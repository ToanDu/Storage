
package views.html.telco.subs

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

object Subscriber_formSearch_importSerial extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="importSearchSerialModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
  <span class="modal-title" id="exampleModalLabel">"""),_display_(/*5.53*/Messages("subscriber.modal.import.serial.title")),format.raw/*5.101*/("""</span>
        """),format.raw/*6.132*/("""
      """),format.raw/*7.7*/("""</div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12">
            <div class="row mb-3">
              <span class="col-sm-4 col-form-label">"""),_display_(/*12.54*/Messages("subscriber.modal.import.serial.uploadList")),format.raw/*12.107*/("""</span>
              <div class="col-sm-8">
                <input type="file" id="filesSearchSerial" name="files" style="background-color: #aaa; width: 100%;"/>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*18.54*/Messages("subscriber.modal.import.sampleFile")),format.raw/*18.100*/("""</span>
              <span class="col-sm-3 col-form-label">"""),_display_(/*19.54*/Messages("subscriber.modal.import.serial.sampleName")),format.raw/*19.107*/("""</span>
              <div class="col-sm-5 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="downloadTemplateSearchSerial()"><i class="bx bx-download"></i> """),_display_(/*21.134*/Messages("subscriber.modal.download")),format.raw/*21.171*/("""</a>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*26.85*/Messages("btnCancle")),format.raw/*26.106*/("""</button>
              <button type="button" class="btn btn-red" data-bs-dismiss="modal" onclick="comfirmListSerialImport()">"""),_display_(/*27.118*/Messages("btnComfirm")),format.raw/*27.140*/("""</button>
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
                  DATE: Mon Sep 22 16:32:55 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/subs/Subscriber_formSearch_importSerial.scala.html
                  HASH: 961ce4136c1e1f9e8fcdb86c3907a22c94699143
                  MATRIX: 1070->0|1456->360|1525->408|1569->547|1602->554|1815->740|1890->793|2208->1084|2276->1130|2364->1191|2439->1244|2660->1437|2719->1474|2915->1643|2958->1664|3113->1791|3157->1813
                  LINES: 33->1|37->5|37->5|38->6|39->7|44->12|44->12|50->18|50->18|51->19|51->19|53->21|53->21|58->26|58->26|59->27|59->27
                  -- GENERATED --
              */
          