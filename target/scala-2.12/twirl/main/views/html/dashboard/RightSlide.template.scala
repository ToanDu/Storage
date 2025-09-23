
package views.html.dashboard

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

object RightSlide extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!-- RIGHT SLIDER CONTENT -->
<div class="sb-slidebar sb-right">
  <div class="right-wrapper">
    <div class="row">
      <h3>
        <span><i class="entypo-gauge"></i>&nbsp;&nbsp;MAIN WIDGET</span>
      </h3>
      <div class="col-sm-12">

        <div class="widget-knob">
          <span class="chart" style="position:relative" data-percent="86">
            <span class="percent"></span>
          </span>
        </div>
        <div class="widget-def">
          <b>Distance traveled</b>
          <br>
          <i>86% to the check point</i>
        </div>

        <div class="widget-knob">
          <span class="speed-car" style="position:relative" data-percent="60">
            <span class="percent2"></span>
          </span>
        </div>
        <div class="widget-def">
          <b>The average speed</b>
          <br>
          <i>30KM/h avarage speed</i>
        </div>


        <div class="widget-knob">
          <span class="overall" style="position:relative" data-percent="25">
            <span class="percent3"></span>
          </span>
        </div>
        <div class="widget-def">
          <b>Overall result</b>
          <br>
          <i>30KM/h avarage Result</i>
        </div>
      </div>
    </div>
  </div>

  <div style="margin-top:0;" class="right-wrapper">
    <div class="row">

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
                  DATE: Mon Sep 22 16:32:41 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/dashboard/RightSlide.scala.html
                  HASH: a3e83898a6f4e62b73ac12b71a21c5e0cd8b62a1
                  MATRIX: 1045->0
                  LINES: 33->1
                  -- GENERATED --
              */
          