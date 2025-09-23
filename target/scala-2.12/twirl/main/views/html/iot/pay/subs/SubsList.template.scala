
package views.html.iot.pay.subs

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

object SubsList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("Subs List")),format.raw/*9.34*/("""</title>
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
          <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; font-weight: normal;">"""),_display_(/*27.154*/Messages("Quản lý đăng ký")),format.raw/*27.181*/("""</span>
        </div>
        <div class="card mt-3">
          <div class="card-body">
            <div id="tabSubsList">

            </div>
          </div>
        </div>

      </div>
    </div>

    """),_display_(/*40.6*/views/*40.11*/.html.iot.pay.subs.SubsList_cancel()),format.raw/*40.47*/("""
    """),_display_(/*41.6*/views/*41.11*/.html.iot.pay.subs.SubsList_payment()),format.raw/*41.48*/("""

    """),_display_(/*43.6*/views/*43.11*/.html.Loading()),format.raw/*43.26*/("""
  """),format.raw/*44.3*/("""</body>

  """),_display_(/*46.4*/views/*46.9*/.html.iot.tags.Main_js()),format.raw/*46.33*/("""

  """),format.raw/*48.3*/("""<script>
          var iconEdit = """"),_display_(/*49.28*/routes/*49.34*/.Assets.versioned("images/icon/edit.png")),format.raw/*49.75*/("""";
          var iconDelete = """"),_display_(/*50.30*/routes/*50.36*/.Assets.versioned("images/icon/delete.png")),format.raw/*50.79*/("""";

          var projectId = '"""),_display_(/*52.29*/projectId),format.raw/*52.38*/("""';

          $(document).ready(function () """),format.raw/*54.41*/("""{"""),format.raw/*54.42*/("""
            """),format.raw/*55.13*/("""$("#menu-subs").addClass("mm-active");

            $("#menu").metisMenu();

          """),format.raw/*59.11*/("""}"""),format.raw/*59.12*/(""")
  </script>
  <script src=""""),_display_(/*61.17*/routes/*61.23*/.Assets.versioned("javascripts/views/pay/subs/subsList.js")),format.raw/*61.82*/(""""></script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/pay/subs/SubsList.scala.html
                  HASH: 7bbc78359ee8803535f5fd70d03751645845ce40
                  MATRIX: 664->1|687->18|1032->52|1163->88|1190->89|1358->231|1399->252|1480->306|1495->312|1552->348|1759->529|1773->534|1819->559|1850->563|1915->602|1929->607|1993->650|2026->657|2040->662|2095->696|2128->702|2465->1011|2514->1038|2747->1245|2761->1250|2818->1286|2850->1292|2864->1297|2922->1334|2955->1341|2969->1346|3005->1361|3035->1364|3073->1376|3086->1381|3131->1405|3162->1409|3225->1445|3240->1451|3302->1492|3361->1524|3376->1530|3440->1573|3499->1605|3529->1614|3601->1658|3630->1659|3671->1672|3786->1759|3815->1760|3872->1790|3887->1796|3967->1855
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|51->19|51->19|51->19|53->21|53->21|53->21|55->23|59->27|59->27|72->40|72->40|72->40|73->41|73->41|73->41|75->43|75->43|75->43|76->44|78->46|78->46|78->46|80->48|81->49|81->49|81->49|82->50|82->50|82->50|84->52|84->52|86->54|86->54|87->55|91->59|91->59|93->61|93->61|93->61
                  -- GENERATED --
              */
          