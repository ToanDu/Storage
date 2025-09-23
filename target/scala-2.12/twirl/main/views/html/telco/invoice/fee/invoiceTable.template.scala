
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

object invoiceTable extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div id="fee_invoice_info" class="card">
  <div class="card-body">
    <div class="table-responsive py-4 " style="border-radius: 8px;" id="fee_invoice_table">
      <table class="table table-striped" style="width: 100%; border: 1px solid;">
        <thead style="background-color: #FBCCD6;">
          <tr>
            <th>"""),_display_(/*7.18*/Messages("invoice.table.stt")),format.raw/*7.47*/("""</th>
            <th>"""),_display_(/*8.18*/Messages("invoice.table.invoiceNumber")),format.raw/*8.57*/("""</th>
            <th>"""),_display_(/*9.18*/Messages("invoice.table.feeInvoiceType")),format.raw/*9.58*/("""</th>
            <th>"""),_display_(/*10.18*/Messages("invoice.table.contractCode")),format.raw/*10.56*/("""</th>
            <th>"""),_display_(/*11.18*/Messages("invoice.table.totalAmount")),format.raw/*11.55*/("""</th>
            <th>"""),_display_(/*12.18*/Messages("invoice.table.invoiceDate")),format.raw/*12.55*/("""</th>
            <th class="d-flex justify-content-center">"""),_display_(/*13.56*/Messages("invoice.table.actions")),format.raw/*13.89*/("""</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td colspan="7" class="text-center">"""),_display_(/*18.50*/Messages("common.noData")),format.raw/*18.75*/("""</td>
          </tr>
        </tbody>
      </table>
    </div>
    
    <div class="row">
      <div class="col-md-4 d-flex align-items-center justify-content-center justify-content-md-start mb-3">
        <p class="mb-0">"""),_display_(/*26.26*/Messages("invoice.table.totalRecordsPrefix")),format.raw/*26.70*/(""" """),format.raw/*26.71*/("""<span id="total_record">0</span> """),_display_(/*26.105*/Messages("invoice.table.totalRecordsSuffix")),format.raw/*26.149*/("""</p>
      </div>
      <div class="col-md-8 d-flex flex-column flex-md-row justify-content-end align-items-center gap-2 gap-md-3 mb-3">
        <div class="dropdown mb-2 mb-md-0">
          <button class="btn btn-sm dropdown-toggle btn-outline-dark" type="button" data-bs-toggle="dropdown"
            aria-expanded="false" id="countPageSize" style="margin-left: 5px;">
            10
          </button>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="javascript:handleChangePageSizeFee(1,10,true)">10</a></li>
            <li><a class="dropdown-item" href="javascript:handleChangePageSizeFee(1,50,true)">50</a></li>
            <li><a class="dropdown-item" href="javascript:handleChangePageSizeFee(1,100,true)">100</a></li>
            <li><a class="dropdown-item" href="javascript:handleChangePageSizeFee(1,200,true)">200</a></li>
            <li><a class="dropdown-item" href="javascript:handleChangePageSizeFee(1,500,true)">500</a></li>
          </ul>
        </div>
        <p class="mb-2 mb-md-0">"""),_display_(/*42.34*/Messages("entries.per.page")),format.raw/*42.62*/("""</p>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/invoice/fee/invoiceTable.scala.html
                  HASH: 6bd26c4eb710847e2602a3aafda06f08d93d1f97
                  MATRIX: 1055->0|1405->324|1454->353|1503->376|1562->415|1611->438|1671->478|1721->501|1780->539|1830->562|1888->599|1938->622|1996->659|2084->720|2138->753|2284->872|2330->897|2582->1122|2647->1166|2676->1167|2738->1201|2804->1245|3874->2288|3923->2316
                  LINES: 33->1|39->7|39->7|40->8|40->8|41->9|41->9|42->10|42->10|43->11|43->11|44->12|44->12|45->13|45->13|50->18|50->18|58->26|58->26|58->26|58->26|58->26|74->42|74->42
                  -- GENERATED --
              */
          