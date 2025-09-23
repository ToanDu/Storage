
package views.html.telco.buySim

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

object BuySim_infoCustomerChangeSim extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-lg-11 col-md-8">
  <div class="row text-start mb-4">
    <div class="col-md-12 mb-4">
      <span class="display-4 title-section-1 text-darker">"""),_display_(/*4.60*/Messages("customer.info.section.title")),format.raw/*4.99*/("""</span>
    </div>
    <div class="col-md-6">
      <div class="row mb-4">
        <label class="col-md-4 col-form-label title-section-2">"""),_display_(/*8.65*/Messages("customer.info.representative.name")),format.raw/*8.110*/("""<span
            class="text-red">"""),_display_(/*9.31*/Messages("field.required")),format.raw/*9.57*/("""</span></label>
        <div class="col-md-8">
          <input id="recipientName" type="text" class="form-control input-form" maxlength="256" onkeypress="if(this.value.length==256) return false;">
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <div class="row mb-4">
        <label class="col-md-4 col-form-label title-section-2">"""),_display_(/*17.65*/Messages("customer.info.businessId")),format.raw/*17.101*/("""<span
            class="text-red">"""),_display_(/*18.31*/Messages("field.required")),format.raw/*18.57*/("""</span></label>
        <div class="col-md-8">
          <input id="bussinessLicense" type="text" class="form-control input-form" readonly maxlength="50">
        </div>
      </div>
    </div>

    <div class="col-md-6">
      <div class="row mb-4">
        <label class="col-md-4 col-form-label title-section-2">"""),_display_(/*27.65*/Messages("customer.info.phone")),format.raw/*27.96*/("""<span
            class="text-red">"""),_display_(/*28.31*/Messages("field.required")),format.raw/*28.57*/("""</span></label>
        <div class="col-md-8">
          <input id="recipientPhone" type="number" class="form-control input-form" pattern="/^-?\d+\.?\d*$/"
            onKeyPress="if(this.value.length==11) return false;">
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <div class="row mb-4">
        <label class="col-md-4 col-form-label title-section-2">"""),_display_(/*37.65*/Messages("customer.info.businessName")),format.raw/*37.103*/("""<span
            class="text-red">"""),_display_(/*38.31*/Messages("field.required")),format.raw/*38.57*/("""</span></label>
        <div class="col-md-8">
          <input id="bussinessName" type="text" readonly class="form-control input-form" maxlength="50">
        </div>
      </div>
    </div>
    <div class="col-md-12">
      <p class="text-center title-section-2 text-darker fst-italic pt-3">
        """),_display_(/*46.10*/Messages("customer.info.changeSim.note")),format.raw/*46.50*/("""
      """),format.raw/*47.7*/("""</p>
    </div>
  </div>

  <div class="row text-start mb-4">
    <div class="col-md-12 mb-4">
      <span class="display-4 title-section-1 text-darker">"""),_display_(/*53.60*/Messages("delivery.section.title")),format.raw/*53.94*/("""</span>
    </div>
    <div class="col-md-6 mb-4">
      <div class="row pl-4">
        <div class="col-md-5">
          <label class="custom-radio">
            <input type="radio" name="transactionPlace" id="optionOne">
            <span class="radio-mark"></span>
            """),_display_(/*61.14*/Messages("delivery.method.store")),format.raw/*61.47*/("""
          """),format.raw/*62.11*/("""</label>
        </div>
        <div class="col-md-7">
          <label class="custom-radio">
            <input type="radio" name="transactionPlace" id="optionTwo">
            <span class="radio-mark"></span>
            """),_display_(/*68.14*/Messages("delivery.method.address")),format.raw/*68.49*/("""
          """),format.raw/*69.11*/("""</label>
        </div>
        <div class="col-md-12 " style="display: none;" id="changMessageOption1">
          <p class="text-start title-section-2 text-darker fst-italic pt-3 mb-0">
            """),_display_(/*73.14*/Messages("delivery.store.note")),format.raw/*73.45*/("""
          """),format.raw/*74.11*/("""</p>
        </div>
      </div>
    </div>

    <div class="col-md-12">
      <div class="row">
        <div class="col-md-4 mb-3">
          <select class="form-control" id="province" onchange="getDistrict()">
            <option value="">"""),_display_(/*83.31*/Messages("location.province")),format.raw/*83.60*/("""</option>
          </select>
        </div>
        <div class="col-md-4 mb-3">
          <select class="form-control" id="district" onchange="getWard()">
            <option value="">"""),_display_(/*88.31*/Messages("location.district")),format.raw/*88.60*/("""</option>
          </select>
        </div>
        <div class="col-md-4 mb-3">
          <select class="form-control" id="ward">
            <option value="">"""),_display_(/*93.31*/Messages("location.ward")),format.raw/*93.56*/("""</option>
          </select>
        </div>
        <div class="col-md-12 mb-3">
             <input id="address" type="text" class="form-control input-form" maxlength="256"
            oninput="if(this.value.length > 256) this.value = this.value.slice(0, 256);"
            placeholder=""""),_display_(/*99.27*/Messages("address.detail.placeholder")),format.raw/*99.65*/("""">
        </div>
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
                  DATE: Mon Sep 22 16:32:51 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/buySim/BuySim_infoCustomerChangeSim.scala.html
                  HASH: 67fee48411b623278e602d2ca282c9df176d821f
                  MATRIX: 1066->0|1253->161|1312->200|1477->339|1543->384|1605->420|1651->446|2035->803|2093->839|2156->875|2203->901|2545->1216|2597->1247|2660->1283|2707->1309|3115->1690|3175->1728|3238->1764|3285->1790|3614->2092|3675->2132|3709->2139|3890->2293|3945->2327|4252->2607|4306->2640|4345->2651|4596->2875|4652->2910|4691->2921|4918->3121|4970->3152|5009->3163|5278->3405|5328->3434|5541->3620|5591->3649|5779->3810|5825->3835|6142->4125|6201->4163
                  LINES: 33->1|36->4|36->4|40->8|40->8|41->9|41->9|49->17|49->17|50->18|50->18|59->27|59->27|60->28|60->28|69->37|69->37|70->38|70->38|78->46|78->46|79->47|85->53|85->53|93->61|93->61|94->62|100->68|100->68|101->69|105->73|105->73|106->74|115->83|115->83|120->88|120->88|125->93|125->93|131->99|131->99
                  -- GENERATED --
              */
          