
package views.html.amarket.marketPlace

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

object MarketPlace extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <link rel="icon" type="image/png" href=""""),_display_(/*7.46*/routes/*7.52*/.Assets.versioned("images/logo.jpg")),format.raw/*7.88*/("""">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Market Palace</title>
    """),format.raw/*10.117*/("""
    """),format.raw/*11.77*/("""

    """),format.raw/*13.5*/("""<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='"""),_display_(/*14.18*/routes/*14.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*14.73*/("""' type='text/css'>
    <link href=""""),_display_(/*15.18*/routes/*15.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*15.99*/("""" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">

    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("assets/css/bootstrap.min.css")),format.raw/*18.73*/("""" rel="stylesheet">

    <link href=""""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("stylesheets/landingPage/argon-design-system.css?v=1.2.2")),format.raw/*20.100*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("assets/plugins/notifications/css/lobibox.min.css")),format.raw/*21.93*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("assets/css/icons.css")),format.raw/*22.65*/("""" rel="stylesheet">

    <link href=""""),_display_(/*24.18*/routes/*24.24*/.Assets.versioned("stylesheets/views/market/landingMarket.css")),format.raw/*24.87*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*25.18*/routes/*25.24*/.Assets.versioned("stylesheets/views/market/MarketPlace.css")),format.raw/*25.85*/("""" rel="stylesheet"/>

  </head>
  <body>
    """),_display_(/*29.6*/views/*29.11*/.html.amarket.marketPlace.MarketPlace_navbar(currentUser)),format.raw/*29.68*/("""
    """),format.raw/*30.5*/("""<div class="section section-features" style="margin-top: 5rem!important; display: flex;">
      <div class="container">
        <div class="wrapper">

          <ul class="nav nav-tabs" role="tablist">
            <li class="nav-item" role="presentation" onclick="getAllProduct()">
              <a class="nav-link active" data-bs-toggle="tab" href="#tabAllProduct" role="tab" aria-selected="false">
                <div class="d-flex align-items-center">
                  <span>"""),_display_(/*38.26*/Messages("Tất cả")),format.raw/*38.44*/("""</span>
                </div>
              </a>
            </li>
            <li class="nav-item" role="presentation" onclick="getListProduct()">
              <a class="nav-link" data-bs-toggle="tab" href="#tabGroupProduct" role="tab" aria-selected="false">
                <div class="d-flex align-items-center">
                  <span>"""),_display_(/*45.26*/Messages("Thiết bị IoT")),format.raw/*45.50*/("""</span>
                </div>
              </a>
            </li>
            <li class="nav-item" role="presentation" onclick="getListSolution()">
              <a class="nav-link" data-bs-toggle="tab" href="#tabSolution" role="tab" aria-selected="false">
                <div class="d-flex align-items-center">
                  <span>"""),_display_(/*52.26*/Messages("Giải pháp IoT")),format.raw/*52.51*/("""</span>
                </div>
              </a>
            </li>
          </ul>
          <div class="tab-content py-3">
            <div class="tab-pane fade show active" id="tabAllProduct" role="tabpanel">
            """),_display_(/*59.14*/views/*59.19*/.html.amarket.marketPlace.MarketPlace_allProduct()),format.raw/*59.69*/("""
            """),format.raw/*60.13*/("""</div>

            <div class="tab-pane fade" id="tabGroupProduct" role="tabpanel">
              """),_display_(/*63.16*/views/*63.21*/.html.amarket.marketPlace.MarketPlace_device()),format.raw/*63.67*/("""
            """),format.raw/*64.13*/("""</div>

            <div class="tab-pane fade" id="tabSolution" role="tabpanel">
            """),_display_(/*67.14*/views/*67.19*/.html.amarket.marketPlace.MarketPlace_solution()),format.raw/*67.67*/("""
            """),format.raw/*68.13*/("""</div>

          </div>
        </div>
      </div>
    </div>

    """),_display_(/*75.6*/views/*75.11*/.html.amarket.marketPlace.MarketPlace_footer(currentUser)),format.raw/*75.68*/("""

      """),format.raw/*77.7*/("""<!-- Messenger Plugin chat Code -->
    <div id="fb-root"></div>
      <!-- Your Plugin chat code -->
    <div id="fb-customer-chat" class="fb-customerchat"></div>

    """),_display_(/*82.6*/views/*82.11*/.html.Loading()),format.raw/*82.26*/("""

  """),format.raw/*84.3*/("""</body>
  <script type="text/javascript" src=""""),_display_(/*85.40*/routes/*85.46*/.JsController.jsMessages()),format.raw/*85.72*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*86.40*/routes/*86.46*/.JsController.javascriptRoutes),format.raw/*86.76*/(""""></script>
  <script src=""""),_display_(/*87.17*/routes/*87.23*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*87.77*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*89.17*/routes/*89.23*/.Assets.versioned("javascripts/landingPage/jquery.min.js")),format.raw/*89.81*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*90.17*/routes/*90.23*/.Assets.versioned("javascripts/landingPage/popper.min.js")),format.raw/*90.81*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*91.17*/routes/*91.23*/.Assets.versioned("javascripts/landingPage/bootstrap.min.js")),format.raw/*91.84*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*92.17*/routes/*92.23*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*92.77*/(""""></script>

  <script src=""""),_display_(/*94.17*/routes/*94.23*/.Assets.versioned("javascripts/landingPage/argon-design-system.js?v=1.2.2")),format.raw/*94.98*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*96.17*/routes/*96.23*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*96.90*/(""""></script>
  <script src=""""),_display_(/*97.17*/routes/*97.23*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*97.96*/(""""></script>
  <script src=""""),_display_(/*98.17*/routes/*98.23*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*98.105*/(""""></script>
  <script src=""""),_display_(/*99.17*/routes/*99.23*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*99.75*/("""" type="text/javascript"></script>

  """),_display_(/*101.4*/views/*101.9*/.html.BackToTop()),format.raw/*101.26*/("""

  """),format.raw/*103.3*/("""<script src=""""),_display_(/*103.17*/routes/*103.23*/.Assets.versioned("javascripts/views/amarket/marketPlace/MarketPlace.js")),format.raw/*103.96*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*104.17*/routes/*104.23*/.Assets.versioned("javascripts/views/amarket/marketPlace/MarketPlace_allProduct.js")),format.raw/*104.107*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*105.17*/routes/*105.23*/.Assets.versioned("javascripts/views/amarket/marketPlace/MarketPlace_device.js")),format.raw/*105.103*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*106.17*/routes/*106.23*/.Assets.versioned("javascripts/views/amarket/marketPlace/MarketPlace_solution.js")),format.raw/*106.105*/("""" type="text/javascript"></script>

  <script>
          var chatbox = document.getElementById('fb-customer-chat');
          chatbox.setAttribute("page_id", "105733635516877");
          chatbox.setAttribute("attribution", "biz_inbox");
  </script>

    <!-- Your SDK code -->
  <script>
          window.fbAsyncInit = function() """),format.raw/*116.43*/("""{"""),format.raw/*116.44*/("""
            """),format.raw/*117.13*/("""FB.init("""),format.raw/*117.21*/("""{"""),format.raw/*117.22*/("""
              """),format.raw/*118.15*/("""xfbml            : true,
              version          : 'v14.0'
            """),format.raw/*120.13*/("""}"""),format.raw/*120.14*/(""");
          """),format.raw/*121.11*/("""}"""),format.raw/*121.12*/(""";

          (function(d, s, id) """),format.raw/*123.31*/("""{"""),format.raw/*123.32*/("""
            """),format.raw/*124.13*/("""var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) return;
            js = d.createElement(s); js.id = id;
            js.src = 'https://connect.facebook.net/vi_VN/sdk/xfbml.customerchat.js';
            fjs.parentNode.insertBefore(js, fjs);
          """),format.raw/*129.11*/("""}"""),format.raw/*129.12*/("""(document, 'script', 'facebook-jssdk'));
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/amarket/marketPlace/MarketPlace.scala.html
                  HASH: 49d1df428c61512645fcf76ec44b7ceec57e6b73
                  MATRIX: 671->1|1012->35|1125->53|1152->54|1294->170|1308->176|1364->212|1502->433|1535->510|1568->516|1718->639|1733->645|1803->694|1866->730|1881->736|1977->811|2151->959|2166->965|2236->1014|2301->1052|2316->1058|2414->1134|2480->1173|2495->1179|2585->1248|2651->1287|2666->1293|2728->1334|2793->1372|2808->1378|2892->1441|2958->1480|2973->1486|3055->1547|3127->1593|3141->1598|3219->1655|3251->1660|3759->2141|3798->2159|4168->2502|4213->2526|4580->2866|4626->2891|4878->3116|4892->3121|4963->3171|5004->3184|5131->3284|5145->3289|5212->3335|5253->3348|5374->3442|5388->3447|5457->3495|5498->3508|5594->3578|5608->3583|5686->3640|5721->3648|5917->3818|5931->3823|5967->3838|5998->3842|6072->3889|6087->3895|6134->3921|6212->3972|6227->3978|6278->4008|6333->4036|6348->4042|6423->4096|6502->4148|6517->4154|6596->4212|6674->4263|6689->4269|6768->4327|6846->4378|6861->4384|6943->4445|7021->4496|7036->4502|7111->4556|7167->4585|7182->4591|7278->4666|7357->4718|7372->4724|7460->4791|7515->4819|7530->4825|7624->4898|7679->4926|7694->4932|7798->5014|7853->5042|7868->5048|7941->5100|8007->5139|8021->5144|8060->5161|8092->5165|8134->5179|8150->5185|8245->5258|8324->5309|8340->5315|8447->5399|8526->5450|8542->5456|8645->5536|8724->5587|8740->5593|8845->5675|9205->6006|9235->6007|9277->6020|9314->6028|9344->6029|9388->6044|9495->6122|9525->6123|9567->6136|9597->6137|9659->6170|9689->6171|9731->6184|10044->6468|10074->6469
                  LINES: 24->1|29->2|34->2|35->3|39->7|39->7|39->7|42->10|43->11|45->13|46->14|46->14|46->14|47->15|47->15|47->15|50->18|50->18|50->18|52->20|52->20|52->20|53->21|53->21|53->21|54->22|54->22|54->22|56->24|56->24|56->24|57->25|57->25|57->25|61->29|61->29|61->29|62->30|70->38|70->38|77->45|77->45|84->52|84->52|91->59|91->59|91->59|92->60|95->63|95->63|95->63|96->64|99->67|99->67|99->67|100->68|107->75|107->75|107->75|109->77|114->82|114->82|114->82|116->84|117->85|117->85|117->85|118->86|118->86|118->86|119->87|119->87|119->87|121->89|121->89|121->89|122->90|122->90|122->90|123->91|123->91|123->91|124->92|124->92|124->92|126->94|126->94|126->94|128->96|128->96|128->96|129->97|129->97|129->97|130->98|130->98|130->98|131->99|131->99|131->99|133->101|133->101|133->101|135->103|135->103|135->103|135->103|136->104|136->104|136->104|137->105|137->105|137->105|138->106|138->106|138->106|148->116|148->116|149->117|149->117|149->117|150->118|152->120|152->120|153->121|153->121|155->123|155->123|156->124|161->129|161->129
                  -- GENERATED --
              */
          