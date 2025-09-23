
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

object MarketPlace_device extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-md-12">
  <div class="row">
    <img src=""""),_display_(/*3.16*/routes/*3.22*/.Assets.versioned("images/market/banner.svg")),format.raw/*3.67*/("""" class="card-img cursor-pointer" alt="...">
  </div>

  <div class="row mt-3">
    <div class="col-md-12">
      <div class="sort-bar">
        <span>"""),_display_(/*9.16*/Messages("Sắp xếp theo")),format.raw/*9.40*/("""</span>
        <select class="form-select ml-3" id="priceSort" style="width: 200px;" onchange="getListProduct()">
          <option value="ASC">"""),_display_(/*11.32*/Messages("Giá: thấp nhất")),format.raw/*11.58*/("""</option>
          <option value="DESC">"""),_display_(/*12.33*/Messages("Giá: cao nhất")),format.raw/*12.58*/("""</option>
        </select>
      </div>
    </div>
  </div>

  <div class="row mt-3" style="display: flex;">
    <div class="col-md-3">
      <h5 class="mb-0 text-uppercase">"""),_display_(/*20.40*/Messages("BỘ LỌC TÌM KIẾM")),format.raw/*20.67*/("""</h5>
      <div class="card" style="margin-top: 1rem;">
        <div class="card-body" style="font-size: 0.85rem;">
          <h6>"""),_display_(/*23.16*/Messages("Theo nhóm sản phẩm")),format.raw/*23.46*/("""</h6>
          <div id="listGroupProduct"></div>
        </div>
      </div>
    </div>

    <div class="col-md-9">
      <div class="row" id="girdProductList"></div>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/amarket/marketPlace/MarketPlace_device.scala.html
                  HASH: 6969bb5560033e5f231dced680719d29364df54a
                  MATRIX: 1063->0|1148->59|1162->65|1227->110|1405->262|1449->286|1622->432|1669->458|1738->500|1784->525|1987->701|2035->728|2194->860|2245->890
                  LINES: 33->1|35->3|35->3|35->3|41->9|41->9|43->11|43->11|44->12|44->12|52->20|52->20|55->23|55->23
                  -- GENERATED --
              */
          