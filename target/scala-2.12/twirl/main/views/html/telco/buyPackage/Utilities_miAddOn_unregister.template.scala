
package views.html.telco.buyPackage

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

object Utilities_miAddOn_unregister extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="unregisterMiAddonModal" data-bs-backdrop="static"  tabindex="-1" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h6 class="modal-title">"""),_display_(/*5.34*/Messages("Huỷ gói MI, Add-on")),format.raw/*5.64*/("""</h6>
      </div>
      <div class="modal-body text-darker">
        <div class="" id="tableUnregisterMiAddon"></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*11.79*/Messages("btnCancel")),format.raw/*11.100*/("""</button>
        <button type="button" class="btn btn-red" onclick="comfirmUnregisterMiAddon()">"""),_display_(/*12.89*/Messages("btnComfirm")),format.raw/*12.111*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/buyPackage/Utilities_miAddOn_unregister.scala.html
                  HASH: f07773a5dfb37f336fad94f4bb87c4719c697ee3
                  MATRIX: 1070->0|1358->262|1408->292|1678->535|1721->556|1846->654|1890->676
                  LINES: 33->1|37->5|37->5|43->11|43->11|44->12|44->12
                  -- GENERATED --
              */
          