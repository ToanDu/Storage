
package views.html.telco.buySim

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

object BuySim_comfirmOrder extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-lg-11 col-md-8" id="tabComfirmOrder">
  <div class="row">
    <div class="col-md-12 text-start mb-4">
      <span class="display-4 title-section-1 text-darker">"""),_display_(/*4.60*/Messages("customer.info.title")),format.raw/*4.91*/("""</span>
    </div>
    <div class="col-md-12 pl-5">
      <div class="row text-start mb-3">
        <div class="col-md-2">
          <span class="col-form-label">"""),_display_(/*9.41*/Messages("customer.info.representative")),format.raw/*9.81*/(""":</span>
        </div>
        <div class="col-md-4">
          <span class="col-form-label" id="recipientNameText"></span>
        </div>
        <div class="col-md-2">
          <span class="col-form-label" class="col-form-label">"""),_display_(/*15.64*/Messages("customer.info.businessLicense")),format.raw/*15.105*/(""":</span>
        </div>
        <div class="col-md-4">
          <span class="col-form-label" id="bussinessLicenseText"></span>
        </div>
      </div>
      <div class="row text-start mb-3">
        <div class="col-md-2">
          <span class="col-form-label">"""),_display_(/*23.41*/Messages("SDT")),format.raw/*23.56*/(""":</span>
        </div>
        <div class="col-md-4">
          <span  class="col-form-label" id="recipientPhoneText"></span>
        </div>
        <div class="col-md-2">
          <span class="col-form-label">"""),_display_(/*29.41*/Messages("customer.info.businessName")),format.raw/*29.79*/(""":</span>
        </div>
        <div class="col-md-4">
          <span class="col-form-label" id="bussinessNameText"></span>
        </div>
      </div>
    </div>
  </div>
  <div class="row mb-4">
    <div class="col-md-12 text-start mb-4">
      <span class="display-4 title-section-1 text-darker">"""),_display_(/*39.60*/Messages("delivery.title")),format.raw/*39.86*/("""</span>
    </div>
    <div class="col-md-12 text-start pl-5">
    <p class="col-form-label" id="transactionPlaceText"></p>      
    <p class="col-form-label" id="addressText"></p>      
    </div>
  </div>
  <div class="row">
    <div class="col-md-12 text-start mb-4">
      <span class="display-4 title-section-1 text-darker">"""),_display_(/*48.60*/Messages("product.info.title")),format.raw/*48.90*/("""</span>
    </div>
    <div class="col-md-12 pl-5 mb-3">
      <div class="table-responsive" style="border-radius: 8px;">
        <table class="table table-striped" id="listContractTable" style="width: 100%;">
          <thead style="background-color: #FBCCD6;">
            <tr class="text-darker">
              <th >"""),_display_(/*55.21*/Messages("manage.stt")),format.raw/*55.43*/("""</th>
              <th >"""),_display_(/*56.21*/Messages("product.package")),format.raw/*56.48*/("""</th>
              <th >"""),_display_(/*57.21*/Messages("product.simQuantity")),format.raw/*57.52*/("""</th>
            </tr>
          </thead>
          <tbody id="pack_data">
            
          </tbody>
        </table>
      </div>
      <div class="pagination_table" id="paginationOrderSim"></div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-12 text-start mb-4">
      <span class="display-4 title-section-1 text-darker">"""),_display_(/*70.60*/Messages("payment.title")),format.raw/*70.85*/("""</span>
    </div>
    <div class="col-md-12 text-start pl-5">
    <p class="col-form-label">"""),_display_(/*73.32*/Messages("payment.cod")),format.raw/*73.55*/("""</p>      
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-md-12 d-flex align-items-center gap-2">
        <label class="custom-checkbox title-section-1 text-darker">
          <input class="form-check-input" id="comfirm-checkbox" type="checkbox" onchange="checkboxDksd(this)">
          <span class="checkmark"></span>
          """),_display_(/*81.12*/Messages("terms.agreement")),format.raw/*81.39*/("""
        """),format.raw/*82.9*/("""</label>
    </div>
    
    <div class="row mt-3 pl-5 text-start"> 
      <ul style="list-style-type: none;">
        <li>- """),_display_(/*87.16*/Messages("terms.service1")),format.raw/*87.42*/("""</li>
        <li>- """),_display_(/*88.16*/Messages("terms.service2")),format.raw/*88.42*/("""</li>
        <li>- """),_display_(/*89.16*/Messages("terms.service3")),format.raw/*89.42*/("""</li>
      </ul>
    </div>
