
package views.html.admin.overview.project

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

object AdminOverview_detailProject_total extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*81.12*/fromTime/*81.20*/ = {{
            import java.util.Calendar
            import java.text.SimpleDateFormat

            val today = Calendar.getInstance
            today.add(Calendar.DATE,-0);
            val curTimeFormat = new SimpleDateFormat("MM-yyyy")
            curTimeFormat.format(today.getTime)
          }};def /*90.12*/toTime/*90.18*/ = {{
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


  <div class="row row-cols-1 row-cols-md-2 row-cols-xl-4 row-group g-0">
    <div class="col" style="padding-right: 15px; cursor: pointer;">
      <div class="card-body card radius-10" style="border: 1px solid #EE0033;" id="tabTotalDeviceActive" onclick="changeChartTotal(1)">
        <div class="d-flex align-items-center">
          <h5 class="mb-0" id="totalDeviceActive">0</h5>
          <div class="ms-auto">
            <i class='bx bx-chip fs-3'></i>
          </div>
        </div>
        <div class="progress my-3" style="height:3px; background-color: #aaa;">
          <div class="progress-bar" role="progressbar" style="width: 55%; background-color: #0d6efd;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
        </div>
        <div class="d-flex align-items-center">
          <p class="mb-0">"""),_display_(/*17.28*/Messages("Tổng số thiết bị đã kích hoạt")),format.raw/*17.69*/("""</p>
        </div>
      </div>
    </div>

    <div class="col" style="padding-right: 15px; cursor: pointer;">
      <div class="card-body card radius-10" id="tabTotalDevice" onclick="changeChartTotal(2)">
        <div class="d-flex align-items-center">
          <h5 class="mb-0" id="totalDevice">0</h5>
          <div class="ms-auto">
            <i class='bx bx-chip fs-3'></i>
          </div>
        </div>
        <div class="progress my-3" style="height:3px; background-color: #aaa;">
          <div class="progress-bar" role="progressbar" style="width: 55%; background-color: #0d6efd;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
        </div>
        <div class="d-flex align-items-center">
          <p class="mb-0">"""),_display_(/*34.28*/Messages("Tổng số thiết bị đang hoạt động")),format.raw/*34.71*/("""</p>
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
          <div class="progress-bar" role="progressbar" style="width: 55%; background-color: #0d6efd;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
        </div>
        <div class="d-flex align-items-center">
          <p class="mb-0">"""),_display_(/*51.28*/Messages("Tổng số người dùng - Tenant")),format.raw/*51.67*/("""</p>
        </div>
      </div>
    </div>

    <div class="col" style=" cursor: pointer;">
      <div class="card-body card radius-10" id="tabTotalCustomer" onclick="changeChartTotal(4)">
        <div class="d-flex align-items-center">
          <h5 class="mb-0" id="totalCustomer">0</h5>
          <div class="ms-auto">
            <i class='bx bx-user-circle fs-3'></i>
          </div>
        </div>
        <div class="progress my-3" style="height:3px; background-color: #aaa;">
          <div class="progress-bar" role="progressbar" style="width: 55%; background-color: #0d6efd;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
        </div>
        <div class="d-flex align-items-center">
          <p class="mb-0">"""),_display_(/*68.28*/Messages("Tổng số Khách hàng - Guest Members")),format.raw/*68.74*/("""</p>
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
          """),format.raw/*89.12*/("""
          """),format.raw/*100.12*/("""

          """),format.raw/*102.11*/("""<div class="row">
            <div class="form-group col-md-5">
              <div class="row">
                <label class="col-md-3 col-form-label" style="text-align: center">"""),_display_(/*105.84*/Messages("Từ ")),format.raw/*105.99*/("""</label>
                <div class="col-md-6">
                  <div class="form-group">
                    <input class="result form-control" type="text" id="date_timepicker_start" value="01-"""),_display_(/*108.106*/fromTime),format.raw/*108.114*/("""">
                  </div>
                </div>
              </div>
            </div>

            <div class="form-group col-md-5">
              <div class="row">
                <label class="col-md-3 col-form-label" style="text-align: center">"""),_display_(/*116.84*/Messages("Đến ")),format.raw/*116.100*/("""</label>
                <div class="col-md-6">
                  <div class="form-group has-default">
                    <input class="result form-control" type="text" id="date_timepicker_end" value=""""),_display_(/*119.101*/toTime),format.raw/*119.107*/("""">
                  </div>
                </div>
              </div>
            </div>

            <div class="form-group col-md-2">
              <button type="submit" class="btn btn-primary" id="buttonGetDataChart" onclick="getDataChartDevice()" style="width: 100%;">"""),_display_(/*126.138*/Messages("Áp dụng ")),format.raw/*126.158*/("""</button>
            </div>
          </div>

        </div>
      </div>
    </div>
  </div>

  <div class="row">
    <div class="col-12 col-lg-12 d-flex">
      <div class="card radius-10 w-100">

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/admin/overview/project/AdminOverview_detailProject_total.scala.html
                  HASH: e32d11365fc5feecb20b5bda285bd1977bc147be
                  MATRIX: 1067->3534|1084->3542|1399->3854|1414->3860|1881->0|2760->852|2822->893|3600->1644|3664->1687|4439->2435|4499->2474|5268->3216|5335->3262|5634->3842|5674->4298|5715->4310|5922->4489|5959->4504|6184->4700|6215->4708|6496->4961|6535->4977|6767->5180|6796->5186|7100->5461|7143->5481
                  LINES: 32->81|32->81|40->90|40->90|51->1|67->17|67->17|84->34|84->34|101->51|101->51|118->68|118->68|131->89|132->100|134->102|137->105|137->105|140->108|140->108|148->116|148->116|151->119|151->119|158->126|158->126
                  -- GENERATED --
              */
          