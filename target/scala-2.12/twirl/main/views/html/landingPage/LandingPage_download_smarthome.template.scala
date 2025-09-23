
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

object LandingPage_download_smarthome extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="downloadSmarthomeModal" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: inherit;">
        <h5 class="modal-title" id="exampleModalLabel" style="font-weight: 500; color: #000000;">"""),_display_(/*5.99*/Messages("Tải ứng dụng IOS / Android ")),format.raw/*5.138*/("""</h5>
        <i class="bx bx-x btn-close" data-bs-dismiss="modal" aria-label="Close" style="font-size: 20px; cursor: pointer;"></i>
      </div>
      <div class="modal-body" style="padding: 25px 25px 0px 25px;">
        <p style="font-weight: 700;font-size: 36px;line-height: 44px;letter-spacing: 1px;color: #EE0033;">"""),_display_(/*9.108*/Messages("VHome - Viettel Smart Home")),format.raw/*9.146*/("""</p>
        <p>"""),_display_(/*10.13*/Messages("VHome là ứng dụng giám sát camera, giúp người dùng dễ dàng quản lý từ xa ở mọi nơi bất cứ thời gian nào.")),format.raw/*10.129*/("""</p>

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
                """),_display_(/*22.18*/Messages("Hoặc quét QR")),format.raw/*22.42*/("""
              """),format.raw/*23.15*/("""</div>
              <div class="col-md-6 mt-3">
                <img src=""""),_display_(/*25.28*/routes/*25.34*/.Assets.versioned("images/landingPage/downloadSmh3.svg")),format.raw/*25.90*/("""">
                <p>"""),_display_(/*26.21*/Messages("Download  bản IOS")),format.raw/*26.50*/("""</p>
              </div>
              <div class="col-md-6 mt-3">
                <img src=""""),_display_(/*29.28*/routes/*29.34*/.Assets.versioned("images/landingPage/downloadSmh4.svg")),format.raw/*29.90*/("""">
                <p>"""),_display_(/*30.21*/Messages("Download  bản Android")),format.raw/*30.54*/("""</p>
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <img src=""""),_display_(/*35.24*/routes/*35.30*/.Assets.versioned("images/landingPage/downloadSmh5.png")),format.raw/*35.86*/("""" width="100%">
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPage/LandingPage_download_smarthome.scala.html
                  HASH: bb3f20ee484a5b1fa7cc1af2de4c005ea4c72b31
                  MATRIX: 1067->0|1439->346|1499->385|1847->706|1906->744|1950->761|2088->877|2279->1041|2294->1047|2371->1103|2491->1196|2506->1202|2583->1258|2694->1342|2739->1366|2782->1381|2885->1457|2900->1463|2977->1519|3027->1542|3077->1571|3199->1666|3214->1672|3291->1728|3341->1751|3395->1784|3540->1902|3555->1908|3632->1964
                  LINES: 33->1|37->5|37->5|41->9|41->9|42->10|42->10|48->16|48->16|48->16|51->19|51->19|51->19|54->22|54->22|55->23|57->25|57->25|57->25|58->26|58->26|61->29|61->29|61->29|62->30|62->30|67->35|67->35|67->35
                  -- GENERATED --
              */
          