
package views.html.noti

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

object Success extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>"""),_display_(/*6.11*/Messages("Success")),format.raw/*6.30*/("""</title>
  <link rel="icon" type="image/png" href=""""),_display_(/*7.44*/routes/*7.50*/.Assets.versioned("images/logo.jpg")),format.raw/*7.86*/("""">

  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
  <meta name="viewport" content="width=device-width" />

  <link href=""""),_display_(/*12.16*/routes/*12.22*/.Assets.versioned("stylesheets/views/noti/noti.css")),format.raw/*12.74*/("""" rel="stylesheet">
</head>
<body>
  <div id="container">
    <div id="success-box">
      <div class="dot"></div>
      <div class="dot two"></div>
      <div class="face">
        <div class="eye"></div>
        <div class="eye right"></div>
        <div class="mouth happy"></div>
      </div>
      <div class="shadow scale"></div>
      <div class="message"><h1 class="alert">Success!</h1><p>yay, everything is working.</p></div>
      <button class="button-box"><h1 class="green">continue</h1></button>
    </div>

    <div id="error-box">
      <div class="dot"></div>
      <div class="dot two"></div>
      <div class="face2">
        <div class="eye"></div>
        <div class="eye right"></div>
        <div class="mouth sad"></div>
      </div>
      <div class="shadow move"></div>
      <div class="message"><h1 class="alert">Error!</h1><p>oh no, something went wrong.</div>
      <button class="button-box"><h1 class="red">try again</h1></button>
    </div>
  </div>
</body>
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
                  DATE: Mon Sep 22 16:32:48 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/noti/Success.scala.html
                  HASH: 92d2ce1d564817df2f7998c68a003ae6ebf2185d
                  MATRIX: 1037->0|1207->144|1246->163|1324->215|1338->221|1394->257|1608->444|1623->450|1696->502
                  LINES: 33->1|38->6|38->6|39->7|39->7|39->7|44->12|44->12|44->12
                  -- GENERATED --
              */
          