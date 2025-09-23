
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

object QrCode_delete extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="deleteQrConfirm" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content bg-danger">
      <div class="modal-header">
        <h5 class="modal-title text-white">"""),_display_(/*5.45*/Messages("qr.delete")),format.raw/*5.66*/("""</h5>
      </div>
      <div class="modal-body text-white">
        <h4 class="modal-body text-white" id="myModalbody">"""),_display_(/*8.61*/Messages("noti.confirmDeletebody")),format.raw/*8.95*/("""</h4>
        <div class="form-group" hidden>
          <input id="idDelete" class="form-control" name="id" >
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-light" data-bs-dismiss="modal" onclick="processDeleteQr()">"""),_display_(/*14.106*/Messages("btnDelete")),format.raw/*14.127*/("""</button>
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*15.77*/Messages("btnCancel")),format.raw/*15.98*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/qrCodeCam/QrCode_delete.scala.html
                  HASH: 26d7808fc425f28b042b2415f8e89bb2a121a757
                  MATRIX: 1048->0|1301->227|1342->248|1489->369|1543->403|1847->679|1890->700|2003->786|2045->807
                  LINES: 33->1|37->5|37->5|40->8|40->8|46->14|46->14|47->15|47->15
                  -- GENERATED --
              */
          