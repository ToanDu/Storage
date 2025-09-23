
package views.html.iot.DeviceIot.variable

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
/*4.2*/import vn.m2m.iot.models.DeviceVariable
/*5.2*/import vn.m2m.utils.UserHelper

object DeviceIotVariable extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template7[User,String,List[DeviceVariable],String,Double,Double,Double,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(currentUser:User, projectId:String, deviceVariableList: List[DeviceVariable], deviceId: String, lat: Double, long: Double, battery: Double):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*6.142*/("""
"""),format.raw/*7.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*12.13*/Messages("Variables Of Device")),format.raw/*12.44*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*13.46*/routes/*13.52*/.Assets.versioned("images/logo.jpg")),format.raw/*13.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*18.6*/views/*18.11*/.html.iot.tags.Main_css()),format.raw/*18.36*/("""

    """),format.raw/*20.5*/("""<link href=""""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("stylesheets/views/scrollListItem.css")),format.raw/*20.81*/("""" rel="stylesheet"/>
    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*21.78*/("""" rel="stylesheet" />
      <script type="text/javascript" src=""""),_display_(/*22.44*/UserHelper/*22.54*/.linkGoogleMapApi),format.raw/*22.71*/(""""> </script>
      <style>
              html, body, #map-canvas """),format.raw/*24.39*/("""{"""),format.raw/*24.40*/("""
                  """),format.raw/*25.19*/("""height : 350px ;
                  width: 100%;
                  padding : 0 ;
              """),format.raw/*28.15*/("""}"""),format.raw/*28.16*/("""

              """),format.raw/*30.15*/("""#paper-middle"""),format.raw/*30.28*/("""{"""),format.raw/*30.29*/("""
                  """),format.raw/*31.19*/("""padding :0px;
                  height: 50%;
              """),format.raw/*33.15*/("""}"""),format.raw/*33.16*/("""
      """),format.raw/*34.7*/("""</style>
      <link href=""""),_display_(/*35.20*/routes/*35.26*/.Assets.versioned("stylesheets/views/variable/variable.css")),format.raw/*35.86*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*39.6*/views/*39.11*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*39.54*/("""

    """),_display_(/*41.6*/views/*41.11*/.html.iot.tags.Header(currentUser)),format.raw/*41.45*/("""

    """),format.raw/*43.5*/("""<div class="page-wrapper">
      <div class="page-content">

          <!--breadcrumb-->
        <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3 ">
          <div class="breadcrumb-title pe-3">"""),_display_(/*48.47*/Messages("manage.group.device")),format.raw/*48.78*/("""</div>
          <div class="ps-3">
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb mb-0 p-0">
                <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt "></i></a>
                </li>
                <li class="breadcrumb-item active " aria-current="page">"""),_display_(/*54.74*/Messages("device.variable.title")),format.raw/*54.107*/("""</li>
              </ol>
            </nav>
          </div>
          <div class="ms-auto">

          </div>
        </div>
          <!--end breadcrumb-->

        <div class="card" style="height: 80vh;">
          <div class="card-header card-header-primary card-header-icon">
            <div class="toolbar" style="float: right">
                <button class="btn btn-success" onclick="getConfigOfDeviceIot()" data-bs-toggle="modal" data-bs-target="#configConfirmModal">
                    <i class="bx bx-world" aria-hidden="true"></i> """),_display_(/*68.69*/Messages("device.variable.configGps")),format.raw/*68.106*/("""
                """),format.raw/*69.17*/("""</button>
                <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addConfirmModal">
                    <i class="bx bx-plus" aria-hidden="true"></i> """),_display_(/*71.68*/Messages("device.variable.addNew")),format.raw/*71.102*/("""
                """),format.raw/*72.17*/("""</button>
            </div>
          </div>

          <div class="card-body" style="overflow-x: auto; background-color: #ff00009c;">
              <div class="col-md-12">
                  <div class="row">

                      <div class="col-md-4">
                          <div class="row row-cols-1" style="height: 100%">
                              """),_display_(/*82.32*/views/*82.37*/.html.iot.DeviceIot.variable.DeviceIotVariable_infoDevice(deviceId)),format.raw/*82.104*/("""
                          """),format.raw/*83.27*/("""</div>
                      </div>

                      <div class="col-md-8" id="listItem">
                          <div class="product-list p-3 mb-3" style="height: 69vh;">
                              """),_display_(/*88.32*/for((variable: DeviceVariable)<- deviceVariableList) yield /*88.84*/ {_display_(Seq[Any](format.raw/*88.86*/("""
                                  """),format.raw/*89.35*/("""<div class="row border mx-0 mb-3 py-2 radius-10 cursor-pointer">
                                      <div class="col-sm-6"
                                      onclick="setEditVariable('"""),_display_(/*91.66*/variable/*91.74*/.getId),format.raw/*91.80*/("""','"""),_display_(/*91.84*/variable/*91.92*/.getName),format.raw/*91.100*/("""','"""),_display_(/*91.104*/variable/*91.112*/.getType),format.raw/*91.120*/("""','"""),_display_(/*91.124*/variable/*91.132*/.getValue),format.raw/*91.141*/("""')" data-bs-toggle="modal" data-bs-target="#editConfirmModal">
                                          <div class="d-flex align-items-center">
                                              <div class="ms-2">
                                                  <h6 class="mb-1 text-white">"""),_display_(/*94.80*/variable/*94.88*/.getName),format.raw/*94.96*/("""</h6>
                                                  <p class="mb-0 text-white">"""),_display_(/*95.79*/variable/*95.87*/.getId),format.raw/*95.93*/("""</p>
                                              </div>
                                          </div>
                                      </div>
                                      <div class="col-sm"
                                      onclick="setEditVariable('"""),_display_(/*100.66*/variable/*100.74*/.getId),format.raw/*100.80*/("""','"""),_display_(/*100.84*/variable/*100.92*/.getName),format.raw/*100.100*/("""','"""),_display_(/*100.104*/variable/*100.112*/.getType),format.raw/*100.120*/("""','"""),_display_(/*100.124*/variable/*100.132*/.getValue),format.raw/*100.141*/("""')" data-bs-toggle="modal" data-bs-target="#editConfirmModal">
                                          <h6 class="mb-1 text-white">"""),_display_(/*101.72*/variable/*101.80*/.getValue),format.raw/*101.89*/("""</h6>
                                          <p class="mb-0 text-white">"""),_display_(/*102.71*/variable/*102.79*/.getType),format.raw/*102.87*/("""</p>
                                      </div>
                                      <div class="col-sm" onclick="showChartOfVariable('"""),_display_(/*104.90*/variable/*104.98*/.getId),format.raw/*104.104*/("""','"""),_display_(/*104.108*/variable/*104.116*/.getName),format.raw/*104.124*/("""')">
                                          <div id="chart"""),_display_(/*105.58*/variable/*105.66*/.getStt),format.raw/*105.73*/(""""></div>
                                      </div>
                                  </div>
                              """)))}),format.raw/*108.32*/("""
                          """),format.raw/*109.27*/("""</div>
                      </div>

                  </div>
              </div>
          </div>

            """),_display_(/*116.14*/views/*116.19*/.html.iot.DeviceIot.variable.DeviceIotVariable_add()),format.raw/*116.71*/("""
            """),_display_(/*117.14*/views/*117.19*/.html.iot.DeviceIot.variable.DeviceIotVariable_editDel()),format.raw/*117.75*/("""
            """),_display_(/*118.14*/views/*118.19*/.html.iot.DeviceIot.variable.DeviceIotVariable_configMap(deviceId, deviceVariableList)),format.raw/*118.105*/("""
            """),_display_(/*119.14*/views/*119.19*/.html.iot.DeviceIot.variable.DeviceIotVariable_chart()),format.raw/*119.73*/("""

        """),format.raw/*121.9*/("""</div>
      </div>

      """),_display_(/*124.8*/views/*124.13*/.html.Loading()),format.raw/*124.28*/("""

    """),format.raw/*126.5*/("""</div>
      <!--  END OF PAPER WRAP -->

  </body>

    """),_display_(/*131.6*/views/*131.11*/.html.iot.tags.Main_js()),format.raw/*131.35*/("""

    """),format.raw/*133.5*/("""<script src=""""),_display_(/*133.19*/routes/*133.25*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*133.79*/(""""></script>
        <!--plugins-->
    <script src=""""),_display_(/*135.19*/routes/*135.25*/.Assets.versioned("assets/plugins/simplebar/js/simplebar.min.js")),format.raw/*135.90*/(""""></script>
    <script src=""""),_display_(/*136.19*/routes/*136.25*/.Assets.versioned("assets/plugins/metismenu/js/metisMenu.min.js")),format.raw/*136.90*/(""""></script>
    <script src=""""),_display_(/*137.19*/routes/*137.25*/.Assets.versioned("assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js")),format.raw/*137.102*/(""""></script>
    <script>
        var lenghtListVar = """),_display_(/*139.30*/deviceVariableList/*139.48*/.size()),format.raw/*139.55*/(""";
        console.log(lenghtListVar);

        var deviceId = '"""),_display_(/*142.26*/deviceId),format.raw/*142.34*/("""';

            $(document).ready(function () """),format.raw/*144.43*/("""{"""),format.raw/*144.44*/("""
                """),format.raw/*145.17*/("""$("#menu-device").addClass("mm-active");
                $("#menu").metisMenu();
            """),format.raw/*147.13*/("""}"""),format.raw/*147.14*/(""")
    </script>

    <script src=""""),_display_(/*150.19*/routes/*150.25*/.Assets.versioned("javascripts/SearchJs.js")),format.raw/*150.69*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*152.19*/routes/*152.25*/.Assets.versioned("assets/plugins/apexcharts-bundle/js/apexcharts.min.js")),format.raw/*152.99*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*154.19*/routes/*154.25*/.Assets.versioned("javascripts/views/device/variable/Variable.js")),format.raw/*154.91*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*155.19*/routes/*155.25*/.Assets.versioned("javascripts/views/device/variable/Variable_add.js")),format.raw/*155.95*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*156.19*/routes/*156.25*/.Assets.versioned("javascripts/views/device/variable/Variable_editDel.js")),format.raw/*156.99*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*158.19*/routes/*158.25*/.Assets.versioned("javascripts/views/device/variable/Variable_map.js")),format.raw/*158.95*/("""" type="text/javascript"></script>
    <script>
            var initLatLng = new google.maps.LatLng(21.025703, 105.832758);
            var mapOptions = """),format.raw/*161.30*/("""{"""),format.raw/*161.31*/("""
                """),format.raw/*162.17*/("""center: initLatLng,
                zoom: 12,
                zoomControl: true,
                zoomControlOptions: """),format.raw/*165.37*/("""{"""),format.raw/*165.38*/("""
                    """),format.raw/*166.21*/("""position: google.maps.ControlPosition.RIGHT_BOTTOM
                """),format.raw/*167.17*/("""}"""),format.raw/*167.18*/(""",
                mapTypeControlOptions: """),format.raw/*168.40*/("""{"""),format.raw/*168.41*/("""
                    """),format.raw/*169.21*/("""position: google.maps.ControlPosition.TOP_RIGHT
                """),format.raw/*170.17*/("""}"""),format.raw/*170.18*/(""",
                scaleControl: true,
                streetViewControl: false,
                fullscreenControl: true,
                fullscreenControlOptions: """),format.raw/*174.43*/("""{"""),format.raw/*174.44*/("""
                    """),format.raw/*175.21*/("""position: google.maps.ControlPosition.RIGHT_BOTTOM
                """),format.raw/*176.17*/("""}"""),format.raw/*176.18*/(""",
                gestureHandling: 'greedy'
            """),format.raw/*178.13*/("""}"""),format.raw/*178.14*/(""";
            var mapPosition = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

            console.log('"""),_display_(/*181.27*/lat),format.raw/*181.30*/("""', '"""),_display_(/*181.35*/long),format.raw/*181.39*/("""');
            if('"""),_display_(/*182.18*/lat),format.raw/*182.21*/("""' > 0 && '"""),_display_(/*182.32*/long),format.raw/*182.36*/("""' > 0)"""),format.raw/*182.42*/("""{"""),format.raw/*182.43*/("""
                """),format.raw/*183.17*/("""addMarkerMap('"""),_display_(/*183.32*/lat),format.raw/*183.35*/("""', '"""),_display_(/*183.40*/long),format.raw/*183.44*/("""', '"""),_display_(/*183.49*/battery),format.raw/*183.56*/("""', '"""),_display_(/*183.61*/deviceId),format.raw/*183.69*/("""');
            """),format.raw/*184.13*/("""}"""),format.raw/*184.14*/("""

            """),format.raw/*186.13*/("""var device_vtag = """"),_display_(/*186.33*/routes/*186.39*/.Assets.versioned("images/dashboard/marker.png")),format.raw/*186.87*/("""";

            var circleSignal_run = """"),_display_(/*188.38*/routes/*188.44*/.Assets.versioned("images/signal/greenCircle.gif")),format.raw/*188.94*/("""";
            var circleSignal_parking = """"),_display_(/*189.42*/routes/*189.48*/.Assets.versioned("images/signal/blueCircle.gif")),format.raw/*189.97*/("""";
            var circleSignal_lost_Gps = """"),_display_(/*190.43*/routes/*190.49*/.Assets.versioned("images/signal/yellowCircle.gif")),format.raw/*190.100*/("""";
            var circleSignal_lost_connect = """"),_display_(/*191.47*/routes/*191.53*/.Assets.versioned("images/signal/grayCircle.gif")),format.raw/*191.102*/("""";
            var circleSignal_alarm = """"),_display_(/*192.40*/routes/*192.46*/.Assets.versioned("images/signal/redCircle.gif")),format.raw/*192.94*/("""";
    </script>

    <script src=""""),_display_(/*195.19*/routes/*195.25*/.Assets.versioned("assets/plugins/apexcharts-bundle/js/apexcharts.min.js")),format.raw/*195.99*/(""""></script>
    <script src=""""),_display_(/*196.19*/routes/*196.25*/.Assets.versioned("assets/plugins/chartjs/js/Chart.min.js")),format.raw/*196.84*/(""""></script>

    <script src=""""),_display_(/*198.19*/routes/*198.25*/.Assets.versioned("javascripts/views/device/variable/Variable_chart.js")),format.raw/*198.97*/("""" type="text/javascript"></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,projectId:String,deviceVariableList:List[DeviceVariable],deviceId:String,lat:Double,long:Double,battery:Double): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,projectId,deviceVariableList,deviceId,lat,long,battery)

  def f:((User,String,List[DeviceVariable],String,Double,Double,Double) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,projectId,deviceVariableList,deviceId,lat,long,battery) => apply(currentUser,projectId,deviceVariableList,deviceId,lat,long,battery)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:44 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/DeviceIot/variable/DeviceIotVariable.scala.html
                  HASH: 5b1b8138041ee00bd3ff02d403b2cb1ab395cb95
                  MATRIX: 674->1|697->18|733->48|773->82|820->123|1221->155|1457->295|1484->296|1653->438|1705->469|1786->523|1801->529|1858->565|2065->746|2079->751|2125->776|2158->782|2198->795|2213->801|2291->858|2356->896|2371->902|2446->956|2538->1021|2557->1031|2595->1048|2688->1113|2717->1114|2764->1133|2886->1227|2915->1228|2959->1244|3000->1257|3029->1258|3076->1277|3163->1336|3192->1337|3226->1344|3281->1372|3296->1378|3377->1438|3467->1502|3481->1507|3545->1550|3578->1557|3592->1562|3647->1596|3680->1602|3922->1817|3974->1848|4324->2171|4379->2204|4953->2751|5012->2788|5057->2805|5267->2988|5323->3022|5368->3039|5758->3402|5772->3407|5861->3474|5916->3501|6154->3712|6222->3764|6262->3766|6325->3801|6542->3991|6559->3999|6586->4005|6617->4009|6634->4017|6664->4025|6696->4029|6714->4037|6744->4045|6776->4049|6794->4057|6825->4066|7141->4355|7158->4363|7187->4371|7298->4455|7315->4463|7342->4469|7645->4744|7663->4752|7691->4758|7723->4762|7741->4770|7772->4778|7805->4782|7824->4790|7855->4798|7888->4802|7907->4810|7939->4819|8101->4953|8119->4961|8150->4970|8254->5046|8272->5054|8302->5062|8469->5201|8487->5209|8516->5215|8549->5219|8568->5227|8599->5235|8689->5297|8707->5305|8736->5312|8894->5438|8950->5465|9092->5579|9107->5584|9181->5636|9223->5650|9238->5655|9316->5711|9358->5725|9373->5730|9482->5816|9524->5830|9539->5835|9615->5889|9653->5899|9708->5927|9723->5932|9760->5947|9794->5953|9879->6011|9894->6016|9940->6040|9974->6046|10016->6060|10032->6066|10108->6120|10189->6173|10205->6179|10292->6244|10350->6274|10366->6280|10453->6345|10511->6375|10527->6381|10627->6458|10709->6512|10737->6530|10766->6537|10858->6601|10888->6609|10963->6655|10993->6656|11039->6673|11161->6766|11191->6767|11254->6802|11270->6808|11336->6852|11418->6906|11434->6912|11530->6986|11612->7040|11628->7046|11716->7112|11797->7165|11813->7171|11905->7241|11986->7294|12002->7300|12098->7374|12180->7428|12196->7434|12288->7504|12470->7657|12500->7658|12546->7675|12692->7792|12722->7793|12772->7814|12868->7881|12898->7882|12968->7923|12998->7924|13048->7945|13141->8009|13171->8010|13363->8173|13393->8174|13443->8195|13539->8262|13569->8263|13654->8319|13684->8320|13843->8451|13868->8454|13901->8459|13927->8463|13976->8484|14001->8487|14040->8498|14066->8502|14101->8508|14131->8509|14177->8526|14220->8541|14245->8544|14278->8549|14304->8553|14337->8558|14366->8565|14399->8570|14429->8578|14474->8594|14504->8595|14547->8609|14595->8629|14611->8635|14681->8683|14750->8724|14766->8730|14838->8780|14910->8824|14926->8830|14997->8879|15070->8924|15086->8930|15160->8981|15237->9030|15253->9036|15325->9085|15395->9127|15411->9133|15481->9181|15545->9217|15561->9223|15657->9297|15715->9327|15731->9333|15812->9392|15871->9423|15887->9429|15981->9501
                  LINES: 24->1|25->2|26->3|27->4|28->5|33->6|38->6|39->7|44->12|44->12|45->13|45->13|45->13|50->18|50->18|50->18|52->20|52->20|52->20|52->20|53->21|53->21|53->21|54->22|54->22|54->22|56->24|56->24|57->25|60->28|60->28|62->30|62->30|62->30|63->31|65->33|65->33|66->34|67->35|67->35|67->35|71->39|71->39|71->39|73->41|73->41|73->41|75->43|80->48|80->48|86->54|86->54|100->68|100->68|101->69|103->71|103->71|104->72|114->82|114->82|114->82|115->83|120->88|120->88|120->88|121->89|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|126->94|126->94|126->94|127->95|127->95|127->95|132->100|132->100|132->100|132->100|132->100|132->100|132->100|132->100|132->100|132->100|132->100|132->100|133->101|133->101|133->101|134->102|134->102|134->102|136->104|136->104|136->104|136->104|136->104|136->104|137->105|137->105|137->105|140->108|141->109|148->116|148->116|148->116|149->117|149->117|149->117|150->118|150->118|150->118|151->119|151->119|151->119|153->121|156->124|156->124|156->124|158->126|163->131|163->131|163->131|165->133|165->133|165->133|165->133|167->135|167->135|167->135|168->136|168->136|168->136|169->137|169->137|169->137|171->139|171->139|171->139|174->142|174->142|176->144|176->144|177->145|179->147|179->147|182->150|182->150|182->150|184->152|184->152|184->152|186->154|186->154|186->154|187->155|187->155|187->155|188->156|188->156|188->156|190->158|190->158|190->158|193->161|193->161|194->162|197->165|197->165|198->166|199->167|199->167|200->168|200->168|201->169|202->170|202->170|206->174|206->174|207->175|208->176|208->176|210->178|210->178|213->181|213->181|213->181|213->181|214->182|214->182|214->182|214->182|214->182|214->182|215->183|215->183|215->183|215->183|215->183|215->183|215->183|215->183|215->183|216->184|216->184|218->186|218->186|218->186|218->186|220->188|220->188|220->188|221->189|221->189|221->189|222->190|222->190|222->190|223->191|223->191|223->191|224->192|224->192|224->192|227->195|227->195|227->195|228->196|228->196|228->196|230->198|230->198|230->198
                  -- GENERATED --
              */
          