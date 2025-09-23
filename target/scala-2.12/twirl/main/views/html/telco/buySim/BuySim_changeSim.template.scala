
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

object BuySim_changeSim extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class=" features-1" style="padding-bottom: 0px;">
    <div class="col-md-12">
      <div class="main-content ">
        <div class="row justify-content-center">
          <div class="col-md-11 text-center">
            <div class="step-container py-4 my-2" data-group-id="changeSim">
              <div class="step active">
                <div class="circle">1</div>
                <span class="fw-bold step-title">"""),_display_(/*9.51*/Messages("step.customerInfo")),format.raw/*9.80*/("""</span>
              </div>
              <div class="arrow"><i class='bx bx-chevron-right'></i></div>
              <div class="step ">
                <div class="circle">2</div>
                <span class="fw-bold step-title">"""),_display_(/*14.51*/Messages("step.subscriberInfo")),format.raw/*14.82*/("""</span>
              </div>
              <div class="arrow"><i class='bx bx-chevron-right'></i></div>
              <div class="step ">
                <div class="circle">3</div>
                <span class="fw-bold step-title">"""),_display_(/*19.51*/Messages("step.confirmChangeSim")),format.raw/*19.84*/("""</span>
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
            """),_display_(/*33.14*/views/*33.19*/.html.telco.buySim.BuySim_infoCustomerChangeSim()),format.raw/*33.68*/("""

            """),format.raw/*35.13*/("""<div class="col-lg-9 col-md-8 mt-5">
                <button type="button" 
                        class="btn btn-telco" 
                        onclick="nextProcess(this, 'changeSim')" 
                        value="1"
                        style="background: #EA0033; color: #FFFFFF;">
                    """),_display_(/*41.22*/Messages("nav.continue")),format.raw/*41.46*/("""
                """),format.raw/*42.17*/("""</button>
            </div>
        </div>
      
        <div class="row step-content justify-content-center" style="display: none;">
            """),_display_(/*47.14*/views/*47.19*/.html.telco.buySim.BuySim_SubsInfor()),format.raw/*47.56*/("""
            
            """),format.raw/*49.13*/("""<div class="col-lg-9 col-md-8 mt-3">
                <button type="button" 
                        class="btn btn-telco" 
                        onclick="backProcess(this, 'changeSim')" 
                        style="background: #FFFFFF; color: #EA0033; border: 1px solid #EA0033;">
                    """),_display_(/*54.22*/Messages("nav.back")),format.raw/*54.42*/("""
                """),format.raw/*55.17*/("""</button>

                <button type="button" 
                        class="btn btn-telco" 
                        value="2" 
                        style="background: #EA0033; color: #FFFFFF;" 
                        disabled 
                        id="checkChangeInformation" 
                        onclick="nextProcess(this, 'changeSim')">
                    """),_display_(/*64.22*/Messages("nav.continue")),format.raw/*64.46*/("""
                """),format.raw/*65.17*/("""</button>
            </div>
        </div>
      
        <div class="row step-content justify-content-center" style="display: none;">
            """),_display_(/*70.14*/views/*70.19*/.html.telco.buySim.BuySim_confirmChangeSim()),format.raw/*70.63*/("""

            """),format.raw/*72.13*/("""<div class="col-lg-9 col-md-8 mt-3">
                <button type="button" 
                        class="btn btn-telco" 
                        onclick="backProcess(this, 'changeSim')" 
                        style="background: #FFFFFF; color: #EA0033; border: 1px solid #EA0033;">
                    """),_display_(/*77.22*/Messages("nav.back")),format.raw/*77.42*/("""
                """),format.raw/*78.17*/("""</button>

                <button type="button" 
                        class="btn btn-telco" 
                        value="3" 
                        id="buttonCommfirmChangeSim" 
                        onclick="nextProcess(this, 'changeSim')" 
                        style="background: #EA0033; color: #FFFFFF;">
                    """),_display_(/*86.22*/Messages("nav.confirm")),format.raw/*86.45*/("""
                """),format.raw/*87.17*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/buySim/BuySim_changeSim.scala.html
                  HASH: c947f657dc76a03dd58899d2176c1ac554ca8f0f
                  MATRIX: 1054->0|1503->423|1552->452|1811->684|1863->715|2122->947|2176->980|2522->1299|2536->1304|2606->1353|2648->1367|2989->1681|3034->1705|3079->1722|3255->1871|3269->1876|3327->1913|3381->1939|3715->2246|3756->2266|3801->2283|4204->2659|4249->2683|4294->2700|4470->2849|4484->2854|4549->2898|4591->2912|4925->3219|4966->3239|5011->3256|5381->3599|5425->3622|5470->3639
                  LINES: 33->1|41->9|41->9|46->14|46->14|51->19|51->19|65->33|65->33|65->33|67->35|73->41|73->41|74->42|79->47|79->47|79->47|81->49|86->54|86->54|87->55|96->64|96->64|97->65|102->70|102->70|102->70|104->72|109->77|109->77|110->78|118->86|118->86|119->87
                  -- GENERATED --
              */
          