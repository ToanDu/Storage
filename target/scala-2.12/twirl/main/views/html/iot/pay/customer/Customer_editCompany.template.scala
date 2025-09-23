
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

object Customer_editCompany extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editCompanyModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("Cập nhật thông tin nhà cung cấp")),format.raw/*5.111*/("""</h5>
      </div>
      <div class="modal-body">
        <form class="row g-3">
          <div class="col-md-12">
            <input type="text" id="isUpdateVendor" name="isUpdate" class="form-control" maxlength="30" autocomplete="off" readonly hidden>

            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*13.55*/Messages("Tên")),_display_(/*13.71*/Messages(" *")),format.raw/*13.85*/("""</label>
              <div class="col-sm-8">
                <input type="text" id="nameVendorEdit" class="form-control" maxlength="30" autocomplete="off" required>
                <br>
                <h7 class="textNote">"""),_display_(/*17.39*/Messages("manage.group.org.30char")),format.raw/*17.74*/("""</h7>
              </div>
            </div>

            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*22.55*/Messages("Mã số thuế")),_display_(/*22.78*/Messages(" *")),format.raw/*22.92*/("""</label>
              <div class="col-sm-8">
                <input type="number" id="faxVendorEdit" class="form-control" maxlength="50" autocomplete="off" required>
              </div>
            </div>

            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*29.55*/Messages("Địa chỉ")),_display_(/*29.75*/Messages(" *")),format.raw/*29.89*/("""</label>
              <div class="col-sm-8">
                <input type="text" id="addressVendorEdit" class="form-control" maxlength="255" autocomplete="off" required>
              </div>
            </div>

          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" onclick="updateVendorInfo()"  data-bs-dismiss="modal">"""),_display_(/*39.109*/Messages("btnSave")),format.raw/*39.128*/("""</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*40.82*/Messages("btnClose")),format.raw/*40.102*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/pay/customer/Customer_editCompany.scala.html
                  HASH: 034e77d5a0ecdb6025d4210782558c9a98324389
                  MATRIX: 1062->0|1378->290|1442->333|1813->677|1849->693|1884->707|2136->932|2192->967|2355->1103|2398->1126|2433->1140|2757->1437|2797->1457|2832->1471|3258->1869|3299->1888|3417->1979|3459->1999
                  LINES: 33->1|37->5|37->5|45->13|45->13|45->13|49->17|49->17|54->22|54->22|54->22|61->29|61->29|61->29|71->39|71->39|72->40|72->40
                  -- GENERATED --
              */
          