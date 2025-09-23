
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

object CustomPageDashboard_accordion_update extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="updateConfirmModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme14">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">"""),_display_(/*5.57*/Messages("btnAdd")),format.raw/*5.75*/("""</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form class="row g-3">
          <div class="col-md-6">
            <label class="form-label">"""),_display_(/*11.40*/Messages("device.add.name")),_display_(/*11.68*/Messages(" *")),format.raw/*11.82*/("""</label>
            <input id="nameDeviceAdd" name="name" type="text" class="form-control" maxlength="50" autocomplete="off" required>
          </div>
        </form>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" onclick="" data-bs-dismiss="modal">"""),_display_(/*18.91*/Messages("btnSave")),format.raw/*18.110*/("""</button>
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*19.77*/Messages("btnClose")),format.raw/*19.97*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboard/customPage/CustomPageDashboard_accordion_update.scala.html
                  HASH: bb3864dc8c45bc00abba9d0e474953b6a96be85a
                  MATRIX: 1086->0|1393->281|1431->299|1712->553|1760->581|1795->595|2128->901|2169->920|2282->1006|2323->1026
                  LINES: 33->1|37->5|37->5|43->11|43->11|43->11|50->18|50->18|51->19|51->19
                  -- GENERATED --
              */
          