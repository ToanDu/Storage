
package views.html.roles

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

object Role_edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<form>
    <div id="editModal" class="modal fixed-left fade" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-dialog-aside" role="document" style="width: 40%">
            <div class="modal-content" id="theme16">
                <div class="modal-header">
                    <h5 class="modal-title text-darker" id="exampleModalLabel">"""),_display_(/*7.81*/Messages("role.editRole")),format.raw/*7.106*/("""</h5>
                    <hr>
                </div>
                <div class="modal-body">
                    <form class="row g-3">
                        <input type="hidden" id="roleIdEdit">
                        <div class="col-md-12">
                            <label class="form-label text-darker">"""),_display_(/*14.68*/Messages("role.name")),_display_(/*14.90*/Messages(" *")),format.raw/*14.104*/("""</label>
                            <input id="roleNameEdit" name="name" type="text" class="form-control" maxlength="50" autocomplete="off" required>
                        </div><hr>

                        <div class="col-md-12">
                            <label class="form-label text-darker">"""),_display_(/*19.68*/Messages("role.resources")),_display_(/*19.95*/Messages(" *")),format.raw/*19.109*/("""</label>
                            <div id="resourceListEdit">

                            </div>
                            <div style="text-align: center;" class="row">
                                <i id="addMoreEdit" style="font-size: 50px;cursor: pointer;" class="bx bxs-plus-circle"></i>
                            </div>
                            <hr>

                        </div>



                    </form>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" onclick="updateRole()" data-bs-dismiss="modal">"""),_display_(/*36.115*/Messages("btnSave")),format.raw/*36.134*/("""</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*37.94*/Messages("btnClose")),format.raw/*37.114*/("""</button>
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
                  DATE: Mon Sep 22 16:32:49 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/roles/Role_edit.scala.html
                  HASH: 04aecfd6dadee85b44d92de73b644b9d6fc0f7b6
                  MATRIX: 1040->1|1421->356|1467->381|1809->696|1851->718|1887->732|2216->1034|2263->1061|2299->1075|2939->1687|2980->1706|3110->1809|3152->1829
                  LINES: 33->2|38->7|38->7|45->14|45->14|45->14|50->19|50->19|50->19|67->36|67->36|68->37|68->37
                  -- GENERATED --
              */
          