
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

object Utilities_modal_change_package extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="modal_change_package" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">
      <div class="modal-header">
        <h6 class="modal-title">"""),_display_(/*5.34*/Messages("utilities.changePackagePlan")),format.raw/*5.73*/("""</h6>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" style="position: absolute; right: 1rem; top: 1rem; filter: grayscale(100%) brightness(60%) contrast(100%);"></button>
      </div>
      <div class="modal-body text-darker">
        <div class="row justify-content-center">
          <div class="col-md-11 text-center">
            <div class="step-container" data-group-id="orderSim">
              <div class="step active">
                <div class="circle">1</div>
                <span class="fw-bold step-title">"""),_display_(/*14.51*/Messages("utilities.unregisterOldPackage")),format.raw/*14.93*/("""</span>
              </div>
              <div class="arrow"><i class='bx bx-chevron-right'></i></div>
              <div class="step">
                <div class="circle">2</div>
                <span class="fw-bold step-title">"""),_display_(/*19.51*/Messages("utilities.registerNewPackage")),format.raw/*19.91*/("""</span>
              </div>
            </div>
          </div>
        </div>
        <div class="mt-3">
          <p class="fst-italic"><Strong>"""),_display_(/*25.42*/Messages("utilities.note")),format.raw/*25.68*/(""":</Strong> """),_display_(/*25.80*/Messages("utilities.changePackageNote")),format.raw/*25.119*/("""</p>
        </div>
        <!-- Step 1 -->
        <div class="step-content step-1">
          <div id="cancel_pack_list"></div>
        </div>

        <!-- Step 2 -->
        <div class="step-content step-2" style="display: none;">
          <div id="register_pack_list"></div>
        </div>
      </div>

      <div class="modal-footer">
        <!-- Step 1 buttons -->
        <div class="footer-step step-1">
          <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*41.81*/Messages("btnCancel")),format.raw/*41.102*/("""</button>
          <button type="button" class="btn btn-red" onclick="nextProcess()">"""),_display_(/*42.78*/Messages("utilities.continue")),format.raw/*42.108*/("""</button>
        </div>

        <!-- Step 2 buttons -->
        <div class="footer-step step-2" style="display: none;">
          <button type="button" class="btn btn-cancle" onclick="backProcess()">"""),_display_(/*47.81*/Messages("utilities.back")),format.raw/*47.107*/("""</button>
          <button type="button" class="btn btn-red"  onclick="openConfirmModalChangePackage()">"""),_display_(/*48.97*/Messages("utilities.confirm")),format.raw/*48.126*/("""</button>
        </div>
      </div>

    </div>
  </div>
</div>

<!-- Modal xác nhận -->
<div class="modal fade" id="modal_confirm_change_package" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" style="box-shadow:none">
    <div class="modal-content text-center p-4">
      <div class="modal-header border-0">
        <h5 class="modal-title w-100">"""),_display_(/*61.40*/Messages("utilities.changePackage")),format.raw/*61.75*/("""</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" style="position: absolute; right: 1rem; top: 1rem; filter: grayscale(100%) brightness(60%) contrast(100%);"></button>
      </div>

      <div class="modal-body">
        <p>"""),_display_(/*66.13*/Messages("utilities.confirmChangePackage")),format.raw/*66.55*/(""" """),format.raw/*66.56*/("""<span id="subscriber_count">0</span> """),_display_(/*66.94*/Messages("utilities.subscribers")),format.raw/*66.127*/("""?</p>
        <strong>"""),_display_(/*67.18*/Messages("utilities.oldPackage")),format.raw/*67.50*/(""" """),format.raw/*67.51*/("""<span id="pkgNameUnRegister"></span> <i class='bx bx-right-arrow-alt'></i> """),_display_(/*67.127*/Messages("utilities.newPackage")),format.raw/*67.159*/(""" """),format.raw/*67.160*/("""<span id="pkgNameRegister"></span></strong>
      </div>

      <div class="modal-footer justify-content-center border-0">
        <button type="button" class="btn btn-outline-danger" id="cancelConfirmChangeBtn">"""),_display_(/*71.91*/Messages("utilities.cancel")),format.raw/*71.119*/("""</button>
        <button type="button" class="btn btn-danger" id="confirmChangeBtn">"""),_display_(/*72.77*/Messages("utilities.confirm")),format.raw/*72.106*/("""</button>
      </div>
    </div>
  </div>
</div>
"""))
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/utilities/Utilities_modal_change_package.scala.html
                  HASH: 02b8a03f31155dbde310102dab148b9b79193bb1
                  MATRIX: 1071->0|1317->220|1376->259|1969->825|2032->867|2290->1098|2351->1138|2526->1286|2573->1312|2612->1324|2673->1363|3196->1859|3239->1880|3353->1967|3405->1997|3634->2199|3682->2225|3815->2331|3866->2360|4280->2747|4336->2782|4635->3054|4698->3096|4727->3097|4792->3135|4847->3168|4897->3191|4950->3223|4979->3224|5083->3300|5137->3332|5167->3333|5407->3546|5457->3574|5570->3660|5621->3689
                  LINES: 33->1|37->5|37->5|46->14|46->14|51->19|51->19|57->25|57->25|57->25|57->25|73->41|73->41|74->42|74->42|79->47|79->47|80->48|80->48|93->61|93->61|98->66|98->66|98->66|98->66|98->66|99->67|99->67|99->67|99->67|99->67|99->67|103->71|103->71|104->72|104->72
                  -- GENERATED --
              */
          