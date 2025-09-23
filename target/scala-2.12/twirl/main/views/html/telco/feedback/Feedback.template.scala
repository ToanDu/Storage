
package views.html.telco.feedback

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
/*1.2*/import vn.m2m.common.models.User

object Feedback extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User, userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.35*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*8.13*/Messages("feedback.title")),format.raw/*8.39*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*9.46*/routes/*9.52*/.Assets.versioned("images/logo.jpg")),format.raw/*9.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*14.6*/views/*14.11*/.html.iot.tags.Main_css()),format.raw/*14.36*/("""

    """),format.raw/*16.5*/("""<link href=""""),_display_(/*16.18*/routes/*16.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*16.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("assets/plugins/input-tags/css/tagsinput.css")),format.raw/*17.88*/("""" rel="stylesheet" />
    """),format.raw/*18.96*/("""
    """),format.raw/*19.5*/("""<link href='"""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*19.73*/("""' type='text/css'>
    """),format.raw/*20.163*/("""
    """),format.raw/*21.5*/("""<link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("stylesheets/bootstrap/datepicker.min.css")),format.raw/*21.85*/("""" rel="stylesheet" />

    <link href=""""),_display_(/*23.18*/routes/*23.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*23.78*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*27.6*/views/*27.11*/.html.telco.Menu(currentUser, "", userId)),format.raw/*27.52*/("""

    """),_display_(/*29.6*/views/*29.11*/.html.telco.Header(currentUser)),format.raw/*29.42*/("""

    """),format.raw/*31.5*/("""<div class="page-wrapper">
      <div class="page-content">

        <div class="card">
          <div class="card-body" style="border-radius: 8px;">

            <span class="text-search">"""),_display_(/*37.40*/Messages("feedback.dear.customer")),format.raw/*37.74*/("""</span><br>
            <span class="">"""),_display_(/*38.29*/Messages("feedback.thank.you.message")),format.raw/*38.67*/("""</span>
            <hr>

            <div class="row mt-3">
              <div class="col-md-6 mt-1">
                <div class="row">
                  <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*44.75*/Messages("feedback.fullname.required")),format.raw/*44.113*/("""</label>
                  <div class="col-sm-8">
                    <input id="fullName" type="text" class="form-control input-form" placeholder=""""),_display_(/*46.100*/Messages("feedback.placeholder.enter.content")),format.raw/*46.146*/("""" maxlength="50">
                  </div>
                </div>
              </div>
              <div class="col-md-12 mt-3">
                <div class="row">
                  <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*52.75*/Messages("feedback.company.name.required")),format.raw/*52.117*/("""</label>
                  <div class="col-sm-9">
                    <input id="nameCompany" type="text" class="form-control input-form" placeholder=""""),_display_(/*54.103*/Messages("feedback.placeholder.enter.content")),format.raw/*54.149*/("""" maxlength="250">
                  </div>
                </div>
              </div>
              <div class="col-md-12 mt-3">
                <div class="row">
                  <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*60.75*/Messages("feedback.field.required")),format.raw/*60.110*/("""</label>
                  <div class="col-sm-9">
                    <select class="form-control" id="field">
                      <option value="">"""),_display_(/*63.41*/Messages("feedback.select.business.field")),format.raw/*63.83*/("""</option>
                      <option value="0">"""),_display_(/*64.42*/Messages("feedback.field.industrial.iot")),format.raw/*64.83*/("""</option>
                      <option value="1">"""),_display_(/*65.42*/Messages("feedback.field.ai")),format.raw/*65.71*/("""</option>
                      <option value="2">"""),_display_(/*66.42*/Messages("feedback.field.smart.home")),format.raw/*66.79*/("""</option>
                      <option value="3">"""),_display_(/*67.42*/Messages("feedback.field.wearable.devices")),format.raw/*67.85*/("""</option>
                      <option value="4">"""),_display_(/*68.42*/Messages("feedback.field.healthcare")),format.raw/*68.79*/("""</option>
                      <option value="5">"""),_display_(/*69.42*/Messages("feedback.field.agriculture")),format.raw/*69.80*/("""</option>
                      <option value="6">"""),_display_(/*70.42*/Messages("feedback.field.utilities")),format.raw/*70.78*/("""</option>
                      <option value="7">"""),_display_(/*71.42*/Messages("feedback.field.transportation")),format.raw/*71.83*/("""</option>
                      <option value="100">"""),_display_(/*72.44*/Messages("feedback.field.other")),format.raw/*72.76*/("""</option>
                    </select>
                  </div>
                </div>
              </div>
              <div class="col-md-12 mt-3">
                <div class="row">
                  <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*79.75*/Messages("feedback.comment.required")),format.raw/*79.112*/("""</label>
                  <div class="col-sm-9">
                    <textarea class="form-control" id="content" rows="6" maxlength="1000" placeholder=""""),_display_(/*81.105*/Messages("feedback.placeholder.enter.max.chars")),format.raw/*81.153*/(""""></textarea>
                  </div>
                </div>
              </div>
              <div class="col-md-12 mt-3">
                <div class="row">
                  <label class="col-sm-2 col-form-label title-section-2">"""),_display_(/*87.75*/Messages("feedback.satisfaction.level")),format.raw/*87.114*/("""</label>
                  <div class="col-sm-9">
                    <select class="form-control" id="rate">
                      <option value="0">"""),_display_(/*90.42*/Messages("feedback.select.satisfaction.level")),format.raw/*90.88*/("""</option>
                      <option value="5">"""),_display_(/*91.42*/Messages("feedback.very.satisfied")),format.raw/*91.77*/("""</option>
                      <option value="4">"""),_display_(/*92.42*/Messages("feedback.satisfied")),format.raw/*92.72*/("""</option>
                      <option value="3">"""),_display_(/*93.42*/Messages("feedback.normal")),format.raw/*93.69*/("""</option>
                      <option value="2">"""),_display_(/*94.42*/Messages("feedback.somewhat.dissatisfied")),format.raw/*94.84*/("""</option>
                      <option value="1">"""),_display_(/*95.42*/Messages("feedback.completely.dissatisfied")),format.raw/*95.86*/("""</option>
                    </select>
                  </div>
                </div>
              </div>
            </div>

            <div class="d-flex flex-column align-items-center text-center mt-3">
              <div class="">
                <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF;width: 180px;" onclick="sendFeedback()">"""),_display_(/*104.150*/Messages("feedback.confirm.send")),format.raw/*104.183*/("""</button>
              </div>
            </div>

          </div>
        </div>

      </div>

      """),_display_(/*113.8*/views/*113.13*/.html.telco.Loading()),format.raw/*113.34*/("""

    """),format.raw/*115.5*/("""</div>
      <!--  END OF PAPER WRAP -->

    """),_display_(/*118.6*/views/*118.11*/.html.telco.mainJs()),format.raw/*118.31*/("""
    """),format.raw/*119.5*/("""<script src=""""),_display_(/*119.19*/routes/*119.25*/.Assets.versioned("javascripts/bootstrap/bootstrap-datepicker.min.js")),format.raw/*119.95*/("""" type="text/javascript"></script>

    <script>
      var userId = '"""),_display_(/*122.22*/userId),format.raw/*122.28*/("""';
            var imgDefault = '"""),_display_(/*123.32*/routes/*123.38*/.Assets.versioned("images/market/default.png")),format.raw/*123.84*/("""';
            $(document).ready(function () """),format.raw/*124.43*/("""{"""),format.raw/*124.44*/("""
              """),format.raw/*125.15*/("""$("#menu-feedback").addClass("mm-active");
              $("#menu").metisMenu();
            """),format.raw/*127.13*/("""}"""),format.raw/*127.14*/(""")
    </script>

    <script src=""""),_display_(/*130.19*/routes/*130.25*/.Assets.versioned("javascripts/views/telco/feedback/Feedback.js")),format.raw/*130.90*/("""" type="text/javascript"></script>
    """),format.raw/*131.142*/("""

  """),format.raw/*133.3*/("""</body>
</html>
"""))
      }
    }
  }

  def render(currentUser:User,userId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,userId)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,userId) => apply(currentUser,userId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:52 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/feedback/Feedback.scala.html
                  HASH: 51482bf55edbad956cc41332b2455af3eee29bad
                  MATRIX: 666->1|1011->35|1139->68|1166->69|1334->211|1380->237|1460->291|1474->297|1530->333|1737->514|1751->519|1797->544|1830->550|1870->563|1885->569|1960->623|2026->662|2041->668|2126->732|2180->849|2212->854|2252->867|2267->873|2337->922|2389->1103|2421->1108|2461->1121|2476->1127|2558->1188|2625->1228|2640->1234|2715->1288|2805->1352|2819->1357|2881->1398|2914->1405|2928->1410|2980->1441|3013->1447|3230->1637|3285->1671|3352->1711|3411->1749|3649->1960|3709->1998|3886->2147|3954->2193|4219->2431|4283->2473|4463->2625|4531->2671|4797->2910|4854->2945|5032->3096|5095->3138|5173->3189|5235->3230|5313->3281|5363->3310|5441->3361|5499->3398|5577->3449|5641->3492|5719->3543|5777->3580|5855->3631|5914->3669|5992->3720|6049->3756|6127->3807|6189->3848|6269->3901|6322->3933|6609->4193|6668->4230|6850->4384|6920->4432|7181->4666|7242->4705|7420->4856|7487->4902|7565->4953|7621->4988|7699->5039|7750->5069|7828->5120|7876->5147|7954->5198|8017->5240|8095->5291|8160->5335|8577->5723|8633->5756|8765->5861|8780->5866|8823->5887|8857->5893|8931->5940|8946->5945|8988->5965|9021->5970|9063->5984|9079->5990|9171->6060|9269->6130|9297->6136|9359->6170|9375->6176|9443->6222|9517->6267|9547->6268|9591->6283|9713->6376|9743->6377|9806->6412|9822->6418|9909->6483|9978->6659|10010->6663
                  LINES: 24->1|29->2|34->2|35->3|40->8|40->8|41->9|41->9|41->9|46->14|46->14|46->14|48->16|48->16|48->16|48->16|49->17|49->17|49->17|50->18|51->19|51->19|51->19|51->19|52->20|53->21|53->21|53->21|53->21|55->23|55->23|55->23|59->27|59->27|59->27|61->29|61->29|61->29|63->31|69->37|69->37|70->38|70->38|76->44|76->44|78->46|78->46|84->52|84->52|86->54|86->54|92->60|92->60|95->63|95->63|96->64|96->64|97->65|97->65|98->66|98->66|99->67|99->67|100->68|100->68|101->69|101->69|102->70|102->70|103->71|103->71|104->72|104->72|111->79|111->79|113->81|113->81|119->87|119->87|122->90|122->90|123->91|123->91|124->92|124->92|125->93|125->93|126->94|126->94|127->95|127->95|136->104|136->104|145->113|145->113|145->113|147->115|150->118|150->118|150->118|151->119|151->119|151->119|151->119|154->122|154->122|155->123|155->123|155->123|156->124|156->124|157->125|159->127|159->127|162->130|162->130|162->130|163->131|165->133
                  -- GENERATED --
              */
          