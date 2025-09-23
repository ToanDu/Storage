
package views.html.telco.apn

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

object APN_addModal extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addDefaultAPN" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel" >"""),_display_(/*5.58*/Messages("apn.modal.assignDefaultAPN")),format.raw/*5.96*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row g-3">
          <div class="col-md-12 justify-content-center text-center">
            <div>
              """),_display_(/*11.16*/Messages("apn.modal.confirmDefaultAPN")),format.raw/*11.55*/("""
            """),format.raw/*12.13*/("""</div>
            <div>
              """),_display_(/*14.16*/Messages("apn.modal.networkWarning")),format.raw/*14.52*/("""
            """),format.raw/*15.13*/("""</div>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn_cmp is-outline mt-3 fs-6 fw-normal" data-bs-dismiss="modal">"""),_display_(/*20.103*/Messages("common.cancel")),format.raw/*20.128*/("""</button>
        <button type="button" class="confirm-register-apn btn_cmp is-primary fs-6 fw-normal" data-bs-dismiss="modal" onclick="RegisterAPN(true)">"""),_display_(/*21.147*/Messages("common.confirm")),format.raw/*21.173*/("""</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="addPrivateAPN" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog  modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel" >"""),_display_(/*31.58*/Messages("apn.modal.assignAPNIP")),format.raw/*31.91*/("""</h5>
      </div>
      <div class="modal-body bg-white" style="padding-left: 30px; padding-right: 30px;">
        <div class="row g-3">
          <div class="col-md-6">
            <input id="idGroupProductEdit" type="text" class="form-control" autocomplete="off" readonly hidden>
            <div class="row mb-3" id="apn-name-field">
              <label class="col-sm-3 col-form-label">"""),_display_(/*38.55*/Messages("apn.modal.apnName")),format.raw/*38.84*/(""" """),format.raw/*38.85*/("""<span
            class="text-red">"""),_display_(/*39.31*/Messages("apn.modal.required")),format.raw/*39.61*/("""</span></label>
              <div class="col-sm-9">
                 <select id="apn-name" class="form-select" onchange="handleChooseAPN()">
                   <option value="" disabled selected hidden>"""),_display_(/*42.63*/Messages("apn.modal.chooseAPN")),format.raw/*42.94*/("""</option>
                </select>
                <div class="helper-text form-text text-danger mt-2" style="min-height: 14px;">
                </div>
              </div>
            </div>

            <div class="row mb-3" id="apn-fromDate-field">
              <label class="col-sm-3 col-form-label">"""),_display_(/*50.55*/Messages("apn.modal.fromDate")),format.raw/*50.85*/(""" """),format.raw/*50.86*/("""<span
            class="text-red">"""),_display_(/*51.31*/Messages("*")),format.raw/*51.44*/("""</span></label>
              <div class="col-sm-9">
                <input id="apn-fromDate" type="text" class="form-control datetime-picker" placeholder="DD/MM/YYYY" required onchange="(()=>"""),format.raw/*53.140*/("""{"""),format.raw/*53.141*/("""validateApnStartDate();validateApnEndDate()"""),format.raw/*53.184*/("""}"""),format.raw/*53.185*/(""")()">
                  <div class="helper-text form-text text-danger mt-2" style="min-height: 14px;">
                </div>
              </div>
            </div>

            <div class="row mb-3" id="apn-reason-field">
              <label class="col-sm-3 col-form-label">"""),_display_(/*60.55*/Messages("apn.add.reason")),format.raw/*60.81*/(""" """),format.raw/*60.82*/("""<span
            class="text-red">"""),_display_(/*61.31*/Messages("*")),format.raw/*61.44*/("""</span></label>
              <div class="col-sm-9">
                <select id="apn-reason" class="form-select" onchange="validateApnReason()" value="299799">
                  <option value="299799">"""),_display_(/*64.43*/Messages("apn.add.customerRequest")),format.raw/*64.78*/("""</option>
                </select>
                  <div class="helper-text form-text text-danger mt-2" style="min-height: 14px;">
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="row mb-3" id="apn-ip-field">
              <label class="col-sm-3 col-form-label">"""),_display_(/*73.55*/Messages("apn.add.ip")),format.raw/*73.77*/(""" """),format.raw/*73.78*/("""<span
            class="text-red">"""),_display_(/*74.31*/Messages("*")),format.raw/*74.44*/("""</span></label>
              <div class="col-sm-9">
                <select id="apn-ip" class="form-select" onchange="validateApnIp()" aria-placeholder=""""),_display_(/*76.103*/Messages("apn.add.chooseIP")),format.raw/*76.131*/("""">
                   <option value="" disabled selected hidden>"""),_display_(/*77.63*/Messages("apn.add.chooseIP")),format.raw/*77.91*/("""</option>
                </select>
                <div class="helper-text form-text text-danger mt-2" style="min-height: 14px;">
                </div>
              </div>
            </div>

            <div class="row mb-3" id="apn-toDate-field">
              <label class="col-sm-3 col-form-label">"""),_display_(/*85.55*/Messages("apn.add.endDate")),format.raw/*85.82*/(""" """),format.raw/*85.83*/("""<span
            class="text-red">"""),_display_(/*86.31*/Messages("*")),format.raw/*86.44*/("""</span></label>
              <div class="col-sm-9">
                <input id="apn-toDate" type="text" class="form-control datetime-picker" placeholder="DD/MM/YYYY" required onchange="(()=>"""),format.raw/*88.138*/("""{"""),format.raw/*88.139*/("""validateApnEndDate();validateApnStartDate()"""),format.raw/*88.182*/("""}"""),format.raw/*88.183*/(""")()">
                  <div class="helper-text form-text text-danger mt-2" style="min-height: 14px;">
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="row g-3">
          <div class="fst-italic">
            <div>
              """),_display_(/*98.16*/Messages("apn.add.note")),format.raw/*98.40*/("""
            """),format.raw/*99.13*/("""</div>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn_cmp is-outline mt-3 fs-6 fw-normal" data-bs-dismiss="modal">"""),_display_(/*104.103*/Messages("common.cancel")),format.raw/*104.128*/("""</button>
        <button type="button" class="confirm-register-apn btn_cmp is-primary fs-6 fw-normal" onclick="RegisterAPN(false)">"""),_display_(/*105.124*/Messages("common.confirm")),format.raw/*105.150*/("""</button>
      </div>
    </div>
  </div>
</div>

"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:50 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/apn/APN_addModal.scala.html
                  HASH: 0a01c65c78b106aa30a633e88fdcdd09fb08c0f3
                  MATRIX: 1047->0|1359->286|1417->324|1626->506|1686->545|1727->558|1794->598|1851->634|1892->647|2107->834|2154->859|2338->1015|2386->1041|2751->1379|2805->1412|3224->1804|3274->1833|3303->1834|3366->1870|3417->1900|3648->2104|3700->2135|4035->2443|4086->2473|4115->2474|4178->2510|4212->2523|4433->2715|4463->2716|4535->2759|4565->2760|4870->3038|4917->3064|4946->3065|5009->3101|5043->3114|5272->3316|5328->3351|5708->3704|5751->3726|5780->3727|5843->3763|5877->3776|6060->3931|6110->3959|6202->4024|6251->4052|6584->4358|6632->4385|6661->4386|6724->4422|6758->4435|6977->4625|7007->4626|7079->4669|7109->4670|7432->4966|7477->4990|7518->5003|7734->5190|7782->5215|7944->5348|7993->5374
                  LINES: 33->1|37->5|37->5|43->11|43->11|44->12|46->14|46->14|47->15|52->20|52->20|53->21|53->21|63->31|63->31|70->38|70->38|70->38|71->39|71->39|74->42|74->42|82->50|82->50|82->50|83->51|83->51|85->53|85->53|85->53|85->53|92->60|92->60|92->60|93->61|93->61|96->64|96->64|105->73|105->73|105->73|106->74|106->74|108->76|108->76|109->77|109->77|117->85|117->85|117->85|118->86|118->86|120->88|120->88|120->88|120->88|130->98|130->98|131->99|136->104|136->104|137->105|137->105
                  -- GENERATED --
              */
          