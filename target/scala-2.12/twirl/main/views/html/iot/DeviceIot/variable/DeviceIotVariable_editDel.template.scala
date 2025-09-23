
package views.html.iot.DeviceIot.variable

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

object DeviceIotVariable_editDel extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editConfirmModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-darker" id="exampleModalLabel">"""),_display_(/*5.69*/Messages("btnEdit")),format.raw/*5.88*/("""</h5>
        <hr>
      </div>
      <div class="modal-body">
        <form class="row g-3">
          <div class="col-md-12" hidden>
            <input id="idVariableEdit" name="id" type="text" class="form-control" maxlength="50" autocomplete="off" required>
          </div>
          <div class="col-md-12">
            <label class="form-label text-darker">"""),_display_(/*14.52*/Messages("device.variable.name")),_display_(/*14.85*/Messages(" *")),format.raw/*14.99*/("""</label>
            <input id="nameVariableEdit" name="name" type="text" class="form-control" maxlength="50" autocomplete="off" required>
          </div>
          <div class="col-md-12">
            <div class="mb-3">
              <label class="form-label text-darker">"""),_display_(/*19.54*/Messages("device.variable.type")),_display_(/*19.87*/Messages(" *")),format.raw/*19.101*/("""</label><br>
              <select id="typeVariableEdit" class="single-select" onchange="chooseEditTypeVariable()" style="width: 100%">
                <option value="0">"""),_display_(/*21.36*/Messages("device.variable.choose")),format.raw/*21.70*/("""</option>
                <option value="text">"""),_display_(/*22.39*/Messages("Text")),format.raw/*22.55*/("""</option>
                <option value="number">"""),_display_(/*23.41*/Messages("Number")),format.raw/*23.59*/("""</option>
              </select>
            </div>

          </div>
          <div class="col-md-12" id="divEditVariable">
            <label class="form-label text-darker">"""),_display_(/*29.52*/Messages("device.variable.value")),_display_(/*29.86*/Messages(" *")),format.raw/*29.100*/("""</label>
            <input id="valueVariableEdit" name="name" type="text" class="form-control" maxlength="50" autocomplete="off" required>
          </div>
        </form>

      </div>
      <div class="modal-footer">
        """),format.raw/*36.123*/("""
        """),format.raw/*37.9*/("""<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*37.82*/Messages("btnClose")),format.raw/*37.102*/("""</button>
        <button type="button" class="btn btn-danger" onclick="postDelVariable()" data-bs-dismiss="modal">"""),_display_(/*38.107*/Messages("btnDelete")),format.raw/*38.128*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/DeviceIot/variable/DeviceIotVariable_editDel.scala.html
                  HASH: cb181cf461a159597aed86ecc8b0cc98a8656dca
                  MATRIX: 1073->0|1390->291|1429->310|1819->673|1872->706|1907->720|2208->994|2261->1027|2297->1041|2495->1212|2550->1246|2625->1294|2662->1310|2739->1360|2778->1378|2982->1555|3036->1589|3072->1603|3329->1945|3365->1954|3465->2027|3507->2047|3651->2163|3694->2184
                  LINES: 33->1|37->5|37->5|46->14|46->14|46->14|51->19|51->19|51->19|53->21|53->21|54->22|54->22|55->23|55->23|61->29|61->29|61->29|68->36|69->37|69->37|69->37|70->38|70->38
                  -- GENERATED --
              */
          