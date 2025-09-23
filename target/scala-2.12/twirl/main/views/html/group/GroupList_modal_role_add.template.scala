
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

object GroupList_modal_role_add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addRoleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("role.addNew")),format.raw/*5.91*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-1"></div>
          <div class="col-md-10">
            <div class="col-md-12">
              <div class="row">

                <div class="col-md-12">
                  <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
                    <span class="input-group-text" style="width: 100%; background-color:#858687; color: #FFFFFF; text-transform: uppercase;">"""),_display_(/*16.143*/Messages("role.name")),format.raw/*16.164*/("""</span>
                  </div>
                  <div class="card" style="padding: 10px; min-height: 150px;">
                    <div class="col-sm-6">
                      <input id="nameRoleNew" type="text" class="form-control" maxlength="30" autocomplete="off" required>
                      <br>
                      <h7 class="textNote">"""),_display_(/*22.45*/Messages("manage.group.org.30char")),format.raw/*22.80*/("""</h7>
                    </div>
                  </div>
                </div>

                <div class="col-md-12">
                  <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
                    <span class="input-group-text" style="width: 100%; background-color:#858687; color: #FFFFFF; text-transform: uppercase;">"""),_display_(/*29.143*/Messages("role.resources")),format.raw/*29.169*/("""</span>
                  </div>
                  <div class="card" style="padding: 10px; min-height: 150px;">
                    <div class="col-sm-12" id="resourcesRoleNew" style="">
                      <div class="row">
                        <div class="col-sm-5">
                          <div class="form-check form-check-inline" style="width: 100%; padding-left: 0px;">
                            <select class="form-select mb-3 service-list" aria-label="Default select example" id="serviceList1">
                              <option class="organizations" value="organizations" selected>"""),_display_(/*37.93*/Messages("role.service.organizations")),format.raw/*37.131*/("""</option>
                              <option class="groups" value="groups">"""),_display_(/*38.70*/Messages("role.service.groups")),format.raw/*38.101*/("""</option>
                              <option class="devices" value="devices">"""),_display_(/*39.72*/Messages("role.service.devices")),format.raw/*39.104*/("""</option>
                              <option class="users" value="users">"""),_display_(/*40.68*/Messages("role.service.users")),format.raw/*40.98*/("""</option>
                              <option class="events" value="events">"""),_display_(/*41.70*/Messages("role.service.events")),format.raw/*41.101*/("""</option>
                            </select>
                          </div>
                        </div>
                        <div class="col-sm-6 permission-list">
                          <div class="form-check form-check-inline" style="margin-top: 10px">
                            <input class="form-check-input CheckBoxView" type="checkbox" id="CheckBoxView1" value="option1">
                            <label class="form-check-label" for="CheckBoxView1">"""),_display_(/*48.82*/Messages("btnView")),format.raw/*48.101*/("""</label>
                          </div>
                          <div class="form-check form-check-inline" style="margin-top: 10px">
                            <input class="form-check-input CheckBoxCreate" type="checkbox" id="CheckBoxCreate1" value="option2">
                            <label class="form-check-label" for="CheckBoxCreate1">"""),_display_(/*52.84*/Messages("btnCreate")),format.raw/*52.105*/("""</label>
                          </div>
                          <div class="form-check form-check-inline" style="margin-top: 10px">
                            <input class="form-check-input CheckBoxEdit" type="checkbox" id="CheckBoxEdit1" value="option3">
                            <label class="form-check-label" for="CheckBoxEdit1">"""),_display_(/*56.82*/Messages("btnEdit")),format.raw/*56.101*/("""</label>
                          </div>
                          <div class="form-check form-check-inline" style="margin-top: 10px">
                            <input class="form-check-input CheckBoxDelete" type="checkbox" id="CheckBoxDelete1" value="option4">
                            <label class="form-check-label" for="CheckBoxDelete1">"""),_display_(/*60.84*/Messages("btnDelete")),format.raw/*60.105*/("""</label>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-sm-12">
                      <div class="d-flex flex-column align-items-center text-center">
                        <button type="button" class="btn btn-dark" style="font-size: 16px; cursor: pointer; float: right" id="addMoreCondition" onclick="appendResourcesRole()">
                          <i class="bx bx-plus me-0"></i>
                        </button>
                      </div>
                    </div>
                  </div>
                </div>


              </div>
            </div>

          </div>
          <div class="col-md-1"></div>

          <div class="col-md-12">
            <div class="d-flex flex-column align-items-center text-center">
              <div class="modal-footer">
                <button type="button" class="btn btn-danger" onclick="postNewRole()" data-bs-dismiss="modal">"""),_display_(/*85.111*/Messages("btnSave")),format.raw/*85.130*/("""</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*86.90*/Messages("btnClose")),format.raw/*86.110*/("""</button>
              </div>
            </div>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList_modal_role_add.scala.html
                  HASH: beeedd1c9fa8481bad5cfd9deae8021302886781
                  MATRIX: 1055->0|1419->338|1462->361|1995->866|2038->887|2414->1236|2470->1271|2867->1640|2915->1666|3546->2270|3606->2308|3712->2387|3765->2418|3873->2499|3927->2531|4031->2608|4082->2638|4188->2717|4241->2748|4743->3223|4784->3242|5159->3590|5202->3611|5571->3953|5612->3972|5987->4320|6030->4341|7051->5334|7092->5353|7218->5452|7260->5472
                  LINES: 33->1|37->5|37->5|48->16|48->16|54->22|54->22|61->29|61->29|69->37|69->37|70->38|70->38|71->39|71->39|72->40|72->40|73->41|73->41|80->48|80->48|84->52|84->52|88->56|88->56|92->60|92->60|117->85|117->85|118->86|118->86
                  -- GENERATED --
              */
          