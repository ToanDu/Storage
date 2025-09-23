
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

object HistoryMap extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, projectId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*84.22*/fromTime/*84.30*/ = {{
                      import java.text.SimpleDateFormat
                      import java.util.Calendar

                      val today = Calendar.getInstance
                      today.add(Calendar.DATE, +0);
                      val curTimeFormat = new SimpleDateFormat("dd/MM/yyyy")
                      curTimeFormat.format(today.getTime)
                    }};def /*94.22*/toTime/*94.28*/ = {{
                      import java.text.SimpleDateFormat
                      import java.util.Calendar
                      import java.util.TimeZone

                      val today = Calendar.getInstance()
                      val curTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm")
                      curTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT+7"))
                      curTimeFormat.format(today.getTime)
                    }};
Seq[Any](format.raw/*3.38*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("History Map")),format.raw/*9.36*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <link href=""""),_display_(/*15.18*/routes/*15.24*/.Assets.versioned("stylesheets/views/solution/tracking/history.css")),format.raw/*15.92*/("""" rel="stylesheet"/>

    """),_display_(/*17.6*/views/*17.11*/.html.iot.tags.Main_css()),format.raw/*17.36*/("""
    """),format.raw/*18.5*/("""<script type="text/javascript" src=""""),_display_(/*18.42*/UserHelper/*18.52*/.linkGoogleMapApi),format.raw/*18.69*/(""""></script>
    <link href=""""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("stylesheets/views/solution/tracking/datetimepicker.css")),format.raw/*19.99*/("""" rel="stylesheet"/>

    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("javascripts/plugins/select2/css/select2.min.css")),format.raw/*21.92*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("javascripts/plugins/select2/css/select2-bootstrap4.css")),format.raw/*22.99*/("""" rel="stylesheet" />


    <style type="text/css">
            .move-in """),format.raw/*26.22*/("""{"""),format.raw/*26.23*/("""
              """),format.raw/*27.15*/("""-moz-transition: all 0.4s ease;
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
              background: url("""),_display_(/*42.32*/routes/*42.38*/.Assets.versioned("img/sidebar/moveicon-in.png")),format.raw/*42.86*/(""") no-repeat;
            """),format.raw/*43.13*/("""}"""),format.raw/*43.14*/("""

            """),format.raw/*45.13*/(""".move-out """),format.raw/*45.23*/("""{"""),format.raw/*45.24*/("""
              """),format.raw/*46.15*/("""-moz-transition: all 0.4s ease;
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
              background: url("""),_display_(/*60.32*/routes/*60.38*/.Assets.versioned("img/sidebar/moveicon-out.png")),format.raw/*60.87*/(""") no-repeat;
            """),format.raw/*61.13*/("""}"""),format.raw/*61.14*/("""
    """),format.raw/*62.5*/("""</style>

  </head>
  <body class="bg-theme" style="overflow: hidden;">
    <div class="wrapper">
      """),_display_(/*67.8*/views/*67.13*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*67.56*/("""

      """),_display_(/*69.8*/views/*69.13*/.html.iot.tags.Header(currentUser)),format.raw/*69.47*/("""


      """),format.raw/*72.7*/("""<div class="page-wrapper">
        <div class="page-content" style="padding: 0px;">
          <div class="main-panel">
            <div class="overlay-map">

              <div id="sidebar-wrapper" class="left-panel">
                <div class="sidebar-content">
                  <div class="panel-heading ">
                    <h4 class="panel-title align-items-center text-white" style="margin-bottom: 0;">"""),_display_(/*80.102*/Messages("manage.tracking.history.title")),format.raw/*80.143*/("""</h4>
                  </div>
                  <div class="panel-body">

                    """),format.raw/*92.22*/("""

                    """),format.raw/*103.22*/("""

                    """),format.raw/*105.21*/("""<div class="col-md-12" style="padding: 3px 3px 3px 10px;">
                      <div class="search-field">
                        <div class="row">
                          <label for="date_timepicker_start" class="col-sm-3 col-form-label form-group"> """),_display_(/*108.107*/Messages("manage.tracking.history.start")),format.raw/*108.148*/(""" """),format.raw/*108.149*/("""</label>
                          <div class="col-sm-8">
                            <input id="date_timepicker_start" class="result form-control datetimepicker" type="text" value=""""),_display_(/*110.126*/fromTime),format.raw/*110.134*/(""" """),format.raw/*110.135*/("""00:00" autocomplete="off" style=""/>
                          </div>
                        </div>
                      </div>
                      <div class="search-field mt-2">
                        <div class="row">
                          <label for="date_timepicker_end" class="col-sm-3 col-form-label form-group">"""),_display_(/*116.104*/Messages("manage.tracking.history.end")),format.raw/*116.143*/("""</label>
                          <div class="col-sm-8">
                            <input id="date_timepicker_end" class="result form-control datetimepicker" type="text" value=""""),_display_(/*118.124*/toTime),format.raw/*118.130*/("""" autocomplete="off" style="">
                          </div>
                        </div>
                      </div>
                      <div class="search-field mt-2">
                        <div class="row">
                          <label class="col-sm-3 col-form-label">"""),_display_(/*124.67*/Messages("manage.tracking.map.name")),format.raw/*124.103*/("""</label>
                          <div class="col-sm-8" id="selectDevice">
                            <select id="idDevice" data-placeholder="" class="single-select" style="width: 100%">
                              <option value="">"""),_display_(/*127.49*/Messages("manage.tracking.history.chooseDevice")),format.raw/*127.97*/("""</option>
                            </select>
                          </div>
                        </div>
                      </div>
                    </div >

                    <div class="col-md-12 text-right" style="padding: 5px 0px">
                      <div class="row">
                        <div class="col-md-12">
                          <button style="float: left;width: 45%; height: 35px; background-color: #de2436bf; color: white; margin-left: 5px;" type="button" class="btn btnControlHistory" onclick="processGetListHistory()">
                            <i class="bx bx-search-alt" style="margin-bottom: -1rem;"></i>"""),_display_(/*138.92*/Messages("manage.tracking.history.view")),format.raw/*138.132*/("""
                          """),format.raw/*139.27*/("""</button>
                          <button style="float: left;width: 45%; height: 35px; background-color: #de2436bf; color: white; margin-left: 5px;" type="button" id="buttonPlayStop" class="btn btnControlHistory" onclick="playbackHistory()">
                            <i class="bx bx-play-circle" style="margin-bottom: -1rem;"></i> """),_display_(/*141.94*/Messages("manage.tracking.history.play")),format.raw/*141.134*/("""
                          """),format.raw/*142.27*/("""</button>
                          <select type="button" class="btn" style="float: left;width: 45%; height: 35px;margin-left: 5px;background-color: #de2436bf; color: white;margin-top: 5px;" id="searchQuickHistory" onchange="searchQuickHistory()" title=""""),_display_(/*143.246*/Messages("manage.tracking.history.quick")),format.raw/*143.287*/("""">
                            <option value="">"""),_display_(/*144.47*/Messages("manage.tracking.history.quick")),format.raw/*144.88*/("""</option>
                            <option value="1">"""),_display_(/*145.48*/Messages("history.search1Day")),format.raw/*145.78*/("""</option>
                            <option value="3">"""),_display_(/*146.48*/Messages("history.search3Day")),format.raw/*146.78*/("""</option>
                            <option value="7">"""),_display_(/*147.48*/Messages("history.search7Day")),format.raw/*147.78*/("""</option>
                            <option value="15">"""),_display_(/*148.49*/Messages("history.search15Day")),format.raw/*148.80*/("""</option>
                            <option value="30">"""),_display_(/*149.49*/Messages("history.search30Day")),format.raw/*149.80*/("""</option>
                          </select>
                          <select type="button" class="btn" style="float: left;width: 45%; height: 35px;margin-left: 5px; margin-top: 5px;background-color: #de2436bf; color: white" id="changeSpeedPlay" onchange="changeSpeedPlay()">
                            <option value="0.5">"""),_display_(/*152.50*/Messages("Tốc độ 0.5")),format.raw/*152.72*/("""</option>
                            <option value="1" selected>"""),_display_(/*153.57*/Messages("Tốc độ 1.0")),format.raw/*153.79*/("""</option>
                            <option value="2">"""),_display_(/*154.48*/Messages("Tốc độ 2.0")),format.raw/*154.70*/("""</option>
                            <option value="5">"""),_display_(/*155.48*/Messages("Tốc độ 5.0")),format.raw/*155.70*/("""</option>
                          </select>
                        </div>
                      </div>
                    </div>

                    <div id="scroll-area-position" class="col-md-12" style="padding: 0; margin-top: 15px;float: left;">
                      <div class="table-responsive">
                        <table class="table mb-0" id="table-map-view" style="background-color: #EAEBEB">
                          <thead id="theadExport" style="color: white; background-color: #858687">
                            <tr>
                              <th class="text-center" style="width: 40px">"""),_display_(/*166.76*/Messages("STT")),format.raw/*166.91*/("""</th>
                              <th style="width: 100px">"""),_display_(/*167.57*/Messages("Vị trí ")),format.raw/*167.76*/("""</th>
                              <th style="width: 100px">"""),_display_(/*168.57*/Messages("Thời gian")),format.raw/*168.78*/("""</th>
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
                            <th>"""),_display_(/*183.34*/Messages("Tổng")),_display_(/*183.51*/Messages(" ")),format.raw/*183.64*/("""</th>
                            <th id="id-sum-stt" style="padding-right: 5px; text-align: right !important;">0</th>
                          </tr>
                        </thead>
                      </table>
                    </div>

                  </div>
                </div>
              </div>

              <a id="menu-toggle" class="move-in"></a>

            </div>
          </div>

          <div id="page-content-wrapper">
            <div id = "map-canvas" class="big-map" style="position: absolute"></div>
          </div>

        </div>
      </div>

    </div>

    """),_display_(/*208.6*/views/*208.11*/.html.Loading()),format.raw/*208.26*/("""
  """),format.raw/*209.3*/("""</body>

  <script src=""""),_display_(/*211.17*/routes/*211.23*/.Assets.versioned("javascripts/jquery/jquery.js")),format.raw/*211.72*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*212.17*/routes/*212.23*/.Assets.versioned("javascripts/jquery/jquery-ui.js")),format.raw/*212.75*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*213.17*/routes/*213.23*/.Assets.versioned("javascripts/jquery/jquery-ui.min.js")),format.raw/*213.79*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*214.17*/routes/*214.23*/.Assets.versioned("javascripts/jquery/jquery-ui-1.12.1.js")),format.raw/*214.82*/("""" type="text/javascript"></script>

  """),_display_(/*216.4*/views/*216.9*/.html.iot.tags.Main_js()),format.raw/*216.33*/("""

  """),format.raw/*218.3*/("""<script src=""""),_display_(/*218.17*/routes/*218.23*/.Assets.versioned("javascripts/jquery/jquery-1.12.4.js")),format.raw/*218.79*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*219.17*/routes/*219.23*/.Assets.versioned("javascripts/plugins/select2/js/select2.min.js")),format.raw/*219.89*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*221.17*/routes/*221.23*/.Assets.versioned("javascripts/bootstrap/bootstrap-datetimepicker.min.js")),format.raw/*221.97*/("""" type="text/javascript"></script>

  <script>
          var projectId = '"""),_display_(/*224.29*/projectId),format.raw/*224.38*/("""';

          $(document).ready(function () """),format.raw/*226.41*/("""{"""),format.raw/*226.42*/("""
            """),format.raw/*227.13*/("""$("#menu-tracking").addClass("mm-active");
            $("#menu-tracking-history").addClass("mm-active");
            $("#menu").metisMenu();

            $('.single-select').select2("""),format.raw/*231.41*/("""{"""),format.raw/*231.42*/("""
              """),format.raw/*232.15*/("""theme: 'bootstrap4',
              width: $(this).data('width') ? $(this).data('width') : $(this).hasClass('w-100') ? '100%' : 'style',
              placeholder: $(this).data('placeholder'),
              allowClear: Boolean($(this).data('allow-clear'))
            """),format.raw/*236.13*/("""}"""),format.raw/*236.14*/(""");

            $('.datetimepicker').datetimepicker("""),format.raw/*238.49*/("""{"""),format.raw/*238.50*/("""
              """),format.raw/*239.15*/("""format:"DD/MM/YYYY HH:mm",
              sideBySide:true,
              icons: """),format.raw/*241.22*/("""{"""),format.raw/*241.23*/("""
                """),format.raw/*242.17*/("""time: "fa fa-clock-o",
                date: "fa fa-calendar",
                up: "fa fa-chevron-up",
                down: "fa fa-chevron-down",
                previous: 'fa fa-chevron-left',
                next: 'fa fa-chevron-right',
                today: 'fa fa-screenshot',
                clear: 'fa fa-trash',
                close: 'fa fa-remove',
              """),format.raw/*251.15*/("""}"""),format.raw/*251.16*/(""",
            """),format.raw/*252.13*/("""}"""),format.raw/*252.14*/(""");
          """),format.raw/*253.11*/("""}"""),format.raw/*253.12*/(""");
  </script>

  <script>
          var initLatLng = new google.maps.LatLng(15.664142, 104.266281);
          var mapOptions = """),format.raw/*258.28*/("""{"""),format.raw/*258.29*/("""
            """),format.raw/*259.13*/("""center: initLatLng,
            zoom: 6,
            zoomControl: true,
            zoomControlOptions: """),format.raw/*262.33*/("""{"""),format.raw/*262.34*/("""
              """),format.raw/*263.15*/("""position: google.maps.ControlPosition.TOP_RIGHT
            """),format.raw/*264.13*/("""}"""),format.raw/*264.14*/(""",
            mapTypeControlOptions: """),format.raw/*265.36*/("""{"""),format.raw/*265.37*/("""
              """),format.raw/*266.15*/("""position: google.maps.ControlPosition.BOTTOM_CENTER
            """),format.raw/*267.13*/("""}"""),format.raw/*267.14*/(""",
            mapTypeControl: false,
            scaleControl: false,
            streetViewControl: false,
            fullscreenControl: true,
            fullscreenControlOptions: """),format.raw/*272.39*/("""{"""),format.raw/*272.40*/("""
              """),format.raw/*273.15*/("""position: google.maps.ControlPosition.RIGHT_BOTTOM
            """),format.raw/*274.13*/("""}"""),format.raw/*274.14*/(""",
            gestureHandling: 'greedy'
          """),format.raw/*276.11*/("""}"""),format.raw/*276.12*/(""";
          var mapHistory = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

          $('.nav-overlay>nav').attr("style", "background-color: rgba(0,0,0,0.5) !important; color: white; position: relative !important;");
          $('#map-canvas').attr("style", "position: absolute;");

          var slideMarkerList = [];
          var markerSlide;
          var delay_playback_max = 2500;
          var delay_playback_min = 250;
          var delay_playback = 2500;
          var effect_playback="linear";
          var drawPlayBackFlag =false;

          var startRacing = """"),_display_(/*290.31*/routes/*290.37*/.Assets.versioned("img/history/startIcon.png")),format.raw/*290.83*/("""";
          var destRacing = """"),_display_(/*291.30*/routes/*291.36*/.Assets.versioned("img/history/endIcon.png")),format.raw/*291.80*/("""";
          var point = """"),_display_(/*292.25*/routes/*292.31*/.Assets.versioned("images/vtag/location1.png")),format.raw/*292.77*/("""";


  </script>
  <script src=""""),_display_(/*296.17*/routes/*296.23*/.Assets.versioned("javascripts/views/solution/tracking/monitorMap/TrackingUtil.js")),format.raw/*296.106*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*298.17*/routes/*298.23*/.Assets.versioned("javascripts/views/solution/tracking/history/jquery.easing.1.3.js")),format.raw/*298.108*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*299.17*/routes/*299.23*/.Assets.versioned("javascripts/views/solution/tracking/history/markerAnimate.js")),format.raw/*299.104*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*300.17*/routes/*300.23*/.Assets.versioned("javascripts/views/solution/tracking/history/SlidingMarker.js")),format.raw/*300.104*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*302.17*/routes/*302.23*/.Assets.versioned("javascripts/views/solution/tracking/history/HistoryMap.js")),format.raw/*302.101*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*303.17*/routes/*303.23*/.Assets.versioned("javascripts/views/solution/tracking/history/HistoryMap-Marker.js")),format.raw/*303.108*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*304.17*/routes/*304.23*/.Assets.versioned("javascripts/views/solution/tracking/history/HistoryMap-Polyline.js")),format.raw/*304.110*/("""" type="text/javascript"></script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/solution/tracking/HistoryMap.scala.html
                  HASH: fe554cc8669cce4ef14a72a9fe2c785bd0062aff
                  MATRIX: 669->1|709->35|1054->67|1170->3220|1187->3228|1576->3625|1591->3631|2078->103|2105->104|2283->256|2326->279|2407->333|2422->339|2479->375|2699->568|2714->574|2803->642|2856->669|2870->674|2916->699|2948->704|3012->741|3031->751|3069->768|3125->797|3140->803|3236->878|3302->917|3317->923|3406->991|3472->1030|3487->1036|3583->1111|3684->1184|3713->1185|3756->1200|4327->1744|4342->1750|4411->1798|4464->1823|4493->1824|4535->1838|4573->1848|4602->1849|4645->1864|5183->2375|5198->2381|5268->2430|5321->2455|5350->2456|5382->2461|5513->2566|5527->2571|5591->2614|5626->2623|5640->2628|5695->2662|5731->2671|6171->3083|6234->3124|6357->3602|6408->4088|6459->4110|6744->4366|6808->4407|6839->4408|7051->4591|7082->4599|7113->4600|7471->4929|7533->4968|7743->5149|7772->5155|8086->5441|8145->5477|8410->5714|8480->5762|9157->6411|9220->6451|9276->6478|9641->6815|9704->6855|9760->6882|10044->7137|10108->7178|10185->7227|10248->7268|10333->7325|10385->7355|10470->7412|10522->7442|10607->7499|10659->7529|10745->7587|10798->7618|10884->7676|10937->7707|11292->8034|11336->8056|11430->8122|11474->8144|11559->8201|11603->8223|11688->8280|11732->8302|12379->8921|12416->8936|12506->8998|12547->9017|12637->9079|12680->9100|13258->9650|13296->9667|13331->9680|13955->10277|13970->10282|14007->10297|14038->10300|14091->10325|14107->10331|14178->10380|14257->10431|14273->10437|14347->10489|14426->10540|14442->10546|14520->10602|14599->10653|14615->10659|14696->10718|14762->10757|14776->10762|14822->10786|14854->10790|14896->10804|14912->10810|14990->10866|15069->10917|15085->10923|15173->10989|15253->11041|15269->11047|15365->11121|15468->11196|15499->11205|15572->11249|15602->11250|15644->11263|15856->11446|15886->11447|15930->11462|16226->11729|16256->11730|16337->11782|16367->11783|16411->11798|16519->11877|16549->11878|16595->11895|16998->12269|17028->12270|17071->12284|17101->12285|17143->12298|17173->12299|17330->12427|17360->12428|17402->12441|17535->12545|17565->12546|17609->12561|17698->12621|17728->12622|17794->12659|17824->12660|17868->12675|17961->12739|17991->12740|18203->12923|18233->12924|18277->12939|18369->13002|18399->13003|18478->13053|18508->13054|19136->13654|19152->13660|19220->13706|19280->13738|19296->13744|19362->13788|19417->13815|19433->13821|19501->13867|19562->13900|19578->13906|19684->13989|19764->14041|19780->14047|19888->14132|19967->14183|19983->14189|20087->14270|20166->14321|20182->14327|20286->14408|20366->14460|20382->14466|20483->14544|20562->14595|20578->14601|20686->14686|20765->14737|20781->14743|20891->14830
                  LINES: 24->1|25->2|30->3|34->84|34->84|42->94|42->94|52->3|53->4|58->9|58->9|59->10|59->10|59->10|64->15|64->15|64->15|66->17|66->17|66->17|67->18|67->18|67->18|67->18|68->19|68->19|68->19|70->21|70->21|70->21|71->22|71->22|71->22|75->26|75->26|76->27|91->42|91->42|91->42|92->43|92->43|94->45|94->45|94->45|95->46|109->60|109->60|109->60|110->61|110->61|111->62|116->67|116->67|116->67|118->69|118->69|118->69|121->72|129->80|129->80|133->92|135->103|137->105|140->108|140->108|140->108|142->110|142->110|142->110|148->116|148->116|150->118|150->118|156->124|156->124|159->127|159->127|170->138|170->138|171->139|173->141|173->141|174->142|175->143|175->143|176->144|176->144|177->145|177->145|178->146|178->146|179->147|179->147|180->148|180->148|181->149|181->149|184->152|184->152|185->153|185->153|186->154|186->154|187->155|187->155|198->166|198->166|199->167|199->167|200->168|200->168|215->183|215->183|215->183|240->208|240->208|240->208|241->209|243->211|243->211|243->211|244->212|244->212|244->212|245->213|245->213|245->213|246->214|246->214|246->214|248->216|248->216|248->216|250->218|250->218|250->218|250->218|251->219|251->219|251->219|253->221|253->221|253->221|256->224|256->224|258->226|258->226|259->227|263->231|263->231|264->232|268->236|268->236|270->238|270->238|271->239|273->241|273->241|274->242|283->251|283->251|284->252|284->252|285->253|285->253|290->258|290->258|291->259|294->262|294->262|295->263|296->264|296->264|297->265|297->265|298->266|299->267|299->267|304->272|304->272|305->273|306->274|306->274|308->276|308->276|322->290|322->290|322->290|323->291|323->291|323->291|324->292|324->292|324->292|328->296|328->296|328->296|330->298|330->298|330->298|331->299|331->299|331->299|332->300|332->300|332->300|334->302|334->302|334->302|335->303|335->303|335->303|336->304|336->304|336->304
                  -- GENERATED --
              */
          