
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

object GroupList_modal_user_addUser extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<form>
  <div class="modal fade" id="groupAdduser" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content" id="theme16">
        <div class="modal-header">
          <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*6.70*/Messages("manage.group.user.new")),format.raw/*6.103*/("""</h5>
        </div>
        <div class="modal-body">
          <form class="row g-3">
            <div class="col-md-12">

              <div class="row mb-4">
                <label class="col-sm-3 col-form-label">"""),_display_(/*13.57*/Messages("manage.user.email")),_display_(/*13.87*/Messages(" *")),format.raw/*13.101*/("""</label>
                <div class="col-sm-8">
                  <input type="text" id="emailAddUser" class="form-control" name="email" type="email" maxlength="50" autocomplete="off" required>
                  <br>
                  <h7 class="textNote">"""),_display_(/*17.41*/Messages("manage.group.org.30char")),format.raw/*17.76*/("""</h7>
                </div>
              </div>

              <div class="row mb-4">
                <label class="col-sm-3 col-form-label">"""),_display_(/*22.57*/Messages("manage.group.tructhuoc")),_display_(/*22.92*/Messages(" *")),format.raw/*22.106*/("""</label>
                <div class="col-sm-8">
                  <select id="chooseGroupUserAdd" class="form-select">
                    <option selected disabled>"""),_display_(/*25.48*/Messages("manage.group.tructhuoc")),format.raw/*25.82*/("""</option>
                  </select>
                </div>
              </div>

              <div class="row mb-4">
                <label class="col-sm-3 col-form-label">"""),_display_(/*31.57*/Messages("role.title")),_display_(/*31.80*/Messages(" *")),format.raw/*31.94*/("""</label>
                <div class="col-sm-8">
                  <select id="chooseRoleUserAdd" class="form-select">
                    <option selected disabled>"""),_display_(/*34.48*/Messages("role.title")),format.raw/*34.70*/("""</option>
                  </select>
                </div>
              </div>

              <div class="row mb-4">
                <label class="col-sm-3 col-form-label">"""),_display_(/*40.57*/Messages("login.Password")),_display_(/*40.84*/Messages(" *")),format.raw/*40.98*/("""</label>
                <div class="col-sm-8">
                  <div class="input-group" id="show_hide_password">
                    <input type="password" name="password" class="form-control border-end-0" id="inputChoosePassword" required>
                    <a id="iconHidePass" onclick="showPassword()" class="input-group-text"><i class='bx bx-hide'></i></a>
                  </div>
                  <br>
                  <h7>"""),_display_(/*47.24*/Messages("manage.group.org.pass")),format.raw/*47.57*/("""</h7>
                </div>
              </div>

              <div class="row mb-4">
                <label class="col-sm-3 col-form-label">"""),_display_(/*52.57*/Messages("login.RePassword")),_display_(/*52.86*/Messages(" *")),format.raw/*52.100*/("""</label>
                <div class="col-sm-8">
                  <div class="input-group" id="show_hide_password">
                    <input type="password" name="passwordRepeat" class="form-control border-end-0" id="inputChooseRePassword" required>
                    <a id="iconHideRePass" onclick="showRePassword()" class="input-group-text"><i class='bx bx-hide'></i></a>
                  </div>
                </div>
              </div>


            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" onclick="processAddUser()" data-bs-dismiss="modal">"""),_display_(/*66.108*/Messages("btnSave")),format.raw/*66.127*/("""</button>
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*67.84*/Messages("btnClose")),format.raw/*67.104*/("""</button>
        </div>
      </div>
    </div> <!-- modal-bialog .// -->
  </div>
</form>
"""))
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList_modal_user_addUser.scala.html
                  HASH: 1e28d3c185e081e67176eaf27bcc65803ea375c9
                  MATRIX: 1059->0|1388->303|1442->336|1686->553|1736->583|1772->597|2056->854|2112->889|2283->1033|2338->1068|2374->1082|2567->1248|2622->1282|2825->1458|2868->1481|2903->1495|3095->1660|3138->1682|3341->1858|3388->1885|3423->1899|3887->2336|3941->2369|4112->2513|4161->2542|4197->2556|4868->3199|4909->3218|5029->3311|5071->3331
                  LINES: 33->1|38->6|38->6|45->13|45->13|45->13|49->17|49->17|54->22|54->22|54->22|57->25|57->25|63->31|63->31|63->31|66->34|66->34|72->40|72->40|72->40|79->47|79->47|84->52|84->52|84->52|98->66|98->66|99->67|99->67
                  -- GENERATED --
              */
          