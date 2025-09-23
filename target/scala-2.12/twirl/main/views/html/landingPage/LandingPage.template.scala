
package views.html.landingPage

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

object LandingPage extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser: User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.21*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="author" content="Viettel InnoWay">
    <meta name="title" content="Viettel InnoWay | Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt.">
    <meta name="description" content="Viettel InnoWay | Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt. Nền tảng IoT hàng đầu Việt Nam. Nền tảng IoT giá rẻ nhất. Giải pháp IoT. InnoWay là giải pháp thông minh cho mọi nhà phát triển ứng dụng IoT. Quản lý thiết bị, thu thập, xử lý và hiển thị dữ liệu cho giải pháp IoT của bạn. Kết nối vô hạn, mở vạn tiềm năng!">
    <meta name="keywords" content="iot, nen tang iot, internet of things, technology, iot vietnam, nha thong minh, nong trai thong minh, dinh vi thong minh, camera thong minh, nang luong thong minh, quan ly tai san, thanh pho thong minh, van phong thong minh, do thi thong minh, giai phap iot, smarthome, smart home, quan ly xe, dong ho dien thong minh, dong ho nuoc thong minh, vtag viettel, vhome viettel, vtag, vhome, vtracking, v-tracking, vtracking viettel, v-tracking viettel">
    <meta name="og:keywords" content="iot, nen tang iot, internet of things, technology, iot vietnam, nha thong minh, nong trai thong minh, dinh vi thong minh, camera thong minh, nang luong thong minh, quan ly tai san, thanh pho thong minh, van phong thong minh, do thi thong minh, giai phap iot, smarthome, smart home, quan ly xe, dong ho dien thong minh, dong ho nuoc thong minh, vtag viettel, vhome viettel, vtag, vhome, vtracking, v-tracking, vtracking viettel, v-tracking viettel">
    <link rel="canonical" href="https://innoway.vn/">
    <meta property="og:locale" content="vi_VN">
    <meta property="og:type" content="website">
    <meta name="robots" content="index,follow,all">
    <meta property="og:title" content="Viettel InnoWay | Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt.">
    <meta name="title" property="og:title" content="Viettel InnoWay | Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt.">
    <meta property="og:description" content="Viettel InnoWay | Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt. Nền tảng IoT hàng đầu Việt Nam. Nền tảng IoT giá rẻ nhất. Giải pháp IoT. InnoWay là giải pháp thông minh cho mọi nhà phát triển ứng dụng IoT. Quản lý thiết bị, thu thập, xử lý và hiển thị dữ liệu cho giải pháp IoT của bạn. Kết nối vô hạn, mở vạn tiềm năng!">
    <meta name="description" property="og:description" content="Viettel InnoWay | Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt. Nền tảng IoT hàng đầu Việt Nam. Nền tảng IoT giá rẻ nhất. Giải pháp IoT. InnoWay là giải pháp thông minh cho mọi nhà phát triển ứng dụng IoT. Quản lý thiết bị, thu thập, xử lý và hiển thị dữ liệu cho giải pháp IoT của bạn. Kết nối vô hạn, mở vạn tiềm năng!">
    <meta property="og:url" content="https://innoway.vn/">
    <meta property="og:site_name" content="innoway.vn">
    <meta name="og:image" content=" https://innoway.vn/assets/images/login/logo.svg">
    <meta name="image" property="og:image" content=" https://innoway.vn/assets/images/login/logo.svg">
    <title>Viettel InnoWay | Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt.</title>
    <meta name="copyright" content="Viettel InnoWay">
    <meta name="twitter:url" content=" https://innoway.vn/">
    <meta name="twitter:title" content="Viettel InnoWay | Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt.">
    <meta name="twitter:description" content=" Viettel InnoWay | Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt. Nền tảng IoT hàng đầu Việt Nam. Nền tảng IoT giá rẻ nhất. Giải pháp IoT. InnoWay là giải pháp thông minh cho mọi nhà phát triển ứng dụng IoT. Quản lý thiết bị, thu thập, xử lý và hiển thị dữ liệu cho giải pháp IoT của bạn. Kết nối vô hạn, mở vạn tiềm năng!">
    <meta name="twitter:card" content="app">
    <meta name="twitter:site" content=" Tổng Công ty Công nghiệp Công nghệ cao Viettel (VHT)">
    <meta name="twitter:text:title" content="Viettel InnoWay | Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt.">
    <meta name="twitter:description" content=" Viettel InnoWay | Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt. Nền tảng IoT hàng đầu Việt Nam. Nền tảng IoT giá rẻ nhất. Giải pháp IoT. InnoWay là giải pháp thông minh cho mọi nhà phát triển ứng dụng IoT. Quản lý thiết bị, thu thập, xử lý và hiển thị dữ liệu cho giải pháp IoT của bạn. Kết nối vô hạn, mở vạn tiềm năng!">
    <meta name="format-detection" content="telephone=no">
    <meta name="resource-type" content="Document">
    <meta name="distribution" content="Global">
    <meta http-equiv="audience" content="General">
    <meta http-equiv="content-language" content="vi_VN">
    <meta name="revisit-after" content="1 days">
      <!-- Google Tag Manager -->
    <script>
            (function(w,d,s,l,i)"""),format.raw/*44.33*/("""{"""),format.raw/*44.34*/("""w[l]=w[l]||[];w[l].push("""),format.raw/*44.58*/("""{"""),format.raw/*44.59*/("""'gtm.start':
                    new Date().getTime(),event:'gtm.js'"""),format.raw/*45.56*/("""}"""),format.raw/*45.57*/(""");var f=d.getElementsByTagName(s)[0],
                    j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
                    'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
            """),format.raw/*48.13*/("""}"""),format.raw/*48.14*/(""")(window,document,'script','dataLayer','GTM-WM56JR3');
    </script>
      <!-- Your SDK code -->
    <script type="application/ld+json">
    """),format.raw/*52.5*/("""{"""),format.raw/*52.6*/("""
      """),format.raw/*53.7*/(""""context":"https://schema.org",
      "type":"WebSite",
      "author":"""),format.raw/*55.16*/("""{"""),format.raw/*55.17*/(""""type":"Person","name”:”Viette”l InnoWay"""),format.raw/*55.57*/("""}"""),format.raw/*55.58*/(""",
        "description":"Viettel InnoWay là Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt. Quản lý thiết bị, thu thập, xử lý và hiển thị dữ liệu cho giải pháp IoT của bạn. Kết nối vô hạn, mở vạn tiềm năng!",
        "headline":"Viettel InnoWay | Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt.",
        "image":"""),format.raw/*58.17*/("""{"""),format.raw/*58.18*/(""""twitter”:”/assets/images/landingPage/Logo.png",
          "facebook”:”/assets/images/landingPage/Logo.png",
          "url":"https://innoway.vn/assets/images/landingPage/Logo.png",
          "type":"imageObject""""),format.raw/*61.31*/("""}"""),format.raw/*61.32*/(""",
        "name":"Viettel InnoWay ",
        "publisher":"""),format.raw/*63.21*/("""{"""),format.raw/*63.22*/(""""type":"Organization",
          "logo":"""),format.raw/*64.18*/("""{"""),format.raw/*64.19*/(""""type":"ImageObject",
            "url":"https://innoway.vn/assets/images/landingPage/Logo.png""""),format.raw/*65.74*/("""}"""),format.raw/*65.75*/(""",
          "name”:”Viettel InnoWay”"""),format.raw/*66.35*/("""}"""),format.raw/*66.36*/(""",
          "sameAs":["https://twitter.com/ViettelInnoway",
            "http://www.linkedin.com/in/viettelinnoway",
            "https://www.facebook.com/innoway.vn",
            "https://www.instagram.com/innoway.vn"
            “https://www.youtube.com/channel/UClr7WnjIVvPKiWmONu4r8zA”],
            "url":"https://innoway.vn/"
            """),format.raw/*73.13*/("""}"""),format.raw/*73.14*/("""
    """),format.raw/*74.5*/("""</script>
      <!-- End Google Tag Manager -->

    <link rel="icon" type="image/png" href=""""),_display_(/*77.46*/routes/*77.52*/.Assets.versioned("images/logo.jpg")),format.raw/*77.88*/("""">
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='"""),_display_(/*81.18*/routes/*81.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*81.73*/("""' type='text/css'>
    <link href=""""),_display_(/*82.18*/routes/*82.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*82.99*/("""" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
      <!-- CSS Files -->
    <link href=""""),_display_(/*85.18*/routes/*85.24*/.Assets.versioned("stylesheets/landingPage/argon-design-system.css?v=1.2.2")),format.raw/*85.100*/("""" rel="stylesheet" />

    <link rel="stylesheet" href=""""),_display_(/*87.35*/routes/*87.41*/.Assets.versioned("assets/plugins/notifications/css/lobibox.min.css")),format.raw/*87.110*/("""" />
    <link href=""""),_display_(/*88.18*/routes/*88.24*/.Assets.versioned("assets/css/icons.css")),format.raw/*88.65*/("""" rel="stylesheet">

    <link href=""""),_display_(/*90.18*/routes/*90.24*/.Assets.versioned("stylesheets/landingPage/landingPage.css0")),format.raw/*90.85*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*91.18*/routes/*91.24*/.Assets.versioned("stylesheets/landingPage/carousel.css")),format.raw/*91.81*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*92.18*/routes/*92.24*/.Assets.versioned("stylesheets/landingPage/link.css")),format.raw/*92.77*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*93.18*/routes/*93.24*/.Assets.versioned("stylesheets/landingPage/landingPage2.css")),format.raw/*93.85*/("""" rel="stylesheet" />

      <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=G-BSR7287P4E"></script>
    <script>
            window.dataLayer = window.dataLayer || [];
            function gtag()"""),format.raw/*99.28*/("""{"""),format.raw/*99.29*/("""dataLayer.push(arguments);"""),format.raw/*99.55*/("""}"""),format.raw/*99.56*/("""
            """),format.raw/*100.13*/("""gtag('js', new Date());

            gtag('config', 'G-BSR7287P4E');
    </script>
  </head>

  <body class="landing-page">

    """),_display_(/*108.6*/views/*108.11*/.html.landingPage.LandingPage_navbar(currentUser)),format.raw/*108.60*/("""

    """),format.raw/*110.5*/("""<div class="wrapper">

      """),_display_(/*112.8*/views/*112.13*/.html.landingPage.LandingPage_overview()),format.raw/*112.53*/("""

      """),format.raw/*114.7*/("""<div class="">
        <div class="section features-12">
          <div class="container">
            <div class="row" style="margin-top: -15px;" >
              <div class="col-md-7 mx-auto text-center">
                <div class="section features-1" id="">
                  <div class="container">
                    <h3 class="display-3 title21">"""),_display_(/*121.52*/Messages("Nền tảng IoT tốt nhất cho phép bạn xây dựng nguyên mẫu, mở rộng và quản lý các dự án dễ dàng!")),format.raw/*121.157*/("""</h3>
                    <p class="lead title22">"""),_display_(/*122.46*/Messages("Bạn đã sẵn sàng bắt đầu xây dựng các sản phẩm IoT?")),format.raw/*122.108*/("""</p>
                  </div>
                </div>
              </div>
              <div class="col-md-5 mx-auto text-center">
                <div class="section features-1" id="">
                  <div class="container">
                    <a class="btn btn-danger" href=""""),_display_(/*129.54*/routes/*129.60*/.Application.register()),format.raw/*129.83*/("""">"""),_display_(/*129.86*/Messages("Đăng ký ngay!")),format.raw/*129.111*/("""</a>
                    <label style="margin-left: 15px;">"""),_display_(/*130.56*/Messages("hoặc dùng thử ")),format.raw/*130.82*/("""<a class="cursor-pointer" href=""""),_display_(/*130.115*/routes/*130.121*/.AppDebugController.solutionMaketPage()),format.raw/*130.160*/("""" style="text-decoration: underline red; color: red; margin-left: 5px;">"""),_display_(/*130.233*/Messages("Giải pháp mẫu")),format.raw/*130.258*/("""</a></label>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        """),_display_(/*137.10*/views/*137.15*/.html.landingPage.LandingPage_giaiPhap()),format.raw/*137.55*/("""

        """),_display_(/*139.10*/views/*139.15*/.html.landingPage.LandingPage_develop()),format.raw/*139.54*/("""

        """),_display_(/*141.10*/views/*141.15*/.html.landingPage.LandingPage_video()),format.raw/*141.52*/("""

        """),_display_(/*143.10*/views/*143.15*/.html.landingPage.LandingPage_usecase()),format.raw/*143.54*/("""

        """),format.raw/*145.9*/("""<div class="shape" style="background-image: url("""),_display_(/*145.58*/routes/*145.64*/.Assets.versioned("images/landingPage/section3.png")),format.raw/*145.116*/("""); background-size: 100% 100%;">
          <div class="container">
            <div class="row">
              <div class="col-md-6 mt-5">
                <h5 class="display-1 text-white why-title">"""),_display_(/*149.61*/Messages("Tại sao lại chọn InnoWay?")),format.raw/*149.98*/("""</h5>
                <p class="text-white mt-4">"""),_display_(/*150.45*/Messages("Với vai trò tiên phong cung cấp giải pháp IoT toàn diện trong cuộc cách mạng chuyển đổi số Việt, chúng tôi mang đến những lựa chọn tốt nhất, tối ưu nhất dành cho các nhà phát triển các ứng dụng IoT tại Việt Nam.")),format.raw/*150.268*/("""</p>
                <div class="row mt-5 mb-5">
                  <div class="col-md-6" id="text-md">
                    <h6 class="display-3 text-white why-text">"""),_display_(/*153.64*/Messages("1$/năm")),format.raw/*153.82*/("""</h6>
                    <p class="text-white ">"""),_display_(/*154.45*/Messages("Chi phí nền tảng thấp")),format.raw/*154.78*/("""</p>
                  </div>
                  <div class="col-md-6" id="text1-md">
                    <h6 class="display-3 text-white why-text">"""),_display_(/*157.64*/Messages("0.1$/tháng")),format.raw/*157.86*/("""</h6>
                    <p class="text-white ">"""),_display_(/*158.45*/Messages("Chi phí kết nối")),format.raw/*158.72*/("""</p>
                  </div>
                  <div class="col-md-6 mt-4">
                    <h6 class="display-3 text-white why-text">"""),_display_(/*161.64*/Messages("~100ms")),format.raw/*161.82*/("""</h6>
                    <p class="text-white ">"""),_display_(/*162.45*/Messages("Độ trễ xử lý tin")),format.raw/*162.73*/("""</p>
                  </div>
                  <div class="col-md-6 mt-4">
                    <h6 class="display-3 text-white why-text">"""),_display_(/*165.64*/Messages("20triệu/tháng")),format.raw/*165.89*/("""</h6>
                    <p class="text-white ">"""),_display_(/*166.45*/Messages("Chi phí hạ tầng tối thiếu")),format.raw/*166.82*/("""</p>
                  </div>
                </div>
              </div>
              <div class="col-md-6" id="text-md1">
                <div class="row">
                  <div class="col-md-6 mt-5">
                    <div class="card p-4" style="box-shadow: 0px 12px 36px rgba(0, 0, 0, 0.12); border-radius: 15px; height: 100%; ">
                      <img id="card1" src=""""),_display_(/*174.45*/routes/*174.51*/.Assets.versioned("images/landingPage/why1.svg")),format.raw/*174.99*/("""" width="64px">
                      <h3 class="mt-31" style="color: #000000; font-weight: 700; margin-top: 20px;">"""),_display_(/*175.102*/Messages("Đội ngũ hỗ trợ")),format.raw/*175.128*/("""</h3>
                      <p class="mt-card1">"""),_display_(/*176.44*/Messages("Là các chuyên gia, có nhiều kinh nghiệm triển khai các dự án IoT lớn, nắm rõ hạ tầng và am hiểu thị trường Việt Nam.")),format.raw/*176.172*/("""</p>
                    </div>
                  </div>
                  <div class="col-md-6 mt-5">
                    <div class="card p-4" style="box-shadow: 0px 12px 36px rgba(0, 0, 0, 0.12); border-radius: 15px; height: 100%;">
                      <img id="card1" src=""""),_display_(/*181.45*/routes/*181.51*/.Assets.versioned("images/landingPage/why2.svg")),format.raw/*181.99*/("""" width="64px">
                      <h3 class="mt-31" style="color: #000000; font-weight: 700; margin-top: 20px;">"""),_display_(/*182.102*/Messages("Hệ thống linh hoạt ")),format.raw/*182.133*/("""</h3>
                      <p class="mt-card1">"""),_display_(/*183.44*/Messages("Hệ thống cho phép mở rộng hoặc thu gọn đáp ựng mọi nhu cầu với chi phí tối ưu")),format.raw/*183.133*/("""</p>
                    </div>
                  </div>
                  <div class="col-md-6 mt-5">
                    <div class="card p-4" style="box-shadow: 0px 12px 36px rgba(0, 0, 0, 0.12); border-radius: 15px; height: 100%;">
                      <img id="card1" src=""""),_display_(/*188.45*/routes/*188.51*/.Assets.versioned("images/landingPage/why3.svg")),format.raw/*188.99*/("""" width="64px">
                      <h3 class="mt-31" style="color: #000000; font-weight: 700; margin-top: 20px;">"""),_display_(/*189.102*/Messages("Giải pháp mẫu")),format.raw/*189.127*/("""</h3>
                      <p class="mt-card1">"""),_display_(/*190.44*/Messages("Các giải pháp mẫu đa dạng, rút ngắn thời gian phát triển dự án IoT của bạn.")),format.raw/*190.131*/("""</p>
                    </div>
                  </div>
                  <div class="col-md-6 mt-5 why-card-4">
                    <div class="card p-4" style="box-shadow: 0px 12px 36px rgba(0, 0, 0, 0.12); border-radius: 15px; height: 100%;">
                      <img id="card1" src=""""),_display_(/*195.45*/routes/*195.51*/.Assets.versioned("images/landingPage/why4.svg")),format.raw/*195.99*/("""" width="64px">
                      <h3 class="mt-31" style="color: #000000; font-weight: 700; margin-top: 20px;">"""),_display_(/*196.102*/Messages("Tuỳ chỉnh và tích hợp")),format.raw/*196.135*/("""</h3>
                      <p class="mt-card1">"""),_display_(/*197.44*/Messages("Khả năng tuỳ biến và phát triển các tính năng không giới hạn.")),format.raw/*197.117*/("""</p>
                    </div>
                  </div>
                </div>
              </div>

            </div>
          </div>
        </div>

        """),_display_(/*207.10*/views/*207.15*/.html.landingPage.LandingPage_customer()),format.raw/*207.55*/("""

        """),format.raw/*209.17*/("""
        """),format.raw/*210.9*/("""<div class="section features-6 mt-1">
          <div class="container">
            <div class="row">
              <div class="col-lg-6 mx-md-auto">
                <img class="img-product" src=""""),_display_(/*214.48*/routes/*214.54*/.Assets.versioned("images/landingPage/img-vTag.svg")),format.raw/*214.106*/("""" width="100%">
              </div>
              <div class="col-lg-6">
                <div class="info info-horizontal info-hover-primary">
                  <div class="description">
                    <p class="title41">"""),_display_(/*219.41*/Messages("landing4.title1")),format.raw/*219.68*/("""</p>
                    """),format.raw/*220.73*/("""
                    """),format.raw/*221.21*/("""<div style="border-bottom: 1px solid red; width: 80px;"></div>
                  </div>

                </div>
                <div class="info info-horizontal info-hover-primary mt-3">
                  <div class="description">
                    <p class="description opacity-8">"""),_display_(/*227.55*/Messages("landing4.title2")),format.raw/*227.82*/("""</p>
                  </div>
                </div>
                <div class="info info-horizontal info-hover-primary">
                  <div class="description">
                    <button class="btn" style="border: 1.4px solid #EE0033; border-radius: 55px; color: #EE0033; font-size: 18px; font-weight: 500; line-height: 26px;line-height: 26px; " data-bs-toggle="modal" data-bs-target="#downloadVtagModal">
                      """),_display_(/*233.24*/Messages("Tải về ngay")),format.raw/*233.47*/("""<i class="fa fa-long-arrow-down" style="margin-left: 4px;"></i>
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        """),_display_(/*241.10*/views/*241.15*/.html.landingPage.LandingPage_download_vtag()),format.raw/*241.60*/("""

        """),format.raw/*243.22*/("""
        """),format.raw/*244.9*/("""<div class="section features-6 section-smarthome">
          <div class="container">
            <div class="row">
              <div class="col-lg-6">
                <div class="info info-horizontal info-hover-primary">
                  <div class="description">
                    <p class="title41">"""),_display_(/*250.41*/Messages("VHome - Viettel SmartHome")),format.raw/*250.78*/("""</p>
                    <div style="border-bottom: 1px solid red; width: 80px;"></div>
                  </div>

                </div>
                <div class="info info-horizontal info-hover-primary mt-3">
                  <div class="description">
                    <p class="description opacity-8">"""),_display_(/*257.55*/Messages("VHome là ứng dụng giám sát camera, giúp người dùng dễ dàng quản lý từ xa ở mọi nơi bất cứ thời gian nào.")),format.raw/*257.171*/("""</p>
                    <p style="color: #333333; font-weight: 500; font-size: 18px; line-height: 26px;">"""),_display_(/*258.103*/Messages("Các tính năng chính: ")),format.raw/*258.136*/("""</p>
                    <p class="description opacity-8">"""),_display_(/*259.55*/Messages("- Điều khiển thiết bị camera từ xa qua internet.")),format.raw/*259.115*/("""</p>
                    <p class="description opacity-8">"""),_display_(/*260.55*/Messages("- Giao diện thiết kế đơn giản, dễ dàng sử dụng.")),format.raw/*260.114*/("""</p>
                    <p class="description opacity-8">"""),_display_(/*261.55*/Messages("- Hỗ trợ chức năng hẹn giờ, thiết lập kịch bản hoạt động.")),format.raw/*261.124*/("""</p>
                    <p class="description opacity-8">"""),_display_(/*262.55*/Messages("- Server Cloud được đặt tại Viettel, đảm bảo đường truyền ổn định, bảo mật thông tin.")),format.raw/*262.152*/("""</p>
                    <p class="description opacity-8">"""),_display_(/*263.55*/Messages("- Các chức năng mới sẽ được cập nhật liên tục.")),format.raw/*263.113*/("""</p>
                    <p style="color: #333333; font-weight: 500;font-size: 18px; line-height: 26px;">"""),_display_(/*264.102*/Messages("Mục tiêu mà chúng tôi hướng tới: ")),format.raw/*264.147*/("""</p>
                    <p class="description opacity-8">"""),_display_(/*265.55*/Messages("- Cung cấp thiết bị giám sát kiểu dáng đơn giản, sang trọng, dễ sử dụng và lắp đặt.")),format.raw/*265.150*/("""</p>
                    <p class="description opacity-8">"""),_display_(/*266.55*/Messages("- Nghiên cứu và ứng dụng các công nghệ tiên tiến nhất.")),format.raw/*266.121*/("""</p>
                  </div>
                </div>
                <div class="info info-horizontal info-hover-primary">
                  <div class="description">
                    <button class="btn" style="border: 1.4px solid #EE0033; border-radius: 55px; color: #EE0033; font-size: 18px; font-weight: 700; line-height: 26px;line-height: 26px; " data-bs-toggle="modal" data-bs-target="#downloadSmarthomeModal">"""),_display_(/*271.253*/Messages("Tải về ngay")),format.raw/*271.276*/("""<i class="fa fa-long-arrow-down" style="margin-left: 4px;"></i></button>
                  </div>
                </div>
              </div>
              <div class="col-lg-6 mx-md-auto">
                <img class="img-products" src=""""),_display_(/*276.49*/routes/*276.55*/.Assets.versioned("images/landingPage/Img_Vhome.svg")),format.raw/*276.108*/("""" width="100%">
              </div>
            </div>
          </div>
        </div>
        """),_display_(/*281.10*/views/*281.15*/.html.landingPage.LandingPage_download_smarthome()),format.raw/*281.65*/("""

        """),format.raw/*283.18*/("""
        """),format.raw/*284.9*/("""<div class="section features-6 section-fleet">
          <div class="container">
            <div class="row">
              <div class="col-lg-6 mx-md-auto">
                <img class="img-product" src=""""),_display_(/*288.48*/routes/*288.54*/.Assets.versioned("images/landingPage/img-Fleet.svg")),format.raw/*288.107*/("""" width="100%">
              </div>
              <div class="col-lg-6">
                <div class="info info-horizontal info-hover-primary">
                  <div class="description">
                    <p class="title41">"""),_display_(/*293.41*/Messages("Fleet Management - Quản lý đội xe")),format.raw/*293.86*/("""</p>
                    <div style="border-bottom: 1px solid red; width: 80px;"></div>
                  </div>

                </div>
                <div class="info info-horizontal info-hover-primary mt-3">
                  <div class="description">
                    <p class="description opacity-8">"""),_display_(/*300.55*/Messages("Giải pháp hỗ trợ các luồng xử lý bản tin định vị, cảnh báo vùng an toàn, pin yếu, cảnh báo khẩn cấp tới người sử dụng. Người sử dụng cũng có thể cấu hình từ xa cho thiết bị về chu kỳ gửi bản tin, chế độ tiết kiệm năng lượng, chế độ hòa mạng, hoặc cấu hình nhận cảnh báo qua SMS hoặc Notification từ App.")),format.raw/*300.370*/("""</p>
                  </div>
                </div>
                <div class="info info-horizontal info-hover-primary">
                  <div class="description">
                    <a class="btn" style="border: 1.4px solid #EE0033; border-radius: 55px; color: #EE0033;  font-size: 18px; font-weight: 500; line-height: 26px;line-height: 26px;" href=""""),_display_(/*305.190*/routes/*305.196*/.AppDebugController.solutionMaketPage()),format.raw/*305.235*/("""" target="_blank">"""),_display_(/*305.254*/Messages("Xem thêm")),format.raw/*305.274*/("""</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        """),format.raw/*313.28*/("""
        """),format.raw/*314.9*/("""<div class="section features-6 section-mettering">
          <div class="container">
            <div class="row">
              <div class="col-lg-6">
                <div class="info info-horizontal info-hover-primary">
                  <div class="description">
                    <p class="title41">"""),_display_(/*320.41*/Messages("Smart Metering - Đồng hồ điện/nước thông minh")),format.raw/*320.98*/("""</p>
                    <div style="border-bottom: 1px solid red; width: 80px;"></div>
                  </div>

                </div>
                <div class="info info-horizontal info-hover-primary mt-3">
                  <div class="description">
                    <p class="description opacity-8">"""),_display_(/*327.55*/Messages("Giải pháp cung cấp khả năng giám sát và cảnh báo từ xa cũng như cung cấp các công cụ phân tích dữ liệu mạnh mẽ để giúp các công ty và người dùng cá nhân tối ưu hóa mức tiêu thụ năng lượng, nước, khí đốt hoặc nhiên liệu của họ.")),format.raw/*327.293*/("""</p>
                    <p style="color: #333333; font-weight: 500;font-size: 18px; line-height: 26px;">"""),_display_(/*328.102*/Messages("Đồng hồ nước thông minh: ")),format.raw/*328.139*/("""</p>
                    <p class="description opacity-8">"""),_display_(/*329.55*/Messages("Đây là dòng thiết bị tối ưu năng lượng sử dụng, với chu kỳ gửi bản tin hàng ngày hoặc hàng giờ để người sử dụng có thể theo dõi lưu lượng sử dụng, nhận cảnh báo khi có hiện tượng nhảy số thất thường, vấn đề về từ tính, vỡ ống nước, rỏ rỉ nước hoặc cạn nước. Đồng thời nhà quản lý cũng có thể thao tác tổng hợp số nước sử dụng, đặt lại đồng hồ từ xa mà không cần đội ngũ kiểm tra đồng hồ nước định kỳ theo tháng.")),format.raw/*329.478*/("""</p>
                    <p style="color: #333333; font-weight: 500;font-size: 18px; line-height: 26px;">"""),_display_(/*330.102*/Messages("Đồng hồ điện thông minh:")),format.raw/*330.138*/("""</p>
                    <p class="description opacity-8">"""),_display_(/*331.55*/Messages("Hệ thống cung cấp khả năng đo lường tự động và từ xa việc sử dụng điện, kết nối và ngắt kết nối dịch vụ, phát hiện giả mạo, xác định và cách ly sự cố mất điện cũng như giám sát điện áp.")),format.raw/*331.252*/("""</p>
                  </div>
                </div>
                <div class="info info-horizontal info-hover-primary">
                  <div class="description">
                    <a class="btn" style="border: 1.4px solid #EE0033; border-radius: 55px; color: #EE0033; font-weight: 500;font-size: 18px; line-height: 26px; letter-spacing: 1px;" href=""""),_display_(/*336.191*/routes/*336.197*/.AppDebugController.solutionMaketPage()),format.raw/*336.236*/("""" target="_blank">"""),_display_(/*336.255*/Messages("Xem thêm")),format.raw/*336.275*/("""</a>
                  </div>
                </div>
              </div>
              <div class="col-lg-6 mx-md-auto">
                <img class="" src=""""),_display_(/*341.37*/routes/*341.43*/.Assets.versioned("images/landingPage/img_smart_mettering.svg")),format.raw/*341.106*/("""" width="100%">
              </div>
            </div>
          </div>
        </div>

        """),_display_(/*347.10*/views/*347.15*/.html.landingPage.LandingPage_partner()),format.raw/*347.54*/("""

        """),format.raw/*349.9*/("""<div class="section features-1" id="divHoiDap">
          <div class="container">
            <div class="col-md-12 mx-auto text-center">
              <img class="imgQuestion" src=""""),_display_(/*352.46*/routes/*352.52*/.Assets.versioned("images/landingPage/icon009.png")),format.raw/*352.103*/("""">
            </div>
            <div class="col-md-12 mt-5">
              <div class="row">
                <div class="col-lg-12">
                  <div class="accordion my-3" id="accordionExample" style="box-shadow: 0px 12px 44px rgba(13, 38, 59, 0.12); border-radius: 20px;">
                    <div class="card">
                      <div class="card-header" id="heading1" style="background-color: white;">
                        <button class="btn btn-link text-primary text-left question-sometime" id="btn-shows" type="" data-toggle="collapse" data-target="#collapse1" aria-expanded="true" aria-controls="collapse1" onclick="Clickme()">
                          <img id="shows" src=""""),_display_(/*361.49*/routes/*361.55*/.Assets.versioned("images/landingPage/Group_5411.png")),format.raw/*361.109*/("""">
                          <img id="hide" src=""""),_display_(/*362.48*/routes/*362.54*/.Assets.versioned("images/landingPage/Group_5412.png")),format.raw/*362.108*/("""">
                          <span class="text-center question-title">"""),_display_(/*363.69*/Messages("InnoWay là gì?")),format.raw/*363.95*/("""</span>
                        </button>
                      </div>
                      <div id="collapse1" class="collapse show" aria-labelledby="heading1" data-parent="#accordionExample">
                        <div class="card-bodys opacity-8">
                          InnoWay là nền tảng IoT cho phép bạn theo dõi và kiểm soát các thiết bị IoT của mình. Nó phục vụ việc thu thập, truyền tải, phân tích, lưu trữ và mô tả trực quan dữ liệu kết nối từ hệ thống thiết bị của người dùng. Nếu đây là lần đầu tiên bạn trải nghiệm nền tảng này, chúng tôi khuyên bạn nên xem <a href="https://vht-iot.gitbook.io/innoway/" class="use-manual" style="color: #5e72e4">hướng dẫn sử dụng </a> để dễ dàng tìm hiểu các thông tin.
                        </div>
                      </div>
                    </div>

                    <div class="card">
                      <div class="card-header" id="heading2" style="background-color: white;">
                        <button class="btn btn-link text-primary text-left" id="btn-shows1" type="button" data-toggle="collapse" data-target="#collapse2" aria-expanded="false" aria-controls="collapse2" onclick="Clickme1()">
                          <img id="shows1" src=""""),_display_(/*376.50*/routes/*376.56*/.Assets.versioned("images/landingPage/Group_5411.png")),format.raw/*376.110*/("""">
                          <img id="hide1" src=""""),_display_(/*377.49*/routes/*377.55*/.Assets.versioned("images/landingPage/Group_5412.png")),format.raw/*377.109*/("""">
                          <span class="text-center question-title">"""),_display_(/*378.69*/Messages(" Bắt đầu như thế nào?")),format.raw/*378.102*/("""</span>
                        </button>
                      </div>
                      <div id="collapse2" class="collapse" aria-labelledby="heading2" data-parent="#accordionExample">
                        <div class="card-bodys opacity-8">
                        """),_display_(/*383.26*/Messages("Bạn có thể bắt đầu trải nghiệm cùng Innoway bằng cách đăng ký tài khoản trả phí hoặc miễn phí. Thông tin chi tiết, bạn có thể tham khảo tại đây.")),format.raw/*383.182*/("""
                        """),format.raw/*384.25*/("""</div>
                      </div>
                    </div>
                    <div class="horizontal-line"></div>
                    <div class="card">
                      <div class="card-header" id="heading3" style="background-color: white;">
                        <button class="btn btn-link text-primary text-left" id="btn-shows2" type="button" data-toggle="collapse" data-target="#collapse3" aria-expanded="flase" aria-controls="collapse3" onclick="Clickme2()">
                          <img id="shows2" src=""""),_display_(/*391.50*/routes/*391.56*/.Assets.versioned("images/landingPage/Group_5411.png")),format.raw/*391.110*/("""">
                          <img id="hide2" src=""""),_display_(/*392.49*/routes/*392.55*/.Assets.versioned("images/landingPage/Group_5412.png")),format.raw/*392.109*/("""">
                          <span class="text-center question-title">"""),_display_(/*393.69*/Messages(" Tôi có thể làm gì với InnoWay?")),format.raw/*393.112*/("""</span>
                        </button>
                      </div>
                      <div id="collapse3" class="collapse" aria-labelledby="heading3" data-parent="#accordionExample">
                        <div class="card-bodys opacity-8">
                          """),_display_(/*398.28*/Messages("Innoway là nền tảng toàn diện để xây dựng các giải pháp IoT. Với Innoway, bạn có thể (bao gồm nhưng không giới hạn):")),format.raw/*398.156*/("""
                          """),format.raw/*399.27*/("""<label>"""),_display_(/*399.35*/Messages("+ Kết nối, quản lý, giám sát và điều khiển các thiết bị IoT một cách nhanh chóng, thuận tiện")),format.raw/*399.139*/("""</label><br>
                          <label>"""),_display_(/*400.35*/Messages("+ Lựa chọn phương án lưu trữ phù hợp: tại chỗ (on-premise) hoặc đám mây (cloud)")),format.raw/*400.126*/("""</label><br>
                          <label>"""),_display_(/*401.35*/Messages("+ Thiết lập hệ thống báo cáo linh hoạt, trực quan")),format.raw/*401.96*/("""</label><br>
                          <label>"""),_display_(/*402.35*/Messages("Chi tiết vui lòng tham khảo tại đây.")),format.raw/*402.83*/("""</label>
                        </div>
                      </div>
                    </div>
                    <div class="horizontal-line"></div>
                    <div class="card">
                      <div class="card-header" id="heading4" style="background-color: white;">
                        <button class="btn btn-link text-primary text-left" id="btn-shows3" type="button" data-toggle="collapse" data-target="#collapse4" aria-expanded="flase" aria-controls="collapse4"onclick="Clickme3()">
                          <img id="shows3" src=""""),_display_(/*410.50*/routes/*410.56*/.Assets.versioned("images/landingPage/Group_5411.png")),format.raw/*410.110*/("""">
                          <img id="hide3" src=""""),_display_(/*411.49*/routes/*411.55*/.Assets.versioned("images/landingPage/Group_5412.png")),format.raw/*411.109*/("""">
                          <span class="text-center question-title">"""),_display_(/*412.69*/Messages(" Làm thế nào để kết nối thiết bị của tôi?")),format.raw/*412.122*/("""</span>
                        </button>
                      </div>
                      <div id="collapse4" class="collapse" aria-labelledby="heading4" data-parent="#accordionExample">
                        <div class="card-bodys opacity-8">
                        """),_display_(/*417.26*/Messages("Innoway hỗ trợ kết nối cho hầu hết các thiết bị IoT. Để có thể biết rõ cách thức kết nối cho thiết bị của bạn, vui lòng tham khảo tại đây")),format.raw/*417.175*/("""
                        """),format.raw/*418.25*/("""</div>
                      </div>
                    </div>
                    <div class="horizontal-line"></div>
                    <div class="card">
                      <div class="card-header" id="heading5" style="background-color: white;">
                        <button class="btn btn-link text-primary text-left" id="btn-shows4" type="button" data-toggle="collapse" data-target="#collapse5" aria-expanded="flase" aria-controls="collapse5" onclick="Clickme4()">
                          <img id="shows4" src=""""),_display_(/*425.50*/routes/*425.56*/.Assets.versioned("images/landingPage/Group_5411.png")),format.raw/*425.110*/("""">
                          <img id="hide4" src=""""),_display_(/*426.49*/routes/*426.55*/.Assets.versioned("images/landingPage/Group_5412.png")),format.raw/*426.109*/("""">
                          <span class="text-center question-title">"""),_display_(/*427.69*/Messages(" Tôi có cần sử dụng SDK không?")),format.raw/*427.111*/("""</span>
                        </button>
                      </div>
                      <div id="collapse5" class="collapse" aria-labelledby="heading5" data-parent="#accordionExample">
                        <div class="card-bodys opacity-8 mb-3">
                        """),_display_(/*432.26*/Messages("Không, nhiều thiết bị IoT không thể  nhúng SDK của bên thứ ba. Innoway cung cấp API khá đơn giản trên các giao thức IoT phổ biến. Bạn có thể chọn bất kỳ thư viện phía máy khách nào bạn thích hoặc sử dụng thư viện của riêng bạn. Tham khảo thêm tại đây")),format.raw/*432.288*/("""
                        """),format.raw/*433.25*/("""</div>
                      </div>
                    </div>

                  </div>
                </div>
                <div class="col-lg-12 mx-auto text-center">
                  <h3 id="center">"""),_display_(/*440.36*/Messages("Bạn có câu hỏi cần giải đáp?")),format.raw/*440.76*/("""</h3>
                  <label style="font-size: 18px; color: #4F5053;">"""),_display_(/*441.68*/Messages("Hãy để các chuyên gia của chúng tôi hỗ trợ bạn")),format.raw/*441.126*/("""</label><br>
                  <button class="btn mt-4" style="background: #EE0033; border-radius: 28px; color: white;" data-bs-toggle="modal" data-bs-target="#questionModal">"""),_display_(/*442.164*/Messages("Đặt câu hỏi ngay ")),format.raw/*442.193*/("""</button>
                </div>
              </div>
            </div>
          </div>
        </div>

        """),_display_(/*449.10*/views/*449.15*/.html.landingPage.LandingPage_question()),format.raw/*449.55*/("""
      """),format.raw/*450.7*/("""</div>
      """),_display_(/*451.8*/views/*451.13*/.html.landingPage.LandingPage_contact()),format.raw/*451.52*/("""

      """),format.raw/*453.7*/("""<div class="shape4" style="">
        <div class="container">
          <div class="row">
            <div class="col-md-8" id="shape3">
              <div class="content">
                <div class="use-content">
                  <p class="use-content-text">Trở thành nhà phát triển</p>
                </div>
                <div class="img-use">
                  <img class="" src=""""),_display_(/*462.39*/routes/*462.45*/.Assets.versioned("images/landingPage/Rectangle 1.png")),format.raw/*462.100*/("""">
                </div>
              </div>
              <div class="">
                <h3 class="text-use-content" style="color: #FFFFFF;">Sẵn sàng để thử trải nghiệm công việc khác nhau ngay bây giờ ?</h3>
              </div>
              <p class="text-use-content-1">Có được trải nghiệm làm việc tốt nhất mà bạn chưa từng cảm thấy trước đây </p>
              <a class="btn btn-danger radius-30 " href="https://blog.innoway.vn/tuyen-dung" target="_blank">
                """),_display_(/*470.18*/Messages("Tham gia ngay")),format.raw/*470.43*/("""
              """),format.raw/*471.15*/("""</a>
            </div>
            <div class="col-md-4" id="shape3">
              <div class="shape4">
                <img class="shape-img" src=""""),_display_(/*475.46*/routes/*475.52*/.Assets.versioned("images/landingPage/avatar_Dev_IoT.png")),format.raw/*475.110*/("""">
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="shape1" style="">
        <div class="container">
          <div class="row">
            <div class="col-md-8">
              <img class="imglogo" src=""""),_display_(/*485.42*/routes/*485.48*/.Assets.versioned("images/landingPage/Logo.png")),format.raw/*485.96*/("""">
            </div>
            <div class="col-md-2 mt1">
              <p class="text-shape">Hotline miễn phí(24/7)</p>
              <a href="tel: 0869999904" target="_blank" class="descriptionss opacity-8">"""),_display_(/*489.90*/Messages("Hotline: 0869999904")),format.raw/*489.121*/("""</a>
            </div>
            <div class="col-md-2 mt2">
              <p class="text-shape">Chăm sóc khác hàng</p>
              <a href="mailto: innowayviettel.com.vn" target="_blank" class="descriptionsss opacity-8">"""),_display_(/*493.105*/Messages("Email: innoway@viettel.com.vn")),format.raw/*493.146*/("""</a>

            </div>
          </div>
        </div>
      </div>
      <div class="section features-1" style="background-color: #0D2C4A">
        <div class="container">
          <div class="row">
            <div class="col-md-4">
              <div class="info text-white">
                <p class="descriptions opacity-8" style="margin-top: 15px; font-weight: 500;">"""),_display_(/*504.96*/Messages("LIÊN HỆ CHÚNG TÔI ")),format.raw/*504.126*/("""</p>
                <a href="https://goo.gl/maps/swYZ4EVoXY4yB1DJ7" target="_blank" class="descriptions opacity-8" style="margin-top: 15px"><i class="bx bx-location-plus"></i> """),_display_(/*505.174*/Messages("Địa chỉ: 380 Lạc Long Quân, Hà Nội")),format.raw/*505.220*/("""</a>
                <a href="tel: 0869999904" target="_blank" class="descriptions opacity-8"><i class="bx bx-phone"></i>"""),_display_(/*506.118*/Messages("Hotline: 0869999904")),format.raw/*506.149*/("""</a>
                <a href="mailto: innoway@viettel.com.vn" target="_blank" class="descriptions opacity-8"><i class="bx bx-envelope"></i> """),_display_(/*507.138*/Messages("Email: innoway@viettel.com.vn")),format.raw/*507.179*/("""</a>
              </div>
            </div>
            <div class="col-md-2">
              <div class="info text-white">
                <p class="descriptions opacity-8" style="margin-top: 15px; font-weight: 500;">"""),_display_(/*512.96*/Messages("INNOWAY ")),format.raw/*512.116*/("""</p>
                <a class="descriptions opacity-8" style="margin-top: 15px" href="https://blog.innoway.vn/gioi-thieu" target="_blank">"""),_display_(/*513.135*/Messages("Giới thiệu")),format.raw/*513.157*/("""</a>
                <a class="descriptions opacity-8" style="margin-top: 15px" href="https://innoway.vn/registerDeveloper" target="_blank">"""),_display_(/*514.137*/Messages("Hợp tác")),format.raw/*514.156*/("""</a>
                <a class="descriptions opacity-8" style="margin-top: 15px" href="https://blog.innoway.vn/tuyen-dung" target="_blank" >"""),_display_(/*515.136*/Messages("Tuyển dụng ")),format.raw/*515.159*/("""</a>
                <a class="descriptions opacity-8" style="margin-top: 15px" href="https://blog.innoway.vn/lien-he" target="_blank">"""),_display_(/*516.132*/Messages("Liên hệ")),format.raw/*516.151*/("""</a>
              </div>
            </div>
            <div class="col-md-2">
              <div class="info text-white">
                <p class="description opacity-8" style="margin-top: 15px; font-weight: 500;">"""),_display_(/*521.95*/Messages("DEVELOPERS ")),format.raw/*521.118*/("""</p>
                <a href="https://vht-iot.gitbook.io/innoway/" target="_bank" class="descriptions opacity-8" style="margin-top: 15px">"""),_display_(/*522.135*/Messages("Hướng dẫn sử dụng")),format.raw/*522.164*/("""</a>
                """),_display_(/*523.18*/if(currentUser != null)/*523.41*/{_display_(Seq[Any](format.raw/*523.42*/("""
                  """),format.raw/*524.19*/("""<a href=""""),_display_(/*524.29*/routes/*524.35*/.ProjectController.project()),format.raw/*524.63*/("""" class="descriptions opacity-8" style="margin-top: 15px">"""),_display_(/*524.122*/Messages("Bắt đầu 1 dự án mới")),format.raw/*524.153*/("""</a>
                """)))}/*525.19*/else/*525.24*/{_display_(Seq[Any](format.raw/*525.25*/("""
                  """),format.raw/*526.19*/("""<a href="#" onclick="notiMustLogin()" class="descriptions opacity-8" style="margin-top: 15px">"""),_display_(/*526.114*/Messages("Bắt đầu 1 dự án")),format.raw/*526.141*/("""</a>
                """)))}),format.raw/*527.18*/("""
                """),format.raw/*528.17*/("""<a href=""""),_display_(/*528.27*/routes/*528.33*/.AppDebugController.solutionMaketPage()),format.raw/*528.72*/("""" target="_blank" class="descriptions opacity-8" style="margin-top: 15px">"""),_display_(/*528.147*/Messages("App SDK")),format.raw/*528.166*/("""</a>
                <a href=""""),_display_(/*529.27*/routes/*529.33*/.AppDebugController.appDebugPage()),format.raw/*529.67*/("""" target="_blank" class="descriptions opacity-8" style="margin-top: 15px">"""),_display_(/*529.142*/Messages("Vsmart Debug")),format.raw/*529.166*/("""</a>
              </div>
            </div>
            <div class="col-md-4">
              <div class="info text-white">
                <p class="descriptions opacity-8" style="margin-top: 15px; font-weight: 500;">"""),_display_(/*534.96*/Messages("NHẬN TIN TỨC ")),format.raw/*534.121*/("""</p>
                <p class="descriptionss opacity-8" style="margin-top: 15px">"""),_display_(/*535.78*/Messages("Đăng ký ngay để nhận thông tin từ InnoWay.vn")),format.raw/*535.134*/("""</p>
                <form class="email">
                  <input type="text" name="email" class="form-control" placeholder="Nhập email">
                  <i class='bx bx-right-arrow-alt' onclick="notiSendMail()" style="width: 40px; height: 36px; right: 8px; top: 4px; border-radius: 4px;" ></i>
                </form>
                <p style="font-size"></p>
                <a href="https://www.facebook.com/innoway.vn/" class="fa fa-facebook-square" target="_blank" style="font-size: 23px; color: red; "></a>
                <a href="https://twitter.com/VInnoway" class="fa fa-twitter-square" target="_blank" style="font-size: 23px; color: red; margin-left: 10px;"></a>
                <a href="https://www.youtube.com/channel/UClr7WnjIVvPKiWmONu4r8zA" class="fa fa-youtube-square" target="_blank" style="font-size: 23px; color: red; margin-left: 10px;"></a>
                <a href="https://www.instagram.com/innoway.vn/" class="fa fa-instagram" target="_blank" style="font-size: 23px; color: red; margin-left: 10px;"></a>
                <p class="description opacity-8" style="margin-top: 15px"></p>
              </div>
            </div>
          </div>
        </div>
      </div>
      """),_display_(/*551.8*/views/*551.13*/.html.Loading()),format.raw/*551.28*/("""

      """),_display_(/*553.8*/views/*553.13*/.html.landingPage.LandingPage_iconLink()),format.raw/*553.53*/("""

    """),format.raw/*555.5*/("""</div>
  </body>
  <script type="text/javascript" src=""""),_display_(/*557.40*/routes/*557.46*/.JsController.jsMessages()),format.raw/*557.72*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*558.40*/routes/*558.46*/.JsController.javascriptRoutes),format.raw/*558.76*/(""""></script>
  <script src=""""),_display_(/*559.17*/routes/*559.23*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*559.77*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*561.17*/routes/*561.23*/.Assets.versioned("javascripts/landingPage/jquery.min.js")),format.raw/*561.81*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*562.17*/routes/*562.23*/.Assets.versioned("javascripts/landingPage/popper.min.js")),format.raw/*562.81*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*563.17*/routes/*563.23*/.Assets.versioned("javascripts/landingPage/bootstrap.min.js")),format.raw/*563.84*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*564.17*/routes/*564.23*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*564.77*/(""""></script>
  <script src=""""),_display_(/*565.17*/routes/*565.23*/.Assets.versioned("javascripts/landingPage/landingPage.js")),format.raw/*565.82*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*566.17*/routes/*566.23*/.Assets.versioned("javascripts/landingPage/argon-design-system.js?v=1.2.2")),format.raw/*566.98*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*568.17*/routes/*568.23*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*568.90*/(""""></script>
  <script src=""""),_display_(/*569.17*/routes/*569.23*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*569.96*/(""""></script>
  <script src=""""),_display_(/*570.17*/routes/*570.23*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*570.105*/(""""></script>
  <script src=""""),_display_(/*571.17*/routes/*571.23*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*571.75*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*573.17*/routes/*573.23*/.Assets.versioned("javascripts/views/landingPage/landingPage.js")),format.raw/*573.88*/("""" type="text/javascript"></script>

  """),_display_(/*575.4*/views/*575.9*/.html.BackToTop()),format.raw/*575.26*/("""

  """),format.raw/*577.3*/("""<script>
          var chatbox = document.getElementById('fb-customer-chat');
          chatbox.setAttribute("page_id", "105733635516877");
          chatbox.setAttribute("attribution", "biz_inbox");
  </script>

    <!-- Your SDK code -->
  <script>
          window.fbAsyncInit = function() """),format.raw/*585.43*/("""{"""),format.raw/*585.44*/("""
            """),format.raw/*586.13*/("""FB.init("""),format.raw/*586.21*/("""{"""),format.raw/*586.22*/("""
              """),format.raw/*587.15*/("""xfbml            : true,
              version          : 'v14.0'
            """),format.raw/*589.13*/("""}"""),format.raw/*589.14*/(""");
          """),format.raw/*590.11*/("""}"""),format.raw/*590.12*/(""";
          (function(d, s, id) """),format.raw/*591.31*/("""{"""),format.raw/*591.32*/("""
            """),format.raw/*592.13*/("""var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) return;
            js = d.createElement(s); js.id = id;
            js.src = 'https://connect.facebook.net/vi_VN/sdk/xfbml.customerchat.js';
            fjs.parentNode.insertBefore(js, fjs);
          """),format.raw/*597.11*/("""}"""),format.raw/*597.12*/("""(document, 'script', 'facebook-jssdk'));
  </script>

  <style id="antiClickjack">body"""),format.raw/*600.33*/("""{"""),format.raw/*600.34*/("""display:none !important;"""),format.raw/*600.58*/("""}"""),format.raw/*600.59*/("""</style>
  <script type="text/javascript">
          if (self === top) """),format.raw/*602.29*/("""{"""),format.raw/*602.30*/("""
            """),format.raw/*603.13*/("""var antiClickjack = document.getElementById("antiClickjack");
            antiClickjack.parentNode.removeChild(antiClickjack);
          """),format.raw/*605.11*/("""}"""),format.raw/*605.12*/(""" """),format.raw/*605.13*/("""else """),format.raw/*605.18*/("""{"""),format.raw/*605.19*/("""
            """),format.raw/*606.13*/("""top.location = self.location;
          """),format.raw/*607.11*/("""}"""),format.raw/*607.12*/("""
  """),format.raw/*608.3*/("""</script>
</html>"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:47 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPage/LandingPage.scala.html
                  HASH: 264a020145e9679199099eaae92a0b7ecaee6c0c
                  MATRIX: 663->1|686->18|1027->52|1141->71|1168->72|6311->5187|6340->5188|6392->5212|6421->5213|6517->5281|6546->5282|6817->5525|6846->5526|7015->5668|7043->5669|7077->5676|7176->5747|7205->5748|7273->5788|7302->5789|7683->6142|7712->6143|7952->6355|7981->6356|8066->6413|8095->6414|8163->6454|8192->6455|8315->6550|8344->6551|8408->6587|8437->6588|8809->6932|8838->6933|8870->6938|8991->7032|9006->7038|9063->7074|9334->7318|9349->7324|9419->7373|9482->7409|9497->7415|9593->7490|9791->7662|9806->7668|9904->7744|9988->7801|10003->7807|10094->7876|10143->7898|10158->7904|10220->7945|10285->7983|10300->7989|10382->8050|10448->8089|10463->8095|10541->8152|10607->8191|10622->8197|10696->8250|10762->8289|10777->8295|10859->8356|11156->8625|11185->8626|11239->8652|11268->8653|11310->8666|11467->8796|11482->8801|11553->8850|11587->8856|11644->8886|11659->8891|11721->8931|11757->8939|12139->9293|12267->9398|12346->9449|12431->9511|12740->9792|12756->9798|12801->9821|12832->9824|12880->9849|12968->9909|13016->9935|13078->9968|13095->9974|13157->10013|13259->10086|13307->10111|13477->10253|13492->10258|13554->10298|13593->10309|13608->10314|13669->10353|13708->10364|13723->10369|13782->10406|13821->10417|13836->10422|13897->10461|13935->10471|14012->10520|14028->10526|14103->10578|14330->10777|14389->10814|14467->10864|14713->11087|14907->11253|14947->11271|15025->11321|15080->11354|15256->11502|15300->11524|15378->11574|15427->11601|15594->11740|15634->11758|15712->11808|15762->11836|15929->11975|15976->12000|16054->12050|16113->12087|16524->12470|16540->12476|16610->12524|16756->12641|16805->12667|16882->12716|17033->12844|17341->13124|17357->13130|17427->13178|17573->13295|17627->13326|17704->13375|17816->13464|18124->13744|18140->13750|18210->13798|18356->13915|18404->13940|18481->13989|18591->14076|18910->14367|18926->14373|18996->14421|19142->14538|19198->14571|19275->14620|19371->14693|19562->14856|19577->14861|19639->14901|19678->14919|19715->14928|19940->15125|19956->15131|20031->15183|20287->15411|20336->15438|20390->15515|20440->15536|20753->15821|20802->15848|21267->16285|21312->16308|21563->16531|21578->16536|21645->16581|21684->16604|21721->16613|22055->16919|22114->16956|22452->17266|22591->17382|22727->17489|22783->17522|22870->17581|22953->17641|23040->17700|23122->17759|23209->17818|23301->17887|23388->17946|23508->18043|23595->18102|23676->18160|23811->18266|23879->18311|23966->18370|24084->18465|24171->18524|24260->18590|24708->19009|24754->19032|25020->19270|25036->19276|25112->19329|25237->19426|25252->19431|25324->19481|25363->19500|25400->19509|25634->19715|25650->19721|25726->19774|25982->20002|26049->20047|26387->20357|26725->20672|27110->21028|27127->21034|27189->21073|27237->21092|27280->21112|27443->21265|27480->21274|27814->21580|27893->21637|28231->21947|28492->22185|28627->22291|28687->22328|28774->22387|29220->22810|29355->22916|29414->22952|29501->23011|29721->23208|30107->23565|30124->23571|30186->23610|30234->23629|30277->23649|30463->23807|30479->23813|30565->23876|30691->23974|30706->23979|30767->24018|30805->24028|31016->24211|31032->24217|31106->24268|31832->24966|31848->24972|31925->25026|32003->25076|32019->25082|32096->25136|32195->25207|32243->25233|33490->26452|33506->26458|33583->26512|33662->26563|33678->26569|33755->26623|33854->26694|33910->26727|34212->27001|34391->27157|34445->27182|34999->27708|35015->27714|35092->27768|35171->27819|35187->27825|35264->27879|35363->27950|35429->27993|35733->28269|35884->28397|35940->28424|35976->28432|36103->28536|36178->28583|36292->28674|36367->28721|36450->28782|36525->28829|36595->28877|37181->29435|37197->29441|37274->29495|37353->29546|37369->29552|37446->29606|37545->29677|37621->29730|37923->30004|38095->30153|38149->30178|38703->30704|38719->30710|38796->30764|38875->30815|38891->30821|38968->30875|39067->30946|39132->30988|39439->31267|39724->31529|39778->31554|40013->31761|40075->31801|40176->31874|40257->31932|40462->32108|40514->32137|40657->32252|40672->32257|40734->32297|40769->32304|40810->32318|40825->32323|40886->32362|40922->32370|41339->32759|41355->32765|41433->32820|41945->33304|41992->33329|42036->33344|42215->33495|42231->33501|42312->33559|42600->33819|42616->33825|42686->33873|42927->34086|42981->34117|43236->34343|43300->34384|43705->34761|43758->34791|43965->34969|44034->35015|44185->35137|44239->35168|44409->35310|44473->35351|44720->35570|44763->35590|44931->35729|44976->35751|45146->35892|45188->35911|45357->36051|45403->36074|45568->36210|45610->36229|45856->36447|45902->36470|46070->36609|46122->36638|46172->36660|46205->36683|46245->36684|46293->36703|46331->36713|46347->36719|46397->36747|46485->36806|46539->36837|46581->36860|46595->36865|46635->36866|46683->36885|46807->36980|46857->37007|46911->37029|46957->37046|46995->37056|47011->37062|47072->37101|47176->37176|47218->37195|47277->37226|47293->37232|47349->37266|47453->37341|47500->37365|47747->37584|47795->37609|47905->37691|47984->37747|49213->38949|49228->38954|49265->38969|49301->38978|49316->38983|49378->39023|49412->39029|49496->39085|49512->39091|49560->39117|49639->39168|49655->39174|49707->39204|49763->39232|49779->39238|49855->39292|49935->39344|49951->39350|50031->39408|50110->39459|50126->39465|50206->39523|50285->39574|50301->39580|50384->39641|50463->39692|50479->39698|50555->39752|50611->39780|50627->39786|50708->39845|50787->39896|50803->39902|50900->39977|50980->40029|50996->40035|51085->40102|51141->40130|51157->40136|51252->40209|51308->40237|51324->40243|51429->40325|51485->40353|51501->40359|51575->40411|51655->40463|51671->40469|51758->40534|51824->40573|51838->40578|51877->40595|51909->40599|52231->40892|52261->40893|52303->40906|52340->40914|52370->40915|52414->40930|52521->41008|52551->41009|52593->41022|52623->41023|52684->41055|52714->41056|52756->41069|53069->41353|53099->41354|53214->41440|53244->41441|53297->41465|53327->41466|53427->41537|53457->41538|53499->41551|53665->41688|53695->41689|53725->41690|53759->41695|53789->41696|53831->41709|53900->41749|53930->41750|53961->41753
                  LINES: 24->1|25->2|30->3|35->3|36->4|76->44|76->44|76->44|76->44|77->45|77->45|80->48|80->48|84->52|84->52|85->53|87->55|87->55|87->55|87->55|90->58|90->58|93->61|93->61|95->63|95->63|96->64|96->64|97->65|97->65|98->66|98->66|105->73|105->73|106->74|109->77|109->77|109->77|113->81|113->81|113->81|114->82|114->82|114->82|117->85|117->85|117->85|119->87|119->87|119->87|120->88|120->88|120->88|122->90|122->90|122->90|123->91|123->91|123->91|124->92|124->92|124->92|125->93|125->93|125->93|131->99|131->99|131->99|131->99|132->100|140->108|140->108|140->108|142->110|144->112|144->112|144->112|146->114|153->121|153->121|154->122|154->122|161->129|161->129|161->129|161->129|161->129|162->130|162->130|162->130|162->130|162->130|162->130|162->130|169->137|169->137|169->137|171->139|171->139|171->139|173->141|173->141|173->141|175->143|175->143|175->143|177->145|177->145|177->145|177->145|181->149|181->149|182->150|182->150|185->153|185->153|186->154|186->154|189->157|189->157|190->158|190->158|193->161|193->161|194->162|194->162|197->165|197->165|198->166|198->166|206->174|206->174|206->174|207->175|207->175|208->176|208->176|213->181|213->181|213->181|214->182|214->182|215->183|215->183|220->188|220->188|220->188|221->189|221->189|222->190|222->190|227->195|227->195|227->195|228->196|228->196|229->197|229->197|239->207|239->207|239->207|241->209|242->210|246->214|246->214|246->214|251->219|251->219|252->220|253->221|259->227|259->227|265->233|265->233|273->241|273->241|273->241|275->243|276->244|282->250|282->250|289->257|289->257|290->258|290->258|291->259|291->259|292->260|292->260|293->261|293->261|294->262|294->262|295->263|295->263|296->264|296->264|297->265|297->265|298->266|298->266|303->271|303->271|308->276|308->276|308->276|313->281|313->281|313->281|315->283|316->284|320->288|320->288|320->288|325->293|325->293|332->300|332->300|337->305|337->305|337->305|337->305|337->305|345->313|346->314|352->320|352->320|359->327|359->327|360->328|360->328|361->329|361->329|362->330|362->330|363->331|363->331|368->336|368->336|368->336|368->336|368->336|373->341|373->341|373->341|379->347|379->347|379->347|381->349|384->352|384->352|384->352|393->361|393->361|393->361|394->362|394->362|394->362|395->363|395->363|408->376|408->376|408->376|409->377|409->377|409->377|410->378|410->378|415->383|415->383|416->384|423->391|423->391|423->391|424->392|424->392|424->392|425->393|425->393|430->398|430->398|431->399|431->399|431->399|432->400|432->400|433->401|433->401|434->402|434->402|442->410|442->410|442->410|443->411|443->411|443->411|444->412|444->412|449->417|449->417|450->418|457->425|457->425|457->425|458->426|458->426|458->426|459->427|459->427|464->432|464->432|465->433|472->440|472->440|473->441|473->441|474->442|474->442|481->449|481->449|481->449|482->450|483->451|483->451|483->451|485->453|494->462|494->462|494->462|502->470|502->470|503->471|507->475|507->475|507->475|517->485|517->485|517->485|521->489|521->489|525->493|525->493|536->504|536->504|537->505|537->505|538->506|538->506|539->507|539->507|544->512|544->512|545->513|545->513|546->514|546->514|547->515|547->515|548->516|548->516|553->521|553->521|554->522|554->522|555->523|555->523|555->523|556->524|556->524|556->524|556->524|556->524|556->524|557->525|557->525|557->525|558->526|558->526|558->526|559->527|560->528|560->528|560->528|560->528|560->528|560->528|561->529|561->529|561->529|561->529|561->529|566->534|566->534|567->535|567->535|583->551|583->551|583->551|585->553|585->553|585->553|587->555|589->557|589->557|589->557|590->558|590->558|590->558|591->559|591->559|591->559|593->561|593->561|593->561|594->562|594->562|594->562|595->563|595->563|595->563|596->564|596->564|596->564|597->565|597->565|597->565|598->566|598->566|598->566|600->568|600->568|600->568|601->569|601->569|601->569|602->570|602->570|602->570|603->571|603->571|603->571|605->573|605->573|605->573|607->575|607->575|607->575|609->577|617->585|617->585|618->586|618->586|618->586|619->587|621->589|621->589|622->590|622->590|623->591|623->591|624->592|629->597|629->597|632->600|632->600|632->600|632->600|634->602|634->602|635->603|637->605|637->605|637->605|637->605|637->605|638->606|639->607|639->607|640->608
                  -- GENERATED --
              */
          