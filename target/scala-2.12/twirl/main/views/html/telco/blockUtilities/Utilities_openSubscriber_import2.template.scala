
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

object Utilities_openSubscriber_import2 extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="importOpenSubsModal2" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <span class="modal-title" id="exampleModalLabel">"""),_display_(/*5.59*/Messages("blockUtilities.importUnblockTwoWayList")),format.raw/*5.109*/("""</span>
        <a class="close cursor-pointer" data-bs-dismiss="modal" aria-hidden="true" style="float: right; font-size: 20px;">×</a>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12">
            <div class="row mb-3">
              <span class="col-sm-4 col-form-label">"""),_display_(/*12.54*/Messages("blockUtilities.loadSubscriberList")),format.raw/*12.99*/("""</span>
              <div class="col-sm-4">
                <input type="file" id="filesOpenSubs2" name="files" style="background-color: #aaa; width: 100%;" hidden/>
                <input type="text" class="form-control input-form" id="nameFileOpenSubs2" readonly/>
              </div>
              <label class="col-sm-4 col-form-label title-section-2" style="text-align: left; cursor: pointer; color: #EA0033;" onclick="importFileOpenSubs2()">
                <i class="bx bx-upload"></i> """),_display_(/*18.47*/Messages("blockUtilities.importSubscriberList")),format.raw/*18.94*/("""
              """),format.raw/*19.15*/("""</label>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*22.54*/Messages("blockUtilities.downloadTemplateFile")),format.raw/*22.101*/("""</span>
              <span class="col-sm-4 col-form-label align-items-center">"""),_display_(/*23.73*/Messages("blockUtilities.templateFileName")),format.raw/*23.116*/("""</span>
              <div class="col-sm-4 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="downloadTemplateBlockSubs()"><i class="bx bx-download"></i> """),_display_(/*25.131*/Messages("Download")),format.raw/*25.151*/("""</a>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*29.54*/Messages("blockUtilities.validSubscribers")),format.raw/*29.97*/("""</span>
              <span class="col-sm-4 col-form-label align-items-center" id="countOpenSubs2True">"""),_display_(/*30.97*/Messages("0")),format.raw/*30.110*/("""</span>
              <div class="col-sm-4 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="exportListSubsOpen2True()"><i class="bx bx-download"></i> """),_display_(/*32.129*/Messages("Download")),format.raw/*32.149*/("""</a>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*36.54*/Messages("blockUtilities.invalidSubscribers")),format.raw/*36.99*/("""</span>
              <span class="col-sm-4 col-form-label align-items-center" id="countOpenSubs2False">"""),_display_(/*37.98*/Messages("0")),format.raw/*37.111*/("""</span>
              <div class="col-sm-4 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="exportListSubsOpen2False()"><i class="bx bx-download"></i> """),_display_(/*39.130*/Messages("Download")),format.raw/*39.150*/("""</a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" onclick="cancleImportFileOpen2()">"""),_display_(/*46.89*/Messages("btnCancle")),format.raw/*46.110*/("""</button>
        <button type="button" class="btn btn-red" onclick="comfirmTableListSubsOpen2()" data-bs-dismiss="modal">"""),_display_(/*47.114*/Messages("btnComfirm")),format.raw/*47.136*/("""</button>
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
                  DATE: Mon Sep 22 16:32:51 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/blockUtilities/Utilities_openSubscriber_import2.scala.html
                  HASH: bb07bc41917e2f41d1ecfad5c47f09ce11cc6195
                  MATRIX: 1078->0|1467->363|1538->413|1893->741|1959->786|2482->1282|2550->1329|2593->1344|2736->1460|2805->1507|2912->1587|2977->1630|3195->1820|3237->1840|3397->1973|3461->2016|3592->2120|3627->2133|3843->2321|3885->2341|4045->2474|4111->2519|4243->2624|4278->2637|4495->2826|4537->2846|4775->3057|4818->3078|4969->3201|5013->3223
                  LINES: 33->1|37->5|37->5|44->12|44->12|50->18|50->18|51->19|54->22|54->22|55->23|55->23|57->25|57->25|61->29|61->29|62->30|62->30|64->32|64->32|68->36|68->36|69->37|69->37|71->39|71->39|78->46|78->46|79->47|79->47
                  -- GENERATED --
              */
          