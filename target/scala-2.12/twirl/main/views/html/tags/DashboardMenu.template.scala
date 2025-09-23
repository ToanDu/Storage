
package views.html.tags

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
/*1.2*/import play.mvc.Http._
/*2.2*/import vn.m2m.common.models.User
/*3.2*/import vn.m2m.utils.UserHelper

object DashboardMenu extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.20*/("""
"""),format.raw/*5.1*/("""<div class="sidebar" data-color="rose" data-background-color="black" data-image=""""),_display_(/*5.83*/routes/*5.89*/.Assets.versioned("images/sidebar.jpg")),format.raw/*5.128*/("""">
    <div class="logo">
        <a href="" class="simple-text logo-mini">
            IP
        </a>
        <a href="" class="simple-text logo-normal">
            IoT Platform
        </a>
    </div>
    <div class="sidebar-wrapper">
        <div class="user">
            <div class="photo">
                <img src=""""),_display_(/*17.28*/routes/*17.34*/.Assets.versioned("images/iot.png")),format.raw/*17.69*/("""" />
            </div>
            <div class="user-info">
                <a data-toggle="collapse" href="#collapseExample" class="username">
                    <span>
                        """),_display_(/*22.26*/currentUser/*22.37*/.getUsername),format.raw/*22.49*/("""
                        """),format.raw/*23.25*/("""<b class="caret"></b>
                    </span>
                </a>
                <div class="collapse" id="collapseExample">
                    <ul class="nav">
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <span class="sidebar-mini"> MP </span>
                                <span class="sidebar-normal"> My Profile </span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <span class="sidebar-mini"> EP </span>
                                <span class="sidebar-normal"> Edit Profile </span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <span class="sidebar-mini"> S </span>
                                <span class="sidebar-normal"> Settings </span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <ul class="nav">
            <li class="nav-item" id="menu-manageUser">
                <a class="nav-link" href=""""),_display_(/*52.44*/routes/*52.50*/.UserController.userList()),format.raw/*52.76*/("""">
                    <i class="fa fa-user"></i>
                    <p> """),_display_(/*54.26*/Messages("Manage User")),format.raw/*54.49*/(""" """),format.raw/*54.50*/("""</p>
                </a>
            </li>

            <li class="nav-item ">
                <a class="nav-link" href=""""),_display_(/*59.44*/routes/*59.50*/.Application.logout()),format.raw/*59.71*/("""">
                    <i class="fa fa-sign-out"></i>
                    <p> """),_display_(/*61.26*/Messages("Logout")),format.raw/*61.44*/(""" """),format.raw/*61.45*/("""</p>
                </a>
            </li>
        </ul>
    </div>
</div>"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:49 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/tags/DashboardMenu.scala.html
                  HASH: b8f117d2f5fe67197780247337a3ad9e7561a0d5
                  MATRIX: 656->1|686->25|726->59|1067->91|1180->109|1207->110|1315->192|1329->198|1389->237|1741->562|1756->568|1812->603|2035->799|2055->810|2088->822|2141->847|3498->2177|3513->2183|3560->2209|3662->2284|3706->2307|3735->2308|3885->2431|3900->2437|3942->2458|4048->2537|4087->2555|4116->2556
                  LINES: 24->1|25->2|26->3|31->4|36->4|37->5|37->5|37->5|37->5|49->17|49->17|49->17|54->22|54->22|54->22|55->23|84->52|84->52|84->52|86->54|86->54|86->54|91->59|91->59|91->59|93->61|93->61|93->61
                  -- GENERATED --
              */
          