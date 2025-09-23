
package views.html.telco.payPostpaidBill

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
/*1.2*/import vn.m2m.utils.DateUtil
/*2.2*/import vn.m2m.common.models.User

object PayPostpaidBill extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.35*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>"""),_display_(/*10.11*/Messages("payPostpaidBill.title")),format.raw/*10.44*/("""</title>
  <link rel="icon" type="image/png" href=""""),_display_(/*11.44*/routes/*11.50*/.Assets.versioned("images/logo.jpg")),format.raw/*11.86*/("""">

  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
  <meta name="viewport" content="width=device-width" />

  """),_display_(/*16.4*/views/*16.9*/.html.iot.tags.Main_css()),format.raw/*16.34*/("""

  """),format.raw/*18.3*/("""<link href=""""),_display_(/*18.16*/routes/*18.22*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*18.76*/("""" rel="stylesheet" />
  <link href=""""),_display_(/*19.16*/routes/*19.22*/.Assets.versioned("assets/plugins/input-tags/css/tagsinput.css")),format.raw/*19.86*/("""" rel="stylesheet" />
  """),format.raw/*21.91*/("""
  """),format.raw/*22.3*/("""<link href='"""),_display_(/*22.16*/routes/*22.22*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*22.71*/("""' type='text/css'>
  <link href=""""),_display_(/*23.16*/routes/*23.22*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*23.97*/("""" rel="stylesheet">
  <link href=""""),_display_(/*24.16*/routes/*24.22*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*24.137*/("""" rel="stylesheet">

  <link href=""""),_display_(/*26.16*/routes/*26.22*/.Assets.versioned("stylesheets/views/telco/utilites/utilites.css")),format.raw/*26.88*/("""" rel="stylesheet" />
  <link href=""""),_display_(/*27.16*/routes/*27.22*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*27.76*/("""" rel="stylesheet" />
  <style>
    .border-post-paid """),format.raw/*29.23*/("""{"""),format.raw/*29.24*/("""
     """),format.raw/*30.6*/("""border-top: 1px solid #D9D9D9;
      padding: 10px 0;
    """),format.raw/*32.5*/("""}"""),format.raw/*32.6*/("""
    """),format.raw/*33.5*/("""#pay_postpai_notice """),format.raw/*33.25*/("""{"""),format.raw/*33.26*/("""
      """),format.raw/*34.7*/("""padding-bottom: 10rem;
    """),format.raw/*35.5*/("""}"""),format.raw/*35.6*/("""
    """),format.raw/*36.5*/(""".input-wrapper """),format.raw/*36.20*/("""{"""),format.raw/*36.21*/("""
      """),format.raw/*37.7*/("""position: relative;
      display: inline-block;
      width: 100%;
    """),format.raw/*40.5*/("""}"""),format.raw/*40.6*/("""

    """),format.raw/*42.5*/(""".input-wrapper input """),format.raw/*42.26*/("""{"""),format.raw/*42.27*/("""
        """),format.raw/*43.9*/("""padding-right: 30px; /* chừa chỗ cho nút X */
    """),format.raw/*44.5*/("""}"""),format.raw/*44.6*/("""

    """),format.raw/*46.5*/(""".clear-btn """),format.raw/*46.16*/("""{"""),format.raw/*46.17*/("""
      """),format.raw/*47.7*/("""position: absolute;
      right: 10px;
      top: 50%;
      transform: translateY(-50%);
      font-size: 18px;
      color: #999;
      cursor: pointer;
      display: none; /* mặc định ẩn */
    """),format.raw/*55.5*/("""}"""),format.raw/*55.6*/("""

    """),format.raw/*57.5*/(""".clear-btn:hover """),format.raw/*57.22*/("""{"""),format.raw/*57.23*/("""
        """),format.raw/*58.9*/("""color: #333;
    """),format.raw/*59.5*/("""}"""),format.raw/*59.6*/("""

  """),format.raw/*61.3*/("""</style>
</head>

