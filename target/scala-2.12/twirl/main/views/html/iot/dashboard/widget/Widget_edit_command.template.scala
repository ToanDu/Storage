
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

object Widget_edit_command extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editWidgetCommandModal" data-widget-id="" tabindex="-1" aria-labelledby="editCommandModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content" id="theme16">
            <div class="modal-header">
                <h5 class="modal-title text-white" id="editCommandModalLabel">"""),_display_(/*5.80*/Messages("Sửa widget command")),format.raw/*5.110*/("""</h5>
            </div>
            <div class="modal-body">
                <form class="row g-3">

                    <div class="col-md-1"></div>
                    <div class="col-md-10">
                        <div class="col-md-12 mt-3" style="background: #858687; padding: 8px">
                            <span style="color: white; margin-left: 25px">"""),_display_(/*13.76*/Messages("DỮ LIỆU")),format.raw/*13.95*/("""</span>
                        </div>
                        <div class="col-md-12 mt-3" style="border: 1px solid #858687;">
                            <div class="row p-3">
                                <div class="col-md-6">
                                    <div class="header-center">
                                        <label for="idWidgetCommandEditOption" class="col-sm-6 col-form-label">"""),_display_(/*19.113*/Messages("Bộ lọc")),format.raw/*19.131*/("""</label>
                                        <select class="form-select mb-3" id="idWidgetCommandEditOption" name="idWidgetCommandEditOption" onchange="changeOptionWidgetCommandEdit(this)">
                                            <option value="">Chọn</option>
                                            <option value="org">Tổ chức</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <div class="header-center filter" id="idWidgetCommandOrg" style="display: none">
                                        <label for="selectWidgetCommandEditOrg" class="col-sm-6 col-form-label">"""),_display_(/*29.114*/Messages("Tổ chức")),format.raw/*29.133*/("""</label>
                                        <select class="form-select mb-3" id="selectWidgetCommandEditOrg" name="selectWidgetCommandEditOrg" onchange="changeOrgWidgetCommandEdit(this)">
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-12" style="display: inline-flex; justify-content: center;">
                                    <div class="table-loading"></div>
                                </div>
                                <div class="col-md-12 filter" id="idWidgetCommandTable"></div>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-1"></div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" onclick="confirmWidgetCommand()">"""),_display_(/*48.97*/Messages("btnComfirm")),format.raw/*48.119*/("""</button>
                <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*49.85*/Messages("btnClose")),format.raw/*49.105*/("""</button>
            </div>
        </div>
    </div>
</div>

<script id="command-edit-table-template" type="x-tmpl-mustache">
    <div class="modal-header" style="background: #858687;">
         <h5 class="modal-title text-white">Chọn thiết bị</h5>
    </div>
    <select class="form-select mb-3" id="selectWidgetCommandEditDevice">
        """),format.raw/*60.9*/("""{"""),format.raw/*60.10*/("""{"""),format.raw/*60.11*/("""#devices"""),format.raw/*60.19*/("""}"""),format.raw/*60.20*/("""}"""),format.raw/*60.21*/("""
                """),format.raw/*61.17*/("""<option """),format.raw/*61.25*/("""{"""),format.raw/*61.26*/("""{"""),format.raw/*61.27*/("""selected"""),format.raw/*61.35*/("""}"""),format.raw/*61.36*/("""}"""),format.raw/*61.37*/(""" """),format.raw/*61.38*/("""value=""""),format.raw/*61.45*/("""{"""),format.raw/*61.46*/("""{"""),format.raw/*61.47*/("""id"""),format.raw/*61.49*/("""}"""),format.raw/*61.50*/("""}"""),format.raw/*61.51*/("""">"""),format.raw/*61.53*/("""{"""),format.raw/*61.54*/("""{"""),format.raw/*61.55*/("""name"""),format.raw/*61.59*/("""}"""),format.raw/*61.60*/("""}"""),format.raw/*61.61*/("""</option>
            """),format.raw/*62.13*/("""{"""),format.raw/*62.14*/("""{"""),format.raw/*62.15*/("""/devices"""),format.raw/*62.23*/("""}"""),format.raw/*62.24*/("""}"""),format.raw/*62.25*/("""
    """),format.raw/*63.5*/("""</select>
</script>"""))
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboard/widget/Widget_edit_command.scala.html
                  HASH: 5dd6e1e506b295f19823d0e697454d59581b2c4b
                  MATRIX: 1065->0|1442->351|1493->381|1885->746|1925->765|2361->1173|2401->1191|3197->1959|3238->1978|4228->2941|4272->2963|4393->3057|4435->3077|4805->3420|4834->3421|4863->3422|4899->3430|4928->3431|4957->3432|5002->3449|5038->3457|5067->3458|5096->3459|5132->3467|5161->3468|5190->3469|5219->3470|5254->3477|5283->3478|5312->3479|5342->3481|5371->3482|5400->3483|5430->3485|5459->3486|5488->3487|5520->3491|5549->3492|5578->3493|5628->3515|5657->3516|5686->3517|5722->3525|5751->3526|5780->3527|5812->3532
                  LINES: 33->1|37->5|37->5|45->13|45->13|51->19|51->19|61->29|61->29|80->48|80->48|81->49|81->49|92->60|92->60|92->60|92->60|92->60|92->60|93->61|93->61|93->61|93->61|93->61|93->61|93->61|93->61|93->61|93->61|93->61|93->61|93->61|93->61|93->61|93->61|93->61|93->61|93->61|93->61|94->62|94->62|94->62|94->62|94->62|94->62|95->63
                  -- GENERATED --
              */
          