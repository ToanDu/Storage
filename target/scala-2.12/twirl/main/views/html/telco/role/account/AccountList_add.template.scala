
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
/*1.2*/import vn.m2m.common.models.User

object AccountList_add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<div class="modal fade" id="addAccountModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*7.65*/Messages("Thêm tài khoản")),format.raw/*7.91*/("""</span>
      </div>
      <div class="modal-body">
        <div class="row g-3">
          <span style="font-weight: 700;font-size: 16px;">"""),_display_(/*11.60*/Messages("Thông tin cá nhân")),format.raw/*11.89*/("""</span>
          <div class="row">
            <div class="col-md-6">
              <div class="row mt-3">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*15.73*/Messages("Họ tên")),format.raw/*15.91*/("""</label>
                <div class="col-sm-8">
                  <input id="fullNameAdd" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="50">
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div class="row mt-3">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*23.73*/Messages("Quyền tài khoản")),format.raw/*23.100*/("""</label>
                <div class="col-sm-8">
                  <select id="roleCmpAdd" type="text" class="form-select">
                    <option value="" selected>"""),_display_(/*26.48*/Messages("-- Chọn --")),format.raw/*26.70*/("""</option>
                    """),_display_(/*27.22*/if(currentUser.getCmpRole == User.CmpRole.SUPER_ADMIN.getCode())/*27.86*/{_display_(Seq[Any](format.raw/*27.87*/("""
                      """),format.raw/*28.23*/("""<option value="ADMIN">"""),_display_(/*28.46*/Messages("Admin")),format.raw/*28.63*/("""</option>
                    """)))}),format.raw/*29.22*/("""
                    """),format.raw/*30.21*/("""<option value="SUPER_ENTERPRISE">"""),_display_(/*30.55*/Messages("Đại lý")),format.raw/*30.73*/("""</option>
                  </select>
                </div>
              </div>
            </div>
          </div>

          <div class="row">
            <div class="col-md-6">
              <div class="row mt-3">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*40.73*/Messages("Email")),format.raw/*40.90*/("""</label>
                <div class="col-sm-8">
                  <input id="emailAdd" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="50">
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div class="row mt-3">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*48.73*/Messages("Số điện thoại")),format.raw/*48.98*/("""</label>
                <div class="col-sm-8">
                  <input id="phoneAdd" type="text" class="form-control input-form" placeholder="Nhập nội dung" onkeypress="return isNumberKey(event)" maxlength="11">
                </div>
              </div>
            </div>
          </div>

        </div>

        <div class="row g-3 mt-3">
          <span style="font-weight: 700;font-size: 16px;">"""),_display_(/*59.60*/Messages("Thông tin doanh nghiệp")),format.raw/*59.94*/("""</span>
          <div class="row">
            <div class="d-flex flex-column align-items-center text-center">
              <div class="">
                <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033; width: 180px;" onclick="importFileListEnterprise()">"""),_display_(/*63.163*/Messages("Up file GPKD")),format.raw/*63.187*/("""</button>
                <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033; width: 180px;" onclick="downloadTemplate()">"""),_display_(/*64.155*/Messages("Down file mẫu")),format.raw/*64.180*/("""</button>
                <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033; width: 180px;" onclick="showAddInfoEnterprise()">"""),_display_(/*65.160*/Messages("Thêm doanh nghiệp")),format.raw/*65.189*/("""</button>
              </div>
            </div>
          </div>
          <div class="row mt-3" style="padding: 15px;" id="divEnterpriseSubmit">
            <table class="table table-striped" id="tableEnterpriseSubmit" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th>"""),_display_(/*73.24*/Messages("STT")),format.raw/*73.39*/("""</th>
                  <th>"""),_display_(/*74.24*/Messages("Tên doanh nghiệp")),format.raw/*74.52*/("""</th>
                  <th>"""),_display_(/*75.24*/Messages("GPKD")),format.raw/*75.40*/("""</th>
                  <th>"""),_display_(/*76.24*/Messages("")),format.raw/*76.36*/("""</th>
                </tr>
              </thead>
              <tbody></tbody>
            </table>
          </div>
        </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" data-bs-dismiss="modal" onclick="cancleSubmitAddAccount()">"""),_display_(/*86.114*/Messages("btnCancle")),format.raw/*86.135*/("""</button>
        <button type="button" class="btn btn-red" onclick="processSubmitAddAccount()">"""),_display_(/*87.88*/Messages("btnComfirm")),format.raw/*87.110*/("""</button>
      </div>
    </div>
  </div>
</div>"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/account/AccountList_add.scala.html
                  HASH: 3cbb31c6bb792c6796a2418e54ff0081f7781aef
                  MATRIX: 670->1|1015->35|1128->53|1155->54|1588->461|1634->487|1802->628|1852->657|2059->837|2098->855|2510->1240|2559->1267|2756->1437|2799->1459|2857->1490|2930->1554|2969->1555|3020->1578|3070->1601|3108->1618|3170->1649|3219->1670|3280->1704|3319->1722|3637->2013|3675->2030|4084->2412|4130->2437|4562->2842|4617->2876|4948->3179|4994->3203|5186->3367|5233->3392|5430->3561|5481->3590|5853->3935|5889->3950|5945->3979|5994->4007|6050->4036|6087->4052|6143->4081|6176->4093|6498->4387|6541->4408|6665->4505|6709->4527
                  LINES: 24->1|29->2|34->2|35->3|39->7|39->7|43->11|43->11|47->15|47->15|55->23|55->23|58->26|58->26|59->27|59->27|59->27|60->28|60->28|60->28|61->29|62->30|62->30|62->30|72->40|72->40|80->48|80->48|91->59|91->59|95->63|95->63|96->64|96->64|97->65|97->65|105->73|105->73|106->74|106->74|107->75|107->75|108->76|108->76|118->86|118->86|119->87|119->87
                  -- GENERATED --
              */
          