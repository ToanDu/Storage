
package views.html.telco.apn

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

object APN_exportModal extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="exportAPNModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">"""),_display_(/*5.57*/Messages("apn.export.title")),format.raw/*5.85*/("""</h5>
      </div> 
      <div class="modal-body" style="padding-left: 3rem; padding-right: 3rem;">
        <div class="row g-3 justify-content-center">
          <div class="col-md-12">
            <div class="row mt-3">
              <label class="col-sm-4 col-form-label title-section-2 text-end">"""),_display_(/*11.80*/Messages("apn.export.recordsPerFile")),format.raw/*11.117*/("""</label>
              <div id="apn-page-size-field" class="col-sm-8">
                <input id="apn-page-size" type="text" onkeyup="validatePageSize()" class="form-control form-info" value="1000" onkeypress="return isNumberKey(event)" autocomplete="off" required>
                <div class="helper-text form-text mt-2">
                  """),_display_(/*15.20*/Messages("apn.export.maxRecordsNote")),format.raw/*15.57*/("""
                """),format.raw/*16.17*/("""</div>
                <div class="error-text text-danger form-text mt-2">
                </div>
              </div>
            </div>
            <div class="row mt-3 justify-content-center">
              <button type="button" class="btn_cmp is-primary fs-6 fw-normal" style="width: 10rem;"
                onclick="getSubscriberFiles(1)">"""),_display_(/*23.50*/Messages("apn.export.createDataFile")),format.raw/*23.87*/("""</button>
            </div>
          </div>
        </div>
        <div class="mx-2">
          <hr />
        </div>
        <div class="row g-3 mt-3">
          <div class="text-end mb-2" id="addBtnDownloadAll">
            <span class="text-darker" id="btnDownloadAll" style="cursor: pointer; text-decoration: underline;">"""),_display_(/*32.113*/Messages("apn.export.downloadAll")),format.raw/*32.147*/("""</span>
          </div>
          <div class="row mx-1 mb-1" id="apn-export-table-container">
            <table id="file_export" class="table table-striped table-bordered" cellspacing="0" width="100%">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th class="text-center">"""),_display_(/*38.44*/Messages("apn.export.serialNumber")),format.raw/*38.79*/("""</th>
                  <th>"""),_display_(/*39.24*/Messages("apn.export.file")),format.raw/*39.51*/("""</th>
                  <th>"""),_display_(/*40.24*/Messages("apn.export.action")),format.raw/*40.53*/("""</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td colspan="3" class="text-center">"""),_display_(/*45.56*/Messages("apn.export.noData")),format.raw/*45.85*/("""</td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="material-datatables row row-cols-auto g-3 mx-1" id="divPagingTable">
            <div class="row">
              <div class="col-md-4">
              </div>
              <div class="col-md-8">
                <div class="dataTables_paginate paging_full_numbers" id="pagingAPNTable"
                  style="cursor: pointer; right: 3rem; position: absolute;"></div>
              </div>
            </div>

            <input name="page" id="apn-page" value="1" style="display: none">
            <input name="isResetPage" id="isResetPage" value="false" style="display: none">
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn_cmp is-outline mt-3 fs-6 fw-normal"
          data-bs-dismiss="modal">"""),_display_(/*67.36*/Messages("common.close")),format.raw/*67.60*/("""</button>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/apn/APN_exportModal.scala.html
                  HASH: 12e995bfbb971301c624058b79a629107c53f364
                  MATRIX: 1050->0|1362->286|1410->314|1738->615|1797->652|2166->994|2224->1031|2269->1048|2641->1393|2699->1430|3055->1758|3111->1792|3463->2117|3519->2152|3575->2181|3623->2208|3679->2237|3729->2266|3905->2415|3955->2444|4860->3322|4905->3346
                  LINES: 33->1|37->5|37->5|43->11|43->11|47->15|47->15|48->16|55->23|55->23|64->32|64->32|70->38|70->38|71->39|71->39|72->40|72->40|77->45|77->45|99->67|99->67
                  -- GENERATED --
              */
          