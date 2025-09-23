
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

object GroupsList_update extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div id="updateConfirmModal" class="modal fixed-left fade" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-dialog-aside" role="document">
        <div class="modal-content bg-gradient-blues">

            <div class="modal-header">
                <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*6.76*/Messages("group.updateOrg")),format.raw/*6.103*/("""</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="col-md-12" hidden>
                    <input id="idGroupUpdate" name="id" type="text" class="form-control" maxlength="50" autocomplete="off" required>
                </div>
                <div class="row g-3">
                    <input type="hidden" id="itype" name="itype" value="0" >
                    <input type="hidden" id="orgIdMove" name="groupId" >
                    <div class="input-group">
                        <a class="input-group-text"><i class='bx bx-search'></i></a>
                        <input id="search-selectOrg" class="search-input form-control border-start-0" style="border-radius: 20px" placeholder=" ...Tìm kiếm tổ chức " onfocus="this.value=''">
                    </div>
                    <div id="selectOrganizations" style="overflow: auto"></div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" onclick="postUpdateOrgIdForGroup()" data-bs-dismiss="modal">"""),_display_(/*24.124*/Messages("btnSave")),format.raw/*24.143*/("""</button>
                <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*25.85*/Messages("btnClose")),format.raw/*25.105*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/groupList/GroupsList_update.scala.html
                  HASH: c00e6a88db9d6b1922169a9cb08d6e0442a4c078
                  MATRIX: 1052->0|1401->323|1449->350|2672->1545|2713->1564|2834->1658|2876->1678
                  LINES: 33->1|38->6|38->6|56->24|56->24|57->25|57->25
                  -- GENERATED --
              */
          