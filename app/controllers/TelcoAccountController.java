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
import vn.m2m.iot.dao.TelcoLogDAO;
import vn.m2m.iot.form.AccountForm;
import vn.m2m.iot.form.AccountTelcoForm;
import vn.m2m.iot.models.TelcoLog;
import vn.m2m.models.ApiResult;
import vn.m2m.service.ApiService;
import vn.m2m.utils.ImageUtil;
import vn.m2m.utils.ObjectUtil;
import vn.m2m.utils.StringUtil;
import vn.m2m.utils.UserHelper;

import javax.inject.Inject;
import java.io.File;
import java.util.*;

/**
 * Created by vtk-anhlt166 on 10/24/22.
 */
@Security.Authenticated(Secured.class)
public class TelcoAccountController extends AbstractController {
    @Inject
    public ApiService apiService;
    @Inject
    public TelcoLogDAO telcoLogDAO;

    public Result accountInfo(String userId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        if(userSession.getCmpRole() == User.CmpRole.ENTERPRISE.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_LV2.getCode()
                || userSession.getCmpRole() == User.CmpRole.ENTERPRISE_VIEW.getCode()){
            if(!userId.equals(userSession.getId())){
                flash("failed", getMessages().at("Bạn không có quyền xem tài khoản khác"));
                return redirect(controllers.routes.LandingPageController.home());
            }
        }

        return ok(views.html.telco.account.Account.render(userSession, userId));
    }

    public Result getInfoAccount() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = jsonGroup.get("userId").asText();

        Map<String, Object> returnData = new HashMap<>();

//        String url = appfileConfig.ulrBackendIot + "/api/attributes/USER/"+userSession.getId()+"/values?offset=0&limit=100";
        String url1 = appfileConfig.ulrBackendIot + "/api/users/cmp/"+userId;
        String token = "Bearer " + userSession.getToken();
        logger.info("token: {}", token);
        ApiResult apiResult1 = apiService.getByToken(url1, token);
//        logger.info("getInfoAccount: {}", Json.toJson(apiResult1));
        respone.setStatus(apiResult1.getResultStatus());
        if(apiResult1.getResultStatus() == 200){
            returnData.put("info", apiResult1.getJsonData());
        }

//        String url2 = appfileConfig.ulrBackendIot + "/api/attributes/USER/"+userSession.getId()+"/values?offset=0&limit=100";
//        ApiResult apiResult2 = apiService.getByToken(url2, token);
////        logger.info("getAttrAccount: {}", Json.toJson(apiResult2));
//
//        if(apiResult2.getResultStatus() == 200){
//            returnData.put("attr", apiResult2.getJsonData());
//        }

        respone.setContent(returnData);
        return ok(Json.toJson(respone));
    }

    public Result getInfoCompany() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = jsonGroup.get("userId").asText();

        String url1 = appfileConfig.ulrBackendIot + "/api/users/"+userId+"/enterprise?limit=1000&offset=0";
        logger.info("url", url1);
        String token = "Bearer " + userSession.getToken();
        ApiResult apiResult1 = apiService.getByToken(url1, token);
        logger.info("getInfoCompany: {}", Json.toJson(apiResult1));
        respone.setStatus(apiResult1.getResultStatus());
        if(apiResult1.getResultStatus() == 200){
            respone.setContent(apiResult1.getJsonData());
        }

        return ok(Json.toJson(respone));
    }

    public Result getInfoCompanyEnterpriseLv2() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String userId = jsonGroup.get("userId").asText();
        String url1 = appfileConfig.ulrBackendIot + "/api/users/"+userId+"/enterprise_lv2_gpkd";
        logger.info("url", url1);
        String token = "Bearer " + userSession.getToken();
        ApiResult apiResult1 = apiService.getByToken(url1, token);
        logger.info("getInfoCompany: {}", Json.toJson(apiResult1));
        respone.setStatus(apiResult1.getResultStatus());
        if(apiResult1.getResultStatus() == 200){
            respone.setContent(apiResult1.getJsonData());
        }

        return ok(Json.toJson(respone));
    }

    public Result getInfoGpkdApproved() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        String url1 = appfileConfig.ulrBackendIot + "/api/users/enterprise?businessLicense=&name&taxCode&foundedFrom&foundedTo&phone&email=&address&status=&userId&orderBy=name&limit=100&offset=0";
        logger.info("url :{}", url1);
        String token = "Bearer " + userSession.getToken();
        ApiResult apiResult1 = apiService.getByToken(url1, token);
        logger.info("getInfoGpkdApproved: {}", Json.toJson(apiResult1));
        respone.setStatus(apiResult1.getResultStatus());
        if(apiResult1.getResultStatus() == 200){
            respone.setContent(apiResult1.getJsonData());
        }

        return ok(Json.toJson(respone));
    }

    public Result updateAccountInfo() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }
        String token = "Bearer " + userSession.getToken();

        Form<AccountForm> formRequest = formFactory.form(AccountForm.class).bindFromRequest();
        if (formRequest.hasErrors()) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("form.error"));
            return ok(Json.toJson(respone));
        }

        AccountForm accountForm = formRequest.get();
        logger.info("AccountForm :{}", Json.toJson(accountForm));

        String fullnameAccount = accountForm.getNameAccount();
