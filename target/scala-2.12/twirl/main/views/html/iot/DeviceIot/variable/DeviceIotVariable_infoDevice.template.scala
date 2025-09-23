
package views.html.iot.DeviceIot.variable

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

object DeviceIotVariable_infoDevice extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(deviceId: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.20*/("""
"""),format.raw/*2.1*/("""<div class="col">
  <div class="card" style="height: 95%">
    <div class="card-body" >
      <div id="paper-middle">
        <div id="map-canvas"></div>
      </div>
    </div>
    <div class="card-body">
      <h5 class="card-title">"""),_display_(/*10.31*/Messages("device.variable.id")),format.raw/*10.61*/("""</h5>
      <p class="card-text" id="deviceId">"""),_display_(/*11.43*/deviceId),format.raw/*11.51*/("""</p>
    </div>
    <div class="card-body">
      <h5 class="card-title">"""),_display_(/*14.31*/Messages("device.variable.total")),format.raw/*14.64*/("""</h5>
      <p class="card-text" id="totalVariable"></p>
    </div>
  </div>
</div>"""))
      }
    }
  }

  def render(deviceId:String): play.twirl.api.HtmlFormat.Appendable = apply(deviceId)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (deviceId) => apply(deviceId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:44 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/DeviceIot/variable/DeviceIotVariable_infoDevice.scala.html
                  HASH: 399d1b5bebc121229f62707fee73d215f8e7f70c
                  MATRIX: 994->1|1107->19|1134->20|1397->256|1448->286|1523->334|1552->342|1653->416|1707->449
                  LINES: 28->1|33->1|34->2|42->10|42->10|43->11|43->11|46->14|46->14
                  -- GENERATED --
              */
          