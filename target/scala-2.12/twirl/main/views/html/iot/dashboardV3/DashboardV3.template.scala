
package views.html.iot.dashboardV3

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
/*4.2*/import vn.m2m.utils.UserHelper

object DashboardV3 extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(currentUser:User, projectId:String, idDashboard:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.58*/("""

"""),format.raw/*7.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*12.13*/Messages("Dashboard")),format.raw/*12.34*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*13.46*/routes/*13.52*/.Assets.versioned("images/logo.jpg")),format.raw/*13.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*18.6*/views/*18.11*/.html.iot.tags.Main_css()),format.raw/*18.36*/("""

    """),format.raw/*20.5*/("""<link href=""""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("assets/plugins/highcharts/css/highcharts-white.css")),format.raw/*20.95*/("""" rel="stylesheet" />
    <script type="text/javascript" src=""""),_display_(/*21.42*/UserHelper/*21.52*/.linkGoogleMapApi),format.raw/*21.69*/(""""> </script>

    <link href=""""),_display_(/*23.18*/routes/*23.24*/.Assets.versioned("stylesheets/views/dashboard/ver2/dashboard.css")),format.raw/*23.91*/("""" rel="stylesheet"/>
    <link href=""""),_display_(/*24.18*/routes/*24.24*/.Assets.versioned("javascripts/views/dashboard/widget/gridstack.min.css")),format.raw/*24.97*/("""" rel="stylesheet"/>
    <link href=""""),_display_(/*25.18*/routes/*25.24*/.Assets.versioned("stylesheets/views/dashboard/widget/round-switch.css")),format.raw/*25.96*/("""" rel="stylesheet"/>
  </head>
  <body class="bg-theme">

    <div class="">
      """),_display_(/*30.8*/views/*30.13*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*30.56*/("""

      """),_display_(/*32.8*/views/*32.13*/.html.iot.tags.Header(currentUser)),format.raw/*32.47*/("""

      """),format.raw/*34.7*/("""<div class="page-wrapper" id="pageWrapper">
        <div class="grid-stack" data-gs-width="12" style="background-color: #eceff1" id="bodyDashboard">
        </div>

        """),format.raw/*38.121*/("""
        """),format.raw/*39.19*/("""
      """),format.raw/*40.7*/("""</div>

    </div>

    <div class="">
      <div class="toolbar" style="float: right; transition: 0.4s;position: fixed;bottom: 10px;right: 20px;z-index: 99;">
        <button class="btn btn-light px-5 radius-30" onclick="loadEditWidgetCurrent()">
          <i class="bx bx-plus" aria-hidden="true"></i> """),_display_(/*47.58*/Messages("widget.edit")),format.raw/*47.81*/("""
        """),format.raw/*48.9*/("""</button>
        <button class="btn btn-success px-5 radius-30" data-bs-toggle="modal" data-bs-target="#addConfirmModal">
          <i class="bx bx-plus" aria-hidden="true"></i> """),_display_(/*50.58*/Messages("widget.add")),format.raw/*50.80*/("""
        """),format.raw/*51.9*/("""</button>
        <button class="btn btn-success px-5 radius-30" onclick="saveDashboard()">
          <i class="bx bx-save" aria-hidden="true"></i> """),_display_(/*53.58*/Messages("widget.save")),format.raw/*53.81*/("""
        """),format.raw/*54.9*/("""</button>
      </div>
    </div>


    """),_display_(/*59.6*/views/*59.11*/.html.Loading()),format.raw/*59.26*/("""
  """),format.raw/*60.3*/("""</body>

  """),_display_(/*62.4*/views/*62.9*/.html.iot.tags.Main_js()),format.raw/*62.33*/("""

  """),format.raw/*64.3*/("""<script>
          var projectId = '"""),_display_(/*65.29*/projectId),format.raw/*65.38*/("""';
          var idDashboard = '"""),_display_(/*66.31*/idDashboard),format.raw/*66.42*/("""';

          $(document).ready(function () """),format.raw/*68.41*/("""{"""),format.raw/*68.42*/("""
            """),format.raw/*69.13*/("""$("#menu-dashboard").addClass("mm-active");
            $("#menu").metisMenu();
          """),format.raw/*71.11*/("""}"""),format.raw/*71.12*/(""");

  </script>

  <script>
          var device_vtag = """"),_display_(/*76.31*/routes/*76.37*/.Assets.versioned("images/dashboard/marker.png")),format.raw/*76.85*/("""";

          var circleSignal_run = """"),_display_(/*78.36*/routes/*78.42*/.Assets.versioned("images/signal/greenCircle.gif")),format.raw/*78.92*/("""";
          var circleSignal_parking = """"),_display_(/*79.40*/routes/*79.46*/.Assets.versioned("images/signal/blueCircle.gif")),format.raw/*79.95*/("""";
          var circleSignal_lost_Gps = """"),_display_(/*80.41*/routes/*80.47*/.Assets.versioned("images/signal/yellowCircle.gif")),format.raw/*80.98*/("""";
          var circleSignal_lost_connect = """"),_display_(/*81.45*/routes/*81.51*/.Assets.versioned("images/signal/grayCircle.gif")),format.raw/*81.100*/("""";
          var circleSignal_alarm = """"),_display_(/*82.38*/routes/*82.44*/.Assets.versioned("images/signal/redCircle.gif")),format.raw/*82.92*/("""";

          var ggmapImg = """"),_display_(/*84.28*/routes/*84.34*/.Assets.versioned("images/widget/ggmap.jpg")),format.raw/*84.78*/("""";
          var deviceListImg = """"),_display_(/*85.33*/routes/*85.39*/.Assets.versioned("images/widget/deviceList.jpg")),format.raw/*85.88*/("""";
          var chartColumnImg = """"),_display_(/*86.34*/routes/*86.40*/.Assets.versioned("images/widget/chartColumn2.png")),format.raw/*86.91*/("""";
          var chartLineImg = """"),_display_(/*87.32*/routes/*87.38*/.Assets.versioned("images/widget/chartLine.png")),format.raw/*87.86*/("""";
          var tableImg = """"),_display_(/*88.28*/routes/*88.34*/.Assets.versioned("images/widget/table.png")),format.raw/*88.78*/("""";
          var gaugeImg = """"),_display_(/*89.28*/routes/*89.34*/.Assets.versioned("images/widget/gauge.png")),format.raw/*89.78*/("""";
          var roundSwitchImg = """"),_display_(/*90.34*/routes/*90.40*/.Assets.versioned("images/widget/roundSwitch.png")),format.raw/*90.90*/("""";

  </script>
  <script src=""""),_display_(/*93.17*/routes/*93.23*/.Assets.versioned("assets/plugins/apexcharts-bundle/js/apexcharts.min.js")),format.raw/*93.97*/(""""></script>

  <script src=""""),_display_(/*95.17*/routes/*95.23*/.Assets.versioned("assets/plugins/highcharts/js/highcharts.js")),format.raw/*95.86*/(""""></script>
  <script src=""""),_display_(/*96.17*/routes/*96.23*/.Assets.versioned("assets/plugins/highcharts/js/highcharts-more.js")),format.raw/*96.91*/(""""></script>
  <script src=""""),_display_(/*97.17*/routes/*97.23*/.Assets.versioned("assets/plugins/highcharts/js/variable-pie.js")),format.raw/*97.88*/(""""></script>
  <script src=""""),_display_(/*98.17*/routes/*98.23*/.Assets.versioned("assets/plugins/highcharts/js/solid-gauge.js")),format.raw/*98.87*/(""""></script>
  <script src=""""),_display_(/*99.17*/routes/*99.23*/.Assets.versioned("assets/plugins/highcharts/js/highcharts-3d.js")),format.raw/*99.89*/(""""></script>
  <script src=""""),_display_(/*100.17*/routes/*100.23*/.Assets.versioned("assets/plugins/highcharts/js/cylinder.js")),format.raw/*100.84*/(""""></script>
  <script src=""""),_display_(/*101.17*/routes/*101.23*/.Assets.versioned("assets/plugins/highcharts/js/funnel3d.js")),format.raw/*101.84*/(""""></script>
  <script src=""""),_display_(/*102.17*/routes/*102.23*/.Assets.versioned("assets/plugins/highcharts/js/exporting.js")),format.raw/*102.85*/(""""></script>
  <script src=""""),_display_(/*103.17*/routes/*103.23*/.Assets.versioned("assets/plugins/highcharts/js/export-data.js")),format.raw/*103.87*/(""""></script>
  <script src=""""),_display_(/*104.17*/routes/*104.23*/.Assets.versioned("assets/plugins/highcharts/js/accessibility.js")),format.raw/*104.89*/(""""></script>
  <script src=""""),_display_(/*105.17*/routes/*105.23*/.Assets.versioned("assets/plugins/mustache/js/mustache.min.js")),format.raw/*105.86*/(""""></script>

  <script src=""""),_display_(/*107.17*/routes/*107.23*/.Assets.versioned("javascripts/views/dashboard/widget/gridstack-h5.js")),format.raw/*107.94*/(""""></script>
  <script src=""""),_display_(/*108.17*/routes/*108.23*/.Assets.versioned("javascripts/views/dashboard/MapPositionMarkerCluster.js")),format.raw/*108.99*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*110.17*/routes/*110.23*/.Assets.versioned("javascripts/views/dashboard/ver3/dashboardV3.js")),format.raw/*110.91*/(""""></script>
  <script src=""""),_display_(/*111.17*/routes/*111.23*/.Assets.versioned("javascripts/views/dashboard/ver3/dashboardV3_map.js")),format.raw/*111.95*/(""""></script>
  <script src=""""),_display_(/*112.17*/routes/*112.23*/.Assets.versioned("javascripts/views/dashboard/ver3/dashboardV3_map_markerSignal.js")),format.raw/*112.108*/(""""></script>
  <script src=""""),_display_(/*113.17*/routes/*113.23*/.Assets.versioned("javascripts/views/dashboard/ver3/dashboardV3_map_markerCluster.js")),format.raw/*113.109*/(""""></script>
  <script src=""""),_display_(/*114.17*/routes/*114.23*/.Assets.versioned("javascripts/views/dashboard/ver3/dashboardV3_map_infoWindow.js")),format.raw/*114.106*/(""""></script>
  <script src=""""),_display_(/*115.17*/routes/*115.23*/.Assets.versioned("javascripts/views/dashboard/ver3/dashboardV3_map_updateMarker.js")),format.raw/*115.108*/(""""></script>

  """),format.raw/*117.11*/("""
  """),format.raw/*118.3*/("""<script src=""""),_display_(/*118.17*/routes/*118.23*/.Assets.versioned("javascripts/views/dashboard/ver3/edit/widget.js")),format.raw/*118.91*/(""""></script>
  <script src=""""),_display_(/*119.17*/routes/*119.23*/.Assets.versioned("javascripts/views/dashboard/ver3/edit/widgetList.js")),format.raw/*119.95*/(""""></script>
  <script src=""""),_display_(/*120.17*/routes/*120.23*/.Assets.versioned("javascripts/views/dashboard/ver3/edit/widget_map.js")),format.raw/*120.95*/(""""></script>
  <script src=""""),_display_(/*121.17*/routes/*121.23*/.Assets.versioned("javascripts/views/dashboard/ver3/edit/widget_save.js")),format.raw/*121.96*/(""""></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,projectId:String,idDashboard:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,projectId,idDashboard)

  def f:((User,String,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,projectId,idDashboard) => apply(currentUser,projectId,idDashboard)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:44 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboardV3/DashboardV3.scala.html
                  HASH: 93a4ee6ebfe4f4408faa0a17fdb29188644ba15a
                  MATRIX: 667->1|690->18|726->48|766->82|1119->114|1270->170|1298->172|1467->314|1509->335|1590->389|1605->395|1662->431|1869->612|1883->617|1929->642|1962->648|2002->661|2017->667|2109->738|2199->801|2218->811|2256->828|2314->859|2329->865|2417->932|2482->970|2497->976|2591->1049|2656->1087|2671->1093|2764->1165|2874->1249|2888->1254|2952->1297|2987->1306|3001->1311|3056->1345|3091->1353|3293->1638|3330->1657|3364->1664|3696->1969|3740->1992|3776->2001|3983->2181|4026->2203|4062->2212|4238->2361|4282->2384|4318->2393|4385->2434|4399->2439|4435->2454|4465->2457|4503->2469|4516->2474|4561->2498|4592->2502|4656->2539|4686->2548|4746->2581|4778->2592|4850->2636|4879->2637|4920->2650|5038->2740|5067->2741|5152->2799|5167->2805|5236->2853|5302->2892|5317->2898|5388->2948|5457->2990|5472->2996|5542->3045|5612->3088|5627->3094|5699->3145|5773->3192|5788->3198|5859->3247|5926->3287|5941->3293|6010->3341|6068->3372|6083->3378|6148->3422|6210->3457|6225->3463|6295->3512|6358->3548|6373->3554|6445->3605|6506->3639|6521->3645|6590->3693|6647->3723|6662->3729|6727->3773|6784->3803|6799->3809|6864->3853|6927->3889|6942->3895|7013->3945|7072->3977|7087->3983|7182->4057|7238->4086|7253->4092|7337->4155|7392->4183|7407->4189|7496->4257|7551->4285|7566->4291|7652->4356|7707->4384|7722->4390|7807->4454|7862->4482|7877->4488|7964->4554|8020->4582|8036->4588|8119->4649|8175->4677|8191->4683|8274->4744|8330->4772|8346->4778|8430->4840|8486->4868|8502->4874|8588->4938|8644->4966|8660->4972|8748->5038|8804->5066|8820->5072|8905->5135|8962->5164|8978->5170|9071->5241|9127->5269|9143->5275|9241->5351|9321->5403|9337->5409|9427->5477|9483->5505|9499->5511|9593->5583|9649->5611|9665->5617|9773->5702|9829->5730|9845->5736|9954->5822|10010->5850|10026->5856|10132->5939|10188->5967|10204->5973|10312->6058|10356->6081|10387->6084|10429->6098|10445->6104|10535->6172|10591->6200|10607->6206|10701->6278|10757->6306|10773->6312|10867->6384|10923->6412|10939->6418|11034->6491
                  LINES: 24->1|25->2|26->3|27->4|32->5|37->5|39->7|44->12|44->12|45->13|45->13|45->13|50->18|50->18|50->18|52->20|52->20|52->20|52->20|53->21|53->21|53->21|55->23|55->23|55->23|56->24|56->24|56->24|57->25|57->25|57->25|62->30|62->30|62->30|64->32|64->32|64->32|66->34|70->38|71->39|72->40|79->47|79->47|80->48|82->50|82->50|83->51|85->53|85->53|86->54|91->59|91->59|91->59|92->60|94->62|94->62|94->62|96->64|97->65|97->65|98->66|98->66|100->68|100->68|101->69|103->71|103->71|108->76|108->76|108->76|110->78|110->78|110->78|111->79|111->79|111->79|112->80|112->80|112->80|113->81|113->81|113->81|114->82|114->82|114->82|116->84|116->84|116->84|117->85|117->85|117->85|118->86|118->86|118->86|119->87|119->87|119->87|120->88|120->88|120->88|121->89|121->89|121->89|122->90|122->90|122->90|125->93|125->93|125->93|127->95|127->95|127->95|128->96|128->96|128->96|129->97|129->97|129->97|130->98|130->98|130->98|131->99|131->99|131->99|132->100|132->100|132->100|133->101|133->101|133->101|134->102|134->102|134->102|135->103|135->103|135->103|136->104|136->104|136->104|137->105|137->105|137->105|139->107|139->107|139->107|140->108|140->108|140->108|142->110|142->110|142->110|143->111|143->111|143->111|144->112|144->112|144->112|145->113|145->113|145->113|146->114|146->114|146->114|147->115|147->115|147->115|149->117|150->118|150->118|150->118|150->118|151->119|151->119|151->119|152->120|152->120|152->120|153->121|153->121|153->121
                  -- GENERATED --
              */
          