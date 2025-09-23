
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

object Widget_edit_gauge extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editWidgetGaugeModal" tabindex="-1" aria-labelledby="editGaugeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content" id="theme16">
            <div class="modal-header">
                <h5 class="modal-title text-white" id="editGaugeModalLabel">"""),_display_(/*5.78*/Messages("Sửa widget biểu đồ máy đo")),format.raw/*5.115*/("""</h5>
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
                                        <label for="idWidgetGaugeEditTitle" class="col-form-label">"""),_display_(/*18.101*/Messages("Tiêu đề *")),format.raw/*18.122*/("""</label>
                                        <input type="text" class="form-control col-sm-6" id="idWidgetGaugeEditTitle" name="idWidgetGaugeEditTitle">
                                        <h7 class="textNote">"""),_display_(/*20.63*/Messages("manage.group.org.30char")),format.raw/*20.98*/("""</h7>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="header-center">
                                        <label for="idWidgetGaugeEditUnit" class="col-form-label">Đơn vị</label>
                                        <input type="text" class="form-control" id="idWidgetGaugeEditUnit" name="idWidgetGaugeEditUnit">
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="header-center">
                                        <label for="idWidgetGaugeEditMax" class="col-form-label">Giá trị lớn nhất</label>
                                        <input type="number" value="100" min="0" class="form-control" id="idWidgetGaugeEditMax" name="idWidgetGaugeEditMax">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-12 mt-3" style="background: #858687; padding: 8px">
                            <span style="color: white; margin-left: 25px">"""),_display_(/*39.76*/Messages("DỮ LIỆU")),format.raw/*39.95*/("""</span>
                        </div>
                        <div class="col-md-12 mt-3" style="border: 1px solid #858687;">
                            <div class="row p-3">
                                <div class="col-md-6">
                                    <div class="header-center">
                                        <label for="idWidgetGaugeEditOption" class="col-sm-6 col-form-label">"""),_display_(/*45.111*/Messages("Bộ lọc")),format.raw/*45.129*/("""</label>
                                        <select class="form-select mb-3" id="idWidgetGaugeEditOption" name="idWidgetGaugeEditOption" onchange="changeOptionWidgetGaugeEdit(this)">
                                            <option value="" disabled>Chọn</option>
                                            <option value="org">Tổ chức</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <div class="header-center filter" id="idWidgetGaugeOrg" style="display: none">
                                        <label for="selectWidgetGaugeEditOrg" class="col-sm-6 col-form-label">"""),_display_(/*55.112*/Messages("Tổ chức")),format.raw/*55.131*/("""</label>
                                        <select class="form-select mb-3" id="selectWidgetGaugeEditOrg" name="selectWidgetGaugeEditOrg" onchange="changeOrgWidgetGaugeEdit(this)">
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-12" style="display: inline-flex; justify-content: center;">
                                    <div class="table-loading"></div>
                                </div>
                                <div id="idWidgetGaugeTable" style="overflow: auto;"></div>
                            </div>
                        </div>

                    </div>
                    <div class="col-md-1"></div>

                </form>

            </div>
            <div class="modal-header" style="background-color: white">
                <button type="button" class="btn btn-success" onclick="confirmWidgetGauge()">"""),_display_(/*74.95*/Messages("btnComfirm")),format.raw/*74.117*/("""</button>
                <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*75.85*/Messages("btnClose")),format.raw/*75.105*/("""</button>
            </div>
        </div>
    </div>
</div>
<script id="gauge-edit-table-template" type="x-tmpl-mustache">
<input type="hidden" name="widgetGaugeTableCheckbox" id="widgetGaugeTableCheckbox"/>
    <table class="table table-bordered table-nowrap">
        <thead class="thead-light">
            <tr>
                <th>Thiết bị</th>
                <th colspan=100 style="text-align: center;vertical-align: middle;">Thuộc tính</th>
            </tr>

        </thead>
        <tbody>
            """),format.raw/*91.13*/("""{"""),format.raw/*91.14*/("""{"""),format.raw/*91.15*/("""#devices"""),format.raw/*91.23*/("""}"""),format.raw/*91.24*/("""}"""),format.raw/*91.25*/("""
                """),format.raw/*92.17*/("""<tr>
                    <td data-id="""),format.raw/*93.33*/("""{"""),format.raw/*93.34*/("""{"""),format.raw/*93.35*/("""id"""),format.raw/*93.37*/("""}"""),format.raw/*93.38*/("""}"""),format.raw/*93.39*/(""">"""),format.raw/*93.40*/("""{"""),format.raw/*93.41*/("""{"""),format.raw/*93.42*/("""name"""),format.raw/*93.46*/("""}"""),format.raw/*93.47*/("""}"""),format.raw/*93.48*/("""</td>
                    """),format.raw/*94.21*/("""{"""),format.raw/*94.22*/("""{"""),format.raw/*94.23*/("""#vars"""),format.raw/*94.28*/("""}"""),format.raw/*94.29*/("""}"""),format.raw/*94.30*/("""
                        """),format.raw/*95.25*/("""<td>
                            <input """),format.raw/*96.36*/("""{"""),format.raw/*96.37*/("""{"""),format.raw/*96.38*/("""disabled"""),format.raw/*96.46*/("""}"""),format.raw/*96.47*/("""}"""),format.raw/*96.48*/(""" """),format.raw/*96.49*/("""name=""""),format.raw/*96.55*/("""{"""),format.raw/*96.56*/("""{"""),format.raw/*96.57*/("""wid"""),format.raw/*96.60*/("""}"""),format.raw/*96.61*/("""}"""),format.raw/*96.62*/("""" type="radio" data-id="""),format.raw/*96.85*/("""{"""),format.raw/*96.86*/("""{"""),format.raw/*96.87*/("""id"""),format.raw/*96.89*/("""}"""),format.raw/*96.90*/("""}"""),format.raw/*96.91*/(""" """),format.raw/*96.92*/("""data-name="""),format.raw/*96.102*/("""{"""),format.raw/*96.103*/("""{"""),format.raw/*96.104*/("""name"""),format.raw/*96.108*/("""}"""),format.raw/*96.109*/("""}"""),format.raw/*96.110*/(""" """),format.raw/*96.111*/("""id=""""),format.raw/*96.115*/("""{"""),format.raw/*96.116*/("""{"""),format.raw/*96.117*/("""wid"""),format.raw/*96.120*/("""}"""),format.raw/*96.121*/("""}"""),format.raw/*96.122*/("""-"""),format.raw/*96.123*/("""{"""),format.raw/*96.124*/("""{"""),format.raw/*96.125*/("""attribute_key"""),format.raw/*96.138*/("""}"""),format.raw/*96.139*/("""}"""),format.raw/*96.140*/("""" attribute-key="""),format.raw/*96.156*/("""{"""),format.raw/*96.157*/("""{"""),format.raw/*96.158*/("""attribute_key"""),format.raw/*96.171*/("""}"""),format.raw/*96.172*/("""}"""),format.raw/*96.173*/(""" """),format.raw/*96.174*/("""attribute-type="""),format.raw/*96.189*/("""{"""),format.raw/*96.190*/("""{"""),format.raw/*96.191*/("""attribute_type"""),format.raw/*96.205*/("""}"""),format.raw/*96.206*/("""}"""),format.raw/*96.207*/(""" """),format.raw/*96.208*/("""value-type="""),format.raw/*96.219*/("""{"""),format.raw/*96.220*/("""{"""),format.raw/*96.221*/("""value_type"""),format.raw/*96.231*/("""}"""),format.raw/*96.232*/("""}"""),format.raw/*96.233*/(""">
                            <label for=""""),format.raw/*97.41*/("""{"""),format.raw/*97.42*/("""{"""),format.raw/*97.43*/("""wid"""),format.raw/*97.46*/("""}"""),format.raw/*97.47*/("""}"""),format.raw/*97.48*/("""-"""),format.raw/*97.49*/("""{"""),format.raw/*97.50*/("""{"""),format.raw/*97.51*/("""id"""),format.raw/*97.53*/("""}"""),format.raw/*97.54*/("""}"""),format.raw/*97.55*/("""">"""),format.raw/*97.57*/("""{"""),format.raw/*97.58*/("""{"""),format.raw/*97.59*/("""attribute_key"""),format.raw/*97.72*/("""}"""),format.raw/*97.73*/("""}"""),format.raw/*97.74*/("""</label>
                        </td>
                    """),format.raw/*99.21*/("""{"""),format.raw/*99.22*/("""{"""),format.raw/*99.23*/("""/vars"""),format.raw/*99.28*/("""}"""),format.raw/*99.29*/("""}"""),format.raw/*99.30*/("""
                """),format.raw/*100.17*/("""</tr>
            """),format.raw/*101.13*/("""{"""),format.raw/*101.14*/("""{"""),format.raw/*101.15*/("""/devices"""),format.raw/*101.23*/("""}"""),format.raw/*101.24*/("""}"""),format.raw/*101.25*/("""
        """),format.raw/*102.9*/("""</tbody>
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
                  DATE: Mon Sep 22 16:32:43 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboard/widget/Widget_edit_gauge.scala.html
                  HASH: 0dbab70038b43c79542d9980dc87ecb69db76bbf
                  MATRIX: 1063->0|1416->327|1474->364|1860->723|1901->743|2325->1139|2368->1160|2614->1379|2670->1414|3953->2670|3993->2689|4427->3095|4467->3113|5262->3880|5303->3899|6314->4883|6358->4905|6479->4999|6521->5019|7063->5533|7092->5534|7121->5535|7157->5543|7186->5544|7215->5545|7260->5562|7325->5599|7354->5600|7383->5601|7413->5603|7442->5604|7471->5605|7500->5606|7529->5607|7558->5608|7590->5612|7619->5613|7648->5614|7702->5640|7731->5641|7760->5642|7793->5647|7822->5648|7851->5649|7904->5674|7972->5714|8001->5715|8030->5716|8066->5724|8095->5725|8124->5726|8153->5727|8187->5733|8216->5734|8245->5735|8276->5738|8305->5739|8334->5740|8385->5763|8414->5764|8443->5765|8473->5767|8502->5768|8531->5769|8560->5770|8599->5780|8629->5781|8659->5782|8692->5786|8722->5787|8752->5788|8782->5789|8815->5793|8845->5794|8875->5795|8907->5798|8937->5799|8967->5800|8997->5801|9027->5802|9057->5803|9099->5816|9129->5817|9159->5818|9204->5834|9234->5835|9264->5836|9306->5849|9336->5850|9366->5851|9396->5852|9440->5867|9470->5868|9500->5869|9543->5883|9573->5884|9603->5885|9633->5886|9673->5897|9703->5898|9733->5899|9772->5909|9802->5910|9832->5911|9902->5953|9931->5954|9960->5955|9991->5958|10020->5959|10049->5960|10078->5961|10107->5962|10136->5963|10166->5965|10195->5966|10224->5967|10254->5969|10283->5970|10312->5971|10353->5984|10382->5985|10411->5986|10498->6045|10527->6046|10556->6047|10589->6052|10618->6053|10647->6054|10693->6071|10740->6089|10770->6090|10800->6091|10837->6099|10867->6100|10897->6101|10934->6110
                  LINES: 33->1|37->5|37->5|44->12|44->12|50->18|50->18|52->20|52->20|71->39|71->39|77->45|77->45|87->55|87->55|106->74|106->74|107->75|107->75|123->91|123->91|123->91|123->91|123->91|123->91|124->92|125->93|125->93|125->93|125->93|125->93|125->93|125->93|125->93|125->93|125->93|125->93|125->93|126->94|126->94|126->94|126->94|126->94|126->94|127->95|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|128->96|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|129->97|131->99|131->99|131->99|131->99|131->99|131->99|132->100|133->101|133->101|133->101|133->101|133->101|133->101|134->102
                  -- GENERATED --
              */
          