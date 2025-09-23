
package views.html.telco.buyPackage

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
    <title>"""),_display_(/*10.13*/Messages("Tiện ích")),format.raw/*10.33*/("""</title>
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

        <div class="accordion-body" style="
          border-left: 1px solid #C0C0C0;
          border-right: 1px solid #C0C0C0;
          border-bottom: 1px solid #C0C0C0;
          border-top: 1px solid #C0C0C0;
          padding-left: 15px;
          padding-right: 15px;
          padding-top: 20px;
          padding-bottom: 20px;
          background-color: white;
        ">
          <div class="card-header-primary card-header-icon">
            <div class="toolbar" style="float: left">
              <button class="btn btn-title">
              """),_display_(/*48.16*/Messages("Đăng ký, huỷ gói Data mua thêm")),format.raw/*48.58*/("""
              """),format.raw/*49.15*/("""</button>
            </div>
            <div class="toolbar" style="float: right">
              <button class="btn px-4 button-light" id="" data-bs-toggle="modal" data-bs-target="#importListSubMiAddonModal">
              """),_display_(/*53.16*/Messages("Tải danh sách TB")),format.raw/*53.44*/("""
              """),format.raw/*54.15*/("""</button>
              """),_display_(/*55.16*/if(UserHelper.isFeatureRole(currentUser, "register_vas"))/*55.73*/{_display_(Seq[Any](format.raw/*55.74*/("""
                """),format.raw/*56.17*/("""<button class="btn px-4 button-light" id="" onclick="appendTablePackMiAddon()" data-bs-toggle="modal" data-bs-target="#registerMiAddonModal">
                """),_display_(/*57.18*/Messages("Đăng ký")),format.raw/*57.37*/("""
                """),format.raw/*58.17*/("""</button>
              """)))}),format.raw/*59.16*/("""

              """),_display_(/*61.16*/if(UserHelper.isFeatureRole(currentUser, "unregister_vas"))/*61.75*/{_display_(Seq[Any](format.raw/*61.76*/("""
                """),format.raw/*62.17*/("""<button class="btn px-4 button-light" id="" onclick="getListPackUnregister()" data-bs-toggle="modal" data-bs-target="#unregisterMiAddonModal">
                """),_display_(/*63.18*/Messages("Huỷ gói")),format.raw/*63.37*/("""
                """),format.raw/*64.17*/("""</button>
              """)))}),format.raw/*65.16*/("""

              """),_display_(/*67.16*/if(UserHelper.isFeatureRole(currentUser, "cancel_extend"))/*67.74*/{_display_(Seq[Any](format.raw/*67.75*/("""
                """),format.raw/*68.17*/("""<button class="btn px-4 button-light" id="" onclick="getListPackUnextend()" data-bs-toggle="modal" data-bs-target="#unextendMiAddonModal">
                """),_display_(/*69.18*/Messages("Huỷ gia hạn")),format.raw/*69.41*/("""
                """),format.raw/*70.17*/("""</button>
              """)))}),format.raw/*71.16*/("""

              """),format.raw/*73.15*/("""<button class="btn px-4 button-light" id="" onclick="exportResultMiAddon()">
              """),_display_(/*74.16*/Messages("Export")),format.raw/*74.34*/("""
              """),format.raw/*75.15*/("""</button>
            </div>
          </div>
          <div style="height:50px"></div>
          <div class="card-body " style="padding-right: 0px;">
            <div class="mt-3" id="dataImportMiAddOn" style=" width: 100%;
            border-left: 1px solid #C0C0C0;
            border-right: 1px solid #C0C0C0;
            border-bottom: 1px solid #C0C0C0;
            border-top: 1px solid #C0C0C0;
            padding-left: 15px;
            padding-right: 15px;
            padding-top: 20px;
            padding-bottom: 20px;
            background-color: white;
            ">

            </div>
          </div>
        </div>

      """),_display_(/*96.8*/views/*96.13*/.html.telco.utilities.Utilities_blockSubs_import()),format.raw/*96.63*/("""
      """),_display_(/*97.8*/views/*97.13*/.html.telco.utilities.Utilities_blockSubs_comfirm()),format.raw/*97.64*/("""
      """),_display_(/*98.8*/views/*98.13*/.html.telco.utilities.Utilities_blockSubs2_confirm()),format.raw/*98.65*/("""

      """),_display_(/*100.8*/views/*100.13*/.html.telco.utilities.Utilities_openSubscriber_import()),format.raw/*100.68*/("""
      """),_display_(/*101.8*/views/*101.13*/.html.telco.utilities.Utilities_openSubscriber_import2()),format.raw/*101.69*/("""
      """),_display_(/*102.8*/views/*102.13*/.html.telco.utilities.Utilities_openSubs1_comfirm()),format.raw/*102.64*/("""
      """),_display_(/*103.8*/views/*103.13*/.html.telco.utilities.Utilities_openSubs2_comfirm()),format.raw/*103.64*/("""
      """),_display_(/*104.8*/views/*104.13*/.html.telco.utilities.Utilities_openSubscriber_pay()),format.raw/*104.65*/("""
      """),_display_(/*105.8*/views/*105.13*/.html.telco.utilities.Utilities_openSubscriber_pay2()),format.raw/*105.66*/("""

      """),_display_(/*107.8*/views/*107.13*/.html.telco.utilities.Utilities_miAddOn_import()),format.raw/*107.61*/("""
      """),_display_(/*108.8*/views/*108.13*/.html.telco.utilities.Utilities_miAddOn_register()),format.raw/*108.63*/("""
      """),_display_(/*109.8*/views/*109.13*/.html.telco.utilities.Utilities_miAddOn_register_comfirm()),format.raw/*109.71*/("""

      """),_display_(/*111.8*/views/*111.13*/.html.telco.utilities.Utilities_miAddOn_unregister()),format.raw/*111.65*/("""
      """),_display_(/*112.8*/views/*112.13*/.html.telco.utilities.Utilities_miAddOn_unregister_comfirm()),format.raw/*112.73*/("""

      """),_display_(/*114.8*/views/*114.13*/.html.telco.utilities.Utilities_miAddOn_unextend()),format.raw/*114.63*/("""
      """),_display_(/*115.8*/views/*115.13*/.html.telco.utilities.Utilities_miAddOn_unextend_comfirm()),format.raw/*115.71*/("""

      """),_display_(/*117.8*/views/*117.13*/.html.telco.utilities.Utilities_recharge_import()),format.raw/*117.62*/("""
      """),_display_(/*118.8*/views/*118.13*/.html.telco.utilities.Utilities_recharge_process()),format.raw/*118.63*/("""
      """),_display_(/*119.8*/views/*119.13*/.html.telco.utilities.Utilities_recharge_comfirm()),format.raw/*119.63*/("""

      """),_display_(/*121.8*/views/*121.13*/.html.telco.utilities.Utilities_noti()),format.raw/*121.51*/("""

      """),_display_(/*123.8*/views/*123.13*/.html.telco.Loading()),format.raw/*123.34*/("""

    """),format.raw/*125.5*/("""</div>
      <!--  END OF PAPER WRAP -->

    """),_display_(/*128.6*/views/*128.11*/.html.telco.mainJs()),format.raw/*128.31*/("""

    """),format.raw/*130.125*/("""
    """),format.raw/*131.5*/("""<script src=""""),_display_(/*131.19*/routes/*131.25*/.Assets.versioned("javascripts/importExcel/xlsx.full.min.js")),format.raw/*131.86*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*132.19*/routes/*132.25*/.Assets.versioned("javascripts/importExcel/jszip.js")),format.raw/*132.78*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*133.19*/routes/*133.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*133.84*/("""" type="text/javascript"></script>

    <script>
            var imgDefault = '"""),_display_(/*136.32*/routes/*136.38*/.Assets.versioned("images/market/default.png")),format.raw/*136.84*/("""';
            var userId = '"""),_display_(/*137.28*/userId),format.raw/*137.34*/("""';

            $(document).ready(function () """),format.raw/*139.43*/("""{"""),format.raw/*139.44*/("""
              """),format.raw/*140.15*/("""$("#menu-utilitiesManage").addClass("mm-active");
              $("#menu").metisMenu();

              document.getElementById('filesMiAddOnSubs').addEventListener('change', uploadMiAddonSubs, false);
              document.getElementById('filesRechargeSubs').addEventListener('change', uploadRechargeSubs, false);
              document.getElementById('filesBlockSubs').addEventListener('change', uploadBlockSubs, false);
              document.getElementById('filesOpenSubs').addEventListener('change', uploadOpenSubs, false);
              document.getElementById('filesOpenSubs2').addEventListener('change', uploadOpenSubs2, false);

            """),format.raw/*149.13*/("""}"""),format.raw/*149.14*/(""");
            function importFileMiAddOnSubs() """),format.raw/*150.46*/("""{"""),format.raw/*150.47*/("""
              """),format.raw/*151.15*/("""$("#filesMiAddOnSubs").click();
            """),format.raw/*152.13*/("""}"""),format.raw/*152.14*/("""
            """),format.raw/*153.13*/("""function importFileRechargeSubs() """),format.raw/*153.47*/("""{"""),format.raw/*153.48*/("""
              """),format.raw/*154.15*/("""$("#filesRechargeSubs").click();
            """),format.raw/*155.13*/("""}"""),format.raw/*155.14*/("""
            """),format.raw/*156.13*/("""function importFileBlockSubs() """),format.raw/*156.44*/("""{"""),format.raw/*156.45*/("""
              """),format.raw/*157.15*/("""$("#filesBlockSubs").click();
            """),format.raw/*158.13*/("""}"""),format.raw/*158.14*/("""
            """),format.raw/*159.13*/("""function importFileOpenSubs() """),format.raw/*159.43*/("""{"""),format.raw/*159.44*/("""
              """),format.raw/*160.15*/("""$("#filesOpenSubs").click();
            """),format.raw/*161.13*/("""}"""),format.raw/*161.14*/("""
            """),format.raw/*162.13*/("""function importFileOpenSubs2() """),format.raw/*162.44*/("""{"""),format.raw/*162.45*/("""
              """),format.raw/*163.15*/("""$("#filesOpenSubs2").click();
            """),format.raw/*164.13*/("""}"""),format.raw/*164.14*/("""
    """),format.raw/*165.5*/("""</script>

    <script src=""""),_display_(/*167.19*/routes/*167.25*/.Assets.versioned("javascripts/views/telco/statusSubs.js")),format.raw/*167.83*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*168.19*/routes/*168.25*/.Assets.versioned("javascripts/views/telco/utilities/utilities.js")),format.raw/*168.92*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*170.19*/routes/*170.25*/.Assets.versioned("javascripts/views/telco/utilities/miAddOn.js")),format.raw/*170.90*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*171.19*/routes/*171.25*/.Assets.versioned("javascripts/views/telco/utilities/miAddOn_unregister.js")),format.raw/*171.101*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*172.19*/routes/*172.25*/.Assets.versioned("javascripts/views/telco/utilities/miAddOn_unextend.js")),format.raw/*172.99*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*174.19*/routes/*174.25*/.Assets.versioned("javascripts/views/telco/utilities/rechargeSubs.js")),format.raw/*174.95*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*175.19*/routes/*175.25*/.Assets.versioned("javascripts/views/telco/utilities/rechargeSubs_pay.js")),format.raw/*175.99*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*176.19*/routes/*176.25*/.Assets.versioned("javascripts/views/telco/utilities/rechargeSubs_history.js")),format.raw/*176.103*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*178.19*/routes/*178.25*/.Assets.versioned("javascripts/views/telco/utilities/blockSubs.js")),format.raw/*178.92*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*180.19*/routes/*180.25*/.Assets.versioned("javascripts/views/telco/utilities/openSubs.js")),format.raw/*180.91*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*181.19*/routes/*181.25*/.Assets.versioned("javascripts/views/telco/utilities/openSubs2.js")),format.raw/*181.92*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*183.19*/routes/*183.25*/.Assets.versioned("javascripts/views/telco/utilities/export.js")),format.raw/*183.89*/("""" type="text/javascript"></script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/buyPackage/Utilities.scala.html
                  HASH: ddbca4598d3aa02f156878a7090a05f014198a53
                  MATRIX: 668->1|704->31|744->65|1088->97|1216->130|1243->131|1412->273|1453->293|1534->347|1549->353|1606->389|1813->570|1827->575|1873->600|1906->606|1946->619|1961->625|2036->679|2103->719|2118->725|2193->779|2259->818|2274->824|2361->890|2451->954|2465->959|2527->1000|2560->1007|2574->1012|2626->1043|2659->1049|3380->1743|3443->1785|3486->1800|3738->2025|3787->2053|3830->2068|3882->2093|3948->2150|3987->2151|4032->2168|4218->2327|4258->2346|4303->2363|4359->2388|4403->2405|4471->2464|4510->2465|4555->2482|4742->2642|4782->2661|4827->2678|4883->2703|4927->2720|4994->2778|5033->2779|5078->2796|5261->2952|5305->2975|5350->2992|5406->3017|5450->3033|5569->3125|5608->3143|5651->3158|6322->3803|6336->3808|6407->3858|6441->3866|6455->3871|6527->3922|6561->3930|6575->3935|6648->3987|6684->3996|6699->4001|6776->4056|6811->4064|6826->4069|6904->4125|6939->4133|6954->4138|7027->4189|7062->4197|7077->4202|7150->4253|7185->4261|7200->4266|7274->4318|7309->4326|7324->4331|7399->4384|7435->4393|7450->4398|7520->4446|7555->4454|7570->4459|7642->4509|7677->4517|7692->4522|7772->4580|7808->4589|7823->4594|7897->4646|7932->4654|7947->4659|8029->4719|8065->4728|8080->4733|8152->4783|8187->4791|8202->4796|8282->4854|8318->4863|8333->4868|8404->4917|8439->4925|8454->4930|8526->4980|8561->4988|8576->4993|8648->5043|8684->5052|8699->5057|8759->5095|8795->5104|8810->5109|8853->5130|8887->5136|8961->5183|8976->5188|9018->5208|9054->5334|9087->5339|9129->5353|9145->5359|9228->5420|9309->5473|9325->5479|9400->5532|9481->5585|9497->5591|9578->5650|9686->5730|9702->5736|9770->5782|9828->5812|9856->5818|9931->5864|9961->5865|10005->5880|10684->6530|10714->6531|10791->6579|10821->6580|10865->6595|10938->6639|10968->6640|11010->6653|11073->6687|11103->6688|11147->6703|11221->6748|11251->6749|11293->6762|11353->6793|11383->6794|11427->6809|11498->6851|11528->6852|11570->6865|11629->6895|11659->6896|11703->6911|11773->6952|11803->6953|11845->6966|11905->6997|11935->6998|11979->7013|12050->7055|12080->7056|12113->7061|12170->7090|12186->7096|12266->7154|12347->7207|12363->7213|12452->7280|12534->7334|12550->7340|12637->7405|12718->7458|12734->7464|12833->7540|12914->7593|12930->7599|13026->7673|13108->7727|13124->7733|13216->7803|13297->7856|13313->7862|13409->7936|13490->7989|13506->7995|13607->8073|13689->8127|13705->8133|13794->8200|13876->8254|13892->8260|13980->8326|14061->8379|14077->8385|14166->8452|14248->8506|14264->8512|14350->8576
                  LINES: 24->1|25->2|26->3|31->4|36->4|37->5|42->10|42->10|43->11|43->11|43->11|48->16|48->16|48->16|50->18|50->18|50->18|50->18|52->20|52->20|52->20|53->21|53->21|53->21|57->25|57->25|57->25|59->27|59->27|59->27|61->29|80->48|80->48|81->49|85->53|85->53|86->54|87->55|87->55|87->55|88->56|89->57|89->57|90->58|91->59|93->61|93->61|93->61|94->62|95->63|95->63|96->64|97->65|99->67|99->67|99->67|100->68|101->69|101->69|102->70|103->71|105->73|106->74|106->74|107->75|128->96|128->96|128->96|129->97|129->97|129->97|130->98|130->98|130->98|132->100|132->100|132->100|133->101|133->101|133->101|134->102|134->102|134->102|135->103|135->103|135->103|136->104|136->104|136->104|137->105|137->105|137->105|139->107|139->107|139->107|140->108|140->108|140->108|141->109|141->109|141->109|143->111|143->111|143->111|144->112|144->112|144->112|146->114|146->114|146->114|147->115|147->115|147->115|149->117|149->117|149->117|150->118|150->118|150->118|151->119|151->119|151->119|153->121|153->121|153->121|155->123|155->123|155->123|157->125|160->128|160->128|160->128|162->130|163->131|163->131|163->131|163->131|164->132|164->132|164->132|165->133|165->133|165->133|168->136|168->136|168->136|169->137|169->137|171->139|171->139|172->140|181->149|181->149|182->150|182->150|183->151|184->152|184->152|185->153|185->153|185->153|186->154|187->155|187->155|188->156|188->156|188->156|189->157|190->158|190->158|191->159|191->159|191->159|192->160|193->161|193->161|194->162|194->162|194->162|195->163|196->164|196->164|197->165|199->167|199->167|199->167|200->168|200->168|200->168|202->170|202->170|202->170|203->171|203->171|203->171|204->172|204->172|204->172|206->174|206->174|206->174|207->175|207->175|207->175|208->176|208->176|208->176|210->178|210->178|210->178|212->180|212->180|212->180|213->181|213->181|213->181|215->183|215->183|215->183
                  -- GENERATED --
              */
          