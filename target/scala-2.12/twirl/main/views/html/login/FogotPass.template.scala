
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

object FogotPass extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>"""),_display_(/*6.17*/Messages("Password")),format.raw/*6.37*/("""</title>
        <link rel="icon" type="image/png" href=""""),_display_(/*7.50*/routes/*7.56*/.Assets.versioned("images/logo.jpg")),format.raw/*7.92*/("""">

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        <link href=""""),_display_(/*12.22*/routes/*12.28*/.Assets.versioned("assets/css/pace.min.css")),format.raw/*12.72*/("""" rel="stylesheet" />
            <!-- Bootstrap CSS -->
        <link href=""""),_display_(/*14.22*/routes/*14.28*/.Assets.versioned("assets/css/bootstrap.min.css")),format.raw/*14.77*/("""" rel="stylesheet">
        <link href=""""),_display_(/*15.22*/routes/*15.28*/.Assets.versioned("assets/css/app.css")),format.raw/*15.67*/("""" rel="stylesheet">
        <link href=""""),_display_(/*16.22*/routes/*16.28*/.Assets.versioned("assets/css/icons.css")),format.raw/*16.69*/("""" rel="stylesheet">

        <link rel="stylesheet" href=""""),_display_(/*18.39*/routes/*18.45*/.Assets.versioned("assets/plugins/notifications/css/lobibox.min.css")),format.raw/*18.114*/("""" />

        <link href=""""),_display_(/*20.22*/routes/*20.28*/.Assets.versioned("stylesheets/views/login/login.css")),format.raw/*20.82*/("""" rel="stylesheet">
    </head>
    <body class="bg-theme " style="background-image: url("""),_display_(/*22.59*/routes/*22.65*/.Assets.versioned("images/login/background.png")),format.raw/*22.113*/(""")">
        <div class="wrapper">
            <div class="authentication-reset-password d-flex align-items-center justify-content-center">
                <div class="row">
                    <div class="col-12 col-lg-8 mx-auto">
                        <div class="">
                            <div class="row g-0" style="padding: 30px;border-radius: 32px;box-shadow: 0 0 30px 0 rgba(129, 137, 152, 0.4);background-color: #ffffff;">
                                <div class="col-lg-7">
                                    <div class="text-center">
                                        <a href=""""),_display_(/*31.51*/routes/*31.57*/.LandingPageController.home()),format.raw/*31.86*/("""">
                                            <img src=""""),_display_(/*32.56*/routes/*32.62*/.Assets.versioned("images/login/logo.svg")),format.raw/*32.104*/("""" height="80%" alt="" />
                                        </a>
                                    </div>
                                    <img src=""""),_display_(/*35.48*/routes/*35.54*/.Assets.versioned("images/login/frame.png")),format.raw/*35.97*/("""" class="card-img login-img h-80 mt-5" alt="...">
                                </div>
                                <div class="col-lg-5 border-end">
                                    <div class="card-body">
                                        <div class="p-6 mt-3">
"""),format.raw/*40.164*/("""
                                            """),format.raw/*41.45*/("""<div class="row g-3" >
                                                <div class="col-12">
                                                    <h4 class="dangnhap">"""),_display_(/*43.75*/Messages("forgot.fogetPass")),format.raw/*43.103*/("""</h4>
                                                </div>
                                                <div class="col-12">
                                                    <label for="inputUsername" class="form-label" >"""),_display_(/*46.101*/Messages("login.username")),format.raw/*46.127*/("""</label>
                                                    <input type="text" name="username" id="inputUsername" class="form-control" maxlength="50" required>
                                                </div>
                                                <div class="col-12">
                                                    <label for="inputChoosePassword" class="form-label">"""),_display_(/*50.106*/Messages("forgot.Password")),format.raw/*50.133*/("""</label>
                                                    <div class="input-group" id="show_hide_password">
                                                        <input type="password" name="password" class="form-control border-end-0" id="inputChoosePassword" maxlength="50" required>
                                                        <a id="iconHidePass" onclick="showPassword()" class="input-group-text"><i class='bx bx-hide'></i></a>
                                                    </div>
                                                </div>
                                                <div class="col-12">
                                                    <label for="inputRePassword" class="form-label">"""),_display_(/*57.102*/Messages("forgot.RePassword")),format.raw/*57.131*/("""</label>
                                                    <div class="input-group" id="show_hide_password">
                                                        <input type="password" name="passwordRepeat" class="form-control border-end-0" id="inputChooseRePassword" required>
                                                        <a id="iconHideRePass" onclick="showRePassword()" class="input-group-text"><i class='bx bx-hide'></i></a>
                                                    </div>
                                                </div>
                                                <div class="col-12">
                                                    <label for="inputRePassword" class="form-label">"""),_display_(/*64.102*/Messages("forgot.sendCode")),format.raw/*64.129*/("""</label>
                                                    <div class="input-group" id="show_hide_password">
                                                        <input type="number" name="code" class="form-control border-end-0" required>
                                                        <a id="buttonSmsCodeChangePass" href="javascript:;" onclick="receiveCode()" class="input-group-text">"""),_display_(/*67.159*/Messages("forgot.code")),format.raw/*67.182*/("""</a>
                                                    </div>
                                                </div>
                                                <div class="col-12">
                                                    <hr>
                                                </div>
                                                <div class="col-12">
                                                    <div class="d-grid">
                                                        <button type="submit" class="btn btn-dark">"""),_display_(/*75.101*/Messages("btnComfirm")),format.raw/*75.123*/("""</button>
                                                    </div>
                                                </div>

                                                <div class="col-12 mt-5">
                                                    <div class="d-grid text-center">
                                                        <p>"""),_display_(/*81.61*/Messages("Bạn đã có tài khoản? ")),format.raw/*81.94*/("""<a href=""""),_display_(/*81.104*/routes/*81.110*/.Application.login()),format.raw/*81.130*/("""" style="font-weight: bold">"""),_display_(/*81.159*/Messages("Đăng nhập tại đây!")),format.raw/*81.189*/("""</a></p>
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

        """),_display_(/*96.10*/views/*96.15*/.html.Loading()),format.raw/*96.30*/("""

    """),format.raw/*98.5*/("""</body>

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

    <script src=""""),_display_(/*124.19*/routes/*124.25*/.Assets.versioned("javascripts/views/login/fogotPass.js")),format.raw/*124.82*/("""" type="text/javascript"></script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/login/FogotPass.scala.html
                  HASH: bf19862a8c9d0007e8c0829b8e1f684a9bfe6f9f
                  MATRIX: 1040->0|1232->166|1272->186|1356->244|1370->250|1426->286|1658->491|1673->497|1738->541|1843->619|1858->625|1928->674|1996->715|2011->721|2071->760|2139->801|2154->807|2216->848|2302->907|2317->913|2408->982|2462->1009|2477->1015|2552->1069|2669->1159|2684->1165|2754->1213|3385->1817|3400->1823|3450->1852|3535->1910|3550->1916|3614->1958|3801->2118|3816->2124|3880->2167|4187->2608|4260->2653|4453->2819|4503->2847|4761->3077|4809->3103|5227->3493|5276->3520|6036->4252|6087->4281|6844->5010|6893->5037|7323->5439|7368->5462|7938->6004|7982->6026|8353->6370|8407->6403|8445->6413|8461->6419|8503->6439|8560->6468|8612->6498|9103->6962|9117->6967|9153->6982|9186->6988|9264->7038|9280->7044|9328->7070|9409->7123|9425->7129|9477->7159|9535->7189|9551->7195|9627->7249|9732->7326|9748->7332|9814->7376|9904->7438|9920->7444|10009->7511|10067->7541|10083->7547|10178->7620|10236->7650|10252->7656|10357->7738|10416->7769|10432->7775|10506->7827|10646->7938|10676->7939|10722->7957|10764->7989|10805->7991|10851->8008|10908->8037|10923->8042|10960->8057|11013->8078|11059->8096|11100->8127|11141->8129|11187->8146|11243->8174|11258->8179|11294->8193|11347->8214|11389->8227|11419->8228|11482->8263|11498->8269|11574->8323|11655->8376|11671->8382|11744->8433|11803->8464|11819->8470|11898->8527
                  LINES: 33->1|38->6|38->6|39->7|39->7|39->7|44->12|44->12|44->12|46->14|46->14|46->14|47->15|47->15|47->15|48->16|48->16|48->16|50->18|50->18|50->18|52->20|52->20|52->20|54->22|54->22|54->22|63->31|63->31|63->31|64->32|64->32|64->32|67->35|67->35|67->35|72->40|73->41|75->43|75->43|78->46|78->46|82->50|82->50|89->57|89->57|96->64|96->64|99->67|99->67|107->75|107->75|113->81|113->81|113->81|113->81|113->81|113->81|113->81|128->96|128->96|128->96|130->98|132->100|132->100|132->100|133->101|133->101|133->101|134->102|134->102|134->102|136->104|136->104|136->104|138->106|138->106|138->106|139->107|139->107|139->107|140->108|140->108|140->108|142->110|142->110|142->110|144->112|144->112|145->113|145->113|145->113|146->114|146->114|146->114|146->114|147->115|148->116|148->116|148->116|149->117|149->117|149->117|149->117|150->118|151->119|151->119|153->121|153->121|153->121|154->122|154->122|154->122|156->124|156->124|156->124
                  -- GENERATED --
              */
          