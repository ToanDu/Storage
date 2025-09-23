
package views.html.iot.project

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

object ProjectList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.20*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("project.title")),format.raw/*9.38*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/group/style.min.css")),format.raw/*17.82*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*18.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("assets/plugins/smart-wizard/css/smart_wizard_all.min.css")),format.raw/*19.101*/("""" rel="stylesheet" type="text/css" />
    <link href=""""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("assets/plugins/select2/css/select2.min.css")),format.raw/*20.87*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("assets/plugins/select2/css/select2-bootstrap4.css")),format.raw/*21.94*/("""" rel="stylesheet" />
    <style>
            .dropdown-menu::after """),format.raw/*23.35*/("""{"""),format.raw/*23.36*/("""
              """),format.raw/*24.15*/("""content: '';
              width: 13px;
              height: 13px;
              background: #FFFFFF;
              position: absolute;
              top: -6px;
              left: 10px;
              transform: rotate(45deg);
              border-top: 1px solid #767676;
              border-left: 1px solid #767676;
            """),format.raw/*34.13*/("""}"""),format.raw/*34.14*/("""

      """),format.raw/*36.7*/(""".bx-dots-horizontal-rounded """),format.raw/*36.35*/("""{"""),format.raw/*36.36*/("""
        """),format.raw/*37.9*/("""color: #aaaaaa !important;
      """),format.raw/*38.7*/("""}"""),format.raw/*38.8*/("""

      """),format.raw/*40.7*/(""".contentSolution """),format.raw/*40.24*/("""{"""),format.raw/*40.25*/("""
        """),format.raw/*41.9*/("""overflow: hidden;
        display: -webkit-box;
        -webkit-line-clamp: 3;
        -webkit-box-orient: vertical;
      """),format.raw/*45.7*/("""}"""),format.raw/*45.8*/("""
      """),format.raw/*46.7*/(""".contentSolution:hover """),format.raw/*46.30*/("""{"""),format.raw/*46.31*/("""
        """),format.raw/*47.9*/("""display: inherit;
      """),format.raw/*48.7*/("""}"""),format.raw/*48.8*/("""

            """),format.raw/*50.13*/(""".select2-container--bootstrap4 .select2-dropdown .select2-results__option[aria-selected=true] """),format.raw/*50.107*/("""{"""),format.raw/*50.108*/("""
              """),format.raw/*51.15*/("""background-color: #EC1B2E;
              color: #ffffff;
            """),format.raw/*53.13*/("""}"""),format.raw/*53.14*/("""
            """),format.raw/*54.13*/(""".select2-container--bootstrap4 .select2-dropdown .select2-results__option """),format.raw/*54.87*/("""{"""),format.raw/*54.88*/("""
              """),format.raw/*55.15*/("""color: #ffffff;
            """),format.raw/*56.13*/("""}"""),format.raw/*56.14*/("""
    """),format.raw/*57.5*/("""</style>
  </head>
  <body class="bg-theme">

    <div class="sidebar-header" style="background-color: white">
      <div>
        <img src=""""),_display_(/*63.20*/routes/*63.26*/.Assets.versioned("images/login/logo.svg")),format.raw/*63.68*/("""" class="logo-icon" alt="logo icon" style="width: 95%;">
      </div>

      <div class="toggle-icon ms-auto" id="arrowMenu" style="display: none"><i class='bx bx-arrow-to-left'></i>
      </div>
    </div>

    <header>
      <div class="topbar d-flex align-items-center">

        <nav class="navbar navbar-expand">
          <div class="mobile-toggle-menu"><i class='bx bx-menu'></i>
          </div>

          <div class="top-menu ms-auto">
            <ul class="navbar-nav align-items-center">
              <li class="nav-item dropdown dropdown-large">

              </li>
            </ul>
          </div>
          <div class="user-box dropdown">
            <a class="d-flex align-items-center nav-link dropdown-toggle dropdown-toggle-nocaret" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              <img src=""""),_display_(/*86.26*/routes/*86.32*/.Assets.versioned("images/avatar_small2x.jpg")),format.raw/*86.78*/("""" class="user-img" alt="user avatar">
              <div class="user-info ps-3">
                <p class="user-name mb-0" style="font-size: 18px;">"""),_display_(/*88.69*/currentUser/*88.80*/.getUsername),format.raw/*88.92*/("""</p>
                """),format.raw/*89.99*/("""
              """),format.raw/*90.15*/("""</div>
            </a>
            <ul class="dropdown-menu dropdown-menu-end">
              <li>
                <a class="dropdown-item" href=""""),_display_(/*94.49*/routes/*94.55*/.LandingPageController.home()),format.raw/*94.84*/("""">
                  <i class='bx bx-home-circle'></i><span>"""),_display_(/*95.59*/Messages("Trang chủ")),format.raw/*95.80*/("""</span>
                </a>
              </li>
              <li>
                <a class="dropdown-item" href=""""),_display_(/*99.49*/routes/*99.55*/.TelcoAccountController.accountInfo(currentUser.getId)),format.raw/*99.109*/("""">
                  <i class='bx bx-credit-card'></i><span>"""),_display_(/*100.59*/Messages("Quản lý sim/thuê bao")),format.raw/*100.91*/("""</span>
                </a>
              </li>
              <li>
                <a class="dropdown-item" href=""""),_display_(/*104.49*/routes/*104.55*/.UserTenantListController.userTenantList()),format.raw/*104.97*/("""" target="_blank">
                  <i class='bx bx-user'></i><span>"""),_display_(/*105.52*/Messages("Quản lý User Tenant")),format.raw/*105.83*/("""</span>
                </a>
              </li>
              <li>
                <a class="dropdown-item" href="javascript:;" data-bs-toggle="modal" data-bs-target="#createDeviceTokenModal">
                  <i class='bx bx-devices'></i><span>"""),_display_(/*110.55*/Messages("user.createDeviceToken")),format.raw/*110.89*/("""</span>
                </a>
              </li>
              <li>
                <a class="dropdown-item" href="javascript:;" data-bs-toggle="modal" data-bs-target="#getDeviceTokenModal">
                  <i class='bx bx-download'></i><span>"""),_display_(/*115.56*/Messages("user.deviceToken")),format.raw/*115.84*/("""</span>
                </a>
              </li>
              <li><a class="dropdown-item" href="javascript:;"><i class='bx bx-vector'></i><span>"""),_display_(/*118.99*/Messages("Version ")),_display_(/*118.120*/currentUser/*118.131*/.getVersion),format.raw/*118.142*/("""</span></a>
              </li>
              <li>
                <div class="dropdown-divider mb-0"></div>
              </li>
              <li><a class="dropdown-item" href=""""),_display_(/*123.51*/routes/*123.57*/.Application.logout()),format.raw/*123.78*/(""""><i class='bx bx-log-out-circle'></i><span>Logout</span></a>
              </li>
            </ul>

          </div>
        </nav>
      </div>
    </header>

    <div class="page-wrapper" style="margin-left: 0px">

      <div class="col-md-12">
        <div class="row">
          <div class="col-md-1"></div>
          <div class="col-md-7" style="padding: 40px 0px 35px 35px">
            <div class="input-group">
              <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF ">"""),_display_(/*139.110*/Messages("DỰ ÁN ")),format.raw/*139.128*/("""</span>
            </div>
          </div>
          <div class="col-md-3" style="padding: 40px">
            <div class="input-group" style="float: right">
              """),format.raw/*144.192*/("""
              """),format.raw/*145.15*/("""<span class="input-group-text" onclick="focusSearchTree()"><i class='bx bx-search-alt'></i></span>
              <input id="search" class="search-input form-control border-start-0" placeholder="" maxlength="30">
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-12">
        <div class="row">

          <div class="col-md-1"></div>
          <div class="col-md-10">
            <div class="row" id="listProject">
            </div>
          </div>

          <div class="col-md-1">
            """),format.raw/*161.85*/("""
              """),format.raw/*162.133*/("""
              """),format.raw/*163.60*/("""
            """),format.raw/*164.21*/("""
          """),format.raw/*165.11*/("""</div>


        </div>
      </div>

      """),_display_(/*171.8*/views/*171.13*/.html.iot.project.ProjectList_add()),format.raw/*171.48*/("""
      """),_display_(/*172.8*/views/*172.13*/.html.iot.project.ProjectList_edit()),format.raw/*172.49*/("""
      """),_display_(/*173.8*/views/*173.13*/.html.iot.project.ProjectList_del()),format.raw/*173.48*/("""
      """),_display_(/*174.8*/views/*174.13*/.html.iot.project.ProjectList_solutionMaket()),format.raw/*174.58*/("""
      """),_display_(/*175.8*/views/*175.13*/.html.iot.project.ProjectList_solutionMaket_fleet()),format.raw/*175.64*/("""
      """),_display_(/*176.8*/views/*176.13*/.html.iot.project.ProjectList_solutionMaket_asset()),format.raw/*176.64*/("""
      """),_display_(/*177.8*/views/*177.13*/.html.iot.project.ProjectList_solutionMaket_smartWater()),format.raw/*177.69*/("""
      """),_display_(/*178.8*/views/*178.13*/.html.iot.project.ProjectList_solutionMaket_smartFarm()),format.raw/*178.68*/("""
      """),_display_(/*179.8*/views/*179.13*/.html.iot.project.ProjectList_solutionMaket_smartHome()),format.raw/*179.68*/("""

      """),_display_(/*181.8*/views/*181.13*/.html.user.UserList_createDeviceToken()),format.raw/*181.52*/("""
      """),_display_(/*182.8*/views/*182.13*/.html.iot.DeviceIot.DeviceIot_getToken(currentUser)),format.raw/*182.64*/("""

      """),_display_(/*184.8*/views/*184.13*/.html.iot.project.ProjectList_activePhone()),format.raw/*184.56*/("""

      """),_display_(/*186.8*/views/*186.13*/.html.Loading()),format.raw/*186.28*/("""

    """),format.raw/*188.5*/("""</div>
      <!--  END OF PAPER WRAP -->

    <script type="text/javascript" src=""""),_display_(/*191.42*/routes/*191.48*/.JsController.jsMessages()),format.raw/*191.74*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*192.42*/routes/*192.48*/.JsController.javascriptRoutes),format.raw/*192.78*/(""""></script>
    <script src=""""),_display_(/*193.19*/routes/*193.25*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*193.79*/("""" type="text/javascript"></script>

    <script type="text/javascript" src=""""),_display_(/*195.42*/routes/*195.48*/.Assets.versioned("assets/js/jquery.min.js")),format.raw/*195.92*/(""""></script>
      <!--notification js -->
    <script src=""""),_display_(/*197.19*/routes/*197.25*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*197.92*/(""""></script>
    <script src=""""),_display_(/*198.19*/routes/*198.25*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*198.98*/(""""></script>
    <script src=""""),_display_(/*199.19*/routes/*199.25*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*199.107*/(""""></script>

    <script src=""""),_display_(/*201.19*/routes/*201.25*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*201.77*/("""" type="text/javascript"></script>
    <script type="text/javascript">
            $(document).ready(function()"""),format.raw/*203.41*/("""{"""),format.raw/*203.42*/("""
              """),_display_(/*204.16*/if(flash.containsKey("success"))/*204.48*/ {_display_(Seq[Any](format.raw/*204.50*/("""
              """),format.raw/*205.15*/("""showNotification('success','"""),_display_(/*205.44*/flash/*205.49*/.get("success")),format.raw/*205.64*/("""');
              """)))}),format.raw/*206.16*/("""
              """),_display_(/*207.16*/if(flash.containsKey("failed"))/*207.47*/ {_display_(Seq[Any](format.raw/*207.49*/("""
              """),format.raw/*208.15*/("""showNotification('danger','"""),_display_(/*208.43*/flash/*208.48*/.get("failed")),format.raw/*208.62*/("""');
              """)))}),format.raw/*209.16*/("""
            """),format.raw/*210.13*/("""}"""),format.raw/*210.14*/(""");

            function commingSoonNoti() """),format.raw/*212.40*/("""{"""),format.raw/*212.41*/("""
              """),format.raw/*213.15*/("""info_noti('Comming soon!');
            """),format.raw/*214.13*/("""}"""),format.raw/*214.14*/("""

            """),format.raw/*216.13*/("""var currentUserId = '"""),_display_(/*216.35*/currentUser/*216.46*/.getId),format.raw/*216.52*/("""';
            var imgProject0 = """"),_display_(/*217.33*/routes/*217.39*/.Assets.versioned("images/iotplatform.png")),format.raw/*217.82*/("""";
            var imgProject1 = """"),_display_(/*218.33*/routes/*218.39*/.Assets.versioned("images/smarthome.jpg")),format.raw/*218.80*/("""";
            var imgProject2 = """"),_display_(/*219.33*/routes/*219.39*/.Assets.versioned("images/smartfarm.jpg")),format.raw/*219.80*/("""";
    </script>
    <script src=""""),_display_(/*221.19*/routes/*221.25*/.Assets.versioned("javascripts/plugins/moment.min.js")),format.raw/*221.79*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*223.19*/routes/*223.25*/.Assets.versioned("assets/js/chosen.jquery.min.js")),format.raw/*223.76*/(""""></script>

    <script src=""""),_display_(/*225.19*/routes/*225.25*/.Assets.versioned("assets/plugins/metismenu/js/metisMenu.min.js")),format.raw/*225.90*/(""""></script>

    <script src=""""),_display_(/*227.19*/routes/*227.25*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*227.79*/(""""></script>
      <!--plugins-->
    <script src=""""),_display_(/*229.19*/routes/*229.25*/.Assets.versioned("assets/plugins/select2/js/select2.min.js")),format.raw/*229.86*/(""""></script>
    <script src=""""),_display_(/*230.19*/routes/*230.25*/.Assets.versioned("assets/plugins/simplebar/js/simplebar.min.js")),format.raw/*230.90*/(""""></script>
    <script src=""""),_display_(/*231.19*/routes/*231.25*/.Assets.versioned("assets/plugins/smart-wizard/js/jquery.smartWizard.min.js")),format.raw/*231.102*/(""""></script>

    <script src=""""),_display_(/*233.19*/routes/*233.25*/.Assets.versioned("javascripts/views/ErrorCode.js")),format.raw/*233.76*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*235.19*/routes/*235.25*/.Assets.versioned("javascripts/views/user/User_deviceToken.js")),format.raw/*235.88*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*237.19*/routes/*237.25*/.Assets.versioned("javascripts/views/project/project.js")),format.raw/*237.82*/(""""></script>
    <script src=""""),_display_(/*238.19*/routes/*238.25*/.Assets.versioned("javascripts/views/project/projectEdit.js")),format.raw/*238.86*/(""""></script>
    <script src=""""),_display_(/*239.19*/routes/*239.25*/.Assets.versioned("javascripts/views/project/projectDel.js")),format.raw/*239.85*/(""""></script>

    <script src=""""),_display_(/*241.19*/routes/*241.25*/.Assets.versioned("javascripts/views/project/project_createTemplate.js")),format.raw/*241.97*/(""""></script>
    <script src=""""),_display_(/*242.19*/routes/*242.25*/.Assets.versioned("javascripts/views/project/project_createTemplate_fleet.js")),format.raw/*242.103*/(""""></script>
    <script src=""""),_display_(/*243.19*/routes/*243.25*/.Assets.versioned("javascripts/views/project/project_createTemplate_smartWater.js")),format.raw/*243.108*/(""""></script>
    <script src=""""),_display_(/*244.19*/routes/*244.25*/.Assets.versioned("javascripts/views/project/project_createTemplate_asset.js")),format.raw/*244.103*/(""""></script>
    <script src=""""),_display_(/*245.19*/routes/*245.25*/.Assets.versioned("javascripts/views/project/project_createTemplate_smartFarm.js")),format.raw/*245.107*/(""""></script>
    <script src=""""),_display_(/*246.19*/routes/*246.25*/.Assets.versioned("javascripts/views/project/project_createTemplate_smartHome.js")),format.raw/*246.107*/(""""></script>

    <script>
            function focusSearchTree() """),format.raw/*249.40*/("""{"""),format.raw/*249.41*/("""
              """),format.raw/*250.15*/("""$("#search-selectOrg").focus();
            """),format.raw/*251.13*/("""}"""),format.raw/*251.14*/("""

            """),format.raw/*253.13*/("""var iconProject = """"),_display_(/*253.33*/routes/*253.39*/.Assets.versioned("images/iotIcon.jpg")),format.raw/*253.78*/("""";
            var imgAddProject = """"),_display_(/*254.35*/routes/*254.41*/.Assets.versioned("images/project/add.png")),format.raw/*254.84*/("""";

            var imgProject0 = """"),_display_(/*256.33*/routes/*256.39*/.Assets.versioned("images/iotplatform.png")),format.raw/*256.82*/("""";
            var imgProject1 = """"),_display_(/*257.33*/routes/*257.39*/.Assets.versioned("images/smarthome.jpg")),format.raw/*257.80*/("""";
            var imgProject2 = """"),_display_(/*258.33*/routes/*258.39*/.Assets.versioned("images/smartfarm.jpg")),format.raw/*258.80*/("""";
            var imgCommingSoon = """"),_display_(/*259.36*/routes/*259.42*/.Assets.versioned("images/dashboard/comingSoon.png")),format.raw/*259.94*/("""";

      var phone = '"""),_display_(/*261.21*/currentUser/*261.32*/.getPhone),format.raw/*261.41*/("""';
      console.log(phone);
    </script>
    <script src=""""),_display_(/*264.19*/routes/*264.25*/.Assets.versioned("javascripts/views/project/activePhone.js")),format.raw/*264.86*/(""""></script>

  </body>
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
                  DATE: Mon Sep 22 16:32:46 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/project/ProjectList.scala.html
                  HASH: fe9e7930fbc301ebfa86934700b0743675d3a851
                  MATRIX: 663->1|686->18|1027->52|1140->70|1167->71|1335->213|1380->238|1461->292|1476->298|1533->334|1740->515|1754->520|1800->545|1833->551|1873->564|1888->570|1967->628|2033->667|2048->673|2123->727|2189->766|2204->772|2303->849|2385->904|2400->910|2484->973|2550->1012|2565->1018|2656->1088|2752->1156|2781->1157|2824->1172|3183->1503|3212->1504|3247->1512|3303->1540|3332->1541|3368->1550|3428->1583|3456->1584|3491->1592|3536->1609|3565->1610|3601->1619|3751->1742|3779->1743|3813->1750|3864->1773|3893->1774|3929->1783|3980->1807|4008->1808|4050->1822|4173->1916|4203->1917|4246->1932|4343->2001|4372->2002|4413->2015|4515->2089|4544->2090|4587->2105|4643->2133|4672->2134|4704->2139|4873->2281|4888->2287|4951->2329|5832->3183|5847->3189|5914->3235|6090->3384|6110->3395|6143->3407|6192->3510|6235->3525|6410->3673|6425->3679|6475->3708|6563->3769|6605->3790|6748->3906|6763->3912|6839->3966|6928->4027|6982->4059|7126->4175|7142->4181|7206->4223|7304->4293|7357->4324|7633->4572|7689->4606|7963->4852|8013->4880|8188->5027|8231->5048|8253->5059|8287->5070|8494->5249|8510->5255|8553->5276|9111->5805|9152->5823|9354->6172|9398->6187|9962->6794|10007->6927|10051->6987|10093->7008|10133->7019|10205->7064|10220->7069|10277->7104|10312->7112|10327->7117|10385->7153|10420->7161|10435->7166|10492->7201|10527->7209|10542->7214|10609->7259|10644->7267|10659->7272|10732->7323|10767->7331|10782->7336|10855->7387|10890->7395|10905->7400|10983->7456|11018->7464|11033->7469|11110->7524|11145->7532|11160->7537|11237->7592|11273->7601|11288->7606|11349->7645|11384->7653|11399->7658|11472->7709|11508->7718|11523->7723|11588->7766|11624->7775|11639->7780|11676->7795|11710->7801|11821->7884|11837->7890|11885->7916|11966->7969|11982->7975|12034->8005|12092->8035|12108->8041|12184->8095|12289->8172|12305->8178|12371->8222|12459->8282|12475->8288|12564->8355|12622->8385|12638->8391|12733->8464|12791->8494|12807->8500|12912->8582|12971->8613|12987->8619|13061->8671|13201->8782|13231->8783|13275->8799|13317->8831|13358->8833|13402->8848|13459->8877|13474->8882|13511->8897|13562->8916|13606->8932|13647->8963|13688->8965|13732->8980|13788->9008|13803->9013|13839->9027|13890->9046|13932->9059|13962->9060|14034->9103|14064->9104|14108->9119|14177->9159|14207->9160|14250->9174|14300->9196|14321->9207|14349->9213|14412->9248|14428->9254|14493->9297|14556->9332|14572->9338|14635->9379|14698->9414|14714->9420|14777->9461|14840->9496|14856->9502|14932->9556|15014->9610|15030->9616|15103->9667|15162->9698|15178->9704|15265->9769|15324->9800|15340->9806|15416->9860|15495->9911|15511->9917|15594->9978|15652->10008|15668->10014|15755->10079|15813->10109|15829->10115|15929->10192|15988->10223|16004->10229|16077->10280|16159->10334|16175->10340|16260->10403|16342->10457|16358->10463|16437->10520|16495->10550|16511->10556|16594->10617|16652->10647|16668->10653|16750->10713|16809->10744|16825->10750|16919->10822|16977->10852|16993->10858|17094->10936|17152->10966|17168->10972|17274->11055|17332->11085|17348->11091|17449->11169|17507->11199|17523->11205|17628->11287|17686->11317|17702->11323|17807->11405|17901->11470|17931->11471|17975->11486|18048->11530|18078->11531|18121->11545|18169->11565|18185->11571|18246->11610|18311->11647|18327->11653|18392->11696|18456->11732|18472->11738|18537->11781|18600->11816|18616->11822|18679->11863|18742->11898|18758->11904|18821->11945|18887->11983|18903->11989|18977->12041|19029->12065|19050->12076|19081->12085|19170->12146|19186->12152|19269->12213
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|51->19|51->19|52->20|52->20|52->20|53->21|53->21|53->21|55->23|55->23|56->24|66->34|66->34|68->36|68->36|68->36|69->37|70->38|70->38|72->40|72->40|72->40|73->41|77->45|77->45|78->46|78->46|78->46|79->47|80->48|80->48|82->50|82->50|82->50|83->51|85->53|85->53|86->54|86->54|86->54|87->55|88->56|88->56|89->57|95->63|95->63|95->63|118->86|118->86|118->86|120->88|120->88|120->88|121->89|122->90|126->94|126->94|126->94|127->95|127->95|131->99|131->99|131->99|132->100|132->100|136->104|136->104|136->104|137->105|137->105|142->110|142->110|147->115|147->115|150->118|150->118|150->118|150->118|155->123|155->123|155->123|171->139|171->139|176->144|177->145|193->161|194->162|195->163|196->164|197->165|203->171|203->171|203->171|204->172|204->172|204->172|205->173|205->173|205->173|206->174|206->174|206->174|207->175|207->175|207->175|208->176|208->176|208->176|209->177|209->177|209->177|210->178|210->178|210->178|211->179|211->179|211->179|213->181|213->181|213->181|214->182|214->182|214->182|216->184|216->184|216->184|218->186|218->186|218->186|220->188|223->191|223->191|223->191|224->192|224->192|224->192|225->193|225->193|225->193|227->195|227->195|227->195|229->197|229->197|229->197|230->198|230->198|230->198|231->199|231->199|231->199|233->201|233->201|233->201|235->203|235->203|236->204|236->204|236->204|237->205|237->205|237->205|237->205|238->206|239->207|239->207|239->207|240->208|240->208|240->208|240->208|241->209|242->210|242->210|244->212|244->212|245->213|246->214|246->214|248->216|248->216|248->216|248->216|249->217|249->217|249->217|250->218|250->218|250->218|251->219|251->219|251->219|253->221|253->221|253->221|255->223|255->223|255->223|257->225|257->225|257->225|259->227|259->227|259->227|261->229|261->229|261->229|262->230|262->230|262->230|263->231|263->231|263->231|265->233|265->233|265->233|267->235|267->235|267->235|269->237|269->237|269->237|270->238|270->238|270->238|271->239|271->239|271->239|273->241|273->241|273->241|274->242|274->242|274->242|275->243|275->243|275->243|276->244|276->244|276->244|277->245|277->245|277->245|278->246|278->246|278->246|281->249|281->249|282->250|283->251|283->251|285->253|285->253|285->253|285->253|286->254|286->254|286->254|288->256|288->256|288->256|289->257|289->257|289->257|290->258|290->258|290->258|291->259|291->259|291->259|293->261|293->261|293->261|296->264|296->264|296->264
                  -- GENERATED --
              */
          