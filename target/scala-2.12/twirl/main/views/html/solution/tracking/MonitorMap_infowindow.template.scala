
package views.html.solution.tracking

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

object MonitorMap_infowindow extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(projectId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.20*/("""
"""),format.raw/*2.1*/("""<div id="show_hide_infowindow" style="border-collapse: separate;
  border-style: none;
  border-radius: 10px">
  <div id="pos_map_info" class="infowindow-main ui-draggable-handle" style="left: 680px;position: absolute;display: none" >
    <div id="info_header" class="infowindow-header">
      <div id="closeinfo" class="infowindow-close infowindow-closes text-white" onclick="closeInfoWindow()"><i class="bx bx-x"></i></div>
      <div id="portsinfo" class="infowindow-port_button tooltip" style="display: none;" ><i class="fa fa-anchor fa-2x"></i></div>
      <div id="info_name" class="infowindow-title" >..........</div>
    </div>
    <div class="infowindow-inner1">
      <div class="infowindow-first" style="padding-left: 5px" >
        <div>
          <img  class="infowindow-img" src=""""),_display_(/*14.46*/routes/*14.52*/.Assets.versioned("images/solution/tracking/gps.png")),format.raw/*14.105*/(""""  id="mInfo_Avatar"/>
        </div>
        <ul style="padding-left: 20px;padding-top: 10px; color: #000000" oncontextmenu="return false;">
          <li><a style="color: #000000" class="ports_button_text no_redirect" href=""""),_display_(/*17.86*/routes/*17.92*/.SolutionTrackingController.historyMap(projectId)),format.raw/*17.141*/("""" onclick="" >"""),_display_(/*17.156*/Messages("manage.tracking.map.history")),format.raw/*17.195*/("""</a>
        </ul>
      </div>
    </div>
    <div class="infowindow-inner2 sc4" style="overflow-y: auto">
      <div class="row">
        <div class="infowindow-devider1 infwin-key" id="infowindow-devider0">
          <span class="infowindow-mtitle" style="margin-top: 10px">"""),_display_(/*24.69*/Messages("map.info.name")),format.raw/*24.94*/("""</span>
          <br>
          <span class="infowindow-mdesc infwin-mmsi" id="mInfo_name">123456789</span>
          <br>

        </div>
        <div class="infowindow-devider2 infwin-key" id="infowindow-devider1">
          """),format.raw/*31.107*/("""
          """),format.raw/*32.19*/("""
          """),format.raw/*33.89*/("""
          """),format.raw/*34.19*/("""

        """),format.raw/*36.9*/("""</div>
      </div>

    </div>
  </div>
</div>"""))
      }
    }
  }

  def render(projectId:String): play.twirl.api.HtmlFormat.Appendable = apply(projectId)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (projectId) => apply(projectId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:49 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/solution/tracking/MonitorMap_infowindow.scala.html
                  HASH: 55d2407524852f9542ca3f96dfb1f64cfd9f241c
                  MATRIX: 982->1|1095->19|1122->20|1944->815|1959->821|2034->874|2288->1101|2303->1107|2374->1156|2417->1171|2478->1210|2783->1488|2829->1513|3086->1837|3125->1856|3164->1945|3203->1964|3240->1974
                  LINES: 28->1|33->1|34->2|46->14|46->14|46->14|49->17|49->17|49->17|49->17|49->17|56->24|56->24|63->31|64->32|65->33|66->34|68->36
                  -- GENERATED --
              */
          