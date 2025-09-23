
package views.html.iot.project

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

object ProjectList_solutionMaket_smartFarm extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addSmartFarmConfirm" data-bs-backdrop="static" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-white">"""),_display_(/*5.45*/Messages("Khởi tạo dự án theo Giải pháp Smart Farm")),format.raw/*5.97*/("""</h5>
      </div>
      <div class="modal-body text-darker">
        <div class="row mb-4">
          <label class="col-sm-3 col-form-label">"""),_display_(/*9.51*/Messages("project.name")),_display_(/*9.76*/Messages(" *")),format.raw/*9.90*/("""</label>
          <div class="col-sm-8">
            <input id="nameSmartFarmAdd" name="name" type="text" class="form-control" maxlength="30" autocomplete="off" required>
            <br>
            <h7 class="textNote">"""),_display_(/*13.35*/Messages("manage.group.org.30char")),format.raw/*13.70*/("""</h7>
          </div>
        </div>
        <div class="row mb-4">
          <label class="col-sm-3 col-form-label">"""),_display_(/*17.51*/Messages("project.content")),_display_(/*17.79*/Messages(" *")),format.raw/*17.93*/("""</label>
          <div class="col-sm-8">
            <textarea class="form-control" id="contentSmartFarmAdd" name="description" maxlength="100" placeholder="" rows="8"></textarea>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" onclick="addProjectSmartFarm()">"""),_display_(/*24.87*/Messages("btnComfirm")),format.raw/*24.109*/("""</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" data-bs-toggle="modal" data-bs-target="#createTemplateProjectModal">"""),_display_(/*25.150*/Messages("btnCancel")),format.raw/*25.171*/("""</button>
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
                  DATE: Mon Sep 22 16:32:46 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/project/ProjectList_solutionMaket_smartFarm.scala.html
                  HASH: 43d65bd9cd1f1b4d9ea63762e7a21ac93b9396b0
                  MATRIX: 1072->0|1358->260|1430->312|1599->455|1643->480|1677->494|1927->717|1983->752|2129->871|2177->899|2212->913|2584->1258|2628->1280|2815->1439|2858->1460
                  LINES: 33->1|37->5|37->5|41->9|41->9|41->9|45->13|45->13|49->17|49->17|49->17|56->24|56->24|57->25|57->25
                  -- GENERATED --
              */
          