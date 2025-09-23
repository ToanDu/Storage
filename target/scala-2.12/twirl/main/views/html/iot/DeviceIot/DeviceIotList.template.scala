
package views.html.iot.DeviceIot

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
/*5.2*/import vn.m2m.utils.UserHelper
/*6.2*/import vn.m2m.common.models.forms.SearchObjectData

object DeviceIotList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,List[DeviceIot],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*7.2*/(currentUser:User, deviceIotList: List[DeviceIot], projectId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.70*/("""
"""),format.raw/*8.1*/("""<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>"""),_display_(/*13.17*/Messages("Manage Devices")),format.raw/*13.43*/("""</title>
        <link rel="icon" type="image/png" href=""""),_display_(/*14.50*/routes/*14.56*/.Assets.versioned("images/logo.jpg")),format.raw/*14.92*/("""">

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        """),_display_(/*19.10*/views/*19.15*/.html.iot.tags.Main_css()),format.raw/*19.40*/("""

        """),format.raw/*21.9*/("""<link href=""""),_display_(/*21.22*/routes/*21.28*/.Assets.versioned("stylesheets/views/group/style.min.css")),format.raw/*21.86*/("""" rel="stylesheet" />
        <link href=""""),_display_(/*22.22*/routes/*22.28*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*22.82*/("""" rel="stylesheet" />

        <link href=""""),_display_(/*24.22*/routes/*24.28*/.Assets.versioned("assets/plugins/smart-wizard/css/smart_wizard_all.min.css")),format.raw/*24.105*/("""" rel="stylesheet" type="text/css" />

        <style>
            .deviceID """),format.raw/*27.23*/("""{"""),format.raw/*27.24*/("""
                """),format.raw/*28.17*/("""cursor: pointer;
            """),format.raw/*29.13*/("""}"""),format.raw/*29.14*/("""
            """),format.raw/*30.13*/(""".deviceID:hover """),format.raw/*30.29*/("""{"""),format.raw/*30.30*/("""
                """),format.raw/*31.17*/("""color: #00a5bb;
            """),format.raw/*32.13*/("""}"""),format.raw/*32.14*/("""
        """),format.raw/*33.9*/("""</style>

    </head>
    <body class="bg-theme">
        """),_display_(/*37.10*/views/*37.15*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*37.58*/("""

        """),_display_(/*39.10*/views/*39.15*/.html.iot.tags.Header(currentUser)),format.raw/*39.49*/("""

        """),format.raw/*41.9*/("""<div class="page-wrapper">
            <div class="page-content">

                    <!--breadcrumb-->
                <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3 ">
                    <div class="breadcrumb-title pe-3">"""),_display_(/*46.57*/Messages("manage.manage")),format.raw/*46.82*/("""</div>
                    <div class="ps-3">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb mb-0 p-0">
                                <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt "></i></a>
                                </li>
                                <li class="breadcrumb-item active " aria-current="page">"""),_display_(/*52.90*/Messages("manage.group.device")),format.raw/*52.121*/("""</li>
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
                                <i class="bx bx-plus" aria-hidden="true"></i> """),_display_(/*66.80*/Messages("device.addNew")),format.raw/*66.105*/("""
                            """),format.raw/*67.29*/("""</button>
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="table-responsive">

                            <table id="dataTables" class="table table-striped table-bordered">
                                <thead class="cf">
                                    <th data-field="id">"""),_display_(/*76.58*/Messages("ID")),format.raw/*76.72*/("""</th>
                                    <th data-field="name">"""),_display_(/*77.60*/Messages("filter.name")),format.raw/*77.83*/("""</th>
                                    """),format.raw/*78.98*/("""
                                    """),format.raw/*79.37*/("""<th data-field="organization">"""),_display_(/*79.68*/Messages("filter.organizationName")),format.raw/*79.103*/("""</th>
                                    <th data-field="groupName">"""),_display_(/*80.65*/Messages("filter.groupName")),format.raw/*80.93*/("""</th>
                                    <th data-field="type">"""),_display_(/*81.60*/Messages("filter.typeName")),format.raw/*81.87*/("""</th>
"""),format.raw/*82.95*/("""
                                    """),format.raw/*83.37*/("""<th data-field="type">"""),_display_(/*83.60*/Messages("filter.message")),format.raw/*83.86*/("""</th>
                                    <th>"""),_display_(/*84.42*/Messages("btnAction")),format.raw/*84.63*/("""</th>

                                </thead>
                                <tbody align="left">
                                """),_display_(/*88.34*/for((device: DeviceIot)<- deviceIotList) yield /*88.74*/ {_display_(Seq[Any](format.raw/*88.76*/("""
                                    """),format.raw/*89.37*/("""<tr>
                                        <td>
                                            <a class="deviceID" href=""""),_display_(/*91.72*/routes/*91.78*/.DeviceVariableController.deviceVariable(projectId, device.getId())),format.raw/*91.145*/("""" target="_blank"  data-bs-toggle="tooltip" data-bs-placement="bottom" title=""""),_display_(/*91.224*/Messages("device.variable.manage")),format.raw/*91.258*/("""">"""),_display_(/*91.261*/device/*91.267*/.getId),format.raw/*91.273*/("""</a>
                                        </td>
                                        <td>"""),_display_(/*93.46*/device/*93.52*/.getName),format.raw/*93.60*/("""</td>
                                        """),format.raw/*94.72*/("""
                                        """),format.raw/*95.41*/("""<td>"""),_display_(/*95.46*/device/*95.52*/.getOrgName),format.raw/*95.63*/("""</td>
                                        <td>"""),_display_(/*96.46*/device/*96.52*/.getGroupName),format.raw/*96.65*/("""</td>
                                        <td>"""),_display_(/*97.46*/device/*97.52*/.getTypeName),format.raw/*97.64*/("""</td>
"""),format.raw/*98.49*/("""
"""),format.raw/*99.70*/("""
"""),format.raw/*100.137*/("""
"""),format.raw/*101.104*/("""
"""),format.raw/*102.57*/("""
"""),format.raw/*103.57*/("""
"""),format.raw/*104.272*/("""
"""),format.raw/*105.104*/("""
"""),format.raw/*106.57*/("""
"""),format.raw/*107.50*/("""
"""),format.raw/*108.50*/("""
                                        """),format.raw/*109.41*/("""<td>
                                            <a rel="tooltip" title=""""),_display_(/*110.70*/Messages("btnSms")),format.raw/*110.88*/("""" class="btn btn-light" href=""""),_display_(/*110.119*/routes/*110.125*/.MessagesDeviceController.messagesDevice(device.getId)),format.raw/*110.179*/("""" target="_blank">
                                                <i class="bx bx-envelope me-0"></i>
                                            </a>
                                        </td>
                                        <td class="dt-buttons btn-group" style="width: 90%">
                                            <button rel="tooltip" title=""""),_display_(/*115.75*/Messages("btnUpdate")),format.raw/*115.96*/("""" class="btn btn-light btn-success" onclick="getDataUpdateDevice('"""),_display_(/*115.163*/device/*115.169*/.getId),format.raw/*115.175*/("""','"""),_display_(/*115.179*/device/*115.185*/.getGroupId),format.raw/*115.196*/("""','"""),_display_(/*115.200*/device/*115.206*/.getOrgID),format.raw/*115.215*/("""','"""),_display_(/*115.219*/device/*115.225*/.getTypeID),format.raw/*115.235*/("""')" data-bs-toggle="modal" data-bs-target="#updateConfirmModal" type="button">
                                                <i class="bx bx-refresh me-0"></i>
                                            </button>
                                            <button rel="tooltip" title=""""),_display_(/*118.75*/Messages("btnEdit")),format.raw/*118.94*/("""" class="btn btn-light" onclick="editDeviceName('"""),_display_(/*118.144*/device/*118.150*/.getId),format.raw/*118.156*/("""', '"""),_display_(/*118.161*/device/*118.167*/.getName),format.raw/*118.175*/("""')" data-bs-toggle="modal" data-bs-target="#editConfirmModal" type="button">
                                                <i class="bx bx-edit me-0"></i>
                                            </button>
                                            <button rel="tooltip" title=""""),_display_(/*121.75*/Messages("btnDelete")),format.raw/*121.96*/("""" class="btn btn-light" onclick="deleteDeviceId('"""),_display_(/*121.146*/device/*121.152*/.getId),format.raw/*121.158*/("""')" data-bs-toggle="modal" data-bs-target="#deleteDeviceconfirm" type="button">
                                                <i class="bx bx-x me-0"></i>
                                            </button>
                                        </td>

                                    </tr>
                                """)))}),format.raw/*127.34*/("""
                                """),format.raw/*128.33*/("""</tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>

            """),_display_(/*136.14*/views/*136.19*/.html.iot.DeviceIot.DeviceIotList_add()),format.raw/*136.58*/("""
            """),_display_(/*137.14*/views/*137.19*/.html.iot.DeviceIot.DeviceIotList_del()),format.raw/*137.58*/("""
            """),_display_(/*138.14*/views/*138.19*/.html.iot.DeviceIot.DeviceIotList_edit()),format.raw/*138.59*/("""
            """),_display_(/*139.14*/views/*139.19*/.html.iot.DeviceIot.DeviceIotList_update()),format.raw/*139.61*/("""

"""),format.raw/*141.66*/("""

            """),_display_(/*143.14*/views/*143.19*/.html.Loading()),format.raw/*143.34*/("""

        """),format.raw/*145.9*/("""</div>
            <!--  END OF PAPER WRAP -->

        """),_display_(/*148.10*/views/*148.15*/.html.iot.tags.Main_js()),format.raw/*148.39*/("""

        """),format.raw/*150.9*/("""<script src=""""),_display_(/*150.23*/routes/*150.29*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*150.83*/(""""></script>
            <!--plugins-->
        <script src=""""),_display_(/*152.23*/routes/*152.29*/.Assets.versioned("assets/plugins/simplebar/js/simplebar.min.js")),format.raw/*152.94*/(""""></script>
        <script src=""""),_display_(/*153.23*/routes/*153.29*/.Assets.versioned("assets/plugins/metismenu/js/metisMenu.min.js")),format.raw/*153.94*/(""""></script>
        <script src=""""),_display_(/*154.23*/routes/*154.29*/.Assets.versioned("assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js")),format.raw/*154.106*/(""""></script>
        <script>
                $(document).ready(function () """),format.raw/*156.47*/("""{"""),format.raw/*156.48*/("""
                    """),format.raw/*157.21*/("""$("#menu-device").addClass("mm-active");
                    $("#menu").metisMenu();
                """),format.raw/*159.17*/("""}"""),format.raw/*159.18*/(""")
        </script>

        <script src=""""),_display_(/*162.23*/routes/*162.29*/.Assets.versioned("javascripts/SearchJs.js")),format.raw/*162.73*/("""" type="text/javascript"></script>

        <script>
            $(document).ready(function() """),format.raw/*165.42*/("""{"""),format.raw/*165.43*/("""
                """),format.raw/*166.17*/("""getListOrganizations();
                getListGroups();
                getListTypes();

                var table = $('#dataTables').DataTable( """),format.raw/*170.57*/("""{"""),format.raw/*170.58*/("""
                    """),format.raw/*171.21*/("""lengthChange: false,
//                    buttons: [ 'excel', 'pdf', 'print'],
                    "order": [],
                    "info": false
                """),format.raw/*175.17*/("""}"""),format.raw/*175.18*/(""" """),format.raw/*175.19*/(""");
                $("#dataTables_filter input")[0].maxLength = 30;

//                table.buttons().container()
//                        .appendTo( '#dataTables_wrapper .col-md-6:eq(0)' );
            """),format.raw/*180.13*/("""}"""),format.raw/*180.14*/(""" """),format.raw/*180.15*/(""");
        </script>

        <script src=""""),_display_(/*183.23*/routes/*183.29*/.Assets.versioned("javascripts/views/group/jstree.js")),format.raw/*183.83*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*184.23*/routes/*184.29*/.Assets.versioned("javascripts/views/device/DeviceIot.js")),format.raw/*184.87*/(""""></script>
        <script src=""""),_display_(/*185.23*/routes/*185.29*/.Assets.versioned("javascripts/views/device/DeviceIot_add.js")),format.raw/*185.91*/(""""></script>

        <script src=""""),_display_(/*187.23*/routes/*187.29*/.Assets.versioned("assets/plugins/smart-wizard/js/jquery.smartWizard.min.js")),format.raw/*187.106*/(""""></script>
        <script src=""""),_display_(/*188.23*/routes/*188.29*/.Assets.versioned("javascripts/views/device/DeviceIot_description.js")),format.raw/*188.99*/(""""></script>
        <script>
                $(document).ready(function () """),format.raw/*190.47*/("""{"""),format.raw/*190.48*/("""
                    """),format.raw/*191.21*/("""// Toolbar extra buttons
                    var btnFinish = $('<button></button>').text('Finish').addClass('btn btn-info').on('click', function () """),format.raw/*192.124*/("""{"""),format.raw/*192.125*/("""
                        """),format.raw/*193.25*/("""alert('Finish Clicked');
                    """),format.raw/*194.21*/("""}"""),format.raw/*194.22*/(""");
                    var btnCancel = $('<button href="#" data-bs-dismiss="modal"></button>').text('Cancel').addClass('btn btn-danger').on('click', function () """),format.raw/*195.159*/("""{"""),format.raw/*195.160*/("""
                        """),format.raw/*196.25*/("""resetFormWizard();
                    """),format.raw/*197.21*/("""}"""),format.raw/*197.22*/(""");
                    // Step show event
                    $("#smartwizard").on("showStep", function (e, anchorObject, stepNumber, stepDirection, stepPosition) """),format.raw/*199.122*/("""{"""),format.raw/*199.123*/("""
                        """),format.raw/*200.25*/("""$("#prev-btn").removeClass('disabled');
                        $("#next-btn").removeClass('disabled');
                        if (stepPosition === 'first') """),format.raw/*202.55*/("""{"""),format.raw/*202.56*/("""
                            """),format.raw/*203.29*/("""$("#prev-btn").addClass('disabled');
                        """),format.raw/*204.25*/("""}"""),format.raw/*204.26*/(""" """),format.raw/*204.27*/("""else if (stepPosition === 'last') """),format.raw/*204.61*/("""{"""),format.raw/*204.62*/("""
                            """),format.raw/*205.29*/("""$("#next-btn").addClass('disabled');
                        """),format.raw/*206.25*/("""}"""),format.raw/*206.26*/(""" """),format.raw/*206.27*/("""else """),format.raw/*206.32*/("""{"""),format.raw/*206.33*/("""
                            """),format.raw/*207.29*/("""$("#prev-btn").removeClass('disabled');
                            $("#next-btn").removeClass('disabled');
                        """),format.raw/*209.25*/("""}"""),format.raw/*209.26*/("""
                    """),format.raw/*210.21*/("""}"""),format.raw/*210.22*/(""");
                    // Smart Wizard
                    $('#smartwizard').smartWizard("""),format.raw/*212.51*/("""{"""),format.raw/*212.52*/("""
                        """),format.raw/*213.25*/("""selected: 0,
                        theme: 'arrows',
                        transition: """),format.raw/*215.37*/("""{"""),format.raw/*215.38*/("""
                            """),format.raw/*216.29*/("""animation: 'slide-horizontal', // Effect on navigation, none/fade/slide-horizontal/slide-vertical/slide-swing
                        """),format.raw/*217.25*/("""}"""),format.raw/*217.26*/(""",
                        toolbarSettings: """),format.raw/*218.42*/("""{"""),format.raw/*218.43*/("""
"""),format.raw/*219.1*/("""//                            toolbarPosition: 'both', // both bottom
                            toolbarExtraButtons: [btnCancel]
                        """),format.raw/*221.25*/("""}"""),format.raw/*221.26*/("""
                    """),format.raw/*222.21*/("""}"""),format.raw/*222.22*/(""");
                    // External Button Events
                    $("#reset-btn").on("click", function () """),format.raw/*224.61*/("""{"""),format.raw/*224.62*/("""
                        """),format.raw/*225.25*/("""// Reset wizard
                        $('#smartwizard').smartWizard("reset");
                        return true;
                    """),format.raw/*228.21*/("""}"""),format.raw/*228.22*/(""");
                    $("#prev-btn").on("click", function () """),format.raw/*229.60*/("""{"""),format.raw/*229.61*/("""
                        """),format.raw/*230.25*/("""// Navigate previous
                        $('#smartwizard').smartWizard("prev");
                        return true;
                    """),format.raw/*233.21*/("""}"""),format.raw/*233.22*/(""");
                    $("#next-btn").on("click", function () """),format.raw/*234.60*/("""{"""),format.raw/*234.61*/("""
                        """),format.raw/*235.25*/("""// Navigate next
                        $('#smartwizard').smartWizard("next");
                        return true;
                    """),format.raw/*238.21*/("""}"""),format.raw/*238.22*/(""");

                """),format.raw/*240.17*/("""}"""),format.raw/*240.18*/(""");

                function resetFormWizard() """),format.raw/*242.44*/("""{"""),format.raw/*242.45*/("""
                    """),format.raw/*243.21*/("""$('#smartwizard').smartWizard("reset");
                """),format.raw/*244.17*/("""}"""),format.raw/*244.18*/("""
        """),format.raw/*245.9*/("""</script>
    </body>
</html>
"""))
      }
    }
  }

  def render(currentUser:User,deviceIotList:List[DeviceIot],projectId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,deviceIotList,projectId)

  def f:((User,List[DeviceIot],String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,deviceIotList,projectId) => apply(currentUser,deviceIotList,projectId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:44 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/DeviceIot/DeviceIotList.scala.html
                  HASH: 9ed681e5c836ee80283654438e40dcda34eae821
                  MATRIX: 665->1|688->18|724->48|764->82|806->118|844->150|1228->202|1391->270|1418->271|1601->427|1648->453|1733->511|1748->517|1805->553|2025->746|2039->751|2085->776|2122->786|2162->799|2177->805|2256->863|2326->906|2341->912|2416->966|2487->1010|2502->1016|2601->1093|2706->1170|2735->1171|2780->1188|2837->1217|2866->1218|2907->1231|2951->1247|2980->1248|3025->1265|3081->1293|3110->1294|3146->1303|3232->1362|3246->1367|3310->1410|3348->1421|3362->1426|3417->1460|3454->1470|3730->1719|3776->1744|4210->2151|4263->2182|4955->2847|5002->2872|5059->2901|5458->3273|5493->3287|5585->3352|5629->3375|5699->3478|5764->3515|5822->3546|5879->3581|5976->3651|6025->3679|6117->3744|6165->3771|6199->3871|6264->3908|6314->3931|6361->3957|6435->4004|6477->4025|6638->4159|6694->4199|6734->4201|6799->4238|6947->4359|6962->4365|7051->4432|7158->4511|7214->4545|7245->4548|7261->4554|7289->4560|7412->4656|7427->4662|7456->4670|7530->4747|7599->4788|7631->4793|7646->4799|7678->4810|7756->4861|7771->4867|7805->4880|7883->4931|7898->4937|7931->4949|7965->5003|7994->5073|8025->5210|8056->5314|8086->5371|8116->5428|8147->5700|8178->5804|8208->5861|8238->5911|8268->5961|8338->6002|8440->6076|8480->6094|8540->6125|8557->6131|8634->6185|9027->6550|9070->6571|9166->6638|9183->6644|9212->6650|9245->6654|9262->6660|9296->6671|9329->6675|9346->6681|9378->6690|9411->6694|9428->6700|9461->6710|9779->7000|9820->7019|9899->7069|9916->7075|9945->7081|9979->7086|9996->7092|10027->7100|10340->7385|10383->7406|10462->7456|10479->7462|10508->7468|10873->7801|10935->7834|11124->7995|11139->8000|11200->8039|11242->8053|11257->8058|11318->8097|11360->8111|11375->8116|11437->8156|11479->8170|11494->8175|11558->8217|11589->8284|11632->8299|11647->8304|11684->8319|11722->8329|11807->8386|11822->8391|11868->8415|11906->8425|11948->8439|11964->8445|12040->8499|12129->8560|12145->8566|12232->8631|12294->8665|12310->8671|12397->8736|12459->8770|12475->8776|12575->8853|12679->8928|12709->8929|12759->8950|12889->9051|12919->9052|12990->9095|13006->9101|13072->9145|13195->9239|13225->9240|13271->9257|13446->9403|13476->9404|13526->9425|13718->9588|13748->9589|13778->9590|14012->9795|14042->9796|14072->9797|14144->9841|14160->9847|14236->9901|14321->9958|14337->9964|14417->10022|14479->10056|14495->10062|14579->10124|14642->10159|14658->10165|14758->10242|14820->10276|14836->10282|14928->10352|15032->10427|15062->10428|15112->10449|15290->10597|15321->10598|15375->10623|15449->10668|15479->10669|15670->10830|15701->10831|15755->10856|15823->10895|15853->10896|16046->11059|16077->11060|16131->11085|16318->11243|16348->11244|16406->11273|16496->11334|16526->11335|16556->11336|16619->11370|16649->11371|16707->11400|16797->11461|16827->11462|16857->11463|16891->11468|16921->11469|16979->11498|17140->11630|17170->11631|17220->11652|17250->11653|17368->11742|17398->11743|17452->11768|17571->11858|17601->11859|17659->11888|17822->12022|17852->12023|17924->12066|17954->12067|17983->12068|18167->12223|18197->12224|18247->12245|18277->12246|18415->12355|18445->12356|18499->12381|18665->12518|18695->12519|18786->12581|18816->12582|18870->12607|19040->12748|19070->12749|19161->12811|19191->12812|19245->12837|19411->12974|19441->12975|19490->12995|19520->12996|19596->13043|19626->13044|19676->13065|19761->13121|19791->13122|19828->13131
                  LINES: 24->1|25->2|26->3|27->4|28->5|29->6|34->7|39->7|40->8|45->13|45->13|46->14|46->14|46->14|51->19|51->19|51->19|53->21|53->21|53->21|53->21|54->22|54->22|54->22|56->24|56->24|56->24|59->27|59->27|60->28|61->29|61->29|62->30|62->30|62->30|63->31|64->32|64->32|65->33|69->37|69->37|69->37|71->39|71->39|71->39|73->41|78->46|78->46|84->52|84->52|98->66|98->66|99->67|108->76|108->76|109->77|109->77|110->78|111->79|111->79|111->79|112->80|112->80|113->81|113->81|114->82|115->83|115->83|115->83|116->84|116->84|120->88|120->88|120->88|121->89|123->91|123->91|123->91|123->91|123->91|123->91|123->91|123->91|125->93|125->93|125->93|126->94|127->95|127->95|127->95|127->95|128->96|128->96|128->96|129->97|129->97|129->97|130->98|131->99|132->100|133->101|134->102|135->103|136->104|137->105|138->106|139->107|140->108|141->109|142->110|142->110|142->110|142->110|142->110|147->115|147->115|147->115|147->115|147->115|147->115|147->115|147->115|147->115|147->115|147->115|147->115|147->115|147->115|150->118|150->118|150->118|150->118|150->118|150->118|150->118|150->118|153->121|153->121|153->121|153->121|153->121|159->127|160->128|168->136|168->136|168->136|169->137|169->137|169->137|170->138|170->138|170->138|171->139|171->139|171->139|173->141|175->143|175->143|175->143|177->145|180->148|180->148|180->148|182->150|182->150|182->150|182->150|184->152|184->152|184->152|185->153|185->153|185->153|186->154|186->154|186->154|188->156|188->156|189->157|191->159|191->159|194->162|194->162|194->162|197->165|197->165|198->166|202->170|202->170|203->171|207->175|207->175|207->175|212->180|212->180|212->180|215->183|215->183|215->183|216->184|216->184|216->184|217->185|217->185|217->185|219->187|219->187|219->187|220->188|220->188|220->188|222->190|222->190|223->191|224->192|224->192|225->193|226->194|226->194|227->195|227->195|228->196|229->197|229->197|231->199|231->199|232->200|234->202|234->202|235->203|236->204|236->204|236->204|236->204|236->204|237->205|238->206|238->206|238->206|238->206|238->206|239->207|241->209|241->209|242->210|242->210|244->212|244->212|245->213|247->215|247->215|248->216|249->217|249->217|250->218|250->218|251->219|253->221|253->221|254->222|254->222|256->224|256->224|257->225|260->228|260->228|261->229|261->229|262->230|265->233|265->233|266->234|266->234|267->235|270->238|270->238|272->240|272->240|274->242|274->242|275->243|276->244|276->244|277->245
                  -- GENERATED --
              */
          