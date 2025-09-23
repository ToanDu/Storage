
package views.html.telco.dashboard

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

object DashboardTelco_statistical extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.20*/("""
"""),format.raw/*4.1*/("""<div class="" style="height: 100%;">
  <div class="card-body">

    """),_display_(/*7.6*/if(UserHelper.isFeatureRole(currentUser, "view_dashboard_warning"))/*7.73*/{_display_(Seq[Any](format.raw/*7.74*/("""
      """),format.raw/*8.7*/("""<div class="row">
        <span class="title-card" style="color: red;">"""),_display_(/*9.55*/Messages("Cảnh báo")),format.raw/*9.75*/("""</span>
      </div>
      <div class="row">
        <div class="col-md-6 align-items-center m-t-3">
          <span>"""),_display_(/*13.18*/Messages("Số thuê bao có số dư TKG < 1000đ")),format.raw/*13.62*/("""</span>
          <div id="chartLowMoney"></div>
          <span class="apexcharts-legend-marker apex-icon-circle" rel="1" style="background: #EA0033; color: #EA0033;"></span>
          <span class="statistical-text cursor-pointer" onclick="showListSubsLowMoney()">"""),_display_(/*16.91*/Messages("TKG < 1000đ")),format.raw/*16.114*/(""" """),format.raw/*16.115*/("""<img src=""""),_display_(/*16.126*/routes/*16.132*/.Assets.versioned("images/telco/excel.png")),format.raw/*16.175*/("""" class="" alt="..." style="height: 20px; margin-bottom: 5px;"></span>
        </div>
        <div class="col-md-6 align-items-center m-t-3">
          <span>"""),_display_(/*19.18*/Messages("Số thuê bao chặn 1 chiều nợ cước")),format.raw/*19.62*/("""</span>
          <div id="chart1BlockDebit"></div>
          <span class="apexcharts-legend-marker apex-icon-circle" rel="1" style="background: #EA0033; color: #EA0033;"></span>
          <span class="statistical-text cursor-pointer" onclick="showListSubsBlockDebit()">"""),_display_(/*22.93*/Messages("Chặn 1 chiều nợ cước")),format.raw/*22.125*/(""" """),format.raw/*22.126*/("""<img src=""""),_display_(/*22.137*/routes/*22.143*/.Assets.versioned("images/telco/excel.png")),format.raw/*22.186*/("""" class="" alt="..." style="height: 20px; margin-bottom: 5px;"></span>
        </div>
        <div class="col-md-6 align-items-center m-t-3">
          <span>"""),_display_(/*25.18*/Messages("Số thuê bao hết lưu lượng")),format.raw/*25.55*/("""</span>
          <div id="chartOutOfData"></div>
          <span class="apexcharts-legend-marker apex-icon-circle" rel="1" style="background: #EA0033; color: #EA0033;"></span>
          <span class="statistical-text cursor-pointer" onclick="showListSubsOutOfData()">"""),_display_(/*28.92*/Messages("Hết lưu lượng")),format.raw/*28.117*/(""" """),format.raw/*28.118*/("""<img src=""""),_display_(/*28.129*/routes/*28.135*/.Assets.versioned("images/telco/excel.png")),format.raw/*28.178*/("""" class="" alt="..." style="height: 20px; margin-bottom: 5px;"></span>
        </div>
      </div>

      <hr style="border: 1px solid #EA0033;">
    """)))}),format.raw/*33.6*/("""

    """),_display_(/*35.6*/if(UserHelper.isFeatureRole(currentUser, "view_dashboard_debit"))/*35.71*/{_display_(Seq[Any](format.raw/*35.72*/("""
      """),format.raw/*36.7*/("""<div class="row">
        <span class="title-card">"""),_display_(/*37.35*/Messages("Tiền cước")),format.raw/*37.56*/("""</span>
      </div>
      <div class="row m-t-3">
        <div class="table-responsive">
          <table id="dataTables" class="table table-striped table-bordered">
            <thead class="cf"></thead>
            <tbody align="left">
              <tr>
                <td>"""),_display_(/*45.22*/Messages("Tổng dư nợ kì đầu")),format.raw/*45.51*/("""</td>
                <td style="text-align: right;" id="staOfCycleBalance"></td>
              </tr>
              <tr>
                <td>"""),_display_(/*49.22*/Messages("Tổng tiền điều chỉnh")),format.raw/*49.54*/("""</td>
                <td style="text-align: right;" id="adjustAmountBalance"></td>
              </tr>
              <tr>
                <td>"""),_display_(/*53.22*/Messages("Tổng tiền đã thanh toán")),format.raw/*53.57*/("""</td>
                <td style="text-align: right;" id="paymentBalance"></td>
              </tr>
              <tr>
                <td>"""),_display_(/*57.22*/Messages("Tổng tiền thừa")),format.raw/*57.48*/("""</td>
                <td style="text-align: right;" id="excessCashBalance"></td>
              </tr>
              <tr>
                <td>"""),_display_(/*61.22*/Messages("Tổng nợ còn lại")),format.raw/*61.49*/("""</td>
                <td style="text-align: right;" id="remainAmountBalance"></td>
              </tr>
              <tr>
                <td>"""),_display_(/*65.22*/Messages("Cước nóng tạm tính")),format.raw/*65.52*/("""</td>
                <td style="text-align: right;" id="hotChargeBalance"></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    """)))}),format.raw/*72.6*/("""

  """),format.raw/*74.3*/("""</div>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/dashboard/DashboardTelco_statistical.scala.html
                  HASH: 06b9e930bf9bd757632a57636eb4063f77d44d73
                  MATRIX: 667->1|707->35|1061->67|1174->85|1201->86|1295->155|1370->222|1408->223|1441->230|1539->302|1579->322|1724->440|1789->484|2082->750|2127->773|2157->774|2196->785|2212->791|2277->834|2463->993|2528->1037|2826->1308|2880->1340|2910->1341|2949->1352|2965->1358|3030->1401|3216->1560|3274->1597|3569->1865|3616->1890|3646->1891|3685->1902|3701->1908|3766->1951|3947->2102|3980->2109|4054->2174|4093->2175|4127->2182|4206->2234|4248->2255|4554->2534|4604->2563|4773->2705|4826->2737|4997->2881|5053->2916|5219->3055|5266->3081|5435->3223|5483->3250|5654->3394|5705->3424|5909->3598|5940->3602
                  LINES: 24->1|25->2|30->3|35->3|36->4|39->7|39->7|39->7|40->8|41->9|41->9|45->13|45->13|48->16|48->16|48->16|48->16|48->16|48->16|51->19|51->19|54->22|54->22|54->22|54->22|54->22|54->22|57->25|57->25|60->28|60->28|60->28|60->28|60->28|60->28|65->33|67->35|67->35|67->35|68->36|69->37|69->37|77->45|77->45|81->49|81->49|85->53|85->53|89->57|89->57|93->61|93->61|97->65|97->65|104->72|106->74
                  -- GENERATED --
              */
          