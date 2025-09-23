
package views.html.telco.utilities

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
/*1.2*/import vn.m2m.utils.DateUtil
/*2.2*/import vn.m2m.common.models.User
/*3.2*/import vn.m2m.utils.UserHelper

object Utilities extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(currentUser:User, userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.35*/("""
"""),format.raw/*5.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*10.13*/Messages("utilities.title")),format.raw/*10.40*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*11.46*/routes/*11.52*/.Assets.versioned("images/logo.jpg")),format.raw/*11.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*16.6*/views/*16.11*/.html.iot.tags.Main_css()),format.raw/*16.36*/("""

    """),format.raw/*18.5*/("""<link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*18.78*/("""" rel="stylesheet" />

    <link href=""""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*20.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("stylesheets/views/telco/utilites/utilites.css")),format.raw/*21.90*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*25.6*/views/*25.11*/.html.telco.Menu(currentUser, "", userId)),format.raw/*25.52*/("""

    """),_display_(/*27.6*/views/*27.11*/.html.telco.Header(currentUser)),format.raw/*27.42*/("""

    """),format.raw/*29.5*/("""<div class="page-wrapper">
      <div class="page-content">
        <input id="gpkd" type="text" class="form-control" readonly hidden>

        <div class="accordion" id="accordionExample">
          <div class="row">
            <div class="col-sm-2 utilities-item">
              <div class="accordion-item">
                <h2 class="accordion-header" id="headingOne">
                  <button class="accordion-button " type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                  """),_display_(/*39.20*/Messages("utilities.addDataPackage")),format.raw/*39.56*/("""
                  """),format.raw/*40.19*/("""</button>
                </h2>
              </div>
              <div class="accordion-item mt-2">
                <h2 class="accordion-header" id="headingTwo">
                  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                    """),_display_(/*46.22*/Messages("utilities.cancelDataPackage")),format.raw/*46.61*/("""
                  """),format.raw/*47.19*/("""</button>
                </h2>
              </div>
              <div class="accordion-item mt-2">
                <h2 class="accordion-header" id="headingThree">
                  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                    <span>"""),_display_(/*53.28*/Messages("utilities.cancelRenewal")),format.raw/*53.63*/("""</span>
                  </button>
                </h2>
              </div>

                <div class="accordion-item mt-2">
                  <h2 class="accordion-header" id="headingFour">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                      <a>"""),_display_(/*61.27*/Messages("utilities.changePackage")),format.raw/*61.62*/("""</a>
                    </button>
                  </h2>
                </div>
            </div>
            <div class="col-sm-10" style="padding-left: 0px;">
              <div class="utilities-content" style="overflow: auto;">
                <div class="accordion-item">
                  <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                  """),_display_(/*70.20*/views/*70.25*/.html.telco.utilities.Utilities_miAddOn(currentUser)),format.raw/*70.77*/("""
                  """),format.raw/*71.19*/("""</div>
                </div>
                <div class="accordion-item">
                  <div id="collapseTwo" class="accordion-collapse collapse " aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                  """),_display_(/*75.20*/views/*75.25*/.html.telco.utilities.Utilities_unregister(currentUser)),format.raw/*75.80*/("""
                  """),format.raw/*76.19*/("""</div>
                </div>

                <div class="accordion-item">
                  <div id="collapseThree" class="accordion-collapse collapse " aria-labelledby="headingThree" data-bs-parent="#accordionExample">
                  """),_display_(/*81.20*/views/*81.25*/.html.telco.utilities.Utilities_unextend(currentUser)),format.raw/*81.78*/("""
                  """),format.raw/*82.19*/("""</div>
                </div>
                <div class="accordion-item">
                  <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="headingFour" data-bs-parent="#accordionExample">
                  """),_display_(/*86.20*/views/*86.25*/.html.telco.utilities.Utilities_changePackage(currentUser)),format.raw/*86.83*/("""
                  """),format.raw/*87.19*/("""</div>
                </div>
                <div class="accordion-item">
                  <div id="collapse5" class="accordion-collapse collapse" aria-labelledby="heading5" data-bs-parent="#accordionExample">
                  """),_display_(/*91.20*/views/*91.25*/.html.telco.utilities.Utilities_openSubscriber2()),format.raw/*91.74*/("""
                  """),format.raw/*92.19*/("""</div>
                </div>
              </div>
            </div>

          </div>

        </div>

      </div>

      """),_display_(/*103.8*/views/*103.13*/.html.telco.utilities.Utilities_blockSubs_import()),format.raw/*103.63*/("""
      """),_display_(/*104.8*/views/*104.13*/.html.telco.utilities.Utilities_blockSubs_comfirm()),format.raw/*104.64*/("""
      """),_display_(/*105.8*/views/*105.13*/.html.telco.utilities.Utilities_blockSubs2_confirm()),format.raw/*105.65*/("""

      """),_display_(/*107.8*/views/*107.13*/.html.telco.utilities.Utilities_openSubscriber_import()),format.raw/*107.68*/("""
      """),_display_(/*108.8*/views/*108.13*/.html.telco.utilities.Utilities_openSubscriber_import2()),format.raw/*108.69*/("""
      """),_display_(/*109.8*/views/*109.13*/.html.telco.utilities.Utilities_openSubs1_comfirm()),format.raw/*109.64*/("""
      """),_display_(/*110.8*/views/*110.13*/.html.telco.utilities.Utilities_openSubs2_comfirm()),format.raw/*110.64*/("""
      """),_display_(/*111.8*/views/*111.13*/.html.telco.utilities.Utilities_openSubscriber_pay()),format.raw/*111.65*/("""
      """),_display_(/*112.8*/views/*112.13*/.html.telco.utilities.Utilities_openSubscriber_pay2()),format.raw/*112.66*/("""

      """),_display_(/*114.8*/views/*114.13*/.html.telco.utilities.Utilities_miAddOn_import()),format.raw/*114.61*/("""
      """),_display_(/*115.8*/views/*115.13*/.html.telco.utilities.Utilities_miAddOn_register()),format.raw/*115.63*/("""
      """),_display_(/*116.8*/views/*116.13*/.html.telco.utilities.Utilities_miAddOn_register_comfirm()),format.raw/*116.71*/("""

      """),_display_(/*118.8*/views/*118.13*/.html.telco.utilities.Utilities_miAddOn_unregister()),format.raw/*118.65*/("""
      """),_display_(/*119.8*/views/*119.13*/.html.telco.utilities.Utilities_miAddOn_unregister_comfirm()),format.raw/*119.73*/("""

      """),_display_(/*121.8*/views/*121.13*/.html.telco.utilities.Utilities_miAddOn_unextend()),format.raw/*121.63*/("""
      """),_display_(/*122.8*/views/*122.13*/.html.telco.utilities.Utilities_miAddOn_unextend_comfirm()),format.raw/*122.71*/("""

      """),_display_(/*124.8*/views/*124.13*/.html.telco.utilities.Utilities_recharge_import()),format.raw/*124.62*/("""
      """),_display_(/*125.8*/views/*125.13*/.html.telco.utilities.Utilities_recharge_process()),format.raw/*125.63*/("""
      """),_display_(/*126.8*/views/*126.13*/.html.telco.utilities.Utilities_recharge_comfirm()),format.raw/*126.63*/("""
      """),_display_(/*127.8*/views/*127.13*/.html.telco.utilities.Utilities_modal_change_package()),format.raw/*127.67*/("""

      """),_display_(/*129.8*/views/*129.13*/.html.telco.utilities.Utilities_noti()),format.raw/*129.51*/("""

      """),_display_(/*131.8*/views/*131.13*/.html.telco.Loading()),format.raw/*131.34*/("""

    """),format.raw/*133.5*/("""</div>
      <!--  END OF PAPER WRAP -->

    """),_display_(/*136.6*/views/*136.11*/.html.telco.mainJs()),format.raw/*136.31*/("""

    """),format.raw/*138.125*/("""
    """),format.raw/*139.5*/("""<script src=""""),_display_(/*139.19*/routes/*139.25*/.Assets.versioned("javascripts/importExcel/xlsx.full.min.js")),format.raw/*139.86*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*140.19*/routes/*140.25*/.Assets.versioned("javascripts/importExcel/jszip.js")),format.raw/*140.78*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*141.19*/routes/*141.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*141.84*/("""" type="text/javascript"></script>

    <script>
            var imgDefault = '"""),_display_(/*144.32*/routes/*144.38*/.Assets.versioned("images/market/default.png")),format.raw/*144.84*/("""';
            var userId = '"""),_display_(/*145.28*/userId),format.raw/*145.34*/("""';

            $(document).ready(function () """),format.raw/*147.43*/("""{"""),format.raw/*147.44*/("""
              """),format.raw/*148.15*/("""$("#menu-utilitiesManage").addClass("mm-active");
              $("#menu").metisMenu();

              document.getElementById('filesMiAddOnSubs').addEventListener('change', uploadMiAddonSubs, false);
              document.getElementById('filesRechargeSubs').addEventListener('change', uploadRechargeSubs, false);
              document.getElementById('filesBlockSubs').addEventListener('change', uploadBlockSubs, false);
              document.getElementById('filesOpenSubs').addEventListener('change', uploadOpenSubs, false);
              document.getElementById('filesOpenSubs2').addEventListener('change', uploadOpenSubs2, false);

            """),format.raw/*157.13*/("""}"""),format.raw/*157.14*/(""");
            function importFileMiAddOnSubs() """),format.raw/*158.46*/("""{"""),format.raw/*158.47*/("""
              """),format.raw/*159.15*/("""$("#filesMiAddOnSubs").click();
            """),format.raw/*160.13*/("""}"""),format.raw/*160.14*/("""
            """),format.raw/*161.13*/("""function importFileRechargeSubs() """),format.raw/*161.47*/("""{"""),format.raw/*161.48*/("""
              """),format.raw/*162.15*/("""$("#filesRechargeSubs").click();
            """),format.raw/*163.13*/("""}"""),format.raw/*163.14*/("""
            """),format.raw/*164.13*/("""function importFileBlockSubs() """),format.raw/*164.44*/("""{"""),format.raw/*164.45*/("""
              """),format.raw/*165.15*/("""$("#filesBlockSubs").click();
            """),format.raw/*166.13*/("""}"""),format.raw/*166.14*/("""
            """),format.raw/*167.13*/("""function importFileOpenSubs() """),format.raw/*167.43*/("""{"""),format.raw/*167.44*/("""
              """),format.raw/*168.15*/("""$("#filesOpenSubs").click();
            """),format.raw/*169.13*/("""}"""),format.raw/*169.14*/("""
            """),format.raw/*170.13*/("""function importFileOpenSubs2() """),format.raw/*170.44*/("""{"""),format.raw/*170.45*/("""
              """),format.raw/*171.15*/("""$("#filesOpenSubs2").click();
            """),format.raw/*172.13*/("""}"""),format.raw/*172.14*/("""
    """),format.raw/*173.5*/("""</script>

    <script src=""""),_display_(/*175.19*/routes/*175.25*/.Assets.versioned("javascripts/views/telco/statusSubs.js")),format.raw/*175.83*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*176.19*/routes/*176.25*/.Assets.versioned("javascripts/views/telco/utilities/utilities.js")),format.raw/*176.92*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*178.19*/routes/*178.25*/.Assets.versioned("javascripts/views/telco/utilities/miAddOn.js")),format.raw/*178.90*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*179.19*/routes/*179.25*/.Assets.versioned("javascripts/views/telco/utilities/miAddOn_unregister.js")),format.raw/*179.101*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*180.19*/routes/*180.25*/.Assets.versioned("javascripts/views/telco/utilities/miAddOn_unextend.js")),format.raw/*180.99*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*181.19*/routes/*181.25*/.Assets.versioned("javascripts/views/telco/utilities/miAddOn_change_package.js")),format.raw/*181.105*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*183.19*/routes/*183.25*/.Assets.versioned("javascripts/views/telco/utilities/rechargeSubs.js")),format.raw/*183.95*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*184.19*/routes/*184.25*/.Assets.versioned("javascripts/views/telco/utilities/rechargeSubs_pay.js")),format.raw/*184.99*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*185.19*/routes/*185.25*/.Assets.versioned("javascripts/views/telco/utilities/rechargeSubs_history.js")),format.raw/*185.103*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*187.19*/routes/*187.25*/.Assets.versioned("javascripts/views/telco/utilities/blockSubs.js")),format.raw/*187.92*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*189.19*/routes/*189.25*/.Assets.versioned("javascripts/views/telco/utilities/openSubs.js")),format.raw/*189.91*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*190.19*/routes/*190.25*/.Assets.versioned("javascripts/views/telco/utilities/openSubs2.js")),format.raw/*190.92*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*192.19*/routes/*192.25*/.Assets.versioned("javascripts/views/telco/utilities/export.js")),format.raw/*192.89*/("""" type="text/javascript"></script>

  </body>
</html>
"""))
      }
    }
  }

  def render(currentUser:User,userId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,userId)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,userId) => apply(currentUser,userId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:55 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/utilities/Utilities.scala.html
                  HASH: 4e365ab99c3f3032e192eb8eb78e83c1b07c6a97
                  MATRIX: 667->1|703->31|743->65|1087->97|1215->130|1242->131|1411->273|1459->300|1540->354|1555->360|1612->396|1819->577|1833->582|1879->607|1912->613|1952->626|1967->632|2042->686|2109->726|2124->732|2199->786|2265->825|2280->831|2367->897|2457->961|2471->966|2533->1007|2566->1014|2580->1019|2632->1050|2665->1056|3256->1620|3313->1656|3360->1675|3753->2041|3813->2080|3860->2099|4265->2477|4321->2512|4755->2919|4811->2954|5282->3398|5296->3403|5369->3455|5416->3474|5679->3710|5693->3715|5769->3770|5816->3789|6084->4030|6098->4035|6172->4088|6219->4107|6483->4344|6497->4349|6576->4407|6623->4426|6881->4657|6895->4662|6965->4711|7012->4730|7165->4856|7180->4861|7252->4911|7287->4919|7302->4924|7375->4975|7410->4983|7425->4988|7499->5040|7535->5049|7550->5054|7627->5109|7662->5117|7677->5122|7755->5178|7790->5186|7805->5191|7878->5242|7913->5250|7928->5255|8001->5306|8036->5314|8051->5319|8125->5371|8160->5379|8175->5384|8250->5437|8286->5446|8301->5451|8371->5499|8406->5507|8421->5512|8493->5562|8528->5570|8543->5575|8623->5633|8659->5642|8674->5647|8748->5699|8783->5707|8798->5712|8880->5772|8916->5781|8931->5786|9003->5836|9038->5844|9053->5849|9133->5907|9169->5916|9184->5921|9255->5970|9290->5978|9305->5983|9377->6033|9412->6041|9427->6046|9499->6096|9534->6104|9549->6109|9625->6163|9661->6172|9676->6177|9736->6215|9772->6224|9787->6229|9830->6250|9864->6256|9938->6303|9953->6308|9995->6328|10031->6454|10064->6459|10106->6473|10122->6479|10205->6540|10286->6593|10302->6599|10377->6652|10458->6705|10474->6711|10555->6770|10663->6850|10679->6856|10747->6902|10805->6932|10833->6938|10908->6984|10938->6985|10982->7000|11661->7650|11691->7651|11768->7699|11798->7700|11842->7715|11915->7759|11945->7760|11987->7773|12050->7807|12080->7808|12124->7823|12198->7868|12228->7869|12270->7882|12330->7913|12360->7914|12404->7929|12475->7971|12505->7972|12547->7985|12606->8015|12636->8016|12680->8031|12750->8072|12780->8073|12822->8086|12882->8117|12912->8118|12956->8133|13027->8175|13057->8176|13090->8181|13147->8210|13163->8216|13243->8274|13324->8327|13340->8333|13429->8400|13511->8454|13527->8460|13614->8525|13695->8578|13711->8584|13810->8660|13891->8713|13907->8719|14003->8793|14084->8846|14100->8852|14203->8932|14285->8986|14301->8992|14393->9062|14474->9115|14490->9121|14586->9195|14667->9248|14683->9254|14784->9332|14866->9386|14882->9392|14971->9459|15053->9513|15069->9519|15157->9585|15238->9638|15254->9644|15343->9711|15425->9765|15441->9771|15527->9835
                  LINES: 24->1|25->2|26->3|31->4|36->4|37->5|42->10|42->10|43->11|43->11|43->11|48->16|48->16|48->16|50->18|50->18|50->18|50->18|52->20|52->20|52->20|53->21|53->21|53->21|57->25|57->25|57->25|59->27|59->27|59->27|61->29|71->39|71->39|72->40|78->46|78->46|79->47|85->53|85->53|93->61|93->61|102->70|102->70|102->70|103->71|107->75|107->75|107->75|108->76|113->81|113->81|113->81|114->82|118->86|118->86|118->86|119->87|123->91|123->91|123->91|124->92|135->103|135->103|135->103|136->104|136->104|136->104|137->105|137->105|137->105|139->107|139->107|139->107|140->108|140->108|140->108|141->109|141->109|141->109|142->110|142->110|142->110|143->111|143->111|143->111|144->112|144->112|144->112|146->114|146->114|146->114|147->115|147->115|147->115|148->116|148->116|148->116|150->118|150->118|150->118|151->119|151->119|151->119|153->121|153->121|153->121|154->122|154->122|154->122|156->124|156->124|156->124|157->125|157->125|157->125|158->126|158->126|158->126|159->127|159->127|159->127|161->129|161->129|161->129|163->131|163->131|163->131|165->133|168->136|168->136|168->136|170->138|171->139|171->139|171->139|171->139|172->140|172->140|172->140|173->141|173->141|173->141|176->144|176->144|176->144|177->145|177->145|179->147|179->147|180->148|189->157|189->157|190->158|190->158|191->159|192->160|192->160|193->161|193->161|193->161|194->162|195->163|195->163|196->164|196->164|196->164|197->165|198->166|198->166|199->167|199->167|199->167|200->168|201->169|201->169|202->170|202->170|202->170|203->171|204->172|204->172|205->173|207->175|207->175|207->175|208->176|208->176|208->176|210->178|210->178|210->178|211->179|211->179|211->179|212->180|212->180|212->180|213->181|213->181|213->181|215->183|215->183|215->183|216->184|216->184|216->184|217->185|217->185|217->185|219->187|219->187|219->187|221->189|221->189|221->189|222->190|222->190|222->190|224->192|224->192|224->192
                  -- GENERATED --
              */
          