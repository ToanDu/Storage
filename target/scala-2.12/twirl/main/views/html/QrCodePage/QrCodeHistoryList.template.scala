
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
/*4.2*/import vn.m2m.iot.models.QrCodeHistory

object QrCodeHistoryList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,List[QrCodeHistory],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(currentUser:User, qrCodeList: List[QrCodeHistory]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.53*/("""
"""),format.raw/*6.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*11.13*/Messages("QR Code History")),format.raw/*11.40*/("""</title>
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
                <li class="breadcrumb-item active " aria-current="page">"""),_display_(/*39.74*/Messages("manage.qrCodeHistory")),format.raw/*39.106*/("""</li>
              </ol>
            </nav>
          </div>
          <div class="ms-auto">

          </div>
        </div>
          <!--end breadcrumb-->

        <div class="card ">
          <div class="card-header card-header-primary card-header-icon">
            <div class="toolbar" style="float: right">
              <button class="btn btn-success px-5 radius-30" onclick="exportQrCodeList()">
                <i class="bx bxs-printer" aria-hidden="true"></i> """),_display_(/*53.68*/Messages("Print")),format.raw/*53.85*/("""
              """),format.raw/*54.15*/("""</button>
            </div>
          </div>

          <div class="card-body">
            <div class="table-responsive">

              <table id="dataTables" class="table table-bordered">
                <thead class="cf">
                  <th>"""),_display_(/*63.24*/Messages("qr.id")),format.raw/*63.41*/("""</th>
                  <th>"""),_display_(/*64.24*/Messages("qr.Name")),format.raw/*64.43*/("""</th>
                  <th>"""),_display_(/*65.24*/Messages("qr.Link")),format.raw/*65.43*/("""</th>
                  <th>"""),_display_(/*66.24*/Messages("qr.QRCode")),format.raw/*66.45*/("""</th>
                  <th>"""),_display_(/*67.24*/Messages("btnDate")),format.raw/*67.43*/("""</th>
                  <th>"""),_display_(/*68.24*/Messages("btnAction")),format.raw/*68.45*/("""</th>
                </thead>
                <tbody align="left">
                """),_display_(/*71.18*/for((qr: QrCodeHistory)<- qrCodeList) yield /*71.55*/ {_display_(Seq[Any](format.raw/*71.57*/("""
                  """),format.raw/*72.19*/("""<tr>
                    <td>"""),_display_(/*73.26*/qr/*73.28*/.getId),format.raw/*73.34*/("""</td>
                    <td>"""),_display_(/*74.26*/qr/*74.28*/.getName),format.raw/*74.36*/("""</td>
                    <td>"""),_display_(/*75.26*/qr/*75.28*/.getLinkAndroid),format.raw/*75.43*/("""<br>"""),_display_(/*75.48*/qr/*75.50*/.getLinkIos),format.raw/*75.61*/("""</td>
                    <td>
                      <img src=""""),_display_(/*77.34*/qr/*77.36*/.getSrc),format.raw/*77.43*/("""" height="50">
                    </td>
                    <td>"""),_display_(/*79.26*/DateUtil/*79.34*/.getDateByFormat(qr.getCreateDate, DateUtil.FORMAT_DATE_YYYY_MM_DD_HH_mm_ss)),format.raw/*79.110*/("""</td>
                    <td>"""),_display_(/*80.26*/qr/*80.28*/.getAction),format.raw/*80.38*/("""</td>
                  </tr>
                """)))}),format.raw/*82.18*/("""
                """),format.raw/*83.17*/("""</tbody>
              </table>

            </div>
          </div>
        </div>
      </div>
    </div>
      <!--  END OF PAPER WRAP -->
    """),_display_(/*92.6*/views/*92.11*/.html.Loading()),format.raw/*92.26*/("""

  """),format.raw/*94.3*/("""</body>

  """),_display_(/*96.4*/views/*96.9*/.html.iot.tags.Main_js()),format.raw/*96.33*/("""

  """),format.raw/*98.3*/("""<script src=""""),_display_(/*98.17*/routes/*98.23*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*98.77*/(""""></script>
    <!--plugins-->
  <script src=""""),_display_(/*100.17*/routes/*100.23*/.Assets.versioned("assets/plugins/simplebar/js/simplebar.min.js")),format.raw/*100.88*/(""""></script>
  <script src=""""),_display_(/*101.17*/routes/*101.23*/.Assets.versioned("assets/plugins/metismenu/js/metisMenu.min.js")),format.raw/*101.88*/(""""></script>
  <script src=""""),_display_(/*102.17*/routes/*102.23*/.Assets.versioned("assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js")),format.raw/*102.100*/(""""></script>
  <script>
          $(document).ready(function () """),format.raw/*104.41*/("""{"""),format.raw/*104.42*/("""
            """),format.raw/*105.13*/("""$("#menu-qrCodeHistory").addClass("mm-active");
          """),format.raw/*106.11*/("""}"""),format.raw/*106.12*/(""")
  </script>

  <script src=""""),_display_(/*109.17*/routes/*109.23*/.Assets.versioned("javascripts/SearchJs.js")),format.raw/*109.67*/("""" type="text/javascript"></script>

  <script>
          $(document).ready(function() """),format.raw/*112.40*/("""{"""),format.raw/*112.41*/("""
            """),format.raw/*113.13*/("""var table = $('#dataTables').DataTable( """),format.raw/*113.53*/("""{"""),format.raw/*113.54*/("""
              """),format.raw/*114.15*/("""lengthChange: false,
              buttons: [ 'excel', 'pdf', 'print'],
              "order": []
            """),format.raw/*117.13*/("""}"""),format.raw/*117.14*/(""" """),format.raw/*117.15*/(""");

//            table.buttons().container()
//                    .appendTo( '#dataTables_wrapper .col-md-6:eq(0)' );
          """),format.raw/*121.11*/("""}"""),format.raw/*121.12*/(""" """),format.raw/*121.13*/(""");
  </script>

  <script src=""""),_display_(/*124.17*/routes/*124.23*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*124.82*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*125.17*/routes/*125.23*/.Assets.versioned("javascripts/qrCode/exportQrCode.js")),format.raw/*125.78*/("""" type="text/javascript"></script>
</html>
"""))
      }
    }
  }

  def render(currentUser:User,qrCodeList:List[QrCodeHistory]): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,qrCodeList)

  def f:((User,List[QrCodeHistory]) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,qrCodeList) => apply(currentUser,qrCodeList)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:49 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/QrCodePage/QrCodeHistoryList.scala.html
                  HASH: 48c1bfd5a4cea08a68da0ecdf46fa090a83b39aa
                  MATRIX: 662->1|685->18|721->48|761->82|1134->122|1280->173|1307->174|1476->316|1524->343|1605->397|1620->403|1677->439|1884->620|1898->625|1944->650|1977->656|2017->669|2032->675|2111->733|2177->772|2192->778|2267->832|2357->896|2371->901|2428->937|2461->944|2475->949|2530->983|2563->989|2805->1204|2845->1223|3195->1546|3249->1578|3750->2052|3788->2069|3831->2084|4108->2334|4146->2351|4202->2380|4242->2399|4298->2428|4338->2447|4394->2476|4436->2497|4492->2526|4532->2545|4588->2574|4630->2595|4742->2680|4795->2717|4835->2719|4882->2738|4939->2768|4950->2770|4977->2776|5035->2807|5046->2809|5075->2817|5133->2848|5144->2850|5180->2865|5212->2870|5223->2872|5255->2883|5346->2947|5357->2949|5385->2956|5478->3022|5495->3030|5593->3106|5651->3137|5662->3139|5693->3149|5771->3196|5816->3213|5989->3360|6003->3365|6039->3380|6070->3384|6108->3396|6121->3401|6166->3425|6197->3429|6238->3443|6253->3449|6328->3503|6403->3550|6419->3556|6506->3621|6562->3649|6578->3655|6665->3720|6721->3748|6737->3754|6837->3831|6929->3894|6959->3895|7001->3908|7088->3966|7118->3967|7177->3998|7193->4004|7259->4048|7374->4134|7404->4135|7446->4148|7515->4188|7545->4189|7589->4204|7728->4314|7758->4315|7788->4316|7947->4446|7977->4447|8007->4448|8067->4480|8083->4486|8164->4545|8243->4596|8259->4602|8336->4657
                  LINES: 24->1|25->2|26->3|27->4|32->5|37->5|38->6|43->11|43->11|44->12|44->12|44->12|49->17|49->17|49->17|51->19|51->19|51->19|51->19|52->20|52->20|52->20|56->24|56->24|56->24|58->26|58->26|58->26|60->28|65->33|65->33|71->39|71->39|85->53|85->53|86->54|95->63|95->63|96->64|96->64|97->65|97->65|98->66|98->66|99->67|99->67|100->68|100->68|103->71|103->71|103->71|104->72|105->73|105->73|105->73|106->74|106->74|106->74|107->75|107->75|107->75|107->75|107->75|107->75|109->77|109->77|109->77|111->79|111->79|111->79|112->80|112->80|112->80|114->82|115->83|124->92|124->92|124->92|126->94|128->96|128->96|128->96|130->98|130->98|130->98|130->98|132->100|132->100|132->100|133->101|133->101|133->101|134->102|134->102|134->102|136->104|136->104|137->105|138->106|138->106|141->109|141->109|141->109|144->112|144->112|145->113|145->113|145->113|146->114|149->117|149->117|149->117|153->121|153->121|153->121|156->124|156->124|156->124|157->125|157->125|157->125
                  -- GENERATED --
              */
          