
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

object DashboardTelco_modalPackageExpire extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.17*/("""
"""),format.raw/*4.1*/("""<div class="modal fade" id="modal_package_expire" data-bs-backdrop="static" tabindex="-1" role="dialog"
  aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-xl modal-dialog-scrollable shadow-none">
    <div class="modal-content">
      <div class="modal-header pb-0">
        <h3 class="modal-title mb-3" id="title_modal_package_expire" style="color: #001737;">"""),_display_(/*9.95*/Messages("Danh sách thuê bao hết hạn gói cước")),format.raw/*9.142*/("""</h3>
        <div class="row text-start">
          <label for="expired_in_days" class="col-sm-2 col-form-label">"""),_display_(/*11.73*/Messages("Hết hạn sau")),format.raw/*11.96*/("""</label>
          <div class="col-sm-3">
            <select name="expired_in_days" class="form-control" id="expired_in_days">
              <option value="3">"""),_display_(/*14.34*/Messages("3 ngày")),format.raw/*14.52*/("""</option>
              <option value="5" >"""),_display_(/*15.35*/Messages("5 ngày")),format.raw/*15.53*/("""</option>
              <option value="7" selected>"""),_display_(/*16.43*/Messages("7 ngày")),format.raw/*16.61*/("""</option>
            </select>
          </div>
        </div>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12" style="border-radius: 8px;">
            <table class="table table-striped" id="table_modal_package_expire" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <th>STT</th>
                <th>Số thuê bao</th>
                <th>GPKD</th>
                <th>Gói cước</th>
                <th>Ngày hết hạn</th>
              </thead>
              <tbody></tbody>
            </table>
            <div>
              <input id="pagePackageExpire" value="1" style="display: none">
              <input id="pageSizePackageExpire" value="10" style="display: none">
            </div>
          </div>
        </div>
      </div>
      <div class="modal-footer mt-1 pt-0" id="footer_modal_package_expire">
        <div class="row">
              <div class="col-md-4 d-flex align-items-center justify-content-center justify-content-md-start mb-3">
                <p class="mb-0">Tổng <span id="total_record_PackageExpire">0</span> bản ghi</p>
              </div>
              <div
                class="col-md-8 d-flex flex-column flex-md-row justify-content-end align-items-center gap-2 gap-md-3 mb-3">
                <div class="dropdown mb-2 mb-md-0">
                  <button class="btn btn-sm dropdown-toggle btn-outline-dark" type="button" data-bs-toggle="dropdown"
                    aria-expanded="false" id="countPagePackageExpire" style="margin-left: 5px;">
                    10
                  </button>
                  <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="javascript:applySearchPackageExpire(1,10)">10</a></li>
                    <li><a class="dropdown-item" href="javascript:applySearchPackageExpire(1,50)">50</a></li>
                    <li><a class="dropdown-item" href="javascript:applySearchPackageExpire(1,100)">100</a></li>
                    <li><a class="dropdown-item" href="javascript:applySearchPackageExpire(1,200)">200</a></li>
                    <li><a class="dropdown-item" href="javascript:applySearchPackageExpire(1,500)">500</a></li>
                  </ul>
                </div>
                <p class="mb-2 mb-md-0">"""),_display_(/*61.42*/Messages("Bản ghi/trang")),format.raw/*61.67*/("""</p>
                <div id="pagingTablePackageExpire" class="justify-content-md-end"></div>
              </div>

            </div>
        <button type="button" class="btn btn-telco" style="background: #FFFFFF; color: #EA0033;"
          onclick="resetModalPackageExpire()" data-bs-dismiss="modal">"""),_display_(/*67.72*/Messages("btnClose")),format.raw/*67.92*/("""</button>
        <button type="button" class="btn btn-telco" style="background: #FFFFFF; color: #EA0033;"
          onclick="downloadExcelPackageExpire(1)">"""),_display_(/*69.52*/Messages("Export")),format.raw/*69.70*/("""</button>
        <a href=""""),_display_(/*70.19*/routes/*70.25*/.TelcoUtilitiesController.utilitiesManage(userId)),format.raw/*70.74*/("""" target="_blank" type="button" class="btn btn-telco"
          style="background: #EA0033; color: #FFFFFF; width: auto;">"""),_display_(/*71.70*/Messages("Mua gói Data")),format.raw/*71.94*/("""</a>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/dashboard/DashboardTelco_modalPackageExpire.scala.html
                  HASH: 5db73eedde436d0281cec37fd40d3b1f86055a9a
                  MATRIX: 667->1|690->18|1055->52|1165->67|1192->68|1638->488|1706->535|1848->650|1892->673|2080->834|2119->852|2190->896|2229->914|2308->966|2347->984|4696->3306|4742->3331|5072->3634|5113->3654|5298->3812|5337->3830|5392->3858|5407->3864|5477->3913|5627->4036|5672->4060
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|43->11|43->11|46->14|46->14|47->15|47->15|48->16|48->16|93->61|93->61|99->67|99->67|101->69|101->69|102->70|102->70|102->70|103->71|103->71
                  -- GENERATED --
              */
          