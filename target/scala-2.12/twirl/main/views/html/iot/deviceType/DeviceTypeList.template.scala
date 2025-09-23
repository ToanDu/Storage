
package views.html.iot.deviceType

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
/*4.2*/import vn.m2m.iot.models.DeviceType
/*5.2*/import vn.m2m.utils.UserHelper
/*6.2*/import vn.m2m.common.models.forms.SearchObjectData

object DeviceTypeList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,List[DeviceType],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*7.2*/(currentUser:User, deviceTypeList: List[DeviceType], projectId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.72*/("""
"""),format.raw/*8.1*/("""<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>"""),_display_(/*13.17*/Messages("Manage Types")),format.raw/*13.41*/("""</title>
        <link rel="icon" type="image/png" href=""""),_display_(/*14.50*/routes/*14.56*/.Assets.versioned("images/logo.jpg")),format.raw/*14.92*/("""">

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        """),_display_(/*19.10*/views/*19.15*/.html.iot.tags.Main_css()),format.raw/*19.40*/("""

        """),format.raw/*21.9*/("""<link href=""""),_display_(/*21.22*/routes/*21.28*/.Assets.versioned("stylesheets/views/group/style.min.css")),format.raw/*21.86*/("""" rel="stylesheet" />
        <link href=""""),_display_(/*22.22*/routes/*22.28*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*22.82*/("""" rel="stylesheet" />

    </head>
    <body class="bg-theme">
        """),_display_(/*26.10*/views/*26.15*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*26.58*/("""

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
                                <li class="breadcrumb-item active " aria-current="page">"""),_display_(/*41.90*/Messages("manage.group.type")),format.raw/*41.119*/("""</li>
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
                                <i class="bx bx-plus" aria-hidden="true"></i> """),_display_(/*55.80*/Messages("deviceType.addNew")),format.raw/*55.109*/("""
                            """),format.raw/*56.29*/("""</button>
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="table-responsive">

                            <table id="dataTables" class="table table-striped table-bordered">
                                <thead class="cf">
                                    <th data-field="id">"""),_display_(/*65.58*/Messages("ID")),format.raw/*65.72*/("""</th>
                                    <th data-field="name">"""),_display_(/*66.60*/Messages("filter.name")),format.raw/*66.83*/("""</th>
                                    <th data-field="organization">"""),_display_(/*67.68*/Messages("filter.organization")),format.raw/*67.99*/("""</th>
                                    <th>"""),_display_(/*68.42*/Messages("btnAction")),format.raw/*68.63*/("""</th>

                                </thead>
                                <tbody align="left">
                                """),_display_(/*72.34*/for((deviceType: DeviceType)<- deviceTypeList) yield /*72.80*/ {_display_(Seq[Any](format.raw/*72.82*/("""
                                    """),format.raw/*73.37*/("""<tr>
                                        <td>"""),_display_(/*74.46*/deviceType/*74.56*/.getId),format.raw/*74.62*/("""</td>
                                        <td>"""),_display_(/*75.46*/deviceType/*75.56*/.getName),format.raw/*75.64*/("""</td>
                                        <td>"""),_display_(/*76.46*/deviceType/*76.56*/.getOrganizationName),format.raw/*76.76*/("""</td>
                                        <td class="dt-buttons btn-group" style="width: 90%">
                                            <button rel="tooltip" title=""""),_display_(/*78.75*/Messages("btnEdit")),format.raw/*78.94*/("""" class="btn btn-light" onclick="editDeviceType('"""),_display_(/*78.144*/deviceType/*78.154*/.getId),format.raw/*78.160*/("""', '"""),_display_(/*78.165*/deviceType/*78.175*/.getName),format.raw/*78.183*/("""')" data-bs-toggle="modal" data-bs-target="#editConfirmModal">
                                                <i class="bx bx-edit me-0"></i>
                                            </button>
                                            <button rel="tooltip" title=""""),_display_(/*81.75*/Messages("btnDelete")),format.raw/*81.96*/("""" class="btn btn-light" onclick="deleteDeviceType('"""),_display_(/*81.148*/deviceType/*81.158*/.getId),format.raw/*81.164*/("""')" data-bs-toggle="modal" data-bs-target="#deleteTypeconfirm">
                                                <i class="bx bx-x me-0"></i>
                                            </button>
                                        </td>

                                    </tr>
                                """)))}),format.raw/*87.34*/("""
                                """),format.raw/*88.33*/("""</tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>

            """),_display_(/*96.14*/views/*96.19*/.html.iot.deviceType.DeviceTypeList_add()),format.raw/*96.60*/("""
            """),_display_(/*97.14*/views/*97.19*/.html.iot.deviceType.DeviceTypeList_del()),format.raw/*97.60*/("""
            """),_display_(/*98.14*/views/*98.19*/.html.iot.deviceType.DeviceTypeList_edit()),format.raw/*98.61*/("""

            """),_display_(/*100.14*/views/*100.19*/.html.Loading()),format.raw/*100.34*/("""

        """),format.raw/*102.9*/("""</div>
            <!--  END OF PAPER WRAP -->

    </body>
    """),_display_(/*106.6*/views/*106.11*/.html.iot.tags.Main_js()),format.raw/*106.35*/("""

    """),format.raw/*108.5*/("""<script src=""""),_display_(/*108.19*/routes/*108.25*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*108.79*/(""""></script>
        <!--plugins-->
    <script src=""""),_display_(/*110.19*/routes/*110.25*/.Assets.versioned("assets/plugins/simplebar/js/simplebar.min.js")),format.raw/*110.90*/(""""></script>
    <script src=""""),_display_(/*111.19*/routes/*111.25*/.Assets.versioned("assets/plugins/metismenu/js/metisMenu.min.js")),format.raw/*111.90*/(""""></script>
    <script src=""""),_display_(/*112.19*/routes/*112.25*/.Assets.versioned("assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js")),format.raw/*112.102*/(""""></script>
    <script>
                $(document).ready(function () """),format.raw/*114.47*/("""{"""),format.raw/*114.48*/("""
                    """),format.raw/*115.21*/("""$("#menu-type").addClass("mm-active");
                    $("#menu").metisMenu();
                """),format.raw/*117.17*/("""}"""),format.raw/*117.18*/(""")
        </script>

    <script src=""""),_display_(/*120.19*/routes/*120.25*/.Assets.versioned("javascripts/SearchJs.js")),format.raw/*120.69*/("""" type="text/javascript"></script>

    <script>
                $(document).ready(function() """),format.raw/*123.46*/("""{"""),format.raw/*123.47*/("""
                    """),format.raw/*124.21*/("""var table = $('#dataTables').DataTable( """),format.raw/*124.61*/("""{"""),format.raw/*124.62*/("""
                        """),format.raw/*125.25*/("""responsive: true,
                        lengthChange: false,
//                        buttons: [ 'excel', 'pdf', 'print'],
                        "order": [],
                        "info": false
                    """),format.raw/*130.21*/("""}"""),format.raw/*130.22*/(""" """),format.raw/*130.23*/(""");
                    $("#dataTables_filter input")[0].maxLength = 30;

//                    table.buttons().container()
//                            .appendTo( '#dataTables_wrapper .col-md-6:eq(0)' );
                """),format.raw/*135.17*/("""}"""),format.raw/*135.18*/(""" """),format.raw/*135.19*/(""");
        </script>

    <script src=""""),_display_(/*138.19*/routes/*138.25*/.Assets.versioned("javascripts/views/group/jstree.js")),format.raw/*138.79*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*139.19*/routes/*139.25*/.Assets.versioned("javascripts/views/deviceType/DeviceType.js")),format.raw/*139.88*/(""""></script>
    <script src=""""),_display_(/*140.19*/routes/*140.25*/.Assets.versioned("javascripts/views/deviceType/DeviceType_add.js")),format.raw/*140.92*/(""""></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,deviceTypeList:List[DeviceType],projectId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,deviceTypeList,projectId)

  def f:((User,List[DeviceType],String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,deviceTypeList,projectId) => apply(currentUser,deviceTypeList,projectId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:44 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/deviceType/DeviceTypeList.scala.html
                  HASH: 1ab81366b7da6abffb9e0048149486ed6a2a9a42
                  MATRIX: 666->1|689->18|725->48|765->82|808->119|846->151|1232->203|1397->273|1424->274|1607->430|1652->454|1737->512|1752->518|1809->554|2029->747|2043->752|2089->777|2126->787|2166->800|2181->806|2260->864|2330->907|2345->913|2420->967|2519->1039|2533->1044|2597->1087|2635->1098|2649->1103|2704->1137|2741->1147|3017->1396|3063->1421|3497->1828|3548->1857|4240->2522|4291->2551|4348->2580|4747->2952|4782->2966|4874->3031|4918->3054|5018->3127|5070->3158|5144->3205|5186->3226|5347->3360|5409->3406|5449->3408|5514->3445|5591->3495|5610->3505|5637->3511|5715->3562|5734->3572|5763->3580|5841->3631|5860->3641|5901->3661|6101->3834|6141->3853|6219->3903|6239->3913|6267->3919|6300->3924|6320->3934|6350->3942|6648->4213|6690->4234|6770->4286|6790->4296|6818->4302|7166->4619|7227->4652|7415->4813|7429->4818|7491->4859|7532->4873|7546->4878|7608->4919|7649->4933|7663->4938|7726->4980|7769->4995|7784->5000|7821->5015|7859->5025|7951->5090|7966->5095|8012->5119|8046->5125|8088->5139|8104->5145|8180->5199|8261->5252|8277->5258|8364->5323|8422->5353|8438->5359|8525->5424|8583->5454|8599->5460|8699->5537|8799->5608|8829->5609|8879->5630|9007->5729|9037->5730|9104->5769|9120->5775|9186->5819|9309->5913|9339->5914|9389->5935|9458->5975|9488->5976|9542->6001|9792->6222|9822->6223|9852->6224|10102->6445|10132->6446|10162->6447|10230->6487|10246->6493|10322->6547|10403->6600|10419->6606|10504->6669|10562->6699|10578->6705|10667->6772
                  LINES: 24->1|25->2|26->3|27->4|28->5|29->6|34->7|39->7|40->8|45->13|45->13|46->14|46->14|46->14|51->19|51->19|51->19|53->21|53->21|53->21|53->21|54->22|54->22|54->22|58->26|58->26|58->26|60->28|60->28|60->28|62->30|67->35|67->35|73->41|73->41|87->55|87->55|88->56|97->65|97->65|98->66|98->66|99->67|99->67|100->68|100->68|104->72|104->72|104->72|105->73|106->74|106->74|106->74|107->75|107->75|107->75|108->76|108->76|108->76|110->78|110->78|110->78|110->78|110->78|110->78|110->78|110->78|113->81|113->81|113->81|113->81|113->81|119->87|120->88|128->96|128->96|128->96|129->97|129->97|129->97|130->98|130->98|130->98|132->100|132->100|132->100|134->102|138->106|138->106|138->106|140->108|140->108|140->108|140->108|142->110|142->110|142->110|143->111|143->111|143->111|144->112|144->112|144->112|146->114|146->114|147->115|149->117|149->117|152->120|152->120|152->120|155->123|155->123|156->124|156->124|156->124|157->125|162->130|162->130|162->130|167->135|167->135|167->135|170->138|170->138|170->138|171->139|171->139|171->139|172->140|172->140|172->140
                  -- GENERATED --
              */
          