//        String phoneAccount = accountForm.getPhoneAccount();
        String idAccount = accountForm.getCmndAccount();
        String nameCompanyAccount = accountForm.getNameCompanyAccount();
        String businessLicenseAccount = accountForm.getGpkdAccount();
        String addressCompanyAccount = accountForm.getAddressAccount();         

        if(StringUtils.isEmpty(fullnameAccount)){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Họ tên không được để trống"));
            return ok(Json.toJson(respone));
        }

        if(!StringUtils.isEmpty(idAccount)){
            Http.MultipartFormData.FilePart fileImage_1 = accountForm.getImage_1();
            Http.MultipartFormData.FilePart fileImage_2 = accountForm.getImage_2();
            Http.MultipartFormData.FilePart fileImage_3 = accountForm.getImage_3();
            if(fileImage_1 != null && fileImage_2 != null && fileImage_3 != null){
                String nameImg_1 = fileImage_1.getFilename().replaceAll(" ","");
                File file_1 = (File) fileImage_1.getFile();
                String imageName_1 = "telco-"+UserHelper.generateUniqueFilename(nameImg_1);
                logger.info("imageName_1 :{}", imageName_1);

                String nameImg_2 = fileImage_2.getFilename().replaceAll(" ","");
                File file_2 = (File) fileImage_2.getFile();
                String imageName_2 = "telco-"+UserHelper.generateUniqueFilename(nameImg_2);
                logger.info("fileImage_2 :{}", imageName_2);

                String nameImg_3 = fileImage_3.getFilename().replaceAll(" ","");
                File file_3 = (File) fileImage_3.getFile();
                String imageName_3 = "telco-"+UserHelper.generateUniqueFilename(nameImg_3);
                logger.info("imageName_3 :{}", imageName_3);

                try {
                    //TODO: send api verify cmnd/cccd



                    //TODO: save cmnd/cccd/img
                    String url = appfileConfig.ulrBackendIot + "/api/attributes";
                    Map<String, Object> dataAttr = new HashMap<>();
                    dataAttr.put("entity_id", userSession.getId());
                    dataAttr.put("entity_type", "USER");
                    List<Object> attrList = new ArrayList<>();
                    for(int i=0; i<7; i++){
                        Map<String, Object> attr = new HashMap<>();
                        attr.put("attribute_type","SCOPE_SERVER");
                        attr.put("logged",false);
                        attr.put("value_t","STR");
                        if(i==0){
                            attr.put("attribute_key","fullname");
                            attr.put("value",fullnameAccount);
                            attrList.add(attr);
                        } else if(i==1){
                            attr.put("attribute_key","cmnd");
                            attr.put("value",idAccount);
                            attrList.add(attr);
                        } else if(i==2){
                            attr.put("attribute_key","nameCompany");
                            attr.put("value",nameCompanyAccount);
                            attrList.add(attr);
                        } else if(i==3){
                            attr.put("attribute_key","addressCompany");
                            attr.put("value",addressCompanyAccount);
                            attrList.add(attr);
                        } else if(i==4){//anh cmnd mat truoc
                            attr.put("attribute_key","cmndImgBefore");
                            attr.put("value",imageName_1);
                            attrList.add(attr);
                        } else if(i==5){//anh cmnd mat sau
                            attr.put("attribute_key","cmndImgAfter");
                            attr.put("value",imageName_2);
                            attrList.add(attr);
                        } else if(i==6){//anh khuon mat
                            attr.put("attribute_key","faceImgAccount");
                            attr.put("value",imageName_3);
                            attrList.add(attr);
                        }
                    }
                    dataAttr.put("attributes", attrList);
                    logger.info("dataAttr: {}", Json.toJson(dataAttr));
                    ApiResult apiResult = apiService.sendPostJson(url, Json.toJson(dataAttr), token);
                    logger.info("save cmnd/ccc: {}", Json.toJson(apiResult));
                    if(apiResult.getResultStatus() == 200) {
                        ImageUtil.writeImgToDisk(imageName_1, appfileConfig.contentFolderImage, file_1);
                        ImageUtil.writeImgToDisk(imageName_2, appfileConfig.contentFolderImage, file_2);
                        ImageUtil.writeImgToDisk(imageName_3, appfileConfig.contentFolderImage, file_3);
                    }

                    //TODO verify GPKD
                    if(!StringUtils.isEmpty(businessLicenseAccount)){
                        Http.MultipartFormData.FilePart fileImage_4 = accountForm.getImage_4();
                        if(fileImage_4 != null){
                            String nameImg_4 = fileImage_4.getFilename().replaceAll(" ","");
                            File file_4 = (File) fileImage_4.getFile();
                            String imageName_4 = "telco-"+UserHelper.generateUniqueFilename(nameImg_4);
                            logger.info("imageName_4 :{}", imageName_4);

                            //TODO: send api verify gpkd

                            //TODO: save gpkd
                            String url_2 = appfileConfig.ulrBackendIot + "/api/users/self";
                            Map<String, String> dataGpkd = new HashMap<>();
                            dataGpkd.put("business_license", businessLicenseAccount);
                            ApiResult apiResult_2 = apiService.putJson(url_2, Json.toJson(dataGpkd), token);
                            logger.info("save gpkd: {}", Json.toJson(apiResult_2));
                            respone.setStatus(apiResult_2.getResultStatus());
                            if(apiResult_2.getResultStatus() == 200) {
                                String urlGpkd = appfileConfig.ulrBackendIot + "/api/attributes";
                                Map<String, Object> dataAttr_2 = new HashMap<>();
                                dataAttr_2.put("entity_id", userSession.getId());
                                dataAttr_2.put("entity_type", "USER");

                                List<Object> attrList_2 = new ArrayList<>();
                                Map<String, Object> attr = new HashMap<>();
                                attr.put("attribute_type","SCOPE_SERVER");
                                attr.put("logged",false);
                                attr.put("value_t","STR");
                                attr.put("attribute_key","gpkdImgAccount");
                                attr.put("value",imageName_4);
                                attrList_2.add(attr);
                                dataAttr_2.put("attributes", attrList_2);
                                logger.info("dataAttr: {}", Json.toJson(dataAttr_2));
                                ApiResult apiResultGpkd = apiService.sendPostJson(urlGpkd, Json.toJson(dataAttr_2), token);
                                logger.info("save img gpkd: {}", Json.toJson(apiResultGpkd));
                                if(apiResultGpkd.getResultStatus() == 200) {
                                    ImageUtil.writeImgToDisk(imageName_4, appfileConfig.contentFolderImage, file_4);
                                }
                            }
                        } else {
                            respone.setIssuccess(false);
                            respone.setErrorString(getMessages().at("Bạn hãy tải lên ảnh giấy phép kinh doanh"));
                            return ok(Json.toJson(respone));
                        }
                    } else {
                        respone.setIssuccess(false);
                        respone.setErrorString(getMessages().at("Bạn chưa điền số GPKD"));
                        return ok(Json.toJson(respone));
                    }

                } catch (Exception e){
                    e.printStackTrace();
                }
            } else {
                respone.setIssuccess(false);
                respone.setErrorString(getMessages().at("Bạn hãy tải lên đủ ảnh CMND/CCCD mặt trước/sau và ảnh khuôn mặt"));
                return ok(Json.toJson(respone));
            }
        } else {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("Bạn chưa điền số CMND/CCCD"));
            return ok(Json.toJson(respone));
        }




        respone.setResultString(getMessages().at("noti.Updatesuccess"));
        return ok(Json.toJson(respone));
    }

   public Result updateDetailAccountTelco() {
       AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
       respone.setIssuccess(true);

       User userSession = getUserSession();
       if(userSession == null){
           respone.setIssuccess(false);
           respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
           return ok(Json.toJson(respone));
       }
       String token = "Bearer " + userSession.getToken();
       logger.info("token :{}", token);
       Form<AccountTelcoForm> formRequest = formFactory.form(AccountTelcoForm.class).bindFromRequest();
       if (formRequest.hasErrors()) {
           respone.setIssuccess(false);
           respone.setErrorString(getMessages().at("form.error"));
           return ok(Json.toJson(respone));
       }

       AccountTelcoForm accountTelcoForm = formRequest.get();
       logger.info("accountTelcoForm :{}", Json.toJson(accountTelcoForm));

       String hoTen = accountTelcoForm.getHoTen();
       String cmnd = accountTelcoForm.getCmnd();
       String sdt = accountTelcoForm.getSdt();
       String ngaySinh = accountTelcoForm.getNgaySinh();
       String quocTich = accountTelcoForm.getQuocTich();
       String tinhTP = accountTelcoForm.getTinhTP();
       String quanHuyen = accountTelcoForm.getQuanHuyen();
       String phuongXa = accountTelcoForm.getPhuongXa();
       String diaChiChiTiet = accountTelcoForm.getDiaChiChiTiet();
       String gioiTinh = accountTelcoForm.getGioiTinh();
       String emailContact =accountTelcoForm.getEmailContact();
       String sdtContact =accountTelcoForm.getSdtContact();

       if(StringUtils.isEmpty(hoTen)){
           respone.setIssuccess(false);
           respone.setErrorString(getMessages().at("Họ tên không được để trống"));
           return ok(Json.toJson(respone));
       }

       Map<String, Object> returnData = new HashMap<>();

       Map<String, Object> profile = new HashMap<>();
       profile.put("dob", ngaySinh);
       profile.put("phone", sdt);
       profile.put("gender", gioiTinh);
       profile.put("nationality", quocTich);
       profile.put("province", tinhTP);
       profile.put("district", quanHuyen);
       profile.put("ward", phuongXa);
       profile.put("full_address", diaChiChiTiet);
       profile.put("contact_email", emailContact);
       profile.put("contact_phone", sdtContact);

       Map<String, Object> identity_info = new HashMap<>();
       identity_info.put("identity", cmnd);

       Http.MultipartFormData.FilePart fileImage_1 = accountTelcoForm.getImage_1();
       Http.MultipartFormData.FilePart fileImage_2 = accountTelcoForm.getImage_2();
       Http.MultipartFormData.FilePart fileImage_3 = accountTelcoForm.getImage_3();
       Http.MultipartFormData.FilePart fileImage_5 = accountTelcoForm.getImage_5();
       Http.MultipartFormData.FilePart fileImage_6 = accountTelcoForm.getImage_6();
       String imageName_1 = "";
       String imageName_2 = "";
       String imageName_3 = "";
       String imageName_5 = "";
       String imageName_6 = "";

//        String url_upImg = "http://125.212.248.229:4437/api/miniovt/file/upload";
       String url_upImg = appfileConfig.urlBackendIotTelco + "/api/miniovt/file/upload";
       logger.info("url_upImg :{}", url_upImg);
       if(fileImage_1 != null) {
           File file_1 = (File) fileImage_1.getFile();
           String nameImg_1 = fileImage_1.getFilename().replaceAll(" ", "");
           ApiResult sendFile1 = apiService.sendFileToInnowayHttpURLConnection(url_upImg, token, nameImg_1, file_1);
           logger.info("sendFile1 :{}", Json.toJson(sendFile1));
           if(sendFile1.getJsonData() != null && sendFile1.getJsonData().get("link") != null){
               imageName_1 = sendFile1.getJsonData().get("link").asText();
               logger.info("imageName_1 :{}", imageName_1);
           }
       }
       if(fileImage_2 != null) {
           File file_2 = (File) fileImage_2.getFile();
           String nameImg_2 = fileImage_2.getFilename().replaceAll(" ", "");
           ApiResult sendFile2 = apiService.sendFileToInnowayHttpURLConnection(url_upImg, token, nameImg_2, file_2);
           logger.info("sendFile2 :{}", Json.toJson(sendFile2));
           if(sendFile2.getJsonData() != null && sendFile2.getJsonData().get("link") != null){
               imageName_2 = sendFile2.getJsonData().get("link").asText();
           }
       }
       if(fileImage_3 != null) {
           File file_3 = (File) fileImage_3.getFile();
           String nameImg_3 = fileImage_3.getFilename().replaceAll(" ", "");
           ApiResult sendFile3 = apiService.sendFileToInnowayHttpURLConnection(url_upImg, token, nameImg_3, file_3);
           logger.info("sendFile3 :{}", Json.toJson(sendFile3));
           if(sendFile3.getJsonData() != null && sendFile3.getJsonData().get("link") != null){
               imageName_3 = sendFile3.getJsonData().get("link").asText();
           }
       }
       if(fileImage_5 != null) {
           File file_5 = (File) fileImage_5.getFile();
           String nameImg_5 = fileImage_5.getFilename().replaceAll(" ", "");
           ApiResult sendFile5 = apiService.sendFileToInnowayHttpURLConnection(url_upImg, token, nameImg_5, file_5);
           logger.info("sendFile5 :{}", Json.toJson(sendFile5));
           if(sendFile5.getJsonData() != null && sendFile5.getJsonData().get("link") != null){
               imageName_5 = sendFile5.getJsonData().get("link").asText();
           }
       }
       if(fileImage_6 != null) {
           File file_6 = (File) fileImage_6.getFile();
           String nameImg_6 = fileImage_6.getFilename().replaceAll(" ", "");
           ApiResult sendFile6 = apiService.sendFileToInnowayHttpURLConnection(url_upImg, token, nameImg_6, file_6);
           logger.info("sendFile6 :{}", Json.toJson(sendFile6));
           if(sendFile6.getJsonData() != null && sendFile6.getJsonData().get("link") != null){
               imageName_6 = sendFile6.getJsonData().get("link").asText();
           }
       }

       if(!StringUtils.isEmpty(imageName_1)) {
           profile.put("profile_image", imageName_1);
       } else {
           String imgOld1 = accountTelcoForm.getImgOld1();
           profile.put("profile_image", imgOld1);
       }
       if(!StringUtils.isEmpty(imageName_2)) {
           identity_info.put("front_image", imageName_2);
       } else {
           String imgOld2 = accountTelcoForm.getImgOld2();
           identity_info.put("front_image", imgOld2);
       }
       if(!StringUtils.isEmpty(imageName_3)) {
           identity_info.put("back_image", imageName_3);
       } else {
           String imgOld3 = accountTelcoForm.getImgOld3();
           identity_info.put("back_image", imgOld3);
       }
       if(!StringUtils.isEmpty(imageName_5)) {
           identity_info.put("authorization_letter_image", imageName_5);
       } else {
           String imgOld5 = accountTelcoForm.getImgOld5();
           identity_info.put("authorization_letter_image", imgOld5);
       }
       if(!StringUtils.isEmpty(imageName_6)) {
           identity_info.put("registration_form_image", imageName_6);
       } else {
           String imgOld6 = accountTelcoForm.getImgOld6();
           identity_info.put("registration_form_image", imgOld6);
       }
       profile.put("identity_info", identity_info);
       Map<String, Object> bodyUser = new HashMap<>();
       bodyUser.put("profile", profile);
       bodyUser.put("name", hoTen);

       //cap nhat thong tin ng dung
       String url_user = appfileConfig.ulrBackendIot + "/api/users/cmp/self";
       logger.debug("bodyUser :{}", Json.toJson(bodyUser));
       ApiResult apiResult = apiService.sendPutJson(url_user, Json.toJson(bodyUser), token);
       if(apiResult.getResultStatus() == 200){
           returnData.put("updateUser", true);
       } else {
           returnData.put("updateUser", false);
       }

       TelcoLog telcoLog = new TelcoLog();
       telcoLog.setUsername(userSession.getUsername());
       telcoLog.setName("updateDetailAccountTelco");
       telcoLog.setContent("Cap nhat thong tin tai khoan");
       telcoLog.setUrl(url_user);
       telcoLog.setBody(String.valueOf(bodyUser));
       telcoLog.setStatusCode(apiResult.getResultStatus());
       telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
       telcoLogDAO.save(telcoLog);

       respone.setContent(returnData);
//        respone.setResultString(getMessages().at("noti.Updatesuccess"));
       return ok(Json.toJson(respone));
   }
