
package views.html.telco.role.account

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

object AccountList_add_enterprise extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="infoEnterpriseModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.65*/Messages("Thêm thông tin doanh nghiệp")),format.raw/*5.104*/("""</span>
      </div>
      <div class="modal-body">
        <div class="row mt-3">
          <div class="row">
            <div class="col-md-12">
              <div class="row mt-3">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*12.73*/Messages("Tên doanh nghiệp")),format.raw/*12.101*/("""</label>
                <div class="col-sm-8">
                  <input id="nameEnterprise" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="50">
                </div>
              </div>
            </div>
            <div class="col-md-12">
              <div class="row mt-3">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*20.73*/Messages("GPKD")),format.raw/*20.89*/("""</label>
                <div class="col-sm-8">
                  <input id="gpkdEnterprise" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="50">
                </div>
              </div>
            </div>

          </div>
        </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" onclick="hideAddInfoEnterprise()">"""),_display_(/*32.89*/Messages("btnCancle")),format.raw/*32.110*/("""</button>
        <button type="button" class="btn btn-red" onclick="comfirmAddInfoEnterprise()">"""),_display_(/*33.89*/Messages("btnComfirm")),format.raw/*33.111*/("""</button>
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
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/account/AccountList_add_enterprise.scala.html
                  HASH: bd5e1f7a1af9e90b729213e0da8a736670e7976d
                  MATRIX: 1070->0|1507->411|1567->450|1850->706|1900->734|2316->1123|2353->1139|2792->1551|2835->1572|2960->1670|3004->1692
                  LINES: 33->1|37->5|37->5|44->12|44->12|52->20|52->20|64->32|64->32|65->33|65->33
                  -- GENERATED --
              */
          