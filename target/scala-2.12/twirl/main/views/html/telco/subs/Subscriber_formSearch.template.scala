
package views.html.telco.subs

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
/*2.2*/import vn.m2m.utils.UserHelper

object Subscriber_formSearch extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.20*/("""
"""),format.raw/*4.1*/("""<div class="card">
  <div class="card-body">
    <span class="text-search">"""),_display_(/*6.32*/Messages("subscriber.searchInfo")),format.raw/*6.65*/("""</span>
    <input id="gpkd" type="text" class="form-control" readonly hidden>

    <div class="row mt-3">
      <div class="col-md-9">
        <div class="row">
          <div class="col-md-6 m-t-3">
            <div class="row m-b-4">
              <div class="col-sm-1"></div>
              <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*15.71*/Messages("subscriber.phoneNumber")),format.raw/*15.105*/("""</label>
              <div class="col-sm-8 input-icons">
                """),format.raw/*17.174*/("""

                """),format.raw/*19.17*/("""<div class="input-group">
                  <input id="isdn" type="text" class="form-control input-form" style="border-right: 0px;" placeholder=""""),_display_(/*20.121*/Messages("subscriber.inputPlaceholder")),format.raw/*20.160*/("""" onkeypress="return isNumberKey(event)" maxlength="10000" required>
                  <a onclick="importSearchListSub()" class="input-group-text cursor-pointer" style="border-left: 0px; background-color: #ffffff">
                    <img src=""""),_display_(/*22.32*/routes/*22.38*/.Assets.versioned("images/telco/excel.png")),format.raw/*22.81*/("""" class="" alt="..." >
                  </a>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-6 m-t-3">
            <div class="row m-b-4">
              <div class="col-sm-1"></div>
              <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*31.71*/Messages("subscriber.serialLabel")),format.raw/*31.105*/("""</label>
              <div class="col-sm-8">
                <div class="input-group">
                  <input id="serialSim" type="text" class="form-control input-form" style="border-right: 0px;" placeholder=""""),_display_(/*34.126*/Messages("subscriber.inputPlaceholder")),format.raw/*34.165*/("""" onkeypress="return isNumberKey(event)"  maxlength="20000" required>
                  <a onclick="importSearchListSerial()" class="input-group-text cursor-pointer" style="border-left: 0px; background-color: #ffffff">
                    <img src=""""),_display_(/*36.32*/routes/*36.38*/.Assets.versioned("images/telco/excel.png")),format.raw/*36.81*/("""" class="" alt="..." >
                  </a>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-6 m-t-3">
            <div class="row m-b-4">
              <div class="col-sm-1"></div>
              <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*45.71*/Messages("subscriber.contractCode")),format.raw/*45.106*/("""</label>
              <div class="col-sm-8">
                <div class="input-group">
                  <input id="accountId" type="text" class="form-control input-form" placeholder=""""),_display_(/*48.99*/Messages("subscriber.inputPlaceholder")),format.raw/*48.138*/("""" onkeypress="return isNumberKey(event)" maxlength="250" required>
                  """),format.raw/*49.154*/("""
                    """),format.raw/*50.107*/("""
                  """),format.raw/*51.27*/("""
                """),format.raw/*52.17*/("""</div>
              </div>
            </div>
          </div>
          <div class="col-md-6 m-t-3">
            <div class="row m-b-4">
              <div class="col-sm-1"></div>
              <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*59.71*/Messages("subscriber.serviceType")),format.raw/*59.105*/("""</label>
              <div class="col-sm-8">
                <select id="payType" type="text" class="form-select" onchange="choosePayType(this)">
                  <option value="" selected>"""),_display_(/*62.46*/Messages("subscriber.selectOption")),format.raw/*62.81*/("""</option>
                  <option value="1">"""),_display_(/*63.38*/Messages("subscriber.postpaid")),format.raw/*63.69*/("""</option>
                  <option value="2">"""),_display_(/*64.38*/Messages("subscriber.prepaid")),format.raw/*64.68*/("""</option>
                </select>
              </div>
            </div>
          </div>
          <div class="col-md-6 m-t-3">
            <div class="row m-b-4">
              <div class="col-sm-1"></div>
              <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*72.71*/Messages("subscriber.servicePackageUsing")),format.raw/*72.113*/("""</label>
              <div class="col-sm-8">
                <select id="productCode" type="text" class="form-select">
                  <option value="" selected>"""),_display_(/*75.46*/Messages("subscriber.selectOption")),format.raw/*75.81*/("""</option>
                </select>
              </div>
            </div>
          </div>
          <div class="col-md-6 m-t-3">
            <div class="row m-b-4">
              <div class="col-sm-1"></div>
              <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*83.71*/Messages("subscriber.blockCutStatus")),format.raw/*83.108*/("""</label>
              <div class="col-sm-8">
                <select id="actStatus" type="text" class="form-select">
                  <option value="" selected>"""),_display_(/*86.46*/Messages("subscriber.selectServiceType")),format.raw/*86.86*/("""</option>
                </select>
              </div>
            </div>
          </div>

          <div class="col-md-6 m-t-3">
            <div class="row m-b-4">
              <div class="col-sm-1"></div>
              <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*95.71*/Messages("subscriber.activationDate")),format.raw/*95.108*/("""</label>
              <div class="col-sm-8">
                <div class="row">
                  <div class="col-sm-6">
                    <input class="form-control datetimepicker" type="text" id="staDatetimeFrom" value="" placeholder=""""),_display_(/*99.120*/Messages("subscriber.fromDate")),format.raw/*99.151*/("""">
                  </div>
                  <div class="col-sm-6">
                    <input class="form-control datetimepicker" type="text" id="staDatetimeTo" value="" placeholder=""""),_display_(/*102.118*/Messages("subscriber.toDate")),format.raw/*102.147*/("""">
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-6 m-t-3">
            <div class="row m-b-4">
              <div class="col-sm-1"></div>
              <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*111.71*/Messages("subscriber.connectionDate")),format.raw/*111.108*/("""</label>
              <div class="col-sm-8">
                <div class="row">
                  <div class="col-sm-6">
                    <input class="form-control datetimepicker" type="text" id="activeDateFrom" value="" placeholder=""""),_display_(/*115.119*/Messages("subscriber.fromDate")),format.raw/*115.150*/("""">
                  </div>
                  <div class="col-sm-6">
                    <input class="form-control datetimepicker" type="text" id="activeDateTo" value="" placeholder=""""),_display_(/*118.117*/Messages("subscriber.toDate")),format.raw/*118.146*/("""">
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-6 m-t-3">
            <div class="row m-b-4">
              <div class="col-sm-1"></div>
              <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*127.71*/Messages("subscriber.businessLicenseNumber")),format.raw/*127.115*/("""</label>
              <div class="col-sm-8">
                <div class="input-group">
                  <select id="idNo" type="text" class="form-select">
                    <option value="" selected>"""),_display_(/*131.48*/Messages("subscriber.selectBusinessLicense")),format.raw/*131.92*/("""</option>
                  </select>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="card-body" style="height: 100%;">
          <div class="d-flex flex-column align-items-center text-center" style="height: 100%; background-color: #EA0033; border-radius: 16px;">
            <img src=""""),_display_(/*142.24*/routes/*142.30*/.Assets.versioned("images/telco/thuebao.svg")),format.raw/*142.75*/("""" alt="Admin" class="img-tb" width="110">
            <div class="mt-3">
              <span class="text-white count-tb" id="count-tb">0</span><br>
              <span class="text-white">"""),_display_(/*145.41*/Messages("subscriber.subscriberCount")),format.raw/*145.79*/("""</span>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="d-flex flex-column align-items-center text-center">
      <div class="">
        """),_display_(/*153.10*/if(UserHelper.isFeatureRole(currentUser, "export_sub"))/*153.65*/{_display_(Seq[Any](format.raw/*153.66*/("""
          """),format.raw/*154.11*/("""<button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="onlickButtonExport()">"""),_display_(/*154.137*/Messages("subscriber.export")),format.raw/*154.166*/("""</button>
        """)))}),format.raw/*155.10*/("""
        """),format.raw/*156.9*/("""<button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="resetFormSearch()">"""),_display_(/*156.132*/Messages("subscriber.reset")),format.raw/*156.160*/("""</button>
        """),_display_(/*157.10*/if(UserHelper.isFeatureRole(currentUser, "view_sub"))/*157.63*/{_display_(Seq[Any](format.raw/*157.64*/("""
          """),format.raw/*158.11*/("""<button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF;" onclick="onlickButtonSearch()">"""),_display_(/*158.137*/Messages("subscriber.search")),format.raw/*158.166*/("""</button>
        """)))}),format.raw/*159.10*/("""
      """),format.raw/*160.7*/("""</div>
    </div>
  </div>
</div>"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:55 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/subs/Subscriber_formSearch.scala.html
                  HASH: e13770b84094297462af856078aa632a162c8320
                  MATRIX: 662->1|702->35|1051->67|1164->85|1191->86|1293->162|1346->195|1723->545|1779->579|1882->810|1928->828|2102->974|2163->1013|2436->1259|2451->1265|2515->1308|2856->1622|2912->1656|3153->1869|3214->1908|3491->2158|3506->2164|3570->2207|3911->2521|3968->2556|4181->2742|4242->2781|4356->3001|4406->3108|4453->3135|4498->3152|4777->3404|4833->3438|5052->3630|5108->3665|5182->3712|5234->3743|5308->3790|5359->3820|5667->4101|5731->4143|5923->4308|5979->4343|6287->4624|6346->4661|6536->4824|6597->4864|6906->5146|6965->5183|7233->5423|7286->5454|7501->5640|7553->5669|7877->5965|7937->6002|8205->6241|8259->6272|8473->6457|8525->6486|8849->6782|8916->6826|9148->7030|9214->7074|9638->7470|9654->7476|9721->7521|9937->7709|9997->7747|10206->7928|10271->7983|10311->7984|10351->7995|10506->8121|10558->8150|10609->8169|10646->8178|10798->8301|10849->8329|10896->8348|10959->8401|10999->8402|11039->8413|11194->8539|11246->8568|11297->8587|11332->8594
                  LINES: 24->1|25->2|30->3|35->3|36->4|38->6|38->6|47->15|47->15|49->17|51->19|52->20|52->20|54->22|54->22|54->22|63->31|63->31|66->34|66->34|68->36|68->36|68->36|77->45|77->45|80->48|80->48|81->49|82->50|83->51|84->52|91->59|91->59|94->62|94->62|95->63|95->63|96->64|96->64|104->72|104->72|107->75|107->75|115->83|115->83|118->86|118->86|127->95|127->95|131->99|131->99|134->102|134->102|143->111|143->111|147->115|147->115|150->118|150->118|159->127|159->127|163->131|163->131|174->142|174->142|174->142|177->145|177->145|185->153|185->153|185->153|186->154|186->154|186->154|187->155|188->156|188->156|188->156|189->157|189->157|189->157|190->158|190->158|190->158|191->159|192->160
                  -- GENERATED --
              */
          