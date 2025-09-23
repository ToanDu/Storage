
package views.html.iot.attribute.device

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
/*2.2*/import vn.m2m.common.models.User

object AttributeDevice extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, projectId:String, deviceId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*84.22*/fromTime/*84.30*/ = {{
                      import java.util.Calendar
                      import java.text.SimpleDateFormat

                      val today = Calendar.getInstance
                      today.add(Calendar.DATE, -1);
                      val curTimeFormat = new SimpleDateFormat("dd/MM/yyyy")
                      curTimeFormat.format(today.getTime)
                    }};def /*93.22*/toTime/*93.28*/ = {{
                      import java.util.Calendar
                      import java.text.SimpleDateFormat

                      val today = Calendar.getInstance()
                      today.add(Calendar.DATE, +1);
                      val curTimeFormat = new SimpleDateFormat("dd/MM/yyyy")
                      curTimeFormat.format(today.getTime)
                    }};
Seq[Any](format.raw/*3.55*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("Device Attribute")),format.raw/*9.41*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""


    """),format.raw/*18.95*/("""
    """),format.raw/*19.5*/("""<link href='"""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*19.73*/("""' type='text/css'>
    <link rel="stylesheet" href=""""),_display_(/*20.35*/routes/*20.41*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*20.156*/("""">

    <style>
            .form-control:disabled, .form-control[readonly] """),format.raw/*23.61*/("""{"""),format.raw/*23.62*/("""
              """),format.raw/*24.15*/("""background-color: #aaa;
              opacity: 1;
            """),format.raw/*26.13*/("""}"""),format.raw/*26.14*/("""
            """),format.raw/*27.13*/(""".form-control """),format.raw/*27.27*/("""{"""),format.raw/*27.28*/("""
              """),format.raw/*28.15*/("""background-color: #aaa;
              color: #dee2e6;
            """),format.raw/*30.13*/("""}"""),format.raw/*30.14*/("""
    """),format.raw/*31.5*/("""</style>

  </head>
  <body class="bg-theme">
    """),_display_(/*35.6*/views/*35.11*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*35.54*/("""

    """),_display_(/*37.6*/views/*37.11*/.html.iot.tags.Header(currentUser)),format.raw/*37.45*/("""

    """),format.raw/*39.5*/("""<div class="page-wrapper">
      <div class="page-content">

        <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
          <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF;">
            """),_display_(/*44.14*/Messages("manage.group.title")),format.raw/*44.44*/(""" """),format.raw/*44.45*/("""<i class="bx bx-caret-right" aria-hidden="true"></i>
            """),_display_(/*45.14*/Messages("manage.group.device")),format.raw/*45.45*/(""" """),format.raw/*45.46*/("""<i class="bx bx-caret-right" aria-hidden="true"></i>
            """),_display_(/*46.14*/Messages("btnAttr")),_display_(/*46.34*/Messages(" (Device ID: ")),_display_(/*46.60*/deviceId),_display_(/*46.69*/Messages(")")),format.raw/*46.82*/("""
          """),format.raw/*47.11*/("""</span>
        </div>

        <div class="card mt-3">
          <div class="card-body">
            <ul class="nav nav-tabs" role="tablist">
              <li class="nav-item" role="presentation" onclick="">
                <a class="nav-link active" data-bs-toggle="tab" href="#listAttributeDevice" role="tab" aria-selected="false">
                  <div class="d-flex align-items-center">
                    <div class="tab-icon"><i class='bx bx-list-ol font-18 me-1'></i>
                    </div>
                    <div class="tab-title">"""),_display_(/*58.45*/Messages("Danh sách thuộc tính")),format.raw/*58.77*/("""</div>
                  </div>
                </a>
              </li>
              <li class="nav-item" role="presentation">
                <a class="nav-link" data-bs-toggle="tab" href="#historyAttributeDevice" role="tab" aria-selected="false">
                  <div class="d-flex align-items-center">
                    <div class="tab-icon"><i class='bx bx-history font-18 me-1'></i>
                    </div>
                    <div class="tab-title">"""),_display_(/*67.45*/Messages("Lịch sử bản tin")),format.raw/*67.72*/("""</div>
                  </div>
                </a>
              </li>
            </ul>
            <div class="tab-content py-3">
              <div class="tab-pane fade show active" id="listAttributeDevice" role="tabpanel">
                <div class="card-body">
                  <div id="tabAttribute" class="body-nest"></div>
                </div>
              </div>
              <div class="tab-pane fade" id="historyAttributeDevice" role="tabpanel">
                <div class="card-body">

                  <form class="row g-3">
                    <div class="col-md-5"></div>

                    """),format.raw/*92.22*/("""
                    """),format.raw/*101.22*/("""
                    """),format.raw/*102.21*/("""<div class="col-md-3">
                      <div class="input-group" id="datePickerFrom">
                        <span class="input-group-text"><i class='bx bxs-calendar'></i></span>
                        <input class="result form-control" type="text" id="dateFrom" value=""""),_display_(/*105.94*/fromTime),format.raw/*105.102*/("""" placeholder="Từ...">
                      </div>
                    </div>
                    <div class="col-md-3">
                      <div class="input-group" id="datePickerTo">
                        <span class="input-group-text"><i class='bx bxs-calendar'></i></span>
                        <input class="result form-control" type="text" id="dateTo" value=""""),_display_(/*111.92*/toTime),format.raw/*111.98*/("""" placeholder="Đến...">
                      </div>
                    </div>
                    <div class="col-md-1">
                      <button type="button" class="btn btn-secondary" onclick="searchHistoryAttributeDevice()"><i class="bx bxs-search"></i>"""),_display_(/*115.142*/Messages("Tìm")),format.raw/*115.157*/("""</button>
                    </div>
                  </form>

                  <div id="tabHistory" class="body-nest mt-3"></div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>
    </div>

    """),_display_(/*129.6*/views/*129.11*/.html.iot.attribute.device.AttributeDevice_add()),format.raw/*129.59*/("""
    """),_display_(/*130.6*/views/*130.11*/.html.iot.attribute.device.AttributeDevice_edit()),format.raw/*130.60*/("""
    """),_display_(/*131.6*/views/*131.11*/.html.iot.attribute.device.AttributeDevice_del()),format.raw/*131.59*/("""

    """),_display_(/*133.6*/views/*133.11*/.html.Loading()),format.raw/*133.26*/("""
  """),format.raw/*134.3*/("""</body>

  """),_display_(/*136.4*/views/*136.9*/.html.iot.tags.Main_js()),format.raw/*136.33*/("""

  """),format.raw/*138.3*/("""<script>
    var iconEdit = """"),_display_(/*139.22*/routes/*139.28*/.Assets.versioned("images/icon/edit.png")),format.raw/*139.69*/("""";
    var iconDelete = """"),_display_(/*140.24*/routes/*140.30*/.Assets.versioned("images/icon/delete.png")),format.raw/*140.73*/("""";

          var projectId = '"""),_display_(/*142.29*/projectId),format.raw/*142.38*/("""';
          var deviceId = '"""),_display_(/*143.28*/deviceId),format.raw/*143.36*/("""';

          $(document).ready(function () """),format.raw/*145.41*/("""{"""),format.raw/*145.42*/("""
            """),format.raw/*146.13*/("""$("#menu-org").addClass("mm-active");

            $("#menu").metisMenu();

            $('#dateFrom').bootstrapMaterialDatePicker("""),format.raw/*150.56*/("""{"""),format.raw/*150.57*/("""
              """),format.raw/*151.15*/("""time: false,
              format: 'DD-MM-YYYY'
            """),format.raw/*153.13*/("""}"""),format.raw/*153.14*/(""");
            $('#dateTo').bootstrapMaterialDatePicker("""),format.raw/*154.54*/("""{"""),format.raw/*154.55*/("""
              """),format.raw/*155.15*/("""time: false,
              format: 'DD-MM-YYYY'
            """),format.raw/*157.13*/("""}"""),format.raw/*157.14*/(""");
          """),format.raw/*158.11*/("""}"""),format.raw/*158.12*/(""")
  </script>

  <script src=""""),_display_(/*161.17*/routes/*161.23*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.min.js")),format.raw/*161.136*/(""""></script>

  <script src=""""),_display_(/*163.17*/routes/*163.23*/.Assets.versioned("javascripts/views/attribute/device/AttributeDevice.js")),format.raw/*163.97*/(""""></script>
  <script src=""""),_display_(/*164.17*/routes/*164.23*/.Assets.versioned("javascripts/views/attribute/device/AttributeDevice_history.js")),format.raw/*164.105*/(""""></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,projectId:String,deviceId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,projectId,deviceId)

  def f:((User,String,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,projectId,deviceId) => apply(currentUser,projectId,deviceId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:42 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/attribute/device/AttributeDevice.scala.html
                  HASH: a051a12d8db8370ef08ce39a55d86697039f8f32
                  MATRIX: 672->1|695->18|1054->52|1187->3588|1204->3596|1593->3992|1608->3998|2014->105|2041->106|2209->248|2257->276|2338->330|2353->336|2410->372|2617->553|2631->558|2677->583|2712->680|2744->685|2784->698|2799->704|2869->753|2949->806|2964->812|3101->927|3205->1003|3234->1004|3277->1019|3367->1081|3396->1082|3437->1095|3479->1109|3508->1110|3551->1125|3645->1191|3674->1192|3706->1197|3783->1248|3797->1253|3861->1296|3894->1303|3908->1308|3963->1342|3996->1348|4297->1622|4348->1652|4377->1653|4470->1719|4522->1750|4551->1751|4644->1817|4684->1837|4730->1863|4759->1872|4793->1885|4832->1896|5409->2446|5462->2478|5954->2943|6002->2970|6647->3970|6697->4374|6747->4395|7053->4673|7084->4681|7485->5054|7513->5060|7806->5324|7844->5339|8130->5598|8145->5603|8215->5651|8248->5657|8263->5662|8334->5711|8367->5717|8382->5722|8452->5770|8486->5777|8501->5782|8538->5797|8569->5800|8608->5812|8622->5817|8668->5841|8700->5845|8758->5875|8774->5881|8837->5922|8891->5948|8907->5954|8972->5997|9032->6029|9063->6038|9121->6068|9151->6076|9224->6120|9254->6121|9296->6134|9456->6265|9486->6266|9530->6281|9619->6341|9649->6342|9734->6398|9764->6399|9808->6414|9897->6474|9927->6475|9969->6488|9999->6489|10058->6520|10074->6526|10210->6639|10267->6668|10283->6674|10379->6748|10435->6776|10451->6782|10556->6864
                  LINES: 24->1|25->2|30->3|34->84|34->84|42->93|42->93|51->3|52->4|57->9|57->9|58->10|58->10|58->10|63->15|63->15|63->15|66->18|67->19|67->19|67->19|67->19|68->20|68->20|68->20|71->23|71->23|72->24|74->26|74->26|75->27|75->27|75->27|76->28|78->30|78->30|79->31|83->35|83->35|83->35|85->37|85->37|85->37|87->39|92->44|92->44|92->44|93->45|93->45|93->45|94->46|94->46|94->46|94->46|94->46|95->47|106->58|106->58|115->67|115->67|132->92|133->101|134->102|137->105|137->105|143->111|143->111|147->115|147->115|161->129|161->129|161->129|162->130|162->130|162->130|163->131|163->131|163->131|165->133|165->133|165->133|166->134|168->136|168->136|168->136|170->138|171->139|171->139|171->139|172->140|172->140|172->140|174->142|174->142|175->143|175->143|177->145|177->145|178->146|182->150|182->150|183->151|185->153|185->153|186->154|186->154|187->155|189->157|189->157|190->158|190->158|193->161|193->161|193->161|195->163|195->163|195->163|196->164|196->164|196->164
                  -- GENERATED --
              */
          