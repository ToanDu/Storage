
package views.html.iot.DeviceIot

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

object DeviceIotList_edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editConfirmModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" id="theme16">
            <div class="modal-header">
                <h5 class="modal-title text-darker" id="exampleModalLabel">"""),_display_(/*5.77*/Messages("device.edit")),format.raw/*5.100*/("""</h5>
                <hr>
            </div>
            <div class="modal-body">
                <form class="row g-3">
                    <div class="col-md-12" hidden>
                        <input id="idDeviceEdit" name="id" type="text" class="form-control" maxlength="50" autocomplete="off" required>
                    </div>
                    <div class="col-md-12">
                        <label class="form-label text-darker">"""),_display_(/*14.64*/Messages("device.add.name")),_display_(/*14.92*/Messages(" *")),format.raw/*14.106*/("""</label>
                        <input id="nameDeviceEdit" name="name" type="text" class="form-control" maxlength="50" autocomplete="off" required>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" onclick="postEditNameDevice()" data-bs-dismiss="modal">"""),_display_(/*20.119*/Messages("btnSave")),format.raw/*20.138*/("""</button>
                <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*21.85*/Messages("btnClose")),format.raw/*21.105*/("""</button>
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
                  DATE: Mon Sep 22 16:32:44 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/DeviceIot/DeviceIotList_edit.scala.html
                  HASH: e00bb1cd3c2c4f72dd2e5c82184f45e55161d1ea
                  MATRIX: 1057->0|1394->311|1438->334|1908->777|1956->805|1992->819|2396->1195|2437->1214|2558->1308|2600->1328
                  LINES: 33->1|37->5|37->5|46->14|46->14|46->14|52->20|52->20|53->21|53->21
                  -- GENERATED --
              */
          