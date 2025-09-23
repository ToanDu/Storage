
package views.html.telco.admin

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

object ApprovedInfoCompany extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("Duyệt thông tin DN")),format.raw/*9.43*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*17.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("stylesheets/views/telco/admin/ApprovedInfo.css")),format.raw/*18.91*/("""" rel="stylesheet" />

    <style>
            .form-control:disabled, .form-control:focus """),format.raw/*21.57*/("""{"""),format.raw/*21.58*/("""
              """),format.raw/*22.15*/("""color: #333333;
            """),format.raw/*23.13*/("""}"""),format.raw/*23.14*/("""
    """),format.raw/*24.5*/("""</style>

  </head>
  <body class="bg-theme">
    """),_display_(/*28.6*/views/*28.11*/.html.telco.role.Menu(currentUser)),format.raw/*28.45*/("""

    """),_display_(/*30.6*/views/*30.11*/.html.telco.role.Header(currentUser)),format.raw/*30.47*/("""

    """),format.raw/*32.5*/("""<div class="page-wrapper">
      <div class="page-content">
        """),_display_(/*34.10*/views/*34.15*/.html.telco.admin.ApprovedInfoCompany_search(currentUser)),format.raw/*34.72*/("""
        """),format.raw/*35.9*/("""<div class="card" >
          <div class="table-responsive" id="tabListInfoCompany" style="border-radius: 8px;">
            <table class="table table-striped" id="tableListInfoCompany" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th>STT</th>
                  <th>Email</th>
                  <th>SĐT</th>
                  <th hidden>Tên DN</th>
                  <th hidden>GPKD</th>
                  <th hidden>Mã số thuế</th>
                  <th hidden>Địa chỉ</th>
                  <th>Quyền</th>
                  <th>Trạng thái</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
              </tbody>
            </table>
            <h5 id="notiNotData" style="text-align: center;"></h5>
          </div>

          <div class="material-datatables row row-cols-auto g-3" style="margin: 5px 10px 5px 0px;" id="divPagingTable">
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

        """),_display_(/*84.10*/views/*84.15*/.html.telco.admin.UserInfoCompany()),format.raw/*84.50*/("""
        """),_display_(/*85.10*/views/*85.15*/.html.telco.admin.UserInfoCompany_zoomImg()),format.raw/*85.58*/("""
        """),_display_(/*86.10*/views/*86.15*/.html.telco.admin.SpenterpriseAdminInfo()),format.raw/*86.56*/("""

      """),format.raw/*88.7*/("""</div>
      """),_display_(/*89.8*/views/*89.13*/.html.telco.Loading()),format.raw/*89.34*/("""

    """),format.raw/*91.5*/("""</div>
      <!--  END OF PAPER WRAP -->

    """),_display_(/*94.6*/views/*94.11*/.html.telco.mainJs()),format.raw/*94.31*/("""

    """),format.raw/*96.5*/("""<script>
            var imgDefault = '"""),_display_(/*97.32*/routes/*97.38*/.Assets.versioned("images/market/default.png")),format.raw/*97.84*/("""';
            $(document).ready(function () """),format.raw/*98.43*/("""{"""),format.raw/*98.44*/("""
              """),format.raw/*99.15*/("""$("#menu-companyManage").addClass("mm-active");
              $("#menu").metisMenu();
            """),format.raw/*101.13*/("""}"""),format.raw/*101.14*/(""")
    </script>
    <script src=""""),_display_(/*103.19*/routes/*103.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*103.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*104.19*/routes/*104.25*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*104.85*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*105.19*/routes/*105.25*/.Assets.versioned("javascripts/views/telco/role/accountList/roleAccountCmp.js")),format.raw/*105.104*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*107.19*/routes/*107.25*/.Assets.versioned("javascripts/views/telco/admin/ApprovedInfoCompany.js")),format.raw/*107.98*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*108.19*/routes/*108.25*/.Assets.versioned("javascripts/views/telco/admin/ApprovedInfoCompany_admin.js")),format.raw/*108.104*/("""" type="text/javascript"></script>

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
                  DATE: Mon Sep 22 16:32:50 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/admin/ApprovedInfoCompany.scala.html
                  HASH: 9bb471c36151f5c363dc69251a2f3b63554d5892
                  MATRIX: 663->1|699->31|1048->65|1161->83|1188->84|1356->226|1406->256|1487->310|1502->316|1559->352|1766->533|1780->538|1826->563|1859->569|1899->582|1914->588|1989->642|2055->681|2070->687|2158->754|2277->845|2306->846|2349->861|2405->889|2434->890|2466->895|2543->946|2557->951|2612->985|2645->992|2659->997|2716->1033|2749->1039|2845->1108|2859->1113|2937->1170|2973->1179|5438->3617|5452->3622|5508->3657|5545->3667|5559->3672|5623->3715|5660->3725|5674->3730|5736->3771|5771->3779|5811->3793|5825->3798|5867->3819|5900->3825|5973->3872|5987->3877|6028->3897|6061->3903|6128->3943|6143->3949|6210->3995|6283->4040|6312->4041|6355->4056|6482->4154|6512->4155|6574->4189|6590->4195|6671->4254|6752->4307|6768->4313|6850->4373|6931->4426|6947->4432|7049->4511|7131->4565|7147->4571|7242->4644|7323->4697|7339->4703|7441->4782
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|53->21|53->21|54->22|55->23|55->23|56->24|60->28|60->28|60->28|62->30|62->30|62->30|64->32|66->34|66->34|66->34|67->35|116->84|116->84|116->84|117->85|117->85|117->85|118->86|118->86|118->86|120->88|121->89|121->89|121->89|123->91|126->94|126->94|126->94|128->96|129->97|129->97|129->97|130->98|130->98|131->99|133->101|133->101|135->103|135->103|135->103|136->104|136->104|136->104|137->105|137->105|137->105|139->107|139->107|139->107|140->108|140->108|140->108
                  -- GENERATED --
              */
          