
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

object LandingPage_develop extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="section features-1" id="divDeveloper">
  <div class="container">
    <div class="col-md-12 mx-auto text-center">
      <h3 class="display-32 title-section-1" >"""),_display_(/*4.48*/Messages("Công cụ lập trình mạnh mẽ")),format.raw/*4.85*/("""</h3>
      <hr style="border-top: 4px solid red; width: 84px; margin-top: 1rem;">
    </div>
    <div class="row">
      <div class="col-md-4">
        <div class="card">
          <div class="alignItemCenter">
            <img src=""""),_display_(/*11.24*/routes/*11.30*/.Assets.versioned("images/landingPage/develop1.png")),format.raw/*11.82*/("""" width="100%">
          </div>
          <div class="text mt-3 p-3">
            <h3 class="text mt-3">"""),_display_(/*14.36*/Messages("Dashboard")),format.raw/*14.57*/("""</h3>
            <p class="mt-3">"""),_display_(/*15.30*/Messages("Tạo các bảng điều khiển để hiển thị dữ liệu thiết bị theo các dạng biểu đồ, bản đồ, bảng thống kê,... theo nhu cầu sử dụng của nhà phát triển.")),format.raw/*15.184*/("""</p>
          </div>
        </div>
      </div>

      <div class="col-md-4" style="margin-top: 3rem !important;">
        <div class="card">
          <div class="alignItemCenter">
            <img src=""""),_display_(/*23.24*/routes/*23.30*/.Assets.versioned("images/landingPage/develop2.png")),format.raw/*23.82*/("""" width="100%">
          </div>
          <div class="text mt-3 p-3">
            <h3 class="text mt-3">"""),_display_(/*26.36*/Messages("Management")),format.raw/*26.58*/("""</h3>
            <p class="mt-3">"""),_display_(/*27.30*/Messages("Tạo các bảng điều khiển để hiển thị dữ liệu thiết bị theo các dạng biểu đồ, bản đồ, bảng thống kê,... theo nhu cầu sử dụng của nhà phát triển.")),format.raw/*27.184*/("""</p>
          </div>
        </div>
      </div>

      <div class="col-md-4" style="margin-top: 6rem !important;">
        <div class="card">
          <div class="alignItemCenter">
            <img src=""""),_display_(/*35.24*/routes/*35.30*/.Assets.versioned("images/landingPage/develop3.png")),format.raw/*35.82*/("""" width="100%">
          </div>
          <div class="text mt-3 p-3">
            <h3 class="text mt-3">"""),_display_(/*38.36*/Messages("Flow Engine")),format.raw/*38.59*/("""</h3>
            <p class="mt-3">"""),_display_(/*39.30*/Messages("Người dùng tạo các luồng xử lý nghiệp vụ cho các bản tin từ thiết bị: tạo bộ quan sát, cảnh báo, thao tác gửi SMS/Email hoặc gọi sang các hệ thống bên ngoài.")),format.raw/*39.199*/("""</p>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPage/LandingPage_develop.scala.html
                  HASH: 8d842f272bd1ac830340bc1f22b90fd796e0e219
                  MATRIX: 1056->0|1254->172|1311->209|1573->444|1588->450|1661->502|1794->608|1836->629|1898->664|2074->818|2308->1025|2323->1031|2396->1083|2529->1189|2572->1211|2634->1246|2810->1400|3044->1607|3059->1613|3132->1665|3265->1771|3309->1794|3371->1829|3562->1998
                  LINES: 33->1|36->4|36->4|43->11|43->11|43->11|46->14|46->14|47->15|47->15|55->23|55->23|55->23|58->26|58->26|59->27|59->27|67->35|67->35|67->35|70->38|70->38|71->39|71->39
                  -- GENERATED --
              */
          