
package views.html.telco.role.account

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

object InfoDataAccount extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="infoDataAccountModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
    <script src=""""),_display_(/*2.19*/routes/*2.25*/.Assets.versioned("javascripts/views/telco/role/accountList/infoDataAccount.js")),format.raw/*2.105*/("""" type="text/javascript"></script>
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header" style=" border-radius: 16px 16px 0px 0px;">
                <span class="modal-title text-black" id="myModalLabel">"""),_display_(/*6.73*/Messages("Lưu lượng sử dụng")),format.raw/*6.102*/("""</span>
            </div>

            <div class="modal-body">
                <div class="relative flex flex-col rounded-xl bg-white bg-clip-border shadow-md">
                    <div class="row" style="padding: 10px">
                        <div class="col text-left" style="display: contents">Thuê bao:</div>
                        <div class="col text-left" style="color: red;text-decoration: underline;" id="numberSubcriber"></div>
                    </div>
                    <div class="row">
                        <div class="col-sm-5 text-left" style="font-weight: bold">Lịch sử sử dụng lưu lượng</div>
                        <div class="col d-inline-flex text-center justify-content-between align-items-center" id="group">
                        </div>
                        <div class="col" >
                            <input class="form-control datetimepicker datetimepicker1" type="text" id="staDatetimeFrom1" value="" placeholder="Từ ngày" onChange="checkDate()">
                        </div>
                        <div class="col" >
                            <input class="form-control datetimepicker datetimepicker1" type="text" id="staDatetimeTo1" value="" placeholder="Đến ngày" onChange="checkDate()">
                        </div>
"""),format.raw/*25.51*/("""
"""),format.raw/*26.182*/("""
"""),format.raw/*27.35*/("""
                    """),format.raw/*28.21*/("""</div>
                    <div class="pt-6 px-2 pb-0" id="chartDataMonthly">
                        <div id="bar-chart"></div>
                    </div>
                    <div id="chartReport" class="text-center">
                        <canvas id="myChart"></canvas>
                    </div>
                </div>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-cancle" data-bs-dismiss="modal" onclick="closeModal()">"""),_display_(/*39.110*/Messages("btnClose")),format.raw/*39.130*/("""</button>
            </div>
        </div>
    </div>

</div>
<script src=""""),_display_(/*45.15*/routes/*45.21*/.Assets.versioned("javascripts/views/telco/role/accountList/infoDataAccount.js")),format.raw/*45.101*/("""" type="text/javascript"></script>
<script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/account/InfoDataAccount.scala.html
                  HASH: cb36d19959994423acab4a20c12d0bc8d2aa4d76
                  MATRIX: 1059->0|1283->198|1297->204|1398->284|1689->549|1739->578|3040->1901|3070->2083|3099->2118|3148->2139|3668->2631|3710->2651|3814->2728|3829->2734|3931->2814
                  LINES: 33->1|34->2|34->2|34->2|38->6|38->6|57->25|58->26|59->27|60->28|71->39|71->39|77->45|77->45|77->45
                  -- GENERATED --
              */
          