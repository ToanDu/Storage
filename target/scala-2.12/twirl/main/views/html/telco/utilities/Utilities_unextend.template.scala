
package views.html.telco.utilities

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
/*2.2*/import vn.m2m.utils.UserHelper

object Utilities_unextend extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.20*/("""
"""),format.raw/*4.1*/("""<div class="accordion-body">
  <div class="card-header-primary card-header-icon">
    <div class="toolbar" style="float: left">
      <button class="btn btn-title">
      """),_display_(/*8.8*/Messages("utilities.cancelRenewalDataPackage")),format.raw/*8.54*/("""
      """),format.raw/*9.7*/("""</button>
    </div>
    <div class="toolbar" style="float: right">
      <button class="btn px-4 button-light" onclick="openSubMiAddonModal('dataImportMiAddOnCancelExtendPack')">
      """),_display_(/*13.8*/Messages("utilities.loadSubscriberList")),format.raw/*13.48*/("""
      """),format.raw/*14.7*/("""</button>

      """),_display_(/*16.8*/if(UserHelper.isFeatureRole(currentUser, "cancel_extend"))/*16.66*/{_display_(Seq[Any](format.raw/*16.67*/("""
        """),format.raw/*17.9*/("""<button class="btn px-4 button-light" id="" onclick="getListPackUnextend()" data-bs-toggle="modal" data-bs-target="#unextendMiAddonModal">
        """),_display_(/*18.10*/Messages("utilities.cancelRenewalAction")),format.raw/*18.51*/("""
        """),format.raw/*19.9*/("""</button>
      """)))}),format.raw/*20.8*/("""
      """),format.raw/*21.7*/("""<button class="btn px-4 button-light" id="" onclick="exportResultMiAddon('dataImportMiAddOnCancelExtendPack')">
        """),_display_(/*22.10*/Messages("common.export")),format.raw/*22.35*/("""
      """),format.raw/*23.7*/("""</button>
    </div>
  </div>
  <div class="card-body " style="padding-right: 0px;">
    <div class="mt-3" id="dataImportMiAddOnCancelExtendPack" style="float: left; width: 100%;">

    </div>
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
                  DATE: Mon Sep 22 16:32:55 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/utilities/Utilities_unextend.scala.html
                  HASH: a7031fefc98746e9d952bc921dd121ad04a80bee
                  MATRIX: 667->1|707->35|1053->67|1166->85|1193->86|1390->258|1456->304|1489->311|1702->498|1763->538|1797->545|1841->563|1908->621|1947->622|1983->631|2158->779|2220->820|2256->829|2303->846|2337->853|2485->974|2531->999|2565->1006
                  LINES: 24->1|25->2|30->3|35->3|36->4|40->8|40->8|41->9|45->13|45->13|46->14|48->16|48->16|48->16|49->17|50->18|50->18|51->19|52->20|53->21|54->22|54->22|55->23
                  -- GENERATED --
              */
          