
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

object Utilities_openSubscriber_import extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="importOpenSubsModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <span class="modal-title" id="exampleModalLabel">"""),_display_(/*5.59*/Messages("Import danh sách thuê bao mở 1 chiều")),format.raw/*5.107*/("""</span>
        <a class="close cursor-pointer" data-bs-dismiss="modal" aria-hidden="true" style="float: right; font-size: 20px;">×</a>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12">
            <div class="row mb-3">
              <span class="col-sm-4 col-form-label">"""),_display_(/*12.54*/Messages("Tải danh sách TB")),format.raw/*12.82*/("""</span>
              <div class="col-sm-4">
                <input type="file" id="filesOpenSubs" name="files" style="background-color: #aaa; width: 100%;" hidden/>
                <input type="text" class="form-control input-form" id="nameFileOpenSubs" readonly/>
              </div>
              <label class="col-sm-4 col-form-label title-section-2" style="text-align: left; cursor: pointer; color: #EA0033;" onclick="importFileOpenSubs()">
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
              <span class="col-sm-4 col-form-label align-items-center" id="countOpenSubsTrue">"""),_display_(/*30.96*/Messages("0")),format.raw/*30.109*/("""</span>
              <div class="col-sm-4 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="exportListSubsOpenTrue()"><i class="bx bx-download"></i> """),_display_(/*32.128*/Messages("Download")),format.raw/*32.148*/("""</a>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*36.54*/Messages("Số TB không hợp lệ")),format.raw/*36.84*/("""</span>
              <span class="col-sm-4 col-form-label align-items-center" id="countOpenSubsFalse">"""),_display_(/*37.97*/Messages("0")),format.raw/*37.110*/("""</span>
              <div class="col-sm-4 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="exportListSubsOpenFalse()"><i class="bx bx-download"></i> """),_display_(/*39.129*/Messages("Download")),format.raw/*39.149*/("""</a>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-cancle" onclick="cancleImportFileOpen()">"""),_display_(/*44.94*/Messages("btnCancle")),format.raw/*44.115*/("""</button>
              <button type="button" class="btn btn-red" onclick="comfirmTableListSubsOpen()" data-bs-dismiss="modal">"""),_display_(/*45.119*/Messages("btnComfirm")),format.raw/*45.141*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/buyPackage/Utilities_openSubscriber_import.scala.html
                  HASH: 994f4364318f6a9eb153a49f12e7050e072052f5
                  MATRIX: 1073->0|1461->362|1530->410|1885->738|1934->766|2454->1259|2503->1287|2546->1302|2689->1418|2734->1442|2841->1522|2888->1548|3106->1738|3148->1758|3308->1891|3353->1915|3483->2018|3518->2031|3733->2218|3775->2238|3935->2371|3986->2401|4117->2505|4152->2518|4368->2706|4410->2726|4615->2904|4658->2925|4814->3053|4858->3075
                  LINES: 33->1|37->5|37->5|44->12|44->12|50->18|50->18|51->19|54->22|54->22|55->23|55->23|57->25|57->25|61->29|61->29|62->30|62->30|64->32|64->32|68->36|68->36|69->37|69->37|71->39|71->39|76->44|76->44|77->45|77->45
                  -- GENERATED --
              */
          