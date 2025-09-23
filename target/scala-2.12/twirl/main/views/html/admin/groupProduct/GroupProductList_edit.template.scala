
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

object GroupProductList_edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editConfirmModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-white" id="exampleModalLabel" >"""),_display_(/*5.69*/Messages("Sửa nhóm sản phẩm")),format.raw/*5.98*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row g-3">
          <div class="col-md-12">
            <input id="idGroupProductEdit" type="text" class="form-control" autocomplete="off" readonly hidden>
            <div class="row mb-1">
              <label class="col-sm-3 col-form-label">"""),_display_(/*12.55*/Messages("Mã nhóm ")),format.raw/*12.75*/("""</label>
              <div class="col-sm-9">
                <input id="codeGroupProductEdit" type="text" class="form-control" autocomplete="off" required>
              </div>
            </div>

            <div class="row mb-1">
              <label class="col-sm-3 col-form-label">"""),_display_(/*19.55*/Messages("Tên nhóm")),format.raw/*19.75*/("""</label>
              <div class="col-sm-9">
                <input id="nameGroupProductEdit" type="text" class="form-control" autocomplete="off" required>
              </div>
            </div>

            <div class="row mb-1">
              <label class="col-sm-3 col-form-label">"""),_display_(/*26.55*/Messages("Phân loại ")),format.raw/*26.77*/("""</label>
              <div class="col-sm-9">
                <select id="typeGroupProductEdit" class="form-select">
                  <option value="0">"""),_display_(/*29.38*/Messages("Thiết bị")),format.raw/*29.58*/("""</option>
                  <option value="1">"""),_display_(/*30.38*/Messages("Giải pháp")),format.raw/*30.59*/("""</option>
                </select>
              </div>
            </div>

            <div class="row mb-1">
              <label class="col-sm-3 col-form-label">"""),_display_(/*36.55*/Messages("Trạng thái")),format.raw/*36.77*/("""</label>
              <div class="col-sm-9">
                <select id="statusGroupProductEdit" class="form-select">
                  <option value="true">"""),_display_(/*39.41*/Messages("Hiện")),format.raw/*39.57*/("""</option>
                  <option value="false">"""),_display_(/*40.42*/Messages("Ẩn")),format.raw/*40.56*/("""</option>
                </select>
              </div>
            </div>

          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*49.77*/Messages("btnClose")),format.raw/*49.97*/("""</button>
        <button type="button" class="btn btn-success" data-bs-dismiss="modal" onclick="processEditGroupProduct()">"""),_display_(/*50.116*/Messages("btnComfirm")),format.raw/*50.138*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/admin/groupProduct/GroupProductList_edit.scala.html
                  HASH: 01eb08420210bb322f2c6a371a35f075c45e1f1d
                  MATRIX: 1065->0|1382->291|1431->320|1773->635|1814->655|2128->942|2169->962|2483->1249|2526->1271|2707->1425|2748->1445|2822->1492|2864->1513|3057->1679|3100->1701|3286->1860|3323->1876|3401->1927|3436->1941|3694->2172|3735->2192|3888->2317|3932->2339
                  LINES: 33->1|37->5|37->5|44->12|44->12|51->19|51->19|58->26|58->26|61->29|61->29|62->30|62->30|68->36|68->36|71->39|71->39|72->40|72->40|81->49|81->49|82->50|82->50
                  -- GENERATED --
              */
          