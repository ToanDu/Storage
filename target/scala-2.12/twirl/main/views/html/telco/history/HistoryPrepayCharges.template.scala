
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

object HistoryPrepayCharges extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("history.prepay.title")),format.raw/*9.45*/("""</title>
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
            """),_display_(/*30.14*/views/*30.19*/.html.telco.history.HistoryPrepayCharges_formSearch(currentUser)),format.raw/*30.83*/("""

           """),format.raw/*32.12*/("""<div class="card">
                <div class="card-body">
                    <div class="table-responsive" style="border-radius: 8px;">
                        <table class="table table-striped" id="listPrepayChargesTable" style="width: 100%;">
                            <thead style="background-color: #FBCCD6;">
                                <tr>
                                    <th>"""),_display_(/*38.42*/Messages("manage.stt")),format.raw/*38.64*/("""</th>
                                    <th>"""),_display_(/*39.42*/Messages("history.prepay.table.transaction.code")),format.raw/*39.91*/("""</th>
                                    <th>"""),_display_(/*40.42*/Messages("history.prepay.table.subscriber.number")),format.raw/*40.92*/("""</th>
                                    <th>"""),_display_(/*41.42*/Messages("history.miaddon.table.package")),format.raw/*41.83*/("""</th>
                                    <th>"""),_display_(/*42.42*/Messages("history.prepay.table.promotion")),format.raw/*42.84*/("""</th>
                                    <th>"""),_display_(/*43.42*/Messages("history.prepay.table.months")),format.raw/*43.81*/("""</th>
                                    <th>"""),_display_(/*44.42*/Messages("history.prepay.table.bonus")),format.raw/*44.80*/("""</th>
                                    <th>"""),_display_(/*45.42*/Messages("history.prepay.table.amount")),format.raw/*45.81*/("""</th>
                                    <th>"""),_display_(/*46.42*/Messages("filter.status")),format.raw/*46.67*/("""</th>
                                    <th>"""),_display_(/*47.42*/Messages("history.prepay.table.description")),format.raw/*47.86*/("""</th>
                                    <th>"""),_display_(/*48.42*/Messages("history.miaddon.table.time")),format.raw/*48.80*/("""</th>
                                </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                        <h5 id="notiNotDataHistory" style="text-align: center;"></h5>
                    </div>
                    <div class="row">
                        <div class="col-md-4 d-flex align-items-center justify-content-center justify-content-md-start mb-3">
                            <p class="mb-0">"""),_display_(/*57.46*/Messages("Total")),format.raw/*57.63*/(""" """),format.raw/*57.64*/("""<span id="total_record">0</span> """),_display_(/*57.98*/Messages("entries")),format.raw/*57.117*/("""</p>
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
                            <p class="mb-2 mb-md-0">"""),_display_(/*73.54*/Messages("history.records.per.page")),format.raw/*73.90*/("""</p>
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

        """),_display_(/*87.10*/views/*87.15*/.html.telco.Loading()),format.raw/*87.36*/("""
    """),format.raw/*88.5*/("""</div>

    """),_display_(/*90.6*/views/*90.11*/.html.telco.mainJs()),format.raw/*90.31*/("""

    """),format.raw/*92.5*/("""<script src=""""),_display_(/*92.19*/routes/*92.25*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/moment.min.js")),format.raw/*92.111*/(""""></script>
    <script src=""""),_display_(/*93.19*/routes/*93.25*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.min.js")),format.raw/*93.138*/(""""></script>
    <script src=""""),_display_(/*94.19*/routes/*94.25*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*94.85*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*95.19*/routes/*95.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*95.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*96.19*/routes/*96.25*/.Assets.versioned("javascripts/views/telco/history/History_prepay_charges.js")),format.raw/*96.103*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*97.19*/routes/*97.25*/.Assets.versioned("javascripts/views/telco/history/History_prepay_charges_export.js")),format.raw/*97.110*/("""" type="text/javascript"></script>
    <script>
        var userId = '"""),_display_(/*99.24*/userId),format.raw/*99.30*/("""';
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/history/HistoryPrepayCharges.scala.html
                  HASH: 35bf4858127da81b803894daa882e37d36ae19d6
                  MATRIX: 665->1|1022->35|1152->70|1180->72|1346->212|1398->244|1479->298|1494->304|1551->340|1760->523|1774->528|1820->553|1853->559|1893->572|1908->578|1983->632|2049->671|2064->677|2149->741|2215->780|2230->786|2300->835|2366->874|2381->880|2518->995|2583->1033|2598->1039|2673->1093|2759->1153|2773->1158|2835->1199|2867->1205|2881->1210|2933->1241|2966->1247|3068->1322|3082->1327|3167->1391|3208->1404|3631->1800|3674->1822|3748->1869|3818->1918|3892->1965|3963->2015|4037->2062|4099->2103|4173->2150|4236->2192|4310->2239|4370->2278|4444->2325|4503->2363|4577->2410|4637->2449|4711->2496|4757->2521|4831->2568|4896->2612|4970->2659|5029->2697|5536->3177|5574->3194|5603->3195|5664->3229|5705->3248|7071->4587|7128->4623|7694->5162|7708->5167|7750->5188|7782->5193|7821->5206|7835->5211|7876->5231|7909->5237|7950->5251|7965->5257|8073->5343|8130->5373|8145->5379|8280->5492|8337->5522|8352->5528|8433->5588|8513->5641|8528->5647|8608->5706|8688->5759|8703->5765|8803->5843|8883->5896|8898->5902|9005->5987|9103->6058|9130->6064
                  LINES: 24->1|29->2|34->2|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|51->19|51->19|52->20|52->20|52->20|53->21|53->21|53->21|57->25|57->25|57->25|58->26|58->26|58->26|60->28|62->30|62->30|62->30|64->32|70->38|70->38|71->39|71->39|72->40|72->40|73->41|73->41|74->42|74->42|75->43|75->43|76->44|76->44|77->45|77->45|78->46|78->46|79->47|79->47|80->48|80->48|89->57|89->57|89->57|89->57|89->57|105->73|105->73|119->87|119->87|119->87|120->88|122->90|122->90|122->90|124->92|124->92|124->92|124->92|125->93|125->93|125->93|126->94|126->94|126->94|127->95|127->95|127->95|128->96|128->96|128->96|129->97|129->97|129->97|131->99|131->99
                  -- GENERATED --
              */
          