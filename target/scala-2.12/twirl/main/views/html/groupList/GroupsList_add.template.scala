
package views.html.groupList

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

object GroupsList_add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addConfirmModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" id="theme16">
            <div class="modal-header">
                <h5 class="modal-title text-darker" id="exampleModalLabel">"""),_display_(/*5.77*/Messages("manage.group.addNew")),format.raw/*5.108*/("""</h5><hr>
            </div>
            <div class="modal-body">
                <form class="row g-3">
                    <div class="col-md-6">
                        <label class="form-label text-darker">"""),_display_(/*10.64*/Messages("manage.group.name")),_display_(/*10.94*/Messages(" *")),format.raw/*10.108*/("""</label>
                        <input id="nameGroupNew" name="name" type="text" class="form-control" maxlength="50" autocomplete="off" required>
                    </div>
                    <div class="col-md-6">
                        <input id="organizationAdd" name="name" type="text" class="form-control" maxlength="50" autocomplete="off" hidden>
                        <label class="form-label text-darker">"""),_display_(/*15.64*/Messages("manage.group.org")),_display_(/*15.93*/Messages(" *")),format.raw/*15.107*/("""</label>
                        <div class="ms-9">
                            <input type="hidden" id="itype" name="itype" value="0" >
                            <input type="hidden" id="orgIdMoveAdd">
                            <div class="input-group">
                                <a class="input-group-text"><i class='bx bx-search'></i></a>
                                <input id="search-selectOrgAdd"  class="search-input form-control border-start-0" placeholder="...Tìm kiếm tổ chức" maxlength="50">
                            </div>

                            <hr>
                            <div id="selectOrganizationsAdd" style="overflow: auto"></div>
                        </div>
                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" onclick="postCreateNewGroup()" data-bs-dismiss="modal">"""),_display_(/*32.119*/Messages("btnSave")),format.raw/*32.138*/("""</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*33.90*/Messages("btnClose")),format.raw/*33.110*/("""</button>
            </div>
        </div>
    </div> <!-- modal-bialog .// -->
</div>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/groupList/GroupsList_add.scala.html
                  HASH: 177993cd566ab0ed7cdad0dc9e3fad6e26d9a0bf
                  MATRIX: 1049->0|1385->310|1437->341|1675->552|1725->582|1761->596|2207->1015|2256->1044|2292->1058|3255->1993|3296->2012|3422->2111|3464->2131
                  LINES: 33->1|37->5|37->5|42->10|42->10|42->10|47->15|47->15|47->15|64->32|64->32|65->33|65->33
                  -- GENERATED --
              */
          