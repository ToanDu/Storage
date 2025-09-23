
package views.html.telco.topUp

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
      """),_display_(/*8.8*/Messages("Đăng ký, huỷ gói Data mua thêm")),format.raw/*8.50*/("""
      """),format.raw/*9.7*/("""</button>
    </div>
    <div class="toolbar" style="float: right">
      <button class="btn px-4 button-light" id="" data-bs-toggle="modal" data-bs-target="#importListSubMiAddonModal">
      """),_display_(/*13.8*/Messages("Tải danh sách TB")),format.raw/*13.36*/("""
      """),format.raw/*14.7*/("""</button>
      """),_display_(/*15.8*/if(UserHelper.isFeatureRole(currentUser, "register_vas"))/*15.65*/{_display_(Seq[Any](format.raw/*15.66*/("""
        """),format.raw/*16.9*/("""<button class="btn px-4 button-light" id="" onclick="appendTablePackMiAddon()" data-bs-toggle="modal" data-bs-target="#registerMiAddonModal">
        """),_display_(/*17.10*/Messages("Đăng ký")),format.raw/*17.29*/("""
        """),format.raw/*18.9*/("""</button>
      """)))}),format.raw/*19.8*/("""

      """),_display_(/*21.8*/if(UserHelper.isFeatureRole(currentUser, "unregister_vas"))/*21.67*/{_display_(Seq[Any](format.raw/*21.68*/("""
        """),format.raw/*22.9*/("""<button class="btn px-4 button-light" id="" onclick="getListPackUnregister()" data-bs-toggle="modal" data-bs-target="#unregisterMiAddonModal">
        """),_display_(/*23.10*/Messages("Huỷ gói")),format.raw/*23.29*/("""
        """),format.raw/*24.9*/("""</button>
      """)))}),format.raw/*25.8*/("""

      """),_display_(/*27.8*/if(UserHelper.isFeatureRole(currentUser, "cancel_extend"))/*27.66*/{_display_(Seq[Any](format.raw/*27.67*/("""
        """),format.raw/*28.9*/("""<button class="btn px-4 button-light" id="" onclick="getListPackUnextend()" data-bs-toggle="modal" data-bs-target="#unextendMiAddonModal">
        """),_display_(/*29.10*/Messages("Huỷ gia hạn")),format.raw/*29.33*/("""
        """),format.raw/*30.9*/("""</button>
      """)))}),format.raw/*31.8*/("""

      """),format.raw/*33.7*/("""<button class="btn px-4 button-light" id="" onclick="exportResultMiAddon()">
      """),_display_(/*34.8*/Messages("Export")),format.raw/*34.26*/("""
      """),format.raw/*35.7*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/topUp/Utilities_miAddOn.scala.html
                  HASH: 0f102e94ff0451f8485f445f08a14e194657df94
                  MATRIX: 663->1|703->35|1048->67|1161->85|1188->86|1385->258|1447->300|1480->307|1699->500|1748->528|1782->535|1825->552|1891->609|1930->610|1966->619|2144->770|2184->789|2220->798|2267->815|2302->824|2370->883|2409->884|2445->893|2624->1045|2664->1064|2700->1073|2747->1090|2782->1099|2849->1157|2888->1158|2924->1167|3099->1315|3143->1338|3179->1347|3226->1364|3261->1372|3371->1456|3410->1474|3444->1481
                  LINES: 24->1|25->2|30->3|35->3|36->4|40->8|40->8|41->9|45->13|45->13|46->14|47->15|47->15|47->15|48->16|49->17|49->17|50->18|51->19|53->21|53->21|53->21|54->22|55->23|55->23|56->24|57->25|59->27|59->27|59->27|60->28|61->29|61->29|62->30|63->31|65->33|66->34|66->34|67->35
                  -- GENERATED --
              */
          