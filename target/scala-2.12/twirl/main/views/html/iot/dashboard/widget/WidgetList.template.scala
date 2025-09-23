
package views.html.iot.dashboard.widget

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

object WidgetList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[User,String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(currentUser:User, projectId:String, idDashboard:String, name:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.71*/("""

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
"""),format.raw/*19.123*/("""
    """),format.raw/*20.5*/("""<link href=""""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("assets/plugins/highcharts/css/highcharts-white.css")),format.raw/*20.95*/("""" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />

    <script type="text/javascript" src=""""),_display_(/*23.42*/UserHelper/*23.52*/.linkGoogleMapApi),format.raw/*23.69*/(""""> </script>

    <link href=""""),_display_(/*25.18*/routes/*25.24*/.Assets.versioned("stylesheets/views/dashboard/loading.css")),format.raw/*25.84*/("""" rel="stylesheet"/>
    <link href=""""),_display_(/*26.18*/routes/*26.24*/.Assets.versioned("stylesheets/views/dashboard/map.css")),format.raw/*26.80*/("""" rel="stylesheet"/>
    """),format.raw/*27.120*/("""
    """),format.raw/*28.5*/("""<link href=""""),_display_(/*28.18*/routes/*28.24*/.Assets.versioned("stylesheets/views/dashboard/widget/switchSocket.css")),format.raw/*28.96*/("""" rel="stylesheet"/>
    <link href=""""),_display_(/*29.18*/routes/*29.24*/.Assets.versioned("stylesheets/views/dashboard/widget/widget.css")),format.raw/*29.90*/("""" rel="stylesheet"/>
    <link href=""""),_display_(/*30.18*/routes/*30.24*/.Assets.versioned("stylesheets/views/dashboard/widget/command.css")),format.raw/*30.91*/("""" rel="stylesheet"/>

    <link rel='stylesheet' href='https://api.mapbox.com/mapbox.js/v3.3.1/mapbox.css'/>
    <link rel='stylesheet' href=""""),_display_(/*33.35*/routes/*33.41*/.Assets.versioned("javascripts/plugins/openStreetMap/MarkerCluster.Default.css")),format.raw/*33.121*/(""""/>
    <link rel='stylesheet' href=""""),_display_(/*34.35*/routes/*34.41*/.Assets.versioned("javascripts/plugins/openStreetMap/MarkerCluster.css")),format.raw/*34.113*/(""""/>

    <style type="text/css">
            .grid-stack """),format.raw/*37.25*/("""{"""),format.raw/*37.26*/("""
              """),format.raw/*38.15*/("""background: #ffffff;
            """),format.raw/*39.13*/("""}"""),format.raw/*39.14*/("""

            """),format.raw/*41.13*/(""".grid-stack-item-content """),format.raw/*41.38*/("""{"""),format.raw/*41.39*/("""
              """),format.raw/*42.15*/("""position: relative;
              /*display: flex;*/
              flex-direction: column;
              min-width: 0;
              word-wrap: break-word;
              background-color: #f8f9fa!important;
              background-clip: border-box;
              border: 0 solid transparent;
              border-radius: .25rem;
              margin-bottom: 1.5rem;
              box-shadow: 0 0.3rem 0.8rem rgb(0 0 0 / 12%);
            """),format.raw/*53.13*/("""}"""),format.raw/*53.14*/("""

            """),format.raw/*55.13*/(""".table-nowrap td"""),format.raw/*55.29*/("""{"""),format.raw/*55.30*/("""
              """),format.raw/*56.15*/("""white-space: nowrap;
            """),format.raw/*57.13*/("""}"""),format.raw/*57.14*/("""
            """),format.raw/*58.13*/(""".error"""),format.raw/*58.19*/("""{"""),format.raw/*58.20*/("""
              """),format.raw/*59.15*/("""color: red;
            """),format.raw/*60.13*/("""}"""),format.raw/*60.14*/("""
    """),format.raw/*61.5*/("""</style>

    <link href=""""),_display_(/*63.18*/routes/*63.24*/.Assets.versioned("javascripts/views/dashboard/widget/gridstack.min.css")),format.raw/*63.97*/("""" rel="stylesheet"/>
  </head>
  <body class="bg-theme">
    """),_display_(/*66.6*/views/*66.11*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*66.54*/("""

    """),_display_(/*68.6*/views/*68.11*/.html.iot.tags.Header(currentUser)),format.raw/*68.45*/("""

    """),format.raw/*70.5*/("""<div class="page-wrapper" style="overflow: auto">

      <div class="toolbar" style="float: right; transition: 0.4s;position: fixed;bottom: 10px;right: 20px;z-index: 99;">
        <button class="btn btn-secondary px-2 radius-30" onclick="backDashboard()">
          <i class="bx bx-chevron-left" aria-hidden="true"></i> """),_display_(/*74.66*/Messages("widget.back")),format.raw/*74.89*/("""
        """),format.raw/*75.9*/("""</button>
        <button class="btn btn-success px-2 radius-30" data-bs-toggle="modal" data-bs-target="#addConfirmModal">
          <i class="bx bx-plus" aria-hidden="true"></i> """),_display_(/*77.58*/Messages("widget.add")),format.raw/*77.80*/("""
        """),format.raw/*78.9*/("""</button>
        <button class="btn btn-success px-2 radius-30" onclick="savePageWidget()">
          <i class="bx bx-save" aria-hidden="true"></i> """),_display_(/*80.58*/Messages("widget.save")),format.raw/*80.81*/("""
        """),format.raw/*81.9*/("""</button>
      </div>

      <div class="grid-stack" data-gs-width="12" style="background-color: #eceff1" id="widgetBody">
      </div>
    </div>

    """),_display_(/*88.6*/views/*88.11*/.html.iot.dashboard.widget.Widget_add()),format.raw/*88.50*/("""
    """),_display_(/*89.6*/views/*89.11*/.html.iot.dashboard.widget.Widget_del()),format.raw/*89.50*/("""
    """),_display_(/*90.6*/views/*90.11*/.html.iot.dashboard.widget.Widget_edit_map()),format.raw/*90.55*/("""
    """),_display_(/*91.6*/views/*91.11*/.html.iot.dashboard.widget.Widget_edit_chart_column()),format.raw/*91.64*/("""
    """),_display_(/*92.6*/views/*92.11*/.html.iot.dashboard.widget.Widget_edit_chart_line()),format.raw/*92.62*/("""
    """),_display_(/*93.6*/views/*93.11*/.html.iot.dashboard.widget.Widget_edit_table()),format.raw/*93.57*/("""
    """),_display_(/*94.6*/views/*94.11*/.html.iot.dashboard.widget.Widget_edit_gauge()),format.raw/*94.57*/("""
    """),_display_(/*95.6*/views/*95.11*/.html.iot.dashboard.widget.Widget_edit_round_switch()),format.raw/*95.64*/("""
    """),_display_(/*96.6*/views/*96.11*/.html.iot.dashboard.widget.Widget_edit_data()),format.raw/*96.56*/("""
    """),_display_(/*97.6*/views/*97.11*/.html.iot.dashboard.widget.Widget_edit_command()),format.raw/*97.59*/("""

  """),format.raw/*99.3*/("""</body>

  """),_display_(/*101.4*/views/*101.9*/.html.iot.tags.Main_js()),format.raw/*101.33*/("""

"""),format.raw/*103.97*/("""
  """),format.raw/*104.3*/("""<script src=""""),_display_(/*104.17*/routes/*104.23*/.Assets.versioned("assets/plugins/mustache/js/mustache.min.js")),format.raw/*104.86*/(""""></script>
  <script src=""""),_display_(/*105.17*/routes/*105.23*/.Assets.versioned("assets/plugins/jquery-validate/js/jquery.validate.min.js")),format.raw/*105.100*/(""""></script>

  <script src=""""),_display_(/*107.17*/routes/*107.23*/.Assets.versioned("assets/plugins/apexcharts-bundle/js/apexcharts.min.js")),format.raw/*107.97*/(""""></script>

  <script src=""""),_display_(/*109.17*/routes/*109.23*/.Assets.versioned("assets/plugins/highcharts/js/highcharts.js")),format.raw/*109.86*/(""""></script>
  <script src=""""),_display_(/*110.17*/routes/*110.23*/.Assets.versioned("assets/plugins/highcharts/js/highcharts-more.js")),format.raw/*110.91*/(""""></script>
  <script src=""""),_display_(/*111.17*/routes/*111.23*/.Assets.versioned("assets/plugins/highcharts/js/variable-pie.js")),format.raw/*111.88*/(""""></script>
  <script src=""""),_display_(/*112.17*/routes/*112.23*/.Assets.versioned("assets/plugins/highcharts/js/solid-gauge.js")),format.raw/*112.87*/(""""></script>
  <script src=""""),_display_(/*113.17*/routes/*113.23*/.Assets.versioned("assets/plugins/highcharts/js/highcharts-3d.js")),format.raw/*113.89*/(""""></script>
  <script src=""""),_display_(/*114.17*/routes/*114.23*/.Assets.versioned("assets/plugins/highcharts/js/cylinder.js")),format.raw/*114.84*/(""""></script>
  <script src=""""),_display_(/*115.17*/routes/*115.23*/.Assets.versioned("assets/plugins/highcharts/js/funnel3d.js")),format.raw/*115.84*/(""""></script>
  <script src=""""),_display_(/*116.17*/routes/*116.23*/.Assets.versioned("assets/plugins/highcharts/js/exporting.js")),format.raw/*116.85*/(""""></script>
  <script src=""""),_display_(/*117.17*/routes/*117.23*/.Assets.versioned("assets/plugins/highcharts/js/export-data.js")),format.raw/*117.87*/(""""></script>
  <script src=""""),_display_(/*118.17*/routes/*118.23*/.Assets.versioned("assets/plugins/highcharts/js/accessibility.js")),format.raw/*118.89*/(""""></script>
  <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
  <script>
    var projectId = '"""),_display_(/*121.23*/projectId),format.raw/*121.32*/("""';
    var projectName = '"""),_display_(/*122.25*/name),format.raw/*122.29*/("""';
    var idDashboard = '"""),_display_(/*123.25*/idDashboard),format.raw/*123.36*/("""';
    var linkMapbox = '"""),_display_(/*124.24*/UserHelper/*124.34*/.linkGoogleMapbox),format.raw/*124.51*/("""';

          $(document).ready(function () """),format.raw/*126.41*/("""{"""),format.raw/*126.42*/("""
            """),format.raw/*127.13*/("""$("#menu-dashboard").addClass("mm-active");
            $("#menu").metisMenu();
          """),format.raw/*129.11*/("""}"""),format.raw/*129.12*/(""");

          function backDashboard() """),format.raw/*131.36*/("""{"""),format.raw/*131.37*/("""
"""),format.raw/*132.1*/("""//              autoSaveWidget();
              window.location.href = jsRoutes.controllers.DashboardV3Controller.dashboard('"""),_display_(/*133.93*/projectId),format.raw/*133.102*/("""', '"""),_display_(/*133.107*/idDashboard),format.raw/*133.118*/("""').url;
          """),format.raw/*134.11*/("""}"""),format.raw/*134.12*/("""

          """),format.raw/*136.11*/("""var userid = '"""),_display_(/*136.26*/currentUser/*136.37*/.getId),format.raw/*136.43*/("""';
          var ggmapImg = """"),_display_(/*137.28*/routes/*137.34*/.Assets.versioned("images/widget/ggmap.jpg")),format.raw/*137.78*/("""";
          var deviceListImg = """"),_display_(/*138.33*/routes/*138.39*/.Assets.versioned("images/widget/deviceList.jpg")),format.raw/*138.88*/("""";
          var chartColumnImg = """"),_display_(/*139.34*/routes/*139.40*/.Assets.versioned("images/widget/chartColumn2.png")),format.raw/*139.91*/("""";
          var chartLineImg = """"),_display_(/*140.32*/routes/*140.38*/.Assets.versioned("images/widget/chartLine.png")),format.raw/*140.86*/("""";
          var tableImg = """"),_display_(/*141.28*/routes/*141.34*/.Assets.versioned("images/widget/table.png")),format.raw/*141.78*/("""";
          var gaugeImg = """"),_display_(/*142.28*/routes/*142.34*/.Assets.versioned("images/widget/gauge.png")),format.raw/*142.78*/("""";
          var roundSwitchImg = """"),_display_(/*143.34*/routes/*143.40*/.Assets.versioned("images/widget/roundSwitch.png")),format.raw/*143.90*/("""";
          var dataImg = """"),_display_(/*144.27*/routes/*144.33*/.Assets.versioned("images/widget/data.png")),format.raw/*144.76*/("""";
  </script>

  <script type="text/javascript" src=""""),_display_(/*147.40*/routes/*147.46*/.Assets.versioned("javascripts/plugins/openStreetMap/leaflet.js")),format.raw/*147.111*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*148.40*/routes/*148.46*/.Assets.versioned("javascripts/plugins/openStreetMap/leaflet.markercluster-src.js")),format.raw/*148.129*/(""""></script>
  <script src=""""),_display_(/*149.17*/routes/*149.23*/.Assets.versioned("javascripts/views/dashboard/widget/gridstack-h5.js")),format.raw/*149.94*/(""""></script>
  <script src=""""),_display_(/*150.17*/routes/*150.23*/.Assets.versioned("javascripts/views/dashboard/widget/widget_loadFirst.js")),format.raw/*150.98*/(""""></script>

  <script src=""""),_display_(/*152.17*/routes/*152.23*/.Assets.versioned("javascripts/views/dashboard/widget/WidgetPage.js")),format.raw/*152.92*/(""""></script>
  <script src=""""),_display_(/*153.17*/routes/*153.23*/.Assets.versioned("javascripts/views/dashboard/widget/widget_map.js")),format.raw/*153.92*/(""""></script>
  <script src=""""),_display_(/*154.17*/routes/*154.23*/.Assets.versioned("javascripts/views/dashboard/widget/widget_chart_column.js")),format.raw/*154.101*/(""""></script>
  <script src=""""),_display_(/*155.17*/routes/*155.23*/.Assets.versioned("javascripts/views/dashboard/widget/widget_chart_line.js")),format.raw/*155.99*/(""""></script>
  <script src=""""),_display_(/*156.17*/routes/*156.23*/.Assets.versioned("javascripts/views/dashboard/widget/widget_table.js")),format.raw/*156.94*/(""""></script>
  <script src=""""),_display_(/*157.17*/routes/*157.23*/.Assets.versioned("javascripts/views/dashboard/widget/widget_gauge.js")),format.raw/*157.94*/(""""></script>
  <script src=""""),_display_(/*158.17*/routes/*158.23*/.Assets.versioned("javascripts/views/dashboard/widget/widget_round_switch.js")),format.raw/*158.101*/(""""></script>
  <script src=""""),_display_(/*159.17*/routes/*159.23*/.Assets.versioned("javascripts/views/dashboard/widget/widget_data.js")),format.raw/*159.93*/(""""></script>
  <script src=""""),_display_(/*160.17*/routes/*160.23*/.Assets.versioned("javascripts/views/dashboard/widget/widget_command.js")),format.raw/*160.96*/(""""></script>

  <script src=""""),_display_(/*162.17*/routes/*162.23*/.Assets.versioned("javascripts/views/dashboard/widget/widget_save.js")),format.raw/*162.93*/(""""></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,projectId:String,idDashboard:String,name:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,projectId,idDashboard,name)

  def f:((User,String,String,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,projectId,idDashboard,name) => apply(currentUser,projectId,idDashboard,name)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:43 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboard/widget/WidgetList.scala.html
                  HASH: 9848009fe9d3caabe97f6da677fc33b61609e512
                  MATRIX: 672->1|695->18|731->48|771->82|1130->114|1294->183|1322->185|1491->327|1533->348|1614->402|1629->408|1686->444|1893->625|1907->630|1953->655|1983->778|2015->783|2055->796|2070->802|2162->873|2363->1048|2382->1058|2420->1075|2478->1106|2493->1112|2574->1172|2639->1210|2654->1216|2731->1272|2785->1412|2817->1417|2857->1430|2872->1436|2965->1508|3030->1546|3045->1552|3132->1618|3197->1656|3212->1662|3300->1729|3470->1872|3485->1878|3587->1958|3652->1996|3667->2002|3761->2074|3846->2131|3875->2132|3918->2147|3979->2180|4008->2181|4050->2195|4103->2220|4132->2221|4175->2236|4642->2675|4671->2676|4713->2690|4757->2706|4786->2707|4829->2722|4890->2755|4919->2756|4960->2769|4994->2775|5023->2776|5066->2791|5118->2815|5147->2816|5179->2821|5233->2848|5248->2854|5342->2927|5430->2989|5444->2994|5508->3037|5541->3044|5555->3049|5610->3083|5643->3089|5991->3410|6035->3433|6071->3442|6278->3622|6321->3644|6357->3653|6534->3803|6578->3826|6614->3835|6794->3989|6808->3994|6868->4033|6900->4039|6914->4044|6974->4083|7006->4089|7020->4094|7085->4138|7117->4144|7131->4149|7205->4202|7237->4208|7251->4213|7323->4264|7355->4270|7369->4275|7436->4321|7468->4327|7482->4332|7549->4378|7581->4384|7595->4389|7669->4442|7701->4448|7715->4453|7781->4498|7813->4504|7827->4509|7896->4557|7927->4561|7966->4573|7980->4578|8026->4602|8057->4700|8088->4703|8130->4717|8146->4723|8231->4786|8287->4814|8303->4820|8403->4897|8460->4926|8476->4932|8572->5006|8629->5035|8645->5041|8730->5104|8786->5132|8802->5138|8892->5206|8948->5234|8964->5240|9051->5305|9107->5333|9123->5339|9209->5403|9265->5431|9281->5437|9369->5503|9425->5531|9441->5537|9524->5598|9580->5626|9596->5632|9679->5693|9735->5721|9751->5727|9835->5789|9891->5817|9907->5823|9993->5887|10049->5915|10065->5921|10153->5987|10323->6130|10354->6139|10409->6166|10435->6170|10490->6197|10523->6208|10577->6234|10597->6244|10636->6261|10709->6305|10739->6306|10781->6319|10900->6409|10930->6410|10998->6449|11028->6450|11057->6451|11211->6577|11243->6586|11277->6591|11311->6602|11358->6620|11388->6621|11429->6633|11472->6648|11493->6659|11521->6665|11579->6695|11595->6701|11661->6745|11724->6780|11740->6786|11811->6835|11875->6871|11891->6877|11964->6928|12026->6962|12042->6968|12112->7016|12170->7046|12186->7052|12252->7096|12310->7126|12326->7132|12392->7176|12456->7212|12472->7218|12544->7268|12601->7297|12617->7303|12682->7346|12765->7401|12781->7407|12869->7472|12948->7523|12964->7529|13070->7612|13126->7640|13142->7646|13235->7717|13291->7745|13307->7751|13404->7826|13461->7855|13477->7861|13568->7930|13624->7958|13640->7964|13731->8033|13787->8061|13803->8067|13904->8145|13960->8173|13976->8179|14074->8255|14130->8283|14146->8289|14239->8360|14295->8388|14311->8394|14404->8465|14460->8493|14476->8499|14577->8577|14633->8605|14649->8611|14741->8681|14797->8709|14813->8715|14908->8788|14965->8817|14981->8823|15073->8893
                  LINES: 24->1|25->2|26->3|27->4|32->5|37->5|39->7|44->12|44->12|45->13|45->13|45->13|50->18|50->18|50->18|51->19|52->20|52->20|52->20|52->20|55->23|55->23|55->23|57->25|57->25|57->25|58->26|58->26|58->26|59->27|60->28|60->28|60->28|60->28|61->29|61->29|61->29|62->30|62->30|62->30|65->33|65->33|65->33|66->34|66->34|66->34|69->37|69->37|70->38|71->39|71->39|73->41|73->41|73->41|74->42|85->53|85->53|87->55|87->55|87->55|88->56|89->57|89->57|90->58|90->58|90->58|91->59|92->60|92->60|93->61|95->63|95->63|95->63|98->66|98->66|98->66|100->68|100->68|100->68|102->70|106->74|106->74|107->75|109->77|109->77|110->78|112->80|112->80|113->81|120->88|120->88|120->88|121->89|121->89|121->89|122->90|122->90|122->90|123->91|123->91|123->91|124->92|124->92|124->92|125->93|125->93|125->93|126->94|126->94|126->94|127->95|127->95|127->95|128->96|128->96|128->96|129->97|129->97|129->97|131->99|133->101|133->101|133->101|135->103|136->104|136->104|136->104|136->104|137->105|137->105|137->105|139->107|139->107|139->107|141->109|141->109|141->109|142->110|142->110|142->110|143->111|143->111|143->111|144->112|144->112|144->112|145->113|145->113|145->113|146->114|146->114|146->114|147->115|147->115|147->115|148->116|148->116|148->116|149->117|149->117|149->117|150->118|150->118|150->118|153->121|153->121|154->122|154->122|155->123|155->123|156->124|156->124|156->124|158->126|158->126|159->127|161->129|161->129|163->131|163->131|164->132|165->133|165->133|165->133|165->133|166->134|166->134|168->136|168->136|168->136|168->136|169->137|169->137|169->137|170->138|170->138|170->138|171->139|171->139|171->139|172->140|172->140|172->140|173->141|173->141|173->141|174->142|174->142|174->142|175->143|175->143|175->143|176->144|176->144|176->144|179->147|179->147|179->147|180->148|180->148|180->148|181->149|181->149|181->149|182->150|182->150|182->150|184->152|184->152|184->152|185->153|185->153|185->153|186->154|186->154|186->154|187->155|187->155|187->155|188->156|188->156|188->156|189->157|189->157|189->157|190->158|190->158|190->158|191->159|191->159|191->159|192->160|192->160|192->160|194->162|194->162|194->162
                  -- GENERATED --
              */
          