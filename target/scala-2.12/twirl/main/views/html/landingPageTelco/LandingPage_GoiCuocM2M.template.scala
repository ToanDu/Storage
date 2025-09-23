
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

object LandingPage_GoiCuocM2M extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="">
    <ul class="nav nav-tabs">
        <li class="nav-item"><a class="nav-link active" data-toggle="tab" onclick=clickTab(1) href="#METERING">"""),_display_(/*3.113*/Messages("landingPageTelco.goicuocm2m.metering")),format.raw/*3.161*/("""</a></li>
        <li class="nav-item"><a class="nav-link" data-toggle="tab" onclick=clickTab(2) href="#TRACKING" style="">"""),_display_(/*4.115*/Messages("landingPageTelco.goicuocm2m.tracking")),format.raw/*4.163*/("""</a></li>
        <li class="nav-item"><a class="nav-link" data-toggle="tab" onclick=clickTab(3) href="#POS" style="">"""),_display_(/*5.110*/Messages("landingPageTelco.goicuocm2m.pos")),format.raw/*5.153*/("""</a></li>
        <li class="nav-item"><a class="nav-link" data-toggle="tab" onclick=clickTab(4) href="#SMART_SPEAKER" style="">"""),_display_(/*6.120*/Messages("landingPageTelco.goicuocm2m.smartSpeaker")),format.raw/*6.172*/("""</a></li>
        <li class="nav-item"><a class="nav-link" data-toggle="tab" onclick=clickTab(5) href="#ADS_SCREEN" style="">"""),_display_(/*7.117*/Messages("landingPageTelco.goicuocm2m.adsScreen")),format.raw/*7.166*/("""</a></li>
        <li class="nav-item"><a class="nav-link" data-toggle="tab" onclick=clickTab(6) href="#CAMERA" style="">"""),_display_(/*8.113*/Messages("landingPageTelco.goicuocm2m.camera")),format.raw/*8.159*/("""</a></li>
        <li class="nav-item"><a class="nav-link" data-toggle="tab" onclick=clickTab(7) href="#CAR" style="">"""),_display_(/*9.110*/Messages("landingPageTelco.goicuocm2m.car")),format.raw/*9.153*/("""</a></li>
        <li class="nav-item"><a class="nav-link" data-toggle="tab" onclick=clickTab(8) href="#SELL_DEVICE" style="">"""),_display_(/*10.118*/Messages("landingPageTelco.goicuocm2m.sellDevice")),format.raw/*10.168*/("""</a></li>
        <li class="nav-item"><a class="nav-link" data-toggle="tab" onclick=clickTab(9) href="#ALL" style="">"""),_display_(/*11.110*/Messages("landingPageTelco.goicuocm2m.all")),format.raw/*11.153*/("""</a></li>
    </ul>
    <div class="tab-content">
        <div id="METERING" class="tab-pane fade active show">
        </div>
        <div id="TRACKING" class="tab-pane fade">
        </div>
        <div id="POS" class="tab-pane fade">
        </div>
        <div id="SMART_SPEAKER" class="tab-pane fade">
        </div>
        <div id="ADS_SCREEN" class="tab-pane fade">
        </div>
        <div id="CAMERA" class="tab-pane fade">
        </div>
        <div id="CAR" class="tab-pane fade">
        </div>
        <div id="SELL_DEVICE" class="tab-pane fade">
        </div>
        <div id="ALL" class="tab-pane fade">
        </div>
    </div>
</div>
"""))
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPageTelco/LandingPage_GoiCuocM2M.scala.html
                  HASH: 0102fa50a9453d82b666a25a0fb8dd37dd764eb8
                  MATRIX: 1064->0|1248->157|1317->205|1468->329|1537->377|1683->496|1747->539|1903->668|1976->720|2129->846|2199->895|2348->1017|2415->1063|2561->1182|2625->1225|2780->1352|2852->1402|2999->1521|3064->1564
                  LINES: 33->1|35->3|35->3|36->4|36->4|37->5|37->5|38->6|38->6|39->7|39->7|40->8|40->8|41->9|41->9|42->10|42->10|43->11|43->11
                  -- GENERATED --
              */
          