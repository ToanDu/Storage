
package views.html.admin.groupProduct

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

object GroupProductList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("Group Product")),format.raw/*9.38*/("""</title>
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
              <button class="btn btn-success px-5 radius-30" onclick="" data-bs-toggle="modal" data-bs-target="#addConfirmModal">
                <i class="bx bx-plus" aria-hidden="true"></i> """),_display_(/*30.64*/Messages("Tạo mới")),format.raw/*30.83*/("""
              """),format.raw/*31.15*/("""</button>
            </div>
          </div>

          <div class="card-body">
            <div class="table-responsive" id="listGroupProductDiv">

              <table id="dataTables" class="table table-bordered">
                <thead class="cf">
                  <th>"""),_display_(/*40.24*/Messages("STT")),format.raw/*40.39*/("""</th>
                  <th>"""),_display_(/*41.24*/Messages("Mã nhóm ")),format.raw/*41.44*/("""</th>
                  <th>"""),_display_(/*42.24*/Messages("Tên nhóm ")),format.raw/*42.45*/("""</th>
                  <th>"""),_display_(/*43.24*/Messages("Phân loại ")),format.raw/*43.46*/("""</th>
                  <th>"""),_display_(/*44.24*/Messages("Ngày tạo ")),format.raw/*44.45*/("""</th>
                  <th>"""),_display_(/*45.24*/Messages("Thao tác ")),format.raw/*45.45*/("""</th>
                </thead>
                <tbody align="left">

                </tbody>
              </table>

            </div>
          </div>
        </div>
      </div>

      """),_display_(/*57.8*/views/*57.13*/.html.admin.groupProduct.GroupProductList_add()),format.raw/*57.60*/("""
      """),_display_(/*58.8*/views/*58.13*/.html.admin.groupProduct.GroupProductList_del()),format.raw/*58.60*/("""
      """),_display_(/*59.8*/views/*59.13*/.html.admin.groupProduct.GroupProductList_edit()),format.raw/*59.61*/("""

    """),format.raw/*61.5*/("""</div>
      <!--  END OF PAPER WRAP -->
    """),_display_(/*63.6*/views/*63.11*/.html.Loading()),format.raw/*63.26*/("""

  """),format.raw/*65.3*/("""</body>

  """),_display_(/*67.4*/views/*67.9*/.html.admin.mainJs()),format.raw/*67.29*/("""

  """),format.raw/*69.3*/("""<script>
          $(document).ready(function () """),format.raw/*70.41*/("""{"""),format.raw/*70.42*/("""
            """),format.raw/*71.13*/("""$("#menu-groupProduct").addClass("mm-active");
            $("#menu").metisMenu();
          """),format.raw/*73.11*/("""}"""),format.raw/*73.12*/(""")
  </script>
  <script src=""""),_display_(/*75.17*/routes/*75.23*/.Assets.versioned("javascripts/views/admin/groupProduct/GroupProduct.js")),format.raw/*75.96*/("""" type="text/javascript"></script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/admin/groupProduct/GroupProductList.scala.html
                  HASH: 1796d40451106d623cfb335eea03fe0ed2db7260
                  MATRIX: 670->1|693->18|1039->52|1152->70|1179->71|1347->213|1392->238|1473->292|1488->298|1545->334|1752->515|1766->520|1812->545|1843->549|1908->588|1922->593|1963->613|1996->620|2010->625|2062->656|2095->662|2532->1072|2572->1091|2615->1106|2917->1381|2953->1396|3009->1425|3050->1445|3106->1474|3148->1495|3204->1524|3247->1546|3303->1575|3345->1596|3401->1625|3443->1646|3659->1836|3673->1841|3741->1888|3775->1896|3789->1901|3857->1948|3891->1956|3905->1961|3974->2009|4007->2015|4079->2061|4093->2066|4129->2081|4160->2085|4198->2097|4211->2102|4252->2122|4283->2126|4360->2175|4389->2176|4430->2189|4551->2282|4580->2283|4637->2313|4652->2319|4746->2392
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|51->19|51->19|51->19|53->21|53->21|53->21|55->23|62->30|62->30|63->31|72->40|72->40|73->41|73->41|74->42|74->42|75->43|75->43|76->44|76->44|77->45|77->45|89->57|89->57|89->57|90->58|90->58|90->58|91->59|91->59|91->59|93->61|95->63|95->63|95->63|97->65|99->67|99->67|99->67|101->69|102->70|102->70|103->71|105->73|105->73|107->75|107->75|107->75
                  -- GENERATED --
              */
          