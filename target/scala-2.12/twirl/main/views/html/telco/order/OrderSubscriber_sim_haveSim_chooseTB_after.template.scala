
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

object OrderSubscriber_sim_haveSim_chooseTB_after extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-md-12 m-t-4">
  <span class="display-4 title-section-1">"""),_display_(/*2.44*/Messages("3. Thông tin thanh toán")),format.raw/*2.79*/("""</span>
</div>
<div class="col-md-12">
  <div class="row m-b-3">
    <label class="col-sm-4 col-form-label title-section-2" style="text-align: left">"""),_display_(/*6.86*/Messages("Số hợp đồng ")),format.raw/*6.110*/("""</label>
    <div class="col-sm-8">
      <input id="so_hop_dong" type="text" class="form-control input-form" maxlength="255" autocomplete="off" value="">
    </div>
  </div>
  <div class="row m-b-3">
    <label class="col-sm-4 col-form-label title-section-2" style="text-align: left">"""),_display_(/*12.86*/Messages("Ngày ký ")),format.raw/*12.106*/("""</label>
    <div class="col-sm-8">
      <input id="ngay_ky" type="text" class="form-control input-form" maxlength="255" autocomplete="off" value="">
    </div>
  </div>
  <div class="row m-b-3">
    <label class="col-sm-4 col-form-label title-section-2" style="text-align: left">"""),_display_(/*18.86*/Messages("Chu kỳ cước ")),format.raw/*18.110*/("""</label>
    <div class="col-sm-8">
      <input id="chu_ky_cuoc" type="text" class="form-control input-form" maxlength="255" autocomplete="off" value="">
    </div>
  </div>
  <div class="row m-b-3">
    <label class="col-sm-4 col-form-label title-section-2" style="text-align: left">"""),_display_(/*24.86*/Messages("Hình thức thanh toán ")),format.raw/*24.119*/("""<span class="text-red">"""),_display_(/*24.143*/Messages("*")),format.raw/*24.156*/("""</span></label>
    <div class="col-sm-8">
      <select class="form-control" style="width: 100%;" id="hinh_thuc_thanh_toan">
        <option value="Thu tại nhà" selected>"""),_display_(/*27.47*/Messages("Thu tại nhà")),format.raw/*27.70*/("""</option>
      </select>
    </div>
  </div>
  <div class="row m-b-3">
    <label class="col-sm-4 col-form-label title-section-2" style="text-align: left">"""),_display_(/*32.86*/Messages("Hình thức TBC ")),format.raw/*32.112*/("""<span class="text-red">"""),_display_(/*32.136*/Messages("*")),format.raw/*32.149*/("""</span></label>
    <div class="col-sm-8">
      <select class="form-control" style="width: 100%;" id="hinh_thuc_tbc">
        <option value="Không nhận" selected>"""),_display_(/*35.46*/Messages("Không nhận")),format.raw/*35.68*/("""</option>
      </select>
    </div>
  </div>
  <div class="row m-b-3">
    <label class="col-sm-4 col-form-label title-section-2" style="text-align: left">"""),_display_(/*40.86*/Messages("In chi tiết cước ")),format.raw/*40.115*/("""<span class="text-red">"""),_display_(/*40.139*/Messages("*")),format.raw/*40.152*/("""</span></label>
    <div class="col-sm-8">
      <select class="form-control" style="width: 100%;" id="in_chi_tiet_cuoc">
        <option value="Không in bản kê chi tiết cước" selected>"""),_display_(/*43.65*/Messages("Không in bản kê chi tiết cước")),format.raw/*43.106*/("""</option>
      </select>
    </div>
  </div>
  <div class="row m-b-3">
    <label class="col-sm-4 col-form-label title-section-2" style="text-align: left">"""),_display_(/*48.86*/Messages("Địa chỉ")),format.raw/*48.105*/("""<span class="text-red">"""),_display_(/*48.129*/Messages("*")),format.raw/*48.142*/("""</span></label>
    <div class="col-sm-8">
      <div class="row">
        <div class="col-sm-4">
          <select class="form-control" id="tinh_tp_4" onchange="selectDistrict_4()">
            <option value="">"""),_display_(/*53.31*/Messages("Tỉnh/ TP")),format.raw/*53.51*/("""</option>
          </select>
        </div>
        <div class="col-sm-4">
          <select class="form-control" id="quan_huyen_4" onchange="selectWard_4()">
            <option>"""),_display_(/*58.22*/Messages("Huyện/ Quận")),format.raw/*58.45*/("""</option>
          </select>
        </div>
        <div class="col-sm-4">
          <select class="form-control" id="phuong_xa_4">
            <option>"""),_display_(/*63.22*/Messages("Phường/Xã")),format.raw/*63.43*/("""</option>
          </select>
        </div>
        <div class="col-sm-12" style="margin-top: 0.5rem;">
          <input id="dia_chi_chi_tiet_4" type="text" class="form-control input-form" maxlength="500" placeholder="Địa chỉ chi tiết">
        </div>
      </div>
    </div>
  </div>
  <div class="row m-b-3">
    <label class="col-sm-4 col-form-label title-section-2" style="text-align: left">"""),_display_(/*73.86*/Messages("Địa chỉ XM/ TBC ")),format.raw/*73.114*/("""</label>
    <div class="col-sm-8">
      <input id="dia_chi_xm_tbc" type="text" class="form-control input-form" maxlength="255" autocomplete="off" value="">
    </div>
  </div>
  <div class="row m-b-3">
    <label class="col-sm-4 col-form-label title-section-2" style="text-align: left">"""),_display_(/*79.86*/Messages("Địa chỉ hóa đơn cước ")),format.raw/*79.119*/("""<span class="text-red">"""),_display_(/*79.143*/Messages("*")),format.raw/*79.156*/("""</span></label>
    <div class="col-sm-8">
      <input id="dia_chi_hoa_don_cuoc" type="text" class="form-control input-form" maxlength="255" autocomplete="off" value="">
    </div>
  </div>

