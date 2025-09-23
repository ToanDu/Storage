
package views.html.iot.message

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

object MessagesDevice_tab_metadata extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="chat-tab-menu mt-3">
  <ul class="nav nav-pills nav-justified">
    <li class="nav-item" data-bs-toggle="modal" data-bs-target="#sendMetadataModal">
      <a class="nav-link active" data-bs-toggle="pill" href="javascript:;" title=""""),_display_(/*4.84*/Messages("filter.sendMetadata")),format.raw/*4.115*/("""">
        <div class="font-24"><i class='bx bx-conversation'></i>
        </div>
        <div><small>"""),_display_(/*7.22*/Messages("message.sendMetadata")),format.raw/*7.54*/("""</small>
        </div>
      </a>
    </li>
    <li class="nav-item" data-bs-toggle="modal" data-bs-target="#sendMessToDevice">
      <a class="nav-link active" data-bs-toggle="pill" href="javascript:;" title=""""),_display_(/*12.84*/Messages("filter.sendMessToDevice")),format.raw/*12.119*/("""">
        <div class="font-24"><i class='bx bx-envelope'></i>
        </div>
        <div><small>"""),_display_(/*15.22*/Messages("message.sendMessToDevice")),format.raw/*15.58*/("""</small>
        </div>
      </a>
    </li>
  </ul>
</div>
<hr>
<p id="contentMetadata" class="text-white" style="margin-left: 15px;"></p>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:45 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/message/MessagesDevice_tab_metadata.scala.html
                  HASH: ffba51d5b867da8464f19caa6a2167a51fe675e5
                  MATRIX: 1064->0|1334->244|1386->275|1515->378|1567->410|1806->622|1863->657|1989->756|2046->792
                  LINES: 33->1|36->4|36->4|39->7|39->7|44->12|44->12|47->15|47->15
                  -- GENERATED --
              */
          