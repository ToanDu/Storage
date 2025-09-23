
package views.html.landingPage

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

object LandingPage_giaiPhap extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="section features-1" id="divGiaiPhap">
  <div class="container">
    <div class="col-md-12 mx-auto text-center">
      <h3 class="display-3 title-section-1">"""),_display_(/*4.46*/Messages("Giải pháp cho mọi dự án IoT")),format.raw/*4.85*/("""</h3>
      <hr style="border-top: 4px solid red; width: 84px; margin-top: 1rem;">
    </div>
    <div class="row mt-5">
      <div class="col-md-3">
        <div class="card card-blue text-center card-listProject">
          <div class="alignItemCenter mt-3">
            <img src=""""),_display_(/*11.24*/routes/*11.30*/.Assets.versioned("images/landingPage/icon001.png")),format.raw/*11.81*/("""" width="" class="align-items-center">
          </div>
          <div class="text mt-3">
            <h4 class="gp-title-1">"""),_display_(/*14.37*/Messages("Telco Management")),format.raw/*14.65*/("""</h4>
            <p class="mt-3">"""),_display_(/*15.30*/Messages("Hỗ trợ quản lý kết nối, quản lý SIM (CMP). Đa dạng hình thức tính cước.")),format.raw/*15.113*/("""</p>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="card card-blue text-center card-listProject">
          <div class="alignItemCenter mt-3">
            <img src=""""),_display_(/*22.24*/routes/*22.30*/.Assets.versioned("images/landingPage/icon002.png")),format.raw/*22.81*/("""" width="" class="align-items-center">
          </div>
          <div class="text mt-3">
            <h4 class="gp-title-1">"""),_display_(/*25.37*/Messages("Microservices")),format.raw/*25.62*/("""</h4>
            <p class="mt-3">"""),_display_(/*26.30*/Messages("Kiến trúc microservices giúp chuyển đổi quy mô linh hoạt")),format.raw/*26.98*/("""</p>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="card card-blue text-center card-listProject">
          <div class="alignItemCenter mt-3">
            <img src=""""),_display_(/*33.24*/routes/*33.30*/.Assets.versioned("images/landingPage/icon003.png")),format.raw/*33.81*/("""" width="" class="align-items-center">
          </div>
          <div class="text mt-3">
            <h4 class="gp-title-1">"""),_display_(/*36.37*/Messages("Cloud Platform")),format.raw/*36.63*/("""</h4>
            <p class="mt-3">"""),_display_(/*37.30*/Messages("Tùy chọn lưu trữ tại chỗ (on-premise) và đám mây (on-cloud)")),format.raw/*37.101*/("""</p>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="card card-blue text-center card-listProject">
          <div class="alignItemCenter mt-3">
            <img src=""""),_display_(/*44.24*/routes/*44.30*/.Assets.versioned("images/landingPage/icon004.png")),format.raw/*44.81*/("""" width="" class="align-items-center">
          </div>
          <div class="text mt-3">
            <h4 class="gp-title-1">"""),_display_(/*47.37*/Messages("IoT Dashboards")),format.raw/*47.63*/("""</h4>
            <p class="mt-3">"""),_display_(/*48.30*/Messages("Giao diện thống kê (dashboards) trực quan, đa dạng")),format.raw/*48.92*/("""</p>
          </div>
        </div>
      </div>

      <div class="col-md-3 mt-3">
        <div class="card card-blue text-center card-listProject">
          <div class="alignItemCenter mt-3">
            <img src=""""),_display_(/*56.24*/routes/*56.30*/.Assets.versioned("images/landingPage/icon005.png")),format.raw/*56.81*/("""" width="" class="align-items-center">
          </div>
          <div class="text mt-3">
            <h4 class="gp-title-1">"""),_display_(/*59.37*/Messages("IoT Flow Engine")),format.raw/*59.64*/("""</h4>
            <p class="mt-3">"""),_display_(/*60.30*/Messages("Giao diện lập trình kéo thả (graphic-based programming)")),format.raw/*60.97*/("""</p>
          </div>
        </div>
      </div>
      <div class="col-md-3 mt-3">
        <div class="card card-blue text-center card-listProject">
          <div class="alignItemCenter mt-3">
            <img src=""""),_display_(/*67.24*/routes/*67.30*/.Assets.versioned("images/landingPage/icon006.png")),format.raw/*67.81*/("""" width="" class="align-items-center">
          </div>
          <div class="text mt-3">
            <h4 class="gp-title-1">"""),_display_(/*70.37*/Messages("Device Management")),format.raw/*70.66*/("""</h4>
            <p class="mt-3">"""),_display_(/*71.30*/Messages("Kết nối, quản lý và mở rộng quy mô nhóm thiết bị của bạn một cách dễ dàng và đáng tin cậy.")),format.raw/*71.132*/("""</p>
          </div>
        </div>
      </div>
      <div class="col-md-3 mt-3">
        <div class="card card-blue text-center card-listProject">
          <div class="alignItemCenter mt-3">
            <img src=""""),_display_(/*78.24*/routes/*78.30*/.Assets.versioned("images/landingPage/icon007.png")),format.raw/*78.81*/("""" width="" class="align-items-center">
          </div>
          <div class="text mt-3">
            <h4 class="gp-title-1">"""),_display_(/*81.37*/Messages("Alarms Management")),format.raw/*81.66*/("""</h4>
            <p class="mt-3">"""),_display_(/*82.30*/Messages("Cung cấp khả năng tạo và quản lý các cảnh báo liên quan đến các thực thể của dự án: thiết bị, tài sản,...")),format.raw/*82.147*/("""</p>
          </div>
        </div>
      </div>
      <div class="col-md-3 mt-3">
        <div class="card card-blue text-center card-listProject">
          <div class="alignItemCenter mt-3">
            <img src=""""),_display_(/*89.24*/routes/*89.30*/.Assets.versioned("images/landingPage/icon008.png")),format.raw/*89.81*/("""" width="" class="align-items-center">
          </div>
          <div class="text mt-3">
            <h4 class="gp-title-1">"""),_display_(/*92.37*/Messages("Security")),format.raw/*92.57*/("""</h4>
            <p class="mt-3">"""),_display_(/*93.30*/Messages("Bảo mật kết nối thiết bị và dữ liệu bằng cách xác thực hai chiều và mã hóa đầu cuối.")),format.raw/*93.126*/("""</p>
          </div>
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
                  DATE: Mon Sep 22 16:32:47 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPage/LandingPage_giaiPhap.scala.html
                  HASH: 9ee0024e7d727d61d7ae6ba5b5f9ed6ab27e049a
                  MATRIX: 1057->0|1252->169|1311->208|1622->492|1637->498|1709->549|1862->675|1911->703|1973->738|2078->821|2318->1034|2333->1040|2405->1091|2558->1217|2604->1242|2666->1277|2755->1345|2995->1558|3010->1564|3082->1615|3235->1741|3282->1767|3344->1802|3437->1873|3677->2086|3692->2092|3764->2143|3917->2269|3964->2295|4026->2330|4109->2392|4355->2611|4370->2617|4442->2668|4595->2794|4643->2821|4705->2856|4793->2923|5038->3141|5053->3147|5125->3198|5278->3324|5328->3353|5390->3388|5514->3490|5759->3708|5774->3714|5846->3765|5999->3891|6049->3920|6111->3955|6250->4072|6495->4290|6510->4296|6582->4347|6735->4473|6776->4493|6838->4528|6956->4624
                  LINES: 33->1|36->4|36->4|43->11|43->11|43->11|46->14|46->14|47->15|47->15|54->22|54->22|54->22|57->25|57->25|58->26|58->26|65->33|65->33|65->33|68->36|68->36|69->37|69->37|76->44|76->44|76->44|79->47|79->47|80->48|80->48|88->56|88->56|88->56|91->59|91->59|92->60|92->60|99->67|99->67|99->67|102->70|102->70|103->71|103->71|110->78|110->78|110->78|113->81|113->81|114->82|114->82|121->89|121->89|121->89|124->92|124->92|125->93|125->93
                  -- GENERATED --
              */
          