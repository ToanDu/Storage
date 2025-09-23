
package views.html.iot.dashboard.customPage

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
/*2.2*/import vn.m2m.utils.DateUtil
/*3.2*/import vn.m2m.common.models.User

object CustomPageDashboard extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.20*/("""
"""),format.raw/*5.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*10.13*/Messages("dashboard.design")),format.raw/*10.41*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*11.46*/routes/*11.52*/.Assets.versioned("images/logo.jpg")),format.raw/*11.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*16.6*/views/*16.11*/.html.iot.tags.Main_css()),format.raw/*16.36*/("""

    """),format.raw/*18.5*/("""<link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("stylesheets/views/group/style.min.css")),format.raw/*18.82*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*19.78*/("""" rel="stylesheet" />

    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("assets/plugins/draggable/draggable.css")),format.raw/*21.83*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme bg-theme1">
    """),_display_(/*25.6*/views/*25.11*/.html.iot.tags.Menu(currentUser, "")),format.raw/*25.47*/("""

    """),_display_(/*27.6*/views/*27.11*/.html.iot.tags.Header(currentUser)),format.raw/*27.45*/("""

    """),format.raw/*29.5*/("""<div class="page-wrapper">
      <div class="page-content">

          <!--breadcrumb-->
        <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3 ">
          <div class="breadcrumb-title pe-3">"""),_display_(/*34.47*/Messages("manage.manage")),format.raw/*34.72*/("""</div>
          <div class="ps-3">
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb mb-0 p-0">
                <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt "></i></a>
                </li>
                <li class="breadcrumb-item active " aria-current="page">"""),_display_(/*40.74*/Messages("dashboard.design")),format.raw/*40.102*/("""</li>
              </ol>
            </nav>
          </div>
          <div class="ms-auto"></div>
        </div>
          <!--end breadcrumb-->


        <div class='parent'>
          <div class="col-md-12" >
            <div class="toolbar" >
              <button class="btn btn-primary" onclick="" data-bs-toggle="modal" data-bs-target="#addRowModal">
                <i class="bx bx-plus" aria-hidden="true"></i> """),_display_(/*53.64*/Messages("dashboard.design.addRow")),format.raw/*53.99*/("""
              """),format.raw/*54.15*/("""</button>
              <button class="btn btn-success" onclick="" data-bs-toggle="modal" data-bs-target="#">
                <i class="bx bx-save" aria-hidden="true"></i> """),_display_(/*56.64*/Messages("btnComfirm")),format.raw/*56.86*/("""
              """),format.raw/*57.15*/("""</button>
              <button class="btn btn-danger" onclick="" data-bs-toggle="modal" data-bs-target="#resetConfirm">
                <i class="bx bx-reset" aria-hidden="true"></i> """),_display_(/*59.65*/Messages("dashboard.design.reset")),format.raw/*59.99*/("""
              """),format.raw/*60.15*/("""</button>
            </div>
          </div>
          <hr>

          <div class="col-md-12" >
            <div class="row">
              <div class="col-md-3">
                <div class="card">
                  <div class="card-body">
                    <h5 class="card-title">Example</h5>
                    <hr/>
                    <div class="accordion" id="accordionExample">
                      <div class="accordion-item">
                        <h2 class="accordion-header">
                          <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                              <div class="tab-icon"><i class='bx bx-map font-18 me-1'></i></div>"""),_display_(/*76.98*/Messages("dashboard.design.map")),format.raw/*76.130*/("""
                          """),format.raw/*77.27*/("""</button>
                        </h2>
                        <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                          """),_display_(/*80.28*/views/*80.33*/.html.iot.dashboard.customPage.CustomPageDashboard_accordion_map()),format.raw/*80.99*/("""
                        """),format.raw/*81.25*/("""</div>
                      </div>

                      <div class="accordion-item">
                        <h2 class="accordion-header" id="headingTwo">
                          <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                              <div class="tab-icon"><i class='bx bx-chart font-18 me-1'></i></div>"""),_display_(/*87.100*/Messages("dashboard.design.chart")),format.raw/*87.134*/("""
                          """),format.raw/*88.27*/("""</button>
                        </h2>
                        <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                            <ul class="nav nav-tabs" role="tablist">
                                <li class="nav-item" role="presentation">
                                    <a class="nav-link active" data-bs-toggle="tab" href="#Column" role="tab" aria-selected="true">
                                        <div class="d-flex align-items-center">
                                            <div class="tab-title">"""),_display_(/*95.69*/Messages("Column")),format.raw/*95.87*/("""</div>
                                        </div>
                                    </a>
                                </li>
                                <li class="nav-item" role="presentation">
                                    <a class="nav-link" data-bs-toggle="tab" href="#Line" role="tab" aria-selected="false">
                                        <div class="d-flex align-items-center">
                                            <div class="tab-title">"""),_display_(/*102.69*/Messages("Line")),format.raw/*102.85*/("""</div>
                                        </div>
                                    </a>
                                </li>
                                <li class="nav-item" role="presentation">
                                    <a class="nav-link" data-bs-toggle="tab" href="#Circle" role="tab" aria-selected="false">
                                        <div class="d-flex align-items-center">
                                            <div class="tab-title">"""),_display_(/*109.69*/Messages("Circle")),format.raw/*109.87*/("""</div>
                                        </div>
                                    </a>
                                </li>
                            </ul>
                            <div class="tab-content py-3">
                                <div class="tab-pane fade show active" id="Column" role="tabpanel">
                                """),_display_(/*116.34*/views/*116.39*/.html.iot.dashboard.customPage.CustomPageDashboard_accordion_chartColumn()),format.raw/*116.113*/("""
                                """),format.raw/*117.33*/("""</div>
                                <div class="tab-pane fade" id="Line" role="tabpanel">
                                """),_display_(/*119.34*/views/*119.39*/.html.iot.dashboard.customPage.CustomPageDashboard_accordion_chartLine()),format.raw/*119.111*/("""
                                """),format.raw/*120.33*/("""</div>
                                <div class="tab-pane fade" id="Circle" role="tabpanel">
                                """),_display_(/*122.34*/views/*122.39*/.html.iot.dashboard.customPage.CustomPageDashboard_accordion_chartCircle()),format.raw/*122.113*/("""
                                """),format.raw/*123.33*/("""</div>
                            </div>

                        </div>
                      </div>

                      <div class="accordion-item">
                        <h2 class="accordion-header" id="headingThree">
                          <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                              <div class="tab-icon"><i class='bx bx-news font-18 me-1'></i></div>"""),_display_(/*132.99*/Messages("dashboard.design.statistical")),format.raw/*132.139*/("""
                          """),format.raw/*133.27*/("""</button>
                        </h2>
                        <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
                          <div class="accordion-body">
                          """),_display_(/*137.28*/views/*137.33*/.html.iot.dashboard.customPage.CustomPageDashboard_accordion_statistical()),format.raw/*137.107*/("""
                          """),format.raw/*138.27*/("""</div>
                        </div>
                      </div>

                      <div class="accordion-item">
                        <h2 class="accordion-header" id="headingFour">
                          <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseThree">
                              <div class="tab-icon"><i class='bx bx-list-ul font-18 me-1'></i></div>"""),_display_(/*145.102*/Messages("dashboard.design.table")),format.raw/*145.136*/("""
                          """),format.raw/*146.27*/("""</button>
                        </h2>
                        <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="headingFour" data-bs-parent="#accordionExample">
                          <div class="accordion-body">
                          """),_display_(/*150.28*/views/*150.33*/.html.iot.dashboard.customPage.CustomPageDashboard_accordion_table()),format.raw/*150.101*/("""
                          """),format.raw/*151.27*/("""</div>
                        </div>
                      </div>

                    </div>
                  </div>
                </div>
              </div>

              <div class="card col-md-9" id="bodyDashboard"></div>
            </div>
          </div>


        </div>
      </div>

      """),_display_(/*168.8*/views/*168.13*/.html.iot.dashboard.customPage.CustomPageDashboard_addRow()),format.raw/*168.72*/("""
      """),_display_(/*169.8*/views/*169.13*/.html.iot.dashboard.customPage.CustomPageDashboard_accordion_update()),format.raw/*169.82*/("""
      """),_display_(/*170.8*/views/*170.13*/.html.iot.dashboard.customPage.CustomPageDashboard_reset()),format.raw/*170.71*/("""

      """),_display_(/*172.8*/views/*172.13*/.html.Loading()),format.raw/*172.28*/("""

    """),format.raw/*174.5*/("""</div>
      <!--  END OF PAPER WRAP -->

  </body>

    """),_display_(/*179.6*/views/*179.11*/.html.iot.tags.Main_js()),format.raw/*179.35*/("""

    """),format.raw/*181.5*/("""<script>
            $(document).ready(function () """),format.raw/*182.43*/("""{"""),format.raw/*182.44*/("""
                """),format.raw/*183.17*/("""$("#menu-customPageDashboard").addClass("mm-active");
                $("#menu").metisMenu();

            """),format.raw/*186.13*/("""}"""),format.raw/*186.14*/(""")
    </script>

    <script src=""""),_display_(/*189.19*/routes/*189.25*/.Assets.versioned("javascripts/SearchJs.js")),format.raw/*189.69*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*191.19*/routes/*191.25*/.Assets.versioned("assets/plugins/draggable/jquery-3.3.1.slim.min.js")),format.raw/*191.95*/(""""></script>
    <script src=""""),_display_(/*192.19*/routes/*192.25*/.Assets.versioned("assets/plugins/draggable/touch-dnd.js")),format.raw/*192.83*/(""""></script>
    <script src=""""),_display_(/*193.19*/routes/*193.25*/.Assets.versioned("javascripts/views/dashboard/CustomPage/CustomPageDashboard.js")),format.raw/*193.107*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*194.19*/routes/*194.25*/.Assets.versioned("javascripts/views/dashboard/CustomPage/CustomChart.js")),format.raw/*194.99*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*195.19*/routes/*195.25*/.Assets.versioned("javascripts/views/dashboard/CustomPage/CustomStatistical.js")),format.raw/*195.105*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*196.19*/routes/*196.25*/.Assets.versioned("javascripts/views/dashboard/CustomPage/CustomTable.js")),format.raw/*196.99*/("""" type="text/javascript"></script>

    <script type="text/javascript">
            $(function() """),format.raw/*199.26*/("""{"""),format.raw/*199.27*/("""
                """),format.raw/*200.17*/("""$('.draggable').draggable("""),format.raw/*200.43*/("""{"""),format.raw/*200.44*/(""" """),format.raw/*200.45*/("""connectWith: '#rhs'"""),format.raw/*200.64*/("""}"""),format.raw/*200.65*/(""");
//                        .click(function(e) """),format.raw/*201.46*/("""{"""),format.raw/*201.47*/("""
"""),format.raw/*202.1*/("""//                    console.log(getParentNode(e.target,5));
//                """),format.raw/*203.19*/("""}"""),format.raw/*203.20*/(""");
                $('.droppable').droppable("""),format.raw/*204.43*/("""{"""),format.raw/*204.44*/(""" """),format.raw/*204.45*/("""activeClass: 'active', hoverClass: 'drop-here' """),format.raw/*204.92*/("""}"""),format.raw/*204.93*/(""");
            """),format.raw/*205.13*/("""}"""),format.raw/*205.14*/(""");

            var mapImg = """"),_display_(/*207.28*/routes/*207.34*/.Assets.versioned("images/dashboard/map.png")),format.raw/*207.79*/("""";
            var chartColumnImg = """"),_display_(/*208.36*/routes/*208.42*/.Assets.versioned("images/dashboard/chartColumn.png")),format.raw/*208.95*/("""";
            var chartLineImg = """"),_display_(/*209.34*/routes/*209.40*/.Assets.versioned("images/dashboard/chartLine.png")),format.raw/*209.91*/("""";
            var chartCircleImg = """"),_display_(/*210.36*/routes/*210.42*/.Assets.versioned("images/dashboard/chartCircle.png")),format.raw/*210.95*/("""";
            var statisticalImg = """"),_display_(/*211.36*/routes/*211.42*/.Assets.versioned("images/dashboard/statistical.png")),format.raw/*211.95*/("""";
            var tableImg = """"),_display_(/*212.30*/routes/*212.36*/.Assets.versioned("images/dashboard/table.png")),format.raw/*212.83*/("""";

            function getParentNode(element, level) """),format.raw/*214.52*/("""{"""),format.raw/*214.53*/(""" """),format.raw/*214.54*/("""// 1 - default value (if no 'level' parameter is passed to the function)
                while(level-- > 0) """),format.raw/*215.36*/("""{"""),format.raw/*215.37*/("""
                    """),format.raw/*216.21*/("""element = element.parentNode;
                    if(!element) """),format.raw/*217.34*/("""{"""),format.raw/*217.35*/("""
                        """),format.raw/*218.25*/("""return null; // to avoid a possible "TypeError: Cannot read property 'parentNode' of null" if the requested level is higher than document
                    """),format.raw/*219.21*/("""}"""),format.raw/*219.22*/("""
                """),format.raw/*220.17*/("""}"""),format.raw/*220.18*/("""
                """),format.raw/*221.17*/("""return element;
            """),format.raw/*222.13*/("""}"""),format.raw/*222.14*/("""
    """),format.raw/*223.5*/("""</script>
</html>
"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:43 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboard/customPage/CustomPageDashboard.scala.html
                  HASH: c083630232122e3207fe0c390559d372367e2ac7
                  MATRIX: 676->1|699->18|735->48|1084->82|1197->100|1224->101|1393->243|1442->271|1523->325|1538->331|1595->367|1802->548|1816->553|1862->578|1895->584|1935->597|1950->603|2029->661|2095->700|2110->706|2185->760|2252->800|2267->806|2347->865|2447->939|2461->944|2518->980|2551->987|2565->992|2620->1026|2653->1032|2895->1247|2941->1272|3291->1595|3341->1623|3790->2045|3846->2080|3889->2095|4089->2268|4132->2290|4175->2305|4387->2490|4442->2524|4485->2539|5282->3309|5336->3341|5391->3368|5637->3587|5651->3592|5738->3658|5791->3683|6266->4130|6322->4164|6377->4191|7014->4801|7053->4819|7560->5298|7598->5314|8107->5795|8147->5813|8534->6172|8549->6177|8646->6251|8708->6284|8862->6410|8877->6415|8972->6487|9034->6520|9190->6648|9205->6653|9302->6727|9364->6760|9911->7279|9974->7319|10030->7346|10331->7619|10346->7624|10443->7698|10499->7725|11012->8209|11069->8243|11125->8270|11424->8541|11439->8546|11530->8614|11586->8641|11919->8947|11934->8952|12015->9011|12050->9019|12065->9024|12156->9093|12191->9101|12206->9106|12286->9164|12322->9173|12337->9178|12374->9193|12408->9199|12493->9257|12508->9262|12554->9286|12588->9292|12668->9343|12698->9344|12744->9361|12880->9468|12910->9469|12973->9504|12989->9510|13055->9554|13137->9608|13153->9614|13245->9684|13303->9714|13319->9720|13399->9778|13457->9808|13473->9814|13578->9896|13659->9949|13675->9955|13771->10029|13852->10082|13868->10088|13971->10168|14052->10221|14068->10227|14164->10301|14290->10398|14320->10399|14366->10416|14421->10442|14451->10443|14481->10444|14529->10463|14559->10464|14636->10512|14666->10513|14695->10514|14804->10594|14834->10595|14908->10640|14938->10641|14968->10642|15044->10689|15074->10690|15118->10705|15148->10706|15207->10737|15223->10743|15290->10788|15356->10826|15372->10832|15447->10885|15511->10921|15527->10927|15600->10978|15666->11016|15682->11022|15757->11075|15823->11113|15839->11119|15914->11172|15974->11204|15990->11210|16059->11257|16143->11312|16173->11313|16203->11314|16340->11422|16370->11423|16420->11444|16512->11507|16542->11508|16596->11533|16783->11691|16813->11692|16859->11709|16889->11710|16935->11727|16992->11755|17022->11756|17055->11761
                  LINES: 24->1|25->2|26->3|31->4|36->4|37->5|42->10|42->10|43->11|43->11|43->11|48->16|48->16|48->16|50->18|50->18|50->18|50->18|51->19|51->19|51->19|53->21|53->21|53->21|57->25|57->25|57->25|59->27|59->27|59->27|61->29|66->34|66->34|72->40|72->40|85->53|85->53|86->54|88->56|88->56|89->57|91->59|91->59|92->60|108->76|108->76|109->77|112->80|112->80|112->80|113->81|119->87|119->87|120->88|127->95|127->95|134->102|134->102|141->109|141->109|148->116|148->116|148->116|149->117|151->119|151->119|151->119|152->120|154->122|154->122|154->122|155->123|164->132|164->132|165->133|169->137|169->137|169->137|170->138|177->145|177->145|178->146|182->150|182->150|182->150|183->151|200->168|200->168|200->168|201->169|201->169|201->169|202->170|202->170|202->170|204->172|204->172|204->172|206->174|211->179|211->179|211->179|213->181|214->182|214->182|215->183|218->186|218->186|221->189|221->189|221->189|223->191|223->191|223->191|224->192|224->192|224->192|225->193|225->193|225->193|226->194|226->194|226->194|227->195|227->195|227->195|228->196|228->196|228->196|231->199|231->199|232->200|232->200|232->200|232->200|232->200|232->200|233->201|233->201|234->202|235->203|235->203|236->204|236->204|236->204|236->204|236->204|237->205|237->205|239->207|239->207|239->207|240->208|240->208|240->208|241->209|241->209|241->209|242->210|242->210|242->210|243->211|243->211|243->211|244->212|244->212|244->212|246->214|246->214|246->214|247->215|247->215|248->216|249->217|249->217|250->218|251->219|251->219|252->220|252->220|253->221|254->222|254->222|255->223
                  -- GENERATED --
              */
          