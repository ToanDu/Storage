
package views.html.telco.blockUtilities

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

object BlockUtilities extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*10.13*/Messages("blockUtilities.title")),format.raw/*10.45*/("""</title>
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
              """),_display_(/*36.16*/if(UserHelper.isFeatureRole(currentUser, "block_sub"))/*36.70*/{_display_(Seq[Any](format.raw/*36.71*/("""
                """),format.raw/*37.17*/("""<div class="accordion-item mt">
                  <h2 class="accordion-header" id="headingThree">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                      <span>"""),_display_(/*40.30*/Messages("blockUtilities.blockOneWay")),format.raw/*40.68*/("""</span>
                    </button>
                  </h2>
                </div>
              """)))}),format.raw/*44.16*/("""
              """),_display_(/*45.16*/if(UserHelper.isFeatureRole(currentUser, "open_sub"))/*45.69*/{_display_(Seq[Any](format.raw/*45.70*/("""
                """),format.raw/*46.17*/("""<div class="accordion-item mt-2">
                  <h2 class="accordion-header" id="headingFour">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                      <a>"""),_display_(/*49.27*/Messages("blockUtilities.unblockOneWay")),format.raw/*49.67*/("""</a>
                    </button>
                  </h2>
                </div>
                <div class="accordion-item mt-2">
                  <h2 class="accordion-header" id="heading5">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse5" aria-expanded="false" aria-controls="collapse5">
                      <span>"""),_display_(/*56.30*/Messages("blockUtilities.unblockTwoWay")),format.raw/*56.70*/("""</span>
                    </button>
                  </h2>
                </div>
              """)))}),format.raw/*60.16*/("""
            """),format.raw/*61.13*/("""</div>
            <div class="col-sm-10" style="padding-left: 0px;">
              <div class="utilities-content" style="overflow: auto;">
                """),_display_(/*64.18*/if(UserHelper.isFeatureRole(currentUser, "block_sub"))/*64.72*/{_display_(Seq[Any](format.raw/*64.73*/("""
                  """),format.raw/*65.19*/("""<div class="accordion-item">
                    <div id="collapseThree" class="accordion-collapse collapse " aria-labelledby="headingThree" data-bs-parent="#accordionExample">
                    """),_display_(/*67.22*/views/*67.27*/.html.telco.utilities.Utilities_blockSubscriber()),format.raw/*67.76*/("""
                    """),format.raw/*68.21*/("""</div>
                  </div>
                """)))}),format.raw/*70.18*/("""
                """),_display_(/*71.18*/if(UserHelper.isFeatureRole(currentUser, "open_sub"))/*71.71*/{_display_(Seq[Any](format.raw/*71.72*/("""
                  """),format.raw/*72.19*/("""<div class="accordion-item">
                    <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="headingFour" data-bs-parent="#accordionExample">
                    """),_display_(/*74.22*/views/*74.27*/.html.telco.utilities.Utilities_openSubscriber()),format.raw/*74.75*/("""
                    """),format.raw/*75.21*/("""</div>
                  </div>
                  <div class="accordion-item">
                    <div id="collapse5" class="accordion-collapse collapse" aria-labelledby="heading5" data-bs-parent="#accordionExample">
                    """),_display_(/*79.22*/views/*79.27*/.html.telco.utilities.Utilities_openSubscriber2()),format.raw/*79.76*/("""
                    """),format.raw/*80.21*/("""</div>
                  </div>
                """)))}),format.raw/*82.18*/("""
              """),format.raw/*83.15*/("""</div>
            </div>

          </div>

        </div>

      </div>

      """),_display_(/*92.8*/views/*92.13*/.html.telco.utilities.Utilities_blockSubs_import()),format.raw/*92.63*/("""
      """),_display_(/*93.8*/views/*93.13*/.html.telco.utilities.Utilities_blockSubs_comfirm()),format.raw/*93.64*/("""
      """),_display_(/*94.8*/views/*94.13*/.html.telco.utilities.Utilities_blockSubs2_confirm()),format.raw/*94.65*/("""

      """),_display_(/*96.8*/views/*96.13*/.html.telco.utilities.Utilities_openSubscriber_import()),format.raw/*96.68*/("""
      """),_display_(/*97.8*/views/*97.13*/.html.telco.utilities.Utilities_openSubscriber_import2()),format.raw/*97.69*/("""
      """),_display_(/*98.8*/views/*98.13*/.html.telco.utilities.Utilities_openSubs1_comfirm()),format.raw/*98.64*/("""
      """),_display_(/*99.8*/views/*99.13*/.html.telco.utilities.Utilities_openSubs2_comfirm()),format.raw/*99.64*/("""
      """),_display_(/*100.8*/views/*100.13*/.html.telco.utilities.Utilities_openSubscriber_pay()),format.raw/*100.65*/("""
      """),_display_(/*101.8*/views/*101.13*/.html.telco.utilities.Utilities_openSubscriber_pay2()),format.raw/*101.66*/("""

      """),_display_(/*103.8*/views/*103.13*/.html.telco.utilities.Utilities_miAddOn_import()),format.raw/*103.61*/("""
      """),_display_(/*104.8*/views/*104.13*/.html.telco.utilities.Utilities_miAddOn_register()),format.raw/*104.63*/("""
      """),_display_(/*105.8*/views/*105.13*/.html.telco.utilities.Utilities_miAddOn_register_comfirm()),format.raw/*105.71*/("""

      """),_display_(/*107.8*/views/*107.13*/.html.telco.utilities.Utilities_miAddOn_unregister()),format.raw/*107.65*/("""
      """),_display_(/*108.8*/views/*108.13*/.html.telco.utilities.Utilities_miAddOn_unregister_comfirm()),format.raw/*108.73*/("""

      """),_display_(/*110.8*/views/*110.13*/.html.telco.utilities.Utilities_miAddOn_unextend()),format.raw/*110.63*/("""
      """),_display_(/*111.8*/views/*111.13*/.html.telco.utilities.Utilities_miAddOn_unextend_comfirm()),format.raw/*111.71*/("""

      """),_display_(/*113.8*/views/*113.13*/.html.telco.utilities.Utilities_recharge_import()),format.raw/*113.62*/("""
      """),_display_(/*114.8*/views/*114.13*/.html.telco.utilities.Utilities_recharge_process()),format.raw/*114.63*/("""
      """),_display_(/*115.8*/views/*115.13*/.html.telco.utilities.Utilities_recharge_comfirm()),format.raw/*115.63*/("""

      """),_display_(/*117.8*/views/*117.13*/.html.telco.utilities.Utilities_noti()),format.raw/*117.51*/("""

      """),_display_(/*119.8*/views/*119.13*/.html.telco.Loading()),format.raw/*119.34*/("""

    """),format.raw/*121.5*/("""</div>
      <!--  END OF PAPER WRAP -->

    """),_display_(/*124.6*/views/*124.11*/.html.telco.mainJs()),format.raw/*124.31*/("""

    """),format.raw/*126.125*/("""
    """),format.raw/*127.5*/("""<script src=""""),_display_(/*127.19*/routes/*127.25*/.Assets.versioned("javascripts/importExcel/xlsx.full.min.js")),format.raw/*127.86*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*128.19*/routes/*128.25*/.Assets.versioned("javascripts/importExcel/jszip.js")),format.raw/*128.78*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*129.19*/routes/*129.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*129.84*/("""" type="text/javascript"></script>

    <script>
            var imgDefault = '"""),_display_(/*132.32*/routes/*132.38*/.Assets.versioned("images/market/default.png")),format.raw/*132.84*/("""';
            var userId = '"""),_display_(/*133.28*/userId),format.raw/*133.34*/("""';

            $(document).ready(function () """),format.raw/*135.43*/("""{"""),format.raw/*135.44*/("""
              """),format.raw/*136.15*/("""$("#menu-utilitiesManage").addClass("mm-active");
              $("#menu").metisMenu();

              document.getElementById('filesMiAddOnSubs').addEventListener('change', uploadMiAddonSubs, false);
              document.getElementById('filesRechargeSubs').addEventListener('change', uploadRechargeSubs, false);
              document.getElementById('filesBlockSubs').addEventListener('change', uploadBlockSubs, false);
              document.getElementById('filesOpenSubs').addEventListener('change', uploadOpenSubs, false);
              document.getElementById('filesOpenSubs2').addEventListener('change', uploadOpenSubs2, false);

            """),format.raw/*145.13*/("""}"""),format.raw/*145.14*/(""");
            function importFileMiAddOnSubs() """),format.raw/*146.46*/("""{"""),format.raw/*146.47*/("""
              """),format.raw/*147.15*/("""$("#filesMiAddOnSubs").click();
            """),format.raw/*148.13*/("""}"""),format.raw/*148.14*/("""
            """),format.raw/*149.13*/("""function importFileRechargeSubs() """),format.raw/*149.47*/("""{"""),format.raw/*149.48*/("""
              """),format.raw/*150.15*/("""$("#filesRechargeSubs").click();
            """),format.raw/*151.13*/("""}"""),format.raw/*151.14*/("""
            """),format.raw/*152.13*/("""function importFileBlockSubs() """),format.raw/*152.44*/("""{"""),format.raw/*152.45*/("""
              """),format.raw/*153.15*/("""$("#filesBlockSubs").click();
            """),format.raw/*154.13*/("""}"""),format.raw/*154.14*/("""
            """),format.raw/*155.13*/("""function importFileOpenSubs() """),format.raw/*155.43*/("""{"""),format.raw/*155.44*/("""
              """),format.raw/*156.15*/("""$("#filesOpenSubs").click();
            """),format.raw/*157.13*/("""}"""),format.raw/*157.14*/("""
            """),format.raw/*158.13*/("""function importFileOpenSubs2() """),format.raw/*158.44*/("""{"""),format.raw/*158.45*/("""
              """),format.raw/*159.15*/("""$("#filesOpenSubs2").click();
            """),format.raw/*160.13*/("""}"""),format.raw/*160.14*/("""
    """),format.raw/*161.5*/("""</script>

    <script src=""""),_display_(/*163.19*/routes/*163.25*/.Assets.versioned("javascripts/views/telco/statusSubs.js")),format.raw/*163.83*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*164.19*/routes/*164.25*/.Assets.versioned("javascripts/views/telco/utilities/utilities.js")),format.raw/*164.92*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*166.19*/routes/*166.25*/.Assets.versioned("javascripts/views/telco/utilities/miAddOn.js")),format.raw/*166.90*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*167.19*/routes/*167.25*/.Assets.versioned("javascripts/views/telco/utilities/miAddOn_unregister.js")),format.raw/*167.101*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*168.19*/routes/*168.25*/.Assets.versioned("javascripts/views/telco/utilities/miAddOn_unextend.js")),format.raw/*168.99*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*170.19*/routes/*170.25*/.Assets.versioned("javascripts/views/telco/utilities/rechargeSubs.js")),format.raw/*170.95*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*171.19*/routes/*171.25*/.Assets.versioned("javascripts/views/telco/utilities/rechargeSubs_pay.js")),format.raw/*171.99*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*172.19*/routes/*172.25*/.Assets.versioned("javascripts/views/telco/utilities/rechargeSubs_history.js")),format.raw/*172.103*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*174.19*/routes/*174.25*/.Assets.versioned("javascripts/views/telco/utilities/blockSubs.js")),format.raw/*174.92*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*176.19*/routes/*176.25*/.Assets.versioned("javascripts/views/telco/utilities/openSubs.js")),format.raw/*176.91*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*177.19*/routes/*177.25*/.Assets.versioned("javascripts/views/telco/utilities/openSubs2.js")),format.raw/*177.92*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*179.19*/routes/*179.25*/.Assets.versioned("javascripts/views/telco/utilities/export.js")),format.raw/*179.89*/("""" type="text/javascript"></script>

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
                  DATE: Mon Sep 22 16:32:51 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/blockUtilities/BlockUtilities.scala.html
                  HASH: 9caf72a81af546aef857310cea2fe3477754000e
                  MATRIX: 672->1|708->31|748->65|1097->97|1225->130|1252->131|1421->273|1474->305|1555->359|1570->365|1627->401|1834->582|1848->587|1894->612|1927->618|1967->631|1982->637|2057->691|2124->731|2139->737|2214->791|2280->830|2295->836|2382->902|2472->966|2486->971|2548->1012|2581->1019|2595->1024|2647->1055|2680->1061|2990->1344|3053->1398|3092->1399|3137->1416|3479->1731|3538->1769|3669->1869|3712->1885|3774->1938|3813->1939|3858->1956|4196->2267|4257->2307|4687->2710|4748->2750|4879->2850|4920->2863|5104->3020|5167->3074|5206->3075|5253->3094|5478->3292|5492->3297|5562->3346|5611->3367|5691->3416|5736->3434|5798->3487|5837->3488|5884->3507|6106->3702|6120->3707|6189->3755|6238->3776|6504->4015|6518->4020|6588->4069|6637->4090|6717->4139|6760->4154|6868->4236|6882->4241|6953->4291|6987->4299|7001->4304|7073->4355|7107->4363|7121->4368|7194->4420|7229->4429|7243->4434|7319->4489|7353->4497|7367->4502|7444->4558|7478->4566|7492->4571|7564->4622|7598->4630|7612->4635|7684->4686|7719->4694|7734->4699|7808->4751|7843->4759|7858->4764|7933->4817|7969->4826|7984->4831|8054->4879|8089->4887|8104->4892|8176->4942|8211->4950|8226->4955|8306->5013|8342->5022|8357->5027|8431->5079|8466->5087|8481->5092|8563->5152|8599->5161|8614->5166|8686->5216|8721->5224|8736->5229|8816->5287|8852->5296|8867->5301|8938->5350|8973->5358|8988->5363|9060->5413|9095->5421|9110->5426|9182->5476|9218->5485|9233->5490|9293->5528|9329->5537|9344->5542|9387->5563|9421->5569|9495->5616|9510->5621|9552->5641|9588->5767|9621->5772|9663->5786|9679->5792|9762->5853|9843->5906|9859->5912|9934->5965|10015->6018|10031->6024|10112->6083|10220->6163|10236->6169|10304->6215|10362->6245|10390->6251|10465->6297|10495->6298|10539->6313|11218->6963|11248->6964|11325->7012|11355->7013|11399->7028|11472->7072|11502->7073|11544->7086|11607->7120|11637->7121|11681->7136|11755->7181|11785->7182|11827->7195|11887->7226|11917->7227|11961->7242|12032->7284|12062->7285|12104->7298|12163->7328|12193->7329|12237->7344|12307->7385|12337->7386|12379->7399|12439->7430|12469->7431|12513->7446|12584->7488|12614->7489|12647->7494|12704->7523|12720->7529|12800->7587|12881->7640|12897->7646|12986->7713|13068->7767|13084->7773|13171->7838|13252->7891|13268->7897|13367->7973|13448->8026|13464->8032|13560->8106|13642->8160|13658->8166|13750->8236|13831->8289|13847->8295|13943->8369|14024->8422|14040->8428|14141->8506|14223->8560|14239->8566|14328->8633|14410->8687|14426->8693|14514->8759|14595->8812|14611->8818|14700->8885|14782->8939|14798->8945|14884->9009
                  LINES: 24->1|25->2|26->3|31->4|36->4|37->5|42->10|42->10|43->11|43->11|43->11|48->16|48->16|48->16|50->18|50->18|50->18|50->18|52->20|52->20|52->20|53->21|53->21|53->21|57->25|57->25|57->25|59->27|59->27|59->27|61->29|68->36|68->36|68->36|69->37|72->40|72->40|76->44|77->45|77->45|77->45|78->46|81->49|81->49|88->56|88->56|92->60|93->61|96->64|96->64|96->64|97->65|99->67|99->67|99->67|100->68|102->70|103->71|103->71|103->71|104->72|106->74|106->74|106->74|107->75|111->79|111->79|111->79|112->80|114->82|115->83|124->92|124->92|124->92|125->93|125->93|125->93|126->94|126->94|126->94|128->96|128->96|128->96|129->97|129->97|129->97|130->98|130->98|130->98|131->99|131->99|131->99|132->100|132->100|132->100|133->101|133->101|133->101|135->103|135->103|135->103|136->104|136->104|136->104|137->105|137->105|137->105|139->107|139->107|139->107|140->108|140->108|140->108|142->110|142->110|142->110|143->111|143->111|143->111|145->113|145->113|145->113|146->114|146->114|146->114|147->115|147->115|147->115|149->117|149->117|149->117|151->119|151->119|151->119|153->121|156->124|156->124|156->124|158->126|159->127|159->127|159->127|159->127|160->128|160->128|160->128|161->129|161->129|161->129|164->132|164->132|164->132|165->133|165->133|167->135|167->135|168->136|177->145|177->145|178->146|178->146|179->147|180->148|180->148|181->149|181->149|181->149|182->150|183->151|183->151|184->152|184->152|184->152|185->153|186->154|186->154|187->155|187->155|187->155|188->156|189->157|189->157|190->158|190->158|190->158|191->159|192->160|192->160|193->161|195->163|195->163|195->163|196->164|196->164|196->164|198->166|198->166|198->166|199->167|199->167|199->167|200->168|200->168|200->168|202->170|202->170|202->170|203->171|203->171|203->171|204->172|204->172|204->172|206->174|206->174|206->174|208->176|208->176|208->176|209->177|209->177|209->177|211->179|211->179|211->179
                  -- GENERATED --
              */
          