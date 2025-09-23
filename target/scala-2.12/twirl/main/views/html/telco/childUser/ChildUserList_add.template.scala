
package views.html.telco.childUser

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

object ChildUserList_add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addChildUserModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.65*/Messages("Tạo user")),format.raw/*5.85*/("""</span>
      </div>
      <div class="modal-body">
        <div class="row mt-3">
          <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*9.67*/Messages("Họ tên")),format.raw/*9.85*/("""</label>
          <div class="col-sm-8">
            <input id="fullNameAdd" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="50">
          </div>
        </div>

        <div class="row mt-3">
          <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*16.67*/Messages("Email")),format.raw/*16.84*/("""</label>
          <div class="col-sm-8">
            <input id="emailAdd" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="50">
          </div>
        </div>

        <div class="row mt-3">
          <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*23.67*/Messages("Số điện thoại")),format.raw/*23.92*/("""</label>
          <div class="col-sm-8">
            <input id="phoneAdd" type="text" class="form-control input-form" placeholder="Nhập nội dung" onkeypress="return isNumberKey(event)" maxlength="11">
          </div>
        </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" data-bs-dismiss="modal" onClick="closeFormAdd()">"""),_display_(/*31.104*/Messages("btnCancle")),format.raw/*31.125*/("""</button>
        <button type="button" class="btn btn-red" onclick="processSubmitAddChildUser(userId)">"""),_display_(/*32.96*/Messages("btnComfirm")),format.raw/*32.118*/("""</button>
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
                  DATE: Mon Sep 22 16:32:51 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/childUser/ChildUserList_add.scala.html
                  HASH: de80c5e85c546f028d1be5b108b81706f2298f9f
                  MATRIX: 1058->0|1484->400|1524->420|1699->569|1737->587|2060->883|2098->900|2418->1193|2464->1218|2876->1602|2919->1623|3051->1728|3095->1750
                  LINES: 33->1|37->5|37->5|41->9|41->9|48->16|48->16|55->23|55->23|63->31|63->31|64->32|64->32
                  -- GENERATED --
              */
          