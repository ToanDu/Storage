
package views.html.telco.aep

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

object AepUtilities_gps extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="row mt-4" id="gps-aep" style="display: none;">
  <div class="col-md-4">
    <div class="row">
      <div class="col-md-4">
        <h6>"""),_display_(/*5.14*/Messages("Request:")),format.raw/*5.34*/("""</h6>
      </div>
      <div class="col-md-8">
        <select class="" onchange="changeApiGeocoding(this)">
          <option value="1" selected>"""),_display_(/*9.39*/Messages("2 WiFis – 1 Cell")),format.raw/*9.67*/("""</option>
          <option value="2">"""),_display_(/*10.30*/Messages("1 Cell – GSM")),format.raw/*10.54*/("""</option>
          <option value="3">"""),_display_(/*11.30*/Messages("1 Cell – Nb-IoT")),format.raw/*11.57*/("""</option>
        </select>
      </div>
    </div>

    <br>
    <textarea style="width: 100%;" rows="10" id="editorRequestGps">
      """),format.raw/*18.7*/("""{"""),format.raw/*18.8*/("""
        """),format.raw/*19.9*/(""""radio": "gsm",
        "cells": [
          """),format.raw/*21.11*/("""{"""),format.raw/*21.12*/("""
            """),format.raw/*22.13*/(""""lac": 42900,
            "cid": 74875925,
            "signal": -71
          """),format.raw/*25.11*/("""}"""),format.raw/*25.12*/("""
        """),format.raw/*26.9*/("""],
        "wifi": [
          """),format.raw/*28.11*/("""{"""),format.raw/*28.12*/("""
            """),format.raw/*29.13*/(""""bssid": "34:36:54:bc:5:30",
            "signal": -53
          """),format.raw/*31.11*/("""}"""),format.raw/*31.12*/(""",
          """),format.raw/*32.11*/("""{"""),format.raw/*32.12*/("""
            """),format.raw/*33.13*/(""""bssid": "78:58:60:7d:8:1c",
            "signal": -54
          """),format.raw/*35.11*/("""}"""),format.raw/*35.12*/("""
        """),format.raw/*36.9*/("""]
      """),format.raw/*37.7*/("""}"""),format.raw/*37.8*/("""
    """),format.raw/*38.5*/("""</textarea>
  </div>

  <div class="col-md-4">
    <h6>"""),_display_(/*42.10*/Messages("Response:")),format.raw/*42.31*/("""</h6><br>

    <textarea style="width: 100%;" rows="10" id="editorResponseGps"></textarea>
  </div>

  <div class="col-md-4">
    <h6>"""),_display_(/*48.10*/Messages("Location:")),format.raw/*48.31*/("""</h6><br>

    <div id="page-content-wrapper" style="background: white; padding: 15px; height: 70vh;">
      <div id="map-canvas" class="big-map"></div>
    </div>
  </div>

  <div class="col-md-12 mx-auto text-center mt-2 mb-2">
    <button type="button" class="btn btn-exp" style="width: 160px;" onclick="submitGps()">"""),_display_(/*56.92*/Messages("Submit")),format.raw/*56.110*/("""</button>
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
                  DATE: Mon Sep 22 16:32:50 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/aep/AepUtilities_gps.scala.html
                  HASH: cd4ef6436662930f7e4d2e38a115cf7d6cc5a502
                  MATRIX: 1051->0|1225->148|1265->168|1439->316|1487->344|1553->383|1598->407|1664->446|1712->473|1875->609|1903->610|1939->619|2012->664|2041->665|2082->678|2189->757|2218->758|2254->767|2313->798|2342->799|2383->812|2476->877|2505->878|2545->890|2574->891|2615->904|2708->969|2737->970|2773->979|2808->987|2836->988|2868->993|2951->1049|2993->1070|3155->1205|3197->1226|3545->1547|3585->1565
                  LINES: 33->1|37->5|37->5|41->9|41->9|42->10|42->10|43->11|43->11|50->18|50->18|51->19|53->21|53->21|54->22|57->25|57->25|58->26|60->28|60->28|61->29|63->31|63->31|64->32|64->32|65->33|67->35|67->35|68->36|69->37|69->37|70->38|74->42|74->42|80->48|80->48|88->56|88->56
                  -- GENERATED --
              */
          