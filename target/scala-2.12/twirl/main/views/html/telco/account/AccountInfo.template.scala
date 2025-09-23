
package views.html.telco.account

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

object AccountInfo extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.20*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("account.title")),format.raw/*9.38*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),format.raw/*14.114*/("""

    """),format.raw/*16.5*/("""<link href=""""),_display_(/*16.18*/routes/*16.24*/.Assets.versioned("stylesheets/landingPage/argon-design-system.css?v=1.2.2")),format.raw/*16.100*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("assets/plugins/notifications/css/lobibox.min.css")),format.raw/*17.93*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("assets/css/icons.css")),format.raw/*18.65*/("""" rel="stylesheet">

    <link href=""""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("stylesheets/views/telco/account/account.css")),format.raw/*20.88*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("stylesheets/views/telco/telco2.css")),format.raw/*21.79*/("""" rel="stylesheet" />

  </head>

  <body class="landing-page">

    """),_display_(/*27.6*/views/*27.11*/.html.telco.Navbar(currentUser)),format.raw/*27.42*/("""

    """),format.raw/*29.5*/("""<div class="wrapper">

      <div class="section features-1">
        <div class="container">

        </div>
      </div>

      <div class="section features-1">
        <div class="container">
          <div class="row">
            <div class="col-md-12 mx-auto text-center">
              <span class="display-3 title-section">"""),_display_(/*41.54*/Messages("account.updateBusinessInfo")),format.raw/*41.92*/("""</span>
              """),format.raw/*42.93*/("""
            """),format.raw/*43.13*/("""</div>
            <div class="col-md-12 m-t-4">
              <span class="display-4 title-section-1">"""),_display_(/*45.56*/Messages("account.personalInfo")),format.raw/*45.88*/("""</span>
            </div>
            <div class="col-md-6 m-t-3">
              <div class="row m-b-4">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*49.73*/Messages("account.fullName")),format.raw/*49.101*/("""<span class="text-red">"""),_display_(/*49.125*/Messages("account.required")),format.raw/*49.153*/("""</span></label>
                <div class="col-sm-8">
                  <input id="nameAccount" type="text" class="form-control input-form" maxlength="50" autocomplete="off" required>
                </div>
              </div>
              <div class="row m-b-4">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*55.73*/Messages("account.email")),format.raw/*55.98*/("""</label>
                <div class="col-sm-8">
                  <input id="emailAccount" type="email" class="form-control input-form" maxlength="255" autocomplete="off" value=""""),_display_(/*57.132*/currentUser/*57.143*/.getUsername),format.raw/*57.155*/("""" readonly>
                </div>
              </div>
            </div>
            <div class="col-md-6 m-t-3">
              <div class="row m-b-4">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*63.73*/Messages("account.phoneNumber")),format.raw/*63.104*/("""<span class="text-red">"""),_display_(/*63.128*/Messages("account.required")),format.raw/*63.156*/("""</span></label>
                <div class="col-sm-8">
                  <input id="phoneAccount" type="number" class="form-control input-form" maxlength="14" autocomplete="off" value=""""),_display_(/*65.132*/currentUser/*65.143*/.getPhone),format.raw/*65.152*/("""">
                </div>
              </div>
              <div class="row m-b-4">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*69.73*/Messages("account.idNumber")),format.raw/*69.101*/("""<span class="text-red">"""),_display_(/*69.125*/Messages("account.required")),format.raw/*69.153*/("""</span></label>
                <div class="col-sm-8">
                  <input id="cmndAccount" type="text" class="form-control input-form" maxlength="15" autocomplete="off" required>
                </div>
              </div>
            </div>

          </div>
          <hr style="border-top: 1px solid #DEDEDE;">

          <div class="row">
            <div class="col-md-12">
              <span class="display-4 title-section-1">"""),_display_(/*81.56*/Messages("account.businessInfo")),format.raw/*81.88*/("""</span>
            </div>
            <div class="col-md-6 m-t-3">
              <div class="row m-b-4">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*85.73*/Messages("account.businessName")),format.raw/*85.105*/("""<span class="text-red">"""),_display_(/*85.129*/Messages("account.required")),format.raw/*85.157*/("""</span></label>
                <div class="col-sm-8">
                  <input id="nameCompanyAccount" type="text" class="form-control input-form" maxlength="50" autocomplete="off" required>
                </div>
              </div>
            </div>
            <div class="col-md-6 m-t-3">
              <div class="row m-b-4">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*93.73*/Messages("account.businessLicense")),format.raw/*93.108*/("""<span class="text-red">"""),_display_(/*93.132*/Messages("account.required")),format.raw/*93.160*/("""</span></label>
                <div class="col-sm-8">
                  <input id="gpkdAccount" type="email" class="form-control input-form" maxlength="255" autocomplete="off" required>
                </div>
              </div>
            </div>
            <div class="col-md-12">
              <div class="row m-b-4">
                <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*101.73*/Messages("account.companyAddress")),format.raw/*101.107*/("""<span class="text-red">"""),_display_(/*101.131*/Messages("account.required")),format.raw/*101.159*/("""</span></label>
                <div class="col-sm-10">
                  <input id="addressAccount" type="text" class="form-control input-form" maxlength="255" autocomplete="off" required>
                </div>
              </div>
            </div>
            <div class="col-md-6 m-t-3">
              <div class="row m-b-4">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*109.73*/Messages("account.idCardPhoto")),format.raw/*109.104*/("""</label>
                <div class="col-sm-8">
                  <div class="row">
                    <div class="col-md-4 position-relative">
                      <input id="imgOld1" type="text" class="form-control" hidden>
                      <input id="changeImg1" type="checkbox" hidden>
                      <div class="d-flex flex-column align-items-center text-center square-item" >
                        <img src=""""),_display_(/*116.36*/routes/*116.42*/.Assets.versioned("images/market/default.png")),format.raw/*116.88*/("""" id="wizardPicturePreview1" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">
                        <input id="wizard-picture-1" name="avatar" type="file" hidden/>
                        <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg1" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(1)"></i></div>
                      </div>
                    </div>
                    <div class="col-md-8 position-relative">
                      <label class="form-label ">"""),_display_(/*122.51*/Messages("account.uploadImage")),format.raw/*122.82*/("""</label><br>
                      <label class="form-label ">"""),_display_(/*123.51*/Messages("account.dragDropFile")),format.raw/*123.83*/("""<a onclick="$('#wizard-picture-1').click();" class="cursor-pointer text-danger">"""),_display_(/*123.164*/Messages("account.here")),format.raw/*123.188*/("""</a></label>
                    </div>
                    <div class="col-md-12 position-relative">
                      <small class="form-label ">"""),_display_(/*126.51*/Messages("account.fileRequirement")),format.raw/*126.86*/("""</small>
                    </div>
                  </div>
                  <div class="row m-t-5">
                    <div class="col-md-4 position-relative">
                      <input id="imgOld2" type="text" class="form-control" hidden>
                      <input id="changeImg2" type="checkbox" hidden>
                      <div class="d-flex flex-column align-items-center text-center square-item">
                        <img src=""""),_display_(/*134.36*/routes/*134.42*/.Assets.versioned("images/market/default.png")),format.raw/*134.88*/("""" id="wizardPicturePreview2" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">
                        <input id="wizard-picture-2" name="avatar" type="file" hidden/>
                        <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg2" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(2)"></i></div>
                      </div>
                    </div>
                    <div class="col-md-8 position-relative">
                      <label class="form-label ">"""),_display_(/*140.51*/Messages("account.uploadImage")),format.raw/*140.82*/("""</label><br>
                      <label class="form-label ">"""),_display_(/*141.51*/Messages("account.dragDropFile")),format.raw/*141.83*/("""<a onclick="$('#wizard-picture-2').click();" class="cursor-pointer text-danger">"""),_display_(/*141.164*/Messages("account.here")),format.raw/*141.188*/("""</a></label>
                    </div>
                    <div class="col-md-12 position-relative">
                      <small class="form-label ">"""),_display_(/*144.51*/Messages("account.fileRequirement")),format.raw/*144.86*/("""</small>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-6 m-t-3">
              <div class="row m-b-4">
                <label class="col-sm-4 col-form-label ">"""),_display_(/*152.58*/Messages("account.businessLicensePhoto")),format.raw/*152.98*/("""</label>
                <div class="col-sm-8">
                  <div class="row">
                    <div class="col-md-4 position-relative">
                      <input id="imgOld3" type="text" class="form-control" hidden>
                      <input id="changeImg3" type="checkbox" hidden>
                      <div class="d-flex flex-column align-items-center text-center square-item">
                        <img src=""""),_display_(/*159.36*/routes/*159.42*/.Assets.versioned("images/market/default.png")),format.raw/*159.88*/("""" id="wizardPicturePreview3" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">
                        <input id="wizard-picture-3" name="avatar" type="file" hidden/>
                        <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg3" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(3)"></i></div>
                      </div>
                    </div>
                    <div class="col-md-8 position-relative">
                      <label class="form-label ">"""),_display_(/*165.51*/Messages("account.uploadImage")),format.raw/*165.82*/("""</label><br>
                      <label class="form-label ">"""),_display_(/*166.51*/Messages("account.dragDropFile")),format.raw/*166.83*/("""<a onclick="$('#wizard-picture-3').click();" class="cursor-pointer text-danger">"""),_display_(/*166.164*/Messages("account.here")),format.raw/*166.188*/("""</a></label>
                    </div>
                    <div class="col-md-12 position-relative">
                      <small class="form-label ">"""),_display_(/*169.51*/Messages("account.fileRequirement")),format.raw/*169.86*/("""</small>
                    </div>
                  </div>
                  <div class="row m-t-5">
                    <div class="col-md-4 position-relative">
                      <input id="imgOld4" type="text" class="form-control" hidden>
                      <input id="changeImg4" type="checkbox" hidden>
                      <div class="d-flex flex-column align-items-center text-center square-item">
                        <img src=""""),_display_(/*177.36*/routes/*177.42*/.Assets.versioned("images/market/default.png")),format.raw/*177.88*/("""" id="wizardPicturePreview4" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">
                        <input id="wizard-picture-4" name="avatar" type="file" hidden/>
                        <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg4" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(4)"></i></div>
                      </div>
                    </div>
                    <div class="col-md-8 position-relative">
                      <label class="form-label ">"""),_display_(/*183.51*/Messages("account.uploadImage")),format.raw/*183.82*/("""</label><br>
                      <label class="form-label ">"""),_display_(/*184.51*/Messages("account.dragDropFile")),format.raw/*184.83*/("""<a onclick="$('#wizard-picture-4').click();" class="cursor-pointer text-danger">"""),_display_(/*184.164*/Messages("account.here")),format.raw/*184.188*/("""</a></label>
                    </div>
                    <div class="col-md-12 position-relative">
                      <small class="form-label ">"""),_display_(/*187.51*/Messages("account.fileRequirement")),format.raw/*187.86*/("""</small>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <hr style="border-top: 1px solid #DEDEDE;">

          <div class="row">
            <label class="col-sm-2 col-form-label text-center">
              <input class="form-check-input" type="checkbox" id="agreeDksdAccount" onchange="agreeDksd(this)">
            </label>
            <div class="col-sm-10">
              <label>"""),_display_(/*201.23*/Messages("account.agreementText")),format.raw/*201.56*/("""</label>
              <br>
              <label>"""),_display_(/*203.23*/Messages("account.termsDetail")),format.raw/*203.54*/("""<a href="#" style="color: #00a5bb; font-style: italic;">"""),_display_(/*203.111*/Messages("account.here")),format.raw/*203.135*/("""</a></label>
            </div>
          </div>
          <div class="row m-t-3">
            <div class="col-md-12 mx-auto text-center">
              <button id="buttonVerifyAccount" type="button" class="btn btn-telco" style="background: #EA0033; color: #FFFFFF;" onclick="otpPhone()" disabled>"""),_display_(/*208.160*/Messages("common.confirm")),format.raw/*208.186*/("""</button>
            </div>
          </div>

        </div>
      </div>

      """),_display_(/*215.8*/views/*215.13*/.html.telco.account.Account_otp()),format.raw/*215.46*/("""
      """),_display_(/*216.8*/views/*216.13*/.html.telco.account.Account_zoomImg()),format.raw/*216.50*/("""

      """),_display_(/*218.8*/views/*218.13*/.html.telco.Footer()),format.raw/*218.33*/("""

      """),_display_(/*220.8*/views/*220.13*/.html.Loading()),format.raw/*220.28*/("""

    """),format.raw/*222.5*/("""</div>
  </body>
  <script type="text/javascript" src=""""),_display_(/*224.40*/routes/*224.46*/.JsController.jsMessages()),format.raw/*224.72*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*225.40*/routes/*225.46*/.JsController.javascriptRoutes),format.raw/*225.76*/(""""></script>
  <script src=""""),_display_(/*226.17*/routes/*226.23*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*226.77*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*228.17*/routes/*228.23*/.Assets.versioned("javascripts/landingPage/jquery.min.js")),format.raw/*228.81*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*229.17*/routes/*229.23*/.Assets.versioned("javascripts/landingPage/popper.min.js")),format.raw/*229.81*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*230.17*/routes/*230.23*/.Assets.versioned("javascripts/landingPage/bootstrap.min.js")),format.raw/*230.84*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*231.17*/routes/*231.23*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*231.77*/(""""></script>
  <script src=""""),_display_(/*232.17*/routes/*232.23*/.Assets.versioned("javascripts/landingPage/argon-design-system.js?v=1.2.2")),format.raw/*232.98*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*234.17*/routes/*234.23*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*234.90*/(""""></script>
  <script src=""""),_display_(/*235.17*/routes/*235.23*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*235.96*/(""""></script>
  <script src=""""),_display_(/*236.17*/routes/*236.23*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*236.105*/(""""></script>
  <script src=""""),_display_(/*237.17*/routes/*237.23*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*237.75*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*239.17*/routes/*239.23*/.Assets.versioned("javascripts/views/telco/account/account.js")),format.raw/*239.86*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*240.17*/routes/*240.23*/.Assets.versioned("javascripts/views/telco/account/account_verify.js")),format.raw/*240.93*/("""" type="text/javascript"></script>

  """),_display_(/*242.4*/views/*242.9*/.html.BackToTop()),format.raw/*242.26*/("""

"""),format.raw/*244.1*/("""</html>"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:50 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/account/AccountInfo.scala.html
                  HASH: 181ce3ce9d86041fff47bb78343c99d70c5a13f1
                  MATRIX: 665->1|688->18|1029->52|1142->70|1169->71|1345->221|1390->246|1471->300|1486->306|1543->342|1751->630|1784->636|1824->649|1839->655|1937->731|2003->770|2018->776|2108->845|2174->884|2189->890|2251->931|2316->969|2331->975|2416->1039|2482->1078|2497->1084|2573->1139|2669->1209|2683->1214|2735->1245|2768->1251|3127->1583|3186->1621|3236->1721|3277->1734|3408->1838|3461->1870|3666->2048|3716->2076|3768->2100|3818->2128|4184->2467|4230->2492|4437->2671|4458->2682|4492->2694|4745->2920|4798->2951|4850->2975|4900->3003|5114->3189|5135->3200|5166->3209|5350->3366|5400->3394|5452->3418|5502->3446|5969->3886|6022->3918|6227->4096|6281->4128|6333->4152|6383->4180|6816->4586|6873->4621|6925->4645|6975->4673|7399->5069|7456->5103|7509->5127|7560->5155|7992->5559|8046->5590|8505->6021|8521->6027|8589->6073|9196->6652|9249->6683|9340->6746|9394->6778|9504->6859|9551->6883|9731->7035|9788->7070|10265->7519|10281->7525|10349->7571|10956->8150|11009->8181|11100->8244|11154->8276|11264->8357|11311->8381|11491->8533|11548->8568|11836->8828|11898->8868|12356->9298|12372->9304|12440->9350|13047->9929|13100->9960|13191->10023|13245->10055|13355->10136|13402->10160|13582->10312|13639->10347|14116->10796|14132->10802|14200->10848|14807->11427|14860->11458|14951->11521|15005->11553|15115->11634|15162->11658|15342->11810|15399->11845|15906->12324|15961->12357|16039->12407|16092->12438|16178->12495|16225->12519|16552->12817|16601->12843|16711->12926|16726->12931|16781->12964|16816->12972|16831->12977|16890->13014|16926->13023|16941->13028|16983->13048|17019->13057|17034->13062|17071->13077|17105->13083|17189->13139|17205->13145|17253->13171|17332->13222|17348->13228|17400->13258|17456->13286|17472->13292|17548->13346|17628->13398|17644->13404|17724->13462|17803->13513|17819->13519|17899->13577|17978->13628|17994->13634|18077->13695|18156->13746|18172->13752|18248->13806|18304->13834|18320->13840|18417->13915|18497->13967|18513->13973|18602->14040|18658->14068|18674->14074|18769->14147|18825->14175|18841->14181|18946->14263|19002->14291|19018->14297|19092->14349|19172->14401|19188->14407|19273->14470|19352->14521|19368->14527|19460->14597|19526->14636|19540->14641|19579->14658|19609->14660
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|46->14|48->16|48->16|48->16|48->16|49->17|49->17|49->17|50->18|50->18|50->18|52->20|52->20|52->20|53->21|53->21|53->21|59->27|59->27|59->27|61->29|73->41|73->41|74->42|75->43|77->45|77->45|81->49|81->49|81->49|81->49|87->55|87->55|89->57|89->57|89->57|95->63|95->63|95->63|95->63|97->65|97->65|97->65|101->69|101->69|101->69|101->69|113->81|113->81|117->85|117->85|117->85|117->85|125->93|125->93|125->93|125->93|133->101|133->101|133->101|133->101|141->109|141->109|148->116|148->116|148->116|154->122|154->122|155->123|155->123|155->123|155->123|158->126|158->126|166->134|166->134|166->134|172->140|172->140|173->141|173->141|173->141|173->141|176->144|176->144|184->152|184->152|191->159|191->159|191->159|197->165|197->165|198->166|198->166|198->166|198->166|201->169|201->169|209->177|209->177|209->177|215->183|215->183|216->184|216->184|216->184|216->184|219->187|219->187|233->201|233->201|235->203|235->203|235->203|235->203|240->208|240->208|247->215|247->215|247->215|248->216|248->216|248->216|250->218|250->218|250->218|252->220|252->220|252->220|254->222|256->224|256->224|256->224|257->225|257->225|257->225|258->226|258->226|258->226|260->228|260->228|260->228|261->229|261->229|261->229|262->230|262->230|262->230|263->231|263->231|263->231|264->232|264->232|264->232|266->234|266->234|266->234|267->235|267->235|267->235|268->236|268->236|268->236|269->237|269->237|269->237|271->239|271->239|271->239|272->240|272->240|272->240|274->242|274->242|274->242|276->244
                  -- GENERATED --
              */
          