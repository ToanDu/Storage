
package views.html.admin.systemHealth

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

object SystemHealth extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("Admin Overview")),format.raw/*9.39*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

  """),format.raw/*17.3*/("""</head>
  <body class="bg-theme">
    """),_display_(/*19.6*/views/*19.11*/.html.admin.navbar()),format.raw/*19.31*/("""

    """),_display_(/*21.6*/views/*21.11*/.html.admin.header(currentUser)),format.raw/*21.42*/("""

    """),format.raw/*23.5*/("""<div class="page-wrapper pb-5" style="background-color: white;">
      <div class="page-content">

        <div class="row">
          <div class="col-md-6">
            <div class="card">
              <iframe src="https://grafana.innoway.vn/d-solo/kschASZVk/kqi-dashboard?orgId=2&theme=light&panelId=11" width="100%" height="350" frameborder="0"></iframe>
            </div>
          </div>

          <div class="col-md-6">
            <div class="card">
              <iframe src="https://grafana.innoway.vn/d-solo/kschASZVk/kqi-dashboard?orgId=2&theme=light&panelId=12" width="100%" height="350" frameborder="0"></iframe>
            </div>
          </div>

          <div class="col-md-6">
            <div class="card">
              <iframe src="https://grafana.innoway.vn/d-solo/kschASZVk/kqi-dashboard?orgId=2&theme=light&panelId=14" width="100%" height="350" frameborder="0"></iframe>
            </div>
          </div>

          <div class="col-md-6">
            <div class="card">
              <iframe src="https://grafana.innoway.vn/d-solo/kschASZVk/kqi-dashboard?orgId=2&theme=light&panelId=8" width="100%" height="350" frameborder="0"></iframe>
            </div>
          </div>

          <div class="col-md-6">
            <div class="card">
              <iframe src="https://grafana.innoway.vn/d-solo/kschASZVk/kqi-dashboard?orgId=2&theme=light&panelId=10" width="100%" height="350" frameborder="0"></iframe>
            </div>
          </div>
        </div>

      </div>
    </div>
      <!--  END OF PAPER WRAP -->
    """),_display_(/*61.6*/views/*61.11*/.html.Loading()),format.raw/*61.26*/("""

  """),format.raw/*63.3*/("""</body>

  """),_display_(/*65.4*/views/*65.9*/.html.admin.mainJs()),format.raw/*65.29*/("""

  """),format.raw/*67.3*/("""<script>
          $(document).ready(function () """),format.raw/*68.41*/("""{"""),format.raw/*68.42*/("""
            """),format.raw/*69.13*/("""$("#menu-adminSystemHealth").addClass("mm-active");
            $("#menu").metisMenu();
          """),format.raw/*71.11*/("""}"""),format.raw/*71.12*/(""");

  </script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/admin/systemHealth/SystemHealth.scala.html
                  HASH: a442963275b9f9ddf77184d78628542f01654c4b
                  MATRIX: 670->1|693->18|1035->52|1148->70|1175->71|1343->213|1389->239|1470->293|1485->299|1542->335|1749->516|1763->521|1809->546|1840->550|1905->589|1919->594|1960->614|1993->621|2007->626|2059->657|2092->663|3670->2215|3684->2220|3720->2235|3751->2239|3789->2251|3802->2256|3843->2276|3874->2280|3951->2329|3980->2330|4021->2343|4147->2441|4176->2442
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|51->19|51->19|51->19|53->21|53->21|53->21|55->23|93->61|93->61|93->61|95->63|97->65|97->65|97->65|99->67|100->68|100->68|101->69|103->71|103->71
                  -- GENERATED --
              */
          