// public Result updateDetailAccountTelco() {
//     AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
//     respone.setIssuccess(true);

//     User userSession = getUserSession();
//     if(userSession == null){
//         respone.setIssuccess(false);
//         respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
//         return ok(Json.toJson(respone));
//     }
//     String token = "Bearer " + userSession.getToken();
//     logger.info("token :{}", token);
//     Form<AccountTelcoForm> formRequest = formFactory.form(AccountTelcoForm.class).bindFromRequest();
//     if (formRequest.hasErrors()) {
//         respone.setIssuccess(false);
//         respone.setErrorString(getMessages().at("form.error"));
//         return ok(Json.toJson(respone));
//     }

//     AccountTelcoForm accountTelcoForm = formRequest.get();
//     logger.info("accountTelcoForm :{}", Json.toJson(accountTelcoForm));

//     String hoTen = accountTelcoForm.getHoTen();
//     String cmnd = accountTelcoForm.getCmnd();
//     String sdt = accountTelcoForm.getSdt();
//     String ngaySinh = accountTelcoForm.getNgaySinh();
//     String quocTich = accountTelcoForm.getQuocTich();
//     String tinhTP = accountTelcoForm.getTinhTP();
//     String quanHuyen = accountTelcoForm.getQuanHuyen();
//     String phuongXa = accountTelcoForm.getPhuongXa();
//     String diaChiChiTiet = accountTelcoForm.getDiaChiChiTiet();
//     String gioiTinh = accountTelcoForm.getGioiTinh();
//     String emailContact =accountTelcoForm.getEmailContact();
//     String sdtContact =accountTelcoForm.getSdtContact();

