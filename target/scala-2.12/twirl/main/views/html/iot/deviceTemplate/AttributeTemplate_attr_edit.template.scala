
package views.html.iot.deviceTemplate

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

object AttributeTemplate_attr_edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editAttributeModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("manage.org.editAttr")),format.raw/*5.99*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12">
            <div class="row mb-4">
              <label class="col-sm-4 col-form-label">"""),_display_(/*11.55*/Messages("manage.org.attr.name")),format.raw/*11.87*/("""</label>
              <div class="col-sm-8">
                <input id="nameAttrEdit" name="name" type="text" class="form-control" maxlength="30" autocomplete="off" readonly>
                <br>
                <h7 class="textNote">"""),_display_(/*15.39*/Messages("manage.group.org.30char")),format.raw/*15.74*/("""</h7>
              </div>
            </div>
            <div class="row mb-4" hidden>
              <label class="col-sm-4 col-form-label">"""),_display_(/*19.55*/Messages("manage.org.attr.type")),format.raw/*19.87*/("""</label>
              <div class="col-sm-8">
                <select id="chooseAttrTypeEdit" class="form-select">
                  <option value="SCOPE_SERVER" selected>"""),_display_(/*22.58*/Messages("Server")),format.raw/*22.76*/("""</option>
                </select>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-4 col-form-label">"""),_display_(/*27.55*/Messages("manage.org.attr.value")),format.raw/*27.88*/("""</label>
              <div class="col-sm-8">
                <select id="chooseAttrValueEdit" class="form-select">
                  <option value="STR">"""),_display_(/*30.40*/Messages("String")),format.raw/*30.58*/("""</option>
                  <option value="BOOL" >"""),_display_(/*31.42*/Messages("Boolean")),format.raw/*31.61*/("""</option>
                  <option value="LONG" >"""),_display_(/*32.42*/Messages("Long")),format.raw/*32.58*/("""</option>
                  <option value="DBL" >"""),_display_(/*33.41*/Messages("Double")),format.raw/*33.59*/("""</option>
                  <option value="JSON" >"""),_display_(/*34.42*/Messages("Json")),format.raw/*34.58*/("""</option>
                </select>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-4 col-form-label">"""),_display_(/*39.55*/Messages("manage.org.attr.default")),format.raw/*39.90*/("""</label>
              <div class="col-sm-8">
                <input id="chooseAttrDefaultEdit" type="text" class="form-control" maxlength="255" autocomplete="off" required>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-4 col-form-label">"""),_display_(/*45.55*/Messages("manage.org.attr.history")),format.raw/*45.90*/("""</label>
              <div class="col-sm-8">
                <select id="chooseAttrHistoryEdit" class="form-select">
                  <option value="true">"""),_display_(/*48.41*/Messages("Có")),format.raw/*48.55*/("""</option>
                  <option value="false" >"""),_display_(/*49.43*/Messages("Không")),format.raw/*49.60*/("""</option>
                </select>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-danger" onclick="processEditAttribute()" data-bs-dismiss="modal">"""),_display_(/*55.118*/Messages("btnSave")),format.raw/*55.137*/("""</button>
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" data-bs-toggle="modal" data-bs-target="#detailAttrConfirm">"""),_display_(/*56.147*/Messages("btnClose")),format.raw/*56.167*/("""</button>
            </div>
          </div>
        </div>
      </div>

    </div>
  </div> <!-- modal-bialog .// -->
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/deviceTemplate/AttributeTemplate_attr_edit.scala.html
                  HASH: cfd08e927889c39f6e1e6505c3bbe5cd99cab995
                  MATRIX: 1071->0|1458->361|1509->392|1735->591|1788->623|2050->858|2106->893|2275->1035|2328->1067|2527->1239|2566->1257|2758->1422|2812->1455|2994->1610|3033->1628|3111->1679|3151->1698|3229->1749|3266->1765|3343->1815|3382->1833|3460->1884|3497->1900|3689->2065|3745->2100|4075->2403|4131->2438|4316->2596|4351->2610|4430->2662|4468->2679|4729->2912|4770->2931|4954->3087|4996->3107
                  LINES: 33->1|37->5|37->5|43->11|43->11|47->15|47->15|51->19|51->19|54->22|54->22|59->27|59->27|62->30|62->30|63->31|63->31|64->32|64->32|65->33|65->33|66->34|66->34|71->39|71->39|77->45|77->45|80->48|80->48|81->49|81->49|87->55|87->55|88->56|88->56
                  -- GENERATED --
              */
          