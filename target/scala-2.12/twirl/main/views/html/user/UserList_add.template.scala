
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

object UserList_add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addConfirmModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" id="theme14">
            <div class="modal-header">
                <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.76*/Messages("btnAdd")),format.raw/*5.94*/("""</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form class="row g-3">
                    <div class="col-md-6">
                        <label class="form-label text-white">"""),_display_(/*11.63*/Messages("user.add.email")),_display_(/*11.90*/Messages(" *")),format.raw/*11.104*/("""</label>
                        <input id="emailUserAdd" name="email" type="text" class="form-control" maxlength="50" autocomplete="off" required>
                        <hr>
                        <label for="inputChoosePassword" class="text-darker">"""),_display_(/*14.79*/Messages("login.Password")),_display_(/*14.106*/Messages(" *")),format.raw/*14.120*/("""</label>
                        <div class="input-group" id="show_hide_password">
                            <input type="password" name="password" class="form-control border-end-0" id="inputCreateNewPassword" required>
                            <a id="iconHidePass" onclick="showPassword1()" class="input-group-text"><i class='bx bx-hide'></i></a>
                        </div>
                        <hr>
                        <label for="inputRePassword" class="text-darker">"""),_display_(/*20.75*/Messages("login.RePassword")),_display_(/*20.104*/Messages(" *")),format.raw/*20.118*/("""</label>
                        <div class="input-group" id="show_hide_password">
                            <input type="password" name="passwordRepeat" class="form-control border-end-0" id="inputCreateNewRePassword" required>
                            <a id="iconHideRePass" onclick="showRePassword1()" class="input-group-text"><i class='bx bx-hide'></i></a>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <input id="organizationAdd" name="name" type="text" class="form-control" maxlength="50" autocomplete="off" hidden>
                        <label class="form-label text-white">"""),_display_(/*28.63*/Messages("Organizations")),_display_(/*28.89*/Messages(" *")),format.raw/*28.103*/("""</label>
                        <div class="ms-9">
                            <input type="hidden" id="itype" name="itype" value="0" >
                            <input type="hidden" id="orgIdMoveAdd">
                            <div class="input-group">
                                <a class="input-group-text"><i class='bx bx-search'></i></a>
                                <input id="search-selectOrgAdd"  class="search-input form-control border-start-0">
                            </div>

                            <hr>
                            <div id="selectOrganizationsAdd" style="overflow: auto"></div>
                        </div>
                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" onclick="postDataCreateUser()" data-bs-dismiss="modal">"""),_display_(/*45.119*/Messages("btnSave")),format.raw/*45.138*/("""</button>
                <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*46.85*/Messages("btnClose")),format.raw/*46.105*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/user/UserList_add.scala.html
                  HASH: accf8355e2e12a822d28dc9a76b158d7ff4ab420
                  MATRIX: 1042->0|1377->309|1415->327|1757->642|1804->669|1840->683|2122->938|2170->965|2206->979|2720->1466|2770->1495|2806->1509|3500->2176|3546->2202|3582->2216|4496->3102|4537->3121|4658->3215|4700->3235
                  LINES: 33->1|37->5|37->5|43->11|43->11|43->11|46->14|46->14|46->14|52->20|52->20|52->20|60->28|60->28|60->28|77->45|77->45|78->46|78->46
                  -- GENERATED --
              */
          