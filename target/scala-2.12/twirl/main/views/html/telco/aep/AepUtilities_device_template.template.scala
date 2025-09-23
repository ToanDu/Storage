
package views.html.telco.aep

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

object AepUtilities_device_template extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="templateModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.65*/Messages("Mẫu thiết bị")),format.raw/*5.89*/("""</span>
      </div>
      <div class="modal-body" style="padding-bottom: 0px;">
        <div class="row mt-3">
          <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*9.67*/Messages("Tên *")),format.raw/*9.84*/("""</label>
          <div class="col-sm-8">
            <input id="nameTemplateAdd" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="50">
          </div>
        </div>


        <div class="modal-footer">
          <button type="button" class="btn btn-success" onclick="addTemplate()">"""),_display_(/*17.82*/Messages("Tạo mới")),format.raw/*17.101*/("""</button>
        </div>
        <hr>
      </div>

      <div class="modal-body" style="padding-top: 0px;">
        <div class="row mt-3">
          <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*24.67*/Messages("Chọn Mẫu thiết bị *")),format.raw/*24.98*/("""</label>
          <div class="col-sm-8">
            <select id="chooseTemplateAdd" class="form-control">
              <option value="">"""),_display_(/*27.33*/Messages("---Chọn Template---")),format.raw/*27.64*/("""</option>
            </select>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" onclick="backModalAddFlow()">"""),_display_(/*33.84*/Messages("btnBack")),format.raw/*33.103*/("""</button>
        <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*34.79*/Messages("btnCancle")),format.raw/*34.100*/("""</button>
        <button type="button" class="btn btn-red" onclick="nextModalAddDevice()">"""),_display_(/*35.83*/Messages("btnNext")),format.raw/*35.102*/("""</button>
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
                  DATE: Mon Sep 22 16:32:50 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/aep/AepUtilities_device_template.scala.html
                  HASH: e8cfb6ac96744d4eeb756c0c46167b500248968d
                  MATRIX: 1063->0|1485->396|1529->420|1733->598|1770->615|2117->935|2158->954|2391->1160|2443->1191|2609->1330|2661->1361|2881->1554|2922->1573|3037->1661|3080->1682|3199->1774|3240->1793
                  LINES: 33->1|37->5|37->5|41->9|41->9|49->17|49->17|56->24|56->24|59->27|59->27|65->33|65->33|66->34|66->34|67->35|67->35
                  -- GENERATED --
              */
          