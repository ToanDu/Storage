
package views.html.iot.pay.customer

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

object Customer_edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editCustomerModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("Cập nhật thông tin người dùng")),format.raw/*5.109*/("""</h5>
      </div>
      <div class="modal-body">
        <form class="row g-3">
          <div class="col-md-12">
            <input type="text" id="isUpdate" name="isUpdate" class="form-control" maxlength="30" autocomplete="off" readonly hidden>

            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*13.55*/Messages("ID")),format.raw/*13.69*/("""</label>
              <div class="col-sm-8">
                <input type="text" id="idCustomerEdit" class="form-control" maxlength="30" autocomplete="off" readonly>
              </div>
            </div>

            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*20.55*/Messages("Tên")),_display_(/*20.71*/Messages(" *")),format.raw/*20.85*/("""</label>
              <div class="col-sm-8">
                <input type="text" id="nameCustomerEdit" class="form-control" maxlength="30" autocomplete="off" required>
                <br>
                <h7 class="textNote">"""),_display_(/*24.39*/Messages("manage.group.org.30char")),format.raw/*24.74*/("""</h7>
              </div>
            </div>

            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*29.55*/Messages("Số điện thoại")),_display_(/*29.81*/Messages(" *")),format.raw/*29.95*/("""</label>
              <div class="col-sm-8">
                <input type="number" id="phoneCustomerEdit" class="form-control" maxlength="11" autocomplete="off" required>
              </div>
            </div>

            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*36.55*/Messages("Địa chỉ")),_display_(/*36.75*/Messages(" *")),format.raw/*36.89*/("""</label>
              <div class="col-sm-8">
                <input type="text" id="addressCustomerEdit" class="form-control" maxlength="255" autocomplete="off" required>
              </div>
            </div>

          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" onclick="updateCustomerInfo()"  data-bs-dismiss="modal">"""),_display_(/*46.111*/Messages("btnSave")),format.raw/*46.130*/("""</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*47.82*/Messages("btnClose")),format.raw/*47.102*/("""</button>
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
                  DATE: Mon Sep 22 16:32:45 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/pay/customer/Customer_edit.scala.html
                  HASH: 64d9c7f80dae1073ca6bdf65b996adbb7bca1641
                  MATRIX: 1055->0|1372->291|1434->332|1799->670|1834->684|2157->980|2193->996|2228->1010|2482->1237|2538->1272|2701->1408|2747->1434|2782->1448|3110->1749|3150->1769|3185->1783|3615->2185|3656->2204|3774->2295|3816->2315
                  LINES: 33->1|37->5|37->5|45->13|45->13|52->20|52->20|52->20|56->24|56->24|61->29|61->29|61->29|68->36|68->36|68->36|78->46|78->46|79->47|79->47
                  -- GENERATED --
              */
          