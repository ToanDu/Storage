
package views.html.telco.account

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

object Account_updateInfoAcc extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="updateInfoAccModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block; background-color: red;">
        <h5 class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.63*/Messages("Xác nhận")),format.raw/*5.83*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">

          <div class="col-12 mt-3">
            <label class="form-label">"""),_display_(/*11.40*/Messages("Nhập mã")),format.raw/*11.59*/("""</label>
            <div class="input-group">
              <input type="number" class="form-control border-end-0" id="optUpdateInfoAcc" maxlength="50">
            </div>
          </div>
          <div class="col-12 mt-3">
            <label class="form-label">"""),_display_(/*17.40*/Messages("Bạn vui lòng nhập OTP được gửi về số điện thoại tài khoản để xác nhận cập nhật thông tin")),format.raw/*17.140*/("""</label>
          </div>

        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" onclick="processUpdateInfoAcc()">"""),_display_(/*23.88*/Messages("btnComfirm")),format.raw/*23.110*/("""</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*24.82*/Messages("btnClose")),format.raw/*24.102*/("""</button>
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
                  DATE: Mon Sep 22 16:32:50 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/account/Account_updateInfoAcc.scala.html
                  HASH: be758d46172470f3617e044f782d3ea3bcc53094
                  MATRIX: 1060->0|1466->380|1506->400|1685->552|1725->571|2017->836|2139->936|2341->1111|2385->1133|2503->1224|2545->1244
                  LINES: 33->1|37->5|37->5|43->11|43->11|49->17|49->17|55->23|55->23|56->24|56->24
                  -- GENERATED --
              */
          