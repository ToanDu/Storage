
package views.html.iot.message

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

object MessagesDevice_tab_message extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-md-12">
  <div class="row">
    <div class="col-md-6 text-white">
      <div class="form-group">
        <label style="font-weight: bold">"""),_display_(/*5.43*/Messages("Topic")),format.raw/*5.60*/("""</label>
      </div><hr>
      <div class="form-check">
        <input type="radio" class="form-check-input" id="dataCheck" name="radio-stacked" required>
        <label class="form-check-label">"""),_display_(/*9.42*/Messages("data")),format.raw/*9.58*/("""</label>
      </div><hr>
      <div class="form-check">
        <input type="radio" class="form-check-input" id="eventsCheck" name="radio-stacked" required>
        <label class="form-check-label">"""),_display_(/*13.42*/Messages("events")),format.raw/*13.60*/("""</label>
      </div><hr>
      <div class="form-check">
        <input type="radio" class="form-check-input" id="appControlsCheck" name="radio-stacked" required>
        <label class="form-check-label">"""),_display_(/*17.42*/Messages("app/controls")),format.raw/*17.66*/("""</label>
      </div><hr>
      <div class="form-check">
        <input type="radio" class="form-check-input" id="deviceControlsCheck" name="radio-stacked" required>
        <label class="form-check-label">"""),_display_(/*21.42*/Messages("device/controls")),format.raw/*21.69*/("""</label>
      </div><hr>
    </div>
    <div class="col-md-6 text-white">
      <div class="form-group">
        <label style="font-weight: bold">"""),_display_(/*26.43*/Messages("Get Message")),format.raw/*26.66*/("""</label>
      </div><hr>
      <div class="form-check">
        <input class="form-check-input" type="checkbox" id="invalidCheckData">
        <label class="form-check-label" for="invalidCheck">"""),_display_(/*30.61*/Messages("data")),format.raw/*30.77*/("""</label>
      </div><hr>
      <div class="form-check">
        <input class="form-check-input" type="checkbox" id="invalidCheckEvents">
        <label class="form-check-label" for="invalidCheck">"""),_display_(/*34.61*/Messages("events")),format.raw/*34.79*/("""</label>
      </div><hr>
      <div class="form-check">
        <input class="form-check-input" type="checkbox" id="invalidCheckAppControls">
        <label class="form-check-label" for="invalidCheck">"""),_display_(/*38.61*/Messages("app/controls")),format.raw/*38.85*/("""</label>
      </div><hr>
      <div class="form-check">
        <input class="form-check-input" type="checkbox"id="invalidCheckDeviceControls">
        <label class="form-check-label" for="invalidCheck">"""),_display_(/*42.61*/Messages("device/controls")),format.raw/*42.88*/("""</label>
      </div><hr>
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
                  DATE: Mon Sep 22 16:32:45 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/message/MessagesDevice_tab_message.scala.html
                  HASH: fc450f296b412d05e76a9bf25db9d5ce2f5fcefe
                  MATRIX: 1063->0|1244->155|1281->172|1504->369|1540->385|1766->584|1805->602|2036->806|2081->830|2315->1037|2363->1064|2538->1212|2582->1235|2805->1431|2842->1447|3067->1645|3106->1663|3336->1866|3381->1890|3613->2095|3661->2122
                  LINES: 33->1|37->5|37->5|41->9|41->9|45->13|45->13|49->17|49->17|53->21|53->21|58->26|58->26|62->30|62->30|66->34|66->34|70->38|70->38|74->42|74->42
                  -- GENERATED --
              */
          