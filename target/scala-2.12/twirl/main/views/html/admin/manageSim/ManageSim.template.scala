
package views.html.admin.manageSim

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
/*1.2*/import helper._
/*2.2*/import vn.m2m.common.models.User

object ManageSim extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("Manage Sim")),format.raw/*9.35*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

  """),format.raw/*17.3*/("""</head>
  <body class="bg-theme">
    """),_display_(/*19.6*/views/*19.11*/.html.admin.navbar()),format.raw/*19.31*/("""

    """),_display_(/*21.6*/views/*21.11*/.html.admin.header(currentUser)),format.raw/*21.42*/("""

      """),format.raw/*23.7*/("""<div class="page-wrapper">
          <div class="page-content">

              <div class="card">
                  <div class="card-header card-header-primary card-header-icon">
                      <div class="toolbar" style="float: right">
                          <sp>"""),_display_(/*29.32*/Messages("DANH SÁCH SIM")),format.raw/*29.57*/("""</sp>
                      </div>
                  </div>

                  <div class="card-body">
                      <div class="table-responsive">
                          <table id="listSimTable" class="table align-middle mb-0 table-responsive table-striped" style='width: 100%;'>
                              <thead>
                                  <th>"""),_display_(/*37.40*/Messages("STT")),format.raw/*37.55*/("""</th>
                                  <th>"""),_display_(/*38.40*/Messages("SimNB")),format.raw/*38.57*/("""</th>
                                  <th>"""),_display_(/*39.40*/Messages("IMSI")),format.raw/*39.56*/("""</th>
                                  <th>"""),_display_(/*40.40*/Messages("Gói cước")),format.raw/*40.60*/("""</th>
                                  <th>"""),_display_(/*41.40*/Messages("Số dư")),format.raw/*41.57*/("""</th>
                                  <th>"""),_display_(/*42.40*/Messages("TT thuê bao")),format.raw/*42.63*/("""</th>
                                  <th>"""),_display_(/*43.40*/Messages("TT chặn cắt")),format.raw/*43.63*/("""</th>
                                  <th>"""),_display_(/*44.40*/Messages("Ngày hết hạn")),format.raw/*44.64*/("""</th>
                                  <th>"""),_display_(/*45.40*/Messages("Thao tác")),format.raw/*45.60*/("""</th>
                              </thead>
                              <tbody>

                              </tbody>
                          </table>
                      </div>
                  </div>
              </div>

              <div class="material-datatables mt-3 mb-3">
                  <input name="page" id="page" value="1" style="display: none">
                  <input name="pageSize" id="pageSize" value="100" style="display: none">
                  <input name="isResetPage" id="isResetPage" value="false" style="display: none">
                  <div class="dataTables_paginate paging_full_numbers" id="pagingTable" style="cursor: pointer;"></div>
              </div>

          </div>
      </div>
    <!--  END OF PAPER WRAP -->
    """),_display_(/*65.6*/views/*65.11*/.html.Loading()),format.raw/*65.26*/("""

  """),format.raw/*67.3*/("""</body>

  """),_display_(/*69.4*/views/*69.9*/.html.admin.mainJs()),format.raw/*69.29*/("""

    """),format.raw/*71.5*/("""<script>
          $(document).ready(function () """),format.raw/*72.41*/("""{"""),format.raw/*72.42*/("""
            """),format.raw/*73.13*/("""$("#menu-adminManageSim").addClass("mm-active");
            $("#menu").metisMenu();
          """),format.raw/*75.11*/("""}"""),format.raw/*75.12*/(""");

          var iconDefault = """"),_display_(/*77.31*/routes/*77.37*/.Assets.versioned("images/login/logo.svg")),format.raw/*77.79*/("""";
  </script>
  <script src=""""),_display_(/*79.17*/routes/*79.23*/.Assets.versioned("javascripts/views/admin/adminOverview/multiselect.js")),format.raw/*79.96*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*80.17*/routes/*80.23*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*80.82*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*82.17*/routes/*82.23*/.Assets.versioned("javascripts/views/admin/manageSim/ManageSim.js")),format.raw/*82.90*/("""" type="text/javascript"></script>


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
                  DATE: Mon Sep 22 16:32:40 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/admin/manageSim/ManageSim.scala.html
                  HASH: 764462b77e8c67b4da9267eb6721942ec408018b
                  MATRIX: 667->1|690->18|1029->52|1142->70|1169->71|1337->213|1379->235|1460->289|1475->295|1532->331|1739->512|1753->517|1799->542|1830->546|1895->585|1909->590|1950->610|1983->617|1997->622|2049->653|2084->661|2386->936|2432->961|2828->1330|2864->1345|2936->1390|2974->1407|3046->1452|3083->1468|3155->1513|3196->1533|3268->1578|3306->1595|3378->1640|3422->1663|3494->1708|3538->1731|3610->1776|3655->1800|3727->1845|3768->1865|4563->2634|4577->2639|4613->2654|4644->2658|4682->2670|4695->2675|4736->2695|4769->2701|4846->2750|4875->2751|4916->2764|5039->2859|5068->2860|5129->2894|5144->2900|5207->2942|5265->2973|5280->2979|5374->3052|5452->3103|5467->3109|5547->3168|5626->3220|5641->3226|5729->3293
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|51->19|51->19|51->19|53->21|53->21|53->21|55->23|61->29|61->29|69->37|69->37|70->38|70->38|71->39|71->39|72->40|72->40|73->41|73->41|74->42|74->42|75->43|75->43|76->44|76->44|77->45|77->45|97->65|97->65|97->65|99->67|101->69|101->69|101->69|103->71|104->72|104->72|105->73|107->75|107->75|109->77|109->77|109->77|111->79|111->79|111->79|112->80|112->80|112->80|114->82|114->82|114->82
                  -- GENERATED --
              */
          