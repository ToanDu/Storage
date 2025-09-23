
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

object Module_wifi extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-md-12">
  <div class="row" id="moduleWifi" style="display: none">
    <div class="col-md-6">
      <div class="card-group shadow">
        <div class="card border-end shadow-none">
          <div class="card-body">
            <h5 class="card-title" style="text-align: center">WT32C3-S5</h5>
          </div>
          <div class="card-footer">
            <div class="row g-0">
              <div class="col-md-4">
                <img src=""""),_display_(/*12.28*/routes/*12.34*/.Assets.versioned("images/module/wifi.jpg")),format.raw/*12.77*/("""" alt="..." class="card-img">
              </div>
              <div class="col-md-8">
                <div class="card-body">
                  <h5 class="card-title">Mô tả</h5>
                  <p class="card-text"> • Mô đun Wifi</p>
                  <p class="card-text"> • Tần số hoạt động: 2.4GHz</p>
                  <p class="card-text"> • Loại ESP32-C3</p>
                  <p class="card-text"> • Tốc độ: 150Mbps</p>
                  <p class="card-text"> • Bộ nhớ: 4MB Flash</p>
                  <p class="card-text"> • Kích thước: 24x16x2.3mm</p>
                  <p class="card-text"> • Nhiệt độ hoạt động: -40 → 85°C</p>
                  <a class="card-text" href="" style="float: right"><small style="cursor: pointer; font-weight: bold">Tải xuống <i class="bx bx-arrow-to-bottom"></i></small></a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-6"></div>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/module/Module_wifi.scala.html
                  HASH: 07f5650f89b152fca9fbe60ea15a5f49e14f7059
                  MATRIX: 1047->0|1533->459|1548->465|1612->508
                  LINES: 33->1|44->12|44->12|44->12
                  -- GENERATED --
              */
          