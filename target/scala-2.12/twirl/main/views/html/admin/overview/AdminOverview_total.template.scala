
package views.html.admin.overview

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

object AdminOverview_total extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*96.12*/fromTime/*96.20*/ = {{
            import java.util.Calendar
            import java.text.SimpleDateFormat

            val today = Calendar.getInstance
            today.add(Calendar.DATE,-0);
            val curTimeFormat = new SimpleDateFormat("MM-yyyy")
            curTimeFormat.format(today.getTime)
          }};def /*105.12*/toTime/*105.18*/ = {{
            import java.util.Calendar
            import java.text.SimpleDateFormat
            //import java.util.TimeZone

            val today = Calendar.getInstance()
            // today.setTimeZone(TimeZone.getTimeZone("GMT+7"))
            val curTimeFormat = new SimpleDateFormat("dd-MM-yyyy")
            curTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT+7"));
            curTimeFormat.format(today.getTime)
          }};
Seq[Any](format.raw/*1.1*/("""<div class="col-md-12">
  <div class="row row-cols-1 row-cols-md-2 row-cols-xl-5 row-group g-0">
    <div class="col" style="padding-right: 15px; cursor: pointer;">
      <div class="card-body card radius-10" style="border: 1px solid #EE0033;" id="tabTotalDevice" onclick="changeChartTotal(1)">
        <div class="d-flex align-items-center">
          <h5 class="mb-0" id="totalDevice">0</h5>
          <div class="ms-auto">
            <i class='bx bx-chip fs-3'></i>
          </div>
        </div>
        <div class="progress my-3" style="height:3px; background-color: #aaa;">
          <div class="progress-bar" role="progressbar" style="width: 25%; background-color: #0d6efd;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
        </div>
        <div class="d-flex align-items-center">
          <p class="mb-0">"""),_display_(/*15.28*/Messages("Tổng số thiết bị")),format.raw/*15.56*/("""</p>
        </div>
      </div>
    </div>

    <div class="col" style="padding-right: 15px; cursor: pointer;">
      <div class="card-body card radius-10" id="tabTotalProject" onclick="changeChartTotal(2)">
        <div class="d-flex align-items-center">
          <h5 class="mb-0" id="totalProject">0</h5>
          <div class="ms-auto">
            <i class='bx bx-folder-open fs-3'></i>
          </div>
        </div>
        <div class="progress my-3" style="height:3px; background-color: #aaa;">
          <div class="progress-bar" role="progressbar" style="width: 15%; background-color: #0d6efd;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
        </div>
        <div class="d-flex align-items-center">
          <p class="mb-0">"""),_display_(/*32.28*/Messages("Tổng số dự án")),format.raw/*32.53*/("""</p>
        </div>
      </div>
    </div>

    <div class="col" style="padding-right: 15px; cursor: pointer;">
      <div class="card-body card radius-10" id="tabTotalUser" onclick="changeChartTotal(3)">
        <div class="d-flex align-items-center">
          <h5 class="mb-0" id="totalUser">0</h5>
          <div class="ms-auto">
            <i class='bx bx-group fs-3'></i>
          </div>
        </div>
        <div class="progress my-3" style="height:3px; background-color: #aaa;">
          <div class="progress-bar" role="progressbar" style="width: 15%; background-color: #0d6efd;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
        </div>
        <div class="d-flex align-items-center">
          <p class="mb-0">"""),_display_(/*49.28*/Messages("Tổng số developer")),format.raw/*49.57*/("""</p>
        </div>
      </div>
    </div>

    <div class="col" style="padding-right: 15px; cursor: pointer;">
      <div class="card-body card radius-10" id="tabTotalDevelopActive" onclick="changeChartTotal(5)">
        <div class="d-flex align-items-center">
          <h5 class="mb-0" id="totalDevelopActive">0</h5>
          <div class="ms-auto">
            <i class='bx bx-group fs-3'></i>
          </div>
        </div>
        <div class="progress my-3" style="height:3px; background-color: #aaa;">
          <div class="progress-bar" role="progressbar" style="width: 10%; background-color: #0d6efd;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
        </div>
        <div class="d-flex align-items-center">
          <p class="mb-0">"""),_display_(/*66.28*/Messages("Tổng số developer active")),format.raw/*66.64*/("""</p>
        </div>
      </div>
    </div>

    <div class="col" style="cursor: pointer;">
      <div class="card-body card radius-10" id="tabTotalCustomer" onclick="changeChartTotal(4)">
        <div class="d-flex align-items-center">
          <h5 class="mb-0" id="totalCustomer">0</h5>
          <div class="ms-auto">
            <i class='bx bx-user-circle fs-3'></i>
          </div>
        </div>
        <div class="progress my-3" style="height:3px; background-color: #aaa;">
          <div class="progress-bar" role="progressbar" style="width: 20%; background-color: #0d6efd;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
        </div>
        <div class="d-flex align-items-center">
          <p class="mb-0">"""),_display_(/*83.28*/Messages("Tổng số Khách hàng")),format.raw/*83.58*/("""</p>
        </div>
      </div>
    </div>
  </div>

  <div class="row">
    <div class="col-12 col-lg-12 d-flex">
      <div class="card radius-10 w-100">
        <div class="card-body" id="chartTotalOverview">
        </div>

        <div class="card-body">
          """),format.raw/*104.12*/("""
          """),format.raw/*115.12*/("""

          """),format.raw/*117.11*/("""<div class="row">
            <div class="form-group col-md-4">
              <div class="row">
                <label class="col-md-3 col-form-label" style="text-align: center">"""),_display_(/*120.84*/Messages("Từ ")),format.raw/*120.99*/("""</label>
                <div class="col-md-8">
                  <div class="form-group">
                    <input class="result form-control" type="text" id="date_timepicker_start" value="01-"""),_display_(/*123.106*/fromTime),format.raw/*123.114*/("""">
                  </div>
                </div>
              </div>
            </div>

            <div class="form-group col-md-4">
              <div class="row">
                <label class="col-md-3 col-form-label" style="text-align: center">"""),_display_(/*131.84*/Messages("Đến ")),format.raw/*131.100*/("""</label>
                <div class="col-md-8">
                  <div class="form-group has-default">
                    <input class="result form-control" type="text" id="date_timepicker_end" value=""""),_display_(/*134.101*/toTime),format.raw/*134.107*/("""">
                  </div>
                </div>
              </div>
            </div>

            <div class="btn-group col-md-4" role="group">
              <a type="button" class="btn btn-primary" id="buttonGetDataChart" onclick="getDataChartDevice()" style="width: 48%">"""),_display_(/*141.131*/Messages("Áp dụng ")),format.raw/*141.151*/("""</a>
              <a type="button" class="btn btn-success" id="buttonDataDevelopExport" onclick="exportDataDevelopActive()" style="width: 48%; display: none;">"""),_display_(/*142.157*/Messages("Export file")),format.raw/*142.180*/("""</a>
            </div>
          </div>

        </div>

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
                  DATE: Mon Sep 22 16:32:40 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/admin/overview/AdminOverview_total.scala.html
                  HASH: d543191fb7b08eea9818ab8203efaf475e21bb7a
                  MATRIX: 1045->4273|1062->4281|1378->4593|1394->4599|1861->0|2726->838|2775->866|3562->1626|3608->1651|4383->2399|4433->2428|5226->3194|5283->3230|6051->3971|6102->4001|6402->4581|6442->5037|6483->5049|6690->5228|6727->5243|6952->5439|6983->5447|7264->5700|7303->5716|7535->5919|7564->5925|7873->6205|7916->6225|8106->6386|8152->6409
                  LINES: 32->96|32->96|40->105|40->105|51->1|65->15|65->15|82->32|82->32|99->49|99->49|116->66|116->66|133->83|133->83|146->104|147->115|149->117|152->120|152->120|155->123|155->123|163->131|163->131|166->134|166->134|173->141|173->141|174->142|174->142
                  -- GENERATED --
              */
          