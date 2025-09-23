
package views.html.dashboard

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

object SideMenu extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<!-- SIDE MENU -->
<div id="skin-select">
  <div id="logo">
    <h1>IoT
      <span>v1.1</span>
    </h1>
  </div>

  <a id="toggle">
    <span class="entypo-menu"></span>
  </a>
  <div class="dark">
    <form action="#">
      <span>
        <input type="text" name="search" value="" class="search rounded id_search" placeholder="Search Menu..." autofocus />
      </span>
    </form>
  </div>

  <div class="search-hover">
    <form id="demo-2">
      <input type="search" placeholder="Search Menu..." class="id_search">
    </form>
  </div>

  <div class="skin-part">
    <div id="tree-wrap">
      <div class="side-bar">
        <ul class="topnav menu-left-nest">
          <li>
            <a href="#" style="border-left:0px solid!important;" class="title-menu-left">
              <span class="design-kit"></span>
              <i data-toggle="tooltip" class="entypo-cog pull-right config-wrap"></i>
            </a>
          </li>

          <li>
            <a class="tooltip-tip ajax-load" href=""""),_display_(/*40.53*/routes/*40.59*/.DashboardController.dashboard()),format.raw/*40.91*/("""" title="Dashboard">
              <i class="icon-window"></i>
              <span>Dashboard</span>
            </a>
          </li>

          """),format.raw/*46.19*/("""
            """),format.raw/*47.116*/("""
              """),format.raw/*48.55*/("""
              """),format.raw/*49.59*/("""
            """),format.raw/*50.21*/("""
          """),format.raw/*51.20*/("""
          """),format.raw/*52.11*/("""<li>
            <a class="tooltip-tip ajax-load" href=""""),_display_(/*53.53*/routes/*53.59*/.UserController.userList()),format.raw/*53.85*/("""" title="User">
              <i class="icon-user"></i>
              <span>"""),_display_(/*55.22*/Messages("Manage Users")),format.raw/*55.46*/("""</span>
            </a>
          </li>
          <li>
            <a class="tooltip-tip ajax-load" href="" title="Mail">
              <i class="icon-mail"></i>
              <span>mail</span>
              <div class="noft-blue">289</div>
            </a>
          </li>

        </ul>


        <div class="side-dash">
          <h3>
            <span>Device</span>
          </h3>
          <ul class="side-dashh-list">
            <li>Avg.
              <span>25k<i style="color:#44BBC1;" class="fa fa-arrow-circle-up"></i>
                  </span>
            </li>
            <li>Visitors
              <span>80%<i style="color:#AB6DB0;" class="fa fa-arrow-circle-down"></i>
                  </span>
            </li>
            <li>Convertion Rate
              <span>13m<i style="color:#19A1F9;" class="fa fa-arrow-circle-up"></i>
                  </span>
            </li>
          </ul>
          <h3>
            <span>Statistical</span>
          </h3>
          <ul class="side-bar-list">
            <li>Avg.
              <div class="linebar">5,7,8,9,3,5,3,8,5</div>
            </li>
            <li>Visitors
              <div class="linebar2">9,7,8,9,5,9,6,8,7</div>
            </li>
            <li>Convertion Rate
              <div class="linebar3">5,7,8,9,3,5,3,8,5</div>
            </li>
          </ul>
          <h3>
            <span>Visitors</span>
          </h3>
          <div id="g1" style="height:180px" class="gauge"></div>
        </div>
      </div>
    </div>
  </div>
</div>
  <!-- END OF SIDE MENU -->"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:41 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/dashboard/SideMenu.scala.html
                  HASH: 750a19ca5f8b61df2e037775bbb0c6312d2b5a4e
                  MATRIX: 661->1|999->35|1112->53|1139->54|2173->1061|2188->1067|2241->1099|2413->1251|2455->1367|2498->1422|2541->1481|2582->1502|2621->1522|2660->1533|2744->1590|2759->1596|2806->1622|2910->1699|2955->1723
                  LINES: 24->1|29->2|34->2|35->3|72->40|72->40|72->40|78->46|79->47|80->48|81->49|82->50|83->51|84->52|85->53|85->53|85->53|87->55|87->55
                  -- GENERATED --
              */
          