
package views.html.amarket.marketPlace.detail

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
/*1.2*/import vn.m2m.iot.models.Product
/*2.2*/import vn.m2m.iot.models.GroupProduct
/*3.2*/import vn.m2m.common.models.User

object MarketPlaceDetail extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,String,Integer,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(currentUser:User, productId:String, groupType:Integer):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.57*/("""
"""),format.raw/*5.1*/("""<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <link rel="icon" type="image/png" href=""""),_display_(/*9.46*/routes/*9.52*/.Assets.versioned("images/logo.jpg")),format.raw/*9.88*/("""">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Market Device</title>
    """),format.raw/*12.117*/("""
    """),format.raw/*13.77*/("""

    """),format.raw/*15.5*/("""<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">

    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("assets/css/bootstrap.min.css")),format.raw/*18.73*/("""" rel="stylesheet">

    <link href=""""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("stylesheets/landingPage/argon-design-system.css?v=1.2.2")),format.raw/*20.100*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("assets/plugins/notifications/css/lobibox.min.css")),format.raw/*21.93*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("assets/css/icons.css")),format.raw/*22.65*/("""" rel="stylesheet">

    <link href=""""),_display_(/*24.18*/routes/*24.24*/.Assets.versioned("stylesheets/views/market/landingMarket.css")),format.raw/*24.87*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*25.18*/routes/*25.24*/.Assets.versioned("stylesheets/views/market/MarketPlace.css")),format.raw/*25.85*/("""" rel="stylesheet"/>
    <link href=""""),_display_(/*26.18*/routes/*26.24*/.Assets.versioned("stylesheets/views/market/detail/TreeComment.css")),format.raw/*26.92*/("""" rel="stylesheet" />

  </head>
  <body>
    """),_display_(/*30.6*/views/*30.11*/.html.amarket.marketPlace.MarketPlace_navbar(currentUser)),format.raw/*30.68*/("""
    """),format.raw/*31.5*/("""<div class="section section-features" style="margin-top: 5rem!important; display: flex;">
      <div class="container">
        <div class="wrapper">

          <div class="col-md-12">
            <div class="cursor-pointer mt-3">
              <a class="tab-title" href=""""),_display_(/*37.43*/routes/*37.49*/.LandingPageController.home()),format.raw/*37.78*/("""">"""),_display_(/*37.81*/Messages("Trang chủ")),format.raw/*37.102*/("""</a> <a>"""),_display_(/*37.111*/Messages(" / ")),format.raw/*37.126*/("""</a>
              <a class="tab-title" href=""""),_display_(/*38.43*/routes/*38.49*/.MarketPlaceController.marketPlace()),format.raw/*38.85*/("""">"""),_display_(/*38.88*/Messages("MarketPlace")),format.raw/*38.111*/("""</a> <a>"""),_display_(/*38.120*/Messages(" / ")),format.raw/*38.135*/("""</a>
              """),_display_(/*39.16*/if(groupType == GroupProduct.Types.device.getCode)/*39.66*/{_display_(Seq[Any](format.raw/*39.67*/("""
                """),format.raw/*40.17*/("""<a class="tab-title" href=""""),_display_(/*40.45*/routes/*40.51*/.MarketPlaceController.marketPlaceDevice()),format.raw/*40.93*/("""">"""),_display_(/*40.96*/Messages("Thiết bị")),format.raw/*40.116*/("""</a>
              """)))}/*41.17*/else if(groupType == GroupProduct.Types.solution.getCode)/*41.74*/{_display_(Seq[Any](format.raw/*41.75*/("""
                """),format.raw/*42.17*/("""<a class="tab-title" href=""""),_display_(/*42.45*/routes/*42.51*/.MarketPlaceController.marketPlaceSolution()),format.raw/*42.95*/("""">"""),_display_(/*42.98*/Messages("Giải pháp")),format.raw/*42.119*/("""</a>
              """)))}),format.raw/*43.16*/("""
            """),format.raw/*44.13*/("""</div>

            <div class="mt-3">
              <div class="row g-0">
                <div class="col-md-5 border-end">
                  <img class="img-fluid" alt="..." id="avatarProduct" style="width: 100%;">
                  <div class="row mb-3  mt-3">
                    <div class="col-md-2" id="imgAvatar"></div>
                    <div class="col-md-2" id="img1" style=""></div>
                    <div class="col-md-2" id="img2" style=""></div>
                    <div class="col-md-2" id="img3" style=""></div>
                    <div class="col-md-2" id="img4" style=""></div>
                    <div class="col-md-2" id="img5" style=""></div>
                  </div>
                </div>
                <div class="col-md-7">
                  <div class="card-body pt-0">
                    <div class=""><span class="detail-name-product" id="nameProduct"></span></div>
                    <div class="mt-3"><span class="detail-content-product" id="infoProduct"></span></div>
                    <div class="d-flex gap-3 mt-4">
                      <a href="#" class="btn btn-danger text-white" data-bs-toggle="modal" data-bs-target="#contactFormModal" onclick="resetFormContact()">
                        <span class="text">"""),_display_(/*65.45*/Messages("Liên hệ ngay ")),format.raw/*65.70*/("""</span>
                        <img src=""""),_display_(/*66.36*/routes/*66.42*/.Assets.versioned("images/market/Vector2.svg")),format.raw/*66.88*/("""" class="" alt="..." style="font-size: 14px;">
                      </a>
                      <a href="#" class="btn btn-white"><span class="text">"""),_display_(/*68.77*/Messages("Chia sẻ")),format.raw/*68.96*/("""</span> <i class='bx bx-share'></i></a>
                      <a href="#" class="btn btn-white">
                        <span class="text">"""),_display_(/*70.45*/Messages("Quan tâm")),format.raw/*70.65*/("""</span> <i class='bx bx-heart'></i>
                      </a>
                    </div>
                  </div>
                </div>
              </div>
              <hr/>
              <div class="col-md-12 pl-0 pr-0">
                <ul class="nav nav-tabs mb-0" role="tablist">
                  <li class="nav-item" role="presentation">
                    <a class="nav-link active" data-bs-toggle="tab" href="#contentProduct" role="tab" aria-selected="true">
                      <div class="d-flex align-items-center">
                        <div class="tab-title tab-detail">"""),_display_(/*82.60*/Messages("Mô tả")),format.raw/*82.77*/("""</div>
                      </div>
                    </a>
                  </li>
                  <li class="nav-item" role="presentation">
                    <a class="nav-link" data-bs-toggle="tab" href="#featureProduct" role="tab" aria-selected="false">
                      <div class="d-flex align-items-center">
                        <div class="tab-title tab-detail" id="titleContentProduct">"""),_display_(/*89.85*/Messages("Tính năng nổi bật")),format.raw/*89.114*/("""</div>
                      </div>
                    </a>
                  </li>
                  <li class="nav-item" role="presentation">
                    <a class="nav-link" data-bs-toggle="tab" href="#linkDocsProduct" role="tab" aria-selected="false">
                      <div class="d-flex align-items-center">
                        <div class="tab-title tab-detail">"""),_display_(/*96.60*/Messages("Tài liệu")),format.raw/*96.80*/("""</div>
                      </div>
                    </a>
                  </li>
                  <li class="nav-item" role="presentation">
                    <a class="nav-link" data-bs-toggle="tab" href="#questionProduct" role="tab" aria-selected="false">
                      <div class="d-flex align-items-center">
                        <div class="tab-title tab-detail">"""),_display_(/*103.60*/Messages("Bình luận")),format.raw/*103.81*/("""</div>
                      </div>
                    </a>
                  </li>
                </ul>
                <div class="tab-content pt-3">
                  <div class="tab-pane fade show active" id="contentProduct" role="tabpanel"></div>
                  <div class="tab-pane fade" id="featureProduct" role="tabpanel"></div>
                  <div class="tab-pane fade" id="linkDocsProduct" role="tabpanel"></div>
                  <div class="tab-pane fade" id="questionProduct" role="tabpanel">
                    <label class="questionText">"""),_display_(/*113.50*/Messages("Nội dung")),format.raw/*113.70*/("""</label>
                    <textarea class="form-control" id="questionText" placeholder="... nội dung tối đa 1000 kí tự" maxlength="1000" rows="5"></textarea>
                    <div class="row mt-3">
                      <div class="col-md-4">
                        <div class="row">
                          <label class="col-sm-12 col-form-label questionText">"""),_display_(/*118.81*/Messages("Tên")),format.raw/*118.96*/("""</label>
                          <div class="col-sm-12">
                            <input id="nameQuestioner" type="text" class="form-control " maxlength="50" autocomplete="off" placeholder="...tối đa 50 kí tự">
                          </div>
                        </div>
                      </div>
                      <div class="col-md-4">
                        <div class="row">
                          <label class="col-sm-12 col-form-label questionText">"""),_display_(/*126.81*/Messages("Email")),format.raw/*126.98*/("""</label>
                          <div class="col-sm-12">
                            <input id="emailQuestioner" type="email" class="form-control " maxlength="100" autocomplete="off" placeholder="...tối đa 100 kí tự">
                          </div>
                        </div>
                      </div>
                      <div class="col-md-12 mt-3">
                        <button class="btn questionButton" type="button" onclick="proccessCommentProduct()">"""),_display_(/*133.110*/Messages("Gửi")),format.raw/*133.125*/(""" """),format.raw/*133.126*/("""<i class="bx bx-redo"></i></button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <hr style="border: 1px solid #aaaaaa;">

            <div class="mt-3">
              <label class="product-comment" id="countComment"></label>
              <div class="row mt-3">
                <div id="tabListComment"></div>
              </div>

            </div>
            <hr style="border: 1px solid #aaaaaa;">

            <div class="mt-3">
              <label class="product-same" id="productSame"></label>
              <div class="row mt-3" id="listProductSame"></div>
            </div>

          </div>

        </div>
      </div>
    </div>

    """),_display_(/*162.6*/views/*162.11*/.html.amarket.marketPlace.MarketPlace_footer(currentUser)),format.raw/*162.68*/("""
    """),_display_(/*163.6*/views/*163.11*/.html.amarket.marketPlace.detail.MarketPlaceDetail_contact()),format.raw/*163.71*/("""
    """),_display_(/*164.6*/views/*164.11*/.html.amarket.marketPlace.detail.MarketPlaceDetail_answer()),format.raw/*164.70*/("""

      """),format.raw/*166.7*/("""<!-- Messenger Plugin chat Code -->
    <div id="fb-root"></div>
      <!-- Your Plugin chat code -->
    <div id="fb-customer-chat" class="fb-customerchat"></div>

    """),_display_(/*171.6*/views/*171.11*/.html.Loading()),format.raw/*171.26*/("""

  """),format.raw/*173.3*/("""</body>
  <script type="text/javascript" src=""""),_display_(/*174.40*/routes/*174.46*/.JsController.jsMessages()),format.raw/*174.72*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*175.40*/routes/*175.46*/.JsController.javascriptRoutes),format.raw/*175.76*/(""""></script>
  <script src=""""),_display_(/*176.17*/routes/*176.23*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*176.77*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*178.17*/routes/*178.23*/.Assets.versioned("javascripts/landingPage/jquery.min.js")),format.raw/*178.81*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*179.17*/routes/*179.23*/.Assets.versioned("javascripts/landingPage/popper.min.js")),format.raw/*179.81*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*180.17*/routes/*180.23*/.Assets.versioned("javascripts/landingPage/bootstrap.min.js")),format.raw/*180.84*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*181.17*/routes/*181.23*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*181.77*/(""""></script>

  <script src=""""),_display_(/*183.17*/routes/*183.23*/.Assets.versioned("javascripts/landingPage/argon-design-system.js?v=1.2.2")),format.raw/*183.98*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*185.17*/routes/*185.23*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*185.90*/(""""></script>
  <script src=""""),_display_(/*186.17*/routes/*186.23*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*186.96*/(""""></script>
  <script src=""""),_display_(/*187.17*/routes/*187.23*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*187.105*/(""""></script>
  <script src=""""),_display_(/*188.17*/routes/*188.23*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*188.75*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*190.17*/routes/*190.23*/.Assets.versioned("javascripts/views/group/jstree.js")),format.raw/*190.77*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*191.17*/routes/*191.23*/.Assets.versioned("javascripts/plugins/moment.min.js")),format.raw/*191.77*/("""" type="text/javascript"></script>

  """),_display_(/*193.4*/views/*193.9*/.html.BackToTop()),format.raw/*193.26*/("""

  """),format.raw/*195.3*/("""<script>
          var productId = '"""),_display_(/*196.29*/productId),format.raw/*196.38*/("""';
          var avtDefault = """"),_display_(/*197.30*/routes/*197.36*/.Assets.versioned("images/avatarDefault.png")),format.raw/*197.81*/("""";
  </script>
  <script src=""""),_display_(/*199.17*/routes/*199.23*/.Assets.versioned("javascripts/views/amarket/marketPlace/detail/MarketPlaceDetail.js")),format.raw/*199.109*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*200.17*/routes/*200.23*/.Assets.versioned("javascripts/views/amarket/marketPlace/detail/MarketPlaceDetail_contact.js")),format.raw/*200.117*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*201.17*/routes/*201.23*/.Assets.versioned("javascripts/views/amarket/marketPlace/detail/MarketPlaceDetail_comment.js")),format.raw/*201.117*/("""" type="text/javascript"></script>

  <script>
          var chatbox = document.getElementById('fb-customer-chat');
          chatbox.setAttribute("page_id", "105733635516877");
          chatbox.setAttribute("attribution", "biz_inbox");
  </script>

    <!-- Your SDK code -->
  <script>
          window.fbAsyncInit = function() """),format.raw/*211.43*/("""{"""),format.raw/*211.44*/("""
            """),format.raw/*212.13*/("""FB.init("""),format.raw/*212.21*/("""{"""),format.raw/*212.22*/("""
              """),format.raw/*213.15*/("""xfbml            : true,
              version          : 'v14.0'
            """),format.raw/*215.13*/("""}"""),format.raw/*215.14*/(""");
          """),format.raw/*216.11*/("""}"""),format.raw/*216.12*/(""";

          (function(d, s, id) """),format.raw/*218.31*/("""{"""),format.raw/*218.32*/("""
            """),format.raw/*219.13*/("""var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) return;
            js = d.createElement(s); js.id = id;
            js.src = 'https://connect.facebook.net/vi_VN/sdk/xfbml.customerchat.js';
            fjs.parentNode.insertBefore(js, fjs);
          """),format.raw/*224.11*/("""}"""),format.raw/*224.12*/("""(document, 'script', 'facebook-jssdk'));
  </script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,productId:String,groupType:Integer): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,productId,groupType)

  def f:((User,String,Integer) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,productId,groupType) => apply(currentUser,productId,groupType)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:41 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/amarket/marketPlace/detail/MarketPlaceDetail.scala.html
                  HASH: 48c926b673babe97053e7ddf4454fd6986cce974
                  MATRIX: 678->1|718->35|763->74|1125->108|1275->163|1302->164|1444->280|1458->286|1514->322|1652->543|1685->620|1718->626|1978->860|1993->866|2063->915|2128->953|2143->959|2241->1035|2307->1074|2322->1080|2412->1149|2478->1188|2493->1194|2555->1235|2620->1273|2635->1279|2719->1342|2785->1381|2800->1387|2882->1448|2947->1486|2962->1492|3051->1560|3124->1607|3138->1612|3216->1669|3248->1674|3548->1947|3563->1953|3613->1982|3643->1985|3686->2006|3723->2015|3760->2030|3834->2077|3849->2083|3906->2119|3936->2122|3981->2145|4018->2154|4055->2169|4102->2189|4161->2239|4200->2240|4245->2257|4300->2285|4315->2291|4378->2333|4408->2336|4450->2356|4489->2377|4555->2434|4594->2435|4639->2452|4694->2480|4709->2486|4774->2530|4804->2533|4847->2554|4898->2574|4939->2587|6225->3846|6271->3871|6341->3914|6356->3920|6423->3966|6600->4116|6640->4135|6808->4276|6849->4296|7470->4890|7508->4907|7944->5316|7995->5345|8407->5730|8448->5750|8861->6135|8904->6156|9495->6719|9537->6739|9936->7110|9973->7125|10477->7601|10516->7618|11018->8091|11056->8106|11087->8107|11875->8868|11890->8873|11969->8930|12002->8936|12017->8941|12099->9001|12132->9007|12147->9012|12228->9071|12264->9079|12461->9249|12476->9254|12513->9269|12545->9273|12620->9320|12636->9326|12684->9352|12763->9403|12779->9409|12831->9439|12887->9467|12903->9473|12979->9527|13059->9579|13075->9585|13155->9643|13234->9694|13250->9700|13330->9758|13409->9809|13425->9815|13508->9876|13587->9927|13603->9933|13679->9987|13736->10016|13752->10022|13849->10097|13929->10149|13945->10155|14034->10222|14090->10250|14106->10256|14201->10329|14257->10357|14273->10363|14378->10445|14434->10473|14450->10479|14524->10531|14604->10583|14620->10589|14696->10643|14775->10694|14791->10700|14867->10754|14933->10793|14947->10798|14986->10815|15018->10819|15083->10856|15114->10865|15174->10897|15190->10903|15257->10948|15316->10979|15332->10985|15441->11071|15520->11122|15536->11128|15653->11222|15732->11273|15748->11279|15865->11373|16225->11704|16255->11705|16297->11718|16334->11726|16364->11727|16408->11742|16515->11820|16545->11821|16587->11834|16617->11835|16679->11868|16709->11869|16751->11882|17064->12166|17094->12167
                  LINES: 24->1|25->2|26->3|31->4|36->4|37->5|41->9|41->9|41->9|44->12|45->13|47->15|50->18|50->18|50->18|52->20|52->20|52->20|53->21|53->21|53->21|54->22|54->22|54->22|56->24|56->24|56->24|57->25|57->25|57->25|58->26|58->26|58->26|62->30|62->30|62->30|63->31|69->37|69->37|69->37|69->37|69->37|69->37|69->37|70->38|70->38|70->38|70->38|70->38|70->38|70->38|71->39|71->39|71->39|72->40|72->40|72->40|72->40|72->40|72->40|73->41|73->41|73->41|74->42|74->42|74->42|74->42|74->42|74->42|75->43|76->44|97->65|97->65|98->66|98->66|98->66|100->68|100->68|102->70|102->70|114->82|114->82|121->89|121->89|128->96|128->96|135->103|135->103|145->113|145->113|150->118|150->118|158->126|158->126|165->133|165->133|165->133|194->162|194->162|194->162|195->163|195->163|195->163|196->164|196->164|196->164|198->166|203->171|203->171|203->171|205->173|206->174|206->174|206->174|207->175|207->175|207->175|208->176|208->176|208->176|210->178|210->178|210->178|211->179|211->179|211->179|212->180|212->180|212->180|213->181|213->181|213->181|215->183|215->183|215->183|217->185|217->185|217->185|218->186|218->186|218->186|219->187|219->187|219->187|220->188|220->188|220->188|222->190|222->190|222->190|223->191|223->191|223->191|225->193|225->193|225->193|227->195|228->196|228->196|229->197|229->197|229->197|231->199|231->199|231->199|232->200|232->200|232->200|233->201|233->201|233->201|243->211|243->211|244->212|244->212|244->212|245->213|247->215|247->215|248->216|248->216|250->218|250->218|251->219|256->224|256->224
                  -- GENERATED --
              */
          