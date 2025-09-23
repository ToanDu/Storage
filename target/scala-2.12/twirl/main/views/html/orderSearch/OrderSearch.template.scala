
package views.html.orderSearch

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
/*2.2*/import vn.m2m.common.models.User

object OrderSearch extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.20*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="author" content="Viettel IoT Cloud">
        <meta name="title" content="Viettel IoT Cloud | Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt.">
        <meta name="description" content="Viettel IoT Cloud | Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt. Nền tảng IoT Cloud hàng đầu Việt Nam.">
        <link rel="canonical" href="https://iot.viettel.vn/">
        <meta property="og: locale" content="vi_VN">
        <meta property="og: type" content="website">
        <meta property="og:title" content="Viettel IoT Cloud | Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt.">
        <title>Viettel IoT Cloud | Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt.</title>
        <meta property="og:locale" content="vi_VN">
        <meta property="og:type" content="website">
        <meta name="og:image" content=" https://iot.viettel.vn/assets/images/landingPageTelco/Viettel.svg">
        <meta name="image" property="og:image" content=" https://iot.viettel.vn/assets/images/landingPageTelco/Viettel.svg">
        <link rel="icon" type="image/png" href=""""),_display_(/*22.50*/routes/*22.56*/.Assets.versioned("images/landingPageTelco/Viettel.svg")),format.raw/*22.112*/("""">
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
        <link href='"""),_display_(/*28.22*/routes/*28.28*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*28.77*/("""' type='text/css'>
        <link href=""""),_display_(/*29.22*/routes/*29.28*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*29.103*/("""" rel="stylesheet">

            <!-- CSS Files -->
        <link href=""""),_display_(/*32.22*/routes/*32.28*/.Assets.versioned("stylesheets/landingPage/argon-design-system.css?v=1.2.2")),format.raw/*32.104*/("""" rel="stylesheet" />
        <link href=""""),_display_(/*33.22*/routes/*33.28*/.Assets.versioned("stylesheets/views/orderSearchPage/index.css?v=1.2.2")),format.raw/*33.100*/("""" rel="stylesheet" />
        <link rel="stylesheet" href=""""),_display_(/*34.39*/routes/*34.45*/.Assets.versioned("assets/plugins/notifications/css/lobibox.min.css")),format.raw/*34.114*/("""" />

        <link href=""""),_display_(/*36.22*/routes/*36.28*/.Assets.versioned("assets/plugins/carousel/css/owl.carousel.min.css")),format.raw/*36.97*/("""" rel="stylesheet">
        <link href=""""),_display_(/*37.22*/routes/*37.28*/.Assets.versioned("assets/plugins/carousel/css/owl.theme.default.min.css")),format.raw/*37.102*/("""" rel="stylesheet">
        <link href=""""),_display_(/*38.22*/routes/*38.28*/.Assets.versioned("assets/css/icons.css")),format.raw/*38.69*/("""" rel="stylesheet">


        <link href=""""),_display_(/*41.22*/routes/*41.28*/.Assets.versioned("stylesheets/landingPage/landingPageTelco.css")),format.raw/*41.93*/("""" rel="stylesheet" />
        <script>
                (function(w,d,s,l,i)"""),format.raw/*43.37*/("""{"""),format.raw/*43.38*/("""w[l]=w[l]||[];w[l].push("""),format.raw/*43.62*/("""{"""),format.raw/*43.63*/("""'gtm.start':
                            new Date().getTime(),event:'gtm.js'"""),format.raw/*44.64*/("""}"""),format.raw/*44.65*/(""");var f=d.getElementsByTagName(s)[0],
                        j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
                        'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
                """),format.raw/*47.17*/("""}"""),format.raw/*47.18*/(""")(window,document,'script','dataLayer','GTM-WM56JR3');
        </script>
        <script type="application/ld+json">
    """),format.raw/*50.5*/("""{"""),format.raw/*50.6*/("""
      """),format.raw/*51.7*/(""""context":"https://schema.org",
      "type":"WebSite",
      "author":"""),format.raw/*53.16*/("""{"""),format.raw/*53.17*/(""""type":"Person","name”:”Viette”l Telco Platform"""),format.raw/*53.64*/("""}"""),format.raw/*53.65*/(""",
        "description":"Viettel IoT Cloud là Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt. Quản lý thiết bị, thu thập, xử lý và hiển thị dữ liệu cho giải pháp IoT của bạn. Kết nối vô hạn, mở vạn tiềm năng!",
        "headline":"Viettel IoT Cloud | Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt.",
        "name":"Viettel IoT Cloud ",
        "publisher":"""),format.raw/*57.21*/("""{"""),format.raw/*57.22*/(""""type":"Organization",
          "logo":"""),format.raw/*58.18*/("""{"""),format.raw/*58.19*/(""""type":"ImageObject",
            "url":"https://innoway.vn/assets/images/landingPageTelco/Logo_Viettel.svg""""),format.raw/*59.87*/("""}"""),format.raw/*59.88*/(""",
          "name”:”Viettel IoT Cloud”"""),format.raw/*60.37*/("""}"""),format.raw/*60.38*/(""",
          "sameAs":["https://twitter.com/ViettelInnoway",
            "http://www.linkedin.com/in/viettelinnoway",
            "https://www.facebook.com/innoway.vn",
            "https://www.instagram.com/innoway.vn"
            “https://www.youtube.com/channel/UClr7WnjIVvPKiWmONu4r8zA”],
            "url":"https://iot.viettel.vn/"
            """),format.raw/*67.13*/("""}"""),format.raw/*67.14*/("""
    """),format.raw/*68.5*/("""</script>
        <!-- Google tag (gtag.js) -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=G-S3V6KNSHZZ"></script>

    <script>
            window.dataLayer = window.dataLayer || [];
            function gtag()"""),format.raw/*74.28*/("""{"""),format.raw/*74.29*/("""dataLayer.push(arguments);"""),format.raw/*74.55*/("""}"""),format.raw/*74.56*/("""
            """),format.raw/*75.13*/("""gtag('js', new Date());

            gtag('config', 'G-S3V6KNSHZZ');

    </script>
    </head>

    <body class="order-search-page">
        <div class="wrapper">
            """),_display_(/*84.14*/views/*84.19*/.html.landingPageTelco.LandingPage_navbar(currentUser)),format.raw/*84.73*/("""
            """),format.raw/*85.13*/("""<div class="container">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="breadcrumb-container">
                            <a href=""""),_display_(/*89.39*/routes/*89.45*/.LandingPageController.home()),format.raw/*89.74*/("""" class="">"""),_display_(/*89.86*/Messages("Trang chủ")),format.raw/*89.107*/("""</a>
                            >>
                            <span class="">"""),_display_(/*91.45*/Messages("Tra cứu đơn hàng")),format.raw/*91.73*/("""</span>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-between">
                    <div class="action-panel col-lg-6 col-md-6 mb-4">
                        <div class="input-title">
                            """),_display_(/*98.30*/Messages("Mã đơn hàng")),format.raw/*98.53*/("""
                        """),format.raw/*99.25*/("""</div>
                        <input name="order-code" type="text" class="form-control input-form" initValue="VT20250418HCEQ" maxlength="50"
                            placeholder="VD: 123456">
                        <div class="error-text-result d-none" style="color: #EA0033;">
                            """),_display_(/*103.30*/Messages("Không có thông tin để hiển thị")),format.raw/*103.72*/("""
                        """),format.raw/*104.25*/("""</div>
                        <button type="button" class="btn btn-telco" value="1" onclick="handleOrderSearch()"
                            style="background: #EA0033; color: #FFFFFF;">
                            """),_display_(/*107.30*/Messages("Tra cứu")),format.raw/*107.49*/("""
                        """),format.raw/*108.25*/("""</button>
                    </div>
                    <img src=""""),_display_(/*110.32*/routes/*110.38*/.Assets.versioned("images/order_search.png")),format.raw/*110.82*/("""" class="img-fluid col-lg-4 col-md-4 col-sm-12 col-xs-12" width="435" height="385">
                </div>
                
                <div id="order-search-result" class="info-panel d-none">
                    <div class="panel-title">"""),_display_(/*114.47*/Messages("THÔNG TIN ĐƠN HÀNG")),format.raw/*114.77*/("""</div>
                    <div class="order-info">
                        <div class="left-section">
                            <div class="field">
                                <div class="field-name">"""),_display_(/*118.58*/Messages("Mã đơn hàng:")),format.raw/*118.82*/("""</div>
                                <div class="field-value"></div>
                            </div>
                            <div class="field">
                                <div class="field-name">"""),_display_(/*122.58*/Messages("Loại đơn hàng:")),format.raw/*122.84*/("""</div>
                                <div class="field-value"></div>
                            </div>
                            <div class="field">
                                <div class="field-name">"""),_display_(/*126.58*/Messages("Thời gian đặt hàng:")),format.raw/*126.89*/("""</div>
                                <div class="field-value"></div>
                            </div>
                            <div class="field">
                                <div class="field-name">"""),_display_(/*130.58*/Messages("Trạng thái đơn hàng:")),format.raw/*130.90*/("""</div>
                                <div class="field-value"></div>
                            </div>
                        </div>
                        <div class="right-section">
                            <div class="field">
                                <div class="field-name">"""),_display_(/*136.58*/Messages("Doanh nghiệp:")),format.raw/*136.83*/("""</div>
                                <div class="field-value"></div>
                            </div>
                            <div class="field">
                                <div class="field-name">"""),_display_(/*140.58*/Messages("Người đại diện :")),format.raw/*140.86*/("""</div>
                                <div class="field-value"></div>
                            </div>
                            <div class="field">
                                <div class="field-name">"""),_display_(/*144.58*/Messages("SĐT người đặt hàng:")),format.raw/*144.89*/("""</div>
                                <div class="field-value"></div>
                            </div>
                            <div class="field">
                                <div class="field-name">"""),_display_(/*148.58*/Messages("Địa chỉ nhận hàng:")),format.raw/*148.88*/("""</div>
                                <div class="field-value"></div>
                            </div>
                        </div>
                    </div>
    
                    <div class="table-name">"""),_display_(/*154.46*/Messages("Chi tiết đơn hàng")),format.raw/*154.75*/("""</div>
                    <div class="card" style="border-radius: 8px;">
                        <div id="order-search-table" class="table-responsive">
                            <table class="table table-striped" id="listOrderTable" style="width: 100%;">
                                <thead style="background-color: #FBCCD6;">
                                    <tr>
                                        <th>"""),_display_(/*160.46*/Messages("STT")),format.raw/*160.61*/("""</th>
                                        <th>"""),_display_(/*161.46*/Messages("Gói cước")),format.raw/*161.66*/("""</th>
                                        <th>"""),_display_(/*162.46*/Messages("Số lượng sim")),format.raw/*162.70*/("""</th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                            <table class="table table-striped" id="listChangeSimTable" style="width: 100%; display: none">
                                <thead style="background-color: #FBCCD6;">
                                    <tr>
                                        <th>"""),_display_(/*171.46*/Messages("STT")),format.raw/*171.61*/("""</th>
                                        <th>"""),_display_(/*172.46*/Messages("Số thuê bao")),format.raw/*172.69*/("""</th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                            <h5 id="notiNotData" style="text-align: center;"></h5>
                        </div>
                    </div>
            </div>
        </div>
        <div class="section features-1" style="background-color: #3A3A3A;" id="divlienhe">
                <div class="navbar-container">
                    <div class="row">
                        <div class="col-md-2">
                            <div class="">
                                <img src=""""),_display_(/*188.44*/routes/*188.50*/.Assets.versioned("images/landingPageTelco/viettel.svg")),format.raw/*188.106*/("""" alt="..." class="card-img">
                            </div>
                        </div>
                        <div class="col-md-6 mt-3">
                            <div class="">
                                <span class="footer-text-1">"""),_display_(/*193.62*/Messages("Tổng Công ty Viễn thông Viettel (Viettel Telecom)")),format.raw/*193.123*/("""</span>
                                <br>
                                <span class="footer-text-2">"""),_display_(/*195.62*/Messages("Mã số doanh nghiệp: 0100109106-011 do Sở Kế hoạch và Đầu tư Thành phố Hà Nội cấp lần đầu ngày 18/07/2005, sửa đổi lần thứ 15 ngày 18/12/2018")),format.raw/*195.214*/("""</span>
                                <br>
                                <span class="footer-text-2">"""),_display_(/*197.62*/Messages("Chịu trách nhiệm nội dung: Ông Cao Anh Sơn")),format.raw/*197.116*/("""</span>
                            </div>
                        </div>
                        <div class="col-md-4 mt-4">
                            <div class="">
                                <div>
                                    <a href="" target="_blank">
                                        <a href="mailto:  iot@viettel.com.vn" target="_blank" class="descriptions opacity-8" style="color: #FFFFFF;">"""),_display_(/*204.152*/Messages("Kinh doanh: iot@viettel.com.vn")),format.raw/*204.194*/("""</a>
                                        <a href="tel: 18008044" target="_blank" class="descriptions opacity-8" style="color: #FFFFFF;">"""),_display_(/*205.137*/Messages("18008044")),format.raw/*205.157*/("""</a>
                                    </a>
                                </div>
                                <div style="margin-top: 15px;">
                                    <a href="" target="_blank">
                                        <a href="mailto:  cskh@viettel.com.vn" target="_blank" class="descriptions opacity-8" style="color: #FFFFFF;">"""),_display_(/*210.153*/Messages("CSKH: cskh@viettel.com.vn")),format.raw/*210.190*/("""</a>
                                        <a href="tel: 198" target="_blank" class="descriptions opacity-8" style="color: #FFFFFF;">"""),_display_(/*211.132*/Messages("198")),format.raw/*211.147*/("""</a>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr style="border-top: 1px solid #4D4D4D; width: 1200px; margin: 20px auto;">
                <div class="container">
                    <div class="row" id="footer-menu">
                        <div class="col-md-6">
                            <span class="footer-text-4">"""),_display_(/*222.58*/Messages("Copyright Viettel Telecom 2022")),format.raw/*222.100*/("""</span>
                        </div>
                        <div class="col-md-6" id="center_footer">
                            <span class="footer-text-4">"""),_display_(/*225.58*/Messages("Follow us: ")),format.raw/*225.81*/("""</span>
                            <a href="https://www.facebook.com/innoway.vn/" class="fa fa-facebook-square" target="_blank" style="font-size: 23px; color: #B1B1B1; "></a>
                            <a href="https://twitter.com/VInnoway" class="fa fa-twitter-square" target="_blank" style="font-size: 23px; color: #B1B1B1; margin-left: 10px;"></a>
                            <a href="https://www.instagram.com/innoway.vn/" class="fa fa-instagram" target="_blank" style="font-size: 23px; color: #B1B1B1; margin-left: 10px;"></a>
                        </div>
                    </div>
                </div>
            </div>
        """),_display_(/*233.10*/views/*233.15*/.html.Loading()),format.raw/*233.30*/("""

    """),format.raw/*235.5*/("""</body>
    <script type="text/javascript" src=""""),_display_(/*236.42*/routes/*236.48*/.JsController.jsMessages()),format.raw/*236.74*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*237.42*/routes/*237.48*/.JsController.javascriptRoutes),format.raw/*237.78*/(""""></script>

    <script src=""""),_display_(/*239.19*/routes/*239.25*/.Assets.versioned("javascripts/landingPage/jquery.min.js")),format.raw/*239.83*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*240.19*/routes/*240.25*/.Assets.versioned("javascripts/landingPage/popper.min.js")),format.raw/*240.83*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*241.19*/routes/*241.25*/.Assets.versioned("javascripts/landingPage/bootstrap.min.js")),format.raw/*241.86*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*242.19*/routes/*242.25*/.Assets.versioned("javascripts/views/telco/orderSearch/index.js")),format.raw/*242.90*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*243.19*/routes/*243.25*/.Assets.versioned("javascripts/Loading.js")),format.raw/*243.68*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*244.19*/routes/*244.25*/.Assets.versioned("javascripts/plugins/moment.min.js")),format.raw/*244.79*/("""" type="text/javascript"></script>


    <script src=""""),_display_(/*247.19*/routes/*247.25*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*247.79*/(""""></script>
    <script src=""""),_display_(/*248.19*/routes/*248.25*/.Assets.versioned("javascripts/landingPage/argon-design-system.js?v=1.2.2")),format.raw/*248.100*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*249.19*/routes/*249.25*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*249.92*/(""""></script>
    <script src=""""),_display_(/*250.19*/routes/*250.25*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*250.98*/(""""></script>
    <script src=""""),_display_(/*251.19*/routes/*251.25*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*251.107*/(""""></script>
    <script src=""""),_display_(/*252.19*/routes/*252.25*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*252.77*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*253.19*/routes/*253.25*/.Assets.versioned("javascripts/views/landingPage/landingPageTelco.js6")),format.raw/*253.96*/("""" type="text/javascript"></script>

    <script>
        let isSearchOrder = window.location.pathname === "/tra_cuu_don_hang";
        console.log(window.location.pathname,'window.location.pathname')
        if(isSearchOrder)"""),format.raw/*258.26*/("""{"""),format.raw/*258.27*/("""
            """),format.raw/*259.13*/("""document.getElementById('questions-menu').style.color = "#000000";
            document.getElementById('order-search-menu').style.color = "#525f7f";
        """),format.raw/*261.9*/("""}"""),format.raw/*261.10*/("""
    """),format.raw/*262.5*/("""</script>

    """),_display_(/*264.6*/views/*264.11*/.html.BackToTop()),format.raw/*264.28*/("""
"""),format.raw/*265.1*/("""</html>"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:49 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/orderSearch/OrderSearch.scala.html
                  HASH: 0d24691a4200be5e2a621debf657f5495b73501a
                  MATRIX: 663->1|686->18|1027->52|1140->70|1167->71|2579->1456|2594->1462|2672->1518|3070->1890|3085->1896|3155->1945|3222->1985|3237->1991|3334->2066|3434->2139|3449->2145|3547->2221|3617->2264|3632->2270|3726->2342|3813->2402|3828->2408|3919->2477|3973->2504|3988->2510|4078->2579|4146->2620|4161->2626|4257->2700|4325->2741|4340->2747|4402->2788|4472->2831|4487->2837|4573->2902|4676->2977|4705->2978|4757->3002|4786->3003|4890->3079|4919->3080|5202->3335|5231->3336|5379->3457|5407->3458|5441->3465|5540->3536|5569->3537|5644->3584|5673->3585|6099->3983|6128->3984|6196->4024|6225->4025|6361->4133|6390->4134|6456->4172|6485->4173|6861->4521|6890->4522|6922->4527|7185->4762|7214->4763|7268->4789|7297->4790|7338->4803|7542->4980|7556->4985|7631->5039|7672->5052|7928->5281|7943->5287|7993->5316|8032->5328|8075->5349|8182->5429|8231->5457|8554->5753|8598->5776|8651->5801|8991->6113|9055->6155|9109->6180|9355->6398|9396->6417|9450->6442|9546->6510|9562->6516|9628->6560|9899->6803|9951->6833|10187->7041|10233->7065|10472->7276|10520->7302|10759->7513|10812->7544|11051->7755|11105->7787|11427->8081|11474->8106|11713->8317|11763->8345|12002->8556|12055->8587|12294->8798|12346->8828|12588->9042|12639->9071|13086->9490|13123->9505|13202->9556|13244->9576|13323->9627|13369->9651|13888->10142|13925->10157|14004->10208|14049->10231|14768->10922|14784->10928|14863->10984|15143->11236|15227->11297|15361->11403|15536->11555|15670->11661|15747->11715|16197->12137|16262->12179|16432->12320|16475->12340|16868->12705|16928->12742|17093->12878|17131->12893|17653->13387|17718->13429|17908->13591|17953->13614|18624->14257|18639->14262|18676->14277|18710->14283|18787->14332|18803->14338|18851->14364|18932->14417|18948->14423|19000->14453|19059->14484|19075->14490|19155->14548|19236->14601|19252->14607|19332->14665|19413->14718|19429->14724|19512->14785|19593->14838|19609->14844|19696->14909|19777->14962|19793->14968|19858->15011|19939->15064|19955->15070|20031->15124|20114->15179|20130->15185|20206->15239|20264->15269|20280->15275|20378->15350|20459->15403|20475->15409|20564->15476|20622->15506|20638->15512|20733->15585|20791->15615|20807->15621|20912->15703|20970->15733|20986->15739|21060->15791|21141->15844|21157->15850|21250->15921|21504->16146|21534->16147|21576->16160|21761->16317|21791->16318|21824->16323|21867->16339|21882->16344|21921->16361|21950->16362
                  LINES: 24->1|25->2|30->3|35->3|36->4|54->22|54->22|54->22|60->28|60->28|60->28|61->29|61->29|61->29|64->32|64->32|64->32|65->33|65->33|65->33|66->34|66->34|66->34|68->36|68->36|68->36|69->37|69->37|69->37|70->38|70->38|70->38|73->41|73->41|73->41|75->43|75->43|75->43|75->43|76->44|76->44|79->47|79->47|82->50|82->50|83->51|85->53|85->53|85->53|85->53|89->57|89->57|90->58|90->58|91->59|91->59|92->60|92->60|99->67|99->67|100->68|106->74|106->74|106->74|106->74|107->75|116->84|116->84|116->84|117->85|121->89|121->89|121->89|121->89|121->89|123->91|123->91|130->98|130->98|131->99|135->103|135->103|136->104|139->107|139->107|140->108|142->110|142->110|142->110|146->114|146->114|150->118|150->118|154->122|154->122|158->126|158->126|162->130|162->130|168->136|168->136|172->140|172->140|176->144|176->144|180->148|180->148|186->154|186->154|192->160|192->160|193->161|193->161|194->162|194->162|203->171|203->171|204->172|204->172|220->188|220->188|220->188|225->193|225->193|227->195|227->195|229->197|229->197|236->204|236->204|237->205|237->205|242->210|242->210|243->211|243->211|254->222|254->222|257->225|257->225|265->233|265->233|265->233|267->235|268->236|268->236|268->236|269->237|269->237|269->237|271->239|271->239|271->239|272->240|272->240|272->240|273->241|273->241|273->241|274->242|274->242|274->242|275->243|275->243|275->243|276->244|276->244|276->244|279->247|279->247|279->247|280->248|280->248|280->248|281->249|281->249|281->249|282->250|282->250|282->250|283->251|283->251|283->251|284->252|284->252|284->252|285->253|285->253|285->253|290->258|290->258|291->259|293->261|293->261|294->262|296->264|296->264|296->264|297->265
                  -- GENERATED --
              */
          