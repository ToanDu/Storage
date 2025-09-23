
package views.html.telco.contract

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

object Contract extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*10.13*/Messages("contract.title")),format.raw/*10.39*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*11.46*/routes/*11.52*/.Assets.versioned("images/logo.jpg")),format.raw/*11.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*16.6*/views/*16.11*/.html.iot.tags.Main_css()),format.raw/*16.36*/("""

    """),format.raw/*18.5*/("""<link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*18.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("assets/plugins/input-tags/css/tagsinput.css")),format.raw/*19.88*/("""" rel="stylesheet" />
    """),format.raw/*20.96*/("""
    """),format.raw/*21.5*/("""<link href='"""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*21.73*/("""' type='text/css'>
    <link href=""""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*22.99*/("""" rel="stylesheet">
    <link href=""""),_display_(/*23.18*/routes/*23.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*23.139*/("""" rel="stylesheet" >

    <link href=""""),_display_(/*25.18*/routes/*25.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*25.78*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*29.6*/views/*29.11*/.html.telco.Menu(currentUser, "", userId)),format.raw/*29.52*/("""

    """),_display_(/*31.6*/views/*31.11*/.html.telco.Header(currentUser)),format.raw/*31.42*/("""

    """),format.raw/*33.5*/("""<div class="page-wrapper">
      <div class="page-content">

        """),_display_(/*36.10*/views/*36.15*/.html.telco.contract.Contract_formSearch(currentUser)),format.raw/*36.68*/("""

        """),format.raw/*38.9*/("""<div class="card">
          <div class="table-responsive" style="border-radius: 8px;">
            <table class="table table-striped" id="listContractTable" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th onclick="sortTable(0, 'ascii')">"""),_display_(/*43.56*/Messages("contract.table.stt")),format.raw/*43.86*/("""</th>
                  <th onclick="sortTable(0, 'ascii')">"""),_display_(/*44.56*/Messages("contract.table.contractCode")),format.raw/*44.95*/("""</th>
                  <th onclick="sortTable(1, 'ascii')">"""),_display_(/*45.56*/Messages("contract.table.contractNumber")),format.raw/*45.97*/("""</th>
                  <th onclick="sortTable(2, 'ascii')">"""),_display_(/*46.56*/Messages("contract.table.status")),format.raw/*46.89*/("""</th>
                  <th onclick="sortTable(3, 'date')">"""),_display_(/*47.55*/Messages("contract.table.effectiveDate")),format.raw/*47.95*/("""</th>
                  <th onclick="sortTable(4, 'ascii')">"""),_display_(/*48.56*/Messages("contract.table.representativeNumber")),format.raw/*48.103*/("""</th>
                  <th onclick="sortTable(5, 'ascii')">"""),_display_(/*49.56*/Messages("contract.table.address")),format.raw/*49.90*/("""</th>
                  """),_display_(/*50.20*/if(UserHelper.isFeatureRole(currentUser, "view_invoice"))/*50.77*/{_display_(Seq[Any](format.raw/*50.78*/("""
                    """),format.raw/*51.21*/("""<th style="text-align: center;">"""),_display_(/*51.54*/Messages("contract.table.actions")),format.raw/*51.88*/("""</th>
                  """)))}),format.raw/*52.20*/("""
                """),format.raw/*53.17*/("""</tr>
              </thead>
              <tbody>
              </tbody>
            </table>
            <h5 id="notiNotDataContract" style="text-align: center;"></h5>
          </div>
          <div class="row pagination-section px-2">
                    <div class="col-md-4 d-flex align-items-center justify-content-center justify-content-md-start mb-3">
                      <p class="mb-0">"""),_display_(/*62.40*/Messages("contract.table.totalRecordsPrefix")),format.raw/*62.85*/(""" """),format.raw/*62.86*/("""<span id="total_record">0</span> """),_display_(/*62.120*/Messages("contract.table.totalRecordsSuffix")),format.raw/*62.165*/("""</p>
                    </div>
                    <div class="col-md-8 d-flex flex-column flex-md-row justify-content-end align-items-center gap-2 gap-md-3 mb-3">
                      <div class="dropdown mb-2 mb-md-0">
                        <button class="btn btn-sm dropdown-toggle btn-outline-dark" type="button" data-bs-toggle="dropdown"
                          aria-expanded="false" id="countPageSize" style="margin-left: 5px;">
                          10
                        </button>
                        <ul class="dropdown-menu">
                          <li><a class="dropdown-item" href="javascript:ApplyFilter(1,10,true)">10</a></li>
                          <li><a class="dropdown-item" href="javascript:ApplyFilter(1,50,true)">50</a></li>
                          <li><a class="dropdown-item" href="javascript:ApplyFilter(1,100,true)">100</a></li>
                          <li><a class="dropdown-item" href="javascript:ApplyFilter(1,200,true)">200</a></li>
                          <li><a class="dropdown-item" href="javascript:ApplyFilter(1,500,true)">500</a></li>
                        </ul>
                      </div>
                      <p class="mb-2 mb-md-0">"""),_display_(/*78.48*/Messages("entries.per.page")),format.raw/*78.76*/("""</p>
                      <div id="pagingTable" class="justify-content-md-end"></div>
                    </div>
                    <div>
                      <input type="hidden" name="page" id="page" value="1" />
                      <input type="hidden" name="pageSize" id="pageSize" value="10" />
                      <input type="hidden" name="isResetPage" id="isResetPage" value="false" />
                    </div>
                  </div>
        </div>

      </div>

      """),_display_(/*91.8*/views/*91.13*/.html.telco.contract.Contract_info()),format.raw/*91.49*/("""

      """),_display_(/*93.8*/views/*93.13*/.html.telco.Loading()),format.raw/*93.34*/("""

    """),format.raw/*95.5*/("""</div>
      <!--  END OF PAPER WRAP -->

    """),_display_(/*98.6*/views/*98.11*/.html.telco.mainJs()),format.raw/*98.31*/("""

    """),format.raw/*100.5*/("""<script>
            var imgDefault = '"""),_display_(/*101.32*/routes/*101.38*/.Assets.versioned("images/market/default.png")),format.raw/*101.84*/("""';
            var userId = '"""),_display_(/*102.28*/userId),format.raw/*102.34*/("""';
            var isViewInvoice = '"""),_display_(/*103.35*/UserHelper/*103.45*/.isFeatureRole(currentUser, "view_invoice")),format.raw/*103.88*/("""';
            console.log(isViewInvoice + " isViewInvoice");
            var view_contract = '"""),_display_(/*105.35*/UserHelper/*105.45*/.isFeatureRole(currentUser, "view_contract")),format.raw/*105.89*/("""';
            var view_detail_contract = '"""),_display_(/*106.42*/UserHelper/*106.52*/.isFeatureRole(currentUser, "view_detail_contract")),format.raw/*106.103*/("""';

            $(document).ready(function () """),format.raw/*108.43*/("""{"""),format.raw/*108.44*/("""
              """),format.raw/*109.15*/("""$("#menu-contractManage").addClass("mm-active");
              $("#menu").metisMenu();
            """),format.raw/*111.13*/("""}"""),format.raw/*111.14*/(""")

            function sortTable(n, type) """),format.raw/*113.41*/("""{"""),format.raw/*113.42*/("""

                """),format.raw/*115.17*/("""console.log(1);
              var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
              table = document.getElementById("listContractTable");
              switching = true;
              dir = "asc";
                console.log(2);
              while (switching) """),format.raw/*121.33*/("""{"""),format.raw/*121.34*/("""
                """),format.raw/*122.17*/("""switching = false;
                rows = table.rows;
                  console.log(3);
                for (i = 1; i < (rows.length - 1); i++) """),format.raw/*125.57*/("""{"""),format.raw/*125.58*/("""
                  """),format.raw/*126.19*/("""shouldSwitch = false;
                  // Get the text content of the cells and convert to lowercase string
                  x = rows[i].getElementsByTagName("TD")[n].textContent.toLowerCase();
                  y = rows[i + 1].getElementsByTagName("TD")[n].textContent.toLowerCase();
                    console.log(x);
                    console.log(y);
                    if(type == 'date')"""),format.raw/*132.39*/("""{"""),format.raw/*132.40*/("""
                         """),format.raw/*133.26*/("""x = new Date(parseDateString(x));
                         y = new Date(parseDateString(y));
                    """),format.raw/*135.21*/("""}"""),format.raw/*135.22*/("""

                  """),format.raw/*137.19*/("""if (dir == "asc") """),format.raw/*137.37*/("""{"""),format.raw/*137.38*/("""
                    """),format.raw/*138.21*/("""if (x > y) """),format.raw/*138.32*/("""{"""),format.raw/*138.33*/("""
                      """),format.raw/*139.23*/("""shouldSwitch = true;
                      break;
                    """),format.raw/*141.21*/("""}"""),format.raw/*141.22*/("""
                  """),format.raw/*142.19*/("""}"""),format.raw/*142.20*/(""" """),format.raw/*142.21*/("""else if (dir == "desc") """),format.raw/*142.45*/("""{"""),format.raw/*142.46*/("""
                    """),format.raw/*143.21*/("""if (x < y) """),format.raw/*143.32*/("""{"""),format.raw/*143.33*/("""
                      """),format.raw/*144.23*/("""shouldSwitch = true;
                      break;
                    """),format.raw/*146.21*/("""}"""),format.raw/*146.22*/("""
                  """),format.raw/*147.19*/("""}"""),format.raw/*147.20*/("""
                """),format.raw/*148.17*/("""}"""),format.raw/*148.18*/("""

                """),format.raw/*150.17*/("""if (shouldSwitch) """),format.raw/*150.35*/("""{"""),format.raw/*150.36*/("""
                  """),format.raw/*151.19*/("""rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                  switching = true;
                  switchcount++;
                """),format.raw/*154.17*/("""}"""),format.raw/*154.18*/(""" """),format.raw/*154.19*/("""else """),format.raw/*154.24*/("""{"""),format.raw/*154.25*/("""
                  """),format.raw/*155.19*/("""if (switchcount == 0 && dir == "asc") """),format.raw/*155.57*/("""{"""),format.raw/*155.58*/("""
                    """),format.raw/*156.21*/("""dir = "desc";
                    switching = true;
                  """),format.raw/*158.19*/("""}"""),format.raw/*158.20*/("""
                """),format.raw/*159.17*/("""}"""),format.raw/*159.18*/("""
              """),format.raw/*160.15*/("""}"""),format.raw/*160.16*/("""
            """),format.raw/*161.13*/("""}"""),format.raw/*161.14*/("""
            """),format.raw/*162.13*/("""function parseDateString(dateString) """),format.raw/*162.50*/("""{"""),format.raw/*162.51*/("""
                """),format.raw/*163.17*/("""var parts = dateString.split(' ');
                var timeParts = parts[0].split(':');
                var dateParts = parts[1].split('/');
                return dateParts[2] + '-' + dateParts[1] + '-' + dateParts[0] + 'T' + timeParts[0] + ':' + timeParts[1];
            """),format.raw/*167.13*/("""}"""),format.raw/*167.14*/("""
    """),format.raw/*168.5*/("""</script>
    <script src=""""),_display_(/*169.19*/routes/*169.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*169.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*170.19*/routes/*170.25*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*170.85*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*172.19*/routes/*172.25*/.Assets.versioned("javascripts/views/telco/contract/contract.js")),format.raw/*172.90*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*173.19*/routes/*173.25*/.Assets.versioned("javascripts/views/telco/contract/contract_info.js")),format.raw/*173.95*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*174.19*/routes/*174.25*/.Assets.versioned("javascripts/views/telco/contract/contract_export.js")),format.raw/*174.97*/("""" type="text/javascript"></script>

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
                  DATE: Mon Sep 22 16:32:52 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/contract/Contract.scala.html
                  HASH: 2cca1a8d081aae04912475fa282d196e1f71413e
                  MATRIX: 666->1|702->31|742->65|1085->97|1213->130|1240->131|1409->273|1456->299|1537->353|1552->359|1609->395|1816->576|1830->581|1876->606|1909->612|1949->625|1964->631|2039->685|2105->724|2120->730|2205->794|2259->911|2291->916|2331->929|2346->935|2416->984|2479->1020|2494->1026|2590->1101|2654->1138|2669->1144|2806->1259|2872->1298|2887->1304|2962->1358|3052->1422|3066->1427|3128->1468|3161->1475|3175->1480|3227->1511|3260->1517|3357->1587|3371->1592|3445->1645|3482->1655|3822->1968|3873->1998|3961->2059|4021->2098|4109->2159|4171->2200|4259->2261|4313->2294|4400->2354|4461->2394|4549->2455|4618->2502|4706->2563|4761->2597|4813->2622|4879->2679|4918->2680|4967->2701|5027->2734|5082->2768|5138->2793|5183->2810|5610->3210|5676->3255|5705->3256|5767->3290|5834->3335|7068->4542|7117->4570|7633->5060|7647->5065|7704->5101|7739->5110|7753->5115|7795->5136|7828->5142|7901->5189|7915->5194|7956->5214|7990->5220|8058->5260|8074->5266|8142->5312|8200->5342|8228->5348|8293->5385|8313->5395|8378->5438|8502->5534|8522->5544|8588->5588|8660->5632|8680->5642|8754->5693|8829->5739|8859->5740|8903->5755|9031->5854|9061->5855|9133->5898|9163->5899|9210->5917|9533->6211|9563->6212|9609->6229|9782->6373|9812->6374|9860->6393|10286->6790|10316->6791|10371->6817|10513->6930|10543->6931|10592->6951|10639->6969|10669->6970|10719->6991|10759->7002|10789->7003|10841->7026|10940->7096|10970->7097|11018->7116|11048->7117|11078->7118|11131->7142|11161->7143|11211->7164|11251->7175|11281->7176|11333->7199|11432->7269|11462->7270|11510->7289|11540->7290|11586->7307|11616->7308|11663->7326|11710->7344|11740->7345|11788->7364|11957->7504|11987->7505|12017->7506|12051->7511|12081->7512|12129->7531|12196->7569|12226->7570|12276->7591|12375->7661|12405->7662|12451->7679|12481->7680|12525->7695|12555->7696|12597->7709|12627->7710|12669->7723|12735->7760|12765->7761|12811->7778|13114->8052|13144->8053|13177->8058|13233->8086|13249->8092|13330->8151|13411->8204|13427->8210|13509->8270|13591->8324|13607->8330|13694->8395|13775->8448|13791->8454|13883->8524|13964->8577|13980->8583|14074->8655
                  LINES: 24->1|25->2|26->3|31->4|36->4|37->5|42->10|42->10|43->11|43->11|43->11|48->16|48->16|48->16|50->18|50->18|50->18|50->18|51->19|51->19|51->19|52->20|53->21|53->21|53->21|53->21|54->22|54->22|54->22|55->23|55->23|55->23|57->25|57->25|57->25|61->29|61->29|61->29|63->31|63->31|63->31|65->33|68->36|68->36|68->36|70->38|75->43|75->43|76->44|76->44|77->45|77->45|78->46|78->46|79->47|79->47|80->48|80->48|81->49|81->49|82->50|82->50|82->50|83->51|83->51|83->51|84->52|85->53|94->62|94->62|94->62|94->62|94->62|110->78|110->78|123->91|123->91|123->91|125->93|125->93|125->93|127->95|130->98|130->98|130->98|132->100|133->101|133->101|133->101|134->102|134->102|135->103|135->103|135->103|137->105|137->105|137->105|138->106|138->106|138->106|140->108|140->108|141->109|143->111|143->111|145->113|145->113|147->115|153->121|153->121|154->122|157->125|157->125|158->126|164->132|164->132|165->133|167->135|167->135|169->137|169->137|169->137|170->138|170->138|170->138|171->139|173->141|173->141|174->142|174->142|174->142|174->142|174->142|175->143|175->143|175->143|176->144|178->146|178->146|179->147|179->147|180->148|180->148|182->150|182->150|182->150|183->151|186->154|186->154|186->154|186->154|186->154|187->155|187->155|187->155|188->156|190->158|190->158|191->159|191->159|192->160|192->160|193->161|193->161|194->162|194->162|194->162|195->163|199->167|199->167|200->168|201->169|201->169|201->169|202->170|202->170|202->170|204->172|204->172|204->172|205->173|205->173|205->173|206->174|206->174|206->174
                  -- GENERATED --
              */
          