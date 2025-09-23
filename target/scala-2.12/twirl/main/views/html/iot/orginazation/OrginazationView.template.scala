
package views.html.iot.orginazation

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

object OrginazationView extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("Orginazation View")),format.raw/*9.42*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link rel="stylesheet" href=""""),_display_(/*17.35*/routes/*17.41*/.Assets.versioned("stylesheets/views/orginazation/jquery.orgchart.css")),format.raw/*17.112*/("""" />
    <link rel="stylesheet" href=""""),_display_(/*18.35*/routes/*18.41*/.Assets.versioned("stylesheets/views/orginazation/orgView.css")),format.raw/*18.104*/("""" />
  </head>
  <body class="bg-theme">
    """),_display_(/*21.6*/views/*21.11*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*21.54*/("""

    """),_display_(/*23.6*/views/*23.11*/.html.iot.tags.Header(currentUser)),format.raw/*23.45*/("""

    """),format.raw/*25.5*/("""<div class="page-wrapper">
      <div class="page-content" >
        <div class="card">
          <div class="col-md-12">
            <div class="row">
              <div class="" id="chart-container"></div>
            </div>
          </div>
        </div>
      </div>
    </div>

    """),_display_(/*37.6*/views/*37.11*/.html.Loading()),format.raw/*37.26*/("""
  """),format.raw/*38.3*/("""</body>

  """),_display_(/*40.4*/views/*40.9*/.html.iot.tags.Main_js()),format.raw/*40.33*/("""

  """),format.raw/*42.3*/("""<script>
          var projectId = '"""),_display_(/*43.29*/projectId),format.raw/*43.38*/("""';
          var iconOrg = """"),_display_(/*44.27*/routes/*44.33*/.Assets.versioned("images/org/orgview.png")),format.raw/*44.76*/("""";
          $(document).ready(function () """),format.raw/*45.41*/("""{"""),format.raw/*45.42*/("""
            """),format.raw/*46.13*/("""$("#menu-orgView").addClass("mm-active");

            $("#menu").metisMenu();
          """),format.raw/*49.11*/("""}"""),format.raw/*49.12*/(""")
  </script>

  <script src=""""),_display_(/*52.17*/routes/*52.23*/.Assets.versioned("javascripts/views/orginazation/jquery.orgchart.min.js")),format.raw/*52.97*/(""""></script>
  <script src=""""),_display_(/*53.17*/routes/*53.23*/.Assets.versioned("javascripts/views/orginazation/orgView.js")),format.raw/*53.85*/(""""></script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/orginazation/OrginazationView.scala.html
                  HASH: 926cea4185fa845074e6ca66662edd54d6409d40
                  MATRIX: 668->1|691->18|1044->52|1175->88|1202->89|1370->231|1419->260|1500->314|1515->320|1572->356|1779->537|1793->542|1839->567|1872->573|1929->603|1944->609|2037->680|2103->719|2118->725|2203->788|2275->834|2289->839|2353->882|2386->889|2400->894|2455->928|2488->934|2803->1223|2817->1228|2853->1243|2883->1246|2921->1258|2934->1263|2979->1287|3010->1291|3074->1328|3104->1337|3160->1366|3175->1372|3239->1415|3310->1458|3339->1459|3380->1472|3497->1561|3526->1562|3584->1593|3599->1599|3694->1673|3749->1701|3764->1707|3847->1769
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|53->21|53->21|53->21|55->23|55->23|55->23|57->25|69->37|69->37|69->37|70->38|72->40|72->40|72->40|74->42|75->43|75->43|76->44|76->44|76->44|77->45|77->45|78->46|81->49|81->49|84->52|84->52|84->52|85->53|85->53|85->53
                  -- GENERATED --
              */
          