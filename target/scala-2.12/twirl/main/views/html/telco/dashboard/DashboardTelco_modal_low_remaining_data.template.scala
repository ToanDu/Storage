
package views.html.telco.dashboard

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
/*1.2*/import helper._
/*2.2*/import vn.m2m.common.models.User

object DashboardTelco_modal_low_remaining_data extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.17*/("""
"""),format.raw/*4.1*/("""<div class="modal fade" id="modal_low_remaining_data" data-bs-backdrop="static" tabindex="-1" role="dialog"
  aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-xl modal-dialog-scrollable shadow-none">
    <div class="modal-content">
      <div class="modal-header pb-0">
        <h3 class="modal-title mb-3" id="title_modal_low_remaining_data" style="color: #001737;">"""),_display_(/*9.99*/Messages("Danh sách thuê bao có lưu lượng data còn lại dưới 20% ")),format.raw/*9.165*/("""</h3>
        <div class="row mb-1 text-start">
          <div class="col-md-1">
            <em>** Chú ý:</em>
          </div>
          <div class="col-md-11">
            <em>- Dữ liệu được thống kê dựa trên tổng dung lượng của mỗi gói data mà thuê bao đã đăng ký,  chu kì cập nhật dữ liệu 24h/1 lần.</em> <br>
            <em>- Các gói cước có chu kì data 1 ngày/1 lần có thể bị cảnh báo trễ.</em>
          </div>
        </div>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12" style="border-radius: 8px;">
            <table class="table table-striped" id="table_modal_low_remaining_data" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <th class="text-center">STT</th>
                <th class="text-center">Số thuê bao</th>
                <th class="text-center">GPKD</th>
                <th class="text-center">Gói cước</th>
                <th class="text-center">Dung lượng data còn lại</th>
                <th class="text-center">Thời gian cập nhật</th>
              </thead>
              <tbody></tbody>
            </table>
            <div>
              <input id="pageLowRemainingData" value="1" style="display: none">
              <input id="pageSizeLowRemainingData" value="10" style="display: none">
            </div>
          </div>
        </div>
      </div>
      <div class="modal-footer mt-1 pt-0" id="footer_modal_red_alert">
        <div class="row">
          <div class="col-md-4 d-flex align-items-center justify-content-center justify-content-md-start mb-3">
            <p class="mb-0">Tổng <span id="total_record_LowRemainingData">0</span> bản ghi</p>
          </div>
          <div
            class="col-md-8 d-flex flex-column flex-md-row justify-content-end align-items-center gap-2 gap-md-3 mb-3">
            <div class="dropdown mb-2 mb-md-0">
              <button class="btn btn-sm dropdown-toggle btn-outline-dark" type="button" data-bs-toggle="dropdown"
                aria-expanded="false" id="countPageLowRemainingData" style="margin-left: 5px;">
                10
              </button>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="javascript:applySearchLowRemainingData(1,10)">10</a></li>
                <li><a class="dropdown-item" href="javascript:applySearchLowRemainingData(1,50)">50</a></li>
                <li><a class="dropdown-item" href="javascript:applySearchLowRemainingData(1,100)">100</a></li>
                <li><a class="dropdown-item" href="javascript:applySearchLowRemainingData(1,200)">200</a></li>
                <li><a class="dropdown-item" href="javascript:applySearchLowRemainingData(1,500)">500</a></li>
              </ul>
            </div>
            <p class="mb-2 mb-md-0">"""),_display_(/*61.38*/Messages("Bản ghi/trang")),format.raw/*61.63*/("""</p>
            <div id="pagingTableLowRemainingData" class="justify-content-md-end"></div>
          </div>
      
        </div>
          <button type="button" class="btn btn-telco" style="background: #FFFFFF; color: #EA0033;"
          onclick="resetModalLowRemainingData()" data-bs-dismiss="modal">"""),_display_(/*67.75*/Messages("btnClose")),format.raw/*67.95*/("""</button>
        <button type="button" class="btn btn-telco" style="background: #FFFFFF; color: #EA0033;"
          onclick="downloadExcelLowRemainingData(1)">"""),_display_(/*69.55*/Messages("Export")),format.raw/*69.73*/("""</button>
        <a href=""""),_display_(/*70.19*/routes/*70.25*/.TelcoUtilitiesController.utilitiesManage(userId)),format.raw/*70.74*/("""" target="_blank" type="button" class="btn btn-telco"
          style="background: #EA0033; color: #FFFFFF; width: auto;">"""),_display_(/*71.70*/Messages("Mua gói Data")),format.raw/*71.94*/("""</a>
          
      </div>
    </div>
  </div>
</div>"""))
      }
    }
  }

  def render(userId:String): play.twirl.api.HtmlFormat.Appendable = apply(userId)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (userId) => apply(userId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:52 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/dashboard/DashboardTelco_modal_low_remaining_data.scala.html
                  HASH: f253c8e833cfc49584c246842f74601aa3c009f6
                  MATRIX: 667->1|690->18|1061->52|1171->67|1198->68|1652->496|1739->562|4584->3380|4630->3405|4962->3710|5003->3730|5191->3891|5230->3909|5285->3937|5300->3943|5370->3992|5520->4115|5565->4139
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|93->61|93->61|99->67|99->67|101->69|101->69|102->70|102->70|102->70|103->71|103->71
                  -- GENERATED --
              */
          