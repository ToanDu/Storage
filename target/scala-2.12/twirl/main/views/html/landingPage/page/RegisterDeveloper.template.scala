
package views.html.landingPage.page

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

object RegisterDeveloper extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.20*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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

    <link rel="icon" type="image/png" href=""""),_display_(/*44.46*/routes/*44.52*/.Assets.versioned("images/logo.jpg")),format.raw/*44.88*/("""">
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='"""),_display_(/*48.18*/routes/*48.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*48.73*/("""' type='text/css'>
    <link href=""""),_display_(/*49.18*/routes/*49.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*49.99*/("""" rel="stylesheet">
    """),format.raw/*50.114*/("""
      """),format.raw/*51.7*/("""<!-- CSS Files -->
    <link href=""""),_display_(/*52.18*/routes/*52.24*/.Assets.versioned("stylesheets/landingPage/argon-design-system.css?v=1.2.2")),format.raw/*52.100*/("""" rel="stylesheet" />

    <link rel="stylesheet" href=""""),_display_(/*54.35*/routes/*54.41*/.Assets.versioned("assets/plugins/notifications/css/lobibox.min.css")),format.raw/*54.110*/("""" />
    <link href=""""),_display_(/*55.18*/routes/*55.24*/.Assets.versioned("assets/css/icons.css")),format.raw/*55.65*/("""" rel="stylesheet">

    <link href=""""),_display_(/*57.18*/routes/*57.24*/.Assets.versioned("stylesheets/landingPage/landingPage.css")),format.raw/*57.84*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*58.18*/routes/*58.24*/.Assets.versioned("stylesheets/landingPage/carousel.css")),format.raw/*58.81*/("""" rel="stylesheet" />

    <link href=""""),_display_(/*60.18*/routes/*60.24*/.Assets.versioned("stylesheets/landingPage/registerSI.css")),format.raw/*60.83*/("""" rel="stylesheet" />

  </head>

  <body class="landing-page">

    """),_display_(/*66.6*/views/*66.11*/.html.landingPage.page.RegisterDeveloper_navbar(currentUser)),format.raw/*66.71*/("""

    """),format.raw/*68.5*/("""<div class="wrapper">

      <div class="modal-body" style="margin-top: 5rem !important;">
        <div class="section features-1" style="padding-bottom: 1rem;">
          <div class="container" style="text-align: center">
            <span class="si-title">"""),_display_(/*73.37*/Messages("Lợi ích khi đăng ký trở thành Nhà tích hợp - Nhà phát triển")),format.raw/*73.108*/("""</span>
          </div>
        </div>
      </div>
      <div class="modal-body" style="background-color: #EE0033;">
        <div class="features-1" style="padding-bottom: 1rem;">
          <div class="container">
            <div class="row" >
              <div class="col-md-3">
                <h4 class="si-container-1">"""),_display_(/*82.45*/Messages("30%")),format.raw/*82.60*/("""</h4>
                <h6 class="si-container-2">"""),_display_(/*83.45*/Messages("Được hưởng chiết khấu cao lên đến 30%")),format.raw/*83.94*/("""</h6>
              </div>
              <div class="col-md-3">
                <h4 class="si-container-1">"""),_display_(/*86.45*/Messages("1.000$")),format.raw/*86.63*/("""</h4>
                <h6 class="si-container-2">"""),_display_(/*87.45*/Messages("Nhận ngay 1.000$ tiền hoa hồng khi giới thiệu đối tác")),format.raw/*87.110*/("""</h6>
              </div>
              <div class="col-md-3">
                <h4 class="si-container-1">"""),_display_(/*90.45*/Messages("180")),format.raw/*90.60*/("""</h4>
                <h6 class="si-container-2">"""),_display_(/*91.45*/Messages("Tặng tài khoản V.I.P lên đến 180 ngày")),format.raw/*91.94*/("""</h6>
              </div>
              <div class="col-md-3">
                <h4 class="si-container-1">"""),_display_(/*94.45*/Messages("24/7")),format.raw/*94.61*/("""</h4>
                <h6 class="si-container-2">"""),_display_(/*95.45*/Messages("Đào tạo kiến thức và hỗ trợ kỹ thuật nhiệt tình 24/7")),format.raw/*95.109*/("""</h6>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="modal-body">
        <div class="section features-1" style="margin-bottom: 1rem;">
          <div class="container">
            <div class="row">
              <div class="col-md-3"></div>
              <div class="col-md-6">

                <ul id="steps-native" class="step" hidden></ul>
                <form id="wizard-native" class="my-2 py-2">
                  <section data-step="coords">
                    <div class="row mt-2 ml-1 si-form-title">
                      <h6>"""),_display_(/*112.28*/Messages("Đăng ký trở thành Nhà tích hợp / Nhà phát triển ngay hôm nay để nhận những thông tin và ưu đãi lớn nhất từ Nền tảng InnoWay.vn")),format.raw/*112.166*/("""</h6>
                    </div>
                    <div class="mt-3">
                      <label class="si-form-title-1">"""),_display_(/*115.55*/Messages("Thông tin của bạn")),format.raw/*115.84*/("""</label>
                    </div>
                    <div class="row mt-3 ml-1">
                      <label class="col-form-label">"""),_display_(/*118.54*/Messages("Vai trò")),format.raw/*118.73*/("""<span class="text-danger">"""),_display_(/*118.100*/Messages(" *")),format.raw/*118.114*/("""</span></label>
                      <div class="col-sm-12 p-0">
                        <input id="roleRegister" type="text" class="form-control" autocomplete="off" placeholder="Nhà tích hợp, Nhà phát triển" required minlength="1" maxlength="100">
                      </div>
                    </div>
                    <div class="row mt-1 ml-1">
                      <label class="col-form-label">"""),_display_(/*124.54*/Messages("Lĩnh vực phát triển")),format.raw/*124.85*/("""<span class="text-danger">"""),_display_(/*124.112*/Messages(" *")),format.raw/*124.126*/("""</span></label>
                      <div class="col-sm-12 p-0">
                        <input id="fieldRegister" type="text" class="form-control" autocomplete="off" placeholder="Nhà thông minh, nông trại thông minh, ..." required minlength="1" maxlength="100">
                      </div>
                    </div>
                    <div class="row mt-1 ml-1">
                      <label class="col-form-label">"""),_display_(/*130.54*/Messages("Số lượng thiết bị")),format.raw/*130.83*/("""<span class="text-danger">"""),_display_(/*130.110*/Messages(" *")),format.raw/*130.124*/("""</span></label>
                      <div class="col-sm-12 p-0">
                        <input id="countDeviceRegister" type="number" class="form-control" autocomplete="off" placeholder="Số lượng thiết bị ước tính anh chị muốn tích hợp trong giải pháp của mình">
                      </div>
                    </div>
                    <div class="row mt-1 ml-1">
                      <label class="col-form-label">"""),_display_(/*136.54*/Messages("Số lượng người dùng")),format.raw/*136.85*/("""<span class="text-danger">"""),_display_(/*136.112*/Messages(" *")),format.raw/*136.126*/("""</span></label>
                      <div class="col-sm-12 p-0">
                        <input id="countUserRegister" type="number" class="form-control" autocomplete="off" placeholder="Số lượng khách hàng anh chị muốn phục vụ ">
                      </div>
                    </div>
                    <div class="mt-3">
                      <button class="btn btn-danger float-right" data-next>"""),_display_(/*142.77*/Messages("Tiếp")),format.raw/*142.93*/(""" """),format.raw/*142.94*/("""<i class="bx bx-chevron-right"></i></button>
                    </div>
                  </section>

                  <section data-step="personal">
                    <div class="row mt-3 ml-1 si-form-title">
                      <h6>"""),_display_(/*148.28*/Messages("Đăng ký trở thành Nhà tích hợp / Nhà phát triển ngay hôm nay để nhận những thông tin và ưu đãi lớn nhất từ Nền tảng InnoWay.vn")),format.raw/*148.166*/("""</h6>
                    </div>
                    <label class="si-form-title-1 mt-3">"""),_display_(/*150.58*/Messages("Thông tin của bạn")),format.raw/*150.87*/("""</label>
                    <div class="mt-3 ml-1">
                      <div class="col-sm-12">
                        <input id="emailRegister" type="text" class="form-control input-info" autocomplete="off" placeholder=""""),_display_(/*153.128*/Messages("Email *")),format.raw/*153.147*/("""" required minlength="1" maxlength="100">
                      </div>
                    </div>
                    <div class="mt-3 ml-1">
                      <div class="col-sm-12">
                        <input id="nameCompanyRegister" type="text" class="form-control input-info" autocomplete="off" placeholder=""""),_display_(/*158.134*/Messages("Tên công ty *")),format.raw/*158.159*/("""" required minlength="1" maxlength="100">
                      </div>
                    </div>
                    <div class="mt-3 ml-1">
                      <div class="col-sm-12">
                        <input id="nameRegister" type="text" class="form-control input-info" autocomplete="off" placeholder=""""),_display_(/*163.127*/Messages("Họ và tên liên hệ *")),format.raw/*163.158*/("""" required minlength="1" maxlength="100">
                      </div>
                    </div>
                    <div class="row mt-3 ml-1">
                      <div class="col-sm-12">
                        <input id="phoneRegister" type="number" class="form-control input-info" autocomplete="off" placeholder=""""),_display_(/*168.130*/Messages("Số điện thoại *")),format.raw/*168.157*/("""" required minlength="9" maxlength="11">
                      </div>
                    </div>

                    <div class="mt-3">
                      <button class="btn btn-link text-gray" data-prev>"""),_display_(/*173.73*/Messages("Quay lại")),format.raw/*173.93*/("""</button>
                      <button class="btn btn-link text-gray" id="buttonFinishRegister" data-next hidden>"""),_display_(/*174.106*/Messages("Tiếp")),format.raw/*174.122*/("""</button>
                      <button class="btn btn-danger float-right" type="button" onclick="registerDeveloper()">"""),_display_(/*175.111*/Messages("Gửi thông tin đăng ký")),format.raw/*175.144*/("""</button>
                    </div>
                  </section>

                  <section data-step="finish">
                    <div class="row mt-3">
                      <div class="container" style="text-align: center">
                        <span class="mt-3" style="font-size: 32px; font-weight: 500; color: #14142B;">"""),_display_(/*182.104*/Messages("Cảm ơn bạn! Thông tin đăng ký của bạn đã gửi thành công!")),format.raw/*182.172*/("""</span><br>
                        <span class="mt-3" style="font-size: 16px; font-weight: 300; color: #14142B;">"""),_display_(/*183.104*/Messages("Chúng tôi đã nhận được thông tin đăng ký trở thành Nhà tích hợp của bạn! Đội ngũ hỗ trợ sẽ liên hệ với bạn trong thời gian sớm nhất")),format.raw/*183.247*/("""</span>
                      </div>
                    </div>
                  </section>
                </form>
              </div>
              <div class="col-md-3"></div>
            </div>
          </div>
        </div>
      </div>

    </div>

  </body>
  <script type="text/javascript" src=""""),_display_(/*198.40*/routes/*198.46*/.JsController.jsMessages()),format.raw/*198.72*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*199.40*/routes/*199.46*/.JsController.javascriptRoutes),format.raw/*199.76*/(""""></script>
  <script src=""""),_display_(/*200.17*/routes/*200.23*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*200.77*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*202.17*/routes/*202.23*/.Assets.versioned("javascripts/landingPage/jquery.min.js")),format.raw/*202.81*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*203.17*/routes/*203.23*/.Assets.versioned("javascripts/landingPage/popper.min.js")),format.raw/*203.81*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*204.17*/routes/*204.23*/.Assets.versioned("javascripts/landingPage/bootstrap.min.js")),format.raw/*204.84*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*205.17*/routes/*205.23*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*205.77*/(""""></script>

  <script src=""""),_display_(/*207.17*/routes/*207.23*/.Assets.versioned("javascripts/landingPage/argon-design-system.js?v=1.2.2")),format.raw/*207.98*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*209.17*/routes/*209.23*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*209.90*/(""""></script>
  <script src=""""),_display_(/*210.17*/routes/*210.23*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*210.96*/(""""></script>
  <script src=""""),_display_(/*211.17*/routes/*211.23*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*211.105*/(""""></script>
  <script src=""""),_display_(/*212.17*/routes/*212.23*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*212.75*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*214.17*/routes/*214.23*/.Assets.versioned("javascripts/plugins/wizard/zangdar.min.js")),format.raw/*214.85*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*216.17*/routes/*216.23*/.Assets.versioned("javascripts/views/admin/registerDeveloper/register.js")),format.raw/*216.97*/("""" type="text/javascript"></script>

  """),_display_(/*218.4*/views/*218.9*/.html.BackToTop()),format.raw/*218.26*/("""
  """),_display_(/*219.4*/views/*219.9*/.html.Loading()),format.raw/*219.24*/("""
