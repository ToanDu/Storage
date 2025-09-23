
package views.html.landingPage

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

object LandingPage_registerDeveloper extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="registerDeveloperModal" data-bs-backdrop="static" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block;">
        <h5 class="modal-title" id="exampleModalLabel" style="font-weight: 500; color: #000000;">"""),_display_(/*5.99*/Messages("Lợi ích khi đăng ký trở thành Nhà tích hợp - Nhà phát triển")),format.raw/*5.170*/("""</h5>
      </div>
      <div class="modal-body" style="background-color: #EE0033;">
        <div class="row" >
          <div class="col-md-3">
            <h4 class="text-white" style="text-align: center; font-weight: 600;">"""),_display_(/*10.83*/Messages("30%")),format.raw/*10.98*/("""</h4>
            <h6 class="text-white" style="text-align: center; font-weight: 300;">"""),_display_(/*11.83*/Messages("Được hưởng chiết khấu cao lên đến 30%")),format.raw/*11.132*/("""</h6>
          </div>
          <div class="col-md-3">
            <h4 class="text-white" style="text-align: center; font-weight: 600;">"""),_display_(/*14.83*/Messages("1.000$")),format.raw/*14.101*/("""</h4>
            <h6 class="text-white" style="text-align: center; font-weight: 300;">"""),_display_(/*15.83*/Messages("Nhận ngay 1.000$ tiền hoa hồng khi giới thiệu đối tác")),format.raw/*15.148*/("""</h6>
          </div>
          <div class="col-md-3">
            <h4 class="text-white" style="text-align: center; font-weight: 600;">"""),_display_(/*18.83*/Messages("180")),format.raw/*18.98*/("""</h4>
            <h6 class="text-white" style="text-align: center; font-weight: 300;">"""),_display_(/*19.83*/Messages("Tặng tài khoản V.I.P lên đến 180 ngày")),format.raw/*19.132*/("""</h6>
          </div>
          <div class="col-md-3">
            <h4 class="text-white" style="text-align: center; font-weight: 600;">"""),_display_(/*22.83*/Messages("24/7")),format.raw/*22.99*/("""</h4>
            <h6 class="text-white" style="text-align: center; font-weight: 300;">"""),_display_(/*23.83*/Messages("Đào tạo kiến thức và hỗ trợ kỹ thuật nhiệt tình 24/7")),format.raw/*23.147*/("""</h6>
          </div>
        </div>
      </div>

      <div class="modal-body">
        <h6>"""),_display_(/*29.14*/Messages("Đăng ký trở thành Nhà tích hợp / Nhà phát triển ngay hôm nay để nhận những thông tin và ưu đãi lớn nhất từ Nền tảng InnoWay.vn")),format.raw/*29.152*/("""</h6>
        <h4 style="font-weight: 500;">"""),_display_(/*30.40*/Messages("Thông tin của bạn")),format.raw/*30.69*/("""</h4>

        <div class="row">
          <div class="col-md-6">
            <div class="row mt-3">
              <label class="col-form-label">"""),_display_(/*35.46*/Messages("Vai trò *")),format.raw/*35.67*/("""</label>
              <div class="col-sm-12">
                <input id="roleRegister" type="text" class="form-control" autocomplete="off" placeholder="Nhà tích hợp, Nhà phát triển">
              </div>
            </div>
            <div class="row mt-3">
              <label class="col-form-label">"""),_display_(/*41.46*/Messages("Lĩnh vực phát triển *")),format.raw/*41.79*/("""</label>
              <div class="col-sm-12">
                <input id="fieldRegister" type="text" class="form-control" autocomplete="off" placeholder="Nhà thông minh, nông trại thông minh, ...">
              </div>
            </div>
            <div class="row mt-3">
              <label class="col-form-label">"""),_display_(/*47.46*/Messages("Số lượng thiết bị *")),format.raw/*47.77*/("""</label>
              <div class="col-sm-12">
                <input id="countDeviceRegister" type="text" class="form-control" autocomplete="off" placeholder="Số lượng thiết bị ước tính anh chị muốn tích hợp trong giải pháp của mình">
              </div>
            </div>
            <div class="row mt-3">
              <label class="col-form-label">"""),_display_(/*53.46*/Messages("Số lượng người dùng *")),format.raw/*53.79*/("""</label>
              <div class="col-sm-12">
                <input id="countUserRegister" type="number" class="form-control" autocomplete="off" placeholder="Số lượng khách hàng anh chị muốn phục vụ ">
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="row mt-3">
              <label class="col-form-label">"""),_display_(/*61.46*/Messages("Email *")),format.raw/*61.65*/("""</label>
              <div class="col-sm-12">
                <input id="emailRegister" type="text" class="form-control" autocomplete="off">
              </div>
            </div>
            <div class="row mt-3">
              <label class="col-form-label">"""),_display_(/*67.46*/Messages("Tên công ty *")),format.raw/*67.71*/("""</label>
              <div class="col-sm-12">
                <input id="nameCompanyRegister" type="text" class="form-control" autocomplete="off">
              </div>
            </div>
            <div class="row mt-3">
              <label class="col-form-label">"""),_display_(/*73.46*/Messages("Họ và tên liên hệ *")),format.raw/*73.77*/("""</label>
              <div class="col-sm-12">
                <input id="nameRegister" type="text" class="form-control" autocomplete="off" >
              </div>
            </div>
            <div class="row mt-3">
              <label class="col-form-label">"""),_display_(/*79.46*/Messages("Số điện thoại *")),format.raw/*79.73*/("""</label>
              <div class="col-sm-12">
                <input id="phoneRegister" type="number" class="form-control" autocomplete="off" >
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" onclick="registerDeveloper()">"""),_display_(/*88.85*/Messages("Gửi thông tin đăng ký")),format.raw/*88.118*/("""</button>
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*89.77*/Messages("Đóng")),format.raw/*89.93*/("""</button>
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
                  DATE: Mon Sep 22 16:32:47 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPage/LandingPage_registerDeveloper.scala.html
                  HASH: ad9d3df6f2bd3c125f86693f5198083c1414f578
                  MATRIX: 1066->0|1462->370|1554->441|1808->668|1844->683|1959->771|2030->820|2195->958|2235->976|2350->1064|2437->1129|2602->1267|2638->1282|2753->1370|2824->1419|2989->1557|3026->1573|3141->1661|3227->1725|3350->1821|3510->1959|3582->2004|3632->2033|3805->2179|3847->2200|4178->2504|4232->2537|4577->2855|4629->2886|5012->3242|5066->3275|5467->3649|5507->3668|5796->3930|5842->3955|6137->4223|6189->4254|6478->4516|6526->4543|6900->4890|6955->4923|7068->5009|7105->5025
                  LINES: 33->1|37->5|37->5|42->10|42->10|43->11|43->11|46->14|46->14|47->15|47->15|50->18|50->18|51->19|51->19|54->22|54->22|55->23|55->23|61->29|61->29|62->30|62->30|67->35|67->35|73->41|73->41|79->47|79->47|85->53|85->53|93->61|93->61|99->67|99->67|105->73|105->73|111->79|111->79|120->88|120->88|121->89|121->89
                  -- GENERATED --
              */
          