//     if(StringUtils.isEmpty(hoTen)){
//         respone.setIssuccess(false);
//         respone.setErrorString(getMessages().at("Họ tên không được để trống"));
//         return ok(Json.toJson(respone));
//     }

//     Map<String, Object> returnData = new HashMap<>();

//     Map<String, Object> profile = new HashMap<>();
//     profile.put("dob", ngaySinh);
//     profile.put("phone", sdt);
//     profile.put("gender", gioiTinh);
//     profile.put("contact_email", emailContact);
//     profile.put("contact_phone", sdtContact);
//     profile.put("nationality", quocTich);
//     profile.put("province", tinhTP);
//     profile.put("district", quanHuyen);
//     profile.put("ward", phuongXa);
//     profile.put("full_address", diaChiChiTiet);

//     Map<String, Object> identity_info = new HashMap<>();
//     identity_info.put("identity", cmnd);

//     String imageName_1 = accountTelcoForm.getImageName1();
//     String imageName_2 = accountTelcoForm.getImageName2();
//     String imageName_3 = accountTelcoForm.getImageName3();
//     String imageName_5 = accountTelcoForm.getImageName5();
//     String imageName_6 = accountTelcoForm.getImageName6();


//     if(!StringUtils.isEmpty(imageName_1)) {
//         profile.put("profile_image", imageName_1);
//     } else {
//         String imgOld1 = accountTelcoForm.getImgOld1();
//         profile.put("profile_image", imgOld1);
//     }
//     if(!StringUtils.isEmpty(imageName_2)) {
//         identity_info.put("front_image", imageName_2);
//     } else {
//         String imgOld2 = accountTelcoForm.getImgOld2();
//         identity_info.put("front_image", imgOld2);
//     }
//     if(!StringUtils.isEmpty(imageName_3)) {
//         identity_info.put("back_image", imageName_3);
//     } else {
//         String imgOld3 = accountTelcoForm.getImgOld3();
//         identity_info.put("back_image", imgOld3);
//     }
//     if(!StringUtils.isEmpty(imageName_5)) {
//         identity_info.put("authorization_letter_image", imageName_5);
//     } else {
//         String imgOld5 = accountTelcoForm.getImgOld5();
//         identity_info.put("authorization_letter_image", imgOld5);
//     }
//     if(!StringUtils.isEmpty(imageName_6)) {
//         identity_info.put("registration_form_image", imageName_6);
//     } else {
//         String imgOld6 = accountTelcoForm.getImgOld6();
//         identity_info.put("registration_form_image", imgOld6);
//     }
//     profile.put("identity_info", identity_info);
//     Map<String, Object> bodyUser = new HashMap<>();
//     bodyUser.put("profile", profile);
//     bodyUser.put("name", hoTen);

