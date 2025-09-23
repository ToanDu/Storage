
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

object UserList_createDeviceToken extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="createDeviceTokenModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("btnAdd")),format.raw/*5.86*/("""</h5>
      </div>
      <div class="modal-body">
        <h4 class="modal-body" id="myModalbody">"""),_display_(/*8.50*/Messages("noti.confirmCreateDeviceToken")),format.raw/*8.91*/("""</h4>
        <form class="row g-3">
          <div class="col-md-12" hidden>
            <input id="idCreateDeviceToken" name="id" type="text" class="form-control" maxlength="50" autocomplete="off" required>
          </div>
        </form>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" onclick="postDataCreateDeviceToken()" data-bs-dismiss="modal">"""),_display_(/*17.117*/Messages("btnComfirm")),format.raw/*17.139*/("""</button>
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*18.77*/Messages("btnClose")),format.raw/*18.97*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/user/UserList_createDeviceToken.scala.html
                  HASH: 33081835836ac10794e688daab1c12e975bb03cb
                  MATRIX: 1056->0|1378->296|1416->314|1541->413|1602->454|2035->859|2079->881|2192->967|2233->987
                  LINES: 33->1|37->5|37->5|40->8|40->8|49->17|49->17|50->18|50->18
                  -- GENERATED --
              */
          