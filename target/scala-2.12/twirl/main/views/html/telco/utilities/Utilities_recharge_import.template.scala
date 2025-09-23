
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

object Utilities_recharge_import extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="importRechargeSubsModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <span class="modal-title" id="exampleModalLabel">"""),_display_(/*5.59*/Messages("utilities.importRechargeList")),format.raw/*5.99*/("""</span>
        <a class="close cursor-pointer" data-bs-dismiss="modal" aria-hidden="true" style="float: right; font-size: 20px;">×</a>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12">
            <div class="row mb-3">
              <span class="col-sm-4 col-form-label">"""),_display_(/*12.54*/Messages("utilities.loadSubscriberList")),format.raw/*12.94*/("""</span>
              <div class="col-sm-4">
                <input type="file" id="filesRechargeSubs" name="files" style="background-color: #aaa; width: 100%;" hidden/>
                <input type="text" class="form-control input-form" id="nameFileRechargeSubs" readonly/>
              </div>
              <label class="col-sm-4 col-form-label title-section-2" style="text-align: left; cursor: pointer; color: #EA0033;" onclick="importFileRechargeSubs()">
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
              <span class="col-sm-4 col-form-label align-items-center" id="countRechargeSubsTrue">"""),_display_(/*30.100*/Messages("0")),format.raw/*30.113*/("""</span>
              <div class="col-sm-4 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="exportListSubsRechargeTrue()"><i class="bx bx-download"></i> """),_display_(/*32.132*/Messages("Download")),format.raw/*32.152*/("""</a>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*36.54*/Messages("utilities.invalidSubscribers")),format.raw/*36.94*/("""</span>
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
                  DATE: Mon Sep 22 16:32:55 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/utilities/Utilities_recharge_import.scala.html
                  HASH: 7eab6690f15fd095fb0180caee15989ffc1233a2
                  MATRIX: 1066->0|1458->366|1518->406|1873->734|1934->774|2466->1279|2519->1311|2562->1326|2705->1442|2766->1482|2873->1562|2920->1588|3138->1778|3180->1798|3340->1931|3399->1969|3534->2076|3569->2089|3788->2280|3830->2300|3990->2433|4051->2473|4187->2581|4222->2594|4442->2786|4484->2806|4722->3016|4764->3036|4924->3168|4968->3190
                  LINES: 33->1|37->5|37->5|44->12|44->12|50->18|50->18|51->19|54->22|54->22|55->23|55->23|57->25|57->25|61->29|61->29|62->30|62->30|64->32|64->32|68->36|68->36|69->37|69->37|71->39|71->39|76->44|76->44|77->45|77->45
                  -- GENERATED --
              */
          