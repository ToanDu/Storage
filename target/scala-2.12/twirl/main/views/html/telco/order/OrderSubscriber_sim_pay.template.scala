
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

object OrderSubscriber_sim_pay extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-lg-9 col-md-8 mt-3" id="tabConnectHaveSim_pay">
  <div class="row">
    <div class="col-md-12 m-t-4">
      <span class="display-4 title-section-1">"""),_display_(/*4.48*/Messages("1. Xác nhận đấu nối")),format.raw/*4.79*/("""</span>
    </div>
    <div class="col-md-12">
      <div class="row">
        <div class="col-md-12 m-t-3">
          <div class="row m-b-3">
            <label class="col-sm-8 col-form-label title-section-2" style="text-align: left" id="confirmNamePack">"""),_display_(/*10.115*/Messages("Gói cước: ")),format.raw/*10.137*/("""</label>
          </div>
          <div class="row m-b-4" id="comfirmTableTotalMoney">

          </div>
          <div class="row" id="comfirmTableTotalMoney">
            <div class="col-sm-1" style="text-align: right;">
              <label class="col-sm-1 col-form-label title-section-2">
                <input class="form-check-input" type="checkbox" onchange="checkboxDksd(this)">
              </label>
            </div>
            <label class="col-sm-11 col-form-label title-section-2" style="text-align: left">
            """),_display_(/*22.14*/Messages("Đồng ý cho phép Viettel sử dụng thông tin của khách hàng để:")),format.raw/*22.86*/("""
            """),format.raw/*23.13*/("""</label>
            <div class="col-sm-1"></div>
            <div class="col-sm-11">
              <ul style="text-align: left;">
                <li>"""),_display_(/*27.22*/Messages("Cung cấp dịch vụ khác của Viettel phát sinh sau thời điểm hòa mạng và/hoặc các dịch vụ Viettel hợp tác với đối tác")),format.raw/*27.148*/("""</li>
                <li>"""),_display_(/*28.22*/Messages("Tổ chức giới thiệu và xúc tiến thương mại")),format.raw/*28.75*/("""</li>
                <li>"""),_display_(/*29.22*/Messages("Nghiên cứu thị trường, thăm dò dư luận, môi giới")),format.raw/*29.82*/("""</li>
              </ul>
            </div>
          </div>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/order/OrderSubscriber_sim_pay.scala.html
                  HASH: 29c382e99512ef468ddf05871d28b3131248d695
                  MATRIX: 1060->0|1251->165|1302->196|1587->453|1631->475|2196->1013|2289->1085|2330->1098|2509->1250|2657->1376|2711->1403|2785->1456|2839->1483|2920->1543
                  LINES: 33->1|36->4|36->4|42->10|42->10|54->22|54->22|55->23|59->27|59->27|60->28|60->28|61->29|61->29
                  -- GENERATED --
              */
          