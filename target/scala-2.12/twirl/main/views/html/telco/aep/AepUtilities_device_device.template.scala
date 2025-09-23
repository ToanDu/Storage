
package views.html.telco.aep

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

object AepUtilities_device_device extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="deviceModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.65*/Messages("Tạo Thiết bị")),format.raw/*5.89*/("""</span>
      </div>
      <div class="modal-body" style="padding-bottom: 0px;">
        <div class="table-responsive mb-3" style="border-radius: 8px;">
          <table class="table table-striped" id="listDeviceCreateWithSerial" style="width: 100%;">
            <thead style="background-color: #FBCCD6;">
              <tr>
                <th>"""),_display_(/*12.22*/Messages("STT")),format.raw/*12.37*/("""</th>
                <th>"""),_display_(/*13.22*/Messages("Thiết bị")),format.raw/*13.42*/("""</th>
                <th>"""),_display_(/*14.22*/Messages("Serial")),format.raw/*14.40*/("""</th>
                <th>"""),_display_(/*15.22*/Messages("Kết quả")),format.raw/*15.41*/("""</th>
              </tr>
            </thead>
            <tbody></tbody>
          </table>
        </div>
      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" onclick="backModalAddTemplate()">"""),_display_(/*24.88*/Messages("btnBack")),format.raw/*24.107*/("""</button>
        <button type="button" class="btn btn-cancle" data-bs-dismiss="modal" onclick="getListSubscriberCmp()">"""),_display_(/*25.112*/Messages("Kết thúc")),format.raw/*25.132*/("""</button>
        <button type="button" class="btn btn-red" onclick="addDeviceWithSerial(0)">"""),_display_(/*26.85*/Messages("btnComfirm")),format.raw/*26.107*/("""</button>
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
                  DATE: Mon Sep 22 16:32:50 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/aep/AepUtilities_device_device.scala.html
                  HASH: 3bd90853196fe36b610d74fbe7a50f7077c7665d
                  MATRIX: 1061->0|1490->403|1534->427|1908->774|1944->789|1998->816|2039->836|2093->863|2132->881|2186->908|2226->927|2496->1170|2537->1189|2686->1310|2728->1330|2849->1424|2893->1446
                  LINES: 33->1|37->5|37->5|44->12|44->12|45->13|45->13|46->14|46->14|47->15|47->15|56->24|56->24|57->25|57->25|58->26|58->26
                  -- GENERATED --
              */
          