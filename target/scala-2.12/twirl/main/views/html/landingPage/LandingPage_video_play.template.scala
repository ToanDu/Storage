
package views.html.landingPage

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

object LandingPage_video_play extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="playVideoConfirm" data-bs-backdrop="static" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: inherit;">
        <h5 class="modal-title" id="exampleModalLabel">"""),_display_(/*5.57*/Messages("Video hướng dẫn tích hợp")),format.raw/*5.93*/("""</h5>
        """),format.raw/*6.102*/("""
        """),format.raw/*7.9*/("""<i class="bx bx-x btn-close" data-bs-dismiss="modal" id="stopVideo" aria-label="Close" style="font-size: 20px; cursor: pointer;"></i>
      </div>
      <div class="modal-body" style="padding: 0;">
        <iframe id="myVideo" width="100%" height="456" src="https://www.youtube.com/embed/KvNhWGB5nuk?rel=1&amp;controls=1&amp;showinfo=0&amp;start=1&autoplay=0&enablejsapi=1"
        frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
      </div>
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
                  DATE: Mon Sep 22 16:32:47 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPage/LandingPage_video_play.scala.html
                  HASH: ac099b640c3932f02e0a2993c206c94b863994e6
                  MATRIX: 1059->0|1409->324|1465->360|1507->467|1542->476
                  LINES: 33->1|37->5|37->5|38->6|39->7
                  -- GENERATED --
              */
          