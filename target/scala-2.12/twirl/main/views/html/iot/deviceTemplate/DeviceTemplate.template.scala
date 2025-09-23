
package views.html.iot.deviceTemplate

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

object DeviceTemplate extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, projectId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.38*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("Device Template")),format.raw/*9.40*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*17.78*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*21.6*/views/*21.11*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*21.54*/("""

    """),_display_(/*23.6*/views/*23.11*/.html.iot.tags.Header(currentUser)),format.raw/*23.45*/("""

    """),format.raw/*25.5*/("""<div class="page-wrapper">
      <div class="page-content">

        <div class="row">
          <div class="col-md-12">
            """),format.raw/*30.103*/("""
              """),format.raw/*31.203*/("""
            """),format.raw/*32.23*/("""
            """),format.raw/*33.75*/("""
              """),format.raw/*34.42*/("""
                """),format.raw/*35.75*/("""
                """),format.raw/*36.80*/("""
                """),format.raw/*37.87*/("""
                """),format.raw/*38.80*/("""
                """),format.raw/*39.81*/("""
              """),format.raw/*40.25*/("""
            """),format.raw/*41.23*/("""

            """),format.raw/*43.13*/("""<div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
              <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; font-weight: normal;">"""),_display_(/*44.158*/Messages("Thiết bị mẫu của tôi")),format.raw/*44.190*/("""</span>
            </div>

            <div class="card">
              <div class="card-body" style="border: 1px solid #858687;">
                <div id="tabListTemplate" class="body-nest"></div>
              </div>
            </div>
          </div>

        </div>
      </div>
    </div>

    """),_display_(/*58.6*/views/*58.11*/.html.iot.deviceTemplate.DeviceTemplate_create()),format.raw/*58.59*/("""
    """),_display_(/*59.6*/views/*59.11*/.html.iot.deviceTemplate.DeviceTemplate_del()),format.raw/*59.56*/("""
    """),_display_(/*60.6*/views/*60.11*/.html.iot.deviceTemplate.DeviceTemplate_createTem()),format.raw/*60.62*/("""
    """),_display_(/*61.6*/views/*61.11*/.html.iot.deviceTemplate.DeviceTemplate_detailAttr()),format.raw/*61.63*/("""


    """),_display_(/*64.6*/views/*64.11*/.html.iot.deviceTemplate.AttributeTemplate_attr_add()),format.raw/*64.64*/("""
    """),_display_(/*65.6*/views/*65.11*/.html.iot.deviceTemplate.AttributeTemplate_attr_edit()),format.raw/*65.65*/("""
    """),_display_(/*66.6*/views/*66.11*/.html.iot.deviceTemplate.AttributeTemplate_attr_del()),format.raw/*66.64*/("""

    """),_display_(/*68.6*/views/*68.11*/.html.Loading()),format.raw/*68.26*/("""
  """),format.raw/*69.3*/("""</body>

  """),_display_(/*71.4*/views/*71.9*/.html.iot.tags.Main_js()),format.raw/*71.33*/("""

  """),format.raw/*73.3*/("""<script>
    var projectId = '"""),_display_(/*74.23*/projectId),format.raw/*74.32*/("""';

    var iconEdit = """"),_display_(/*76.22*/routes/*76.28*/.Assets.versioned("images/icon/edit.png")),format.raw/*76.69*/("""";
    var iconDelete = """"),_display_(/*77.24*/routes/*77.30*/.Assets.versioned("images/icon/delete.png")),format.raw/*77.73*/("""";

    var smartwater = """"),_display_(/*79.24*/routes/*79.30*/.Assets.versioned("images/smartwater.jpg")),format.raw/*79.72*/("""";

          $(document).ready(function () """),format.raw/*81.41*/("""{"""),format.raw/*81.42*/("""
            """),format.raw/*82.13*/("""$("#menu-deviceTemplate").addClass("mm-active");

            $("#menu").metisMenu();
            for (var e = window.location, o = $(".metismenu li a").filter(function() """),format.raw/*85.86*/("""{"""),format.raw/*85.87*/("""
              """),format.raw/*86.15*/("""return this.href == e
            """),format.raw/*87.13*/("""}"""),format.raw/*87.14*/(""").addClass("").parent().addClass("mm-active"); o.is("li");) o = o.parent("").addClass("mm-show").parent("").addClass("mm-active");
          """),format.raw/*88.11*/("""}"""),format.raw/*88.12*/(""")
  </script>

  <script src=""""),_display_(/*91.17*/routes/*91.23*/.Assets.versioned("javascripts/views/deviceTemplate/DeviceTemplate.js")),format.raw/*91.94*/(""""></script>
  <script src=""""),_display_(/*92.17*/routes/*92.23*/.Assets.versioned("javascripts/views/deviceTemplate/DeviceTemplate_attribute.js")),format.raw/*92.104*/(""""></script>
  <script src=""""),_display_(/*93.17*/routes/*93.23*/.Assets.versioned("javascripts/views/deviceTemplate/DeviceTemplate_createTem.js")),format.raw/*93.104*/(""""></script>

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
                  DATE: Mon Sep 22 16:32:44 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/deviceTemplate/DeviceTemplate.scala.html
                  HASH: d978e7a9992834ad85334f193d3e325f06e124e5
                  MATRIX: 670->1|693->18|1044->52|1175->88|1202->89|1370->231|1417->258|1498->312|1513->318|1570->354|1777->535|1791->540|1837->565|1870->571|1910->584|1925->590|2000->644|2090->708|2104->713|2168->756|2201->763|2215->768|2270->802|2303->808|2465->1031|2509->1234|2550->1257|2591->1332|2634->1374|2679->1449|2724->1529|2769->1616|2814->1696|2859->1777|2902->1802|2943->1825|2985->1839|3257->2083|3311->2115|3639->2417|3653->2422|3722->2470|3754->2476|3768->2481|3834->2526|3866->2532|3880->2537|3952->2588|3984->2594|3998->2599|4071->2651|4105->2659|4119->2664|4193->2717|4225->2723|4239->2728|4314->2782|4346->2788|4360->2793|4434->2846|4467->2853|4481->2858|4517->2873|4547->2876|4585->2888|4598->2893|4643->2917|4674->2921|4732->2952|4762->2961|4814->2986|4829->2992|4891->3033|4944->3059|4959->3065|5023->3108|5077->3135|5092->3141|5155->3183|5227->3227|5256->3228|5297->3241|5496->3412|5525->3413|5568->3428|5630->3462|5659->3463|5828->3604|5857->3605|5915->3636|5930->3642|6022->3713|6077->3741|6092->3747|6195->3828|6250->3856|6265->3862|6368->3943
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|53->21|53->21|53->21|55->23|55->23|55->23|57->25|62->30|63->31|64->32|65->33|66->34|67->35|68->36|69->37|70->38|71->39|72->40|73->41|75->43|76->44|76->44|90->58|90->58|90->58|91->59|91->59|91->59|92->60|92->60|92->60|93->61|93->61|93->61|96->64|96->64|96->64|97->65|97->65|97->65|98->66|98->66|98->66|100->68|100->68|100->68|101->69|103->71|103->71|103->71|105->73|106->74|106->74|108->76|108->76|108->76|109->77|109->77|109->77|111->79|111->79|111->79|113->81|113->81|114->82|117->85|117->85|118->86|119->87|119->87|120->88|120->88|123->91|123->91|123->91|124->92|124->92|124->92|125->93|125->93|125->93
                  -- GENERATED --
              */
          