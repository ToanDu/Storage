
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
/*1.2*/import helper._

object Register extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>"""),_display_(/*7.17*/Messages("Register")),format.raw/*7.37*/("""</title>
        <link rel="icon" type="image/png" href=""""),_display_(/*8.50*/routes/*8.56*/.Assets.versioned("images/logo.jpg")),format.raw/*8.92*/("""">

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        <link href=""""),_display_(/*13.22*/routes/*13.28*/.Assets.versioned("assets/css/pace.min.css")),format.raw/*13.72*/("""" rel="stylesheet" />
            <!-- Bootstrap CSS -->
        <link href=""""),_display_(/*15.22*/routes/*15.28*/.Assets.versioned("assets/css/bootstrap.min.css")),format.raw/*15.77*/("""" rel="stylesheet">
        <link href=""""),_display_(/*16.22*/routes/*16.28*/.Assets.versioned("assets/css/app.css")),format.raw/*16.67*/("""" rel="stylesheet">
        <link href=""""),_display_(/*17.22*/routes/*17.28*/.Assets.versioned("assets/css/icons.css")),format.raw/*17.69*/("""" rel="stylesheet">

        <link rel="stylesheet" href=""""),_display_(/*19.39*/routes/*19.45*/.Assets.versioned("assets/plugins/notifications/css/lobibox.min.css")),format.raw/*19.114*/("""" />

        <link href=""""),_display_(/*21.22*/routes/*21.28*/.Assets.versioned("stylesheets/views/login/login.css")),format.raw/*21.82*/("""" rel="stylesheet">
        </head>
    <body class="bg-theme " style="background-image: url("""),_display_(/*23.59*/routes/*23.65*/.Assets.versioned("images/login/background.png")),format.raw/*23.113*/(""")">
        <div class="wrapper">
            <div class="authentication-reset-password d-flex align-items-center justify-content-center">
                <div class="row">
                    <div class="col-12 col-lg-8 mx-auto">
                        <div class="">
                            <div class="row g-0" style="padding: 30px;border-radius: 32px;box-shadow: 0 0 30px 0 rgba(129, 137, 152, 0.4);background-color: #ffffff;">

                                <div class="col-lg-7">
                                    <div class="text-center">
                                        <a href=""""),_display_(/*33.51*/routes/*33.57*/.LandingPageController.home()),format.raw/*33.86*/("""">
                                            <img src=""""),_display_(/*34.56*/routes/*34.62*/.Assets.versioned("images/landingPageTelco/viettel.svg")),format.raw/*34.118*/("""" height="80%" alt="" />
                                        </a>
                                    </div>
                                    <img src=""""),_display_(/*37.48*/routes/*37.54*/.Assets.versioned("images/login/frame.png")),format.raw/*37.97*/("""" class="card-img login-img h-80 mt-5" alt="...">
                                </div>
                                <div class="col-lg-5 border-end">
                                    <div class="card-body">
                                        <div class="p-6 mt-3">
                                            <div class="row g-3" id="form-login" >
                                                <div class="col-12">
                                                    <h4 class="dangnhap">"""),_display_(/*44.75*/Messages("register.title")),format.raw/*44.101*/("""</h4>
                                                </div>
                                                <div class="col-12">
                                                    <label for="inputUsername" class="form-label">"""),_display_(/*47.100*/Messages("login.username")),format.raw/*47.126*/("""</label>
                                                    <input type="text" name="username" class="form-control" required maxlength="50" id="inputUsername">
                                                </div>
                                                <div class="col-12">
                                                    <label for="inputChoosePassword" class="form-label">"""),_display_(/*51.106*/Messages("login.Password")),format.raw/*51.132*/("""</label>
                                                    <div class="input-group" id="show_hide_password">
                                                        <input type="password" name="password" class="form-control border-end-0" id="inputChoosePassword" required maxlength="50">
                                                        <a id="iconHidePass" onclick="showPassword()" class="input-group-text"><i class='bx bx-hide'></i></a>
                                                    </div>
                                                </div>
                                                <div class="col-12">
                                                    <label for="inputChooseRePassword" class="form-label">"""),_display_(/*58.108*/Messages("login.RePassword")),format.raw/*58.136*/("""</label>
                                                    <div class="input-group" id="show_hide_password">
                                                        <input type="password" name="passwordRepeat" class="form-control border-end-0" id="inputChooseRePassword" required maxlength="50">
                                                        <a id="iconHideRePass" onclick="showRePassword()" class="input-group-text"><i class='bx bx-hide'></i></a>
                                                    </div>
                                                </div>
                                                <div class="col-12">
                                                    <label for="inputChooseOtpEmail" class="form-label">"""),_display_(/*65.106*/Messages("Nhập mã OTP kích hoạt mail")),format.raw/*65.144*/("""</label>
                                                    <div class="input-group">
                                                        <input type="text" name="optEmail" class="form-control border-end-0" id="inputOtpEmail" required maxlength="50">
                                                        <a id="buttonGetOtpEmail" onclick="getOtpEmail()" class="input-group-text cursor-pointer">"""),_display_(/*68.148*/Messages("Nhận mã OTP")),format.raw/*68.171*/("""</a>
                                                    </div>
                                                </div>

                                                <div class="col-12">
                                                    <hr>
                                                </div>
                                                <div class="col-12">
                                                    <div class="d-grid">
                                                        <button class="btn btn-dark" onclick="sendRegister()">"""),_display_(/*77.112*/Messages("btnComfirm")),format.raw/*77.134*/("""</button>
                                                    </div>
                                                </div>

                                                <div class="col-12 mt-5">
                                                    <div class="d-grid text-center">
                                                        <p>"""),_display_(/*83.61*/Messages("Bạn đã có tài khoản? ")),format.raw/*83.94*/("""<a href=""""),_display_(/*83.104*/routes/*83.110*/.Application.login()),format.raw/*83.130*/("""" style="font-weight: bold">"""),_display_(/*83.159*/Messages("Đăng nhập tại đây!")),format.raw/*83.189*/("""</a></p>
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

    </body>

    <script type="text/javascript" src=""""),_display_(/*100.42*/routes/*100.48*/.JsController.jsMessages()),format.raw/*100.74*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*101.42*/routes/*101.48*/.JsController.javascriptRoutes),format.raw/*101.78*/(""""></script>
    <script src=""""),_display_(/*102.19*/routes/*102.25*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*102.79*/("""" type="text/javascript"></script>

    <script type="text/javascript" src=""""),_display_(/*104.42*/routes/*104.48*/.Assets.versioned("assets/js/jquery.min.js")),format.raw/*104.92*/(""""></script>
        <!--notification js -->
    <script src=""""),_display_(/*106.19*/routes/*106.25*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*106.92*/(""""></script>
    <script src=""""),_display_(/*107.19*/routes/*107.25*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*107.98*/(""""></script>
    <script src=""""),_display_(/*108.19*/routes/*108.25*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*108.107*/(""""></script>

    <script src=""""),_display_(/*110.19*/routes/*110.25*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*110.77*/("""" type="text/javascript"></script>
    <script type="text/javascript">
            $(document).ready(function()"""),format.raw/*112.41*/("""{"""),format.raw/*112.42*/("""
                """),_display_(/*113.18*/if(flash.containsKey("success"))/*113.50*/ {_display_(Seq[Any](format.raw/*113.52*/("""
                """),format.raw/*114.17*/("""showNotification('success','"""),_display_(/*114.46*/flash/*114.51*/.get("success")),format.raw/*114.66*/("""');
                """)))}),format.raw/*115.18*/("""
                """),_display_(/*116.18*/if(flash.containsKey("failed"))/*116.49*/ {_display_(Seq[Any](format.raw/*116.51*/("""
                """),format.raw/*117.17*/("""showNotification('danger','"""),_display_(/*117.45*/flash/*117.50*/.get("failed")),format.raw/*117.64*/("""');
                """)))}),format.raw/*118.18*/("""
            """),format.raw/*119.13*/("""}"""),format.raw/*119.14*/(""");
    </script>
    <script src=""""),_display_(/*121.19*/routes/*121.25*/.Assets.versioned("javascripts/plugins/moment.min.js")),format.raw/*121.79*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*122.19*/routes/*122.25*/.Assets.versioned("assets/js/chosen.jquery.min.js")),format.raw/*122.76*/(""""></script>

    <script src=""""),_display_(/*124.19*/routes/*124.25*/.Assets.versioned("javascripts/views/login/register.js")),format.raw/*124.81*/("""" type="text/javascript"></script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/login/Register.scala.html
                  HASH: de7485efbbb80a1376b9514f4f6bdc42db41196f
                  MATRIX: 657->1|1062->17|1254->183|1294->203|1378->261|1392->267|1448->303|1680->508|1695->514|1760->558|1865->636|1880->642|1950->691|2018->732|2033->738|2093->777|2161->818|2176->824|2238->865|2324->924|2339->930|2430->999|2484->1026|2499->1032|2574->1086|2695->1180|2710->1186|2780->1234|3412->1839|3427->1845|3477->1874|3562->1932|3577->1938|3655->1994|3842->2154|3857->2160|3921->2203|4452->2707|4500->2733|4757->2962|4805->2988|5223->3378|5271->3404|6037->4142|6087->4170|6863->4918|6923->4956|7354->5359|7399->5382|7981->5936|8025->5958|8396->6302|8450->6335|8488->6345|8504->6351|8546->6371|8603->6400|8655->6430|9192->6939|9208->6945|9256->6971|9337->7024|9353->7030|9405->7060|9463->7090|9479->7096|9555->7150|9660->7227|9676->7233|9742->7277|9832->7339|9848->7345|9937->7412|9995->7442|10011->7448|10106->7521|10164->7551|10180->7557|10285->7639|10344->7670|10360->7676|10434->7728|10574->7839|10604->7840|10650->7858|10692->7890|10733->7892|10779->7909|10836->7938|10851->7943|10888->7958|10941->7979|10987->7997|11028->8028|11069->8030|11115->8047|11171->8075|11186->8080|11222->8094|11275->8115|11317->8128|11347->8129|11410->8164|11426->8170|11502->8224|11583->8277|11599->8283|11672->8334|11731->8365|11747->8371|11825->8427
                  LINES: 24->1|34->2|39->7|39->7|40->8|40->8|40->8|45->13|45->13|45->13|47->15|47->15|47->15|48->16|48->16|48->16|49->17|49->17|49->17|51->19|51->19|51->19|53->21|53->21|53->21|55->23|55->23|55->23|65->33|65->33|65->33|66->34|66->34|66->34|69->37|69->37|69->37|76->44|76->44|79->47|79->47|83->51|83->51|90->58|90->58|97->65|97->65|100->68|100->68|109->77|109->77|115->83|115->83|115->83|115->83|115->83|115->83|115->83|132->100|132->100|132->100|133->101|133->101|133->101|134->102|134->102|134->102|136->104|136->104|136->104|138->106|138->106|138->106|139->107|139->107|139->107|140->108|140->108|140->108|142->110|142->110|142->110|144->112|144->112|145->113|145->113|145->113|146->114|146->114|146->114|146->114|147->115|148->116|148->116|148->116|149->117|149->117|149->117|149->117|150->118|151->119|151->119|153->121|153->121|153->121|154->122|154->122|154->122|156->124|156->124|156->124
                  -- GENERATED --
              */
          