
package views.html.telco.topUp

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

        <div class="tab-content tab-recharge" style="background-color: white;">
          <div class="tab-pane fade show active" id="recharge" role="tabpanel">
            <div class="row">
              <div class="col-md-8">
                <label class="text-recharge-2 mt-3" style="float: left">"""),_display_(/*38.74*/Messages("Thông tin nạp tiền")),format.raw/*38.104*/("""</label>
                <div class="row mt-5">
                  <label class="col-sm-3 col-form-label">"""),_display_(/*40.59*/Messages("Tài khoản")),format.raw/*40.80*/("""</label>
                  <div class="col-sm-6">
                    <select class="form-control">
                      <option selected>"""),_display_(/*43.41*/Messages("Tài khoản viễn thông")),format.raw/*43.73*/("""</option>
                    </select>
                  </div>
                </div>
                <div class="row mt-3">
                  <label class="col-sm-3 col-form-label">"""),_display_(/*48.59*/Messages("Số tiền (nạp cho 1 TB)")),format.raw/*48.93*/("""</label>
                  <div class="col-sm-6">
                    <input type="number" class="form-control" id="moneyRecharge" onchange="inputMoneyRechargeSubs(this)" pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==7) return false;" placeholder=""""),_display_(/*50.214*/Messages("Nhập số tiền thanh toán tối thiểu 5.000đ")),format.raw/*50.266*/("""">
                  </div>
                </div>
                <div class="row mt-3">
                  <label class="col-sm-3 col-form-label">"""),_display_(/*54.59*/Messages("")),format.raw/*54.71*/("""</label>
                  <div class="col-sm-8">
                    <button type="button" class="btn btn-light mt-1 px-3 button-money" onclick="chooseMoneyNap(10000)">10.000đ</button>
                    <button type="button" class="btn btn-light mt-1 px-3 button-money" onclick="chooseMoneyNap(20000)">20.000đ</button>
                    <button type="button" class="btn btn-light mt-1 px-3 button-money" onclick="chooseMoneyNap(50000)">50.000đ</button>
                    <button type="button" class="btn btn-light mt-1 px-3 button-money" onclick="chooseMoneyNap(100000)">100.000đ</button>
                    <button type="button" class="btn btn-light mt-1 px-3 button-money" onclick="chooseMoneyNap(200000)">200.000đ</button>
                  </div>
                </div>
                <div class="modal-footer mt-3">
                  <button type="button" class="btn" onclick="" data-bs-toggle="modal" data-bs-target="#importRechargeSubsModal" style="background: #FFFFFF;border: 1px solid #EA0033;border-radius: 8px 8px 8px 0px;color: #EA0033;">"""),_display_(/*64.231*/Messages("Tải danh sách")),format.raw/*64.256*/("""</button>
                </div>
              </div>

              <div class="col-md-4" style="border-left: 1px solid #C0C0C0;">
                <label class="text-recharge-2 mt-3" style="float: left">"""),_display_(/*69.74*/Messages("Thanh toán")),format.raw/*69.96*/("""</label>
                <div class="row mt-5">
                  <table class="table" style="width: 100%;">
                    <tbody>
                      <tr>
                        <td>"""),_display_(/*74.30*/Messages("Số tiền (nạp cho 1 TB):")),format.raw/*74.65*/("""</td>
                        <td id="moneyRechargeOneSub" class="text-recharge-3"></td>
                      </tr>
                      <tr>
                        <td>"""),_display_(/*78.30*/Messages("Số thuê bao:")),format.raw/*78.54*/("""</td>
                        <td id="countRechargeSub" class="text-recharge-3"></td>
                      </tr>
                      <tr>
                        <td class="text-recharge-3">"""),_display_(/*82.54*/Messages("Tổng thanh toán:")),format.raw/*82.82*/("""</td>
                        <td id="totalRecharge" class="text-recharge-3"></td>
                      </tr>
                    </tbody>
                  </table>
                </div>
                <div class="modal-footer mt-3">
                  <button type="button" class="btn btn-red cursor-pointer" onclick="comfirmProcessRechargeSubs()" style="border-radius: 8px 8px 8px 0px;" id="buttonRecharge" disabled>"""),_display_(/*89.185*/Messages("Thanh toán")),format.raw/*89.207*/("""</button>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="row mt-1" id="dataImportRechargeSubs" style="padding: 15px;"></div>
            </div>

          </div>

      </div>

      """),_display_(/*101.8*/views/*101.13*/.html.telco.utilities.Utilities_blockSubs_import()),format.raw/*101.63*/("""
      """),_display_(/*102.8*/views/*102.13*/.html.telco.utilities.Utilities_blockSubs_comfirm()),format.raw/*102.64*/("""
      """),_display_(/*103.8*/views/*103.13*/.html.telco.utilities.Utilities_blockSubs2_confirm()),format.raw/*103.65*/("""

      """),_display_(/*105.8*/views/*105.13*/.html.telco.utilities.Utilities_openSubscriber_import()),format.raw/*105.68*/("""
      """),_display_(/*106.8*/views/*106.13*/.html.telco.utilities.Utilities_openSubscriber_import2()),format.raw/*106.69*/("""
      """),_display_(/*107.8*/views/*107.13*/.html.telco.utilities.Utilities_openSubs1_comfirm()),format.raw/*107.64*/("""
      """),_display_(/*108.8*/views/*108.13*/.html.telco.utilities.Utilities_openSubs2_comfirm()),format.raw/*108.64*/("""
      """),_display_(/*109.8*/views/*109.13*/.html.telco.utilities.Utilities_openSubscriber_pay()),format.raw/*109.65*/("""
      """),_display_(/*110.8*/views/*110.13*/.html.telco.utilities.Utilities_openSubscriber_pay2()),format.raw/*110.66*/("""

      """),_display_(/*112.8*/views/*112.13*/.html.telco.utilities.Utilities_miAddOn_import()),format.raw/*112.61*/("""
      """),_display_(/*113.8*/views/*113.13*/.html.telco.utilities.Utilities_miAddOn_register()),format.raw/*113.63*/("""
      """),_display_(/*114.8*/views/*114.13*/.html.telco.utilities.Utilities_miAddOn_register_comfirm()),format.raw/*114.71*/("""

      """),_display_(/*116.8*/views/*116.13*/.html.telco.utilities.Utilities_miAddOn_unregister()),format.raw/*116.65*/("""
      """),_display_(/*117.8*/views/*117.13*/.html.telco.utilities.Utilities_miAddOn_unregister_comfirm()),format.raw/*117.73*/("""

      """),_display_(/*119.8*/views/*119.13*/.html.telco.utilities.Utilities_miAddOn_unextend()),format.raw/*119.63*/("""
      """),_display_(/*120.8*/views/*120.13*/.html.telco.utilities.Utilities_miAddOn_unextend_comfirm()),format.raw/*120.71*/("""

      """),_display_(/*122.8*/views/*122.13*/.html.telco.utilities.Utilities_recharge_import()),format.raw/*122.62*/("""
      """),_display_(/*123.8*/views/*123.13*/.html.telco.utilities.Utilities_recharge_process()),format.raw/*123.63*/("""
      """),_display_(/*124.8*/views/*124.13*/.html.telco.utilities.Utilities_recharge_comfirm()),format.raw/*124.63*/("""

      """),_display_(/*126.8*/views/*126.13*/.html.telco.utilities.Utilities_noti()),format.raw/*126.51*/("""

      """),_display_(/*128.8*/views/*128.13*/.html.telco.Loading()),format.raw/*128.34*/("""

    """),format.raw/*130.5*/("""</div>
      <!--  END OF PAPER WRAP -->

    """),_display_(/*133.6*/views/*133.11*/.html.telco.mainJs()),format.raw/*133.31*/("""

    """),format.raw/*135.125*/("""
    """),format.raw/*136.5*/("""<script src=""""),_display_(/*136.19*/routes/*136.25*/.Assets.versioned("javascripts/importExcel/xlsx.full.min.js")),format.raw/*136.86*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*137.19*/routes/*137.25*/.Assets.versioned("javascripts/importExcel/jszip.js")),format.raw/*137.78*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*138.19*/routes/*138.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*138.84*/("""" type="text/javascript"></script>

    <script>
            var imgDefault = '"""),_display_(/*141.32*/routes/*141.38*/.Assets.versioned("images/market/default.png")),format.raw/*141.84*/("""';
            var userId = '"""),_display_(/*142.28*/userId),format.raw/*142.34*/("""';

            $(document).ready(function () """),format.raw/*144.43*/("""{"""),format.raw/*144.44*/("""
              """),format.raw/*145.15*/("""$("#menu-utilitiesManage").addClass("mm-active");
              $("#menu").metisMenu();

              document.getElementById('filesMiAddOnSubs').addEventListener('change', uploadMiAddonSubs, false);
              document.getElementById('filesRechargeSubs').addEventListener('change', uploadRechargeSubs, false);
              document.getElementById('filesBlockSubs').addEventListener('change', uploadBlockSubs, false);
              document.getElementById('filesOpenSubs').addEventListener('change', uploadOpenSubs, false);
              document.getElementById('filesOpenSubs2').addEventListener('change', uploadOpenSubs2, false);

            """),format.raw/*154.13*/("""}"""),format.raw/*154.14*/(""");
            function importFileMiAddOnSubs() """),format.raw/*155.46*/("""{"""),format.raw/*155.47*/("""
              """),format.raw/*156.15*/("""$("#filesMiAddOnSubs").click();
            """),format.raw/*157.13*/("""}"""),format.raw/*157.14*/("""
            """),format.raw/*158.13*/("""function importFileRechargeSubs() """),format.raw/*158.47*/("""{"""),format.raw/*158.48*/("""
              """),format.raw/*159.15*/("""$("#filesRechargeSubs").click();
            """),format.raw/*160.13*/("""}"""),format.raw/*160.14*/("""
            """),format.raw/*161.13*/("""function importFileBlockSubs() """),format.raw/*161.44*/("""{"""),format.raw/*161.45*/("""
              """),format.raw/*162.15*/("""$("#filesBlockSubs").click();
            """),format.raw/*163.13*/("""}"""),format.raw/*163.14*/("""
            """),format.raw/*164.13*/("""function importFileOpenSubs() """),format.raw/*164.43*/("""{"""),format.raw/*164.44*/("""
              """),format.raw/*165.15*/("""$("#filesOpenSubs").click();
            """),format.raw/*166.13*/("""}"""),format.raw/*166.14*/("""
            """),format.raw/*167.13*/("""function importFileOpenSubs2() """),format.raw/*167.44*/("""{"""),format.raw/*167.45*/("""
              """),format.raw/*168.15*/("""$("#filesOpenSubs2").click();
            """),format.raw/*169.13*/("""}"""),format.raw/*169.14*/("""
    """),format.raw/*170.5*/("""</script>

    <script src=""""),_display_(/*172.19*/routes/*172.25*/.Assets.versioned("javascripts/views/telco/statusSubs.js")),format.raw/*172.83*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*173.19*/routes/*173.25*/.Assets.versioned("javascripts/views/telco/utilities/utilities.js")),format.raw/*173.92*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*175.19*/routes/*175.25*/.Assets.versioned("javascripts/views/telco/utilities/miAddOn.js")),format.raw/*175.90*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*176.19*/routes/*176.25*/.Assets.versioned("javascripts/views/telco/utilities/miAddOn_unregister.js")),format.raw/*176.101*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*177.19*/routes/*177.25*/.Assets.versioned("javascripts/views/telco/utilities/miAddOn_unextend.js")),format.raw/*177.99*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*179.19*/routes/*179.25*/.Assets.versioned("javascripts/views/telco/utilities/rechargeSubs.js")),format.raw/*179.95*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*180.19*/routes/*180.25*/.Assets.versioned("javascripts/views/telco/utilities/rechargeSubs_pay.js")),format.raw/*180.99*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*181.19*/routes/*181.25*/.Assets.versioned("javascripts/views/telco/utilities/rechargeSubs_history.js")),format.raw/*181.103*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*183.19*/routes/*183.25*/.Assets.versioned("javascripts/views/telco/utilities/blockSubs.js")),format.raw/*183.92*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*185.19*/routes/*185.25*/.Assets.versioned("javascripts/views/telco/utilities/openSubs.js")),format.raw/*185.91*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*186.19*/routes/*186.25*/.Assets.versioned("javascripts/views/telco/utilities/openSubs2.js")),format.raw/*186.92*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*188.19*/routes/*188.25*/.Assets.versioned("javascripts/views/telco/utilities/export.js")),format.raw/*188.89*/("""" type="text/javascript"></script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/topUp/Utilities.scala.html
                  HASH: 097319dabfb8dd958c2f4cad6d3a071435e6e041
                  MATRIX: 663->1|699->31|739->65|1083->97|1211->130|1238->131|1407->273|1448->293|1529->347|1544->353|1601->389|1808->570|1822->575|1868->600|1901->606|1941->619|1956->625|2031->679|2098->719|2113->725|2188->779|2254->818|2269->824|2356->890|2446->954|2460->959|2522->1000|2555->1007|2569->1012|2621->1043|2654->1049|3118->1486|3170->1516|3303->1622|3345->1643|3512->1783|3565->1815|3777->2000|3832->2034|4123->2297|4197->2349|4372->2497|4405->2509|5493->3569|5540->3594|5772->3799|5815->3821|6035->4014|6091->4049|6291->4222|6336->4246|6557->4440|6606->4468|7056->4890|7100->4912|7383->5168|7398->5173|7470->5223|7505->5231|7520->5236|7593->5287|7628->5295|7643->5300|7717->5352|7753->5361|7768->5366|7845->5421|7880->5429|7895->5434|7973->5490|8008->5498|8023->5503|8096->5554|8131->5562|8146->5567|8219->5618|8254->5626|8269->5631|8343->5683|8378->5691|8393->5696|8468->5749|8504->5758|8519->5763|8589->5811|8624->5819|8639->5824|8711->5874|8746->5882|8761->5887|8841->5945|8877->5954|8892->5959|8966->6011|9001->6019|9016->6024|9098->6084|9134->6093|9149->6098|9221->6148|9256->6156|9271->6161|9351->6219|9387->6228|9402->6233|9473->6282|9508->6290|9523->6295|9595->6345|9630->6353|9645->6358|9717->6408|9753->6417|9768->6422|9828->6460|9864->6469|9879->6474|9922->6495|9956->6501|10030->6548|10045->6553|10087->6573|10123->6699|10156->6704|10198->6718|10214->6724|10297->6785|10378->6838|10394->6844|10469->6897|10550->6950|10566->6956|10647->7015|10755->7095|10771->7101|10839->7147|10897->7177|10925->7183|11000->7229|11030->7230|11074->7245|11753->7895|11783->7896|11860->7944|11890->7945|11934->7960|12007->8004|12037->8005|12079->8018|12142->8052|12172->8053|12216->8068|12290->8113|12320->8114|12362->8127|12422->8158|12452->8159|12496->8174|12567->8216|12597->8217|12639->8230|12698->8260|12728->8261|12772->8276|12842->8317|12872->8318|12914->8331|12974->8362|13004->8363|13048->8378|13119->8420|13149->8421|13182->8426|13239->8455|13255->8461|13335->8519|13416->8572|13432->8578|13521->8645|13603->8699|13619->8705|13706->8770|13787->8823|13803->8829|13902->8905|13983->8958|13999->8964|14095->9038|14177->9092|14193->9098|14285->9168|14366->9221|14382->9227|14478->9301|14559->9354|14575->9360|14676->9438|14758->9492|14774->9498|14863->9565|14945->9619|14961->9625|15049->9691|15130->9744|15146->9750|15235->9817|15317->9871|15333->9877|15419->9941
                  LINES: 24->1|25->2|26->3|31->4|36->4|37->5|42->10|42->10|43->11|43->11|43->11|48->16|48->16|48->16|50->18|50->18|50->18|50->18|52->20|52->20|52->20|53->21|53->21|53->21|57->25|57->25|57->25|59->27|59->27|59->27|61->29|70->38|70->38|72->40|72->40|75->43|75->43|80->48|80->48|82->50|82->50|86->54|86->54|96->64|96->64|101->69|101->69|106->74|106->74|110->78|110->78|114->82|114->82|121->89|121->89|133->101|133->101|133->101|134->102|134->102|134->102|135->103|135->103|135->103|137->105|137->105|137->105|138->106|138->106|138->106|139->107|139->107|139->107|140->108|140->108|140->108|141->109|141->109|141->109|142->110|142->110|142->110|144->112|144->112|144->112|145->113|145->113|145->113|146->114|146->114|146->114|148->116|148->116|148->116|149->117|149->117|149->117|151->119|151->119|151->119|152->120|152->120|152->120|154->122|154->122|154->122|155->123|155->123|155->123|156->124|156->124|156->124|158->126|158->126|158->126|160->128|160->128|160->128|162->130|165->133|165->133|165->133|167->135|168->136|168->136|168->136|168->136|169->137|169->137|169->137|170->138|170->138|170->138|173->141|173->141|173->141|174->142|174->142|176->144|176->144|177->145|186->154|186->154|187->155|187->155|188->156|189->157|189->157|190->158|190->158|190->158|191->159|192->160|192->160|193->161|193->161|193->161|194->162|195->163|195->163|196->164|196->164|196->164|197->165|198->166|198->166|199->167|199->167|199->167|200->168|201->169|201->169|202->170|204->172|204->172|204->172|205->173|205->173|205->173|207->175|207->175|207->175|208->176|208->176|208->176|209->177|209->177|209->177|211->179|211->179|211->179|212->180|212->180|212->180|213->181|213->181|213->181|215->183|215->183|215->183|217->185|217->185|217->185|218->186|218->186|218->186|220->188|220->188|220->188
                  -- GENERATED --
              */
          