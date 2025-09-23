
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

object HistoryDeposit_formSearch extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

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
          <label class="col-sm-4 col-form-label">"""),_display_(/*14.51*/Messages("history.deposit.order.id")),format.raw/*14.87*/("""</label>
          <div class="col-sm-8">
            <input id="orderId" type="text" class="form-control input-form" placeholder=""""),_display_(/*16.91*/Messages("subscriber.inputPlaceholder")),format.raw/*16.130*/("""" maxlength="250">
          </div>
        </div>
        <div class="form-group row mb-3">
          <label class="col-sm-4 col-form-label">"""),_display_(/*20.51*/Messages("history.deposit.subscriber")),format.raw/*20.89*/("""</label>
          <div class="col-sm-8">
            <input id="isdn" type="text" class="form-control input-form" placeholder=""""),_display_(/*22.88*/Messages("subscriber.inputPlaceholder")),format.raw/*22.127*/("""" maxlength="250">
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
        """),format.raw/*44.9*/("""<button type="button" class="btn btn-danger mr-2 mb-3 btn-telco" onclick="getListHistoryDepositAction()">
          """),_display_(/*45.12*/Messages("subscriber.search")),format.raw/*45.41*/("""
        """),format.raw/*46.9*/("""</button>
      """)))}),format.raw/*47.8*/("""
      """),_display_(/*48.8*/if(UserHelper.isFeatureRole(currentUser, "export_contract"))/*48.68*/ {_display_(Seq[Any](format.raw/*48.70*/("""
        """),format.raw/*49.9*/("""<button type="button" class="btn btn-outline-danger mr-2 mb-3 btn-telco" onclick="onlickButtonExport()">
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
                  DATE: Mon Sep 22 16:32:52 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/history/HistoryDeposit_formSearch.scala.html
                  HASH: 6d4b4b63b42ffbd72f6eda7a2298998d40ef043b
                  MATRIX: 665->1|705->35|1058->67|1172->86|1200->88|1319->181|1372->214|1585->400|1642->436|1801->568|1862->607|2032->750|2091->788|2247->917|2308->956|2549->1170|2596->1196|2773->1345|2826->1376|3013->1535|3064->1564|3212->1686|3279->1744|3319->1746|3355->1755|3499->1872|3549->1901|3585->1910|3632->1927|3666->1935|3735->1995|3775->1997|3811->2006|3954->2122|3993->2140|4029->2149|4076->2166|4110->2173|4243->2279|4281->2296|4315->2303
                  LINES: 24->1|25->2|30->3|35->3|37->5|39->7|39->7|46->14|46->14|48->16|48->16|52->20|52->20|54->22|54->22|62->30|62->30|64->32|64->32|67->35|67->35|75->43|75->43|75->43|76->44|77->45|77->45|78->46|79->47|80->48|80->48|80->48|81->49|82->50|82->50|83->51|84->52|85->53|86->54|86->54|87->55
                  -- GENERATED --
              */
          