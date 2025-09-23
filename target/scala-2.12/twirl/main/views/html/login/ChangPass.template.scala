
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

object ChangPass extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*6.13*/Messages("ChangePass")),format.raw/*6.35*/("""</title>
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
  <body class="bg-theme " style="background-image: url("""),_display_(/*23.57*/routes/*23.63*/.Assets.versioned("images/landingPageTelco/banner_1.jpg")),format.raw/*23.120*/(""");    background-repeat: no-repeat;  background-size: 100% 100%;">

    <div class="wrapper">
      <div class="col-12 col-lg-8 mx-auto">
        <div class="logo">
          <a class="navbar-brand mr-lg-5" href=""""),_display_(/*28.50*/routes/*28.56*/.LandingPageController.home()),format.raw/*28.85*/("""">
            <img class="imglogo" src=""""),_display_(/*29.40*/routes/*29.46*/.Assets.versioned("images/landingPageTelco/Logo_Viettel.svg")),format.raw/*29.107*/("""" >
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
                    <p class="texth">"""),_display_(/*41.39*/Messages("Dịch vụ Sim Data truyền tải dữ liệu")),format.raw/*41.86*/("""</p>
                  </div>
                </div>
                <div class="col-lg-5 border-end">
                  <div class="card-body mb-1">
                    <div class="p-6 mt-3">
                      <form class="row g-3" action=""""),_display_(/*47.54*/routes/*47.60*/.Application.authenticate()),format.raw/*47.87*/("""" id="form-login" method="post" autocomplete="off">
                        <div class="col-12" style="text-align: center">
                          <h4 class="hello">"""),_display_(/*49.46*/Messages("Chào mừng bạn!")),format.raw/*49.72*/("""</h4>
                          <h4 class="dangnhap" style="">"""),_display_(/*50.58*/Messages("Đổi mật khẩu")),format.raw/*50.82*/("""</h4>
                          <h4 class="" style="font-weight: 400; font-size: 16px; line-height: 21px; color: #727272;">"""),_display_(/*51.119*/Messages("Để trải nghiệm dịch vụ của chúng tôi")),format.raw/*51.167*/("""</h4>
                        </div>
                        <div class="col-12">
                          <div class="input-group" id="show_hide_password">
                            <a id="iconHidePass" onclick="showPassword()" class="input-group-text"><i class='bx bx-hide'></i></a>
                            <input type="password" name="password" class="form-control" id="inputoldPassword" required maxlength="50" placeholder="Mật khẩu cũ *">
                          </div>
                        </div>
                        <div class="col-12">
                          <div class="input-group" id="show_hide_password">
                            <a id="iconHidenewPass" onclick="showPassword1()" class="input-group-text"><i class='bx bx-hide'></i></a>
                            <input type="password" name="password" class="form-control" id="inputnewPassword" required maxlength="50" placeholder="Mật khẩu mới *">
                          </div>
                        </div>
                        <div class="col-12">
                          <div class="input-group" id="show_hide_password">
                            <a id="iconHideRePass" onclick="showRePassword()" class="input-group-text"><i class='bx bx-hide'></i></a>
                            <input type="password" name="password" class="form-control" id="inputnewRePassword" required maxlength="50" placeholder="Xác nhận mật khẩu mới *">
                          </div>
                        </div>
                      </form>
                    </div>
                    <div class="d-grid" style="margin: 15px 0 34px 0 !important;">
                      <button class="btn btn-dark" type="button" onclick="sendChangPassword()" type="button" style="background: #EE0033;">"""),_display_(/*74.140*/Messages("Xác nhận")),format.raw/*74.160*/("""</button>
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
            <span class="footer-text-4">"""),_display_(/*87.42*/Messages("Copyright Viettel Telecom 2022")),format.raw/*87.84*/("""</span>
          </div>
          <div class="col-md-6" id="center_footer">
            <span class="footer-text-4">"""),_display_(/*90.42*/Messages("Follow us: ")),format.raw/*90.65*/("""</span>
            <a href="https://www.facebook.com/innoway.vn/" class="fa fa-facebook-square" target="_blank" style="font-size: 23px; color: #B1B1B1; "></a>
            <a href="https://twitter.com/VInnoway" class="fa fa-twitter-square" target="_blank" style="font-size: 23px; color: #B1B1B1; margin-left: 10px;"></a>
            <a href="https://www.instagram.com/innoway.vn/" class="fa fa-instagram" target="_blank" style="font-size: 23px; color: #B1B1B1; margin-left: 10px;"></a>
          </div>
        </div>
      </div>
    </div>
  </body>

  <script type="text/javascript" src=""""),_display_(/*100.40*/routes/*100.46*/.JsController.jsMessages()),format.raw/*100.72*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*101.40*/routes/*101.46*/.JsController.javascriptRoutes),format.raw/*101.76*/(""""></script>
  <script src=""""),_display_(/*102.17*/routes/*102.23*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*102.77*/("""" type="text/javascript"></script>

  <script type="text/javascript" src=""""),_display_(/*104.40*/routes/*104.46*/.Assets.versioned("assets/js/jquery.min.js")),format.raw/*104.90*/(""""></script>
    <!--notification js -->
  <script src=""""),_display_(/*106.17*/routes/*106.23*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*106.90*/(""""></script>
  <script src=""""),_display_(/*107.17*/routes/*107.23*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*107.96*/(""""></script>
  <script src=""""),_display_(/*108.17*/routes/*108.23*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*108.105*/(""""></script>

  <script src=""""),_display_(/*110.17*/routes/*110.23*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*110.75*/("""" type="text/javascript"></script>
  <script type="text/javascript">
            $(document).ready(function()"""),format.raw/*112.41*/("""{"""),format.raw/*112.42*/("""
              """),_display_(/*113.16*/if(flash.containsKey("success"))/*113.48*/ {_display_(Seq[Any](format.raw/*113.50*/("""
              """),format.raw/*114.15*/("""showNotification('success','"""),_display_(/*114.44*/flash/*114.49*/.get("success")),format.raw/*114.64*/("""');
              """)))}),format.raw/*115.16*/("""
              """),_display_(/*116.16*/if(flash.containsKey("failed"))/*116.47*/ {_display_(Seq[Any](format.raw/*116.49*/("""
              """),format.raw/*117.15*/("""showNotification('danger','"""),_display_(/*117.43*/flash/*117.48*/.get("failed")),format.raw/*117.62*/("""');
              """)))}),format.raw/*118.16*/("""
            """),format.raw/*119.13*/("""}"""),format.raw/*119.14*/(""");
    </script>
  <script src=""""),_display_(/*121.17*/routes/*121.23*/.Assets.versioned("javascripts/plugins/moment.min.js")),format.raw/*121.77*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*122.17*/routes/*122.23*/.Assets.versioned("assets/js/chosen.jquery.min.js")),format.raw/*122.74*/(""""></script>

  <script src=""""),_display_(/*124.17*/routes/*124.23*/.Assets.versioned("javascripts/views/login/ChangPass.js")),format.raw/*124.80*/("""" type="text/javascript"></script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/login/ChangPass.scala.html
                  HASH: 4a8a529c7be4e749b8c0218f51f46a80d6cbd6fb
                  MATRIX: 1040->0|1218->152|1260->174|1340->228|1354->234|1410->270|1741->574|1756->580|1821->624|1916->692|1931->698|2001->747|2065->784|2080->790|2140->829|2204->866|2219->872|2281->913|2363->968|2378->974|2469->1043|2519->1066|2534->1072|2614->1131|2727->1217|2742->1223|2821->1280|3062->1494|3077->1500|3127->1529|3196->1571|3211->1577|3294->1638|3970->2287|4038->2334|4311->2580|4326->2586|4374->2613|4570->2782|4617->2808|4707->2871|4752->2895|4904->3019|4974->3067|6773->4838|6815->4858|7254->5270|7317->5312|7462->5430|7506->5453|8126->6045|8142->6051|8190->6077|8269->6128|8285->6134|8337->6164|8393->6192|8409->6198|8485->6252|8588->6327|8604->6333|8670->6377|8754->6433|8770->6439|8859->6506|8915->6534|8931->6540|9026->6613|9082->6641|9098->6647|9203->6729|9260->6758|9276->6764|9350->6816|9488->6925|9518->6926|9562->6942|9604->6974|9645->6976|9689->6991|9746->7020|9761->7025|9798->7040|9849->7059|9893->7075|9934->7106|9975->7108|10019->7123|10075->7151|10090->7156|10126->7170|10177->7189|10219->7202|10249->7203|10310->7236|10326->7242|10402->7296|10481->7347|10497->7353|10570->7404|10627->7433|10643->7439|10722->7496
                  LINES: 33->1|38->6|38->6|39->7|39->7|39->7|45->13|45->13|45->13|47->15|47->15|47->15|48->16|48->16|48->16|49->17|49->17|49->17|51->19|51->19|51->19|53->21|53->21|53->21|55->23|55->23|55->23|60->28|60->28|60->28|61->29|61->29|61->29|73->41|73->41|79->47|79->47|79->47|81->49|81->49|82->50|82->50|83->51|83->51|106->74|106->74|119->87|119->87|122->90|122->90|132->100|132->100|132->100|133->101|133->101|133->101|134->102|134->102|134->102|136->104|136->104|136->104|138->106|138->106|138->106|139->107|139->107|139->107|140->108|140->108|140->108|142->110|142->110|142->110|144->112|144->112|145->113|145->113|145->113|146->114|146->114|146->114|146->114|147->115|148->116|148->116|148->116|149->117|149->117|149->117|149->117|150->118|151->119|151->119|153->121|153->121|153->121|154->122|154->122|154->122|156->124|156->124|156->124
                  -- GENERATED --
              */
          