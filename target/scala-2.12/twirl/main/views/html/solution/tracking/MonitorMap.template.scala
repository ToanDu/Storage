
package views.html.solution.tracking

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

object MonitorMap extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, projectId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.38*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("Monitor Map")),format.raw/*9.36*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    """),_display_(/*16.6*/views/*16.11*/.html.iot.tags.Main_css()),format.raw/*16.36*/("""
    """),format.raw/*17.5*/("""<script type="text/javascript" src=""""),_display_(/*17.42*/UserHelper/*17.52*/.linkGoogleMapApi),format.raw/*17.69*/(""""></script>
    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("stylesheets/views/solution/tracking/map.css")),format.raw/*18.88*/("""" rel="stylesheet"/>
    <link href=""""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("stylesheets/views/solution/tracking/infowindow.css")),format.raw/*19.95*/("""" rel="stylesheet"/>

    <style type="text/css">
            .move-in """),format.raw/*22.22*/("""{"""),format.raw/*22.23*/("""
              """),format.raw/*23.15*/("""-moz-transition: all 0.4s ease;
              -webkit-transition: all 0.4s ease;
              -o-transition: all 0.4s ease;
              -ms-transition: all 0.4s ease;
              transition: all 0.4s ease;
              position: absolute;
              top: 45%;
              left: 97%;
              width: 28px;
              height: 55px;
              display: block;
              padding: 10px 10px 10px 0px;
              z-index: 96;
              cursor: pointer;
              margin-left: -4px;
              background: url("""),_display_(/*38.32*/routes/*38.38*/.Assets.versioned("img/sidebar/moveicon-in.png")),format.raw/*38.86*/(""") no-repeat;
            """),format.raw/*39.13*/("""}"""),format.raw/*39.14*/("""

            """),format.raw/*41.13*/(""".move-out """),format.raw/*41.23*/("""{"""),format.raw/*41.24*/("""
              """),format.raw/*42.15*/("""-moz-transition: all 0.4s ease;
              -webkit-transition: all 0.4s ease;
              -o-transition: all 0.4s ease;
              -ms-transition: all 0.4s ease;
              transition: all 0.4s ease;
              position: absolute;
              top: 45%;
              left: 0px;
              width: 28px;
              height: 55px;
              display: block;
              padding: 10px 10px 10px 0px;
              z-index: 96;
              cursor: pointer;
              background: url("""),_display_(/*56.32*/routes/*56.38*/.Assets.versioned("img/sidebar/moveicon-out.png")),format.raw/*56.87*/(""") no-repeat;
            """),format.raw/*57.13*/("""}"""),format.raw/*57.14*/("""
    """),format.raw/*58.5*/("""</style>

    </head>
  <body class="bg-theme" style="overflow: hidden;">
    <div class="wrapper">
      """),_display_(/*63.8*/views/*63.13*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*63.56*/("""

      """),_display_(/*65.8*/views/*65.13*/.html.iot.tags.Header(currentUser)),format.raw/*65.47*/("""


      """),format.raw/*68.7*/("""<div class="page-wrapper">
        <div class="page-content" style="padding: 0px;">
          <div class="main-panel">
            <div class="overlay-map">

              <div id="sidebar-wrapper" class="left-panel-2">
                <div class="sidebar-content">
                  <div class="panel-heading ">
                    <h4 class="panel-title align-items-center text-white" style="margin-bottom: 0;">"""),_display_(/*76.102*/Messages("manage.tracking.map.title")),format.raw/*76.139*/("""</h4>
                  </div>
                  <div class="panel-body">
                    <div class="col-md-12 form-horizontal" style="padding: 5px;">
                      <div class="search-field">
                        <div class="row" style="">
                          <label class="col-sm-3 col-form-label">"""),_display_(/*82.67*/Messages("Search")),format.raw/*82.85*/("""</label>
                          <div class="col-sm-9">
                            <input id="search-device" class="form-control" type="text" placeholder="">
                          </div>
                        </div>
                      </div>
                    </div>

                    <div id="scroll-area-position" class="col-md-12" style="padding: 0; margin-top: 15px;float: left;">
                      <div class="table-responsive">
                        <table class="table mb-0" id="table-map-view" style="background-color: #EAEBEB">
                          <thead id="theadExport" style="color: white; background-color: #858687">
                            <tr>
                              <th class="text-center" style="width: 40px">"""),_display_(/*95.76*/Messages("STT")),format.raw/*95.91*/("""</th>
                              <th style="width: 100px">"""),_display_(/*96.57*/Messages("manage.tracking.map.name")),format.raw/*96.93*/("""</th>
                              <th style="width: 100px">"""),_display_(/*97.57*/Messages("manage.tracking.map.status")),format.raw/*97.95*/("""</th>
                            </tr>
                          </thead>
                          <tbody>

                          </tbody>
                        </table>
                      </div>
                    </div>

                    <div class="col-md-12" style="float: left; padding: 5px; background-color: #dee2e6;">
                      <table style="margin-bottom: 0">
                        <thead>
                          <tr>
                            <th style="width: 80px"></th>
                            <th>"""),_display_(/*112.34*/Messages("Tổng")),_display_(/*112.51*/Messages(" ")),format.raw/*112.64*/("""</th>
                            <th id="id-sum-stt" style="padding-right: 5px; text-align: right !important;">0</th>
                          </tr>
                        </thead>
                      </table>
                    </div>

                    """),format.raw/*119.39*/("""
                      """),format.raw/*120.162*/("""
                        """),format.raw/*121.52*/("""
                          """),format.raw/*122.48*/("""
                            """),format.raw/*123.159*/("""
                              """),format.raw/*124.61*/("""
                                """),format.raw/*125.52*/("""
                                """),format.raw/*126.90*/("""
                            """),format.raw/*127.39*/("""
                          """),format.raw/*128.37*/("""

                        """),format.raw/*130.35*/("""
                      """),format.raw/*131.33*/("""
                    """),format.raw/*132.31*/("""

                  """),format.raw/*134.19*/("""</div>
                </div>
              </div>

              <a id="menu-toggle" class="move-out"></a>

            </div>
          </div>

          <div id="page-content-wrapper">
            <div id = "map-canvas" class="big-map" style="position: absolute"></div>
          </div>

          """),_display_(/*147.12*/views/*147.17*/.html.solution.tracking.MonitorMap_infowindow(projectId)),format.raw/*147.73*/("""
        """),format.raw/*148.9*/("""</div>
      </div>

    </div>
  </body>

  <script src=""""),_display_(/*154.17*/routes/*154.23*/.Assets.versioned("javascripts/jquery/jquery.js")),format.raw/*154.72*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*155.17*/routes/*155.23*/.Assets.versioned("javascripts/jquery/jquery-ui.js")),format.raw/*155.75*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*156.17*/routes/*156.23*/.Assets.versioned("javascripts/jquery/jquery-ui.min.js")),format.raw/*156.79*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*157.17*/routes/*157.23*/.Assets.versioned("javascripts/jquery/jquery-ui-1.12.1.js")),format.raw/*157.82*/("""" type="text/javascript"></script>

  """),_display_(/*159.4*/views/*159.9*/.html.iot.tags.Main_js()),format.raw/*159.33*/("""

  """),format.raw/*161.3*/("""<script src=""""),_display_(/*161.17*/routes/*161.23*/.Assets.versioned("javascripts/jquery/jquery-1.12.4.js")),format.raw/*161.79*/("""" type="text/javascript"></script>

  <script>
          var projectId = '"""),_display_(/*164.29*/projectId),format.raw/*164.38*/("""';

          $(document).ready(function () """),format.raw/*166.41*/("""{"""),format.raw/*166.42*/("""
            """),format.raw/*167.13*/("""$("#menu-tracking").addClass("mm-active");
            $("#menu-tracking-map").addClass("mm-active");
            $("#menu").metisMenu();
          """),format.raw/*170.11*/("""}"""),format.raw/*170.12*/(""");
  </script>

  <script>
          var initLatLng = new google.maps.LatLng(15.664142, 104.266281);
          var mapOptions = """),format.raw/*175.28*/("""{"""),format.raw/*175.29*/("""
            """),format.raw/*176.13*/("""center: initLatLng,
            zoom: 6,
            zoomControl: true,
            zoomControlOptions: """),format.raw/*179.33*/("""{"""),format.raw/*179.34*/("""
              """),format.raw/*180.15*/("""position: google.maps.ControlPosition.TOP_RIGHT
            """),format.raw/*181.13*/("""}"""),format.raw/*181.14*/(""",
            mapTypeControlOptions: """),format.raw/*182.36*/("""{"""),format.raw/*182.37*/("""
              """),format.raw/*183.15*/("""position: google.maps.ControlPosition.BOTTOM_CENTER
            """),format.raw/*184.13*/("""}"""),format.raw/*184.14*/(""",
            mapTypeControl: false,
            scaleControl: false,
            streetViewControl: false,
            fullscreenControl: true,
            fullscreenControlOptions: """),format.raw/*189.39*/("""{"""),format.raw/*189.40*/("""
              """),format.raw/*190.15*/("""position: google.maps.ControlPosition.RIGHT_BOTTOM
            """),format.raw/*191.13*/("""}"""),format.raw/*191.14*/(""",
            gestureHandling: 'greedy'
          """),format.raw/*193.11*/("""}"""),format.raw/*193.12*/(""";
          var mapPosition = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

          $('.nav-overlay>nav').attr("style", "background-color: rgba(0,0,0,0.5) !important; color: white; position: relative !important;");
          $('#map-canvas').attr("style", "position: absolute;");

          var carRun = """"),_display_(/*199.26*/routes/*199.32*/.Assets.versioned("images/vtag/map.png")),format.raw/*199.72*/("""";
          //Signal
          var circleSignal_run = """"),_display_(/*201.36*/routes/*201.42*/.Assets.versioned("img/image_signal/redCircle.gif")),format.raw/*201.93*/("""";

  </script>
  <script src=""""),_display_(/*204.17*/routes/*204.23*/.Assets.versioned("javascripts/views/solution/tracking/monitorMap/TrackingUtil.js")),format.raw/*204.106*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*206.17*/routes/*206.23*/.Assets.versioned("javascripts/views/solution/tracking/monitorMap/MonitorMap.js")),format.raw/*206.104*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*207.17*/routes/*207.23*/.Assets.versioned("javascripts/views/solution/tracking/monitorMap/MonitorMap_markerSignal.js")),format.raw/*207.117*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*208.17*/routes/*208.23*/.Assets.versioned("javascripts/views/solution/tracking/monitorMap/MapPositionMarkerCluster.js")),format.raw/*208.118*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*209.17*/routes/*209.23*/.Assets.versioned("javascripts/views/solution/tracking/monitorMap/MonitorMap_markerCluster.js")),format.raw/*209.118*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*210.17*/routes/*210.23*/.Assets.versioned("javascripts/views/solution/tracking/monitorMap/MonitorMap_icon.js")),format.raw/*210.109*/("""" type="text/javascript"></script>
  """),format.raw/*211.153*/("""
  """),format.raw/*212.3*/("""<script src=""""),_display_(/*212.17*/routes/*212.23*/.Assets.versioned("javascripts/views/solution/tracking/monitorMap/MonitorMap_infowindow.js")),format.raw/*212.115*/("""" type="text/javascript"></script>

</html>"""))
      }
    }
  }

  def render(currentUser:User,projectId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,projectId)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,projectId) => apply(currentUser,projectId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:49 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/solution/tracking/MonitorMap.scala.html
                  HASH: 9f77da6a808d253c3c583d64474471cb8b39395c
                  MATRIX: 669->1|709->35|1054->67|1185->103|1212->104|1390->256|1433->279|1514->333|1529->339|1586->375|1794->557|1808->562|1854->587|1886->592|1950->629|1969->639|2007->656|2063->685|2078->691|2163->755|2228->793|2243->799|2335->870|2434->941|2463->942|2506->957|3077->1501|3092->1507|3161->1555|3214->1580|3243->1581|3285->1595|3323->1605|3352->1606|3395->1621|3933->2132|3948->2138|4018->2187|4071->2212|4100->2213|4132->2218|4265->2325|4279->2330|4343->2373|4378->2382|4392->2387|4447->2421|4483->2430|4925->2844|4984->2881|5333->3203|5372->3221|6166->3988|6202->4003|6291->4065|6348->4101|6437->4163|6496->4201|7074->4751|7112->4768|7147->4781|7439->5062|7492->5224|7546->5276|7602->5324|7661->5483|7721->5544|7783->5596|7845->5686|7903->5725|7959->5762|8014->5798|8066->5831|8116->5862|8165->5882|8495->6184|8510->6189|8588->6245|8625->6254|8712->6313|8728->6319|8799->6368|8878->6419|8894->6425|8968->6477|9047->6528|9063->6534|9141->6590|9220->6641|9236->6647|9317->6706|9383->6745|9397->6750|9443->6774|9475->6778|9517->6792|9533->6798|9611->6854|9714->6929|9745->6938|9818->6982|9848->6983|9890->6996|10067->7144|10097->7145|10254->7273|10284->7274|10326->7287|10459->7391|10489->7392|10533->7407|10622->7467|10652->7468|10718->7505|10748->7506|10792->7521|10885->7585|10915->7586|11127->7769|11157->7770|11201->7785|11293->7848|11323->7849|11402->7899|11432->7900|11795->8235|11811->8241|11873->8281|11958->8338|11974->8344|12047->8395|12107->8427|12123->8433|12229->8516|12309->8568|12325->8574|12429->8655|12508->8706|12524->8712|12641->8806|12720->8857|12736->8863|12854->8958|12933->9009|12949->9015|13067->9110|13146->9161|13162->9167|13271->9253|13338->9440|13369->9443|13411->9457|13427->9463|13542->9555
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|48->16|48->16|48->16|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|51->19|51->19|54->22|54->22|55->23|70->38|70->38|70->38|71->39|71->39|73->41|73->41|73->41|74->42|88->56|88->56|88->56|89->57|89->57|90->58|95->63|95->63|95->63|97->65|97->65|97->65|100->68|108->76|108->76|114->82|114->82|127->95|127->95|128->96|128->96|129->97|129->97|144->112|144->112|144->112|151->119|152->120|153->121|154->122|155->123|156->124|157->125|158->126|159->127|160->128|162->130|163->131|164->132|166->134|179->147|179->147|179->147|180->148|186->154|186->154|186->154|187->155|187->155|187->155|188->156|188->156|188->156|189->157|189->157|189->157|191->159|191->159|191->159|193->161|193->161|193->161|193->161|196->164|196->164|198->166|198->166|199->167|202->170|202->170|207->175|207->175|208->176|211->179|211->179|212->180|213->181|213->181|214->182|214->182|215->183|216->184|216->184|221->189|221->189|222->190|223->191|223->191|225->193|225->193|231->199|231->199|231->199|233->201|233->201|233->201|236->204|236->204|236->204|238->206|238->206|238->206|239->207|239->207|239->207|240->208|240->208|240->208|241->209|241->209|241->209|242->210|242->210|242->210|243->211|244->212|244->212|244->212|244->212
                  -- GENERATED --
              */
          