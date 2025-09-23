
package views.html.roles

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

object Role_add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<form>
    <div id="addConfirmModal" class="modal fixed-left fade" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-dialog-aside" role="document" style="width: 40%">
            <div class="modal-content" id="theme16">
                <div class="modal-header">
                    <h5 class="modal-title text-darker" id="exampleModalLabel">"""),_display_(/*6.81*/Messages("role.addNew")),format.raw/*6.104*/("""</h5>
                    <hr>
                </div>
                <div class="modal-body">
                    <form class="row g-3">
                        <div class="col-md-12">
                            <label class="form-label text-darker">"""),_display_(/*12.68*/Messages("role.name")),_display_(/*12.90*/Messages(" *")),format.raw/*12.104*/("""</label>
                            <input id="newRoleName" name="name" type="text" class="form-control" maxlength="50" autocomplete="off" required>
                        </div><hr>

                        <div class="col-md-12">
                            <label class="form-label text-darker">"""),_display_(/*17.68*/Messages("role.resources")),_display_(/*17.95*/Messages(" *")),format.raw/*17.109*/("""</label>
                            <div id="resourceList">
                                <div class="row py-3">
                                    <div class="col-md-3">
                                        <select id="serviceList" class="form-select service-list">
                                            <option class="devices" selected value="devices">"""),_display_(/*22.95*/Messages("role.service.devices")),format.raw/*22.127*/("""</option>
                                            <option class="groups" value="groups">"""),_display_(/*23.84*/Messages("role.service.groups")),format.raw/*23.115*/("""</option>
                                            <option class="devicetypes" value="devicetypes">"""),_display_(/*24.94*/Messages("role.service.devicetypes")),format.raw/*24.130*/("""</option>
                                            <option class="topics" value="topics">"""),_display_(/*25.84*/Messages("role.service.topics")),format.raw/*25.115*/("""</option>
                                            <option class="devicetokens" value="devicetokens">"""),_display_(/*26.96*/Messages("role.service.devicetokens")),format.raw/*26.133*/("""</option>
                                            <option class="events" value="events">"""),_display_(/*27.84*/Messages("role.service.events")),format.raw/*27.115*/("""</option>
                                        </select>
                                    </div>
                                    <div class="col-md-8">
                                        <select id="servicePermissions" data-placeholder="Lựa chọn nghiệp vụ" multiple class="chosen-select permission-list">
                                            <option value="create" >"""),_display_(/*32.70*/Messages("role.permission.create")),format.raw/*32.104*/("""</option>
                                            <option value="read" selected>"""),_display_(/*33.76*/Messages("role.permission.read")),format.raw/*33.108*/("""</option>
                                            <option value="modify">"""),_display_(/*34.69*/Messages("role.permission.modify")),format.raw/*34.103*/("""</option>
                                            <option value="delete">"""),_display_(/*35.69*/Messages("role.permission.delete")),format.raw/*35.103*/("""</option>
                                        </select>
                                    </div>
                                    <div class="col-md-1 pt-sm-2">
                                        <i style="font-size: 16px; cursor: pointer;" class="bx bxs-trash-alt icon-remove-resource"></i>
                                    </div>
                                </div>
                            </div>
                            <div style="text-align: center;" class="row">
                                <i id="addMore" style="font-size: 50px;cursor: pointer;" class="bx bxs-plus-circle"></i>
                            </div>
                            <hr>

                        </div>



                    </form>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" onclick="createNewRole()" data-bs-dismiss="modal">"""),_display_(/*56.118*/Messages("btnSave")),format.raw/*56.137*/("""</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*57.94*/Messages("btnClose")),format.raw/*57.114*/("""</button>
                </div>
            </div>
        </div> <!-- modal-bialog .// -->
    </div>
</form>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:49 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/roles/Role_add.scala.html
                  HASH: aebe14042b6206c2db315bc01fc8e6a1641e8d40
                  MATRIX: 1039->0|1426->361|1470->384|1750->637|1792->659|1828->673|2156->974|2203->1001|2239->1015|2634->1383|2688->1415|2808->1508|2861->1539|2991->1642|3049->1678|3169->1771|3222->1802|3354->1907|3413->1944|3533->2037|3586->2068|4002->2457|4058->2491|4170->2576|4224->2608|4329->2686|4385->2720|4490->2798|4546->2832|5507->3765|5548->3784|5678->3887|5720->3907
                  LINES: 33->1|38->6|38->6|44->12|44->12|44->12|49->17|49->17|49->17|54->22|54->22|55->23|55->23|56->24|56->24|57->25|57->25|58->26|58->26|59->27|59->27|64->32|64->32|65->33|65->33|66->34|66->34|67->35|67->35|88->56|88->56|89->57|89->57
                  -- GENERATED --
              */
          