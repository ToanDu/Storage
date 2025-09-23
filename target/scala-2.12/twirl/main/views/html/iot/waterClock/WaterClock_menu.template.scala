
package views.html.iot.waterClock

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

object WaterClock_menu extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="wrapper">
  <div class="sidebar-wrapper" data-simplebar="true" style="background-color: #F4F5F6;">
    <div class="sidebar-header" style="background-color: white;">
      <div>
        <img src=""""),_display_(/*5.20*/routes/*5.26*/.Assets.versioned("images/dashboard/logo.svg")),format.raw/*5.72*/("""" class="logo-icon" alt="logo icon" style="width: 150px; margin-left: 35px;">
      </div>
      <div class="toggle-icon ms-auto" id="arrowMenu" style="display: none"><i class='bx bx-arrow-to-left'></i>
      </div>
    </div>
      <!--navigation-->
    <ul class="metismenu" id="menu">

      <li id="menu-waterClock">
        <a href=""""),_display_(/*14.19*/routes/*14.25*/.WaterClockController.waterClock()),format.raw/*14.59*/("""">
          <div class="parent-icon">
            <img src=""""),_display_(/*16.24*/routes/*16.30*/.Assets.versioned("images/menu/tongquan.png")),format.raw/*16.75*/("""" class="logo-icon" alt="logo icon" style="">
          </div>
          <div class="menu-title">"""),_display_(/*18.36*/Messages("manage.home")),format.raw/*18.59*/("""</div>
        </a>
      </li>

    </ul>
  </div>
</div>
<script src=""""),_display_(/*25.15*/routes/*25.21*/.Assets.versioned("javascripts/menu.js")),format.raw/*25.61*/("""" type="text/javascript"></script>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:46 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/waterClock/WaterClock_menu.scala.html
                  HASH: 1ffacfd5f0c2502300daf7104fe1dad0e62766ef
                  MATRIX: 1055->0|1289->208|1303->214|1369->260|1735->599|1750->605|1805->639|1894->701|1909->707|1975->752|2100->850|2144->873|2244->946|2259->952|2320->992
                  LINES: 33->1|37->5|37->5|37->5|46->14|46->14|46->14|48->16|48->16|48->16|50->18|50->18|57->25|57->25|57->25
                  -- GENERATED --
              */
          