
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

object MarketPlace_solution extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-md-12">
  <div class="row">
    <img src=""""),_display_(/*3.16*/routes/*3.22*/.Assets.versioned("images/market/banner.svg")),format.raw/*3.67*/("""" class="card-img cursor-pointer" alt="..." style="padding: 0px;">
  </div>
  <div class="row mt-3" style="display: flex;">
    <div class="col-md-3">
      <div class="row" style="margin-top: 10px;">
        <h6 class="text-group">"""),_display_(/*8.33*/Messages("Theo nhóm sản phẩm")),format.raw/*8.63*/("""</h6>
        <div class="mt-3" id="listGroupSolution"></div>
      </div>
    </div>
    <div class="col-md-9">
      <div class="row">
        <div class="col-md-12" style="padding: 0px; margin-left: 5px;">
          <div class="sort-bar" style="background-color: white">
            <h6>"""),_display_(/*16.18*/Messages("Sắp xếp theo")),format.raw/*16.42*/("""</h6>
            <select class="form-select ml-3" id="priceSortSolution" style="width: 200px;" onchange="getListSolution()">
              <option value="ASC">"""),_display_(/*18.36*/Messages("Giá: thấp nhất")),format.raw/*18.62*/("""</option>
              <option value="DESC">"""),_display_(/*19.37*/Messages("Giá: cao nhất")),format.raw/*19.62*/("""</option>
            </select>
          </div>
        </div>
      </div>
      <div class="row mt-3" id="girdSolutionList"></div>
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
                  DATE: Mon Sep 22 16:32:40 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/amarket/marketPlace/MarketPlace_solution.scala.html
                  HASH: 0fd9aad185b26dabf68180e45373f80834191ebc
                  MATRIX: 1065->0|1150->59|1164->65|1229->110|1488->343|1538->373|1856->664|1901->688|2089->849|2136->875|2209->921|2255->946
                  LINES: 33->1|35->3|35->3|35->3|40->8|40->8|48->16|48->16|50->18|50->18|51->19|51->19
                  -- GENERATED --
              */
          