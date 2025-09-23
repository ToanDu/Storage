
package views.html

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

object BackToTop extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<link href=""""),_display_(/*1.14*/routes/*1.20*/.Assets.versioned("stylesheets/backToTop.css")),format.raw/*1.66*/("""" rel="stylesheet" />
<a href="javaScript:;" class="back-to-top">
    <i class='bx bxs-up-arrow-alt' style="font-size: 36px; margin-top: 10px;"></i>
</a>
<script src=""""),_display_(/*5.15*/routes/*5.21*/.Assets.versioned("javascripts/backToTop.js")),format.raw/*5.66*/("""" type="text/javascript"></script>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:39 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/BackToTop.scala.html
                  HASH: 339502ddc2f4a9d27f86fcafc471f92d58aff0df
                  MATRIX: 1034->0|1073->13|1087->19|1153->65|1347->233|1361->239|1426->284
                  LINES: 33->1|33->1|33->1|33->1|37->5|37->5|37->5
                  -- GENERATED --
              */
          