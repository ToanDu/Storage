
package views.html.ruleChain

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
/*2.2*/import vn.m2m.utils.DateUtil
/*3.2*/import vn.m2m.common.models.User

object RuleChain extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(currentUser:User, urlRuleEngine:String, projectId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.60*/("""
"""),format.raw/*5.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*10.13*/Messages("Flow Engine")),format.raw/*10.36*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*11.46*/routes/*11.52*/.Assets.versioned("images/logo.jpg")),format.raw/*11.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*16.6*/views/*16.11*/.html.iot.tags.Main_css()),format.raw/*16.36*/("""

    """),format.raw/*18.5*/("""<link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("stylesheets/views/group/style.min.css")),format.raw/*18.82*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*19.78*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*23.6*/views/*23.11*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*23.54*/("""

    """),_display_(/*25.6*/views/*25.11*/.html.iot.tags.Header(currentUser)),format.raw/*25.45*/("""

    """),format.raw/*27.5*/("""<div class="page-wrapper">
      <div class="page-content">

        <div class="card">
          <div class="card-body" style="height: 85vh; padding: 0px;" id="iframeRuleChain">
            <iframe src=""""),_display_(/*32.27*/urlRuleEngine),format.raw/*32.40*/("""" width="100%" height="100%" allowfullscreen></iframe>
          </div>
        </div>
      </div>

    </div>
      <!--  END OF PAPER WRAP -->
    """),_display_(/*39.6*/views/*39.11*/.html.Loading()),format.raw/*39.26*/("""

  """),format.raw/*41.3*/("""</body>

  """),_display_(/*43.4*/views/*43.9*/.html.iot.tags.Main_js()),format.raw/*43.33*/("""

  """),format.raw/*45.3*/("""<script>
          var projectId = '"""),_display_(/*46.29*/projectId),format.raw/*46.38*/("""';

          $(document).ready(function () """),format.raw/*48.41*/("""{"""),format.raw/*48.42*/("""
            """),format.raw/*49.13*/("""$("#menu-ruleChain").addClass("mm-active");
            $("#menu").metisMenu();

//            setTimeout(function () """),format.raw/*52.38*/("""{"""),format.raw/*52.39*/("""
"""),format.raw/*53.1*/("""//              var url = 'http://localhost:4200/ruleChains/8c513cd0-d246-11eb-9381-ab2a1a8daaf0';
//              var el = document.getElementById('iframeRuleChain');
//              el.src = url;
//            """),format.raw/*56.15*/("""}"""),format.raw/*56.16*/(""",3000);

          """),format.raw/*58.11*/("""}"""),format.raw/*58.12*/(""")
  </script>

  <script src=""""),_display_(/*61.17*/routes/*61.23*/.Assets.versioned("javascripts/SearchJs.js")),format.raw/*61.67*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*63.17*/routes/*63.23*/.Assets.versioned("javascripts/views/ruleEngine/RuleEngine.js")),format.raw/*63.86*/("""" type="text/javascript"></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,urlRuleEngine:String,projectId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,urlRuleEngine,projectId)

  def f:((User,String,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,urlRuleEngine,projectId) => apply(currentUser,urlRuleEngine,projectId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:49 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/ruleChain/RuleChain.scala.html
                  HASH: 7ae024817401a85caa781d8f39adc2afe1a68000
                  MATRIX: 661->1|684->18|720->48|1073->82|1226->140|1253->141|1422->283|1466->306|1547->360|1562->366|1619->402|1826->583|1840->588|1886->613|1919->619|1959->632|1974->638|2053->696|2119->735|2134->741|2209->795|2299->859|2313->864|2377->907|2410->914|2424->919|2479->953|2512->959|2744->1164|2778->1177|2955->1328|2969->1333|3005->1348|3036->1352|3074->1364|3087->1369|3132->1393|3163->1397|3227->1434|3257->1443|3329->1487|3358->1488|3399->1501|3545->1619|3574->1620|3602->1621|3842->1833|3871->1834|3918->1853|3947->1854|4005->1885|4020->1891|4085->1935|4164->1987|4179->1993|4263->2056
                  LINES: 24->1|25->2|26->3|31->4|36->4|37->5|42->10|42->10|43->11|43->11|43->11|48->16|48->16|48->16|50->18|50->18|50->18|50->18|51->19|51->19|51->19|55->23|55->23|55->23|57->25|57->25|57->25|59->27|64->32|64->32|71->39|71->39|71->39|73->41|75->43|75->43|75->43|77->45|78->46|78->46|80->48|80->48|81->49|84->52|84->52|85->53|88->56|88->56|90->58|90->58|93->61|93->61|93->61|95->63|95->63|95->63
                  -- GENERATED --
              */
          