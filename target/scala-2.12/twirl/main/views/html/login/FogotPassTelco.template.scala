
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

object FogotPassTelco extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*6.13*/Messages("Password")),format.raw/*6.33*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*7.46*/routes/*7.52*/.Assets.versioned("images/logo.jpg")),format.raw/*7.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

    <link href=""""),_display_(/*13.18*/routes/*13.24*/.Assets.versioned("assets/css/pace.min.css")),format.raw/*13.68*/("""" rel="stylesheet" />
      <!-- Bootstrap CSS -->
    <link href=""""),_display_(/*15.18*/routes/*15.24*/.Assets.versioned("assets/css/bootstrap.min.css")),format.raw/*15.73*/("""" rel="stylesheet">
    <link href=""""),_display_(/*16.18*/routes/*16.24*/.Assets.versioned("assets/css/app.css")),format.raw/*16.63*/("""" rel="stylesheet">
    <link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("assets/css/icons.css")),format.raw/*17.65*/("""" rel="stylesheet">

    <link rel="stylesheet" href=""""),_display_(/*19.35*/routes/*19.41*/.Assets.versioned("assets/plugins/notifications/css/lobibox.min.css")),format.raw/*19.110*/("""" />

    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("stylesheets/views/login/loginTelco.css")),format.raw/*21.83*/("""" rel="stylesheet">
  </head>
  <body class="bg-theme" style="background-image: url("""),_display_(/*23.56*/routes/*23.62*/.Assets.versioned("images/landingPageTelco/banner_1.jpg")),format.raw/*23.119*/(""")">

    <div class="wrapper">
      <div class="col-12 col-lg-8 mx-auto">
        <div class="logo">
          <div class="navbar-brand mr-lg-5">
            <a class="navbar-brand mr-lg-5" href=""""),_display_(/*29.52*/routes/*29.58*/.LandingPageController.home()),format.raw/*29.87*/("""">
              <img class="imglogo" src=""""),_display_(/*30.42*/routes/*30.48*/.Assets.versioned("images/landingPageTelco/Logo_Viettel.svg")),format.raw/*30.109*/("""" >
            </a>
          </div>
        </div>
      </div>
      <div class="authentication-reset-password d-flex align-items-center justify-content-center">
        <div class="row">
          <div class="col-12 col-lg-8 mx-auto">
            <div class="">
              <div class="row g-0" style="border-radius: 32px;box-shadow: 0 0 30px 0 rgba(129, 137, 152, 0.4);background-color: #ffffff;">
                <div class="col-lg-7" style="background-image: url(/assets/images/landingPageTelco/Rectangle_29.png);  background-repeat: no-repeat;  background-size: 100% 100%;">
                  <div class="text-center1">
                    <p class="texth">"""),_display_(/*42.39*/Messages("Dịch vụ Sim Data truyền tải dữ liệu")),format.raw/*42.86*/("""</p>
                  </div>
                </div>
                <div class="col-lg-5 border-end">
                  <div class="card-body mb-1">
                    <div class="p-6 mt-3">
                      <div class="row g-3" action=""""),_display_(/*48.53*/routes/*48.59*/.Application.authenticate()),format.raw/*48.86*/("""" id="form-login" method="post" autocomplete="off">
                        <div class="col-12" style="text-align: center">
                          <h4 class="hello">"""),_display_(/*50.46*/Messages("Chào mừng bạn!")),format.raw/*50.72*/("""</h4>
                          <h4 class="dangnhap" style="">"""),_display_(/*51.58*/Messages("Quên mật khẩu")),format.raw/*51.83*/("""</h4>
                          <h4 class="" style="font-weight: 400;font-size: 16px; line-height: 21px;color: #727272;">"""),_display_(/*52.117*/Messages("Để trải nghiệm dịch vụ của chúng tôi")),format.raw/*52.165*/("""</h4>
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
                            <input type="password" name="password" class="form-control" id="inputChoosePassword" required maxlength="50" placeholder="Mật khẩu mới *">
                          </div>
                        </div>
                        <div class="col-12">
                          <div class="input-group" id="show_hide_password">
                            <a id="iconHideRePass" onclick="showRePassword()" class="input-group-text"><i class='bx bx-hide'></i></a>
                            <input type="password"  name="passwordRepeat" class="form-control" id="inputChooseRePassword" required maxlength="50" placeholder="Nhập lại mật khẩu mới*">
                          </div>
                        </div>
                        <div class="d-grid">
                          <a id="buttonSmsCodeChangePass" href="javascript:;" onclick="getOtpEmail()" style="font-weight: bold; color: #EA0033;text-align: right;">"""),_display_(/*73.165*/Messages("Gửi OTP")),format.raw/*73.184*/("""</a>
                        </div>
                        <div class="col-12">
                          <div class="input-group">
                            <input type="text" name="otpEmail" class="form-control" id="inputOtpEmail"  placeholder="Nhập mã xác nhận *" oninput="validateNumberInput(this)">
                          </div>
                        </div>
                        <div class="col-12">
                          <h3 class="title-section-3">"""),_display_(/*81.56*/Messages("Khi nhập Đăng ký, bạn đã đồng ý thực hiện mọi giao dịch theo ")),format.raw/*81.129*/("""<a href="/" style="color: #ee0033">"""),_display_(/*81.165*/Messages("Điều kiện sử dụng dịch vụ của chính sách Viettel?")),format.raw/*81.226*/("""</a></h3>
                        </div>
                        <div class="col-12" style="text-align: -webkit-center;">
                          <div class="d-grid" style="width: 50%;">
                            <button type="submit" onclick="sendRegister()" style="background: #EA0033;  border-radius: 8px 8px 8px 0px; color: #FFFFFF" class="btn btn-dark">"""),_display_(/*85.175*/Messages("btnComfirm")),format.raw/*85.197*/("""<span style="margin-left: 4px;">&#8599;</span></button>
                          </div>
                        </div>

                        <div class="col-12 mt-5">
                          <div class="col-12 mt-5">
                            <div class="d-grid">
                              <p>"""),_display_(/*92.35*/Messages("Quý khách đã có tài khoản ?")),format.raw/*92.74*/("""</p>
                            </div>
                            <div class="d-grid">
                              <a href=""""),_display_(/*95.41*/routes/*95.47*/.Application.login()),format.raw/*95.67*/("""" style="font-weight: bold;color: #EA0033;">"""),_display_(/*95.112*/Messages("Đăng nhập tại đây.")),format.raw/*95.142*/("""</a>
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
            <span class="footer-text-4">"""),_display_(/*112.42*/Messages("Copyright Viettel Telecom 2022")),format.raw/*112.84*/("""</span>
          </div>
          <div class="col-md-6" id="center_footer">
            <span class="footer-text-4">"""),_display_(/*115.42*/Messages("Follow us: ")),format.raw/*115.65*/("""</span>
            <a href="https://www.facebook.com/innoway.vn/" class="fa fa-facebook-square" target="_blank" style="font-size: 23px; color: #B1B1B1; "></a>
            <a href="https://twitter.com/VInnoway" class="fa fa-twitter-square" target="_blank" style="font-size: 23px; color: #B1B1B1; margin-left: 10px;"></a>
            <a href="https://www.instagram.com/innoway.vn/" class="fa fa-instagram" target="_blank" style="font-size: 23px; color: #B1B1B1; margin-left: 10px;"></a>
          </div>
        </div>
      </div>
    </div>
  </body>
  <script type="text/javascript" src=""""),_display_(/*124.40*/routes/*124.46*/.JsController.jsMessages()),format.raw/*124.72*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*125.40*/routes/*125.46*/.JsController.javascriptRoutes),format.raw/*125.76*/(""""></script>
  <script src=""""),_display_(/*126.17*/routes/*126.23*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*126.77*/("""" type="text/javascript"></script>

  <script type="text/javascript" src=""""),_display_(/*128.40*/routes/*128.46*/.Assets.versioned("assets/js/jquery.min.js")),format.raw/*128.90*/(""""></script>
    <!--notification js -->
  <script src=""""),_display_(/*130.17*/routes/*130.23*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*130.90*/(""""></script>
  <script src=""""),_display_(/*131.17*/routes/*131.23*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*131.96*/(""""></script>
  <script src=""""),_display_(/*132.17*/routes/*132.23*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*132.105*/(""""></script>

  <script src=""""),_display_(/*134.17*/routes/*134.23*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*134.75*/("""" type="text/javascript"></script>
  <script type="text/javascript">
            $(document).ready(function()"""),format.raw/*136.41*/("""{"""),format.raw/*136.42*/("""
              """),_display_(/*137.16*/if(flash.containsKey("success"))/*137.48*/ {_display_(Seq[Any](format.raw/*137.50*/("""
              """),format.raw/*138.15*/("""showNotification('success','"""),_display_(/*138.44*/flash/*138.49*/.get("success")),format.raw/*138.64*/("""');
              """)))}),format.raw/*139.16*/("""
              """),_display_(/*140.16*/if(flash.containsKey("failed"))/*140.47*/ {_display_(Seq[Any](format.raw/*140.49*/("""
              """),format.raw/*141.15*/("""showNotification('danger','"""),_display_(/*141.43*/flash/*141.48*/.get("failed")),format.raw/*141.62*/("""');
              """)))}),format.raw/*142.16*/("""
            """),format.raw/*143.13*/("""}"""),format.raw/*143.14*/(""");
  </script>
  <script>
        function validateNumberInput(inputElement) """),format.raw/*146.52*/("""{"""),format.raw/*146.53*/("""
          """),format.raw/*147.11*/("""var inputValue = inputElement.value;

          var numericValue = inputValue.replace(/[^0-9]/g, '');

          if (inputValue !== numericValue) """),format.raw/*151.44*/("""{"""),format.raw/*151.45*/("""
            """),format.raw/*152.13*/("""inputElement.value = numericValue;
          """),format.raw/*153.11*/("""}"""),format.raw/*153.12*/("""
        """),format.raw/*154.9*/("""}"""),format.raw/*154.10*/("""
  """),format.raw/*155.3*/("""</script>
  <script src=""""),_display_(/*156.17*/routes/*156.23*/.Assets.versioned("javascripts/plugins/moment.min.js")),format.raw/*156.77*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*157.17*/routes/*157.23*/.Assets.versioned("assets/js/chosen.jquery.min.js")),format.raw/*157.74*/(""""></script>

  <script src=""""),_display_(/*159.17*/routes/*159.23*/.Assets.versioned("javascripts/views/login/fogotPass.js")),format.raw/*159.80*/("""" type="text/javascript"></script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/login/FogotPassTelco.scala.html
                  HASH: 39c4715e1f2e818b2f2280a49c16b0cf369cec12
                  MATRIX: 1045->0|1223->152|1263->172|1343->226|1357->232|1413->268|1744->572|1759->578|1824->622|1919->690|1934->696|2004->745|2068->782|2083->788|2143->827|2207->864|2222->870|2284->911|2366->966|2381->972|2472->1041|2522->1064|2537->1070|2617->1129|2729->1214|2744->1220|2823->1277|3048->1475|3063->1481|3113->1510|3184->1554|3199->1560|3282->1621|3977->2289|4045->2336|4317->2581|4332->2587|4380->2614|4576->2783|4623->2809|4713->2872|4759->2897|4909->3019|4979->3067|6637->4697|6678->4716|7176->5187|7271->5260|7335->5296|7418->5357|7809->5720|7853->5742|8186->6048|8246->6087|8402->6216|8417->6222|8458->6242|8531->6287|8583->6317|9146->6852|9210->6894|9356->7012|9401->7035|10020->7626|10036->7632|10084->7658|10163->7709|10179->7715|10231->7745|10287->7773|10303->7779|10379->7833|10482->7908|10498->7914|10564->7958|10648->8014|10664->8020|10753->8087|10809->8115|10825->8121|10920->8194|10976->8222|10992->8228|11097->8310|11154->8339|11170->8345|11244->8397|11382->8506|11412->8507|11456->8523|11498->8555|11539->8557|11583->8572|11640->8601|11655->8606|11692->8621|11743->8640|11787->8656|11828->8687|11869->8689|11913->8704|11969->8732|11984->8737|12020->8751|12071->8770|12113->8783|12143->8784|12249->8861|12279->8862|12319->8873|12494->9019|12524->9020|12566->9033|12640->9078|12670->9079|12707->9088|12737->9089|12768->9092|12822->9118|12838->9124|12914->9178|12993->9229|13009->9235|13082->9286|13139->9315|13155->9321|13234->9378
                  LINES: 33->1|38->6|38->6|39->7|39->7|39->7|45->13|45->13|45->13|47->15|47->15|47->15|48->16|48->16|48->16|49->17|49->17|49->17|51->19|51->19|51->19|53->21|53->21|53->21|55->23|55->23|55->23|61->29|61->29|61->29|62->30|62->30|62->30|74->42|74->42|80->48|80->48|80->48|82->50|82->50|83->51|83->51|84->52|84->52|105->73|105->73|113->81|113->81|113->81|113->81|117->85|117->85|124->92|124->92|127->95|127->95|127->95|127->95|127->95|144->112|144->112|147->115|147->115|156->124|156->124|156->124|157->125|157->125|157->125|158->126|158->126|158->126|160->128|160->128|160->128|162->130|162->130|162->130|163->131|163->131|163->131|164->132|164->132|164->132|166->134|166->134|166->134|168->136|168->136|169->137|169->137|169->137|170->138|170->138|170->138|170->138|171->139|172->140|172->140|172->140|173->141|173->141|173->141|173->141|174->142|175->143|175->143|178->146|178->146|179->147|183->151|183->151|184->152|185->153|185->153|186->154|186->154|187->155|188->156|188->156|188->156|189->157|189->157|189->157|191->159|191->159|191->159
                  -- GENERATED --
              */
          