
package views.html.user

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

object UserList_edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editConfirmModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme14">
      <div class="modal-header">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("btnEdit")),format.raw/*5.87*/("""</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form class="row g-3">
          <div class="col-md-12" hidden>
            <input id="idUserEdit" name="id" type="text" class="form-control" maxlength="50" autocomplete="off" required>
          </div>
          <div class="col-md-12">
            <label class="form-label text-white">"""),_display_(/*14.51*/Messages("user.add.email")),_display_(/*14.78*/Messages(" *")),format.raw/*14.92*/("""</label>
            <input id="emailUserEdit" name="email" type="text" class="form-control" maxlength="50" autocomplete="off" required>
          </div>
        </form>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" onclick="postDataEditUser()" data-bs-dismiss="modal">"""),_display_(/*21.109*/Messages("btnSave")),format.raw/*21.128*/("""</button>
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*22.77*/Messages("btnClose")),format.raw/*22.97*/("""</button>
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
                  DATE: Mon Sep 22 16:32:56 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/user/UserList_edit.scala.html
                  HASH: 0eba4091d72c3b301e9f8ee603c2adeac36a3f88
                  MATRIX: 1043->0|1359->290|1398->309|1871->755|1918->782|1953->796|2306->1121|2347->1140|2460->1226|2501->1246
                  LINES: 33->1|37->5|37->5|46->14|46->14|46->14|53->21|53->21|54->22|54->22
                  -- GENERATED --
              */
          