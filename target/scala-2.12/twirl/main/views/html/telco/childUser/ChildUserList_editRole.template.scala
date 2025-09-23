
package views.html.telco.childUser

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

object ChildUserList_editRole extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="roleChildUserModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.65*/Messages("Quản lý vai trò")),format.raw/*5.92*/("""</span>
      </div>
      <div class="modal-body">
        <div class="row align-items-center">
          <div class="col-sm-2"></div>
          <div class="col-sm-6" style="text-align: left;">
            <label class="col-form-label title-section-2">"""),_display_(/*11.60*/Messages("Chức năng")),format.raw/*11.81*/("""</label>
          </div>
          <div class="col-sm-4" style="text-align: left;">
            <label class="col-form-label title-section-2">"""),_display_(/*14.60*/Messages("Quyền")),format.raw/*14.77*/("""</label>
          </div>
        </div>
        <hr>

        <div class="row">
          <input type="text" id="idChildUserUpdateRole" readonly hidden>
          <div class="accordion" id="accordionExample">
            <div class="accordion-item">
              <div class="accordion-header" id="headingOne">
                <div class="row">
                  <div class="col-md-8">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
							"""),_display_(/*27.9*/Messages("Dashboard")),format.raw/*27.30*/("""
                    """),format.raw/*28.21*/("""</button>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 7px;" class="" id="dashboard" onchange="checkAllDashboard(this)">
                  </div>
                </div>
              </div>
              <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                <div class="row mt-2">
                  <div class="col-sm-2"></div>
                  <div class="col-md-6">
                    <label>"""),_display_(/*39.29*/Messages("Tổng số thuê bao")),format.raw/*39.57*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 3px;" class="checked_role" id="view_dashboard_total_sub" onchange="onchangeCheckboxTabDashboard()" checked disabled>
                  </div>
                </div>
                <div class="row mt-2">
                  <div class="col-sm-2"></div>
                  <div class="col-md-6">
                    <label>"""),_display_(/*48.29*/Messages("Trạng thái thuê bao")),format.raw/*48.60*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 3px;" class="checked_role" id="view_dashboard_status_sub" onchange="onchangeCheckboxTabDashboard()" checked disabled>
                  </div>
                </div>
                <div class="row mt-2">
                  <div class="col-sm-2"></div>
                  <div class="col-md-6">
                    <label>"""),_display_(/*57.29*/Messages("Loại hình thuê bao")),format.raw/*57.59*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 3px;" class="checked_role" id="view_dashboard_paytype_sub" onchange="onchangeCheckboxTabDashboard()" checked disabled>
                  </div>
                </div>
                <div class="row mt-2">
                  <div class="col-sm-2"></div>
                  <div class="col-md-6">
                    <label>"""),_display_(/*66.29*/Messages("Thuê bao lũy kế theo tháng")),format.raw/*66.67*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 3px;" class="checked_role" id="view_dashboard_monthly_sub" onchange="onchangeCheckboxTabDashboard()" checked disabled>
                  </div>
                </div>
                <div class="row mt-2">
                  <div class="col-sm-2"></div>
                  <div class="col-md-6">
                    <label>"""),_display_(/*75.29*/Messages("Cảnh báo")),format.raw/*75.49*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 3px;" class="checked_role" id="view_dashboard_warning" onchange="onchangeCheckboxTabDashboard()" checked disabled>
                  </div>
                </div>
                <div class="row mt-2">
                  <div class="col-sm-2"></div>
                  <div class="col-md-6">
                    <label>"""),_display_(/*84.29*/Messages("Tiền cước")),format.raw/*84.50*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 3px;" class="checked_role dashboard" id="view_dashboard_debit" onchange="onchangeCheckboxTabDashboard()">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <hr>

        <div class="row">
          <div class="accordion" id="accordion_2">
            <div class="accordion-item">
              <div class="accordion-header" id="headingSubs">
                <div class="row">
                  <div class="col-md-8">
                    <label class="accordion-button collapsed" type="text" data-bs-toggle="collapse" data-bs-target="#collapseSubs" aria-expanded="true" aria-controls="collapseSubs">"""),_display_(/*102.183*/Messages("Quản lý thuê bao")),format.raw/*102.211*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 7px;" class="" id="sub" onchange="checkAllSub(this)">
                  </div>
                </div>
              </div>
              <div id="collapseSubs" class="accordion-collapse collapse" aria-labelledby="headingSubs" data-bs-parent="#accordion_2">
                <div class="row mt-2">
                  <div class="col-sm-2"></div>
                  <div class="col-md-6">
                    <label>"""),_display_(/*113.29*/Messages("Xem thuê bao")),format.raw/*113.53*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 3px;" class="checked_role" id="view_sub" onchange="onchangeCheckboxTabSub()" checked disabled>
                  </div>
                </div>
                <div class="row mt-2">
                  <div class="col-sm-2"></div>
                  <div class="col-md-6">
                    <label>"""),_display_(/*122.29*/Messages("Xuất file")),format.raw/*122.50*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 3px;" class="checked_role sub" id="export_sub" onchange="onchangeCheckboxTabSub()">
                  </div>
                </div>
                <div class="row mt-2">
                  <div class="col-sm-2"></div>
                  <div class="col-md-6">
                    <label>"""),_display_(/*131.29*/Messages("Xem chi tiết từng thuê bao")),format.raw/*131.67*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 3px;" class="checked_role sub" id="view_detail_sub" onchange="onchangeCheckboxTabSub()">
                  </div>
                </div>
                <div class="row mt-2">
                  <div class="col-sm-2"></div>
                  <div class="col-md-6">
                    <label>"""),_display_(/*140.29*/Messages("Kiểm tra lưu lượng từng thuê bao")),format.raw/*140.73*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 3px;" class="checked_role sub" id="view_data_sub" onchange="onchangeCheckboxTabSub()">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <hr>

        <div class="row">
          <div class="accordion" id="accordion_3">
            <div class="accordion-item">
              <div class="accordion-header" id="headingContract">
                <div class="row">
                  <div class="col-md-8">
                    <label class="accordion-button collapsed" type="text" data-bs-toggle="collapse" data-bs-target="#collapseContract" aria-expanded="true" aria-controls="collapseContract">"""),_display_(/*158.191*/Messages("Quản lý hợp đồng")),format.raw/*158.219*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 7px;" class="" id="contract" onchange="checkAllContract(this)">
                  </div>
                </div>
              </div>
              <div id="collapseContract" class="accordion-collapse collapse " aria-labelledby="headingContract" data-bs-parent="#accordion_3">
                <div class="row mt-2">
                  <div class="col-sm-2"></div>
                  <div class="col-md-6">
                    <label>"""),_display_(/*169.29*/Messages("Xem hợp đồng")),format.raw/*169.53*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 3px;" class="checked_role contract" id="view_contract" onchange="onchangeCheckboxTabContract()">
                  </div>
                </div>
                <div class="row mt-2">
                  <div class="col-sm-2"></div>
                  <div class="col-md-6">
                    <label>"""),_display_(/*178.29*/Messages("Xuất file")),format.raw/*178.50*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 3px;" class="checked_role contract" id="export_contract" onchange="onchangeCheckboxTabContract()">
                  </div>
                </div>
                <div class="row mt-2">
                  <div class="col-sm-2"></div>
                  <div class="col-md-6">
                    <label>"""),_display_(/*187.29*/Messages("Xem chi tiết hợp đồng")),format.raw/*187.62*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 3px;" class="checked_role contract" id="view_detail_contract" onchange="onchangeCheckboxTabContract()">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <hr>

        <div class="row">
          <div class="accordion" id="accordion_4">
            <div class="accordion-item">
              <div class="accordion-header" id="headingInvoices">
                <div class="row">
                  <div class="col-md-8">
                    <label class="accordion-button collapsed" type="text" data-bs-toggle="collapse" data-bs-target="#collapseInvoices" aria-expanded="true" aria-controls="collapseInvoices">"""),_display_(/*205.191*/Messages("Quản lý hóa đơn")),format.raw/*205.218*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 7px;" class="" id="invoices" onchange="checkAllInvoice(this)">
                  </div>
                </div>
              </div>
              <div id="collapseInvoices" class="accordion-collapse collapse " aria-labelledby="headingInvoices" data-bs-parent="#accordion_4">
                <div class="row mt-2">
                  <div class="col-sm-2"></div>
                  <div class="col-md-6">
                    <label>"""),_display_(/*216.29*/Messages("Xem hóa đơn")),format.raw/*216.52*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 3px;" class="checked_role invoices" id="view_invoice" onchange="onchangeCheckboxTabInvoice()">
                  </div>
                </div>
                <div class="row mt-2">
                  <div class="col-sm-2"></div>
                  <div class="col-md-6">
                    <label>"""),_display_(/*225.29*/Messages("Tải hóa đơn")),format.raw/*225.52*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 3px;" class="checked_role invoices" id="download_invoice" onchange="onchangeCheckboxTabInvoice()">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <hr>
        <div class="row">
          <div class="accordion" id="accordion_5">
            <div class="accordion-item">
              <div class="accordion-header" id="headingUtilities">
                <div class="row">
                  <div class="col-md-8">
                    <label class="accordion-button collapsed" type="text" data-bs-toggle="collapse" data-bs-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">"""),_display_(/*242.193*/Messages("Quản lý tiện ích")),format.raw/*242.221*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 7px;" class="" id="utilities" onchange="checkAllUtilities(this)">
                  </div>
                </div>
              </div>
              <div id="collapseUtilities" class="accordion-collapse collapse " aria-labelledby="headingUtilities" data-bs-parent="#accordion_5">
                <div class="row mt-2">
                  <div class="col-sm-2"></div>
                  <div class="col-md-6">
                    <label>"""),_display_(/*253.29*/Messages("Đăng ký gói")),format.raw/*253.52*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 3px;" class="checked_role utilities" id="register_vas" onchange="onchangeCheckboxTabUtilities()">
                  </div>
                </div>
                <div class="row mt-2">
                  <div class="col-sm-2"></div>
                  <div class="col-md-6">
                    <label>"""),_display_(/*262.29*/Messages("Hủy gói")),format.raw/*262.48*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 3px;" class="checked_role utilities" id="unregister_vas" onchange="onchangeCheckboxTabUtilities()">
                  </div>
                </div>
                <div class="row mt-2">
                  <div class="col-sm-2"></div>
                  <div class="col-md-6">
                    <label>"""),_display_(/*271.29*/Messages("Hủy gia hạn")),format.raw/*271.52*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 3px;" class="checked_role utilities" id="cancel_extend" onchange="onchangeCheckboxTabUtilities()">
                  </div>
                </div>
                <div class="row mt-2">
                  <div class="col-sm-2"></div>
                  <div class="col-md-6">
                    <label>"""),_display_(/*280.29*/Messages("Nạp tiền")),format.raw/*280.49*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 3px;" class="checked_role utilities" id="top_up" onchange="onchangeCheckboxTabUtilities()">
                  </div>
                </div>
                <div class="row mt-2">
                  <div class="col-sm-2"></div>
                  <div class="col-md-6">
                    <label>"""),_display_(/*289.29*/Messages("Chặn chiều")),format.raw/*289.51*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 3px;" class="checked_role utilities" id="block_sub" onchange="onchangeCheckboxTabUtilities()">
                  </div>
                </div>
                <div class="row mt-2">
                  <div class="col-sm-2"></div>
                  <div class="col-md-6">
                    <label>"""),_display_(/*298.29*/Messages("Mở chiều")),format.raw/*298.49*/("""</label>
                  </div>
                  <div class="col-md-4">
                    <input type="checkbox" style="margin-top: 3px;" class="checked_role utilities" id="open_sub" onchange="onchangeCheckboxTabUtilities()">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <hr>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*312.79*/Messages("btnCancle")),format.raw/*312.100*/("""</button>
        <button type="button" class="btn btn-red" onclick="processUpdateRoleChildUser()">"""),_display_(/*313.91*/Messages("btnComfirm")),format.raw/*313.113*/("""</button>
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
                  DATE: Mon Sep 22 16:32:52 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/childUser/ChildUserList_editRole.scala.html
                  HASH: c278075367e79e06ec31161e2140758c3cd2e544
                  MATRIX: 1063->0|1490->401|1537->428|1818->682|1860->703|2031->847|2069->864|2663->1432|2705->1453|2754->1474|3351->2044|3400->2072|3884->2529|3936->2560|4421->3018|4472->3048|4958->3507|5017->3545|5503->4004|5544->4024|6026->4479|6068->4500|6911->5314|6962->5342|7539->5891|7585->5915|8048->6350|8091->6371|8543->6795|8603->6833|9060->7262|9126->7306|9962->8113|10013->8141|10609->8709|10655->8733|11120->9170|11163->9191|11630->9630|11685->9663|12538->10487|12588->10514|13183->11081|13228->11104|13691->11539|13736->11562|14586->12383|14637->12411|15237->12983|15282->13006|15748->13444|15789->13463|16257->13903|16302->13926|16769->14365|16811->14385|17271->14817|17315->14839|17778->15274|17820->15294|18337->15783|18381->15804|18509->15904|18554->15926
                  LINES: 33->1|37->5|37->5|43->11|43->11|46->14|46->14|59->27|59->27|60->28|71->39|71->39|80->48|80->48|89->57|89->57|98->66|98->66|107->75|107->75|116->84|116->84|134->102|134->102|145->113|145->113|154->122|154->122|163->131|163->131|172->140|172->140|190->158|190->158|201->169|201->169|210->178|210->178|219->187|219->187|237->205|237->205|248->216|248->216|257->225|257->225|274->242|274->242|285->253|285->253|294->262|294->262|303->271|303->271|312->280|312->280|321->289|321->289|330->298|330->298|344->312|344->312|345->313|345->313
                  -- GENERATED --
              */
          