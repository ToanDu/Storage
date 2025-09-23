
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

object Location_listIsdn extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div id="listIsdnCellModal" class="modal fixed-left fade" data-bs-backdrop="static" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-dialog-aside" role="document">
    <div class="modal-content">

      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel" style="text-align: left;">"""),_display_(/*6.83*/Messages("Danh sách thuê bao")),format.raw/*6.113*/("""</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" style="position: fixed;top: 30px;right: 15px; background-color: #aaa;"></button>
      </div>
      <div class="modal-body" style="padding-top: 0px;">
        <div class="row">
          <label class="col-sm-12 col-form-label title-section-2 font-600">"""),_display_(/*11.77*/Messages("Tổng số thuê bao: ")),format.raw/*11.107*/("""<span class="font-400" id="countIsdnCell"></span></label>
        </div>
        <div class="row">
          <label class="col-sm-12 col-form-label title-section-2 font-600">"""),_display_(/*14.77*/Messages("Địa chỉ: ")),format.raw/*14.98*/("""<span class="font-400" id="addressIsdnCell"></span></label>
        </div>
        <div class="row">
          <label class="col-sm-3 col-form-label title-section-2 font-600">"""),_display_(/*17.76*/Messages("Số thuê bao: ")),format.raw/*17.101*/("""</label>
          <div class="col-sm-9 input-icons">
            <div class="input-group">
              <input id="isdnSearch" type="text" class="form-control input-form" style="border-right: 0px;" placeholder="Nhập nội dung" onkeypress="return isNumberKey(event)" maxlength="10000" required="">
              <a onclick="getIsdnListWitdCellAndPaging()" class="input-group-text cursor-pointer" style="border-left: 0px; background-color: #ffffff">
                <img src=""""),_display_(/*22.28*/routes/*22.34*/.Assets.versioned("images/telco/search.png")),format.raw/*22.78*/("""" class="" alt="...">
              </a>
            </div>
          </div>
        </div>
        <div class="row mt-3">
          <div class="table-responsive" style="border-radius: 8px;">
            <table class="table table-striped" id="listIsdnInCellTable" style="width: 100%; margin-bottom: 0px;">
              <thead style="background-color: #eee;">
                <tr>
                  <th>STT</th>
                  <th>Số thuê bao</th>
                  <th>Gói cước</th>
                  <th>Tình trạng</th>
                  <th>Lưu lượng</th>
                  <th>Lịch sử vị trí</th>
                </tr>
              </thead>
              <tbody></tbody>
            </table>
            <h5 class="mt-3" id="notiNotDataSubs" style="text-align: center;"></h5>
          </div>
          <div class="material-datatables row row-cols-auto g-3" style="margin-bottom: 5px; margin-bottom: 10px;" id="divPagingTable">
            <div class="row">
              <div class="col-md-4">
                <div class="dropdown">
                  <button class="btn dropdown-toggle text-white" type="button" data-bs-toggle="dropdown" aria-expanded="false" id="countPageSize" style="background-color: rgb(0 0 0 / 50%); margin-left: 5px;">10</button>
                  <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="javascript:ApplyFilter(1,10,true)">10</a></li>
                    <li><a class="dropdown-item" href="javascript:ApplyFilter(1,50,true)">50</a></li>
                    <li><a class="dropdown-item" href="javascript:ApplyFilter(1,100,true)">100</a></li>
                    <li><a class="dropdown-item" href="javascript:ApplyFilter(1,200,true)">200</a></li>
                  </ul>
                </div>
              </div>
              <div class="col-md-8">
                <div class="dataTables_paginate paging_full_numbers" id="pagingTable" style="cursor: pointer; right: 5px; position: absolute;"></div>
              </div>
            </div>

            <input name="page" id="page" value="1" style="display: none">
            <input name="pageSize" id="pageSize" value="10" style="display: none">
          </div>
        </div>
      </div>
      <div class="modal-footer">

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/location/Location_listIsdn.scala.html
                  HASH: 7fdc4b041d8345ee519a31770423814f6bfd6a59
                  MATRIX: 1057->0|1408->325|1459->355|1836->705|1888->735|2090->910|2132->931|2335->1107|2382->1132|2885->1608|2900->1614|2965->1658
                  LINES: 33->1|38->6|38->6|43->11|43->11|46->14|46->14|49->17|49->17|54->22|54->22|54->22
                  -- GENERATED --
              */
          