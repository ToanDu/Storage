
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

object Title extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User, title: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.35*/("""
"""),format.raw/*3.1*/("""<!--TITLE -->
<div class="row">
  <div id="paper-top">
    <div class="col-sm-4">
      <h2 class="tittle-content-header">
        <i class="icon-window"></i>
        <span>Dashboard
        </span>
      </h2>
    </div>
    <div class="col-sm-8">
      <div class="devider-vertical visible-lg"></div>
      <div class="tittle-middle-header">
        <div class="alert">
          <button type="button" class="close" data-dismiss="alert">×</button>
          <span class="tittle-alert entypo-info-circled"></span>
          Welcome back,&nbsp;
          <strong>"""),_display_(/*20.20*/currentUser/*20.31*/.getUsername),_display_(/*20.44*/Messages("!")),format.raw/*20.57*/("""</strong>&nbsp;&nbsp;Your last sig in at Yesterday, 16:54 PM
        </div>
      </div>
    </div>
  </div>
</div>
  <!--/ TITLE -->

  <!-- BREADCRUMB -->
<ul id="breadcrumb">
  <li>
    <span class="entypo-home"></span>
  </li>
  <li><i class="fa fa-lg fa-angle-right"></i>
  </li>
  <li><a href="" title="Dashboard">"""),_display_(/*35.37*/title),format.raw/*35.42*/("""</a>
  </li>
  <li class="pull-right">
    <div class="input-group input-widget">
      <input style="border-radius:15px" type="text" placeholder="Search..." class="form-control">
    </div>
  </li>
</ul>
  <!-- END OF BREADCRUMB -->"""))
      }
    }
  }

  def render(currentUser:User,title:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,title)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,title) => apply(currentUser,title)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:41 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/dashboard/Title.scala.html
                  HASH: 54dab6a977f4eff039f65cea43b6f5acce7bfb06
                  MATRIX: 661->1|1003->35|1131->68|1158->69|1749->633|1769->644|1802->657|1836->670|2184->991|2210->996
                  LINES: 24->1|29->2|34->2|35->3|52->20|52->20|52->20|52->20|67->35|67->35
                  -- GENERATED --
              */
          