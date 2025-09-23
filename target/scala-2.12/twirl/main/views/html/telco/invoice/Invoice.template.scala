
package views.html.telco.invoice

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
/*3.2*/import vn.m2m.utils.UserHelper

object Invoice extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(currentUser:User, userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.35*/("""
"""),format.raw/*5.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*10.13*/Messages("manage.group.bill")),format.raw/*10.42*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*11.46*/routes/*11.52*/.Assets.versioned("images/logo.jpg")),format.raw/*11.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*16.6*/views/*16.11*/.html.iot.tags.Main_css()),format.raw/*16.36*/("""

    """),format.raw/*18.5*/("""<link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*18.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("assets/plugins/input-tags/css/tagsinput.css")),format.raw/*19.88*/("""" rel="stylesheet" />
    """),format.raw/*20.96*/("""
    """),format.raw/*21.5*/("""<link href='"""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*21.73*/("""' type='text/css'>
    <link href=""""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*22.99*/("""" rel="stylesheet">
    <link href=""""),_display_(/*23.18*/routes/*23.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*23.139*/("""" rel="stylesheet" >
    <link href=""""),_display_(/*24.18*/routes/*24.24*/.Assets.versioned("stylesheets/component/Tabs.css")),format.raw/*24.75*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*25.18*/routes/*25.24*/.Assets.versioned("stylesheets/views/invoice/index.css")),format.raw/*25.80*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*26.18*/routes/*26.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*26.78*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*30.6*/views/*30.11*/.html.telco.Menu(currentUser, "", userId)),format.raw/*30.52*/("""
    """),_display_(/*31.6*/views/*31.11*/.html.telco.Header(currentUser)),format.raw/*31.42*/("""
    """),format.raw/*32.5*/("""<div class="page-wrapper">
      <div class="page-content">
        <div class="section features-1">
          <div class="container-1 bg-white" >
            <ul class="nav nav-tabs" role="tablist" id="invoiceTab">
              <li class="nav-item" role="presentation" onclick="">
                <a class="nav-link d-flex align-items-end gap-2 active display-4" id="service_invoice_tab" data-bs-toggle="tab" href="#tab1" role="tab"
                  aria-selected="false">
                  <img src=""""),_display_(/*40.30*/routes/*40.36*/.Assets.versioned("images/telco/information.svg")),format.raw/*40.85*/("""" class="icon-tab" alt="icon tab"/>
                  """),_display_(/*41.20*/Messages("invoice.service.title")),format.raw/*41.53*/("""
                """),format.raw/*42.17*/("""</a>
              </li>
              <li class="nav-item" role="presentation" onclick="">
                <a class="nav-link d-flex align-items-end gap-2 display-4" id="fee_invoice_tab" data-bs-toggle="tab" href="#tab2" role="tab"
                  aria-selected="false">
                  <img src=""""),_display_(/*47.30*/routes/*47.36*/.Assets.versioned("images/telco/childUser.svg")),format.raw/*47.83*/("""" class="icon-tab" alt="icon tab"/>
                  """),_display_(/*48.20*/Messages("invoice.fee.title")),format.raw/*48.49*/("""
                """),format.raw/*49.17*/("""</a>
              </li>
            </ul>
            <div class="tab-content tab-recharge">
              <div class="tab-pane fade show active" id="tab1" style="margin-bottom: 2rem;margin-top: 1rem" role="tabpanel">
                """),_display_(/*54.18*/views/*54.23*/.html.telco.invoice.service.searchForm()),format.raw/*54.63*/("""
                """),_display_(/*55.18*/views/*55.23*/.html.telco.invoice.service.invoiceTable()),format.raw/*55.65*/("""
              """),format.raw/*56.15*/("""</div>
    
              <div class="tab-pane fade" id="tab2" style="margin-bottom: 2rem;margin-top: 1rem" role="tabpanel">
                """),_display_(/*59.18*/views/*59.23*/.html.telco.invoice.fee.searchForm()),format.raw/*59.59*/("""
                """),_display_(/*60.18*/views/*60.23*/.html.telco.invoice.fee.invoiceTable()),format.raw/*60.61*/("""
              """),format.raw/*61.15*/("""</div>
            </div>
    
          </div>
        </div>
    
        <!-- form search -->
    
    
    
      </div>
    
      """),_display_(/*73.8*/views/*73.13*/.html.telco.Loading()),format.raw/*73.34*/("""
    
    """),format.raw/*75.5*/("""</div>
    """),_display_(/*76.6*/views/*76.11*/.html.telco.mainJs()),format.raw/*76.31*/("""
    """),_display_(/*77.6*/views/*77.11*/.html.telco.invoice.InvoiceProviewModal()),format.raw/*77.52*/("""
    """),format.raw/*78.5*/("""<script>
      var userId = '"""),_display_(/*79.22*/userId),format.raw/*79.28*/("""';
      $(document).ready(function () """),format.raw/*80.37*/("""{"""),format.raw/*80.38*/("""
        """),format.raw/*81.9*/("""$("#menu-InvoiceManage").addClass("mm-active");
        $("#menu").metisMenu();
      """),format.raw/*83.7*/("""}"""),format.raw/*83.8*/(""")

      $('#service_invoice #dateFrom').bootstrapMaterialDatePicker("""),format.raw/*85.67*/("""{"""),format.raw/*85.68*/("""
        """),format.raw/*86.9*/("""format: 'DD/MM/YYYY',
        time: false
      """),format.raw/*88.7*/("""}"""),format.raw/*88.8*/(""");
      $('#service_invoice #dateFrom').bootstrapMaterialDatePicker('setDate', moment().startOf('month'));
      $('#service_invoice #dateTo').bootstrapMaterialDatePicker("""),format.raw/*90.65*/("""{"""),format.raw/*90.66*/("""
        """),format.raw/*91.9*/("""format: 'DD/MM/YYYY',
        time: false
      """),format.raw/*93.7*/("""}"""),format.raw/*93.8*/(""");
      $('#service_invoice #dateTo').bootstrapMaterialDatePicker('setDate', moment());

      $('#fee_invoice #dateFrom').bootstrapMaterialDatePicker("""),format.raw/*96.63*/("""{"""),format.raw/*96.64*/("""
        """),format.raw/*97.9*/("""format: 'DD/MM/YYYY',
        time: false
      """),format.raw/*99.7*/("""}"""),format.raw/*99.8*/(""");
      $('#fee_invoice #dateFrom').bootstrapMaterialDatePicker('setDate', moment().startOf('month'));
      $('#fee_invoice #dateTo').bootstrapMaterialDatePicker("""),format.raw/*101.61*/("""{"""),format.raw/*101.62*/("""
        """),format.raw/*102.9*/("""format: 'DD/MM/YYYY',
        time: false
      """),format.raw/*104.7*/("""}"""),format.raw/*104.8*/(""");
      $('#fee_invoice #dateTo').bootstrapMaterialDatePicker('setDate', moment());
    </script>
    <script src=""""),_display_(/*107.19*/routes/*107.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*107.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*108.19*/routes/*108.25*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*108.85*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*109.19*/routes/*109.25*/.Assets.versioned("javascripts/views/telco/invoice/index.js")),format.raw/*109.86*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*110.19*/routes/*110.25*/.Assets.versioned("javascripts/views/telco/invoice/validate.js")),format.raw/*110.89*/("""" type="text/javascript"></script>
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
                  DATE: Mon Sep 22 16:32:53 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/invoice/Invoice.scala.html
                  HASH: 5567fd7f1152debcf1cfc5f395d942fc03d4aa65
                  MATRIX: 665->1|701->31|741->65|1083->97|1211->130|1238->131|1407->273|1457->302|1538->356|1553->362|1610->398|1817->579|1831->584|1877->609|1910->615|1950->628|1965->634|2040->688|2106->727|2121->733|2206->797|2260->914|2292->919|2332->932|2347->938|2417->987|2480->1023|2495->1029|2591->1104|2655->1141|2670->1147|2807->1262|2872->1300|2887->1306|2959->1357|3025->1396|3040->1402|3117->1458|3183->1497|3198->1503|3273->1557|3363->1621|3377->1626|3439->1667|3471->1673|3485->1678|3537->1709|3569->1714|4101->2219|4116->2225|4186->2274|4268->2329|4322->2362|4367->2379|4697->2682|4712->2688|4780->2735|4862->2790|4912->2819|4957->2836|5220->3072|5234->3077|5295->3117|5340->3135|5354->3140|5417->3182|5460->3197|5629->3339|5643->3344|5700->3380|5745->3398|5759->3403|5818->3441|5861->3456|6024->3593|6038->3598|6080->3619|6117->3629|6155->3641|6169->3646|6210->3666|6242->3672|6256->3677|6318->3718|6350->3723|6407->3753|6434->3759|6501->3798|6530->3799|6566->3808|6679->3894|6707->3895|6804->3964|6833->3965|6869->3974|6944->4022|6972->4023|7172->4195|7201->4196|7237->4205|7312->4253|7340->4254|7520->4406|7549->4407|7585->4416|7660->4464|7688->4465|7881->4629|7911->4630|7948->4639|8024->4687|8053->4688|8198->4805|8214->4811|8295->4870|8376->4923|8392->4929|8474->4989|8555->5042|8571->5048|8654->5109|8735->5162|8751->5168|8837->5232
                  LINES: 24->1|25->2|26->3|31->4|36->4|37->5|42->10|42->10|43->11|43->11|43->11|48->16|48->16|48->16|50->18|50->18|50->18|50->18|51->19|51->19|51->19|52->20|53->21|53->21|53->21|53->21|54->22|54->22|54->22|55->23|55->23|55->23|56->24|56->24|56->24|57->25|57->25|57->25|58->26|58->26|58->26|62->30|62->30|62->30|63->31|63->31|63->31|64->32|72->40|72->40|72->40|73->41|73->41|74->42|79->47|79->47|79->47|80->48|80->48|81->49|86->54|86->54|86->54|87->55|87->55|87->55|88->56|91->59|91->59|91->59|92->60|92->60|92->60|93->61|105->73|105->73|105->73|107->75|108->76|108->76|108->76|109->77|109->77|109->77|110->78|111->79|111->79|112->80|112->80|113->81|115->83|115->83|117->85|117->85|118->86|120->88|120->88|122->90|122->90|123->91|125->93|125->93|128->96|128->96|129->97|131->99|131->99|133->101|133->101|134->102|136->104|136->104|139->107|139->107|139->107|140->108|140->108|140->108|141->109|141->109|141->109|142->110|142->110|142->110
                  -- GENERATED --
              */
          