
package views.html.iot.waterClock

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
<script src=""""),_display_(/*56.15*/routes/*56.21*/.Assets.versioned("assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js")),format.raw/*56.98*/(""""></script>"""))
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/waterClock/Main_js.scala.html
                  HASH: 249c700b279a469f1d6da79b478db367da8a84b0
                  MATRIX: 1047->0|1110->37|1124->43|1170->69|1245->118|1259->124|1309->154|1361->180|1375->186|1449->240|1548->313|1562->319|1626->363|1706->417|1720->423|1807->490|1859->516|1873->522|1966->595|2018->621|2032->627|2135->709|2189->736|2204->742|2276->793|2352->842|2367->848|2440->900|2575->1007|2604->1008|2649->1026|2690->1058|2730->1060|2775->1077|2831->1106|2845->1111|2881->1126|2933->1147|2978->1165|3018->1196|3058->1198|3103->1215|3158->1243|3172->1248|3207->1262|3259->1283|3305->1301|3449->1417|3478->1418|3527->1439|3597->1481|3626->1482|3679->1507|3810->1610|3839->1611|3884->1628|3913->1629|3999->1687|4028->1688|4077->1709|4146->1750|4175->1751|4228->1776|4362->1882|4391->1883|4436->1900|4465->1901|4508->1916|4537->1917|4612->1964|4641->1965|4690->1986|4762->2030|4791->2031|4833->2045|4880->2065|4895->2071|4959->2114|5021->2149|5036->2155|5098->2196|5160->2231|5175->2237|5237->2278|5292->2306|5307->2312|5401->2385|5455->2412|5470->2418|5545->2472|5622->2522|5637->2528|5709->2579|5763->2606|5778->2612|5853->2666|5925->2711|5940->2717|6026->2782|6079->2808|6094->2814|6180->2879|6233->2905|6248->2911|6346->2988
                  LINES: 33->1|33->1|33->1|33->1|34->2|34->2|34->2|35->3|35->3|35->3|37->5|37->5|37->5|39->7|39->7|39->7|40->8|40->8|40->8|41->9|41->9|41->9|43->11|43->11|43->11|44->12|44->12|44->12|46->14|46->14|47->15|47->15|47->15|48->16|48->16|48->16|48->16|49->17|50->18|50->18|50->18|51->19|51->19|51->19|51->19|52->20|54->22|55->23|55->23|56->24|56->24|56->24|57->25|59->27|59->27|60->28|60->28|61->29|61->29|62->30|62->30|62->30|63->31|65->33|65->33|66->34|66->34|67->35|67->35|69->37|69->37|70->38|71->39|71->39|73->41|73->41|73->41|73->41|74->42|74->42|74->42|75->43|75->43|75->43|78->46|78->46|78->46|80->48|80->48|80->48|82->50|82->50|82->50|84->52|84->52|84->52|86->54|86->54|86->54|87->55|87->55|87->55|88->56|88->56|88->56
                  -- GENERATED --
              */
          