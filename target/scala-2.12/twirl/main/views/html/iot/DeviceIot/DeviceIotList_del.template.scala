
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

object DeviceIotList_del extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="deleteDeviceconfirm" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" id="theme16">
            <div class="modal-header">
                <h5 class="modal-title text-darker">"""),_display_(/*5.54*/Messages("device.delete")),format.raw/*5.79*/("""</h5>
                <hr>
            </div>
            <div class="modal-body text-darker">
                <h4 class="modal-body text-darker align-items-center" id="myModalbody">"""),_display_(/*9.89*/Messages("noti.confirmDeletebody")),format.raw/*9.123*/("""</h4>
                <div class="form-group" hidden>
                    <input id="idDeviceDelete" class="form-control" name="id" >
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal" onclick="processDeleteDeviceId()">"""),_display_(/*15.121*/Messages("btnDelete")),format.raw/*15.142*/("""</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*16.90*/Messages("btnCancel")),format.raw/*16.111*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/DeviceIot/DeviceIotList_del.scala.html
                  HASH: 6c579f43abb77f8f892603f57fa72489a5f892ce
                  MATRIX: 1056->0|1337->255|1382->280|1591->463|1646->497|2009->832|2052->853|2178->952|2221->973
                  LINES: 33->1|37->5|37->5|41->9|41->9|47->15|47->15|48->16|48->16
                  -- GENERATED --
              */
          