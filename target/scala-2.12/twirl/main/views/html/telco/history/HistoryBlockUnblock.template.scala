
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

object HistoryBlockUnblock extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("history.blockunblock.title")),format.raw/*9.51*/("""</title>
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
            """),_display_(/*30.14*/views/*30.19*/.html.telco.history.HistoryBlockUnblock_formSearch(currentUser)),format.raw/*30.82*/("""

            """),format.raw/*32.13*/("""<div class="card">
                <div class="card-body">
                    <div class="table-responsive" style="border-radius: 8px;">
                        <table class="table table-striped" id="listHistoryBlockUnblockTable" style="width: 100%;">
                            <thead style="background-color: #FBCCD6;">
                                <tr>
                                    <th>"""),_display_(/*38.42*/Messages("manage.stt")),format.raw/*38.64*/("""</th>
                                    <th>"""),_display_(/*39.42*/Messages("history.blockunblock.subscriber.number")),format.raw/*39.92*/("""</th>
                                    <th>"""),_display_(/*40.42*/Messages("history.blockunblock.action")),format.raw/*40.81*/("""</th>
                                    <th>"""),_display_(/*41.42*/Messages("history.blockunblock.result")),format.raw/*41.81*/("""</th>
                                    <th>"""),_display_(/*42.42*/Messages("history.blockunblock.reason")),format.raw/*42.81*/("""</th>
                                    <th>"""),_display_(/*43.42*/Messages("history.blockunblock.time")),format.raw/*43.79*/("""</th>
                                </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                        <h5 id="notiNotDataHistory" style="text-align: center;"></h5>
                    </div>
                    <div class="row">
                        <div class="col-md-4 d-flex align-items-center justify-content-center justify-content-md-start mb-3">
                            <p class="mb-0">"""),_display_(/*52.46*/Messages("Total")),format.raw/*52.63*/(""" """),format.raw/*52.64*/("""<span id="total_record">0</span> """),_display_(/*52.98*/Messages("entries")),format.raw/*52.117*/("""</p>
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
                            <p class="mb-2 mb-md-0">"""),_display_(/*68.54*/Messages("history.records.per.page")),format.raw/*68.90*/("""</p>
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

        """),_display_(/*82.10*/views/*82.15*/.html.telco.Loading()),format.raw/*82.36*/("""
    """),format.raw/*83.5*/("""</div>

    """),_display_(/*85.6*/views/*85.11*/.html.telco.mainJs()),format.raw/*85.31*/("""

    """),format.raw/*87.5*/("""<script src=""""),_display_(/*87.19*/routes/*87.25*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/moment.min.js")),format.raw/*87.111*/(""""></script>
    <script src=""""),_display_(/*88.19*/routes/*88.25*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.min.js")),format.raw/*88.138*/(""""></script>
    <script src=""""),_display_(/*89.19*/routes/*89.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*89.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*90.19*/routes/*90.25*/.Assets.versioned("javascripts/views/telco/history/History_block_unblock.js")),format.raw/*90.102*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*91.19*/routes/*91.25*/.Assets.versioned("javascripts/views/telco/history/History_block_unblock_export.js")),format.raw/*91.109*/("""" type="text/javascript"></script>
    <script>
        var userId = '"""),_display_(/*93.24*/userId),format.raw/*93.30*/("""';
        var actionCode = "06,07,08,09";
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/history/HistoryBlockUnblock.scala.html
                  HASH: 747e60e368b5ce672649d353befa7c6c227f6f6a
                  MATRIX: 665->1|1021->35|1151->70|1179->72|1345->212|1403->250|1484->304|1499->310|1556->346|1765->529|1779->534|1825->559|1858->565|1898->578|1913->584|1988->638|2054->677|2069->683|2154->747|2220->786|2235->792|2305->841|2371->880|2386->886|2523->1001|2588->1039|2603->1045|2678->1099|2764->1159|2778->1164|2840->1205|2872->1211|2886->1216|2938->1247|2971->1253|3073->1328|3087->1333|3171->1396|3213->1410|3642->1812|3685->1834|3759->1881|3830->1931|3904->1978|3964->2017|4038->2064|4098->2103|4172->2150|4232->2189|4306->2236|4364->2273|4871->2753|4909->2770|4938->2771|4999->2805|5040->2824|6406->4163|6463->4199|7029->4738|7043->4743|7085->4764|7117->4769|7156->4782|7170->4787|7211->4807|7244->4813|7285->4827|7300->4833|7408->4919|7465->4949|7480->4955|7615->5068|7672->5098|7687->5104|7767->5163|7847->5216|7862->5222|7961->5299|8041->5352|8056->5358|8162->5442|8260->5513|8287->5519
                  LINES: 24->1|29->2|34->2|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|51->19|51->19|52->20|52->20|52->20|53->21|53->21|53->21|57->25|57->25|57->25|58->26|58->26|58->26|60->28|62->30|62->30|62->30|64->32|70->38|70->38|71->39|71->39|72->40|72->40|73->41|73->41|74->42|74->42|75->43|75->43|84->52|84->52|84->52|84->52|84->52|100->68|100->68|114->82|114->82|114->82|115->83|117->85|117->85|117->85|119->87|119->87|119->87|119->87|120->88|120->88|120->88|121->89|121->89|121->89|122->90|122->90|122->90|123->91|123->91|123->91|125->93|125->93
                  -- GENERATED --
              */
          