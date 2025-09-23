
package views.html.telco.topUp

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

object Utilities_openSubscriber_pay extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="payMyViettelModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <img src=""""),_display_(/*5.20*/routes/*5.26*/.Assets.versioned("images/telco/successIcon.png")),format.raw/*5.75*/("""" alt="..." style="width: 56px; height: 56px;" class="card-img mt-3"><br>
        <h6 class="modal-title mt-3">"""),_display_(/*6.39*/Messages("Quý khách vui lòng nhấn xác nhận sau khi đã thanh toán thành công!")),format.raw/*6.117*/("""</h6>

        <button type="button" class="btn btn-red mt-5" onclick="comfirmPayOpenSubsSuccess()">"""),_display_(/*8.95*/Messages("btnComfirm")),format.raw/*8.117*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/topUp/Utilities_openSubscriber_pay.scala.html
                  HASH: d63a622db13a299dd9706a5e235a1a2363a89e88
                  MATRIX: 1065->0|1403->312|1417->318|1486->367|1624->479|1723->557|1850->658|1893->680
                  LINES: 33->1|37->5|37->5|37->5|38->6|38->6|40->8|40->8
                  -- GENERATED --
              */
          