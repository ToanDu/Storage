
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

object exportReportModal extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Boolean,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(isRedBaring: Boolean = true):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.31*/("""
"""),format.raw/*2.1*/("""<div class="modal fade" id="exportReportModal" tabindex="-1" aria-labelledby="reportModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title">"""),_display_(/*6.34*/Messages("Xuất file excel")),format.raw/*6.61*/("""</h5>
      </div> 
      <div class="modal-body" style="padding-left: 3rem; padding-right: 3rem;">
        <div class="row g-3 justify-content-center">
          <div class="col-md-12">
            <div class="row mt-3">
              <label class="col-sm-4 col-form-label title-section-2 text-end">"""),_display_(/*12.80*/Messages("Số lượng bản ghi trên 1 file")),format.raw/*12.120*/("""</label>
              <div id="report-page-size-field" class="col-sm-8">
                <input id="report-page-size" type="text" onkeyup="validatePageSize()" class="form-control form-info" value="1000" onkeypress="return isNumberKey(event)" autocomplete="off" required>
                <div class="helper-text form-text mt-2">
                  """),_display_(/*16.20*/Messages("** Tối đa 1000 bản ghi trên 1 file")),format.raw/*16.66*/("""
                """),format.raw/*17.17*/("""</div>
                <div class="error-text text-danger form-text mt-2">
                </div>
              </div>
            </div>
            <div class="row mt-3 justify-content-center">
              """),_display_(/*23.16*/if(isRedBaring)/*23.31*/{_display_(Seq[Any](format.raw/*23.32*/("""
              """),format.raw/*24.15*/("""<button type="button" class="btn_cmp is-primary fs-6 fw-normal" style="width: 10rem;"
                onclick="getRedBaringFiles(1)">"""),_display_(/*25.49*/Messages("Tạo file dữ liệu ")),format.raw/*25.78*/("""</button>
              """)))}/*26.16*/else/*26.21*/{_display_(Seq[Any](format.raw/*26.22*/("""
              """),format.raw/*27.15*/("""<button type="button" class="btn_cmp is-primary fs-6 fw-normal" style="width: 10rem;"
                onclick="getExpiratedPackageFiles(1)">"""),_display_(/*28.56*/Messages("Tạo file dữ liệu ")),format.raw/*28.85*/("""</button>
              """)))}),format.raw/*29.16*/("""
            """),format.raw/*30.13*/("""</div>
          </div>
        </div>
        <div class="mx-2">
          <hr />
        </div>
        <div class="row g-3 mt-3">
          <div class="text-end mb-2" id="addBtnDownloadAll">
            <span class="text-darker" id="btnDownloadAll" style="cursor: pointer; text-decoration: underline;">Tải xuống tất cả</span>
          </div>
          <div class="row mx-1 mb-1" id="report-export-table-container">
            <table id="file_export" class="table table-striped table-bordered" cellspacing="0" width="100%">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th class="text-center">STT</th>
                  <th>File</th>
                  <th>Thao tác</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td colspan="3" class="text-center">Chưa có dữ liệu</td>
                </tr>
              </tbody>
            </table>
          </div>
        <div class="row pagination-section">
          <div class="col-md-4 d-flex align-items-center justify-content-center justify-content-md-start mb-3">
            <p class="mb-0">Tổng <span id="total_record">0</span> bản ghi</p>
          </div>
          <div class="col-md-8 d-flex flex-column flex-md-row justify-content-end align-items-center gap-2 gap-md-3 mb-3">
            <div class="dropdown mb-2 mb-md-0">
              <button class="btn btn-sm dropdown-toggle btn-outline-dark" type="button" data-bs-toggle="dropdown"
                aria-expanded="false" id="countPageSize" style="margin-left: 5px;">
                10
              </button>
              """),_display_(/*66.16*/if(isRedBaring)/*66.31*/{_display_(Seq[Any](format.raw/*66.32*/("""
              """),format.raw/*67.15*/("""<ul class="dropdown-menu">
                <li><a class="dropdown-item" href="javascript:handleChangePageSizeModalRedBaring(1,10)">10</a></li>
                <li><a class="dropdown-item" href="javascript:handleChangePageSizeModalRedBaring(1,50)">50</a></li>
                <li><a class="dropdown-item" href="javascript:handleChangePageSizeModalRedBaring(1,100)">100</a></li>
                <li><a class="dropdown-item" href="javascript:handleChangePageSizeModalRedBaring(1,200)">200</a></li>
                <li><a class="dropdown-item" href="javascript:handleChangePageSizeModalRedBaring(1,500)">500</a></li>
              </ul>
              """)))}/*74.16*/else/*74.21*/{_display_(Seq[Any](format.raw/*74.22*/("""
              """),format.raw/*75.15*/("""<ul class="dropdown-menu">
                <li><a class="dropdown-item" href="javascript:handleChangePageSizeModalExpiratedPackage(1,10)">10</a></li>
                <li><a class="dropdown-item" href="javascript:handleChangePageSizeModalExpiratedPackage(1,50)">50</a></li>
                <li><a class="dropdown-item" href="javascript:handleChangePageSizeModalExpiratedPackage(1,100)">100</a></li>
                <li><a class="dropdown-item" href="javascript:handleChangePageSizeModalExpiratedPackage(1,200)">200</a></li>
                <li><a class="dropdown-item" href="javascript:handleChangePageSizeModalExpiratedPackage(1,500)">500</a></li>
              </ul>
              """)))}),format.raw/*82.16*/("""
              
            """),format.raw/*84.13*/("""</div>
            <p class="mb-2 mb-md-0">"""),_display_(/*85.38*/Messages("Bản ghi/trang")),format.raw/*85.63*/("""</p>
            <div id="pagingTable" class="justify-content-md-end"></div>
          </div>
          <div>
            <input type="hidden" name="page" id="page" value="1" />
            <input type="hidden" name="pageSize" id="pageSize" value="10" />
            <input type="hidden" name="isResetPage" id="isResetPage" value="false" />
          </div>
</div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn_cmp is-outline mt-3 fs-6 fw-normal"
          data-bs-dismiss="modal">"""),_display_(/*98.36*/Messages("btnClose")),format.raw/*98.56*/("""</button>

      </div>
    </div>
  </div>
</div>"""))
      }
    }
  }

  def render(isRedBaring:Boolean): play.twirl.api.HtmlFormat.Appendable = apply(isRedBaring)

  def f:((Boolean) => play.twirl.api.HtmlFormat.Appendable) = (isRedBaring) => apply(isRedBaring)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/statisticalReport/exportReportModal.scala.html
                  HASH: 7495f8ab2049d55484c1f474d37718f027a42dfb
                  MATRIX: 985->1|1109->30|1136->31|1427->296|1474->323|1802->624|1864->664|2239->1012|2306->1058|2351->1075|2589->1286|2613->1301|2652->1302|2695->1317|2856->1451|2906->1480|2950->1505|2963->1510|3002->1511|3045->1526|3213->1667|3263->1696|3319->1721|3360->1734|5037->3384|5061->3399|5100->3400|5143->3415|5810->4063|5823->4068|5862->4069|5905->4084|6619->4767|6675->4795|6746->4839|6792->4864|7357->5402|7398->5422
                  LINES: 28->1|33->1|34->2|38->6|38->6|44->12|44->12|48->16|48->16|49->17|55->23|55->23|55->23|56->24|57->25|57->25|58->26|58->26|58->26|59->27|60->28|60->28|61->29|62->30|98->66|98->66|98->66|99->67|106->74|106->74|106->74|107->75|114->82|116->84|117->85|117->85|130->98|130->98
                  -- GENERATED --
              */
          