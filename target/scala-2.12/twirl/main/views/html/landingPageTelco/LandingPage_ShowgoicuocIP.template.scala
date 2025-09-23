
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

object LandingPage_ShowgoicuocIP extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<div class="modal fade" id="showGioicuocIP" tabindex="-1" aria-hidden="true" style="opacity: 1;overflow-y: auto;left: 362px;>
<div class="modal-dialog modal-xl">
<div class="modal-content" id="theme16">
    <div class="modal-header" style="text-align: center; display: inherit;border-bottom: 0px;">
        <h5 class="modal-title" id="exampleModalLabel" style="font-weight: 700; color: ##44494D;font-size: 24px;line-height: 43px;margin-left: 275px;">"""),_display_(/*6.153*/Messages("landingPageTelco.showip.packageInfo")),format.raw/*6.200*/("""</h5>
        <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
    </div>
    <div class="modal-body">
        <div class="alignItemCenter" style="text-align: center">
            <img src=""""),_display_(/*11.24*/routes/*11.30*/.Assets.versioned("images/landingPageTelco/exchange-rate_1.jpg")),format.raw/*11.94*/("""" width="" class="align-items-lg-center">
        </div>
        <div class="text mt-3" style="text-align: center">
            <div class="description">
                <h4 class="gc-title-1">"""),_display_(/*15.41*/Messages("landingPageTelco.showip.ipAccessTracking")),format.raw/*15.93*/("""</h4>
            </div>
        </div>
        <div class="row" style="border-bottom: 1px solid #e9eaef">
            <div class="col-md-4">
                <p class="pack">"""),_display_(/*20.34*/Messages("landingPageTelco.showip.m2m30ip10gb")),format.raw/*20.81*/("""</p>
                <div class="charge">
                    <p class="mt-3">"""),_display_(/*22.38*/Messages("landingPageTelco.showip.prepaid")),format.raw/*22.81*/("""</p>
                </div>
                <div class="description">
                    <p class="money">"""),_display_(/*25.39*/Messages("landingPageTelco.showip.price30k")),format.raw/*25.83*/("""</p>
                    <p class="fc-other-month">"""),_display_(/*26.48*/Messages("landingPageTelco.showip.currency30days")),format.raw/*26.98*/("""</p>
                </div>
            </div>
            <div class="col-md-8">
                <div class="content-text">
                    <p class="text-content">"""),_display_(/*31.46*/Messages("landingPageTelco.showip.free10gb300mb")),format.raw/*31.95*/("""</p>
                    <p class="text-content">"""),_display_(/*32.46*/Messages("landingPageTelco.showip.freeMonthlyFee")),format.raw/*32.96*/("""</p>
                </div>
            </div>
        </div>
        <div class="row" style="margin-top: 24px;border-bottom: 1px solid #e9eaef;">
            <div class="col-md-4">
                <p class="pack">"""),_display_(/*38.34*/Messages("landingPageTelco.showip.m2m50ip25gb")),format.raw/*38.81*/("""</p>
                <div class="charge">
                    <p class="mt-3">"""),_display_(/*40.38*/Messages("landingPageTelco.showip.prepaid")),format.raw/*40.81*/("""</p>
                </div>
                <div class="description">
                    <p class="money">"""),_display_(/*43.39*/Messages("landingPageTelco.showip.price15k")),format.raw/*43.83*/("""</p>
                    <p class="fc-other-month">"""),_display_(/*44.48*/Messages("landingPageTelco.showip.currency30days")),format.raw/*44.98*/("""</p>
                </div>
            </div>
            <div class="col-md-8">
                <div class="content-text">
                    <p class="text-content">"""),_display_(/*49.46*/Messages("landingPageTelco.showip.free25gb500mb")),format.raw/*49.95*/("""</p>
                    <p class="text-content">"""),_display_(/*50.46*/Messages("landingPageTelco.showip.freeMonthlyFee")),format.raw/*50.96*/("""</p>
                </div>
            </div>
        </div>
        <div class="row" style="margin-top: 24px;border-bottom: 1px solid #e9eaef;">
            <div class="col-md-4">
                <p class="pack">"""),_display_(/*56.34*/Messages("landingPageTelco.showip.m2m70ip50gb")),format.raw/*56.81*/("""</p>
                <div class="charge">
                    <p class="mt-3">"""),_display_(/*58.38*/Messages("landingPageTelco.showip.prepaid")),format.raw/*58.81*/("""</p>
                </div>
                <div class="description">
                    <p class="money">"""),_display_(/*61.39*/Messages("landingPageTelco.showip.price70k")),format.raw/*61.83*/("""</p>
                    <p class="fc-other-month">"""),_display_(/*62.48*/Messages("landingPageTelco.showip.currency30days")),format.raw/*62.98*/("""</p>
                </div>
            </div>
            <div class="col-md-8">
                <div class="content-text">
                    <p class="text-content">"""),_display_(/*67.46*/Messages("landingPageTelco.showip.free50gb1gb")),format.raw/*67.93*/("""</p>
                    <p class="text-content">"""),_display_(/*68.46*/Messages("landingPageTelco.showip.freeMonthlyFee")),format.raw/*68.96*/("""</p>
                </div>
            </div>
        </div>
        <div class="row" style="margin-top: 24px;border-bottom: 1px solid #e9eaef;">
            <div class="col-md-4">
                <p class="pack">"""),_display_(/*74.34*/Messages("landingPageTelco.showip.m2m30ip10gb12m")),format.raw/*74.84*/("""</p>
                <div class="charge">
                    <p class="mt-3">"""),_display_(/*76.38*/Messages("landingPageTelco.showip.prepaid")),format.raw/*76.81*/("""</p>
                </div>
                <div class="description">
                    <p class="money">"""),_display_(/*79.39*/Messages("landingPageTelco.showip.price360k")),format.raw/*79.84*/("""</p>
                    <p class="fc-other-month">"""),_display_(/*80.48*/Messages("landingPageTelco.showip.currency360days")),format.raw/*80.99*/("""</p>
                </div>
            </div>
            <div class="col-md-8">
                <div class="content-text">
                    <p class="text-content">"""),_display_(/*85.46*/Messages("landingPageTelco.showip.free10gb300mb")),format.raw/*85.95*/("""</p>
                    <p class="text-content">"""),_display_(/*86.46*/Messages("landingPageTelco.showip.freeMonthlyFee")),format.raw/*86.96*/("""</p>
                </div>
            </div>
        </div>
        <div class="row" style="margin-top: 24px;border-bottom: 1px solid #e9eaef;">
            <div class="col-md-4">
                <p class="pack">"""),_display_(/*92.34*/Messages("landingPageTelco.showip.m2m50ip25gb12m")),format.raw/*92.84*/("""</p>
                <div class="charge">
                    <p class="mt-3">"""),_display_(/*94.38*/Messages("landingPageTelco.showip.prepaid")),format.raw/*94.81*/("""</p>
                </div>
                <div class="description">
                    <p class="money">"""),_display_(/*97.39*/Messages("landingPageTelco.showip.price600k")),format.raw/*97.84*/("""</p>
                    <p class="fc-other-month">"""),_display_(/*98.48*/Messages("landingPageTelco.showip.currency360days")),format.raw/*98.99*/("""</p>
                </div>
            </div>
            <div class="col-md-8">
                <div class="content-text">
                    <p class="text-content">"""),_display_(/*103.46*/Messages("landingPageTelco.showip.free25gb500mb")),format.raw/*103.95*/("""</p>
                    <p class="text-content">"""),_display_(/*104.46*/Messages("landingPageTelco.showip.freeMonthlyFee")),format.raw/*104.96*/("""</p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <p class="pack">"""),_display_(/*110.34*/Messages("landingPageTelco.showip.m2m70ip50gb12m")),format.raw/*110.84*/("""</p>
                <div class="charge">
                    <p class="mt-3">"""),_display_(/*112.38*/Messages("landingPageTelco.showip.prepaid")),format.raw/*112.81*/("""</p>
                </div>
                <div class="description">
                    <p class="money">"""),_display_(/*115.39*/Messages("landingPageTelco.showip.price840k")),format.raw/*115.84*/("""</p>
                    <p class="fc-other-month">"""),_display_(/*116.48*/Messages("landingPageTelco.showip.currency360days")),format.raw/*116.99*/("""</p>
                </div>
            </div>
            <div class="col-md-8">
                <div class="content-text">
                    <p class="text-content">"""),_display_(/*121.46*/Messages("landingPageTelco.showip.free50gb1gb")),format.raw/*121.93*/("""</p>
                    <p class="text-content">"""),_display_(/*122.46*/Messages("landingPageTelco.showip.freeMonthlyFee")),format.raw/*122.96*/("""</p>
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
                  DATE: Mon Sep 22 18:18:26 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPageTelco/LandingPage_ShowgoicuocIP.scala.html
                  HASH: 400be6c2ec002a8b76cc83c268bb0a77a59ebd65
                  MATRIX: 1067->1|1545->452|1613->499|1860->719|1875->725|1960->789|2181->983|2254->1035|2456->1210|2524->1257|2630->1336|2694->1379|2829->1487|2894->1531|2973->1583|3044->1633|3241->1803|3311->1852|3388->1902|3459->1952|3701->2167|3769->2214|3875->2293|3939->2336|4074->2444|4139->2488|4218->2540|4289->2590|4486->2760|4556->2809|4633->2859|4704->2909|4946->3124|5014->3171|5120->3250|5184->3293|5319->3401|5384->3445|5463->3497|5534->3547|5731->3717|5799->3764|5876->3814|5947->3864|6189->4079|6260->4129|6366->4208|6430->4251|6565->4359|6631->4404|6710->4456|6782->4507|6979->4677|7049->4726|7126->4776|7197->4826|7439->5041|7510->5091|7616->5170|7680->5213|7815->5321|7881->5366|7960->5418|8032->5469|8230->5639|8301->5688|8379->5738|8451->5788|8635->5944|8707->5994|8814->6073|8879->6116|9015->6224|9082->6269|9162->6321|9235->6372|9433->6542|9502->6589|9580->6639|9652->6689
                  LINES: 33->2|37->6|37->6|42->11|42->11|42->11|46->15|46->15|51->20|51->20|53->22|53->22|56->25|56->25|57->26|57->26|62->31|62->31|63->32|63->32|69->38|69->38|71->40|71->40|74->43|74->43|75->44|75->44|80->49|80->49|81->50|81->50|87->56|87->56|89->58|89->58|92->61|92->61|93->62|93->62|98->67|98->67|99->68|99->68|105->74|105->74|107->76|107->76|110->79|110->79|111->80|111->80|116->85|116->85|117->86|117->86|123->92|123->92|125->94|125->94|128->97|128->97|129->98|129->98|134->103|134->103|135->104|135->104|141->110|141->110|143->112|143->112|146->115|146->115|147->116|147->116|152->121|152->121|153->122|153->122
                  -- GENERATED --
              */
          