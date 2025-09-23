
package views.html.telco.utilities

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
        <label class="text-recharge-1 align-items-center" style="margin-left: 5px">"""),_display_(/*5.85*/Messages("utilities.recharge")),format.raw/*5.115*/("""</label>
      </a>
    </li>
    <li class="nav-item" role="presentation" onclick="">
      <a class="nav-link" data-bs-toggle="tab" href="#historyRecharge" role="tab" aria-selected="false">
        <label class="text-recharge-1 align-items-center" style="margin-left: 5px">"""),_display_(/*10.85*/Messages("utilities.rechargeHistory")),format.raw/*10.122*/("""</label>
      </a>
    </li>
  </ul>
  <div class="tab-content tab-recharge">
    <div class="tab-pane fade show active" id="recharge" role="tabpanel">
      <div class="row">
        <div class="col-md-8">
          <label class="text-recharge-2 mt-3" style="float: left">"""),_display_(/*18.68*/Messages("utilities.rechargeInfo")),format.raw/*18.102*/("""</label>
          <div class="row mt-5">
            <label class="col-sm-3 col-form-label">"""),_display_(/*20.53*/Messages("utilities.account")),format.raw/*20.82*/("""</label>
            <div class="col-sm-6">
              <select class="form-control">
                <option selected>"""),_display_(/*23.35*/Messages("utilities.telcoAccount")),format.raw/*23.69*/("""</option>
              </select>
            </div>
          </div>
          <div class="row mt-3">
            <label class="col-sm-3 col-form-label">"""),_display_(/*28.53*/Messages("utilities.amountPerSubscriber")),format.raw/*28.94*/("""</label>
            <div class="col-sm-6">
              <input type="number" class="form-control" id="moneyRecharge" onchange="inputMoneyRechargeSubs(this)" pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==7) return false;" placeholder=""""),_display_(/*30.208*/Messages("utilities.enterAmount")),format.raw/*30.241*/("""">
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
            <button type="button" class="btn" onclick="" data-bs-toggle="modal" data-bs-target="#importRechargeSubsModal" style="background: #FFFFFF;border: 1px solid #EA0033;border-radius: 8px 8px 8px 0px;color: #EA0033;">"""),_display_(/*44.225*/Messages("utilities.loadList")),format.raw/*44.255*/("""</button>
          </div>
        </div>

        <div class="col-md-4" style="border-left: 1px solid #C0C0C0;">
          <label class="text-recharge-2 mt-3" style="float: left">"""),_display_(/*49.68*/Messages("utilities.payment")),format.raw/*49.97*/("""</label>
          <div class="row mt-5">
            <table class="table" style="width: 100%;">
              <tbody>
                <tr>
                  <td>"""),_display_(/*54.24*/Messages("utilities.amountPerSubscriber")),format.raw/*54.65*/(""":</td>
                  <td id="moneyRechargeOneSub" class="text-recharge-3"></td>
                </tr>
                <tr>
                  <td>"""),_display_(/*58.24*/Messages("utilities.numberOfSubscribers")),format.raw/*58.65*/(""":</td>
                  <td id="countRechargeSub" class="text-recharge-3"></td>
                </tr>
                <tr>
                  <td class="text-recharge-3">"""),_display_(/*62.48*/Messages("utilities.totalPayment")),format.raw/*62.82*/(""":</td>
                  <td id="totalRecharge" class="text-recharge-3"></td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="modal-footer mt-3">
            <button type="button" class="btn btn-red cursor-pointer" onclick="comfirmProcessRechargeSubs()" style="border-radius: 8px 8px 8px 0px;" id="buttonRecharge" disabled>"""),_display_(/*69.179*/Messages("utilities.payNow")),format.raw/*69.207*/("""</button>
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
                <th>"""),_display_(/*86.22*/Messages("utilities.subscriber")),format.raw/*86.54*/("""</th>
                <th>"""),_display_(/*87.22*/Messages("utilities.action")),format.raw/*87.50*/("""</th>
                <th>"""),_display_(/*88.22*/Messages("utilities.amount")),format.raw/*88.50*/("""</th>
                <th>"""),_display_(/*89.22*/Messages("utilities.totalAmount")),format.raw/*89.55*/("""</th>
                <th>"""),_display_(/*90.22*/Messages("utilities.status")),format.raw/*90.50*/("""</th>
                <th>"""),_display_(/*91.22*/Messages("utilities.description")),format.raw/*91.55*/("""</th>
                <th>"""),_display_(/*92.22*/Messages("utilities.time")),format.raw/*92.48*/("""</th>
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
                  DATE: Mon Sep 22 16:32:55 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/utilities/Utilities_recharge.scala.html
                  HASH: 467ec7d5546ddb1cf76f0ac448e927321aab038e
                  MATRIX: 1059->0|1403->318|1454->348|1757->624|1816->661|2118->936|2174->970|2295->1064|2345->1093|2494->1215|2549->1249|2731->1404|2793->1445|3072->1696|3127->1729|3278->1853|3311->1865|4339->2865|4391->2895|4599->3076|4649->3105|4839->3268|4901->3309|5078->3459|5140->3500|5338->3671|5393->3705|5802->4086|5852->4114|6514->4749|6567->4781|6621->4808|6670->4836|6724->4863|6773->4891|6827->4918|6881->4951|6935->4978|6984->5006|7038->5033|7092->5066|7146->5093|7193->5119
                  LINES: 33->1|37->5|37->5|42->10|42->10|50->18|50->18|52->20|52->20|55->23|55->23|60->28|60->28|62->30|62->30|66->34|66->34|76->44|76->44|81->49|81->49|86->54|86->54|90->58|90->58|94->62|94->62|101->69|101->69|118->86|118->86|119->87|119->87|120->88|120->88|121->89|121->89|122->90|122->90|123->91|123->91|124->92|124->92
                  -- GENERATED --
              */
          