
package views.html.iot.userTenant

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

object UserTenantList_search extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

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
              <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*11.71*/Messages("Tên")),format.raw/*11.86*/("""</label>
              <div class="col-sm-8 input-icons">
                <input id="nameSearch" type="text" class="form-control input-form" maxlength="50" autocomplete="off">
              </div>
            </div>
          </div>
          <div class="col-md-6 m-t-3">
            <div class="row m-b-4">
              <div class="col-sm-1"></div>
              <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*20.71*/Messages("Số điện thoại")),format.raw/*20.96*/("""</label>
              <div class="col-sm-8 input-icons">
                <input id="phoneSearch" type="text" class="form-control input-form" maxlength="11" autocomplete="off">
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="d-flex flex-column align-items-center text-center">
      <div class="">
        <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033; width: 180px;" data-bs-toggle="modal" data-bs-target="#addModal">"""),_display_(/*31.168*/Messages("Thêm user")),format.raw/*31.189*/("""</button>

        <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033; width: 180px;" onclick="resetFormSearch()">"""),_display_(/*33.146*/Messages("Reset")),format.raw/*33.163*/("""</button>
        <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF; width: 180px;" onclick="onlickButtonSearch()">"""),_display_(/*34.149*/Messages("Tra cứu")),format.raw/*34.168*/("""</button>
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
                  DATE: Mon Sep 22 16:32:46 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/userTenant/UserTenantList_search.scala.html
                  HASH: 0e7c9d6ca6350277ae9c9ab74d315da7f9f00f98
                  MATRIX: 1061->0|1163->76|1213->106|1520->386|1556->401|2004->822|2050->847|2607->1376|2650->1397|2834->1553|2873->1570|3059->1728|3100->1747
                  LINES: 33->1|35->3|35->3|43->11|43->11|52->20|52->20|63->31|63->31|65->33|65->33|66->34|66->34
                  -- GENERATED --
              */
          