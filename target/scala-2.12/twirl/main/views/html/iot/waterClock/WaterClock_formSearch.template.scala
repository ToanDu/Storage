
package views.html.iot.waterClock

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

object WaterClock_formSearch extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*5.10*/fromTime/*5.18*/ = {{
          import java.util.Calendar
          import java.text.SimpleDateFormat

          val today = Calendar.getInstance
          today.add(Calendar.DATE,-29);
          val curTimeFormat = new SimpleDateFormat("dd-MM-yyyy")
          curTimeFormat.format(today.getTime)
        }};def /*14.10*/toTime/*14.16*/ = {{
          import java.util.Calendar
          import java.text.SimpleDateFormat
          //import java.util.TimeZone

          val today = Calendar.getInstance()
          // today.setTimeZone(TimeZone.getTimeZone("GMT+7"))
          val curTimeFormat = new SimpleDateFormat("dd-MM-yyyy")
          curTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT+7"));
          curTimeFormat.format(today.getTime)
        }};
Seq[Any](format.raw/*1.1*/("""<div class="card ">
  <div class="card-body">
    <div class="col-12">
      <div class="row">
        """),format.raw/*13.10*/("""
        """),format.raw/*24.10*/("""

        """),format.raw/*26.9*/("""<div class="form-group col-md-2">
          <div class="row">
            <label class="col-md-4 col-form-label" style="text-align: right">"""),_display_(/*28.79*/Messages("Form")),format.raw/*28.95*/("""</label>
            <div class="col-md-8">
              <div class="form-group">
                <input class="result form-control" type="text" id="date_timepicker_start" value=""""),_display_(/*31.99*/fromTime),format.raw/*31.107*/("""">
              </div>
            </div>
          </div>
        </div>

        <div class="form-group col-md-2">
          <div class="row">
            <label class="col-md-4 col-form-label" style="text-align: right">"""),_display_(/*39.79*/Messages("To")),format.raw/*39.93*/("""</label>
            <div class="col-md-8">
              <div class="form-group has-default">
                <input class="result form-control" type="text" id="date_timepicker_end" value=""""),_display_(/*42.97*/toTime),format.raw/*42.103*/("""">
              </div>
            </div>
          </div>
        </div>

        <div class="form-group col-md-7">
          <div class="row">
            <label class="col-md-3 col-form-label" style="text-align: right">"""),_display_(/*50.79*/Messages("Device")),format.raw/*50.97*/("""</label>
            <div class="col-md-9">
              <div class="form-group has-default" id="selectClock">
                <select id="chooseDeviceClock" multiple class="single-select" style="width: 100%"></select>
              </div>
            </div>
          </div>
        </div>

        <div class="form-group col-md-1">
          <button type="submit" class="btn btn-fill btn-danger" onclick="getHistoryClock()" id="buttonSearchHistory">"""),_display_(/*60.119*/Messages("Tìm ")),format.raw/*60.135*/("""</button>
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
                  DATE: Mon Sep 22 16:32:46 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/waterClock/WaterClock_formSearch.scala.html
                  HASH: 55446e79199b411d59af150d26c3bf63fba6947c
                  MATRIX: 1046->104|1062->112|1367->412|1382->418|1831->0|1962->402|1999->838|2036->848|2203->988|2240->1004|2448->1185|2478->1193|2729->1417|2764->1431|2982->1622|3010->1628|3261->1852|3300->1870|3781->2323|3819->2339
                  LINES: 32->5|32->5|40->14|40->14|51->1|55->13|56->24|58->26|60->28|60->28|63->31|63->31|71->39|71->39|74->42|74->42|82->50|82->50|92->60|92->60
                  -- GENERATED --
              */
          