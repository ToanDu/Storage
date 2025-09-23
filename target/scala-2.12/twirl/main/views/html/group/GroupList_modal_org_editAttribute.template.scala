
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

object GroupList_modal_org_editAttribute extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editAttributeModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("manage.org.editAttr")),format.raw/*5.99*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12">
            <div class="row mb-4">
              <label class="col-sm-4 col-form-label">"""),_display_(/*11.55*/Messages("manage.org.attr.name")),format.raw/*11.87*/("""</label>
              <div class="col-sm-8">
                <input id="nameAttrEdit" name="name" type="text" class="form-control" maxlength="30" autocomplete="off" readonly>
                <br>
                <h7 class="textNote">"""),_display_(/*15.39*/Messages("manage.group.org.30char")),format.raw/*15.74*/("""</h7>
              </div>
            </div>
            <div class="row mb-4" hidden>
              <label class="col-sm-4 col-form-label">"""),_display_(/*19.55*/Messages("manage.org.attr.type")),format.raw/*19.87*/("""</label>
              <div class="col-sm-8">
                <select id="chooseAttrTypeEdit" class="form-select">
                  """),format.raw/*22.81*/("""
                """),format.raw/*23.17*/("""<option value="SCOPE_SERVER" selected>"""),_display_(/*23.56*/Messages("Server")),format.raw/*23.74*/("""</option>
                  """),format.raw/*24.75*/("""
                """),format.raw/*25.17*/("""</select>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-4 col-form-label">"""),_display_(/*29.55*/Messages("manage.org.attr.value")),format.raw/*29.88*/("""</label>
              <div class="col-sm-8">
                <select id="chooseAttrValueEdit" class="form-select">
                  <option value="STR">"""),_display_(/*32.40*/Messages("String")),format.raw/*32.58*/("""</option>
                  <option value="BOOL" >"""),_display_(/*33.42*/Messages("Boolean")),format.raw/*33.61*/("""</option>
                  <option value="LONG" >"""),_display_(/*34.42*/Messages("Long")),format.raw/*34.58*/("""</option>
                  <option value="DBL" >"""),_display_(/*35.41*/Messages("Double")),format.raw/*35.59*/("""</option>
                  <option value="JSON" >"""),_display_(/*36.42*/Messages("Json")),format.raw/*36.58*/("""</option>
                </select>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-4 col-form-label">"""),_display_(/*41.55*/Messages("manage.org.attr.default")),format.raw/*41.90*/("""</label>
              <div class="col-sm-8">
                <input id="chooseAttrDefaultEdit" type="text" class="form-control" maxlength="255" autocomplete="off" required>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-4 col-form-label">"""),_display_(/*47.55*/Messages("manage.org.attr.history")),format.raw/*47.90*/("""</label>
              <div class="col-sm-8">
                <select id="chooseAttrHistoryEdit" class="form-select">
                  <option value="true">"""),_display_(/*50.41*/Messages("Có")),format.raw/*50.55*/("""</option>
                  <option value="false" >"""),_display_(/*51.43*/Messages("Không")),format.raw/*51.60*/("""</option>
                </select>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-danger" onclick="processEditAttribute()" data-bs-dismiss="modal">"""),_display_(/*57.118*/Messages("btnSave")),format.raw/*57.137*/("""</button>
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*58.88*/Messages("btnClose")),format.raw/*58.108*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList_modal_org_editAttribute.scala.html
                  HASH: a04f48f32ba10891aa09bcca3f20bcf837c15f6b
                  MATRIX: 1064->0|1425->335|1476->366|1702->565|1755->597|2017->832|2073->867|2242->1009|2295->1041|2456->1236|2501->1253|2567->1292|2606->1310|2662->1394|2707->1411|2873->1550|2927->1583|3109->1738|3148->1756|3226->1807|3266->1826|3344->1877|3381->1893|3458->1943|3497->1961|3575->2012|3612->2028|3804->2193|3860->2228|4190->2531|4246->2566|4431->2724|4466->2738|4545->2790|4583->2807|4844->3040|4885->3059|5009->3156|5051->3176
                  LINES: 33->1|37->5|37->5|43->11|43->11|47->15|47->15|51->19|51->19|54->22|55->23|55->23|55->23|56->24|57->25|61->29|61->29|64->32|64->32|65->33|65->33|66->34|66->34|67->35|67->35|68->36|68->36|73->41|73->41|79->47|79->47|82->50|82->50|83->51|83->51|89->57|89->57|90->58|90->58
                  -- GENERATED --
              */
          