
package views.html.telco.role.qrcode

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

object QrcodeList_add_upfileCustomer extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addUpfileCustomerModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" style="overflow: auto;">
  <div class="modal-dialog modal-xl">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <span class="modal-title" id="exampleModalLabel">"""),_display_(/*5.59*/Messages("Thông tin hồ sơ khách hàng")),format.raw/*5.97*/("""</span>
        <a class="close cursor-pointer" data-bs-dismiss="modal" aria-hidden="true" style="float: right; font-size: 20px;">×</a>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-sm-1"></div>
          <div class="col-sm-10">
            <div class="row mb-2" id="tabHopDongTraSau">
              <span class="col-sm-2 col-form-label">"""),_display_(/*13.54*/Messages("Hợp đồng *")),format.raw/*13.76*/("""</span>
              <div class="col-sm-5" style="padding-left: 0px;">
                <select class="form-control select-form" id="contractList"></select>
              </div>
            </div>

            <div id="listChungTu" style=""></div>

            <div class="row mt-3 mb-1">
              <small class="form-label ">"""),_display_(/*22.43*/Messages("* File pdf, jpg, jpeg, png dung lượng file không quá 3mb")),format.raw/*22.111*/("""</small>
            </div>

            """),format.raw/*25.44*/("""
              """),format.raw/*26.89*/("""
              """),format.raw/*27.41*/("""
                """),format.raw/*28.101*/("""
                  """),format.raw/*29.63*/("""
                    """),format.raw/*30.101*/("""
                      """),format.raw/*31.213*/("""
                      """),format.raw/*32.101*/("""
                      """),format.raw/*33.202*/("""
                    """),format.raw/*34.31*/("""
                  """),format.raw/*35.29*/("""
                  """),format.raw/*36.63*/("""
                    """),format.raw/*37.89*/("""
                    """),format.raw/*38.207*/("""
                  """),format.raw/*39.29*/("""
                  """),format.raw/*40.64*/("""
                    """),format.raw/*41.120*/("""
                  """),format.raw/*42.29*/("""
                """),format.raw/*43.27*/("""
              """),format.raw/*44.25*/("""
            """),format.raw/*45.23*/("""

            """),format.raw/*47.39*/("""
              """),format.raw/*48.89*/("""
              """),format.raw/*49.41*/("""
                """),format.raw/*50.101*/("""
                  """),format.raw/*51.63*/("""
                    """),format.raw/*52.101*/("""
                      """),format.raw/*53.213*/("""
                      """),format.raw/*54.103*/("""
                      """),format.raw/*55.202*/("""
                    """),format.raw/*56.31*/("""
                  """),format.raw/*57.29*/("""
                  """),format.raw/*58.63*/("""
                    """),format.raw/*59.95*/("""
                    """),format.raw/*60.207*/("""
                  """),format.raw/*61.29*/("""
                  """),format.raw/*62.64*/("""
                    """),format.raw/*63.120*/("""
                  """),format.raw/*64.29*/("""
                """),format.raw/*65.27*/("""
              """),format.raw/*66.25*/("""
              """),format.raw/*67.41*/("""
                """),format.raw/*68.101*/("""
                  """),format.raw/*69.63*/("""
                    """),format.raw/*70.101*/("""
                      """),format.raw/*71.213*/("""
                      """),format.raw/*72.103*/("""
                      """),format.raw/*73.202*/("""
                    """),format.raw/*74.31*/("""
                  """),format.raw/*75.29*/("""
                  """),format.raw/*76.63*/("""
                    """),format.raw/*77.93*/("""
                    """),format.raw/*78.207*/("""
                  """),format.raw/*79.29*/("""
                  """),format.raw/*80.64*/("""
                    """),format.raw/*81.120*/("""
                  """),format.raw/*82.29*/("""
                """),format.raw/*83.27*/("""
              """),format.raw/*84.25*/("""
            """),format.raw/*85.23*/("""

            """),format.raw/*87.13*/("""<div class="modal-footer">
              <button type="button" class="btn btn-cancle" onclick="backModalInfoCustomer()">"""),_display_(/*88.95*/Messages("Trở về")),format.raw/*88.113*/("""</button>
              <button type="button" class="btn btn-red" onclick="validateStartCreateQr()">"""),_display_(/*89.92*/Messages("Tạo mã")),format.raw/*89.110*/("""</button>
            </div>
          </div>
          <div class="col-sm-1"></div>
        </div>
      </div>

    </div>
  </div> <!-- modal-bialog .// -->
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
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/qrcode/QrcodeList_add_upfileCustomer.scala.html
                  HASH: e8bd7c218d65441001d7b3c6be193f68a885c72a
                  MATRIX: 1072->0|1487->389|1545->427|1961->816|2004->838|2362->1169|2452->1237|2521->1309|2564->1398|2607->1439|2653->1540|2700->1603|2750->1704|2802->1917|2854->2018|2906->2220|2955->2251|3002->2280|3049->2343|3098->2432|3148->2639|3195->2668|3242->2732|3292->2852|3339->2881|3384->2908|3427->2933|3468->2956|3510->2996|3553->3085|3596->3126|3642->3227|3689->3290|3739->3391|3791->3604|3843->3707|3895->3909|3944->3940|3991->3969|4038->4032|4087->4127|4137->4334|4184->4363|4231->4427|4281->4547|4328->4576|4373->4603|4416->4628|4459->4669|4505->4770|4552->4833|4602->4934|4654->5147|4706->5250|4758->5452|4807->5483|4854->5512|4901->5575|4950->5668|5000->5875|5047->5904|5094->5968|5144->6088|5191->6117|5236->6144|5279->6169|5320->6192|5362->6206|5510->6327|5550->6345|5678->6446|5718->6464
                  LINES: 33->1|37->5|37->5|45->13|45->13|54->22|54->22|57->25|58->26|59->27|60->28|61->29|62->30|63->31|64->32|65->33|66->34|67->35|68->36|69->37|70->38|71->39|72->40|73->41|74->42|75->43|76->44|77->45|79->47|80->48|81->49|82->50|83->51|84->52|85->53|86->54|87->55|88->56|89->57|90->58|91->59|92->60|93->61|94->62|95->63|96->64|97->65|98->66|99->67|100->68|101->69|102->70|103->71|104->72|105->73|106->74|107->75|108->76|109->77|110->78|111->79|112->80|113->81|114->82|115->83|116->84|117->85|119->87|120->88|120->88|121->89|121->89
                  -- GENERATED --
              */
          