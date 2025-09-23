
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

object BillUserList_payment extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="paymentBillConfirm" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog ">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-white">"""),_display_(/*5.45*/Messages("Thanh toán hóa đơn")),format.raw/*5.75*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="form-group">
          <div class="card" style="padding: 20px; border: 1px solid #858687;">
            <div class="row">

              <div class="col-md-12">
                <div class="row mb-4">
                  <label class="col-sm-4 col-form-label">"""),_display_(/*14.59*/Messages("Hóa đơn")),format.raw/*14.78*/("""</label>
                  <div class="col-sm-8">
                    <span id="tdIdBill"></span>
                  </div>
                </div>
              </div>
              <div class="col-md-12">
                <div class="row mb-4">
                  <label class="col-sm-4 col-form-label">"""),_display_(/*22.59*/Messages("Địa chỉ thanh toán")),format.raw/*22.89*/("""</label>
                  <div class="col-sm-8">
                    <a id="tdLinkPayBill" style="cursor: pointer; color: #00a5bb;"></a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" data-bs-dismiss="modal" onclick="checkStatusBill()">"""),_display_(/*33.108*/Messages("Xác nhận thanh toán")),format.raw/*33.139*/("""</button>
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*34.77*/Messages("btnCancel")),format.raw/*34.98*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/pay/billUser/BillUserList_payment.scala.html
                  HASH: e14554362db76f6764a7d263f699b8d407b54f25
                  MATRIX: 1062->0|1322->234|1372->264|1727->592|1767->611|2096->913|2147->943|2586->1354|2639->1385|2752->1471|2794->1492
                  LINES: 33->1|37->5|37->5|46->14|46->14|54->22|54->22|65->33|65->33|66->34|66->34
                  -- GENERATED --
              */
          