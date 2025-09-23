
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

object AccountList_info extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="infoAccountModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.65*/Messages("Thông tin tài khoản")),format.raw/*5.96*/("""</span>
      </div>

      <div class="modal-body">
        <div class="row g-3">
          """),format.raw/*10.100*/("""

          """),format.raw/*12.11*/("""<div class="row mt-3">
            <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*13.69*/Messages("Email")),format.raw/*13.86*/("""</label>
            <div class="col-sm-8">
              <input id="emailInfo" type="text" class="form-control input-form">
            </div>
          </div>
          <div class="row mt-3">
            <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*19.69*/Messages("Họ tên")),format.raw/*19.87*/("""</label>
            <div class="col-sm-8">
              <input id="fullnameInfo" type="text" class="form-control input-form">
            </div>
          </div>
          <div class="row mt-3">
            <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*25.69*/Messages("Số điện thoại")),format.raw/*25.94*/("""</label>
            <div class="col-sm-8">
              <input id="phoneInfo" type="text" class="form-control input-form">
            </div>
          </div>
          <div class="row mt-3">
            <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*31.69*/Messages("Quyền TK")),format.raw/*31.89*/("""</label>
            <div class="col-sm-8">
              <input id="roleInfo" type="text" class="form-control input-form">
            </div>
          </div>
            <div class="row mt-3">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*37.73*/Messages("Tỉnh/ TP")),format.raw/*37.93*/("""</label>
                <div class="col-sm-8">
                    <input id="tinhTP" type="text" class="form-control input-form">
                </div>
            </div>
            <div class="row mt-3">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*43.73*/Messages("Huyện/ Quận")),format.raw/*43.96*/("""</label>
                <div class="col-sm-8">
                    <input id="quanHuyen" type="text" class="form-control input-form">
                </div>
            </div>
            <div class="row mt-3">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*49.73*/Messages("Phường/Xã")),format.raw/*49.94*/("""</label>
                <div class="col-sm-8">
                    <input id="phuongXa" type="text" class="form-control input-form">
                </div>
            </div>
            <div class="row mt-3">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*55.73*/Messages("Địa chỉ chi tiết")),format.raw/*55.101*/("""</label>
                <div class="col-sm-8">
                    <input id="diaChiChiTiet" type="text" class="form-control input-form">
                </div>
            </div>

        </div>
      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*65.79*/Messages("btnClose")),format.raw/*65.99*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/account/AccountList_info.scala.html
                  HASH: 8dc3b0970c4cb22522703607efc99dd54a92e6cd
                  MATRIX: 1060->0|1494->408|1545->439|1667->621|1707->633|1825->724|1863->741|2152->1003|2191->1021|2483->1286|2529->1311|2818->1573|2859->1593|3153->1860|3194->1880|3502->2161|3546->2184|3857->2468|3899->2489|4209->2772|4259->2800|4608->3122|4649->3142
                  LINES: 33->1|37->5|37->5|42->10|44->12|45->13|45->13|51->19|51->19|57->25|57->25|63->31|63->31|69->37|69->37|75->43|75->43|81->49|81->49|87->55|87->55|97->65|97->65
                  -- GENERATED --
              */
          