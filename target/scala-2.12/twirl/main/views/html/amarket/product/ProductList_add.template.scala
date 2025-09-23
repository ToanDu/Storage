
package views.html.amarket.product

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

object ProductList_add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addProductModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-fullscreen">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("Tạo mới sản phẩm")),format.raw/*5.96*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-7">
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*11.55*/Messages("* Tên sản phẩm")),format.raw/*11.81*/("""</label>
              <div class="col-sm-8">
                <input id="nameProductAdd" type="text" class="form-control" maxlength="255" autocomplete="off" placeholder="...tối đa 255 kí tự">
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*17.55*/Messages("* Giới thiệu sản phẩm")),format.raw/*17.88*/("""</label>
              <div class="col-sm-8">
                <textarea class="form-control" id="infoProductAdd" maxlength="500" rows="2" placeholder="...tối đa 500 kí tự"></textarea>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*23.55*/Messages("* Mô tả sản phẩm")),format.raw/*23.83*/("""</label>
              <div class="col-sm-8">
                <textarea class="form-control" id="contentProductAdd" maxlength="5000" rows="5" placeholder="...tối đa 5000 kí tự"></textarea>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*29.55*/Messages("Tính năng nổi bật")),format.raw/*29.84*/("""</label>
              <div class="col-sm-8">
                <textarea class="form-control" id="featureProductAdd" maxlength="1000" rows="3" placeholder="...tối đa 1000 kí tự"></textarea>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*35.55*/Messages("Link tài liệu")),format.raw/*35.80*/("""</label>
              <div class="col-sm-8">
                <textarea class="form-control" id="linkDocsProductAdd" maxlength="500" rows="2" placeholder="...tối đa 500 kí tự"></textarea>
              </div>
            </div>
          </div>

          <div class="col-md-5">
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*44.55*/Messages("Mã SP")),format.raw/*44.72*/("""</label>
              <div class="col-sm-9">
                <input id="codeProductAdd" type="text" class="form-control" maxlength="50" autocomplete="off" placeholder="...tối đa 50 kí tự">
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*50.55*/Messages("* Phân loại")),format.raw/*50.78*/("""</label>
              <div class="col-sm-9" id="selectGroupProductAdd">
                <select id="typeGroupProductAdd" class="form-select" onchange="selectGroupProductAdd()">
                  <option value="0">"""),_display_(/*53.38*/Messages("Thiết bị")),format.raw/*53.58*/("""</option>
                  <option value="1">"""),_display_(/*54.38*/Messages("Giải pháp")),format.raw/*54.59*/("""</option>
                </select>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*59.55*/Messages("* Nhóm sản phẩm")),format.raw/*59.82*/("""</label>
              <div class="col-sm-9" id="selectGroupProductAdd">
                <select id="groupProductAdd" class="form-select"></select>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*65.55*/Messages("Hiển thị")),format.raw/*65.75*/("""</label>
              <div class="col-sm-9">
                <select id="showProductAdd" class="form-select">
                  <option value="true" selected>"""),_display_(/*68.50*/Messages("Hiện")),format.raw/*68.66*/("""</option>
                  <option value="false">"""),_display_(/*69.42*/Messages("Ẩn")),format.raw/*69.56*/("""</option>
                </select>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*74.55*/Messages("Giá (VND)")),format.raw/*74.76*/("""</label>
              <div class="col-sm-9">
                <input id="priceProductAdd" type="number" class="form-control" value="0">
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*80.55*/Messages("Giải pháp đi kèm sản phẩm")),format.raw/*80.92*/("""</label>
              <div class="col-sm-9">
                <textarea class="form-control" id="solutionAdd" maxlength="500" rows="2" placeholder="...tối đa 500 kí tự"></textarea>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*86.55*/Messages("Thông tin người hỗ trợ bán hàng")),format.raw/*86.98*/("""</label>
              <div class="col-sm-9">
                <textarea class="form-control" id="supportPersionAdd" maxlength="500" rows="2" placeholder="...tối đa 500 kí tự"></textarea>
              </div>
            </div>
          </div>

          <div class="col-md-12">
            <div class="row">
              <div class="col-md-2 position-relative">
                <label class="form-label">"""),_display_(/*96.44*/Messages("* Ảnh đại diện")),format.raw/*96.70*/("""</label>
                <div class="d-flex flex-column align-items-center text-center" style="border: 1px solid;">
                  <img src=""""),_display_(/*98.30*/routes/*98.36*/.Assets.versioned("images/market/default.png")),format.raw/*98.82*/("""" id="wizardPicturePreview" alt="Admin" class="p-1" style="margin: 10px;width: 95%;">
                  <input id="wizard-picture" name="avatar" type="file" hidden/>

                  <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImage()"></i></div>
                </div>
                <div class="d-flex align-items-center cursor-pointer" onclick="$('#wizard-picture').click();">
                  <div class="font-22 text-black-50">
                    <i class="fadeIn animated bx bx-upload"></i>
                  </div>
                  <div class="ms-2">"""),_display_(/*107.38*/Messages("Tải ảnh đại diện")),format.raw/*107.66*/("""</div>
                </div>
              </div>

              <div class="col-md-2 position-relative">
                <label class="form-label">"""),_display_(/*112.44*/Messages("Hình ảnh 1")),format.raw/*112.66*/("""</label>
                <div class="d-flex flex-column align-items-center text-center" style="border: 1px solid;">
                  <img src=""""),_display_(/*114.30*/routes/*114.36*/.Assets.versioned("images/market/default.png")),format.raw/*114.82*/("""" id="wizardPicturePreview1" alt="Admin" class="p-1" style="margin: 10px;width: 95%;">
                  <input id="wizard-picture-1" name="avatar" type="file" hidden/>
                  <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg1" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(1)"></i></div>
                </div>
                <div class="d-flex align-items-center cursor-pointer" onclick="$('#wizard-picture-1').click();">
                  <div class="font-22 text-black-50">
                    <i class="fadeIn animated bx bx-upload"></i>
                  </div>
                  <div class="ms-2">"""),_display_(/*122.38*/Messages("Tải ảnh 1")),format.raw/*122.59*/("""</div>
                </div>
              </div>

              <div class="col-md-2 position-relative">
                <label class="form-label">"""),_display_(/*127.44*/Messages("Hình ảnh 2")),format.raw/*127.66*/("""</label>
                <div class="d-flex flex-column align-items-center text-center" style="border: 1px solid;">
                  <img src=""""),_display_(/*129.30*/routes/*129.36*/.Assets.versioned("images/market/default.png")),format.raw/*129.82*/("""" id="wizardPicturePreview2" alt="Admin" class="p-1" style="margin: 10px;width: 95%;">
                  <input id="wizard-picture-2" name="avatar" type="file" hidden/>
                  <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg2" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(2)"></i></div>
                </div>
                <div class="d-flex align-items-center cursor-pointer" onclick="$('#wizard-picture-2').click();">
                  <div class="font-22 text-black-50">
                    <i class="fadeIn animated bx bx-upload"></i>
                  </div>
                  <div class="ms-2">"""),_display_(/*137.38*/Messages("Tải ảnh 2")),format.raw/*137.59*/("""</div>
                </div>
              </div>

              <div class="col-md-2 position-relative">
                <label class="form-label">"""),_display_(/*142.44*/Messages("Hình ảnh 3")),format.raw/*142.66*/("""</label>
                <div class="d-flex flex-column align-items-center text-center" style="border: 1px solid;">
                  <img src=""""),_display_(/*144.30*/routes/*144.36*/.Assets.versioned("images/market/default.png")),format.raw/*144.82*/("""" id="wizardPicturePreview3" alt="Admin" class="p-1" style="margin: 10px;width: 95%;">
                  <input id="wizard-picture-3" name="avatar" type="file" hidden/>
                  <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg3" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(3)"></i></div>
                </div>
                <div class="d-flex align-items-center cursor-pointer" onclick="$('#wizard-picture-3').click();">
                  <div class="font-22 text-black-50">
                    <i class="fadeIn animated bx bx-upload"></i>
                  </div>
                  <div class="ms-2">"""),_display_(/*152.38*/Messages("Tải ảnh 3")),format.raw/*152.59*/("""</div>
                </div>
              </div>

              <div class="col-md-2 position-relative">
                <label class="form-label">"""),_display_(/*157.44*/Messages("Hình ảnh 4")),format.raw/*157.66*/("""</label>
                <div class="d-flex flex-column align-items-center text-center" style="border: 1px solid;">
                  <img src=""""),_display_(/*159.30*/routes/*159.36*/.Assets.versioned("images/market/default.png")),format.raw/*159.82*/("""" id="wizardPicturePreview4" alt="Admin" class="p-1" style="margin: 10px;width: 95%;">
                  <input id="wizard-picture-4" name="avatar" type="file" hidden/>
                  <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg4" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(4)"></i></div>
                </div>
                <div class="d-flex align-items-center cursor-pointer" onclick="$('#wizard-picture-4').click();">
                  <div class="font-22 text-black-50">
                    <i class="fadeIn animated bx bx-upload"></i>
                  </div>
                  <div class="ms-2">"""),_display_(/*167.38*/Messages("Tải ảnh 4")),format.raw/*167.59*/("""</div>
                </div>
              </div>

              <div class="col-md-2 position-relative">
                <label class="form-label">"""),_display_(/*172.44*/Messages("Hình ảnh 5")),format.raw/*172.66*/("""</label>
                <div class="d-flex flex-column align-items-center text-center" style="border: 1px solid;">
                  <img src=""""),_display_(/*174.30*/routes/*174.36*/.Assets.versioned("images/market/default.png")),format.raw/*174.82*/("""" id="wizardPicturePreview5" alt="Admin" class="p-1" style="margin: 10px;width: 95%;">
                  <input id="wizard-picture-5" name="avatar" type="file" hidden/>
                  <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg5" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(5)"></i></div>
                </div>
                <div class="d-flex align-items-center cursor-pointer" onclick="$('#wizard-picture-5').click();">
                  <div class="font-22 text-black-50">
                    <i class="fadeIn animated bx bx-upload"></i>
                  </div>
                  <div class="ms-2">"""),_display_(/*182.38*/Messages("Tải ảnh 5")),format.raw/*182.59*/("""</div>
                </div>
              </div>

            </div>
            <small>"""),_display_(/*187.21*/Messages("manage.group.upImageNote")),format.raw/*187.57*/("""</small>

            <div class="modal-footer">
              <button type="button" class="btn btn-danger" onclick="postDataCreateProduct()">"""),_display_(/*190.95*/Messages("btnSave")),format.raw/*190.114*/("""</button>
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*191.88*/Messages("btnClose")),format.raw/*191.108*/("""</button>
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
                  DATE: Mon Sep 22 16:32:41 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/amarket/product/ProductList_add.scala.html
                  HASH: 453ee75adaa47ae181959604498d231421a5a119
                  MATRIX: 1056->0|1457->375|1505->403|1730->601|1777->627|2125->948|2179->981|2519->1294|2568->1322|2913->1640|2963->1669|3308->1987|3354->2012|3749->2380|3787->2397|4133->2716|4177->2739|4419->2954|4460->2974|4534->3021|4576->3042|4768->3207|4816->3234|5120->3511|5161->3531|5348->3691|5385->3707|5463->3758|5498->3772|5690->3937|5732->3958|6024->4223|6082->4260|6419->4570|6483->4613|6917->5020|6964->5046|7136->5191|7151->5197|7218->5243|7914->5911|7964->5939|8142->6089|8186->6111|8359->6256|8375->6262|8443->6308|9151->6988|9194->7009|9372->7159|9416->7181|9589->7326|9605->7332|9673->7378|10381->8058|10424->8079|10602->8229|10646->8251|10819->8396|10835->8402|10903->8448|11611->9128|11654->9149|11832->9299|11876->9321|12049->9466|12065->9472|12133->9518|12841->10198|12884->10219|13062->10369|13106->10391|13279->10536|13295->10542|13363->10588|14071->11268|14114->11289|14233->11380|14291->11416|14462->11559|14504->11578|14629->11675|14672->11695
                  LINES: 33->1|37->5|37->5|43->11|43->11|49->17|49->17|55->23|55->23|61->29|61->29|67->35|67->35|76->44|76->44|82->50|82->50|85->53|85->53|86->54|86->54|91->59|91->59|97->65|97->65|100->68|100->68|101->69|101->69|106->74|106->74|112->80|112->80|118->86|118->86|128->96|128->96|130->98|130->98|130->98|139->107|139->107|144->112|144->112|146->114|146->114|146->114|154->122|154->122|159->127|159->127|161->129|161->129|161->129|169->137|169->137|174->142|174->142|176->144|176->144|176->144|184->152|184->152|189->157|189->157|191->159|191->159|191->159|199->167|199->167|204->172|204->172|206->174|206->174|206->174|214->182|214->182|219->187|219->187|222->190|222->190|223->191|223->191
                  -- GENERATED --
              */
          