
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
/*1.2*/import vn.m2m.common.models.User

object Header extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<header>
    <div class="topbar d-flex align-items-center" style="background-color: #940e15;">
        <nav class="navbar navbar-expand" style="border-radius: 0px 0px 0px 0px; background-color: #ffffff;">
            <div class="mobile-toggle-menu"><i class='bx bx-menu'></i></div>

            <div class="top-menu ms-auto">
                <ul class="navbar-nav align-items-center">
                    <!-- Nút đổi ngôn ngữ -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-black" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            🌐
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end">
                            <li>
                                <a class="dropdown-item" href=""""),_display_(/*17.65*/routes/*17.71*/.Application.setLang("vi")),format.raw/*17.97*/("""">🇻🇳 Tiếng Việt</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href=""""),_display_(/*20.65*/routes/*20.71*/.Application.setLang("uk")),format.raw/*20.97*/("""">🇺🇸 English</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>

            <div class="user-box dropdown">
                <a class="d-flex align-items-center nav-link dropdown-toggle dropdown-toggle-nocaret" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <img src=""""),_display_(/*29.32*/routes/*29.38*/.Assets.versioned("images/avatarDefault.png")),format.raw/*29.83*/("""" class="user-img" alt="user avatar">
                    <div class="user-info ps-3">
                        <p class="user-name mb-0 text-black">"""),_display_(/*31.63*/currentUser/*31.74*/.getUsername),format.raw/*31.86*/("""</p>
                    </div>
                </a>
                <ul class="dropdown-menu dropdown-menu-end">
                    <li><a class="dropdown-item" href=""""),_display_(/*35.57*/routes/*35.63*/.LandingPageController.home()),format.raw/*35.92*/("""" target="_blank"><i class="bx bx-home"></i><span>"""),_display_(/*35.143*/Messages("header.nav.home")),format.raw/*35.170*/("""</span></a>
                    </li>
                    <li>
                        <a class="dropdown-item" href=""""),_display_(/*38.57*/routes/*38.63*/.ProjectController.project()),format.raw/*38.91*/("""" target="_blank"><i class="bx bx-cog"></i><span> """),_display_(/*38.142*/Messages("header.nav.projectManagement")),format.raw/*38.182*/("""</span></a>
                    </li>
                    <li>
                        <a href=""""),_display_(/*41.35*/routes/*41.41*/.TelcoSubscriberController.subscriberManage(currentUser.getId)),format.raw/*41.103*/("""" target="_blank" class="dropdown-item"><i class="bx bx-credit-card"></i> """),_display_(/*41.178*/Messages("header.nav.telcoManagement")),format.raw/*41.216*/("""</a>
                    </li>
                    <li>
                        <a href=""""),_display_(/*44.35*/routes/*44.41*/.ProductListController.productList(currentUser.getId)),format.raw/*44.94*/("""" target="_blank" class="dropdown-item"><i class="bx bx-devices"></i> """),_display_(/*44.165*/Messages("header.nav.productManagement")),format.raw/*44.205*/("""</a>
                    </li>
                    <li>
                        <a href=""""),_display_(/*47.35*/routes/*47.41*/.TelcoApiKeyController.apiKeyManage(currentUser.getId)),format.raw/*47.95*/("""" target="_blank" class="dropdown-item"><i class="bx bx-key"></i> """),_display_(/*47.162*/Messages("header.nav.apiKeyManagement")),format.raw/*47.201*/("""</a>
                    </li>
                    <li><a class="dropdown-item" href="javascript:;"><i class='bx bx-vector'></i><span>"""),_display_(/*49.105*/Messages("header.info.version")),_display_(/*49.137*/currentUser/*49.148*/.getVersion),format.raw/*49.159*/("""</span></a>
                    </li>
                    <li><a class="dropdown-item" href=""""),_display_(/*51.57*/routes/*51.63*/.Application.logout()),format.raw/*51.84*/(""""><i class='bx bx-log-out-circle'></i><span>"""),_display_(/*51.129*/Messages("header.user.logout")),format.raw/*51.159*/("""</span></a>
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
                  DATE: Mon Sep 22 16:32:50 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/Header.scala.html
                  HASH: f990f1e9cfb4e800748a6bfc5c87bbfc0fedfe6f
                  MATRIX: 657->1|993->35|1106->53|1133->54|2011->905|2026->911|2073->937|2253->1090|2268->1096|2315->1122|2742->1522|2757->1528|2823->1573|2999->1722|3019->1733|3052->1745|3249->1915|3264->1921|3314->1950|3393->2001|3442->2028|3588->2147|3603->2153|3652->2181|3731->2232|3793->2272|3917->2369|3932->2375|4016->2437|4119->2512|4179->2550|4296->2640|4311->2646|4385->2699|4484->2770|4546->2810|4663->2900|4678->2906|4753->2960|4848->3027|4909->3066|5072->3201|5125->3233|5146->3244|5179->3255|5300->3349|5315->3355|5357->3376|5430->3421|5482->3451
                  LINES: 24->1|29->2|34->2|35->3|49->17|49->17|49->17|52->20|52->20|52->20|61->29|61->29|61->29|63->31|63->31|63->31|67->35|67->35|67->35|67->35|67->35|70->38|70->38|70->38|70->38|70->38|73->41|73->41|73->41|73->41|73->41|76->44|76->44|76->44|76->44|76->44|79->47|79->47|79->47|79->47|79->47|81->49|81->49|81->49|81->49|83->51|83->51|83->51|83->51|83->51
                  -- GENERATED --
              */
          