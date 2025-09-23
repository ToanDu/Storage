
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

object Event_add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[DeviceIot],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(deviceList: List[DeviceIot]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.31*/("""
"""),format.raw/*3.1*/("""<div id="addConfirmModal" class="modal fixed-left fade" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-fullscreen" role="document" >
        <div class="modal-content" id="theme16">
            <div class="modal-header">
                <h5 class="modal-title text-darker" id="exampleModalLabel">"""),_display_(/*7.77*/Messages("event.title.addNewEvent")),format.raw/*7.112*/("""</h5>
                <hr>
            </div>
            <div class="modal-body">
                <form class="row g-3">
                    <div class="col-md-12">
                        <label class="form-label text-darker">"""),_display_(/*13.64*/Messages("event.title.name")),_display_(/*13.93*/Messages(" *")),format.raw/*13.107*/("""</label>
                        <input id="newEventName" name="name" type="text" class="form-control" maxlength="50" autocomplete="off" required>

                    </div><hr>

                    <div class="col-md-12">
                        <label class="form-label text-darker">"""),_display_(/*19.64*/Messages("event.title.condition")),format.raw/*19.97*/("""</label>
                        <div id="conditionLst">
                            <div class="row pt-3 pb-1">
                                <div class="col-md">
                                    <select id="listDeviceDrd" class="form-select device-list">
                                        <option selected disabled value="">Select device</option>
                                        """),_display_(/*25.42*/for((device: DeviceIot)<- deviceList) yield /*25.79*/ {_display_(Seq[Any](format.raw/*25.81*/("""
                                            """),format.raw/*26.45*/("""<option value=""""),_display_(/*26.61*/device/*26.67*/.getId),format.raw/*26.73*/("""">"""),_display_(/*26.76*/device/*26.82*/.getName),format.raw/*26.90*/("""</option>
                                        """)))}),format.raw/*27.42*/("""
                                    """),format.raw/*28.37*/("""</select>
                                </div>
                                <div class="col-md">
                                    <select id="listVarDrd" class="form-select var-list">
                                        <option disabled selected value="">Select variable</option>
                                    </select>
                                </div>
                                <div class="col-md">
                                    <select id="listOprDrd" class="form-select op-list">
                                        <option selected disabled value="">Select operator</option>
                                        <option value="=">"""),_display_(/*38.60*/Messages("event.operator.equal")),format.raw/*38.92*/("""</option>
                                        <option value=">">"""),_display_(/*39.60*/Messages("event.operator.greater")),format.raw/*39.94*/("""</option>
                                        <option value="<">"""),_display_(/*40.60*/Messages("event.operator.less")),format.raw/*40.91*/("""</option>
                                    </select>
                                    <select id="listOprStringDrd" hidden class="form-select op-list">
                                        <option selected disabled value="">"""),_display_(/*43.77*/Messages("event.operator.selectOperator")),format.raw/*43.118*/("""</option>
                                        <option value="=">"""),_display_(/*44.60*/Messages("event.operator.equal")),format.raw/*44.92*/("""</option>
                                        <option value="!=">"""),_display_(/*45.61*/Messages("event.operator.notEqual")),format.raw/*45.96*/("""</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    <input id="threshold" name="name" type="text" placeholder="Threshold" class="form-control input-threshold" maxlength="50" autocomplete="off" required>
                                </div>
                                <div class="col-sm-1 pt-sm-2">
                                    <i style="font-size: 16px; cursor: pointer; visibility: hidden" class="bx bxs-trash-alt icon-remove-cond"></i>
                                </div>
                            </div>


                        </div>


                       <div style="text-align: center;" class="row">
                           <i id="addMoreCondition" style="font-size: 50px;cursor: pointer;" class="bx bxs-plus-circle"></i>
                       </div>

                        <hr>
                    </div>

                    <div class="col-md-12">
                        <label class="form-label text-darker">"""),_display_(/*68.64*/Messages("event.title.action")),format.raw/*68.94*/("""</label>
                        <div id="actionList">
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
                            <i id="addMoreAction" style="font-size: 50px;cursor: pointer;" class="bx bxs-plus-circle"></i>
                        </div>

                        <hr>
                    </div>

                    <div class="col-md-12">
                        <label class="form-label text-darker">"""),_display_(/*102.64*/Messages("event.title.interval")),format.raw/*102.96*/("""</label>
                        <div class="row">
                            <div class="col-md">
                                <input type="checkbox" class="btn-check" id="monday" name="weekdays" value="monday" autocomplete="off"/>
                                <label style="width: inherit;" class="btn btn-primary btn-weekday" for="monday">Monday</label>
                            </div>
                            <div class="col-md">
                                <input type="checkbox" class="btn-check" id="tuesday" name="weekdays" value="tuesday" autocomplete="off"/>
                                <label style="width: inherit;" class="btn btn-primary btn-weekday" for="tuesday">Tuesday</label>
                            </div>
                            <div class="col-md">
                                <input type="checkbox" class="btn-check" id="wednesday" name="weekdays" value="wednesday" autocomplete="off"/>
                                <label style="width: inherit;" class="btn btn-primary btn-weekday" for="wednesday">Wednesday</label>
                            </div>
                            <div class="col-md">
                                <input type="checkbox" class="btn-check" id="thursday" name="weekdays" value="thursday" autocomplete="off"/>
                                <label style="width: inherit;" class="btn btn-primary btn-weekday" for="thursday">Thursday</label>
                            </div>
                            <div class="col-md">
                                <input type="checkbox" class="btn-check" id="friday" name="weekdays" value="friday" autocomplete="off"/>
                                <label style="width: inherit;" class="btn btn-primary btn-weekday" for="friday">Friday</label>
                            </div>
                            <div class="col-md">
                                <input type="checkbox" class="btn-check" id="saturday" name="weekdays" value="saturday" autocomplete="off"/>
                                <label style="width: inherit;" class="btn btn-primary btn-weekday" for="saturday">Saturday</label>
                            </div>
                            <div class="col-md">
                                <input type="checkbox" class="btn-check" id="sunday" name="weekdays" value="sunday" autocomplete="off"/>
                                <label style="width: inherit;" class="btn btn-primary btn-weekday" for="sunday">Sunday</label>
                            </div>
                        </div>
                        <div class="row pt-4">
                            <div class="col-md-2">
                                <label class="form-label text-darker">"""),_display_(/*135.72*/Messages("event.start")),format.raw/*135.95*/("""</label>
                                <input value="00:00" style="padding: .375rem .5rem;" id="startTime" name="startTime" type="time" class="form-control" autocomplete="off" required>
                            </div>
                            <div style="display: contents;">
                                <span style="margin-top: 38px;">-</span>
                            </div>

                            <div class="col-md-2">
                                <label class="form-label text-darker">"""),_display_(/*143.72*/Messages("event.end")),format.raw/*143.93*/("""</label>
                                <input value="23:59" style="padding: .375rem .5rem;" id="endTime" name="endTime" type="time" class="form-control" autocomplete="off" required>
                            </div>

                        </div>
                        <hr>
                    </div>


                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" onclick="postDataCreateEvent()" data-bs-dismiss="modal">"""),_display_(/*156.120*/Messages("btnSave")),format.raw/*156.139*/("""</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*157.90*/Messages("btnClose")),format.raw/*157.110*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/events/Event_add.scala.html
                  HASH: 006c4b35eaff017017823df693069ffdf3bafdf5
                  MATRIX: 658->1|1010->37|1134->66|1161->67|1501->381|1557->416|1813->645|1862->674|1898->688|2212->975|2266->1008|2694->1409|2747->1446|2787->1448|2860->1493|2903->1509|2918->1515|2945->1521|2975->1524|2990->1530|3019->1538|3101->1589|3166->1626|3871->2304|3924->2336|4020->2405|4075->2439|4171->2508|4223->2539|4484->2773|4547->2814|4643->2883|4696->2915|4793->2985|4849->3020|5960->4104|6011->4134|8157->6252|8211->6284|10958->9003|11003->9026|11546->9541|11589->9562|12129->10073|12171->10092|12298->10191|12341->10211
                  LINES: 24->1|29->2|34->2|35->3|39->7|39->7|45->13|45->13|45->13|51->19|51->19|57->25|57->25|57->25|58->26|58->26|58->26|58->26|58->26|58->26|58->26|59->27|60->28|70->38|70->38|71->39|71->39|72->40|72->40|75->43|75->43|76->44|76->44|77->45|77->45|100->68|100->68|134->102|134->102|167->135|167->135|175->143|175->143|188->156|188->156|189->157|189->157
                  -- GENERATED --
              */
          