
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

object QrCode_create extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addConfirmModal" data-bs-backdrop="static"  tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-white" id="exampleModalLabel" >"""),_display_(/*5.69*/Messages("btnAdd")),format.raw/*5.87*/("""</h5>
      </div>
      <div class="modal-body">
        <form class="row g-3">
          <div class="col-md-12" hidden>
            <input id="idDevice">
          </div>
          <div class="col-md-12" style="text-align: center">
            <label class="form-label"  id="titleComfirmImport">"""),_display_(/*13.65*/Messages("")),format.raw/*13.77*/("""</label>

            <div class="sm-9" style="margin-left: 13%; padding: 0pt; height: 238pt; width: 510.4pt;" >
              <div style="width: 100%; height: 100%; border-radius: 12pt; border: 0.5px solid #000000; background-color: #FFFFFF" id="imgQrCode">
                <div class="" style="height: 50.4pt; border-bottom: 0.5px solid #000000;">
                  <span style="float: left; margin-left: 17.2pt; font-size: 32pt; color: #333333; font-weight: 600; margin-top: 2.4pt;">"""),_display_(/*18.138*/Messages("Home Hub")),format.raw/*18.158*/("""</span>
                  <img src=""""),_display_(/*19.30*/routes/*19.36*/.Assets.versioned("images/cam/viettel3x.png")),format.raw/*19.81*/("""" alt="..." class="" style="height: 29.6pt; width: 151.6pt; float: right; margin-right: 24pt; margin-top: 10.4pt;">
                </div>
                <div class="">
                  <span class="form-label" style="font-size: 20pt; float: left; margin-top: 12.8pt; margin-left: 13.2pt; color: #333333; font-weight: 600">"""),_display_(/*22.157*/Messages("Model: VHUB-Y04")),format.raw/*22.184*/("""</span>
                  <span style="font-size: 20pt; float: left; margin-top: 51.2pt; margin-left: -174.8pt; color: #333333; font-weight: 600">"""),_display_(/*23.140*/Messages("INPUT: 48V - 0.5A")),format.raw/*23.169*/("""</span>
                  <span style="font-size: 20pt; float: left; margin-top: 89.6pt; margin-left: -175.4pt; color: #333333; font-weight: 600" id="serialQr">"""),_display_(/*24.154*/Messages("S/N: TWFX000012")),format.raw/*24.181*/("""</span>
                  <span style="font-size: 20pt; float: left; margin-top: 126.4pt; margin-left: -174.8pt; color: #333333; font-weight: 600" id="macQr">"""),_display_(/*25.152*/Messages("MAC: 00:02:D1:94:72:E9")),format.raw/*25.186*/("""</span>
                  <img src=""""),_display_(/*26.30*/routes/*26.36*/.Assets.versioned("images/cam/re3x.png")),format.raw/*26.76*/("""" alt="..." class="" style="height: 55.2pt; width: 52.4pt; margin-top: 27.2px; margin-left: -48pt;">
                  <img src=""""),_display_(/*27.30*/routes/*27.36*/.Assets.versioned("images/cam/ro3x.png")),format.raw/*27.76*/("""" alt="..." class="" style="height: 31.6pt; width: 78.4pt; position: absolute; margin-top: 115.2px; margin-left: -67.2pt;">
                  <div class="" style="width: 166pt; height: 166pt; border-radius: 5pt; border: 0.5px solid #000000; float: right; margin-right: 8.4pt; margin-top: 7.6pt;" id="id_qrcode">
                    <img src=""""),_display_(/*29.32*/routes/*29.38*/.Assets.versioned("images/cam/qr3x.png")),format.raw/*29.78*/("""" alt="..." class="" style="height: 128pt; width: 128pt; margin-top: 12.8pt;">
                  </div>
                </div>
              </div>
            </div>

          </div>
        </form>
      </div>
      <div class="modal-body" style="max-height: 500px; overflow: auto" id="divTableImport">
        <table id="tableImport" class="table" style="width: 100%;">
          <tbody align="left" class=""></tbody>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" id="buttonSubmitQrCode" onclick="submitQrCodeCam(1)">"""),_display_(/*44.109*/Messages("btnComfirm")),format.raw/*44.131*/("""</button>
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal" onclick="cancleImportCSV()">"""),_display_(/*45.105*/Messages("btnClose")),format.raw/*45.125*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/qrCodeCam/QrCode_create.scala.html
                  HASH: 048d857c02773a44db90d90d9f0b5e38b091edd2
                  MATRIX: 1048->0|1400->326|1438->344|1763->642|1796->654|2311->1141|2353->1161|2417->1198|2432->1204|2498->1249|2852->1575|2901->1602|3076->1749|3127->1778|3316->1939|3365->1966|3552->2125|3608->2159|3672->2196|3687->2202|3748->2242|3905->2372|3920->2378|3981->2418|4351->2761|4366->2767|4427->2807|5049->3401|5093->3423|5235->3537|5277->3557
                  LINES: 33->1|37->5|37->5|45->13|45->13|50->18|50->18|51->19|51->19|51->19|54->22|54->22|55->23|55->23|56->24|56->24|57->25|57->25|58->26|58->26|58->26|59->27|59->27|59->27|61->29|61->29|61->29|76->44|76->44|77->45|77->45
                  -- GENERATED --
              */
          