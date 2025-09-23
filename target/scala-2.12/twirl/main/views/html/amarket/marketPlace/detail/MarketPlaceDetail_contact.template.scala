
package views.html.amarket.marketPlace.detail

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

object MarketPlaceDetail_contact extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="contactFormModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      """),format.raw/*4.37*/("""
        """),format.raw/*5.105*/("""
      """),format.raw/*6.17*/("""
      """),format.raw/*7.7*/("""<div class="modal-body">
        <span class="title-form-contact-1">"""),_display_(/*8.45*/Messages("Gửi thông tin liên hệ")),format.raw/*8.78*/("""</span>
        <br>
        <span class="title-form-contact-2">"""),_display_(/*10.45*/Messages("Vui lòng nhập thông tin để liên hệ với người bán")),format.raw/*10.105*/("""</span>
        <form class="row g-3 mt-3">
          <div class="col-md-12">
            <div class="row mb-1">
              <span class="col-sm-12 col-form-label">"""),_display_(/*14.55*/Messages("Họ tên")),format.raw/*14.73*/("""</span>
              <div class="col-sm-12">
                <input type="text" id="nameContact" class="form-control" maxlength="100" autocomplete="off">
              </div>
            </div>

            <div class="row mb-1">
              <span class="col-sm-12 col-form-label">"""),_display_(/*21.55*/Messages("Số điện thoại")),format.raw/*21.80*/("""</span>
              <div class="col-sm-12">
                <input type="number" id="phoneContact" class="form-control" maxlength="11" autocomplete="off">
              </div>
            </div>

            <div class="row mb-1">
              <span class="col-sm-12 col-form-label">"""),_display_(/*28.55*/Messages("Email")),format.raw/*28.72*/("""</span>
              <div class="col-sm-12">
                <input type="text" id="emailContact" class="form-control" maxlength="100" autocomplete="off">
              </div>
            </div>

            <div class="row mb-1">
              <span class="col-sm-12 col-form-label">"""),_display_(/*35.55*/Messages("Tên công ty")),format.raw/*35.78*/("""</span>
              <div class="col-sm-12">
                <input type="text" id="companyContact" class="form-control" maxlength="255" autocomplete="off">
              </div>
            </div>

            <div class="row mb-4">
              <span class="col-sm-12 col-form-label">"""),_display_(/*42.55*/Messages("Nội dung tin nhắn")),format.raw/*42.84*/("""</span>
              <div class="col-sm-12">
                <textarea class="form-control" id="contentContact" maxlength="1000" rows="5" placeholder="...tối đa 1000 kí tự"></textarea>
              </div>
            </div>

            <div class="row mb-4">
              <div class="col-sm-12">
                <button type="button" class="btn btn-danger text-white" onclick="processSendContactMarket()" style="width: 100%;">
                """),_display_(/*51.18*/Messages("Gửi thông tin")),format.raw/*51.43*/(""" """),format.raw/*51.44*/("""<img src=""""),_display_(/*51.55*/routes/*51.61*/.Assets.versioned("images/market/Vector2.svg")),format.raw/*51.107*/("""" class="" alt="..." style="font-size: 14px;">
                </button>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div> <!-- modal-bialog .// -->
</div>
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
                  DATE: Mon Sep 22 16:32:41 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/amarket/marketPlace/detail/MarketPlaceDetail_contact.scala.html
                  HASH: 53a12e6a64e914f122e6a5a008e3389961f02ee8
                  MATRIX: 1077->0|1300->226|1337->331|1371->348|1404->355|1499->424|1552->457|1644->522|1726->582|1920->749|1959->767|2271->1052|2317->1077|2631->1364|2669->1381|2982->1667|3026->1690|3341->1978|3391->2007|3866->2455|3912->2480|3941->2481|3979->2492|3994->2498|4062->2544
                  LINES: 33->1|36->4|37->5|38->6|39->7|40->8|40->8|42->10|42->10|46->14|46->14|53->21|53->21|60->28|60->28|67->35|67->35|74->42|74->42|83->51|83->51|83->51|83->51|83->51|83->51
                  -- GENERATED --
              */
          