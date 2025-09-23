
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

object GroupList_modal_user_editRole extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editRoleUserModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("Cập nhật vai trò user")),format.raw/*5.101*/("""</h5>
      </div>
      <div class="modal-body">
        <form class="row g-3">
          <div class="col-md-12">
            <input type="text" id="idUserEdit" class="form-control" readonly hidden>

            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*13.55*/Messages("manage.user.email")),_display_(/*13.85*/Messages(" *")),format.raw/*13.99*/("""</label>
              <div class="col-sm-8">
                <input type="text" id="emailUserEdit" class="form-control" name="email" type="email" maxlength="50" autocomplete="off" readonly>
              </div>
            </div>


            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*21.55*/Messages("role.title")),_display_(/*21.78*/Messages(" *")),format.raw/*21.92*/("""</label>
              <div class="col-sm-8">
                <select id="chooseRoleUserEdit" class="form-select">
                  <option selected disabled>"""),_display_(/*24.46*/Messages("role.title")),format.raw/*24.68*/("""</option>
                </select>
              </div>
            </div>

          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" onclick="processEditRoleUser()" data-bs-dismiss="modal">"""),_display_(/*33.111*/Messages("btnSave")),format.raw/*33.130*/("""</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*34.82*/Messages("btnClose")),format.raw/*34.102*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList_modal_user_editRole.scala.html
                  HASH: 381c366f8824898e22c439107973ba20b300020a
                  MATRIX: 1060->0|1377->291|1431->324|1748->614|1798->644|1833->658|2182->980|2225->1003|2260->1017|2447->1177|2490->1199|2784->1465|2825->1484|2943->1575|2985->1595
                  LINES: 33->1|37->5|37->5|45->13|45->13|45->13|53->21|53->21|53->21|56->24|56->24|65->33|65->33|66->34|66->34
                  -- GENERATED --
              */
          