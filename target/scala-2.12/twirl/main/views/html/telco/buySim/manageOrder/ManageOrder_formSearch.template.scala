
package views.html.telco.buySim.manageOrder

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
/*1.2*/import vn.m2m.common.models.User

object ManageOrder_formSearch extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<div class="card">
  <div class="card-body">
    <span class="text-search">"""),_display_(/*5.32*/Messages("history.search.info")),format.raw/*5.63*/("""</span>
    <input id="gpkd" type="text" class="form-control" readonly hidden>

    <div class="row mt-3">
      """),format.raw/*9.39*/("""
        """),format.raw/*10.36*/("""
          """),format.raw/*11.43*/("""
          """),format.raw/*12.101*/("""
          """),format.raw/*13.37*/("""
            """),format.raw/*14.129*/("""
          """),format.raw/*15.21*/("""
        """),format.raw/*16.19*/("""
      """),format.raw/*17.17*/("""
      """),format.raw/*18.7*/("""<div class="row">
        <!-- Cột trái -->
        <div class="col-md-6">
          <!-- Mã đơn hàng -->
          <div class="mb-3 row">
            <label for="orderId" class="col-sm-2 col-form-label">"""),_display_(/*23.67*/Messages("history.search.order.code")),format.raw/*23.104*/("""</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="orderId" placeholder=""""),_display_(/*25.82*/Messages("history.search.placeholder.enter.content")),format.raw/*25.134*/("""" maxlength="256" oninput="if(this.value.length > 256) this.value = this.value.slice(0, 256);">
            </div>
          </div>
      
          <!-- Loại đơn hàng -->
          <div class="mb-3 row">
            <label for="orderType" class="col-sm-2 col-form-label">"""),_display_(/*31.69*/Messages("history.search.order.type")),format.raw/*31.106*/("""</label>
            <div class="col-sm-10">
              <select id="orderType" class="form-control">
                <option value="">"""),_display_(/*34.35*/Messages("history.search.select.choose")),format.raw/*34.75*/("""</option>
                <option value="order">"""),_display_(/*35.40*/Messages("history.search.order.type.order")),format.raw/*35.83*/("""</option>
                <option value="change">"""),_display_(/*36.41*/Messages("history.search.order.type.change")),format.raw/*36.85*/("""</option>
              </select>
            </div>
          </div>
        </div>
      
        <!-- Cột phải -->
        <div class="col-md-6">
          <!-- Thời gian -->
          <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">"""),_display_(/*46.53*/Messages("history.search.time")),format.raw/*46.84*/("""</label>
            <div class="col-sm-10">
              <div class="row">
                <div class="col-sm-6">
                  <input type="text" class="form-control datetimepicker" id="fromDate" placeholder=""""),_display_(/*50.102*/Messages("history.search.placeholder.from.date")),format.raw/*50.150*/("""">
                </div>
                <div class="col-sm-6">
                  <input type="text" class="form-control datetimepicker" id="toDate" placeholder=""""),_display_(/*53.100*/Messages("history.search.placeholder.to.date")),format.raw/*53.146*/("""">
                </div>
              </div>
            </div>
          </div>
      
          <!-- Trạng thái -->
          <div class="mb-3 row">
            <label for="status" class="col-sm-2 col-form-label">"""),_display_(/*61.66*/Messages("history.search.status")),format.raw/*61.99*/("""</label>
            <div class="col-sm-10">
              <select id="status" class="form-control">
                <option value="">"""),_display_(/*64.35*/Messages("history.search.select.choose")),format.raw/*64.75*/("""</option>
                <option value="1">"""),_display_(/*65.36*/Messages("history.search.status.success")),format.raw/*65.77*/("""</option>
                <option value="0">"""),_display_(/*66.36*/Messages("history.search.status.failed")),format.raw/*66.76*/("""</option>
              </select>
            </div>
          </div>
        </div>
      </div>
      
    </div>
    <div class="d-flex flex-column align-items-center text-center">
      <div class="">
        <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF;" onclick="onlickButtonSearch()">"""),_display_(/*76.135*/Messages("history.search.button.search")),format.raw/*76.175*/("""</button>
        <button type="button" id="btn_export_data" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="onclickButtonExport()">"""),_display_(/*77.157*/Messages("Export")),format.raw/*77.175*/("""</button>
        <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="resetFormSearch()">"""),_display_(/*78.132*/Messages("history.search.button.reset")),format.raw/*78.171*/("""</button>
      </div>
    </div>
  </div>
</div>"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:51 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/buySim/manageOrder/ManageOrder_formSearch.scala.html
                  HASH: 91d75e9fd82dacb46179c5238f0613991f2ff66d
                  MATRIX: 676->1|1028->35|1141->53|1168->54|1270->130|1321->161|1461->306|1498->342|1537->385|1577->486|1616->523|1658->652|1697->673|1734->692|1769->709|1803->716|2035->921|2094->958|2247->1084|2321->1136|2621->1409|2680->1446|2845->1584|2906->1624|2982->1673|3046->1716|3123->1766|3188->1810|3478->2073|3530->2104|3775->2321|3845->2369|4037->2533|4105->2579|4350->2797|4404->2830|4566->2965|4627->3005|4699->3050|4761->3091|4833->3136|4894->3176|5261->3515|5323->3555|5517->3721|5557->3739|5726->3880|5787->3919
                  LINES: 24->1|29->2|34->2|35->3|37->5|37->5|41->9|42->10|43->11|44->12|45->13|46->14|47->15|48->16|49->17|50->18|55->23|55->23|57->25|57->25|63->31|63->31|66->34|66->34|67->35|67->35|68->36|68->36|78->46|78->46|82->50|82->50|85->53|85->53|93->61|93->61|96->64|96->64|97->65|97->65|98->66|98->66|108->76|108->76|109->77|109->77|110->78|110->78
                  -- GENERATED --
              */
          