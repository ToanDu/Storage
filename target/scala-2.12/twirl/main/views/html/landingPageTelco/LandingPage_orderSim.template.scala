
package views.html.landingPageTelco

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

object LandingPage_orderSim extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="questionModal1" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: inherit;">
        <h5 class="modal-title" id="exampleModalLabel" style="font-weight: 500; color: #000000;">"""),_display_(/*5.99*/Messages("landingPageTelco.ordersim.pleaseChoose")),format.raw/*5.149*/("""</h5>
      </div>
      <div class="modal-body">
        <input type="radio" id="age1" name="age" value="Sim">
        <label for="age1">"""),_display_(/*9.28*/Messages("landingPageTelco.ordersim.hasSim")),format.raw/*9.72*/("""</label><br>
        <input type="radio" id="age2" name="age" value="notSim">
        <label for="age2">"""),_display_(/*11.28*/Messages("landingPageTelco.ordersim.noSim")),format.raw/*11.71*/("""</label><br><br>
      </div>
      <div class="modal-dialog_btn-2column2" style="text-align: center;">
        <button type="button" class="btn btn-default" data-dismiss="modal" style="color: #EA0033; background: #FFFFFF;border-radius: 8px 8px 8px 0px;border-color: #EA0033;margin-top: -45px;">"""),_display_(/*14.193*/Messages("landingPageTelco.ordersim.cancel")),format.raw/*14.237*/("""</button>
        <button type="button" class="btn btn-danger" style="background: #EA0033; color: #FFFFFF;margin-top: -45px;" onclick="checkButton()" data-bs-dismiss="modal">"""),_display_(/*15.166*/Messages("landingPageTelco.ordersim.continue")),format.raw/*15.212*/("""</button>
      </div>
    </div>
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
                  DATE: Mon Sep 22 17:09:16 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPageTelco/LandingPage_orderSim.scala.html
                  HASH: 611d14480c94bb5d54c359943b5ae53e4bd7d5d1
                  MATRIX: 1062->0|1439->351|1510->401|1675->540|1739->584|1871->689|1935->732|2259->1028|2325->1072|2528->1247|2596->1293
                  LINES: 33->1|37->5|37->5|41->9|41->9|43->11|43->11|46->14|46->14|47->15|47->15
                  -- GENERATED --
              */
          