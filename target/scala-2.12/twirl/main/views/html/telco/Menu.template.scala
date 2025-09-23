
package views.html.telco

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

object Menu extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, gpkd:String, userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.48*/("""
"""),format.raw/*4.1*/("""<div class="wrapper">
    <div class="sidebar-wrapper" data-simplebar="true" style="background-image: url("""),_display_(/*5.86*/routes/*5.92*/.Assets.versioned("images/telco/menu.png")),format.raw/*5.134*/("""">
        <div class="sidebar-header" style="background-color: #940e15;">
            <a class="cursor-pointer" href=""""),_display_(/*7.46*/routes/*7.52*/.LandingPageController.home()),format.raw/*7.81*/("""">
                <img src=""""),_display_(/*8.28*/routes/*8.34*/.Assets.versioned("images/telco/viettel2.svg")),format.raw/*8.80*/("""" class="logo-icon" alt="logo icon" style="width: 180px; margin-left: 20px;">
            </a>
            <div class="toggle-icon ms-auto" id="arrowMenu" style="display: none"><i class='bx bx-arrow-to-left'></i>
            </div>
        </div>
        <div class="side-bar-search">
            <div class="search-container">
                <img alt="logo" src=""""),_display_(/*15.39*/routes/*15.45*/.Assets.versioned("images/telco/search.svg")),format.raw/*15.89*/("""" />
                <input type="text" class="search-input" style="margin-top:5px" placeholder= """"),_display_(/*16.95*/Messages("telco.searchPlaceholder")),format.raw/*16.130*/("""" onkeyup="filterFunction()">
                <div class="dropdown-list-report" id="dropdown-list">
                    <a href=""""),_display_(/*18.31*/routes/*18.37*/.TelcoDashboardController.telcoDashboard(userId)),format.raw/*18.85*/("""">
                        <div class="menu-title">"""),_display_(/*19.50*/Messages("telco.dashboard")),format.raw/*19.77*/("""</div>
                    </a>
                    <a href=""""),_display_(/*21.31*/routes/*21.37*/.TelcoSubscriberController.subscriberManage(userId)),format.raw/*21.88*/("""">
                        <div class="menu-title">"""),_display_(/*22.50*/Messages("telco.subscriberManagement")),format.raw/*22.88*/("""</div>
                    </a>
                    <a href=""""),_display_(/*24.31*/routes/*24.37*/.TelcoOrderController.buySim(userId)),format.raw/*24.73*/("""">
                        <div class="menu-title">"""),_display_(/*25.50*/Messages("telco.buySim")),format.raw/*25.74*/("""</div>
                    </a>
                    <a href=""""),_display_(/*27.31*/routes/*27.37*/.TelcoUtilitiesController.utilitiesManage(userId)),format.raw/*27.86*/("""">
                        <div class="menu-title">"""),_display_(/*28.50*/Messages("telco.buyDataPackage")),format.raw/*28.82*/("""</div>
                    </a>
                    <a href=""""),_display_(/*30.31*/routes/*30.37*/.TelcoUtilitiesController.utilitiesTopup(userId)),format.raw/*30.85*/("""">
                        <div class="menu-title">"""),_display_(/*31.50*/Messages("telco.topup")),format.raw/*31.73*/("""</div>
                    </a>
                    <a href=""""),_display_(/*33.31*/routes/*33.37*/.TelcoUtilitiesController.prepayCharges(userId)),format.raw/*33.84*/("""">
                        <div class="menu-title">"""),_display_(/*34.50*/Messages("telco.prepayCharges")),format.raw/*34.81*/("""</div>
                    </a>
                    <a href=""""),_display_(/*36.31*/routes/*36.37*/.TelcoHistoryController.historyBlockUnblock(userId)),format.raw/*36.88*/("""">
                        <div class="menu-title">"""),_display_(/*37.50*/Messages("telco.blockUnblock")),format.raw/*37.80*/("""</div>
                    </a>
                    <a href=""""),_display_(/*39.31*/routes/*39.37*/.TelcoAPNController.APNview(userId)),format.raw/*39.72*/("""">
                        <div class="menu-title">"""),_display_(/*40.50*/Messages("telco.apn")),format.raw/*40.71*/("""</div>
                    </a>
                    <a href=""""),_display_(/*42.31*/routes/*42.37*/.TelcoLocationController.telcoLocation(userId)),format.raw/*42.83*/("""">
                        <div class="menu-title">"""),_display_(/*43.50*/Messages("telco.monitoringMap")),format.raw/*43.81*/("""</div>
                    </a>
                    <a href=""""),_display_(/*45.31*/routes/*45.37*/.TelcoOrderController.manageOrder(userId)),format.raw/*45.78*/("""">
                        <div class="menu-title">"""),_display_(/*46.50*/Messages("telco.historyBuySim")),format.raw/*46.81*/("""</div>
                    </a>
                    <a href=""""),_display_(/*48.31*/routes/*48.37*/.TelcoHistoryController.historyPackMiAddon(userId)),format.raw/*48.87*/("""">
                        <div class="menu-title">"""),_display_(/*49.50*/Messages("telco.historyMiAddon")),format.raw/*49.82*/("""</div>
                    </a>
                    <a href=""""),_display_(/*51.31*/routes/*51.37*/.TelcoHistoryController.historyDeposit(userId)),format.raw/*51.83*/("""" >
                        <div class="menu-title">"""),_display_(/*52.50*/Messages("telco.historyTopup")),format.raw/*52.80*/("""</div>
                    </a>
                    <a href=""""),_display_(/*54.31*/routes/*54.37*/.TelcoHistoryController.historyPostPaidBill(userId)),format.raw/*54.88*/("""" >
                        <div class="menu-title">"""),_display_(/*55.50*/Messages("telco.historyPostpaidBill")),format.raw/*55.87*/("""</div>
                    </a>
                    <a href=""""),_display_(/*57.31*/routes/*57.37*/.TelcoHistoryController.historyPrepayCharges(userId)),format.raw/*57.89*/("""" >
                        <div class="menu-title">"""),_display_(/*58.50*/Messages("telco.historyPrepayCharges")),format.raw/*58.88*/("""</div>
                    </a>
                    <a href=""""),_display_(/*60.31*/routes/*60.37*/.TelcoHistoryController.historyBlockUnblock(userId)),format.raw/*60.88*/("""" >
                        <div class="menu-title">"""),_display_(/*61.50*/Messages("telco.historyBlockUnblock")),format.raw/*61.87*/("""</div>
                    </a>
                    <a href=""""),_display_(/*63.31*/routes/*63.37*/.TelcoUtilitiesController.payPostpaidBill(userId)),format.raw/*63.86*/("""" >
                        <div class="menu-title">"""),_display_(/*64.50*/Messages("telco.payPostpaidBill")),format.raw/*64.83*/("""</div>
                    </a>
                   <a href=""""),_display_(/*66.30*/routes/*66.36*/.TelcoHistoryController.historyApn(userId)),format.raw/*66.78*/("""">
                       <div class="menu-title">"""),_display_(/*67.49*/Messages("telco.historyApn")),format.raw/*67.77*/("""</div>
                    </a>
"""),format.raw/*69.84*/("""
"""),format.raw/*70.85*/("""
"""),format.raw/*71.28*/("""
                    """),format.raw/*72.21*/("""<a href=""""),_display_(/*72.31*/routes/*72.37*/.InvoiceManagerController.invoiceManage(userId)),format.raw/*72.84*/("""">
                        <div class="menu-title">"""),_display_(/*73.50*/Messages("telco.invoiceManagement")),format.raw/*73.85*/("""</div>
                    </a>
                    <a href=""""),_display_(/*75.31*/routes/*75.37*/.TelcoContractController.contractManage(userId)),format.raw/*75.84*/("""">
                        <div class="menu-title">"""),_display_(/*76.50*/Messages("telco.contractManagement")),format.raw/*76.86*/("""</div>
                    </a> 
                    <a href=""""),_display_(/*78.31*/routes/*78.37*/.TelcoStatisticalReportController.RedBaring(userId)),format.raw/*78.88*/("""">
                        <div class="menu-title">"""),_display_(/*79.50*/Messages("telco.exceedConsumptionLimit")),format.raw/*79.90*/("""</div>
                    </a> 
                    <!-- <a href=""""),_display_(/*81.36*/routes/*81.42*/.TelcoStatisticalReportController.ExpiratedPackage(userId)),format.raw/*81.100*/("""">
                        <div class="menu-title">"""),_display_(/*82.50*/Messages("Thời gian hết hạn gói cước")),format.raw/*82.88*/("""</div>
                    </a> -->
"""),format.raw/*84.87*/("""
"""),format.raw/*85.94*/("""
"""),format.raw/*86.29*/("""
"""),format.raw/*87.83*/("""
"""),format.raw/*88.91*/("""
"""),format.raw/*89.29*/("""
                    """),format.raw/*90.21*/("""<a href=""""),_display_(/*90.31*/routes/*90.37*/.TelcoAccountController.accountInfo(userId)),format.raw/*90.80*/("""">
                        <div class="menu-title">"""),_display_(/*91.50*/Messages("telco.accountInfo")),format.raw/*91.79*/("""</div>
                    </a>
                    <a href=""""),_display_(/*93.31*/routes/*93.37*/.TelcoFeedbackController.feedback(userId)),format.raw/*93.78*/("""">
                        <div class="menu-title">"""),_display_(/*94.50*/Messages("telco.feedback")),format.raw/*94.76*/("""</div>
                    </a>
                </div>
            </div>
        </div>
            <!--navigation-->
        <ul class="metismenu" id="menu">
            <li id="menu-dashboardManage">
                <a href=""""),_display_(/*102.27*/routes/*102.33*/.TelcoDashboardController.telcoDashboard(userId)),format.raw/*102.81*/("""" class="text-white">
                    <div class="parent-icon">
                        <img src=""""),_display_(/*104.36*/routes/*104.42*/.Assets.versioned("images/telco/dashboard.svg")),format.raw/*104.89*/("""" class="logo-icon" alt="logo icon" style="">
                    </div>
                    <div class="menu-title">"""),_display_(/*106.46*/Messages("telco.dashboard")),format.raw/*106.73*/("""</div>
                </a>
            </li>

            """),_display_(/*110.14*/if(UserHelper.isFeatureRole(currentUser, "view_sub"))/*110.67*/{_display_(Seq[Any](format.raw/*110.68*/("""
                """),format.raw/*111.17*/("""<li id="menu-subscriberManage">
                    <a href=""""),_display_(/*112.31*/routes/*112.37*/.TelcoSubscriberController.subscriberManage(userId)),format.raw/*112.88*/("""" class="text-white">
                        <div class="parent-icon">
                            <img src=""""),_display_(/*114.40*/routes/*114.46*/.Assets.versioned("images/telco/subscriberManagement.svg")),format.raw/*114.104*/("""" class="logo-icon" alt="logo icon" style="">
                        </div>
                        <div class="menu-title">"""),_display_(/*116.50*/Messages("telco.subscriberManagement")),format.raw/*116.88*/("""</div>
                    </a>
                </li>
            """)))}),format.raw/*119.14*/("""

            """),_display_(/*121.14*/if(currentUser.getCmpRole != User.CmpRole.ENTERPRISE_VIEW.getCode)/*121.80*/{_display_(Seq[Any](format.raw/*121.81*/("""
                """),format.raw/*122.17*/("""<div class="accordion-sidebar">
                    <div class="accordion-sidebar-item">
                        <div class="accordion-sidebar-header">
                            <div class="accordion-sidebar-title">
                                <img src=""""),_display_(/*126.44*/routes/*126.50*/.Assets.versioned("images/telco/service.svg")),format.raw/*126.95*/("""" class="logo-icon" alt="logo icon" style="">
                                <div class="accordion-sidebar-header-title">"""),_display_(/*127.78*/Messages("telco.services")),format.raw/*127.104*/("""</div>
                            </div>
                            <img alt="logo" src=""""),_display_(/*129.51*/routes/*129.57*/.Assets.versioned("images/telco/arrow_down.svg")),format.raw/*129.105*/("""" class="arrow-right" style="transform: rotate(-90deg);"/>
                            <img alt="logo" src=""""),_display_(/*130.51*/routes/*130.57*/.Assets.versioned("images/telco/arrow_down.svg")),format.raw/*130.105*/("""" class="arrow-down"/>
                        </div>
                        <div class="accordion-sidebar-content">
                            """),_display_(/*133.30*/if(currentUser.getCmpRole != User.CmpRole.ENTERPRISE_LV2.getCode)/*133.95*/{_display_(Seq[Any](format.raw/*133.96*/("""
                                """),format.raw/*134.33*/("""<li id="set-change-sim" class="js-active-check">
                                    <a href=""""),_display_(/*135.47*/routes/*135.53*/.TelcoOrderController.buySim(userId)),format.raw/*135.89*/("""" class="text-white">
                                        <div class="parent-icon">
                                            <img src=""""),_display_(/*137.56*/routes/*137.62*/.Assets.versioned("images/telco/menuItem.svg")),format.raw/*137.108*/("""" class="logo-icon-child" alt="logo icon" style="">
                                        </div>
                                        <div class="menu-title1">"""),_display_(/*139.67*/Messages("telco.buySim")),format.raw/*139.91*/("""</div>
                                    </a>
                                </li>
                            """)))}),format.raw/*142.30*/("""
                            """),format.raw/*143.29*/("""<li id="" class="js-active-check">
                                <a href=""""),_display_(/*144.43*/routes/*144.49*/.TelcoUtilitiesController.utilitiesManage(userId)),format.raw/*144.98*/("""" class="text-white">
                                    <div class="parent-icon">
                                        <img src=""""),_display_(/*146.52*/routes/*146.58*/.Assets.versioned("images/telco/menuItem.svg")),format.raw/*146.104*/("""" class="logo-icon-child" alt="logo icon" style="">
                                    </div>
                                    <div class="menu-title1">"""),_display_(/*148.63*/Messages("telco.buyDataPackage")),format.raw/*148.95*/("""</div>
                                </a>
                            </li>
                            <li id="" class="js-active-check">
                                <a href=""""),_display_(/*152.43*/routes/*152.49*/.TelcoUtilitiesController.utilitiesTopup(userId)),format.raw/*152.97*/("""" class="text-white">
                                    <div class="parent-icon">
                                        <img src=""""),_display_(/*154.52*/routes/*154.58*/.Assets.versioned("images/telco/menuItem.svg")),format.raw/*154.104*/("""" class="logo-icon-child" alt="logo icon" style="">
                                    </div>
                                    <div class="menu-title1">"""),_display_(/*156.63*/Messages("telco.topup")),format.raw/*156.86*/("""</div>
                                </a>
                            </li>
                            <li id="" class="js-active-check">
                               <a href=""""),_display_(/*160.42*/routes/*160.48*/.TelcoUtilitiesController.prepayCharges(userId)),format.raw/*160.95*/("""" class="text-white">
                                   <div class="parent-icon">
                                       <img src=""""),_display_(/*162.51*/routes/*162.57*/.Assets.versioned("images/telco/menuItem.svg")),format.raw/*162.103*/("""" class="logo-icon-child" alt="logo icon" style="">
                                    </div>
                                    <div class="menu-title1">"""),_display_(/*164.63*/Messages("telco.prepayCharges")),format.raw/*164.94*/("""</div>
                               </a>
                            </li>
                             <li id="" class="js-active-check">
                                <a href=""""),_display_(/*168.43*/routes/*168.49*/.TelcoUtilitiesController.payPostpaidBill(userId)),format.raw/*168.98*/("""" class="text-white">
                                    <div class="parent-icon">
                                        <img src=""""),_display_(/*170.52*/routes/*170.58*/.Assets.versioned("images/telco/menuItem.svg")),format.raw/*170.104*/("""" class="logo-icon-child" alt="logo icon" style="">
                                    </div>
                                    <div class="menu-title1">"""),_display_(/*172.63*/Messages("telco.payPostpaidBill")),format.raw/*172.96*/("""</div>
                                </a>
                            </li>
                            <li id="" class="js-active-check">
                                <a href=""""),_display_(/*176.43*/routes/*176.49*/.TelcoUtilitiesController.utilitiesBlock(userId)),format.raw/*176.97*/("""" class="text-white">
                                    <div class="parent-icon">
                                        <img src=""""),_display_(/*178.52*/routes/*178.58*/.Assets.versioned("images/telco/menuItem.svg")),format.raw/*178.104*/("""" class="logo-icon-child" alt="logo icon" style="">
                                    </div>
                                    <div class="menu-title1">"""),_display_(/*180.63*/Messages("telco.blockUnblock")),format.raw/*180.93*/("""</div>
                                </a>
                            </li>
                            <li id="" class="js-active-check">
                                <a href=""""),_display_(/*184.43*/routes/*184.49*/.TelcoAPNController.APNview(userId)),format.raw/*184.84*/("""" class="text-white">
                                    <div class="parent-icon">
                                        <img src=""""),_display_(/*186.52*/routes/*186.58*/.Assets.versioned("images/telco/menuItem.svg")),format.raw/*186.104*/("""" class="logo-icon-child" alt="logo icon" style="">
                                    </div>
                                    <div class="menu-title1">"""),_display_(/*188.63*/Messages("telco.apn")),format.raw/*188.84*/("""</div>
                                </a>
                            </li>
                            """),format.raw/*191.124*/("""
                            """),format.raw/*192.29*/("""<li id="menu-location">
                                <a href=""""),_display_(/*193.43*/routes/*193.49*/.TelcoLocationController.telcoLocation(userId)),format.raw/*193.95*/("""" class="text-white">
                                    <div class="parent-icon">
                                        <img src=""""),_display_(/*195.52*/routes/*195.58*/.Assets.versioned("images/telco/menuItem.svg")),format.raw/*195.104*/("""" class="logo-icon-child" alt="logo icon" style="">
                                    </div>
                                    <div class="menu-title1">"""),_display_(/*197.63*/Messages("telco.monitoringMap")),format.raw/*197.94*/("""</div>
                                </a>
                            </li>
                            """),format.raw/*200.56*/("""
                        """),format.raw/*201.25*/("""</div>
                    </div>
                </div>
            """)))}),format.raw/*204.14*/("""

            """),format.raw/*206.13*/("""<div class="accordion-sidebar">
                <div class="accordion-sidebar-item">
                    <div class="accordion-sidebar-header">
                        <div class="accordion-sidebar-title">
                            <img src=""""),_display_(/*210.40*/routes/*210.46*/.Assets.versioned("images/telco/serviceHistory.svg")),format.raw/*210.98*/("""" class="logo-icon" alt="logo icon" style="">
                            <div class="accordion-sidebar-header-title">"""),_display_(/*211.74*/Messages("telco.serviceHistory")),format.raw/*211.106*/("""</div>
                        </div>
                        <img alt="logo" src=""""),_display_(/*213.47*/routes/*213.53*/.Assets.versioned("images/telco/arrow_down.svg")),format.raw/*213.101*/("""" class="arrow-right" style="transform: rotate(-90deg);"/>
                        <img alt="logo" src=""""),_display_(/*214.47*/routes/*214.53*/.Assets.versioned("images/telco/arrow_down.svg")),format.raw/*214.101*/("""" class="arrow-down"/>
                    </div>
                    <div class="accordion-sidebar-content">
                        <li id="" class="js-active-check">
                            <a href=""""),_display_(/*218.39*/routes/*218.45*/.TelcoOrderController.manageOrder(userId)),format.raw/*218.86*/("""" class="text-white">
                                <div class="parent-icon">
                                    <img src=""""),_display_(/*220.48*/routes/*220.54*/.Assets.versioned("images/telco/menuItem.svg")),format.raw/*220.100*/("""" class="logo-icon-child" alt="logo icon" style="">
                                </div>
                                <div class="menu-title1">"""),_display_(/*222.59*/Messages("telco.historyBuySim")),format.raw/*222.90*/("""</div>
                            </a>
                        </li>
                        """),_display_(/*225.26*/if(currentUser.getCmpRole != User.CmpRole.ENTERPRISE_VIEW.getCode)/*225.92*/{_display_(Seq[Any](format.raw/*225.93*/("""
                            """),format.raw/*226.29*/("""<li id="menu-historyMiAddon" class="js-active-check">
                                <a href=""""),_display_(/*227.43*/routes/*227.49*/.TelcoHistoryController.historyPackMiAddon(userId)),format.raw/*227.99*/("""" class="text-white">
                                    <div class="parent-icon">
                                        <img src=""""),_display_(/*229.52*/routes/*229.58*/.Assets.versioned("images/telco/menuItem.svg")),format.raw/*229.104*/("""" class="logo-icon-child" alt="logo icon" style="">
                                    </div>
                                    <div class="menu-title1">"""),_display_(/*231.63*/Messages("telco.historyMiAddon")),format.raw/*231.95*/("""</div>
                                </a>
                            </li>
                        """)))}),format.raw/*234.26*/("""
                        """),format.raw/*235.25*/("""<li id="" class="js-active-check">
                            <a href=""""),_display_(/*236.39*/routes/*236.45*/.TelcoHistoryController.historyPrepayCharges(userId)),format.raw/*236.97*/("""" class="text-white">
                                <div class="parent-icon">
                                    <img src=""""),_display_(/*238.48*/routes/*238.54*/.Assets.versioned("images/telco/menuItem.svg")),format.raw/*238.100*/("""" class="logo-icon-child" alt="logo icon" style="">
                                </div>
                                <div class="menu-title1">"""),_display_(/*240.59*/Messages("telco.historyPrepayCharges")),format.raw/*240.97*/("""</div>
                            </a>
                        </li>
                        <li id="" class="js-active-check">
                            <a href=""""),_display_(/*244.39*/routes/*244.45*/.TelcoHistoryController.historyPostPaidBill(userId)),format.raw/*244.96*/("""" class="text-white">
                                <div class="parent-icon">
                                    <img src=""""),_display_(/*246.48*/routes/*246.54*/.Assets.versioned("images/telco/menuItem.svg")),format.raw/*246.100*/("""" class="logo-icon-child" alt="logo icon" style="">
                                </div>
                                <div class="menu-title1">"""),_display_(/*248.59*/Messages("telco.historyPostpaidBill")),format.raw/*248.96*/("""</div>
                            </a>
                        </li>
                        <li id="" class="js-active-check">
                            <a href=""""),_display_(/*252.39*/routes/*252.45*/.TelcoHistoryController.historyDeposit(userId)),format.raw/*252.91*/("""" class="text-white">
                                <div class="parent-icon">
                                    <img src=""""),_display_(/*254.48*/routes/*254.54*/.Assets.versioned("images/telco/menuItem.svg")),format.raw/*254.100*/("""" class="logo-icon-child" alt="logo icon" style="">
                                </div>
                                <div class="menu-title1">"""),_display_(/*256.59*/Messages("telco.historyTopup")),format.raw/*256.89*/("""</div>
                            </a>
                        </li>
                        <li id="" class="js-active-check">
                            <a href=""""),_display_(/*260.39*/routes/*260.45*/.TelcoHistoryController.historyBlockUnblock(userId)),format.raw/*260.96*/("""" class="text-white">
                                <div class="parent-icon">
                                    <img src=""""),_display_(/*262.48*/routes/*262.54*/.Assets.versioned("images/telco/menuItem.svg")),format.raw/*262.100*/("""" class="logo-icon-child" alt="logo icon" style="">
                                </div>
                                <div class="menu-title1">"""),_display_(/*264.59*/Messages("telco.historyBlockUnblock")),format.raw/*264.96*/("""</div>
                            </a>
                        </li>
                        <li id="" class="js-active-check">
                            <a href=""""),_display_(/*268.39*/routes/*268.45*/.TelcoHistoryController.historyApn(userId)),format.raw/*268.87*/("""" class="text-white">
                               <div class="parent-icon">
                                    <img src=""""),_display_(/*270.48*/routes/*270.54*/.Assets.versioned("images/telco/menuItem.svg")),format.raw/*270.100*/("""" class="logo-icon-child" alt="logo icon" style="">
                                </div>
                                <div class="menu-title1">"""),_display_(/*272.59*/Messages("telco.historyApn")),format.raw/*272.87*/("""</div>
                            </a>
                        </li>
                    </div>
                </div>
            </div>

"""),format.raw/*279.150*/("""
"""),format.raw/*280.47*/("""
"""),format.raw/*281.103*/("""
"""),format.raw/*282.54*/("""
"""),format.raw/*283.141*/("""
"""),format.raw/*284.35*/("""
"""),format.raw/*285.85*/("""
"""),format.raw/*286.29*/("""
"""),format.raw/*287.26*/("""
"""),format.raw/*288.18*/("""
                """),format.raw/*289.17*/("""<li id="menu-InvoiceManage">
                    <a href=""""),_display_(/*290.31*/routes/*290.37*/.InvoiceManagerController.invoiceManage(userId)),format.raw/*290.84*/("""" class="text-white">
                        <div class="parent-icon">
                            <img src=""""),_display_(/*292.40*/routes/*292.46*/.Assets.versioned("images/telco/contractManagement.svg")),format.raw/*292.102*/("""" class="logo-icon" alt="logo icon" style="">
                        </div>
                        <div class="menu-title">"""),_display_(/*294.50*/Messages("telco.invoiceManagement")),format.raw/*294.85*/("""</div>
                    </a>
                </li>
            """),_display_(/*297.14*/if(UserHelper.isFeatureRole(currentUser, "view_contract") && currentUser.getCmpRole != User.CmpRole.ENTERPRISE_VIEW.getCode)/*297.138*/{_display_(Seq[Any](format.raw/*297.139*/("""
                """),format.raw/*298.17*/("""<li id="menu-contractManage">
                    <a href=""""),_display_(/*299.31*/routes/*299.37*/.TelcoContractController.contractManage(userId)),format.raw/*299.84*/("""" class="text-white">
                        <div class="parent-icon">
                            <img src=""""),_display_(/*301.40*/routes/*301.46*/.Assets.versioned("images/telco/contractManagement.svg")),format.raw/*301.102*/("""" class="logo-icon" alt="logo icon" style="">
                        </div>
                        <div class="menu-title">"""),_display_(/*303.50*/Messages("telco.contractManagement")),format.raw/*303.86*/("""</div>
                    </a>
                </li>
            """)))}),format.raw/*306.14*/("""
               """),format.raw/*307.16*/("""<div class="accordion-sidebar">
                <div class="accordion-sidebar-item">
                    <div class="accordion-sidebar-header">
                        <div class="accordion-sidebar-title">
                            <img src=""""),_display_(/*311.40*/routes/*311.46*/.Assets.versioned("images/telco/serviceHistory.svg")),format.raw/*311.98*/("""" class="logo-icon" alt="logo icon">
                            <div class="accordion-sidebar-header-title" style="max-width:none;">"""),_display_(/*312.98*/Messages("telco.reportStatistics")),format.raw/*312.132*/("""</div>
                        </div>
                        <img alt="logo" src=""""),_display_(/*314.47*/routes/*314.53*/.Assets.versioned("images/telco/arrow_down.svg")),format.raw/*314.101*/("""" class="arrow-right" style="transform: rotate(-90deg);"/>
                        <img alt="logo" src=""""),_display_(/*315.47*/routes/*315.53*/.Assets.versioned("images/telco/arrow_down.svg")),format.raw/*315.101*/("""" class="arrow-down"/>
                    </div>
                    <div class="accordion-sidebar-content">
                        <li id="" class="js-active-check">
                            <a href=""""),_display_(/*319.39*/routes/*319.45*/.TelcoStatisticalReportController.RedBaring(userId)),format.raw/*319.96*/("""" class="text-white" style="height:60px !important;">
                                <div class="parent-icon">
                                    <img src=""""),_display_(/*321.48*/routes/*321.54*/.Assets.versioned("images/telco/menuItem.svg")),format.raw/*321.100*/("""" class="logo-icon-child" alt="logo icon" >
                                </div>
                                <div class="menu-title1">
                                    <span>"""),_display_(/*324.44*/Messages("telco.exceedConsumptionLimit")),format.raw/*324.84*/("""</span>
            
                                </div>
                            </a>
                        </li>
                        <!-- <li id="" class="js-active-check">
                            <a href=""""),_display_(/*330.39*/routes/*330.45*/.TelcoStatisticalReportController.ExpiratedPackage(userId)),format.raw/*330.103*/("""" class="text-white">
                                <div class="parent-icon">
                                    <img src=""""),_display_(/*332.48*/routes/*332.54*/.Assets.versioned("images/telco/menuItem.svg")),format.raw/*332.100*/("""" class="logo-icon-child" alt="logo icon">
                                </div>
                                <div class="menu-title1">"""),_display_(/*334.59*/Messages("Thời gian hết hạn gói cước")),format.raw/*334.97*/("""</div>
                            </a>
                        </li> -->
                    </div>
                </div>
            </div>
           

"""),format.raw/*342.44*/("""
"""),format.raw/*343.101*/("""
"""),format.raw/*344.50*/("""
"""),format.raw/*345.145*/("""
"""),format.raw/*346.31*/("""
"""),format.raw/*347.90*/("""
"""),format.raw/*348.25*/("""
"""),format.raw/*349.22*/("""

                """),format.raw/*351.17*/("""<!-- """),_display_(/*351.23*/if(currentUser.getCmpRole != User.CmpRole.ENTERPRISE_VIEW.getCode)/*351.89*/{_display_(Seq[Any](format.raw/*351.90*/("""
            """),format.raw/*352.13*/("""<li id="menu-utilitiesManage">
                <a href=""""),_display_(/*353.27*/routes/*353.33*/.TelcoUtilitiesController.utilitiesManage(userId)),format.raw/*353.82*/("""" class="text-white">
                    <div class="parent-icon">
                        <img src=""""),_display_(/*355.36*/routes/*355.42*/.Assets.versioned("images/telco/ti.svg")),format.raw/*355.82*/("""" class="logo-icon" alt="logo icon" style="">
                    </div>
                    <div class="menu-title">"""),_display_(/*357.46*/Messages("Tiện ích")),format.raw/*357.66*/("""</div>
                </a>
            </li>

            """),format.raw/*361.84*/("""
                """),format.raw/*362.31*/("""
                """),format.raw/*363.97*/("""
                """),format.raw/*364.46*/("""
                """),format.raw/*365.128*/("""
                """),format.raw/*366.27*/("""
                """),format.raw/*367.80*/("""
                """),format.raw/*368.51*/("""
                """),format.raw/*369.51*/("""
                """),format.raw/*370.130*/("""
                """),format.raw/*371.25*/("""
                """),format.raw/*372.26*/("""
                """),format.raw/*373.22*/("""

            """)))}),format.raw/*375.14*/(""" """),format.raw/*375.15*/("""-->

            <!-- """),_display_(/*377.19*/if(currentUser.getCmpRole != User.CmpRole.ENTERPRISE_LV2.getCode)/*377.84*/{_display_(Seq[Any](format.raw/*377.85*/("""
                """),format.raw/*378.17*/("""<li id="menu-childUser">
                    <a href=""""),_display_(/*379.31*/routes/*379.37*/.TelcoChildUserController.listChildUser(userId)),format.raw/*379.84*/("""" class="text-white">
                        <div class="parent-icon">
                            """),format.raw/*381.135*/("""
                            """),format.raw/*382.29*/("""<i class="bx bx-group" style="font-size: 29px;"></i>
                        </div>
                        <div class="menu-title">"""),_display_(/*384.50*/Messages("Quản lý TK doanh nghiệp cấp 2")),format.raw/*384.91*/("""</div>
                    </a>
                </li>
            """)))}),format.raw/*387.14*/(""" """),format.raw/*387.15*/("""-->
            <!-- """),_display_(/*388.19*/if(currentUser.getCmpRole != User.CmpRole.ENTERPRISE_LV2.getCode && currentUser.getCmpRole != User.CmpRole.ENTERPRISE_VIEW.getCode)/*388.150*/{_display_(Seq[Any](format.raw/*388.151*/("""
                """),format.raw/*389.17*/("""<li id="menu-logConnectSim">
                    <a href=""""),_display_(/*390.31*/routes/*390.37*/.TelcoLogController.logConnectSim(userId)),format.raw/*390.78*/("""" class="text-white">
                        <div class="parent-icon">
                            <img src=""""),_display_(/*392.40*/routes/*392.46*/.Assets.versioned("images/telco/lsdaunoi.svg")),format.raw/*392.92*/("""" class="logo-icon" alt="logo icon" style="">
                        </div>
                        <div class="menu-title">"""),_display_(/*394.50*/Messages("Lịch sử đấu nối")),format.raw/*394.77*/("""</div>
                    </a>
                </li>
            """)))}),format.raw/*397.14*/(""" """),format.raw/*397.15*/("""-->

"""),format.raw/*399.80*/("""
"""),format.raw/*400.39*/("""
"""),format.raw/*401.102*/("""
"""),format.raw/*402.54*/("""
"""),format.raw/*403.149*/("""
"""),format.raw/*404.35*/("""
"""),format.raw/*405.91*/("""
"""),format.raw/*406.29*/("""
"""),format.raw/*407.26*/("""
"""),format.raw/*408.18*/("""

            """),_display_(/*410.14*/if(currentUser.getCmpRole != User.CmpRole.ENTERPRISE_LV2.getCode  )/*410.81*/{_display_(Seq[Any](format.raw/*410.82*/("""
                """),format.raw/*411.17*/("""<li id="menu-account">
                    <a href=""""),_display_(/*412.31*/routes/*412.37*/.TelcoAccountController.accountInfo(userId)),format.raw/*412.80*/("""" class="text-white">
                        <div class="parent-icon">
                            <img src=""""),_display_(/*414.40*/routes/*414.46*/.Assets.versioned("images/telco/accountInfo.svg")),format.raw/*414.95*/("""" class="logo-icon" alt="logo icon" style="">
                        </div>
                        <div class="menu-title">"""),_display_(/*416.50*/Messages("telco.accountInfo")),format.raw/*416.79*/("""</div>
                    </a>
                </li>
            """)))}),format.raw/*419.14*/("""

            """),format.raw/*421.13*/("""<li id="menu-feedback">
                <a href=""""),_display_(/*422.27*/routes/*422.33*/.TelcoFeedbackController.feedback(userId)),format.raw/*422.74*/("""" class="text-white">
                    <div class="parent-icon">
                        <img src=""""),_display_(/*424.36*/routes/*424.42*/.Assets.versioned("images/telco/feedback.svg")),format.raw/*424.88*/("""" class="logo-icon" alt="logo icon" style="">
                    </div>
                    <div class="menu-title">"""),_display_(/*426.46*/Messages("telco.feedback")),format.raw/*426.72*/("""</div>
                </a>
            </li>

            <li>
                <a href=""""),_display_(/*431.27*/routes/*431.33*/.Application.logout()),format.raw/*431.54*/("""" class="text-white">
                    <div class="parent-icon">
                        <img src=""""),_display_(/*433.36*/routes/*433.42*/.Assets.versioned("images/telco/logOut.svg")),format.raw/*433.86*/("""" class="logo-icon" alt="logo icon" style="">
                    </div>
                    <div class="menu-title">"""),_display_(/*435.46*/Messages("manage.logout")),format.raw/*435.71*/("""</div>
                </a>
            </li>
        </ul>
    </div>
</div>
<script src=""""),_display_(/*441.15*/routes/*441.21*/.Assets.versioned("javascripts/menu.js")),format.raw/*441.61*/("""" type="text/javascript"></script>
<link href=""""),_display_(/*442.14*/routes/*442.20*/.Assets.versioned("stylesheets/component/Menu.css")),format.raw/*442.71*/("""" rel="stylesheet" />
<script>
        document.querySelectorAll('.accordion-sidebar-item').forEach(item => """),format.raw/*444.78*/("""{"""),format.raw/*444.79*/("""
            """),format.raw/*445.13*/("""const links = item.querySelectorAll('.accordion-sidebar-content a');
        const currentUrl = window.location.href;

        links.forEach(link => """),format.raw/*448.31*/("""{"""),format.raw/*448.32*/("""
            """),format.raw/*449.13*/("""if (link.href === currentUrl) """),format.raw/*449.43*/("""{"""),format.raw/*449.44*/("""
            """),format.raw/*450.13*/("""item.classList.add('active');
        """),format.raw/*451.9*/("""}"""),format.raw/*451.10*/("""
        """),format.raw/*452.9*/("""}"""),format.raw/*452.10*/(""");
        """),format.raw/*453.9*/("""}"""),format.raw/*453.10*/(""");

        document.querySelectorAll('.accordion-sidebar-header').forEach(header => """),format.raw/*455.82*/("""{"""),format.raw/*455.83*/("""
            """),format.raw/*456.13*/("""header.addEventListener('click', () => """),format.raw/*456.52*/("""{"""),format.raw/*456.53*/("""
            """),format.raw/*457.13*/("""const item = header.parentElement;
        item.classList.toggle('active');
        """),format.raw/*459.9*/("""}"""),format.raw/*459.10*/(""");
        """),format.raw/*460.9*/("""}"""),format.raw/*460.10*/(""");

        document.querySelectorAll('.js-active-check a').forEach(link => """),format.raw/*462.73*/("""{"""),format.raw/*462.74*/("""
            """),format.raw/*463.13*/("""if (link.href === window.location.href) """),format.raw/*463.53*/("""{"""),format.raw/*463.54*/("""
            """),format.raw/*464.13*/("""link.parentElement.classList.add('r_active');
        """),format.raw/*465.9*/("""}"""),format.raw/*465.10*/("""
        """),format.raw/*466.9*/("""}"""),format.raw/*466.10*/(""");
</script>
<script>
        const input = document.querySelector('.search-input');
        const dropdown = document.getElementById('dropdown-list');
        const items = dropdown.getElementsByTagName('a');

        input.addEventListener('focus', () => """),format.raw/*473.47*/("""{"""),format.raw/*473.48*/("""
            """),format.raw/*474.13*/("""dropdown.classList.add('show-list');
        """),format.raw/*475.9*/("""}"""),format.raw/*475.10*/(""");

        document.addEventListener('click', (e) => """),format.raw/*477.51*/("""{"""),format.raw/*477.52*/("""
            """),format.raw/*478.13*/("""if (!e.target.closest('.search-container')) """),format.raw/*478.57*/("""{"""),format.raw/*478.58*/("""
            """),format.raw/*479.13*/("""dropdown.classList.remove('show-list');
        """),format.raw/*480.9*/("""}"""),format.raw/*480.10*/("""
        """),format.raw/*481.9*/("""}"""),format.raw/*481.10*/(""");

        function filterFunction() """),format.raw/*483.35*/("""{"""),format.raw/*483.36*/("""
            """),format.raw/*484.13*/("""const filter = input.value.toLowerCase();
            for (let i = 0; i < items.length; i++) """),format.raw/*485.52*/("""{"""),format.raw/*485.53*/("""
                """),format.raw/*486.17*/("""const text = items[i].textContent || items[i].innerText;
                items[i].style.display = text.toLowerCase().includes(filter) ? "" : "none";
            """),format.raw/*488.13*/("""}"""),format.raw/*488.14*/("""
        """),format.raw/*489.9*/("""}"""),format.raw/*489.10*/("""
"""),format.raw/*490.1*/("""</script>
"""))
      }
    }
  }

  def render(currentUser:User,gpkd:String,userId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,gpkd,userId)

  def f:((User,String,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,gpkd,userId) => apply(currentUser,gpkd,userId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Sep 23 11:31:25 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/Menu.scala.html
                  HASH: 40757c015afef89079ee69a42b8f0b48df5cd4e7
                  MATRIX: 657->1|697->35|1043->67|1184->113|1211->114|1344->221|1358->227|1421->269|1567->389|1581->395|1630->424|1686->454|1700->460|1766->506|2159->872|2174->878|2239->922|2365->1021|2422->1056|2579->1186|2594->1192|2663->1240|2742->1292|2790->1319|2879->1381|2894->1387|2966->1438|3045->1490|3104->1528|3193->1590|3208->1596|3265->1632|3344->1684|3389->1708|3478->1770|3493->1776|3563->1825|3642->1877|3695->1909|3784->1971|3799->1977|3868->2025|3947->2077|3991->2100|4080->2162|4095->2168|4163->2215|4242->2267|4294->2298|4383->2360|4398->2366|4470->2417|4549->2469|4600->2499|4689->2561|4704->2567|4760->2602|4839->2654|4881->2675|4970->2737|4985->2743|5052->2789|5131->2841|5183->2872|5272->2934|5287->2940|5349->2981|5428->3033|5480->3064|5569->3126|5584->3132|5655->3182|5734->3234|5787->3266|5876->3328|5891->3334|5958->3380|6038->3433|6089->3463|6178->3525|6193->3531|6265->3582|6345->3635|6403->3672|6492->3734|6507->3740|6580->3792|6660->3845|6719->3883|6808->3945|6823->3951|6895->4002|6975->4055|7033->4092|7122->4154|7137->4160|7207->4209|7287->4262|7341->4295|7429->4356|7444->4362|7507->4404|7585->4455|7634->4483|7694->4598|7723->4683|7752->4711|7801->4732|7838->4742|7853->4748|7921->4795|8000->4847|8056->4882|8145->4944|8160->4950|8228->4997|8307->5049|8364->5085|8454->5148|8469->5154|8541->5205|8620->5257|8681->5297|8776->5365|8791->5371|8871->5429|8950->5481|9009->5519|9073->5641|9102->5735|9131->5764|9160->5847|9189->5938|9218->5967|9267->5988|9304->5998|9319->6004|9383->6047|9462->6099|9512->6128|9601->6190|9616->6196|9678->6237|9757->6289|9804->6315|10061->6544|10077->6550|10147->6598|10278->6701|10294->6707|10363->6754|10509->6872|10558->6899|10646->6959|10709->7012|10749->7013|10795->7030|10885->7092|10901->7098|10974->7149|11113->7260|11129->7266|11210->7324|11364->7450|11424->7488|11523->7555|11566->7570|11642->7636|11682->7637|11728->7654|12017->7915|12033->7921|12100->7966|12251->8089|12300->8115|12420->8207|12436->8213|12507->8261|12644->8370|12660->8376|12731->8424|12906->8571|12981->8636|13021->8637|13083->8670|13206->8765|13222->8771|13280->8807|13451->8950|13467->8956|13536->9002|13729->9167|13775->9191|13922->9306|13980->9335|14085->9412|14101->9418|14172->9467|14335->9602|14351->9608|14420->9654|14605->9811|14659->9843|14870->10026|14886->10032|14956->10080|15119->10215|15135->10221|15204->10267|15389->10424|15434->10447|15644->10629|15660->10635|15729->10682|15890->10815|15906->10821|15975->10867|16160->11024|16213->11055|16424->11238|16440->11244|16511->11293|16674->11428|16690->11434|16759->11480|16944->11637|16999->11670|17210->11853|17226->11859|17296->11907|17459->12042|17475->12048|17544->12094|17729->12251|17781->12281|17992->12464|18008->12470|18065->12505|18228->12640|18244->12646|18313->12692|18498->12849|18541->12870|18677->13071|18735->13100|18829->13166|18845->13172|18913->13218|19076->13353|19092->13359|19161->13405|19346->13562|19399->13593|19534->13726|19588->13751|19690->13821|19733->13835|20006->14080|20022->14086|20096->14138|20243->14257|20298->14289|20410->14373|20426->14379|20497->14427|20630->14532|20646->14538|20717->14586|20952->14793|20968->14799|21031->14840|21186->14967|21202->14973|21271->15019|21448->15168|21501->15199|21624->15294|21700->15360|21740->15361|21798->15390|21922->15486|21938->15492|22010->15542|22173->15677|22189->15683|22258->15729|22443->15886|22497->15918|22632->16021|22686->16046|22787->16119|22803->16125|22877->16177|23032->16304|23048->16310|23117->16356|23294->16505|23354->16543|23549->16710|23565->16716|23638->16767|23793->16894|23809->16900|23878->16946|24055->17095|24114->17132|24309->17299|24325->17305|24393->17351|24548->17478|24564->17484|24633->17530|24810->17679|24862->17709|25057->17876|25073->17882|25146->17933|25301->18060|25317->18066|25386->18112|25563->18261|25622->18298|25817->18465|25833->18471|25897->18513|26051->18639|26067->18645|26136->18691|26313->18840|26363->18868|26533->19157|26563->19204|26594->19307|26624->19361|26655->19502|26685->19537|26715->19622|26745->19651|26775->19677|26805->19695|26851->19712|26938->19771|26954->19777|27023->19824|27162->19935|27178->19941|27257->19997|27411->20123|27468->20158|27563->20225|27698->20349|27739->20350|27785->20367|27873->20427|27889->20433|27958->20480|28097->20591|28113->20597|28192->20653|28346->20779|28404->20815|28503->20882|28548->20898|28821->21143|28837->21149|28911->21201|29073->21335|29130->21369|29242->21453|29258->21459|29329->21507|29462->21612|29478->21618|29549->21666|29784->21873|29800->21879|29873->21930|30060->22089|30076->22095|30145->22141|30357->22325|30419->22365|30672->22590|30688->22596|30769->22654|30924->22781|30940->22787|31009->22833|31177->22973|31237->23011|31422->23210|31453->23311|31483->23361|31514->23506|31544->23537|31574->23627|31604->23652|31634->23674|31681->23692|31715->23698|31791->23764|31831->23765|31873->23778|31958->23835|31974->23841|32045->23890|32176->23993|32192->23999|32254->24039|32400->24157|32442->24177|32530->24307|32576->24338|32622->24435|32668->24481|32715->24609|32761->24636|32807->24716|32853->24767|32899->24818|32946->24948|32992->24973|33038->24999|33084->25021|33131->25036|33161->25037|33212->25060|33287->25125|33327->25126|33373->25143|33456->25198|33472->25204|33541->25251|33671->25457|33729->25486|33890->25619|33953->25660|34052->25727|34082->25728|34132->25750|34274->25881|34315->25882|34361->25899|34448->25958|34464->25964|34527->26005|34666->26116|34682->26122|34750->26168|34904->26294|34953->26321|35052->26388|35082->26389|35116->26473|35146->26512|35177->26614|35207->26668|35238->26817|35268->26852|35298->26943|35328->26972|35358->26998|35388->27016|35431->27031|35508->27098|35548->27099|35594->27116|35675->27169|35691->27175|35756->27218|35895->27329|35911->27335|35982->27384|36136->27510|36187->27539|36286->27606|36329->27620|36407->27670|36423->27676|36486->27717|36617->27820|36633->27826|36701->27872|36847->27990|36895->28016|37013->28106|37029->28112|37072->28133|37203->28236|37219->28242|37285->28286|37431->28404|37478->28429|37598->28521|37614->28527|37676->28567|37752->28615|37768->28621|37841->28672|37978->28780|38008->28781|38050->28794|38228->28943|38258->28944|38300->28957|38359->28987|38389->28988|38431->29001|38497->29039|38527->29040|38564->29049|38594->29050|38633->29061|38663->29062|38777->29147|38807->29148|38849->29161|38917->29200|38947->29201|38989->29214|39101->29298|39131->29299|39170->29310|39200->29311|39305->29387|39335->29388|39377->29401|39446->29441|39476->29442|39518->29455|39600->29509|39630->29510|39667->29519|39697->29520|39983->29777|40013->29778|40055->29791|40128->29836|40158->29837|40241->29891|40271->29892|40313->29905|40386->29949|40416->29950|40458->29963|40534->30011|40564->30012|40601->30021|40631->30022|40698->30060|40728->30061|40770->30074|40892->30167|40922->30168|40968->30185|41158->30346|41188->30347|41225->30356|41255->30357|41284->30358
                  LINES: 24->1|25->2|30->3|35->3|36->4|37->5|37->5|37->5|39->7|39->7|39->7|40->8|40->8|40->8|47->15|47->15|47->15|48->16|48->16|50->18|50->18|50->18|51->19|51->19|53->21|53->21|53->21|54->22|54->22|56->24|56->24|56->24|57->25|57->25|59->27|59->27|59->27|60->28|60->28|62->30|62->30|62->30|63->31|63->31|65->33|65->33|65->33|66->34|66->34|68->36|68->36|68->36|69->37|69->37|71->39|71->39|71->39|72->40|72->40|74->42|74->42|74->42|75->43|75->43|77->45|77->45|77->45|78->46|78->46|80->48|80->48|80->48|81->49|81->49|83->51|83->51|83->51|84->52|84->52|86->54|86->54|86->54|87->55|87->55|89->57|89->57|89->57|90->58|90->58|92->60|92->60|92->60|93->61|93->61|95->63|95->63|95->63|96->64|96->64|98->66|98->66|98->66|99->67|99->67|101->69|102->70|103->71|104->72|104->72|104->72|104->72|105->73|105->73|107->75|107->75|107->75|108->76|108->76|110->78|110->78|110->78|111->79|111->79|113->81|113->81|113->81|114->82|114->82|116->84|117->85|118->86|119->87|120->88|121->89|122->90|122->90|122->90|122->90|123->91|123->91|125->93|125->93|125->93|126->94|126->94|134->102|134->102|134->102|136->104|136->104|136->104|138->106|138->106|142->110|142->110|142->110|143->111|144->112|144->112|144->112|146->114|146->114|146->114|148->116|148->116|151->119|153->121|153->121|153->121|154->122|158->126|158->126|158->126|159->127|159->127|161->129|161->129|161->129|162->130|162->130|162->130|165->133|165->133|165->133|166->134|167->135|167->135|167->135|169->137|169->137|169->137|171->139|171->139|174->142|175->143|176->144|176->144|176->144|178->146|178->146|178->146|180->148|180->148|184->152|184->152|184->152|186->154|186->154|186->154|188->156|188->156|192->160|192->160|192->160|194->162|194->162|194->162|196->164|196->164|200->168|200->168|200->168|202->170|202->170|202->170|204->172|204->172|208->176|208->176|208->176|210->178|210->178|210->178|212->180|212->180|216->184|216->184|216->184|218->186|218->186|218->186|220->188|220->188|223->191|224->192|225->193|225->193|225->193|227->195|227->195|227->195|229->197|229->197|232->200|233->201|236->204|238->206|242->210|242->210|242->210|243->211|243->211|245->213|245->213|245->213|246->214|246->214|246->214|250->218|250->218|250->218|252->220|252->220|252->220|254->222|254->222|257->225|257->225|257->225|258->226|259->227|259->227|259->227|261->229|261->229|261->229|263->231|263->231|266->234|267->235|268->236|268->236|268->236|270->238|270->238|270->238|272->240|272->240|276->244|276->244|276->244|278->246|278->246|278->246|280->248|280->248|284->252|284->252|284->252|286->254|286->254|286->254|288->256|288->256|292->260|292->260|292->260|294->262|294->262|294->262|296->264|296->264|300->268|300->268|300->268|302->270|302->270|302->270|304->272|304->272|311->279|312->280|313->281|314->282|315->283|316->284|317->285|318->286|319->287|320->288|321->289|322->290|322->290|322->290|324->292|324->292|324->292|326->294|326->294|329->297|329->297|329->297|330->298|331->299|331->299|331->299|333->301|333->301|333->301|335->303|335->303|338->306|339->307|343->311|343->311|343->311|344->312|344->312|346->314|346->314|346->314|347->315|347->315|347->315|351->319|351->319|351->319|353->321|353->321|353->321|356->324|356->324|362->330|362->330|362->330|364->332|364->332|364->332|366->334|366->334|374->342|375->343|376->344|377->345|378->346|379->347|380->348|381->349|383->351|383->351|383->351|383->351|384->352|385->353|385->353|385->353|387->355|387->355|387->355|389->357|389->357|393->361|394->362|395->363|396->364|397->365|398->366|399->367|400->368|401->369|402->370|403->371|404->372|405->373|407->375|407->375|409->377|409->377|409->377|410->378|411->379|411->379|411->379|413->381|414->382|416->384|416->384|419->387|419->387|420->388|420->388|420->388|421->389|422->390|422->390|422->390|424->392|424->392|424->392|426->394|426->394|429->397|429->397|431->399|432->400|433->401|434->402|435->403|436->404|437->405|438->406|439->407|440->408|442->410|442->410|442->410|443->411|444->412|444->412|444->412|446->414|446->414|446->414|448->416|448->416|451->419|453->421|454->422|454->422|454->422|456->424|456->424|456->424|458->426|458->426|463->431|463->431|463->431|465->433|465->433|465->433|467->435|467->435|473->441|473->441|473->441|474->442|474->442|474->442|476->444|476->444|477->445|480->448|480->448|481->449|481->449|481->449|482->450|483->451|483->451|484->452|484->452|485->453|485->453|487->455|487->455|488->456|488->456|488->456|489->457|491->459|491->459|492->460|492->460|494->462|494->462|495->463|495->463|495->463|496->464|497->465|497->465|498->466|498->466|505->473|505->473|506->474|507->475|507->475|509->477|509->477|510->478|510->478|510->478|511->479|512->480|512->480|513->481|513->481|515->483|515->483|516->484|517->485|517->485|518->486|520->488|520->488|521->489|521->489|522->490
                  -- GENERATED --
              */
          