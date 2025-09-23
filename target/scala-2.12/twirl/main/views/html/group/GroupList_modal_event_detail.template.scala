
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

object GroupList_modal_event_detail extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editEventModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-fullscreen">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("Cập nhật sự kiện")),format.raw/*5.96*/("""</h5>
      </div>
      <div class="modal-body">
        <input id="idEventEdit" type="text" class="form-control" readonly hidden>
        <div class="row">
          <div class="col-md-1"></div>
          <div class="col-md-6">
            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" style="width: 100%; background-color:#858687; color: #FFFFFF; text-transform: uppercase;">"""),_display_(/*13.137*/Messages("event.title.default")),format.raw/*13.168*/("""</span>
            </div>

            <div class="card" style="padding: 10px; border: 1px solid #858687;">
              <div class="row mb-2">
                <div class="col-sm-4">
                  <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*19.87*/Messages("event.title.name")),format.raw/*19.115*/("""</label>
                  <input id="nameEventEdit" type="text" class="form-control" maxlength="50" autocomplete="off" required>
                </div>
                <div class="col-sm-4">
                  <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*23.87*/Messages("event.title.under")),format.raw/*23.116*/("""</label>
                  <select id="chooseGroupEventEdit" class="form-select mb-3" aria-label="Default select example"></select>
                </div>
                <div class="col-sm-4">
                  <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*27.87*/Messages("event.title.status")),format.raw/*27.117*/("""</label>
                  <select id="chooseStatusEventEdit" class="form-select mb-3" aria-label="Default select example">
                    <option value="true">"""),_display_(/*29.43*/Messages("event.title.statusActive")),format.raw/*29.79*/("""</option>
                    <option value="false">"""),_display_(/*30.44*/Messages("event.title.statusUnactive")),format.raw/*30.82*/("""</option>
                  </select>
                </div>
                <div class="col-sm-4">
                  <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*34.87*/Messages("Onclick")),format.raw/*34.106*/("""</label>
                  <select id="chooseOnclickEdit" class="form-select mb-3" onchange="selectTypeOnclickEdit(this)">
                    <option value="true">"""),_display_(/*36.43*/Messages("Có")),format.raw/*36.57*/("""</option>
                    <option value="false">"""),_display_(/*37.44*/Messages("Không")),format.raw/*37.61*/("""</option>
                  </select>
                </div>
                <div class="col-sm-4">
                  <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*41.87*/Messages("Kiểu sự kiện")),format.raw/*41.111*/("""</label>
                  <select id="chooseTypeEventEdit" class="form-select mb-3" onchange="selectTypeEventEdit(this)">
                    <option value="event">"""),_display_(/*43.44*/Messages("Sự kiện event")),format.raw/*43.69*/("""</option>
                    <option value="schedule">"""),_display_(/*44.47*/Messages("Lập lịch schedule")),format.raw/*44.76*/("""</option>
                  </select>
                </div>
                <div class="col-sm-4">
                  <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*48.87*/Messages("Số lần lặp lại")),format.raw/*48.113*/("""</label>
                  <input id="retryEdit" type="number" class="form-control" required>
                </div>
              </div>
            </div>

            <div id="tabConditionEdit">
              <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
                <span class="input-group-text" style="width: 100%; background-color:#858687; color: #FFFFFF; text-transform: uppercase;">"""),_display_(/*56.139*/Messages("event.title.condition")),format.raw/*56.172*/("""</span>
              </div>

              <div class="card" style="padding: 10px; border: 1px solid #858687;">
                <div id="conditionListEdit">
                  <div class="row mb-2">
                    <div class="col-sm-11">
                      <div class="row">
                        <div class="col-sm-3">
                          <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*65.95*/Messages("event.title.device")),format.raw/*65.125*/("""</label>
                        </div>
                        <div class="col-sm-3">
                          <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*68.95*/Messages("event.title.attr")),format.raw/*68.123*/("""</label>
                        </div>
                        <div class="col-sm-3">
                          <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*71.95*/Messages("event.title.condition1")),format.raw/*71.129*/("""</label>
                        </div>
                        <div class="col-sm-3">
                          <label class="col-sm-12 col-form-label" style="text-align: center">"""),_display_(/*74.95*/Messages("event.title.value")),format.raw/*74.124*/("""</label>
                        </div>
                      </div>
                    </div>
                    <div class="col-sm-1"></div>
                  </div>
                </div>
                <div class="col-sm-11">
                  <button type="button" class="btn btn-dark" style="font-size: 24px; cursor: pointer; float: right" id="addMoreConditionEdit">
                    <i class="bx bx-plus me-0"></i>
                  </button>
                </div>
              </div>
            </div>

            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" style="width: 100%; background-color:#858687; color: #FFFFFF; text-transform: uppercase;">"""),_display_(/*90.137*/Messages("event.column.title.action")),format.raw/*90.174*/("""</span>
            </div>

            <div class="card" style="padding: 10px; border: 1px solid #858687;">
              <div id="actionListEdit">

              </div>
              <div class="col-sm-11">
                <button type="button" class="btn btn-dark" style="font-size: 24px; cursor: pointer; float: right" id="addMoreActionEdit">
                  <i class="bx bx-plus me-0"></i>
                </button>
              </div>
            </div>
          </div>

          <div class="col-md-4">
            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" style="width: 100%; background-color:#858687; color: #FFFFFF; text-transform: uppercase;">"""),_display_(/*107.137*/Messages("event.column.title.time")),format.raw/*107.172*/("""</span>
            </div>

            <div class="card" style="padding: 10px; border: 1px solid #858687;">
              <div class="row">
                <div class="col-sm-12">
                  <div class="row">
                    <div class="col-md-4 mb-3">
                      <input type="checkbox" class="btn-check" id="mondayEdit" name="weekdaysEdit" value="mondayEdit" autocomplete="off"/>
                      <label style="width: 100%;" class="btn btn-danger btn-weekday" for="mondayEdit">Thứ Hai</label>
                    </div>
                    <div class="col-md-4 mb-3">
                      <input type="checkbox" class="btn-check" id="tuesdayEdit" name="weekdaysEdit" value="tuesdayEdit" autocomplete="off"/>
                      <label style="width: 100%;" class="btn btn-danger btn-weekday" for="tuesdayEdit">Thứ Ba</label>
                    </div>
                    <div class="col-md-4 mb-3">
                      <input type="checkbox" class="btn-check" id="wednesdayEdit" name="weekdaysEdit" value="wednesdayEdit" autocomplete="off"/>
                      <label style="width: 100%;" class="btn btn-danger btn-weekday" for="wednesdayEdit">Thứ Tư</label>
                    </div>
                    <div class="col-md-4 mb-3">
                      <input type="checkbox" class="btn-check" id="thursdayEdit" name="weekdaysEdit" value="thursdayEdit" autocomplete="off"/>
                      <label style="width: 100%;" class="btn btn-danger btn-weekday" for="thursdayEdit">Thứ Năm</label>
                    </div>
                    <div class="col-md-4 mb-3">
                      <input type="checkbox" class="btn-check" id="fridayEdit" name="weekdaysEdit" value="fridayEdit" autocomplete="off"/>
                      <label style="width: 100%;" class="btn btn-danger btn-weekday" for="fridayEdit">Thứ Sáu</label>
                    </div>
                    <div class="col-md-4 mb-3">
                      <input type="checkbox" class="btn-check" id="saturdayEdit" name="weekdaysEdit" value="saturdayEdit" autocomplete="off"/>
                      <label style="width: 100%;" class="btn btn-danger btn-weekday" for="saturdayEdit">Thứ Bảy</label>
                    </div>
                    <div class="col-md-4 mb-3">
                      <input type="checkbox" class="btn-check" id="sundayEdit" name="weekdaysEdit" value="sundayEdit" autocomplete="off"/>
                      <label style="width: 100%;" class="btn btn-danger btn-weekday" for="sundayEdit">Chủ nhật</label>
                    </div>
                  </div>
                </div>
                <div class="col-sm-12">
                  <div class="row" style="">
                    """),format.raw/*146.48*/("""
                    """),format.raw/*147.73*/("""
                    """),format.raw/*148.31*/("""
                  """),format.raw/*149.19*/("""<div class="col-sm-6 mt-4 align-items-center">
                    <label class="form-label text-darker text-center">"""),_display_(/*150.72*/Messages("event.start")),format.raw/*150.95*/("""</label>
                    <input value="08:00" style="padding: .375rem .5rem;" id="startTimeEdit" name="startTimeEdit" type="time" class="form-control" autocomplete="off" required>
                  </div>
                  <div class="col-sm-6 mt-4 align-items-center" id="tabTimeEndEdit">
                    <label class="form-label text-darker text-center">"""),_display_(/*154.72*/Messages("event.end")),format.raw/*154.93*/("""</label>
                    <input value="23:59" style="padding: .375rem .5rem;" id="endTimeEdit" name="endTimeEdit" type="time" class="form-control" autocomplete="off" required>
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
                <button type="button" class="btn btn-success" onclick="postEditEvent()" id="buttonEditEvent" style="display: none;">"""),_display_(/*167.134*/Messages("Cập nhật event")),format.raw/*167.160*/("""</button>
                <button type="button" class="btn btn-success" onclick="postEditSchedule()" id="buttonEditSchedule" style="display: none;">"""),_display_(/*168.140*/Messages("Cập nhật Schedule")),format.raw/*168.169*/("""</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*169.90*/Messages("btnClose")),format.raw/*169.110*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList_modal_event_detail.scala.html
                  HASH: c0bee71864727e4e596f3165ee0b466aa395c0c9
                  MATRIX: 1059->0|1433->348|1481->376|1974->841|2027->872|2325->1143|2375->1171|2680->1449|2731->1478|3038->1758|3090->1788|3283->1954|3340->1990|3420->2043|3479->2081|3692->2267|3733->2286|3925->2451|3960->2465|4040->2518|4078->2535|4291->2721|4337->2745|4530->2911|4576->2936|4659->2992|4709->3021|4922->3207|4970->3233|5435->3670|5490->3703|5941->4127|5993->4157|6201->4338|6251->4366|6459->4547|6515->4581|6723->4762|6774->4791|7557->5546|7616->5583|8394->6332|8452->6367|11198->9111|11248->9184|11298->9215|11346->9234|11492->9352|11537->9375|11930->9740|11973->9761|12636->10395|12685->10421|12863->10570|12915->10599|13042->10698|13085->10718
                  LINES: 33->1|37->5|37->5|45->13|45->13|51->19|51->19|55->23|55->23|59->27|59->27|61->29|61->29|62->30|62->30|66->34|66->34|68->36|68->36|69->37|69->37|73->41|73->41|75->43|75->43|76->44|76->44|80->48|80->48|88->56|88->56|97->65|97->65|100->68|100->68|103->71|103->71|106->74|106->74|122->90|122->90|139->107|139->107|178->146|179->147|180->148|181->149|182->150|182->150|186->154|186->154|199->167|199->167|200->168|200->168|201->169|201->169
                  -- GENERATED --
              */
          