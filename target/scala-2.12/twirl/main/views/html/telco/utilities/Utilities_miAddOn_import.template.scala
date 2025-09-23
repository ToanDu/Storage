
package views.html.telco.utilities

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
        <span class="modal-title" id="exampleModalLabel">"""),_display_(/*5.59*/Messages("utilities.importSubscriberList")),format.raw/*5.101*/("""</span>
         <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" style="position: absolute; right: 1rem; top: 1rem; filter: grayscale(100%) brightness(60%) contrast(100%);"></button>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12">
            <div class="row mb-3">
              <span class="col-sm-4 col-form-label">"""),_display_(/*12.54*/Messages("utilities.uploadSubscriberList")),format.raw/*12.96*/("""</span>
              <div class="col-sm-4">
                <input type="file" id="filesMiAddOnSubs" name="files" style="background-color: #aaa; width: 100%;" hidden/>
                <input type="text" class="form-control input-form" id="nameFileMiAddOnSubs" readonly/>
              </div>
              <label class="col-sm-4 col-form-label title-section-2" style="text-align: left; cursor: pointer; color: #EA0033;" onclick="importFileMiAddOnSubs()">
                <i class="bx bx-upload"></i> """),_display_(/*18.47*/Messages("utilities.importList")),format.raw/*18.79*/("""
              """),format.raw/*19.15*/("""</label>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*22.54*/Messages("utilities.downloadSampleFile")),format.raw/*22.94*/("""</span>
              <span class="col-sm-4 col-form-label align-items-center">"""),_display_(/*23.73*/Messages("List_Subs.xlsx")),format.raw/*23.99*/("""</span>
              <div class="col-sm-4 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="downloadTemplateBlockSubs()"><i class="bx bx-download"></i> """),_display_(/*25.131*/Messages("Download")),format.raw/*25.151*/("""</a>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*29.54*/Messages("utilities.validSubscribers")),format.raw/*29.92*/("""</span>
              <span class="col-sm-4 col-form-label align-items-center" id="countMiAddonSubsTrue">"""),_display_(/*30.99*/Messages("0")),format.raw/*30.112*/("""</span>
              <div class="col-sm-4 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="exportListSubsMiAddonTrue()"><i class="bx bx-download"></i> """),_display_(/*32.131*/Messages("Download")),format.raw/*32.151*/("""</a>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*36.54*/Messages("utilities.invalidSubscribers")),format.raw/*36.94*/("""</span>
              <span class="col-sm-4 col-form-label align-items-center" id="countMiAddonSubsFalse">"""),_display_(/*37.100*/Messages("0")),format.raw/*37.113*/("""</span>
              <div class="col-sm-4 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="exportListSubsMiAddonFalse()"><i class="bx bx-download"></i> """),_display_(/*39.132*/Messages("Download")),format.raw/*39.152*/("""</a>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-cancle" onclick="cancleImportFileMiAddon()">"""),_display_(/*44.97*/Messages("btnCancle")),format.raw/*44.118*/("""</button>
              <button type="button" class="btn btn-red" id="checkChangeInformation" disabled onclick="comfirmTableListSubsMiAddon()" data-bs-dismiss="modal">"""),_display_(/*45.159*/Messages("btnComfirm")),format.raw/*45.181*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/utilities/Utilities_miAddOn_import.scala.html
                  HASH: 04f60d8d5e5daa702d51446bac70d7678ad215a8
                  MATRIX: 1065->0|1459->368|1522->410|1959->820|2022->862|2551->1364|2604->1396|2647->1411|2790->1527|2851->1567|2958->1647|3005->1673|3223->1863|3265->1883|3425->2016|3484->2054|3617->2160|3652->2173|3870->2363|3912->2383|4072->2516|4133->2556|4268->2663|4303->2676|4522->2867|4564->2887|4772->3068|4815->3089|5011->3257|5055->3279
                  LINES: 33->1|37->5|37->5|44->12|44->12|50->18|50->18|51->19|54->22|54->22|55->23|55->23|57->25|57->25|61->29|61->29|62->30|62->30|64->32|64->32|68->36|68->36|69->37|69->37|71->39|71->39|76->44|76->44|77->45|77->45
                  -- GENERATED --
              */
          