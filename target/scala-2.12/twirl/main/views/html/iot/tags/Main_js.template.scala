
package views.html.iot.tags

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

object Main_js extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<script type="text/javascript" src=""""),_display_(/*1.38*/routes/*1.44*/.JsController.jsMessages()),format.raw/*1.70*/(""""></script>
<script type="text/javascript" src=""""),_display_(/*2.38*/routes/*2.44*/.JsController.javascriptRoutes),format.raw/*2.74*/(""""></script>
<script src=""""),_display_(/*3.15*/routes/*3.21*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*3.75*/("""" type="text/javascript"></script>

<script type="text/javascript" src=""""),_display_(/*5.38*/routes/*5.44*/.Assets.versioned("assets/js/jquery.min.js")),format.raw/*5.88*/(""""></script>
    <!--notification js -->
<script src=""""),_display_(/*7.15*/routes/*7.21*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*7.88*/(""""></script>
<script src=""""),_display_(/*8.15*/routes/*8.21*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*8.94*/(""""></script>
<script src=""""),_display_(/*9.15*/routes/*9.21*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*9.103*/(""""></script>

<script src=""""),_display_(/*11.15*/routes/*11.21*/.Assets.versioned("javascripts/views/ErrorCode.js")),format.raw/*11.72*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*12.15*/routes/*12.21*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*12.73*/("""" type="text/javascript"></script>
<script type="text/javascript">
            $(document).ready(function()"""),format.raw/*14.41*/("""{"""),format.raw/*14.42*/("""
                """),_display_(/*15.18*/if(flash.containsKey("success"))/*15.50*/ {_display_(Seq[Any](format.raw/*15.52*/("""
                """),format.raw/*16.17*/("""showNotification('success','"""),_display_(/*16.46*/flash/*16.51*/.get("success")),format.raw/*16.66*/("""');
                """)))}),format.raw/*17.18*/("""
                """),_display_(/*18.18*/if(flash.containsKey("failed"))/*18.49*/ {_display_(Seq[Any](format.raw/*18.51*/("""
                """),format.raw/*19.17*/("""showNotification('danger','"""),_display_(/*19.45*/flash/*19.50*/.get("failed")),format.raw/*19.64*/("""');
                """)))}),format.raw/*20.18*/("""

                """),format.raw/*22.17*/("""const element = document.querySelector('.wrapper');
                $(".mobile-toggle-menu").on("click", function() """),format.raw/*23.65*/("""{"""),format.raw/*23.66*/("""
                    """),format.raw/*24.21*/("""if(!element.classList.contains("toggled"))"""),format.raw/*24.63*/("""{"""),format.raw/*24.64*/("""
                        """),format.raw/*25.25*/("""$(".wrapper").addClass("toggled");
                        $("#arrowMenu").show();
                    """),format.raw/*27.21*/("""}"""),format.raw/*27.22*/("""
                """),format.raw/*28.17*/("""}"""),format.raw/*28.18*/(""");
                $("#arrowMenu").on("click", function() """),format.raw/*29.56*/("""{"""),format.raw/*29.57*/("""
                    """),format.raw/*30.21*/("""if(element.classList.contains("toggled"))"""),format.raw/*30.62*/("""{"""),format.raw/*30.63*/("""
                        """),format.raw/*31.25*/("""$(".wrapper").removeClass("toggled");
                        $("#arrowMenu").hide();
                    """),format.raw/*33.21*/("""}"""),format.raw/*33.22*/("""
                """),format.raw/*34.17*/("""}"""),format.raw/*34.18*/(""");
            """),format.raw/*35.13*/("""}"""),format.raw/*35.14*/(""");

                function commingSoonNoti() """),format.raw/*37.44*/("""{"""),format.raw/*37.45*/("""
                    """),format.raw/*38.21*/("""info_noti('Comming soon!');
                """),format.raw/*39.17*/("""}"""),format.raw/*39.18*/("""

            """),format.raw/*41.13*/("""var imgProject0 = """"),_display_(/*41.33*/routes/*41.39*/.Assets.versioned("images/iotplatform.png")),format.raw/*41.82*/("""";
            var imgProject1 = """"),_display_(/*42.33*/routes/*42.39*/.Assets.versioned("images/smarthome.jpg")),format.raw/*42.80*/("""";
            var imgProject2 = """"),_display_(/*43.33*/routes/*43.39*/.Assets.versioned("images/smartfarm.jpg")),format.raw/*43.80*/("""";
