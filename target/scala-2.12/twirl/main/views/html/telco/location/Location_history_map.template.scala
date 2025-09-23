
package views.html.telco.location

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

object Location_history_map extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*18.18*/fromTime/*18.26*/ = {{
                  import java.util.Calendar
                  import java.text.SimpleDateFormat

                  val today = Calendar.getInstance
                  today.add(Calendar.DATE,-6);
                  val curTimeFormat = new SimpleDateFormat("dd/MM/yyyy")
                  curTimeFormat.format(today.getTime)
                }};def /*31.18*/toTime/*31.24*/ = {{
                  import java.util.Calendar
                  import java.text.SimpleDateFormat
                  //import java.util.TimeZone

                  val today = Calendar.getInstance()
                  // today.setTimeZone(TimeZone.getTimeZone("GMT+7"))
                  val curTimeFormat = new SimpleDateFormat("dd/MM/yyyy")
                  curTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT+7"));
                  curTimeFormat.format(today.getTime)
                }};
Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="mapHistoryModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <span class="modal-title" id="exampleModalLabel">"""),_display_(/*5.59*/Messages("Lịch sử vị trí")),format.raw/*5.85*/("""</span>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" style="position: absolute;top: 30px;right: 15px; background-color: #aaa;"></button>
      </div>
      <div class="modal-body" style="padding-top: 0px;">
        <div class="card-body" style="padding-bottom: 0px;">
          <div class="row">
            <div class="col-md-4">
              <div class="row">
                <label class="col-form-label title-section-2">"""),_display_(/*13.64*/Messages("Thuê bao")),format.raw/*13.84*/("""</label>
                <input id="isdnHistoryMap" type="text" class="form-control input-form" readonly>
                <input id="serialHistoryMap" type="text" class="form-control input-form" readonly hidden>
              </div>
              <div class="row">
                """),format.raw/*26.18*/("""
                """),format.raw/*27.17*/("""<label class="col-form-label title-section-2">"""),_display_(/*27.64*/Messages("Từ ngày")),format.raw/*27.83*/("""</label>
                <input class="form-control datetimepicker" type="text" id="fromDateHistoryMap" value=""""),_display_(/*28.104*/fromTime),format.raw/*28.112*/("""" placeholder="Đến ngày">
              </div>
              <div class="row">
                """),format.raw/*41.18*/("""
                """),format.raw/*42.17*/("""<label class="col-form-label title-section-2">"""),_display_(/*42.64*/Messages("Đến ngày")),format.raw/*42.84*/("""</label>
                <input class="form-control datetimepicker" type="text" id="toDateHistoryMap" value=""""),_display_(/*43.102*/toTime),format.raw/*43.108*/("""" placeholder="Đến ngày">
              </div>
              <div class="row mt-3">
                <button type="button" class="btn btn-search" onclick="searchHistoryMap()" style="width: 100%">"""),_display_(/*46.112*/Messages("btnSearch")),format.raw/*46.133*/("""</button>
              </div>
              <div class="row mt-3" style="height: 258px;">
                <div class="table-responsive" style="padding: 0; height: 100%;">
                  <table class="table table-striped" id="listHistoryMapTable" style="width: 100%; margin-bottom: 0px; max-height: 258px;">
                    <thead style="background-color: #eee;">
                      <tr>
                        <th>STT</th>
                        <th>Thời gian</th>
                        <th>Vị trí</th>
                      </tr>
                    </thead>
                    <tbody></tbody>
                  </table>
                  <h5 class="mt-3" id="notiNotHistoryMap" style="text-align: center;"></h5>
                </div>
              </div>
            </div>
            <div class="col-md-8">
              <div class="card" style="height: 550px;">
                <div class="big-map" id="map-history" style="height: 100%;"></div>
              </div>
            </div>

          </div>
        </div>
      </div>

    </div>
  </div> <!-- modal-bialog .// -->
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/location/Location_history_map.scala.html
                  HASH: 740b2bcfd9cefc8185f7044173d41148826c2857
                  MATRIX: 1046->1158|1063->1166|1423->1810|1438->1816|1959->0|2343->358|2389->384|2888->856|2929->876|3238->1511|3283->1528|3357->1575|3397->1594|3537->1706|3567->1714|3690->2308|3735->2325|3809->2372|3850->2392|3988->2502|4016->2508|4239->2703|4282->2724
                  LINES: 32->18|32->18|40->31|40->31|51->1|55->5|55->5|63->13|63->13|68->26|69->27|69->27|69->27|70->28|70->28|73->41|74->42|74->42|74->42|75->43|75->43|78->46|78->46
                  -- GENERATED --
              */
          