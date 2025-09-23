
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

object Utilities_openSubs1_comfirm extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="comfirmOpen1SubsModal" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h6 class="modal-title">"""),_display_(/*5.34*/Messages("Xác nhận mở 1 chiều thuê bao")),format.raw/*5.74*/("""</h6>
      </div>
      <div class="modal-body text-darker">
        <h5 class="modal-body text-darker align-items-center" id="comfirmCountOpenSubs1"></h5>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-red" data-bs-dismiss="modal" onclick="processOpenListSubs()">"""),_display_(/*11.108*/Messages("btnComfirm")),format.raw/*11.130*/("""</button>
        <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*12.79*/Messages("btnCancel")),format.raw/*12.100*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/topUp/Utilities_openSubs1_comfirm.scala.html
                  HASH: 596ae9662c099de9e2fb1a1010f7f96428dfcc2e
                  MATRIX: 1064->0|1315->225|1375->265|1713->575|1757->597|1872->685|1915->706
                  LINES: 33->1|37->5|37->5|43->11|43->11|44->12|44->12
                  -- GENERATED --
              */
          