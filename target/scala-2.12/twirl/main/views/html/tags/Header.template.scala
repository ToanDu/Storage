
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
/*1.2*/import vn.m2m.common.models.User

object Header extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User, string: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.36*/("""
"""),format.raw/*3.1*/("""<!-- START HEADER -->
<nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
  <div class="container-fluid">
    <div class="navbar-wrapper">
      <div class="navbar-minimize">
        <button id="minimizeSidebar" class="btn btn-just-icon btn-white btn-fab btn-round">
          <i class="material-icons text_align-center visible-on-sidebar-regular">more_vert</i>
          <i class="material-icons design_bullet-list-67 visible-on-sidebar-mini">view_list</i>
        </button>
      </div>
      <a class="navbar-brand" style="color: #005bab !important; font-weight: bold;">"""),_display_(/*13.86*/string),format.raw/*13.92*/("""</a>
    </div>
    <button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
      <span class="sr-only">Toggle navigation</span>
      <span class="navbar-toggler-icon icon-bar"></span>
      <span class="navbar-toggler-icon icon-bar"></span>
      <span class="navbar-toggler-icon icon-bar"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end">

      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="">
            <i class="material-icons">dashboard</i>
            <p class="d-lg-none d-md-block">
              Stats
            </p>
          </a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link" href="" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="material-icons">notifications</i>
            <span class="notification">5</span>
            <p class="d-lg-none d-md-block">
              Some Actions
            </p>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
            <a class="dropdown-item" href="">Mike John responded to your email</a>
            <a class="dropdown-item" href="">You have 5 new tasks</a>
            <a class="dropdown-item" href="">You're now friend with Andrew</a>
            <a class="dropdown-item" href="">Another Notification</a>
            <a class="dropdown-item" href="">Another One</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link" href="" id="navbarDropdownProfile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="material-icons">person</i>
            <p class="d-lg-none d-md-block">
              Account
            </p>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownProfile">
            <a class="dropdown-item" href="">Profile</a>
            <a class="dropdown-item" href="">Settings</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href=""""),_display_(/*59.45*/routes/*59.51*/.Application.logout()),format.raw/*59.72*/("""">"""),_display_(/*59.75*/Messages("header.user.logout")),format.raw/*59.105*/("""</a>
          </div>
        </li>
      </ul>
    </div>
  </div>
</nav>
"""))
      }
    }
  }

  def render(currentUser:User,string:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,string)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,string) => apply(currentUser,string)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:49 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/tags/Header.scala.html
                  HASH: bec5ba2f9c67ed27b5836d0240e811438fb0e701
                  MATRIX: 656->1|999->35|1128->69|1155->70|1788->676|1815->682|4079->2919|4094->2925|4136->2946|4166->2949|4218->2979
                  LINES: 24->1|29->2|34->2|35->3|45->13|45->13|91->59|91->59|91->59|91->59|91->59
                  -- GENERATED --
              */
          