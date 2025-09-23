
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

object HistoryPrepayCharges_formSearch extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser: User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.21*/("""

"""),format.raw/*5.1*/("""<div class="card">
  <div class="card-body">
    <span class="text-search font-weight-bold">"""),_display_(/*7.49*/Messages("history.miaddon.search.info")),format.raw/*7.88*/("""</span>

    <div class="row mt-3">

      <!-- Cột bên trái -->
      <div class="col-md-6">
        <div class="form-group row mb-3">
          <label class="col-sm-4 col-form-label">"""),_display_(/*14.51*/Messages("history.prepay.search.transaction.code")),format.raw/*14.101*/("""</label>
          <div class="col-sm-8">
            <input id="orderId" type="text" class="form-control input-form" placeholder=""""),_display_(/*16.91*/Messages("history.miaddon.search.placeholder.content")),format.raw/*16.145*/("""" maxlength="250">
          </div>
        </div>
        <div class="form-group row mb-3">
          <label class="col-sm-4 col-form-label">"""),_display_(/*20.51*/Messages("history.miaddon.search.subscriber")),format.raw/*20.96*/("""</label>
          <div class="col-sm-8">
            <input id="isdn" type="text" class="form-control input-form" placeholder=""""),_display_(/*22.88*/Messages("history.miaddon.search.placeholder.content")),format.raw/*22.142*/("""" 
              oninput="this.value=this.value.replace(/\s+/g,'')" onkeypress="return isNumberKey(event)" maxlength="12" minlength="12" pattern="\d"""),format.raw/*23.146*/("""{"""),format.raw/*23.147*/("""12"""),format.raw/*23.149*/("""}"""),format.raw/*23.150*/("""" required>
          </div>
        </div>
      </div>

      <!-- Cột bên phải -->
      <div class="col-md-6">
        <div class="form-group row mb-3">
          <label class="col-sm-3 col-form-label">"""),_display_(/*31.51*/Messages("history.miaddon.search.time")),format.raw/*31.90*/("""</label>
          <div class="col-sm-4 mb-3">
            <input id="from" type="text" class="form-control input-form datetimepicker" placeholder=""""),_display_(/*33.103*/Messages("history.miaddon.search.from.date")),format.raw/*33.147*/("""">
          </div>
          <div class="col-sm-4 mb-3">
            <input id="to"  type="text" class="form-control input-form datetimepicker" placeholder=""""),_display_(/*36.102*/Messages("history.miaddon.search.to.date")),format.raw/*36.144*/("""">
          </div>
        </div>
      </div>
    </div>

    <!-- Button -->
    <div class="text-center mt-4">
      """),_display_(/*44.8*/if(UserHelper.isFeatureRole(currentUser, "view_contract"))/*44.66*/ {_display_(Seq[Any](format.raw/*44.68*/("""
        """),format.raw/*45.9*/("""<button type="button" class="btn btn-danger mr-2 mb-3 btn-telco" onclick="getListPrepayChargesAction(true)">
          """),_display_(/*46.12*/Messages("subscriber.search")),format.raw/*46.41*/("""
        """),format.raw/*47.9*/("""</button>
      """)))}),format.raw/*48.8*/("""
      """),_display_(/*49.8*/if(UserHelper.isFeatureRole(currentUser, "export_contract"))/*49.68*/ {_display_(Seq[Any](format.raw/*49.70*/("""
        """),format.raw/*50.9*/("""<button type="button" class="btn btn-outline-danger mr-2 mb-3 btn-telco" id="btn_export" onclick="onlickButtonExport()">
          """),_display_(/*51.12*/Messages("btnExport")),format.raw/*51.33*/("""
        """),format.raw/*52.9*/("""</button>
      """)))}),format.raw/*53.8*/("""
      """),format.raw/*54.7*/("""<button type="button" class="btn btn-outline-danger btn-telco mb-3" onclick="resetFormSearch()">
        """),_display_(/*55.10*/Messages("subscriber.reset")),format.raw/*55.38*/("""
      """),format.raw/*56.7*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/history/HistoryPrepayCharges_formSearch.scala.html
                  HASH: cf772405c4ab3bdb0dfa2c5865a01c14a3df8d47
                  MATRIX: 665->1|705->35|1064->67|1178->86|1206->88|1325->181|1384->220|1597->406|1669->456|1828->588|1904->642|2074->785|2140->830|2296->959|2372->1013|2549->1161|2579->1162|2610->1164|2640->1165|2874->1372|2934->1411|3111->1560|3177->1604|3364->1763|3428->1805|3576->1927|3643->1985|3683->1987|3719->1996|3866->2116|3916->2145|3952->2154|3999->2171|4033->2179|4102->2239|4142->2241|4178->2250|4337->2382|4379->2403|4415->2412|4462->2429|4496->2436|4629->2542|4678->2570|4712->2577
                  LINES: 24->1|25->2|30->3|35->3|37->5|39->7|39->7|46->14|46->14|48->16|48->16|52->20|52->20|54->22|54->22|55->23|55->23|55->23|55->23|63->31|63->31|65->33|65->33|68->36|68->36|76->44|76->44|76->44|77->45|78->46|78->46|79->47|80->48|81->49|81->49|81->49|82->50|83->51|83->51|84->52|85->53|86->54|87->55|87->55|88->56
                  -- GENERATED --
              */
          