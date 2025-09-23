
package views.html.telco.prepayCharges

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

object PrepayCharges_formSearch extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<div class="card">
  <div class="card-body">
    <span class="text-search">"""),_display_(/*5.32*/Messages("prepayCharges.subtitle")),format.raw/*5.66*/("""</span>
    <input id="gpkd" type="text" class="form-control" readonly hidden>
    <div class="row mt-3">
      <div class="row">
        <div class="col-md-6">
          <div class="mb-3 row">
            <label for="orderType" class="col-sm-2 col-form-label">"""),_display_(/*11.69*/Messages("prepayCharges.phoneNumber")),format.raw/*11.106*/("""</label>
            <div class="col-sm-10">
              <input id="isdn" type="text" class="form-control input-form" placeholder=""""),_display_(/*13.90*/Messages("prepayCharges.enterSubscriber")),format.raw/*13.131*/("""" maxlength="11" inputmode="numeric" required>
              <p class="title-section-2 text-darker fst-italic pt-3">
                """),_display_(/*15.18*/Messages("prepayCharges.notePostpaid")),format.raw/*15.56*/("""
              """),format.raw/*16.15*/("""</p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="d-flex flex-column align-items-center text-center">
      <div class="">
        <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF;"
          onclick="searchData()">"""),_display_(/*25.35*/Messages("prepayCharges.search")),format.raw/*25.67*/("""</button>
        <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;"
            onclick="resetData()">"""),_display_(/*27.36*/Messages("Reset")),format.raw/*27.53*/("""</button>
      </div>
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
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/prepayCharges/PrepayCharges_formSearch.scala.html
                  HASH: 9b6af984f1c9c2811dffdedc52c5d91c0b035014
                  MATRIX: 671->1|1025->35|1138->53|1165->54|1267->130|1321->164|1610->426|1669->463|1830->597|1893->638|2054->772|2113->810|2156->825|2488->1130|2541->1162|2715->1309|2753->1326
                  LINES: 24->1|29->2|34->2|35->3|37->5|37->5|43->11|43->11|45->13|45->13|47->15|47->15|48->16|57->25|57->25|59->27|59->27
                  -- GENERATED --
              */
          