
package views.html.telco.log.survey

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

object LogSurvey_editDel extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editUserSurveyModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.65*/Messages("Sửa / Xóa")),format.raw/*5.86*/("""</span>
      </div>
      <div class="modal-body">
        <div class="row mt-3">
          <input id="idUserSurvey" type="text" class="form-control input-form" readonly hidden>
        </div>
        <div class="row mt-3">
          <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*12.67*/Messages("Doanh nghiệp")),format.raw/*12.91*/("""</label>
          <div class="col-sm-9">
            <input id="nameEnterSurvey" type="text" class="form-control input-form" readonly >
          </div>
        </div>
        <div class="row mt-3">
          <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*18.67*/Messages("Khảo sát")),format.raw/*18.87*/("""</label>
          <div class="col-sm-9">
            <select class="form-control" id="isSurvey">
              <option value="true">"""),_display_(/*21.37*/Messages("Đã khảo sát")),format.raw/*21.60*/("""</option>
              <option value="false">"""),_display_(/*22.38*/Messages("Chưa khảo sát")),format.raw/*22.63*/("""</option>
            </select>
          </div>
        </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-red" data-bs-dismiss="modal" onclick="processDelSurvey()">"""),_display_(/*29.105*/Messages("btnDelete")),format.raw/*29.126*/("""</button>
        <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*30.79*/Messages("btnCancle")),format.raw/*30.100*/("""</button>
        <button type="button" class="btn btn-red" data-bs-dismiss="modal" onclick="processEditSurvey()">"""),_display_(/*31.106*/Messages("btnComfirm")),format.raw/*31.128*/("""</button>
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
                  DATE: Mon Sep 22 16:32:53 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/log/survey/LogSurvey_editDel.scala.html
                  HASH: b17f770d2870042c38ca3b825944f5d72ca6f442
                  MATRIX: 1059->0|1496->411|1537->432|1855->723|1900->747|2193->1013|2234->1033|2395->1167|2439->1190|2513->1237|2559->1262|2802->1477|2845->1498|2960->1586|3003->1607|3146->1722|3190->1744
                  LINES: 33->1|37->5|37->5|44->12|44->12|50->18|50->18|53->21|53->21|54->22|54->22|61->29|61->29|62->30|62->30|63->31|63->31
                  -- GENERATED --
              */
          