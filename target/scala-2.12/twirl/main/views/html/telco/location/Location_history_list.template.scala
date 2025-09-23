
package views.html.telco.location

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

object Location_history_list extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*25.14*/fromTime/*25.22*/ = {{
              import java.util.Calendar
              import java.text.SimpleDateFormat

              val today = Calendar.getInstance
              today.add(Calendar.DATE,-6);
              val curTimeFormat = new SimpleDateFormat("dd/MM/yyyy")
              curTimeFormat.format(today.getTime)
            }};def /*34.14*/toTime/*34.20*/ = {{
              import java.util.Calendar
              import java.text.SimpleDateFormat
              //import java.util.TimeZone

              val today = Calendar.getInstance()
              // today.setTimeZone(TimeZone.getTimeZone("GMT+7"))
              val curTimeFormat = new SimpleDateFormat("dd/MM/yyyy")
              curTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT+7"));
              curTimeFormat.format(today.getTime)
            }};
Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="listHistoryModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <span class="modal-title" id="exampleModalLabel">"""),_display_(/*5.59*/Messages("Lịch sử vị trí thuê bao")),format.raw/*5.94*/("""</span>
      </div>
      <div class="modal-body">
        <div class="col-md-12">
          <div class="row">
            <div class="col-md-3">
              <label class="col-sm-12 col-form-label title-section-2">"""),_display_(/*11.72*/Messages("Thuê bao")),format.raw/*11.92*/("""</label>
            </div>
            <div class="col-md-3">
              <label class="col-sm-12 col-form-label title-section-2">"""),_display_(/*14.72*/Messages("Từ ngày")),format.raw/*14.91*/("""</label>
            </div>
            <div class="col-md-3">
              <label class="col-sm-12 col-form-label title-section-2">"""),_display_(/*17.72*/Messages("Đến ngày")),format.raw/*17.92*/("""</label>
            </div>
          </div>
          <div class="row mt-1">
            <div class="col-md-3">
              <input id="isdnHistory" type="text" class="form-control input-form" readonly>
              <input id="serialHistory" type="text" class="form-control input-form" readonly hidden>
            </div>
            """),format.raw/*33.14*/("""
            """),format.raw/*44.14*/("""
            """),format.raw/*45.13*/("""<div class="col-md-3">
              <input class="form-control datetimepicker" type="text" id="fromDateHistory" value=""""),_display_(/*46.99*/fromTime),format.raw/*46.107*/("""" placeholder="Từ ngày">
            </div>
            <div class="col-md-3">
              <input class="form-control datetimepicker" type="text" id="toDateHistory" value=""""),_display_(/*49.97*/toTime),format.raw/*49.103*/("""" placeholder="Đến ngày">
            </div>
            <div class="col-md-3">
              <button type="button" class="btn btn-search" onclick="searchHistoryIsdn()">"""),_display_(/*52.91*/Messages("btnSearch")),format.raw/*52.112*/("""</button>
            </div>
          </div>
        </div>
        <div class="col-md-12">
          <div class="row mt-3">
            <div class="table-responsive" style="border-radius: 8px;">
              <table class="table table-striped" id="listHistoryIsdnTable" style="width: 100%; margin-bottom: 0px;">
                <thead style="background-color: #eee;">
                  <tr>
                    <th>STT</th>
                    <th>Số thuê bao</th>
                    <th>Thời gian</th>
                    <th>Vị trí</th>
                    <th>Tọa độ</th>
                  </tr>
                </thead>
                <tbody></tbody>
              </table>
              <h5 class="mt-3" id="notiNotHistoryIsdn" style="text-align: center;"></h5>
            </div>
            <div class="material-datatables row row-cols-auto g-3" style="margin-bottom: 5px; margin-bottom: 10px;">
              <div class="row">
                <div class="col-md-4">
                  <div class="dropdown">
                    <button class="btn dropdown-toggle text-white" type="button" data-bs-toggle="dropdown" aria-expanded="false" id="countPageSizeHistoryIsdn" style="background-color: rgb(0 0 0 / 50%); margin-left: 5px;">10</button>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="javascript:ApplyFilterHistoryIsdn(1,10,true)">10</a></li>
                      <li><a class="dropdown-item" href="javascript:ApplyFilterHistoryIsdn(1,50,true)">50</a></li>
                      <li><a class="dropdown-item" href="javascript:ApplyFilterHistoryIsdn(1,100,true)">100</a></li>
                      <li><a class="dropdown-item" href="javascript:ApplyFilterHistoryIsdn(1,200,true)">200</a></li>
                    </ul>
                  </div>
                </div>
                <div class="col-md-8">
                  <div class="dataTables_paginate paging_full_numbers" id="pagingTableHistoryIsdn" style="cursor: pointer; right: 15px; position: absolute;"></div>
                </div>
              </div>

              <input name="page" id="pageHistoryIsdn" value="1" style="display: none">
              <input name="pageSize" id="pageSizeHistoryIsdn" value="10" style="display: none">
            </div>
          </div>
        </div>

        <div class="modal-footer">
          <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*98.81*/Messages("btnClose")),format.raw/*98.101*/("""</button>
        </div>
      </div>

    </div>
  </div> <!-- modal-bialog .// -->
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
                  DATE: Mon Sep 22 16:32:53 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/location/Location_history_list.scala.html
                  HASH: 16159f90a8147e23d22557fab4f2cba795dbbdf1
                  MATRIX: 1047->1277|1064->1285|1396->1616|1411->1622|1896->0|2281->359|2336->394|2581->612|2622->632|2783->766|2823->785|2984->919|3025->939|3390->1602|3431->2078|3472->2091|3620->2212|3650->2220|3852->2395|3880->2401|4077->2571|4120->2592|6582->5027|6624->5047
                  LINES: 32->25|32->25|40->34|40->34|51->1|55->5|55->5|61->11|61->11|64->14|64->14|67->17|67->17|75->33|76->44|77->45|78->46|78->46|81->49|81->49|84->52|84->52|130->98|130->98
                  -- GENERATED --
              */
          