//     //cap nhat thong tin ng dung
//     String url_user = appfileConfig.ulrBackendIot + "/api/users/cmp/self";
//     logger.debug("bodyUser :{}", Json.toJson(bodyUser));
//     ApiResult apiResult = apiService.sendPutJson(url_user, Json.toJson(bodyUser), token);
//     if(apiResult.getResultStatus() == 200){
//         returnData.put("updateUser", true);
//     } else {
//         returnData.put("updateUser", false);
//     }

//     TelcoLog telcoLog = new TelcoLog();
//     telcoLog.setUsername(userSession.getUsername());
//     telcoLog.setName("updateDetailAccountTelco");
//     telcoLog.setContent("Cap nhat thong tin tai khoan");
//     telcoLog.setUrl(url_user);
//     telcoLog.setBody(String.valueOf(bodyUser));
//     telcoLog.setStatusCode(apiResult.getResultStatus());
//     telcoLog.setResponse(String.valueOf(apiResult.getJsonData()));
//     telcoLogDAO.save(telcoLog);

//     respone.setContent(returnData);
// //        respone.setResultString(getMessages().at("noti.Updatesuccess"));
//     return ok(Json.toJson(respone));
// }
    public Result  updateInfoCompanyTelco() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }
        String token = "Bearer " + userSession.getToken();
        logger.info("token :{}", token);
        Form<AccountTelcoForm> formRequest = formFactory.form(AccountTelcoForm.class).bindFromRequest();
        if (formRequest.hasErrors()) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("form.error"));
            return ok(Json.toJson(respone));
        }

        AccountTelcoForm accountTelcoForm = formRequest.get();
        logger.info("accountTelcoForm :{}", Json.toJson(accountTelcoForm));

        String idDoanhNghiep = accountTelcoForm.getIdDoanhNghiep();
        String tenDoanhNghiep = accountTelcoForm.getTenDoanhNghiep();
        String maSoThue = accountTelcoForm.getMaSoThue();
        String soGpkd = accountTelcoForm.getSoGpkd();
        String ngayThanhLap = accountTelcoForm.getNgayThanhLap();
        String sdtDN = accountTelcoForm.getSdtDN();
        String emailDN = accountTelcoForm.getEmailDN();
        String tinhTpDN = accountTelcoForm.getTinhTpDN();
        String quanHuyenDN = accountTelcoForm.getQuanHuyenDN();
        String phuongXaDN = accountTelcoForm.getPhuongXaDN();
        String diaChiChiTietDN = accountTelcoForm.getDiaChiChiTietDN();
        String dsLinhVuc = accountTelcoForm.getDsLinhVuc();
        String dsDongThietBi = accountTelcoForm.getDsDongThietBi();

        //thong tin doanh nghiep
        Map<String, Object> body = new HashMap<>();
        body.put("name", tenDoanhNghiep);
        body.put("business_license", soGpkd);
        body.put("tax_code", maSoThue);
        body.put("founded", ngayThanhLap);
        body.put("phone", sdtDN);
        body.put("email", emailDN);
        body.put("province", tinhTpDN);
        body.put("district", quanHuyenDN);
        body.put("ward", phuongXaDN);
        body.put("full_address", diaChiChiTietDN);

        List<String> myListLinhVuc = new ArrayList<String>();
        myListLinhVuc = Arrays.asList(dsLinhVuc.split(","));
        if(myListLinhVuc.size() > 0){
            List<Object> dsLV = new ArrayList<>();
            for(String lv: myListLinhVuc){
                Map<String, String> data = new HashMap<>();
                data.put("code", lv);
                dsLV.add(data);
            }
            body.put("business_types", dsLV);
        }

        List<String> myListDongThietBi = new ArrayList<String>();
        myListDongThietBi = Arrays.asList(dsDongThietBi.split(","));
        if(myListDongThietBi.size() > 0){
            List<Object> dsDTB = new ArrayList<>();
            for(String dtb: myListDongThietBi){
                Map<String, String> data = new HashMap<>();
                data.put("code", dtb);
                dsDTB.add(data);
            }
            body.put("device_types", dsDTB);
        }

        Map<String, Object> returnData = new HashMap<>();
