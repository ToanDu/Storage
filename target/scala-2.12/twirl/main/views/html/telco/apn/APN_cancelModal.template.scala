
package views.html.telco.apn

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

object APN_cancelModal extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="cancelDefaultAPN" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title " id="exampleModalLabel" >"""),_display_(/*5.59*/Messages("apn.cancel.cancelDefaultAPN")),format.raw/*5.98*/("""</h5>
      </div>
      <div class="modal-body bg-white">
        <div class="row g-3">
          <div class="col-md-12 justify-content-center text-center fs-6">
            <div>
              """),_display_(/*11.16*/Messages("apn.cancel.confirmCancelDefault")),format.raw/*11.59*/("""
            """),format.raw/*12.13*/("""</div>
            <div>
              """),_display_(/*14.16*/Messages("apn.cancel.networkWarning")),format.raw/*14.53*/("""
            """),format.raw/*15.13*/("""</div>
          </div>
        </div>
      </div>
       <div class="modal-footer">
        <button type="button" class="btn_cmp is-outline mt-3 fs-6 fw-normal" data-bs-dismiss="modal">"""),_display_(/*20.103*/Messages("apn.cancel.cancelButton")),format.raw/*20.138*/("""</button>
        <button type="button" class="confirm-remove-apn btn_cmp is-primary fs-6 fw-normal" data-bs-dismiss="modal" onclick="UnRegisterAPN(true)">"""),_display_(/*21.147*/Messages("apn.cancel.confirmButton")),format.raw/*21.183*/("""</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="cancelPrivateAPN" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel" >"""),_display_(/*30.58*/Messages("apn.cancel.cancelPrivateAPN")),format.raw/*30.97*/("""</h5>
      </div>
      <div class="modal-body bg-white">
        <div class="row g-3">
          <div class="col-md-12 justify-content-center text-center fs-6">
             <div>
              """),_display_(/*36.16*/Messages("apn.cancel.confirmCancelPrivate")),format.raw/*36.59*/("""
            """),format.raw/*37.13*/("""</div>
            <div>
              """),_display_(/*39.16*/Messages("apn.cancel.networkWarning")),format.raw/*39.53*/("""
            """),format.raw/*40.13*/("""</div>
          <div class="row mb-4 mt-5">
            <div class="row col-md-6">
              <label class="col-sm-4 col-form-label">"""),_display_(/*43.55*/Messages("apn.cancel.apnName")),format.raw/*43.85*/("""</label>
              <div class="col-sm-8">
                <input id="apn-name" type="text" class="form-control" style="color: black !important;" autocomplete="off" required disabled >
              </div>
            </div>
            <div class="row col-md-6">
              <label class="col-sm-4 col-form-label">"""),_display_(/*49.55*/Messages("apn.cancel.ipAddress")),format.raw/*49.87*/("""</label>
              <div class="col-sm-8">
                <input id="apn-ip" type="text" class="form-control" style="color: black !important;" autocomplete="off" required disabled >
              </div>
            </div>
          </div>
          <div class="row">
            <label class="col-form-label" style="width: 16.5%;">"""),_display_(/*56.66*/Messages("apn.cancel.reason")),format.raw/*56.95*/(""" """),format.raw/*56.96*/("""<span
                class="text-red">"""),_display_(/*57.35*/Messages("common.required")),format.raw/*57.62*/("""</span></label>
            <div class="" style="width: 83.5%;padding-left: 0.3rem; padding-right: 3.8rem;">
              <select id="apn-reason" class="form-select" value="299799" required>
                <option value="299799">"""),_display_(/*60.41*/Messages("apn.cancel.customerRequest")),format.raw/*60.79*/("""</option>
              </select>
               <div class="helper-text form-text text-danger mt-2" style="min-height: 14px;"></div>
            </div>
          </div>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn_cmp is-outline mt-3 fs-6 fw-normal" data-bs-dismiss="modal" >"""),_display_(/*69.104*/Messages("common.cancel")),format.raw/*69.129*/("""</button>
        <button type="button" class="confirm-remove-apn btn_cmp is-primary fs-6 fw-normal" onclick="UnRegisterAPN(false)">"""),_display_(/*70.124*/Messages("common.confirm")),format.raw/*70.150*/("""</button>
      </div>
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
                  DATE: Mon Sep 22 16:32:50 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/apn/APN_cancelModal.scala.html
                  HASH: 99b3b47d1e9c1e4b3653c55498e852c2340c34e3
                  MATRIX: 1050->0|1366->290|1425->329|1648->525|1712->568|1753->581|1820->621|1878->658|1919->671|2135->859|2192->894|2376->1050|2434->1086|2800->1425|2860->1464|3084->1661|3148->1704|3189->1717|3256->1757|3314->1794|3355->1807|3520->1945|3571->1975|3919->2296|3972->2328|4335->2664|4385->2693|4414->2694|4481->2734|4529->2761|4788->2993|4847->3031|5226->3382|5273->3407|5434->3540|5482->3566
                  LINES: 33->1|37->5|37->5|43->11|43->11|44->12|46->14|46->14|47->15|52->20|52->20|53->21|53->21|62->30|62->30|68->36|68->36|69->37|71->39|71->39|72->40|75->43|75->43|81->49|81->49|88->56|88->56|88->56|89->57|89->57|92->60|92->60|101->69|101->69|102->70|102->70
                  -- GENERATED --
              */
          