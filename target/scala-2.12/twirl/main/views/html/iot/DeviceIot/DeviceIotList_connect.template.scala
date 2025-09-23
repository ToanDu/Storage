
package views.html.iot.DeviceIot

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

object DeviceIotList_connect extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<form>
  <div class="modal fade" id="connectDeviceModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
      <div class="modal-content" id="theme7">
        <div class="modal-header">
          <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*6.70*/Messages("Connect Device")),format.raw/*6.96*/("""</h5>
          <button type="button" class="btn-close" href="#" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div id="smartwizard">
          <ul class="nav">
            <li class="nav-item">
              <a class="nav-link" href="#step-0"></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#step-1">	<strong>Step 1</strong>
                <br>"""),_display_(/*16.22*/Messages("device.paidDevice")),format.raw/*16.51*/("""</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#step-2">	<strong>Step 2</strong>
                <br>"""),_display_(/*20.22*/Messages("device.sendMessage")),format.raw/*20.52*/("""</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#step-3">	<strong>Step 3</strong>
                <br>"""),_display_(/*24.22*/Messages("device.checkConnect")),format.raw/*24.53*/("""</a>
            </li>
          </ul>
          <div class="tab-content">
            <div id="step-0" class="tab-pane" role="tabpanel" aria-labelledby="step-0">"""),_display_(/*28.89*/Messages(" ")),format.raw/*28.102*/("""</div>
            <div id="step-1" class="tab-pane" role="tabpanel" aria-labelledby="step-1">
              <form class="row g-3">
                <h6 class="text-white">"""),_display_(/*31.41*/Messages("device.step1")),format.raw/*31.65*/("""</h6><hr>
                <div class="col-12">
                  <label class="form-label text-white">"""),_display_(/*33.57*/Messages("Device ID")),format.raw/*33.78*/("""</label>
                  <div class="input-group input-group-lg">
                    <input type="text" class="form-control border-start-0" id="device-deviceId"/>
                    <span class="input-group-text" style="cursor: pointer" onclick="copyText('device-deviceId', 'Device ID')"><i class='bx bxs-copyright'></i>"""),_display_(/*36.160*/Messages("Copy")),format.raw/*36.176*/("""</span>
                  </div>
                </div>
                <div class="col-12">
                  <label class="form-label text-white">"""),_display_(/*40.57*/Messages("Device Token")),format.raw/*40.81*/("""</label>
                  <div class="input-group input-group-lg">
                    <input type="text" class="form-control border-start-0" id="device-deviceToken"/>
                    <span class="input-group-text" style="cursor: pointer" onclick="copyText('device-deviceToken', 'Device Token')"><i class='bx bxs-copyright'></i>"""),_display_(/*43.166*/Messages("Copy")),format.raw/*43.182*/("""</span>
                  </div>
                </div>
              </form>
            </div>

            <div id="step-2" class="tab-pane" role="tabpanel" aria-labelledby="step-2">
              <h6 class="text-white">"""),_display_(/*50.39*/Messages("device.step2")),format.raw/*50.63*/("""</h6><hr>
              <div class="col-md-12 text-white" id="contentMessageTest" style="margin-left: 15px;"></div>
            </div>

            <div id="step-3" class="tab-pane" role="tabpanel" aria-labelledby="step-3">
            </div>
          </div>
        </div>
        """),format.raw/*58.39*/("""
        """),format.raw/*59.110*/("""
        """),format.raw/*60.19*/("""
      """),format.raw/*61.7*/("""</div>
    </div>
  </div>
</form>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:44 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/DeviceIot/DeviceIotList_connect.scala.html
                  HASH: 0bba0ac0d77d59f7c4946d6b77bf209c57463501
                  MATRIX: 1060->0|1429->343|1475->369|1928->795|1978->824|2157->976|2208->1006|2387->1158|2439->1189|2629->1352|2664->1365|2863->1537|2908->1561|3038->1664|3080->1685|3433->2010|3471->2026|3647->2175|3692->2199|4054->2533|4092->2549|4343->2773|4388->2797|4699->3110|4737->3220|4774->3239|4808->3246
                  LINES: 33->1|38->6|38->6|48->16|48->16|52->20|52->20|56->24|56->24|60->28|60->28|63->31|63->31|65->33|65->33|68->36|68->36|72->40|72->40|75->43|75->43|82->50|82->50|90->58|91->59|92->60|93->61
                  -- GENERATED --
              */
          