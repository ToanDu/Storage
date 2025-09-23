
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

object AepUtilities_device_project extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="projectModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.65*/Messages("Project")),format.raw/*5.84*/("""</span>
      </div>
      <div class="modal-body" style="padding-bottom: 0px;">
        <div class="row mt-3">
          <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*9.67*/Messages("Tên *")),format.raw/*9.84*/("""</label>
          <div class="col-sm-9">
            <input id="nameProjectAdd" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="50">
          </div>
        </div>

        <div class="row mt-3">
          <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*16.67*/Messages("Mô tả")),format.raw/*16.84*/("""</label>
          <div class="col-sm-9">
            <input id="desProjectAdd" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="250">
          </div>
        </div>

        <div class="modal-footer">
          <button type="button" class="btn btn-success" onclick="addProject()">"""),_display_(/*23.81*/Messages("Tạo dự án mới")),format.raw/*23.106*/("""</button>
        </div>
        <hr>
      </div>

      <div class="modal-body" style="padding-top: 0px;">
        <div class="row mt-3">
          <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*30.67*/Messages("Chọn dự án *")),format.raw/*30.91*/("""</label>
          <div class="col-sm-9">
            <select id="chooseProjectAdd" class="form-control">
              <option value="">"""),_display_(/*33.33*/Messages("---Chọn project---")),format.raw/*33.63*/("""</option>
            </select>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*39.79*/Messages("btnCancle")),format.raw/*39.100*/("""</button>
        <button type="button" class="btn btn-red" onclick="nextModalAddFlow()">"""),_display_(/*40.81*/Messages("btnNext")),format.raw/*40.100*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/aep/AepUtilities_device_project.scala.html
                  HASH: 9e92a13a38345fec5ad2b2f6955cce8b8a3bbdb0
                  MATRIX: 1062->0|1483->395|1522->414|1726->592|1763->609|2089->908|2127->925|2471->1242|2518->1267|2751->1473|2796->1497|2961->1635|3012->1665|3227->1853|3270->1874|3387->1964|3428->1983
                  LINES: 33->1|37->5|37->5|41->9|41->9|48->16|48->16|55->23|55->23|62->30|62->30|65->33|65->33|71->39|71->39|72->40|72->40
                  -- GENERATED --
              */
          