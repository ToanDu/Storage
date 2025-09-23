
package views.html.telco.account

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

object Account_updateEnterprise extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="updateEnterpriseModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block; ">
        <h5 class="modal-title " id="myModalLabel">"""),_display_(/*5.53*/Messages("common.confirm")),format.raw/*5.79*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">

          <div class="col-12 mt-3">
            <label class="form-label">"""),_display_(/*11.40*/Messages("account.selectRepresentativePhone")),format.raw/*11.85*/("""</label>
            <div id="phoneRepresent">

            </div>
          </div>

          <div class="col-12 mt-3">
            <label class="form-label">"""),_display_(/*18.40*/Messages("common.enterCode")),format.raw/*18.68*/("""</label>
            <div class="input-group">
              <input type="number" class="form-control border-end-0" id="optUpdateEnterprise" maxlength="50">
              <div id="buttonOtpOfEnterprise"></div>
            </div>
          </div>
          <div class="col-12 mt-3">
            <label class="form-label">"""),_display_(/*25.40*/Messages("account.otpInstructionUpdate")),format.raw/*25.80*/("""</label>
          </div>

        </div>
      </div>
      <div class="modal-footer">
        <div id="buttonUpdateEnterprise">

        </div>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*34.82*/Messages("common.close")),format.raw/*34.106*/("""</button>
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
                  DATE: Mon Sep 22 16:32:50 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/account/Account_updateEnterprise.scala.html
                  HASH: 7190712def2b2e964603753195dc85a616f97031
                  MATRIX: 1063->0|1440->351|1486->377|1665->529|1731->574|1918->734|1967->762|2315->1083|2376->1123|2630->1350|2676->1374
                  LINES: 33->1|37->5|37->5|43->11|43->11|50->18|50->18|57->25|57->25|66->34|66->34
                  -- GENERATED --
              */
          