//        String url_upImg = "http://125.212.248.229:4437/api/miniovt/file/upload";
        String url_upImg = appfileConfig.urlBackendIotTelco + "/api/miniovt/file/upload";
        logger.info("url_upImg :{}", url_upImg);

        Http.MultipartFormData.FilePart fileImage_1 = accountTelcoForm.getImage_1();
        String imageName_1 = "";
        if(fileImage_1 != null) {
            File file_1 = (File) fileImage_1.getFile();
            String nameImg_1 = fileImage_1.getFilename().replaceAll(" ", "");
            ApiResult sendFile1 = apiService.sendFileToInnowayHttpURLConnection(url_upImg, token, nameImg_1, file_1);
            logger.info("sendFile4 :{}", Json.toJson(sendFile1));
            if(sendFile1.getJsonData() != null && sendFile1.getJsonData().get("link") != null){
                imageName_1 = sendFile1.getJsonData().get("link").asText();
            }
        }
        if(!StringUtils.isEmpty(imageName_1)){
            body.put("business_license_image", imageName_1);
        } else {
            String imgOld1 = accountTelcoForm.getImgOld1();
            body.put("business_license_image", imgOld1);
        }
        logger.info("body :{}", Json.toJson(body));
        if(StringUtils.isEmpty(idDoanhNghiep)){ //tao thong tin doanh nghiep moi
            String url_dn = appfileConfig.ulrBackendIot + "/api/users/enterprise";
            logger.info("url_dn :{}", url_dn);
            ApiResult apiResultDN = apiService.sendPostJson(url_dn, Json.toJson(body), token);
            logger.info("apiResultDN :{}", Json.toJson(apiResultDN));
            respone.setStatus(apiResultDN.getResultStatus());
            respone.setContent(apiResultDN.getJsonData());
            if(apiResultDN.getResultStatus() >= 200 && apiResultDN.getResultStatus() <= 299){
                respone.setIssuccess(true);
            } else {
                respone.setIssuccess(false);
            }

            TelcoLog telcoLog_dn = new TelcoLog();
            telcoLog_dn.setUsername(userSession.getUsername());
            telcoLog_dn.setName("updateDetailAccountTelco");
            telcoLog_dn.setContent("Cap nhat thong tin doanh nghiep");
            telcoLog_dn.setUrl(url_dn);
            telcoLog_dn.setBody(String.valueOf(body));
            telcoLog_dn.setStatusCode(apiResultDN.getResultStatus());
            telcoLog_dn.setResponse(String.valueOf(apiResultDN.getJsonData()));
            telcoLogDAO.save(telcoLog_dn);
        } else {
            String url_dn = appfileConfig.ulrBackendIot + "/api/users/enterprise/"+idDoanhNghiep;
            logger.info("url_dn :{}", url_dn);
            ApiResult apiResultDN = apiService.sendPutJson(url_dn, Json.toJson(body), token);
            logger.info("apiResultDN :{}", Json.toJson(apiResultDN));
            respone.setStatus(apiResultDN.getResultStatus());
            respone.setContent(apiResultDN.getJsonData());
            if(apiResultDN.getResultStatus() >= 200 && apiResultDN.getResultStatus() <= 299){
                respone.setIssuccess(true);
            } else {
                respone.setIssuccess(false);
            }

            TelcoLog telcoLog_dn = new TelcoLog();
            telcoLog_dn.setUsername(userSession.getUsername());
            telcoLog_dn.setName("updateDetailAccountTelco");
            telcoLog_dn.setContent("Cap nhat thong tin doanh nghiep");
            telcoLog_dn.setUrl(url_dn);
            telcoLog_dn.setBody(String.valueOf(body));
            telcoLog_dn.setStatusCode(apiResultDN.getResultStatus());
            telcoLog_dn.setResponse(String.valueOf(apiResultDN.getJsonData()));
            telcoLogDAO.save(telcoLog_dn);
        }

