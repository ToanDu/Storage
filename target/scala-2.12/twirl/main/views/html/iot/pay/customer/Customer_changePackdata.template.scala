
package views.html.iot.pay.customer

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

object Customer_changePackdata extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="changePackDataModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("packdata.change")),format.raw/*5.95*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12">
            <div class="row">
              <div class="col-md-3">
                <div class="card" style="padding: 15px; height: 100%; overflow: auto; max-height: 71vh;">
                  <div class="input-group mt-2">
                    <span class="input-group-text" onclick=""><i class='bx bx-search-alt'></i></span>
                    <input id="searchPackChange" class="search-input form-control border-start-0" placeholder="" maxlength="30">
                  </div>
                  <div class="panel-body" style="padding: 2px 2px 2px 2px; overflow-y: auto;" >
                    <div style="width: 100%; overflow: auto; height: 100%;padding: 10px;" id="listPackData">
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-9">
                <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
                  <span class="input-group-text" style="width: 100%; background-color:#aaa; color: #FFFFFF; text-transform: uppercase; font-weight: normal;">"""),_display_(/*25.159*/Messages("Thông tin gói cước")),format.raw/*25.189*/("""</span>
                </div>
                <div class="card" style="padding: 15px; border: 1px solid #858687;">
                  <div class="row">
                    <div class="col-md-6">
                      <div class="row mb-1">
                        <h4 class="col-sm-12 col-form-label" id="idPackDataInfoNew">"""),_display_(/*31.86*/Messages("ID: ")),format.raw/*31.102*/("""</h4>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="row mb-1">
                        <h4 class="col-sm-12 col-form-label" id="namePackDataInfoNew">"""),_display_(/*36.88*/Messages("packdata.name")),format.raw/*36.113*/("""</h4>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="row mb-1">
                        <h4 class="col-sm-12 col-form-label" id="typePackDataInfoNew">"""),_display_(/*41.88*/Messages("Loại gói")),format.raw/*41.108*/("""</h4>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="row mb-1">
                        <h4 class="col-sm-12 col-form-label" id="statusPackDataInfoNew">"""),_display_(/*46.90*/Messages("Trạng thái")),format.raw/*46.112*/("""</h4>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="row mb-1">
                        <h4 class="col-sm-12 col-form-label" id="contentPackDataInfoNew">"""),_display_(/*51.91*/Messages("packdata.content")),format.raw/*51.119*/("""</h4>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="row mb-1">
                        <h4 class="col-sm-12 col-form-label" id="datePackDataInfoNew">"""),_display_(/*56.88*/Messages("Ngày tạo")),format.raw/*56.108*/("""</h4>
                      </div>
                    </div>
                  </div>
                </div>

                <div class="card" style="padding: 15px; border: 1px solid #858687;">
                  <div class="row">
                    <div class="col-md-6">
                      <div class="row mb-1">
                        <label class="col-sm-5 col-form-label" >"""),_display_(/*66.66*/Messages("Loại dịch vụ")),format.raw/*66.90*/("""</label>
                        <div class="col-sm-7">
                          <input id="serviceTypeNew" type="text" class="form-control" autocomplete="off" readonly>
                        </div>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="row mb-1">
                        <label class="col-sm-5 col-form-label" >"""),_display_(/*74.66*/Messages("Số lượng đăng kí")),format.raw/*74.94*/("""</label>
                        <div class="col-sm-7" id="planLvNew">
                          <input id="registerNew" type="number" class="form-control" autocomplete="off" value="0" required>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>

                <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
                  <span class="input-group-text" style="width: 100%; background-color:#aaa; color: #FFFFFF; text-transform: uppercase; font-weight: normal;">"""),_display_(/*84.159*/Messages("So sánh với gói cước hiện tại")),format.raw/*84.200*/("""</span>
                </div>
                <div class="card" style="padding: 15px; border: 1px solid #858687;">
                  <div class="card-body">
                    <div class="table-responsive" id="divTablePackdata">
                      <table class="table mb-0 table-striped">
                        <thead>
                          <tr>
                            <th scope="col"></th>
                            <th scope="col" id="namePackCurrent">"""),_display_(/*93.67*/Messages("Gói hiện tại: Chưa có")),format.raw/*93.100*/("""</th>
                            <th scope="col" id="namePackNew">"""),_display_(/*94.63*/Messages("Gói mới: Chưa chọn")),format.raw/*94.93*/("""</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <th>"""),_display_(/*99.34*/Messages("Phương thức thanh toán")),format.raw/*99.68*/("""</th>
                            <th id="paymentTypeCurrent">"""),_display_(/*100.58*/Messages("")),format.raw/*100.70*/("""</th>
                            <th id="paymentTypeNew">"""),_display_(/*101.54*/Messages("")),format.raw/*101.66*/("""</th>
                          </tr>
                          <tr>
                            <th>"""),_display_(/*104.34*/Messages("Loại chu kỳ tính tiền")),format.raw/*104.67*/("""</th>
                            <th id="typePeriodCurrent">"""),_display_(/*105.57*/Messages("")),format.raw/*105.69*/("""</th>
                            <th id="typePeriodNew">"""),_display_(/*106.53*/Messages("")),format.raw/*106.65*/("""</th>
                          </tr>
                          <tr>
                            <th>"""),_display_(/*109.34*/Messages("Chu kì tính tiền")),format.raw/*109.62*/("""</th>
                            <th id="periodCurrent">"""),_display_(/*110.53*/Messages("")),format.raw/*110.65*/("""</th>
                            <th id="periodNew">"""),_display_(/*111.49*/Messages("")),format.raw/*111.61*/("""</th>
                          </tr>
                          <tr>
                            <th>"""),_display_(/*114.34*/Messages("Chi phí cố định hàng kỳ")),format.raw/*114.69*/("""</th>
                            <th id="fixCostCurrent">"""),_display_(/*115.54*/Messages("")),format.raw/*115.66*/("""</th>
                            <th id="fixCostNew">"""),_display_(/*116.50*/Messages("")),format.raw/*116.62*/("""</th>
                          </tr>
                          <tr>
                            <th>"""),_display_(/*119.34*/Messages("Đơn vị tính")),format.raw/*119.57*/("""</th>
                            <th id="chargingUnitCurrent">"""),_display_(/*120.59*/Messages("")),format.raw/*120.71*/("""</th>
                            <th id="chargingUnitNew">"""),_display_(/*121.55*/Messages("")),format.raw/*121.67*/("""</th>
                          </tr>
                          <tr>
                            <th>"""),_display_(/*124.34*/Messages("Phương pháp định giá")),format.raw/*124.66*/("""</th>
                            <th id="estimateCurrent">"""),_display_(/*125.55*/Messages("")),format.raw/*125.67*/("""</th>
                            <th id="estimateNew">"""),_display_(/*126.51*/Messages("")),format.raw/*126.63*/("""</th>
                          </tr>
                          <tr>
                            <th>"""),_display_(/*129.34*/Messages("Số tiền")),format.raw/*129.53*/("""</th>
                            <th id="priceCurrent">"""),_display_(/*130.52*/Messages("")),format.raw/*130.64*/("""</th>
                            <th id="priceNew">"""),_display_(/*131.48*/Messages("")),format.raw/*131.60*/("""</th>
                          </tr>
                          <tr>
                            <th>"""),_display_(/*134.34*/Messages("Số lượng miễn phí")),format.raw/*134.63*/("""</th>
                            <th id="numberFreeCurrent">"""),_display_(/*135.57*/Messages("")),format.raw/*135.69*/("""</th>
                            <th id="numberFreeNew">"""),_display_(/*136.53*/Messages("")),format.raw/*136.65*/("""</th>
                          </tr>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-danger" onclick="processChangePackdataForUser()" data-bs-dismiss="modal">"""),_display_(/*147.126*/Messages("btnSave")),format.raw/*147.145*/("""</button>
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*148.88*/Messages("btnClose")),format.raw/*148.108*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/pay/customer/Customer_changePackdata.scala.html
                  HASH: 001cc66306b2047485977bc31f86fd402f96e5f2
                  MATRIX: 1065->0|1436->345|1483->372|2698->1559|2750->1589|3102->1914|3140->1930|3404->2167|3451->2192|3715->2429|3757->2449|4023->2688|4067->2710|4334->2950|4384->2978|4648->3215|4690->3235|5102->3620|5147->3644|5585->4055|5634->4083|6254->4675|6317->4716|6817->5189|6872->5222|6967->5290|7018->5320|7212->5487|7267->5521|7358->5584|7392->5596|7479->5655|7513->5667|7643->5769|7698->5802|7788->5864|7822->5876|7908->5934|7942->5946|8072->6048|8122->6076|8208->6134|8242->6146|8324->6200|8358->6212|8488->6314|8545->6349|8632->6408|8666->6420|8749->6475|8783->6487|8913->6589|8958->6612|9050->6676|9084->6688|9172->6748|9206->6760|9336->6862|9390->6894|9478->6954|9512->6966|9596->7022|9630->7034|9760->7136|9801->7155|9886->7212|9920->7224|10001->7277|10035->7289|10165->7391|10216->7420|10306->7482|10340->7494|10426->7552|10460->7564|10871->7946|10913->7965|11038->8062|11081->8082
                  LINES: 33->1|37->5|37->5|57->25|57->25|63->31|63->31|68->36|68->36|73->41|73->41|78->46|78->46|83->51|83->51|88->56|88->56|98->66|98->66|106->74|106->74|116->84|116->84|125->93|125->93|126->94|126->94|131->99|131->99|132->100|132->100|133->101|133->101|136->104|136->104|137->105|137->105|138->106|138->106|141->109|141->109|142->110|142->110|143->111|143->111|146->114|146->114|147->115|147->115|148->116|148->116|151->119|151->119|152->120|152->120|153->121|153->121|156->124|156->124|157->125|157->125|158->126|158->126|161->129|161->129|162->130|162->130|163->131|163->131|166->134|166->134|167->135|167->135|168->136|168->136|179->147|179->147|180->148|180->148
                  -- GENERATED --
              */
          