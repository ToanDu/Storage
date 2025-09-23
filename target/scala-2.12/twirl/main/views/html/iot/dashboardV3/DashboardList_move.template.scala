
package views.html.iot.dashboardV3

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

object DashboardList_move extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div id="move-tree-view" class="modal fixed-left fade" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-dialog-aside" role="document">
    <div class="modal-content" style="background-color: white">

      <div class="modal-header">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*6.68*/Messages("Gán dashboard vào tổ chức")),format.raw/*6.105*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="panel-body" style="padding: 5px 2px 2px 2px; overflow-y: auto;  background-color: #EAEBEB; height: 100%;" >
          <div style="width: 100%; overflow: auto; height: 100%; padding: 5px;">
            <input type="hidden" id="itype" name="itype" value="0" >
            <input type="hidden" id="idDashboard" name="idDashboard" >
            <input type="hidden" id="orgIdMove" name="orgId" >
            <input type="" id="orgNameMove" name="orgName" style="width:100%; padding: 5px;">
            <div id="tabListOrg" style="overflow: auto; background-color: #EAEBEB; height: 90%;"></div>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" onclick="processMoveDashboardToOrg()">"""),_display_(/*20.94*/Messages("btnSave")),format.raw/*20.113*/("""</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*21.82*/Messages("btnClose")),format.raw/*21.102*/("""</button>
      </div>

    </div>
  </div>
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
                  DATE: Mon Sep 22 16:32:44 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboardV3/DashboardList_move.scala.html
                  HASH: 755a7f4840ea7777e062d6cde5116231d662d6ba
                  MATRIX: 1059->0|1398->313|1456->350|2314->1181|2355->1200|2473->1291|2515->1311
                  LINES: 33->1|38->6|38->6|52->20|52->20|53->21|53->21
                  -- GENERATED --
              */
          