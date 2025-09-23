
package views.html.tags

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

object main_css extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.5*/("""<!--     Fonts and icons     -->
"""),format.raw/*3.151*/("""
    """),format.raw/*4.5*/("""<link href='"""),_display_(/*4.18*/routes/*4.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*4.73*/("""' type='text/css'>
    <link href=""""),_display_(/*5.18*/routes/*5.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*5.99*/("""" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- CSS Files -->
<link href=""""),_display_(/*8.14*/routes/*8.20*/.Assets.versioned("stylesheets/material-dashboard/material-dashboard.css?v=2.1.0")),format.raw/*8.102*/("""" rel="stylesheet"/>"""))
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/tags/main_css.scala.html
                  HASH: c4edb0c54163af130357ace5a79a89d3eac521c1
                  MATRIX: 1038->5|1099->188|1130->193|1169->206|1183->212|1252->261|1314->297|1328->303|1423->378|1613->542|1627->548|1730->630
                  LINES: 33->2|34->3|35->4|35->4|35->4|35->4|36->5|36->5|36->5|39->8|39->8|39->8
                  -- GENERATED --
              */
          