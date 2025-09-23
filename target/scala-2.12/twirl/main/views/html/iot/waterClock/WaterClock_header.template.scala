
package views.html.iot.waterClock

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

object WaterClock_header extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<header>
    <div class="topbar d-flex align-items-center" style="background: #585757; border-radius: 8px 0px 0px 0px;">
        <nav class="navbar navbar-expand">
            <div class="mobile-toggle-menu"><i class='bx bx-menu'></i>
            </div>

            <div class="top-menu ms-auto">
                <ul class="navbar-nav align-items-center">
                    <li class="nav-item dropdown dropdown-large">
                        <a class="nav-link dropdown-toggle dropdown-toggle-nocaret position-relative text-white" href="https://hoangpm11.gitbook.io/innoway" target="_blank" style="font-size: 18px">
                            <i class='bx bx-notepad'></i>"""),_display_(/*11.59*/Messages("Hướng dẫn sử dụng")),format.raw/*11.88*/("""
                        """),format.raw/*12.25*/("""</a>
                    </li>


                    <li class="nav-item dropdown dropdown-large" style="margin-left: 10px">
                        <a class="nav-link dropdown-toggle dropdown-toggle-nocaret position-relative text-white" style="font-size: 18px">
                            <img src=""""),_display_(/*18.40*/routes/*18.46*/.Assets.versioned("images/overview/config.svg")),format.raw/*18.93*/(""""> <span>"""),_display_(/*18.103*/Messages("Cài đặt")),format.raw/*18.122*/("""</span>
                        </a>
                    </li>
                    <li class="nav-item dropdown dropdown-large" style="margin-left: 10px">
                        <a class="nav-link dropdown-toggle dropdown-toggle-nocaret position-relative text-white" style="font-size: 18px">
                            <img src=""""),_display_(/*23.40*/routes/*23.46*/.Assets.versioned("images/overview/cskh.svg")),format.raw/*23.91*/(""""> <span>"""),_display_(/*23.101*/Messages("Hỗ trợ")),format.raw/*23.119*/("""</span>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="user-box dropdown">
                <a class="d-flex align-items-center nav-link dropdown-toggle dropdown-toggle-nocaret" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <img src=""""),_display_(/*30.32*/routes/*30.38*/.Assets.versioned("images/avatar_small2x.jpg")),format.raw/*30.84*/("""" class="user-img" alt="user avatar">
                    <div class="user-info ps-3">
                        <p class="user-name mb-0 text-white">admin</p>
"""),format.raw/*33.83*/("""
                    """),format.raw/*34.21*/("""</div>
                </a>
                <ul class="dropdown-menu dropdown-menu-end">
                    <li><a class="dropdown-item" href=""""),_display_(/*37.57*/routes/*37.63*/.LandingPageController.home()),format.raw/*37.92*/(""""><i class="bx bx-home"></i><span>"""),_display_(/*37.127*/Messages("Trang chủ")),format.raw/*37.148*/("""</span></a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</header>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:46 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/waterClock/WaterClock_header.scala.html
                  HASH: ab159907374ea035a49759d9e1e55f419c8c8013
                  MATRIX: 1057->0|1763->679|1813->708|1866->733|2195->1035|2210->1041|2278->1088|2316->1098|2357->1117|2716->1449|2731->1455|2797->1500|2835->1510|2875->1528|3255->1881|3270->1887|3337->1933|3523->2173|3572->2194|3744->2339|3759->2345|3809->2374|3872->2409|3915->2430
                  LINES: 33->1|43->11|43->11|44->12|50->18|50->18|50->18|50->18|50->18|55->23|55->23|55->23|55->23|55->23|62->30|62->30|62->30|65->33|66->34|69->37|69->37|69->37|69->37|69->37
                  -- GENERATED --
              */
          