</div>

<div class="col-md-12 m-t-4">
  <span class="display-4 title-section-1">"""),_display_(/*88.44*/Messages("4. Thông tin hồ sơ khách hàng")),format.raw/*88.85*/("""</span>
</div>
<div class="col-md-12 mt-3">
  <div class="row m-b-4">
    <label class="col-sm-4 title-section-2" style="text-align: left">"""),_display_(/*92.71*/Messages("Bản cam kết")),format.raw/*92.94*/("""</label>
    <div class="col-sm-5">
      <input type="file" class="" id="file_ban_cam_ket" name="files" style="background-color: #aaa; width: 100%;"/>
    </div>
    <div class="col-sm-3" style="text-align: left;">
      <a style="color: #EA0033; cursor: pointer;" onclick=""><i class="bx bx-file"></i> """),_display_(/*97.90*/Messages("Upload file")),format.raw/*97.113*/("""</a>
    </div>
  </div>
  <div class="row m-b-4">
    <label class="col-sm-4 title-section-2" style="text-align: left">"""),_display_(/*101.71*/Messages("CMND/ CCCD mặt trước")),format.raw/*101.103*/("""</label>
    <div class="col-sm-5">
      <input type="file" class="" id="file_cmnd_cccd_mat_truoc" name="files" style="background-color: #aaa; width: 100%;"/>
    </div>
    <div class="col-sm-3" style="text-align: left;">
      <a style="color: #EA0033; cursor: pointer;" onclick=""><i class="bx bx-file"></i> """),_display_(/*106.90*/Messages("Upload file")),format.raw/*106.113*/("""</a>
    </div>
  </div>
  <div class="row m-b-4">
    <label class="col-sm-4 title-section-2" style="text-align: left">"""),_display_(/*110.71*/Messages("CMND/ CCCD mặt sau")),format.raw/*110.101*/("""</label>
    <div class="col-sm-5">
      <input type="file" class="" id="file_cmnd_cccd_mat_sau" name="files" style="background-color: #aaa; width: 100%;"/>
    </div>
    <div class="col-sm-3" style="text-align: left;">
      <a style="color: #EA0033; cursor: pointer;" onclick=""><i class="bx bx-file"></i> """),_display_(/*115.90*/Messages("Upload file")),format.raw/*115.113*/("""</a>
    </div>
  </div>
  <div class="row m-b-4">
    <label class="col-sm-4 title-section-2" style="text-align: left">"""),_display_(/*119.71*/Messages("Hình ảnh khách hàng")),format.raw/*119.102*/("""</label>
    <div class="col-sm-5">
      <input type="file" class="" id="file_hinh_anh_khach_hang" name="files" style="background-color: #aaa; width: 100%;"/>
    </div>
    <div class="col-sm-3" style="text-align: left;">
      <a style="color: #EA0033; cursor: pointer;" onclick=""><i class="bx bx-file"></i> """),_display_(/*124.90*/Messages("Upload file")),format.raw/*124.113*/("""</a>
    </div>
  </div>
  <div class="row m-b-4">
    <label class="col-sm-4 title-section-2" style="text-align: left">"""),_display_(/*128.71*/Messages("Hợp đồng")),format.raw/*128.91*/("""</label>
    <div class="col-sm-5">
      <input type="file" class="" id="file_hop_dong" name="files" style="background-color: #aaa; width: 100%;"/>
    </div>
    <div class="col-sm-3" style="text-align: left;">
      <a style="color: #EA0033; cursor: pointer;" onclick=""><i class="bx bx-file"></i> """),_display_(/*133.90*/Messages("Upload file")),format.raw/*133.113*/("""</a>
    </div>
  </div>
  <div class="row m-b-4">
    <label class="col-sm-4 title-section-2" style="text-align: left">"""),_display_(/*137.71*/Messages("Phụ lục HĐDĐ trả sau")),format.raw/*137.103*/("""</label>
    <div class="col-sm-5">
      <input type="file" class="" id="file_phu_luc_hddd_tra_sau" name="files" style="background-color: #aaa; width: 100%;"/>
    </div>
    <div class="col-sm-3" style="text-align: left;">
      <a style="color: #EA0033; cursor: pointer;" onclick=""><i class="bx bx-file"></i> """),_display_(/*142.90*/Messages("Upload file")),format.raw/*142.113*/("""</a>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/order/OrderSubscriber_sim_haveSim_chooseTB_after.scala.html
                  HASH: 2f0931fef3ae96822a8353f4f4f6aea166f52b79
                  MATRIX: 1079->0|1178->73|1233->108|1409->258|1454->282|1767->568|1809->588|2118->870|2164->894|2477->1180|2532->1213|2584->1237|2619->1250|2818->1422|2862->1445|3046->1602|3094->1628|3146->1652|3181->1665|3372->1829|3415->1851|3599->2008|3650->2037|3702->2061|3737->2074|3950->2260|4013->2301|4197->2458|4238->2477|4290->2501|4325->2514|4565->2727|4606->2747|4814->2928|4858->2951|5039->3105|5081->3126|5505->3523|5555->3551|5871->3840|5926->3873|5978->3897|6013->3910|6313->4183|6375->4224|6542->4364|6586->4387|6918->4692|6963->4715|7112->4836|7167->4868|7508->5181|7554->5204|7703->5325|7756->5355|8095->5666|8141->5689|8290->5810|8344->5841|8685->6154|8731->6177|8880->6298|8922->6318|9252->6620|9298->6643|9447->6764|9502->6796|9844->7110|9890->7133
                  LINES: 33->1|34->2|34->2|38->6|38->6|44->12|44->12|50->18|50->18|56->24|56->24|56->24|56->24|59->27|59->27|64->32|64->32|64->32|64->32|67->35|67->35|72->40|72->40|72->40|72->40|75->43|75->43|80->48|80->48|80->48|80->48|85->53|85->53|90->58|90->58|95->63|95->63|105->73|105->73|111->79|111->79|111->79|111->79|120->88|120->88|124->92|124->92|129->97|129->97|133->101|133->101|138->106|138->106|142->110|142->110|147->115|147->115|151->119|151->119|156->124|156->124|160->128|160->128|165->133|165->133|169->137|169->137|174->142|174->142
                  -- GENERATED --
              */
          