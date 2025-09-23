
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

object WaterClock extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(token: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.17*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*7.13*/Messages("Water Clock")),format.raw/*7.36*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*8.46*/routes/*8.52*/.Assets.versioned("images/logo.jpg")),format.raw/*8.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*13.6*/views/*13.11*/.html.iot.tags.Main_css()),format.raw/*13.36*/("""

    """),format.raw/*15.5*/("""<link href=""""),_display_(/*15.18*/routes/*15.24*/.Assets.versioned("stylesheets/views/group/style.min.css")),format.raw/*15.82*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*16.18*/routes/*16.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*16.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/overview/slider.css")),format.raw/*17.82*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("stylesheets/views/overview/slider2.css")),format.raw/*18.83*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("stylesheets/views/overview/overview.css")),format.raw/*19.84*/("""" rel="stylesheet" />

    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("stylesheets/plugins/select2/css/select2.min.css")),format.raw/*21.92*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("stylesheets/plugins/select2/css/select2-bootstrap4.css")),format.raw/*22.99*/("""" rel="stylesheet" />

    """),format.raw/*24.96*/("""
    """),format.raw/*25.5*/("""<link href='"""),_display_(/*25.18*/routes/*25.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*25.73*/("""' type='text/css'>
    <link href=""""),_display_(/*26.18*/routes/*26.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*26.99*/("""" rel="stylesheet">
    <link href=""""),_display_(/*27.18*/routes/*27.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*27.139*/("""" rel="stylesheet" >
    <style>
            .btn """),format.raw/*29.18*/("""{"""),format.raw/*29.19*/("""
              """),format.raw/*30.15*/("""color: white;
            """),format.raw/*31.13*/("""}"""),format.raw/*31.14*/("""
            """),format.raw/*32.13*/("""table.dataTable.dtr-inline.collapsed>tbody>tr[role="row"]>td:first-child:before, table.dataTable.dtr-inline.collapsed>tbody>tr[role="row"]>th:first-child:before """),format.raw/*32.174*/("""{"""),format.raw/*32.175*/("""
              """),format.raw/*33.15*/("""top: 8px;
            """),format.raw/*34.13*/("""}"""),format.raw/*34.14*/("""
    """),format.raw/*35.5*/("""</style>
  </head>
  <body class="bg-theme">
    """),_display_(/*38.6*/views/*38.11*/.html.iot.waterClock.WaterClock_menu()),format.raw/*38.49*/("""

    """),_display_(/*40.6*/views/*40.11*/.html.iot.waterClock.WaterClock_header()),format.raw/*40.51*/("""

    """),format.raw/*42.5*/("""<div class="page-wrapper">
      <div class="page-content">

        """),format.raw/*45.28*/("""
        """),format.raw/*46.9*/("""<div class="col-md-12">
          <div class="row mb-4">
            <div class="col-sm-9">
              <div class="breadcrumb-title pe-3 breadcrumbTitle" >"""),_display_(/*49.68*/Messages("Đồng hồ nước ")),format.raw/*49.93*/("""</div>
            </div>
            <div class="col-sm-3">
              <div class="inner-addon left-addon">
                <input id="searchDashboard" class="form-control inputSearch" type="text" placeholder="" maxlength="50">
                <i class="glyphicon bx bx-search"></i>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          """),format.raw/*60.37*/("""
            """),format.raw/*61.34*/("""
              """),format.raw/*62.42*/("""
                """),format.raw/*63.39*/("""
                  """),format.raw/*64.120*/("""
                  """),format.raw/*65.46*/("""
                    """),format.raw/*66.98*/("""
                    """),format.raw/*67.47*/("""
                      """),format.raw/*68.119*/("""
                    """),format.raw/*69.31*/("""
                  """),format.raw/*70.29*/("""
                """),format.raw/*71.27*/("""
              """),format.raw/*72.25*/("""
            """),format.raw/*73.23*/("""
          """),format.raw/*74.21*/("""

          """),format.raw/*76.11*/("""<div class="col-md-12">
            <div class="card radius-10">
              <div class="card-body">
                <div class="table-responsive mt-3" id="listClock" style="overflow: hidden;"></div>
              </div>
            </div>
          </div>

          <div class="col-md-12">
            <div class="row mb-4">
              <div class="col-sm-9">
                <div class="breadcrumb-title pe-3 breadcrumbTitle" >"""),_display_(/*87.70*/Messages("Biểu đồ thồng kê ")),format.raw/*87.99*/("""</div>
              </div>
              <div class="col-sm-3">
                <div class="inner-addon left-addon">
                  <input id="searchDashboard" class="form-control inputSearch" type="text" placeholder="" maxlength="50">
                  <i class="glyphicon bx bx-search"></i>
                </div>
              </div>
            </div>
          </div>

          <div class="col-md-12">
            <div class="row">
              <div class="col-md-12">
                """),_display_(/*101.18*/views/*101.23*/.html.iot.waterClock.WaterClock_formSearch()),format.raw/*101.67*/("""
              """),format.raw/*102.15*/("""</div>
              <div class="col-md-8">
                <div class="card">
                  <div class="card-body">
                    <div id="columnChartDay" style="height: 400px;"></div>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="card">
                  <div class="card-body">
                    <div id="columnChartMonth" style="height: 400px;"></div>
                  </div>
                </div>
              </div>
            </div>
          </div>

        </div>
      </div>

      """),_display_(/*123.8*/views/*123.13*/.html.Loading()),format.raw/*123.28*/("""

    """),format.raw/*125.5*/("""</div>
      <!--  END OF PAPER WRAP -->

    """),_display_(/*128.6*/views/*128.11*/.html.iot.waterClock.Main_js()),format.raw/*128.41*/("""

    """),format.raw/*130.5*/("""<script src=""""),_display_(/*130.19*/routes/*130.25*/.Assets.versioned("javascripts/plugins/loader.js")),format.raw/*130.75*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*131.19*/routes/*131.25*/.Assets.versioned("javascripts/plugins/chartist.min.js")),format.raw/*131.81*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*133.19*/routes/*133.25*/.Assets.versioned("stylesheets/plugins/select2/js/select2.min.js")),format.raw/*133.91*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*135.19*/routes/*135.25*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/moment.min.js")),format.raw/*135.111*/(""""></script>
    <script src=""""),_display_(/*136.19*/routes/*136.25*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.min.js")),format.raw/*136.138*/(""""></script>

    <script>
      var token = """"),_display_(/*139.21*/token),format.raw/*139.26*/("""";

            $(document).ready(function () """),format.raw/*141.43*/("""{"""),format.raw/*141.44*/("""
              """),format.raw/*142.15*/("""$("#menu-waterClock").addClass("mm-active");

              $("#menu").metisMenu();
              for (var e = window.location, o = $(".metismenu li a").filter(function() """),format.raw/*145.88*/("""{"""),format.raw/*145.89*/("""
                """),format.raw/*146.17*/("""return this.href == e
              """),format.raw/*147.15*/("""}"""),format.raw/*147.16*/(""").addClass("").parent().addClass("mm-active"); o.is("li");) o = o.parent("").addClass("mm-show").parent("").addClass("mm-active");

              $('.single-select').select2("""),format.raw/*149.43*/("""{"""),format.raw/*149.44*/("""
                """),format.raw/*150.17*/("""theme: 'bootstrap4',
                width: $(this).data('width') ? $(this).data('width') : $(this).hasClass('w-100') ? '100%' : 'style',
                placeholder: $(this).data('placeholder'),
                allowClear: Boolean($(this).data('allow-clear'))
              """),format.raw/*154.15*/("""}"""),format.raw/*154.16*/(""");

              $('#date_timepicker_start').bootstrapMaterialDatePicker("""),format.raw/*156.71*/("""{"""),format.raw/*156.72*/("""
                """),format.raw/*157.17*/("""format: 'DD-MM-YYYY',
                time: false
              """),format.raw/*159.15*/("""}"""),format.raw/*159.16*/(""");
              $('#date_timepicker_end').bootstrapMaterialDatePicker("""),format.raw/*160.69*/("""{"""),format.raw/*160.70*/("""
                """),format.raw/*161.17*/("""format: 'DD-MM-YYYY',
                time: false
              """),format.raw/*163.15*/("""}"""),format.raw/*163.16*/(""");
            """),format.raw/*164.13*/("""}"""),format.raw/*164.14*/(""")
    </script>

    <script src=""""),_display_(/*167.19*/routes/*167.25*/.Assets.versioned("javascripts/plugins/jquery.dataTables.min.js")),format.raw/*167.90*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*169.19*/routes/*169.25*/.Assets.versioned("javascripts/views/waterClock/waterClock.js")),format.raw/*169.88*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*170.19*/routes/*170.25*/.Assets.versioned("javascripts/views/waterClock/waterClock_listDevice.js")),format.raw/*170.99*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*171.19*/routes/*171.25*/.Assets.versioned("javascripts/views/waterClock/waterClock_chart.js")),format.raw/*171.94*/("""" type="text/javascript"></script>

  </body>
</html>
"""))
      }
    }
  }

  def render(token:String): play.twirl.api.HtmlFormat.Appendable = apply(token)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (token) => apply(token)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:46 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/waterClock/WaterClock.scala.html
                  HASH: e267b3520df36ba6a15adf977e34f99bb5a709e7
                  MATRIX: 968->1|1078->16|1105->17|1273->159|1316->182|1396->236|1410->242|1466->278|1673->459|1687->464|1733->489|1766->495|1806->508|1821->514|1900->572|1966->611|1981->617|2056->671|2122->710|2137->716|2216->774|2282->813|2297->819|2377->878|2443->917|2458->923|2539->983|2606->1023|2621->1029|2710->1097|2776->1136|2791->1142|2887->1217|2942->1335|2974->1340|3014->1353|3029->1359|3099->1408|3162->1444|3177->1450|3273->1525|3337->1562|3352->1568|3489->1683|3567->1733|3596->1734|3639->1749|3693->1775|3722->1776|3763->1789|3953->1950|3983->1951|4026->1966|4076->1988|4105->1989|4137->1994|4213->2044|4227->2049|4286->2087|4319->2094|4333->2099|4394->2139|4427->2145|4524->2233|4560->2242|4746->2401|4792->2426|5215->2847|5256->2881|5299->2923|5344->2962|5392->3082|5439->3128|5488->3226|5537->3273|5589->3392|5638->3423|5685->3452|5730->3479|5773->3504|5814->3527|5853->3548|5893->3560|6355->3995|6405->4024|6930->4521|6945->4526|7011->4570|7055->4585|7680->5183|7695->5188|7732->5203|7766->5209|7840->5256|7855->5261|7907->5291|7941->5297|7983->5311|7999->5317|8071->5367|8152->5420|8168->5426|8246->5482|8328->5536|8344->5542|8432->5608|8514->5662|8530->5668|8639->5754|8697->5784|8713->5790|8849->5903|8923->5949|8950->5954|9025->6000|9055->6001|9099->6016|9299->6187|9329->6188|9375->6205|9440->6241|9470->6242|9673->6416|9703->6417|9749->6434|10053->6709|10083->6710|10186->6784|10216->6785|10262->6802|10355->6866|10385->6867|10485->6938|10515->6939|10561->6956|10654->7020|10684->7021|10728->7036|10758->7037|10821->7072|10837->7078|10924->7143|11006->7197|11022->7203|11107->7266|11188->7319|11204->7325|11300->7399|11381->7452|11397->7458|11488->7527
                  LINES: 28->1|33->1|34->2|39->7|39->7|40->8|40->8|40->8|45->13|45->13|45->13|47->15|47->15|47->15|47->15|48->16|48->16|48->16|49->17|49->17|49->17|50->18|50->18|50->18|51->19|51->19|51->19|53->21|53->21|53->21|54->22|54->22|54->22|56->24|57->25|57->25|57->25|57->25|58->26|58->26|58->26|59->27|59->27|59->27|61->29|61->29|62->30|63->31|63->31|64->32|64->32|64->32|65->33|66->34|66->34|67->35|70->38|70->38|70->38|72->40|72->40|72->40|74->42|77->45|78->46|81->49|81->49|92->60|93->61|94->62|95->63|96->64|97->65|98->66|99->67|100->68|101->69|102->70|103->71|104->72|105->73|106->74|108->76|119->87|119->87|133->101|133->101|133->101|134->102|155->123|155->123|155->123|157->125|160->128|160->128|160->128|162->130|162->130|162->130|162->130|163->131|163->131|163->131|165->133|165->133|165->133|167->135|167->135|167->135|168->136|168->136|168->136|171->139|171->139|173->141|173->141|174->142|177->145|177->145|178->146|179->147|179->147|181->149|181->149|182->150|186->154|186->154|188->156|188->156|189->157|191->159|191->159|192->160|192->160|193->161|195->163|195->163|196->164|196->164|199->167|199->167|199->167|201->169|201->169|201->169|202->170|202->170|202->170|203->171|203->171|203->171
                  -- GENERATED --
              */
          