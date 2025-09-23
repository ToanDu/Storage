
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

object HistoryApn extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("history.apn.title")),format.raw/*9.42*/("""</title>
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
            """),_display_(/*30.14*/views/*30.19*/.html.telco.history.HistoryAPN_formSearch(currentUser)),format.raw/*30.73*/("""

            """),format.raw/*32.13*/("""<div class="card">
                <div class="card-body">
                    <div class="table-responsive" style="border-radius: 8px;">
                        <table class="table table-striped" id="listHistoryApnTable" style="width: 100%;">
                            <thead style="background-color: #FBCCD6;">
                                <tr>
                                    <th>"""),_display_(/*38.42*/Messages("manage.stt")),format.raw/*38.64*/("""</th>
                                    <th>"""),_display_(/*39.42*/Messages("history.apn.subscriber.number")),format.raw/*39.83*/("""</th>
                                    <th>"""),_display_(/*40.42*/Messages("history.apn.action")),format.raw/*40.72*/("""</th>
                                    <th>"""),_display_(/*41.42*/Messages("history.apn.apn")),format.raw/*41.69*/("""</th>
                                    <th>"""),_display_(/*42.42*/Messages("history.apn.ip")),format.raw/*42.68*/("""</th>
                                    <th>"""),_display_(/*43.42*/Messages("history.apn.start.date")),format.raw/*43.76*/("""</th>
                                    <th>"""),_display_(/*44.42*/Messages("history.apn.end.date")),format.raw/*44.74*/("""</th>
                                    <th>"""),_display_(/*45.42*/Messages("history.apn.result")),format.raw/*45.72*/("""</th>
                                    <th>"""),_display_(/*46.42*/Messages("history.apn.failure.reason")),format.raw/*46.80*/("""</th>
                                    <th>"""),_display_(/*47.42*/Messages("history.apn.time")),format.raw/*47.70*/("""</th>
                                </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                        <h5 id="notiNotDataHistory" style="text-align: center;"></h5>
                    </div>
                    <div class="row">
                        <div class="col-md-4 d-flex align-items-center justify-content-center justify-content-md-start mb-3">
                            <p class="mb-0">"""),_display_(/*56.46*/Messages("Total")),format.raw/*56.63*/(""" """),format.raw/*56.64*/("""<span id="total_record">0</span> """),_display_(/*56.98*/Messages("entries")),format.raw/*56.117*/("""</p>
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
                            <p class="mb-2 mb-md-0">"""),_display_(/*72.54*/Messages("history.records.per.page")),format.raw/*72.90*/("""</p>
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

        """),_display_(/*86.10*/views/*86.15*/.html.telco.Loading()),format.raw/*86.36*/("""
    """),format.raw/*87.5*/("""</div>

    """),_display_(/*89.6*/views/*89.11*/.html.telco.mainJs()),format.raw/*89.31*/("""

    """),format.raw/*91.5*/("""<script src=""""),_display_(/*91.19*/routes/*91.25*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/moment.min.js")),format.raw/*91.111*/(""""></script>
    <script src=""""),_display_(/*92.19*/routes/*92.25*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.min.js")),format.raw/*92.138*/(""""></script>
    <script src=""""),_display_(/*93.19*/routes/*93.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*93.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*94.19*/routes/*94.25*/.Assets.versioned("javascripts/views/telco/history/History_apn.js")),format.raw/*94.92*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*95.19*/routes/*95.25*/.Assets.versioned("javascripts/views/telco/history/History_apn_export.js")),format.raw/*95.99*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*96.19*/routes/*96.25*/.Assets.versioned("javascripts/views/telco/history/History_apn_validate.js")),format.raw/*96.101*/("""" type="text/javascript"></script>
    <script>
        var userId = '"""),_display_(/*98.24*/userId),format.raw/*98.30*/("""';
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/history/HistoryApn.scala.html
                  HASH: 3482359ac49adf3445abb56077cba8119926af72
                  MATRIX: 665->1|1012->35|1142->70|1170->72|1336->212|1385->241|1466->295|1481->301|1538->337|1747->520|1761->525|1807->550|1840->556|1880->569|1895->575|1970->629|2036->668|2051->674|2136->738|2202->777|2217->783|2287->832|2353->871|2368->877|2505->992|2570->1030|2585->1036|2660->1090|2746->1150|2760->1155|2822->1196|2854->1202|2868->1207|2920->1238|2953->1244|3055->1319|3069->1324|3144->1378|3186->1392|3606->1785|3649->1807|3723->1854|3785->1895|3859->1942|3910->1972|3984->2019|4032->2046|4106->2093|4153->2119|4227->2166|4282->2200|4356->2247|4409->2279|4483->2326|4534->2356|4608->2403|4667->2441|4741->2488|4790->2516|5297->2996|5335->3013|5364->3014|5425->3048|5466->3067|6832->4406|6889->4442|7455->4981|7469->4986|7511->5007|7543->5012|7582->5025|7596->5030|7637->5050|7670->5056|7711->5070|7726->5076|7834->5162|7891->5192|7906->5198|8041->5311|8098->5341|8113->5347|8193->5406|8273->5459|8288->5465|8376->5532|8456->5585|8471->5591|8566->5665|8646->5718|8661->5724|8759->5800|8857->5871|8884->5877
                  LINES: 24->1|29->2|34->2|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|51->19|51->19|52->20|52->20|52->20|53->21|53->21|53->21|57->25|57->25|57->25|58->26|58->26|58->26|60->28|62->30|62->30|62->30|64->32|70->38|70->38|71->39|71->39|72->40|72->40|73->41|73->41|74->42|74->42|75->43|75->43|76->44|76->44|77->45|77->45|78->46|78->46|79->47|79->47|88->56|88->56|88->56|88->56|88->56|104->72|104->72|118->86|118->86|118->86|119->87|121->89|121->89|121->89|123->91|123->91|123->91|123->91|124->92|124->92|124->92|125->93|125->93|125->93|126->94|126->94|126->94|127->95|127->95|127->95|128->96|128->96|128->96|130->98|130->98
                  -- GENERATED --
              */
          