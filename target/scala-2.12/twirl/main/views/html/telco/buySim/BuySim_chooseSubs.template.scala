
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

object BuySim_chooseSubs extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-lg-9 col-md-8" id="tabChooseSubsForPackdata">

  <div class="row">
    <div class="col-md-12 m-t-4">
      <span class="display-4 title-section-1">"""),_display_(/*5.48*/Messages("buySim.chooseSubscriberForPlan")),format.raw/*5.90*/("""</span>
    </div>
    <div class="col-md-12 mt-3">
      <div class="row m-b-3">
        <div class="col-sm-5">
          <input class="form-check-input" name="inlineRadio_1" type="radio" id="" onclick="getConnectSubscriberChoose(1)"><label class="form-check-label" for="">"""),_display_(/*10.163*/Messages("buySim.chooseSubscriber")),format.raw/*10.198*/("""</label>
        </div>
        <div class="col-sm-7">
          <input class="form-check-input" name="inlineRadio_1" type="radio" id="" onclick="getConnectSubscriberRamdom(1)" checked><label class="form-check-label" for="">"""),_display_(/*13.171*/Messages("buySim.randomSubscriber")),format.raw/*13.206*/("""</label>
        </div>
      </div>
    </div>
    <div class="col-md-12 mt-3">
      <div class="card-body">
        <div id="tabChooseSubsRamdom_1" style="display: none">
          <div class="row">
            <label class="col-sm-3 col-form-label title-section-2" style="text-align: left">"""),_display_(/*21.94*/Messages("buySim.subscribersNeeded")),format.raw/*21.130*/("""</label>
            <div class="col-sm-4">
              <input class="form-control countSubscriberBuy" id="countSubscriberBuy_1" type="number" readonly>
            </div>
          </div>
        </div>

        <div id="tabChooseSubsSearch_1" style="display: none">
          <div class="row">
            <label class="col-sm-3 col-form-label title-section-2" style="text-align: left">"""),_display_(/*30.94*/Messages("buySim.searchSubscriber")),format.raw/*30.129*/("""</label>
            <div class="col-sm-4">
              <input class="form-control" id="textSearchChooseSubs_1" type="number" onchange="" placeholder=""""),_display_(/*32.111*/Messages("buySim.searchPlaceholder")),format.raw/*32.147*/("""" onKeyPress="if(this.value.length==15) return false;">
            </div>
            <div class="col-sm-3">
              <button type="button" class="btn btn-search float-start" onclick="searchSubscriberByStock(1)" style="background: #FFFFFF; color: #EA0033; border: 1px solid #EA0033;">"""),_display_(/*35.182*/Messages("buySim.search")),format.raw/*35.207*/("""</button>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="table-responsive mt-3" id="tableBuySubscriber_1"></div>
        </div>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/buySim/BuySim_chooseSubs.scala.html
                  HASH: 5f8f3439abe46ab6ba8e1d8058d2ac3c69ce00d5
                  MATRIX: 1055->0|1245->164|1307->206|1610->481|1667->516|1920->741|1977->776|2299->1071|2357->1107|2775->1498|2832->1533|3014->1687|3072->1723|3391->2014|3438->2039
                  LINES: 33->1|37->5|37->5|42->10|42->10|45->13|45->13|53->21|53->21|62->30|62->30|64->32|64->32|67->35|67->35
                  -- GENERATED --
              */
          