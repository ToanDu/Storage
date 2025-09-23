
package views.html.groupList

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
/*4.2*/import vn.m2m.models.Group
/*5.2*/import vn.m2m.utils.UserHelper
/*6.2*/import vn.m2m.common.models.forms.SearchObjectData

object GroupsList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,List[Group],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*7.2*/(currentUser:User, groupsList: List[Group]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.45*/("""
"""),format.raw/*8.1*/("""<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>"""),_display_(/*13.17*/Messages("Manage Groups")),format.raw/*13.42*/("""</title>
        <link rel="icon" type="image/png" href=""""),_display_(/*14.50*/routes/*14.56*/.Assets.versioned("images/logo.jpg")),format.raw/*14.92*/("""">

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        """),_display_(/*19.10*/views/*19.15*/.html.iot.tags.Main_css()),format.raw/*19.40*/("""

        """),format.raw/*21.9*/("""<link href=""""),_display_(/*21.22*/routes/*21.28*/.Assets.versioned("stylesheets/views/group/style.min.css")),format.raw/*21.86*/("""" rel="stylesheet" />
        <link href=""""),_display_(/*22.22*/routes/*22.28*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*22.82*/("""" rel="stylesheet" />

    </head>
    <body class="bg-theme">
        """),_display_(/*26.10*/views/*26.15*/.html.iot.tags.Menu(currentUser, "")),format.raw/*26.51*/("""

        """),_display_(/*28.10*/views/*28.15*/.html.iot.tags.Header(currentUser)),format.raw/*28.49*/("""

        """),format.raw/*30.9*/("""<div class="page-wrapper">
            <div class="page-content">

                    <!--breadcrumb-->
                <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3 ">
                    <div class="breadcrumb-title pe-3">"""),_display_(/*35.57*/Messages("manage.manage")),format.raw/*35.82*/("""</div>
                    <div class="ps-3">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb mb-0 p-0">
                                <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt "></i></a>
                                </li>
                                <li class="breadcrumb-item active " aria-current="page">"""),_display_(/*41.90*/Messages("manage.group.group")),format.raw/*41.120*/("""</li>
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
                            <button class="btn btn-danger px-5 radius-30" onclick="getAddListOrganization()" data-bs-toggle="modal" data-bs-target="#addConfirmModal">
                                <i class="bx bx-plus" aria-hidden="true"></i> """),_display_(/*55.80*/Messages("group.addNew")),format.raw/*55.104*/("""
                            """),format.raw/*56.29*/("""</button>
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="table-responsive">

                            <table id="dataTables" class="table table-striped table-bordered">
                                <thead class="cf">
                                    <th data-field="id">"""),_display_(/*65.58*/Messages("ID")),format.raw/*65.72*/("""</th>
                                    <th data-field="name">"""),_display_(/*66.60*/Messages("filter.name")),format.raw/*66.83*/("""</th>
                                    <th data-field="group">"""),_display_(/*67.61*/Messages("filter.orgId")),format.raw/*67.85*/("""</th>
                                    <th>"""),_display_(/*68.42*/Messages("btnAction")),format.raw/*68.63*/("""</th>

                                </thead>
                                <tbody align="left">
                                """),_display_(/*72.34*/for((groups: Group)<- groupsList) yield /*72.67*/ {_display_(Seq[Any](format.raw/*72.69*/("""
                                    """),format.raw/*73.37*/("""<tr>
                                        <td>"""),_display_(/*74.46*/groups/*74.52*/.getId),format.raw/*74.58*/("""</td>
                                        <td>"""),_display_(/*75.46*/groups/*75.52*/.getName),format.raw/*75.60*/("""</td>
                                        <td>"""),_display_(/*76.46*/groups/*76.52*/.getOrgId),format.raw/*76.61*/("""</td>
                                        <td class="dt-buttons btn-group" style="width: 90%">
                                            <button rel="tooltip" title=""""),_display_(/*78.75*/Messages("btnUpdate")),format.raw/*78.96*/("""" class="btn btn-light" onclick="setIdGroupUpdate('"""),_display_(/*78.148*/groups/*78.154*/.getId),format.raw/*78.160*/("""', '"""),_display_(/*78.165*/groups/*78.171*/.getOrgId),format.raw/*78.180*/("""')" data-bs-toggle="modal" data-bs-target="#updateConfirmModal">
                                                <i class="bx bx-refresh me-0"></i>
                                            </button>
                                            <button rel="tooltip" title=""""),_display_(/*81.75*/Messages("btnEdit")),format.raw/*81.94*/("""" class="btn btn-light" onclick="editGroupName('"""),_display_(/*81.143*/groups/*81.149*/.getId),format.raw/*81.155*/("""', '"""),_display_(/*81.160*/groups/*81.166*/.getName),format.raw/*81.174*/("""')" data-bs-toggle="modal" data-bs-target="#editConfirmModal">
                                                <i class="bx bx-edit me-0"></i>
                                            </button>
                                            <button rel="tooltip" title=""""),_display_(/*84.75*/Messages("btnDelete")),format.raw/*84.96*/("""" class="btn btn-light" onclick="deleteGroupId('"""),_display_(/*84.145*/groups/*84.151*/.getId),format.raw/*84.157*/("""')" data-bs-toggle="modal" data-bs-target="#deleteGroupconfirm">
                                                <i class="bx bx-x me-0"></i>
                                            </button>
                                        </td>

                                    </tr>
                                """)))}),format.raw/*90.34*/("""
                                """),format.raw/*91.33*/("""</tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>

            """),_display_(/*99.14*/views/*99.19*/.html.groupList.GroupsList_add()),format.raw/*99.51*/("""
            """),_display_(/*100.14*/views/*100.19*/.html.groupList.GroupsList_del()),format.raw/*100.51*/("""
            """),_display_(/*101.14*/views/*101.19*/.html.groupList.GroupsList_edit()),format.raw/*101.52*/("""
            """),_display_(/*102.14*/views/*102.19*/.html.groupList.GroupsList_update()),format.raw/*102.54*/("""
        """),format.raw/*103.9*/("""</div>
            <!--  END OF PAPER WRAP -->
        """),_display_(/*105.10*/views/*105.15*/.html.Loading()),format.raw/*105.30*/("""

    """),format.raw/*107.5*/("""</body>

    """),_display_(/*109.6*/views/*109.11*/.html.iot.tags.Main_js()),format.raw/*109.35*/("""

    """),format.raw/*111.5*/("""<script src=""""),_display_(/*111.19*/routes/*111.25*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*111.79*/(""""></script>
        <!--plugins-->
    <script src=""""),_display_(/*113.19*/routes/*113.25*/.Assets.versioned("assets/plugins/simplebar/js/simplebar.min.js")),format.raw/*113.90*/(""""></script>
    <script src=""""),_display_(/*114.19*/routes/*114.25*/.Assets.versioned("assets/plugins/metismenu/js/metisMenu.min.js")),format.raw/*114.90*/(""""></script>
    <script src=""""),_display_(/*115.19*/routes/*115.25*/.Assets.versioned("assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js")),format.raw/*115.102*/(""""></script>
    <script>
                $(document).ready(function () """),format.raw/*117.47*/("""{"""),format.raw/*117.48*/("""
                    """),format.raw/*118.21*/("""$("#menu-group").addClass("mm-active");
                    $("#menu").metisMenu();
                """),format.raw/*120.17*/("""}"""),format.raw/*120.18*/(""")
        </script>

    <script src=""""),_display_(/*123.19*/routes/*123.25*/.Assets.versioned("javascripts/SearchJs.js")),format.raw/*123.69*/("""" type="text/javascript"></script>

    <script>
                $(document).ready(function() """),format.raw/*126.46*/("""{"""),format.raw/*126.47*/("""
                    """),format.raw/*127.21*/("""getOrgList(); //get list org (update group)

                    var table = $('#dataTables').DataTable( """),format.raw/*129.61*/("""{"""),format.raw/*129.62*/("""
                        """),format.raw/*130.25*/("""lengthChange: false,
//                        buttons: [ 'excel', 'pdf', 'print'],
                        "order": [],
                        "info": false
                    """),format.raw/*134.21*/("""}"""),format.raw/*134.22*/(""" """),format.raw/*134.23*/(""");
                    $("#dataTables_filter input")[0].maxLength = 30;

//                    table.buttons().container()
//                            .appendTo( '#dataTables_wrapper .col-md-6:eq(0)' );
                """),format.raw/*139.17*/("""}"""),format.raw/*139.18*/(""" """),format.raw/*139.19*/(""");
        </script>

    <script src=""""),_display_(/*142.19*/routes/*142.25*/.Assets.versioned("javascripts/views/group/jstree.js")),format.raw/*142.79*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*143.19*/routes/*143.25*/.Assets.versioned("javascripts/views/groups/GroupsList.js")),format.raw/*143.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*144.19*/routes/*144.25*/.Assets.versioned("javascripts/views/groups/GroupsList_add.js")),format.raw/*144.88*/("""" type="text/javascript"></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,groupsList:List[Group]): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,groupsList)

  def f:((User,List[Group]) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,groupsList) => apply(currentUser,groupsList)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:42 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/groupList/GroupsList.scala.html
                  HASH: 74530275a1a47ba74da8e2f64d98f9ad9202dc89
                  MATRIX: 661->1|684->18|720->48|760->82|794->110|832->142|1202->194|1340->237|1367->238|1550->394|1596->419|1681->477|1696->483|1753->519|1973->712|1987->717|2033->742|2070->752|2110->765|2125->771|2204->829|2274->872|2289->878|2364->932|2463->1004|2477->1009|2534->1045|2572->1056|2586->1061|2641->1095|2678->1105|2954->1354|3000->1379|3434->1786|3486->1816|4179->2482|4225->2506|4282->2535|4681->2907|4716->2921|4808->2986|4852->3009|4945->3075|4990->3099|5064->3146|5106->3167|5267->3301|5316->3334|5356->3336|5421->3373|5498->3423|5513->3429|5540->3435|5618->3486|5633->3492|5662->3500|5740->3551|5755->3557|5785->3566|5985->3739|6027->3760|6107->3812|6123->3818|6151->3824|6184->3829|6200->3835|6231->3844|6534->4120|6574->4139|6651->4188|6667->4194|6695->4200|6728->4205|6744->4211|6774->4219|7072->4490|7114->4511|7191->4560|7207->4566|7235->4572|7584->4890|7645->4923|7833->5084|7847->5089|7900->5121|7942->5135|7957->5140|8011->5172|8053->5186|8068->5191|8123->5224|8165->5238|8180->5243|8237->5278|8274->5287|8358->5343|8373->5348|8410->5363|8444->5369|8485->5383|8500->5388|8546->5412|8580->5418|8622->5432|8638->5438|8714->5492|8795->5545|8811->5551|8898->5616|8956->5646|8972->5652|9059->5717|9117->5747|9133->5753|9233->5830|9333->5901|9363->5902|9413->5923|9542->6023|9572->6024|9639->6063|9655->6069|9721->6113|9844->6207|9874->6208|9924->6229|10058->6334|10088->6335|10142->6360|10350->6539|10380->6540|10410->6541|10660->6762|10690->6763|10720->6764|10788->6804|10804->6810|10880->6864|10961->6917|10977->6923|11058->6982|11139->7035|11155->7041|11240->7104
                  LINES: 24->1|25->2|26->3|27->4|28->5|29->6|34->7|39->7|40->8|45->13|45->13|46->14|46->14|46->14|51->19|51->19|51->19|53->21|53->21|53->21|53->21|54->22|54->22|54->22|58->26|58->26|58->26|60->28|60->28|60->28|62->30|67->35|67->35|73->41|73->41|87->55|87->55|88->56|97->65|97->65|98->66|98->66|99->67|99->67|100->68|100->68|104->72|104->72|104->72|105->73|106->74|106->74|106->74|107->75|107->75|107->75|108->76|108->76|108->76|110->78|110->78|110->78|110->78|110->78|110->78|110->78|110->78|113->81|113->81|113->81|113->81|113->81|113->81|113->81|113->81|116->84|116->84|116->84|116->84|116->84|122->90|123->91|131->99|131->99|131->99|132->100|132->100|132->100|133->101|133->101|133->101|134->102|134->102|134->102|135->103|137->105|137->105|137->105|139->107|141->109|141->109|141->109|143->111|143->111|143->111|143->111|145->113|145->113|145->113|146->114|146->114|146->114|147->115|147->115|147->115|149->117|149->117|150->118|152->120|152->120|155->123|155->123|155->123|158->126|158->126|159->127|161->129|161->129|162->130|166->134|166->134|166->134|171->139|171->139|171->139|174->142|174->142|174->142|175->143|175->143|175->143|176->144|176->144|176->144
                  -- GENERATED --
              */
          