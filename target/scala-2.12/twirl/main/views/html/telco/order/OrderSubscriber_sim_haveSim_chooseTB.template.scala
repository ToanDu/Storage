
package views.html.telco.order

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

object OrderSubscriber_sim_haveSim_chooseTB extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-lg-9 col-md-8" id="tabConnectHaveSim_chooseTB">
  <div class="row">
    <div class="col-md-6">
      <div class="col-md-12 m-t-4">
        <span class="display-4 title-section-1">"""),_display_(/*5.50*/Messages("1. Thông tin thuê bao")),format.raw/*5.83*/("""</span>
      </div>
      <div class="col-md-12 mt-3">
        <div class="row m-b-3">
          <label class="col-sm-4 col-form-label title-section-2" style="text-align: left">"""),_display_(/*9.92*/Messages("Gói cước ")),format.raw/*9.113*/("""<span class="text-red">"""),_display_(/*9.137*/Messages("*")),format.raw/*9.150*/("""</span></label>
          <div class="col-sm-8">
            <select class="form-control" style="width: 100%;" id="goi_cuoc" onchange="choosePackPayAfterOrBefore()"></select>
          </div>
          <div class="col-sm-4"></div>
          <label class="col-sm-8 col-form-label title-section-2" style="text-align: left" id="discountPromotionData"></label>
        </div>
        <div class="row m-b-3">
          <label class="col-sm-4 col-form-label title-section-2" style="text-align: left">"""),_display_(/*17.92*/Messages("Hình thức hòa mạng ")),format.raw/*17.123*/("""<span class="text-red">"""),_display_(/*17.147*/Messages("*")),format.raw/*17.160*/("""</span></label>
          <div class="col-sm-8">
            <select class="form-control" style="width: 100%;" id="ly_do_dau_noi" onchange="chooseReasonConnect()">
              <option value="">"""),_display_(/*20.33*/Messages("---Chọn hình thức---")),format.raw/*20.65*/("""</option>
            </select>
          </div>
        </div>
        <div class="row m-b-3">
          <label class="col-sm-4 col-form-label title-section-2" style="text-align: left">"""),_display_(/*25.92*/Messages("Đối tượng")),format.raw/*25.113*/("""</label>
          <div class="col-sm-8">
            <select class="form-control" style="width: 100%;" id="doi_tuong">
              <option value="TC01">"""),_display_(/*28.37*/Messages("Cho cá nhân và tổ chức")),format.raw/*28.71*/("""</option>
              <option value="TC02">"""),_display_(/*29.37*/Messages("Cho thiết bị")),format.raw/*29.61*/("""</option>
            </select>
          </div>
        </div>
      </div>

      <div id="tab_chooseTB_after" style="display: none">
        """),_display_(/*36.10*/views/*36.15*/.html.telco.order.OrderSubscriber_sim_haveSim_chooseTB_after()),format.raw/*36.77*/("""
      """),format.raw/*37.7*/("""</div>

      <div id="tab_chooseCt" style="display: none">
        """),_display_(/*40.10*/views/*40.15*/.html.telco.order.OrderSubscriber_sim_haveSim_chooseTB_upCt()),format.raw/*40.76*/("""
      """),format.raw/*41.7*/("""</div>
    </div>

    <div class="col-md-6" id="">
      <div class="col-md-12 m-t-4">
        <span class="display-4 title-section-1">"""),_display_(/*46.50*/Messages("2. Chọn số thuê bao")),format.raw/*46.81*/("""</span>
      </div>
      <div class="col-md-12 mt-3">
        <div class="row m-b-3">
          <div class="col-sm-5">
            <input class="form-check-input" name="inlineRadioOptions" type="radio" id="inlineRadio1" onclick="getConnectSubscriberChoose()"><label class="form-check-label" for="inlineRadio1">"""),_display_(/*51.193*/Messages("Chọn thuê bao")),format.raw/*51.218*/("""</label>
          </div>
          <div class="col-sm-7">
            <input class="form-check-input" name="inlineRadioOptions" type="radio" id="inlineRadio2" onclick="getConnectSubscriberRamdom()"><label class="form-check-label" for="inlineRadio2">"""),_display_(/*54.193*/Messages("Lấy thuê bao ngẫu nhiên")),format.raw/*54.228*/("""</label>
          </div>
        </div>
      </div>
      <div class="col-md-12 mt-3">
        <div class="card-body">
          <div class="" id="searchChooseSubscriber" style="display: none;">
            <div class="row">
              <label class="col-sm-4 col-form-label title-section-2" style="text-align: left">"""),_display_(/*62.96*/Messages("Số thuê bao*")),format.raw/*62.120*/("""</label>
              <div class="col-sm-8">
                <input class="form-control" type="number" id="textSearchChooseSubs" min="0" placeholder=""""),_display_(/*64.107*/Messages("Bạn hãy nhập ít nhất 1 chữ số")),format.raw/*64.148*/("""">
              </div>
            </div>
            <div class="row justify-content-center mt-3">
              <button type="button" class="btn btn-search float-start" onclick="searchSubscriberByStock()" style="background: #FFFFFF; color: #EA0033; border: 1px solid #EA0033;">"""),_display_(/*68.181*/Messages("Tìm kiếm")),format.raw/*68.201*/("""</button>
            </div>
          </div>

          <div class="table-responsive mt-3" id="tableChooseSubscriber"></div>
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
                  DATE: Mon Sep 22 16:32:53 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/order/OrderSubscriber_sim_haveSim_chooseTB.scala.html
                  HASH: 710256b59ecd48413bf283d3ed4e6b8de7cfaedb
                  MATRIX: 1073->0|1295->196|1348->229|1553->408|1595->429|1646->453|1680->466|2202->961|2255->992|2307->1016|2342->1029|2565->1225|2618->1257|2832->1444|2875->1465|3058->1621|3113->1655|3186->1701|3231->1725|3403->1870|3417->1875|3500->1937|3534->1944|3630->2013|3644->2018|3726->2079|3760->2086|3924->2223|3976->2254|4317->2567|4364->2592|4643->2843|4700->2878|5049->3200|5095->3224|5275->3376|5338->3417|5647->3698|5689->3718
                  LINES: 33->1|37->5|37->5|41->9|41->9|41->9|41->9|49->17|49->17|49->17|49->17|52->20|52->20|57->25|57->25|60->28|60->28|61->29|61->29|68->36|68->36|68->36|69->37|72->40|72->40|72->40|73->41|78->46|78->46|83->51|83->51|86->54|86->54|94->62|94->62|96->64|96->64|100->68|100->68
                  -- GENERATED --
              */
          