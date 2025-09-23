
package views.html.report.log

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
/*2.2*/import vn.m2m.utils.DateUtil
/*3.2*/import vn.m2m.common.models.User
/*4.2*/import vn.m2m.iot.models.DeviceIot

object LogDevice extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,List[DeviceIot],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(currentUser:User, deviceList: List[DeviceIot]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.49*/("""
"""),format.raw/*6.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*11.13*/Messages("Report Log")),format.raw/*11.35*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*12.46*/routes/*12.52*/.Assets.versioned("images/logo.jpg")),format.raw/*12.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*17.6*/views/*17.11*/.html.iot.tags.Main_css()),format.raw/*17.36*/("""
    """),format.raw/*18.5*/("""<link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("stylesheets/views/scrollListItem.css")),format.raw/*18.81*/("""" rel="stylesheet"/>
  </head>
  <body class="bg-theme">
    """),_display_(/*21.6*/views/*21.11*/.html.iot.tags.Menu(currentUser, "")),format.raw/*21.47*/("""

    """),_display_(/*23.6*/views/*23.11*/.html.iot.tags.Header(currentUser)),format.raw/*23.45*/("""

    """),format.raw/*25.5*/("""<div class="page-wrapper">
      <div class="page-content">

        <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3 ">
          <div class="breadcrumb-title pe-3">"""),_display_(/*29.47*/Messages("STATISTICAL")),format.raw/*29.70*/("""</div>
          <div class="ps-3">
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb mb-0 p-0">
                <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt "></i></a>
                </li>
                <li class="breadcrumb-item active " aria-current="page">"""),_display_(/*35.74*/Messages("manage.report")),format.raw/*35.99*/("""</li>
              </ol>
            </nav>
          </div>
          <div class="ms-auto"></div>
        </div>

        <div class="card " style="height: 83vh;">
          <div class="chat-wrapper" style="height: 100%;">

            <div class="chat-sidebar">
              <div class="chat-sidebar-header">
                <div class="d-flex align-items-center">
                  <div class="chat-user-online">
                    <img src=""""),_display_(/*49.32*/routes/*49.38*/.Assets.versioned("images/logo2.png")),format.raw/*49.75*/("""" width="45" height="45" class="rounded-circle" alt="" />
                  </div>
                  <div class="flex-grow-1 ms-2">
                    <p class="mb-0 font-15">"""),_display_(/*52.46*/Messages("manage.deviceIot.list")),format.raw/*52.79*/("""</p>
                  </div>
                </div>
                <div class="mb-3"></div>

              </div>
              <div class="chat-sidebar-content bg-gradient-burning" id="listItem">
                <div class="customers-list tab-content py-3" style="padding: 5px;">
                  """),_display_(/*60.20*/for((device: DeviceIot)<- deviceList) yield /*60.57*/{_display_(Seq[Any](format.raw/*60.58*/("""
                    """),format.raw/*61.21*/("""<div class="form-check">
                      <input type="radio" class="form-check-input" id="dataCheck" name="radio-stacked" onclick="getLogDeviceById('"""),_display_(/*62.132*/device/*62.138*/.getId),format.raw/*62.144*/("""')" required>
                      <h4 class="mb-1 font-14 text-white">"""),_display_(/*63.60*/device/*63.66*/.getName),format.raw/*63.74*/("""</h4>
                      <p class="mb-0 font-13 text-white">"""),_display_(/*64.59*/device/*64.65*/.getId),format.raw/*64.71*/("""</p>
                    </div><hr>
                    """)))}),format.raw/*66.22*/("""
                """),format.raw/*67.17*/("""</div>
              </div>
            </div>

            <div class="chat-header d-flex align-items-center" style="background-color: white">
              <div class="chat-toggle-btn"><i class='bx bx-menu-alt-left'></i>
              </div>
              <div>
                <h4 class="mb-1 font-weight-bold" id="deviceIdCurent"></h4>
                <div class="list-inline d-sm-flex mb-0 d-none"> <a href="javascript:;" class="list-inline-item d-flex align-items-center">
                  <small class='bx bxs-circle me-1 chart-online'></small>"""),_display_(/*77.75*/Messages("report.message.log")),format.raw/*77.105*/("""</a>
                </div>
              </div>
            </div>

            <div class="chat-content">
              <div class="chat-content-leftside">
                <div id="listMessageOfDevice"></div>
              </div>
            </div>
              <!--start chat overlay-->
            <div class="overlay chat-toggle-btn-mobile"></div>
              <!--end chat overlay-->
          </div>

        </div>

      </div>

      """),_display_(/*96.8*/views/*96.13*/.html.Loading()),format.raw/*96.28*/("""
    """),format.raw/*97.5*/("""</div>
      <!--  END OF PAPER WRAP -->


  </body>

  """),_display_(/*103.4*/views/*103.9*/.html.iot.tags.Main_js()),format.raw/*103.33*/("""

  """),format.raw/*105.3*/("""<script src=""""),_display_(/*105.17*/routes/*105.23*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*105.77*/(""""></script>
    <!--plugins-->
  <script src=""""),_display_(/*107.17*/routes/*107.23*/.Assets.versioned("assets/plugins/simplebar/js/simplebar.min.js")),format.raw/*107.88*/(""""></script>
  <script src=""""),_display_(/*108.17*/routes/*108.23*/.Assets.versioned("assets/plugins/metismenu/js/metisMenu.min.js")),format.raw/*108.88*/(""""></script>
  <script src=""""),_display_(/*109.17*/routes/*109.23*/.Assets.versioned("assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js")),format.raw/*109.100*/(""""></script>
  <script>
          $(document).ready(function () """),format.raw/*111.41*/("""{"""),format.raw/*111.42*/("""
            """),format.raw/*112.13*/("""$("#menu-report").addClass("mm-active");
            $("#menu").metisMenu();
          """),format.raw/*114.11*/("""}"""),format.raw/*114.12*/(""")
  </script>

  <script src=""""),_display_(/*117.17*/routes/*117.23*/.Assets.versioned("javascripts/SearchJs.js")),format.raw/*117.67*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*119.17*/routes/*119.23*/.Assets.versioned("javascripts/views/report/logDevice.js")),format.raw/*119.81*/("""" type="text/javascript"></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,deviceList:List[DeviceIot]): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,deviceList)

  def f:((User,List[DeviceIot]) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,deviceList) => apply(currentUser,deviceList)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:49 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/report/log/LogDevice.scala.html
                  HASH: d13df261a2cafcd56aa9f7e7ec1ac1537b0df2df
                  MATRIX: 662->1|685->18|721->48|761->82|1118->118|1260->165|1287->166|1456->308|1499->330|1580->384|1595->390|1652->426|1859->607|1873->612|1919->637|1951->642|1991->655|2006->661|2084->718|2172->780|2186->785|2243->821|2276->828|2290->833|2345->867|2378->873|2592->1060|2636->1083|2986->1406|3032->1431|3508->1880|3523->1886|3581->1923|3785->2100|3839->2133|4168->2435|4221->2472|4260->2473|4309->2494|4493->2650|4509->2656|4537->2662|4637->2735|4652->2741|4681->2749|4772->2813|4787->2819|4814->2825|4902->2882|4947->2899|5527->3452|5579->3482|6052->3929|6066->3934|6102->3949|6134->3954|6218->4011|6232->4016|6278->4040|6310->4044|6352->4058|6368->4064|6444->4118|6519->4165|6535->4171|6622->4236|6678->4264|6694->4270|6781->4335|6837->4363|6853->4369|6953->4446|7045->4509|7075->4510|7117->4523|7233->4610|7263->4611|7322->4642|7338->4648|7404->4692|7484->4744|7500->4750|7580->4808
                  LINES: 24->1|25->2|26->3|27->4|32->5|37->5|38->6|43->11|43->11|44->12|44->12|44->12|49->17|49->17|49->17|50->18|50->18|50->18|50->18|53->21|53->21|53->21|55->23|55->23|55->23|57->25|61->29|61->29|67->35|67->35|81->49|81->49|81->49|84->52|84->52|92->60|92->60|92->60|93->61|94->62|94->62|94->62|95->63|95->63|95->63|96->64|96->64|96->64|98->66|99->67|109->77|109->77|128->96|128->96|128->96|129->97|135->103|135->103|135->103|137->105|137->105|137->105|137->105|139->107|139->107|139->107|140->108|140->108|140->108|141->109|141->109|141->109|143->111|143->111|144->112|146->114|146->114|149->117|149->117|149->117|151->119|151->119|151->119
                  -- GENERATED --
              */
          