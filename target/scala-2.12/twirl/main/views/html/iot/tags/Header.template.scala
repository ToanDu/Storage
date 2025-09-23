
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

object Header extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<header>
    <div class="topbar d-flex align-items-center" style="background: #585757; border-radius: 8px 0px 0px 0px;">
        <nav class="navbar navbar-expand">
            <div class="mobile-toggle-menu"><i class='bx bx-menu'></i>
            </div>

            <div class="top-menu ms-auto">
                <ul class="navbar-nav align-items-center">
                    <li class="nav-item dropdown dropdown-large">
                        <a class="nav-link dropdown-toggle dropdown-toggle-nocaret position-relative text-white" href="https://vht-iot.gitbook.io/innoway/" target="_blank" style="font-size: 18px">
                            <i class='bx bx-notepad'></i>"""),_display_(/*13.59*/Messages("Hướng dẫn sử dụng")),format.raw/*13.88*/("""
                        """),format.raw/*14.25*/("""</a>
                    </li>

                    <li class="nav-item dropdown dropdown-large" style="margin-left: 10px">
                        <a class="nav-link dropdown-toggle dropdown-toggle-nocaret position-relative text-white" id="nameHeaderProject" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="font-size: 18px">
                            <img src=""""),_display_(/*19.40*/routes/*19.46*/.Assets.versioned("images/overview/qlda.svg")),format.raw/*19.91*/(""""> """),_display_(/*19.95*/Messages("project.manage")),format.raw/*19.121*/("""<i class='bx bx-caret-down'></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-end">
                            <a href="javascript:;">
                                <div class="msg-header">
                                    <p class="msg-header-title" >"""),_display_(/*24.67*/Messages("project.list")),format.raw/*24.91*/("""</p>
                                    """),format.raw/*25.98*/("""
                                """),format.raw/*26.33*/("""</div>
                            </a>
                            <div class="header-message-list" id="headerListProject" style="overflow: auto">

                            </div>
                        </div>
                    </li>
                    <li class="nav-item dropdown dropdown-large" style="margin-left: 10px">
                        <a class="nav-link dropdown-toggle dropdown-toggle-nocaret position-relative text-white" style="font-size: 18px">
                            <img src=""""),_display_(/*35.40*/routes/*35.46*/.Assets.versioned("images/overview/config.svg")),format.raw/*35.93*/(""""> <span>"""),_display_(/*35.103*/Messages("Cài đặt")),format.raw/*35.122*/("""</span>
                        </a>
                    </li>
                    <li class="nav-item dropdown dropdown-large" style="margin-left: 10px">
                        <a class="nav-link dropdown-toggle dropdown-toggle-nocaret position-relative text-white" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="font-size: 18px">
                            <img src=""""),_display_(/*40.40*/routes/*40.46*/.Assets.versioned("images/overview/cskh.svg")),format.raw/*40.91*/(""""> """),_display_(/*40.95*/Messages("Hỗ trợ")),format.raw/*40.113*/("""<i class='bx bx-caret-down'></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-end">
                            <a href="javascript:;">
                                <div class="msg-header">
                                    <p class="msg-header-title" >"""),_display_(/*45.67*/Messages("Vui lòng liên hệ ngay với bộ phận hỗ trợ kĩ thuật của chúng tôi")),format.raw/*45.142*/("""</p>
                                </div>
                            </a>
                            <div class="header-message-list" style="height: auto">
                                <a href="tel: 0349784555" target="_blank" class="dropdown-item" ><i class="bx bx-phone"></i> """),_display_(/*49.127*/Messages("Số điện thoại: 0349784555")),format.raw/*49.164*/("""</a>
                                <a href="https://chat.zalo.me" target="_blank" class="dropdown-item" ><i class="bx bx-chat"></i> """),_display_(/*50.131*/Messages("Zalo: 0349784555")),format.raw/*50.159*/("""</a>
                                <a href="mailto: innoway@viettel.com.vn" target="_blank" class="dropdown-item" ><i class="bx bx-envelope"></i> """),_display_(/*51.146*/Messages("Email: ntheanhbk@gmail.com")),format.raw/*51.184*/("""</a>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="user-box dropdown">
                <a class="d-flex align-items-center nav-link dropdown-toggle dropdown-toggle-nocaret" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <img src=""""),_display_(/*59.32*/routes/*59.38*/.Assets.versioned("images/avatar_small2x.jpg")),format.raw/*59.84*/("""" class="user-img" alt="user avatar">
                    <div class="user-info ps-3">
                        <p class="user-name mb-0 text-white">"""),_display_(/*61.63*/currentUser/*61.74*/.getUsername),format.raw/*61.86*/("""</p>
"""),format.raw/*62.83*/("""
                    """),format.raw/*63.21*/("""</div>
                </a>
                <ul class="dropdown-menu dropdown-menu-end">
                    <li><a class="dropdown-item" href=""""),_display_(/*66.57*/routes/*66.63*/.LandingPageController.home()),format.raw/*66.92*/("""" target="_blank"><i class="bx bx-home"></i><span>"""),_display_(/*66.143*/Messages("header.nav.home")),format.raw/*66.170*/("""</span></a>
                    </li>
                    <li>
                        <a class="dropdown-item" href=""""),_display_(/*69.57*/routes/*69.63*/.ProjectController.project()),format.raw/*69.91*/("""" target="_blank">
                            <i class="bx bx-cog"></i><span>"""),_display_(/*70.61*/Messages("project.list")),format.raw/*70.85*/("""</span>
                        </a>
                    </li>
                    <li>
                        <a class="dropdown-item" href="javascript:;" data-bs-toggle="modal" data-bs-target="#createDeviceTokenModal">
                            <i class='bx bx-home-circle'></i><span>"""),_display_(/*75.69*/Messages("user.createDeviceToken")),format.raw/*75.103*/("""</span>
                        </a>
                    </li>
                    <li>
                        <a class="dropdown-item" href="javascript:;" data-bs-toggle="modal" data-bs-target="#getDeviceTokenModal">
                            <i class='bx bx-download'></i><span>"""),_display_(/*80.66*/Messages("user.deviceToken")),format.raw/*80.94*/("""</span>
                        </a>
                    </li>
                    <li><a class="dropdown-item" href="javascript:;"><i class='bx bx-vector'></i><span>"""),_display_(/*83.105*/Messages("header.info.version")),_display_(/*83.137*/currentUser/*83.148*/.getVersion),format.raw/*83.159*/("""</span></a>
                    </li>
                    <li>
                        <div class="dropdown-divider mb-0"></div>
                    </li>
                    <li><a class="dropdown-item" href=""""),_display_(/*88.57*/routes/*88.63*/.Application.logout()),format.raw/*88.84*/(""""><i class='bx bx-log-out-circle'></i><span>"""),_display_(/*88.129*/Messages("header.user.logout")),format.raw/*88.159*/("""</span></a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</header>

"""),_display_(/*96.2*/views/*96.7*/.html.user.UserList_createDeviceToken()),format.raw/*96.46*/("""
"""),_display_(/*97.2*/views/*97.7*/.html.iot.DeviceIot.DeviceIot_getToken(currentUser)),format.raw/*97.58*/("""
"""),format.raw/*98.1*/("""<script src=""""),_display_(/*98.15*/routes/*98.21*/.Assets.versioned("javascripts/views/user/User_deviceToken.js")),format.raw/*98.84*/("""" type="text/javascript"></script>"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:46 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/tags/Header.scala.html
                  HASH: db1a0e33555a9a8ce36eab535413c00b20021040
                  MATRIX: 660->1|996->35|1109->53|1136->54|1841->732|1891->761|1944->786|2366->1181|2381->1187|2447->1232|2478->1236|2526->1262|2860->1569|2905->1593|2974->1695|3035->1728|3572->2238|3587->2244|3655->2291|3693->2301|3734->2320|4155->2714|4170->2720|4236->2765|4267->2769|4307->2787|4641->3094|4738->3169|5052->3455|5111->3492|5274->3627|5324->3655|5501->3805|5561->3843|5975->4230|5990->4236|6057->4282|6233->4431|6253->4442|6286->4454|6319->4541|6368->4562|6540->4707|6555->4713|6605->4742|6684->4793|6733->4820|6879->4939|6894->4945|6943->4973|7049->5052|7094->5076|7411->5366|7467->5400|7778->5684|7827->5712|8022->5879|8075->5911|8096->5922|8129->5933|8367->6144|8382->6150|8424->6171|8497->6216|8549->6246|8692->6363|8705->6368|8765->6407|8793->6409|8806->6414|8878->6465|8906->6466|8947->6480|8962->6486|9046->6549
                  LINES: 24->1|29->2|34->2|35->3|45->13|45->13|46->14|51->19|51->19|51->19|51->19|51->19|56->24|56->24|57->25|58->26|67->35|67->35|67->35|67->35|67->35|72->40|72->40|72->40|72->40|72->40|77->45|77->45|81->49|81->49|82->50|82->50|83->51|83->51|91->59|91->59|91->59|93->61|93->61|93->61|94->62|95->63|98->66|98->66|98->66|98->66|98->66|101->69|101->69|101->69|102->70|102->70|107->75|107->75|112->80|112->80|115->83|115->83|115->83|115->83|120->88|120->88|120->88|120->88|120->88|128->96|128->96|128->96|129->97|129->97|129->97|130->98|130->98|130->98|130->98
                  -- GENERATED --
              */
          