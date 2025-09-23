
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

object AppSdk extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>AppSDK</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <link href=""""),_display_(/*13.18*/routes/*13.24*/.Assets.versioned("awesome/css/bootstrap.css")),format.raw/*13.70*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*14.18*/routes/*14.24*/.Assets.versioned("awesome/css/landing-page.css")),format.raw/*14.73*/("""" rel="stylesheet"/>

      <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400,300' rel='stylesheet' type='text/css'>
    <link href=""""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("awesome/css/pe-icon-7-stroke.css")),format.raw/*19.77*/("""" rel="stylesheet" />

    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("stylesheets/views/app/appSdk.css")),format.raw/*21.77*/("""" rel="stylesheet" />

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
              <a href=""""),_display_(/*40.25*/routes/*40.31*/.LandingPageController.home()),format.raw/*40.60*/("""">
                <i class="fa fa-home"></i> """),_display_(/*41.45*/Messages("Trang chủ ")),format.raw/*41.67*/("""
              """),format.raw/*42.15*/("""</a>
            </li>
            <li>
              <a href=""""),_display_(/*45.25*/routes/*45.31*/.AppDebugController.solutionMaketPage()),format.raw/*45.70*/("""">
                <i class="fa fa-cloud"></i> """),_display_(/*46.46*/Messages("Giải pháp mẫu")),format.raw/*46.71*/("""
              """),format.raw/*47.15*/("""</a>
            </li>
            <li>
              <a href=""""),_display_(/*50.25*/routes/*50.31*/.AppDebugController.appSdkPage()),format.raw/*50.63*/("""" class="btn btn-neutral">
                <i class="fa fa-tablet"></i> """),_display_(/*51.47*/Messages("App SDK")),format.raw/*51.66*/("""
              """),format.raw/*52.15*/("""</a>
            </li>
            <li>
              <a href=""""),_display_(/*55.25*/routes/*55.31*/.AppDebugController.appDebugPage()),format.raw/*55.65*/("""">
                <i class="fa fa-tablet"></i> """),_display_(/*56.47*/Messages("App Debug")),format.raw/*56.68*/("""
              """),format.raw/*57.15*/("""</a>
            </li>
            """),_display_(/*59.14*/if(currentUser != null)/*59.37*/{_display_(Seq[Any](format.raw/*59.38*/("""
              """),format.raw/*60.15*/("""<li>
                <a href=""""),_display_(/*61.27*/routes/*61.33*/.ProjectController.project()),format.raw/*61.61*/("""">
                  <i class="fa fa-user"></i> """),_display_(/*62.47*/currentUser/*62.58*/.getUsername),format.raw/*62.70*/("""
                """),format.raw/*63.17*/("""</a>
              </li>
            """)))}/*65.15*/else/*65.20*/{_display_(Seq[Any](format.raw/*65.21*/("""
              """),format.raw/*66.15*/("""<li>
                <a href=""""),_display_(/*67.27*/routes/*67.33*/.Application.login()),format.raw/*67.53*/("""">
                  <i class="fa fa-lock"></i> """),_display_(/*68.47*/Messages("landing.dangnhap")),format.raw/*68.75*/("""
                """),format.raw/*69.17*/("""</a>
              </li>
              <li>
                <a href=""""),_display_(/*72.27*/routes/*72.33*/.Application.register()),format.raw/*72.56*/("""">
                  <i class="fa fa-lock"></i> """),_display_(/*73.47*/Messages("landing.dangki")),format.raw/*73.73*/("""
                """),format.raw/*74.17*/("""</a>
              </li>
            """)))}),format.raw/*76.14*/("""
          """),format.raw/*77.11*/("""</ul>
        </div>
          <!-- /.navbar-collapse -->
      </div>
    </nav>
    <div class="wrapper">
      <div class="parallax filter-gradient red" data-color="red">
        <div class="parallax-background">
          <img class="parallax-background-image" src=""""),_display_(/*85.56*/routes/*85.62*/.Assets.versioned("awesome/img/bg3.jpg")),format.raw/*85.102*/("""">
        </div>
        <div class= "container">
          <div class="row">
            <div class="col-md-5 hidden-xs">
              <div class="parallax-image">
                <img class="phone" src=""""),_display_(/*91.42*/routes/*91.48*/.Assets.versioned("awesome/img/iphone3.png")),format.raw/*91.92*/("""" style="margin-top: 20px"/>
              </div>
            </div>
            <div class="col-md-6 col-md-offset-1">
              <div class="description">
                <h2>"""),_display_(/*96.22*/Messages("Nền tảng IoT InnoWay")),format.raw/*96.54*/("""</h2>
                <br>
                <h5>"""),_display_(/*98.22*/Messages("Cùng trải nghiệm những ứng dụng điện thoại đã tích hợp với nền tảng IoT Innoway cho các bộ giải pháp như: Nhà thông minh, Trang trại thông minh.")),format.raw/*98.178*/("""</h5>
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
          <h4 class="header-text text-center">"""),_display_(/*115.48*/Messages("Danh sách App SDK")),format.raw/*115.77*/("""</h4>
          <div class="row">
            <div class="col-md-12">
              <div class="card mb-3">
                <div class="card-body" style="padding: 0px;">
                  <h5 class="card-title">
                    <div class="col-md-12" style="border-bottom: 1px solid #ccc!important;">
                      <div class="row">
                        <div class="col-md-6 align-items-center" style="height: 40px; padding: 10px; margin-right: -12px;">
                          <span class="">
                          Smarthome SDK
                          </span>
                        </div>
                        <div class="col-md-3 align-items-center area-android" id="imgLogoAndoird" style="cursor: pointer; padding: 10px" onclick="changeLinkAndroid()">
                          <span>Android</span>
                        </div>
                        <div class="col-md-3 align-items-center " id="imgLogoIos" style="cursor: pointer; padding: 10px" onclick="changeLinkIos()">
                          <span class="">iOS</span>
                        </div>
                      </div>
                    </div>
                  </h5>

                  <div class="col-md-12">
                    <div class="row">
                      <div class="col-md-5">
                        <img src=""""),_display_(/*141.36*/routes/*141.42*/.Assets.versioned("images/overview/appSdk.png")),format.raw/*141.89*/("""" width="100%" alt="" />
                      </div>
                      <div class="col-md-7">
                        <p class="card-text" style="text-align: initial;">"""),_display_(/*144.76*/Messages("Ứng dụng cho phép kết nối và quản lý các thiết bị thông minh trong nhà ")),format.raw/*144.159*/("""</p>
                        <div id="linkDownloadSdk" style="text-align: initial;">
                          <a href="http://203.113.138.18:4447/s/r2mdFKfdA28otJt/download" target="_blank" >
                            <i class="fa fa-download" style="padding: 0px 5px; border: 1px solid #ccc!important;"></i> """),_display_(/*147.121*/Messages("Tải tài liệu ")),format.raw/*147.146*/("""
                          """),format.raw/*148.27*/("""</a><br>
                          <a href="http://203.113.138.18:4447/s/j8GJxdf3js55FsB/download" target="_blank" >
                            <i class="fa fa-download" style="padding: 0px 5px; border: 1px solid #ccc!important;"></i> """),_display_(/*150.121*/Messages("Tải SDK ")),format.raw/*150.141*/("""
                          """),format.raw/*151.27*/("""</a>
                          <hr>
                        </div>
                      </div>
                    </div>
                  </div>

                </div>
              </div>
            </div>

            <div class="col-md-12">
              <div class="card mb-3">
                <div class="card-body" style="padding: 0px;">
                  <h5 class="card-title">
                    <div class="col-md-12" style="border-bottom: 1px solid #ccc!important;">
                      <div class="row">
                        <div class="col-md-6 align-items-center" style="height: 40px; padding: 10px; margin-right: -12px;">
                          <span class="">
                          Smart Tracking SDK
                          </span>
                        </div>
                        <div class="col-md-3 align-items-center area-android" style="cursor: pointer; padding: 10px" onclick="">
                          <span>Android</span>
                        </div>
                        <div class="col-md-3 align-items-center" style="cursor: pointer; padding: 10px" onclick="">
                          <span class="">iOS</span>
                        </div>
                      </div>
                    </div>
                  </h5>

                  <div class="col-md-12" style="padding: 15px;">
                    <p class="card-text">Đang phát triển </p>
                  </div>
                </div>
              </div>
            </div>

            <div class="col-md-12">
              <div class="card mb-3">
                <div class="card-body" style="padding: 0px;">
                  <h5 class="card-title">
                    <div class="col-md-12" style="border-bottom: 1px solid #ccc!important;">
                      <div class="row">
                        <div class="col-md-6 align-items-center" style="height: 40px; padding: 10px; margin-right: -12px;">
                          <span class="">
                          Smart Packing SDK
                          </span>
                        </div>
                        <div class="col-md-3 align-items-center area-android" style="cursor: pointer; padding: 10px" onclick="">
                          <span>Android</span>
                        </div>
                        <div class="col-md-3 align-items-center" style="cursor: pointer; padding: 10px" onclick="">
                          <span class="">iOS</span>
                        </div>
                      </div>
                    </div>
                  </h5>

                  <div class="col-md-12" style="padding: 15px;">
                    <p class="card-text">Đang phát triển </p>
                  </div>
                </div>
              </div>
            </div>

            <div class="col-md-12">
              <div class="card mb-3">
                <div class="card-body" style="padding: 0px;">
                  <h5 class="card-title">
                    <div class="col-md-12" style="border-bottom: 1px solid #ccc!important;">
                      <div class="row">
                        <div class="col-md-6 align-items-center" style="height: 40px; padding: 10px; margin-right: -12px;">
                          <span class="">
                          Industry SDK
                          </span>
                        </div>
                        <div class="col-md-3 align-items-center area-android" style="cursor: pointer; padding: 10px" onclick="">
                          <span>Android</span>
                        </div>
                        <div class="col-md-3 align-items-center" style="cursor: pointer; padding: 10px" onclick="">
                          <span class="">iOS</span>
                        </div>
                      </div>
                    </div>
                  </h5>

                  <div class="col-md-12" style="padding: 15px;">
                    <p class="card-text">Đang phát triển </p>
                  </div>
                </div>
              </div>
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
  <script src=""""),_display_(/*273.17*/routes/*273.23*/.Assets.versioned("awesome/js/jquery-1.10.2.js")),format.raw/*273.71*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*274.17*/routes/*274.23*/.Assets.versioned("awesome/js/jquery-ui-1.10.4.custom.min.js")),format.raw/*274.85*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*275.17*/routes/*275.23*/.Assets.versioned("awesome/js/bootstrap.js")),format.raw/*275.67*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*276.17*/routes/*276.23*/.Assets.versioned("awesome/js/awesome-landing-page.js")),format.raw/*276.78*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*278.17*/routes/*278.23*/.Assets.versioned("javascripts/views/app/appSdk.js")),format.raw/*278.75*/(""""></script>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPage/page/AppSdk.scala.html
                  HASH: 88addbde4ac88e9e41f9120442881d8195386bd9
                  MATRIX: 668->1|1004->35|1117->53|1144->54|1286->170|1300->176|1356->212|1670->499|1685->505|1752->551|1818->590|1833->596|1903->645|2236->951|2251->957|2325->1010|2392->1050|2407->1056|2481->1109|3387->1988|3402->1994|3452->2023|3526->2070|3569->2092|3612->2107|3703->2171|3718->2177|3778->2216|3853->2264|3899->2289|3942->2304|4033->2368|4048->2374|4101->2406|4201->2479|4241->2498|4284->2513|4375->2577|4390->2583|4445->2617|4521->2666|4563->2687|4606->2702|4669->2738|4701->2761|4740->2762|4783->2777|4841->2808|4856->2814|4905->2842|4981->2891|5001->2902|5034->2914|5079->2931|5136->2970|5149->2975|5188->2976|5231->2991|5289->3022|5304->3028|5345->3048|5421->3097|5470->3125|5515->3142|5612->3212|5627->3218|5671->3241|5747->3290|5794->3316|5839->3333|5908->3371|5947->3382|6245->3653|6260->3659|6322->3699|6557->3907|6572->3913|6637->3957|6845->4138|6898->4170|6973->4218|7151->4374|7718->4913|7769->4942|9131->6276|9147->6282|9216->6329|9418->6503|9524->6586|9866->6899|9914->6924|9970->6951|10236->7188|10279->7208|10335->7235|15246->12118|15262->12124|15332->12172|15411->12223|15427->12229|15511->12291|15590->12342|15606->12348|15672->12392|15751->12443|15767->12449|15844->12504|15924->12556|15940->12562|16014->12614
                  LINES: 24->1|29->2|34->2|35->3|39->7|39->7|39->7|45->13|45->13|45->13|46->14|46->14|46->14|51->19|51->19|51->19|53->21|53->21|53->21|72->40|72->40|72->40|73->41|73->41|74->42|77->45|77->45|77->45|78->46|78->46|79->47|82->50|82->50|82->50|83->51|83->51|84->52|87->55|87->55|87->55|88->56|88->56|89->57|91->59|91->59|91->59|92->60|93->61|93->61|93->61|94->62|94->62|94->62|95->63|97->65|97->65|97->65|98->66|99->67|99->67|99->67|100->68|100->68|101->69|104->72|104->72|104->72|105->73|105->73|106->74|108->76|109->77|117->85|117->85|117->85|123->91|123->91|123->91|128->96|128->96|130->98|130->98|147->115|147->115|173->141|173->141|173->141|176->144|176->144|179->147|179->147|180->148|182->150|182->150|183->151|305->273|305->273|305->273|306->274|306->274|306->274|307->275|307->275|307->275|308->276|308->276|308->276|310->278|310->278|310->278
                  -- GENERATED --
              */
          