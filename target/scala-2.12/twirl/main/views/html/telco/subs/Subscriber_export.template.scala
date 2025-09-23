
package views.html.telco.subs

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

object Subscriber_export extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="exportListFileModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
  <span class="modal-title" id="exampleModalLabel">"""),_display_(/*5.53*/Messages("subscriber.modal.export.title")),format.raw/*5.94*/("""</span>
      </div>
      <div class="modal-body bg-white">
        <div class="row justify-content-center">
          <div class="col-md-11">
            <div class="row mb-3">
              <span class="col-sm-4 col-form-label" style="text-align: right;">"""),_display_(/*11.81*/Messages("subscriber.modal.export.dataType")),format.raw/*11.125*/("""</span>
              <div class="col-sm-8">
                <select id="select_type_data" class="form-select" style="border-radius: 8px;">
                  <option value="1" selected>"""),_display_(/*14.47*/Messages("subscriber.modal.export.dataType.info")),format.raw/*14.96*/("""</option>
                  <option value="2">"""),_display_(/*15.38*/Messages("subscriber.modal.export.dataType.usage")),format.raw/*15.88*/("""</option>
                </select>
              </div>
            </div>
            <div class="row mb-3">
              <span class="col-sm-4 col-form-label" style="text-align: right;">"""),_display_(/*20.81*/Messages("subscriber.modal.export.unit")),format.raw/*20.121*/("""</span>
              <div class="col-sm-8">
                <select id="select_type_unit" class="form-select" style="border-radius: 8px;">
                  <option value="GB">GB</option>
                  <option value="MB" selected>MB</option>
                  <option value="KB">KB</option>
                </select>
              </div>
            </div>
            <div class="row mb-3">
              <span class="col-sm-4 col-form-label" style="text-align: right;">"""),_display_(/*30.81*/Messages("subscriber.modal.export.recordsPerFile")),format.raw/*30.131*/("""</span>
              <div class="col-sm-8">
                <input class="form-control mb-2" type="text" style="border-radius: 8px;" id="countOnefileExport" value="5000" placeholder=""""),_display_(/*32.141*/Messages("subscriber.modal.export.placeholder.recordsPerFile")),format.raw/*32.203*/("""" onkeypress="return isNumberKey(event)">
                <small>"""),_display_(/*33.25*/Messages("subscriber.modal.export.recordsPerFile.note")),format.raw/*33.80*/("""</small>
              </div>
             
            </div>
            <div class="row mb-3" id="select_date" style="display: none;">
              <span class="col-sm-4 col-form-label" style="text-align: right;">"""),_display_(/*38.81*/Messages("subscriber.modal.export.time")),format.raw/*38.121*/("""</span>
              <div class="col-sm-8">
                <input class="form-control datetimepicker mb-2" type="text" id="fromDate" value="" placeholder=""""),_display_(/*40.114*/Messages("subscriber.modal.export.placeholder.fromDate")),format.raw/*40.170*/("""">
                <input class="form-control datetimepicker mb-2" type="text" id="toDate" value="" placeholder=""""),_display_(/*41.112*/Messages("subscriber.modal.export.placeholder.toDate")),format.raw/*41.166*/("""">
                <small>"""),_display_(/*42.25*/Messages("subscriber.modal.export.time.note")),format.raw/*42.70*/("""</small>
              </div>
            </div>
           
            <div class="row justify-content-center">
              <button type="button" class="btn btn-red" onclick="getListFileExport()">"""),_display_(/*47.88*/Messages("subscriber.modal.export.createFiles")),format.raw/*47.135*/("""</button>
            </div>
            <hr>
            <div class="text-end mb-2" id="addBtnDownloadAll">
            </div>
            <div class="row mb-1" id="tabListFileExport" style="padding: 0px 15px 15px 15px;">
              <table id="file_export" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <thead style="background-color: #FBCCD6;">
                  <tr>
                    <th>"""),_display_(/*56.26*/Messages("subscriber.modal.export.table.index")),format.raw/*56.73*/("""</th>
                    <th>"""),_display_(/*57.26*/Messages("subscriber.modal.export.table.file")),format.raw/*57.72*/("""</th>
                    <th>"""),_display_(/*58.26*/Messages("subscriber.modal.export.table.action")),format.raw/*58.74*/("""</th>
                  </tr>
                </thead>
                <tbody>
                <tr>
                  <td colspan="3" class="text-center">"""),_display_(/*63.56*/Messages("subscriber.modal.export.table.noData")),format.raw/*63.104*/("""</td>
                </tr>
                </tbody>
              </table>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*70.85*/Messages("btnClose")),format.raw/*70.105*/("""</button>
            </div>
          </div>
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
                  DATE: Mon Sep 22 16:32:55 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/subs/Subscriber_export.scala.html
                  HASH: 467eb4e1beea8c19fd9b0bdf7303ba5c1ed44989
                  MATRIX: 1053->0|1435->356|1496->397|1782->656|1848->700|2061->886|2131->935|2205->982|2276->1032|2494->1223|2556->1263|3060->1740|3132->1790|3345->1975|3429->2037|3522->2103|3598->2158|3843->2376|3905->2416|4091->2574|4169->2630|4311->2744|4387->2798|4441->2825|4507->2870|4735->3071|4804->3118|5272->3559|5340->3606|5398->3637|5465->3683|5523->3714|5592->3762|5774->3917|5844->3965|6090->4184|6132->4204
                  LINES: 33->1|37->5|37->5|43->11|43->11|46->14|46->14|47->15|47->15|52->20|52->20|62->30|62->30|64->32|64->32|65->33|65->33|70->38|70->38|72->40|72->40|73->41|73->41|74->42|74->42|79->47|79->47|88->56|88->56|89->57|89->57|90->58|90->58|95->63|95->63|102->70|102->70
                  -- GENERATED --
              */
          