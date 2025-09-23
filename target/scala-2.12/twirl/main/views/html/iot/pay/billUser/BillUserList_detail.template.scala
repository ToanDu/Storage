
package views.html.iot.pay.billUser

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

object BillUserList_detail extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="detailBillModal" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16" style="">
      <div class="modal-header">
        <h5 class="modal-title text-white">"""),_display_(/*5.45*/Messages("Chi tiết hóa đơn")),format.raw/*5.73*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="form-group">
          <div class="card" style="padding: 20px; border: 1px solid #858687;">
            <div class="row">

              <div class="col-md-6">
                <div class="card-body" style="border: 1px solid #858687; border-radius: 20px; height: 100%;">
                  <div class="row mt-1 align-items-center">
                    <h4 class="col-sm-12 col-form-label" style="font-weight: 600;">"""),_display_(/*15.85*/Messages("Thông tin nhà cung cấp")),format.raw/*15.119*/("""</h4>
                  </div>
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*18.61*/Messages("Tên công ty")),format.raw/*18.84*/("""</label>
                    <label class="col-sm-8 col-form-label" id="tdDetailVName"></label>
                  </div>
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*22.61*/Messages("Mã số thuế")),format.raw/*22.83*/("""</label>
                    <label class="col-sm-8 col-form-label" id="tdDetailVTax"></label>
                  </div>
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*26.61*/Messages("Địa chỉ")),format.raw/*26.80*/("""</label>
                    <label class="col-sm-8 col-form-label" id="tdDetailVAddress"></label>
                  </div>
                </div>
              </div>

              <div class="col-md-6">
                <div class="card-body" style="border: 1px solid #858687; border-radius: 20px; height: 100%;">
                  <div class="row mt-1 align-items-center">
                    <h4 class="col-sm-12 col-form-label" style="font-weight: 600;">"""),_display_(/*35.85*/Messages("Thông tin khách hàng")),format.raw/*35.117*/("""</h4>
                  </div>
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*38.61*/Messages("Tên KH")),format.raw/*38.79*/("""</label>
                    <label class="col-sm-8 col-form-label" id="tdDetailCName"></label>
                  </div>
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*42.61*/Messages("Mã KH")),format.raw/*42.78*/("""</label>
                    <label class="col-sm-8 col-form-label" id="tdDetailCTax"></label>
                  </div>
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*46.61*/Messages("Địa chỉ")),format.raw/*46.80*/("""</label>
                    <label class="col-sm-8 col-form-label" id="tdDetailCAddress"></label>
                  </div>
                </div>
              </div>

              <div class="col-md-12 mt-3">
                <div class="card-body" style="border: 1px solid #858687; border-radius: 20px; height: 100%;">
                  <div class="row mt-1">
                    <h4 class="col-sm-12 col-form-label" style="font-weight: 600;">"""),_display_(/*55.85*/Messages("Thông tin thanh toán")),format.raw/*55.117*/("""</h4>
                  </div>
                  <div class="row">
                    <div class="col-md-5">
                      <div class="row mb-4">
                        <label class="col-sm-5 col-form-label">"""),_display_(/*60.65*/Messages("Mã hóa đơn")),format.raw/*60.87*/("""</label>
                        <label class="col-sm-7 col-form-label" id="tdDetailBId"></label>
                      </div>
                      <div class="row mb-4">
                        <label class="col-sm-5 col-form-label">"""),_display_(/*64.65*/Messages("Mã đăng ký")),format.raw/*64.87*/("""</label>
                        <label class="col-sm-7 col-form-label" id="tdDetailBSubId"></label>
                      </div>
                      """),format.raw/*67.49*/("""
                      """),format.raw/*68.98*/("""
                      """),format.raw/*69.95*/("""
                      """),format.raw/*70.33*/("""
                      """),format.raw/*71.23*/("""<div class="row mb-4">
                        <label class="col-sm-5 col-form-label">"""),_display_(/*72.65*/Messages("Dịch vụ sử dụng")),format.raw/*72.92*/("""</label>
                        <label class="col-sm-7 col-form-label" id="tdDetailSService"></label>
                      </div>
                    </div>
                    <div class="col-md-7">
                      <div class="row mb-4">
                        <label class="col-sm-6 col-form-label">"""),_display_(/*78.65*/Messages("Ngày yêu cầu thanh toán")),format.raw/*78.100*/("""</label>
                        <label class="col-sm-6 col-form-label" id="tdDetailDateRequest"></label>
                      </div>
                      <div class="row mb-4">
                        <label class="col-sm-6 col-form-label">"""),_display_(/*82.65*/Messages("Ngày hết hạn thanh toán")),format.raw/*82.100*/("""</label>
                        <label class="col-sm-6 col-form-label" id="tdDetailDateExpiry"></label>
                      </div>
                      <div class="row mb-4">
                        <label class="col-sm-6 col-form-label">"""),_display_(/*86.65*/Messages("Ngày thanh toán thực tế")),format.raw/*86.100*/("""</label>
                        <label class="col-sm-6 col-form-label" id="tdDetailDatePayment"></label>
                      </div>
                      <div class="row mb-4">
                        <label class="col-sm-6 col-form-label">"""),_display_(/*90.65*/Messages("Trạng thái hóa đơn")),format.raw/*90.95*/("""</label>
                        <label class="col-sm-6 col-form-label" id="tdDetailStatus"></label>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <div class="col-md-12 mt-3">
                <div class="card-body" style="border: 1px solid #858687; border-radius: 20px; height: 100%;">
                  <div class="row mt-1">
                    <h4 class="col-sm-12 col-form-label" style="font-weight: 600;">"""),_display_(/*101.85*/Messages("Thông tin dịch vụ")),format.raw/*101.114*/("""</h4>
                  </div>
                  <div class="row">
                    <table id="tableDetailCost" class="table" style='width: 100%'>
                      <thead>
                        <th>"""),_display_(/*106.30*/Messages("STT")),format.raw/*106.45*/("""</th>
                        <th>"""),_display_(/*107.30*/Messages("Tên dịch vụ")),format.raw/*107.53*/("""</th>
                        <th>"""),_display_(/*108.30*/Messages("ĐVT")),format.raw/*108.45*/("""</th>
                        <th>"""),_display_(/*109.30*/Messages("Số lượng")),format.raw/*109.50*/("""</th>
                        <th>"""),_display_(/*110.30*/Messages("Đơn giá")),format.raw/*110.49*/("""</th>
                        <th>"""),_display_(/*111.30*/Messages("Số tiền")),format.raw/*111.49*/("""</th>
                      </thead>
                      <tbody align="left">
                      </tbody>
                    </table>
                  </div>
                  <div class="row mt-1">
                    <h4 class="col-sm-12 col-form-label" style="font-style: oblique;" id="textCostTotal"></h4>
                  </div>
                </div>
              </div>

            </div>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*128.77*/Messages("btnClose")),format.raw/*128.97*/("""</button>
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
                  DATE: Mon Sep 22 16:32:45 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/pay/billUser/BillUserList_detail.scala.html
                  HASH: 3ee5fd3852be4a42ab41dba00242dc25e509627b
                  MATRIX: 1061->0|1335->248|1383->276|1894->760|1950->794|2109->926|2153->949|2402->1171|2445->1193|2693->1414|2733->1433|3220->1893|3274->1925|3433->2057|3472->2075|3721->2297|3759->2314|4007->2535|4047->2554|4521->3001|4575->3033|4821->3252|4864->3274|5127->3510|5170->3532|5350->3710|5401->3808|5452->3903|5503->3936|5554->3959|5668->4046|5716->4073|6054->4384|6111->4419|6382->4663|6439->4698|6709->4941|6766->4976|7037->5220|7088->5250|7621->5755|7673->5784|7910->5993|7947->6008|8010->6043|8055->6066|8118->6101|8155->6116|8218->6151|8260->6171|8323->6206|8364->6225|8427->6260|8468->6279|9056->6839|9098->6859
                  LINES: 33->1|37->5|37->5|47->15|47->15|50->18|50->18|54->22|54->22|58->26|58->26|67->35|67->35|70->38|70->38|74->42|74->42|78->46|78->46|87->55|87->55|92->60|92->60|96->64|96->64|99->67|100->68|101->69|102->70|103->71|104->72|104->72|110->78|110->78|114->82|114->82|118->86|118->86|122->90|122->90|133->101|133->101|138->106|138->106|139->107|139->107|140->108|140->108|141->109|141->109|142->110|142->110|143->111|143->111|160->128|160->128
                  -- GENERATED --
              */
          