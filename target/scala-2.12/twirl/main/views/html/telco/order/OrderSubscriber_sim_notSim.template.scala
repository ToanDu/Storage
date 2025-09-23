
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

object OrderSubscriber_sim_notSim extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<div class="col-lg-9 col-md-8 mt-3" id="tabConnectNotSim" style="display: none;">
  <div class="row">
    <div class="col-md-12 m-t-4">
      <span class="display-4 title-section-1">"""),_display_(/*6.48*/Messages("1. Thông tin doanh nghiệp")),format.raw/*6.85*/("""</span>
    </div>
    <div class="col-md-12">
      <div class="row">
        <div class="col-md-6 m-t-3">
          <div class="row m-b-4">
            <label class="col-sm-4 col-form-label title-section-2" style="text-align: left">"""),_display_(/*12.94*/Messages("Họ tên người đại diện")),format.raw/*12.127*/("""<span class="text-red">"""),_display_(/*12.151*/Messages("*")),format.raw/*12.164*/("""</span></label>
            <div class="col-sm-8">
              <input id="namePerCompany" type="text" class="form-control input-form" maxlength="255" autocomplete="off">
            </div>
          </div>
        </div>
        <div class="col-md-6 m-t-3">
          <div class="row m-b-4">
            <label class="col-sm-4 col-form-label title-section-2" style="text-align: left">"""),_display_(/*20.94*/Messages("Mã số Doanh nghiệp")),format.raw/*20.124*/("""<span class="text-red">"""),_display_(/*20.148*/Messages("*")),format.raw/*20.161*/("""</span></label>
            <div class="col-sm-8">
              <input id="gpkdCompany" type="number" class="form-control input-form" maxlength="255" autocomplete="off">
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="col-md-12 m-t-4">
      <span class="display-4 title-section-1">"""),_display_(/*30.48*/Messages("2. Hình thức nhận SIM")),format.raw/*30.81*/("""</span>
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
                  DATE: Mon Sep 22 16:32:53 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/order/OrderSubscriber_sim_notSim.scala.html
                  HASH: 4a20e25b37b9201b257d7078f7d569927c07f8f3
                  MATRIX: 663->1|1019->35|1132->53|1159->54|1368->237|1425->274|1687->509|1742->542|1794->566|1829->579|2243->966|2295->996|2347->1020|2382->1033|2737->1361|2791->1394
                  LINES: 24->1|29->2|34->2|35->3|38->6|38->6|44->12|44->12|44->12|44->12|52->20|52->20|52->20|52->20|62->30|62->30
                  -- GENERATED --
              */
          