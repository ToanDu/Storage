
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

object ProjectList_createTemplate extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="createTemplateProjectModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-fullscreen">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: inherit;">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("Giải pháp mẫu")),format.raw/*5.93*/("""</h5>
        <button type="button" class="btn-close" onclick="cancleWizard()" aria-label="Close"></button>
      </div>
      <div class="modal-body">

        <div class="card" style="padding: 20px; border: 1px solid #858687;">
          <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 row-cols-xl-4">
            <div class="col">
              <div class="card">
                <img src=""""),_display_(/*14.28*/routes/*14.34*/.Assets.versioned("images/landingPage/fleet.png")),format.raw/*14.83*/("""" class="card-img-top" alt="..." height="300">
                <div class="card-body">
                  <div class="form-check form-check-inline">
                    <input class="form-check-input checkbox-gp" type="radio" name="radioChooseTemplate" onchange="chooseTemplateProject('Fleet Management')" style="font-size: 20px; margin-top: 0px;">
                    <label class="form-check-label" for="" style="font-weight: 500;">"""),_display_(/*18.87*/Messages("Giải pháp Fleet Management")),format.raw/*18.125*/("""</label>
                  </div>
                </div>
              </div>
            </div>

            <div class="col">
              <div class="card">
                <img src=""""),_display_(/*26.28*/routes/*26.34*/.Assets.versioned("images/project/asset.jpeg")),format.raw/*26.80*/("""" class="card-img-top" alt="..." height="300">
                <div class="card-body">
                  <div class="form-check form-check-inline">
                    <input class="form-check-input checkbox-gp" type="radio" name="radioChooseTemplate" onchange="chooseTemplateProject('Asset Management')" style="font-size: 20px; margin-top: 0px;">
                    <label class="form-check-label" for="" style="font-weight: 500;">"""),_display_(/*30.87*/Messages("Giải pháp Asset Management")),format.raw/*30.125*/("""</label>
                  </div>
                </div>
              </div>
            </div>

            <div class="col">
              <div class="card">
                <img src=""""),_display_(/*38.28*/routes/*38.34*/.Assets.versioned("images/landingPage/smartmettering.png")),format.raw/*38.92*/("""" class="card-img-top" alt="..." height="300">
                <div class="card-body">
                  <div class="form-check form-check-inline">
                    <input class="form-check-input checkbox-gp" type="radio" name="radioChooseTemplate" onchange="chooseTemplateProject('Smart Water Meter')" style="font-size: 20px; margin-top: 0px;">
                    <label class="form-check-label" for="" style="font-weight: 500;">"""),_display_(/*42.87*/Messages("Giải pháp Smart Water Meter")),format.raw/*42.126*/("""</label>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="card" style="padding: 20px; border: 1px solid #858687;">
          <div class="row" hidden>
            <input id="nameTemplateProject" class="form-group" type="text" readonly>
          </div>
          <div class="row" id="divSmartWizard">
            """),format.raw/*55.39*/("""
              """),format.raw/*56.35*/("""
                """),format.raw/*57.131*/("""
                """),format.raw/*58.123*/("""
                """),format.raw/*59.144*/("""
                """),format.raw/*60.130*/("""
                """),format.raw/*61.129*/("""
                """),format.raw/*62.146*/("""
                """),format.raw/*63.145*/("""
                """),format.raw/*64.127*/("""
              """),format.raw/*65.24*/("""
              """),format.raw/*66.44*/("""
                """),format.raw/*67.102*/("""
                """),format.raw/*68.102*/("""
                """),format.raw/*69.102*/("""
                """),format.raw/*70.102*/("""
                """),format.raw/*71.102*/("""
                """),format.raw/*72.102*/("""
                """),format.raw/*73.102*/("""
                """),format.raw/*74.102*/("""
              """),format.raw/*75.25*/("""
            """),format.raw/*76.23*/("""
          """),format.raw/*77.11*/("""</div>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/project/ProjectList_createTemplate.scala.html
                  HASH: 6578df4851d4cbd4c37a9b7e11921ffbec84e33f
                  MATRIX: 1063->0|1478->389|1523->414|1951->815|1966->821|2036->870|2497->1304|2557->1342|2772->1530|2787->1536|2854->1582|3315->2016|3375->2054|3590->2242|3605->2248|3684->2306|4146->2741|4207->2780|4639->3210|4682->3245|4728->3376|4774->3499|4820->3643|4866->3773|4912->3902|4958->4048|5004->4193|5050->4320|5093->4344|5136->4388|5182->4490|5228->4592|5274->4694|5320->4796|5366->4898|5412->5000|5458->5102|5504->5204|5547->5229|5588->5252|5627->5263
                  LINES: 33->1|37->5|37->5|46->14|46->14|46->14|50->18|50->18|58->26|58->26|58->26|62->30|62->30|70->38|70->38|70->38|74->42|74->42|87->55|88->56|89->57|90->58|91->59|92->60|93->61|94->62|95->63|96->64|97->65|98->66|99->67|100->68|101->69|102->70|103->71|104->72|105->73|106->74|107->75|108->76|109->77
                  -- GENERATED --
              */
          