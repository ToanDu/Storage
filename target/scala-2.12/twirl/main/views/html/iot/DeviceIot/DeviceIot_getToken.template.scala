
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
/*1.2*/import vn.m2m.common.models.User

object DeviceIot_getToken extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<div class="modal fade" id="getDeviceTokenModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*7.68*/Messages("Device Token")),format.raw/*7.92*/("""</h5>
      </div>
      <div class="modal-body">
        <form class="row g-3">
          <div class="col-md-12">
            <input id="deviceToken" type="text" value=""""),_display_(/*12.57*/currentUser/*12.68*/.getDeviceToken),format.raw/*12.83*/("""" class="form-control" maxlength="50" autocomplete="off" required>
          </div>
        </form>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" onclick="copyLinkTokenDevice()" data-bs-dismiss="modal">"""),_display_(/*18.112*/Messages("btnCopy")),format.raw/*18.131*/("""</button>
      </div>
    </div>
  </div>
</div>"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:44 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/DeviceIot/DeviceIot_getToken.scala.html
                  HASH: 8bd1edc45e3383cc795f3a1d623a1effd6d1912c
                  MATRIX: 665->1|1013->35|1126->53|1153->54|1481->356|1525->380|1723->551|1743->562|1779->577|2065->835|2106->854
                  LINES: 24->1|29->2|34->2|35->3|39->7|39->7|44->12|44->12|44->12|50->18|50->18
                  -- GENERATED --
              */
          