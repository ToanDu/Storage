
package views.html.telco.history

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

object HistoryPostPaidBill_formSearch extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser: User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.21*/("""

"""),format.raw/*5.1*/("""<div class="card">
  <div class="card-body">
    <span class="text-search font-weight-bold">"""),_display_(/*7.49*/Messages("subscriber.searchInfo")),format.raw/*7.82*/("""</span>

    <div class="row mt-3">

      <!-- Cột bên trái -->
      <div class="col-md-6">
        <div class="form-group row mb-3">
          <label class="col-sm-4 col-form-label">"""),_display_(/*14.51*/Messages("history.postpaid.transaction.code")),format.raw/*14.96*/("""</label>
          <div class="col-sm-8">
            <input id="orderId" type="text" class="form-control input-form" placeholder=""""),_display_(/*16.91*/Messages("subscriber.inputPlaceholder")),format.raw/*16.130*/("""" maxlength="250">
          </div>
        </div>
        <div class="form-group row mb-3">
          <label class="col-sm-4 col-form-label">"""),_display_(/*20.51*/Messages("history.postpaid.contract.code")),format.raw/*20.93*/("""</label>
          <div class="col-sm-8">
            <input id="contractId" type="text" class="form-control input-form" placeholder=""""),_display_(/*22.94*/Messages("subscriber.inputPlaceholder")),format.raw/*22.133*/("""" maxlength="250">
          </div>
        </div>
      </div>

      <!-- Cột bên phải -->
      <div class="col-md-6">
        <div class="form-group row mb-3">
          <label class="col-sm-3 col-form-label">"""),_display_(/*30.51*/Messages("filter.logDate")),format.raw/*30.77*/("""</label>
          <div class="col-sm-4 mb-3">
            <input id="from" type="text" class="form-control input-form datetimepicker" placeholder=""""),_display_(/*32.103*/Messages("subscriber.fromDate")),format.raw/*32.134*/("""">
          </div>
          <div class="col-sm-4 mb-3">
            <input id="to"  type="text" class="form-control input-form datetimepicker" placeholder=""""),_display_(/*35.102*/Messages("subscriber.toDate")),format.raw/*35.131*/("""">
          </div>
        </div>
      </div>
    </div>

    <!-- Button -->
    <div class="text-center mt-4">
      """),_display_(/*43.8*/if(UserHelper.isFeatureRole(currentUser, "view_contract"))/*43.66*/ {_display_(Seq[Any](format.raw/*43.68*/("""
        """),format.raw/*44.9*/("""<button type="button" class="btn btn-danger mr-2 mb-3 btn-telco" onclick="getListHistoryPostPaidBillAction()">
          """),_display_(/*45.12*/Messages("subscriber.search")),format.raw/*45.41*/("""
        """),format.raw/*46.9*/("""</button>
      """)))}),format.raw/*47.8*/("""
      """),_display_(/*48.8*/if(UserHelper.isFeatureRole(currentUser, "export_contract"))/*48.68*/ {_display_(Seq[Any](format.raw/*48.70*/("""
        """),format.raw/*49.9*/("""<button type="button" class="btn btn-outline-danger mr-2 mb-3 btn-telco" id="export_data" onclick="onlickButtonExport()">
          """),_display_(/*50.12*/Messages("Export")),format.raw/*50.30*/("""
        """),format.raw/*51.9*/("""</button>
      """)))}),format.raw/*52.8*/("""
      """),format.raw/*53.7*/("""<button type="button" class="btn btn-outline-danger btn-telco mb-3" onclick="resetFormSearch()">
        """),_display_(/*54.10*/Messages("Reset")),format.raw/*54.27*/("""
      """),format.raw/*55.7*/("""</button>
    </div>
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
                  DATE: Mon Sep 22 16:32:53 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/history/HistoryPostPaidBill_formSearch.scala.html
                  HASH: b05290f296fa207a78cdf8680ee3ce3c0f479633
                  MATRIX: 665->1|705->35|1063->67|1177->86|1205->88|1324->181|1377->214|1590->400|1656->445|1815->577|1876->616|2046->759|2109->801|2271->936|2332->975|2573->1189|2620->1215|2797->1364|2850->1395|3037->1554|3088->1583|3236->1705|3303->1763|3343->1765|3379->1774|3528->1896|3578->1925|3614->1934|3661->1951|3695->1959|3764->2019|3804->2021|3840->2030|4000->2163|4039->2181|4075->2190|4122->2207|4156->2214|4289->2320|4327->2337|4361->2344
                  LINES: 24->1|25->2|30->3|35->3|37->5|39->7|39->7|46->14|46->14|48->16|48->16|52->20|52->20|54->22|54->22|62->30|62->30|64->32|64->32|67->35|67->35|75->43|75->43|75->43|76->44|77->45|77->45|78->46|79->47|80->48|80->48|80->48|81->49|82->50|82->50|83->51|84->52|85->53|86->54|86->54|87->55
                  -- GENERATED --
              */
          