<body class="bg-theme">
  """),_display_(/*65.4*/views/*65.9*/.html.telco.Menu(currentUser, "", userId)),format.raw/*65.50*/("""

  """),_display_(/*67.4*/views/*67.9*/.html.telco.Header(currentUser)),format.raw/*67.40*/("""

  """),format.raw/*69.3*/("""<div class="page-wrapper">
    <div class="page-content">
      """),_display_(/*71.8*/views/*71.13*/.html.telco.payPostpaidBill.PayPostpaidBill_formSearch(currentUser)),format.raw/*71.80*/("""
      
      """),format.raw/*73.7*/("""<form id="pay_postpai_Form" class="card p-4 pt-3">
        <p id="pay_postpai_notice" class="border-post-paid fst-italic">"""),_display_(/*74.73*/Messages("payPostpaidBill.noData")),format.raw/*74.107*/("""</p>

        <div id="pay_postpai_FormContent" class="d-none">
          <p class="text-search mb-3 border-post-paid">
          """),_display_(/*78.12*/Messages("payPostpaidBill.paymentInfo")),format.raw/*78.51*/("""
          """),format.raw/*79.11*/("""</p>
          <div class="row">
            <!-- Thông tin đóng cước -->
            <div class="col-md-7 col-lg-9 d-flex justify-content-center"
            
              style="border-right: 1px solid #C5C5C5;">
              <div class="col-md-10">
                <div class="mb-4 row">
                  <label class="col-lg-4 col-form-label">"""),_display_(/*87.59*/Messages("payPostpaidBill.contractNumber")),format.raw/*87.101*/("""</label>
                  <div class="col-lg-8">
                    <input type="text" class="form-control input-form" id="contractNumber" readonly>
                  </div>
                </div>
        
                <div class="mb-4 row ">
                  <label class="col-lg-4 col-form-label">"""),_display_(/*94.59*/Messages("payPostpaidBill.totalDebt")),format.raw/*94.96*/("""</label>
                  <div class="col-lg-8">
                    <input type="text" class="form-control input-form" id="totalDebt" readonly>
                  </div>
                </div>
        
                <div class="mb-4 row ">
                  <label class="col-lg-4 col-form-label">"""),_display_(/*101.59*/Messages("payPostpaidBill.payment")),format.raw/*101.94*/("""</label>
                  <div class="col-lg-8">
                    <div class="input-wrapper">
                      <input type="text" class="form-control input-form" id="paymentAmount" placeholder=""""),_display_(/*104.107*/Messages("payPostpaidBill.paymentPlaceholder")),format.raw/*104.153*/("""" required>
                      <span class="clear-btn">&times;</span>
                    </div>
                    <p class="title-section-2 text-darker fst-italic pt-3">
                      """),_display_(/*108.24*/Messages("payPostpaidBill.paymentNotice")),format.raw/*108.65*/("""
                    """),format.raw/*109.21*/("""</p>
                  </div>
                </div>
              </div>
            </div>
        
            <!-- Thông tin thanh toán -->
            <div class="col-md-5 col-lg-3 payment-box d-flex justify-content-center">
              <div class="col-md-10">
              <h5 class="mb-4">"""),_display_(/*118.33*/Messages("payPostpaidBill.paymentInfoBox")),format.raw/*118.75*/("""</h5>
              <div class="d-flex justify-content-between flex-wrap align-items-center gap-1 mb-5">
                <strong> """),_display_(/*120.27*/Messages("payPostpaidBill.totalPayment")),format.raw/*120.67*/("""</strong> <strong id="total">"""),_display_(/*120.97*/Messages("payPostpaidBill.js.zeroAmount")),format.raw/*120.138*/("""</strong>
              </div>
              <div class="d-flex justify-content-center">
                <button type="button" class="btn ms-0 btn-telco disabled" id="btn_confirm_payment" style="background: #EA0033; color: #FFFFFF;">"""),_display_(/*123.146*/Messages("payPostpaidBill.payButton")),format.raw/*123.183*/("""</button>
              </div>
              </div>
             
            </div>
          </div>
        </div>
      
      </form>
      <!-- Modal xác nhận đóng cước trước -->
      <div class="modal fade" id="modalpay_confirm_payment" tabindex="-1" aria-labelledby="modalpay_confirm_paymentLabel"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" style="box-shadow:none">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title mt-3 mb-3" id="modalpay_confirm_paymentLabel">"""),_display_(/*138.85*/Messages("payPostpaidBill.confirmTitle")),format.raw/*138.125*/("""</h5>
            </div>
            <div class="modal-body text-center pt-0 pb-0" id="modalpay_confirm_paymentBody">
              <p class="mb-0">"""),_display_(/*141.32*/Messages("payPostpaidBill.confirmQuestion1")),format.raw/*141.76*/("""</p>
              <p class="mb-0">"""),_display_(/*142.32*/Messages("payPostpaidBill.confirmQuestion2")),format.raw/*142.76*/(""" """),format.raw/*142.77*/("""<strong id="confirm_payment_amount"></strong> """),_display_(/*142.124*/Messages("payPostpaidBill.confirmQuestion3")),format.raw/*142.168*/(""" """),format.raw/*142.169*/("""<strong id="confirm_payment_contract"></strong> ?</strong>
              </p>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF;"
                id="btnpay_confirm_payment">"""),_display_(/*147.46*/Messages("payPostpaidBill.confirmButton")),format.raw/*147.87*/("""</button>
              <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;"
                data-bs-dismiss="modal">"""),_display_(/*149.42*/Messages("payPostpaidBill.cancelButton")),format.raw/*149.82*/("""</button>
            </div>
          </div>
        </div>
      </div>
  
      <div class="modal fade" id="comfirmRechargeModal" data-bs-backdrop="static" tabindex="-1"
        aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" style="box-shadow:none">
          <div class="modal-content" id="theme16">
            <div class="modal-header" style="text-align: center; display: block">
              <img src=""""),_display_(/*160.26*/routes/*160.32*/.Assets.versioned("images/telco/successIcon.png")),format.raw/*160.81*/("""" alt="..."
                style="width: 56px; height: 56px;" class="card-img mt-3"><br>
              <h6 class="modal-title mt-3">"""),_display_(/*162.45*/Messages("payPostpaidBill.successMessage")),format.raw/*162.87*/("""
              """),format.raw/*163.15*/("""</h6>
  
              <button type="button" class="btn btn-red mt-5" data-bs-dismiss="modal"
                onclick="showBill()">"""),_display_(/*166.39*/Messages("payPostpaidBill.confirmButtonSuccess")),format.raw/*166.87*/("""</button>
            </div>
          </div>
        </div> <!-- modal-bialog .// -->
      </div>
    </div>
    """),_display_(/*172.6*/views/*172.11*/.html.telco.Loading()),format.raw/*172.32*/("""
  """),format.raw/*173.3*/("""</div>
  <!--  END OF PAPER WRAP -->

  """),_display_(/*176.4*/views/*176.9*/.html.telco.mainJs()),format.raw/*176.29*/("""

  """),format.raw/*178.3*/("""<script>
    var userId = '"""),_display_(/*179.20*/userId),format.raw/*179.26*/("""';
  </script>
  <script src=""""),_display_(/*181.17*/routes/*181.23*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*181.82*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*182.17*/routes/*182.23*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/moment.min.js")),format.raw/*182.109*/(""""></script>
  <script src=""""),_display_(/*183.17*/routes/*183.23*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.min.js")),format.raw/*183.136*/(""""></script>
  <script src=""""),_display_(/*184.17*/routes/*184.23*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*184.83*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*185.17*/routes/*185.23*/.Assets.versioned("javascripts/views/telco/PayPostpaidBill/PayPostpaidBill.js")),format.raw/*185.102*/("""" type="text/javascript"></script>

