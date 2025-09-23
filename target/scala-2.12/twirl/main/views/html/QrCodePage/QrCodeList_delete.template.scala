
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

object QrCodeList_delete extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="deleteQrConfirm" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content bg-danger">
      <div class="modal-header">
        <h5 class="modal-title text-white">"""),_display_(/*5.45*/Messages("qr.delete")),format.raw/*5.66*/("""</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body text-white">
        <h4 class="modal-body text-white" id="myModalbody">"""),_display_(/*9.61*/Messages("noti.confirmDeletebody")),format.raw/*9.95*/("""</h4>
        <div class="form-group" hidden>
          <input id="idDelete" class="form-control" name="id" >
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-light" data-bs-dismiss="modal" onclick="processDeleteQr()">"""),_display_(/*15.106*/Messages("btnDelete")),format.raw/*15.127*/("""</button>
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*16.77*/Messages("btnCancel")),format.raw/*16.98*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/QrCodePage/QrCodeList_delete.scala.html
                  HASH: 09ebc5096876cd3642d033eb535f680593603c33
                  MATRIX: 1053->0|1315->236|1356->257|1604->479|1658->513|1962->789|2005->810|2118->896|2160->917
                  LINES: 33->1|37->5|37->5|41->9|41->9|47->15|47->15|48->16|48->16
                  -- GENERATED --
              */
          