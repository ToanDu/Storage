
package views.html.telco.childUser

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

object ChildUserList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*9.13*/Messages("Quản lý user")),format.raw/*9.37*/("""</title>
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
    <link href=""""),_display_(/*24.18*/routes/*24.24*/.Assets.versioned("stylesheets/views/telco/role/childUser.css")),format.raw/*24.87*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*28.6*/views/*28.11*/.html.telco.Menu(currentUser, "", userId)),format.raw/*28.52*/("""

    """),_display_(/*30.6*/views/*30.11*/.html.telco.Header(currentUser)),format.raw/*30.42*/("""

    """),format.raw/*32.5*/("""<div class="page-wrapper">
      <div class="page-content">

        """),_display_(/*35.10*/views/*35.15*/.html.telco.childUser.ChildUserList_formSearch(currentUser)),format.raw/*35.74*/("""

        """),format.raw/*37.9*/("""<div class="card">
          <div class="table-responsive" style="border-radius: 8px;">
            <table class="table table-striped" id="listChildUserTable" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th>STT</th>
                  <th>Họ tên</th>
                  <th>Email</th>
                  <th>SĐT</th>
                  <th style="text-align: center;">Phân quyền</th>
                  <th style="text-align: center;">Reset mật khẩu</th>
                  <th style="text-align: center;">Xóa</th>

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

      </div>

      """),_display_(/*84.8*/views/*84.13*/.html.telco.childUser.ChildUserList_add()),format.raw/*84.54*/("""
      """),_display_(/*85.8*/views/*85.13*/.html.telco.childUser.ChildUserList_genPass()),format.raw/*85.58*/("""
      """),_display_(/*86.8*/views/*86.13*/.html.telco.childUser.ChildUserList_genPass_comfirm()),format.raw/*86.66*/("""
      """),_display_(/*87.8*/views/*87.13*/.html.telco.childUser.ChildUserList_del()),format.raw/*87.54*/("""
      """),_display_(/*88.8*/views/*88.13*/.html.telco.childUser.ChildUserList_editRole()),format.raw/*88.59*/("""

      """),_display_(/*90.8*/views/*90.13*/.html.telco.Loading()),format.raw/*90.34*/("""

    """),format.raw/*92.5*/("""</div>
      <!--  END OF PAPER WRAP -->

    """),_display_(/*95.6*/views/*95.11*/.html.telco.mainJs()),format.raw/*95.31*/("""

    """),format.raw/*97.5*/("""<script>
            var imgDefault = '"""),_display_(/*98.32*/routes/*98.38*/.Assets.versioned("images/market/default.png")),format.raw/*98.84*/("""';
            var userId = '"""),_display_(/*99.28*/userId),format.raw/*99.34*/("""';

            $(document).ready(function () """),format.raw/*101.43*/("""{"""),format.raw/*101.44*/("""
              """),format.raw/*102.15*/("""$("#menu-childUser").addClass("mm-active");
              $("#menu").metisMenu();
            """),format.raw/*104.13*/("""}"""),format.raw/*104.14*/(""")
    </script>
    <script src=""""),_display_(/*106.19*/routes/*106.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*106.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*107.19*/routes/*107.25*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*107.85*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*109.19*/routes/*109.25*/.Assets.versioned("javascripts/views/telco/childUser/ChildUser.js")),format.raw/*109.92*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*110.19*/routes/*110.25*/.Assets.versioned("javascripts/views/telco/childUser/ChildUser_add.js")),format.raw/*110.96*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*111.19*/routes/*111.25*/.Assets.versioned("javascripts/views/telco/childUser/ChildUser_pass.js")),format.raw/*111.97*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*112.19*/routes/*112.25*/.Assets.versioned("javascripts/views/telco/childUser/ChildUser_del.js")),format.raw/*112.96*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*113.19*/routes/*113.25*/.Assets.versioned("javascripts/views/telco/childUser/ChildUser_role.js")),format.raw/*113.97*/("""" type="text/javascript"></script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/childUser/ChildUserList.scala.html
                  HASH: 00f2963030a7f4619f882a7a99019fe36161797a
                  MATRIX: 667->1|703->31|1053->65|1181->98|1208->99|1376->241|1420->265|1501->319|1516->325|1573->361|1780->542|1794->547|1840->572|1873->578|1913->591|1928->597|2003->651|2069->690|2084->696|2169->760|2223->877|2255->882|2295->895|2310->901|2380->950|2443->986|2458->992|2595->1107|2661->1146|2676->1152|2751->1206|2817->1245|2832->1251|2916->1314|3006->1378|3020->1383|3082->1424|3115->1431|3129->1436|3181->1467|3214->1473|3311->1543|3325->1548|3405->1607|3442->1617|5862->4011|5876->4016|5938->4057|5972->4065|5986->4070|6052->4115|6086->4123|6100->4128|6174->4181|6208->4189|6222->4194|6284->4235|6318->4243|6332->4248|6399->4294|6434->4303|6448->4308|6490->4329|6523->4335|6596->4382|6610->4387|6651->4407|6684->4413|6751->4453|6766->4459|6833->4505|6890->4535|6917->4541|6992->4587|7022->4588|7066->4603|7189->4697|7219->4698|7281->4732|7297->4738|7378->4797|7459->4850|7475->4856|7557->4916|7639->4970|7655->4976|7744->5043|7825->5096|7841->5102|7934->5173|8015->5226|8031->5232|8125->5304|8206->5357|8222->5363|8315->5434|8396->5487|8412->5493|8506->5565
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|52->20|52->20|52->20|52->20|53->21|53->21|53->21|55->23|55->23|55->23|56->24|56->24|56->24|60->28|60->28|60->28|62->30|62->30|62->30|64->32|67->35|67->35|67->35|69->37|116->84|116->84|116->84|117->85|117->85|117->85|118->86|118->86|118->86|119->87|119->87|119->87|120->88|120->88|120->88|122->90|122->90|122->90|124->92|127->95|127->95|127->95|129->97|130->98|130->98|130->98|131->99|131->99|133->101|133->101|134->102|136->104|136->104|138->106|138->106|138->106|139->107|139->107|139->107|141->109|141->109|141->109|142->110|142->110|142->110|143->111|143->111|143->111|144->112|144->112|144->112|145->113|145->113|145->113
                  -- GENERATED --
              */
          