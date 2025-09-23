
package views.html.telco

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

object Loading extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<link href=""""),_display_(/*1.14*/routes/*1.20*/.Assets.versioned("stylesheets/views/telco/process2.css")),format.raw/*1.77*/("""" rel="stylesheet" />

<div id="proccesing-area" style="display: none">
  """),format.raw/*4.28*/("""
    """),format.raw/*5.32*/("""
  """),format.raw/*6.13*/("""
  """),format.raw/*7.3*/("""<div class="container-loading">
    <div class="wrapper-loading">
      <div class="loader">
        <div class="spinner"></div>
      </div>
      <div class="loader">
        <div class="spinner"></div>
      </div>
      <div class="loader">
        <div class="spinner"></div>
      </div>
      <div class="loader">
        <div class="spinner"></div>
      </div>
      <div class="loader">
        <div class="spinner"></div>
      </div>
      <div class="loader">
        <div class="spinner"></div>
      </div>
      <div class="loader">
        <div class="spinner"></div>
      </div>
      <div class="loader">
        <div class="spinner"></div>
      </div>
      <div class="loader">
        <div class="spinner"></div>
      </div>
    </div>
    <h4 class="text-loading">"""),_display_(/*37.31*/Messages("Hệ thống đang xử lý")),format.raw/*37.62*/("""</h4>
  </div>
</div>

<script src=""""),_display_(/*41.15*/routes/*41.21*/.Assets.versioned("javascripts/views/telco/process.js")),format.raw/*41.76*/("""" type="text/javascript"></script>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:50 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/Loading.scala.html
                  HASH: 6eca3bca26a1c503a09c3180a1ac0fe5ad12191b
                  MATRIX: 1038->0|1077->13|1091->19|1168->76|1269->175|1301->207|1331->220|1360->223|2178->1014|2230->1045|2294->1082|2309->1088|2385->1143
                  LINES: 33->1|33->1|33->1|33->1|36->4|37->5|38->6|39->7|69->37|69->37|73->41|73->41|73->41
                  -- GENERATED --
              */
          