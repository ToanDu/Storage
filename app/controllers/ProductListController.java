package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.apache.commons.lang.StringUtils;
import play.data.Form;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.common.models.forms.SearchFilter;
import vn.m2m.common.models.forms.SearchFilterForm;
import vn.m2m.common.models.forms.SearchObjectData;
import vn.m2m.iot.dao.GroupProductDAO;
import vn.m2m.iot.dao.ProductDAO;
import vn.m2m.iot.form.ProductForm;
import vn.m2m.iot.models.GroupProduct;
import vn.m2m.iot.models.Product;
import vn.m2m.models.ApiResult;
import vn.m2m.utils.DateUtil;
import vn.m2m.utils.ImageUtil;
import vn.m2m.utils.StringUtil;
import vn.m2m.utils.UserHelper;

import javax.inject.Inject;
import java.io.File;
import java.util.*;
import java.util.concurrent.CompletableFuture;

import static vn.m2m.utils.SearchUtil.*;
import static vn.m2m.utils.SearchUtil.SEARCH_INT_TYPE;
import static vn.m2m.utils.SearchUtil.SEARCH_STRING_TYPE;

/**
 * Created by vtk-anhlt166 on 8/4/22.
 */
@Security.Authenticated(Secured.class)
public class ProductListController  extends AbstractController {
    @Inject
    public ProductDAO productDAO;
    @Inject
    public GroupProductDAO groupProductDAO;

    public Result productList(String id) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        if (userSession.getSystemRole() != User.SystemRole.SYSTEM_ADMIN.getCode()) {
            if(!userSession.getId().equals(id)){
                flash("failed", getMessages().at("noti.notPermit"));
                return redirect(controllers.routes.Application.login());
            }
        }

        return ok(views.html.amarket.product.ProductList.render(userSession, id));
    }

    public Result getProductByUser() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id").asText();
        String filterKey = jsonGroup.get("filterKey").asText();
        String sortKey = jsonGroup.get("sortKey").asText();

        List<Product> productList = productDAO.getProductByUser(id, filterKey, sortKey);
