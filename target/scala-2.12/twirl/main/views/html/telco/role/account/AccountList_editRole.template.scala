
package views.html.telco.role.account

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

object AccountList_editRole extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editRoleAccountCmpModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.65*/Messages("Sửa quyền tài khoản")),format.raw/*5.96*/("""</span>
      </div>
      <div class="modal-body">
        <div class="row mt-3">
          <div class="row">
            <input id="idAccountEditRole" type="text" class="form-control input-form" readonly hidden>

            <div class="col-md-12">
              <div class="row mt-3">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*14.73*/Messages("Email")),format.raw/*14.90*/("""</label>
                <div class="col-sm-8">
                  <input id="emailAccountEditRole" type="text" class="form-control input-form" readonly>
                </div>
              </div>
            </div>
            <div class="col-md-12">
              <div class="row mt-3">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*22.73*/Messages("Quyền")),format.raw/*22.90*/("""</label>
                <div class="col-sm-8">
                  <select id="roleAccountEditRole" class="form-control">
                    <option value="ENTERPRISE">"""),_display_(/*25.49*/Messages("Doanh nghiệp")),format.raw/*25.73*/("""</option>
                    <option value="ENTERPRISE_VIEW">"""),_display_(/*26.54*/Messages("TK trải nghiệm")),format.raw/*26.80*/("""</option>
                  </select>
                </div>
              </div>
            </div>

          </div>
        </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*37.79*/Messages("btnCancle")),format.raw/*37.100*/("""</button>
        <button type="button" class="btn btn-red" data-bs-dismiss="modal" onclick="processEditRoleAccountCmp()">"""),_display_(/*38.114*/Messages("btnComfirm")),format.raw/*38.136*/("""</button>
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
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/account/AccountList_editRole.scala.html
                  HASH: a240a401037506ca9b736ffb3fb82472f8cd372b
                  MATRIX: 1064->0|1496->406|1547->437|1934->797|1972->814|2360->1175|2398->1192|2594->1361|2639->1385|2729->1448|2776->1474|3062->1733|3105->1754|3256->1877|3300->1899
                  LINES: 33->1|37->5|37->5|46->14|46->14|54->22|54->22|57->25|57->25|58->26|58->26|69->37|69->37|70->38|70->38
                  -- GENERATED --
              */
          