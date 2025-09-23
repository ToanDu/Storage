
package views.html.user

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
/*7.2*/import vn.m2m.iot.models.Organization

object UserList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[User,List[User],List[Role],List[Organization],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*8.2*/(currentUser: User, userList: List[User], roleList: List[Role], organizationList: List[Organization]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*8.103*/("""
"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>"""),_display_(/*14.17*/Messages("Manage Users")),format.raw/*14.41*/("""</title>
        <link rel="icon" type="image/png" href=""""),_display_(/*15.50*/routes/*15.56*/.Assets.versioned("images/logo.jpg")),format.raw/*15.92*/("""">

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        """),_display_(/*20.10*/views/*20.15*/.html.iot.tags.Main_css()),format.raw/*20.40*/("""

        """),format.raw/*22.9*/("""<link href=""""),_display_(/*22.22*/routes/*22.28*/.Assets.versioned("stylesheets/views/group/style.min.css")),format.raw/*22.86*/("""" rel="stylesheet" />
        <link href=""""),_display_(/*23.22*/routes/*23.28*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*23.82*/("""" rel="stylesheet" />

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
                                <li class="breadcrumb-item active " aria-current="page">"""),_display_(/*42.90*/Messages("manage.group.user")),format.raw/*42.119*/("""</li>
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
                            <button class="btn btn-light px-5 radius-30" onclick="getAddListOrganization()" data-bs-toggle="modal" data-bs-target="#addConfirmModal">
                                <i class="bx bx-plus" aria-hidden="true"></i> """),_display_(/*56.80*/Messages("user.addNew")),format.raw/*56.103*/("""
                            """),format.raw/*57.29*/("""</button>
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="table-responsive">

                            <table id="dataTables" class="table table-striped table-bordered">
                                <thead class="cf">
                                    <th data-field="id">"""),_display_(/*66.58*/Messages("ID")),format.raw/*66.72*/("""</th>
                                    <th data-field="name">"""),_display_(/*67.60*/Messages("filter.name")),format.raw/*67.83*/("""</th>
                                    <th data-field="group">"""),_display_(/*68.61*/Messages("filter.organization")),format.raw/*68.92*/("""</th>
                                    <th data-field="group">"""),_display_(/*69.61*/Messages("filter.role")),format.raw/*69.84*/("""</th>
                                    <th>"""),_display_(/*70.42*/Messages("ACTION")),format.raw/*70.60*/("""</th>

                                </thead>
                                <tbody align="left">
                                """),_display_(/*74.34*/for((user: User) <- userList) yield /*74.63*/ {_display_(Seq[Any](format.raw/*74.65*/("""
                                    """),format.raw/*75.37*/("""<tr>
                                        <td>"""),_display_(/*76.46*/user/*76.50*/.getId),format.raw/*76.56*/("""</td>
                                        <td>"""),_display_(/*77.46*/user/*77.50*/.getUsername),format.raw/*77.62*/("""</td>
                                        <td>"""),_display_(/*78.46*/user/*78.50*/.getOrgName),format.raw/*78.61*/("""</td>
                                        <td>"""),_display_(/*79.46*/user/*79.50*/.getRoleName),format.raw/*79.62*/("""</td>
                                        <td class="dt-buttons btn-group" style="width: 90%">
                                            """),format.raw/*81.216*/("""
                                            """),format.raw/*82.80*/("""
                                            """),format.raw/*83.58*/("""
                                            """),format.raw/*84.238*/("""
                                            """),format.raw/*85.80*/("""
                                            """),format.raw/*86.58*/("""
                                        """),format.raw/*87.41*/("""<button rel="tooltip" title=""""),_display_(/*87.71*/Messages("btnRole")),format.raw/*87.90*/("""" class="btn btn-light" onclick="setSelectedUser('"""),_display_(/*87.141*/user/*87.145*/.getId),format.raw/*87.151*/("""', '"""),_display_(/*87.156*/user/*87.160*/.getRoleId),format.raw/*87.170*/("""')" data-bs-toggle="modal" data-bs-target="#addRoleForUserModal">
                                            <i class="bx bxs-user-badge me-0"></i>
                                        </button>
                                        <button rel="tooltip" title=""""),_display_(/*90.71*/Messages("btnUpdate.org")),format.raw/*90.96*/("""" class="btn btn-light" onclick="setUserOrg('"""),_display_(/*90.142*/user/*90.146*/.getId),format.raw/*90.152*/("""', '"""),_display_(/*90.157*/user/*90.161*/.getOrgId),format.raw/*90.170*/("""')" data-bs-toggle="modal" data-bs-target="#setUserOrg">
                                            <i class="bx bx-group me-0"></i>
                                        </button>
                                            """),format.raw/*93.222*/("""
                                            """),format.raw/*94.77*/("""
                                            """),format.raw/*95.58*/("""
                                        """),format.raw/*96.41*/("""</td>

                                    </tr>
                                """)))}),format.raw/*99.34*/("""
                                """),format.raw/*100.33*/("""</tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>

            """),_display_(/*108.14*/views/*108.19*/.html.user.UserList_add()),format.raw/*108.44*/("""
            """),_display_(/*109.14*/views/*109.19*/.html.user.UserList_edit()),format.raw/*109.45*/("""
            """),_display_(/*110.14*/views/*110.19*/.html.user.UserList_del()),format.raw/*110.44*/("""

            """),_display_(/*112.14*/views/*112.19*/.html.user.UserRole_add(roleList)),format.raw/*112.52*/("""
            """),_display_(/*113.14*/views/*113.19*/.html.user.UserOrg_update(organizationList)),format.raw/*113.62*/("""

            """),_display_(/*115.14*/views/*115.19*/.html.Loading()),format.raw/*115.34*/("""
        """),format.raw/*116.9*/("""</div>
            <!--  END OF PAPER WRAP -->


    </body>

    """),_display_(/*122.6*/views/*122.11*/.html.iot.tags.Main_js()),format.raw/*122.35*/("""

    """),format.raw/*124.5*/("""<script src=""""),_display_(/*124.19*/routes/*124.25*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*124.79*/(""""></script>
        <!--plugins-->
    <script src=""""),_display_(/*126.19*/routes/*126.25*/.Assets.versioned("assets/plugins/simplebar/js/simplebar.min.js")),format.raw/*126.90*/(""""></script>
    <script src=""""),_display_(/*127.19*/routes/*127.25*/.Assets.versioned("assets/plugins/metismenu/js/metisMenu.min.js")),format.raw/*127.90*/(""""></script>
    <script src=""""),_display_(/*128.19*/routes/*128.25*/.Assets.versioned("assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js")),format.raw/*128.102*/(""""></script>
    <script>
            $(document).ready(function () """),format.raw/*130.43*/("""{"""),format.raw/*130.44*/("""
                """),format.raw/*131.17*/("""$("#menu-user").addClass("mm-active");
                $("#menu").metisMenu();
            """),format.raw/*133.13*/("""}"""),format.raw/*133.14*/(""")
    </script>

    <script src=""""),_display_(/*136.19*/routes/*136.25*/.Assets.versioned("javascripts/SearchJs.js")),format.raw/*136.69*/("""" type="text/javascript"></script>

    <script>
            $(document).ready(function () """),format.raw/*139.43*/("""{"""),format.raw/*139.44*/("""
                """),format.raw/*140.17*/("""var table = $('#dataTables').DataTable("""),format.raw/*140.56*/("""{"""),format.raw/*140.57*/("""
                    """),format.raw/*141.21*/("""lengthChange: false,
//                        buttons: [ 'excel', 'pdf', 'print'],
                    "order": [],
                    "info": false
                """),format.raw/*145.17*/("""}"""),format.raw/*145.18*/(""");
                $("#dataTables_filter input")[0].maxLength = 30;
//                    table.buttons().container()
//                            .appendTo( '#dataTables_wrapper .col-md-6:eq(0)' );
            """),format.raw/*149.13*/("""}"""),format.raw/*149.14*/(""");
    </script>

    <script src=""""),_display_(/*152.19*/routes/*152.25*/.Assets.versioned("javascripts/views/group/jstree.js")),format.raw/*152.79*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*154.19*/routes/*154.25*/.Assets.versioned("javascripts/views/user/User.js")),format.raw/*154.76*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*155.19*/routes/*155.25*/.Assets.versioned("javascripts/views/user/User_add.js")),format.raw/*155.80*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*156.19*/routes/*156.25*/.Assets.versioned("javascripts/views/user/User_edit.js")),format.raw/*156.81*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*157.19*/routes/*157.25*/.Assets.versioned("javascripts/views/user/User_delete.js")),format.raw/*157.83*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*158.19*/routes/*158.25*/.Assets.versioned("javascripts/views/user/UserOrg_update.js")),format.raw/*158.86*/("""" type="text/javascript"></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,userList:List[User],roleList:List[Role],organizationList:List[Organization]): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,userList,roleList,organizationList)

  def f:((User,List[User],List[Role],List[Organization]) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,userList,roleList,organizationList) => apply(currentUser,userList,roleList,organizationList)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:56 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/user/UserList.scala.html
                  HASH: e560e5ec5ea1e4a8d4c8ff29f7c7ec1f297001ba
                  MATRIX: 656->1|679->18|715->48|755->82|795->116|833->148|891->200|1275->239|1472->340|1499->341|1682->497|1727->521|1812->579|1827->585|1884->621|2104->814|2118->819|2164->844|2201->854|2241->867|2256->873|2335->931|2405->974|2420->980|2495->1034|2594->1106|2608->1111|2665->1147|2703->1158|2717->1163|2772->1197|2809->1207|3085->1456|3131->1481|3565->1888|3616->1917|4308->2582|4353->2605|4410->2634|4809->3006|4844->3020|4936->3085|4980->3108|5073->3174|5125->3205|5218->3271|5262->3294|5336->3341|5375->3359|5536->3493|5581->3522|5621->3524|5686->3561|5763->3611|5776->3615|5803->3621|5881->3672|5894->3676|5927->3688|6005->3739|6018->3743|6050->3754|6128->3805|6141->3809|6174->3821|6346->4135|6419->4215|6492->4273|6566->4511|6639->4591|6712->4649|6781->4690|6838->4720|6878->4739|6957->4790|6971->4794|6999->4800|7032->4805|7046->4809|7078->4819|7374->5088|7420->5113|7494->5159|7508->5163|7536->5169|7569->5174|7583->5178|7614->5187|7871->5592|7944->5669|8017->5727|8086->5768|8199->5850|8261->5883|8450->6044|8465->6049|8512->6074|8554->6088|8569->6093|8617->6119|8659->6133|8674->6138|8721->6163|8764->6178|8779->6183|8834->6216|8876->6230|8891->6235|8956->6278|8999->6293|9014->6298|9051->6313|9088->6322|9182->6389|9197->6394|9243->6418|9277->6424|9319->6438|9335->6444|9411->6498|9492->6551|9508->6557|9595->6622|9653->6652|9669->6658|9756->6723|9814->6753|9830->6759|9930->6836|10026->6903|10056->6904|10102->6921|10222->7012|10252->7013|10315->7048|10331->7054|10397->7098|10517->7189|10547->7190|10593->7207|10661->7246|10691->7247|10741->7268|10937->7435|10967->7436|11208->7648|11238->7649|11302->7685|11318->7691|11394->7745|11476->7799|11492->7805|11565->7856|11646->7909|11662->7915|11739->7970|11820->8023|11836->8029|11914->8085|11995->8138|12011->8144|12091->8202|12172->8255|12188->8261|12271->8322
                  LINES: 24->1|25->2|26->3|27->4|28->5|29->6|30->7|35->8|40->8|41->9|46->14|46->14|47->15|47->15|47->15|52->20|52->20|52->20|54->22|54->22|54->22|54->22|55->23|55->23|55->23|59->27|59->27|59->27|61->29|61->29|61->29|63->31|68->36|68->36|74->42|74->42|88->56|88->56|89->57|98->66|98->66|99->67|99->67|100->68|100->68|101->69|101->69|102->70|102->70|106->74|106->74|106->74|107->75|108->76|108->76|108->76|109->77|109->77|109->77|110->78|110->78|110->78|111->79|111->79|111->79|113->81|114->82|115->83|116->84|117->85|118->86|119->87|119->87|119->87|119->87|119->87|119->87|119->87|119->87|119->87|122->90|122->90|122->90|122->90|122->90|122->90|122->90|122->90|125->93|126->94|127->95|128->96|131->99|132->100|140->108|140->108|140->108|141->109|141->109|141->109|142->110|142->110|142->110|144->112|144->112|144->112|145->113|145->113|145->113|147->115|147->115|147->115|148->116|154->122|154->122|154->122|156->124|156->124|156->124|156->124|158->126|158->126|158->126|159->127|159->127|159->127|160->128|160->128|160->128|162->130|162->130|163->131|165->133|165->133|168->136|168->136|168->136|171->139|171->139|172->140|172->140|172->140|173->141|177->145|177->145|181->149|181->149|184->152|184->152|184->152|186->154|186->154|186->154|187->155|187->155|187->155|188->156|188->156|188->156|189->157|189->157|189->157|190->158|190->158|190->158
                  -- GENERATED --
              */
          