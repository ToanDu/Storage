
package views.html.telco.statisticalReport

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

object searchForm extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Boolean,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(hasDate: Boolean = false):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.28*/("""
"""),format.raw/*3.1*/("""<div class="card" id="statisticalReportSearchForm">
  <div class="card-body">
    <span class="text-search">"""),_display_(/*5.32*/Messages("Thông tin tìm kiếm")),format.raw/*5.62*/("""</span>
    <div class="row mt-3">
      <div class="col-sm-6 col-md-5 m-t-3">
        <div class="row m-b-4 align-items-center">
          <label class="col-sm-4 col-form-label title-section-2 text-start">"""),_display_(/*9.78*/Messages("Số thuê bao")),format.raw/*9.101*/("""</label>
          <div class="col-sm-8">
            <input id="isDn" type="text" class="form-control input-form" placeholder="Nhập số thuê bao" onkeypress="return isNumberKey(event)" maxlength="11">
          </div>
        </div>
      </div>
      <div class="col-md-2"></div>
      <div class="col-sm-6 col-md-5 m-t-3">
         <div class="row m-b-4 align-items-center">
          <label class="col-sm-4 col-form-label title-section-2 text-start">"""),_display_(/*18.78*/Messages("Mã hợp đồng")),format.raw/*18.101*/("""</label>
          <div class="col-sm-8">
            <input id="contractId" type="text" class="form-control input-form" placeholder="Nhập mã hợp đồng" onkeypress="return isNumberKey(event)" maxlength="11">
          </div>
        </div>
      </div>
    </div>
    """),_display_(/*25.6*/if(hasDate)/*25.17*/ {_display_(Seq[Any](format.raw/*25.19*/("""<div class="row mt-3">
      <div class="col-sm-6 col-md-5 m-t-3">
        <div class="row m-b-4 align-items-center">
          <label class="col-sm-4 col-form-label title-section-2 text-start">"""),_display_(/*28.78*/Messages("Ngày hết hạn")),format.raw/*28.102*/("""</label>
          <div class="col-sm-4">
            <input id="dateFrom" type="text" class="form-control input-form datetimepicker" placeholder="Từ ngày">
          </div>
          <div class="col-sm-4">
            <input id="dateTo" type="text" class="form-control input-form datetimepicker" placeholder="Đến ngày">
          </div>
        </div>
      </div>
    </div>""")))}),format.raw/*37.12*/("""
    """),format.raw/*38.5*/("""<div class="d-flex flex-column align-items-center text-center">
      <div>
        """),_display_(/*40.10*/if(hasDate)/*40.21*/ {_display_(Seq[Any](format.raw/*40.23*/("""
        """),format.raw/*41.9*/("""<button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF;" onclick="getExpiratedPackages(true)">"""),_display_(/*41.141*/Messages("Tra cứu")),format.raw/*41.160*/("""</button>
        <button type="button" class="btn mt-3 btn-telco d-none" style="background: #FFFFFF; color: #EA0033;" data-bs-toggle="modal" data-bs-target="#exportReportModal">"""),_display_(/*42.170*/Messages("Export")),format.raw/*42.188*/("""</button>
        <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="handleResetAllExpiratedPackages()">"""),_display_(/*43.148*/Messages("Reset")),format.raw/*43.165*/("""</button>
      
        """)))}/*45.10*/else/*45.15*/{_display_(Seq[Any](format.raw/*45.16*/("""
        """),format.raw/*46.9*/("""<button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF;" onclick="getRedBarings(true)">"""),_display_(/*46.134*/Messages("Tra cứu")),format.raw/*46.153*/("""</button>
        <button type="button" class="btn mt-3 btn-telco d-none" style="background: #FFFFFF; color: #EA0033;" data-bs-toggle="modal" data-bs-target="#exportReportModal">"""),_display_(/*47.170*/Messages("Export")),format.raw/*47.188*/("""</button>
        <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="handleResetAllRedBarings()">"""),_display_(/*48.141*/Messages("Reset")),format.raw/*48.158*/("""</button>
        """)))}),format.raw/*49.10*/("""
        """),format.raw/*50.9*/("""</div>
    </div>
  </div>
</div>"""))
      }
    }
  }

  def render(hasDate:Boolean): play.twirl.api.HtmlFormat.Appendable = apply(hasDate)

  def f:((Boolean) => play.twirl.api.HtmlFormat.Appendable) = (hasDate) => apply(hasDate)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/statisticalReport/searchForm.scala.html
                  HASH: d3acb787f14a95e460395f710b31eb308d09aef8
                  MATRIX: 978->2|1099->28|1126->29|1261->138|1311->168|1544->375|1588->398|2069->852|2114->875|2408->1143|2428->1154|2468->1156|2690->1351|2736->1375|3144->1752|3176->1757|3288->1842|3308->1853|3348->1855|3384->1864|3544->1996|3585->2015|3792->2194|3832->2212|4017->2369|4056->2386|4101->2412|4114->2417|4153->2418|4189->2427|4342->2552|4383->2571|4590->2750|4630->2768|4808->2918|4847->2935|4897->2954|4933->2963
                  LINES: 28->2|33->2|34->3|36->5|36->5|40->9|40->9|49->18|49->18|56->25|56->25|56->25|59->28|59->28|68->37|69->38|71->40|71->40|71->40|72->41|72->41|72->41|73->42|73->42|74->43|74->43|76->45|76->45|76->45|77->46|77->46|77->46|78->47|78->47|79->48|79->48|80->49|81->50
                  -- GENERATED --
              */
          