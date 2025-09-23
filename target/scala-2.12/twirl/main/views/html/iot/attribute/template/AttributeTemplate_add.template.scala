
package views.html.iot.attribute.template

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

object AttributeTemplate_add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

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
                  <option value="SCOPE_SERVER" selected>"""),_display_(/*22.58*/Messages("Server")),format.raw/*22.76*/("""</option>
                </select>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-4 col-form-label">"""),_display_(/*27.55*/Messages("manage.org.attr.value")),format.raw/*27.88*/("""</label>
              <div class="col-sm-8">
                <select id="chooseAttrValueAdd" class="form-select">
                  <option value="STR" selected>"""),_display_(/*30.49*/Messages("String")),format.raw/*30.67*/("""</option>
                  <option value="BOOL" >"""),_display_(/*31.42*/Messages("Boolean")),format.raw/*31.61*/("""</option>
                  <option value="LONG" >"""),_display_(/*32.42*/Messages("Long")),format.raw/*32.58*/("""</option>
                  <option value="DBL" >"""),_display_(/*33.41*/Messages("Double")),format.raw/*33.59*/("""</option>
                  <option value="JSON" >"""),_display_(/*34.42*/Messages("Json")),format.raw/*34.58*/("""</option>
                </select>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-4 col-form-label">"""),_display_(/*39.55*/Messages("manage.org.attr.default")),format.raw/*39.90*/("""</label>
              <div class="col-sm-8">
                <input id="chooseAttrDefaultAdd" type="text" class="form-control" maxlength="255" autocomplete="off" required>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-4 col-form-label">"""),_display_(/*45.55*/Messages("manage.org.attr.history")),format.raw/*45.90*/("""</label>
              <div class="col-sm-8">
                <select id="chooseAttrHistoryAdd" class="form-select">
                  <option value="true" selected>"""),_display_(/*48.50*/Messages("Có")),format.raw/*48.64*/("""</option>
                  <option value="false" >"""),_display_(/*49.43*/Messages("Không")),format.raw/*49.60*/("""</option>
                </select>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-danger" onclick="processAddAttribute()" data-bs-dismiss="modal">"""),_display_(/*55.117*/Messages("btnSave")),format.raw/*55.136*/("""</button>
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*56.88*/Messages("btnClose")),format.raw/*56.108*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/attribute/template/AttributeTemplate_add.scala.html
                  HASH: a63b4cb80e8e8556304cb10b5e2d84725eed36a7
                  MATRIX: 1069->0|1429->334|1479->364|1705->563|1758->595|2019->829|2075->864|2237->999|2290->1031|2488->1202|2527->1220|2719->1385|2773->1418|2963->1581|3002->1599|3080->1650|3120->1669|3198->1720|3235->1736|3312->1786|3351->1804|3429->1855|3466->1871|3658->2036|3714->2071|4043->2373|4099->2408|4292->2574|4327->2588|4406->2640|4444->2657|4704->2889|4745->2908|4869->3005|4911->3025
                  LINES: 33->1|37->5|37->5|43->11|43->11|47->15|47->15|51->19|51->19|54->22|54->22|59->27|59->27|62->30|62->30|63->31|63->31|64->32|64->32|65->33|65->33|66->34|66->34|71->39|71->39|77->45|77->45|80->48|80->48|81->49|81->49|87->55|87->55|88->56|88->56
                  -- GENERATED --
              */
          