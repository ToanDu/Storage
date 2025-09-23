
package views.html.iot.dashboard.customPage

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

object CustomPageDashboard_accordion_chartCircle extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="accordion-body">
  <div id="divChartCircle" >
    <li class="draggable" style="height: 100%;" id="chartCircle0" onclick="clickEditDetail(this, 2)">
      <img src=""""),_display_(/*4.18*/routes/*4.24*/.Assets.versioned("images/dashboard/chartCircle.png")),format.raw/*4.77*/("""" width="100%" height="100%" alt="" />
      <div class="col" style="margin-top: 12px">
        <div class="btn-group" role="group" aria-label="Basic example" style="display: flex;justify-content: center;align-items: center;">
          <button type="button" class="btn btn-light"><i class="bx bx-edit"></i>
          </button>
          <button type="button" class="btn btn-light" onclick="removeLiID('chartCircle0')"><i class="bx bx-x"></i>
          </button>
        </div>
      </div>
    </li>
  </div>
  <hr>
  <button class="btn btn-primary" onclick="createLiChartCircle()">
    <i class="bx bx-plus" aria-hidden="true"></i> """),_display_(/*17.52*/Messages("dashboard.design.create")),format.raw/*17.87*/("""
  """),format.raw/*18.3*/("""</button>
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
                  DATE: Mon Sep 22 16:32:43 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboard/customPage/CustomPageDashboard_accordion_chartCircle.scala.html
                  HASH: f87f94adb381107e3ade33a129a80fb45e136cb3
                  MATRIX: 1091->0|1294->177|1308->183|1381->236|2043->871|2099->906|2129->909
                  LINES: 33->1|36->4|36->4|36->4|49->17|49->17|50->18
                  -- GENERATED --
              */
          