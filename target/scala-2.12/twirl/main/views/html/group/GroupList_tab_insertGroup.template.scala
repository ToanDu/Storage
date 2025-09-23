
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

object GroupList_tab_insertGroup extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<form action="#" method="POST" id="insertGroupForm">
    <div style="padding: 5px 15px;">
        <div class="form-group" hidden>
            <input id="idInsertGroup" name="id" type="text" class="form-control">
        </div>
    </div>
    <div class="row">
        <label class="col-sm-2 col-form-label">"""),_display_(/*8.49*/Messages("manage.group.name")),format.raw/*8.78*/("""</label>
        <div class="col-sm-7">
            <div class="form-group">
                <input id="nameInsertGroup" name="name" type="text" class="form-control" placeholder="name" maxlength="50">
            </div>
        </div>
    </div>
    <div class="row">
        <label class="col-sm-2 col-form-label">"""),_display_(/*16.49*/Messages("manage.group.address")),format.raw/*16.81*/("""</label>
        <div class="col-sm-7">
            <div class="form-group">
                <input id="addressInsertGroup" name="address" type="text" class="form-control" placeholder="address" maxlength="50">
            </div>
        </div>
    </div>
    <div class="row">
        <label class="col-sm-2 col-form-label">"""),_display_(/*24.49*/Messages("manage.group.email")),format.raw/*24.79*/("""</label>
        <div class="col-sm-7">
            <div class="form-group">
                <input id="emailInsertGroup" name="email" type="text" class="form-control" placeholder="email" maxlength="50">
            </div>
        </div>
    </div>
    <div class="row">
        <label class="col-sm-2 col-form-label">"""),_display_(/*32.49*/Messages("manage.group.phone")),format.raw/*32.79*/("""</label>
        <div class="col-sm-7">
            <div class="form-group">
                <input id="phoneInsertGroup" name="phone" type="text" class="form-control" placeholder="phone" maxlength="13" minlength="9">
            </div>
        </div>
    </div>

    <div class="card-footer ml-auto mr-auto">
        <button onclick="AddChildGroup('')" type="button" class="btn btn-success btn-fill btn-sm"><i class="fa fa-floppy-o" aria-hidden="true"></i> """),_display_(/*41.150*/Messages("btnSave")),format.raw/*41.169*/("""</button>

    </div>
</form>"""))
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList_tab_insertGroup.scala.html
                  HASH: da6d6d20a34b9cf5cc21ffc38facfba7e85fda6e
                  MATRIX: 1056->0|1390->308|1439->337|1782->653|1835->685|2187->1010|2238->1040|2584->1359|2635->1389|3122->1848|3163->1867
                  LINES: 33->1|40->8|40->8|48->16|48->16|56->24|56->24|64->32|64->32|73->41|73->41
                  -- GENERATED --
              */
          