
package views.html.landingPageTelco

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

object LandingPage_navbar extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<!-- Navbar -->
<nav id="navbar-main" class="navbar navbar-main navbar-expand-lg navbar-transparent navbar-light py-2" style="background-image: url("""),_display_(/*4.134*/routes/*4.140*/.Assets.versioned("images/landingPageTelco/Group_48.jpg")),format.raw/*4.197*/("""); ">
    <div class="col-md-12">
        <div class="row navbar-container">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar_global" aria-controls="navbar_global" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="navbar-collapse collapse" id="navbar_global">
                <div class="navbar-collapse-header">
                    <div class="row">
                        <div class="col-9 collapse-brand">
                            <a style="font-weight: bold; color: red">
                            """),_display_(/*15.30*/Messages("landingPageTelco.navbar.brandName")),format.raw/*15.75*/("""
                            """),format.raw/*16.29*/("""</a>
                        </div>
                        <div class="col-3 collapse-close">
                            <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbar_global" aria-controls="navbar_global" aria-expanded="false" aria-label="Toggle navigation">
                                <span></span>
                                <span></span>
                            </button>
                        </div>
                    </div>
                </div>
                <ul class="navbar-nav navbar-nav-hover align-items-lg-center">
                    <li class="nav-item dropdown navbar-logo">
                        <a class="navbar-brand mr-lg-5" href=""""),_display_(/*28.64*/routes/*28.70*/.LandingPageController.home()),format.raw/*28.99*/("""">
                            <img class="imglogo" src=""""),_display_(/*29.56*/routes/*29.62*/.Assets.versioned("images/landingPageTelco/Logo_Viettel.svg")),format.raw/*29.123*/("""" >
                        </a>
                    </li>
                    <li class="nav-item dropdown">
                        <a onclick="goToByScroll('divgioithieu')" class="nav-link" role="button">
                            <span class="nav-link-inner--text">"""),_display_(/*34.65*/Messages("landingPageTelco.navbar.introduction")),format.raw/*34.113*/("""</span>
                        </a>
                    </li>
                    <li class="nav-item dropdown">
                        <a onclick="goToByScroll('divGioicuoc')" class="nav-link" role="button">
                            <span class="nav-link-inner--text">"""),_display_(/*39.65*/Messages("landingPageTelco.navbar.packages")),format.raw/*39.109*/("""</span>
                            """),format.raw/*40.145*/("""
                        """),format.raw/*41.25*/("""</a>
                    </li>
                    <li onclick="goToByScroll('divSanpham')" class="nav-item dropdown">
                        <a class="nav-link" role="button">
                            <span class="nav-link-inner--text">"""),_display_(/*45.65*/Messages("landingPageTelco.navbar.products")),format.raw/*45.109*/("""</span>
                        </a>
                    </li>
                    <li  onclick="goToByScroll('dathang')" class="nav-item dropdown">
                        <a class="nav-link" role="button">
                            <span class="nav-link-inner--text">"""),_display_(/*50.65*/Messages("landingPageTelco.navbar.iotPlatform")),format.raw/*50.112*/("""</span>
                        </a>
                        """),format.raw/*56.33*/("""
                    """),format.raw/*57.21*/("""</li>
                    <li  onclick="goToByScroll('dathang1')" class="nav-item dropdown">
                        <a class="nav-link" role="button">
                            <span class="nav-link-inner--text">"""),_display_(/*60.65*/Messages("landingPageTelco.navbar.cmpSystem")),format.raw/*60.110*/("""</span>
                        </a>
                    </li>

                    <li class="nav-item dropdown">
                        <a href="#" class="nav-link" data-toggle="dropdown" role="button">
                            <span class="nav-link-inner--text">"""),_display_(/*66.65*/Messages("landingPageTelco.navbar.support")),format.raw/*66.108*/("""</span> <i class="fa fa-angle-down text-white"></i>
                        </a>
                        <div class="dropdown-menu" style="z-index: 999;">
                            <a id="questions-menu" onclick="goToByScroll('divHoiDap')" class="dropdown-item">"""),_display_(/*69.111*/Messages("landingPageTelco.navbar.faq")),format.raw/*69.150*/("""</a>
                            <a id="order-search-menu" href="/tra_cuu_don_hang" class="dropdown-item">"""),_display_(/*70.103*/Messages("landingPageTelco.navbar.orderTracking")),format.raw/*70.152*/("""</a>
                            <a href="https://blog.innoway.vn/forum/dien-dan-iot" target="_blank" class="dropdown-item">"""),_display_(/*71.121*/Messages("landingPageTelco.navbar.forum")),format.raw/*71.162*/("""</a>
                            <a href="/assets/VT_IOT_PLATFORM.pdf" target="_blank" class="dropdown-item">"""),_display_(/*72.106*/Messages("landingPageTelco.navbar.catalog")),format.raw/*72.149*/("""</a>
                        </div>
                    </li>

                </ul>
                <ul class="navbar-nav navbar-nav-hover align-items-lg-center navbar-login">
                """),_display_(/*78.18*/if(currentUser !=null)/*78.40*/{_display_(Seq[Any](format.raw/*78.41*/("""
                    """),format.raw/*79.21*/("""<li class="nav-item dropdown">
                        <a href="#" class="nav-link" data-toggle="dropdown" role="button">
                            <span class="nav-link-inner--text">"""),_display_(/*81.65*/Messages("")),_display_(/*81.78*/currentUser/*81.89*/.getUsername),format.raw/*81.101*/("""</span> <i class="fa fa-angle-down text-black-50"></i>
                        </a>
                        <div class="dropdown-menu" style="z-index: 999;">
                        """),_display_(/*84.26*/if(currentUser.getCmpRole == User.CmpRole.SUPER_ADMIN.getCode() ||
                                currentUser.getCmpRole == User.CmpRole.ADMIN.getCode() || currentUser.getCmpRole == User.CmpRole.SUPER_ENTERPRISE.getCode())/*85.157*/{_display_(Seq[Any](format.raw/*85.158*/("""
                            """),_display_(/*86.30*/if(currentUser.getCmpRole == User.CmpRole.SUPER_ADMIN.getCode())/*86.94*/ {_display_(Seq[Any](format.raw/*86.96*/("""
                                """),format.raw/*87.33*/("""<a href=""""),_display_(/*87.43*/routes/*87.49*/.AdminOverviewController.adminOverview()),format.raw/*87.89*/("""" class="dropdown-item">"""),_display_(/*87.114*/Messages("landingPageTelco.navbar.platformAdmin")),format.raw/*87.163*/("""</a>
                            """)))}),format.raw/*88.30*/("""

                            """),format.raw/*90.29*/("""<a href=""""),_display_(/*90.39*/routes/*90.45*/.TelcoRoleAccountController.accountList()),format.raw/*90.86*/("""" class="dropdown-item">"""),_display_(/*90.111*/Messages("landingPageTelco.navbar.cmpAdmin")),format.raw/*90.155*/("""</a>
                        """)))}/*91.27*/else/*91.32*/{_display_(Seq[Any](format.raw/*91.33*/("""
                            """),_display_(/*92.30*/if(currentUser.getCmpRole == User.CmpRole.ENTERPRISE.getCode() || currentUser.getCmpRole == User.CmpRole.ENTERPRISE_VIEW.getCode())/*92.161*/{_display_(Seq[Any](format.raw/*92.162*/("""
                                """),_display_(/*93.34*/if(currentUser.getProfileStatus && currentUser.getProfileStatus != null)/*93.106*/{_display_(Seq[Any](format.raw/*93.107*/("""
                                    """),format.raw/*94.37*/("""<a href=""""),_display_(/*94.47*/routes/*94.53*/.TelcoSubscriberController.subscriberManage(currentUser.getId)),format.raw/*94.115*/("""" class="dropdown-item" >"""),_display_(/*94.141*/Messages("landingPageTelco.navbar.cmpSystem")),format.raw/*94.186*/("""</a>
                                """)))}/*95.35*/else/*95.39*/{_display_(Seq[Any](format.raw/*95.40*/("""
                                    """),format.raw/*96.37*/("""<a href=""""),_display_(/*96.47*/routes/*96.53*/.TelcoAccountController.accountInfo(currentUser.getId)),format.raw/*96.107*/("""" class="dropdown-item" >"""),_display_(/*96.133*/Messages("landingPageTelco.navbar.cmpSystem")),format.raw/*96.178*/("""</a>
                                """)))}),format.raw/*97.34*/("""
                            """)))}/*98.30*/else/*98.34*/{_display_(Seq[Any](format.raw/*98.35*/("""
                                """),format.raw/*99.33*/("""<a href=""""),_display_(/*99.43*/routes/*99.49*/.TelcoSubscriberController.subscriberManage(currentUser.getId)),format.raw/*99.111*/("""" class="dropdown-item" >"""),_display_(/*99.137*/Messages("landingPageTelco.navbar.cmpSystem")),format.raw/*99.182*/("""</a>
                            """)))}),format.raw/*100.30*/("""

                            """),format.raw/*102.29*/("""<a href=""""),_display_(/*102.39*/routes/*102.45*/.Application.ChangePass()),format.raw/*102.70*/("""" target="_blank" class="dropdown-item">"""),_display_(/*102.111*/Messages("landingPageTelco.navbar.changePassword")),format.raw/*102.161*/("""</a>
                        """)))}),format.raw/*103.26*/("""
                            """),format.raw/*104.29*/("""<a href=""""),_display_(/*104.39*/routes/*104.45*/.Application.logout()),format.raw/*104.66*/("""" class="dropdown-item">"""),_display_(/*104.91*/Messages("landingPageTelco.navbar.logout")),format.raw/*104.133*/("""</a>
                        </div>
                    </li>
                """)))}/*107.19*/else/*107.24*/{_display_(Seq[Any](format.raw/*107.25*/("""
                    """),format.raw/*108.21*/("""<li class="nav-item dropdown">
                        <a href=""""),_display_(/*109.35*/routes/*109.41*/.Application.login()),format.raw/*109.61*/("""" class="nav-link" role="button">
                            <i class="ni ni-collection d-lg-none"></i>
                            <span class="nav-link-inner--text">"""),_display_(/*111.65*/Messages("landingPageTelco.navbar.login")),format.raw/*111.106*/("""</span>
                        </a>
                    </li>
                    <li class="nav-item dropdown button-register">
                        <a href=""""),_display_(/*115.35*/routes/*115.41*/.Application.register()),format.raw/*115.64*/("""" class="nav-link" role="button">
                            <i class="ni ni-collection d-lg-none"></i>
                            <span class="nav-link-inner--text">"""),_display_(/*117.65*/Messages("landingPageTelco.navbar.register")),format.raw/*117.109*/("""</span>
                        </a>
                    </li>
                """)))}),format.raw/*120.18*/("""
                     """),format.raw/*121.22*/("""<li class="nav-item dropdown">
                        <a class="nav-link" href="#" data-toggle="dropdown" role="button">
                            🌐
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" style="z-index: 999;">
                            <a class="dropdown-item" href=""""),_display_(/*126.61*/routes/*126.67*/.Application.setLang("vi")),format.raw/*126.93*/("""">🇻🇳 Tiếng Việt</a>
                            <a class="dropdown-item" href=""""),_display_(/*127.61*/routes/*127.67*/.Application.setLang("uk")),format.raw/*127.93*/("""">🇺🇸 English</a>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="container" style="margin-top: 1rem;">

                <h2 class="display-3 title21">"""),_display_(/*134.48*/Messages("landingPageTelco.navbar.serviceTitle")),format.raw/*134.96*/("""</h2>
                <p class="lead title22">"""),_display_(/*135.42*/Messages("landingPageTelco.navbar.serviceDescription")),format.raw/*135.96*/("""</p>
                <div class="modal-dialog_btn-2column">
                    <a class="button button_primary" style="border-color: #FFFFFF;" onclick="goToByScroll('divSanpham')">"""),_display_(/*137.123*/Messages("landingPageTelco.navbar.iotProducts")),format.raw/*137.170*/("""</a>
                    <a class="button button_primary" style="border-color: #FFFFFF;" onclick="goToByScroll('divGioicuoc')">"""),_display_(/*138.124*/Messages("landingPageTelco.navbar.iotPackages")),format.raw/*138.171*/("""</a>
                </div>
            </div>
        </div>
    </div>
</nav>
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
                  DATE: Mon Sep 22 17:09:16 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPageTelco/LandingPage_navbar.scala.html
                  HASH: c9d37c1925be658aa44f92672d7a2db56165fe48
                  MATRIX: 668->1|1016->35|1129->53|1156->54|1332->203|1347->209|1425->266|2121->935|2187->980|2244->1009|2991->1729|3006->1735|3056->1764|3141->1822|3156->1828|3239->1889|3538->2161|3608->2209|3910->2484|3976->2528|4041->2680|4094->2705|4363->2947|4429->2991|4728->3263|4797->3310|4886->4087|4935->4108|5178->4324|5245->4369|5542->4639|5607->4682|5900->4947|5961->4986|6096->5093|6167->5142|6320->5267|6383->5308|6521->5418|6586->5461|6807->5655|6838->5677|6877->5678|6926->5699|7139->5885|7172->5898|7192->5909|7226->5921|7436->6104|7669->6327|7709->6328|7766->6358|7839->6422|7879->6424|7940->6457|7977->6467|7992->6473|8053->6513|8106->6538|8177->6587|8242->6621|8300->6651|8337->6661|8352->6667|8414->6708|8467->6733|8533->6777|8582->6808|8595->6813|8634->6814|8691->6844|8832->6975|8872->6976|8933->7010|9015->7082|9055->7083|9120->7120|9157->7130|9172->7136|9256->7198|9310->7224|9377->7269|9434->7308|9447->7312|9486->7313|9551->7350|9588->7360|9603->7366|9679->7420|9733->7446|9800->7491|9869->7529|9918->7559|9931->7563|9970->7564|10031->7597|10068->7607|10083->7613|10167->7675|10221->7701|10288->7746|10354->7780|10413->7810|10451->7820|10467->7826|10514->7851|10584->7892|10657->7942|10719->7972|10777->8001|10815->8011|10831->8017|10874->8038|10927->8063|10992->8105|11091->8185|11105->8190|11145->8191|11195->8212|11288->8277|11304->8283|11346->8303|11543->8472|11607->8513|11799->8677|11815->8683|11860->8706|12057->8875|12124->8919|12236->8999|12287->9021|12651->9357|12667->9363|12715->9389|12825->9471|12841->9477|12889->9503|13144->9730|13214->9778|13289->9825|13365->9879|13576->10061|13646->10108|13803->10236|13873->10283
                  LINES: 24->1|29->2|34->2|35->3|36->4|36->4|36->4|47->15|47->15|48->16|60->28|60->28|60->28|61->29|61->29|61->29|66->34|66->34|71->39|71->39|72->40|73->41|77->45|77->45|82->50|82->50|84->56|85->57|88->60|88->60|94->66|94->66|97->69|97->69|98->70|98->70|99->71|99->71|100->72|100->72|106->78|106->78|106->78|107->79|109->81|109->81|109->81|109->81|112->84|113->85|113->85|114->86|114->86|114->86|115->87|115->87|115->87|115->87|115->87|115->87|116->88|118->90|118->90|118->90|118->90|118->90|118->90|119->91|119->91|119->91|120->92|120->92|120->92|121->93|121->93|121->93|122->94|122->94|122->94|122->94|122->94|122->94|123->95|123->95|123->95|124->96|124->96|124->96|124->96|124->96|124->96|125->97|126->98|126->98|126->98|127->99|127->99|127->99|127->99|127->99|127->99|128->100|130->102|130->102|130->102|130->102|130->102|130->102|131->103|132->104|132->104|132->104|132->104|132->104|132->104|135->107|135->107|135->107|136->108|137->109|137->109|137->109|139->111|139->111|143->115|143->115|143->115|145->117|145->117|148->120|149->121|154->126|154->126|154->126|155->127|155->127|155->127|162->134|162->134|163->135|163->135|165->137|165->137|166->138|166->138
                  -- GENERATED --
              */
          