
package views.html.QrCodePage

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
/*2.2*/import vn.m2m.utils.DateUtil
/*3.2*/import vn.m2m.common.models.User
/*4.2*/import vn.m2m.iot.models.QrCode

object QrCodeList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,List[QrCode],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(currentUser:User, qrCodeList: List[QrCode]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.46*/("""
"""),format.raw/*6.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*11.13*/Messages("Manage QR Code")),format.raw/*11.39*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*12.46*/routes/*12.52*/.Assets.versioned("images/logo.jpg")),format.raw/*12.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*17.6*/views/*17.11*/.html.iot.tags.Main_css()),format.raw/*17.36*/("""

    """),format.raw/*19.5*/("""<link href=""""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("stylesheets/views/group/style.min.css")),format.raw/*19.82*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*20.78*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*24.6*/views/*24.11*/.html.iot.tags.Menu(currentUser, "")),format.raw/*24.47*/("""

    """),_display_(/*26.6*/views/*26.11*/.html.iot.tags.Header(currentUser)),format.raw/*26.45*/("""

    """),format.raw/*28.5*/("""<div class="page-wrapper">
      <div class="page-content">

          <!--breadcrumb-->
        <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3 ">
          <div class="breadcrumb-title pe-3">"""),_display_(/*33.47*/Messages("QR CODE")),format.raw/*33.66*/("""</div>
          <div class="ps-3">
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb mb-0 p-0">
                <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt "></i></a>
                </li>
                <li class="breadcrumb-item active " aria-current="page">"""),_display_(/*39.74*/Messages("manage.qrCodeList")),format.raw/*39.103*/("""</li>
              </ol>
            </nav>
          </div>
          <div class="ms-auto">

          </div>
        </div>
          <!--end breadcrumb-->

        <div class="card ">
          <div class="card-header card-header-primary card-header-icon">
            <div class="toolbar" style="float: left">
              <div class="toolbar" style="float: left;
                margin-top: 15px; ">
                <input type="file" id="files" name="files" style="display: none;background-color: #f4f4f4"/>
              </div>
            </div>
            <div class="toolbar" style="float: right">

              <button class="btn btn-danger px-5 radius-30" onclick="importFileCSV()">
                <i class="bx bxs-file-import" aria-hidden="true"></i> """),_display_(/*60.72*/Messages("Import")),format.raw/*60.90*/("""
              """),format.raw/*61.15*/("""</button>
              <button class="btn btn-danger px-5 radius-30" id="buttonSubmitImportCSV" data-bs-toggle="modal" data-bs-target="#addConfirmModal" hidden>
                <i class="bx bxs-file-import" aria-hidden="true"></i> """),_display_(/*63.72*/Messages("Submit")),format.raw/*63.90*/("""
              """),format.raw/*64.15*/("""</button>
              <button class="btn btn-danger px-5 radius-30" onclick="downloadCSVTemplate()">
                <i class="bx bx-download" aria-hidden="true"></i> """),_display_(/*66.68*/Messages("Download Template")),format.raw/*66.97*/("""
              """),format.raw/*67.15*/("""</button>
              <button class="btn btn-success px-5 radius-30" onclick="exportQrCodeList()">
                <i class="bx bxs-file-export" aria-hidden="true"></i> """),_display_(/*69.72*/Messages("Export")),format.raw/*69.90*/("""
              """),format.raw/*70.15*/("""</button>
            </div>
          </div>

          <div class="card-body">
            <div class="table-responsive">

              <table id="dataTables" class="table table-bordered">
                <thead class="cf">
                  <th>"""),_display_(/*79.24*/Messages("qr.id")),format.raw/*79.41*/("""</th>
                  <th>"""),_display_(/*80.24*/Messages("qr.Name")),format.raw/*80.43*/("""</th>
                  <th>"""),_display_(/*81.24*/Messages("qr.Link")),format.raw/*81.43*/("""</th>
                  <th>"""),_display_(/*82.24*/Messages("qr.QRCode")),format.raw/*82.45*/("""</th>
                  <th>"""),_display_(/*83.24*/Messages("btnDate")),format.raw/*83.43*/("""</th>
                  <th>"""),_display_(/*84.24*/Messages("btnAction")),format.raw/*84.45*/("""</th>
                </thead>
                <tbody align="left">
                """),_display_(/*87.18*/for((qr: QrCode)<- qrCodeList) yield /*87.48*/ {_display_(Seq[Any](format.raw/*87.50*/("""
                  """),format.raw/*88.19*/("""<tr>
                    <td>"""),_display_(/*89.26*/qr/*89.28*/.getId),format.raw/*89.34*/("""</td>
                    <td>"""),_display_(/*90.26*/qr/*90.28*/.getName),format.raw/*90.36*/("""</td>
                    <td>"""),_display_(/*91.26*/qr/*91.28*/.getLinkAndroid),format.raw/*91.43*/("""<br>"""),_display_(/*91.48*/qr/*91.50*/.getLinkIos),format.raw/*91.61*/("""</td>
                    <td>
                      <img src=""""),_display_(/*93.34*/qr/*93.36*/.getSrc),format.raw/*93.43*/("""" height="50">
                    </td>
                    <td>"""),_display_(/*95.26*/DateUtil/*95.34*/.getDateByFormat(qr.getLogDate, DateUtil.FORMAT_DATE_YYYY_MM_DD_HH_mm_ss)),format.raw/*95.107*/("""</td>
                    <td class="dt-buttons btn-group" style="width: 90%">
                      <a rel="tooltip" title=""""),_display_(/*97.48*/Messages("btnView")),format.raw/*97.67*/("""" class="btn btn-light" href=""""),_display_(/*97.98*/routes/*97.104*/.QrCodeController.qrCodeImg(qr.getId)),format.raw/*97.141*/("""" target="_blank">
                        <i class="bx bx-link me-0"></i>
                      </a>
                      <a rel="tooltip" title=""""),_display_(/*100.48*/Messages("btnEdit")),format.raw/*100.67*/("""" class="btn btn-light" onclick="setEditQr('"""),_display_(/*100.112*/qr/*100.114*/.getId),format.raw/*100.120*/("""', '"""),_display_(/*100.125*/qr/*100.127*/.getName),format.raw/*100.135*/("""', '"""),_display_(/*100.140*/qr/*100.142*/.getLinkAndroid),format.raw/*100.157*/("""', '"""),_display_(/*100.162*/qr/*100.164*/.getLinkIos),format.raw/*100.175*/("""')" data-bs-toggle="modal" data-bs-target="#editQrConfirm">
                        <i class="bx bx-edit me-0"></i>
                      </a>
                      <a rel="tooltip" title=""""),_display_(/*103.48*/Messages("btnDelete")),format.raw/*103.69*/("""" class="btn btn-light" onclick="setDeleteQr('"""),_display_(/*103.116*/qr/*103.118*/.getId),format.raw/*103.124*/("""')" data-bs-toggle="modal" data-bs-target="#deleteQrConfirm">
                        <i class="bx bx-x me-0"></i>
                      </a>
                    </td>
                  </tr>
                """)))}),format.raw/*108.18*/("""
                """),format.raw/*109.17*/("""</tbody>
              </table>

            </div>
          </div>
        </div>
      </div>

      """),_display_(/*117.8*/views/*117.13*/.html.QrCodePage.QrCodeList_create()),format.raw/*117.49*/("""
      """),_display_(/*118.8*/views/*118.13*/.html.QrCodePage.QrCodeList_delete()),format.raw/*118.49*/("""
      """),_display_(/*119.8*/views/*119.13*/.html.QrCodePage.QrCodeList_edit()),format.raw/*119.47*/("""

    """),format.raw/*121.5*/("""</div>
      <!--  END OF PAPER WRAP -->
    """),_display_(/*123.6*/views/*123.11*/.html.Loading()),format.raw/*123.26*/("""

  """),format.raw/*125.3*/("""</body>

  """),_display_(/*127.4*/views/*127.9*/.html.iot.tags.Main_js()),format.raw/*127.33*/("""

  """),format.raw/*129.3*/("""<script src=""""),_display_(/*129.17*/routes/*129.23*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*129.77*/(""""></script>
    <!--plugins-->
  <script src=""""),_display_(/*131.17*/routes/*131.23*/.Assets.versioned("assets/plugins/simplebar/js/simplebar.min.js")),format.raw/*131.88*/(""""></script>
  <script src=""""),_display_(/*132.17*/routes/*132.23*/.Assets.versioned("assets/plugins/metismenu/js/metisMenu.min.js")),format.raw/*132.88*/(""""></script>
  <script src=""""),_display_(/*133.17*/routes/*133.23*/.Assets.versioned("assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js")),format.raw/*133.100*/(""""></script>
  <script>
          $(document).ready(function () """),format.raw/*135.41*/("""{"""),format.raw/*135.42*/("""
            """),format.raw/*136.13*/("""$("#menu-qrCode").addClass("mm-active");
            $("#menu").metisMenu();
          """),format.raw/*138.11*/("""}"""),format.raw/*138.12*/(""")
  </script>

  <script src=""""),_display_(/*141.17*/routes/*141.23*/.Assets.versioned("javascripts/SearchJs.js")),format.raw/*141.67*/("""" type="text/javascript"></script>

  <script>
          $(document).ready(function() """),format.raw/*144.40*/("""{"""),format.raw/*144.41*/("""
            """),format.raw/*145.13*/("""var table = $('#dataTables').DataTable( """),format.raw/*145.53*/("""{"""),format.raw/*145.54*/("""
              """),format.raw/*146.15*/("""lengthChange: false,
              buttons: [ 'excel', 'pdf', 'print'],
              "order": []
            """),format.raw/*149.13*/("""}"""),format.raw/*149.14*/(""" """),format.raw/*149.15*/(""");

//            table.buttons().container()
//                    .appendTo( '#dataTables_wrapper .col-md-6:eq(0)' );
          """),format.raw/*153.11*/("""}"""),format.raw/*153.12*/(""" """),format.raw/*153.13*/(""");
  </script>

  <script src=""""),_display_(/*156.17*/routes/*156.23*/.Assets.versioned("javascripts/jquery/jquery-csv.js")),format.raw/*156.76*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*157.17*/routes/*157.23*/.Assets.versioned("javascripts/qrCode/downloadTemplate.js")),format.raw/*157.82*/("""" type="text/javascript"></script>

  <script type="text/javascript">
          $(document).ready(function()"""),format.raw/*160.39*/("""{"""),format.raw/*160.40*/("""
            """),format.raw/*161.13*/("""document.getElementById('files').addEventListener('change', upload, false);
          """),format.raw/*162.11*/("""}"""),format.raw/*162.12*/(""");
  </script>
  <script src=""""),_display_(/*164.17*/routes/*164.23*/.Assets.versioned("javascripts/qrCode/qrcode.min.js")),format.raw/*164.76*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*165.17*/routes/*165.23*/.Assets.versioned("javascripts/qrCode/QrCode.js")),format.raw/*165.72*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*166.17*/routes/*166.23*/.Assets.versioned("javascripts/qrCode/importFileIdQrCode.js")),format.raw/*166.84*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*168.17*/routes/*168.23*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*168.82*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*169.17*/routes/*169.23*/.Assets.versioned("javascripts/qrCode/exportQrCode.js")),format.raw/*169.78*/("""" type="text/javascript"></script>

  <script type="text/javascript" src=""""),_display_(/*171.40*/routes/*171.46*/.Assets.versioned("javascripts/exportZip/jszip.js")),format.raw/*171.97*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*172.40*/routes/*172.46*/.Assets.versioned("javascripts/exportZip/jszip-utils.js")),format.raw/*172.103*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*173.40*/routes/*173.46*/.Assets.versioned("javascripts/exportZip/FileSaver.js")),format.raw/*173.101*/(""""></script>
</html>
"""))
      }
    }
  }

  def render(currentUser:User,qrCodeList:List[QrCode]): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,qrCodeList)

  def f:((User,List[QrCode]) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,qrCodeList) => apply(currentUser,qrCodeList)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:49 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/QrCodePage/QrCodeList.scala.html
                  HASH: 852cb8a8790229f092a4125f7fc8dab020b029b2
                  MATRIX: 662->1|685->18|721->48|761->82|1113->115|1252->159|1279->160|1448->302|1495->328|1576->382|1591->388|1648->424|1855->605|1869->610|1915->635|1948->641|1988->654|2003->660|2082->718|2148->757|2163->763|2238->817|2328->881|2342->886|2399->922|2432->929|2446->934|2501->968|2534->974|2776->1189|2816->1208|3166->1531|3217->1560|4014->2330|4053->2348|4096->2363|4356->2596|4395->2614|4438->2629|4635->2799|4685->2828|4728->2843|4927->3015|4966->3033|5009->3048|5286->3298|5324->3315|5380->3344|5420->3363|5476->3392|5516->3411|5572->3440|5614->3461|5670->3490|5710->3509|5766->3538|5808->3559|5920->3644|5966->3674|6006->3676|6053->3695|6110->3725|6121->3727|6148->3733|6206->3764|6217->3766|6246->3774|6304->3805|6315->3807|6351->3822|6383->3827|6394->3829|6426->3840|6517->3904|6528->3906|6556->3913|6649->3979|6666->3987|6761->4060|6914->4186|6954->4205|7012->4236|7028->4242|7087->4279|7264->4428|7305->4447|7379->4492|7392->4494|7421->4500|7455->4505|7468->4507|7499->4515|7533->4520|7546->4522|7584->4537|7618->4542|7631->4544|7665->4555|7883->4745|7926->4766|8002->4813|8015->4815|8044->4821|8285->5030|8331->5047|8463->5152|8478->5157|8536->5193|8571->5201|8586->5206|8644->5242|8679->5250|8694->5255|8750->5289|8784->5295|8857->5341|8872->5346|8909->5361|8941->5365|8980->5377|8994->5382|9040->5406|9072->5410|9114->5424|9130->5430|9206->5484|9281->5531|9297->5537|9384->5602|9440->5630|9456->5636|9543->5701|9599->5729|9615->5735|9715->5812|9807->5875|9837->5876|9879->5889|9995->5976|10025->5977|10084->6008|10100->6014|10166->6058|10281->6144|10311->6145|10353->6158|10422->6198|10452->6199|10496->6214|10635->6324|10665->6325|10695->6326|10854->6456|10884->6457|10914->6458|10974->6490|10990->6496|11065->6549|11144->6600|11160->6606|11241->6665|11378->6773|11408->6774|11450->6787|11565->6873|11595->6874|11654->6905|11670->6911|11745->6964|11824->7015|11840->7021|11911->7070|11990->7121|12006->7127|12089->7188|12169->7240|12185->7246|12266->7305|12345->7356|12361->7362|12438->7417|12541->7492|12557->7498|12630->7549|12709->7600|12725->7606|12805->7663|12884->7714|12900->7720|12978->7775
                  LINES: 24->1|25->2|26->3|27->4|32->5|37->5|38->6|43->11|43->11|44->12|44->12|44->12|49->17|49->17|49->17|51->19|51->19|51->19|51->19|52->20|52->20|52->20|56->24|56->24|56->24|58->26|58->26|58->26|60->28|65->33|65->33|71->39|71->39|92->60|92->60|93->61|95->63|95->63|96->64|98->66|98->66|99->67|101->69|101->69|102->70|111->79|111->79|112->80|112->80|113->81|113->81|114->82|114->82|115->83|115->83|116->84|116->84|119->87|119->87|119->87|120->88|121->89|121->89|121->89|122->90|122->90|122->90|123->91|123->91|123->91|123->91|123->91|123->91|125->93|125->93|125->93|127->95|127->95|127->95|129->97|129->97|129->97|129->97|129->97|132->100|132->100|132->100|132->100|132->100|132->100|132->100|132->100|132->100|132->100|132->100|132->100|132->100|132->100|135->103|135->103|135->103|135->103|135->103|140->108|141->109|149->117|149->117|149->117|150->118|150->118|150->118|151->119|151->119|151->119|153->121|155->123|155->123|155->123|157->125|159->127|159->127|159->127|161->129|161->129|161->129|161->129|163->131|163->131|163->131|164->132|164->132|164->132|165->133|165->133|165->133|167->135|167->135|168->136|170->138|170->138|173->141|173->141|173->141|176->144|176->144|177->145|177->145|177->145|178->146|181->149|181->149|181->149|185->153|185->153|185->153|188->156|188->156|188->156|189->157|189->157|189->157|192->160|192->160|193->161|194->162|194->162|196->164|196->164|196->164|197->165|197->165|197->165|198->166|198->166|198->166|200->168|200->168|200->168|201->169|201->169|201->169|203->171|203->171|203->171|204->172|204->172|204->172|205->173|205->173|205->173
                  -- GENERATED --
              */
          