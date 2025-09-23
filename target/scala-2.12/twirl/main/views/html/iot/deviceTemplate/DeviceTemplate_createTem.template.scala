
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

object DeviceTemplate_createTem extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="chooseDeviceTemplateModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("Chọn mẫu thiết bị")),format.raw/*5.97*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">

          <div class="col-md-12">
            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" style="width: 100%; background-color:#858687; color: #FFFFFF; text-transform: uppercase;">"""),_display_(/*12.137*/Messages("deviceTemplate.name")),format.raw/*12.168*/("""</span>
            </div>

            <input id="idDeviceTemplateChoose" readonly hidden>

            <div class="card" style="padding: 20px; border: 1px solid #858687;">
              <ul class="nav nav-tabs" role="tablist">
                <li class="nav-item" role="presentation">
                  <a class="nav-link active" data-bs-toggle="tab" href="#tabDeviceType" role="tab" aria-selected="true">
                    <div class="d-flex align-items-center">
                      """),format.raw/*22.94*/("""
                      """),format.raw/*23.23*/("""<div class="tab-title">"""),_display_(/*23.47*/Messages("Kiểu thiết bị ")),format.raw/*23.73*/("""</div>
                    </div>
                  </a>
                </li>
                <li class="nav-item" role="presentation">
                  <a class="nav-link" data-bs-toggle="tab" href="#tabBusinessType" role="tab" aria-selected="false">
                    <div class="d-flex align-items-center">
                      """),format.raw/*30.98*/("""
                      """),format.raw/*31.23*/("""<div class="tab-title">"""),_display_(/*31.47*/Messages("Business type ")),format.raw/*31.73*/("""</div>
                    </div>
                  </a>
                </li>
                <li class="nav-item" role="presentation">
                  <a class="nav-link" data-bs-toggle="tab" href="#tabGroupType" role="tab" aria-selected="false">
                    <div class="d-flex align-items-center">
                      """),format.raw/*38.98*/("""
                      """),format.raw/*39.23*/("""<div class="tab-title">"""),_display_(/*39.47*/Messages("Nhóm thiết bị ")),format.raw/*39.73*/("""</div>
                    </div>
                  </a>
                </li>
                <li class="nav-item" role="presentation">
                  <a class="nav-link" data-bs-toggle="tab" href="#tabProtocol" role="tab" aria-selected="false">
                    <div class="d-flex align-items-center">
                      """),format.raw/*46.98*/("""
                      """),format.raw/*47.23*/("""<div class="tab-title">"""),_display_(/*47.47*/Messages("Giao thức truyền thông")),format.raw/*47.81*/("""</div>
                    </div>
                  </a>
                </li>
              </ul>
              <div class="tab-content py-3">
                <div class="tab-pane fade show active" id="tabDeviceType" role="tabpanel">
                  <div class="col-md-12">
                    <div class="row">
                      <div class="col-md-4" id="listDeviceType"></div>
                      <div class="col-md-8">
                        <div class="row" id="listImgDeviceType"></div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="tab-pane fade" id="tabBusinessType" role="tabpanel">
                  <div class="col-md-12">
                    <div class="row">
                      <div class="col-md-4" id="listBusinessType"></div>
                      <div class="col-md-8">
                        <div class="row" id="listImgBusinessType"></div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="tab-pane fade" id="tabGroupType" role="tabpanel">
                  <div class="col-md-12">
                    <div class="row">
                      <div class="col-md-4" id="listGroupType"></div>
                      <div class="col-md-8">
                        <div class="row" id="listImgGroupType"></div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="tab-pane fade" id="tabProtocol" role="tabpanel">
                  <div class="col-md-12">
                    <div class="row">
                      <div class="col-md-4" id="listProtocol"></div>
                      <div class="col-md-8">
                        <div class="row" id="listImgProtocol"></div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" style="width: 100%; background-color:#858687; color: #FFFFFF; text-transform: uppercase;">"""),_display_(/*97.137*/Messages("Thuộc tính thiết bị mẫu")),format.raw/*97.172*/("""</span>
            </div>

            <div class="card" style="padding: 20px; border: 1px solid #858687;">
              <div class="row mb-2">
                <div class="col-sm-12" id="tableAttributeTemplateDevice">

                  </div>
              </div>
            </div>
          </div>

          <div class="col-md-12">
            <div class="d-flex flex-column align-items-center text-center">
              <div class="modal-footer">
                <button type="button" class="btn btn-danger" onclick="processCreateTemplateDevice()" data-bs-dismiss="modal">"""),_display_(/*112.127*/Messages("btnComfirm")),format.raw/*112.149*/("""</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*113.90*/Messages("btnClose")),format.raw/*113.110*/("""</button>
              </div>
            </div>
          </div>

        </div>
      </div>
    </div>
  </div> <!-- modal-bialog .// -->
</div>>"""))
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/deviceTemplate/DeviceTemplate_createTem.scala.html
                  HASH: 7e84dd9df5de89e52939fceb916dc3af9f6fa2ab
                  MATRIX: 1068->0|1471->377|1520->406|1894->752|1947->783|2465->1344|2516->1367|2567->1391|2614->1417|2978->1828|3029->1851|3080->1875|3127->1901|3488->2309|3539->2332|3590->2356|3637->2382|3997->2789|4048->2812|4099->2836|4154->2870|6411->5099|6468->5134|7078->5715|7123->5737|7250->5836|7293->5856
                  LINES: 33->1|37->5|37->5|44->12|44->12|54->22|55->23|55->23|55->23|62->30|63->31|63->31|63->31|70->38|71->39|71->39|71->39|78->46|79->47|79->47|79->47|129->97|129->97|144->112|144->112|145->113|145->113
                  -- GENERATED --
              */
          