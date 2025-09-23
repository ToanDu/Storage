
package views.html.iot.deviceType

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

object DeviceTypeList_add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addConfirmModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" id="theme16">
            <div class="modal-header">
                <h5 class="modal-title text-darker" id="exampleModalLabel">"""),_display_(/*5.77*/Messages("btnAdd")),format.raw/*5.95*/("""</h5>
                <hr>
            </div>
            <div class="modal-body">
                <form class="row g-3">
                    <div class="col-md-6">
                        <label class="form-label text-darker">"""),_display_(/*11.64*/Messages("deviceType.add.name")),_display_(/*11.96*/Messages(" *")),format.raw/*11.110*/("""</label>
                        <input id="nameDeviceTypeAdd" name="name" type="text" class="form-control" maxlength="50" autocomplete="off" required>
                    </div>
                    <div class="col-md-6">
                        <input id="organizationAdd" name="name" type="text" class="form-control" maxlength="50" autocomplete="off" hidden>
                        <label class="form-label text-darker">"""),_display_(/*16.64*/Messages("filter.organization")),_display_(/*16.96*/Messages(" *")),format.raw/*16.110*/("""</label>
                        <div class="ms-9">
                            <input type="hidden" id="itype" name="itype" value="0" >
                            <input type="hidden" id="orgIdMoveAdd">
                            <div class="input-group">
                                <a class="input-group-text"><i class='bx bx-search'></i></a>
                                <input id="search-selectOrgAdd"  class="search-input form-control border-start-0" maxlength="50" placeholder="...Tìm kiếm tổ chức">
                            </div>

                            <hr>
                            <div id="selectOrganizationsAdd" style="overflow: auto"></div>
                        </div>
                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" onclick="postDataCreateDeviceType()" data-bs-dismiss="modal">"""),_display_(/*33.125*/Messages("btnSave")),format.raw/*33.144*/("""</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*34.90*/Messages("btnClose")),format.raw/*34.110*/("""</button>
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
                  DATE: Mon Sep 22 16:32:44 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/deviceType/DeviceTypeList_add.scala.html
                  HASH: 2a13c5c92db3ff64c42d2087cf8e011d13eb6560
                  MATRIX: 1058->0|1394->310|1432->328|1687->556|1739->588|1775->602|2226->1026|2278->1058|2314->1072|3283->2013|3324->2032|3450->2131|3492->2151
                  LINES: 33->1|37->5|37->5|43->11|43->11|43->11|48->16|48->16|48->16|65->33|65->33|66->34|66->34
                  -- GENERATED --
              */
          