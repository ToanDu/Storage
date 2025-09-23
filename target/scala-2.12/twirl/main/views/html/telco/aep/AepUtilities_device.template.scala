
package views.html.telco.aep

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

object AepUtilities_device extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="row mt-4" id="device-aep" style="display: none;">
  <div class="card">
    <div class="card-body">
      <span class="text-search">"""),_display_(/*4.34*/Messages("Thông tin tìm kiếm")),format.raw/*4.64*/("""</span>
      <input id="gpkd" type="text" class="form-control" readonly hidden>

      <div class="row mt-3">
        <div class="col-md-10">
          <div class="row">
            <div class="col-md-6 m-t-3">
              <div class="row m-b-4">
                <div class="col-sm-1"></div>
                <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*13.73*/Messages("Số thuê bao")),format.raw/*13.96*/("""</label>
                <div class="col-sm-8 input-icons">
                  <div class="input-group">
                    <input id="isdn" type="text" class="form-control input-form" placeholder="Nhập nội dung" onkeypress="return isNumberKey(event)" maxlength="10000" required>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-6 m-t-3">
              <div class="row m-b-4">
                <div class="col-sm-1"></div>
                <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*24.73*/Messages("Serial")),format.raw/*24.91*/("""</label>
                <div class="col-sm-8">
                  <div class="input-group">
                    <input id="serialSim" type="text" class="form-control input-form" placeholder="Nhập nội dung" onkeypress="return isNumberKey(event)"  maxlength="20000" required>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-6 m-t-3">
              <div class="row m-b-4">
                <div class="col-sm-1"></div>
                <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*35.73*/Messages("Mã hợp đồng")),format.raw/*35.96*/("""</label>
                <div class="col-sm-8">
                  <div class="input-group">
                    <input id="accountId" type="text" class="form-control input-form" placeholder="Nhập nội dung" onkeypress="return isNumberKey(event)" maxlength="250" required>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-6 m-t-3">
              <div class="row m-b-4">
                <div class="col-sm-1"></div>
                <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*46.73*/Messages("Loại dịch vụ")),format.raw/*46.97*/("""</label>
                <div class="col-sm-8">
                  <select id="payType" type="text" class="form-select" onchange="choosePayType(this)">
                    <option value="" selected>"""),_display_(/*49.48*/Messages("-- Chọn --")),format.raw/*49.70*/("""</option>
                    <option value="1">"""),_display_(/*50.40*/Messages("Trả sau")),format.raw/*50.59*/("""</option>
                    <option value="2">"""),_display_(/*51.40*/Messages("Trả trước")),format.raw/*51.61*/("""</option>
                  </select>
                </div>
              </div>
            </div>
            <div class="col-md-6 m-t-3">
              <div class="row m-b-4">
                <div class="col-sm-1"></div>
                <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*59.73*/Messages("Gói cước sử dụng")),format.raw/*59.101*/("""</label>
                <div class="col-sm-8">
                  <select id="productCode" type="text" class="form-select">
                    <option value="" selected>"""),_display_(/*62.48*/Messages("-- Chọn --")),format.raw/*62.70*/("""</option>
                  </select>
                </div>
              </div>
            </div>
            <div class="col-md-6 m-t-3">
              <div class="row m-b-4">
                <div class="col-sm-1"></div>
                <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*70.73*/Messages("Tình trạng chặn cắt")),format.raw/*70.104*/("""</label>
                <div class="col-sm-8">
                  <select id="actStatus" type="text" class="form-select">
                    <option value="" selected>"""),_display_(/*73.48*/Messages("-- Hãy chọn loại dịch vụ --")),format.raw/*73.87*/("""</option>
                  </select>
                </div>
              </div>
            </div>

            <div class="col-md-6 m-t-3">
              <div class="row m-b-4">
                <div class="col-sm-1"></div>
                <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*82.73*/Messages("Ngày kích hoạt")),format.raw/*82.99*/("""</label>
                <div class="col-sm-8">
                  <div class="row">
                    <div class="col-sm-6">
                      <input class="form-control datetimepicker" type="text" id="staDatetimeFrom" value="" placeholder="Từ ngày">
                    </div>
                    <div class="col-sm-6">
                      <input class="form-control datetimepicker" type="text" id="staDatetimeTo" value="" placeholder="Đến ngày">
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-6 m-t-3">
              <div class="row m-b-4">
                <div class="col-sm-1"></div>
                <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*98.73*/Messages("Ngày đấu nối")),format.raw/*98.97*/("""</label>
                <div class="col-sm-8">
                  <div class="row">
                    <div class="col-sm-6">
                      <input class="form-control datetimepicker" type="text" id="activeDateFrom" value="" placeholder="Từ ngày">
                    </div>
                    <div class="col-sm-6">
                      <input class="form-control datetimepicker" type="text" id="activeDateTo" value="" placeholder="Đến ngày">
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-2">
          <div class="card-body" style="height: 100%;">
            <div class="">
              <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF; width: 100%;" onclick="onlickButtonSearchSubs()">"""),_display_(/*116.158*/Messages("Tra cứu")),format.raw/*116.177*/("""</button>
              <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033; width: 100%;" onclick="resetFormSearch()">"""),_display_(/*117.151*/Messages("Reset")),format.raw/*117.168*/("""</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="row">
    <div class="col-md-6">
      <h6>"""),_display_(/*127.12*/Messages("Đã chọn ")),format.raw/*127.32*/("""<span style="color: red;" id="countCheckSubs">"""),_display_(/*127.79*/Messages("(0)")),format.raw/*127.94*/("""</span>"""),_display_(/*127.102*/Messages(" thuê bao")),format.raw/*127.123*/("""</h6>
    </div>
    <div class="col-md-6" style="text-align: right;">
      <button type="button" class="btn btn-success mb-2" onclick="showModalCreateDevice()">"""),_display_(/*130.93*/Messages("Tạo thiết bị")),format.raw/*130.117*/("""</button>
    </div>
  </div>

  <div class="card" style="padding-left: 0; padding-right: 0;">
    <div class="table-responsive mb-3" style="border-radius: 8px;">
      <table class="table table-striped" id="listSubsTable" style="width: 100%;">
        <thead style="background-color: #FBCCD6;">
          <tr>
            <th>
              <input class="form-check-input check-all" type="checkbox" id="check-all-subs" onchange="checkAllSubs(this)">
            </th>
            <th>STT</th>
            <th>Số thuê bao</th>
            <th>Mã TB</th>
            <th>Gói cước</th>
            """),format.raw/*146.37*/("""
            """),format.raw/*147.31*/("""
            """),format.raw/*148.13*/("""<th>Serial sim</th>
            <th>TT chặn cắt</th>
            <th>Kích hoạt</th>
            <th>Đấu nối</th>
            <th>Loại DV</th>
            <th style="text-align: center">"""),_display_(/*153.45*/Messages("Hành động")),format.raw/*153.66*/("""</th>
          </tr>
        </thead>
        <tbody></tbody>
      </table>
      <h5 id="notiNotDataSubs" style="text-align: center;"></h5>
    </div>
    <div class="material-datatables row row-cols-auto g-3 mt-1" style="margin-bottom: 5px; margin-bottom: 10px; display: none;" id="divPagingTable">
      <div class="row">
        <div class="col-md-4">
          <div class="dropdown">
            <button class="btn dropdown-toggle text-white" type="button" data-bs-toggle="dropdown" aria-expanded="false" id="countPageSize" style="background-color: rgb(0 0 0 / 50%); margin-left: 5px;">10</button>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="javascript:ApplyFilter(1,10,true)">10</a></li>
              <li><a class="dropdown-item" href="javascript:ApplyFilter(1,50,true)">50</a></li>
              <li><a class="dropdown-item" href="javascript:ApplyFilter(1,100,true)">100</a></li>
              <li><a class="dropdown-item" href="javascript:ApplyFilter(1,200,true)">200</a></li>
              <li><a class="dropdown-item" href="javascript:ApplyFilter(1,500,true)">500</a></li>
            </ul>
          </div>
        </div>
        <div class="col-md-8">
          <div class="dataTables_paginate paging_full_numbers" id="pagingTable" style="cursor: pointer; right: 5px; position: absolute;"></div>
        </div>
      </div>

      <input name="page" id="page" value="1" style="display: none">
      <input name="pageSize" id="pageSize" value="10" style="display: none">
      <input name="isResetPage" id="isResetPage" value="false" style="display: none">
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
                  DATE: Mon Sep 22 16:32:50 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/aep/AepUtilities_device.scala.html
                  HASH: fd86b4f7da74f2b4ead616c26b49ea62c15bf7a0
                  MATRIX: 1054->0|1224->144|1274->174|1668->541|1712->564|2303->1128|2342->1146|2927->1704|2971->1727|3553->2282|3598->2306|3823->2504|3866->2526|3942->2575|3982->2594|4058->2643|4100->2664|4424->2961|4474->2989|4672->3160|4715->3182|5039->3479|5092->3510|5288->3679|5348->3718|5673->4016|5720->4042|6514->4809|6559->4833|7460->5705|7502->5724|7691->5884|7731->5901|7912->6054|7954->6074|8029->6121|8066->6136|8103->6144|8147->6165|8338->6328|8385->6352|9010->6972|9052->7003|9094->7016|9308->7202|9351->7223
                  LINES: 33->1|36->4|36->4|45->13|45->13|56->24|56->24|67->35|67->35|78->46|78->46|81->49|81->49|82->50|82->50|83->51|83->51|91->59|91->59|94->62|94->62|102->70|102->70|105->73|105->73|114->82|114->82|130->98|130->98|148->116|148->116|149->117|149->117|159->127|159->127|159->127|159->127|159->127|159->127|162->130|162->130|178->146|179->147|180->148|185->153|185->153
                  -- GENERATED --
              */
          