package controllers;

import com.google.inject.Inject;
import models.ajaxjsons.AbstractAjaxJsonModel;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.common.models.forms.SearchFilter;
import vn.m2m.common.models.forms.SearchFilterForm;
import vn.m2m.common.models.forms.SearchObjectData;
import vn.m2m.common.models.forms.UserForm;
import vn.m2m.iot.dao.RegisterDeveloperDAO;
import vn.m2m.iot.form.RegisterDeveloperForm;
import vn.m2m.iot.models.RegisterDeveloper;
import vn.m2m.utils.UserHelper;

import java.util.ArrayList;
import java.util.List;

import static vn.m2m.utils.SearchUtil.*;
import static vn.m2m.utils.SearchUtil.InitConditionListDataPOST;
import static vn.m2m.utils.SearchUtil.SEARCH_STRING_TYPE;

/**
 * Created by vtk-anhlt166 on 7/27/22.
 */
@Security.Authenticated(Secured.class)
public class AdminRegisterDeveloperController extends AbstractController {
    @Inject
    public RegisterDeveloperDAO registerDeveloperDAO;




    public Result registerDeveloperList(){
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
        searchArray.add("nameCompany");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("email");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("phone");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("role");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("field");
        searchArray.add(SEARCH_INT_TYPE);
        searchArray.add("countDevice");
        searchArray.add(SEARCH_INT_TYPE);
        searchArray.add("countUser");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("ip");

        searchFilter = InitConditionListData(searchArray,"logDate"); // last field is sort field name
        searchFilter.setIsDesc(true);

        List<Object> objectList = new ArrayList<Object>();
        objectList =(List<Object>)(List) registerDeveloperDAO.searchAndQuery(searchFilter);

        long countTotal = registerDeveloperDAO.countOnQuery(searchFilter);
        searchObjectData = PagingDataAfterSearch(searchFilter, countTotal);
        searchObjectData.setObjectList(objectList);

        return ok(views.html.admin.registerDeveloper.RegisterDeveloperList.render(userSession, searchObjectData, searchArray));
    }

    public Result registerDeveloperFilterList() {
        Form<SearchFilterForm> searchGenericFormForm = formFactory.form(SearchFilterForm.class);
        SearchFilterForm searchFilterForm = searchGenericFormForm.bindFromRequest().get();

        return registerDeveloperFilterList(searchFilterForm);
    }

    public Result registerDeveloperFilterList(SearchFilterForm searchFilterForm) {
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
        searchArray.add("nameCompany");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("email");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("phone");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("role");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("field");
        searchArray.add(SEARCH_INT_TYPE);
        searchArray.add("countDevice");
        searchArray.add(SEARCH_INT_TYPE);
        searchArray.add("countUser");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("ip");

        SearchFilter searchFilter = new SearchFilter();
        searchFilter = InitConditionListDataPOST(searchArray, searchFilterForm);
        searchFilter.setIsDesc(true);
        searchFilter.setSortFieldName("logDate");

        List<Object> objectList = new ArrayList<Object>();
        objectList =(List<Object>)(List) registerDeveloperDAO.searchAndQuery(searchFilter);

        long countTotal = registerDeveloperDAO.countOnQuery(searchFilter);
        SearchObjectData searchObjectData = new SearchObjectData();
        searchObjectData = PagingDataAfterSearchPOST(searchFilter, searchFilterForm,countTotal);
        searchObjectData.setObjectList(objectList);

        searchArray = new ArrayList<String>();
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("name");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("nameCompany");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("email");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("phone");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("role");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("field");
        searchArray.add(SEARCH_INT_TYPE);
        searchArray.add("countDevice");
        searchArray.add(SEARCH_INT_TYPE);
        searchArray.add("countUser");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("ip");

        return ok(views.html.admin.registerDeveloper.RegisterDeveloperList.render(userSession, searchObjectData, searchArray));
    }

    public Result deleteRegisterDeveloper(){
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        if (userSession.getSystemRole() != User.SystemRole.SYSTEM_ADMIN.getCode()) {
            flash("failed", getMessages().at("noti.notPermit"));
            return redirect(controllers.routes.Application.login());
        }

        Form<RegisterDeveloperForm> formRequest = formFactory.form(RegisterDeveloperForm.class).bindFromRequest();
        if (formRequest.hasErrors()) {
            logger.debug("form error");
            flash("failed", getMessages().at("form.error"));
            return redirect(routes.AdminRegisterDeveloperController.registerDeveloperList());
        }

        RegisterDeveloperForm register = formRequest.get();
        String id = register.getId();

        RegisterDeveloper registerDeveloper = registerDeveloperDAO.getByKey(id);
        if(registerDeveloper == null){
            flash("failed", getMessages().at("Lỗi không tìm thấy đăng kí "));
            return redirect(routes.AdminRegisterDeveloperController.registerDeveloperList());
        } else {
            registerDeveloperDAO.deleteByKey(id);
        }

        flash("success", getMessages().at("Xóa thành công"));
        return redirect(routes.AdminRegisterDeveloperController.registerDeveloperList());
    }

    public Result exportRegisterDeveloperList(){
        User userSession = getUserSession();
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

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
        searchArray.add("nameCompany");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("email");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("phone");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("role");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("field");
        searchArray.add(SEARCH_INT_TYPE);
        searchArray.add("countDevice");
        searchArray.add(SEARCH_INT_TYPE);
        searchArray.add("countUser");
        searchArray.add(SEARCH_STRING_TYPE);
        searchArray.add("ip");

        Form<SearchFilterForm> searchGenericFormForm = formFactory.form(SearchFilterForm.class);
        SearchFilterForm searchFilterForm = searchGenericFormForm.bindFromRequest().get();
        searchFilterForm.setFilter(searchArray);

        SearchFilter searchFilter = new SearchFilter();
        searchFilter = InitConditionListDataPOST(searchArray, searchFilterForm);

        List<RegisterDeveloper> registerDevelopers = new ArrayList<>();
        registerDevelopers = registerDeveloperDAO.searchAndQueryWithoutPaging(searchFilter);

        return ok(Json.toJson(registerDevelopers));
    }
}
