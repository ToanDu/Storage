
package views.html.roles

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
/*4.2*/import vn.m2m.common.models.Role
/*5.2*/import vn.m2m.utils.UserHelper
/*6.2*/import vn.m2m.common.models.forms.SearchObjectData

object RoleList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,List[Role],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*7.2*/(currentUser:User, roleList: List[Role]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.42*/("""
"""),format.raw/*8.1*/("""<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>"""),_display_(/*13.17*/Messages("Manage Roles")),format.raw/*13.41*/("""</title>
        <link rel="icon" type="image/png" href=""""),_display_(/*14.50*/routes/*14.56*/.Assets.versioned("images/logo.jpg")),format.raw/*14.92*/("""">

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        """),_display_(/*19.10*/views/*19.15*/.html.iot.tags.Main_css()),format.raw/*19.40*/("""

        """),format.raw/*21.9*/("""<link href=""""),_display_(/*21.22*/routes/*21.28*/.Assets.versioned("stylesheets/views/group/style.min.css")),format.raw/*21.86*/("""" rel="stylesheet" />
        <link href=""""),_display_(/*22.22*/routes/*22.28*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*22.82*/("""" rel="stylesheet" />
        <link href=""""),_display_(/*23.22*/routes/*23.28*/.Assets.versioned("stylesheets/views/roles/roles.css")),format.raw/*23.82*/("""" rel="stylesheet" />

    </head>
    <body class="bg-theme">
        """),_display_(/*27.10*/views/*27.15*/.html.iot.tags.Menu(currentUser, "")),format.raw/*27.51*/("""

        """),_display_(/*29.10*/views/*29.15*/.html.iot.tags.Header(currentUser)),format.raw/*29.49*/("""

        """),format.raw/*31.9*/("""<div class="page-wrapper">
            <div class="page-content">

                    <!--breadcrumb-->
                <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3 ">
                    <div class="breadcrumb-title pe-3">"""),_display_(/*36.57*/Messages("manage.manage")),format.raw/*36.82*/("""</div>
                    <div class="ps-3">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb mb-0 p-0">
                                <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt "></i></a>
                                </li>
                                <li class="breadcrumb-item active " aria-current="page">"""),_display_(/*42.90*/Messages("manage.group.role")),format.raw/*42.119*/("""</li>
                            </ol>
                        </nav>
                    </div>
                    <div class="ms-auto">

                    </div>
                </div>
                    <!--end breadcrumb-->

                <div class="card ">
                    <div class="card-header card-header-primary card-header-icon">
                        <div class="toolbar" style="float: right">
                            <button class="btn btn-light px-5 radius-30" data-bs-toggle="modal" data-bs-target="#addConfirmModal">
                                <i class="bx bx-plus" aria-hidden="true"></i> """),_display_(/*56.80*/Messages("role.addNew")),format.raw/*56.103*/("""
                            """),format.raw/*57.29*/("""</button>
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="table-responsive">

                            <table id="dataTables" class="table table-striped table-bordered">
                                <thead class="cf">
                                    <th>"""),_display_(/*66.42*/Messages("ID")),format.raw/*66.56*/("""</th>
                                    <th>"""),_display_(/*67.42*/Messages("filter.name")),format.raw/*67.65*/("""</th>
                                    <th>"""),_display_(/*68.42*/Messages("btnAction")),format.raw/*68.63*/("""</th>

                                </thead>
                                <tbody align="left">
                                """),_display_(/*72.34*/for((role: Role)<- roleList) yield /*72.62*/ {_display_(Seq[Any](format.raw/*72.64*/("""
                                    """),format.raw/*73.37*/("""<tr>
                                        <td>"""),_display_(/*74.46*/role/*74.50*/.getId),format.raw/*74.56*/("""</td>
                                        <td>"""),_display_(/*75.46*/role/*75.50*/.getName),format.raw/*75.58*/("""</td>
                                        <td class="dt-buttons btn-group" style="width: 90%">
                                            <button rel="tooltip" title=""""),_display_(/*77.75*/Messages("btnView")),format.raw/*77.94*/("""" class="btn btn-light" onclick="showServicePolicy('"""),_display_(/*77.147*/role/*77.151*/.getServiceLog),format.raw/*77.165*/("""')" data-bs-toggle="modal" data-bs-target="#viewRoleConfirm">
                                                <i class="bx bx-info-circle me-0"></i>
                                            </button>
                                            <button rel="tooltip" title=""""),_display_(/*80.75*/Messages("btnEdit")),format.raw/*80.94*/("""" class="btn btn-light" onclick="getUpdateView('"""),_display_(/*80.143*/role/*80.147*/.getId),format.raw/*80.153*/("""')" data-bs-toggle="modal" data-bs-target="#editModal">
                                                <i class="bx bx-edit me-0"></i>
                                            </button>
                                            <button rel="tooltip" title=""""),_display_(/*83.75*/Messages("btnDelete")),format.raw/*83.96*/("""" class="btn btn-light" onclick="deleteRole('"""),_display_(/*83.142*/role/*83.146*/.getId),format.raw/*83.152*/("""')" data-bs-toggle="modal" data-bs-target="#deleteRoleConfirm">
                                                <i class="bx bx-x me-0"></i>
                                            </button>
                                        </td>

                                    </tr>
                                """)))}),format.raw/*89.34*/("""
                                """),format.raw/*90.33*/("""</tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>

            """),_display_(/*98.14*/views/*98.19*/.html.roles.Role_add()),format.raw/*98.41*/("""
            """),_display_(/*99.14*/views/*99.19*/.html.user.UserList_link()),format.raw/*99.45*/("""
            """),_display_(/*100.14*/views/*100.19*/.html.roles.Role_del()),format.raw/*100.41*/("""
            """),_display_(/*101.14*/views/*101.19*/.html.roles.Role_edit()),format.raw/*101.42*/("""
            """),_display_(/*102.14*/views/*102.19*/.html.roles.Role_view()),format.raw/*102.42*/("""

            """),_display_(/*104.14*/views/*104.19*/.html.Loading()),format.raw/*104.34*/("""
        """),format.raw/*105.9*/("""</div>
            <!--  END OF PAPER WRAP -->


    </body>

    """),_display_(/*111.6*/views/*111.11*/.html.iot.tags.Main_js()),format.raw/*111.35*/("""

    """),format.raw/*113.5*/("""<script src=""""),_display_(/*113.19*/routes/*113.25*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*113.79*/(""""></script>
        <!--plugins-->
    <script src=""""),_display_(/*115.19*/routes/*115.25*/.Assets.versioned("assets/plugins/simplebar/js/simplebar.min.js")),format.raw/*115.90*/(""""></script>
    <script src=""""),_display_(/*116.19*/routes/*116.25*/.Assets.versioned("assets/plugins/metismenu/js/metisMenu.min.js")),format.raw/*116.90*/(""""></script>
    <script src=""""),_display_(/*117.19*/routes/*117.25*/.Assets.versioned("assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js")),format.raw/*117.102*/(""""></script>
    <script>
                $(document).ready(function () """),format.raw/*119.47*/("""{"""),format.raw/*119.48*/("""
                    """),format.raw/*120.21*/("""$("#menu-role").addClass("mm-active");
                    $("#menu").metisMenu();
                """),format.raw/*122.17*/("""}"""),format.raw/*122.18*/(""")
    </script>

    <script src=""""),_display_(/*125.19*/routes/*125.25*/.Assets.versioned("javascripts/SearchJs.js")),format.raw/*125.69*/("""" type="text/javascript"></script>

    <script>
                $(document).ready(function() """),format.raw/*128.46*/("""{"""),format.raw/*128.47*/("""
                    """),format.raw/*129.21*/("""var table = $('#dataTables').DataTable( """),format.raw/*129.61*/("""{"""),format.raw/*129.62*/("""
                        """),format.raw/*130.25*/("""responsive: true,
                        lengthChange: false,
//                        buttons: [ 'excel', 'pdf', 'print'],
                        "order": [],
                        "info": false
                    """),format.raw/*135.21*/("""}"""),format.raw/*135.22*/(""" """),format.raw/*135.23*/(""");
                    $("#dataTables_filter input")[0].maxLength = 30;
//                    table.buttons().container()
//                            .appendTo( '#dataTables_wrapper .col-md-6:eq(0)' );
                """),format.raw/*139.17*/("""}"""),format.raw/*139.18*/(""" """),format.raw/*139.19*/(""");
    </script>

    <script src=""""),_display_(/*142.19*/routes/*142.25*/.Assets.versioned("javascripts/plugins/base64.js")),format.raw/*142.75*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*143.19*/routes/*143.25*/.Assets.versioned("javascripts/views/roles/roles.js")),format.raw/*143.78*/("""" type="text/javascript"></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,roleList:List[Role]): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,roleList)

  def f:((User,List[Role]) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,roleList) => apply(currentUser,roleList)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:49 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/roles/RoleList.scala.html
                  HASH: 1d1251b53ea75fed826ea77d40dd0d11f859776a
                  MATRIX: 657->1|680->18|716->48|756->82|796->116|834->148|1201->200|1336->240|1363->241|1546->397|1591->421|1676->479|1691->485|1748->521|1968->714|1982->719|2028->744|2065->754|2105->767|2120->773|2199->831|2269->874|2284->880|2359->934|2429->977|2444->983|2519->1037|2618->1109|2632->1114|2689->1150|2727->1161|2741->1166|2796->1200|2833->1210|3109->1459|3155->1484|3589->1891|3640->1920|4297->2550|4342->2573|4399->2602|4782->2958|4817->2972|4891->3019|4935->3042|5009->3089|5051->3110|5212->3244|5256->3272|5296->3274|5361->3311|5438->3361|5451->3365|5478->3371|5556->3422|5569->3426|5598->3434|5798->3607|5838->3626|5919->3679|5933->3683|5969->3697|6273->3974|6313->3993|6390->4042|6404->4046|6432->4052|6723->4316|6765->4337|6839->4383|6853->4387|6881->4393|7229->4710|7290->4743|7478->4904|7492->4909|7535->4931|7576->4945|7590->4950|7637->4976|7679->4990|7694->4995|7738->5017|7780->5031|7795->5036|7840->5059|7882->5073|7897->5078|7942->5101|7985->5116|8000->5121|8037->5136|8074->5145|8168->5212|8183->5217|8229->5241|8263->5247|8305->5261|8321->5267|8397->5321|8478->5374|8494->5380|8581->5445|8639->5475|8655->5481|8742->5546|8800->5576|8816->5582|8916->5659|9016->5730|9046->5731|9096->5752|9224->5851|9254->5852|9317->5887|9333->5893|9399->5937|9522->6031|9552->6032|9602->6053|9671->6093|9701->6094|9755->6119|10005->6340|10035->6341|10065->6342|10314->6562|10344->6563|10374->6564|10438->6600|10454->6606|10526->6656|10607->6709|10623->6715|10698->6768
                  LINES: 24->1|25->2|26->3|27->4|28->5|29->6|34->7|39->7|40->8|45->13|45->13|46->14|46->14|46->14|51->19|51->19|51->19|53->21|53->21|53->21|53->21|54->22|54->22|54->22|55->23|55->23|55->23|59->27|59->27|59->27|61->29|61->29|61->29|63->31|68->36|68->36|74->42|74->42|88->56|88->56|89->57|98->66|98->66|99->67|99->67|100->68|100->68|104->72|104->72|104->72|105->73|106->74|106->74|106->74|107->75|107->75|107->75|109->77|109->77|109->77|109->77|109->77|112->80|112->80|112->80|112->80|112->80|115->83|115->83|115->83|115->83|115->83|121->89|122->90|130->98|130->98|130->98|131->99|131->99|131->99|132->100|132->100|132->100|133->101|133->101|133->101|134->102|134->102|134->102|136->104|136->104|136->104|137->105|143->111|143->111|143->111|145->113|145->113|145->113|145->113|147->115|147->115|147->115|148->116|148->116|148->116|149->117|149->117|149->117|151->119|151->119|152->120|154->122|154->122|157->125|157->125|157->125|160->128|160->128|161->129|161->129|161->129|162->130|167->135|167->135|167->135|171->139|171->139|171->139|174->142|174->142|174->142|175->143|175->143|175->143
                  -- GENERATED --
              */
          