//        logger.info("productList :{}", Json.toJson(productList));
        respone.setContent(productList);

        return ok(Json.toJson(respone));
    }

    public Result createProduct() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        Form<ProductForm> formRequest = formFactory.form(ProductForm.class).bindFromRequest();
        if (formRequest.hasErrors()) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("form.error"));
            return ok(Json.toJson(respone));
        }

        ProductForm productForm = formRequest.get();
        logger.info("ProductForm :{}", Json.toJson(productForm));

        String code = productForm.getCode();
        String name = productForm.getName();
        double price = productForm.getPrice();
        String groupId = productForm.getGroupId();
        boolean statusShow = productForm.isStatusShow();
        String info = productForm.getInfo();
        String content = productForm.getContent();
        String feature = productForm.getFeature();
        String linkDocs = productForm.getLinkDocs();
        String supportPersion = productForm.getSupportPersion();
        String solution = productForm.getSolution();

        Product product = new Product();
        product.setUserId(userSession.getId());
        product.setUserName(userSession.getUsername());
        product.setCode(code);
        product.setName(name);
        product.setNameLowerCase(name.toLowerCase());
        product.setInfo(info);
        product.setContent(content);
        product.setFeature(feature);
        product.setLinkDocs(linkDocs);
        product.setSupportPersion(supportPersion);
        product.setSolution(solution);
        product.setStatusShow(statusShow);
        product.setPrice(price);

        GroupProduct groupProduct = groupProductDAO.getByKey(groupId);
        if(groupProduct != null){
            product.setGroupId(groupProduct.getId());
            product.setGroupType(groupProduct.getType());
            product.setGroupName(groupProduct.getName());
            product.setStatusGroup(groupProduct.isStatus());
        }

        Http.MultipartFormData.FilePart fileData = productForm.getFileData();
        if(fileData != null){
            String fileName = fileData.getFilename();
            File file = (File) fileData.getFile();
            String imageName = UserHelper.generateUniqueFilename(fileName);
            logger.info("imageName :{}", imageName);

            try {
                ImageUtil.writeAvatarToDisk(imageName, appfileConfig.contentFolderImage, file);
                product.setImgName(imageName);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        Http.MultipartFormData.FilePart fileImage_1 = productForm.getImage_1();
        if(fileImage_1 != null){
            String nameImg_1 = fileImage_1.getFilename();
            File file_1 = (File) fileImage_1.getFile();
            String imageName_1 = UserHelper.generateUniqueFilename(nameImg_1);
            logger.info("imageName_1 :{}", imageName_1);

            try {
                ImageUtil.writeAvatarToDisk(imageName_1, appfileConfig.contentFolderImage, file_1);
                product.setImage_1(imageName_1);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        Http.MultipartFormData.FilePart fileImage_2 = productForm.getImage_2();
        if(fileImage_2 != null){
            String nameImg_2 = fileImage_2.getFilename();
            File file_2 = (File) fileImage_2.getFile();
            String imageName_2 = UserHelper.generateUniqueFilename(nameImg_2);
            logger.info("fileImage_2 :{}", imageName_2);

            try {
                ImageUtil.writeAvatarToDisk(imageName_2, appfileConfig.contentFolderImage, file_2);
                product.setImage_2(imageName_2);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        Http.MultipartFormData.FilePart fileImage_3 = productForm.getImage_3();
        if(fileImage_3 != null){
            String nameImg_3 = fileImage_3.getFilename();
            File file_3 = (File) fileImage_3.getFile();
            String imageName_3 = UserHelper.generateUniqueFilename(nameImg_3);
            logger.info("imageName_3 :{}", imageName_3);

            try {
                ImageUtil.writeAvatarToDisk(imageName_3, appfileConfig.contentFolderImage, file_3);
                product.setImage_3(imageName_3);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        Http.MultipartFormData.FilePart fileImage_4 = productForm.getImage_4();
        if(fileImage_4 != null){
            String nameImg_4 = fileImage_4.getFilename();
            File file_4 = (File) fileImage_4.getFile();
            String imageName_4 = UserHelper.generateUniqueFilename(nameImg_4);
            logger.info("imageName_4 :{}", imageName_4);

            try {
                ImageUtil.writeAvatarToDisk(imageName_4, appfileConfig.contentFolderImage, file_4);
                product.setImage_4(imageName_4);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        Http.MultipartFormData.FilePart fileImage_5 = productForm.getImage_5();
        if(fileImage_5 != null){
            String nameImg_5 = fileImage_5.getFilename();
            File file_5 = (File) fileImage_5.getFile();
            String imageName_5 = UserHelper.generateUniqueFilename(nameImg_5);
            logger.info("imageName_5 :{}", imageName_5);

            try {
                ImageUtil.writeAvatarToDisk(imageName_5, appfileConfig.contentFolderImage, file_5);
                product.setImage_5(imageName_5);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        productDAO.save(product);

        respone.setResultString(getMessages().at("noti.Addsuccess"));
        return ok(Json.toJson(respone));
    }

    public Result getProductById() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id = (jsonGroup.get("id") != null) ? jsonGroup.get("id").asText() : "";

        Product product = productDAO.getByKey(id);
        if(product == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Không tìm thấy sản phẩm"));
            return ok(Json.toJson(respone));
        }

        respone.setContent(product);
        return ok(Json.toJson(respone));
    }

    public Result editProduct() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        Form<ProductForm> formRequest = formFactory.form(ProductForm.class).bindFromRequest();
        if (formRequest.hasErrors()) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("form.error"));
            return ok(Json.toJson(respone));
        }

        ProductForm productForm = formRequest.get();
        logger.info("ProductForm :{}", Json.toJson(productForm));
        String id = productForm.getId();
        logger.info("id ProductForm :{}", id);
        String code = productForm.getCode();
        String name = productForm.getName();
        double price = productForm.getPrice();
        String groupId = productForm.getGroupId();
        boolean statusShow = productForm.isStatusShow();
        String info = productForm.getInfo();
        String content = productForm.getContent();
        String feature = productForm.getFeature();
        String linkDocs = productForm.getLinkDocs();
        String supportPersion = productForm.getSupportPersion();
        String solution = productForm.getSolution();

        Product product = productDAO.getByKey(id);
        if(product == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Không tìm thấy sản phẩm"));
            return ok(Json.toJson(respone));
        }

        product.setCode(code);
        product.setName(name);
        product.setNameLowerCase(name.toLowerCase());
        product.setPrice(price);

        GroupProduct groupProduct = groupProductDAO.getByKey(groupId);
        if(groupProduct != null){
            product.setGroupId(groupProduct.getId());
            product.setGroupType(groupProduct.getType());
            product.setGroupName(groupProduct.getName());
        }

        product.setStatusShow(statusShow);
        product.setInfo(info);
        product.setContent(content);
        product.setFeature(feature);
        product.setLinkDocs(linkDocs);
        product.setSupportPersion(supportPersion);
        product.setSolution(solution);
        product.setUpdateDate(DateUtil.now());

        Boolean isChangeImg = productForm.getChangeImg();
        String imgOld = productForm.getImgOld();
        Http.MultipartFormData.FilePart fileData = productForm.getFileData();
        if(isChangeImg){
            if(fileData != null){
                String fileName = productForm.getFileName();
                File file = (File) fileData.getFile();
                String imageName = UserHelper.generateUniqueFilename(fileName);
                logger.info("imageName :{}", imageName);

                try {
                    ImageUtil.writeAvatarToDisk(imageName, appfileConfig.contentFolderImage, file);
                    product.setImgName(imageName);

                    java.util.concurrent.CompletionStage<Boolean> promiseOfDelImg = CompletableFuture.supplyAsync(
                            () -> ImageUtil.delImage(imgOld, appfileConfig.contentFolderImage));
                    logger.debug("promiseOfDelImg = {}", promiseOfDelImg);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        Boolean isChangeImg1 = productForm.getChangeImg1();
        if(isChangeImg1){
            String imgOld1 = productForm.getImgOld1();
            Http.MultipartFormData.FilePart fileImage_1 = productForm.getImage_1();
            if(fileImage_1 != null){
                String nameImg_1 = fileImage_1.getFilename();
                File file_1 = (File) fileImage_1.getFile();
                String imageName_1 = UserHelper.generateUniqueFilename(nameImg_1);

                try {
                    ImageUtil.writeAvatarToDisk(imageName_1, appfileConfig.contentFolderImage, file_1);
                    product.setImage_1(imageName_1);

                    if(!StringUtils.isEmpty(imgOld1)){
                        java.util.concurrent.CompletionStage<Boolean> promiseOfDelImg1 = CompletableFuture.supplyAsync(
                                () -> ImageUtil.delImage(imgOld1, appfileConfig.contentFolderImage));
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            } else {
                product.setImage_1(null);
                if(!StringUtils.isEmpty(imgOld1)){
                    java.util.concurrent.CompletionStage<Boolean> promiseOfDelImg1 = CompletableFuture.supplyAsync(
                            () -> ImageUtil.delImage(imgOld1, appfileConfig.contentFolderImage));
                }
            }
        }

        Boolean isChangeImg2 = productForm.getChangeImg2();
        if(isChangeImg2){
            String imgOld2 = productForm.getImgOld2();
            Http.MultipartFormData.FilePart fileImage_2 = productForm.getImage_2();
            if(fileImage_2 != null){
                String nameImg_2 = fileImage_2.getFilename();
                File file_2 = (File) fileImage_2.getFile();
                String imageName_2 = UserHelper.generateUniqueFilename(nameImg_2);

                try {
                    ImageUtil.writeAvatarToDisk(imageName_2, appfileConfig.contentFolderImage, file_2);
                    product.setImage_2(imageName_2);

                    if(!StringUtils.isEmpty(imgOld2)){
                        java.util.concurrent.CompletionStage<Boolean> promiseOfDelImg2 = CompletableFuture.supplyAsync(
                                () -> ImageUtil.delImage(imgOld2, appfileConfig.contentFolderImage));
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            } else {
                product.setImage_2(null);
                if(!StringUtils.isEmpty(imgOld2)){
                    java.util.concurrent.CompletionStage<Boolean> promiseOfDelImg2 = CompletableFuture.supplyAsync(
                            () -> ImageUtil.delImage(imgOld2, appfileConfig.contentFolderImage));
                }
            }
        }

        Boolean isChangeImg3 = productForm.getChangeImg3();
        if(isChangeImg3){
            String imgOld3 = productForm.getImgOld3();
            Http.MultipartFormData.FilePart fileImage_3 = productForm.getImage_3();
            if(fileImage_3 != null){
                String nameImg_3 = fileImage_3.getFilename();
                File file_3 = (File) fileImage_3.getFile();
                String imageName_3 = UserHelper.generateUniqueFilename(nameImg_3);

                try {
                    ImageUtil.writeAvatarToDisk(imageName_3, appfileConfig.contentFolderImage, file_3);
                    product.setImage_3(imageName_3);

                    if(!StringUtils.isEmpty(imgOld3)){
                        java.util.concurrent.CompletionStage<Boolean> promiseOfDelImg3 = CompletableFuture.supplyAsync(
                                () -> ImageUtil.delImage(imgOld3, appfileConfig.contentFolderImage));
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            } else {
                product.setImage_3(null);
                if(!StringUtils.isEmpty(imgOld3)){
                    java.util.concurrent.CompletionStage<Boolean> promiseOfDelImg3 = CompletableFuture.supplyAsync(
                            () -> ImageUtil.delImage(imgOld3, appfileConfig.contentFolderImage));
                }
            }
        }

        Boolean isChangeImg4 = productForm.getChangeImg4();
        if(isChangeImg4){
            String imgOld4 = productForm.getImgOld4();
            Http.MultipartFormData.FilePart fileImage_4 = productForm.getImage_4();
            if(fileImage_4 != null){
                String nameImg_4 = fileImage_4.getFilename();
                File file_4 = (File) fileImage_4.getFile();
                String imageName_4 = UserHelper.generateUniqueFilename(nameImg_4);

                try {
                    ImageUtil.writeAvatarToDisk(imageName_4, appfileConfig.contentFolderImage, file_4);
                    product.setImage_4(imageName_4);

                    if(!StringUtils.isEmpty(imgOld4)){
                        java.util.concurrent.CompletionStage<Boolean> promiseOfDelImg4 = CompletableFuture.supplyAsync(
                                () -> ImageUtil.delImage(imgOld4, appfileConfig.contentFolderImage));
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            } else {
                product.setImage_4(null);
                if(!StringUtils.isEmpty(imgOld4)){
                    java.util.concurrent.CompletionStage<Boolean> promiseOfDelImg4 = CompletableFuture.supplyAsync(
                            () -> ImageUtil.delImage(imgOld4, appfileConfig.contentFolderImage));
                }
            }
        }

        Boolean isChangeImg5 = productForm.getChangeImg5();
        if(isChangeImg5){
            String imgOld5 = productForm.getImgOld5();
            Http.MultipartFormData.FilePart fileImage_5 = productForm.getImage_5();
            if(fileImage_5 != null){
                String nameImg_5 = fileImage_5.getFilename();
                File file_5 = (File) fileImage_5.getFile();
                String imageName_5 = UserHelper.generateUniqueFilename(nameImg_5);

                try {
                    ImageUtil.writeAvatarToDisk(imageName_5, appfileConfig.contentFolderImage, file_5);
                    product.setImage_5(imageName_5);

                    if(!StringUtils.isEmpty(imgOld5)){
                        java.util.concurrent.CompletionStage<Boolean> promiseOfDelImg5 = CompletableFuture.supplyAsync(
                                () -> ImageUtil.delImage(imgOld5, appfileConfig.contentFolderImage));
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            } else {
                product.setImage_5(null);
                if(!StringUtils.isEmpty(imgOld5)){
                    java.util.concurrent.CompletionStage<Boolean> promiseOfDelImg5 = CompletableFuture.supplyAsync(
                            () -> ImageUtil.delImage(imgOld5, appfileConfig.contentFolderImage));
                }
            }
        }

        productDAO.save(product);

        respone.setResultString(getMessages().at("noti.Addsuccess"));
        return ok(Json.toJson(respone));
    }

    public Result deleteProduct() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id = (jsonGroup.get("id") != null) ? jsonGroup.get("id").asText() : "";

        Product product = productDAO.getByKey(id);
        if(product == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Không tìm thấy sản phẩm"));
            return ok(Json.toJson(respone));
        }

        productDAO.deleteByKey(id);

        respone.setResultString(getMessages().at("noti.Deletesuccess"));
        return ok(Json.toJson(respone));
    }

    public Result requestApproveProduct() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id = (jsonGroup.get("id") != null) ? jsonGroup.get("id").asText() : "";

        Product product = productDAO.getByKey(id);
        if(product == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Không tìm thấy sản phẩm"));
            return ok(Json.toJson(respone));
        }

         if(product.getStatusApprove() == 1){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Sản phẩm đã được duyệt"));
            return ok(Json.toJson(respone));
        } else {
             if(product.getStatusApprove() != 3){
                 product.setStatusApprove(3);
                 productDAO.save(product);

                 respone.setResultString(getMessages().at("Gửi yêu cầu thành công"));
                 return ok(Json.toJson(respone));
             } else {
                 respone.setIssuccess(false);
                 respone.setErrorString(getMessages().at("Sản phẩm đang chờ duyệt"));
                 return ok(Json.toJson(respone));
             }
        }
    }


    //TODO Admin
    public Result manageProductList(){
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        if (userSession.getSystemRole() != User.SystemRole.SYSTEM_ADMIN.getCode()) {
            flash("failed", getMessages().at("noti.notPermit"));
            return redirect(controllers.routes.Application.login());
        }

        SearchObjectData searchObjectData = new SearchObjectData();
        SearchFilter searchFilter = new SearchFilter();

        List<String> searchArray = new ArrayList<String>();
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("code");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("name");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("username");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("groupName");
        searchArray.add(SEARCH_INT_TYPE);
        searchArray.add("statusApprove");
        searchArray.add(SEARCH_DATE_TYPE);
        searchArray.add("createDate");

        searchFilter = InitConditionListData(searchArray,"createDate"); // last field is sort field name
        searchFilter.setIsDesc(true);

        List<Object> objectList = new ArrayList<Object>();
        objectList =(List<Object>)(List) productDAO.searchAndQuery(searchFilter);

        long countTotal = productDAO.countOnQuery(searchFilter);
        searchObjectData = PagingDataAfterSearch(searchFilter, countTotal);
        searchObjectData.setObjectList(objectList);

        return ok(views.html.admin.manageProduct.ManageProductList.render(userSession, searchObjectData, searchArray));
    }

    public Result manageProductFilterList() {
        Form<SearchFilterForm> searchGenericFormForm = formFactory.form(SearchFilterForm.class);
        SearchFilterForm searchFilterForm = searchGenericFormForm.bindFromRequest().get();

        return manageProductFilterList(searchFilterForm);
    }

    public Result manageProductFilterList(SearchFilterForm searchFilterForm) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        if (userSession.getSystemRole() != User.SystemRole.SYSTEM_ADMIN.getCode()) {
            flash("failed", getMessages().at("noti.notPermit"));
            return redirect(controllers.routes.Application.login());
        }

        List<String> searchArray = new ArrayList<String>();
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("code");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("name");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("username");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("groupName");
        searchArray.add(SEARCH_INT_TYPE);
        searchArray.add("statusApprove");
        searchArray.add(SEARCH_DATE_TYPE);
        searchArray.add("createDate");

        SearchFilter searchFilter = new SearchFilter();
        searchFilter = InitConditionListDataPOST(searchArray, searchFilterForm);
        searchFilter.setIsDesc(true);
        searchFilter.setSortFieldName("createDate");
        logger.info("searchFilter :{}", Json.toJson(searchFilter));

        List<Object> objectList = new ArrayList<Object>();
        objectList =(List<Object>)(List) productDAO.searchAndQuery(searchFilter);

        long countTotal = productDAO.countOnQuery(searchFilter);
        SearchObjectData searchObjectData = new SearchObjectData();
        searchObjectData = PagingDataAfterSearchPOST(searchFilter, searchFilterForm,countTotal);
        searchObjectData.setObjectList(objectList);

        searchArray = new ArrayList<String>();
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("code");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("name");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("username");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("groupName");
        searchArray.add(SEARCH_INT_TYPE);
        searchArray.add("statusApprove");
        searchArray.add(SEARCH_DATE_TYPE);
        searchArray.add("createDate");

        return ok(views.html.admin.manageProduct.ManageProductList.render(userSession, searchObjectData, searchArray));

    }

    public Result changeStatusProduct() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        if (userSession.getSystemRole() != User.SystemRole.SYSTEM_ADMIN.getCode()) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.notPermit"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String id = (jsonGroup.get("id") != null) ? jsonGroup.get("id").asText() : "";
        int statusApprove = jsonGroup.get("statusApprove").asInt();
        String contentApprove = (jsonGroup.get("contentApprove") != null) ? jsonGroup.get("contentApprove").asText() : "";

        Product product = productDAO.getByKey(id);
        if(product == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Không tìm thấy sản phẩm"));
            return ok(Json.toJson(respone));
        }

        product.setStatusApprove(statusApprove);
        product.setContentApprove(contentApprove);
        productDAO.save(product);

        respone.setResultString(getMessages().at("noti.Updatesuccess"));
        return ok(Json.toJson(respone));
    }
}
