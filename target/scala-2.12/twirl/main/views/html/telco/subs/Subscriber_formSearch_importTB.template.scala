
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

object Subscriber_formSearch_importTB extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="importSearchSubsModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
  <span class="modal-title" id="exampleModalLabel">"""),_display_(/*5.53*/Messages("subscriber.modal.import.subs.title")),format.raw/*5.99*/("""</span>
        """),format.raw/*6.132*/("""
      """),format.raw/*7.7*/("""</div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12">
            <div class="row mb-3">
              <span class="col-sm-4 col-form-label">"""),_display_(/*12.54*/Messages("subscriber.modal.import.subs.uploadList")),format.raw/*12.105*/("""</span>
              <div class="col-sm-8">
                <input type="file" id="filesSearchSubs" name="files" style="background-color: #aaa; width: 100%;"/>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*18.54*/Messages("subscriber.modal.import.sampleFile")),format.raw/*18.100*/("""</span>
              <span class="col-sm-3 col-form-label">"""),_display_(/*19.54*/Messages("subscriber.modal.import.subs.sampleName")),format.raw/*19.105*/("""</span>
              <div class="col-sm-5 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="downloadTemplateSearchSubs()"><i class="bx bx-download"></i> """),_display_(/*21.132*/Messages("subscriber.modal.download")),format.raw/*21.169*/("""</a>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*26.85*/Messages("btnCancle")),format.raw/*26.106*/("""</button>
              <button type="button" class="btn btn-red" data-bs-dismiss="modal" onclick="comfirmListSubsImport()">"""),_display_(/*27.116*/Messages("btnComfirm")),format.raw/*27.138*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/subs/Subscriber_formSearch_importTB.scala.html
                  HASH: 36f75c4a6af07da2ff06376fd060e17209f9853e
                  MATRIX: 1066->0|1450->358|1516->404|1560->543|1593->550|1806->736|1879->787|2195->1076|2263->1122|2351->1183|2424->1234|2643->1425|2702->1462|2898->1631|2941->1652|3094->1777|3138->1799
                  LINES: 33->1|37->5|37->5|38->6|39->7|44->12|44->12|50->18|50->18|51->19|51->19|53->21|53->21|58->26|58->26|59->27|59->27
                  -- GENERATED --
              */
          