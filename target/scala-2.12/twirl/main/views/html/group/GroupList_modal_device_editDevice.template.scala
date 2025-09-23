
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

object GroupList_modal_device_editDevice extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editDeviceModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.63*/Messages("device.edit")),format.raw/*5.86*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row g-3">
          <div class="col-md-12">
            <input id="idDeviceEdit" name="id" type="text" class="form-control" maxlength="30" autocomplete="off" readonly hidden>

            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*13.55*/Messages("device.add.name")),_display_(/*13.83*/Messages(" *")),format.raw/*13.97*/("""</label>
              <div class="col-sm-8">
                <input id="nameDeviceEdit" name="name" type="text" class="form-control" maxlength="30" autocomplete="off" required>
                <br>
                <h7 class="textNote">"""),_display_(/*17.39*/Messages("manage.group.org.30char")),format.raw/*17.74*/("""</h7>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*21.55*/Messages("manage.group.tructhuoc")),_display_(/*21.90*/Messages(" *")),format.raw/*21.104*/("""</label>
              <div class="col-sm-8">
                <select id="chooseGroupDeviceEdit" class="form-select">
                  <option value="" selected disabled>"""),_display_(/*24.55*/Messages("manage.group.tructhuoc")),format.raw/*24.89*/("""</option>

                </select>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*30.55*/Messages("manage.group.templateDevice")),_display_(/*30.95*/Messages(" *")),format.raw/*30.109*/("""</label>
              <div class="col-sm-8">
                <select id="chooseTemplateDeviceEdit" class="form-select">
                  <option selected disabled>"""),_display_(/*33.46*/Messages("manage.group.templateDevice")),format.raw/*33.85*/("""</option>
                </select>
              </div>
            </div>

          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" id="btnAcceptDevice" onclick="processEditDeviceInOrg()" class="btn btn-danger" data-bs-dismiss="modal">"""),_display_(/*42.135*/Messages("btnSave")),format.raw/*42.154*/("""</button>
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*43.77*/Messages("btnClose")),format.raw/*43.97*/("""</button>
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
                  DATE: Mon Sep 22 16:32:42 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList_modal_device_editDevice.scala.html
                  HASH: b64bd09550b2bd690536052dcf88a84ca1d1d1c7
                  MATRIX: 1064->0|1408->318|1451->341|1813->676|1861->704|1896->718|2160->955|2216->990|2378->1125|2433->1160|2469->1174|2668->1346|2723->1380|2916->1546|2976->1586|3012->1600|3205->1766|3265->1805|3582->2094|3623->2113|3736->2199|3777->2219
                  LINES: 33->1|37->5|37->5|45->13|45->13|45->13|49->17|49->17|53->21|53->21|53->21|56->24|56->24|62->30|62->30|62->30|65->33|65->33|74->42|74->42|75->43|75->43
                  -- GENERATED --
              */
          