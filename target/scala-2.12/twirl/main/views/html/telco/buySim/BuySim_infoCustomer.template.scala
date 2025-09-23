
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

object BuySim_infoCustomer extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

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
          <input id="ten_ng_dai_dien" type="text" class="form-control input-form" maxlength="256" onkeypress="if(this.value.length==256) return false;">
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <div class="row mb-4">
        <label class="col-md-4 col-form-label title-section-2">"""),_display_(/*17.65*/Messages("customer.info.businessId")),format.raw/*17.101*/("""<span
            class="text-red">"""),_display_(/*18.31*/Messages("field.required")),format.raw/*18.57*/("""</span></label>
        <div class="col-md-8">
          <input id="ma_so_doanh_nghiep" type="text" class="form-control input-form" readonly maxlength="50">
        </div>
      </div>
    </div>

    <div class="col-md-6">
      <div class="row mb-4">
        <label class="col-md-4 col-form-label title-section-2">"""),_display_(/*27.65*/Messages("customer.info.phone")),format.raw/*27.96*/("""<span
            class="text-red">"""),_display_(/*28.31*/Messages("field.required")),format.raw/*28.57*/("""</span></label>
        <div class="col-md-8">
          <input id="so_dien_thoai_lien_he" type="number" class="form-control input-form" pattern="/^-?\d+\.?\d*$/"
            onKeyPress="if(this.value.length==11) return false;">
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <div class="row mb-4">
        <label class="col-md-4 col-form-label title-section-2">"""),_display_(/*37.65*/Messages("customer.info.businessName")),format.raw/*37.103*/("""<span
            class="text-red">"""),_display_(/*38.31*/Messages("field.required")),format.raw/*38.57*/("""</span></label>
        <div class="col-md-8">
          <input id="ten_doanh_nghiep" type="text" readonly class="form-control input-form" maxlength="50">
        </div>
      </div>
    </div>
    <div class="col-md-12">
      <p class="text-center title-section-2 text-darker fst-italic pt-3">
        """),_display_(/*46.10*/Messages("customer.info.contact.note")),format.raw/*46.48*/("""
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
            <input type="radio" name="inlineRadioOptions" id="inlineRadio2">
            <span class="radio-mark"></span>
            """),_display_(/*61.14*/Messages("delivery.method.store")),format.raw/*61.47*/("""
          """),format.raw/*62.11*/("""</label>
        </div>
        <div class="col-md-7">
          <label class="custom-radio">
            <input type="radio" name="inlineRadioOptions" id="inlineRadio1">
            <span class="radio-mark"></span>
            """),_display_(/*68.14*/Messages("delivery.method.address")),format.raw/*68.49*/("""
          """),format.raw/*69.11*/("""</label>
        </div>
        <div class="col-md-12 " style="display: none;" id="orderMessageOption1">
          <p class="text-start title-section-2 text-darker fst-italic pt-3 mb-0">
            """),_display_(/*73.14*/Messages("delivery.store.note")),format.raw/*73.45*/("""
          """),format.raw/*74.11*/("""</p>
        </div>
      </div>
    </div>

    <div class="col-md-12">
      <div class="row">
        <div class="col-md-4 mb-3">
          <select class="form-control" id="tinh_tp" onchange="selectDistrict()">
            <option value="">"""),_display_(/*83.31*/Messages("location.province")),format.raw/*83.60*/("""</option>
          </select>
        </div>
        <div class="col-md-4 mb-3">
          <select class="form-control" id="quan_huyen" onchange="selectWard()">
            <option value="">"""),_display_(/*88.31*/Messages("location.district")),format.raw/*88.60*/("""</option>
          </select>
        </div>
        <div class="col-md-4 mb-3">
          <select class="form-control" id="phuong_xa">
            <option value="">"""),_display_(/*93.31*/Messages("location.ward")),format.raw/*93.56*/("""</option>
          </select>
        </div>
        <div class="col-md-12 mb-3">
          <input id="dia_chi_chi_tiet" type="text" class="form-control input-form" maxlength="256"
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/buySim/BuySim_infoCustomer.scala.html
                  HASH: 4375058d532a0e11f383888f722fcd159220926f
                  MATRIX: 1057->0|1244->161|1303->200|1468->339|1534->384|1596->420|1642->446|2028->805|2086->841|2149->877|2196->903|2540->1220|2592->1251|2655->1287|2702->1313|3117->1701|3177->1739|3240->1775|3287->1801|3619->2106|3678->2144|3712->2151|3893->2305|3948->2339|4260->2624|4314->2657|4353->2668|4609->2897|4665->2932|4704->2943|4931->3143|4983->3174|5022->3185|5293->3429|5343->3458|5561->3649|5611->3678|5804->3844|5850->3869|6173->4165|6232->4203
                  LINES: 33->1|36->4|36->4|40->8|40->8|41->9|41->9|49->17|49->17|50->18|50->18|59->27|59->27|60->28|60->28|69->37|69->37|70->38|70->38|78->46|78->46|79->47|85->53|85->53|93->61|93->61|94->62|100->68|100->68|101->69|105->73|105->73|106->74|115->83|115->83|120->88|120->88|125->93|125->93|131->99|131->99
                  -- GENERATED --
              */
          