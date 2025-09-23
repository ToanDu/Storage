
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

object Widget_edit_table extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editWidgetTableModal" tabindex="-1" aria-labelledby="editTableModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content" id="theme16">
            <div class="modal-header">
                <h5 class="modal-title text-white" id="editTableModalLabel">"""),_display_(/*5.78*/Messages("Sửa widget bảng dữ liệu")),format.raw/*5.113*/("""</h5>
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
                                        <label for="idWidgetTableEditTitle" class="col-form-label">"""),_display_(/*19.101*/Messages("Tiêu đề *")),format.raw/*19.122*/("""</label>
                                        <input type="text" class="form-control col-sm-6" id="idWidgetTableEditTitle" name="idWidgetTableEditTitle">
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
                                        <label for="idWidgetTableEditOption" class="col-sm-6 col-form-label">"""),_display_(/*34.111*/Messages("Bộ lọc")),format.raw/*34.129*/("""</label>
                                        <select class="form-select mb-3" id="idWidgetTableEditOption" name="idWidgetTableEditOption" onchange="changeOptionWidgetTableEdit(this)">
                                            <option value="" disabled>Chọn</option>
                                            <option value="org">Tổ chức</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <div class="header-center filter" id="idWidgetTableOrg" style="display: none">
                                        <label for="idWidgetTableEditOption" class="col-sm-6 col-form-label">"""),_display_(/*44.111*/Messages("Tổ chức")),format.raw/*44.130*/("""</label>
                                        <select class="form-select mb-3" id="selectWidgetTableEditOrg" name="selectWidgetTableEditOrg" onchange="changeOrgWidgetTableEdit(this)">
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-12" style="display: inline-flex; justify-content: center;">
                                    <div class="table-loading"></div>
                                </div>
                                <div id="idWidgetTableTable" style="overflow: auto;"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-1"></div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" onclick="confirmWidgetTable()">"""),_display_(/*62.95*/Messages("btnComfirm")),format.raw/*62.117*/("""</button>
                <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*63.85*/Messages("btnClose")),format.raw/*63.105*/("""</button>
            </div>
        </div>
    </div>
</div>

<script id="table-edit-table-template" type="x-tmpl-mustache">
    <input type="hidden" name="widgetTableTableCheckbox" id="widgetTableTableCheckbox"/>
    <table class="table table-bordered table-nowrap">
        <thead class="thead-light">
            <tr>
                <th>Thiết bị</th>
                <th colspan=100 style="text-align: center;vertical-align: middle;">Thuộc tính</th>
            </tr>

        </thead>
        <tbody>
            """),format.raw/*80.13*/("""{"""),format.raw/*80.14*/("""{"""),format.raw/*80.15*/("""#devices"""),format.raw/*80.23*/("""}"""),format.raw/*80.24*/("""}"""),format.raw/*80.25*/("""
                """),format.raw/*81.17*/("""<tr>
                    <td scope="row" data-id="""),format.raw/*82.45*/("""{"""),format.raw/*82.46*/("""{"""),format.raw/*82.47*/("""id"""),format.raw/*82.49*/("""}"""),format.raw/*82.50*/("""}"""),format.raw/*82.51*/(""">"""),format.raw/*82.52*/("""{"""),format.raw/*82.53*/("""{"""),format.raw/*82.54*/("""name"""),format.raw/*82.58*/("""}"""),format.raw/*82.59*/("""}"""),format.raw/*82.60*/("""</td>
                    """),format.raw/*83.21*/("""{"""),format.raw/*83.22*/("""{"""),format.raw/*83.23*/("""#vars"""),format.raw/*83.28*/("""}"""),format.raw/*83.29*/("""}"""),format.raw/*83.30*/("""
                        """),format.raw/*84.25*/("""<td>
                            <input type="checkbox" data-id="""),format.raw/*85.60*/("""{"""),format.raw/*85.61*/("""{"""),format.raw/*85.62*/("""id"""),format.raw/*85.64*/("""}"""),format.raw/*85.65*/("""}"""),format.raw/*85.66*/(""" """),format.raw/*85.67*/("""data-name="""),format.raw/*85.77*/("""{"""),format.raw/*85.78*/("""{"""),format.raw/*85.79*/("""name"""),format.raw/*85.83*/("""}"""),format.raw/*85.84*/("""}"""),format.raw/*85.85*/(""" """),format.raw/*85.86*/("""id=""""),format.raw/*85.90*/("""{"""),format.raw/*85.91*/("""{"""),format.raw/*85.92*/("""wid"""),format.raw/*85.95*/("""}"""),format.raw/*85.96*/("""}"""),format.raw/*85.97*/("""-"""),format.raw/*85.98*/("""{"""),format.raw/*85.99*/("""{"""),format.raw/*85.100*/("""attribute_key"""),format.raw/*85.113*/("""}"""),format.raw/*85.114*/("""}"""),format.raw/*85.115*/("""" attribute-key="""),format.raw/*85.131*/("""{"""),format.raw/*85.132*/("""{"""),format.raw/*85.133*/("""attribute_key"""),format.raw/*85.146*/("""}"""),format.raw/*85.147*/("""}"""),format.raw/*85.148*/(""" """),format.raw/*85.149*/("""attribute-type="""),format.raw/*85.164*/("""{"""),format.raw/*85.165*/("""{"""),format.raw/*85.166*/("""attribute_type"""),format.raw/*85.180*/("""}"""),format.raw/*85.181*/("""}"""),format.raw/*85.182*/(""" """),format.raw/*85.183*/("""value-type="""),format.raw/*85.194*/("""{"""),format.raw/*85.195*/("""{"""),format.raw/*85.196*/("""value_type"""),format.raw/*85.206*/("""}"""),format.raw/*85.207*/("""}"""),format.raw/*85.208*/(""">
                            <label for=""""),format.raw/*86.41*/("""{"""),format.raw/*86.42*/("""{"""),format.raw/*86.43*/("""wid"""),format.raw/*86.46*/("""}"""),format.raw/*86.47*/("""}"""),format.raw/*86.48*/("""-"""),format.raw/*86.49*/("""{"""),format.raw/*86.50*/("""{"""),format.raw/*86.51*/("""id"""),format.raw/*86.53*/("""}"""),format.raw/*86.54*/("""}"""),format.raw/*86.55*/("""">"""),format.raw/*86.57*/("""{"""),format.raw/*86.58*/("""{"""),format.raw/*86.59*/("""attribute_key"""),format.raw/*86.72*/("""}"""),format.raw/*86.73*/("""}"""),format.raw/*86.74*/("""</label>
                        </td>
                    """),format.raw/*88.21*/("""{"""),format.raw/*88.22*/("""{"""),format.raw/*88.23*/("""/vars"""),format.raw/*88.28*/("""}"""),format.raw/*88.29*/("""}"""),format.raw/*88.30*/("""
                """),format.raw/*89.17*/("""</tr>
            """),format.raw/*90.13*/("""{"""),format.raw/*90.14*/("""{"""),format.raw/*90.15*/("""/devices"""),format.raw/*90.23*/("""}"""),format.raw/*90.24*/("""}"""),format.raw/*90.25*/("""
        """),format.raw/*91.9*/("""</tbody>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboard/widget/Widget_edit_table.scala.html
                  HASH: e71c942ff0232a7dae5cd808c1f7af560be90d87
                  MATRIX: 1063->0|1416->327|1472->362|1859->722|1900->742|2324->1138|2367->1159|2613->1378|2669->1413|3021->1738|3061->1757|3495->2163|3535->2181|4329->2947|4370->2966|5348->3917|5392->3939|5513->4033|5555->4053|6102->4572|6131->4573|6160->4574|6196->4582|6225->4583|6254->4584|6299->4601|6376->4650|6405->4651|6434->4652|6464->4654|6493->4655|6522->4656|6551->4657|6580->4658|6609->4659|6641->4663|6670->4664|6699->4665|6753->4691|6782->4692|6811->4693|6844->4698|6873->4699|6902->4700|6955->4725|7047->4789|7076->4790|7105->4791|7135->4793|7164->4794|7193->4795|7222->4796|7260->4806|7289->4807|7318->4808|7350->4812|7379->4813|7408->4814|7437->4815|7469->4819|7498->4820|7527->4821|7558->4824|7587->4825|7616->4826|7645->4827|7674->4828|7704->4829|7746->4842|7776->4843|7806->4844|7851->4860|7881->4861|7911->4862|7953->4875|7983->4876|8013->4877|8043->4878|8087->4893|8117->4894|8147->4895|8190->4909|8220->4910|8250->4911|8280->4912|8320->4923|8350->4924|8380->4925|8419->4935|8449->4936|8479->4937|8549->4979|8578->4980|8607->4981|8638->4984|8667->4985|8696->4986|8725->4987|8754->4988|8783->4989|8813->4991|8842->4992|8871->4993|8901->4995|8930->4996|8959->4997|9000->5010|9029->5011|9058->5012|9145->5071|9174->5072|9203->5073|9236->5078|9265->5079|9294->5080|9339->5097|9385->5115|9414->5116|9443->5117|9479->5125|9508->5126|9537->5127|9573->5136
                  LINES: 33->1|37->5|37->5|45->13|45->13|51->19|51->19|53->21|53->21|60->28|60->28|66->34|66->34|76->44|76->44|94->62|94->62|95->63|95->63|112->80|112->80|112->80|112->80|112->80|112->80|113->81|114->82|114->82|114->82|114->82|114->82|114->82|114->82|114->82|114->82|114->82|114->82|114->82|115->83|115->83|115->83|115->83|115->83|115->83|116->84|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|117->85|118->86|118->86|118->86|118->86|118->86|118->86|118->86|118->86|118->86|118->86|118->86|118->86|118->86|118->86|118->86|118->86|118->86|118->86|120->88|120->88|120->88|120->88|120->88|120->88|121->89|122->90|122->90|122->90|122->90|122->90|122->90|123->91
                  -- GENERATED --
              */
          