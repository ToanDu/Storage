
package views.html.telco.role.account

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

object AccountList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.20*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("Quản lý tài khoản")),format.raw/*9.42*/("""</title>
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

    <link href=""""),_display_(/*24.18*/routes/*24.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*24.78*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*28.6*/views/*28.11*/.html.telco.role.Menu(currentUser)),format.raw/*28.45*/("""

    """),_display_(/*30.6*/views/*30.11*/.html.telco.role.Header(currentUser)),format.raw/*30.47*/("""

    """),format.raw/*32.5*/("""<div class="page-wrapper">
      <div class="page-content">

        """),_display_(/*35.10*/views/*35.15*/.html.telco.role.account.AccountList_search(currentUser)),format.raw/*35.71*/("""

        """),format.raw/*37.9*/("""<div class="card">
          <div class="table-responsive mb-3" style="border-radius: 8px;">
            <table class="table table-striped" id="listAccountsTable" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th>"""),_display_(/*42.24*/Messages("STT")),format.raw/*42.39*/("""</th>
                  <th>"""),_display_(/*43.24*/Messages("Email")),format.raw/*43.41*/("""</th>
                  <th>"""),_display_(/*44.24*/Messages("Họ tên")),format.raw/*44.42*/("""</th>
                  <th>"""),_display_(/*45.24*/Messages("SĐT")),format.raw/*45.39*/("""</th>
                  <th>"""),_display_(/*46.24*/Messages("Quyền TK")),format.raw/*46.44*/("""</th>
                  """),_display_(/*47.20*/if(currentUser.getCmpRole != User.CmpRole.SUPER_ENTERPRISE.getCode())/*47.89*/{_display_(Seq[Any](format.raw/*47.90*/("""
                    """),format.raw/*48.21*/("""<th style="text-align: center;">"""),_display_(/*48.54*/Messages("Sửa quyền")),format.raw/*48.75*/("""</th>
                  """)))}),format.raw/*49.20*/("""
                  """),format.raw/*50.19*/("""<th style="text-align: center;">"""),_display_(/*50.52*/Messages("Thao tác")),format.raw/*50.72*/("""</th>
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

      """),_display_(/*84.8*/views/*84.13*/.html.telco.role.account.AccountList_add(currentUser)),format.raw/*84.66*/("""
      """),_display_(/*85.8*/views/*85.13*/.html.telco.role.account.AccountList_add_import()),format.raw/*85.62*/("""
      """),_display_(/*86.8*/views/*86.13*/.html.telco.role.account.AccountList_add_enterprise()),format.raw/*86.66*/("""
      """),_display_(/*87.8*/views/*87.13*/.html.telco.role.account.AccountList_genPass()),format.raw/*87.59*/("""
      """),_display_(/*88.8*/views/*88.13*/.html.telco.role.account.AccountList_genPass_comfirm()),format.raw/*88.67*/("""
      """),_display_(/*89.8*/views/*89.13*/.html.telco.role.account.AccountList_info()),format.raw/*89.56*/("""
      """),_display_(/*90.8*/views/*90.13*/.html.telco.role.account.AccountList_del()),format.raw/*90.55*/("""
      """),_display_(/*91.8*/views/*91.13*/.html.telco.role.account.AccountList_editRole()),format.raw/*91.60*/("""

      """),_display_(/*93.8*/views/*93.13*/.html.telco.Loading()),format.raw/*93.34*/("""

    """),format.raw/*95.5*/("""</div>

    """),_display_(/*97.6*/views/*97.11*/.html.telco.mainJs()),format.raw/*97.31*/("""

    """),format.raw/*99.5*/("""<script>
            var imgDefault = '"""),_display_(/*100.32*/routes/*100.38*/.Assets.versioned("images/market/default.png")),format.raw/*100.84*/("""';
            var roleCmp = '"""),_display_(/*101.29*/User/*101.33*/.CmpRole.getNameByCode(currentUser.getCmpRole)),format.raw/*101.79*/("""';
            console.log(roleCmp);
            $(document).ready(function () """),format.raw/*103.43*/("""{"""),format.raw/*103.44*/("""
              """),format.raw/*104.15*/("""$("#menu-accountList").addClass("mm-active");
              $("#menu").metisMenu();

              $('.datetimepicker').bootstrapMaterialDatePicker("""),format.raw/*107.64*/("""{"""),format.raw/*107.65*/("""
                """),format.raw/*108.17*/("""format: 'DD/MM/YYYY',
                time: false
              """),format.raw/*110.15*/("""}"""),format.raw/*110.16*/(""");

              document.getElementById('filesAddEnterprise').addEventListener('change', uploadListEnterprise, false);

            """),format.raw/*114.13*/("""}"""),format.raw/*114.14*/(""")
    </script>
    <script src=""""),_display_(/*116.19*/routes/*116.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*116.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*117.19*/routes/*117.25*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*117.85*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*118.19*/routes/*118.25*/.Assets.versioned("javascripts/exportfile/alasql.min.js")),format.raw/*118.82*/("""" type="text/javascript"></script>

    """),format.raw/*120.126*/("""
    """),format.raw/*121.5*/("""<script src=""""),_display_(/*121.19*/routes/*121.25*/.Assets.versioned("javascripts/views/telco/role/accountList/roleAccountCmp.js")),format.raw/*121.104*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*122.19*/routes/*122.25*/.Assets.versioned("javascripts/views/telco/role/accountList/accountList.js")),format.raw/*122.101*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*123.19*/routes/*123.25*/.Assets.versioned("javascripts/views/telco/role/accountList/accountList_add.js")),format.raw/*123.105*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*124.19*/routes/*124.25*/.Assets.versioned("javascripts/views/telco/role/accountList/accountList_export.js")),format.raw/*124.108*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*125.19*/routes/*125.25*/.Assets.versioned("javascripts/views/telco/role/accountList/accountList_info.js")),format.raw/*125.106*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*126.19*/routes/*126.25*/.Assets.versioned("javascripts/views/telco/role/accountList/accountList_del.js")),format.raw/*126.105*/("""" type="text/javascript"></script>

  </body>
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
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/account/AccountList.scala.html
                  HASH: 77a97dd51e67a6a0823f19ac0b2ddc17dad77576
                  MATRIX: 670->1|706->31|1047->65|1160->83|1187->84|1355->226|1404->255|1485->309|1500->315|1557->351|1764->532|1778->537|1824->562|1857->568|1897->581|1912->587|1987->641|2053->680|2068->686|2153->750|2207->867|2239->872|2279->885|2294->891|2364->940|2427->976|2442->982|2538->1057|2602->1094|2617->1100|2754->1215|2820->1254|2835->1260|2910->1314|3000->1378|3014->1383|3069->1417|3102->1424|3116->1429|3173->1465|3206->1471|3303->1541|3317->1546|3394->1602|3431->1612|3744->1898|3780->1913|3836->1942|3874->1959|3930->1988|3969->2006|4025->2035|4061->2050|4117->2079|4158->2099|4210->2124|4288->2193|4327->2194|4376->2215|4436->2248|4478->2269|4534->2294|4581->2313|4641->2346|4682->2366|6514->4172|6528->4177|6602->4230|6636->4238|6650->4243|6720->4292|6754->4300|6768->4305|6842->4358|6876->4366|6890->4371|6957->4417|6991->4425|7005->4430|7080->4484|7114->4492|7128->4497|7192->4540|7226->4548|7240->4553|7303->4595|7337->4603|7351->4608|7419->4655|7454->4664|7468->4669|7510->4690|7543->4696|7582->4709|7596->4714|7637->4734|7670->4740|7738->4780|7754->4786|7822->4832|7881->4863|7895->4867|7963->4913|8071->4992|8101->4993|8145->5008|8322->5156|8352->5157|8398->5174|8491->5238|8521->5239|8684->5373|8714->5374|8776->5408|8792->5414|8873->5473|8954->5526|8970->5532|9052->5592|9133->5645|9149->5651|9228->5708|9298->5869|9331->5874|9373->5888|9389->5894|9491->5973|9572->6026|9588->6032|9687->6108|9768->6161|9784->6167|9887->6247|9968->6300|9984->6306|10090->6389|10171->6442|10187->6448|10291->6529|10372->6582|10388->6588|10491->6668
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|52->20|52->20|52->20|52->20|53->21|53->21|53->21|54->22|54->22|54->22|56->24|56->24|56->24|60->28|60->28|60->28|62->30|62->30|62->30|64->32|67->35|67->35|67->35|69->37|74->42|74->42|75->43|75->43|76->44|76->44|77->45|77->45|78->46|78->46|79->47|79->47|79->47|80->48|80->48|80->48|81->49|82->50|82->50|82->50|116->84|116->84|116->84|117->85|117->85|117->85|118->86|118->86|118->86|119->87|119->87|119->87|120->88|120->88|120->88|121->89|121->89|121->89|122->90|122->90|122->90|123->91|123->91|123->91|125->93|125->93|125->93|127->95|129->97|129->97|129->97|131->99|132->100|132->100|132->100|133->101|133->101|133->101|135->103|135->103|136->104|139->107|139->107|140->108|142->110|142->110|146->114|146->114|148->116|148->116|148->116|149->117|149->117|149->117|150->118|150->118|150->118|152->120|153->121|153->121|153->121|153->121|154->122|154->122|154->122|155->123|155->123|155->123|156->124|156->124|156->124|157->125|157->125|157->125|158->126|158->126|158->126
                  -- GENERATED --
              */
          