
package views.html.telco.admin

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

object SpenterpriseAdminInfo extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="infoAdminSuperenModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("Duyệt thông tin Admin/Đại lý")),format.raw/*5.108*/("""</h5>
      </div>

      <div class="modal-body">
        <input id="idUserAdminSperen" type="text" class="form-control input-form" readonly hidden>
        <div class="col-md-12 m-t-3">
          <div class="row">
            <div >
              <div class="table-responsive mb-3" style="border-radius: 8px;">
                <table class="table table-striped" id="listEnterpriseTable" style="width: 100%;">
                  <thead style="background-color: #FBCCD6;">
                    <tr>
                      <th>"""),_display_(/*17.28*/Messages("STT")),format.raw/*17.43*/("""</th>
                      <th>"""),_display_(/*18.28*/Messages("Tên DN")),format.raw/*18.46*/("""</th>
                      <th>"""),_display_(/*19.28*/Messages("GPKD")),format.raw/*19.44*/("""</th>
                      <th>"""),_display_(/*20.28*/Messages("Thao tác")),format.raw/*20.48*/("""</th>
                      <th style="text-align: center">"""),_display_(/*21.55*/Messages("Kiểm duyệt")),format.raw/*21.77*/("""</th>
                    </tr>
                  </thead>
                  <tbody></tbody>
                </table>
                <h5 id="notiNotDataDetail" style="text-align: center;"></h5>
              </div>
              <div class="material-datatables row row-cols-auto g-3" style="margin-bottom: 5px; margin-right: 10px;" id="">
                <div class="row">
                  <div class="col-md-4">
                    <div class="dropdown">
                      <button class="btn dropdown-toggle text-white" type="button" data-bs-toggle="dropdown" aria-expanded="false" id="countPageSizeDetail" style="background-color: rgb(0 0 0 / 50%);">10</button>
                      <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="javascript:ApplyFilterDetail(1,10,true)">10</a></li>
                        <li><a class="dropdown-item" href="javascript:ApplyFilterDetail(1,50,true)">50</a></li>
                        <li><a class="dropdown-item" href="javascript:ApplyFilterDetail(1,100,true)">100</a></li>
                        <li><a class="dropdown-item" href="javascript:ApplyFilterDetail(1,200,true)">200</a></li>
                        <li><a class="dropdown-item" href="javascript:ApplyFilterDetail(1,500,true)">500</a></li>
                      </ul>
                    </div>
                  </div>
                  <div class="col-md-8">
                    <div class="dataTables_paginate paging_full_numbers" id="pagingTableDetail" style="cursor: pointer; right: 15px; position: absolute;"></div>
                  </div>
                </div>

                <input name="pageDetail" id="pageDetail" value="1" style="display: none">
                <input name="pageSizeDetail" id="pageSizeDetail" value="10" style="display: none">
                <input name="isResetPageDetail" id="isResetPage" value="false" style="display: none">
              </div>
            </div>
            <hr>
          </div>

          <div class="row">
            <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*56.69*/Messages("Lý do từ chối")),format.raw/*56.94*/("""</label>
            <div class="col-sm-10">
              <textarea class="form-control" id="descriptionDetail" rows="2" maxlength="500"></textarea>
            </div>
          </div>

        </div>
      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" onclick="" data-bs-dismiss="modal">"""),_display_(/*66.93*/Messages("Đóng")),format.raw/*66.109*/("""</button>
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
                  DATE: Mon Sep 22 16:32:50 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/admin/SpenterpriseAdminInfo.scala.html
                  HASH: 0062edc8211a9de491ccb92400035e42d0049f64
                  MATRIX: 1058->0|1479->395|1540->435|2091->959|2127->974|2187->1007|2226->1025|2286->1058|2323->1074|2383->1107|2424->1127|2511->1187|2554->1209|4659->3287|4705->3312|5073->3653|5111->3669
                  LINES: 33->1|37->5|37->5|49->17|49->17|50->18|50->18|51->19|51->19|52->20|52->20|53->21|53->21|88->56|88->56|98->66|98->66
                  -- GENERATED --
              */
          