
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
/*1.2*/import vn.m2m.common.models.User

object OrderSubscriber_sim_infoKH extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<div class="col-lg-9 col-md-8">

  <div class="row">
    <div class="col-md-12 m-t-3">
      <span class="display-4 title-section-1">"""),_display_(/*7.48*/Messages("1. Thông tin khách hàng")),format.raw/*7.83*/("""</span>
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*13.65*/Messages("Nhóm loại KH")),format.raw/*13.89*/("""<span class="text-red">"""),_display_(/*13.113*/Messages("*")),format.raw/*13.126*/("""</span></label>
        <div class="col-sm-6">
          <select class="form-control" id="nhom_loai_kh">
            <option value="VTL" selected>"""),_display_(/*16.43*/Messages("KH doanh nghiệp")),format.raw/*16.70*/("""</option>
            <option value="VIE" >"""),_display_(/*17.35*/Messages("KH cá nhân")),format.raw/*17.57*/("""</option>
          </select>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*26.65*/Messages("Loại KH")),format.raw/*26.84*/("""<span class="text-red">"""),_display_(/*26.108*/Messages("*")),format.raw/*26.121*/("""</span></label>
        <div class="col-sm-6">
          <select class="form-control" id="loai_kh">
            <option value="DCT" selected>"""),_display_(/*29.43*/Messages("Công ty TNHH, Cổ phần, Hợp danh, Liên doanh")),format.raw/*29.98*/("""</option>
          </select>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*38.65*/Messages("Tên DN")),format.raw/*38.83*/("""<span class="text-red">"""),_display_(/*38.107*/Messages("*")),format.raw/*38.120*/("""</span></label>
        <div class="col-sm-6">
          <input id="ten_dn" type="text" class="form-control input-form" maxlength="255" placeholder="Nhập nội dung">
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*48.65*/Messages("Mã số thuế")),format.raw/*48.87*/("""<span class="text-red">"""),_display_(/*48.111*/Messages("*")),format.raw/*48.124*/("""</span></label>
        <div class="col-sm-6">
          <input id="ma_so_thue" type="text" class="form-control input-form" maxlength="255">
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*58.65*/Messages("Ngày thành lập")),format.raw/*58.91*/("""<span class="text-red">"""),_display_(/*58.115*/Messages("*")),format.raw/*58.128*/("""</span></label>
        <div class="col-sm-6">
          <input id="ngay_thanh_lap" type="text" class="form-control input-form date_timepicker">
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*68.65*/Messages("Địa chỉ")),format.raw/*68.84*/("""<span class="text-red">"""),_display_(/*68.108*/Messages("*")),format.raw/*68.121*/("""</span></label>
        <div class="col-sm-8">
          <div class="row">
            <div class="col-sm-4">
              <select class="form-control" id="tinh_tp" onchange="selectDistrict()">
                <option value="">"""),_display_(/*73.35*/Messages("Tỉnh/ TP")),format.raw/*73.55*/("""</option>
              </select>
            </div>
            <div class="col-sm-4">
              <select class="form-control" id="quan_huyen" onchange="selectWard()">
                <option value="">"""),_display_(/*78.35*/Messages("Huyện/ Quận")),format.raw/*78.58*/("""</option>
              </select>
            </div>
            <div class="col-sm-4">
              <select class="form-control" id="phuong_xa">
                <option value="">"""),_display_(/*83.35*/Messages("Phường/Xã")),format.raw/*83.56*/("""</option>
              </select>
            </div>
            <div class="col-sm-12" style="margin-top: 0.5rem;">
              <input id="dia_chi_chi_tiet" type="text" class="form-control input-form" maxlength="500" placeholder="Địa chỉ chi tiết">
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*97.65*/Messages("Thông tin giấy tờ")),format.raw/*97.94*/("""<span class="text-red">"""),_display_(/*97.118*/Messages("*")),format.raw/*97.131*/("""</span></label>
        <div class="col-sm-8">
          <div class="row">
            <div class="col-sm-6 m-b-3">
              <select class="form-control" id="loai_giay_to">
                <option value="BUS">"""),_display_(/*102.38*/Messages("GPKD")),format.raw/*102.54*/("""</option>
              </select>
            </div>
            <div class="col-sm-6 m-b-3">
              <input id="so_giay_to" type="text" class="form-control input-form" maxlength="500" placeholder="Số giấy tờ">
            </div>
            <div class="col-sm-6">
              <input id="noi_cap" type="text" class="form-control input-form" maxlength="500" placeholder="Nơi cấp">
            </div>
            <div class="col-sm-6">
              <input id="ngay_cap" type="text" class="form-control input-form date_timepicker" maxlength="500" placeholder="Ngày cấp" onchange="checkDateCustomer()">
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*122.65*/Messages("Quốc tịch")),format.raw/*122.86*/("""<span class="text-red">"""),_display_(/*122.110*/Messages("*")),format.raw/*122.123*/("""</span></label>
        <div class="col-sm-6">
          <input id="quoc_tich" type="text" class="form-control input-form" maxlength="255" value="Việt Nam">
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*132.65*/Messages("Mã postcode")),format.raw/*132.88*/("""</label>
        <div class="col-sm-6">
          <input id="ma_postcode" type="text" class="form-control input-form" maxlength="255" value="100000">
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*142.65*/Messages("Ghi chú")),format.raw/*142.84*/("""</label>
        <div class="col-sm-6">
          <input id="ghi_chu" type="text" class="form-control input-form" maxlength="255" placeholder="Nhập nội dung">
        </div>
      </div>
    </div>
  </div>

  """),format.raw/*150.31*/("""
  """),format.raw/*151.3*/("""<div class="row">
    <div class="col-md-12 m-t-3">
      <span class="display-4 title-section-1">"""),_display_(/*153.48*/Messages("2. Thông tin  người đại diện")),format.raw/*153.88*/("""</span>
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*159.65*/Messages("Tên khách hàng")),format.raw/*159.91*/("""<span class="text-red">"""),_display_(/*159.115*/Messages("*")),format.raw/*159.128*/("""</span></label>
        <div class="col-sm-6">
          <input id="ten_khach_hang" type="text" class="form-control input-form" maxlength="255" placeholder="Nhập nội dung">
        </div>
      </div>
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*169.65*/Messages("Nhóm loại KH")),format.raw/*169.89*/("""<span class="text-red">"""),_display_(/*169.113*/Messages("*")),format.raw/*169.126*/("""</span></label>
        <div class="col-sm-6">
          <select class="form-control" id="nhom_loai_kh_2">
            <option value="1" selected>"""),_display_(/*172.41*/Messages("Cá nhân trong nước")),format.raw/*172.71*/("""</option>
          </select>
        </div>
      </div>
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*181.65*/Messages("Loại KH")),format.raw/*181.84*/("""<span class="text-red">"""),_display_(/*181.108*/Messages("*")),format.raw/*181.121*/("""</span></label>
        <div class="col-sm-6">
          <select class="form-control" id="loai_kh_2">
            <option value="VIE" selected>"""),_display_(/*184.43*/Messages("Tư nhân trong nước")),format.raw/*184.73*/("""</option>
          </select>
        </div>
      </div>
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*193.65*/Messages("Ngày sinh ")),format.raw/*193.87*/("""<span class="text-red">"""),_display_(/*193.111*/Messages("*")),format.raw/*193.124*/("""</span></label>
        <div class="col-sm-6">
          <input id="ngay_sinh" type="text" class="form-control input-form date_timepicker" maxlength="255" placeholder="DD/MM/YYYY" onchange="checkDateBirth1()">
        </div>
      </div>
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*203.65*/Messages("Giới tính ")),format.raw/*203.87*/("""</label>
        <div class="col-sm-6">
          <select class="form-control" id="gioi_tinh_2">
            <option value="M" selected>"""),_display_(/*206.41*/Messages("Nam")),format.raw/*206.56*/("""</option>
            <option value="F">"""),_display_(/*207.32*/Messages("Nữ")),format.raw/*207.46*/("""</option>am
          </select>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*216.65*/Messages("Quốc tịch")),format.raw/*216.86*/("""<span class="text-red">"""),_display_(/*216.110*/Messages("*")),format.raw/*216.123*/("""</span></label>
        <div class="col-sm-6">
          <input id="quoc_tich_2" type="text" class="form-control input-form" maxlength="255" value="Việt Nam">
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*226.65*/Messages("Địa chỉ")),format.raw/*226.84*/("""<span class="text-red">"""),_display_(/*226.108*/Messages("*")),format.raw/*226.121*/("""</span></label>
        <div class="col-sm-8">
          <div class="row">
            <div class="col-sm-4">
              <select class="form-control" id="tinh_tp_2" onchange="selectDistrict_2()">
                <option value="">"""),_display_(/*231.35*/Messages("Tỉnh/ TP")),format.raw/*231.55*/("""</option>
              </select>
            </div>
            <div class="col-sm-4">
              <select class="form-control" id="quan_huyen_2" onchange="selectWard_2()">
                <option value="">"""),_display_(/*236.35*/Messages("Huyện/ Quận")),format.raw/*236.58*/("""</option>
              </select>
            </div>
            <div class="col-sm-4">
              <select class="form-control" id="phuong_xa_2">
                <option value="">"""),_display_(/*241.35*/Messages("Phường/Xã")),format.raw/*241.56*/("""</option>
              </select>
            </div>
            <div class="col-sm-12" style="margin-top: 0.5rem;">
              <input id="dia_chi_chi_tiet_2" type="text" class="form-control input-form" maxlength="500" placeholder="Địa chỉ chi tiết">
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*255.65*/Messages("Thông tin giấy tờ")),format.raw/*255.94*/("""<span class="text-red">"""),_display_(/*255.118*/Messages("*")),format.raw/*255.131*/("""</span></label>
        <div class="col-sm-8">
          <div class="row">
            <div class="col-sm-6 m-b-3">
              <select class="form-control" id="loai_giay_to_2">
                <option value="ID">"""),_display_(/*260.37*/Messages("CMND")),format.raw/*260.53*/("""</option>
                <option value="IDC" selected>"""),_display_(/*261.47*/Messages("CCCD")),format.raw/*261.63*/("""</option>
              </select>
            </div>
            <div class="col-sm-6 m-b-3">
              <input id="so_giay_to_2" type="number" class="form-control input-form" maxlength="500" placeholder="Số giấy tờ">
            </div>
            <div class="col-sm-12 m-b-3">
              <input id="noi_cap_2" type="text" class="form-control input-form" maxlength="500" placeholder="Nơi cấp">
            </div>
            <div class="col-sm-6 m-b-3">
              <input id="ngay_cap_2" type="text" class="form-control input-form date_timepicker" maxlength="500" placeholder="Ngày cấp" onchange="checkDateRepresentative()">
            </div>
            <div class="col-sm-6">
              <input id="ngay_het_han_2" type="text" class="form-control input-form date_timepicker" maxlength="500" placeholder="Ngày hết hạn" onchange="checkExpirationDate2()">
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*284.65*/Messages("Ghi chú")),format.raw/*284.84*/("""</label>
        <div class="col-sm-6">
          <input id="ghi_chu_2" type="text" class="form-control input-form" maxlength="255" placeholder="Nhập nội dung">
        </div>
      </div>
    </div>
  </div>

  """),format.raw/*292.30*/("""
  """),format.raw/*293.3*/("""<div class="row">
    <div class="col-md-12 m-t-3">
      <span class="display-4 title-section-1">"""),_display_(/*295.48*/Messages("3. Thông tin người sử dụng")),format.raw/*295.86*/("""</span>
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*301.65*/Messages("Tên khách hàng")),format.raw/*301.91*/("""<span class="text-red">"""),_display_(/*301.115*/Messages("*")),format.raw/*301.128*/("""</span></label>
        <div class="col-sm-6">
          <input id="ten_khach_hang_3" type="text" class="form-control input-form" maxlength="255" placeholder="Nhập nội dung">
        </div>
      </div>
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*311.65*/Messages("Nhóm loại KH")),format.raw/*311.89*/("""<span class="text-red">"""),_display_(/*311.113*/Messages("*")),format.raw/*311.126*/("""</span></label>
        <div class="col-sm-6">
          <select class="form-control" id="nhom_loai_kh_3">
            <option value="1" selected>"""),_display_(/*314.41*/Messages("Cá nhân trong nước")),format.raw/*314.71*/("""</option>
          </select>
        </div>
      </div>
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*323.65*/Messages("Loại KH")),format.raw/*323.84*/("""<span class="text-red">"""),_display_(/*323.108*/Messages("*")),format.raw/*323.121*/("""</span></label>
        <div class="col-sm-6">
          <select class="form-control" id="loai_kh_3">
            <option value="VIE" selected>"""),_display_(/*326.43*/Messages("Tư nhân trong nước")),format.raw/*326.73*/("""</option>
          </select>
        </div>
      </div>
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*335.65*/Messages("Ngày sinh ")),format.raw/*335.87*/("""<span class="text-red">"""),_display_(/*335.111*/Messages("*")),format.raw/*335.124*/("""</span></label>
        <div class="col-sm-6">
          <input id="ngay_sinh_3" type="text" class="form-control input-form date_timepicker" maxlength="255" placeholder="DD/MM/YYYY" onchange="checkDateBirth()">
        </div>
      </div>
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*345.65*/Messages("Giới tính ")),format.raw/*345.87*/("""</label>
        <div class="col-sm-6">
          <select class="form-control" id="gioi_tinh_3">
            <option value="M" selected>"""),_display_(/*348.41*/Messages("Nam")),format.raw/*348.56*/("""</option>
            <option value="F">"""),_display_(/*349.32*/Messages("Nữ")),format.raw/*349.46*/("""</option>am
          </select>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*358.65*/Messages("Quốc tịch")),format.raw/*358.86*/("""<span class="text-red">"""),_display_(/*358.110*/Messages("*")),format.raw/*358.123*/("""</span></label>
        <div class="col-sm-6">
          <input id="quoc_tich_3" type="text" class="form-control input-form" maxlength="255" value="Việt Nam">
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*368.65*/Messages("Địa chỉ")),format.raw/*368.84*/("""<span class="text-red">"""),_display_(/*368.108*/Messages("*")),format.raw/*368.121*/("""</span></label>
        <div class="col-sm-8">
          <div class="row">
            <div class="col-sm-4">
              <select class="form-control" id="tinh_tp_3" onchange="selectDistrict_3()">
                <option value="">"""),_display_(/*373.35*/Messages("Tỉnh/ TP")),format.raw/*373.55*/("""</option>
              </select>
            </div>
            <div class="col-sm-4">
              <select class="form-control" id="quan_huyen_3" onchange="selectWard_3()">
                <option value="">"""),_display_(/*378.35*/Messages("Huyện/ Quận")),format.raw/*378.58*/("""</option>
              </select>
            </div>
            <div class="col-sm-4">
              <select class="form-control" id="phuong_xa_3">
                <option value="">"""),_display_(/*383.35*/Messages("Phường/Xã")),format.raw/*383.56*/("""</option>
              </select>
            </div>
            <div class="col-sm-12" style="margin-top: 0.5rem;">
              <input id="dia_chi_chi_tiet_3" type="text" class="form-control input-form" maxlength="500" placeholder="Địa chỉ chi tiết">
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*397.65*/Messages("Thông tin giấy tờ")),format.raw/*397.94*/("""<span class="text-red">"""),_display_(/*397.118*/Messages("*")),format.raw/*397.131*/("""</span></label>
        <div class="col-sm-8">
          <div class="row">
            <div class="col-sm-6 m-b-3">
              <select class="form-control" id="loai_giay_to_3">
                <option value="ID">"""),_display_(/*402.37*/Messages("CMND")),format.raw/*402.53*/("""</option>
                <option value="IDC" selected>"""),_display_(/*403.47*/Messages("CCCD")),format.raw/*403.63*/("""</option>
              </select>
            </div>
            <div class="col-sm-6 m-b-3">
              <input id="so_giay_to_3" type="number" class="form-control input-form" maxlength="500" placeholder="Số giấy tờ">
            </div>
            <div class="col-sm-12 m-b-3">
              <input id="noi_cap_3" type="text" class="form-control input-form" maxlength="500" placeholder="Nơi cấp">
            </div>
            <div class="col-sm-6 m-b-3">
              <input id="ngay_cap_3" type="text" class="form-control input-form date_timepicker" maxlength="500" placeholder="Ngày cấp" onchange="checkDateUsed()">
            </div>
            <div class="col-sm-6 m-b-3">
              <input id="ngay_het_han_3" type="text" class="form-control input-form date_timepicker" maxlength="500" placeholder="Ngày hết hạn" onchange="checkExpirationDate3()">
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-9">
      <div class="row m-b-3">
        <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*426.65*/Messages("Ghi chú")),format.raw/*426.84*/("""</label>
        <div class="col-sm-6">
          <input id="ghi_chu_3" type="text" class="form-control input-form" maxlength="255" placeholder="Nhập nội dung">
        </div>
      </div>
    </div>
  </div>

  """),format.raw/*434.62*/("""

"""),format.raw/*436.1*/("""</div>
<script>
      function checkDateBirth()"""),format.raw/*438.32*/("""{"""),format.raw/*438.33*/("""
        """),format.raw/*439.9*/("""var input = document.getElementById('ngay_sinh_3').value;
        var registerDay = new Date(input.split("/").reverse().join("-"));
        var currentDay = new Date();
        currentDay.setHours(0, 0, 0, 0);
        if ( currentDay - registerDay < 441763200000 ) """),format.raw/*443.56*/("""{"""),format.raw/*443.57*/("""
          """),format.raw/*444.11*/("""showNotification('danger',Messages("Thông tin người sử dụng không đủ 14 tuổi"));
          document.getElementById('ngay_sinh_3').value = "";
        """),format.raw/*446.9*/("""}"""),format.raw/*446.10*/("""
      """),format.raw/*447.7*/("""}"""),format.raw/*447.8*/("""

      """),format.raw/*449.7*/("""function checkDateBirth1()"""),format.raw/*449.33*/("""{"""),format.raw/*449.34*/("""
        """),format.raw/*450.9*/("""var input = document.getElementById('ngay_sinh').value;
        var registerDay = new Date(input.split("/").reverse().join("-"));
        var currentDay = new Date();
        currentDay.setHours(0, 0, 0, 0);
        if ( currentDay - registerDay < 441763200000 ) """),format.raw/*454.56*/("""{"""),format.raw/*454.57*/("""
          """),format.raw/*455.11*/("""showNotification('danger',Messages("Thông tin người đại diện không đủ 14 tuổi"));
          document.getElementById('ngay_sinh').value = "";
        """),format.raw/*457.9*/("""}"""),format.raw/*457.10*/("""
      """),format.raw/*458.7*/("""}"""),format.raw/*458.8*/("""

      """),format.raw/*460.7*/("""function checkDateCustomer() """),format.raw/*460.36*/("""{"""),format.raw/*460.37*/("""
        """),format.raw/*461.9*/("""var input = document.getElementById('ngay_cap').value;

        // Kiểm tra xem ngày nhập vào có trước ngày hiện tại không
        var registerDay = new Date(input.split("/").reverse().join("-"));
        var currentDay = new Date();

        if (registerDay > currentDay) """),format.raw/*467.39*/("""{"""),format.raw/*467.40*/("""
          """),format.raw/*468.11*/("""showNotification('danger',Messages(" Ngày cấp không được lớn hơn ngày hiện tại"));
          document.getElementById('ngay_cap').value = "";
        """),format.raw/*470.9*/("""}"""),format.raw/*470.10*/("""
      """),format.raw/*471.7*/("""}"""),format.raw/*471.8*/("""
      """),format.raw/*472.7*/("""function checkDateRepresentative() """),format.raw/*472.42*/("""{"""),format.raw/*472.43*/("""
        """),format.raw/*473.9*/("""var input = document.getElementById('ngay_cap_2').value;

        // Kiểm tra xem ngày nhập vào có trước ngày hiện tại không
        var registerDay = new Date(input.split("/").reverse().join("-"));
        var currentDay = new Date();
        if (registerDay > currentDay) """),format.raw/*478.39*/("""{"""),format.raw/*478.40*/("""
          """),format.raw/*479.11*/("""showNotification('danger',Messages(" Ngày cấp không được lớn hơn ngày hiện tại"));
          document.getElementById('ngay_cap_2').value = "";
        """),format.raw/*481.9*/("""}"""),format.raw/*481.10*/("""
      """),format.raw/*482.7*/("""}"""),format.raw/*482.8*/("""
      """),format.raw/*483.7*/("""function checkDateUsed() """),format.raw/*483.32*/("""{"""),format.raw/*483.33*/("""
        """),format.raw/*484.9*/("""var input = document.getElementById('ngay_cap_3').value;

        // Kiểm tra xem ngày nhập vào có trước ngày hiện tại không
        var registerDay = new Date(input.split("/").reverse().join("-"));
        var currentDay = new Date();
        if (registerDay > currentDay) """),format.raw/*489.39*/("""{"""),format.raw/*489.40*/("""
          """),format.raw/*490.11*/("""showNotification('danger',Messages("Ngày cấp không được lớn hơn ngày hiện tại"));
          document.getElementById('ngay_cap_3').value = "";
        """),format.raw/*492.9*/("""}"""),format.raw/*492.10*/("""
      """),format.raw/*493.7*/("""}"""),format.raw/*493.8*/("""
      """),format.raw/*494.7*/("""function checkExpirationDate2() """),format.raw/*494.39*/("""{"""),format.raw/*494.40*/("""
        """),format.raw/*495.9*/("""var input = document.getElementById('ngay_het_han_2').value;
        var expirationDate = new Date(input.split("/").reverse().join("-"));
        var currentDay = new Date();
        currentDay.setHours(0, 0, 0, 0);
        if (expirationDate <= currentDay) """),format.raw/*499.43*/("""{"""),format.raw/*499.44*/("""
          """),format.raw/*500.11*/("""showNotification('danger',Messages("Ngày hết hạn không được nhỏ hơn ngày hiện tại"));
          document.getElementById('ngay_het_han_2').value = "";
        """),format.raw/*502.9*/("""}"""),format.raw/*502.10*/("""
      """),format.raw/*503.7*/("""}"""),format.raw/*503.8*/("""
      """),format.raw/*504.7*/("""function checkExpirationDate3() """),format.raw/*504.39*/("""{"""),format.raw/*504.40*/("""
        """),format.raw/*505.9*/("""var input = document.getElementById('ngay_het_han_3').value;
        var expirationDate = new Date(input.split("/").reverse().join("-"));
        var currentDay = new Date();
        currentDay.setHours(0, 0, 0, 0);
        if (expirationDate <= currentDay) """),format.raw/*509.43*/("""{"""),format.raw/*509.44*/("""
          """),format.raw/*510.11*/("""showNotification('danger',Messages("Ngày hết hạn không được nhỏ hơn ngày hiện tại"));
          document.getElementById('ngay_het_han_3').value = "";
        """),format.raw/*512.9*/("""}"""),format.raw/*512.10*/("""
      """),format.raw/*513.7*/("""}"""),format.raw/*513.8*/("""
  """),format.raw/*514.3*/("""</script>"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:53 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/order/OrderSubscriber_sim_infoKH.scala.html
                  HASH: 08aadfe601119b1d70a816ce01183b094f54963b
                  MATRIX: 663->1|1019->35|1132->53|1159->54|1319->188|1374->223|1575->397|1620->421|1672->445|1707->458|1881->605|1929->632|2000->676|2043->698|2289->917|2329->936|2381->960|2416->973|2585->1115|2661->1170|2907->1389|2946->1407|2998->1431|3033->1444|3414->1798|3457->1820|3509->1844|3544->1857|3901->2187|3948->2213|4000->2237|4035->2250|4396->2584|4436->2603|4488->2627|4523->2640|4779->2869|4820->2889|5053->3095|5097->3118|5305->3299|5347->3320|5851->3797|5901->3826|5953->3850|5988->3863|6231->4078|6269->4094|7130->4927|7173->4948|7226->4972|7262->4985|7636->5331|7681->5354|8048->5693|8089->5712|8328->5950|8359->5953|8486->6052|8548->6092|8750->6266|8798->6292|8851->6316|8887->6329|9282->6696|9328->6720|9381->6744|9417->6757|9592->6904|9644->6934|9896->7158|9937->7177|9990->7201|10026->7214|10198->7358|10250->7388|10502->7612|10546->7634|10599->7658|10635->7671|11067->8075|11111->8097|11276->8234|11313->8249|11382->8290|11418->8304|11667->8525|11710->8546|11763->8570|11799->8583|12175->8931|12216->8950|12269->8974|12305->8987|12566->9220|12608->9240|12846->9450|12891->9473|13102->9656|13145->9677|13652->10156|13703->10185|13756->10209|13792->10222|14036->10438|14074->10454|14158->10510|14196->10526|15317->11619|15358->11638|15599->11877|15630->11880|15757->11979|15817->12017|16019->12191|16067->12217|16120->12241|16156->12254|16553->12623|16599->12647|16652->12671|16688->12684|16863->12831|16915->12861|17167->13085|17208->13104|17261->13128|17297->13141|17469->13285|17521->13315|17773->13539|17817->13561|17870->13585|17906->13598|18339->14003|18383->14025|18548->14162|18585->14177|18654->14218|18690->14232|18939->14453|18982->14474|19035->14498|19071->14511|19447->14859|19488->14878|19541->14902|19577->14915|19838->15148|19880->15168|20118->15378|20163->15401|20374->15584|20417->15605|20924->16084|20975->16113|21028->16137|21064->16150|21308->16366|21346->16382|21430->16438|21468->16454|22585->17543|22626->17562|22867->17833|22897->17835|22973->17882|23003->17883|23040->17892|23334->18157|23364->18158|23404->18169|23582->18319|23612->18320|23647->18327|23676->18328|23712->18336|23767->18362|23797->18363|23834->18372|24126->18635|24156->18636|24196->18647|24373->18796|24403->18797|24438->18804|24467->18805|24503->18813|24561->18842|24591->18843|24628->18852|24930->19125|24960->19126|25000->19137|25177->19286|25207->19287|25242->19294|25271->19295|25306->19302|25370->19337|25400->19338|25437->19347|25740->19621|25770->19622|25810->19633|25989->19784|26019->19785|26054->19792|26083->19793|26118->19800|26172->19825|26202->19826|26239->19835|26542->20109|26572->20110|26612->20121|26790->20271|26820->20272|26855->20279|26884->20280|26919->20287|26980->20319|27010->20320|27047->20329|27334->20587|27364->20588|27404->20599|27590->20757|27620->20758|27655->20765|27684->20766|27719->20773|27780->20805|27810->20806|27847->20815|28134->21073|28164->21074|28204->21085|28390->21243|28420->21244|28455->21251|28484->21252|28515->21255
                  LINES: 24->1|29->2|34->2|35->3|39->7|39->7|45->13|45->13|45->13|45->13|48->16|48->16|49->17|49->17|58->26|58->26|58->26|58->26|61->29|61->29|70->38|70->38|70->38|70->38|80->48|80->48|80->48|80->48|90->58|90->58|90->58|90->58|100->68|100->68|100->68|100->68|105->73|105->73|110->78|110->78|115->83|115->83|129->97|129->97|129->97|129->97|134->102|134->102|154->122|154->122|154->122|154->122|164->132|164->132|174->142|174->142|182->150|183->151|185->153|185->153|191->159|191->159|191->159|191->159|201->169|201->169|201->169|201->169|204->172|204->172|213->181|213->181|213->181|213->181|216->184|216->184|225->193|225->193|225->193|225->193|235->203|235->203|238->206|238->206|239->207|239->207|248->216|248->216|248->216|248->216|258->226|258->226|258->226|258->226|263->231|263->231|268->236|268->236|273->241|273->241|287->255|287->255|287->255|287->255|292->260|292->260|293->261|293->261|316->284|316->284|324->292|325->293|327->295|327->295|333->301|333->301|333->301|333->301|343->311|343->311|343->311|343->311|346->314|346->314|355->323|355->323|355->323|355->323|358->326|358->326|367->335|367->335|367->335|367->335|377->345|377->345|380->348|380->348|381->349|381->349|390->358|390->358|390->358|390->358|400->368|400->368|400->368|400->368|405->373|405->373|410->378|410->378|415->383|415->383|429->397|429->397|429->397|429->397|434->402|434->402|435->403|435->403|458->426|458->426|466->434|468->436|470->438|470->438|471->439|475->443|475->443|476->444|478->446|478->446|479->447|479->447|481->449|481->449|481->449|482->450|486->454|486->454|487->455|489->457|489->457|490->458|490->458|492->460|492->460|492->460|493->461|499->467|499->467|500->468|502->470|502->470|503->471|503->471|504->472|504->472|504->472|505->473|510->478|510->478|511->479|513->481|513->481|514->482|514->482|515->483|515->483|515->483|516->484|521->489|521->489|522->490|524->492|524->492|525->493|525->493|526->494|526->494|526->494|527->495|531->499|531->499|532->500|534->502|534->502|535->503|535->503|536->504|536->504|536->504|537->505|541->509|541->509|542->510|544->512|544->512|545->513|545->513|546->514
                  -- GENERATED --
              */
          