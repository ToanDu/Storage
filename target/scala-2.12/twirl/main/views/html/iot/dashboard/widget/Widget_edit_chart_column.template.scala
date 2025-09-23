
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

object Widget_edit_chart_column extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editWidgetChartColumnModal" tabindex="-1" aria-labelledby="editChartColumnModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content" id="theme16">
            <div class="modal-header">
                <h5 class="modal-title text-white" id="editChartColumnModalLabel">"""),_display_(/*5.84*/Messages("Sửa widget biều đồ cột")),format.raw/*5.118*/("""</h5>
            </div>
            <div class="modal-body">
                <form class="row g-3">

                    <div class="col-md-1"></div>
                    <div class="col-md-10">
                        <div class="col-md-12" style="background: #858687; padding: 8px">
                            <span style="color: white; margin-left: 25px">"""),_display_(/*13.76*/Messages("HIỂN THỊ")),format.raw/*13.96*/("""</span>
                        </div>
                        <div class="col-md-12 mt-3" style="border: 1px solid #858687;">
                            <div class="row p-3">
                                <div class="col-md-6">
                                    <div class="header-center">
                                        <label for="idWidgetChartLineEditTitle" class="col-form-label">"""),_display_(/*19.105*/Messages("Tiêu đề *")),format.raw/*19.126*/("""</label>
                                        <input type="text" class="form-control col-sm-6" id="idWidgetChartColumnEditTitle" name="idWidgetChartColumnEditTitle">
                                        <h7 class="textNote">"""),_display_(/*21.63*/Messages("manage.group.org.30char")),format.raw/*21.98*/("""</h7>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-12 mt-3" style="background: #858687; padding: 8px">
                            <span style="color: white; margin-left: 25px">"""),_display_(/*28.76*/Messages("DỮ LIỆU")),format.raw/*28.95*/("""</span>
                        </div>
                        <div class="col-md-12 mt-3" style="border: 1px solid #858687;">
                            <div class="row p-3">
                                <div class="col-md-6">
                                    <div class="header-center">
                                        <label for="idWidgetChartColumnEditOption" class="col-sm-6 col-form-label">"""),_display_(/*34.117*/Messages("Bộ lọc")),format.raw/*34.135*/("""</label>
                                        <select class="form-select mb-3" id="idWidgetChartColumnEditOption" name="idWidgetChartColumnEditOption" onchange="changeOptionWidgetChartColumnEdit(this)">
                                            <option value="" disabled>Chọn</option>
                                            <option value="org">Tổ chức</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <div class="header-center filter" id="idWidgetChartColumnOrg" style="display: none">
                                        <label for="idWidgetChartColumnEditOption" class="col-sm-6 col-form-label">"""),_display_(/*44.117*/Messages("Tổ chức")),format.raw/*44.136*/("""</label>
                                        <select class="form-select mb-3" id="selectWidgetChartColumnEditOrg" name="selectWidgetChartColumnEditOrg" onchange="changeOrgWidgetChartColumnEdit(this)">
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-12" style="display: inline-flex; justify-content: center;">
                                    <div class="table-loading"></div>
                                </div>
                                <div id="idWidgetChartColumnTable" style="overflow: auto;"></div>
                            </div>
                        </div>

                    </div>
                    <div class="col-md-1"></div>
                </form>

            </div>
            <div class="modal-header" style="background-color: white">
                <button type="button" class="btn btn-success" onclick="confirmWidgetChartColumn()">"""),_display_(/*62.101*/Messages("btnComfirm")),format.raw/*62.123*/("""</button>
                <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*63.85*/Messages("btnClose")),format.raw/*63.105*/("""</button>
            </div>
        </div>
    </div>
</div>
<script id="chart-column-edit-table-template" type="x-tmpl-mustache">
    <input type="hidden" name="widgetChartColumnTableCheckbox" id="widgetChartColumnTableCheckbox"/>
    <table class="table table-bordered table-nowrap">
        <thead class="thead-light">
            <tr>
                <th>Thiết bị</th>
                <th colspan=100 style="text-align: center;vertical-align: middle;">Thuộc tính</th>
            </tr>

        </thead>
        <tbody>
            """),format.raw/*79.13*/("""{"""),format.raw/*79.14*/("""{"""),format.raw/*79.15*/("""#devices"""),format.raw/*79.23*/("""}"""),format.raw/*79.24*/("""}"""),format.raw/*79.25*/("""
                """),format.raw/*80.17*/("""<tr>
                    <td data-id="""),format.raw/*81.33*/("""{"""),format.raw/*81.34*/("""{"""),format.raw/*81.35*/("""id"""),format.raw/*81.37*/("""}"""),format.raw/*81.38*/("""}"""),format.raw/*81.39*/("""><b>"""),format.raw/*81.43*/("""{"""),format.raw/*81.44*/("""{"""),format.raw/*81.45*/("""name"""),format.raw/*81.49*/("""}"""),format.raw/*81.50*/("""}"""),format.raw/*81.51*/("""</b></td>
                    """),format.raw/*82.21*/("""{"""),format.raw/*82.22*/("""{"""),format.raw/*82.23*/("""#vars"""),format.raw/*82.28*/("""}"""),format.raw/*82.29*/("""}"""),format.raw/*82.30*/("""
                        """),format.raw/*83.25*/("""<td>
                            <input """),format.raw/*84.36*/("""{"""),format.raw/*84.37*/("""{"""),format.raw/*84.38*/("""disabled"""),format.raw/*84.46*/("""}"""),format.raw/*84.47*/("""}"""),format.raw/*84.48*/(""" """),format.raw/*84.49*/("""type="checkbox" data-id="""),format.raw/*84.73*/("""{"""),format.raw/*84.74*/("""{"""),format.raw/*84.75*/("""id"""),format.raw/*84.77*/("""}"""),format.raw/*84.78*/("""}"""),format.raw/*84.79*/(""" """),format.raw/*84.80*/("""data-name="""),format.raw/*84.90*/("""{"""),format.raw/*84.91*/("""{"""),format.raw/*84.92*/("""name"""),format.raw/*84.96*/("""}"""),format.raw/*84.97*/("""}"""),format.raw/*84.98*/(""" """),format.raw/*84.99*/("""id=""""),format.raw/*84.103*/("""{"""),format.raw/*84.104*/("""{"""),format.raw/*84.105*/("""wid"""),format.raw/*84.108*/("""}"""),format.raw/*84.109*/("""}"""),format.raw/*84.110*/("""-"""),format.raw/*84.111*/("""{"""),format.raw/*84.112*/("""{"""),format.raw/*84.113*/("""attribute_key"""),format.raw/*84.126*/("""}"""),format.raw/*84.127*/("""}"""),format.raw/*84.128*/("""" attribute-key="""),format.raw/*84.144*/("""{"""),format.raw/*84.145*/("""{"""),format.raw/*84.146*/("""attribute_key"""),format.raw/*84.159*/("""}"""),format.raw/*84.160*/("""}"""),format.raw/*84.161*/(""" """),format.raw/*84.162*/("""attribute-type="""),format.raw/*84.177*/("""{"""),format.raw/*84.178*/("""{"""),format.raw/*84.179*/("""attribute_type"""),format.raw/*84.193*/("""}"""),format.raw/*84.194*/("""}"""),format.raw/*84.195*/(""" """),format.raw/*84.196*/("""value-type="""),format.raw/*84.207*/("""{"""),format.raw/*84.208*/("""{"""),format.raw/*84.209*/("""value_type"""),format.raw/*84.219*/("""}"""),format.raw/*84.220*/("""}"""),format.raw/*84.221*/(""">
                            <label for=""""),format.raw/*85.41*/("""{"""),format.raw/*85.42*/("""{"""),format.raw/*85.43*/("""wid"""),format.raw/*85.46*/("""}"""),format.raw/*85.47*/("""}"""),format.raw/*85.48*/("""-"""),format.raw/*85.49*/("""{"""),format.raw/*85.50*/("""{"""),format.raw/*85.51*/("""attribute_key"""),format.raw/*85.64*/("""}"""),format.raw/*85.65*/("""}"""),format.raw/*85.66*/("""">"""),format.raw/*85.68*/("""{"""),format.raw/*85.69*/("""{"""),format.raw/*85.70*/("""attribute_key"""),format.raw/*85.83*/("""}"""),format.raw/*85.84*/("""}"""),format.raw/*85.85*/("""</label>
                        </td>
                    """),format.raw/*87.21*/("""{"""),format.raw/*87.22*/("""{"""),format.raw/*87.23*/("""/vars"""),format.raw/*87.28*/("""}"""),format.raw/*87.29*/("""}"""),format.raw/*87.30*/("""
                """),format.raw/*88.17*/("""</tr>
            """),format.raw/*89.13*/("""{"""),format.raw/*89.14*/("""{"""),format.raw/*89.15*/("""/devices"""),format.raw/*89.23*/("""}"""),format.raw/*89.24*/("""}"""),format.raw/*89.25*/("""
        """),format.raw/*90.9*/("""</tbody>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboard/widget/Widget_edit_chart_column.scala.html
                  HASH: 7df541f5fb997cbf8d01bb47677060722e5d6e3e
                  MATRIX: 1070->0|1441->345|1496->379|1883->739|1924->759|2352->1159|2395->1180|2653->1411|2709->1446|3061->1771|3101->1790|3541->2202|3581->2220|4405->3016|4446->3035|5487->4048|5531->4070|5652->4164|5694->4184|6259->4721|6288->4722|6317->4723|6353->4731|6382->4732|6411->4733|6456->4750|6521->4787|6550->4788|6579->4789|6609->4791|6638->4792|6667->4793|6699->4797|6728->4798|6757->4799|6789->4803|6818->4804|6847->4805|6905->4835|6934->4836|6963->4837|6996->4842|7025->4843|7054->4844|7107->4869|7175->4909|7204->4910|7233->4911|7269->4919|7298->4920|7327->4921|7356->4922|7408->4946|7437->4947|7466->4948|7496->4950|7525->4951|7554->4952|7583->4953|7621->4963|7650->4964|7679->4965|7711->4969|7740->4970|7769->4971|7798->4972|7831->4976|7861->4977|7891->4978|7923->4981|7953->4982|7983->4983|8013->4984|8043->4985|8073->4986|8115->4999|8145->5000|8175->5001|8220->5017|8250->5018|8280->5019|8322->5032|8352->5033|8382->5034|8412->5035|8456->5050|8486->5051|8516->5052|8559->5066|8589->5067|8619->5068|8649->5069|8689->5080|8719->5081|8749->5082|8788->5092|8818->5093|8848->5094|8918->5136|8947->5137|8976->5138|9007->5141|9036->5142|9065->5143|9094->5144|9123->5145|9152->5146|9193->5159|9222->5160|9251->5161|9281->5163|9310->5164|9339->5165|9380->5178|9409->5179|9438->5180|9525->5239|9554->5240|9583->5241|9616->5246|9645->5247|9674->5248|9719->5265|9765->5283|9794->5284|9823->5285|9859->5293|9888->5294|9917->5295|9953->5304
                  LINES: 33->1|37->5|37->5|45->13|45->13|51->19|51->19|53->21|53->21|60->28|60->28|66->34|66->34|76->44|76->44|94->62|94->62|95->63|95->63|111->79|111->79|111->79|111->79|111->79|111->79|112->80|113->81|113->81|113->81|113->81|113->81|113->81|113->81|113->81|113->81|113->81|113->81|113->81|114->82|114->82|114->82|114->82|114->82|114->82|115->83|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|116->84|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|119->87|119->87|119->87|119->87|119->87|119->87|120->88|121->89|121->89|121->89|121->89|121->89|121->89|122->90
                  -- GENERATED --
              */
          