
package views.html.telco.dashboard

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

object DashboardTelco_statistical_listBlockDebit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="listBlockDebitModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <span class="modal-title" id="myModalLabel">"""),_display_(/*5.54*/Messages("Danh sách thuê bao chặn 1 chiều nợ cước")),format.raw/*5.105*/("""</span>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12" style="border-radius: 8px;">
            <table class="table table-striped" id="tableBlockDebit" style="width: 100%;">
              <thead style="background-color: #ff000054;">
                <tr>
                  <th>"""),_display_(/*13.24*/Messages("STT")),format.raw/*13.39*/("""</th>
                  <th>"""),_display_(/*14.24*/Messages("Số thuê bao")),format.raw/*14.47*/("""</th>
                  """),format.raw/*15.51*/("""
                  """),format.raw/*16.19*/("""<th>"""),_display_(/*16.24*/Messages("Trạng thái chặn cắt")),format.raw/*16.55*/("""</th>
                  """),format.raw/*17.65*/("""
                """),format.raw/*18.17*/("""</tr>
              </thead>
              <tbody></tbody>
            </table>
            <div class="material-datatables row row-cols-auto g-3" style="margin: 10px 15px 5px 0px;">
              <div class="row">
                <div class="col-md-4">
                  </div>
                <div class="col-md-8">
                  <div class="dataTables_paginate paging_full_numbers" id="pagingTableBlockDebit" style="cursor: pointer; right: 15px; position: absolute;"></div>
                </div>
              </div>

              <input id="pageBlockDebit" value="1" style="display: none">
              <input id="pageSizeBlockDebit" value="10" style="display: none">
            </div>
          </div>
        </div>
      </div>
      <div class="modal-footer mt-1">
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*38.77*/Messages("btnClose")),format.raw/*38.97*/("""</button>
        <button type="button" class="btn btn-success" onclick="downloadBlockDebit(1)">"""),_display_(/*39.88*/Messages("Download")),format.raw/*39.108*/("""</button>
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
                  DATE: Mon Sep 22 16:32:52 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/dashboard/DashboardTelco_statistical_listBlockDebit.scala.html
                  HASH: 9647f655bc9c00ee9f44dcd16f463b511dd025fe
                  MATRIX: 1082->0|1443->335|1515->386|1875->719|1911->734|1967->763|2011->786|2063->842|2110->861|2142->866|2194->897|2246->967|2291->984|3175->1841|3216->1861|3340->1958|3382->1978
                  LINES: 33->1|37->5|37->5|45->13|45->13|46->14|46->14|47->15|48->16|48->16|48->16|49->17|50->18|70->38|70->38|71->39|71->39
                  -- GENERATED --
              */
          