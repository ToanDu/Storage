package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.ws.*;
import play.mvc.*;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import akka.util.ByteString;
import akka.stream.javadsl.Source;
import javax.inject.Inject;
import java.io.InputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CompletionStage;

@Security.Authenticated(Secured.class)
public class DownloadFileController extends AbstractController {

    private final WSClient ws;

    @Inject
    public DownloadFileController(WSClient ws) {
        this.ws = ws;
    }

    public CompletionStage<Result> downloadFileFromApi(String param) throws Exception {
        User userSession = getUserSession();
//        if(userSession == null){
//            respone.setIssuccess(false);
//            respone.setResultString(getMessages().at("noti.sessionTimeOut"));
//            return ok(Json.toJson(respone));
//        }

        JsonNode jsonGroup = request().body().asJson();
        //String param = jsonGroup.get("param").asText();

        String token = "Bearer " + userSession.getToken();
        String paramDecode = URLDecoder.decode(param, StandardCharsets.UTF_8.toString());
        String paramFinal = URLDecoder.decode(paramDecode, StandardCharsets.UTF_8.toString());

        String url = appfileConfig.urlBackendIotTelco2 + paramFinal;
        logger.info("url:{}", url);
        return ws.url(url)
                .addHeader("Authorization", token)
                .setRequestTimeout(java.time.Duration.ofSeconds(30))
                .stream()
                .thenApply(response -> {
                    if (response.getStatus() != 200) {
                        return Results.status(response.getStatus(), "Không thể tải file");
                    }
                    logger.info("response:{}", response);

                    Source<ByteString, ?> stream = response.getBodyAsSource();
                    //String contentType = response.getHeaders().get("Content-Type").stream().findFirst().orElse("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                    logger.info("header:{}", response.getHeaders());
                    logger.info("disposition:{}", response.getHeaders().get("Content-Disposition"));
                    List<String> dispositions = response.getHeaders().get("Content-Disposition");
                    String disposition = (dispositions != null && !dispositions.isEmpty())
                            ? dispositions.get(0)
                            : "attachment; filename=download.xlsx";
                    //String disposition = response.getHeaders().get("Content-Disposition").stream().findFirst().orElse("attachment; filename=download.xlsx");

                    return Results.ok().chunked(stream)
                            .as("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
                            .withHeader("Content-Disposition", disposition);
                });
    }
}

