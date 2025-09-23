
package views.html.amarket.marketPlace.detail

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

object MarketPlaceDetail_answer extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="answerFormModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h4 class="modal-title" id="exampleModalLabel">"""),_display_(/*5.57*/Messages("Trả lời bình luận")),format.raw/*5.86*/("""</h4><br>
      </div>
      <div class="modal-body">
        <form class="row g-3">
          <div class="col-md-12">
            <input id="parentId" type="text" class="form-control" readonly hidden>
            <div class="row">
              <label class="col-sm-12 col-form-label questionText">"""),_display_(/*12.69*/Messages("Nội dung")),format.raw/*12.89*/("""</label>
              <div class="col-sm-12">
                <h6 id="questionContent"></h6>
              </div>
            </div>
            <div class="row mt-3">
              <label class="col-sm-12 col-form-label questionText">"""),_display_(/*18.69*/Messages("Câu trả lời")),format.raw/*18.92*/("""</label>
              <div class="col-sm-12">
                <textarea class="form-control" id="answerContent" placeholder="... nội dung tối đa 1000 kí tự" maxlength="1000" rows="5"></textarea>
              </div>
            </div>
            <div class="row mt-3">
              <label class="col-sm-12 col-form-label questionText">"""),_display_(/*24.69*/Messages("Tên")),format.raw/*24.84*/("""</label>
              <div class="col-sm-12">
                <input id="answerName" type="text" class="form-control " maxlength="50" autocomplete="off" placeholder="...tối đa 50 kí tự">
              </div>
            </div>
            <div class="row mt-3">
              <label class="col-sm-12 col-form-label questionText">"""),_display_(/*30.69*/Messages("Email")),format.raw/*30.86*/("""</label>
              <div class="col-sm-12">
                <input id="answerEmail" type="text" class="form-control " maxlength="50" autocomplete="off" placeholder="...tối đa 50 kí tự">
              </div>
            </div>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger text-white" onclick="proccessAnswer()" data-bs-dismiss="modal">"""),_display_(/*39.117*/Messages("Gửi")),format.raw/*39.132*/("""</button>
        <button type="button" class="btn btn-default text-white" data-bs-dismiss="modal">"""),_display_(/*40.91*/Messages("btnClose")),format.raw/*40.111*/("""</button>
      </div>
    </div>
  </div> <!-- modal-bialog .// -->
</div>
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
                  DATE: Mon Sep 22 16:32:41 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/amarket/marketPlace/detail/MarketPlaceDetail_answer.scala.html
                  HASH: e0cccbd42eb80ccb243696bd23505ead8dcae70a
                  MATRIX: 1076->0|1380->278|1429->307|1756->607|1797->627|2061->864|2105->887|2471->1226|2507->1241|2865->1572|2903->1589|3355->2013|3392->2028|3519->2128|3561->2148
                  LINES: 33->1|37->5|37->5|44->12|44->12|50->18|50->18|56->24|56->24|62->30|62->30|71->39|71->39|72->40|72->40
                  -- GENERATED --
              */
          