
package views.html.admin.contact

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

object MarketPlaceContact_status extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editConfirmModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-white" id="exampleModalLabel" >"""),_display_(/*5.69*/Messages("Xác nhận xử lý")),format.raw/*5.95*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row g-3">
          <div class="col-md-12">
            <input id="idContactEdit" type="text" class="form-control" autocomplete="off" readonly hidden>
            <div class="row mb-1">
              <label class="col-sm-3 col-form-label">"""),_display_(/*12.55*/Messages("Trạng thái")),format.raw/*12.77*/("""</label>
              <div class="col-sm-9">
                <select id="statusContactEdit" class="form-select">
                  <option value="true">"""),_display_(/*15.41*/Messages("Đã xử lý")),format.raw/*15.61*/("""</option>
                  <option value="false">"""),_display_(/*16.42*/Messages("Chưa xử lý")),format.raw/*16.64*/("""</option>
                </select>
              </div>
            </div>

          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*25.77*/Messages("btnClose")),format.raw/*25.97*/("""</button>
        <button type="button" class="btn btn-success" data-bs-dismiss="modal" onclick="processEditContact()">"""),_display_(/*26.111*/Messages("btnComfirm")),format.raw/*26.133*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/admin/contact/MarketPlaceContact_status.scala.html
                  HASH: 640b6fe2e57f73edf6f23a882f1c522d6fbcd257
                  MATRIX: 1064->0|1381->291|1427->317|1764->627|1807->649|1988->803|2029->823|2107->874|2150->896|2408->1127|2449->1147|2597->1267|2641->1289
                  LINES: 33->1|37->5|37->5|44->12|44->12|47->15|47->15|48->16|48->16|57->25|57->25|58->26|58->26
                  -- GENERATED --
              */
          