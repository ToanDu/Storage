
package views.html.QrCodePage

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
/*1.2*/import vn.m2m.iot.models.QrCode

object QrCodeList_view extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[QrCode,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(qrCode: QrCode):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.18*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>"""),_display_(/*8.17*/Messages("Scan QR Code")),format.raw/*8.41*/("""</title>
        <link rel="icon" type="image/png" href=""""),_display_(/*9.50*/routes/*9.56*/.Assets.versioned("images/logo.jpg")),format.raw/*9.92*/("""">

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        """),_display_(/*14.10*/views/*14.15*/.html.iot.tags.Main_css()),format.raw/*14.40*/("""
    """),format.raw/*15.5*/("""</head>
    <body onload=onReady()>
        <div class="card" style="padding: 15px">
            <div class="col-md-12" style="text-align: center">
                <img id="qrcodeImg" style="width: 50%">
            </div>
            <div class="col-md-12 mt-5">
                <div class="row">
                    <div class="ml-auto mr-auto" style="text-align: center">
                        <a class="btn btn-light" id="buttonDownAndroid" href=""""),_display_(/*24.80*/qrCode/*24.86*/.getLinkAndroid),format.raw/*24.101*/("""">
                            <i class="bx bxl-android" aria-hidden="true"></i> """),_display_(/*25.80*/Messages("Download Android App")),format.raw/*25.112*/("""
                        """),format.raw/*26.25*/("""</a>
                        <a class="btn btn-light" id="buttonDownIos" href=""""),_display_(/*27.76*/qrCode/*27.82*/.getLinkIos),format.raw/*27.93*/("""">
                            <i class="bx bxl-apple" aria-hidden="true"></i> """),_display_(/*28.78*/Messages("Download IOS App")),format.raw/*28.106*/("""
                        """),format.raw/*29.25*/("""</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src=""""),_display_(/*35.19*/routes/*35.25*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*35.79*/("""" type="text/javascript"></script>
    <script type="text/javascript">
            function onReady() """),format.raw/*37.32*/("""{"""),format.raw/*37.33*/("""
                """),format.raw/*38.17*/("""document.getElementById("qrcodeImg").src = '"""),_display_(/*38.62*/qrCode/*38.68*/.getSrc),format.raw/*38.75*/("""';

                var userAgent = navigator.userAgent || navigator.vendor || window.opera;
                if (/windows phone/i.test(userAgent)) """),format.raw/*41.55*/("""{"""),format.raw/*41.56*/("""
                    """),format.raw/*42.21*/("""$("#buttonDownAndroid").show();
                    $("#buttonDownIos").hide();
                    setTimeout(function () """),format.raw/*44.44*/("""{"""),format.raw/*44.45*/("""
                        """),format.raw/*45.25*/("""window.location.href = '"""),_display_(/*45.50*/qrCode/*45.56*/.getLinkAndroid),format.raw/*45.71*/("""';
                    """),format.raw/*46.21*/("""}"""),format.raw/*46.22*/(""",500);
                """),format.raw/*47.17*/("""}"""),format.raw/*47.18*/("""
                """),format.raw/*48.17*/("""if (/android/i.test(userAgent)) """),format.raw/*48.49*/("""{"""),format.raw/*48.50*/("""
                    """),format.raw/*49.21*/("""$("#buttonDownAndroid").show();
                    $("#buttonDownIos").hide();
                    setTimeout(function () """),format.raw/*51.44*/("""{"""),format.raw/*51.45*/("""
                        """),format.raw/*52.25*/("""window.location.href = '"""),_display_(/*52.50*/qrCode/*52.56*/.getLinkAndroid),format.raw/*52.71*/("""';
                    """),format.raw/*53.21*/("""}"""),format.raw/*53.22*/(""",500);
                """),format.raw/*54.17*/("""}"""),format.raw/*54.18*/("""
                """),format.raw/*55.17*/("""if (/iPad|iPhone|iPod/.test(userAgent) && !window.MSStream) """),format.raw/*55.77*/("""{"""),format.raw/*55.78*/("""
                    """),format.raw/*56.21*/("""$("#buttonDownAndroid").hide();
                    $("#buttonDownIos").show();
                    setTimeout(function () """),format.raw/*58.44*/("""{"""),format.raw/*58.45*/("""
                        """),format.raw/*59.25*/("""window.location.href = '"""),_display_(/*59.50*/qrCode/*59.56*/.getLinkIos),format.raw/*59.67*/("""';
                    """),format.raw/*60.21*/("""}"""),format.raw/*60.22*/(""",500);
                """),format.raw/*61.17*/("""}"""),format.raw/*61.18*/("""

            """),format.raw/*63.13*/("""}"""),format.raw/*63.14*/("""
    """),format.raw/*64.5*/("""</script>
</html>
"""))
      }
    }
  }

  def render(qrCode:QrCode): play.twirl.api.HtmlFormat.Appendable = apply(qrCode)

  def f:((QrCode) => play.twirl.api.HtmlFormat.Appendable) = (qrCode) => apply(qrCode)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:49 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/QrCodePage/QrCodeList_view.scala.html
                  HASH: 732f2e85bd37a09ee6e9cec8da48fb37dae7bf77
                  MATRIX: 662->1|1008->34|1119->50|1146->51|1328->207|1372->231|1456->289|1470->295|1526->331|1746->524|1760->529|1806->554|1838->559|2319->1013|2334->1019|2371->1034|2480->1116|2534->1148|2587->1173|2694->1253|2709->1259|2741->1270|2848->1350|2898->1378|2951->1403|3097->1522|3112->1528|3187->1582|3317->1684|3346->1685|3391->1702|3463->1747|3478->1753|3506->1760|3681->1907|3710->1908|3759->1929|3910->2052|3939->2053|3992->2078|4044->2103|4059->2109|4095->2124|4146->2147|4175->2148|4226->2171|4255->2172|4300->2189|4360->2221|4389->2222|4438->2243|4589->2366|4618->2367|4671->2392|4723->2417|4738->2423|4774->2438|4825->2461|4854->2462|4905->2485|4934->2486|4979->2503|5067->2563|5096->2564|5145->2585|5296->2708|5325->2709|5378->2734|5430->2759|5445->2765|5477->2776|5528->2799|5557->2800|5608->2823|5637->2824|5679->2838|5708->2839|5740->2844
                  LINES: 24->1|29->2|34->2|35->3|40->8|40->8|41->9|41->9|41->9|46->14|46->14|46->14|47->15|56->24|56->24|56->24|57->25|57->25|58->26|59->27|59->27|59->27|60->28|60->28|61->29|67->35|67->35|67->35|69->37|69->37|70->38|70->38|70->38|70->38|73->41|73->41|74->42|76->44|76->44|77->45|77->45|77->45|77->45|78->46|78->46|79->47|79->47|80->48|80->48|80->48|81->49|83->51|83->51|84->52|84->52|84->52|84->52|85->53|85->53|86->54|86->54|87->55|87->55|87->55|88->56|90->58|90->58|91->59|91->59|91->59|91->59|92->60|92->60|93->61|93->61|95->63|95->63|96->64
                  -- GENERATED --
              */
          