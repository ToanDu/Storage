
package views.html.telco.role.account

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
/*1.2*/import vn.m2m.utils.DateUtil
/*2.2*/import vn.m2m.common.models.User

object InfoAccountCmp extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.35*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("Thông tin tài khoản")),format.raw/*9.44*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*17.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("assets/plugins/input-tags/css/tagsinput.css")),format.raw/*18.88*/("""" rel="stylesheet" />
    <link href='"""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*19.73*/("""' type='text/css'>
    <link href=""""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*20.99*/("""" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" >
    <link href=""""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*22.139*/("""" rel="stylesheet" >

    <link href=""""),_display_(/*24.18*/routes/*24.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*24.78*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*28.6*/views/*28.11*/.html.telco.role.Menu(currentUser)),format.raw/*28.45*/("""

    """),_display_(/*30.6*/views/*30.11*/.html.telco.Header(currentUser)),format.raw/*30.42*/("""

    """),format.raw/*32.5*/("""<div class="page-wrapper">
      <div class="page-content">

        <div class="card">
          <div class="card-body">
            <span class="text-search">"""),_display_(/*37.40*/Messages("Thông tin cá nhân")),format.raw/*37.69*/("""</span>
            <div class="row">
              <input id="id" type="text" class="form-control input-form" readonly hidden>
              <div class="col-md-6">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*42.75*/Messages("Họ tên")),format.raw/*42.93*/("""</label>
                  <div class="col-sm-8">
                    <input id="fullName" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="50">
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*50.75*/Messages("Quyền tài khoản")),format.raw/*50.102*/("""</label>
                  <div class="col-sm-8">
                    <input id="roleCmp" type="text" class="form-control input-form" placeholder="Nhập nội dung" readonly>
                  </div>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-md-6">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*61.75*/Messages("Email")),format.raw/*61.92*/("""</label>
                  <div class="col-sm-8">
                    <input id="email" type="text" class="form-control input-form" placeholder="Nhập nội dung" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*69.75*/Messages("Số điện thoại")),format.raw/*69.100*/("""</label>
                  <div class="col-sm-8">
                    <input id="phone" type="text" class="form-control input-form" placeholder="Nhập nội dung" onkeypress="return isNumberKey(event)" maxlength="11">
                  </div>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-md-6">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*80.75*/Messages("CMT/CCCD")),format.raw/*80.95*/("""</label>
                  <div class="col-sm-8">
                    <input id="cmnd" type="text" class="form-control input-form" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*88.75*/Messages("Ngày sinh")),format.raw/*88.96*/("""</label>
                  <div class="col-sm-8">
                    <input id="ngaySinh" type="text" class="form-control input-form" readonly>
                  </div>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-md-12">
                <div class="row mt-3">
                  <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*99.75*/Messages("Địa chỉ chi tiết")),format.raw/*99.103*/("""</label>
                  <div class="col-sm-10">
                    <div class="row">
                      <div class="col-sm-4">
                        <input id="tinh" type="text" class="form-control input-form" readonly>
                      </div>
                      <div class="col-sm-4" >
                        <input id="quan" type="text" class="form-control input-form" readonly>
                      </div>
                      <div class="col-sm-4">
                        <input id="phuong" type="text" class="form-control input-form" readonly>
                      </div>
                      <div class="col-sm-12 mt-3">
                        <input id="diaChi" type="text" class="form-control input-form" readonly>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="d-flex flex-column align-items-center text-center">
              <div class="">
                <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033; width: 270px; display: none;" id="buttonImportEnterprise" data-bs-toggle="modal" data-bs-target="#importAddEnterpriseModal" onclick="setImportEnterprise()">"""),_display_(/*122.267*/Messages("Import doanh nghiệp")),format.raw/*122.298*/("""</button>
                <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033; width: 180px; display: none;" id="buttonAddEnterprise" data-bs-toggle="modal" data-bs-target="#addEnterpriseModal">"""),_display_(/*123.226*/Messages("Thêm doanh nghiệp")),format.raw/*123.255*/("""</button>
                <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033; width: 180px; display: none;" id="buttonResetEnterprise" data-bs-toggle="modal" data-bs-target="#comfirmGenPassModal">"""),_display_(/*124.229*/Messages("Reset mật khẩu")),format.raw/*124.255*/("""</button>
                <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF; width: 180px; display: none;" id="buttonUpdateEnterprise" onclick="processSubmitUpdateEnterprise()">"""),_display_(/*125.211*/Messages("Cập nhật")),format.raw/*125.231*/("""</button>
              </div>
            </div>
          </div>
        </div>

        <div class="card" id="listEnterprise" style="display: none;">
          <div class="table-responsive mb-3" style="border-radius: 8px;">
            <table class="table table-striped" id="listEnterpriseTable" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th>"""),_display_(/*136.24*/Messages("STT")),format.raw/*136.39*/("""</th>
                  <th>"""),_display_(/*137.24*/Messages("Tên doanh nghiệp")),format.raw/*137.52*/("""</th>
                  <th>"""),_display_(/*138.24*/Messages("GPKD ")),format.raw/*138.41*/("""</th>
                  <th>"""),_display_(/*139.24*/Messages("Thao tác")),format.raw/*139.44*/("""</th>
                  <th hidden>"""),_display_(/*140.31*/Messages("MST")),format.raw/*140.46*/("""</th>
                  <th hidden>"""),_display_(/*141.31*/Messages("Thành lập")),format.raw/*141.52*/("""</th>
                  <th hidden>"""),_display_(/*142.31*/Messages("Địa chỉ")),format.raw/*142.50*/("""</th>
                  <th>"""),_display_(/*143.24*/Messages("Trạng thái")),format.raw/*143.46*/("""</th>
                  <th style="text-align: center">"""),_display_(/*144.51*/Messages("Thao tác")),format.raw/*144.71*/("""</th>
                </tr>
              </thead>
              <tbody></tbody>
            </table>
            <h5 id="notiNotData" style="text-align: center;"></h5>
          </div>
          <div class="material-datatables row row-cols-auto g-3" style="margin-bottom: 5px; margin-right: 10px;" id="divPagingTable">
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

        <div class="card" id="infoAccountEnterprise" style="padding: 15px; display: none;">
          <span style="font-weight: 700;font-size: 16px;">"""),_display_(/*177.60*/Messages("Thông tin doanh nghiệp")),format.raw/*177.94*/("""</span>
          <div class="row">
            <div class="col-md-8">
              <div class="row mt-3">
                <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*181.73*/Messages("Tên DN")),format.raw/*181.91*/("""</label>
                <div class="col-sm-10">
                  <input id="tenDoanhNghiepEnterprise" type="text" class="form-control input-form" maxlength="250" readonly>
                </div>
              </div>
              <div class="row mt-3">
                <div class="col-sm-6">
                  <div class="row">
                    <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*189.77*/Messages("Mã số thuế")),format.raw/*189.99*/("""</label>
                    <div class="col-sm-8">
                      <input id="maSoThueEnterprise" type="text" class="form-control input-form" maxlength="250" readonly>
                    </div>
                  </div>
                </div>
                <div class="col-sm-6">
                  <div class="row">
                    <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*197.77*/Messages("Số GPKD")),format.raw/*197.96*/("""</label>
                    <div class="col-sm-8">
                      <input id="soGpkdEnterprise" type="text" class="form-control input-form" maxlength="250" readonly>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row mt-3">
                <div class="col-sm-6">
                  <div class="row">
                    <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*207.77*/Messages("Ngày thành lập")),format.raw/*207.103*/("""</label>
                    <div class="col-sm-8">
                      <input id="ngayThanhLapEnterprise" type="text" class="form-control input-form" maxlength="250" readonly>
                    </div>
                  </div>
                </div>
                <div class="col-sm-6">
                  <div class="row">
                    <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*215.77*/Messages("Số điện thoại DN")),format.raw/*215.105*/("""</label>
                    <div class="col-sm-8">
                      <input id="sdtDnEnterprise" type="number" class="form-control input-form" readonly>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row mt-3">
                <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*223.73*/Messages("Email DN")),format.raw/*223.93*/("""</label>
                <div class="col-sm-10">
                  <input id="emailDnEnterprise" type="text" class="form-control input-form" maxlength="250" readonly>
                </div>
              </div>
              <div class="row mt-3">
                <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*229.73*/Messages("Địa chỉ")),format.raw/*229.92*/("""</label>
                <div class="col-sm-10">
                  <div class="row">
                    <div class="col-sm-4">
                      <input id="tinhTpDnEnterprise" type="text" class="form-control input-form" maxlength="250" readonly>
                    </div>
                    <div class="col-sm-4">
                      <input id="quanHuyenDnEnterprise" type="text" class="form-control input-form" maxlength="250" readonly>
                    </div>
                    <div class="col-sm-4">
                      <input id="phuongXaDnEnterprise" type="text" class="form-control input-form" maxlength="250" readonly>
                    </div>
                    <div class="col-sm-12 mt-3">
                      <input id="diaChiChiTietDnEnterprise" type="text" class="form-control input-form" maxlength="250" readonly>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row">
                <label class="col-sm-12 col-form-label title-section-2" id="notiApproved"></label>
              </div>
            </div>

            <div class="col-md-4">
              <div class="row mt-3">
                <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*254.73*/Messages("Ảnh GPKD")),format.raw/*254.93*/("""</label>
                <div class="col-sm-9 position-relative">
                  <div class="row">
                    <div class="col-md-12 position-relative">
                      <div class="d-flex flex-column align-items-center text-center square-item" >
                        <img src=""""),_display_(/*259.36*/routes/*259.42*/.Assets.versioned("images/market/default.png")),format.raw/*259.88*/("""" id="wizardPicturePreviewEnterprise" onclick="zoomImg(this)" alt="img" class="p-1 zoom" style="width: 100%;object-fit: contain;">
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

      """),_display_(/*271.8*/views/*271.13*/.html.telco.role.account.InfoAccountCmp_genPass()),format.raw/*271.62*/("""
      """),_display_(/*272.8*/views/*272.13*/.html.telco.role.account.InfoAccountCmp_genPass_comfirm()),format.raw/*272.70*/("""
      """),_display_(/*273.8*/views/*273.13*/.html.telco.role.account.InfoAccountCmp_addEnterprise(currentUser)),format.raw/*273.79*/("""
      """),_display_(/*274.8*/views/*274.13*/.html.telco.role.account.InfoAccountCmp_delEnterprise()),format.raw/*274.68*/("""
      """),_display_(/*275.8*/views/*275.13*/.html.telco.role.account.InfoAccountCmp_editEnterprise(currentUser)),format.raw/*275.80*/("""
      """),_display_(/*276.8*/views/*276.13*/.html.telco.role.account.InfoAccountCmp_importEnterprise()),format.raw/*276.71*/("""
      """),_display_(/*277.8*/views/*277.13*/.html.telco.role.account.InfoAccountCmp_info()),format.raw/*277.59*/("""

      """),_display_(/*279.8*/views/*279.13*/.html.telco.Loading()),format.raw/*279.34*/("""

    """),format.raw/*281.5*/("""</div>

    """),_display_(/*283.6*/views/*283.11*/.html.telco.mainJs()),format.raw/*283.31*/("""

    """),format.raw/*285.5*/("""<script>
            var userId = '"""),_display_(/*286.28*/userId),format.raw/*286.34*/("""';
            var userCurrentId = '"""),_display_(/*287.35*/currentUser/*287.46*/.getId),format.raw/*287.52*/("""';
            var roleCmp = '"""),_display_(/*288.29*/User/*288.33*/.CmpRole.getNameByCode(currentUser.getCmpRole)),format.raw/*288.79*/("""';
            var imgDefault = '"""),_display_(/*289.32*/routes/*289.38*/.Assets.versioned("images/market/default.png")),format.raw/*289.84*/("""';
            $(document).ready(function () """),format.raw/*290.43*/("""{"""),format.raw/*290.44*/("""
              """),format.raw/*291.15*/("""$("#menu-infoAccountList").addClass("mm-active");
              $("#menu").metisMenu();

              document.getElementById('filesAddEnterprise').addEventListener('change', uploadListEnterprise, false);
            """),format.raw/*295.13*/("""}"""),format.raw/*295.14*/(""")

            function importFileAddEnterprise() """),format.raw/*297.48*/("""{"""),format.raw/*297.49*/("""
              """),format.raw/*298.15*/("""$("#filesAddEnterprise").click();
            """),format.raw/*299.13*/("""}"""),format.raw/*299.14*/("""
    """),format.raw/*300.5*/("""</script>
    <script src=""""),_display_(/*301.19*/routes/*301.25*/.Assets.versioned("assets/plugins/input-tags/js/tagsinput.js")),format.raw/*301.87*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*302.19*/routes/*302.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*302.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*303.19*/routes/*303.25*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*303.85*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*305.19*/routes/*305.25*/.Assets.versioned("javascripts/views/telco/role/accountList/roleAccountCmp.js")),format.raw/*305.104*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*307.19*/routes/*307.25*/.Assets.versioned("javascripts/views/telco/role/accountList/infoAccountCmp_import.js")),format.raw/*307.111*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*308.19*/routes/*308.25*/.Assets.versioned("javascripts/views/telco/role/accountList/infoAccountCmp.js3")),format.raw/*308.105*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*309.19*/routes/*309.25*/.Assets.versioned("javascripts/views/telco/role/accountList/infoAccountCmp_resetPass.js")),format.raw/*309.114*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*310.19*/routes/*310.25*/.Assets.versioned("javascripts/views/telco/role/accountList/infoAccountCmp_addEnterprise.js")),format.raw/*310.118*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*311.19*/routes/*311.25*/.Assets.versioned("javascripts/views/telco/role/accountList/infoAccountCmp_delEnterprise.js")),format.raw/*311.118*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*312.19*/routes/*312.25*/.Assets.versioned("javascripts/views/telco/role/accountList/infoAccountCmp_edit.js")),format.raw/*312.109*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*313.19*/routes/*313.25*/.Assets.versioned("javascripts/views/telco/role/accountList/InfoAccountCmp_infoDN.js")),format.raw/*313.111*/("""" type="text/javascript"></script>

  </body>
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
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/account/InfoAccountCmp.scala.html
                  HASH: 50f0dbf7f9ba70ad7fb1c1e8616ef90d7384999d
                  MATRIX: 670->1|706->31|1057->65|1185->98|1212->99|1380->241|1431->272|1512->326|1527->332|1584->368|1791->549|1805->554|1851->579|1884->585|1924->598|1939->604|2014->658|2080->697|2095->703|2180->767|2246->806|2261->812|2331->861|2394->897|2409->903|2505->978|2661->1107|2676->1113|2813->1228|2879->1267|2894->1273|2969->1327|3059->1391|3073->1396|3128->1430|3161->1437|3175->1442|3227->1473|3260->1479|3448->1640|3498->1669|3803->1947|3842->1965|4267->2363|4316->2390|4784->2831|4822->2848|5238->3237|5285->3262|5796->3746|5837->3766|6224->4126|6266->4147|6708->4562|6758->4590|8050->5853|8104->5884|8368->6119|8420->6148|8687->6386|8736->6412|8985->6632|9028->6652|9478->7074|9515->7089|9572->7118|9622->7146|9679->7175|9718->7192|9775->7221|9817->7241|9881->7277|9918->7292|9982->7328|10025->7349|10089->7385|10130->7404|10187->7433|10231->7455|10315->7511|10357->7531|12322->9468|12378->9502|12586->9682|12626->9700|13060->10106|13104->10128|13533->10529|13574->10548|14059->11005|14108->11031|14541->11436|14592->11464|14983->11827|15025->11847|15373->12167|15414->12186|16702->13446|16744->13466|17070->13764|17086->13770|17154->13816|17510->14145|17525->14150|17596->14199|17631->14207|17646->14212|17725->14269|17760->14277|17775->14282|17863->14348|17898->14356|17913->14361|17990->14416|18025->14424|18040->14429|18129->14496|18164->14504|18179->14509|18259->14567|18294->14575|18309->14580|18377->14626|18413->14635|18428->14640|18471->14661|18505->14667|18545->14680|18560->14685|18602->14705|18636->14711|18700->14747|18728->14753|18793->14790|18814->14801|18842->14807|18901->14838|18915->14842|18983->14888|19045->14922|19061->14928|19129->14974|19203->15019|19233->15020|19277->15035|19524->15253|19554->15254|19633->15304|19663->15305|19707->15320|19782->15366|19812->15367|19845->15372|19901->15400|19917->15406|20001->15468|20082->15521|20098->15527|20179->15586|20260->15639|20276->15645|20358->15705|20440->15759|20456->15765|20558->15844|20640->15898|20656->15904|20765->15990|20846->16043|20862->16049|20965->16129|21046->16182|21062->16188|21174->16277|21255->16330|21271->16336|21387->16429|21468->16482|21484->16488|21600->16581|21681->16634|21697->16640|21804->16724|21885->16777|21901->16783|22010->16869
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|51->19|51->19|52->20|52->20|52->20|54->22|54->22|54->22|56->24|56->24|56->24|60->28|60->28|60->28|62->30|62->30|62->30|64->32|69->37|69->37|74->42|74->42|82->50|82->50|93->61|93->61|101->69|101->69|112->80|112->80|120->88|120->88|131->99|131->99|154->122|154->122|155->123|155->123|156->124|156->124|157->125|157->125|168->136|168->136|169->137|169->137|170->138|170->138|171->139|171->139|172->140|172->140|173->141|173->141|174->142|174->142|175->143|175->143|176->144|176->144|209->177|209->177|213->181|213->181|221->189|221->189|229->197|229->197|239->207|239->207|247->215|247->215|255->223|255->223|261->229|261->229|286->254|286->254|291->259|291->259|291->259|303->271|303->271|303->271|304->272|304->272|304->272|305->273|305->273|305->273|306->274|306->274|306->274|307->275|307->275|307->275|308->276|308->276|308->276|309->277|309->277|309->277|311->279|311->279|311->279|313->281|315->283|315->283|315->283|317->285|318->286|318->286|319->287|319->287|319->287|320->288|320->288|320->288|321->289|321->289|321->289|322->290|322->290|323->291|327->295|327->295|329->297|329->297|330->298|331->299|331->299|332->300|333->301|333->301|333->301|334->302|334->302|334->302|335->303|335->303|335->303|337->305|337->305|337->305|339->307|339->307|339->307|340->308|340->308|340->308|341->309|341->309|341->309|342->310|342->310|342->310|343->311|343->311|343->311|344->312|344->312|344->312|345->313|345->313|345->313
                  -- GENERATED --
              */
          