
package views.html.telco.order

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

object OrderSubscriber_sim_infoKH_img extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="row">
  <div class="col-md-12 m-t-3">
    <span class="display-4 title-section-1">"""),_display_(/*3.46*/Messages("4. Up ảnh, phiếu yêu cầu")),format.raw/*3.82*/("""</span>
  </div>
</div>
<div class="row" style="text-align: left;">
  <div class="col-md-1 m-t-3">
    <label class="col-sm-12 col-form-label title-section-2">"""),_display_(/*8.62*/Messages("Ảnh đại diện")),format.raw/*8.86*/("""<span class="text-red">"""),_display_(/*8.110*/Messages("*")),format.raw/*8.123*/("""</span></label>
  </div>
  <div class="col-md-3 m-t-3">
    <div class="row m-b-4">
      <div class="col-sm-12 position-relative">
        <div class="row">
          <div class="col-md-12 position-relative">
            <input id="imgOld1" type="text" class="form-control" hidden>
            <div class="d-flex flex-column align-items-center text-center square-item" >
              <img src=""""),_display_(/*17.26*/routes/*17.32*/.Assets.versioned("images/market/default.png")),format.raw/*17.78*/("""" id="wizardPicturePreview1" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">
              <input id="wizard-picture-1" name="avatar" type="file" hidden/>
              <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg1" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(1)"></i></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="col-md-1 m-t-3">
    <label class="col-sm-12 col-form-label title-section-2">"""),_display_(/*28.62*/Messages("Mặt trước CMT/ CCCD")),format.raw/*28.93*/("""<span class="text-red">"""),_display_(/*28.117*/Messages("*")),format.raw/*28.130*/("""</span></label>
  </div>
  <div class="col-md-3 m-t-3">
    <div class="row m-b-4">
      <div class="col-sm-12">
        <div class="row">
          <div class="col-md-12 position-relative">
            <input id="imgOld2" type="text" class="form-control" hidden>
            <div class="d-flex flex-column align-items-center text-center square-item" >
              <img src=""""),_display_(/*37.26*/routes/*37.32*/.Assets.versioned("images/market/default.png")),format.raw/*37.78*/("""" id="wizardPicturePreview2" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">
              <input id="wizard-picture-2" name="avatar" type="file" hidden/>
              <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg2" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(2)"></i></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="col-md-1 m-t-3">
    <label class="col-sm-12 col-form-label title-section-2">"""),_display_(/*48.62*/Messages("Mặt sau CMT/ CCCD")),format.raw/*48.91*/("""<span class="text-red">"""),_display_(/*48.115*/Messages("*")),format.raw/*48.128*/("""</span></label>
  </div>
  <div class="col-md-3 m-t-3">
    <div class="row m-b-4">
      <div class="col-sm-12">
        <div class="row">
          <div class="col-md-12 position-relative">
            <input id="imgOld3" type="text" class="form-control" hidden>
            <div class="d-flex flex-column align-items-center text-center square-item" >
              <img src=""""),_display_(/*57.26*/routes/*57.32*/.Assets.versioned("images/market/default.png")),format.raw/*57.78*/("""" id="wizardPicturePreview3" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">
              <input id="wizard-picture-3" name="avatar" type="file" hidden/>
              <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg3" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(3)"></i></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="col-md-1 m-t-3">
    <label class="col-sm-12 col-form-label title-section-2">"""),_display_(/*68.62*/Messages("Ảnh GPKD")),format.raw/*68.82*/("""<span class="text-red">"""),_display_(/*68.106*/Messages("*")),format.raw/*68.119*/("""</span></label>
  </div>
  <div class="col-md-3 m-t-3">
    <div class="row m-b-4">
      <div class="col-sm-12 position-relative">
        <div class="row">
          <div class="col-md-12 position-relative">
            <input id="imgOld4" type="text" class="form-control" hidden>
            <div class="d-flex flex-column align-items-center text-center square-item" >
              <img src=""""),_display_(/*77.26*/routes/*77.32*/.Assets.versioned("images/market/default.png")),format.raw/*77.78*/("""" id="wizardPicturePreview4" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">
              <input id="wizard-picture-4" name="avatar" type="file" hidden/>
              <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg4" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(4)"></i></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="col-md-1 m-t-3">
    <label class="col-sm-12 col-form-label title-section-2">"""),_display_(/*88.62*/Messages("Ảnh phiếu yêu cầu")),format.raw/*88.91*/("""<span class="text-red">"""),_display_(/*88.115*/Messages("*")),format.raw/*88.128*/("""</span></label>
  </div>
  <div class="col-md-7 m-t-3">
    <div class="row m-b-4">
      <div class="col-sm-12 position-relative">
        <div class="row">
          <div class="col-md-5 position-relative">
            <input id="imgOld5" type="text" class="form-control" hidden>
            <div class="d-flex flex-column align-items-center text-center square-item" >
              <img src=""""),_display_(/*97.26*/routes/*97.32*/.Assets.versioned("images/market/default.png")),format.raw/*97.78*/("""" id="wizardPicturePreview5" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">
              <input id="wizard-picture-5" name="avatar" type="file" hidden/>
              <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg5" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(5)"></i></div>
            </div>
          </div>
          <div class="col-md-7 position-relative">
            <label class="form-label ">"""),_display_(/*103.41*/Messages("Upload image")),format.raw/*103.65*/("""</label><br>
            <label class="form-label ">"""),_display_(/*104.41*/Messages("Kéo thả file ảnh hoặc mở file ")),format.raw/*104.83*/("""<a onclick="$('#wizard-picture-5').click();" class="cursor-pointer text-danger">"""),_display_(/*104.164*/Messages("tại đây")),format.raw/*104.183*/("""</a></label>
          </div>
          <div class="col-md-12 position-relative">
            <small class="form-label ">"""),_display_(/*107.41*/Messages("File jpg, png, jpeg, pdf dung lượng file không quá 3mb")),format.raw/*107.107*/("""</small>
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
                  DATE: Mon Sep 22 16:32:53 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/order/OrderSubscriber_sim_infoKH_img.scala.html
                  HASH: 2d629225234690bb2b3ce6f81bf9484f59fbaf70
                  MATRIX: 1067->0|1188->95|1244->131|1430->291|1474->315|1525->339|1559->352|1983->749|1998->755|2065->801|2661->1370|2713->1401|2765->1425|2800->1438|3206->1817|3221->1823|3288->1869|3884->2438|3934->2467|3986->2491|4021->2504|4427->2883|4442->2889|4509->2935|5105->3504|5146->3524|5198->3548|5233->3561|5657->3958|5672->3964|5739->4010|6335->4579|6385->4608|6437->4632|6472->4645|6895->5041|6910->5047|6977->5093|7524->5612|7570->5636|7651->5689|7715->5731|7825->5812|7867->5831|8017->5953|8106->6019
                  LINES: 33->1|35->3|35->3|40->8|40->8|40->8|40->8|49->17|49->17|49->17|60->28|60->28|60->28|60->28|69->37|69->37|69->37|80->48|80->48|80->48|80->48|89->57|89->57|89->57|100->68|100->68|100->68|100->68|109->77|109->77|109->77|120->88|120->88|120->88|120->88|129->97|129->97|129->97|135->103|135->103|136->104|136->104|136->104|136->104|139->107|139->107
                  -- GENERATED --
              */
          