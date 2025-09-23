
package views.html.group

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

object GroupList_modal_org_edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editOrgModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("group.editOrg")),format.raw/*5.93*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-8">
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*11.55*/Messages("manage.group.org")),_display_(/*11.84*/Messages(" *")),format.raw/*11.98*/("""</label>
              <div class="col-sm-8">
                <input id="editNameOrg" name="name" type="text" class="form-control" maxlength="30" autocomplete="off" required>
                <br>
                <h7 class="textNote"> """),_display_(/*15.40*/Messages("manage.group.org.30char")),format.raw/*15.75*/("""</h7>
              </div>
            </div>
            <div class="row mb-4" hidden>
              """),format.raw/*19.110*/("""
              """),format.raw/*20.15*/("""<div class="col-sm-8">
                <input id="editIdOrg" name="id" type="text" class="form-control" maxlength="30" autocomplete="off" readonly>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*25.55*/Messages("manage.group.orgId")),format.raw/*25.85*/("""</label>
              <div class="col-sm-8">
                <span id="textIdOrg"></span>
                <br>
                <h7 class="textNote"> """),_display_(/*29.40*/Messages("manage.group.orgIdContent")),format.raw/*29.77*/("""</h7>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*33.55*/Messages("manage.group.tructhuoc")),_display_(/*33.90*/Messages(" *")),format.raw/*33.104*/("""</label>
              <div class="col-sm-8">
                <select id="chooseGroupOrgEdit" class="form-select">
                  <option value="" selected disabled>"""),_display_(/*36.55*/Messages("manage.group.tructhuoc")),format.raw/*36.89*/("""</option>
                </select>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*41.55*/Messages("manage.group.content")),_display_(/*41.88*/Messages(" *")),format.raw/*41.102*/("""</label>
              <div class="col-sm-8">
                <textarea class="form-control" id="editDescriptionOrg" placeholder="" rows="10"></textarea>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-danger" onclick="editOrg()" data-bs-dismiss="modal">"""),_display_(/*48.105*/Messages("btnSave")),format.raw/*48.124*/("""</button>
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*49.88*/Messages("btnClose")),format.raw/*49.108*/("""</button>
            </div>
          </div>

          <div class="col-md-4">
            <div class="col-md-12 position-relative">
              <label class="form-label">"""),_display_(/*55.42*/Messages("manage.group.img")),format.raw/*55.70*/("""</label>
              <div class="d-flex flex-column align-items-center text-center" style="border: 1px solid;">
                <img id="wizardPicturePreviewEdit" src=""""),_display_(/*57.58*/routes/*57.64*/.Assets.versioned("images/org/building.png")),format.raw/*57.108*/("""" alt="Admin" class="p-1" width="100%" style="margin: 10px;;">
                <input id="wizard-picture-edit" name="avatar" type="file" hidden/>
                <input id="imgOld" type="text" hidden/>
              </div>
            </div>
            <div class="col-md-12">
              """),format.raw/*63.110*/("""
                """),format.raw/*64.56*/("""
                  """),format.raw/*65.67*/("""
                """),format.raw/*66.27*/("""
                """),format.raw/*67.87*/("""
              """),format.raw/*68.25*/("""
              """),format.raw/*69.15*/("""<div class="d-flex align-items-center p-2 cursor-pointer" onclick="$('#wizard-picture-edit').click();">
                <div class="font-22 text-black-50">
                  <i class="fadeIn animated bx bx-upload"></i>
                </div>
                <div class="ms-2">"""),_display_(/*73.36*/Messages("manage.group.upImage")),format.raw/*73.68*/("""</div>
              </div>
            </div>
            <h7>"""),_display_(/*76.18*/Messages("manage.group.upImageNote")),format.raw/*76.54*/("""</h7>
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
                  DATE: Mon Sep 22 16:32:42 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList_modal_org_edit.scala.html
                  HASH: c80a356599d6941238e5704344b5675af24d3c29
                  MATRIX: 1055->0|1419->338|1464->363|1689->561|1738->590|1773->604|2035->839|2091->874|2222->1071|2265->1086|2569->1363|2620->1393|2798->1544|2856->1581|3018->1716|3073->1751|3109->1765|3305->1934|3360->1968|3552->2133|3605->2166|3641->2180|4007->2518|4048->2537|4172->2634|4214->2654|4416->2829|4465->2857|4663->3028|4678->3034|4744->3078|5065->3465|5110->3521|5157->3588|5202->3615|5247->3702|5290->3727|5333->3742|5637->4019|5690->4051|5781->4115|5838->4151
                  LINES: 33->1|37->5|37->5|43->11|43->11|43->11|47->15|47->15|51->19|52->20|57->25|57->25|61->29|61->29|65->33|65->33|65->33|68->36|68->36|73->41|73->41|73->41|80->48|80->48|81->49|81->49|87->55|87->55|89->57|89->57|89->57|95->63|96->64|97->65|98->66|99->67|100->68|101->69|105->73|105->73|108->76|108->76
                  -- GENERATED --
              */
          