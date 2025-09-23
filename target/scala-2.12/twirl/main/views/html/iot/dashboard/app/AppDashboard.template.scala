
package views.html.iot.dashboard.app

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

object AppDashboard extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[String,String,String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(projectId:String, idDashboard:String, token: String, deviceId: String, deviceToken: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.94*/("""
"""),format.raw/*6.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*11.13*/Messages("App Dashboard")),format.raw/*11.38*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*12.46*/routes/*12.52*/.Assets.versioned("images/logo.jpg")),format.raw/*12.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*17.6*/views/*17.11*/.html.iot.tags.Main_css()),format.raw/*17.36*/("""

    """),format.raw/*19.5*/("""<link href=""""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("assets/plugins/highcharts/css/highcharts-white.css")),format.raw/*19.95*/("""" rel="stylesheet" />
    <script type="text/javascript" src=""""),_display_(/*20.42*/UserHelper/*20.52*/.linkGoogleMapApi),format.raw/*20.69*/(""""> </script>

    <link href=""""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("stylesheets/views/dashboard/ver2/dashboard.css")),format.raw/*22.91*/("""" rel="stylesheet"/>
    <link href=""""),_display_(/*23.18*/routes/*23.24*/.Assets.versioned("javascripts/views/dashboard/widget/gridstack.min.css")),format.raw/*23.97*/("""" rel="stylesheet"/>
    """),format.raw/*24.120*/("""
    """),format.raw/*25.5*/("""<link href=""""),_display_(/*25.18*/routes/*25.24*/.Assets.versioned("stylesheets/views/dashboard/widget/switchSocket.css")),format.raw/*25.96*/("""" rel="stylesheet"/>

  </head>
  <body>
    <div class="card">
      <div class="card-body">
        <div style="background-color: #eceff1;" id="bodyDashboard">
        </div>
      </div>
    </div>

    """),_display_(/*36.6*/views/*36.11*/.html.Loading()),format.raw/*36.26*/("""
  """),format.raw/*37.3*/("""</body>

  """),_display_(/*39.4*/views/*39.9*/.html.iot.tags.Main_js()),format.raw/*39.33*/("""

  """),format.raw/*41.3*/("""<script>
    var projectId = '"""),_display_(/*42.23*/projectId),format.raw/*42.32*/("""';
    var idDashboard = '"""),_display_(/*43.25*/idDashboard),format.raw/*43.36*/("""';
    var token = '"""),_display_(/*44.19*/token),format.raw/*44.24*/("""';
    var deviceId = '"""),_display_(/*45.22*/deviceId),format.raw/*45.30*/("""';
  </script>

  <script>
          var device_vtag = """"),_display_(/*49.31*/routes/*49.37*/.Assets.versioned("images/dashboard/marker.png")),format.raw/*49.85*/("""";

          var circleSignal_run = """"),_display_(/*51.36*/routes/*51.42*/.Assets.versioned("images/signal/greenCircle.gif")),format.raw/*51.92*/("""";
          var circleSignal_parking = """"),_display_(/*52.40*/routes/*52.46*/.Assets.versioned("images/signal/blueCircle.gif")),format.raw/*52.95*/("""";
          var circleSignal_lost_Gps = """"),_display_(/*53.41*/routes/*53.47*/.Assets.versioned("images/signal/yellowCircle.gif")),format.raw/*53.98*/("""";
          var circleSignal_lost_connect = """"),_display_(/*54.45*/routes/*54.51*/.Assets.versioned("images/signal/grayCircle.gif")),format.raw/*54.100*/("""";
          var circleSignal_alarm = """"),_display_(/*55.38*/routes/*55.44*/.Assets.versioned("images/signal/redCircle.gif")),format.raw/*55.92*/("""";

  </script>
  <script src=""""),_display_(/*58.17*/routes/*58.23*/.Assets.versioned("assets/plugins/apexcharts-bundle/js/apexcharts.min.js")),format.raw/*58.97*/(""""></script>
  <script src=""""),_display_(/*59.17*/routes/*59.23*/.Assets.versioned("javascripts/plugins/loader.js")),format.raw/*59.73*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*60.17*/routes/*60.23*/.Assets.versioned("javascripts/chartist/chartist.min.js")),format.raw/*60.80*/(""""></script>

  <script src=""""),_display_(/*62.17*/routes/*62.23*/.Assets.versioned("assets/plugins/highcharts/js/highcharts.js")),format.raw/*62.86*/(""""></script>
  <script src=""""),_display_(/*63.17*/routes/*63.23*/.Assets.versioned("assets/plugins/highcharts/js/highcharts-more.js")),format.raw/*63.91*/(""""></script>
  <script src=""""),_display_(/*64.17*/routes/*64.23*/.Assets.versioned("assets/plugins/highcharts/js/variable-pie.js")),format.raw/*64.88*/(""""></script>
  <script src=""""),_display_(/*65.17*/routes/*65.23*/.Assets.versioned("assets/plugins/highcharts/js/solid-gauge.js")),format.raw/*65.87*/(""""></script>
  <script src=""""),_display_(/*66.17*/routes/*66.23*/.Assets.versioned("assets/plugins/highcharts/js/highcharts-3d.js")),format.raw/*66.89*/(""""></script>
  <script src=""""),_display_(/*67.17*/routes/*67.23*/.Assets.versioned("assets/plugins/highcharts/js/cylinder.js")),format.raw/*67.84*/(""""></script>
  <script src=""""),_display_(/*68.17*/routes/*68.23*/.Assets.versioned("assets/plugins/highcharts/js/funnel3d.js")),format.raw/*68.84*/(""""></script>
  <script src=""""),_display_(/*69.17*/routes/*69.23*/.Assets.versioned("assets/plugins/highcharts/js/exporting.js")),format.raw/*69.85*/(""""></script>
  <script src=""""),_display_(/*70.17*/routes/*70.23*/.Assets.versioned("assets/plugins/highcharts/js/export-data.js")),format.raw/*70.87*/(""""></script>
  <script src=""""),_display_(/*71.17*/routes/*71.23*/.Assets.versioned("assets/plugins/highcharts/js/accessibility.js")),format.raw/*71.89*/(""""></script>
  <script src=""""),_display_(/*72.17*/routes/*72.23*/.Assets.versioned("assets/plugins/mustache/js/mustache.min.js")),format.raw/*72.86*/(""""></script>

  <script src=""""),_display_(/*74.17*/routes/*74.23*/.Assets.versioned("javascripts/views/dashboard/widget/gridstack-h5.js")),format.raw/*74.94*/(""""></script>
  <script src=""""),_display_(/*75.17*/routes/*75.23*/.Assets.versioned("javascripts/views/dashboard/MapPositionMarkerCluster.js")),format.raw/*75.99*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*77.17*/routes/*77.23*/.Assets.versioned("javascripts/views/dashboard/app/dashboard.js")),format.raw/*77.88*/(""""></script>
  <script src=""""),_display_(/*78.17*/routes/*78.23*/.Assets.versioned("javascripts/views/dashboard/app/dashboard_map.js")),format.raw/*78.92*/(""""></script>
  <script src=""""),_display_(/*79.17*/routes/*79.23*/.Assets.versioned("javascripts/views/dashboard/app/Dashboard_map_markerSignal.js")),format.raw/*79.105*/(""""></script>
  <script src=""""),_display_(/*80.17*/routes/*80.23*/.Assets.versioned("javascripts/views/dashboard/app/Dashboard_map_markerCluster.js")),format.raw/*80.106*/(""""></script>
  <script src=""""),_display_(/*81.17*/routes/*81.23*/.Assets.versioned("javascripts/views/dashboard/app/Dashboard_map_infoWindow.js")),format.raw/*81.103*/(""""></script>
  <script src=""""),_display_(/*82.17*/routes/*82.23*/.Assets.versioned("javascripts/views/dashboard/app/Dashboard_map_updateMarker.js")),format.raw/*82.105*/(""""></script>

  <script src=""""),_display_(/*84.17*/routes/*84.23*/.Assets.versioned("javascripts/views/dashboard/app/dashboard_chart.js")),format.raw/*84.94*/(""""></script>
  <script id="dashboard-widget-table-template" type="x-tmpl-mustache">
    <table class="table table-striped">
        <thead class="thead-light">
            <tr>
                <th scope="col">Thiết bị</th>
                <th scope="col">Thuộc tính</th>
                <th scope="col">Dữ liệu</th>
                <th scope="col">Thời gian</th>
            </tr>

        </thead>
        <tbody>
            """),format.raw/*97.13*/("""{"""),format.raw/*97.14*/("""{"""),format.raw/*97.15*/("""#."""),format.raw/*97.17*/("""}"""),format.raw/*97.18*/("""}"""),format.raw/*97.19*/("""
              """),format.raw/*98.15*/("""<tr>
                    <th scope="row">"""),format.raw/*99.37*/("""{"""),format.raw/*99.38*/("""{"""),format.raw/*99.39*/("""device"""),format.raw/*99.45*/("""}"""),format.raw/*99.46*/("""}"""),format.raw/*99.47*/("""</th>
                    <td>"""),format.raw/*100.25*/("""{"""),format.raw/*100.26*/("""{"""),format.raw/*100.27*/("""var"""),format.raw/*100.30*/("""}"""),format.raw/*100.31*/("""}"""),format.raw/*100.32*/("""</td>
                    <td>"""),format.raw/*101.25*/("""{"""),format.raw/*101.26*/("""{"""),format.raw/*101.27*/("""data"""),format.raw/*101.31*/("""}"""),format.raw/*101.32*/("""}"""),format.raw/*101.33*/("""</td>
                    <td>"""),format.raw/*102.25*/("""{"""),format.raw/*102.26*/("""{"""),format.raw/*102.27*/("""time"""),format.raw/*102.31*/("""}"""),format.raw/*102.32*/("""}"""),format.raw/*102.33*/("""</td>
              </tr>
            """),format.raw/*104.13*/("""{"""),format.raw/*104.14*/("""{"""),format.raw/*104.15*/("""/."""),format.raw/*104.17*/("""}"""),format.raw/*104.18*/("""}"""),format.raw/*104.19*/("""
        """),format.raw/*105.9*/("""</tbody>
    </table>
  </script>
  <script src=""""),_display_(/*108.17*/routes/*108.23*/.Assets.versioned("javascripts/views/dashboard/app/dashboard_table.js")),format.raw/*108.94*/(""""></script>
  <script src=""""),_display_(/*109.17*/routes/*109.23*/.Assets.versioned("javascripts/views/dashboard/app/dashboard_gauge.js")),format.raw/*109.94*/(""""></script>
  <script src=""""),_display_(/*110.17*/routes/*110.23*/.Assets.versioned("javascripts/views/dashboard/app/dashboard_round_switch.js")),format.raw/*110.101*/(""""></script>
  <script src=""""),_display_(/*111.17*/routes/*111.23*/.Assets.versioned("javascripts/views/dashboard/app/dashboard_data.js")),format.raw/*111.93*/(""""></script>

</html>
"""))
      }
    }
  }

  def render(projectId:String,idDashboard:String,token:String,deviceId:String,deviceToken:String): play.twirl.api.HtmlFormat.Appendable = apply(projectId,idDashboard,token,deviceId,deviceToken)

  def f:((String,String,String,String,String) => play.twirl.api.HtmlFormat.Appendable) = (projectId,idDashboard,token,deviceId,deviceToken) => apply(projectId,idDashboard,token,deviceId,deviceToken)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:43 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboard/app/AppDashboard.scala.html
                  HASH: 750cccd7f054762947ab33a4a01d8478f1437d6c
                  MATRIX: 669->1|692->18|728->48|768->82|1138->114|1325->206|1352->207|1521->349|1567->374|1648->428|1663->434|1720->470|1927->651|1941->656|1987->681|2020->687|2060->700|2075->706|2167->777|2257->840|2276->850|2314->867|2372->898|2387->904|2475->971|2540->1009|2555->1015|2649->1088|2703->1228|2735->1233|2775->1246|2790->1252|2883->1324|3116->1531|3130->1536|3166->1551|3196->1554|3234->1566|3247->1571|3292->1595|3323->1599|3381->1630|3411->1639|3465->1666|3497->1677|3545->1698|3571->1703|3622->1727|3651->1735|3735->1792|3750->1798|3819->1846|3885->1885|3900->1891|3971->1941|4040->1983|4055->1989|4125->2038|4195->2081|4210->2087|4282->2138|4356->2185|4371->2191|4442->2240|4509->2280|4524->2286|4593->2334|4652->2366|4667->2372|4762->2446|4817->2474|4832->2480|4903->2530|4981->2581|4996->2587|5074->2644|5130->2673|5145->2679|5229->2742|5284->2770|5299->2776|5388->2844|5443->2872|5458->2878|5544->2943|5599->2971|5614->2977|5699->3041|5754->3069|5769->3075|5856->3141|5911->3169|5926->3175|6008->3236|6063->3264|6078->3270|6160->3331|6215->3359|6230->3365|6313->3427|6368->3455|6383->3461|6468->3525|6523->3553|6538->3559|6625->3625|6680->3653|6695->3659|6779->3722|6835->3751|6850->3757|6942->3828|6997->3856|7012->3862|7109->3938|7188->3990|7203->3996|7289->4061|7344->4089|7359->4095|7449->4164|7504->4192|7519->4198|7623->4280|7678->4308|7693->4314|7798->4397|7853->4425|7868->4431|7970->4511|8025->4539|8040->4545|8144->4627|8200->4656|8215->4662|8307->4733|8761->5159|8790->5160|8819->5161|8849->5163|8878->5164|8907->5165|8950->5180|9019->5221|9048->5222|9077->5223|9111->5229|9140->5230|9169->5231|9228->5261|9258->5262|9288->5263|9320->5266|9350->5267|9380->5268|9439->5298|9469->5299|9499->5300|9532->5304|9562->5305|9592->5306|9651->5336|9681->5337|9711->5338|9744->5342|9774->5343|9804->5344|9871->5382|9901->5383|9931->5384|9962->5386|9992->5387|10022->5388|10059->5397|10137->5447|10153->5453|10246->5524|10302->5552|10318->5558|10411->5629|10467->5657|10483->5663|10584->5741|10640->5769|10656->5775|10748->5845
                  LINES: 24->1|25->2|26->3|27->4|32->5|37->5|38->6|43->11|43->11|44->12|44->12|44->12|49->17|49->17|49->17|51->19|51->19|51->19|51->19|52->20|52->20|52->20|54->22|54->22|54->22|55->23|55->23|55->23|56->24|57->25|57->25|57->25|57->25|68->36|68->36|68->36|69->37|71->39|71->39|71->39|73->41|74->42|74->42|75->43|75->43|76->44|76->44|77->45|77->45|81->49|81->49|81->49|83->51|83->51|83->51|84->52|84->52|84->52|85->53|85->53|85->53|86->54|86->54|86->54|87->55|87->55|87->55|90->58|90->58|90->58|91->59|91->59|91->59|92->60|92->60|92->60|94->62|94->62|94->62|95->63|95->63|95->63|96->64|96->64|96->64|97->65|97->65|97->65|98->66|98->66|98->66|99->67|99->67|99->67|100->68|100->68|100->68|101->69|101->69|101->69|102->70|102->70|102->70|103->71|103->71|103->71|104->72|104->72|104->72|106->74|106->74|106->74|107->75|107->75|107->75|109->77|109->77|109->77|110->78|110->78|110->78|111->79|111->79|111->79|112->80|112->80|112->80|113->81|113->81|113->81|114->82|114->82|114->82|116->84|116->84|116->84|129->97|129->97|129->97|129->97|129->97|129->97|130->98|131->99|131->99|131->99|131->99|131->99|131->99|132->100|132->100|132->100|132->100|132->100|132->100|133->101|133->101|133->101|133->101|133->101|133->101|134->102|134->102|134->102|134->102|134->102|134->102|136->104|136->104|136->104|136->104|136->104|136->104|137->105|140->108|140->108|140->108|141->109|141->109|141->109|142->110|142->110|142->110|143->111|143->111|143->111
                  -- GENERATED --
              */
          