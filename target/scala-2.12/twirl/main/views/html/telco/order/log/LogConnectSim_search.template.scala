
package views.html.telco.order.log

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

object LogConnectSim_search extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

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
              <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*10.71*/Messages("Loại đấu nối")),format.raw/*10.95*/("""</label>
              <div class="col-sm-8 input-icons">
                <select class="form-control" id="actionConnectSim">
                  <option value="13">"""),_display_(/*13.39*/Messages("Trả trước")),format.raw/*13.60*/("""</option>
                  <option value="12">"""),_display_(/*14.39*/Messages("Trả sau")),format.raw/*14.58*/("""</option>
                </select>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="d-flex flex-column align-items-center text-center">
      <div class="">
        <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF; width: 180px;" onclick="onlickButtonSearch()">"""),_display_(/*24.149*/Messages("Tra cứu")),format.raw/*24.168*/("""</button>
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
                  DATE: Mon Sep 22 16:32:53 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/order/log/LogConnectSim_search.scala.html
                  HASH: 7f2f5342a9cc35034c851e2379e3079ffac3159a
                  MATRIX: 1061->0|1163->76|1213->106|1519->385|1564->409|1755->573|1797->594|1872->642|1912->661|2309->1030|2350->1049
                  LINES: 33->1|35->3|35->3|42->10|42->10|45->13|45->13|46->14|46->14|56->24|56->24
                  -- GENERATED --
              */
          