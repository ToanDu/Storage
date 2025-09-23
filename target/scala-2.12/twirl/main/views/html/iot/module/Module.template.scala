
package views.html.iot.module

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
/*2.2*/import vn.m2m.common.models.User

object Module extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, projectId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.38*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("Module")),format.raw/*9.31*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*17.78*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*21.6*/views/*21.11*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*21.54*/("""

    """),_display_(/*23.6*/views/*23.11*/.html.iot.tags.Header(currentUser)),format.raw/*23.45*/("""

    """),format.raw/*25.5*/("""<div class="page-wrapper">
      <div class="page-content">

        <div class="row">

          <div class="col-md-3">
            <div class="card">

              <div class="panel" style="height: 90vh;">
                <div class="panel-body" style="overflow-y: auto;  color: #ffffff; height: 85vh;" >
                  <div style="width: 100%; overflow: auto; height: 100%;">
                    <div class="card-body" style="background-color: #858687; text-transform: uppercase;">
                      <h5 class="card-title align-items-center text-white">"""),_display_(/*37.77*/Messages("Chọn phương thức truyền thông")),format.raw/*37.118*/("""</h5>
                    </div>

                    <div class="card-body" style="padding: 2rem;">
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" onchange="change_module_action('Tất cả', 0)"  value="" style="margin-top: 0.15em;">
                        <h6 class="mt-3" style="width:100%;">"""),_display_(/*43.63*/Messages("Tất cả")),format.raw/*43.81*/("""</h6>
                      </div>
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" onchange="change_module_action('NB-IoT', 4)"  value="" checked style="margin-top: 0.15em;">
                        <h6 class="mt-3" style="width:100%;">"""),_display_(/*47.63*/Messages("NB-IoT")),format.raw/*47.81*/("""</h6>
                      </div>
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" onchange="change_module_action('2G', 6)"  value="" style="margin-top: 0.15em;">
                        <h6 class="mt-3" style="width:100%;">"""),_display_(/*51.63*/Messages("2G")),format.raw/*51.77*/("""</h6>
                      </div>
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" onchange="change_module_action('Wifi', 1)"  value="" style="margin-top: 0.15em;">
                        <h6 class="mt-3" style="width:100%;">"""),_display_(/*55.63*/Messages("Wifi")),format.raw/*55.79*/("""</h6>
                      </div>
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" onchange="change_module_action('Wifi + Bluetooth', 3)"  value="" style="margin-top: 0.15em;">
                        <h6 class="mt-3" style="width:100%;">"""),_display_(/*59.63*/Messages("Wifi + Bluetooth")),format.raw/*59.91*/("""</h6>
                      </div>
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" onchange="change_module_action('Bluetooth', 2)"  value="" style="margin-top: 0.15em;">
                        <h6 class="mt-3" style="width:100%;">"""),_display_(/*63.63*/Messages("Bluetooth")),format.raw/*63.84*/("""</h6>
                      </div>
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" onchange="change_module_action('Zigbee', 5)"  value="" style="margin-top: 0.15em;">
                        <h6 class="mt-3" style="width:100%;">"""),_display_(/*67.63*/Messages("Zigbee")),format.raw/*67.81*/("""</h6>
                      </div>
                    </div>
                  </div>
                </div>

              </div>
            </div>
          </div>

          <div class="col-md-9">
            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; font-weight: 500;">
              """),_display_(/*80.16*/Messages("Các sản phẩm")),format.raw/*80.40*/("""
              """),format.raw/*81.15*/("""</span>
            </div>

            <div class="card mb-3">
              <div class="card-body">
                <p class="card-text">Gồm thông tin các bộ sản phẩm đi kèm code mẫu, tài liệu hướng dẫn tích hợp.</p>
              </div>
            </div>

            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" id="titleProduct" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; font-weight: 500;">
              """),_display_(/*92.16*/Messages("NB-IoT")),format.raw/*92.34*/("""
              """),format.raw/*93.15*/("""</span>
            </div>

            <div class="row">
              """),_display_(/*97.16*/views/*97.21*/.html.iot.module.Module_nbIot()),format.raw/*97.52*/("""
              """),_display_(/*98.16*/views/*98.21*/.html.iot.module.Module_2g()),format.raw/*98.49*/("""
              """),_display_(/*99.16*/views/*99.21*/.html.iot.module.Module_wifi()),format.raw/*99.51*/("""
              """),_display_(/*100.16*/views/*100.21*/.html.iot.module.Module_wifiBluetooth()),format.raw/*100.60*/("""
              """),_display_(/*101.16*/views/*101.21*/.html.iot.module.Module_bluetooth()),format.raw/*101.56*/("""
              """),_display_(/*102.16*/views/*102.21*/.html.iot.module.Module_zigbee()),format.raw/*102.53*/("""
            """),format.raw/*103.13*/("""</div>

          </div>
        </div>
      </div>
    </div>

    """),_display_(/*110.6*/views/*110.11*/.html.Loading()),format.raw/*110.26*/("""
  """),format.raw/*111.3*/("""</body>

  """),_display_(/*113.4*/views/*113.9*/.html.iot.tags.Main_js()),format.raw/*113.33*/("""

  """),format.raw/*115.3*/("""<script>
    var projectId = '"""),_display_(/*116.23*/projectId),format.raw/*116.32*/("""';
          $(document).ready(function () """),format.raw/*117.41*/("""{"""),format.raw/*117.42*/("""
            """),format.raw/*118.13*/("""$("#menu-module").addClass("mm-active");

            $("#menu").metisMenu();
          """),format.raw/*121.11*/("""}"""),format.raw/*121.12*/(""");
  </script>

  <script src=""""),_display_(/*124.17*/routes/*124.23*/.Assets.versioned("javascripts/views/module/Module.js")),format.raw/*124.78*/(""""></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,projectId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,projectId)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,projectId) => apply(currentUser,projectId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:45 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/module/Module.scala.html
                  HASH: 90b9ef693616fbc5f00f161a62f0e3729075c598
                  MATRIX: 662->1|685->18|1028->52|1159->88|1186->89|1354->231|1392->249|1473->303|1488->309|1545->345|1752->526|1766->531|1812->556|1845->562|1885->575|1900->581|1975->635|2065->699|2079->704|2143->747|2176->754|2190->759|2245->793|2278->799|2870->1364|2933->1405|3347->1792|3386->1810|3742->2139|3781->2157|4125->2474|4160->2488|4506->2807|4543->2823|4901->3154|4950->3182|5301->3506|5343->3527|5691->3848|5730->3866|6227->4336|6272->4360|6315->4375|6861->4894|6900->4912|6943->4927|7043->5000|7057->5005|7109->5036|7152->5052|7166->5057|7215->5085|7258->5101|7272->5106|7323->5136|7367->5152|7382->5157|7443->5196|7487->5212|7502->5217|7559->5252|7603->5268|7618->5273|7672->5305|7714->5318|7811->5388|7826->5393|7863->5408|7894->5411|7933->5423|7947->5428|7993->5452|8025->5456|8084->5487|8115->5496|8187->5539|8217->5540|8259->5553|8376->5641|8406->5642|8466->5674|8482->5680|8559->5735
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|53->21|53->21|53->21|55->23|55->23|55->23|57->25|69->37|69->37|75->43|75->43|79->47|79->47|83->51|83->51|87->55|87->55|91->59|91->59|95->63|95->63|99->67|99->67|112->80|112->80|113->81|124->92|124->92|125->93|129->97|129->97|129->97|130->98|130->98|130->98|131->99|131->99|131->99|132->100|132->100|132->100|133->101|133->101|133->101|134->102|134->102|134->102|135->103|142->110|142->110|142->110|143->111|145->113|145->113|145->113|147->115|148->116|148->116|149->117|149->117|150->118|153->121|153->121|156->124|156->124|156->124
                  -- GENERATED --
              */
          