
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

object Navbar extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<!-- Navbar -->
<nav id="navbar-main" class="navbar navbar-main navbar-expand-lg navbar-transparent navbar-light py-2 text-white background-red">
  <div class="col-md-12">
    <div class="row navbar-container">
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar_global" aria-controls="navbar_global" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="navbar-collapse collapse" id="navbar_global">
        <div class="navbar-collapse-header">
          <div class="row">
            <div class="col-9 collapse-brand">
              <a style="font-weight: bold; color: red">
                """),_display_(/*15.18*/Messages("M2M Viettel")),format.raw/*15.41*/("""
              """),format.raw/*16.15*/("""</a>
            </div>
            <div class="col-3 collapse-close">
              <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbar_global" aria-controls="navbar_global" aria-expanded="false" aria-label="Toggle navigation">
                <span></span>
                <span></span>
              </button>
            </div>
          </div>
        </div>
        <ul class="navbar-nav navbar-nav-hover align-items-lg-center">
          <li class="nav-item dropdown navbar-logo nav-item-hide">
            <a class="navbar-brand mr-lg-5" href=""""),_display_(/*28.52*/routes/*28.58*/.LandingPageController.home()),format.raw/*28.87*/("""">
              <img src=""""),_display_(/*29.26*/routes/*29.32*/.Assets.versioned("images/telco/logo.svg")),format.raw/*29.74*/("""" style="height: 36px;">
            </a>
          </li>
          <li class="nav-item dropdown nav-item-hide">
            <a class="nav-link" role="button">
              <span class="nav-link-inner--text">"""),_display_(/*34.51*/Messages("")),format.raw/*34.63*/("""</span>
            </a>
          </li>
          <li class="nav-item dropdown nav-item-hide">
            <a class="nav-link" role="button">
              <span class="nav-link-inner--text">"""),_display_(/*39.51*/Messages("")),format.raw/*39.63*/("""</span>
            </a>
          </li>
          <li class="nav-item dropdown nav-item-hide">
            <a class="nav-link" role="button">
              <span class="nav-link-inner--text">"""),_display_(/*44.51*/Messages("")),format.raw/*44.63*/("""</span>
            </a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link" role="button" href=""""),_display_(/*48.54*/routes/*48.60*/.LandingPageController.home()),format.raw/*48.89*/("""">
              <span class="nav-link-inner--text">"""),_display_(/*49.51*/Messages("Giới thiệu")),format.raw/*49.73*/("""</span>
            </a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link" role="button" href=""""),_display_(/*53.54*/routes/*53.60*/.LandingPageController.landingPage()),format.raw/*53.96*/("""" target="_blank">
              <span class="nav-link-inner--text">"""),_display_(/*54.51*/Messages("IoT Platform")),format.raw/*54.75*/("""</span>
            </a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link" role="button" href=""""),_display_(/*58.54*/routes/*58.60*/.TelcoSubscriberController.subscriberManage(currentUser.getId)),format.raw/*58.122*/("""">
              <span class="nav-link-inner--text">"""),_display_(/*59.51*/Messages("Quản lý thuê bao")),format.raw/*59.79*/("""</span>
            </a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link" role="button" href=""""),_display_(/*63.54*/routes/*63.60*/.ProjectController.project()),format.raw/*63.88*/("""" target="_blank">
              <span class="nav-link-inner--text">"""),_display_(/*64.51*/Messages("Quản lý dự án")),format.raw/*64.76*/("""</span>
            </a>
          </li>
          <li class="nav-item dropdown">
            <a href="#" class="nav-link" data-toggle="dropdown" role="button">
              <span class="nav-link-inner--text">"""),_display_(/*69.51*/Messages("")),_display_(/*69.64*/currentUser/*69.75*/.getUsername),format.raw/*69.87*/("""</span> <i class="bx bx-caret-down text-black"></i>
            </a>
            <div class="dropdown-menu" style="z-index: 999;">
              """),_display_(/*72.16*/if(currentUser.getSystemRole == User.SystemRole.SYSTEM_ADMIN.getCode())/*72.87*/{_display_(Seq[Any](format.raw/*72.88*/("""
                """),format.raw/*73.17*/("""<a href=""""),_display_(/*73.27*/routes/*73.33*/.AdminOverviewController.adminOverview()),format.raw/*73.73*/("""" class="dropdown-item">"""),_display_(/*73.98*/Messages("Quản trị hệ thống ")),format.raw/*73.128*/("""</a>
              """)))}/*74.17*/else/*74.22*/{_display_(Seq[Any](format.raw/*74.23*/("""
                """),format.raw/*75.17*/("""<a href=""""),_display_(/*75.27*/routes/*75.33*/.ProductListController.productList(currentUser.getId)),format.raw/*75.86*/("""" class="dropdown-item">"""),_display_(/*75.111*/Messages("Quản lý sản phẩm ")),format.raw/*75.140*/("""</a>
              """)))}),format.raw/*76.16*/("""
              """),format.raw/*77.15*/("""<a href=""""),_display_(/*77.25*/routes/*77.31*/.Application.logout()),format.raw/*77.52*/("""" class="dropdown-item">"""),_display_(/*77.77*/Messages("Đăng xuất ")),format.raw/*77.99*/("""</a>
            </div>
          </li>
        </ul>
      </div>
    </div>
  </div>
</nav>
  <!-- End Navbar -->"""))
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/Navbar.scala.html
                  HASH: 39563d292903398b54ee6648449c568447480c8c
                  MATRIX: 657->1|993->35|1106->53|1133->54|1881->775|1925->798|1968->813|2585->1403|2600->1409|2650->1438|2705->1466|2720->1472|2783->1514|3020->1724|3053->1736|3273->1929|3306->1941|3526->2134|3559->2146|3721->2281|3736->2287|3786->2316|3866->2369|3909->2391|4071->2526|4086->2532|4143->2568|4239->2637|4284->2661|4446->2796|4461->2802|4545->2864|4625->2917|4674->2945|4836->3080|4851->3086|4900->3114|4996->3183|5042->3208|5280->3419|5313->3432|5333->3443|5366->3455|5539->3601|5619->3672|5658->3673|5703->3690|5740->3700|5755->3706|5816->3746|5868->3771|5920->3801|5959->3822|5972->3827|6011->3828|6056->3845|6093->3855|6108->3861|6182->3914|6235->3939|6286->3968|6337->3988|6380->4003|6417->4013|6432->4019|6474->4040|6526->4065|6569->4087
                  LINES: 24->1|29->2|34->2|35->3|47->15|47->15|48->16|60->28|60->28|60->28|61->29|61->29|61->29|66->34|66->34|71->39|71->39|76->44|76->44|80->48|80->48|80->48|81->49|81->49|85->53|85->53|85->53|86->54|86->54|90->58|90->58|90->58|91->59|91->59|95->63|95->63|95->63|96->64|96->64|101->69|101->69|101->69|101->69|104->72|104->72|104->72|105->73|105->73|105->73|105->73|105->73|105->73|106->74|106->74|106->74|107->75|107->75|107->75|107->75|107->75|107->75|108->76|109->77|109->77|109->77|109->77|109->77|109->77
                  -- GENERATED --
              */
          