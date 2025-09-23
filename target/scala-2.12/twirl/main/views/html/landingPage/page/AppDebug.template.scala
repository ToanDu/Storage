
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

object AppDebug extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>AppDebug</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <link href=""""),_display_(/*13.18*/routes/*13.24*/.Assets.versioned("awesome/css/bootstrap.css")),format.raw/*13.70*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*14.18*/routes/*14.24*/.Assets.versioned("awesome/css/landing-page.css")),format.raw/*14.73*/("""" rel="stylesheet"/>

      <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400,300' rel='stylesheet' type='text/css'>
    <link href=""""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("awesome/css/pe-icon-7-stroke.css")),format.raw/*19.77*/("""" rel="stylesheet" />

    <style>
            .Rectangle-1486 """),format.raw/*22.29*/("""{"""),format.raw/*22.30*/("""
              """),format.raw/*23.15*/("""width: 80%;
              height: 50px;
              margin: 18px 13px 13px 72px;
              padding: 11px 35px 8px 23px;
              border-radius: 16px;
              border: solid 1px #707070;
              background-color: #fffafb;
            """),format.raw/*30.13*/("""}"""),format.raw/*30.14*/("""
            """),format.raw/*31.13*/(""".Ellipse-344 """),format.raw/*31.26*/("""{"""),format.raw/*31.27*/("""
              """),format.raw/*32.15*/("""width: 38px;
              height: 38px;
              margin: 0 30px 0 0;
              padding: 7px 14px 8px;
              border: solid 1px #707070;
              background-color: #fff;
              border-radius: 50%
            """),format.raw/*39.13*/("""}"""),format.raw/*39.14*/("""
            """),format.raw/*40.13*/(""".qr-text """),format.raw/*40.22*/("""{"""),format.raw/*40.23*/("""
              """),format.raw/*41.15*/("""width: 100%;
              height: 23px;
              margin: 6px 0 9px 3px;
              font-size: 18px;
              font-weight: normal;
              font-stretch: normal;
              font-style: normal;
              line-height: 1.28;
              letter-spacing: normal;
              text-align: left;
              color: #333;
            """),format.raw/*52.13*/("""}"""),format.raw/*52.14*/("""
    """),format.raw/*53.5*/("""</style>

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
              <a href=""""),_display_(/*72.25*/routes/*72.31*/.LandingPageController.home()),format.raw/*72.60*/("""">
                <i class="fa fa-home"></i> """),_display_(/*73.45*/Messages("Trang chủ ")),format.raw/*73.67*/("""
              """),format.raw/*74.15*/("""</a>
            </li>
            <li>
              <a href=""""),_display_(/*77.25*/routes/*77.31*/.AppDebugController.solutionMaketPage()),format.raw/*77.70*/("""">
                <i class="fa fa-cloud"></i> """),_display_(/*78.46*/Messages("Giải pháp mẫu")),format.raw/*78.71*/("""
              """),format.raw/*79.15*/("""</a>
            </li>
            <li>
              <a href=""""),_display_(/*82.25*/routes/*82.31*/.AppDebugController.appSdkPage()),format.raw/*82.63*/("""">
                <i class="fa fa-tablet"></i> """),_display_(/*83.47*/Messages("App SDK")),format.raw/*83.66*/("""
              """),format.raw/*84.15*/("""</a>
            </li>
            <li>
              <a href=""""),_display_(/*87.25*/routes/*87.31*/.AppDebugController.appDebugPage()),format.raw/*87.65*/("""" class="btn btn-neutral">
                <i class="fa fa-tablet"></i> """),_display_(/*88.47*/Messages("App Debug")),format.raw/*88.68*/("""
              """),format.raw/*89.15*/("""</a>
            </li>
            """),_display_(/*91.14*/if(currentUser != null)/*91.37*/{_display_(Seq[Any](format.raw/*91.38*/("""
              """),format.raw/*92.15*/("""<li>
                <a href=""""),_display_(/*93.27*/routes/*93.33*/.ProjectController.project()),format.raw/*93.61*/("""">
                  <i class="fa fa-user"></i> """),_display_(/*94.47*/currentUser/*94.58*/.getUsername),format.raw/*94.70*/("""
                """),format.raw/*95.17*/("""</a>
              </li>
            """)))}/*97.15*/else/*97.20*/{_display_(Seq[Any](format.raw/*97.21*/("""
              """),format.raw/*98.15*/("""<li>
                <a href=""""),_display_(/*99.27*/routes/*99.33*/.Application.login()),format.raw/*99.53*/("""">
                  <i class="fa fa-lock"></i> """),_display_(/*100.47*/Messages("landing.dangnhap")),format.raw/*100.75*/("""
                """),format.raw/*101.17*/("""</a>
              </li>
              <li>
                <a href=""""),_display_(/*104.27*/routes/*104.33*/.Application.register()),format.raw/*104.56*/("""">
                  <i class="fa fa-lock"></i> """),_display_(/*105.47*/Messages("landing.dangki")),format.raw/*105.73*/("""
                """),format.raw/*106.17*/("""</a>
              </li>
            """)))}),format.raw/*108.14*/("""
          """),format.raw/*109.11*/("""</ul>
        </div>
          <!-- /.navbar-collapse -->
      </div>
    </nav>
    <div class="wrapper">
      <div class="parallax filter-gradient red" data-color="red">
        <div class="parallax-background">
          <img class="parallax-background-image" src=""""),_display_(/*117.56*/routes/*117.62*/.Assets.versioned("awesome/img/bg3.jpg")),format.raw/*117.102*/("""">
        </div>
        <div class= "container">
          <div class="row">
            <div class="col-md-5 hidden-xs">
              <div class="parallax-image">
                <img class="phone" src=""""),_display_(/*123.42*/routes/*123.48*/.Assets.versioned("awesome/img/iphone3.png")),format.raw/*123.92*/("""" style="margin-top: 20px"/>
              </div>
            </div>
            <div class="col-md-6 col-md-offset-1">
              <div class="description">
                <h2>"""),_display_(/*128.22*/Messages("Nền tảng IoT InnoWay")),format.raw/*128.54*/("""</h2>
                <br>
                <h5>"""),_display_(/*130.22*/Messages("Cùng trải nghiệm những ứng dụng điện thoại đã tích hợp với nền tảng IoT Innoway cho các bộ giải pháp như: Nhà thông minh, Trang trại thông minh.")),format.raw/*130.178*/("""</h5>
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
          <h4 class="header-text text-center">"""),_display_(/*147.48*/Messages("App Debug IOS/ANDROID")),format.raw/*147.81*/("""</h4>
          <div class="row">

            <div class="col-md-12">
              <img src=""""),_display_(/*151.26*/routes/*151.32*/.Assets.versioned("images/debug.png")),format.raw/*151.69*/("""" alt="..." class="card-img" style="width: 100%;">
            </div>

            <div class="col-md-12">
              <div class="card-body">
                <h5 style="font-weight: bold">"""),_display_(/*156.48*/Messages("Vsmart debug")),format.raw/*156.72*/("""</h5>
                <p class="card-text">"""),_display_(/*157.39*/Messages("Vsmart debug là ứng dụng hỗ trợ các nhà phát triển theo dõi dữ liệu của các thiết bị đã tích hợp với nền tảng Innoway.")),format.raw/*157.169*/("""</p>
                <p class="card-text">"""),_display_(/*158.39*/Messages("Để cài đặt ứng dụng, vui lòng thực hiện theo hướng dẫn sau:")),format.raw/*158.110*/("""</p>
                <div class="Rectangle-1486 d-flex">
                  """),format.raw/*160.68*/("""
                  """),format.raw/*161.19*/("""<span class="qr-text">1. Quét mã QR bằng điện thoại</span>
                </div>
                <div class="Rectangle-1486 d-flex">
                  """),format.raw/*164.68*/("""
                  """),format.raw/*165.19*/("""<span class="qr-text">2. Cài đặt ứng dụng Deploygate</span>
                </div>
                <div class="Rectangle-1486 d-flex">
                  """),format.raw/*168.68*/("""
                  """),format.raw/*169.19*/("""<span class="qr-text">3. Quét mã QR bằng ứng dụng Deploygate</span>
                </div>
              </div>
            </div>

            <div class="col-md-6 mt-3">
              <div class="card-body align-items-center">
                <h5 style="font-weight: bold; text-transform: uppercase;">"""),_display_(/*176.76*/Messages("Android")),format.raw/*176.95*/("""</h5>
                <img src=""""),_display_(/*177.28*/routes/*177.34*/.Assets.versioned("images/debugAdroid.png")),format.raw/*177.77*/("""" alt="..." class="card-img" style="width: 380px; padding: 15px">
                <br>
                <a href="https://dply.me/3j9wws" target="_blank">"""),_display_(/*179.67*/Messages("Hoặc truy cập vào đường link: https://dply.me/3j9wws")),format.raw/*179.131*/("""</a>
              </div>
            </div>

            <div class="col-md-6">
              <div class="card-body align-items-center">
                <h5 style="font-weight: bold; text-transform: uppercase;">"""),_display_(/*185.76*/Messages("IOS")),format.raw/*185.91*/("""</h5>
                <img src=""""),_display_(/*186.28*/routes/*186.34*/.Assets.versioned("images/debugIos.png")),format.raw/*186.74*/("""" alt="..." class="card-img" style="width: 380px; padding: 15px">
                <br>
                <a href="https://dply.me/hhdor8" target="_blank">"""),_display_(/*188.67*/Messages("Hoặc truy cập vào đường link: https://dply.me/hhdor8")),format.raw/*188.131*/("""</a>
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
  <script src=""""),_display_(/*220.17*/routes/*220.23*/.Assets.versioned("awesome/js/jquery-1.10.2.js")),format.raw/*220.71*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*221.17*/routes/*221.23*/.Assets.versioned("awesome/js/jquery-ui-1.10.4.custom.min.js")),format.raw/*221.85*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*222.17*/routes/*222.23*/.Assets.versioned("awesome/js/bootstrap.js")),format.raw/*222.67*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*223.17*/routes/*223.23*/.Assets.versioned("awesome/js/awesome-landing-page.js")),format.raw/*223.78*/("""" type="text/javascript"></script>


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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPage/page/AppDebug.scala.html
                  HASH: 2baa473debb6e9cb31c32adc66291a37153ca454
                  MATRIX: 668->1|1006->35|1119->53|1146->54|1288->170|1302->176|1358->212|1674->501|1689->507|1756->553|1822->592|1837->598|1907->647|2240->953|2255->959|2329->1012|2420->1075|2449->1076|2492->1091|2775->1346|2804->1347|2845->1360|2886->1373|2915->1374|2958->1389|3222->1625|3251->1626|3292->1639|3329->1648|3358->1649|3401->1664|3785->2020|3814->2021|3846->2026|4739->2892|4754->2898|4804->2927|4878->2974|4921->2996|4964->3011|5055->3075|5070->3081|5130->3120|5205->3168|5251->3193|5294->3208|5385->3272|5400->3278|5453->3310|5529->3359|5569->3378|5612->3393|5703->3457|5718->3463|5773->3497|5873->3570|5915->3591|5958->3606|6021->3642|6053->3665|6092->3666|6135->3681|6193->3712|6208->3718|6257->3746|6333->3795|6353->3806|6386->3818|6431->3835|6488->3874|6501->3879|6540->3880|6583->3895|6641->3926|6656->3932|6697->3952|6774->4001|6824->4029|6870->4046|6968->4116|6984->4122|7029->4145|7106->4194|7154->4220|7200->4237|7270->4275|7310->4286|7609->4557|7625->4563|7688->4603|7924->4811|7940->4817|8006->4861|8215->5042|8269->5074|8345->5122|8524->5278|9091->5817|9146->5850|9270->5946|9286->5952|9345->5989|9565->6181|9611->6205|9683->6249|9836->6379|9907->6422|10001->6493|10105->6617|10153->6636|10334->6837|10382->6856|10564->7058|10612->7077|10944->7381|10985->7400|11046->7433|11062->7439|11127->7482|11308->7635|11395->7699|11636->7912|11673->7927|11734->7960|11750->7966|11812->8006|11993->8159|12080->8223|12962->9077|12978->9083|13048->9131|13127->9182|13143->9188|13227->9250|13306->9301|13322->9307|13388->9351|13467->9402|13483->9408|13560->9463
                  LINES: 24->1|29->2|34->2|35->3|39->7|39->7|39->7|45->13|45->13|45->13|46->14|46->14|46->14|51->19|51->19|51->19|54->22|54->22|55->23|62->30|62->30|63->31|63->31|63->31|64->32|71->39|71->39|72->40|72->40|72->40|73->41|84->52|84->52|85->53|104->72|104->72|104->72|105->73|105->73|106->74|109->77|109->77|109->77|110->78|110->78|111->79|114->82|114->82|114->82|115->83|115->83|116->84|119->87|119->87|119->87|120->88|120->88|121->89|123->91|123->91|123->91|124->92|125->93|125->93|125->93|126->94|126->94|126->94|127->95|129->97|129->97|129->97|130->98|131->99|131->99|131->99|132->100|132->100|133->101|136->104|136->104|136->104|137->105|137->105|138->106|140->108|141->109|149->117|149->117|149->117|155->123|155->123|155->123|160->128|160->128|162->130|162->130|179->147|179->147|183->151|183->151|183->151|188->156|188->156|189->157|189->157|190->158|190->158|192->160|193->161|196->164|197->165|200->168|201->169|208->176|208->176|209->177|209->177|209->177|211->179|211->179|217->185|217->185|218->186|218->186|218->186|220->188|220->188|252->220|252->220|252->220|253->221|253->221|253->221|254->222|254->222|254->222|255->223|255->223|255->223
                  -- GENERATED --
              */
          