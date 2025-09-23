
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

object DashboardTelco_modal_red_alert extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.17*/("""
"""),format.raw/*4.1*/("""<div class="modal fade" id="modal_red_alert" data-bs-backdrop="static" tabindex="-1" role="dialog"
  aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-xl modal-dialog-scrollable shadow-none">
    <div class="modal-content">
      <div class="modal-header pb-0">
        <h3 class="modal-title mb-3" id="title_modal_red_alert" style="color: #001737;">"""),_display_(/*9.90*/Messages("dashboard.modal.redAlert.title")),format.raw/*9.132*/("""</h3>
        <p class="mb-1 text-start"><em>"""),_display_(/*10.41*/Messages("dashboard.modal.redAlert.note")),format.raw/*10.82*/("""</em></p>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12" style="border-radius: 8px;">
            <table class="table table-striped" id="table_modal_red_alert" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <th class="text-center">"""),_display_(/*17.42*/Messages("manage.stt")),format.raw/*17.64*/("""</th>
                <th class="text-center">"""),_display_(/*18.42*/Messages("dashboard.modal.subscriber.number")),format.raw/*18.87*/("""</th>
                <th class="text-center">"""),_display_(/*19.42*/Messages("dashboard.modal.contract.code")),format.raw/*19.83*/("""</th>
                <th class="text-center">"""),_display_(/*20.42*/Messages("dashboard.modal.consumption.threshold")),format.raw/*20.91*/("""</th>
                <th class="text-center">"""),_display_(/*21.42*/Messages("dashboard.modal.update.time")),format.raw/*21.81*/("""</th>
              </thead>
              <tbody></tbody>
            </table>
            <div>
              <input id="pageRedAlert" value="1" style="display: none">
              <input id="pageSizeRedAlert" value="10" style="display: none">
            </div>
          </div>
        </div>
      </div>
      <div class="modal-footer mt-1 pt-0" id="footer_modal_red_alert">
        <div class="row">
          <div class="col-md-4 d-flex align-items-center justify-content-center justify-content-md-start mb-3">
            <p class="mb-0">"""),_display_(/*35.30*/Messages("Total")),format.raw/*35.47*/(""" """),format.raw/*35.48*/("""<span id="total_record_RedAlert">0</span> """),_display_(/*35.91*/Messages("entries")),format.raw/*35.110*/("""</p>
          </div>
          <div
            class="col-md-8 d-flex flex-column flex-md-row justify-content-end align-items-center gap-2 gap-md-3 mb-3">
            <div class="dropdown mb-2 mb-md-0">
              <button class="btn btn-sm dropdown-toggle btn-outline-dark" type="button" data-bs-toggle="dropdown"
                aria-expanded="false" id="countPageRedAlert" style="margin-left: 5px;">
                10
              </button>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="javascript:applySearchRedAlert(1,10)">10</a></li>
                <li><a class="dropdown-item" href="javascript:applySearchRedAlert(1,50)">50</a></li>
                <li><a class="dropdown-item" href="javascript:applySearchRedAlert(1,100)">100</a></li>
                <li><a class="dropdown-item" href="javascript:applySearchRedAlert(1,200)">200</a></li>
                <li><a class="dropdown-item" href="javascript:applySearchRedAlert(1,500)">500</a></li>
              </ul>
            </div>
            <p class="mb-2 mb-md-0">"""),_display_(/*52.38*/Messages("Bản ghi/trang")),format.raw/*52.63*/("""</p>
            <div id="pagingTableRedAlert" class="justify-content-md-end"></div>
          </div>
      
        </div>
        <button type="button" class="btn btn-telco" style="background: #FFFFFF; color: #EA0033; width: 90px;"
          onclick="resetModalRedAlert()" data-bs-dismiss="modal">"""),_display_(/*58.67*/Messages("btnClose")),format.raw/*58.87*/("""</button>
        <button type="button" class="btn btn-telco" style="background: #EA0033; color: #FFFFFF; width: auto;"
          onclick="downloadExcelRedAlert(1)">"""),_display_(/*60.47*/Messages("Export")),format.raw/*60.65*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/dashboard/DashboardTelco_modal_red_alert.scala.html
                  HASH: 339c24b40accd87d3986a333089fb180fa1fc2fd
                  MATRIX: 667->1|690->18|1052->52|1162->67|1189->68|1625->478|1688->520|1761->566|1823->607|2186->943|2229->965|2303->1012|2369->1057|2443->1104|2505->1145|2579->1192|2649->1241|2723->1288|2783->1327|3359->1876|3397->1893|3426->1894|3496->1937|3537->1956|4642->3034|4688->3059|5015->3359|5056->3379|5249->3545|5288->3563
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|49->17|49->17|50->18|50->18|51->19|51->19|52->20|52->20|53->21|53->21|67->35|67->35|67->35|67->35|67->35|84->52|84->52|90->58|90->58|92->60|92->60
                  -- GENERATED --
              */
          