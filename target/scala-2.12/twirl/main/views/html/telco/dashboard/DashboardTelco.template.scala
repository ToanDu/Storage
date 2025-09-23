
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
/*1.2*/import vn.m2m.utils.DateUtil
/*2.2*/import vn.m2m.common.models.User
/*3.2*/import vn.m2m.utils.UserHelper

object DashboardTelco extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(currentUser:User, userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.35*/("""
"""),format.raw/*5.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*10.13*/Messages("dashboard.telco.title")),format.raw/*10.46*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*11.46*/routes/*11.52*/.Assets.versioned("images/logo.jpg")),format.raw/*11.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*16.6*/views/*16.11*/.html.iot.tags.Main_css()),format.raw/*16.36*/("""

    """),format.raw/*18.5*/("""<link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*18.78*/("""" rel="stylesheet" />

    <link href=""""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("assets/plugins/select2/css/select2.min.css")),format.raw/*20.87*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("assets/plugins/select2/css/select2-bootstrap4.css")),format.raw/*21.94*/("""" rel="stylesheet" />

    <link href=""""),_display_(/*23.18*/routes/*23.24*/.Assets.versioned("stylesheets/views/telco/dashboard/dashboard.css")),format.raw/*23.92*/("""" rel="stylesheet" />
    <link href="https://files-maps.viettel.vn/sdk/vtmap-gl-js/v1.13.1/vtmap-gl.css" rel="stylesheet" />
  </head>
  <body class="bg-theme">
    """),_display_(/*27.6*/views/*27.11*/.html.telco.Menu(currentUser, "", userId)),format.raw/*27.52*/("""

    """),_display_(/*29.6*/views/*29.11*/.html.telco.Header(currentUser)),format.raw/*29.42*/("""

  """),format.raw/*31.3*/("""<div class="page-wrapper">
    <div class="page-content" style="background-color: #DEDEDE;">
      <div id="dashboard__telco">
          <!-- Features -->
        <div class="telco__features mb-3" id="telcoFeatures">
        </div>

        <!-- Totals -->
        <div class="telco__totals mb-3">
          <div class="telco__totals-item">
            <div class="telco__totals-item-header">
              <h5 class="telco__totals-item-title">"""),_display_(/*42.53*/Messages("dashboard.telco.totalSubscribers")),format.raw/*42.97*/("""</h5>
              <p id="pieIncreaseSubs">"""),_display_(/*43.40*/Messages("dashboard.telco.increasePercent")),format.raw/*43.83*/("""</p>
            </div>
            <strong class="telco__totals-item-number" id="totalSub">0</strong>
          </div>
          <div class="telco__totals-item">
            <div class="telco__totals-item-header">
              <h5 class="telco__totals-item-title">"""),_display_(/*49.53*/Messages("dashboard.telco.newThisMonth")),format.raw/*49.93*/("""</h5>
            </div>
            <strong class="telco__totals-item-number" id="totalSubNow">0</strong>
          </div>
          <div class="telco__totals-item">
            <div class="telco__totals-item-header">
              <h5 class="telco__totals-item-title">"""),_display_(/*55.53*/Messages("dashboard.telco.totalDataThisMonth")),format.raw/*55.99*/(""" 
                """),format.raw/*56.17*/("""<span id="tooltip_date" data-toggle="tooltip" data-placement="top" title=""""),_display_(/*56.92*/Messages("dashboard.telco.dataTooltip")),format.raw/*56.131*/("""" style="cursor: pointer;">
                  <i class='bx bxs-time'></i>
                </span>
              </h5>
            </div>
            <strong class="telco__totals-item-number" id="totalUsedData">0</strong>
          </div>
          <div class="telco__totals-item">
            <div class="telco__totals-item-header">
              <h5 class="telco__totals-item-title">"""),_display_(/*65.53*/Messages("dashboard.telco.totalCostMonth")),format.raw/*65.95*/("""</h5>
            </div>
            <strong class="telco__totals-item-number">--</strong>
          </div>
          <!-- <div class="telco__totals-item">
            <div class="telco__totals-item-header">
              <h5 class="telco__totals-item-title">Tổng</h5>
            </div>
            <strong class="telco__totals-item-number">--</strong>
          </div> -->
        </div>

          <!-- Chart -->
          <div class="row mb-2">
            <div class="col-lg-4 mb-3 d-flex">
              <div class="card_dashboard w-100 h-100 ">
                <span class="telco__charts-item-title">"""),_display_(/*81.57*/Messages("dashboard.telco.subscriberDistribution")),format.raw/*81.107*/("""</span>
                <div id="chart-subscriber-distribution"></div>
              </div>
            </div>
            <div class="col-lg-4 mb-3 d-flex">
              <div class="card_dashboard w-100 h-100 ">
                <div class="d-flex justify-content-between">
                  <span class="telco__charts-item-title">"""),_display_(/*88.59*/Messages("dashboard.telco.activeSubscribers")),format.raw/*88.104*/("""</span>
                  <span id="totalSub_data">0</span>
                </div>
                <div id="subscriber-statistics-container">
                  <div class="d-flex justify-content-center flex-column" id="chart-subscriber-statistics-prepaid"></div>
                  <div class="d-flex justify-content-center flex-column" id="chart-subscriber-statistics-postpaid"></div>
                </div>
              </div>
            </div>
            <div class="col-lg-4 mb-3 d-flex">
              <div class="card_dashboard w-100 h-100 ">
                <div class="d-flex justify-content-between mb-3">
                  <span class="telco__charts-item-title mb-0">"""),_display_(/*100.64*/Messages("dashboard.telco.warnings")),format.raw/*100.100*/("""
                    """),format.raw/*101.21*/("""<svg class="warning-svg" width="35" height="30" viewBox="0 0 45 40" fill="none"
                      xmlns="http://www.w3.org/2000/svg">
                      <path
                        d="M43.7602 11.6036C43.5959 11.196 43.2108 10.9347 42.754 10.8576L42.7573 10.8434L36.5994 10.4438L37.8428 4.96555L37.8308 4.9645C37.8533 4.75028 37.8181 4.54084 37.7283 4.3531C37.6384 4.16537 37.4963 4.00461 37.3135 3.88382C37.1296 3.76376 36.9103 3.6873 36.6733 3.66063C36.4362 3.63395 36.1882 3.65782 35.9492 3.73029L35.9443 3.71831L29.987 6.11987L27.9936 1.17495L27.9814 1.17985C27.8791 0.998086 27.7261 0.845608 27.5346 0.734745C27.3431 0.623881 27.1185 0.557742 26.879 0.541678C26.6389 0.526217 26.3907 0.561684 26.1547 0.645175C25.9188 0.728665 25.7017 0.857809 25.5214 1.02205L25.5099 1.01436L21.2808 5.64993L16.6879 2.63258L16.6794 2.64188C16.4798 2.5413 16.2498 2.48666 16.008 2.48239C15.7662 2.47813 15.5193 2.52435 15.2874 2.61733C14.7978 2.81471 14.4475 3.18878 14.301 3.60228L14.2851 3.60119L13.0487 9.04881L6.9792 8.65475L6.97664 8.66595C6.73322 8.67349 6.48793 8.73132 6.26059 8.83478C6.03325 8.93823 5.83025 9.08441 5.66799 9.26149C5.50632 9.43937 5.39025 9.64305 5.32916 9.85604C5.26808 10.069 5.26372 10.2853 5.31643 10.4874L5.30149 10.4934L7.2832 15.4093L1.41212 17.7761L1.41602 17.7858C1.19396 17.8994 0.999072 18.0542 0.847117 18.2377C0.695161 18.4211 0.5904 18.6281 0.5413 18.8419C0.493317 19.0559 0.50251 19.2704 0.568133 19.4682C0.633756 19.6659 0.753965 19.8412 0.919026 19.9799L0.9089 19.9915L5.49832 23.0065L1.3081 27.5996L1.31772 27.6059C1.17654 27.7952 1.08431 28.0055 1.04847 28.2199C1.01264 28.4342 1.03421 28.6465 1.11144 28.8396C1.27575 29.2472 1.66104 29.509 2.1177 29.5856L2.11441 29.5998L8.27231 29.9994L7.02889 35.4777L7.04071 35.4783C7.01824 35.6925 7.05336 35.902 7.14323 36.0897C7.2331 36.2774 7.3752 36.4382 7.55804 36.559C7.7419 36.679 7.96122 36.7555 8.19825 36.7822C8.43527 36.8088 8.68333 36.785 8.92232 36.7125L8.92733 36.7249L14.8842 34.3236L16.8774 39.2681L16.8896 39.2632C17.092 39.6185 17.4866 39.8684 17.9919 39.9013C18.2321 39.9164 18.4801 39.8807 18.716 39.7973C18.9519 39.7138 19.169 39.5849 19.3496 39.421L19.361 39.4287L23.5901 34.7931L28.183 37.8104L28.1915 37.8011C28.3911 37.9017 28.6211 37.9564 28.8629 37.9606C29.1047 37.9649 29.3516 37.9187 29.5836 37.8257C30.0732 37.6283 30.4234 37.2542 30.5701 36.8412L30.5853 36.8421L31.8217 31.3944L37.8917 31.7883L37.8943 31.7771C38.1377 31.7695 38.383 31.7117 38.6104 31.6082C38.8377 31.5048 39.0407 31.3586 39.2029 31.1815C39.3646 31.0036 39.4807 30.8 39.5418 30.587C39.6029 30.374 39.6072 30.1577 39.5545 29.9556L39.5695 29.9496L37.5879 25.0342L43.4596 22.6672L43.4557 22.6575C43.6777 22.5439 43.8726 22.3891 44.0246 22.2056C44.1765 22.0221 44.2813 21.8151 44.3304 21.6014C44.3784 21.3873 44.3693 21.1726 44.3036 20.9748C44.2379 20.777 44.1177 20.6016 43.9525 20.4629L43.9628 20.4518L39.3734 17.4368L43.5636 12.8436L43.554 12.8373C43.6951 12.648 43.7874 12.4377 43.8232 12.2234C43.859 12.0091 43.8375 11.7968 43.7602 11.6036Z"
                        fill="#D5002E" />
                      <rect x="20" y="11" width="4" height="13" fill="white" />
                      <rect x="20" y="26" width="4" height="3" fill="white" />
                    </svg>
                  </span>
                  <i class='bx bx-refresh refresh-icon' id="refreshIcon" onclick="getAlertDashboard()"></i>
                </div>
                <div class="telco__charts-grid">
                  <div class="telco__charts-box telco__charts-box--pink">
                    <p class="telco__charts-box-name">"""),_display_(/*114.56*/Messages("dashboard.warning.redAlert")),format.raw/*114.94*/("""</p>
                    <p class="telco__charts-box-value" id="RED_ALERT">0</p>
                    <p class="telco__charts-box-sub">"""),_display_(/*116.55*/Messages("dashboard.warning.subscribers")),format.raw/*116.96*/("""</p>
                    <a href="#" class="telco__charts-box-link" onclick="getDetailRedAlert()">"""),_display_(/*117.95*/Messages("dashboard.warning.details")),format.raw/*117.132*/("""</a>
                  </div>
                  <div class="telco__charts-box telco__charts-box--purple">
                    <p class="telco__charts-box-name">"""),_display_(/*120.56*/Messages("dashboard.warning.prepaidExpired")),format.raw/*120.100*/("""</p>
                    <p class="telco__charts-box-value" id="PREPAID_EXPIRED">0</p>
                    <p class="telco__charts-box-sub">"""),_display_(/*122.55*/Messages("dashboard.warning.subscribers")),format.raw/*122.96*/("""</p>
                    <a href="#" class="telco__charts-box-link" onclick="getDetailPrepaidExpired()">"""),_display_(/*123.101*/Messages("dashboard.warning.details")),format.raw/*123.138*/("""</a>
                  </div>
                  <div class="telco__charts-box telco__charts-box--cream">
                    <p class="telco__charts-box-name">"""),_display_(/*126.56*/Messages("dashboard.warning.blockDebit")),format.raw/*126.96*/("""</p>
                    <p class="telco__charts-box-value">--</p>
                    <p class="telco__charts-box-sub">"""),_display_(/*128.55*/Messages("dashboard.warning.subscribers")),format.raw/*128.96*/("""</p>
                    <a href="#" class="telco__charts-box-link">"""),_display_(/*129.65*/Messages("dashboard.warning.details")),format.raw/*129.102*/("""</a>
                  </div>
                  <div class="telco__charts-box telco__charts-box--mint">
                    <p class="telco__charts-box-name">"""),_display_(/*132.56*/Messages("dashboard.warning.packageExpired")),format.raw/*132.100*/("""</p>
                    <p class="telco__charts-box-value" id="PACKAGE_EXPIRED">0</p>
                    <p class="telco__charts-box-sub">"""),_display_(/*134.55*/Messages("dashboard.warning.subscribers")),format.raw/*134.96*/("""</p>
                    <a href="#" class="telco__charts-box-link" onclick="getDetailPackageExpire()">"""),_display_(/*135.100*/Messages("dashboard.warning.details")),format.raw/*135.137*/("""</a>
                  </div>
                  <div class="telco__charts-box telco__charts-box--blue">
                    <p class="telco__charts-box-name">"""),_display_(/*138.56*/Messages("dashboard.warning.lowBalance")),format.raw/*138.96*/("""</p>
                        <p class="telco__charts-box-value" id="lowMoneyCount">0</p>
                        <p class="telco__charts-box-sub">"""),_display_(/*140.59*/Messages("dashboard.warning.subscribers")),format.raw/*140.100*/("""</p>
                        <a href="#" class="telco__charts-box-link" onclick="showListSubsLowMoney()">"""),_display_(/*141.102*/Messages("dashboard.warning.details")),format.raw/*141.139*/("""</a>
                  </div>
                  <div class="telco__charts-box telco__charts-box--yellow">
                    <p class="telco__charts-box-name">"""),_display_(/*144.56*/Messages("dashboard.warning.lowRemainingData")),format.raw/*144.102*/("""</p>
                    <p class="telco__charts-box-value" id="LOW_REMAINING_DATA">0</p>
                    <p class="telco__charts-box-sub">"""),_display_(/*146.55*/Messages("dashboard.warning.subscribers")),format.raw/*146.96*/("""</p>
                    <a href="#" class="telco__charts-box-link" onclick="getDetailLowRemainingData()">"""),_display_(/*147.103*/Messages("dashboard.warning.details")),format.raw/*147.140*/("""</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
          
          <!-- Datas -->
          <div class="row mb-2">
            <div class="col-lg-4 mb-3 d-flex">
              <div class="card_dashboard w-100 h-100">
                <span class="telco__charts-item-title">"""),_display_(/*158.57*/Messages("dashboard.telco.cumulativeSubscribers")),format.raw/*158.106*/("""</span>
                <div id="chart-cumulative"></div>
              </div>
            </div>
            <div class="col-lg-4 mb-3 d-flex">
              <div class="card_dashboard w-100 h-100">
                <span class="telco__charts-item-title">"""),_display_(/*164.57*/Messages("dashboard.telco.dataUsage")),format.raw/*164.94*/("""</span>
                <div class="d-flex justify-content-between align-items-center mb-3">
                  <p class="mb-0" style="color: #615E83; font-weight: 500; font-size: 14px;">"""),_display_(/*166.95*/Messages("dashboard.telco.dataUsageGB")),format.raw/*166.134*/("""</p>
                  <div class="toggle-buttons">
                    <button class="tab-btn active" id="filterByDay">"""),_display_(/*168.70*/Messages("dashboard.telco.filterByDay")),format.raw/*168.109*/("""</button>
                    <button class="tab-btn" id="filterByMonth">"""),_display_(/*169.65*/Messages("dashboard.telco.filterByMonth")),format.raw/*169.106*/("""</button>
                  </div>
                </div>
                <div id="chart-data-usage"></div>
              </div>
            </div>
            <div class="col-lg-4 mb-3 d-flex">
              <div class="card_dashboard w-100 h-100">
                <span class="telco__charts-item-title">"""),_display_(/*177.57*/Messages("dashboard.telco.postpaidStatistics")),format.raw/*177.103*/("""</span>
                <ul class="list-group mb-3" id="list-group-custom">
                  <li class="list-group-item d-flex justify-content-between">
                    <span>"""),_display_(/*180.28*/Messages("dashboard.postpaid.startBalance")),format.raw/*180.71*/("""</span>
                    <span id="staOfCycleBalance">0</span>
                  </li>
                  <li class="list-group-item d-flex justify-content-between">
                    <span>"""),_display_(/*184.28*/Messages("dashboard.postpaid.adjustAmount")),format.raw/*184.71*/("""</span>
                    <span id="adjustAmountBalance">0</span>
                  </li>
                  <li class="list-group-item d-flex justify-content-between">
                    <span>"""),_display_(/*188.28*/Messages("dashboard.postpaid.payment")),format.raw/*188.66*/("""</span>
                    <span id="paymentBalance">0</span>
                  </li>
                  <li class="list-group-item d-flex justify-content-between">
                    <span>"""),_display_(/*192.28*/Messages("dashboard.postpaid.excessCash")),format.raw/*192.69*/("""</span>
                    <span id="excessCashBalance">0</span>
                  </li>
                  <li class="list-group-item d-flex justify-content-between">
                    <span>"""),_display_(/*196.28*/Messages("dashboard.postpaid.remainAmount")),format.raw/*196.71*/("""</span>
                    <span id="remainAmountBalance">0</span>
                  </li>
                  <li class="list-group-item d-flex justify-content-between">
                    <span>"""),_display_(/*200.28*/Messages("dashboard.postpaid.hotCharge")),format.raw/*200.68*/("""</span>
                    <span id="hotChargeBalance">0</span>
                  </li>
                </ul>
              </div>
            </div>
          </div>
          
          <!-- Map -->
          <div class="row mb-2">
            <div class="col-sm-12 col-md-12 col-lg-8 mb-3 ">
              <div class="tel__map">
                <span class="telco__charts-item-title">"""),_display_(/*212.57*/Messages("dashboard.telco.subscriberDistributionMap")),format.raw/*212.110*/("""</span>
                <div class="tel__map-box">
                  <div id="viettel_map"></div>
                </div>
              </div>
            </div>
            <div class="col-sm-12 col-md-12 col-lg-4 mb-3 ">
              <div class="tel__map">
                <span class="telco__charts-item-title">"""),_display_(/*220.57*/Messages("dashboard.telco.topDataUsers")),format.raw/*220.97*/("""</span>
                <div class="table-box">
                  <table class="table table-bordered table-striped">
                    <thead class="thead-dark">
                      <tr>
                        <th class="p-3">"""),_display_(/*225.42*/Messages("manage.stt")),format.raw/*225.64*/("""</th>
                        <th class="p-3">"""),_display_(/*226.42*/Messages("dashboard.table.subscriber.number")),format.raw/*226.87*/("""</th>
                        <th class="p-3">"""),_display_(/*227.42*/Messages("dashboard.table.usage.gb")),format.raw/*227.78*/("""</th>
                      </tr>
                    </thead>
                    <tbody ib="top5DataUsersOfMonth">
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
      </div>

      """),_display_(/*239.8*/views/*239.13*/.html.telco.dashboard.DashboardTelco_company()),format.raw/*239.59*/("""
      """),_display_(/*240.8*/views/*240.13*/.html.telco.dashboard.DashboardTelco_statistical_listLowMoney(userId)),format.raw/*240.82*/("""
      """),_display_(/*241.8*/views/*241.13*/.html.telco.dashboard.DashboardTelco_statistical_listBlockDebit()),format.raw/*241.78*/("""
      """),_display_(/*242.8*/views/*242.13*/.html.telco.dashboard.DashboardTelco_statistical_listOutOfData(userId)),format.raw/*242.83*/("""
      """),_display_(/*243.8*/views/*243.13*/.html.telco.dashboard.DashboardTelco_modalPackageExpire(userId)),format.raw/*243.76*/("""
      """),_display_(/*244.8*/views/*244.13*/.html.telco.dashboard.DashboardTelco_modal_red_alert(userId)),format.raw/*244.73*/("""
      """),_display_(/*245.8*/views/*245.13*/.html.telco.dashboard.DashboardTelco_modal_prepaid_expired(userId)),format.raw/*245.79*/("""
      """),_display_(/*246.8*/views/*246.13*/.html.telco.dashboard.DashboardTelco_modal_low_remaining_data(userId)),format.raw/*246.82*/("""

      """),_display_(/*248.8*/views/*248.13*/.html.telco.Loading()),format.raw/*248.34*/("""
    """),format.raw/*249.5*/("""</div>
  </div>
    <!--  END OF PAPER WRAP -->

    """),_display_(/*253.6*/views/*253.11*/.html.telco.mainJs()),format.raw/*253.31*/("""

  """),format.raw/*255.3*/("""<script>
              var imgDefault = '"""),_display_(/*256.34*/routes/*256.40*/.Assets.versioned("images/market/default.png")),format.raw/*256.86*/("""';
              var userId = '"""),_display_(/*257.30*/userId),format.raw/*257.36*/("""';
              var username = '"""),_display_(/*258.32*/currentUser/*258.43*/.getUsername),format.raw/*258.55*/("""';
              var view_dashboard_total_sub = '"""),_display_(/*259.48*/UserHelper/*259.58*/.isFeatureRole(currentUser, "view_dashboard_total_sub")),format.raw/*259.113*/("""';
              var view_dashboard_status_sub = '"""),_display_(/*260.49*/UserHelper/*260.59*/.isFeatureRole(currentUser, "view_dashboard_status_sub")),format.raw/*260.115*/("""';
              var view_dashboard_paytype_sub = '"""),_display_(/*261.50*/UserHelper/*261.60*/.isFeatureRole(currentUser, "view_dashboard_paytype_sub")),format.raw/*261.117*/("""';
              var view_dashboard_warning = '"""),_display_(/*262.46*/UserHelper/*262.56*/.isFeatureRole(currentUser, "view_dashboard_warning")),format.raw/*262.109*/("""';
              var view_dashboard_monthly_sub = '"""),_display_(/*263.50*/UserHelper/*263.60*/.isFeatureRole(currentUser, "view_dashboard_monthly_sub")),format.raw/*263.117*/("""';
              var view_dashboard_debit = '"""),_display_(/*264.44*/UserHelper/*264.54*/.isFeatureRole(currentUser, "view_dashboard_debit")),format.raw/*264.105*/("""';

              $(document).ready(function () """),format.raw/*266.45*/("""{"""),format.raw/*266.46*/("""
                """),format.raw/*267.17*/("""$("#menu-dashboardManage").addClass("mm-active");
                $("#menu").metisMenu();
              """),format.raw/*269.15*/("""}"""),format.raw/*269.16*/(""")
      </script>
  <script src=""""),_display_(/*271.17*/routes/*271.23*/.Assets.versioned("assets/plugins/input-tags/js/tagsinput.js")),format.raw/*271.85*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*272.17*/routes/*272.23*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*272.82*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*273.17*/routes/*273.23*/.Assets.versioned("assets/plugins/apexcharts-bundle/js/apexcharts.min.js")),format.raw/*273.97*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*274.17*/routes/*274.23*/.Assets.versioned("javascripts/plugins/moment.min.js")),format.raw/*274.77*/("""" type="text/javascript"></script>    
  <script src=""""),_display_(/*275.17*/routes/*275.23*/.Assets.versioned("assets/plugins/select2/js/select2.min.js")),format.raw/*275.84*/(""""></script>

    """),format.raw/*277.126*/("""
  """),format.raw/*278.3*/("""<script src=""""),_display_(/*278.17*/routes/*278.23*/.Assets.versioned("javascripts/views/telco/dashboard/dashboard.js")),format.raw/*278.90*/("""" type="text/javascript"></script>
    """),format.raw/*279.138*/("""

  """),format.raw/*281.3*/("""<script src=""""),_display_(/*281.17*/routes/*281.23*/.Assets.versioned("javascripts/views/telco/dashboard/dashboard_overview.js")),format.raw/*281.99*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*282.17*/routes/*282.23*/.Assets.versioned("javascripts/views/telco/dashboard/dashboard_columnChart.js")),format.raw/*282.102*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*283.17*/routes/*283.23*/.Assets.versioned("javascripts/views/telco/dashboard/dashboard_pieChart.js")),format.raw/*283.99*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*284.17*/routes/*284.23*/.Assets.versioned("javascripts/views/telco/dashboard/dashboard_pieChart_lowMoney.js")),format.raw/*284.108*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*285.17*/routes/*285.23*/.Assets.versioned("javascripts/views/telco/dashboard/dashboard_pieChart_blockDebit.js")),format.raw/*285.110*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*286.17*/routes/*286.23*/.Assets.versioned("javascripts/views/telco/dashboard/dashboard_pieChart_outOfData.js")),format.raw/*286.109*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*287.17*/routes/*287.23*/.Assets.versioned("javascripts/views/telco/dashboard/dashboard_modal_package_expire.js")),format.raw/*287.111*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*288.17*/routes/*288.23*/.Assets.versioned("javascripts/views/telco/dashboard/dashboard_modal_red_alert.js")),format.raw/*288.106*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*289.17*/routes/*289.23*/.Assets.versioned("javascripts/views/telco/dashboard/dashboard_modal_prepaid_expired.js")),format.raw/*289.112*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*290.17*/routes/*290.23*/.Assets.versioned("javascripts/views/telco/dashboard/dashboard_modal_low_remaining_data.js")),format.raw/*290.115*/("""" type="text/javascript"></script>
  <script src="https://files-maps.viettel.vn/sdk/vtmap-gl-js/v1.13.1/vtmap-gl.js" type="text/javascript"></script>
  <script src=""""),_display_(/*292.17*/routes/*292.23*/.Assets.versioned("javascripts/views/telco/dashboard/location_viettelmap.js")),format.raw/*292.100*/("""" type="text/javascript"></script>
  <link href=""""),_display_(/*293.16*/routes/*293.22*/.Assets.versioned("stylesheets/views/telco/location/Location.css")),format.raw/*293.88*/("""" rel="stylesheet" />

  <script>
    // Mảng chứa dữ liệu menu
    const menuItems = [
      """),format.raw/*298.7*/("""{"""),format.raw/*298.8*/("""
        """),format.raw/*299.9*/("""href: '"""),_display_(/*299.17*/routes/*299.23*/.TelcoUtilitiesController.utilitiesManage(userId)),format.raw/*299.72*/("""',
        imgSrc: '"""),_display_(/*300.19*/routes/*300.25*/.Assets.versioned("images/dashboardnew/muagoidata.svg")),format.raw/*300.80*/("""',
        alt: '"""),_display_(/*301.16*/Messages("dashboard.features.buyDataPackage")),format.raw/*301.61*/("""',
        name: '"""),_display_(/*302.17*/Messages("dashboard.features.buyDataPackage")),format.raw/*302.62*/("""'
      """),format.raw/*303.7*/("""}"""),format.raw/*303.8*/(""",
      """),format.raw/*304.7*/("""{"""),format.raw/*304.8*/("""
        """),format.raw/*305.9*/("""href: '"""),_display_(/*305.17*/routes/*305.23*/.TelcoUtilitiesController.utilitiesTopup(userId)),format.raw/*305.71*/("""',
        imgSrc: '"""),_display_(/*306.19*/routes/*306.25*/.Assets.versioned("images/dashboardnew/naptienn.svg")),format.raw/*306.78*/("""',
        alt: '"""),_display_(/*307.16*/Messages("dashboard.features.topup")),format.raw/*307.52*/("""',
        name: '"""),_display_(/*308.17*/Messages("dashboard.features.topup")),format.raw/*308.53*/("""'
      """),format.raw/*309.7*/("""}"""),format.raw/*309.8*/(""",
      """),format.raw/*310.7*/("""{"""),format.raw/*310.8*/("""
        """),format.raw/*311.9*/("""href: '"""),_display_(/*311.17*/routes/*311.23*/.TelcoUtilitiesController.utilitiesBlock(userId)),format.raw/*311.71*/("""',
        imgSrc: '"""),_display_(/*312.19*/routes/*312.25*/.Assets.versioned("images/dashboardnew/chanmothuebao.svg")),format.raw/*312.83*/("""',
        alt: '"""),_display_(/*313.16*/Messages("dashboard.features.blockUnblock")),format.raw/*313.59*/("""',
        name: '"""),_display_(/*314.17*/Messages("dashboard.features.blockUnblock")),format.raw/*314.60*/("""'
      """),format.raw/*315.7*/("""}"""),format.raw/*315.8*/(""",
      """),format.raw/*316.7*/("""{"""),format.raw/*316.8*/("""
        """),format.raw/*317.9*/("""href: '"""),_display_(/*317.17*/routes/*317.23*/.TelcoUtilitiesController.utilitiesManage(userId)),format.raw/*317.72*/("""',
        imgSrc: '"""),_display_(/*318.19*/routes/*318.25*/.Assets.versioned("images/dashboardnew/doigoii.svg")),format.raw/*318.77*/("""',
        alt: '"""),_display_(/*319.16*/Messages("dashboard.features.changePackage")),format.raw/*319.60*/("""',
        name: '"""),_display_(/*320.17*/Messages("dashboard.features.changePackage")),format.raw/*320.61*/("""'
      """),format.raw/*321.7*/("""}"""),format.raw/*321.8*/(""",
      """),format.raw/*322.7*/("""{"""),format.raw/*322.8*/("""
        """),format.raw/*323.9*/("""href: '"""),_display_(/*323.17*/routes/*323.23*/.TelcoUtilitiesController.utilitiesManage(userId)),format.raw/*323.72*/("""',
        imgSrc: '"""),_display_(/*324.19*/routes/*324.25*/.Assets.versioned("images/dashboardnew/huygiahangoi.svg")),format.raw/*324.82*/("""',
        alt: '"""),_display_(/*325.16*/Messages("dashboard.features.cancelAutoRenewal")),format.raw/*325.64*/("""',
        name: '"""),_display_(/*326.17*/Messages("dashboard.features.cancelAutoRenewal")),format.raw/*326.65*/("""'
      """),format.raw/*327.7*/("""}"""),format.raw/*327.8*/(""",
      """),format.raw/*328.7*/("""{"""),format.raw/*328.8*/("""
        """),format.raw/*329.9*/("""href: '"""),_display_(/*329.17*/routes/*329.23*/.TelcoOrderController.buySim(userId)),format.raw/*329.59*/("""',
        imgSrc: '"""),_display_(/*330.19*/routes/*330.25*/.Assets.versioned("images/dashboardnew/datdoisim.svg")),format.raw/*330.79*/("""',
        alt: '"""),_display_(/*331.16*/Messages("dashboard.features.orderSim")),format.raw/*331.55*/("""',
        name: '"""),_display_(/*332.17*/Messages("dashboard.features.orderSim")),format.raw/*332.56*/("""'
      """),format.raw/*333.7*/("""}"""),format.raw/*333.8*/(""",
      """),format.raw/*334.7*/("""{"""),format.raw/*334.8*/("""
        """),format.raw/*335.9*/("""href: '"""),_display_(/*335.17*/routes/*335.23*/.TelcoLocationController.telcoLocation(userId)),format.raw/*335.69*/("""',
        imgSrc: '"""),_display_(/*336.19*/routes/*336.25*/.Assets.versioned("images/dashboardnew/bandogiamsat.svg")),format.raw/*336.82*/("""',
        alt: '"""),_display_(/*337.16*/Messages("dashboard.features.monitoringMap")),format.raw/*337.60*/("""',
        name: '"""),_display_(/*338.17*/Messages("dashboard.features.monitoringMap")),format.raw/*338.61*/("""'
      """),format.raw/*339.7*/("""}"""),format.raw/*339.8*/(""",
      """),format.raw/*340.12*/("""
      """),format.raw/*341.76*/("""
      """),format.raw/*342.89*/("""
      """),format.raw/*343.36*/("""
      """),format.raw/*344.36*/("""
      """),format.raw/*345.12*/("""
    """),format.raw/*346.5*/("""];

    // Lặp qua mảng và tạo các phần tử HTML
    const telcoFeaturesContainer = document.getElementById('telcoFeatures');

    menuItems.forEach(item => """),format.raw/*351.31*/("""{"""),format.raw/*351.32*/("""
      """),format.raw/*352.7*/("""const linkElement = `
              <a href="$"""),format.raw/*353.25*/("""{"""),format.raw/*353.26*/("""item.href"""),format.raw/*353.35*/("""}"""),format.raw/*353.36*/("""" class="telco__features-item">
                  <img class="telco__features-item-img" src="$"""),format.raw/*354.63*/("""{"""),format.raw/*354.64*/("""item.imgSrc"""),format.raw/*354.75*/("""}"""),format.raw/*354.76*/(""""  alt="$"""),format.raw/*354.85*/("""{"""),format.raw/*354.86*/("""item.alt"""),format.raw/*354.94*/("""}"""),format.raw/*354.95*/("""">
                  <span class="telco__features-item-name">$"""),format.raw/*355.60*/("""{"""),format.raw/*355.61*/("""item.name"""),format.raw/*355.70*/("""}"""),format.raw/*355.71*/("""</span>
              </a>
          `;
      telcoFeaturesContainer.innerHTML += linkElement;
    """),format.raw/*359.5*/("""}"""),format.raw/*359.6*/(""");
  </script>
  </body>
</html>
"""))
      }
    }
  }

  def render(currentUser:User,userId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,userId)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,userId) => apply(currentUser,userId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:52 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/dashboard/DashboardTelco.scala.html
                  HASH: 5cb7589d2500e265ba0adbb39a5bde1b08ac8fc2
                  MATRIX: 667->1|703->31|743->65|1092->97|1220->130|1247->131|1416->273|1470->306|1551->360|1566->366|1623->402|1830->583|1844->588|1890->613|1923->619|1963->632|1978->638|2053->692|2120->732|2135->738|2219->801|2285->840|2300->846|2391->916|2458->956|2473->962|2562->1030|2755->1197|2769->1202|2831->1243|2864->1250|2878->1255|2930->1286|2961->1290|3433->1735|3498->1779|3570->1824|3634->1867|3928->2134|3989->2174|4287->2445|4354->2491|4400->2509|4502->2584|4563->2623|4975->3008|5038->3050|5673->3658|5745->3708|6105->4041|6172->4086|6880->4766|6939->4802|6989->4823|10601->8407|10661->8445|10824->8580|10887->8621|11014->8720|11074->8757|11263->8918|11330->8962|11499->9103|11562->9144|11696->9249|11756->9286|11944->9446|12006->9486|12155->9607|12218->9648|12315->9717|12375->9754|12562->9913|12629->9957|12798->10098|12861->10139|12994->10243|13054->10280|13241->10439|13303->10479|13478->10626|13542->10667|13677->10773|13737->10810|13926->10971|13995->11017|14167->11161|14230->11202|14366->11309|14426->11346|14791->11683|14863->11732|15147->11988|15206->12025|15421->12212|15483->12251|15632->12372|15694->12411|15796->12485|15860->12526|16194->12832|16263->12878|16472->13059|16537->13102|16760->13297|16825->13340|17050->13537|17110->13575|17330->13767|17393->13808|17616->14003|17681->14046|17906->14243|17968->14283|18385->14672|18461->14725|18804->15040|18866->15080|19126->15312|19170->15334|19245->15381|19312->15426|19387->15473|19445->15509|19746->15783|19761->15788|19829->15834|19864->15842|19879->15847|19970->15916|20005->15924|20020->15929|20107->15994|20142->16002|20157->16007|20249->16077|20284->16085|20299->16090|20384->16153|20419->16161|20434->16166|20516->16226|20551->16234|20566->16239|20654->16305|20689->16313|20704->16318|20795->16387|20831->16396|20846->16401|20889->16422|20922->16427|21003->16481|21018->16486|21060->16506|21092->16510|21162->16552|21178->16558|21246->16604|21306->16636|21334->16642|21396->16676|21417->16687|21451->16699|21529->16749|21549->16759|21627->16814|21706->16865|21726->16875|21805->16931|21885->16983|21905->16993|21985->17050|22061->17098|22081->17108|22157->17161|22237->17213|22257->17223|22337->17280|22411->17326|22431->17336|22505->17387|22582->17435|22612->17436|22658->17453|22791->17557|22821->17558|22883->17592|22899->17598|22983->17660|23062->17711|23078->17717|23159->17776|23238->17827|23254->17833|23350->17907|23429->17958|23445->17964|23521->18018|23604->18073|23620->18079|23703->18140|23750->18278|23781->18281|23823->18295|23839->18301|23928->18368|23997->18540|24029->18544|24071->18558|24087->18564|24185->18640|24264->18691|24280->18697|24382->18776|24461->18827|24477->18833|24575->18909|24654->18960|24670->18966|24778->19051|24857->19102|24873->19108|24983->19195|25062->19246|25078->19252|25187->19338|25266->19389|25282->19395|25393->19483|25472->19534|25488->19540|25594->19623|25673->19674|25689->19680|25801->19769|25880->19820|25896->19826|26011->19918|26205->20084|26221->20090|26321->20167|26399->20217|26415->20223|26503->20289|26625->20383|26654->20384|26691->20393|26727->20401|26743->20407|26814->20456|26863->20477|26879->20483|26956->20538|27002->20556|27069->20601|27116->20620|27183->20665|27219->20673|27248->20674|27284->20682|27313->20683|27350->20692|27386->20700|27402->20706|27472->20754|27521->20775|27537->20781|27612->20834|27658->20852|27716->20888|27763->20907|27821->20943|27857->20951|27886->20952|27922->20960|27951->20961|27988->20970|28024->20978|28040->20984|28110->21032|28159->21053|28175->21059|28255->21117|28301->21135|28366->21178|28413->21197|28478->21240|28514->21248|28543->21249|28579->21257|28608->21258|28645->21267|28681->21275|28697->21281|28768->21330|28817->21351|28833->21357|28907->21409|28953->21427|29019->21471|29066->21490|29132->21534|29168->21542|29197->21543|29233->21551|29262->21552|29299->21561|29335->21569|29351->21575|29422->21624|29471->21645|29487->21651|29566->21708|29612->21726|29682->21774|29729->21793|29799->21841|29835->21849|29864->21850|29900->21858|29929->21859|29966->21868|30002->21876|30018->21882|30076->21918|30125->21939|30141->21945|30217->21999|30263->22017|30324->22056|30371->22075|30432->22114|30468->22122|30497->22123|30533->22131|30562->22132|30599->22141|30635->22149|30651->22155|30719->22201|30768->22222|30784->22228|30863->22285|30909->22303|30975->22347|31022->22366|31088->22410|31124->22418|31153->22419|31190->22432|31226->22508|31262->22597|31298->22633|31334->22669|31370->22681|31403->22686|31588->22842|31618->22843|31653->22850|31728->22896|31758->22897|31796->22906|31826->22907|31949->23001|31979->23002|32019->23013|32049->23014|32087->23023|32117->23024|32154->23032|32184->23033|32275->23095|32305->23096|32343->23105|32373->23106|32500->23205|32529->23206
                  LINES: 24->1|25->2|26->3|31->4|36->4|37->5|42->10|42->10|43->11|43->11|43->11|48->16|48->16|48->16|50->18|50->18|50->18|50->18|52->20|52->20|52->20|53->21|53->21|53->21|55->23|55->23|55->23|59->27|59->27|59->27|61->29|61->29|61->29|63->31|74->42|74->42|75->43|75->43|81->49|81->49|87->55|87->55|88->56|88->56|88->56|97->65|97->65|113->81|113->81|120->88|120->88|132->100|132->100|133->101|146->114|146->114|148->116|148->116|149->117|149->117|152->120|152->120|154->122|154->122|155->123|155->123|158->126|158->126|160->128|160->128|161->129|161->129|164->132|164->132|166->134|166->134|167->135|167->135|170->138|170->138|172->140|172->140|173->141|173->141|176->144|176->144|178->146|178->146|179->147|179->147|190->158|190->158|196->164|196->164|198->166|198->166|200->168|200->168|201->169|201->169|209->177|209->177|212->180|212->180|216->184|216->184|220->188|220->188|224->192|224->192|228->196|228->196|232->200|232->200|244->212|244->212|252->220|252->220|257->225|257->225|258->226|258->226|259->227|259->227|271->239|271->239|271->239|272->240|272->240|272->240|273->241|273->241|273->241|274->242|274->242|274->242|275->243|275->243|275->243|276->244|276->244|276->244|277->245|277->245|277->245|278->246|278->246|278->246|280->248|280->248|280->248|281->249|285->253|285->253|285->253|287->255|288->256|288->256|288->256|289->257|289->257|290->258|290->258|290->258|291->259|291->259|291->259|292->260|292->260|292->260|293->261|293->261|293->261|294->262|294->262|294->262|295->263|295->263|295->263|296->264|296->264|296->264|298->266|298->266|299->267|301->269|301->269|303->271|303->271|303->271|304->272|304->272|304->272|305->273|305->273|305->273|306->274|306->274|306->274|307->275|307->275|307->275|309->277|310->278|310->278|310->278|310->278|311->279|313->281|313->281|313->281|313->281|314->282|314->282|314->282|315->283|315->283|315->283|316->284|316->284|316->284|317->285|317->285|317->285|318->286|318->286|318->286|319->287|319->287|319->287|320->288|320->288|320->288|321->289|321->289|321->289|322->290|322->290|322->290|324->292|324->292|324->292|325->293|325->293|325->293|330->298|330->298|331->299|331->299|331->299|331->299|332->300|332->300|332->300|333->301|333->301|334->302|334->302|335->303|335->303|336->304|336->304|337->305|337->305|337->305|337->305|338->306|338->306|338->306|339->307|339->307|340->308|340->308|341->309|341->309|342->310|342->310|343->311|343->311|343->311|343->311|344->312|344->312|344->312|345->313|345->313|346->314|346->314|347->315|347->315|348->316|348->316|349->317|349->317|349->317|349->317|350->318|350->318|350->318|351->319|351->319|352->320|352->320|353->321|353->321|354->322|354->322|355->323|355->323|355->323|355->323|356->324|356->324|356->324|357->325|357->325|358->326|358->326|359->327|359->327|360->328|360->328|361->329|361->329|361->329|361->329|362->330|362->330|362->330|363->331|363->331|364->332|364->332|365->333|365->333|366->334|366->334|367->335|367->335|367->335|367->335|368->336|368->336|368->336|369->337|369->337|370->338|370->338|371->339|371->339|372->340|373->341|374->342|375->343|376->344|377->345|378->346|383->351|383->351|384->352|385->353|385->353|385->353|385->353|386->354|386->354|386->354|386->354|386->354|386->354|386->354|386->354|387->355|387->355|387->355|387->355|391->359|391->359
                  -- GENERATED --
              */
          