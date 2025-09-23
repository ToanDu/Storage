
package views.html.telco.buySim

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

object BuySim_SubsInfor extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-lg-11 col-md-8 text-start">
    <div class="row mb-4">
        <div class="col-md-12">
            <span class="display-4 title-section-1 text-darker">"""),_display_(/*4.66*/Messages("subscriber.change.info")),format.raw/*4.100*/("""</span>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
          <div class="row mb-3">
            <span class="col-sm-4 col-form-label">"""),_display_(/*11.52*/Messages("subscriber.change.upload")),format.raw/*11.88*/("""</span>
            <div class="col-sm-4">
              <input type="file" id="filesMiAddOnSubs" name="files" style="background-color: #aaa; width: 100%;" hidden/>
              <input type="text" class="form-control input-form" id="nameFileMiAddOnSubs" readonly/>
            </div>
            <label class="col-sm-4 col-form-label title-section-2" style="text-align: left; cursor: pointer; color: #EA0033;" onclick="importFileMiAddOnSubs()">
              <i class="bx bx-upload"></i> """),_display_(/*17.45*/Messages("subscriber.change.uploadList")),format.raw/*17.85*/("""
            """),format.raw/*18.13*/("""</label>
          </div>
          <div class="row mb-1">
            <span class="col-sm-4 col-form-label">"""),_display_(/*21.52*/Messages("subscriber.change.sampleFile")),format.raw/*21.92*/("""</span>
            <span class="col-sm-4 col-form-label align-items-center">"""),_display_(/*22.71*/Messages("subscriber.change.sampleFileName")),format.raw/*22.115*/("""</span>
            <div class="col-sm-4 col-form-label">
              <a style="color: #EA0033; cursor: pointer;" onclick="downloadTemplateBlockSubs()"><i class="bx bx-download"></i> """),_display_(/*24.129*/Messages("subscriber.modal.download")),format.raw/*24.166*/("""</a>
            </div>
          </div>
          <div class="row mb-1">
            <span class="col-sm-4 col-form-label">"""),_display_(/*28.52*/Messages("subscriber.change.validCount")),format.raw/*28.92*/("""</span>
            <span class="col-sm-4 col-form-label align-items-center" id="countMiAddonSubsTrue">"""),_display_(/*29.97*/Messages("subscriber.import.zeroCount")),format.raw/*29.136*/("""</span>
            <div class="col-sm-4 col-form-label">
              <a style="color: #EA0033; cursor: pointer;" onclick="exportListSubsMiAddonTrue()"><i class="bx bx-download"></i> """),_display_(/*31.129*/Messages("subscriber.modal.download")),format.raw/*31.166*/("""</a>
            </div>
          </div>
          <div class="row mb-1">
            <span class="col-sm-4 col-form-label">"""),_display_(/*35.52*/Messages("subscriber.change.invalidCount")),format.raw/*35.94*/("""</span>
            <span class="col-sm-4 col-form-label align-items-center" id="countMiAddonSubsFalse">"""),_display_(/*36.98*/Messages("subscriber.import.zeroCount")),format.raw/*36.137*/("""</span>
            <div class="col-sm-4 col-form-label">
              <a style="color: #EA0033; cursor: pointer;" onclick="exportListSubsMiAddonFalse()"><i class="bx bx-download"></i> """),_display_(/*38.130*/Messages("subscriber.modal.download")),format.raw/*38.167*/("""</a>
            </div>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/buySim/BuySim_SubsInfor.scala.html
                  HASH: 09b17ca6cdacdb3ea79356d0a38da0997ce78057
                  MATRIX: 1054->0|1248->168|1303->202|1503->375|1560->411|2077->901|2138->941|2179->954|2316->1064|2377->1104|2482->1182|2548->1226|2762->1412|2821->1449|2973->1574|3034->1614|3165->1718|3226->1757|3440->1943|3499->1980|3651->2105|3714->2147|3846->2252|3907->2291|4122->2478|4181->2515
                  LINES: 33->1|36->4|36->4|43->11|43->11|49->17|49->17|50->18|53->21|53->21|54->22|54->22|56->24|56->24|60->28|60->28|61->29|61->29|63->31|63->31|67->35|67->35|68->36|68->36|70->38|70->38
                  -- GENERATED --
              */
          