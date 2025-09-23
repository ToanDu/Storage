
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

object ProjectList_edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editProjectModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("project.edit")),format.raw/*5.92*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">
          <input id="idProjectEdit" name="id" type="text" class="form-control" maxlength="30" autocomplete="off" hidden>

          <div class="col-md-8">
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*13.55*/Messages("project.name")),_display_(/*13.80*/Messages(" *")),format.raw/*13.94*/("""</label>
              <div class="col-sm-8">
                <input id="nameProjectEdit" name="name" type="text" class="form-control" maxlength="30" autocomplete="off" required>
                <br>
                <h7 class="textNote">"""),_display_(/*17.39*/Messages("manage.group.org.30char")),format.raw/*17.74*/("""</h7>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*21.55*/Messages("project.content")),_display_(/*21.83*/Messages(" *")),format.raw/*21.97*/("""</label>
              <div class="col-sm-8">
                <textarea class="form-control" id="descriptionProjectEdit" name="description" maxlength="100" placeholder="" rows="8"></textarea>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*27.55*/Messages("Lĩnh vực")),_display_(/*27.76*/Messages(" *")),format.raw/*27.90*/("""</label>
              <div class="col-sm-8">
                <select id="tagEdit" class="multiple-select" multiple="multiple"></select>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-danger" onclick="postDataEditProject()">"""),_display_(/*34.93*/Messages("btnSave")),format.raw/*34.112*/("""</button>
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*35.88*/Messages("btnClose")),format.raw/*35.108*/("""</button>
            </div>
          </div>

          <div class="col-md-4">
            <div class="col-md-12 position-relative">
              <label class="form-label">"""),_display_(/*41.42*/Messages("manage.group.img")),format.raw/*41.70*/("""</label>
              <div class="d-flex flex-column align-items-center text-center" style="border: 1px solid;">
                <img src=""""),_display_(/*43.28*/routes/*43.34*/.Assets.versioned("images/logo2.png")),format.raw/*43.71*/("""" id="wizardPicturePreviewEdit" alt="Admin" class="p-1" style="margin: 10px;width: 95%;">
                <input id="wizard-picture-edit" name="avatar" type="file" hidden/>
                <input id="imgOld" type="text" hidden/>
              </div>
            </div>
            <div class="col-md-12">
              """),format.raw/*49.110*/("""
                """),format.raw/*50.56*/("""
                  """),format.raw/*51.67*/("""
                """),format.raw/*52.27*/("""
                """),format.raw/*53.87*/("""
              """),format.raw/*54.25*/("""
              """),format.raw/*55.15*/("""<div class="d-flex align-items-center cursor-pointer" onclick="$('#wizard-picture-edit').click();">
                <div class="font-22 text-black-50">
                  <i class="fadeIn animated bx bx-upload"></i>
                </div>
                <div class="ms-2">"""),_display_(/*59.36*/Messages("manage.group.upImage")),format.raw/*59.68*/("""</div>
              </div>
            </div>
            <small>"""),_display_(/*62.21*/Messages("manage.group.upImageNote")),format.raw/*62.57*/("""</small>
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
                  DATE: Mon Sep 22 16:32:46 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/project/ProjectList_edit.scala.html
                  HASH: e18803b931089d9886eaa261630127aadfaaa95f
                  MATRIX: 1053->0|1421->342|1465->366|1812->686|1857->711|1892->725|2157->963|2213->998|2375->1133|2423->1161|2458->1175|2806->1496|2847->1517|2882->1531|3218->1840|3259->1859|3383->1956|3425->1976|3627->2151|3676->2179|3844->2320|3859->2326|3917->2363|4265->2777|4310->2833|4357->2900|4402->2927|4447->3014|4490->3039|4533->3054|4833->3327|4886->3359|4980->3426|5037->3462
                  LINES: 33->1|37->5|37->5|45->13|45->13|45->13|49->17|49->17|53->21|53->21|53->21|59->27|59->27|59->27|66->34|66->34|67->35|67->35|73->41|73->41|75->43|75->43|75->43|81->49|82->50|83->51|84->52|85->53|86->54|87->55|91->59|91->59|94->62|94->62
                  -- GENERATED --
              */
          