
package views.html.telco.buySim

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

object BuySim_finish_detail extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="finishDetailModal" data-bs-backdrop="static" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content" id="theme16" style="align-items: center;">
      <div class="modal-header">
        <label class="col-sm-12 col-form-label title-section-2">"""),_display_(/*5.66*/Messages("detail.title")),format.raw/*5.90*/("""</label>
      </div>


      <div class="modal-body text-darker" style="text-align: center;">
        <div class="row">
          <div class="col-md-12">
            <div class="table-responsive mt-3">
              <table id="tableFinishDetail" class="table table-striped table-bordered" cellspacing='0' width='100%'>
                <thead>
                  <th>"""),_display_(/*15.24*/Messages("STT")),format.raw/*15.39*/("""</th>
                  <th>"""),_display_(/*16.24*/Messages("ISDN")),format.raw/*16.40*/("""</th>
                  <th>"""),_display_(/*17.24*/Messages("buySim.productName")),format.raw/*17.54*/("""</th>
                  <th>"""),_display_(/*18.24*/Messages("buySim.result")),format.raw/*18.49*/("""</th>
                  <th>"""),_display_(/*19.24*/Messages("buySim.reason")),format.raw/*19.49*/("""</th>
                </thead>
                <tbody align="left"></tbody>
              </table>
            </div>
          </div>
        </div>
      </div>

      <div class="modal-footer">
        <a type="button" class="btn btn-telco" onclick="closePopupFinishDetail()" style="background: #EA0033; color: #FFFFFF;">"""),_display_(/*29.129*/Messages("buySim.close")),format.raw/*29.153*/("""</a>
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
                  DATE: Mon Sep 22 16:32:51 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/buySim/BuySim_finish_detail.scala.html
                  HASH: 172ad98c9330fdc705b4e37108235791a1531b88
                  MATRIX: 1058->0|1401->317|1445->341|1839->708|1875->723|1931->752|1968->768|2024->797|2075->827|2131->856|2177->881|2233->910|2279->935|2632->1260|2678->1284
                  LINES: 33->1|37->5|37->5|47->15|47->15|48->16|48->16|49->17|49->17|50->18|50->18|51->19|51->19|61->29|61->29
                  -- GENERATED --
              */
          