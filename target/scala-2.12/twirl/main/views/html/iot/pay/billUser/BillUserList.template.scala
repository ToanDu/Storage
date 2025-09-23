
package views.html.iot.pay.billUser

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

object BillUserList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, projectId:String, userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.53*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("Bill User")),format.raw/*9.34*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

  """),format.raw/*17.3*/("""</head>
  <body class="bg-theme">
    """),_display_(/*19.6*/views/*19.11*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*19.54*/("""

    """),_display_(/*21.6*/views/*21.11*/.html.iot.tags.Header(currentUser)),format.raw/*21.45*/("""

    """),format.raw/*23.5*/("""<div class="page-wrapper">
      <div class="page-content">

        <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
          <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; font-weight: normal;">"""),_display_(/*27.154*/Messages("Danh sách hóa đơn")),format.raw/*27.183*/("""</span>
        </div>
        <div class="card mt-3">
          <div class="card-body">
            <div id="tabBillList">

            </div>
          </div>
        </div>

      </div>
    </div>

    """),_display_(/*40.6*/views/*40.11*/.html.iot.pay.billUser.BillUserList_payment()),format.raw/*40.56*/("""
    """),_display_(/*41.6*/views/*41.11*/.html.iot.pay.billUser.BillUserList_detail()),format.raw/*41.55*/("""

    """),_display_(/*43.6*/views/*43.11*/.html.Loading()),format.raw/*43.26*/("""
  """),format.raw/*44.3*/("""</body>

  """),_display_(/*46.4*/views/*46.9*/.html.iot.tags.Main_js()),format.raw/*46.33*/("""

  """),format.raw/*48.3*/("""<script>
    var iconEdit = """"),_display_(/*49.22*/routes/*49.28*/.Assets.versioned("images/icon/edit.png")),format.raw/*49.69*/("""";
    var iconDelete = """"),_display_(/*50.24*/routes/*50.30*/.Assets.versioned("images/icon/delete.png")),format.raw/*50.73*/("""";


          var projectId = '"""),_display_(/*53.29*/projectId),format.raw/*53.38*/("""';
          var userId = '"""),_display_(/*54.26*/userId),format.raw/*54.32*/("""';

          $(document).ready(function () """),format.raw/*56.41*/("""{"""),format.raw/*56.42*/("""
            """),format.raw/*57.13*/("""$("#menu-billUser").addClass("mm-active");

            $("#menu").metisMenu();

          """),format.raw/*61.11*/("""}"""),format.raw/*61.12*/(""")
  </script>
  <script src=""""),_display_(/*63.17*/routes/*63.23*/.Assets.versioned("javascripts/views/pay/billUser/billUserList.js")),format.raw/*63.90*/(""""></script>
  <script src=""""),_display_(/*64.17*/routes/*64.23*/.Assets.versioned("javascripts/views/pay/bill/billList_pay.js")),format.raw/*64.86*/(""""></script>
  <script src=""""),_display_(/*65.17*/routes/*65.23*/.Assets.versioned("javascripts/views/pay/bill/billList_detail.js")),format.raw/*65.89*/(""""></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,projectId:String,userId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,projectId,userId)

  def f:((User,String,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,projectId,userId) => apply(currentUser,projectId,userId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:45 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/pay/billUser/BillUserList.scala.html
                  HASH: 08937adf423cc67d237c1926a02dd269920a7acb
                  MATRIX: 668->1|691->18|1047->52|1193->103|1220->104|1388->246|1429->267|1510->321|1525->327|1582->363|1789->544|1803->549|1849->574|1880->578|1945->617|1959->622|2023->665|2056->672|2070->677|2125->711|2158->717|2495->1026|2546->1055|2779->1262|2793->1267|2859->1312|2891->1318|2905->1323|2970->1367|3003->1374|3017->1379|3053->1394|3083->1397|3121->1409|3134->1414|3179->1438|3210->1442|3267->1472|3282->1478|3344->1519|3397->1545|3412->1551|3476->1594|3536->1627|3566->1636|3621->1664|3648->1670|3720->1714|3749->1715|3790->1728|3909->1819|3938->1820|3995->1850|4010->1856|4098->1923|4153->1951|4168->1957|4252->2020|4307->2048|4322->2054|4409->2120
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|51->19|51->19|51->19|53->21|53->21|53->21|55->23|59->27|59->27|72->40|72->40|72->40|73->41|73->41|73->41|75->43|75->43|75->43|76->44|78->46|78->46|78->46|80->48|81->49|81->49|81->49|82->50|82->50|82->50|85->53|85->53|86->54|86->54|88->56|88->56|89->57|93->61|93->61|95->63|95->63|95->63|96->64|96->64|96->64|97->65|97->65|97->65
                  -- GENERATED --
              */
          