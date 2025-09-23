
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

object BuySim_oderSim extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class=" features-1" style="padding-bottom: 0px;">
  <div class="col-md-12">
    <div class="main-content ">
      <div class="row justify-content-center">
        <div class="col-md-11 text-center">
          <div class="step-container py-4 my-2" data-group-id="orderSim">
            <div class="step active">
              <div class="circle">1</div>
              <span class="fw-bold step-title">"""),_display_(/*9.49*/Messages("step.customerInfo")),format.raw/*9.78*/("""</span>
            </div>
            <div class="arrow"><i class='bx bx-chevron-right'></i></div>
            <div class="step ">
              <div class="circle">2</div>
              <span class="fw-bold step-title">"""),_display_(/*14.49*/Messages("step.selectSimAndPlan")),format.raw/*14.82*/("""</span>
            </div>
            <div class="arrow"><i class='bx bx-chevron-right'></i></div>
            <div class="step ">
              <div class="circle">3</div>
              <span class="fw-bold step-title">"""),_display_(/*19.49*/Messages("step.confirmOrder")),format.raw/*19.78*/("""</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<div class="section features-1">
  <div class="col-lg-12 text-center">
    <div class="main-content">

      <div class="row step-content justify-content-center" id="cardSection">
          """),_display_(/*33.12*/views/*33.17*/.html.telco.buySim.BuySim_infoCustomer()),format.raw/*33.57*/("""
  
          """),format.raw/*35.11*/("""<div class="col-lg-9 col-md-8 mt-5">
              <button
                  type="button"
                  class="btn btn-telco"
                  value="1"
                  onclick="nextProcess(this, 'orderSim')"
                  style="background: #EA0033; color: #FFFFFF;">
                  """),_display_(/*42.20*/Messages("nav.continue")),format.raw/*42.44*/("""
              """),format.raw/*43.15*/("""</button>
          </div>
      </div>
  
      <div class="row step-content justify-content-center" style="display: none;">
          """),_display_(/*48.12*/views/*48.17*/.html.telco.buySim.BuySim_packData()),format.raw/*48.53*/("""
  
          """),format.raw/*50.11*/("""<div class="col-lg-9 col-md-8 mt-3">
              <button
                  type="button"
                  class="btn btn-telco"
                  onclick="backProcess(this, 'orderSim')"
                  style="background: #FFFFFF; color: #EA0033; border: 1px solid #EA0033;">
                  """),_display_(/*56.20*/Messages("nav.back")),format.raw/*56.40*/("""
              """),format.raw/*57.15*/("""</button>
  
              <button
                  type="button"
                  class="btn btn-telco"
                  value="2"
                  onclick="nextProcess(this, 'orderSim')"
                  style="background: #EA0033; color: #FFFFFF;">
                  """),_display_(/*65.20*/Messages("nav.continue")),format.raw/*65.44*/("""
              """),format.raw/*66.15*/("""</button>
          </div>
      </div>
  
      <div class="row step-content justify-content-center" style="display: none;">
          """),_display_(/*71.12*/views/*71.17*/.html.telco.buySim.BuySim_comfirmOrder()),format.raw/*71.57*/("""
  
          """),format.raw/*73.11*/("""<div class="col-lg-9 col-md-8 mt-3">
              <button
                  type="button"
                  class="btn btn-telco"
                  onclick="backProcess(this, 'orderSim')"
                  style="background: #FFFFFF; color: #EA0033; border: 1px solid #EA0033;">
                  """),_display_(/*79.20*/Messages("nav.back")),format.raw/*79.40*/("""
              """),format.raw/*80.15*/("""</button>
  
              <button
                  type="button"
                  class="btn btn-telco"
                  id="buttonCommfirmBuySim"
                  value="3"
                  onclick="nextProcess(this, 'orderSim')"
                  style="background: #EA0033; color: #FFFFFF;"
                  disabled>
                  """),_display_(/*90.20*/Messages("nav.confirm")),format.raw/*90.43*/("""
              """),format.raw/*91.15*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/buySim/BuySim_oderSim.scala.html
                  HASH: 68c1c1fa18fbe7a9b0648230311d95c446a59b7d
                  MATRIX: 1052->0|1484->406|1533->435|1782->657|1836->690|2085->912|2135->941|2453->1232|2467->1237|2528->1277|2570->1291|2897->1591|2942->1615|2985->1630|3149->1767|3163->1772|3220->1808|3262->1822|3588->2121|3629->2141|3672->2156|3975->2432|4020->2456|4063->2471|4227->2608|4241->2613|4302->2653|4344->2667|4670->2966|4711->2986|4754->3001|5128->3348|5172->3371|5215->3386
                  LINES: 33->1|41->9|41->9|46->14|46->14|51->19|51->19|65->33|65->33|65->33|67->35|74->42|74->42|75->43|80->48|80->48|80->48|82->50|88->56|88->56|89->57|97->65|97->65|98->66|103->71|103->71|103->71|105->73|111->79|111->79|112->80|122->90|122->90|123->91
                  -- GENERATED --
              */
          