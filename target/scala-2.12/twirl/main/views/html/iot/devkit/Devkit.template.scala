
package views.html.iot.devkit

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

object Devkit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("Devkit")),format.raw/*9.31*/("""</title>
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
                <div class="panel-heading" >
                  <h4 class="panel-title">
                    <div class="row" style="padding: 10px;">
                      <div class="col-md-12">
                        <div class="input-group">
                          <span class="input-group-text" onclick=""><i class='bx bx-search-alt'></i></span>
                          <input id="search-selectOrg" class="search-input form-control border-start-0" placeholder="" maxlength="30">
                        </div>
                      </div>
                    </div>
                  </h4>
                </div>


                <div class="panel-body" style="padding: 2px 2px 2px 2px; overflow-y: auto;  color: #ffffff; height: 85vh;" >
                  <div style="width: 100%; overflow: auto; height: 100%; padding: 10px;">
                    <div class="card" style="">
                      <div class="d-flex align-items-center" style="background: #B5B6B7; border-radius: 5px; height: 36px;">
                        <h6 class="mb-0" style="width:100%; color: white;">Espressif Systems</h6>
                      </div>
                    </div>
                    <div class="card" style="">
                      <div class="d-flex align-items-center" style="background: #B5B6B7; border-radius: 5px; height: 36px; ">
                        <h6 class="mb-0" style="width:100%; color: white;">Simcom</h6>
                      </div>
                    </div>
                  </div>
                </div>

              </div>
            </div>
          </div>

          <div class="col-md-9">
            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase;">
                """),_display_(/*70.18*/Messages("Hướng dẫn tích hợp thiết bị")),format.raw/*70.57*/("""
              """),format.raw/*71.15*/("""</span>
            </div>

            <div class="card mb-3">
              <div class="card-body">
                <p class="card-text">Khu vực này bao gồm thông tin các bộ DevKit đi kèm code mẫu, tài liệu hướng dẫn tích hợp và bộ SDK để kết nối thiết bị của bạn với InnoWay.</p>
              </div>
            </div>

            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; ">
              """),_display_(/*82.16*/Messages("Espressif System")),format.raw/*82.44*/("""
              """),format.raw/*83.15*/("""</span>
            </div>

            <div class="card mb-3">
              <div class="row">
                <div class="col-md-6">
                  <div class="card-body">
                    <div class="card-group shadow">
                      <div class="card border-end shadow-none">
                        <div class="card-body" style="background-color: #858687; border-radius: 5px 5px 0px 0px; height: 37px; padding: 7px;">
                          <h5 class="card-title" style="text-align: center; color: #ffffff">ESP32</h5>
                        </div>
                        <div class="card-footer">
                          <div class="row g-0">
                            <div class="col-md-4">
                              <img src=""""),_display_(/*98.42*/routes/*98.48*/.Assets.versioned("images/ESP32.jpg")),format.raw/*98.85*/("""" alt="..." class="card-img">
                            </div>
                            <div class="col-md-8">
                              <div class="card-body">
                                <h5 class="card-title">Mô tả</h5>
                                <p class="card-text"> - Cách thức truyền thông: Wifi</p>
                                <p class="card-text"> - Giao thức truyền thông: MQTT</p>
                                <p class="card-text"> - Giao thức giao tiếp: UART</p>
                                <a class="card-text" href="http://203.113.138.18:4447/s/KgQ7GzSirnD26Wx/download" style="float: right"><small style="cursor: pointer; font-weight: 600;">Tải tài liệu <i class="bx bx-arrow-to-bottom"></i></small></a>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; ">
              """),_display_(/*120.16*/Messages("Simcom")),format.raw/*120.34*/("""
              """),format.raw/*121.15*/("""</span>
            </div>
            <div class="card mb-3">
              <div class="row">

                <div class="col-md-6">
                  <div class="card-body">
                    <div class="card-group shadow">
                      <div class="card border-end shadow-none">
                        <div class="card-body" style="background-color: #858687; border-radius: 5px 5px 0px 0px; height: 37px; padding: 7px;">
                          <h5 class="card-title" style="text-align: center; color: #ffffff">SIMCOM 7020E</h5>
                        </div>
                        <div class="card-footer">
                          <div class="row g-0">
                            <div class="col-md-4">
                              <img src=""""),_display_(/*136.42*/routes/*136.48*/.Assets.versioned("images/SIMCOM7020.png")),format.raw/*136.90*/("""" alt="..." class="card-img">
                            </div>
                            <div class="col-md-8">
                              <div class="card-body">
                                <h5 class="card-title">Mô tả</h5>
                                <p class="card-text"> - Cách thức truyền thông: NB-IoT</p>
                                <p class="card-text"> - Giao thức truyền thông: MQTT</p>
                                <p class="card-text"> - Giao thức giao tiếp: UART</p>
                                <a class="card-text" href="http://203.113.138.18:4447/s/2FzAKHRNsRsq7gX/download" style="float: right"><small style="cursor: pointer; font-weight: 600;">Tải tài liệu <i class="bx bx-arrow-to-bottom"></i></small></a>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>

              </div>
            </div>
          </div>

        </div>
      </div>
    </div>

    """),_display_(/*162.6*/views/*162.11*/.html.Loading()),format.raw/*162.26*/("""
  """),format.raw/*163.3*/("""</body>

  """),_display_(/*165.4*/views/*165.9*/.html.iot.tags.Main_js()),format.raw/*165.33*/("""

  """),format.raw/*167.3*/("""<script>
          var projectId = '"""),_display_(/*168.29*/projectId),format.raw/*168.38*/("""';
          $(document).ready(function () """),format.raw/*169.41*/("""{"""),format.raw/*169.42*/("""
            """),format.raw/*170.13*/("""$("#menu-devkit").addClass("mm-active");

            $("#menu").metisMenu();
            for (var e = window.location, o = $(".metismenu li a").filter(function() """),format.raw/*173.86*/("""{"""),format.raw/*173.87*/("""
              """),format.raw/*174.15*/("""return this.href == e
            """),format.raw/*175.13*/("""}"""),format.raw/*175.14*/(""").addClass("").parent().addClass("mm-active"); o.is("li");) o = o.parent("").addClass("mm-show").parent("").addClass("mm-active");
          """),format.raw/*176.11*/("""}"""),format.raw/*176.12*/(""")

          function focusSearchTree() """),format.raw/*178.38*/("""{"""),format.raw/*178.39*/("""
            """),format.raw/*179.13*/("""$("#search-selectOrg").focus();
          """),format.raw/*180.11*/("""}"""),format.raw/*180.12*/("""
  """),format.raw/*181.3*/("""</script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/devkit/Devkit.scala.html
                  HASH: a145d85b8ef8b13b49dfb81d3b50d8541bd04e4b
                  MATRIX: 662->1|685->18|1028->52|1159->88|1186->89|1354->231|1392->249|1473->303|1488->309|1545->345|1752->526|1766->531|1812->556|1845->562|1885->575|1900->581|1975->635|2065->699|2079->704|2143->747|2176->754|2190->759|2245->793|2278->799|4389->2883|4449->2922|4492->2937|5067->3485|5116->3513|5159->3528|5946->4288|5961->4294|6019->4331|7300->5584|7340->5602|7384->5617|8179->6384|8195->6390|8259->6432|9380->7526|9395->7531|9432->7546|9463->7549|9502->7561|9516->7566|9562->7590|9594->7594|9659->7631|9690->7640|9762->7683|9792->7684|9834->7697|10026->7860|10056->7861|10100->7876|10163->7910|10193->7911|10363->8052|10393->8053|10462->8093|10492->8094|10534->8107|10605->8149|10635->8150|10666->8153
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|53->21|53->21|53->21|55->23|55->23|55->23|57->25|102->70|102->70|103->71|114->82|114->82|115->83|130->98|130->98|130->98|152->120|152->120|153->121|168->136|168->136|168->136|194->162|194->162|194->162|195->163|197->165|197->165|197->165|199->167|200->168|200->168|201->169|201->169|202->170|205->173|205->173|206->174|207->175|207->175|208->176|208->176|210->178|210->178|211->179|212->180|212->180|213->181
                  -- GENERATED --
              */
          