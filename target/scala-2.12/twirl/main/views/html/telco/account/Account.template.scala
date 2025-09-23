
package views.html.telco.account

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._
/*1.2*/import helper._
/*2.2*/import vn.m2m.common.models.User

object Account extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.35*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>"""),_display_(/*9.17*/Messages("account.title")),format.raw/*9.42*/("""</title>
        <link rel="icon" type="image/png" href=""""),_display_(/*10.50*/routes/*10.56*/.Assets.versioned("images/logo.jpg")),format.raw/*10.92*/("""">
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        """),format.raw/*14.118*/("""
        """),_display_(/*15.10*/views/*15.15*/.html.iot.tags.Main_css()),format.raw/*15.40*/("""
        """),format.raw/*16.9*/("""<link href=""""),_display_(/*16.22*/routes/*16.28*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*16.82*/("""" rel="stylesheet" />
        <link href=""""),_display_(/*17.22*/routes/*17.28*/.Assets.versioned("assets/plugins/input-tags/css/tagsinput.css")),format.raw/*17.92*/("""" rel="stylesheet" />
        <link href=""""),_display_(/*18.22*/routes/*18.28*/.Assets.versioned("assets/plugins/notifications/css/lobibox.min.css")),format.raw/*18.97*/("""" rel="stylesheet" />
        <link href=""""),_display_(/*19.22*/routes/*19.28*/.Assets.versioned("assets/css/icons.css")),format.raw/*19.69*/("""" rel="stylesheet">

        """),format.raw/*21.100*/("""
        """),format.raw/*22.9*/("""<link href='"""),_display_(/*22.22*/routes/*22.28*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*22.77*/("""' type='text/css'>
        <link href=""""),_display_(/*23.22*/routes/*23.28*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*23.103*/("""" rel="stylesheet">
        <link href=""""),_display_(/*24.22*/routes/*24.28*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*24.143*/("""" rel="stylesheet" >

        <link href=""""),_display_(/*26.22*/routes/*26.28*/.Assets.versioned("assets/plugins/select2/css/select2.min.css")),format.raw/*26.91*/("""" rel="stylesheet" />
        <link href=""""),_display_(/*27.22*/routes/*27.28*/.Assets.versioned("assets/plugins/select2/css/select2-bootstrap4.css")),format.raw/*27.98*/("""" rel="stylesheet" />

        <link href=""""),_display_(/*29.22*/routes/*29.28*/.Assets.versioned("stylesheets/views/telco/account/account.css")),format.raw/*29.92*/("""" rel="stylesheet" />
        <link href=""""),_display_(/*30.22*/routes/*30.28*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*30.82*/("""" rel="stylesheet" />
        <link href=""""),_display_(/*31.22*/routes/*31.28*/.Assets.versioned("stylesheets/views/telco/role/childUser.css")),format.raw/*31.91*/("""" rel="stylesheet" />

    </head>

    <body class="bg-theme">
        """),_display_(/*36.10*/views/*36.15*/.html.telco.Menu(currentUser, "", userId)),format.raw/*36.56*/("""
        """),_display_(/*37.10*/views/*37.15*/.html.telco.Header(currentUser)),format.raw/*37.46*/("""
        """),format.raw/*38.9*/("""<div class="page-wrapper">
            <div class="page-content">
                <div class="section features-1">
                    <div class="container-1" style="background-color: #FFFFFF">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item" role="presentation" onclick="">
                                <a class="nav-link active display-4 title-section-1 " data-bs-toggle="tab" href="#infoAccount" role="tab" aria-selected="false">"""),_display_(/*44.162*/Messages("account.info.tab")),format.raw/*44.190*/("""
                                """),format.raw/*45.33*/("""</a>
                            </li>
                            <li class="nav-item" role="presentation" onclick="">
                                <a class="nav-link display-4 title-section-1"  data-bs-toggle="tab" href="#enterpriseLv2" role="tab" aria-selected="false" onclick="getListChildUser()">"""),_display_(/*48.186*/Messages("account.management.level2")),format.raw/*48.223*/("""
                                """),format.raw/*49.33*/("""</a>
                            </li>
                        </ul>
                        <div class="tab-content tab-recharge" style="">
                            <div class="tab-pane fade show active" id="infoAccount" role="tabpanel">
                                <div class="row" style="padding:30px">
                                    <label class="col-sm-12 col-form-label title-section-2" style="font-style: italic">"""),_display_(/*55.121*/Messages("account.info.notice")),format.raw/*55.152*/("""</label>
                                    <div class="col-md-12 m-t-4">
                                        <span class="display-4 title-section-1">"""),_display_(/*57.82*/Messages("account.info.section1")),format.raw/*57.115*/("""</span>
                                    </div>
                                    <div class="col-md-12 m-t-3" style="border: 1px solid #DEDEDE;background-color: white">
                                        <div class="row m-t-3">
                                            <div class="col-md-4 m-t-3">
                                                <div class="row m-b-4">
                                                    <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*63.109*/Messages("Email")),format.raw/*63.126*/("""<span class="text-red">"""),_display_(/*63.150*/Messages("*")),format.raw/*63.163*/("""</span></label>
                                                    <div class="col-sm-8">
                                                        <input id="email" type="email" class="form-control input-form" maxlength="250" value="" readonly>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-4 m-t-3">
                                                <div class="row m-b-4">
                                                    <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*71.109*/Messages("account.info.fullName")),format.raw/*71.142*/("""<span class="text-red">"""),_display_(/*71.166*/Messages("*")),format.raw/*71.179*/("""</span></label>
                                                    <div class="col-sm-8">
                                                        <input id="hoTen" type="text" class="form-control input-form" maxlength="50" required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-4 m-t-3">
                                                <div class="row m-b-4">
                                                    <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*79.109*/Messages("account.info.idNumber")),format.raw/*79.142*/("""</label>
                                                    <div class="col-sm-8">
                                                        <input id="cmnd" type="number" class="form-control input-form" pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==50) return false;" required>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-4 m-t-3">
                                                <div class="row m-b-4">
                                                    <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*90.109*/Messages("account.info.phone")),format.raw/*90.139*/("""<span class="text-red">"""),_display_(/*90.163*/Messages("*")),format.raw/*90.176*/("""</span></label>
                                                    <div class="col-sm-8">
                                                        <input id="sdt" type="number" class="form-control input-form" pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==11) return false;">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-4 m-t-3">
                                                <div class="row m-b-4">
                                                    <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*98.109*/Messages("account.info.birthDate")),format.raw/*98.143*/("""</label>
                                                    <div class="col-sm-8">
                                                        <input id="ngaySinh" type="text" class="form-control input-form date_timepicker" maxlength="50" required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-4 m-t-3">
                                                <div class="row m-b-4">
                                                    <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*106.109*/Messages("account.info.nationality")),format.raw/*106.145*/("""</label>
                                                    <div class="col-sm-8">
                                                        """),format.raw/*108.150*/("""
                                                        """),format.raw/*109.57*/("""<select class="form-control" id="quocTich">
                                                            <option value=""""),_display_(/*110.77*/Messages("account.info.vietnam")),format.raw/*110.109*/("""">"""),_display_(/*110.112*/Messages("account.info.vietnam")),format.raw/*110.144*/("""</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-8 m-t-3">
                                                <div class="row m-b-4">
                                                    <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*120.109*/Messages("account.info.address")),format.raw/*120.141*/("""</label>
                                                    <div class="col-sm-10">
                                                        <div class="row">
                                                            <div class="col-sm-4">
                                                                <select class="form-control" id="tinhTP" onchange="selectDistrict()">
                                                                    <option value="">"""),_display_(/*125.87*/Messages("account.info.province")),format.raw/*125.120*/("""</option>
                                                                </select>
                                                            </div>
                                                            <div class="col-sm-4">
                                                                <select class="form-control" id="quanHuyen" onchange="selectWard()">
                                                                    <option>"""),_display_(/*130.78*/Messages("account.info.district")),format.raw/*130.111*/("""</option>
                                                                </select>
                                                            </div>
                                                            <div class="col-sm-4">
                                                                <select class="form-control" id="phuongXa">
                                                                    <option>"""),_display_(/*135.78*/Messages("account.info.ward")),format.raw/*135.107*/("""</option>
                                                                </select>
                                                            </div>
                                                            <div class="col-sm-12 m-t-3">
                                                                <input id="diaChiChiTiet" type="text" class="form-control input-form" maxlength="250" placeholder=""""),_display_(/*139.165*/Messages("account.info.detailAddress")),format.raw/*139.203*/("""">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-4 m-t-3">
                                                <div class="row m-b-4">
                                                    <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*147.109*/Messages("account.info.gender")),format.raw/*147.140*/("""</label>
                                                    <div class="col-sm-8">
                                                        <select class="form-control" id="gioiTinh">
                                                            <option value="M">"""),_display_(/*150.80*/Messages("account.info.male")),format.raw/*150.109*/("""</option>
                                                            <option value="F">"""),_display_(/*151.80*/Messages("account.info.female")),format.raw/*151.111*/("""</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-2" style="width: 11.9%;">
                                                <label class="col-sm-8 col-form-label title-section-2">"""),_display_(/*160.105*/Messages("account.info.avatar")),format.raw/*160.136*/("""</label>
                                            </div>
                                            <div class="col-md-3 " style="background-color: #F6F6F6;border-radius:3px;height: 140px;padding:0px; line-height: 1;">
                                                <div class="row m-b-2" style="border: 0.5px dashed #C0C0C0; margin:0.5rem; border-radius: 5px; height: 90%;">
                                                    <div class="col-sm-12 position-relative">
                                                        <div class="row" style="padding-top: 0.5rem">
                                                            <div class="col-md-4 position-relative" style="display: flex; align-items: center;justify-content: center;">
                                                                <input id="imgOld1" type="text" class="form-control" hidden>
                                                                <input id="changeImg1" type="checkbox" hidden>
                                                                <div class="d-flex flex-column align-items-center text-center square-item" >
                                                                    <img src=""""),_display_(/*170.80*/routes/*170.86*/.Assets.versioned("images/market/default.png")),format.raw/*170.132*/("""" id="wizardPicturePreview1" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">
                                                                    <input id="wizard-picture-1" name="avatar" type="file" hidden/>
                                                                    <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg1" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(1)"></i></div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-8 position-relative" style="display: inline-table;padding-top: 1rem" >
                                                                <label class="form-label " style="font-size: 16px;color: #727272;font-style: bold">"""),_display_(/*176.149*/Messages("account.info.uploadImage")),format.raw/*176.185*/("""</label><br>
                                                                <label class="form-label " style="font-size:12px">"""),_display_(/*177.116*/Messages("account.info.dragDropFile")),format.raw/*177.153*/("""<a onclick="$('#wizard-picture-1').click();" class="cursor-pointer text-decoration-underline text-danger">"""),_display_(/*177.260*/Messages("account.info.clickHere")),format.raw/*177.294*/("""</a></label>
                                                            </div>
                                                            <div class="col-md-12 position-relative" style="padding-top: 0.5rem;">
                                                                <small class="form-label " style="font-style: italic;font-size: 12px;">"""),_display_(/*180.137*/Messages("account.info.fileRequirement")),format.raw/*180.177*/("""</small>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-2" style="width: 10%">
                                                <label class="col-sm-12 col-form-label title-section-2">"""),_display_(/*187.106*/Messages("account.info.idCard")),format.raw/*187.137*/("""<span class="text-red">"""),_display_(/*187.161*/Messages("*")),format.raw/*187.174*/("""</span></label>
                                            </div>
                                            <div class="col-md-6 ">
                                                <div class="row m-b-4">
                                                    <div class="col-sm-12">
                                                        <div class="row">
                                                            <div class="col-sm-6 " style="background-color: #F6F6F6;border-radius:3px;height: 140px;padding:0px; line-height: 1;width: 48%">
                                                                <div class="row m-b-2" style="border: 0.5px dashed #C0C0C0; margin:0.5rem; border-radius: 5px; height: 90%;">
                                                                    <div class="col-sm-12 position-relative">
                                                                        <div class="row" style="padding-top: 0.5rem">
                                                                            <div class="col-md-4 position-relative" style="display: flex; align-items: center;justify-content: center;">
                                                                                <input id="imgOld2" type="text" class="form-control" hidden>
                                                                                <input id="changeImg2" type="checkbox" hidden>
                                                                                <div class="d-flex flex-column align-items-center text-center square-item" >
                                                                                    <img src=""""),_display_(/*201.96*/routes/*201.102*/.Assets.versioned("images/market/default.png")),format.raw/*201.148*/("""" id="wizardPicturePreview2" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">
                                                                                    <input id="wizard-picture-2" name="avatar" type="file" hidden/>
                                                                                    <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg2" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(2)"></i></div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-8 position-relative" style="display: inline-table;padding-top: 1rem" >
                                                                                <label class="form-label " style="font-size: 16px;color: #727272;font-style: bold">"""),_display_(/*207.165*/Messages("account.info.uploadImage")),format.raw/*207.201*/("""</label><br>
                                                                                <label class="form-label " style="font-size:12px">"""),_display_(/*208.132*/Messages("account.info.dragDropFile")),format.raw/*208.169*/("""<a onclick="$('#wizard-picture-2').click();" class="cursor-pointer text-decoration-underline text-danger">"""),_display_(/*208.276*/Messages("account.info.clickHere")),format.raw/*208.310*/("""</a></label>
                                                                            </div>
                                                                            <div class="col-md-12 position-relative" style="padding-top: 0.5rem;">
                                                                                <small class="form-label " style="font-style: italic;font-size: 12px;">"""),_display_(/*211.153*/Messages("account.info.fileRequirement")),format.raw/*211.193*/("""</small>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6 " style="background-color: #F6F6F6;border-radius:3px;height: 140px;padding:0px;margin-left: 1rem; line-height: 1;width: 48%">
                                                                <div class="row m-b-2" style="border: 0.5px dashed #C0C0C0; margin:0.5rem; border-radius: 5px; height: 90%;">
                                                                    <div class="col-sm-12 position-relative">
                                                                        <div class="row" style="padding-top: 0.5rem">
                                                                            <div class="col-md-4 position-relative" style="display: flex; align-items: center;justify-content: center;">
                                                                                <input id="imgOld3" type="text" class="form-control" hidden>
                                                                                <input id="changeImg3" type="checkbox" hidden>
                                                                                <div class="d-flex flex-column align-items-center text-center square-item" >
                                                                                    <img src=""""),_display_(/*225.96*/routes/*225.102*/.Assets.versioned("images/market/default.png")),format.raw/*225.148*/("""" id="wizardPicturePreview3" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">
                                                                                    <input id="wizard-picture-3" name="avatar" type="file" hidden/>
                                                                                    <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg3" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(3)"></i></div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-8 position-relative" style="display: inline-table;padding-top: 1rem" >
                                                                                <label class="form-label " style="font-size: 16px;color: #727272;font-style: bold">"""),_display_(/*231.165*/Messages("account.info.uploadImage")),format.raw/*231.201*/("""</label><br>
                                                                                <label class="form-label " style="font-size:12px">"""),_display_(/*232.132*/Messages("account.info.dragDropFile")),format.raw/*232.169*/("""<a onclick="$('#wizard-picture-3').click();" class="cursor-pointer text-decoration-underline text-danger">"""),_display_(/*232.276*/Messages("account.info.clickHere")),format.raw/*232.310*/("""</a></label>
                                                                            </div>
                                                                            <div class="col-md-12 position-relative" style="padding-top: 0.5rem;">
                                                                                <small class="form-label " style="font-style: italic;font-size: 12px;">"""),_display_(/*235.153*/Messages("account.info.fileRequirement")),format.raw/*235.193*/("""</small>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-md-1 " style="width: 11.9%">
                                                <label class="col-sm-12 col-form-label title-section-2">"""),_display_(/*247.106*/Messages("account.info.authorization")),format.raw/*247.144*/("""<span class="text-red">"""),_display_(/*247.168*/Messages("*")),format.raw/*247.181*/("""</span></label>
                                                <div class="col-sm-12 col-form-label ">
                                                    <label class="form-label " style="font-size: 12px">"""),_display_(/*249.105*/Messages("account.info.downloadTemplate")),format.raw/*249.146*/("""<a href="/assets/Giay_uy_quyen.docx " download="Giay_uy_quyen.docx" class="cursor-pointer text-danger">"""),_display_(/*249.250*/Messages("account.info.clickHere")),format.raw/*249.284*/("""</a></label>
                                                </div>
                                            </div>
                                            <div class="col-md-3 " style="background-color: #F6F6F6;border-radius:3px;height: 140px;padding:0px; line-height: 1;">
                                                <div class="row m-b-2" style="border: 0.5px dashed #C0C0C0; margin:0.5rem; border-radius: 5px; height: 90%;">
                                                    <div class="col-sm-12 position-relative">
                                                        <div class="row" style="padding-top: 0.5rem">
                                                            <div class="col-md-4 position-relative" style="display: flex; align-items: center;justify-content: center;">
                                                                <input id="imgOld5" type="text" class="form-control" hidden>
                                                                <input id="changeImg5" type="checkbox" hidden>
                                                                <div class="d-flex flex-column align-items-center text-center square-item" >
                                                                    <img src=""""),_display_(/*260.80*/routes/*260.86*/.Assets.versioned("images/market/default.png")),format.raw/*260.132*/("""" id="wizardPicturePreview5" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">
                                                                    <input id="wizard-picture-5" name="avatar" type="file" hidden/>
                                                                    <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg5" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(5)"></i></div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-8 position-relative" style="display: inline-table;padding-top: 1rem" >
                                                                <label class="form-label " style="font-size: 16px;color: #727272;font-style: bold">"""),_display_(/*266.149*/Messages("account.info.uploadImage")),format.raw/*266.185*/("""</label><br>
                                                                <label class="form-label " style="font-size:12px">"""),_display_(/*267.116*/Messages("account.info.dragDropFile")),format.raw/*267.153*/("""<a onclick="$('#wizard-picture-5').click();" class="cursor-pointer text-decoration-underline text-danger">"""),_display_(/*267.260*/Messages("account.info.clickHere")),format.raw/*267.294*/("""</a></label>
                                                            </div>
                                                            <div class="col-md-12 position-relative" style="padding-top: 0.5rem;">
                                                                <small class="form-label " style="font-style: italic;font-size: 12px;">"""),_display_(/*270.137*/Messages("account.info.fileRequirement")),format.raw/*270.177*/("""</small>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>


                                            <div class="col-md-2 " style="width: 10%;">
                                                <label class="col-sm-12 col-form-label title-section-2">"""),_display_(/*279.106*/Messages("account.info.registrationForm")),format.raw/*279.147*/("""<span class="text-red">"""),_display_(/*279.171*/Messages("*")),format.raw/*279.184*/("""</span></label>
                                                <div class="col-md-12 position-relative">
                                                    <label class="form-label" style="font-size: 12px">"""),_display_(/*281.104*/Messages("account.info.downloadTemplate")),format.raw/*281.145*/("""<a href="/assets/Phieu_dang_ky.docx " download="Phieu_dang_ky.docx" class="cursor-pointer text-danger">"""),_display_(/*281.249*/Messages("account.info.clickHere")),format.raw/*281.283*/("""</a></label>
                                                </div>
                                            </div>
                                            <div class="col-md-3 " style="background-color: #F6F6F6;border-radius:3px;height: 140px;padding:0px; line-height: 1;width: 24%">
                                                <div class="row m-b-2" style="border: 0.5px dashed #C0C0C0; margin:0.5rem; border-radius: 5px; height: 90%;">
                                                    <div class="col-sm-12 position-relative">
                                                        <div class="row" style="padding-top: 0.5rem">
                                                            <div class="col-md-4 position-relative" style="display: flex; align-items: center;justify-content: center;">
                                                                <input id="imgOld6" type="text" class="form-control" hidden>
                                                                <input id="changeImg6" type="checkbox" hidden>
                                                                <div class="d-flex flex-column align-items-center text-center square-item" >
                                                                    <img src=""""),_display_(/*292.80*/routes/*292.86*/.Assets.versioned("images/market/default.png")),format.raw/*292.132*/("""" id="wizardPicturePreview6" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">
                                                                    <input id="wizard-picture-6" name="avatar" type="file" hidden/>
                                                                    <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg6" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(6)"></i></div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-8 position-relative" style="display: inline-table;padding-top: 1rem" >
                                                                <label class="form-label " style="font-size: 16px;color: #727272;font-style: bold">"""),_display_(/*298.149*/Messages("account.info.uploadImage")),format.raw/*298.185*/("""</label><br>
                                                                <label class="form-label " style="font-size:12px">"""),_display_(/*299.116*/Messages("account.info.dragDropFile")),format.raw/*299.153*/("""<a onclick="$('#wizard-picture-6').click();" class="cursor-pointer text-decoration-underline text-danger">"""),_display_(/*299.260*/Messages("account.info.clickHere")),format.raw/*299.294*/("""</a></label>
                                                            </div>
                                                            <div class="col-md-12 position-relative" style="padding-top: 0.5rem;">
                                                                <small class="form-label " style="font-style: italic;font-size: 12px;">"""),_display_(/*302.137*/Messages("account.info.fileRequirement")),format.raw/*302.177*/("""</small>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div style="padding: 10px">
                                                <hr style="border-top: 2px solid #000000; ">
                                            </div>
                                            <div class="row" style="padding:15px">
                                                <div class="col-md-12 m-t-4">
                                                    <span class="display-4 title-section-1">"""),_display_(/*313.94*/Messages("account.contact.other")),format.raw/*313.127*/("""</span>
                                                </div>
                                                <div class="col-md-12 m-t-3">
                                                    <div class="row m-t-3">
                                                        <div class="col-md-6 m-t-3">
                                                            <div class="row m-b-4">
                                                                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*319.121*/Messages("account.contact.email")),format.raw/*319.154*/("""</label>
                                                                <div class="col-sm-8">
                                                                    <input id="emailContact" type="email" placeholder=""""),_display_(/*321.121*/Messages("account.contact.emailPlaceholder")),format.raw/*321.165*/("""" class="form-control input-form" maxlength="250" value="" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6 m-t-3">
                                                            <div class="row m-b-4">
                                                                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*327.121*/Messages("account.contact.phone")),format.raw/*327.154*/("""</label>
                                                                <div class="col-sm-6">
                                                                    <input id="sdtContact" type="number" placeholder=""""),_display_(/*329.120*/Messages("account.contact.phonePlaceholder")),format.raw/*329.164*/("""" class="form-control input-form" pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==11) return false;">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12 m-t-1">
                                                    <label class="col-sm-12 col-form-label title-section-3" style="font-style: italic">"""),_display_(/*336.137*/Messages("account.contact.notice")),format.raw/*336.171*/("""</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-12 m-t-3">
                                                <label class="col-form-label title-section-2" id="notiApprovedAccount"></label>
                                            </div>
                                            <div class="row m-t-2 m-b-4">
                                                <div class="col-md-12 mx-auto text-center">
                                                    <button type="button" class="btn btn-telco" style="background: #EA0033; color: #FFFFFF;" onclick="getOtpUpdateInfoAcc();">"""),_display_(/*344.176*/Messages("btnComfirm")),format.raw/*344.198*/("""</button>
                                                </div>
                                            </div>
                                        </div>


                                    </div>
                                    <hr style="border-top: 1px solid #DEDEDE;">

                                    <div class="row" id="tab_info_company">
                                        <div class="col-md-12">
                                            <span class="display-4 title-section-1">"""),_display_(/*355.86*/Messages("account.enterprise.section2")),format.raw/*355.125*/("""</span>
                                        </div>

                                        <input id="id_doanh_nghiep_0" class="id_doanh_nghiep" hidden readonly>
                                        <div class="col-md-12 m-t-3" id="tt_doanh_nghiep_0" stt="0" style="border: 1px solid #a2a2a2;">
                                            <div class="row m-t-3">
                                                <div class="col-md-8">
                                                    <div class="row m-b-4">
                                                        <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*363.113*/Messages("account.enterprise.name")),format.raw/*363.148*/("""<span class="text-red">"""),_display_(/*363.172*/Messages("*")),format.raw/*363.185*/("""</span></label>
                                                        <div class="col-sm-10">
                                                            <input id="tenDoanhNghiep_0" type="text" class="form-control input-form" maxlength="250" value="">
                                                        </div>
                                                    </div>
                                                    <div class="row m-b-4">
                                                        <div class="col-sm-6">
                                                            <div class="row">
                                                                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*371.121*/Messages("account.enterprise.taxCode")),format.raw/*371.159*/("""<span class="text-red">"""),_display_(/*371.183*/Messages("*")),format.raw/*371.196*/("""</span></label>
                                                                <div class="col-sm-8">
                                                                    <input id="maSoThue_0" type="text" class="form-control input-form" maxlength="250" value="">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <div class="row">
                                                                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*379.121*/Messages("account.enterprise.licenseNumber")),format.raw/*379.165*/("""<span class="text-red">"""),_display_(/*379.189*/Messages("*")),format.raw/*379.202*/("""</span></label>
                                                                <div class="col-sm-8">
                                                                    <input id="soGpkd_0" type="text" class="form-control input-form" maxlength="250" value="">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row m-b-4">
                                                        <div class="col-sm-6">
                                                            <div class="row">
                                                                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*389.121*/Messages("account.enterprise.establishDate")),format.raw/*389.165*/("""<span class="text-red">"""),_display_(/*389.189*/Messages("*")),format.raw/*389.202*/("""</span></label>
                                                                <div class="col-sm-8">
                                                                    <input id="ngayThanhLap_0" type="text" class="form-control input-form date_timepicker" maxlength="250">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <div class="row">
                                                                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*397.121*/Messages("account.enterprise.phone")),format.raw/*397.157*/("""</label>
                                                                <div class="col-sm-8">
                                                                    <input id="sdtDN_0" type="number" class="form-control input-form" pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==11) return false;">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row m-b-4">
                                                        <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*405.113*/Messages("Email DN")),format.raw/*405.133*/("""</label>
                                                        <div class="col-sm-10">
                                                            <input id="emailDN_0" type="text" class="form-control input-form" maxlength="250">
                                                        </div>
                                                    </div>
                                                    <div class="row m-b-3">
                                                        <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*411.113*/Messages("account.info.address")),format.raw/*411.145*/("""<span class="text-red">"""),_display_(/*411.169*/Messages("*")),format.raw/*411.182*/("""</span></label>
                                                        <div class="col-sm-10">
                                                            <div class="row">
                                                                <div class="col-sm-4">
                                                                    <select class="form-control" id="tinhTpDN_0" onchange="selectDistrictDN(0)">
                                                                        <option value="">"""),_display_(/*416.91*/Messages("account.info.province")),format.raw/*416.124*/("""</option>
                                                                    </select>
                                                                </div>
                                                                <div class="col-sm-4">
                                                                    <select class="form-control" id="quanHuyenDN_0" onchange="selectWardDN(0)">
                                                                        <option value="">"""),_display_(/*421.91*/Messages("account.info.district")),format.raw/*421.124*/("""</option>
                                                                    </select>
                                                                </div>
                                                                <div class="col-sm-4">
                                                                    <select class="form-control" id="phuongXaDN_0">
                                                                        <option value="">"""),_display_(/*426.91*/Messages("account.info.ward")),format.raw/*426.120*/("""</option>
                                                                    </select>
                                                                </div>
                                                                <div class="col-sm-12 m-t-3">
                                                                    <input id="diaChiChiTietDN_0" type="text" class="form-control input-form" maxlength="250" placeholder="Địa chỉ chi tiết">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row m-b-3">
                                                        <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*436.113*/Messages("account.enterprise.field")),format.raw/*436.149*/("""<span class="text-red">"""),_display_(/*436.173*/Messages("*")),format.raw/*436.186*/("""</span></label>
                                                        <div class="col-sm-10">
                                                            <select class="form-control" id="linhVuc_0" multiple="multiple">

                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="row m-b-3">
                                                        <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*444.113*/Messages("account.enterprise.deviceType")),format.raw/*444.154*/("""<span class="text-red">"""),_display_(/*444.178*/Messages("*")),format.raw/*444.191*/("""</span></label>
                                                        <div class="col-sm-10">
                                                            <select class="form-control" id="dongThietBi_0" multiple="multiple">

                                                            </select>
                                                        </div>
                                                    </div>

                                                </div>

                                                <div class="col-md-4">
                                                    <div class="row m-b-4">
                                                        <label class="col-sm-12 col-form-label title-section-2">"""),_display_(/*456.114*/Messages("account.enterprise.licenseImage")),format.raw/*456.157*/("""<span class="text-red">"""),_display_(/*456.181*/Messages("*")),format.raw/*456.194*/("""</span></label>
                                                        <div class="col-sm-12 position-relative">
                                                            <div class="row">
                                                                <div class="col-md-4 position-relative">
                                                                    <input id="imgOld4_0" type="text" class="form-control" hidden>
                                                                    <input id="changeImg4_0" type="checkbox" hidden>
                                                                    <div class="d-flex flex-column align-items-center text-center square-item" >
                                                                        <img src=""""),_display_(/*463.84*/routes/*463.90*/.Assets.versioned("images/market/default.png")),format.raw/*463.136*/("""" id="wizardPicturePreview4_0" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">
                                                                        <input id="wizard-picture-4_0" name="avatar" type="file" hidden/>
                                                                        """),format.raw/*465.252*/("""
                                                                    """),format.raw/*466.69*/("""</div>
                                                                </div>
                                                                <div class="col-md-8 position-relative">
                                                                    <label class="form-label ">"""),_display_(/*469.97*/Messages("Upload image")),format.raw/*469.121*/("""</label><br>
                                                                    <label class="form-label ">"""),_display_(/*470.97*/Messages("account.info.dragDropImageFile")),format.raw/*470.139*/("""<a onclick="$('#wizard-picture-4_0').click();" class="cursor-pointer text-danger">"""),_display_(/*470.222*/Messages("account.info.clickHere")),format.raw/*470.256*/("""</a></label>
                                                                </div>
                                                                <div class="col-md-12 position-relative">
                                                                    <small class="form-label ">"""),_display_(/*473.97*/Messages("account.info.fileRequirement")),format.raw/*473.137*/("""</small>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="col-md-12">
                                                    <div class="row m-t-3">
                                                        <label class="col-sm-12 col-form-label title-section-2" id="notiApproved_0"></label>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row m-t-2 m-b-4">
                                                <div class="col-md-12 mx-auto text-center">
                                                    <button type="button" class="btn btn-telco" style="background: #EA0033; color: #FFFFFF;" onclick="getOtpUpdateEnterprise(0)">"""),_display_(/*489.179*/Messages("btnComfirm")),format.raw/*489.201*/("""</button>
                                                </div>
                                            </div>
                                        </div>

                                    </div>

                                    <div class="col-md-12">
                                        <div class="row m-t-3">
                                            <label class="col-sm-12 col-form-label title-section-2" style="text-align: right;">
                                                <a onclick="addFormInfoCompany()" style="color: green; cursor: pointer; font-weight: 600;">"""),_display_(/*499.141*/Messages("account.enterprise.add")),format.raw/*499.175*/("""</a></label>
                                        </div>
                                    </div>
                                    <hr style="border-top: 1px solid #DEDEDE;">
                                </div>
                            </div>

                            <div class="tab-pane fade" id="enterpriseLv2" style="margin-bottom: 2rem;margin-top: 1rem" role="tabpanel">
                                """),_display_(/*507.34*/views/*507.39*/.html.telco.childUser.ChildUserList_formSearch(currentUser)),format.raw/*507.98*/("""

                                """),format.raw/*509.33*/("""<div class="card">
                                    <div class="table-responsive" style="border-radius: 8px;">
                                        <table class="table table-striped" id="listChildUserTable" style="width: 100%;">
                                            <thead style="background-color: #FBCCD6;">
                                                <tr>
                                                    <th>"""),_display_(/*514.58*/Messages("account.table.stt")),format.raw/*514.87*/("""</th>
                                                    <th>"""),_display_(/*515.58*/Messages("account.table.fullName")),format.raw/*515.92*/("""</th>
                                                    <th>"""),_display_(/*516.58*/Messages("account.table.email")),format.raw/*516.89*/("""</th>
                                                    <th>"""),_display_(/*517.58*/Messages("account.table.phone")),format.raw/*517.89*/("""</th>
                                                    <th style="text-align: center;">"""),_display_(/*518.86*/Messages("account.table.permission")),format.raw/*518.122*/("""</th>
                                                    <th style="text-align: center;">"""),_display_(/*519.86*/Messages("account.table.resetPassword")),format.raw/*519.125*/("""</th>
                                                    <th style="text-align: center;">"""),_display_(/*520.86*/Messages("account.table.delete")),format.raw/*520.118*/("""</th>

                                                </tr>
                                            </thead>
                                            <tbody>
                                            </tbody>
                                        </table>
                                        <h5 id="notiNotData" style="text-align: center;"></h5>
                                    </div>
                                    <div class="material-datatables row row-cols-auto g-3" style="margin: 5px; margin-bottom: 10px;" id="divPagingTable">
                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="dropdown">
                                                    <button class="btn dropdown-toggle text-white" type="button" data-bs-toggle="dropdown" aria-expanded="false" id="countPageSize" style="background-color: rgb(0 0 0 / 50%);; margin-left: 5px;">10</button>
                                                    <ul class="dropdown-menu">
                                                        <li><a class="dropdown-item" href="javascript:ApplyFilter(1,10,true)">10</a></li>
                                                        <li><a class="dropdown-item" href="javascript:ApplyFilter(1,50,true)">50</a></li>
                                                        <li><a class="dropdown-item" href="javascript:ApplyFilter(1,100,true)">100</a></li>
                                                        <li><a class="dropdown-item" href="javascript:ApplyFilter(1,200,true)">200</a></li>
                                                        <li><a class="dropdown-item" href="javascript:ApplyFilter(1,500,true)">500</a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="col-md-8">
                                                <div class="dataTables_paginate paging_full_numbers" id="pagingTable" style="cursor: pointer; right: 5px; position: absolute;"></div>
                                            </div>
                                        </div>

                                        <input name="page" id="page" value="1" style="display: none">
                                        <input name="pageSize" id="pageSize" value="10" style="display: none">
                                        <input name="isResetPage" id="isResetPage" value="false" style="display: none">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    """),_display_(/*557.22*/views/*557.27*/.html.telco.account.Account_otp()),format.raw/*557.60*/("""
                    """),_display_(/*558.22*/views/*558.27*/.html.telco.account.Account_zoomImg()),format.raw/*558.64*/("""
                    """),_display_(/*559.22*/views/*559.27*/.html.telco.account.Account_updateInfoAcc()),format.raw/*559.70*/("""
                    """),_display_(/*560.22*/views/*560.27*/.html.telco.account.Account_updateEnterprise()),format.raw/*560.73*/("""
                    """),_display_(/*561.22*/views/*561.27*/.html.telco.account.Account_delEnterprise()),format.raw/*561.70*/("""
                    """),_display_(/*562.22*/views/*562.27*/.html.telco.childUser.ChildUserList_add()),format.raw/*562.68*/("""
                    """),_display_(/*563.22*/views/*563.27*/.html.telco.childUser.ChildUserList_genPass()),format.raw/*563.72*/("""
                    """),_display_(/*564.22*/views/*564.27*/.html.telco.childUser.ChildUserList_genPass_comfirm()),format.raw/*564.80*/("""
                    """),_display_(/*565.22*/views/*565.27*/.html.telco.childUser.ChildUserList_del()),format.raw/*565.68*/("""
                    """),_display_(/*566.22*/views/*566.27*/.html.telco.childUser.ChildUserList_editRole()),format.raw/*566.73*/("""


                    """),_display_(/*569.22*/views/*569.27*/.html.Loading()),format.raw/*569.42*/("""

                """),format.raw/*571.17*/("""</div>
            </div>
    </body>
    <script>
            var imgDefault = '"""),_display_(/*575.32*/routes/*575.38*/.Assets.versioned("images/market/default.png")),format.raw/*575.84*/("""';
            var userId = '"""),_display_(/*576.28*/userId),format.raw/*576.34*/("""';

            //            $(document).ready(function () """),format.raw/*578.57*/("""{"""),format.raw/*578.58*/("""
            """),format.raw/*579.13*/("""//                $("#menu-childUser").addClass("mm-active");
            //                $("#menu").metisMenu();
            //            """),format.raw/*581.27*/("""}"""),format.raw/*581.28*/(""")
    </script>
    <script src=""""),_display_(/*583.19*/routes/*583.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*583.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*584.19*/routes/*584.25*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*584.85*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*586.19*/routes/*586.25*/.Assets.versioned("javascripts/views/telco/childUser/ChildUser.js")),format.raw/*586.92*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*587.19*/routes/*587.25*/.Assets.versioned("javascripts/views/telco/childUser/ChildUser_add.js")),format.raw/*587.96*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*588.19*/routes/*588.25*/.Assets.versioned("javascripts/views/telco/childUser/ChildUser_pass.js")),format.raw/*588.97*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*589.19*/routes/*589.25*/.Assets.versioned("javascripts/views/telco/childUser/ChildUser_del.js")),format.raw/*589.96*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*590.19*/routes/*590.25*/.Assets.versioned("javascripts/views/telco/childUser/ChildUser_role.js")),format.raw/*590.97*/("""" type="text/javascript"></script>


    <script type="text/javascript" src=""""),_display_(/*593.42*/routes/*593.48*/.JsController.jsMessages()),format.raw/*593.74*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*594.42*/routes/*594.48*/.JsController.javascriptRoutes),format.raw/*594.78*/(""""></script>
    <script src=""""),_display_(/*595.19*/routes/*595.25*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*595.79*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*597.19*/routes/*597.25*/.Assets.versioned("javascripts/landingPage/jquery.min.js")),format.raw/*597.83*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*598.19*/routes/*598.25*/.Assets.versioned("javascripts/landingPage/popper.min.js")),format.raw/*598.83*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*599.19*/routes/*599.25*/.Assets.versioned("javascripts/landingPage/bootstrap.min.js")),format.raw/*599.86*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*600.19*/routes/*600.25*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*600.79*/(""""></script>
    <script src=""""),_display_(/*601.19*/routes/*601.25*/.Assets.versioned("javascripts/landingPage/argon-design-system.js?v=1.2.2")),format.raw/*601.100*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*603.19*/routes/*603.25*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/moment.min.js")),format.raw/*603.111*/(""""></script>
    <script src=""""),_display_(/*604.19*/routes/*604.25*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.min.js")),format.raw/*604.138*/(""""></script>

    <script src=""""),_display_(/*606.19*/routes/*606.25*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*606.92*/(""""></script>
    <script src=""""),_display_(/*607.19*/routes/*607.25*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*607.98*/(""""></script>
    <script src=""""),_display_(/*608.19*/routes/*608.25*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*608.107*/(""""></script>
    <script src=""""),_display_(/*609.19*/routes/*609.25*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*609.77*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*611.19*/routes/*611.25*/.Assets.versioned("assets/plugins/select2/js/select2.min.js")),format.raw/*611.86*/(""""></script>

    <script src=""""),_display_(/*613.19*/routes/*613.25*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*613.85*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*614.19*/routes/*614.25*/.Assets.versioned("javascripts/views/telco/account/account_typeBusiness.js")),format.raw/*614.101*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*616.19*/routes/*616.25*/.Assets.versioned("javascripts/views/telco/account/account.js")),format.raw/*616.88*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*617.19*/routes/*617.25*/.Assets.versioned("javascripts/views/telco/account/account_verify.js")),format.raw/*617.95*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*618.19*/routes/*618.25*/.Assets.versioned("javascripts/views/telco/account/account_area.js")),format.raw/*618.93*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*619.19*/routes/*619.25*/.Assets.versioned("javascripts/views/telco/account/account_editGpkd.js")),format.raw/*619.97*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*620.19*/routes/*620.25*/.Assets.versioned("javascripts/views/telco/account/account_updateInfoAcc.js")),format.raw/*620.102*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*621.19*/routes/*621.25*/.Assets.versioned("javascripts/views/telco/account/account_updateEnterprise.js")),format.raw/*621.105*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*622.19*/routes/*622.25*/.Assets.versioned("javascripts/views/telco/account/account_delEnterprise.js")),format.raw/*622.102*/("""" type="text/javascript"></script>

    """),_display_(/*624.6*/views/*624.11*/.html.BackToTop()),format.raw/*624.28*/("""

    """),format.raw/*626.5*/("""<script>
            var userId = '"""),_display_(/*627.28*/userId),format.raw/*627.34*/("""';
            var phoneUser = "";
            var imgDefault = '"""),_display_(/*629.32*/routes/*629.38*/.Assets.versioned("images/market/default.png")),format.raw/*629.84*/("""';
            $('.date_timepicker').bootstrapMaterialDatePicker("""),format.raw/*630.63*/("""{"""),format.raw/*630.64*/("""
                """),format.raw/*631.17*/("""format: 'DD/MM/YYYY',
                time: false
            """),format.raw/*633.13*/("""}"""),format.raw/*633.14*/(""");
    </script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,userId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,userId)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,userId) => apply(currentUser,userId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:50 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/account/Account.scala.html
                  HASH: 15b3a07c62a38c4c7b86424eff4ad96e8e7c4053
                  MATRIX: 665->1|688->18|1032->52|1160->85|1187->86|1377->250|1422->275|1507->333|1522->339|1579->375|1799->675|1836->685|1850->690|1896->715|1932->724|1972->737|1987->743|2062->797|2132->840|2147->846|2232->910|2302->953|2317->959|2407->1028|2477->1071|2492->1077|2554->1118|2612->1238|2648->1247|2688->1260|2703->1266|2773->1315|2840->1355|2855->1361|2952->1436|3020->1477|3035->1483|3172->1598|3242->1641|3257->1647|3341->1710|3411->1753|3426->1759|3517->1829|3588->1873|3603->1879|3688->1943|3758->1986|3773->1992|3848->2046|3918->2089|3933->2095|4017->2158|4117->2231|4131->2236|4193->2277|4230->2287|4244->2292|4296->2323|4332->2332|4862->2834|4912->2862|4973->2895|5306->3200|5365->3237|5426->3270|5887->3703|5940->3734|6123->3890|6178->3923|6698->4415|6737->4432|6789->4456|6824->4469|7515->5132|7570->5165|7622->5189|7657->5202|8337->5854|8392->5887|9236->6703|9288->6733|9340->6757|9375->6770|10110->7477|10166->7511|10859->8175|10918->8211|11088->8444|11174->8501|11322->8621|11377->8653|11409->8656|11464->8688|12093->9288|12148->9320|12638->9782|12694->9815|13166->10259|13222->10292|13669->10711|13721->10740|14155->11145|14216->11183|14796->11734|14850->11765|15141->12028|15193->12057|15310->12146|15364->12177|15933->12717|15987->12748|17217->13950|17233->13956|17302->14002|18267->14938|18326->14974|18483->15102|18543->15139|18679->15246|18736->15280|19112->15627|19175->15667|19699->16162|19753->16193|19806->16217|19842->16230|21523->17883|21540->17889|21609->17935|22670->18967|22729->19003|22902->19147|22962->19184|23098->19291|23155->19325|23579->19720|23642->19760|25368->21458|25385->21464|25454->21510|26515->22542|26574->22578|26747->22722|26807->22759|26943->22866|27000->22900|27424->23295|27487->23335|28323->24142|28384->24180|28437->24204|28473->24217|28710->24425|28774->24466|28907->24570|28964->24604|30253->25865|30269->25871|30338->25917|31303->26853|31362->26889|31519->27017|31579->27054|31715->27161|31772->27195|32148->27542|32211->27582|32739->28081|32803->28122|32856->28146|32892->28159|33130->28368|33194->28409|33327->28513|33384->28547|34683->29818|34699->29824|34768->29870|35733->30806|35792->30842|35949->30970|36009->31007|36145->31114|36202->31148|36578->31495|36641->31535|37443->32309|37499->32342|38034->32848|38090->32881|38335->33097|38402->33141|38990->33700|39046->33733|39290->33948|39357->33992|40029->34635|40086->34669|40824->35378|40869->35400|41411->35914|41473->35953|42132->36583|42190->36618|42243->36642|42279->36655|43038->37385|43099->37423|43152->37447|43188->37460|43959->38202|44026->38246|44079->38270|44115->38283|45019->39158|45086->39202|45139->39226|45175->39239|45957->39992|46016->40028|46803->40786|46846->40806|47417->41348|47472->41380|47525->41404|47561->41417|48085->41913|48141->41946|48649->42426|48705->42459|49185->42911|49237->42940|50157->43831|50216->43867|50269->43891|50305->43904|50936->44506|51000->44547|51053->44571|51089->44584|51853->45319|51919->45362|51972->45386|52008->45399|52809->46172|52825->46178|52894->46224|53260->46739|53358->46808|53665->47087|53712->47111|53849->47220|53914->47262|54026->47345|54083->47379|54397->47665|54460->47705|55613->48829|55658->48851|56287->49451|56344->49485|56799->49912|56814->49917|56895->49976|56958->50010|57418->50442|57469->50471|57560->50534|57616->50568|57707->50631|57760->50662|57851->50725|57904->50756|58023->50847|58082->50883|58201->50974|58263->51013|58382->51104|58437->51136|61293->53964|61308->53969|61363->54002|61413->54024|61428->54029|61487->54066|61537->54088|61552->54093|61617->54136|61667->54158|61682->54163|61750->54209|61800->54231|61815->54236|61880->54279|61930->54301|61945->54306|62008->54347|62058->54369|62073->54374|62140->54419|62190->54441|62205->54446|62280->54499|62330->54521|62345->54526|62408->54567|62458->54589|62473->54594|62541->54640|62593->54664|62608->54669|62645->54684|62692->54702|62802->54784|62818->54790|62886->54836|62944->54866|62972->54872|63061->54932|63091->54933|63133->54946|63304->55088|63334->55089|63396->55123|63412->55129|63493->55188|63574->55241|63590->55247|63672->55307|63754->55361|63770->55367|63859->55434|63940->55487|63956->55493|64049->55564|64130->55617|64146->55623|64240->55695|64321->55748|64337->55754|64430->55825|64511->55878|64527->55884|64621->55956|64727->56034|64743->56040|64791->56066|64872->56119|64888->56125|64940->56155|64998->56185|65014->56191|65090->56245|65172->56299|65188->56305|65268->56363|65349->56416|65365->56422|65445->56480|65526->56533|65542->56539|65625->56600|65706->56653|65722->56659|65798->56713|65856->56743|65872->56749|65970->56824|66052->56878|66068->56884|66177->56970|66235->57000|66251->57006|66387->57119|66446->57150|66462->57156|66551->57223|66609->57253|66625->57259|66720->57332|66778->57362|66794->57368|66899->57450|66957->57480|66973->57486|67047->57538|67129->57592|67145->57598|67228->57659|67287->57690|67303->57696|67385->57756|67466->57809|67482->57815|67581->57891|67663->57945|67679->57951|67764->58014|67845->58067|67861->58073|67953->58143|68034->58196|68050->58202|68140->58270|68221->58323|68237->58329|68331->58401|68412->58454|68428->58460|68528->58537|68609->58590|68625->58596|68728->58676|68809->58729|68825->58735|68925->58812|68993->58853|69008->58858|69047->58875|69081->58881|69145->58917|69173->58923|69267->58989|69283->58995|69351->59041|69445->59106|69475->59107|69521->59124|69612->59186|69642->59187
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|46->14|47->15|47->15|47->15|48->16|48->16|48->16|48->16|49->17|49->17|49->17|50->18|50->18|50->18|51->19|51->19|51->19|53->21|54->22|54->22|54->22|54->22|55->23|55->23|55->23|56->24|56->24|56->24|58->26|58->26|58->26|59->27|59->27|59->27|61->29|61->29|61->29|62->30|62->30|62->30|63->31|63->31|63->31|68->36|68->36|68->36|69->37|69->37|69->37|70->38|76->44|76->44|77->45|80->48|80->48|81->49|87->55|87->55|89->57|89->57|95->63|95->63|95->63|95->63|103->71|103->71|103->71|103->71|111->79|111->79|122->90|122->90|122->90|122->90|130->98|130->98|138->106|138->106|140->108|141->109|142->110|142->110|142->110|142->110|152->120|152->120|157->125|157->125|162->130|162->130|167->135|167->135|171->139|171->139|179->147|179->147|182->150|182->150|183->151|183->151|192->160|192->160|202->170|202->170|202->170|208->176|208->176|209->177|209->177|209->177|209->177|212->180|212->180|219->187|219->187|219->187|219->187|233->201|233->201|233->201|239->207|239->207|240->208|240->208|240->208|240->208|243->211|243->211|257->225|257->225|257->225|263->231|263->231|264->232|264->232|264->232|264->232|267->235|267->235|279->247|279->247|279->247|279->247|281->249|281->249|281->249|281->249|292->260|292->260|292->260|298->266|298->266|299->267|299->267|299->267|299->267|302->270|302->270|311->279|311->279|311->279|311->279|313->281|313->281|313->281|313->281|324->292|324->292|324->292|330->298|330->298|331->299|331->299|331->299|331->299|334->302|334->302|345->313|345->313|351->319|351->319|353->321|353->321|359->327|359->327|361->329|361->329|368->336|368->336|376->344|376->344|387->355|387->355|395->363|395->363|395->363|395->363|403->371|403->371|403->371|403->371|411->379|411->379|411->379|411->379|421->389|421->389|421->389|421->389|429->397|429->397|437->405|437->405|443->411|443->411|443->411|443->411|448->416|448->416|453->421|453->421|458->426|458->426|468->436|468->436|468->436|468->436|476->444|476->444|476->444|476->444|488->456|488->456|488->456|488->456|495->463|495->463|495->463|497->465|498->466|501->469|501->469|502->470|502->470|502->470|502->470|505->473|505->473|521->489|521->489|531->499|531->499|539->507|539->507|539->507|541->509|546->514|546->514|547->515|547->515|548->516|548->516|549->517|549->517|550->518|550->518|551->519|551->519|552->520|552->520|589->557|589->557|589->557|590->558|590->558|590->558|591->559|591->559|591->559|592->560|592->560|592->560|593->561|593->561|593->561|594->562|594->562|594->562|595->563|595->563|595->563|596->564|596->564|596->564|597->565|597->565|597->565|598->566|598->566|598->566|601->569|601->569|601->569|603->571|607->575|607->575|607->575|608->576|608->576|610->578|610->578|611->579|613->581|613->581|615->583|615->583|615->583|616->584|616->584|616->584|618->586|618->586|618->586|619->587|619->587|619->587|620->588|620->588|620->588|621->589|621->589|621->589|622->590|622->590|622->590|625->593|625->593|625->593|626->594|626->594|626->594|627->595|627->595|627->595|629->597|629->597|629->597|630->598|630->598|630->598|631->599|631->599|631->599|632->600|632->600|632->600|633->601|633->601|633->601|635->603|635->603|635->603|636->604|636->604|636->604|638->606|638->606|638->606|639->607|639->607|639->607|640->608|640->608|640->608|641->609|641->609|641->609|643->611|643->611|643->611|645->613|645->613|645->613|646->614|646->614|646->614|648->616|648->616|648->616|649->617|649->617|649->617|650->618|650->618|650->618|651->619|651->619|651->619|652->620|652->620|652->620|653->621|653->621|653->621|654->622|654->622|654->622|656->624|656->624|656->624|658->626|659->627|659->627|661->629|661->629|661->629|662->630|662->630|663->631|665->633|665->633
                  -- GENERATED --
              */
          