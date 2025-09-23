
package views.html.telco.survey

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

object Survey extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="updateTypeBusinessModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.65*/Messages("Khảo sát")),format.raw/*5.85*/("""</span>
        <h6 class="text-white">"""),_display_(/*6.33*/Messages("Kính gửi quý khách hàng, để cung cấp dịch vụ được tốt hơn, chúng tôi xin một số thông tin khảo sát về sản phẩm, dịch vụ, làm định hướng nâng cấp hệ thống trong giai đoạn tiếp theo. Rất mong quý khách hàng bỏ chút thời gian phản hồi đủ các nội dung.")),format.raw/*6.293*/("""</h6><h6 class="text-white">"""),_display_(/*6.322*/Messages("Xin trân trọng cảm ơn quý khách hàng.")),format.raw/*6.371*/("""</h6>
      </div>
      """),format.raw/*8.119*/("""
      """),format.raw/*9.7*/("""<div class="modal-body">
        <div class="m-t-3" style="border: 1px solid #dee2e6; padding: 15px;">
          <div class="row" style="margin-top: 5px;">
            <label class="col-sm-3 col-form-label title-section-2">Tên khách hàng *</label>
            <div class="col-sm-6">
              <input class="form-control" type="text" id="tenKhachHang" maxlength="50">
            </div>
          </div>
          <div class="row" style="margin-top: 5px;">
            <label class="col-sm-3 col-form-label title-section-2">Người liên hệ *</label>
            <div class="col-sm-6">
              <input class="form-control" type="text" id="ngLienHe" maxlength="50">
            </div>
          </div>
          <div class="row" style="margin-top: 5px;">
            <label class="col-sm-3 col-form-label title-section-2">Chức vụ *</label>
            <div class="col-sm-6">
              <input class="form-control" type="text" id="chucVu" maxlength="50">
            </div>
          </div>
            <div class="row" style="margin-top: 5px;">
                <label class="col-sm-3 col-form-label title-section-2">Số lượng thuê bao *</label>
                <div class="col-sm-6">
                    <input class="form-control" type="number" id="soThueBao" readonly>
                </div>
            </div>
        </div>
      </div>

      <div class="modal-body" style="padding-top: 0px;">

        <h6 class="m-t-3">"""),_display_(/*40.28*/Messages("1. Anh/chị có gặp bất tiện gì trong quá trình sử dụng không? Nếu có, xin cụ thể vấn đề gây khó chịu nhất? *")),format.raw/*40.147*/("""</h6>
        <textarea class="form-control" id="q1" maxlength="1000" rows="2" placeholder="...tối đa 1000 kí tự"></textarea>


        <h6 class="m-t-3">"""),_display_(/*44.28*/Messages("2. Có tính năng nào anh chị chưa thử dùng trên CMP? (chọn 1 hoặc nhiều phương án) *")),format.raw/*44.123*/("""</h6>
        <div>
          <div class="form-check form-check-inline">
            <input class="form-check-input q2" type="checkbox" id="q2-1" value="1">
            <label class="form-check-label" for="q2-1">"""),_display_(/*48.57*/Messages("Xem thông tin thuê bao")),format.raw/*48.91*/("""</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q2" type="checkbox" id="q2-2" value="2">
            <label class="form-check-label" for="q2-2">"""),_display_(/*52.57*/Messages("Quản lý hợp đồng")),format.raw/*52.85*/("""</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q2" type="checkbox" id="q2-3" value="3">
            <label class="form-check-label" for="q2-3">"""),_display_(/*56.57*/Messages("Tra cứu cước")),format.raw/*56.81*/("""</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q2" type="checkbox" id="q2-4" value="4">
            <label class="form-check-label" for="q2-4">"""),_display_(/*60.57*/Messages("Theo dõi nội dung thuê bao đã dùng")),format.raw/*60.103*/("""</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q2" type="checkbox" id="q2-5" value="5">
            <label class="form-check-label" for="q2-5">"""),_display_(/*64.57*/Messages("Định vị thuê bao")),format.raw/*64.85*/("""</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q2" type="checkbox" id="q2-6" value="6">
            <label class="form-check-label" for="q2-6">"""),_display_(/*68.57*/Messages("Đầu nối SIM")),format.raw/*68.80*/("""</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q2" type="checkbox" id="q2-7" value="7">
            <label class="form-check-label" for="q2-7">"""),_display_(/*72.57*/Messages("Chặn mở SIM")),format.raw/*72.80*/("""</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q2" type="checkbox" id="q2-8" value="8">
            <label class="form-check-label" for="q2-8">"""),_display_(/*76.57*/Messages("Nạp tiền cho thuê bao")),format.raw/*76.90*/("""</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q2" type="checkbox" id="q2-9" value="9">
            <label class="form-check-label" for="q2-9">"""),_display_(/*80.57*/Messages("Phân quyền user (theo phân cấp đơn vị) ")),format.raw/*80.108*/("""</label>
          </div><br>
        </div>
        <h6 class="m-t-3">"""),_display_(/*83.28*/Messages("Có 3 tính năng nâng cao sắp tới sẽ đưa vào triển khai, bạn thấy tính năng nào sẽ có ý nghĩa nhất với doanh nghiệp của mình? (chọn 1 phương án)*")),format.raw/*83.183*/("""</h6>
        <div>
          <div class="form-check form-check-inline">
            <input class="form-check-input q3" type="radio" id="q3_1" name="q3" value="1">
            <label class="form-check-label" for="q3_1">Tính năng tư vấn gói cước dựa trên lưu lượng tiêu dùng thực tế</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q3" type="radio" id="q3_2" name="q3" value="2">
            <label class="form-check-label" for="q3_2">Tính năng định vị thuê bao (cho bạn biết vị trí thực tế của từng thuê bao)</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q3" type="radio" id="q3_3" name="q3" value="3">
            <label class="form-check-label" for="q3_3">Hỗ trợ quản lý thiết bị (quản lý trạng thái, quản lý phiên bản phần mềm thiết bị, nâng cấp phần mềm thiết bị từ xa)</label>
          </div><br>
        </div>
        <h6 class="m-t-3">"""),_display_(/*98.28*/Messages(" Theo anh chị, hệ thống cần bổ sung thêm tính năng nào để Doanh nghiệp quản lý thuê bao tốt hơn? *")),format.raw/*98.138*/("""</h6>
        <textarea class="form-control" id="q4" maxlength="1000" rows="2" placeholder="...tối đa 1000 kí tự"></textarea>
        <h6 class="m-t-3">"""),_display_(/*100.28*/Messages("3. CMP có giúp đơn vị giảm được nhân sự vận hành hệ thống không? *")),format.raw/*100.106*/("""</h6>
        <div class="form-check form-check-inline">
          <input class="form-check-input q5" type="radio" id="q5_1" name="q5" value="1">
          <label class="form-check-label" for="q5_1">Có</label>
        </div><br>
        <div class="form-check form-check-inline">
          <input class="form-check-input q5" type="radio" id="q5_2" name="q5" value="2">
          <label class="form-check-label" for="q5_2">Không</label>
        </div><br>
        <h6 class="m-t-3">"""),_display_(/*109.28*/Messages("CMP giúp doanh nghiệp tiết kiệm thời gian trong khâu nào nhất? (quản lý SIM, nạp tiền, chặn/mở chặn, đấu nối SIM) *")),format.raw/*109.155*/("""</h6>
        <textarea class="form-control" id="q6" maxlength="1000" rows="2" placeholder="...tối đa 1000 kí tự"></textarea>
        <h6 class="m-t-3">"""),_display_(/*111.28*/Messages("4. Anh/chị có biết đến tính năng Quản lý hợp đồng của CMP không? *")),format.raw/*111.106*/("""</h6>
        <div class="form-check form-check-inline">
          <input class="form-check-input q7" type="radio" id="q7_1" name="q7" value="1">
          <label class="form-check-label" for="q5_1">Có</label>
        </div><br>
        <div class="form-check form-check-inline">
          <input class="form-check-input q7" type="radio" id="q7_2" name="q7" value="2">
          <label class="form-check-label" for="q7_2">Không</label>
        </div><br>
        <h6 class="m-t-3">"""),_display_(/*120.28*/Messages("Anh/chị có biết đến tính năng mua gói data/Mi của CMP không? *")),format.raw/*120.102*/("""</h6>
        <div class="form-check form-check-inline">
          <input class="form-check-input q8" type="radio" id="q8_1" name="q8" value="1">
          <label class="form-check-label" for="q8_1">Có</label>
        </div><br>
        <div class="form-check form-check-inline">
          <input class="form-check-input q8" type="radio" id="q8_2" name="q8" value="2">
          <label class="form-check-label" for="q8_2">Không</label>
        </div><br>
        <h6 class="m-t-3">"""),_display_(/*129.28*/Messages("Anh/chị có biết đến tính năng nạp tiền của CMP không? *")),format.raw/*129.95*/("""</h6>
        <div class="form-check form-check-inline">
          <input class="form-check-input q9" type="radio" id="q9_1" name="q9" value="1">
          <label class="form-check-label" for="9_1">Có</label>
        </div><br>
        <div class="form-check form-check-inline">
          <input class="form-check-input q9" type="radio" id="q9_2" name="q9" value="2">
          <label class="form-check-label" for="q9_2">Không</label>
        </div><br>
        <h6 class="m-t-3">"""),_display_(/*138.28*/Messages("Anh/chị có biết đến tính năng mở chiều/chặn chiều thuê bao của CMP không? *")),format.raw/*138.115*/("""</h6>
        <div class="form-check form-check-inline">
          <input class="form-check-input q10" type="radio" id="q10_1" name="q10" value="1">
          <label class="form-check-label" for="q10_1">Có</label>
        </div><br>
        <div class="form-check form-check-inline">
          <input class="form-check-input q10" type="radio" id="q10_2" name="q10" value="2">
          <label class="form-check-label" for="q10_2">Không</label>
        </div><br>
        <h6 class="m-t-3">"""),_display_(/*147.28*/Messages("Anh/chị có biết đến tính năng đấu nối/đặt hàng thuê bao của CMP không? *")),format.raw/*147.112*/("""</h6>
        <div class="form-check form-check-inline">
          <input class="form-check-input q11" type="radio" id="q11_1" name="q11" value="1">
          <label class="form-check-label" for="q11_1">Có</label>
        </div><br>
        <div class="form-check form-check-inline">
          <input class="form-check-input q11" type="radio" id="q11_2" name="q11" value="2">
          <label class="form-check-label" for="q11_2">Không</label>
        </div><br>
        <h6 class="m-t-3">"""),_display_(/*156.28*/Messages("Anh/chị có biết đến tính năng tạo user/phân quyền của CMP không? *")),format.raw/*156.106*/("""</h6>
        <div class="form-check form-check-inline">
          <input class="form-check-input q12" type="radio" id="q12" name="q12" value="1">
          <label class="form-check-label" for="q12_1">Có</label>
        </div><br>
        <div class="form-check form-check-inline">
          <input class="form-check-input q12" type="radio" id="q12_2" name="q12" value="2">
          <label class="form-check-label" for="q12_2">Không</label>
        </div><br>
        <h6 class="m-t-3">"""),_display_(/*165.28*/Messages("Anh/chị có biết đến tính năng định vị thuê bao của CMP không? (bạn có thể biết thuê bao nằm ở khu vực nào, đã di chuyển qua những nơi nào trong vòng 1 tuần, 1 tháng) *")),format.raw/*165.207*/("""</h6>
        <div class="form-check form-check-inline">
          <input class="form-check-input q13" type="radio" id="q13_1" name="q13" value="1">
          <label class="form-check-label" for="q13_1">Có</label>
        </div><br>
        <div class="form-check form-check-inline">
          <input class="form-check-input q13" type="radio" id="q13_2" name="q13" value="2">
          <label class="form-check-label" for="q13_2">Không</label>
        </div><br>
        <h6 class="m-t-3">"""),_display_(/*174.28*/Messages("Anh/chị có biết đến tính năng tư vấn gói cước phù hợp, dựa trên lưu lượng sử dụng thực tế của thuê bao không? *")),format.raw/*174.151*/("""</h6>
        <div class="form-check form-check-inline">
          <input class="form-check-input q14" type="radio" id="q14_1" name="q14" value="1">
          <label class="form-check-label" for="q14_1">Có</label>
        </div><br>
        <div class="form-check form-check-inline">
          <input class="form-check-input q14" type="radio" id="q14_2" name="q14" value="2">
          <label class="form-check-label" for="q14_2">Không</label>
        </div>
        <h6 class="m-t-3">"""),_display_(/*183.28*/Messages("5. Doanh nghiệp các anh chị, có đang duy trì đội ngũ phát triển ứng dụng, bảo trì hệ thống phần mềm cho sản phẩm dịch vụ của mình không? Đội ngũ bao nhiêu người (nếu có?) *")),format.raw/*183.212*/("""</h6>
        <div class="form-check form-check-inline">
          <input class="form-check-input q15" type="radio" id="q15_1" name="q15" value="1">
          <label class="form-check-label" for="q15_1">0</label>
        </div>
        <div class="form-check form-check-inline">
          <input class="form-check-input q15" type="radio" id="q15_2" name="q15" value="2">
          <label class="form-check-label" for="q15_2">1</label>
        </div>
        <div class="form-check form-check-inline">
          <input class="form-check-input q15" type="radio" id="q15_3" name="q15" value="3">
          <label class="form-check-label" for="q15_3">2</label>
        </div>
        <div class="form-check form-check-inline">
          <input class="form-check-input q15" type="radio" id="q15_4" name="q15" value="4">
          <label class="form-check-label" for="q15_4">3</label>
        </div>
        <div class="form-check form-check-inline">
          <input class="form-check-input q15" type="radio" id="q15_5" name="q15" value="5">
          <label class="form-check-label" for="q15_5">4</label>
        </div>
        <div class="form-check form-check-inline">
          <input class="form-check-input q15" type="radio" id="q15_6" name="q15" value="6">
          <label class="form-check-label" for="q15_6"> &gt 5</label>
        </div>
        <h6 class="m-t-3">"""),_display_(/*208.28*/Messages("Ứng dụng IoT của doanh nghiệp bạn thuộc lĩnh vực nào? (chọn nhiều phương án) *")),format.raw/*208.118*/("""</h6>
        <div>
          <div class="form-check form-check-inline">
            <input class="form-check-input q16" type="checkbox" id="q16_1" value="1">
            <label class="form-check-label" for="q16_1">"""),_display_(/*212.58*/Messages("Giao thông")),format.raw/*212.80*/("""</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q16" type="checkbox" id="q16_2" value="2">
            <label class="form-check-label" for="q16_2">"""),_display_(/*216.58*/Messages("Vận tải ( khách, hàng hóa)")),format.raw/*216.96*/("""</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q16" type="checkbox" id="q16_3" value="3">
            <label class="form-check-label" for="q16_3">"""),_display_(/*220.58*/Messages("Quản lý thú cưng, tài sản")),format.raw/*220.95*/("""</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q16" type="checkbox" id="q16_4" value="4">
            <label class="form-check-label" for="q16_4">"""),_display_(/*224.58*/Messages("Y tế - Chăm sóc sức khỏe")),format.raw/*224.94*/("""</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q16" type="checkbox" id="q16_5" value="5">
            <label class="form-check-label" for="q16_5">"""),_display_(/*228.58*/Messages("Đo lường (điện, nước)")),format.raw/*228.91*/("""</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q16" type="checkbox" id="q16_6" value="6">
            <label class="form-check-label" for="q16_6">"""),_display_(/*232.58*/Messages("Phát wifi")),format.raw/*232.79*/("""</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q16" type="checkbox" id="q16_7" value="7">
            <label class="form-check-label" for="q16_7">"""),_display_(/*236.58*/Messages("Camera giám sát")),format.raw/*236.85*/("""</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q16" type="checkbox" id="q16_8" value="8">
            <label class="form-check-label" for="q16_8">"""),_display_(/*240.58*/Messages("Đèn đường")),format.raw/*240.79*/("""</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q16" type="checkbox" id="q2-9" value="9">
            <label class="form-check-label" for="q16_9">"""),_display_(/*244.58*/Messages("Nông nghiệp (cây trồng) ")),format.raw/*244.94*/("""</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q16" type="checkbox" id="q16_10" value="10">
            <label class="form-check-label" for="q16_10">"""),_display_(/*248.59*/Messages("Thủy canh (tôm, cá) ")),format.raw/*248.91*/("""</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q16" type="checkbox" id="q16_11" value="11">
            <label class="form-check-label" for="q16_11">"""),_display_(/*252.59*/Messages("Quan trắc môi trường (nguồn nước, không khí, nước thải) ")),format.raw/*252.127*/("""</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q16" type="checkbox" id="q16_12" value="12">
            <label class="form-check-label" for="q16_12">"""),_display_(/*256.59*/Messages("Sản xuất - truyền tải điệ ")),format.raw/*256.97*/("""</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q16" type="checkbox" id="q16_13" value="13">
            <label class="form-check-label" for="q16_13">"""),_display_(/*260.59*/Messages("Đồng hồ thông minh (trẻ em, thể thao) ")),format.raw/*260.109*/("""</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q16" type="checkbox" id="q16_14" value="14">
            <label class="form-check-label" for="q16_14">"""),_display_(/*264.59*/Messages("Lĩnh vực khác... ")),format.raw/*264.88*/("""</label>
          </div><br>
        </div>
        <h6 class="m-t-3">"""),_display_(/*267.28*/Messages("Số lượng kết nối của Doanh nghiệp hiện tại đang là bao nhiêu? *")),format.raw/*267.103*/("""</h6>
        <textarea class="form-control" id="q17" maxlength="1000" rows="2" placeholder="...tối đa 1000 kí tự"></textarea>
        <h6 class="m-t-3">"""),_display_(/*269.28*/Messages("Nếu Viettel hỗ trợ chuyển đổi nền tảng phần mềm (gồm tích hợp thiết bị, web, mobile app), đồng thời tối ưu chi phí vận hành cho doanh nghiệp (thấp hơn mức hiện phải chi trả), thì doanh nghiệp có sẵn sàng thử nghiệm dùng nền tảng phần mềm của Viettel không? *")),format.raw/*269.298*/("""</h6>
        <div>
          <div class="form-check form-check-inline">
            <input class="form-check-input q18" type="radio" id="q18_1" name="q18" value="1">
            <label class="form-check-label" for="q18_1">Không</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q18" type="radio" id="q18_2" name="q18" value="2">
            <label class="form-check-label" for="q18_2">Xem xét</label>
          </div><br>
          <div class="form-check form-check-inline">
            <input class="form-check-input q18" type="radio" id="q18_3" name="q18" value="3">
            <label class="form-check-label" for="q18_3">Sẵn sàng</label>
          </div><br>
        </div>
        <h6 class="m-t-3">"""),_display_(/*284.28*/Messages("7. Điều gì của CMP sẽ khiến các bạn giới thiệu cho bạn bè (đồng nghiệp) biết đến và sử dụng phần mềm này?  *")),format.raw/*284.148*/("""</h6>
        <textarea class="form-control" id="q19" maxlength="1000" rows="2" placeholder="...tối đa 1000 kí tự"></textarea>
        <h6 class="m-t-3">"""),_display_(/*286.28*/Messages("Bạn có gợi ý nào để chúng tôi có thể hoàn thiện sản phẩm CMP tốt hơn cho nhu cầu của doanh nghiệp bạn? *")),format.raw/*286.144*/("""</h6>
        <textarea class="form-control" id="q20" maxlength="1000" rows="2" placeholder="...tối đa 1000 kí tự"></textarea>
        <h6 class="m-t-3">"""),_display_(/*288.28*/Messages("Nếu bạn chỉ mô tả CMP bằng 1 câu, thì bạn sẽ mô tả thế nào? *")),format.raw/*288.101*/("""</h6>
        <textarea class="form-control" id="q21" maxlength="1000" rows="2" placeholder="...tối đa 1000 kí tự"></textarea>

      </div>

      <h5 style="text-align: center">"""),_display_(/*293.39*/Messages("Cảm ơn quý khách hàng đã tham gia khảo sát")),format.raw/*293.93*/("""</h5>

      <div class="modal-footer">
        <button type="button" class="btn btn-red" onclick="comfirmSurvey()">"""),_display_(/*296.78*/Messages("btnComfirm")),format.raw/*296.100*/("""</button>
      </div>
    </div>
  </div>
