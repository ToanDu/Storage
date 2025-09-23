
package views.html.iot.dashboard

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

object DashboardVer2 extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(currentUser:User, projectId:String, idDashboard:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*72.10*/fromTime/*72.18*/ = {{
          import java.util.Calendar
          import java.text.SimpleDateFormat

          val today = Calendar.getInstance
          today.add(Calendar.DATE,-1);
          val curTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm")
          curTimeFormat.format(today.getTime)
        }};def /*81.10*/toTime/*81.16*/ = {{
          import java.util.Calendar
          import java.text.SimpleDateFormat
          //import java.util.TimeZone

          val today = Calendar.getInstance()
          // today.setTimeZone(TimeZone.getTimeZone("GMT+7"))
          val curTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm")
          curTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT+7"));
          curTimeFormat.format(today.getTime)
        }};
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
    <link href='"""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*22.73*/("""' type='text/css'>
    """),format.raw/*23.96*/("""
    """),format.raw/*24.5*/("""<link href=""""),_display_(/*24.18*/routes/*24.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*24.139*/("""" rel="stylesheet" >

    <link href=""""),_display_(/*26.18*/routes/*26.24*/.Assets.versioned("stylesheets/views/dashboard/ver2/dashboard.css")),format.raw/*26.91*/("""" rel="stylesheet"/>
    <link href=""""),_display_(/*27.18*/routes/*27.24*/.Assets.versioned("javascripts/views/dashboard/widget/gridstack.min.css")),format.raw/*27.97*/("""" rel="stylesheet"/>
    """),format.raw/*28.120*/("""
    """),format.raw/*29.5*/("""<link href=""""),_display_(/*29.18*/routes/*29.24*/.Assets.versioned("stylesheets/views/dashboard/widget/switchSocket.css")),format.raw/*29.96*/("""" rel="stylesheet"/>
    <link href=""""),_display_(/*30.18*/routes/*30.24*/.Assets.versioned("stylesheets/views/dashboard/widget/command.css")),format.raw/*30.91*/("""" rel="stylesheet"/>

    <link rel='stylesheet' href='https://api.mapbox.com/mapbox.js/v3.3.1/mapbox.css'/>
    <link rel='stylesheet' href=""""),_display_(/*33.35*/routes/*33.41*/.Assets.versioned("javascripts/plugins/openStreetMap/MarkerCluster.Default.css")),format.raw/*33.121*/(""""/>
    <link rel='stylesheet' href=""""),_display_(/*34.35*/routes/*34.41*/.Assets.versioned("javascripts/plugins/openStreetMap/MarkerCluster.css")),format.raw/*34.113*/(""""/>

  </head>
  <body class="bg-theme">

    <div class="">
      """),_display_(/*40.8*/views/*40.13*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*40.56*/("""

      """),_display_(/*42.8*/views/*42.13*/.html.iot.tags.Header(currentUser)),format.raw/*42.47*/("""

      """),format.raw/*44.7*/("""<div class="page-wrapper">
        <div class="grid-stack" data-gs-width="12" style="background-color: #eceff1" id="bodyDashboard">
        </div>
      </div>

    </div>

    <div class="">
      <div class="toolbar" style="float: right; transition: 0.4s;position: fixed;bottom: 10px;right: 20px;z-index: 99;">
        """),format.raw/*53.92*/("""
          """),format.raw/*54.93*/("""
        """),format.raw/*55.22*/("""
        """),format.raw/*56.9*/("""<button class="btn btn-light px-3 radius-30" onclick="routesPageWiget()" style="color: black;">
          <i class="bx bx-edit" aria-hidden="true"></i> """),_display_(/*57.58*/Messages("widget.edit")),format.raw/*57.81*/("""
        """),format.raw/*58.9*/("""</button>
      </div>
    </div>

    <div class="switcher-wrapper">
      <div class="switcher-btn"> <i class='bx bx-cog bx-spin'></i>
      </div>
      <div class="switcher-body">
        <div class="d-flex align-items-center">
          <h5 class="mb-0 text-uppercase text-danger">"""),_display_(/*67.56*/Messages("Cấu hình")),format.raw/*67.76*/("""</h5>
          <button type="button" class="btn-close ms-auto close-switcher" aria-label="Close"></button>
        </div>
        <hr/>

        """),format.raw/*80.10*/("""
        """),format.raw/*91.10*/("""

        """),format.raw/*93.9*/("""<div class="row">
          <div class="form-group mt-3">
            <div class="row">
              <label class="col-md-3 col-form-label" style="text-align: center">"""),_display_(/*96.82*/Messages("Từ ")),format.raw/*96.97*/("""</label>
              <div class="col-md-9">
                <div class="form-group">
                  <input class="result form-control" type="text" id="date_timepicker_start" value=""""),_display_(/*99.101*/fromTime),format.raw/*99.109*/("""">
                </div>
              </div>
            </div>
          </div>

          <div class="form-group mt-3">
            <div class="row">
              <label class="col-md-3 col-form-label" style="text-align: center">"""),_display_(/*107.82*/Messages("Đến ")),format.raw/*107.98*/("""</label>
              <div class="col-md-9">
                <div class="form-group has-default">
                  <input class="result form-control" type="text" id="date_timepicker_end" value=""""),_display_(/*110.99*/toTime),format.raw/*110.105*/("""">
                </div>
              </div>
            </div>
          </div>

          <div class="form-group mt-3">
            <div class="row">
              <label class="col-md-3 col-form-label" style="text-align: center">"""),_display_(/*118.82*/Messages("Type")),format.raw/*118.98*/("""</label>
              <div class="col-md-9">
                <div class="form-group has-default">
                  <select class="form-control" id="aggType" onchange="chooseAggType(this)">
                    <option value="NONE" selected>"""),_display_(/*122.52*/Messages("NONE")),format.raw/*122.68*/("""</option>
                    <option value="MAX">"""),_display_(/*123.42*/Messages("MAX")),format.raw/*123.57*/("""</option>
                    <option value="MIN">"""),_display_(/*124.42*/Messages("MIN")),format.raw/*124.57*/("""</option>
                    <option value="AVG">"""),_display_(/*125.42*/Messages("AVG")),format.raw/*125.57*/("""</option>
                      <option value="SUM">"""),_display_(/*126.44*/Messages("SUM")),format.raw/*126.59*/("""</option>
                      <option value="COUNT">"""),_display_(/*127.46*/Messages("COUNT")),format.raw/*127.63*/("""</option>
                  </select>
                </div>
              </div>
            </div>
          </div>

          <div class="form-group mt-3" style="display: none" id="tabInterval">
            <div class="row">
              <label class="col-md-3 col-form-label" style="text-align: center">"""),_display_(/*136.82*/Messages("Interval")),format.raw/*136.102*/("""</label>
              <div class="col-md-9">
                <div class="form-group has-default">
                  <input class="result form-control" type="number" id="interval" value="0">
                </div>
              </div>
            </div>
          </div>

          <div class="btn-group mt-3">
            <a type="button" class="btn btn-danger" onclick="applyConfigDashboard()" style="width: 48%">"""),_display_(/*146.106*/Messages("Áp dụng ")),format.raw/*146.126*/("""</a>
            <a type="button" class="btn btn-telco" onclick="resetConfigDashboard()" style="width: 48%; border: 1px solid red;">"""),_display_(/*147.129*/Messages("Reset ")),format.raw/*147.147*/("""</a>
          </div>
        </div>

      </div>
    </div>

    """),_display_(/*154.6*/views/*154.11*/.html.Loading()),format.raw/*154.26*/("""
  """),format.raw/*155.3*/("""</body>

  """),_display_(/*157.4*/views/*157.9*/.html.iot.tags.Main_js()),format.raw/*157.33*/("""

  """),format.raw/*159.3*/("""<script>
    var projectId = '"""),_display_(/*160.23*/projectId),format.raw/*160.32*/("""';
    var idDashboard = '"""),_display_(/*161.25*/idDashboard),format.raw/*161.36*/("""';
    var linkMapbox = '"""),_display_(/*162.24*/UserHelper/*162.34*/.linkGoogleMapbox),format.raw/*162.51*/("""';

          $(document).ready(function () """),format.raw/*164.41*/("""{"""),format.raw/*164.42*/("""
            """),format.raw/*165.13*/("""$("#menu-dashboard").addClass("mm-active");
            $("#menu").metisMenu();

            $('#date_timepicker_start').bootstrapMaterialDatePicker("""),format.raw/*168.69*/("""{"""),format.raw/*168.70*/("""
              """),format.raw/*169.15*/("""format: 'DD/MM/YYYY HH:mm',
//                time: false
            """),format.raw/*171.13*/("""}"""),format.raw/*171.14*/(""");
            $('#date_timepicker_end').bootstrapMaterialDatePicker("""),format.raw/*172.67*/("""{"""),format.raw/*172.68*/("""
              """),format.raw/*173.15*/("""format: 'DD/MM/YYYY HH:mm',
//                time: false
            """),format.raw/*175.13*/("""}"""),format.raw/*175.14*/(""");
          """),format.raw/*176.11*/("""}"""),format.raw/*176.12*/(""");

    function routesPageWiget() """),format.raw/*178.32*/("""{"""),format.raw/*178.33*/("""
      """),format.raw/*179.7*/("""window.location.href = jsRoutes.controllers.WidgetListController.widgetPage('"""),_display_(/*179.85*/projectId),format.raw/*179.94*/("""', '"""),_display_(/*179.99*/idDashboard),format.raw/*179.110*/("""').url;
    """),format.raw/*180.5*/("""}"""),format.raw/*180.6*/("""

    """),format.raw/*182.5*/("""function backListDashboard() """),format.raw/*182.34*/("""{"""),format.raw/*182.35*/("""
      """),format.raw/*183.7*/("""window.location.href = jsRoutes.controllers.DashboardV3Controller.dashboardList('"""),_display_(/*183.89*/projectId),format.raw/*183.98*/("""').url;
    """),format.raw/*184.5*/("""}"""),format.raw/*184.6*/("""
  """),format.raw/*185.3*/("""</script>

  <script>
          var device_vtag = """"),_display_(/*188.31*/routes/*188.37*/.Assets.versioned("images/dashboard/marker.png")),format.raw/*188.85*/("""";

          var circleSignal_run = """"),_display_(/*190.36*/routes/*190.42*/.Assets.versioned("images/signal/greenCircle.gif")),format.raw/*190.92*/("""";
          var circleSignal_parking = """"),_display_(/*191.40*/routes/*191.46*/.Assets.versioned("images/signal/blueCircle.gif")),format.raw/*191.95*/("""";
          var circleSignal_lost_Gps = """"),_display_(/*192.41*/routes/*192.47*/.Assets.versioned("images/signal/yellowCircle.gif")),format.raw/*192.98*/("""";
          var circleSignal_lost_connect = """"),_display_(/*193.45*/routes/*193.51*/.Assets.versioned("images/signal/grayCircle.gif")),format.raw/*193.100*/("""";
          var circleSignal_alarm = """"),_display_(/*194.38*/routes/*194.44*/.Assets.versioned("images/signal/redCircle.gif")),format.raw/*194.92*/("""";

  </script>
  <script src=""""),_display_(/*197.17*/routes/*197.23*/.Assets.versioned("assets/plugins/apexcharts-bundle/js/apexcharts.min.js")),format.raw/*197.97*/(""""></script>
  <script src=""""),_display_(/*198.17*/routes/*198.23*/.Assets.versioned("javascripts/plugins/loader.js")),format.raw/*198.73*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*199.17*/routes/*199.23*/.Assets.versioned("javascripts/chartist/chartist.min.js")),format.raw/*199.80*/(""""></script>

  <script src=""""),_display_(/*201.17*/routes/*201.23*/.Assets.versioned("assets/plugins/highcharts/js/highcharts.js")),format.raw/*201.86*/(""""></script>
  <script src=""""),_display_(/*202.17*/routes/*202.23*/.Assets.versioned("assets/plugins/highcharts/js/highcharts-more.js")),format.raw/*202.91*/(""""></script>
  <script src=""""),_display_(/*203.17*/routes/*203.23*/.Assets.versioned("assets/plugins/highcharts/js/variable-pie.js")),format.raw/*203.88*/(""""></script>
  <script src=""""),_display_(/*204.17*/routes/*204.23*/.Assets.versioned("assets/plugins/highcharts/js/solid-gauge.js")),format.raw/*204.87*/(""""></script>
  <script src=""""),_display_(/*205.17*/routes/*205.23*/.Assets.versioned("assets/plugins/highcharts/js/highcharts-3d.js")),format.raw/*205.89*/(""""></script>
  <script src=""""),_display_(/*206.17*/routes/*206.23*/.Assets.versioned("assets/plugins/highcharts/js/cylinder.js")),format.raw/*206.84*/(""""></script>
  <script src=""""),_display_(/*207.17*/routes/*207.23*/.Assets.versioned("assets/plugins/highcharts/js/funnel3d.js")),format.raw/*207.84*/(""""></script>
  <script src=""""),_display_(/*208.17*/routes/*208.23*/.Assets.versioned("assets/plugins/highcharts/js/exporting.js")),format.raw/*208.85*/(""""></script>
  <script src=""""),_display_(/*209.17*/routes/*209.23*/.Assets.versioned("assets/plugins/highcharts/js/export-data.js")),format.raw/*209.87*/(""""></script>
  <script src=""""),_display_(/*210.17*/routes/*210.23*/.Assets.versioned("assets/plugins/highcharts/js/accessibility.js")),format.raw/*210.89*/(""""></script>
  <script src=""""),_display_(/*211.17*/routes/*211.23*/.Assets.versioned("assets/plugins/mustache/js/mustache.min.js")),format.raw/*211.86*/(""""></script>

  <script src=""""),_display_(/*213.17*/routes/*213.23*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.min.js")),format.raw/*213.136*/(""""></script>

  <script src=""""),_display_(/*215.17*/routes/*215.23*/.Assets.versioned("javascripts/views/dashboard/widget/gridstack-h5.js")),format.raw/*215.94*/(""""></script>
  <script src=""""),_display_(/*216.17*/routes/*216.23*/.Assets.versioned("javascripts/views/dashboard/MapPositionMarkerCluster.js")),format.raw/*216.99*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*217.17*/routes/*217.23*/.Assets.versioned("javascripts/views/dashboard/ver2/dashboard.js")),format.raw/*217.89*/(""""></script>
  <script src=""""),_display_(/*218.17*/routes/*218.23*/.Assets.versioned("javascripts/views/dashboard/ver2/dashboard_map.js")),format.raw/*218.93*/(""""></script>
  <script src=""""),_display_(/*219.17*/routes/*219.23*/.Assets.versioned("javascripts/views/dashboard/ver2/Dashboard_map_markerSignal.js")),format.raw/*219.106*/(""""></script>
  <script src=""""),_display_(/*220.17*/routes/*220.23*/.Assets.versioned("javascripts/views/dashboard/ver2/Dashboard_map_markerCluster.js")),format.raw/*220.107*/(""""></script>
  <script src=""""),_display_(/*221.17*/routes/*221.23*/.Assets.versioned("javascripts/views/dashboard/ver2/Dashboard_map_infoWindow.js")),format.raw/*221.104*/(""""></script>
  <script src=""""),_display_(/*222.17*/routes/*222.23*/.Assets.versioned("javascripts/views/dashboard/ver2/Dashboard_map_updateMarker.js")),format.raw/*222.106*/(""""></script>

  <script type="text/javascript" src=""""),_display_(/*224.40*/routes/*224.46*/.Assets.versioned("javascripts/plugins/openStreetMap/leaflet.js")),format.raw/*224.111*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*225.40*/routes/*225.46*/.Assets.versioned("javascripts/plugins/openStreetMap/leaflet.markercluster-src.js")),format.raw/*225.129*/(""""></script>
  <script src=""""),_display_(/*226.17*/routes/*226.23*/.Assets.versioned("javascripts/views/dashboard/ver2/dashboard_map_mapbox.js")),format.raw/*226.100*/(""""></script>

  <script src=""""),_display_(/*228.17*/routes/*228.23*/.Assets.versioned("javascripts/views/dashboard/ver2/dashboard_chart.js")),format.raw/*228.95*/(""""></script>
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
            """),format.raw/*241.13*/("""{"""),format.raw/*241.14*/("""{"""),format.raw/*241.15*/("""#."""),format.raw/*241.17*/("""}"""),format.raw/*241.18*/("""}"""),format.raw/*241.19*/("""
              """),format.raw/*242.15*/("""<tr>
                    <th scope="row">"""),format.raw/*243.37*/("""{"""),format.raw/*243.38*/("""{"""),format.raw/*243.39*/("""device"""),format.raw/*243.45*/("""}"""),format.raw/*243.46*/("""}"""),format.raw/*243.47*/("""</th>
                    <td>"""),format.raw/*244.25*/("""{"""),format.raw/*244.26*/("""{"""),format.raw/*244.27*/("""var"""),format.raw/*244.30*/("""}"""),format.raw/*244.31*/("""}"""),format.raw/*244.32*/("""</td>
                    <td>"""),format.raw/*245.25*/("""{"""),format.raw/*245.26*/("""{"""),format.raw/*245.27*/("""data"""),format.raw/*245.31*/("""}"""),format.raw/*245.32*/("""}"""),format.raw/*245.33*/("""</td>
                    <td>"""),format.raw/*246.25*/("""{"""),format.raw/*246.26*/("""{"""),format.raw/*246.27*/("""time"""),format.raw/*246.31*/("""}"""),format.raw/*246.32*/("""}"""),format.raw/*246.33*/("""</td>
              </tr>
            """),format.raw/*248.13*/("""{"""),format.raw/*248.14*/("""{"""),format.raw/*248.15*/("""/."""),format.raw/*248.17*/("""}"""),format.raw/*248.18*/("""}"""),format.raw/*248.19*/("""
        """),format.raw/*249.9*/("""</tbody>
    </table>
  </script>
  <script src=""""),_display_(/*252.17*/routes/*252.23*/.Assets.versioned("javascripts/views/dashboard/ver2/dashboard_table.js")),format.raw/*252.95*/(""""></script>
  <script src=""""),_display_(/*253.17*/routes/*253.23*/.Assets.versioned("javascripts/views/dashboard/ver2/dashboard_gauge.js")),format.raw/*253.95*/(""""></script>
  <script src=""""),_display_(/*254.17*/routes/*254.23*/.Assets.versioned("javascripts/views/dashboard/ver2/dashboard_round_switch.js")),format.raw/*254.102*/(""""></script>
  <script src=""""),_display_(/*255.17*/routes/*255.23*/.Assets.versioned("javascripts/views/dashboard/ver2/dashboard_data.js")),format.raw/*255.94*/(""""></script>
  <script src=""""),_display_(/*256.17*/routes/*256.23*/.Assets.versioned("javascripts/views/dashboard/ver2/dashboard_command.js")),format.raw/*256.97*/(""""></script>
  <script src=""""),_display_(/*257.17*/routes/*257.23*/.Assets.versioned("javascripts/views/dashboard/ver2/dashboard_config.js")),format.raw/*257.96*/(""""></script>

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
                  DATE: Mon Sep 22 16:32:43 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboard/DashboardVer2.scala.html
                  HASH: 0c4bda71ec8ac5aadd1a1b624616a2ffa3548ebd
                  MATRIX: 665->1|688->18|724->48|764->82|1119->114|1255->3426|1272->3434|1582->3739|1597->3745|2053->170|2081->172|2250->314|2292->335|2373->389|2388->395|2445->431|2652->612|2666->617|2712->642|2745->648|2785->661|2800->667|2892->738|2982->801|3001->811|3039->828|3096->858|3111->864|3181->913|3232->1027|3264->1032|3304->1045|3319->1051|3456->1166|3522->1205|3537->1211|3625->1278|3690->1316|3705->1322|3799->1395|3853->1535|3885->1540|3925->1553|3940->1559|4033->1631|4098->1669|4113->1675|4201->1742|4371->1885|4386->1891|4488->1971|4553->2009|4568->2015|4662->2087|4756->2155|4770->2160|4834->2203|4869->2212|4883->2217|4938->2251|4973->2259|5322->2663|5361->2756|5398->2778|5434->2787|5614->2940|5658->2963|5694->2972|6008->3259|6049->3279|6223->3729|6260->4171|6297->4181|6493->4350|6529->4365|6744->4552|6774->4560|7037->4795|7075->4811|7300->5008|7329->5014|7592->5249|7630->5265|7900->5507|7938->5523|8017->5574|8054->5589|8133->5640|8170->5655|8249->5706|8286->5721|8367->5774|8404->5789|8487->5844|8526->5861|8863->6170|8906->6190|9351->6606|9394->6626|9556->6759|9597->6777|9692->6845|9707->6850|9744->6865|9775->6868|9814->6880|9828->6885|9874->6909|9906->6913|9965->6944|9996->6953|10051->6980|10084->6991|10138->7017|10158->7027|10197->7044|10270->7088|10300->7089|10342->7102|10520->7251|10550->7252|10594->7267|10693->7337|10723->7338|10821->7407|10851->7408|10895->7423|10994->7493|11024->7494|11066->7507|11096->7508|11160->7543|11190->7544|11225->7551|11331->7629|11362->7638|11395->7643|11429->7654|11469->7666|11498->7667|11532->7673|11590->7702|11620->7703|11655->7710|11765->7792|11796->7801|11836->7813|11865->7814|11896->7817|11976->7869|11992->7875|12062->7923|12129->7962|12145->7968|12217->8018|12287->8060|12303->8066|12374->8115|12445->8158|12461->8164|12534->8215|12609->8262|12625->8268|12697->8317|12765->8357|12781->8363|12851->8411|12911->8443|12927->8449|13023->8523|13079->8551|13095->8557|13167->8607|13246->8658|13262->8664|13341->8721|13398->8750|13414->8756|13499->8819|13555->8847|13571->8853|13661->8921|13717->8949|13733->8955|13820->9020|13876->9048|13892->9054|13978->9118|14034->9146|14050->9152|14138->9218|14194->9246|14210->9252|14293->9313|14349->9341|14365->9347|14448->9408|14504->9436|14520->9442|14604->9504|14660->9532|14676->9538|14762->9602|14818->9630|14834->9636|14922->9702|14978->9730|14994->9736|15079->9799|15136->9828|15152->9834|15288->9947|15345->9976|15361->9982|15454->10053|15510->10081|15526->10087|15624->10163|15703->10214|15719->10220|15807->10286|15863->10314|15879->10320|15971->10390|16027->10418|16043->10424|16149->10507|16205->10535|16221->10541|16328->10625|16384->10653|16400->10659|16504->10740|16560->10768|16576->10774|16682->10857|16762->10909|16778->10915|16866->10980|16945->11031|16961->11037|17067->11120|17123->11148|17139->11154|17239->11231|17296->11260|17312->11266|17406->11338|17861->11764|17891->11765|17921->11766|17952->11768|17982->11769|18012->11770|18056->11785|18126->11826|18156->11827|18186->11828|18221->11834|18251->11835|18281->11836|18340->11866|18370->11867|18400->11868|18432->11871|18462->11872|18492->11873|18551->11903|18581->11904|18611->11905|18644->11909|18674->11910|18704->11911|18763->11941|18793->11942|18823->11943|18856->11947|18886->11948|18916->11949|18983->11987|19013->11988|19043->11989|19074->11991|19104->11992|19134->11993|19171->12002|19249->12052|19265->12058|19359->12130|19415->12158|19431->12164|19525->12236|19581->12264|19597->12270|19699->12349|19755->12377|19771->12383|19864->12454|19920->12482|19936->12488|20032->12562|20088->12590|20104->12596|20199->12669
                  LINES: 24->1|25->2|26->3|27->4|32->5|36->72|36->72|44->81|44->81|55->5|57->7|62->12|62->12|63->13|63->13|63->13|68->18|68->18|68->18|70->20|70->20|70->20|70->20|71->21|71->21|71->21|72->22|72->22|72->22|73->23|74->24|74->24|74->24|74->24|76->26|76->26|76->26|77->27|77->27|77->27|78->28|79->29|79->29|79->29|79->29|80->30|80->30|80->30|83->33|83->33|83->33|84->34|84->34|84->34|90->40|90->40|90->40|92->42|92->42|92->42|94->44|103->53|104->54|105->55|106->56|107->57|107->57|108->58|117->67|117->67|122->80|123->91|125->93|128->96|128->96|131->99|131->99|139->107|139->107|142->110|142->110|150->118|150->118|154->122|154->122|155->123|155->123|156->124|156->124|157->125|157->125|158->126|158->126|159->127|159->127|168->136|168->136|178->146|178->146|179->147|179->147|186->154|186->154|186->154|187->155|189->157|189->157|189->157|191->159|192->160|192->160|193->161|193->161|194->162|194->162|194->162|196->164|196->164|197->165|200->168|200->168|201->169|203->171|203->171|204->172|204->172|205->173|207->175|207->175|208->176|208->176|210->178|210->178|211->179|211->179|211->179|211->179|211->179|212->180|212->180|214->182|214->182|214->182|215->183|215->183|215->183|216->184|216->184|217->185|220->188|220->188|220->188|222->190|222->190|222->190|223->191|223->191|223->191|224->192|224->192|224->192|225->193|225->193|225->193|226->194|226->194|226->194|229->197|229->197|229->197|230->198|230->198|230->198|231->199|231->199|231->199|233->201|233->201|233->201|234->202|234->202|234->202|235->203|235->203|235->203|236->204|236->204|236->204|237->205|237->205|237->205|238->206|238->206|238->206|239->207|239->207|239->207|240->208|240->208|240->208|241->209|241->209|241->209|242->210|242->210|242->210|243->211|243->211|243->211|245->213|245->213|245->213|247->215|247->215|247->215|248->216|248->216|248->216|249->217|249->217|249->217|250->218|250->218|250->218|251->219|251->219|251->219|252->220|252->220|252->220|253->221|253->221|253->221|254->222|254->222|254->222|256->224|256->224|256->224|257->225|257->225|257->225|258->226|258->226|258->226|260->228|260->228|260->228|273->241|273->241|273->241|273->241|273->241|273->241|274->242|275->243|275->243|275->243|275->243|275->243|275->243|276->244|276->244|276->244|276->244|276->244|276->244|277->245|277->245|277->245|277->245|277->245|277->245|278->246|278->246|278->246|278->246|278->246|278->246|280->248|280->248|280->248|280->248|280->248|280->248|281->249|284->252|284->252|284->252|285->253|285->253|285->253|286->254|286->254|286->254|287->255|287->255|287->255|288->256|288->256|288->256|289->257|289->257|289->257
                  -- GENERATED --
              */
          