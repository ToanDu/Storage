
package views.html.telco.topUp

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

object Utilities_blockSubscriber extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="accordion-body">
  <div class="card-header-primary card-header-icon">
    <div class="toolbar" style="float: left">
      <button class="btn btn-title">
        """),_display_(/*5.10*/Messages("Chặn chiều thuê bao")),format.raw/*5.41*/("""
      """),format.raw/*6.7*/("""</button>
    </div>
    <div class="toolbar" style="float: right">
      <button class="btn px-4 button-light" id="buttonImportBlockSubs" data-bs-toggle="modal" data-bs-target="#importBlockSubsModal">
        """),_display_(/*10.10*/Messages("Tải danh sách TB")),format.raw/*10.38*/("""
      """),format.raw/*11.7*/("""</button>
      <button class="btn px-4 button-light" id="buttonProcessBlockSubs1" onclick="showComfirmBlockSubsModal(1)">
        """),_display_(/*13.10*/Messages("Chặn 1 chiều")),format.raw/*13.34*/("""
      """),format.raw/*14.7*/("""</button>
      <button class="btn px-4 button-light" id="buttonProcessBlockSubs2" onclick="showComfirmBlockSubsModal(2)">
      """),_display_(/*16.8*/Messages("Chặn 2 chiều")),format.raw/*16.32*/("""
      """),format.raw/*17.7*/("""</button>
      <button class="btn px-4 button-light" id="buttonImportBlockSubs" onclick="exportResultListSubsBlock()">
      """),_display_(/*19.8*/Messages("Export")),format.raw/*19.26*/("""
      """),format.raw/*20.7*/("""</button>
    </div>
  </div>
  <div class="card-body mt-3" style="padding-right: 0px;">
    <div class="" id="dataImportBlockSubs" style="float: left; width: 100%;">

    </div>
  </div>
</div>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:55 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/topUp/Utilities_blockSubscriber.scala.html
                  HASH: caa19d73e6c91d7d0ea2c92136a028590de0932b
                  MATRIX: 1062->0|1262->174|1313->205|1346->212|1584->423|1633->451|1667->458|1826->590|1871->614|1905->621|2061->751|2106->775|2140->782|2293->909|2332->927|2366->934
                  LINES: 33->1|37->5|37->5|38->6|42->10|42->10|43->11|45->13|45->13|46->14|48->16|48->16|49->17|51->19|51->19|52->20
                  -- GENERATED --
              */
          