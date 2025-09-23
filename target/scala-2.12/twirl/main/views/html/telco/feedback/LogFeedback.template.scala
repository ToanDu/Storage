
package views.html.telco.feedback

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

object LogFeedback extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("Log Feedback")),format.raw/*9.37*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*17.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("assets/plugins/input-tags/css/tagsinput.css")),format.raw/*18.88*/("""" rel="stylesheet" />
    """),format.raw/*19.96*/("""
    """),format.raw/*20.5*/("""<link href='"""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*20.73*/("""' type='text/css'>
    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*21.139*/("""" rel="stylesheet" >

    <link href=""""),_display_(/*23.18*/routes/*23.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*23.78*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*27.6*/views/*27.11*/.html.telco.role.Menu(currentUser)),format.raw/*27.45*/("""

    """),_display_(/*29.6*/views/*29.11*/.html.telco.role.Header(currentUser)),format.raw/*29.47*/("""

    """),format.raw/*31.5*/("""<div class="page-wrapper">
      <div class="page-content">

        """),_display_(/*34.10*/views/*34.15*/.html.telco.feedback.LogFeedback_search()),format.raw/*34.56*/("""

        """),format.raw/*36.9*/("""<div class="card">
          <div class="table-responsive mb-3" style="border-radius: 8px;">
            <table class="table table-striped" id="listLogsTable" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th>"""),_display_(/*41.24*/Messages("STT")),format.raw/*41.39*/("""</th>
                  <th>"""),_display_(/*42.24*/Messages("Email")),format.raw/*42.41*/("""</th>
                  <th>"""),_display_(/*43.24*/Messages("Họ tên")),format.raw/*43.42*/("""</th>
                  <th>"""),_display_(/*44.24*/Messages("SĐT")),format.raw/*44.39*/("""</th>
                  <th>"""),_display_(/*45.24*/Messages("Tên DN")),format.raw/*45.42*/("""</th>
                  <th>"""),_display_(/*46.24*/Messages("Nội dung")),format.raw/*46.44*/("""</th>
                  <th>"""),_display_(/*47.24*/Messages("Thời gian")),format.raw/*47.45*/("""</th>
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

      """),_display_(/*81.8*/views/*81.13*/.html.telco.Loading()),format.raw/*81.34*/("""

    """),format.raw/*83.5*/("""</div>

    """),_display_(/*85.6*/views/*85.11*/.html.telco.mainJs()),format.raw/*85.31*/("""

    """),format.raw/*87.5*/("""<script>
            var imgDefault = '"""),_display_(/*88.32*/routes/*88.38*/.Assets.versioned("images/market/default.png")),format.raw/*88.84*/("""';
            var roleCmp = '"""),_display_(/*89.29*/User/*89.33*/.CmpRole.getNameByCode(currentUser.getCmpRole)),format.raw/*89.79*/("""';
            console.log(roleCmp);
            $(document).ready(function () """),format.raw/*91.43*/("""{"""),format.raw/*91.44*/("""
              """),format.raw/*92.15*/("""$("#menu-logFeedback").addClass("mm-active");
              $("#menu").metisMenu();

              $('.datetimepicker').bootstrapMaterialDatePicker("""),format.raw/*95.64*/("""{"""),format.raw/*95.65*/("""
                """),format.raw/*96.17*/("""format: 'DD/MM/YYYY',
                time: false
              """),format.raw/*98.15*/("""}"""),format.raw/*98.16*/(""");
            """),format.raw/*99.13*/("""}"""),format.raw/*99.14*/(""")
    </script>
    <script src=""""),_display_(/*101.19*/routes/*101.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*101.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*102.19*/routes/*102.25*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*102.85*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*104.19*/routes/*104.25*/.Assets.versioned("javascripts/views/telco/feedback/LogFeedback.js")),format.raw/*104.93*/("""" type="text/javascript"></script>

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
                  DATE: Mon Sep 22 16:32:52 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/feedback/LogFeedback.scala.html
                  HASH: e1b6069bdf20b5dafcf944be5a00f1dbeade89bd
                  MATRIX: 666->1|702->31|1043->65|1156->83|1183->84|1351->226|1395->250|1476->304|1491->310|1548->346|1755->527|1769->532|1815->557|1848->563|1888->576|1903->582|1978->636|2044->675|2059->681|2144->745|2198->862|2230->867|2270->880|2285->886|2355->935|2418->971|2433->977|2570->1092|2636->1131|2651->1137|2726->1191|2816->1255|2830->1260|2885->1294|2918->1301|2932->1306|2989->1342|3022->1348|3119->1418|3133->1423|3195->1464|3232->1474|3541->1756|3577->1771|3633->1800|3671->1817|3727->1846|3766->1864|3822->1893|3858->1908|3914->1937|3953->1955|4009->1984|4050->2004|4106->2033|4148->2054|5980->3860|5994->3865|6036->3886|6069->3892|6108->3905|6122->3910|6163->3930|6196->3936|6263->3976|6278->3982|6345->4028|6403->4059|6416->4063|6483->4109|6590->4188|6619->4189|6662->4204|6838->4352|6867->4353|6912->4370|7004->4434|7033->4435|7076->4450|7105->4451|7167->4485|7183->4491|7264->4550|7345->4603|7361->4609|7443->4669|7525->4723|7541->4729|7631->4797
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|52->20|52->20|52->20|52->20|53->21|53->21|53->21|55->23|55->23|55->23|59->27|59->27|59->27|61->29|61->29|61->29|63->31|66->34|66->34|66->34|68->36|73->41|73->41|74->42|74->42|75->43|75->43|76->44|76->44|77->45|77->45|78->46|78->46|79->47|79->47|113->81|113->81|113->81|115->83|117->85|117->85|117->85|119->87|120->88|120->88|120->88|121->89|121->89|121->89|123->91|123->91|124->92|127->95|127->95|128->96|130->98|130->98|131->99|131->99|133->101|133->101|133->101|134->102|134->102|134->102|136->104|136->104|136->104
                  -- GENERATED --
              */
          