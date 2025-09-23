
package views.html.dashboard

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

object Dashboard extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,Long,Long,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(currentUser:User, countTotalDevice: Long, countTotalUser: Long):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.66*/("""

"""),format.raw/*7.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*12.13*/Messages("Dashboard")),format.raw/*12.34*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*13.46*/routes/*13.52*/.Assets.versioned("images/iot.png")),format.raw/*13.87*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("assets/css/style.css")),format.raw/*18.65*/("""" rel="stylesheet"/>
    <link href=""""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("assets/css/loader-style.css")),format.raw/*19.72*/("""" rel="stylesheet"/>
    <link href=""""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("assets/css/bootstrap.css")),format.raw/*20.69*/("""" rel="stylesheet"/>
    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("assets/js/progress-bar/number-pb.css")),format.raw/*21.81*/("""" rel="stylesheet"/>
    <link href=""""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("stylesheets/views/dashboard/map.css")),format.raw/*22.80*/("""" rel="stylesheet"/>

    <style type="text/css">
            canvas#canvas4 """),format.raw/*25.28*/("""{"""),format.raw/*25.29*/("""
              """),format.raw/*26.15*/("""position: relative;
              top: 20px;
            """),format.raw/*28.13*/("""}"""),format.raw/*28.14*/("""
    """),format.raw/*29.5*/("""</style>
    """),format.raw/*30.83*/("""
    """),format.raw/*31.5*/("""<link rel="shortcut icon" href=""""),_display_(/*31.38*/routes/*31.44*/.Assets.versioned("assets/ico/minus.png")),format.raw/*31.85*/("""">

    <script type="text/javascript" src=""""),_display_(/*33.42*/UserHelper/*33.52*/.linkGoogleMapApi),format.raw/*33.69*/(""""> </script>
  </head>
  <body>
      <!-- Preloader -->
    <div id="preloader">
      <div id="status">&nbsp;</div>
    </div>

    <nav role="navigation" class="navbar navbar-static-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button data-target="#bs-example-navbar-collapse-1" data-toggle="collapse" class="navbar-toggle" type="button">
            <span class="entypo-menu"></span>
          </button>
          <button class="navbar-toggle toggle-menu-mobile toggle-left" type="button">
            <span class="entypo-list-add"></span>
          </button>

          <div id="logo-mobile" class="visible-xs">
            <h1>IoT Platform
              <span>v1.1</span>
            </h1>
          </div>
        </div>

        """),_display_(/*58.10*/views/*58.15*/.html.dashboard.Navbar(currentUser)),format.raw/*58.50*/("""
      """),format.raw/*59.7*/("""</div>
    </nav>

      """),_display_(/*62.8*/views/*62.13*/.html.dashboard.SideMenu(currentUser)),format.raw/*62.50*/("""

      """),format.raw/*64.7*/("""<!--  PAPER WRAP -->
    <div class="wrap-fluid">
      <div class="container-fluid paper-wrap bevel tlbr">
          <!-- CONTENT -->
        """),_display_(/*68.10*/views/*68.15*/.html.dashboard.Title(currentUser, "Dashboard")),format.raw/*68.62*/("""

        """),format.raw/*70.9*/("""<div id="paper-middle">
          <div id="map-canvas"></div>
        </div>

          <!--  DEVICE MANAGER -->
        <div class="content-wrap">
          <div class="row">

            <div class="col-sm-6">
              <div class="col-sm-6">
                <div class="profit" id="profitClose">
                  <div class="headline ">
                    <h3>
                      <span>
                        <i class="maki-ferry"></i>&#160;&#160;"""),_display_(/*84.64*/Messages("Devices")),format.raw/*84.83*/("""</span>
                    </h3>
                  </div>
                  <div class="value">
                    <span><i class="maki-ferry fa-2x"></i>
                    </span><b style="font-size: 60px">"""),_display_(/*89.56*/countTotalDevice),format.raw/*89.72*/("""</b><b>Device IoT</b>
                  </div>
                  <div class="progress-tinny">
                    <div style="width: 50%" class="bar"></div>
                  </div>
                  <div class="profit-line">
                    <i class="fa fa-caret-up fa-lg"></i>&#160;&#160; 50% &#160;From Last Hour</div>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="member" id="memberClose">
                  <div class="headline ">
                    <h3>
                      <span>
                        <i class="fa fa-users"></i>&#160;&#160;"""),_display_(/*103.65*/Messages("USERS")),format.raw/*103.82*/("""</span>
                    </h3>
                  </div>
                  <div class="value">
                    <span><i class="fa fa-user fa-2x"></i>
                    </span><b style="font-size: 60px">"""),_display_(/*108.56*/countTotalUser),format.raw/*108.70*/("""</b><b>User</b>
                  </div>
                  <div class="progress-tinny">
                    <div style="width: 50%" class="bar"></div>
                  </div>
                  <div class="profit-line">
                    <i class="fa fa-caret-up fa-lg"></i>&#160;&#160; 50% &#160;From Last Hour</div>
                </div>
              </div>
              <div class="col-sm-12">
                <div class="order" id="orderClose">
                  <div class="headline ">
                    <h3>
                      <span>
                        <i class="fa fa-rss"></i>&#160;&#160;"""),_display_(/*122.63*/Messages("ACCESS")),format.raw/*122.81*/("""</span>
                    </h3>
                  </div>
                  <div class="value">
                    <span><i class="fa fa-rss fa-2x"></i>
                    </span><b style="font-size: 60px">111</b><b>Access To Day</b>
                  </div>
                  <div class="progress-tinny">
                    <div style="width: 50%" class="bar"></div>
                  </div>
                  <div class="profit-line">
                    <i class="fa fa-caret-up fa-lg"></i>&#160;&#160; 50% &#160;From Last Hour</div>
                </div>
              </div>
            </div>

            <div class="col-sm-6">
              <div class="chart-wrap">
                <div class="chart-dash">
                  <div id="placeholder" style="width:100%;height:200px;"></div>
                </div>

                <div class="row">
                  <div class="col-sm-8">
                    <div class="speed">
                      <h2>Speed </h2>
                      <h1>74
                        <span>Km / hours</span>
                      </h1>
                    </div>
                  </div>
                  <div class="col-sm-4">
                    <div class="traffic">
                      <h2> per day</h2>
                      <h1>2.5874</h1>
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-4">
                    <div class="traffic-rates">
                      <h4> Rates</h4>
                      <h1>30 %
                        <span>-1,3 %</span>
                      </h1>
                    </div>
                  </div>
                  <div class="col-sm-4">
                    <div class="traffic-rates">
                      <h4> Rates</h4>
                      <h1>30 %
                        <span>-1,3 %</span>
                      </h1>
                    </div>
                  </div>
                  <div class="col-sm-4">
                    <div class="traffic-rates">
                      <h4>Rates</h4>
                      <h1>30 %
                        <span>-1,3 %</span>
                      </h1>
                    </div>
                  </div>
                </div>
              </div>
            </div>

          </div>
        </div>
          <!--  / DEVICE MANAGER -->

        <div class="content-wrap">
          <div class="row">

          </div>
            <!-- /END OF CONTENT -->

          """),_display_(/*199.12*/views/*199.17*/.html.dashboard.Footer()),format.raw/*199.41*/("""

        """),format.raw/*201.9*/("""</div>

      </div>
    </div>
      <!--  END OF PAPER WRAP -->

    """),_display_(/*207.6*/views/*207.11*/.html.dashboard.RightSlide()),format.raw/*207.39*/("""


    """),format.raw/*210.5*/("""<script type="text/javascript" src=""""),_display_(/*210.42*/routes/*210.48*/.Assets.versioned("assets/js/chart/realTime.js")),format.raw/*210.96*/(""""></script>

    <script>
            var initLatLng = new google.maps.LatLng(21.025703, 105.832758);
            var mapOptions = """),format.raw/*214.30*/("""{"""),format.raw/*214.31*/("""
              """),format.raw/*215.15*/("""center: initLatLng,
              zoom: 12,
              zoomControl: true,
              zoomControlOptions: """),format.raw/*218.35*/("""{"""),format.raw/*218.36*/("""
                """),format.raw/*219.17*/("""position: google.maps.ControlPosition.RIGHT_BOTTOM
              """),format.raw/*220.15*/("""}"""),format.raw/*220.16*/(""",
              mapTypeControlOptions: """),format.raw/*221.38*/("""{"""),format.raw/*221.39*/("""
                """),format.raw/*222.17*/("""position: google.maps.ControlPosition.TOP_RIGHT
              """),format.raw/*223.15*/("""}"""),format.raw/*223.16*/(""",
              scaleControl: true,
              streetViewControl: false,
              fullscreenControl: true,
              fullscreenControlOptions: """),format.raw/*227.41*/("""{"""),format.raw/*227.42*/("""
                """),format.raw/*228.17*/("""position: google.maps.ControlPosition.RIGHT_BOTTOM
              """),format.raw/*229.15*/("""}"""),format.raw/*229.16*/(""",
              gestureHandling: 'greedy'
            """),format.raw/*231.13*/("""}"""),format.raw/*231.14*/(""";
            var mapPosition = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

            var device_vtag = """"),_display_(/*234.33*/routes/*234.39*/.Assets.versioned("images/vtag/vtag.png")),format.raw/*234.80*/("""";

            var circleSignal_run = """"),_display_(/*236.38*/routes/*236.44*/.Assets.versioned("images/signal/greenCircle.gif")),format.raw/*236.94*/("""";
            var circleSignal_parking = """"),_display_(/*237.42*/routes/*237.48*/.Assets.versioned("images/signal/blueCircle.gif")),format.raw/*237.97*/("""";
            var circleSignal_lost_Gps = """"),_display_(/*238.43*/routes/*238.49*/.Assets.versioned("images/signal/yellowCircle.gif")),format.raw/*238.100*/("""";
            var circleSignal_lost_connect = """"),_display_(/*239.47*/routes/*239.53*/.Assets.versioned("images/signal/grayCircle.gif")),format.raw/*239.102*/("""";
            var circleSignal_alarm = """"),_display_(/*240.40*/routes/*240.46*/.Assets.versioned("images/signal/redCircle.gif")),format.raw/*240.94*/("""";
    </script>
    <script src=""""),_display_(/*242.19*/routes/*242.25*/.Assets.versioned("javascripts/views/dashboard/MapPositionMarkerCluster.js")),format.raw/*242.101*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*243.19*/routes/*243.25*/.Assets.versioned("javascripts/views/dashboard/dashboard_mapController.js")),format.raw/*243.100*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*244.19*/routes/*244.25*/.Assets.versioned("javascripts/views/dashboard/dashboard_map_markerSignal.js")),format.raw/*244.103*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*245.19*/routes/*245.25*/.Assets.versioned("javascripts/views/dashboard/dashboard_map_markerCluster.js")),format.raw/*245.104*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*246.19*/routes/*246.25*/.Assets.versioned("javascripts/views/dashboard/dashboard_map_infoWindow.js")),format.raw/*246.101*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*247.19*/routes/*247.25*/.Assets.versioned("javascripts/views/dashboard/dashboard_map_getImgWithRotation.js")),format.raw/*247.109*/("""" type="text/javascript"></script>

    """),format.raw/*249.15*/("""
    """),format.raw/*250.5*/("""<script src=""""),_display_(/*250.19*/routes/*250.25*/.Assets.versioned("javascripts/views/dashboard/dashboard_map_socket.js")),format.raw/*250.97*/("""" type="text/javascript"></script>
    <script type="text/javascript">
            var WS = window['MozWebSocket'] ? MozWebSocket : WebSocket;
            var socket;
            var urlWS;
            if (isSecure()) """),format.raw/*255.29*/("""{"""),format.raw/*255.30*/("""
              """),format.raw/*256.15*/("""urlWS = """"),_display_(/*256.25*/controllers/*256.36*/.routes.SocketController.wsSocket().webSocketURL(true)),format.raw/*256.90*/("""";
            """),format.raw/*257.13*/("""}"""),format.raw/*257.14*/("""
            """),format.raw/*258.13*/("""else """),format.raw/*258.18*/("""{"""),format.raw/*258.19*/("""
              """),format.raw/*259.15*/("""urlWS = """"),_display_(/*259.25*/controllers/*259.36*/.routes.SocketController.wsSocket().webSocketURL(false)),format.raw/*259.91*/("""";
            """),format.raw/*260.13*/("""}"""),format.raw/*260.14*/("""
            """),format.raw/*261.13*/("""console.log("urlWS:" +urlWS);
            setTimeout(function() """),format.raw/*262.35*/("""{"""),format.raw/*262.36*/("""
              """),format.raw/*263.15*/("""socket = startSocket(urlWS, false);
            """),format.raw/*264.13*/("""}"""),format.raw/*264.14*/(""", 1000);
    </script>

  </body>
