
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

object QrCodePage extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>
  <head>
    <script src=""""),_display_(/*4.19*/routes/*4.25*/.Assets.versioned("javascripts/qrCode/qrcode.min.js")),format.raw/*4.78*/("""" type="text/javascript"></script>
    <script type="text/javascript">
		function onReady() """),format.raw/*6.22*/("""{"""),format.raw/*6.23*/("""
          """),format.raw/*7.11*/("""var qrcode = new QRCode("id_qrcode", """),format.raw/*7.48*/("""{"""),format.raw/*7.49*/("""
              """),format.raw/*8.15*/("""id:"abc",
            text:"abcsdsadgdfs",
            width:150,
            height:150,
            colorDark:"#000000",
            colorLight:"#ffffff",
            correctLevel:QRCode.CorrectLevel.H
          """),format.raw/*15.11*/("""}"""),format.raw/*15.12*/(""");

          setTimeout(function () """),format.raw/*17.34*/("""{"""),format.raw/*17.35*/("""
              """),format.raw/*18.15*/("""var src= document.querySelector('#id_qrcode img').getAttribute("src");
              console.log(src);

              document.getElementById("id_qrcode_2").src = src;
          """),format.raw/*22.11*/("""}"""),format.raw/*22.12*/(""",3000);
        """),format.raw/*23.9*/("""}"""),format.raw/*23.10*/("""
		"""),format.raw/*24.3*/("""</script>
  </head>
  <body onload=onReady()>
    <div class="col-md-12" style="position: relative;align-items: center">
      <div id="id_qrcode"></div>
    </div>
      <div class="col-md-12" style="position: relative;align-items: center">
          <img id="id_qrcode_2">
      </div>
  </body>
</html>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:49 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/QrCodePage/QrCodePage.scala.html
                  HASH: eb7304adf2a795fcad29f5dfa5cb0bd6f5357e74
                  MATRIX: 1046->0|1122->50|1136->56|1209->109|1328->201|1356->202|1394->213|1458->250|1486->251|1528->266|1770->480|1799->481|1864->518|1893->519|1936->534|2142->712|2171->713|2214->729|2243->730|2273->733
                  LINES: 33->1|36->4|36->4|36->4|38->6|38->6|39->7|39->7|39->7|40->8|47->15|47->15|49->17|49->17|50->18|54->22|54->22|55->23|55->23|56->24
                  -- GENERATED --
              */
          