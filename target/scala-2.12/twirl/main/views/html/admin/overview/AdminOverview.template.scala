
package views.html.admin.overview

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

object AdminOverview extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("Admin Overview")),format.raw/*9.39*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

      """),format.raw/*17.7*/("""<link href=""""),_display_(/*17.20*/routes/*17.26*/.Assets.versioned("stylesheets/views/admin/multiselect.css")),format.raw/*17.86*/("""" rel="stylesheet" />
      <link href='"""),_display_(/*18.20*/routes/*18.26*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*18.75*/("""' type='text/css'>
      <link href=""""),_display_(/*19.20*/routes/*19.26*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*19.101*/("""" rel="stylesheet">
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" >
      <link href=""""),_display_(/*21.20*/routes/*21.26*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*21.141*/("""" rel="stylesheet" >

      <style>
          /*tbody tr:hover """),format.raw/*24.28*/("""{"""),format.raw/*24.29*/("""*/
              /*background-color: #ff6687;*/
              /*color: white;*/
          /*"""),format.raw/*27.13*/("""}"""),format.raw/*27.14*/("""*/
          tr th:hover """),format.raw/*28.23*/("""{"""),format.raw/*28.24*/("""
             """),format.raw/*29.14*/("""cursor: pointer;
          """),format.raw/*30.11*/("""}"""),format.raw/*30.12*/("""
          """),format.raw/*31.11*/(""".limitName """),format.raw/*31.22*/("""{"""),format.raw/*31.23*/("""
              """),format.raw/*32.15*/("""overflow: hidden;
              white-space: nowrap;
              text-overflow: ellipsis;
              max-width: 150px;
              font-weight: 600;
              font-size: 18px;
              line-height: 26px;
              letter-spacing: 0.75px;
          """),format.raw/*40.11*/("""}"""),format.raw/*40.12*/("""
          """),format.raw/*41.11*/(""".limitDescription """),format.raw/*41.29*/("""{"""),format.raw/*41.30*/("""
              """),format.raw/*42.15*/("""overflow: hidden;
              white-space: nowrap;
              text-overflow: ellipsis;
              max-width: 150px;
              font-weight: 300;
              font-size: 14px;
              line-height: 20px;
              letter-spacing: 0.5px;
          """),format.raw/*50.11*/("""}"""),format.raw/*50.12*/("""
          """),format.raw/*51.11*/(""".limitEmail """),format.raw/*51.23*/("""{"""),format.raw/*51.24*/("""
              """),format.raw/*52.15*/("""overflow: hidden;
              white-space: nowrap;
              text-overflow: ellipsis;
              max-width: 150px;
              font-weight: 400;
              font-size: 16px;
              line-height: 26px;
              letter-spacing: 0.6px;
          """),format.raw/*60.11*/("""}"""),format.raw/*60.12*/("""
          """),format.raw/*61.11*/(""".btn-flat """),format.raw/*61.21*/("""{"""),format.raw/*61.22*/("""
              """),format.raw/*62.15*/("""color: white;
          """),format.raw/*63.11*/("""}"""),format.raw/*63.12*/("""
      """),format.raw/*64.7*/("""</style>

  </head>
  <body class="bg-theme">
    """),_display_(/*68.6*/views/*68.11*/.html.admin.navbar()),format.raw/*68.31*/("""

    """),_display_(/*70.6*/views/*70.11*/.html.admin.header(currentUser)),format.raw/*70.42*/("""

      """),format.raw/*72.7*/("""<div class="page-wrapper pb-5" style="background-color: white;">
          <div class="page-content">

              <div class="col-md-12">
                  <div class="row mb-4">
                      <div class="breadcrumb-title pe-3" style="font-weight: 500;">"""),_display_(/*77.85*/Messages("TỔNG QUAN")),format.raw/*77.106*/("""</div>
                  </div>
              </div>

              """),_display_(/*81.16*/views/*81.21*/.html.admin.overview.AdminOverview_total()),format.raw/*81.63*/("""

              """),format.raw/*83.15*/("""<div class="col-md-12 mt-4">
                  <div class="row mb-4">
                      <div class="breadcrumb-title pe-3" style="font-weight: 500;">"""),_display_(/*85.85*/Messages("DANH SÁCH DỰ ÁN")),format.raw/*85.112*/("""</div>
                  </div>
              </div>

              """),_display_(/*89.16*/views/*89.21*/.html.admin.overview.AdminOverview_projectList()),format.raw/*89.69*/("""

          """),format.raw/*91.11*/("""</div>
      </div>
    <!--  END OF PAPER WRAP -->
    """),_display_(/*94.6*/views/*94.11*/.html.Loading()),format.raw/*94.26*/("""

  """),format.raw/*96.3*/("""</body>

  """),_display_(/*98.4*/views/*98.9*/.html.admin.mainJs()),format.raw/*98.29*/("""
  """),format.raw/*99.3*/("""<script src=""""),_display_(/*99.17*/routes/*99.23*/.Assets.versioned("assets/plugins/apexcharts-bundle/js/apexcharts.min.js")),format.raw/*99.97*/("""" type="text/javascript"></script>

    <script>
          $(document).ready(function () """),format.raw/*102.41*/("""{"""),format.raw/*102.42*/("""
            """),format.raw/*103.13*/("""$("#menu-adminOverview").addClass("mm-active");
            $("#menu").metisMenu();

              $("#test").CreateMultiCheckBox("""),format.raw/*106.46*/("""{"""),format.raw/*106.47*/(""" """),format.raw/*106.48*/("""width: '230px', defaultText : 'Theo lĩnh vực', height:'250px' """),format.raw/*106.110*/("""}"""),format.raw/*106.111*/(""");

              $('#date_timepicker_start').bootstrapMaterialDatePicker("""),format.raw/*108.71*/("""{"""),format.raw/*108.72*/("""
                  """),format.raw/*109.19*/("""format: 'DD-MM-YYYY',
                  time: false
              """),format.raw/*111.15*/("""}"""),format.raw/*111.16*/(""");
              $('#date_timepicker_end').bootstrapMaterialDatePicker("""),format.raw/*112.69*/("""{"""),format.raw/*112.70*/("""
                  """),format.raw/*113.19*/("""format: 'DD-MM-YYYY',
                  time: false
              """),format.raw/*115.15*/("""}"""),format.raw/*115.16*/(""");
          """),format.raw/*116.11*/("""}"""),format.raw/*116.12*/(""");

          var iconDefault = """"),_display_(/*118.31*/routes/*118.37*/.Assets.versioned("images/login/logo.svg")),format.raw/*118.79*/("""";
  </script>
  <script src=""""),_display_(/*120.17*/routes/*120.23*/.Assets.versioned("javascripts/views/admin/adminOverview/multiselect.js")),format.raw/*120.96*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*121.17*/routes/*121.23*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*121.82*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*123.17*/routes/*123.23*/.Assets.versioned("javascripts/views/admin/adminOverview/AdminOverview.js")),format.raw/*123.98*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*124.17*/routes/*124.23*/.Assets.versioned("javascripts/views/admin/adminOverview/AdminOverview_chart.js")),format.raw/*124.104*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*125.17*/routes/*125.23*/.Assets.versioned("javascripts/views/admin/adminOverview/AdminOverview_projectList.js")),format.raw/*125.110*/("""" type="text/javascript"></script>

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
                  DATE: Mon Sep 22 16:32:40 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/admin/overview/AdminOverview.scala.html
                  HASH: 4d1f5372cba6948770b12c8010b8604be16e62c1
                  MATRIX: 666->1|689->18|1032->52|1145->70|1172->71|1340->213|1386->239|1467->293|1482->299|1539->335|1746->516|1760->521|1806->546|1841->554|1881->567|1896->573|1977->633|2045->674|2060->680|2130->729|2195->767|2210->773|2307->848|2467->981|2482->987|2619->1102|2710->1165|2739->1166|2859->1258|2888->1259|2941->1284|2970->1285|3012->1299|3067->1326|3096->1327|3135->1338|3174->1349|3203->1350|3246->1365|3542->1633|3571->1634|3610->1645|3656->1663|3685->1664|3728->1679|4023->1946|4052->1947|4091->1958|4131->1970|4160->1971|4203->1986|4498->2253|4527->2254|4566->2265|4604->2275|4633->2276|4676->2291|4728->2315|4757->2316|4791->2323|4868->2374|4882->2379|4923->2399|4956->2406|4970->2411|5022->2442|5057->2450|5350->2716|5393->2737|5489->2806|5503->2811|5566->2853|5610->2869|5791->3023|5840->3050|5936->3119|5950->3124|6019->3172|6059->3184|6142->3241|6156->3246|6192->3261|6223->3265|6261->3277|6274->3282|6315->3302|6345->3305|6386->3319|6401->3325|6496->3399|6614->3488|6644->3489|6686->3502|6845->3632|6875->3633|6905->3634|6997->3696|7028->3697|7131->3771|7161->3772|7209->3791|7304->3857|7334->3858|7434->3929|7464->3930|7512->3949|7607->4015|7637->4016|7679->4029|7709->4030|7771->4064|7787->4070|7851->4112|7910->4143|7926->4149|8021->4222|8100->4273|8116->4279|8197->4338|8277->4390|8293->4396|8390->4471|8469->4522|8485->4528|8589->4609|8668->4660|8684->4666|8794->4753
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|51->19|51->19|53->21|53->21|53->21|56->24|56->24|59->27|59->27|60->28|60->28|61->29|62->30|62->30|63->31|63->31|63->31|64->32|72->40|72->40|73->41|73->41|73->41|74->42|82->50|82->50|83->51|83->51|83->51|84->52|92->60|92->60|93->61|93->61|93->61|94->62|95->63|95->63|96->64|100->68|100->68|100->68|102->70|102->70|102->70|104->72|109->77|109->77|113->81|113->81|113->81|115->83|117->85|117->85|121->89|121->89|121->89|123->91|126->94|126->94|126->94|128->96|130->98|130->98|130->98|131->99|131->99|131->99|131->99|134->102|134->102|135->103|138->106|138->106|138->106|138->106|138->106|140->108|140->108|141->109|143->111|143->111|144->112|144->112|145->113|147->115|147->115|148->116|148->116|150->118|150->118|150->118|152->120|152->120|152->120|153->121|153->121|153->121|155->123|155->123|155->123|156->124|156->124|156->124|157->125|157->125|157->125
                  -- GENERATED --
              */
          