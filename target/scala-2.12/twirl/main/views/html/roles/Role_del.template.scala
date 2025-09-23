
package views.html.roles

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

object Role_del extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="deleteRoleConfirm" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" id="theme16">
            <div class="modal-header">
                <h5 class="modal-title text-darker">"""),_display_(/*5.54*/Messages("role.title.delete")),format.raw/*5.83*/("""</h5>
                <hr>
            </div>
            <div class="modal-body text-darker">
                <h4 class="modal-body text-darker align-items-center" id="myModalbody">"""),_display_(/*9.89*/Messages("noti.confirmDeletebody")),format.raw/*9.123*/("""</h4>
                <div class="form-group" hidden>
                    <input id="idRoleDelete" class="form-control" name="id" >
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
                  DATE: Mon Sep 22 16:32:49 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/roles/Role_del.scala.html
                  HASH: 19179c3f8597e4432fff070c91ac118cd6f836e8
                  MATRIX: 1039->0|1318->253|1367->282|1576->465|1631->499|1989->829|2032->850|2158->949|2201->970
                  LINES: 33->1|37->5|37->5|41->9|41->9|47->15|47->15|48->16|48->16
                  -- GENERATED --
              */
          