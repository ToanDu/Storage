
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

object Utilities_changePackage extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.20*/("""
"""),format.raw/*4.1*/("""<div class="accordion-body">
  <div class="card-header-primary card-header-icon">
    <div class="toolbar" style="float: left">
      <button class="btn btn-title">
      """),_display_(/*8.8*/Messages("utilities.changeDataPackage")),format.raw/*8.47*/("""
      """),format.raw/*9.7*/("""</button>
    </div>
    <div class="toolbar" style="float: right">
      <button class="btn px-4 button-light" onclick="openSubMiAddonModal('dataImportMiAddOnChangelPackage')">
      """),_display_(/*13.8*/Messages("utilities.loadSubscriberList")),format.raw/*13.48*/("""
      """),format.raw/*14.7*/("""</button>


      """),_display_(/*17.8*/if(UserHelper.isFeatureRole(currentUser, "cancel_extend"))/*17.66*/{_display_(Seq[Any](format.raw/*17.67*/("""
        """),format.raw/*18.9*/("""<button class="btn px-4 button-light" id="" onclick="changePackage()" >
        """),_display_(/*19.10*/Messages("utilities.changePackageAction")),format.raw/*19.51*/("""
        """),format.raw/*20.9*/("""</button>
      """)))}),format.raw/*21.8*/("""
    """),format.raw/*22.5*/("""<button class="btn px-4 button-light" id="" onclick="exportResultMiAddon('dataImportMiAddOnChangelPackage')">
            """),_display_(/*23.14*/Messages("Export")),format.raw/*23.32*/("""
    """),format.raw/*24.5*/("""</button>
    </div>
  </div>
  <div class="card-body " style="padding-right: 0px;">
    <div class="mt-3" id="dataImportMiAddOnChangelPackage" style="float: left; width: 100%;">

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/utilities/Utilities_changePackage.scala.html
                  HASH: 8afb885dbb5172cbbf4da7786abc095a6af76ca8
                  MATRIX: 667->1|707->35|1058->67|1171->85|1198->86|1395->258|1454->297|1487->304|1698->489|1759->529|1793->536|1838->555|1905->613|1944->614|1980->623|2088->704|2150->745|2186->754|2233->771|2265->776|2415->899|2454->917|2486->922
                  LINES: 24->1|25->2|30->3|35->3|36->4|40->8|40->8|41->9|45->13|45->13|46->14|49->17|49->17|49->17|50->18|51->19|51->19|52->20|53->21|54->22|55->23|55->23|56->24
                  -- GENERATED --
              */
          