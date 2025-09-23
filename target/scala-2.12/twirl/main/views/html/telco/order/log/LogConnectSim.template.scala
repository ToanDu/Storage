
package views.html.telco.order.log

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

object LogConnectSim extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("Lịch sử đấu nối")),format.raw/*9.40*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*17.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("assets/plugins/input-tags/css/tagsinput.css")),format.raw/*18.88*/("""" rel="stylesheet" />
    """),format.raw/*19.96*/("""
    """),format.raw/*20.5*/("""<link href='"""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*20.73*/("""' type='text/css'>
    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*21.139*/("""" rel="stylesheet" >

    <link href=""""),_display_(/*23.18*/routes/*23.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*23.78*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*27.6*/views/*27.11*/.html.telco.Menu(currentUser, "", userId)),format.raw/*27.52*/("""

    """),_display_(/*29.6*/views/*29.11*/.html.telco.Header(currentUser)),format.raw/*29.42*/("""

    """),format.raw/*31.5*/("""<div class="page-wrapper">
      <div class="page-content">

        """),_display_(/*34.10*/views/*34.15*/.html.telco.order.log.LogConnectSim_search()),format.raw/*34.59*/("""

        """),format.raw/*36.9*/("""<div class="card">
          <div class="table-responsive mb-3" style="border-radius: 8px;">
            <table class="table table-striped" id="listLogsTable" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th>"""),_display_(/*41.24*/Messages("STT")),format.raw/*41.39*/("""</th>
                  <th>"""),_display_(/*42.24*/Messages("Người dùng")),format.raw/*42.46*/("""</th>
                  <th>"""),_display_(/*43.24*/Messages("OrderID")),format.raw/*43.43*/("""</th>
                  <th>"""),_display_(/*44.24*/Messages("ISDN")),format.raw/*44.40*/("""</th>
                  <th>"""),_display_(/*45.24*/Messages("Loại")),format.raw/*45.40*/("""</th>
                  <th>"""),_display_(/*46.24*/Messages("Đơn giá")),format.raw/*46.43*/("""</th>
                  <th>"""),_display_(/*47.24*/Messages("ID Thanh toán")),format.raw/*47.49*/("""</th>
                  <th>"""),_display_(/*48.24*/Messages("Kết quả")),format.raw/*48.43*/("""</th>
                  <th>"""),_display_(/*49.24*/Messages("Ghi chú")),format.raw/*49.43*/("""</th>
                  <th>"""),_display_(/*50.24*/Messages("Thời gian")),format.raw/*50.45*/("""</th>
                </tr>
              </thead>
              <tbody></tbody>
            </table>
            <h5 id="notiNotData" style="text-align: center;"></h5>
          </div>
          <div class="material-datatables row row-cols-auto g-3" style="margin-bottom: 5px; margin-right: 10px;" id="divPagingTable">
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

      </div>

      """),_display_(/*84.8*/views/*84.13*/.html.telco.Loading()),format.raw/*84.34*/("""

    """),format.raw/*86.5*/("""</div>

    """),_display_(/*88.6*/views/*88.11*/.html.telco.mainJs()),format.raw/*88.31*/("""

    """),format.raw/*90.5*/("""<script>
            var imgDefault = '"""),_display_(/*91.32*/routes/*91.38*/.Assets.versioned("images/market/default.png")),format.raw/*91.84*/("""';
            var roleCmp = '"""),_display_(/*92.29*/User/*92.33*/.CmpRole.getNameByCode(currentUser.getCmpRole)),format.raw/*92.79*/("""';
            console.log(roleCmp);
            var userId = '"""),_display_(/*94.28*/userId),format.raw/*94.34*/("""';
            $(document).ready(function () """),format.raw/*95.43*/("""{"""),format.raw/*95.44*/("""
              """),format.raw/*96.15*/("""$("#menu-logConnectSim").addClass("mm-active");
              $("#menu").metisMenu();
            """),format.raw/*98.13*/("""}"""),format.raw/*98.14*/(""")
    </script>
    <script src=""""),_display_(/*100.19*/routes/*100.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*100.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*101.19*/routes/*101.25*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*101.85*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*103.19*/routes/*103.25*/.Assets.versioned("javascripts/views/telco/order/log/LogConnectSim.js")),format.raw/*103.96*/("""" type="text/javascript"></script>

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
                  DATE: Mon Sep 22 16:32:53 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/order/log/LogConnectSim.scala.html
                  HASH: 0fb34f1fbd1e5ac30f237b524e35acc70cad63dd
                  MATRIX: 667->1|703->31|1053->65|1181->98|1208->99|1376->241|1423->268|1504->322|1519->328|1576->364|1783->545|1797->550|1843->575|1876->581|1916->594|1931->600|2006->654|2072->693|2087->699|2172->763|2226->880|2258->885|2298->898|2313->904|2383->953|2446->989|2461->995|2598->1110|2664->1149|2679->1155|2754->1209|2844->1273|2858->1278|2920->1319|2953->1326|2967->1331|3019->1362|3052->1368|3149->1438|3163->1443|3228->1487|3265->1497|3574->1779|3610->1794|3666->1823|3709->1845|3765->1874|3805->1893|3861->1922|3898->1938|3954->1967|3991->1983|4047->2012|4087->2031|4143->2060|4189->2085|4245->2114|4285->2133|4341->2162|4381->2181|4437->2210|4479->2231|6311->4037|6325->4042|6367->4063|6400->4069|6439->4082|6453->4087|6494->4107|6527->4113|6594->4153|6609->4159|6676->4205|6734->4236|6747->4240|6814->4286|6905->4350|6932->4356|7005->4401|7034->4402|7077->4417|7203->4515|7232->4516|7294->4550|7310->4556|7391->4615|7472->4668|7488->4674|7570->4734|7652->4788|7668->4794|7761->4865
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|52->20|52->20|52->20|52->20|53->21|53->21|53->21|55->23|55->23|55->23|59->27|59->27|59->27|61->29|61->29|61->29|63->31|66->34|66->34|66->34|68->36|73->41|73->41|74->42|74->42|75->43|75->43|76->44|76->44|77->45|77->45|78->46|78->46|79->47|79->47|80->48|80->48|81->49|81->49|82->50|82->50|116->84|116->84|116->84|118->86|120->88|120->88|120->88|122->90|123->91|123->91|123->91|124->92|124->92|124->92|126->94|126->94|127->95|127->95|128->96|130->98|130->98|132->100|132->100|132->100|133->101|133->101|133->101|135->103|135->103|135->103
                  -- GENERATED --
              */
          