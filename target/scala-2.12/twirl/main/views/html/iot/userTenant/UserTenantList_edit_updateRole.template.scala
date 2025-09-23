
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

object UserTenantList_edit_updateRole extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="updateRoleModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-lg" style="box-shadow: 2px 0px 4px 2px #ea0033;">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.65*/Messages("Cập nhật quyền")),format.raw/*5.91*/("""</span>
      </div>
      <div class="modal-body">
        <div class="row g-3">
          <div class="col-md-12">
            <div class="row mt-3">
              <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*11.71*/Messages("User ID")),format.raw/*11.90*/("""</label>
              <div class="col-sm-7">
                <input id="userIdPer" type="text" class="form-control input-form" readonly>
              </div>
            </div>
          </div>
          <div class="col-md-12">
            <div class="row mt-3">
              <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*19.71*/Messages("Project ID")),format.raw/*19.93*/("""</label>
              <div class="col-sm-7">
                <input id="projectIdPer" type="text" class="form-control input-form" readonly>
              </div>
            </div>
          </div>
          <div class="col-md-12">
            <div class="row mt-3">
              <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*27.71*/Messages("Role Id")),format.raw/*27.90*/("""</label>
              <div class="col-sm-7">
                <select id="roleIdListPer" class="form-control"></select>
              </div>
            </div>
          </div>

        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" onclick="closeUpdateRoleModal()">"""),_display_(/*37.88*/Messages("btnCancle")),format.raw/*37.109*/("""</button>
        <button type="button" class="btn btn-red" onclick="processUpdateRolePermision()">"""),_display_(/*38.91*/Messages("btnComfirm")),format.raw/*38.113*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/userTenant/UserTenantList_edit_updateRole.scala.html
                  HASH: dfebf0ffbae72ac8ff5aefd75544e4de0151e420
                  MATRIX: 1070->0|1548->452|1594->478|1842->699|1882->718|2243->1052|2286->1074|2650->1411|2690->1430|3043->1756|3086->1777|3213->1877|3257->1899
                  LINES: 33->1|37->5|37->5|43->11|43->11|51->19|51->19|59->27|59->27|69->37|69->37|70->38|70->38
                  -- GENERATED --
              */
          