
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

object Widget_edit_chart_line extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editWidgetChartLineModal" tabindex="-1" aria-labelledby="editChartLineModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content" id="theme16">
            <div class="modal-header">
                <h5 class="modal-title text-white" id="editChartLineModalLabel">"""),_display_(/*5.82*/Messages("widget.chartLine")),format.raw/*5.110*/("""</h5>
            </div>
            <div class="modal-body">
                <form class="row g-3">
                    <div class="col-md-1"></div>
                    <div class="col-md-10">
                        <div class="col-md-12" style="background: #858687; padding: 8px">
                            <span style="color: white; margin-left: 25px">"""),_display_(/*12.76*/Messages("HIỂN THỊ")),format.raw/*12.96*/("""</span>
                        </div>
                        <div class="col-md-12 mt-3" style="border: 1px solid #858687;">
                            <div class="row p-3">
                                <div class="col-md-6">
                                    <div class="header-center">
                                        <label for="idWidgetChartLineEditTitle" class="col-form-label">"""),_display_(/*18.105*/Messages("Tiêu đề *")),format.raw/*18.126*/("""</label>
                                        <input type="text" class="form-control col-sm-6" id="idWidgetChartLineEditTitle" name="idWidgetChartLineEditTitle">
                                        <h7 class="textNote">"""),_display_(/*20.63*/Messages("manage.group.org.30char")),format.raw/*20.98*/("""</h7>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-12 mt-3" style="background: #858687; padding: 8px">
                            <span style="color: white; margin-left: 25px">"""),_display_(/*27.76*/Messages("DỮ LIỆU")),format.raw/*27.95*/("""</span>
                        </div>
                        <div class="col-md-12 mt-3" style="border: 1px solid #858687;">
                            <div class="row p-3">
                                <div class="col-md-6">
                                    <div class="header-center">
                                        <label for="idWidgetChartLineEditOption" class="col-sm-6 col-form-label">"""),_display_(/*33.115*/Messages("Bộ lọc")),format.raw/*33.133*/("""</label>
                                        <select class="form-select mb-3" id="idWidgetChartLineEditOption" name="idWidgetChartLineEditOption" onchange="changeOptionWidgetChartLineEdit(this)">
                                            <option value="" disabled>Chọn</option>
                                            """),format.raw/*36.99*/("""
                                            """),format.raw/*37.45*/("""<option value="org">Tổ chức</option>
                                            """),format.raw/*38.93*/("""
                                            """),format.raw/*39.98*/("""
                                        """),format.raw/*40.41*/("""</select>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <div class="header-center filter" id="idWidgetChartLineOrg" style="display: none">
                                        <label for="idWidgetChartLineEditOption" class="col-sm-6 col-form-label">"""),_display_(/*46.115*/Messages("Tổ chức")),format.raw/*46.134*/("""</label>
                                        <select class="form-select mb-3" id="selectWidgetChartLineEditOrg" name="selectWidgetChartLineEditOrg" onchange="changeOrgWidgetChartLineEdit(this)">
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-12" style="display: inline-flex; justify-content: center;">
                                    <div class="table-loading"></div>
                                </div>
                                <div id="idWidgetChartLineTable" style="overflow: auto;"></div>

                                <div class="form-group row">
                                    <div class="col-md-5 filter" id="idWidgetChartLineGroup" style="display:none;">
                                        <select class="form-select mb-3" id="selectWidgetChartLineEditGroup" name="selectWidgetChartLineEditGroup" onchange="changeGroupWidgetChartLineEdit(this)">
                                        </select>
                                    </div>
                                    <div class="col-md-5 filter" id="idWidgetChartLineDT" style="display:none;">
                                        <select class="form-select mb-3" id="selectWidgetChartLineEditDT" name="selectWidgetChartLineEditDT" onchange="changeDTWidgetChartLineEdit(this)">
                                        </select>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-1"></div>
                </form>

            </div>
            <div class="modal-header" style="background-color: white">
                <button type="button" class="btn btn-success" onclick="confirmWidgetChartLine()">"""),_display_(/*75.99*/Messages("btnComfirm")),format.raw/*75.121*/("""</button>
                <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*76.85*/Messages("btnClose")),format.raw/*76.105*/("""</button>
            </div>
        </div>
    </div>
</div>
<script id="chart-line-edit-table-template" type="x-tmpl-mustache">
    <input type="hidden" name="widgetChartLineTableCheckbox" id="widgetChartLineTableCheckbox"/>
    <table class="table table-bordered table-nowrap">
        <thead class="thead-light">
            <tr>
                <th>Thiết bị</th>
                <th colspan=100 style="text-align: center;vertical-align: middle;">Thuộc tính</th>
            </tr>

        </thead>
        <tbody>
            """),format.raw/*92.13*/("""{"""),format.raw/*92.14*/("""{"""),format.raw/*92.15*/("""#devices"""),format.raw/*92.23*/("""}"""),format.raw/*92.24*/("""}"""),format.raw/*92.25*/("""
                """),format.raw/*93.17*/("""<tr>
                    <td data-id="""),format.raw/*94.33*/("""{"""),format.raw/*94.34*/("""{"""),format.raw/*94.35*/("""id"""),format.raw/*94.37*/("""}"""),format.raw/*94.38*/("""}"""),format.raw/*94.39*/(""" """),format.raw/*94.40*/("""style="width:15%">"""),format.raw/*94.58*/("""{"""),format.raw/*94.59*/("""{"""),format.raw/*94.60*/("""name"""),format.raw/*94.64*/("""}"""),format.raw/*94.65*/("""}"""),format.raw/*94.66*/("""</td>
                    """),format.raw/*95.21*/("""{"""),format.raw/*95.22*/("""{"""),format.raw/*95.23*/("""#vars"""),format.raw/*95.28*/("""}"""),format.raw/*95.29*/("""}"""),format.raw/*95.30*/("""
                    """),format.raw/*96.21*/("""<td>
                        <input """),format.raw/*97.32*/("""{"""),format.raw/*97.33*/("""{"""),format.raw/*97.34*/("""disabled"""),format.raw/*97.42*/("""}"""),format.raw/*97.43*/("""}"""),format.raw/*97.44*/(""" """),format.raw/*97.45*/("""type="checkbox" data-id="""),format.raw/*97.69*/("""{"""),format.raw/*97.70*/("""{"""),format.raw/*97.71*/("""id"""),format.raw/*97.73*/("""}"""),format.raw/*97.74*/("""}"""),format.raw/*97.75*/(""" """),format.raw/*97.76*/("""data-name="""),format.raw/*97.86*/("""{"""),format.raw/*97.87*/("""{"""),format.raw/*97.88*/("""name"""),format.raw/*97.92*/("""}"""),format.raw/*97.93*/("""}"""),format.raw/*97.94*/(""" """),format.raw/*97.95*/("""id=""""),format.raw/*97.99*/("""{"""),format.raw/*97.100*/("""{"""),format.raw/*97.101*/("""wid"""),format.raw/*97.104*/("""}"""),format.raw/*97.105*/("""}"""),format.raw/*97.106*/("""-"""),format.raw/*97.107*/("""{"""),format.raw/*97.108*/("""{"""),format.raw/*97.109*/("""attribute_key"""),format.raw/*97.122*/("""}"""),format.raw/*97.123*/("""}"""),format.raw/*97.124*/("""" attribute-key="""),format.raw/*97.140*/("""{"""),format.raw/*97.141*/("""{"""),format.raw/*97.142*/("""attribute_key"""),format.raw/*97.155*/("""}"""),format.raw/*97.156*/("""}"""),format.raw/*97.157*/(""" """),format.raw/*97.158*/("""attribute-type="""),format.raw/*97.173*/("""{"""),format.raw/*97.174*/("""{"""),format.raw/*97.175*/("""attribute_type"""),format.raw/*97.189*/("""}"""),format.raw/*97.190*/("""}"""),format.raw/*97.191*/(""" """),format.raw/*97.192*/("""value-type="""),format.raw/*97.203*/("""{"""),format.raw/*97.204*/("""{"""),format.raw/*97.205*/("""value_type"""),format.raw/*97.215*/("""}"""),format.raw/*97.216*/("""}"""),format.raw/*97.217*/(""">
                        <label for=""""),format.raw/*98.37*/("""{"""),format.raw/*98.38*/("""{"""),format.raw/*98.39*/("""wid"""),format.raw/*98.42*/("""}"""),format.raw/*98.43*/("""}"""),format.raw/*98.44*/("""-"""),format.raw/*98.45*/("""{"""),format.raw/*98.46*/("""{"""),format.raw/*98.47*/("""attribute_key"""),format.raw/*98.60*/("""}"""),format.raw/*98.61*/("""}"""),format.raw/*98.62*/("""">"""),format.raw/*98.64*/("""{"""),format.raw/*98.65*/("""{"""),format.raw/*98.66*/("""attribute_key"""),format.raw/*98.79*/("""}"""),format.raw/*98.80*/("""}"""),format.raw/*98.81*/("""</label>
                    </td>
                    """),format.raw/*100.21*/("""{"""),format.raw/*100.22*/("""{"""),format.raw/*100.23*/("""/vars"""),format.raw/*100.28*/("""}"""),format.raw/*100.29*/("""}"""),format.raw/*100.30*/("""
                """),format.raw/*101.17*/("""</tr>
            """),format.raw/*102.13*/("""{"""),format.raw/*102.14*/("""{"""),format.raw/*102.15*/("""/devices"""),format.raw/*102.23*/("""}"""),format.raw/*102.24*/("""}"""),format.raw/*102.25*/("""
        """),format.raw/*103.9*/("""</tbody>
    </table>
</script>



"""),format.raw/*109.9*/("""
"""),format.raw/*110.112*/("""
"""),format.raw/*111.42*/("""
"""),format.raw/*112.86*/("""
"""),format.raw/*113.22*/("""
"""),format.raw/*114.18*/("""
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
                  DATE: Mon Sep 22 16:32:43 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboard/widget/Widget_edit_chart_line.scala.html
                  HASH: cd733bab259d1bf2ae1be5e7897fd41a30f40abc
                  MATRIX: 1068->0|1433->339|1482->367|1868->726|1909->746|2337->1146|2380->1167|2634->1394|2690->1429|3042->1754|3082->1773|3520->2183|3560->2201|3916->2583|3989->2628|4098->2757|4171->2855|4240->2896|4649->3277|4690->3296|6619->5198|6663->5220|6784->5314|6826->5334|7385->5865|7414->5866|7443->5867|7479->5875|7508->5876|7537->5877|7582->5894|7647->5931|7676->5932|7705->5933|7735->5935|7764->5936|7793->5937|7822->5938|7868->5956|7897->5957|7926->5958|7958->5962|7987->5963|8016->5964|8070->5990|8099->5991|8128->5992|8161->5997|8190->5998|8219->5999|8268->6020|8332->6056|8361->6057|8390->6058|8426->6066|8455->6067|8484->6068|8513->6069|8565->6093|8594->6094|8623->6095|8653->6097|8682->6098|8711->6099|8740->6100|8778->6110|8807->6111|8836->6112|8868->6116|8897->6117|8926->6118|8955->6119|8987->6123|9017->6124|9047->6125|9079->6128|9109->6129|9139->6130|9169->6131|9199->6132|9229->6133|9271->6146|9301->6147|9331->6148|9376->6164|9406->6165|9436->6166|9478->6179|9508->6180|9538->6181|9568->6182|9612->6197|9642->6198|9672->6199|9715->6213|9745->6214|9775->6215|9805->6216|9845->6227|9875->6228|9905->6229|9944->6239|9974->6240|10004->6241|10070->6279|10099->6280|10128->6281|10159->6284|10188->6285|10217->6286|10246->6287|10275->6288|10304->6289|10345->6302|10374->6303|10403->6304|10433->6306|10462->6307|10491->6308|10532->6321|10561->6322|10590->6323|10674->6378|10704->6379|10734->6380|10768->6385|10798->6386|10828->6387|10874->6404|10921->6422|10951->6423|10981->6424|11018->6432|11048->6433|11078->6434|11115->6443|11178->6486|11209->6598|11239->6640|11269->6726|11299->6748|11329->6766
                  LINES: 33->1|37->5|37->5|44->12|44->12|50->18|50->18|52->20|52->20|59->27|59->27|65->33|65->33|68->36|69->37|70->38|71->39|72->40|78->46|78->46|107->75|107->75|108->76|108->76|124->92|124->92|124->92|124->92|124->92|124->92|125->93|126->94|126->94|126->94|126->94|126->94|126->94|126->94|126->94|126->94|126->94|126->94|126->94|126->94|127->95|127->95|127->95|127->95|127->95|127->95|128->96|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|130->98|130->98|130->98|130->98|130->98|130->98|130->98|130->98|130->98|130->98|130->98|130->98|130->98|130->98|130->98|130->98|130->98|130->98|132->100|132->100|132->100|132->100|132->100|132->100|133->101|134->102|134->102|134->102|134->102|134->102|134->102|135->103|141->109|142->110|143->111|144->112|145->113|146->114
                  -- GENERATED --
              */
          