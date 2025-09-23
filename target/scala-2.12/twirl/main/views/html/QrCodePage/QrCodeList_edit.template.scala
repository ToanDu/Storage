
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

object QrCodeList_edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editQrConfirm" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" id="theme14">
            <div class="modal-header">
                <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.76*/Messages("qr.edit")),format.raw/*5.95*/("""</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form class="row g-3">
                    <div class="col-md-12">
                        <label class="form-label text-white">"""),_display_(/*11.63*/Messages("qr.id")),format.raw/*11.80*/("""</label>
                        <input id="idQrEdit" type="text" class="form-control" maxlength="50" autocomplete="off" readonly>
                    </div>
                    <div class="col-md-12">
                        <label class="form-label text-white">"""),_display_(/*15.63*/Messages("qr.Name")),format.raw/*15.82*/("""</label>
                        <input id="nameQrEdit" type="text" class="form-control" maxlength="50" autocomplete="off" required>
                    </div>
                    <div class="col-md-12">
                        <label class="form-label text-white">"""),_display_(/*19.63*/Messages("qr.LinkAndroid")),format.raw/*19.89*/("""</label>
                        <input id="androidQrEdit" type="text" class="form-control" maxlength="500" autocomplete="off" required>
                    </div>
                    <div class="col-md-12">
                        <label class="form-label text-white">"""),_display_(/*23.63*/Messages("qr.LinkIos")),format.raw/*23.85*/("""</label>
                        <input id="iosQrEdit" type="text" class="form-control" maxlength="500" autocomplete="off" required>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" onclick="postEditQr()" data-bs-dismiss="modal">"""),_display_(/*29.111*/Messages("btnSave")),format.raw/*29.130*/("""</button>
                <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*30.85*/Messages("btnClose")),format.raw/*30.105*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/QrCodePage/QrCodeList_edit.scala.html
                  HASH: 714efcda29ff98a97c589effebb150a80a4bc328
                  MATRIX: 1051->0|1384->307|1423->326|1766->642|1804->659|2095->923|2135->942|2428->1208|2475->1234|2772->1504|2815->1526|3195->1878|3236->1897|3357->1991|3399->2011
                  LINES: 33->1|37->5|37->5|43->11|43->11|47->15|47->15|51->19|51->19|55->23|55->23|61->29|61->29|62->30|62->30
                  -- GENERATED --
              */
          