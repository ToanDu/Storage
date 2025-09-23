
package views.html.events

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
/*1.2*/import vn.m2m.iot.models.DeviceIot

object Event_edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[DeviceIot],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(deviceList: List[DeviceIot]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.31*/("""
"""),format.raw/*3.1*/("""<div id="editEventModal" class="modal fixed-left fade" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-dialog-aside" role="document" style="width: 50%;">
        <div class="modal-content" id="theme16">
            <div class="modal-header">
                <h5 class="modal-title text-darker" id="exampleModalLabel">"""),_display_(/*7.77*/Messages("event.title.editEvent")),format.raw/*7.110*/("""</h5>
                <hr>
            </div>
            <div class="modal-body">
                <form class="row g-3">
                    <input type="hidden" id="eventIdEdit">
                    <div class="col-md-6">
                        <label class="form-label text-darker">"""),_display_(/*14.64*/Messages("event.title.name")),_display_(/*14.93*/Messages(" *")),format.raw/*14.107*/("""</label>
                        <input id="eventNameEdit" name="name" type="text" class="form-control" maxlength="50" autocomplete="off" required>

                    </div>
                    <div class="col-md-6">
                        <label class="form-label text-darker">"""),_display_(/*19.64*/Messages("event.title.status")),format.raw/*19.94*/("""</label>
                        <div class="form-check form-switch">
                            <input class="form-check-input" type="checkbox" id="eventStatus">
                            <label class="form-check-label" for="eventStatus"></label>
                        </div>
                    </div>
                    <hr>

                    <div class="col-md-12">
                        <label class="form-label text-darker">"""),_display_(/*28.64*/Messages("event.title.condition")),format.raw/*28.97*/("""</label>
                        <div id="conditionLstEdit">
                            <div class="row pt-3 pb-1">
                                <div class="col-md">
                                    <select id="listDeviceDrd" class="form-select device-list">
                                        <option selected disabled value="">Select device</option>
                                        """),_display_(/*34.42*/for((device: DeviceIot)<- deviceList) yield /*34.79*/ {_display_(Seq[Any](format.raw/*34.81*/("""
                                            """),format.raw/*35.45*/("""<option value=""""),_display_(/*35.61*/device/*35.67*/.getId),format.raw/*35.73*/("""">"""),_display_(/*35.76*/device/*35.82*/.getName),format.raw/*35.90*/("""</option>
                                        """)))}),format.raw/*36.42*/("""
                                    """),format.raw/*37.37*/("""</select>
                                </div>
                                <div class="col-md">
                                    <select id="listVarDrd0" class="form-select var-list">
                                        <option disabled selected value="">Select variable</option>
                                    </select>
                                </div>
                                <div class="col-md">
                                    <select id="listOprDrd0" class="form-select op-list">
                                        <option selected disabled value="">Select operator</option>
                                        <option value="=">Equal to</option>
                                        <option value=">">Greater than</option>
                                        <option value="<">Less than</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    <input id="threshold0" name="name" type="text" placeholder="Threshold" class="form-control input-threshold" maxlength="50" autocomplete="off" required>
                                </div>
                                <div class="col-sm-1 pt-sm-2">
                                    <i style="font-size: 16px; cursor: pointer; visibility: hidden" class="bx bxs-trash-alt icon-remove-cond"></i>
                                </div>
                            </div>


                        </div>


                       <div style="text-align: center;" class="row">
                           <i id="addMoreConditionEdit" style="font-size: 50px;cursor: pointer;" class="bx bxs-plus-circle"></i>
                       </div>

                        <hr>
                    </div>

                    <div class="col-md-12">
                        <label class="form-label text-darker">"""),_display_(/*72.64*/Messages("event.title.action")),format.raw/*72.94*/("""</label>
                        <div id="actionListEdit">
                            <div class="row pb-3 row-action">
                                <div class="col-md">
                                    <select id="listActionTypeDrd" class="form-select actionType-list">
                                        <option selected disabled value="">Select action</option>
                                        <option value="sms">Sms</option>
                                        <option value="email">Email</option>
                                    </select>
                                </div>
                                <div class="col-md">
                                    <input id="receiver" name="name" type="text" placeholder="Receiver" class="form-control input-receiver" maxlength="50" autocomplete="off" required>
                                </div>
                                <div class="col-md">
                                    <input id="subject" name="name" type="text" placeholder="Subject" class="form-control input-subject" maxlength="50" autocomplete="off" required>
                                </div>
                                <div class="col-md">
                                    <input id="message" name="name" type="text" placeholder="Message" class="form-control input-message" maxlength="50" autocomplete="off" required>
                                </div>
                                <div class="col-sm-1 pt-sm-2">
                                    <i style="font-size: 16px; cursor: pointer;" class="bx bxs-trash-alt icon-remove-action"></i>
                                </div>
                            </div>
                        </div>


                        <div style="text-align: center;" class="row">
                            <i id="addMoreActionEdit" style="font-size: 50px;cursor: pointer;" class="bx bxs-plus-circle"></i>
                        </div>

                        <hr>
                    </div>

                    <div class="col-md-12">
                        <label class="form-label text-darker">"""),_display_(/*106.64*/Messages("event.title.interval")),format.raw/*106.96*/("""</label>
                        <div class="row">
                            <div class="col-md">
                                <input type="checkbox" class="btn-check" id="monday-edit" name="weekdays" value="monday" autocomplete="off"/>
                                <label style="width: inherit;" class="btn btn-primary btn-weekday" for="monday-edit">Monday</label>
                            </div>
                            <div class="col-md">
                                <input type="checkbox" class="btn-check" id="tuesday-edit" name="weekdays" value="tuesday" autocomplete="off"/>
                                <label style="width: inherit;" class="btn btn-primary btn-weekday" for="tuesday-edit">Tuesday</label>
                            </div>
                            <div class="col-md">
                                <input type="checkbox" class="btn-check" id="wednesday-edit" name="weekdays" value="wednesday" autocomplete="off"/>
                                <label style="width: inherit;" class="btn btn-primary btn-weekday" for="wednesday-edit">Wednesday</label>
                            </div>
                            <div class="col-md">
                                <input type="checkbox" class="btn-check" id="thursday-edit" name="weekdays" value="thursday" autocomplete="off"/>
                                <label style="width: inherit;" class="btn btn-primary btn-weekday" for="thursday-edit">Thursday</label>
                            </div>
                            <div class="col-md">
                                <input type="checkbox" class="btn-check" id="friday-edit" name="weekdays" value="friday" autocomplete="off"/>
                                <label style="width: inherit;" class="btn btn-primary btn-weekday" for="friday-edit">Friday</label>
                            </div>
                            <div class="col-md">
                                <input type="checkbox" class="btn-check" id="saturday-edit" name="weekdays" value="saturday" autocomplete="off"/>
                                <label style="width: inherit;" class="btn btn-primary btn-weekday" for="saturday-edit">Saturday</label>
                            </div>
                            <div class="col-md">
                                <input type="checkbox" class="btn-check" id="sunday-edit" name="weekdays" value="sunday" autocomplete="off"/>
                                <label style="width: inherit;" class="btn btn-primary btn-weekday" for="sunday-edit">Sunday</label>
                            </div>
                        </div>
                        <div class="row pt-4">
                            <div class="col-md-2">
                                <label class="form-label">Start</label>
                                <input value="00:00" style="padding: .375rem .5rem;" id="startTime-edit" name="startTime" type="time" class="form-control" autocomplete="off" required>
                            </div>
                            <div style="display: contents;">
                                <span style="margin-top: 38px;">-</span>
                            </div>

                            <div class="col-md-2">
                                <label class="form-label">End</label>
                                <input value="23:59" style="padding: .375rem .5rem;" id="endTime-edit" name="endTime" type="time" class="form-control" autocomplete="off" required>
                            </div>

                        </div>
                    </div>


                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" onclick="updateEvent()" data-bs-dismiss="modal">"""),_display_(/*159.112*/Messages("btnSave")),format.raw/*159.131*/("""</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*160.90*/Messages("btnClose")),format.raw/*160.110*/("""</button>
            </div>
        </div>
    </div> <!-- modal-bialog .// -->
</div>

"""))
      }
    }
  }

  def render(deviceList:List[DeviceIot]): play.twirl.api.HtmlFormat.Appendable = apply(deviceList)

  def f:((List[DeviceIot]) => play.twirl.api.HtmlFormat.Appendable) = (deviceList) => apply(deviceList)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:41 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/events/Event_edit.scala.html
                  HASH: 7b4f4c70cdeaa9852912460c241e6d46dbddf237
                  MATRIX: 658->1|1011->37|1135->66|1162->67|1522->401|1576->434|1890->721|1939->750|1975->764|2284->1046|2335->1076|2804->1518|2858->1551|3290->1956|3343->1993|3383->1995|3456->2040|3499->2056|3514->2062|3541->2068|3571->2071|3586->2077|3615->2085|3697->2136|3762->2173|5722->4106|5773->4136|7927->6262|7981->6294|11780->10064|11822->10083|11949->10182|11992->10202
                  LINES: 24->1|29->2|34->2|35->3|39->7|39->7|46->14|46->14|46->14|51->19|51->19|60->28|60->28|66->34|66->34|66->34|67->35|67->35|67->35|67->35|67->35|67->35|67->35|68->36|69->37|104->72|104->72|138->106|138->106|191->159|191->159|192->160|192->160
                  -- GENERATED --
              */
          