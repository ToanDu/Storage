
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

object DeviceTemplate_create extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addDeviceTemplateModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("deviceTemplate.create")),format.raw/*5.101*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">

          <div class="col-md-12">
            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" style="width: 100%; background-color:#858687; color: #FFFFFF; text-transform: uppercase;">"""),_display_(/*12.137*/Messages("deviceTemplate.name")),format.raw/*12.168*/("""</span>
            </div>

            <div class="card" style="padding: 20px; border: 1px solid #858687;">
              <div class="row mb-2">
                <div class="col-sm-6">
                  <input id="nameDeviceTemplateAdd" type="text" class="form-control" maxlength="30" autocomplete="off" required>
                </div>
                <h7 class="textNote">"""),_display_(/*20.39*/Messages("manage.group.org.30char")),format.raw/*20.74*/("""</h7>
              </div>
            </div>

            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" style="width: 100%; background-color:#858687; color: #FFFFFF; text-transform: uppercase;">"""),_display_(/*25.137*/Messages("deviceTemplate.listFlow")),format.raw/*25.172*/("""</span>
            </div>

            <div class="card" style="padding: 20px; border: 1px solid #858687;">
              <div class="row mb-2">
                <div class="col-sm-12" id="tableListFlowAdd">

                  </div>
              </div>
            </div>
          </div>

          <div class="col-md-12">
            <div class="d-flex flex-column align-items-center text-center">
              <div class="modal-footer">
                <button type="button" class="btn btn-danger" onclick="postCreateDeviceTemplate()" data-bs-dismiss="modal">"""),_display_(/*40.124*/Messages("btnSave")),format.raw/*40.143*/("""</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*41.90*/Messages("btnClose")),format.raw/*41.110*/("""</button>
              </div>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/deviceTemplate/DeviceTemplate_create.scala.html
                  HASH: 40766df18ce6112435956122b8fde6a91d51deb5
                  MATRIX: 1065->0|1439->348|1493->381|1867->727|1920->758|2322->1133|2378->1168|2688->1450|2745->1485|3339->2051|3380->2070|3506->2169|3548->2189
                  LINES: 33->1|37->5|37->5|44->12|44->12|52->20|52->20|57->25|57->25|72->40|72->40|73->41|73->41
                  -- GENERATED --
              */
          