
package views.html.amarket.marketPlace

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

object MarketPlace_navbar extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<!-- Navbar -->
<nav id="navbar-main" class="navbar navbar-main navbar-expand-lg navbar-transparent navbar-light py-2" style="background-color: white; position: absolute;">
  <div class="col-md-12">
    <div class="row">
      <div class="col-md-12">
        <div class="" >
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar_global" aria-controls="navbar_global" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="navbar-collapse collapse" id="navbar_global">
            <div class="navbar-collapse-header">
              <div class="row">
                <div class="col-9 collapse-brand">
                  <a style="font-weight: bold; color: red">
                    """),_display_(/*17.22*/Messages("landing.title1")),format.raw/*17.48*/("""
                  """),format.raw/*18.19*/("""</a>
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
                <a class="navbar-brand mr-lg-5" href=""""),_display_(/*30.56*/routes/*30.62*/.LandingPageController.home()),format.raw/*30.91*/("""">
                  <img src=""""),_display_(/*31.30*/routes/*31.36*/.Assets.versioned("images/login/logo.svg")),format.raw/*31.78*/("""" style="height: 40px;">
                </a>
              </li>
              <li class="nav-item dropdown">
                <a href=""""),_display_(/*35.27*/routes/*35.33*/.LandingPageController.home()),format.raw/*35.62*/("""" class="nav-link">
                  <span class="nav-link-inner--text">"""),_display_(/*36.55*/Messages("Trang chủ")),format.raw/*36.76*/("""</span>
                </a>
              </li>
              <li class="nav-item dropdown">
                <a href=""""),_display_(/*40.27*/routes/*40.33*/.MarketPlaceController.marketPlace()),format.raw/*40.69*/("""" class="nav-link">
                  <span class="nav-link-inner--text" style="color: #EE0033;">"""),_display_(/*41.79*/Messages("Marketplace")),format.raw/*41.102*/("""</span>
                </a>
              </li>
              <li class="nav-item dropdown">
                <a onclick="" href="#" class="nav-link" data-toggle="dropdown" role="button">
                  <span class="nav-link-inner--text">"""),_display_(/*46.55*/Messages("Developers ")),format.raw/*46.78*/("""</span> <i class="fa fa-angle-down text-black-50"></i>
                </a>
                <div class="dropdown-menu" style="z-index: 999;">
                  <a href="https://vht-iot.gitbook.io/innoway/" target="_blank" class="dropdown-item">"""),_display_(/*49.104*/Messages("Hướng dẫn sử dụng")),format.raw/*49.133*/("""</a>
                  """),_display_(/*50.20*/if(currentUser != null)/*50.43*/{_display_(Seq[Any](format.raw/*50.44*/("""
                    """),format.raw/*51.21*/("""<a href=""""),_display_(/*51.31*/routes/*51.37*/.ProjectController.project()),format.raw/*51.65*/("""" class="dropdown-item">"""),_display_(/*51.90*/Messages("Bắt đầu 1 dự án")),format.raw/*51.117*/("""</a>
                  """)))}/*52.21*/else/*52.26*/{_display_(Seq[Any](format.raw/*52.27*/("""
                    """),format.raw/*53.21*/("""<a href="#" onclick="notiMustLogin()" class="dropdown-item">"""),_display_(/*53.82*/Messages("Bắt đầu 1 dự án")),format.raw/*53.109*/("""</a>
                  """)))}),format.raw/*54.20*/("""
                  """),format.raw/*55.19*/("""<a href=""""),_display_(/*55.29*/routes/*55.35*/.AppDebugController.solutionMaketPage()),format.raw/*55.74*/("""" target="_blank" class="dropdown-item">"""),_display_(/*55.115*/Messages("Giải pháp mẫu")),format.raw/*55.140*/("""</a>
                  <a href=""""),_display_(/*56.29*/routes/*56.35*/.AppDebugController.appSdkPage()),format.raw/*56.67*/("""" target="_blank" class="dropdown-item">"""),_display_(/*56.108*/Messages("App SDK")),format.raw/*56.127*/("""</a>
                  <a href=""""),_display_(/*57.29*/routes/*57.35*/.AppDebugController.appDebugPage()),format.raw/*57.69*/("""" target="_blank" class="dropdown-item">"""),_display_(/*57.110*/Messages("Vsmart Debug")),format.raw/*57.134*/("""</a>
                </div>
              </li>

              <li class="nav-item dropdown">
                <a onclick="" href="#" class="nav-link" data-toggle="dropdown" role="button">
                  <span class="nav-link-inner--text">"""),_display_(/*63.55*/Messages("Cộng đồng")),format.raw/*63.76*/("""</span> <i class="fa fa-angle-down text-black-50"></i>
                </a>
                <div class="dropdown-menu" style="z-index: 999;">
                  <a href="https://blog.innoway.vn/forum/dien-dan-iot" target="_blank" class="dropdown-item">"""),_display_(/*66.111*/Messages("Diễn đàn IoT")),format.raw/*66.135*/("""</a>
                  <a href="https://blog.innoway.vn/tuyen-dung" target="_blank" class="dropdown-item">"""),_display_(/*67.103*/Messages("Tuyển dụng ")),format.raw/*67.126*/("""</a>
                  <a href="https://blog.innoway.vn/giao-duc" target="_blank" class="dropdown-item">"""),_display_(/*68.101*/Messages("Giáo dục ")),format.raw/*68.122*/("""</a>
                  <a href="https://blog.innoway.vn/tin-tuc" target="_blank" class="dropdown-item">"""),_display_(/*69.100*/Messages("Tin tức ")),format.raw/*69.120*/("""</a>
                  <a href="https://blog.innoway.vn/forums" target="_blank" class="dropdown-item">"""),_display_(/*70.99*/Messages("Hỏi đáp ")),format.raw/*70.119*/("""</a>
                </div>
              </li>
            </ul>

            <ul class="navbar-nav navbar-nav-hover align-items-lg-center navbar-login" style="">
            """),_display_(/*76.14*/if(currentUser != null)/*76.37*/{_display_(Seq[Any](format.raw/*76.38*/("""
              """),format.raw/*77.15*/("""<li class="nav-item dropdown">
                <a href="#" class="nav-link" data-toggle="dropdown" role="button">
                  """),format.raw/*79.122*/("""
                  """),format.raw/*80.19*/("""<span class="nav-link-inner--text">"""),_display_(/*80.55*/Messages("Welcome! ")),_display_(/*80.77*/currentUser/*80.88*/.getUsername),format.raw/*80.100*/("""</span> <i class="fa fa-angle-down text-black-50"></i>
                </a>
                <div class="dropdown-menu" style="z-index: 999;">
                  """),_display_(/*83.20*/if(currentUser.getSystemRole == User.SystemRole.SYSTEM_ADMIN.getCode())/*83.91*/{_display_(Seq[Any](format.raw/*83.92*/("""
                    """),format.raw/*84.21*/("""<a href=""""),_display_(/*84.31*/routes/*84.37*/.AdminOverviewController.adminOverview()),format.raw/*84.77*/("""" class="dropdown-item">"""),_display_(/*84.102*/Messages("Quản trị hệ thống ")),format.raw/*84.132*/("""</a>
                  """)))}/*85.21*/else/*85.26*/{_display_(Seq[Any](format.raw/*85.27*/("""
                    """),format.raw/*86.21*/("""<a href=""""),_display_(/*86.31*/routes/*86.37*/.ProjectController.project()),format.raw/*86.65*/("""" target="_blank" class="dropdown-item">"""),_display_(/*86.106*/Messages("Quản trị dự án ")),format.raw/*86.133*/("""</a>
                    <a href=""""),_display_(/*87.31*/routes/*87.37*/.ProductListController.productList(currentUser.getId)),format.raw/*87.90*/("""" target="_blank" class="dropdown-item">"""),_display_(/*87.131*/Messages("Quản lý sản phẩm ")),format.raw/*87.160*/("""</a>
                  """)))}),format.raw/*88.20*/("""
                  """),format.raw/*89.19*/("""<a href=""""),_display_(/*89.29*/routes/*89.35*/.Application.logout()),format.raw/*89.56*/("""" class="dropdown-item">"""),_display_(/*89.81*/Messages("Đăng xuất ")),format.raw/*89.103*/("""</a>
                </div>
              </li>
            """)))}/*92.15*/else/*92.20*/{_display_(Seq[Any](format.raw/*92.21*/("""
              """),format.raw/*93.15*/("""<li class="nav-item dropdown">
                <a href=""""),_display_(/*94.27*/routes/*94.33*/.Application.login()),format.raw/*94.53*/("""" class="nav-link" role="button">
                  <i class="ni ni-collection d-lg-none"></i>
                  <span class="nav-link-inner--text">"""),_display_(/*96.55*/Messages("landing.dangnhap")),format.raw/*96.83*/("""</span>
                </a>
              </li>

              <li class="nav-item dropdown button-register">
                <a href=""""),_display_(/*101.27*/routes/*101.33*/.Application.register()),format.raw/*101.56*/("""" class="nav-link" role="button">
                  <i class="ni ni-collection d-lg-none"></i>
                  <span class="nav-link-inner--text">"""),_display_(/*103.55*/Messages("landing.dangki")),format.raw/*103.81*/("""</span>
                </a>
              </li>
            """)))}),format.raw/*106.14*/("""
            """),format.raw/*107.13*/("""</ul>

          </div>
        </div>
      </div>
    </div>
  </div>
</nav>
  <!-- End Navbar -->"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:40 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/amarket/marketPlace/MarketPlace_navbar.scala.html
                  HASH: c3ffc86a837245db94b2e98fad5c3e61ecd4c166
                  MATRIX: 671->1|1019->35|1132->53|1159->54|2007->875|2054->901|2101->920|2752->1544|2767->1550|2817->1579|2876->1611|2891->1617|2954->1659|3118->1796|3133->1802|3183->1831|3284->1905|3326->1926|3473->2046|3488->2052|3545->2088|3670->2186|3715->2209|3984->2451|4028->2474|4301->2719|4352->2748|4403->2772|4435->2795|4474->2796|4523->2817|4560->2827|4575->2833|4624->2861|4676->2886|4725->2913|4768->2938|4781->2943|4820->2944|4869->2965|4957->3026|5006->3053|5061->3077|5108->3096|5145->3106|5160->3112|5220->3151|5289->3192|5336->3217|5396->3250|5411->3256|5464->3288|5533->3329|5574->3348|5634->3381|5649->3387|5704->3421|5773->3462|5819->3486|6088->3728|6130->3749|6410->4001|6456->4025|6591->4132|6636->4155|6769->4260|6812->4281|6944->4385|6986->4405|7116->4508|7158->4528|7362->4705|7394->4728|7433->4729|7476->4744|7637->4979|7684->4998|7747->5034|7789->5056|7809->5067|7843->5079|8031->5240|8111->5311|8150->5312|8199->5333|8236->5343|8251->5349|8312->5389|8365->5414|8417->5444|8460->5469|8473->5474|8512->5475|8561->5496|8598->5506|8613->5512|8662->5540|8731->5581|8780->5608|8842->5643|8857->5649|8931->5702|9000->5743|9051->5772|9106->5796|9153->5815|9190->5825|9205->5831|9247->5852|9299->5877|9343->5899|9423->5961|9436->5966|9475->5967|9518->5982|9602->6039|9617->6045|9658->6065|9834->6214|9883->6242|10048->6379|10064->6385|10109->6408|10286->6557|10334->6583|10428->6645|10470->6658
                  LINES: 24->1|29->2|34->2|35->3|49->17|49->17|50->18|62->30|62->30|62->30|63->31|63->31|63->31|67->35|67->35|67->35|68->36|68->36|72->40|72->40|72->40|73->41|73->41|78->46|78->46|81->49|81->49|82->50|82->50|82->50|83->51|83->51|83->51|83->51|83->51|83->51|84->52|84->52|84->52|85->53|85->53|85->53|86->54|87->55|87->55|87->55|87->55|87->55|87->55|88->56|88->56|88->56|88->56|88->56|89->57|89->57|89->57|89->57|89->57|95->63|95->63|98->66|98->66|99->67|99->67|100->68|100->68|101->69|101->69|102->70|102->70|108->76|108->76|108->76|109->77|111->79|112->80|112->80|112->80|112->80|112->80|115->83|115->83|115->83|116->84|116->84|116->84|116->84|116->84|116->84|117->85|117->85|117->85|118->86|118->86|118->86|118->86|118->86|118->86|119->87|119->87|119->87|119->87|119->87|120->88|121->89|121->89|121->89|121->89|121->89|121->89|124->92|124->92|124->92|125->93|126->94|126->94|126->94|128->96|128->96|133->101|133->101|133->101|135->103|135->103|138->106|139->107
                  -- GENERATED --
              */
          