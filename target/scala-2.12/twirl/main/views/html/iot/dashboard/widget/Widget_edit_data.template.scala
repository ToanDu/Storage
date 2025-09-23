
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

object Widget_edit_data extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="editWidgetDataModal" tabindex="-1" aria-labelledby="editDataModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h5 class="modal-title text-white" id="editDataModalLabel">"""),_display_(/*5.69*/Messages("Sửa dữ liệu ")),format.raw/*5.93*/("""</h5>
      </div>
      <div class="modal-body">
        <form class="row g-3">

          <div class="col-md-1"></div>
          <div class="col-md-10">
            <div class="col-md-12" style="background: #858687; padding: 8px">
              <span style="color: white; margin-left: 25px">"""),_display_(/*13.62*/Messages("HIỂN THỊ")),format.raw/*13.82*/("""</span>
            </div>
            <div class="col-md-12 mt-3" style="border: 1px solid #858687;">
              <div class="row p-3">
                <div class="col-md-6">
                  <div class="header-center">
                    <label for="idWidgetDataEditTitle" class="col-form-label">"""),_display_(/*19.80*/Messages("Tiêu đề *")),format.raw/*19.101*/("""</label>
                    <input type="text" class="form-control col-sm-6" id="idWidgetDataEditTitle" name="idWidgetDataEditTitle">
                    <h7 class="textNote">"""),_display_(/*21.43*/Messages("manage.group.org.30char")),format.raw/*21.78*/("""</h7>
                  </div>
                </div>
                <div class="col-md-3">
                  <div class="header-center">
                    <label for="idWidgetDataEditUnit" class="col-form-label">Đơn vị</label>
                    <input type="text" class="form-control" id="idWidgetDataEditUnit" name="idWidgetDataEditUnit">
                  </div>
                </div>
              </div>
            </div>

            <div class="col-md-12 mt-3" style="background: #858687; padding: 8px">
              <span style="color: white; margin-left: 25px">"""),_display_(/*34.62*/Messages("DỮ LIỆU")),format.raw/*34.81*/("""</span>
            </div>
            <div class="col-md-12 mt-3" style="border: 1px solid #858687;">
              <div class="row p-3">
                <div class="col-md-6">
                  <div class="header-center">
                    <label for="idWidgetDataEditOption" class="col-sm-6 col-form-label">"""),_display_(/*40.90*/Messages("Bộ lọc")),format.raw/*40.108*/("""</label>
                    <select class="form-select mb-3" id="idWidgetDataEditOption" name="idWidgetDataEditOption" onchange="changeOptionWidgetDataEdit(this)">
                      <option value="" disabled>Chọn</option>
                      <option value="org">Tổ chức</option>
                    </select>
                  </div>
                </div>

                <div class="col-md-6">
                  <div class="header-center filter" id="idWidgetDataOrg" style="display: none">
                    <label for="selectWidgetDataEditOrg" class="col-sm-6 col-form-label">"""),_display_(/*50.91*/Messages("Tổ chức")),format.raw/*50.110*/("""</label>
                    <select class="form-select mb-3" id="selectWidgetDataEditOrg" name="selectWidgetDataEditOrg" onchange="changeOrgWidgetDataEdit(this)">
                                        </select>
                  </div>
                </div>
                <div class="col-md-12" style="display: inline-flex; justify-content: center;">
                  <div class="table-loading"></div>
                </div>
                <div id="idWidgetDataTable" style="overflow: auto;"></div>
              </div>
            </div>

          </div>
          <div class="col-md-1"></div>

        </form>

      </div>
      <div class="modal-header" style="background-color: white">
        <button type="button" class="btn btn-success" onclick="confirmWidgetData()">"""),_display_(/*69.86*/Messages("btnComfirm")),format.raw/*69.108*/("""</button>
        <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*70.77*/Messages("btnClose")),format.raw/*70.97*/("""</button>
      </div>
    </div>
  </div>
</div>
<script id="data-edit-table-template" type="x-tmpl-mustache">
<input type="hidden" name="widgetDataTableCheckbox" id="widgetDataTableCheckbox"/>
    <table class="table table-bordered table-nowrap">
        <thead class="thead-light">
            <tr>
                <th>Thiết bị</th>
                <th colspan=100 style="text-align: center;vertical-align: middle;">Thuộc tính</th>
            </tr>

        </thead>
        <tbody>
            """),format.raw/*86.13*/("""{"""),format.raw/*86.14*/("""{"""),format.raw/*86.15*/("""#devices"""),format.raw/*86.23*/("""}"""),format.raw/*86.24*/("""}"""),format.raw/*86.25*/("""
                """),format.raw/*87.17*/("""<tr>
                    <td data-id="""),format.raw/*88.33*/("""{"""),format.raw/*88.34*/("""{"""),format.raw/*88.35*/("""id"""),format.raw/*88.37*/("""}"""),format.raw/*88.38*/("""}"""),format.raw/*88.39*/(""">"""),format.raw/*88.40*/("""{"""),format.raw/*88.41*/("""{"""),format.raw/*88.42*/("""name"""),format.raw/*88.46*/("""}"""),format.raw/*88.47*/("""}"""),format.raw/*88.48*/("""</td>
                    """),format.raw/*89.21*/("""{"""),format.raw/*89.22*/("""{"""),format.raw/*89.23*/("""#vars"""),format.raw/*89.28*/("""}"""),format.raw/*89.29*/("""}"""),format.raw/*89.30*/("""
                        """),format.raw/*90.25*/("""<td>
                            <input """),format.raw/*91.36*/("""{"""),format.raw/*91.37*/("""{"""),format.raw/*91.38*/("""disabled"""),format.raw/*91.46*/("""}"""),format.raw/*91.47*/("""}"""),format.raw/*91.48*/(""" """),format.raw/*91.49*/("""name=""""),format.raw/*91.55*/("""{"""),format.raw/*91.56*/("""{"""),format.raw/*91.57*/("""wid"""),format.raw/*91.60*/("""}"""),format.raw/*91.61*/("""}"""),format.raw/*91.62*/("""" type="radio" data-id="""),format.raw/*91.85*/("""{"""),format.raw/*91.86*/("""{"""),format.raw/*91.87*/("""id"""),format.raw/*91.89*/("""}"""),format.raw/*91.90*/("""}"""),format.raw/*91.91*/(""" """),format.raw/*91.92*/("""data-name="""),format.raw/*91.102*/("""{"""),format.raw/*91.103*/("""{"""),format.raw/*91.104*/("""name"""),format.raw/*91.108*/("""}"""),format.raw/*91.109*/("""}"""),format.raw/*91.110*/(""" """),format.raw/*91.111*/("""id=""""),format.raw/*91.115*/("""{"""),format.raw/*91.116*/("""{"""),format.raw/*91.117*/("""wid"""),format.raw/*91.120*/("""}"""),format.raw/*91.121*/("""}"""),format.raw/*91.122*/("""-"""),format.raw/*91.123*/("""{"""),format.raw/*91.124*/("""{"""),format.raw/*91.125*/("""attribute_key"""),format.raw/*91.138*/("""}"""),format.raw/*91.139*/("""}"""),format.raw/*91.140*/("""" attribute-key="""),format.raw/*91.156*/("""{"""),format.raw/*91.157*/("""{"""),format.raw/*91.158*/("""attribute_key"""),format.raw/*91.171*/("""}"""),format.raw/*91.172*/("""}"""),format.raw/*91.173*/(""" """),format.raw/*91.174*/("""attribute-type="""),format.raw/*91.189*/("""{"""),format.raw/*91.190*/("""{"""),format.raw/*91.191*/("""attribute_type"""),format.raw/*91.205*/("""}"""),format.raw/*91.206*/("""}"""),format.raw/*91.207*/(""" """),format.raw/*91.208*/("""value-type="""),format.raw/*91.219*/("""{"""),format.raw/*91.220*/("""{"""),format.raw/*91.221*/("""value_type"""),format.raw/*91.231*/("""}"""),format.raw/*91.232*/("""}"""),format.raw/*91.233*/(""">
                            <label for=""""),format.raw/*92.41*/("""{"""),format.raw/*92.42*/("""{"""),format.raw/*92.43*/("""wid"""),format.raw/*92.46*/("""}"""),format.raw/*92.47*/("""}"""),format.raw/*92.48*/("""-"""),format.raw/*92.49*/("""{"""),format.raw/*92.50*/("""{"""),format.raw/*92.51*/("""id"""),format.raw/*92.53*/("""}"""),format.raw/*92.54*/("""}"""),format.raw/*92.55*/("""">"""),format.raw/*92.57*/("""{"""),format.raw/*92.58*/("""{"""),format.raw/*92.59*/("""attribute_key"""),format.raw/*92.72*/("""}"""),format.raw/*92.73*/("""}"""),format.raw/*92.74*/("""</label>
                        </td>
                    """),format.raw/*94.21*/("""{"""),format.raw/*94.22*/("""{"""),format.raw/*94.23*/("""/vars"""),format.raw/*94.28*/("""}"""),format.raw/*94.29*/("""}"""),format.raw/*94.30*/("""
                """),format.raw/*95.17*/("""</tr>
            """),format.raw/*96.13*/("""{"""),format.raw/*96.14*/("""{"""),format.raw/*96.15*/("""/devices"""),format.raw/*96.23*/("""}"""),format.raw/*96.24*/("""}"""),format.raw/*96.25*/("""
        """),format.raw/*97.9*/("""</tbody>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboard/widget/Widget_edit_data.scala.html
                  HASH: 7695f09e07147d430bfeb0732a2b7c0a94c481c7
                  MATRIX: 1062->0|1392->304|1436->328|1757->622|1798->642|2128->945|2171->966|2375->1143|2431->1178|3037->1757|3077->1776|3417->2089|3457->2107|4074->2697|4115->2716|4927->3501|4971->3523|5084->3609|5125->3629|5652->4128|5681->4129|5710->4130|5746->4138|5775->4139|5804->4140|5849->4157|5914->4194|5943->4195|5972->4196|6002->4198|6031->4199|6060->4200|6089->4201|6118->4202|6147->4203|6179->4207|6208->4208|6237->4209|6291->4235|6320->4236|6349->4237|6382->4242|6411->4243|6440->4244|6493->4269|6561->4309|6590->4310|6619->4311|6655->4319|6684->4320|6713->4321|6742->4322|6776->4328|6805->4329|6834->4330|6865->4333|6894->4334|6923->4335|6974->4358|7003->4359|7032->4360|7062->4362|7091->4363|7120->4364|7149->4365|7188->4375|7218->4376|7248->4377|7281->4381|7311->4382|7341->4383|7371->4384|7404->4388|7434->4389|7464->4390|7496->4393|7526->4394|7556->4395|7586->4396|7616->4397|7646->4398|7688->4411|7718->4412|7748->4413|7793->4429|7823->4430|7853->4431|7895->4444|7925->4445|7955->4446|7985->4447|8029->4462|8059->4463|8089->4464|8132->4478|8162->4479|8192->4480|8222->4481|8262->4492|8292->4493|8322->4494|8361->4504|8391->4505|8421->4506|8491->4548|8520->4549|8549->4550|8580->4553|8609->4554|8638->4555|8667->4556|8696->4557|8725->4558|8755->4560|8784->4561|8813->4562|8843->4564|8872->4565|8901->4566|8942->4579|8971->4580|9000->4581|9087->4640|9116->4641|9145->4642|9178->4647|9207->4648|9236->4649|9281->4666|9327->4684|9356->4685|9385->4686|9421->4694|9450->4695|9479->4696|9515->4705
                  LINES: 33->1|37->5|37->5|45->13|45->13|51->19|51->19|53->21|53->21|66->34|66->34|72->40|72->40|82->50|82->50|101->69|101->69|102->70|102->70|118->86|118->86|118->86|118->86|118->86|118->86|119->87|120->88|120->88|120->88|120->88|120->88|120->88|120->88|120->88|120->88|120->88|120->88|120->88|121->89|121->89|121->89|121->89|121->89|121->89|122->90|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|124->92|124->92|124->92|124->92|124->92|124->92|124->92|124->92|124->92|124->92|124->92|124->92|124->92|124->92|124->92|124->92|124->92|124->92|126->94|126->94|126->94|126->94|126->94|126->94|127->95|128->96|128->96|128->96|128->96|128->96|128->96|129->97
                  -- GENERATED --
              */
          