
package views.html.telco.contract

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

object Contract_info extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="infoContract" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">
      <div class="modal-header">
        <span class="modal-title" id="myModalLabel">"""),_display_(/*5.54*/Messages("contract.info.title")),format.raw/*5.85*/("""</span>
      </div>
      <div class="modal-body">
        <div class="row g-3">
          <div class="row">
            <span style="font-weight: 700;font-size: 16px;">"""),_display_(/*10.62*/Messages("contract.info.detailsHeader")),format.raw/*10.101*/("""</span>
            <div class="row">
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*14.75*/Messages("contract.info.contractCode")),format.raw/*14.113*/("""</label>
                  <div class="col-sm-8">
                    <input id="accountIdDetail" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*22.75*/Messages("contract.info.contractNumber")),format.raw/*22.115*/("""</label>
                  <div class="col-sm-8">
                    <input id="accountNoDetail" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*30.75*/Messages("contract.info.status")),format.raw/*30.107*/("""</label>
                  <div class="col-sm-8">
                    <input id="accountStatus" type="text" class="form-control form-info" value="" readonly>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <hr>

          """),format.raw/*40.21*/("""
          """),format.raw/*41.11*/("""<div class="row">
            <div class="row">
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*45.75*/Messages("contract.info.beginningDebt")),format.raw/*45.114*/("""</label>
                  <div class="col-sm-8">
                    <input id="staOfCycleContract" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*53.75*/Messages("contract.info.paidAmount")),format.raw/*53.111*/("""</label>
                  <div class="col-sm-8">
                    <input id="paymentContract" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*61.75*/Messages("contract.info.adjustmentAmount")),format.raw/*61.117*/("""</label>
                  <div class="col-sm-8">
                    <input id="adjustAmountContract" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*72.75*/Messages("contract.info.remainingDebt")),format.raw/*72.114*/("""</label>
                  <div class="col-sm-8">
                    <input id="remainAmountContract" type="text" class="form-control form-info" value="" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*80.75*/Messages("contract.info.hotChargeEstimated")),format.raw/*80.119*/("""</label>
                  <div class="col-sm-8">
                    <input id="hotChargeContract" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="row mt-3">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*88.75*/Messages("contract.info.contractExcessCash")),format.raw/*88.119*/("""</label>
                  <div class="col-sm-8">
                    <input id="excessCashContract" type="text" class="form-control form-info" readonly>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <hr>

        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*101.77*/Messages("btnClose")),format.raw/*101.97*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/contract/Contract_info.scala.html
                  HASH: 9fc933df2fb4fa618a910e60468b90654277fc02
                  MATRIX: 1053->0|1407->328|1458->359|1656->530|1717->569|1932->757|1992->795|2389->1165|2451->1205|2848->1575|2902->1607|3219->1906|3258->1917|3483->2115|3544->2154|3944->2527|4002->2563|4399->2933|4463->2975|4915->3400|4976->3439|5387->3823|5453->3867|5852->4239|5918->4283|6358->4695|6400->4715
                  LINES: 33->1|37->5|37->5|42->10|42->10|46->14|46->14|54->22|54->22|62->30|62->30|72->40|73->41|77->45|77->45|85->53|85->53|93->61|93->61|104->72|104->72|112->80|112->80|120->88|120->88|133->101|133->101
                  -- GENERATED --
              */
          