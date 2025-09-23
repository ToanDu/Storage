
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

object PrepayCharges_bill extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

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
  <title>"""),_display_(/*10.11*/Messages("prepayCharges.bill.title")),format.raw/*10.47*/("""</title>
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
        <h5 class="fw-bold mb-4">"""),_display_(/*38.35*/Messages("prepayCharges.bill.pageHeader")),format.raw/*38.76*/("""</h5>
        <div class="row justify-content-center">
          <div class="col-lg-9">
            <div class="row mb-3">
              <label class="col-sm-5 col-form-label">"""),_display_(/*42.55*/Messages("prepayCharges.bill.subscriberNumber")),format.raw/*42.102*/("""</label>
              <div class="col-sm-7">
                <input type="text" readonly class="form-control" id="isdn">
              </div>
            </div>
  
            <div class="row mb-3">
              <label class="col-sm-5 col-form-label">"""),_display_(/*49.55*/Messages("prepayCharges.bill.packageCode")),format.raw/*49.97*/("""</label>
              <div class="col-sm-7">
                <input type="text" readonly class="form-control" id="product_code">
              </div>
            </div>
  
            <div class="row mb-3">
              <label class="col-sm-5 col-form-label">"""),_display_(/*56.55*/Messages("prepayCharges.bill.promotionCode")),format.raw/*56.99*/("""</label>
              <div class="col-sm-7">
                <input type="text" readonly class="form-control" id="promotion_code">
              </div>
            </div>
  
            <div class="row mb-3">
              <label class="col-sm-5 col-form-label">"""),_display_(/*63.55*/Messages("prepayCharges.bill.prepaidMonths")),format.raw/*63.99*/("""</label>
              <div class="col-sm-7">
                <input type="text" readonly class="form-control" id="prom_month">
              </div>
            </div>
  
            <div class="row mb-3">
              <label class="col-sm-5 col-form-label">"""),_display_(/*70.55*/Messages("prepayCharges.bill.promotion")),format.raw/*70.95*/("""</label>
              <div class="col-sm-7">
                <input type="text" readonly class="form-control" id="prom_value">
              </div>
            </div>
  
            <div class="row mb-3">
              <label class="col-sm-5 col-form-label">"""),_display_(/*77.55*/Messages("prepayCharges.bill.paymentAmount")),format.raw/*77.99*/("""</label>
              <div class="col-sm-7">
                <input type="text" readonly class="form-control" id="amount">
              </div>
            </div>
  
            <div class="row mb-3">
              <label class="col-sm-5 col-form-label">"""),_display_(/*84.55*/Messages("prepayCharges.bill.status")),format.raw/*84.92*/("""</label>
              <div class="col-sm-7">
                <input type="text" readonly class="form-control status-success" id="state">
              </div>
            </div>
  
            <div class="row mb-3">
              <label class="col-sm-5 col-form-label">"""),_display_(/*91.55*/Messages("prepayCharges.bill.reason")),format.raw/*91.92*/("""</label>
              <div class="col-sm-7">
                <input type="text" readonly class="form-control" id="description">
              </div>
            </div>
  
            <div class="row mb-5">
              <label class="col-sm-5 col-form-label">"""),_display_(/*98.55*/Messages("prepayCharges.bill.executionTime")),format.raw/*98.99*/("""</label>
              <div class="col-sm-7">
                <input type="text" readonly class="form-control" id="execute_time">
              </div>
            </div>
            <div class="d-flex flex-column align-items-center text-center mt-5">
              <div class="">
                <a href=""""),_display_(/*105.27*/routes/*105.33*/.TelcoHistoryController.historyPrepayCharges(userId)),format.raw/*105.85*/("""" class="btn mt-3 btn-telco w-auto" style="background: #EA0033; color: #FFFFFF;">"""),_display_(/*105.167*/Messages("prepayCharges.bill.historyButton")),format.raw/*105.211*/("""</a>
                <a href=""""),_display_(/*106.27*/routes/*106.33*/.TelcoUtilitiesController.prepayCharges(userId)),format.raw/*106.80*/("""" class="btn mt-3 btn-telco w-auto"
                  style="background: #EA0033; color: #FFFFFF;">"""),_display_(/*107.65*/Messages("prepayCharges.bill.continueButton")),format.raw/*107.110*/("""</a>
              </div>
            </div>
          </div>
        </div>
  
      </div>
  
    </div>
    """),_display_(/*116.6*/views/*116.11*/.html.telco.Loading()),format.raw/*116.32*/("""
  """),format.raw/*117.3*/("""</div>
  <!--  END OF PAPER WRAP -->

  """),_display_(/*120.4*/views/*120.9*/.html.telco.mainJs()),format.raw/*120.29*/("""

  """),format.raw/*122.3*/("""<script>
    var userId = '"""),_display_(/*123.20*/userId),format.raw/*123.26*/("""';
  </script>
  <script src=""""),_display_(/*125.17*/routes/*125.23*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/moment.min.js")),format.raw/*125.109*/(""""></script>
  <script src=""""),_display_(/*126.17*/routes/*126.23*/.Assets.versioned("javascripts/views/telco/prepayCharges/prepayCharges_bill.js")),format.raw/*126.103*/("""" type="text/javascript"></script>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/prepayCharges/PrepayCharges_bill.scala.html
                  HASH: 76f75cfe8aaa3bc0c73bcd5089b54b82cb24e2d1
                  MATRIX: 671->1|707->31|1062->65|1190->98|1217->99|1379->234|1436->270|1515->322|1530->328|1587->364|1788->539|1801->544|1847->569|1878->573|1918->586|1933->592|2008->646|2072->683|2087->689|2172->753|2224->870|2254->873|2294->886|2309->892|2379->941|2440->975|2455->981|2551->1056|2613->1091|2628->1097|2765->1212|2828->1248|2843->1254|2930->1320|2994->1357|3009->1363|3084->1417|3168->1475|3181->1480|3243->1521|3274->1526|3287->1531|3339->1562|3370->1566|3518->1687|3580->1728|3784->1905|3853->1952|4134->2206|4197->2248|4486->2510|4551->2554|4842->2818|4907->2862|5194->3122|5255->3162|5542->3422|5607->3466|5890->3722|5948->3759|6245->4029|6303->4066|6591->4327|6656->4371|6990->4677|7006->4683|7080->4735|7191->4817|7258->4861|7317->4892|7333->4898|7402->4945|7530->5045|7598->5090|7737->5202|7752->5207|7795->5228|7826->5231|7894->5272|7908->5277|7950->5297|7982->5301|8038->5329|8066->5335|8125->5366|8141->5372|8250->5458|8306->5486|8322->5492|8425->5572
                  LINES: 24->1|25->2|30->3|35->3|36->4|42->10|42->10|43->11|43->11|43->11|48->16|48->16|48->16|50->18|50->18|50->18|50->18|51->19|51->19|51->19|52->21|53->22|53->22|53->22|53->22|54->23|54->23|54->23|55->24|55->24|55->24|57->26|57->26|57->26|58->27|58->27|58->27|62->31|62->31|62->31|64->33|64->33|64->33|66->35|69->38|69->38|73->42|73->42|80->49|80->49|87->56|87->56|94->63|94->63|101->70|101->70|108->77|108->77|115->84|115->84|122->91|122->91|129->98|129->98|136->105|136->105|136->105|136->105|136->105|137->106|137->106|137->106|138->107|138->107|147->116|147->116|147->116|148->117|151->120|151->120|151->120|153->122|154->123|154->123|156->125|156->125|156->125|157->126|157->126|157->126
                  -- GENERATED --
              */
          