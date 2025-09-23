
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

object PayPostpaidBill_detail extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

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
  <title>"""),_display_(/*10.11*/Messages("payPostpaidBill.detail.title")),format.raw/*10.51*/("""</title>
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
      <div class="card p-4">
        <h5 class="fw-bold mb-4">"""),_display_(/*38.35*/Messages("payPostpaidBill.detail.pageHeader")),format.raw/*38.80*/("""</h5>
        <div class="row justify-content-center">
          <div class="col-lg-9">
            <div class="row mb-3">
              <label class="col-sm-5 col-form-label">"""),_display_(/*42.55*/Messages("payPostpaidBill.detail.contractNumber")),format.raw/*42.104*/("""</label>
              <div class="col-sm-7">
                <input type="text" value="---" readonly class="form-control" id="contractNumber">
              </div>
            </div>
  
            <div class="row mb-3">
              <label class="col-sm-5 col-form-label">"""),_display_(/*49.55*/Messages("payPostpaidBill.detail.totalDebt")),format.raw/*49.99*/("""</label>
              <div class="col-sm-7">
                <input type="text" value="---" readonly class="form-control" id="total_debt">
              </div>
            </div>
  
            <div class="row mb-3">
              <label class="col-sm-5 col-form-label">"""),_display_(/*56.55*/Messages("payPostpaidBill.detail.paymentAmount")),format.raw/*56.103*/("""</label>
              <div class="col-sm-7">
                <input type="text" value="---" readonly class="form-control" id="payment_amount">
              </div>
            </div>
  
            <div class="row mb-3">
              <label class="col-sm-5 col-form-label">"""),_display_(/*63.55*/Messages("payPostpaidBill.detail.status")),format.raw/*63.96*/("""</label>
              <div class="col-sm-7">
                <input type="text" value="---" readonly class="form-control status-success" id="state">
              </div>
            </div>
  
            <div class="row mb-3">
              <label class="col-sm-5 col-form-label">"""),_display_(/*70.55*/Messages("payPostpaidBill.detail.reason")),format.raw/*70.96*/("""</label>
              <div class="col-sm-7">
                <input type="text" value="---" readonly class="form-control" id="description">
              </div>
            </div>
  
            <div class="row mb-5">
              <label class="col-sm-5 col-form-label">"""),_display_(/*77.55*/Messages("payPostpaidBill.detail.executionTime")),format.raw/*77.103*/("""</label>
              <div class="col-sm-7">
                <input type="text" value="---" readonly class="form-control" id="execute_time">
              </div>
            </div>
            <div class="d-flex flex-column align-items-center text-center mt-5">
              <div class="">
                <a href=""""),_display_(/*84.27*/routes/*84.33*/.TelcoHistoryController.historyPostPaidBill(userId)),format.raw/*84.84*/("""" class="btn mt-3 btn-telco w-auto" style="background: #EA0033; color: #FFFFFF;">"""),_display_(/*84.166*/Messages("payPostpaidBill.detail.historyButton")),format.raw/*84.214*/("""</a>
                <a href=""""),_display_(/*85.27*/routes/*85.33*/.TelcoUtilitiesController.payPostpaidBill(userId)),format.raw/*85.82*/("""" class="btn mt-3 btn-telco w-auto"
                  style="background: #EA0033; color: #FFFFFF;">"""),_display_(/*86.65*/Messages("payPostpaidBill.detail.continueButton")),format.raw/*86.114*/("""</a>
              </div>
            </div>
          </div>
        </div>
  
      </div>
  
    </div>
    """),_display_(/*95.6*/views/*95.11*/.html.telco.Loading()),format.raw/*95.32*/("""
  """),format.raw/*96.3*/("""</div>
  <!--  END OF PAPER WRAP -->

  """),_display_(/*99.4*/views/*99.9*/.html.telco.mainJs()),format.raw/*99.29*/("""

  """),format.raw/*101.3*/("""<script>
    var userId = '"""),_display_(/*102.20*/userId),format.raw/*102.26*/("""';
  </script>
  <script src=""""),_display_(/*104.17*/routes/*104.23*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/moment.min.js")),format.raw/*104.109*/(""""></script>
  <script src=""""),_display_(/*105.17*/routes/*105.23*/.Assets.versioned("javascripts/views/telco/PayPostpaidBill/PayPostpaidBill.js")),format.raw/*105.102*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*106.17*/routes/*106.23*/.Assets.versioned("javascripts/views/telco/PayPostpaidBill/PayPostpaidBill_detail.js")),format.raw/*106.109*/("""" type="text/javascript"></script>
  <script>
  
</script>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/payPostpaidBill/PayPostpaidBill_detail.scala.html
                  HASH: 75f7f64c6136e134b29d222a08a9c5287594f2d7
                  MATRIX: 673->1|709->31|1068->65|1196->98|1223->99|1385->234|1446->274|1525->326|1540->332|1597->368|1798->543|1811->548|1857->573|1888->577|1928->590|1943->596|2018->650|2082->687|2097->693|2182->757|2234->874|2264->877|2304->890|2319->896|2389->945|2450->979|2465->985|2561->1060|2623->1095|2638->1101|2775->1216|2838->1252|2853->1258|2940->1324|3004->1361|3019->1367|3094->1421|3178->1479|3191->1484|3253->1525|3284->1530|3297->1535|3349->1566|3380->1570|3528->1691|3594->1736|3798->1913|3869->1962|4172->2238|4237->2282|4536->2554|4606->2602|4909->2878|4971->2919|5280->3201|5342->3242|5642->3515|5712->3563|6057->3881|6072->3887|6144->3938|6254->4020|6324->4068|6382->4099|6397->4105|6467->4154|6594->4254|6665->4303|6803->4415|6817->4420|6859->4441|6889->4444|6956->4485|6969->4490|7010->4510|7042->4514|7098->4542|7126->4548|7185->4579|7201->4585|7310->4671|7366->4699|7382->4705|7484->4784|7563->4835|7579->4841|7688->4927
                  LINES: 24->1|25->2|30->3|35->3|36->4|42->10|42->10|43->11|43->11|43->11|48->16|48->16|48->16|50->18|50->18|50->18|50->18|51->19|51->19|51->19|52->21|53->22|53->22|53->22|53->22|54->23|54->23|54->23|55->24|55->24|55->24|57->26|57->26|57->26|58->27|58->27|58->27|62->31|62->31|62->31|64->33|64->33|64->33|66->35|69->38|69->38|73->42|73->42|80->49|80->49|87->56|87->56|94->63|94->63|101->70|101->70|108->77|108->77|115->84|115->84|115->84|115->84|115->84|116->85|116->85|116->85|117->86|117->86|126->95|126->95|126->95|127->96|130->99|130->99|130->99|132->101|133->102|133->102|135->104|135->104|135->104|136->105|136->105|136->105|137->106|137->106|137->106
                  -- GENERATED --
              */
          