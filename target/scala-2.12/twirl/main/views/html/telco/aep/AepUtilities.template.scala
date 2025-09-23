
package views.html.telco.aep

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
/*1.2*/import vn.m2m.utils.DateUtil
/*2.2*/import vn.m2m.common.models.User
/*3.2*/import vn.m2m.utils.UserHelper

object AepUtilities extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(currentUser:User, userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.35*/("""
"""),format.raw/*5.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*10.13*/Messages("Tiện ích mở rộng")),format.raw/*10.41*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*11.46*/routes/*11.52*/.Assets.versioned("images/logo.jpg")),format.raw/*11.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*16.6*/views/*16.11*/.html.iot.tags.Main_css()),format.raw/*16.36*/("""

    """),format.raw/*18.96*/("""
    """),format.raw/*19.5*/("""<link href='"""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*19.73*/("""' type='text/css'>
    <link href=""""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*20.99*/("""" rel="stylesheet">
    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*21.139*/("""" rel="stylesheet" >
    <link href=""""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*22.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*23.18*/routes/*23.24*/.Assets.versioned("assets/plugins/input-tags/css/tagsinput.css")),format.raw/*23.88*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*24.18*/routes/*24.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*24.78*/("""" rel="stylesheet" />
    <script type="text/javascript" src=""""),_display_(/*25.42*/UserHelper/*25.52*/.linkGoogleMapApi),format.raw/*25.69*/(""""></script>

    <link rel="stylesheet" type="text/css" href=""""),_display_(/*27.51*/routes/*27.57*/.Assets.versioned("stylesheets/views/telco/aep/codemirror.min.css")),format.raw/*27.124*/(""""/>
    <link rel="stylesheet" type="text/css" href=""""),_display_(/*28.51*/routes/*28.57*/.Assets.versioned("stylesheets/views/telco/aep/abbott.min.css")),format.raw/*28.120*/(""""/>
    <script src=""""),_display_(/*29.19*/routes/*29.25*/.Assets.versioned("javascripts/views/aep/codemirror.min.js")),format.raw/*29.85*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*30.19*/routes/*30.25*/.Assets.versioned("javascripts/views/aep/perl.min.js")),format.raw/*30.79*/("""" type="text/javascript"></script>
    <link href=""""),_display_(/*31.18*/routes/*31.24*/.Assets.versioned("stylesheets/views/telco/aep/aepUtilities.css")),format.raw/*31.89*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*35.6*/views/*35.11*/.html.telco.Menu(currentUser, "", userId)),format.raw/*35.52*/("""

    """),_display_(/*37.6*/views/*37.11*/.html.telco.Header(currentUser)),format.raw/*37.42*/("""

    """),format.raw/*39.5*/("""<div class="page-wrapper">
      <div class="page-content">
        <span class="content-card-0" id="title-aep">"""),_display_(/*41.54*/Messages("Dịch vụ mở rộng")),format.raw/*41.81*/("""</span><br>
        <div class="row mt-4" id="choose-aep">
          <div class="col-md-3">
            <div class="card" style="padding: 24px; height: 100%;">
              <div class="row mb-3">
                <div class="col-md-9">
                  <span class="content-card-1">"""),_display_(/*47.49*/Messages("Quản lý thiết bị")),format.raw/*47.77*/("""</span><br>
                  <span class="content-card-2">"""),_display_(/*48.49*/Messages("Mô tả ngắn")),format.raw/*48.71*/("""</span>
                </div>
                <div class="col-md-3">
                  <img src=""""),_display_(/*51.30*/routes/*51.36*/.Assets.versioned("images/AEP/device.svg")),format.raw/*51.78*/("""" width="100%">
                </div>
              </div>
              <div class="row mx-auto text-center div-exp">
                <button type="button" class="btn btn-exp" onclick="showTabDevice()">"""),_display_(/*55.86*/Messages("Trải nghiệm ngay")),format.raw/*55.114*/("""</button>
              </div>
            </div>
          </div>

          <div class="col-md-3">
            <div class="card" style="padding: 24px; height: 100%;">
              <div class="row mb-3">
                <div class="col-md-9">
                  <span class="content-card-1">"""),_display_(/*64.49*/Messages("Định vị")),format.raw/*64.68*/("""</span><br>
                  <span class="content-card-2">"""),_display_(/*65.49*/Messages("Cung cấp thông tin vị trí của thiết bị, thuê bao thông qua Cell ID và WiFI-Cell.")),format.raw/*65.141*/("""</span>
                </div>
                <div class="col-md-3">
                  <img src=""""),_display_(/*68.30*/routes/*68.36*/.Assets.versioned("images/AEP/gps.svg")),format.raw/*68.75*/("""" width="100%">
                </div>
              </div>
              <div class="row mx-auto text-center div-exp">
                <button type="button" class="btn btn-exp" onclick="showEditorGps()">"""),_display_(/*72.86*/Messages("Trải nghiệm ngay")),format.raw/*72.114*/("""</button>
              </div>
            </div>
          </div>

          <div class="col-md-3">
            <div class="card" style="padding: 24px; height: 100%;">
              <div class="row mb-3">
                <div class="col-md-9">
                  <span class="content-card-1">"""),_display_(/*81.49*/Messages("Thời tiết")),format.raw/*81.70*/("""</span><br>
                  <span class="content-card-2">"""),_display_(/*82.49*/Messages("Cung cấp các thông tin về trạng thái thời tiết, nhiệt độ, độ ẩm, tốc độ gió,…theo đơn vị hành chính cấp tỉnh.")),format.raw/*82.170*/("""</span>
                </div>
                <div class="col-md-3">
                  <img src=""""),_display_(/*85.30*/routes/*85.36*/.Assets.versioned("images/AEP/weather.svg")),format.raw/*85.79*/("""" width="100%">
                </div>
              </div>
              <div class="row mx-auto text-center div-exp">
                <button type="button" class="btn btn-exp" onclick="showEditorWeather()">"""),_display_(/*89.90*/Messages("Trải nghiệm ngay")),format.raw/*89.118*/("""</button>
              </div>
            </div>
          </div>

          <div class="col-md-3">
            <div class="card" style="padding: 24px; height: 100%;">
              <div class="row mb-3">
                <div class="col-md-9">
                  <span class="content-card-1">"""),_display_(/*98.49*/Messages("Dịch vụ Video")),format.raw/*98.74*/("""</span><br>
                  <span class="content-card-2">"""),_display_(/*99.49*/Messages("Cung cấp các giải pháp camera cho hộ gia đình, nhà xưởng, văn phòng, giao thông đô thị,…với đa dạng mức chi phí từ bình dân đến cao cấp.")),format.raw/*99.197*/("""</span>
                </div>
                <div class="col-md-3">
                  <img src=""""),_display_(/*102.30*/routes/*102.36*/.Assets.versioned("images/AEP/video.svg")),format.raw/*102.77*/("""" width="100%">
                </div>
              </div>
              <div class="row mx-auto text-center div-exp">
                <button type="button" class="btn btn-exp" style="background-color: #aaa">"""),_display_(/*106.91*/Messages("Đang phát triển")),format.raw/*106.118*/("""</button>
              </div>
            </div>
          </div>
        </div>

        """),_display_(/*112.10*/views/*112.15*/.html.telco.aep.AepUtilities_device()),format.raw/*112.52*/("""
        """),_display_(/*113.10*/views/*113.15*/.html.telco.aep.AepUtilities_device_project()),format.raw/*113.60*/("""
        """),_display_(/*114.10*/views/*114.15*/.html.telco.aep.AepUtilities_device_flow()),format.raw/*114.57*/("""
        """),_display_(/*115.10*/views/*115.15*/.html.telco.aep.AepUtilities_device_template()),format.raw/*115.61*/("""
        """),_display_(/*116.10*/views/*116.15*/.html.telco.aep.AepUtilities_device_device()),format.raw/*116.59*/("""

        """),_display_(/*118.10*/views/*118.15*/.html.telco.aep.AepUtilities_gps()),format.raw/*118.49*/("""

        """),_display_(/*120.10*/views/*120.15*/.html.telco.aep.AepUtilities_weather()),format.raw/*120.53*/("""

      """),format.raw/*122.7*/("""</div>

      """),_display_(/*124.8*/views/*124.13*/.html.telco.Loading()),format.raw/*124.34*/("""

    """),format.raw/*126.5*/("""</div>
      <!--  END OF PAPER WRAP -->

    """),_display_(/*129.6*/views/*129.11*/.html.telco.mainJs()),format.raw/*129.31*/("""

    """),format.raw/*131.5*/("""<script>
            var imgDefault = '"""),_display_(/*132.32*/routes/*132.38*/.Assets.versioned("images/market/default.png")),format.raw/*132.84*/("""';
            var userId = '"""),_display_(/*133.28*/userId),format.raw/*133.34*/("""';

            $(document).ready(function () """),format.raw/*135.43*/("""{"""),format.raw/*135.44*/("""
              """),format.raw/*136.15*/("""$("#menu-aep").addClass("mm-active");
              $("#menu").metisMenu();

              $('.datetimepicker').bootstrapMaterialDatePicker("""),format.raw/*139.64*/("""{"""),format.raw/*139.65*/("""
                """),format.raw/*140.17*/("""format: 'DD/MM/YYYY',
                time: false
              """),format.raw/*142.15*/("""}"""),format.raw/*142.16*/(""");
            """),format.raw/*143.13*/("""}"""),format.raw/*143.14*/(""")
    </script>
    <script>
            var initLatLng = new google.maps.LatLng(20.972510, 105.745253);
            var mapOptions = """),format.raw/*147.30*/("""{"""),format.raw/*147.31*/("""
              """),format.raw/*148.15*/("""center: initLatLng,
              zoom: 7,
              zoomControl: true,
              zoomControlOptions: """),format.raw/*151.35*/("""{"""),format.raw/*151.36*/("""
                """),format.raw/*152.17*/("""position: google.maps.ControlPosition.TOP_RIGHT
              """),format.raw/*153.15*/("""}"""),format.raw/*153.16*/(""",
              mapTypeControlOptions: """),format.raw/*154.38*/("""{"""),format.raw/*154.39*/("""
                """),format.raw/*155.17*/("""position: google.maps.ControlPosition.BOTTOM_CENTER
              """),format.raw/*156.15*/("""}"""),format.raw/*156.16*/(""",
              mapTypeControl: false,
              scaleControl: false,
              streetViewControl: false,
              fullscreenControl: true,
              fullscreenControlOptions: """),format.raw/*161.41*/("""{"""),format.raw/*161.42*/("""
                """),format.raw/*162.17*/("""position: google.maps.ControlPosition.RIGHT_BOTTOM
              """),format.raw/*163.15*/("""}"""),format.raw/*163.16*/(""",
              gestureHandling: 'greedy'
            """),format.raw/*165.13*/("""}"""),format.raw/*165.14*/(""";
            var mapPosition = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
            $('#map-canvas').attr("style", "position: relative; width: 100%; height: 100%;");

            var point = """"),_display_(/*169.27*/routes/*169.33*/.Assets.versioned("img/image_signal/blueCar.png")),format.raw/*169.82*/("""";
    </script>
    <script src=""""),_display_(/*171.19*/routes/*171.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*171.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*172.19*/routes/*172.25*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*172.85*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*174.19*/routes/*174.25*/.Assets.versioned("javascripts/views/telco/subs/subscriber_listProductOffering.js")),format.raw/*174.108*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*175.19*/routes/*175.25*/.Assets.versioned("javascripts/views/aep/AepUtilities.js")),format.raw/*175.83*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*176.19*/routes/*176.25*/.Assets.versioned("javascripts/views/aep/AepUtilities_weather.js")),format.raw/*176.91*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*177.19*/routes/*177.25*/.Assets.versioned("javascripts/views/aep/AepUtilities_gps.js")),format.raw/*177.87*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*178.19*/routes/*178.25*/.Assets.versioned("javascripts/views/aep/AepUtilities_subs.js")),format.raw/*178.88*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*179.19*/routes/*179.25*/.Assets.versioned("javascripts/views/aep/AepUtilities_subs_createDevice.js")),format.raw/*179.101*/("""" type="text/javascript"></script>

  </body>
</html>
"""))
      }
    }
  }

  def render(currentUser:User,userId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,userId)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,userId) => apply(currentUser,userId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:50 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/aep/AepUtilities.scala.html
                  HASH: de49b6ec449ea41aaa187c221f01be458fe693cc
                  MATRIX: 661->1|697->31|737->65|1084->97|1212->130|1239->131|1408->273|1457->301|1538->355|1553->361|1610->397|1817->578|1831->583|1877->608|1911->705|1943->710|1983->723|1998->729|2068->778|2131->814|2146->820|2242->895|2306->932|2321->938|2458->1053|2523->1091|2538->1097|2613->1151|2679->1190|2694->1196|2779->1260|2845->1299|2860->1305|2935->1359|3025->1422|3044->1432|3082->1449|3172->1512|3187->1518|3276->1585|3357->1639|3372->1645|3457->1708|3506->1730|3521->1736|3602->1796|3682->1849|3697->1855|3772->1909|3851->1961|3866->1967|3952->2032|4042->2096|4056->2101|4118->2142|4151->2149|4165->2154|4217->2185|4250->2191|4390->2304|4438->2331|4749->2615|4798->2643|4885->2703|4928->2725|5054->2824|5069->2830|5132->2872|5364->3077|5414->3105|5734->3398|5774->3417|5861->3477|5975->3569|6101->3668|6116->3674|6176->3713|6408->3918|6458->3946|6778->4239|6820->4260|6907->4320|7050->4441|7176->4540|7191->4546|7255->4589|7491->4798|7541->4826|7861->5119|7907->5144|7994->5204|8164->5352|8291->5451|8307->5457|8370->5498|8608->5708|8658->5735|8778->5827|8793->5832|8852->5869|8890->5879|8905->5884|8972->5929|9010->5939|9025->5944|9089->5986|9127->5996|9142->6001|9210->6047|9248->6057|9263->6062|9329->6106|9368->6117|9383->6122|9439->6156|9478->6167|9493->6172|9553->6210|9589->6218|9631->6233|9646->6238|9689->6259|9723->6265|9797->6312|9812->6317|9854->6337|9888->6343|9956->6383|9972->6389|10040->6435|10098->6465|10126->6471|10201->6517|10231->6518|10275->6533|10444->6673|10474->6674|10520->6691|10613->6755|10643->6756|10687->6771|10717->6772|10880->6906|10910->6907|10954->6922|11093->7032|11123->7033|11169->7050|11260->7112|11290->7113|11358->7152|11388->7153|11434->7170|11529->7236|11559->7237|11781->7430|11811->7431|11857->7448|11951->7513|11981->7514|12064->7568|12094->7569|12347->7794|12363->7800|12434->7849|12497->7884|12513->7890|12594->7949|12675->8002|12691->8008|12773->8068|12855->8122|12871->8128|12977->8211|13058->8264|13074->8270|13154->8328|13235->8381|13251->8387|13339->8453|13420->8506|13436->8512|13520->8574|13601->8627|13617->8633|13702->8696|13783->8749|13799->8755|13898->8831
                  LINES: 24->1|25->2|26->3|31->4|36->4|37->5|42->10|42->10|43->11|43->11|43->11|48->16|48->16|48->16|50->18|51->19|51->19|51->19|51->19|52->20|52->20|52->20|53->21|53->21|53->21|54->22|54->22|54->22|55->23|55->23|55->23|56->24|56->24|56->24|57->25|57->25|57->25|59->27|59->27|59->27|60->28|60->28|60->28|61->29|61->29|61->29|62->30|62->30|62->30|63->31|63->31|63->31|67->35|67->35|67->35|69->37|69->37|69->37|71->39|73->41|73->41|79->47|79->47|80->48|80->48|83->51|83->51|83->51|87->55|87->55|96->64|96->64|97->65|97->65|100->68|100->68|100->68|104->72|104->72|113->81|113->81|114->82|114->82|117->85|117->85|117->85|121->89|121->89|130->98|130->98|131->99|131->99|134->102|134->102|134->102|138->106|138->106|144->112|144->112|144->112|145->113|145->113|145->113|146->114|146->114|146->114|147->115|147->115|147->115|148->116|148->116|148->116|150->118|150->118|150->118|152->120|152->120|152->120|154->122|156->124|156->124|156->124|158->126|161->129|161->129|161->129|163->131|164->132|164->132|164->132|165->133|165->133|167->135|167->135|168->136|171->139|171->139|172->140|174->142|174->142|175->143|175->143|179->147|179->147|180->148|183->151|183->151|184->152|185->153|185->153|186->154|186->154|187->155|188->156|188->156|193->161|193->161|194->162|195->163|195->163|197->165|197->165|201->169|201->169|201->169|203->171|203->171|203->171|204->172|204->172|204->172|206->174|206->174|206->174|207->175|207->175|207->175|208->176|208->176|208->176|209->177|209->177|209->177|210->178|210->178|210->178|211->179|211->179|211->179
                  -- GENERATED --
              */
          