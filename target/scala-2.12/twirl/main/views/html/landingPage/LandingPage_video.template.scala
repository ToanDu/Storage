
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

object LandingPage_video extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="section features-1" id="video" style="background: #F8F6F3;">
  <div class="container">
    <div class="card-body">
        <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
          <ol class="carousel-indicators">
            <li data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"></li>
            <li data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"></li>
            <li data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"></li>
          </ol>
          <div class="carousel-inner1">

            <div class="carousel-item active" data-bs-interval="5000">
              <div class="row g-0 ">
                <div class="col-md-6">
                  <div class="card-body">
                    <h3 style="color: #000000; font-weight: 700;font-size: 32px;line-height: 44px;">"""),_display_(/*16.102*/Messages("Làm thế nào để tích hợp thiết bị lên nền tảng Innoway?")),format.raw/*16.168*/("""</h3>
                    <p class="mt-3">"""),_display_(/*17.38*/Messages("Trong video ngắn 10 phút này, bạn sẽ được hướng dẫn tích hợp Kit ESP32 lên trên nền tảng Innoway thông qua các bước:")),format.raw/*17.166*/("""</p>
                    <p class="mt-3">"""),_display_(/*18.38*/Messages("- Tạo một dự án trên Innoway ")),format.raw/*18.79*/("""</p>
                    <p class="mt-3">"""),_display_(/*19.38*/Messages("- Lấy thông tin cấu hình MQTT Broker")),format.raw/*19.86*/("""</p>
                    <p class="mt-3">"""),_display_(/*20.38*/Messages("- Tải SDK và Nạp Firmware cho thiết bị")),format.raw/*20.88*/("""</p>
                    <p class="mt-3">"""),_display_(/*21.38*/Messages("- Xem bản tin, dữ liệu gửi lên trên Web và Debug App chuyên biệt.")),format.raw/*21.115*/("""</p>
                  </div>
                </div>
                <div class="col-md-6" style="padding: 0;">
                  <iframe id="myVideo1" width="100%" height="456" src="https://www.youtube.com/embed/KvNhWGB5nuk?rel=1&amp;controls=1&amp;showinfo=0&amp;start=1&autoplay=0&enablejsapi=1"
                  frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
                </div>
    <!--                <div class="col-md-1"></div>-->
              </div>
            </div>

            <div class="carousel-item" data-bs-interval="5000">
              <div class="row g-0 ">
<!--                <div class="col-md-1"></div>-->
                <div class="col-md-6">
                  <div class="card-body">
                    <h3 style="color: #000000; font-weight: 600;font-size: 32px;line-height: 44px;">"""),_display_(/*37.102*/Messages("Hướng dẫn tích hợp giải pháp SmartFarm")),format.raw/*37.152*/("""</h3>
                  </div>
                </div>
                <div class="col-md-6" style="padding: 0;">
                  <iframe id="myVideo2" width="100%" height="456" src="https://www.youtube.com/embed/Cw0A-sDof3M?rel=1&amp;controls=1&amp;showinfo=0&amp;start=1&autoplay=0&enablejsapi=1"
                  frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
                </div>
<!--                <div class="col-md-1"></div>-->
              </div>
            </div>

            <div class="carousel-item" data-bs-interval="5000">
              <div class="row g-0 ">
<!--                <div class="col-md-1"></div>-->
                <div class="col-md-6">
                  <div class="card-body">
                    <h3 style="color: #000000; font-weight: 600;font-size: 32px;line-height: 44px;">"""),_display_(/*53.102*/Messages("Tích hợp thiết bị IoT outdoor lên nền tảng (dùng SIM)")),format.raw/*53.167*/("""</h3>
                  </div>
                </div>
                <div class="col-md-6" style="padding: 0;">
                  <iframe id="myVideo3" width="100%" height="456" src="https://www.youtube.com/embed/iKnUqAkxvuk?rel=1&amp;controls=1&amp;showinfo=0&amp;start=1&autoplay=0&enablejsapi=1"
                  frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
                </div>
                <div class="col-md-1"></div>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPage/LandingPage_video.scala.html
                  HASH: ef68fe25cf2c046ce8974518a1c2dfa37e0a5cdc
                  MATRIX: 1054->0|1959->877|2047->943|2117->986|2267->1114|2336->1156|2398->1197|2467->1239|2536->1287|2605->1329|2676->1379|2745->1421|2844->1498|3720->2346|3792->2396|4665->3241|4752->3306
                  LINES: 33->1|48->16|48->16|49->17|49->17|50->18|50->18|51->19|51->19|52->20|52->20|53->21|53->21|69->37|69->37|85->53|85->53
                  -- GENERATED --
              */
          