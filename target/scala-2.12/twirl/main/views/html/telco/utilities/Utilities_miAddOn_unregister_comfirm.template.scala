
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

object Utilities_miAddOn_unregister_comfirm extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="comfirmUnregisterMiAddonModal" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h6 class="modal-title">"""),_display_(/*5.34*/Messages("utilities.unregisterMiAddon")),format.raw/*5.73*/("""</h6>
         <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" style="position: absolute; right: 1rem; top: 1rem; filter: grayscale(100%) brightness(60%) contrast(100%);"></button>
      </div>
      <div class="modal-body text-darker">
        <h6 id="textComfirmUnregisterMiAddon">"""),_display_(/*9.48*/Messages("utilities.confirmUnregisterMiAddon")),format.raw/*9.94*/("""</h6>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-red" data-bs-dismiss="modal" onclick="processUnregisterMiAddon(0)">"""),_display_(/*12.114*/Messages("btnComfirm")),format.raw/*12.136*/("""</button>
        <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*13.79*/Messages("btnCancel")),format.raw/*13.100*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/utilities/Utilities_miAddOn_unregister_comfirm.scala.html
                  HASH: 24cbd9788dec0f0748abe178a7aa75240a865bf9
                  MATRIX: 1077->0|1336->233|1395->272|1740->591|1806->637|1999->802|2043->824|2158->912|2201->933
                  LINES: 33->1|37->5|37->5|41->9|41->9|44->12|44->12|45->13|45->13
                  -- GENERATED --
              */
          