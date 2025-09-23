
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

object DeviceIotVariable_chart extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="chartModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-fullscreen">
    <div class="modal-content" id="theme7">
      <div class="modal-header">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("device.variable.chart")),format.raw/*5.101*/("""</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div class="d-flex align-items-center">
          <div class="ms-6" style="width: 100%; margin-left: 15px" id="divChartLineVariable">

          </div>
          <div class="ms-6" style="width: 100%; margin-left: 15px" id="divChartColumnVariable">

          </div>
        </div>
        <div class="d-flex align-items-center">
          <div class="ms-12" style="width: 100%; margin-left: 15px">
            <div class="table-responsive">
              <table class="table align-middle mb-0" id="divTableVariable">
                <thead class="table-light">
                  <tr>
                    <th>STT</th>
                    <th>"""),_display_(/*24.26*/Messages("device.variable.name")),format.raw/*24.58*/("""</th>
                    <th>"""),_display_(/*25.26*/Messages("device.variable.value")),format.raw/*25.59*/("""</th>
                    <th>"""),_display_(/*26.26*/Messages("device.variable.time")),format.raw/*26.58*/("""</th>
                  </tr>
                </thead>
                <tbody>
                </tbody>
              </table>
            </div>
          </div>
        </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*38.77*/Messages("btnClose")),format.raw/*38.97*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/DeviceIot/variable/DeviceIotVariable_chart.scala.html
                  HASH: 038d069921bdce3dc20966c3a7b47b86932e71a6
                  MATRIX: 1071->0|1397->300|1451->333|2279->1134|2332->1166|2390->1197|2444->1230|2502->1261|2555->1293|2883->1594|2924->1614
                  LINES: 33->1|37->5|37->5|56->24|56->24|57->25|57->25|58->26|58->26|70->38|70->38
                  -- GENERATED --
              */
          