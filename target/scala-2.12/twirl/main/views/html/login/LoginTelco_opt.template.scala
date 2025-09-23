
package views.html.login

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

object LoginTelco_opt extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="optPhoneLoginModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block; background-color: red;">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("Xác thực OTP")),format.raw/*5.92*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-12 mt-3">
            <label class="form-label">"""),_display_(/*10.40*/Messages("Nhập mã OTP xác nhận đăng nhập")),format.raw/*10.82*/("""</label>
            <div class="input-group">
              <input type="number" name="optPhoneLogin" class="form-control" id="optPhoneLogin" maxlength="50">
              """),format.raw/*13.134*/("""
            """),format.raw/*14.13*/("""</div>
          </div>

        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" onclick="comfirmOtpLogin()">"""),_display_(/*20.83*/Messages("btnComfirm")),format.raw/*20.105*/("""</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*21.82*/Messages("btnClose")),format.raw/*21.102*/("""</button>
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
                  DATE: Mon Sep 22 16:32:48 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/login/LoginTelco_opt.scala.html
                  HASH: d6f4199306b948706bcbe628998d41d74986c2a3
                  MATRIX: 1045->0|1456->385|1500->409|1678->560|1741->602|1943->894|1984->907|2179->1075|2223->1097|2341->1188|2383->1208
                  LINES: 33->1|37->5|37->5|42->10|42->10|45->13|46->14|52->20|52->20|53->21|53->21
                  -- GENERATED --
              */
          