
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

object LandingPage_overview extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="section section-hero section-shaped" id="divTongQuan" style="padding-bottom: 0rem;">

  <div class="shape shape-style-3 shape-default" >
    """),format.raw/*4.136*/("""
  """),format.raw/*5.3*/("""</div>
  <div id="carouselHeader" class="carousel slide" style="position: initial;" data-bs-ride="carousel">
    <ol class="carousel-indicators carousel-indicators-slider">
      <li data-bs-target="#carouselHeader" data-bs-slide-to="0" class="active"></li>
      <li data-bs-target="#carouselHeader" data-bs-slide-to="1"></li>
      <li data-bs-target="#carouselHeader" data-bs-slide-to="2"></li>
      <li data-bs-target="#carouselHeader" data-bs-slide-to="3"></li>
    </ol>
    <div class="carousel-inner">
      <div class="carousel-item active" data-bs-interval="5000">
        <div class="page-header">
          <div class="container shape-container py-lg">
            <div class="col px-0">
              <div class="row">
                <div class="col-lg-8">
                  <h3 class="title-img-1">"""),_display_(/*20.44*/Messages("InnoWay")),format.raw/*20.63*/("""</h3>
                  <h5 class="title-img-2">"""),_display_(/*21.44*/Messages("Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt")),format.raw/*21.122*/("""</h5>
                  <h4 class="title-img-3">"""),_display_(/*22.44*/Messages("KẾT NỐI VÔ HẠN, MỞ VẠN TIỀM NĂNG !")),format.raw/*22.90*/("""</h4>
                </div>
                <div class="col-lg-4">
                  <img class="imgSlider" src=""""),_display_(/*25.48*/routes/*25.54*/.Assets.versioned("images/landingPage/backgroup2.png")),format.raw/*25.108*/("""" width="100%">
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="carousel-item" data-bs-interval="5000">
        <div class="page-header">
          <div class="container shape-container py-lg">
            <div class="col px-0">
              <div class="row">
                <div class="col-lg-6">
                  <h3 class="title-img-1">"""),_display_(/*39.44*/Messages("InnoWay")),format.raw/*39.63*/("""</h3>
                  <h5 class="title-img-2">"""),_display_(/*40.44*/Messages("Giải pháp toàn diện cho các")),format.raw/*40.83*/("""</h5>
                  <h4 class="title-img-3">"""),_display_(/*41.44*/Messages("Nhà tích hợp & Nhà phát triển")),format.raw/*41.85*/("""</h4>
                  <div class="mt-3 buttonSlider">
                    <button class="btn " href=""""),_display_(/*43.49*/routes/*43.55*/.Application.register()),format.raw/*43.78*/("""" style="border-radius: 8px; background-color:#000000; color: white;">"""),_display_(/*43.149*/Messages("Đăng ký ngay")),format.raw/*43.173*/("""</button>
                  </div>
                </div>
                <div class="col-lg-4">
                  <img class="imgSlider" src=""""),_display_(/*47.48*/routes/*47.54*/.Assets.versioned("images/landingPage/imgSlide2.svg")),format.raw/*47.107*/("""" height="100%" width="100%">
                </div>
                <div class="col-lg-2"></div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="carousel-item" data-bs-interval="5000">
        <div class="page-header">
          <div class="container shape-container py-lg">
            <div class="col px-0">
              <div class="row">
                <div class="col-lg-6">
                  <h3 class="title-img-4">"""),_display_(/*62.44*/Messages("Nền tảng IoT InnoWay")),format.raw/*62.76*/("""</h3>
                  <h5 class="title-img-2">"""),_display_(/*63.44*/Messages("Quản lý thiết bị, thu thập, xử lý và hiển thị dữ liệu cho giải pháp IoT của bạn")),format.raw/*63.135*/("""</h5>
                  <div class="mt-3 buttonSlider">
                    <button class="btn" href=""""),_display_(/*65.48*/routes/*65.54*/.AppDebugController.solutionMaketPage()),format.raw/*65.93*/("""" target="_blank" style="border-radius: 8px; color: white; border: 1.4px solid white;">"""),_display_(/*65.181*/Messages("Tìm hiểu ngay")),format.raw/*65.206*/("""</button>
                  </div>
                </div>
                <div class="col-lg-5">
                  <img class="imgSlider" src=""""),_display_(/*69.48*/routes/*69.54*/.Assets.versioned("images/landingPage/imgS.svg")),format.raw/*69.102*/("""" height="100%" width="100%">
                </div>
                <div class="col-lg-1"></div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="carousel-item" data-bs-interval="5000">
        <div class="page-header">
          <div class="container shape-container py-lg">
            <div class="col px-0">
              <div class="row">
                <div class="col-lg-7">
                  <h3 class="title-img-3">"""),_display_(/*84.44*/Messages("Giải pháp thông minh")),format.raw/*84.76*/("""</h3>
                  <h5 class="title-img-4">"""),_display_(/*85.44*/Messages("cho Nhà phát triển ứng dụng IoT")),format.raw/*85.87*/("""</h5>
                  <div class="mt-4 buttonSlider">
                    <button class="btn " href=""""),_display_(/*87.49*/routes/*87.55*/.Application.register()),format.raw/*87.78*/("""" style="border-radius: 8px; background-color:#000000; color: white;">"""),_display_(/*87.149*/Messages("Đăng ký ngay")),format.raw/*87.173*/("""</button>
                  </div>
                </div>
                <div class="col-lg-5">
                  <img class="imgSlider" src=""""),_display_(/*91.48*/routes/*91.54*/.Assets.versioned("images/landingPage/backgroup3.png")),format.raw/*91.108*/("""" height="100%" width="100%">
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
                  DATE: Mon Sep 22 16:32:47 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPage/LandingPage_overview.scala.html
                  HASH: e3dcd9124eb8aa72201884c58f0a6a73806120e6
                  MATRIX: 1057->0|1238->284|1267->287|2109->1102|2149->1121|2225->1170|2325->1248|2401->1297|2468->1343|2610->1458|2625->1464|2701->1518|3150->1940|3190->1959|3266->2008|3326->2047|3402->2096|3464->2137|3595->2241|3610->2247|3654->2270|3753->2341|3799->2365|3970->2509|3985->2515|4060->2568|4568->3049|4621->3081|4697->3130|4810->3221|4940->3324|4955->3330|5015->3369|5131->3457|5178->3482|5349->3626|5364->3632|5434->3680|5942->4161|5995->4193|6071->4242|6135->4285|6266->4389|6281->4395|6325->4418|6424->4489|6470->4513|6641->4657|6656->4663|6732->4717
                  LINES: 33->1|36->4|37->5|52->20|52->20|53->21|53->21|54->22|54->22|57->25|57->25|57->25|71->39|71->39|72->40|72->40|73->41|73->41|75->43|75->43|75->43|75->43|75->43|79->47|79->47|79->47|94->62|94->62|95->63|95->63|97->65|97->65|97->65|97->65|97->65|101->69|101->69|101->69|116->84|116->84|117->85|117->85|119->87|119->87|119->87|119->87|119->87|123->91|123->91|123->91
                  -- GENERATED --
              */
          