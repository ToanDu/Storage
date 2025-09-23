
package views.html.admin.templateDevice

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

object TemplateDeviceList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("Template Device")),format.raw/*9.40*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

  """),format.raw/*17.3*/("""</head>
  <body class="bg-theme">
    """),_display_(/*19.6*/views/*19.11*/.html.admin.navbar()),format.raw/*19.31*/("""

    """),_display_(/*21.6*/views/*21.11*/.html.admin.header(currentUser)),format.raw/*21.42*/("""

    """),format.raw/*23.5*/("""<div class="page-wrapper">
      <div class="page-content">

        <div class="card ">
          <div class="card-header card-header-primary card-header-icon">
            <div class="toolbar" style="float: right">
              <button class="btn btn-success px-5 radius-30" onclick="" data-bs-toggle="modal" data-bs-target="#addConfirmModal" >
                <i class="bx bx-plus" aria-hidden="true"></i> """),_display_(/*30.64*/Messages("Tạo mới")),format.raw/*30.83*/("""
              """),format.raw/*31.15*/("""</button>
            </div>
          </div>

          <div class="card-body">
            <div class="table-responsive" id="listTemplateDeviceDiv">

              <table id="dataTables" class="table table-bordered">
                <thead class="cf">
                  <th>"""),_display_(/*40.24*/Messages("STT")),format.raw/*40.39*/("""</th>
                  <th>"""),_display_(/*41.24*/Messages("Business Type")),format.raw/*41.49*/("""</th>
                  <th>"""),_display_(/*42.24*/Messages("Device Type")),format.raw/*42.47*/("""</th>
                  <th>"""),_display_(/*43.24*/Messages("Device Name")),format.raw/*43.47*/("""</th>
                  <th>"""),_display_(/*44.24*/Messages("Url Image")),format.raw/*44.45*/("""</th>
                  <th>"""),_display_(/*45.24*/Messages("Attributes")),format.raw/*45.46*/("""</th>
                  <th>"""),_display_(/*46.24*/Messages("Action")),format.raw/*46.42*/("""</th>
                </thead>
                <tbody align="left">

                </tbody>
              </table>

            </div>
          </div>
        </div>
      </div>

      """),_display_(/*58.8*/views/*58.13*/.html.admin.templateDevice.TemplateDeviceList_add()),format.raw/*58.64*/("""
      """),_display_(/*59.8*/views/*59.13*/.html.admin.templateDevice.TemplateDeviceList_edit()),format.raw/*59.65*/("""
      """),_display_(/*60.8*/views/*60.13*/.html.admin.templateDevice.TemplateDeviceList_del()),format.raw/*60.64*/("""

    """),format.raw/*62.5*/("""</div>
      <!--  END OF PAPER WRAP -->
    """),_display_(/*64.6*/views/*64.11*/.html.Loading()),format.raw/*64.26*/("""

  """),format.raw/*66.3*/("""</body>

  """),_display_(/*68.4*/views/*68.9*/.html.admin.mainJs()),format.raw/*68.29*/("""

  """),format.raw/*70.3*/("""<script>
          $(document).ready(function () """),format.raw/*71.41*/("""{"""),format.raw/*71.42*/("""
            """),format.raw/*72.13*/("""$("#menu-templateDevice").addClass("mm-active");
            $("#menu").metisMenu();
          """),format.raw/*74.11*/("""}"""),format.raw/*74.12*/(""")
  </script>
  <script src=""""),_display_(/*76.17*/routes/*76.23*/.Assets.versioned("javascripts/views/admin/templateDevice.js")),format.raw/*76.85*/("""" type="text/javascript"></script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/admin/templateDevice/TemplateDeviceList.scala.html
                  HASH: 4ffea8b323f69d585e2fb654c009a9dab2563df4
                  MATRIX: 672->1|695->18|1043->52|1156->70|1183->71|1351->213|1398->240|1479->294|1494->300|1551->336|1758->517|1772->522|1818->547|1849->551|1914->590|1928->595|1969->615|2002->622|2016->627|2068->658|2101->664|2539->1075|2579->1094|2622->1109|2926->1386|2962->1401|3018->1430|3064->1455|3120->1484|3164->1507|3220->1536|3264->1559|3320->1588|3362->1609|3418->1638|3461->1660|3517->1689|3556->1707|3772->1897|3786->1902|3858->1953|3892->1961|3906->1966|3979->2018|4013->2026|4027->2031|4099->2082|4132->2088|4204->2134|4218->2139|4254->2154|4285->2158|4323->2170|4336->2175|4377->2195|4408->2199|4485->2248|4514->2249|4555->2262|4678->2357|4707->2358|4764->2388|4779->2394|4862->2456
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|51->19|51->19|51->19|53->21|53->21|53->21|55->23|62->30|62->30|63->31|72->40|72->40|73->41|73->41|74->42|74->42|75->43|75->43|76->44|76->44|77->45|77->45|78->46|78->46|90->58|90->58|90->58|91->59|91->59|91->59|92->60|92->60|92->60|94->62|96->64|96->64|96->64|98->66|100->68|100->68|100->68|102->70|103->71|103->71|104->72|106->74|106->74|108->76|108->76|108->76
                  -- GENERATED --
              */
          