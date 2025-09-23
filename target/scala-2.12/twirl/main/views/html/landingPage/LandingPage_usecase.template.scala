
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

object LandingPage_usecase extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="section features-1" id="divUseCase">
  <div class="container">
    <div class="row">
      <div class="col-md-4">
        <div class="usecase1">
          <div class="usecase1-menu">
            <img src=""""),_display_(/*7.24*/routes/*7.30*/.Assets.versioned("images/landingPage/usecase1.png")),format.raw/*7.82*/("""" width="80%">
          </div>
          <div class="text mt-1">
            <p class="mt-3">"""),_display_(/*10.30*/Messages("Nền tảng IoT InnoWay hỗ trợ nhiều giải pháp IoT mạnh mẽ, có thể mở rộng và thân thiện với người dùng. Flow Engine dễ dàng xây dựng luồng xử lý logic.")),format.raw/*10.191*/("""</p>
          </div>
        </div>
      </div>

      <div class="col-md-4">
        <div class="usecase">
          <div class="usecase-menu">
            <span class="usecase-title"><img src=""""),_display_(/*18.52*/routes/*18.58*/.Assets.versioned("images/landingPage/usecase2.png")),format.raw/*18.110*/("""" width=""> &nbsp;"""),_display_(/*18.129*/Messages("Nhà thông minh")),format.raw/*18.155*/("""</span>
          </div>
          <div class="text mt-1">
            <p class="mt-3">"""),_display_(/*21.30*/Messages("• Điều khiển các thiết bị điện trong nhà từ xa qua các công nghệ IR, Wifi, Zigbee. ")),format.raw/*21.125*/("""</p>
            <p class="mt-3">"""),_display_(/*22.30*/Messages("• Giám sát tất cả chuyển động, thay đổi về trạng thái hoạt động của từng thiết bị điện.")),format.raw/*22.129*/("""</p>
            <p class="mt-3">"""),_display_(/*23.30*/Messages("• Hỗ trợ các ngữ cảnh thông minh được đặt theo giờ hoặc theo ngoại cảnh để người sử dụng có trải nghiệm và sức khỏe tinh thần tốt nhất trong căn nhà của mình.")),format.raw/*23.200*/("""</p>
          </div>
        </div>
      </div>

      <div class="col-md-4">
        <div class="usecase">
          <div class="usecase-menu">
            <span class="usecase-title"><img src=""""),_display_(/*31.52*/routes/*31.58*/.Assets.versioned("images/landingPage/usecase3.png")),format.raw/*31.110*/("""" width=""> &nbsp;"""),_display_(/*31.129*/Messages("Định vị thông minh")),format.raw/*31.159*/("""</span>
          </div>
          <div class="text mt-1">
            <p class="mt-3">"""),_display_(/*34.30*/Messages("• Giải pháp hỗ trợ các luồng xử lý bản tin định vị, cảnh báo vùng an toàn, pin yếu, cảnh báo khẩn cấp tới người sử dụng. ")),format.raw/*34.163*/("""</p>
            <p class="mt-3">"""),_display_(/*35.30*/Messages("• Người sử dụng cũng có thể cấu hình từ xa cho thiết bị về chu kỳ gửi bản tin, chế độ tiết kiệm năng lượng, chế độ hòa mạng, hoặc cấu hình nhận cảnh báo qua SMS hoặc Notification từ App.")),format.raw/*35.228*/("""</p>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-4">
        <div class="usecase">
          <div class="usecase-menu">
            <img src=""""),_display_(/*44.24*/routes/*44.30*/.Assets.versioned("images/landingPage/usecase4.png")),format.raw/*44.82*/("""" width="">
            <span class="usecase-title">"""),_display_(/*45.42*/Messages("Đo lường thông minh")),format.raw/*45.73*/("""</span>
          </div>
          <div class="text mt-1">
            <p class="mt-3">"""),_display_(/*48.30*/Messages("• Thu thập, lưu trữ và tổng hợp dữ liệu từ đồng hồ (Điện, nước,...) thông minh một cách xác nhất.")),format.raw/*48.139*/("""</p>
            <p class="mt-3">"""),_display_(/*49.30*/Messages("• Phân tích mức tiêu thụ tài nguyên và đưa ra cảnh báo về rò rỉ, bất thường hoặc gian lận. ")),format.raw/*49.133*/("""</p>
            <p class="mt-3">"""),_display_(/*50.30*/Messages("• Trình bày kết quả phân tích cho người dùng cuối.")),format.raw/*50.92*/("""</p>
          </div>
        </div>
      </div>

      <div class="col-md-4">
        <div class="usecase">
          <div class="usecase-menu">
            <span class="usecase-title"><img src=""""),_display_(/*58.52*/routes/*58.58*/.Assets.versioned("images/landingPage/usecase5.png")),format.raw/*58.110*/("""" width=""> &nbsp;"""),_display_(/*58.129*/Messages("Văn phòng thông minh ")),format.raw/*58.162*/("""</span>
          </div>
          <div class="text mt-1">
            <p class="mt-3">"""),_display_(/*61.30*/Messages("• Đảm bảo sức khỏe và sự an toàn của nhân viên để thúc đẩy năng suất của tổ chức, doanh nghiệp.")),format.raw/*61.137*/("""</p>
            <p class="mt-3">"""),_display_(/*62.30*/Messages("• Tối ưu hóa việc tiêu thụ các tài nguyên (điện, nước, không khí, nhiệt độ, trang thiết bị, vật tư,...)")),format.raw/*62.145*/("""</p>
            <p class="mt-3">"""),_display_(/*63.30*/Messages("• Nâng cao khả năng bảo mật, an ninh, an toàn cũng như phòng chống cháy nổ.")),format.raw/*63.117*/("""</p>
            <p class="mt-3">"""),_display_(/*64.30*/Messages("• Tất cả đều có thể điều khiển và kiểm soát từ xa.")),format.raw/*64.92*/("""</p>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="usecase">
          <div class="usecase-menu">
            <span class="usecase-title"><img src=""""),_display_(/*71.52*/routes/*71.58*/.Assets.versioned("images/landingPage/usecase6.png")),format.raw/*71.110*/("""" width=""> &nbsp;"""),_display_(/*71.129*/Messages("Quản lý tài sản")),format.raw/*71.156*/("""</span>
          </div>
          <div class="text mt-1">
            <p class="mt-3">"""),_display_(/*74.30*/Messages("• Theo dõi tài sản từ xa.")),format.raw/*74.67*/("""</p>
            <p class="mt-3">"""),_display_(/*75.30*/Messages("• Theo dõi tình trạng / trạng thái của tài sản, quản lý vòng đời tài sản. ")),format.raw/*75.116*/("""</p>
            <p class="mt-3">"""),_display_(/*76.30*/Messages("• Tự động hóa quy trình làm việc tài sản.")),format.raw/*76.83*/("""</p>
            <p class="mt-3">"""),_display_(/*77.30*/Messages("• Bảo mật cho tài sản bằng cách mã hóa dữ liệu để đảm bảo rằng dữ liệu được giữ riêng tư và an toàn.")),format.raw/*77.142*/("""</p>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPage/LandingPage_usecase.scala.html
                  HASH: f33d8159a963e69e91774510ddac8b5952f72f97
                  MATRIX: 1056->0|1300->218|1314->224|1386->276|1508->371|1691->532|1916->730|1931->736|2005->788|2052->807|2100->833|2215->921|2332->1016|2393->1050|2514->1149|2575->1183|2767->1353|2992->1551|3007->1557|3081->1609|3128->1628|3180->1658|3295->1746|3450->1879|3511->1913|3731->2111|3960->2313|3975->2319|4048->2371|4128->2424|4180->2455|4295->2543|4426->2652|4487->2686|4612->2789|4673->2823|4756->2885|4981->3083|4996->3089|5070->3141|5117->3160|5172->3193|5287->3281|5416->3388|5477->3422|5614->3537|5675->3571|5784->3658|5845->3692|5928->3754|6152->3951|6167->3957|6241->4009|6288->4028|6337->4055|6452->4143|6510->4180|6571->4214|6679->4300|6740->4334|6814->4387|6875->4421|7009->4533
                  LINES: 33->1|39->7|39->7|39->7|42->10|42->10|50->18|50->18|50->18|50->18|50->18|53->21|53->21|54->22|54->22|55->23|55->23|63->31|63->31|63->31|63->31|63->31|66->34|66->34|67->35|67->35|76->44|76->44|76->44|77->45|77->45|80->48|80->48|81->49|81->49|82->50|82->50|90->58|90->58|90->58|90->58|90->58|93->61|93->61|94->62|94->62|95->63|95->63|96->64|96->64|103->71|103->71|103->71|103->71|103->71|106->74|106->74|107->75|107->75|108->76|108->76|109->77|109->77
                  -- GENERATED --
              */
          