
package views.html.iot.pay.packData

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

object PackData_edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editPackDataModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16" style="width: 150%; right: 25%;">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("packdata.edit")),format.raw/*5.93*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12">
            <input id="idPackDataEdit" type="text" class="form-control" maxlength="30" autocomplete="off" hidden>

            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" style="width: 100%; background-color:#858687; color: #FFFFFF; text-transform: uppercase;">"""),_display_(/*13.137*/Messages("packdata.info")),format.raw/*13.162*/("""</span>
            </div>
            <div class="card" style="padding: 20px; border: 1px solid #858687;">
              <div class="row">
                <div class="col-md-6">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*19.61*/Messages("packdata.name")),format.raw/*19.86*/("""</label>
                    <div class="col-sm-8">
                      <input id="namePackDataEdit" type="text" class="form-control" maxlength="30" autocomplete="off" required>
                      <br>
                      <h7 class="textNote">"""),_display_(/*23.45*/Messages("manage.group.org.30char")),format.raw/*23.80*/("""</h7>
                    </div>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*29.61*/Messages("packdata.content")),format.raw/*29.89*/("""</label>
                    <div class="col-sm-8">
                      <textarea id="contentPackDataEdit" type="text" rows="4" cols="25" maxlength="500"></textarea>
                    </div>
                  </div>
                </div>

                <div class="col-md-6">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*38.61*/Messages("Loại gói")),format.raw/*38.81*/("""</label>
                    <div class="col-sm-8">
                      <select id="typePackDataEdit" class="form-select" aria-label="select">
                        <option value="offical">"""),_display_(/*41.50*/Messages("Chính thức")),format.raw/*41.72*/("""</option>
                        <option value="trial">"""),_display_(/*42.48*/Messages("Dùng thử")),format.raw/*42.68*/("""</option>
                      </select>
                    </div>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*49.61*/Messages("Trạng thái")),format.raw/*49.83*/("""</label>
                    <div class="col-sm-8">
                      <select id="statusPackDataEdit" class="form-select" aria-label="select">
                        <option value="present">"""),_display_(/*52.50*/Messages("Hiện")),format.raw/*52.66*/("""</option>
                        <option value="hidden">"""),_display_(/*53.49*/Messages("Ẩn")),format.raw/*53.63*/("""</option>
                      </select>
                    </div>
                  </div>
                </div>

              </div>
            </div>

            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" style="width: 100%; background-color:#858687; color: #FFFFFF; text-transform: uppercase;">"""),_display_(/*63.137*/Messages("packdata.data")),format.raw/*63.162*/("""</span>
            </div>
            <div class="card" style="padding: 20px; border: 1px solid #858687;">
              <div class="row">
                <div class="col-md-6">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*69.61*/Messages("Phương thức thanh toán")),format.raw/*69.95*/("""</label>
                    <div class="col-sm-8">
                      <select id="paymentTypeEdit" onchange="choosePaymentTypeEdit()" class="form-select" aria-label="select">
                        <option value="PREPAY">"""),_display_(/*72.49*/Messages("Trả trước")),format.raw/*72.70*/("""</option>
                        <option value="POSTPAID">"""),_display_(/*73.51*/Messages("Trả sau")),format.raw/*73.70*/("""</option>
                      </select>
                    </div>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*80.61*/Messages("Loại chu kỳ tính tiền")),format.raw/*80.94*/("""</label>
                    <div class="col-sm-8">
                      <select id="typePeriodEdit" onchange="choosePeriodTypeEdit()" class="form-select" aria-label="select">
                        <option value="PERIODIC">"""),_display_(/*83.51*/Messages("Định kỳ")),format.raw/*83.70*/("""</option>
                        <option value="ONCE">"""),_display_(/*84.47*/Messages("Một lần")),format.raw/*84.66*/("""</option>
                      </select>
                    </div>
                  </div>
                </div>

                <div class="col-md-6" id="divCalUnitEdit" style="display: block;">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*92.61*/Messages("Chu kì tính tiền")),format.raw/*92.89*/("""</label>
                    <div class="col-sm-4">
                      <input id="periodEdit" type="number" value="1" class="form-control" max="1000" autocomplete="off" required>
                    </div>
                    <div class="col-sm-4">
                      <select id="calUnitEdit" class="form-select" aria-label="select">
                        <option value="day">"""),_display_(/*98.46*/Messages("Ngày")),format.raw/*98.62*/("""</option>
                        <option value="week">"""),_display_(/*99.47*/Messages("Tuần")),format.raw/*99.63*/("""</option>
                        <option value="month">"""),_display_(/*100.48*/Messages("Tháng")),format.raw/*100.65*/("""</option>
                        <option value="year">"""),_display_(/*101.47*/Messages("Năm")),format.raw/*101.62*/("""</option>
                      </select>
                    </div>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*108.61*/Messages("Chi phí cố định hàng kỳ (VND)")),format.raw/*108.102*/("""</label>
                    <div class="col-sm-8">
                      <input id="fixCostEdit" type="number" value="0" class="form-control" autocomplete="off" required>
                    </div>
                  </div>
                </div>

                <div class="col-md-6">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*117.61*/Messages("Đơn vị tính")),format.raw/*117.84*/("""</label>
                    <div class="col-sm-8">
                      <select id="chargingUnitEdit" class="form-select" aria-label="select">
                        <option value="message">"""),_display_(/*120.50*/Messages("Kết nối")),format.raw/*120.69*/("""</option>
                        <option value="device">"""),_display_(/*121.49*/Messages("Thiết bị")),format.raw/*121.69*/("""</option>
                      </select>
                    </div>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*128.61*/Messages("Phương pháp định giá")),format.raw/*128.93*/("""</label>
                    <div class="col-sm-8">
                      <select id="estimateEdit" class="form-select" aria-label="select" onchange="changeEstimateEdit()">
                        <option value="fix">"""),_display_(/*131.46*/Messages("Cố định")),format.raw/*131.65*/("""</option>
                        <option value="unit">"""),_display_(/*132.47*/Messages("Theo đơn vị")),format.raw/*132.70*/("""</option>
                        <option value="mass">"""),_display_(/*133.47*/Messages("Khối lượng")),format.raw/*133.69*/("""</option>
                        <option value="accumulated">"""),_display_(/*134.54*/Messages("Lũy kế")),format.raw/*134.72*/("""</option>
                        <option value="step">"""),_display_(/*135.47*/Messages("Bậc thang")),format.raw/*135.68*/("""</option>
                      </select>
                    </div>
                  </div>
                </div>

                <div class="col-md-6" id="divPriceEdit" style="display: block;">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*143.61*/Messages("Số tiền (VND)")),format.raw/*143.86*/("""</label>
                    <div class="col-sm-8">
                      <input id="priceEdit" type="number" class="form-control" autocomplete="off" value="0" required>
                    </div>
                  </div>
                </div>
                <div class="col-md-6" id="divNumberFreeEdit" style="display: none;">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*151.61*/Messages("Số lượng miễn phí")),format.raw/*151.90*/("""</label>
                    <div class="col-sm-8">
                      <input id="numberFreeEdit" type="number" class="form-control" autocomplete="off" value="0" required>
                    </div>
                  </div>
                </div>

              </div>
            </div>

            """),format.raw/*161.27*/("""
            """),format.raw/*162.13*/("""<div id="tabPlanLevelEdit" style="display: none;">
              <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
                <span class="input-group-text" style="width: 100%; background-color:#858687; color: #FFFFFF; text-transform: uppercase;" id="namePlanLevelEdit"></span>
              </div>
              <div class="card" style="padding: 20px; border: 1px solid #858687;" >
                <div class="row">
                  <div class="col-sm-1">
                    <div class="row">
                      <div class="col-md-12 mt-2">
                        <button type="button" class="btn btn-dark" style="font-size: 24px; cursor: pointer; float: left;" onclick="appendPlanLevelEdit()">
                          <i class="bx bx-plus me-0"></i>
                        </button>
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-11" id="planLevelEdit">

                  </div>
                </div>

              </div>
            </div>

            <div class="card" style="padding: 20px; border: 1px solid #858687;" id="tabMoneyBuyPlanEdit">
              <h4>"""),_display_(/*186.20*/Messages("Ước tính số tiền thanh toán")),format.raw/*186.59*/("""</h4>
              <div class="col-sm-12">
                <div class="row">
                  <label class="col-sm-3 col-form-label" style="text-align: right;">"""),_display_(/*189.86*/Messages("Nếu khách mua")),format.raw/*189.111*/("""</label>
                  <div class="col-sm-3">
                    <input id="numberBuyPlanEdit" type="number" class="form-control" autocomplete="off" required>
                  </div>
                  <label class="col-sm-6 col-form-label" id="moneyBuyPlanEdit">"""),_display_(/*193.81*/Messages(" thì tổng số tiền phải thanh toán là 0 VND")),format.raw/*193.135*/("""</label>
                </div>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-danger" onclick="processEditPackdata()" data-bs-dismiss="modal">"""),_display_(/*199.117*/Messages("btnSave")),format.raw/*199.136*/("""</button>
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*200.88*/Messages("btnClose")),format.raw/*200.108*/("""</button>
            </div>
          </div>

        </div>
      </div>

    </div>
  </div> <!-- modal-bialog .// -->
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/pay/packData/PackData_edit.scala.html
                  HASH: 6df51a417dc340fbe2294bbb6bf64a6f306319a6
                  MATRIX: 1055->0|1457->376|1502->401|1990->861|2037->886|2344->1166|2390->1191|2668->1442|2724->1477|2972->1698|3021->1726|3432->2110|3473->2130|3694->2324|3737->2346|3821->2403|3862->2423|4146->2680|4189->2702|4412->2898|4449->2914|4534->2972|4569->2986|4991->3380|5038->3405|5345->3685|5400->3719|5654->3946|5696->3967|5783->4027|5823->4046|6107->4303|6161->4336|6415->4563|6455->4582|6538->4638|6578->4657|6907->4959|6956->4987|7368->5372|7405->5388|7488->5444|7525->5460|7610->5517|7649->5534|7733->5590|7770->5605|8055->5862|8119->5903|8535->6291|8580->6314|8802->6508|8843->6527|8929->6585|8971->6605|9256->6862|9310->6894|9556->7112|9597->7131|9681->7187|9726->7210|9810->7266|9854->7288|9945->7351|9985->7369|10069->7425|10112->7446|10440->7746|10487->7771|10946->8202|10997->8231|11330->8549|11372->8562|12594->9756|12655->9795|12846->9958|12894->9983|13191->10252|13268->10306|13525->10534|13567->10553|13692->10650|13735->10670
                  LINES: 33->1|37->5|37->5|45->13|45->13|51->19|51->19|55->23|55->23|61->29|61->29|70->38|70->38|73->41|73->41|74->42|74->42|81->49|81->49|84->52|84->52|85->53|85->53|95->63|95->63|101->69|101->69|104->72|104->72|105->73|105->73|112->80|112->80|115->83|115->83|116->84|116->84|124->92|124->92|130->98|130->98|131->99|131->99|132->100|132->100|133->101|133->101|140->108|140->108|149->117|149->117|152->120|152->120|153->121|153->121|160->128|160->128|163->131|163->131|164->132|164->132|165->133|165->133|166->134|166->134|167->135|167->135|175->143|175->143|183->151|183->151|193->161|194->162|218->186|218->186|221->189|221->189|225->193|225->193|231->199|231->199|232->200|232->200
                  -- GENERATED --
              */
          