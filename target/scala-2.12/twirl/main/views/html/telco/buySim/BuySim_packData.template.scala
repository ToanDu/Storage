
package views.html.telco.buySim

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

object BuySim_packData extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-lg-11 col-md-8">
  <div class="row">
    <div class="col-md-12 mb-4">
      <span class="display-4 title-section-1 text-darker">"""),_display_(/*4.60*/Messages("product.info.section.title")),format.raw/*4.98*/("""</span>
    </div>
  </div>

  <form id="content_pack">
    <div id="choose_pack_1">
      <div class="row">
        <div class="col-md-6">
          <div class="row">
            <label class="col-sm-4 col-form-label title-section-2" style="text-align: left">"""),_display_(/*13.94*/Messages("product.package")),format.raw/*13.121*/(""" """),format.raw/*13.122*/("""<span class="text-red">"""),_display_(/*13.146*/Messages("field.required")),format.raw/*13.172*/("""</span></label>
            <div class="col-sm-8">
              <select class="form-control" style="width: 100%;" id="goi_cuoc_1" name="productCode_1" onchange="getReasonWithPack(1)">
                <option value="">"""),_display_(/*16.35*/Messages("product.package.select")),format.raw/*16.69*/("""</option>
              </select>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="row m-b-3">
            <label class="col-sm-6 col-form-label title-section-2">"""),_display_(/*23.69*/Messages("product.sim.quantity")),format.raw/*23.101*/("""<span class="text-red">"""),_display_(/*23.125*/Messages("field.required")),format.raw/*23.151*/("""</span></label>
            <div class="col-sm-6">
              <input id="so_luong_1" stt="1" type="number" name="numIsdn_1" class="form-control input-form count_pack_data" min="1" max="1000000"  value="1" onchange="changeCountPackData(1)" onKeyPress="if(this.value.length==8) return false;">
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="row m-b-3" style="float: right;">
            """),format.raw/*31.169*/("""
          """),format.raw/*32.11*/("""</div>
        </div>
      </div>
      <div class="row mt-3">
        <label class="col-sm-2 col-form-label title-section-2" style="text-align: left">"""),_display_(/*36.90*/Messages("product.connection.reason")),format.raw/*36.127*/("""<span class="text-red">"""),_display_(/*36.151*/Messages("field.required")),format.raw/*36.177*/("""</span></label>
        <div class="col-sm-7">
          <select class="form-control choose_reason" style="width: 100%;" id="ly_do_dau_noi_1" name="regReasonCode_1" onchange="getListSaleService(1)">
            <option value="">"""),_display_(/*39.31*/Messages("product.connection.reason.select")),format.raw/*39.75*/("""</option>
          </select>
        </div>
        <div class="col-sm-2">
          <button type="button" class="btn btn-search" style="background: #EA0033; color: #FFFFFF;" onclick="addContentPackData()">"""),_display_(/*43.133*/Messages("action.add")),format.raw/*43.155*/("""</button>
        </div>
      </div>
      <div class="row mt-4">
        <div class="col-md-12" id="ds_mat_hang_1"></div>
      </div>
      <hr>
    </div>
  </form>
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
                  DATE: Mon Sep 22 16:32:51 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/buySim/BuySim_packData.scala.html
                  HASH: fd307321379c63a897218dc4a90f5d3af68c4960
                  MATRIX: 1053->0|1224->145|1282->183|1570->444|1619->471|1649->472|1701->496|1749->522|1995->741|2050->775|2295->993|2349->1025|2401->1049|2449->1075|2923->1676|2962->1687|3142->1840|3201->1877|3253->1901|3301->1927|3557->2156|3622->2200|3858->2408|3902->2430
                  LINES: 33->1|36->4|36->4|45->13|45->13|45->13|45->13|45->13|48->16|48->16|55->23|55->23|55->23|55->23|63->31|64->32|68->36|68->36|68->36|68->36|71->39|71->39|75->43|75->43
                  -- GENERATED --
              */
          