
package views.html.telco.invoice.service

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

object invoiceTable extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div id="service_invoice_info" class="card">
  <div class="card-body">
    <div class="table-responsive py-4 " style="border-radius: 8px;" id="service_invoice_table">
      <table class="table table-striped" style="width: 100%; border: 1px solid;">
        <thead style="background-color: #FBCCD6;">
          <tr>
            <th>"""),_display_(/*7.18*/Messages("invoice.table.stt")),format.raw/*7.47*/("""</th>
            <th>"""),_display_(/*8.18*/Messages("invoice.table.invoiceNumber")),format.raw/*8.57*/("""</th>
            <th>"""),_display_(/*9.18*/Messages("invoice.table.serviceInvoiceType")),format.raw/*9.62*/("""</th>
            <th>"""),_display_(/*10.18*/Messages("invoice.table.totalAmount")),format.raw/*10.55*/("""</th>
            <th>"""),_display_(/*11.18*/Messages("invoice.table.invoiceDate")),format.raw/*11.55*/("""</th>
            <th class="d-flex justify-content-center">"""),_display_(/*12.56*/Messages("invoice.table.actions")),format.raw/*12.89*/("""</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td colspan="7" class="text-center">"""),_display_(/*17.50*/Messages("common.noData")),format.raw/*17.75*/("""</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="row">
      <div class="col-md-4 d-flex align-items-center justify-content-center justify-content-md-start mb-3">
        <p class="mb-0">"""),_display_(/*24.26*/Messages("invoice.table.totalRecordsPrefix")),format.raw/*24.70*/(""" """),format.raw/*24.71*/("""<span id="total_record">0</span> """),_display_(/*24.105*/Messages("invoice.table.totalRecordsSuffix")),format.raw/*24.149*/("""</p>
      </div>
      <div class="col-md-8 d-flex flex-column flex-md-row justify-content-end align-items-center gap-2 gap-md-3 mb-3">
        <div class="dropdown mb-2 mb-md-0">
          <button class="btn btn-sm dropdown-toggle btn-outline-dark" type="button" data-bs-toggle="dropdown"
            aria-expanded="false" id="countPageSize" style="margin-left: 5px;">
            10
          </button>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="javascript:handleChangePageSizeService(1,10,true)">10</a></li>
            <li><a class="dropdown-item" href="javascript:handleChangePageSizeService(1,50,true)">50</a></li>
            <li><a class="dropdown-item" href="javascript:handleChangePageSizeService(1,100,true)">100</a></li>
            <li><a class="dropdown-item" href="javascript:handleChangePageSizeService(1,200,true)">200</a></li>
            <li><a class="dropdown-item" href="javascript:handleChangePageSizeService(1,500,true)">500</a></li>
          </ul>
        </div>
        <p class="mb-2 mb-md-0">"""),_display_(/*40.34*/Messages("entries.per.page")),format.raw/*40.62*/("""</p>
        <div id="pagingTable" class="justify-content-md-end"></div>
      </div>
    <div>
      <input type="hidden" name="page" id="page" value="1" />
      <input type="hidden" name="pageSize" id="pageSize" value="10" />
      <input type="hidden" name="isResetPage" id="isResetPage" value="false" />
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
                  DATE: Mon Sep 22 16:32:53 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/invoice/service/invoiceTable.scala.html
                  HASH: 993a7dd27157cac1ce82d8adbe13c9d584836362
                  MATRIX: 1059->0|1417->332|1466->361|1515->384|1574->423|1623->446|1687->490|1737->513|1795->550|1845->573|1903->610|1991->671|2045->704|2191->823|2237->848|2484->1068|2549->1112|2578->1113|2640->1147|2706->1191|3796->2254|3845->2282
                  LINES: 33->1|39->7|39->7|40->8|40->8|41->9|41->9|42->10|42->10|43->11|43->11|44->12|44->12|49->17|49->17|56->24|56->24|56->24|56->24|56->24|72->40|72->40
                  -- GENERATED --
              */
          