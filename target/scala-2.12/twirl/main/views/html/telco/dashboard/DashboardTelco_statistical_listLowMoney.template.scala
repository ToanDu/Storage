
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

object DashboardTelco_statistical_listLowMoney extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.17*/("""
"""),format.raw/*4.1*/("""<div class="modal fade" id="listLowMoneyModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-xl modal-dialog-scrollable shadow-none">
    <div class="modal-content">
      <div class="modal-header pb-0">
        <h3 class="modal-title mb-3" id="myModalLabel" style="color: #001737;">"""),_display_(/*8.81*/Messages("dashboard.modal.lowBalance.title")),format.raw/*8.125*/("""</h3>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12" style="border-radius: 8px;">
            <table class="table table-striped" id="tableLowMoney" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th>"""),_display_(/*16.24*/Messages("manage.stt")),format.raw/*16.46*/("""</th>
                  <th>"""),_display_(/*17.24*/Messages("dashboard.modal.subscriber.number")),format.raw/*17.69*/("""</th>
                  <th>"""),_display_(/*18.24*/Messages("dashboard.modal.root.account")),format.raw/*18.64*/("""</th>
                  <th>"""),_display_(/*19.24*/Messages("dashboard.modal.block.status")),format.raw/*19.64*/("""</th>
                  <th>"""),_display_(/*20.24*/Messages("dashboard.modal.activity.status")),format.raw/*20.67*/("""</th>
                  <th>"""),_display_(/*21.24*/Messages("dashboard.modal.update.time")),format.raw/*21.63*/("""</th>
                </tr>
              </thead>
              <tbody></tbody>
            </table>
          <div>
            <input id="pageLowMoney" value="1" style="display: none">
            <input id="pageSizeLowMoney" value="10" style="display: none">
            <input name="isResetPage" id="isResetPage" value="false" style="display: none">
          </div>
          </div>
        </div>
      </div>
      <div class="modal-footer mt-1 pt-0">
        <div class="row">
          <div class="col-md-4 d-flex align-items-center justify-content-center justify-content-md-start mb-3">
            <p class="mb-0">"""),_display_(/*37.30*/Messages("Total")),format.raw/*37.47*/(""" """),format.raw/*37.48*/("""<span id="total_record_LowMoney">0</span> """),_display_(/*37.91*/Messages("entries")),format.raw/*37.110*/("""</p>
          </div>
          <div class="col-md-8 d-flex flex-column flex-md-row justify-content-end align-items-center gap-2 gap-md-3 mb-3">
            <div class="dropdown mb-2 mb-md-0">
              <button class="btn btn-sm dropdown-toggle btn-outline-dark" type="button" data-bs-toggle="dropdown"
                aria-expanded="false" id="countPageSizeLowMoney" style="margin-left: 5px;">
                10
              </button>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="javascript:applySearchLowMoney(1,10,true)">10</a></li>
                <li><a class="dropdown-item" href="javascript:applySearchLowMoney(1,50,true)">50</a></li>
                <li><a class="dropdown-item" href="javascript:applySearchLowMoney(1,100,true)">100</a></li>
                <li><a class="dropdown-item" href="javascript:applySearchLowMoney(1,200,true)">200</a></li>
                <li><a class="dropdown-item" href="javascript:applySearchLowMoney(1,500,true)">500</a></li>
              </ul>
            </div>
            <p class="mb-2 mb-md-0">"""),_display_(/*53.38*/Messages("entries.per.page")),format.raw/*53.66*/("""</p>
            <div id="pagingTableLowMoney" class="justify-content-md-end"></div>
          </div>
        
        </div>
        <button type="button" class="btn btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="resetModalLowMoney()" data-bs-dismiss="modal">"""),_display_(/*58.154*/Messages("btnClose")),format.raw/*58.174*/("""</button>
        <button type="button" class="btn btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="downloadLowMoney(1)">"""),_display_(/*59.129*/Messages("Export")),format.raw/*59.147*/("""</button>
        <a href=""""),_display_(/*60.19*/routes/*60.25*/.TelcoUtilitiesController.utilitiesTopup(userId)),format.raw/*60.73*/("""" target="_blank" type="button" class="btn btn-telco" style="background: #EA0033; color: #FFFFFF;">"""),_display_(/*60.173*/Messages("Nạp tiền")),format.raw/*60.193*/("""</a>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/dashboard/DashboardTelco_statistical_listLowMoney.scala.html
                  HASH: 871d808e6422beee9db7363ad8f442275600c901
                  MATRIX: 667->1|690->18|1061->52|1171->67|1198->68|1625->469|1690->513|2044->840|2087->862|2143->891|2209->936|2265->965|2326->1005|2382->1034|2443->1074|2499->1103|2563->1146|2619->1175|2679->1214|3333->1841|3371->1858|3400->1859|3470->1902|3511->1921|4633->3016|4682->3044|4989->3323|5031->3343|5197->3481|5237->3499|5292->3527|5307->3533|5376->3581|5504->3681|5546->3701
                  LINES: 24->1|25->2|30->3|35->3|36->4|40->8|40->8|48->16|48->16|49->17|49->17|50->18|50->18|51->19|51->19|52->20|52->20|53->21|53->21|69->37|69->37|69->37|69->37|69->37|85->53|85->53|90->58|90->58|91->59|91->59|92->60|92->60|92->60|92->60|92->60
                  -- GENERATED --
              */
          