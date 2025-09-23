
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

object Menu extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<div class="wrapper">
    <div class="sidebar-wrapper" data-simplebar="true" style="background-image: url("""),_display_(/*4.86*/routes/*4.92*/.Assets.versioned("images/telco/menu.png")),format.raw/*4.134*/("""">
        <div class="sidebar-header" style="background-color: #940e15;">
            <a class="cursor-pointer" href=""""),_display_(/*6.46*/routes/*6.52*/.LandingPageController.home()),format.raw/*6.81*/("""">
                <img src=""""),_display_(/*7.28*/routes/*7.34*/.Assets.versioned("images/telco/viettel2.svg")),format.raw/*7.80*/("""" class="logo-icon" alt="logo icon" style="width: 150px; margin-left: 35px;">
            </a>
            <div class="toggle-icon ms-auto" id="arrowMenu" style="display: none"><i class='bx bx-arrow-to-left'></i>
            </div>
        </div>
            <!--navigation-->
        <ul class="metismenu" id="menu">
            <li id="menu-userTenantList">
                <a href=""""),_display_(/*15.27*/routes/*15.33*/.UserTenantListController.userTenantList()),format.raw/*15.75*/("""" class="text-white">
                    <div class="parent-icon"><i class='bx bx-line-chart'></i></div>
                    <div class="menu-title">"""),_display_(/*17.46*/Messages("Quản lý User Tenant")),format.raw/*17.77*/("""</div>
                </a>
            </li>

        </ul>
    </div>
</div>
<script src=""""),_display_(/*24.15*/routes/*24.21*/.Assets.versioned("javascripts/menu.js")),format.raw/*24.61*/("""" type="text/javascript"></script>"""))
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/userTenant/Menu.scala.html
                  HASH: 16256516d2740ed8c8603f990ed0581d23dd097c
                  MATRIX: 666->1|1000->35|1113->53|1140->54|1273->161|1287->167|1350->209|1496->329|1510->335|1559->364|1615->394|1629->400|1695->446|2108->832|2123->838|2186->880|2364->1031|2416->1062|2536->1155|2551->1161|2612->1201
                  LINES: 24->1|29->2|34->2|35->3|36->4|36->4|36->4|38->6|38->6|38->6|39->7|39->7|39->7|47->15|47->15|47->15|49->17|49->17|56->24|56->24|56->24
                  -- GENERATED --
              */
          