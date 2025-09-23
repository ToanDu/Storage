
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

object AepUtilities_weather extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="row mt-4" id="weather-aep" style="display: none;">
  <div class="col-md-6">
    <h6>"""),_display_(/*3.10*/Messages("Request:")),format.raw/*3.30*/("""</h6><br>

    <textarea style="width: 100%;" rows="10" id="editorRequestWeather" name="code">
      """),format.raw/*6.7*/("""{"""),format.raw/*6.8*/("""
        """),format.raw/*7.9*/(""""lat": 21.021502,
        "lon": 105.8313135
      """),format.raw/*9.7*/("""}"""),format.raw/*9.8*/("""
    """),format.raw/*10.5*/("""</textarea>
  </div>

  <div class="col-md-6">
    <h6>"""),_display_(/*14.10*/Messages("Response:")),format.raw/*14.31*/("""</h6><br>

    <textarea style="width: 100%;" rows="10" id="editorResponseWeather"></textarea>
  </div>

  <div class="col-md-12 mx-auto text-center mt-2 mb-2">
    <button type="button" class="btn btn-exp" style="width: 160px;" onclick="submitWeather()">"""),_display_(/*20.96*/Messages("Submit")),format.raw/*20.114*/("""</button>
  </div>
</div>"""))
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/aep/AepUtilities_weather.scala.html
                  HASH: 041553dcd441343eb7a6556f293027a4100ac05e
                  MATRIX: 1055->0|1178->97|1218->117|1345->218|1372->219|1407->228|1484->279|1511->280|1543->285|1626->341|1668->362|1951->618|1991->636
                  LINES: 33->1|35->3|35->3|38->6|38->6|39->7|41->9|41->9|42->10|46->14|46->14|52->20|52->20
                  -- GENERATED --
              */
          