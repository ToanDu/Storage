
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

object DashboardTelco_statistical_listOutOfData extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.17*/("""
"""),format.raw/*4.1*/("""<div class="modal fade" id="listOutOfDataModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-lg modal-dialog-scrollable shadow-none">
    <div class="modal-content">
      <div class="modal-header pb-0">
        <h3 class="modal-title mb-3" id="myModalLabel" style="color: #001737;">"""),_display_(/*8.81*/Messages("Danh sách thuê bao có lưu lượng data bằng 0")),format.raw/*8.136*/("""</h3>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12" style="border-radius: 8px;">
            <table class="table table-striped" id="tableOutOfData" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th>"""),_display_(/*16.24*/Messages("STT")),format.raw/*16.39*/("""</th>
                  <th>"""),_display_(/*17.24*/Messages("Số thuê bao")),format.raw/*17.47*/("""</th>
                  <th>"""),_display_(/*18.24*/Messages("TK gốc")),format.raw/*18.42*/("""</th>
                  <th>"""),_display_(/*19.24*/Messages("Lưu lượng còn lại")),format.raw/*19.53*/("""</th>
                  <th>"""),_display_(/*20.24*/Messages("Trạng thái hoạt động")),format.raw/*20.56*/("""</th>
                </tr>
              </thead>
              <tbody></tbody>
            </table>
          <div>
            <input id="pageOutOfData" value="1" style="display: none">
            <input id="pageSizeOutOfData" value="10" style="display: none">
          </div>
          </div>
        </div>
      </div>
      <div class="modal-footer mt-1 pt-0">
        <div class="row">
            <div class="col-md-4 d-flex align-items-center justify-content-center justify-content-md-start mb-3">
              <p class="mb-0">Tổng <span id="total_record_OutOfData">0</span> bản ghi</p>
            </div>
            <div class="col-md-8 d-flex flex-column flex-md-row justify-content-end align-items-center gap-2 gap-md-3 mb-3">
              <div class="dropdown mb-2 mb-md-0">
                <button class="btn btn-sm dropdown-toggle btn-outline-dark" type="button" data-bs-toggle="dropdown"
                  aria-expanded="false" id="countPageSize" style="margin-left: 5px;">
                  10
                </button>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="javascript:applySearchOutOfData(1,10,true)">10</a></li>
                  <li><a class="dropdown-item" href="javascript:applySearchOutOfData(1,50,true)">50</a></li>
                  <li><a class="dropdown-item" href="javascript:applySearchOutOfData(1,100,true)">100</a></li>
                  <li><a class="dropdown-item" href="javascript:applySearchOutOfData(1,200,true)">200</a></li>
                  <li><a class="dropdown-item" href="javascript:applySearchOutOfData(1,500,true)">500</a></li>
                </ul>
              </div>
              <p class="mb-2 mb-md-0">"""),_display_(/*51.40*/Messages("Bản ghi/trang")),format.raw/*51.65*/("""</p>
              <div id="pagingTableOutOfData" class="justify-content-md-end"></div>
            </div>
          
          </div>
        <button type="button" class="btn btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="resetModalOutOfData()" data-bs-dismiss="modal">"""),_display_(/*56.155*/Messages("btnClose")),format.raw/*56.175*/("""</button>
        <button type="button" class="btn btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="downloadOutOfData(1)">"""),_display_(/*57.130*/Messages("Export")),format.raw/*57.148*/("""</button>
        <a href=""""),_display_(/*58.19*/routes/*58.25*/.TelcoUtilitiesController.utilitiesManage(userId)),format.raw/*58.74*/("""" type="button" class="btn btn-telco" style="background: #EA0033; color: #FFFFFF; width: auto;">"""),_display_(/*58.171*/Messages("Mua gói Data")),format.raw/*58.195*/("""</a>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/dashboard/DashboardTelco_statistical_listOutOfData.scala.html
                  HASH: a4a876e6790cda77754bf279478f18cef5078539
                  MATRIX: 667->1|690->18|1062->52|1172->67|1199->68|1627->470|1703->525|2058->853|2094->868|2150->897|2194->920|2250->949|2289->967|2345->996|2395->1025|2451->1054|2504->1086|4250->2805|4296->2830|4613->3119|4655->3139|4822->3278|4862->3296|4917->3324|4932->3330|5002->3379|5127->3476|5173->3500
                  LINES: 24->1|25->2|30->3|35->3|36->4|40->8|40->8|48->16|48->16|49->17|49->17|50->18|50->18|51->19|51->19|52->20|52->20|83->51|83->51|88->56|88->56|89->57|89->57|90->58|90->58|90->58|90->58|90->58
                  -- GENERATED --
              */
          