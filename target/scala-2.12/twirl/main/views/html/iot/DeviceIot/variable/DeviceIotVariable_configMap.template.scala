
package views.html.iot.DeviceIot.variable

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
/*1.2*/import vn.m2m.iot.models.DeviceVariable

object DeviceIotVariable_configMap extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,List[DeviceVariable],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(deviceId: String, deviceVariableList: List[DeviceVariable]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.62*/("""
"""),format.raw/*3.1*/("""<div class="modal fade" id="configConfirmModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-darker" id="exampleModalLabel">"""),_display_(/*7.69*/Messages("device.variable.configGps")),format.raw/*7.106*/("""</h5>
        <hr>
      </div>
      <div class="modal-body">
        <form class="row g-3">
          <div class="col-md-12">
            <label class="form-label text-darker">"""),_display_(/*13.52*/Messages("manage.deviceIot.id")),_display_(/*13.84*/Messages(" *")),format.raw/*13.98*/("""</label>
            <input id="idDeviceConfig" name="id" type="text" class="form-control" value=""""),_display_(/*14.91*/deviceId),format.raw/*14.99*/("""" maxlength="50" autocomplete="off" readonly>
          </div>
          <div class="col-md-12">
            <label class="form-label text-darker">"""),_display_(/*17.52*/Messages("manage.deviceIot.latitude")),_display_(/*17.90*/Messages(" *")),format.raw/*17.104*/("""</label><br>
            <select id="latitudeDeviceConfig" style="width: 100%">
            """),_display_(/*19.14*/for((variable: DeviceVariable)<- deviceVariableList) yield /*19.66*/ {_display_(Seq[Any](format.raw/*19.68*/("""
              """),format.raw/*20.15*/("""<option value=""""),_display_(/*20.31*/variable/*20.39*/.getName),format.raw/*20.47*/("""">"""),_display_(/*20.50*/variable/*20.58*/.getName),format.raw/*20.66*/("""</option>
            """)))}),format.raw/*21.14*/("""
            """),format.raw/*22.13*/("""</select>
          </div>
          <div class="col-md-12">
            <label class="form-label text-darker">"""),_display_(/*25.52*/Messages("manage.deviceIot.longitude")),_display_(/*25.91*/Messages(" *")),format.raw/*25.105*/("""</label><br>
            <select id="longitudeDeviceConfig" style="width: 100%">
            """),_display_(/*27.14*/for((variable: DeviceVariable)<- deviceVariableList) yield /*27.66*/ {_display_(Seq[Any](format.raw/*27.68*/("""
              """),format.raw/*28.15*/("""<option value=""""),_display_(/*28.31*/variable/*28.39*/.getName),format.raw/*28.47*/("""">"""),_display_(/*28.50*/variable/*28.58*/.getName),format.raw/*28.66*/("""</option>
            """)))}),format.raw/*29.14*/("""
            """),format.raw/*30.13*/("""</select>
          </div>
        </form>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" onclick="processConfigGpsDevice()" data-bs-dismiss="modal">"""),_display_(/*36.115*/Messages("btnSave")),format.raw/*36.134*/("""</button>
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*37.77*/Messages("btnClose")),format.raw/*37.97*/("""</button>
      </div>
    </div>
  </div>
</div>"""))
      }
    }
  }

  def render(deviceId:String,deviceVariableList:List[DeviceVariable]): play.twirl.api.HtmlFormat.Appendable = apply(deviceId,deviceVariableList)

  def f:((String,List[DeviceVariable]) => play.twirl.api.HtmlFormat.Appendable) = (deviceId,deviceVariableList) => apply(deviceId,deviceVariableList)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:44 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/DeviceIot/variable/DeviceIotVariable_configMap.scala.html
                  HASH: 7e3facc89c89054043dbaa65d2ea991d6bcea6d1
                  MATRIX: 674->1|1061->42|1216->102|1243->103|1562->396|1620->433|1826->612|1878->644|1913->658|2039->757|2068->765|2243->913|2301->951|2337->965|2457->1058|2525->1110|2565->1112|2608->1127|2651->1143|2668->1151|2697->1159|2727->1162|2744->1170|2773->1178|2827->1201|2868->1214|3007->1326|3066->1365|3102->1379|3223->1473|3291->1525|3331->1527|3374->1542|3417->1558|3434->1566|3463->1574|3493->1577|3510->1585|3539->1593|3593->1616|3634->1629|3866->1833|3907->1852|4020->1938|4061->1958
                  LINES: 24->1|29->2|34->2|35->3|39->7|39->7|45->13|45->13|45->13|46->14|46->14|49->17|49->17|49->17|51->19|51->19|51->19|52->20|52->20|52->20|52->20|52->20|52->20|52->20|53->21|54->22|57->25|57->25|57->25|59->27|59->27|59->27|60->28|60->28|60->28|60->28|60->28|60->28|60->28|61->29|62->30|68->36|68->36|69->37|69->37
                  -- GENERATED --
              */
          