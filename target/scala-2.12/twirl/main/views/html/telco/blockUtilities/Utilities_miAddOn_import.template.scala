
package views.html.telco.blockUtilities

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

object Utilities_miAddOn_import extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="importListSubMiAddonModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <span class="modal-title" id="exampleModalLabel">"""),_display_(/*5.59*/Messages("Import danh sách thuê bao")),format.raw/*5.96*/("""</span>
        <a class="close cursor-pointer" data-bs-dismiss="modal" aria-hidden="true" style="float: right; font-size: 20px;">×</a>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12">
            <div class="row mb-3">
              <span class="col-sm-4 col-form-label">"""),_display_(/*12.54*/Messages("Tải danh sách TB")),format.raw/*12.82*/("""</span>
              <div class="col-sm-4">
                <input type="file" id="filesMiAddOnSubs" name="files" style="background-color: #aaa; width: 100%;" hidden/>
                <input type="text" class="form-control input-form" id="nameFileMiAddOnSubs" readonly/>
              </div>
              <label class="col-sm-4 col-form-label title-section-2" style="text-align: left; cursor: pointer; color: #EA0033;" onclick="importFileMiAddOnSubs()">
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
              <span class="col-sm-4 col-form-label align-items-center" id="countMiAddonSubsTrue">"""),_display_(/*30.99*/Messages("0")),format.raw/*30.112*/("""</span>
              <div class="col-sm-4 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="exportListSubsMiAddonTrue()"><i class="bx bx-download"></i> """),_display_(/*32.131*/Messages("Download")),format.raw/*32.151*/("""</a>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*36.54*/Messages("Số TB không hợp lệ")),format.raw/*36.84*/("""</span>
              <span class="col-sm-4 col-form-label align-items-center" id="countMiAddonSubsFalse">"""),_display_(/*37.100*/Messages("0")),format.raw/*37.113*/("""</span>
              <div class="col-sm-4 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="exportListSubsMiAddonFalse()"><i class="bx bx-download"></i> """),_display_(/*39.132*/Messages("Download")),format.raw/*39.152*/("""</a>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-cancle" onclick="cancleImportFileMiAddon()">"""),_display_(/*44.97*/Messages("btnCancle")),format.raw/*44.118*/("""</button>
              <button type="button" class="btn btn-red" onclick="comfirmTableListSubsMiAddon()" data-bs-dismiss="modal">"""),_display_(/*45.122*/Messages("btnComfirm")),format.raw/*45.144*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/blockUtilities/Utilities_miAddOn_import.scala.html
                  HASH: a189f61323e29dc4ddff837a26b9257ddd5b4267
                  MATRIX: 1070->0|1464->368|1521->405|1876->733|1925->761|2454->1263|2503->1291|2546->1306|2689->1422|2734->1446|2841->1526|2888->1552|3106->1742|3148->1762|3308->1895|3353->1919|3486->2025|3521->2038|3739->2228|3781->2248|3941->2381|3992->2411|4127->2518|4162->2531|4381->2722|4423->2742|4631->2923|4674->2944|4833->3075|4877->3097
                  LINES: 33->1|37->5|37->5|44->12|44->12|50->18|50->18|51->19|54->22|54->22|55->23|55->23|57->25|57->25|61->29|61->29|62->30|62->30|64->32|64->32|68->36|68->36|69->37|69->37|71->39|71->39|76->44|76->44|77->45|77->45
                  -- GENERATED --
              */
          