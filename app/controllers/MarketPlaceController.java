package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.apache.commons.lang.StringUtils;
import play.libs.Json;
import play.mvc.Result;
import vn.m2m.common.models.User;
import vn.m2m.iot.dao.GroupProductDAO;
import vn.m2m.iot.dao.ProductContactDAO;
import vn.m2m.iot.dao.ProductDAO;
import vn.m2m.iot.models.GroupProduct;
import vn.m2m.iot.models.Product;
import vn.m2m.iot.models.ProductContact;
import vn.m2m.utils.StringUtil;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vtk-anhlt166 on 8/5/22.
 */
public class MarketPlaceController extends AbstractController {
    @Inject
    public ProductDAO productDAO;

    @Inject
    public GroupProductDAO groupProductDAO;

    @Inject
    public ProductContactDAO productContactDAO;

    public Result marketPlace() {
        User userSession = getUserSession();

        return ok(views.html.amarket.marketPlace.all.MarketPlaceAll.render(userSession));
    }

    public Result marketPlaceSolution() {
        User userSession = getUserSession();

        return ok(views.html.amarket.marketPlace.solution.MarketPlaceSolution.render(userSession));
    }

    public Result marketPlaceDevice() {
        User userSession = getUserSession();

        return ok(views.html.amarket.marketPlace.device.MarketPlaceDevice.render(userSession));
    }

    public Result detailProduct(String id) {
        User userSession = getUserSession();

        Product product = productDAO.getByKey(id);
        if(product == null){
            flash("failed",getMessages().at("Không tìm thấy sản phẩm"));
            return redirect(routes.MarketPlaceController.marketPlace());
        }

        return ok(views.html.amarket.marketPlace.detail.MarketPlaceDetail.render(userSession, id, product.getGroupType()));
    }

    public Result getAllProduct() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String filterKey = jsonGroup.get("filterKey").asText();
        String sortKey = jsonGroup.get("sortKey").asText();

        String groupProduct = jsonGroup.get("groupProduct").asText();
        List<String> listIdGroupProduct = new ArrayList<String>();
        if(!StringUtils.isEmpty(groupProduct)){
            listIdGroupProduct = Arrays.asList(groupProduct.split(","));
        }

        List<Product> productList = productDAO.getAllProductMarket(filterKey, sortKey, listIdGroupProduct);
        logger.info("productList :{}", Json.toJson(productList));
        respone.setContent(productList);

        return ok(Json.toJson(respone));
    }

    public Result getAllSolution() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String name = jsonGroup.get("name").asText();
        String groupId = jsonGroup.get("groupId").asText();

        List<Product> productList = new ArrayList<>();
        if(StringUtils.isEmpty(groupId)){
            productList = productDAO.getAllSolution(8, name);
        } else {
            productList = productDAO.getAllSolution(8, name, groupId);
        }
        logger.info("productList :{}", Json.toJson(productList));
        respone.setContent(productList);

        return ok(Json.toJson(respone));
    }

    public Result getAllDevice() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String name = jsonGroup.get("name").asText();
        String groupId = jsonGroup.get("groupId").asText();

        List<Product> productList = new ArrayList<>();
        if(StringUtils.isEmpty(groupId)){
            productList = productDAO.getAllDevice(8, name);
        } else {
            productList = productDAO.getAllDevice(8, name, groupId);
        }

        logger.info("productList :{}", Json.toJson(productList));
        respone.setContent(productList);

        return ok(Json.toJson(respone));
    }

    public Result getProductMarket() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String filterKey = jsonGroup.get("filterKey").asText();
        String sortKey = jsonGroup.get("sortKey").asText();
        int groupType = jsonGroup.get("groupType").asInt();
        String name = jsonGroup.get("name").asText();

        String groupProduct = jsonGroup.get("groupProduct").asText();
        List<String> listIdGroupProduct = new ArrayList<String>();
        if(!StringUtils.isEmpty(groupProduct)){
            listIdGroupProduct = Arrays.asList(groupProduct.split(","));
        }

        List<Product> productList = productDAO.getProductMarket(filterKey, sortKey, listIdGroupProduct, groupType, name);
        logger.info("productList :{}", Json.toJson(productList));
        respone.setContent(productList);

        return ok(Json.toJson(respone));
    }

    public Result getAllGroupProduct() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        List<GroupProduct> groupProductList = groupProductDAO.getAllGroupProduct();

        respone.setContent(groupProductList);
        respone.setResultString(getMessages().at("noti.Getsuccess"));
        return ok(Json.toJson(respone));
    }

    public Result getAllGroupSolution() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        List<GroupProduct> groupProductList = groupProductDAO.getAllGroupSolution();

        if(groupProductList.size() > 0){
            for(GroupProduct groupProduct: groupProductList){
                long countProduct = productDAO.countProductInGroup(groupProduct.getId());
                groupProduct.setCountProduct(countProduct);
            }
        }

        respone.setContent(groupProductList);
        respone.setResultString(getMessages().at("noti.Getsuccess"));
        return ok(Json.toJson(respone));
    }

    public Result getAllGroupDevice() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        List<GroupProduct> groupProductList = groupProductDAO.getAllGroupDevice();

        if(groupProductList.size() > 0){
            for(GroupProduct groupProduct: groupProductList){
                long countProduct = productDAO.countProductInGroup(groupProduct.getId());
                groupProduct.setCountProduct(countProduct);
            }
        }

        respone.setContent(groupProductList);
        respone.setResultString(getMessages().at("noti.Getsuccess"));
        return ok(Json.toJson(respone));
    }

    public Result getDetailProductWithId() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id").asText();

        Product product = productDAO.getByKey(id);
        if(product == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Không tìm thấy sản phẩm"));
            return ok(Json.toJson(respone));
        }

        product.setCountView(product.getCountView()+1);
        productDAO.save(product);

        respone.setContent(product);
        return ok(Json.toJson(respone));
    }

    public Result getSameProduct() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id").asText();

        Product product = productDAO.getByKey(id);
        if(product == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Không tìm thấy sản phẩm"));
            return ok(Json.toJson(respone));
        }

        List<Product> productList = new ArrayList<>();
        if(product.getGroupType() == GroupProduct.Types.solution.getCode()){
            productList = productDAO.getAllSolution(5, "");
        } else {
            productList = productDAO.getAllDevice(5, "");
        }

        respone.setContent(productList);
        return ok(Json.toJson(respone));
    }


}
