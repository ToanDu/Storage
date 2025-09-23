
package views.html.iot.attribute.group

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

object AttributeGroup extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, projectId:String, groupId:String):play.twirl.api.HtmlFormat.Appendable = {
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
Seq[Any](format.raw/*3.54*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("Group Attribute")),format.raw/*9.40*/("""</title>
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
            """),_display_(/*45.14*/Messages("manage.group.group")),format.raw/*45.44*/(""" """),format.raw/*45.45*/("""<i class="bx bx-caret-right" aria-hidden="true"></i>
            """),_display_(/*46.14*/Messages("btnAttr")),_display_(/*46.34*/Messages(" (Group ID: ")),_display_(/*46.59*/groupId),_display_(/*46.67*/Messages(")")),format.raw/*46.80*/("""
          """),format.raw/*47.11*/("""</span>
        </div>

        <div class="card mt-3">
          <div class="card-body">
            <ul class="nav nav-tabs" role="tablist">
              <li class="nav-item" role="presentation" onclick="">
                <a class="nav-link active" data-bs-toggle="tab" href="#listAttribute" role="tab" aria-selected="false">
                  <div class="d-flex align-items-center">
                    <div class="tab-icon"><i class='bx bx-list-ol font-18 me-1'></i>
                    </div>
                    <div class="tab-title">"""),_display_(/*58.45*/Messages("Danh sách thuộc tính")),format.raw/*58.77*/("""</div>
                  </div>
                </a>
              </li>
              <li class="nav-item" role="presentation">
                <a class="nav-link" data-bs-toggle="tab" href="#historyAttribute" role="tab" aria-selected="false">
                  <div class="d-flex align-items-center">
                    <div class="tab-icon"><i class='bx bx-history font-18 me-1'></i>
                    </div>
                    <div class="tab-title">"""),_display_(/*67.45*/Messages("Lịch sử bản tin")),format.raw/*67.72*/("""</div>
                  </div>
                </a>
              </li>
            </ul>
            <div class="tab-content py-3">
              <div class="tab-pane fade show active" id="listAttribute" role="tabpanel">
                <div class="card-body">
                  <div id="tabAttribute" class="body-nest"></div>
                </div>
              </div>
              <div class="tab-pane fade" id="historyAttribute" role="tabpanel">
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
                      <button type="button" class="btn btn-secondary" onclick="searchHistoryAttributeGroup()"><i class="bx bxs-search"></i>"""),_display_(/*115.141*/Messages("Tìm")),format.raw/*115.156*/("""</button>
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

    """),_display_(/*129.6*/views/*129.11*/.html.iot.attribute.group.AttributeGroup_add()),format.raw/*129.57*/("""
    """),_display_(/*130.6*/views/*130.11*/.html.iot.attribute.group.AttributeGroup_edit()),format.raw/*130.58*/("""
    """),_display_(/*131.6*/views/*131.11*/.html.iot.attribute.group.AttributeGroup_del()),format.raw/*131.57*/("""

    """),_display_(/*133.6*/views/*133.11*/.html.Loading()),format.raw/*133.26*/("""
  """),format.raw/*134.3*/("""</body>

  """),_display_(/*136.4*/views/*136.9*/.html.iot.tags.Main_js()),format.raw/*136.33*/("""

  """),format.raw/*138.3*/("""<script>
    var iconEdit = """"),_display_(/*139.22*/routes/*139.28*/.Assets.versioned("images/icon/edit.png")),format.raw/*139.69*/("""";
    var iconDelete = """"),_display_(/*140.24*/routes/*140.30*/.Assets.versioned("images/icon/delete.png")),format.raw/*140.73*/("""";

          var projectId = '"""),_display_(/*142.29*/projectId),format.raw/*142.38*/("""';
          var groupId = '"""),_display_(/*143.27*/groupId),format.raw/*143.34*/("""';

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

  <script src=""""),_display_(/*163.17*/routes/*163.23*/.Assets.versioned("javascripts/views/attribute/group/AttributeGroup.js")),format.raw/*163.95*/(""""></script>
  <script src=""""),_display_(/*164.17*/routes/*164.23*/.Assets.versioned("javascripts/views/attribute/group/AttributeGroup_history.js")),format.raw/*164.103*/(""""></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,projectId:String,groupId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,projectId,groupId)

  def f:((User,String,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,projectId,groupId) => apply(currentUser,projectId,groupId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:42 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/attribute/group/AttributeGroup.scala.html
                  HASH: ae51504c2592b6ebe83ccaa07b85c4250d296195
                  MATRIX: 671->1|694->18|1052->52|1184->3559|1201->3567|1590->3963|1605->3969|2011->104|2038->105|2206->247|2253->274|2334->328|2349->334|2406->370|2613->551|2627->556|2673->581|2708->678|2740->683|2780->696|2795->702|2865->751|2945->804|2960->810|3097->925|3201->1001|3230->1002|3273->1017|3363->1079|3392->1080|3433->1093|3475->1107|3504->1108|3547->1123|3641->1189|3670->1190|3702->1195|3779->1246|3793->1251|3857->1294|3890->1301|3904->1306|3959->1340|3992->1346|4293->1620|4344->1650|4373->1651|4466->1717|4517->1747|4546->1748|4639->1814|4679->1834|4724->1859|4752->1867|4786->1880|4825->1891|5396->2435|5449->2467|5935->2926|5983->2953|6616->3941|6666->4345|6716->4366|7022->4644|7053->4652|7454->5025|7482->5031|7774->5294|7812->5309|8098->5568|8113->5573|8181->5619|8214->5625|8229->5630|8298->5677|8331->5683|8346->5688|8414->5734|8448->5741|8463->5746|8500->5761|8531->5764|8570->5776|8584->5781|8630->5805|8662->5809|8720->5839|8736->5845|8799->5886|8853->5912|8869->5918|8934->5961|8994->5993|9025->6002|9082->6031|9111->6038|9184->6082|9214->6083|9256->6096|9416->6227|9446->6228|9490->6243|9579->6303|9609->6304|9694->6360|9724->6361|9768->6376|9857->6436|9887->6437|9929->6450|9959->6451|10018->6482|10034->6488|10170->6601|10227->6630|10243->6636|10337->6708|10393->6736|10409->6742|10512->6822
                  LINES: 24->1|25->2|30->3|34->84|34->84|42->93|42->93|51->3|52->4|57->9|57->9|58->10|58->10|58->10|63->15|63->15|63->15|66->18|67->19|67->19|67->19|67->19|68->20|68->20|68->20|71->23|71->23|72->24|74->26|74->26|75->27|75->27|75->27|76->28|78->30|78->30|79->31|83->35|83->35|83->35|85->37|85->37|85->37|87->39|92->44|92->44|92->44|93->45|93->45|93->45|94->46|94->46|94->46|94->46|94->46|95->47|106->58|106->58|115->67|115->67|132->92|133->101|134->102|137->105|137->105|143->111|143->111|147->115|147->115|161->129|161->129|161->129|162->130|162->130|162->130|163->131|163->131|163->131|165->133|165->133|165->133|166->134|168->136|168->136|168->136|170->138|171->139|171->139|171->139|172->140|172->140|172->140|174->142|174->142|175->143|175->143|177->145|177->145|178->146|182->150|182->150|183->151|185->153|185->153|186->154|186->154|187->155|189->157|189->157|190->158|190->158|193->161|193->161|193->161|195->163|195->163|195->163|196->164|196->164|196->164
                  -- GENERATED --
              */
          