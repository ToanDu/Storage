
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

object LandingPage_contact extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="section features-6" id="divLienHe">
  <div class="container">
    <div class="row align-items-center">
      <div class="col-md-2"></div>
      <div class="col-md-8" style="box-shadow: 0px 12px 44px rgba(13, 38, 59, 0.12); border-radius: 24px;">
        <div class="row">
          <div class="col-md-4" id="text-white" style="padding: 0px;">
            <img class="" src=""""),_display_(/*8.33*/routes/*8.39*/.Assets.versioned("images/landingPage/imgContact1.png")),format.raw/*8.94*/("""" height="100%" width="100%">
            <img class="imgCskh" src=""""),_display_(/*9.40*/routes/*9.46*/.Assets.versioned("images/landingPage/imgContact2.png")),format.raw/*9.101*/("""" style="">
          </div>
          <div class="col-md-8">
            <div class="form-group" style="text-align: center">
              <label class="mt-3 contact-form-1">"""),_display_(/*13.51*/Messages("Liên hệ với chúng tôi ")),format.raw/*13.85*/("""</label>
            </div>
            <div class="form-group ml-5 mr-5">
              <p>"""),_display_(/*16.19*/Messages("landing7.name")),_display_(/*16.45*/Messages("*")),format.raw/*16.58*/("""</p>
              <input class="form-control input7" type="text" id="name" maxlength="50">
            </div>
            <div class="form-group ml-5 mr-5">
              <p>"""),_display_(/*20.19*/Messages("landing7.email")),_display_(/*20.46*/Messages("*")),format.raw/*20.59*/("""</p>
              <input class="form-control input7" type="email" id="email" maxlength="50">
            </div>
            <div class="form-group ml-5 mr-5">
              <p>"""),_display_(/*24.19*/Messages("landing7.phone")),_display_(/*24.46*/Messages("*")),format.raw/*24.59*/("""</p>
              <input class="form-control input7" type="number" id="phone" maxlength="11">
            </div>
            <div class="form-group ml-5 mr-5">
              <p>"""),_display_(/*28.19*/Messages("landing7.select")),_display_(/*28.47*/Messages("*")),format.raw/*28.60*/("""</p>
              <select class="form-control input7" style="width: 100%" id="field">
                <option value="1">"""),_display_(/*30.36*/Messages("landing7.select1")),format.raw/*30.64*/("""</option>
                <option value="2">"""),_display_(/*31.36*/Messages("landing7.select2")),format.raw/*31.64*/("""</option>
                <option value="3">"""),_display_(/*32.36*/Messages("landing7.select3")),format.raw/*32.64*/("""</option>
                <option value="4">"""),_display_(/*33.36*/Messages("landing7.select4")),format.raw/*33.64*/("""</option>
              </select>
            </div>
            <div class="form-group ml-5 mr-5">
              <p>"""),_display_(/*37.19*/Messages("landing7.content")),_display_(/*37.48*/Messages("*")),format.raw/*37.61*/("""</p>
              <textarea id="content" name="content" type="text" class="form-control" rows="5" autocomplete="off" maxlength="500"></textarea>
            </div>
            <div class="form-group mt-3 text-center">
              <button class="btn btn-danger radius-40" onclick="submitFormContact()" id="buttonSubmitContacts">
              """),_display_(/*42.16*/Messages("Gửi thông tin ngay ")),format.raw/*42.47*/("""
              """),format.raw/*43.15*/("""</button>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-2"></div>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPage/LandingPage_contact.scala.html
                  HASH: 97b4ac223da4dca0b0af476244854ddd1e275935
                  MATRIX: 1056->0|1469->387|1483->393|1558->448|1653->517|1667->523|1743->578|1946->754|2001->788|2121->881|2167->907|2201->920|2404->1096|2451->1123|2485->1136|2690->1314|2737->1341|2771->1354|2977->1533|3025->1561|3059->1574|3208->1696|3257->1724|3329->1769|3378->1797|3450->1842|3499->1870|3571->1915|3620->1943|3765->2061|3814->2090|3848->2103|4221->2449|4273->2480|4316->2495
                  LINES: 33->1|40->8|40->8|40->8|41->9|41->9|41->9|45->13|45->13|48->16|48->16|48->16|52->20|52->20|52->20|56->24|56->24|56->24|60->28|60->28|60->28|62->30|62->30|63->31|63->31|64->32|64->32|65->33|65->33|69->37|69->37|69->37|74->42|74->42|75->43
                  -- GENERATED --
              */
          