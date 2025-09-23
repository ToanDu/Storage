
package views.html.iot.app

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

object AppSDK extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("App SDK")),format.raw/*9.32*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/app/appSdk.css")),format.raw/*17.77*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*21.6*/views/*21.11*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*21.54*/("""

    """),_display_(/*23.6*/views/*23.11*/.html.iot.tags.Header(currentUser)),format.raw/*23.45*/("""

    """),format.raw/*25.5*/("""<div class="page-wrapper">
      <div class="page-content">
        <div class="row">

          <div class="col-md-6">
            <div class="card mb-3">
              <div class="card-body" style="padding: 0px;">
                <h5 class="card-title">
                  <div class="col-md-12" style="border-bottom: 1px solid #ccc!important;">
                    <div class="row">
                      <div class="col-md-6 align-items-center" style="height: 40px; padding: 10px; margin-right: -12px;">
                        <span class="">
                          Smarthome SDK
                        </span>
                      </div>
                      <div class="col-md-3 align-items-center area-android" id="imgLogoAndoird" style="cursor: pointer; padding: 10px" onclick="changeLinkAndroid()">
                        <span>Android</span>
                      </div>
                      <div class="col-md-3 align-items-center " id="imgLogoIos" style="cursor: pointer; padding: 10px" onclick="changeLinkIos()">
                        <span class="">iOS</span>
                      </div>
                    </div>
                  </div>
                </h5>

                <div class="col-md-12">
                  <div class="row">
                    <div class="col-md-5">
                      <img src=""""),_display_(/*53.34*/routes/*53.40*/.Assets.versioned("images/overview/appSdk.png")),format.raw/*53.87*/("""" width="100%" alt="" />
                    </div>
                    <div class="col-md-7">
                      <p class="card-text">"""),_display_(/*56.45*/Messages("Ứng dụng cho phép kết nối và quản lý các thiết bị thông minh trong nhà ")),format.raw/*56.128*/("""</p>
                      <div id="linkDownloadSdk">
                        <a class="mb-3" href="http://203.113.138.18:4447/s/r2mdFKfdA28otJt/download" target="_blank">
                          <i class="bx bx-download" style="padding: 0px 5px; border: 1px solid #ccc!important;"></i> """),_display_(/*59.119*/Messages("Tải tài liệu ")),format.raw/*59.144*/("""
                        """),format.raw/*60.25*/("""</a>
                        <hr>
                        <a class="mt-3" href="http://203.113.138.18:4447/s/j8GJxdf3js55FsB/download" target="_blank">
                          <i class="bx bx-download" style="padding: 0px 5px; border: 1px solid #ccc!important;"></i> """),_display_(/*63.119*/Messages("Tải SDK ")),format.raw/*63.139*/("""
                        """),format.raw/*64.25*/("""</a>
                        <hr>
                      </div>
                    </div>
                  </div>
                </div>

              </div>
            </div>
          </div>

          <div class="col-md-6">
            <div class="card mb-3">
              <div class="card-body" style="padding: 0px;">
                <h5 class="card-title">
                  <div class="col-md-12" style="border-bottom: 1px solid #ccc!important;">
                    <div class="row">
                      <div class="col-md-6 align-items-center" style="height: 40px; padding: 10px; margin-right: -12px;">
                        <span class="">
                          Smart Tracking SDK
                        </span>
                      </div>
                      <div class="col-md-3 align-items-center area-android" style="cursor: pointer; padding: 10px" onclick="">
                        <span>Android</span>
                      </div>
                      <div class="col-md-3 align-items-center" style="cursor: pointer; padding: 10px" onclick="">
                        <span class="">iOS</span>
                      </div>
                    </div>
                  </div>
                </h5>

                <div class="col-md-12" style="padding: 15px;">
                  <p class="card-text">Đang phát triển </p>
                </div>
              </div>
            </div>
          </div>

          <div class="col-md-6">
            <div class="card mb-3">
              <div class="card-body" style="padding: 0px;">
                <h5 class="card-title">
                  <div class="col-md-12" style="border-bottom: 1px solid #ccc!important;">
                    <div class="row">
                      <div class="col-md-6 align-items-center" style="height: 40px; padding: 10px; margin-right: -12px;">
                        <span class="">
                          Smart Packing SDK
                        </span>
                      </div>
                      <div class="col-md-3 align-items-center area-android" style="cursor: pointer; padding: 10px" onclick="">
                        <span>Android</span>
                      </div>
                      <div class="col-md-3 align-items-center" style="cursor: pointer; padding: 10px" onclick="">
                        <span class="">iOS</span>
                      </div>
                    </div>
                  </div>
                </h5>

                <div class="col-md-12" style="padding: 15px;">
                  <p class="card-text">Đang phát triển </p>
                </div>
              </div>
            </div>
          </div>

          <div class="col-md-6">
            <div class="card mb-3">
              <div class="card-body" style="padding: 0px;">
                <h5 class="card-title">
                  <div class="col-md-12" style="border-bottom: 1px solid #ccc!important;">
                    <div class="row">
                      <div class="col-md-6 align-items-center" style="height: 40px; padding: 10px; margin-right: -12px;">
                        <span class="">
                          Industry SDK
                        </span>
                      </div>
                      <div class="col-md-3 align-items-center area-android" style="cursor: pointer; padding: 10px" onclick="">
                        <span>Android</span>
                      </div>
                      <div class="col-md-3 align-items-center" style="cursor: pointer; padding: 10px" onclick="">
                        <span class="">iOS</span>
                      </div>
                    </div>
                  </div>
                </h5>

                <div class="col-md-12" style="padding: 15px;">
                  <p class="card-text">Đang phát triển </p>
                </div>
              </div>
            </div>
          </div>

        </div>
      </div>
    </div>

    """),_display_(/*163.6*/views/*163.11*/.html.Loading()),format.raw/*163.26*/("""
  """),format.raw/*164.3*/("""</body>

  """),_display_(/*166.4*/views/*166.9*/.html.iot.tags.Main_js()),format.raw/*166.33*/("""

  """),format.raw/*168.3*/("""<script>
          var projectId = '"""),_display_(/*169.29*/projectId),format.raw/*169.38*/("""';
          $(document).ready(function () """),format.raw/*170.41*/("""{"""),format.raw/*170.42*/("""
            """),format.raw/*171.13*/("""$("#menu-appMobile").addClass("mm-active");

            $("#menu").metisMenu();
            for (var e = window.location, o = $(".metismenu li a").filter(function() """),format.raw/*174.86*/("""{"""),format.raw/*174.87*/("""
              """),format.raw/*175.15*/("""return this.href == e
            """),format.raw/*176.13*/("""}"""),format.raw/*176.14*/(""").addClass("").parent().addClass("mm-active"); o.is("li");) o = o.parent("").addClass("mm-show").parent("").addClass("mm-active");
          """),format.raw/*177.11*/("""}"""),format.raw/*177.12*/(""")
  </script>
  <script src=""""),_display_(/*179.17*/routes/*179.23*/.Assets.versioned("javascripts/views/app/appSdk.js")),format.raw/*179.75*/(""""></script>
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
                  DATE: Mon Sep 22 16:32:42 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/app/AppSDK.scala.html
                  HASH: 71b840a6ce2641b2aedb44fee866f8147e9243ef
                  MATRIX: 659->1|682->18|1025->52|1156->88|1183->89|1351->231|1390->250|1471->304|1486->310|1543->346|1750->527|1764->532|1810->557|1843->563|1883->576|1898->582|1972->635|2062->699|2076->704|2140->747|2173->754|2187->759|2242->793|2275->799|3642->2139|3657->2145|3725->2192|3891->2331|3996->2414|4314->2704|4361->2729|4414->2754|4712->3024|4754->3044|4807->3069|8786->7021|8801->7026|8838->7041|8869->7044|8908->7056|8922->7061|8968->7085|9000->7089|9065->7126|9096->7135|9168->7178|9198->7179|9240->7192|9435->7358|9465->7359|9509->7374|9572->7408|9602->7409|9772->7550|9802->7551|9860->7581|9876->7587|9950->7639
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|53->21|53->21|53->21|55->23|55->23|55->23|57->25|85->53|85->53|85->53|88->56|88->56|91->59|91->59|92->60|95->63|95->63|96->64|195->163|195->163|195->163|196->164|198->166|198->166|198->166|200->168|201->169|201->169|202->170|202->170|203->171|206->174|206->174|207->175|208->176|208->176|209->177|209->177|211->179|211->179|211->179
                  -- GENERATED --
              */
          