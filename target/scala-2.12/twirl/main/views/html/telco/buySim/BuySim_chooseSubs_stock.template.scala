
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

object BuySim_chooseSubs_stock extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="searchBuySubsInStockModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <span class="modal-title" id="exampleModalLabel">"""),_display_(/*5.59*/Messages("subscriber.list.title")),format.raw/*5.92*/("""</span>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12">
            <div class="table-responsive mt-3" id="tableSearchBuySubsInStock"></div>


          </div>
        </div>
        <div class="row justify-content-center mt-3">
          <button type="button" class="btn btn-telco" style="background: #FFFFFF; color: #EA0033; border: 1px solid #EA0033;" data-bs-dismiss="modal">"""),_display_(/*16.152*/Messages("btnCancle")),format.raw/*16.173*/("""</button>
          <button type="button" class="btn btn-telco" onclick="chooseListSubsInStock()" style="background: #EA0033; color: #FFFFFF;">"""),_display_(/*17.135*/Messages("btnComfirm")),format.raw/*17.157*/("""</button>
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
                  DATE: Mon Sep 22 16:32:51 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/buySim/BuySim_chooseSubs_stock.scala.html
                  HASH: 0e11ff8f09a5778e6abc5027c57e7cb8d4d6dafa
                  MATRIX: 1061->0|1455->368|1508->401|1972->837|2015->858|2187->1002|2231->1024
                  LINES: 33->1|37->5|37->5|48->16|48->16|49->17|49->17
                  -- GENERATED --
              */
          