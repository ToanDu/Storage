
package views.html.events

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

object Event_del extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="deleteEventConfirm" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" id="theme16">
            <div class="modal-header">
                <h5 class="modal-title text-darker">"""),_display_(/*5.54*/Messages("event.title.delete")),format.raw/*5.84*/("""</h5>
                <hr>
            </div>
            <div class="modal-body text-darker">
                <h4 class="modal-body text-darker" id="myModalbody">"""),_display_(/*9.70*/Messages("noti.confirmDeletebody")),format.raw/*9.104*/("""</h4>
                <div class="form-group" hidden>
                    <input id="idEventDelete" class="form-control" name="id" >
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal" onclick="processDeleteEvent()">"""),_display_(/*15.118*/Messages("btnDelete")),format.raw/*15.139*/("""</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*16.90*/Messages("btnCancel")),format.raw/*16.111*/("""</button>
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
                  DATE: Mon Sep 22 16:32:41 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/events/Event_del.scala.html
                  HASH: d1d758f359b3f0a80ca08e52ae627e4062072883
                  MATRIX: 1041->0|1321->254|1371->284|1561->448|1616->482|1975->813|2018->834|2144->933|2187->954
                  LINES: 33->1|37->5|37->5|41->9|41->9|47->15|47->15|48->16|48->16
                  -- GENERATED --
              */
          