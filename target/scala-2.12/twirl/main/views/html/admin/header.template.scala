
package views.html.admin

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
                        """),format.raw/*13.202*/("""
                            """),format.raw/*14.92*/("""
                        """),format.raw/*15.33*/("""
                    """),format.raw/*16.21*/("""</li>
                </ul>
            </div>
            <div class="user-box dropdown">
                <a class="d-flex align-items-center nav-link dropdown-toggle dropdown-toggle-nocaret" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <img src=""""),_display_(/*21.32*/routes/*21.38*/.Assets.versioned("images/avatar_small2x.jpg")),format.raw/*21.84*/("""" class="user-img" alt="user avatar">
                    <div class="user-info ps-3">
                        <p class="user-name mb-0 text-white">"""),_display_(/*23.63*/currentUser/*23.74*/.getUsername),format.raw/*23.86*/("""</p>
                    </div>
                </a>
                <ul class="dropdown-menu dropdown-menu-end">
                    <li><a class="dropdown-item" href=""""),_display_(/*27.57*/routes/*27.63*/.LandingPageController.home()),format.raw/*27.92*/("""" target="_blank"><i class="bx bx-home"></i><span>"""),_display_(/*27.143*/Messages("Trang chủ")),format.raw/*27.164*/("""</span></a>
                    </li>
                    <li>
                        <a class="dropdown-item" href=""""),_display_(/*30.57*/routes/*30.63*/.AdminTelcoController.approvedInfoCompanyTelco()),format.raw/*30.111*/("""" target="_blank">
                            <i class="bx bx-list-ol"></i><span>"""),_display_(/*31.65*/Messages("Quản lý doanh nghiệp")),format.raw/*31.97*/("""</span>
                        </a>
                    </li>
                    <li>
                        <div class="dropdown-divider mb-0"></div>
                    </li>
                    <li><a class="dropdown-item" href=""""),_display_(/*37.57*/routes/*37.63*/.Application.logout()),format.raw/*37.84*/(""""><i class='bx bx-log-out-circle'></i><span>Logout</span></a>
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
                  DATE: Mon Sep 22 16:32:39 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/admin/header.scala.html
                  HASH: 07146cb4a80fd7760d4763d57e73e27ec216ec47
                  MATRIX: 657->1|993->35|1106->53|1133->54|1610->679|1667->771|1720->804|1769->825|2092->1121|2107->1127|2174->1173|2350->1322|2370->1333|2403->1345|2600->1515|2615->1521|2665->1550|2744->1601|2787->1622|2933->1741|2948->1747|3018->1795|3128->1878|3181->1910|3444->2146|3459->2152|3501->2173
                  LINES: 24->1|29->2|34->2|35->3|45->13|46->14|47->15|48->16|53->21|53->21|53->21|55->23|55->23|55->23|59->27|59->27|59->27|59->27|59->27|62->30|62->30|62->30|63->31|63->31|69->37|69->37|69->37
                  -- GENERATED --
              */
          