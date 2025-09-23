
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

object AttributeDevice_edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

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
                <input id="chooseAttrTypeEdit" type="text" readonly>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-4 col-form-label">"""),_display_(/*25.55*/Messages("manage.org.attr.value")),format.raw/*25.88*/("""</label>
              <div class="col-sm-8">
                <select id="chooseAttrValueEdit" class="form-select">
                  <option value="STR">"""),_display_(/*28.40*/Messages("String")),format.raw/*28.58*/("""</option>
                  <option value="BOOL" >"""),_display_(/*29.42*/Messages("Boolean")),format.raw/*29.61*/("""</option>
                  <option value="LONG" >"""),_display_(/*30.42*/Messages("Long")),format.raw/*30.58*/("""</option>
                  <option value="DBL" >"""),_display_(/*31.41*/Messages("Double")),format.raw/*31.59*/("""</option>
                  <option value="JSON" >"""),_display_(/*32.42*/Messages("Json")),format.raw/*32.58*/("""</option>
                </select>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-4 col-form-label">"""),_display_(/*37.55*/Messages("manage.org.attr.default")),format.raw/*37.90*/("""</label>
              <div class="col-sm-8">
                <input id="chooseAttrDefaultEdit" type="text" class="form-control" maxlength="255" autocomplete="off" required>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-4 col-form-label">"""),_display_(/*43.55*/Messages("manage.org.attr.history")),format.raw/*43.90*/("""</label>
              <div class="col-sm-8">
                <select id="chooseAttrHistoryEdit" class="form-select">
                  <option value="true">"""),_display_(/*46.41*/Messages("Có")),format.raw/*46.55*/("""</option>
                  <option value="false" >"""),_display_(/*47.43*/Messages("Không")),format.raw/*47.60*/("""</option>
                </select>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-danger" onclick="processEditAttribute()" data-bs-dismiss="modal">"""),_display_(/*53.118*/Messages("btnSave")),format.raw/*53.137*/("""</button>
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*54.88*/Messages("btnClose")),format.raw/*54.108*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/attribute/device/AttributeDevice_edit.scala.html
                  HASH: 2c2a8b0d4867492767661f8d023630ecb1a904a7
                  MATRIX: 1066->0|1427->335|1478->366|1704->565|1757->597|2019->832|2075->867|2244->1009|2297->1041|2568->1285|2622->1318|2804->1473|2843->1491|2921->1542|2961->1561|3039->1612|3076->1628|3153->1678|3192->1696|3270->1747|3307->1763|3499->1928|3555->1963|3885->2266|3941->2301|4126->2459|4161->2473|4240->2525|4278->2542|4539->2775|4580->2794|4704->2891|4746->2911
                  LINES: 33->1|37->5|37->5|43->11|43->11|47->15|47->15|51->19|51->19|57->25|57->25|60->28|60->28|61->29|61->29|62->30|62->30|63->31|63->31|64->32|64->32|69->37|69->37|75->43|75->43|78->46|78->46|79->47|79->47|85->53|85->53|86->54|86->54
                  -- GENERATED --
              */
          