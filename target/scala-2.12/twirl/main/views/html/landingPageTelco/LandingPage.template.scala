
package views.html.landingPageTelco

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
        <link rel="stylesheet" href=""""),_display_(/*33.39*/routes/*33.45*/.Assets.versioned("assets/plugins/notifications/css/lobibox.min.css")),format.raw/*33.114*/("""" />

        <link href=""""),_display_(/*35.22*/routes/*35.28*/.Assets.versioned("assets/plugins/carousel/css/owl.carousel.min.css")),format.raw/*35.97*/("""" rel="stylesheet">
        <link href=""""),_display_(/*36.22*/routes/*36.28*/.Assets.versioned("assets/plugins/carousel/css/owl.theme.default.min.css")),format.raw/*36.102*/("""" rel="stylesheet">
        <link href=""""),_display_(/*37.22*/routes/*37.28*/.Assets.versioned("assets/css/icons.css")),format.raw/*37.69*/("""" rel="stylesheet">


        <link href=""""),_display_(/*40.22*/routes/*40.28*/.Assets.versioned("stylesheets/landingPage/landingPageTelco.css")),format.raw/*40.93*/("""" rel="stylesheet" />
        <script>
                (function(w,d,s,l,i)"""),format.raw/*42.37*/("""{"""),format.raw/*42.38*/("""w[l]=w[l]||[];w[l].push("""),format.raw/*42.62*/("""{"""),format.raw/*42.63*/("""'gtm.start':
                            new Date().getTime(),event:'gtm.js'"""),format.raw/*43.64*/("""}"""),format.raw/*43.65*/(""");var f=d.getElementsByTagName(s)[0],
                        j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
                        'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
                """),format.raw/*46.17*/("""}"""),format.raw/*46.18*/(""")(window,document,'script','dataLayer','GTM-WM56JR3');
        </script>
        <script type="application/ld+json">
    """),format.raw/*49.5*/("""{"""),format.raw/*49.6*/("""
      """),format.raw/*50.7*/(""""context":"https://schema.org",
      "type":"WebSite",
      "author":"""),format.raw/*52.16*/("""{"""),format.raw/*52.17*/(""""type":"Person","name”:”Viette”l Telco Platform"""),format.raw/*52.64*/("""}"""),format.raw/*52.65*/(""",
        "description":"Viettel IoT Cloud là Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt. Quản lý thiết bị, thu thập, xử lý và hiển thị dữ liệu cho giải pháp IoT của bạn. Kết nối vô hạn, mở vạn tiềm năng!",
        "headline":"Viettel IoT Cloud | Nền tảng IoT toàn diện phục vụ chuyển đổi số cho doanh nghiệp Việt.",
        "name":"Viettel IoT Cloud ",
        "publisher":"""),format.raw/*56.21*/("""{"""),format.raw/*56.22*/(""""type":"Organization",
          "logo":"""),format.raw/*57.18*/("""{"""),format.raw/*57.19*/(""""type":"ImageObject",
            "url":"https://innoway.vn/assets/images/landingPageTelco/Logo_Viettel.svg""""),format.raw/*58.87*/("""}"""),format.raw/*58.88*/(""",
          "name”:”Viettel IoT Cloud”"""),format.raw/*59.37*/("""}"""),format.raw/*59.38*/(""",
          "sameAs":["https://twitter.com/ViettelInnoway",
            "http://www.linkedin.com/in/viettelinnoway",
            "https://www.facebook.com/innoway.vn",
            "https://www.instagram.com/innoway.vn"
            “https://www.youtube.com/channel/UClr7WnjIVvPKiWmONu4r8zA”],
            "url":"https://iot.viettel.vn/"
            """),format.raw/*66.13*/("""}"""),format.raw/*66.14*/("""
    """),format.raw/*67.5*/("""</script>
        <!-- Google tag (gtag.js) -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=G-S3V6KNSHZZ"></script>

    <script>
            window.dataLayer = window.dataLayer || [];
            function gtag()"""),format.raw/*73.28*/("""{"""),format.raw/*73.29*/("""dataLayer.push(arguments);"""),format.raw/*73.55*/("""}"""),format.raw/*73.56*/("""
            """),format.raw/*74.13*/("""gtag('js', new Date());

            gtag('config', 'G-S3V6KNSHZZ');

    </script>
    </head>

    <body class="landing-page">
        <div class="wrapper">
            """),_display_(/*83.14*/views/*83.19*/.html.landingPageTelco.LandingPage_navbar(currentUser)),format.raw/*83.73*/("""
            """),format.raw/*84.13*/("""<div class="section features-6 mt-1" id="divgioithieu" style="z-index: 5;  top: -74px;">
                <div class="container mt-1">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="info info-horizontal info-hover-primary">
                                <div class="description">
                                    <p class="title41">"""),_display_(/*90.57*/Messages("landingPageTelco.introduction")),format.raw/*90.98*/("""</p>
                                </div>
                                <div class="info info-horizontal info-hover-primary-primary mt-3">
                                    <div class="description">
                                        <p class="description opacity-8">"""),_display_(/*94.75*/Messages("landingPageTelco.simDataService")),format.raw/*94.118*/("""</p>
                                    </div>
                                    <div class="info info-horizontal info-hover-primary">
                                        <div class="description">
                                            <img class="img-introduces" src=""""),_display_(/*98.79*/routes/*98.85*/.Assets.versioned("images/landingPageTelco/Vector.svg")),format.raw/*98.140*/("""">
                                            <p class="descriptionsss opacity-8">"""),_display_(/*99.82*/Messages("landingPageTelco.m2mTechnology")),format.raw/*99.124*/("""</p>
                                        </div>
                                        <div class="description">
                                            <img class="img-introduces" src=""""),_display_(/*102.79*/routes/*102.85*/.Assets.versioned("images/landingPageTelco/Vector.svg")),format.raw/*102.140*/("""">
                                            <p class="descriptionsss opacity-8">"""),_display_(/*103.82*/Messages("landingPageTelco.m2mDataService")),format.raw/*103.125*/("""</p>
                                        </div>
                                        <div class="description">
                                            <img class="img-introduces" src=""""),_display_(/*106.79*/routes/*106.85*/.Assets.versioned("images/landingPageTelco/Vector.svg")),format.raw/*106.140*/("""">
                                            <p class="descriptionsss opacity-8">"""),_display_(/*107.82*/Messages("landingPageTelco.iotTechnology")),format.raw/*107.124*/("""</p>
                                        </div>
                                    </div>
                                    <div class="info info-horizontal info-hover-primary">
                                        <div class="description">
                                            <a onclick="goToByScroll('divGioicuoc')"  rel="nofollow" target="_blank" class="btn btn-danger-2"  style="background: #EA0033; border-radius: 8px 8px 8px 0px; font-weight: 700; font-size: 16px; line-height: 22px; display: flex; align-items: flex-end; text-align: center; color: #FFFFFF;">"""),_display_(/*112.334*/Messages("landingPageTelco.viewProducts")),format.raw/*112.375*/("""<span style="margin-left: 4px;">&#8599;</span></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 mx-md-auto">
                            <img class="img-introduces" src=""""),_display_(/*119.63*/routes/*119.69*/.Assets.versioned("images/landingPageTelco/Group_45.svg")),format.raw/*119.126*/("""" width="100%">
                        </div>
                    </div>
                </div>
            </div>
            """),_display_(/*124.14*/views/*124.19*/.html.landingPageTelco.LandingPage_Giaiphap(currentUser)),format.raw/*124.75*/("""
            """),format.raw/*125.13*/("""<div class="section features-1" id="divGioicuoc" style=" background: #f9f9f9;background-image: url("""),_display_(/*125.113*/routes/*125.119*/.Assets.versioned("images/landingPageTelco/BG1.png")),format.raw/*125.171*/(""");    background-repeat: no-repeat;  background-size: 100% 100%;">
                <div class="container">
                    <div class="col-md-12 mx-auto text-center">
                        <p class="value">"""),_display_(/*128.43*/Messages("landingPageTelco.m2mPackageProducts")),format.raw/*128.90*/("""</p>
                        <h3 class="display-3 title-section-1">"""),_display_(/*129.64*/Messages("landingPageTelco.diversePackages")),format.raw/*129.108*/("""</h3>
                    </div>
                    <div class="container">
                        <div class="description">
                            <h4 class="cdata">"""),_display_(/*133.48*/Messages("landingPageTelco.packageType")),format.raw/*133.88*/("""</h4>
                            <div class="cdata">"""),_display_(/*134.49*/Messages("landingPageTelco.fourGFiveG")),format.raw/*134.88*/("""</div>
                            <label class="switch">
                                <input type="checkbox" id="switch1" aria-label="Switch1">
                                <span class="iots"></span>
                            </label>
                            <p class="datatable1">"""),_display_(/*139.52*/Messages("landingPageTelco.nbIot")),format.raw/*139.86*/("""</p>
                            <p class="datatable1">"""),_display_(/*140.52*/Messages("landingPageTelco.nbIot")),format.raw/*140.86*/("""</p>
                        </div>
                        <div class="descriptionsss" style="display:-webkit-inline-box">
                            <h4 class="cdata">"""),_display_(/*143.48*/Messages("landingPageTelco.subscription")),format.raw/*143.89*/("""</h4>
                            <div class="cdata">"""),_display_(/*144.49*/Messages("landingPageTelco.prepaid")),format.raw/*144.85*/("""</div>
                            <label class="switch">
                                <input type="checkbox" id="switch2" aria-label="Switch2">
                                <span></span>
                            </label>
                            <p class="datatable">"""),_display_(/*149.51*/Messages("landingPageTelco.postpaid")),format.raw/*149.88*/("""</p>
                        </div>
                        <button id="btncompare" type="button" class="btn btn-danger-3" style="color: #EA0033; height: 42px;margin-top: -6px; margin-left: 2rem "  onclick="clickCompare()" data-toggle="modal" data-target="#questionModal3">"""),_display_(/*151.239*/Messages("landingPageTelco.comparePackages")),format.raw/*151.283*/("""</button>

                    </div>
                    """),_display_(/*154.22*/views/*154.27*/.html.landingPageTelco.LandingPage_Sosanh()),format.raw/*154.70*/("""

                    """),_display_(/*156.22*/views/*156.27*/.html.landingPageTelco.LandingPage_GoiCuocM2M()),format.raw/*156.74*/("""
                    """),_display_(/*157.22*/views/*157.27*/.html.landingPageTelco.LandingPage_orderSim()),format.raw/*157.72*/("""

                """),format.raw/*159.17*/("""</div>
            </div>
            """),_display_(/*161.14*/views/*161.19*/.html.landingPageTelco.LandingPage_Sanpham()),format.raw/*161.63*/("""

            """),_display_(/*163.14*/views/*163.19*/.html.landingPageTelco.LandingPage_Dathang(currentUser)),format.raw/*163.74*/("""

            """),_display_(/*165.14*/views/*165.19*/.html.landingPageTelco.LandingPage_client()),format.raw/*165.62*/("""
"""),format.raw/*166.36*/("""
"""),format.raw/*167.44*/("""
"""),format.raw/*168.135*/("""
"""),format.raw/*169.51*/("""
"""),format.raw/*170.58*/("""
"""),format.raw/*171.107*/("""
"""),format.raw/*172.39*/("""
"""),format.raw/*173.35*/("""
"""),format.raw/*174.51*/("""
"""),format.raw/*175.94*/("""
"""),format.raw/*176.64*/("""
"""),format.raw/*177.107*/("""
"""),format.raw/*178.113*/("""
"""),format.raw/*179.43*/("""
"""),format.raw/*180.39*/("""
"""),format.raw/*181.67*/("""
"""),format.raw/*182.64*/("""
"""),format.raw/*183.109*/("""
"""),format.raw/*184.115*/("""
"""),format.raw/*185.43*/("""
"""),format.raw/*186.39*/("""
"""),format.raw/*187.67*/("""
"""),format.raw/*188.64*/("""
"""),format.raw/*189.109*/("""
"""),format.raw/*190.113*/("""
"""),format.raw/*191.43*/("""
"""),format.raw/*192.39*/("""
"""),format.raw/*193.74*/("""
"""),format.raw/*194.159*/("""
"""),format.raw/*195.39*/("""
"""),format.raw/*196.35*/("""
"""),format.raw/*197.31*/("""
"""),format.raw/*198.27*/("""
"""),format.raw/*199.23*/("""
            """),format.raw/*200.13*/("""<div class="section features-1" id="divHoiDap" style="background: #F9F9F9;background-image: url("""),_display_(/*200.110*/routes/*200.116*/.Assets.versioned("images/landingPageTelco/Group_42.png")),format.raw/*200.173*/(""");background-repeat: no-repeat;  background-size: 100% 100%;">
                <div class="container">
                    <div class="col-md-12 mx-auto text-center">
                        <p class="value">"""),_display_(/*203.43*/Messages("landingPageTelco.faq")),format.raw/*203.75*/("""</p>
                    </div>
                    <div class="row g-0">
                        <div class="col-md-6">
                            <div class="accordion my-3" id="accordionExample">
                                <div class="card" style="border: 0 solid rgba(0, 0, 0, 0.05);">
                                    <div class="card-header" id="heading1" style="background-color: white;">
                                        <button class="btn btn-link text-primary text-left" id="btn-shows" type="button" data-toggle="collapse" data-target="#collapse1" aria-expanded="false" aria-controls="collapse1" onclick="Clickme(1)" style="white-space: inherit;">
                                            <img id="shows" src=""""),_display_(/*211.67*/routes/*211.73*/.Assets.versioned("images/landingPageTelco/Group_5411.png")),format.raw/*211.132*/("""">
                                            <img id="hide" src=""""),_display_(/*212.66*/routes/*212.72*/.Assets.versioned("images/landingPageTelco/Group_5412.png")),format.raw/*212.131*/("""">
                                            <span class="text-center question-title">"""),_display_(/*213.87*/Messages("landingPageTelco.faq1")),format.raw/*213.120*/("""</span>
                                        </button>
                                    </div>
                                    <div id="collapse1" class="collapse" aria-labelledby="heading1" data-parent="#accordionExample">
                                        <div class="card-bodys opacity-8">
                                            <label> """),_display_(/*218.54*/Messages("landingPageTelco.faq1.answer1")),format.raw/*218.95*/("""</label>
                                            <label> """),_display_(/*219.54*/Messages("landingPageTelco.faq1.answer2")),format.raw/*219.95*/("""</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="accordion my-3" id="accordionExample">
                                <div class="card" style="border: 0 solid rgba(0, 0, 0, 0.05);">
                                    <div class="card-header" id="heading2" style="background-color: white;">
                                        <button class="btn btn-link text-primary text-left" id="btn-shows1" type="button" data-toggle="collapse" data-target="#collapse2" aria-expanded="false" aria-controls="collapse2" onclick="Clickme(2)"style="white-space: inherit;">
                                            <img id="shows1" src=""""),_display_(/*230.68*/routes/*230.74*/.Assets.versioned("images/landingPageTelco/Group_5411.png")),format.raw/*230.133*/("""">
                                            <img id="hide1" src=""""),_display_(/*231.67*/routes/*231.73*/.Assets.versioned("images/landingPageTelco/Group_5412.png")),format.raw/*231.132*/("""">
                                            <span class="text-center question-title">"""),_display_(/*232.87*/Messages("landingPageTelco.faq2")),format.raw/*232.120*/("""</span>
                                        </button>
                                    </div>
                                    <div id="collapse2" class="collapse" aria-labelledby="heading2" data-parent="#accordionExample">
                                        <div class="card-bodys opacity-8">
                                            <label>"""),_display_(/*237.53*/Messages("landingPageTelco.faq2.answer")),format.raw/*237.93*/("""</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="accordion my-3" id="accordionExample">
                                <div class="card" style="border: 0 solid rgba(0, 0, 0, 0.05);">
                                    <div class="card-header" id="heading2" style="background-color: white;">
                                        <button class="btn btn-link text-primary text-left" id="btn-shows2" type="button" data-toggle="collapse" data-target="#collapse3" aria-expanded="false" aria-controls="collapse3" onclick="Clickme(3)" style="white-space: inherit;">
                                            <img id="shows2" src=""""),_display_(/*248.68*/routes/*248.74*/.Assets.versioned("images/landingPageTelco/Group_5411.png")),format.raw/*248.133*/("""">
                                            <img id="hide2" src=""""),_display_(/*249.67*/routes/*249.73*/.Assets.versioned("images/landingPageTelco/Group_5412.png")),format.raw/*249.132*/("""">
                                            <span class="text-center question-title">"""),_display_(/*250.87*/Messages("landingPageTelco.faq3")),format.raw/*250.120*/("""</span>
                                        </button>
                                    </div>
                                    <div id="collapse3" class="collapse" aria-labelledby="heading3" data-parent="#accordionExample">
                                        <div class="card-bodys opacity-8">
                                            <label>"""),_display_(/*255.53*/Messages("landingPageTelco.faq3.intro")),format.raw/*255.92*/(""" """),format.raw/*255.93*/("""</label>
                                            <label> """),_display_(/*256.54*/Messages("landingPageTelco.faq3.answer1")),format.raw/*256.95*/(""" """),format.raw/*256.96*/("""</label>
                                            <label> """),_display_(/*257.54*/Messages("landingPageTelco.faq3.answer2")),format.raw/*257.95*/(""" """),format.raw/*257.96*/("""</label>
                                            <label> """),_display_(/*258.54*/Messages("landingPageTelco.faq3.answer3")),format.raw/*258.95*/(""" """),format.raw/*258.96*/("""</label>
                                            <label> """),_display_(/*259.54*/Messages("landingPageTelco.faq3.answer4")),format.raw/*259.95*/("""</label>
                                            <label> """),_display_(/*260.54*/Messages("landingPageTelco.faq3.answer5")),format.raw/*260.95*/("""</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="accordion my-3" id="accordionExample">
                                <div class="card" style="border: 0 solid rgba(0, 0, 0, 0.05);">
                                    <div class="card-header" id="heading2" style="background-color: white;">
                                        <button class="btn btn-link text-primary text-left" id="btn-shows3" type="button" data-toggle="collapse" data-target="#collapse4" aria-expanded="false" aria-controls="collapse4" onclick="Clickme(4)" style="white-space: inherit;">
                                            <img id="shows3" src=""""),_display_(/*271.68*/routes/*271.74*/.Assets.versioned("images/landingPageTelco/Group_5411.png")),format.raw/*271.133*/("""">
                                            <img id="hide3" src=""""),_display_(/*272.67*/routes/*272.73*/.Assets.versioned("images/landingPageTelco/Group_5412.png")),format.raw/*272.132*/("""">
                                            <span class="text-center question-title">"""),_display_(/*273.87*/Messages("landingPageTelco.faq4")),format.raw/*273.120*/("""</span>
                                        </button>
                                    </div>
                                    <div id="collapse4" class="collapse" aria-labelledby="heading4" data-parent="#accordionExample">
                                        <div class="card-bodys opacity-8">
                                            <label>"""),_display_(/*278.53*/Messages("landingPageTelco.faq4.answer1")),format.raw/*278.94*/("""</label>
                                            <label>"""),_display_(/*279.53*/Messages("landingPageTelco.faq4.answer2")),format.raw/*279.94*/("""</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="section features-1" id="divhotro" style="background-image: url("""),_display_(/*288.89*/routes/*288.95*/.Assets.versioned("images/landingPageTelco/bg_4.png")),format.raw/*288.148*/(""");    background-repeat: no-repeat;  background-size: 100% 100%;">
                <div class="container">
                    <div class="row" style="">
                        <div class="col-md-4" id="text-footer">
                            <div class="description">
                                <p class="content-user">"""),_display_(/*293.58*/Messages("landingPageTelco.customerSupport")),format.raw/*293.102*/("""</p>
                            </div>
                        </div>
                        <div class="col-md-8">
                            <div class="form-group ml-5 mr-5" style="">
                                <div class="descriptionss">
                                    <p class="input-group" style="color: #FFFFFF">"""),_display_(/*299.84*/Messages("landingPageTelco.fullName")),_display_(/*299.122*/Messages("landingPageTelco.required")),format.raw/*299.159*/("""</p>
                                    <input class="form-control input7" type="text" id="name" maxlength="50">
                                </div>
                            </div>
                            <div class="form-group ml-5 mr-5">
                                <div class="descriptionss">
                                    <p class="input-group" style="color: #FFFFFF">"""),_display_(/*305.84*/Messages("landingPageTelco.email")),_display_(/*305.119*/Messages("landingPageTelco.required")),format.raw/*305.156*/("""</p>
                                    <input class="form-control input7" type="text" id="email" maxlength="50">
                                </div>
                            </div>
                            <div class="form-group ml-5 mr-5">
                                <div class="descriptionss">
                                    <p class="input-group" style="color: #FFFFFF">"""),_display_(/*311.84*/Messages("landingPageTelco.phoneNumber")),_display_(/*311.125*/Messages("landingPageTelco.required")),format.raw/*311.162*/("""</p>
                                    <input class="form-control input7" type="number" id="phone" maxlength="11">
                                </div>
                            </div>
                            <div class="form-group ml-5 mr-5">
                                <div class="descriptionss">
                                    <p class="input-group" style="color: #FFFFFF">"""),_display_(/*317.84*/Messages("landingPageTelco.supportContent")),_display_(/*317.128*/Messages("landingPageTelco.required")),format.raw/*317.165*/("""</p>
                                    <textarea id="content" name="content" type="text" class="form-control" rows="5" autocomplete="off" maxlength="500"></textarea>
                                </div>
                            </div>
                            <div class="form-group mt-3 text-center">
                                <button class="btn btn-danger radiuss-40" onclick="submitFormContactTelco()" id="buttonSubmitContacts">"""),_display_(/*322.137*/Messages("landingPageTelco.send")),format.raw/*322.170*/("""</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="section features-1" style="background-color: #3A3A3A;" id="divlienhe">
                <div class="navbar-container">
                    <div class="row">
                        <div class="col-md-2">
                            <div class="">
                                <img src=""""),_display_(/*333.44*/routes/*333.50*/.Assets.versioned("images/landingPageTelco/viettel.svg")),format.raw/*333.106*/("""" alt="..." class="card-img">
                            </div>
                        </div>
                        <div class="col-md-6 mt-3">
                            <div class="">
                                <span class="footer-text-1">"""),_display_(/*338.62*/Messages("landingPageTelco.viettelTelecom")),format.raw/*338.105*/("""</span>
                                <br>
                                <span class="footer-text-2">"""),_display_(/*340.62*/Messages("landingPageTelco.businessCode")),format.raw/*340.103*/("""</span>
                                <br>
                                <span class="footer-text-2">"""),_display_(/*342.62*/Messages("landingPageTelco.contentResponsible")),format.raw/*342.109*/("""</span>
                            </div>
                        </div>
                        <div class="col-md-4 mt-4">
                            <div class="">
                                <div>
                                    <a href="" target="_blank">
                                        <a href="mailto:  iot@viettel.com.vn" target="_blank" class="descriptions opacity-8" style="color: #FFFFFF;">"""),_display_(/*349.152*/Messages("landingPageTelco.businessContact")),format.raw/*349.196*/("""</a>
                                        <a href="tel: 18008044" target="_blank" class="descriptions opacity-8" style="color: #FFFFFF;">"""),_display_(/*350.137*/Messages("landingPageTelco.businessPhone")),format.raw/*350.179*/("""</a>
                                    </a>
                                </div>
                                <div style="margin-top: 15px;">
                                    <a href="" target="_blank">
                                        <a href="mailto:  cskh@viettel.com.vn" target="_blank" class="descriptions opacity-8" style="color: #FFFFFF;">"""),_display_(/*355.153*/Messages("landingPageTelco.customerCare")),format.raw/*355.194*/("""</a>
                                        <a href="tel: 198" target="_blank" class="descriptions opacity-8" style="color: #FFFFFF;">"""),_display_(/*356.132*/Messages("landingPageTelco.customerCarePhone")),format.raw/*356.178*/("""</a>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr style="border-top: 1px solid #4D4D4D; width: 1200px; margin: 20px auto;">
                <div class="container">
                    <div class="row" id="footer-menu">
                        <div class="col-md-6" style="">
                            <span class="footer-text-4">"""),_display_(/*367.58*/Messages("landingPageTelco.copyright")),format.raw/*367.96*/("""</span>
                        </div>
                        <div class="col-md-6" id="center_footer">
                            <span class="footer-text-4">"""),_display_(/*370.58*/Messages("landingPageTelco.followUs")),format.raw/*370.95*/("""</span>
                            <a href="https://www.facebook.com/innoway.vn/" class="fa fa-facebook-square" target="_blank" style="font-size: 23px; color: #B1B1B1; "></a>
                            <a href="https://twitter.com/VInnoway" class="fa fa-twitter-square" target="_blank" style="font-size: 23px; color: #B1B1B1; margin-left: 10px;"></a>
                            <a href="https://www.instagram.com/innoway.vn/" class="fa fa-instagram" target="_blank" style="font-size: 23px; color: #B1B1B1; margin-left: 10px;"></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script type="text/javascript" src=""""),_display_(/*380.42*/routes/*380.48*/.JsController.jsMessages()),format.raw/*380.74*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*381.42*/routes/*381.48*/.JsController.javascriptRoutes),format.raw/*381.78*/(""""></script>

    <script src=""""),_display_(/*383.19*/routes/*383.25*/.Assets.versioned("javascripts/landingPage/jquery.min.js")),format.raw/*383.83*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*384.19*/routes/*384.25*/.Assets.versioned("javascripts/landingPage/popper.min.js")),format.raw/*384.83*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*385.19*/routes/*385.25*/.Assets.versioned("javascripts/landingPage/bootstrap.min.js")),format.raw/*385.86*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*386.19*/routes/*386.25*/.Assets.versioned("assets/plugins/carousel/js/owl.carousel.min.js")),format.raw/*386.92*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*387.19*/routes/*387.25*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*387.79*/(""""></script>
    <script src=""""),_display_(/*388.19*/routes/*388.25*/.Assets.versioned("javascripts/landingPage/argon-design-system.js?v=1.2.2")),format.raw/*388.100*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*389.19*/routes/*389.25*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*389.92*/(""""></script>
    <script src=""""),_display_(/*390.19*/routes/*390.25*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*390.98*/(""""></script>
    <script src=""""),_display_(/*391.19*/routes/*391.25*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*391.107*/(""""></script>
    <script src=""""),_display_(/*392.19*/routes/*392.25*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*392.77*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*393.19*/routes/*393.25*/.Assets.versioned("javascripts/views/landingPage/landingPageTelco.js")),format.raw/*393.95*/("""" type="text/javascript"></script>
   <script>
            """),_display_(/*395.14*/if(currentUser != null )/*395.38*/{_display_(Seq[Any](format.raw/*395.39*/("""
                """),format.raw/*396.17*/("""var userId = '"""),_display_(/*396.32*/currentUser/*396.43*/.getId),format.raw/*396.49*/("""';
                var flagLogin = "login";
            """)))}/*398.14*/else/*398.18*/{_display_(Seq[Any](format.raw/*398.19*/("""
                """),format.raw/*399.17*/("""var flagLogin = "notLogin";
            """)))}),format.raw/*400.14*/("""

   """),format.raw/*402.4*/("""</script>

    """),_display_(/*404.6*/views/*404.11*/.html.BackToTop()),format.raw/*404.28*/("""
"""),format.raw/*405.1*/("""</html>"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 17:07:59 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPageTelco/LandingPage.scala.html
                  HASH: b5802ff6fd699888bcbbd6a8c1dd7b0c1c2b9189
                  MATRIX: 668->1|691->18|1032->52|1145->70|1172->71|2584->1456|2599->1462|2677->1518|3075->1890|3090->1896|3160->1945|3227->1985|3242->1991|3339->2066|3439->2139|3454->2145|3552->2221|3639->2281|3654->2287|3745->2356|3799->2383|3814->2389|3904->2458|3972->2499|3987->2505|4083->2579|4151->2620|4166->2626|4228->2667|4298->2710|4313->2716|4399->2781|4502->2856|4531->2857|4583->2881|4612->2882|4716->2958|4745->2959|5028->3214|5057->3215|5205->3336|5233->3337|5267->3344|5366->3415|5395->3416|5470->3463|5499->3464|5925->3862|5954->3863|6022->3903|6051->3904|6187->4012|6216->4013|6282->4051|6311->4052|6687->4400|6716->4401|6748->4406|7011->4641|7040->4642|7094->4668|7123->4669|7164->4682|7363->4854|7377->4859|7452->4913|7493->4926|7935->5341|7997->5382|8303->5661|8368->5704|8677->5986|8692->5992|8769->6047|8880->6131|8944->6173|9168->6369|9184->6375|9262->6430|9374->6514|9440->6557|9664->6753|9680->6759|9758->6814|9870->6898|9935->6940|10548->7524|10612->7565|11006->7931|11022->7937|11102->7994|11259->8123|11274->8128|11352->8184|11394->8197|11523->8297|11540->8303|11615->8355|11856->8568|11925->8615|12021->8683|12088->8727|12290->8901|12352->8941|12434->8995|12495->9034|12818->9329|12874->9363|12958->9419|13014->9453|13213->9624|13276->9665|13358->9719|13416->9755|13725->10036|13784->10073|14087->10347|14154->10391|14241->10450|14256->10455|14321->10498|14372->10521|14387->10526|14456->10573|14506->10595|14521->10600|14588->10645|14635->10663|14702->10702|14717->10707|14783->10751|14826->10766|14841->10771|14918->10826|14961->10841|14976->10846|15041->10889|15071->10925|15101->10969|15132->11104|15162->11155|15192->11213|15223->11320|15253->11359|15283->11394|15313->11445|15343->11539|15373->11603|15404->11710|15435->11823|15465->11866|15495->11905|15525->11972|15555->12036|15586->12145|15617->12260|15647->12303|15677->12342|15707->12409|15737->12473|15768->12582|15799->12695|15829->12738|15859->12777|15889->12851|15920->13010|15950->13049|15980->13084|16010->13115|16040->13142|16070->13165|16112->13178|16238->13275|16255->13281|16335->13338|16572->13547|16626->13579|17394->14319|17410->14325|17492->14384|17588->14452|17604->14458|17686->14517|17803->14606|17859->14639|18249->15001|18312->15042|18402->15104|18465->15145|19364->16016|19380->16022|19462->16081|19559->16150|19575->16156|19657->16215|19774->16304|19830->16337|20219->16698|20281->16738|21181->17610|21197->17616|21279->17675|21376->17744|21392->17750|21474->17809|21591->17898|21647->17931|22036->18292|22097->18331|22127->18332|22217->18394|22280->18435|22310->18436|22400->18498|22463->18539|22493->18540|22583->18602|22646->18643|22676->18644|22766->18706|22829->18747|22919->18809|22982->18850|23882->19722|23898->19728|23980->19787|24077->19856|24093->19862|24175->19921|24292->20010|24348->20043|24737->20404|24800->20445|24889->20506|24952->20547|25341->20908|25357->20914|25433->20967|25790->21296|25857->21340|26218->21673|26278->21711|26338->21748|26760->22142|26817->22177|26877->22214|27300->22609|27363->22650|27423->22687|27848->23084|27914->23128|27974->23165|28451->23613|28507->23646|28993->24104|29009->24110|29088->24166|29368->24418|29434->24461|29568->24567|29632->24608|29766->24714|29836->24761|30286->25183|30353->25227|30523->25368|30588->25410|30981->25775|31045->25816|31210->25952|31279->25998|31810->26501|31870->26539|32060->26701|32119->26738|32849->27440|32865->27446|32913->27472|32994->27525|33010->27531|33062->27561|33121->27592|33137->27598|33217->27656|33298->27709|33314->27715|33394->27773|33475->27826|33491->27832|33574->27893|33655->27946|33671->27952|33760->28019|33841->28072|33857->28078|33933->28132|33991->28162|34007->28168|34105->28243|34186->28296|34202->28302|34291->28369|34349->28399|34365->28405|34460->28478|34518->28508|34534->28514|34639->28596|34697->28626|34713->28632|34787->28684|34868->28737|34884->28743|34976->28813|35064->28873|35098->28897|35138->28898|35184->28915|35227->28930|35248->28941|35276->28947|35353->29004|35367->29008|35407->29009|35453->29026|35526->29067|35559->29072|35602->29088|35617->29093|35656->29110|35685->29111
                  LINES: 24->1|25->2|30->3|35->3|36->4|54->22|54->22|54->22|60->28|60->28|60->28|61->29|61->29|61->29|64->32|64->32|64->32|65->33|65->33|65->33|67->35|67->35|67->35|68->36|68->36|68->36|69->37|69->37|69->37|72->40|72->40|72->40|74->42|74->42|74->42|74->42|75->43|75->43|78->46|78->46|81->49|81->49|82->50|84->52|84->52|84->52|84->52|88->56|88->56|89->57|89->57|90->58|90->58|91->59|91->59|98->66|98->66|99->67|105->73|105->73|105->73|105->73|106->74|115->83|115->83|115->83|116->84|122->90|122->90|126->94|126->94|130->98|130->98|130->98|131->99|131->99|134->102|134->102|134->102|135->103|135->103|138->106|138->106|138->106|139->107|139->107|144->112|144->112|151->119|151->119|151->119|156->124|156->124|156->124|157->125|157->125|157->125|157->125|160->128|160->128|161->129|161->129|165->133|165->133|166->134|166->134|171->139|171->139|172->140|172->140|175->143|175->143|176->144|176->144|181->149|181->149|183->151|183->151|186->154|186->154|186->154|188->156|188->156|188->156|189->157|189->157|189->157|191->159|193->161|193->161|193->161|195->163|195->163|195->163|197->165|197->165|197->165|198->166|199->167|200->168|201->169|202->170|203->171|204->172|205->173|206->174|207->175|208->176|209->177|210->178|211->179|212->180|213->181|214->182|215->183|216->184|217->185|218->186|219->187|220->188|221->189|222->190|223->191|224->192|225->193|226->194|227->195|228->196|229->197|230->198|231->199|232->200|232->200|232->200|232->200|235->203|235->203|243->211|243->211|243->211|244->212|244->212|244->212|245->213|245->213|250->218|250->218|251->219|251->219|262->230|262->230|262->230|263->231|263->231|263->231|264->232|264->232|269->237|269->237|280->248|280->248|280->248|281->249|281->249|281->249|282->250|282->250|287->255|287->255|287->255|288->256|288->256|288->256|289->257|289->257|289->257|290->258|290->258|290->258|291->259|291->259|292->260|292->260|303->271|303->271|303->271|304->272|304->272|304->272|305->273|305->273|310->278|310->278|311->279|311->279|320->288|320->288|320->288|325->293|325->293|331->299|331->299|331->299|337->305|337->305|337->305|343->311|343->311|343->311|349->317|349->317|349->317|354->322|354->322|365->333|365->333|365->333|370->338|370->338|372->340|372->340|374->342|374->342|381->349|381->349|382->350|382->350|387->355|387->355|388->356|388->356|399->367|399->367|402->370|402->370|412->380|412->380|412->380|413->381|413->381|413->381|415->383|415->383|415->383|416->384|416->384|416->384|417->385|417->385|417->385|418->386|418->386|418->386|419->387|419->387|419->387|420->388|420->388|420->388|421->389|421->389|421->389|422->390|422->390|422->390|423->391|423->391|423->391|424->392|424->392|424->392|425->393|425->393|425->393|427->395|427->395|427->395|428->396|428->396|428->396|428->396|430->398|430->398|430->398|431->399|432->400|434->402|436->404|436->404|436->404|437->405
                  -- GENERATED --
              */
          