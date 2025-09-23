
package views.html.telco.devices

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
/*1.2*/import vn.m2m.common.models.User

object Device extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser: User, userId: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.37*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>"""),_display_(/*9.11*/Messages("Quản lý thiết bị")),format.raw/*9.39*/("""</title>
  <link rel="icon" type="image/png" href=""""),_display_(/*10.44*/routes/*10.50*/.Assets.versioned("images/logo.jpg")),format.raw/*10.86*/("""">

  <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
  <meta name="viewport" content="width=device-width" />

  """),_display_(/*15.4*/views/*15.9*/.html.iot.tags.Main_css()),format.raw/*15.34*/("""

  """),format.raw/*17.3*/("""<link href=""""),_display_(/*17.16*/routes/*17.22*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*17.76*/("""" rel="stylesheet" />
  <link href=""""),_display_(/*18.16*/routes/*18.22*/.Assets.versioned("assets/plugins/input-tags/css/tagsinput.css")),format.raw/*18.86*/("""" rel="stylesheet" />
  """),format.raw/*21.5*/("""
  """),format.raw/*22.3*/("""<link href='"""),_display_(/*22.16*/routes/*22.22*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*22.71*/("""' type='text/css'>
  """),format.raw/*25.5*/("""
  """),format.raw/*26.3*/("""<link href=""""),_display_(/*26.16*/routes/*26.22*/.Assets.versioned("stylesheets/bootstrap/datepicker.min.css")),format.raw/*26.83*/("""" rel="stylesheet" />
  <link href=""""),_display_(/*27.16*/routes/*27.22*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*27.76*/("""" rel="stylesheet" />
</head>

<body class="bg-theme">
  """),_display_(/*31.4*/views/*31.9*/.html.telco.Menu(currentUser, "", userId)),format.raw/*31.50*/("""
  """),_display_(/*32.4*/views/*32.9*/.html.telco.Header(currentUser)),format.raw/*32.40*/("""

  """),format.raw/*34.3*/("""<div class="page-wrapper">
    <div class="page-content">

      """),_display_(/*37.8*/views/*37.13*/.html.telco.devices.Device_formSearch(currentUser)),format.raw/*37.63*/("""

      """),format.raw/*39.7*/("""<div class="card">
        <div class="card-body">
          <div class="table-responsive" style="border-radius: 8px;">
            <table class="table table-striped" id="listDeviceTable" style="width: 100%;">
              <thead style="background-color: #FBCCD6;">
                <tr>
                  <th>STT</th>
                  <th>Số thuê bao</th>
                  <th>Serial sim</th>
                  <th>Trạng thái thuê bao</th>
                  <th>Imei thiết bị</th>
                  <th>Loại thiết bị</th>
                  <th>Tên thiết bị</th>
                  <th>Hãng sản xuất</th>
                  <th>Công nghệ hỗ trợ</th>
                  <th>Thao tác</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>0912345678</td>
                  <td>1234567891234567890</td>
                  <td>Bình thường</td>
                  <td>WW-XXXXXX-YYYYYY-Z</td>
                  <td>Cảm biến</td>
                  <td>TEST-DEVICE-1</td>
                  <td>Viettel</td>
                  <td>5G</td>
                  <td class="text-center">
                   <i title="Xem lịch sử" id="test" class='bx bx-history' style="font-size: 25px; cursor: pointer;"></i> 
                  </td>
                </tr>
              </tbody>
            </table>
            <h5 id="notiNotDataDevice" style="text-align: center;"></h5>
          </div>
          <div class="material-datatables row row-cols-auto g-3" style="margin: 5px; margin-bottom: 10px;"
            id="divPagingTable">
            <div class="row">
              <div class="col-md-4">
                <div class="dropdown">
                  <button class="btn dropdown-toggle text-white" type="button" data-bs-toggle="dropdown"
                    aria-expanded="false" id="countPageSize"
                    style="background-color: rgb(0 0 0 / 50%);; margin-left: 5px;">10</button>
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
                <div class="dataTables_paginate paging_full_numbers" id="pagingTable"
                  style="cursor: pointer; right: 5px; position: absolute;"></div>
              </div>
            </div>

            <input name="page" id="page" value="1" style="display: none">
            <input name="pageSize" id="pageSize" value="10" style="display: none">
            <input name="isResetPage" id="isResetPage" value="false" style="display: none">
          </div>
        </div>
      </div>
    </div>
    """),_display_(/*106.6*/views/*106.11*/.html.telco.devices.Device_history_modal()),format.raw/*106.53*/("""
    """),_display_(/*107.6*/views/*107.11*/.html.telco.Loading()),format.raw/*107.32*/("""
  """),format.raw/*108.3*/("""</div>
  <!-- END OF PAPER WRAP -->
  """),_display_(/*110.4*/views/*110.9*/.html.telco.mainJs()),format.raw/*110.29*/("""
  """),format.raw/*111.3*/("""<script src=""""),_display_(/*111.17*/routes/*111.23*/.Assets.versioned(" javascripts/bootstrap/bootstrap-datepicker.min.js")),format.raw/*111.94*/("""" type="text/javascript"></script>
  <script>
    var userId = '"""),_display_(/*113.20*/userId),format.raw/*113.26*/("""';
    $("#test").on('click', function () """),format.raw/*114.40*/("""{"""),format.raw/*114.41*/("""
      """),format.raw/*115.7*/("""$('#modal_history').modal("show");
    """),format.raw/*116.5*/("""}"""),format.raw/*116.6*/(""");
  </script>
</body>

</html>"""))
      }
    }
  }

  def render(currentUser:User,userId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,userId)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,userId) => apply(currentUser,userId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:52 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/devices/Device.scala.html
                  HASH: 494e09319d34e37da1c4d4c98f506c5d0a481d8d
                  MATRIX: 665->1|1008->35|1138->70|1165->71|1326->206|1374->234|1453->286|1468->292|1525->328|1726->503|1739->508|1785->533|1816->537|1856->550|1871->556|1946->610|2010->647|2025->653|2110->717|2161->837|2191->840|2231->853|2246->859|2316->908|2364->1092|2394->1095|2434->1108|2449->1114|2531->1175|2595->1212|2610->1218|2685->1272|2769->1330|2782->1335|2844->1376|2874->1380|2887->1385|2939->1416|2970->1420|3062->1486|3076->1491|3147->1541|3182->1549|6361->4701|6376->4706|6440->4748|6473->4754|6488->4759|6531->4780|6562->4783|6628->4822|6642->4827|6684->4847|6715->4850|6757->4864|6773->4870|6866->4941|6959->5006|6987->5012|7058->5054|7088->5055|7123->5062|7190->5101|7219->5102
                  LINES: 24->1|29->2|34->2|35->3|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->21|52->22|52->22|52->22|52->22|53->25|54->26|54->26|54->26|54->26|55->27|55->27|55->27|59->31|59->31|59->31|60->32|60->32|60->32|62->34|65->37|65->37|65->37|67->39|134->106|134->106|134->106|135->107|135->107|135->107|136->108|138->110|138->110|138->110|139->111|139->111|139->111|139->111|141->113|141->113|142->114|142->114|143->115|144->116|144->116
                  -- GENERATED --
              */
          