</div>

<script src=""""),_display_(/*302.15*/routes/*302.21*/.Assets.versioned("javascripts/views/telco/survey/Survey.js")),format.raw/*302.82*/("""" type="text/javascript"></script>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:55 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/survey/Survey.scala.html
                  HASH: b53260e9f2db4a67b5366942fbd42e3b85c2ae87
                  MATRIX: 1044->0|1485->415|1525->435|1591->475|1872->735|1928->764|1998->813|2051->950|2084->957|3544->2390|3685->2509|3867->2664|3984->2759|4224->2972|4279->3006|4529->3229|4578->3257|4828->3480|4873->3504|5123->3727|5191->3773|5441->3996|5490->4024|5740->4247|5784->4270|6034->4493|6078->4516|6328->4739|6382->4772|6632->4995|6705->5046|6804->5118|6981->5273|8008->6273|8140->6383|8321->6536|8422->6614|8932->7096|9082->7223|9263->7376|9364->7454|9874->7936|9971->8010|10481->8492|10570->8559|11079->9040|11189->9127|11707->9617|11814->9701|12332->10191|12433->10269|12949->10757|13151->10936|13669->11426|13815->11549|14329->12035|14536->12219|15934->13589|16047->13679|16291->13895|16335->13917|16589->14143|16649->14181|16903->14407|16962->14444|17216->14670|17274->14706|17528->14932|17583->14965|17837->15191|17880->15212|18134->15438|18183->15465|18437->15691|18480->15712|18733->15937|18791->15973|19048->16202|19102->16234|19359->16463|19450->16531|19707->16760|19767->16798|20024->17027|20097->17077|20354->17306|20405->17335|20505->17407|20603->17482|20785->17636|21078->17906|21887->18687|22030->18807|22212->18961|22351->19077|22533->19231|22629->19304|22837->19484|22913->19538|23058->19655|23103->19677|23196->19742|23212->19748|23295->19809
                  LINES: 33->1|37->5|37->5|38->6|38->6|38->6|38->6|40->8|41->9|72->40|72->40|76->44|76->44|80->48|80->48|84->52|84->52|88->56|88->56|92->60|92->60|96->64|96->64|100->68|100->68|104->72|104->72|108->76|108->76|112->80|112->80|115->83|115->83|130->98|130->98|132->100|132->100|141->109|141->109|143->111|143->111|152->120|152->120|161->129|161->129|170->138|170->138|179->147|179->147|188->156|188->156|197->165|197->165|206->174|206->174|215->183|215->183|240->208|240->208|244->212|244->212|248->216|248->216|252->220|252->220|256->224|256->224|260->228|260->228|264->232|264->232|268->236|268->236|272->240|272->240|276->244|276->244|280->248|280->248|284->252|284->252|288->256|288->256|292->260|292->260|296->264|296->264|299->267|299->267|301->269|301->269|316->284|316->284|318->286|318->286|320->288|320->288|325->293|325->293|328->296|328->296|334->302|334->302|334->302
                  -- GENERATED --
              */
          