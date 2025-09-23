package vn.m2m.service;

import akka.japi.Function;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import models.appjsons.ErrorCodeApp;
import org.springframework.util.StringUtils;
import play.Logger;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;
import play.shaded.ahc.io.netty.util.concurrent.Promise;
import vn.m2m.models.ApiResult;
import vn.m2m.models.HttpPostMultipart;
import vn.m2m.utils.ObjectUtil;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.File;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.CompletionStage;

/**
 * Created by vtk-anhlt166 on 4/2/21.
 */
@Singleton
public class ApiService {
    public Logger.ALogger logger = Logger.of(ApiService.class);

    private WSClient ws;
    @Inject
    public ApiService(WSClient ws){
        this.ws = ws;
    }

    public String getToken(){
        String url = "https://api.iotcloud.com.vn:4438/token";
        String body = "grant_type=client_credentials&client_id=9221f93a-58b6-40c5-8dc5-1bd6ab0a4897&client_secret=90pd2Ot8LZURZtUB8XL69cOdB9";
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .setContentType("application/x-www-form-urlencoded")
                    .setMethod("--insecure")
//                    .post("grant_type=client_credentials&client_id=9221f93a-58b6-40c5-8dc5-1bd6ab0a4897&client_secret=90pd2Ot8LZURZtUB8XL69cOdB9")
                    .post(body)
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("sendApiWithFormUrlencoded");
            apiResult.setSuccess(true);

            String token = (apiResult.getJsonData().get("access_token")!=null) ? apiResult.getJsonData().get("access_token").asText() : "";
            return token;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return "";
        }
    }
    public ApiResult sendApiWithFormUrlencoded(String url, String body){
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .setContentType("application/x-www-form-urlencoded")
                    .setMethod("--insecure")
//                    .post("grant_type=client_credentials&client_id=9221f93a-58b6-40c5-8dc5-1bd6ab0a4897&client_secret=90pd2Ot8LZURZtUB8XL69cOdB9")
                    .post(body)
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("sendApiWithFormUrlencoded");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }
    public ApiResult getWithParams(String url, String token, Map<String, String> params){
        try {
            WSRequest request = ws.url(url);
            if (params != null) {
                Set<String> keys = params.keySet();
                for (String key : keys) {
                    if(!StringUtils.isEmpty(params.get(key))){
                        request.addQueryParameter(key, params.get(key));
                    }
                }
            }
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(60000))
                    .setHeader("Authorization",token)
                    .setMethod("--insecure")
                    .get()
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("get");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }

    public WSResponse getRaw(String url, Map<String, String> params){
        try {
            WSRequest request = ws.url(url);
            if (params != null) {
                Set<String> keys = params.keySet();
                for (String key : keys) {
                    request.addQueryParameter(key, params.get(key));
                }
            }
            CompletionStage<WSResponse> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .setMethod("--insecure")
                    .get();
            WSResponse apiResult = responseCompletionStage.toCompletableFuture().get();

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);

            return null;
        }
    }

    public ApiResult sendApiWithParam(String url, String token){
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .setContentType("application/x-www-form-urlencoded")
                    .setHeader("Authorization",token)
                    .setMethod("--insecure")
//                    .post("grant_type=client_credentials&client_id=9221f93a-58b6-40c5-8dc5-1bd6ab0a4897&client_secret=90pd2Ot8LZURZtUB8XL69cOdB9")
                    .get()
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("sendApiWithFormUrlencoded");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }

    public ApiResult sendApiWithJson(String url, String body){
        JsonNode data = ObjectUtil.jsonStrToJsonNode(body);
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .setContentType("application/json")
                    .setMethod("--insecure")
                    .post(data)
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("sendApiWithJson");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }

    public ApiResult sendPost(String url, String token){
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .setHeader("Authorization",token)
                    .setMethod("--insecure")
                    .post("")
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("sendPost");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }

    public ApiResult sendPostJson(String url, JsonNode body, String token){
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .setContentType("application/json")
                    .setHeader("Authorization",token)
                    .setMethod("--insecure")
                    .post(body)
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("sendPostJson");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }
    public ApiResult sendPostJsonWithoutToken(String url, JsonNode body){
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .setContentType("application/json")
                    .setMethod("--insecure")
                    .post(body)
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("sendPostJson");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }

    public ApiResult sendPutJson(String url, JsonNode body, String token){
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .setContentType("application/json")
                    .setHeader("Authorization",token)
                    .setMethod("--insecure")
                    .put(body)
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("sendPutJson");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }

    public ApiResult sendPostString(String url, String body, String token){
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .setContentType("application/json")
                    .setHeader("Authorization",token)
                    .setMethod("--insecure")
                    .post(body)
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("sendPostJson");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }

    //message
    public ApiResult sendMessage(String url, String body, String deviceToken, String userToken){
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .setContentType("application/json")
                    .setHeader("Authorization",userToken)
                    .setHeader("Token",deviceToken)
                    .setMethod("--insecure")
                    .post(body)
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("sendPostJson");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }

    public ApiResult sendMessageOnOffByJson(String url, String body, String deviceToken, String userToken){
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .setContentType("application/json")
                    .setHeader("Authorization",userToken)
                    .setHeader("Token",deviceToken)
                    .setMethod("--insecure")
                    .post(ObjectUtil.jsonStrToJsonNode(body))
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("sendPostJson");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }

    public ApiResult getListMessageOfDevice(String url, String token, String deviceToken){
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .setContentType("application/json")
                    .setHeader("Authorization",token)
                    .setHeader("Token",deviceToken)
                    .setMethod("--insecure")
                    .get()
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("sendPostJson");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }

    public ApiResult putJson(String url, JsonNode body, String token){
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .setContentType("application/json")
                    .setHeader("Authorization",token)
                    .setMethod("--insecure")
                    .put(body)
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("sendPostJson");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }
    public ApiResult sendPut(String url, String token){
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .setContentType("application/json")
                    .setHeader("Authorization",token)
                    .setMethod("--insecure")
                    .put("")
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("sendPostJson");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }

    public ApiResult getByToken(String url, String token){
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .setHeader("Authorization",token)
                    .setMethod("--insecure")
                    .get()
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("getByToken");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }

    public ApiResult getByUrl(String url){
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .get()
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("getByUrl");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }

    public ApiResult getByUserTokenAndDeviceToken(String url, String userToken, String deviceToken){
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .setHeader("Authorization",userToken)
                    .setHeader("Token",deviceToken)
                    .setMethod("--insecure")
                    .get()
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("getByToken");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }

    public ApiResult deleteByToken(String url, String token){
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .setHeader("Authorization",token)
                    .setMethod("--insecure")
                    .delete()
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("getByToken");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }

    public ApiResult authenIotPlatformByToken(){
        //call api authen -> get token
        String url = "https://api.iotcloud.com.vn:4438/token";
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .setContentType("application/x-www-form-urlencoded")
                    .setMethod("--insecure")
                    .post("grant_type=client_credentials&client_id=9221f93a-58b6-40c5-8dc5-1bd6ab0a4897&client_secret=90pd2Ot8LZURZtUB8XL69cOdB9")
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("get token");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }

    public ApiResult sendApiJson(){
        //call api authen -> get token
        String url = "https://us1.unwiredlabs.com/v2/process.php";
        ArrayList<JsonNode> arrayListCells = new ArrayList<>();
        JsonNode cells = Json.newObject()
                .put("lac", 43300)
                .put("cid", 75430933)
                .put("psc", 0);
        arrayListCells.add(cells);
        ArrayList<String> arrayListWifi = new ArrayList<>();
        JsonNode data = Json.newObject()
                .put("token", "284a3628cddb31")
                .put("radio", "nbiot")
                .put("address", 1)
                .put("mcc", 452)
                .put("mnc", 4)
                .putPOJO("wifi", arrayListWifi)
                .putPOJO("cells", arrayListCells);
        logger.info("sendApiJson :{}", data);
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .setContentType("application/json")
                    .post(data)
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("get token");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }

    public ApiResult getListDeviceByToken(String token){
        //call api authen -> get token
        String url = "http://10.55.121.73:8080/vtag/admin/device/all";
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .setHeader("Authorization","Bearer "+token)
                    .setMethod("--insecure")
                    .get()
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("getListDeviceByToken");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }

    //get all
    public ApiResult getAllDeviceByBackendVtag(){
        //call api authen -> get token
        String url = "http://203.113.138.18:8080/vtag/admin/devices";
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
//                    .setHeader("Authorization","Bearer X1xl5Z2WHnl62ha_tZtPUTNfguTi3HJdXe31V_wFR8I.tvNycDRrWODa0KKgQek5CM86-EXm8_l7cJWI305W0MA")
                    .get()
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("getAllDeviceByBackendVtag");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }

    private ApiResult getApiResult(WSResponse wsResponse){
//        logger.info("wsResponse: {}", wsResponse.getHeaders());
//        logger.info("wsResponse body: {}",wsResponse.getBody());
//        logger.info("wsResponse status: {}",wsResponse.getStatus());
        int responeStatus=wsResponse.getStatus();

        ApiResult apiResult = new ApiResult();

        apiResult.setResultStatus(responeStatus);
        apiResult.setBody(new String(wsResponse.getBodyAsBytes().toArray()));
        try {
            if(!StringUtils.isEmpty(wsResponse.getBody())){
                apiResult.setJsonData(ObjectUtil.jsonStrToJsonNode(new String(wsResponse.getBodyAsBytes().toArray())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (responeStatus==200){
            apiResult.setSuccess(true);
        }else{
            apiResult.setSuccess(false);
        }

        return apiResult;
    }

    public ApiResult sendApiAppWithJson(String url, String appKey, String appSecret, String body){
        JsonNode data = ObjectUtil.jsonStrToJsonNode(body);
        try {
            WSRequest request = ws.url(url);
            CompletionStage<ApiResult> responseCompletionStage = request.setRequestTimeout(Duration.ofMillis(30000))
                    .addHeader("AppKey", appKey)
                    .addHeader("AppSecret", appSecret)
                    .setContentType("application/json")
                    .setMethod("--insecure")
                    .post(data)
                    .thenApply(wsResponse -> getApiResult(wsResponse));
            ApiResult apiResult=responseCompletionStage.toCompletableFuture().get();
            apiResult.setErrorName("sendApiWithJson");
            apiResult.setSuccess(true);

            return apiResult;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:{}", e);
            ApiResult apiResult =new ApiResult();
            apiResult.setSuccess(false);
            apiResult.setErrorName(ErrorCodeApp.UnknowError.getName());

            return apiResult;
        }
    }

    public ApiResult sendFileToInnowayHttpURLConnection(String url, String token, String fileName, File file){
        logger.info("fileName :{}", fileName);
        ApiResult apiResult =new ApiResult();

        try {
            // Set header
            Map<String, String> headers = new HashMap<>();
            headers.put("Authorization", token);
            HttpPostMultipart multipart = new HttpPostMultipart(url, "utf-8", headers);
            // Add form field
//            multipart.addFormField("file_name", fileName);
            multipart.addFormField("ramdomName", "true");
            // Add file
            multipart.addFilePart("file", file, fileName);
            // Print result
            String response = multipart.finish();
            logger.info("response :{}", response);

            apiResult.setSuccess(true);
            apiResult.setJsonData(ObjectUtil.jsonStrToJsonNode(response));

        } catch (Exception e) {
            e.printStackTrace();
            apiResult.setSuccess(false);
        }

        return apiResult;
    }

}
