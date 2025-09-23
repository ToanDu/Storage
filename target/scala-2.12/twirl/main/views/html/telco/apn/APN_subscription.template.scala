
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

object APN_subscription extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="row g-3 py-4">
  <div id="apnContractInfo">
    <span style="font-weight: 700;font-size: 16px;">"""),_display_(/*3.54*/Messages("apn.contractDetailInfo")),format.raw/*3.88*/("""</span>
    <div class="row">
      <div class="col-md-4">
        <div class="row mt-3">
          <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*7.67*/Messages("apn.subscriberNumber")),format.raw/*7.99*/("""</label>
          <div class="col-sm-8">
            <input id="apn-isdn" type="text" class="form-control form-info" readonly>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="row mt-3">
          <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*15.67*/Messages("apn.serialSim")),format.raw/*15.92*/("""</label>
          <div class="col-sm-8">
            <input id="apn-serial" type="text" class="form-control form-info" readonly>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="row mt-3">
          <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*23.67*/Messages("apn.gpkd")),format.raw/*23.87*/("""</label>
          <div class="col-sm-8">
            <input id="apn-idNo" type="text" class="form-control form-info" readonly>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-4">
        <div class="row mt-3">
          <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*33.67*/Messages("apn.serviceType")),format.raw/*33.94*/("""</label>
          <div class="col-sm-8">
            <input id="apn-payTypeView" type="text" class="form-control form-info" readonly>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="row mt-3">
          <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*41.67*/Messages("apn.mainPackage")),format.raw/*41.94*/("""</label>
          <div class="col-sm-8">
            <input id="apn-productCode" type="text" class="form-control form-info" readonly>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="row mt-3">
          <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*49.67*/Messages("apn.blockStatus")),format.raw/*49.94*/("""</label>
          <div class="col-sm-8">
            <input id="apn-actStatusText" type="text" class="form-control form-info" readonly>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-12 col-md-4">
        <div class="row mt-3">
          <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*59.67*/Messages("apn.activationDate")),format.raw/*59.97*/("""</label>
          <div class="col-sm-8">
            <input id="apn-activeDatetime" type="text" class="form-control form-info" readonly>
          </div>
        </div>
      </div>
      <div class="col-sm-12 col-md-4">
        <div class="row mt-3">
          <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*67.67*/Messages("apn.connectionDate")),format.raw/*67.97*/("""</label>
          <div class="col-sm-8">
            <input id="apn-staDatetime" type="text" class="form-control form-info" readonly>
          </div>
        </div>
      </div>
      <div class="col-sm-12 col-md-4">
        <div class="row mt-3">
        </div>
      </div>
    </div>
  </div>
  <hr>

  <div id="apnDetail">
    <div class="row align-content-center">
      <div class="col-md-7 d-flex flex-column justify-content-center">
        <div class="fs-6 fw-bold">
          """),_display_(/*85.12*/Messages("apn.subscriberAPNList")),format.raw/*85.45*/("""
        """),format.raw/*86.9*/("""</div>
      </div>
      <div class="col-md-5 d-flex align-content-center justify-content-end gap-3">
        
        <button type="button" class="btn_cmp is-primary fs-6 fw-normal" style="width: 180px;" data-bs-toggle="modal" data-bs-target="#addDefaultAPN">
          """),_display_(/*91.12*/Messages("apn.assignDefaultAPN")),format.raw/*91.44*/("""</button>
        <button type="button" class="btn_cmp is-primary fs-6 fw-normal" style="width: 180px;" data-bs-toggle="modal" data-bs-target="#addPrivateAPN">
          """),_display_(/*93.12*/Messages("apn.assignAPNIP")),format.raw/*93.39*/("""</button>
      </div>
    </div>

    <div class="row fst-italic mt-4">
      <div>
        """),_display_(/*99.10*/Messages("apn.defaultAPNNote")),format.raw/*99.40*/("""
      """),format.raw/*100.7*/("""</div>
    </div>
    <div class="table-responsive my-3" style="border-radius: 8px;">
      <table id="apn-detail-table" class="table table-striped" style="width: 100%;">
        <thead style="background-color: #FBCCD6;">
          <tr>
            <th>"""),_display_(/*106.18*/Messages("apn.serialNumber")),format.raw/*106.46*/("""</th>
            <th>"""),_display_(/*107.18*/Messages("apn.apnType")),format.raw/*107.41*/("""</th>
            <th>"""),_display_(/*108.18*/Messages("apn.apnName")),format.raw/*108.41*/("""</th>
            <th>"""),_display_(/*109.18*/Messages("apn.ipAddress")),format.raw/*109.43*/("""</th>
            <th>"""),_display_(/*110.18*/Messages("apn.startDate")),format.raw/*110.43*/("""</th>
            <th>"""),_display_(/*111.18*/Messages("apn.endDate")),format.raw/*111.41*/("""</th>
            <th class="text-center">"""),_display_(/*112.38*/Messages("apn.actions")),format.raw/*112.61*/("""</th>
          </tr>
        </thead>
        <tbody>
         </tbody>
      </table>
      <h5 id="notiNotDataSubs" style="text-align: center;"></h5>
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
                  DATE: Mon Sep 22 16:32:51 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/apn/APN_subscription.scala.html
                  HASH: 69343d52a7a841871d93cee8400a388c4cd28d49
                  MATRIX: 1051->0|1186->109|1240->143|1422->299|1474->331|1800->630|1846->655|2174->956|2215->976|2574->1308|2622->1335|2955->1641|3003->1668|3336->1974|3384->2001|3762->2352|3813->2382|4159->2701|4210->2731|4726->3220|4780->3253|4816->3262|5116->3535|5169->3567|5367->3738|5415->3765|5536->3859|5587->3889|5622->3896|5904->4150|5954->4178|6005->4201|6050->4224|6101->4247|6146->4270|6197->4293|6244->4318|6295->4341|6342->4366|6393->4389|6438->4412|6509->4455|6554->4478
                  LINES: 33->1|35->3|35->3|39->7|39->7|47->15|47->15|55->23|55->23|65->33|65->33|73->41|73->41|81->49|81->49|91->59|91->59|99->67|99->67|117->85|117->85|118->86|123->91|123->91|125->93|125->93|131->99|131->99|132->100|138->106|138->106|139->107|139->107|140->108|140->108|141->109|141->109|142->110|142->110|143->111|143->111|144->112|144->112
                  -- GENERATED --
              */
          