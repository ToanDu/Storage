
package views.html.telco

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

object TermOfUse extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*6.13*/Messages("Điều khoản sử dụng")),format.raw/*6.43*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*7.46*/routes/*7.52*/.Assets.versioned("images/logo.jpg")),format.raw/*7.88*/("""">
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <link href=""""),_display_(/*11.18*/routes/*11.24*/.Assets.versioned("stylesheets/landingPage/argon-design-system.css?v=1.2.2")),format.raw/*11.100*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*12.18*/routes/*12.24*/.Assets.versioned("assets/plugins/notifications/css/lobibox.min.css")),format.raw/*12.93*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*13.18*/routes/*13.24*/.Assets.versioned("assets/css/icons.css")),format.raw/*13.65*/("""" rel="stylesheet">

    <link href=""""),_display_(/*15.18*/routes/*15.24*/.Assets.versioned("stylesheets/views/telco/account/account.css")),format.raw/*15.88*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*16.18*/routes/*16.24*/.Assets.versioned("stylesheets/views/telco/telco2.css")),format.raw/*16.79*/("""" rel="stylesheet" />

  </head>

  <body class="landing-page">

    <div class="wrapper">

      <div class="section features-1">
        <div class="container">
          <h1 style="text-align: center;">"""),_display_(/*26.44*/Messages("ĐIỀU KHOẢN SỬ DỤNG")),format.raw/*26.74*/("""</h1>
        </div>
      </div>

      <div class="section features-1">
        <div class="container-1">
          <h3>"""),_display_(/*32.16*/Messages("PHẦN 1: ĐIỀU KHOẢN VÀ ĐIỀU KIỆN GIAO DỊCH")),format.raw/*32.69*/("""</h3>
          <strong>"""),_display_(/*33.20*/Messages("Phạm vi áp dụng")),format.raw/*33.47*/("""</strong>
          <label>"""),_display_(/*34.19*/Messages("Cá nhân có năng lực hành vi dân sự theo quy định pháp luật và có tài sản để thực hiện giao dịch mua Sản Phẩm trên Sàn giao dịch TMĐT Viettel.vn/My Viettel, trừ giao dịch mua các Sản Phẩm phải đăng ký hoặc sản phẩm khác theo quy định của pháp luật phải được người đại diện theo pháp luật đồng ý.")),format.raw/*34.325*/("""</label>
          <label>"""),_display_(/*35.19*/Messages("Mọi tổ chức được thành lập và hoạt động hợp pháp theo quy định của Pháp luật Việt Nam.")),format.raw/*35.118*/("""</label>
          <label>"""),_display_(/*36.19*/Messages("Cá nhân/ Tổ chức (sau đây gọi là “Người sử dụng”, “Người mua”, “Người bán/Nhà cung cấp dịch vụ/Đối tác”) có thể mua/bán/sử dụng sản phẩm dịch vụ như: Gói cước, Truyền hình, Điện thoại, sản phẩm về công nghệ thông tin và viễn thông, thời trang, du lịch, nội/ngoại thất, cơ khí điện tử, vé máy bay, các sản phẩm Digital Marketing, các sản phẩm TMĐT đến từ Shopee, Tiki, Lazada …")),format.raw/*36.407*/("""</label>
          <label>"""),_display_(/*37.19*/Messages("Cá nhân/ Tổ chức có nhu cầu được giao Sản Phẩm đến các địa điểm phù hợp với Chính sách giao hàng của Viettel.")),format.raw/*37.140*/("""</label>
          <hr>

          <strong>"""),_display_(/*40.20*/Messages("Các bước dành cho người mua, người sử dụng dịch vụ trên Viettel.vn/ My Viettel")),format.raw/*40.110*/("""</strong>
          <label><strong>"""),_display_(/*41.27*/Messages("Bước 1: ")),format.raw/*41.47*/("""</strong>"""),_display_(/*41.57*/Messages("Sau khi đăng nhập https://viettel.vn, người sử dụng cần Đăng ký tài khoản, click “Đăng ký”")),format.raw/*41.159*/("""</label><br>
          <label><strong>"""),_display_(/*42.27*/Messages("Bước 2: ")),format.raw/*42.47*/("""</strong>"""),_display_(/*42.57*/Messages("Sau khi đăng ký thành công, click “Đăng nhập”")),format.raw/*42.114*/("""</label><br>
          <label><strong>"""),_display_(/*43.27*/Messages("Bước 3: ")),format.raw/*43.47*/("""</strong>"""),_display_(/*43.57*/Messages("Đăng nhập thành công, người dùng sẽ nhìn thấy trang chủ có các nội dung sản phẩm, dịch vụ nổi bật và đồng thời góc phải màn hình sẽ hiện thông tin của người sử dụng dịch vụ")),format.raw/*43.241*/("""</label><br>
          <label><strong>"""),_display_(/*44.27*/Messages("Bước 4: ")),format.raw/*44.47*/("""</strong>"""),_display_(/*44.57*/Messages("Người dùng đã có thể tìm kiếm thông tin sản phẩm/dịch vụ theo nhu cầu trên Viettel Shop hoặc Viettel Mall")),format.raw/*44.174*/("""</label><br>
          <hr>

          <strong>"""),_display_(/*47.20*/Messages("Viettel Shop:")),format.raw/*47.45*/("""</strong><br>
          <strong>"""),_display_(/*48.20*/Messages("Mua gói dịch vụ viễn thông: ")),format.raw/*48.60*/("""</strong><br>
          <label>"""),_display_(/*49.19*/Messages("Người sử dụng dịch vụ chỉ cần chọn sản phẩm => Click “Đăng ký” hoặc “Mua ngay” => Đồng ý thanh toán bằng tài khoản chính trong số dư của tài khoản viễn thông, hoặc thanh toán bằng Viettel pay/Thẻ nội địa/Thẻ Quốc tế => Click “Xác nhận” để hoàn tất quá trình mua sản phẩm/dịch vụ.")),format.raw/*49.310*/("""</label>
          <strong>"""),_display_(/*50.20*/Messages("Mua sản phẩm: ")),format.raw/*50.46*/("""</strong><br>
          <label>"""),_display_(/*51.19*/Messages("Người mua chọn sản phẩm theo nhu cầu => Click “Mua ngay” => Hệ thống sẽ hiển thị chi tiết sản phẩm => Click “Tiếp tục”")),format.raw/*51.149*/("""</label>
          <label>"""),_display_(/*52.19*/Messages("Sau khi người mua điền đầy đủ thông tin ở phần “Thông tin đơn hàng”, Người mua bấm vào “Tôi đồng ý với điều khoản mua hàng” để xác nhận đơn hàng và đồng ý với các điều khoản quy định về mua hàng của Viettel. Sau khi xác nhận đơn hàng, Người mua bấm “Thanh toán” để hoàn thành quy trình mua hàng.")),format.raw/*52.326*/("""</label>
          <label>"""),_display_(/*53.19*/Messages("Người mua sẽ thanh toán cho nhà cung cấp khi nhân viên giao hàng chuyển giao sản phẩm cho Người mua tại địa chỉ đã đăng ký hoặc thanh toán bằng hình thức tài khoản thẻ tùy vào lựa chọn của Người mua khi đăng ký thông tin mua hàng.")),format.raw/*53.261*/("""</label>
          <hr>

          <strong>"""),_display_(/*56.20*/Messages("Viettel Mall:")),format.raw/*56.45*/("""</strong><br>
          <strong>"""),_display_(/*57.20*/Messages("Trường hợp Affiliate với các sàn Shopee, Tiki: ")),format.raw/*57.79*/("""</strong><br>
          <label>"""),_display_(/*58.19*/Messages("Khi truy cập thành công https://viettel.vn, người mua, người sử dụng dịch vụ không cần phải đăng ký hoặc đăng nhập => Click “Viettel Mall” => Tìm kiếm sản phẩm mong muốn")),format.raw/*58.200*/("""</label>
          <label>"""),_display_(/*59.19*/Messages("Click sản phẩm muốn mua để xem chi tiết sản phẩm")),format.raw/*59.79*/("""</label>
          <label>"""),_display_(/*60.19*/Messages("Hệ thống sẽ hiển thị nút “Mua ngay trên Shopee/Tiki” => Click “Mua ngay” => Hệ thống tự động chuyển sang trang Shopee/Tiki để người mua, người sử dụng dịch vụ bắt đầu quá trình mua hàng:")),format.raw/*60.217*/("""</label>
          <strong>"""),_display_(/*61.20*/Messages("Trường hợp mua hàng trực tiếp sản phẩm Dịch vụ số ngoài viễn thông do Viettel phân phối:")),format.raw/*61.120*/("""</strong><br>
          <label>"""),_display_(/*62.19*/Messages("Khi truy cập thành công https://viettel.vn, người mua, người sử dụng dịch vụ không cần phải đăng ký hoặc đăng nhập => Click “Viettel Mall” => Tìm kiếm sản phẩm mong muốn")),format.raw/*62.200*/("""</label>
          <label>"""),_display_(/*63.19*/Messages("Click sản phẩm muốn mua để xem chi tiết sản phẩm")),format.raw/*63.79*/("""</label>
          <label>"""),_display_(/*64.19*/Messages("Hệ thống sẽ hiển thị nút “Mua ngaytrên Shopee/Tiki”hoặc chuyển sang web/app của Shopee/Tiki => Khách hàng thực hiện mua sản phẩm trên Shopee/Tiki.")),format.raw/*64.177*/("""</label>
          <hr>

          <strong>"""),_display_(/*67.20*/Messages("Các bước dành cho người bán/nhà cung cấp dịch vụ/Đối tác trên Viettel.vn/ My Viettel")),format.raw/*67.116*/("""</strong><br>
          <label>"""),_display_(/*68.19*/Messages("Thương nhân, tổ chức, cá nhân có nhu cầu đăng tin rao bán, rao mua, cho thuê sản phẩm dịch vụ của mình lên website https://seller.viettel.vn tiến hành các bước như sau:")),format.raw/*68.201*/("""</label>
          <label><strong>"""),_display_(/*69.27*/Messages("Bước 1: ")),format.raw/*69.47*/("""</strong>"""),_display_(/*69.57*/Messages("Truy cập website https://seller.viettel.vnhoặc click vào icon Viettel Mall trên website https://viettel.vn")),format.raw/*69.175*/("""</label><br>
          <label><strong>"""),_display_(/*70.27*/Messages("Bước 2: ")),format.raw/*70.47*/("""</strong>"""),_display_(/*70.57*/Messages("Nhấn vào nút Đăng ký.")),format.raw/*70.90*/("""</label><br>
          <label><strong>"""),_display_(/*71.27*/Messages("Bước 3: ")),format.raw/*71.47*/("""</strong>"""),_display_(/*71.57*/Messages("Cá nhân/tổ chức nhập các thông tin để đăng ký tài khoản người bán trên sàn TMĐT Viettel. Sau khi đăng ký thành công, cá nhân/tổ chức đăng nhập vào Kênh người bán")),format.raw/*71.230*/("""</label><br>
          <label><strong>"""),_display_(/*72.27*/Messages("Bước 4: ")),format.raw/*72.47*/("""</strong>"""),_display_(/*72.57*/Messages("Cá nhân/tổ chức truy cập vào tính năng Quản lý sản phẩm để xem danh sách sản phẩm của mình.")),format.raw/*72.160*/("""</label><br>
          <label><strong>"""),_display_(/*73.27*/Messages("Bước 5: ")),format.raw/*73.47*/("""</strong>"""),_display_(/*73.57*/Messages("Cá nhân/tổ chức bấm hình dấu cộng (được khoanh đỏ trong hình trên) để mở ra màn hình Thêm mới sản phẩm.")),format.raw/*73.172*/("""</label><br>
          <label><strong>"""),_display_(/*74.27*/Messages("Bước 6: ")),format.raw/*74.47*/("""</strong>"""),_display_(/*74.57*/Messages("Người bán thực hiện nhập các thông tin chi tiết sản phẩm của mình lên sàn và nhấn nút Thêm mới")),format.raw/*74.163*/("""</label><br>
          <label><strong>"""),_display_(/*75.27*/Messages("Bước 7: ")),format.raw/*75.47*/("""</strong>"""),_display_(/*75.57*/Messages("Sau khi thêm mới xong, trên giao diện Quản lý sản phẩm sẽ hiển thị sản phẩm ở trạng thái chờ duyệt.")),format.raw/*75.168*/("""</label><br>
          <label><strong>"""),_display_(/*76.27*/Messages("Bước 8: ")),format.raw/*76.47*/("""</strong>"""),_display_(/*76.57*/Messages("Sản phẩm sau khi đưa lên sẽ được hệ thống phê duyệt rồi mới được lựa chọn để đăng bán trên sàn TMĐT của Viettel. Người bán có thể chọn lựa sản phẩm nào đưa lên hoặc bỏ đăng bán trên sàn. Với những sản phẩm không được phê duyệt thì hệ thống sẽ hiển thị thông báo “không đủ điều kiện” và không cho phép đăng bán trên My Viettel.")),format.raw/*76.395*/("""</label><br>
          <label><strong>"""),_display_(/*77.27*/Messages("Bước 9: ")),format.raw/*77.47*/("""</strong>"""),_display_(/*77.57*/Messages("Sau khi người bán đăng bán thành công, Người mua hàng có thể mua hàng tại website viettel.vn")),format.raw/*77.161*/("""</label><br>



        </div>
      </div>

      """),_display_(/*84.8*/views/*84.13*/.html.telco.Footer()),format.raw/*84.33*/("""
    """),format.raw/*85.5*/("""</div>
  </body>
  <script type="text/javascript" src=""""),_display_(/*87.40*/routes/*87.46*/.JsController.jsMessages()),format.raw/*87.72*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*88.40*/routes/*88.46*/.JsController.javascriptRoutes),format.raw/*88.76*/(""""></script>
  <script src=""""),_display_(/*89.17*/routes/*89.23*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*89.77*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*91.17*/routes/*91.23*/.Assets.versioned("javascripts/landingPage/jquery.min.js")),format.raw/*91.81*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*92.17*/routes/*92.23*/.Assets.versioned("javascripts/landingPage/popper.min.js")),format.raw/*92.81*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*93.17*/routes/*93.23*/.Assets.versioned("javascripts/landingPage/bootstrap.min.js")),format.raw/*93.84*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*94.17*/routes/*94.23*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*94.77*/(""""></script>
  <script src=""""),_display_(/*95.17*/routes/*95.23*/.Assets.versioned("javascripts/landingPage/argon-design-system.js?v=1.2.2")),format.raw/*95.98*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*97.17*/routes/*97.23*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*97.90*/(""""></script>
  <script src=""""),_display_(/*98.17*/routes/*98.23*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*98.96*/(""""></script>
  <script src=""""),_display_(/*99.17*/routes/*99.23*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*99.105*/(""""></script>
  <script src=""""),_display_(/*100.17*/routes/*100.23*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*100.75*/("""" type="text/javascript"></script>

  """),_display_(/*102.4*/views/*102.9*/.html.BackToTop()),format.raw/*102.26*/("""

"""),format.raw/*104.1*/("""</html>"""))
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/TermOfUse.scala.html
                  HASH: b2623210a9f7e2a842c88680c43346079abec683
                  MATRIX: 1040->0|1216->150|1266->180|1346->234|1360->240|1416->276|1635->468|1650->474|1748->550|1814->589|1829->595|1919->664|1985->703|2000->709|2062->750|2127->788|2142->794|2227->858|2293->897|2308->903|2384->958|2617->1164|2668->1194|2818->1317|2892->1370|2944->1395|2992->1422|3047->1450|3375->1756|3429->1783|3550->1882|3604->1909|4014->2297|4068->2324|4211->2445|4282->2489|4394->2579|4457->2615|4498->2635|4535->2645|4659->2747|4725->2786|4766->2806|4803->2816|4882->2873|4948->2912|4989->2932|5026->2942|5232->3126|5298->3165|5339->3185|5376->3195|5515->3312|5590->3360|5636->3385|5696->3418|5757->3458|5816->3490|6129->3781|6184->3809|6231->3835|6290->3867|6442->3997|6496->4024|6825->4331|6879->4358|7143->4600|7214->4644|7260->4669|7320->4702|7400->4761|7459->4793|7662->4974|7716->5001|7797->5061|7851->5088|8071->5286|8126->5314|8248->5414|8307->5446|8510->5627|8564->5654|8645->5714|8699->5741|8879->5899|8950->5943|9068->6039|9127->6071|9331->6253|9393->6288|9434->6308|9471->6318|9611->6436|9677->6475|9718->6495|9755->6505|9809->6538|9875->6577|9916->6597|9953->6607|10148->6780|10214->6819|10255->6839|10292->6849|10417->6952|10483->6991|10524->7011|10561->7021|10698->7136|10764->7175|10805->7195|10842->7205|10970->7311|11036->7350|11077->7370|11114->7380|11247->7491|11313->7530|11354->7550|11391->7560|11751->7898|11817->7937|11858->7957|11895->7967|12021->8071|12099->8123|12113->8128|12154->8148|12186->8153|12269->8209|12284->8215|12331->8241|12409->8292|12424->8298|12475->8328|12530->8356|12545->8362|12620->8416|12699->8468|12714->8474|12793->8532|12871->8583|12886->8589|12965->8647|13043->8698|13058->8704|13140->8765|13218->8816|13233->8822|13308->8876|13363->8904|13378->8910|13474->8985|13553->9037|13568->9043|13656->9110|13711->9138|13726->9144|13820->9217|13875->9245|13890->9251|13994->9333|14050->9361|14066->9367|14140->9419|14206->9458|14220->9463|14259->9480|14289->9482
                  LINES: 33->1|38->6|38->6|39->7|39->7|39->7|43->11|43->11|43->11|44->12|44->12|44->12|45->13|45->13|45->13|47->15|47->15|47->15|48->16|48->16|48->16|58->26|58->26|64->32|64->32|65->33|65->33|66->34|66->34|67->35|67->35|68->36|68->36|69->37|69->37|72->40|72->40|73->41|73->41|73->41|73->41|74->42|74->42|74->42|74->42|75->43|75->43|75->43|75->43|76->44|76->44|76->44|76->44|79->47|79->47|80->48|80->48|81->49|81->49|82->50|82->50|83->51|83->51|84->52|84->52|85->53|85->53|88->56|88->56|89->57|89->57|90->58|90->58|91->59|91->59|92->60|92->60|93->61|93->61|94->62|94->62|95->63|95->63|96->64|96->64|99->67|99->67|100->68|100->68|101->69|101->69|101->69|101->69|102->70|102->70|102->70|102->70|103->71|103->71|103->71|103->71|104->72|104->72|104->72|104->72|105->73|105->73|105->73|105->73|106->74|106->74|106->74|106->74|107->75|107->75|107->75|107->75|108->76|108->76|108->76|108->76|109->77|109->77|109->77|109->77|116->84|116->84|116->84|117->85|119->87|119->87|119->87|120->88|120->88|120->88|121->89|121->89|121->89|123->91|123->91|123->91|124->92|124->92|124->92|125->93|125->93|125->93|126->94|126->94|126->94|127->95|127->95|127->95|129->97|129->97|129->97|130->98|130->98|130->98|131->99|131->99|131->99|132->100|132->100|132->100|134->102|134->102|134->102|136->104
                  -- GENERATED --
              */
          