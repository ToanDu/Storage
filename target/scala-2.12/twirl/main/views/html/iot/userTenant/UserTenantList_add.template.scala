
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

object UserTenantList_add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.65*/Messages("Thêm user")),format.raw/*5.86*/("""</span>
      </div>
      <div class="modal-body">
        <div class="row g-3">
          <div class="col-md-12">
            <div class="row mt-3">
              <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*11.71*/Messages("Email")),format.raw/*11.88*/("""</label>
              <div class="col-sm-7">
                <input id="email" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="50" autocomplete="off">
              </div>
            </div>
          </div>
          <div class="col-md-12">
            <div class="row mt-3">
              <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*19.71*/Messages("Tên")),format.raw/*19.86*/("""</label>
              <div class="col-sm-7">
                <input id="name" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="50" autocomplete="off">
              </div>
            </div>
          </div>

          <div class="col-md-12">
            <div class="row mt-3">
              <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*28.71*/Messages("Số điện thoại")),format.raw/*28.96*/("""</label>
              <div class="col-sm-7">
                <input id="phone" type="text" class="form-control input-form" placeholder="Nhập nội dung" onkeypress="return isNumberKey(event)" maxlength="11" autocomplete="off">
              </div>
            </div>
          </div>
          <div class="col-md-12">
            <div class="row mt-3">
              <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*36.71*/Messages("Mật khẩu")),format.raw/*36.91*/("""</label>
              <div class="col-sm-7">
                <input id="password" type="password" class="form-control input-form" placeholder="Nhập nội dung" autocomplete="off">
              </div>
            </div>
          </div>

        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*46.79*/Messages("btnCancle")),format.raw/*46.100*/("""</button>
        <button type="button" class="btn btn-red" onclick="createUserTenant()">"""),_display_(/*47.81*/Messages("btnComfirm")),format.raw/*47.103*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/userTenant/UserTenantList_add.scala.html
                  HASH: b31efdf28e852368ac665f0f6c5c77ad66b6bf9a
                  MATRIX: 1058->0|1484->400|1525->421|1773->642|1811->659|2221->1042|2257->1057|2667->1440|2713->1465|3162->1887|3203->1907|3606->2283|3649->2304|3766->2394|3810->2416
                  LINES: 33->1|37->5|37->5|43->11|43->11|51->19|51->19|60->28|60->28|68->36|68->36|78->46|78->46|79->47|79->47
                  -- GENERATED --
              */
          