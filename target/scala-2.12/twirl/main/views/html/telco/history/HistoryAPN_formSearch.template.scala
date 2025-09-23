
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

object HistoryAPN_formSearch extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

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
          <label class="col-sm-4 col-lg-3 col-form-label">"""),_display_(/*14.60*/Messages("history.apn.subscriber.number")),format.raw/*14.101*/("""</label>
          <div class="col-sm-8 col-lg-8">
            <input id="sdtHistoryAPN" type="text" class="form-control input-form" placeholder=""""),_display_(/*16.97*/Messages("subscriber.inputPlaceholder")),format.raw/*16.136*/("""" maxlength="250">
          </div>
          <div class="col-sm-0 col-lg-1"></div>

        </div>
        <div class="form-group row mb-3">
          <label class="col-sm-4 col-lg-3 col-form-label">"""),_display_(/*22.60*/Messages("history.apn.action.type")),format.raw/*22.95*/("""</label>
          <div class="col-sm-8 col-lg-8 input-icons" >
            <select id="actionHistoryAPN" class="form-control" style="border: 0.5px solid #C0C0C0; border-radius: 8px">
              <option value="" disabled selected hidden>"""),_display_(/*25.58*/Messages("history.apn.select.action.type")),format.raw/*25.100*/("""</option>
              <option value="reg_def">"""),_display_(/*26.40*/Messages("history.apn.assign.default.apn")),format.raw/*26.82*/("""</option>
              <option value="reg_prv">"""),_display_(/*27.40*/Messages("history.apn.assign.private.apn")),format.raw/*27.82*/("""</option>
              <option value="unreg_def">"""),_display_(/*28.42*/Messages("history.apn.cancel.default.apn")),format.raw/*28.84*/("""</option>
              <option value="unreg_prv">"""),_display_(/*29.42*/Messages("history.apn.cancel.private.apn")),format.raw/*29.84*/("""</option>
            </select>
          </div>
          <div class="col-sm-0 col-lg-1"></div>
        </div>
      </div>

      <!-- Cột bên phải -->
      <div class="col-md-6">
        <div class="form-group row mb-3">
          <div class="col-sm-0 col-lg-2"></div>
          <label class="col-sm-3 col-lg-2 col-form-label">"""),_display_(/*40.60*/Messages("filter.logDate")),format.raw/*40.86*/("""</label>
          <div id="fromHistoryAPN-field" class="col-sm-4 col-lg-4 mb-3">
            <input id="fromHistoryAPN" type="text" class="form-control input-form datetimepicker" placeholder=""""),_display_(/*42.113*/Messages("subscriber.fromDate")),format.raw/*42.144*/("""" onchange="validateDate()">
             <div class="helper-text form-text text-danger mt-2" style="min-height: 14px;"></div>
          </div>
          <div id="toHistoryAPN-field" class="col-sm-4 col-lg-4 mb-3">
            <input id="toHistoryAPN"  type="text" class="form-control input-form datetimepicker" placeholder=""""),_display_(/*46.112*/Messages("subscriber.toDate")),format.raw/*46.141*/("""" onchange="validateDate()">
             <div class="helper-text form-text text-danger mt-2" style="min-height: 14px;"></div>
          </div>
        </div>
      </div>
    </div>

    <!-- Button -->
    <div class="text-center mt-4">
      """),_display_(/*55.8*/if(UserHelper.isFeatureRole(currentUser, "view_contract"))/*55.66*/ {_display_(Seq[Any](format.raw/*55.68*/("""
        """),format.raw/*56.9*/("""<button type="button" class="btn btn-danger mr-2 mb-3 btn-telco" onclick="getListHistoryApnAction()">
          """),_display_(/*57.12*/Messages("subscriber.search")),format.raw/*57.41*/("""
        """),format.raw/*58.9*/("""</button>
      """)))}),format.raw/*59.8*/("""
      """),_display_(/*60.8*/if(UserHelper.isFeatureRole(currentUser, "export_contract"))/*60.68*/ {_display_(Seq[Any](format.raw/*60.70*/("""
        """),format.raw/*61.9*/("""<button type="button" class="btn btn-outline-danger mr-2 mb-3 btn-telco" id="buttonExportApn" onclick="onlickButtonExport()">
          """),_display_(/*62.12*/Messages("Export")),format.raw/*62.30*/("""
        """),format.raw/*63.9*/("""</button>
      """)))}),format.raw/*64.8*/("""
      """),format.raw/*65.7*/("""<button type="button" class="btn btn-outline-danger btn-telco mb-3" onclick="resetFormSearch()">
        """),_display_(/*66.10*/Messages("Reset")),format.raw/*66.27*/("""
      """),format.raw/*67.7*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/history/HistoryAPN_formSearch.scala.html
                  HASH: f85c18e4fe8b95be9cb0074b235440a67ac1d89f
                  MATRIX: 665->1|705->35|1054->67|1168->86|1196->88|1315->181|1368->214|1590->409|1653->450|1827->597|1888->636|2116->837|2172->872|2440->1113|2504->1155|2580->1204|2643->1246|2719->1295|2782->1337|2860->1388|2923->1430|3001->1481|3064->1523|3423->1855|3470->1881|3692->2075|3745->2106|4099->2432|4150->2461|4422->2707|4489->2765|4529->2767|4565->2776|4705->2889|4755->2918|4791->2927|4838->2944|4872->2952|4941->3012|4981->3014|5017->3023|5181->3160|5220->3178|5256->3187|5303->3204|5337->3211|5470->3317|5508->3334|5542->3341
                  LINES: 24->1|25->2|30->3|35->3|37->5|39->7|39->7|46->14|46->14|48->16|48->16|54->22|54->22|57->25|57->25|58->26|58->26|59->27|59->27|60->28|60->28|61->29|61->29|72->40|72->40|74->42|74->42|78->46|78->46|87->55|87->55|87->55|88->56|89->57|89->57|90->58|91->59|92->60|92->60|92->60|93->61|94->62|94->62|95->63|96->64|97->65|98->66|98->66|99->67
                  -- GENERATED --
              */
          