</body>

</html>"""))
      }
    }
  }

  def render(currentUser:User,userId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,userId)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,userId) => apply(currentUser,userId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/payPostpaidBill/PayPostpaidBill.scala.html
                  HASH: 3cb72f02a4f8ae7c49b3f788aba698590cbea537
                  MATRIX: 673->1|709->31|1061->65|1189->98|1216->99|1378->234|1432->267|1511->319|1526->325|1583->361|1784->536|1797->541|1843->566|1874->570|1914->583|1929->589|2004->643|2068->680|2083->686|2168->750|2220->867|2250->870|2290->883|2305->889|2375->938|2436->972|2451->978|2547->1053|2609->1088|2624->1094|2761->1209|2824->1245|2839->1251|2926->1317|2990->1354|3005->1360|3080->1414|3162->1468|3191->1469|3224->1475|3309->1533|3337->1534|3369->1539|3417->1559|3446->1560|3480->1567|3534->1594|3562->1595|3594->1600|3637->1615|3666->1616|3700->1623|3799->1695|3827->1696|3860->1702|3909->1723|3938->1724|3974->1733|4051->1783|4079->1784|4112->1790|4151->1801|4180->1802|4214->1809|4439->2007|4467->2008|4500->2014|4545->2031|4574->2032|4610->2041|4654->2058|4682->2059|4713->2063|4784->2108|4797->2113|4859->2154|4890->2159|4903->2164|4955->2195|4986->2199|5077->2264|5091->2269|5179->2336|5220->2350|5370->2473|5426->2507|5584->2638|5644->2677|5683->2688|6061->3039|6125->3081|6458->3387|6516->3424|6845->3725|6902->3760|7135->3964|7204->4010|7431->4209|7494->4250|7544->4271|7872->4571|7936->4613|8095->4744|8157->4784|8215->4814|8279->4855|8542->5089|8602->5126|9206->5702|9269->5742|9446->5891|9512->5935|9576->5971|9642->6015|9672->6016|9748->6063|9815->6107|9846->6108|10163->6397|10226->6438|10413->6597|10475->6637|10979->7113|10995->7119|11066->7168|11228->7302|11292->7344|11336->7359|11496->7491|11566->7539|11709->7655|11724->7660|11767->7681|11798->7684|11866->7725|11880->7730|11922->7750|11954->7754|12010->7782|12038->7788|12097->7819|12113->7825|12194->7884|12273->7935|12289->7941|12398->8027|12454->8055|12470->8061|12606->8174|12662->8202|12678->8208|12760->8268|12839->8319|12855->8325|12957->8404
                  LINES: 24->1|25->2|30->3|35->3|36->4|42->10|42->10|43->11|43->11|43->11|48->16|48->16|48->16|50->18|50->18|50->18|50->18|51->19|51->19|51->19|52->21|53->22|53->22|53->22|53->22|54->23|54->23|54->23|55->24|55->24|55->24|57->26|57->26|57->26|58->27|58->27|58->27|60->29|60->29|61->30|63->32|63->32|64->33|64->33|64->33|65->34|66->35|66->35|67->36|67->36|67->36|68->37|71->40|71->40|73->42|73->42|73->42|74->43|75->44|75->44|77->46|77->46|77->46|78->47|86->55|86->55|88->57|88->57|88->57|89->58|90->59|90->59|92->61|96->65|96->65|96->65|98->67|98->67|98->67|100->69|102->71|102->71|102->71|104->73|105->74|105->74|109->78|109->78|110->79|118->87|118->87|125->94|125->94|132->101|132->101|135->104|135->104|139->108|139->108|140->109|149->118|149->118|151->120|151->120|151->120|151->120|154->123|154->123|169->138|169->138|172->141|172->141|173->142|173->142|173->142|173->142|173->142|173->142|178->147|178->147|180->149|180->149|191->160|191->160|191->160|193->162|193->162|194->163|197->166|197->166|203->172|203->172|203->172|204->173|207->176|207->176|207->176|209->178|210->179|210->179|212->181|212->181|212->181|213->182|213->182|213->182|214->183|214->183|214->183|215->184|215->184|215->184|216->185|216->185|216->185
                  -- GENERATED --
              */
          