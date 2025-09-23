
package views.html.telco.order

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

object OrderSubscribe extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.35*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("Đấu nối")),format.raw/*9.32*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">
    """),format.raw/*11.117*/("""
    """),format.raw/*12.62*/("""

    """),format.raw/*14.5*/("""<link href=""""),_display_(/*14.18*/routes/*14.24*/.Assets.versioned("stylesheets/landingPage/argon-design-system.css?v=1.2.2")),format.raw/*14.100*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*15.18*/routes/*15.24*/.Assets.versioned("assets/plugins/notifications/css/lobibox.min.css")),format.raw/*15.93*/("""" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("assets/css/icons.css")),format.raw/*17.65*/("""" rel="stylesheet">

    """),format.raw/*19.96*/("""
    """),format.raw/*20.5*/("""<link href='"""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*20.73*/("""' type='text/css'>
    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*21.139*/("""" rel="stylesheet" >

    <link href=""""),_display_(/*23.18*/routes/*23.24*/.Assets.versioned("stylesheets/views/datatable.css")),format.raw/*23.76*/("""" rel="stylesheet" />

    <link href=""""),_display_(/*25.18*/routes/*25.24*/.Assets.versioned("stylesheets/views/telco/account/account.css")),format.raw/*25.88*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*26.18*/routes/*26.24*/.Assets.versioned("stylesheets/views/telco/telco2.css")),format.raw/*26.79*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*27.18*/routes/*27.24*/.Assets.versioned("stylesheets/views/telco/order/Order.css")),format.raw/*27.84*/("""" rel="stylesheet" />

  </head>

  <body class="landing-page">
    <div class="wrapper">

      <div class="" style="background-color: #EA0033; padding: 2rem;">
        <div class="row">
          <div class="col-md-7 mx-auto text-center">
            <a class="navbar-brand mr-lg-5" href=""""),_display_(/*37.52*/routes/*37.58*/.LandingPageController.home()),format.raw/*37.87*/("""">
              <img src=""""),_display_(/*38.26*/routes/*38.32*/.Assets.versioned("images/telco/logo.svg")),format.raw/*38.74*/("""" style="height: 100%;">
            </a>
            <a class="mr-lg-5">
              <img src=""""),_display_(/*41.26*/routes/*41.32*/.Assets.versioned("images/telco/connectSim.svg")),format.raw/*41.80*/("""" style="height: 100%;">
            </a>
          </div>
          <div class="col-md-5 mx-auto text-left">

          </div>
        </div>
      </div>

      <div class=" features-1 content-1" style="padding-bottom: 0px;">
        <div class="col-md-12">
          <div class="main-content ">
            <div class="row justify-content-center" style="padding-top: 2rem;" id="wizardRow">
              <div class="col-md-11 text-center">
                <div class="wizard-form py-4 my-2">
                  <ul id="progressBar" class="progressbar px-lg-5 px-0">
                    <li id="progressList-1" class="d-inline-block fw-bold w-20 position-relative text-center float-start progressbar-list active" style="z-index: 4;">"""),_display_(/*57.168*/Messages("Sim số điện thoại")),format.raw/*57.197*/("""</li>
                    <li id="progressList-2" class="d-inline-block fw-bold w-20 position-relative text-center float-start progressbar-list" style="z-index: 3;"> """),_display_(/*58.162*/Messages("Thông tin khách hàng")),format.raw/*58.194*/("""</li>
                    <li id="progressList-3" class="d-inline-block fw-bold w-20 position-relative text-center float-start progressbar-list" style="z-index: 2;"> """),_display_(/*59.162*/Messages("Chọn số thuê bao")),format.raw/*59.190*/("""</li>
                    <li id="progressList-4" class="d-inline-block fw-bold w-20 position-relative text-center float-start progressbar-list" style="z-index: 1;"> """),_display_(/*60.162*/Messages("Thanh toán")),format.raw/*60.184*/("""</li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="section features-1">
        <div class="col-lg-12 text-center">
          <div class="main-content">

            <div class="row justify-content-center" id="cardSection">
              """),_display_(/*74.16*/views/*74.21*/.html.telco.order.OrderSubscriber_sim_haveSim()),format.raw/*74.68*/("""

              """),format.raw/*76.15*/("""<div class="col-lg-9 col-md-8 mt-5">
                <button type="button" class="btn btn-telco float-end next" value="1" onclick="" style="background: #EA0033; color: #FFFFFF;">"""),_display_(/*77.143*/Messages("Tiếp theo")),format.raw/*77.164*/("""</button>
              </div>
            </div>

            <div class="row justify-content-center" style="display: none;">
              """),_display_(/*82.16*/views/*82.21*/.html.telco.order.OrderSubscriber_sim_infoKH(currentUser)),format.raw/*82.78*/("""

              """),format.raw/*84.15*/("""<div class="col-lg-9 col-md-8 mt-3">
                <button type="button" class="btn btn-telco float-start back" style="background: #FFFFFF; color: #EA0033; border: 1px solid #EA0033;">"""),_display_(/*85.151*/Messages("Quay lại")),format.raw/*85.171*/("""</button>
                <button type="button" class="btn btn-telco float-end next" value="2" style="background: #EA0033; color: #FFFFFF;">"""),_display_(/*86.132*/Messages("Tiếp theo")),format.raw/*86.153*/("""</button>
              </div>
            </div>

            <div class="row justify-content-center" style="display: none;">
              """),_display_(/*91.16*/views/*91.21*/.html.telco.order.OrderSubscriber_sim_haveSim_chooseTB()),format.raw/*91.77*/("""

              """),format.raw/*93.15*/("""<div class="col-lg-9 col-md-8 mt-3">
                <button type="button" class="btn btn-telco float-start back" style="background: #FFFFFF; color: #EA0033; border: 1px solid #EA0033;">"""),_display_(/*94.151*/Messages("Quay lại")),format.raw/*94.171*/("""</button>
                <button type="button" class="btn btn-telco float-end next" value="3" style="background: #EA0033; color: #FFFFFF;">"""),_display_(/*95.132*/Messages("Tiếp theo")),format.raw/*95.153*/("""</button>
              </div>
            </div>

            <div class="row justify-content-center" style="display: none;">
              """),_display_(/*100.16*/views/*100.21*/.html.telco.order.OrderSubscriber_sim_pay()),format.raw/*100.64*/("""

              """),format.raw/*102.15*/("""<div class="col-lg-9 col-md-8 mt-3">
                <button type="button" class="btn btn-telco float-start back" style="background: #FFFFFF; color: #EA0033; border: 1px solid #EA0033;">"""),_display_(/*103.151*/Messages("Quay lại")),format.raw/*103.171*/("""</button>
                <button type="button" class="btn btn-telco float-end" id="buttonConnectSim" onclick="connectSubscriberSimPay()" style="background: #EA0033; color: #FFFFFF;" disabled>"""),_display_(/*104.184*/Messages("Đấu nối")),format.raw/*104.203*/("""</button>
              </div>
            </div>

          </div>
        </div>
      </div>

      """),_display_(/*112.8*/views/*112.13*/.html.telco.order.OrderSubscriber_searchSubsInStock()),format.raw/*112.66*/("""
      """),_display_(/*113.8*/views/*113.13*/.html.telco.order.OrderSubscriber_finish(currentUser, userId)),format.raw/*113.74*/("""
      """),_display_(/*114.8*/views/*114.13*/.html.telco.order.OrderSubscriber_sim_infoKH_zoomImg()),format.raw/*114.67*/("""

      """),_display_(/*116.8*/views/*116.13*/.html.telco.Footer()),format.raw/*116.33*/("""

      """),_display_(/*118.8*/views/*118.13*/.html.telco.Loading()),format.raw/*118.34*/("""

    """),format.raw/*120.5*/("""</div>
  </body>
  <script type="text/javascript" src=""""),_display_(/*122.40*/routes/*122.46*/.JsController.jsMessages()),format.raw/*122.72*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*123.40*/routes/*123.46*/.JsController.javascriptRoutes),format.raw/*123.76*/(""""></script>
  <script src=""""),_display_(/*124.17*/routes/*124.23*/.Assets.versioned("assets/js/jquery.min.js")),format.raw/*124.67*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*126.17*/routes/*126.23*/.Assets.versioned("javascripts/landingPage/popper.min.js")),format.raw/*126.81*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*127.17*/routes/*127.23*/.Assets.versioned("javascripts/landingPage/bootstrap.min.js")),format.raw/*127.84*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*128.17*/routes/*128.23*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*128.77*/(""""></script>
  <script src=""""),_display_(/*129.17*/routes/*129.23*/.Assets.versioned("javascripts/landingPage/argon-design-system.js?v=1.2.2")),format.raw/*129.98*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*130.17*/routes/*130.23*/.Assets.versioned("assets/plugins/datatable/js/jquery.dataTables.min.js")),format.raw/*130.96*/(""""></script>

  <script src=""""),_display_(/*132.17*/routes/*132.23*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/moment.min.js")),format.raw/*132.109*/(""""></script>
  <script src=""""),_display_(/*133.17*/routes/*133.23*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.min.js")),format.raw/*133.136*/(""""></script>

  <script src=""""),_display_(/*135.17*/routes/*135.23*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*135.90*/(""""></script>
  <script src=""""),_display_(/*136.17*/routes/*136.23*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*136.96*/(""""></script>
  <script src=""""),_display_(/*137.17*/routes/*137.23*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*137.105*/(""""></script>
  <script src=""""),_display_(/*138.17*/routes/*138.23*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*138.75*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*140.17*/routes/*140.23*/.Assets.versioned("javascripts/importExcel/xlsx.full.min.js")),format.raw/*140.84*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*141.17*/routes/*141.23*/.Assets.versioned("javascripts/importExcel/jszip.js")),format.raw/*141.76*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*142.17*/routes/*142.23*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*142.82*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*144.17*/routes/*144.23*/.Assets.versioned("javascripts/views/telco/order/orderValidateForm.js")),format.raw/*144.94*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*145.17*/routes/*145.23*/.Assets.versioned("javascripts/views/telco/order/order_sim.js")),format.raw/*145.86*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*146.17*/routes/*146.23*/.Assets.versioned("javascripts/views/telco/order/order_sim_have.js")),format.raw/*146.91*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*147.17*/routes/*147.23*/.Assets.versioned("javascripts/views/telco/order/order_sim_have_chooseTB.js")),format.raw/*147.100*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*148.17*/routes/*148.23*/.Assets.versioned("javascripts/views/telco/order/order_sim_searchSubs.js")),format.raw/*148.97*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*149.17*/routes/*149.23*/.Assets.versioned("javascripts/views/telco/order/order_pay.js")),format.raw/*149.86*/("""" type="text/javascript"></script>

  """),_display_(/*151.4*/views/*151.9*/.html.BackToTop()),format.raw/*151.26*/("""

  """),format.raw/*153.3*/("""<script type="text/javascript">
          var userId = '"""),_display_(/*154.26*/userId),format.raw/*154.32*/("""';
          var roleCmp = '"""),_display_(/*155.27*/User/*155.31*/.CmpRole.getNameByCode(currentUser.getCmpRole)),format.raw/*155.77*/("""';
          console.log(roleCmp);
          var imgDefault = '"""),_display_(/*157.30*/routes/*157.36*/.Assets.versioned("images/market/default.png")),format.raw/*157.82*/("""';

          $(document).ready(function () """),format.raw/*159.41*/("""{"""),format.raw/*159.42*/("""
            """),format.raw/*160.13*/("""$('.date_timepicker').bootstrapMaterialDatePicker("""),format.raw/*160.63*/("""{"""),format.raw/*160.64*/("""
              """),format.raw/*161.15*/("""format: 'DD/MM/YYYY',
              time: false
            """),format.raw/*163.13*/("""}"""),format.raw/*163.14*/(""");
//            $("#notificationModal").modal('show');
            document.getElementById('filesConnectHaveSim').addEventListener('change', uploadFilesConnectHaveSim, false);

            // next button
            $(".next").on("""),format.raw/*168.27*/("""{"""),format.raw/*168.28*/("""
              """),format.raw/*169.15*/("""click: function () """),format.raw/*169.34*/("""{"""),format.raw/*169.35*/("""
                """),format.raw/*170.17*/("""if(this.value == 1)"""),format.raw/*170.36*/("""{"""),format.raw/*170.37*/("""
                  """),format.raw/*171.19*/("""if(listSerialTrue.length == 0)"""),format.raw/*171.49*/("""{"""),format.raw/*171.50*/("""
                    """),format.raw/*172.21*/("""showNotification('danger',Messages("Bạn chưa tải lên danh sách serial sim hợp lệ"));
                    return;
                  """),format.raw/*174.19*/("""}"""),format.raw/*174.20*/("""
                """),format.raw/*175.17*/("""}"""),format.raw/*175.18*/(""" """),format.raw/*175.19*/("""else if(this.value == 2)"""),format.raw/*175.43*/("""{"""),format.raw/*175.44*/("""
                  """),format.raw/*176.19*/("""var checkForm = validateFormInfoCustomer();
                  if(!checkForm)"""),format.raw/*177.33*/("""{"""),format.raw/*177.34*/("""
                    """),format.raw/*178.21*/("""return;
                  """),format.raw/*179.19*/("""}"""),format.raw/*179.20*/("""
                """),format.raw/*180.17*/("""}"""),format.raw/*180.18*/(""" """),format.raw/*180.19*/("""else if(this.value == 3)"""),format.raw/*180.43*/("""{"""),format.raw/*180.44*/("""
                  """),format.raw/*181.19*/("""var check = checkComfirmConnect();
                  if(!check)"""),format.raw/*182.29*/("""{"""),format.raw/*182.30*/("""
                    """),format.raw/*183.21*/("""return;
                  """),format.raw/*184.19*/("""}"""),format.raw/*184.20*/("""
                  """),format.raw/*185.19*/("""appendDataPayConnectSim();

                  uploadImgCt();
                """),format.raw/*188.17*/("""}"""),format.raw/*188.18*/("""

                """),format.raw/*190.17*/("""$("#progressBar").find(".active").next().addClass("active");
                $(this).parents(".row").fadeOut("slow", function () """),format.raw/*191.69*/("""{"""),format.raw/*191.70*/("""
                  """),format.raw/*192.19*/("""$(this).next(".row").fadeIn("slow");
                """),format.raw/*193.17*/("""}"""),format.raw/*193.18*/(""");
              """),format.raw/*194.15*/("""}"""),format.raw/*194.16*/("""
            """),format.raw/*195.13*/("""}"""),format.raw/*195.14*/(""");
            // back button
            $(".back").on("""),format.raw/*197.27*/("""{"""),format.raw/*197.28*/("""
              """),format.raw/*198.15*/("""click: function () """),format.raw/*198.34*/("""{"""),format.raw/*198.35*/("""
                """),format.raw/*199.17*/("""$("#progressBar .active").last().removeClass("active");
                $(this).parents(".row").fadeOut("slow", function () """),format.raw/*200.69*/("""{"""),format.raw/*200.70*/("""
                  """),format.raw/*201.19*/("""$(this).prev(".row").fadeIn("slow");
                """),format.raw/*202.17*/("""}"""),format.raw/*202.18*/(""");
              """),format.raw/*203.15*/("""}"""),format.raw/*203.16*/("""
            """),format.raw/*204.13*/("""}"""),format.raw/*204.14*/(""");
            //finish button
            $(".submit-button").on("""),format.raw/*206.36*/("""{"""),format.raw/*206.37*/("""
              """),format.raw/*207.15*/("""click: function () """),format.raw/*207.34*/("""{"""),format.raw/*207.35*/("""
                """),format.raw/*208.17*/("""$("#wizardRow").fadeOut(300);
                $(this).parents(".row").children("#successForm").fadeOut(300);
                $(this).parents(".row").children("#successMessage").fadeIn(3000);
              """),format.raw/*211.15*/("""}"""),format.raw/*211.16*/("""
            """),format.raw/*212.13*/("""}"""),format.raw/*212.14*/(""");
            //Active card on click function
//            $(".card").on("""),format.raw/*214.29*/("""{"""),format.raw/*214.30*/("""
"""),format.raw/*215.1*/("""//              click: function () """),format.raw/*215.36*/("""{"""),format.raw/*215.37*/("""
"""),format.raw/*216.1*/("""//                $(this).toggleClass("active-card");
//                $(this).parent(".col").siblings().children(".card").removeClass("active-card");
//                $(this).find(".form-check-input").attr("checked", true);
//                $(this).parent(".col").siblings().children(".card").find(".form-check-input").attr("checked", false);
//              """),format.raw/*220.17*/("""}"""),format.raw/*220.18*/("""
"""),format.raw/*221.1*/("""//            """),format.raw/*221.15*/("""}"""),format.raw/*221.16*/(""");
            //back to wizard
            $(".back-to-wizard").on("""),format.raw/*223.37*/("""{"""),format.raw/*223.38*/("""
              """),format.raw/*224.15*/("""click: function () """),format.raw/*224.34*/("""{"""),format.raw/*224.35*/("""
                """),format.raw/*225.17*/("""location.reload(true);
              """),format.raw/*226.15*/("""}"""),format.raw/*226.16*/("""
            """),format.raw/*227.13*/("""}"""),format.raw/*227.14*/(""");
          """),format.raw/*228.11*/("""}"""),format.raw/*228.12*/(""");
  </script>


</html>"""))
      }
    }
  }

  def render(currentUser:User,userId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,userId)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,userId) => apply(currentUser,userId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:53 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/order/OrderSubscribe.scala.html
                  HASH: e74f5fe0b1dd2728352563326df4cb969f08575d
                  MATRIX: 663->1|686->18|1037->52|1165->85|1192->86|1368->236|1407->255|1488->309|1503->315|1560->351|1596->470|1629->532|1662->538|1702->551|1717->557|1815->633|1881->672|1896->678|1986->747|2162->896|2177->902|2239->943|2292->1059|2324->1064|2364->1077|2379->1083|2449->1132|2512->1168|2527->1174|2664->1289|2730->1328|2745->1334|2818->1386|2885->1426|2900->1432|2985->1496|3051->1535|3066->1541|3142->1596|3208->1635|3223->1641|3304->1701|3623->1993|3638->1999|3688->2028|3743->2056|3758->2062|3821->2104|3947->2203|3962->2209|4031->2257|4794->2992|4845->3021|5040->3188|5094->3220|5289->3387|5339->3415|5534->3582|5578->3604|5950->3949|5964->3954|6032->4001|6076->4017|6283->4196|6326->4217|6495->4359|6509->4364|6587->4421|6631->4437|6846->4624|6888->4644|7057->4785|7100->4806|7269->4948|7283->4953|7360->5009|7404->5025|7619->5212|7661->5232|7830->5373|7873->5394|8043->5536|8058->5541|8123->5584|8168->5600|8384->5787|8427->5807|8649->6000|8691->6019|8822->6123|8837->6128|8912->6181|8947->6189|8962->6194|9045->6255|9080->6263|9095->6268|9171->6322|9207->6331|9222->6336|9264->6356|9300->6365|9315->6370|9358->6391|9392->6397|9476->6453|9492->6459|9540->6485|9619->6536|9635->6542|9687->6572|9743->6600|9759->6606|9825->6650|9905->6702|9921->6708|10001->6766|10080->6817|10096->6823|10179->6884|10258->6935|10274->6941|10350->6995|10406->7023|10422->7029|10519->7104|10598->7155|10614->7161|10709->7234|10766->7263|10782->7269|10891->7355|10947->7383|10963->7389|11099->7502|11156->7531|11172->7537|11261->7604|11317->7632|11333->7638|11428->7711|11484->7739|11500->7745|11605->7827|11661->7855|11677->7861|11751->7913|11831->7965|11847->7971|11930->8032|12009->8083|12025->8089|12100->8142|12179->8193|12195->8199|12276->8258|12356->8310|12372->8316|12465->8387|12544->8438|12560->8444|12645->8507|12724->8558|12740->8564|12830->8632|12909->8683|12925->8689|13025->8766|13104->8817|13120->8823|13216->8897|13295->8948|13311->8954|13396->9017|13462->9056|13476->9061|13515->9078|13547->9082|13632->9139|13660->9145|13717->9174|13731->9178|13799->9224|13891->9288|13907->9294|13975->9340|14048->9384|14078->9385|14120->9398|14199->9448|14229->9449|14273->9464|14362->9524|14392->9525|14652->9756|14682->9757|14726->9772|14774->9791|14804->9792|14850->9809|14898->9828|14928->9829|14976->9848|15035->9878|15065->9879|15115->9900|15275->10031|15305->10032|15351->10049|15381->10050|15411->10051|15464->10075|15494->10076|15542->10095|15647->10171|15677->10172|15727->10193|15782->10219|15812->10220|15858->10237|15888->10238|15918->10239|15971->10263|16001->10264|16049->10283|16141->10346|16171->10347|16221->10368|16276->10394|16306->10395|16354->10414|16460->10491|16490->10492|16537->10510|16695->10639|16725->10640|16773->10659|16855->10712|16885->10713|16931->10730|16961->10731|17003->10744|17033->10745|17118->10801|17148->10802|17192->10817|17240->10836|17270->10837|17316->10854|17469->10978|17499->10979|17547->10998|17629->11051|17659->11052|17705->11069|17735->11070|17777->11083|17807->11084|17902->11150|17932->11151|17976->11166|18024->11185|18054->11186|18100->11203|18334->11408|18364->11409|18406->11422|18436->11423|18540->11498|18570->11499|18599->11500|18663->11535|18693->11536|18722->11537|19114->11900|19144->11901|19173->11902|19216->11916|19246->11917|19343->11985|19373->11986|19417->12001|19465->12020|19495->12021|19541->12038|19607->12075|19637->12076|19679->12089|19709->12090|19751->12103|19781->12104
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|43->11|44->12|46->14|46->14|46->14|46->14|47->15|47->15|47->15|49->17|49->17|49->17|51->19|52->20|52->20|52->20|52->20|53->21|53->21|53->21|55->23|55->23|55->23|57->25|57->25|57->25|58->26|58->26|58->26|59->27|59->27|59->27|69->37|69->37|69->37|70->38|70->38|70->38|73->41|73->41|73->41|89->57|89->57|90->58|90->58|91->59|91->59|92->60|92->60|106->74|106->74|106->74|108->76|109->77|109->77|114->82|114->82|114->82|116->84|117->85|117->85|118->86|118->86|123->91|123->91|123->91|125->93|126->94|126->94|127->95|127->95|132->100|132->100|132->100|134->102|135->103|135->103|136->104|136->104|144->112|144->112|144->112|145->113|145->113|145->113|146->114|146->114|146->114|148->116|148->116|148->116|150->118|150->118|150->118|152->120|154->122|154->122|154->122|155->123|155->123|155->123|156->124|156->124|156->124|158->126|158->126|158->126|159->127|159->127|159->127|160->128|160->128|160->128|161->129|161->129|161->129|162->130|162->130|162->130|164->132|164->132|164->132|165->133|165->133|165->133|167->135|167->135|167->135|168->136|168->136|168->136|169->137|169->137|169->137|170->138|170->138|170->138|172->140|172->140|172->140|173->141|173->141|173->141|174->142|174->142|174->142|176->144|176->144|176->144|177->145|177->145|177->145|178->146|178->146|178->146|179->147|179->147|179->147|180->148|180->148|180->148|181->149|181->149|181->149|183->151|183->151|183->151|185->153|186->154|186->154|187->155|187->155|187->155|189->157|189->157|189->157|191->159|191->159|192->160|192->160|192->160|193->161|195->163|195->163|200->168|200->168|201->169|201->169|201->169|202->170|202->170|202->170|203->171|203->171|203->171|204->172|206->174|206->174|207->175|207->175|207->175|207->175|207->175|208->176|209->177|209->177|210->178|211->179|211->179|212->180|212->180|212->180|212->180|212->180|213->181|214->182|214->182|215->183|216->184|216->184|217->185|220->188|220->188|222->190|223->191|223->191|224->192|225->193|225->193|226->194|226->194|227->195|227->195|229->197|229->197|230->198|230->198|230->198|231->199|232->200|232->200|233->201|234->202|234->202|235->203|235->203|236->204|236->204|238->206|238->206|239->207|239->207|239->207|240->208|243->211|243->211|244->212|244->212|246->214|246->214|247->215|247->215|247->215|248->216|252->220|252->220|253->221|253->221|253->221|255->223|255->223|256->224|256->224|256->224|257->225|258->226|258->226|259->227|259->227|260->228|260->228
                  -- GENERATED --
              */
          