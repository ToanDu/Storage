
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

object OrderSubscriber_sim_haveSim_chooseTB_upCt extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-md-12 m-t-4">
  <span class="display-4 title-section-1">"""),_display_(/*2.44*/Messages("Tải file chứng từ")),format.raw/*2.73*/("""</span>
  <input id="customerTypeCt" type="text" class="form-control input-form" readonly hidden>
</div>
<div class="row" style="text-align: left;" id="listCt">
  <div class="col-md-1 m-t-3">
    <label class="col-sm-12 col-form-label title-section-2">"""),_display_(/*7.62*/Messages("Ảnh đại diện")),format.raw/*7.86*/("""<span class="text-red">"""),_display_(/*7.110*/Messages("*")),format.raw/*7.123*/("""</span></label>
  </div>
  <div class="col-md-3 m-t-3">
    <div class="row m-b-4">
      <div class="col-sm-12 position-relative">
        <div class="row">
          <div class="col-md-12 position-relative">
            <input id="imgOld1" type="text" class="form-control" hidden>
            <div class="d-flex flex-column align-items-center text-center square-item" >
              <img src=""""),_display_(/*16.26*/routes/*16.32*/.Assets.versioned("images/market/default.png")),format.raw/*16.78*/("""" id="wizardPicturePreview1" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">
              <input id="wizard-picture-1" name="avatar" type="file" hidden/>
              <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg1" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(1)"></i></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="col-md-1 m-t-3">
    <label class="col-sm-12 col-form-label title-section-2">"""),_display_(/*27.62*/Messages("Mặt trước CMT/ CCCD")),format.raw/*27.93*/("""<span class="text-red">"""),_display_(/*27.117*/Messages("*")),format.raw/*27.130*/("""</span></label>
  </div>
  <div class="col-md-3 m-t-3">
    <div class="row m-b-4">
      <div class="col-sm-12">
        <div class="row">
          <div class="col-md-12 position-relative">
            <input id="imgOld2" type="text" class="form-control" hidden>
            <div class="d-flex flex-column align-items-center text-center square-item" >
              <img src=""""),_display_(/*36.26*/routes/*36.32*/.Assets.versioned("images/market/default.png")),format.raw/*36.78*/("""" id="wizardPicturePreview2" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">
              <input id="wizard-picture-2" name="avatar" type="file" hidden/>
              <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg2" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(2)"></i></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="col-md-1 m-t-3">
    <label class="col-sm-12 col-form-label title-section-2">"""),_display_(/*47.62*/Messages("Mặt sau CMT/ CCCD")),format.raw/*47.91*/("""<span class="text-red">"""),_display_(/*47.115*/Messages("*")),format.raw/*47.128*/("""</span></label>
  </div>
  <div class="col-md-3 m-t-3">
    <div class="row m-b-4">
      <div class="col-sm-12">
        <div class="row">
          <div class="col-md-12 position-relative">
            <input id="imgOld3" type="text" class="form-control" hidden>
            <div class="d-flex flex-column align-items-center text-center square-item" >
              <img src=""""),_display_(/*56.26*/routes/*56.32*/.Assets.versioned("images/market/default.png")),format.raw/*56.78*/("""" id="wizardPicturePreview3" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">
              <input id="wizard-picture-3" name="avatar" type="file" hidden/>
              <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg3" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(3)"></i></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="col-md-1 m-t-3">
    <label class="col-sm-12 col-form-label title-section-2">"""),_display_(/*67.62*/Messages("Ảnh GPKD")),format.raw/*67.82*/("""<span class="text-red">"""),_display_(/*67.106*/Messages("*")),format.raw/*67.119*/("""</span></label>
  </div>
  <div class="col-md-3 m-t-3">
    <div class="row m-b-4">
      <div class="col-sm-12 position-relative">
        <div class="row">
          <div class="col-md-12 position-relative">
            <input id="imgOld4" type="text" class="form-control" hidden>
            <div class="d-flex flex-column align-items-center text-center square-item" >
              <img src=""""),_display_(/*76.26*/routes/*76.32*/.Assets.versioned("images/market/default.png")),format.raw/*76.78*/("""" id="wizardPicturePreview4" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">
              <input id="wizard-picture-4" name="avatar" type="file" hidden/>
              <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg4" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(4)"></i></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="col-md-1 m-t-3">
    <label class="col-sm-12 col-form-label title-section-2">"""),_display_(/*87.62*/Messages("Ảnh phiếu yêu cầu")),format.raw/*87.91*/("""<span class="text-red">"""),_display_(/*87.115*/Messages("*")),format.raw/*87.128*/("""</span></label>
  </div>
  <div class="col-md-7 m-t-3">
    <div class="row m-b-4">
      <div class="col-sm-12 position-relative">
        <div class="row">
          <div class="col-md-5 position-relative">
            <input id="imgOld5" type="text" class="form-control" hidden>
            <div class="d-flex flex-column align-items-center text-center square-item" >
              <img src=""""),_display_(/*96.26*/routes/*96.32*/.Assets.versioned("images/market/default.png")),format.raw/*96.78*/("""" id="wizardPicturePreview5" onclick="zoomImg(this)" alt="Admin" class="p-1 zoom" style="width: 100%;object-fit: contain;">
              <input id="wizard-picture-5" name="avatar" type="file" hidden/>
              <div class="position-absolute end-0 m-3 product-discount" id="buttonResetImg5" style="display: none"><i class="bx bx-x cursor-pointer" onclick="resetImageNumber(5)"></i></div>
            </div>
          </div>
          <div class="col-md-7 position-relative">
            <label class="form-label ">"""),_display_(/*102.41*/Messages("Upload image")),format.raw/*102.65*/("""</label><br>
            <label class="form-label ">"""),_display_(/*103.41*/Messages("Kéo thả file ảnh hoặc mở file ")),format.raw/*103.83*/("""<a onclick="$('#wizard-picture-5').click();" class="cursor-pointer text-danger">"""),_display_(/*103.164*/Messages("tại đây")),format.raw/*103.183*/("""</a></label>
          </div>
          <div class="col-md-12 position-relative">
            <small class="form-label ">"""),_display_(/*106.41*/Messages("File jpg, png, jpeg, pdf dung lượng file không quá 3mb")),format.raw/*106.107*/("""</small>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/order/OrderSubscriber_sim_haveSim_chooseTB_upCt.scala.html
                  HASH: 2fd0684f8be31831f718bee5421d65f7debf6165
                  MATRIX: 1078->0|1177->73|1226->102|1505->355|1549->379|1600->403|1634->416|2058->813|2073->819|2140->865|2736->1434|2788->1465|2840->1489|2875->1502|3281->1881|3296->1887|3363->1933|3959->2502|4009->2531|4061->2555|4096->2568|4502->2947|4517->2953|4584->2999|5180->3568|5221->3588|5273->3612|5308->3625|5732->4022|5747->4028|5814->4074|6410->4643|6460->4672|6512->4696|6547->4709|6970->5105|6985->5111|7052->5157|7599->5676|7645->5700|7726->5753|7790->5795|7900->5876|7942->5895|8092->6017|8181->6083
                  LINES: 33->1|34->2|34->2|39->7|39->7|39->7|39->7|48->16|48->16|48->16|59->27|59->27|59->27|59->27|68->36|68->36|68->36|79->47|79->47|79->47|79->47|88->56|88->56|88->56|99->67|99->67|99->67|99->67|108->76|108->76|108->76|119->87|119->87|119->87|119->87|128->96|128->96|128->96|134->102|134->102|135->103|135->103|135->103|135->103|138->106|138->106
                  -- GENERATED --
              */
          