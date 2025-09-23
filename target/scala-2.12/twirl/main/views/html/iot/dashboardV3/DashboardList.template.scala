
package views.html.iot.dashboardV3

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

object DashboardList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("Dashboard List")),format.raw/*9.39*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/group/style.min.css")),format.raw/*17.82*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*18.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("stylesheets/views/group/group.css")),format.raw/*19.78*/("""" rel="stylesheet" />
  </head>
  <body class="bg-theme">
    """),_display_(/*22.6*/views/*22.11*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*22.54*/("""

    """),_display_(/*24.6*/views/*24.11*/.html.iot.tags.Header(currentUser)),format.raw/*24.45*/("""

    """),format.raw/*26.5*/("""<div class="page-wrapper">
      <div class="page-content">

        """),format.raw/*29.45*/("""
          """),format.raw/*30.35*/("""
            """),format.raw/*31.21*/("""
              """),format.raw/*32.23*/("""
                """),format.raw/*33.45*/("""
                  """),format.raw/*34.67*/("""
                  """),format.raw/*35.90*/("""
                  """),format.raw/*36.68*/("""
                  """),format.raw/*37.90*/("""
                  """),format.raw/*38.105*/("""
                """),format.raw/*39.27*/("""
              """),format.raw/*40.24*/("""
            """),format.raw/*41.22*/("""
          """),format.raw/*42.23*/("""
        """),format.raw/*43.19*/("""

        """),format.raw/*45.9*/("""<div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
          <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; font-weight: normal;">"""),_display_(/*46.154*/Messages("Danh sách bảng điều khiển")),format.raw/*46.191*/("""</span>
        </div>
        <div class="card mt-3">
          <div class="card-body" style="border: 1px solid #858687;">
            <div id="listDashboard" class="body-nest mt-3"></div>
          </div>
        </div>

      </div>
    </div>

    """),_display_(/*57.6*/views/*57.11*/.html.iot.dashboardV3.DashboardList_add()),format.raw/*57.52*/("""
    """),_display_(/*58.6*/views/*58.11*/.html.iot.dashboardV3.DashboardList_edit()),format.raw/*58.53*/("""
    """),_display_(/*59.6*/views/*59.11*/.html.iot.dashboardV3.DashboardList_del()),format.raw/*59.52*/("""
    """),_display_(/*60.6*/views/*60.11*/.html.iot.dashboardV3.DashboardList_move()),format.raw/*60.53*/("""

    """),_display_(/*62.6*/views/*62.11*/.html.Loading()),format.raw/*62.26*/("""
  """),format.raw/*63.3*/("""</body>

  """),_display_(/*65.4*/views/*65.9*/.html.iot.tags.Main_js()),format.raw/*65.33*/("""

  """),format.raw/*67.3*/("""<script>
          var projectId = '"""),_display_(/*68.29*/projectId),format.raw/*68.38*/("""';

          var iconEdit = """"),_display_(/*70.28*/routes/*70.34*/.Assets.versioned("images/icon/edit.png")),format.raw/*70.75*/("""";
          var iconDelete = """"),_display_(/*71.30*/routes/*71.36*/.Assets.versioned("images/icon/delete.png")),format.raw/*71.79*/("""";
          var iconInfo = """"),_display_(/*72.28*/routes/*72.34*/.Assets.versioned("images/icon/copy.png")),format.raw/*72.75*/("""";

          $(document).ready(function () """),format.raw/*74.41*/("""{"""),format.raw/*74.42*/("""
            """),format.raw/*75.13*/("""$("#menu-dashboard").addClass("mm-active");

            $("#menu").metisMenu();
          """),format.raw/*78.11*/("""}"""),format.raw/*78.12*/(""")
  </script>

  <script src=""""),_display_(/*81.17*/routes/*81.23*/.Assets.versioned("javascripts/views/group/jstree.js")),format.raw/*81.77*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*83.17*/routes/*83.23*/.Assets.versioned("javascripts/views/dashboardV3/dashboardList.js")),format.raw/*83.90*/(""""></script>

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
                  DATE: Mon Sep 22 16:32:44 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboardV3/DashboardList.scala.html
                  HASH: de1ddd9ec6233243366ee5648cfa1394400afc0c
                  MATRIX: 667->1|690->18|1040->52|1171->88|1198->89|1366->231|1412->257|1493->311|1508->317|1565->353|1772->534|1786->539|1832->564|1865->570|1905->583|1920->589|1999->647|2065->686|2080->692|2155->746|2221->785|2236->791|2311->845|2400->908|2414->913|2478->956|2511->963|2525->968|2580->1002|2613->1008|2710->1113|2749->1148|2790->1169|2833->1192|2878->1237|2925->1304|2972->1394|3019->1462|3066->1552|3114->1657|3159->1684|3202->1708|3243->1730|3282->1753|3319->1772|3356->1782|3624->2022|3683->2059|3962->2312|3976->2317|4038->2358|4070->2364|4084->2369|4147->2411|4179->2417|4193->2422|4255->2463|4287->2469|4301->2474|4364->2516|4397->2523|4411->2528|4447->2543|4477->2546|4515->2558|4528->2563|4573->2587|4604->2591|4668->2628|4698->2637|4756->2668|4771->2674|4833->2715|4892->2747|4907->2753|4971->2796|5028->2826|5043->2832|5105->2873|5177->2917|5206->2918|5247->2931|5366->3022|5395->3023|5453->3054|5468->3060|5543->3114|5622->3166|5637->3172|5725->3239
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|51->19|51->19|54->22|54->22|54->22|56->24|56->24|56->24|58->26|61->29|62->30|63->31|64->32|65->33|66->34|67->35|68->36|69->37|70->38|71->39|72->40|73->41|74->42|75->43|77->45|78->46|78->46|89->57|89->57|89->57|90->58|90->58|90->58|91->59|91->59|91->59|92->60|92->60|92->60|94->62|94->62|94->62|95->63|97->65|97->65|97->65|99->67|100->68|100->68|102->70|102->70|102->70|103->71|103->71|103->71|104->72|104->72|104->72|106->74|106->74|107->75|110->78|110->78|113->81|113->81|113->81|115->83|115->83|115->83
                  -- GENERATED --
              */
          