
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

object Utilities_openSubscriber_import extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="importOpenSubsModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <span class="modal-title" id="exampleModalLabel">"""),_display_(/*5.59*/Messages("blockUtilities.importUnblockOneWayList")),format.raw/*5.109*/("""</span>
        <a class="close cursor-pointer" data-bs-dismiss="modal" aria-hidden="true" style="float: right; font-size: 20px;">×</a>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12">
            <div class="row mb-3">
              <span class="col-sm-4 col-form-label">"""),_display_(/*12.54*/Messages("blockUtilities.loadSubscriberList")),format.raw/*12.99*/("""</span>
              <div class="col-sm-4">
                <input type="file" id="filesOpenSubs" name="files" style="background-color: #aaa; width: 100%;" hidden/>
                <input type="text" class="form-control input-form" id="nameFileOpenSubs" readonly/>
              </div>
              <label class="col-sm-4 col-form-label title-section-2" style="text-align: left; cursor: pointer; color: #EA0033;" onclick="importFileOpenSubs()">
                <i class="bx bx-upload"></i> """),_display_(/*18.47*/Messages("blockUtilities.importSubscriberList")),format.raw/*18.94*/("""
              """),format.raw/*19.15*/("""</label>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*22.54*/Messages("blockUtilities.downloadTemplateFile")),format.raw/*22.101*/("""</span>
              <span class="col-sm-4 col-form-label align-items-center">"""),_display_(/*23.73*/Messages("blockUtilities.templateFileName")),format.raw/*23.116*/("""</span>
              <div class="col-sm-4 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="downloadTemplateBlockSubs()"><i class="bx bx-download"></i> """),_display_(/*25.131*/Messages("common.download")),format.raw/*25.158*/("""</a>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*29.54*/Messages("blockUtilities.validSubscribers")),format.raw/*29.97*/("""</span>
              <span class="col-sm-4 col-form-label align-items-center" id="countOpenSubsTrue">"""),_display_(/*30.96*/Messages("0")),format.raw/*30.109*/("""</span>
              <div class="col-sm-4 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="exportListSubsOpenTrue()"><i class="bx bx-download"></i> """),_display_(/*32.128*/Messages("common.download")),format.raw/*32.155*/("""</a>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*36.54*/Messages("blockUtilities.invalidSubscribers")),format.raw/*36.99*/("""</span>
              <span class="col-sm-4 col-form-label align-items-center" id="countOpenSubsFalse">"""),_display_(/*37.97*/Messages("0")),format.raw/*37.110*/("""</span>
              <div class="col-sm-4 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="exportListSubsOpenFalse()"><i class="bx bx-download"></i> """),_display_(/*39.129*/Messages("common.download")),format.raw/*39.156*/("""</a>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-cancle" onclick="cancleImportFileOpen()">"""),_display_(/*44.94*/Messages("common.cancel")),format.raw/*44.119*/("""</button>
              <button type="button" class="btn btn-red" onclick="comfirmTableListSubsOpen()" data-bs-dismiss="modal">"""),_display_(/*45.119*/Messages("common.confirm")),format.raw/*45.145*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/utilities/Utilities_openSubscriber_import.scala.html
                  HASH: fd8208caec8ca06d6bef5bca6155766964aeeeca
                  MATRIX: 1072->0|1460->362|1531->412|1886->740|1952->785|2472->1278|2540->1325|2583->1340|2726->1456|2795->1503|2902->1583|2967->1626|3185->1816|3234->1843|3394->1976|3458->2019|3588->2122|3623->2135|3838->2322|3887->2349|4047->2482|4113->2527|4244->2631|4279->2644|4495->2832|4544->2859|4749->3037|4796->3062|4952->3190|5000->3216
                  LINES: 33->1|37->5|37->5|44->12|44->12|50->18|50->18|51->19|54->22|54->22|55->23|55->23|57->25|57->25|61->29|61->29|62->30|62->30|64->32|64->32|68->36|68->36|69->37|69->37|71->39|71->39|76->44|76->44|77->45|77->45
                  -- GENERATED --
              */
          