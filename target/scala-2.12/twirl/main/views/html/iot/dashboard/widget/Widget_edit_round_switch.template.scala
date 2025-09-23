
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

object Widget_edit_round_switch extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editWidgetRoundSwitchModal" data-widget-id="" tabindex="-1" aria-labelledby="editRoundSwitchModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content" id="theme16">
            <div class="modal-header">
                <h5 class="modal-title text-white" id="editRoundSwitchModalLabel">"""),_display_(/*5.84*/Messages("Sửa widget công tắc")),format.raw/*5.115*/("""</h5>
            </div>
            <div class="modal-body">
                <form class="row g-3">

                    <div class="col-md-1"></div>
                    <div class="col-md-10">
                        """),format.raw/*12.94*/("""
                            """),format.raw/*13.107*/("""
                        """),format.raw/*14.35*/("""
                        """),format.raw/*15.92*/("""
                            """),format.raw/*16.54*/("""
                                """),format.raw/*17.59*/("""
                                    """),format.raw/*18.68*/("""
                                        """),format.raw/*19.140*/("""
                                        """),format.raw/*20.164*/("""
                                        """),format.raw/*21.107*/("""
                                    """),format.raw/*22.47*/("""
                                """),format.raw/*23.43*/("""
                            """),format.raw/*24.39*/("""
                        """),format.raw/*25.35*/("""

                        """),format.raw/*27.25*/("""<div class="col-md-12 mt-3" style="background: #858687; padding: 8px">
                            <span style="color: white; margin-left: 25px">"""),_display_(/*28.76*/Messages("DỮ LIỆU")),format.raw/*28.95*/("""</span>
                        </div>
                        <div class="col-md-12 mt-3" style="border: 1px solid #858687;">
                            <div class="row p-3">
                                <div class="col-md-6">
                                    <div class="header-center">
                                        <label for="idWidgetRoundSwitchEditOption" class="col-sm-6 col-form-label">"""),_display_(/*34.117*/Messages("Bộ lọc")),format.raw/*34.135*/("""</label>
                                        <select class="form-select mb-3" id="idWidgetRoundSwitchEditOption" name="idWidgetRoundSwitchEditOption" onchange="changeOptionWidgetRoundSwitchEdit(this)">
                                            <option value="" disabled>Chọn</option>
                                            <option value="org">Tổ chức</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <div class="header-center filter" id="idWidgetRoundSwitchOrg" style="display: none">
                                        <label for="idWidgetRoundSwitchEditOption" class="col-sm-6 col-form-label">"""),_display_(/*44.117*/Messages("Tổ chức")),format.raw/*44.136*/("""</label>
                                        <select class="form-select mb-3" id="selectWidgetRoundSwitchEditOrg" name="selectWidgetRoundSwitchEditOrg" onchange="changeOrgWidgetRoundSwitchEdit(this)">
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-12" style="display: inline-flex; justify-content: center;">
                                    <div class="table-loading"></div>
                                </div>
                                <div class="col-md-12 filter" id="idWidgetRoundSwitchTable"></div>

                                <div class="col-md-4">
                                    <div class="modal-header" style="background: #858687;">
                                        <h6 class="modal-title text-white">"""),_display_(/*56.77*/Messages("Topic")),format.raw/*56.94*/("""</h6>
                                    </div>
                                    <input class="form-control " id="widgetRoundSwitchTopic">
                                </div>
                                <div class="col-md-4">
                                    <div class="modal-header" style="background: #858687;">
                                        <h5 class="modal-title text-white">Bật TB</h5>
                                    </div>
                                    <textarea class="form-control " id="widgetRoundSwitchOn"></textarea>
                                </div>
                                <div class="col-md-4">
                                    <div class="modal-header" style="background: #858687;">
                                        <h5 class="modal-title text-white">Tắt TB</h5>
                                    </div>
                                    <textarea class="form-control " id="widgetRoundSwitchOff"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-1"></div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" onclick="confirmWidgetRoundSwitch()">"""),_display_(/*81.101*/Messages("btnComfirm")),format.raw/*81.123*/("""</button>
                <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*82.85*/Messages("btnClose")),format.raw/*82.105*/("""</button>
            </div>
        </div>
    </div>
</div>


<script id="round-switch-edit-template" type="x-tmpl-mustache">
    <input type="hidden" name="widgetRoundSwitchCheckbox" id="widgetRoundSwitchCheckbox"/>
    <table class="table table-bordered table-nowrap">
        <thead class="thead-light">
            <tr>
                <th>Thiết bị</th>
                <th colspan=100 style="text-align: center;vertical-align: middle;">Thuộc tính trạng thái TB</th>
            </tr>

        </thead>
        <tbody>
            """),format.raw/*100.13*/("""{"""),format.raw/*100.14*/("""{"""),format.raw/*100.15*/("""#devices"""),format.raw/*100.23*/("""}"""),format.raw/*100.24*/("""}"""),format.raw/*100.25*/("""
                """),format.raw/*101.17*/("""<tr>
                    <td data-id="""),format.raw/*102.33*/("""{"""),format.raw/*102.34*/("""{"""),format.raw/*102.35*/("""id"""),format.raw/*102.37*/("""}"""),format.raw/*102.38*/("""}"""),format.raw/*102.39*/(""">"""),format.raw/*102.40*/("""{"""),format.raw/*102.41*/("""{"""),format.raw/*102.42*/("""name"""),format.raw/*102.46*/("""}"""),format.raw/*102.47*/("""}"""),format.raw/*102.48*/("""</td>
                    """),format.raw/*103.21*/("""{"""),format.raw/*103.22*/("""{"""),format.raw/*103.23*/("""#vars"""),format.raw/*103.28*/("""}"""),format.raw/*103.29*/("""}"""),format.raw/*103.30*/("""
                        """),format.raw/*104.25*/("""<td>
                            <input """),format.raw/*105.36*/("""{"""),format.raw/*105.37*/("""{"""),format.raw/*105.38*/("""disabled"""),format.raw/*105.46*/("""}"""),format.raw/*105.47*/("""}"""),format.raw/*105.48*/(""" """),format.raw/*105.49*/("""name=""""),format.raw/*105.55*/("""{"""),format.raw/*105.56*/("""{"""),format.raw/*105.57*/("""wid"""),format.raw/*105.60*/("""}"""),format.raw/*105.61*/("""}"""),format.raw/*105.62*/("""" type="radio" data-id="""),format.raw/*105.85*/("""{"""),format.raw/*105.86*/("""{"""),format.raw/*105.87*/("""id"""),format.raw/*105.89*/("""}"""),format.raw/*105.90*/("""}"""),format.raw/*105.91*/(""" """),format.raw/*105.92*/("""data-name="""),format.raw/*105.102*/("""{"""),format.raw/*105.103*/("""{"""),format.raw/*105.104*/("""name"""),format.raw/*105.108*/("""}"""),format.raw/*105.109*/("""}"""),format.raw/*105.110*/(""" """),format.raw/*105.111*/("""id=""""),format.raw/*105.115*/("""{"""),format.raw/*105.116*/("""{"""),format.raw/*105.117*/("""wid"""),format.raw/*105.120*/("""}"""),format.raw/*105.121*/("""}"""),format.raw/*105.122*/("""-"""),format.raw/*105.123*/("""{"""),format.raw/*105.124*/("""{"""),format.raw/*105.125*/("""attribute_key"""),format.raw/*105.138*/("""}"""),format.raw/*105.139*/("""}"""),format.raw/*105.140*/("""" attribute-key="""),format.raw/*105.156*/("""{"""),format.raw/*105.157*/("""{"""),format.raw/*105.158*/("""attribute_key"""),format.raw/*105.171*/("""}"""),format.raw/*105.172*/("""}"""),format.raw/*105.173*/(""" """),format.raw/*105.174*/("""attribute-type="""),format.raw/*105.189*/("""{"""),format.raw/*105.190*/("""{"""),format.raw/*105.191*/("""attribute_type"""),format.raw/*105.205*/("""}"""),format.raw/*105.206*/("""}"""),format.raw/*105.207*/(""" """),format.raw/*105.208*/("""value-type="""),format.raw/*105.219*/("""{"""),format.raw/*105.220*/("""{"""),format.raw/*105.221*/("""value_type"""),format.raw/*105.231*/("""}"""),format.raw/*105.232*/("""}"""),format.raw/*105.233*/(""">
                            <label for=""""),format.raw/*106.41*/("""{"""),format.raw/*106.42*/("""{"""),format.raw/*106.43*/("""wid"""),format.raw/*106.46*/("""}"""),format.raw/*106.47*/("""}"""),format.raw/*106.48*/("""-"""),format.raw/*106.49*/("""{"""),format.raw/*106.50*/("""{"""),format.raw/*106.51*/("""id"""),format.raw/*106.53*/("""}"""),format.raw/*106.54*/("""}"""),format.raw/*106.55*/("""">"""),format.raw/*106.57*/("""{"""),format.raw/*106.58*/("""{"""),format.raw/*106.59*/("""attribute_key"""),format.raw/*106.72*/("""}"""),format.raw/*106.73*/("""}"""),format.raw/*106.74*/("""</label>
                        </td>
                    """),format.raw/*108.21*/("""{"""),format.raw/*108.22*/("""{"""),format.raw/*108.23*/("""/vars"""),format.raw/*108.28*/("""}"""),format.raw/*108.29*/("""}"""),format.raw/*108.30*/("""
                """),format.raw/*109.17*/("""</tr>
            """),format.raw/*110.13*/("""{"""),format.raw/*110.14*/("""{"""),format.raw/*110.15*/("""/devices"""),format.raw/*110.23*/("""}"""),format.raw/*110.24*/("""}"""),format.raw/*110.25*/("""
        """),format.raw/*111.9*/("""</tbody>
    </table>
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
                  DATE: Mon Sep 22 16:32:44 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboard/widget/Widget_edit_round_switch.scala.html
                  HASH: eaa039a38a63044f56a1ebaaee7b9d757f1246a9
                  MATRIX: 1070->0|1459->363|1511->394|1758->682|1816->789|1869->824|1922->916|1979->970|2040->1029|2105->1097|2175->1237|2245->1401|2315->1508|2380->1555|2441->1598|2498->1637|2551->1672|2605->1698|2778->1844|2818->1863|3258->2275|3298->2293|4122->3089|4163->3108|5070->3988|5108->4005|6487->5356|6531->5378|6652->5472|6694->5492|7260->6029|7290->6030|7320->6031|7357->6039|7387->6040|7417->6041|7463->6058|7529->6095|7559->6096|7589->6097|7620->6099|7650->6100|7680->6101|7710->6102|7740->6103|7770->6104|7803->6108|7833->6109|7863->6110|7918->6136|7948->6137|7978->6138|8012->6143|8042->6144|8072->6145|8126->6170|8195->6210|8225->6211|8255->6212|8292->6220|8322->6221|8352->6222|8382->6223|8417->6229|8447->6230|8477->6231|8509->6234|8539->6235|8569->6236|8621->6259|8651->6260|8681->6261|8712->6263|8742->6264|8772->6265|8802->6266|8842->6276|8873->6277|8904->6278|8938->6282|8969->6283|9000->6284|9031->6285|9065->6289|9096->6290|9127->6291|9160->6294|9191->6295|9222->6296|9253->6297|9284->6298|9315->6299|9358->6312|9389->6313|9420->6314|9466->6330|9497->6331|9528->6332|9571->6345|9602->6346|9633->6347|9664->6348|9709->6363|9740->6364|9771->6365|9815->6379|9846->6380|9877->6381|9908->6382|9949->6393|9980->6394|10011->6395|10051->6405|10082->6406|10113->6407|10184->6449|10214->6450|10244->6451|10276->6454|10306->6455|10336->6456|10366->6457|10396->6458|10426->6459|10457->6461|10487->6462|10517->6463|10548->6465|10578->6466|10608->6467|10650->6480|10680->6481|10710->6482|10798->6541|10828->6542|10858->6543|10892->6548|10922->6549|10952->6550|10998->6567|11045->6585|11075->6586|11105->6587|11142->6595|11172->6596|11202->6597|11239->6606
                  LINES: 33->1|37->5|37->5|44->12|45->13|46->14|47->15|48->16|49->17|50->18|51->19|52->20|53->21|54->22|55->23|56->24|57->25|59->27|60->28|60->28|66->34|66->34|76->44|76->44|88->56|88->56|113->81|113->81|114->82|114->82|132->100|132->100|132->100|132->100|132->100|132->100|133->101|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|135->103|135->103|135->103|135->103|135->103|135->103|136->104|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|137->105|138->106|138->106|138->106|138->106|138->106|138->106|138->106|138->106|138->106|138->106|138->106|138->106|138->106|138->106|138->106|138->106|138->106|138->106|140->108|140->108|140->108|140->108|140->108|140->108|141->109|142->110|142->110|142->110|142->110|142->110|142->110|143->111
                  -- GENERATED --
              */
          