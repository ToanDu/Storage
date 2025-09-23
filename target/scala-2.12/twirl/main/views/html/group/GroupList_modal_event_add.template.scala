
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

object GroupList_modal_event_add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addEventModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-fullscreen">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("event.title.addNewEvent")),format.raw/*5.103*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-1"></div>
          <div class="col-md-6">
            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" style="width: 100%; background-color:#858687; color: #FFFFFF; text-transform: uppercase;">"""),_display_(/*12.137*/Messages("event.title.default")),format.raw/*12.168*/("""</span>
            </div>

            <div class="card" style="padding: 10px; border: 1px solid #858687;">
              <div class="row mb-2">
                <div class="col-sm-4">
                  <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*18.87*/Messages("event.title.name")),format.raw/*18.115*/("""</label>
                  <input id="nameEventNew" type="text" class="form-control" maxlength="50" autocomplete="off" required>
                  <h7 class="textNote">"""),_display_(/*20.41*/Messages("manage.group.org.30char")),format.raw/*20.76*/("""</h7>
                </div>
                <div class="col-sm-4">
                  <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*23.87*/Messages("event.title.under")),format.raw/*23.116*/("""</label>
                  <select id="chooseGroupEventAdd" class="form-select mb-3" aria-label="Default select example"></select>
                </div>
                <div class="col-sm-4">
                  <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*27.87*/Messages("event.title.status")),format.raw/*27.117*/("""</label>
                  <select id="chooseStatusEventAdd" class="form-select mb-3" aria-label="Default select example">
                    <option value="true">"""),_display_(/*29.43*/Messages("event.title.statusActive")),format.raw/*29.79*/("""</option>
                    <option value="false">"""),_display_(/*30.44*/Messages("event.title.statusUnactive")),format.raw/*30.82*/("""</option>
                  </select>
                </div>
                <div class="col-sm-4">
                  <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*34.87*/Messages("Onclick")),format.raw/*34.106*/("""</label>
                  <select id="chooseOnclickAdd" class="form-select mb-3" onchange="selectTypeOnclick(this)">
                    <option value="true">"""),_display_(/*36.43*/Messages("Có")),format.raw/*36.57*/("""</option>
                    <option value="false" selected>"""),_display_(/*37.53*/Messages("Không")),format.raw/*37.70*/("""</option>
                  </select>
                </div>
                <div class="col-sm-4">
                  <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*41.87*/Messages("Kiểu sự kiện")),format.raw/*41.111*/("""</label>
                  <select id="chooseTypeEventAdd" class="form-select mb-3" onchange="selectTypeEvent(this)">
                    <option value="event" selected>"""),_display_(/*43.53*/Messages("Sự kiện event")),format.raw/*43.78*/("""</option>
                    <option value="schedule">"""),_display_(/*44.47*/Messages("Lập lịch schedule")),format.raw/*44.76*/("""</option>
                  </select>
                </div>
                <div class="col-sm-4">
                  <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*48.87*/Messages("Số lần lặp lại")),format.raw/*48.113*/("""</label>
                  <input id="retryAdd" type="number" class="form-control" required>
                </div>
              </div>
            </div>

            <div id="tabConditionAdd">
              <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
                <span class="input-group-text" style="width: 100%; background-color:#858687; color: #FFFFFF; text-transform: uppercase;">"""),_display_(/*56.139*/Messages("event.title.condition")),format.raw/*56.172*/("""</span>
              </div>

              <div class="card" style="padding: 10px; border: 1px solid #858687;">
                <div id="conditionList">
                  <div class="row mb-2">
                    <div class="col-sm-11">
                      <div class="row">
                        <div class="col-sm-3">
                          <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*65.95*/Messages("event.title.device")),format.raw/*65.125*/("""</label>
                          <select id="listDevice1" onchange="getListAttrDevice(1)" class="form-select mb-3 device-list" aria-label="Default select example"></select>
                        </div>
                        <div class="col-sm-3">
                          <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*69.95*/Messages("event.title.attr")),format.raw/*69.123*/("""</label>
                          <select id="listAttributeDevice1" class="form-select mb-3 var-list" aria-label="Default select example"></select>
                        </div>
                        <div class="col-sm-3">
                          <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*73.95*/Messages("event.title.condition1")),format.raw/*73.129*/("""</label>
                          <select id="listConditionDevice1" class="form-select mb-3 op-list" aria-label="Default select example">
                            <option value="=">"""),_display_(/*75.48*/Messages("event.operator.equal")),format.raw/*75.80*/("""</option>
                            <option value=">">"""),_display_(/*76.48*/Messages("event.operator.greater")),format.raw/*76.82*/("""</option>
                            <option value="<">"""),_display_(/*77.48*/Messages("event.operator.less")),format.raw/*77.79*/("""</option>
                          </select>
                        </div>
                        <div class="col-sm-3">
                          <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*81.95*/Messages("event.title.value")),format.raw/*81.124*/("""</label>
                          <input id="valueConditionDevice1" type="text" class="form-control input-threshold" autocomplete="off" required>
                        </div>
                      </div>
                    </div>
                    <div class="col-sm-1">
                      <div class="col-sm-12">
                        <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*88.93*/Messages(" ")),format.raw/*88.106*/("""</label>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-sm-11">
                  <button type="button" class="btn btn-dark" style="font-size: 24px; cursor: pointer; float: right" id="addMoreCondition">
                    <i class="bx bx-plus me-0"></i>
                  </button>
                </div>
              </div>
            </div>

            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" style="width: 100%; background-color:#858687; color: #FFFFFF; text-transform: uppercase;">"""),_display_(/*102.137*/Messages("event.column.title.action")),format.raw/*102.174*/("""</span>
            </div>

            <div class="card" style="padding: 10px; border: 1px solid #858687;">
              <div id="actionList">
                <div class="row mb-2">
                  <div class="col-sm-11">
                    <div class="row">
                      <div class="col-sm-3">
                        <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*111.93*/Messages("event.column.title.hd")),format.raw/*111.126*/("""</label>
                        <select id="listAction" class="form-select mb-3 actionType-list" aria-label="Default select example">
                          <option value="email">Email</option>
                          <option value="sms">Sms</option>
                          <option value="mqtt">Mqtt</option>
                        </select>
                      </div>
                      <div class="col-sm-3">
                        <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*119.93*/Messages("event.column.title.address")),format.raw/*119.131*/("""</label>
                        <input id="addressAction" type="text" class="form-control input-receiver" autocomplete="off" required>
                      </div>
                      <div class="col-sm-3">
                        <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*123.93*/Messages("event.column.title.title")),format.raw/*123.129*/("""</label>
                        <input id="titleAction" type="text" class="form-control input-subject" autocomplete="off" required>
                      </div>
                      <div class="col-sm-3">
                        <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*127.93*/Messages("event.column.title.content")),format.raw/*127.131*/("""</label>
                        <input id="contentAction" type="text" class="form-control input-message" autocomplete="off" required>
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-1">
                  </div>
                </div>
              </div>
              <div class="col-sm-11">
                <button type="button" class="btn btn-dark" style="font-size: 24px; cursor: pointer; float: right" id="addMoreAction">
                  <i class="bx bx-plus me-0"></i>
                </button>
              </div>
            </div>
          </div>

          <div class="col-md-4">
            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" style="width: 100%; background-color:#858687; color: #FFFFFF; text-transform: uppercase;">"""),_display_(/*146.137*/Messages("event.column.title.time")),format.raw/*146.172*/("""</span>
            </div>

            <div class="card" style="padding: 10px; border: 1px solid #858687;">
              <div class="row">
                <div class="col-sm-12">
                  <div class="row">
                    <div class="col-md-4 mb-3">
                      <input type="checkbox" class="btn-check" id="monday" name="weekdays" value="monday" autocomplete="off"/>
                      <label style="width: 100%;" class="btn btn-danger btn-weekday" for="monday">Thứ Hai</label>
                    </div>
                    <div class="col-md-4 mb-3">
                      <input type="checkbox" class="btn-check" id="tuesday" name="weekdays" value="tuesday" autocomplete="off"/>
                      <label style="width: 100%;" class="btn btn-danger btn-weekday" for="tuesday">Thứ Ba</label>
                    </div>
                    <div class="col-md-4 mb-3">
                      <input type="checkbox" class="btn-check" id="wednesday" name="weekdays" value="wednesday" autocomplete="off"/>
                      <label style="width: 100%;" class="btn btn-danger btn-weekday" for="wednesday">Thứ Tư</label>
                    </div>
                    <div class="col-md-4 mb-3">
                      <input type="checkbox" class="btn-check" id="thursday" name="weekdays" value="thursday" autocomplete="off"/>
                      <label style="width: 100%;" class="btn btn-danger btn-weekday" for="thursday">Thứ Năm</label>
                    </div>
                    <div class="col-md-4 mb-3">
                      <input type="checkbox" class="btn-check" id="friday" name="weekdays" value="friday" autocomplete="off"/>
                      <label style="width: 100%;" class="btn btn-danger btn-weekday" for="friday">Thứ Sáu</label>
                    </div>
                    <div class="col-md-4 mb-3">
                      <input type="checkbox" class="btn-check" id="saturday" name="weekdays" value="saturday" autocomplete="off"/>
                      <label style="width: 100%;" class="btn btn-danger btn-weekday" for="saturday">Thứ Bảy</label>
                    </div>
                    <div class="col-md-4 mb-3">
                      <input type="checkbox" class="btn-check" id="sunday" name="weekdays" value="sunday" autocomplete="off"/>
                      <label style="width: 100%;" class="btn btn-danger btn-weekday" for="sunday">Chủ nhật</label>
                    </div>
                  </div>
                </div>
                <div class="col-sm-12">
                  <div class="row" style="">
                    """),format.raw/*185.48*/("""
                      """),format.raw/*186.75*/("""
                    """),format.raw/*187.31*/("""
                    """),format.raw/*188.21*/("""<div class="col-sm-6 mt-4 align-items-center">
                      <label class="form-label text-darker text-center">"""),_display_(/*189.74*/Messages("event.start")),format.raw/*189.97*/("""</label>
                      <input value="08:00" style="padding: .375rem .5rem;" id="startTime" name="startTime" type="time" class="form-control" autocomplete="off" required>
                    </div>
                    <div class="col-sm-6 mt-4 align-items-center" id="tabTimeEnd">
                      <label class="form-label text-darker text-center">"""),_display_(/*193.74*/Messages("event.end")),format.raw/*193.95*/("""</label>
                      <input value="23:59" style="padding: .375rem .5rem;" id="endTime" name="endTime" type="time" class="form-control" autocomplete="off" required>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-1"></div>

          <div class="col-md-12">
            <div class="d-flex flex-column align-items-center text-center">
              <div class="modal-footer">
                <button type="button" class="btn btn-success" onclick="postCreateEvent()" id="buttonCreateEvent">"""),_display_(/*206.115*/Messages("Tạo event")),format.raw/*206.136*/("""</button>
                <button type="button" class="btn btn-success" onclick="postCreateSchedule()" id="buttonCreateSchedule" style="display: none;">"""),_display_(/*207.144*/Messages("Tạo schedule")),format.raw/*207.168*/("""</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*208.90*/Messages("btnClose")),format.raw/*208.110*/("""</button>
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
                  DATE: Mon Sep 22 16:32:42 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList_modal_event_add.scala.html
                  HASH: 27c4a0265ed2cb727f501ad65ef6dc1577d66c6d
                  MATRIX: 1056->0|1429->347|1485->382|1896->765|1949->796|2247->1067|2297->1095|2493->1264|2549->1299|2730->1453|2781->1482|3087->1761|3139->1791|3331->1956|3388->1992|3468->2045|3527->2083|3740->2269|3781->2288|3968->2448|4003->2462|4092->2524|4130->2541|4343->2727|4389->2751|4586->2921|4632->2946|4715->3002|4765->3031|4978->3217|5026->3243|5489->3678|5544->3711|5991->4131|6043->4161|6417->4508|6467->4536|6815->4857|6871->4891|7084->5077|7137->5109|7221->5166|7276->5200|7360->5257|7412->5288|7657->5506|7708->5535|8150->5950|8185->5963|8885->6634|8945->6671|9374->7072|9430->7105|9976->7623|10037->7661|10367->7963|10426->7999|10753->8298|10814->8336|11743->9236|11801->9271|14435->11903|14487->11978|14537->12009|14587->12030|14735->12150|14780->12173|15169->12534|15212->12555|15852->13166|15896->13187|16078->13340|16125->13364|16252->13463|16295->13483
                  LINES: 33->1|37->5|37->5|44->12|44->12|50->18|50->18|52->20|52->20|55->23|55->23|59->27|59->27|61->29|61->29|62->30|62->30|66->34|66->34|68->36|68->36|69->37|69->37|73->41|73->41|75->43|75->43|76->44|76->44|80->48|80->48|88->56|88->56|97->65|97->65|101->69|101->69|105->73|105->73|107->75|107->75|108->76|108->76|109->77|109->77|113->81|113->81|120->88|120->88|134->102|134->102|143->111|143->111|151->119|151->119|155->123|155->123|159->127|159->127|178->146|178->146|217->185|218->186|219->187|220->188|221->189|221->189|225->193|225->193|238->206|238->206|239->207|239->207|240->208|240->208
                  -- GENERATED --
              */
          