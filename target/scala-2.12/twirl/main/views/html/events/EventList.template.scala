
package views.html.events

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
/*4.2*/import vn.m2m.iot.models.DeviceIot
/*5.2*/import vn.m2m.iot.models.Event
/*6.2*/import vn.m2m.utils.UserHelper
/*7.2*/import vn.m2m.common.models.forms.SearchObjectData
/*8.2*/import vn.m2m.iot.models.Organization

object EventList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[User,List[DeviceIot],List[Event],List[Organization],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*9.2*/(currentUser:User, deviceList: List[DeviceIot], eventList: List[Event], organizationList: List[Organization]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*9.111*/("""
"""),format.raw/*10.1*/("""<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>"""),_display_(/*15.17*/Messages("Manage Events")),format.raw/*15.42*/("""</title>
        <link rel="icon" type="image/png" href=""""),_display_(/*16.50*/routes/*16.56*/.Assets.versioned("images/logo.jpg")),format.raw/*16.92*/("""">

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        """),_display_(/*21.10*/views/*21.15*/.html.iot.tags.Main_css()),format.raw/*21.40*/("""

        """),format.raw/*23.9*/("""<link href=""""),_display_(/*23.22*/routes/*23.28*/.Assets.versioned("stylesheets/views/group/style.min.css")),format.raw/*23.86*/("""" rel="stylesheet" />
        <link href=""""),_display_(/*24.22*/routes/*24.28*/.Assets.versioned("stylesheets/views/events/events.css")),format.raw/*24.84*/("""" rel="stylesheet" />
        <link href=""""),_display_(/*25.22*/routes/*25.28*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*25.82*/("""" rel="stylesheet" />

    </head>
    <body class="bg-theme">
        """),_display_(/*29.10*/views/*29.15*/.html.iot.tags.Menu(currentUser, "")),format.raw/*29.51*/("""

        """),_display_(/*31.10*/views/*31.15*/.html.iot.tags.Header(currentUser)),format.raw/*31.49*/("""

        """),format.raw/*33.9*/("""<div class="page-wrapper">
            <div class="page-content">

                    <!--breadcrumb-->
                <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3 ">
                    <div class="breadcrumb-title pe-3">"""),_display_(/*38.57*/Messages("manage.manage")),format.raw/*38.82*/("""</div>
                    <div class="ps-3">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb mb-0 p-0">
                                <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt "></i></a>
                                </li>
                                <li class="breadcrumb-item active " aria-current="page">"""),_display_(/*44.90*/Messages("manage.group.event")),format.raw/*44.120*/("""</li>
                            </ol>
                        </nav>
                    </div>
                    <div class="ms-auto">

                    </div>
                </div>
                    <!--end breadcrumb-->

                <div class="card " >
                    <div class="card-header card-header-primary card-header-icon">
                        <div class="toolbar" style="float: right">
                            <button class="btn btn-light px-5 radius-30" data-bs-toggle="modal" data-bs-target="#addConfirmModal">
                                <i class="bx bx-plus" aria-hidden="true"></i> """),_display_(/*58.80*/Messages("event.title.addNewEvent")),format.raw/*58.115*/("""
                            """),format.raw/*59.29*/("""</button>
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="table-responsive">

                            <table id="dataTables" class="table table-striped table-bordered">
                                <thead class="cf">
                                    <th data-field="id">"""),_display_(/*68.58*/Messages("ID")),format.raw/*68.72*/("""</th>
                                    <th data-field="name">"""),_display_(/*69.60*/Messages("event.title.name")),format.raw/*69.88*/("""</th>
                                    <th data-field="group">"""),_display_(/*70.61*/Messages("event.column.title.organization")),format.raw/*70.104*/("""</th>
                                    <th data-field="group">"""),_display_(/*71.61*/Messages("event.column.title.status")),format.raw/*71.98*/("""</th>
                                    <th>"""),_display_(/*72.42*/Messages("btnAction")),format.raw/*72.63*/("""</th>

                                </thead>
                                <tbody align="left">
                                """),_display_(/*76.34*/for((event: Event)<- eventList) yield /*76.65*/ {_display_(Seq[Any](format.raw/*76.67*/("""
                                    """),format.raw/*77.37*/("""<tr>
                                        <td>"""),_display_(/*78.46*/event/*78.51*/.getId),format.raw/*78.57*/("""</td>
                                        <td>"""),_display_(/*79.46*/event/*79.51*/.getName),format.raw/*79.59*/("""</td>
                                        <td>"""),_display_(/*80.46*/event/*80.51*/.getOrganization),format.raw/*80.67*/("""</td>
                                        <td>"""),_display_(/*81.46*/event/*81.51*/.getStatusStr),format.raw/*81.64*/("""</td>
                                        <td class="dt-buttons btn-group" style="width: 90%">
                                            <button rel="tooltip" title=""""),_display_(/*83.75*/Messages("btnEdit")),format.raw/*83.94*/("""" class="btn btn-light" onclick="getEvent('"""),_display_(/*83.138*/event/*83.143*/.getId),format.raw/*83.149*/("""')" data-bs-toggle="modal" data-bs-target="#editEventModal">
                                                <i class="bx bx-edit me-0"></i>
                                            </button>
                                            <button rel="tooltip" title=""""),_display_(/*86.75*/Messages("btnUpdate.org")),format.raw/*86.100*/("""" class="btn btn-light" onclick="setEventOrg('"""),_display_(/*86.147*/event/*86.152*/.getId),format.raw/*86.158*/("""', '"""),_display_(/*86.163*/event/*86.168*/.getOrganization),format.raw/*86.184*/("""')" data-bs-toggle="modal" data-bs-target="#setEventOrg">
                                                <i class="bx bx-group me-0"></i>
                                            </button>
                                            """),_display_(/*89.46*/if(!event.isStatus)/*89.65*/{_display_(Seq[Any](format.raw/*89.66*/("""
                                                """),format.raw/*90.49*/("""<button rel="tooltip" title=""""),_display_(/*90.79*/Messages("btnActiveEvent")),format.raw/*90.105*/("""" class="btn btn-light" onclick="activeEvent('"""),_display_(/*90.152*/event/*90.157*/.getId),format.raw/*90.163*/("""')">
                                                    <i class="bx bx-arrow-from-bottom me-0"></i>
                                                </button>
                                            """)))}/*93.46*/else/*93.50*/{_display_(Seq[Any](format.raw/*93.51*/("""
                                                """),format.raw/*94.49*/("""<button rel="tooltip" title=""""),_display_(/*94.79*/Messages("btnDeActiveEvent")),format.raw/*94.107*/("""" class="btn btn-light" onclick="deActiveEvent('"""),_display_(/*94.156*/event/*94.161*/.getId),format.raw/*94.167*/("""')">
                                                    <i class="bx bx-arrow-from-top me-0"></i>
                                                </button>
                                            """)))}),format.raw/*97.46*/("""
                                            """),format.raw/*98.45*/("""<button rel="tooltip" title=""""),_display_(/*98.75*/Messages("btnDelete")),format.raw/*98.96*/("""" class="btn btn-light" onclick="deleteEvent('"""),_display_(/*98.143*/event/*98.148*/.getId),format.raw/*98.154*/("""')" data-bs-toggle="modal" data-bs-target="#deleteEventConfirm">
                                                <i class="bx bx-x me-0"></i>
                                            </button>

                                        </td>

                                    </tr>
                                """)))}),format.raw/*105.34*/("""
                                """),format.raw/*106.33*/("""</tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>

            """),_display_(/*114.14*/views/*114.19*/.html.events.Event_add(deviceList)),format.raw/*114.53*/("""
            """),_display_(/*115.14*/views/*115.19*/.html.events.Event_del()),format.raw/*115.43*/("""
            """),_display_(/*116.14*/views/*116.19*/.html.events.Event_Org(organizationList)),format.raw/*116.59*/("""
            """),_display_(/*117.14*/views/*117.19*/.html.user.UserList_link()),format.raw/*117.45*/("""
            """),_display_(/*118.14*/views/*118.19*/.html.events.Event_edit(deviceList)),format.raw/*118.54*/("""

            """),_display_(/*120.14*/views/*120.19*/.html.Loading()),format.raw/*120.34*/("""
        """),format.raw/*121.9*/("""</div>
            <!--  END OF PAPER WRAP -->


    </body>

    """),_display_(/*127.6*/views/*127.11*/.html.iot.tags.Main_js()),format.raw/*127.35*/("""

    """),format.raw/*129.5*/("""<script src=""""),_display_(/*129.19*/routes/*129.25*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*129.79*/(""""></script>
        <!--plugins-->
    <script src=""""),_display_(/*131.19*/routes/*131.25*/.Assets.versioned("assets/plugins/simplebar/js/simplebar.min.js")),format.raw/*131.90*/(""""></script>
    <script src=""""),_display_(/*132.19*/routes/*132.25*/.Assets.versioned("assets/plugins/metismenu/js/metisMenu.min.js")),format.raw/*132.90*/(""""></script>
    <script src=""""),_display_(/*133.19*/routes/*133.25*/.Assets.versioned("assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js")),format.raw/*133.102*/(""""></script>
    <script>
                $(document).ready(function () """),format.raw/*135.47*/("""{"""),format.raw/*135.48*/("""
                    """),format.raw/*136.21*/("""$("#menu-event").addClass("mm-active");
                    $("#menu").metisMenu();
                """),format.raw/*138.17*/("""}"""),format.raw/*138.18*/(""")
    </script>

    <script src=""""),_display_(/*141.19*/routes/*141.25*/.Assets.versioned("javascripts/SearchJs.js")),format.raw/*141.69*/("""" type="text/javascript"></script>

    <script>
                $(document).ready(function() """),format.raw/*144.46*/("""{"""),format.raw/*144.47*/("""
                    """),format.raw/*145.21*/("""var table = $('#dataTables').DataTable( """),format.raw/*145.61*/("""{"""),format.raw/*145.62*/("""
                        """),format.raw/*146.25*/("""responsive: true,
                        lengthChange: false,
//                        buttons: [ 'excel', 'pdf', 'print']
                        "order": [],
                        "info": false
                    """),format.raw/*151.21*/("""}"""),format.raw/*151.22*/(""" """),format.raw/*151.23*/(""");
                    $("#dataTables_filter input")[0].maxLength = 30;

//                    table.buttons().container()
//                            .appendTo( '#dataTables_wrapper .col-md-6:eq(0)' );
                """),format.raw/*156.17*/("""}"""),format.raw/*156.18*/(""" """),format.raw/*156.19*/(""");
    </script>

    <script src=""""),_display_(/*159.19*/routes/*159.25*/.Assets.versioned("javascripts/views/user/User.js")),format.raw/*159.76*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*160.19*/routes/*160.25*/.Assets.versioned("javascripts/views/events/events.js")),format.raw/*160.80*/("""" type="text/javascript"></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,deviceList:List[DeviceIot],eventList:List[Event],organizationList:List[Organization]): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,deviceList,eventList,organizationList)

  def f:((User,List[DeviceIot],List[Event],List[Organization]) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,deviceList,eventList,organizationList) => apply(currentUser,deviceList,eventList,organizationList)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:41 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/events/EventList.scala.html
                  HASH: 83828880a6cca002b82b8bbe8c1246fe27a1d864
                  MATRIX: 658->1|681->18|717->48|757->82|799->118|837->150|875->182|933->234|1324->273|1529->382|1557->383|1740->539|1786->564|1871->622|1886->628|1943->664|2163->857|2177->862|2223->887|2260->897|2300->910|2315->916|2394->974|2464->1017|2479->1023|2556->1079|2626->1122|2641->1128|2716->1182|2815->1254|2829->1259|2886->1295|2924->1306|2938->1311|2993->1345|3030->1355|3306->1604|3352->1629|3786->2036|3838->2066|4496->2697|4553->2732|4610->2761|5009->3133|5044->3147|5136->3212|5185->3240|5278->3306|5343->3349|5436->3415|5494->3452|5568->3499|5610->3520|5771->3654|5818->3685|5858->3687|5923->3724|6000->3774|6014->3779|6041->3785|6119->3836|6133->3841|6162->3849|6240->3900|6254->3905|6291->3921|6369->3972|6383->3977|6417->3990|6617->4163|6657->4182|6729->4226|6744->4231|6772->4237|7068->4506|7115->4531|7190->4578|7205->4583|7233->4589|7266->4594|7281->4599|7319->4615|7584->4853|7612->4872|7651->4873|7728->4922|7785->4952|7833->4978|7908->5025|7923->5030|7951->5036|8175->5241|8188->5245|8227->5246|8304->5295|8361->5325|8411->5353|8488->5402|8503->5407|8531->5413|8764->5615|8837->5660|8894->5690|8936->5711|9011->5758|9026->5763|9054->5769|9405->6088|9467->6121|9656->6282|9671->6287|9727->6321|9769->6335|9784->6340|9830->6364|9872->6378|9887->6383|9949->6423|9991->6437|10006->6442|10054->6468|10096->6482|10111->6487|10168->6522|10211->6537|10226->6542|10263->6557|10300->6566|10394->6633|10409->6638|10455->6662|10489->6668|10531->6682|10547->6688|10623->6742|10704->6795|10720->6801|10807->6866|10865->6896|10881->6902|10968->6967|11026->6997|11042->7003|11142->7080|11242->7151|11272->7152|11322->7173|11451->7273|11481->7274|11544->7309|11560->7315|11626->7359|11749->7453|11779->7454|11829->7475|11898->7515|11928->7516|11982->7541|12231->7761|12261->7762|12291->7763|12541->7984|12571->7985|12601->7986|12665->8022|12681->8028|12754->8079|12835->8132|12851->8138|12928->8193
                  LINES: 24->1|25->2|26->3|27->4|28->5|29->6|30->7|31->8|36->9|41->9|42->10|47->15|47->15|48->16|48->16|48->16|53->21|53->21|53->21|55->23|55->23|55->23|55->23|56->24|56->24|56->24|57->25|57->25|57->25|61->29|61->29|61->29|63->31|63->31|63->31|65->33|70->38|70->38|76->44|76->44|90->58|90->58|91->59|100->68|100->68|101->69|101->69|102->70|102->70|103->71|103->71|104->72|104->72|108->76|108->76|108->76|109->77|110->78|110->78|110->78|111->79|111->79|111->79|112->80|112->80|112->80|113->81|113->81|113->81|115->83|115->83|115->83|115->83|115->83|118->86|118->86|118->86|118->86|118->86|118->86|118->86|118->86|121->89|121->89|121->89|122->90|122->90|122->90|122->90|122->90|122->90|125->93|125->93|125->93|126->94|126->94|126->94|126->94|126->94|126->94|129->97|130->98|130->98|130->98|130->98|130->98|130->98|137->105|138->106|146->114|146->114|146->114|147->115|147->115|147->115|148->116|148->116|148->116|149->117|149->117|149->117|150->118|150->118|150->118|152->120|152->120|152->120|153->121|159->127|159->127|159->127|161->129|161->129|161->129|161->129|163->131|163->131|163->131|164->132|164->132|164->132|165->133|165->133|165->133|167->135|167->135|168->136|170->138|170->138|173->141|173->141|173->141|176->144|176->144|177->145|177->145|177->145|178->146|183->151|183->151|183->151|188->156|188->156|188->156|191->159|191->159|191->159|192->160|192->160|192->160
                  -- GENERATED --
              */
          