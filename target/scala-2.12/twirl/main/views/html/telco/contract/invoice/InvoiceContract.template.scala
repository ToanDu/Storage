
package views.html.telco.contract.invoice

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
/*1.2*/import vn.m2m.common.models.User
/*2.2*/import vn.m2m.utils.UserHelper

object InvoiceContract extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, contract:String, userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*52.22*/fromTime/*52.30*/ = {{
                      import java.util.Calendar
                      import java.text.SimpleDateFormat

                      val today = Calendar.getInstance
                      today.add(Calendar.MINUTE, +0);
                      val curTimeFormat = new SimpleDateFormat("MM/yyyy")
                      curTimeFormat.format(today.getTime)
                    }};
Seq[Any](format.raw/*3.52*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("invoice.contract.title")),_display_(/*9.48*/contract),format.raw/*9.56*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*17.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("assets/plugins/input-tags/css/tagsinput.css")),format.raw/*18.88*/("""" rel="stylesheet" />
    <link href='"""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*19.73*/("""' type='text/css'>
    <link href=""""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*20.99*/("""" rel="stylesheet">
    """),format.raw/*21.163*/("""
    """),format.raw/*22.5*/("""<link href=""""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("stylesheets/bootstrap/datepicker.min.css")),format.raw/*22.85*/("""" rel="stylesheet" />

    <link href=""""),_display_(/*24.18*/routes/*24.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*24.78*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*28.6*/views/*28.11*/.html.telco.Menu(currentUser, "", userId)),format.raw/*28.52*/("""

    """),_display_(/*30.6*/views/*30.11*/.html.telco.Header(currentUser)),format.raw/*30.42*/("""

    """),format.raw/*32.5*/("""<div class="page-wrapper">
      <div class="page-content">
        <div class="card">
          <div class="card-body">
            <span class="text-search">"""),_display_(/*36.40*/Messages("invoice.contract.listTitle")),format.raw/*36.78*/("""</span>
            <div class="row mt-3">
              <div class="col-md-6 m-t-3">
                <div class="row m-b-4">
                  <div class="col-sm-1"></div>
                  <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*41.75*/Messages("invoice.contract.contractNumber")),format.raw/*41.118*/("""</label>
                  <div class="col-sm-8">
                    <input id="contractId" type="text" class="form-control input-form" value=""""),_display_(/*43.96*/contract),format.raw/*43.104*/("""" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-6 m-t-3">
                <div class="row m-b-4">
                  <div class="col-sm-1"></div>
                  <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*50.75*/Messages("invoice.contract.selectMonth")),format.raw/*50.115*/("""</label>
                  <div class="col-sm-8">
                    """),format.raw/*60.22*/("""
                    """),format.raw/*61.21*/("""<input class="form-control datetimepicker" type="text" id="monthInvoice" value=""""),_display_(/*61.102*/fromTime),format.raw/*61.110*/("""" placeholder=""""),_display_(/*61.126*/Messages("invoice.contract.monthPlaceholder")),format.raw/*61.171*/("""">
                  </div>
                </div>
              </div>
            </div>
            <div class="d-flex flex-column align-items-center text-center">
              <div class="">
                <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="exportInvoiceCSV()">"""),_display_(/*68.141*/Messages("invoice.contract.exportCSV")),format.raw/*68.179*/("""</button>
                <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF;" onclick="getListInvoiceOfContract()">"""),_display_(/*69.149*/Messages("invoice.contract.lookup")),format.raw/*69.184*/("""</button>
              </div>
            </div>
          </div>
        </div>

        <div class="card">
          <div class="card-body" style="border-radius: 8px;" id="divTableInvoice">
            <table class="table" id="tableListInvoice" style="width: 100%;">
              <thead style="background-color: #ff000054;">
                <tr>
                  <th>"""),_display_(/*80.24*/Messages("invoice.contract.table.stt")),format.raw/*80.62*/("""</th>
                  <th>"""),_display_(/*81.24*/Messages("invoice.contract.table.invoiceNumber")),format.raw/*81.72*/("""</th>
                  <th>"""),_display_(/*82.24*/Messages("invoice.contract.table.type")),format.raw/*82.63*/("""</th>
                  <th>"""),_display_(/*83.24*/Messages("invoice.contract.table.beforeTax")),format.raw/*83.68*/("""</th>
                  <th>"""),_display_(/*84.24*/Messages("invoice.contract.table.afterTax")),format.raw/*84.67*/("""</th>
                  <th>"""),_display_(/*85.24*/Messages("invoice.contract.table.assignDate")),format.raw/*85.69*/("""</th>
                  """),_display_(/*86.20*/if(UserHelper.isFeatureRole(currentUser, "download_invoice"))/*86.81*/{_display_(Seq[Any](format.raw/*86.82*/("""
                    """),format.raw/*87.21*/("""<th>"""),_display_(/*87.26*/Messages("invoice.contract.table.actions")),format.raw/*87.68*/("""</th>
                  """)))}),format.raw/*88.20*/("""
                """),format.raw/*89.17*/("""</tr>
              </thead>
              <tbody></tbody>
            </table>
          </div>
          <h5 id="notiNotDatatable" style="text-align: center;"></h5>
        </div>

      </div>

      """),_display_(/*99.8*/views/*99.13*/.html.telco.Loading()),format.raw/*99.34*/("""

    """),format.raw/*101.5*/("""</div>
      <!--  END OF PAPER WRAP -->

    """),_display_(/*104.6*/views/*104.11*/.html.telco.mainJs()),format.raw/*104.31*/("""
    """),format.raw/*105.5*/("""<script src=""""),_display_(/*105.19*/routes/*105.25*/.Assets.versioned("javascripts/bootstrap/bootstrap-datepicker.min.js")),format.raw/*105.95*/("""" type="text/javascript"></script>

    <script>
            var contractId = '"""),_display_(/*108.32*/contract),format.raw/*108.40*/("""';
            var imgDefault = '"""),_display_(/*109.32*/routes/*109.38*/.Assets.versioned("images/market/default.png")),format.raw/*109.84*/("""';
            var isDownloadInvoice = '"""),_display_(/*110.39*/UserHelper/*110.49*/.isFeatureRole(currentUser, "download_invoice")),format.raw/*110.96*/("""';
            console.log(isDownloadInvoice + " isDownloadInvoice");
            $(document).ready(function () """),format.raw/*112.43*/("""{"""),format.raw/*112.44*/("""
              """),format.raw/*113.15*/("""$("#menu-contractManage").addClass("mm-active");
              $("#menu").metisMenu();

              $('.datetimepicker').datepicker("""),format.raw/*116.47*/("""{"""),format.raw/*116.48*/("""
                """),format.raw/*117.17*/("""format: 'mm/yyyy',
                startView: "months",
                minViewMode: "months"
              """),format.raw/*120.15*/("""}"""),format.raw/*120.16*/(""");
            """),format.raw/*121.13*/("""}"""),format.raw/*121.14*/(""")
    </script>

    <script src=""""),_display_(/*124.19*/routes/*124.25*/.Assets.versioned("javascripts/views/telco/contract/invoice/invoice.js")),format.raw/*124.97*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*125.19*/routes/*125.25*/.Assets.versioned("javascripts/views/telco/contract/invoice/invoice_export.js")),format.raw/*125.104*/("""" type="text/javascript"></script>

  </body>
</html>
"""))
      }
    }
  }

  def render(currentUser:User,contract:String,userId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,contract,userId)

  def f:((User,String,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,contract,userId) => apply(currentUser,contract,userId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:52 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/contract/invoice/InvoiceContract.scala.html
                  HASH: 54d8027963c5bd82835e1433e017cc7939f0660a
                  MATRIX: 674->1|714->35|1071->67|1201->2572|1218->2580|1621->117|1648->118|1816->260|1870->295|1898->303|1979->357|1994->363|2051->399|2258->580|2272->585|2318->610|2351->616|2391->629|2406->635|2481->689|2547->728|2562->734|2647->798|2713->837|2728->843|2798->892|2861->928|2876->934|2972->1009|3025->1191|3057->1196|3097->1209|3112->1215|3194->1276|3261->1316|3276->1322|3351->1376|3441->1440|3455->1445|3517->1486|3550->1493|3564->1498|3616->1529|3649->1535|3836->1695|3895->1733|4169->1980|4234->2023|4406->2168|4436->2176|4748->2461|4810->2501|4908->2953|4957->2974|5066->3055|5096->3063|5140->3079|5207->3124|5571->3460|5631->3498|5817->3656|5874->3691|6274->4064|6333->4102|6389->4131|6458->4179|6514->4208|6574->4247|6630->4276|6695->4320|6751->4349|6815->4392|6871->4421|6937->4466|6989->4491|7059->4552|7098->4553|7147->4574|7179->4579|7242->4621|7298->4646|7343->4663|7573->4867|7587->4872|7629->4893|7663->4899|7737->4946|7752->4951|7794->4971|7827->4976|7869->4990|7885->4996|7977->5066|8085->5146|8115->5154|8177->5188|8193->5194|8261->5240|8330->5281|8350->5291|8419->5338|8560->5450|8590->5451|8634->5466|8797->5600|8827->5601|8873->5618|9010->5726|9040->5727|9084->5742|9114->5743|9177->5778|9193->5784|9287->5856|9368->5909|9384->5915|9486->5994
                  LINES: 24->1|25->2|30->3|34->52|34->52|43->3|44->4|49->9|49->9|49->9|50->10|50->10|50->10|55->15|55->15|55->15|57->17|57->17|57->17|57->17|58->18|58->18|58->18|59->19|59->19|59->19|60->20|60->20|60->20|61->21|62->22|62->22|62->22|62->22|64->24|64->24|64->24|68->28|68->28|68->28|70->30|70->30|70->30|72->32|76->36|76->36|81->41|81->41|83->43|83->43|90->50|90->50|92->60|93->61|93->61|93->61|93->61|93->61|100->68|100->68|101->69|101->69|112->80|112->80|113->81|113->81|114->82|114->82|115->83|115->83|116->84|116->84|117->85|117->85|118->86|118->86|118->86|119->87|119->87|119->87|120->88|121->89|131->99|131->99|131->99|133->101|136->104|136->104|136->104|137->105|137->105|137->105|137->105|140->108|140->108|141->109|141->109|141->109|142->110|142->110|142->110|144->112|144->112|145->113|148->116|148->116|149->117|152->120|152->120|153->121|153->121|156->124|156->124|156->124|157->125|157->125|157->125
                  -- GENERATED --
              */
          