
package views.html.telco

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

object Footer extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="section features-1" style="background-color: #3A3A3A; border-top: 3px solid #EA0033;">
  <div class="navbar-container">
    <div class="row">
      <div class="col-md-2">
        <div class="">
          <img src=""""),_display_(/*6.22*/routes/*6.28*/.Assets.versioned("images/telco/viettel.svg")),format.raw/*6.73*/("""" alt="..." class="card-img">
        </div>
      </div>
      <div class="col-md-6 mt-3">
        <div class="">
          <span class="footer-text-1">"""),_display_(/*11.40*/Messages("Tổng Công ty Viễn thông Viettel (Viettel Telecom)")),format.raw/*11.101*/("""</span>
          <br>
          <span class="footer-text-2">"""),_display_(/*13.40*/Messages("Mã số doanh nghiệp: 0100109106-011 do Sở Kế hoạch và Đầu tư Thành phố Hà Nội cấp lần đầu ngày 18/07/2005, sửa đổi lần thứ 15 ngày 18/12/2018")),format.raw/*13.192*/("""</span>
          <br>
          <span class="footer-text-2">"""),_display_(/*15.40*/Messages("Chịu trách nhiệm nội dung: Ông Cao Anh Sơn")),format.raw/*15.94*/("""</span>
        </div>
      </div>
      <div class="col-md-1"></div>
      <div class="col-md-3 mt-3">
        <div class="">
          <div>
            <a href="mailto: cskh@viettel.com.vn" target="_blank">
              <img src=""""),_display_(/*23.26*/routes/*23.32*/.Assets.versioned("images/telco/cskh.svg")),format.raw/*23.74*/("""" alt="..." width="32">
              <span class="footer-text-3">"""),_display_(/*24.44*/Messages("cskh@viettel.com.vn")),format.raw/*24.75*/("""</span>
            </a>
          </div>
          <div style="margin-top: 15px;">
            <a href="tel: 0869999904" target="_blank">
              <img src=""""),_display_(/*29.26*/routes/*29.32*/.Assets.versioned("images/telco/phone.svg")),format.raw/*29.75*/("""" alt="..." width="32">
              <span class="footer-text-3">"""),_display_(/*30.44*/Messages("0869999904")),format.raw/*30.66*/("""</span>
            </a>
          </div>
        </div>
      </div>
    </div>
    <hr style="border-top: 1px solid #4D4D4D;">

    <div class="row">
      <div class="col-md-6">
        <span class="footer-text-4">"""),_display_(/*40.38*/Messages("Copyright Viettel Telecom 2022")),format.raw/*40.80*/("""</span>
      </div>
      <div class="col-md-6" style="text-align: right;">
        <span class="footer-text-4">"""),_display_(/*43.38*/Messages("Follow us: ")),format.raw/*43.61*/("""</span>
        <a href="https://www.facebook.com/innoway.vn/" class="fa fa-facebook-square" target="_blank" style="font-size: 23px; color: #B1B1B1; "></a>
        <a href="https://twitter.com/VInnoway" class="fa fa-twitter-square" target="_blank" style="font-size: 23px; color: #B1B1B1; margin-left: 10px;"></a>
        <a href="https://www.instagram.com/innoway.vn/" class="fa fa-instagram" target="_blank" style="font-size: 23px; color: #B1B1B1; margin-left: 10px;"></a>
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
                  DATE: Mon Sep 22 16:32:49 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/Footer.scala.html
                  HASH: a5b3b12358f250f0de4606c6e8a9a1b2f82b40da
                  MATRIX: 1037->0|1290->227|1304->233|1369->278|1550->432|1633->493|1722->555|1896->707|1985->769|2060->823|2323->1060|2338->1066|2401->1108|2495->1175|2547->1206|2738->1370|2753->1376|2817->1419|2911->1486|2954->1508|3199->1726|3262->1768|3403->1882|3447->1905
                  LINES: 33->1|38->6|38->6|38->6|43->11|43->11|45->13|45->13|47->15|47->15|55->23|55->23|55->23|56->24|56->24|61->29|61->29|61->29|62->30|62->30|72->40|72->40|75->43|75->43
                  -- GENERATED --
              */
          