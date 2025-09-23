
package views.html.iot.app

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
/*1.2*/import helper._
/*2.2*/import vn.m2m.common.models.User

object AppDebug extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, projectId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.38*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("App Debug")),format.raw/*9.34*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*17.78*/("""" rel="stylesheet" />

    <style>
      .Rectangle-1486 """),format.raw/*20.23*/("""{"""),format.raw/*20.24*/("""
        """),format.raw/*21.9*/("""width: 80%;
        height: 57px;
        margin: 18px 13px 13px 72px;
        padding: 11px 35px 8px 23px;
        border-radius: 16px;
        border: solid 1px #707070;
        background-color: #fffafb;
      """),format.raw/*28.7*/("""}"""),format.raw/*28.8*/("""
      """),format.raw/*29.7*/(""".Ellipse-344 """),format.raw/*29.20*/("""{"""),format.raw/*29.21*/("""
        """),format.raw/*30.9*/("""width: 38px;
        height: 38px;
        margin: 0 30px 0 0;
        padding: 7px 14px 8px;
        border: solid 1px #707070;
        background-color: #fff;
        border-radius: 50%
      """),format.raw/*37.7*/("""}"""),format.raw/*37.8*/("""
      """),format.raw/*38.7*/(""".qr-text """),format.raw/*38.16*/("""{"""),format.raw/*38.17*/("""
        """),format.raw/*39.9*/("""width: 100%;
        height: 23px;
        margin: 6px 0 9px 3px;
        font-size: 18px;
        font-weight: normal;
        font-stretch: normal;
        font-style: normal;
        line-height: 1.28;
        letter-spacing: normal;
        text-align: left;
        color: #333;
      """),format.raw/*50.7*/("""}"""),format.raw/*50.8*/("""
    """),format.raw/*51.5*/("""</style>
  </head>
  <body class="bg-theme">
    """),_display_(/*54.6*/views/*54.11*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*54.54*/("""

    """),_display_(/*56.6*/views/*56.11*/.html.iot.tags.Header(currentUser)),format.raw/*56.45*/("""

    """),format.raw/*58.5*/("""<div class="page-wrapper">
      <div class="page-content">
        <div class="card">
          <div class="col-md-12">
            <div class="row">

              <div class="col-md-6">
                <img src=""""),_display_(/*65.28*/routes/*65.34*/.Assets.versioned("images/debug.png")),format.raw/*65.71*/("""" alt="..." class="card-img" style="height: 100%; padding: 15px">
              </div>

              <div class="col-md-6">
                <div class="card-body">
                  <h5 style="font-weight: bold">"""),_display_(/*70.50*/Messages("Vsmart debug")),format.raw/*70.74*/("""</h5>
                  <p class="card-text">"""),_display_(/*71.41*/Messages("Vsmart debug là ứng dụng hỗ trợ các nhà phát triển theo dõi dữ liệu của các thiết bị đã tích hợp với nền tảng Innoway.")),format.raw/*71.171*/("""</p>
                  <p class="card-text">"""),_display_(/*72.41*/Messages("Để cài đặt ứng dụng, vui lòng thực hiện theo hướng dẫn sau:")),format.raw/*72.112*/("""</p>
                  <div class="Rectangle-1486 d-flex">
                    <div class="Ellipse-344"><span>1</span></div><span class="qr-text">Quét mã QR bằng điện thoại</span>
                  </div>
                  <div class="Rectangle-1486 d-flex">
                    <div class="Ellipse-344"><span>2</span></div><span class="qr-text">Cài đặt ứng dụng Deploygate</span>
                  </div>
                  <div class="Rectangle-1486 d-flex">
                    <div class="Ellipse-344"><span>3</span></div><span class="qr-text">Quét mã QR bằng ứng dụng Deploygate</span>
                  </div>
                </div>
              </div>

              <div class="col-md-6">
                <div class="card-body align-items-center">
                  <h5 style="font-weight: normal; text-transform: uppercase;">"""),_display_(/*87.80*/Messages("Android")),format.raw/*87.99*/("""</h5>
                  <img src=""""),_display_(/*88.30*/routes/*88.36*/.Assets.versioned("images/debugAdroid.png")),format.raw/*88.79*/("""" alt="..." class="card-img" style="width: 380px; padding: 15px">
                  <br>
                  <a href="https://dply.me/3j9wws" target="_blank">"""),_display_(/*90.69*/Messages("Hoặc truy cập vào đường link: https://dply.me/3j9wws")),format.raw/*90.133*/("""</a>
                </div>
              </div>

              <div class="col-md-6">
                <div class="card-body align-items-center">
                  <h5 style="font-weight: normal; text-transform: uppercase;">"""),_display_(/*96.80*/Messages("IOS")),format.raw/*96.95*/("""</h5>
                  <img src=""""),_display_(/*97.30*/routes/*97.36*/.Assets.versioned("images/debugIos.png")),format.raw/*97.76*/("""" alt="..." class="card-img" style="width: 380px; padding: 15px">
                  <br>
                  <a href="https://dply.me/hhdor8" target="_blank">"""),_display_(/*99.69*/Messages("Hoặc truy cập vào đường link: https://dply.me/hhdor8")),format.raw/*99.133*/("""</a>
                </div>
              </div>

            </div>
          </div>
        </div>
      </div>
    </div>

    """),_display_(/*109.6*/views/*109.11*/.html.Loading()),format.raw/*109.26*/("""
  """),format.raw/*110.3*/("""</body>

  """),_display_(/*112.4*/views/*112.9*/.html.iot.tags.Main_js()),format.raw/*112.33*/("""

  """),format.raw/*114.3*/("""<script>
          var projectId = '"""),_display_(/*115.29*/projectId),format.raw/*115.38*/("""';
          $(document).ready(function () """),format.raw/*116.41*/("""{"""),format.raw/*116.42*/("""
            """),format.raw/*117.13*/("""$("#menu-appDebug").addClass("mm-active");

            $("#menu").metisMenu();
            for (var e = window.location, o = $(".metismenu li a").filter(function() """),format.raw/*120.86*/("""{"""),format.raw/*120.87*/("""
              """),format.raw/*121.15*/("""return this.href == e
            """),format.raw/*122.13*/("""}"""),format.raw/*122.14*/(""").addClass("").parent().addClass("mm-active"); o.is("li");) o = o.parent("").addClass("mm-show").parent("").addClass("mm-active");
          """),format.raw/*123.11*/("""}"""),format.raw/*123.12*/(""")
  </script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,projectId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,projectId)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,projectId) => apply(currentUser,projectId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:42 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/app/AppDebug.scala.html
                  HASH: a16b4e6c434048ca7f37c758cacb1f70a0fa7d5a
                  MATRIX: 659->1|682->18|1027->52|1158->88|1185->89|1353->231|1394->252|1475->306|1490->312|1547->348|1754->529|1768->534|1814->559|1847->565|1887->578|1902->584|1977->638|2062->695|2091->696|2127->705|2367->918|2395->919|2429->926|2470->939|2499->940|2535->949|2756->1143|2784->1144|2818->1151|2855->1160|2884->1161|2920->1170|3237->1460|3265->1461|3297->1466|3373->1516|3387->1521|3451->1564|3484->1571|3498->1576|3553->1610|3586->1616|3829->1832|3844->1838|3902->1875|4143->2089|4188->2113|4261->2159|4413->2289|4485->2334|4578->2405|5440->3240|5480->3259|5542->3294|5557->3300|5621->3343|5805->3500|5891->3564|6143->3789|6179->3804|6241->3839|6256->3845|6317->3885|6501->4042|6587->4106|6745->4237|6760->4242|6797->4257|6828->4260|6867->4272|6881->4277|6927->4301|6959->4305|7024->4342|7055->4351|7127->4394|7157->4395|7199->4408|7393->4573|7423->4574|7467->4589|7530->4623|7560->4624|7730->4765|7760->4766
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|52->20|52->20|53->21|60->28|60->28|61->29|61->29|61->29|62->30|69->37|69->37|70->38|70->38|70->38|71->39|82->50|82->50|83->51|86->54|86->54|86->54|88->56|88->56|88->56|90->58|97->65|97->65|97->65|102->70|102->70|103->71|103->71|104->72|104->72|119->87|119->87|120->88|120->88|120->88|122->90|122->90|128->96|128->96|129->97|129->97|129->97|131->99|131->99|141->109|141->109|141->109|142->110|144->112|144->112|144->112|146->114|147->115|147->115|148->116|148->116|149->117|152->120|152->120|153->121|154->122|154->122|155->123|155->123
                  -- GENERATED --
              */
          