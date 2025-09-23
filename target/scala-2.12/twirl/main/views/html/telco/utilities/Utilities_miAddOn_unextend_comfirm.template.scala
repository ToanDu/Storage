
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

object Utilities_miAddOn_unextend_comfirm extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="comfirmUnextendMiAddonModal" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h6 class="modal-title">"""),_display_(/*5.34*/Messages("utilities.cancelMiAddonRenewal")),format.raw/*5.76*/("""</h6>
         <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" style="position: absolute; right: 1rem; top: 1rem; filter: grayscale(100%) brightness(60%) contrast(100%);"></button>
      </div>
      <div class="modal-body text-darker">
        <h6 id="textComfirmUnextendMiAddon">"""),_display_(/*9.46*/Messages("utilities.confirmCancelRenewal")),format.raw/*9.88*/("""</h6>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-red" data-bs-dismiss="modal" onclick="processUnextendMiAddon(0)">"""),_display_(/*12.112*/Messages("btnComfirm")),format.raw/*12.134*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/utilities/Utilities_miAddOn_unextend_comfirm.scala.html
                  HASH: 3b61d88a12051a99678ef91e8848876c6477b462
                  MATRIX: 1075->0|1332->231|1394->273|1737->590|1799->632|1990->795|2034->817|2149->905|2192->926
                  LINES: 33->1|37->5|37->5|41->9|41->9|44->12|44->12|45->13|45->13
                  -- GENERATED --
              */
          