
package views.html.telco.invoice.fee

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

object searchForm extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="card" id="fee_invoice">
  <div class="card-body">
    <span class="text-search">"""),_display_(/*3.32*/Messages("invoice.search.info")),format.raw/*3.63*/("""</span>
    <div class="row mt-3">
      <div class="col-sm-6 col-md-5 m-t-3">
        <div class="row m-b-4 align-items-center">
          <label class="col-sm-4 col-form-label title-section-2 text-start">"""),_display_(/*7.78*/Messages("invoice.search.invoiceNumber")),format.raw/*7.118*/("""</label>
          <div class="col-sm-8">
            <input id="invoiceNumber" type="text" class="form-control input-form" placeholder=""""),_display_(/*9.97*/Messages("invoice.search.invoiceNumberPlaceholder")),format.raw/*9.148*/("""" maxlength="250">
          </div>
        </div>
      </div>
      <div class="col-md-2"></div>
      <div class="col-sm-6 col-md-5 m-t-3">
        <div class="row m-b-4 align-items-center">
          <label class="col-sm-4 col-form-label title-section-2 text-start">"""),_display_(/*16.78*/Messages("invoice.search.feeInvoiceType")),format.raw/*16.119*/("""</label>
          <div class="col-sm-8">
            <select id="invoiceType" class="form-control input-form">
              <option value="HDIS,HDTT,HDCDT,HDDC" disabled selected hidden>"""),_display_(/*19.78*/Messages("invoice.search.selectInvoiceType")),format.raw/*19.122*/("""</option>
              <option value="HDIS">"""),_display_(/*20.37*/Messages("invoice.type.fee.generated")),format.raw/*20.75*/("""</option>
              <option value="HDTT">"""),_display_(/*21.37*/Messages("invoice.type.fee.surplus")),format.raw/*21.73*/("""</option>
              <option value="HDCDT">"""),_display_(/*22.38*/Messages("invoice.type.fee.prepaid")),format.raw/*22.74*/("""</option>
              <option value="HDDC">"""),_display_(/*23.37*/Messages("invoice.type.fee.adjustment")),format.raw/*23.76*/("""</option>
            </select>
          </div>
        </div>
      </div>
    </div>
    <div class="row mt-3">
      <div class="col-sm-6 col-md-5 m-t-3">
        <div class="row m-b-4 align-items-center">
          <label class="col-sm-4 col-form-label title-section-2 text-start">"""),_display_(/*32.78*/Messages("invoice.search.contractCode")),format.raw/*32.117*/("""</label>
          <div class="col-sm-8">
            <input id="accountId" type="text" class="form-control input-form" placeholder=""""),_display_(/*34.93*/Messages("invoice.search.contractCodePlaceholder")),format.raw/*34.143*/("""" onkeypress="return isNumberKey(event)" maxlength="11">
          </div>
        </div>
      </div>
      <div class="col-md-2"></div>
      <div class="col-sm-6 col-md-5 m-t-3">
        <div class="row m-b-4 align-items-center">
          <label class="col-sm-4 col-form-label title-section-2 text-start">"""),_display_(/*41.78*/Messages("invoice.search.invoiceDate")),format.raw/*41.116*/("""</label>
          <div class="col-sm-4">
            <input id="dateFrom" type="text" class="form-control input-form datetimepicker" placeholder=""""),_display_(/*43.107*/Messages("invoice.search.fromDate")),format.raw/*43.142*/("""">
          </div>
          <div class="col-sm-4">
            <input id="dateTo" type="text" class="form-control input-form datetimepicker" placeholder=""""),_display_(/*46.105*/Messages("invoice.search.toDate")),format.raw/*46.138*/("""">
          </div>
        </div>
      </div>
    </div>
    <div class="d-flex flex-column align-items-center text-center">
      <div>
        <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF;" onclick="getInvoices('fee',true)">"""),_display_(/*53.138*/Messages("invoice.search.lookup")),format.raw/*53.171*/("""</button>
        <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="handleResetAll('fee')">"""),_display_(/*54.136*/Messages("invoice.search.reset")),format.raw/*54.168*/("""</button>
      </div>
    </div>
  </div>
</div>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:53 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/invoice/fee/searchForm.scala.html
                  HASH: ff1dc4737504c39c9e606c82c8c07939980b7740
                  MATRIX: 1053->0|1172->93|1223->124|1456->331|1517->371|1681->509|1753->560|2051->831|2114->872|2330->1061|2396->1105|2469->1151|2528->1189|2601->1235|2658->1271|2732->1318|2789->1354|2862->1400|2922->1439|3236->1726|3297->1765|3458->1899|3530->1949|3866->2258|3926->2296|4102->2444|4159->2479|4344->2636|4399->2669|4703->2945|4758->2978|4931->3123|4985->3155
                  LINES: 33->1|35->3|35->3|39->7|39->7|41->9|41->9|48->16|48->16|51->19|51->19|52->20|52->20|53->21|53->21|54->22|54->22|55->23|55->23|64->32|64->32|66->34|66->34|73->41|73->41|75->43|75->43|78->46|78->46|85->53|85->53|86->54|86->54
                  -- GENERATED --
              */
          