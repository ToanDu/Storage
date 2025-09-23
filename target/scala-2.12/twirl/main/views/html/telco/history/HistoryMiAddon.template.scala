
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
/*1.2*/import vn.m2m.utils.DateUtil
/*2.2*/import vn.m2m.common.models.User

object HistoryMiAddon extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.35*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("history.miaddon.title")),format.raw/*9.46*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*17.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("assets/plugins/input-tags/css/tagsinput.css")),format.raw/*18.88*/("""" rel="stylesheet" />
    """),format.raw/*19.96*/("""
    """),format.raw/*20.5*/("""<link href='"""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*20.73*/("""' type='text/css'>
    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*21.99*/("""" rel="stylesheet">
    <link href=""""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*22.139*/("""" rel="stylesheet" >

    <link href=""""),_display_(/*24.18*/routes/*24.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*24.78*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*28.6*/views/*28.11*/.html.telco.Menu(currentUser, "", userId)),format.raw/*28.52*/("""

    """),_display_(/*30.6*/views/*30.11*/.html.telco.Header(currentUser)),format.raw/*30.42*/("""

    """),format.raw/*32.5*/("""<div class="page-wrapper" id="historyMiAddonPage">
      <div class="page-content">
        """),_display_(/*34.10*/views/*34.15*/.html.telco.history.HistoryMiAddon_formSearch(currentUser)),format.raw/*34.73*/("""
        """),format.raw/*35.9*/("""<div class="card">
          <div class="table-responsive mb-3" style="border-radius: 8px;">
            <table class="table table-striped" id="listHistorysTable" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th>"""),_display_(/*40.24*/Messages("manage.stt")),format.raw/*40.46*/("""</th>
                  <th>"""),_display_(/*41.24*/Messages("history.miaddon.table.gpkd")),format.raw/*41.62*/("""</th>
                  <th>"""),_display_(/*42.24*/Messages("history.miaddon.table.isdn")),format.raw/*42.62*/("""</th>
                  <th>"""),_display_(/*43.24*/Messages("history.miaddon.table.package")),format.raw/*43.65*/("""</th>
                  <th>"""),_display_(/*44.24*/Messages("filter.status")),format.raw/*44.49*/("""</th>
                  <th>"""),_display_(/*45.24*/Messages("filter.content")),format.raw/*45.50*/("""</th>
                  <th>"""),_display_(/*46.24*/Messages("history.miaddon.table.time")),format.raw/*46.62*/("""</th>
                </tr>
              </thead>
              <tbody></tbody>
            </table>
            <h5 id="notiNotData" style="text-align: center;"></h5>
          </div>
          
          <div class="row pagination-section px-2">
            <div class="col-md-4 d-flex align-items-center justify-content-center justify-content-md-start mb-3">
              <p class="mb-0">"""),_display_(/*56.32*/Messages("Total")),format.raw/*56.49*/(""" """),format.raw/*56.50*/("""<span id="total_record">0</span> """),_display_(/*56.84*/Messages("entries")),format.raw/*56.103*/("""</p>
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
              <p class="mb-2 mb-md-0">"""),_display_(/*72.40*/Messages("history.records.per.page")),format.raw/*72.76*/("""</p>
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

      """),_display_(/*85.8*/views/*85.13*/.html.telco.Loading()),format.raw/*85.34*/("""

    """),format.raw/*87.5*/("""</div>

    """),_display_(/*89.6*/views/*89.11*/.html.telco.mainJs()),format.raw/*89.31*/("""

    """),format.raw/*91.5*/("""<script>
            var imgDefault = '"""),_display_(/*92.32*/routes/*92.38*/.Assets.versioned("images/market/default.png")),format.raw/*92.84*/("""';
            var roleCmp = '"""),_display_(/*93.29*/User/*93.33*/.CmpRole.getNameByCode(currentUser.getCmpRole)),format.raw/*93.79*/("""';
            console.log(roleCmp);
            var userId = '"""),_display_(/*95.28*/userId),format.raw/*95.34*/("""';
            $(document).ready(function () """),format.raw/*96.43*/("""{"""),format.raw/*96.44*/("""
              """),format.raw/*97.15*/("""$("#menu-historyMiAddon").addClass("mm-active");
              $("#menu").metisMenu();

              $('.datetimepicker').bootstrapMaterialDatePicker("""),format.raw/*100.64*/("""{"""),format.raw/*100.65*/("""
                """),format.raw/*101.17*/("""format: 'DD/MM/YYYY',
                time: false
              """),format.raw/*103.15*/("""}"""),format.raw/*103.16*/(""");
            """),format.raw/*104.13*/("""}"""),format.raw/*104.14*/(""")
    </script>
    <script src=""""),_display_(/*106.19*/routes/*106.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*106.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*107.19*/routes/*107.25*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*107.85*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*109.19*/routes/*109.25*/.Assets.versioned("javascripts/views/telco/history/HistoryMiAddon.js")),format.raw/*109.95*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*110.19*/routes/*110.25*/.Assets.versioned("javascripts/views/telco/history/History_miaddon_export.js")),format.raw/*110.103*/("""" type="text/javascript"></script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/history/HistoryMiAddon.scala.html
                  HASH: 1b2110fec201f3f9f968f1caa79b9fa637611295
                  MATRIX: 665->1|701->31|1052->65|1180->98|1207->99|1375->241|1428->274|1509->328|1524->334|1581->370|1788->551|1802->556|1848->581|1881->587|1921->600|1936->606|2011->660|2077->699|2092->705|2177->769|2231->886|2263->891|2303->904|2318->910|2388->959|2451->995|2466->1001|2562->1076|2626->1113|2641->1119|2778->1234|2844->1273|2859->1279|2934->1333|3024->1397|3038->1402|3100->1443|3133->1450|3147->1455|3199->1486|3232->1492|3352->1585|3366->1590|3445->1648|3481->1657|3794->1943|3837->1965|3893->1994|3952->2032|4008->2061|4067->2099|4123->2128|4185->2169|4241->2198|4287->2223|4343->2252|4390->2278|4446->2307|4505->2345|4926->2739|4964->2756|4993->2757|5054->2791|5095->2810|6201->3889|6258->3925|6710->4351|6724->4356|6766->4377|6799->4383|6838->4396|6852->4401|6893->4421|6926->4427|6993->4467|7008->4473|7075->4519|7133->4550|7146->4554|7213->4600|7304->4664|7331->4670|7404->4715|7433->4716|7476->4731|7656->4882|7686->4883|7732->4900|7825->4964|7855->4965|7899->4980|7929->4981|7991->5015|8007->5021|8088->5080|8169->5133|8185->5139|8267->5199|8349->5253|8365->5259|8457->5329|8538->5382|8554->5388|8655->5466
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|52->20|52->20|52->20|52->20|53->21|53->21|53->21|54->22|54->22|54->22|56->24|56->24|56->24|60->28|60->28|60->28|62->30|62->30|62->30|64->32|66->34|66->34|66->34|67->35|72->40|72->40|73->41|73->41|74->42|74->42|75->43|75->43|76->44|76->44|77->45|77->45|78->46|78->46|88->56|88->56|88->56|88->56|88->56|104->72|104->72|117->85|117->85|117->85|119->87|121->89|121->89|121->89|123->91|124->92|124->92|124->92|125->93|125->93|125->93|127->95|127->95|128->96|128->96|129->97|132->100|132->100|133->101|135->103|135->103|136->104|136->104|138->106|138->106|138->106|139->107|139->107|139->107|141->109|141->109|141->109|142->110|142->110|142->110
                  -- GENERATED --
              */
          