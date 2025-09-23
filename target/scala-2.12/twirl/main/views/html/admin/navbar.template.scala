
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

object navbar extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="wrapper">
  <div class="sidebar-wrapper" data-simplebar="true" style="background-color: #F4F5F6;">
    <div class="sidebar-header" style="background-color: white;">
      <div>
        <img src=""""),_display_(/*5.20*/routes/*5.26*/.Assets.versioned("images/dashboard/logo.svg")),format.raw/*5.72*/("""" class="logo-icon" alt="logo icon" style="width: 150px; margin-left: 35px;">
      </div>
      <div class="toggle-icon ms-auto" id="arrowMenu" style="display: none"><i class='bx bx-arrow-to-left'></i>
      </div>
    </div>
      <!--navigation-->
    <ul class="metismenu" id="menu">

      <li id="menu-adminOverview">
        <a href=""""),_display_(/*14.19*/routes/*14.25*/.AdminOverviewController.adminOverview()),format.raw/*14.65*/("""">
          <div class="parent-icon">
            <i class="bx bx-desktop"></i>
          </div>
          <div class="menu-title">"""),_display_(/*18.36*/Messages("Tổng quan hệ thống")),format.raw/*18.66*/("""</div>
        </a>
      </li>

      <li id="menu-adminSystemHealth">
        <a href=""""),_display_(/*23.19*/routes/*23.25*/.AdminSystemHealthController.systemHealth()),format.raw/*23.68*/("""">
          <div class="parent-icon">
            <i class="bx bx-home-heart"></i>
          </div>
          <div class="menu-title">"""),_display_(/*27.36*/Messages("Sức khoẻ hệ thống")),format.raw/*27.65*/("""</div>
        </a>
      </li>

      """),format.raw/*31.40*/("""
        """),format.raw/*32.73*/("""
          """),format.raw/*33.40*/("""
            """),format.raw/*34.51*/("""
          """),format.raw/*35.21*/("""
          """),format.raw/*36.70*/("""
        """),format.raw/*37.17*/("""
      """),format.raw/*38.16*/("""

      """),format.raw/*40.7*/("""<li id="menu-templateDevice">
        <a href=""""),_display_(/*41.19*/routes/*41.25*/.TemplateDeviceController.templateDeviceList()),format.raw/*41.71*/("""">
          <div class="parent-icon">
            <i class="bx bx-devices"></i>
          </div>
          <div class="menu-title">"""),_display_(/*45.36*/Messages("Quản lý mẫu thiết bị ")),format.raw/*45.69*/("""</div>
        </a>
      </li>

      <li id="menu-registerDeveloper">
        <a href=""""),_display_(/*50.19*/routes/*50.25*/.AdminRegisterDeveloperController.registerDeveloperList()),format.raw/*50.82*/("""">
          <div class="parent-icon">
            <i class="bx bx-list-check"></i>
          </div>
          <div class="menu-title">"""),_display_(/*54.36*/Messages("DS Đăng kí Developer ")),format.raw/*54.69*/("""</div>
        </a>
      </li>

      <li id="menu-groupProduct">
        <a href=""""),_display_(/*59.19*/routes/*59.25*/.AdminGroupProductController.groupProductList()),format.raw/*59.72*/("""">
          <div class="parent-icon">
            <i class="bx bxl-product-hunt"></i>
          </div>
          <div class="menu-title">"""),_display_(/*63.36*/Messages("Quản lý nhóm sản phẩm")),format.raw/*63.69*/("""</div>
        </a>
      </li>

      <li id="menu-manageProduct">
        <a href=""""),_display_(/*68.19*/routes/*68.25*/.ProductListController.manageProductList()),format.raw/*68.67*/("""">
          <div class="parent-icon">
            <i class="bx bx-package"></i>
          </div>
          <div class="menu-title">"""),_display_(/*72.36*/Messages("Quản lý sản phẩm")),format.raw/*72.64*/("""</div>
        </a>
      </li>

      <li id="menu-manageContact">
        <a href=""""),_display_(/*77.19*/routes/*77.25*/.MarketPlaceContactController.productContactList()),format.raw/*77.75*/("""">
          <div class="parent-icon">
            <i class="bx bx-credit-card"></i>
          </div>
          <div class="menu-title">"""),_display_(/*81.36*/Messages("Quản lý liên hệ")),format.raw/*81.63*/("""</div>
        </a>
      </li>

      <li id="">
        <a href=""""),_display_(/*86.19*/routes/*86.25*/.AdminTelcoController.approvedInfoCompanyTelco()),format.raw/*86.73*/("""">
          <div class="parent-icon">
            <i class="bx bx-store"></i>
          </div>
          <div class="menu-title">"""),_display_(/*90.36*/Messages("Quản lý doanh nghiệp")),format.raw/*90.68*/("""</div>
        </a>
      </li>

      <li>
        <a href=""""),_display_(/*95.19*/routes/*95.25*/.Application.logout()),format.raw/*95.46*/("""">
          <div class="parent-icon">
            <i class='bx bx-log-out'></i>
          </div>
          <div class="menu-title">"""),_display_(/*99.36*/Messages("manage.logout")),format.raw/*99.61*/("""</div>
        </a>
      </li>
    </ul>
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
                  DATE: Mon Sep 22 16:32:40 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/admin/navbar.scala.html
                  HASH: bdf2a6e6aec8c3e37461ef819afbe841624849df
                  MATRIX: 1037->0|1271->208|1285->214|1351->260|1720->602|1735->608|1796->648|1956->781|2007->811|2124->901|2139->907|2203->950|2366->1086|2416->1115|2483->1187|2520->1260|2559->1300|2600->1351|2639->1372|2678->1442|2715->1459|2750->1475|2785->1483|2860->1531|2875->1537|2942->1583|3102->1716|3156->1749|3273->1839|3288->1845|3366->1902|3529->2038|3583->2071|3695->2156|3710->2162|3778->2209|3944->2348|3998->2381|4111->2467|4126->2473|4189->2515|4349->2648|4398->2676|4511->2762|4526->2768|4597->2818|4761->2955|4809->2982|4904->3050|4919->3056|4988->3104|5146->3235|5199->3267|5288->3329|5303->3335|5345->3356|5505->3489|5551->3514
                  LINES: 33->1|37->5|37->5|37->5|46->14|46->14|46->14|50->18|50->18|55->23|55->23|55->23|59->27|59->27|63->31|64->32|65->33|66->34|67->35|68->36|69->37|70->38|72->40|73->41|73->41|73->41|77->45|77->45|82->50|82->50|82->50|86->54|86->54|91->59|91->59|91->59|95->63|95->63|100->68|100->68|100->68|104->72|104->72|109->77|109->77|109->77|113->81|113->81|118->86|118->86|118->86|122->90|122->90|127->95|127->95|127->95|131->99|131->99
                  -- GENERATED --
              */
          