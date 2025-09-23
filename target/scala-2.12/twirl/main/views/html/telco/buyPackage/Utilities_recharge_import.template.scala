
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

object Utilities_recharge_import extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="importRechargeSubsModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <span class="modal-title" id="exampleModalLabel">"""),_display_(/*5.59*/Messages("Import danh sách thuê bao nạp tiền")),format.raw/*5.105*/("""</span>
        <a class="close cursor-pointer" data-bs-dismiss="modal" aria-hidden="true" style="float: right; font-size: 20px;">×</a>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12">
            <div class="row mb-3">
              <span class="col-sm-4 col-form-label">"""),_display_(/*12.54*/Messages("Tải danh sách TB")),format.raw/*12.82*/("""</span>
              <div class="col-sm-4">
                <input type="file" id="filesRechargeSubs" name="files" style="background-color: #aaa; width: 100%;" hidden/>
                <input type="text" class="form-control input-form" id="nameFileRechargeSubs" readonly/>
              </div>
              <label class="col-sm-4 col-form-label title-section-2" style="text-align: left; cursor: pointer; color: #EA0033;" onclick="importFileRechargeSubs()">
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
              <span class="col-sm-4 col-form-label align-items-center" id="countRechargeSubsTrue">"""),_display_(/*30.100*/Messages("0")),format.raw/*30.113*/("""</span>
              <div class="col-sm-4 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="exportListSubsRechargeTrue()"><i class="bx bx-download"></i> """),_display_(/*32.132*/Messages("Download")),format.raw/*32.152*/("""</a>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*36.54*/Messages("Số TB không hợp lệ")),format.raw/*36.84*/("""</span>
              <span class="col-sm-4 col-form-label align-items-center" id="countRechargeSubsFalse">"""),_display_(/*37.101*/Messages("0")),format.raw/*37.114*/("""</span>
              <div class="col-sm-4 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="exportListSubsRechargeFalse()"><i class="bx bx-download"></i> """),_display_(/*39.133*/Messages("Download")),format.raw/*39.153*/("""</a>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-cancle" data-bs-dismiss="modal" onclick="cancleImportFileSubsRecharge()">"""),_display_(/*44.126*/Messages("btnClose")),format.raw/*44.146*/("""</button>
              <button type="button" class="btn btn-red" onclick="comfirmTableListSubsRecharge()" data-bs-dismiss="modal">"""),_display_(/*45.123*/Messages("btnComfirm")),format.raw/*45.145*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/buyPackage/Utilities_recharge_import.scala.html
                  HASH: fa0fc8b4bc53f2c0a8464ebedb36286e8525f274
                  MATRIX: 1067->0|1459->366|1526->412|1881->740|1930->768|2462->1273|2511->1301|2554->1316|2697->1432|2742->1456|2849->1536|2896->1562|3114->1752|3156->1772|3316->1905|3361->1929|3496->2036|3531->2049|3750->2240|3792->2260|3952->2393|4003->2423|4139->2531|4174->2544|4394->2736|4436->2756|4674->2966|4716->2986|4876->3118|4920->3140
                  LINES: 33->1|37->5|37->5|44->12|44->12|50->18|50->18|51->19|54->22|54->22|55->23|55->23|57->25|57->25|61->29|61->29|62->30|62->30|64->32|64->32|68->36|68->36|69->37|69->37|71->39|71->39|76->44|76->44|77->45|77->45
                  -- GENERATED --
              */
          