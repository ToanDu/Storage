
package views.html.QrCodePage

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

object QrCodeList_create extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addConfirmModal" data-bs-backdrop="static"  tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme14">
      <div class="modal-header">
        <h5 class="modal-title text-white" id="exampleModalLabel" >"""),_display_(/*5.69*/Messages("btnAdd")),format.raw/*5.87*/("""</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" onclick="cancleImportCSV()"></button>
      </div>
      <div class="modal-body">
        <form class="row g-3">
          <div class="col-md-12" hidden>
            <input id="idDevice">
          </div>
          <div class="col-md-12" style="text-align: center">
            <label class="form-label text-white"  id="titleComfirmImport">"""),_display_(/*14.76*/Messages("")),format.raw/*14.88*/("""</label>
            <div class="ms-9" id="id_qrcode"></div>
          </div>
        </form>
      </div>
      <div class="modal-body" style="max-height: 500px; overflow: auto" id="divTableImport">
        <table id="tableImport" class="table" style="width: 100%;">
          """),format.raw/*21.22*/("""
            """),format.raw/*22.47*/("""
            """),format.raw/*23.62*/("""
          """),format.raw/*24.23*/("""
          """),format.raw/*25.11*/("""<tbody align="left" class="text-white"></tbody>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" id="buttonSubmitQrCode" onclick="submitQrCode(1)">"""),_display_(/*29.106*/Messages("btnComfirm")),format.raw/*29.128*/("""</button>
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal" onclick="cancleImportCSV()">"""),_display_(/*30.105*/Messages("btnClose")),format.raw/*30.125*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/QrCodePage/QrCodeList_create.scala.html
                  HASH: bce6724e95e8035b8e69d2c5989bf04fedc35b4d
                  MATRIX: 1053->0|1396->317|1434->335|1899->773|1932->785|2238->1074|2279->1121|2320->1183|2359->1206|2398->1217|2642->1433|2686->1455|2828->1569|2870->1589
                  LINES: 33->1|37->5|37->5|46->14|46->14|53->21|54->22|55->23|56->24|57->25|61->29|61->29|62->30|62->30
                  -- GENERATED --
              */
          