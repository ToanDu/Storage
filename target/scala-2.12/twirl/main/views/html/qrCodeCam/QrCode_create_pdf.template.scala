
package views.html.qrCodeCam

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

object QrCode_create_pdf extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="pdfConfirmModal" data-bs-backdrop="static"  tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-fullscreen">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-white" id="exampleModalLabel" >"""),_display_(/*5.69*/Messages("btnAdd")),format.raw/*5.87*/("""</h5>
      </div>
      <div class="modal-body">
        <form class="row g-3">
          <div class="col-md-12" hidden>
            <input id="idDevice">
          </div>
          <div class="col-md-12" style="text-align: center;">
            <label class="form-label"  id="titleComfirmImport">"""),_display_(/*13.65*/Messages("")),format.raw/*13.77*/("""</label>

            <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 row-cols-xl-4" id="divPdfQrcode" style="width: 1024px">

              <div class="col mt-3">
                <div style="height: 59.5pt; width: 127.6pt; border-radius: 6pt; border: 0.5px solid #000000; background-color: #FFFFFF" id="imgQrCode">
                  <div class="" style="height: 12.6pt; border-bottom: 0.5px solid #000000;">
                    <span style="float: left; margin-left: 4.3pt; font-size: 8pt; color: #333333; font-weight: 600; margin-top: 0.6pt;">"""),_display_(/*20.138*/Messages("Home Hub")),format.raw/*20.158*/("""</span>
                    <img src=""""),_display_(/*21.32*/routes/*21.38*/.Assets.versioned("images/cam/viettel3x.png")),format.raw/*21.83*/("""" alt="..." class="" style="height: 7.4pt; width: 37.9pt; float: right; margin-right: 6pt; margin-top: 2.6pt;">
                  </div>
                  <div class="">
                    <span class="form-label" style="font-size: 5pt; float: left; margin-top: 3.2pt; margin-left: 3.3pt; color: #333333; font-weight: 600">"""),_display_(/*24.156*/Messages("Model: VHUB-Y04")),format.raw/*24.183*/("""</span>
                    <span style="font-size: 5pt; float: left; margin-top: 12.8pt; margin-left: -47.8pt; color: #333333; font-weight: 600">"""),_display_(/*25.140*/Messages("INPUT: 48V - 0.5A")),format.raw/*25.169*/("""</span>
                    <span style="font-size: 5pt; float: left; margin-top: 22.4pt; margin-left: -48.2pt; color: #333333; font-weight: 600" id="serialQr">"""),_display_(/*26.154*/Messages("S/N: TWFX000012")),format.raw/*26.181*/("""</span>
                    <span style="font-size: 5pt; float: left; margin-top: 31.6pt; margin-left: -48.2pt; color: #333333; font-weight: 600" id="macQr">"""),_display_(/*27.151*/Messages("MAC: 00:02:D1:94:72:E9")),format.raw/*27.185*/("""</span>
                    <img src=""""),_display_(/*28.32*/routes/*28.38*/.Assets.versioned("images/cam/re3x.png")),format.raw/*28.78*/("""" alt="..." class="" style="height: 13.8pt; width: 13.1pt; margin-top: 6.8px; margin-left: -12pt;">
                    <img src=""""),_display_(/*29.32*/routes/*29.38*/.Assets.versioned("images/cam/ro3x.png")),format.raw/*29.78*/("""" alt="..." class="" style="height: 7.9pt; width: 19.6pt; position: absolute; margin-top: 28.8px; margin-left: -16.8pt;">
                    <div class="" style="width: 42.5pt; height: 42.5pt; border-radius: 5pt; border: 0.5px solid #000000; float: right; margin-right: 2.1pt; margin-top: 1.9pt;" id="id_qrcode">
                      <img src=""""),_display_(/*31.34*/routes/*31.40*/.Assets.versioned("images/cam/qr3x.png")),format.raw/*31.80*/("""" alt="..." class="" style="height: 36pt; width: 36pt; margin-top: 3.2pt;">
                    </div>
                  </div>
                </div>
              </div>

            </div>

          </div>
        </form>
      </div>
      <div class="modal-body" style="" id="divTableImport">
        <table id="tableImport" class="table" style="width: 100%;">
          <tbody align="left" class=""></tbody>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" id="buttonSubmitQrCode" onclick="submitQrCodeCamPdf(1)">"""),_display_(/*48.112*/Messages("btnComfirm")),format.raw/*48.134*/("""</button>
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal" onclick="cancleImportCSV()">"""),_display_(/*49.105*/Messages("btnClose")),format.raw/*49.125*/("""</button>
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
                  DATE: Mon Sep 22 16:32:49 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/qrCodeCam/QrCode_create_pdf.scala.html
                  HASH: 0c14de10ca41dbe53cb7b9a19102a72d9288fa3f
                  MATRIX: 1052->0|1412->334|1450->352|1776->651|1809->663|2390->1216|2432->1236|2498->1275|2513->1281|2579->1326|2932->1651|2981->1678|3156->1825|3207->1854|3396->2015|3445->2042|3631->2200|3687->2234|3753->2273|3768->2279|3829->2319|3987->2450|4002->2456|4063->2496|4437->2843|4452->2849|4513->2889|5130->3478|5174->3500|5316->3614|5358->3634
                  LINES: 33->1|37->5|37->5|45->13|45->13|52->20|52->20|53->21|53->21|53->21|56->24|56->24|57->25|57->25|58->26|58->26|59->27|59->27|60->28|60->28|60->28|61->29|61->29|61->29|63->31|63->31|63->31|80->48|80->48|81->49|81->49
                  -- GENERATED --
              */
          