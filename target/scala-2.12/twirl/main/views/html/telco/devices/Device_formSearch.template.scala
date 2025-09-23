
package views.html.telco.devices

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

object Device_formSearch extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.20*/("""
"""),format.raw/*4.1*/("""<div class="card">
  <div class="card-body">
    <span class="text-search">"""),_display_(/*6.32*/Messages("Thông tin tìm kiếm")),format.raw/*6.62*/("""</span>
    <input id="gpkd" type="text" class="form-control" readonly hidden>

    <div class="row mt-3">
      <div class="col-md-6 m-t-3">
        <div class="row m-b-4">
          <div class="col-sm-1"></div>
          <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*13.67*/Messages("Số thuê bao")),format.raw/*13.90*/("""</label>
          <div class="col-sm-8">
            <input id="accountNo" type="text" class="form-control input-form" placeholder="Nhập nội dung"
              maxlength="250">
          </div>
        </div>
      </div>
    </div>
    <div class="d-flex flex-column align-items-center text-center">
      <div class="">
        """),_display_(/*23.10*/if(UserHelper.isFeatureRole(currentUser, "export_contract"))/*23.70*/{_display_(Seq[Any](format.raw/*23.71*/("""
        """),format.raw/*24.9*/("""<button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;"
          onclick="onlickButtonExport()">"""),_display_(/*25.43*/Messages("Export")),format.raw/*25.61*/("""</button>
        """)))}),format.raw/*26.10*/("""
        """),format.raw/*27.9*/("""<button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;"
          onclick="resetFormSearch()">"""),_display_(/*28.40*/Messages("Reset")),format.raw/*28.57*/("""</button>
        """),_display_(/*29.10*/if(UserHelper.isFeatureRole(currentUser, "view_contract"))/*29.68*/{_display_(Seq[Any](format.raw/*29.69*/("""
        """),format.raw/*30.9*/("""<button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF;"
          onclick="onlickButtonSearch()">"""),_display_(/*31.43*/Messages("Tra cứu")),format.raw/*31.62*/("""</button>
        """)))}),format.raw/*32.10*/("""
      """),format.raw/*33.7*/("""</div>
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
                  DATE: Mon Sep 22 16:32:52 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/devices/Device_formSearch.scala.html
                  HASH: 24166a01413ec041247bec4094cbe86fced19c14
                  MATRIX: 665->1|705->35|1050->67|1163->85|1190->86|1292->162|1342->192|1648->471|1692->494|2052->827|2121->887|2160->888|2196->897|2359->1033|2398->1051|2448->1070|2484->1079|2644->1212|2682->1229|2728->1248|2795->1306|2834->1307|2870->1316|3033->1452|3073->1471|3123->1490|3157->1497
                  LINES: 24->1|25->2|30->3|35->3|36->4|38->6|38->6|45->13|45->13|55->23|55->23|55->23|56->24|57->25|57->25|58->26|59->27|60->28|60->28|61->29|61->29|61->29|62->30|63->31|63->31|64->32|65->33
                  -- GENERATED --
              */
          