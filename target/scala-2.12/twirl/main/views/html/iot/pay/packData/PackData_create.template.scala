
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

object PackData_create extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addPackDataModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16" style="width: 150%; right: 25%;">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("packdata.add")),format.raw/*5.92*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12">
            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" style="width: 100%; background-color:#858687; color: #FFFFFF; text-transform: uppercase;">"""),_display_(/*11.137*/Messages("packdata.info")),format.raw/*11.162*/("""</span>
            </div>
            <div class="card" style="padding: 20px; border: 1px solid #858687;">
              <div class="row">
                <div class="col-md-6">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*17.61*/Messages("packdata.name")),format.raw/*17.86*/("""</label>
                    <div class="col-sm-8">
                      <input id="namePackDataAdd" type="text" class="form-control" maxlength="30" autocomplete="off" required>
                      <br>
                      <h7 class="textNote">"""),_display_(/*21.45*/Messages("manage.group.org.30char")),format.raw/*21.80*/("""</h7>
                    </div>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*27.61*/Messages("packdata.content")),format.raw/*27.89*/("""</label>
                    <div class="col-sm-8">
                      <textarea id="contentPackDataAdd" type="text" rows="4" cols="25" maxlength="500"></textarea>
                    </div>
                  </div>
                </div>

                <div class="col-md-6">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*36.61*/Messages("Loại gói")),format.raw/*36.81*/("""</label>
                    <div class="col-sm-8">
                      <select id="typePackDataAdd" class="form-select" aria-label="select">
                        <option value="official" selected>"""),_display_(/*39.60*/Messages("Chính thức")),format.raw/*39.82*/("""</option>
                        <option value="trial">"""),_display_(/*40.48*/Messages("Dùng thử")),format.raw/*40.68*/("""</option>
                      </select>
                    </div>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*47.61*/Messages("Trạng thái")),format.raw/*47.83*/("""</label>
                    <div class="col-sm-8">
                      <select id="statusPackDataAdd" class="form-select" aria-label="select">
                        <option value="present" selected>"""),_display_(/*50.59*/Messages("Hiện")),format.raw/*50.75*/("""</option>
                        <option value="hidden">"""),_display_(/*51.49*/Messages("Ẩn")),format.raw/*51.63*/("""</option>
                      </select>
                    </div>
                  </div>
                </div>

              </div>
            </div>

            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" style="width: 100%; background-color:#858687; color: #FFFFFF; text-transform: uppercase;">"""),_display_(/*61.137*/Messages("packdata.data")),format.raw/*61.162*/("""</span>
            </div>
            <div class="card" style="padding: 20px; border: 1px solid #858687;">
              <div class="row">
                <div class="col-md-6">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*67.61*/Messages("Thời điểm thanh toán")),format.raw/*67.93*/("""</label>
                    <div class="col-sm-8">
                      <select id="paymentTypeAdd" onchange="choosePaymentType()" class="form-select" aria-label="select">
                        <option value="PREPAY" selected>"""),_display_(/*70.58*/Messages("Trả trước")),format.raw/*70.79*/("""</option>
                        <option value="POSTPAID">"""),_display_(/*71.51*/Messages("Trả sau")),format.raw/*71.70*/("""</option>
                      </select>
                    </div>
                  </div>
                </div>
                <div class="col-md-6" >
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*78.61*/Messages("Loại chu kỳ tính tiền")),format.raw/*78.94*/("""</label>
                    <div class="col-sm-8">
                      <select id="typePeriodAdd" onchange="choosePeriodType()" class="form-select" aria-label="select">
                        <option value="PERIODIC" selected>"""),_display_(/*81.60*/Messages("Định kỳ")),format.raw/*81.79*/("""</option>
                        <option value="ONCE">"""),_display_(/*82.47*/Messages("Một lần")),format.raw/*82.66*/("""</option>
                      </select>
                    </div>
                  </div>
                </div>

                <div class="col-md-6" id="divCalUnitAdd" style="display: block;">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*90.61*/Messages("Chu kì tính tiền")),format.raw/*90.89*/("""</label>
                    <div class="col-sm-4">
                      <input id="periodAdd" type="number" value="1" class="form-control" max="1000" autocomplete="off" required>
                    </div>
                    <div class="col-sm-4">
                      <select id="calUnitAdd" class="form-select" aria-label="select">
                        <option value="day">"""),_display_(/*96.46*/Messages("Ngày")),format.raw/*96.62*/("""</option>
                        <option value="week">"""),_display_(/*97.47*/Messages("Tuần")),format.raw/*97.63*/("""</option>
                        <option value="month" selected>"""),_display_(/*98.57*/Messages("Tháng")),format.raw/*98.74*/("""</option>
                        <option value="year">"""),_display_(/*99.47*/Messages("Năm")),format.raw/*99.62*/("""</option>
                      </select>
                    </div>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*106.61*/Messages("Chi phí cố định hàng kỳ (VND)")),format.raw/*106.102*/("""</label>
                    <div class="col-sm-8">
                      <input id="fixCostAdd" type="number" value="0" class="form-control" autocomplete="off" required>
                    </div>
                  </div>
                </div>

                <div class="col-md-6">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*115.61*/Messages("Đơn vị tính")),format.raw/*115.84*/("""</label>
                    <div class="col-sm-8">
                      <select id="chargingUnitAdd" class="form-select" aria-label="select">
                        <option value="message" selected>"""),_display_(/*118.59*/Messages("Kết nối")),format.raw/*118.78*/("""</option>
                        <option value="device">"""),_display_(/*119.49*/Messages("Thiết bị")),format.raw/*119.69*/("""</option>
                        <option value="api">"""),_display_(/*120.46*/Messages("API")),format.raw/*120.61*/("""</option>
                      </select>
                    </div>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*127.61*/Messages("Phương pháp định giá")),format.raw/*127.93*/("""</label>
                    <div class="col-sm-8">
                      <select id="estimateAdd" class="form-select" aria-label="select" onchange="changeEstimateAdd()">
                        <option value="fix" selected>"""),_display_(/*130.55*/Messages("Cố định")),format.raw/*130.74*/("""</option>
                        <option value="unit">"""),_display_(/*131.47*/Messages("Theo đơn vị")),format.raw/*131.70*/("""</option>
                        <option value="mass">"""),_display_(/*132.47*/Messages("Khối lượng")),format.raw/*132.69*/("""</option>
                        <option value="accumulated">"""),_display_(/*133.54*/Messages("Lũy kế")),format.raw/*133.72*/("""</option>
                        <option value="step">"""),_display_(/*134.47*/Messages("Bậc thang")),format.raw/*134.68*/("""</option>
                      </select>
                    </div>
                  </div>
                </div>

                <div class="col-md-6" id="divPriceAdd" style="display: block;">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*142.61*/Messages("Số tiền (VND)")),format.raw/*142.86*/("""</label>
                    <div class="col-sm-8">
                      <input id="priceAdd" type="number" class="form-control" autocomplete="off" value="0" required>
                    </div>
                  </div>
                </div>
                <div class="col-md-6" id="divNumberFreeAdd" style="display: none;">
                  <div class="row mb-4">
                    <label class="col-sm-4 col-form-label">"""),_display_(/*150.61*/Messages("Số lượng miễn phí")),format.raw/*150.90*/("""</label>
                    <div class="col-sm-8">
                      <input id="numberFreeAdd" type="number" class="form-control" autocomplete="off" value="0" required>
                    </div>
                  </div>
                </div>

              </div>
            </div>

            """),format.raw/*160.27*/("""
            """),format.raw/*161.13*/("""<div id="tabPlanLevel" style="display: none;">
              <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
                <span class="input-group-text" style="width: 100%; background-color:#858687; color: #FFFFFF; text-transform: uppercase;" id="namePlanLevelAdd"></span>
              </div>
              <div class="card" style="padding: 20px; border: 1px solid #858687;" >
                <div class="row">
                  <div class="col-sm-1">
                    <div class="row">
                      <div class="col-md-12 mt-2">
                        <button type="button" class="btn btn-dark" style="font-size: 24px; cursor: pointer; float: left;" onclick="appendPlanLevelAdd()">
                          <i class="bx bx-plus me-0"></i>
                        </button>
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-11" id="planLevelAdd">
                    <div class="row">
                      <div class="col-md-3">
                        <div class="row mb-4">
                          <label class="col-sm-6 col-form-label" style="text-align: right;">"""),_display_(/*180.94*/Messages("Từ 1 đến")),format.raw/*180.114*/("""</label>
                          <div class="col-sm-6">
                            <input id="levelPlanAdd0" type="number" class="form-control" autocomplete="off" value="0" required>
                          </div>
                        </div>
                      </div>
                      <div class="col-md-5">
                        <div class="row mb-4">
                          <label class="col-sm-5 col-form-label" style="text-align: right;">"""),_display_(/*188.94*/Messages("Đơn giá")),format.raw/*188.113*/("""</label>
                          <div class="col-sm-7">
                            <input id="pricePlanAdd0" type="number" class="form-control" autocomplete="off" value="0" required>
                          </div>
                        </div>
                      </div>
                      <div class="col-md-3">
                        <div class="row mb-4">
                          <label class="col-sm-6 col-form-label" style="text-align: right;">"""),_display_(/*196.94*/Messages("Miễn phí")),format.raw/*196.114*/("""</label>
                          <div class="col-sm-6">
                            <input id="freePlanAdd0" type="number" class="form-control" autocomplete="off" value="0" required>
                          </div>
                        </div>
                      </div>
                      <div class="col-md-1">
                        <div class="row mb-4">
                          <i class="bx bx-trash icon-remove-cond" style="font-size: 24px; cursor: pointer" onclick="removeCondition(this)"></i>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>

              </div>
            </div>

            <div class="card" style="padding: 20px; border: 1px solid #858687;" id="tabMoneyBuyPlanAdd">
              <h4>"""),_display_(/*215.20*/Messages("Ước tính số tiền thanh toán")),format.raw/*215.59*/("""</h4>
              <div class="col-sm-12">
                <div class="row">
                  <label class="col-sm-3 col-form-label" style="text-align: right;">"""),_display_(/*218.86*/Messages("Nếu khách mua")),format.raw/*218.111*/("""</label>
                  <div class="col-sm-3">
                    <input id="numberBuyPlanAdd" type="number" class="form-control" autocomplete="off" required>
                  </div>
                  <label class="col-sm-6 col-form-label" id="moneyBuyPlanAdd">"""),_display_(/*222.80*/Messages(" thì tổng số tiền phải thanh toán là 0 VND")),format.raw/*222.134*/("""</label>
                </div>
              </div>
            </div>


            <div class="modal-footer">
              <button type="button" class="btn btn-danger" onclick="processCreatePackdata()" data-bs-dismiss="modal">"""),_display_(/*229.119*/Messages("btnSave")),format.raw/*229.138*/("""</button>
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*230.88*/Messages("btnClose")),format.raw/*230.108*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/pay/packData/PackData_create.scala.html
                  HASH: 8a1a634d47388f0ab7106288184db91dfa97bea5
                  MATRIX: 1057->0|1458->375|1502->399|1875->744|1922->769|2229->1049|2275->1074|2552->1324|2608->1359|2856->1580|2905->1608|3315->1991|3356->2011|3586->2214|3629->2236|3713->2293|3754->2313|4038->2570|4081->2592|4312->2796|4349->2812|4434->2870|4469->2884|4891->3278|4938->3303|5245->3583|5298->3615|5556->3846|5598->3867|5685->3927|5725->3946|6010->4204|6064->4237|6322->4468|6362->4487|6445->4543|6485->4562|6813->4863|6862->4891|7272->5274|7309->5290|7392->5346|7429->5362|7522->5428|7560->5445|7643->5501|7679->5516|7964->5773|8028->5814|8443->6201|8488->6224|8718->6426|8759->6445|8845->6503|8887->6523|8970->6578|9007->6593|9292->6850|9346->6882|9599->7107|9640->7126|9724->7182|9769->7205|9853->7261|9897->7283|9988->7346|10028->7364|10112->7420|10155->7441|10482->7740|10529->7765|10986->8194|11037->8223|11369->8540|11411->8553|12633->9747|12676->9767|13168->10231|13210->10250|13702->10714|13745->10734|14588->11549|14649->11588|14840->11751|14888->11776|15183->12043|15260->12097|15520->12328|15562->12347|15687->12444|15730->12464
                  LINES: 33->1|37->5|37->5|43->11|43->11|49->17|49->17|53->21|53->21|59->27|59->27|68->36|68->36|71->39|71->39|72->40|72->40|79->47|79->47|82->50|82->50|83->51|83->51|93->61|93->61|99->67|99->67|102->70|102->70|103->71|103->71|110->78|110->78|113->81|113->81|114->82|114->82|122->90|122->90|128->96|128->96|129->97|129->97|130->98|130->98|131->99|131->99|138->106|138->106|147->115|147->115|150->118|150->118|151->119|151->119|152->120|152->120|159->127|159->127|162->130|162->130|163->131|163->131|164->132|164->132|165->133|165->133|166->134|166->134|174->142|174->142|182->150|182->150|192->160|193->161|212->180|212->180|220->188|220->188|228->196|228->196|247->215|247->215|250->218|250->218|254->222|254->222|261->229|261->229|262->230|262->230
                  -- GENERATED --
              */
          