</html>
"""))
      }
    }
  }

  def render(currentUser:User,countTotalDevice:Long,countTotalUser:Long): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,countTotalDevice,countTotalUser)

  def f:((User,Long,Long) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,countTotalDevice,countTotalUser) => apply(currentUser,countTotalDevice,countTotalUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:41 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/dashboard/Dashboard.scala.html
                  HASH: bb624363d677bdbe9ff1aa7723fc318af1b1dbaa
                  MATRIX: 661->1|684->18|720->48|760->82|1107->114|1266->178|1294->180|1463->322|1505->343|1586->397|1601->403|1657->438|1877->631|1892->637|1954->678|2019->716|2034->722|2103->770|2168->808|2183->814|2249->859|2314->897|2329->903|2407->960|2472->998|2487->1004|2564->1060|2669->1137|2698->1138|2741->1153|2826->1210|2855->1211|2887->1216|2928->1307|2960->1312|3020->1345|3035->1351|3097->1392|3169->1437|3188->1447|3226->1464|4034->2245|4048->2250|4104->2285|4138->2292|4190->2318|4204->2323|4262->2360|4297->2368|4468->2512|4482->2517|4550->2564|4587->2574|5076->3036|5116->3055|5354->3266|5391->3282|6040->3903|6079->3920|6318->4131|6354->4145|6994->4757|7034->4775|9575->7288|9590->7293|9636->7317|9674->7327|9773->7399|9788->7404|9838->7432|9873->7439|9938->7476|9954->7482|10024->7530|10184->7661|10214->7662|10258->7677|10398->7788|10428->7789|10474->7806|10568->7871|10598->7872|10666->7911|10696->7912|10742->7929|10833->7991|10863->7992|11047->8147|11077->8148|11123->8165|11217->8230|11247->8231|11330->8285|11360->8286|11525->8423|11541->8429|11604->8470|11673->8511|11689->8517|11761->8567|11833->8611|11849->8617|11920->8666|11993->8711|12009->8717|12083->8768|12160->8817|12176->8823|12248->8872|12318->8914|12334->8920|12404->8968|12467->9003|12483->9009|12582->9085|12663->9138|12679->9144|12777->9219|12858->9272|12874->9278|12975->9356|13056->9409|13072->9415|13174->9494|13255->9547|13271->9553|13370->9629|13451->9682|13467->9688|13574->9772|13643->9822|13676->9827|13718->9841|13734->9847|13828->9919|14075->10137|14105->10138|14149->10153|14187->10163|14208->10174|14284->10228|14328->10243|14358->10244|14400->10257|14434->10262|14464->10263|14508->10278|14546->10288|14567->10299|14644->10354|14688->10369|14718->10370|14760->10383|14853->10447|14883->10448|14927->10463|15004->10511|15034->10512
                  LINES: 24->1|25->2|26->3|27->4|32->5|37->5|39->7|44->12|44->12|45->13|45->13|45->13|50->18|50->18|50->18|51->19|51->19|51->19|52->20|52->20|52->20|53->21|53->21|53->21|54->22|54->22|54->22|57->25|57->25|58->26|60->28|60->28|61->29|62->30|63->31|63->31|63->31|63->31|65->33|65->33|65->33|90->58|90->58|90->58|91->59|94->62|94->62|94->62|96->64|100->68|100->68|100->68|102->70|116->84|116->84|121->89|121->89|135->103|135->103|140->108|140->108|154->122|154->122|231->199|231->199|231->199|233->201|239->207|239->207|239->207|242->210|242->210|242->210|242->210|246->214|246->214|247->215|250->218|250->218|251->219|252->220|252->220|253->221|253->221|254->222|255->223|255->223|259->227|259->227|260->228|261->229|261->229|263->231|263->231|266->234|266->234|266->234|268->236|268->236|268->236|269->237|269->237|269->237|270->238|270->238|270->238|271->239|271->239|271->239|272->240|272->240|272->240|274->242|274->242|274->242|275->243|275->243|275->243|276->244|276->244|276->244|277->245|277->245|277->245|278->246|278->246|278->246|279->247|279->247|279->247|281->249|282->250|282->250|282->250|282->250|287->255|287->255|288->256|288->256|288->256|288->256|289->257|289->257|290->258|290->258|290->258|291->259|291->259|291->259|291->259|292->260|292->260|293->261|294->262|294->262|295->263|296->264|296->264
                  -- GENERATED --
              */
          