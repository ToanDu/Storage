
package views.html.telco.blockUtilities

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

object Utilities_miAddOn_register extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="registerMiAddonModal" data-bs-backdrop="static"  tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content" id="theme16">
            <div class="modal-header">
                <h6 class="modal-title">"""),_display_(/*5.42*/Messages("Đăng ký gói MI, Add-on")),format.raw/*5.76*/("""</h6>
            </div>
            <div class="modal-body text-darker">
                <div class="" id="tableRegisterMiAddon">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*12.87*/Messages("btnCancel")),format.raw/*12.108*/("""</button>
                <button type="button" class="btn btn-red" onclick="comfirmRegisterMiAddon()">"""),_display_(/*13.95*/Messages("btnComfirm")),format.raw/*13.117*/("""</button>
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
                  DATE: Mon Sep 22 16:32:51 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/blockUtilities/Utilities_miAddOn_register.scala.html
                  HASH: 9d0d8f90ae6664f3632fad657a46a3c33c5fe5f0
                  MATRIX: 1072->0|1378->280|1432->314|1757->612|1800->633|1931->737|1975->759
                  LINES: 33->1|37->5|37->5|44->12|44->12|45->13|45->13
                  -- GENERATED --
              */
          