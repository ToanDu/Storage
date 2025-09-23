
package views.html.iot.pay.bill

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

object BillList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("Manage Bill")),format.raw/*9.36*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<style>
            .form-control:disabled, .form-control[readonly] """),format.raw/*18.61*/("""{"""),format.raw/*18.62*/("""
              """),format.raw/*19.15*/("""background-color: #aaa;
              opacity: 1;
            """),format.raw/*21.13*/("""}"""),format.raw/*21.14*/("""
            """),format.raw/*22.13*/(""".form-control """),format.raw/*22.27*/("""{"""),format.raw/*22.28*/("""
              """),format.raw/*23.15*/("""background-color: #aaa;
              color: #dee2e6;
            """),format.raw/*25.13*/("""}"""),format.raw/*25.14*/("""
    """),format.raw/*26.5*/("""</style>

  </head>
  <body class="bg-theme">
    """),_display_(/*30.6*/views/*30.11*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*30.54*/("""

    """),_display_(/*32.6*/views/*32.11*/.html.iot.tags.Header(currentUser)),format.raw/*32.45*/("""

    """),format.raw/*34.5*/("""<div class="page-wrapper">
      <div class="page-content">

        <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
          <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; font-weight: normal;">"""),_display_(/*38.154*/Messages("Quản lý hóa đơn")),format.raw/*38.181*/("""</span>
        </div>
        <div class="card mt-3">
          <div class="card-body">
            <div id="tabBillList">

            </div>
          </div>
        </div>

      </div>
    </div>

    """),_display_(/*51.6*/views/*51.11*/.html.iot.pay.bill.BillList_payment()),format.raw/*51.48*/("""
    """),_display_(/*52.6*/views/*52.11*/.html.iot.pay.bill.BillList_detail()),format.raw/*52.47*/("""

    """),_display_(/*54.6*/views/*54.11*/.html.Loading()),format.raw/*54.26*/("""
  """),format.raw/*55.3*/("""</body>

  """),_display_(/*57.4*/views/*57.9*/.html.iot.tags.Main_js()),format.raw/*57.33*/("""

  """),format.raw/*59.3*/("""<script>
    var iconEdit = """"),_display_(/*60.22*/routes/*60.28*/.Assets.versioned("images/icon/edit.png")),format.raw/*60.69*/("""";
    var iconDelete = """"),_display_(/*61.24*/routes/*61.30*/.Assets.versioned("images/icon/delete.png")),format.raw/*61.73*/("""";

          var projectId = '"""),_display_(/*63.29*/projectId),format.raw/*63.38*/("""';

          $(document).ready(function () """),format.raw/*65.41*/("""{"""),format.raw/*65.42*/("""
            """),format.raw/*66.13*/("""$("#menu-bill").addClass("mm-active");

            $("#menu").metisMenu();

          """),format.raw/*70.11*/("""}"""),format.raw/*70.12*/(""")
  </script>
  <script src=""""),_display_(/*72.17*/routes/*72.23*/.Assets.versioned("javascripts/views/pay/bill/billList.js")),format.raw/*72.82*/(""""></script>
  <script src=""""),_display_(/*73.17*/routes/*73.23*/.Assets.versioned("javascripts/views/pay/bill/billList_pay.js")),format.raw/*73.86*/(""""></script>
  <script src=""""),_display_(/*74.17*/routes/*74.23*/.Assets.versioned("javascripts/views/pay/bill/billList_detail.js")),format.raw/*74.89*/(""""></script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/pay/bill/BillList.scala.html
                  HASH: d9e73f0f1f71bb2334eabe9ec9d6352a9e29677b
                  MATRIX: 664->1|687->18|1032->52|1163->88|1190->89|1358->231|1401->254|1482->308|1497->314|1554->350|1761->531|1775->536|1821->561|1854->567|1950->635|1979->636|2022->651|2112->713|2141->714|2182->727|2224->741|2253->742|2296->757|2390->823|2419->824|2451->829|2528->880|2542->885|2606->928|2639->935|2653->940|2708->974|2741->980|3078->1289|3127->1316|3360->1523|3374->1528|3432->1565|3464->1571|3478->1576|3535->1612|3568->1619|3582->1624|3618->1639|3648->1642|3686->1654|3699->1659|3744->1683|3775->1687|3832->1717|3847->1723|3909->1764|3962->1790|3977->1796|4041->1839|4100->1871|4130->1880|4202->1924|4231->1925|4272->1938|4387->2025|4416->2026|4473->2056|4488->2062|4568->2121|4623->2149|4638->2155|4722->2218|4777->2246|4792->2252|4879->2318
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|50->18|50->18|51->19|53->21|53->21|54->22|54->22|54->22|55->23|57->25|57->25|58->26|62->30|62->30|62->30|64->32|64->32|64->32|66->34|70->38|70->38|83->51|83->51|83->51|84->52|84->52|84->52|86->54|86->54|86->54|87->55|89->57|89->57|89->57|91->59|92->60|92->60|92->60|93->61|93->61|93->61|95->63|95->63|97->65|97->65|98->66|102->70|102->70|104->72|104->72|104->72|105->73|105->73|105->73|106->74|106->74|106->74
                  -- GENERATED --
              */
          