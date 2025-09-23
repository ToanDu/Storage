
package views.html.iot.module

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

object Module_zigbee extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-md-12">
  <div class="row" id="moduleZigbee" style="display: none">
    <div class="col-md-6" >
      <div class="card-group shadow">
        <div class="card border-end shadow-none">
          <div class="card-body">
            <h5 class="card-title" style="text-align: center">SMCZ01P</h5>
          </div>
          <div class="card-footer">
            <div class="row g-0">
              <div class="col-md-4">
                <img src=""""),_display_(/*12.28*/routes/*12.34*/.Assets.versioned("images/module/smcz01p.png")),format.raw/*12.80*/("""" alt="..." class="card-img">
              </div>
              <div class="col-md-8">
                <div class="card-body">
                  <h5 class="card-title">Mô tả</h5>
                  <p class="card-text"> • Mô đun Zigbee</p>
                  <p class="card-text"> • Tần số hoạt động: 2.4 GHz, EFR32MG21</p>
                  <p class="card-text"> • Bộ nhớ: 2Mbps, 512KB Flash</p>
                  <p class="card-text"> • Nhiệt độ hoạt động: -40 → 85°C</p>
                  <p class="card-text"> • Kích thước: 22x16x2.2mm</p>
                  <a class="card-text" href="" style="float: right"><small style="cursor: pointer; font-weight: bold">Tải xuống <i class="bx bx-arrow-to-bottom"></i></small></a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
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
                  DATE: Mon Sep 22 16:32:45 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/module/Module_zigbee.scala.html
                  HASH: fafb3abf7221fa24a7aa49a1e55ece06b7266f9a
                  MATRIX: 1049->0|1536->460|1551->466|1618->512
                  LINES: 33->1|44->12|44->12|44->12
                  -- GENERATED --
              */
          