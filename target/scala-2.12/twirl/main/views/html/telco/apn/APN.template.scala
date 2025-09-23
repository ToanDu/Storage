
package views.html.telco.apn

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
/*3.2*/import vn.m2m.utils.UserHelper

object APN extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(currentUser:User, userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.35*/("""
"""),format.raw/*5.1*/("""<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("apn.title")),format.raw/*9.34*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*17.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("assets/plugins/input-tags/css/tagsinput.css")),format.raw/*18.88*/("""" rel="stylesheet" />
    <link href='"""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*19.73*/("""' type='text/css'>
    <link href=""""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*20.99*/("""" rel="stylesheet">
    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*21.139*/("""" rel="stylesheet" >
    <link href=""""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("stylesheets/views/telco/apn/index.css")),format.raw/*22.82*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*23.18*/routes/*23.24*/.Assets.versioned("stylesheets/component/DatetimePicker.css")),format.raw/*23.85*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*24.18*/routes/*24.24*/.Assets.versioned("stylesheets/main.css")),format.raw/*24.65*/("""" rel="stylesheet" />
  </head>
  <body class="bg-theme">
    """),_display_(/*27.6*/views/*27.11*/.html.telco.Menu(currentUser, "", userId)),format.raw/*27.52*/("""

    """),_display_(/*29.6*/views/*29.11*/.html.telco.Header(currentUser)),format.raw/*29.42*/("""

    """),format.raw/*31.5*/("""<div class="page-wrapper">
      <div class="page-content">
        """),_display_(/*33.10*/views/*33.15*/.html.telco.apn.APN_searchForm()),format.raw/*33.47*/("""

      """),format.raw/*35.7*/("""<div class="card" id="apnSubscriptionCard">
          <div class="card-body" style="min-height: 10rem;">
            <div class="row" id="noDataFound">
              <div class="col-md-12">
                """),_display_(/*39.18*/Messages("apn.noData")),format.raw/*39.40*/("""
              """),format.raw/*40.15*/("""</div>
            </div>
            <div class="row d-none" id="apnSubscriptionInfo">
              """),_display_(/*43.16*/views/*43.21*/.html.telco.apn.APN_subscription()),format.raw/*43.55*/("""
            """),format.raw/*44.13*/("""</div>
          </div>
      </div>
      """),_display_(/*47.8*/views/*47.13*/.html.telco.apn.APN_addModal()),format.raw/*47.43*/("""
      """),_display_(/*48.8*/views/*48.13*/.html.telco.apn.APN_exportModal()),format.raw/*48.46*/("""
      """),_display_(/*49.8*/views/*49.13*/.html.telco.apn.APN_cancelModal()),format.raw/*49.46*/("""
      """),_display_(/*50.8*/views/*50.13*/.html.telco.Loading()),format.raw/*50.34*/("""
       
    """),format.raw/*52.5*/("""</div>

    """),_display_(/*54.6*/views/*54.11*/.html.telco.mainJs()),format.raw/*54.31*/("""

    """),format.raw/*56.5*/("""<script src=""""),_display_(/*56.19*/routes/*56.25*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/moment.min.js")),format.raw/*56.111*/(""""></script>

    <script type="text/javascript">
      var userId = '"""),_display_(/*59.22*/userId),format.raw/*59.28*/("""';

      $(document).ready(function () """),format.raw/*61.37*/("""{"""),format.raw/*61.38*/("""
        """),format.raw/*62.9*/("""$('#apn-fromDate').bootstrapMaterialDatePicker("""),format.raw/*62.56*/("""{"""),format.raw/*62.57*/("""
          """),format.raw/*63.11*/("""format: 'DD/MM/YYYY',
          minDate: new Date(),
          time: false
        """),format.raw/*66.9*/("""}"""),format.raw/*66.10*/(""");
        $('#apn-fromDate').bootstrapMaterialDatePicker('setDate', moment());
        $('#apn-toDate').bootstrapMaterialDatePicker("""),format.raw/*68.54*/("""{"""),format.raw/*68.55*/("""
          """),format.raw/*69.11*/("""format: 'DD/MM/YYYY',
          minDate: new Date(),
          time: false
        """),format.raw/*72.9*/("""}"""),format.raw/*72.10*/(""");
      """),format.raw/*73.7*/("""}"""),format.raw/*73.8*/(""")
      var dateNow = new Date().setHours(0, 0, 0, 0);
      var iconAction = """"),_display_(/*75.26*/routes/*75.32*/.Assets.versioned("images/telco/apn/disconnect.svg")),format.raw/*75.84*/("""";

        $(document).ready(function () """),format.raw/*77.39*/("""{"""),format.raw/*77.40*/("""
          """),format.raw/*78.11*/("""$('#exportAPNModal').on('hidden.bs.modal', function () """),format.raw/*78.66*/("""{"""),format.raw/*78.67*/("""
            """),format.raw/*79.13*/("""$('#apn-page-size').val('1000');
            $('#apn-export-table-container #file_export tbody').html('<tr><td colspan="3" class="text-center">"""),_display_(/*80.112*/Messages("apn.noDataAvailable")),format.raw/*80.143*/("""</td></tr>');
            $("#addBtnDownloadAll #btnDownloadAll").removeClass("text-danger");
            $("#addBtnDownloadAll #btnDownloadAll").addClass("text-darker");
            $("#addBtnDownloadAll #btnDownloadAll").off("click");
          """),format.raw/*84.11*/("""}"""),format.raw/*84.12*/(""");

          $('#cancelPrivateAPN').on('show.bs.modal', function () """),format.raw/*86.66*/("""{"""),format.raw/*86.67*/("""
          """),format.raw/*87.11*/("""}"""),format.raw/*87.12*/(""");
          $('#cancelPrivateAPN').on('hidden.bs.modal', function () """),format.raw/*88.68*/("""{"""),format.raw/*88.69*/("""
            """),format.raw/*89.13*/("""$('#cancelPrivateAPN #apn-name').val('');
            $('#cancelPrivateAPN #apn-ip').val('');
            $('#cancelPrivateAPN #apn-reason').val('299799');
          """),format.raw/*92.11*/("""}"""),format.raw/*92.12*/(""");     
          $('#addPrivateAPN').on('show.bs.modal', function () """),format.raw/*93.63*/("""{"""),format.raw/*93.64*/("""
            """),format.raw/*94.13*/("""const apnName = $("#addPrivateAPN #apn-name");
            apnName.empty();
            apnName.append(`<option value="" disabled selected hidden>$"""),format.raw/*96.72*/("""{"""),format.raw/*96.73*/("""Messages("apn.chooseAPN")"""),format.raw/*96.98*/("""}"""),format.raw/*96.99*/("""</option>`);

            privateAPN.forEach(function (apn) """),format.raw/*98.47*/("""{"""),format.raw/*98.48*/("""
              """),format.raw/*99.15*/("""apnName.append(
                $("<option>", """),format.raw/*100.31*/("""{"""),format.raw/*100.32*/("""
                  """),format.raw/*101.19*/("""value: apn.apn_code,
                  text: apn.apn_code,
                """),format.raw/*103.17*/("""}"""),format.raw/*103.18*/(""")
              );
            """),format.raw/*105.13*/("""}"""),format.raw/*105.14*/(""");
          """),format.raw/*106.11*/("""}"""),format.raw/*106.12*/(""");
          $('#addPrivateAPN').on('hidden.bs.modal', function () """),format.raw/*107.65*/("""{"""),format.raw/*107.66*/("""
            """),format.raw/*108.13*/("""resetForm()
          """),format.raw/*109.11*/("""}"""),format.raw/*109.12*/(""");
        """),format.raw/*110.9*/("""}"""),format.raw/*110.10*/(""");

        $(document).on('keypress', '#apn-phoneNumber-field input', function (e) """),format.raw/*112.81*/("""{"""),format.raw/*112.82*/("""
          """),format.raw/*113.11*/("""if (e.which === 13) """),format.raw/*113.31*/("""{"""),format.raw/*113.32*/("""
            """),format.raw/*114.13*/("""e.preventDefault();
            handleSearchAPN();
          """),format.raw/*116.11*/("""}"""),format.raw/*116.12*/("""
        """),format.raw/*117.9*/("""}"""),format.raw/*117.10*/(""");
    </script>


    <script src=""""),_display_(/*121.19*/routes/*121.25*/.Assets.versioned("javascripts/views/telco/apn/validate.js")),format.raw/*121.85*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*122.19*/routes/*122.25*/.Assets.versioned("javascripts/views/telco/apn/export.js")),format.raw/*122.83*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*123.19*/routes/*123.25*/.Assets.versioned("assets/plugins/input-tags/js/tagsinput.js")),format.raw/*123.87*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*124.19*/routes/*124.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*124.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*125.19*/routes/*125.25*/.Assets.versioned("javascripts/views/telco/apn/index.js")),format.raw/*125.82*/("""" type="text/javascript"></script>
  </body>
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
                  DATE: Mon Sep 22 16:32:50 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/apn/APN.scala.html
                  HASH: 8acad85d2d3807f19a298c0bd3d0fea3454143f2
                  MATRIX: 661->1|697->31|737->65|1075->97|1203->130|1230->131|1382->257|1423->278|1504->332|1519->338|1576->374|1783->555|1797->560|1843->585|1876->591|1916->604|1931->610|2006->664|2072->703|2087->709|2172->773|2238->812|2253->818|2323->867|2386->903|2401->909|2497->984|2561->1021|2576->1027|2713->1142|2778->1180|2793->1186|2872->1244|2938->1283|2953->1289|3035->1350|3101->1389|3116->1395|3178->1436|3267->1499|3281->1504|3343->1545|3376->1552|3390->1557|3442->1588|3475->1594|3571->1663|3585->1668|3638->1700|3673->1708|3907->1915|3950->1937|3993->1952|4123->2055|4137->2060|4192->2094|4233->2107|4303->2151|4317->2156|4368->2186|4402->2194|4416->2199|4470->2232|4504->2240|4518->2245|4572->2278|4606->2286|4620->2291|4662->2312|4702->2325|4741->2338|4755->2343|4796->2363|4829->2369|4870->2383|4885->2389|4993->2475|5090->2545|5117->2551|5185->2591|5214->2592|5250->2601|5325->2648|5354->2649|5393->2660|5503->2743|5532->2744|5693->2877|5722->2878|5761->2889|5871->2972|5900->2973|5936->2982|5964->2983|6071->3063|6086->3069|6159->3121|6229->3163|6258->3164|6297->3175|6380->3230|6409->3231|6450->3244|6622->3388|6675->3419|6950->3666|6979->3667|7076->3736|7105->3737|7144->3748|7173->3749|7271->3819|7300->3820|7341->3833|7535->3999|7564->4000|7662->4070|7691->4071|7732->4084|7907->4231|7936->4232|7989->4257|8018->4258|8106->4318|8135->4319|8178->4334|8253->4380|8283->4381|8331->4400|8435->4475|8465->4476|8525->4507|8555->4508|8597->4521|8627->4522|8723->4589|8753->4590|8795->4603|8846->4625|8876->4626|8915->4637|8945->4638|9058->4722|9088->4723|9128->4734|9177->4754|9207->4755|9249->4768|9339->4829|9369->4830|9406->4839|9436->4840|9501->4877|9517->4883|9599->4943|9680->4996|9696->5002|9776->5060|9857->5113|9873->5119|9957->5181|10038->5234|10054->5240|10135->5299|10216->5352|10232->5358|10311->5415
                  LINES: 24->1|25->2|26->3|31->4|36->4|37->5|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|51->19|51->19|52->20|52->20|52->20|53->21|53->21|53->21|54->22|54->22|54->22|55->23|55->23|55->23|56->24|56->24|56->24|59->27|59->27|59->27|61->29|61->29|61->29|63->31|65->33|65->33|65->33|67->35|71->39|71->39|72->40|75->43|75->43|75->43|76->44|79->47|79->47|79->47|80->48|80->48|80->48|81->49|81->49|81->49|82->50|82->50|82->50|84->52|86->54|86->54|86->54|88->56|88->56|88->56|88->56|91->59|91->59|93->61|93->61|94->62|94->62|94->62|95->63|98->66|98->66|100->68|100->68|101->69|104->72|104->72|105->73|105->73|107->75|107->75|107->75|109->77|109->77|110->78|110->78|110->78|111->79|112->80|112->80|116->84|116->84|118->86|118->86|119->87|119->87|120->88|120->88|121->89|124->92|124->92|125->93|125->93|126->94|128->96|128->96|128->96|128->96|130->98|130->98|131->99|132->100|132->100|133->101|135->103|135->103|137->105|137->105|138->106|138->106|139->107|139->107|140->108|141->109|141->109|142->110|142->110|144->112|144->112|145->113|145->113|145->113|146->114|148->116|148->116|149->117|149->117|153->121|153->121|153->121|154->122|154->122|154->122|155->123|155->123|155->123|156->124|156->124|156->124|157->125|157->125|157->125
                  -- GENERATED --
              */
          