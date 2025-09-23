
package views.html.amarket

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
/*1.2*/import vn.m2m.common.models.User

object header extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<header>
    <div class="topbar d-flex align-items-center" style="background: #10375C; border-radius: 8px 0px 0px 0px;">
        <nav class="navbar navbar-expand">
            <div class="mobile-toggle-menu"><i class='bx bx-menu'></i>
            </div>

            <div class="top-menu ms-auto">
                <ul class="navbar-nav align-items-center">
                    <li class="nav-item dropdown dropdown-large">
                        """),format.raw/*12.202*/("""
                            """),format.raw/*13.92*/("""
                        """),format.raw/*14.33*/("""
                    """),format.raw/*15.21*/("""</li>
                </ul>
            </div>
            <div class="user-box dropdown">
                <a class="d-flex align-items-center nav-link dropdown-toggle dropdown-toggle-nocaret" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <img src=""""),_display_(/*20.32*/routes/*20.38*/.Assets.versioned("images/avatar_small2x.jpg")),format.raw/*20.84*/("""" class="user-img" alt="user avatar">
                    <div class="user-info ps-3">
                        <p class="user-name mb-0 text-white">"""),_display_(/*22.63*/currentUser/*22.74*/.getUsername),format.raw/*22.86*/("""</p>
                    </div>
                </a>
                <ul class="dropdown-menu dropdown-menu-end">
                    <li><a class="dropdown-item" href=""""),_display_(/*26.57*/routes/*26.63*/.LandingPageController.home()),format.raw/*26.92*/(""""><i class="bx bx-home"></i><span>"""),_display_(/*26.127*/Messages("Trang chủ")),format.raw/*26.148*/("""</span></a>
                    </li>
                    <li><a class="dropdown-item" href=""""),_display_(/*28.57*/routes/*28.63*/.ProjectController.project()),format.raw/*28.91*/(""""><i class="bx bx-cog"></i><span>"""),_display_(/*28.125*/Messages("Danh sách dự án")),format.raw/*28.152*/("""</span></a>
                    </li>
                    """),format.raw/*30.29*/("""
                        """),format.raw/*31.70*/("""
                    """),format.raw/*32.30*/("""
                    """),format.raw/*33.21*/("""<li><a class="dropdown-item" href=""""),_display_(/*33.57*/routes/*33.63*/.Application.logout()),format.raw/*33.84*/(""""><i class='bx bx-log-out-circle'></i><span>Logout</span></a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</header>
"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:40 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/amarket/header.scala.html
                  HASH: 94da2a9d41a4ae6aa3b5e369df7120c7302245bb
                  MATRIX: 659->1|995->35|1108->53|1135->54|1611->678|1668->770|1721->803|1770->824|2093->1120|2108->1126|2175->1172|2351->1321|2371->1332|2404->1344|2601->1514|2616->1520|2666->1549|2729->1584|2772->1605|2893->1699|2908->1705|2957->1733|3019->1767|3068->1794|3154->1860|3207->1930|3256->1960|3305->1981|3368->2017|3383->2023|3425->2044
                  LINES: 24->1|29->2|34->2|35->3|44->12|45->13|46->14|47->15|52->20|52->20|52->20|54->22|54->22|54->22|58->26|58->26|58->26|58->26|58->26|60->28|60->28|60->28|60->28|60->28|62->30|63->31|64->32|65->33|65->33|65->33|65->33
                  -- GENERATED --
              */
          