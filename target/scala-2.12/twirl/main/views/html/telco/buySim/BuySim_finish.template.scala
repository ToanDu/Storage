
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
/*1.2*/import vn.m2m.common.models.User

object BuySim_finish extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<div class="modal fade" id="notificationModal" data-bs-backdrop="static" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16" style="align-items: center;">
      """),format.raw/*6.100*/("""
      """),format.raw/*7.97*/("""
      """),format.raw/*8.17*/("""
    """),format.raw/*9.5*/("""<div class="modal-header" style="border-bottom: 0px solid #e9ecef; padding-bottom: 0px;">
      <img src=""""),_display_(/*10.18*/routes/*10.24*/.Assets.versioned("images/telco/successIcon.png")),format.raw/*10.73*/("""" alt="..." style="width: 56px; height: 56px;" class="card-img mt-3">
    </div>
    <div class="modal-header" style="padding-bottom: 0px; padding-top: 0px;">
      <label class="col-sm-12 col-form-label title-section-2" style="color: red; font-weight: 600;">"""),_display_(/*13.102*/Messages("buySim.orderResult")),format.raw/*13.132*/("""</label>
    </div>

    <div class="modal-body text-darker" style="text-align: center;">
      <div class="row">
        <div class="col-md-12">
          <div class="table-responsive mt-3">
            <table id="tableResultBuySim" class="table table-striped table-bordered" cellspacing='0' width='100%'>
              <thead>
                <th>"""),_display_(/*22.22*/Messages("buySim.productName")),format.raw/*22.52*/("""</th>
                <th>"""),_display_(/*23.22*/Messages("buySim.quantity")),format.raw/*23.49*/("""</th>
                <th>"""),_display_(/*24.22*/Messages("buySim.successfulOrders")),format.raw/*24.57*/("""</th>
                <th>"""),_display_(/*25.22*/Messages("buySim.failedOrders")),format.raw/*25.53*/("""</th>
                <th>"""),_display_(/*26.22*/Messages("")),format.raw/*26.34*/("""</th>
              </thead>
              <tbody align="left"></tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

    <div class="modal-header" style="border-bottom: 0px solid #e9ecef; padding-bottom: 0px; padding-top: 0px; text-align: center;">
      <label class="col-sm-12 col-form-label title-section-2" style="padding-bottom: 0px;">"""),_display_(/*36.93*/Messages("order.success.contact")),format.raw/*36.126*/("""</label>
      <label class="col-sm-12 col-form-label title-section-2" style="">"""),_display_(/*37.73*/Messages("order.success.thanks")),format.raw/*37.105*/("""</label>
    </div>
    <div class="modal-footer">
      <a type="button" class="btn btn-telco" data-bs-dismiss="modal" style="background: #FFFFFF; color: #EA0033; border: 1px solid #EA0033;">"""),_display_(/*40.143*/Messages("buySim.close")),format.raw/*40.167*/("""</a>
      <a type="button" class="btn btn-telco" href=""""),_display_(/*41.53*/routes/*41.59*/.TelcoOrderController.manageOrder(currentUser.getId)),format.raw/*41.111*/("""" style="background: #EA0033; color: #FFFFFF;">"""),_display_(/*41.159*/Messages("buySim.finish")),format.raw/*41.184*/("""</a>
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
                  DATE: Mon Sep 22 16:32:51 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/buySim/BuySim_finish.scala.html
                  HASH: 970d7759ede4659490d1604f0f5b7471c4c1d953
                  MATRIX: 664->1|1007->35|1120->53|1147->54|1400->372|1434->469|1468->486|1499->491|1633->598|1648->604|1718->653|2006->913|2058->943|2435->1293|2486->1323|2540->1350|2588->1377|2642->1404|2698->1439|2752->1466|2804->1497|2858->1524|2891->1536|3292->1910|3347->1943|3455->2024|3509->2056|3730->2249|3776->2273|3860->2330|3875->2336|3949->2388|4025->2436|4072->2461
                  LINES: 24->1|29->2|34->2|35->3|38->6|39->7|40->8|41->9|42->10|42->10|42->10|45->13|45->13|54->22|54->22|55->23|55->23|56->24|56->24|57->25|57->25|58->26|58->26|68->36|68->36|69->37|69->37|72->40|72->40|73->41|73->41|73->41|73->41|73->41
                  -- GENERATED --
              */
          