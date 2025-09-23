
package views.html.telco.dashboard

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

object DashboardTelco_company extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="updateTypeBusinessModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.65*/Messages("survey.title")),format.raw/*5.89*/("""</span>
        <h6 class="text-white">"""),_display_(/*6.33*/Messages("survey.description")),format.raw/*6.63*/("""</h6>
      </div>
      """),format.raw/*8.119*/("""
      """),format.raw/*9.7*/("""<div class="modal-body" id="bodyTypeBusiness">

      </div>

      <div class="modal-body" id="">

        <h6 class="m-t-3">"""),_display_(/*15.28*/Messages("survey.question1")),format.raw/*15.56*/(""" """),format.raw/*15.57*/("""<span class="text-red">"""),_display_(/*15.81*/Messages("account.required")),format.raw/*15.109*/("""</span></h6>
        <div>
          <div class="form-check">
            <input class="form-check-input hardMonth" type="checkbox" id="hardMonth_1" value="1">
            <label class="form-check-label" for="hardMonth_1">"""),_display_(/*19.64*/Messages("survey.option.topup")),format.raw/*19.95*/("""</label>
          </div>
          <div class="form-check">
            <input class="form-check-input hardMonth" type="checkbox" id="hardMonth_2" value="2">
            <label class="form-check-label" for="hardMonth_2">"""),_display_(/*23.64*/Messages("survey.option.checkStatus")),format.raw/*23.101*/("""</label>
          </div>
          <div class="form-check">
            <input class="form-check-input hardMonth" type="checkbox" id="hardMonth_3" value="3">
            <label class="form-check-label" for="hardMonth_3">"""),_display_(/*27.64*/Messages("survey.option.newConnection")),format.raw/*27.103*/("""</label>
          </div>
          <div class="form-check">
            <input class="form-check-input hardMonth" type="checkbox" id="hardMonth_4" value="4">
            <label class="form-check-label" for="hardMonth_4">"""),_display_(/*31.64*/Messages("survey.option.blockUnblock")),format.raw/*31.102*/("""</label>
          </div>
          <div class="form-check">
            <input class="form-check-input hardMonth" type="checkbox" id="hardMonth_5" value="5">
            <label class="form-check-label" for="hardMonth_5">"""),_display_(/*35.64*/Messages("survey.option.buySim")),format.raw/*35.96*/("""</label>
          </div>
          <div class="form-check">
            <input class="form-check-input hardMonth" type="checkbox" id="hardMonth_6" value="6">
            <label class="form-check-label" for="hardMonth_6">"""),_display_(/*39.64*/Messages("survey.option.invoiceManagement")),format.raw/*39.107*/("""</label>
          </div>
          <div class="form-check">
            <input class="form-check-input hardMonth" type="checkbox" id="hardMonth_7" value="7">
            <label class="form-check-label" for="hardMonth_7">"""),_display_(/*43.64*/Messages("survey.option.contractManagement")),format.raw/*43.108*/("""</label>
          </div>
        </div>

        <h6 class="m-t-3">"""),_display_(/*47.28*/Messages("2. Đánh giá tổng thể về trải nghiệm sử dụng nền tảng quản lý kết nối M2M IoT")),format.raw/*47.116*/(""" """),format.raw/*47.117*/("""<span class="text-red">"""),_display_(/*47.141*/Messages("*")),format.raw/*47.154*/("""</span></h6>
        <div>
          <div class="form-check form-check-inline">
            <input class="form-check-input experience" type="radio" id="experience_1" name="experience" value="1">
            <label class="form-check-label" for="experience_1">"""),_display_(/*51.65*/Messages("Rất không hài lòng")),format.raw/*51.95*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input experience" type="radio" id="experience_2" name="experience" value="2">
            <label class="form-check-label" for="experience_2">"""),_display_(/*55.65*/Messages("Không hài lòng")),format.raw/*55.91*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input experience" type="radio" id="experience_3" name="experience" value="3">
            <label class="form-check-label" for="experience_3">"""),_display_(/*59.65*/Messages("Hài lòng")),format.raw/*59.85*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input experience" type="radio" id="experience_4" name="experience" value="4">
            <label class="form-check-label" for="experience_4">"""),_display_(/*63.65*/Messages("Rất hài lòng")),format.raw/*63.89*/("""</label>
          </div>
        </div>

        <h6 class="m-t-3">"""),_display_(/*67.28*/Messages("3. Đánh giá về mức độ dễ sử dụng của website")),format.raw/*67.84*/(""" """),format.raw/*67.85*/("""<span class="text-red">"""),_display_(/*67.109*/Messages("*")),format.raw/*67.122*/("""</span></h6>
        <div>
          <div class="form-check form-check-inline">
            <input class="form-check-input easeUse" type="radio" id="easeUse_1" name="easeUse" value="1">
            <label class="form-check-label" for="easeUse_1">"""),_display_(/*71.62*/Messages("Rất không hài lòng")),format.raw/*71.92*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input easeUse" type="radio" id="easeUse_2" name="easeUse" value="2">
            <label class="form-check-label" for="easeUse_2">"""),_display_(/*75.62*/Messages("Không hài lòng")),format.raw/*75.88*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input easeUse" type="radio" id="easeUse_3" name="easeUse" value="3">
            <label class="form-check-label" for="easeUse_3">"""),_display_(/*79.62*/Messages("Hài lòng")),format.raw/*79.82*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input easeUse" type="radio" id="easeUse_4" name="easeUse" value="4">
            <label class="form-check-label" for="easeUse_4">"""),_display_(/*83.62*/Messages("Rất hài lòng")),format.raw/*83.86*/("""</label>
          </div>
        </div>

        <h6 class="m-t-3">"""),_display_(/*87.28*/Messages("4. Bạn thường xuyên sử dụng dịch vụ nào nhất? (Có thể chọn nhiều đáp án)")),format.raw/*87.112*/(""" """),format.raw/*87.113*/("""<span class="text-red">"""),_display_(/*87.137*/Messages("*")),format.raw/*87.150*/("""</span></h6>
        <div>
          <div class="form-check form-check-inline">
            <input class="form-check-input sometimeUse" type="checkbox" id="sometimeUse_1" value="1">
            <label class="form-check-label" for="sometimeUse_1">"""),_display_(/*91.66*/Messages("Quản lý thuê bao")),format.raw/*91.94*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input sometimeUse" type="checkbox" id="sometimeUse_2" value="2">
            <label class="form-check-label" for="sometimeUse_2">"""),_display_(/*95.66*/Messages("Quản lý hợp đồng")),format.raw/*95.94*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input sometimeUse" type="checkbox" id="sometimeUse_3" value="3">
            <label class="form-check-label" for="sometimeUse_3">"""),_display_(/*99.66*/Messages("Quản lý đơn hàng")),format.raw/*99.94*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input sometimeUse" type="checkbox" id="sometimeUse_4" value="4">
            <label class="form-check-label" for="sometimeUse_4">"""),_display_(/*103.66*/Messages("Chặn/mở chiều thuê bao")),format.raw/*103.100*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input sometimeUse" type="checkbox" id="sometimeUse_5" value="5">
            <label class="form-check-label" for="sometimeUse_5">"""),_display_(/*107.66*/Messages("Nạp tiền")),format.raw/*107.86*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input sometimeUse" type="checkbox" id="sometimeUse_6" value="6">
            <label class="form-check-label" for="sometimeUse_6">"""),_display_(/*111.66*/Messages("Đăng ký gói cước")),format.raw/*111.94*/("""</label>
          </div>
        </div>

        <h6 class="m-t-3">"""),_display_(/*115.28*/Messages("5. Đánh giá các dịch vụ của nền tảng")),format.raw/*115.76*/(""" """),format.raw/*115.77*/("""<span class="text-red">"""),_display_(/*115.101*/Messages("*")),format.raw/*115.114*/("""</span></h6>
        <div class="row">
          <div class="col-md-3">
            <div class="form-check form-check-inline">
              <label class="form-check-label">"""),_display_(/*119.48*/Messages("Quản lý thuê bao")),format.raw/*119.76*/("""</label>
            </div>
          </div>
          <div class="col-md-9">
            <div class="form-check form-check-inline">
              <input class="form-check-input manageSubs" type="radio" id="manageSubs_1" name="manageSubs" value="1">
              <label class="form-check-label" for="manageSubs_1">"""),_display_(/*125.67*/Messages("Rất không hài lòng")),format.raw/*125.97*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input manageSubs" type="radio" id="manageSubs_2" name="manageSubs" value="2">
              <label class="form-check-label" for="manageSubs_2">"""),_display_(/*129.67*/Messages("Không hài lòng")),format.raw/*129.93*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input manageSubs" type="radio" id="manageSubs_3" name="manageSubs" value="3">
              <label class="form-check-label" for="manageSubs_3">"""),_display_(/*133.67*/Messages("Hài lòng")),format.raw/*133.87*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input manageSubs" type="radio" id="manageSubs_4" name="manageSubs" value="4">
              <label class="form-check-label" for="manageSubs_4">"""),_display_(/*137.67*/Messages("Rất hài lòng")),format.raw/*137.91*/("""</label>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-md-3">
            <div class="form-check form-check-inline">
              <label class="form-check-label">"""),_display_(/*145.48*/Messages("Quản lý hợp đồng")),format.raw/*145.76*/("""</label>
            </div>
          </div>
          <div class="col-md-9">
            <div class="form-check form-check-inline">
              <input class="form-check-input manageContract" type="radio" id="manageContract_1" name="manageContract" value="1">
              <label class="form-check-label" for="manageContract_1">"""),_display_(/*151.71*/Messages("Rất không hài lòng")),format.raw/*151.101*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input manageContract" type="radio" id="manageContract_2" name="manageContract" value="2">
              <label class="form-check-label" for="manageContract_2">"""),_display_(/*155.71*/Messages("Không hài lòng")),format.raw/*155.97*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input manageContract" type="radio" id="manageContract_3" name="manageContract" value="3">
              <label class="form-check-label" for="manageContract_3">"""),_display_(/*159.71*/Messages("Hài lòng")),format.raw/*159.91*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input manageContract" type="radio" id="manageContract_4" name="manageContract" value="4">
              <label class="form-check-label" for="manageContract_4">"""),_display_(/*163.71*/Messages("Rất hài lòng")),format.raw/*163.95*/("""</label>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-md-3">
            <div class="form-check form-check-inline">
              <label class="form-check-label">"""),_display_(/*171.48*/Messages("Quản lý đơn hàng")),format.raw/*171.76*/("""</label>
            </div>
          </div>
          <div class="col-md-9">
            <div class="form-check form-check-inline">
              <input class="form-check-input manageOrder" type="radio" id="manageOrder_1" name="manageOrder" value="1">
              <label class="form-check-label" for="manageOrder_1">"""),_display_(/*177.68*/Messages("Rất không hài lòng")),format.raw/*177.98*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input manageOrder" type="radio" id="manageOrder_2" name="manageOrder" value="2">
              <label class="form-check-label" for="manageOrder_2">"""),_display_(/*181.68*/Messages("Không hài lòng")),format.raw/*181.94*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input manageOrder" type="radio" id="manageOrder_3" name="manageOrder" value="3">
              <label class="form-check-label" for="manageOrder_3">"""),_display_(/*185.68*/Messages("Hài lòng")),format.raw/*185.88*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input manageOrder" type="radio" id="manageOrder_4" name="manageOrder" value="4">
              <label class="form-check-label" for="manageOrder_4">"""),_display_(/*189.68*/Messages("Rất hài lòng")),format.raw/*189.92*/("""</label>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-md-3">
            <div class="form-check form-check-inline">
              <label class="form-check-label">"""),_display_(/*197.48*/Messages("Chặn chiều TB")),format.raw/*197.73*/("""</label>
            </div>
          </div>
          <div class="col-md-9">
            <div class="form-check form-check-inline">
              <input class="form-check-input blockSub" type="radio" id="blockSub_1" name="blockSub" value="1">
              <label class="form-check-label" for="blockSub_1">"""),_display_(/*203.65*/Messages("Rất không hài lòng")),format.raw/*203.95*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input blockSub" type="radio" id="blockSub_2" name="blockSub" value="2">
              <label class="form-check-label" for="blockSub_2">"""),_display_(/*207.65*/Messages("Không hài lòng")),format.raw/*207.91*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input blockSub" type="radio" id="blockSub_3" name="blockSub" value="3">
              <label class="form-check-label" for="blockSub_3">"""),_display_(/*211.65*/Messages("Hài lòng")),format.raw/*211.85*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input blockSub" type="radio" id="blockSub_4" name="blockSub" value="4">
              <label class="form-check-label" for="blockSub_4">"""),_display_(/*215.65*/Messages("Rất hài lòng")),format.raw/*215.89*/("""</label>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-md-3">
            <div class="form-check form-check-inline">
              <label class="form-check-label">"""),_display_(/*223.48*/Messages("Mở chặn 1 chiều")),format.raw/*223.75*/("""</label>
            </div>
          </div>
          <div class="col-md-9">
            <div class="form-check form-check-inline">
              <input class="form-check-input open1Way" type="radio" id="open1Way_1" name="open1Way" value="1">
              <label class="form-check-label" for="open1Way_1">"""),_display_(/*229.65*/Messages("Rất không hài lòng")),format.raw/*229.95*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input open1Way" type="radio" id="open1Way_2" name="open1Way" value="2">
              <label class="form-check-label" for="open1Way_2">"""),_display_(/*233.65*/Messages("Không hài lòng")),format.raw/*233.91*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input open1Way" type="radio" id="open1Way_3" name="open1Way" value="3">
              <label class="form-check-label" for="open1Way_3">"""),_display_(/*237.65*/Messages("Hài lòng")),format.raw/*237.85*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input open1Way" type="radio" id="open1Way_4" name="open1Way" value="4">
              <label class="form-check-label" for="open1Way_4">"""),_display_(/*241.65*/Messages("Rất hài lòng")),format.raw/*241.89*/("""</label>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-md-3">
            <div class="form-check form-check-inline">
              <label class="form-check-label">"""),_display_(/*249.48*/Messages("Mở chặn 2 chiều")),format.raw/*249.75*/("""</label>
            </div>
          </div>
          <div class="col-md-9">
            <div class="form-check form-check-inline">
              <input class="form-check-input open2Way" type="radio" id="open2Way_1" name="open2Way" value="1">
              <label class="form-check-label" for="open2Way_1">"""),_display_(/*255.65*/Messages("Rất không hài lòng")),format.raw/*255.95*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input open2Way" type="radio" id="open2Way_2" name="open2Way" value="2">
              <label class="form-check-label" for="open2Way_2">"""),_display_(/*259.65*/Messages("Không hài lòng")),format.raw/*259.91*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input open2Way" type="radio" id="open2Way_3" name="open2Way" value="3">
              <label class="form-check-label" for="open2Way_3">"""),_display_(/*263.65*/Messages("Hài lòng")),format.raw/*263.85*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input open2Way" type="radio" id="open2Way_4" name="open2Way" value="4">
              <label class="form-check-label" for="open2Way_4">"""),_display_(/*267.65*/Messages("Rất hài lòng")),format.raw/*267.89*/("""</label>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-md-3">
            <div class="form-check form-check-inline">
              <label class="form-check-label">"""),_display_(/*275.48*/Messages("Nạp tiền")),format.raw/*275.68*/("""</label>
            </div>
          </div>
          <div class="col-md-9">
            <div class="form-check form-check-inline">
              <input class="form-check-input rechargeMoney" type="radio" id="rechargeMoney_1" name="rechargeMoney" value="1">
              <label class="form-check-label" for="rechargeMoney_1">"""),_display_(/*281.70*/Messages("Rất không hài lòng")),format.raw/*281.100*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input rechargeMoney" type="radio" id="rechargeMoney_2" name="rechargeMoney" value="2">
              <label class="form-check-label" for="rechargeMoney_2">"""),_display_(/*285.70*/Messages("Không hài lòng")),format.raw/*285.96*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input rechargeMoney" type="radio" id="rechargeMoney_3" name="rechargeMoney" value="3">
              <label class="form-check-label" for="rechargeMoney_3">"""),_display_(/*289.70*/Messages("Hài lòng")),format.raw/*289.90*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input rechargeMoney" type="radio" id="rechargeMoney_4" name="rechargeMoney" value="4">
              <label class="form-check-label" for="rechargeMoney_4">"""),_display_(/*293.70*/Messages("Rất hài lòng")),format.raw/*293.94*/("""</label>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-md-3">
            <div class="form-check form-check-inline">
              <label class="form-check-label">"""),_display_(/*301.48*/Messages("Đăng ký gói cước Mi, Add-on")),format.raw/*301.87*/("""</label>
            </div>
          </div>
          <div class="col-md-9">
            <div class="form-check form-check-inline">
              <input class="form-check-input miAddon" type="radio" id="miAddon_1" name="miAddon" value="1">
              <label class="form-check-label" for="miAddon_1">"""),_display_(/*307.64*/Messages("Rất không hài lòng")),format.raw/*307.94*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input miAddon" type="radio" id="miAddon_2" name="miAddon" value="2">
              <label class="form-check-label" for="miAddon_2">"""),_display_(/*311.64*/Messages("Không hài lòng")),format.raw/*311.90*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input miAddon" type="radio" id="miAddon_3" name="miAddon" value="3">
              <label class="form-check-label" for="miAddon_3">"""),_display_(/*315.64*/Messages("Hài lòng")),format.raw/*315.84*/("""</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input miAddon" type="radio" id="miAddon_4" name="miAddon" value="4">
              <label class="form-check-label" for="miAddon_4">"""),_display_(/*319.64*/Messages("Rất hài lòng")),format.raw/*319.88*/("""</label>
            </div>
          </div>
        </div>

        <h6 class="m-t-3">"""),_display_(/*324.28*/Messages("6. Cho chúng tôi xin một số góp ý để cải thiện các dịch vụ trên nhé")),format.raw/*324.107*/("""</h6>
        <textarea class="form-control" id="contentFeedback" maxlength="1000" rows="3" placeholder="...tối đa 1000 kí tự"></textarea>

        <h6 class="m-t-3">"""),_display_(/*327.28*/Messages("7. Bạn sẵn sàng chi trả cho những tính năng nào dưới đây? Nếu có, mức phí là bao nhiêu? (Phí trên một lần thực hiện thao tác)")),format.raw/*327.165*/(""" """),format.raw/*327.166*/("""<span class="text-red">"""),_display_(/*327.190*/Messages("*")),format.raw/*327.203*/("""</span></h6>
        <div>
          <h6 class="">"""),_display_(/*329.25*/Messages("Đấu nối thuê bao M2M/IOT")),format.raw/*329.61*/("""</h6>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeeConnect" type="radio" id="payFeeConnect_1" name="payFeeConnect" value="1">
            <label class="form-check-label" for="payFeeConnect_1">"""),_display_(/*332.68*/Messages("0-5.000 VNĐ")),format.raw/*332.91*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeeConnect" type="radio" id="payFeeConnect_2" name="payFeeConnect" value="2">
            <label class="form-check-label" for="payFeeConnect_2">"""),_display_(/*336.68*/Messages("5.000 - 10.000 VNĐ")),format.raw/*336.98*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeeConnect" type="radio" id="payFeeConnect_3" name="payFeeConnect" value="3">
            <label class="form-check-label" for="payFeeConnect_3">"""),_display_(/*340.68*/Messages("10.000 - 50.000 VNĐ")),format.raw/*340.99*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeeConnect" type="radio" id="payFeeConnect_4" name="payFeeConnect" value="4">
            <label class="form-check-label" for="payFeeConnect_4">"""),_display_(/*344.68*/Messages("Trên 50.000 VNĐ")),format.raw/*344.95*/("""</label>
          </div>
        </div>
        <div>
          <h6 class="">"""),_display_(/*348.25*/Messages("Mua gói (gói >=20K)")),format.raw/*348.56*/("""</h6>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeePackage" type="radio" id="payFeePackage_1" name="payFeePackage" value="1">
            <label class="form-check-label" for="payFeePackage_1">"""),_display_(/*351.68*/Messages("0-5.000 VNĐ")),format.raw/*351.91*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeePackage" type="radio" id="payFeePackage_2" name="payFeePackage" value="2">
            <label class="form-check-label" for="payFeePackage_2">"""),_display_(/*355.68*/Messages("5.000 - 10.000 VNĐ")),format.raw/*355.98*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeePackage" type="radio" id="payFeePackage_3" name="payFeePackage" value="3">
            <label class="form-check-label" for="payFeePackage_3">"""),_display_(/*359.68*/Messages("10.000 - 50.000 VNĐ")),format.raw/*359.99*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeePackage" type="radio" id="payFeePackage_4" name="payFeePackage" value="4">
            <label class="form-check-label" for="payFeePackage_4">"""),_display_(/*363.68*/Messages("Trên 50.000 VNĐ")),format.raw/*363.95*/("""</label>
          </div>
        </div>
        <div>
          <h6 class="">"""),_display_(/*367.25*/Messages("Mở chặn 1 chiều, 2 chiều")),format.raw/*367.61*/("""</h6>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeeOpenSub" type="radio" id="payFeeOpenSub_1" name="payFeeOpenSub" value="1">
            <label class="form-check-label" for="payFeeOpenSub_1">"""),_display_(/*370.68*/Messages("0-5.000 VNĐ")),format.raw/*370.91*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeeOpenSub" type="radio" id="payFeeOpenSub_2" name="payFeeOpenSub" value="2">
            <label class="form-check-label" for="payFeeOpenSub_2">"""),_display_(/*374.68*/Messages("5.000 - 10.000 VNĐ")),format.raw/*374.98*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeeOpenSub" type="radio" id="payFeeOpenSub_3" name="payFeeOpenSub" value="3">
            <label class="form-check-label" for="payFeeOpenSub_3">"""),_display_(/*378.68*/Messages("10.000 - 50.000 VNĐ")),format.raw/*378.99*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeeOpenSub" type="radio" id="payFeeOpenSub_4" name="payFeeOpenSub" value="4">
            <label class="form-check-label" for="payFeeOpenSub_4">"""),_display_(/*382.68*/Messages("Trên 50.000 VNĐ")),format.raw/*382.95*/("""</label>
          </div>
        </div>
        <div>
          <h6 class="">"""),_display_(/*386.25*/Messages("Chặn 1 chiều, 2 chiều")),format.raw/*386.58*/("""</h6>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeeBlockSub" type="radio" id="payFeeBlockSub_1" name="payFeeBlockSub" value="1">
            <label class="form-check-label" for="payFeeBlockSub_1">"""),_display_(/*389.69*/Messages("0-5.000 VNĐ")),format.raw/*389.92*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeeBlockSub" type="radio" id="payFeeBlockSub_2" name="payFeeBlockSub" value="2">
            <label class="form-check-label" for="payFeeBlockSub_2">"""),_display_(/*393.69*/Messages("5.000 - 10.000 VNĐ")),format.raw/*393.99*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeeBlockSub" type="radio" id="payFeeBlockSub_3" name="payFeeBlockSub" value="3">
            <label class="form-check-label" for="payFeeBlockSub_3">"""),_display_(/*397.69*/Messages("10.000 - 50.000 VNĐ")),format.raw/*397.100*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeeBlockSub" type="radio" id="payFeeBlockSub_4" name="payFeeBlockSub" value="4">
            <label class="form-check-label" for="payFeeBlockSub_4">"""),_display_(/*401.69*/Messages("Trên 50.000 VNĐ")),format.raw/*401.96*/("""</label>
          </div>
        </div>
        <div>
          <h6 class="">"""),_display_(/*405.25*/Messages("Nạp tiền")),format.raw/*405.45*/("""</h6>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeeRecharge" type="radio" id="payFeeRecharge_1" name="payFeeRecharge" value="1">
            <label class="form-check-label" for="payFeeRecharge_1">"""),_display_(/*408.69*/Messages("0-5.000 VNĐ")),format.raw/*408.92*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeeRecharge" type="radio" id="payFeeRecharge_2" name="payFeeRecharge" value="2">
            <label class="form-check-label" for="payFeeRecharge_2">"""),_display_(/*412.69*/Messages("5.000 - 10.000 VNĐ")),format.raw/*412.99*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeeRecharge" type="radio" id="payFeeRecharge_3" name="payFeeRecharge" value="3">
            <label class="form-check-label" for="payFeeRecharge_3">"""),_display_(/*416.69*/Messages("10.000 - 50.000 VNĐ")),format.raw/*416.100*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeeRecharge" type="radio" id="payFeeRecharge_4" name="payFeeRecharge" value="4">
            <label class="form-check-label" for="payFeeRecharge_4">"""),_display_(/*420.69*/Messages("Trên 50.000 VNĐ")),format.raw/*420.96*/("""</label>
          </div>
        </div>
        <div>
          <h6 class="">"""),_display_(/*424.25*/Messages("Đăng ký gói cước")),format.raw/*424.53*/("""</h6>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeeMiAddon" type="radio" id="payFeeMiAddon_1" name="payFeeMiAddon" value="1">
            <label class="form-check-label" for="payFeeMiAddon_1">"""),_display_(/*427.68*/Messages("0-5.000 VNĐ")),format.raw/*427.91*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeeMiAddon" type="radio" id="payFeeMiAddon_2" name="payFeeMiAddon" value="2">
            <label class="form-check-label" for="payFeeMiAddon_2">"""),_display_(/*431.68*/Messages("5.000 - 10.000 VNĐ")),format.raw/*431.98*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeeMiAddon" type="radio" id="payFeeMiAddon_3" name="payFeeMiAddon" value="3">
            <label class="form-check-label" for="payFeeMiAddon_3">"""),_display_(/*435.68*/Messages("10.000 - 50.000 VNĐ")),format.raw/*435.99*/("""</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input payFeeMiAddon" type="radio" id="payFeeMiAddon_4" name="payFeeMiAddon" value="4">
            <label class="form-check-label" for="payFeeMiAddon_4">"""),_display_(/*439.68*/Messages("Trên 50.000 VNĐ")),format.raw/*439.95*/("""</label>
          </div>
        </div>

        <h6 class="m-t-3">"""),_display_(/*443.28*/Messages("8. Nếu các tính năng liên quan đến phân tích và lọc dữ liệu được phát triển, bạn mong muốn có tính năng nào? (Chọn nhiều options)")),format.raw/*443.169*/(""" """),format.raw/*443.170*/("""<span class="text-red">"""),_display_(/*443.194*/Messages("*")),format.raw/*443.207*/("""</span></h6>
        <div>
          <div class="form-check">
            <input class="form-check-input extraFeatures" type="checkbox" id="extraFeatures_1" value="1">
            <label class="form-check-label" for="extraFeatures_1">"""),_display_(/*447.68*/Messages("Quản lý thiết bị: theo dõi trạng thái hoạt động, cấu hình và bật tắt thiết bị từ xa.")),format.raw/*447.164*/("""</label>
          </div>
          <div class="form-check">
            <input class="form-check-input extraFeatures" type="checkbox" id="extraFeatures_2" value="2">
            <label class="form-check-label" for="extraFeatures_2">"""),_display_(/*451.68*/Messages("Tích hợp và phân tích dữ liệu: Thu thập dữ liệu từ nhiều nguồn khác nhau, bao gồm các thiết bị IoT, cảm biến, hệ thống khác. Phân tích dữ liệu theo các tiêu chí tùy chỉnh.")),format.raw/*451.251*/("""</label>
          </div>
          <div class="form-check">
            <input class="form-check-input extraFeatures" type="checkbox" id="extraFeatures_3" value="3">
            <label class="form-check-label" for="extraFeatures_3">"""),_display_(/*455.68*/Messages("Xử lý dữ liệu thời gian thực: Nhận được thông tin và cảnh báo ngay lập tức.")),format.raw/*455.155*/("""</label>
          </div>
          <div class="form-check">
            <input class="form-check-input extraFeatures" type="checkbox" id="extraFeatures_4" value="4">
            <label class="form-check-label" for="extraFeatures_4">"""),_display_(/*459.68*/Messages("Tạo và quản lý các quy tắc tự động: Tạo các quy tắc tự động dựa trên dữ liệu IoT, tự động hóa quy trình và phản ứng tức thì vào các sự kiện và trạng thái của thiết bị IoT.")),format.raw/*459.251*/("""</label>
          </div>
          <div class="form-check">
            <input class="form-check-input extraFeatures" type="checkbox" id="extraFeatures_5" value="5">
            <label class="form-check-label" for="extraFeatures_5">"""),_display_(/*463.68*/Messages("Tạo bảng điều khiển tùy chỉnh: Giúp hiển thị thông tin quan trọng theo nhu cầu của từng khách hàng.")),format.raw/*463.179*/("""</label>
          </div>
          <div class="form-check">
            <input class="form-check-input extraFeatures" type="checkbox" id="extraFeatures_6" value="6">
            <label class="form-check-label" for="extraFeatures_6">"""),_display_(/*467.68*/Messages("Tính năng khác")),format.raw/*467.94*/("""</label>
          </div>
        </div>

        <h6 class="m-t-3">"""),_display_(/*471.28*/Messages("9. Bạn gặp phải những khó khăn gì khi xây dựng ứng dụng IoT cho doanh nghiệp của bạn? (Chọn nhiều option)")),format.raw/*471.145*/(""" """),format.raw/*471.146*/("""<span class="text-red">"""),_display_(/*471.170*/Messages("*")),format.raw/*471.183*/("""</span></h6>
        <div>
          <div class="form-check">
            <input class="form-check-input hard" type="checkbox" id="hard_1" value="1">
            <label class="form-check-label" for="hard_1">"""),_display_(/*475.59*/Messages("Tích hợp thiết bị")),format.raw/*475.88*/("""</label>
          </div>
          <div class="form-check">
            <input class="form-check-input hard" type="checkbox" id="hard_2" value="2">
            <label class="form-check-label" for="hard_2">"""),_display_(/*479.59*/Messages("Triển khai hạ tầng server")),format.raw/*479.96*/("""</label>
          </div>
          <div class="form-check">
            <input class="form-check-input hard" type="checkbox" id="hard_3" value="3">
            <label class="form-check-label" for="hard_3">"""),_display_(/*483.59*/Messages("Chất lượng kết nối vô tuyến không đảm bảo")),format.raw/*483.112*/("""</label>
          </div>
          <div class="form-check">
            <input class="form-check-input hard" type="checkbox" id="hard_4" value="4">
            <label class="form-check-label" for="hard_4">"""),_display_(/*487.59*/Messages("Chi phí cao")),format.raw/*487.82*/("""</label>
          </div>
          <div class="form-check">
            <input class="form-check-input hard" type="checkbox" id="hard_5" value="5">
            <label class="form-check-label" for="hard_5">"""),_display_(/*491.59*/Messages("Thời gian phát triển ứng dụng quá lâu")),format.raw/*491.108*/("""</label>
          </div>
          <div class="form-check">
            <input class="form-check-input hard" type="checkbox" id="hard_6" value="6">
            <label class="form-check-label" for="hard_6">"""),_display_(/*495.59*/Messages("Thiếu nhân sự vận hành")),format.raw/*495.93*/("""</label>
          </div>
          <div class="form-check">
            <input class="form-check-input hard" type="checkbox" id="hard_7" value="7">
            <label class="form-check-label" for="hard_7">"""),_display_(/*499.59*/Messages("Thiếu các đầu bài cụ thể từ khách hàng")),format.raw/*499.109*/("""</label>
          </div>
        </div>

        <h6 class="m-t-3">"""),_display_(/*503.28*/Messages("10. Bạn có đang dùng nền tảng IOT nào cho ứng dụng của doanh nghiệp mình không?")),format.raw/*503.119*/("""</h6>
        <textarea class="form-control" id="contentUsePlatformOther" maxlength="1000" rows="3" placeholder="...tối đa 1000 kí tự"></textarea>

        <h6 class="m-t-3">"""),_display_(/*506.28*/Messages("11. Doanh nghiệp của bạn đang phả chi trả cho IOT Platform này hàng tháng như thế nào?")),format.raw/*506.126*/("""</h6>
        <textarea class="form-control" id="contentFeeOneMonth" maxlength="1000" rows="3" placeholder="...tối đa 1000 kí tự"></textarea>

        <h6 class="m-t-3">"""),_display_(/*509.28*/Messages("12. Bạn có sẵn sàng giới thiệu cho bạn bè thuộc DN khác, trải nghiệm dùng thử bộ công cụ CMP của Viettel?")),format.raw/*509.145*/(""" """),format.raw/*509.146*/("""<span class="text-red">"""),_display_(/*509.170*/Messages("*")),format.raw/*509.183*/("""</span></h6>
        <div>
          <div class="form-check">
            <input class="form-check-input realyUse" type="radio" id="realyUse_1" name="realyUse" value="1">
            <label class="form-check-label" for="realyUse_1">"""),_display_(/*513.63*/Messages("Sẵn sàng")),format.raw/*513.83*/("""</label>
          </div>
          <div class="form-check">
            <input class="form-check-input realyUse" type="radio" id="realyUse_2" name="realyUse" value="2">
            <label class="form-check-label" for="realyUse_2">"""),_display_(/*517.63*/Messages("Cần trải nghiệm thêm")),format.raw/*517.95*/("""</label>
          </div>
          <div class="form-check">
            <input class="form-check-input realyUse" type="radio" id="realyUse_3" name="realyUse" value="3">
            <label class="form-check-label" for="realyUse_3">"""),_display_(/*521.63*/Messages("Hoàn toàn không muốn")),format.raw/*521.95*/("""</label>
          </div>
        </div>

      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-red" onclick="comfirmUpdateTypeBusiness()">"""),_display_(/*528.90*/Messages("btnComfirm")),format.raw/*528.112*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/dashboard/DashboardTelco_company.scala.html
                  HASH: ce7b0f75faee27133a6ad236ac65a6b5ac39abcc
                  MATRIX: 1063->0|1504->415|1548->439|1614->479|1664->509|1717->646|1750->653|1904->780|1953->808|1982->809|2033->833|2083->861|2333->1084|2385->1115|2634->1337|2693->1374|2942->1596|3003->1635|3252->1857|3312->1895|3561->2117|3614->2149|3863->2371|3928->2414|4177->2636|4243->2680|4339->2749|4449->2837|4479->2838|4531->2862|4566->2875|4852->3134|4903->3164|5188->3422|5235->3448|5520->3706|5561->3726|5846->3984|5891->4008|5987->4077|6064->4133|6093->4134|6145->4158|6180->4171|6454->4418|6505->4448|6778->4694|6825->4720|7098->4966|7139->4986|7412->5232|7457->5256|7553->5325|7659->5409|7689->5410|7741->5434|7776->5447|8050->5694|8099->5722|8372->5968|8421->5996|8694->6242|8743->6270|9017->6516|9074->6550|9348->6796|9390->6816|9664->7062|9714->7090|9811->7159|9881->7207|9911->7208|9964->7232|10000->7245|10202->7419|10252->7447|10596->7763|10648->7793|10942->8059|10990->8085|11284->8351|11326->8371|11620->8637|11666->8661|11916->8883|11966->8911|12326->9243|12379->9273|12689->9555|12737->9581|13047->9863|13089->9883|13399->10165|13445->10189|13695->10411|13745->10439|14093->10759|14145->10789|14443->11059|14491->11085|14789->11355|14831->11375|15129->11645|15175->11669|15425->11891|15472->11916|15808->12224|15860->12254|16146->12512|16194->12538|16480->12796|16522->12816|16808->13074|16854->13098|17104->13320|17153->13347|17489->13655|17541->13685|17827->13943|17875->13969|18161->14227|18203->14247|18489->14505|18535->14529|18785->14751|18834->14778|19170->15086|19222->15116|19508->15374|19556->15400|19842->15658|19884->15678|20170->15936|20216->15960|20466->16182|20508->16202|20864->16530|20917->16560|21223->16838|21271->16864|21577->17142|21619->17162|21925->17440|21971->17464|22221->17686|22282->17725|22614->18029|22666->18059|22948->18313|22996->18339|23278->18593|23320->18613|23602->18867|23648->18891|23764->18979|23866->19058|24061->19225|24221->19362|24252->19363|24305->19387|24341->19400|24420->19451|24478->19487|24756->19737|24801->19760|25099->20030|25151->20060|25449->20330|25502->20361|25800->20631|25849->20658|25956->20737|26009->20768|26287->21018|26332->21041|26630->21311|26682->21341|26980->21611|27033->21642|27331->21912|27380->21939|27487->22018|27545->22054|27823->22304|27868->22327|28166->22597|28218->22627|28516->22897|28569->22928|28867->23198|28916->23225|29023->23304|29078->23337|29360->23591|29405->23614|29707->23888|29759->23918|30061->24192|30115->24223|30417->24497|30466->24524|30573->24603|30615->24623|30897->24877|30942->24900|31244->25174|31296->25204|31598->25478|31652->25509|31954->25783|32003->25810|32110->25889|32160->25917|32438->26167|32483->26190|32781->26460|32833->26490|33131->26760|33184->26791|33482->27061|33531->27088|33628->27157|33792->27298|33823->27299|33876->27323|33912->27336|34175->27571|34294->27667|34556->27901|34762->28084|35024->28318|35134->28405|35396->28639|35602->28822|35864->29056|35998->29167|36260->29401|36308->29427|36405->29496|36545->29613|36576->29614|36629->29638|36665->29651|36901->29859|36952->29888|37187->30095|37246->30132|37481->30339|37557->30392|37792->30599|37837->30622|38072->30829|38144->30878|38379->31085|38435->31119|38670->31326|38743->31376|38840->31445|38954->31536|39157->31711|39278->31809|39476->31979|39616->32096|39647->32097|39700->32121|39736->32134|39997->32367|40039->32387|40299->32619|40353->32651|40613->32883|40667->32915|40873->33093|40918->33115
                  LINES: 33->1|37->5|37->5|38->6|38->6|40->8|41->9|47->15|47->15|47->15|47->15|47->15|51->19|51->19|55->23|55->23|59->27|59->27|63->31|63->31|67->35|67->35|71->39|71->39|75->43|75->43|79->47|79->47|79->47|79->47|79->47|83->51|83->51|87->55|87->55|91->59|91->59|95->63|95->63|99->67|99->67|99->67|99->67|99->67|103->71|103->71|107->75|107->75|111->79|111->79|115->83|115->83|119->87|119->87|119->87|119->87|119->87|123->91|123->91|127->95|127->95|131->99|131->99|135->103|135->103|139->107|139->107|143->111|143->111|147->115|147->115|147->115|147->115|147->115|151->119|151->119|157->125|157->125|161->129|161->129|165->133|165->133|169->137|169->137|177->145|177->145|183->151|183->151|187->155|187->155|191->159|191->159|195->163|195->163|203->171|203->171|209->177|209->177|213->181|213->181|217->185|217->185|221->189|221->189|229->197|229->197|235->203|235->203|239->207|239->207|243->211|243->211|247->215|247->215|255->223|255->223|261->229|261->229|265->233|265->233|269->237|269->237|273->241|273->241|281->249|281->249|287->255|287->255|291->259|291->259|295->263|295->263|299->267|299->267|307->275|307->275|313->281|313->281|317->285|317->285|321->289|321->289|325->293|325->293|333->301|333->301|339->307|339->307|343->311|343->311|347->315|347->315|351->319|351->319|356->324|356->324|359->327|359->327|359->327|359->327|359->327|361->329|361->329|364->332|364->332|368->336|368->336|372->340|372->340|376->344|376->344|380->348|380->348|383->351|383->351|387->355|387->355|391->359|391->359|395->363|395->363|399->367|399->367|402->370|402->370|406->374|406->374|410->378|410->378|414->382|414->382|418->386|418->386|421->389|421->389|425->393|425->393|429->397|429->397|433->401|433->401|437->405|437->405|440->408|440->408|444->412|444->412|448->416|448->416|452->420|452->420|456->424|456->424|459->427|459->427|463->431|463->431|467->435|467->435|471->439|471->439|475->443|475->443|475->443|475->443|475->443|479->447|479->447|483->451|483->451|487->455|487->455|491->459|491->459|495->463|495->463|499->467|499->467|503->471|503->471|503->471|503->471|503->471|507->475|507->475|511->479|511->479|515->483|515->483|519->487|519->487|523->491|523->491|527->495|527->495|531->499|531->499|535->503|535->503|538->506|538->506|541->509|541->509|541->509|541->509|541->509|545->513|545->513|549->517|549->517|553->521|553->521|560->528|560->528
                  -- GENERATED --
              */
          