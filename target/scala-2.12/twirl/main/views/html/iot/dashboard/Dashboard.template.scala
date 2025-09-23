
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

object Dashboard extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.20*/("""

"""),format.raw/*7.1*/("""<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>"""),_display_(/*12.17*/Messages("Dashboard")),format.raw/*12.38*/("""</title>
        <link rel="icon" type="image/png" href=""""),_display_(/*13.50*/routes/*13.56*/.Assets.versioned("images/logo.jpg")),format.raw/*13.92*/("""">

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        """),_display_(/*18.10*/views/*18.15*/.html.iot.tags.Main_css()),format.raw/*18.40*/("""

        """),format.raw/*20.9*/("""<link href=""""),_display_(/*20.22*/routes/*20.28*/.Assets.versioned("assets/plugins/highcharts/css/highcharts-white.css")),format.raw/*20.99*/("""" rel="stylesheet" />

        <script type="text/javascript" src=""""),_display_(/*22.46*/UserHelper/*22.56*/.linkGoogleMapApi),format.raw/*22.73*/(""""> </script>

        <link href=""""),_display_(/*24.22*/routes/*24.28*/.Assets.versioned("stylesheets/views/dashboard/map.css")),format.raw/*24.84*/("""" rel="stylesheet"/>
        <style type="text/css">
                canvas#canvas4 """),format.raw/*26.32*/("""{"""),format.raw/*26.33*/("""
                    """),format.raw/*27.21*/("""position: relative;
                    /*top: 20px;*/
                """),format.raw/*29.17*/("""}"""),format.raw/*29.18*/("""
        """),format.raw/*30.9*/("""</style>
    </head>
    <body class="bg-theme">

        <div class="">
            """),_display_(/*35.14*/views/*35.19*/.html.iot.tags.Menu(currentUser, "")),format.raw/*35.55*/("""

            """),_display_(/*37.14*/views/*37.19*/.html.iot.tags.Header(currentUser)),format.raw/*37.53*/("""

            """),_display_(/*39.14*/views/*39.19*/.html.iot.dashboard.Dashboard_body()),format.raw/*39.55*/("""
        """),format.raw/*40.9*/("""</div>

        """),_display_(/*42.10*/views/*42.15*/.html.Loading()),format.raw/*42.30*/("""
    """),format.raw/*43.5*/("""</body>

    """),_display_(/*45.6*/views/*45.11*/.html.iot.tags.Main_js()),format.raw/*45.35*/("""

    """),format.raw/*47.5*/("""<script src=""""),_display_(/*47.19*/routes/*47.25*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*47.79*/(""""></script>
        <!--plugins-->
    <script src=""""),_display_(/*49.19*/routes/*49.25*/.Assets.versioned("assets/plugins/simplebar/js/simplebar.min.js")),format.raw/*49.90*/(""""></script>
    <script src=""""),_display_(/*50.19*/routes/*50.25*/.Assets.versioned("assets/plugins/metismenu/js/metisMenu.min.js")),format.raw/*50.90*/(""""></script>
    <script src=""""),_display_(/*51.19*/routes/*51.25*/.Assets.versioned("assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js")),format.raw/*51.102*/(""""></script>
    <script>
        new PerfectScrollbar('.customers-list');

        $(document).ready(function () """),format.raw/*55.39*/("""{"""),format.raw/*55.40*/("""
            """),format.raw/*56.13*/("""$("#menu-home").addClass("mm-active");
        """),format.raw/*57.9*/("""}"""),format.raw/*57.10*/(""")
    </script>

    <script>
            var initLatLng = new google.maps.LatLng(21.025703, 105.832758);
            var mapOptions = """),format.raw/*62.30*/("""{"""),format.raw/*62.31*/("""
                """),format.raw/*63.17*/("""center: initLatLng,
                zoom: 12,
                zoomControl: true,
                zoomControlOptions: """),format.raw/*66.37*/("""{"""),format.raw/*66.38*/("""
                    """),format.raw/*67.21*/("""position: google.maps.ControlPosition.RIGHT_BOTTOM
                """),format.raw/*68.17*/("""}"""),format.raw/*68.18*/(""",
                mapTypeControlOptions: """),format.raw/*69.40*/("""{"""),format.raw/*69.41*/("""
                    """),format.raw/*70.21*/("""position: google.maps.ControlPosition.TOP_RIGHT
                """),format.raw/*71.17*/("""}"""),format.raw/*71.18*/(""",
                scaleControl: true,
                streetViewControl: false,
                fullscreenControl: true,
                fullscreenControlOptions: """),format.raw/*75.43*/("""{"""),format.raw/*75.44*/("""
                    """),format.raw/*76.21*/("""position: google.maps.ControlPosition.RIGHT_BOTTOM
                """),format.raw/*77.17*/("""}"""),format.raw/*77.18*/(""",
                gestureHandling: 'greedy'
            """),format.raw/*79.13*/("""}"""),format.raw/*79.14*/(""";
            var mapPosition = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

            var device_vtag = """"),_display_(/*82.33*/routes/*82.39*/.Assets.versioned("images/dashboard/marker.png")),format.raw/*82.87*/("""";

            var circleSignal_run = """"),_display_(/*84.38*/routes/*84.44*/.Assets.versioned("images/signal/greenCircle.gif")),format.raw/*84.94*/("""";
            var circleSignal_parking = """"),_display_(/*85.42*/routes/*85.48*/.Assets.versioned("images/signal/blueCircle.gif")),format.raw/*85.97*/("""";
            var circleSignal_lost_Gps = """"),_display_(/*86.43*/routes/*86.49*/.Assets.versioned("images/signal/yellowCircle.gif")),format.raw/*86.100*/("""";
            var circleSignal_lost_connect = """"),_display_(/*87.47*/routes/*87.53*/.Assets.versioned("images/signal/grayCircle.gif")),format.raw/*87.102*/("""";
            var circleSignal_alarm = """"),_display_(/*88.40*/routes/*88.46*/.Assets.versioned("images/signal/redCircle.gif")),format.raw/*88.94*/("""";

    </script>
    <script src=""""),_display_(/*91.19*/routes/*91.25*/.Assets.versioned("javascripts/views/dashboard/MapPositionMarkerCluster.js")),format.raw/*91.101*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*92.19*/routes/*92.25*/.Assets.versioned("javascripts/views/dashboard/dashboard_mapController.js")),format.raw/*92.100*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*93.19*/routes/*93.25*/.Assets.versioned("javascripts/views/dashboard/dashboard_map_markerSignal.js")),format.raw/*93.103*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*94.19*/routes/*94.25*/.Assets.versioned("javascripts/views/dashboard/dashboard_map_markerCluster.js")),format.raw/*94.104*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*95.19*/routes/*95.25*/.Assets.versioned("javascripts/views/dashboard/dashboard_map_deviceList.js")),format.raw/*95.101*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*96.19*/routes/*96.25*/.Assets.versioned("javascripts/views/dashboard/dashboard_map_infoWindow.js")),format.raw/*96.101*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*97.19*/routes/*97.25*/.Assets.versioned("javascripts/views/dashboard/dashboard_map_getImgWithRotation.js")),format.raw/*97.109*/("""" type="text/javascript"></script>

    """),format.raw/*99.15*/("""
    """),format.raw/*100.5*/("""<script src=""""),_display_(/*100.19*/routes/*100.25*/.Assets.versioned("javascripts/views/dashboard/dashboard_map_socket.js")),format.raw/*100.97*/("""" type="text/javascript"></script>
    <script type="text/javascript">
            var WS = window['MozWebSocket'] ? MozWebSocket : WebSocket;
            var socket;
            var urlWS;
            if (isSecure()) """),format.raw/*105.29*/("""{"""),format.raw/*105.30*/("""
                """),format.raw/*106.17*/("""urlWS = """"),_display_(/*106.27*/controllers/*106.38*/.routes.SocketController.wsSocket().webSocketURL(true)),format.raw/*106.92*/("""";
            """),format.raw/*107.13*/("""}"""),format.raw/*107.14*/("""
            """),format.raw/*108.13*/("""else """),format.raw/*108.18*/("""{"""),format.raw/*108.19*/("""
                """),format.raw/*109.17*/("""urlWS = """"),_display_(/*109.27*/controllers/*109.38*/.routes.SocketController.wsSocket().webSocketURL(false)),format.raw/*109.93*/("""";
            """),format.raw/*110.13*/("""}"""),format.raw/*110.14*/("""
            """),format.raw/*111.13*/("""console.log("urlWS:" +urlWS);
            setTimeout(function() """),format.raw/*112.35*/("""{"""),format.raw/*112.36*/("""
                """),format.raw/*113.17*/("""socket = startSocket(urlWS, false);
            """),format.raw/*114.13*/("""}"""),format.raw/*114.14*/(""", 3000);
    </script>


    <script src=""""),_display_(/*118.19*/routes/*118.25*/.Assets.versioned("assets/plugins/apexcharts-bundle/js/apexcharts.min.js")),format.raw/*118.99*/(""""></script>

    <script src=""""),_display_(/*120.19*/routes/*120.25*/.Assets.versioned("assets/plugins/highcharts/js/highcharts.js")),format.raw/*120.88*/(""""></script>
    <script src=""""),_display_(/*121.19*/routes/*121.25*/.Assets.versioned("assets/plugins/highcharts/js/highcharts-more.js")),format.raw/*121.93*/(""""></script>
    <script src=""""),_display_(/*122.19*/routes/*122.25*/.Assets.versioned("assets/plugins/highcharts/js/variable-pie.js")),format.raw/*122.90*/(""""></script>
    <script src=""""),_display_(/*123.19*/routes/*123.25*/.Assets.versioned("assets/plugins/highcharts/js/solid-gauge.js")),format.raw/*123.89*/(""""></script>
    <script src=""""),_display_(/*124.19*/routes/*124.25*/.Assets.versioned("assets/plugins/highcharts/js/highcharts-3d.js")),format.raw/*124.91*/(""""></script>
    <script src=""""),_display_(/*125.19*/routes/*125.25*/.Assets.versioned("assets/plugins/highcharts/js/cylinder.js")),format.raw/*125.86*/(""""></script>
    <script src=""""),_display_(/*126.19*/routes/*126.25*/.Assets.versioned("assets/plugins/highcharts/js/funnel3d.js")),format.raw/*126.86*/(""""></script>
    <script src=""""),_display_(/*127.19*/routes/*127.25*/.Assets.versioned("assets/plugins/highcharts/js/exporting.js")),format.raw/*127.87*/(""""></script>
    <script src=""""),_display_(/*128.19*/routes/*128.25*/.Assets.versioned("assets/plugins/highcharts/js/export-data.js")),format.raw/*128.89*/(""""></script>
    <script src=""""),_display_(/*129.19*/routes/*129.25*/.Assets.versioned("assets/plugins/highcharts/js/accessibility.js")),format.raw/*129.91*/(""""></script>

    <script src=""""),_display_(/*131.19*/routes/*131.25*/.Assets.versioned("javascripts/views/dashboard/dashboard_chart.js")),format.raw/*131.92*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*132.19*/routes/*132.25*/.Assets.versioned("javascripts/views/dashboard/dashboard_realtimeChart.js")),format.raw/*132.100*/("""" type="text/javascript"></script>

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
                  DATE: Mon Sep 22 16:32:43 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboard/Dashboard.scala.html
                  HASH: e03c495c95183824c8732cced8ffcf73f6eb76fb
                  MATRIX: 665->1|688->18|724->48|764->82|1101->114|1214->132|1242->134|1425->290|1467->311|1552->369|1567->375|1624->411|1844->604|1858->609|1904->634|1941->644|1981->657|1996->663|2088->734|2183->802|2202->812|2240->829|2302->864|2317->870|2394->926|2506->1010|2535->1011|2584->1032|2683->1103|2712->1104|2748->1113|2861->1199|2875->1204|2932->1240|2974->1255|2988->1260|3043->1294|3085->1309|3099->1314|3156->1350|3192->1359|3236->1376|3250->1381|3286->1396|3318->1401|3358->1415|3372->1420|3417->1444|3450->1450|3491->1464|3506->1470|3581->1524|3661->1577|3676->1583|3762->1648|3819->1678|3834->1684|3920->1749|3977->1779|3992->1785|4091->1862|4232->1975|4261->1976|4302->1989|4376->2036|4405->2037|4568->2172|4597->2173|4642->2190|4787->2307|4816->2308|4865->2329|4960->2396|4989->2397|5058->2438|5087->2439|5136->2460|5228->2524|5257->2525|5448->2688|5477->2689|5526->2710|5621->2777|5650->2778|5734->2834|5763->2835|5927->2972|5942->2978|6011->3026|6079->3067|6094->3073|6165->3123|6236->3167|6251->3173|6321->3222|6393->3267|6408->3273|6481->3324|6557->3373|6572->3379|6643->3428|6712->3470|6727->3476|6796->3524|6859->3560|6874->3566|6972->3642|7052->3695|7067->3701|7164->3776|7244->3829|7259->3835|7359->3913|7439->3966|7454->3972|7555->4051|7635->4104|7650->4110|7748->4186|7828->4239|7843->4245|7941->4321|8021->4374|8036->4380|8142->4464|8210->4514|8243->4519|8285->4533|8301->4539|8395->4611|8642->4829|8672->4830|8718->4847|8756->4857|8777->4868|8853->4922|8897->4937|8927->4938|8969->4951|9003->4956|9033->4957|9079->4974|9117->4984|9138->4995|9215->5050|9259->5065|9289->5066|9331->5079|9424->5143|9454->5144|9500->5161|9577->5209|9607->5210|9678->5253|9694->5259|9790->5333|9849->5364|9865->5370|9950->5433|10008->5463|10024->5469|10114->5537|10172->5567|10188->5573|10275->5638|10333->5668|10349->5674|10435->5738|10493->5768|10509->5774|10597->5840|10655->5870|10671->5876|10754->5937|10812->5967|10828->5973|10911->6034|10969->6064|10985->6070|11069->6132|11127->6162|11143->6168|11229->6232|11287->6262|11303->6268|11391->6334|11450->6365|11466->6371|11555->6438|11636->6491|11652->6497|11750->6572
                  LINES: 24->1|25->2|26->3|27->4|32->5|37->5|39->7|44->12|44->12|45->13|45->13|45->13|50->18|50->18|50->18|52->20|52->20|52->20|52->20|54->22|54->22|54->22|56->24|56->24|56->24|58->26|58->26|59->27|61->29|61->29|62->30|67->35|67->35|67->35|69->37|69->37|69->37|71->39|71->39|71->39|72->40|74->42|74->42|74->42|75->43|77->45|77->45|77->45|79->47|79->47|79->47|79->47|81->49|81->49|81->49|82->50|82->50|82->50|83->51|83->51|83->51|87->55|87->55|88->56|89->57|89->57|94->62|94->62|95->63|98->66|98->66|99->67|100->68|100->68|101->69|101->69|102->70|103->71|103->71|107->75|107->75|108->76|109->77|109->77|111->79|111->79|114->82|114->82|114->82|116->84|116->84|116->84|117->85|117->85|117->85|118->86|118->86|118->86|119->87|119->87|119->87|120->88|120->88|120->88|123->91|123->91|123->91|124->92|124->92|124->92|125->93|125->93|125->93|126->94|126->94|126->94|127->95|127->95|127->95|128->96|128->96|128->96|129->97|129->97|129->97|131->99|132->100|132->100|132->100|132->100|137->105|137->105|138->106|138->106|138->106|138->106|139->107|139->107|140->108|140->108|140->108|141->109|141->109|141->109|141->109|142->110|142->110|143->111|144->112|144->112|145->113|146->114|146->114|150->118|150->118|150->118|152->120|152->120|152->120|153->121|153->121|153->121|154->122|154->122|154->122|155->123|155->123|155->123|156->124|156->124|156->124|157->125|157->125|157->125|158->126|158->126|158->126|159->127|159->127|159->127|160->128|160->128|160->128|161->129|161->129|161->129|163->131|163->131|163->131|164->132|164->132|164->132
                  -- GENERATED --
              */
          