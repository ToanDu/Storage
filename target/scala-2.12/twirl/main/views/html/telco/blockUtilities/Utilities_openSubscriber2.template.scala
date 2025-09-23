
package views.html.telco.blockUtilities

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

object Utilities_openSubscriber2 extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="accordion-body">
  <div class="card-header-primary card-header-icon">
    <div class="toolbar" style="float: left">
      <button class="btn btn-title">
      """),_display_(/*5.8*/Messages("blockUtilities.unblockTwoWaySubscriber")),format.raw/*5.58*/("""
      """),format.raw/*6.7*/("""</button>
    </div>
    <div class="toolbar" style="float: right">
      <button class="btn px-4 button-light" id="buttonImportOpenSubs" data-bs-toggle="modal" data-bs-target="#importOpenSubsModal2">
      """),_display_(/*10.8*/Messages("blockUtilities.loadSubscriberList")),format.raw/*10.53*/("""
      """),format.raw/*11.7*/("""</button>
      <button class="btn px-4 button-light" id="buttonProcessOpenSubs2" onclick="showComfirmOpenSubsModal2()">
      """),_display_(/*13.8*/Messages("blockUtilities.unblockTwoWayAction")),format.raw/*13.54*/("""
      """),format.raw/*14.7*/("""</button>
      <button class="btn px-4 button-light" id="buttonImportOpenSubs" onclick="exportResultListSubsOpen2()">
      """),_display_(/*16.8*/Messages("Export")),format.raw/*16.26*/("""
      """),format.raw/*17.7*/("""</button>
    </div>
  </div>
  <div class="card-body mt-3" style="padding-right: 0px;">
    <div class="" id="dataImportOpenSubs2" style="float: left; width: 100%;">

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/blockUtilities/Utilities_openSubscriber2.scala.html
                  HASH: 75af908d9f6322e10745de66148796c179513209
                  MATRIX: 1071->0|1268->172|1338->222|1371->229|1605->437|1671->482|1705->489|1859->617|1926->663|1960->670|2112->796|2151->814|2185->821
                  LINES: 33->1|37->5|37->5|38->6|42->10|42->10|43->11|45->13|45->13|46->14|48->16|48->16|49->17
                  -- GENERATED --
              */
          