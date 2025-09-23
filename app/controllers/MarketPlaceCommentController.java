package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import play.libs.Json;
import play.mvc.Result;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.ProductCommentDAO;
import vn.m2m.iot.models.ProductComment;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by vtk-anhlt166 on 8/16/22.
 */
public class MarketPlaceCommentController extends AbstractController {
    @Inject
    public ProductCommentDAO productCommentDAO;

    public Result commentWithProductId() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id").asText();
        String name = jsonGroup.get("name").asText();
        String email = jsonGroup.get("email").asText();
        String content = jsonGroup.get("content").asText();
        String parent = jsonGroup.get("parent").asText();

        ProductComment productComment = new ProductComment();
        productComment.setProductId(id);
        productComment.setName(name);
        productComment.setEmail(email);
        productComment.setContent(content);
        productComment.setParent(parent);

        if(userSession == null){
            productComment.setCreateByGuest(true);
        } else {
            productComment.setUsername(userSession.getUsername());
            if(userSession.getRole() == User.SystemRole.SYSTEM_ADMIN.getCode()){
                productComment.setCreateByAdmin(true);
            } else {
                productComment.setCreateByUser(true);
            }
        }
        productCommentDAO.save(productComment);

        respone.setContent(productComment);
        respone.setResultString(getMessages().at("Gửi bình luận thành công"));
        return ok(Json.toJson(respone));
    }

    public Result getListCommentProduct() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id").asText();

        List<ProductComment> productCommentList = productCommentDAO.getCommentByProductId(id);

        respone.setContent(productCommentList);
        return ok(Json.toJson(respone));
    }
}
