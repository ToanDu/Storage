
package views.html.group

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

object GroupList_tab_InfoOrg extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div >
  <div class="card" style="height: 36px;background: #EC1B2E;opacity: 0.85;border-radius: 0px 4px 0px 0px; width: 100%">
    <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; ">"""),_display_(/*3.128*/Messages("manage.org.overview")),format.raw/*3.159*/("""</span>
  </div>

  <div class="card">
    <div class="col-md-12" style="padding: 15px; border: 1px solid #858687;">
      <div class="row">
        <div class="col-md-3">
          <img src=""""),_display_(/*10.22*/routes/*10.28*/.Assets.versioned("images/org/building.png")),format.raw/*10.72*/("""" id="imageInfoOrg" width="100%">
        </div>
        """),format.raw/*12.41*/("""
        """),format.raw/*13.9*/("""<div class="col-md-9">
          <table class="table mb-0">
            <thead>
            </thead>
            <tbody>
              <tr>
                <th style="width: 150px">"""),_display_(/*19.43*/Messages("ID")),format.raw/*19.57*/("""</th>
                <th id="infoIdOrg">"""),_display_(/*20.37*/Messages("")),format.raw/*20.49*/("""</th>
              </tr>
              <tr>
                <th style="width: 150px">"""),_display_(/*23.43*/Messages("Tên")),format.raw/*23.58*/("""</th>
                <th id="infoNameOrg">"""),_display_(/*24.39*/Messages("")),format.raw/*24.51*/("""</th>
              </tr>
              <tr>
                <th style="width: 150px">"""),_display_(/*27.43*/Messages("Mô tả")),format.raw/*27.60*/("""</th>
                <th id="infoContentOrg">"""),_display_(/*28.42*/Messages("")),format.raw/*28.54*/("""</th>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>

  <div class="card table-responsive" id="tabAttribute" style="padding: 10px; display: none; border: 1px solid #858687;">
    <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; ">"""),_display_(/*38.128*/Messages("Danh sách thuộc tính")),format.raw/*38.160*/("""</span>
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
                  DATE: Mon Sep 22 16:32:42 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList_tab_InfoOrg.scala.html
                  HASH: e9886bf455ae867bf5250eaab49e0f073e254718
                  MATRIX: 1052->0|1333->254|1385->285|1605->478|1620->484|1685->528|1770->617|1806->626|2015->808|2050->822|2119->864|2152->876|2266->963|2302->978|2373->1022|2406->1034|2520->1121|2558->1138|2632->1185|2665->1197|3056->1560|3110->1592
                  LINES: 33->1|35->3|35->3|42->10|42->10|42->10|44->12|45->13|51->19|51->19|52->20|52->20|55->23|55->23|56->24|56->24|59->27|59->27|60->28|60->28|70->38|70->38
                  -- GENERATED --
              */
          