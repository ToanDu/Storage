
package views.html.group

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

object GroupList_modal_user_delUsers extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="deleteUsersconfirm" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-white">"""),_display_(/*5.45*/Messages("iot.manage.removeUsers")),format.raw/*5.79*/("""</h5>
      </div>
      <div class="modal-body text-white">
        <h4 class="modal-body text-darker align-items-center" id="myModalbody">"""),_display_(/*8.81*/Messages("noti.confirmDeletebody")),format.raw/*8.115*/("""</h4>
        <div class="form-group" hidden>
          <input id="idUserDelete" class="form-control" name="idUserDelete">
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal" onclick="postDataDelUserInOrg()">"""),_display_(/*14.112*/Messages("btnDelete")),format.raw/*14.133*/("""</button>
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*15.77*/Messages("btnCancel")),format.raw/*15.98*/("""</button>
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
                  DATE: Mon Sep 22 16:32:42 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList_modal_user_delUsers.scala.html
                  HASH: 023f9721bb43c13cc69fb4d1a926fa8af56c51cc
                  MATRIX: 1060->0|1319->233|1373->267|1540->408|1595->442|1918->737|1961->758|2074->844|2116->865
                  LINES: 33->1|37->5|37->5|40->8|40->8|46->14|46->14|47->15|47->15
                  -- GENERATED --
              */
          