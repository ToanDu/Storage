
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
/*1.2*/import vn.m2m.utils.UserHelper
/*2.2*/import vn.m2m.common.models.User

object Menu extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser: User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.21*/("""
"""),format.raw/*4.1*/("""<div class="sidebar" data-color="azure" data-image=""""),_display_(/*4.54*/routes/*4.60*/.Assets.versioned("images/lightdashboard/faces/face-0.jpg")),format.raw/*4.119*/("""">

        <!--

        Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
        Tip 2: you can also add an image using data-image tag

    -->


    <div class="logo">
        <a href=""""),_display_(/*15.19*/routes/*15.25*/.Application.login()),format.raw/*15.45*/("""" class="logo-text">
        """),_display_(/*16.10*/Messages("Admin.menu.Title")),format.raw/*16.38*/("""
        """),format.raw/*17.9*/("""</a>
    </div>

    <div class="sidebar-wrapper">

        <div class="user">
            <div class="photo">
                <img src="" onerror="this.src='"""),_display_(/*24.49*/routes/*24.55*/.Assets.versioned("images/lightdashboard/default-avatar.jpg")),format.raw/*24.116*/("""'" alt="..."/>
            </div>
            <div class="info">
                <a data-toggle="collapse" href="#collapseExample" class="collapsed">
                    """),_display_(/*28.22*/currentUser/*28.33*/.getEmail),format.raw/*28.42*/("""
                    """),format.raw/*29.21*/("""<b class="caret"></b>
                </a>
                <div class="collapse" id="collapseExample">
                    <ul class="nav">
                        """),format.raw/*33.124*/("""
                        """),format.raw/*34.25*/("""<li><a href=""""),_display_(/*34.39*/routes/*34.45*/.Application.logout()),format.raw/*34.66*/("""">"""),_display_(/*34.69*/Messages("nav.Logout")),format.raw/*34.91*/("""</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <ul class="nav" style="margin-bottom: 50px">

        </ul>
    </div>
</div>

"""))
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/tags/Menu.scala.html
                  HASH: 48a94eda1eb6c4aea2fe373f8aaae5608f790052
                  MATRIX: 656->1|694->33|1028->67|1142->86|1169->87|1248->140|1262->146|1342->205|1621->457|1636->463|1677->483|1734->513|1783->541|1819->550|2005->709|2020->715|2103->776|2301->947|2321->958|2351->967|2400->988|2593->1251|2646->1276|2687->1290|2702->1296|2744->1317|2774->1320|2817->1342
                  LINES: 24->1|25->2|30->3|35->3|36->4|36->4|36->4|36->4|47->15|47->15|47->15|48->16|48->16|49->17|56->24|56->24|56->24|60->28|60->28|60->28|61->29|65->33|66->34|66->34|66->34|66->34|66->34|66->34
                  -- GENERATED --
              */
          