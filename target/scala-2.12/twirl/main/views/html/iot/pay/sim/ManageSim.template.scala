
package views.html.iot.pay.sim

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

object ManageSim extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, projectId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.38*/("""
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
      """),_display_(/*19.8*/views/*19.13*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*19.56*/("""

      """),_display_(/*21.8*/views/*21.13*/.html.iot.tags.Header(currentUser)),format.raw/*21.47*/("""

      """),format.raw/*23.7*/("""<div class="page-wrapper">
          <div class="page-content">

              <div class="card">
                  <div class="card-header card-header-primary card-header-icon">
                      <div class="toolbar" style="float: left;">
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
                  <input name="pageSize" id="pageSize" value="20" style="display: none">
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
            var projectId = '"""),_display_(/*72.31*/projectId),format.raw/*72.40*/("""';

          $(document).ready(function () """),format.raw/*74.41*/("""{"""),format.raw/*74.42*/("""
            """),format.raw/*75.13*/("""$("#menu-sim").addClass("mm-active");
            $("#menu").metisMenu();
          """),format.raw/*77.11*/("""}"""),format.raw/*77.12*/(""");

          var iconDefault = """"),_display_(/*79.31*/routes/*79.37*/.Assets.versioned("images/login/logo.svg")),format.raw/*79.79*/("""";
  </script>
  <script src=""""),_display_(/*81.17*/routes/*81.23*/.Assets.versioned("javascripts/views/admin/adminOverview/multiselect.js")),format.raw/*81.96*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*82.17*/routes/*82.23*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*82.82*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*84.17*/routes/*84.23*/.Assets.versioned("javascripts/views/admin/manageSim/ManageSim.js")),format.raw/*84.90*/("""" type="text/javascript"></script>


</html>
"""))
      }
    }
  }

  def render(currentUser:User,projectId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,projectId)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,projectId) => apply(currentUser,projectId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:45 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/pay/sim/ManageSim.scala.html
                  HASH: 46c7b6f7c2837cd8b16f3723d2c88dc8dba026ee
                  MATRIX: 663->1|686->18|1032->52|1163->88|1190->89|1358->231|1400->253|1481->307|1496->313|1553->349|1760->530|1774->535|1820->560|1851->564|1918->605|1932->610|1996->653|2031->662|2045->667|2100->701|2135->709|2437->984|2483->1009|2879->1378|2915->1393|2987->1438|3025->1455|3097->1500|3134->1516|3206->1561|3247->1581|3319->1626|3357->1643|3429->1688|3473->1711|3545->1756|3589->1779|3661->1824|3706->1848|3778->1893|3819->1913|4613->2681|4627->2686|4663->2701|4694->2705|4732->2717|4745->2722|4786->2742|4819->2748|4885->2787|4915->2796|4987->2840|5016->2841|5057->2854|5169->2938|5198->2939|5259->2973|5274->2979|5337->3021|5395->3052|5410->3058|5504->3131|5582->3182|5597->3188|5677->3247|5756->3299|5771->3305|5859->3372
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|51->19|51->19|51->19|53->21|53->21|53->21|55->23|61->29|61->29|69->37|69->37|70->38|70->38|71->39|71->39|72->40|72->40|73->41|73->41|74->42|74->42|75->43|75->43|76->44|76->44|77->45|77->45|97->65|97->65|97->65|99->67|101->69|101->69|101->69|103->71|104->72|104->72|106->74|106->74|107->75|109->77|109->77|111->79|111->79|111->79|113->81|113->81|113->81|114->82|114->82|114->82|116->84|116->84|116->84
                  -- GENERATED --
              */
          