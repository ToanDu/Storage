
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

object Account_otp extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="optPhoneModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title" id="exampleModalLabel">"""),_display_(/*5.57*/Messages("account.verifyPhone")),format.raw/*5.88*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-12 mt-3">
            <label class="form-label">"""),_display_(/*10.40*/Messages("account.enterOtpCode")),format.raw/*10.72*/("""</label>
            <div class="input-group">
              <input type="text" name="optPhone" class="form-control border-end-0" id="inputOtpPhone" maxlength="50">
              <a id="buttonGetOtpPhone" onclick="otpPhone()" class="input-group-text cursor-pointer">"""),_display_(/*13.103*/Messages("account.getOtpCode")),format.raw/*13.133*/("""</a>
            </div>
          </div>

        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" onclick="activePhone()">"""),_display_(/*20.79*/Messages("common.confirm")),format.raw/*20.105*/("""</button>
        <button type="button" class="btn btn-secondary" onclick="clearinterval()" data-bs-dismiss="modal">"""),_display_(/*21.108*/Messages("common.close")),format.raw/*21.132*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/account/Account_otp.scala.html
                  HASH: 4ca182d4762c2cadbfb4fcb28650e3738042eac6
                  MATRIX: 1050->0|1421->345|1472->376|1650->527|1703->559|1998->826|2050->856|2258->1037|2306->1063|2451->1180|2497->1204
                  LINES: 33->1|37->5|37->5|42->10|42->10|45->13|45->13|52->20|52->20|53->21|53->21
                  -- GENERATED --
              */
          