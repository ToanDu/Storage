
package views.html.iot.pay.sim

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

object Sim extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, projectId:String, simnb:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.52*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>"""),_display_(/*9.17*/Messages("Detail Sim")),format.raw/*9.39*/("""</title>
        <link rel="icon" type="image/png" href=""""),_display_(/*10.50*/routes/*10.56*/.Assets.versioned("images/logo.jpg")),format.raw/*10.92*/("""">

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        """),_display_(/*15.10*/views/*15.15*/.html.iot.tags.Main_css()),format.raw/*15.40*/("""

        """),format.raw/*17.9*/("""<link href=""""),_display_(/*17.22*/routes/*17.28*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*17.82*/("""" rel="stylesheet" />
        <link href=""""),_display_(/*18.22*/routes/*18.28*/.Assets.versioned("stylesheets/views/pay/customer.css")),format.raw/*18.83*/("""" rel="stylesheet" />

        <style>
                .nav """),format.raw/*21.22*/("""{"""),format.raw/*21.23*/("""
                    """),format.raw/*22.21*/("""display: block;
                """),format.raw/*23.17*/("""}"""),format.raw/*23.18*/("""
                """),format.raw/*24.17*/(""".nav-pills .nav-link.active, .nav-pills .show>.nav-link """),format.raw/*24.73*/("""{"""),format.raw/*24.74*/("""
                    """),format.raw/*25.21*/("""color: #f8f9fa;
                    background-color: #ec1b2eb8;
                """),format.raw/*27.17*/("""}"""),format.raw/*27.18*/("""
                """),format.raw/*28.17*/(""".nav-pills .nav-link """),format.raw/*28.38*/("""{"""),format.raw/*28.39*/("""
                    """),format.raw/*29.21*/("""text-align: center;
                    background-color: #aaa;
                    color: white;
                    width:100%;
                    margin-top: 15px;
                """),format.raw/*34.17*/("""}"""),format.raw/*34.18*/("""
        """),format.raw/*35.9*/("""</style>
    </head>
    <body class="bg-theme">
        """),_display_(/*38.10*/views/*38.15*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*38.58*/("""

        """),_display_(/*40.10*/views/*40.15*/.html.iot.tags.Header(currentUser)),format.raw/*40.49*/("""

        """),format.raw/*42.9*/("""<div class="page-wrapper">
            <div class="page-content">

                <div class="row">
                    <div class="col-md-12">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="tab-content" id="infoCustomer">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
                                                <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; font-weight: normal;"> """),_display_(/*53.193*/Messages("Thông tin thiết bị")),format.raw/*53.223*/("""</span>
                                            </div>
                                            <div class="card mb-3" style="border: 1px solid #858687;">
                                                <div class="card-body">
                                                    <p class="card-text" >"""),_display_(/*57.76*/Messages("ID")),format.raw/*57.90*/("""</p>
                                                    <p class="card-text" >"""),_display_(/*58.76*/Messages("Mã IMEI")),format.raw/*58.95*/("""</p>
                                                    <p class="card-text" >"""),_display_(/*59.76*/Messages("Serial")),format.raw/*59.94*/("""</p>
                                                    <p class="card-text" >"""),_display_(/*60.76*/Messages("ESim")),format.raw/*60.92*/("""</p>
                                                    <p class="card-text" >"""),_display_(/*61.76*/Messages("Trạng thái đấu nối")),format.raw/*61.106*/("""</p>
                                                    <p class="card-text" >"""),_display_(/*62.76*/Messages("Loại dịch vụ")),format.raw/*62.100*/("""</p>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-md-6">
                                            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
                                                <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; font-weight: normal;"> """),_display_(/*69.193*/Messages("Thông tin gói cước")),format.raw/*69.223*/("""</span>
                                            </div>
                                            <div class="card mb-3" style="border: 1px solid #858687;">
                                                <div class="card-body">
                                                    <p class="card-text" >"""),_display_(/*73.76*/Messages("Tên gói cước")),format.raw/*73.100*/("""</p>
                                                    <p class="card-text" >"""),_display_(/*74.76*/Messages("Trạng thái")),format.raw/*74.98*/("""</p>
                                                    <p class="card-text" >"""),_display_(/*75.76*/Messages("Số simNB")),format.raw/*75.96*/("""</p>
                                                    <p class="card-text" >"""),_display_(/*76.76*/Messages("Serial Sim")),format.raw/*76.98*/("""</p>
                                                    <p class="card-text" >"""),_display_(/*77.76*/Messages("Số dư")),format.raw/*77.93*/("""</p>
                                                    <p class="card-text" >"""),_display_(/*78.76*/Messages("Thời điểm hết hạn")),format.raw/*78.105*/("""</p>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
                                                <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; font-weight: normal;"> """),_display_(/*85.193*/Messages("Thông tin thuê bao")),format.raw/*85.223*/("""</span>
                                            </div>
                                            <div class="card mb-3" style="border: 1px solid #858687;">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="card-body">
                                                            <p class="card-text" >"""),_display_(/*91.84*/Messages("Tên gói cước")),format.raw/*91.108*/("""</p>
                                                            <p class="card-text" >"""),_display_(/*92.84*/Messages("Trạng thái")),format.raw/*92.106*/("""</p>
                                                            <p class="card-text" >"""),_display_(/*93.84*/Messages("Số dư")),format.raw/*93.101*/("""</p>
                                                            <p class="card-text" >"""),_display_(/*94.84*/Messages("Ngày nạp tiền gần nhất")),format.raw/*94.118*/("""</p>
                                                            <p class="card-text" >"""),_display_(/*95.84*/Messages("Số tiền nạp gần nhất")),format.raw/*95.116*/("""</p>
                                                            <p class="card-text" >"""),_display_(/*96.84*/Messages("Thời điểm hết hạn")),format.raw/*96.113*/("""</p>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="card-body">
                                                            <p class="card-text" >"""),_display_(/*101.84*/Messages("Số thuê bao")),format.raw/*101.107*/("""</p>
                                                            <p class="card-text" >"""),_display_(/*102.84*/Messages("Gói cước chính")),format.raw/*102.110*/("""</p>
                                                            <p class="card-text" >"""),_display_(/*103.84*/Messages("Ngày bắt đầu gói cước chính")),format.raw/*103.123*/("""</p>
                                                            <p class="card-text" >"""),_display_(/*104.84*/Messages("Ngày hết hạn gói cước chính")),format.raw/*104.123*/("""</p>
                                                            <p class="card-text" >"""),_display_(/*105.84*/Messages("Data theo KB")),format.raw/*105.108*/("""</p>
                                                            <p class="card-text" >"""),_display_(/*106.84*/Messages("Data còn lại theo KB")),format.raw/*106.116*/("""</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>

                </div>
            </div>
        </div>

        """),_display_(/*124.10*/views/*124.15*/.html.Loading()),format.raw/*124.30*/("""
    """),format.raw/*125.5*/("""</body>

    """),_display_(/*127.6*/views/*127.11*/.html.iot.tags.Main_js()),format.raw/*127.35*/("""

    """),format.raw/*129.5*/("""<script>
            var projectId = '"""),_display_(/*130.31*/projectId),format.raw/*130.40*/("""';
            var simnb = '"""),_display_(/*131.27*/simnb),format.raw/*131.32*/("""';

            var iconEdit = """"),_display_(/*133.30*/routes/*133.36*/.Assets.versioned("images/icon/edit.png")),format.raw/*133.77*/("""";
            var iconDelete = """"),_display_(/*134.32*/routes/*134.38*/.Assets.versioned("images/icon/delete.png")),format.raw/*134.81*/("""";
            var iconList = """"),_display_(/*135.30*/routes/*135.36*/.Assets.versioned("images/icon/copy.png")),format.raw/*135.77*/("""";

            $(document).ready(function () """),format.raw/*137.43*/("""{"""),format.raw/*137.44*/("""
                """),format.raw/*138.17*/("""$("#menu-sim").addClass("mm-active");

                $("#menu").metisMenu();
                for (var e = window.location, o = $(".metismenu li a").filter(function() """),format.raw/*141.90*/("""{"""),format.raw/*141.91*/("""
                    """),format.raw/*142.21*/("""return this.href == e
                """),format.raw/*143.17*/("""}"""),format.raw/*143.18*/(""").addClass("").parent().addClass("mm-active"); o.is("li");) o = o.parent("").addClass("mm-show").parent("").addClass("mm-active");
            """),format.raw/*144.13*/("""}"""),format.raw/*144.14*/(""");
    </script>
    <script src=""""),_display_(/*146.19*/routes/*146.25*/.Assets.versioned("javascripts/views/pay/sim/Sim.js")),format.raw/*146.78*/(""""></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,projectId:String,simnb:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,projectId,simnb)

  def f:((User,String,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,projectId,simnb) => apply(currentUser,projectId,simnb)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:45 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/pay/sim/Sim.scala.html
                  HASH: 098f0bcc991694fb4ae995ce7e88cc64ac28bfb3
                  MATRIX: 663->1|686->18|1033->52|1178->102|1205->103|1387->259|1429->281|1514->339|1529->345|1586->381|1806->574|1820->579|1866->604|1903->614|1943->627|1958->633|2033->687|2103->730|2118->736|2194->791|2282->851|2311->852|2360->873|2420->905|2449->906|2494->923|2578->979|2607->980|2656->1001|2765->1082|2794->1083|2839->1100|2888->1121|2917->1122|2966->1143|3178->1327|3207->1328|3243->1337|3328->1395|3342->1400|3406->1443|3444->1454|3458->1459|3513->1493|3550->1503|4333->2258|4385->2288|4721->2597|4756->2611|4863->2691|4903->2710|5010->2790|5049->2808|5156->2888|5193->2904|5300->2984|5352->3014|5459->3094|5505->3118|6078->3663|6130->3693|6466->4002|6512->4026|6619->4106|6662->4128|6769->4208|6810->4228|6917->4308|6960->4330|7067->4410|7105->4427|7212->4507|7263->4536|7837->5082|7889->5112|8382->5578|8428->5602|8543->5690|8587->5712|8702->5800|8741->5817|8856->5905|8912->5939|9027->6027|9081->6059|9196->6147|9247->6176|9640->6541|9686->6564|9802->6652|9851->6678|9967->6766|10029->6805|10145->6893|10207->6932|10323->7020|10370->7044|10486->7132|10541->7164|11094->7689|11109->7694|11146->7709|11179->7714|11220->7728|11235->7733|11281->7757|11315->7763|11382->7802|11413->7811|11470->7840|11497->7845|11558->7878|11574->7884|11637->7925|11699->7959|11715->7965|11780->8008|11840->8040|11856->8046|11919->8087|11994->8133|12024->8134|12070->8151|12267->8319|12297->8320|12347->8341|12414->8379|12444->8380|12616->8523|12646->8524|12709->8559|12725->8565|12800->8618
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|53->21|53->21|54->22|55->23|55->23|56->24|56->24|56->24|57->25|59->27|59->27|60->28|60->28|60->28|61->29|66->34|66->34|67->35|70->38|70->38|70->38|72->40|72->40|72->40|74->42|85->53|85->53|89->57|89->57|90->58|90->58|91->59|91->59|92->60|92->60|93->61|93->61|94->62|94->62|101->69|101->69|105->73|105->73|106->74|106->74|107->75|107->75|108->76|108->76|109->77|109->77|110->78|110->78|117->85|117->85|123->91|123->91|124->92|124->92|125->93|125->93|126->94|126->94|127->95|127->95|128->96|128->96|133->101|133->101|134->102|134->102|135->103|135->103|136->104|136->104|137->105|137->105|138->106|138->106|156->124|156->124|156->124|157->125|159->127|159->127|159->127|161->129|162->130|162->130|163->131|163->131|165->133|165->133|165->133|166->134|166->134|166->134|167->135|167->135|167->135|169->137|169->137|170->138|173->141|173->141|174->142|175->143|175->143|176->144|176->144|178->146|178->146|178->146
                  -- GENERATED --
              */
          