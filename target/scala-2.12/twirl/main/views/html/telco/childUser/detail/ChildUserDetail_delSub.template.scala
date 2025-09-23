
package views.html.telco.childUser.detail

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

object ChildUserDetail_delSub extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="delSubOfChildUserModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*5.65*/Messages("Xoá gán thuê bao")),format.raw/*5.93*/("""</span>
      </div>
      <div class="modal-body">
        <div class="row mt-3">
          <div class="row">
            <input id="isdnDel" type="text" class="form-control input-form" readonly hidden>
            <h5 class="modal-body text-darker align-items-center" id="">"""),_display_(/*11.74*/Messages("Bạn có chắc chắn muốn thực hiện?")),format.raw/*11.118*/("""</h5>
          </div>
        </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*17.79*/Messages("btnCancle")),format.raw/*17.100*/("""</button>
        <button type="button" class="btn btn-red" data-bs-dismiss="modal" onclick="processDeleteSubOfChildUser()">"""),_display_(/*18.116*/Messages("btnComfirm")),format.raw/*18.138*/("""</button>
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
                  DATE: Mon Sep 22 16:32:52 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/childUser/detail/ChildUserDetail_delSub.scala.html
                  HASH: 379609c797f92b93e160c0c0497c3ac05fdb8b29
                  MATRIX: 1070->0|1501->405|1549->433|1853->710|1919->754|2109->917|2152->938|2305->1063|2349->1085
                  LINES: 33->1|37->5|37->5|43->11|43->11|49->17|49->17|50->18|50->18
                  -- GENERATED --
              */
          