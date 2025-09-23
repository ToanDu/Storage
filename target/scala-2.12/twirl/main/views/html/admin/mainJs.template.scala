
package views.html.admin

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

object mainJs extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

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
              """),_display_(/*15.16*/if(flash.containsKey("success"))/*15.48*/ {_display_(Seq[Any](format.raw/*15.50*/("""
              """),format.raw/*16.15*/("""showNotification('success','"""),_display_(/*16.44*/flash/*16.49*/.get("success")),format.raw/*16.64*/("""');
              """)))}),format.raw/*17.16*/("""
              """),_display_(/*18.16*/if(flash.containsKey("failed"))/*18.47*/ {_display_(Seq[Any](format.raw/*18.49*/("""
              """),format.raw/*19.15*/("""showNotification('danger','"""),_display_(/*19.43*/flash/*19.48*/.get("failed")),format.raw/*19.62*/("""');
              """)))}),format.raw/*20.16*/("""

              """),format.raw/*22.15*/("""const element = document.querySelector('.wrapper');
              $(".mobile-toggle-menu").on("click", function() """),format.raw/*23.63*/("""{"""),format.raw/*23.64*/("""
                """),format.raw/*24.17*/("""if(!element.classList.contains("toggled"))"""),format.raw/*24.59*/("""{"""),format.raw/*24.60*/("""
                  """),format.raw/*25.19*/("""$(".wrapper").addClass("toggled");
                  $("#arrowMenu").show();
                """),format.raw/*27.17*/("""}"""),format.raw/*27.18*/("""
              """),format.raw/*28.15*/("""}"""),format.raw/*28.16*/(""");
              $("#arrowMenu").on("click", function() """),format.raw/*29.54*/("""{"""),format.raw/*29.55*/("""
                """),format.raw/*30.17*/("""if(element.classList.contains("toggled"))"""),format.raw/*30.58*/("""{"""),format.raw/*30.59*/("""
                  """),format.raw/*31.19*/("""$(".wrapper").removeClass("toggled");
                  $("#arrowMenu").hide();
                """),format.raw/*33.17*/("""}"""),format.raw/*33.18*/("""
              """),format.raw/*34.15*/("""}"""),format.raw/*34.16*/(""");
            """),format.raw/*35.13*/("""}"""),format.raw/*35.14*/(""");
</script>

<script src=""""),_display_(/*38.15*/routes/*38.21*/.Assets.versioned("assets/plugins/datatable/js/jquery.dataTables.min.js")),format.raw/*38.94*/(""""></script>

<script src=""""),_display_(/*40.15*/routes/*40.21*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/moment.min.js")),format.raw/*40.107*/(""""></script>
<script src=""""),_display_(/*41.15*/routes/*41.21*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.min.js")),format.raw/*41.134*/(""""></script>

<script src=""""),_display_(/*43.15*/routes/*43.21*/.Assets.versioned("assets/js/chosen.jquery.min.js")),format.raw/*43.72*/(""""></script>

<script src=""""),_display_(/*45.15*/routes/*45.21*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*45.75*/(""""></script>
  <!--plugins-->
<script src=""""),_display_(/*47.15*/routes/*47.21*/.Assets.versioned("assets/plugins/simplebar/js/simplebar.min.js")),format.raw/*47.86*/(""""></script>
<script src=""""),_display_(/*48.15*/routes/*48.21*/.Assets.versioned("assets/plugins/metismenu/js/metisMenu.min.js")),format.raw/*48.86*/(""""></script>
<script src=""""),_display_(/*49.15*/routes/*49.21*/.Assets.versioned("assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js")),format.raw/*49.98*/(""""></script>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:39 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/admin/mainJs.scala.html
                  HASH: dabc5a33c82487540daf9ef7080bea933cf27302
                  MATRIX: 1037->0|1100->37|1114->43|1160->69|1235->118|1249->124|1299->154|1351->180|1365->186|1439->240|1538->313|1552->319|1616->363|1694->415|1708->421|1795->488|1847->514|1861->520|1954->593|2006->619|2020->625|2123->707|2177->734|2192->740|2264->791|2340->840|2355->846|2428->898|2563->1005|2592->1006|2635->1022|2676->1054|2716->1056|2759->1071|2815->1100|2829->1105|2865->1120|2915->1139|2958->1155|2998->1186|3038->1188|3081->1203|3136->1231|3150->1236|3185->1250|3235->1269|3279->1285|3421->1399|3450->1400|3495->1417|3565->1459|3594->1460|3641->1479|3762->1572|3791->1573|3834->1588|3863->1589|3947->1645|3976->1646|4021->1663|4090->1704|4119->1705|4166->1724|4290->1820|4319->1821|4362->1836|4391->1837|4434->1852|4463->1853|4518->1881|4533->1887|4627->1960|4681->1987|4696->1993|4804->2079|4857->2105|4872->2111|5007->2224|5061->2251|5076->2257|5148->2308|5202->2335|5217->2341|5292->2395|5362->2438|5377->2444|5463->2509|5516->2535|5531->2541|5617->2606|5670->2632|5685->2638|5783->2715
                  LINES: 33->1|33->1|33->1|33->1|34->2|34->2|34->2|35->3|35->3|35->3|37->5|37->5|37->5|39->7|39->7|39->7|40->8|40->8|40->8|41->9|41->9|41->9|43->11|43->11|43->11|44->12|44->12|44->12|46->14|46->14|47->15|47->15|47->15|48->16|48->16|48->16|48->16|49->17|50->18|50->18|50->18|51->19|51->19|51->19|51->19|52->20|54->22|55->23|55->23|56->24|56->24|56->24|57->25|59->27|59->27|60->28|60->28|61->29|61->29|62->30|62->30|62->30|63->31|65->33|65->33|66->34|66->34|67->35|67->35|70->38|70->38|70->38|72->40|72->40|72->40|73->41|73->41|73->41|75->43|75->43|75->43|77->45|77->45|77->45|79->47|79->47|79->47|80->48|80->48|80->48|81->49|81->49|81->49
                  -- GENERATED --
              */
          