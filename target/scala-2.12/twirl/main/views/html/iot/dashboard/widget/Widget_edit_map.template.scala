
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

object Widget_edit_map extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<style>
    option:disabled"""),format.raw/*2.20*/("""{"""),format.raw/*2.21*/("""
        """),format.raw/*3.9*/("""color: red;
    """),format.raw/*4.5*/("""}"""),format.raw/*4.6*/("""
"""),format.raw/*5.1*/("""</style>
<div class="modal fade" id="editWidgetMapModal" data-widget-id="" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content" id="theme16">
            <div class="modal-header">
                <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*10.76*/Messages("widget.editWidgetMap")),format.raw/*10.108*/("""</h5>
            </div>
            <div class="modal-body">
                <form class="row g-3">
                    <div class="col-md-1"></div>
                    <div class="col-md-10">
                        <div class="col-md-12" style="background: #858687; padding: 8px">
                            <span style="color: white; margin-left: 25px">"""),_display_(/*17.76*/Messages("HIỂN THỊ")),format.raw/*17.96*/("""</span>
                        </div>
                        <div class="col-md-12 mt-3" style="border: 1px solid #858687;">
                            <div class="row p-3">
                                <div class="col-md-6">
                                    <div class="header-center">
                                        <label for="idWidgetMapEditTitle" class="col-form-label">"""),_display_(/*23.99*/Messages("Tiêu đề *")),format.raw/*23.120*/("""</label>
                                        <input type="text" class="form-control col-sm-6" id="idWidgetMapEditTitle" name="idWidgetMapEditTitle">
                                        <h7 class="textNote">"""),_display_(/*25.63*/Messages("manage.group.org.30char")),format.raw/*25.98*/("""</h7>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="header-center">
                                        <label for="idWidgetMapEditTitle" class="col-form-label">"""),_display_(/*30.99*/Messages("Loại bản đồ")),format.raw/*30.122*/("""</label>
                                        <select id="typeWidgetMapEdit" class="form-select mb-3">
                                            <option value="" disabled>"""),_display_(/*32.72*/Messages("Chọn loại bản đồ")),format.raw/*32.100*/("""</option>
                                            <option value="1">"""),_display_(/*33.64*/Messages("Google Map")),format.raw/*33.86*/("""</option>
                                            <option value="2">"""),_display_(/*34.64*/Messages("MapBox")),format.raw/*34.82*/("""</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-12 mt-3" style="background: #858687; padding: 8px">
                            <span style="color: white; margin-left: 25px">"""),_display_(/*42.76*/Messages("DỮ LIỆU")),format.raw/*42.95*/("""</span>
                        </div>
                        <div class="col-md-12 mt-3" style="border: 1px solid #858687;">
                            <div class="row p-3">
                                <div class="col-md-6">
                                    <div class="header-center">
                                        <label for="idWidgetMapEditOption" class="col-sm-6 col-form-label">"""),_display_(/*48.109*/Messages("Bộ lọc")),format.raw/*48.127*/("""</label>
                                        <select class="form-select mb-3" id="idWidgetMapEditOption" name="idWidgetMapEditOption" onchange="changeOptionWidgetMapEdit(this)">
                                            <option value="" disabled>Chọn</option>
                                            <option value="org">Tổ chức</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <div class="header-center filter" id="idWidgetMapOrg" style="display: none">
                                        <label for="idWidgetMapEditOption" class="col-sm-6 col-form-label">"""),_display_(/*58.109*/Messages("Tổ chức")),format.raw/*58.128*/("""</label>
                                        <select class="form-select mb-3" id="selectWidgetMapEditOrg" name="selectWidgetMapEditOrg" onchange="changeOrgWidgetMapEdit(this)">
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-12" style="display: inline-flex; justify-content: center;">
                                    <div class="table-loading"></div>
                                </div>
                                <div id="idWidgetMapTable" style="overflow: auto;"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-1"></div>

                </form>
            </div>
            <div class="modal-header" style="background-color: white">
                <button type="button" class="btn btn-success" onclick="confirmWidgetMap()">"""),_display_(/*75.93*/Messages("btnComfirm")),format.raw/*75.115*/("""</button>
                <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*76.85*/Messages("btnClose")),format.raw/*76.105*/("""</button>
            </div>
        </div>
    </div>
</div>
<script id="map-edit-table-template" type="x-tmpl-mustache">
    <input type="hidden" name="widgetMapTableSelect" id="widgetMapTableSelect"/>
    <table class="table table-bordered table-nowrap">
        <thead class="thead-light">
            <tr>
                <th>Thiết bị</th>
                <th>Vĩ độ (latitude)</th>
                <th>Kinh độ (longitude)</th>
            </tr>

        </thead>
        <tbody>
            """),format.raw/*93.13*/("""{"""),format.raw/*93.14*/("""{"""),format.raw/*93.15*/("""#devices"""),format.raw/*93.23*/("""}"""),format.raw/*93.24*/("""}"""),format.raw/*93.25*/("""
                """),format.raw/*94.17*/("""<tr>
                    <td data-id="""),format.raw/*95.33*/("""{"""),format.raw/*95.34*/("""{"""),format.raw/*95.35*/("""id"""),format.raw/*95.37*/("""}"""),format.raw/*95.38*/("""}"""),format.raw/*95.39*/(""" """),format.raw/*95.40*/("""data-active="""),format.raw/*95.52*/("""{"""),format.raw/*95.53*/("""{"""),format.raw/*95.54*/("""isActive"""),format.raw/*95.62*/("""}"""),format.raw/*95.63*/("""}"""),format.raw/*95.64*/(""" """),format.raw/*95.65*/(""">"""),format.raw/*95.66*/("""{"""),format.raw/*95.67*/("""{"""),format.raw/*95.68*/("""name"""),format.raw/*95.72*/("""}"""),format.raw/*95.73*/("""}"""),format.raw/*95.74*/("""</td>
                    <td>
                        <select class="form-control lat" name="widgetMapTableSelectLat" """),format.raw/*97.89*/("""{"""),format.raw/*97.90*/("""{"""),format.raw/*97.91*/("""disabled"""),format.raw/*97.99*/("""}"""),format.raw/*97.100*/("""}"""),format.raw/*97.101*/(""">
                        """),format.raw/*98.25*/("""{"""),format.raw/*98.26*/("""{"""),format.raw/*98.27*/("""#isActive"""),format.raw/*98.36*/("""}"""),format.raw/*98.37*/("""}"""),format.raw/*98.38*/("""
                        """),format.raw/*99.25*/("""<option value="">Chọn</option>
                        """),format.raw/*100.25*/("""{"""),format.raw/*100.26*/("""{"""),format.raw/*100.27*/("""/isActive"""),format.raw/*100.36*/("""}"""),format.raw/*100.37*/("""}"""),format.raw/*100.38*/("""
                        """),format.raw/*101.25*/("""{"""),format.raw/*101.26*/("""{"""),format.raw/*101.27*/("""#vars"""),format.raw/*101.32*/("""}"""),format.raw/*101.33*/("""}"""),format.raw/*101.34*/("""
                            """),format.raw/*102.29*/("""<option value=""""),format.raw/*102.44*/("""{"""),format.raw/*102.45*/("""{"""),format.raw/*102.46*/("""attribute_key"""),format.raw/*102.59*/("""}"""),format.raw/*102.60*/("""}"""),format.raw/*102.61*/("""" attribute-type="""),format.raw/*102.78*/("""{"""),format.raw/*102.79*/("""{"""),format.raw/*102.80*/("""attribute_type"""),format.raw/*102.94*/("""}"""),format.raw/*102.95*/("""}"""),format.raw/*102.96*/(""" """),format.raw/*102.97*/("""value-type="""),format.raw/*102.108*/("""{"""),format.raw/*102.109*/("""{"""),format.raw/*102.110*/("""value_type"""),format.raw/*102.120*/("""}"""),format.raw/*102.121*/("""}"""),format.raw/*102.122*/(""" """),format.raw/*102.123*/("""{"""),format.raw/*102.124*/("""{"""),format.raw/*102.125*/("""latSelected"""),format.raw/*102.136*/("""}"""),format.raw/*102.137*/("""}"""),format.raw/*102.138*/(""" """),format.raw/*102.139*/("""{"""),format.raw/*102.140*/("""{"""),format.raw/*102.141*/("""disabled"""),format.raw/*102.149*/("""}"""),format.raw/*102.150*/("""}"""),format.raw/*102.151*/(""">"""),format.raw/*102.152*/("""{"""),format.raw/*102.153*/("""{"""),format.raw/*102.154*/("""attribute_key"""),format.raw/*102.167*/("""}"""),format.raw/*102.168*/("""}"""),format.raw/*102.169*/(""" """),format.raw/*102.170*/("""("""),format.raw/*102.171*/("""{"""),format.raw/*102.172*/("""{"""),format.raw/*102.173*/("""value_type"""),format.raw/*102.183*/("""}"""),format.raw/*102.184*/("""}"""),format.raw/*102.185*/(""")</option>
                        """),format.raw/*103.25*/("""{"""),format.raw/*103.26*/("""{"""),format.raw/*103.27*/("""/vars"""),format.raw/*103.32*/("""}"""),format.raw/*103.33*/("""}"""),format.raw/*103.34*/("""
                        """),format.raw/*104.25*/("""</select>
                    </td>
                    <td>
                        <select class="form-control long" name="widgetMapTableSelectLong" """),format.raw/*107.91*/("""{"""),format.raw/*107.92*/("""{"""),format.raw/*107.93*/("""disabled"""),format.raw/*107.101*/("""}"""),format.raw/*107.102*/("""}"""),format.raw/*107.103*/(""">
                        """),format.raw/*108.25*/("""{"""),format.raw/*108.26*/("""{"""),format.raw/*108.27*/("""#isActive"""),format.raw/*108.36*/("""}"""),format.raw/*108.37*/("""}"""),format.raw/*108.38*/("""
                        """),format.raw/*109.25*/("""<option value="">Chọn</option>
                        """),format.raw/*110.25*/("""{"""),format.raw/*110.26*/("""{"""),format.raw/*110.27*/("""/isActive"""),format.raw/*110.36*/("""}"""),format.raw/*110.37*/("""}"""),format.raw/*110.38*/("""
                        """),format.raw/*111.25*/("""{"""),format.raw/*111.26*/("""{"""),format.raw/*111.27*/("""#vars"""),format.raw/*111.32*/("""}"""),format.raw/*111.33*/("""}"""),format.raw/*111.34*/("""
                            """),format.raw/*112.29*/("""<option value=""""),format.raw/*112.44*/("""{"""),format.raw/*112.45*/("""{"""),format.raw/*112.46*/("""attribute_key"""),format.raw/*112.59*/("""}"""),format.raw/*112.60*/("""}"""),format.raw/*112.61*/("""" attribute-type="""),format.raw/*112.78*/("""{"""),format.raw/*112.79*/("""{"""),format.raw/*112.80*/("""attribute_type"""),format.raw/*112.94*/("""}"""),format.raw/*112.95*/("""}"""),format.raw/*112.96*/(""" """),format.raw/*112.97*/("""value-type="""),format.raw/*112.108*/("""{"""),format.raw/*112.109*/("""{"""),format.raw/*112.110*/("""value_type"""),format.raw/*112.120*/("""}"""),format.raw/*112.121*/("""}"""),format.raw/*112.122*/(""" """),format.raw/*112.123*/("""{"""),format.raw/*112.124*/("""{"""),format.raw/*112.125*/("""longSelected"""),format.raw/*112.137*/("""}"""),format.raw/*112.138*/("""}"""),format.raw/*112.139*/(""" """),format.raw/*112.140*/("""{"""),format.raw/*112.141*/("""{"""),format.raw/*112.142*/("""disabled"""),format.raw/*112.150*/("""}"""),format.raw/*112.151*/("""}"""),format.raw/*112.152*/(""">"""),format.raw/*112.153*/("""{"""),format.raw/*112.154*/("""{"""),format.raw/*112.155*/("""attribute_key"""),format.raw/*112.168*/("""}"""),format.raw/*112.169*/("""}"""),format.raw/*112.170*/("""   """),format.raw/*112.173*/("""("""),format.raw/*112.174*/("""{"""),format.raw/*112.175*/("""{"""),format.raw/*112.176*/("""value_type"""),format.raw/*112.186*/("""}"""),format.raw/*112.187*/("""}"""),format.raw/*112.188*/(""")</option>
                        """),format.raw/*113.25*/("""{"""),format.raw/*113.26*/("""{"""),format.raw/*113.27*/("""/vars"""),format.raw/*113.32*/("""}"""),format.raw/*113.33*/("""}"""),format.raw/*113.34*/("""
                        """),format.raw/*114.25*/("""</select>
                    </td>
                </tr>
            """),format.raw/*117.13*/("""{"""),format.raw/*117.14*/("""{"""),format.raw/*117.15*/("""/devices"""),format.raw/*117.23*/("""}"""),format.raw/*117.24*/("""}"""),format.raw/*117.25*/("""
        """),format.raw/*118.9*/("""</tbody>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboard/widget/Widget_edit_map.scala.html
                  HASH: 754610cdccdb5b5e005715db2b1553dadcd021b4
                  MATRIX: 1061->0|1115->27|1143->28|1178->37|1220->53|1247->54|1274->55|1649->403|1703->435|2089->794|2130->814|2551->1208|2594->1229|2836->1444|2892->1479|3224->1784|3269->1807|3473->1984|3523->2012|3623->2085|3666->2107|3766->2180|3805->2198|4211->2577|4251->2596|4683->3000|4723->3018|5507->3774|5548->3793|6547->4765|6591->4787|6712->4881|6754->4901|7278->5397|7307->5398|7336->5399|7372->5407|7401->5408|7430->5409|7475->5426|7540->5463|7569->5464|7598->5465|7628->5467|7657->5468|7686->5469|7715->5470|7755->5482|7784->5483|7813->5484|7849->5492|7878->5493|7907->5494|7936->5495|7965->5496|7994->5497|8023->5498|8055->5502|8084->5503|8113->5504|8260->5623|8289->5624|8318->5625|8354->5633|8384->5634|8414->5635|8468->5661|8497->5662|8526->5663|8563->5672|8592->5673|8621->5674|8674->5699|8758->5754|8788->5755|8818->5756|8856->5765|8886->5766|8916->5767|8970->5792|9000->5793|9030->5794|9064->5799|9094->5800|9124->5801|9182->5830|9226->5845|9256->5846|9286->5847|9328->5860|9358->5861|9388->5862|9434->5879|9464->5880|9494->5881|9537->5895|9567->5896|9597->5897|9627->5898|9668->5909|9699->5910|9730->5911|9770->5921|9801->5922|9832->5923|9863->5924|9894->5925|9925->5926|9966->5937|9997->5938|10028->5939|10059->5940|10090->5941|10121->5942|10159->5950|10190->5951|10221->5952|10252->5953|10283->5954|10314->5955|10357->5968|10388->5969|10419->5970|10450->5971|10481->5972|10512->5973|10543->5974|10583->5984|10614->5985|10645->5986|10709->6021|10739->6022|10769->6023|10803->6028|10833->6029|10863->6030|10917->6055|11097->6206|11127->6207|11157->6208|11195->6216|11226->6217|11257->6218|11312->6244|11342->6245|11372->6246|11410->6255|11440->6256|11470->6257|11524->6282|11608->6337|11638->6338|11668->6339|11706->6348|11736->6349|11766->6350|11820->6375|11850->6376|11880->6377|11914->6382|11944->6383|11974->6384|12032->6413|12076->6428|12106->6429|12136->6430|12178->6443|12208->6444|12238->6445|12284->6462|12314->6463|12344->6464|12387->6478|12417->6479|12447->6480|12477->6481|12518->6492|12549->6493|12580->6494|12620->6504|12651->6505|12682->6506|12713->6507|12744->6508|12775->6509|12817->6521|12848->6522|12879->6523|12910->6524|12941->6525|12972->6526|13010->6534|13041->6535|13072->6536|13103->6537|13134->6538|13165->6539|13208->6552|13239->6553|13270->6554|13303->6557|13334->6558|13365->6559|13396->6560|13436->6570|13467->6571|13498->6572|13562->6607|13592->6608|13622->6609|13656->6614|13686->6615|13716->6616|13770->6641|13869->6711|13899->6712|13929->6713|13966->6721|13996->6722|14026->6723|14063->6732
                  LINES: 33->1|34->2|34->2|35->3|36->4|36->4|37->5|42->10|42->10|49->17|49->17|55->23|55->23|57->25|57->25|62->30|62->30|64->32|64->32|65->33|65->33|66->34|66->34|74->42|74->42|80->48|80->48|90->58|90->58|107->75|107->75|108->76|108->76|125->93|125->93|125->93|125->93|125->93|125->93|126->94|127->95|127->95|127->95|127->95|127->95|127->95|127->95|127->95|127->95|127->95|127->95|127->95|127->95|127->95|127->95|127->95|127->95|127->95|127->95|127->95|129->97|129->97|129->97|129->97|129->97|129->97|130->98|130->98|130->98|130->98|130->98|130->98|131->99|132->100|132->100|132->100|132->100|132->100|132->100|133->101|133->101|133->101|133->101|133->101|133->101|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|134->102|135->103|135->103|135->103|135->103|135->103|135->103|136->104|139->107|139->107|139->107|139->107|139->107|139->107|140->108|140->108|140->108|140->108|140->108|140->108|141->109|142->110|142->110|142->110|142->110|142->110|142->110|143->111|143->111|143->111|143->111|143->111|143->111|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|144->112|145->113|145->113|145->113|145->113|145->113|145->113|146->114|149->117|149->117|149->117|149->117|149->117|149->117|150->118
                  -- GENERATED --
              */
          