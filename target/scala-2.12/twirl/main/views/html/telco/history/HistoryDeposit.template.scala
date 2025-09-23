
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

object HistoryDeposit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("history.deposit.title")),format.raw/*9.46*/("""</title>
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
            """),_display_(/*30.14*/views/*30.19*/.html.telco.history.HistoryDeposit_formSearch(currentUser)),format.raw/*30.77*/("""

            """),format.raw/*32.13*/("""<div class="card">
                <div class="card-body">
                    <div class="table-responsive" style="border-radius: 8px;">
                        <table class="table table-striped" id="listHistoryDepositTable" style="width: 100%;">
                            <thead style="background-color: #FBCCD6;">
                                <tr>
                                    <th>"""),_display_(/*38.42*/Messages("manage.stt")),format.raw/*38.64*/("""</th>
                                    <th>"""),_display_(/*39.42*/Messages("history.deposit.order.id")),format.raw/*39.78*/("""</th>
                                    <th>"""),_display_(/*40.42*/Messages("history.deposit.subscriber.number")),format.raw/*40.87*/("""</th>
                                    <th>"""),_display_(/*41.42*/Messages("history.deposit.action")),format.raw/*41.76*/("""</th>
                                    <th>"""),_display_(/*42.42*/Messages("history.deposit.amount")),format.raw/*42.76*/("""</th>
                                    <th>"""),_display_(/*43.42*/Messages("history.deposit.total.amount")),format.raw/*43.82*/("""</th>
                                    <th>"""),_display_(/*44.42*/Messages("history.deposit.status")),format.raw/*44.76*/("""</th>
                                    <th>"""),_display_(/*45.42*/Messages("history.deposit.description")),format.raw/*45.81*/("""</th>
                                    <th>"""),_display_(/*46.42*/Messages("history.deposit.time")),format.raw/*46.74*/("""</th>
                                </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                        <h5 id="notiNotDataHistory" style="text-align: center;"></h5>
                    </div>
                    <div class="row">
                        <div class="col-md-4 d-flex align-items-center justify-content-center justify-content-md-start mb-3">
                            <p class="mb-0">"""),_display_(/*55.46*/Messages("Total")),format.raw/*55.63*/(""" """),format.raw/*55.64*/("""<span id="total_record">0</span> """),_display_(/*55.98*/Messages("entries")),format.raw/*55.117*/("""</p>
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
                            <p class="mb-2 mb-md-0">"""),_display_(/*71.54*/Messages("history.records.per.page")),format.raw/*71.90*/("""</p>
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

        """),_display_(/*85.10*/views/*85.15*/.html.telco.Loading()),format.raw/*85.36*/("""
    """),format.raw/*86.5*/("""</div>

    """),_display_(/*88.6*/views/*88.11*/.html.telco.mainJs()),format.raw/*88.31*/("""

    """),format.raw/*90.5*/("""<script src=""""),_display_(/*90.19*/routes/*90.25*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/moment.min.js")),format.raw/*90.111*/(""""></script>
    <script src=""""),_display_(/*91.19*/routes/*91.25*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.min.js")),format.raw/*91.138*/(""""></script>
    <script src=""""),_display_(/*92.19*/routes/*92.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*92.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*93.19*/routes/*93.25*/.Assets.versioned("javascripts/views/telco/history/History_deposit.js")),format.raw/*93.96*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*94.19*/routes/*94.25*/.Assets.versioned("javascripts/views/telco/history/History_deposit_export.js")),format.raw/*94.103*/("""" type="text/javascript"></script>
    <script>
        var userId = '"""),_display_(/*96.24*/userId),format.raw/*96.30*/("""';
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
                  DATE: Mon Sep 22 16:32:52 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/history/HistoryDeposit.scala.html
                  HASH: 7d4473d31a0d9581e9cce1ee900c65b810c26192
                  MATRIX: 665->1|1016->35|1146->70|1174->72|1340->212|1393->245|1474->299|1489->305|1546->341|1755->524|1769->529|1815->554|1848->560|1888->573|1903->579|1978->633|2044->672|2059->678|2144->742|2210->781|2225->787|2295->836|2361->875|2376->881|2513->996|2578->1034|2593->1040|2668->1094|2754->1154|2768->1159|2830->1200|2862->1206|2876->1211|2928->1242|2961->1248|3063->1323|3077->1328|3156->1386|3198->1400|3622->1797|3665->1819|3739->1866|3796->1902|3870->1949|3936->1994|4010->2041|4065->2075|4139->2122|4194->2156|4268->2203|4329->2243|4403->2290|4458->2324|4532->2371|4592->2410|4666->2457|4719->2489|5226->2969|5264->2986|5293->2987|5354->3021|5395->3040|6761->4379|6818->4415|7384->4954|7398->4959|7440->4980|7472->4985|7511->4998|7525->5003|7566->5023|7599->5029|7640->5043|7655->5049|7763->5135|7820->5165|7835->5171|7970->5284|8027->5314|8042->5320|8122->5379|8202->5432|8217->5438|8309->5509|8389->5562|8404->5568|8504->5646|8602->5717|8629->5723
                  LINES: 24->1|29->2|34->2|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|51->19|51->19|52->20|52->20|52->20|53->21|53->21|53->21|57->25|57->25|57->25|58->26|58->26|58->26|60->28|62->30|62->30|62->30|64->32|70->38|70->38|71->39|71->39|72->40|72->40|73->41|73->41|74->42|74->42|75->43|75->43|76->44|76->44|77->45|77->45|78->46|78->46|87->55|87->55|87->55|87->55|87->55|103->71|103->71|117->85|117->85|117->85|118->86|120->88|120->88|120->88|122->90|122->90|122->90|122->90|123->91|123->91|123->91|124->92|124->92|124->92|125->93|125->93|125->93|126->94|126->94|126->94|128->96|128->96
                  -- GENERATED --
              */
          