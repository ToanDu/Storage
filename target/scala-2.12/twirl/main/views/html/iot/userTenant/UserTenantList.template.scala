
package views.html.iot.userTenant

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

object UserTenantList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("User Tenant")),format.raw/*9.36*/("""</title>
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
    """),_display_(/*28.6*/views/*28.11*/.html.iot.userTenant.Menu(currentUser)),format.raw/*28.49*/("""

    """),_display_(/*30.6*/views/*30.11*/.html.iot.userTenant.Header(currentUser)),format.raw/*30.51*/("""

    """),format.raw/*32.5*/("""<div class="page-wrapper">
      <div class="page-content">

        """),_display_(/*35.10*/views/*35.15*/.html.iot.userTenant.UserTenantList_search()),format.raw/*35.59*/("""

        """),format.raw/*37.9*/("""<div class="card">
          <div class="table-responsive mb-3" style="border-radius: 8px;">
            <table class="table table-striped" id="listDatasTable" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th>"""),_display_(/*42.24*/Messages("STT")),format.raw/*42.39*/("""</th>
                  <th>"""),_display_(/*43.24*/Messages("Email")),format.raw/*43.41*/("""</th>
                  <th>"""),_display_(/*44.24*/Messages("Tên")),format.raw/*44.39*/("""</th>
                  <th>"""),_display_(/*45.24*/Messages("Số điện thoại")),format.raw/*45.49*/("""</th>
                  <th>"""),_display_(/*46.24*/Messages("Quyền")),format.raw/*46.41*/("""</th>
                  <th style="text-align: center">"""),_display_(/*47.51*/Messages("Chi tiết")),format.raw/*47.71*/("""</th>
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

      """),_display_(/*81.8*/views/*81.13*/.html.iot.userTenant.UserTenantList_add()),format.raw/*81.54*/("""
      """),_display_(/*82.8*/views/*82.13*/.html.iot.userTenant.UserTenantList_del()),format.raw/*82.54*/("""
      """),_display_(/*83.8*/views/*83.13*/.html.iot.userTenant.UserTenantList_edit()),format.raw/*83.55*/("""
      """),_display_(/*84.8*/views/*84.13*/.html.iot.userTenant.UserTenantList_edit_updateRole()),format.raw/*84.66*/("""
      """),_display_(/*85.8*/views/*85.13*/.html.iot.userTenant.UserTenantList_edit_delPermis()),format.raw/*85.65*/("""
      """),_display_(/*86.8*/views/*86.13*/.html.iot.userTenant.UserTenantList_edit_addPermis()),format.raw/*86.65*/("""

      """),_display_(/*88.8*/views/*88.13*/.html.telco.Loading()),format.raw/*88.34*/("""

    """),format.raw/*90.5*/("""</div>

    """),_display_(/*92.6*/views/*92.11*/.html.telco.mainJs()),format.raw/*92.31*/("""

    """),format.raw/*94.5*/("""<script>
            var imgDefault = '"""),_display_(/*95.32*/routes/*95.38*/.Assets.versioned("images/market/default.png")),format.raw/*95.84*/("""';

            $(document).ready(function () """),format.raw/*97.43*/("""{"""),format.raw/*97.44*/("""
              """),format.raw/*98.15*/("""$("#menu-userTenantList").addClass("mm-active");
              $("#menu").metisMenu();
            """),format.raw/*100.13*/("""}"""),format.raw/*100.14*/(""")
    </script>
    <script src=""""),_display_(/*102.19*/routes/*102.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*102.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*103.19*/routes/*103.25*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*103.85*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*105.19*/routes/*105.25*/.Assets.versioned("javascripts/views/userTenant/UserTenant.js")),format.raw/*105.88*/("""" type="text/javascript"></script>

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
                  DATE: Mon Sep 22 16:32:46 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/userTenant/UserTenantList.scala.html
                  HASH: d0a753e76d4f99b53136307d71fc4c613dfca123
                  MATRIX: 666->1|702->31|1046->65|1159->83|1186->84|1354->226|1397->249|1478->303|1493->309|1550->345|1757->526|1771->531|1817->556|1850->562|1890->575|1905->581|1980->635|2046->674|2061->680|2146->744|2200->861|2232->866|2272->879|2287->885|2357->934|2420->970|2435->976|2531->1051|2595->1088|2610->1094|2747->1209|2813->1248|2828->1254|2903->1308|2993->1372|3007->1377|3066->1415|3099->1422|3113->1427|3174->1467|3207->1473|3304->1543|3318->1548|3383->1592|3420->1602|3730->1885|3766->1900|3822->1929|3860->1946|3916->1975|3952->1990|4008->2019|4054->2044|4110->2073|4148->2090|4231->2146|4272->2166|6104->3972|6118->3977|6180->4018|6214->4026|6228->4031|6290->4072|6324->4080|6338->4085|6401->4127|6435->4135|6449->4140|6523->4193|6557->4201|6571->4206|6644->4258|6678->4266|6692->4271|6765->4323|6800->4332|6814->4337|6856->4358|6889->4364|6928->4377|6942->4382|6983->4402|7016->4408|7083->4448|7098->4454|7165->4500|7239->4546|7268->4547|7311->4562|7439->4661|7469->4662|7531->4696|7547->4702|7628->4761|7709->4814|7725->4820|7807->4880|7889->4934|7905->4940|7990->5003
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|52->20|52->20|52->20|52->20|53->21|53->21|53->21|54->22|54->22|54->22|56->24|56->24|56->24|60->28|60->28|60->28|62->30|62->30|62->30|64->32|67->35|67->35|67->35|69->37|74->42|74->42|75->43|75->43|76->44|76->44|77->45|77->45|78->46|78->46|79->47|79->47|113->81|113->81|113->81|114->82|114->82|114->82|115->83|115->83|115->83|116->84|116->84|116->84|117->85|117->85|117->85|118->86|118->86|118->86|120->88|120->88|120->88|122->90|124->92|124->92|124->92|126->94|127->95|127->95|127->95|129->97|129->97|130->98|132->100|132->100|134->102|134->102|134->102|135->103|135->103|135->103|137->105|137->105|137->105
                  -- GENERATED --
              */
          