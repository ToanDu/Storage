
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

object UserTenantList_edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-fullscreen">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.65*/Messages("Thông tin user")),format.raw/*5.91*/("""</span>
      </div>
      <div class="modal-body">
        <div class="row g-3">
          <div class="col-md-6">
            <div class="row mt-3">
              <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*11.71*/Messages("ID")),format.raw/*11.85*/("""</label>
              <div class="col-sm-7">
                <input id="idEdit" type="text" class="form-control input-form" readonly>
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="row mt-3">
              <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*19.71*/Messages("Email")),format.raw/*19.88*/("""</label>
              <div class="col-sm-7">
                <input id="emailEdit" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="50" autocomplete="off">
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="row mt-3">
              <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*27.71*/Messages("Tên")),format.raw/*27.86*/("""</label>
              <div class="col-sm-7">
                <input id="nameEdit" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="50" autocomplete="off">
              </div>
            </div>
          </div>

          <div class="col-md-6">
            <div class="row mt-3">
              <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*36.71*/Messages("Số điện thoại")),format.raw/*36.96*/("""</label>
              <div class="col-sm-7">
                <input id="phoneEdit" type="text" class="form-control input-form" placeholder="Nhập nội dung" onkeypress="return isNumberKey(event)" maxlength="11" autocomplete="off">
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="row mt-3">
              <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*44.71*/Messages("Mật khẩu")),format.raw/*44.91*/("""</label>
              <div class="col-sm-7">
                <input id="passwordEdit" type="password" class="form-control input-form" placeholder="Nhập nội dung" autocomplete="off">
              </div>
            </div>
          </div>
          <div class="col-md-12">
            <div class="modal-footer">
              <button type="button" class="btn btn-cancle" onclick="setAddPermission()">"""),_display_(/*52.90*/Messages("Thêm role")),format.raw/*52.111*/("""</button>

              <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*54.85*/Messages("btnCancle")),format.raw/*54.106*/("""</button>
              <button type="button" class="btn btn-red" onclick="processEditUser()">"""),_display_(/*55.86*/Messages("btnComfirm")),format.raw/*55.108*/("""</button>
            </div>
          </div>
        </div>

        <div class="row mt-3">
          <div class="table-responsive mb-3" style="border-radius: 8px;">
            <table class="table table-striped" id="listPermissionUser" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th>"""),_display_(/*65.24*/Messages("STT")),format.raw/*65.39*/("""</th>
                  <th>"""),_display_(/*66.24*/Messages("Project")),format.raw/*66.43*/("""</th>
                  <th>"""),_display_(/*67.24*/Messages("Role")),format.raw/*67.40*/("""</th>
                  <th style="text-align: center">"""),_display_(/*68.51*/Messages("Thao tác")),format.raw/*68.71*/("""</th>
                </tr>
              </thead>
              <tbody></tbody>
            </table>
            <h5 id="notiNotDataPermission" style="text-align: center;"></h5>
          </div>
        </div>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/userTenant/UserTenantList_edit.scala.html
                  HASH: 9f2599b52e976858fd24a34e0fa02b129c58f877
                  MATRIX: 1059->0|1460->375|1506->401|1753->621|1788->635|2145->965|2183->982|2596->1368|2632->1383|3045->1769|3091->1794|3543->2219|3584->2239|4013->2641|4056->2662|4178->2757|4221->2778|4343->2873|4387->2895|4775->3256|4811->3271|4867->3300|4907->3319|4963->3348|5000->3364|5083->3420|5124->3440
                  LINES: 33->1|37->5|37->5|43->11|43->11|51->19|51->19|59->27|59->27|68->36|68->36|76->44|76->44|84->52|84->52|86->54|86->54|87->55|87->55|97->65|97->65|98->66|98->66|99->67|99->67|100->68|100->68
                  -- GENERATED --
              */
          