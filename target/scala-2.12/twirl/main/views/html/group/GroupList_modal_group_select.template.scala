
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

object GroupList_modal_group_select extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div id="move-tree-view" class="modal fixed-left fade" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-dialog-aside" role="document">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("Chuyển thiết bị")),format.raw/*5.95*/("""</h5>
      </div>
      <div class="modal-body">
        <form class="row g-3">
          <input type="text" id="idMove" readonly hidden>
          <input type="text" id="groupIdMove" readonly hidden>
          <div class="input-group">
            <span class="input-group-text" onclick=""><i class='bx bx-search-alt'></i></span>
            <input id="search-selectOrgMove" class="search-input form-control border-start-0" placeholder="" maxlength="30">
          </div>
          <hr>
          <div id="tabListOrgMove" style=""></div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" onclick="processMoveUser()" id="buttonMoveUser" style="display: none">"""),_display_(/*20.126*/Messages("btnSave")),format.raw/*20.145*/("""</button>
        <button type="button" class="btn btn-success" onclick="processMoveDevice()" id="buttonMoveDevice">"""),_display_(/*21.108*/Messages("btnSave")),format.raw/*21.127*/("""</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*22.82*/Messages("btnClose")),format.raw/*22.102*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList_modal_group_select.scala.html
                  HASH: 466f3cc1ce0f2db843d2fb7192273bef53378bff
                  MATRIX: 1059->0|1421->336|1468->363|2223->1090|2264->1109|2409->1226|2450->1245|2568->1336|2610->1356
                  LINES: 33->1|37->5|37->5|52->20|52->20|53->21|53->21|54->22|54->22
                  -- GENERATED --
              */
          