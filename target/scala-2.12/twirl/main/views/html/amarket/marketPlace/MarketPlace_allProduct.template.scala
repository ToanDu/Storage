
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

object MarketPlace_allProduct extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-md-12">
  <div class="row" >
    <img src=""""),_display_(/*3.16*/routes/*3.22*/.Assets.versioned("images/market/banner.svg")),format.raw/*3.67*/("""" class="card-img cursor-pointer" alt="..." style="padding: 0px;">
  </div>

  <div class="row mt-3">
    <div class="col-md-12" style="padding: 0px;">
      <div class="sort-bar">
        <span>"""),_display_(/*9.16*/Messages("Sắp xếp theo")),format.raw/*9.40*/("""</span>
        <select class="form-select ml-3" id="priceSortAllProduct" style="width: 200px;" onchange="getAllProduct()">
          <option value="ASC">"""),_display_(/*11.32*/Messages("Giá: thấp nhất")),format.raw/*11.58*/("""</option>
          <option value="DESC">"""),_display_(/*12.33*/Messages("Giá: cao nhất")),format.raw/*12.58*/("""</option>
        </select>
      </div>
    </div>
  </div>

  <div class="row mt-3" style="display: flex;">
    <div class="col-md-12">
      <div class="row" id="girdAllList"></div>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/amarket/marketPlace/MarketPlace_allProduct.scala.html
                  HASH: f581bc0da4cfb1ec8efb232ffefe4fdc5e389c38
                  MATRIX: 1067->0|1153->60|1167->66|1232->111|1454->307|1498->331|1680->486|1727->512|1796->554|1842->579
                  LINES: 33->1|35->3|35->3|35->3|41->9|41->9|43->11|43->11|44->12|44->12
                  -- GENERATED --
              */
          