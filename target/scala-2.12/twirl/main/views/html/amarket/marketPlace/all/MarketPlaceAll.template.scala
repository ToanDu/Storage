
package views.html.amarket.marketPlace.all

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
/*1.2*/import vn.m2m.common.models.User

object MarketPlaceAll extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="icon" type="image/png" href=""""),_display_(/*7.50*/routes/*7.56*/.Assets.versioned("images/logo.jpg")),format.raw/*7.92*/("""">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>Market Place</title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <link href='"""),_display_(/*14.22*/routes/*14.28*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*14.77*/("""' type='text/css'>
        <link href=""""),_display_(/*15.22*/routes/*15.28*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*15.103*/("""" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">

        <link href=""""),_display_(/*18.22*/routes/*18.28*/.Assets.versioned("assets/css/bootstrap.min.css")),format.raw/*18.77*/("""" rel="stylesheet">

        <link href=""""),_display_(/*20.22*/routes/*20.28*/.Assets.versioned("stylesheets/landingPage/argon-design-system.css?v=1.2.2")),format.raw/*20.104*/("""" rel="stylesheet" />
        <link href=""""),_display_(/*21.22*/routes/*21.28*/.Assets.versioned("assets/plugins/notifications/css/lobibox.min.css")),format.raw/*21.97*/("""" rel="stylesheet" />
        <link href=""""),_display_(/*22.22*/routes/*22.28*/.Assets.versioned("assets/css/icons.css")),format.raw/*22.69*/("""" rel="stylesheet">

        <link href=""""),_display_(/*24.22*/routes/*24.28*/.Assets.versioned("stylesheets/views/market/landingMarket.css")),format.raw/*24.91*/("""" rel="stylesheet" />
        <link href=""""),_display_(/*25.22*/routes/*25.28*/.Assets.versioned("stylesheets/views/market/MarketPlace.css")),format.raw/*25.89*/("""" rel="stylesheet"/>

    </head>
    <body>
        """),_display_(/*29.10*/views/*29.15*/.html.amarket.marketPlace.MarketPlace_navbar(currentUser)),format.raw/*29.72*/("""
        """),format.raw/*30.9*/("""<div class="section section-features" style="margin-top: 5rem!important; display: flex;">
            <div class="container">
                <div class="wrapper">
                    <div class="col-md-12">

                        <div class="row" style="background-color: #EE0033; border-radius: 15px;">
                            <img src=""""),_display_(/*36.40*/routes/*36.46*/.Assets.versioned("images/market/banner.png")),format.raw/*36.91*/("""" class="card-img cursor-pointer img-banner" alt="..." style="padding: 0px;">
                            <div class="page-header">
                                <div class="container shape-container d-flex align-items-center">
                                    <div class="col px-0">
                                        <div class="row align-items-center justify-content-center">
                                            <div class="col-lg-11">
                                                <span class="giai-phap-iot" style="color: white">"""),_display_(/*42.99*/Messages("Giải pháp IoT")),format.raw/*42.124*/("""</span><br>
                                                <span class="header-content-market" style="color: white">"""),_display_(/*43.107*/Messages("Các giải pháp Iot thông minh cho doanh nghiệp và hộ gia đình")),format.raw/*43.179*/("""</span>
                                                <div class="col-lg-9" style="padding-left: 0px;">
                                                    <div class="inner-addon left-addon mt-3 mb-3">
                                                        <input id="searchProduct" class="form-control inputSearch" style="font-size: 1.5rem;" type="text" placeholder=""""),_display_(/*46.169*/Messages("Tìm kiếm theo tên thiết bị, giải pháp")),format.raw/*46.218*/("""" maxlength="50">
                                                        <i class="glyphicon bx bx-search"></i>
                                                        <button class="btn btn-danger cursor-pointer search-button" onclick="getListDevice()">"""),_display_(/*48.144*/Messages("Tìm kiếm")),format.raw/*48.164*/("""</button>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row mt-3">
                            <div class="col-md-12" style="padding: 0px;">
                                <div class="col-md-12" style="background-color: white; display: block;">
                                    <span class="text-all-device-1">"""),_display_(/*62.70*/Messages("Thiết bị")),format.raw/*62.90*/("""</span><br>
                                    <div class="clearfix">
                                        <p class="mb-0 float-start" style="margin-top: 0.55rem;">
                                            <span class="text-darker text-all-device-2">"""),_display_(/*65.90*/Messages("Tất cả các thiết bị IoT")),format.raw/*65.125*/("""</span>
                                        </p>
                                        <div class="mb-0 float-end" id="listGroupDevice">
                                            """),format.raw/*68.96*/("""
                                        """),format.raw/*69.41*/("""</div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12 mt-3">
                                <div class="row" id="girdDeviceAllList"></div>
                            </div>
                            <div class="col-md-12">
                                <div class="modal-header" style="text-align: center; display: block">
                                    <a class="btn button-all" type="button" href=""""),_display_(/*78.84*/routes/*78.90*/.MarketPlaceController.marketPlaceDevice()),format.raw/*78.132*/("""">
                                    """),_display_(/*79.38*/Messages("Tất cả thiết bị")),format.raw/*79.65*/(""" """),format.raw/*79.66*/("""<img src=""""),_display_(/*79.77*/routes/*79.83*/.Assets.versioned("images/market/Vector.svg")),format.raw/*79.128*/("""" class="" alt="..." style="font-size: 14px;">
                                    </a>
                                </div>
                            </div>
                        </div>

                        <div class="row mt-3">
                            <div class="col-md-12" style="padding: 0px;">
                                <div class="col-md-12" style="background-color: white; display: block;">
                                    <span class="text-all-device-1">"""),_display_(/*88.70*/Messages("Giải pháp")),format.raw/*88.91*/("""</span><br>
                                    <div class="clearfix">
                                        <p class="mb-0 float-start" style="margin-top: 0.55rem;">
                                            <span class="text-darker text-all-device-2">"""),_display_(/*91.90*/Messages("Tất cả giải pháp IoT")),format.raw/*91.122*/("""</span>
                                        </p>
                                        <p class="mb-0 float-end" id="listGroupSolution">
                                            """),format.raw/*94.96*/("""
                                        """),format.raw/*95.41*/("""</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12 mt-3">
                                <div class="row" id="girdSolutionAllList"></div>
                            </div>
                            <div class="col-md-12">
                                <div class="modal-header" style="text-align: center; display: block">
                                    <a class="btn button-all" type="button" href=""""),_display_(/*104.84*/routes/*104.90*/.MarketPlaceController.marketPlaceSolution()),format.raw/*104.134*/("""">
                                        """),_display_(/*105.42*/Messages("Tất cả giải pháp")),format.raw/*105.70*/(""" """),format.raw/*105.71*/("""<img src=""""),_display_(/*105.82*/routes/*105.88*/.Assets.versioned("images/market/Vector.svg")),format.raw/*105.133*/("""" class="" alt="..." style="font-size: 14px;">
                                    </a>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>
            </div>
        </div>

        """),_display_(/*117.10*/views/*117.15*/.html.amarket.marketPlace.MarketPlace_footer(currentUser)),format.raw/*117.72*/("""

            """),format.raw/*119.13*/("""<!-- Messenger Plugin chat Code -->
        <div id="fb-root"></div>
            <!-- Your Plugin chat code -->
        <div id="fb-customer-chat" class="fb-customerchat"></div>

        """),_display_(/*124.10*/views/*124.15*/.html.Loading()),format.raw/*124.30*/("""

    """),format.raw/*126.5*/("""</body>
    <script type="text/javascript" src=""""),_display_(/*127.42*/routes/*127.48*/.JsController.jsMessages()),format.raw/*127.74*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*128.42*/routes/*128.48*/.JsController.javascriptRoutes),format.raw/*128.78*/(""""></script>
    <script src=""""),_display_(/*129.19*/routes/*129.25*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*129.79*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*131.19*/routes/*131.25*/.Assets.versioned("javascripts/landingPage/jquery.min.js")),format.raw/*131.83*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*132.19*/routes/*132.25*/.Assets.versioned("javascripts/landingPage/popper.min.js")),format.raw/*132.83*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*133.19*/routes/*133.25*/.Assets.versioned("javascripts/landingPage/bootstrap.min.js")),format.raw/*133.86*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*134.19*/routes/*134.25*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*134.79*/(""""></script>

    <script src=""""),_display_(/*136.19*/routes/*136.25*/.Assets.versioned("javascripts/landingPage/argon-design-system.js?v=1.2.2")),format.raw/*136.100*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*138.19*/routes/*138.25*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*138.92*/(""""></script>
    <script src=""""),_display_(/*139.19*/routes/*139.25*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*139.98*/(""""></script>
    <script src=""""),_display_(/*140.19*/routes/*140.25*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*140.107*/(""""></script>
    <script src=""""),_display_(/*141.19*/routes/*141.25*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*141.77*/("""" type="text/javascript"></script>

    """),_display_(/*143.6*/views/*143.11*/.html.BackToTop()),format.raw/*143.28*/("""

    """),format.raw/*145.5*/("""<script src=""""),_display_(/*145.19*/routes/*145.25*/.Assets.versioned("javascripts/views/amarket/marketPlace/all/MarketPlaceAll.js")),format.raw/*145.105*/("""" type="text/javascript"></script>

    <script>
            var avtDefault = """"),_display_(/*148.32*/routes/*148.38*/.Assets.versioned("images/avatarDefault.png")),format.raw/*148.83*/("""";

            var chatbox = document.getElementById('fb-customer-chat');
            chatbox.setAttribute("page_id", "105733635516877");
            chatbox.setAttribute("attribution", "biz_inbox");
    </script>

        <!-- Your SDK code -->
    <script>
            window.fbAsyncInit = function() """),format.raw/*157.45*/("""{"""),format.raw/*157.46*/("""
                """),format.raw/*158.17*/("""FB.init("""),format.raw/*158.25*/("""{"""),format.raw/*158.26*/("""
                    """),format.raw/*159.21*/("""xfbml            : true,
                    version          : 'v14.0'
                """),format.raw/*161.17*/("""}"""),format.raw/*161.18*/(""");
            """),format.raw/*162.13*/("""}"""),format.raw/*162.14*/(""";

            (function(d, s, id) """),format.raw/*164.33*/("""{"""),format.raw/*164.34*/("""
                """),format.raw/*165.17*/("""var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id)) return;
                js = d.createElement(s); js.id = id;
                js.src = 'https://connect.facebook.net/vi_VN/sdk/xfbml.customerchat.js';
                fjs.parentNode.insertBefore(js, fjs);
            """),format.raw/*170.13*/("""}"""),format.raw/*170.14*/("""(document, 'script', 'facebook-jssdk'));
    </script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:40 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/amarket/marketPlace/all/MarketPlaceAll.scala.html
                  HASH: 9755d9afcff6ca56a89456fe3f7d8a15254789ea
                  MATRIX: 675->1|1019->35|1132->53|1159->54|1311->180|1325->186|1381->222|1850->664|1865->670|1935->719|2002->759|2017->765|2114->840|2296->996|2311->1002|2381->1051|2450->1093|2465->1099|2563->1175|2633->1218|2648->1224|2738->1293|2808->1336|2823->1342|2885->1383|2954->1425|2969->1431|3053->1494|3123->1537|3138->1543|3220->1604|3301->1658|3315->1663|3393->1720|3429->1729|3802->2075|3817->2081|3883->2126|4465->2681|4512->2706|4658->2824|4752->2896|5153->3269|5224->3318|5508->3574|5550->3594|6244->4261|6285->4281|6570->4539|6627->4574|6842->4812|6911->4853|7470->5385|7485->5391|7549->5433|7616->5473|7664->5500|7693->5501|7731->5512|7746->5518|7813->5563|8329->6052|8371->6073|8656->6331|8710->6363|8925->6601|8994->6642|9554->7174|9570->7180|9637->7224|9709->7268|9759->7296|9789->7297|9828->7308|9844->7314|9912->7359|10229->7648|10244->7653|10323->7710|10366->7724|10582->7912|10597->7917|10634->7932|10668->7938|10745->7987|10761->7993|10809->8019|10890->8072|10906->8078|10958->8108|11016->8138|11032->8144|11108->8198|11190->8252|11206->8258|11286->8316|11367->8369|11383->8375|11463->8433|11544->8486|11560->8492|11643->8553|11724->8606|11740->8612|11816->8666|11875->8697|11891->8703|11989->8778|12071->8832|12087->8838|12176->8905|12234->8935|12250->8941|12345->9014|12403->9044|12419->9050|12524->9132|12582->9162|12598->9168|12672->9220|12740->9261|12755->9266|12794->9283|12828->9289|12870->9303|12886->9309|12989->9389|13097->9469|13113->9475|13180->9520|13513->9824|13543->9825|13589->9842|13626->9850|13656->9851|13706->9872|13823->9960|13853->9961|13897->9976|13927->9977|13991->10012|14021->10013|14067->10030|14398->10332|14428->10333
                  LINES: 24->1|29->2|34->2|35->3|39->7|39->7|39->7|46->14|46->14|46->14|47->15|47->15|47->15|50->18|50->18|50->18|52->20|52->20|52->20|53->21|53->21|53->21|54->22|54->22|54->22|56->24|56->24|56->24|57->25|57->25|57->25|61->29|61->29|61->29|62->30|68->36|68->36|68->36|74->42|74->42|75->43|75->43|78->46|78->46|80->48|80->48|94->62|94->62|97->65|97->65|100->68|101->69|110->78|110->78|110->78|111->79|111->79|111->79|111->79|111->79|111->79|120->88|120->88|123->91|123->91|126->94|127->95|136->104|136->104|136->104|137->105|137->105|137->105|137->105|137->105|137->105|149->117|149->117|149->117|151->119|156->124|156->124|156->124|158->126|159->127|159->127|159->127|160->128|160->128|160->128|161->129|161->129|161->129|163->131|163->131|163->131|164->132|164->132|164->132|165->133|165->133|165->133|166->134|166->134|166->134|168->136|168->136|168->136|170->138|170->138|170->138|171->139|171->139|171->139|172->140|172->140|172->140|173->141|173->141|173->141|175->143|175->143|175->143|177->145|177->145|177->145|177->145|180->148|180->148|180->148|189->157|189->157|190->158|190->158|190->158|191->159|193->161|193->161|194->162|194->162|196->164|196->164|197->165|202->170|202->170
                  -- GENERATED --
              */
          