
package views.html.amarket.marketPlace

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

object MarketPlace_footer extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<div class="section features-1" style="padding: 0; background: #F8F6F3;;">
  <div class="container">
    <div class="row">
      <div class="col-md-8">
        <img class="" src=""""),_display_(/*7.29*/routes/*7.35*/.Assets.versioned("images/landingPage/Logo.png")),format.raw/*7.83*/("""">
      </div>
      <div class="col-md-2 mt">
        <p class="text-shape">Hotline miễn phí(24/7)</p>
        <p class="text-shape1">0869999904</p>
      </div>
      <div class="col-md-2 mt">
        <p class="text-shape">Chăm sóc khác hàng</p>
        <p class="text-shape1" style="word-break: break-all;">"""),_display_(/*15.64*/Messages("innoway@viettel.com.vn")),format.raw/*15.98*/("""</p>
      </div>
    </div>
  </div>
</div>
<div class="section features-1" style="border-bottom: 1px solid #F8F6F3;">
  <div class="container">
    <div class="row">
      <div class="col-md-4">
        <div class="info text-white">
          <p class="descriptions opacity-8 text-darker" style="margin-top: 15px; font-weight: 500;">"""),_display_(/*25.102*/Messages("LIÊN HỆ CHÚNG TÔI ")),format.raw/*25.132*/("""</p>
          <p class="descriptions opacity-8 text-black-50" style="margin-top: 15px"><i class="bx bx-location-plus"></i> """),_display_(/*26.121*/Messages("380 Lạc Long Quân, Nhật Tân, Tây Hồ, Hà Nội")),format.raw/*26.176*/("""</p>
          <a href="tel: 0869999904" target="_blank" class="descriptions opacity-8 text-black-50"><i class="bx bx-phone"></i> """),_display_(/*27.127*/Messages("0869999904")),format.raw/*27.149*/("""</a>
          <a href="mailto: innowayviettel.com.vn" target="_blank" class="descriptions opacity-8 text-black-50"><i class="bx bx-envelope"></i> """),_display_(/*28.144*/Messages("innoway@viettel.com.vn")),format.raw/*28.178*/("""</a>
        </div>
      </div>
      <div class="col-md-2">
        <div class="info text-white">
          <p class="descriptions opacity-8 text-darker" style="margin-top: 15px; font-weight: 500;">"""),_display_(/*33.102*/Messages("INNOWAY ")),format.raw/*33.122*/("""</p>
          <p class="descriptions opacity-8 text-black-50" style="margin-top: 15px">"""),_display_(/*34.85*/Messages("Giới thiệu")),format.raw/*34.107*/("""</p>
          <p class="descriptions opacity-8 text-black-50" style="margin-top: 15px">"""),_display_(/*35.85*/Messages("Hợp tác")),format.raw/*35.104*/("""</p>
          <a href="https://blog.innoway.vn/tuyen-dung" target="_blank" class="descriptions opacity-8 text-black-50">"""),_display_(/*36.118*/Messages("Tuyển dụng ")),format.raw/*36.141*/("""</a>
        </div>
      </div>
      <div class="col-md-2">
        <div class="info text-white">
          <p class="description opacity-8 text-darker" style="margin-top: 15px; font-weight: 500;">"""),_display_(/*41.101*/Messages("DEVELOPERS ")),format.raw/*41.124*/("""</p>
          <a href="https://vht-iot.gitbook.io/innoway/" targat="_bank" class="descriptions opacity-8 text-black-50" style="margin-top: 15px">"""),_display_(/*42.143*/Messages("Hướng dẫn sử dụng")),format.raw/*42.172*/("""</a>
          """),_display_(/*43.12*/if(currentUser != null)/*43.35*/{_display_(Seq[Any](format.raw/*43.36*/("""
            """),format.raw/*44.13*/("""<a href=""""),_display_(/*44.23*/routes/*44.29*/.ProjectController.project()),format.raw/*44.57*/("""" class="descriptions opacity-8 text-black-50" style="margin-top: 15px">"""),_display_(/*44.130*/Messages("Bắt đầu 1 dự án mới")),format.raw/*44.161*/("""</a>
          """)))}/*45.13*/else/*45.18*/{_display_(Seq[Any](format.raw/*45.19*/("""
            """),format.raw/*46.13*/("""<a href="#" onclick="notiMustLogin()" class="descriptions opacity-8 text-black-50">"""),_display_(/*46.97*/Messages("Bắt đầu 1 dự án")),format.raw/*46.124*/("""</a>
          """)))}),format.raw/*47.12*/("""
          """),format.raw/*48.11*/("""<a href=""""),_display_(/*48.21*/routes/*48.27*/.AppDebugController.solutionMaketPage()),format.raw/*48.66*/("""" target="_blank" class="descriptions opacity-8 text-black-50" style="margin-top: 15px">"""),_display_(/*48.155*/Messages("App SDK")),format.raw/*48.174*/("""</a>
          <a href=""""),_display_(/*49.21*/routes/*49.27*/.AppDebugController.appDebugPage()),format.raw/*49.61*/("""" target="_blank" class="descriptions opacity-8 text-black-50" style="margin-top: 15px">"""),_display_(/*49.150*/Messages("Vsmart Debug")),format.raw/*49.174*/("""</a>
        </div>
      </div>
      <div class="col-md-4">
        <div class="info text-white">
          <p class="descriptions opacity-8 text-darker" style="margin-top: 15px; font-weight: 500;">"""),_display_(/*54.102*/Messages("NHẬN TIN TỨC ")),format.raw/*54.127*/("""</p>
          <p class="descriptions opacity-8 text-black-50" style="margin-top: 15px">"""),_display_(/*55.85*/Messages("Đăng ký ngay để nhận thông tin từ InnoWay.vn")),format.raw/*55.141*/("""</p>
          <input class="form-control"  placeholder="Nhập email" class="bx:arrow-to-right">
          <a href="https://www.facebook.com/innoway.vn/" class="bx bxl-facebook" target="_blank"></a>
          <a href="https://twitter.com/VInnoway" class="bx bxl-twitter" target="_blank"></a>
          <a href="https://www.youtube.com/channel/UClr7WnjIVvPKiWmONu4r8zA" class="bx bxl-youtube" target="_blank"></a>
          <a href="https://www.instagram.com/innoway.vn/" class="bx bxl-instagram" target="_blank"></a>
          <p class="description opacity-8" style="margin-top: 15px"></p>
        </div>
      </div>
    </div>
  </div>
</div>
<div class="section features-1" style="padding: 0;">
  <div class="container">
    <div class="row">
      <div class="col-md-8 mt">
        <p class="text-black-50">"""),_display_(/*71.35*/Messages("© 2022. Bản quyền thuộc về Tổng Công ty Công nghiệp Công nghệ cao Viettel (VHT)")),format.raw/*71.126*/("""</p>
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
                  DATE: Mon Sep 22 16:32:40 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/amarket/marketPlace/MarketPlace_footer.scala.html
                  HASH: 0bfe5a5d670bce93ef7f43d40d9e18db2b7833a5
                  MATRIX: 671->1|1019->35|1132->53|1159->54|1365->234|1379->240|1447->288|1786->600|1841->634|2205->970|2257->1000|2410->1125|2487->1180|2646->1311|2690->1333|2866->1481|2922->1515|3151->1716|3193->1736|3309->1825|3353->1847|3469->1936|3510->1955|3660->2077|3705->2100|3933->2300|3978->2323|4153->2470|4204->2499|4247->2515|4279->2538|4318->2539|4359->2552|4396->2562|4411->2568|4460->2596|4561->2669|4614->2700|4649->2717|4662->2722|4701->2723|4742->2736|4853->2820|4902->2847|4949->2863|4988->2874|5025->2884|5040->2890|5100->2929|5217->3018|5258->3037|5310->3062|5325->3068|5380->3102|5497->3191|5543->3215|5772->3416|5819->3441|5935->3530|6013->3586|6851->4397|6964->4488
                  LINES: 24->1|29->2|34->2|35->3|39->7|39->7|39->7|47->15|47->15|57->25|57->25|58->26|58->26|59->27|59->27|60->28|60->28|65->33|65->33|66->34|66->34|67->35|67->35|68->36|68->36|73->41|73->41|74->42|74->42|75->43|75->43|75->43|76->44|76->44|76->44|76->44|76->44|76->44|77->45|77->45|77->45|78->46|78->46|78->46|79->47|80->48|80->48|80->48|80->48|80->48|80->48|81->49|81->49|81->49|81->49|81->49|86->54|86->54|87->55|87->55|103->71|103->71
                  -- GENERATED --
              */
          