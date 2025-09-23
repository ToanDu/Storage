
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

object LoginTelcoDemo extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>"""),_display_(/*6.17*/Messages("Login")),format.raw/*6.34*/("""</title>
        <link rel="icon" type="image/png" href=""""),_display_(/*7.50*/routes/*7.56*/.Assets.versioned("images/logo.jpg")),format.raw/*7.92*/("""">

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <link href=""""),_display_(/*12.22*/routes/*12.28*/.Assets.versioned("assets/css/pace.min.css")),format.raw/*12.72*/("""" rel="stylesheet" />
            <!-- Bootstrap CSS -->
        <link href=""""),_display_(/*14.22*/routes/*14.28*/.Assets.versioned("assets/css/bootstrap.min.css")),format.raw/*14.77*/("""" rel="stylesheet">
        <link href=""""),_display_(/*15.22*/routes/*15.28*/.Assets.versioned("assets/css/app.css")),format.raw/*15.67*/("""" rel="stylesheet">
        <link href=""""),_display_(/*16.22*/routes/*16.28*/.Assets.versioned("assets/css/icons.css")),format.raw/*16.69*/("""" rel="stylesheet">
        <link rel="stylesheet" href=""""),_display_(/*17.39*/routes/*17.45*/.Assets.versioned("assets/plugins/notifications/css/lobibox.min.css")),format.raw/*17.114*/("""" />
        <link href=""""),_display_(/*18.22*/routes/*18.28*/.Assets.versioned("stylesheets/views/login/loginTelco.css")),format.raw/*18.87*/("""" rel="stylesheet">
    </head>
    <body class="bg-theme " style="background-image: url("""),_display_(/*20.59*/routes/*20.65*/.Assets.versioned("images/landingPageTelco/banner_1.jpg")),format.raw/*20.122*/(""");    background-repeat: no-repeat;  background-size: 100% 100%;">

        <div class="wrapper">
            <div class="col-12 col-lg-8 mx-auto">
                <div class="logo">
                    <a class="navbar-brand mr-lg-5" href=""""),_display_(/*25.60*/routes/*25.66*/.LandingPageController.home()),format.raw/*25.95*/("""">
                        <img class="imglogo" src=""""),_display_(/*26.52*/routes/*26.58*/.Assets.versioned("images/landingPageTelco/Logo_Viettel.svg")),format.raw/*26.119*/("""" >
                    </a>
                </div>
            </div>
            <div class="authentication-reset-password d-flex align-items-center justify-content-center">
                <div class="row">
                    <div class="col-12 col-lg-8 mx-auto">
                        <div class="">
                            <div class="row g-0" style="border-radius: 14px;box-shadow: 0 0 30px 0 rgba(129, 137, 152, 0.4);background-color: #ffffff;">

                                <div class="col-lg-7" style="background-image: url(/assets/images/landingPageTelco/Rectangle_29.png);  background-repeat: no-repeat;  background-size: 100% 100%;">
                                    <div class="text-center">
                                        <p class="texth">"""),_display_(/*38.59*/Messages("Dịch vụ Sim Data truyền tải dữ liệu")),format.raw/*38.106*/("""</p>
                                    </div>
                                    """),format.raw/*40.175*/("""
                                """),format.raw/*41.33*/("""</div>
                                <div class="col-lg-5 border-end">
                                    <div class="card-body mb-1">
                                        <div class="p-6 mt-3">
                                            <form class="row g-3" action=""""),_display_(/*45.76*/routes/*45.82*/.Application.authenticate()),format.raw/*45.109*/("""" id="form-login" method="post" autocomplete="off">
                                                <div class="col-12" style="text-align: center">
                                                    <h4 class="hello">"""),_display_(/*47.72*/Messages("Chào mừng bạn!")),format.raw/*47.98*/("""</h4>
                                                    <h4 class="dangnhap" style="">"""),_display_(/*48.84*/Messages("login.login")),format.raw/*48.107*/("""</h4>
                                                    <h4 class="" style="font-weight: 400; font-size: 16px; line-height: 21px; color: #727272;">"""),_display_(/*49.145*/Messages("Để trải nghiệm dịch vụ của chúng tôi")),format.raw/*49.193*/("""</h4>
                                                </div>
                                                <div class="col-12">
                                                    <div class="input-group">
                                                        <a class="input-group-text"><i class='bx bx-user'></i></a>
                                                        <input type="text" id="inputEmail" name="username" class="form-control" maxlength="50" placeholder="Email*" value=""""),_display_(/*54.173*/Messages("iot@viettel.com.vn")),format.raw/*54.203*/("""">
                                                    </div>
                                                </div>
                                                <div class="col-12">
                                                    """),format.raw/*58.144*/("""
                                                """),format.raw/*59.49*/("""<div class="input-group" id="show_hide_password">
                                                    <a id="iconHidePass" onclick="showPassword()" class="input-group-text"><i class='bx bx-hide'></i></a>
                                                    <input type="password" name="password"  class="form-control" id="inputChoosePassword" maxlength="50" placeholder="Mật khẩu*" value=""""),_display_(/*61.186*/Messages("123456a@")),format.raw/*61.206*/("""">
                                                </div>
                                                </div>


                                                <div class="col-12">
                                                    <div class="d-grid">
                                                        <a href=""""),_display_(/*68.67*/routes/*68.73*/.Application.forgotPassPage()),format.raw/*68.102*/("""" style="font-weight: bold; color: #EA0033;text-align: right;font-weight: 600;  font-size: 14px;  line-height: 18px;">"""),_display_(/*68.221*/Messages("Quên mật khẩu?")),format.raw/*68.247*/("""</a>
                                                    </div>
                                                    <div class="col-12" style="text-align: -webkit-center">
                                                        <div class="d-grid" style="width: 50%;padding-top: 15px;">
                                                            """),format.raw/*72.295*/("""
                                                        """),format.raw/*73.57*/("""<button type="submit" id="loginButton" style="background: #EA0033;  border-radius: 8px 8px 8px 0px; color: #FFFFFF" class="btn" >"""),_display_(/*73.187*/Messages("Đăng nhập")),format.raw/*73.208*/("""<span style="margin-left: 4px;">&#8599;</span></button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="p-6" style="padding: 0rem;">
                                            <div class="col-12 mt-5">
                                                <div class="d-grid ">
                                                    <div class="d-grid " >
                                                        <p style="margin-bottom: 0.5rem;">"""),_display_(/*83.92*/Messages("Bạn chưa có tài khoản?")),format.raw/*83.126*/("""</p>
                                                        <a href=""""),_display_(/*84.67*/routes/*84.73*/.Application.register()),format.raw/*84.96*/("""" style="font-weight: bold;font-weight: 400;  font-size: 16px;  line-height: 21px;  align-items: center;  text-align: center;"><span style="color: #ee0033">"""),_display_(/*84.253*/Messages("Đăng kí tại đây.")),format.raw/*84.281*/("""</span></a>
                                                        <a href="https://vht-iot.gitbook.io/huong-dan-su-dung-cmp/" target="_blank" style="font-weight: 400;  font-size: 16px;  line-height: 21px;  align-items: center;  text-align: center; margin-top: 15px;">
                                                            <span style="color: #ee0033">"""),_display_(/*86.91*/Messages("Hướng dẫn sử dụng")),format.raw/*86.120*/("""</span>
                                                        </a>
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
                        <span class="footer-text-4">"""),_display_(/*104.54*/Messages("Copyright Viettel Telecom 2022")),format.raw/*104.96*/("""</span>
                    </div>
                    <div class="col-md-6" id="center_footer">
                        <span class="footer-text-4">"""),_display_(/*107.54*/Messages("Follow us: ")),format.raw/*107.77*/("""</span>
                        <a href="https://www.facebook.com/innoway.vn/" class="fa fa-facebook-square" target="_blank" style="font-size: 23px; color: #B1B1B1; "></a>
                        <a href="https://twitter.com/VInnoway" class="fa fa-twitter-square" target="_blank" style="font-size: 23px; color: #B1B1B1; margin-left: 10px;"></a>
                        <a href="https://www.instagram.com/innoway.vn/" class="fa fa-instagram" target="_blank" style="font-size: 23px; color: #B1B1B1; margin-left: 10px;"></a>
                    </div>
                </div>
            </div>
        </div>

        """),_display_(/*116.10*/views/*116.15*/.html.login.LoginTelco_opt()),format.raw/*116.43*/("""
        """),_display_(/*117.10*/views/*117.15*/.html.Loading()),format.raw/*117.30*/("""
    """),format.raw/*118.5*/("""</body>

    <script type="text/javascript" src=""""),_display_(/*120.42*/routes/*120.48*/.JsController.jsMessages()),format.raw/*120.74*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*121.42*/routes/*121.48*/.JsController.javascriptRoutes),format.raw/*121.78*/(""""></script>
    <script src=""""),_display_(/*122.19*/routes/*122.25*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*122.79*/("""" type="text/javascript"></script>

    <script type="text/javascript" src=""""),_display_(/*124.42*/routes/*124.48*/.Assets.versioned("assets/js/jquery.min.js")),format.raw/*124.92*/(""""></script>
        <!--notification js -->
    <script src=""""),_display_(/*126.19*/routes/*126.25*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*126.92*/(""""></script>
    <script src=""""),_display_(/*127.19*/routes/*127.25*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*127.98*/(""""></script>
    <script src=""""),_display_(/*128.19*/routes/*128.25*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*128.107*/(""""></script>

    <script src=""""),_display_(/*130.19*/routes/*130.25*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*130.77*/("""" type="text/javascript"></script>
    <script type="text/javascript">
            $(document).ready(function()"""),format.raw/*132.41*/("""{"""),format.raw/*132.42*/("""
                """),_display_(/*133.18*/if(flash.containsKey("success"))/*133.50*/ {_display_(Seq[Any](format.raw/*133.52*/("""
                """),format.raw/*134.17*/("""showNotification('success','"""),_display_(/*134.46*/flash/*134.51*/.get("success")),format.raw/*134.66*/("""');
                """)))}),format.raw/*135.18*/("""
                """),_display_(/*136.18*/if(flash.containsKey("failed"))/*136.49*/ {_display_(Seq[Any](format.raw/*136.51*/("""
                """),format.raw/*137.17*/("""showNotification('danger','"""),_display_(/*137.45*/flash/*137.50*/.get("failed")),format.raw/*137.64*/("""');
                """)))}),format.raw/*138.18*/("""
            """),format.raw/*139.13*/("""}"""),format.raw/*139.14*/(""");
    </script>
    <script src=""""),_display_(/*141.19*/routes/*141.25*/.Assets.versioned("javascripts/plugins/moment.min.js")),format.raw/*141.79*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*142.19*/routes/*142.25*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*142.79*/(""""></script>

    <script src=""""),_display_(/*144.19*/routes/*144.25*/.Assets.versioned("javascripts/views/login/login.js")),format.raw/*144.78*/("""" type="text/javascript"></script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/login/LoginTelcoDemo.scala.html
                  HASH: a5f3a6251ae256b06ad5959f7be6a5f69813edbf
                  MATRIX: 1045->0|1237->166|1274->183|1358->241|1372->247|1428->283|1774->602|1789->608|1854->652|1959->730|1974->736|2044->785|2112->826|2127->832|2187->871|2255->912|2270->918|2332->959|2417->1017|2432->1023|2523->1092|2576->1118|2591->1124|2671->1183|2788->1273|2803->1279|2882->1336|3151->1578|3166->1584|3216->1613|3297->1667|3312->1673|3395->1734|4199->2511|4268->2558|4381->2780|4442->2813|4745->3089|4760->3095|4809->3122|5055->3341|5102->3367|5218->3456|5263->3479|5441->3629|5511->3677|6034->4172|6086->4202|6353->4531|6430->4580|6847->4969|6889->4989|7239->5312|7254->5318|7305->5347|7452->5466|7500->5492|7876->6073|7961->6130|8119->6260|8162->6281|8908->7000|8964->7034|9062->7105|9077->7111|9121->7134|9306->7291|9356->7319|9743->7679|9794->7708|10605->8491|10669->8533|10847->8683|10892->8706|11536->9322|11551->9327|11601->9355|11639->9365|11654->9370|11691->9385|11724->9390|11802->9440|11818->9446|11866->9472|11947->9525|11963->9531|12015->9561|12073->9591|12089->9597|12165->9651|12270->9728|12286->9734|12352->9778|12442->9840|12458->9846|12547->9913|12605->9943|12621->9949|12716->10022|12774->10052|12790->10058|12895->10140|12954->10171|12970->10177|13044->10229|13184->10340|13214->10341|13260->10359|13302->10391|13343->10393|13389->10410|13446->10439|13461->10444|13498->10459|13551->10480|13597->10498|13638->10529|13679->10531|13725->10548|13781->10576|13796->10581|13832->10595|13885->10616|13927->10629|13957->10630|14020->10665|14036->10671|14112->10725|14193->10778|14209->10784|14285->10838|14344->10869|14360->10875|14435->10928
                  LINES: 33->1|38->6|38->6|39->7|39->7|39->7|44->12|44->12|44->12|46->14|46->14|46->14|47->15|47->15|47->15|48->16|48->16|48->16|49->17|49->17|49->17|50->18|50->18|50->18|52->20|52->20|52->20|57->25|57->25|57->25|58->26|58->26|58->26|70->38|70->38|72->40|73->41|77->45|77->45|77->45|79->47|79->47|80->48|80->48|81->49|81->49|86->54|86->54|90->58|91->59|93->61|93->61|100->68|100->68|100->68|100->68|100->68|104->72|105->73|105->73|105->73|115->83|115->83|116->84|116->84|116->84|116->84|116->84|118->86|118->86|136->104|136->104|139->107|139->107|148->116|148->116|148->116|149->117|149->117|149->117|150->118|152->120|152->120|152->120|153->121|153->121|153->121|154->122|154->122|154->122|156->124|156->124|156->124|158->126|158->126|158->126|159->127|159->127|159->127|160->128|160->128|160->128|162->130|162->130|162->130|164->132|164->132|165->133|165->133|165->133|166->134|166->134|166->134|166->134|167->135|168->136|168->136|168->136|169->137|169->137|169->137|169->137|170->138|171->139|171->139|173->141|173->141|173->141|174->142|174->142|174->142|176->144|176->144|176->144
                  -- GENERATED --
              */
          