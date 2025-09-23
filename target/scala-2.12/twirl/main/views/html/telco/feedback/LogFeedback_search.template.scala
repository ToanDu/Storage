
package views.html.telco.feedback

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

object LogFeedback_search extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="card">
  <div class="card-body">
    <span class="text-search">"""),_display_(/*3.32*/Messages("Thông tin tìm kiếm")),format.raw/*3.62*/("""</span>

    <div class="row mt-3">
      <div class="col-md-12">
        <div class="row">
          <div class="col-md-6 m-t-3">
            <div class="row m-b-4">
              <div class="col-sm-1"></div>
              <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*11.71*/Messages("Email")),format.raw/*11.88*/("""</label>
              <div class="col-sm-8 input-icons">
                <input id="email" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="50" required>
              </div>
            </div>
          </div>
          <div class="col-md-6 m-t-3">
            <div class="row m-b-4">
              <div class="col-sm-1"></div>
              <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*20.71*/Messages("Phone")),format.raw/*20.88*/("""</label>
              <div class="col-sm-8 input-icons">
                <input id="phone" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="11" required>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="d-flex flex-column align-items-center text-center">
      <div class="">
        <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033; width: 180px;" onclick="resetFormSearch()">"""),_display_(/*31.146*/Messages("Reset")),format.raw/*31.163*/("""</button>
        <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF; width: 180px;" onclick="onlickButtonSearch()">"""),_display_(/*32.149*/Messages("Tra cứu")),format.raw/*32.168*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/feedback/LogFeedback_search.scala.html
                  HASH: a0a5ba5e22fdf69eb049fc60d788fa5dd84570c5
                  MATRIX: 1058->0|1160->76|1210->106|1517->386|1555->403|2016->837|2054->854|2601->1373|2640->1390|2826->1548|2867->1567
                  LINES: 33->1|35->3|35->3|43->11|43->11|52->20|52->20|63->31|63->31|64->32|64->32
                  -- GENERATED --
              */
          