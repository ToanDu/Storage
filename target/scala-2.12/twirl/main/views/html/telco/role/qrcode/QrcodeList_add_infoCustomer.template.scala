
package views.html.telco.role.qrcode

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

object QrcodeList_add_infoCustomer extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addInfoCustomerModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <span class="modal-title" id="exampleModalLabel">"""),_display_(/*5.59*/Messages("Thông tin khách hàng")),format.raw/*5.91*/("""</span>
        <a class="close cursor-pointer" data-bs-dismiss="modal" aria-hidden="true" style="float: right; font-size: 20px;">×</a>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-sm-1"></div>
          <div class="col-sm-10">
            <div class="row mb-1">
              <span class="col-sm-3 col-form-label">"""),_display_(/*13.54*/Messages("Tên khách hàng *")),format.raw/*13.82*/("""</span>
              <div class="col-sm-5">
                <input type="text" class="form-control input-form" id="nameCustomer" maxlength="50"/>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-3 col-form-label">"""),_display_(/*19.54*/Messages("Loại KH *")),format.raw/*19.75*/("""</span>
              <div class="col-sm-5">
                <select class="form-control select-form" id="typeCustomer">
                  <option value="VTL" selected>"""),_display_(/*22.49*/Messages("KH doanh nghiệp")),format.raw/*22.76*/("""</option>
                  <option value="VIE" >"""),_display_(/*23.41*/Messages("KH cá nhân")),format.raw/*23.63*/("""</option>
                </select>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-3 col-form-label">"""),_display_(/*28.54*/Messages("Ngày sinh *")),format.raw/*28.77*/("""</span>
              <div class="col-sm-5">
                <input id="birthdayCustomer" type="text" class="form-control input-form date_timepicker" maxlength="50" placeholder="DD/MM/YYYY">
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-3 col-form-label">"""),_display_(/*34.54*/Messages("Giới tính *")),format.raw/*34.77*/("""</span>
              <div class="col-sm-5">
                <select class="form-control select-form" id="sexCustomer">
                  <option value="M">"""),_display_(/*37.38*/Messages("Nam")),format.raw/*37.53*/("""</option>
                  <option value="F">"""),_display_(/*38.38*/Messages("Nữ")),format.raw/*38.52*/("""</option>
                </select>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-3 col-form-label">"""),_display_(/*43.54*/Messages("Quốc tịch *")),format.raw/*43.77*/("""</span>
              <div class="col-sm-5">
                <select class="form-control" id="nationCustomer">
                  <option value="vietnam">"""),_display_(/*46.44*/Messages("Việt Nam")),format.raw/*46.64*/("""</option>
                </select>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-3 col-form-label">"""),_display_(/*51.54*/Messages("Địa chỉ *")),format.raw/*51.75*/("""</span>
              <div class="col-sm-9">
                <div class="row">
                  <div class="col-sm-4 mb-1">
                    <select class="form-control" id="tinhTp" onchange="selectDistrict()">
                      <option value="">"""),_display_(/*56.41*/Messages("Tỉnh/ TP")),format.raw/*56.61*/("""</option>
                    </select>
                  </div>
                  <div class="col-sm-4 mb-1">
                    <select class="form-control" id="quanHuyen" onchange="selectWard()">
                      <option value="">"""),_display_(/*61.41*/Messages("Huyện/ Quận")),format.raw/*61.64*/("""</option>
                    </select>
                  </div>
                  <div class="col-sm-4 mb-1">
                    <select class="form-control" id="phuongXa">
                      <option value="">"""),_display_(/*66.41*/Messages("Phường/Xã")),format.raw/*66.62*/("""</option>
                    </select>
                  </div>
                  <div class="col-sm-12 mb-1">
                    <input id="diaChiChiTiet" type="text" class="form-control input-form" maxlength="500" placeholder="Địa chỉ chi tiết">
                  </div>
                </div>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-3 col-form-label">"""),_display_(/*76.54*/Messages("Thông tin giấy tờ *")),format.raw/*76.85*/("""</span>
              <div class="col-sm-9">
                <div class="row">
                  <div class="col-sm-6 mb-1">
                    <select class="form-control" id="loai_giay_to">
                      <option value="ID">"""),_display_(/*81.43*/Messages("Chứng mình thư")),format.raw/*81.69*/("""</option>
                      <option value="IDC" selected>"""),_display_(/*82.53*/Messages("Căn cước công dân")),format.raw/*82.82*/("""</option>
                    </select>
                  </div>
                  <div class="col-sm-6 mb-1">
                    <input id="so_giay_to" type="text" class="form-control input-form" maxlength="50" placeholder="Số giấy tờ">
                  </div>
                  <div class="col-sm-6 mb-1">
                    <input id="noi_cap" type="text" class="form-control input-form" maxlength="50" placeholder="Nơi cấp">
                  </div>
                  <div class="col-sm-6 mb-1">
                    <input id="ngay_cap" type="text" class="form-control input-form date_timepicker" maxlength="50" placeholder="Ngày cấp">
                  </div>
                  <div class="col-sm-6 mb-1">
                    <input id="ngay_het_han" type="text" class="form-control input-form date_timepicker" maxlength="50" placeholder="Ngày hết hạn">
                  </div>
                </div>
              </div>
            </div>



            <div class="modal-footer">
              <button type="button" class="btn btn-cancle" onclick="backModalImportSerial()">"""),_display_(/*104.95*/Messages("Trở về")),format.raw/*104.113*/("""</button>
              <button type="button" class="btn btn-red" onclick="nextModalUpfileCustomer()">"""),_display_(/*105.94*/Messages("btnPrev")),format.raw/*105.113*/("""</button>
            </div>
          </div>
          <div class="col-sm-1"></div>
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
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/qrcode/QrcodeList_add_infoCustomer.scala.html
                  HASH: 6dbb477489759a1ef966b59a55b90608856621cc
                  MATRIX: 1070->0|1459->363|1511->395|1905->762|1954->790|2256->1065|2298->1086|2494->1255|2542->1282|2619->1332|2662->1354|2853->1518|2897->1541|3243->1860|3287->1883|3471->2040|3507->2055|3581->2102|3616->2116|3807->2280|3851->2303|4032->2457|4073->2477|4264->2641|4306->2662|4588->2917|4629->2937|4896->3177|4940->3200|5182->3415|5224->3436|5677->3862|5729->3893|5991->4128|6038->4154|6127->4216|6177->4245|7291->5331|7332->5349|7463->5452|7505->5471
                  LINES: 33->1|37->5|37->5|45->13|45->13|51->19|51->19|54->22|54->22|55->23|55->23|60->28|60->28|66->34|66->34|69->37|69->37|70->38|70->38|75->43|75->43|78->46|78->46|83->51|83->51|88->56|88->56|93->61|93->61|98->66|98->66|108->76|108->76|113->81|113->81|114->82|114->82|136->104|136->104|137->105|137->105
                  -- GENERATED --
              */
          