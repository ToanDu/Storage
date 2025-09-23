
package views.html.oauth

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
/*1.2*/import com.google.common.base.Strings

object Login extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Map[String, String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(map: Map[String, String]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.28*/("""

"""),format.raw/*4.1*/("""<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>"""),_display_(/*9.17*/Messages("Login")),format.raw/*9.34*/("""</title>
        <link rel="icon" type="image/png" href=""""),_display_(/*10.50*/routes/*10.56*/.Assets.versioned("images/logo.jpg")),format.raw/*10.92*/("""">

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        <link href=""""),_display_(/*15.22*/routes/*15.28*/.Assets.versioned("assets/css/pace.min.css")),format.raw/*15.72*/("""" rel="stylesheet" />
            <!-- Bootstrap CSS -->
        <link href=""""),_display_(/*17.22*/routes/*17.28*/.Assets.versioned("assets/css/bootstrap.min.css")),format.raw/*17.77*/("""" rel="stylesheet">
        <link href=""""),_display_(/*18.22*/routes/*18.28*/.Assets.versioned("assets/css/app.css")),format.raw/*18.67*/("""" rel="stylesheet">
        <link href=""""),_display_(/*19.22*/routes/*19.28*/.Assets.versioned("assets/css/icons.css")),format.raw/*19.69*/("""" rel="stylesheet">

        <link rel="stylesheet" href=""""),_display_(/*21.39*/routes/*21.45*/.Assets.versioned("assets/plugins/notifications/css/lobibox.min.css")),format.raw/*21.114*/("""" />

        <link href=""""),_display_(/*23.22*/routes/*23.28*/.Assets.versioned("stylesheets/views/login/login.css")),format.raw/*23.82*/("""" rel="stylesheet">
    </head>
    <body class="bg-theme " style="background-image: url("""),_display_(/*25.59*/routes/*25.65*/.Assets.versioned("images/login/background.png")),format.raw/*25.113*/(""")">

        <div class="wrapper">
            <div class="authentication-reset-password d-flex align-items-center justify-content-center">
                <div class="row">
                    <div class="col-12 col-lg-8 mx-auto">
                        <div class="">
                            <div class="row g-0" style="padding: 30px;border-radius: 32px;box-shadow: 0 0 30px 0 rgba(129, 137, 152, 0.4);background-color: #ffffff;">

                                <div class="col-lg-7">
                                    <div class="text-center">
                                        <a href=""""),_display_(/*36.51*/routes/*36.57*/.LandingPageController.home()),format.raw/*36.86*/("""">
                                            <img src=""""),_display_(/*37.56*/routes/*37.62*/.Assets.versioned("images/login/logo.svg")),format.raw/*37.104*/("""" height="80%" alt="" />
                                        </a>
                                    </div>

                                    <img src=""""),_display_(/*41.48*/routes/*41.54*/.Assets.versioned("images/login/frame.png")),format.raw/*41.97*/("""" class="card-img login-img h-80 mt-5" alt="...">
                                </div>

                                <div class="col-lg-5 border-end">
                                    <div class="card-body">
                                        <div class="p-6 mt-3">
                                            """),_display_(/*47.46*/if(Strings.isNullOrEmpty(map.get("loginChallenge")))/*47.98*/{_display_(Seq[Any](format.raw/*47.99*/("""
                                                """),format.raw/*48.49*/("""<div class="row g-3">
"""),format.raw/*49.77*/("""
"""),format.raw/*50.109*/("""
"""),format.raw/*51.63*/("""
                                                    """),format.raw/*52.53*/("""<div class="col-12">
                                                        <div class="d-grid text-center">
                                                            <p>
                                                                """),_display_(/*55.66*/map/*55.69*/.get("errorTitle")),format.raw/*55.87*/(""":
                                                                <a style="color:#ec1b2e">"""),_display_(/*56.91*/map/*56.94*/.get("errorContent")),format.raw/*56.114*/("""</a>
                                                            </p>
                                                        </div>
                                                    </div>
                                                </div>
                                            """)))}/*61.47*/else/*61.52*/{_display_(Seq[Any](format.raw/*61.53*/("""
                                                """),format.raw/*62.49*/("""<form class="row g-3" action=""""),_display_(/*62.80*/routes/*62.86*/.OAuthController.postLogin()),format.raw/*62.114*/("""" id="form-login" method="post" autocomplete="off">
                                                    <div class="col-12">
                                                        <h4 class="dangnhap">"""),_display_(/*64.79*/Messages("login.login")),format.raw/*64.102*/("""</h4>
                                                    </div>

                                                    <div class="col-12">
                                                        <input type="hidden" name="loginChallenge" value=""""),_display_(/*68.108*/map/*68.111*/.get("loginChallenge")),format.raw/*68.133*/("""">
                                                        <input type="hidden" name="projectID" value=""""),_display_(/*69.103*/map/*69.106*/.get("projectID")),format.raw/*69.123*/("""">
                                                        <input type="hidden" name="appKey" value=""""),_display_(/*70.100*/map/*70.103*/.get("appKey")),format.raw/*70.117*/("""">
                                                        <input type="hidden" name="appSecret" value=""""),_display_(/*71.103*/map/*71.106*/.get("appSecret")),format.raw/*71.123*/("""">
                                                    </div>

                                                    <div class="input-group">
                                                        <a class="input-group-text"><i class='bx bx-user'></i></a>
                                                        <input type="text" id="inputEmail" name="username" class="form-control">
                                                    </div>

                                                    <div class="col-12">
                                                        <div class="input-group" id="show_hide_password">
                                                            <a id="iconHidePass" onclick="showPassword()" class="input-group-text"><i class='bx bx-hide'></i></a>
                                                            <input type="password" name="password" class="form-control border-end-0" id="inputChoosePassword">

                                                        </div>
                                                    </div>
                                                    <div class="col-md-12">
                                                        <hr>
                                                    </div>

                                                    <div class="col-12">
                                                        <div class="d-grid">
                                                            <button type="submit" id="loginButton" class="btn btn-danger">"""),_display_(/*92.124*/Messages("btnComfirm")),format.raw/*92.146*/("""</button>
                                                        </div>
                                                        <div class="d-grid mt-3">
                                                            <p style="text-align: center">"""),_display_(/*95.92*/Messages("Quay lại ")),format.raw/*95.113*/("""<a href=""""),_display_(/*95.123*/routes/*95.129*/.LandingPageController.home()),format.raw/*95.158*/("""" style="font-weight: bold">"""),_display_(/*95.187*/Messages("Trang chủ")),format.raw/*95.208*/("""</a></p>
                                                        </div>
                                                    </div>

                                                </form>
                                            """)))}),format.raw/*100.46*/("""

                                        """),format.raw/*102.41*/("""</div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>

    <script type="text/javascript" src=""""),_display_(/*115.42*/routes/*115.48*/.JsController.jsMessages()),format.raw/*115.74*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*116.42*/routes/*116.48*/.JsController.javascriptRoutes),format.raw/*116.78*/(""""></script>
    <script src=""""),_display_(/*117.19*/routes/*117.25*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*117.79*/("""" type="text/javascript"></script>

    <script type="text/javascript" src=""""),_display_(/*119.42*/routes/*119.48*/.Assets.versioned("assets/js/jquery.min.js")),format.raw/*119.92*/(""""></script>
        <!--notification js -->
    <script src=""""),_display_(/*121.19*/routes/*121.25*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*121.92*/(""""></script>
    <script src=""""),_display_(/*122.19*/routes/*122.25*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*122.98*/(""""></script>
    <script src=""""),_display_(/*123.19*/routes/*123.25*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*123.107*/(""""></script>

    <script src=""""),_display_(/*125.19*/routes/*125.25*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*125.77*/("""" type="text/javascript"></script>
    <script type="text/javascript">
            $(document).ready(function()"""),format.raw/*127.41*/("""{"""),format.raw/*127.42*/("""
                """),_display_(/*128.18*/if(flash.containsKey("success"))/*128.50*/ {_display_(Seq[Any](format.raw/*128.52*/("""
                """),format.raw/*129.17*/("""showNotification('success','"""),_display_(/*129.46*/flash/*129.51*/.get("success")),format.raw/*129.66*/("""');
                """)))}),format.raw/*130.18*/("""
                """),_display_(/*131.18*/if(flash.containsKey("failed"))/*131.49*/ {_display_(Seq[Any](format.raw/*131.51*/("""
                """),format.raw/*132.17*/("""showNotification('danger','"""),_display_(/*132.45*/flash/*132.50*/.get("failed")),format.raw/*132.64*/("""');
                """)))}),format.raw/*133.18*/("""
            """),format.raw/*134.13*/("""}"""),format.raw/*134.14*/(""");
    </script>
    <script src=""""),_display_(/*136.19*/routes/*136.25*/.Assets.versioned("javascripts/plugins/moment.min.js")),format.raw/*136.79*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*137.19*/routes/*137.25*/.Assets.versioned("assets/js/chosen.jquery.min.js")),format.raw/*137.76*/(""""></script>

    <script src=""""),_display_(/*139.19*/routes/*139.25*/.Assets.versioned("javascripts/views/login/login.js")),format.raw/*139.78*/("""" type="text/javascript"></script>
    <script>
            $("body").on("submit", "form", function() """),format.raw/*141.55*/("""{"""),format.raw/*141.56*/("""
                """),format.raw/*142.17*/("""$(this).submit(function() """),format.raw/*142.43*/("""{"""),format.raw/*142.44*/("""
                    """),format.raw/*143.21*/("""return false;
                """),format.raw/*144.17*/("""}"""),format.raw/*144.18*/(""");
                return true;
            """),format.raw/*146.13*/("""}"""),format.raw/*146.14*/(""");
    </script>

</html>"""))
      }
    }
  }

  def render(map:Map[String, String]): play.twirl.api.HtmlFormat.Appendable = apply(map)

  def f:((Map[String, String]) => play.twirl.api.HtmlFormat.Appendable) = (map) => apply(map)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:48 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/oauth/Login.scala.html
                  HASH: 087063c463f56657c3126ea1bdf3773873ce9e7a
                  MATRIX: 657->1|1012->40|1133->66|1161->68|1353->234|1390->251|1475->309|1490->315|1547->351|1779->556|1794->562|1859->606|1964->684|1979->690|2049->739|2117->780|2132->786|2192->825|2260->866|2275->872|2337->913|2423->972|2438->978|2529->1047|2583->1074|2598->1080|2673->1134|2790->1224|2805->1230|2875->1278|3508->1884|3523->1890|3573->1919|3658->1977|3673->1983|3737->2025|3925->2186|3940->2192|4004->2235|4355->2559|4416->2611|4455->2612|4532->2661|4582->2759|4612->2868|4641->2931|4722->2984|4988->3223|5000->3226|5039->3244|5158->3336|5170->3339|5212->3359|5523->3652|5536->3657|5575->3658|5652->3707|5710->3738|5725->3744|5775->3772|6005->3975|6050->3998|6324->4244|6337->4247|6381->4269|6514->4374|6527->4377|6566->4394|6696->4496|6709->4499|6745->4513|6878->4618|6891->4621|6930->4638|8496->6176|8540->6198|8813->6444|8856->6465|8894->6475|8910->6481|8961->6510|9018->6539|9061->6560|9326->6793|9397->6835|9720->7130|9736->7136|9784->7162|9865->7215|9881->7221|9933->7251|9991->7281|10007->7287|10083->7341|10188->7418|10204->7424|10270->7468|10360->7530|10376->7536|10465->7603|10523->7633|10539->7639|10634->7712|10692->7742|10708->7748|10813->7830|10872->7861|10888->7867|10962->7919|11102->8030|11132->8031|11178->8049|11220->8081|11261->8083|11307->8100|11364->8129|11379->8134|11416->8149|11469->8170|11515->8188|11556->8219|11597->8221|11643->8238|11699->8266|11714->8271|11750->8285|11803->8306|11845->8319|11875->8320|11938->8355|11954->8361|12030->8415|12111->8468|12127->8474|12200->8525|12259->8556|12275->8562|12350->8615|12481->8717|12511->8718|12557->8735|12612->8761|12642->8762|12692->8783|12751->8813|12781->8814|12854->8858|12884->8859
                  LINES: 24->1|29->2|34->2|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|50->18|50->18|50->18|51->19|51->19|51->19|53->21|53->21|53->21|55->23|55->23|55->23|57->25|57->25|57->25|68->36|68->36|68->36|69->37|69->37|69->37|73->41|73->41|73->41|79->47|79->47|79->47|80->48|81->49|82->50|83->51|84->52|87->55|87->55|87->55|88->56|88->56|88->56|93->61|93->61|93->61|94->62|94->62|94->62|94->62|96->64|96->64|100->68|100->68|100->68|101->69|101->69|101->69|102->70|102->70|102->70|103->71|103->71|103->71|124->92|124->92|127->95|127->95|127->95|127->95|127->95|127->95|127->95|132->100|134->102|147->115|147->115|147->115|148->116|148->116|148->116|149->117|149->117|149->117|151->119|151->119|151->119|153->121|153->121|153->121|154->122|154->122|154->122|155->123|155->123|155->123|157->125|157->125|157->125|159->127|159->127|160->128|160->128|160->128|161->129|161->129|161->129|161->129|162->130|163->131|163->131|163->131|164->132|164->132|164->132|164->132|165->133|166->134|166->134|168->136|168->136|168->136|169->137|169->137|169->137|171->139|171->139|171->139|173->141|173->141|174->142|174->142|174->142|175->143|176->144|176->144|178->146|178->146
                  -- GENERATED --
              */
          