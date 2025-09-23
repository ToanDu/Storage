
package views.html.download

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

object DownloadPage extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <link rel="icon" type="image/png" href=""""),_display_(/*5.46*/routes/*5.52*/.Assets.versioned("images/logo.jpg")),format.raw/*5.88*/("""">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Download</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <link href=""""),_display_(/*11.18*/routes/*11.24*/.Assets.versioned("awesome/css/bootstrap.css")),format.raw/*11.70*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*12.18*/routes/*12.24*/.Assets.versioned("awesome/css/landing-page.css")),format.raw/*12.73*/("""" rel="stylesheet"/>

      <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400,300' rel='stylesheet' type='text/css'>
    <link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("awesome/css/pe-icon-7-stroke.css")),format.raw/*17.77*/("""" rel="stylesheet" />

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
          """),format.raw/*31.18*/("""
            """),format.raw/*32.45*/("""
              """),format.raw/*33.37*/("""
                """),format.raw/*34.98*/("""
              """),format.raw/*35.25*/("""
              """),format.raw/*36.38*/("""
                                """),format.raw/*37.44*/("""
              """),format.raw/*38.25*/("""
            """),format.raw/*39.23*/("""
          """),format.raw/*40.19*/("""
        """),format.raw/*41.9*/("""</div>
          <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="example" >
          <ul class="nav navbar-nav navbar-right">
            <li>
              <a href=""""),_display_(/*46.25*/routes/*46.31*/.LandingPageController.home()),format.raw/*46.60*/("""">
                <i class="fa fa-home"></i> """),_display_(/*47.45*/Messages("Trang chủ ")),format.raw/*47.67*/("""
              """),format.raw/*48.15*/("""</a>
            </li>
            <li>
              <a href=""""),_display_(/*51.25*/routes/*51.31*/.Application.login()),format.raw/*51.51*/("""">
                <i class="fa fa-user"></i> """),_display_(/*52.45*/Messages("landing.dangnhap")),format.raw/*52.73*/("""
              """),format.raw/*53.15*/("""</a>
            </li>
            <li>
              <a href=""""),_display_(/*56.25*/routes/*56.31*/.Application.register()),format.raw/*56.54*/("""">
                <i class="fa fa-edit"></i> """),_display_(/*57.45*/Messages("landing.dangki")),format.raw/*57.71*/("""
              """),format.raw/*58.15*/("""</a>
            </li>
          </ul>
        </div>
          <!-- /.navbar-collapse -->
      </div>
    </nav>
    <div class="wrapper">
      <div class="parallax filter-gradient red" data-color="red">
        <div class="parallax-background">
          <img class="parallax-background-image" src=""""),_display_(/*68.56*/routes/*68.62*/.Assets.versioned("awesome/img/bg3.jpg")),format.raw/*68.102*/("""">
        </div>
        <div class= "container">
          <div class="row">
            <div class="col-md-5 hidden-xs">
              <div class="parallax-image">
                <img class="phone" src=""""),_display_(/*74.42*/routes/*74.48*/.Assets.versioned("awesome/img/iphone3.png")),format.raw/*74.92*/("""" style="margin-top: 20px"/>
              </div>
            </div>
            <div class="col-md-6 col-md-offset-1">
              <div class="description">
                <h2>"""),_display_(/*79.22*/Messages("Nền tảng IoT InnoWay")),format.raw/*79.54*/("""</h2>
                <br>
                <h5>"""),_display_(/*81.22*/Messages("Cùng trải nghiệm những ứng dụng điện thoại đã tích hợp với nền tảng IoT Innoway cho các bộ giải pháp như: Nhà thông minh, Trang trại thông minh.")),format.raw/*81.178*/("""</h5>
              </div>
              <div class="buttons">
                <button class="btn btn-simple btn-neutral">
                  <i class="fa fa-apple"></i>
                </button>
                <button class="btn btn-simple btn-neutral">
                  <i class="fa fa-android"></i>
                </button>
                """),format.raw/*90.64*/("""
                  """),format.raw/*91.52*/("""
                """),format.raw/*92.30*/("""
              """),format.raw/*93.15*/("""</div>
            </div>
          </div>
        </div>
      </div>

      <div class="section section-features">
        <div class="container">
          <h4 class="header-text text-center">Download App Smarthome</h4>
          <div class="row">
            <div class="col-md-6">
              <div class="card card-blue">
                <div class="">
                  <img src=""""),_display_(/*106.30*/routes/*106.36*/.Assets.versioned("images/landingPage/download/androidSmarthome.jpeg")),format.raw/*106.106*/("""" style="width: 80%">
                </div>
                <div class="text">
                  <a href="https://dply.me/qh3w1h" target="_blank">"""),_display_(/*109.69*/Messages("Link download Android: https://dply.me/qh3w1h")),format.raw/*109.126*/("""</a>
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div class="card card-blue">
                <div class="">
                  <img src=""""),_display_(/*116.30*/routes/*116.36*/.Assets.versioned("images/landingPage/download/iosSmarthome.jpeg")),format.raw/*116.102*/("""" style="width: 80%">
                </div>
                <div class="text">
                  <a href="https://dply.me/t0naoi" target="_blank">"""),_display_(/*119.69*/Messages("Link download IOS: https://dply.me/t0naoi")),format.raw/*119.122*/("""</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="section section-features">
        <div class="container">
          <h4 class="header-text text-center">Download App Smartfarm</h4>
          <div class="row">
            <div class="col-md-6">
              <div class="card card-blue">
                <div class="">
                  <img src=""""),_display_(/*134.30*/routes/*134.36*/.Assets.versioned("images/landingPage/download/iosSmartfarm.jpeg")),format.raw/*134.102*/("""" style="width: 80%">
                </div>
                <div class="text">
                  <a href="https://dply.me/9zecfj" target="_blank">"""),_display_(/*137.69*/Messages("Link download Android: https://dply.me/9zecfj")),format.raw/*137.126*/("""</a>
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div class="card card-blue">
                <div class="">
                  <img src=""""),_display_(/*144.30*/routes/*144.36*/.Assets.versioned("images/landingPage/download/iosSmartfarm.jpeg")),format.raw/*144.102*/("""" style="width: 80%">
                </div>
                <div class="text">
                  <a href="https://dply.me/9zecfj" target="_blank">"""),_display_(/*147.69*/Messages("Link download IOS: https://dply.me/9zecfj")),format.raw/*147.122*/("""</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <footer class="footer">
        <div class="container">
          <nav class="pull-left">
            """),format.raw/*158.21*/("""
              """),format.raw/*159.23*/("""
                """),format.raw/*160.95*/("""
              """),format.raw/*161.24*/("""
            """),format.raw/*162.22*/("""
          """),format.raw/*163.11*/("""</nav>
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
                &copy; 2021 <a href="#">Innoway Platform team</a>, made with love
          </div>
        </div>
      </footer>
    </div>

  </body>
  <script src=""""),_display_(/*183.17*/routes/*183.23*/.Assets.versioned("awesome/js/jquery-1.10.2.js")),format.raw/*183.71*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*184.17*/routes/*184.23*/.Assets.versioned("awesome/js/jquery-ui-1.10.4.custom.min.js")),format.raw/*184.85*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*185.17*/routes/*185.23*/.Assets.versioned("awesome/js/bootstrap.js")),format.raw/*185.67*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*186.17*/routes/*186.23*/.Assets.versioned("awesome/js/awesome-landing-page.js")),format.raw/*186.78*/("""" type="text/javascript"></script>
</html>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:41 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/download/DownloadPage.scala.html
                  HASH: 71f3324f7f2af5b561f7bb3a59db9ad47adc95e5
                  MATRIX: 1046->0|1188->116|1202->122|1258->158|1574->447|1589->453|1656->499|1722->538|1737->544|1807->593|2140->899|2155->905|2229->958|2898->1606|2939->1651|2982->1688|3027->1786|3070->1811|3113->1849|3174->1893|3217->1918|3258->1941|3297->1960|3333->1969|3600->2209|3615->2215|3665->2244|3739->2291|3782->2313|3825->2328|3916->2392|3931->2398|3972->2418|4046->2465|4095->2493|4138->2508|4229->2572|4244->2578|4288->2601|4362->2648|4409->2674|4452->2689|4783->2993|4798->2999|4860->3039|5095->3247|5110->3253|5175->3297|5383->3478|5436->3510|5511->3558|5689->3714|6062->4106|6109->4158|6154->4188|6197->4203|6614->4592|6630->4598|6723->4668|6899->4816|6979->4873|7213->5079|7229->5085|7318->5151|7494->5299|7570->5352|8029->5783|8045->5789|8134->5855|8310->6003|8390->6060|8624->6266|8640->6272|8729->6338|8905->6486|8981->6539|9232->6769|9276->6792|9322->6887|9366->6911|9408->6933|9448->6944|10131->7599|10147->7605|10217->7653|10296->7704|10312->7710|10396->7772|10475->7823|10491->7829|10557->7873|10636->7924|10652->7930|10729->7985
                  LINES: 33->1|37->5|37->5|37->5|43->11|43->11|43->11|44->12|44->12|44->12|49->17|49->17|49->17|63->31|64->32|65->33|66->34|67->35|68->36|69->37|70->38|71->39|72->40|73->41|78->46|78->46|78->46|79->47|79->47|80->48|83->51|83->51|83->51|84->52|84->52|85->53|88->56|88->56|88->56|89->57|89->57|90->58|100->68|100->68|100->68|106->74|106->74|106->74|111->79|111->79|113->81|113->81|122->90|123->91|124->92|125->93|138->106|138->106|138->106|141->109|141->109|148->116|148->116|148->116|151->119|151->119|166->134|166->134|166->134|169->137|169->137|176->144|176->144|176->144|179->147|179->147|190->158|191->159|192->160|193->161|194->162|195->163|215->183|215->183|215->183|216->184|216->184|216->184|217->185|217->185|217->185|218->186|218->186|218->186
                  -- GENERATED --
              */
          