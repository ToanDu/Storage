
package views.html.iot.project

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

object ProjectList_activePhone extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="activePhoneModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("Xác thực số điện thoại")),format.raw/*5.102*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">

          <div class="col-12">
            <label class="form-label">"""),_display_(/*11.40*/Messages("Nhập số điện thoại")),format.raw/*11.70*/("""</label>
            <div class="input-group">
              <input type="number" name="phone" class="form-control border-end-0" id="phoneUser" maxlength="11">
            </div>
          </div>
          <div class="col-12 mt-3">
            <label class="form-label">"""),_display_(/*17.40*/Messages("Nhập mã OTP kích hoạt")),format.raw/*17.73*/("""</label>
            <div class="input-group">
              <input type="text" name="optPhone" class="form-control border-end-0" id="inputOtpPhone" maxlength="50">
              <a id="buttonGetOtpPhone" onclick="getOtpPhone()" class="input-group-text cursor-pointer">"""),_display_(/*20.106*/Messages("Nhận mã OTP")),format.raw/*20.129*/("""</a>
            </div>
          </div>

        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" onclick="processActivePhone()">"""),_display_(/*27.86*/Messages("btnComfirm")),format.raw/*27.108*/("""</button>
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
                  DATE: Mon Sep 22 16:32:46 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/project/ProjectList_activePhone.scala.html
                  HASH: 73181a7133781b11c1a3670fe22185a218c977be
                  MATRIX: 1060->0|1445->359|1500->393|1674->540|1725->570|2023->841|2077->874|2375->1144|2420->1167|2635->1355|2679->1377
                  LINES: 33->1|37->5|37->5|43->11|43->11|49->17|49->17|52->20|52->20|59->27|59->27
                  -- GENERATED --
              */
          