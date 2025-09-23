
package views.html.telco.role.account

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

object InfoAccountCmp_genPass extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="generatePassModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.65*/Messages("Generate Password")),format.raw/*5.94*/("""</span>
      </div>
      <div class="modal-body">
        <div class="row g-3">
          <div class="row mt-3">
            <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*10.69*/Messages("Email")),format.raw/*10.86*/("""</label>
            <div class="col-sm-12">
              <input id="genEmail" type="text" class="form-control input-form" readonly>
            </div>
          </div>

          <div class="row mt-3">
            <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*17.69*/Messages("Mật khẩu mới")),format.raw/*17.93*/("""</label>
            <div class="col-sm-12">
              <input id="genPass" type="text" class="form-control input-form" readonly>
            </div>
          </div>

        </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*27.79*/Messages("btnClose")),format.raw/*27.99*/("""</button>
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
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/account/InfoAccountCmp_genPass.scala.html
                  HASH: bf8beec3aa28f6b35b9c012c1ea7d4b873b56590
                  MATRIX: 1066->0|1492->400|1541->429|1751->612|1789->629|2088->901|2133->925|2470->1235|2511->1255
                  LINES: 33->1|37->5|37->5|42->10|42->10|49->17|49->17|59->27|59->27
                  -- GENERATED --
              */
          