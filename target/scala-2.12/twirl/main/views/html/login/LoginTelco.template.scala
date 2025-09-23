
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

object LoginTelco extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

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
                                                    """),format.raw/*52.142*/("""
                                                """),format.raw/*53.49*/("""<div class="input-group">
                                                    <a class="input-group-text"><i class='bx bx-user'></i></a>
                                                    <input type="text" id="inputEmail" name="username" class="form-control" maxlength="50" placeholder="Email*">
                                                </div>
                                                </div>
                                                <div class="col-12">
                                                    """),format.raw/*59.144*/("""
                                                """),format.raw/*60.49*/("""<div class="input-group" id="show_hide_password">
                                                    <a id="iconHidePass" onclick="showPassword()" class="input-group-text"><i class='bx bx-hide'></i></a>
                                                    <input type="password" name="password"  class="form-control" id="inputChoosePassword" maxlength="50" placeholder="Mật khẩu*">
                                                </div>
                                                </div>


                                                <div class="col-12">
                                                    <div class="d-grid">
                                                        <a href=""""),_display_(/*69.67*/routes/*69.73*/.Application.forgotPassPage()),format.raw/*69.102*/("""" style="font-weight: bold; color: #EA0033;text-align: right;font-weight: 600;  font-size: 14px;  line-height: 18px;">"""),_display_(/*69.221*/Messages("Quên mật khẩu?")),format.raw/*69.247*/("""</a>
                                                    </div>
                                                    <div class="col-12" style="text-align: -webkit-center">
                                                        <div class="d-grid" style="width: 50%;padding-top: 15px;">
                                                            """),format.raw/*73.295*/("""
                                                            """),format.raw/*74.61*/("""<button type="submit" id="loginButton" style="background: #EA0033;  border-radius: 8px 8px 8px 0px; color: #FFFFFF" class="btn" >"""),_display_(/*74.191*/Messages("Đăng nhập")),format.raw/*74.212*/("""<span style="margin-left: 4px;">&#8599;</span></button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="p-6" style="padding: 0rem;">
                                            <div class="col-12 mt-5">
                                                <div class="d-grid ">
                                                    <div class="d-grid " >
                                                        <p style="margin-bottom: 0.5rem;">"""),_display_(/*84.92*/Messages("Bạn chưa có tài khoản?")),format.raw/*84.126*/("""</p>
                                                        <a href=""""),_display_(/*85.67*/routes/*85.73*/.Application.register()),format.raw/*85.96*/("""" style="font-weight: bold;font-weight: 400;  font-size: 16px;  line-height: 21px;  align-items: center;  text-align: center;"><span style="color: #ee0033">"""),_display_(/*85.253*/Messages("Đăng kí tại đây.")),format.raw/*85.281*/("""</span></a>
                                                        <a href="https://vht-iot.gitbook.io/huong-dan-su-dung-cmp/" target="_blank" style="font-weight: 400;  font-size: 16px;  line-height: 21px;  align-items: center;  text-align: center; margin-top: 15px;">
                                                            <span style="color: #ee0033">"""),_display_(/*87.91*/Messages("Hướng dẫn sử dụng")),format.raw/*87.120*/("""</span>
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
                        <span class="footer-text-4">"""),_display_(/*105.54*/Messages("Copyright Viettel Telecom 2022")),format.raw/*105.96*/("""</span>
                    </div>
                    <div class="col-md-6" id="center_footer">
                        <span class="footer-text-4">"""),_display_(/*108.54*/Messages("Follow us: ")),format.raw/*108.77*/("""</span>
                        <a href="https://www.facebook.com/innoway.vn/" class="fa fa-facebook-square" target="_blank" style="font-size: 23px; color: #B1B1B1; "></a>
                        <a href="https://twitter.com/VInnoway" class="fa fa-twitter-square" target="_blank" style="font-size: 23px; color: #B1B1B1; margin-left: 10px;"></a>
                        <a href="https://www.instagram.com/innoway.vn/" class="fa fa-instagram" target="_blank" style="font-size: 23px; color: #B1B1B1; margin-left: 10px;"></a>
                    </div>
                </div>
            </div>
        </div>

        """),_display_(/*117.10*/views/*117.15*/.html.login.LoginTelco_opt()),format.raw/*117.43*/("""
        """),_display_(/*118.10*/views/*118.15*/.html.Loading()),format.raw/*118.30*/("""
    """),format.raw/*119.5*/("""</body>

    <script type="text/javascript" src=""""),_display_(/*121.42*/routes/*121.48*/.JsController.jsMessages()),format.raw/*121.74*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*122.42*/routes/*122.48*/.JsController.javascriptRoutes),format.raw/*122.78*/(""""></script>
    <script src=""""),_display_(/*123.19*/routes/*123.25*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*123.79*/("""" type="text/javascript"></script>

    <script type="text/javascript" src=""""),_display_(/*125.42*/routes/*125.48*/.Assets.versioned("assets/js/jquery.min.js")),format.raw/*125.92*/(""""></script>
        <!--notification js -->
    <script src=""""),_display_(/*127.19*/routes/*127.25*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*127.92*/(""""></script>
    <script src=""""),_display_(/*128.19*/routes/*128.25*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*128.98*/(""""></script>
    <script src=""""),_display_(/*129.19*/routes/*129.25*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*129.107*/(""""></script>

    <script src=""""),_display_(/*131.19*/routes/*131.25*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*131.77*/("""" type="text/javascript"></script>
    <script type="text/javascript">
            $(document).ready(function()"""),format.raw/*133.41*/("""{"""),format.raw/*133.42*/("""
                """),_display_(/*134.18*/if(flash.containsKey("success"))/*134.50*/ {_display_(Seq[Any](format.raw/*134.52*/("""
                """),format.raw/*135.17*/("""showNotification('success','"""),_display_(/*135.46*/flash/*135.51*/.get("success")),format.raw/*135.66*/("""');
                """)))}),format.raw/*136.18*/("""
                """),_display_(/*137.18*/if(flash.containsKey("failed"))/*137.49*/ {_display_(Seq[Any](format.raw/*137.51*/("""
                """),format.raw/*138.17*/("""showNotification('danger','"""),_display_(/*138.45*/flash/*138.50*/.get("failed")),format.raw/*138.64*/("""');
                """)))}),format.raw/*139.18*/("""
            """),format.raw/*140.13*/("""}"""),format.raw/*140.14*/(""");
    </script>
    <script src=""""),_display_(/*142.19*/routes/*142.25*/.Assets.versioned("javascripts/plugins/moment.min.js")),format.raw/*142.79*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*143.19*/routes/*143.25*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*143.79*/(""""></script>

    <script src=""""),_display_(/*145.19*/routes/*145.25*/.Assets.versioned("javascripts/views/login/login.js")),format.raw/*145.78*/("""" type="text/javascript"></script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/login/LoginTelco.scala.html
                  HASH: eb93bfcb8c793ba51f7f66aae98f6345f0179824
                  MATRIX: 1041->0|1233->166|1270->183|1354->241|1368->247|1424->283|1770->602|1785->608|1850->652|1955->730|1970->736|2040->785|2108->826|2123->832|2183->871|2251->912|2266->918|2328->959|2413->1017|2428->1023|2519->1092|2572->1118|2587->1124|2667->1183|2784->1273|2799->1279|2878->1336|3147->1578|3162->1584|3212->1613|3293->1667|3308->1673|3391->1734|4195->2511|4264->2558|4377->2780|4438->2813|4741->3089|4756->3095|4805->3122|5051->3341|5098->3367|5214->3456|5259->3479|5437->3629|5507->3677|5718->3948|5795->3997|6353->4617|6430->4666|7159->5368|7174->5374|7225->5403|7372->5522|7420->5548|7796->6129|7885->6190|8043->6320|8086->6341|8832->7060|8888->7094|8986->7165|9001->7171|9045->7194|9230->7351|9280->7379|9667->7739|9718->7768|10529->8551|10593->8593|10771->8743|10816->8766|11460->9382|11475->9387|11525->9415|11563->9425|11578->9430|11615->9445|11648->9450|11726->9500|11742->9506|11790->9532|11871->9585|11887->9591|11939->9621|11997->9651|12013->9657|12089->9711|12194->9788|12210->9794|12276->9838|12366->9900|12382->9906|12471->9973|12529->10003|12545->10009|12640->10082|12698->10112|12714->10118|12819->10200|12878->10231|12894->10237|12968->10289|13108->10400|13138->10401|13184->10419|13226->10451|13267->10453|13313->10470|13370->10499|13385->10504|13422->10519|13475->10540|13521->10558|13562->10589|13603->10591|13649->10608|13705->10636|13720->10641|13756->10655|13809->10676|13851->10689|13881->10690|13944->10725|13960->10731|14036->10785|14117->10838|14133->10844|14209->10898|14268->10929|14284->10935|14359->10988
                  LINES: 33->1|38->6|38->6|39->7|39->7|39->7|44->12|44->12|44->12|46->14|46->14|46->14|47->15|47->15|47->15|48->16|48->16|48->16|49->17|49->17|49->17|50->18|50->18|50->18|52->20|52->20|52->20|57->25|57->25|57->25|58->26|58->26|58->26|70->38|70->38|72->40|73->41|77->45|77->45|77->45|79->47|79->47|80->48|80->48|81->49|81->49|84->52|85->53|91->59|92->60|101->69|101->69|101->69|101->69|101->69|105->73|106->74|106->74|106->74|116->84|116->84|117->85|117->85|117->85|117->85|117->85|119->87|119->87|137->105|137->105|140->108|140->108|149->117|149->117|149->117|150->118|150->118|150->118|151->119|153->121|153->121|153->121|154->122|154->122|154->122|155->123|155->123|155->123|157->125|157->125|157->125|159->127|159->127|159->127|160->128|160->128|160->128|161->129|161->129|161->129|163->131|163->131|163->131|165->133|165->133|166->134|166->134|166->134|167->135|167->135|167->135|167->135|168->136|169->137|169->137|169->137|170->138|170->138|170->138|170->138|171->139|172->140|172->140|174->142|174->142|174->142|175->143|175->143|175->143|177->145|177->145|177->145
                  -- GENERATED --
              */
          