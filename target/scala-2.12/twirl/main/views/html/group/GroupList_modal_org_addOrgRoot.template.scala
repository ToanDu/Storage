
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

object GroupList_modal_org_addOrgRoot extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addGroupRootModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content" id="theme16">
            <div class="modal-header" style="text-align: center; display: block">
                <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.76*/Messages("btnAddGroupRoot")),format.raw/*5.103*/("""</h5>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-8">
                        <div class="row mb-4">
                            <label class="col-sm-3 col-form-label">"""),_display_(/*11.69*/Messages("manage.group.org")),_display_(/*11.98*/Messages(" *")),format.raw/*11.112*/("""</label>
                            <div class="col-sm-8">
                                <input id="nameOrgCreate" name="name" type="text" class="form-control" maxlength="30" autocomplete="off" required>
                                <br>
                                <h7 class="textNote">"""),_display_(/*15.55*/Messages("manage.group.org.30char")),format.raw/*15.90*/("""</h7>
                            </div>
                        </div>
                        <div class="row mb-4">
                            <label class="col-sm-3 col-form-label">"""),_display_(/*19.69*/Messages("manage.group.tructhuoc")),_display_(/*19.104*/Messages(" *")),format.raw/*19.118*/("""</label>
                            <div class="col-sm-8">
                                <select id="chooseGroupOrgAdd" class="form-select">
                                    <option value="" selected>"""),_display_(/*22.64*/Messages("manage.group.tructhuoc")),format.raw/*22.98*/("""</option>
                                </select>
                            </div>
                        </div>
                        <div class="row mb-4">
                            <label class="col-sm-3 col-form-label">"""),_display_(/*27.69*/Messages("manage.group.content")),_display_(/*27.102*/Messages(" *")),format.raw/*27.116*/("""</label>
                            <div class="col-sm-8">
                                <textarea class="form-control" id="descriptionOrgCreate" placeholder="" rows="8" maxlength="100"></textarea>
                            </div>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" onclick="postDataCreateOrg()" data-bs-dismiss="modal">"""),_display_(/*34.129*/Messages("btnSave")),format.raw/*34.148*/("""</button>
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*35.102*/Messages("btnClose")),format.raw/*35.122*/("""</button>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="col-md-12 position-relative">
                            <label class="form-label">"""),_display_(/*41.56*/Messages("manage.group.img")),format.raw/*41.84*/("""</label>
                            <div class="d-flex flex-column align-items-center text-center" style="border: 1px solid;">
                                <img id="wizardPicturePreview" src=""""),_display_(/*43.70*/routes/*43.76*/.Assets.versioned("images/org/building.png")),format.raw/*43.120*/("""" alt="Admin" class="p-1" width="100%" style="margin: 10px;;">
                                <input id="wizard-picture" name="avatar" type="file" hidden/>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="d-flex align-items-center cursor-pointer" onclick="chooseImgDefault()">
                                <div class="font-22 text-black-50">
                                    <i class="fadeIn animated bx bx-images"></i>
                                </div>
                                <div class="ms-2">"""),_display_(/*52.52*/Messages("manage.group.imgChooseDefault")),format.raw/*52.93*/("""</div>
                            </div>
                            <div class="d-flex align-items-center cursor-pointer" onclick="$('#wizard-picture').click();">
                                <div class="font-22 text-black-50">
                                    <i class="fadeIn animated bx bx-upload"></i>
                                </div>
                                <div class="ms-2">"""),_display_(/*58.52*/Messages("manage.group.upImage")),format.raw/*58.84*/("""</div>
                            </div>
                        </div>
                        <small>"""),_display_(/*61.33*/Messages("manage.group.upImageNote")),format.raw/*61.69*/("""</small>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList_modal_org_addOrgRoot.scala.html
                  HASH: a0b14154a5fd54c86c22bc5bc3f1c9df7c49b10f
                  MATRIX: 1061->0|1450->363|1498->390|1779->644|1828->673|1864->687|2189->985|2245->1020|2459->1207|2515->1242|2551->1256|2785->1463|2840->1497|3100->1730|3154->1763|3190->1777|3665->2224|3706->2243|3845->2354|3887->2374|4147->2607|4196->2635|4420->2832|4435->2838|4501->2882|5150->3504|5212->3545|5643->3949|5696->3981|5828->4086|5885->4122
                  LINES: 33->1|37->5|37->5|43->11|43->11|43->11|47->15|47->15|51->19|51->19|51->19|54->22|54->22|59->27|59->27|59->27|66->34|66->34|67->35|67->35|73->41|73->41|75->43|75->43|75->43|84->52|84->52|90->58|90->58|93->61|93->61
                  -- GENERATED --
              */
          