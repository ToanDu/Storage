
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

object ProjectList_add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /*helper.form(action = routes.ProjectController.createProject(), 'enctype -> "multipart/form-data", 'id -> "createProjectForm"){*/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.3*/("""<div class="modal fade" id="addProjectModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
      <div class="modal-content" id="theme16">
        <div class="modal-header" style="text-align: center; display: block">
          <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*6.70*/Messages("project.addNew")),format.raw/*6.96*/("""</h5>
        </div>
        <div class="modal-body">
          <div class="row">
            <div class="col-md-8">
              <div class="row mb-4">
                <label class="col-sm-3 col-form-label">"""),_display_(/*12.57*/Messages("project.name")),_display_(/*12.82*/Messages(" *")),format.raw/*12.96*/("""</label>
                <div class="col-sm-8">
                  <input id="nameProjectCreate" name="name" type="text" class="form-control" maxlength="30" autocomplete="off" required>
                  <br>
                  <h7 class="textNote">"""),_display_(/*16.41*/Messages("manage.group.org.30char")),format.raw/*16.76*/("""</h7>
                </div>
              </div>
              <div class="row mb-4">
                <label class="col-sm-3 col-form-label">"""),_display_(/*20.57*/Messages("project.content")),_display_(/*20.85*/Messages(" *")),format.raw/*20.99*/("""</label>
                <div class="col-sm-8">
                  <textarea class="form-control" id="descriptionProjectCreate" name="description" maxlength="100" placeholder="" rows="6"></textarea>
                </div>
              </div>
              <div class="row mb-4">
                <label class="col-sm-3 col-form-label">"""),_display_(/*26.57*/Messages("Lĩnh vực")),_display_(/*26.78*/Messages(" *")),format.raw/*26.92*/("""</label>
                <div class="col-sm-8">
                  <select id="tagCreate" class="multiple-select" multiple="multiple"></select>
                </div>
              </div>

              <div class="modal-footer">
                <button type="button" class="btn btn-danger" onclick="postDataCreateProject()">"""),_display_(/*33.97*/Messages("btnSave")),format.raw/*33.116*/("""</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*34.90*/Messages("btnClose")),format.raw/*34.110*/("""</button>
              </div>
            </div>

            <div class="col-md-4">
              <div class="col-md-12 position-relative">
                <label class="form-label">"""),_display_(/*40.44*/Messages("manage.group.img")),format.raw/*40.72*/("""</label>
                <div class="d-flex flex-column align-items-center text-center" style="border: 1px solid;">
                  <img src=""""),_display_(/*42.30*/routes/*42.36*/.Assets.versioned("images/iotplatform.png")),format.raw/*42.79*/("""" id="wizardPicturePreview" alt="Admin" class="p-1" style="margin: 10px;width: 95%;">
                  <input id="wizard-picture" name="avatar" type="file" hidden/>
                </div>
              </div>
              <div class="col-md-12">
                <div class="d-flex align-items-center cursor-pointer" onclick="chooseImgDefault()">
                  <div class="font-22 text-black-50">
                    <i class="fadeIn animated bx bx-images"></i>
                  </div>
                  <div class="ms-2">"""),_display_(/*51.38*/Messages("manage.group.imgChooseDefault")),format.raw/*51.79*/("""</div>
                </div>
                <div class="d-flex align-items-center cursor-pointer" onclick="$('#wizard-picture').click();">
                  <div class="font-22 text-black-50">
                    <i class="fadeIn animated bx bx-upload"></i>
                  </div>
                  <div class="ms-2">"""),_display_(/*57.38*/Messages("manage.group.upImage")),format.raw/*57.70*/("""</div>
                </div>
              </div>
              <small>"""),_display_(/*60.23*/Messages("manage.group.upImageNote")),format.raw/*60.59*/("""</small>
            </div>

          </div>
        </div>

      </div>
    </div> <!-- modal-bialog .// -->
  </div>
"""),format.raw/*69.6*/("""
"""))
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/project/ProjectList_add.scala.html
                  HASH: f8b7a3ed73b4f4087f6fdaa6a7112049bd03e58e
                  MATRIX: 1178->133|1553->482|1599->508|1836->718|1881->743|1916->757|2191->1005|2247->1040|2417->1183|2465->1211|2500->1225|2862->1560|2903->1581|2938->1595|3290->1920|3331->1939|3457->2038|3499->2058|3711->2243|3760->2271|3932->2416|3947->2422|4011->2465|4567->2994|4629->3035|4978->3357|5031->3389|5131->3462|5188->3498|5336->3624
                  LINES: 33->2|37->6|37->6|43->12|43->12|43->12|47->16|47->16|51->20|51->20|51->20|57->26|57->26|57->26|64->33|64->33|65->34|65->34|71->40|71->40|73->42|73->42|73->42|82->51|82->51|88->57|88->57|91->60|91->60|100->69
                  -- GENERATED --
              */
          