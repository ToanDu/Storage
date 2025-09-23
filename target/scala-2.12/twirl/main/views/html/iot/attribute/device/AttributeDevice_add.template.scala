
package views.html.iot.attribute.device

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

object AttributeDevice_add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addAttributeModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("manage.org.addAttr")),format.raw/*5.98*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12">
            <div class="row mb-4">
              <label class="col-sm-4 col-form-label">"""),_display_(/*11.55*/Messages("manage.org.attr.name")),format.raw/*11.87*/("""</label>
              <div class="col-sm-8">
                <input id="nameAttrAdd" name="name" type="text" class="form-control" maxlength="30" autocomplete="off" required>
                <br>
                <h7 class="textNote">"""),_display_(/*15.39*/Messages("manage.group.org.30char")),format.raw/*15.74*/("""</h7>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-4 col-form-label">"""),_display_(/*19.55*/Messages("manage.org.attr.type")),format.raw/*19.87*/("""</label>
              <div class="col-sm-8">
                <select id="chooseAttrTypeAdd" class="form-select">
                  <option value="SCOPE_SHARE" selected>"""),_display_(/*22.57*/Messages("Share")),format.raw/*22.74*/("""</option>
                  <option value="SCOPE_SERVER">"""),_display_(/*23.49*/Messages("Server")),format.raw/*23.67*/("""</option>
                  """),format.raw/*24.75*/("""
                """),format.raw/*25.17*/("""</select>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-4 col-form-label">"""),_display_(/*29.55*/Messages("manage.org.attr.value")),format.raw/*29.88*/("""</label>
              <div class="col-sm-8">
                <select id="chooseAttrValueAdd" class="form-select">
                  <option value="STR" selected>"""),_display_(/*32.49*/Messages("String")),format.raw/*32.67*/("""</option>
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
                <input id="chooseAttrDefaultAdd" type="text" class="form-control" maxlength="255" autocomplete="off" required>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-4 col-form-label">"""),_display_(/*47.55*/Messages("manage.org.attr.history")),format.raw/*47.90*/("""</label>
              <div class="col-sm-8">
                <select id="chooseAttrHistoryAdd" class="form-select">
                  <option value="true" selected>"""),_display_(/*50.50*/Messages("Có")),format.raw/*50.64*/("""</option>
                  <option value="false" >"""),_display_(/*51.43*/Messages("Không")),format.raw/*51.60*/("""</option>
                </select>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-danger" onclick="processAddAttribute()" data-bs-dismiss="modal">"""),_display_(/*57.117*/Messages("btnSave")),format.raw/*57.136*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/attribute/device/AttributeDevice_add.scala.html
                  HASH: 55a9aac9a9cac9f6b4cffadf0e57528652f1439c
                  MATRIX: 1065->0|1425->334|1475->364|1701->563|1754->595|2015->829|2071->864|2233->999|2286->1031|2483->1201|2521->1218|2606->1276|2645->1294|2701->1378|2746->1395|2912->1534|2966->1567|3156->1730|3195->1748|3273->1799|3313->1818|3391->1869|3428->1885|3505->1935|3544->1953|3622->2004|3659->2020|3851->2185|3907->2220|4236->2522|4292->2557|4485->2723|4520->2737|4599->2789|4637->2806|4897->3038|4938->3057|5062->3154|5104->3174
                  LINES: 33->1|37->5|37->5|43->11|43->11|47->15|47->15|51->19|51->19|54->22|54->22|55->23|55->23|56->24|57->25|61->29|61->29|64->32|64->32|65->33|65->33|66->34|66->34|67->35|67->35|68->36|68->36|73->41|73->41|79->47|79->47|82->50|82->50|83->51|83->51|89->57|89->57|90->58|90->58
                  -- GENERATED --
              */
          