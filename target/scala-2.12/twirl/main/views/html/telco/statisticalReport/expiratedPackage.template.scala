
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

object expiratedPackage extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*10.13*/Messages("report.expirated.title")),format.raw/*10.47*/("""</title>
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
    """),_display_(/*29.6*/views/*29.11*/.html.telco.Menu(currentUser, "", userId)),format.raw/*29.52*/("""
    """),_display_(/*30.6*/views/*30.11*/.html.telco.Header(currentUser)),format.raw/*30.42*/("""

    """),format.raw/*32.5*/("""<div>
      <div class="page-wrapper">
        <div class="page-content">
          <div class="section features-1">
            <div class="container-1">
              """),_display_(/*37.16*/views/*37.21*/.html.telco.statisticalReport.searchForm(true)),format.raw/*37.67*/("""
              
              """),format.raw/*39.15*/("""<div id="expiratedPackageContainer" class="card">
                <div class="card-body">
                  <div class="row p-4 d-none" id="noDataFound">
                    """),_display_(/*42.22*/Messages("report.expirated.noData")),format.raw/*42.57*/("""
                  """),format.raw/*43.19*/("""</div>
                  <div class="table-responsive py-4 " style="border-radius: 8px;" id="expiratedPackageTable">
                    <table class="table table-striped" style="width: 100%; border: 1px solid;">
                      <thead style="background-color: #FBCCD6;">
                        <tr>
                          <th>"""),_display_(/*48.32*/Messages("report.expirated.table.stt")),format.raw/*48.70*/("""</th>
                          <th>"""),_display_(/*49.32*/Messages("report.expirated.table.subscriberNumber")),format.raw/*49.83*/("""</th>
                          <th>"""),_display_(/*50.32*/Messages("report.expirated.table.contractCode")),format.raw/*50.79*/("""</th>
                          <th>"""),_display_(/*51.32*/Messages("report.expirated.table.subscriberType")),format.raw/*51.81*/("""</th>
                          <th>"""),_display_(/*52.32*/Messages("report.expirated.table.packageType")),format.raw/*52.78*/("""</th>
                          <th>"""),_display_(/*53.32*/Messages("report.expirated.table.expiredDate")),format.raw/*53.78*/("""</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td colspan="12" class="text-center">"""),_display_(/*58.65*/Messages("report.expirated.noDataTable")),format.raw/*58.105*/("""</td>
                        </tr>
                      </tbody>
                    </table>
                    <h5 id="notiNotDataSubs" style="text-align: center;"></h5>
                  </div>
                  <div class="row pagination-section">
                    <div class="col-md-4 d-flex align-items-center justify-content-center justify-content-md-start mb-3">
                      <p class="mb-0">"""),_display_(/*66.40*/Messages("report.expirated.totalRecordsPrefix")),format.raw/*66.87*/(""" """),format.raw/*66.88*/("""<span id="total_record">0</span> """),_display_(/*66.122*/Messages("report.expirated.totalRecordsSuffix")),format.raw/*66.169*/("""</p>
                    </div>
                    <div class="col-md-8 d-flex flex-column flex-md-row justify-content-end align-items-center gap-2 gap-md-3 mb-3">
                      <div class="dropdown mb-2 mb-md-0">
                        <button class="btn btn-sm dropdown-toggle btn-outline-dark" type="button" data-bs-toggle="dropdown"
                          aria-expanded="false" id="countPageSize" style="margin-left: 5px;">
                          10
                        </button>
                        <ul class="dropdown-menu">
                          <li><a class="dropdown-item" href="javascript:handleChangePageSize(1,10)">10</a></li>
                          <li><a class="dropdown-item" href="javascript:handleChangePageSize(1,50)">50</a></li>
                          <li><a class="dropdown-item" href="javascript:handleChangePageSize(1,100)">100</a></li>
                          <li><a class="dropdown-item" href="javascript:handleChangePageSize(1,200)">200</a></li>
                          <li><a class="dropdown-item" href="javascript:handleChangePageSize(1,500)">500</a></li>
                        </ul>
                      </div>
                      <p class="mb-2 mb-md-0">"""),_display_(/*82.48*/Messages("report.expirated.recordsPerPage")),format.raw/*82.91*/("""</p>
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

    """),_display_(/*99.6*/views/*99.11*/.html.telco.Loading()),format.raw/*99.32*/("""
    """),_display_(/*100.6*/views/*100.11*/.html.telco.mainJs()),format.raw/*100.31*/("""
    """),_display_(/*101.6*/views/*101.11*/.html.telco.statisticalReport.exportReportModal(false)),format.raw/*101.65*/("""

    """),format.raw/*103.5*/("""<script>
      var userId = '"""),_display_(/*104.22*/userId),format.raw/*104.28*/("""';
      var totalSubscriber = 0;

      $('#statisticalReportSearchForm #dateFrom').bootstrapMaterialDatePicker("""),format.raw/*107.79*/("""{"""),format.raw/*107.80*/("""
        """),format.raw/*108.9*/("""format: 'DD/MM/YYYY',
        time: false
      """),format.raw/*110.7*/("""}"""),format.raw/*110.8*/(""");
      $('#statisticalReportSearchForm #dateTo').bootstrapMaterialDatePicker("""),format.raw/*111.77*/("""{"""),format.raw/*111.78*/("""
        """),format.raw/*112.9*/("""format: 'DD/MM/YYYY',
        time: false
      """),format.raw/*114.7*/("""}"""),format.raw/*114.8*/(""");
      $('#statisticalReportSearchForm #dateFrom').bootstrapMaterialDatePicker('setDate', moment());
      $('#statisticalReportSearchForm #dateTo').bootstrapMaterialDatePicker('setDate', moment().endOf('month'));

      $('#exportReportModal').on('hidden.bs.modal', function () """),format.raw/*118.65*/("""{"""),format.raw/*118.66*/("""
        """),format.raw/*119.9*/("""$('#report-page-size').val('1000');
        $('#exportReportModal #page').val('1');
        $('#exportReportModal #pageSize').val('10');
        $('#report-export-table-container #file_export tbody').html('<tr><td colspan="3" class="text-center">' + Messages("report.expirated.noDataExport") + '</td></tr>');
        $("#addBtnDownloadAll #btnDownloadAll").removeClass("text-danger");
        $("#addBtnDownloadAll #btnDownloadAll").addClass("text-darker");
        $("#addBtnDownloadAll #btnDownloadAll").off("click");
      """),format.raw/*126.7*/("""}"""),format.raw/*126.8*/(""");
    </script>
    <script src=""""),_display_(/*128.19*/routes/*128.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*128.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*129.19*/routes/*129.25*/.Assets.versioned("javascripts/views/telco/statisticReport/common.js")),format.raw/*129.95*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*130.19*/routes/*130.25*/.Assets.versioned("javascripts/views/telco/statisticReport/expiratedPackage.js")),format.raw/*130.105*/("""" type="text/javascript"></script>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/statisticalReport/expiratedPackage.scala.html
                  HASH: 71f61d1ef7efc1f07b6fd97dcaa67c3ef3de0995
                  MATRIX: 675->1|711->31|751->65|1102->97|1230->130|1257->131|1426->273|1481->307|1562->361|1577->367|1634->403|1841->584|1855->589|1901->614|1934->620|1974->633|1989->639|2064->693|2130->732|2145->738|2230->802|2284->919|2316->924|2356->937|2371->943|2441->992|2504->1028|2519->1034|2615->1109|2679->1146|2694->1152|2831->1267|2896->1305|2911->1311|2986->1365|3052->1404|3067->1410|3129->1451|3219->1515|3233->1520|3295->1561|3327->1567|3341->1572|3393->1603|3426->1609|3623->1779|3637->1784|3704->1830|3762->1860|3964->2035|4020->2070|4067->2089|4432->2427|4491->2465|4555->2502|4627->2553|4691->2590|4759->2637|4823->2674|4893->2723|4957->2760|5024->2806|5088->2843|5155->2889|5372->3079|5434->3119|5877->3535|5945->3582|5974->3583|6036->3617|6105->3664|7359->4891|7423->4934|8027->5512|8041->5517|8083->5538|8116->5544|8131->5549|8173->5569|8206->5575|8221->5580|8297->5634|8331->5640|8389->5670|8417->5676|8559->5789|8589->5790|8626->5799|8702->5847|8731->5848|8839->5927|8869->5928|8906->5937|8982->5985|9011->5986|9321->6267|9351->6268|9388->6277|9942->6803|9971->6804|10034->6839|10050->6845|10131->6904|10212->6957|10228->6963|10320->7033|10401->7086|10417->7092|10520->7172
                  LINES: 24->1|25->2|26->3|31->4|36->4|37->5|42->10|42->10|43->11|43->11|43->11|48->16|48->16|48->16|50->18|50->18|50->18|50->18|51->19|51->19|51->19|52->20|53->21|53->21|53->21|53->21|54->22|54->22|54->22|55->23|55->23|55->23|56->24|56->24|56->24|57->25|57->25|57->25|61->29|61->29|61->29|62->30|62->30|62->30|64->32|69->37|69->37|69->37|71->39|74->42|74->42|75->43|80->48|80->48|81->49|81->49|82->50|82->50|83->51|83->51|84->52|84->52|85->53|85->53|90->58|90->58|98->66|98->66|98->66|98->66|98->66|114->82|114->82|131->99|131->99|131->99|132->100|132->100|132->100|133->101|133->101|133->101|135->103|136->104|136->104|139->107|139->107|140->108|142->110|142->110|143->111|143->111|144->112|146->114|146->114|150->118|150->118|151->119|158->126|158->126|160->128|160->128|160->128|161->129|161->129|161->129|162->130|162->130|162->130
                  -- GENERATED --
              */
          