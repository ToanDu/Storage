
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

object Utilities_openSubscriber extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="accordion-body">
  <div class="card-header-primary card-header-icon">
    <div class="toolbar" style="float: left">
      <button class="btn btn-title">
      """),_display_(/*5.8*/Messages("blockUtilities.unblockOneWaySubscriber")),format.raw/*5.58*/("""
      """),format.raw/*6.7*/("""</button>
    </div>
    <div class="toolbar" style="float: right">
      <button class="btn px-4 button-light" id="buttonImportOpenSubs" data-bs-toggle="modal" data-bs-target="#importOpenSubsModal">
      """),_display_(/*10.8*/Messages("blockUtilities.loadSubscriberList")),format.raw/*10.53*/("""
      """),format.raw/*11.7*/("""</button>
      <button class="btn px-4 button-light" id="buttonProcessOpenSubs1" onclick="showComfirmOpenSubsModal(1)">
      """),_display_(/*13.8*/Messages("blockUtilities.unblockOneWayAction")),format.raw/*13.54*/("""
      """),format.raw/*14.7*/("""</button>
      <button class="btn px-4 button-light" id="buttonImportOpenSubs" onclick="exportResultListSubsOpen()">
      """),_display_(/*16.8*/Messages("common.export")),format.raw/*16.33*/("""
      """),format.raw/*17.7*/("""</button>
    </div>
  </div>
  <div class="card-body mt-3" style="padding-right: 0px;">
    <div class="" id="dataImportOpenSubs" style="float: left; width: 100%;">

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/utilities/Utilities_openSubscriber.scala.html
                  HASH: 1faa340f7184712c1b2d97da1d1dc78fa8ee2d63
                  MATRIX: 1065->0|1262->172|1332->222|1365->229|1598->436|1664->481|1698->488|1852->616|1919->662|1953->669|2104->794|2150->819|2184->826
                  LINES: 33->1|37->5|37->5|38->6|42->10|42->10|43->11|45->13|45->13|46->14|48->16|48->16|49->17
                  -- GENERATED --
              */
          