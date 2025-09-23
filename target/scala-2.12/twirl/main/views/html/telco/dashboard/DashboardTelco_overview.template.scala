
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

object DashboardTelco_overview extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.20*/("""
"""),format.raw/*4.1*/("""<div class="" style="height: 100%;">
  <div class="card-body">

    <div class="row">
      <span class="title-card">"""),_display_(/*8.33*/Messages("Thuê bao")),format.raw/*8.53*/("""</span>
    </div>
    """),_display_(/*10.6*/if(UserHelper.isFeatureRole(currentUser, "view_dashboard_total_sub"))/*10.75*/{_display_(Seq[Any](format.raw/*10.76*/("""
      """),format.raw/*11.7*/("""<div class="row mt-4" style="padding: 35px; background-color: #dee2e6;">
        <div class="col-md-2 align-items-center">
          <span class="count-card-1">"""),_display_(/*13.39*/Messages("Tổng số thuê bao")),format.raw/*13.67*/("""</span>
        </div>
        <div class="col-md-8 align-items-center">
          <span class="count-card" id="totalSub">"""),_display_(/*16.51*/Messages("0")),format.raw/*16.64*/("""</span>
        </div>
        <div class="col-md-2" style="text-align: right;">
          <span style="font-size: 22px; font-weight: bold;" id="pieIncreaseSubs"></span>
        </div>
      </div>
    """)))}),format.raw/*22.6*/("""

    """),format.raw/*24.5*/("""<div class="row" style="padding: 35px; padding-right: 0px;">
      """),_display_(/*25.8*/if(UserHelper.isFeatureRole(currentUser, "view_dashboard_status_sub"))/*25.78*/{_display_(Seq[Any](format.raw/*25.79*/("""
        """),format.raw/*26.9*/("""<div class="col-md-2 align-items-center">
          <span class="count-card-1">"""),_display_(/*27.39*/Messages("Trạng thái thuê bao")),format.raw/*27.70*/("""</span>
        </div>
        <div class="col-md-10 align-items-center" style="padding-right: 0px;">
          <div class="progress" style="height: 48px;">
            <div class="progress-bar" role="progressbar" style="background-color: #EA0033;" aria-valuenow="" aria-valuemin="0" aria-valuemax="100" id="pieAtiveSubs"></div>
            <div class="progress-bar" role="progressbar" style="background-color: #999;" aria-valuenow="" aria-valuemin="0" aria-valuemax="100" id="pieBlock1Subs"></div>
            <div class="progress-bar" role="progressbar" style="background-color: #aaaaaae3;" aria-valuenow="" aria-valuemin="0" aria-valuemax="100" id="pieBlock2Subs"></div>
            <div class="progress-bar" role="progressbar" style="background-color: #dee2e6;" aria-valuenow="" aria-valuemin="0" aria-valuemax="100" id="pieCancleSubs"></div>
          </div>
        </div>
      """)))}),format.raw/*37.8*/("""

      """),_display_(/*39.8*/if(UserHelper.isFeatureRole(currentUser, "view_dashboard_paytype_sub"))/*39.79*/{_display_(Seq[Any](format.raw/*39.80*/("""
        """),format.raw/*40.9*/("""<div class="col-md-2 align-items-center m-t-3">
          <span class="count-card-1">"""),_display_(/*41.39*/Messages("Loại hình thuê bao")),format.raw/*41.69*/("""</span>
        </div>
        <div class="col-md-10 align-items-center m-t-3" style="padding-right: 0px;">
          <div class="progress" style="height: 48px;">
            <div class="progress-bar" role="progressbar" style="background-color: #EA0033;" aria-valuenow="" aria-valuemin="0" aria-valuemax="100" id="piePrevSubs"></div>
            <div class="progress-bar" role="progressbar" style="background-color: #aaa;" aria-valuenow="" aria-valuemin="0" aria-valuemax="100" id="piePostSubs"></div>
          </div>
        </div>
      """)))}),format.raw/*49.8*/("""

    """),format.raw/*51.5*/("""</div>

    <hr style="border: 1px solid #EA0033;">

    """),_display_(/*55.6*/if(UserHelper.isFeatureRole(currentUser, "view_dashboard_monthly_sub"))/*55.77*/{_display_(Seq[Any](format.raw/*55.78*/("""
      """),format.raw/*56.7*/("""<div class="row">
        <span class="title-card" style="text-align: center;">"""),_display_(/*57.63*/Messages("Thuê bao lũy kế theo tháng")),format.raw/*57.101*/("""</span>
      </div>
      <div class="row m-t-3">
        <div class="col-md-6 align-items-center m-t-3" style="padding-left: 0px;">
          <span class="count-card-1">"""),_display_(/*61.39*/Messages("TK thuê bao hoạt động")),format.raw/*61.72*/("""</span>
          <div id="chartActiveSubWithMonth" style="padding-top: 10px;"></div>
        </div>
        <div class="col-md-6 align-items-center m-t-3" style="padding-right: 0px;">
          <span class="count-card-1">"""),_display_(/*65.39*/Messages("TK thuê bao cắt hủy")),format.raw/*65.70*/("""</span>
          <div id="chartCancledSubWithMonth" style="padding-top: 10px;"></div>
        </div>
      </div>
    """)))}),format.raw/*69.6*/("""

  """),format.raw/*71.3*/("""</div>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/dashboard/DashboardTelco_overview.scala.html
                  HASH: 159120408709e7fce40cbf0f45fa0366fc0f7019
                  MATRIX: 667->1|707->35|1058->67|1171->85|1198->86|1342->204|1382->224|1432->248|1510->317|1549->318|1583->325|1771->486|1820->514|1970->637|2004->650|2237->853|2270->859|2364->927|2443->997|2482->998|2518->1007|2625->1087|2677->1118|3593->2004|3628->2013|3708->2084|3747->2085|3783->2094|3896->2180|3947->2210|4518->2751|4551->2757|4635->2815|4715->2886|4754->2887|4788->2894|4895->2974|4955->3012|5154->3184|5208->3217|5458->3440|5510->3471|5660->3591|5691->3595
                  LINES: 24->1|25->2|30->3|35->3|36->4|40->8|40->8|42->10|42->10|42->10|43->11|45->13|45->13|48->16|48->16|54->22|56->24|57->25|57->25|57->25|58->26|59->27|59->27|69->37|71->39|71->39|71->39|72->40|73->41|73->41|81->49|83->51|87->55|87->55|87->55|88->56|89->57|89->57|93->61|93->61|97->65|97->65|101->69|103->71
                  -- GENERATED --
              */
          