</div>
<!-- Modal Success Message -->
<div class="modal fade" id="successOrderModal" tabindex="-1" aria-labelledby="successOrderModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg modal-dialog-centered shadow-none">
    <div class="modal-content">
      <div class="modal-header border-bottom-0 position-relative">
        <p class="modal-title fs-2" id="successOrderModalLabel">"""),_display_(/*98.66*/Messages("notification.title")),format.raw/*98.96*/("""</p>
        <!-- Icon Close -->
        <i class="bx bx-x-circle position-absolute top-0 end-0 p-2" onclick="location.reload()" data-bs-dismiss="modal" aria-label="Close" style="cursor: pointer; font-size: 35px; color: #727272;"></i>
      </div>
      <div class="modal-body text-center">
        <svg class="mb-4" width="56" height="56" viewBox="0 0 56 56" fill="none" xmlns="http://www.w3.org/2000/svg">
          <g clip-path="url(#clip0_230_24490)">
          <circle cx="26" cy="31" r="24" fill="#FFD0D0"/>
          <path d="M24.3362 41.798C24.0461 41.798 23.7679 41.6826 23.5629 41.4775L11.67 29.5851C11.2428 29.1579 11.2428 28.4653 11.67 28.0381L17.857 21.8511C18.2842 21.4239 18.9768 21.4239 19.4041 21.8511L24.3362 26.7833L36.5964 14.5226C36.8015 14.3175 37.0801 14.2021 37.3702 14.2021C37.6598 14.2021 37.9384 14.3175 38.1435 14.5226L44.3304 20.71C44.7577 21.1368 44.7577 21.8293 44.3304 22.2566L25.1095 41.478C24.9044 41.683 24.6263 41.798 24.3362 41.798ZM13.9904 28.8118L24.3362 39.1576L42.0105 21.4833L37.3702 16.8425L25.1095 29.1032C24.6822 29.5305 23.9897 29.5305 23.5629 29.1032L18.6307 24.1711L13.9904 28.8118Z" fill="#EA0033"/>
          <path d="M27.9932 56C27.2788 56 26.5636 55.9727 25.8471 55.918C19.1932 55.4078 12.9263 52.5243 8.20099 47.7994C2.91254 42.5106 0 35.4794 0 28C0 20.5211 2.91254 13.4894 8.20099 8.20099C13.4894 2.91254 20.5211 0 28 0C35.4794 0 42.5106 2.91254 47.7994 8.20099C52.5243 12.9263 55.4078 19.1932 55.918 25.8471C56.4225 32.4288 54.5897 38.9892 50.7573 44.3204C50.4048 44.8108 49.7212 44.9224 49.2307 44.5699C48.7402 44.2174 48.6287 43.5338 48.9812 43.0433C56.3888 32.7394 55.2412 18.7369 46.2524 9.74762C36.1882 -0.316589 19.8123 -0.316589 9.74805 9.74762C-0.316589 19.8123 -0.316589 36.1877 9.74805 46.2524C18.7369 55.2408 32.7399 56.3888 43.0438 48.9808C43.5342 48.6283 44.2174 48.7402 44.5703 49.2307C44.9228 49.7212 44.8108 50.4044 44.3204 50.7573C39.5694 54.1727 33.8417 56 27.9932 56Z" fill="#EA0033"/>
          <path d="M47.0264 48.1199C46.7384 48.1199 46.4564 48.0028 46.2531 47.7994C46.0497 47.5956 45.9326 47.3137 45.9326 47.0261C45.9326 46.7382 46.0497 46.4562 46.2531 46.2528C46.4564 46.0494 46.7384 45.9324 47.0264 45.9324C47.3139 45.9324 47.5959 46.0494 47.7997 46.2528C48.0031 46.4562 48.1201 46.7382 48.1201 47.0261C48.1201 47.3137 48.0031 47.5956 47.7997 47.7994C47.5959 48.0028 47.3139 48.1199 47.0264 48.1199Z" fill="#EA0033"/>
          </g>
          <defs>
          <clipPath id="clip0_230_24490">
          <rect width="56" height="56" fill="white"/>
          </clipPath>
          </defs>
        </svg>
        <h4 style="color: #EA0033;">"""),_display_(/*116.38*/Messages("order.success.title")),format.raw/*116.69*/("""</h4>
        <p><strong class="text-darker">"""),_display_(/*117.41*/Messages("order.success.code")),format.raw/*117.71*/(""" """),format.raw/*117.72*/("""</strong><span id="orderID"></span></p>
        <p>"""),_display_(/*118.13*/Messages("order.success.contact")),format.raw/*118.46*/(""" """),format.raw/*118.47*/("""<br> """),_display_(/*118.53*/Messages("order.success.thanks")),format.raw/*118.85*/("""</p>
      </div>
      <div class="modal-footer border-top-0">
        <button type="button" class="btn btn-telco" onclick="location.reload()" style="background: #FFFFFF; color: #EA0033; border: 1px solid #EA0033; font-style: italic;">"""),_display_(/*121.174*/Messages("finish.end")),format.raw/*121.196*/("""</button>
      </div>
    </div>
  </div>
