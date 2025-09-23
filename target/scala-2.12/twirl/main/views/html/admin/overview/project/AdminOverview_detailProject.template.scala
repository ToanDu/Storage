
package views.html.admin.overview.project

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

object AdminOverview_detailProject extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, projectId: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.39*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>"""),_display_(/*9.17*/Messages("Admin Overview")),format.raw/*9.43*/("""</title>
        <link rel="icon" type="image/png" href=""""),_display_(/*10.50*/routes/*10.56*/.Assets.versioned("images/logo.jpg")),format.raw/*10.92*/("""">

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        """),_display_(/*15.10*/views/*15.15*/.html.iot.tags.Main_css()),format.raw/*15.40*/("""

        """),format.raw/*17.9*/("""<link href=""""),_display_(/*17.22*/routes/*17.28*/.Assets.versioned("stylesheets/views/admin/multiselect.css")),format.raw/*17.88*/("""" rel="stylesheet" />
        """),format.raw/*18.100*/("""
        """),format.raw/*19.9*/("""<link href='"""),_display_(/*19.22*/routes/*19.28*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*19.77*/("""' type='text/css'>
        <link href=""""),_display_(/*20.22*/routes/*20.28*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*20.103*/("""" rel="stylesheet">
        <link href=""""),_display_(/*21.22*/routes/*21.28*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*21.143*/("""" rel="stylesheet" >

        <style>
                .btn-flat """),format.raw/*24.27*/("""{"""),format.raw/*24.28*/("""
                    """),format.raw/*25.21*/("""color: white;
                """),format.raw/*26.17*/("""}"""),format.raw/*26.18*/("""
        """),format.raw/*27.9*/("""</style>

    </head>
    <body class="bg-theme">
        """),_display_(/*31.10*/views/*31.15*/.html.admin.navbar()),format.raw/*31.35*/("""

        """),_display_(/*33.10*/views/*33.15*/.html.admin.header(currentUser)),format.raw/*33.46*/("""

        """),format.raw/*35.9*/("""<div class="page-wrapper pb-5" style="background-color: white;">
            <div class="page-content">

                <div class="col-md-12">
                    <div class="row mb-4">
                        <div class="breadcrumb-title pe-3" style="font-weight: 500;" id="nameProject">"""),_display_(/*40.104*/Messages("Tổng quan dự án")),format.raw/*40.131*/("""</div>
                    </div>
                </div>

                """),_display_(/*44.18*/views/*44.23*/.html.admin.overview.project.AdminOverview_detailProject_total()),format.raw/*44.87*/("""

                """),format.raw/*46.17*/("""<div class="col-md-12 mt-4">
                    <div class="row mb-4">
                        <div class="breadcrumb-title pe-3" style="font-weight: 500;">"""),_display_(/*48.87*/Messages("Phân bổ thiết bị")),format.raw/*48.115*/("""</div>
                    </div>
                </div>

                <div class="col-md-12 mt-4">
                    <div class="row mb-4">
                        <div id="chartRadialDevice"></div>
                    </div>
                    <div class="row mb-4">
                        <div class="col col-lg-8 mx-auto">
                            <div class="row"  id="labelsChart">

                            </div>

                        </div>
                    </div>
                </div>

            </div>
        </div>
            <!--  END OF PAPER WRAP -->
        """),_display_(/*69.10*/views/*69.15*/.html.Loading()),format.raw/*69.30*/("""

    """),format.raw/*71.5*/("""</body>

    """),_display_(/*73.6*/views/*73.11*/.html.admin.mainJs()),format.raw/*73.31*/("""
    """),format.raw/*74.5*/("""<script src=""""),_display_(/*74.19*/routes/*74.25*/.Assets.versioned("assets/plugins/apexcharts-bundle/js/apexcharts.min.js")),format.raw/*74.99*/("""" type="text/javascript"></script>

    <script>
            var projectId = '"""),_display_(/*77.31*/projectId),format.raw/*77.40*/("""';

            $(document).ready(function () """),format.raw/*79.43*/("""{"""),format.raw/*79.44*/("""
                """),format.raw/*80.17*/("""$("#menu-adminOverview").addClass("mm-active");
                $("#menu").metisMenu();

                $("#test").CreateMultiCheckBox("""),format.raw/*83.48*/("""{"""),format.raw/*83.49*/(""" """),format.raw/*83.50*/("""width: '230px', defaultText : 'Theo lĩnh vực', height:'250px' """),format.raw/*83.112*/("""}"""),format.raw/*83.113*/(""");

                $('#date_timepicker_start').bootstrapMaterialDatePicker("""),format.raw/*85.73*/("""{"""),format.raw/*85.74*/("""
                    """),format.raw/*86.21*/("""format: 'DD-MM-YYYY',
                    time: false
                """),format.raw/*88.17*/("""}"""),format.raw/*88.18*/(""");
                $('#date_timepicker_end').bootstrapMaterialDatePicker("""),format.raw/*89.71*/("""{"""),format.raw/*89.72*/("""
                    """),format.raw/*90.21*/("""format: 'DD-MM-YYYY',
                    time: false
                """),format.raw/*92.17*/("""}"""),format.raw/*92.18*/(""");
            """),format.raw/*93.13*/("""}"""),format.raw/*93.14*/(""");

            var iconDefault = """"),_display_(/*95.33*/routes/*95.39*/.Assets.versioned("images/login/logo.svg")),format.raw/*95.81*/("""";
    </script>
    <script src=""""),_display_(/*97.19*/routes/*97.25*/.Assets.versioned("javascripts/views/admin/adminOverview/multiselect.js")),format.raw/*97.98*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*99.19*/routes/*99.25*/.Assets.versioned("javascripts/views/admin/adminOverview/project/AdminOverviewProject.js")),format.raw/*99.115*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*100.19*/routes/*100.25*/.Assets.versioned("javascripts/views/admin/adminOverview/project/AdminOverviewProject_chart.js")),format.raw/*100.121*/("""" type="text/javascript"></script>

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
                  DATE: Mon Sep 22 16:32:40 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/admin/overview/project/AdminOverview_detailProject.scala.html
                  HASH: c3bc650866d10472e9b9dec2aa4471fb1ec599fd
                  MATRIX: 674->1|697->18|1061->52|1193->89|1220->90|1402->246|1448->272|1533->330|1548->336|1605->372|1825->565|1839->570|1885->595|1922->605|1962->618|1977->624|2058->684|2117->805|2153->814|2193->827|2208->833|2278->882|2345->922|2360->928|2457->1003|2525->1044|2540->1050|2677->1165|2769->1229|2798->1230|2847->1251|2905->1281|2934->1282|2970->1291|3056->1350|3070->1355|3111->1375|3149->1386|3163->1391|3215->1422|3252->1432|3571->1723|3620->1750|3722->1825|3736->1830|3821->1894|3867->1912|4052->2070|4102->2098|4729->2698|4743->2703|4779->2718|4812->2724|4852->2738|4866->2743|4907->2763|4939->2768|4980->2782|4995->2788|5090->2862|5196->2941|5226->2950|5300->2996|5329->2997|5374->3014|5538->3150|5567->3151|5596->3152|5687->3214|5717->3215|5821->3291|5850->3292|5899->3313|5997->3383|6026->3384|6127->3457|6156->3458|6205->3479|6303->3549|6332->3550|6375->3565|6404->3566|6467->3602|6482->3608|6545->3650|6607->3685|6622->3691|6716->3764|6797->3818|6812->3824|6924->3914|7005->3967|7021->3973|7140->4069
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|51->19|51->19|51->19|51->19|52->20|52->20|52->20|53->21|53->21|53->21|56->24|56->24|57->25|58->26|58->26|59->27|63->31|63->31|63->31|65->33|65->33|65->33|67->35|72->40|72->40|76->44|76->44|76->44|78->46|80->48|80->48|101->69|101->69|101->69|103->71|105->73|105->73|105->73|106->74|106->74|106->74|106->74|109->77|109->77|111->79|111->79|112->80|115->83|115->83|115->83|115->83|115->83|117->85|117->85|118->86|120->88|120->88|121->89|121->89|122->90|124->92|124->92|125->93|125->93|127->95|127->95|127->95|129->97|129->97|129->97|131->99|131->99|131->99|132->100|132->100|132->100
                  -- GENERATED --
              */
          