
package views.html.iot.dashboard.widget

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

object Widget_add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addConfirmModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.68*/Messages("widget.choose")),format.raw/*5.93*/("""</h5>
      </div>
      <div class="modal-body" style="background-color: #FFFFFF;">
        <form class="row g-3">
          <div class="col-md-12">

            <div class="row">
              <div class="col-md-4">
                <div class="card">
                  <div class="col-md-12" style="background-color: #F4F5F6">
                    <div class="row">
                      <div class="col-md-6" style="padding: 10px;">
                        <div style="padding: 15px; margin-left: 15px; background-color: white;">
                          <img src=""""),_display_(/*18.38*/routes/*18.44*/.Assets.versioned("images/widget/chartLineIcon.png")),format.raw/*18.96*/("""" width="100%" alt="" />
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" name="flexRadioDefault" id="lineChart" onchange="change_widget_action(this)" value="4" style="float: right; margin-right: 10px;">
                        </div>
                        <label class="form-check-label" for="lineChart" style="margin-top: 10px; font-weight: bold; margin-right: 10px">Biểu đồ đường</label>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="card">
                  <div class="col-md-12" style="background-color: #F4F5F6">
                    <div class="row">
                      <div class="col-md-6" style="padding: 10px;">
                        <div style="padding: 15px; margin-left: 15px; background-color: white;">
                          <img src=""""),_display_(/*37.38*/routes/*37.44*/.Assets.versioned("images/widget/chartColumnIcon.png")),format.raw/*37.98*/("""" width="100%" alt="" />
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" name="flexRadioDefault" id="columnChart" onchange="change_widget_action(this)" value="3" style="float: right; margin-right: 10px;">
                        </div>
                        <label class="form-check-label" for="columnChart" style="margin-top: 10px; font-weight: bold; margin-right: 10px">Biểu đồ cột</label>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="card">
                  <div class="col-md-12" style="background-color: #F4F5F6">
                    <div class="row">
                      <div class="col-md-6" style="padding: 10px;">
                        <div style="padding: 15px; margin-left: 15px; background-color: white;">
                          <img src=""""),_display_(/*56.38*/routes/*56.44*/.Assets.versioned("images/widget/gauseIcon.png")),format.raw/*56.92*/("""" width="100%" alt="" />
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" name="flexRadioDefault" id="gauseChart" onchange="change_widget_action(this)" value="5" style="float: right; margin-right: 10px;">
                        </div>
                        <label class="form-check-label" for="gauseChart" style="margin-top: 10px; font-weight: bold; margin-right: 10px">Biểu đồ máy đo</label>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="card">
                  <div class="col-md-12" style="background-color: #F4F5F6">
                    <div class="row">
                      <div class="col-md-6" style="padding: 10px;">
                        <div style="padding: 15px; margin-left: 15px; background-color: white;">
                          <img src=""""),_display_(/*75.38*/routes/*75.44*/.Assets.versioned("images/widget/mapIcon.png")),format.raw/*75.90*/("""" width="100%" alt="" />
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" name="flexRadioDefault" id="ggMap" onchange="change_widget_action(this)" value="1" style="float: right; margin-right: 10px;">
                        </div>
                        <label class="form-check-label" for="ggMap" style="margin-top: 10px; font-weight: bold; margin-right: 10px">Bản đồ</label>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="card">
                  <div class="col-md-12" style="background-color: #F4F5F6">
                    <div class="row">
                      <div class="col-md-6" style="padding: 10px;">
                        <div style="padding: 15px; margin-left: 15px; background-color: white;">
                          <img src=""""),_display_(/*94.38*/routes/*94.44*/.Assets.versioned("images/widget/dataIcon.png")),format.raw/*94.91*/("""" width="100%" alt="" />
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" name="flexRadioDefault" id="tableData" onchange="change_widget_action(this)" value="2" style="float: right; margin-right: 10px;">
                        </div>
                        <label class="form-check-label" for="tableData" style="margin-top: 10px; font-weight: bold; margin-right: 10px">Bảng dữ liệu</label>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="card">
                  <div class="col-md-12" style="background-color: #F4F5F6">
                    <div class="row">
                      <div class="col-md-6" style="padding: 10px;">
                        <div style="padding: 15px; margin-left: 15px; background-color: white;">
                          <img src=""""),_display_(/*113.38*/routes/*113.44*/.Assets.versioned("images/dashboard/switch.png")),format.raw/*113.92*/("""" width="100%" alt="" />
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" name="flexRadioDefault" id="tableSwitch" onchange="change_widget_action(this)" value="6" style="float: right; margin-right: 10px;">
                        </div>
                        <label class="form-check-label" for="tableSwitch" style="margin-top: 10px; font-weight: bold; margin-right: 10px">Công tắc</label>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="card">
                  <div class="col-md-12" style="background-color: #F4F5F6">
                    <div class="row">
                      <div class="col-md-6" style="padding: 10px;">
                        <div style="padding: 15px; margin-left: 15px; background-color: white;">
                          <img src=""""),_display_(/*132.38*/routes/*132.44*/.Assets.versioned("images/dashboard/data.png")),format.raw/*132.90*/("""" width="100%" alt="" />
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" name="flexRadioDefault" id="tableData" onchange="change_widget_action(this)" value="7" style="float: right; margin-right: 10px;">
                        </div>
                        <label class="form-check-label" for="tableData" style="margin-top: 10px; font-weight: bold; margin-right: 10px">Dữ liệu</label>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="card">
                  <div class="col-md-12" style="background-color: #F4F5F6">
                    <div class="row">
                      <div class="col-md-6" style="padding: 10px;">
                        <div style="padding: 15px; margin-left: 15px; background-color: white;">
                          <img src=""""),_display_(/*151.38*/routes/*151.44*/.Assets.versioned("images/widget/command.png")),format.raw/*151.90*/("""" width="100%" alt="" />
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" name="flexRadioDefault" id="commandData" onchange="change_widget_action(this)" value="8" style="float: right; margin-right: 10px;">
                        </div>
                        <label class="form-check-label" for="commandData" style="margin-top: 10px; font-weight: bold; margin-right: 10px">Command</label>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

            </div>
          </div>
          <div class="col-md-12" id="bodyWidget"></div>
        </form>

      </div>
      <div class="modal-header" style="background-color: white">
        <button type="button" class="btn btn-success" onclick="addNewWidget()">"""),_display_(/*172.81*/Messages("btnComfirm")),format.raw/*172.103*/("""</button>
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*173.77*/Messages("btnClose")),format.raw/*173.97*/("""</button>
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
                  DATE: Mon Sep 22 16:32:43 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboard/widget/Widget_add.scala.html
                  HASH: a4b418dc2717f5e9c307a1072c3bec546369c187
                  MATRIX: 1056->0|1380->298|1425->323|2021->892|2036->898|2109->950|3218->2032|3233->2038|3308->2092|4419->3176|4434->3182|4503->3230|5615->4315|5630->4321|5697->4367|6791->5434|6806->5440|6874->5487|7983->6568|7999->6574|8069->6622|9178->7703|9194->7709|9262->7755|10366->8831|10382->8837|10450->8883|11438->9843|11483->9865|11597->9951|11639->9971
                  LINES: 33->1|37->5|37->5|50->18|50->18|50->18|69->37|69->37|69->37|88->56|88->56|88->56|107->75|107->75|107->75|126->94|126->94|126->94|145->113|145->113|145->113|164->132|164->132|164->132|183->151|183->151|183->151|204->172|204->172|205->173|205->173
                  -- GENERATED --
              */
          