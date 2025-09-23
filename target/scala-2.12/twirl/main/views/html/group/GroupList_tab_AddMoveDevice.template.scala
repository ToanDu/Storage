
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

object GroupList_tab_AddMoveDevice extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="">
    <div class="card" style="height: 36px;background: #EC1B2E;opacity: 0.85;border-radius: 0px 4px 0px 0px; width: 100%">
        <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase;" id="totalDevice">"""),_display_(/*3.148*/Messages("manage.org.device")),format.raw/*3.177*/("""</span>
    </div>
    <div class="body-nest">
        <div id="tabDevice" style="width: 100%;"></div>
        <div class="material-datatables mt-3">
            <input name="page" id="page" value="1" style="display: none">
            <input name="pageSize" id="pageSize" value="15" style="display: none">
            <input name="isResetPage" id="isResetPage" value="false" style="display: none">
            <div class="dataTables_paginate paging_full_numbers" id="pagingTable" style="cursor: pointer;"></div>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList_tab_AddMoveDevice.scala.html
                  HASH: afb44eaa7a7138e8ae7b3a862387010bdcd3cf93
                  MATRIX: 1058->0|1369->284|1419->313
                  LINES: 33->1|35->3|35->3
                  -- GENERATED --
              */
          