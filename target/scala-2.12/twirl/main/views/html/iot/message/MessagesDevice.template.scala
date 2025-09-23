
package views.html.iot.message

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

object MessagesDevice extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(currentUser:User, deviceId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.37*/("""
"""),format.raw/*5.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*10.13*/Messages("Messages")),format.raw/*10.33*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*11.46*/routes/*11.52*/.Assets.versioned("images/logo.jpg")),format.raw/*11.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*16.6*/views/*16.11*/.html.iot.tags.Main_css()),format.raw/*16.36*/("""

    """),format.raw/*18.5*/("""<link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("stylesheets/views/group/style.min.css")),format.raw/*18.82*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*19.78*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*23.6*/views/*23.11*/.html.iot.tags.Menu(currentUser, "")),format.raw/*23.47*/("""

    """),_display_(/*25.6*/views/*25.11*/.html.iot.tags.Header(currentUser)),format.raw/*25.45*/("""

    """),format.raw/*27.5*/("""<div class="page-wrapper">
      <div class="page-content">

          <!--breadcrumb-->
        <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3 ">
          <div class="breadcrumb-title pe-3">"""),_display_(/*32.47*/Messages("manage.group.device")),format.raw/*32.78*/("""</div>
          <div class="ps-3">
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb mb-0 p-0">
                <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt "></i></a>
                </li>
                <li class="breadcrumb-item active " aria-current="page">"""),_display_(/*38.74*/Messages("message.title")),format.raw/*38.99*/("""</li>
              </ol>
            </nav>
          </div>
          <div class="ms-auto">

          </div>
        </div>
          <!--end breadcrumb-->

        <div class="card " style="height: 80vh;">
          <div class="chat-wrapper" style="height: 100%;">

            <div class="chat-sidebar" id="theme13">
              <div class="chat-sidebar-header">
                <div class="d-flex align-items-center">
                  <div class="chat-user-online">
                    <img src=""""),_display_(/*55.32*/routes/*55.38*/.Assets.versioned("images/logo2.png")),format.raw/*55.75*/("""" width="45" height="45" class="rounded-circle" alt="" />
                  </div>
                  <div class="flex-grow-1 ms-2">
                    <p class="mb-0">"""),_display_(/*58.38*/currentUser/*58.49*/.getUsername),format.raw/*58.61*/("""</p>
                  </div>
                  <div class="dropdown">
                    <div class="cursor-pointer font-24 dropdown-toggle dropdown-toggle-nocaret" data-bs-toggle="dropdown"><i class='bx bx-dots-horizontal-rounded'></i>
                    </div>
                    <div class="dropdown-menu dropdown-menu-end"> <a class="dropdown-item" href="javascript:;">Settings</a>
                      <div class="dropdown-divider"></div>	<a class="dropdown-item" href="javascript:;">Help & Feedback</a>
                      <a class="dropdown-item" href="javascript:;">Enable Split View Mode</a>
                      <a class="dropdown-item" href="javascript:;">Keyboard Shortcuts</a>
                    </div>
                  </div>
                </div>
                <div class="mb-3"></div>

              </div>
              <div class="chat-sidebar-content" >

                <ul class="nav nav-tabs" role="tablist" style="padding: 5px;">
                  <li class="nav-item" role="presentation" style="width: 50%;">
                    <a class="nav-link active" data-bs-toggle="tab" href="#tabMessage" role="tab" aria-selected="false">
                      <div class="d-flex align-items-center text-white">
                        <div class="tab-icon"><i class='bx bx-user-pin font-18 me-1'></i>
                        </div>
                        <div class="tab-title">"""),_display_(/*81.49*/Messages("message.sendTopic")),format.raw/*81.78*/("""</div>
                      </div>
                    </a>
                  </li>
                  <li class="nav-item" role="presentation" style="width: 50%;">
                    <a class="nav-link " data-bs-toggle="tab" href="#tabMetadata" role="tab" aria-selected="true">
                      <div class="d-flex align-items-center text-white">
                        <div class="tab-icon"><i class='bx bx-home font-18 me-1'></i>
                        </div>
                        <div class="tab-title">"""),_display_(/*90.49*/Messages("message.sendMess")),format.raw/*90.77*/("""</div>
                      </div>
                    </a>
                  </li>
                </ul>
                <div class="tab-content py-3" style="padding: 5px;">
                  <div class="tab-pane fade show active" id="tabMessage" role="tabpanel">
                  """),_display_(/*97.20*/views/*97.25*/.html.iot.message.MessagesDevice_tab_message()),format.raw/*97.71*/("""
                  """),format.raw/*98.19*/("""</div>
                  <div class="tab-pane fade" id="tabMetadata" role="tabpanel">
                    """),_display_(/*100.22*/views/*100.27*/.html.iot.message.MessagesDevice_tab_metadata()),format.raw/*100.74*/("""
                  """),format.raw/*101.19*/("""</div>
                </div>

              </div>
            </div>

            <div class="chat-header d-flex align-items-center">
              <div class="chat-toggle-btn"><i class='bx bx-menu-alt-left'></i>
              </div>
              <div>
                <h4 class="mb-1 font-weight-bold">"""),_display_(/*111.52*/deviceId),format.raw/*111.60*/("""</h4>
                <div class="list-inline d-sm-flex mb-0 d-none"> <a href="javascript:;" class="list-inline-item d-flex align-items-center"><small class='bx bxs-circle me-1 chart-online'></small>Active Now</a>
"""),format.raw/*113.102*/("""
"""),format.raw/*114.138*/("""
                """),format.raw/*115.17*/("""</div>
              </div>
            </div>
            <div class="chat-content">
              <div class="chat-content-leftside">
                <div id="listMessageOfDevice">

"""),format.raw/*122.109*/("""
"""),format.raw/*123.43*/("""
"""),format.raw/*124.68*/("""
"""),format.raw/*125.72*/("""
"""),format.raw/*126.75*/("""
"""),format.raw/*127.86*/("""
"""),format.raw/*128.33*/("""
"""),format.raw/*129.45*/("""
"""),format.raw/*130.33*/("""
"""),format.raw/*131.31*/("""

                """),format.raw/*133.17*/("""</div>
              </div>

            </div>
            <div class="chat-footer d-flex align-items-center">
              <div class="flex-grow-1 pe-2">
                <div class="input-group">	<span class="input-group-text"><i class='bx bx-message'></i></span>
                  <input type="text" id="messageToDevice" class="form-control" placeholder="Type a message">
                </div>
              </div>
              <div class="chat-footer-menu">
                <a onclick="processSendMessageToDevice()" style="cursor: pointer" title="Send Message"><i class='bx bxs-send'></i></a>
              </div>
            </div>
              <!--start chat overlay-->
            <div class="overlay chat-toggle-btn-mobile"></div>
              <!--end chat overlay-->
          </div>

        </div>
      </div>

      """),_display_(/*155.8*/views/*155.13*/.html.iot.message.MessagesDevice_sendMetadata()),format.raw/*155.60*/("""
      """),_display_(/*156.8*/views/*156.13*/.html.iot.message.MessagesDevice_tab_sendMessToDevice()),format.raw/*156.68*/("""

      """),_display_(/*158.8*/views/*158.13*/.html.Loading()),format.raw/*158.28*/("""

    """),format.raw/*160.5*/("""</div>
      <!--  END OF PAPER WRAP -->

    """),_display_(/*163.6*/views/*163.11*/.html.iot.tags.Main_js()),format.raw/*163.35*/("""

    """),format.raw/*165.5*/("""<script src=""""),_display_(/*165.19*/routes/*165.25*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*165.79*/(""""></script>
      <!--plugins-->
    <script src=""""),_display_(/*167.19*/routes/*167.25*/.Assets.versioned("assets/plugins/simplebar/js/simplebar.min.js")),format.raw/*167.90*/(""""></script>
    <script src=""""),_display_(/*168.19*/routes/*168.25*/.Assets.versioned("assets/plugins/metismenu/js/metisMenu.min.js")),format.raw/*168.90*/(""""></script>
    <script src=""""),_display_(/*169.19*/routes/*169.25*/.Assets.versioned("assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js")),format.raw/*169.102*/(""""></script>

    <script src=""""),_display_(/*171.19*/routes/*171.25*/.Assets.versioned("javascripts/SearchJs.js")),format.raw/*171.69*/("""" type="text/javascript"></script>

    <script>
      var deviceId = '"""),_display_(/*174.24*/deviceId),format.raw/*174.32*/("""';
    </script>

    <script src=""""),_display_(/*177.19*/routes/*177.25*/.Assets.versioned("javascripts/views/message/metadata.js")),format.raw/*177.83*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*178.19*/routes/*178.25*/.Assets.versioned("javascripts/views/message/message.js")),format.raw/*178.82*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*179.19*/routes/*179.25*/.Assets.versioned("javascripts/views/message/sendMessToDevice.js")),format.raw/*179.91*/("""" type="text/javascript"></script>

    <script type="text/javascript">
      var paramMessage = "";
      $(document).ready(function () """),format.raw/*183.37*/("""{"""),format.raw/*183.38*/("""
        """),format.raw/*184.9*/("""document.getElementById('invalidCheckData').onclick = function(e)"""),format.raw/*184.74*/("""{"""),format.raw/*184.75*/("""
          """),format.raw/*185.11*/("""checkCheckBoxShowData();
        """),format.raw/*186.9*/("""}"""),format.raw/*186.10*/(""";
        document.getElementById('invalidCheckEvents').onclick = function(e)"""),format.raw/*187.76*/("""{"""),format.raw/*187.77*/("""
          """),format.raw/*188.11*/("""checkCheckBoxShowData();
        """),format.raw/*189.9*/("""}"""),format.raw/*189.10*/(""";
        document.getElementById('invalidCheckAppControls').onclick = function(e)"""),format.raw/*190.81*/("""{"""),format.raw/*190.82*/("""
          """),format.raw/*191.11*/("""checkCheckBoxShowData();
        """),format.raw/*192.9*/("""}"""),format.raw/*192.10*/(""";
        document.getElementById('invalidCheckDeviceControls').onclick = function(e)"""),format.raw/*193.84*/("""{"""),format.raw/*193.85*/("""
          """),format.raw/*194.11*/("""checkCheckBoxShowData();
        """),format.raw/*195.9*/("""}"""),format.raw/*195.10*/(""";
      """),format.raw/*196.7*/("""}"""),format.raw/*196.8*/(""")
    </script>
  </body>
</html>
"""))
      }
    }
  }

  def render(currentUser:User,deviceId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,deviceId)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,deviceId) => apply(currentUser,deviceId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:45 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/message/MessagesDevice.scala.html
                  HASH: 640be00022d6cb18ff3913c43c3d7650b704da9b
                  MATRIX: 663->1|686->18|722->48|1073->82|1203->117|1230->118|1399->260|1440->280|1521->334|1536->340|1593->376|1800->557|1814->562|1860->587|1893->593|1933->606|1948->612|2027->670|2093->709|2108->715|2183->769|2273->833|2287->838|2344->874|2377->881|2391->886|2446->920|2479->926|2721->1141|2773->1172|3123->1495|3169->1520|3702->2026|3717->2032|3775->2069|3971->2238|3991->2249|4024->2261|5460->3670|5510->3699|6055->4217|6104->4245|6416->4530|6430->4535|6497->4581|6544->4600|6679->4707|6694->4712|6763->4759|6811->4778|7146->5085|7176->5093|7420->5408|7451->5546|7497->5563|7711->5855|7741->5898|7771->5966|7801->6038|7831->6113|7861->6199|7891->6232|7921->6277|7951->6310|7981->6341|8028->6359|8890->7194|8905->7199|8974->7246|9009->7254|9024->7259|9101->7314|9137->7323|9152->7328|9189->7343|9223->7349|9297->7396|9312->7401|9358->7425|9392->7431|9434->7445|9450->7451|9526->7505|9605->7556|9621->7562|9708->7627|9766->7657|9782->7663|9869->7728|9927->7758|9943->7764|10043->7841|10102->7872|10118->7878|10184->7922|10284->7994|10314->8002|10378->8038|10394->8044|10474->8102|10555->8155|10571->8161|10650->8218|10731->8271|10747->8277|10835->8343|11001->8480|11031->8481|11068->8490|11162->8555|11192->8556|11232->8567|11293->8600|11323->8601|11429->8678|11459->8679|11499->8690|11560->8723|11590->8724|11701->8806|11731->8807|11771->8818|11832->8851|11862->8852|11976->8937|12006->8938|12046->8949|12107->8982|12137->8983|12173->8991|12202->8992
                  LINES: 24->1|25->2|26->3|31->4|36->4|37->5|42->10|42->10|43->11|43->11|43->11|48->16|48->16|48->16|50->18|50->18|50->18|50->18|51->19|51->19|51->19|55->23|55->23|55->23|57->25|57->25|57->25|59->27|64->32|64->32|70->38|70->38|87->55|87->55|87->55|90->58|90->58|90->58|113->81|113->81|122->90|122->90|129->97|129->97|129->97|130->98|132->100|132->100|132->100|133->101|143->111|143->111|145->113|146->114|147->115|154->122|155->123|156->124|157->125|158->126|159->127|160->128|161->129|162->130|163->131|165->133|187->155|187->155|187->155|188->156|188->156|188->156|190->158|190->158|190->158|192->160|195->163|195->163|195->163|197->165|197->165|197->165|197->165|199->167|199->167|199->167|200->168|200->168|200->168|201->169|201->169|201->169|203->171|203->171|203->171|206->174|206->174|209->177|209->177|209->177|210->178|210->178|210->178|211->179|211->179|211->179|215->183|215->183|216->184|216->184|216->184|217->185|218->186|218->186|219->187|219->187|220->188|221->189|221->189|222->190|222->190|223->191|224->192|224->192|225->193|225->193|226->194|227->195|227->195|228->196|228->196
                  -- GENERATED --
              */
          