
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

object GroupList_tab_updateGroup extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="" style="padding: 5px 15px;">
    <div class="form-group" hidden>
        <input id="idUpdateGroup" name="id" type="text" class="form-control">
    </div>

    <div class="row">
        <label class="col-sm-2 col-form-label">"""),_display_(/*7.49*/Messages("manage.group.org")),format.raw/*7.77*/("""</label>
        <div class="col-sm-7">
            <div class="form-group">
                <input id="nameUpdateGroup" name="name" type="text" class="form-control" placeholder="name" maxlength="50">
            </div>
        </div>
        <div class="row" style="">
            <div class="ml-auto mr-auto text-center mt-5">
                <button class="btn btn-danger px-5 radius-30" onclick="updateGroup('')" class="btn btn-danger btn-fill btn-sm">
                    <i class="bx bx-check-circle" aria-hidden="true"></i> """),_display_(/*16.76*/Messages("btnSave")),format.raw/*16.95*/("""
                """),format.raw/*17.17*/("""</button>
                <button class="btn btn-danger px-5 radius-30" onclick="setdelGroupid()" data-bs-toggle="modal" data-bs-target="#deleteGroupconfirm">
                    <i class='bx bx-x-circle'></i>"""),_display_(/*19.52*/Messages("btnDelete")),format.raw/*19.73*/("""
                """),format.raw/*20.17*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList_tab_updateGroup.scala.html
                  HASH: ba36c3ba115504ddef30fc5161fa9ed2564b207f
                  MATRIX: 1056->0|1320->238|1368->266|1927->798|1967->817|2012->834|2249->1044|2291->1065|2336->1082
                  LINES: 33->1|39->7|39->7|48->16|48->16|49->17|51->19|51->19|52->20
                  -- GENERATED --
              */
          