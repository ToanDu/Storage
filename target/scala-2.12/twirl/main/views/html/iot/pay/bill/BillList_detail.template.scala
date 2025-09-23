
package views.html.iot.pay.bill

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

object BillList_detail extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

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
                        """),format.raw/*68.100*/("""
                        """),format.raw/*69.97*/("""
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
                  <div class="row" id="tableDetailCost" >
                    <table class="table" style='width: 100%'>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/pay/bill/BillList_detail.scala.html
                  HASH: 1513804849bf0d07d745b70eb683b599019c6e45
                  MATRIX: 1053->0|1327->248|1375->276|1886->760|1942->794|2101->926|2145->949|2394->1171|2437->1193|2685->1414|2725->1433|3212->1893|3266->1925|3425->2057|3464->2075|3713->2297|3751->2314|3999->2535|4039->2554|4513->3001|4567->3033|4813->3252|4856->3274|5119->3510|5162->3532|5342->3710|5396->3810|5449->3907|5500->3940|5551->3963|5665->4050|5713->4077|6051->4388|6108->4423|6379->4667|6436->4702|6706->4945|6763->4980|7034->5224|7085->5254|7618->5759|7670->5788|7908->5998|7945->6013|8008->6048|8053->6071|8116->6106|8153->6121|8216->6156|8258->6176|8321->6211|8362->6230|8425->6265|8466->6284|9054->6844|9096->6864
                  LINES: 33->1|37->5|37->5|47->15|47->15|50->18|50->18|54->22|54->22|58->26|58->26|67->35|67->35|70->38|70->38|74->42|74->42|78->46|78->46|87->55|87->55|92->60|92->60|96->64|96->64|99->67|100->68|101->69|102->70|103->71|104->72|104->72|110->78|110->78|114->82|114->82|118->86|118->86|122->90|122->90|133->101|133->101|138->106|138->106|139->107|139->107|140->108|140->108|141->109|141->109|142->110|142->110|143->111|143->111|160->128|160->128
                  -- GENERATED --
              */
          