
package views.html.telco.role

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

object Menu extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<div class="wrapper">
    <div class="sidebar-wrapper" data-simplebar="true" style="background-image: url("""),_display_(/*4.86*/routes/*4.92*/.Assets.versioned("images/telco/menu.png")),format.raw/*4.134*/("""">
        <div class="sidebar-header" style="background-color: #940e15;">
            <a class="cursor-pointer" href=""""),_display_(/*6.46*/routes/*6.52*/.LandingPageController.home()),format.raw/*6.81*/("""">
                <img src=""""),_display_(/*7.28*/routes/*7.34*/.Assets.versioned("images/telco/viettel2.svg")),format.raw/*7.80*/("""" class="logo-icon" alt="logo icon" style="width: 150px; margin-left: 35px;">
            </a>
            <div class="toggle-icon ms-auto" id="arrowMenu" style="display: none"><i class='bx bx-arrow-to-left'></i>
            </div>
        </div>
            <!--navigation-->
        <ul class="metismenu" id="menu">
            """),_display_(/*14.14*/if(currentUser.getCmpRole == User.CmpRole.SUPER_ADMIN.getCode())/*14.78*/{_display_(Seq[Any](format.raw/*14.79*/("""
                """),format.raw/*15.17*/("""<li id="menu-accountList">
                    <a href=""""),_display_(/*16.31*/routes/*16.37*/.TelcoRoleAccountController.accountList()),format.raw/*16.78*/("""" class="text-white">
                        <div class="parent-icon">
                            <img src=""""),_display_(/*18.40*/routes/*18.46*/.Assets.versioned("images/telco/tb.svg")),format.raw/*18.86*/("""" class="logo-icon" alt="logo icon" style="">
                        </div>
                        <div class="menu-title">"""),_display_(/*20.50*/Messages("Quản lý tài khoản")),format.raw/*20.79*/("""</div>
                    </a>
                </li>
            """)))}/*23.15*/else/*23.20*/{_display_(Seq[Any](format.raw/*23.21*/("""
                """),format.raw/*24.17*/("""<li id="menu-infoAccountList">
                    <a href=""""),_display_(/*25.31*/routes/*25.37*/.TelcoRoleAccountController.infoAccountCmp(currentUser.getId)),format.raw/*25.98*/("""" class="text-white">
                        <div class="parent-icon">
                            <img src=""""),_display_(/*27.40*/routes/*27.46*/.Assets.versioned("images/telco/hd.svg")),format.raw/*27.86*/("""" class="logo-icon" alt="logo icon" style="">
                        </div>
                        <div class="menu-title">"""),_display_(/*29.50*/Messages("Thông tin tài khoản")),format.raw/*29.81*/("""</div>
                    </a>
                </li>
                """),_display_(/*32.18*/if(currentUser.getCmpRole == User.CmpRole.ADMIN.getCode() || currentUser.getCmpRole == User.CmpRole.SUPER_ENTERPRISE.getCode())/*32.145*/{_display_(Seq[Any](format.raw/*32.146*/("""
                    """),format.raw/*33.21*/("""<li id="menu-accountList">
                        <a href=""""),_display_(/*34.35*/routes/*34.41*/.TelcoRoleAccountController.accountList()),format.raw/*34.82*/("""" class="text-white">
                            <div class="parent-icon">
                                <img src=""""),_display_(/*36.44*/routes/*36.50*/.Assets.versioned("images/telco/tb.svg")),format.raw/*36.90*/("""" class="logo-icon" alt="logo icon" style="">
                            </div>
                            <div class="menu-title">"""),_display_(/*38.54*/Messages("Quản lý tài khoản")),format.raw/*38.83*/("""</div>
                        </a>
                    </li>
                """)))}),format.raw/*41.18*/("""
                """),format.raw/*42.17*/("""<li id="menu-qrCodeList">
                    <a href=""""),_display_(/*43.31*/routes/*43.37*/.TelcoQrcodeController.qrcodeList()),format.raw/*43.72*/("""" class="text-white">
                        <div class="parent-icon">
                            <img src=""""),_display_(/*45.40*/routes/*45.46*/.Assets.versioned("images/telco/setting.svg")),format.raw/*45.91*/("""" class="logo-icon" alt="logo icon" style="">
                        </div>
                        <div class="menu-title">"""),_display_(/*47.50*/Messages("Quản lý QR Code")),format.raw/*47.77*/("""</div>
                    </a>
                </li>

            """)))}),format.raw/*51.14*/("""

            """),_display_(/*53.14*/if(currentUser.getCmpRole == User.CmpRole.SUPER_ADMIN.getCode() || currentUser.getCmpRole == User.CmpRole.ADMIN.getCode())/*53.136*/{_display_(Seq[Any](format.raw/*53.137*/("""
                """),format.raw/*54.17*/("""<li id="menu-companyManage">
                    <a href=""""),_display_(/*55.31*/routes/*55.37*/.AdminTelcoController.approvedInfoCompanyTelco()),format.raw/*55.85*/("""" class="text-white">
                        <div class="parent-icon">
                            <img src=""""),_display_(/*57.40*/routes/*57.46*/.Assets.versioned("images/telco/setting.svg")),format.raw/*57.91*/("""" class="logo-icon" alt="logo icon" style="">
                        </div>
                        <div class="menu-title">"""),_display_(/*59.50*/Messages("Duyệt thông tin KH")),format.raw/*59.80*/("""</div>
                    </a>
                </li>
            """)))}),format.raw/*62.14*/("""

            """),_display_(/*64.14*/if(currentUser.getCmpRole == User.CmpRole.SUPER_ADMIN.getCode())/*64.78*/{_display_(Seq[Any](format.raw/*64.79*/("""
                """),format.raw/*65.17*/("""<li id="menu-logFeedback">
                    <a href=""""),_display_(/*66.31*/routes/*66.37*/.TelcoFeedbackController.logFeedback()),format.raw/*66.75*/("""" class="text-white">
                        <div class="parent-icon">
                            <img src=""""),_display_(/*68.40*/routes/*68.46*/.Assets.versioned("images/telco/hd.svg")),format.raw/*68.86*/("""" class="logo-icon" alt="logo icon" style="">
                        </div>
                        <div class="menu-title">"""),_display_(/*70.50*/Messages("Quản lý góp ý")),format.raw/*70.75*/("""</div>
                    </a>
                </li>

                <li id="menu-logCmp">
                    <a href=""""),_display_(/*75.31*/routes/*75.37*/.TelcoLogController.logCmp()),format.raw/*75.65*/("""" class="text-white">
                        <div class="parent-icon">
                            <img src=""""),_display_(/*77.40*/routes/*77.46*/.Assets.versioned("images/telco/logAPI.svg")),format.raw/*77.90*/("""" class="logo-icon" alt="logo icon" style="">
                        </div>
                        <div class="menu-title">"""),_display_(/*79.50*/Messages("Log API CMP")),format.raw/*79.73*/("""</div>
                    </a>
                </li>

                <li id="menu-logSurvey">
                    <a href=""""),_display_(/*84.31*/routes/*84.37*/.TelcoLogController.logCustomerSurvey()),format.raw/*84.76*/("""" class="text-white">
                        <div class="parent-icon">
                            <img src=""""),_display_(/*86.40*/routes/*86.46*/.Assets.versioned("images/telco/khaosat.svg")),format.raw/*86.91*/("""" class="logo-icon" alt="logo icon" style="">
                        </div>
                        <div class="menu-title">"""),_display_(/*88.50*/Messages("Khảo sát khách hàng")),format.raw/*88.81*/("""</div>
                    </a>
                </li>
            """)))}),format.raw/*91.14*/("""

            """),format.raw/*93.13*/("""<li>
                <a href=""""),_display_(/*94.27*/routes/*94.33*/.Application.logout()),format.raw/*94.54*/("""" class="text-white">
                    <div class="parent-icon"><i class='bx bx-log-out'></i>
                    </div>
                    <div class="menu-title">"""),_display_(/*97.46*/Messages("manage.logout")),format.raw/*97.71*/("""</div>
                </a>
            </li>
        </ul>
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
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/Menu.scala.html
                  HASH: 7445fbd402f5b27c9011a91b288b0bc6e227f0c5
                  MATRIX: 662->1|996->35|1109->53|1136->54|1269->161|1283->167|1346->209|1492->329|1506->335|1555->364|1611->394|1625->400|1691->446|2049->777|2122->841|2161->842|2206->859|2290->916|2305->922|2367->963|2505->1074|2520->1080|2581->1120|2734->1246|2784->1275|2870->1343|2883->1348|2922->1349|2967->1366|3055->1427|3070->1433|3152->1494|3290->1605|3305->1611|3366->1651|3519->1777|3571->1808|3669->1879|3806->2006|3846->2007|3895->2028|3983->2089|3998->2095|4060->2136|4206->2255|4221->2261|4282->2301|4443->2435|4493->2464|4603->2543|4648->2560|4731->2616|4746->2622|4802->2657|4940->2768|4955->2774|5021->2819|5174->2945|5222->2972|5321->3040|5363->3055|5495->3177|5535->3178|5580->3195|5666->3254|5681->3260|5750->3308|5888->3419|5903->3425|5969->3470|6122->3596|6173->3626|6271->3693|6313->3708|6386->3772|6425->3773|6470->3790|6554->3847|6569->3853|6628->3891|6766->4002|6781->4008|6842->4048|6995->4174|7041->4199|7191->4322|7206->4328|7255->4356|7393->4467|7408->4473|7473->4517|7626->4643|7670->4666|7823->4792|7838->4798|7898->4837|8036->4948|8051->4954|8117->4999|8270->5125|8322->5156|8420->5223|8462->5237|8520->5268|8535->5274|8577->5295|8773->5464|8819->5489
                  LINES: 24->1|29->2|34->2|35->3|36->4|36->4|36->4|38->6|38->6|38->6|39->7|39->7|39->7|46->14|46->14|46->14|47->15|48->16|48->16|48->16|50->18|50->18|50->18|52->20|52->20|55->23|55->23|55->23|56->24|57->25|57->25|57->25|59->27|59->27|59->27|61->29|61->29|64->32|64->32|64->32|65->33|66->34|66->34|66->34|68->36|68->36|68->36|70->38|70->38|73->41|74->42|75->43|75->43|75->43|77->45|77->45|77->45|79->47|79->47|83->51|85->53|85->53|85->53|86->54|87->55|87->55|87->55|89->57|89->57|89->57|91->59|91->59|94->62|96->64|96->64|96->64|97->65|98->66|98->66|98->66|100->68|100->68|100->68|102->70|102->70|107->75|107->75|107->75|109->77|109->77|109->77|111->79|111->79|116->84|116->84|116->84|118->86|118->86|118->86|120->88|120->88|123->91|125->93|126->94|126->94|126->94|129->97|129->97
                  -- GENERATED --
              */
          