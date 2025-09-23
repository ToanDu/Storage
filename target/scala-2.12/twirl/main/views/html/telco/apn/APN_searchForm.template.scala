
package views.html.telco.apn

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

object APN_searchForm extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="card" id="searchAPNCard">
  <div class="card-body">
    <span class="text-search">"""),_display_(/*3.32*/Messages("apn.searchInfo")),format.raw/*3.58*/("""</span>
    <input id="gpkd" type="text" class="form-control" readonly hidden>

    <div class="row mt-3">
      <div class="col-md-9">
        <div class="row">
          <div class="col-md-6 m-t-3">
            <div class="row m-b-4" id="apn-phoneNumber-field">
              <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*11.71*/Messages("apn.subscriberNumber")),format.raw/*11.103*/("""</label>
              <div class="col-sm-8 input-icons">
                <div class="input-group">
                  <input name="telephoneNumber" type="text" class="form-control input-form text-darker" style="border-right: 0px;" placeholder=""""),_display_(/*14.146*/Messages("apn.searchPlaceholder")),format.raw/*14.179*/("""" onkeypress="return isNumberKey(event)" maxlength="12" required>
                  <a class="input-group-text cursor-pointer" style="border-left: 0px; background-color: #ffffff">
                    <img src=""""),_display_(/*16.32*/routes/*16.38*/.Assets.versioned("images/telco/search.png")),format.raw/*16.82*/("""" class="" alt="..." >
                  </a>
                </div>
                <div class="helper-text form-text text-danger mt-2" style="min-height: 14px;"></div>
              </div>
            </div>
          </div>
     
        </div>
      </div>
    </div>
    <div class="d-flex justify-content-center align-items-center gap-3 action-pannel">
        <button type="button" class="mt-3 btn_cmp is-primary fs-6 fw-bold" onclick="handleSearchAPN()">"""),_display_(/*28.105*/Messages("apn.searchButton")),format.raw/*28.133*/("""</button>
        <button type="button" class="btn_cmp is-outline mt-3 fs-6 fw-bold" data-bs-toggle="modal" data-bs-target="#exportAPNModal">"""),_display_(/*29.133*/Messages("apn.exportButton")),format.raw/*29.161*/("""</button>
        <button type="button" class="btn_cmp is-outline mt-3 fs-6 fw-bold" onclick="resetAll()">"""),_display_(/*30.98*/Messages("apn.resetButton")),format.raw/*30.125*/("""</button>
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
                  DATE: Mon Sep 22 16:32:50 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/apn/APN_searchForm.scala.html
                  HASH: 2f48dfd63f5af002733313f90a8bbf21a3db31ca
                  MATRIX: 1049->0|1170->95|1216->121|1577->455|1631->487|1904->732|1959->765|2197->976|2212->982|2277->1026|2768->1489|2818->1517|2988->1659|3038->1687|3172->1794|3221->1821
                  LINES: 33->1|35->3|35->3|43->11|43->11|46->14|46->14|48->16|48->16|48->16|60->28|60->28|61->29|61->29|62->30|62->30
                  -- GENERATED --
              */
          