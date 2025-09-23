
package views.html.telco.buyPackage

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

object Utilities_openSubscriber_import2 extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="importOpenSubsModal2" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <span class="modal-title" id="exampleModalLabel">"""),_display_(/*5.59*/Messages("Import danh sách thuê bao mở 2 chiều")),format.raw/*5.107*/("""</span>
        <a class="close cursor-pointer" data-bs-dismiss="modal" aria-hidden="true" style="float: right; font-size: 20px;">×</a>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12">
            <div class="row mb-3">
              <span class="col-sm-4 col-form-label">"""),_display_(/*12.54*/Messages("Tải danh sách TB")),format.raw/*12.82*/("""</span>
              <div class="col-sm-4">
                <input type="file" id="filesOpenSubs2" name="files" style="background-color: #aaa; width: 100%;" hidden/>
                <input type="text" class="form-control input-form" id="nameFileOpenSubs2" readonly/>
              </div>
              <label class="col-sm-4 col-form-label title-section-2" style="text-align: left; cursor: pointer; color: #EA0033;" onclick="importFileOpenSubs2()">
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
              <span class="col-sm-4 col-form-label align-items-center" id="countOpenSubsTrue2">"""),_display_(/*30.97*/Messages("0")),format.raw/*30.110*/("""</span>
              <div class="col-sm-4 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="exportListSubsOpenTrue2()"><i class="bx bx-download"></i> """),_display_(/*32.129*/Messages("Download")),format.raw/*32.149*/("""</a>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*36.54*/Messages("Số TB không hợp lệ")),format.raw/*36.84*/("""</span>
              <span class="col-sm-4 col-form-label align-items-center" id="countOpenSubsFalse2">"""),_display_(/*37.98*/Messages("0")),format.raw/*37.111*/("""</span>
              <div class="col-sm-4 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="exportListSubsOpenFalse2()"><i class="bx bx-download"></i> """),_display_(/*39.130*/Messages("Download")),format.raw/*39.150*/("""</a>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-cancle" onclick="cancleImportFileOpen2()">"""),_display_(/*44.95*/Messages("btnCancle")),format.raw/*44.116*/("""</button>
              <button type="button" class="btn btn-red" onclick="comfirmTableListSubsOpen2()" data-bs-dismiss="modal">"""),_display_(/*45.120*/Messages("btnComfirm")),format.raw/*45.142*/("""</button>
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
                  DATE: Mon Sep 22 16:32:51 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/buyPackage/Utilities_openSubscriber_import2.scala.html
                  HASH: 0d224c51055a30595b369a3d015b2b9ad5f478de
                  MATRIX: 1074->0|1463->363|1532->411|1887->739|1936->767|2459->1263|2508->1291|2551->1306|2694->1422|2739->1446|2846->1526|2893->1552|3111->1742|3153->1762|3313->1895|3358->1919|3489->2023|3524->2036|3740->2224|3782->2244|3942->2377|3993->2407|4125->2512|4160->2525|4377->2714|4419->2734|4625->2913|4668->2934|4825->3063|4869->3085
                  LINES: 33->1|37->5|37->5|44->12|44->12|50->18|50->18|51->19|54->22|54->22|55->23|55->23|57->25|57->25|61->29|61->29|62->30|62->30|64->32|64->32|68->36|68->36|69->37|69->37|71->39|71->39|76->44|76->44|77->45|77->45
                  -- GENERATED --
              */
          