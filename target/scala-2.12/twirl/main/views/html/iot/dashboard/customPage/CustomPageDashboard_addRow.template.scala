
package views.html.iot.dashboard.customPage

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

object CustomPageDashboard_addRow extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addRowModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme14">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">"""),_display_(/*5.57*/Messages("dashboard.design.addCol")),format.raw/*5.92*/("""</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form class="row g-3">
          <div class="col-md-12">
            <label class="form-label">"""),_display_(/*11.40*/Messages("dashboard.design.countCol")),_display_(/*11.78*/Messages(" *")),format.raw/*11.92*/("""</label>
            <select id="numberCol" style="width: 100%">
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="6">6</option>
            </select>
          </div>
          <div class="col-md-12">
            <div class="row">
              <div class="col-md-6">
                <label class="form-label">"""),_display_(/*23.44*/Messages("dashboard.design.heightCol")),_display_(/*23.83*/Messages(" *")),format.raw/*23.97*/("""</label>
                <input id="heightRow" type="number" class="form-control" required>
              </div>
              <div class="col-md-6">
                <label class="form-label">"""),_display_(/*27.44*/Messages("dashboard.design.dvHeightCol")),_display_(/*27.85*/Messages(" *")),format.raw/*27.99*/("""</label>
                <select id="dvCol" style="width: 100%">
                  <option value="px">"""),_display_(/*29.39*/Messages("px")),format.raw/*29.53*/("""</option>
                  <option value="vh">"""),_display_(/*30.39*/Messages("%")),format.raw/*30.52*/("""</option>
                </select>
              </div>
            </div>
          </div>
        </form>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" onclick="createRow()" data-bs-dismiss="modal">"""),_display_(/*39.102*/Messages("btnSave")),format.raw/*39.121*/("""</button>
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*40.77*/Messages("btnClose")),format.raw/*40.97*/("""</button>
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
                  DATE: Mon Sep 22 16:32:43 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboard/customPage/CustomPageDashboard_addRow.scala.html
                  HASH: 2efe4db628d13eeed72e67f4d9d9765e29b4fdae
                  MATRIX: 1076->0|1376->274|1431->309|1713->564|1771->602|1806->616|2296->1079|2355->1118|2390->1132|2610->1325|2671->1366|2706->1380|2836->1483|2871->1497|2946->1545|2980->1558|3265->1815|3306->1834|3419->1920|3460->1940
                  LINES: 33->1|37->5|37->5|43->11|43->11|43->11|55->23|55->23|55->23|59->27|59->27|59->27|61->29|61->29|62->30|62->30|71->39|71->39|72->40|72->40
                  -- GENERATED --
              */
          