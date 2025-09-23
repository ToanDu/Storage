
package views.html.telco.log

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

object LogCmp extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("Log CMP")),format.raw/*9.32*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*17.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("assets/plugins/input-tags/css/tagsinput.css")),format.raw/*18.88*/("""" rel="stylesheet" />
    <link href='"""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*19.73*/("""' type='text/css'>
    <link href=""""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*20.99*/("""" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" >
    <link href=""""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*22.139*/("""" rel="stylesheet" >

    <link href=""""),_display_(/*24.18*/routes/*24.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*24.78*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*28.6*/views/*28.11*/.html.telco.role.Menu(currentUser)),format.raw/*28.45*/("""

    """),_display_(/*30.6*/views/*30.11*/.html.telco.role.Header(currentUser)),format.raw/*30.47*/("""

    """),format.raw/*32.5*/("""<div class="page-wrapper">
      <div class="page-content">

        """),_display_(/*35.10*/views/*35.15*/.html.telco.log.LogCmp_search()),format.raw/*35.46*/("""

        """),format.raw/*37.9*/("""<div class="card">
          <div class="table-responsive mb-3" style="border-radius: 8px;">
            <table class="table table-striped" id="listLogsTable" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th>"""),_display_(/*42.24*/Messages("STT")),format.raw/*42.39*/("""</th>
                  <th>"""),_display_(/*43.24*/Messages("Username")),format.raw/*43.44*/("""</th>
                  <th>"""),_display_(/*44.24*/Messages("Hàm")),format.raw/*44.39*/("""</th>
                  <th>"""),_display_(/*45.24*/Messages("Tác vụ")),format.raw/*45.42*/("""</th>
                  <th>"""),_display_(/*46.24*/Messages("Url")),format.raw/*46.39*/("""</th>
                  <th>"""),_display_(/*47.24*/Messages("Body")),format.raw/*47.40*/("""</th>
                  <th>"""),_display_(/*48.24*/Messages("Status")),format.raw/*48.42*/("""</th>
                  <th>"""),_display_(/*49.24*/Messages("Kết quả")),format.raw/*49.43*/("""</th>
                  <th>"""),_display_(/*50.24*/Messages("Thời gian")),format.raw/*50.45*/("""</th>
                  <th>"""),_display_(/*51.24*/Messages("Chi tiết")),format.raw/*51.44*/("""</th>
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

      """),_display_(/*85.8*/views/*85.13*/.html.telco.log.LogCmp_respon()),format.raw/*85.44*/("""

      """),_display_(/*87.8*/views/*87.13*/.html.telco.Loading()),format.raw/*87.34*/("""

    """),format.raw/*89.5*/("""</div>

    """),_display_(/*91.6*/views/*91.11*/.html.telco.mainJs()),format.raw/*91.31*/("""

    """),format.raw/*93.5*/("""<script>
            var imgDefault = '"""),_display_(/*94.32*/routes/*94.38*/.Assets.versioned("images/market/default.png")),format.raw/*94.84*/("""';
            var roleCmp = '"""),_display_(/*95.29*/User/*95.33*/.CmpRole.getNameByCode(currentUser.getCmpRole)),format.raw/*95.79*/("""';
            console.log(roleCmp);
            $(document).ready(function () """),format.raw/*97.43*/("""{"""),format.raw/*97.44*/("""
              """),format.raw/*98.15*/("""$("#menu-logCmp").addClass("mm-active");
              $("#menu").metisMenu();

              $('.datetimepicker').bootstrapMaterialDatePicker("""),format.raw/*101.64*/("""{"""),format.raw/*101.65*/("""
                """),format.raw/*102.17*/("""format: 'DD/MM/YYYY',
                time: false
              """),format.raw/*104.15*/("""}"""),format.raw/*104.16*/(""");
            """),format.raw/*105.13*/("""}"""),format.raw/*105.14*/(""")
    </script>
    <script src=""""),_display_(/*107.19*/routes/*107.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*107.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*108.19*/routes/*108.25*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*108.85*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*110.19*/routes/*110.25*/.Assets.versioned("javascripts/views/telco/log/logCmp.js")),format.raw/*110.83*/("""" type="text/javascript"></script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/log/LogCmp.scala.html
                  HASH: 26fa50819e8c736e659e0a3627a12cb63debea44
                  MATRIX: 661->1|697->31|1033->65|1146->83|1173->84|1341->226|1380->245|1461->299|1476->305|1533->341|1740->522|1754->527|1800->552|1833->558|1873->571|1888->577|1963->631|2029->670|2044->676|2129->740|2195->779|2210->785|2280->834|2343->870|2358->876|2454->951|2610->1080|2625->1086|2762->1201|2828->1240|2843->1246|2918->1300|3008->1364|3022->1369|3077->1403|3110->1410|3124->1415|3181->1451|3214->1457|3311->1527|3325->1532|3377->1563|3414->1573|3723->1855|3759->1870|3815->1899|3856->1919|3912->1948|3948->1963|4004->1992|4043->2010|4099->2039|4135->2054|4191->2083|4228->2099|4284->2128|4323->2146|4379->2175|4419->2194|4475->2223|4517->2244|4573->2273|4614->2293|6446->4099|6460->4104|6512->4135|6547->4144|6561->4149|6603->4170|6636->4176|6675->4189|6689->4194|6730->4214|6763->4220|6830->4260|6845->4266|6912->4312|6970->4343|6983->4347|7050->4393|7157->4472|7186->4473|7229->4488|7401->4631|7431->4632|7477->4649|7570->4713|7600->4714|7644->4729|7674->4730|7736->4764|7752->4770|7833->4829|7914->4882|7930->4888|8012->4948|8094->5002|8110->5008|8190->5066
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|51->19|51->19|52->20|52->20|52->20|54->22|54->22|54->22|56->24|56->24|56->24|60->28|60->28|60->28|62->30|62->30|62->30|64->32|67->35|67->35|67->35|69->37|74->42|74->42|75->43|75->43|76->44|76->44|77->45|77->45|78->46|78->46|79->47|79->47|80->48|80->48|81->49|81->49|82->50|82->50|83->51|83->51|117->85|117->85|117->85|119->87|119->87|119->87|121->89|123->91|123->91|123->91|125->93|126->94|126->94|126->94|127->95|127->95|127->95|129->97|129->97|130->98|133->101|133->101|134->102|136->104|136->104|137->105|137->105|139->107|139->107|139->107|140->108|140->108|140->108|142->110|142->110|142->110
                  -- GENERATED --
              */
          