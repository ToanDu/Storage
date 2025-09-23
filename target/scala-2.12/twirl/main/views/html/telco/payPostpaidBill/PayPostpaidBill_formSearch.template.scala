
package views.html.telco.payPostpaidBill

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

object PayPostpaidBill_formSearch extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<div class="card">
  <div class="card-body">
    <span class="text-search">"""),_display_(/*5.32*/Messages("payPostpaidBill.formSearch.title")),format.raw/*5.76*/("""</span>
    <input id="gpkd" type="text" class="form-control" readonly hidden>
    <div class="row mt-3">
      <div class="row">
        <div class="col-md-6">
          <div class="mb-3 row">
            <label for="contractId" class="col-sm-2 col-form-label">"""),_display_(/*11.70*/Messages("payPostpaidBill.formSearch.contractCode")),format.raw/*11.121*/("""</label>
            <div class="col-sm-10">
              <input id="contractId" type="text" class="form-control input-form" placeholder=""""),_display_(/*13.96*/Messages("payPostpaidBill.formSearch.contractPlaceholder")),format.raw/*13.154*/("""" maxlength="11" inputmode="numeric" required onkeypress="if(event.key==='Enter') searchData()">
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="d-flex flex-column align-items-center text-center">
      <div class="">
        <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF;"
          onclick="searchData()">"""),_display_(/*22.35*/Messages("payPostpaidBill.formSearch.searchButton")),format.raw/*22.86*/("""</button>
        <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;"
            onclick="resetData()">"""),_display_(/*24.36*/Messages("payPostpaidBill.formSearch.resetButton")),format.raw/*24.86*/("""</button>
      </div>
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
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/payPostpaidBill/PayPostpaidBill_formSearch.scala.html
                  HASH: 80ab32fc5e5a14b8f2a6edbe027cb4d1df4b87fc
                  MATRIX: 673->1|1029->35|1142->53|1169->54|1271->130|1335->174|1625->437|1698->488|1865->628|1945->686|2369->1083|2441->1134|2615->1281|2686->1331
                  LINES: 24->1|29->2|34->2|35->3|37->5|37->5|43->11|43->11|45->13|45->13|54->22|54->22|56->24|56->24
                  -- GENERATED --
              */
          