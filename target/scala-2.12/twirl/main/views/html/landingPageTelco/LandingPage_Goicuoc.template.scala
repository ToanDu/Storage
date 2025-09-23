
package views.html.landingPageTelco

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

object LandingPage_Goicuoc extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<div class="modal fade" id="showGioicuoc1" tabindex="-1" aria-hidden="true" style="opacity: 1;overflow-y: auto;">
    <div class="modal-dialog modal-xl">
        <div class="modal-content" id="theme16">
            <div class="modal-header" style="text-align: center; display: inherit;border-bottom: 0px;">
                <h5 class="modal-title" id="exampleModalLabel" style="font-weight: 700; color: ##44494D;font-size: 24px;line-height: 43px;margin-left: 275px;">"""),_display_(/*6.161*/Messages("landingPageTelco.goicuoc.packageInfo")),format.raw/*6.209*/("""</h5>
                <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
            </div>
            <div class="modal-body">
                <div class="alignItemCenter" style="text-align: center">
                    <img src=""""),_display_(/*11.32*/routes/*11.38*/.Assets.versioned("images/landingPageTelco/tracking_1.jpg")),format.raw/*11.97*/("""" width="" class="align-items-lg-center">
                </div>
                <div class="text mt-3" style="text-align: center">
                    <div class="description">
                        <h4 class="gc-title-1">"""),_display_(/*15.49*/Messages("landingPageTelco.goicuoc.journeyMonitoring")),format.raw/*15.103*/("""</h4>
                    </div>
                </div>
                <div class="row" style="border-bottom: 1px solid #e9eaef">
                    <div class="col-md-4">
                        <p class="pack">"""),_display_(/*20.42*/Messages("landingPageTelco.goicuoc.m2m10Package")),format.raw/*20.91*/("""</p>
                        <div class="charge">
                            <p class="mt-3">"""),_display_(/*22.46*/Messages("landingPageTelco.goicuoc.prepaid")),format.raw/*22.90*/("""</p>
                        </div>
                        <div class="description">
                            <p class="money">"""),_display_(/*25.47*/Messages("landingPageTelco.goicuoc.price10k")),format.raw/*25.92*/("""</p>
                            <p class="fc-other-month">"""),_display_(/*26.56*/Messages("landingPageTelco.goicuoc.currency30days")),format.raw/*26.107*/("""</p>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="content-text">
                            <p class="text-content">"""),_display_(/*31.54*/Messages("landingPageTelco.goicuoc.free100mb")),format.raw/*31.100*/("""</p>
                            <p class="text-content">"""),_display_(/*32.54*/Messages("landingPageTelco.goicuoc.freeMonthlyFee")),format.raw/*32.105*/("""</p>
                        </div>
                    </div>
                </div>
                <div class="row" style="margin-top: 24px">
                    <div class="col-md-4">
                        <p class="pack">"""),_display_(/*38.42*/Messages("landingPageTelco.goicuoc.m2m15Package")),format.raw/*38.91*/("""</p>
                        <div class="charge">
                            <p class="mt-3">"""),_display_(/*40.46*/Messages("landingPageTelco.goicuoc.prepaid")),format.raw/*40.90*/("""</p>
                        </div>
                        <div class="description">
                            <p class="money">"""),_display_(/*43.47*/Messages("landingPageTelco.goicuoc.price15k")),format.raw/*43.92*/("""</p>
                            <p class="fc-other-month">"""),_display_(/*44.56*/Messages("landingPageTelco.goicuoc.currency30days")),format.raw/*44.107*/("""</p>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="content-text">
                            <p class="text-content">"""),_display_(/*49.54*/Messages("landingPageTelco.goicuoc.free300mb")),format.raw/*49.100*/("""</p>
                            <p class="text-content">"""),_display_(/*50.54*/Messages("landingPageTelco.goicuoc.freeMonthlyFee")),format.raw/*50.105*/("""</p>
                        </div>
                    </div>
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
                  DATE: Mon Sep 22 17:07:59 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPageTelco/LandingPage_Goicuoc.scala.html
                  HASH: b74f8537b29f28d2157701728f1963c3cc0eade4
                  MATRIX: 1061->1|1555->468|1624->516|1911->776|1926->782|2006->841|2259->1067|2335->1121|2577->1336|2647->1385|2769->1480|2834->1524|2993->1656|3059->1701|3146->1761|3219->1812|3456->2022|3524->2068|3609->2126|3682->2177|3938->2406|4008->2455|4130->2550|4195->2594|4354->2726|4420->2771|4507->2831|4580->2882|4817->3092|4885->3138|4970->3196|5043->3247
                  LINES: 33->2|37->6|37->6|42->11|42->11|42->11|46->15|46->15|51->20|51->20|53->22|53->22|56->25|56->25|57->26|57->26|62->31|62->31|63->32|63->32|69->38|69->38|71->40|71->40|74->43|74->43|75->44|75->44|80->49|80->49|81->50|81->50
                  -- GENERATED --
              */
          