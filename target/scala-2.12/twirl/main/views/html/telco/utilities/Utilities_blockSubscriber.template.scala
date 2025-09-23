
package views.html.telco.utilities

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

object Utilities_blockSubscriber extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="accordion-body">
  <div class="card-header-primary card-header-icon">
    <div class="toolbar" style="float: left">
      <button class="btn btn-title">
        """),_display_(/*5.10*/Messages("blockUtilities.blockSubscriber")),format.raw/*5.52*/("""
      """),format.raw/*6.7*/("""</button>
    </div>
    <div class="toolbar" style="float: right">
      <button class="btn px-4 button-light" id="buttonImportBlockSubs" data-bs-toggle="modal" data-bs-target="#importBlockSubsModal">
        """),_display_(/*10.10*/Messages("blockUtilities.loadSubscriberList")),format.raw/*10.55*/("""
      """),format.raw/*11.7*/("""</button>
      <button class="btn px-4 button-light" id="buttonProcessBlockSubs1" onclick="showComfirmBlockSubsModal(1)">
        """),_display_(/*13.10*/Messages("blockUtilities.blockOneWayAction")),format.raw/*13.54*/("""
      """),format.raw/*14.7*/("""</button>
      <button class="btn px-4 button-light" id="buttonProcessBlockSubs2" onclick="showComfirmBlockSubsModal(2)">
      """),_display_(/*16.8*/Messages("blockUtilities.blockTwoWayAction")),format.raw/*16.52*/("""
      """),format.raw/*17.7*/("""</button>
      <button class="btn px-4 button-light" id="buttonImportBlockSubs" onclick="exportResultListSubsBlock()">
      """),_display_(/*19.8*/Messages("common.export")),format.raw/*19.33*/("""
      """),format.raw/*20.7*/("""</button>
    </div>
  </div>
  <div class="card-body mt-3" style="padding-right: 0px;">
    <div class="" id="dataImportBlockSubs" style="float: left; width: 100%;">

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
                  DATE: Mon Sep 22 16:32:55 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/utilities/Utilities_blockSubscriber.scala.html
                  HASH: ce38f99350ed74ccab7f6c8e108d52e3a4604a89
                  MATRIX: 1066->0|1266->174|1328->216|1361->223|1599->434|1665->479|1699->486|1858->618|1923->662|1957->669|2113->799|2178->843|2212->850|2365->977|2411->1002|2445->1009
                  LINES: 33->1|37->5|37->5|38->6|42->10|42->10|43->11|45->13|45->13|46->14|48->16|48->16|49->17|51->19|51->19|52->20
                  -- GENERATED --
              */
          