</script>

<script src=""""),_display_(/*46.15*/routes/*46.21*/.Assets.versioned("assets/plugins/datatable/js/jquery.dataTables.min.js")),format.raw/*46.94*/(""""></script>

<script src=""""),_display_(/*48.15*/routes/*48.21*/.Assets.versioned("javascripts/plugins/moment.min.js")),format.raw/*48.75*/("""" type="text/javascript"></script>

<script src=""""),_display_(/*50.15*/routes/*50.21*/.Assets.versioned("assets/js/chosen.jquery.min.js")),format.raw/*50.72*/(""""></script>

<script src=""""),_display_(/*52.15*/routes/*52.21*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*52.75*/(""""></script>
    <!--plugins-->
<script src=""""),_display_(/*54.15*/routes/*54.21*/.Assets.versioned("assets/plugins/simplebar/js/simplebar.min.js")),format.raw/*54.86*/(""""></script>
<script src=""""),_display_(/*55.15*/routes/*55.21*/.Assets.versioned("assets/plugins/metismenu/js/metisMenu.min.js")),format.raw/*55.86*/(""""></script>
<script src=""""),_display_(/*56.15*/routes/*56.21*/.Assets.versioned("assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js")),format.raw/*56.98*/(""""></script>

<script type="text/javascript" src=""""),_display_(/*58.38*/routes/*58.44*/.Assets.versioned("javascripts/views/project/headerProject.js")),format.raw/*58.107*/(""""></script>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:46 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/tags/Main_js.scala.html
                  HASH: 72df7307f8e641f22726866ffa5ce61902ab4a79
                  MATRIX: 1041->0|1104->37|1118->43|1164->69|1239->118|1253->124|1303->154|1355->180|1369->186|1443->240|1542->313|1556->319|1620->363|1700->417|1714->423|1801->490|1853->516|1867->522|1960->595|2012->621|2026->627|2129->709|2183->736|2198->742|2270->793|2346->842|2361->848|2434->900|2569->1007|2598->1008|2643->1026|2684->1058|2724->1060|2769->1077|2825->1106|2839->1111|2875->1126|2927->1147|2972->1165|3012->1196|3052->1198|3097->1215|3152->1243|3166->1248|3201->1262|3253->1283|3299->1301|3443->1417|3472->1418|3521->1439|3591->1481|3620->1482|3673->1507|3804->1610|3833->1611|3878->1628|3907->1629|3993->1687|4022->1688|4071->1709|4140->1750|4169->1751|4222->1776|4356->1882|4385->1883|4430->1900|4459->1901|4502->1916|4531->1917|4606->1964|4635->1965|4684->1986|4756->2030|4785->2031|4827->2045|4874->2065|4889->2071|4953->2114|5015->2149|5030->2155|5092->2196|5154->2231|5169->2237|5231->2278|5286->2306|5301->2312|5395->2385|5449->2412|5464->2418|5539->2472|5616->2522|5631->2528|5703->2579|5757->2606|5772->2612|5847->2666|5919->2711|5934->2717|6020->2782|6073->2808|6088->2814|6174->2879|6227->2905|6242->2911|6340->2988|6417->3038|6432->3044|6517->3107
                  LINES: 33->1|33->1|33->1|33->1|34->2|34->2|34->2|35->3|35->3|35->3|37->5|37->5|37->5|39->7|39->7|39->7|40->8|40->8|40->8|41->9|41->9|41->9|43->11|43->11|43->11|44->12|44->12|44->12|46->14|46->14|47->15|47->15|47->15|48->16|48->16|48->16|48->16|49->17|50->18|50->18|50->18|51->19|51->19|51->19|51->19|52->20|54->22|55->23|55->23|56->24|56->24|56->24|57->25|59->27|59->27|60->28|60->28|61->29|61->29|62->30|62->30|62->30|63->31|65->33|65->33|66->34|66->34|67->35|67->35|69->37|69->37|70->38|71->39|71->39|73->41|73->41|73->41|73->41|74->42|74->42|74->42|75->43|75->43|75->43|78->46|78->46|78->46|80->48|80->48|80->48|82->50|82->50|82->50|84->52|84->52|84->52|86->54|86->54|86->54|87->55|87->55|87->55|88->56|88->56|88->56|90->58|90->58|90->58
                  -- GENERATED --
              */
          