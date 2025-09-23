
package views.html.iot.DeviceIot

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

object DeviceIotList_update extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div id="updateConfirmModal" class="modal fixed-left fade" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-fullscreen">
        <div class="modal-content" id="theme16">

            <div class="modal-header">
                <h5 class="modal-title text-darker" id="exampleModalLabel">"""),_display_(/*6.77*/Messages("device.update")),format.raw/*6.102*/("""</h5><hr>
            </div>
            <div class="modal-body">
                <div class="col-md-12" hidden>
                    <input id="idDeviceUpdate" name="id" type="text" class="form-control" maxlength="50" autocomplete="off" required>
                </div>
                <div class="row row-cols-1 row-cols-lg-3" style="height: 100%;">

                    <div class="col">
                        <div class="card radius-10 border-danger" style="height: 100%; border: 1px solid #f41127">
                            <div class="card-body" >
                                <div class="d-flex ">
                                    <div class="ms-3">
                                        <h6 class="mb-0 text-darker">"""),_display_(/*19.71*/Messages("filter.organization")),format.raw/*19.102*/("""</h6>
                                    </div>
                                    <div class="ms-9" style="margin-left: 15px">
                                        <input type="hidden" id="itype" name="itype" value="0" >
                                        <input type="hidden" id="orgIdMove">
                                        <div class="input-group">
                                            <a class="input-group-text"><i class='bx bx-search'></i></a>
                                            <input id="search-selectOrg"  class="search-input form-control border-start-0">
                                        </div>

                                        <hr>
                                        <div id="selectOrganizations" style="overflow: auto"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card radius-10" style="height: 100%; border: 1px solid #f41127">
                            <div class="card-body">
                                <div class="d-flex ">
                                    <div class="ms-3">
                                        <h6 class="mb-0 text-darker">"""),_display_(/*41.71*/Messages("filter.group")),format.raw/*41.95*/("""</h6>
                                    </div>
                                    <div class="ms-9" style="margin-left: 15px">
                                        <input type="hidden" id="itype" name="itype" value="0" >
                                        <input type="hidden" id="groupIdMove">
                                        <div class="input-group">
                                            <a class="input-group-text"><i class='bx bx-search'></i></a>
                                            <input id="search-selectGroup"  class="search-input form-control border-start-0">
                                        </div>

                                        <hr>
                                        <div id="selectGroups" style="overflow: auto"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card radius-10" style="height: 100%; border: 1px solid #f41127">
                            <div class="card-body ">
                                <div class="d-flex ">
                                    <div class="ms-3">
                                        <h6 class="mb-0 text-darker">"""),_display_(/*63.71*/Messages("filter.type")),format.raw/*63.94*/("""</h6>
                                    </div>
                                    <div class="ms-9" id="listDeviceTypes" style="margin-left: 15px">

                                    </div>
                                </div>
                            </div>
                            <input type="hidden" id="typeIdMove">
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" onclick="processUpdateDevice()" data-bs-dismiss="modal">"""),_display_(/*76.120*/Messages("btnSave")),format.raw/*76.139*/("""</button>
                <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*77.85*/Messages("btnClose")),format.raw/*77.105*/("""</button>
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
                  DATE: Mon Sep 22 16:32:44 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/DeviceIot/DeviceIotList_update.scala.html
                  HASH: f1fbd5145d24a7c7fd2ef281fe1e316d617035b1
                  MATRIX: 1059->0|1386->301|1432->326|2196->1063|2249->1094|3613->2431|3658->2455|5020->3790|5064->3813|5685->4406|5726->4425|5847->4519|5889->4539
                  LINES: 33->1|38->6|38->6|51->19|51->19|73->41|73->41|95->63|95->63|108->76|108->76|109->77|109->77
                  -- GENERATED --
              */
          