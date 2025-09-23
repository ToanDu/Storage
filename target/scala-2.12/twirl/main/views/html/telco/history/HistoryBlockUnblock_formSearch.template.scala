
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

object HistoryBlockUnblock_formSearch extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

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
          <label class="col-sm-4 col-form-label">"""),_display_(/*14.51*/Messages("history.blockunblock.subscriber")),format.raw/*14.94*/("""</label>
          <div class="col-sm-8">
            <input id="isdn" type="text" class="form-control input-form" placeholder=""""),_display_(/*16.88*/Messages("subscriber.inputPlaceholder")),format.raw/*16.127*/("""" maxlength="250">
          </div>
        </div>
        <div class="form-group row mb-3">
          <label class="col-sm-4 col-form-label">"""),_display_(/*20.51*/Messages("history.blockunblock.action.type")),format.raw/*20.95*/("""</label>
          <div class="col-sm-8">
          <select name="" class="form-select" id="action">
            <option value="">"""),_display_(/*23.31*/Messages("history.blockunblock.select.action.type")),format.raw/*23.82*/("""</option>
            <option value="08">"""),_display_(/*24.33*/Messages("history.blockunblock.open.one.way")),format.raw/*24.78*/("""</option>
            <option value="06">"""),_display_(/*25.33*/Messages("history.blockunblock.block.one.way")),format.raw/*25.79*/("""</option>
            <option value="09">"""),_display_(/*26.33*/Messages("history.blockunblock.open.two.way")),format.raw/*26.78*/("""</option>
            <option value="07">"""),_display_(/*27.33*/Messages("history.blockunblock.block.two.way")),format.raw/*27.79*/("""</option>
          </select>
          </div>
        </div>
      </div>

      <!-- Cột bên phải -->
      <div class="col-md-6">
        <div class="form-group row mb-3">
          <label class="col-sm-3 col-form-label">"""),_display_(/*36.51*/Messages("filter.logDate")),format.raw/*36.77*/("""</label>
          <div class="col-sm-4 mb-3">
            <input id="from" type="text" class="form-control input-form datetimepicker" placeholder=""""),_display_(/*38.103*/Messages("subscriber.fromDate")),format.raw/*38.134*/("""">
          </div>
          <div class="col-sm-4 mb-3">
            <input id="to"  type="text" class="form-control input-form datetimepicker" placeholder=""""),_display_(/*41.102*/Messages("subscriber.toDate")),format.raw/*41.131*/("""">
          </div>
        </div>
      </div>
    </div>

    <!-- Button -->
    <div class="text-center mt-4">
      """),_display_(/*49.8*/if(UserHelper.isFeatureRole(currentUser, "view_contract"))/*49.66*/ {_display_(Seq[Any](format.raw/*49.68*/("""
        """),format.raw/*50.9*/("""<button type="button" class="btn btn-danger mr-2 mb-3 btn-telco" onclick="getListHistoryBlockUnblockAction()">
          """),_display_(/*51.12*/Messages("subscriber.search")),format.raw/*51.41*/("""
        """),format.raw/*52.9*/("""</button>
      """)))}),format.raw/*53.8*/("""
      """),_display_(/*54.8*/if(UserHelper.isFeatureRole(currentUser, "export_contract"))/*54.68*/ {_display_(Seq[Any](format.raw/*54.70*/("""
        """),format.raw/*55.9*/("""<button type="button" class="btn btn-outline-danger mr-2 mb-3 btn-telco" onclick="onlickButtonExport()">
          """),_display_(/*56.12*/Messages("Export")),format.raw/*56.30*/("""
        """),format.raw/*57.9*/("""</button>
      """)))}),format.raw/*58.8*/("""
      """),format.raw/*59.7*/("""<button type="button" class="btn btn-outline-danger btn-telco mb-3" onclick="resetFormSearch()">
        """),_display_(/*60.10*/Messages("Reset")),format.raw/*60.27*/("""
      """),format.raw/*61.7*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/history/HistoryBlockUnblock_formSearch.scala.html
                  HASH: 128eddc7f7f45fd4e87653e0abfd00947768ebc4
                  MATRIX: 665->1|705->35|1063->67|1177->86|1205->88|1324->181|1377->214|1590->400|1654->443|1810->572|1871->611|2041->754|2106->798|2264->929|2336->980|2405->1022|2471->1067|2540->1109|2607->1155|2676->1197|2742->1242|2811->1284|2878->1330|3130->1555|3177->1581|3354->1730|3407->1761|3594->1920|3645->1949|3793->2071|3860->2129|3900->2131|3936->2140|4085->2262|4135->2291|4171->2300|4218->2317|4252->2325|4321->2385|4361->2387|4397->2396|4540->2512|4579->2530|4615->2539|4662->2556|4696->2563|4829->2669|4867->2686|4901->2693
                  LINES: 24->1|25->2|30->3|35->3|37->5|39->7|39->7|46->14|46->14|48->16|48->16|52->20|52->20|55->23|55->23|56->24|56->24|57->25|57->25|58->26|58->26|59->27|59->27|68->36|68->36|70->38|70->38|73->41|73->41|81->49|81->49|81->49|82->50|83->51|83->51|84->52|85->53|86->54|86->54|86->54|87->55|88->56|88->56|89->57|90->58|91->59|92->60|92->60|93->61
                  -- GENERATED --
              */
          