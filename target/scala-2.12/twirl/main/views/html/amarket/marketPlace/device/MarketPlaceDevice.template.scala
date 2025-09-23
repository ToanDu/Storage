
package views.html.amarket.marketPlace.device

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

object MarketPlaceDevice extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>Market Device</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    """),format.raw/*14.114*/("""
    """),format.raw/*15.5*/("""<link href='"""),_display_(/*15.18*/routes/*15.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*15.73*/("""' type='text/css'>
    <link href=""""),_display_(/*16.18*/routes/*16.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*16.99*/("""" rel="stylesheet">

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

          <div class="col-md-12">

            <div class="row" style="background-color: #EE0033; border-radius: 15px;">
              <img src=""""),_display_(/*37.26*/routes/*37.32*/.Assets.versioned("images/market/banner.png")),format.raw/*37.77*/("""" class="card-img cursor-pointer img-banner" alt="..." style="padding: 0px;">
              <div class="page-header">
                <div class="container shape-container d-flex align-items-center">
                  <div class="col px-0">
                    <div class="row align-items-center justify-content-center">
                      <div class="col-lg-11">
                        <span class="giai-phap-iot" style="color: white">"""),_display_(/*43.75*/Messages("Thiết bị IoT")),format.raw/*43.99*/("""</span><br>
                        <span class="header-content-market" style="color: white">"""),_display_(/*44.83*/Messages("Các thiết bị Iot thông minh cho doanh nghiệp và hộ gia đình")),format.raw/*44.154*/("""</span>
                        <div class="col-lg-9" style="padding-left: 0px;">
                          <div class="inner-addon left-addon mt-3 mb-3">
                            <input id="searchProduct" class="form-control inputSearch" style="font-size: 1.5rem;" type="text" placeholder=""""),_display_(/*47.141*/Messages("Tìm kiếm theo tên thiết bị")),format.raw/*47.179*/("""" maxlength="50">
                            <i class="glyphicon bx bx-search"></i>
                            <button class="btn btn-danger search-button" onclick="getListDevice()">"""),_display_(/*49.101*/Messages("Tìm kiếm")),format.raw/*49.121*/("""</button>
                          </div>
                        </div>

                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="cursor-pointer mt-3">
              <a class="tab-title" href=""""),_display_(/*61.43*/routes/*61.49*/.LandingPageController.home()),format.raw/*61.78*/("""">"""),_display_(/*61.81*/Messages("Trang chủ")),format.raw/*61.102*/("""</a> <a>"""),_display_(/*61.111*/Messages(" / ")),format.raw/*61.126*/("""</a>
              <a class="tab-title" href=""""),_display_(/*62.43*/routes/*62.49*/.MarketPlaceController.marketPlace()),format.raw/*62.85*/("""">"""),_display_(/*62.88*/Messages("MarketPlace")),format.raw/*62.111*/("""</a> <a>"""),_display_(/*62.120*/Messages(" / ")),format.raw/*62.135*/("""</a>
              <a class="tab-title" href=""""),_display_(/*63.43*/routes/*63.49*/.MarketPlaceController.marketPlaceDevice()),format.raw/*63.91*/("""">"""),_display_(/*63.94*/Messages("Thiết bị")),format.raw/*63.114*/("""</a>
            </div>
            <div class="row mt-3" style="display: flex;">
              <div class="col-md-3">
                <div class="row" style="margin-top: 10px;">
                  <h2 class="accordion-header" id="headingGroupDevice">
                    <button class="accordion-button text-group" type="button" data-bs-toggle="collapse" data-bs-target="#collapseGroupDevice" aria-expanded="true" aria-controls="collapseGroupDevice">
                    """),_display_(/*70.22*/Messages("Theo nhóm thiết bị")),format.raw/*70.52*/("""
                    """),format.raw/*71.21*/("""</button>
                  </h2>
                  <div id="collapseGroupDevice" class="accordion-collapse collapse show" aria-labelledby="headingGroupDevice" data-bs-parent="#accordionGroupDevice">
                    <div class="mt-3" id="listGroupDevice" style="padding-right: 1.5rem;"></div>
                  </div>
                </div>
              </div>
              <div class="col-md-9">
                <div class="row">
                  <div class="col-md-12" style="padding: 0px; margin-left: 5px;">
                    <div class="sort-bar" style="background-color: white">
                      <span id="totalProduct" class="total-product">"""),_display_(/*82.70*/Messages("0 ket qua")),format.raw/*82.91*/("""</span>
                      <div class="row mb-3">
                        <label class="col-sm-5 col-form-label">"""),_display_(/*84.65*/Messages("Sắp xếp theo")),format.raw/*84.89*/("""</label>
                        <div class="col-sm-7">
                          <select class="form-select ml-3" id="priceSortDevice" style="width: 200px;" onchange="getListDevice()">
                            <option value="ASC">"""),_display_(/*87.50*/Messages("Giá: thấp nhất")),format.raw/*87.76*/("""</option>
                            <option value="DESC">"""),_display_(/*88.51*/Messages("Giá: cao nhất")),format.raw/*88.76*/("""</option>
                          </select>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="row mt-3" id="girdDeviceList"></div>
              </div>
            </div>
          </div>

        </div>
      </div>
    </div>

    """),_display_(/*104.6*/views/*104.11*/.html.amarket.marketPlace.MarketPlace_footer(currentUser)),format.raw/*104.68*/("""

      """),format.raw/*106.7*/("""<!-- Messenger Plugin chat Code -->
    <div id="fb-root"></div>
      <!-- Your Plugin chat code -->
    <div id="fb-customer-chat" class="fb-customerchat"></div>

    """),_display_(/*111.6*/views/*111.11*/.html.Loading()),format.raw/*111.26*/("""

  """),format.raw/*113.3*/("""</body>
  <script type="text/javascript" src=""""),_display_(/*114.40*/routes/*114.46*/.JsController.jsMessages()),format.raw/*114.72*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*115.40*/routes/*115.46*/.JsController.javascriptRoutes),format.raw/*115.76*/(""""></script>
  <script src=""""),_display_(/*116.17*/routes/*116.23*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*116.77*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*118.17*/routes/*118.23*/.Assets.versioned("javascripts/landingPage/jquery.min.js")),format.raw/*118.81*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*119.17*/routes/*119.23*/.Assets.versioned("javascripts/landingPage/popper.min.js")),format.raw/*119.81*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*120.17*/routes/*120.23*/.Assets.versioned("javascripts/landingPage/bootstrap.min.js")),format.raw/*120.84*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*121.17*/routes/*121.23*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*121.77*/(""""></script>

  <script src=""""),_display_(/*123.17*/routes/*123.23*/.Assets.versioned("javascripts/landingPage/argon-design-system.js?v=1.2.2")),format.raw/*123.98*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*125.17*/routes/*125.23*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*125.90*/(""""></script>
  <script src=""""),_display_(/*126.17*/routes/*126.23*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*126.96*/(""""></script>
  <script src=""""),_display_(/*127.17*/routes/*127.23*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*127.105*/(""""></script>
  <script src=""""),_display_(/*128.17*/routes/*128.23*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*128.75*/("""" type="text/javascript"></script>

  """),_display_(/*130.4*/views/*130.9*/.html.BackToTop()),format.raw/*130.26*/("""

  """),format.raw/*132.3*/("""<script src=""""),_display_(/*132.17*/routes/*132.23*/.Assets.versioned("javascripts/views/amarket/marketPlace/device/MarketPlaceDevice.js")),format.raw/*132.109*/("""" type="text/javascript"></script>

  <script>
    var avtDefault = """"),_display_(/*135.24*/routes/*135.30*/.Assets.versioned("images/avatarDefault.png")),format.raw/*135.75*/("""";

          var chatbox = document.getElementById('fb-customer-chat');
          chatbox.setAttribute("page_id", "105733635516877");
          chatbox.setAttribute("attribution", "biz_inbox");
  </script>

    <!-- Your SDK code -->
  <script>
          window.fbAsyncInit = function() """),format.raw/*144.43*/("""{"""),format.raw/*144.44*/("""
            """),format.raw/*145.13*/("""FB.init("""),format.raw/*145.21*/("""{"""),format.raw/*145.22*/("""
              """),format.raw/*146.15*/("""xfbml            : true,
              version          : 'v14.0'
            """),format.raw/*148.13*/("""}"""),format.raw/*148.14*/(""");
          """),format.raw/*149.11*/("""}"""),format.raw/*149.12*/(""";

          (function(d, s, id) """),format.raw/*151.31*/("""{"""),format.raw/*151.32*/("""
            """),format.raw/*152.13*/("""var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) return;
            js = d.createElement(s); js.id = id;
            js.src = 'https://connect.facebook.net/vi_VN/sdk/xfbml.customerchat.js';
            fjs.parentNode.insertBefore(js, fjs);
          """),format.raw/*157.11*/("""}"""),format.raw/*157.12*/("""(document, 'script', 'facebook-jssdk'));
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
                  DATE: Mon Sep 22 16:32:41 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/amarket/marketPlace/device/MarketPlaceDevice.scala.html
                  HASH: caf4adedfaede99c71bd5a612f07e185143297ee
                  MATRIX: 678->1|1025->35|1138->53|1165->54|1307->170|1321->176|1377->212|1812->727|1844->732|1884->745|1899->751|1969->800|2032->836|2047->842|2143->917|2208->955|2223->961|2293->1010|2358->1048|2373->1054|2471->1130|2537->1169|2552->1175|2642->1244|2708->1283|2723->1289|2785->1330|2850->1368|2865->1374|2949->1437|3015->1476|3030->1482|3112->1543|3184->1589|3198->1594|3276->1651|3308->1656|3632->1953|3647->1959|3713->2004|4181->2445|4226->2469|4347->2563|4440->2634|4763->2929|4823->2967|5036->3152|5078->3172|5413->3480|5428->3486|5478->3515|5508->3518|5551->3539|5588->3548|5625->3563|5699->3610|5714->3616|5771->3652|5801->3655|5846->3678|5883->3687|5920->3702|5994->3749|6009->3755|6072->3797|6102->3800|6144->3820|6643->4292|6694->4322|6743->4343|7433->5006|7475->5027|7619->5144|7664->5168|7926->5403|7973->5429|8060->5489|8106->5514|8482->5863|8497->5868|8576->5925|8612->5933|8809->6103|8824->6108|8861->6123|8893->6127|8968->6174|8984->6180|9032->6206|9111->6257|9127->6263|9179->6293|9235->6321|9251->6327|9327->6381|9407->6433|9423->6439|9503->6497|9582->6548|9598->6554|9678->6612|9757->6663|9773->6669|9856->6730|9935->6781|9951->6787|10027->6841|10084->6870|10100->6876|10197->6951|10277->7003|10293->7009|10382->7076|10438->7104|10454->7110|10549->7183|10605->7211|10621->7217|10726->7299|10782->7327|10798->7333|10872->7385|10938->7424|10952->7429|10991->7446|11023->7450|11065->7464|11081->7470|11190->7556|11288->7626|11304->7632|11371->7677|11688->7965|11718->7966|11760->7979|11797->7987|11827->7988|11871->8003|11978->8081|12008->8082|12050->8095|12080->8096|12142->8129|12172->8130|12214->8143|12527->8427|12557->8428
                  LINES: 24->1|29->2|34->2|35->3|39->7|39->7|39->7|46->14|47->15|47->15|47->15|47->15|48->16|48->16|48->16|50->18|50->18|50->18|52->20|52->20|52->20|53->21|53->21|53->21|54->22|54->22|54->22|56->24|56->24|56->24|57->25|57->25|57->25|61->29|61->29|61->29|62->30|69->37|69->37|69->37|75->43|75->43|76->44|76->44|79->47|79->47|81->49|81->49|93->61|93->61|93->61|93->61|93->61|93->61|93->61|94->62|94->62|94->62|94->62|94->62|94->62|94->62|95->63|95->63|95->63|95->63|95->63|102->70|102->70|103->71|114->82|114->82|116->84|116->84|119->87|119->87|120->88|120->88|136->104|136->104|136->104|138->106|143->111|143->111|143->111|145->113|146->114|146->114|146->114|147->115|147->115|147->115|148->116|148->116|148->116|150->118|150->118|150->118|151->119|151->119|151->119|152->120|152->120|152->120|153->121|153->121|153->121|155->123|155->123|155->123|157->125|157->125|157->125|158->126|158->126|158->126|159->127|159->127|159->127|160->128|160->128|160->128|162->130|162->130|162->130|164->132|164->132|164->132|164->132|167->135|167->135|167->135|176->144|176->144|177->145|177->145|177->145|178->146|180->148|180->148|181->149|181->149|183->151|183->151|184->152|189->157|189->157
                  -- GENERATED --
              */
          