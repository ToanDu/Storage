
package views.html.iot.pay.packData

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
/*1.2*/import helper._
/*2.2*/import vn.m2m.common.models.User

object PackData extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, projectId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.38*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("Pack Data")),format.raw/*9.34*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*17.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("stylesheets/views/pay/packdata.css")),format.raw/*18.79*/("""" rel="stylesheet" />
  </head>
  <body class="bg-theme">
    """),_display_(/*21.6*/views/*21.11*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*21.54*/("""

    """),_display_(/*23.6*/views/*23.11*/.html.iot.tags.Header(currentUser)),format.raw/*23.45*/("""

    """),format.raw/*25.5*/("""<div class="page-wrapper">
      <div class="page-content">

        <div class="row">
          <div class="col-md-4">
            <div class="card">

              <div class="panel" style="height: 85vh;background-color: #ffffff;">
                <div class="panel-heading" >
                  <h4 class="panel-title">
                    <div class="row" style="padding: 12px 12px 1px 12px;">
                      <div class="col-md-2">
                        <div class="input-group" style="">
                          <span class="input-group-text" style="cursor: pointer;" data-bs-toggle="modal" data-bs-target="#addPackDataModal" title=""""),_display_(/*38.149*/Messages("packdata.add")),format.raw/*38.173*/("""">
                            <i class='bx bx-plus'></i>
                          </span>
                        </div>
                      </div>
                      <div class="col-md-10">
                        <div class="input-group" style="">
                          <div class="inner-addon left-addon" style="width: 99%;">
                            <input id="searchPackData" class="form-control inputSearch" type="text" placeholder="" maxlength="30">
                            <i class="glyphicon bx bx-search" onclick="focusSearchTree()"></i>
                          </div>
                        </div>
                      </div>
                    </div>
                  </h4>
                </div>


                <div class="panel-body" style="padding: 2px 2px 2px 2px; overflow-y: auto;  color: #ffffff; height: 77vh;" >
                  <div style="width: 100%; overflow: auto; height: 100%;padding: 10px;" id="listPackData">

                  </div>
                </div>

              </div>
            </div>
          </div>

          <div class="col-md-8">
            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; font-weight: normal;">"""),_display_(/*68.158*/Messages("Thông tin chung")),format.raw/*68.185*/("""</span>
            </div>
            <div class="card" style="padding: 20px; border: 1px solid #858687;">
              <div class="row">
                <div class="col-md-6">
                  <div class="row mb-4">
                    <h4 class="col-sm-12 col-form-label" id="idPackDataInfo">"""),_display_(/*74.79*/Messages("ID: ")),format.raw/*74.95*/("""</h4>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="row mb-4">
                    <h4 class="col-sm-12 col-form-label" id="namePackDataInfo">"""),_display_(/*79.81*/Messages("packdata.name")),format.raw/*79.106*/("""</h4>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="row mb-4">
                    <h4 class="col-sm-12 col-form-label" id="typePackDataInfo">"""),_display_(/*84.81*/Messages("Loại gói")),format.raw/*84.101*/("""</h4>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="row mb-4">
                    <h4 class="col-sm-12 col-form-label" id="statusPackDataInfo">"""),_display_(/*89.83*/Messages("Trạng thái")),format.raw/*89.105*/("""</h4>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="row mb-4">
                    <h4 class="col-sm-12 col-form-label" id="contentPackDataInfo">"""),_display_(/*94.84*/Messages("packdata.content")),format.raw/*94.112*/("""</h4>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="row mb-4">
                    <h4 class="col-sm-12 col-form-label" id="datePackDataInfo">"""),_display_(/*99.81*/Messages("Ngày tạo")),format.raw/*99.101*/("""</h4>
                  </div>
                </div>
              </div>
            </div>


            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; font-weight: normal;">"""),_display_(/*107.158*/Messages("Dữ liệu gói cước")),format.raw/*107.186*/("""</span>
            </div>
            <div class="card" style="padding: 20px; border: 1px solid #858687;">
              <div class="row">
                <div class="col-md-6">
                  <div class="row mb-4">
                    <h4 class="col-sm-12 col-form-label" id="paymentTypeInfo">"""),_display_(/*113.80*/Messages("Phương thức thanh toán: ")),format.raw/*113.116*/("""</h4>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="row mb-4">
                    <h4 class="col-sm-12 col-form-label" id="typePeriodInfo">"""),_display_(/*118.79*/Messages("Loại chu kỳ tính tiền: ")),format.raw/*118.114*/("""</h4>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="row mb-4">
                    <h4 class="col-sm-12 col-form-label" id="periodInfo">"""),_display_(/*123.75*/Messages("Chu kì tính tiền: ")),format.raw/*123.105*/("""</h4>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="row mb-4">
                    <h4 class="col-sm-12 col-form-label" id="fixCostInfo">"""),_display_(/*128.76*/Messages("Chi phí cố định hàng kỳ: ")),format.raw/*128.113*/("""</h4>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="row mb-4">
                    <h4 class="col-sm-12 col-form-label" id="chargingUnitInfo">"""),_display_(/*133.81*/Messages("Đơn vị tính: ")),format.raw/*133.106*/("""</h4>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="row mb-4">
                    <h4 class="col-sm-12 col-form-label" id="estimateInfo">"""),_display_(/*138.77*/Messages("Phương pháp định giá: ")),format.raw/*138.111*/("""</h4>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="row mb-4">
                    <h4 class="col-sm-12 col-form-label" id="priceInfo">"""),_display_(/*143.74*/Messages("Số tiền: ")),format.raw/*143.95*/("""</h4>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="row mb-4">
                    <h4 class="col-sm-12 col-form-label" id="numberFreeInfo">"""),_display_(/*148.79*/Messages("Số lượng miễn phí: ")),format.raw/*148.110*/("""</h4>
                  </div>
                </div>
              </div>
            </div>

            <div id="tabPlanLevelInfo" style="display: none">
              """),format.raw/*155.105*/("""
                """),format.raw/*156.172*/("""
              """),format.raw/*157.25*/("""
              """),format.raw/*158.15*/("""<div class="card" style="padding: 20px; border: 1px solid #858687;" >
                <div class="row">
                  <div class="col-sm-12" id="planLevelInfo"></div>
                </div>
              </div>
            </div>

          </div>
        </div>
      </div>
    </div>

    """),_display_(/*170.6*/views/*170.11*/.html.iot.pay.packData.PackData_create()),format.raw/*170.51*/("""
    """),_display_(/*171.6*/views/*171.11*/.html.iot.pay.packData.PackData_edit()),format.raw/*171.49*/("""
    """),_display_(/*172.6*/views/*172.11*/.html.iot.pay.packData.PackData_delete()),format.raw/*172.51*/("""

    """),_display_(/*174.6*/views/*174.11*/.html.Loading()),format.raw/*174.26*/("""
  """),format.raw/*175.3*/("""</body>

  """),_display_(/*177.4*/views/*177.9*/.html.iot.tags.Main_js()),format.raw/*177.33*/("""

  """),format.raw/*179.3*/("""<script>
    var projectId = '"""),_display_(/*180.23*/projectId),format.raw/*180.32*/("""';
    var iconEdit = """"),_display_(/*181.22*/routes/*181.28*/.Assets.versioned("images/icon/edit.png")),format.raw/*181.69*/("""";
    var iconDelete = """"),_display_(/*182.24*/routes/*182.30*/.Assets.versioned("images/icon/delete.png")),format.raw/*182.73*/("""";

          $(document).ready(function () """),format.raw/*184.41*/("""{"""),format.raw/*184.42*/("""
            """),format.raw/*185.13*/("""$("#menu-packData").addClass("mm-active");

            $("#menu").metisMenu();
            for (var e = window.location, o = $(".metismenu li a").filter(function() """),format.raw/*188.86*/("""{"""),format.raw/*188.87*/("""
              """),format.raw/*189.15*/("""return this.href == e
            """),format.raw/*190.13*/("""}"""),format.raw/*190.14*/(""").addClass("").parent().addClass("mm-active"); o.is("li");) o = o.parent("").addClass("mm-show").parent("").addClass("mm-active");
          """),format.raw/*191.11*/("""}"""),format.raw/*191.12*/(""")

          function focusSearchTree() """),format.raw/*193.38*/("""{"""),format.raw/*193.39*/("""
            """),format.raw/*194.13*/("""$("#search-selectOrg").focus();
          """),format.raw/*195.11*/("""}"""),format.raw/*195.12*/("""
  """),format.raw/*196.3*/("""</script>
  <script src=""""),_display_(/*197.17*/routes/*197.23*/.Assets.versioned("javascripts/views/pay/PackData.js")),format.raw/*197.77*/(""""></script>
  <script src=""""),_display_(/*198.17*/routes/*198.23*/.Assets.versioned("javascripts/views/pay/PackData_add.js")),format.raw/*198.81*/(""""></script>
  <script src=""""),_display_(/*199.17*/routes/*199.23*/.Assets.versioned("javascripts/views/pay/PackData_edit.js")),format.raw/*199.82*/(""""></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,projectId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,projectId)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,projectId) => apply(currentUser,projectId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:45 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/pay/packData/PackData.scala.html
                  HASH: 930a085c0e6a8e9675802285c658be4f34de9f40
                  MATRIX: 668->1|691->18|1036->52|1167->88|1194->89|1362->231|1403->252|1484->306|1499->312|1556->348|1763->529|1777->534|1823->559|1856->565|1896->578|1911->584|1986->638|2052->677|2067->683|2143->738|2232->801|2246->806|2310->849|2343->856|2357->861|2412->895|2445->901|3122->1550|3168->1574|4560->2938|4609->2965|4934->3263|4971->3279|5212->3493|5259->3518|5500->3732|5542->3752|5785->3968|5829->3990|6073->4207|6123->4235|6364->4449|6406->4469|6787->4821|6838->4849|7165->5148|7224->5184|7464->5396|7522->5431|7758->5639|7811->5669|8048->5878|8108->5915|8350->6129|8398->6154|8636->6364|8693->6398|8928->6605|8971->6626|9211->6838|9265->6869|9466->7130|9513->7302|9557->7327|9601->7342|9925->7639|9940->7644|10002->7684|10035->7690|10050->7695|10110->7733|10143->7739|10158->7744|10220->7784|10254->7791|10269->7796|10306->7811|10337->7814|10376->7826|10390->7831|10436->7855|10468->7859|10527->7890|10558->7899|10610->7923|10626->7929|10689->7970|10743->7996|10759->8002|10824->8045|10897->8089|10927->8090|10969->8103|11163->8268|11193->8269|11237->8284|11300->8318|11330->8319|11500->8460|11530->8461|11599->8501|11629->8502|11671->8515|11742->8557|11772->8558|11803->8561|11857->8587|11873->8593|11949->8647|12005->8675|12021->8681|12101->8739|12157->8767|12173->8773|12254->8832
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|53->21|53->21|53->21|55->23|55->23|55->23|57->25|70->38|70->38|100->68|100->68|106->74|106->74|111->79|111->79|116->84|116->84|121->89|121->89|126->94|126->94|131->99|131->99|139->107|139->107|145->113|145->113|150->118|150->118|155->123|155->123|160->128|160->128|165->133|165->133|170->138|170->138|175->143|175->143|180->148|180->148|187->155|188->156|189->157|190->158|202->170|202->170|202->170|203->171|203->171|203->171|204->172|204->172|204->172|206->174|206->174|206->174|207->175|209->177|209->177|209->177|211->179|212->180|212->180|213->181|213->181|213->181|214->182|214->182|214->182|216->184|216->184|217->185|220->188|220->188|221->189|222->190|222->190|223->191|223->191|225->193|225->193|226->194|227->195|227->195|228->196|229->197|229->197|229->197|230->198|230->198|230->198|231->199|231->199|231->199
                  -- GENERATED --
              */
          