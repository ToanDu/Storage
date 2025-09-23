
package views.html.landingPage

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

object LandingPage_question extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="questionModal" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: inherit;">
        <h5 class="modal-title" id="exampleModalLabel" style="font-weight: 500; color: #000000;">"""),_display_(/*5.99*/Messages("Đặt câu hỏi?")),format.raw/*5.123*/("""</h5>
        <i class="bx bx-x btn-close" data-bs-dismiss="modal" aria-label="Close" style="font-size: 20px; cursor: pointer;"></i>
      </div>
      <div class="modal-body">
        <h6 class="modal-title" style="font-weight: 400; color: #000000;">"""),_display_(/*9.76*/Messages("Thông tin của bạn")),format.raw/*9.105*/("""</h6>
        <div class="row mt-3">
          <input type="text" id="" class="form-control" maxlength="100" autocomplete="off" placeholder="Họ và tên*">
        </div>
        <div class="row mt-3">
          <input type="number" id="" class="form-control" maxlength="11" autocomplete="off" placeholder="Số di động*">
        </div>
        <div class="row mt-3">
          <input type="text" id="" class="form-control" maxlength="100" autocomplete="off" placeholder="Email*">
        </div>
        <div class="row mt-3">
          <textarea type="text" id="" class="form-control" maxlength="255" autocomplete="off" placeholder="Nội dung cần hỏi*" rows="5"></textarea>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" onclick="success_noti('Gửi câu hỏi thành công!')" data-bs-dismiss="modal">"""),_display_(/*24.129*/Messages("Gửi câu hỏi ngay")),format.raw/*24.157*/("""</button>
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
                  DATE: Mon Sep 22 16:32:47 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPage/LandingPage_question.scala.html
                  HASH: e1740833ea910ce394647e18691135abbc5f84cc
                  MATRIX: 1057->0|1433->350|1478->374|1756->626|1806->655|2694->1515|2744->1543
                  LINES: 33->1|37->5|37->5|41->9|41->9|56->24|56->24
                  -- GENERATED --
              */
          