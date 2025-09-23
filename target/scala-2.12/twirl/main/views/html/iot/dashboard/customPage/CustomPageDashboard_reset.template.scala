
package views.html.iot.dashboard.customPage

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

object CustomPageDashboard_reset extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="resetConfirm" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content bg-danger">
      <div class="modal-header">
        <h5 class="modal-title text-white">"""),_display_(/*5.45*/Messages("dashboard.design.reset")),format.raw/*5.79*/("""</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body text-white">
        <h4 class="modal-body" id="myModalbody">"""),_display_(/*9.50*/Messages("dashboard.design.resetConfirm")),format.raw/*9.91*/("""</h4>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-light" data-bs-dismiss="modal" onclick="resetAllDesign()">"""),_display_(/*12.105*/Messages("btnDelete")),format.raw/*12.126*/("""</button>
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*13.77*/Messages("btnCancel")),format.raw/*13.98*/("""</button>
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
                  DATE: Mon Sep 22 16:32:43 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboard/customPage/CustomPageDashboard_reset.scala.html
                  HASH: 23a49dd4abb64240c8aa232fb015dd9fb8ed9081
                  MATRIX: 1075->0|1334->233|1388->267|1625->478|1686->519|1870->675|1913->696|2026->782|2068->803
                  LINES: 33->1|37->5|37->5|41->9|41->9|44->12|44->12|45->13|45->13
                  -- GENERATED --
              */
          