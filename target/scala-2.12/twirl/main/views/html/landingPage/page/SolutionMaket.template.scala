
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

object SolutionMaket extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <link rel="icon" type="image/png" href=""""),_display_(/*7.46*/routes/*7.52*/.Assets.versioned("images/logo.jpg")),format.raw/*7.88*/("""">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Solution Maket</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <link href=""""),_display_(/*13.18*/routes/*13.24*/.Assets.versioned("awesome/css/bootstrap.css")),format.raw/*13.70*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*14.18*/routes/*14.24*/.Assets.versioned("awesome/css/landing-page.css")),format.raw/*14.73*/("""" rel="stylesheet"/>

      <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400,300' rel='stylesheet' type='text/css'>
    <link href=""""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("awesome/css/pe-icon-7-stroke.css")),format.raw/*19.77*/("""" rel="stylesheet" />

    <style>
      .alignItemCenter """),format.raw/*22.24*/("""{"""),format.raw/*22.25*/("""
        """),format.raw/*23.9*/("""position: relative;
      """),format.raw/*24.7*/("""}"""),format.raw/*24.8*/("""
      """),format.raw/*25.7*/(""".contentSolution """),format.raw/*25.24*/("""{"""),format.raw/*25.25*/("""
        """),format.raw/*26.9*/("""overflow: hidden;
        display: -webkit-box;
        -webkit-line-clamp: 3;
        -webkit-box-orient: vertical;
      """),format.raw/*30.7*/("""}"""),format.raw/*30.8*/("""
      """),format.raw/*31.7*/(""".contentSolution:hover """),format.raw/*31.30*/("""{"""),format.raw/*31.31*/("""
        """),format.raw/*32.9*/("""display: inherit;
      """),format.raw/*33.7*/("""}"""),format.raw/*33.8*/("""
    """),format.raw/*34.5*/("""</style>

  </head>
  <body class="landing-page landing-page1">
    <nav class="navbar navbar-transparent navbar-top" role="navigation">
      <div class="container">
          <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button id="menu-toggle" type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar bar1"></span>
            <span class="icon-bar bar2"></span>
            <span class="icon-bar bar3"></span>
          </button>
        </div>
          <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="example" >
          <ul class="nav navbar-nav navbar-right">
            <li>
              <a href=""""),_display_(/*53.25*/routes/*53.31*/.LandingPageController.home()),format.raw/*53.60*/("""">
                <i class="fa fa-home"></i> """),_display_(/*54.45*/Messages("Trang chủ ")),format.raw/*54.67*/("""
              """),format.raw/*55.15*/("""</a>
            </li>
            <li>
              <a href=""""),_display_(/*58.25*/routes/*58.31*/.AppDebugController.solutionMaketPage()),format.raw/*58.70*/("""" class="btn btn-neutral">
                <i class="fa fa-cloud"></i> """),_display_(/*59.46*/Messages("Giải pháp mẫu")),format.raw/*59.71*/("""
              """),format.raw/*60.15*/("""</a>
            </li>
            <li>
              <a href=""""),_display_(/*63.25*/routes/*63.31*/.AppDebugController.appSdkPage()),format.raw/*63.63*/("""">
                <i class="fa fa-tablet"></i> """),_display_(/*64.47*/Messages("App SDK")),format.raw/*64.66*/("""
              """),format.raw/*65.15*/("""</a>
            </li>
            <li>
              <a href=""""),_display_(/*68.25*/routes/*68.31*/.AppDebugController.appDebugPage()),format.raw/*68.65*/("""">
                <i class="fa fa-tablet"></i> """),_display_(/*69.47*/Messages("App Debug")),format.raw/*69.68*/("""
              """),format.raw/*70.15*/("""</a>
            </li>
            """),_display_(/*72.14*/if(currentUser != null)/*72.37*/{_display_(Seq[Any](format.raw/*72.38*/("""
              """),format.raw/*73.15*/("""<li>
                <a href=""""),_display_(/*74.27*/routes/*74.33*/.ProjectController.project()),format.raw/*74.61*/("""">
                  <i class="fa fa-user"></i> """),_display_(/*75.47*/currentUser/*75.58*/.getUsername),format.raw/*75.70*/("""
                """),format.raw/*76.17*/("""</a>
              </li>
            """)))}/*78.15*/else/*78.20*/{_display_(Seq[Any](format.raw/*78.21*/("""
              """),format.raw/*79.15*/("""<li>
                <a href=""""),_display_(/*80.27*/routes/*80.33*/.Application.login()),format.raw/*80.53*/("""">
                  <i class="fa fa-lock"></i> """),_display_(/*81.47*/Messages("landing.dangnhap")),format.raw/*81.75*/("""
                """),format.raw/*82.17*/("""</a>
              </li>
              <li>
                <a href=""""),_display_(/*85.27*/routes/*85.33*/.Application.register()),format.raw/*85.56*/("""">
                  <i class="fa fa-lock"></i> """),_display_(/*86.47*/Messages("landing.dangki")),format.raw/*86.73*/("""
                """),format.raw/*87.17*/("""</a>
              </li>
            """)))}),format.raw/*89.14*/("""
          """),format.raw/*90.11*/("""</ul>
        </div>
          <!-- /.navbar-collapse -->
      </div>
    </nav>
    <div class="wrapper">
      <div class="parallax filter-gradient red" data-color="red">
        <div class="parallax-background">
          <img class="parallax-background-image" src=""""),_display_(/*98.56*/routes/*98.62*/.Assets.versioned("awesome/img/bg3.jpg")),format.raw/*98.102*/("""">
        </div>
        <div class= "container">
          <div class="row">
            <div class="col-md-5 hidden-xs">
              <div class="parallax-image">
                <img class="phone" src=""""),_display_(/*104.42*/routes/*104.48*/.Assets.versioned("awesome/img/iphone3.png")),format.raw/*104.92*/("""" style="margin-top: 20px"/>
              </div>
            </div>
            <div class="col-md-6 col-md-offset-1">
              <div class="description">
                <h2>"""),_display_(/*109.22*/Messages("Nền tảng IoT InnoWay")),format.raw/*109.54*/("""</h2>
                <br>
                <h5>"""),_display_(/*111.22*/Messages("Cùng trải nghiệm những ứng dụng điện thoại đã tích hợp với nền tảng IoT Innoway cho các bộ giải pháp như: Nhà thông minh, Trang trại thông minh.")),format.raw/*111.178*/("""</h5>
              </div>
              <div class="buttons">
                <button class="btn btn-simple btn-neutral">
                  <i class="fa fa-apple"></i>
                </button>
                <button class="btn btn-simple btn-neutral">
                  <i class="fa fa-android"></i>
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="section section-features">
        <div class="container">
          <h4 class="header-text text-center">"""),_display_(/*128.48*/Messages("Danh sách Giải pháp mẫu")),format.raw/*128.83*/("""</h4>
          <div class="row">

            <div class="col-md-6">
              <div class="card" style="padding: 5px;">
                <div class="alignItemCenter">
                  <img src=""""),_display_(/*134.30*/routes/*134.36*/.Assets.versioned("images/solution/SmartTracking.png")),format.raw/*134.90*/("""" width="100%" height="300">
                </div>
                <div class="text mt-3 p-3 mb-3">
                  <div class="row">
                    <div class="col-md-6"><i class="fa fa-user"></i> """),_display_(/*138.71*/Messages("InnoWay")),format.raw/*138.90*/("""</div>
                    <div class="col-md-6"><i class="fa fa-calendar"></i> """),_display_(/*139.75*/Messages("01/06/2022")),format.raw/*139.97*/("""</div>
                  </div>
                  <h4 class="mt-3" style="font-weight: 500;">"""),_display_(/*141.63*/Messages("Giải pháp Fleet Management")),format.raw/*141.101*/("""</h4>
                  <p class="mt-3 contentSolution">
                  """),_display_(/*143.20*/Messages("Giúp bạn quản lý hoạt động của đội xe, dẫn đến giảm chi phí, cải thiện hiệu quả và nâng cao tính tuân thủ. Giải pháp quản lý đội xe phù hợp có thể là công cụ trong việc điều phối các hoạt động quản lý đội xe của bạn.")),format.raw/*143.248*/("""
                  """),format.raw/*144.19*/("""</p>
                  <a class="btn btn-danger" href=""""),_display_(/*145.52*/routes/*145.58*/.ProjectController.project()),format.raw/*145.86*/("""" type="button">"""),_display_(/*145.103*/Messages("Cài đặt")),format.raw/*145.122*/("""</a>
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div class="card" style="padding: 5px;">
                <div class="alignItemCenter">
                  <img src=""""),_display_(/*152.30*/routes/*152.36*/.Assets.versioned("images/solution/AssetManagement.png")),format.raw/*152.92*/("""" width="100%" height="300">
                </div>
                <div class="text mt-3 p-3">
                  <div class="row">
                    <div class="col-md-6"><i class="fa fa-user"></i> """),_display_(/*156.71*/Messages("InnoWay")),format.raw/*156.90*/("""</div>
                    <div class="col-md-6"><i class="fa fa-calendar"></i> """),_display_(/*157.75*/Messages("01/06/2022")),format.raw/*157.97*/("""</div>
                  </div>
                  <h4 class="mt-3" style="font-weight: 500;">"""),_display_(/*159.63*/Messages("Giải pháp Asset Management")),format.raw/*159.101*/("""</h4>
                  <p class="mt-3 contentSolution">
                  """),_display_(/*161.20*/Messages("Giúp bạn theo dõi tài sản thông qua việc sử dụng các thẻ RFID được gắn vào chúng, được đọc bằng máy quét cố định được gắn ở vị trí cố đinh. Mỗi khi một thẻ được đọc, nó sẽ được lưu tổng hợp thành một chuỗi và bán tổng tất cả các RFID đã quét được lên hệ thống.")),format.raw/*161.292*/("""
                  """),format.raw/*162.19*/("""</p>
                  <a class="btn btn-danger" href=""""),_display_(/*163.52*/routes/*163.58*/.ProjectController.project()),format.raw/*163.86*/("""" type="button">"""),_display_(/*163.103*/Messages("Cài đặt")),format.raw/*163.122*/("""</a>
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div class="card" style="padding: 5px;">
                <div class="alignItemCenter">
                  <img src=""""),_display_(/*170.30*/routes/*170.36*/.Assets.versioned("images/solution/SmartMetering.png")),format.raw/*170.90*/("""" width="100%" height="300">
                </div>
                <div class="text mt-3 p-3">
                  <div class="row">
                    <div class="col-md-6"><i class="fa fa-user"></i> """),_display_(/*174.71*/Messages("InnoWay")),format.raw/*174.90*/("""</div>
                    <div class="col-md-6"><i class="fa fa-calendar"></i> """),_display_(/*175.75*/Messages("01/06/2022")),format.raw/*175.97*/("""</div>
                  </div>
                  <h4 class="mt-3" style="font-weight: 500;">"""),_display_(/*177.63*/Messages("Giải pháp Smart Water Meter")),format.raw/*177.102*/("""</h4>
                  <p class="mt-3 contentSolution">
                  """),_display_(/*179.20*/Messages("Giúp bạn theo dõi lưu lượng sử dụng, cảnh bảo về các vấn đề liên quan đến đường dẫn nước trong nhà bạn, dẫn đến giảm chi phí, giải thiếu các rủi ro, cung cấp hệ thống đo lường từ xa và tổng hợp lại số lượng đã sử dụng mà không cần đội ngũ đến kiểm tra.")),format.raw/*179.284*/("""
                  """),format.raw/*180.19*/("""</p>
                  <a class="btn btn-danger" href=""""),_display_(/*181.52*/routes/*181.58*/.ProjectController.project()),format.raw/*181.86*/("""" type="button">"""),_display_(/*181.103*/Messages("Cài đặt")),format.raw/*181.122*/("""</a>
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div class="card" style="padding: 5px;">
                <div class="alignItemCenter">
                  <img src=""""),_display_(/*188.30*/routes/*188.36*/.Assets.versioned("images/solution/SmartFarming.png")),format.raw/*188.89*/("""" width="100%" height="300">
                </div>
                <div class="text mt-3 p-3">
                  <div class="row">
                    <div class="col-md-6"><i class="fa fa-user"></i> """),_display_(/*192.71*/Messages("InnoWay")),format.raw/*192.90*/("""</div>
                    <div class="col-md-6"><i class="fa fa-calendar"></i> """),_display_(/*193.75*/Messages("01/06/2022")),format.raw/*193.97*/("""</div>
                  </div>
                  <h4 class="mt-3" style="font-weight: 500;">"""),_display_(/*195.63*/Messages("Giải pháp Smart Farm")),format.raw/*195.95*/("""</h4>
                  <p class="mt-3 contentSolution">
                  """),_display_(/*197.20*/Messages("Giúp bạn theo dõi lưu lượng sử dụng, cảnh bảo về các vấn đề liên quan đến đường dẫn nước trong nhà bạn, dẫn đến giảm chi phí, giải thiếu các rủi ro, cung cấp hệ thống đo lường từ xa và tổng hợp lại số lượng đã sử dụng mà không cần đội ngũ đến kiểm tra.")),format.raw/*197.284*/("""
                  """),format.raw/*198.19*/("""</p>
                  <a class="btn btn-danger" href=""""),_display_(/*199.52*/routes/*199.58*/.ProjectController.project()),format.raw/*199.86*/("""" type="button">"""),_display_(/*199.103*/Messages("Cài đặt")),format.raw/*199.122*/("""</a>
                </div>
              </div>
            </div>

            <div class="col-md-6">
              <div class="card" style="padding: 5px;">
                <div class="alignItemCenter">
                  <img src=""""),_display_(/*207.30*/routes/*207.36*/.Assets.versioned("images/solution/SmartHome.png")),format.raw/*207.86*/("""" width="100%" height="300">
                </div>
                <div class="text mt-3 p-3">
                  <div class="row">
                    <div class="col-md-6"><i class="fa fa-user"></i> """),_display_(/*211.71*/Messages("InnoWay")),format.raw/*211.90*/("""</div>
                    <div class="col-md-6"><i class="fa fa-calendar"></i> """),_display_(/*212.75*/Messages("01/06/2022")),format.raw/*212.97*/("""</div>
                  </div>
                  <h4 class="mt-3" style="font-weight: 500;">"""),_display_(/*214.63*/Messages("Giải pháp Smarthome")),format.raw/*214.94*/("""</h4>
                  <p class="mt-3 contentSolution">
                  """),_display_(/*216.20*/Messages("Giải pháp hỗ trợ các ngữ cảnh thông minh được đặt theo giờ hoặc theo ngoại cảnh để người sử dụng có trải nghiệm và sức khỏe tinh thần tốt nhất trong căn nhà ")),format.raw/*216.189*/("""
                  """),format.raw/*217.19*/("""</p>
                  <a class="btn btn-danger" href=""""),_display_(/*218.52*/routes/*218.58*/.ProjectController.project()),format.raw/*218.86*/("""" type="button">"""),_display_(/*218.103*/Messages("Cài đặt")),format.raw/*218.122*/("""</a>
                </div>
              </div>
            </div>

            <div class="col-md-6">
              <div class="card" style="padding: 5px;">
                <div class="alignItemCenter">
                  <img src=""""),_display_(/*226.30*/routes/*226.36*/.Assets.versioned("images/project/vtag.png")),format.raw/*226.80*/("""" width="100%" height="300">
                </div>
                <div class="text mt-3 p-3">
                  <div class="row">
                    <div class="col-md-6"><i class="fa fa-user"></i> """),_display_(/*230.71*/Messages("InnoWay")),format.raw/*230.90*/("""</div>
                    <div class="col-md-6"><i class="fa fa-calendar"></i> """),_display_(/*231.75*/Messages("01/06/2022")),format.raw/*231.97*/("""</div>
                  </div>
                  <h4 class="mt-3" style="font-weight: 500;">"""),_display_(/*233.63*/Messages("Giải pháp Định vị thông minh")),format.raw/*233.103*/("""</h4>
                  <p class="mt-3 contentSolution">
                  """),_display_(/*235.20*/Messages("Giải pháp hỗ trợ các ngữ cảnh thông minh được đặt theo giờ hoặc theo ngoại cảnh để người sử dụng có trải nghiệm và sức khỏe tinh thần tốt nhất trong căn nhà ")),format.raw/*235.189*/("""
                  """),format.raw/*236.19*/("""</p>
                  <a class="btn btn-info" href=""""),_display_(/*237.50*/routes/*237.56*/.ProjectController.project()),format.raw/*237.84*/("""" type="button">"""),_display_(/*237.101*/Messages("Đang phát triển")),format.raw/*237.128*/("""</a>
                </div>
              </div>
            </div>

          </div>
        </div>
      </div>

      <div class="section section-features">
        <div class="container">
          <h4 class="header-text text-center">"""),_display_(/*248.48*/Messages("Hướng dẫn tích hợp giải pháp SmartFarm")),format.raw/*248.98*/("""</h4>
          <div class="row">

            <div class="col-md-12">
              <iframe id="myVideo" width="100%" height="456" src="https://www.youtube.com/embed/Cw0A-sDof3M?rel=1&amp;controls=1&amp;showinfo=0&amp;start=1&autoplay=0&enablejsapi=1"
              frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
            </div>

          </div>
        </div>
      </div>

      <footer class="footer">
        <div class="container">
          <nav class="pull-left">

          </nav>
          <div class="social-area pull-right">
            <a class="btn btn-social btn-facebook btn-simple">
              <i class="fa fa-facebook-square"></i>
            </a>
            <a class="btn btn-social btn-twitter btn-simple">
              <i class="fa fa-twitter"></i>
            </a>
            <a class="btn btn-social btn-pinterest btn-simple">
              <i class="fa fa-pinterest"></i>
            </a>
          </div>
          <div class="copyright">
                &copy; 2022 <a href="#">Innoway Platform team</a>, made with love
          </div>
        </div>
      </footer>
    </div>

  </body>
  <script src=""""),_display_(/*284.17*/routes/*284.23*/.Assets.versioned("awesome/js/jquery-1.10.2.js")),format.raw/*284.71*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*285.17*/routes/*285.23*/.Assets.versioned("awesome/js/jquery-ui-1.10.4.custom.min.js")),format.raw/*285.85*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*286.17*/routes/*286.23*/.Assets.versioned("awesome/js/bootstrap.js")),format.raw/*286.67*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*287.17*/routes/*287.23*/.Assets.versioned("awesome/js/awesome-landing-page.js")),format.raw/*287.78*/("""" type="text/javascript"></script>

</html>
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
                  DATE: Mon Sep 22 16:32:47 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPage/page/SolutionMaket.scala.html
                  HASH: 51b0a71bfb323eee34525daaf1eef3a2e2e46fff
                  MATRIX: 668->1|1011->35|1124->53|1151->54|1293->170|1307->176|1363->212|1685->507|1700->513|1767->559|1833->598|1848->604|1918->653|2251->959|2266->965|2340->1018|2426->1076|2455->1077|2491->1086|2544->1112|2572->1113|2606->1120|2651->1137|2680->1138|2716->1147|2866->1270|2894->1271|2928->1278|2979->1301|3008->1302|3044->1311|3095->1335|3123->1336|3155->1341|4048->2207|4063->2213|4113->2242|4187->2289|4230->2311|4273->2326|4364->2390|4379->2396|4439->2435|4538->2507|4584->2532|4627->2547|4718->2611|4733->2617|4786->2649|4862->2698|4902->2717|4945->2732|5036->2796|5051->2802|5106->2836|5182->2885|5224->2906|5267->2921|5330->2957|5362->2980|5401->2981|5444->2996|5502->3027|5517->3033|5566->3061|5642->3110|5662->3121|5695->3133|5740->3150|5797->3189|5810->3194|5849->3195|5892->3210|5950->3241|5965->3247|6006->3267|6082->3316|6131->3344|6176->3361|6273->3431|6288->3437|6332->3460|6408->3509|6455->3535|6500->3552|6569->3590|6608->3601|6906->3872|6921->3878|6983->3918|7219->4126|7235->4132|7301->4176|7510->4357|7564->4389|7640->4437|7819->4593|8386->5132|8443->5167|8671->5367|8687->5373|8763->5427|8998->5634|9039->5653|9148->5734|9192->5756|9314->5850|9375->5888|9479->5964|9730->6192|9778->6211|9862->6267|9878->6273|9928->6301|9974->6318|10016->6337|10277->6570|10293->6576|10371->6632|10601->6834|10642->6853|10751->6934|10795->6956|10917->7050|10978->7088|11082->7164|11377->7436|11425->7455|11509->7511|11525->7517|11575->7545|11621->7562|11663->7581|11924->7814|11940->7820|12016->7874|12246->8076|12287->8095|12396->8176|12440->8198|12562->8292|12624->8331|12728->8407|13015->8671|13063->8690|13147->8746|13163->8752|13213->8780|13259->8797|13301->8816|13562->9049|13578->9055|13653->9108|13883->9310|13924->9329|14033->9410|14077->9432|14199->9526|14253->9558|14357->9634|14644->9898|14692->9917|14776->9973|14792->9979|14842->10007|14888->10024|14930->10043|15192->10277|15208->10283|15280->10333|15510->10535|15551->10554|15660->10635|15704->10657|15826->10751|15879->10782|15983->10858|16175->11027|16223->11046|16307->11102|16323->11108|16373->11136|16419->11153|16461->11172|16723->11406|16739->11412|16805->11456|17035->11658|17076->11677|17185->11758|17229->11780|17351->11874|17414->11914|17518->11990|17710->12159|17758->12178|17840->12232|17856->12238|17906->12266|17952->12283|18002->12310|18269->12549|18341->12599|19540->13770|19556->13776|19626->13824|19705->13875|19721->13881|19805->13943|19884->13994|19900->14000|19966->14044|20045->14095|20061->14101|20138->14156
                  LINES: 24->1|29->2|34->2|35->3|39->7|39->7|39->7|45->13|45->13|45->13|46->14|46->14|46->14|51->19|51->19|51->19|54->22|54->22|55->23|56->24|56->24|57->25|57->25|57->25|58->26|62->30|62->30|63->31|63->31|63->31|64->32|65->33|65->33|66->34|85->53|85->53|85->53|86->54|86->54|87->55|90->58|90->58|90->58|91->59|91->59|92->60|95->63|95->63|95->63|96->64|96->64|97->65|100->68|100->68|100->68|101->69|101->69|102->70|104->72|104->72|104->72|105->73|106->74|106->74|106->74|107->75|107->75|107->75|108->76|110->78|110->78|110->78|111->79|112->80|112->80|112->80|113->81|113->81|114->82|117->85|117->85|117->85|118->86|118->86|119->87|121->89|122->90|130->98|130->98|130->98|136->104|136->104|136->104|141->109|141->109|143->111|143->111|160->128|160->128|166->134|166->134|166->134|170->138|170->138|171->139|171->139|173->141|173->141|175->143|175->143|176->144|177->145|177->145|177->145|177->145|177->145|184->152|184->152|184->152|188->156|188->156|189->157|189->157|191->159|191->159|193->161|193->161|194->162|195->163|195->163|195->163|195->163|195->163|202->170|202->170|202->170|206->174|206->174|207->175|207->175|209->177|209->177|211->179|211->179|212->180|213->181|213->181|213->181|213->181|213->181|220->188|220->188|220->188|224->192|224->192|225->193|225->193|227->195|227->195|229->197|229->197|230->198|231->199|231->199|231->199|231->199|231->199|239->207|239->207|239->207|243->211|243->211|244->212|244->212|246->214|246->214|248->216|248->216|249->217|250->218|250->218|250->218|250->218|250->218|258->226|258->226|258->226|262->230|262->230|263->231|263->231|265->233|265->233|267->235|267->235|268->236|269->237|269->237|269->237|269->237|269->237|280->248|280->248|316->284|316->284|316->284|317->285|317->285|317->285|318->286|318->286|318->286|319->287|319->287|319->287
                  -- GENERATED --
              */
          