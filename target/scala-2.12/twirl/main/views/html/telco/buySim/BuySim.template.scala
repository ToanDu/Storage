
package views.html.telco.buySim

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

object BuySim extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("order.title")),format.raw/*9.36*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">
    """),format.raw/*11.117*/("""
    """),format.raw/*12.62*/("""
    """),_display_(/*13.6*/views/*13.11*/.html.iot.tags.Main_css()),format.raw/*13.36*/("""
    """),format.raw/*14.5*/("""<link href=""""),_display_(/*14.18*/routes/*14.24*/.Assets.versioned("stylesheets/landingPage/argon-design-system.css?v=1.2.2")),format.raw/*14.100*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*15.18*/routes/*15.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*15.78*/("""" rel="stylesheet" />

    <link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("assets/plugins/notifications/css/lobibox.min.css")),format.raw/*17.93*/("""" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("assets/css/icons.css")),format.raw/*21.65*/("""" rel="stylesheet">
    <link href='"""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*22.73*/("""' type='text/css'>
    <link href=""""),_display_(/*23.18*/routes/*23.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*23.99*/("""" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" >
    <link href=""""),_display_(/*25.18*/routes/*25.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*25.139*/("""" rel="stylesheet" >

    <link href=""""),_display_(/*27.18*/routes/*27.24*/.Assets.versioned("stylesheets/views/datatable.css")),format.raw/*27.76*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*28.18*/routes/*28.24*/.Assets.versioned("stylesheets/views/telco/order/Order.css")),format.raw/*28.84*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*29.18*/routes/*29.24*/.Assets.versioned("stylesheets/views/telco/account/account.css")),format.raw/*29.88*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*30.18*/routes/*30.24*/.Assets.versioned("stylesheets/views/telco/telco2.css")),format.raw/*30.79*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*31.18*/routes/*31.24*/.Assets.versioned("assets/css/app.css")),format.raw/*31.63*/("""" rel="stylesheet">

    <link href=""""),_display_(/*33.18*/routes/*33.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*33.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*34.18*/routes/*34.24*/.Assets.versioned("stylesheets/views/telco/utilites/utilites.css")),format.raw/*34.90*/("""" rel="stylesheet" />
  </head>

  <body class="bg-theme">
    """),_display_(/*38.6*/views/*38.11*/.html.telco.Menu(currentUser, "", userId)),format.raw/*38.52*/("""
    """),_display_(/*39.6*/views/*39.11*/.html.telco.Header(currentUser)),format.raw/*39.42*/("""
    """),format.raw/*40.5*/("""<div class="page-wrapper">
      <div class="page-content">
        <div class="accordion" id="accordionSim">
          <div class="row">
            <div class="col-sm-12 col-md-2 utilities-item">

                <div class="accordion-item">
                  <h2 class="accordion-header" id="headingOne">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                      """),_display_(/*49.24*/Messages("order.sim")),format.raw/*49.45*/("""
                    """),format.raw/*50.21*/("""</button>
                  </h2>
                </div>
                <div class="accordion-item mt-2">
                  <h2 class="accordion-header" id="headingTwo">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                      """),_display_(/*56.24*/Messages("order.changeSim")),format.raw/*56.51*/("""
                    """),format.raw/*57.21*/("""</button>
                  </h2>
                </div>
             
            </div>
            <div class="col-sm-12 col-md-10" style="padding-left: 0px;">
              <div class="utilities-content" style="position: relative">
                <div class="accordion-item">
                  <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionSim">
                    """),_display_(/*66.22*/views/*66.27*/.html.telco.buySim.BuySim_oderSim()),format.raw/*66.62*/("""
                  """),format.raw/*67.19*/("""</div>
                </div>
                
                <div class="accordion-item">
                  <div id="collapseTwo" class="accordion-collapse collapse " aria-labelledby="headingTwo" data-bs-parent="#accordionSim">
                    """),_display_(/*72.22*/views/*72.27*/.html.telco.buySim.BuySim_changeSim()),format.raw/*72.64*/("""
                  """),format.raw/*73.19*/("""</div>
                </div>
               
              </div>
            </div>

          </div>

        </div>
      </div>
      """),_display_(/*83.8*/views/*83.13*/.html.telco.buySim.BuySim_chooseSubs_stock()),format.raw/*83.57*/("""
      """),_display_(/*84.8*/views/*84.13*/.html.telco.buySim.BuySim_finish(currentUser)),format.raw/*84.58*/("""
      """),_display_(/*85.8*/views/*85.13*/.html.telco.buySim.BuySim_finish_detail()),format.raw/*85.54*/("""


      """),_display_(/*88.8*/views/*88.13*/.html.telco.Loading()),format.raw/*88.34*/("""

    """),format.raw/*90.5*/("""</div>
  </body>
  <script type="text/javascript" src=""""),_display_(/*92.40*/routes/*92.46*/.JsController.jsMessages()),format.raw/*92.72*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*93.40*/routes/*93.46*/.JsController.javascriptRoutes),format.raw/*93.76*/(""""></script>
  <script src=""""),_display_(/*94.17*/routes/*94.23*/.Assets.versioned("assets/js/jquery.min.js")),format.raw/*94.67*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*96.17*/routes/*96.23*/.Assets.versioned("javascripts/landingPage/popper.min.js")),format.raw/*96.81*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*97.17*/routes/*97.23*/.Assets.versioned("javascripts/landingPage/bootstrap.min.js")),format.raw/*97.84*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*98.17*/routes/*98.23*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*98.77*/(""""></script>
  <script src=""""),_display_(/*99.17*/routes/*99.23*/.Assets.versioned("javascripts/landingPage/argon-design-system.js?v=1.2.2")),format.raw/*99.98*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*100.17*/routes/*100.23*/.Assets.versioned("assets/plugins/datatable/js/jquery.dataTables.min.js")),format.raw/*100.96*/(""""></script>

  <script src=""""),_display_(/*102.17*/routes/*102.23*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/moment.min.js")),format.raw/*102.109*/(""""></script>
  <script src=""""),_display_(/*103.17*/routes/*103.23*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.min.js")),format.raw/*103.136*/(""""></script>

  <script src=""""),_display_(/*105.17*/routes/*105.23*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*105.90*/(""""></script>
  <script src=""""),_display_(/*106.17*/routes/*106.23*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*106.96*/(""""></script>
  <script src=""""),_display_(/*107.17*/routes/*107.23*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*107.105*/(""""></script>
  <script src=""""),_display_(/*108.17*/routes/*108.23*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*108.75*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*110.17*/routes/*110.23*/.Assets.versioned("javascripts/importExcel/xlsx.full.min.js")),format.raw/*110.84*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*111.17*/routes/*111.23*/.Assets.versioned("javascripts/importExcel/jszip.js")),format.raw/*111.76*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*112.17*/routes/*112.23*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*112.82*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*114.17*/routes/*114.23*/.Assets.versioned("javascripts/views/telco/buySim/ValidateBuySim.js")),format.raw/*114.92*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*115.17*/routes/*115.23*/.Assets.versioned("javascripts/views/telco/buySim/BuySim.js")),format.raw/*115.84*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*116.17*/routes/*116.23*/.Assets.versioned("javascripts/views/telco/buySim/BuySim_packData.js")),format.raw/*116.93*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*117.17*/routes/*117.23*/.Assets.versioned("javascripts/views/telco/buySim/BuySim_chooseSubs.js")),format.raw/*117.95*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*118.17*/routes/*118.23*/.Assets.versioned("javascripts/views/telco/buySim/BuySim_comfirm.js")),format.raw/*118.92*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*119.17*/routes/*119.23*/.Assets.versioned("javascripts/views/telco/buySim/ChangeSim.js")),format.raw/*119.87*/("""" type="text/javascript"></script>
  
  <script src=""""),_display_(/*121.17*/routes/*121.23*/.Assets.versioned("javascripts/views/telco/utilities/miAddOn.js")),format.raw/*121.88*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*122.17*/routes/*122.23*/.Assets.versioned("javascripts/views/telco/utilities/blockSubs.js")),format.raw/*122.90*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*123.17*/routes/*123.23*/.Assets.versioned("javascripts/views/telco/utilities/export.js")),format.raw/*123.87*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*124.17*/routes/*124.23*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*124.83*/("""" type="text/javascript"></script>
  """),_display_(/*125.4*/views/*125.9*/.html.BackToTop()),format.raw/*125.26*/("""

  """),format.raw/*127.3*/("""<script type="text/javascript">
      var userId = '"""),_display_(/*128.22*/userId),format.raw/*128.28*/("""';

      $(document).ready(function () """),format.raw/*130.37*/("""{"""),format.raw/*130.38*/("""
          """),format.raw/*131.11*/("""$('#filesMiAddOnSubs').on('change', uploadMiAddonSubs);
      """),format.raw/*132.7*/("""}"""),format.raw/*132.8*/(""");

      function importFileMiAddOnSubs() """),format.raw/*134.40*/("""{"""),format.raw/*134.41*/("""
          """),format.raw/*135.11*/("""$("#filesMiAddOnSubs").click();
      """),format.raw/*136.7*/("""}"""),format.raw/*136.8*/("""

      """),format.raw/*138.7*/("""// ------------------------ STEP HANDLE ------------------------

      function findStepContainer(groupID) """),format.raw/*140.43*/("""{"""),format.raw/*140.44*/("""
          """),format.raw/*141.11*/("""const $container = $(`.step-container[data-group-id="$"""),format.raw/*141.65*/("""{"""),format.raw/*141.66*/("""groupID"""),format.raw/*141.73*/("""}"""),format.raw/*141.74*/(""""]`);
          if (!$container.length) """),format.raw/*142.35*/("""{"""),format.raw/*142.36*/("""
              """),format.raw/*143.15*/("""console.error('"""),_display_(/*143.31*/Messages("buySim.error.stepContainerNotFound")),format.raw/*143.77*/(""":', groupID);
              return null;
          """),format.raw/*145.11*/("""}"""),format.raw/*145.12*/("""
          """),format.raw/*146.11*/("""return $container;
      """),format.raw/*147.7*/("""}"""),format.raw/*147.8*/("""

      """),format.raw/*149.7*/("""function changeStep(groupID, direction = 'next') """),format.raw/*149.56*/("""{"""),format.raw/*149.57*/("""
          """),format.raw/*150.11*/("""const $container = findStepContainer(groupID);
          if (!$container) return;

          const $currentStep = $container.find('.step.active');
          const $targetStep = direction === 'next' 
              ? $currentStep.nextAll('.step').first()
              : $currentStep.prevAll('.step').first();

          if (!$targetStep.length) return;

          $currentStep.removeClass('active');
          $targetStep.addClass('active');
      """),format.raw/*162.7*/("""}"""),format.raw/*162.8*/("""

      """),format.raw/*164.7*/("""function nextStep(groupID) """),format.raw/*164.34*/("""{"""),format.raw/*164.35*/("""
          """),format.raw/*165.11*/("""changeStep(groupID, 'next');
      """),format.raw/*166.7*/("""}"""),format.raw/*166.8*/("""

      """),format.raw/*168.7*/("""function backStep(groupID) """),format.raw/*168.34*/("""{"""),format.raw/*168.35*/("""
          """),format.raw/*169.11*/("""changeStep(groupID, 'prev');
      """),format.raw/*170.7*/("""}"""),format.raw/*170.8*/("""

      """),format.raw/*172.7*/("""// ------------------------ PROCESS HANDLER ------------------------

      function nextProcess(btn, groupID) """),format.raw/*174.42*/("""{"""),format.raw/*174.43*/("""
          """),format.raw/*175.11*/("""const $btn = $(btn);
          if ($btn.prop("disabled")) return;

          $btn.prop("disabled", true);
          let stepValue = parseInt(btn.value);
          let isValid = true;

          switch (stepValue) """),format.raw/*182.30*/("""{"""),format.raw/*182.31*/("""
              case 1:
                  isValid = groupID === "orderSim" ? validateFormInfoDNOrderSim() : validateFormInfoDNChangeSim();
                  break;

              case 2:
                  if (groupID === "orderSim") """),format.raw/*188.47*/("""{"""),format.raw/*188.48*/("""
                      """),format.raw/*189.23*/("""isValid = validateFormChoosePack();
                      if (isValid) checkOrderInformation();
                  """),format.raw/*191.19*/("""}"""),format.raw/*191.20*/(""" """),format.raw/*191.21*/("""else """),format.raw/*191.26*/("""{"""),format.raw/*191.27*/("""
                      """),format.raw/*192.23*/("""checkChangeInformation();
                  """),format.raw/*193.19*/("""}"""),format.raw/*193.20*/("""
                  """),format.raw/*194.19*/("""break;

              case 3:
                  groupID === "orderSim" ? confirmOder() : confirmChangeSim();
                  break;
          """),format.raw/*199.11*/("""}"""),format.raw/*199.12*/("""

          """),format.raw/*201.11*/("""if (!isValid) """),format.raw/*201.25*/("""{"""),format.raw/*201.26*/("""
              """),format.raw/*202.15*/("""$btn.prop("disabled", false);
              return;
          """),format.raw/*204.11*/("""}"""),format.raw/*204.12*/("""

          """),format.raw/*206.11*/("""const $currentStepContent = $btn.closest(".step-content");
          const $nextStepContent = $currentStepContent.next(".step-content");

          if (!$nextStepContent.length) return;

          $currentStepContent.fadeOut("slow", function () """),format.raw/*211.59*/("""{"""),format.raw/*211.60*/("""
              """),format.raw/*212.15*/("""$nextStepContent.fadeIn("slow", function () """),format.raw/*212.59*/("""{"""),format.raw/*212.60*/("""
                  """),format.raw/*213.19*/("""$btn.prop("disabled", false);
              """),format.raw/*214.15*/("""}"""),format.raw/*214.16*/(""");
          """),format.raw/*215.11*/("""}"""),format.raw/*215.12*/(""");

          nextStep(groupID);
      """),format.raw/*218.7*/("""}"""),format.raw/*218.8*/("""

      """),format.raw/*220.7*/("""function backProcess(btn, groupID) """),format.raw/*220.42*/("""{"""),format.raw/*220.43*/("""
          """),format.raw/*221.11*/("""const $btn = $(btn);
          if ($btn.prop("disabled")) return;

          $btn.prop("disabled", true);

          const $currentStepContent = $btn.closest(".step-content");
          const $prevStepContent = $currentStepContent.prev(".step-content");

          $currentStepContent.fadeOut("slow", function () """),format.raw/*229.59*/("""{"""),format.raw/*229.60*/("""
              """),format.raw/*230.15*/("""$prevStepContent.fadeIn("slow", function () """),format.raw/*230.59*/("""{"""),format.raw/*230.60*/(""" 
                  """),format.raw/*231.19*/("""$btn.prop("disabled", false);
              """),format.raw/*232.15*/("""}"""),format.raw/*232.16*/(""");
          """),format.raw/*233.11*/("""}"""),format.raw/*233.12*/(""");

          backStep(groupID);
      """),format.raw/*236.7*/("""}"""),format.raw/*236.8*/("""

  """),format.raw/*238.3*/("""</script>

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
                  DATE: Mon Sep 22 16:32:51 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/buySim/BuySim.scala.html
                  HASH: a4c81454941d4e1fe2f90265588f236fd1a59ad8
                  MATRIX: 664->1|687->18|1030->52|1158->85|1185->86|1361->236|1404->259|1485->313|1500->319|1557->355|1593->474|1626->536|1658->542|1672->547|1718->572|1750->577|1790->590|1805->596|1903->672|1969->711|1984->717|2059->771|2126->811|2141->817|2231->886|2519->1147|2534->1153|2596->1194|2660->1231|2675->1237|2745->1286|2808->1322|2823->1328|2919->1403|3075->1532|3090->1538|3227->1653|3293->1692|3308->1698|3381->1750|3447->1789|3462->1795|3543->1855|3609->1894|3624->1900|3709->1964|3775->2003|3790->2009|3866->2064|3932->2103|3947->2109|4007->2148|4072->2186|4087->2192|4162->2246|4228->2285|4243->2291|4330->2357|4420->2421|4434->2426|4496->2467|4528->2473|4542->2478|4594->2509|4626->2514|5157->3018|5199->3039|5248->3060|5653->3438|5701->3465|5750->3486|6221->3930|6235->3935|6291->3970|6338->3989|6616->4240|6630->4245|6688->4282|6735->4301|6901->4441|6915->4446|6980->4490|7014->4498|7028->4503|7094->4548|7128->4556|7142->4561|7204->4602|7240->4612|7254->4617|7296->4638|7329->4644|7412->4700|7427->4706|7474->4732|7552->4783|7567->4789|7618->4819|7673->4847|7688->4853|7753->4897|7832->4949|7847->4955|7926->5013|8004->5064|8019->5070|8101->5131|8179->5182|8194->5188|8269->5242|8324->5270|8339->5276|8435->5351|8514->5402|8530->5408|8625->5481|8682->5510|8698->5516|8807->5602|8863->5630|8879->5636|9015->5749|9072->5778|9088->5784|9177->5851|9233->5879|9249->5885|9344->5958|9400->5986|9416->5992|9521->6074|9577->6102|9593->6108|9667->6160|9747->6212|9763->6218|9846->6279|9925->6330|9941->6336|10016->6389|10095->6440|10111->6446|10192->6505|10272->6557|10288->6563|10379->6632|10458->6683|10474->6689|10557->6750|10636->6801|10652->6807|10744->6877|10823->6928|10839->6934|10933->7006|11012->7057|11028->7063|11119->7132|11198->7183|11214->7189|11300->7253|11382->7307|11398->7313|11485->7378|11564->7429|11580->7435|11669->7502|11748->7553|11764->7559|11850->7623|11929->7674|11945->7680|12027->7740|12092->7778|12106->7783|12145->7800|12177->7804|12258->7857|12286->7863|12355->7903|12385->7904|12425->7915|12515->7977|12544->7978|12616->8021|12646->8022|12686->8033|12752->8071|12781->8072|12817->8080|12954->8188|12984->8189|13024->8200|13107->8254|13137->8255|13173->8262|13203->8263|13272->8303|13302->8304|13346->8319|13390->8335|13458->8381|13538->8432|13568->8433|13608->8444|13661->8469|13690->8470|13726->8478|13804->8527|13834->8528|13874->8539|14349->8986|14378->8987|14414->8995|14470->9022|14500->9023|14540->9034|14603->9069|14632->9070|14668->9078|14724->9105|14754->9106|14794->9117|14857->9152|14886->9153|14922->9161|15062->9272|15092->9273|15132->9284|15374->9497|15404->9498|15665->9730|15695->9731|15747->9754|15890->9868|15920->9869|15950->9870|15984->9875|16014->9876|16066->9899|16139->9943|16169->9944|16217->9963|16390->10107|16420->10108|16461->10120|16504->10134|16534->10135|16578->10150|16669->10212|16699->10213|16740->10225|17014->10470|17044->10471|17088->10486|17161->10530|17191->10531|17239->10550|17312->10594|17342->10595|17384->10608|17414->10609|17481->10648|17510->10649|17546->10657|17610->10692|17640->10693|17680->10704|18022->11017|18052->11018|18096->11033|18169->11077|18199->11078|18248->11098|18321->11142|18351->11143|18393->11156|18423->11157|18490->11196|18519->11197|18551->11201
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|43->11|44->12|45->13|45->13|45->13|46->14|46->14|46->14|46->14|47->15|47->15|47->15|49->17|49->17|49->17|53->21|53->21|53->21|54->22|54->22|54->22|55->23|55->23|55->23|57->25|57->25|57->25|59->27|59->27|59->27|60->28|60->28|60->28|61->29|61->29|61->29|62->30|62->30|62->30|63->31|63->31|63->31|65->33|65->33|65->33|66->34|66->34|66->34|70->38|70->38|70->38|71->39|71->39|71->39|72->40|81->49|81->49|82->50|88->56|88->56|89->57|98->66|98->66|98->66|99->67|104->72|104->72|104->72|105->73|115->83|115->83|115->83|116->84|116->84|116->84|117->85|117->85|117->85|120->88|120->88|120->88|122->90|124->92|124->92|124->92|125->93|125->93|125->93|126->94|126->94|126->94|128->96|128->96|128->96|129->97|129->97|129->97|130->98|130->98|130->98|131->99|131->99|131->99|132->100|132->100|132->100|134->102|134->102|134->102|135->103|135->103|135->103|137->105|137->105|137->105|138->106|138->106|138->106|139->107|139->107|139->107|140->108|140->108|140->108|142->110|142->110|142->110|143->111|143->111|143->111|144->112|144->112|144->112|146->114|146->114|146->114|147->115|147->115|147->115|148->116|148->116|148->116|149->117|149->117|149->117|150->118|150->118|150->118|151->119|151->119|151->119|153->121|153->121|153->121|154->122|154->122|154->122|155->123|155->123|155->123|156->124|156->124|156->124|157->125|157->125|157->125|159->127|160->128|160->128|162->130|162->130|163->131|164->132|164->132|166->134|166->134|167->135|168->136|168->136|170->138|172->140|172->140|173->141|173->141|173->141|173->141|173->141|174->142|174->142|175->143|175->143|175->143|177->145|177->145|178->146|179->147|179->147|181->149|181->149|181->149|182->150|194->162|194->162|196->164|196->164|196->164|197->165|198->166|198->166|200->168|200->168|200->168|201->169|202->170|202->170|204->172|206->174|206->174|207->175|214->182|214->182|220->188|220->188|221->189|223->191|223->191|223->191|223->191|223->191|224->192|225->193|225->193|226->194|231->199|231->199|233->201|233->201|233->201|234->202|236->204|236->204|238->206|243->211|243->211|244->212|244->212|244->212|245->213|246->214|246->214|247->215|247->215|250->218|250->218|252->220|252->220|252->220|253->221|261->229|261->229|262->230|262->230|262->230|263->231|264->232|264->232|265->233|265->233|268->236|268->236|270->238
                  -- GENERATED --
              */
          