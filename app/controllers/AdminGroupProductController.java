package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.GroupProductDAO;
import vn.m2m.iot.dao.ProductDAO;
import vn.m2m.iot.models.GroupProduct;
import vn.m2m.iot.models.Product;
import vn.m2m.utils.ObjectUtil;
import vn.m2m.utils.StringUtil;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vtk-anhlt166 on 8/4/22.
 */
@Security.Authenticated(Secured.class)
public class AdminGroupProductController extends AbstractController {
    @Inject
    public GroupProductDAO groupProductDAO;
    @Inject
    public ProductDAO productDAO;

    public Result groupProductList() {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        if (userSession.getSystemRole() != User.SystemRole.SYSTEM_ADMIN.getCode()) {
            flash("failed", getMessages().at("noti.notPermit"));
            return redirect(controllers.routes.Application.login());
        }

        return ok(views.html.admin.groupProduct.GroupProductList.render(userSession));
    }

    public Result getListGroupProduct() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        List<GroupProduct> groupProductList = groupProductDAO.getAll();

        respone.setContent(groupProductList);
        respone.setResultString(getMessages().at("noti.Getsuccess"));
        return ok(Json.toJson(respone));
    }

    public Result addGroupProduct() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        logger.info("jsonGroup :{}", jsonGroup);
        String code = jsonGroup.get("code").asText().trim();
        String name = jsonGroup.get("name").asText().trim();
        int type = jsonGroup.get("type").asInt();
        boolean status = jsonGroup.get("status").asBoolean();

        if(StringUtils.isEmpty(code) || StringUtils.isEmpty(code)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Bạn chưa điền đủ thông tin"));
            return ok(Json.toJson(respone));
        }

        GroupProduct groupProduct = new GroupProduct();
        groupProduct.setCode(code);
        groupProduct.setName(name);
        groupProduct.setType(type);
        groupProduct.setStatus(status);
        groupProductDAO.save(groupProduct);

        respone.setResultString(getMessages().at("noti.Addsuccess"));
        return ok(Json.toJson(respone));
    }

    public Result deleteGroupProduct() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        logger.info("jsonGroup :{}", jsonGroup);
        String id = (jsonGroup.get("id") != null) ? jsonGroup.get("id").asText() : "";

        GroupProduct groupProduct = groupProductDAO.getByKey(id);
        if(groupProduct == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Không tìm thấy nhóm sản phẩm"));
            return ok(Json.toJson(respone));
        }

        groupProductDAO.deleteByKey(id);

        respone.setResultString(getMessages().at("noti.Deletesuccess"));
        return ok(Json.toJson(respone));
    }

    public Result editGroupProduct() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        logger.info("jsonGroup :{}", jsonGroup);
        String id = jsonGroup.get("id").asText();
        String code = jsonGroup.get("code").asText().trim();
        String name = jsonGroup.get("name").asText().trim();
        int type = jsonGroup.get("type").asInt();
        boolean status = jsonGroup.get("status").asBoolean();

        if(StringUtils.isEmpty(code) || StringUtils.isEmpty(code)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Bạn chưa điền đủ thông tin"));
            return ok(Json.toJson(respone));
        }

        GroupProduct groupProduct = groupProductDAO.getByKey(id);
        if(groupProduct == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Không tìm thấy nhóm sản phẩm"));
            return ok(Json.toJson(respone));
        }

        groupProduct.setCode(code);
        groupProduct.setName(name);
        groupProduct.setType(type);
        groupProduct.setStatus(status);
        groupProductDAO.save(groupProduct);

        List<Product> productList = productDAO.getAllProductInGroup(id);
        logger.info("productList : {}", productList.size());
        if(productList.size() > 0){
            for(Product product : productList){
                product.setStatusGroup(status);
                productDAO.save(product);
            }
        }

        respone.setResultString(getMessages().at("noti.Updatesuccess"));
        return ok(Json.toJson(respone));
    }
}
