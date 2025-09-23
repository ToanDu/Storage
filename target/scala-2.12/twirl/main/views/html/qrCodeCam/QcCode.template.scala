
package views.html.qrCodeCam

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
/*4.2*/import vn.m2m.iot.models.QrCodeCam

object QcCode extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,List[QrCodeCam],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(currentUser:User, qrCodeList: List[QrCodeCam]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.49*/("""
"""),format.raw/*6.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*11.13*/Messages("QR Code Cam")),format.raw/*11.36*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*12.46*/routes/*12.52*/.Assets.versioned("images/logo.jpg")),format.raw/*12.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*17.6*/views/*17.11*/.html.iot.tags.Main_css()),format.raw/*17.36*/("""

    """),format.raw/*19.5*/("""<style>
      .id_qrcode img """),format.raw/*20.22*/("""{"""),format.raw/*20.23*/("""
        """),format.raw/*21.9*/("""margin-top: 5px;
        margin-left: -5px;
      """),format.raw/*23.7*/("""}"""),format.raw/*23.8*/("""
    """),format.raw/*24.5*/("""</style>

  </head>
  <body class="bg-theme">
    """),_display_(/*28.6*/views/*28.11*/.html.iot.tags.Menu(currentUser, "")),format.raw/*28.47*/("""

    """),_display_(/*30.6*/views/*30.11*/.html.iot.tags.Header(currentUser)),format.raw/*30.45*/("""

    """),format.raw/*32.5*/("""<div class="page-wrapper">
      <div class="page-content">

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
                <i class="bx bxs-file-import" aria-hidden="true"></i> """),_display_(/*46.72*/Messages("Import")),format.raw/*46.90*/("""
              """),format.raw/*47.15*/("""</button>
              <button class="btn btn-danger px-5 radius-30" id="buttonSubmitImportCSV" data-bs-toggle="modal" data-bs-target="#addConfirmModal" hidden>
                <i class="bx bxs-file-import" aria-hidden="true"></i> """),_display_(/*49.72*/Messages("Submit")),format.raw/*49.90*/("""
              """),format.raw/*50.15*/("""</button>
              <button class="btn btn-danger px-5 radius-30" onclick="downloadCSVTemplate()">
                <i class="bx bx-download" aria-hidden="true"></i> """),_display_(/*52.68*/Messages("Download Template")),format.raw/*52.97*/("""
              """),format.raw/*53.15*/("""</button>
              <button class="btn btn-success px-5 radius-30" onclick="exportQrCodeList()">
                <i class="bx bxs-file-export" aria-hidden="true"></i> """),_display_(/*55.72*/Messages("Export")),format.raw/*55.90*/("""
              """),format.raw/*56.15*/("""</button>
            </div>
          </div>

          <div class="card-body">
            <div class="table-responsive">

              <table id="dataTables" class="table table-bordered">
                <thead class="cf">
                  <th>"""),_display_(/*65.24*/Messages("STT")),format.raw/*65.39*/("""</th>
                  <th>"""),_display_(/*66.24*/Messages("Serial")),format.raw/*66.42*/("""</th>
                  <th>"""),_display_(/*67.24*/Messages("Mac")),format.raw/*67.39*/("""</th>
                  <th>"""),_display_(/*68.24*/Messages("qr.QRCode")),format.raw/*68.45*/("""</th>
                  <th>"""),_display_(/*69.24*/Messages("btnDate")),format.raw/*69.43*/("""</th>
                  <th>"""),_display_(/*70.24*/Messages("btnAction")),format.raw/*70.45*/("""</th>
                </thead>
                <tbody align="left">
                """),_display_(/*73.18*/for((qr: QrCodeCam)<- qrCodeList) yield /*73.51*/ {_display_(Seq[Any](format.raw/*73.53*/("""
                  """),format.raw/*74.19*/("""<tr>
                    <td></td>
                    <td>"""),_display_(/*76.26*/qr/*76.28*/.getSerial),format.raw/*76.38*/("""</td>
                    <td>"""),_display_(/*77.26*/qr/*77.28*/.getMac),format.raw/*77.35*/("""</td>
                    <td>
                      <img src=""""),_display_(/*79.34*/qr/*79.36*/.getSrc),format.raw/*79.43*/("""" height="50">
                    </td>
                    <td>"""),_display_(/*81.26*/DateUtil/*81.34*/.getDateByFormat(qr.getLogDate, DateUtil.FORMAT_DATE_YYYY_MM_DD_HH_mm_ss)),format.raw/*81.107*/("""</td>
                    <td class="dt-buttons btn-group" style="width: 90%">
                      <a rel="tooltip" title=""""),_display_(/*83.48*/Messages("btnView")),format.raw/*83.67*/("""" class="btn btn-light">
                        <i class="bx bx-link me-0"></i>
                      </a>
                      <a rel="tooltip" title=""""),_display_(/*86.48*/Messages("btnDelete")),format.raw/*86.69*/("""" class="btn btn-light" onclick="setDeleteQr('"""),_display_(/*86.116*/qr/*86.118*/.getId),format.raw/*86.124*/("""')" data-bs-toggle="modal" data-bs-target="#deleteQrConfirm">
                        <i class="bx bx-x me-0"></i>
                      </a>
                    </td>
                  </tr>
                """)))}),format.raw/*91.18*/("""
                """),format.raw/*92.17*/("""</tbody>
              </table>

            </div>
          </div>
        </div>
      </div>

      """),_display_(/*100.8*/views/*100.13*/.html.qrCodeCam.QrCode_create()),format.raw/*100.44*/("""
      """),format.raw/*101.51*/("""
      """),_display_(/*102.8*/views/*102.13*/.html.qrCodeCam.QrCode_delete()),format.raw/*102.44*/("""


    """),format.raw/*105.5*/("""</div>
      <!--  END OF PAPER WRAP -->
    """),_display_(/*107.6*/views/*107.11*/.html.Loading()),format.raw/*107.26*/("""

  """),format.raw/*109.3*/("""</body>

  """),_display_(/*111.4*/views/*111.9*/.html.iot.tags.Main_js()),format.raw/*111.33*/("""

  """),format.raw/*113.3*/("""<script src=""""),_display_(/*113.17*/routes/*113.23*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*113.77*/(""""></script>
    <!--plugins-->
  <script src=""""),_display_(/*115.17*/routes/*115.23*/.Assets.versioned("assets/plugins/simplebar/js/simplebar.min.js")),format.raw/*115.88*/(""""></script>
  <script src=""""),_display_(/*116.17*/routes/*116.23*/.Assets.versioned("assets/plugins/metismenu/js/metisMenu.min.js")),format.raw/*116.88*/(""""></script>
  <script src=""""),_display_(/*117.17*/routes/*117.23*/.Assets.versioned("assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js")),format.raw/*117.100*/(""""></script>
  <script>
          $(document).ready(function () """),format.raw/*119.41*/("""{"""),format.raw/*119.42*/("""
            """),format.raw/*120.13*/("""$("#menu-qrCode").addClass("mm-active");
            $("#menu").metisMenu();
          """),format.raw/*122.11*/("""}"""),format.raw/*122.12*/(""")
  </script>

  <script src=""""),_display_(/*125.17*/routes/*125.23*/.Assets.versioned("javascripts/SearchJs.js")),format.raw/*125.67*/("""" type="text/javascript"></script>

  <script>
          $(document).ready(function() """),format.raw/*128.40*/("""{"""),format.raw/*128.41*/("""
            """),format.raw/*129.13*/("""var table = $('#dataTables').DataTable( """),format.raw/*129.53*/("""{"""),format.raw/*129.54*/("""
              """),format.raw/*130.15*/("""lengthChange: false,
              buttons: [ 'excel', 'pdf', 'print'],
              "order": []
            """),format.raw/*133.13*/("""}"""),format.raw/*133.14*/(""" """),format.raw/*133.15*/(""");

            table.on('order.dt search.dt', function () """),format.raw/*135.56*/("""{"""),format.raw/*135.57*/("""
              """),format.raw/*136.15*/("""table.column(0, """),format.raw/*136.31*/("""{"""),format.raw/*136.32*/("""search:'applied', order:'applied'"""),format.raw/*136.65*/("""}"""),format.raw/*136.66*/(""").nodes().each( function (cell, i) """),format.raw/*136.101*/("""{"""),format.raw/*136.102*/("""
                """),format.raw/*137.17*/("""cell.innerHTML = i+1;
              """),format.raw/*138.15*/("""}"""),format.raw/*138.16*/(""" """),format.raw/*138.17*/(""");
            """),format.raw/*139.13*/("""}"""),format.raw/*139.14*/(""" """),format.raw/*139.15*/(""").draw();

          """),format.raw/*141.11*/("""}"""),format.raw/*141.12*/(""");
  </script>

  <script src=""""),_display_(/*144.17*/routes/*144.23*/.Assets.versioned("javascripts/jquery/jquery-csv.js")),format.raw/*144.76*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*145.17*/routes/*145.23*/.Assets.versioned("javascripts/qrCode/cam/downloadTemplate.js")),format.raw/*145.86*/("""" type="text/javascript"></script>

  <script type="text/javascript">
          $(document).ready(function()"""),format.raw/*148.39*/("""{"""),format.raw/*148.40*/("""
            """),format.raw/*149.13*/("""document.getElementById('files').addEventListener('change', upload, false);
          """),format.raw/*150.11*/("""}"""),format.raw/*150.12*/(""");

          var viettel3x = '"""),_display_(/*152.29*/routes/*152.35*/.Assets.versioned("images/cam/viettel3x.png")),format.raw/*152.80*/("""';
    var re3x = '"""),_display_(/*153.18*/routes/*153.24*/.Assets.versioned("images/cam/re3x.png")),format.raw/*153.64*/("""';
    var ro3x = '"""),_display_(/*154.18*/routes/*154.24*/.Assets.versioned("images/cam/ro3x.png")),format.raw/*154.64*/("""';

  </script>

  <script type="text/javascript" src=""""),_display_(/*158.40*/routes/*158.46*/.Assets.versioned("javascripts/exportZip/jszip.js")),format.raw/*158.97*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*159.40*/routes/*159.46*/.Assets.versioned("javascripts/exportZip/jszip-utils.js")),format.raw/*159.103*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*160.40*/routes/*160.46*/.Assets.versioned("javascripts/exportZip/FileSaver.js")),format.raw/*160.101*/(""""></script>

  <script src=""""),_display_(/*162.17*/routes/*162.23*/.Assets.versioned("javascripts/qrCode/cam/screenshots/jspdf.umd.min.js")),format.raw/*162.95*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*163.17*/routes/*163.23*/.Assets.versioned("javascripts/qrCode/cam/screenshots/html2canvas2.min.js")),format.raw/*163.98*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*165.17*/routes/*165.23*/.Assets.versioned("javascripts/qrCode/qrcode.min.js")),format.raw/*165.76*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*166.17*/routes/*166.23*/.Assets.versioned("javascripts/qrCode/cam/QrCodeCam.js")),format.raw/*166.79*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*167.17*/routes/*167.23*/.Assets.versioned("javascripts/qrCode/cam/ImportQrCam.js")),format.raw/*167.81*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*169.17*/routes/*169.23*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*169.82*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*170.17*/routes/*170.23*/.Assets.versioned("javascripts/qrCode/exportQrCode.js")),format.raw/*170.78*/("""" type="text/javascript"></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,qrCodeList:List[QrCodeCam]): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,qrCodeList)

  def f:((User,List[QrCodeCam]) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,qrCodeList) => apply(currentUser,qrCodeList)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:49 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/qrCodeCam/QcCode.scala.html
                  HASH: cafeb48e995fbd6c1f7089b36e31c1b76e7f77b1
                  MATRIX: 661->1|684->18|720->48|760->82|1114->118|1256->165|1283->166|1452->308|1496->331|1577->385|1592->391|1649->427|1856->608|1870->613|1916->638|1949->644|2006->673|2035->674|2071->683|2148->733|2176->734|2208->739|2285->790|2299->795|2356->831|2389->838|2403->843|2458->877|2491->883|3189->1554|3228->1572|3271->1587|3531->1820|3570->1838|3613->1853|3810->2023|3860->2052|3903->2067|4102->2239|4141->2257|4184->2272|4461->2522|4497->2537|4553->2566|4592->2584|4648->2613|4684->2628|4740->2657|4782->2678|4838->2707|4878->2726|4934->2755|4976->2776|5088->2861|5137->2894|5177->2896|5224->2915|5311->2975|5322->2977|5353->2987|5411->3018|5422->3020|5450->3027|5541->3091|5552->3093|5580->3100|5673->3166|5690->3174|5785->3247|5938->3373|5978->3392|6160->3547|6202->3568|6277->3615|6289->3617|6317->3623|6557->3832|6602->3849|6734->3954|6749->3959|6802->3990|6838->4041|6873->4049|6888->4054|6941->4085|6976->4092|7049->4138|7064->4143|7101->4158|7133->4162|7172->4174|7186->4179|7232->4203|7264->4207|7306->4221|7322->4227|7398->4281|7473->4328|7489->4334|7576->4399|7632->4427|7648->4433|7735->4498|7791->4526|7807->4532|7907->4609|7999->4672|8029->4673|8071->4686|8187->4773|8217->4774|8276->4805|8292->4811|8358->4855|8473->4941|8503->4942|8545->4955|8614->4995|8644->4996|8688->5011|8827->5121|8857->5122|8887->5123|8975->5182|9005->5183|9049->5198|9094->5214|9124->5215|9186->5248|9216->5249|9281->5284|9312->5285|9358->5302|9423->5338|9453->5339|9483->5340|9527->5355|9557->5356|9587->5357|9637->5378|9667->5379|9727->5411|9743->5417|9818->5470|9897->5521|9913->5527|9998->5590|10135->5698|10165->5699|10207->5712|10322->5798|10352->5799|10412->5831|10428->5837|10495->5882|10543->5902|10559->5908|10621->5948|10669->5968|10685->5974|10747->6014|10831->6070|10847->6076|10920->6127|10999->6178|11015->6184|11095->6241|11174->6292|11190->6298|11268->6353|11325->6382|11341->6388|11435->6460|11514->6511|11530->6517|11627->6592|11707->6644|11723->6650|11798->6703|11877->6754|11893->6760|11971->6816|12050->6867|12066->6873|12146->6931|12226->6983|12242->6989|12323->7048|12402->7099|12418->7105|12495->7160
                  LINES: 24->1|25->2|26->3|27->4|32->5|37->5|38->6|43->11|43->11|44->12|44->12|44->12|49->17|49->17|49->17|51->19|52->20|52->20|53->21|55->23|55->23|56->24|60->28|60->28|60->28|62->30|62->30|62->30|64->32|78->46|78->46|79->47|81->49|81->49|82->50|84->52|84->52|85->53|87->55|87->55|88->56|97->65|97->65|98->66|98->66|99->67|99->67|100->68|100->68|101->69|101->69|102->70|102->70|105->73|105->73|105->73|106->74|108->76|108->76|108->76|109->77|109->77|109->77|111->79|111->79|111->79|113->81|113->81|113->81|115->83|115->83|118->86|118->86|118->86|118->86|118->86|123->91|124->92|132->100|132->100|132->100|133->101|134->102|134->102|134->102|137->105|139->107|139->107|139->107|141->109|143->111|143->111|143->111|145->113|145->113|145->113|145->113|147->115|147->115|147->115|148->116|148->116|148->116|149->117|149->117|149->117|151->119|151->119|152->120|154->122|154->122|157->125|157->125|157->125|160->128|160->128|161->129|161->129|161->129|162->130|165->133|165->133|165->133|167->135|167->135|168->136|168->136|168->136|168->136|168->136|168->136|168->136|169->137|170->138|170->138|170->138|171->139|171->139|171->139|173->141|173->141|176->144|176->144|176->144|177->145|177->145|177->145|180->148|180->148|181->149|182->150|182->150|184->152|184->152|184->152|185->153|185->153|185->153|186->154|186->154|186->154|190->158|190->158|190->158|191->159|191->159|191->159|192->160|192->160|192->160|194->162|194->162|194->162|195->163|195->163|195->163|197->165|197->165|197->165|198->166|198->166|198->166|199->167|199->167|199->167|201->169|201->169|201->169|202->170|202->170|202->170
                  -- GENERATED --
              */
          