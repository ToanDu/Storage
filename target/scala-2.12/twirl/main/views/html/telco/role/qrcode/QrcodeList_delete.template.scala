
package views.html.telco.role.qrcode

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

object QrcodeList_delete extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="deleteQrcodeModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block; ">
        <h5 class="modal-title" id="titleFinishCreateQrcode">"""),_display_(/*5.63*/Messages("Xóa QR Code")),format.raw/*5.86*/("""</h5>
      </div>
      <div class="modal-body">
        <input id="idQrcodeDel" hidden>
        <h5 class="modal-body text-darker align-items-center">"""),_display_(/*9.64*/Messages("Bạn có chắc chắn muốn xóa QR Code này?")),format.raw/*9.114*/("""</h5>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*12.79*/Messages("btnClose")),format.raw/*12.99*/("""</button>
        <button type="button" class="btn btn-red" data-bs-dismiss="modal" onclick="delQrcode()">"""),_display_(/*13.98*/Messages("btnComfirm")),format.raw/*13.120*/("""</button>
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
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/qrcode/QrcodeList_delete.scala.html
                  HASH: 83fd78588070ff6f04968f243e4751d527975be8
                  MATRIX: 1060->0|1443->357|1486->380|1665->533|1736->583|1893->713|1934->733|2068->840|2112->862
                  LINES: 33->1|37->5|37->5|41->9|41->9|44->12|44->12|45->13|45->13
                  -- GENERATED --
              */
          