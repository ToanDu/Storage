
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

object GroupList_modal_device_addDevice extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="groupadddevice" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.63*/Messages("iot.manage.org.AddDeviceToOrg")),format.raw/*5.104*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row g-3">
          <div class="col-md-12">
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*11.55*/Messages("device.add.name")),_display_(/*11.83*/Messages(" *")),format.raw/*11.97*/("""</label>
              <div class="col-sm-8">
                <input id="nameDeviceAdd" name="name" type="text" class="form-control" maxlength="30" autocomplete="off" required>
                <br>
                <h7 class="textNote">"""),_display_(/*15.39*/Messages("manage.group.org.30char")),format.raw/*15.74*/("""</h7>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*19.55*/Messages("manage.group.tructhuoc")),_display_(/*19.90*/Messages(" *")),format.raw/*19.104*/("""</label>
              <div class="col-sm-8">
                <select id="chooseGroupDeviceAdd" class="form-select">
                  <option selected disabled>"""),_display_(/*22.46*/Messages("manage.group.tructhuoc")),format.raw/*22.80*/("""</option>

                </select>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*28.55*/Messages("manage.group.templateDevice")),_display_(/*28.95*/Messages(" *")),format.raw/*28.109*/("""</label>
              <div class="col-sm-8">
                <select id="chooseTemplateDeviceAdd" class="form-select">
                  <option value="" selected disabled>"""),_display_(/*31.55*/Messages("manage.group.templateDevice")),format.raw/*31.94*/("""</option>
                </select>
              </div>
            </div>

          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" id="btnAcceptDevice" onclick="processCreateDeviceToOrg()" class="btn btn-danger" data-bs-dismiss="modal">"""),_display_(/*40.137*/Messages("btnSave")),format.raw/*40.156*/("""</button>
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*41.77*/Messages("btnClose")),format.raw/*41.97*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList_modal_device_addDevice.scala.html
                  HASH: 8ad35408de661ac7dd7fecd71a256ff6b0316dc3
                  MATRIX: 1063->0|1406->317|1468->358|1698->561|1746->589|1781->603|2044->839|2100->874|2262->1009|2317->1044|2353->1058|2542->1220|2597->1254|2790->1420|2850->1460|2886->1474|3087->1648|3147->1687|3466->1978|3507->1997|3620->2083|3661->2103
                  LINES: 33->1|37->5|37->5|43->11|43->11|43->11|47->15|47->15|51->19|51->19|51->19|54->22|54->22|60->28|60->28|60->28|63->31|63->31|72->40|72->40|73->41|73->41
                  -- GENERATED --
              */
          