
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

object HistoryMiAddon_formSearch extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<div class="card">
  <div class="card-body">
    <span class="text-search">"""),_display_(/*5.32*/Messages("history.miaddon.search.info")),format.raw/*5.71*/("""</span>
    <input id="gpkd" type="text" class="form-control" readonly hidden>

    <div class="row mt-3">
      """),format.raw/*9.39*/("""
        """),format.raw/*10.36*/("""
          """),format.raw/*11.43*/("""
          """),format.raw/*12.101*/("""
          """),format.raw/*13.37*/("""
            """),format.raw/*14.129*/("""
          """),format.raw/*15.21*/("""
        """),format.raw/*16.19*/("""
      """),format.raw/*17.17*/("""
      """),format.raw/*18.7*/("""<div class="row">
        <!-- Cột trái -->
        <div class="col-md-6">
          <div class="form-group row mb-3">
            <label class="col-sm-4 col-form-label">"""),_display_(/*22.53*/Messages("history.miaddon.search.gpkd.number")),format.raw/*22.99*/("""</label>
            <div class="col-sm-8">
              <input id="idNo" type="text" class="form-control input-form" placeholder=""""),_display_(/*24.90*/Messages("history.miaddon.search.placeholder.content")),format.raw/*24.144*/("""" maxlength="250">
            </div>
          </div>
          <div class="form-group row mb-3">
            <label class="col-sm-4 col-form-label">"""),_display_(/*28.53*/Messages("history.miaddon.search.subscriber")),format.raw/*28.98*/("""</label>
            <div class="col-sm-8">
              <input id="isdn" type="text" class="form-control input-form" placeholder=""""),_display_(/*30.90*/Messages("history.miaddon.search.placeholder.content")),format.raw/*30.144*/("""" maxlength="250">
            </div>
          </div>
        </div>
      
        <!-- Cột phải -->
        <div class="col-md-6">
          <!-- Thời gian -->
          <div class="mb-3 row">
            <label class="col-sm-3 col-form-label">"""),_display_(/*39.53*/Messages("history.miaddon.search.time")),format.raw/*39.92*/("""</label>
            <div class="col-sm-9">
              <div class="row">
                <div class="col-sm-6">
                  <input type="text" class="form-control datetimepicker" id="fromDate" placeholder=""""),_display_(/*43.102*/Messages("history.miaddon.search.from.date")),format.raw/*43.146*/("""">
                </div>
                <div class="col-sm-6">
                  <input type="text" class="form-control datetimepicker" id="toDate" placeholder=""""),_display_(/*46.100*/Messages("history.miaddon.search.to.date")),format.raw/*46.142*/("""">
                </div>
              </div>
            </div>
          </div>
      
          <!-- Trạng thái -->
          <div class="mb-3 row">
            <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*54.69*/Messages("history.miaddon.search.action")),format.raw/*54.110*/("""</label>
            <div class="col-sm-9 input-icons">
              <select id="packMiAddon" class="form-control">
                <option value="21">"""),_display_(/*57.37*/Messages("history.miaddon.search.register.package")),format.raw/*57.88*/("""</option>
                <option value="22">"""),_display_(/*58.37*/Messages("history.miaddon.search.cancel.package")),format.raw/*58.86*/("""</option>
                <option value="23">"""),_display_(/*59.37*/Messages("history.miaddon.search.cancel.renewal")),format.raw/*59.86*/("""</option>
                <option value="change">"""),_display_(/*60.41*/Messages("history.miaddon.search.change.package")),format.raw/*60.90*/("""</option>
              </select>
            </div>
          </div>
        </div>
      </div>
      
    </div>
    <div class="d-flex flex-column align-items-center text-center">
      <div class="">
        <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF;" onclick="onlickButtonSearch()">"""),_display_(/*70.135*/Messages("subscriber.search")),format.raw/*70.164*/("""</button>
        <button type="button" id="btn_export_data_miaddon" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="onlickButtonExport()">"""),_display_(/*71.164*/Messages("btnExport")),format.raw/*71.185*/("""</button>
        <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="resetFormSearch()">"""),_display_(/*72.132*/Messages("subscriber.reset")),format.raw/*72.160*/("""</button>
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
                  DATE: Mon Sep 22 16:32:53 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/history/HistoryMiAddon_formSearch.scala.html
                  HASH: 313d558e0684879738e25fe973dce4432cc9e393
                  MATRIX: 665->1|1020->35|1133->53|1160->54|1262->130|1321->169|1461->314|1498->350|1537->393|1577->494|1616->531|1658->660|1697->681|1734->700|1769->717|1803->724|2001->895|2068->941|2228->1074|2304->1128|2482->1279|2548->1324|2708->1457|2784->1511|3059->1759|3119->1798|3363->2014|3429->2058|3621->2222|3685->2264|3933->2485|3996->2526|4176->2679|4248->2730|4321->2776|4391->2825|4464->2871|4534->2920|4611->2970|4681->3019|5048->3358|5099->3387|5300->3560|5343->3581|5512->3722|5562->3750
                  LINES: 24->1|29->2|34->2|35->3|37->5|37->5|41->9|42->10|43->11|44->12|45->13|46->14|47->15|48->16|49->17|50->18|54->22|54->22|56->24|56->24|60->28|60->28|62->30|62->30|71->39|71->39|75->43|75->43|78->46|78->46|86->54|86->54|89->57|89->57|90->58|90->58|91->59|91->59|92->60|92->60|102->70|102->70|103->71|103->71|104->72|104->72
                  -- GENERATED --
              */
          