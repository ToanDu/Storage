
package views.html.admin.groupProduct

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

object GroupProductList_add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addConfirmModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-white" id="exampleModalLabel" >"""),_display_(/*5.69*/Messages("Thêm nhóm sản phẩm")),format.raw/*5.99*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row g-3">
          <div class="col-md-12">

            <div class="row mb-1">
              <label class="col-sm-3 col-form-label">"""),_display_(/*12.55*/Messages("Mã nhóm ")),format.raw/*12.75*/("""</label>
              <div class="col-sm-9">
                <input id="codeGroupProductAdd" type="text" class="form-control" autocomplete="off" required>
              </div>
            </div>

            <div class="row mb-1">
              <label class="col-sm-3 col-form-label">"""),_display_(/*19.55*/Messages("Tên nhóm")),format.raw/*19.75*/("""</label>
              <div class="col-sm-9">
                <input id="nameGroupProductAdd" type="text" class="form-control" autocomplete="off" required>
              </div>
            </div>

            <div class="row mb-1">
              <label class="col-sm-3 col-form-label">"""),_display_(/*26.55*/Messages("Phân loại ")),format.raw/*26.77*/("""</label>
              <div class="col-sm-9">
                <select id="typeGroupProductAdd" class="form-select">
                  <option value="0" selected>"""),_display_(/*29.47*/Messages("Thiết bị")),format.raw/*29.67*/("""</option>
                  <option value="1">"""),_display_(/*30.38*/Messages("Giải pháp")),format.raw/*30.59*/("""</option>
                </select>
              </div>
            </div>

            <div class="row mb-1">
              <label class="col-sm-3 col-form-label">"""),_display_(/*36.55*/Messages("Trạng thái")),format.raw/*36.77*/("""</label>
              <div class="col-sm-9">
                <select id="statusGroupProductAdd" class="form-select">
                  <option value="true" selected>"""),_display_(/*39.50*/Messages("Hiện")),format.raw/*39.66*/("""</option>
                  <option value="false">"""),_display_(/*40.42*/Messages("Ẩn")),format.raw/*40.56*/("""</option>
                </select>
              </div>
            </div>

          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*49.77*/Messages("btnClose")),format.raw/*49.97*/("""</button>
        <button type="button" class="btn btn-success" data-bs-dismiss="modal" onclick="processAddGroupProduct()">"""),_display_(/*50.115*/Messages("btnComfirm")),format.raw/*50.137*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/admin/groupProduct/GroupProductList_add.scala.html
                  HASH: f9ba2fdef7bbf639e1c36767e214fee17c497102
                  MATRIX: 1064->0|1380->290|1430->320|1661->524|1702->544|2015->830|2056->850|2369->1136|2412->1158|2601->1320|2642->1340|2716->1387|2758->1408|2951->1574|2994->1596|3188->1763|3225->1779|3303->1830|3338->1844|3596->2075|3637->2095|3789->2219|3833->2241
                  LINES: 33->1|37->5|37->5|44->12|44->12|51->19|51->19|58->26|58->26|61->29|61->29|62->30|62->30|68->36|68->36|71->39|71->39|72->40|72->40|81->49|81->49|82->50|82->50
                  -- GENERATED --
              */
          