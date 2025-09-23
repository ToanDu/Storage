
package views.html.landingPage

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
                <a onclick="goToByScroll('divTongQuan')" class="nav-link" role="button">
                  """),format.raw/*36.60*/("""
                  """),format.raw/*37.19*/("""<span class="nav-link-inner--text">"""),_display_(/*37.55*/Messages("landing.gioithieu")),format.raw/*37.84*/("""</span>
                  <span class="nav-link-inner--text showMobile">"""),_display_(/*38.66*/Messages("landing.gioithieu1")),format.raw/*38.96*/("""</span>
                </a>
              </li>

              <li class="nav-item dropdown">
                <a onclick="goToByScroll('divGiaiPhap')" class="nav-link" role="button">
                  """),format.raw/*44.65*/("""
                  """),format.raw/*45.19*/("""<span class="nav-link-inner--text">"""),_display_(/*45.55*/Messages("Giải pháp ")),format.raw/*45.77*/("""</span>
                  <span class="nav-link-inner--text showMobile">"""),_display_(/*46.66*/Messages("Giải pháp cho các dự án ")),format.raw/*46.102*/("""</span>
                </a>
              </li>

              <li class="nav-item dropdown">
                <a onclick="goToByScroll('divUseCase')" class="nav-link" role="button">
                  """),format.raw/*52.65*/("""
                  """),format.raw/*53.19*/("""<span class="nav-link-inner--text">"""),_display_(/*53.55*/Messages("landing.usecase")),format.raw/*53.82*/("""</span>
                  <span class="nav-link-inner--text showMobile">"""),_display_(/*54.66*/Messages("landing.usecase1")),format.raw/*54.94*/("""</span>
                </a>
              </li>

              <li class="nav-item dropdown">
                <a onclick="goToByScroll('divKhachHang')" class="nav-link" role="button">
                  """),format.raw/*60.65*/("""
                  """),format.raw/*61.19*/("""<span class="nav-link-inner--text">"""),_display_(/*61.55*/Messages("Khách hàng")),format.raw/*61.77*/("""</span>
                  <span class="nav-link-inner--text showMobile">"""),_display_(/*62.66*/Messages("Khách hàng và sản phẩm ")),format.raw/*62.101*/("""</span>
                </a>
              </li>

              <li class="nav-item dropdown">
                <a onclick="goToByScroll('divDoiTac')" class="nav-link" role="button">
                  """),format.raw/*68.65*/("""
                  """),format.raw/*69.19*/("""<span class="nav-link-inner--text">"""),_display_(/*69.55*/Messages("Đối tác ")),format.raw/*69.75*/("""</span>
                  <span class="nav-link-inner--text showMobile">"""),_display_(/*70.66*/Messages("Đối tác của chúng tôi ")),format.raw/*70.100*/("""</span>
                </a>
              </li>

              <li class="nav-item dropdown">
                <a onclick="goToByScroll('divHoiDap')" class="nav-link" role="button">
                  """),format.raw/*76.65*/("""
                  """),format.raw/*77.19*/("""<span class="nav-link-inner--text">"""),_display_(/*77.55*/Messages("Hỏi - Đáp ")),format.raw/*77.77*/("""</span>
                  <span class="nav-link-inner--text showMobile">"""),_display_(/*78.66*/Messages("Các câu hỏi thường gặp ")),format.raw/*78.101*/("""</span>
                </a>
              </li>

              <li class="nav-item dropdown">
                <a onclick="" href="#" class="nav-link" data-toggle="dropdown" role="button">

                  <span class="nav-link-inner--text">"""),_display_(/*85.55*/Messages("Developers ")),format.raw/*85.78*/("""</span> <i class="fa fa-angle-down text-black-50"></i>
                  <span class="nav-link-inner--text showMobile">"""),_display_(/*86.66*/Messages("Công cụ lập trình ")),format.raw/*86.96*/("""</span>
                </a>
                <div class="dropdown-menu" style="z-index: 999;">
                  <a href=""""),_display_(/*89.29*/routes/*89.35*/.LandingPageController.registerDeveloper()),format.raw/*89.77*/("""" target="_blank" class="dropdown-item">"""),_display_(/*89.118*/Messages("Đăng ký trở thành Dev/SI")),format.raw/*89.154*/("""</a>
                  <a href="https://vht-iot.gitbook.io/innoway/" target="_blank" class="dropdown-item">"""),_display_(/*90.104*/Messages("Hướng dẫn sử dụng")),format.raw/*90.133*/("""</a>
                  """),_display_(/*91.20*/if(currentUser != null)/*91.43*/{_display_(Seq[Any](format.raw/*91.44*/("""
                    """),format.raw/*92.21*/("""<a href=""""),_display_(/*92.31*/routes/*92.37*/.ProjectController.project()),format.raw/*92.65*/("""" class="dropdown-item">"""),_display_(/*92.90*/Messages("Bắt đầu 1 dự án")),format.raw/*92.117*/("""</a>
                  """)))}/*93.21*/else/*93.26*/{_display_(Seq[Any](format.raw/*93.27*/("""
                    """),format.raw/*94.21*/("""<a href="#" onclick="notiMustLogin()" class="dropdown-item">"""),_display_(/*94.82*/Messages("Bắt đầu 1 dự án")),format.raw/*94.109*/("""</a>
                  """)))}),format.raw/*95.20*/("""
                  """),format.raw/*96.19*/("""<a href=""""),_display_(/*96.29*/routes/*96.35*/.AppDebugController.solutionMaketPage()),format.raw/*96.74*/("""" target="_blank" class="dropdown-item">"""),_display_(/*96.115*/Messages("Giải pháp mẫu")),format.raw/*96.140*/("""</a>
                  <a href=""""),_display_(/*97.29*/routes/*97.35*/.AppDebugController.appSdkPage()),format.raw/*97.67*/("""" target="_blank" class="dropdown-item">"""),_display_(/*97.108*/Messages("App SDK")),format.raw/*97.127*/("""</a>
                  <a href=""""),_display_(/*98.29*/routes/*98.35*/.AppDebugController.appDebugPage()),format.raw/*98.69*/("""" target="_blank" class="dropdown-item">"""),_display_(/*98.110*/Messages("Vsmart Debug")),format.raw/*98.134*/("""</a>
                </div>
              </li>

              <li class="nav-item dropdown">
                <a onclick="" href="#" class="nav-link" data-toggle="dropdown" role="button">
                  <span class="nav-link-inner--text">"""),_display_(/*104.55*/Messages("Cộng đồng")),format.raw/*104.76*/("""</span> <i class="fa fa-angle-down text-black-50"></i>
                  <span class="nav-link-inner--text showMobile">"""),_display_(/*105.66*/Messages("Cộng đồng phát triển IoT")),format.raw/*105.102*/("""</span>
                </a>
                <div class="dropdown-menu" style="z-index: 999;">
                  """),format.raw/*108.135*/("""
                  """),format.raw/*109.19*/("""<a href="https://blog.innoway.vn/forum/dien-dan-iot" target="_blank" class="dropdown-item">"""),_display_(/*109.111*/Messages("Diễn đàn IoT")),format.raw/*109.135*/("""</a>
                  <a href="https://blog.innoway.vn/tuyen-dung" target="_blank" class="dropdown-item">"""),_display_(/*110.103*/Messages("Tuyển dụng ")),format.raw/*110.126*/("""</a>
                  <a href="https://blog.innoway.vn/giao-duc" target="_blank" class="dropdown-item">"""),_display_(/*111.101*/Messages("Giáo dục ")),format.raw/*111.122*/("""</a>
                  <a href="https://blog.innoway.vn/tin-tuc" target="_blank" class="dropdown-item">"""),_display_(/*112.100*/Messages("Tin tức ")),format.raw/*112.120*/("""</a>
                  <a href="https://blog.innoway.vn/forums" target="_blank" class="dropdown-item">"""),_display_(/*113.99*/Messages("Hỏi đáp ")),format.raw/*113.119*/("""</a>
                </div>
              </li>

              <li class="nav-item dropdown">
                <a href=""""),_display_(/*118.27*/routes/*118.33*/.MarketPlaceController.marketPlace()),format.raw/*118.69*/("""" class="nav-link" role="button">
                <span class="nav-link-inner--text">"""),_display_(/*119.53*/Messages("Market Place")),format.raw/*119.77*/("""</span>
                <span class="nav-link-inner--text showMobile">"""),_display_(/*120.64*/Messages("Chợ công nghệ IoT")),format.raw/*120.93*/("""</span>
                </a>
              </li>
            </ul>

            <ul class="navbar-nav navbar-nav-hover align-items-lg-center navbar-login" style="">
            """),_display_(/*126.14*/if(currentUser != null)/*126.37*/{_display_(Seq[Any](format.raw/*126.38*/("""
              """),format.raw/*127.15*/("""<li class="nav-item dropdown">
                <a href="#" class="nav-link" data-toggle="dropdown" role="button">
                  """),format.raw/*129.122*/("""
                  """),format.raw/*130.19*/("""<span class="nav-link-inner--text">"""),_display_(/*130.55*/Messages("")),_display_(/*130.68*/currentUser/*130.79*/.getUsername),format.raw/*130.91*/("""</span> <i class="fa fa-angle-down text-black-50"></i>
                </a>
                <div class="dropdown-menu" style="z-index: 999;">
                """),_display_(/*133.18*/if(currentUser.getSystemRole == User.SystemRole.SYSTEM_ADMIN.getCode())/*133.89*/{_display_(Seq[Any](format.raw/*133.90*/("""
                  """),format.raw/*134.19*/("""<a href=""""),_display_(/*134.29*/routes/*134.35*/.AdminOverviewController.adminOverview()),format.raw/*134.75*/("""" class="dropdown-item">"""),_display_(/*134.100*/Messages("Quản trị hệ thống ")),format.raw/*134.130*/("""</a>
                """)))}/*135.19*/else/*135.24*/{_display_(Seq[Any](format.raw/*135.25*/("""
                  """),format.raw/*136.19*/("""<a href=""""),_display_(/*136.29*/routes/*136.35*/.ProjectController.project()),format.raw/*136.63*/("""" target="_blank" class="dropdown-item">"""),_display_(/*136.104*/Messages("Quản trị dự án ")),format.raw/*136.131*/("""</a>
                  <a href=""""),_display_(/*137.29*/routes/*137.35*/.TelcoSubscriberController.subscriberManage(currentUser.getId)),format.raw/*137.97*/("""" target="_blank" class="dropdown-item">"""),_display_(/*137.138*/Messages("Quản lý Telco")),format.raw/*137.163*/("""</a>
                  <a href=""""),_display_(/*138.29*/routes/*138.35*/.ProductListController.productList(currentUser.getId)),format.raw/*138.88*/("""" target="_blank" class="dropdown-item">"""),_display_(/*138.129*/Messages("Quản lý sản phẩm ")),format.raw/*138.158*/("""</a>
                """)))}),format.raw/*139.18*/("""
                  """),format.raw/*140.19*/("""<a href=""""),_display_(/*140.29*/routes/*140.35*/.Application.logout()),format.raw/*140.56*/("""" class="dropdown-item">"""),_display_(/*140.81*/Messages("Đăng xuất ")),format.raw/*140.103*/("""</a>
                </div>
              </li>
            """)))}/*143.15*/else/*143.20*/{_display_(Seq[Any](format.raw/*143.21*/("""
              """),format.raw/*144.15*/("""<li class="nav-item dropdown">
                <a href=""""),_display_(/*145.27*/routes/*145.33*/.Application.login()),format.raw/*145.53*/("""" class="nav-link" role="button">
                  <i class="ni ni-collection d-lg-none"></i>
                  <span class="nav-link-inner--text">"""),_display_(/*147.55*/Messages("landing.dangnhap")),format.raw/*147.83*/("""</span>
                  """),format.raw/*148.106*/("""
                """),format.raw/*149.17*/("""</a>
              </li>

              <li class="nav-item dropdown button-register">
                <a href=""""),_display_(/*153.27*/routes/*153.33*/.Application.register()),format.raw/*153.56*/("""" class="nav-link" role="button">
                  <i class="ni ni-collection d-lg-none"></i>
                  <span class="nav-link-inner--text">"""),_display_(/*155.55*/Messages("landing.dangki")),format.raw/*155.81*/("""</span>
                  """),format.raw/*156.104*/("""
                """),format.raw/*157.17*/("""</a>
              </li>
            """)))}),format.raw/*159.14*/("""
            """),format.raw/*160.13*/("""</ul>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPage/LandingPage_navbar.scala.html
                  HASH: 6127bd8c101f7e44e5f13ae0deed3d611c05a199
                  MATRIX: 663->1|1011->35|1124->53|1151->54|1998->874|2045->900|2092->919|2743->1543|2758->1549|2808->1578|2867->1610|2882->1616|2945->1658|3191->1917|3238->1936|3301->1972|3351->2001|3451->2074|3502->2104|3732->2352|3779->2371|3842->2407|3885->2429|3985->2502|4043->2538|4272->2785|4319->2804|4382->2840|4430->2867|4530->2940|4579->2968|4810->3217|4857->3236|4920->3272|4963->3294|5063->3367|5120->3402|5348->3648|5395->3667|5458->3703|5499->3723|5599->3796|5655->3830|5883->4076|5930->4095|5993->4131|6036->4153|6136->4226|6193->4261|6464->4505|6508->4528|6655->4648|6706->4678|6856->4801|6871->4807|6934->4849|7003->4890|7061->4926|7197->5034|7248->5063|7299->5087|7331->5110|7370->5111|7419->5132|7456->5142|7471->5148|7520->5176|7572->5201|7621->5228|7664->5253|7677->5258|7716->5259|7765->5280|7853->5341|7902->5368|7957->5392|8004->5411|8041->5421|8056->5427|8116->5466|8185->5507|8232->5532|8292->5565|8307->5571|8360->5603|8429->5644|8470->5663|8530->5696|8545->5702|8600->5736|8669->5777|8715->5801|8985->6043|9028->6064|9176->6184|9235->6220|9378->6449|9426->6468|9547->6560|9594->6584|9730->6691|9776->6714|9910->6819|9954->6840|10087->6944|10130->6964|10261->7067|10304->7087|10452->7207|10468->7213|10526->7249|10640->7335|10686->7359|10785->7430|10836->7459|11042->7637|11075->7660|11115->7661|11159->7676|11321->7911|11369->7930|11433->7966|11467->7979|11488->7990|11522->8002|11709->8161|11790->8232|11830->8233|11878->8252|11916->8262|11932->8268|11994->8308|12048->8333|12101->8363|12143->8386|12157->8391|12197->8392|12245->8411|12283->8421|12299->8427|12349->8455|12419->8496|12469->8523|12530->8556|12546->8562|12630->8624|12700->8665|12748->8690|12809->8723|12825->8729|12900->8782|12970->8823|13022->8852|13076->8874|13124->8893|13162->8903|13178->8909|13221->8930|13274->8955|13319->8977|13400->9039|13414->9044|13454->9045|13498->9060|13583->9117|13599->9123|13641->9143|13818->9292|13868->9320|13924->9433|13970->9450|14111->9563|14127->9569|14172->9592|14349->9741|14397->9767|14453->9878|14499->9895|14569->9933|14611->9946
                  LINES: 24->1|29->2|34->2|35->3|49->17|49->17|50->18|62->30|62->30|62->30|63->31|63->31|63->31|68->36|69->37|69->37|69->37|70->38|70->38|76->44|77->45|77->45|77->45|78->46|78->46|84->52|85->53|85->53|85->53|86->54|86->54|92->60|93->61|93->61|93->61|94->62|94->62|100->68|101->69|101->69|101->69|102->70|102->70|108->76|109->77|109->77|109->77|110->78|110->78|117->85|117->85|118->86|118->86|121->89|121->89|121->89|121->89|121->89|122->90|122->90|123->91|123->91|123->91|124->92|124->92|124->92|124->92|124->92|124->92|125->93|125->93|125->93|126->94|126->94|126->94|127->95|128->96|128->96|128->96|128->96|128->96|128->96|129->97|129->97|129->97|129->97|129->97|130->98|130->98|130->98|130->98|130->98|136->104|136->104|137->105|137->105|140->108|141->109|141->109|141->109|142->110|142->110|143->111|143->111|144->112|144->112|145->113|145->113|150->118|150->118|150->118|151->119|151->119|152->120|152->120|158->126|158->126|158->126|159->127|161->129|162->130|162->130|162->130|162->130|162->130|165->133|165->133|165->133|166->134|166->134|166->134|166->134|166->134|166->134|167->135|167->135|167->135|168->136|168->136|168->136|168->136|168->136|168->136|169->137|169->137|169->137|169->137|169->137|170->138|170->138|170->138|170->138|170->138|171->139|172->140|172->140|172->140|172->140|172->140|172->140|175->143|175->143|175->143|176->144|177->145|177->145|177->145|179->147|179->147|180->148|181->149|185->153|185->153|185->153|187->155|187->155|188->156|189->157|191->159|192->160
                  -- GENERATED --
              */
          