
package views.html.telco.statisticalReport

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

object redBaring extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*10.13*/Messages("redbaring.title")),format.raw/*10.40*/("""</title>
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
    <link href=""""),_display_(/*24.18*/routes/*24.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*24.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*25.18*/routes/*25.24*/.Assets.versioned("stylesheets/main.css")),format.raw/*25.65*/("""" rel="stylesheet" />
  </head>
  <body class="bg-theme">
    """),_display_(/*28.6*/views/*28.11*/.html.telco.Menu(currentUser, "", userId)),format.raw/*28.52*/("""
    """),_display_(/*29.6*/views/*29.11*/.html.telco.Header(currentUser)),format.raw/*29.42*/("""

    """),format.raw/*31.5*/("""<div>
      <div class="page-wrapper">
        <div class="page-content">
          <div class="section features-1">
            <div class="container-1">
              """),_display_(/*36.16*/views/*36.21*/.html.telco.statisticalReport.searchForm()),format.raw/*36.63*/("""

              """),format.raw/*38.15*/("""<div id="RedBaringContainer" class="card">
                <div class="card-body">
                  <div class="table-responsive py-4 style="border-radius: 8px;" id="RedBaringTable">
                    <table class="table table-striped" style="width: 100%; border: 1px solid;">
                      <thead style="background-color: #FBCCD6;">
                        <tr>
                          <th>"""),_display_(/*44.32*/Messages("manage.stt")),format.raw/*44.54*/("""</th>
                          <th>"""),_display_(/*45.32*/Messages("redbaring.subscriber.number")),format.raw/*45.71*/("""</th>
                          <th>"""),_display_(/*46.32*/Messages("redbaring.contract.code")),format.raw/*46.67*/("""</th>
                          <th>"""),_display_(/*47.32*/Messages("redbaring.credit.limit")),format.raw/*47.66*/("""</th>
                          <th>"""),_display_(/*48.32*/Messages("redbaring.incurred.charges")),format.raw/*48.70*/("""</th>
                          <th>"""),_display_(/*49.32*/Messages("redbaring.billing.period")),format.raw/*49.68*/("""</th>
                          <th>"""),_display_(/*50.32*/Messages("redbaring.block.type")),format.raw/*50.64*/("""</th>
                          <th>"""),_display_(/*51.32*/Messages("redbaring.update.time")),format.raw/*51.65*/("""</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td colspan="12" class="text-center">"""),_display_(/*56.65*/Messages("manage.no.data")),format.raw/*56.91*/("""</td>
                        </tr>
                      </tbody>
                    </table>
                    <h5 id="notiNotDataSubs" style="text-align: center;"></h5>
                  </div>
                  <div class="row pagination-section">
                    <div class="col-md-4 d-flex align-items-center justify-content-center justify-content-md-start mb-3">
                      <p class="mb-0">"""),_display_(/*64.40*/Messages("Total")),format.raw/*64.57*/(""" """),format.raw/*64.58*/("""<span id="total_record">0</span> """),_display_(/*64.92*/Messages("entries")),format.raw/*64.111*/("""</p>
                    </div>
                    <div class="col-md-8 d-flex flex-column flex-md-row justify-content-end align-items-center gap-2 gap-md-3 mb-3">
                      <div class="dropdown mb-2 mb-md-0">
                        <button class="btn btn-sm dropdown-toggle btn-outline-dark" type="button" data-bs-toggle="dropdown"
                          aria-expanded="false" id="countPageSize" style="margin-left: 5px;">
                          10
                        </button>
                        <ul class="dropdown-menu">
                          <li><a class="dropdown-item" href="javascript:handleChangePageSize(1,10,true)">10</a></li>
                          <li><a class="dropdown-item" href="javascript:handleChangePageSize(1,50,true)">50</a></li>
                          <li><a class="dropdown-item" href="javascript:handleChangePageSize(1,100,true)">100</a></li>
                          <li><a class="dropdown-item" href="javascript:handleChangePageSize(1,200,true)">200</a></li>
                          <li><a class="dropdown-item" href="javascript:handleChangePageSize(1,500,true)">500</a></li>
                        </ul>
                      </div>
                      <p class="mb-2 mb-md-0">"""),_display_(/*80.48*/Messages("entries.per.page")),format.raw/*80.76*/("""</p>
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
            </div>
          </div>
        </div>
      </div>
    </div>

    """),_display_(/*97.6*/views/*97.11*/.html.telco.Loading()),format.raw/*97.32*/("""
    """),_display_(/*98.6*/views/*98.11*/.html.telco.mainJs()),format.raw/*98.31*/("""
    """),_display_(/*99.6*/views/*99.11*/.html.telco.statisticalReport.exportReportModal(true)),format.raw/*99.64*/("""
    
    """),format.raw/*101.5*/("""<script>
      var userId = '"""),_display_(/*102.22*/userId),format.raw/*102.28*/("""';
      var totalSubscriber = 0;

      $('#exportReportModal').on('hidden.bs.modal', function () """),format.raw/*105.65*/("""{"""),format.raw/*105.66*/("""
          """),format.raw/*106.11*/("""$('#report-page-size').val('1000');
          $('#exportReportModal #page').val('1');
          $('#exportReportModal #pageSize').val('10');
          $('#report-export-table-container #file_export tbody').html('<tr><td colspan="3" class="text-center">' + Messages("manage.no.data") + '</td></tr>');
          $("#addBtnDownloadAll #btnDownloadAll").removeClass("text-danger");
          $("#addBtnDownloadAll #btnDownloadAll").addClass("text-darker");
          $("#addBtnDownloadAll #btnDownloadAll").off("click");
      """),format.raw/*113.7*/("""}"""),format.raw/*113.8*/(""");

    </script>
    <script src=""""),_display_(/*116.19*/routes/*116.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*116.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*117.19*/routes/*117.25*/.Assets.versioned("javascripts/views/telco/statisticReport/common.js")),format.raw/*117.95*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*118.19*/routes/*118.25*/.Assets.versioned("javascripts/views/telco/statisticReport/redBaring.js")),format.raw/*118.98*/("""" type="text/javascript"></script>
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
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/statisticalReport/redBaring.scala.html
                  HASH: d25b1fea98871a7f099b9f4ebd050780801bb707
                  MATRIX: 675->1|711->31|751->65|1095->97|1223->130|1250->131|1419->273|1467->300|1548->354|1563->360|1620->396|1827->577|1841->582|1887->607|1920->613|1960->626|1975->632|2050->686|2116->725|2131->731|2216->795|2270->912|2302->917|2342->930|2357->936|2427->985|2490->1021|2505->1027|2601->1102|2665->1139|2680->1145|2817->1260|2882->1298|2897->1304|2972->1358|3038->1397|3053->1403|3115->1444|3204->1507|3218->1512|3280->1553|3312->1559|3326->1564|3378->1595|3411->1601|3608->1771|3622->1776|3685->1818|3729->1834|4161->2239|4204->2261|4268->2298|4328->2337|4392->2374|4448->2409|4512->2446|4567->2480|4631->2517|4690->2555|4754->2592|4811->2628|4875->2665|4928->2697|4992->2734|5046->2767|5263->2957|5310->2983|5753->3399|5791->3416|5820->3417|5881->3451|5922->3470|7201->4722|7250->4750|7854->5328|7868->5333|7910->5354|7942->5360|7956->5365|7997->5385|8029->5391|8043->5396|8117->5449|8155->5459|8213->5489|8241->5495|8369->5594|8399->5595|8439->5606|8990->6129|9019->6130|9083->6166|9099->6172|9180->6231|9261->6284|9277->6290|9369->6360|9450->6413|9466->6419|9561->6492
                  LINES: 24->1|25->2|26->3|31->4|36->4|37->5|42->10|42->10|43->11|43->11|43->11|48->16|48->16|48->16|50->18|50->18|50->18|50->18|51->19|51->19|51->19|52->20|53->21|53->21|53->21|53->21|54->22|54->22|54->22|55->23|55->23|55->23|56->24|56->24|56->24|57->25|57->25|57->25|60->28|60->28|60->28|61->29|61->29|61->29|63->31|68->36|68->36|68->36|70->38|76->44|76->44|77->45|77->45|78->46|78->46|79->47|79->47|80->48|80->48|81->49|81->49|82->50|82->50|83->51|83->51|88->56|88->56|96->64|96->64|96->64|96->64|96->64|112->80|112->80|129->97|129->97|129->97|130->98|130->98|130->98|131->99|131->99|131->99|133->101|134->102|134->102|137->105|137->105|138->106|145->113|145->113|148->116|148->116|148->116|149->117|149->117|149->117|150->118|150->118|150->118
                  -- GENERATED --
              */
          