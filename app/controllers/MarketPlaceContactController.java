package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.ajaxjsons.AbstractAjaxJsonModel;
import org.apache.commons.lang.StringUtils;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import services.MailerService;
import vn.m2m.common.models.User;
import vn.m2m.common.models.forms.SearchFilter;
import vn.m2m.common.models.forms.SearchFilterForm;
import vn.m2m.common.models.forms.SearchObjectData;
import vn.m2m.iot.dao.ProductContactDAO;
import vn.m2m.iot.dao.ProductDAO;
import vn.m2m.iot.models.Product;
import vn.m2m.iot.models.ProductContact;
import vn.m2m.utils.DateUtil;
import vn.m2m.utils.StringUtil;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static vn.m2m.utils.SearchUtil.*;

/**
 * Created by vtk-anhlt166 on 8/15/22.
 */
public class MarketPlaceContactController extends AbstractController {
    @Inject
    public ProductContactDAO productContactDAO;
    @Inject
    public ProductDAO productDAO;
    @Inject
    private MailerService mailerService;

    public Result productContactList(){
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
        searchArray.add("name");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("phone");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("email");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("company");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("productName");
        searchArray.add(SEARCH_BOOLEAN_TYPE);
        searchArray.add("status");
        searchArray.add(SEARCH_DATE_TYPE);
        searchArray.add("createDate");

        searchFilter = InitConditionListData(searchArray,"createDate"); // last field is sort field name
        searchFilter.setIsDesc(true);

        List<Object> objectList = new ArrayList<Object>();
        objectList =(List<Object>)(List) productContactDAO.searchAndQuery(searchFilter);

        long countTotal = productContactDAO.countOnQuery(searchFilter);
        searchObjectData = PagingDataAfterSearch(searchFilter, countTotal);
        searchObjectData.setObjectList(objectList);

        return ok(views.html.admin.contact.MarketPlaceContact.render(userSession, searchObjectData, searchArray));
    }

    public Result productContactFilterList() {
        Form<SearchFilterForm> searchGenericFormForm = formFactory.form(SearchFilterForm.class);
        SearchFilterForm searchFilterForm = searchGenericFormForm.bindFromRequest().get();

        return productContactFilterList(searchFilterForm);
    }

    public Result productContactFilterList(SearchFilterForm searchFilterForm) {
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
        searchArray.add("name");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("phone");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("email");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("company");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("productName");
        searchArray.add(SEARCH_BOOLEAN_TYPE);
        searchArray.add("status");
        searchArray.add(SEARCH_DATE_TYPE);
        searchArray.add("createDate");

        SearchFilter searchFilter = new SearchFilter();
        searchFilter = InitConditionListDataPOST(searchArray, searchFilterForm);
        searchFilter.setIsDesc(true);
        searchFilter.setSortFieldName("createDate");
        logger.info("searchFilter :{}", Json.toJson(searchFilter));

        List<Object> objectList = new ArrayList<Object>();
        objectList =(List<Object>)(List) productContactDAO.searchAndQuery(searchFilter);

        long countTotal = productContactDAO.countOnQuery(searchFilter);
        SearchObjectData searchObjectData = new SearchObjectData();
        searchObjectData = PagingDataAfterSearchPOST(searchFilter, searchFilterForm,countTotal);
        searchObjectData.setObjectList(objectList);

        searchArray = new ArrayList<String>();
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("name");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("phone");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("email");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("company");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("productName");
        searchArray.add(SEARCH_BOOLEAN_TYPE);
        searchArray.add("status");
        searchArray.add(SEARCH_DATE_TYPE);
        searchArray.add("createDate");

        return ok(views.html.admin.contact.MarketPlaceContact.render(userSession, searchObjectData, searchArray));
    }

    public Result sendContactMarket() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String productId = jsonGroup.get("productId").asText();
        String name = jsonGroup.get("name").asText();
        String phone = jsonGroup.get("phone").asText();
        String email = jsonGroup.get("email").asText();
        String company = jsonGroup.get("company").asText();
        String content = jsonGroup.get("content").asText();

        if(StringUtils.isEmpty(name) || StringUtils.isEmpty(phone) || StringUtils.isEmpty(email) || StringUtils.isEmpty(content)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Bạn hãy điền đầy đủ thông tin"));
            return ok(Json.toJson(respone));
        }

        if(!StringUtil.validatePhoneVnNew(phone)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Số điện thoại không đúng định dạng"));
            return ok(Json.toJson(respone));
        }

        if(!StringUtil.validateEmail(email)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Email không đúng định dạng"));
            return ok(Json.toJson(respone));
        }

        Product product = productDAO.getByKey(productId);
        if(product == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Không tìm thấy sản phẩm"));
            return ok(Json.toJson(respone));
        }

        ProductContact productContact = new ProductContact();
        productContact.setName(name);
        productContact.setPhone(phone);
        productContact.setEmail(email);
        productContact.setCompany(company);
        productContact.setContent(content);
        productContact.setProductId(productId);
        productContact.setProductName(product.getName());
        productContactDAO.save(productContact);

        //mailer
        try {
            String emailList = appfileConfig.listEmailSendContact;
            List<String> myList = new ArrayList<String>();
            myList = Arrays.asList(emailList.split(","));
            String emailTitle = "[MarketPlace - "+appfileConfig.hostNameSendContact+"] Liên hệ mua sản phẩm";
            String emailBody = "Dear sir, " +
                    "\r\n "+
                    "\r\nThông tin khách hàng liên hệ mua sản phẩm:"+
                    "\r\n "+
                    "\r\nID sản phẩm: " + productId +
                    "\r\nTên sản phẩm: " + product.getName() +
                    "\r\n "+
                    "\r\nHọ tên: " + name +
                    "\r\nSĐT: " + phone +
                    "\r\nEmail: " + email +
                    "\r\nCông ty: " + company +
                    "\r\nNội dung: " + content +
                    "\r\n "+
                    "\r\nBest Regards,"
                    ;

            mailerService.sendEmail(appfileConfig.serverEmail,
                    myList,
                    emailTitle,
                    null,
                    emailBody,
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
            respone.setIssuccess(false);
            respone.setContent("Exception");
            return ok(Json.toJson(respone));
        }

        respone.setResultString(getMessages().at("Gửi liên hệ thành công!"));
        return ok(Json.toJson(respone));
    }

    public Result editContactMarket() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        JsonNode jsonGroup = request().body().asJson();
        String id = jsonGroup.get("id").asText();
        boolean status = jsonGroup.get("status").asBoolean();

        ProductContact productContact = productContactDAO.getByKey(id);
        if(productContact == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Không tìm thấy liên hệ mua sản phẩm"));
            return ok(Json.toJson(respone));
        }

        productContact.setStatus(status);
        productContactDAO.save(productContact);

        respone.setResultString(getMessages().at("Cập nhật thành công!"));
        respone.setContent(status);
        return ok(Json.toJson(respone));
    }
}
