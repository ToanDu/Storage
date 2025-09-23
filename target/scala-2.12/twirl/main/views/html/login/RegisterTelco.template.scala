
package views.html.login

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

object RegisterTelco extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>"""),_display_(/*6.17*/Messages("Register")),format.raw/*6.37*/("""</title>
        <link rel="icon" type="image/png" href=""""),_display_(/*7.50*/routes/*7.56*/.Assets.versioned("images/logo.jpg")),format.raw/*7.92*/("""">

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

        <link href=""""),_display_(/*13.22*/routes/*13.28*/.Assets.versioned("assets/css/pace.min.css")),format.raw/*13.72*/("""" rel="stylesheet" />
            <!-- Bootstrap CSS -->
        <link href=""""),_display_(/*15.22*/routes/*15.28*/.Assets.versioned("assets/css/bootstrap.min.css")),format.raw/*15.77*/("""" rel="stylesheet">
        <link href=""""),_display_(/*16.22*/routes/*16.28*/.Assets.versioned("assets/css/app.css")),format.raw/*16.67*/("""" rel="stylesheet">

        <link href=""""),_display_(/*18.22*/routes/*18.28*/.Assets.versioned("assets/css/icons.css")),format.raw/*18.69*/("""" rel="stylesheet">

        <link rel="stylesheet" href=""""),_display_(/*20.39*/routes/*20.45*/.Assets.versioned("assets/plugins/notifications/css/lobibox.min.css")),format.raw/*20.114*/("""" />

        <link href=""""),_display_(/*22.22*/routes/*22.28*/.Assets.versioned("stylesheets/views/login/loginTelco.css")),format.raw/*22.87*/("""" rel="stylesheet">
    </head>
    <body class="bg-theme" style="background-image: url("""),_display_(/*24.58*/routes/*24.64*/.Assets.versioned("images/landingPageTelco/banner_1.jpg")),format.raw/*24.121*/(""")">

        <div class="wrapper">
            <div class="col-12 col-lg-8 mx-auto">
                <div class="logo">
                    <div class="navbar-brand mr-lg-5">
                        <a href=""""),_display_(/*30.35*/routes/*30.41*/.LandingPageController.home()),format.raw/*30.70*/("""">
                            <img src=""""),_display_(/*31.40*/routes/*31.46*/.Assets.versioned("images/landingPageTelco/Logo_Viettel.svg")),format.raw/*31.107*/("""" height="80%" alt="" />
                        </a>
                    </div>
                </div>
            </div>
            <div class="authentication-reset-password d-flex align-items-center justify-content-center">
                <div class="row">
                    <div class="col-12 col-lg-8 mx-auto">
                        <div class="">
                            <div class="row g-0" style="border-radius: 18px;box-shadow: 0 0 30px 0 rgba(129, 137, 152, 0.4);background-color: #ffffff;">
                                <div class="col-lg-7" style="background-image: url(/assets/images/landingPageTelco/Rectangle_29.png);  background-repeat: no-repeat;  background-size: 100% 100%;">
                                    <div class="text-center1">
                                        <p class="texth">"""),_display_(/*43.59*/Messages("Dịch vụ Sim Data truyền tải dữ liệu")),format.raw/*43.106*/("""</p>
                                    </div>
                                </div>
                                <div class="col-lg-5 border-end">
                                    <div class="card-body mb-1">
                                        <div class="p-6 mt-3">
                                            <div class="row g-3" action=""""),_display_(/*49.75*/routes/*49.81*/.Application.authenticate()),format.raw/*49.108*/("""" id="form-login" method="post" autocomplete="off">
                                                <div class="col-12" style="text-align: center">
                                                    <h4 class="hello">"""),_display_(/*51.72*/Messages("Chào mừng bạn!")),format.raw/*51.98*/("""</h4>
                                                    <h4 class="dangnhap" style="">"""),_display_(/*52.84*/Messages("Đăng ký tài khoản")),format.raw/*52.113*/("""</h4>
                                                    <h4 class="" style="font-weight: 400;font-size: 16px; line-height: 21px;color: #727272;">"""),_display_(/*53.143*/Messages("Để trải nghiệm dịch vụ của chúng tôi")),format.raw/*53.191*/("""</h4>
                                                </div>
                                                <div class="col-12">
                                                    <div class="input-group">
                                                        <a class="input-group-text"><i class='bx bx-user'></i></a>
                                                        <input type="text"  name="username" class="form-control" required maxlength="50" id="inputUsername" placeholder="Email *">
                                                    </div>
                                                </div>
                                                <div class="col-12">
                                                    <div class="input-group" id="show_hide_password">
                                                        <a id="iconHidePass" onclick="showPassword()" class="input-group-text"><i class='bx bx-hide'></i></a>
                                                        <input type="password" name="password" class="form-control" id="inputChoosePassword" required maxlength="50" placeholder="Mật khẩu *">
                                                    </div>
                                                </div>
                                                <div class="col-12">
                                                    <div class="input-group" id="show_hide_password">
                                                        <a id="iconHideRePass" onclick="showRePassword()" class="input-group-text"><i class='bx bx-hide'></i></a>
                                                        <input type="password"  name="passwordRepeat" class="form-control" id="inputChooseRePassword" required maxlength="50" placeholder="Nhập lại mật khẩu *">
                                                    </div>
                                                </div>
                                                <div class="d-grid-1">
                                                    <a id="buttonGetOtpEmail" onclick="getOtpEmail()" style="font-weight: bold; color: #EA0033;text-align: right;cursor: pointer; border: none;background: none" >"""),_display_(/*74.212*/Messages("Gửi OTP")),format.raw/*74.231*/("""</a>
                                                </div>
                                                <div class="col-12">
                                                    <div class="input-group">
                                                        <input type="text" name="optEmail" class="form-control" id="inputOtpEmail" required maxlength="50" placeholder="Nhập mã OTP kích hoạt email *" oninput="validateNumberInput(this)">
                                                    </div>
                                                </div>
                                                <div class="col-12">
                                                    <h3 class="title-section-3">"""),_display_(/*82.82*/Messages("Khi nhập Đăng ký, bạn đã đồng ý thực hiện mọi giao dịch theo ")),format.raw/*82.155*/("""<a href="/" style="color: #ee0033">"""),_display_(/*82.191*/Messages("Điều kiện sử dụng dịch vụ của chính sách Viettel?")),format.raw/*82.252*/("""</a></h3>
                                                </div>
                                                <div class="col-12" style="text-align: -webkit-center;">
                                                    <div class="d-grid" style="width: 50%;">
                                                        <button onclick="sendRegister()" style="background: #EA0033;  border-radius: 8px 8px 8px 0px; color: #FFFFFF" class="btn btn-dark">"""),_display_(/*86.189*/Messages("Đăng ký")),format.raw/*86.208*/("""<span style="margin-left: 4px;">&#8599;</span></button>
                                                    </div>
                                                </div>

                                                <div class="col-12 mt-5">
                                                    <div class="col-12 mt-5">
                                                        <div class="d-grid">
                                                            <p>"""),_display_(/*93.65*/Messages("Đã có tài khoản?")),format.raw/*93.93*/("""</p>
                                                        </div>
                                                        <div class="d-grid">
                                                            <a href=""""),_display_(/*96.71*/routes/*96.77*/.Application.login()),format.raw/*96.97*/("""" style="font-weight: bold;color: #EA0033;">"""),_display_(/*96.142*/Messages("Đăng nhập tại đây.")),format.raw/*96.172*/("""</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <hr style="border-top: 1px solid #4D4D4D; margin: 20px auto;">
            <div class="container">
                <div class="row" id="footer-menu">
                    <div class="col-md-6" style="text-align: left;">
                        <span class="footer-text-4">"""),_display_(/*113.54*/Messages("Copyright Viettel Telecom 2022")),format.raw/*113.96*/("""</span>
                    </div>
                    <div class="col-md-6" id="center_footer">
                        <span class="footer-text-4">"""),_display_(/*116.54*/Messages("Follow us: ")),format.raw/*116.77*/("""</span>
                        <a href="https://www.facebook.com/innoway.vn/" class="fa fa-facebook-square" target="_blank" style="font-size: 23px; color: #B1B1B1; "></a>
                        <a href="https://twitter.com/VInnoway" class="fa fa-twitter-square" target="_blank" style="font-size: 23px; color: #B1B1B1; margin-left: 10px;"></a>
                        <a href="https://www.instagram.com/innoway.vn/" class="fa fa-instagram" target="_blank" style="font-size: 23px; color: #B1B1B1; margin-left: 10px;"></a>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script type="text/javascript" src=""""),_display_(/*125.42*/routes/*125.48*/.JsController.jsMessages()),format.raw/*125.74*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*126.42*/routes/*126.48*/.JsController.javascriptRoutes),format.raw/*126.78*/(""""></script>
    <script src=""""),_display_(/*127.19*/routes/*127.25*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*127.79*/("""" type="text/javascript"></script>

    <script type="text/javascript" src=""""),_display_(/*129.42*/routes/*129.48*/.Assets.versioned("assets/js/jquery.min.js")),format.raw/*129.92*/(""""></script>
        <!--notification js -->
    <script src=""""),_display_(/*131.19*/routes/*131.25*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*131.92*/(""""></script>
    <script src=""""),_display_(/*132.19*/routes/*132.25*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*132.98*/(""""></script>
    <script src=""""),_display_(/*133.19*/routes/*133.25*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*133.107*/(""""></script>

    <script src=""""),_display_(/*135.19*/routes/*135.25*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*135.77*/("""" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function()"""),format.raw/*137.37*/("""{"""),format.raw/*137.38*/("""
            """),_display_(/*138.14*/if(flash.containsKey("success"))/*138.46*/ {_display_(Seq[Any](format.raw/*138.48*/("""
            """),format.raw/*139.13*/("""showNotification('success','"""),_display_(/*139.42*/flash/*139.47*/.get("success")),format.raw/*139.62*/("""');
            """)))}),format.raw/*140.14*/("""
            """),_display_(/*141.14*/if(flash.containsKey("failed"))/*141.45*/ {_display_(Seq[Any](format.raw/*141.47*/("""
            """),format.raw/*142.13*/("""showNotification('danger','"""),_display_(/*142.41*/flash/*142.46*/.get("failed")),format.raw/*142.60*/("""');
            """)))}),format.raw/*143.14*/("""
        """),format.raw/*144.9*/("""}"""),format.raw/*144.10*/(""");
    </script>
    <script>
        function validateNumberInput(inputElement) """),format.raw/*147.52*/("""{"""),format.raw/*147.53*/("""
            """),format.raw/*148.13*/("""var inputValue = inputElement.value;

            var numericValue = inputValue.replace(/[^0-9]/g, '');

            if (inputValue !== numericValue) """),format.raw/*152.46*/("""{"""),format.raw/*152.47*/("""
                """),format.raw/*153.17*/("""inputElement.value = numericValue;
            """),format.raw/*154.13*/("""}"""),format.raw/*154.14*/("""
        """),format.raw/*155.9*/("""}"""),format.raw/*155.10*/("""
  """),format.raw/*156.3*/("""</script>
    <script src=""""),_display_(/*157.19*/routes/*157.25*/.Assets.versioned("javascripts/plugins/moment.min.js")),format.raw/*157.79*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*158.19*/routes/*158.25*/.Assets.versioned("assets/js/chosen.jquery.min.js")),format.raw/*158.76*/(""""></script>
    <script src=""""),_display_(/*159.19*/routes/*159.25*/.Assets.versioned("javascripts/views/login/register.js")),format.raw/*159.81*/("""" type="text/javascript"></script>

</html>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:48 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/login/RegisterTelco.scala.html
                  HASH: 82ba8dc8611a9886502baa9f0aa34869a49574cc
                  MATRIX: 1044->0|1236->166|1276->186|1360->244|1374->250|1430->286|1777->606|1792->612|1857->656|1962->734|1977->740|2047->789|2115->830|2130->836|2190->875|2259->917|2274->923|2336->964|2422->1023|2437->1029|2528->1098|2582->1125|2597->1131|2677->1190|2793->1279|2808->1285|2887->1342|3123->1551|3138->1557|3188->1586|3257->1628|3272->1634|3355->1695|4211->2524|4280->2571|4662->2926|4677->2932|4726->2959|4972->3178|5019->3204|5135->3293|5186->3322|5362->3470|5432->3518|7648->5706|7689->5725|8423->6432|8518->6505|8582->6541|8665->6602|9144->7053|9185->7072|9676->7536|9725->7564|9967->7779|9982->7785|10023->7805|10096->7850|10148->7880|10957->8661|11021->8703|11199->8853|11244->8876|11931->9535|11947->9541|11995->9567|12076->9620|12092->9626|12144->9656|12202->9686|12218->9692|12294->9746|12399->9823|12415->9829|12481->9873|12571->9935|12587->9941|12676->10008|12734->10038|12750->10044|12845->10117|12903->10147|12919->10153|13024->10235|13083->10266|13099->10272|13173->10324|13309->10431|13339->10432|13381->10446|13423->10478|13464->10480|13506->10493|13563->10522|13578->10527|13615->10542|13664->10559|13706->10573|13747->10604|13788->10606|13830->10619|13886->10647|13901->10652|13937->10666|13986->10683|14023->10692|14053->10693|14163->10774|14193->10775|14235->10788|14414->10938|14444->10939|14490->10956|14566->11003|14596->11004|14633->11013|14663->11014|14694->11017|14750->11045|14766->11051|14842->11105|14923->11158|14939->11164|15012->11215|15070->11245|15086->11251|15164->11307
                  LINES: 33->1|38->6|38->6|39->7|39->7|39->7|45->13|45->13|45->13|47->15|47->15|47->15|48->16|48->16|48->16|50->18|50->18|50->18|52->20|52->20|52->20|54->22|54->22|54->22|56->24|56->24|56->24|62->30|62->30|62->30|63->31|63->31|63->31|75->43|75->43|81->49|81->49|81->49|83->51|83->51|84->52|84->52|85->53|85->53|106->74|106->74|114->82|114->82|114->82|114->82|118->86|118->86|125->93|125->93|128->96|128->96|128->96|128->96|128->96|145->113|145->113|148->116|148->116|157->125|157->125|157->125|158->126|158->126|158->126|159->127|159->127|159->127|161->129|161->129|161->129|163->131|163->131|163->131|164->132|164->132|164->132|165->133|165->133|165->133|167->135|167->135|167->135|169->137|169->137|170->138|170->138|170->138|171->139|171->139|171->139|171->139|172->140|173->141|173->141|173->141|174->142|174->142|174->142|174->142|175->143|176->144|176->144|179->147|179->147|180->148|184->152|184->152|185->153|186->154|186->154|187->155|187->155|188->156|189->157|189->157|189->157|190->158|190->158|190->158|191->159|191->159|191->159
                  -- GENERATED --
              */
          