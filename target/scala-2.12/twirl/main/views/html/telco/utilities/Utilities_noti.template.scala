
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

object Utilities_noti extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="notificationModal" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h4 class="modal-title">"""),_display_(/*5.34*/Messages("utilities.notification")),format.raw/*5.68*/("""</h4>
        <img src=""""),_display_(/*6.20*/routes/*6.26*/.Assets.versioned("images/telco/successIcon.png")),format.raw/*6.75*/("""" alt="..." style="width: 56px; height: 56px;" class="card-img mt-3"><br>
        <div class="mt-4">
          <span class="modal-body text-darker align-items-center noti1" id="textNofitication1"></span><br>
          <span class="modal-body text-darker align-items-center noti2" id="textNofitication2"></span><br>
        </div>

        <button type="button" class="btn btn-cancle mt-3" data-bs-dismiss="modal">"""),_display_(/*12.84*/Messages("btnClose")),format.raw/*12.104*/("""</button>
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
                  DATE: Mon Sep 22 16:32:55 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/utilities/Utilities_noti.scala.html
                  HASH: 8e1beabf9145fd68dcf7e367a420fe697996640c
                  MATRIX: 1055->0|1302->221|1356->255|1407->280|1421->286|1490->335|1931->749|1973->769
                  LINES: 33->1|37->5|37->5|38->6|38->6|38->6|44->12|44->12
                  -- GENERATED --
              */
          