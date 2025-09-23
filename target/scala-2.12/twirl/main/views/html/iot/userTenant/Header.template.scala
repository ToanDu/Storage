
package views.html.iot.userTenant

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
            <div class="mobile-toggle-menu"><i class='bx bx-menu'></i>
            </div>
            <div class="top-menu ms-auto">
                <ul class="navbar-nav align-items-center">
                    <li class="nav-item dropdown dropdown-large">
                        <a class="nav-link dropdown-toggle dropdown-toggle-nocaret position-relative text-white" style="font-size: 18px">

                        </a>
                    </li>
                </ul>
            </div>
            <div class="user-box dropdown">
                <a class="d-flex align-items-center nav-link dropdown-toggle dropdown-toggle-nocaret" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <img src=""""),_display_(/*19.32*/routes/*19.38*/.Assets.versioned("images/avatarDefault.png")),format.raw/*19.83*/("""" class="user-img" alt="user avatar">
                    <div class="user-info ps-3">
                        <p class="user-name mb-0 text-black">"""),_display_(/*21.63*/currentUser/*21.74*/.getUsername),format.raw/*21.86*/("""</p>
                    </div>
                </a>
                <ul class="dropdown-menu dropdown-menu-end">
                    <li><a class="dropdown-item" href=""""),_display_(/*25.57*/routes/*25.63*/.LandingPageController.home()),format.raw/*25.92*/("""" target="_blank"><i class="bx bx-home"></i><span>"""),_display_(/*25.143*/Messages("header.nav.home")),format.raw/*25.170*/("""</span></a>
                    </li>
                    <li>
                        <a class="dropdown-item" href=""""),_display_(/*28.57*/routes/*28.63*/.ProjectController.project()),format.raw/*28.91*/("""" target="_blank"><i class="bx bx-cog"></i><span> """),_display_(/*28.142*/Messages("header.nav.projectManagement")),format.raw/*28.182*/("""</span></a>
                    </li>
                    <li>
                        <a href=""""),_display_(/*31.35*/routes/*31.41*/.TelcoSubscriberController.subscriberManage(currentUser.getId)),format.raw/*31.103*/("""" target="_blank" class="dropdown-item"><i class="bx bx-credit-card"></i> """),_display_(/*31.178*/Messages("header.nav.telcoManagement")),format.raw/*31.216*/("""</a>
                    </li>
                    <li>
                        <a href=""""),_display_(/*34.35*/routes/*34.41*/.ProductListController.productList(currentUser.getId)),format.raw/*34.94*/("""" target="_blank" class="dropdown-item"><i class="bx bx-devices"></i> """),_display_(/*34.165*/Messages("header.nav.productManagement")),format.raw/*34.205*/("""</a>
                    </li>
                    <li><a class="dropdown-item" href="javascript:;"><i class='bx bx-vector'></i><span>"""),_display_(/*36.105*/Messages("header.info.version")),_display_(/*36.137*/currentUser/*36.148*/.getVersion),format.raw/*36.159*/("""</span></a>
                    </li>
                    <li><a class="dropdown-item" href=""""),_display_(/*38.57*/routes/*38.63*/.Application.logout()),format.raw/*38.84*/(""""><i class='bx bx-log-out-circle'></i><span>"""),_display_(/*38.129*/Messages("header.user.logout")),format.raw/*38.159*/("""</span></a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</header>"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:46 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/userTenant/Header.scala.html
                  HASH: d3054cebf830d15d12a01e2a51b389f1a0e24966
                  MATRIX: 666->1|1002->35|1115->53|1142->54|2116->1001|2131->1007|2197->1052|2373->1201|2393->1212|2426->1224|2623->1394|2638->1400|2688->1429|2767->1480|2816->1507|2962->1626|2977->1632|3026->1660|3105->1711|3167->1751|3291->1848|3306->1854|3390->1916|3493->1991|3553->2029|3670->2119|3685->2125|3759->2178|3858->2249|3920->2289|4083->2424|4136->2456|4157->2467|4190->2478|4311->2572|4326->2578|4368->2599|4441->2644|4493->2674
                  LINES: 24->1|29->2|34->2|35->3|51->19|51->19|51->19|53->21|53->21|53->21|57->25|57->25|57->25|57->25|57->25|60->28|60->28|60->28|60->28|60->28|63->31|63->31|63->31|63->31|63->31|66->34|66->34|66->34|66->34|66->34|68->36|68->36|68->36|68->36|70->38|70->38|70->38|70->38|70->38
                  -- GENERATED --
              */
          