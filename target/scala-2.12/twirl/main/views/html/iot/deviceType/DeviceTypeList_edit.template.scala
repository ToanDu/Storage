
package views.html.iot.deviceType

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

object DeviceTypeList_edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editConfirmModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-darker" id="exampleModalLabel">"""),_display_(/*5.69*/Messages("deviceType.edit")),format.raw/*5.96*/("""</h5>
        <hr>
      </div>
      <div class="modal-body">
        <form class="row g-3">
          <div class="col-md-12" hidden>
            <input id="idDeviceTypeEdit" name="id" type="text" class="form-control" maxlength="50" autocomplete="off" required>
          </div>
          <div class="col-md-12">
            <label class="form-label text-darker">"""),_display_(/*14.52*/Messages("deviceType.add.name")),_display_(/*14.84*/Messages(" *")),format.raw/*14.98*/("""</label>
            <input id="nameDeviceTypeEdit" name="name" type="text" class="form-control" maxlength="50" autocomplete="off" required>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" onclick="postEditDeviceType()" data-bs-dismiss="modal">"""),_display_(/*20.111*/Messages("btnSave")),format.raw/*20.130*/("""</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*21.82*/Messages("btnClose")),format.raw/*21.102*/("""</button>
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
                  DATE: Mon Sep 22 16:32:45 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/deviceType/DeviceTypeList_edit.scala.html
                  HASH: 016d31e9255f4ea67759fddf25ea726de894e238
                  MATRIX: 1059->0|1376->291|1423->318|1815->683|1867->715|1902->729|2260->1059|2301->1078|2419->1169|2461->1189
                  LINES: 33->1|37->5|37->5|46->14|46->14|46->14|52->20|52->20|53->21|53->21
                  -- GENERATED --
              */
          