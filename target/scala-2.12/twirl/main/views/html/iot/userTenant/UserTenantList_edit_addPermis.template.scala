
package views.html.iot.userTenant

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

object UserTenantList_edit_addPermis extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addRoleModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-lg" style="box-shadow: 2px 0px 4px 2px #ea0033;">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.65*/Messages("Thêm quyền")),format.raw/*5.87*/("""</span>
      </div>
      <div class="modal-body">
        <div class="row g-3">
          <div class="col-md-12">
            <div class="row mt-3">
              <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*11.71*/Messages("User ID")),format.raw/*11.90*/("""</label>
              <div class="col-sm-7">
                <input id="userIdPerAdd" type="text" class="form-control input-form" readonly>
              </div>
            </div>
          </div>
          <div class="col-md-12">
            <div class="row mt-3">
              <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*19.71*/Messages("Project")),format.raw/*19.90*/("""</label>
              <div class="col-sm-7">
                """),format.raw/*21.102*/("""
                """),format.raw/*22.17*/("""<select id="projectIdPerAdd" class="form-control" onchange="chooseProjectGetListRole()"></select>
              </div>
            </div>
          </div>
          <div class="col-md-12">
            <div class="row mt-3">
              <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*28.71*/Messages("Role")),format.raw/*28.87*/("""</label>
              <div class="col-sm-7">
                <select id="roleIdListPerAdd" class="form-control"></select>
              </div>
            </div>
          </div>

        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" onclick="closeAddRoleModal()">"""),_display_(/*38.85*/Messages("btnCancle")),format.raw/*38.106*/("""</button>
        <button type="button" class="btn btn-red" onclick="processAddRolePermision()">"""),_display_(/*39.88*/Messages("btnComfirm")),format.raw/*39.110*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/userTenant/UserTenantList_edit_addPermis.scala.html
                  HASH: 982421cdd04758d21b4283a58bab3dd129a47818
                  MATRIX: 1069->0|1544->449|1586->471|1834->692|1874->711|2238->1048|2278->1067|2369->1214|2414->1231|2735->1525|2772->1541|3125->1867|3168->1888|3292->1985|3336->2007
                  LINES: 33->1|37->5|37->5|43->11|43->11|51->19|51->19|53->21|54->22|60->28|60->28|70->38|70->38|71->39|71->39
                  -- GENERATED --
              */
          