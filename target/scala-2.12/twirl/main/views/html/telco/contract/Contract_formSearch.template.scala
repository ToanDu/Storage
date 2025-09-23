
package views.html.telco.contract

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

object Contract_formSearch extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.20*/("""
"""),format.raw/*4.1*/("""<div class="card">
  <div class="card-body">
    <span class="text-search">"""),_display_(/*6.32*/Messages("contract.search.info")),format.raw/*6.64*/("""</span>
    <input id="gpkd" type="text" class="form-control" readonly hidden>

    <div class="row mt-3">
      <div class="col-md-6 m-t-3">
        <div class="row m-b-4">
          <div class="col-sm-1"></div>
          <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*13.67*/Messages("contract.search.contractNumber")),format.raw/*13.109*/("""</label>
          <div class="col-sm-8">
            <input id="accountNo" type="text" class="form-control input-form" placeholder=""""),_display_(/*15.93*/Messages("contract.search.placeholder")),format.raw/*15.132*/("""" maxlength="250">
          </div>
        </div>
      </div>
      <div class="col-md-6 m-t-3">
        <div class="row m-b-4">
          <div class="col-sm-1"></div>
          <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*22.67*/Messages("contract.search.contractCode")),format.raw/*22.107*/("""</label>
          <div class="col-sm-8">
            <input id="accountId" type="text" class="form-control input-form" placeholder=""""),_display_(/*24.93*/Messages("contract.search.placeholder")),format.raw/*24.132*/("""" onkeypress="return isNumberKey(event)" maxlength="250">
          </div>
        </div>
      </div>
    </div>
    <div class="d-flex flex-column align-items-center text-center">
      <div class="">
        """),_display_(/*31.10*/if(UserHelper.isFeatureRole(currentUser, "export_contract"))/*31.70*/{_display_(Seq[Any](format.raw/*31.71*/("""
          """),format.raw/*32.11*/("""<button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="onlickButtonExport()">"""),_display_(/*32.137*/Messages("contract.search.export")),format.raw/*32.171*/("""</button>
        """)))}),format.raw/*33.10*/("""
        """),format.raw/*34.9*/("""<button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="resetFormSearch()">"""),_display_(/*34.132*/Messages("contract.search.reset")),format.raw/*34.165*/("""</button>
        """),_display_(/*35.10*/if(UserHelper.isFeatureRole(currentUser, "view_contract"))/*35.68*/{_display_(Seq[Any](format.raw/*35.69*/("""
          """),format.raw/*36.11*/("""<button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF;" onclick="onlickButtonSearch()">"""),_display_(/*36.137*/Messages("contract.search.lookup")),format.raw/*36.171*/("""</button>
        """)))}),format.raw/*37.10*/("""
      """),format.raw/*38.7*/("""</div>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/contract/Contract_formSearch.scala.html
                  HASH: 373aae34549363955be983db1ea6579562cdf564
                  MATRIX: 666->1|706->35|1053->67|1166->85|1193->86|1295->162|1347->194|1653->473|1717->515|1878->649|1939->688|2202->924|2264->964|2425->1098|2486->1137|2725->1349|2794->1409|2833->1410|2872->1421|3026->1547|3082->1581|3132->1600|3168->1609|3319->1732|3374->1765|3420->1784|3487->1842|3526->1843|3565->1854|3719->1980|3775->2014|3825->2033|3859->2040
                  LINES: 24->1|25->2|30->3|35->3|36->4|38->6|38->6|45->13|45->13|47->15|47->15|54->22|54->22|56->24|56->24|63->31|63->31|63->31|64->32|64->32|64->32|65->33|66->34|66->34|66->34|67->35|67->35|67->35|68->36|68->36|68->36|69->37|70->38
                  -- GENERATED --
              */
          