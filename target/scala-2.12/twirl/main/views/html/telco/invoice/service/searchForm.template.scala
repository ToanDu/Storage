
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

object searchForm extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="card" id="service_invoice">
  <div class="card-body">
    <span class="text-search">"""),_display_(/*3.32*/Messages("invoice.search.info")),format.raw/*3.63*/("""</span>
    <div class="row mt-3">
      <div class="col-sm-6 col-md-5 m-t-3">
        <div class="row m-b-4 align-items-center">
          <label class="col-sm-4 col-md-4 col-form-label title-section-2 text-start">"""),_display_(/*7.87*/Messages("invoice.search.invoiceNumber")),format.raw/*7.127*/("""</label>
          <div class="col-sm-8 col-md-8">
            <input id="invoiceNumber" type="text" class="form-control input-form" placeholder=""""),_display_(/*9.97*/Messages("invoice.search.invoiceNumberPlaceholder")),format.raw/*9.148*/("""" maxlength="250">
          </div>
        </div>
      </div>
      <div class="col-sm-0 col-md-2"></div>
      <div class="col-sm-6 col-md-5 m-t-3">
        <div class="row m-b-4 align-items-center">
          <label class="col-sm-4 col-md-4 col-form-label title-section-2 text-start">"""),_display_(/*16.87*/Messages("invoice.search.serviceInvoiceType")),format.raw/*16.132*/("""</label>
          <div class="col-sm-8 col-md-8">
            <select id="invoiceType" class="form-control input-form">
              <option value="08,09,10" disabled selected hidden>"""),_display_(/*19.66*/Messages("invoice.search.selectInvoiceType")),format.raw/*19.110*/("""</option>
              <option value="10">"""),_display_(/*20.35*/Messages("invoice.type.service.topup")),format.raw/*20.73*/("""</option>
              <option value="08">"""),_display_(/*21.35*/Messages("invoice.type.service.unblock1")),format.raw/*21.76*/("""</option>
              <option value="09">"""),_display_(/*22.35*/Messages("invoice.type.service.unblock2")),format.raw/*22.76*/("""</option>
            </select>
          </div>
        </div>
      </div>
    </div>
    <div class="row mt-3">
        <div class="col-sm-6 col-md-5">
            <div class="row m-b-4 align-items-center">
                <label class="col-md-4 col-form-label title-section-2 text-start mt-2">"""),_display_(/*31.89*/Messages("invoice.search.invoiceDate")),format.raw/*31.127*/("""</label>
                <div class="col-md-4 mt-2">
                    <input id="dateFrom" type="text" class="form-control input-form datetimepicker"
                        placeholder=""""),_display_(/*34.39*/Messages("invoice.search.fromDate")),format.raw/*34.74*/("""">
                </div>
                <div class="col-md-4 mt-2">
                    <input id="dateTo" type="text" class="form-control input-form datetimepicker"
                        placeholder=""""),_display_(/*38.39*/Messages("invoice.search.toDate")),format.raw/*38.72*/("""">
                </div>
            </div>
        </div>
    </div>
    <div class="d-flex justify-content-center align-items-center text-center">
      <div>
        <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF;" onclick="getInvoices('service',true)">"""),_display_(/*45.142*/Messages("invoice.search.lookup")),format.raw/*45.175*/("""</button>
        <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="handleResetAll('service')">"""),_display_(/*46.140*/Messages("invoice.search.reset")),format.raw/*46.172*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/invoice/service/searchForm.scala.html
                  HASH: 3a37aeb9ff064b2dac47f4da4cccb77763e6b2a2
                  MATRIX: 1057->0|1180->97|1231->128|1473->344|1534->384|1707->531|1779->582|2095->871|2162->916|2375->1102|2441->1146|2512->1190|2571->1228|2642->1272|2704->1313|2775->1357|2837->1398|3162->1696|3222->1734|3440->1925|3496->1960|3729->2166|3783->2199|4114->2502|4169->2535|4346->2684|4400->2716
                  LINES: 33->1|35->3|35->3|39->7|39->7|41->9|41->9|48->16|48->16|51->19|51->19|52->20|52->20|53->21|53->21|54->22|54->22|63->31|63->31|66->34|66->34|70->38|70->38|77->45|77->45|78->46|78->46
                  -- GENERATED --
              */
          