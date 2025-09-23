
package views.html.iot.dashboard.widget

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

object Widget_del extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="deleteWidgetConfirm" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" id="theme16">
            <div class="modal-header">
                <h5 class="modal-title text-white">"""),_display_(/*5.53*/Messages("Xóa widget")),format.raw/*5.75*/("""</h5>
            </div>
            <div class="modal-body">
                <h4 class="modal-body text-darker" id="myModalbody">"""),_display_(/*8.70*/Messages("noti.confirmDeletebody")),format.raw/*8.104*/("""</h4>
                <div class="form-group" hidden>
                    <input id="idWidgetDelete" class="form-control">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal" onclick="processDeleteWidgetId()">"""),_display_(/*14.121*/Messages("btnDelete")),format.raw/*14.142*/("""</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*15.90*/Messages("btnCancel")),format.raw/*15.111*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboard/widget/Widget_del.scala.html
                  HASH: ff4b403020bc892208a34ebb653aa2d8d8554d17
                  MATRIX: 1056->0|1336->254|1378->276|1535->407|1590->441|1942->765|1985->786|2111->885|2154->906
                  LINES: 33->1|37->5|37->5|40->8|40->8|46->14|46->14|47->15|47->15
                  -- GENERATED --
              */
          