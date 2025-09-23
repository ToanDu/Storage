
package views.html.telco.topUp

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

object Utilities_blockSubs_import extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="importBlockSubsModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <span class="modal-title" id="exampleModalLabel">"""),_display_(/*5.59*/Messages("Import danh sách thuê bao chặn chiều")),format.raw/*5.107*/("""</span>
        <a class="close cursor-pointer" data-bs-dismiss="modal" aria-hidden="true" style="float: right; font-size: 20px;">×</a>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12">
            <div class="row mb-3">
              <span class="col-sm-4 col-form-label">"""),_display_(/*12.54*/Messages("Tải danh sách TB")),format.raw/*12.82*/("""</span>
              <div class="col-sm-4">
                <input type="file" id="filesBlockSubs" name="files" style="background-color: #aaa; width: 100%;" hidden/>
                <input type="text" class="form-control input-form" id="nameFileBlockSubs" readonly/>
              </div>
              <label class="col-sm-4 col-form-label title-section-2" style="text-align: left; cursor: pointer; color: #EA0033;" onclick="importFileBlockSubs()">
                <i class="bx bx-upload"></i> """),_display_(/*18.47*/Messages("Import danh sách")),format.raw/*18.75*/("""
              """),format.raw/*19.15*/("""</label>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*22.54*/Messages("Tải file mẫu")),format.raw/*22.78*/("""</span>
              <span class="col-sm-4 col-form-label align-items-center">"""),_display_(/*23.73*/Messages("List_Subs.xlsx")),format.raw/*23.99*/("""</span>
              <div class="col-sm-4 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="downloadTemplateBlockSubs()"><i class="bx bx-download"></i> """),_display_(/*25.131*/Messages("Download")),format.raw/*25.151*/("""</a>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*29.54*/Messages("Số TB hợp lệ")),format.raw/*29.78*/("""</span>
              <span class="col-sm-4 col-form-label align-items-center" id="countBlockSubsTrue">"""),_display_(/*30.97*/Messages("0")),format.raw/*30.110*/("""</span>
              <div class="col-sm-4 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="exportListSubsBlockTrue()"><i class="bx bx-download"></i> """),_display_(/*32.129*/Messages("Download")),format.raw/*32.149*/("""</a>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*36.54*/Messages("Số TB không hợp lệ")),format.raw/*36.84*/("""</span>
              <span class="col-sm-4 col-form-label align-items-center" id="countBlockSubsFalse">"""),_display_(/*37.98*/Messages("0")),format.raw/*37.111*/("""</span>
              <div class="col-sm-4 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="exportListSubsBlockFalse()"><i class="bx bx-download"></i> """),_display_(/*39.130*/Messages("Download")),format.raw/*39.150*/("""</a>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-cancle" onclick="cancleImportFileBlock()">"""),_display_(/*44.95*/Messages("btnCancle")),format.raw/*44.116*/("""</button>
              <button type="button" class="btn btn-red" onclick="comfirmTableListSubsBlock()" data-bs-dismiss="modal">"""),_display_(/*45.120*/Messages("btnComfirm")),format.raw/*45.142*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/topUp/Utilities_blockSubs_import.scala.html
                  HASH: 490b7ef4d3d7a1293ffabc8bf57049374dc0ad2f
                  MATRIX: 1063->0|1452->363|1521->411|1876->739|1925->767|2448->1263|2497->1291|2540->1306|2683->1422|2728->1446|2835->1526|2882->1552|3100->1742|3142->1762|3302->1895|3347->1919|3478->2023|3513->2036|3729->2224|3771->2244|3931->2377|3982->2407|4114->2512|4149->2525|4366->2714|4408->2734|4614->2913|4657->2934|4814->3063|4858->3085
                  LINES: 33->1|37->5|37->5|44->12|44->12|50->18|50->18|51->19|54->22|54->22|55->23|55->23|57->25|57->25|61->29|61->29|62->30|62->30|64->32|64->32|68->36|68->36|69->37|69->37|71->39|71->39|76->44|76->44|77->45|77->45
                  -- GENERATED --
              */
          