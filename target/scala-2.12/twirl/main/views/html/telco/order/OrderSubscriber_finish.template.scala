
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

object OrderSubscriber_finish extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User, userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.35*/("""
"""),format.raw/*3.1*/("""<div class="modal fade" id="notificationModal" data-bs-backdrop="static" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16" style="align-items: center;">
      <div class="modal-header">
        <img src=""""),_display_(/*7.20*/routes/*7.26*/.Assets.versioned("images/telco/successIcon.png")),format.raw/*7.75*/("""" alt="..." style="width: 56px; height: 56px;" class="card-img mt-3">
      </div>
      <div class="modal-body text-darker" style="text-align: center;">
        <h4 class="modal-title">"""),_display_(/*10.34*/Messages("Bạn đã thanh toán thành công?")),format.raw/*10.75*/("""</h4>
        <small style="margin-top: 15px;">"""),_display_(/*11.43*/Messages("Xác nhận đã thanh toán thành công, bạn vui lòng quay lại trang quản lý thuê bao để kiểm tra danh sách thuê bao đã được đấu nối!")),format.raw/*11.182*/("""</small>
        <div class="" id="iframePaymentConnectSim">
          """),format.raw/*13.102*/("""
        """),format.raw/*14.9*/("""</div>
      </div>
      <div class="modal-footer">
        <a type="button" class="btn btn-telco" href=""""),_display_(/*17.55*/routes/*17.61*/.TelcoSubscriberController.subscriberManage(userId)),format.raw/*17.112*/("""" style="background: #EA0033; color: #FFFFFF;">"""),_display_(/*17.160*/Messages("btnComfirm")),format.raw/*17.182*/("""</a>
        <a type="button" class="btn btn-telco" data-bs-dismiss="modal" style="background: #FFFFFF; color: #EA0033; border: 1px solid #EA0033;">"""),_display_(/*18.145*/Messages("btnCancel")),format.raw/*18.166*/("""</a>
      </div>
    </div>
  </div>
</div>"""))
      }
    }
  }

  def render(currentUser:User,userId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,userId)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,userId) => apply(currentUser,userId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:53 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/order/OrderSubscriber_finish.scala.html
                  HASH: 7dc0bb4b706b82484688ea1787839c600d8b8e26
                  MATRIX: 663->1|1022->35|1150->68|1177->69|1465->331|1479->337|1548->386|1762->573|1824->614|1899->662|2060->801|2160->963|2196->972|2330->1079|2345->1085|2418->1136|2494->1184|2538->1206|2715->1355|2758->1376
                  LINES: 24->1|29->2|34->2|35->3|39->7|39->7|39->7|42->10|42->10|43->11|43->11|45->13|46->14|49->17|49->17|49->17|49->17|49->17|50->18|50->18
                  -- GENERATED --
              */
          