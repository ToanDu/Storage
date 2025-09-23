
package views.html.iot.dashboardV3

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

object DashboardList_edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editDashboardModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("dashboard.edit")),format.raw/*5.94*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12">
            <input id="idDashboardEdit" name="id" type="text" class="form-control" maxlength="30" autocomplete="off" readonly hidden>

            <div class="row mb-4">
              <label class="col-sm-4 col-form-label">"""),_display_(/*13.55*/Messages("dashboard.name")),format.raw/*13.81*/("""</label>
              <div class="col-sm-8">
                <input id="nameDashboardEdit" name="name" type="text" class="form-control" maxlength="30" autocomplete="off" required>
                <br>
                <h7 class="textNote">"""),_display_(/*17.39*/Messages("manage.group.org.30char")),format.raw/*17.74*/("""</h7>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-4 col-form-label">"""),_display_(/*21.55*/Messages("dashboard.content")),format.raw/*21.84*/("""</label>
              <div class="col-sm-8">
                <textarea class="form-control" id="contentDashboardEdit" name="description" maxlength="100" placeholder="" rows="5"></textarea>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-danger" onclick="processEditDashboard()">"""),_display_(/*28.94*/Messages("btnSave")),format.raw/*28.113*/("""</button>
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*29.88*/Messages("btnClose")),format.raw/*29.108*/("""</button>
            </div>
          </div>
        </div>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboardV3/DashboardList_edit.scala.html
                  HASH: c97ae3acc509741b9b39a3f28d46d8b174f28562
                  MATRIX: 1059->0|1420->335|1466->361|1827->695|1874->721|2141->961|2197->996|2359->1131|2409->1160|2799->1523|2840->1542|2964->1639|3006->1659
                  LINES: 33->1|37->5|37->5|45->13|45->13|49->17|49->17|53->21|53->21|60->28|60->28|61->29|61->29
                  -- GENERATED --
              */
          