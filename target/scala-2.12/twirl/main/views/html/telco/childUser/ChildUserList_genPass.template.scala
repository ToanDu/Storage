
package views.html.telco.childUser

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

object ChildUserList_genPass extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="generatePassModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.65*/Messages("Reset mật khẩu")),format.raw/*5.91*/("""</span>
      </div>
      <div class="modal-body">
        <div class="row g-3">
          <div class="row mt-3">
"""),format.raw/*10.97*/("""
            """),format.raw/*11.13*/("""<div class="col-sm-12">
              <input id="genId" type="text" class="form-control input-form" readonly hidden>
            </div>
          </div>

          <div class="row mt-3">
            <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*17.69*/Messages("User")),format.raw/*17.85*/("""</label>
            <div class="col-sm-12">
              <input id="emailResetChildUser" type="text" class="form-control input-form" readonly>
            </div>
          </div>

          <div class="row mt-3">
            <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*24.69*/Messages("Mật khẩu mới")),format.raw/*24.93*/("""</label>
            <div class="col-sm-12">
              <input id="genPass" type="text" class="form-control input-form" readonly>
            </div>
          </div>

        </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*34.79*/Messages("btnClose")),format.raw/*34.99*/("""</button>
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
                  DATE: Mon Sep 22 16:32:52 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/childUser/ChildUserList_genPass.scala.html
                  HASH: 37830b2b4dbe14d19e839d2b92a548270eaf216f
                  MATRIX: 1062->0|1488->400|1534->426|1677->637|1718->650|2000->905|2037->921|2347->1204|2392->1228|2729->1538|2770->1558
                  LINES: 33->1|37->5|37->5|42->10|43->11|49->17|49->17|56->24|56->24|66->34|66->34
                  -- GENERATED --
              */
          