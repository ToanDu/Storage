
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

object GroupList_modal_group_add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addGroupModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("group.addNew")),format.raw/*5.92*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">

          <div class="col-md-12">
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*12.55*/Messages("group.name")),_display_(/*12.78*/Messages(" *")),format.raw/*12.92*/("""</label>
              <div class="col-sm-8">
                <input id="nameGroupNew" type="text" class="form-control" maxlength="30" autocomplete="off" required>
                <br>
                <h7 class="textNote">"""),_display_(/*16.39*/Messages("manage.group.org.30char")),format.raw/*16.74*/("""</h7>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*20.55*/Messages("group.type")),_display_(/*20.78*/Messages(" *")),format.raw/*20.92*/("""</label>
              <div class="col-sm-8">
                <select id="entityGroupAdd" class="form-select">
                  <option value="ORGANIZATION">"""),_display_(/*23.49*/Messages("group.type.org")),format.raw/*23.75*/("""</option>
                  <option value="USER">"""),_display_(/*24.41*/Messages("group.type.user")),format.raw/*24.68*/("""</option>
                  <option value="DEVICE">"""),_display_(/*25.43*/Messages("group.type.device")),format.raw/*25.72*/("""</option>
                  <option value="EVENT">"""),_display_(/*26.42*/Messages("group.type.event")),format.raw/*26.70*/("""</option>
                </select>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*31.55*/Messages("manage.group.content")),_display_(/*31.88*/Messages(" *")),format.raw/*31.102*/("""</label>
              <div class="col-sm-8">
                <textarea class="form-control" id="" placeholder="" rows="10"></textarea>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-danger" onclick="postAddNewGroup()" data-bs-dismiss="modal">"""),_display_(/*38.113*/Messages("btnSave")),format.raw/*38.132*/("""</button>
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*39.88*/Messages("btnClose")),format.raw/*39.108*/("""</button>
            </div>
          </div>


        </div>
      </div>
    </div>
  </div> <!-- modal-bialog .// -->
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList_modal_group_add.scala.html
                  HASH: a035b411758842b77e7ee57182bd0f50ae147b1c
                  MATRIX: 1056->0|1412->330|1456->354|1683->554|1726->577|1761->591|2011->814|2067->849|2229->984|2272->1007|2307->1021|2493->1180|2540->1206|2617->1256|2665->1283|2744->1335|2794->1364|2872->1415|2921->1443|3113->1608|3166->1641|3202->1655|3558->1983|3599->2002|3723->2099|3765->2119
                  LINES: 33->1|37->5|37->5|44->12|44->12|44->12|48->16|48->16|52->20|52->20|52->20|55->23|55->23|56->24|56->24|57->25|57->25|58->26|58->26|63->31|63->31|63->31|70->38|70->38|71->39|71->39
                  -- GENERATED --
              */
          