
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

object Module_nbIot extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-md-12" id="moduleNbIot" style="display: block">
  <div class="row">
    <div class="col-md-6">
      <div class="card-group shadow">
        <div class="card border-end shadow-none">
          <div class="card-body">
            <h5 class="card-title" style="text-align: center">BC660k</h5>
          </div>
          <div class="card-footer">
            <div class="row g-0">
              <div class="col-md-4">
                <img src=""""),_display_(/*12.28*/routes/*12.34*/.Assets.versioned("images/module/bc660k.png")),format.raw/*12.79*/("""" alt="..." class="card-img">
              </div>
              <div class="col-md-8">
                <div class="card-body">
                  <h5 class="card-title">Mô tả</h5>
                  <p class="card-text"> • Mô đun NB-IOT</p>
                  <p class="card-text"> • Loại: LTE-NB2</p>
                  <p class="card-text"> • Công suất: class 3 </p>
                  <p class="card-text"> • Tốc độ: 158.5Kbps (HL), 127Kbps (DL)</p>
                  <p class="card-text"> • Nhiệt độ hoạt động: -40 → 85°C</p>
                  <p class="card-text"> • Kích thước: 17.7x15.8x2.0mm</p>
                  <a class="card-text" href="" style="float: right"><small style="cursor: pointer; font-weight: bold">Tải xuống <i class="bx bx-arrow-to-bottom"></i></small></a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="col-md-6">
      <div class="card-group shadow">
        <div class="card border-end shadow-none">
          <div class="card-body">
            <h5 class="card-title" style="text-align: center">SIM7022</h5>
          </div>
          <div class="card-footer">
            <div class="row g-0">
              <div class="col-md-4">
                <img src=""""),_display_(/*41.28*/routes/*41.34*/.Assets.versioned("images/module/sim7022.png")),format.raw/*41.80*/("""" alt="..." class="card-img">
              </div>
              <div class="col-md-8">
                <div class="card-body">
                  <h5 class="card-title">Mô tả</h5>
                  <p class="card-text"> • Mô đun NB-IOT</p>
                  <p class="card-text"> • Loại: LTE-NB2</p>
                  <p class="card-text"> • Công suất: class 3 </p>
                  <p class="card-text"> • Tốc độ: 159Kbps (UL),127Kbps (DL)</p>
                  <p class="card-text"> • Nhiệt độ hoạt động: -40 → 85°C</p>
                  <p class="card-text"> • Kích thước: 17.6x15.7x2.3mm</p>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/module/Module_nbIot.scala.html
                  HASH: af8e00482a0064b0fbcd77c50c1ac683ca6f6406
                  MATRIX: 1048->0|1533->458|1548->464|1614->509|2914->1782|2929->1788|2996->1834
                  LINES: 33->1|44->12|44->12|44->12|73->41|73->41|73->41
                  -- GENERATED --
              */
          