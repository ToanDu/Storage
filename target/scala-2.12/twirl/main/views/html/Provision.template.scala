
package views.html

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

object Provision extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>"""),_display_(/*6.17*/Messages("Điều khoản sử dụng")),format.raw/*6.47*/("""</title>
        <link rel="icon" type="image/png" href=""""),_display_(/*7.50*/routes/*7.56*/.Assets.versioned("images/logo.jpg")),format.raw/*7.92*/("""">

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        """),_display_(/*12.10*/views/*12.15*/.html.iot.tags.Main_css()),format.raw/*12.40*/("""

        """),format.raw/*14.9*/("""<style>
            .title-provision """),format.raw/*15.30*/("""{"""),format.raw/*15.31*/("""
                """),format.raw/*16.17*/("""display: flex;
                background-color: #ed1b2f;
                height: 200px;
                color: white;
                text-align: center;
                justify-content: center;
                align-items: center;
                font-size: 35px;
                font-weight: bold;
            """),format.raw/*25.13*/("""}"""),format.raw/*25.14*/("""
            """),format.raw/*26.13*/(""".heading1 """),format.raw/*26.23*/("""{"""),format.raw/*26.24*/("""
                """),format.raw/*27.17*/("""color: #000000;
                font-size: 25px;
                font-weight: bold;
                padding-bottom: 10px;
                pading-top: 15px;
            """),format.raw/*32.13*/("""}"""),format.raw/*32.14*/("""
            """),format.raw/*33.13*/(""".heading2 """),format.raw/*33.23*/("""{"""),format.raw/*33.24*/("""
                """),format.raw/*34.17*/("""color: #000000;
                font-size: 18px;
                padding-bottom: 15px;
                padding-top: 15px;
                font-weight: bold;
            """),format.raw/*39.13*/("""}"""),format.raw/*39.14*/("""
            """),format.raw/*40.13*/(""".content """),format.raw/*40.22*/("""{"""),format.raw/*40.23*/("""
                """),format.raw/*41.17*/("""text-align: justify;
                text-justify: inter-word;
            """),format.raw/*43.13*/("""}"""),format.raw/*43.14*/("""
        """),format.raw/*44.9*/("""</style>
    </head>
    <body>
        <div class="provision">
            <div class="provision-main">
                <div class="space-top">Viettel High Technology Industries Corporation</div>
                <div class = "title-provision">
                    ĐIỀU KHOẢN SỬ DỤNG
                </div>
                <div class="card">
                    <div class="card-body" style="padding: 50px;">
                        <div class="heading1">I. Điều khoản chung</div>

                        <div class="heading2">1. Định nghĩa</div>
                        <div class="content">
                            <ul>
                                <li>
                            Giải pháp an ninh căn hộ: Là sản phẩm được phát triển và cung cấp bởi Tổng Công ty Công nghiệp Công nghệ cao Viettel,
                                    trực thuộc Tập đoàn Công nghiệp – Viễn thông Quân đội. Sản phẩm cung cấp giải pháp giám sát và kiểm soát an ninh cho căn hộ thông qua các tính năng:
                                    nhận diện khuôn mặt thành viên trong gia đình, phát hiện, cảnh báo hành vi xâm nhập vào căn hộ hoặc khu vực nguy hiểm,
                                    tùy biến ngữ cảnh sử dụng theo nhu cầu của chủ căn hộ.
                                </li>
                                <li>
                            Sản phẩm bao gồm: Các camera IP để thu thập hình ảnh kết nối với thiết bị Home AI Hub.
                                    Home AI Hub có nhiệm vụ xử lý các thuật toán AI từ các hình ảnh thu được từ camera. Các thông báo về nhận diện khuôn mặt và hành vi xâm nhập sẽ được gửi
                                    đến người dùng thông qua ứng dụng VIETTEL HOME được cài đặt trên điện thoại. Ngoài ra người dùng còn có thể xem lại lịch sử, xem trực tiếp các sự kiện
                                    đang diễn ra tại căn hộ thông qua ứng dụng.
                                </li>
                                <li>
                            Người dùng: Là tất cả các cá nhân và tổ chức có nhu cầu sử dụng sản phẩm
                                    Giải pháp an ninh căn hộ bao gồm bộ thiết bị và ứng dụng VIETTEL HOME.
                                </li>
                            </ul>
                        </div>

                        <div class="heading2">2. Cập nhật</div>
                        <div class="content">
                    Quy định này có thể được cập nhật thường xuyên, phiên bản cập nhật sẽ được
                            thông báo đến Người dùng trên ứng dụng. Phiên bản cập nhật này sẽ thay thế cho các quy định và điều kiện trong thỏa thuận ban đầu.
                        </div>

                        <div class="heading2">3. Quyền sở hữu sản phẩm</div>
                        <div class="content">
                    Sản phẩm Giải pháp an nình căn hộ được phát triển và quản lý trực tiếp bởi Tổng công ty công nghiệp công nghệ cao Viettel (“VHT”) và thuộc quyền sở hữu của Công
                            ty mẹ - Tập đoàn Công nghiệp – Viễn thông Quân đội. Tất cả các quyền sở hữu trí tuệ liên quan đến ứng dụng và các hướng dẫn liên quan cũng sẽ thuộc quyền sở hữu
                            duy nhất của Công ty mẹ - Tập đoàn Công nghiệp – Viễn thông Quân đội. Do vậy, không có bất kỳ cá nhân, doanh nghiệp, đơn vị, tổ chức nào được phép sao chép,
                            phân phối hoặc bằng bất kỳ hành vi nào khác xâm phạm tới quyền sở hữu trí tuệ của chủ sở hữu nếu không có sự đồng ý và cho phép của VHT và Công ty mẹ
                            - Tập đoàn Công nghiệp – Viễn thông Quân đội Viettel.
                        </div>

                        <div class="heading2">4. Tài khoản ứng dụng</div>
                        <div class="content">
                    Khi sử dụng sản phẩm Giải pháp an ninh căn hộ, Người dùng cần thực hiện
                            cài đặt ứng dụng VIETTEL HOME và tạo tài khoản theo yêu cầu cầu của VHT (ví dụ: số điện thoại, email, mật khẩu, một số thông tin khác được gọi chung là “Thông tin tài khoản”).
                            Người dùng phải đảm bảo thông tin cung cấp cho VHT là đúng và chính xác. Các quyền lợi và nghĩa vụ căn cứ trên thông tin tài khoản Người dùng đã đăng ký. Do đó, nếu có bất kỳ thông tin
                            nào sai lệch, VHT sẽ không chịu trách nhiệm khi thông tin đó ảnh hưởng hoặc hạn chế quyền lợi của Người dùng.
                        </div>

                        <div class="heading2">5. Quyền truy cập và sử dụng thông tin</div>
                        <div class="content">
                    Khi sử dụng sản phẩm, Người dùng thừa nhận rằng chúng tôi có quyền thu thập và sử dụng các thông tin sau:
                            <ul>
                                <li>Thu thập các thông tin Người dùng cung cấp để xác nhận tài khoản: tên, số điện thoại, giới tính, hình ảnh, ...</li>
                                <li>Thu thập các thông tin về cấu hình điện thoại, thông tin về phiên bản ứng dụng VIETTEL HOME đang sử dụng trên điện thoại của Người dùng.</li>
                                <li>Các dữ liệu hình ảnh, khuôn mặt thu thập được từ IP Camera</li>
                            </ul>
                            Chúng tôi cam kết không sử dụng bất kỳ biện pháp nào để theo dõi nội
                            dung video, trao đổi hoặc hình thức theo dõi khác nhằm theo dõi Người dùng khi sử dụng thiết bị và ứng dụng VIETTEL HOME.

                        </div>

                        <div class="heading2">6. Cam kết bảo mật thông tin</div>
                        <div class="content">
                            <ul>
                                <li>VHT cam kết bảo mật tuyệt đối các thông tin cá nhân của người dùng theo chính sách bảo vệ thông tin cá nhân của VHT, phù hợp với quy định của Luật Bảo vệ quyền lợi người tiêu dùng.
                                    VHT cam kết không sử dụng, không chuyển giao, cung cấp hay tiết lộ cho bên thứ ba nào về thông tin cá nhân của Người dùng khi không có sự cho phép đồng ý từ Người dùng, trừ trường hợp
                                    cung cấp với mục đích chăm sóc và hỗ trợ dịch vụ khách hàng và cung cấp cho cơ quan chức năng có thẩm quyền khi được yêu cầu.</li>
                                <li>Trong trường hợp máy chủ lưu trữ thông tin bị hacker tấn công dẫn đến mất mát dữ liệu cá nhân người dùng, VHT sẽ có trách nhiệm thông báo vụ việc cho cơ quan chức năng điều tra
                                    xử lý kịp thời và thông báo cho người dùng được biết.</li>
                                <li>VHT yêu cầu Người dùng phải cung cấp đầy đủ thông tin cá nhân có liên quan như: Họ tên, email, số điện thoại, ảnh … và chịu trách nhiệm về tính pháp lý của những thông tin trên.
                                    VHT không chịu trách nhiệm cũng như không giải quyết mọi khiếu nại có liên quan đến quyền lợi của Người dùng nếu xét thấy tất cả thông tin cá nhân của Người dùng cung cấp khi
                                    đăng ký ban đầu là không chính xác.</li>
                            </ul>

                        </div>

                        <div class="heading1">II. Quy định sử dụng sản phẩm </div>
                        <div class="heading2">1. Quyền và nghĩa vụ của các bên</div>
                        <div class="heading3">1.1 Phạm vi cấp phép ứng dụng</div>
                        <div class="content">
                            <ul>
                                <li>
                            VHT cấp ứng dụng này cho từng cá nhân Người dùng, không thể chuyển nhượng, không thể ủy quyền lại và không được phép độc quyền.
                                </li>
                                <li>
                            Người dùng có thể cài đặt, sử dụng, hiển thị và chạy ứng dụng này cho mục đích phi thương mại trên một một thiết bị đầu cuối di động đơn lẻ. Nhưng người dùng không được cài đặt, sử dụng,
                                    vận hành ứng dụng này với mục đích kinh doanh thương mại, không được sao chép, thay đổi, sửa đổi, câu nối để vận hành hoặc tạo ra bất kỳ sản phẩm phái sinh nào đối với dữ liệu trao đổi
                                    của đầu khách hàng và đầu dịch vụ trong quá trình vận hành ứng dụng này và đối với dữ liệu trong bộ nhớ của bất kỳ thiết bị đầu cuối nào mà ứng dụng này hoạt động truyền tải vào hoặc
                                    đối với dữ liệu của ứng dụng này, các hình thức bao gồm, nhưng không giới hạn ở việc sử dụng các giắc cắm, công cụ của bên thứ ba/ dịch vụ câu móc ngoài hoặc không được cấp phép để nối
                                    vào ứng dụng này và các hệ thống liên quan. Nếu muốn mua bán, sao chép và phân phối thương mại, chẳng hạn như ứng dụng cài đặt sẵn và đóng gói, thì phải có được văn bản uỷ quyền và
                                    cho phép của VHT.
                                </li>
                                <li>Người dùng có thể sao chép một bản sao của ứng dụng này cho mục đích sử dụng ứng dụng và dịch vụ này, chỉ dùng để làm bản sao lưu. Bản sao để sao lưu phải chứa tất cả các thông tin bản quyền
                                    có trong ứng dụng gốc.</li>
                            </ul>

                            Ngoại trừ những ủy quyền rõ ràng theo thỏa thuận này, VHT không ủy quyền các quyền lợi khác cho người dùng, nếu người dùng sử dụng các quyền khác, thì phải được sự đồng ý bằng văn bản của VHT.
                        </div>
                        <div class="heading3">1.2 Có được, cài đặt, nâng cấp ứng dụng</div>
                        <div class="content">
                            <ul>
                                <li>
                            Người dùng sẽ được tải về và cài đặt ứng dụng VIETTEL HOME theo trang web chỉ định của VHT hoặc theo phương thức chỉ định. Lưu ý không tải ứng dụng trên các trang web không được chỉ định để ngăn
                                    chặn thiết bị lây nhiễm các các chương trình độc hại có thể làm hỏng dữ liệu của người dùng và có được thông tin riêng tư của người dùng. Nếu người dùng có được ứng dụng này hoặc chương trình cài đặt
                                    tương tự như tên gọi của ứng dụng này từ một bên thứ ba mà không được ủy quyền của VHT, thì VHT không thể đảm bảo rằng ứng dụng này có thể sử dụng bình thường, và VHT sẽ không chịu trách nhiệm về
                                    tổn thất do việc này gây ra cho Người dùng.
                                </li>
                                <li>
                            Người dùng phải chọn phiên bản ứng dụng này phù hợp với thiết bị đầu cuối đã được cài đặt, nếu không, người dùng sẽ tự chịu trách nhiệm về bất kỳ vấn đề ứng dụng nào gây ra bởi sự không tương thích
                                    giữa ứng dụng và các loại hình thiết bị.
                                </li>
                                <li>
                            Để cải thiện trải nghiệm của người dùng, hoàn thiện nội dung của các dịch vụ, VHT có quyền cung cấp cho quý khách phiên bản thay thế, sửa đổi và nâng cấp bất cứ lúc nào, cũng có quyền thu phí thay thế,
                                    sửa đổi và nâng cấp, nhưng việc thu phí phải có được sự đồng ý của quý khách trước. Ứng dụng này mặc định mở các chức năng "Nhắc nhở nâng cấp" cho người dùng, căn cứ vào sự khác biệt của phiên bản
                                    ứng dụng mà người dùng sử dụng, VHT sẽ cung cấp cho người dùng quyền tự lựa chọn xem có cần mở các chức năng này hay không. Sau khi phát hành phiên bản mới của ứng dụng, VHT không đảm bảo rằng các
                                    phiên bản cũ của ứng dụng có thể tiếp tục sử dụng.
                                </li>
                            </ul>

                        </div>
                        <div class="heading3">1.3 Quyền sở hữu trí tuệ</div>
                        <div class="content">
                            <ul>
                                <li>
                            VHT là chủ sở hữu quyền sở hữu trí tuệ của sản phẩm này. Tất cả các quyền tác giả, quyền thương hiệu, quyền sáng chế, bí mật thương mại và các quyền sở hữu trí tuệ khác của sản phẩm này,
                                    tất cả các nội dung thông tin liên quan có liên quan đến sản phẩm này (bao gồm nhưng không giới hạn trong các văn bản, hình ảnh, âm thanh, video, đồ họa, thiết kế giao diện, khung phiên bản, dữ liệu
                                    liên quan hoặc tài liệu điện tử), đều được bảo vệ bởi luật pháp địa phương của quý khách và bởi các quy định của các điều ước quốc tế tương ứng, VHT được hưởng các quyền sở hữu trí tuệ nêu trên.
                                </li>
                                <li>
                            Khi không có sự đồng ý bằng văn bản của VHT, người dùng không được tự ý hoặc cho phép bên thứ ba thực hiện, sử dụng, chuyển nhượng quyền sở hữu trí tuệ nói trên vì mục đích thương mại
                                    hoặc phi thương mại, VHT và Tập đoàn Công nghiệp – Viễn thông Quân đội có quyền truy cứu trách nhiệm vi phạm nói trên.
                                </li>
                            </ul>

                            <div class="heading2">2. Chính sách bảo hành, bảo trì</div>
                            <div class="content">
                        Tổng Công ty Công nghiệp Công nghệ cao Viettel (VHT) cung cấp dịch vụ bảo hành có giới hạn cho tất cả các thiết bị trong sản phẩm Giải pháp an ninh căn hộ của VHT. VHT sẽ đổi mới thiết bị,
                                bảo hành theo hình thức một đổi một đối với các sản phẩm đáp ứng đầy đủ quy định bảo hành có giới hạn của VHT. Giá trị cao nhất của việc bảo hành và đổi trả từ VHT sẽ bằng hoặc không cao hơn
                                so với giá bán của thiết bị.
                            </div>
                            <div class="heading3">2.1 Thời hạn bảo hành</div>
                            <div class="content">
                        Thời hạn bảo hành cho thiết bị và phụ kiện đi kèm là 12 tháng kể từ ngày mua
                            </div>
                            <div class="heading3">2.2 Điều kiện bảo hành</div>
                            <div class="content">
                        Sản phẩm được bảo hành khi đáp ứng đầy đủ các điều kiện sau đây:
                                <ul>
                                    <li>
                                Sản phẩm có tem bảo hành và còn thời hạn bảo hành tính đến thời điểm VHT nhận được. Trường hợp sản phẩm không có tem bảo hành, VHT sẽ tính thời hạn bảo hành theo phiếu xuất hàng.
                                    </li>
                                    <li>
                                Sản phẩm còn nguyên dạng, đúng quy cách, không chịu các tác động vật lý, tem bảo hành (nếu có) còn đầy đủ và nguyên vẹn, số serial trên tem phải rõ ràng, không bị tẩy, xóa, sửa.
                                    </li>
                                    <li>Sản phẩm hư hỏng do chất lượng linh kiện hay lỗi quy trình sản xuất.</li>
                                    <li>Sản phẩm không thuộc trường hợp bị từ chối bảo hành.</li>
                                </ul>
                            </div>
                            <div class="heading3">2.3 Các hạng mục từ chối bảo hành</div>
                            <div class="content">
                        Việc bảo hành không được áp dụng đối với các trường hợp sau: Thiết bị đã hết hạn bảo hành; Sản phẩm đã bị can thiệp, sửa chữa hoặc thay đổi;
                                Số Serial đã bị can thiệp, rách, mờ, hoặc tháo bỏ; Tem bảo hành (nếu có) đã bị xé hoặc tháo bỏ; Việc hư hỏng do tai nạn, thiên tai, sử dụng
                                sai cách hoặc sai mục đích do vô tình hay cố ý, không bảo trì hoặc bảo trì không đúng cách, hoặc sử dụng trong các điều kiện không bình thường;
                                Việc hư hỏng do người dùng gây ra; Việc hư hỏng do sử dụng hoặc bảo quản trong các điều kiện vượt quá điều kiện sử dụng và bảo quản được mô tả
                                chi tiết trong Hướng dẫn sử dụng; Các phần mềm và dữ liệu bị mất mát trong quá trình sửa chửa hoặc thay thế.
                            </div>
                            <div class="heading3">2.4 Chi phí bảo hành</div>
                            <div class="content">
                        Miễn phí 100% chi phí bảo hành đối với thiết bị trong thời hạn bảo hành và đủ điều kiện bảo hành.
                            </div>
                            <div class="heading3">2.5 Địa điểm bảo hành</div>
                            <div class="content-item">
                        Tổng Công ty Công nghiệp Công nghệ cao Viettel <br>
                                Địa chỉ: Số 380, đường Lạc Long Quân, phường Nhật Tân, quận Tây Hồ, TP Hà Nội.
                    </div>

                            <div class="heading2">III. Giải quyết tranh chấp khiếu nại</div>
                            <div class="heading2">1. Nguyên tắc chung</div>
                            <div class="content">
                        VHT có trách nhiệm tiếp nhận khiếu nại và hỗ trợ Người dùng liên quan đến việc sử dụng sản phẩm. Khi phát sinh tranh chấp, VHT đề cao giải pháp
                                thương lượng, hòa giải giữa các bên.
                            </div>
                            <div class="heading2">2. Trình tự giải quyết khiếu nại</div>
                            <div class="content">
                        Bước 1: Người dùng khiếu nại về chất lượng sản phẩm hoặc các vấn đề khác trong quá trình sử dụng sản phẩm thông qua các kênh:
                                <ul>
                                    <li>Email: viettelvht247@viettel.com.vn</li>
                                    <li>Hotline: 02466.647.647</li>
                                </ul>
                                Thời hạn giải quyết khiếu nại: 07 (bảy) ngày kể từ ngày phát sinh sự việc.<br>
                                Bước 2: Trong vòng 07 (bảy) ngày kể từ ngày nhận được khiếu nại, Bộ phận Chăm sóc Khách hàng sẽ kiểm tra, xác nhận thông tin khiếu nại và
                                thông báo cho các bên có liên quan. VHT đồng thời tiến hành xác minh nội dung khiếu nại, phạm vi khiếu nại, phân tích nguyên nhân, tính chất,
                                mức độ của khiếu nại để đưa ra biện pháp cụ thể hỗ trợ Người dùng giải quyết khiếu nại đó.<br>
                                Bước 3: Trường hợp tranh chấp không giải quyết được bằng thương lượng, hòa giải, một trong các bên có quyền đưa tranh chấp ra cơ quan nhà nước
                                có thẩm quyền giải quyết. Bên khiếu nại, bên bị khiếu nại và các chủ thể có liên quan có trách nhiệm tích cực phối hợp, cung cấp văn bản,
                                tài liệu liên quan phục vụ cho quá trình giải quyết tranh chấp của cơ quan nhà nước có thẩm quyền.<br>
                                Bước 4: Trường hợp tranh chấp liên quan đến hành vi vi phạm quy tắc xử sự của Người dùng đã được các bên cam kết, VHT có quyền áp dụng
                                các biện pháp: cảnh cáo, tạm thời ngừng cung cấp dịch vụ hoặc chấm dứt cung cấp dịch vụ vĩnh viễn tương ứng với mức độ vi phạm, đồng thời
                                yêu cầu bên vi phạm bồi thường thiệt hại cho bên bị vi phạm (nếu có).
                            </div>

                            <div class="heading2">IV. ĐIỀU KHOẢN ÁP DỤNG</div>
                            <div class="content">
                                <ol>
                                    <li>Mọi tranh chấp trong quá trình sử dụng sản phẩm giữa VHT và các bên sẽ được các bên giải quyết bằng phương pháp thương lượng, hòa giải. Trường hợp
                                        các bên không giải quyết được bằng thương lượng, hòa giải thì một trong các bên có quyền đưa tranh chấp ra giải quyết tại cơ quan nhà nước có thẩm quyền
                            """),
format.raw("""            nhằm đảm bảo lợi ích hợp pháp của các bên, nhất là cho Người dùng. Đồng thời VHT có trách nhiệm hỗ trợ cơ quan nhà nước có thẩm quyền bằng việc cung cấp
                                        các thông tin liên quan trong quá trình giải quyết tranh chấp.</li>
                                    <li>Quy định này có hiệu lực thi hành kể từ ngày đăng tải trên ứng dụng VIETTEL HOME. Người dùng đồng ý cam kết thực hiện đúng các điều khoản trong
                                        nội dung Quy định này khi sử dụng sản phẩm trên ứng dụng.</li>
                                    <li>Quy định này có hiệu lực áp dụng ngay khi được đăng tải trên ứng dụng VIETTEL HOME tại mục Hồ sơ => Điều khoản sử dụng. VHT có quyền sửa đổi
                                        Quy định này bằng cách cập nhật công khai trên ứng dụng. Người dùng có trách nhiệm chủ động cập nhật nội dung khi Quy định có sự sửa đổi và được thông
                                        báo trên mục tương ứng.</li>
                                    <li>Trường hợp phải thay đổi nội dung Quy định để đảm bảo mục đích và hoạt động của ứng dụng thì VHTsẽ thông báo trên ứng dụng VIETTEL AICAMERA ít nhất 05
                                        (năm) ngày trước khi áp dụng. Sau 05 (năm) ngày thông báo, Quy định được sửa đổi, bổ sung, thay thế chính thức có hiệu lực. Việc Người dùng tiếp tục sử dụng
                                        dịch vụ sau khi Quy định sửa đổi có hiệu lực đồng nghĩa với việc Người dùng đã chấp nhận Quy định sửa đổi này.</li>
                                </ol>
                            </div>

                            <div class="heading2">V. THÔNG TIN LIÊN LẠC</div>

                            TỔNG CÔNG TY CÔNG NGHIỆP CÔNG NGHỆ CAO VIETTEL
                            <ul>
                                <li>
                                        Địa chỉ: Số 380 Lạc Long Quân, Phường Nhật Tân, Quận Tây Hồ, Thành phố Hà Nội, Việt Nam.
                                </li>
                                <li>
                                        Hotline: 02466.647.647
                                </li>
                                <li>
                                        Email: viettelvht247@viettel.com.vn
                                </li>
                            </ul>



                        </div>


                    </div>
                </div>
            </div>
        </div>
    </body>
</html>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:39 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/Provision.scala.html
                  HASH: 76e516d1d3c0675b96f81bb58f2fbf931ac8087f
                  MATRIX: 1034->0|1226->166|1276->196|1360->254|1374->260|1430->296|1650->489|1664->494|1710->519|1747->529|1812->566|1841->567|1886->584|2227->897|2256->898|2297->911|2335->921|2364->922|2409->939|2605->1107|2634->1108|2675->1121|2713->1131|2742->1132|2787->1149|2984->1318|3013->1319|3054->1332|3091->1341|3120->1342|3165->1359|3268->1434|3297->1435|3333->1444
                  LINES: 33->1|38->6|38->6|39->7|39->7|39->7|44->12|44->12|44->12|46->14|47->15|47->15|48->16|57->25|57->25|58->26|58->26|58->26|59->27|64->32|64->32|65->33|65->33|65->33|66->34|71->39|71->39|72->40|72->40|72->40|73->41|75->43|75->43|76->44
                  -- GENERATED --
              */
          