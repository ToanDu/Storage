
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

object DeviceIotVariable_add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addConfirmModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("btnAdd")),format.raw/*5.86*/("""</h5>
      </div>
      <div class="modal-body">
        <form class="row g-3">
          <div class="col-md-12">
            <label class="form-label text-darker">"""),_display_(/*10.52*/Messages("device.variable.name")),_display_(/*10.85*/Messages(" *")),format.raw/*10.99*/("""</label>
            <input id="nameVariableAdd" name="name" type="text" class="form-control" maxlength="50" autocomplete="off" required>
          </div>
          <div class="col-md-12">
            <div class="mb-3">
              <label class="form-label text-darker">"""),_display_(/*15.54*/Messages("device.variable.type")),_display_(/*15.87*/Messages(" *")),format.raw/*15.101*/("""</label><br>
              <select id="typeVariableAdd" class="single-select form-control" onchange="chooseTypeVariable()" style="width: 100%">
                <option value="0">"""),_display_(/*17.36*/Messages("device.variable.choose")),format.raw/*17.70*/("""</option>
                <option value="string">"""),_display_(/*18.41*/Messages("Text")),format.raw/*18.57*/("""</option>
                <option value="number">"""),_display_(/*19.41*/Messages("Number")),format.raw/*19.59*/("""</option>
              </select>
            </div>

          </div>
          <div class="col-md-12" id="divValueVariable">
            """),format.raw/*25.100*/("""
            """),format.raw/*26.134*/("""
          """),format.raw/*27.11*/("""</div>
        </form>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" onclick="postDataAddVariable()" data-bs-dismiss="modal">"""),_display_(/*32.112*/Messages("btnSave")),format.raw/*32.131*/("""</button>
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*33.77*/Messages("btnClose")),format.raw/*33.97*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/DeviceIot/variable/DeviceIotVariable_add.scala.html
                  HASH: 0b8ac58497000922d24346550b9d650135c40807
                  MATRIX: 1069->0|1384->289|1422->307|1615->473|1668->506|1703->520|2003->793|2056->826|2092->840|2298->1019|2353->1053|2430->1103|2467->1119|2544->1169|2583->1187|2751->1413|2793->1547|2832->1558|3041->1739|3082->1758|3195->1844|3236->1864
                  LINES: 33->1|37->5|37->5|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|50->18|50->18|51->19|51->19|57->25|58->26|59->27|64->32|64->32|65->33|65->33
                  -- GENERATED --
              */
          