
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

object Utilities_miAddOn extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.20*/("""
"""),format.raw/*4.1*/("""<div class="accordion-body">
  <div class="card-header-primary card-header-icon">
    <div class="toolbar" style="float: left">
      <button class="btn btn-title">
      """),_display_(/*8.8*/Messages("utilities.addDataPackage")),format.raw/*8.44*/("""
      """),format.raw/*9.7*/("""</button>
    </div>
    <div class="toolbar" style="float: right">
      <button class="btn px-4 button-light" onclick="openSubMiAddonModal('dataImportMiAddOn')">
      """),_display_(/*13.8*/Messages("utilities.loadSubscriberList")),format.raw/*13.48*/("""
      """),format.raw/*14.7*/("""</button>
      """),_display_(/*15.8*/if(UserHelper.isFeatureRole(currentUser, "register_vas"))/*15.65*/{_display_(Seq[Any](format.raw/*15.66*/("""
        """),format.raw/*16.9*/("""<button class="btn px-4 button-light" id="" onclick="appendTablePackMiAddon()" data-bs-toggle="modal" data-bs-target="#registerMiAddonModal">
        """),_display_(/*17.10*/Messages("utilities.register")),format.raw/*17.40*/("""
        """),format.raw/*18.9*/("""</button>
      """)))}),format.raw/*19.8*/("""

      """),format.raw/*21.7*/("""<button class="btn px-4 button-light" id="" onclick="exportResultMiAddon('dataImportMiAddOn')">
      """),_display_(/*22.8*/Messages("common.export")),format.raw/*22.33*/("""
      """),format.raw/*23.7*/("""</button>
    </div>
  </div>
  <div class="card-body " style="padding-right: 0px;">
    <div class="mt-3" id="dataImportMiAddOn" style="float: left; width: 100%;">

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/utilities/Utilities_miAddOn.scala.html
                  HASH: 507c17d17907bcb19b4da7a87423d9090f6a5620
                  MATRIX: 667->1|707->35|1052->67|1165->85|1192->86|1389->258|1445->294|1478->301|1675->472|1736->512|1770->519|1813->536|1879->593|1918->594|1954->603|2132->754|2183->784|2219->793|2266->810|2301->818|2430->921|2476->946|2510->953
                  LINES: 24->1|25->2|30->3|35->3|36->4|40->8|40->8|41->9|45->13|45->13|46->14|47->15|47->15|47->15|48->16|49->17|49->17|50->18|51->19|53->21|54->22|54->22|55->23
                  -- GENERATED --
              */
          