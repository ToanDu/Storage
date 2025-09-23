
package views.html.amarket

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

object navbar extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<div class="wrapper">
    <div class="sidebar-wrapper" data-simplebar="true" style="background-color: #F4F5F6;">
        <div class="sidebar-header" style="background-color: white;">
            <div>
                <img src=""""),_display_(/*7.28*/routes/*7.34*/.Assets.versioned("images/dashboard/logo.svg")),format.raw/*7.80*/("""" class="logo-icon" alt="logo icon" style="width: 150px; margin-left: 35px;">
            </div>
            <div class="toggle-icon ms-auto" id="arrowMenu" style="display: none"><i class='bx bx-arrow-to-left'></i>
            </div>
        </div>
            <!--navigation-->
        <ul class="metismenu" id="menu">
            <li class="menu-label">Market Place</li>
            <li id="menu-product">
                <a href=""""),_display_(/*16.27*/routes/*16.33*/.ProductListController.productList(currentUser.getId)),format.raw/*16.86*/("""">
                    <div class="parent-icon">
                        <i class="bx bx-devices"></i>
                    </div>
                    <div class="menu-title">"""),_display_(/*20.46*/Messages("Quản lý sản phẩm")),format.raw/*20.74*/("""</div>
                </a>
            </li>

            <li>
                <a href=""""),_display_(/*25.27*/routes/*25.33*/.Application.logout()),format.raw/*25.54*/("""">
                    <div class="parent-icon">
                        <i class='bx bx-log-out'></i>
                    </div>
                    <div class="menu-title">"""),_display_(/*29.46*/Messages("manage.logout")),format.raw/*29.71*/("""</div>
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
                  DATE: Mon Sep 22 16:32:40 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/amarket/navbar.scala.html
                  HASH: b3c05c7ffaf44a8572dcdb83ef2befdbd7cac6b9
                  MATRIX: 659->1|995->35|1108->53|1135->54|1389->282|1403->288|1469->334|1930->768|1945->774|2019->827|2221->1002|2270->1030|2387->1120|2402->1126|2444->1147|2646->1322|2692->1347
                  LINES: 24->1|29->2|34->2|35->3|39->7|39->7|39->7|48->16|48->16|48->16|52->20|52->20|57->25|57->25|57->25|61->29|61->29
                  -- GENERATED --
              */
          