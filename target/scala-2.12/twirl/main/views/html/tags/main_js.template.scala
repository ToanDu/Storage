
package views.html.tags

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

object main_js extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<script type="text/javascript" src=""""),_display_(/*1.38*/routes/*1.44*/.JsController.jsMessages()),format.raw/*1.70*/(""""></script>
<script type="text/javascript" src=""""),_display_(/*2.38*/routes/*2.44*/.JsController.javascriptRoutes),format.raw/*2.74*/(""""></script>

<script src=""""),_display_(/*4.15*/routes/*4.21*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*4.75*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*5.15*/routes/*5.21*/.Assets.versioned("javascripts/js/core/popper.min.js")),format.raw/*5.75*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*6.15*/routes/*6.21*/.Assets.versioned("javascripts/js/core/bootstrap-material-design.min.js")),format.raw/*6.94*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*7.15*/routes/*7.21*/.Assets.versioned("javascripts/js/plugins/perfect-scrollbar.jquery.min.js")),format.raw/*7.96*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*8.15*/routes/*8.21*/.Assets.versioned("javascripts/js/plugins/moment.min.js")),format.raw/*8.78*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*9.15*/routes/*9.21*/.Assets.versioned("javascripts/js/plugins/sweetalert2.js")),format.raw/*9.79*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*10.15*/routes/*10.21*/.Assets.versioned("javascripts/js/plugins/jquery.validate.min.js")),format.raw/*10.87*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*11.15*/routes/*11.21*/.Assets.versioned("javascripts/js/plugins/jquery.bootstrap-wizard.js")),format.raw/*11.91*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*12.15*/routes/*12.21*/.Assets.versioned("javascripts/js/plugins/bootstrap-selectpicker.js")),format.raw/*12.90*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*13.15*/routes/*13.21*/.Assets.versioned("javascripts/js/plugins/bootstrap-datetimepicker.min.js")),format.raw/*13.96*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*14.15*/routes/*14.21*/.Assets.versioned("javascripts/js/plugins/jquery.dataTables.min.js")),format.raw/*14.89*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*15.15*/routes/*15.21*/.Assets.versioned("javascripts/js/plugins/bootstrap-tagsinput.js")),format.raw/*15.87*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*16.15*/routes/*16.21*/.Assets.versioned("javascripts/js/plugins/jasny-bootstrap.min.js")),format.raw/*16.87*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*17.15*/routes/*17.21*/.Assets.versioned("javascripts/js/plugins/fullcalendar.min.js")),format.raw/*17.84*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*18.15*/routes/*18.21*/.Assets.versioned("javascripts/js/plugins/jquery-jvectormap.js")),format.raw/*18.85*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*19.15*/routes/*19.21*/.Assets.versioned("javascripts/js/plugins/nouislider.min.js")),format.raw/*19.82*/("""" type="text/javascript"></script>
"""),format.raw/*20.89*/("""
"""),format.raw/*21.1*/("""<script src=""""),_display_(/*21.15*/routes/*21.21*/.Assets.versioned("javascripts/js/plugins/arrive.min.js")),format.raw/*21.78*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*22.15*/routes/*22.21*/.Assets.versioned("javascripts/js/plugins/chartist.min.js")),format.raw/*22.80*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*23.15*/routes/*23.21*/.Assets.versioned("javascripts/js/plugins/bootstrap-notify.js")),format.raw/*23.84*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*24.15*/routes/*24.21*/.Assets.versioned("javascripts/js/material-dashboard.js")),format.raw/*24.78*/("""" type="text/javascript"></script>

<script type="text/javascript">
            $(document).ready(function()"""),format.raw/*27.41*/("""{"""),format.raw/*27.42*/("""
                """),_display_(/*28.18*/if(flash.containsKey("success"))/*28.50*/ {_display_(Seq[Any](format.raw/*28.52*/("""
                """),format.raw/*29.17*/("""showNotification('top','center','success','"""),_display_(/*29.61*/flash/*29.66*/.get("success")),format.raw/*29.81*/("""','notification');
                """)))}),format.raw/*30.18*/("""
                """),_display_(/*31.18*/if(flash.containsKey("failed"))/*31.49*/ {_display_(Seq[Any](format.raw/*31.51*/("""
                """),format.raw/*32.17*/("""showNotification('top','center','danger','"""),_display_(/*32.60*/flash/*32.65*/.get("failed")),format.raw/*32.79*/("""','notification');
                """)))}),format.raw/*33.18*/("""
            """),format.raw/*34.13*/("""}"""),format.raw/*34.14*/(""");
</script>
<script src=""""),_display_(/*36.15*/routes/*36.21*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*36.73*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*37.15*/routes/*37.21*/.Assets.versioned("javascripts/SearchJs.js")),format.raw/*37.65*/("""" type="text/javascript"></script>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:49 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/tags/main_js.scala.html
                  HASH: b2b085ac3b5fc8bbdaeea654aef016f1ad1084c6
                  MATRIX: 1037->0|1100->37|1114->43|1160->69|1235->118|1249->124|1299->154|1352->181|1366->187|1440->241|1515->290|1529->296|1603->350|1678->399|1692->405|1785->478|1860->527|1874->533|1969->608|2044->657|2058->663|2135->720|2210->769|2224->775|2302->833|2378->882|2393->888|2480->954|2556->1003|2571->1009|2662->1079|2738->1128|2753->1134|2843->1203|2919->1252|2934->1258|3030->1333|3106->1382|3121->1388|3210->1456|3286->1505|3301->1511|3388->1577|3464->1626|3479->1632|3566->1698|3642->1747|3657->1753|3741->1816|3817->1865|3832->1871|3917->1935|3993->1984|4008->1990|4090->2051|4153->2174|4181->2175|4222->2189|4237->2195|4315->2252|4391->2301|4406->2307|4486->2366|4562->2415|4577->2421|4661->2484|4737->2533|4752->2539|4830->2596|4966->2704|4995->2705|5040->2723|5081->2755|5121->2757|5166->2774|5237->2818|5251->2823|5287->2838|5354->2874|5399->2892|5439->2923|5479->2925|5524->2942|5594->2985|5608->2990|5643->3004|5710->3040|5751->3053|5780->3054|5834->3081|5849->3087|5922->3139|5998->3188|6013->3194|6078->3238
                  LINES: 33->1|33->1|33->1|33->1|34->2|34->2|34->2|36->4|36->4|36->4|37->5|37->5|37->5|38->6|38->6|38->6|39->7|39->7|39->7|40->8|40->8|40->8|41->9|41->9|41->9|42->10|42->10|42->10|43->11|43->11|43->11|44->12|44->12|44->12|45->13|45->13|45->13|46->14|46->14|46->14|47->15|47->15|47->15|48->16|48->16|48->16|49->17|49->17|49->17|50->18|50->18|50->18|51->19|51->19|51->19|52->20|53->21|53->21|53->21|53->21|54->22|54->22|54->22|55->23|55->23|55->23|56->24|56->24|56->24|59->27|59->27|60->28|60->28|60->28|61->29|61->29|61->29|61->29|62->30|63->31|63->31|63->31|64->32|64->32|64->32|64->32|65->33|66->34|66->34|68->36|68->36|68->36|69->37|69->37|69->37
                  -- GENERATED --
              */
          