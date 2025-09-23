
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

object GroupList_modal_group_editGroup extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editGroupModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("group.edit")),format.raw/*5.90*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">

          <div class="col-md-12">
            <div class="row mb-4" hidden>
              <input id="idGroupEdit" type="text" class="form-control" maxlength="30" autocomplete="off" required>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*15.55*/Messages("group.name")),_display_(/*15.78*/Messages(" *")),format.raw/*15.92*/("""</label>
              <div class="col-sm-8">
                <input id="nameGroupEdit" type="text" class="form-control" maxlength="30" autocomplete="off" required>
                <br>
                <h7 class="textNote">"""),_display_(/*19.39*/Messages("manage.group.org.30char")),format.raw/*19.74*/("""</h7>
              </div>
            </div>
            """),format.raw/*22.39*/("""
              """),format.raw/*23.104*/("""
              """),format.raw/*24.41*/("""
                """),format.raw/*25.70*/("""
                  """),format.raw/*26.88*/("""
                  """),format.raw/*27.81*/("""
                  """),format.raw/*28.85*/("""
                  """),format.raw/*29.83*/("""
                """),format.raw/*30.30*/("""
              """),format.raw/*31.25*/("""
            """),format.raw/*32.23*/("""
            """),format.raw/*33.39*/("""
              """),format.raw/*34.114*/("""
              """),format.raw/*35.41*/("""
                """),format.raw/*36.94*/("""
              """),format.raw/*37.25*/("""
            """),format.raw/*38.23*/("""

            """),format.raw/*40.13*/("""<div class="modal-footer">
              <button type="button" class="btn btn-danger" onclick="postEditGroup()" data-bs-dismiss="modal">"""),_display_(/*41.111*/Messages("btnSave")),format.raw/*41.130*/("""</button>
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*42.88*/Messages("btnClose")),format.raw/*42.108*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList_modal_group_editGroup.scala.html
                  HASH: ae8da3655e7b901202ce398d01e86e854c907239
                  MATRIX: 1062->0|1419->331|1461->353|1864->729|1907->752|1942->766|2193->990|2249->1025|2335->1109|2379->1213|2422->1254|2467->1324|2514->1412|2561->1493|2608->1578|2655->1661|2700->1691|2743->1716|2784->1739|2825->1778|2869->1892|2912->1933|2957->2027|3000->2052|3041->2075|3083->2089|3248->2226|3289->2245|3413->2342|3455->2362
                  LINES: 33->1|37->5|37->5|47->15|47->15|47->15|51->19|51->19|54->22|55->23|56->24|57->25|58->26|59->27|60->28|61->29|62->30|63->31|64->32|65->33|66->34|67->35|68->36|69->37|70->38|72->40|73->41|73->41|74->42|74->42
                  -- GENERATED --
              */
          