
package views.html.telco.prepayCharges

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

object PrepayCharges extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

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
  <title>"""),_display_(/*10.11*/Messages("prepayCharges.title")),format.raw/*10.42*/("""</title>
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
</head>

<body class="bg-theme">
  """),_display_(/*31.4*/views/*31.9*/.html.telco.Menu(currentUser, "", userId)),format.raw/*31.50*/("""

  """),_display_(/*33.4*/views/*33.9*/.html.telco.Header(currentUser)),format.raw/*33.40*/("""

  """),format.raw/*35.3*/("""<div class="page-wrapper">
    <div class="page-content">
      """),_display_(/*37.8*/views/*37.13*/.html.telco.prepayCharges.PrepayCharges_formSearch(currentUser)),format.raw/*37.76*/("""

      """),format.raw/*39.7*/("""<form id="prepayForm" class="card p-4 pt-3">
        <span class="text-search"
         style="border-top: 1px solid #D9D9D9; padding: 10px 0;">
         """),_display_(/*42.11*/Messages("prepayCharges.info")),format.raw/*42.41*/("""
        """),format.raw/*43.9*/("""</span>
        <p id="prepayCharges_no_data">"""),_display_(/*44.40*/Messages("prepayCharges.noData")),format.raw/*44.72*/("""</p>
        <div id="form_info" class="d-none">
        <div class="row">
          <!-- Thông tin đóng cước -->
          <div class="col-md-7 col-lg-9" id="prepayChargesInfo">
            <div class="mb-4 row">
              <label class="col-lg-4 col-form-label">"""),_display_(/*50.55*/Messages("prepayCharges.phoneNumber")),format.raw/*50.92*/("""</label>
              <div class="col-lg-8">
                <input type="text" class="form-control input-form" id="phoneNumber" readonly>
              </div>
            </div>
      
            <div class="mb-4 row ">
              <label class="col-lg-4 col-form-label">"""),_display_(/*57.55*/Messages("prepayCharges.package")),format.raw/*57.88*/("""</label>
              <div class="col-lg-8">
                <input type="text" class="form-control input-form" id="productCode" readonly>
              </div>
            </div>

            <div class="mb-4 row ">
              <label class="col-lg-4 col-form-label">"""),_display_(/*64.55*/Messages("prepayCharges.promotionCode")),format.raw/*64.94*/("""</label>
              <div class="col-lg-8">
                <input type="text" class="form-control input-form" id="promotionCode" readonly>
              </div>
            </div>
      
            <div class="mb-4 row ">
              <label class="col-lg-4 col-form-label">"""),_display_(/*71.55*/Messages("prepayCharges.monthsToPrepay")),format.raw/*71.95*/("""</label>
              <div class="col-lg-8">
                <div class="row" id="prepayOptions">
                </div>
                <div><small>"""),_display_(/*75.30*/Messages("prepayCharges.priceIncludesBonus")),format.raw/*75.74*/("""</small></div>
              </div>
            </div>
          </div>
      
          <!-- Thông tin thanh toán -->
          <div class="col-md-5 col-lg-3 payment-box">
            <h5 class="mb-4">"""),_display_(/*82.31*/Messages("prepayCharges.payment")),format.raw/*82.64*/("""</h5>
            <div class="d-flex justify-content-between flex-wrap align-items-center gap-1 mb-5">
              <strong> """),_display_(/*84.25*/Messages("prepayCharges.totalPayment")),format.raw/*84.63*/("""</strong> <strong id="total">0 đ</strong>
            </div>
            <div class="d-flex justify-content-center">
              <button type="button" class="btn ms-0 btn-telco" id="btn_pay" style="background: #EA0033; color: #FFFFFF;">"""),_display_(/*87.123*/Messages("prepayCharges.payButton")),format.raw/*87.158*/("""</button>
            </div>
          </div>
        </div>
        </div>
        
      </form>
      <!-- Modal xác nhận đóng cước trước -->
      <div class="modal fade" id="modalPrepayConfirm" tabindex="-1" aria-labelledby="modalPrepayConfirmLabel"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" style="box-shadow:none">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title mt-3 mb-3" id="modalPrepayConfirmLabel">"""),_display_(/*100.79*/Messages("prepayCharges.confirmTitle")),format.raw/*100.117*/("""
              """),format.raw/*101.15*/("""</h5>
            </div>
            <div class="modal-body text-center pt-0 pb-0" id="modalPrepayConfirmBody">
              <p class="mb-0">"""),_display_(/*104.32*/Messages("prepayCharges.confirmQuestion1")),format.raw/*104.74*/("""</p>
              <p class="mb-0">"""),_display_(/*105.32*/Messages("prepayCharges.confirmQuestion2")),format.raw/*105.74*/(""" """),format.raw/*105.75*/("""<strong><span id="numMonth_val"></span> """),_display_(/*105.116*/Messages("prepayCharges.confirmMonths")),format.raw/*105.155*/("""</strong> """),_display_(/*105.166*/Messages("prepayCharges.confirmForSubscriber")),format.raw/*105.212*/("""
                """),format.raw/*106.17*/("""<strong><span id="phoneNumber_val"></span>?</strong></p>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;"
                data-bs-dismiss="modal">"""),_display_(/*110.42*/Messages("prepayCharges.cancel")),format.raw/*110.74*/("""</button>
              <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF;"
                id="btnPrepayConfirm">"""),_display_(/*112.40*/Messages("prepayCharges.confirm")),format.raw/*112.73*/("""</button>
            </div>
          </div>
        </div>
      </div>

     <div class="modal fade" id="comfirmRechargeSubsModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered" style="box-shadow:none">
        <div class="modal-content" id="theme16">
          <div class="modal-header" style="text-align: center; display: block">
            <img src=""""),_display_(/*122.24*/routes/*122.30*/.Assets.versioned("images/telco/successIcon.png")),format.raw/*122.79*/("""" alt="..." style="width: 56px; height: 56px;" class="card-img mt-3"><br>
            <h6 class="modal-title mt-3">"""),_display_(/*123.43*/Messages("prepayCharges.successMessage")),format.raw/*123.83*/("""</h6>

            <button type="button" class="btn btn-red mt-5" data-bs-dismiss="modal" onclick="showBill()">"""),_display_(/*125.106*/Messages("btnComfirm")),format.raw/*125.128*/("""</button>
          </div>
        </div>
      </div> <!-- modal-bialog .// -->
    </div>
    </div>
    """),_display_(/*131.6*/views/*131.11*/.html.telco.Loading()),format.raw/*131.32*/("""
  """),format.raw/*132.3*/("""</div>
  <!--  END OF PAPER WRAP -->

  """),_display_(/*135.4*/views/*135.9*/.html.telco.mainJs()),format.raw/*135.29*/("""

  """),format.raw/*137.3*/("""<script>
    var userId = '"""),_display_(/*138.20*/userId),format.raw/*138.26*/("""';
  </script>
  <script src=""""),_display_(/*140.17*/routes/*140.23*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*140.82*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*141.17*/routes/*141.23*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/moment.min.js")),format.raw/*141.109*/(""""></script>
  <script src=""""),_display_(/*142.17*/routes/*142.23*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.min.js")),format.raw/*142.136*/(""""></script>
  <script src=""""),_display_(/*143.17*/routes/*143.23*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*143.83*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*144.17*/routes/*144.23*/.Assets.versioned("javascripts/views/telco/prepayCharges/prepayCharges.js")),format.raw/*144.98*/("""" type="text/javascript"></script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/prepayCharges/PrepayCharges.scala.html
                  HASH: 93a7b6084a8017e443cb7ea797373c80c609de7d
                  MATRIX: 671->1|707->31|1057->65|1185->98|1212->99|1374->234|1426->265|1505->317|1520->323|1577->359|1778->534|1791->539|1837->564|1868->568|1908->581|1923->587|1998->641|2062->678|2077->684|2162->748|2214->865|2244->868|2284->881|2299->887|2369->936|2430->970|2445->976|2541->1051|2603->1086|2618->1092|2755->1207|2818->1243|2833->1249|2920->1315|2984->1352|2999->1358|3074->1412|3158->1470|3171->1475|3233->1516|3264->1521|3277->1526|3329->1557|3360->1561|3451->1626|3465->1631|3549->1694|3584->1702|3766->1857|3817->1887|3853->1896|3927->1943|3980->1975|4275->2243|4333->2280|4637->2557|4691->2590|4989->2861|5049->2900|5355->3179|5416->3219|5594->3370|5659->3414|5889->3617|5943->3650|6097->3777|6156->3815|6423->4054|6480->4089|7027->4608|7088->4646|7132->4661|7303->4804|7367->4846|7431->4882|7495->4924|7525->4925|7595->4966|7657->5005|7697->5016|7766->5062|7812->5079|8104->5343|8158->5375|8343->5532|8398->5565|8887->6026|8903->6032|8974->6081|9118->6197|9180->6237|9321->6349|9366->6371|9501->6479|9516->6484|9559->6505|9590->6508|9658->6549|9672->6554|9714->6574|9746->6578|9802->6606|9830->6612|9889->6643|9905->6649|9986->6708|10065->6759|10081->6765|10190->6851|10246->6879|10262->6885|10398->6998|10454->7026|10470->7032|10552->7092|10631->7143|10647->7149|10744->7224
                  LINES: 24->1|25->2|30->3|35->3|36->4|42->10|42->10|43->11|43->11|43->11|48->16|48->16|48->16|50->18|50->18|50->18|50->18|51->19|51->19|51->19|52->21|53->22|53->22|53->22|53->22|54->23|54->23|54->23|55->24|55->24|55->24|57->26|57->26|57->26|58->27|58->27|58->27|62->31|62->31|62->31|64->33|64->33|64->33|66->35|68->37|68->37|68->37|70->39|73->42|73->42|74->43|75->44|75->44|81->50|81->50|88->57|88->57|95->64|95->64|102->71|102->71|106->75|106->75|113->82|113->82|115->84|115->84|118->87|118->87|131->100|131->100|132->101|135->104|135->104|136->105|136->105|136->105|136->105|136->105|136->105|136->105|137->106|141->110|141->110|143->112|143->112|153->122|153->122|153->122|154->123|154->123|156->125|156->125|162->131|162->131|162->131|163->132|166->135|166->135|166->135|168->137|169->138|169->138|171->140|171->140|171->140|172->141|172->141|172->141|173->142|173->142|173->142|174->143|174->143|174->143|175->144|175->144|175->144
                  -- GENERATED --
              */
          