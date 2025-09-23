
package views.html.landingPage

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

object LandingPage_download_vtag extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="downloadVtagModal" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: inherit;">
        <h5 class="modal-title" id="exampleModalLabel" style="font-weight: 500; color: #000000;">"""),_display_(/*5.99*/Messages("Tải ứng dụng IOS / Android ")),format.raw/*5.138*/("""</h5>
        <i class="bx bx-x btn-close" data-bs-dismiss="modal" aria-label="Close" style="font-size: 20px; cursor: pointer;"></i>
      </div>
      <div class="modal-body" style="padding: 25px 25px 0px 25px;">
        <p style="font-weight: 700;font-size: 36px;line-height: 44px;letter-spacing: 1px;color: #EE0033;">"""),_display_(/*9.108*/Messages("vTag Viettel - Thiết bị định vị thông minh")),format.raw/*9.162*/("""</p>
        <p>"""),_display_(/*10.13*/Messages("- Định vị thông minh vTag là thiết bị sử dụng công nghệ NB-IoT có hỗ trợ định vị 3 trong 1 (GPS, Wifi, Mobile Cell) để phát hiện chuyển động và gửi thông tin vị trí của đối tượng sử dụng.")),format.raw/*10.212*/("""</p>
        <p>"""),_display_(/*11.13*/Messages("- vTag giúp chúng ta đễ dàng quản lý, theo dõi vị trí của trẻ em, người già, thú cưng, đồ vật và xe cộ. Với nhiều chức năng khác nhau, phù hợp với nhiều đối tượng khác nhau.")),format.raw/*11.198*/("""</p>
        <div class="row">
          <div class="col-md-6">
            <div class="row">
              <div class="col-md-6 mt-3">
                <img src=""""),_display_(/*16.28*/routes/*16.34*/.Assets.versioned("images/landingPage/downloadSmh1.png")),format.raw/*16.90*/("""">
              </div>
              <div class="col-md-6 mt-3">
                <img src=""""),_display_(/*19.28*/routes/*19.34*/.Assets.versioned("images/landingPage/downloadSmh2.png")),format.raw/*19.90*/("""">
              </div>
              <div class="col-md-12 mt-3">
              """),_display_(/*22.16*/Messages("Hoặc quét QR")),format.raw/*22.40*/("""
              """),format.raw/*23.15*/("""</div>
              <div class="col-md-6 mt-3">
                <img src=""""),_display_(/*25.28*/routes/*25.34*/.Assets.versioned("images/landingPage/downloadVtag1.svg")),format.raw/*25.91*/("""">
                <p>"""),_display_(/*26.21*/Messages("Download  bản IOS")),format.raw/*26.50*/("""</p>
              </div>
              <div class="col-md-6 mt-3">
                <img src=""""),_display_(/*29.28*/routes/*29.34*/.Assets.versioned("images/landingPage/downloadVtag2.svg")),format.raw/*29.91*/("""">
                <p>"""),_display_(/*30.21*/Messages("Download  bản Android")),format.raw/*30.54*/("""</p>
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <img src=""""),_display_(/*35.24*/routes/*35.30*/.Assets.versioned("images/landingPage/downloadVtag1.png")),format.raw/*35.87*/("""" width="100%">
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
                  DATE: Mon Sep 22 16:32:47 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPage/LandingPage_download_vtag.scala.html
                  HASH: 1cedfca637e5a9dedb82a5d3cddbac8b377fb1ec
                  MATRIX: 1062->0|1429->341|1489->380|1837->701|1912->755|1956->772|2177->971|2221->988|2428->1173|2618->1336|2633->1342|2710->1398|2830->1491|2845->1497|2922->1553|3031->1635|3076->1659|3119->1674|3222->1750|3237->1756|3315->1813|3365->1836|3415->1865|3537->1960|3552->1966|3630->2023|3680->2046|3734->2079|3879->2197|3894->2203|3972->2260
                  LINES: 33->1|37->5|37->5|41->9|41->9|42->10|42->10|43->11|43->11|48->16|48->16|48->16|51->19|51->19|51->19|54->22|54->22|55->23|57->25|57->25|57->25|58->26|58->26|61->29|61->29|61->29|62->30|62->30|67->35|67->35|67->35
                  -- GENERATED --
              */
          