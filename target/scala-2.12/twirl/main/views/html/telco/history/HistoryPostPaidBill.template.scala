
package views.html.telco.history

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
/*1.2*/import vn.m2m.common.models.User

object HistoryPostPaidBill extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser: User, userId: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.37*/("""

"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("history.postpaid.title")),format.raw/*9.47*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""" />

    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*17.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("assets/plugins/input-tags/css/tagsinput.css")),format.raw/*18.88*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*19.73*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*20.139*/("""" rel="stylesheet" >
    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*21.78*/("""" rel="stylesheet" />
</head>

<body class="bg-theme">
    """),_display_(/*25.6*/views/*25.11*/.html.telco.Menu(currentUser, "", userId)),format.raw/*25.52*/("""
    """),_display_(/*26.6*/views/*26.11*/.html.telco.Header(currentUser)),format.raw/*26.42*/("""

    """),format.raw/*28.5*/("""<div class="page-wrapper">
        <div class="page-content">
            """),_display_(/*30.14*/views/*30.19*/.html.telco.history.HistoryPostPaidBill_formSearch(currentUser)),format.raw/*30.82*/("""

            """),format.raw/*32.13*/("""<div class="card">
                <div class="card-body">
                    <div class="table-responsive" style="border-radius: 8px;">
                        <table class="table table-striped" id="listHistoryPostPaidBillTable" style="width: 100%;">
                            <thead style="background-color: #FBCCD6;">
                                <tr>
                                    <th>"""),_display_(/*38.42*/Messages("manage.stt")),format.raw/*38.64*/("""</th>
                                    <th>"""),_display_(/*39.42*/Messages("history.postpaid.transaction.code")),format.raw/*39.87*/("""</th>
                                    <th>"""),_display_(/*40.42*/Messages("history.postpaid.contract.number")),format.raw/*40.86*/("""</th>
                                    <th>"""),_display_(/*41.42*/Messages("history.postpaid.amount")),format.raw/*41.77*/("""</th>
                                    <th>"""),_display_(/*42.42*/Messages("history.postpaid.status")),format.raw/*42.77*/("""</th>
                                    <th>"""),_display_(/*43.42*/Messages("history.postpaid.description")),format.raw/*43.82*/("""</th>
                                    <th>"""),_display_(/*44.42*/Messages("history.postpaid.time")),format.raw/*44.75*/("""</th>
                                </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                        <h5 id="notiNotDataHistory" style="text-align: center;"></h5>
                    </div>
                    <div class="row" id="listHistoryPostPaidBillPaging">
                        <div class="col-md-4 d-flex align-items-center justify-content-center justify-content-md-start mb-3">
                            <p class="mb-0">"""),_display_(/*53.46*/Messages("Total")),format.raw/*53.63*/(""" """),format.raw/*53.64*/("""<span id="total_record">0</span> """),_display_(/*53.98*/Messages("entries")),format.raw/*53.117*/("""</p>
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
                            <p class="mb-2 mb-md-0">"""),_display_(/*69.54*/Messages("history.records.per.page")),format.raw/*69.90*/("""</p>
                            <div id="pagingTable" class="justify-content-md-end"></div>
                        </div>

                    </div>
                    <div>
                        <input type="hidden" name="page" id="page" value="1" />
                        <input type="hidden" name="pageSize" id="pageSize" value="10" />
                        <input type="hidden" name="isResetPage" id="isResetPage" value="false" />
                    </div>
                </div>
            </div>
        </div>

        """),_display_(/*83.10*/views/*83.15*/.html.telco.Loading()),format.raw/*83.36*/("""
    """),format.raw/*84.5*/("""</div>

    """),_display_(/*86.6*/views/*86.11*/.html.telco.mainJs()),format.raw/*86.31*/("""

    """),format.raw/*88.5*/("""<script src=""""),_display_(/*88.19*/routes/*88.25*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/moment.min.js")),format.raw/*88.111*/(""""></script>
    <script src=""""),_display_(/*89.19*/routes/*89.25*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.min.js")),format.raw/*89.138*/(""""></script>
    <script src=""""),_display_(/*90.19*/routes/*90.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*90.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*91.19*/routes/*91.25*/.Assets.versioned("javascripts/views/telco/history/History_post_paid_bill.js")),format.raw/*91.103*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*92.19*/routes/*92.25*/.Assets.versioned("javascripts/views/telco/history/History_post_paid_bill_export.js")),format.raw/*92.110*/("""" type="text/javascript"></script>
    <script>
        var userId = '"""),_display_(/*94.24*/userId),format.raw/*94.30*/("""';
        var actionCode = "10";
    </script>
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
                  DATE: Mon Sep 22 16:32:53 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/history/HistoryPostPaidBill.scala.html
                  HASH: 8de393f7654737b81db03ca2944f461dde84ddab
                  MATRIX: 665->1|1021->35|1151->70|1179->72|1345->212|1399->246|1480->300|1495->306|1552->342|1761->525|1775->530|1821->555|1854->561|1894->574|1909->580|1984->634|2050->673|2065->679|2150->743|2216->782|2231->788|2301->837|2367->876|2382->882|2519->997|2584->1035|2599->1041|2674->1095|2760->1155|2774->1160|2836->1201|2868->1207|2882->1212|2934->1243|2967->1249|3069->1324|3083->1329|3167->1392|3209->1406|3638->1808|3681->1830|3755->1877|3821->1922|3895->1969|3960->2013|4034->2060|4090->2095|4164->2142|4220->2177|4294->2224|4355->2264|4429->2311|4483->2344|5025->2859|5063->2876|5092->2877|5153->2911|5194->2930|6560->4269|6617->4305|7183->4844|7197->4849|7239->4870|7271->4875|7310->4888|7324->4893|7365->4913|7398->4919|7439->4933|7454->4939|7562->5025|7619->5055|7634->5061|7769->5174|7826->5204|7841->5210|7921->5269|8001->5322|8016->5328|8116->5406|8196->5459|8211->5465|8318->5550|8416->5621|8443->5627
                  LINES: 24->1|29->2|34->2|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|51->19|51->19|52->20|52->20|52->20|53->21|53->21|53->21|57->25|57->25|57->25|58->26|58->26|58->26|60->28|62->30|62->30|62->30|64->32|70->38|70->38|71->39|71->39|72->40|72->40|73->41|73->41|74->42|74->42|75->43|75->43|76->44|76->44|85->53|85->53|85->53|85->53|85->53|101->69|101->69|115->83|115->83|115->83|116->84|118->86|118->86|118->86|120->88|120->88|120->88|120->88|121->89|121->89|121->89|122->90|122->90|122->90|123->91|123->91|123->91|124->92|124->92|124->92|126->94|126->94
                  -- GENERATED --
              */
          