
package views.html.amarket.marketPlace

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

object MarketPlace_background extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="section section-hero section-shaped" id="divTongQuan" style="padding-bottom: 0rem;">

  <div class="shape shape-style-3 shape-default" >
    """),format.raw/*4.136*/("""
  """),format.raw/*5.3*/("""</div>
  <div id="carouselHeader" class="carousel slide" style="position: initial;" data-bs-ride="carousel">
    <ol class="carousel-indicators">
      <li data-bs-target="#carouselHeader" data-bs-slide-to="0" class="active"></li>
      <li data-bs-target="#carouselHeader" data-bs-slide-to="1"></li>
    </ol>
    <div class="carousel-inner">
      <div class="carousel-item active" data-bs-interval="5000">
        <div class="page-header">
          <div class="container shape-container d-flex align-items-center py-lg">
            <div class="col px-0">
              <div class="row align-items-center justify-content-center">
                <div class="col-lg-8">
                  <h3 class="display-1 text-white">"""),_display_(/*18.53*/Messages("InnoWay")),format.raw/*18.72*/("""</h3>
                  <h5 class="display-4 font-weight-normal text-white mt-4">"""),_display_(/*19.77*/Messages("Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt")),format.raw/*19.155*/("""</h5>
                  <h4 class="display-3 text-white mt-4">"""),_display_(/*20.58*/Messages("KẾT NỐI VÔ HẠN, MỞ VẠN TIỀM NĂNG ! ")),format.raw/*20.105*/("""</h4>
                </div>
                <div class="col-lg-4">
                  <img class="mt-3" src=""""),_display_(/*23.43*/routes/*23.49*/.Assets.versioned("images/landingPage/backgroup2.png")),format.raw/*23.103*/("""" width="100%">
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="carousel-item" data-bs-interval="5000">
        <div class="page-header">
          <div class="container shape-container d-flex align-items-center py-lg">
            <div class="col px-0">
              <div class="row align-items-center justify-content-center">
                <div class="col-lg-8">
                  <h3 class="display-1 text-white">"""),_display_(/*37.53*/Messages("Nền tảng IoT InnoWay")),format.raw/*37.85*/("""</h3>
                  <h5 class="display-4 font-weight-normal text-white mt-4">"""),_display_(/*38.77*/Messages("Quản lý thiết bị, thu thập, xử lý và hiển thị dữ liệu cho giải pháp IoT của bạn")),format.raw/*38.168*/("""</h5>
                  <button class="btn mt-4" style="border-radius: 8px; color: white; border: 1.4px solid white;">"""),_display_(/*39.114*/Messages("Tìm hiểu ngay")),format.raw/*39.139*/("""</button>
                </div>
                <div class="col-lg-4">
                  <img class="mt-3" src=""""),_display_(/*42.43*/routes/*42.49*/.Assets.versioned("images/landingPage/backgroup4.png")),format.raw/*42.103*/("""" width="100%">
                </div>
              </div>
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
                  DATE: Mon Sep 22 16:32:40 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/amarket/marketPlace/MarketPlace_background.scala.html
                  HASH: d083f1098968216c7e1ddb2f8ef394e6bdcb95a5
                  MATRIX: 1067->0|1248->284|1277->287|2029->1012|2069->1031|2178->1113|2278->1191|2368->1254|2437->1301|2574->1411|2589->1417|2665->1471|3191->1970|3244->2002|3353->2084|3466->2175|3613->2294|3660->2319|3801->2433|3816->2439|3892->2493
                  LINES: 33->1|36->4|37->5|50->18|50->18|51->19|51->19|52->20|52->20|55->23|55->23|55->23|69->37|69->37|70->38|70->38|71->39|71->39|74->42|74->42|74->42
                  -- GENERATED --
              */
          