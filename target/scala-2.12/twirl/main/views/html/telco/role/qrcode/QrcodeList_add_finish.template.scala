
package views.html.telco.role.qrcode

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

object QrcodeList_add_finish extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addQrcodeFinishModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block; ">
        <h5 class="modal-title" id="titleFinishCreateQrcode">"""),_display_(/*5.63*/Messages("Khởi tạo mã QR Code")),format.raw/*5.94*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row" id="resultCreateQrcode">

        </div>
      </div>
      <div class="modal-footer">
        """),format.raw/*13.131*/("""
        """),format.raw/*14.9*/("""<button type="button" class="btn btn-red" data-bs-dismiss="modal" onclick="getListQrcode()">"""),_display_(/*14.102*/Messages("btnClose")),format.raw/*14.122*/("""</button>
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
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/qrcode/QrcodeList_add_finish.scala.html
                  HASH: 1288003d5309145992d33aee397f523fd19af14c
                  MATRIX: 1064->0|1450->360|1501->391|1700->683|1736->692|1857->785|1899->805
                  LINES: 33->1|37->5|37->5|45->13|46->14|46->14|46->14
                  -- GENERATED --
              */
          