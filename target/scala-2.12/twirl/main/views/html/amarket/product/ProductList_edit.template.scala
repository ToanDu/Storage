
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

object ProductList_edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editConfirmModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-fullscreen">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("Chi tiết sản phẩm")),format.raw/*5.97*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-2">
            <div class="row mb-2">
              <label class="col-sm-12 col-form-label" id="statusApprove">"""),_display_(/*11.75*/Messages("Trạng thái: Chờ duyệt")),format.raw/*11.108*/("""</label>
            </div>
            <div class="row mb-2">
              <label class="col-sm-12 col-form-label" id="contentApprove">"""),_display_(/*14.76*/Messages("Lý do: Admin chưa duyệt")),format.raw/*14.111*/("""</label>
            </div>
            <div class="row mb-2">
              <label class="col-sm-12 col-form-label" id="createDate">"""),_display_(/*17.72*/Messages("Ngày tạo: ")),format.raw/*17.94*/("""</label>
            </div>
            <div class="row mb-2">
              <label class="col-sm-12 col-form-label" id="updateDate">"""),_display_(/*20.72*/Messages("Cập nhật lần cuối: ")),format.raw/*20.103*/("""</label>
            </div>
          </div>
          <div class="col-md-6">
            <input id="idProductEdit" type="text" class="form-control" hidden>

            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*27.55*/Messages("* Tên sản phẩm")),format.raw/*27.81*/("""</label>
              <div class="col-sm-8">
                <input id="nameProductEdit" type="text" class="form-control" maxlength="255" autocomplete="off" placeholder="...tối đa 255 kí tự">
              </div>
            </div>


            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*35.55*/Messages("* Giới thiệu sản phẩm")),format.raw/*35.88*/("""</label>
              <div class="col-sm-8">
                <textarea class="form-control" id="infoProductEdit" maxlength="500" rows="2" placeholder="...tối đa 500 kí tự"></textarea>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*41.55*/Messages("* Mô tả sản phẩm")),format.raw/*41.83*/("""</label>
              <div class="col-sm-8">
                <textarea class="form-control" id="contentProductEdit" maxlength="5000" rows="5" placeholder="...tối đa 5000 kí tự"></textarea>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*47.55*/Messages("Tính năng nổi bật")),format.raw/*47.84*/("""</label>
              <div class="col-sm-8">
                <textarea class="form-control" id="featureProductEdit" maxlength="1000" rows="3" placeholder="...tối đa 1000 kí tự"></textarea>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*53.55*/Messages("Link tài liệu")),format.raw/*53.80*/("""</label>
              <div class="col-sm-8">
                <textarea class="form-control" id="linkDocsProductEdit" maxlength="500" rows="2" placeholder="...tối đa 500 kí tự"></textarea>
              </div>
            </div>
          </div>

          <div class="col-md-4">
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*62.55*/Messages("Mã SP")),format.raw/*62.72*/("""</label>
              <div class="col-sm-8">
                <input id="codeProductEdit" type="text" class="form-control" maxlength="50" autocomplete="off" placeholder="...tối đa 50 kí tự">
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*68.55*/Messages("* Phân loại")),format.raw/*68.78*/("""</label>
              <div class="col-sm-8" id="selectGroupProductAdd">
                <select id="typeGroupProductEdit" class="form-select" onchange="selectGroupProductEdit()">
                  <option value="0">"""),_display_(/*71.38*/Messages("Thiết bị")),format.raw/*71.58*/("""</option>
                  <option value="1">"""),_display_(/*72.38*/Messages("Giải pháp")),format.raw/*72.59*/("""</option>
                </select>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*77.55*/Messages("* Nhóm sản phẩm")),format.raw/*77.82*/("""</label>
              <div class="col-sm-8" id="selectGroupProductEdit">
                <select id="groupProductEdit" class="form-select"></select>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*83.55*/Messages("Hiển thị")),format.raw/*83.75*/("""</label>
              <div class="col-sm-8">
                <select id="showProductEdit" class="form-select">
                  <option value="true" selected>"""),_display_(/*86.50*/Messages("Hiện")),format.raw/*86.66*/("""</option>
                  <option value="false">"""),_display_(/*87.42*/Messages("Ẩn")),format.raw/*87.56*/("""</option>
                </select>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*92.55*/Messages("Giá (VND)")),format.raw/*92.76*/("""</label>
              <div class="col-sm-8">
                <input id="priceProductEdit" type="number" class="form-control" value="0">
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*98.55*/Messages("Giải pháp đi kèm sản phẩm")),format.raw/*98.92*/("""</label>
              <div class="col-sm-8">
                <textarea class="form-control" id="solutionEdit" maxlength="500" rows="2" placeholder="...tối đa 500 kí tự"></textarea>
              </div>
            </div>
            <div class="row mb-4">
              <label class="col-sm-3 col-form-label">"""),_display_(/*104.55*/Messages("Thông tin người hỗ trợ bán hàng")),format.raw/*104.98*/("""</label>
              <div class="col-sm-8">
                <textarea class="form-control" id="supportPersionEdit" maxlength="500" rows="2" placeholder="...tối đa 500 kí tự"></textarea>
              </div>
            </div>
          </div>

          <div class="col-md-12">
            <div class="row">
              <div class="col-md-2 position-relative">
                <label class="form-label">"""),_display_(/*114.44*/Messages("* Ảnh đại diện")),format.raw/*114.70*/("""</label>
                <input id="imgProductOld" type="text" class="form-control" hidden>
                <div class="d-flex flex-column align-items-center text-center" style="border: 1px solid;">
                  <img src=""""),_display_(/*117.30*/routes/*117.36*/.Assets.versioned("images/iotplatform.png")),format.raw/*117.79*/("""" id="wizardPicturePreviewEdit" alt="Admin" class="p-1" style="margin: 10px;width: 95%;">
                  <input id="wizard-picture-edit" name="avatar" type="file" hidden/>

                  <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImgEdit" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageEdit()"></i></div>
                </div>
                <div class="d-flex align-items-center cursor-pointer" onclick="$('#wizard-picture-edit').click();">
                  <div class="font-22 text-black-50">
                    <i class="fadeIn animated bx bx-upload"></i>
                  </div>
                  <div class="ms-2">"""),_display_(/*126.38*/Messages("manage.group.upImage")),format.raw/*126.70*/("""</div>
                </div>
              </div>

              <div class="col-md-2 position-relative">
                <label class="form-label">"""),_display_(/*131.44*/Messages("Hình ảnh 1")),format.raw/*131.66*/("""</label>
                <input id="imgProductOld1" type="text" class="form-control" hidden>
                <input id="changeImg1" type="checkbox" hidden>
                <div class="d-flex flex-column align-items-center text-center" style="border: 1px solid;">
                  <img src=""""),_display_(/*135.30*/routes/*135.36*/.Assets.versioned("images/market/default.png")),format.raw/*135.82*/("""" id="wizardPicturePreviewEdit1" alt="Admin" class="p-1" style="margin: 10px;width: 95%;">
                  <input id="wizard-picture-1-edit" name="avatar" type="file" hidden/>
                  <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImgEdit1" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumberEdit(1)"></i></div>
                </div>
                <div class="d-flex align-items-center cursor-pointer" onclick="$('#wizard-picture-1-edit').click();">
                  <div class="font-22 text-black-50">
                    <i class="fadeIn animated bx bx-upload"></i>
                  </div>
                  <div class="ms-2">"""),_display_(/*143.38*/Messages("Tải ảnh 1")),format.raw/*143.59*/("""</div>
                </div>
              </div>

              <div class="col-md-2 position-relative">
                <label class="form-label">"""),_display_(/*148.44*/Messages("Hình ảnh 2")),format.raw/*148.66*/("""</label>
                <input id="imgProductOld2" type="text" class="form-control" hidden>
                <input id="changeImg2" type="checkbox" hidden>
                <div class="d-flex flex-column align-items-center text-center" style="border: 1px solid;">
                  <img src=""""),_display_(/*152.30*/routes/*152.36*/.Assets.versioned("images/market/default.png")),format.raw/*152.82*/("""" id="wizardPicturePreviewEdit2" alt="Admin" class="p-1" style="margin: 10px;width: 95%;">
                  <input id="wizard-picture-2-edit" name="avatar" type="file" hidden/>
                  <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImgEdit2" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumberEdit(2)"></i></div>
                </div>
                <div class="d-flex align-items-center cursor-pointer" onclick="$('#wizard-picture-2-edit').click();">
                  <div class="font-22 text-black-50">
                    <i class="fadeIn animated bx bx-upload"></i>
                  </div>
                  <div class="ms-2">"""),_display_(/*160.38*/Messages("Tải ảnh 2")),format.raw/*160.59*/("""</div>
                </div>
              </div>

              <div class="col-md-2 position-relative">
                <label class="form-label">"""),_display_(/*165.44*/Messages("Hình ảnh 3")),format.raw/*165.66*/("""</label>
                <input id="imgProductOld3" type="text" class="form-control" hidden>
                <input id="changeImg3" type="checkbox" hidden>
                <div class="d-flex flex-column align-items-center text-center" style="border: 1px solid;">
                  <img src=""""),_display_(/*169.30*/routes/*169.36*/.Assets.versioned("images/market/default.png")),format.raw/*169.82*/("""" id="wizardPicturePreviewEdit3" alt="Admin" class="p-1" style="margin: 10px;width: 95%;">
                  <input id="wizard-picture-3-edit" name="avatar" type="file" hidden/>
                  <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImgEdit3" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumberEdit(3)"></i></div>
                </div>
                <div class="d-flex align-items-center cursor-pointer" onclick="$('#wizard-picture-3-edit').click();">
                  <div class="font-22 text-black-50">
                    <i class="fadeIn animated bx bx-upload"></i>
                  </div>
                  <div class="ms-2">"""),_display_(/*177.38*/Messages("Tải ảnh 3")),format.raw/*177.59*/("""</div>
                </div>
              </div>

              <div class="col-md-2 position-relative">
                <label class="form-label">"""),_display_(/*182.44*/Messages("Hình ảnh 4")),format.raw/*182.66*/("""</label>
                <input id="imgProductOld4" type="text" class="form-control" hidden>
                <input id="changeImg4" type="checkbox" hidden>
                <div class="d-flex flex-column align-items-center text-center" style="border: 1px solid;">
                  <img src=""""),_display_(/*186.30*/routes/*186.36*/.Assets.versioned("images/market/default.png")),format.raw/*186.82*/("""" id="wizardPicturePreviewEdit4" alt="Admin" class="p-1" style="margin: 10px;width: 95%;">
                  <input id="wizard-picture-4-edit" name="avatar" type="file" hidden/>
                  <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImgEdit4" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumberEdit(4)"></i></div>
                </div>
                <div class="d-flex align-items-center cursor-pointer" onclick="$('#wizard-picture-4-edit').click();">
                  <div class="font-22 text-black-50">
                    <i class="fadeIn animated bx bx-upload"></i>
                  </div>
                  <div class="ms-2">"""),_display_(/*194.38*/Messages("Tải ảnh 4")),format.raw/*194.59*/("""</div>
                </div>
              </div>

              <div class="col-md-2 position-relative">
                <label class="form-label">"""),_display_(/*199.44*/Messages("Hình ảnh 5")),format.raw/*199.66*/("""</label>
                <input id="imgProductOld5" type="text" class="form-control" hidden>
                <input id="changeImg5" type="checkbox" hidden>
                <div class="d-flex flex-column align-items-center text-center" style="border: 1px solid;">
                  <img src=""""),_display_(/*203.30*/routes/*203.36*/.Assets.versioned("images/market/default.png")),format.raw/*203.82*/("""" id="wizardPicturePreviewEdit5" alt="Admin" class="p-1" style="margin: 10px;width: 95%;">
                  <input id="wizard-picture-5-edit" name="avatar" type="file" hidden/>
                  <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImgEdit5" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumberEdit(5)"></i></div>
                </div>
                <div class="d-flex align-items-center cursor-pointer" onclick="$('#wizard-picture-5-edit').click();">
                  <div class="font-22 text-black-50">
                    <i class="fadeIn animated bx bx-upload"></i>
                  </div>
                  <div class="ms-2">"""),_display_(/*211.38*/Messages("Tải ảnh 5")),format.raw/*211.59*/("""</div>
                </div>
              </div>

            </div>
            <small>"""),_display_(/*216.21*/Messages("manage.group.upImageNote")),format.raw/*216.57*/("""</small>

            <div class="modal-footer">
              """),format.raw/*219.204*/("""
              """),format.raw/*220.15*/("""<button type="button" class="btn btn-danger" onclick="processEditProduct()">"""),_display_(/*220.92*/Messages("btnUpdate")),format.raw/*220.113*/("""</button>
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*221.88*/Messages("btnClose")),format.raw/*221.108*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/amarket/product/ProductList_edit.scala.html
                  HASH: 0fa37673addef73f6285a096b7a424ac6f1cee7d
                  MATRIX: 1057->0|1459->376|1508->405|1753->623|1808->656|1973->794|2030->829|2191->963|2234->985|2395->1119|2448->1150|2722->1397|2769->1423|3120->1747|3174->1780|3515->2094|3564->2122|3910->2441|3960->2470|4306->2789|4352->2814|4748->3183|4786->3200|5133->3520|5177->3543|5421->3760|5462->3780|5536->3827|5578->3848|5770->4013|5818->4040|6124->4319|6165->4339|6353->4500|6390->4516|6468->4567|6503->4581|6695->4746|6737->4767|7030->5033|7088->5070|7427->5381|7492->5424|7928->5832|7976->5858|8232->6086|8248->6092|8313->6135|9031->6825|9085->6857|9263->7007|9307->7029|9627->7321|9643->7327|9711->7373|10441->8075|10484->8096|10662->8246|10706->8268|11026->8560|11042->8566|11110->8612|11840->9314|11883->9335|12061->9485|12105->9507|12425->9799|12441->9805|12509->9851|13239->10553|13282->10574|13460->10724|13504->10746|13824->11038|13840->11044|13908->11090|14638->11792|14681->11813|14859->11963|14903->11985|15223->12277|15239->12283|15307->12329|16037->13031|16080->13052|16199->13143|16257->13179|16350->13431|16394->13446|16499->13523|16543->13544|16668->13641|16711->13661
                  LINES: 33->1|37->5|37->5|43->11|43->11|46->14|46->14|49->17|49->17|52->20|52->20|59->27|59->27|67->35|67->35|73->41|73->41|79->47|79->47|85->53|85->53|94->62|94->62|100->68|100->68|103->71|103->71|104->72|104->72|109->77|109->77|115->83|115->83|118->86|118->86|119->87|119->87|124->92|124->92|130->98|130->98|136->104|136->104|146->114|146->114|149->117|149->117|149->117|158->126|158->126|163->131|163->131|167->135|167->135|167->135|175->143|175->143|180->148|180->148|184->152|184->152|184->152|192->160|192->160|197->165|197->165|201->169|201->169|201->169|209->177|209->177|214->182|214->182|218->186|218->186|218->186|226->194|226->194|231->199|231->199|235->203|235->203|235->203|243->211|243->211|248->216|248->216|251->219|252->220|252->220|252->220|253->221|253->221
                  -- GENERATED --
              */
          