
package views.html.landingPage.page

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

object RegisterDeveloper_navbar extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<!-- Navbar -->
<nav id="navbar-main" class="navbar navbar-main navbar-expand-lg navbar-transparent navbar-light py-2" style="background-color: white;">
  <div class="col-md-12">
    <div class="row">
      <div class="col-md-12 container" style="">
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
                <a href=""""),_display_(/*36.27*/routes/*36.33*/.LandingPageController.home()),format.raw/*36.62*/("""" class="nav-link" role="button">
                  <span class="nav-link-inner--text">"""),_display_(/*37.55*/Messages("Trang chủ")),format.raw/*37.76*/("""</span>
                  <span class="nav-link-inner--text showMobile">"""),_display_(/*38.66*/Messages("Landing Page")),format.raw/*38.90*/("""</span>
                </a>
              </li>

              <li class="nav-item dropdown">
                <a href="https://blog.innoway.vn/forum/dien-dan-iot" target="_blank" class="nav-link" role="button">
                  <span class="nav-link-inner--text">"""),_display_(/*44.55*/Messages("Cộng đồng")),format.raw/*44.76*/("""</span>
                  <span class="nav-link-inner--text showMobile">"""),_display_(/*45.66*/Messages("Diễn đàn Iot")),format.raw/*45.90*/("""</span>
                </a>
              </li>

              <li class="nav-item dropdown">
                <a href=""""),_display_(/*50.27*/routes/*50.33*/.MarketPlaceController.marketPlace()),format.raw/*50.69*/("""" class="nav-link" role="button">
                  <span class="nav-link-inner--text">"""),_display_(/*51.55*/Messages("Market Place")),format.raw/*51.79*/("""</span>
                  <span class="nav-link-inner--text showMobile">"""),_display_(/*52.66*/Messages("Chợ công nghệ IoT")),format.raw/*52.95*/("""</span>
                </a>
              </li>

              <li class="nav-item dropdown">
                <a onclick="" href="#" class="nav-link" data-toggle="dropdown" role="button">
                  <span class="nav-link-inner--text">"""),_display_(/*58.55*/Messages("Developers ")),format.raw/*58.78*/("""</span> <i class="fa fa-angle-down text-black-50"></i>
                  <span class="nav-link-inner--text showMobile">"""),_display_(/*59.66*/Messages("Công cụ lập trình ")),format.raw/*59.96*/("""</span>
                </a>
                <div class="dropdown-menu" style="z-index: 999;">
                  <a href=""""),_display_(/*62.29*/routes/*62.35*/.LandingPageController.registerDeveloper()),format.raw/*62.77*/("""" target="_blank" class="dropdown-item">"""),_display_(/*62.118*/Messages("Đăng ký trở thành Dev/SI")),format.raw/*62.154*/("""</a>
                  <a href="https://vht-iot.gitbook.io/innoway/" target="_blank" class="dropdown-item">"""),_display_(/*63.104*/Messages("Hướng dẫn sử dụng")),format.raw/*63.133*/("""</a>
                  """),_display_(/*64.20*/if(currentUser != null)/*64.43*/{_display_(Seq[Any](format.raw/*64.44*/("""
                    """),format.raw/*65.21*/("""<a href=""""),_display_(/*65.31*/routes/*65.37*/.ProjectController.project()),format.raw/*65.65*/("""" class="dropdown-item">"""),_display_(/*65.90*/Messages("Bắt đầu 1 dự án")),format.raw/*65.117*/("""</a>
                  """)))}/*66.21*/else/*66.26*/{_display_(Seq[Any](format.raw/*66.27*/("""
                    """),format.raw/*67.21*/("""<a href="#" onclick="notiMustLogin()" class="dropdown-item">"""),_display_(/*67.82*/Messages("Bắt đầu 1 dự án")),format.raw/*67.109*/("""</a>
                  """)))}),format.raw/*68.20*/("""
                  """),format.raw/*69.19*/("""<a href=""""),_display_(/*69.29*/routes/*69.35*/.AppDebugController.solutionMaketPage()),format.raw/*69.74*/("""" target="_blank" class="dropdown-item">"""),_display_(/*69.115*/Messages("Giải pháp mẫu")),format.raw/*69.140*/("""</a>
                  <a href=""""),_display_(/*70.29*/routes/*70.35*/.AppDebugController.appSdkPage()),format.raw/*70.67*/("""" target="_blank" class="dropdown-item">"""),_display_(/*70.108*/Messages("App SDK")),format.raw/*70.127*/("""</a>
                  <a href=""""),_display_(/*71.29*/routes/*71.35*/.AppDebugController.appDebugPage()),format.raw/*71.69*/("""" target="_blank" class="dropdown-item">"""),_display_(/*71.110*/Messages("Vsmart Debug")),format.raw/*71.134*/("""</a>
                </div>
              </li>

              <li class="nav-item dropdown">
                <a onclick="" href="#" class="nav-link" data-toggle="dropdown" role="button">
                  <span class="nav-link-inner--text">"""),_display_(/*77.55*/Messages("Công ty ")),format.raw/*77.75*/("""</span> <i class="fa fa-angle-down text-black-50"></i>
                  <span class="nav-link-inner--text showMobile">"""),_display_(/*78.66*/Messages("Giới thiệu về Innoway")),format.raw/*78.99*/("""</span>
                </a>
                <div class="dropdown-menu" style="z-index: 999;">
                  <a href="https://blog.innoway.vn/giao-duc" target="_blank" class="dropdown-item">"""),_display_(/*81.101*/Messages("Giáo dục ")),format.raw/*81.122*/("""</a>
                  <a href="https://blog.innoway.vn" target="_blank" class="dropdown-item">"""),_display_(/*82.92*/Messages("Blog")),format.raw/*82.108*/("""</a>
                  <a href="https://blog.innoway.vn/tuyen-dung" target="_blank" class="dropdown-item">"""),_display_(/*83.103*/Messages("Tuyển dụng ")),format.raw/*83.126*/("""</a>
                  <a href="https://blog.innoway.vn/tin-tuc" target="_blank" class="dropdown-item">"""),_display_(/*84.100*/Messages("Tin tức ")),format.raw/*84.120*/("""</a>
                  <a href="https://blog.innoway.vn/forums" target="_blank" class="dropdown-item">"""),_display_(/*85.99*/Messages("Hỏi đáp ")),format.raw/*85.119*/("""</a>
                </div>
              </li>


            </ul>

            <ul class="navbar-nav navbar-nav-hover align-items-lg-center navbar-login" style="">
            """),_display_(/*93.14*/if(currentUser != null)/*93.37*/{_display_(Seq[Any](format.raw/*93.38*/("""
              """),format.raw/*94.15*/("""<li class="nav-item dropdown">
                <a href="#" class="nav-link" data-toggle="dropdown" role="button">
                  """),format.raw/*96.122*/("""
                  """),format.raw/*97.19*/("""<span class="nav-link-inner--text">"""),_display_(/*97.55*/Messages("")),_display_(/*97.68*/currentUser/*97.79*/.getUsername),format.raw/*97.91*/("""</span> <i class="fa fa-angle-down text-black-50"></i>
                </a>
                <div class="dropdown-menu" style="z-index: 999;">
                  """),_display_(/*100.20*/if(currentUser.getSystemRole == User.SystemRole.SYSTEM_ADMIN.getCode())/*100.91*/{_display_(Seq[Any](format.raw/*100.92*/("""
                    """),format.raw/*101.21*/("""<a href=""""),_display_(/*101.31*/routes/*101.37*/.AdminOverviewController.adminOverview()),format.raw/*101.77*/("""" class="dropdown-item">"""),_display_(/*101.102*/Messages("Quản trị hệ thống ")),format.raw/*101.132*/("""</a>
                  """)))}/*102.21*/else/*102.26*/{_display_(Seq[Any](format.raw/*102.27*/("""
                    """),format.raw/*103.21*/("""<a href=""""),_display_(/*103.31*/routes/*103.37*/.ProjectController.project()),format.raw/*103.65*/("""" class="dropdown-item">"""),_display_(/*103.90*/Messages("Quản trị dự án ")),format.raw/*103.117*/("""</a>
                    <a href=""""),_display_(/*104.31*/routes/*104.37*/.ProductListController.productList(currentUser.getId)),format.raw/*104.90*/("""" class="dropdown-item">"""),_display_(/*104.115*/Messages("Quản lý sản phẩm ")),format.raw/*104.144*/("""</a>
                  """)))}),format.raw/*105.20*/("""
                  """),format.raw/*106.19*/("""<a href=""""),_display_(/*106.29*/routes/*106.35*/.Application.logout()),format.raw/*106.56*/("""" class="dropdown-item">"""),_display_(/*106.81*/Messages("Đăng xuất ")),format.raw/*106.103*/("""</a>
                </div>
              </li>
            """)))}/*109.15*/else/*109.20*/{_display_(Seq[Any](format.raw/*109.21*/("""
              """),format.raw/*110.15*/("""<li class="nav-item dropdown">
                <a href=""""),_display_(/*111.27*/routes/*111.33*/.Application.login()),format.raw/*111.53*/("""" class="nav-link" role="button">
                  <i class="ni ni-collection d-lg-none"></i>
                  <span class="nav-link-inner--text">"""),_display_(/*113.55*/Messages("landing.dangnhap")),format.raw/*113.83*/("""</span>
                  """),format.raw/*114.106*/("""
                """),format.raw/*115.17*/("""</a>
              </li>

              <li class="nav-item dropdown button-register">
                <a href=""""),_display_(/*119.27*/routes/*119.33*/.Application.register()),format.raw/*119.56*/("""" class="nav-link" role="button">
                  <i class="ni ni-collection d-lg-none"></i>
                  <span class="nav-link-inner--text">"""),_display_(/*121.55*/Messages("landing.dangki")),format.raw/*121.81*/("""</span>
                  """),format.raw/*122.104*/("""
                """),format.raw/*123.17*/("""</a>
              </li>
            """)))}),format.raw/*125.14*/("""
            """),format.raw/*126.13*/("""</ul>

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
                  DATE: Mon Sep 22 16:32:47 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPage/page/RegisterDeveloper_navbar.scala.html
                  HASH: 7c2368fb956b17b6d99aa9904df1c3d80ea254c2
                  MATRIX: 668->1|1022->35|1135->53|1162->54|2009->874|2056->900|2103->919|2754->1543|2769->1549|2819->1578|2878->1610|2893->1616|2956->1658|3121->1796|3136->1802|3186->1831|3301->1919|3343->1940|3443->2013|3488->2037|3781->2303|3823->2324|3923->2397|3968->2421|4116->2542|4131->2548|4188->2584|4303->2672|4348->2696|4448->2769|4498->2798|4768->3041|4812->3064|4959->3184|5010->3214|5160->3337|5175->3343|5238->3385|5307->3426|5365->3462|5501->3570|5552->3599|5603->3623|5635->3646|5674->3647|5723->3668|5760->3678|5775->3684|5824->3712|5876->3737|5925->3764|5968->3789|5981->3794|6020->3795|6069->3816|6157->3877|6206->3904|6261->3928|6308->3947|6345->3957|6360->3963|6420->4002|6489->4043|6536->4068|6596->4101|6611->4107|6664->4139|6733->4180|6774->4199|6834->4232|6849->4238|6904->4272|6973->4313|7019->4337|7288->4579|7329->4599|7476->4719|7530->4752|7753->4947|7796->4968|7919->5064|7957->5080|8092->5187|8137->5210|8269->5314|8311->5334|8441->5437|8483->5457|8689->5636|8721->5659|8760->5660|8803->5675|8964->5910|9011->5929|9074->5965|9107->5978|9127->5989|9160->6001|9349->6162|9430->6233|9470->6234|9520->6255|9558->6265|9574->6271|9636->6311|9690->6336|9743->6366|9787->6391|9801->6396|9841->6397|9891->6418|9929->6428|9945->6434|9995->6462|10048->6487|10098->6514|10161->6549|10177->6555|10252->6608|10306->6633|10358->6662|10414->6686|10462->6705|10500->6715|10516->6721|10559->6742|10612->6767|10657->6789|10738->6851|10752->6856|10792->6857|10836->6872|10921->6929|10937->6935|10979->6955|11156->7104|11206->7132|11262->7245|11308->7262|11449->7375|11465->7381|11510->7404|11687->7553|11735->7579|11791->7690|11837->7707|11907->7745|11949->7758
                  LINES: 24->1|29->2|34->2|35->3|49->17|49->17|50->18|62->30|62->30|62->30|63->31|63->31|63->31|68->36|68->36|68->36|69->37|69->37|70->38|70->38|76->44|76->44|77->45|77->45|82->50|82->50|82->50|83->51|83->51|84->52|84->52|90->58|90->58|91->59|91->59|94->62|94->62|94->62|94->62|94->62|95->63|95->63|96->64|96->64|96->64|97->65|97->65|97->65|97->65|97->65|97->65|98->66|98->66|98->66|99->67|99->67|99->67|100->68|101->69|101->69|101->69|101->69|101->69|101->69|102->70|102->70|102->70|102->70|102->70|103->71|103->71|103->71|103->71|103->71|109->77|109->77|110->78|110->78|113->81|113->81|114->82|114->82|115->83|115->83|116->84|116->84|117->85|117->85|125->93|125->93|125->93|126->94|128->96|129->97|129->97|129->97|129->97|129->97|132->100|132->100|132->100|133->101|133->101|133->101|133->101|133->101|133->101|134->102|134->102|134->102|135->103|135->103|135->103|135->103|135->103|135->103|136->104|136->104|136->104|136->104|136->104|137->105|138->106|138->106|138->106|138->106|138->106|138->106|141->109|141->109|141->109|142->110|143->111|143->111|143->111|145->113|145->113|146->114|147->115|151->119|151->119|151->119|153->121|153->121|154->122|155->123|157->125|158->126
                  -- GENERATED --
              */
          