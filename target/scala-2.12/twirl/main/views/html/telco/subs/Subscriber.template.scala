
package views.html.telco.subs

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
/*3.2*/import vn.m2m.utils.UserHelper

object Subscriber extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(currentUser:User, userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.35*/("""
"""),format.raw/*5.1*/("""<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("subscriber.title")),format.raw/*9.41*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*17.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("assets/plugins/input-tags/css/tagsinput.css")),format.raw/*18.88*/("""" rel="stylesheet" />
    """),format.raw/*19.96*/("""
      """),format.raw/*20.7*/("""<link href='"""),_display_(/*20.20*/routes/*20.26*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*20.75*/("""' type='text/css'>
      <link href=""""),_display_(/*21.20*/routes/*21.26*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*21.101*/("""" rel="stylesheet">
    <link href=""""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*22.139*/("""" rel="stylesheet" >
    """),format.raw/*23.104*/("""
    """),format.raw/*24.5*/("""<link href=""""),_display_(/*24.18*/routes/*24.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*24.78*/("""" rel="stylesheet" />
  </head>
  <body class="bg-theme">
    """),_display_(/*27.6*/views/*27.11*/.html.telco.Menu(currentUser, "", userId)),format.raw/*27.52*/("""

    """),_display_(/*29.6*/views/*29.11*/.html.telco.Header(currentUser)),format.raw/*29.42*/("""
    """),format.raw/*30.5*/("""<div style="background-color: #ff4d4f;color: white;font-weight: bold;padding: 8px 16px;text-align: center;z-index: 999;">

    </div>
    <div class="page-wrapper">
      <div class="page-content">
        """),_display_(/*35.10*/views/*35.15*/.html.telco.subs.Subscriber_formSearch(currentUser)),format.raw/*35.66*/("""

        """),format.raw/*37.9*/("""<div class="card">
          <div class="table-responsive mb-3" style="border-radius: 8px;">
            <table class="table table-striped" id="listSubsTable" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th>"""),_display_(/*42.24*/Messages("subscriber.stt")),format.raw/*42.50*/("""</th>
                  <th>"""),_display_(/*43.24*/Messages("subscriber.phoneNumber")),format.raw/*43.58*/("""</th>
                  <th>"""),_display_(/*44.24*/Messages("subscriber.subscriberCode")),format.raw/*44.61*/("""</th>
                  <th>"""),_display_(/*45.24*/Messages("subscriber.servicePackage")),format.raw/*45.61*/("""</th>
                  <th>"""),_display_(/*46.24*/Messages("subscriber.promotionCode")),format.raw/*46.60*/("""</th>
                  <th>"""),_display_(/*47.24*/Messages("subscriber.contractCode")),format.raw/*47.59*/("""</th>
                  <th>"""),_display_(/*48.24*/Messages("subscriber.customerCode")),format.raw/*48.59*/("""</th>
                  <th>"""),_display_(/*49.24*/Messages("subscriber.simSerial")),format.raw/*49.56*/("""</th>
                  <th>"""),_display_(/*50.24*/Messages("subscriber.blockStatus")),format.raw/*50.58*/("""</th>
                  <th>"""),_display_(/*51.24*/Messages("subscriber.activation")),format.raw/*51.57*/("""</th>
                  <th>"""),_display_(/*52.24*/Messages("subscriber.connection")),format.raw/*52.57*/("""</th>
                  <th>"""),_display_(/*53.24*/Messages("subscriber.serviceType")),format.raw/*53.58*/("""</th>
                  """),_display_(/*54.20*/if(UserHelper.isFeatureRole(currentUser, "view_data_sub"))/*54.78*/{_display_(Seq[Any](format.raw/*54.79*/("""
                    """),format.raw/*55.21*/("""<th style="text-align: center">"""),_display_(/*55.53*/Messages("subscriber.check")),format.raw/*55.81*/("""</th>
                  """)))}),format.raw/*56.20*/("""
                """),format.raw/*57.17*/("""</tr>
              </thead>
              <tbody></tbody>
            </table>
            <h5 id="notiNotDataSubs" style="text-align: center;"></h5>
          </div>
          <div class="material-datatables row row-cols-auto g-3" style="margin-bottom: 5px; margin-bottom: 10px; display: none;" id="divPagingTable">
            <div class="row">
              <div class="col-md-4">
                <div class="dropdown">
                  <button class="btn dropdown-toggle text-white" type="button" data-bs-toggle="dropdown" aria-expanded="false" id="countPageSize" style="background-color: rgb(0 0 0 / 50%); margin-left: 5px;">10</button>
                  <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="javascript:ApplyFilter(1,10,true)">10</a></li>
                    <li><a class="dropdown-item" href="javascript:ApplyFilter(1,50,true)">50</a></li>
                    <li><a class="dropdown-item" href="javascript:ApplyFilter(1,100,true)">100</a></li>
                    <li><a class="dropdown-item" href="javascript:ApplyFilter(1,200,true)">200</a></li>
                    <li><a class="dropdown-item" href="javascript:ApplyFilter(1,500,true)">500</a></li>
                  </ul>
                </div>
              </div>
              <div class="col-md-8">
                <div class="dataTables_paginate paging_full_numbers" id="pagingTable" style="cursor: pointer; right: 5px; position: absolute;"></div>
              </div>
            </div>

            <input name="page" id="page" value="1" style="display: none">
            <input name="pageSize" id="pageSize" value="10" style="display: none">
            <input name="isResetPage" id="isResetPage" value="false" style="display: none">
          </div>
      </div>

      """),format.raw/*88.41*/("""
        """),format.raw/*89.172*/("""
        """),format.raw/*90.19*/("""
      """),format.raw/*91.17*/("""

      """),_display_(/*93.8*/views/*93.13*/.html.telco.subs.Subscriber_search()),format.raw/*93.49*/("""
      """),_display_(/*94.8*/views/*94.13*/.html.telco.subs.Subscriber_info()),format.raw/*94.47*/("""
      """),_display_(/*95.8*/views/*95.13*/.html.telco.subs.Subscriber_formSearch_importTB()),format.raw/*95.62*/("""
      """),_display_(/*96.8*/views/*96.13*/.html.telco.subs.Subscriber_formSearch_importSerial()),format.raw/*96.66*/("""
      """),_display_(/*97.8*/views/*97.13*/.html.telco.subs.Subscriber_formSearch_importAccount()),format.raw/*97.67*/("""
      """),_display_(/*98.8*/views/*98.13*/.html.telco.subs.Subscriber_export()),format.raw/*98.49*/("""
      """),_display_(/*99.8*/views/*99.13*/.html.telco.role.account.InfoDataAccount()),format.raw/*99.55*/("""
      """),_display_(/*100.8*/views/*100.13*/.html.telco.Loading()),format.raw/*100.34*/("""
        """),format.raw/*101.9*/("""<div id="zaloButton" class="zalo-chat-widget" data-oaid="1814378069399742003" data-welcome-message=""""),_display_(/*101.110*/Messages("zalo.welcome.message")),format.raw/*101.142*/("""" data-autopopup="1" data-width="350" data-height="420">
        <script src="https://sp.zalo.me/plugins/sdk.js"></script>

            <!-- JavaScript để di chuyển nút -->
        <script>
                // Lấy phần tử Zalo Button
                var zaloButton = document.getElementById("zaloButton");

                // Hàm xử lý sự kiện di chuyển
                function dragElement(elmnt) """),format.raw/*110.45*/("""{"""),format.raw/*110.46*/("""
                    """),format.raw/*111.21*/("""var pos1 = 0, pos2 = 0, pos3 = 0, pos4 = 0;
                    elmnt.onmousedown = dragMouseDown;

                    function dragMouseDown(e) """),format.raw/*114.47*/("""{"""),format.raw/*114.48*/("""
                        """),format.raw/*115.25*/("""e = e || window.event;
                        e.preventDefault();
                        // Lấy vị trí ban đầu của con trỏ
                        pos3 = e.clientX;
                        pos4 = e.clientY;
                        document.onmouseup = closeDragElement;
                        document.onmousemove = elementDrag;
                    """),format.raw/*122.21*/("""}"""),format.raw/*122.22*/("""

                    """),format.raw/*124.21*/("""function elementDrag(e) """),format.raw/*124.45*/("""{"""),format.raw/*124.46*/("""
                        """),format.raw/*125.25*/("""e = e || window.event;
                        e.preventDefault();
                        // Tính toán vị trí mới của con trỏ
                        pos1 = pos3 - e.clientX;
                        pos2 = pos4 - e.clientY;
                        pos3 = e.clientX;
                        pos4 = e.clientY;
                        // Đặt lại vị trí của phần tử
                        elmnt.style.top = (elmnt.offsetTop - pos2) + "px";
                        elmnt.style.left = (elmnt.offsetLeft - pos1) + "px";
                    """),format.raw/*135.21*/("""}"""),format.raw/*135.22*/("""

                    """),format.raw/*137.21*/("""function closeDragElement() """),format.raw/*137.49*/("""{"""),format.raw/*137.50*/("""
                        """),format.raw/*138.25*/("""// Dừng di chuyển khi nhả chuột
                        document.onmouseup = null;
                        document.onmousemove = null;
                    """),format.raw/*141.21*/("""}"""),format.raw/*141.22*/("""
                """),format.raw/*142.17*/("""}"""),format.raw/*142.18*/("""

                """),format.raw/*144.17*/("""// Kích hoạt hàm drag cho nút Zalo OA
                dragElement(zaloButton);
        </script>
    </div>
      <!--  END OF PAPER WRAP -->

    """),_display_(/*150.6*/views/*150.11*/.html.telco.mainJs()),format.raw/*150.31*/("""

    """),format.raw/*152.5*/("""<script>
            var imgDefault = '"""),_display_(/*153.32*/routes/*153.38*/.Assets.versioned("images/market/default.png")),format.raw/*153.84*/("""';
            var userId = '"""),_display_(/*154.28*/userId),format.raw/*154.34*/("""';
            var view_sub = '"""),_display_(/*155.30*/UserHelper/*155.40*/.isFeatureRole(currentUser, "view_sub")),format.raw/*155.79*/("""';
            var view_detail_sub = '"""),_display_(/*156.37*/UserHelper/*156.47*/.isFeatureRole(currentUser, "view_detail_sub")),format.raw/*156.93*/("""';
            var view_data_sub = '"""),_display_(/*157.35*/UserHelper/*157.45*/.isFeatureRole(currentUser, "view_data_sub")),format.raw/*157.89*/("""';

            $(document).ready(function () """),format.raw/*159.43*/("""{"""),format.raw/*159.44*/("""
              """),format.raw/*160.15*/("""$("#menu-subscriberManage").addClass("mm-active");
              $("#menu").metisMenu();

              $('.datetimepicker').bootstrapMaterialDatePicker("""),format.raw/*163.64*/("""{"""),format.raw/*163.65*/("""
                """),format.raw/*164.17*/("""format: 'DD/MM/YYYY',
                time: false
              """),format.raw/*166.15*/("""}"""),format.raw/*166.16*/(""");

              document.getElementById('filesSearchSubs').addEventListener('change', uploadSearchSubs, false);
              document.getElementById('filesSearchSerial').addEventListener('change', uploadSearchSerial, false);
              document.getElementById('filesSearchAccount').addEventListener('change', uploadSearchAccount, false);

            """),format.raw/*172.13*/("""}"""),format.raw/*172.14*/(""")
    </script>
    <script src=""""),_display_(/*174.19*/routes/*174.25*/.Assets.versioned("assets/plugins/input-tags/js/tagsinput.js")),format.raw/*174.87*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*175.19*/routes/*175.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*175.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*176.19*/routes/*176.25*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*176.85*/("""" type="text/javascript"></script>
    """),format.raw/*177.96*/("""

    """),format.raw/*179.5*/("""<script src=""""),_display_(/*179.19*/routes/*179.25*/.Assets.versioned("javascripts/views/telco/subs/subscriber_listGpkd.js")),format.raw/*179.97*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*180.19*/routes/*180.25*/.Assets.versioned("javascripts/views/telco/subs/subscriber.js")),format.raw/*180.88*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*181.19*/routes/*181.25*/.Assets.versioned("javascripts/views/telco/subs/subscriber_listProductOffering.js")),format.raw/*181.108*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*182.19*/routes/*182.25*/.Assets.versioned("javascripts/views/telco/subs/subscriber_info.js")),format.raw/*182.93*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*183.19*/routes/*183.25*/.Assets.versioned("javascripts/views/telco/subs/subscriber_export.js")),format.raw/*183.95*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*184.19*/routes/*184.25*/.Assets.versioned("javascripts/views/telco/subs/subscriber_export_subs.js")),format.raw/*184.100*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*185.19*/routes/*185.25*/.Assets.versioned("javascripts/views/telco/subs/subscriber_export_serial.js")),format.raw/*185.102*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*186.19*/routes/*186.25*/.Assets.versioned("javascripts/views/telco/subs/subscriber_importSearch.js")),format.raw/*186.101*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*187.19*/routes/*187.25*/.Assets.versioned("javascripts/views/telco/subs/subscriber_importSearchSerial.js")),format.raw/*187.107*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*188.19*/routes/*188.25*/.Assets.versioned("javascripts/views/telco/subs/subscriber_importSearchAccount.js")),format.raw/*188.108*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*189.19*/routes/*189.25*/.Assets.versioned("javascripts/views/telco/subs/subscriber_search_byVht.js")),format.raw/*189.101*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*190.19*/routes/*190.25*/.Assets.versioned("javascripts/views/telco/role/accountList/infoDataAccount.js")),format.raw/*190.105*/("""" type="text/javascript"></script>

    """),format.raw/*194.8*/("""

  """),format.raw/*196.3*/("""</body>
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
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/subs/Subscriber.scala.html
                  HASH: fc2b37f6e31a61e992d95c473cac353ac216ae39
                  MATRIX: 662->1|698->31|738->65|1083->97|1211->130|1238->131|1390->257|1438->285|1519->339|1534->345|1591->381|1798->562|1812->567|1858->592|1891->598|1931->611|1946->617|2021->671|2087->710|2102->716|2187->780|2241->897|2275->904|2315->917|2330->923|2400->972|2465->1010|2480->1016|2577->1091|2641->1128|2656->1134|2793->1249|2847->1373|2879->1378|2919->1391|2934->1397|3009->1451|3098->1514|3112->1519|3174->1560|3207->1567|3221->1572|3273->1603|3305->1608|3539->1815|3553->1820|3625->1871|3662->1881|3971->2163|4018->2189|4074->2218|4129->2252|4185->2281|4243->2318|4299->2347|4357->2384|4413->2413|4470->2449|4526->2478|4582->2513|4638->2542|4694->2577|4750->2606|4803->2638|4859->2667|4914->2701|4970->2730|5024->2763|5080->2792|5134->2825|5190->2854|5245->2888|5297->2913|5364->2971|5403->2972|5452->2993|5511->3025|5560->3053|5616->3078|5661->3095|7476->4916|7514->5088|7551->5107|7586->5124|7621->5133|7635->5138|7692->5174|7726->5182|7740->5187|7795->5221|7829->5229|7843->5234|7913->5283|7947->5291|7961->5296|8035->5349|8069->5357|8083->5362|8158->5416|8192->5424|8206->5429|8263->5465|8297->5473|8311->5478|8374->5520|8409->5528|8424->5533|8467->5554|8504->5563|8634->5664|8689->5696|9115->6093|9145->6094|9195->6115|9370->6261|9400->6262|9454->6287|9835->6639|9865->6640|9916->6662|9969->6686|9999->6687|10053->6712|10617->7247|10647->7248|10698->7270|10755->7298|10785->7299|10839->7324|11024->7480|11054->7481|11100->7498|11130->7499|11177->7517|11352->7665|11367->7670|11409->7690|11443->7696|11511->7736|11527->7742|11595->7788|11653->7818|11681->7824|11741->7856|11761->7866|11822->7905|11889->7944|11909->7954|11977->8000|12042->8037|12062->8047|12128->8091|12203->8137|12233->8138|12277->8153|12459->8306|12489->8307|12535->8324|12628->8388|12658->8389|13044->8746|13074->8747|13136->8781|13152->8787|13236->8849|13317->8902|13333->8908|13414->8967|13495->9020|13511->9026|13593->9086|13661->9216|13695->9222|13737->9236|13753->9242|13847->9314|13928->9367|13944->9373|14029->9436|14110->9489|14126->9495|14232->9578|14313->9631|14329->9637|14419->9705|14500->9758|14516->9764|14608->9834|14689->9887|14705->9893|14803->9968|14884->10021|14900->10027|15000->10104|15081->10157|15097->10163|15196->10239|15277->10292|15293->10298|15398->10380|15479->10433|15495->10439|15601->10522|15682->10575|15698->10581|15797->10657|15878->10710|15894->10716|15997->10796|16065->11078|16097->11082
                  LINES: 24->1|25->2|26->3|31->4|36->4|37->5|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|52->20|52->20|52->20|52->20|53->21|53->21|53->21|54->22|54->22|54->22|55->23|56->24|56->24|56->24|56->24|59->27|59->27|59->27|61->29|61->29|61->29|62->30|67->35|67->35|67->35|69->37|74->42|74->42|75->43|75->43|76->44|76->44|77->45|77->45|78->46|78->46|79->47|79->47|80->48|80->48|81->49|81->49|82->50|82->50|83->51|83->51|84->52|84->52|85->53|85->53|86->54|86->54|86->54|87->55|87->55|87->55|88->56|89->57|120->88|121->89|122->90|123->91|125->93|125->93|125->93|126->94|126->94|126->94|127->95|127->95|127->95|128->96|128->96|128->96|129->97|129->97|129->97|130->98|130->98|130->98|131->99|131->99|131->99|132->100|132->100|132->100|133->101|133->101|133->101|142->110|142->110|143->111|146->114|146->114|147->115|154->122|154->122|156->124|156->124|156->124|157->125|167->135|167->135|169->137|169->137|169->137|170->138|173->141|173->141|174->142|174->142|176->144|182->150|182->150|182->150|184->152|185->153|185->153|185->153|186->154|186->154|187->155|187->155|187->155|188->156|188->156|188->156|189->157|189->157|189->157|191->159|191->159|192->160|195->163|195->163|196->164|198->166|198->166|204->172|204->172|206->174|206->174|206->174|207->175|207->175|207->175|208->176|208->176|208->176|209->177|211->179|211->179|211->179|211->179|212->180|212->180|212->180|213->181|213->181|213->181|214->182|214->182|214->182|215->183|215->183|215->183|216->184|216->184|216->184|217->185|217->185|217->185|218->186|218->186|218->186|219->187|219->187|219->187|220->188|220->188|220->188|221->189|221->189|221->189|222->190|222->190|222->190|224->194|226->196
                  -- GENERATED --
              */
          