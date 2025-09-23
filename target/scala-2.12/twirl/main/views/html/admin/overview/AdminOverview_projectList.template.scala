
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

object AdminOverview_projectList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-md-12">
  <div class="row">
    <div class="col-md-4" >
      <div class="input-group mb-3" id="tabSelectTag">
        <select id="tagsSelect">
        </select>
        <button class="btn btn-dark" type="button" onclick="getListProjectAdmin()">"""),_display_(/*7.85*/Messages("Áp dụng")),format.raw/*7.104*/("""</button>
      </div>

    </div>
    <div class="col-md-4">
      <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">"""),_display_(/*13.59*/Messages("Sắp xếp")),format.raw/*13.78*/("""</span>
        <select class="form-select" id="sortKey" onchange="getListProjectAdmin()">
          <option value="msg_quantity">"""),_display_(/*15.41*/Messages("Số bản tin")),format.raw/*15.63*/("""</option>
          <option value="device_quantity">"""),_display_(/*16.44*/Messages("Thiết bị đã kích hoạt")),format.raw/*16.77*/("""</option>
          <option value="device_active">"""),_display_(/*17.42*/Messages("Thiết bị đang hoạt động")),format.raw/*17.77*/("""</option>
          <option value="user_quantity">"""),_display_(/*18.42*/Messages("Số khách hàng")),format.raw/*18.67*/("""</option>
          """),format.raw/*19.74*/("""
          """),format.raw/*20.11*/("""<option value="created_time" selected>"""),_display_(/*20.50*/Messages("Ngày tạo")),format.raw/*20.70*/("""</option>
        </select>
        <select class="form-select" id="sortType" onchange="getListProjectAdmin()">
          <option value="DESC" selected>"""),_display_(/*23.42*/Messages("Giảm dần")),format.raw/*23.62*/("""</option>
          <option value="ASC" >"""),_display_(/*24.33*/Messages("Tăng dần")),format.raw/*24.53*/("""</option>
        </select>
      </div>
    </div>
    <div class="col-md-3">
      <div class="input-group mb-3">
        <button class="btn btn-dark" type="button" id="button-addon1" onclick="getListProjectAdmin()">"""),_display_(/*30.104*/Messages("Tìm kiếm")),format.raw/*30.124*/("""</button>
        <input id="searchNameProject" type="text" class="form-control" placeholder="...Tìm kiếm theo tên dự án" aria-describedby="button-addon1">
      </div>
    </div>
    <div class="col-md-1">
      <div class="input-group mb-3">
        <button class="btn btn-success" onclick="exportListProject()">"""),_display_(/*36.72*/Messages("Export")),format.raw/*36.90*/("""</button>
      </div>
    </div>
  </div>

  <div id="tabListProject" class="mt-3" style="width: 100%;"></div>
  <div class="material-datatables mt-3 mb-3">
    <input name="page" id="page" value="1" style="display: none">
    <input name="pageSize" id="pageSize" value="50" style="display: none">
    <input name="isResetPage" id="isResetPage" value="false" style="display: none">
    <div class="dataTables_paginate paging_full_numbers" id="pagingTable" style="cursor: pointer;"></div>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/admin/overview/AdminOverview_projectList.scala.html
                  HASH: ff67a636b48272fca47785a39d2b2b1dff972218
                  MATRIX: 1065->0|1353->262|1393->281|1577->438|1617->457|1775->588|1818->610|1898->663|1952->696|2030->747|2086->782|2164->833|2210->858|2258->941|2297->952|2363->991|2404->1011|2584->1164|2625->1184|2694->1226|2735->1246|2982->1465|3024->1485|3366->1800|3405->1818
                  LINES: 33->1|39->7|39->7|45->13|45->13|47->15|47->15|48->16|48->16|49->17|49->17|50->18|50->18|51->19|52->20|52->20|52->20|55->23|55->23|56->24|56->24|62->30|62->30|68->36|68->36
                  -- GENERATED --
              */
          