
package views.html.iot.userTenant

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

object UserTenantList_del extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="delModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.65*/Messages("Xoá user")),format.raw/*5.85*/("""</span>
      </div>
      <div class="modal-body">
        <div class="row mt-3">
          <div class="row">
            <input id="idDel" type="text" class="form-control input-form" readonly hidden>
            <h5 class="modal-body text-darker align-items-center" id="nameDel"></h5>
          </div>
        </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*17.79*/Messages("btnCancle")),format.raw/*17.100*/("""</button>
        <button type="button" class="btn btn-red" data-bs-dismiss="modal" onclick="processDeleteUser()">"""),_display_(/*18.106*/Messages("btnComfirm")),format.raw/*18.128*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/userTenant/UserTenantList_del.scala.html
                  HASH: 568e0da763dad159bb1c0393e8874275d434a56b
                  MATRIX: 1058->0|1475->391|1515->411|1986->855|2029->876|2172->991|2216->1013
                  LINES: 33->1|37->5|37->5|49->17|49->17|50->18|50->18
                  -- GENERATED --
              */
          