
package views.html.telco.buySim.manageOrder

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

object ManageOrder extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.35*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("history.order.sim.title")),format.raw/*9.48*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*17.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("assets/plugins/input-tags/css/tagsinput.css")),format.raw/*18.88*/("""" rel="stylesheet" />
    """),format.raw/*19.96*/("""
    """),format.raw/*20.5*/("""<link href='"""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*20.73*/("""' type='text/css'>
    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*21.99*/("""" rel="stylesheet">
    <link href=""""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*22.139*/("""" rel="stylesheet" >

    <link href=""""),_display_(/*24.18*/routes/*24.24*/.Assets.versioned("stylesheets/views/telco/utilites/utilites.css")),format.raw/*24.90*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*25.18*/routes/*25.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*25.78*/("""" rel="stylesheet" />
  </head>
  <body class="bg-theme">
    """),_display_(/*28.6*/views/*28.11*/.html.telco.Menu(currentUser, "", userId)),format.raw/*28.52*/("""

    """),_display_(/*30.6*/views/*30.11*/.html.telco.Header(currentUser)),format.raw/*30.42*/("""

    """),format.raw/*32.5*/("""<div class="page-wrapper">
      <div class="page-content">
        """),_display_(/*34.10*/views/*34.15*/.html.telco.buySim.manageOrder.ManageOrder_formSearch(currentUser)),format.raw/*34.81*/("""

        """),format.raw/*36.9*/("""<div class="card" style="border-radius: 8px;">
          <div class="card-body">
          <div class="table-responsive">
            <table class="table table-striped" id="listOrderTable" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th>"""),_display_(/*42.24*/Messages("history.table.no")),format.raw/*42.52*/("""</th>
                  <th>"""),_display_(/*43.24*/Messages("history.table.order.code")),format.raw/*43.60*/("""</th>
                  <th>"""),_display_(/*44.24*/Messages("history.table.order.type")),format.raw/*44.60*/("""</th>
                  <th>"""),_display_(/*45.24*/Messages("history.table.company.name")),format.raw/*45.62*/("""</th>
                  <th>"""),_display_(/*46.24*/Messages("history.table.representative")),format.raw/*46.64*/("""</th>
                  <th>"""),_display_(/*47.24*/Messages("history.table.phone.number")),format.raw/*47.62*/("""</th>
                  <th>"""),_display_(/*48.24*/Messages("history.table.status")),format.raw/*48.56*/("""</th>
                  <th>"""),_display_(/*49.24*/Messages("history.table.time")),format.raw/*49.54*/("""</th>
                  <th>"""),_display_(/*50.24*/Messages("history.table.actions")),format.raw/*50.57*/("""</th>
                </tr>
              </thead>
              <tbody>
              </tbody>
            </table>
            <h5 id="notiNotData" style="text-align: center;"></h5>
          </div>
          <div class="row">
            <div class="col-md-4 d-flex align-items-center justify-content-center justify-content-md-start mb-3">
              <p class="mb-0">"""),_display_(/*60.32*/Messages("history.total")),format.raw/*60.57*/(""" """),format.raw/*60.58*/("""<span id="total_record">0</span> """),_display_(/*60.92*/Messages("history.records")),format.raw/*60.119*/("""</p>
            </div>
            <div class="col-md-8 d-flex flex-column flex-md-row justify-content-end align-items-center gap-2 gap-md-3 mb-3">
              <div class="dropdown mb-2 mb-md-0">
                <button class="btn btn-sm dropdown-toggle btn-outline-dark" type="button" data-bs-toggle="dropdown"
                  aria-expanded="false" id="countPageSize" style="margin-left: 5px;">
                  10
                </button>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="javascript:ApplyFilter(1,10,true)">10</a></li>
                  <li><a class="dropdown-item" href="javascript:ApplyFilter(1,50,true)">50</a></li>
                  <li><a class="dropdown-item" href="javascript:ApplyFilter(1,100,true)">100</a></li>
                  <li><a class="dropdown-item" href="javascript:ApplyFilter(1,200,true)">200</a></li>
                  <li><a class="dropdown-item" href="javascript:ApplyFilter(1,500,true)">500</a></li>
                </ul>
              </div>
              <p class="mb-2 mb-md-0">"""),_display_(/*76.40*/Messages("history.records.per.page")),format.raw/*76.76*/("""</p>
              <div id="pagingTable" class="justify-content-md-end"></div>
            </div>
          
          </div>
          <div>
            <input name="page" id="page" value="1" style="display: none">
            <input name="pageSize" id="pageSize" value="10" style="display: none">
            <input name="isResetPage" id="isResetPage" value="false" style="display: none">
          </div>
          </div>
        </div>

      </div>
    <!-- Modal -->
    <div id="orderDetailModal" class="modal fade" tabindex="-1">
      <div class="modal-dialog modal-xl">
        <div class="modal-content">
          <div class="modal-header"><h5 class="modal-title">"""),_display_(/*94.62*/Messages("history.modal.order.details")),format.raw/*94.101*/("""</h5></div>
          <div class="modal-body">
            <div class="row g-4">
              <!-- Cột 1 -->
              <div class="col-md-4">
                <div class="mb-3">
                  <label for="orderCode" class="form-label">"""),_display_(/*100.62*/Messages("history.modal.order.code")),format.raw/*100.98*/("""</label>
                  <input type="text" class="form-control" id="orderCodeReadonly" readonly>
                </div>
                <div class="mb-3">
                  <label for="orderTime" class="form-label">"""),_display_(/*104.62*/Messages("history.modal.order.time")),format.raw/*104.98*/("""</label>
                  <input type="text" class="form-control" id="orderTimeReadonly" readonly>
                </div>
                <div class="mb-3">
                  <label for="recipientName" class="form-label">"""),_display_(/*108.66*/Messages("history.modal.representative")),format.raw/*108.106*/("""</label>
                  <input type="text" class="form-control" id="recipientNameReadonly" readonly>
                </div>
              </div>
    
              <!-- Cột 2 -->
              <div class="col-md-4">
                <div class="mb-3">
                  <label for="orderType" class="form-label">"""),_display_(/*116.62*/Messages("history.modal.order.type")),format.raw/*116.98*/("""</label>
                  <input type="text" class="form-control" id="orderTypeReadonly" readonly>
                </div>
                <div class="mb-3">
                  <label for="orderMethod" class="form-label">"""),_display_(/*120.64*/Messages("history.modal.receive.method")),format.raw/*120.104*/("""</label>
                  <input type="text" class="form-control" id="orderMethodReadonly" readonly>
                </div>
                <div class="mb-3">
                  <label for="recipientPhone" class="form-label">"""),_display_(/*124.67*/Messages("history.modal.phone.number")),format.raw/*124.105*/("""</label>
                  <input type="text" class="form-control" id="recipientPhoneReadonly" readonly>
                </div>
              </div>
    
              <!-- Cột 3 -->
              <div class="col-md-4">
                <div class="mb-3">
                  <label for="orderStatus" class="form-label">"""),_display_(/*132.64*/Messages("history.modal.status")),format.raw/*132.96*/("""</label>
                  <input type="text" class="form-control" id="orderStatusReadonly" readonly>
                </div>
                <div class="mb-3">
                  <label for="bussinessName" class="form-label">"""),_display_(/*136.66*/Messages("history.modal.company")),format.raw/*136.99*/("""</label>
                  <input type="text" class="form-control" id="bussinessNameReadonly" readonly>
                </div>
                <div class="mb-3">
                  <label for="recipientAddress" class="form-label">"""),_display_(/*140.69*/Messages("history.modal.delivery.address")),format.raw/*140.111*/("""</label>
                  <input type="text" class="form-control" id="recipientAddressReadonly" readonly>
                </div>
              </div>
            </div>
    
            <!-- Bảng sản phẩm -->
            <div class="table-responsive mt-4">
              <h6 class="fw-bold mb-2">"""),_display_(/*148.41*/Messages("history.modal.product.list")),format.raw/*148.79*/("""</h6>
              <table id="orderProductTable" class="table table-bordered table-striped">
                <thead style="background-color: #FBCCD6;">
                </thead>
                <tbody>
                  <!-- Nội dung sẽ được đổ từ JavaScript -->
                </tbody>
              </table>
            </div>
            <div class="row pagination-section px-2">
            <div class="col-md-4 d-flex align-items-center justify-content-center justify-content-md-start mb-3">
              <p class="mb-0">"""),_display_(/*159.32*/Messages("history.total")),format.raw/*159.57*/(""" """),format.raw/*159.58*/("""<span id="total_record">0</span> """),_display_(/*159.92*/Messages("history.records")),format.raw/*159.119*/("""</p>
            </div>
            <div class="col-md-8 d-flex flex-column flex-md-row justify-content-end align-items-center gap-2 gap-md-3 mb-3">
              <div class="dropdown mb-2 mb-md-0">
                <button class="btn btn-sm dropdown-toggle btn-outline-dark" type="button" data-bs-toggle="dropdown"
                  aria-expanded="false" id="countPageSize" style="margin-left: 5px;">
                  10
                </button>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="javascript:applySearchModalDetail(1,10,true)">10</a></li>
                  <li><a class="dropdown-item" href="javascript:applySearchModalDetail(1,50,true)">50</a></li>
                  <li><a class="dropdown-item" href="javascript:applySearchModalDetail(1,100,true)">100</a></li>
                  <li><a class="dropdown-item" href="javascript:applySearchModalDetail(1,200,true)">200</a></li>
                  <li><a class="dropdown-item" href="javascript:applySearchModalDetail(1,500,true)">500</a></li>
                </ul>
              </div>
              <p class="mb-2 mb-md-0">"""),_display_(/*175.40*/Messages("history.records.per.page")),format.raw/*175.76*/("""</p>
              <div id="pagingTable" class="justify-content-md-end"></div>
            </div>
            <div>
              <input type="hidden" name="page" id="page" value="1" />
              <input type="hidden" name="pageSize" id="pageSize" value="10" />
              <input type="hidden" name="isResetPage" id="isResetPage" value="false" />
            </div>
          </div>
          </div>
          <div class="modal-footer">
            <button class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;" data-bs-dismiss="modal">"""),_display_(/*186.118*/Messages("btnClose")),format.raw/*186.138*/("""</button>
          </div>
        </div>
      </div>
    </div>
      """),_display_(/*191.8*/views/*191.13*/.html.telco.Loading()),format.raw/*191.34*/("""

    """),format.raw/*193.5*/("""</div>
      <!--  END OF PAPER WRAP -->

    """),_display_(/*196.6*/views/*196.11*/.html.telco.mainJs()),format.raw/*196.31*/("""

    """),format.raw/*198.5*/("""<script>
      var userId = '"""),_display_(/*199.22*/userId),format.raw/*199.28*/("""';
      var orderType = "";
      var ordersTemp = [];
 
            var imgDefault = '"""),_display_(/*203.32*/routes/*203.38*/.Assets.versioned("images/market/default.png")),format.raw/*203.84*/("""';
            $(document).ready(function () """),format.raw/*204.43*/("""{"""),format.raw/*204.44*/("""
              """),format.raw/*205.15*/("""$("#menu-orderManage").addClass("mm-active");
              $("#menu").metisMenu();
            """),format.raw/*207.13*/("""}"""),format.raw/*207.14*/(""")
            $('#orderDetailModal').on('hidden.bs.modal', function () """),format.raw/*208.70*/("""{"""),format.raw/*208.71*/("""
            """),format.raw/*209.13*/("""orderType = "";
            ordersTemp=[];
            $("#orderDetailModal #pagingTable").empty();
            $("#orderDetailModal #total_record").text('0');
            $('#orderDetailModal [name=page]').val(1);
            $('#orderDetailModal [name=pageSize]').val(10);
            """),format.raw/*215.13*/("""}"""),format.raw/*215.14*/(""");
    </script>
    <script src=""""),_display_(/*217.19*/routes/*217.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*217.84*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*219.19*/routes/*219.25*/.Assets.versioned("javascripts/views/telco/buySim/manageOrder/ManageOrder.js")),format.raw/*219.103*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*220.19*/routes/*220.25*/.Assets.versioned("javascripts/views/telco/buySim/manageOrder/ManageOrder_export.js")),format.raw/*220.110*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*221.19*/routes/*221.25*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/moment.min.js")),format.raw/*221.111*/(""""></script>
    <script src=""""),_display_(/*222.19*/routes/*222.25*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.min.js")),format.raw/*222.138*/(""""></script>
    <script>
      $('.datetimepicker').bootstrapMaterialDatePicker("""),format.raw/*224.56*/("""{"""),format.raw/*224.57*/("""
        """),format.raw/*225.9*/("""format: 'DD/MM/YYYY',
        time: false,
        maxDate: moment()
      """),format.raw/*228.7*/("""}"""),format.raw/*228.8*/(""");
    </script>
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
                  DATE: Mon Sep 22 16:32:51 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/buySim/manageOrder/ManageOrder.scala.html
                  HASH: d7169e16b5cdeea577beba7f9dd877dea7da3c13
                  MATRIX: 676->1|712->31|1060->65|1188->98|1215->99|1383->241|1438->276|1519->330|1534->336|1591->372|1798->553|1812->558|1858->583|1891->589|1931->602|1946->608|2021->662|2087->701|2102->707|2187->771|2241->888|2273->893|2313->906|2328->912|2398->961|2461->997|2476->1003|2572->1078|2636->1115|2651->1121|2788->1236|2854->1275|2869->1281|2956->1347|3022->1386|3037->1392|3112->1446|3201->1509|3215->1514|3277->1555|3310->1562|3324->1567|3376->1598|3409->1604|3505->1673|3519->1678|3606->1744|3643->1754|3982->2066|4031->2094|4087->2123|4144->2159|4200->2188|4257->2224|4313->2253|4372->2291|4428->2320|4489->2360|4545->2389|4604->2427|4660->2456|4713->2488|4769->2517|4820->2547|4876->2576|4930->2609|5331->2983|5377->3008|5406->3009|5467->3043|5516->3070|6622->4149|6679->4185|7383->4862|7444->4901|7715->5144|7773->5180|8020->5399|8078->5435|8329->5658|8392->5698|8735->6013|8793->6049|9042->6270|9105->6310|9359->6536|9420->6574|9766->6892|9820->6924|10073->7149|10128->7182|10386->7412|10451->7454|10777->7752|10837->7790|11394->8319|11441->8344|11471->8345|11533->8379|11583->8406|12745->9540|12803->9576|13392->10136|13435->10156|13535->10229|13550->10234|13593->10255|13627->10261|13701->10308|13716->10313|13758->10333|13792->10339|13850->10369|13878->10375|13995->10464|14011->10470|14079->10516|14153->10561|14183->10562|14227->10577|14352->10673|14382->10674|14482->10745|14512->10746|14554->10759|14870->11046|14900->11047|14963->11082|14979->11088|15060->11147|15142->11201|15158->11207|15259->11285|15340->11338|15356->11344|15464->11429|15545->11482|15561->11488|15670->11574|15728->11604|15744->11610|15880->11723|15989->11803|16019->11804|16056->11813|16159->11888|16188->11889
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|52->20|52->20|52->20|52->20|53->21|53->21|53->21|54->22|54->22|54->22|56->24|56->24|56->24|57->25|57->25|57->25|60->28|60->28|60->28|62->30|62->30|62->30|64->32|66->34|66->34|66->34|68->36|74->42|74->42|75->43|75->43|76->44|76->44|77->45|77->45|78->46|78->46|79->47|79->47|80->48|80->48|81->49|81->49|82->50|82->50|92->60|92->60|92->60|92->60|92->60|108->76|108->76|126->94|126->94|132->100|132->100|136->104|136->104|140->108|140->108|148->116|148->116|152->120|152->120|156->124|156->124|164->132|164->132|168->136|168->136|172->140|172->140|180->148|180->148|191->159|191->159|191->159|191->159|191->159|207->175|207->175|218->186|218->186|223->191|223->191|223->191|225->193|228->196|228->196|228->196|230->198|231->199|231->199|235->203|235->203|235->203|236->204|236->204|237->205|239->207|239->207|240->208|240->208|241->209|247->215|247->215|249->217|249->217|249->217|251->219|251->219|251->219|252->220|252->220|252->220|253->221|253->221|253->221|254->222|254->222|254->222|256->224|256->224|257->225|260->228|260->228
                  -- GENERATED --
              */
          