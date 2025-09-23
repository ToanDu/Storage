
package views.html.iot.tags

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

object Menu extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, id:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.31*/("""
"""),format.raw/*4.1*/("""<div class="wrapper">
    <div class="sidebar-wrapper" data-simplebar="true" style="background-color: #F4F5F6;">
        <div class="sidebar-header" style="background-color: white;">
            <div>
                <img src=""""),_display_(/*8.28*/routes/*8.34*/.Assets.versioned("images/dashboard/logo.svg")),format.raw/*8.80*/("""" class="logo-icon" alt="logo icon" style="width: 150px; margin-left: 35px;">
            </div>
            <div class="toggle-icon ms-auto" id="arrowMenu" style="display: none"><i class='bx bx-arrow-to-left'></i>
            </div>
        </div>
            <!--navigation-->
        <ul class="metismenu" id="menu">

            <li id="menu-overview">
                <a href=""""),_display_(/*17.27*/routes/*17.33*/.OverviewController.overview(id)),format.raw/*17.65*/("""">
                    <div class="parent-icon">
                        <img src=""""),_display_(/*19.36*/routes/*19.42*/.Assets.versioned("images/menu/tongquan.png")),format.raw/*19.87*/("""" class="logo-icon" alt="logo icon" style="">
                    </div>
                    <div class="menu-title">"""),_display_(/*21.46*/Messages("manage.home")),format.raw/*21.69*/("""</div>
                </a>
            </li>



            <li class="">
                <a class="has-arrow" aria-expanded="false">
                    <div class="parent-icon">
                        <img src=""""),_display_(/*30.36*/routes/*30.42*/.Assets.versioned("images/menu/device.png")),format.raw/*30.85*/("""" class="logo-icon" alt="logo icon" style="">
                    </div>
                    <div class="menu-title">"""),_display_(/*32.46*/Messages("manage.device")),format.raw/*32.71*/("""</div>
                </a>
                <ul class="mm-collapse">
                    <li id="menu-devkit">
                        <a href=""""),_display_(/*36.35*/routes/*36.41*/.DevkitController.devkit(id)),format.raw/*36.69*/("""">
                            """),format.raw/*37.62*/("""
                            """),format.raw/*38.29*/("""<span style="margin-left: 40px">"""),_display_(/*38.62*/Messages("Devkit")),format.raw/*38.80*/("""</span>
                        </a>
                    </li>
                    <li id="menu-module">
                        <a href=""""),_display_(/*42.35*/routes/*42.41*/.ModuleController.module(id)),format.raw/*42.69*/("""">
                            """),format.raw/*43.67*/("""
                            """),format.raw/*44.29*/("""<span style="margin-left: 40px">"""),_display_(/*44.62*/Messages("Module")),format.raw/*44.80*/("""</span>
                        </a>
                    </li>
                </ul>
            </li>

            <li class="">
                <a class="has-arrow" aria-expanded="false">
                    <div class="parent-icon">
                        <img src=""""),_display_(/*53.36*/routes/*53.42*/.Assets.versioned("images/menu/cloud.png")),format.raw/*53.84*/("""" class="logo-icon" alt="logo icon" style="">
                    </div>
                    <div class="menu-title">"""),_display_(/*55.46*/Messages("manage.cloud")),format.raw/*55.70*/("""</div>
                </a>
                <ul class="mm-collapse">
                    <li id="menu-orgView">
                        <a href=""""),_display_(/*59.35*/routes/*59.41*/.OrginazationController.orginazationView(id)),format.raw/*59.85*/("""">
                            <span style="margin-left: 40px">"""),_display_(/*60.62*/Messages("manage.group.orgView")),format.raw/*60.94*/("""</span>
                        </a>
                    </li>
                    <li id="menu-org">
                        <a href=""""),_display_(/*64.35*/routes/*64.41*/.GroupController.orgList(id)),format.raw/*64.69*/("""">
                            """),format.raw/*65.60*/("""
                            """),format.raw/*66.29*/("""<span style="margin-left: 40px">"""),_display_(/*66.62*/Messages("manage.group.title")),format.raw/*66.92*/("""</span>
                        </a>
                    </li>
                    <li id="menu-deviceTemplate">
                        <a href=""""),_display_(/*70.35*/routes/*70.41*/.DeviceTemplateController.deviceTemplate(id)),format.raw/*70.85*/("""">
                            """),format.raw/*71.66*/("""
                            """),format.raw/*72.29*/("""<span style="margin-left: 40px">"""),_display_(/*72.62*/Messages("deviceTemplate.title")),format.raw/*72.94*/("""</span>
                        </a>
                    </li>
                    <li id="menu-ruleChain">
                        <a href=""""),_display_(/*76.35*/routes/*76.41*/.RuleChainController.ruleChain(id)),format.raw/*76.75*/("""">
                            """),format.raw/*77.59*/("""
                            """),format.raw/*78.29*/("""<span style="margin-left: 40px">"""),_display_(/*78.62*/Messages("manage.ruleChain")),format.raw/*78.90*/("""</span>
                        </a>
                    </li>
                    <li id="menu-dashboard">
                        <a href=""""),_display_(/*82.35*/routes/*82.41*/.DashboardV3Controller.dashboardList(id)),format.raw/*82.81*/("""">
                            """),format.raw/*83.61*/("""
                            """),format.raw/*84.29*/("""<span style="margin-left: 40px">"""),_display_(/*84.62*/Messages("manage.dashboard")),format.raw/*84.90*/("""</span>
                        </a>
                    </li>
                </ul>
            </li>

            <li class="">
                <a class="has-arrow" aria-expanded="false">
                    <div class="parent-icon">
                        <img src=""""),_display_(/*93.36*/routes/*93.42*/.Assets.versioned("images/menu/app.png")),format.raw/*93.82*/("""" class="logo-icon" alt="logo icon" style="">
                    </div>
                    <div class="menu-title">"""),_display_(/*95.46*/Messages("manage.app")),format.raw/*95.68*/("""</div>
                </a>
                <ul class="mm-collapse">
                    <li id="menu-appSdk">
                        <a href=""""),_display_(/*99.35*/routes/*99.41*/.AppDebugController.appSdk(id)),format.raw/*99.71*/("""">
                            """),format.raw/*100.62*/("""
                            """),format.raw/*101.29*/("""<span style="margin-left: 40px">"""),_display_(/*101.62*/Messages("manage.appSdk")),format.raw/*101.87*/("""</span>
                        </a>
                    </li>
                    <li id="menu-appDebug">
                        <a href=""""),_display_(/*105.35*/routes/*105.41*/.AppDebugController.appDebug(id)),format.raw/*105.73*/("""">
                            """),format.raw/*106.58*/("""
                            """),format.raw/*107.29*/("""<span style="margin-left: 40px">"""),_display_(/*107.62*/Messages("manage.debug")),format.raw/*107.86*/("""</span>
                        </a>
                    </li>
                </ul>
            </li>

            <li class="">
                <a class="has-arrow" aria-expanded="false">
                    <div class="parent-icon">
                        <img src=""""),_display_(/*116.36*/routes/*116.42*/.Assets.versioned("images/menu/pay.png")),format.raw/*116.82*/("""" class="logo-icon" alt="logo icon" style="">
                    </div>
                    <div class="menu-title">"""),_display_(/*118.46*/Messages("manage.pay")),format.raw/*118.68*/("""</div>
                </a>
                <ul class="mm-collapse">
                    """),_display_(/*121.22*/if(currentUser.isAdmin)/*121.45*/{_display_(Seq[Any](format.raw/*121.46*/("""
                        """),format.raw/*122.25*/("""<li id="menu-packData">
                            <a href=""""),_display_(/*123.39*/routes/*123.45*/.PayPackDataController.packData(id)),format.raw/*123.80*/("""">
                                """),format.raw/*124.64*/("""
                                """),format.raw/*125.33*/("""<span style="margin-left: 40px">"""),_display_(/*125.66*/Messages("manage.group.packData")),format.raw/*125.99*/("""</span>
                            </a>
                        </li>
                        <li id="menu-customer">
                            <a href=""""),_display_(/*129.39*/routes/*129.45*/.PayCustomerController.payCustomer(id)),format.raw/*129.83*/("""">
                                """),format.raw/*130.63*/("""
                                """),format.raw/*131.33*/("""<span style="margin-left: 40px">"""),_display_(/*131.66*/Messages("manage.group.customer")),format.raw/*131.99*/("""</span>
                            </a>
                        </li>
                        <li id="menu-subs">
                            <a href=""""),_display_(/*135.39*/routes/*135.45*/.PaySubsController.subsList(id)),format.raw/*135.76*/("""">
                                <span style="margin-left: 40px">"""),_display_(/*136.66*/Messages("manage.group.subs")),format.raw/*136.95*/("""</span>
                            </a>
                        </li>
                        <li id="menu-bill">
                            <a href=""""),_display_(/*140.39*/routes/*140.45*/.PayBillController.billList(id)),format.raw/*140.76*/("""">
                                <span style="margin-left: 40px">"""),_display_(/*141.66*/Messages("manage.group.bill")),format.raw/*141.95*/("""</span>
                            </a>
                        </li>
                    """)))}),format.raw/*144.22*/("""
                    """),format.raw/*145.21*/("""<li id="menu-customerPay">
                        <a class="has-arrow" href="javascript:;">
                            <span style="margin-left: 20px"><i class='bx bx-id-card'></i>"""),_display_(/*147.91*/Messages("manage.customer")),format.raw/*147.118*/("""</span>
                        </a>
                        <ul>
                            <li id="menu-billUser">
                                <a href=""""),_display_(/*151.43*/routes/*151.49*/.PayBillController.billUserList(id, currentUser.getId)),format.raw/*151.103*/("""">
                                    <span style="margin-left: 40px">"""),_display_(/*152.70*/Messages("manage.group.billUser")),format.raw/*152.103*/("""</span>
                                </a>
                            </li>
                            <li id="menu-pay">
                                <a href=""""),_display_(/*156.43*/routes/*156.49*/.PayCustomerController.payment(id, currentUser.getId)),format.raw/*156.102*/("""">
                                    <span style="margin-left: 40px">"""),_display_(/*157.70*/Messages("manage.group.pay")),format.raw/*157.98*/("""</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </li>

            <li id="menu-sim">
                <a href=""""),_display_(/*166.27*/routes/*166.33*/.ManageSimController.manageSim(id)),format.raw/*166.67*/("""">
                    <div class="parent-icon">
                        <i class="bx bx-memory-card" style="width: 30px; color: red;"></i>
                    </div>
                    <div class="menu-title">"""),_display_(/*170.46*/Messages("manage.group.sim")),format.raw/*170.74*/("""</div>
                </a>
            </li>

            <li class="">
                <a class="has-arrow" aria-expanded="false">
                    <div class="parent-icon">
                        <img src=""""),_display_(/*177.36*/routes/*177.42*/.Assets.versioned("images/menu/connect.png")),format.raw/*177.86*/("""" class="logo-icon" alt="logo icon" style="">
                    </div>
                    <div class="menu-title">"""),_display_(/*179.46*/Messages("manage.integrated")),format.raw/*179.75*/("""</div>
                </a>
                <ul class="mm-collapse">
                    <li id="menu-tracking">
                        <a class="has-arrow" href="javascript:;">
                            <span style="margin-left: 20px"><i class='bx bx-map-alt'></i>"""),_display_(/*184.91*/Messages("manage.tracking")),format.raw/*184.118*/("""</span>
                        </a>
                        <ul>
                            <li id="menu-tracking-map">
                                <a href=""""),_display_(/*188.43*/routes/*188.49*/.SolutionTrackingController.monitorMap(id)),format.raw/*188.91*/("""">
                                    <span style="margin-left: 40px">"""),_display_(/*189.70*/Messages("manage.tracking.map")),format.raw/*189.101*/("""</span>
                                </a>
                            </li>
                            <li id="menu-tracking-history">
                                <a href=""""),_display_(/*193.43*/routes/*193.49*/.SolutionTrackingController.historyMap(id)),format.raw/*193.91*/("""">
                                    <span style="margin-left: 40px">"""),_display_(/*194.70*/Messages("manage.tracking.history")),format.raw/*194.105*/("""</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li id="menu-smarthome">
                        <a class="has-arrow" href="javascript:;">
                            <span style="margin-left: 20px"><i class='bx bx-home'></i>"""),_display_(/*201.88*/Messages("manage.smarthome")),format.raw/*201.116*/("""</span>
                        </a>
                    </li>
                </ul>
            </li>

            """),format.raw/*207.54*/("""
                """),format.raw/*208.69*/("""
                """),format.raw/*209.42*/("""
                    """),format.raw/*210.73*/("""
                        """),format.raw/*211.90*/("""
                        """),format.raw/*212.35*/("""
                        """),format.raw/*213.89*/("""
                    """),format.raw/*214.29*/("""
                """),format.raw/*215.26*/("""
                """),format.raw/*216.49*/("""
                    """),format.raw/*217.80*/("""
                        """),format.raw/*218.84*/("""
                        """),format.raw/*219.35*/("""
                        """),format.raw/*220.92*/("""
                    """),format.raw/*221.29*/("""
                """),format.raw/*222.26*/("""
            """),format.raw/*223.18*/("""

            """),format.raw/*225.13*/("""<hr>
            <li>
                <a href=""""),_display_(/*227.27*/routes/*227.33*/.Application.logout()),format.raw/*227.54*/("""">
                    <div class="parent-icon"><i class='bx bx-log-out'></i>
                    </div>
                    <div class="menu-title">"""),_display_(/*230.46*/Messages("manage.logout")),format.raw/*230.71*/("""</div>
                </a>
            </li>
        </ul>
    </div>
</div>
<script src=""""),_display_(/*236.15*/routes/*236.21*/.Assets.versioned("javascripts/menu.js")),format.raw/*236.61*/("""" type="text/javascript"></script>"""))
      }
    }
  }

  def render(currentUser:User,id:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,id)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,id) => apply(currentUser,id)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:46 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/tags/Menu.scala.html
                  HASH: fa97d700d8c981ee685bae65dd015856c2465e81
                  MATRIX: 660->1|700->35|1039->67|1163->96|1190->97|1444->325|1458->331|1524->377|1934->760|1949->766|2002->798|2113->882|2128->888|2194->933|2339->1051|2383->1074|2626->1290|2641->1296|2705->1339|2850->1457|2896->1482|3068->1627|3083->1633|3132->1661|3191->1725|3248->1754|3308->1787|3347->1805|3513->1944|3528->1950|3577->1978|3636->2047|3693->2076|3753->2109|3792->2127|4090->2398|4105->2404|4168->2446|4313->2564|4358->2588|4531->2734|4546->2740|4611->2784|4702->2848|4755->2880|4918->3016|4933->3022|4982->3050|5041->3112|5098->3141|5158->3174|5209->3204|5383->3351|5398->3357|5463->3401|5522->3469|5579->3498|5639->3531|5692->3563|5861->3705|5876->3711|5931->3745|5990->3806|6047->3835|6107->3868|6156->3896|6325->4038|6340->4044|6401->4084|6460->4147|6517->4176|6577->4209|6626->4237|6924->4508|6939->4514|7000->4554|7145->4672|7188->4694|7360->4839|7375->4845|7426->4875|7486->4939|7544->4968|7605->5001|7652->5026|7821->5167|7837->5173|7891->5205|7951->5265|8009->5294|8070->5327|8116->5351|8415->5622|8431->5628|8493->5668|8639->5786|8683->5808|8801->5898|8834->5921|8874->5922|8928->5947|9018->6009|9034->6015|9091->6050|9155->6116|9217->6149|9278->6182|9333->6215|9518->6372|9534->6378|9594->6416|9658->6481|9720->6514|9781->6547|9836->6580|10017->6733|10033->6739|10086->6770|10182->6838|10233->6867|10414->7020|10430->7026|10483->7057|10579->7125|10630->7154|10754->7246|10804->7267|11015->7450|11065->7477|11253->7637|11269->7643|11346->7697|11446->7769|11502->7802|11698->7970|11714->7976|11790->8029|11890->8101|11940->8129|12201->8362|12217->8368|12273->8402|12513->8614|12563->8642|12805->8856|12821->8862|12887->8906|13033->9024|13084->9053|13381->9322|13431->9349|13623->9513|13639->9519|13703->9561|13803->9633|13857->9664|14066->9845|14082->9851|14146->9893|14246->9965|14304->10000|14665->10333|14716->10361|14861->10518|14907->10587|14953->10629|15003->10702|15057->10792|15111->10827|15165->10916|15215->10945|15261->10971|15307->11020|15357->11100|15411->11184|15465->11219|15519->11311|15569->11340|15615->11366|15657->11384|15700->11398|15776->11446|15792->11452|15835->11473|16013->11623|16060->11648|16180->11740|16196->11746|16258->11786
                  LINES: 24->1|25->2|30->3|35->3|36->4|40->8|40->8|40->8|49->17|49->17|49->17|51->19|51->19|51->19|53->21|53->21|62->30|62->30|62->30|64->32|64->32|68->36|68->36|68->36|69->37|70->38|70->38|70->38|74->42|74->42|74->42|75->43|76->44|76->44|76->44|85->53|85->53|85->53|87->55|87->55|91->59|91->59|91->59|92->60|92->60|96->64|96->64|96->64|97->65|98->66|98->66|98->66|102->70|102->70|102->70|103->71|104->72|104->72|104->72|108->76|108->76|108->76|109->77|110->78|110->78|110->78|114->82|114->82|114->82|115->83|116->84|116->84|116->84|125->93|125->93|125->93|127->95|127->95|131->99|131->99|131->99|132->100|133->101|133->101|133->101|137->105|137->105|137->105|138->106|139->107|139->107|139->107|148->116|148->116|148->116|150->118|150->118|153->121|153->121|153->121|154->122|155->123|155->123|155->123|156->124|157->125|157->125|157->125|161->129|161->129|161->129|162->130|163->131|163->131|163->131|167->135|167->135|167->135|168->136|168->136|172->140|172->140|172->140|173->141|173->141|176->144|177->145|179->147|179->147|183->151|183->151|183->151|184->152|184->152|188->156|188->156|188->156|189->157|189->157|198->166|198->166|198->166|202->170|202->170|209->177|209->177|209->177|211->179|211->179|216->184|216->184|220->188|220->188|220->188|221->189|221->189|225->193|225->193|225->193|226->194|226->194|233->201|233->201|239->207|240->208|241->209|242->210|243->211|244->212|245->213|246->214|247->215|248->216|249->217|250->218|251->219|252->220|253->221|254->222|255->223|257->225|259->227|259->227|259->227|262->230|262->230|268->236|268->236|268->236
                  -- GENERATED --
              */
          