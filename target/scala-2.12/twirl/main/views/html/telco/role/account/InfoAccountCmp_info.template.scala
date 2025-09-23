
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

object InfoAccountCmp_info extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="infoAccountModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.65*/Messages("Thông tin tài khoản")),format.raw/*5.96*/("""</span>
      </div>

      <div class="modal-body">
        <div class="row g-3">
          <span style="font-weight: 700;font-size: 16px;">"""),_display_(/*10.60*/Messages("1. Thông tin cá nhân")),format.raw/*10.92*/("""</span>
          <div class="row">
            <div class="col-md-6">
              <div class="row mt-3">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*14.73*/Messages("Email")),format.raw/*14.90*/("""</label>
                <div class="col-sm-8">
                  <input id="emailInfo" type="text" class="form-control input-form" readonly>
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div class="row mt-3">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*22.73*/Messages("Họ tên")),format.raw/*22.91*/("""</label>
                <div class="col-sm-8">
                  <input id="fullnameInfo" type="text" class="form-control input-form" readonly>
                </div>
              </div>
            </div>
          </div>

          <div class="row">
            <div class="col-md-6">
              <div class="row mt-3">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*33.73*/Messages("Số điện thoại")),format.raw/*33.98*/("""</label>
                <div class="col-sm-8">
                  <input id="phoneInfo" type="text" class="form-control input-form" readonly>
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div class="row mt-3">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*41.73*/Messages("Quyền TK")),format.raw/*41.93*/("""</label>
                <div class="col-sm-8">
                  <input id="roleInfo" type="text" class="form-control input-form" readonly>
                </div>
              </div>
            </div>
          </div>

          <div class="row">
            <div class="col-md-6">
              <div class="row mt-3">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*52.73*/Messages("CMT/CCCD")),format.raw/*52.93*/("""</label>
                <div class="col-sm-8">
                  <input id="cmtInfo" type="text" class="form-control input-form" readonly>
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div class="row mt-3">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*60.73*/Messages("Ngày sinh")),format.raw/*60.94*/("""</label>
                <div class="col-sm-8">
                  <input id="ngaysinhInfo" type="text" class="form-control input-form" readonly>
                </div>
              </div>
            </div>
          </div>

          <div class="row">
            <div class="col-md-12">
              <div class="row mt-3">
                <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*71.73*/Messages("Địa chỉ chi tiết")),format.raw/*71.101*/("""</label>
                <div class="col-sm-10">
                  <div class="row">
                    <div class="col-sm-4">
                      <input id="tinhTp" type="text" class="form-control input-form" readonly>
                    </div>
                    <div class="col-sm-4" >
                      <input id="quanHuyen" type="text" class="form-control input-form" readonly>
                    </div>
                    <div class="col-sm-4">
                      <input id="phuongXa" type="text" class="form-control input-form" readonly>
                    </div>
                    <div class="col-sm-12 mt-3">
                      <input id="diaChiChiTiet" type="text" class="form-control input-form" readonly>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="row mt-3">
          <span style="font-weight: 700;font-size: 16px;">"""),_display_(/*94.60*/Messages("2. Thông tin doanh nghiệp")),format.raw/*94.97*/("""</span>
          <div class="row">
            <div class="col-md-8">
              <div class="row mt-3">
                <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*98.73*/Messages("Tên DN")),format.raw/*98.91*/("""</label>
                <div class="col-sm-10">
                  <input id="tenDoanhNghiep" type="text" class="form-control input-form" maxlength="250" readonly>
                </div>
              </div>
              <div class="row mt-3">
                <div class="col-sm-6">
                  <div class="row">
                    <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*106.77*/Messages("Mã số thuế")),format.raw/*106.99*/("""</label>
                    <div class="col-sm-8">
                      <input id="maSoThue" type="text" class="form-control input-form" maxlength="250" readonly>
                    </div>
                  </div>
                </div>
                <div class="col-sm-6">
                  <div class="row">
                    <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*114.77*/Messages("Số GPKD")),format.raw/*114.96*/("""</label>
                    <div class="col-sm-8">
                      <input id="soGpkd" type="text" class="form-control input-form" maxlength="250" readonly>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row mt-3">
                <div class="col-sm-6">
                  <div class="row">
                    <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*124.77*/Messages("Ngày thành lập")),format.raw/*124.103*/("""</label>
                    <div class="col-sm-8">
                      <input id="ngayThanhLap" type="text" class="form-control input-form" maxlength="250" readonly>
                    </div>
                  </div>
                </div>
                <div class="col-sm-6">
                  <div class="row">
                    <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*132.77*/Messages("Số điện thoại DN")),format.raw/*132.105*/("""</label>
                    <div class="col-sm-8">
                      <input id="sdtDN" type="number" class="form-control input-form" readonly>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row mt-3">
                <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*140.73*/Messages("Email DN")),format.raw/*140.93*/("""</label>
                <div class="col-sm-10">
                  <input id="emailDN" type="text" class="form-control input-form" maxlength="250" readonly>
                </div>
              </div>
              <div class="row mt-3">
                <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*146.73*/Messages("Địa chỉ")),format.raw/*146.92*/("""</label>
                <div class="col-sm-10">
                  <div class="row">
                    <div class="col-sm-4">
                      <input id="tinhTpDN" type="text" class="form-control input-form" maxlength="250" readonly>
                    </div>
                    <div class="col-sm-4">
                      <input id="quanHuyenDN" type="text" class="form-control input-form" maxlength="250" readonly>
                    </div>
                    <div class="col-sm-4">
                      <input id="phuongXaDN" type="text" class="form-control input-form" maxlength="250" readonly>
                    </div>
                    <div class="col-sm-12 mt-3">
                      <input id="diaChiChiTietDN" type="text" class="form-control input-form" maxlength="250" readonly>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row">
                <label class="col-sm-12 col-form-label title-section-2" id="notiApproved"></label>
              </div>
            </div>

            <div class="col-md-4">
              <div class="row mt-3">
                <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*171.73*/Messages("Ảnh GPKD")),format.raw/*171.93*/("""</label>
                <div class="col-sm-9 position-relative">
                  <div class="row">
                    <div class="col-md-12 position-relative">
                      <div class="d-flex flex-column align-items-center text-center square-item" >
                        <img src=""""),_display_(/*176.36*/routes/*176.42*/.Assets.versioned("images/market/default.png")),format.raw/*176.88*/("""" id="wizardPicturePreview" onclick="zoomImg(this)" alt="img" class="p-1 zoom" style="width: 100%;object-fit: contain;">
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*189.79*/Messages("btnClose")),format.raw/*189.99*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/account/InfoAccountCmp_info.scala.html
                  HASH: bb59feee4a2c25fd8c44428f46bbf01a2bcea8e8
                  MATRIX: 1063->0|1497->408|1548->439|1717->581|1770->613|1977->793|2015->810|2391->1159|2430->1177|2855->1575|2901->1600|3277->1949|3318->1969|3739->2363|3780->2383|4154->2730|4196->2751|4622->3150|4672->3178|5674->4153|5732->4190|5939->4370|5978->4388|6402->4784|6446->4806|6865->5197|6906->5216|7381->5663|7430->5689|7853->6084|7904->6112|8285->6465|8327->6485|8665->6795|8706->6814|9954->8034|9996->8054|10322->8352|10338->8358|10406->8404|10857->8827|10899->8847
                  LINES: 33->1|37->5|37->5|42->10|42->10|46->14|46->14|54->22|54->22|65->33|65->33|73->41|73->41|84->52|84->52|92->60|92->60|103->71|103->71|126->94|126->94|130->98|130->98|138->106|138->106|146->114|146->114|156->124|156->124|164->132|164->132|172->140|172->140|178->146|178->146|203->171|203->171|208->176|208->176|208->176|221->189|221->189
                  -- GENERATED --
              */
          