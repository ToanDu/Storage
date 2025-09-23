
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

object Login extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

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
                                        <a href=""""),_display_(/*33.51*/routes/*33.57*/.LandingPageController.home()),format.raw/*33.86*/("""">
                                            <img src=""""),_display_(/*34.56*/routes/*34.62*/.Assets.versioned("images/landingPageTelco/viettel.svg")),format.raw/*34.118*/("""" height="80%" alt="" />
                                        </a>
                                    </div>

                                    <img src=""""),_display_(/*38.48*/routes/*38.54*/.Assets.versioned("images/login/frame.png")),format.raw/*38.97*/("""" class="card-img login-img h-80 mt-5" alt="...">
                                </div>
                                <div class="col-lg-5 border-end">
                                    <div class="card-body mb-1">
                                        <div class="p-6 mt-3">
                                            <form class="row g-3" action=""""),_display_(/*43.76*/routes/*43.82*/.Application.authenticate()),format.raw/*43.109*/("""" id="form-login" method="post" autocomplete="off">
                                                <div class="col-12">
                                                    <h4 class="dangnhap" style="">"""),_display_(/*45.84*/Messages("login.login")),format.raw/*45.107*/("""</h4>
                                                </div>
                                                <div class="col-12">
                                                    """),format.raw/*48.142*/("""
                                                    """),format.raw/*49.53*/("""<div class="input-group">
                                                        <a class="input-group-text"><i class='bx bx-user'></i></a>
                                                        <input type="text" id="inputEmail" name="username" class="form-control" maxlength="50">
                                                    </div>

                                                </div>
                                                <div class="col-12">
                                                    """),format.raw/*56.144*/("""
                                                    """),format.raw/*57.53*/("""<div class="input-group" id="show_hide_password">
                                                        <a id="iconHidePass" onclick="showPassword()" class="input-group-text"><i class='bx bx-hide'></i></a>
                                                        <input type="password" name="password" class="form-control" id="inputChoosePassword" maxlength="50">
                                                    </div>
                                                </div>


                                                <div class="col-12">
                                                    <div class="d-grid">
                                                        <button type="submit" id="loginButton" style="background-color: #B5B6B7; color: #FFFFFF" class="btn">"""),_display_(/*66.159*/Messages("btnComfirm")),format.raw/*66.181*/("""</button>
                                                    </div>
                                                    <div class="d-grid mt-3">
                                                        <p style="text-align: center">"""),_display_(/*69.88*/Messages("Quay lại ")),format.raw/*69.109*/("""<a href=""""),_display_(/*69.119*/routes/*69.125*/.LandingPageController.home()),format.raw/*69.154*/("""" style="font-weight: bold">"""),_display_(/*69.183*/Messages("Trang chủ")),format.raw/*69.204*/("""</a></p>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="p-6" style="margin-top: 100px">
                                            <div class="col-12 mt-5">
                                                <div class="d-grid " >
                                                    <p style="margin-bottom: 0.5rem;">"""),_display_(/*77.88*/Messages("Bạn chưa có tài khoản? ")),format.raw/*77.123*/("""<a href=""""),_display_(/*77.133*/routes/*77.139*/.Application.register()),format.raw/*77.162*/("""" style="font-weight: bold">"""),_display_(/*77.191*/Messages("Đăng kí tại đây")),format.raw/*77.218*/("""</a></p>
                                                </div>
                                                <div class="d-grid ">
                                                    <p>"""),_display_(/*80.57*/Messages("Bạn quên mật khẩu? ")),format.raw/*80.88*/("""<a href=""""),_display_(/*80.98*/routes/*80.104*/.Application.forgotPassPage()),format.raw/*80.133*/("""" style="font-weight: bold">"""),_display_(/*80.162*/Messages("Thay đổi mật khẩu tại đây")),format.raw/*80.199*/("""</a></p>
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

    <script type="text/javascript" src=""""),_display_(/*96.42*/routes/*96.48*/.JsController.jsMessages()),format.raw/*96.74*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*97.42*/routes/*97.48*/.JsController.javascriptRoutes),format.raw/*97.78*/(""""></script>
    <script src=""""),_display_(/*98.19*/routes/*98.25*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*98.79*/("""" type="text/javascript"></script>

    <script type="text/javascript" src=""""),_display_(/*100.42*/routes/*100.48*/.Assets.versioned("assets/js/jquery.min.js")),format.raw/*100.92*/(""""></script>
        <!--notification js -->
    <script src=""""),_display_(/*102.19*/routes/*102.25*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*102.92*/(""""></script>
    <script src=""""),_display_(/*103.19*/routes/*103.25*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*103.98*/(""""></script>
    <script src=""""),_display_(/*104.19*/routes/*104.25*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*104.107*/(""""></script>

    <script src=""""),_display_(/*106.19*/routes/*106.25*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*106.77*/("""" type="text/javascript"></script>
    <script type="text/javascript">
            $(document).ready(function()"""),format.raw/*108.41*/("""{"""),format.raw/*108.42*/("""
                """),_display_(/*109.18*/if(flash.containsKey("success"))/*109.50*/ {_display_(Seq[Any](format.raw/*109.52*/("""
                """),format.raw/*110.17*/("""showNotification('success','"""),_display_(/*110.46*/flash/*110.51*/.get("success")),format.raw/*110.66*/("""');
                """)))}),format.raw/*111.18*/("""
                """),_display_(/*112.18*/if(flash.containsKey("failed"))/*112.49*/ {_display_(Seq[Any](format.raw/*112.51*/("""
                """),format.raw/*113.17*/("""showNotification('danger','"""),_display_(/*113.45*/flash/*113.50*/.get("failed")),format.raw/*113.64*/("""');
                """)))}),format.raw/*114.18*/("""
            """),format.raw/*115.13*/("""}"""),format.raw/*115.14*/(""");
    </script>
    <script src=""""),_display_(/*117.19*/routes/*117.25*/.Assets.versioned("javascripts/plugins/moment.min.js")),format.raw/*117.79*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*118.19*/routes/*118.25*/.Assets.versioned("assets/js/chosen.jquery.min.js")),format.raw/*118.76*/(""""></script>

    <script src=""""),_display_(/*120.19*/routes/*120.25*/.Assets.versioned("javascripts/views/login/login.js")),format.raw/*120.78*/("""" type="text/javascript"></script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/login/Login.scala.html
                  HASH: d30bc1673a1c806e68c20f0659e07fab57cee773
                  MATRIX: 1036->0|1228->166|1265->183|1349->241|1363->247|1419->283|1651->488|1666->494|1731->538|1836->616|1851->622|1921->671|1989->712|2004->718|2064->757|2132->798|2147->804|2209->845|2295->904|2310->910|2401->979|2455->1006|2470->1012|2545->1066|2662->1156|2677->1162|2747->1210|3380->1816|3395->1822|3445->1851|3530->1909|3545->1915|3623->1971|3811->2132|3826->2138|3890->2181|4275->2539|4290->2545|4339->2572|4570->2776|4615->2799|4826->3070|4907->3123|5457->3735|5538->3788|6347->4569|6391->4591|6652->4825|6695->4846|6733->4856|6749->4862|6800->4891|6857->4920|6900->4941|7461->5475|7518->5510|7556->5520|7572->5526|7617->5549|7674->5578|7723->5605|7940->5795|7992->5826|8029->5836|8045->5842|8096->5871|8153->5900|8212->5937|8689->6387|8704->6393|8751->6419|8831->6472|8846->6478|8897->6508|8954->6538|8969->6544|9044->6598|9149->6675|9165->6681|9231->6725|9321->6787|9337->6793|9426->6860|9484->6890|9500->6896|9595->6969|9653->6999|9669->7005|9774->7087|9833->7118|9849->7124|9923->7176|10063->7287|10093->7288|10139->7306|10181->7338|10222->7340|10268->7357|10325->7386|10340->7391|10377->7406|10430->7427|10476->7445|10517->7476|10558->7478|10604->7495|10660->7523|10675->7528|10711->7542|10764->7563|10806->7576|10836->7577|10899->7612|10915->7618|10991->7672|11072->7725|11088->7731|11161->7782|11220->7813|11236->7819|11311->7872
                  LINES: 33->1|38->6|38->6|39->7|39->7|39->7|44->12|44->12|44->12|46->14|46->14|46->14|47->15|47->15|47->15|48->16|48->16|48->16|50->18|50->18|50->18|52->20|52->20|52->20|54->22|54->22|54->22|65->33|65->33|65->33|66->34|66->34|66->34|70->38|70->38|70->38|75->43|75->43|75->43|77->45|77->45|80->48|81->49|88->56|89->57|98->66|98->66|101->69|101->69|101->69|101->69|101->69|101->69|101->69|109->77|109->77|109->77|109->77|109->77|109->77|109->77|112->80|112->80|112->80|112->80|112->80|112->80|112->80|128->96|128->96|128->96|129->97|129->97|129->97|130->98|130->98|130->98|132->100|132->100|132->100|134->102|134->102|134->102|135->103|135->103|135->103|136->104|136->104|136->104|138->106|138->106|138->106|140->108|140->108|141->109|141->109|141->109|142->110|142->110|142->110|142->110|143->111|144->112|144->112|144->112|145->113|145->113|145->113|145->113|146->114|147->115|147->115|149->117|149->117|149->117|150->118|150->118|150->118|152->120|152->120|152->120
                  -- GENERATED --
              */
          