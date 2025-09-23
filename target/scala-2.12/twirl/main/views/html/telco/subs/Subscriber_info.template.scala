
package views.html.telco.subs

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

object Subscriber_info extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="infoSubscriber" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">
      <div class="modal-header">
  <span class="modal-title" id="myModalLabel">"""),_display_(/*5.48*/Messages("subscriber.info.title")),format.raw/*5.81*/("""</span>
      </div>
      <div class="modal-body">
        <div class="row g-3">
          <div class="row">
            <span style="font-weight: 700;font-size: 16px;">"""),_display_(/*10.62*/Messages("subscriber.info.detailTitle")),format.raw/*10.101*/("""</span>
            <div class="row">
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*14.75*/Messages("subscriber.phoneNumber")),format.raw/*14.109*/("""</label>
                  <div class="col-sm-8">
                    <input id="isdnInfo" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*22.75*/Messages("subscriber.simSerial")),format.raw/*22.107*/("""</label>
                  <div class="col-sm-8">
                    <input id="serialInfo" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*30.75*/Messages("subscriber.type")),format.raw/*30.102*/("""</label>
                  <div class="col-sm-8">
                    <input id="typeInfo" type="text" class="form-control form-info" value="" readonly>
                  </div>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*41.75*/Messages("subscriber.serviceType")),format.raw/*41.109*/("""</label>
                  <div class="col-sm-8">
                    <input id="payTypeInfo" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*49.75*/Messages("subscriber.blockStatus")),format.raw/*49.109*/("""</label>
                  <div class="col-sm-8">
                    <input id="actStatusInfo" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*57.75*/Messages("subscriber.hybridAmount")),format.raw/*57.110*/("""</label>
                  <div class="col-sm-8">
                    <input id="moneyHybridInfo" type="text" class="form-control form-info" value="0" readonly>
                  </div>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*68.75*/Messages("subscriber.activation")),format.raw/*68.108*/("""</label>
                  <div class="col-sm-8">
                    <input id="staDatetimeInfo" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*76.75*/Messages("subscriber.connection")),format.raw/*76.108*/("""</label>
                  <div class="col-sm-8">
                    <input id="activeDatetimeInfo" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
              </div>
            </div>
          </div>
          <hr>

          """),format.raw/*88.21*/("""
          """),format.raw/*89.11*/("""<div class="row">
            <div class="row">
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*93.75*/Messages("subscriber.debtBeginPeriod")),format.raw/*93.113*/("""</label>
                  <div class="col-sm-8">
                    <input id="staOfCycleSubs" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*101.75*/Messages("subscriber.paidAmount")),format.raw/*101.108*/("""</label>
                  <div class="col-sm-8">
                    <input id="paymentSubs" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*109.75*/Messages("subscriber.remainingDebt")),format.raw/*109.111*/("""</label>
                  <div class="col-sm-8">
                    <input id="remainAmountSubs" type="text" class="form-control form-info" value="" readonly>
                  </div>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*120.75*/Messages("subscriber.adjustmentAmount")),format.raw/*120.114*/("""</label>
                  <div class="col-sm-8">
                    <input id="adjustAmountSubs" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*128.75*/Messages("subscriber.hotChargeTemp")),format.raw/*128.111*/("""</label>
                  <div class="col-sm-8">
                    <input id="hotChargeSubs" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
              </div>
            </div>
          </div>
          <hr>

          """),format.raw/*140.21*/("""
          """),format.raw/*141.11*/("""<div class="row">
            <div class="row">
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*145.75*/Messages("subscriber.mainPackage")),format.raw/*145.109*/("""</label>
                  <div class="col-sm-8">
                    <input id="productCodeSubs" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*153.75*/Messages("subscriber.export.column.dataRemaining")),format.raw/*153.125*/("""</label>
                    <div class="col-sm-8 d-flex align-items-center">
                    <input id="dataBalanceInfo" type="text" class="form-control form-info me-2" style="flex: 1;" readonly>
                    <select id="dataUnitSelect" class="form-select" style="flex: 0.2;" onchange="convertUnit('dataBalanceInfo', this)">
                      <option value="GB" selected>GB</option>
                      <option value="MB" selected>MB</option>
                      <option value="KB">KB</option>
                    </select>
                    </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*166.75*/Messages("subscriber.export.column.smsRemaining")),format.raw/*166.124*/("""</label>
                  <div class="col-sm-8">
                    <input id="smsBalanceInfo" type="text" class="form-control form-info" value="" readonly>
                  </div>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*177.75*/Messages("subscriber.export.column.voiceRemaining")),format.raw/*177.126*/("""</label>
                  <div class="col-sm-8">
                    <input id="voiceBalanceInfo" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*185.75*/Messages("subscriber.export.column.mainAccount")),format.raw/*185.123*/("""</label>
                  <div class="col-sm-8">
                    <input id="moneyBalanceInfo" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*193.75*/Messages("subscriber.export.column.promotionAccount")),format.raw/*193.128*/("""</label>
                  <div class="col-sm-8">
                    <input id="promotionBalanceInfo" type="text" class="form-control form-info" value="" readonly>
                  </div>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*204.75*/Messages("subscriber.export.column.intraNetworkAccount")),format.raw/*204.131*/("""</label>
                  <div class="col-sm-8">
                    <input id="promotionVtBalanceInfo" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*212.75*/Messages("subscriber.export.column.otherAccount")),format.raw/*212.124*/("""</label>
                  <div class="col-sm-8">
                    <input id="otherBalanceInfo" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*223.75*/Messages("subscriber.export.column.promotionCode")),format.raw/*223.125*/("""</label>
                  <div class="col-sm-8">
                    <input id="codeCtkm" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*231.75*/Messages("subscriber.export.column.promoName")),format.raw/*231.121*/("""</label>
                  <div class="col-sm-8">
                    <input id="nameCtkm" type="text" class="form-control form-info" value="" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*239.75*/Messages("subscriber.export.column.promoEffectDate")),format.raw/*239.127*/("""</label>
                  <div class="col-sm-8">
                    <input id="effectCtkm" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*247.75*/Messages("subscriber.export.column.promoExpireDate")),format.raw/*247.127*/("""</label>
                  <div class="col-sm-8">
                    <input id="expireCtkm" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*255.75*/Messages("subscriber.export.column.promoDescription")),format.raw/*255.128*/("""</label>
                  <div class="col-sm-8">
                    <input id="descriptionCtkm" type="text" class="form-control form-info" value="" readonly>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <hr>

          """),format.raw/*265.21*/("""
          """),format.raw/*266.11*/("""<div class="row">
            <div class="row mb-3">
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*270.75*/Messages("subscriber.info.apnDefault")),format.raw/*270.113*/("""</label>
                  <div class="col-sm-8">
                    <input id="apnDefault" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-8">
                <div class="row mt-3">
                  <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*278.75*/Messages("subscriber.info.apnPrivate")),format.raw/*278.113*/("""</label>
                    <div class="col-sm-10 d-flex align-items-center">
                    <input id="apnPrivate" type="text" class="form-control form-info" readonly>
                    </div>
                </div>
              </div>
            </div>
          </div>

          """),format.raw/*287.21*/("""
          """),format.raw/*288.11*/("""<div class="row">
            <span style="font-weight: 700;font-size: 16px;">"""),_display_(/*289.62*/Messages("subscriber.modal.info.addonListTitle")),format.raw/*289.110*/("""</span>
            <div class="table-responsive mb-3" style="border-radius: 8px;">
              <table class="table table-striped" id="tableKttkKtmiSubs" style="width: 100%;">
                <thead style="background-color: #ff000054;">
                  <tr>
                    <th>"""),_display_(/*294.26*/Messages("subscriber.modal.info.addon.index")),format.raw/*294.71*/("""</th>
                    <th>"""),_display_(/*295.26*/Messages("subscriber.modal.info.addon.serviceName")),format.raw/*295.77*/("""</th>
                    """),format.raw/*296.58*/("""
                    """),format.raw/*297.21*/("""<th>"""),_display_(/*297.26*/Messages("subscriber.modal.info.addon.remainingVolume")),format.raw/*297.81*/("""</th>
                    """),format.raw/*298.60*/("""
                    """),format.raw/*299.51*/("""
                    """),format.raw/*300.21*/("""<th>"""),_display_(/*300.26*/Messages("subscriber.modal.info.addon.expireDate")),format.raw/*300.76*/("""</th>
                    <th>"""),_display_(/*301.26*/Messages("subscriber.modal.info.addon.detail")),format.raw/*301.72*/("""</th>
                  </tr>
                </thead>
                <tbody></tbody>
              </table>
            </div>
          </div>

        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*312.77*/Messages("btnClose")),format.raw/*312.97*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/subs/Subscriber_info.scala.html
                  HASH: b94000837ea7f67bdc3f9d3df44e6c278cefaa98
                  MATRIX: 1051->0|1401->324|1454->357|1652->528|1713->567|1928->755|1984->789|2374->1152|2428->1184|2820->1549|2869->1576|3318->1998|3374->2032|3767->2398|3823->2432|4218->2800|4275->2835|4732->3265|4787->3298|5184->3668|5239->3701|5610->4054|5649->4065|5874->4263|5934->4301|6331->4670|6387->4703|6781->5069|6840->5105|7298->5535|7360->5574|7759->5945|7818->5981|8185->6329|8225->6340|8451->6538|8508->6572|8906->6942|8979->6992|9772->7757|9844->7806|10300->8234|10374->8285|10773->8656|10844->8704|11243->9075|11319->9128|11781->9562|11860->9618|12265->9995|12337->10044|12786->10465|12859->10515|13250->10878|13319->10924|13719->11296|13794->11348|14187->11713|14262->11765|14655->12130|14731->12183|15051->12484|15091->12495|15322->12698|15383->12736|15776->13101|15837->13139|16159->13442|16199->13453|16306->13532|16377->13580|16692->13867|16759->13912|16818->13943|16891->13994|16946->14057|16996->14078|17029->14083|17106->14138|17161->14203|17211->14254|17261->14275|17294->14280|17366->14330|17425->14361|17493->14407|17805->14691|17847->14711
                  LINES: 33->1|37->5|37->5|42->10|42->10|46->14|46->14|54->22|54->22|62->30|62->30|73->41|73->41|81->49|81->49|89->57|89->57|100->68|100->68|108->76|108->76|120->88|121->89|125->93|125->93|133->101|133->101|141->109|141->109|152->120|152->120|160->128|160->128|172->140|173->141|177->145|177->145|185->153|185->153|198->166|198->166|209->177|209->177|217->185|217->185|225->193|225->193|236->204|236->204|244->212|244->212|255->223|255->223|263->231|263->231|271->239|271->239|279->247|279->247|287->255|287->255|297->265|298->266|302->270|302->270|310->278|310->278|319->287|320->288|321->289|321->289|326->294|326->294|327->295|327->295|328->296|329->297|329->297|329->297|330->298|331->299|332->300|332->300|332->300|333->301|333->301|344->312|344->312
                  -- GENERATED --
              */
          