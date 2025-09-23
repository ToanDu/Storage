
package views.html.iot.overview

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
/*5.2*/import vn.m2m.utils.UserHelper
/*6.2*/import vn.m2m.common.models.forms.SearchObjectData

object Overview extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*7.2*/(currentUser:User, projectId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*201.16*/fromTime/*201.24*/ = {{
                import java.util.Calendar
                import java.text.SimpleDateFormat

                val today = Calendar.getInstance
                today.add(Calendar.DATE,-1);
                val curTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm")
                curTimeFormat.format(today.getTime)
              }};def /*210.16*/toTime/*210.22*/ = {{
                import java.util.Calendar
                import java.text.SimpleDateFormat
                //import java.util.TimeZone

                val today = Calendar.getInstance()
                // today.setTimeZone(TimeZone.getTimeZone("GMT+7"))
                val curTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm")
                curTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT+7"));
                curTimeFormat.format(today.getTime)
              }};
Seq[Any](format.raw/*7.38*/("""
"""),format.raw/*8.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*13.13*/Messages("overview.title")),format.raw/*13.39*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*14.46*/routes/*14.52*/.Assets.versioned("images/logo.jpg")),format.raw/*14.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*19.6*/views/*19.11*/.html.iot.tags.Main_css()),format.raw/*19.36*/("""

    """),format.raw/*21.5*/("""<link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("stylesheets/views/group/style.min.css")),format.raw/*21.82*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*22.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*23.18*/routes/*23.24*/.Assets.versioned("stylesheets/views/overview/slider.css")),format.raw/*23.82*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*24.18*/routes/*24.24*/.Assets.versioned("stylesheets/views/overview/slider2.css")),format.raw/*24.83*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*25.18*/routes/*25.24*/.Assets.versioned("stylesheets/views/overview/overview.css")),format.raw/*25.84*/("""" rel="stylesheet" />

    """),format.raw/*27.96*/("""
    """),format.raw/*28.5*/("""<link href='"""),_display_(/*28.18*/routes/*28.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*28.73*/("""' type='text/css'>
    <link href=""""),_display_(/*29.18*/routes/*29.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*29.99*/("""" rel="stylesheet">
    <link href=""""),_display_(/*30.18*/routes/*30.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*30.139*/("""" rel="stylesheet" >

  </head>
  <body class="bg-theme">
    """),_display_(/*34.6*/views/*34.11*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*34.54*/("""

    """),_display_(/*36.6*/views/*36.11*/.html.iot.tags.Header(currentUser)),format.raw/*36.45*/("""

    """),format.raw/*38.5*/("""<div class="page-wrapper">
      <div class="page-content">
        <h4 id="nameProjectTitle"></h4>

        """),format.raw/*42.28*/("""
        """),format.raw/*43.9*/("""<div class="col-md-12 mt-3">
          <div class="row mb-4">
            <div class="col-sm-9">
              <div class="breadcrumb-title pe-3 breadcrumbTitle" >"""),_display_(/*46.68*/Messages("overview.monitor")),format.raw/*46.96*/("""</div>
            </div>
            <div class="col-sm-3">
              <div class="inner-addon left-addon">
                <input id="searchDashboard" class="form-control inputSearch" type="text" placeholder="" maxlength="50">
                <i class="glyphicon bx bx-search"></i>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <h6 class="mb-0 mb-2" id="titleNotDashboard" style="display: none">"""),_display_(/*57.79*/Messages("overview.youNotDashboard")),format.raw/*57.115*/("""</h6>

          <div class="col-md-12">
            <div class='demo-container'>
              <div class='carousel' id="listDashboard">

              </div>
            </div>
          </div>
        </div>

        """),format.raw/*68.21*/("""
        """),format.raw/*69.9*/("""<div class="col-md-12 mt-3">
          <div class="row mb-4">
            <div class="col-sm-9">
              <div class="breadcrumb-title pe-3 breadcrumbTitle" >"""),_display_(/*72.68*/Messages("overview.app")),format.raw/*72.92*/("""</div>
            </div>
            <div class="col-sm-3">
              <div class="inner-addon left-addon">
                <input id="searchApp" class="form-control inputSearch" type="text" placeholder="" maxlength="50">
                <i class="glyphicon bx bx-search"></i>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <h6 class="mb-0 mb-2">"""),_display_(/*83.34*/Messages("overview.youNotApp")),format.raw/*83.64*/("""</h6>
          <div class="col-md-4">
            <div class="card w-100">
              <div class="row g-0">
                <div class="card-header border-bottom" style="background-color: #aaa;">
                  <div class="d-flex align-items-center">
                    <div>
                      <h6 class="mb-0" style="color: white; text-transform: uppercase;">Ứng dụng mẫu</h6>
                    </div>
                    <div class="font-22 ms-auto text-white"><i class="bx bx-dots-horizontal-rounded"></i>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row g-0">
                <div class="col-md-6">
                  <img src=""""),_display_(/*99.30*/routes/*99.36*/.Assets.versioned("images/dashboard/comingSoon.png")),format.raw/*99.88*/("""" alt="..." class="card-img" style="height: 100%; padding: 15px">
                </div>
                <div class="col-md-6">
                  <div class="card-body" style="height: 100%;overflow: auto; min-height: 100px">
                    """),format.raw/*103.63*/("""
                    """),format.raw/*104.21*/("""<p class="card-text">Ngày tạo: 20 - 11 - 2021</p>
                    <p class="card-text"><small class="">Thông tin mô tả : ...comming soon!</small>
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="col-md-4">
            <div class="ml-auto mr-auto text-center" style="">
              <button type="button" class="btn px-5 radius-15 modal-title" style="padding: 15px; background-color: #aaa; color: white; float: left">
                <i class="bx bx-plus-circle mr-1"></i>Tạo mới ứng dụng
              </button>
            </div>
          </div>
        </div>

        """),format.raw/*122.17*/("""
        """),format.raw/*123.9*/("""<div class="col-md-12 mt-3">
          <div class="row mb-4">
            <div class="col-sm-9">
              <div class="breadcrumb-title pe-3 breadcrumbTitle" >"""),_display_(/*126.68*/Messages("overview.flow")),format.raw/*126.93*/("""</div>
            </div>
            <div class="col-sm-3">
              <div class="inner-addon left-addon">
                <input id="searchFlow" class="form-control inputSearch" type="text" placeholder="" maxlength="50">
                <i class="glyphicon bx bx-search"></i>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <h6 class="mb-0 mb-2" id="titleNotFlow" style="display: none">"""),_display_(/*137.74*/Messages("overview.youNotFlow")),format.raw/*137.105*/("""</h6>
          <div class="col-md-12">
            <div class='carousel' id="listFlowEngine">

            </div>
          </div>
        </div>

        """),format.raw/*145.30*/("""
        """),format.raw/*146.9*/("""<div class="col-md-12 mt-3">
          <div class="row mb-4">
            <div class="col-sm-9">
              <div class="breadcrumb-title pe-3 breadcrumbTitle" >"""),_display_(/*149.68*/Messages("overview.overviewData")),format.raw/*149.101*/("""</div>
            </div>
            <div class="col-sm-3">
              <div class="inner-addon left-addon">
                <input id="searchData" class="form-control inputSearch" type="text" placeholder="" maxlength="50">
                <i class="glyphicon bx bx-search"></i>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-4">
            <div class="card w-100">
              <div class="col">
                <div class="card bg-transparent shadow-none mb-0">
                  <div class="card-body text-center">
                    <p class="mb-1 text-danger">Tổng số thiết bị</p>
                    <h3 class="text-danger" id="countDevice">0</h3>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="col-md-4">
            <div class="card w-100">
              <div class="col">
                <div class="card bg-transparent shadow-none mb-0">
                  <div class="card-body text-center">
                    <p class="mb-1 text-danger">Tổng số user online </p>
                    <h3 class="text-danger" id="countMess">0</h3>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="col-md-4">
            <div class="card w-100">
              <div class="col">
                <div class="card bg-transparent shadow-none mb-0">
                  <div class="card-body text-center">
                    <p class="mb-1 text-danger">Tổng số người dùng</p>
                    <h3 class="text-danger" id="countUser">0</h3>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="col-md-12">
            <div class="card-body">
              """),format.raw/*209.16*/("""
              """),format.raw/*220.16*/("""

              """),format.raw/*222.15*/("""<div class="row">
                <div class="form-group col-md-3">
                  <div class="row">
                    <label class="col-md-3 col-form-label" style="text-align: center">"""),_display_(/*225.88*/Messages("Từ ")),format.raw/*225.103*/("""</label>
                    <div class="col-md-9">
                      <div class="form-group">
                        <input class="result form-control" type="text" id="date_timepicker_start" value=""""),_display_(/*228.107*/fromTime),format.raw/*228.115*/("""">
                      </div>
                    </div>
                  </div>
                </div>

                <div class="form-group col-md-3">
                  <div class="row">
                    <label class="col-md-3 col-form-label" style="text-align: center">"""),_display_(/*236.88*/Messages("Đến ")),format.raw/*236.104*/("""</label>
                    <div class="col-md-9">
                      <div class="form-group has-default">
                        <input class="result form-control" type="text" id="date_timepicker_end" value=""""),_display_(/*239.105*/toTime),format.raw/*239.111*/("""">
                      </div>
                    </div>
                  </div>
                </div>

                <div class="form-group col-md-2">
                  <div class="row">
                    <label class="col-md-5 col-form-label" style="text-align: center">"""),_display_(/*247.88*/Messages("Method")),format.raw/*247.106*/("""</label>
                    <div class="col-md-7">
                      <div class="form-group has-default">
                        <select class="form-control" id="methodRequest">
                          <option value="POST">"""),_display_(/*251.49*/Messages("POST")),format.raw/*251.65*/("""</option>
                          <option value="GET">"""),_display_(/*252.48*/Messages("GET")),format.raw/*252.63*/("""</option>
                          <option value="PUT">"""),_display_(/*253.48*/Messages("PUT")),format.raw/*253.63*/("""</option>
                          <option value="DELETE">"""),_display_(/*254.51*/Messages("DELETE")),format.raw/*254.69*/("""</option>
                        </select>
                      </div>
                    </div>
                  </div>
                </div>

                <div class="form-group col-md-2">
                  <div class="row">
                    <label class="col-md-5 col-form-label" style="text-align: center">"""),_display_(/*263.88*/Messages("URL")),format.raw/*263.103*/("""</label>
                    <div class="col-md-7">
                      <div class="form-group has-default">
                        <select class="form-control" id="urlRequest">
                          <option value="devices">"""),_display_(/*267.52*/Messages("devices")),format.raw/*267.71*/("""</option>
                          <option value="users">"""),_display_(/*268.50*/Messages("users")),format.raw/*268.67*/("""</option>
                          <option value="organizations">"""),_display_(/*269.58*/Messages("organizations")),format.raw/*269.83*/("""</option>
                          <option value="events">"""),_display_(/*270.51*/Messages("events")),format.raw/*270.69*/("""</option>
                          <option value="groups">"""),_display_(/*271.51*/Messages("groups")),format.raw/*271.69*/("""</option>
                          <option value="attributes">"""),_display_(/*272.55*/Messages("attributes")),format.raw/*272.77*/("""</option>
                          <option value="rpc">"""),_display_(/*273.48*/Messages("rpc")),format.raw/*273.63*/("""</option>
                        </select>
                      </div>
                    </div>
                  </div>
                </div>

                <div class="btn-group col-md-2" role="group">
                  <a type="button" class="btn btn-danger" id="buttonGetDataChart" onclick="getDataStatistical()" style="width: 48%">"""),_display_(/*281.134*/Messages("Áp dụng ")),format.raw/*281.154*/("""</a>
                </div>
              </div>

            </div>
          </div>

          <div class="col-md-4">
            <div class="card w-100">
              <div class="col">
                <div class="card bg-transparent shadow-none mb-0">
                  <div class="card-body text-center">
                    <p class="mb-1 text-danger">Thời gian request trung bình </p>
                    <h3 class="text-danger" id="avgLatency">0</h3>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="col-md-4">
            <div class="card w-100">
              <div class="col">
                <div class="card bg-transparent shadow-none mb-0">
                  <div class="card-body text-center">
                    <p class="mb-1 text-danger">Tổng số request</p>
                    <h3 class="text-danger" id="totalRequest">0</h3>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="col-md-4">
            <div class="card w-100">
              <div class="col">
                <div class="card bg-transparent shadow-none mb-0">
                  <div class="card-body text-center">
                    <p class="mb-1 text-danger">Tỉ lệ thành công </p>
                    <h3 class="text-danger" id="successRate">0</h3>
                  </div>
                </div>
              </div>
            </div>
          </div>

        </div>

        """),format.raw/*329.33*/("""
        """),format.raw/*330.59*/("""

      """),format.raw/*332.7*/("""</div>

      """),_display_(/*334.8*/views/*334.13*/.html.Loading()),format.raw/*334.28*/("""

    """),format.raw/*336.5*/("""</div>
      <!--  END OF PAPER WRAP -->

    """),_display_(/*339.6*/views/*339.11*/.html.iot.tags.Main_js()),format.raw/*339.35*/("""

    """),format.raw/*341.5*/("""<script>
      var projectId = '"""),_display_(/*342.25*/projectId),format.raw/*342.34*/("""';

      var img = '"""),_display_(/*344.19*/routes/*344.25*/.Assets.versioned("images/overview/flow.jpg")),format.raw/*344.70*/("""';
      var img1 = '"""),_display_(/*345.20*/routes/*345.26*/.Assets.versioned("images/overview/flow1.png")),format.raw/*345.72*/("""';
      var img2 = '"""),_display_(/*346.20*/routes/*346.26*/.Assets.versioned("images/overview/flow2.png")),format.raw/*346.72*/("""';
      var dashboard = '"""),_display_(/*347.25*/routes/*347.31*/.Assets.versioned("images/overview/dashboard.png")),format.raw/*347.81*/("""';
      var dashboard2 = '"""),_display_(/*348.26*/routes/*348.32*/.Assets.versioned("images/overview/dashboard2.png")),format.raw/*348.83*/("""';
      var dashboard3 = '"""),_display_(/*349.26*/routes/*349.32*/.Assets.versioned("images/overview/dashboard3.jpg")),format.raw/*349.83*/("""';

            $(document).ready(function () """),format.raw/*351.43*/("""{"""),format.raw/*351.44*/("""
              """),format.raw/*352.15*/("""$("#menu-overview").addClass("mm-active");

              $("#menu").metisMenu();
              for (var e = window.location, o = $(".metismenu li a").filter(function() """),format.raw/*355.88*/("""{"""),format.raw/*355.89*/("""
                """),format.raw/*356.17*/("""return this.href == e
              """),format.raw/*357.15*/("""}"""),format.raw/*357.16*/(""").addClass("").parent().addClass("mm-active"); o.is("li");) o = o.parent("").addClass("mm-show").parent("").addClass("mm-active");

              $('#date_timepicker_start').bootstrapMaterialDatePicker("""),format.raw/*359.71*/("""{"""),format.raw/*359.72*/("""
                """),format.raw/*360.17*/("""format: 'DD/MM/YYYY HH:mm',
//                time: false
              """),format.raw/*362.15*/("""}"""),format.raw/*362.16*/(""");
              $('#date_timepicker_end').bootstrapMaterialDatePicker("""),format.raw/*363.69*/("""{"""),format.raw/*363.70*/("""
                """),format.raw/*364.17*/("""format: 'DD/MM/YYYY HH:mm',
//                time: false
              """),format.raw/*366.15*/("""}"""),format.raw/*366.16*/(""");
            """),format.raw/*367.13*/("""}"""),format.raw/*367.14*/(""")
    </script>

    <script src=""""),_display_(/*370.19*/routes/*370.25*/.Assets.versioned("assets/plugins/apexcharts-bundle/js/apexcharts.min.js")),format.raw/*370.99*/(""""></script>
    <script src=""""),_display_(/*371.19*/routes/*371.25*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.min.js")),format.raw/*371.138*/(""""></script>

    <script src=""""),_display_(/*373.19*/routes/*373.25*/.Assets.versioned("javascripts/views/overview/listDashboard.js")),format.raw/*373.89*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*375.19*/routes/*375.25*/.Assets.versioned("javascripts/views/overview/Overview.js")),format.raw/*375.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*376.19*/routes/*376.25*/.Assets.versioned("javascripts/views/overview/Overview_flow.js")),format.raw/*376.89*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*377.19*/routes/*377.25*/.Assets.versioned("javascripts/views/overview/Overview_chart.js")),format.raw/*377.90*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*378.19*/routes/*378.25*/.Assets.versioned("javascripts/views/overview/Overview_statistical.js")),format.raw/*378.96*/("""" type="text/javascript"></script>

  </body>
</html>
"""))
      }
    }
  }

  def render(currentUser:User,projectId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,projectId)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,projectId) => apply(currentUser,projectId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:45 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/overview/Overview.scala.html
                  HASH: d97c74b72eaacf75db2f423e96dc0b3121af00c9
                  MATRIX: 664->1|687->18|723->48|763->82|805->118|843->150|1206->202|1323->8244|1341->8252|1694->8605|1710->8611|2220->238|2247->239|2416->381|2463->407|2544->461|2559->467|2616->503|2823->684|2837->689|2883->714|2916->720|2956->733|2971->739|3050->797|3116->836|3131->842|3206->896|3272->935|3287->941|3366->999|3432->1038|3447->1044|3527->1103|3593->1142|3608->1148|3689->1208|3744->1326|3776->1331|3816->1344|3831->1350|3901->1399|3964->1435|3979->1441|4075->1516|4139->1553|4154->1559|4291->1674|4380->1737|4394->1742|4458->1785|4491->1792|4505->1797|4560->1831|4593->1837|4730->1965|4766->1974|4957->2138|5006->2166|5496->2629|5554->2665|5802->2897|5838->2906|6029->3070|6074->3094|6513->3506|6564->3536|7314->4259|7329->4265|7402->4317|7676->4604|7726->4625|8436->5314|8473->5323|8665->5487|8712->5512|9193->5965|9247->5996|9432->6173|9469->6182|9661->6346|9717->6379|11610->8589|11654->9091|11699->9107|11918->9298|11956->9313|12190->9518|12221->9526|12530->9807|12569->9823|12813->10038|12842->10044|13151->10325|13192->10343|13452->10575|13490->10591|13575->10648|13612->10663|13697->10720|13734->10735|13822->10795|13862->10813|14212->11135|14250->11150|14510->11382|14551->11401|14638->11460|14677->11477|14772->11544|14819->11569|14907->11629|14947->11647|15035->11707|15075->11725|15167->11789|15211->11811|15296->11868|15333->11883|15706->12227|15749->12247|17300->13793|17338->13852|17374->13860|17416->13875|17431->13880|17468->13895|17502->13901|17576->13948|17591->13953|17637->13977|17671->13983|17732->14016|17763->14025|17813->14047|17829->14053|17896->14098|17946->14120|17962->14126|18030->14172|18080->14194|18096->14200|18164->14246|18219->14273|18235->14279|18307->14329|18363->14357|18379->14363|18452->14414|18508->14442|18524->14448|18597->14499|18672->14545|18702->14546|18746->14561|18944->14730|18974->14731|19020->14748|19085->14784|19115->14785|19346->14987|19376->14988|19422->15005|19523->15077|19553->15078|19653->15149|19683->15150|19729->15167|19830->15239|19860->15240|19904->15255|19934->15256|19997->15291|20013->15297|20109->15371|20167->15401|20183->15407|20319->15520|20378->15551|20394->15557|20480->15621|20562->15675|20578->15681|20659->15740|20740->15793|20756->15799|20842->15863|20923->15916|20939->15922|21026->15987|21107->16040|21123->16046|21216->16117
                  LINES: 24->1|25->2|26->3|27->4|28->5|29->6|34->7|38->201|38->201|46->210|46->210|57->7|58->8|63->13|63->13|64->14|64->14|64->14|69->19|69->19|69->19|71->21|71->21|71->21|71->21|72->22|72->22|72->22|73->23|73->23|73->23|74->24|74->24|74->24|75->25|75->25|75->25|77->27|78->28|78->28|78->28|78->28|79->29|79->29|79->29|80->30|80->30|80->30|84->34|84->34|84->34|86->36|86->36|86->36|88->38|92->42|93->43|96->46|96->46|107->57|107->57|118->68|119->69|122->72|122->72|133->83|133->83|149->99|149->99|149->99|153->103|154->104|172->122|173->123|176->126|176->126|187->137|187->137|195->145|196->146|199->149|199->149|251->209|252->220|254->222|257->225|257->225|260->228|260->228|268->236|268->236|271->239|271->239|279->247|279->247|283->251|283->251|284->252|284->252|285->253|285->253|286->254|286->254|295->263|295->263|299->267|299->267|300->268|300->268|301->269|301->269|302->270|302->270|303->271|303->271|304->272|304->272|305->273|305->273|313->281|313->281|361->329|362->330|364->332|366->334|366->334|366->334|368->336|371->339|371->339|371->339|373->341|374->342|374->342|376->344|376->344|376->344|377->345|377->345|377->345|378->346|378->346|378->346|379->347|379->347|379->347|380->348|380->348|380->348|381->349|381->349|381->349|383->351|383->351|384->352|387->355|387->355|388->356|389->357|389->357|391->359|391->359|392->360|394->362|394->362|395->363|395->363|396->364|398->366|398->366|399->367|399->367|402->370|402->370|402->370|403->371|403->371|403->371|405->373|405->373|405->373|407->375|407->375|407->375|408->376|408->376|408->376|409->377|409->377|409->377|410->378|410->378|410->378
                  -- GENERATED --
              */
          