
package views.html.telco.devices

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

object Device_history_modal extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!-- Modal -->
<div class="modal fade" id="modal_history" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Lịch sử thông tin SIM - Thiết bị</h5>
            </div>

            <div class="modal-body">
                <div class="container-fluid px-3 text-center">
                    <div class="row mb-2 justify-content-center">
                        <div class="col-sm-2 fw-semibold">
                            <b>Số thuê bao:</b>
                        </div>
                        <div class="col-sm-4 text-start">
                            <b>0912345678</b>
                        </div>
                    </div>
                    <div class="row mb-4 justify-content-center">
                        <div class="col-sm-2 fw-semibold">
                            <b>Serial SIM:</b>
                        </div>
                        <div class="col-sm-4 text-start">
                            <b>1234567891234567890</b>
                        </div>
                    </div>
                </div>


                <div class="table-responsive">
                    <table class="table table-bordered table-striped text-center">
                        <thead style="background-color: #FBCCD6;" class="fw-bold">
                            <tr>
                                <th>STT</th>
                                <th>IMEI thiết bị</th>
                                <th>Loại thiết bị</th>
                                <th>Tên thiết bị</th>
                                <th>Hãng sản xuất</th>
                                <th>Thời gian kích hoạt</th>
                                <th>Thời gian tạm dừng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Dữ liệu mẫu -->
                            <tr>
                                <td>1</td>
                                <td>WW-XXXXXXX-YYYYYY-Z</td>
                                <td>Cảm biến</td>
                                <td>TEST-DEVICE-1</td>
                                <td>Viettel</td>
                                <td>00:00 01/01/2025</td>
                                <td>~</td>
                            </tr>
                            <!-- Thêm các dòng khác tại đây -->
                        </tbody>
                    </table>
                </div>
            </div>

           <div class="modal-footer">
                <button type="button" class="btn btn-red" data-bs-dismiss="modal" onclick="processBlockListSubs(0, '06')">"""),_display_(/*61.124*/Messages("btnComfirm")),format.raw/*61.146*/("""</button>
                <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*62.87*/Messages("btnCancel")),format.raw/*62.108*/("""</button>
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
                  DATE: Mon Sep 22 16:32:52 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/devices/Device_history_modal.scala.html
                  HASH: 80c7ca90b3f98e1b38c7fd6726dbe4a4525013c1
                  MATRIX: 1059->0|3792->2705|3836->2727|3959->2823|4002->2844
                  LINES: 33->1|93->61|93->61|94->62|94->62
                  -- GENERATED --
              */
          