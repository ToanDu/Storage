
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

object LandingPage_partner extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="section features-1" id="divDoiTac">
  <div class="container">
    <div class="col-md-12 mx-auto text-center">
      <h3 class="display-3 title-section-1">"""),_display_(/*4.46*/Messages("Đối tác của chúng tôi")),format.raw/*4.79*/("""</h3>
    <p class="partner">"""),_display_(/*5.25*/Messages("Sự kết hợp của Innoway và các đối tác lớn trong lĩnh vực công nghệ sẽ mang đến cho khách hàng những giải pháp IoT hữu hiệu")),format.raw/*5.159*/("""</p>
    <div class="row mt-3">
      <div class="col-md-2" style="padding-top: 30px;">
        <img src=""""),_display_(/*8.20*/routes/*8.26*/.Assets.versioned("images/landingPage/partner1.svg")),format.raw/*8.78*/("""" width="100%" height="50px">
      </div>
      <div class="col-md-2" style="padding-top: 30px;">
        <img src=""""),_display_(/*11.20*/routes/*11.26*/.Assets.versioned("images/landingPage/partner2.svg")),format.raw/*11.78*/("""" width="100%" height="50px">
      </div>
      <div class="col-md-2" style="padding-top: 30px;">
        <img src=""""),_display_(/*14.20*/routes/*14.26*/.Assets.versioned("images/landingPage/partner3.svg")),format.raw/*14.78*/("""" width="100%" height="50px">
      </div>
      <div class="col-md-2" style="padding-top: 30px;">
        <img src=""""),_display_(/*17.20*/routes/*17.26*/.Assets.versioned("images/landingPage/partner4.svg")),format.raw/*17.78*/("""" width="100%" height="50px">
      </div>
      <div class="col-md-2" style="padding-top: 30px;">
        <img src=""""),_display_(/*20.20*/routes/*20.26*/.Assets.versioned("images/landingPage/partner5.svg")),format.raw/*20.78*/("""" width="100%" height="50px">
      </div>
      <div class="col-md-2" style="padding-top: 30px;">
        <img src=""""),_display_(/*23.20*/routes/*23.26*/.Assets.versioned("images/landingPage/partner6.svg")),format.raw/*23.78*/("""" width="100%" height="50px">
      </div>

    </div>
    <div class="row mt-4">
      <div class="col-md-2 mt">

      </div>
      <div class="col-md-2 mt">
        <img class="img-partner" src=""""),_display_(/*32.40*/routes/*32.46*/.Assets.versioned("images/landingPage/image19.svg")),format.raw/*32.97*/("""" width="" height="50px">
      </div>
      <div class="col-md-2 mt">
        <img class="img-partner" src=""""),_display_(/*35.40*/routes/*35.46*/.Assets.versioned("images/landingPage/image31.svg")),format.raw/*35.97*/("""" width="100%" height="50px">
      </div>
      <div class="col-md-2 mt">
        <img class="img-partner" src=""""),_display_(/*38.40*/routes/*38.46*/.Assets.versioned("images/landingPage/image32.svg")),format.raw/*38.97*/("""" width="" height="50px">
      </div>
      <div class="col-md-2 mt">
        <img class="img-partner" src=""""),_display_(/*41.40*/routes/*41.46*/.Assets.versioned("images/landingPage/zivix.png")),format.raw/*41.95*/("""" width="" height="50px">
      </div>
      <div class="col-md-2 mt">

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPage/LandingPage_partner.scala.html
                  HASH: db99db8fe7dfc45e8ea61dc43d8214a7e46eda25
                  MATRIX: 1056->0|1249->167|1302->200|1358->230|1513->364|1646->471|1660->477|1732->529|1877->647|1892->653|1965->705|2110->823|2125->829|2198->881|2343->999|2358->1005|2431->1057|2576->1175|2591->1181|2664->1233|2809->1351|2824->1357|2897->1409|3123->1608|3138->1614|3210->1665|3347->1775|3362->1781|3434->1832|3575->1946|3590->1952|3662->2003|3799->2113|3814->2119|3884->2168
                  LINES: 33->1|36->4|36->4|37->5|37->5|40->8|40->8|40->8|43->11|43->11|43->11|46->14|46->14|46->14|49->17|49->17|49->17|52->20|52->20|52->20|55->23|55->23|55->23|64->32|64->32|64->32|67->35|67->35|67->35|70->38|70->38|70->38|73->41|73->41|73->41
                  -- GENERATED --
              */
          