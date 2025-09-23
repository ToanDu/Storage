
package views.html.telco.log.survey

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

object LogSurvey extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.20*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("Khảo sát")),format.raw/*9.33*/("""</title>
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
    """),_display_(/*28.6*/views/*28.11*/.html.telco.role.Menu(currentUser)),format.raw/*28.45*/("""

    """),_display_(/*30.6*/views/*30.11*/.html.telco.role.Header(currentUser)),format.raw/*30.47*/("""

    """),format.raw/*32.5*/("""<div class="page-wrapper">
      <div class="page-content">

        """),_display_(/*35.10*/views/*35.15*/.html.telco.log.survey.LogSurvey_search()),format.raw/*35.56*/("""

        """),format.raw/*37.9*/("""<div class="card">
          <div class="table-responsive mb-3" style="border-radius: 8px;">
            <table class="table table-striped" id="listLogsTable" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th>"""),_display_(/*42.24*/Messages("STT")),format.raw/*42.39*/("""</th>
                  <th>"""),_display_(/*43.24*/Messages("User")),format.raw/*43.40*/("""</th>
                  <th>"""),_display_(/*44.24*/Messages("Tên KH")),format.raw/*44.42*/("""</th>
                  <th>"""),_display_(/*45.24*/Messages("Người liên hệ")),format.raw/*45.49*/("""</th>
                  <th>"""),_display_(/*46.24*/Messages("Chức vụ")),format.raw/*46.43*/("""</th>
                  <th>"""),_display_(/*47.24*/Messages("Số TB")),format.raw/*47.41*/("""</th>
                  <th>"""),_display_(/*48.24*/Messages("Đánh giá CMP")),format.raw/*48.48*/("""</th>
                  <th>"""),_display_(/*49.24*/Messages("Mong muốn")),format.raw/*49.45*/("""</th>
                  <th>"""),_display_(/*50.24*/Messages("Thời gian")),format.raw/*50.45*/("""</th>
                  <th>"""),_display_(/*51.24*/Messages("Thao tác")),format.raw/*51.44*/("""</th>
                </tr>
              </thead>
              <tbody></tbody>
            </table>
            <h5 id="notiNotData" style="text-align: center;"></h5>
          </div>
          <div class="material-datatables row row-cols-auto g-3" style="margin-bottom: 5px; margin-right: 10px;" id="divPagingTable">
            <div class="row">
              <div class="col-md-4">
                <div class="dropdown">
                  <button class="btn dropdown-toggle text-white" type="button" data-bs-toggle="dropdown" aria-expanded="false" id="countPageSize" style="background-color: rgb(0 0 0 / 50%); margin-left: 5px;">15</button>
                  <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="javascript:ApplyFilter(1,15,true)">15</a></li>
                    <li><a class="dropdown-item" href="javascript:ApplyFilter(1,50,true)">50</a></li>
                    <li><a class="dropdown-item" href="javascript:ApplyFilter(1,100,true)">100</a></li>
                    <li><a class="dropdown-item" href="javascript:ApplyFilter(1,200,true)">200</a></li>
                    <li><a class="dropdown-item" href="javascript:ApplyFilter(1,500,true)">500</a></li>
                  </ul>
                </div>
              </div>
              <div class="col-md-8">
                <div class="dataTables_paginate paging_full_numbers" id="pagingTable" style="cursor: pointer; right: 5px; position: absolute;"></div>
              </div>
            </div>

            <input name="page" id="page" value="1" style="display: none">
            <input name="pageSize" id="pageSize" value="15" style="display: none">
            <input name="isResetPage" id="isResetPage" value="false" style="display: none">
          </div>
        </div>

      </div>

      """),_display_(/*85.8*/views/*85.13*/.html.telco.log.survey.LogSurvey_editDel()),format.raw/*85.55*/("""

      """),_display_(/*87.8*/views/*87.13*/.html.telco.Loading()),format.raw/*87.34*/("""

    """),format.raw/*89.5*/("""</div>

    """),_display_(/*91.6*/views/*91.11*/.html.telco.mainJs()),format.raw/*91.31*/("""

    """),format.raw/*93.5*/("""<script>
            var imgDefault = '"""),_display_(/*94.32*/routes/*94.38*/.Assets.versioned("images/market/default.png")),format.raw/*94.84*/("""';
            var roleCmp = '"""),_display_(/*95.29*/User/*95.33*/.CmpRole.getNameByCode(currentUser.getCmpRole)),format.raw/*95.79*/("""';
            console.log(roleCmp);
            $(document).ready(function () """),format.raw/*97.43*/("""{"""),format.raw/*97.44*/("""
              """),format.raw/*98.15*/("""$("#menu-logSurvey").addClass("mm-active");
              $("#menu").metisMenu();
            """),format.raw/*100.13*/("""}"""),format.raw/*100.14*/(""")
    </script>
    <script src=""""),_display_(/*102.19*/routes/*102.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*102.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*103.19*/routes/*103.25*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*103.85*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*105.19*/routes/*105.25*/.Assets.versioned("javascripts/views/telco/log/survey/Survey.js")),format.raw/*105.90*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*106.19*/routes/*106.25*/.Assets.versioned("javascripts/views/telco/log/survey/survey_getName.js")),format.raw/*106.98*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*107.19*/routes/*107.25*/.Assets.versioned("javascripts/views/telco/log/survey/survey_export.js")),format.raw/*107.97*/("""" type="text/javascript"></script>

  </body>
</html>
"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:53 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/log/survey/LogSurvey.scala.html
                  HASH: 018a2ae642b48d4d6da9937974c3ed624e846046
                  MATRIX: 668->1|704->31|1043->65|1156->83|1183->84|1351->226|1391->246|1472->300|1487->306|1544->342|1751->523|1765->528|1811->553|1844->559|1884->572|1899->578|1974->632|2040->671|2055->677|2140->741|2194->858|2226->863|2266->876|2281->882|2351->931|2414->967|2429->973|2525->1048|2589->1085|2604->1091|2741->1206|2807->1245|2822->1251|2897->1305|2987->1369|3001->1374|3056->1408|3089->1415|3103->1420|3160->1456|3193->1462|3290->1532|3304->1537|3366->1578|3403->1588|3712->1870|3748->1885|3804->1914|3841->1930|3897->1959|3936->1977|3992->2006|4038->2031|4094->2060|4134->2079|4190->2108|4228->2125|4284->2154|4329->2178|4385->2207|4427->2228|4483->2257|4525->2278|4581->2307|4622->2327|6454->4133|6468->4138|6531->4180|6566->4189|6580->4194|6622->4215|6655->4221|6694->4234|6708->4239|6749->4259|6782->4265|6849->4305|6864->4311|6931->4357|6989->4388|7002->4392|7069->4438|7176->4517|7205->4518|7248->4533|7371->4627|7401->4628|7463->4662|7479->4668|7560->4727|7641->4780|7657->4786|7739->4846|7821->4900|7837->4906|7924->4971|8005->5024|8021->5030|8116->5103|8197->5156|8213->5162|8307->5234
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|52->20|52->20|52->20|52->20|53->21|53->21|53->21|54->22|54->22|54->22|56->24|56->24|56->24|60->28|60->28|60->28|62->30|62->30|62->30|64->32|67->35|67->35|67->35|69->37|74->42|74->42|75->43|75->43|76->44|76->44|77->45|77->45|78->46|78->46|79->47|79->47|80->48|80->48|81->49|81->49|82->50|82->50|83->51|83->51|117->85|117->85|117->85|119->87|119->87|119->87|121->89|123->91|123->91|123->91|125->93|126->94|126->94|126->94|127->95|127->95|127->95|129->97|129->97|130->98|132->100|132->100|134->102|134->102|134->102|135->103|135->103|135->103|137->105|137->105|137->105|138->106|138->106|138->106|139->107|139->107|139->107
                  -- GENERATED --
              */
          