
package views.html.telco.order

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

object OrderSubscriber_sim_haveSim extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-lg-9 col-md-8 mt-3" id="tabConnectHaveSim">
  <div class="row">
    <div class="col-md-12 m-t-4">
      <span class="display-4 title-section-1">"""),_display_(/*4.48*/Messages("1. Thông tin thuê bao")),format.raw/*4.81*/("""</span>
    </div>
    <div class="col-md-12">
      <div class="row">
        <div class="col-md-12 m-t-3">
          <div class="row m-b-4">
            <label class="col-sm-3 col-form-label title-section-2" style="text-align: left">"""),_display_(/*10.94*/Messages("Danh sách thuê bao")),format.raw/*10.124*/("""<span class="text-red">"""),_display_(/*10.148*/Messages("*")),format.raw/*10.161*/("""</span></label>
            <div class="col-sm-3">
              <input type="text" class="form-control input-form" id="nameFileImport" readonly/>
            </div>
            <input type="file" class="" id="filesConnectHaveSim" name="files" style="background-color: #aaa;" hidden/>
            <label class="col-sm-3 col-form-label title-section-2" style="text-align: left; cursor: pointer; color: #EA0033;" onclick="importFileConnectHaveSim()">
              <i class="bx bx-upload"></i> """),_display_(/*16.45*/Messages("Import danh sách")),format.raw/*16.73*/("""
            """),format.raw/*17.13*/("""</label>
            <label class="col-sm-3 col-form-label title-section-2" style="text-align: left; cursor: pointer; color: #EA0033;" onclick="downloadTemplateConnectHaveSim()">
              <i class="bx bx-file"></i> """),_display_(/*19.43*/Messages("File danh sách mẫu")),format.raw/*19.73*/("""
            """),format.raw/*20.13*/("""</label>
          </div>
        </div>
      </div>
    </div>

    <div class="col-md-12 m-t-4">
      <span class="display-4 title-section-1">"""),_display_(/*27.48*/Messages("2. Check danh sách")),format.raw/*27.78*/("""</span>
    </div>
    <div class="col-md-12">
      <div class="row">
        <div class="col-md-12 m-t-3">
          <div class="row m-b-4">
            <label class="col-sm-3 col-form-label title-section-2" style="text-align: left">"""),_display_(/*33.94*/Messages("Số lượng thuê bao hợp lệ")),format.raw/*33.130*/("""<span class="text-red">"""),_display_(/*33.154*/Messages("*")),format.raw/*33.167*/("""</span></label>
            <div class="col-sm-3">
              <input type="number" class="form-control input-form" id="countConnectHaveSimTrue" value="0" style="width: 100%;" readonly/>
            </div>
            <label class="col-sm-6 col-form-label title-section-2" style="text-align: left; cursor: pointer; color: #EA0033;" onclick="exportListConnectHaveSimTrue()">
              <i class="bx bx-download"></i> """),_display_(/*38.47*/Messages("Tải danh sách chi tiết")),format.raw/*38.81*/("""
            """),format.raw/*39.13*/("""</label>
          </div>
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
                  DATE: Mon Sep 22 16:32:53 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/order/OrderSubscriber_sim_haveSim.scala.html
                  HASH: 6a9f7a4fa84d8908bb2ab539766dac3bdeaa1ca4
                  MATRIX: 1064->0|1251->161|1304->194|1567->430|1619->460|1671->484|1706->497|2226->990|2275->1018|2316->1031|2564->1252|2615->1282|2656->1295|2830->1442|2881->1472|3144->1708|3202->1744|3254->1768|3289->1781|3738->2203|3793->2237|3834->2250
                  LINES: 33->1|36->4|36->4|42->10|42->10|42->10|42->10|48->16|48->16|49->17|51->19|51->19|52->20|59->27|59->27|65->33|65->33|65->33|65->33|70->38|70->38|71->39
                  -- GENERATED --
              */
          