</div>
<!-- Modal Faild Message -->
<div class="modal fade" id="failOrderModal" tabindex="-1" aria-labelledby="failOrderModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg modal-dialog-centered shadow-none">
    <div class="modal-content">
      <div class="modal-header border-bottom-0 position-relative">
        <p class="modal-title fs-2" id="failOrderModalLabel">"""),_display_(/*131.63*/Messages("notification.title")),format.raw/*131.93*/("""</p>
        <!-- Icon Close -->
        <i class="bx bx-x-circle position-absolute top-0 end-0 p-2" onclick="location.reload()" data-bs-dismiss="modal" aria-label="Close" style="cursor: pointer; font-size: 35px; color: #727272;"></i>
      </div>
      <div class="modal-body text-center">
        <svg class="mb-4" width="56" height="56" viewBox="0 0 56 56" fill="none" xmlns="http://www.w3.org/2000/svg">
          <g clip-path="url(#clip0_230_24498)">
          <circle cx="26" cy="31" r="24" fill="#FFD0D0"/>
          <path d="M27.9932 56C27.2788 56 26.5636 55.9727 25.8471 55.918C19.1932 55.4078 12.9263 52.5243 8.20099 47.7994C2.91254 42.5106 0 35.4794 0 28C0 20.5211 2.91254 13.4894 8.20099 8.20099C13.4894 2.91254 20.5211 0 28 0C35.4794 0 42.5106 2.91254 47.7994 8.20099C52.5243 12.9263 55.4078 19.1932 55.918 25.8471C56.4225 32.4288 54.5897 38.9892 50.7573 44.3204C50.4048 44.8108 49.7212 44.9224 49.2307 44.5699C48.7402 44.2174 48.6287 43.5338 48.9812 43.0433C56.3888 32.7394 55.2412 18.7369 46.2524 9.74762C36.1882 -0.316589 19.8123 -0.316589 9.74805 9.74762C-0.316589 19.8123 -0.316589 36.1877 9.74805 46.2524C18.7369 55.2408 32.7399 56.3888 43.0438 48.9808C43.5342 48.6283 44.2174 48.7402 44.5703 49.2307C44.9228 49.7212 44.8108 50.4044 44.3204 50.7573C39.5694 54.1727 33.8417 56 27.9932 56Z" fill="#EA0033"/>
          <path d="M47.0264 48.1199C46.7384 48.1199 46.4564 48.0028 46.2531 47.7994C46.0497 47.5956 45.9326 47.3137 45.9326 47.0261C45.9326 46.7382 46.0497 46.4562 46.2531 46.2528C46.4564 46.0494 46.7384 45.9324 47.0264 45.9324C47.3139 45.9324 47.5959 46.0494 47.7997 46.2528C48.0031 46.4562 48.1201 46.7382 48.1201 47.0261C48.1201 47.3137 48.0031 47.5956 47.7997 47.7994C47.5959 48.0028 47.3139 48.1199 47.0264 48.1199Z" fill="#EA0033"/>
          <g clip-path="url(#clip1_230_24498)">
          <path d="M38.7907 36.4777L31.8131 29.5001L38.7907 22.5225C38.9244 22.3871 38.9994 22.2045 38.9994 22.0143C38.9994 21.8241 38.9244 21.6415 38.7907 21.5061L35.4945 18.21C35.3597 18.0752 35.1769 17.9995 34.9863 17.9995C34.7958 17.9995 34.613 18.0752 34.4782 18.21L27.5006 25.1876L20.5229 18.21C20.3882 18.0752 20.2054 17.9995 20.0148 17.9995C19.8242 17.9995 19.6414 18.0752 19.5066 18.21L16.2104 21.5061C16.0757 21.6409 16 21.8237 16 22.0143C16 22.2049 16.0757 22.3877 16.2104 22.5225L23.1881 29.5001L16.2104 36.4777C16.0757 36.6125 16 36.7953 16 36.9859C16 37.1764 16.0757 37.3592 16.2104 37.494L19.5066 40.7902C19.6414 40.9249 19.8242 41.0006 20.0148 41.0006C20.2054 41.0006 20.3882 40.9249 20.5229 40.7902L27.5006 33.8126L34.4782 40.7902C34.613 40.9249 34.7958 41.0006 34.9863 41.0006C35.1769 41.0006 35.3597 40.9249 35.4945 40.7902L38.7907 37.494C38.9254 37.3592 39.0011 37.1764 39.0011 36.9859C39.0011 36.7953 38.9254 36.6125 38.7907 36.4777Z" fill="#EA0029"/>
          </g>
          </g>
          <defs>
          <clipPath id="clip0_230_24498">
          <rect width="56" height="56" fill="white"/>
          </clipPath>
          <clipPath id="clip1_230_24498">
          <rect width="23" height="23" fill="white" transform="translate(16 18)"/>
          </clipPath>
          </defs>
          </svg>
          
        <h4 style="color: #EA0033;">"""),_display_(/*155.38*/Messages("order.failure.title")),format.raw/*155.69*/("""</h4>
        <p>"""),_display_(/*156.13*/Messages("order.failure.message")),format.raw/*156.46*/("""</p>
      </div>
      <div class="modal-footer border-top-0">
        <button type="button" class="btn btn-telco" onclick="location.reload()" style="background: #FFFFFF; color: #EA0033; border: 1px solid #EA0033; font-style: italic;">"""),_display_(/*159.174*/Messages("finish.end")),format.raw/*159.196*/("""</button>
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
                  DATE: Mon Sep 22 16:32:51 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/buySim/BuySim_comfirmOrder.scala.html
                  HASH: e4fdc05a9dab0096c3b0f31ac9ed30a0c84a0a02
                  MATRIX: 1057->0|1260->177|1311->208|1500->371|1560->411|1821->645|1884->686|2178->953|2214->968|2454->1181|2513->1219|2841->1520|2888->1546|3246->1877|3297->1907|3644->2227|3687->2249|3740->2275|3788->2302|3841->2328|3893->2359|4268->2707|4314->2732|4435->2826|4479->2849|4854->3197|4902->3224|4938->3233|5091->3359|5138->3385|5186->3406|5233->3432|5281->3453|5328->3479|5780->3904|5831->3934|8478->6553|8531->6584|8605->6630|8657->6660|8687->6661|8767->6713|8822->6746|8852->6747|8886->6753|8940->6785|9206->7022|9251->7044|9707->7472|9759->7502|12967->10682|13020->10713|13066->10731|13121->10764|13387->11001|13432->11023
                  LINES: 33->1|36->4|36->4|41->9|41->9|47->15|47->15|55->23|55->23|61->29|61->29|71->39|71->39|80->48|80->48|87->55|87->55|88->56|88->56|89->57|89->57|102->70|102->70|105->73|105->73|113->81|113->81|114->82|119->87|119->87|120->88|120->88|121->89|121->89|130->98|130->98|148->116|148->116|149->117|149->117|149->117|150->118|150->118|150->118|150->118|150->118|153->121|153->121|163->131|163->131|187->155|187->155|188->156|188->156|191->159|191->159
                  -- GENERATED --
              */
          