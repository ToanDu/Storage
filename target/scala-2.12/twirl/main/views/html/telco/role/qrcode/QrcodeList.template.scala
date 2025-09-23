
package views.html.telco.role.qrcode

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

object QrcodeList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.20*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("Quản lý QR Code")),format.raw/*9.40*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*17.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("assets/plugins/input-tags/css/tagsinput.css")),format.raw/*18.88*/("""" rel="stylesheet" />
    """),format.raw/*19.96*/("""
    """),format.raw/*20.5*/("""<link href='"""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*20.73*/("""' type='text/css'>
    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*21.99*/("""" rel="stylesheet">
    <link href=""""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*22.139*/("""" rel="stylesheet" >

    <link href=""""),_display_(/*24.18*/routes/*24.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*24.78*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*28.6*/views/*28.11*/.html.telco.role.Menu(currentUser)),format.raw/*28.45*/("""

    """),_display_(/*30.6*/views/*30.11*/.html.telco.role.Header(currentUser)),format.raw/*30.47*/("""

    """),format.raw/*32.5*/("""<div class="page-wrapper">
      <div class="page-content">

        <div class="card" id="formSearch">
          <div class="card-body">
            <span class="text-search">"""),_display_(/*37.40*/Messages("Thông tin tìm kiếm")),format.raw/*37.70*/("""</span>

            <div class="row mt-3">
              <div class="col-md-12">
                <div class="row">
                  <div class="col-md-6 m-t-3">
                    <div class="row m-b-4">
                      <div class="col-sm-1"></div>
                      <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*45.79*/Messages("Serial Sim")),format.raw/*45.101*/("""</label>
                      <div class="col-sm-8 input-icons">
                        <input id="serialSim" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="50" required>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6 m-t-3">
                    <div class="row m-b-4">
                      <div class="col-sm-1"></div>
                      <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*54.79*/Messages("Trạng thái đấu nối")),format.raw/*54.109*/("""</label>
                      <div class="col-sm-8 input-icons">
                        <select id="statusConnectSub" class="form-control">
                          <option value="">"""),_display_(/*57.45*/Messages("--- Chọn trạng thái ---")),format.raw/*57.80*/("""</option>
                          <option value="PROCESSING">"""),_display_(/*58.55*/Messages("Đang tạo QR")),format.raw/*58.78*/("""</option>
                          <option value="CREATED_SUCCESS">"""),_display_(/*59.60*/Messages("Đã tạo QR")),format.raw/*59.81*/("""</option>
                          <option value="CREATED_FAILED">"""),_display_(/*60.59*/Messages("Đã tạo QR thất bại")),format.raw/*60.89*/("""</option>
                          <option value="CREATED_PAYMENT">"""),_display_(/*61.60*/Messages("Đã tạo payment")),format.raw/*61.86*/("""</option>
                          <option value="PAID_SUCCESS">"""),_display_(/*62.57*/Messages("Đã thanh toán thành công (Chưa đấu nối)")),format.raw/*62.108*/("""</option>
                          <option value="PROVISIONED_FAILED">"""),_display_(/*63.63*/Messages("Đấu nối thất bại ")),format.raw/*63.92*/("""</option>
                          <option value="PROVISIONED_SUCCESS">"""),_display_(/*64.64*/Messages("Đấu nối thành công")),format.raw/*64.94*/("""</option>
                        </select>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6 m-t-3">
                    <div class="row m-b-4">
                      <div class="col-sm-1"></div>
                      <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*72.79*/Messages("Ngày tạo từ")),format.raw/*72.102*/("""</label>
                      <div class="col-sm-8 input-icons">
                        <input id="fromDateCreateQr" type="text" class="form-control input-form date_timepicker">
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6 m-t-3">
                    <div class="row m-b-4">
                      <div class="col-sm-1"></div>
                      <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*81.79*/Messages("Ngày tạo đến")),format.raw/*81.103*/("""</label>
                      <div class="col-sm-8 input-icons">
                        <input id="toDateCreateQr" type="text" class="form-control input-form date_timepicker">
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="d-flex flex-column align-items-center text-center">
              <div class="">
                <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033; width: 180px;" data-bs-toggle="modal" data-bs-target="#addQrcodeModal">"""),_display_(/*92.182*/Messages("Tạo QR")),format.raw/*92.200*/("""</button>
                <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033; width: 180px;" onclick="exportListQrCode()">"""),_display_(/*93.155*/Messages("Export")),format.raw/*93.173*/("""</button>
                <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="resetFormSearch()">"""),_display_(/*94.140*/Messages("Reset")),format.raw/*94.157*/("""</button>
                <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF; width: 180px;" onclick="onlickButtonSearch()">"""),_display_(/*95.157*/Messages("Tra cứu")),format.raw/*95.176*/("""</button>
              </div>
            </div>
          </div>
        </div>

        <div class="card">
          <div class="table-responsive mb-3" style="border-radius: 8px;">
            <table class="table table-striped" id="listQrcodeTable" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th>"""),_display_(/*106.24*/Messages("STT")),format.raw/*106.39*/("""</th>
                  <th>"""),_display_(/*107.24*/Messages("User đấu nối")),format.raw/*107.48*/("""</th>
                  <th>"""),_display_(/*108.24*/Messages("Tên DN")),format.raw/*108.42*/("""</th>
                  <th>"""),_display_(/*109.24*/Messages("GPKD")),format.raw/*109.40*/("""</th>
                  <th>"""),_display_(/*110.24*/Messages("Serial Sim")),format.raw/*110.46*/("""</th>
                  <th>"""),_display_(/*111.24*/Messages("Ngày tạo")),format.raw/*111.44*/("""</th>
                  <th>"""),_display_(/*112.24*/Messages("Tên gói cước")),format.raw/*112.48*/("""</th>
                  <th>"""),_display_(/*113.24*/Messages("Mã QR")),format.raw/*113.41*/("""</th>
                  <th>"""),_display_(/*114.24*/Messages("Mã xác nhận")),format.raw/*114.47*/("""</th>
                  <th>"""),_display_(/*115.24*/Messages("Trạng thái đấu nối")),format.raw/*115.54*/("""</th>
                  <th>"""),_display_(/*116.24*/Messages("Ngày đấu nối")),format.raw/*116.48*/("""</th>
                  <th style="text-align: center;">"""),_display_(/*117.52*/Messages("Thao tác")),format.raw/*117.72*/("""</th>
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
                  <button class="btn dropdown-toggle text-white" type="button" data-bs-toggle="dropdown" aria-expanded="false" id="countPageSize" style="background-color: rgb(0 0 0 / 50%); margin-left: 5px;">10</button>
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

        """),_display_(/*149.10*/views/*149.15*/.html.telco.role.qrcode.QrcodeList_add()),format.raw/*149.55*/("""
        """),_display_(/*150.10*/views/*150.15*/.html.telco.role.qrcode.QrcodeList_add_infoCustomer()),format.raw/*150.68*/("""
        """),_display_(/*151.10*/views/*151.15*/.html.telco.role.qrcode.QrcodeList_add_upfileCustomer()),format.raw/*151.70*/("""
        """),_display_(/*152.10*/views/*152.15*/.html.telco.role.qrcode.QrcodeList_add_finish()),format.raw/*152.62*/("""
        """),_display_(/*153.10*/views/*153.15*/.html.telco.role.qrcode.QrcodeList_zoomImg()),format.raw/*153.59*/("""
        """),_display_(/*154.10*/views/*154.15*/.html.telco.role.qrcode.QrcodeList_delete()),format.raw/*154.58*/("""

      """),format.raw/*156.7*/("""</div>

      """),_display_(/*158.8*/views/*158.13*/.html.telco.Loading()),format.raw/*158.34*/("""

    """),format.raw/*160.5*/("""</div>

    """),_display_(/*162.6*/views/*162.11*/.html.telco.mainJs()),format.raw/*162.31*/("""

    """),format.raw/*164.5*/("""<script>
            var imgDefault = '"""),_display_(/*165.32*/routes/*165.38*/.Assets.versioned("images/market/default.png")),format.raw/*165.84*/("""';
            var roleCmp = '"""),_display_(/*166.29*/User/*166.33*/.CmpRole.getNameByCode(currentUser.getCmpRole)),format.raw/*166.79*/("""';
            console.log(roleCmp);
            $(document).ready(function () """),format.raw/*168.43*/("""{"""),format.raw/*168.44*/("""
              """),format.raw/*169.15*/("""$("#menu-qrCodeList").addClass("mm-active");
              $("#menu").metisMenu();

              $('.date_timepicker').bootstrapMaterialDatePicker("""),format.raw/*172.65*/("""{"""),format.raw/*172.66*/("""
                """),format.raw/*173.17*/("""format: 'DD/MM/YYYY',
                time: false
              """),format.raw/*175.15*/("""}"""),format.raw/*175.16*/(""");

              document.getElementById('filesSerials').addEventListener('change', uploadFilesSerialAdm1, false);
            """),format.raw/*178.13*/("""}"""),format.raw/*178.14*/(""")
    </script>
    <script src=""""),_display_(/*180.19*/routes/*180.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*180.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*181.19*/routes/*181.25*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*181.85*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*182.19*/routes/*182.25*/.Assets.versioned("javascripts/exportfile/alasql.min.js")),format.raw/*182.82*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*183.19*/routes/*183.25*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/moment.min.js")),format.raw/*183.111*/(""""></script>
    <script src=""""),_display_(/*184.19*/routes/*184.25*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.min.js")),format.raw/*184.138*/(""""></script>

    <script type="text/javascript" src=""""),_display_(/*186.42*/routes/*186.48*/.Assets.versioned("javascripts/exportZip/jszip.js")),format.raw/*186.99*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*187.42*/routes/*187.48*/.Assets.versioned("javascripts/exportZip/jszip-utils.js")),format.raw/*187.105*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*188.42*/routes/*188.48*/.Assets.versioned("javascripts/exportZip/FileSaver.js")),format.raw/*188.103*/(""""></script>

    """),format.raw/*190.126*/("""
    """),format.raw/*191.5*/("""<script src=""""),_display_(/*191.19*/routes/*191.25*/.Assets.versioned("javascripts/views/telco/role/qrcode/Qrcode.js")),format.raw/*191.91*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*192.19*/routes/*192.25*/.Assets.versioned("javascripts/views/telco/role/qrcode/Qrcode_upfile.js")),format.raw/*192.98*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*193.19*/routes/*193.25*/.Assets.versioned("javascripts/views/telco/role/qrcode/Qrcode_add.js")),format.raw/*193.95*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*194.19*/routes/*194.25*/.Assets.versioned("javascripts/views/telco/role/qrcode/Qrcode_add_infoCustomer.js")),format.raw/*194.108*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*195.19*/routes/*195.25*/.Assets.versioned("javascripts/views/telco/role/qrcode/Qrcode_add_upfileCustomer.js")),format.raw/*195.110*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*196.19*/routes/*196.25*/.Assets.versioned("javascripts/views/telco/role/qrcode/Qrcode_add_finish.js")),format.raw/*196.102*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*197.19*/routes/*197.25*/.Assets.versioned("javascripts/views/telco/role/qrcode/Qrcode_del.js")),format.raw/*197.95*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*198.19*/routes/*198.25*/.Assets.versioned("javascripts/views/telco/role/qrcode/Qrcode_download.js")),format.raw/*198.100*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*200.19*/routes/*200.25*/.Assets.versioned("javascripts/views/telco/role/qrcode/Qrcode_export.js")),format.raw/*200.98*/("""" type="text/javascript"></script>

  </body>
</html>
"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/qrcode/QrcodeList.scala.html
                  HASH: 35ea9ec5e7d55fce5812c8d36786b5f6e6a5ecbd
                  MATRIX: 669->1|705->31|1045->65|1158->83|1185->84|1353->226|1400->253|1481->307|1496->313|1553->349|1760->530|1774->535|1820->560|1853->566|1893->579|1908->585|1983->639|2049->678|2064->684|2149->748|2203->865|2235->870|2275->883|2290->889|2360->938|2423->974|2438->980|2534->1055|2598->1092|2613->1098|2750->1213|2816->1252|2831->1258|2906->1312|2996->1376|3010->1381|3065->1415|3098->1422|3112->1427|3169->1463|3202->1469|3406->1646|3457->1676|3820->2012|3864->2034|4401->2544|4453->2574|4666->2760|4722->2795|4813->2859|4857->2882|4953->2951|4995->2972|5090->3040|5141->3070|5237->3139|5284->3165|5377->3231|5450->3282|5549->3354|5599->3383|5699->3456|5750->3486|6122->3831|6167->3854|6675->4335|6721->4359|7357->4967|7397->4985|7589->5149|7629->5167|7806->5316|7845->5333|8039->5499|8080->5518|8483->5893|8520->5908|8577->5937|8623->5961|8680->5990|8720->6008|8777->6037|8815->6053|8872->6082|8916->6104|8973->6133|9015->6153|9072->6182|9118->6206|9175->6235|9214->6252|9271->6281|9316->6304|9373->6333|9425->6363|9482->6392|9528->6416|9613->6473|9655->6493|11477->8287|11492->8292|11554->8332|11592->8342|11607->8347|11682->8400|11720->8410|11735->8415|11812->8470|11850->8480|11865->8485|11934->8532|11972->8542|11987->8547|12053->8591|12091->8601|12106->8606|12171->8649|12207->8657|12249->8672|12264->8677|12307->8698|12341->8704|12381->8717|12396->8722|12438->8742|12472->8748|12540->8788|12556->8794|12624->8840|12683->8871|12697->8875|12765->8921|12873->9000|12903->9001|12947->9016|13124->9164|13154->9165|13200->9182|13293->9246|13323->9247|13480->9375|13510->9376|13572->9410|13588->9416|13669->9475|13750->9528|13766->9534|13848->9594|13929->9647|13945->9653|14024->9710|14105->9763|14121->9769|14230->9855|14288->9885|14304->9891|14440->10004|14522->10058|14538->10064|14611->10115|14692->10168|14708->10174|14788->10231|14869->10284|14885->10290|14963->10345|15010->10483|15043->10488|15085->10502|15101->10508|15189->10574|15270->10627|15286->10633|15381->10706|15462->10759|15478->10765|15570->10835|15651->10888|15667->10894|15773->10977|15854->11030|15870->11036|15978->11121|16059->11174|16075->11180|16175->11257|16256->11310|16272->11316|16364->11386|16445->11439|16461->11445|16559->11520|16641->11574|16657->11580|16752->11653
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|52->20|52->20|52->20|52->20|53->21|53->21|53->21|54->22|54->22|54->22|56->24|56->24|56->24|60->28|60->28|60->28|62->30|62->30|62->30|64->32|69->37|69->37|77->45|77->45|86->54|86->54|89->57|89->57|90->58|90->58|91->59|91->59|92->60|92->60|93->61|93->61|94->62|94->62|95->63|95->63|96->64|96->64|104->72|104->72|113->81|113->81|124->92|124->92|125->93|125->93|126->94|126->94|127->95|127->95|138->106|138->106|139->107|139->107|140->108|140->108|141->109|141->109|142->110|142->110|143->111|143->111|144->112|144->112|145->113|145->113|146->114|146->114|147->115|147->115|148->116|148->116|149->117|149->117|181->149|181->149|181->149|182->150|182->150|182->150|183->151|183->151|183->151|184->152|184->152|184->152|185->153|185->153|185->153|186->154|186->154|186->154|188->156|190->158|190->158|190->158|192->160|194->162|194->162|194->162|196->164|197->165|197->165|197->165|198->166|198->166|198->166|200->168|200->168|201->169|204->172|204->172|205->173|207->175|207->175|210->178|210->178|212->180|212->180|212->180|213->181|213->181|213->181|214->182|214->182|214->182|215->183|215->183|215->183|216->184|216->184|216->184|218->186|218->186|218->186|219->187|219->187|219->187|220->188|220->188|220->188|222->190|223->191|223->191|223->191|223->191|224->192|224->192|224->192|225->193|225->193|225->193|226->194|226->194|226->194|227->195|227->195|227->195|228->196|228->196|228->196|229->197|229->197|229->197|230->198|230->198|230->198|232->200|232->200|232->200
                  -- GENERATED --
              */
          