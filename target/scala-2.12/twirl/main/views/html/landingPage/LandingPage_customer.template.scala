
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

object LandingPage_customer extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="section features-1 mt-5" id="divKhachHang">
  <div class="container">
    <div class="col-md-12 mx-auto text-center">
      <h3 class="title-section-1">"""),_display_(/*4.36*/Messages("Khách hàng và sản phẩm ")),format.raw/*4.71*/("""<span style="color: #ee0033">"""),_display_(/*4.101*/Messages("tiêu biểu")),format.raw/*4.122*/("""</span></h3>
      <p id="customer">"""),_display_(/*5.25*/Messages("Nền tảng Innoway đã đồng hành cùng nhiều doanh nghiệp trong nước xây dựng giải pháp IoT phục vụ chuyển đổi số.")),format.raw/*5.147*/("""</p>
      <div class="row">
        <div class="col-md">
          <img class="img-brand" src=""""),_display_(/*8.40*/routes/*8.46*/.Assets.versioned("images/landingPage/customer1.svg")),format.raw/*8.99*/("""" >
        </div>
        <div class="col-md">
          <img class="img-brand" src=""""),_display_(/*11.40*/routes/*11.46*/.Assets.versioned("images/landingPage/customer2.svg")),format.raw/*11.99*/("""" >
        </div>
        <div class="col-md">
          <img class="img-brand" src=""""),_display_(/*14.40*/routes/*14.46*/.Assets.versioned("images/landingPage/Brand 1.png")),format.raw/*14.97*/("""" >
        </div>
        <div class="col-md">
          <img class="img-brand" src=""""),_display_(/*17.40*/routes/*17.46*/.Assets.versioned("images/landingPage/customer3.svg")),format.raw/*17.99*/("""" >
        </div>
        <div class="col-md">
          <img class="img-brand" src=""""),_display_(/*20.40*/routes/*20.46*/.Assets.versioned("images/landingPage/customer4.svg")),format.raw/*20.99*/("""" >
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPage/LandingPage_customer.scala.html
                  HASH: 6dbe812442c7c6f5de549d31a1d1c47a679f9111
                  MATRIX: 1057->0|1248->165|1303->200|1360->230|1402->251|1465->288|1608->410|1731->507|1745->513|1818->566|1932->653|1947->659|2021->712|2135->799|2150->805|2222->856|2336->943|2351->949|2425->1002|2539->1089|2554->1095|2628->1148
                  LINES: 33->1|36->4|36->4|36->4|36->4|37->5|37->5|40->8|40->8|40->8|43->11|43->11|43->11|46->14|46->14|46->14|49->17|49->17|49->17|52->20|52->20|52->20
                  -- GENERATED --
              */
          