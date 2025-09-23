
package views.html.telco.buyPackage

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

object Utilities_recharge extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="accordion-body">
  <ul class="nav nav-tabs" role="tablist">
    <li class="nav-item" role="presentation" onclick="">
      <a class="nav-link active" data-bs-toggle="tab" href="#recharge" role="tab" aria-selected="false">
        <label class="text-recharge-1 align-items-center" style="margin-left: 5px">"""),_display_(/*5.85*/Messages("Nạp tiền")),format.raw/*5.105*/("""</label>
      </a>
    </li>
    <li class="nav-item" role="presentation" onclick="">
      <a class="nav-link" data-bs-toggle="tab" href="#historyRecharge" role="tab" aria-selected="false">
        <label class="text-recharge-1 align-items-center" style="margin-left: 5px">"""),_display_(/*10.85*/Messages("Lịch sử nạp tiền")),format.raw/*10.113*/("""</label>
      </a>
    </li>
  </ul>
  <div class="tab-content tab-recharge" style="">
    <div class="tab-pane fade show active" id="recharge" role="tabpanel">
      <div class="row">
        <div class="col-md-8">
          <label class="text-recharge-2 mt-3" style="float: left">"""),_display_(/*18.68*/Messages("Thông tin nạp tiền")),format.raw/*18.98*/("""</label>
          <div class="row mt-5">
            <label class="col-sm-3 col-form-label">"""),_display_(/*20.53*/Messages("Tài khoản")),format.raw/*20.74*/("""</label>
            <div class="col-sm-6">
              <select class="form-control">
                <option selected>"""),_display_(/*23.35*/Messages("Tài khoản viễn thông")),format.raw/*23.67*/("""</option>
              </select>
            </div>
          </div>
          <div class="row mt-3">
            <label class="col-sm-3 col-form-label">"""),_display_(/*28.53*/Messages("Số tiền (nạp cho 1 TB)")),format.raw/*28.87*/("""</label>
            <div class="col-sm-6">
              <input type="number" class="form-control" id="moneyRecharge" onchange="inputMoneyRechargeSubs(this)" pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==7) return false;" placeholder=""""),_display_(/*30.208*/Messages("Nhập số tiền thanh toán tối thiểu 5.000đ")),format.raw/*30.260*/("""">
            </div>
          </div>
          <div class="row mt-3">
            <label class="col-sm-3 col-form-label">"""),_display_(/*34.53*/Messages("")),format.raw/*34.65*/("""</label>
            <div class="col-sm-8">
              <button type="button" class="btn btn-light mt-1 px-3 button-money" onclick="chooseMoneyNap(10000)">10.000đ</button>
              <button type="button" class="btn btn-light mt-1 px-3 button-money" onclick="chooseMoneyNap(20000)">20.000đ</button>
              <button type="button" class="btn btn-light mt-1 px-3 button-money" onclick="chooseMoneyNap(50000)">50.000đ</button>
              <button type="button" class="btn btn-light mt-1 px-3 button-money" onclick="chooseMoneyNap(100000)">100.000đ</button>
              <button type="button" class="btn btn-light mt-1 px-3 button-money" onclick="chooseMoneyNap(200000)">200.000đ</button>
            </div>
          </div>
          <div class="modal-footer mt-3">
            <button type="button" class="btn" onclick="" data-bs-toggle="modal" data-bs-target="#importRechargeSubsModal" style="background: #FFFFFF;border: 1px solid #EA0033;border-radius: 8px 8px 8px 0px;color: #EA0033;">"""),_display_(/*44.225*/Messages("Tải danh sách")),format.raw/*44.250*/("""</button>
          </div>
        </div>

        <div class="col-md-4" style="border-left: 1px solid #C0C0C0;">
          <label class="text-recharge-2 mt-3" style="float: left">"""),_display_(/*49.68*/Messages("Thanh toán")),format.raw/*49.90*/("""</label>
          <div class="row mt-5">
            <table class="table" style="width: 100%;">
              <tbody>
                <tr>
                  <td>"""),_display_(/*54.24*/Messages("Số tiền (nạp cho 1 TB):")),format.raw/*54.59*/("""</td>
                  <td id="moneyRechargeOneSub" class="text-recharge-3"></td>
                </tr>
                <tr>
                  <td>"""),_display_(/*58.24*/Messages("Số thuê bao:")),format.raw/*58.48*/("""</td>
                  <td id="countRechargeSub" class="text-recharge-3"></td>
                </tr>
                <tr>
                  <td class="text-recharge-3">"""),_display_(/*62.48*/Messages("Tổng thanh toán:")),format.raw/*62.76*/("""</td>
                  <td id="totalRecharge" class="text-recharge-3"></td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="modal-footer mt-3">
            <button type="button" class="btn btn-red cursor-pointer" onclick="comfirmProcessRechargeSubs()" style="border-radius: 8px 8px 8px 0px;" id="buttonRecharge" disabled>"""),_display_(/*69.179*/Messages("Thanh toán")),format.raw/*69.201*/("""</button>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="row mt-1" id="dataImportRechargeSubs" style="padding: 15px;"></div>
      </div>

    </div>
    <div class="tab-pane fade" id="historyRecharge" style="margin-bottom: 2rem;" role="tabpanel">
      <div class="card" style="border: 0px;">
        <div class="table-responsive mt-3">
          <table class="table table-striped" id="listHistoryRechargeTable" style="width: 100%;">
            <thead style="background-color: #FBCCD6;">
              <tr>
                <th>STT</th>
                <th>Order ID</th>
                <th>Thuê bao</th>
                <th>Thao tác</th>
                <th>Số tiền</th>
                <th>Tổng tiền</th>
                <th>Trạng thái</th>
                <th>Mô tả</th>
                <th>Thời gian</th>
              </tr>
            </thead>
            <tbody></tbody>
          </table>
          <h5 id="notiNotDataHistory" style="text-align: center;"></h5>
        </div>
        <div class="material-datatables row row-cols-auto g-3" style="margin-bottom: 5px; margin-bottom: 10px;" id="divPagingTableHistoryRecharge">
          <input name="pageHistoryRecharge" id="pageHistoryRecharge" value="1" style="display: none">
          <input name="pageSizeHistoryRecharge" id="pageSizeHistoryRecharge" value="15" style="display: none">
          <div class="dataTables_paginate paging_full_numbers" id="pagingTableHistoryRecharge" style="cursor: pointer; right: 0px; position: absolute;"></div>
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
                  DATE: Mon Sep 22 16:32:51 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/buyPackage/Utilities_recharge.scala.html
                  HASH: 916c674b31fe0e7672ceaa189ac0e3aaab2a0df4
                  MATRIX: 1060->0|1404->318|1445->338|1748->614|1798->642|2109->926|2160->956|2281->1050|2323->1071|2472->1193|2525->1225|2707->1380|2762->1414|3041->1665|3115->1717|3266->1841|3299->1853|4327->2853|4374->2878|4582->3059|4625->3081|4815->3244|4871->3279|5047->3428|5092->3452|5289->3622|5338->3650|5746->4030|5790->4052
                  LINES: 33->1|37->5|37->5|42->10|42->10|50->18|50->18|52->20|52->20|55->23|55->23|60->28|60->28|62->30|62->30|66->34|66->34|76->44|76->44|81->49|81->49|86->54|86->54|90->58|90->58|94->62|94->62|101->69|101->69
                  -- GENERATED --
              */
          