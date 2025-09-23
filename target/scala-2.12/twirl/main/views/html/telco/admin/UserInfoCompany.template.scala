
package views.html.telco.admin

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

object UserInfoCompany extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="infoCompanyModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-fullscreen">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="background-color: red;">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("Duyệt thông tin doanh nghiệp")),format.raw/*5.108*/("""</h5>
      </div>

      <div class="modal-body">
        <input id="idUser" type="text" class="form-control input-form" readonly hidden>
        <label class="col-sm-12 col-form-label title-section-2" style="font-weight: 600;">"""),_display_(/*10.92*/Messages("1. Thông tin cá nhân")),format.raw/*10.124*/("""</label>
        <div class="col-md-12 m-t-3">
          <div class="row" style="">
            <div class="col-md-4">
              <div class="row mb-3">
                <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*15.73*/Messages("Email")),format.raw/*15.90*/("""</label>
                <div class="col-sm-9">
                  <input id="emailUser" type="text" class="form-control input-form" maxlength="255" readonly>
                </div>
              </div>
              <div class="row mb-3">
                <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*21.73*/Messages("Họ tên")),format.raw/*21.91*/("""</label>
                <div class="col-sm-9">
                  <input id="fullNameUser" type="text" class="form-control input-form" maxlength="255" readonly>
                </div>
              </div>
              <div class="row mb-3">
                <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*27.73*/Messages("Số CMT")),format.raw/*27.91*/("""</label>
                <div class="col-sm-9">
                  <input id="cmtUser" type="text" class="form-control input-form" maxlength="255" readonly>
                </div>
              </div>
              <div class="row mb-3">
                <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*33.73*/Messages("SĐT")),format.raw/*33.88*/("""</label>
                <div class="col-sm-9">
                  <input id="phoneUser" type="text" class="form-control input-form" maxlength="255" readonly>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="row mb-3">
                <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*41.73*/Messages("Mặt trước CMT/CCCD")),format.raw/*41.103*/("""</label>
                <div class="col-sm-9 position-relative">
                  <div class="row">
                    <div class="col-md-12 position-relative">
                      <div class="d-flex flex-column align-items-center text-center square-item" >
                        <img src=""""),_display_(/*46.36*/routes/*46.42*/.Assets.versioned("images/market/default.png")),format.raw/*46.88*/("""" id="imgCmtFront" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 60%;object-fit: contain;">
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <div class="row mb-3">
                <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*54.73*/Messages("Giấy ủy quyền")),format.raw/*54.98*/("""</label>
                <div class="col-sm-9 position-relative">
                  <div class="row">
                    <div class="col-md-12 position-relative">
                      <div class="d-flex flex-column align-items-center text-center square-item" >
                        <img src=""""),_display_(/*59.36*/routes/*59.42*/.Assets.versioned("images/market/default.png")),format.raw/*59.88*/("""" id="imgAuthorization" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 60%;object-fit: contain;">
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="row mb-3">
                <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*68.73*/Messages("Mặt sau CMT/CCCD")),format.raw/*68.101*/("""</label>
                <div class="col-sm-9 position-relative">
                  <div class="row">
                    <div class="col-md-12 position-relative">
                      <div class="d-flex flex-column align-items-center text-center square-item" >
                        <img src=""""),_display_(/*73.36*/routes/*73.42*/.Assets.versioned("images/market/default.png")),format.raw/*73.88*/("""" id="imgCmtBack" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 60%;object-fit: contain;">
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <div class="row mb-3">
                <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*81.73*/Messages("Phiếu đăng ký tài khoản")),format.raw/*81.108*/("""</label>
                <div class="col-sm-9 position-relative">
                  <div class="row">
                    <div class="col-md-12 position-relative">
                      <div class="d-flex flex-column align-items-center text-center square-item" >
                        <img src=""""),_display_(/*86.36*/routes/*86.42*/.Assets.versioned("images/market/default.png")),format.raw/*86.88*/("""" id="imgRegistration" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 60%;object-fit: contain;">
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="row mb-3">
              <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*95.71*/Messages("Lý do từ chối")),format.raw/*95.96*/("""</label>
              <div class="col-sm-10">
                <textarea class="form-control" id="descriptionAccount" rows="2" maxlength="500"></textarea>
              </div>
              <label class="col-sm-12 col-form-label title-section-2" id="notiApprovedAccount"></label>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-success" id="buttonApproved" onclick="processComfirmInfoAccount('APPROVED')">"""),_display_(/*102.130*/Messages("btnComfirm")),format.raw/*102.152*/("""</button>
              <button type="button" class="btn btn-danger" id="buttonRejected" onclick="processComfirmInfoAccount('REJECTED')">"""),_display_(/*103.129*/Messages("Từ chối")),format.raw/*103.148*/("""</button>
              <button type="button" class="btn btn-secondary" onclick="closeModal()" data-bs-dismiss="modal">"""),_display_(/*104.111*/Messages("Đóng")),format.raw/*104.127*/("""</button>
            </div>
          </div>

          <label class="col-sm-12 col-form-label title-section-2 m-t-3" style="font-weight: 600;">"""),_display_(/*108.100*/Messages("2. Thông tin doanh nghiệp")),format.raw/*108.137*/("""</label>
          <div id="tab_info_company">

          </div>

        </div>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/admin/UserInfoCompany.scala.html
                  HASH: ea553fb3fd5bca5f7b289bdf63bbd60946f7a138
                  MATRIX: 1052->0|1442->364|1503->404|1760->634|1814->666|2069->894|2107->911|2445->1222|2484->1240|2825->1554|2864->1572|3200->1881|3236->1896|3628->2261|3680->2291|4005->2589|4020->2595|4087->2641|4462->2989|4508->3014|4833->3312|4848->3318|4915->3364|5348->3770|5398->3798|5723->4096|5738->4102|5805->4148|6179->4495|6236->4530|6561->4828|6576->4834|6643->4880|7037->5247|7083->5272|7579->5739|7624->5761|7791->5899|7833->5918|7982->6038|8021->6054|8196->6200|8256->6237
                  LINES: 33->1|37->5|37->5|42->10|42->10|47->15|47->15|53->21|53->21|59->27|59->27|65->33|65->33|73->41|73->41|78->46|78->46|78->46|86->54|86->54|91->59|91->59|91->59|100->68|100->68|105->73|105->73|105->73|113->81|113->81|118->86|118->86|118->86|127->95|127->95|134->102|134->102|135->103|135->103|136->104|136->104|140->108|140->108
                  -- GENERATED --
              */
          