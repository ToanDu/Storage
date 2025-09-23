
package views.html.telco.dashboard

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
/*1.2*/import helper._
/*2.2*/import vn.m2m.common.models.User

object DashboardTelco_modal_prepaid_expired extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.17*/("""
"""),format.raw/*4.1*/("""<div class="modal fade" id="modal_prepaid_expired" data-bs-backdrop="static" tabindex="-1" role="dialog"
  aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-xl modal-dialog-scrollable shadow-none">
    <div class="modal-content">
      <div class="modal-header pb-0">
        <h3 class="modal-title mb-3" id="title_modal_prepaid_expired" style="color: #001737;">"""),_display_(/*9.96*/Messages("dashboard.modal.prepaidExpired.title")),format.raw/*9.144*/("""</h3>
        <p class="mb-1 text-start"><em>"""),_display_(/*10.41*/Messages("dashboard.modal.prepaidExpired.note")),format.raw/*10.88*/("""</em></p>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12" style="border-radius: 8px;">
            <table class="table table-striped" id="table_modal_prepaid_expired" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <th class="text-center">"""),_display_(/*17.42*/Messages("manage.stt")),format.raw/*17.64*/("""</th>
                <th class="text-center">"""),_display_(/*18.42*/Messages("dashboard.modal.subscriber.number")),format.raw/*18.87*/("""</th>
                <th class="text-center">"""),_display_(/*19.42*/Messages("dashboard.modal.contract.code")),format.raw/*19.83*/("""</th>
                <th class="text-center">"""),_display_(/*20.42*/Messages("dashboard.modal.prepaid.expiry.date")),format.raw/*20.89*/("""</th>
                <th class="text-center">"""),_display_(/*21.42*/Messages("dashboard.modal.update.time")),format.raw/*21.81*/("""</th>
              </thead>
              <tbody></tbody>
            </table>
            <div>
              <input id="pagePrepaidExpired" value="1" style="display: none">
              <input id="pageSizePrepaidExpired" value="10" style="display: none">
            </div>
          </div>
        </div>
      </div>
      <div class="modal-footer mt-1 pt-0" id="footer_modal_prepaid_expired">
           <div class="row">
              <div class="col-md-4 d-flex align-items-center justify-content-center justify-content-md-start mb-3">
                <p class="mb-0">Tổng <span id="total_record_PrepaidExpired">0</span> bản ghi</p>
              </div>
              <div
                class="col-md-8 d-flex flex-column flex-md-row justify-content-end align-items-center gap-2 gap-md-3 mb-3">
                <div class="dropdown mb-2 mb-md-0">
                  <button class="btn btn-sm dropdown-toggle btn-outline-dark" type="button" data-bs-toggle="dropdown"
                    aria-expanded="false" id="countPagePrepaidExpired" style="margin-left: 5px;">
                    10
                  </button>
                  <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="javascript:applySearchPrepaidExpired(1,10)">10</a></li>
                    <li><a class="dropdown-item" href="javascript:applySearchPrepaidExpired(1,50)">50</a></li>
                    <li><a class="dropdown-item" href="javascript:applySearchPrepaidExpired(1,100)">100</a></li>
                    <li><a class="dropdown-item" href="javascript:applySearchPrepaidExpired(1,200)">200</a></li>
                    <li><a class="dropdown-item" href="javascript:applySearchPrepaidExpired(1,500)">500</a></li>
                  </ul>
                </div>
                <p class="mb-2 mb-md-0">"""),_display_(/*52.42*/Messages("Bản ghi/trang")),format.raw/*52.67*/("""</p>
                <div id="pagingTablePrepaidExpired" class="justify-content-md-end"></div>
              </div>

            </div>
        <button type="button" class="btn btn-telco" style="background: #FFFFFF; color: #EA0033;"
          onclick="resetModalPrepaidExpired()" data-bs-dismiss="modal">"""),_display_(/*58.73*/Messages("btnClose")),format.raw/*58.93*/("""</button>
        <button type="button" class="btn btn-telco" style="background: #FFFFFF; color: #EA0033;"
          onclick="downloadExcelPrepaidExpired(1)">"""),_display_(/*60.53*/Messages("Export")),format.raw/*60.71*/("""</button>
        <a href=""""),_display_(/*61.19*/routes/*61.25*/.TelcoUtilitiesController.prepayCharges(userId)),format.raw/*61.72*/("""" target="_blank" type="button" class="btn btn-telco"
          style="background: #EA0033; color: #FFFFFF; width: auto;">"""),_display_(/*62.70*/Messages("Đóng cước trước")),format.raw/*62.97*/("""</a>
      </div>
    </div>
  </div>
</div>"""))
      }
    }
  }

  def render(userId:String): play.twirl.api.HtmlFormat.Appendable = apply(userId)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (userId) => apply(userId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:52 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/dashboard/DashboardTelco_modal_prepaid_expired.scala.html
                  HASH: 4cae9196e2c92120ddf5aff0be71ad3346bb9dcf
                  MATRIX: 667->1|690->18|1058->52|1168->67|1195->68|1643->490|1712->538|1785->584|1853->631|2222->973|2265->995|2339->1042|2405->1087|2479->1134|2541->1175|2615->1222|2683->1269|2757->1316|2817->1355|4663->3174|4709->3199|5041->3504|5082->3524|5268->3683|5307->3701|5362->3729|5377->3735|5445->3782|5595->3905|5643->3932
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|49->17|49->17|50->18|50->18|51->19|51->19|52->20|52->20|53->21|53->21|84->52|84->52|90->58|90->58|92->60|92->60|93->61|93->61|93->61|94->62|94->62
                  -- GENERATED --
              */
          