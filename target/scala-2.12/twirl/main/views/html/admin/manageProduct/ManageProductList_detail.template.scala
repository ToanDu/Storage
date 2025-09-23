
package views.html.admin.manageProduct

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

object ManageProductList_detail extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="detailConfirmModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("Chi tiết sản phẩm")),format.raw/*5.97*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">

          <div class="col-md-7">
            <input id="idProduct" type="text" class="form-control" hidden>
            <div class="row mb-0">
              <label class="col-sm-12 col-form-label" >"""),_display_(/*13.57*/Messages("Mã sản phẩm")),format.raw/*13.80*/("""<p class="fw-bold" id="codeProduct"></p></label>
            </div>
            <div class="row mb-0">
              <label class="col-sm-12 col-form-label" id="">"""),_display_(/*16.62*/Messages("Tên sản phẩm")),format.raw/*16.86*/("""<p class="fw-bold" id="nameProduct"></p></label>
            </div>
            <div class="row mb-0">
              <label class="col-sm-12 col-form-label" id="">"""),_display_(/*19.62*/Messages("Giá (VND)")),format.raw/*19.83*/("""<p class="fw-bold" id="priceProduct"></p></label>
            </div>
            <div class="row mb-0">
              <label class="col-sm-12 col-form-label" id="">"""),_display_(/*22.62*/Messages("Nhóm sản phẩm")),format.raw/*22.87*/("""<p class="fw-bold" id="groupProduct"></p></label>
            </div>
            <div class="row mb-0">
              <label class="col-sm-12 col-form-label" id="">"""),_display_(/*25.62*/Messages("Hiển thị")),format.raw/*25.82*/("""<p class="fw-bold" id="showProduct"></p></label>
            </div>
            <div class="row mb-0">
              <label class="col-sm-12 col-form-label" id="">"""),_display_(/*28.62*/Messages("Giới thiệu sản phẩm")),format.raw/*28.93*/("""<p class="fw-bold" id="infoProduct"></p></label>
            </div>
            <div class="row mb-0">
              <label class="col-sm-12 col-form-label" id="">"""),_display_(/*31.62*/Messages("Mô tả sản phẩm")),format.raw/*31.88*/("""<p class="fw-bold" id="contentProduct"></p></label>
            </div>
            <div class="row mb-0">
              <label class="col-sm-12 col-form-label" id="">"""),_display_(/*34.62*/Messages("Thông tin người hỗ trợ bán hàng")),format.raw/*34.105*/("""<p class="fw-bold" id="supportPersionProduct"></p></label>
            </div>
            <div class="row mb-0">
              <label class="col-sm-12 col-form-label" id="">"""),_display_(/*37.62*/Messages("Giải pháp đi kèm sản phẩm")),format.raw/*37.99*/("""<p class="fw-bold" id="solutionProduct"></p></label>
            </div>
          </div>

          <div class="col-md-5">
            <div class="col-md-12 position-relative">
              <label class="form-label">"""),_display_(/*43.42*/Messages("manage.group.img")),format.raw/*43.70*/("""</label>
              <div class="d-flex flex-column align-items-center text-center" style="border: 1px solid;">
                <img src=""""),_display_(/*45.28*/routes/*45.34*/.Assets.versioned("images/iotplatform.png")),format.raw/*45.77*/("""" id="wizardPicturePreview" alt="Admin" class="p-1" style="margin: 10px;width: 95%;">
                <input id="wizard-picture-edit" name="avatar" type="file" hidden/>
              </div>
            </div>

            <div class="row mb-1">
              <label class="col-sm-12 col-form-label">"""),_display_(/*51.56*/Messages("Trạng thái:")),format.raw/*51.79*/("""</label>
              <div class="col-sm-12">
                <select id="statusApproveDetail" class="form-select">
                  <option value="0">"""),_display_(/*54.38*/Messages("Mới khởi tạo")),format.raw/*54.62*/("""</option>
                  <option value="1">"""),_display_(/*55.38*/Messages("Duyệt")),format.raw/*55.55*/("""</option>
                  <option value="2">"""),_display_(/*56.38*/Messages("Từ chối")),format.raw/*56.57*/("""</option>
                  <option value="3">"""),_display_(/*57.38*/Messages("Chờ duyệt")),format.raw/*57.59*/("""</option>
                </select>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-12 col-form-label">"""),_display_(/*62.56*/Messages("Lý do từ chối duyệt:")),format.raw/*62.88*/("""</label>
              <div class="col-sm-12">
                <textarea class="form-control" id="contentApproveDetail" maxlength="500" rows="3" placeholder="...tối đa 500 kí tự"></textarea>
              </div>
            </div>
            <div class="row mb-1">
              <label class="col-sm-12 col-form-label" >"""),_display_(/*68.57*/Messages("Ngày tạo: ")),format.raw/*68.79*/("""<p class="fw-bold" id="logDate"></p></label>
            </div>
            <div class="row mb-1">
              <label class="col-sm-12 col-form-label" >"""),_display_(/*71.57*/Messages("Cập nhật lần cuối: ")),format.raw/*71.88*/("""<p class="fw-bold" id="updateDate"></p></label>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-danger" onclick="processChangeStatusProduct()" data-bs-dismiss="modal">"""),_display_(/*74.124*/Messages("btnUpdate")),format.raw/*74.145*/("""</button>
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*75.88*/Messages("btnClose")),format.raw/*75.108*/("""</button>
            </div>
          </div>

        </div>
      </div>

    </div>
  </div> <!-- modal-bialog .// -->
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
                  DATE: Mon Sep 22 16:32:40 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/admin/manageProduct/ManageProductList_detail.scala.html
                  HASH: 8477da3f00365cf33175be481354f81bb4a9f58e
                  MATRIX: 1069->0|1439->344|1488->373|1791->649|1835->672|2026->836|2071->860|2262->1024|2304->1045|2496->1210|2542->1235|2734->1400|2775->1420|2966->1584|3018->1615|3209->1779|3256->1805|3450->1972|3515->2015|3716->2189|3774->2226|4019->2444|4068->2472|4236->2613|4251->2619|4315->2662|4642->2962|4686->2985|4867->3139|4912->3163|4986->3210|5024->3227|5098->3274|5138->3293|5212->3340|5254->3361|5447->3527|5500->3559|5849->3881|5892->3903|6074->4058|6126->4089|6383->4318|6426->4339|6550->4436|6592->4456
                  LINES: 33->1|37->5|37->5|45->13|45->13|48->16|48->16|51->19|51->19|54->22|54->22|57->25|57->25|60->28|60->28|63->31|63->31|66->34|66->34|69->37|69->37|75->43|75->43|77->45|77->45|77->45|83->51|83->51|86->54|86->54|87->55|87->55|88->56|88->56|89->57|89->57|94->62|94->62|100->68|100->68|103->71|103->71|106->74|106->74|107->75|107->75
                  -- GENERATED --
              */
          