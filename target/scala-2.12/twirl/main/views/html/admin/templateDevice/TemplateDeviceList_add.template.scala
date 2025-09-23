
package views.html.admin.templateDevice

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

object TemplateDeviceList_add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addConfirmModal" data-bs-backdrop="static"  tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-white" id="exampleModalLabel" >"""),_display_(/*5.69*/Messages("Thêm thiết bị mẫu")),format.raw/*5.98*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row g-3">
          <div class="col-md-12">

            <div class="row mb-1">
              <label class="col-sm-3 col-form-label">"""),_display_(/*12.55*/Messages("Business type")),format.raw/*12.80*/("""</label>
              <div class="col-sm-9">
                <input id="businessTypeAdd" type="text" class="form-control" autocomplete="off" required>
              </div>
            </div>

            <div class="row mb-1">
              <label class="col-sm-3 col-form-label">"""),_display_(/*19.55*/Messages("Kiểu thiết bị ")),format.raw/*19.81*/("""</label>
              <div class="col-sm-9">
                <input id="deviceTypeAdd" type="text" class="form-control" autocomplete="off" required>
              </div>
            </div>

            <div class="row mb-1">
              <label class="col-sm-3 col-form-label">"""),_display_(/*26.55*/Messages("Nhóm thiết bị ")),format.raw/*26.81*/("""</label>
              <div class="col-sm-9">
                <input id="deviceGroupAdd" type="text" class="form-control" autocomplete="off" required>
              </div>
            </div>

            <div class="row mb-1">
              <label class="col-sm-3 col-form-label">"""),_display_(/*33.55*/Messages("Tên thiết bị")),format.raw/*33.79*/("""</label>
              <div class="col-sm-9">
                <input id="deviceNameAdd" type="text" class="form-control" autocomplete="off" required>
              </div>
            </div>

            <div class="row mb-1">
              <label class="col-sm-3 col-form-label">"""),_display_(/*40.55*/Messages("Giao thức truyền thông ")),format.raw/*40.90*/("""</label>
              <div class="col-sm-9">
                <input id="protocolAdd" type="text" class="form-control" autocomplete="off" required>
              </div>
            </div>

            <div class="row mb-1">
              <label class="col-sm-3 col-form-label">"""),_display_(/*47.55*/Messages("Link ảnh")),format.raw/*47.75*/("""</label>
              <div class="col-sm-9">
                <input id="urlImageAdd" type="text" class="form-control" autocomplete="off" required>
              </div>
            </div>

            <div class="row mb-1">
              <label class="col-sm-12 col-form-label">"""),_display_(/*54.56*/Messages("Thuộc tính")),format.raw/*54.78*/("""</label>
              <div class="col-sm-12">
                <div class="row">
                  <div class="col-sm-1 pt-sm-2"></div>
                  <div class="col-sm-3">
                    <label class="col-form-label">"""),_display_(/*59.52*/Messages("Attribute Name")),format.raw/*59.78*/("""</label>
                  </div>
                  <div class="col-sm-2">
                    <label class="col-form-label">"""),_display_(/*62.52*/Messages("Attribute Type")),format.raw/*62.78*/("""</label>
                  </div>
                  <div class="col-sm-2">
                    <label class="col-form-label">"""),_display_(/*65.52*/Messages("Save Log")),format.raw/*65.72*/("""</label>
                  </div>
                  <div class="col-sm-4">
                    <label class="col-form-label">"""),_display_(/*68.52*/Messages("Attribute Content")),format.raw/*68.81*/("""</label>
                  </div>
                </div>
                <div class="row" id="listAttributeAdd"></div>
              </div>
            </div>

          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" onclick="appendResourcesAttr()">"""),_display_(/*79.88*/Messages("Thêm attribute")),format.raw/*79.114*/("""</button>
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*80.77*/Messages("btnClose")),format.raw/*80.97*/("""</button>
        <button type="button" class="btn btn-success" data-bs-dismiss="modal" onclick="processAddTemplatDevice()">"""),_display_(/*81.116*/Messages("btnComfirm")),format.raw/*81.138*/("""</button>
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
                  DATE: Mon Sep 22 16:32:40 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/admin/templateDevice/TemplateDeviceList_add.scala.html
                  HASH: 2228904aaa3d1f96e5f1e4bdff256c732c71b4eb
                  MATRIX: 1068->0|1420->326|1469->355|1700->559|1746->584|2055->866|2102->892|2409->1172|2456->1198|2764->1479|2809->1503|3116->1783|3172->1818|3477->2096|3518->2116|3824->2395|3867->2417|4122->2645|4169->2671|4322->2797|4369->2823|4522->2949|4563->2969|4716->3095|4766->3124|5118->3449|5166->3475|5279->3561|5320->3581|5473->3706|5517->3728
                  LINES: 33->1|37->5|37->5|44->12|44->12|51->19|51->19|58->26|58->26|65->33|65->33|72->40|72->40|79->47|79->47|86->54|86->54|91->59|91->59|94->62|94->62|97->65|97->65|100->68|100->68|111->79|111->79|112->80|112->80|113->81|113->81
                  -- GENERATED --
              */
          