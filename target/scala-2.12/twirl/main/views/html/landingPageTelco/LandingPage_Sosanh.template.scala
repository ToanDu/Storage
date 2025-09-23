
package views.html.landingPageTelco

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

object LandingPage_Sosanh extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="questionModal3" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content" id="theme16">
            <div class="modal-header" style="text-align: center; display: contents;">
                <h5 class="ipSosanh">"""),_display_(/*5.39*/Messages("landingPageTelco.sosanh.comparePackages")),format.raw/*5.90*/("""</h5>
            </div>
            <div class="modal-body" id="popup">

            </div>
            <div class="modal-dialog_btn-2column2" style="text-align: center;">
"""),format.raw/*11.255*/("""
            """),format.raw/*12.13*/("""<button type="button" class="btn btn-default" data-dismiss="modal" onclick="selectData()" style="color: #FFFFFF; background: #EA0033;border-radius: 8px 8px 8px 0px;margin-top: -45px;">"""),_display_(/*12.198*/Messages("landingPageTelco.sosanh.close")),format.raw/*12.239*/("""</button>
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
                  DATE: Mon Sep 22 18:18:26 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPageTelco/LandingPage_Sosanh.scala.html
                  HASH: 55c20117817ad103265d3a4e81062854a936f30f
                  MATRIX: 1060->0|1377->291|1448->342|1650->769|1691->782|1904->967|1967->1008
                  LINES: 33->1|37->5|37->5|43->11|44->12|44->12|44->12
                  -- GENERATED --
              */
          