
package views.html.iot.project

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

object ProjectList_solutionMaket extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="createTemplateProjectModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-fullscreen">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: inherit;">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("Solution Maketplace")),format.raw/*5.99*/("""</h5>
        <button type="button" class="btn-close text-white" onclick="cancleWizard()" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <h6 class="">"""),_display_(/*9.23*/Messages("Chúng tôi cung cấp nhiều giải pháp mẫu hoàn thiện và tiết kiệm chi phí giúp bạn nhanh chóng xây dựng các ứng dụng thông minh.")),format.raw/*9.160*/("""</h6>

        <ul class="nav nav-tabs mt-3" role="tablist">
          <li class="nav-item" role="presentation">
            <a class="nav-link active" data-bs-toggle="tab" href="#tabSolutionAll" role="tab" aria-selected="true">
              <div class="d-flex align-items-center">
                """),format.raw/*15.82*/("""
                """),format.raw/*16.27*/("""
                """),format.raw/*17.17*/("""<div class="tab-title">"""),_display_(/*17.41*/Messages("Tất cả")),format.raw/*17.59*/("""</div>
              </div>
            </a>
          </li>
        </ul>
        <div class="tab-content py-3">
          <div class="tab-pane fade show active" id="tabSolutionAll" role="tabpanel">
            <div class="col-md-12">

              <div class="row">
                <div class="col-md-3">
                  <div class="card">
                    <div class="alignItemCenter">
                      <img src=""""),_display_(/*30.34*/routes/*30.40*/.Assets.versioned("images/solution/SmartTracking.png")),format.raw/*30.94*/("""" width="100%" height="300">
                    </div>
                    <div class="text mt-3 p-3">
                      <div class="row">
                        <div class="col-md-6"><i class="bx bx-user"></i> """),_display_(/*34.75*/Messages("InnoWay")),format.raw/*34.94*/("""</div>
                        <div class="col-md-6"><i class="bx bx-calendar"></i> """),_display_(/*35.79*/Messages("01/06/2022")),format.raw/*35.101*/("""</div>
                      </div>
                      <h4 class="mt-3" style="font-weight: 500;">"""),_display_(/*37.67*/Messages("Giải pháp Fleet Management")),format.raw/*37.105*/("""</h4>
                      <p class="mt-3 contentSolution">
                      """),_display_(/*39.24*/Messages("Giải pháp quản lý đội xe giúp bạn quản lý hoạt động của đội xe, dẫn đến giảm chi phí, cải thiện hiệu quả và nâng cao tính tuân thủ. Giải pháp quản lý đội xe phù hợp có thể là công cụ trong việc điều phối các hoạt động quản lý đội xe của bạn.")),format.raw/*39.277*/("""
                      """),format.raw/*40.23*/("""<br>"""),_display_(/*40.28*/Messages("Chức năng chính:")),format.raw/*40.56*/("""
                      """),format.raw/*41.23*/("""<br>"""),_display_(/*41.28*/Messages("- Cảnh báo vùng an toàn qua SMS hoặc App Notification")),format.raw/*41.93*/("""
                      """),format.raw/*42.23*/("""<br>"""),_display_(/*42.28*/Messages("- Cảnh báo pin yếu qua SMS hoặc App Notification")),format.raw/*42.88*/("""
                      """),format.raw/*43.23*/("""<br>"""),_display_(/*43.28*/Messages("- Định vị được vị trí qua bản tin thiết bị bắn lên")),format.raw/*43.90*/("""
                      """),format.raw/*44.23*/("""</p>
                      <button class="btn btn-danger" data-bs-dismiss="modal" data-bs-toggle="modal" data-bs-target="#addFleetConfirm" id="buttonAddProjectFleet">"""),_display_(/*45.163*/Messages("Cài đặt")),format.raw/*45.182*/("""</button>
                    </div>
                  </div>
                </div>
                <div class="col-md-3">
                  <div class="card">
                    <div class="alignItemCenter">
                      <img src=""""),_display_(/*52.34*/routes/*52.40*/.Assets.versioned("images/solution/AssetManagement.png")),format.raw/*52.96*/("""" width="100%" height="300">
                    </div>
                    <div class="text mt-3 p-3">
                      <div class="row">
                        <div class="col-md-6"><i class="bx bx-user"></i> """),_display_(/*56.75*/Messages("InnoWay")),format.raw/*56.94*/("""</div>
                        <div class="col-md-6"><i class="bx bx-calendar"></i> """),_display_(/*57.79*/Messages("01/06/2022")),format.raw/*57.101*/("""</div>
                      </div>
                      <h4 class="mt-3" style="font-weight: 500;">"""),_display_(/*59.67*/Messages("Giải pháp Asset Management")),format.raw/*59.105*/("""</h4>
                      <p class="mt-3 contentSolution">
                      """),_display_(/*61.24*/Messages("Giải pháp quản lý tài sản giúp bạn theo dõi tài sản thông qua việc sử dụng các thẻ RFID được gắn vào chúng. Các thẻ được đọc bằng máy quét cố định được gắn ở vị trí cố đinh. Mỗi khi một thẻ được đọc, nó sẽ được lưu tổng hợp thành một chuỗi và bán tổng tất cả các RFID đã quét được lên hệ thống. Bên cạnh đó, giải pháp còn cảnh báo cho bạn những RFID bị thiếu hoặc RFID lạ để giúp bạn tránh bị thiếu sót tài sản")),format.raw/*61.446*/("""
                      """),format.raw/*62.23*/("""<br>"""),_display_(/*62.28*/Messages("Chức năng chính:")),format.raw/*62.56*/("""
                      """),format.raw/*63.23*/("""<br>"""),_display_(/*63.28*/Messages("- Cảnh báo RFID bị thiếu, RFID lạ qua SMS hoặc App Notification")),format.raw/*63.103*/("""
                      """),format.raw/*64.23*/("""<br>"""),_display_(/*64.28*/Messages("- Xử lý tập bản tin thiết bị gửi lên (gộp bản tin, kiểm tra trùng)")),format.raw/*64.106*/("""
                      """),format.raw/*65.23*/("""<br>"""),_display_(/*65.28*/Messages("- Đăng ký RFID mới theo danh sách hoặc chỉnh sửa số lượng nhỏ")),format.raw/*65.101*/("""
                      """),format.raw/*66.23*/("""</p>
                      <button class="btn btn-danger" data-bs-dismiss="modal" data-bs-toggle="modal" data-bs-target="#addAssetConfirm" id="buttonAddProjectAsset">"""),_display_(/*67.163*/Messages("Cài đặt")),format.raw/*67.182*/("""</button>
                    </div>
                  </div>
                </div>
                <div class="col-md-3">
                  <div class="card">
                    <div class="alignItemCenter">
                      <img src=""""),_display_(/*74.34*/routes/*74.40*/.Assets.versioned("images/solution/SmartMetering.png")),format.raw/*74.94*/("""" width="100%" height="300">
                    </div>
                    <div class="text mt-3 p-3">
                      <div class="row">
                        <div class="col-md-6"><i class="bx bx-user"></i> """),_display_(/*78.75*/Messages("InnoWay")),format.raw/*78.94*/("""</div>
                        <div class="col-md-6"><i class="bx bx-calendar"></i> """),_display_(/*79.79*/Messages("01/06/2022")),format.raw/*79.101*/("""</div>
                      </div>
                      <h4 class="mt-3" style="font-weight: 500;">"""),_display_(/*81.67*/Messages("Giải pháp Smart Water Meter")),format.raw/*81.106*/("""</h4>
                      <p class="mt-3 contentSolution">
                      """),_display_(/*83.24*/Messages("Giải pháp đồng hồ nước thông mình giúp bạn theo dõi lưu lượng sử dụng, cảnh bảo về các vấn đề liên quan đến đường dẫn nước trong nhà bạn, dẫn đến giảm chi phí, giải thiếu các rủi ro. Giải pháp đồng hồ nước thông minh cung cấp hệ thông đo lường từ xa và tổng hợp lại số lượng đã sử dụng mà không cần đội ngũ đến kiểm tra. ")),format.raw/*83.357*/("""
                      """),format.raw/*84.23*/("""<br>"""),_display_(/*84.28*/Messages("Chức năng chính:")),format.raw/*84.56*/("""
                      """),format.raw/*85.23*/("""<br>"""),_display_(/*85.28*/Messages("- Đo lượng tổng lượng nước tiêu thụ ")),format.raw/*85.76*/("""
                      """),format.raw/*86.23*/("""<br>"""),_display_(/*86.28*/Messages("- Cảnh báo về sự cố đường nước qua SMS hoặc App notification")),format.raw/*86.100*/("""
                      """),format.raw/*87.23*/("""<br>"""),_display_(/*87.28*/Messages("- Đo tốc độ dòng chảy của nước")),format.raw/*87.70*/("""
                      """),format.raw/*88.23*/("""</p>
                      <button class="btn btn-danger" data-bs-dismiss="modal" data-bs-toggle="modal" data-bs-target="#addSmartWaterConfirm" id="buttonAddProjectSmartWater">"""),_display_(/*89.173*/Messages("Cài đặt")),format.raw/*89.192*/("""</button>
                    </div>
                  </div>
                </div>
                <div class="col-md-3">
                  <div class="card">
                    <div class="alignItemCenter">
                      <img src=""""),_display_(/*96.34*/routes/*96.40*/.Assets.versioned("images/solution/SmartFarming.png")),format.raw/*96.93*/("""" width="100%" height="300">
                    </div>
                    <div class="text mt-3 p-3">
                      <div class="row">
                        <div class="col-md-6"><i class="bx bx-user"></i> """),_display_(/*100.75*/Messages("InnoWay")),format.raw/*100.94*/("""</div>
                        <div class="col-md-6"><i class="bx bx-calendar"></i> """),_display_(/*101.79*/Messages("01/06/2022")),format.raw/*101.101*/("""</div>
                      </div>
                      <h4 class="mt-3" style="font-weight: 500;">"""),_display_(/*103.67*/Messages("Giải pháp Smart Farm")),format.raw/*103.99*/("""</h4>
                      <p class="mt-3 contentSolution">
                      """),_display_(/*105.24*/Messages("Giải pháp nông nghiệp thông minh giúp bạn theo dõi lưu lượng sử dụng, cảnh báo về các vấn đề liên quan độ ẩm cho vườn cây nhà bạn, giảm thiếu các rủi ro.")),format.raw/*105.189*/("""
                      """),format.raw/*106.23*/("""<br>"""),_display_(/*106.28*/Messages("Chức năng chính:")),format.raw/*106.56*/("""
                      """),format.raw/*107.23*/("""<br>"""),_display_(/*107.28*/Messages("- Do độ ẩm hiện tại để bật/tắt máy bơm nước")),format.raw/*107.83*/("""
                      """),format.raw/*108.23*/("""<br>"""),_display_(/*108.28*/Messages("- Do tổng lượng nước đã tiêu thụ")),format.raw/*108.72*/("""
                      """),format.raw/*109.23*/("""</p>
                      <button class="btn btn-danger" data-bs-dismiss="modal" data-bs-toggle="modal" data-bs-target="#addSmartFarmConfirm" id="buttonAddProjectSmartFarm">"""),_display_(/*110.171*/Messages("Cài đặt")),format.raw/*110.190*/("""</button>
                    </div>
                  </div>
                </div>

                <div class="col-md-3">
                  <div class="card">
                    <div class="alignItemCenter">
                      <img src=""""),_display_(/*118.34*/routes/*118.40*/.Assets.versioned("images/solution/SmartHome.png")),format.raw/*118.90*/("""" width="100%" height="300">
                    </div>
                    <div class="text mt-3 p-3">
                      <div class="row">
                        <div class="col-md-6"><i class="bx bx-user"></i> """),_display_(/*122.75*/Messages("InnoWay")),format.raw/*122.94*/("""</div>
                        <div class="col-md-6"><i class="bx bx-calendar"></i> """),_display_(/*123.79*/Messages("01/06/2022")),format.raw/*123.101*/("""</div>
                      </div>
                      <h4 class="mt-3" style="font-weight: 500;">"""),_display_(/*125.67*/Messages("Giải pháp Smarthome")),format.raw/*125.98*/("""</h4>
                      <p class="mt-3 contentSolution">
                      """),_display_(/*127.24*/Messages("Giải pháp hỗ trợ các ngữ cảnh thông minh được đặt theo giờ hoặc theo ngoại cảnh để người sử dụng có trải nghiệm và sức khỏe tinh thần tốt nhất trong căn nhà ")),format.raw/*127.193*/("""
                      """),format.raw/*128.23*/("""</p>
                      <button class="btn btn-danger" data-bs-dismiss="modal" data-bs-toggle="modal" data-bs-target="#addSmartHomeConfirm" id="buttonAddProjectSmartHome">"""),_display_(/*129.171*/Messages("Cài đặt")),format.raw/*129.190*/("""</button>
                    </div>
                  </div>
                </div>

                <div class="col-md-3">
                  <div class="card">
                    <div class="alignItemCenter">
                      <img src=""""),_display_(/*137.34*/routes/*137.40*/.Assets.versioned("images/project/vtag.png")),format.raw/*137.84*/("""" width="100%" height="300">
                    </div>
                    <div class="text mt-3 p-3">
                      <div class="row">
                        <div class="col-md-6"><i class="bx bx-user"></i> """),_display_(/*141.75*/Messages("InnoWay")),format.raw/*141.94*/("""</div>
                        <div class="col-md-6"><i class="bx bx-calendar"></i> """),_display_(/*142.79*/Messages("01/06/2022")),format.raw/*142.101*/("""</div>
                      </div>
                      <h4 class="mt-3" style="font-weight: 500;">"""),_display_(/*144.67*/Messages("Giải pháp Định vị thông minh")),format.raw/*144.107*/("""</h4>
                      <p class="mt-3 contentSolution">
                      """),_display_(/*146.24*/Messages("Giải pháp hỗ trợ các ngữ cảnh thông minh được đặt theo giờ hoặc theo ngoại cảnh để người sử dụng có trải nghiệm và sức khỏe tinh thần tốt nhất trong căn nhà ")),format.raw/*146.193*/("""
                      """),format.raw/*147.23*/("""</p>
                      <button class="btn btn-info" onclick="" id="" disabled style="color: white">"""),_display_(/*148.100*/Messages("Đang phát triển")),format.raw/*148.127*/("""</button>
                    </div>
                  </div>
                </div>


              </div>

            </div>
          </div>
        </div>

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
                  DATE: Mon Sep 22 16:32:46 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/project/ProjectList_solutionMaket.scala.html
                  HASH: 0a75fc373a77a9470dbb85cc409319d09452459f
                  MATRIX: 1062->0|1477->389|1528->420|1739->605|1897->742|2224->1106|2269->1133|2314->1150|2365->1174|2404->1192|2859->1620|2874->1626|2949->1680|3194->1898|3234->1917|3346->2002|3390->2024|3519->2126|3579->2164|3690->2248|3965->2501|4016->2524|4048->2529|4097->2557|4148->2580|4180->2585|4266->2650|4317->2673|4349->2678|4430->2738|4481->2761|4513->2766|4596->2828|4647->2851|4842->3018|4883->3037|5154->3281|5169->3287|5246->3343|5491->3561|5531->3580|5643->3665|5687->3687|5816->3789|5876->3827|5987->3911|6431->4333|6482->4356|6514->4361|6563->4389|6614->4412|6646->4417|6743->4492|6794->4515|6826->4520|6926->4598|6977->4621|7009->4626|7104->4699|7155->4722|7350->4889|7391->4908|7662->5152|7677->5158|7752->5212|7997->5430|8037->5449|8149->5534|8193->5556|8322->5658|8383->5697|8494->5781|8849->6114|8900->6137|8932->6142|8981->6170|9032->6193|9064->6198|9133->6246|9184->6269|9216->6274|9310->6346|9361->6369|9393->6374|9456->6416|9507->6439|9712->6616|9753->6635|10024->6879|10039->6885|10113->6938|10359->7156|10400->7175|10513->7260|10558->7282|10688->7384|10742->7416|10854->7500|11042->7665|11094->7688|11127->7693|11177->7721|11229->7744|11262->7749|11339->7804|11391->7827|11424->7832|11490->7876|11542->7899|11746->8074|11788->8093|12061->8338|12077->8344|12149->8394|12395->8612|12436->8631|12549->8716|12594->8738|12724->8840|12777->8871|12889->8955|13081->9124|13133->9147|13337->9322|13379->9341|13652->9586|13668->9592|13734->9636|13980->9854|14021->9873|14134->9958|14179->9980|14309->10082|14372->10122|14484->10206|14676->10375|14728->10398|14861->10502|14911->10529
                  LINES: 33->1|37->5|37->5|41->9|41->9|47->15|48->16|49->17|49->17|49->17|62->30|62->30|62->30|66->34|66->34|67->35|67->35|69->37|69->37|71->39|71->39|72->40|72->40|72->40|73->41|73->41|73->41|74->42|74->42|74->42|75->43|75->43|75->43|76->44|77->45|77->45|84->52|84->52|84->52|88->56|88->56|89->57|89->57|91->59|91->59|93->61|93->61|94->62|94->62|94->62|95->63|95->63|95->63|96->64|96->64|96->64|97->65|97->65|97->65|98->66|99->67|99->67|106->74|106->74|106->74|110->78|110->78|111->79|111->79|113->81|113->81|115->83|115->83|116->84|116->84|116->84|117->85|117->85|117->85|118->86|118->86|118->86|119->87|119->87|119->87|120->88|121->89|121->89|128->96|128->96|128->96|132->100|132->100|133->101|133->101|135->103|135->103|137->105|137->105|138->106|138->106|138->106|139->107|139->107|139->107|140->108|140->108|140->108|141->109|142->110|142->110|150->118|150->118|150->118|154->122|154->122|155->123|155->123|157->125|157->125|159->127|159->127|160->128|161->129|161->129|169->137|169->137|169->137|173->141|173->141|174->142|174->142|176->144|176->144|178->146|178->146|179->147|180->148|180->148
                  -- GENERATED --
              */
          