"""),format.raw/*220.1*/("""</html>"""))
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPage/page/RegisterDeveloper.scala.html
                  HASH: 41c123bc8f67232a2686352238169ba992a1ee14
                  MATRIX: 668->1|691->18|1038->52|1151->70|1178->71|6286->5152|6301->5158|6358->5194|6629->5438|6644->5444|6714->5493|6777->5529|6792->5535|6888->5610|6941->5743|6975->5750|7038->5786|7053->5792|7151->5868|7235->5925|7250->5931|7341->6000|7390->6022|7405->6028|7467->6069|7532->6107|7547->6113|7628->6173|7694->6212|7709->6218|7787->6275|7854->6315|7869->6321|7949->6380|8045->6450|8059->6455|8140->6515|8173->6521|8459->6780|8552->6851|8907->7179|8943->7194|9020->7244|9090->7293|9225->7401|9264->7419|9341->7469|9428->7534|9563->7642|9599->7657|9676->7707|9746->7756|9881->7864|9918->7880|9995->7930|10081->7994|10706->8591|10867->8729|11021->8855|11072->8884|11237->9021|11278->9040|11334->9067|11371->9081|11806->9488|11859->9519|11915->9546|11952->9560|12401->9981|12452->10010|12508->10037|12545->10051|12995->10473|13048->10504|13104->10531|13141->10545|13571->10947|13609->10963|13639->10964|13907->11204|14068->11342|14186->11432|14237->11461|14492->11687|14534->11706|14884->12027|14932->12052|15275->12366|15329->12397|15679->12718|15729->12745|15966->12954|16008->12974|16152->13089|16191->13105|16340->13225|16396->13258|16758->13591|16849->13659|16993->13774|17159->13917|17494->14224|17510->14230|17558->14256|17637->14307|17653->14313|17705->14343|17761->14371|17777->14377|17853->14431|17933->14483|17949->14489|18029->14547|18108->14598|18124->14604|18204->14662|18283->14713|18299->14719|18382->14780|18461->14831|18477->14837|18553->14891|18610->14920|18626->14926|18723->15001|18803->15053|18819->15059|18908->15126|18964->15154|18980->15160|19075->15233|19131->15261|19147->15267|19252->15349|19308->15377|19324->15383|19398->15435|19478->15487|19494->15493|19578->15555|19658->15607|19674->15613|19770->15687|19836->15726|19850->15731|19889->15748|19920->15752|19934->15757|19971->15772|20000->15773
                  LINES: 24->1|25->2|30->3|35->3|36->4|76->44|76->44|76->44|80->48|80->48|80->48|81->49|81->49|81->49|82->50|83->51|84->52|84->52|84->52|86->54|86->54|86->54|87->55|87->55|87->55|89->57|89->57|89->57|90->58|90->58|90->58|92->60|92->60|92->60|98->66|98->66|98->66|100->68|105->73|105->73|114->82|114->82|115->83|115->83|118->86|118->86|119->87|119->87|122->90|122->90|123->91|123->91|126->94|126->94|127->95|127->95|144->112|144->112|147->115|147->115|150->118|150->118|150->118|150->118|156->124|156->124|156->124|156->124|162->130|162->130|162->130|162->130|168->136|168->136|168->136|168->136|174->142|174->142|174->142|180->148|180->148|182->150|182->150|185->153|185->153|190->158|190->158|195->163|195->163|200->168|200->168|205->173|205->173|206->174|206->174|207->175|207->175|214->182|214->182|215->183|215->183|230->198|230->198|230->198|231->199|231->199|231->199|232->200|232->200|232->200|234->202|234->202|234->202|235->203|235->203|235->203|236->204|236->204|236->204|237->205|237->205|237->205|239->207|239->207|239->207|241->209|241->209|241->209|242->210|242->210|242->210|243->211|243->211|243->211|244->212|244->212|244->212|246->214|246->214|246->214|248->216|248->216|248->216|250->218|250->218|250->218|251->219|251->219|251->219|252->220
                  -- GENERATED --
              */
          