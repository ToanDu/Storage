
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

object AepUtilities_device_flow extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="flowModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog ">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.65*/Messages("Flow")),format.raw/*5.81*/("""</span>
      </div>
      <div class="modal-body" style="padding-bottom: 0px;">
        <div class="row mt-3">
          <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*9.67*/Messages("Tên *")),format.raw/*9.84*/("""</label>
          <div class="col-sm-8">
            <input id="nameFlowAdd" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="50">
          </div>
        </div>

        <div class="row mt-3">
          <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*16.67*/Messages("Mô tả")),format.raw/*16.84*/("""</label>
          <div class="col-sm-8">
            <input id="descriptionFlowAdd" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="250">
          </div>
        </div>

        <div class="modal-footer">
          <button type="button" class="btn btn-success" onclick="addFlow()">"""),_display_(/*23.78*/Messages("Tạo mới")),format.raw/*23.97*/("""</button>
        </div>
        <hr>
      </div>

      <div class="modal-body" style="padding-top: 0px;">
        <div class="row mt-3">
          <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*30.67*/Messages("Chọn Flow *")),format.raw/*30.90*/("""</label>
          <div class="col-sm-8">
            <select id="chooseFlowAdd" class="form-control">
              <option value="">"""),_display_(/*33.33*/Messages("---Chọn Flow---")),format.raw/*33.60*/("""</option>
            </select>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" onclick="backModalAddProject()">"""),_display_(/*39.87*/Messages("btnBack")),format.raw/*39.106*/("""</button>
        <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*40.79*/Messages("btnCancle")),format.raw/*40.100*/("""</button>
        <button type="button" class="btn btn-red" onclick="nextModalAddTemplate()">"""),_display_(/*41.85*/Messages("btnNext")),format.raw/*41.104*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/aep/AepUtilities_device_flow.scala.html
                  HASH: cbdbc427d80fe6d151a11a8120e4ff82b8b18c0d
                  MATRIX: 1059->0|1478->393|1514->409|1718->587|1755->604|2078->900|2116->917|2462->1236|2502->1255|2735->1461|2779->1484|2941->1619|2989->1646|3212->1842|3253->1861|3368->1949|3411->1970|3532->2064|3573->2083
                  LINES: 33->1|37->5|37->5|41->9|41->9|48->16|48->16|55->23|55->23|62->30|62->30|65->33|65->33|71->39|71->39|72->40|72->40|73->41|73->41
                  -- GENERATED --
              */
          