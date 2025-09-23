
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

object GroupList_modal_group_editRole extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editRoleGroupUserModal" data-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("Cập nhật quyền nhóm user")),format.raw/*5.104*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">

          <div class="col-md-12">
            <div class="row mb-4" hidden>
              <input id="idRoleGroupUser" type="text" class="form-control" readonly>
            </div>
            <div class="row mb-4">
              <label class="col-sm-4 col-form-label">"""),_display_(/*15.55*/Messages("Quyền nhóm user")),format.raw/*15.82*/("""</label>
              <div class="col-sm-7">
                <select class="form-control" id="listRoleGroupUsers">

                </select>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-danger" onclick="proccessUpdateRoleGroupUser()">"""),_display_(/*24.101*/Messages("btnSave")),format.raw/*24.120*/("""</button>
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*25.88*/Messages("btnClose")),format.raw/*25.108*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList_modal_group_editRole.scala.html
                  HASH: d6bf7eb0d92e718bfa465148ba5f25a741e843fd
                  MATRIX: 1061->0|1449->362|1506->398|1879->744|1927->771|2278->1094|2319->1113|2443->1210|2485->1230
                  LINES: 33->1|37->5|37->5|47->15|47->15|56->24|56->24|57->25|57->25
                  -- GENERATED --
              */
          