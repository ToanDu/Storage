
package views.html.telco

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

object PageSuccess extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Success</title>
  """),format.raw/*6.119*/("""
    """),format.raw/*7.5*/("""<link href='"""),_display_(/*7.18*/routes/*7.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*7.73*/("""' type='text/css'>
    <link href=""""),_display_(/*8.18*/routes/*8.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*8.99*/("""" rel="stylesheet">
  <style>
      body """),format.raw/*10.12*/("""{"""),format.raw/*10.13*/("""
        """),format.raw/*11.9*/("""text-align: center;
        padding: 40px 0;
        background: #EBF0F5;
      """),format.raw/*14.7*/("""}"""),format.raw/*14.8*/("""
      """),format.raw/*15.7*/("""h1 """),format.raw/*15.10*/("""{"""),format.raw/*15.11*/("""
        """),format.raw/*16.9*/("""color: #88B04B;
        font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
        font-weight: 900;
        font-size: 40px;
        margin-bottom: 10px;
      """),format.raw/*21.7*/("""}"""),format.raw/*21.8*/("""
      """),format.raw/*22.7*/("""p """),format.raw/*22.9*/("""{"""),format.raw/*22.10*/("""
        """),format.raw/*23.9*/("""color: #404F5E;
        font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
        font-size:20px;
        margin: 0;
      """),format.raw/*27.7*/("""}"""),format.raw/*27.8*/("""
      """),format.raw/*28.7*/("""i """),format.raw/*28.9*/("""{"""),format.raw/*28.10*/("""
        """),format.raw/*29.9*/("""color: #9ABC66;
        font-size: 100px;
        line-height: 200px;
        margin-left:-15px;
      """),format.raw/*33.7*/("""}"""),format.raw/*33.8*/("""
      """),format.raw/*34.7*/(""".card """),format.raw/*34.13*/("""{"""),format.raw/*34.14*/("""
        """),format.raw/*35.9*/("""background: white;
        padding: 60px;
        border-radius: 4px;
        box-shadow: 0 2px 3px #C8D0D8;
        display: inline-block;
        margin: 0 auto;
      """),format.raw/*41.7*/("""}"""),format.raw/*41.8*/("""
    """),format.raw/*42.5*/("""</style>
</head>
<body>
  <div class="card">
    <div style="border-radius:200px; height:200px; width:200px; background: #F8FAF5; margin:0 auto;">
      <i class="checkmark">✓</i>
    </div>
    <h1>Success</h1>
    <p>"""),_display_(/*50.9*/Messages("Chúc mừng bạn đã thanh toán thành công;")),format.raw/*50.60*/("""<br/> """),_display_(/*50.67*/Messages("Cửa sổ sẽ đóng sau 3 giây!")),format.raw/*50.105*/("""</p>
  </div>
</body>
  <script>
    setTimeout(function () """),format.raw/*54.28*/("""{"""),format.raw/*54.29*/("""
      """),format.raw/*55.7*/("""window.close();
    """),format.raw/*56.5*/("""}"""),format.raw/*56.6*/(""",3000);
  </script>
</html>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:50 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/PageSuccess.scala.html
                  HASH: 03aa39513c7265a8c060a322d0b7d031da5ae587
                  MATRIX: 1042->0|1162->208|1193->213|1232->226|1246->232|1315->281|1377->317|1391->323|1486->398|1555->439|1584->440|1620->449|1727->529|1755->530|1789->537|1820->540|1849->541|1885->550|2080->718|2108->719|2142->726|2171->728|2200->729|2236->738|2394->869|2422->870|2456->877|2485->879|2514->880|2550->889|2680->992|2708->993|2742->1000|2776->1006|2805->1007|2841->1016|3038->1186|3066->1187|3098->1192|3344->1412|3416->1463|3450->1470|3510->1508|3598->1568|3627->1569|3661->1576|3708->1596|3736->1597
                  LINES: 33->1|38->6|39->7|39->7|39->7|39->7|40->8|40->8|40->8|42->10|42->10|43->11|46->14|46->14|47->15|47->15|47->15|48->16|53->21|53->21|54->22|54->22|54->22|55->23|59->27|59->27|60->28|60->28|60->28|61->29|65->33|65->33|66->34|66->34|66->34|67->35|73->41|73->41|74->42|82->50|82->50|82->50|82->50|86->54|86->54|87->55|88->56|88->56
                  -- GENERATED --
              */
          