//        respone.setResultString(getMessages().at("noti.Updatesuccess"));
        return ok(Json.toJson(respone));
    }

    public Result deleteInfoCompany() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String enterpriseId = jsonGroup.get("enterpriseId").asText();

        String token = "Bearer " + userSession.getToken();
        String url_enterprise = appfileConfig.urlBackendIotTelco + "/api/users/enterprise/"+enterpriseId;
        ApiResult apiResult_enterprise = apiService.deleteByToken(url_enterprise, token);
        logger.info("url_enterprise : {}", url_enterprise);
        logger.info("deleteEnterprise : {}", Json.toJson(apiResult_enterprise));
        respone.setStatus(apiResult_enterprise.getResultStatus());
        respone.setContent(apiResult_enterprise.getJsonData());
        if(apiResult_enterprise.getResultStatus() >= 200 && apiResult_enterprise.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Deletesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.Deletefalse"));
        }

        TelcoLog telcoLog = new TelcoLog();
        telcoLog.setUsername(userSession.getUsername());
        telcoLog.setName("deleteInfoCompany");
        telcoLog.setContent("Xoa thong tin GPKD doanh nghiep");
        telcoLog.setUrl(url_enterprise);
//        telcoLog.setBody(String.valueOf(param));
        telcoLog.setStatusCode(apiResult_enterprise.getResultStatus());
        telcoLog.setResponse(String.valueOf(apiResult_enterprise.getJsonData()));
        telcoLogDAO.save(telcoLog);

        return ok(Json.toJson(respone));
    }

    public Result getListArea() { // lay ds dia ban
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        JsonNode jsonGroup = request().body().asJson();
        String type = (jsonGroup.get("type") != null) ? jsonGroup.get("type").asText() :"";
        String parentCode = (jsonGroup.get("parentCode") != null) ? jsonGroup.get("parentCode").asText() :"";
        Map<String, String> param = new HashMap<>();
        param.put("type", type);
        param.put("parentCode", parentCode);
        logger.info("param: {}", param);
        String url = appfileConfig.urlBackendIotTelco + "/api/telco/getListArea";
        logger.info("url: {}", url);
        String token = "Bearer " + userSession.getToken();
        ApiResult apiResult = apiService.getWithParams(url, token, param);
//        logger.info("getArea: {}", Json.toJson(apiResult));
        respone.setStatus(apiResult.getResultStatus());
        if(apiResult.getResultStatus() == 200){
            respone.setContent(apiResult.getJsonData());
        }

        return ok(Json.toJson(respone));
    }

    public Result getCategoryBusinessAndDevice() { // lay ds lĩnh vực hoạt động + thiết bi đang sử dụng
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if (userSession == null) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }

        Map<String, Object> data = new HashMap<>();

        String url_1 = appfileConfig.urlBackendIotTelco + "/api/users/cmp/noauth/category/BUSINESS";
        String token = "Bearer " + userSession.getToken();
        ApiResult apiResult_1 = apiService.getByToken(url_1, token);
        logger.info("getCategoryBusinessAndDevice: {}", Json.toJson(apiResult_1));
        if(apiResult_1.getResultStatus() == 200){
            data.put("business", apiResult_1.getJsonData());
        }

        String url_2 = appfileConfig.urlBackendIotTelco + "/api/users/cmp/noauth/category/DEVICE";
        ApiResult apiResult_2 = apiService.getByToken(url_2, token);
        logger.info("getCategoryBusinessAndDevice: {}", Json.toJson(apiResult_2));
        if(apiResult_2.getResultStatus() == 200){
            data.put("device", apiResult_2.getJsonData());
        }

        respone.setContent(data);
        return ok(Json.toJson(respone));
    }

    public Result updateCategoryBusinessAndDevice() {
        AbstractAjaxJsonModel respone = new AbstractAjaxJsonModel();
        respone.setIssuccess(true);

        User userSession = getUserSession();
        if(userSession == null){
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("noti.sessionTimeOut"));
            return ok(Json.toJson(respone));
        }
        String token = "Bearer " + userSession.getToken();
        logger.info("token :{}", token);
        Form<AccountTelcoForm> formRequest = formFactory.form(AccountTelcoForm.class).bindFromRequest();
        if (formRequest.hasErrors()) {
            respone.setIssuccess(false);
            respone.setErrorString(getMessages().at("form.error"));
            return ok(Json.toJson(respone));
        }

        AccountTelcoForm accountTelcoForm = formRequest.get();
        logger.info("accountTelcoForm :{}", Json.toJson(accountTelcoForm));

        String idDoanhNghiep = accountTelcoForm.getIdDoanhNghiep();
        String dsLinhVuc = accountTelcoForm.getDsLinhVuc();
        String dsDongThietBi = accountTelcoForm.getDsDongThietBi();

        //thong tin doanh nghiep
        Map<String, Object> body = new HashMap<>();

        List<String> myListLinhVuc = new ArrayList<String>();
        myListLinhVuc = Arrays.asList(dsLinhVuc.split(","));
        if(myListLinhVuc.size() > 0){
            List<Object> dsLV = new ArrayList<>();
            for(String lv: myListLinhVuc){
                Map<String, String> data = new HashMap<>();
                data.put("code", lv);
                dsLV.add(data);
            }
            body.put("business_types", dsLV);
        }

        List<String> myListDongThietBi = new ArrayList<String>();
        myListDongThietBi = Arrays.asList(dsDongThietBi.split(","));
        if(myListDongThietBi.size() > 0){
            List<Object> dsDTB = new ArrayList<>();
            for(String dtb: myListDongThietBi){
                Map<String, String> data = new HashMap<>();
                data.put("code", dtb);
                dsDTB.add(data);
            }
            body.put("device_types", dsDTB);
        }
        logger.info("body :{}", Json.toJson(body));

        String url_dn = appfileConfig.ulrBackendIot + "/api/users/enterprise/"+idDoanhNghiep;
        logger.info("url_dn :{}", url_dn);
        ApiResult apiResultDN = apiService.sendPutJson(url_dn, Json.toJson(body), token);
        logger.info("apiResultDN :{}", Json.toJson(apiResultDN));
        respone.setStatus(apiResultDN.getResultStatus());
        respone.setContent(apiResultDN.getJsonData());
        if(apiResultDN.getResultStatus() >= 200 && apiResultDN.getResultStatus() <= 299){
            respone.setResultString(getMessages().at("noti.Updatesuccess"));
        } else {
            respone.setIssuccess(false);
            respone.setResultString(getMessages().at("noti.Updatefalse"));
        }

        TelcoLog telcoLog_dn = new TelcoLog();
        telcoLog_dn.setUsername(userSession.getUsername());
        telcoLog_dn.setName("updateCategoryBusinessAndDevice");
        telcoLog_dn.setContent("Cap nhat linh vuc doanh nghiep");
        telcoLog_dn.setUrl(url_dn);
        telcoLog_dn.setBody(String.valueOf(body));
        telcoLog_dn.setStatusCode(apiResultDN.getResultStatus());
        telcoLog_dn.setResponse(String.valueOf(apiResultDN.getJsonData()));
        telcoLogDAO.save(telcoLog_dn);

//        respone.setResultString(getMessages().at("noti.Updatesuccess"));
        return ok(Json.toJson(respone));
    }
}
