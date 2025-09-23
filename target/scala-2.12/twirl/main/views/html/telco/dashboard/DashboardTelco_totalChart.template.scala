
package views.html.telco.dashboard

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

object DashboardTelco_totalChart extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="card" style="height: 100%;">
  <div class="card-body">

    <div class="row">
      <div class="col-md-8">
        <div class="row">
          <div class="col-md-6">
            <span class="title-card">"""),_display_(/*8.39*/Messages("Tổng thuê bao và chi phí phát sinh")),format.raw/*8.85*/("""</span>
          </div>
          <div class="col-md-6">
            <select class="select-form">
              <option value="0">"""),_display_(/*12.34*/Messages("Theo tháng ")),format.raw/*12.57*/("""</option>
            </select>
          </div>
        </div>
      </div>

      <div class="col-md-4">

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
                  DATE: Mon Sep 22 16:32:52 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/dashboard/DashboardTelco_totalChart.scala.html
                  HASH: 4a9558a2f194750c577612a7d9e948cbbc5fc9c9
                  MATRIX: 1066->0|1308->216|1374->262|1533->394|1577->417
                  LINES: 33->1|40->8|40->8|44->12|44->12
                  -- GENERATED --
              */
          