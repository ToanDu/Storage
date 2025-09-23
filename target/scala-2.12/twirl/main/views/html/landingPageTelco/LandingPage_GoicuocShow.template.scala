
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

object LandingPage_GoicuocShow extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /*</div>*/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*14.1*/("""<div class="modal fade" id="showGioicuoc" tabindex="-1" aria-hidden="true" style="opacity: 1;overflow-y: auto;">
    <div class="modal-dialog modal-xl">
        <div class="modal-content" id="theme16">
            <div class="modal-header" style="text-align: center; display: inherit;border-bottom: 0px;">
                <h5 class="modal-title" id="exampleModalLabel" style="font-weight: 700; color: ##44494D;font-size: 24px;line-height: 43px;margin-left: 275px;">"""),_display_(/*18.161*/Messages("landingPageTelco.goicuocshow.packageInfo")),format.raw/*18.213*/("""</h5>
                <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
            </div>
            <div class="modal-body">
                <div class="alignItemCenter" style="text-align: center">
                    <img src=""""),_display_(/*23.32*/routes/*23.38*/.Assets.versioned("images/landingPageTelco/medium_1.jpg")),format.raw/*23.95*/("""" width="" class="align-items-lg-center">
                </div>
                <div class="text mt-3" style="text-align: center">
                    <div class="description">
                        <h4 class="gc-title-1">"""),_display_(/*27.49*/Messages("landingPageTelco.goicuocshow.metering")),format.raw/*27.98*/("""</h4>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <p class="pack">"""),_display_(/*32.42*/Messages("landingPageTelco.goicuocshow.nbiot10")),format.raw/*32.90*/("""</p>
                        <div class="charge">
                            <p class="mt-3">"""),_display_(/*34.46*/Messages("landingPageTelco.goicuocshow.postpaid")),format.raw/*34.95*/("""</p>
                        </div>
                        <div class="description">
                            <p class="money">"""),_display_(/*37.47*/Messages("landingPageTelco.goicuocshow.price10k")),format.raw/*37.96*/("""</p>
                            <p class="fc-other-month">"""),_display_(/*38.56*/Messages("landingPageTelco.goicuocshow.currency30days")),format.raw/*38.111*/("""</p>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="content-text">
                            <p class="text-content">"""),_display_(/*43.54*/Messages("landingPageTelco.goicuocshow.freeBandwidth")),format.raw/*43.108*/("""</p>
                            <p class="text-content">"""),_display_(/*44.54*/Messages("landingPageTelco.goicuocshow.freeMonthlyFee")),format.raw/*44.109*/("""</p>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPageTelco/LandingPage_GoicuocShow.scala.html
                  HASH: 624e10270340ef8ec908c74e0c6e829d09df2507
                  MATRIX: 1072->616|1566->1082|1640->1134|1927->1394|1942->1400|2020->1457|2273->1683|2343->1732|2544->1906|2613->1954|2735->2049|2805->2098|2964->2230|3034->2279|3121->2339|3198->2394|3435->2604|3511->2658|3596->2716|3673->2771
                  LINES: 33->14|37->18|37->18|42->23|42->23|42->23|46->27|46->27|51->32|51->32|53->34|53->34|56->37|56->37|57->38|57->38|62->43|62->43|63->44|63->44
                  -- GENERATED --
              */
          