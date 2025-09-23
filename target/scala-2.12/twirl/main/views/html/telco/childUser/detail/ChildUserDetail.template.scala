
package views.html.telco.childUser.detail

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

object ChildUserDetail extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[User,String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, userId:String, childUserId:String, email:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.69*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("Phân quyền thuê bao")),format.raw/*9.44*/("""</title>
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
    <link href=""""),_display_(/*25.18*/routes/*25.24*/.Assets.versioned("stylesheets/views/telco/role/childUser.css")),format.raw/*25.87*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*29.6*/views/*29.11*/.html.telco.Menu(currentUser, "", userId)),format.raw/*29.52*/("""

    """),_display_(/*31.6*/views/*31.11*/.html.telco.Header(currentUser)),format.raw/*31.42*/("""

    """),format.raw/*33.5*/("""<div class="page-wrapper">
      <div class="page-content">

        """),_display_(/*36.10*/views/*36.15*/.html.telco.childUser.detail.ChildUserDetail_formSearch(currentUser, email)),format.raw/*36.90*/("""

        """),format.raw/*38.9*/("""<div class="card">
          <div class="table-responsive" style="border-radius: 8px;">
            <table class="table table-striped" id="listSubsChildUserTable" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th>STT</th>
                  <th>GPKD</th>
                  <th>Số thuê bao</th>
                  <th>Ngày gán</th>
                  <th style="text-align: center;">Thao tác</th>
                </tr>
              </thead>
              <tbody>
              </tbody>
            </table>
            <h5 id="notiNotData" style="text-align: center;"></h5>
          </div>
          <div class="material-datatables row row-cols-auto g-3" style="margin: 5px; margin-bottom: 10px;" id="divPagingTable">
            <div class="row">
              <div class="col-md-4">
                <div class="dropdown">
                  <button class="btn dropdown-toggle text-white" type="button" data-bs-toggle="dropdown" aria-expanded="false" id="countPageSize" style="background-color: rgb(0 0 0 / 50%);; margin-left: 5px;">10</button>
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

        """),_display_(/*80.10*/views/*80.15*/.html.telco.childUser.detail.ChildUserDetail_import()),format.raw/*80.68*/("""
        """),_display_(/*81.10*/views/*81.15*/.html.telco.childUser.detail.ChildUserDetail_delSub()),format.raw/*81.68*/("""

      """),format.raw/*83.7*/("""</div>

      """),_display_(/*85.8*/views/*85.13*/.html.telco.Loading()),format.raw/*85.34*/("""

    """),format.raw/*87.5*/("""</div>
      <!--  END OF PAPER WRAP -->

    """),_display_(/*90.6*/views/*90.11*/.html.telco.mainJs()),format.raw/*90.31*/("""

    """),format.raw/*92.5*/("""<script>
            var imgDefault = '"""),_display_(/*93.32*/routes/*93.38*/.Assets.versioned("images/market/default.png")),format.raw/*93.84*/("""';
            var userId = '"""),_display_(/*94.28*/userId),format.raw/*94.34*/("""';
            var childUserId = '"""),_display_(/*95.33*/childUserId),format.raw/*95.44*/("""';

            $(document).ready(function () """),format.raw/*97.43*/("""{"""),format.raw/*97.44*/("""
              """),format.raw/*98.15*/("""$("#menu-childUser").addClass("mm-active");
              $("#menu").metisMenu();

              document.getElementById('filesSubs').addEventListener('change', uploadSubs, false);
            """),format.raw/*102.13*/("""}"""),format.raw/*102.14*/(""")
    </script>
    <script src=""""),_display_(/*104.19*/routes/*104.25*/.Assets.versioned("javascripts/importExcel/xlsx.full.min.js")),format.raw/*104.86*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*105.19*/routes/*105.25*/.Assets.versioned("javascripts/importExcel/jszip.js")),format.raw/*105.78*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*106.19*/routes/*106.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*106.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*107.19*/routes/*107.25*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*107.85*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*109.19*/routes/*109.25*/.Assets.versioned("javascripts/views/telco/childUser/detail/ChildUserDetail.js")),format.raw/*109.105*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*110.19*/routes/*110.25*/.Assets.versioned("javascripts/views/telco/childUser/detail/ChildUserDetail_import.js")),format.raw/*110.112*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*111.19*/routes/*111.25*/.Assets.versioned("javascripts/views/telco/childUser/detail/ChildUserDetail_delSub.js")),format.raw/*111.112*/("""" type="text/javascript"></script>

  </body>
</html>
"""))
      }
    }
  }

  def render(currentUser:User,userId:String,childUserId:String,email:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,userId,childUserId,email)

  def f:((User,String,String,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,userId,childUserId,email) => apply(currentUser,userId,childUserId,email)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:52 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/childUser/detail/ChildUserDetail.scala.html
                  HASH: 6b23f3b86bc1366198d8ab6a0b41715e4ff7cd87
                  MATRIX: 674->1|710->31|1076->65|1238->132|1265->133|1433->275|1484->306|1565->360|1580->366|1637->402|1844->583|1858->588|1904->613|1937->619|1977->632|1992->638|2067->692|2133->731|2148->737|2233->801|2287->918|2319->923|2359->936|2374->942|2444->991|2507->1027|2522->1033|2618->1108|2682->1145|2697->1151|2834->1266|2900->1305|2915->1311|2990->1365|3056->1404|3071->1410|3155->1473|3245->1537|3259->1542|3321->1583|3354->1590|3368->1595|3420->1626|3453->1632|3550->1702|3564->1707|3660->1782|3697->1792|5987->4055|6001->4060|6075->4113|6112->4123|6126->4128|6200->4181|6235->4189|6276->4204|6290->4209|6332->4230|6365->4236|6438->4283|6452->4288|6493->4308|6526->4314|6593->4354|6608->4360|6675->4406|6732->4436|6759->4442|6821->4477|6853->4488|6927->4534|6956->4535|6999->4550|7221->4743|7251->4744|7313->4778|7329->4784|7412->4845|7493->4898|7509->4904|7584->4957|7665->5010|7681->5016|7762->5075|7843->5128|7859->5134|7941->5194|8023->5248|8039->5254|8142->5334|8223->5387|8239->5393|8349->5480|8430->5533|8446->5539|8556->5626
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|52->20|52->20|52->20|52->20|53->21|53->21|53->21|54->22|54->22|54->22|56->24|56->24|56->24|57->25|57->25|57->25|61->29|61->29|61->29|63->31|63->31|63->31|65->33|68->36|68->36|68->36|70->38|112->80|112->80|112->80|113->81|113->81|113->81|115->83|117->85|117->85|117->85|119->87|122->90|122->90|122->90|124->92|125->93|125->93|125->93|126->94|126->94|127->95|127->95|129->97|129->97|130->98|134->102|134->102|136->104|136->104|136->104|137->105|137->105|137->105|138->106|138->106|138->106|139->107|139->107|139->107|141->109|141->109|141->109|142->110|142->110|142->110|143->111|143->111|143->111
                  -- GENERATED --
              */
          