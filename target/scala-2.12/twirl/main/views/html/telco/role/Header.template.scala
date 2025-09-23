
package views.html.telco.role

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
          <img src=""""),_display_(/*19.22*/routes/*19.28*/.Assets.versioned("images/avatarDefault.png")),format.raw/*19.73*/("""" class="user-img" alt="user avatar">
          <div class="user-info ps-3">
            <p class="user-name mb-0 text-black">"""),_display_(/*21.51*/currentUser/*21.62*/.getUsername),format.raw/*21.74*/("""</p>
          </div>
        </a>
        <ul class="dropdown-menu dropdown-menu-end">
          <li><a class="dropdown-item" href=""""),_display_(/*25.47*/routes/*25.53*/.LandingPageController.home()),format.raw/*25.82*/("""" target="_blank"><i class="bx bx-home"></i><span>"""),_display_(/*25.133*/Messages("header.nav.home")),format.raw/*25.160*/("""</span></a>
          </li>
          <li>
            <a class="dropdown-item" href=""""),_display_(/*28.45*/routes/*28.51*/.ProjectController.project()),format.raw/*28.79*/("""" target="_blank"><i class="bx bx-cog"></i><span> """),_display_(/*28.130*/Messages("header.nav.projectManagement")),format.raw/*28.170*/("""</span></a>
          </li>
          <li>
            <a href=""""),_display_(/*31.23*/routes/*31.29*/.TelcoRoleAccountController.accountList()),format.raw/*31.70*/("""" target="_blank" class="dropdown-item"><i class="bx bx-credit-card"></i> """),_display_(/*31.145*/Messages("header.nav.telcoManagement")),format.raw/*31.183*/("""</a>
          </li>
          <li>
            <a href=""""),_display_(/*34.23*/routes/*34.29*/.ProductListController.productList(currentUser.getId)),format.raw/*34.82*/("""" target="_blank" class="dropdown-item"><i class="bx bx-devices"></i> """),_display_(/*34.153*/Messages("header.nav.productManagement")),format.raw/*34.193*/("""</a>
          </li>
          <li><a class="dropdown-item" href="javascript:;"><i class='bx bx-vector'></i><span>"""),_display_(/*36.95*/Messages("header.info.version")),_display_(/*36.127*/currentUser/*36.138*/.getVersion),format.raw/*36.149*/("""</span></a>
          </li>
          <li><a class="dropdown-item" href=""""),_display_(/*38.47*/routes/*38.53*/.Application.logout()),format.raw/*38.74*/(""""><i class='bx bx-log-out-circle'></i><span>"""),_display_(/*38.119*/Messages("header.user.logout")),format.raw/*38.149*/("""</span></a>
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
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/Header.scala.html
                  HASH: 95c6a46a7c5123818c7c233470d3ea62f0691167
                  MATRIX: 662->1|998->35|1111->53|1138->54|1999->888|2014->894|2080->939|2234->1066|2254->1077|2287->1089|2448->1223|2463->1229|2513->1258|2592->1309|2641->1336|2755->1423|2770->1429|2819->1457|2898->1508|2960->1548|3052->1613|3067->1619|3129->1660|3232->1735|3292->1773|3377->1831|3392->1837|3466->1890|3565->1961|3627->2001|3769->2116|3822->2148|3843->2159|3876->2170|3977->2244|3992->2250|4034->2271|4107->2316|4159->2346
                  LINES: 24->1|29->2|34->2|35->3|51->19|51->19|51->19|53->21|53->21|53->21|57->25|57->25|57->25|57->25|57->25|60->28|60->28|60->28|60->28|60->28|63->31|63->31|63->31|63->31|63->31|66->34|66->34|66->34|66->34|66->34|68->36|68->36|68->36|68->36|70->38|70->38|70->38|70->38|70->38
                  -- GENERATED --
              */
          