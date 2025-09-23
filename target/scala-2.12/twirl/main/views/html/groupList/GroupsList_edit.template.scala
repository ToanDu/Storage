
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

object GroupsList_edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editConfirmModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" id="theme16">
            <div class="modal-header">
                <h5 class="modal-title text-darker" id="exampleModalLabel">"""),_display_(/*5.77*/Messages("group.edit")),format.raw/*5.99*/("""</h5><hr>
            </div>
            <div class="modal-body">
                <form class="row g-3">
                    <div class="col-md-12" hidden>
                        <input id="idGroupEdit" name="id" type="text" class="form-control" maxlength="50" autocomplete="off" required>
                    </div>
                    <div class="col-md-12">
                        <label class="form-label text-darker">"""),_display_(/*13.64*/Messages("manage.group.name")),_display_(/*13.94*/Messages(" *")),format.raw/*13.108*/("""</label>
                        <input id="nameGroupEdit" name="name" type="text" class="form-control" maxlength="50" autocomplete="off" required>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" onclick="postEditNameGroup()" data-bs-dismiss="modal">"""),_display_(/*19.118*/Messages("btnSave")),format.raw/*19.137*/("""</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*20.90*/Messages("btnClose")),format.raw/*20.110*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/groupList/GroupsList_edit.scala.html
                  HASH: 9b663e0b32f9da032cd0f0bb9d0c70e1c8dcfbe5
                  MATRIX: 1050->0|1387->311|1429->333|1881->758|1931->788|1967->802|2369->1176|2410->1195|2536->1294|2578->1314
                  LINES: 33->1|37->5|37->5|45->13|45->13|45->13|51->19|51->19|52->20|52->20
                  -- GENERATED --
              */
          