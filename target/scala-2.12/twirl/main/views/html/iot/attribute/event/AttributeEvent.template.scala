
package views.html.iot.attribute.event

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

object AttributeEvent extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, projectId:String, eventId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*85.22*/fromTime/*85.30*/ = {{
                      import java.util.Calendar
                      import java.text.SimpleDateFormat

                      val today = Calendar.getInstance
                      today.add(Calendar.DATE, -1);
                      val curTimeFormat = new SimpleDateFormat("dd/MM/yyyy")
                      curTimeFormat.format(today.getTime)
                    }};def /*94.22*/toTime/*94.28*/ = {{
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
    <title>"""),_display_(/*9.13*/Messages("Event Attribute")),format.raw/*9.40*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""


    """),format.raw/*18.95*/("""
    """),format.raw/*19.5*/("""<link href='"""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*19.73*/("""' type='text/css'>
    <link href=""""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*20.99*/("""" rel="stylesheet">
    <link rel="stylesheet" href=""""),_display_(/*21.35*/routes/*21.41*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*21.156*/("""">

    <style>
            .form-control:disabled, .form-control[readonly] """),format.raw/*24.61*/("""{"""),format.raw/*24.62*/("""
              """),format.raw/*25.15*/("""background-color: #aaa;
              opacity: 1;
            """),format.raw/*27.13*/("""}"""),format.raw/*27.14*/("""
            """),format.raw/*28.13*/(""".form-control """),format.raw/*28.27*/("""{"""),format.raw/*28.28*/("""
              """),format.raw/*29.15*/("""background-color: #aaa;
              color: #dee2e6;
            """),format.raw/*31.13*/("""}"""),format.raw/*31.14*/("""
    """),format.raw/*32.5*/("""</style>

  </head>
  <body class="bg-theme">
    """),_display_(/*36.6*/views/*36.11*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*36.54*/("""

    """),_display_(/*38.6*/views/*38.11*/.html.iot.tags.Header(currentUser)),format.raw/*38.45*/("""

    """),format.raw/*40.5*/("""<div class="page-wrapper">
      <div class="page-content">

        <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
          <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF;">
            """),_display_(/*45.14*/Messages("manage.group.title")),format.raw/*45.44*/(""" """),format.raw/*45.45*/("""<i class="bx bx-caret-right" aria-hidden="true"></i>
            """),_display_(/*46.14*/Messages("manage.group.event")),format.raw/*46.44*/(""" """),format.raw/*46.45*/("""<i class="bx bx-caret-right" aria-hidden="true"></i>
            """),_display_(/*47.14*/Messages("btnAttr")),_display_(/*47.34*/Messages(" (Event ID: ")),_display_(/*47.59*/eventId),_display_(/*47.67*/Messages(")")),format.raw/*47.80*/("""
          """),format.raw/*48.11*/("""</span>
        </div>

        <div class="card mt-3">
          <div class="card-body">
            <ul class="nav nav-tabs" role="tablist">
              <li class="nav-item" role="presentation" onclick="">
                <a class="nav-link active" data-bs-toggle="tab" href="#listAttribute" role="tab" aria-selected="false">
                  <div class="d-flex align-items-center">
                    <div class="tab-icon"><i class='bx bx-list-ol font-18 me-1'></i>
                    </div>
                    <div class="tab-title">"""),_display_(/*59.45*/Messages("Danh sách thuộc tính")),format.raw/*59.77*/("""</div>
                  </div>
                </a>
              </li>
              <li class="nav-item" role="presentation">
                <a class="nav-link" data-bs-toggle="tab" href="#historyAttribute" role="tab" aria-selected="false">
                  <div class="d-flex align-items-center">
                    <div class="tab-icon"><i class='bx bx-history font-18 me-1'></i>
                    </div>
                    <div class="tab-title">"""),_display_(/*68.45*/Messages("Lịch sử bản tin")),format.raw/*68.72*/("""</div>
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

                    """),format.raw/*93.22*/("""
                    """),format.raw/*102.22*/("""
                    """),format.raw/*103.21*/("""<div class="col-md-3">
                      <div class="input-group" id="datePickerFrom">
                        <span class="input-group-text"><i class='bx bxs-calendar'></i></span>
                        <input class="result form-control" type="text" id="dateFrom" value=""""),_display_(/*106.94*/fromTime),format.raw/*106.102*/("""" placeholder="Từ...">
                      </div>
                    </div>
                    <div class="col-md-3">
                      <div class="input-group" id="datePickerTo">
                        <span class="input-group-text"><i class='bx bxs-calendar'></i></span>
                        <input class="result form-control" type="text" id="dateTo" value=""""),_display_(/*112.92*/toTime),format.raw/*112.98*/("""" placeholder="Đến...">
                      </div>
                    </div>
                    <div class="col-md-1">
                      <button type="button" class="btn btn-secondary" onclick="searchHistoryAttributeEvent()"><i class="bx bxs-search"></i>"""),_display_(/*116.141*/Messages("Tìm")),format.raw/*116.156*/("""</button>
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

    """),_display_(/*130.6*/views/*130.11*/.html.iot.attribute.event.AttributeEvent_add()),format.raw/*130.57*/("""
    """),_display_(/*131.6*/views/*131.11*/.html.iot.attribute.event.AttributeEvent_edit()),format.raw/*131.58*/("""
    """),_display_(/*132.6*/views/*132.11*/.html.iot.attribute.event.AttributeEvent_del()),format.raw/*132.57*/("""

    """),_display_(/*134.6*/views/*134.11*/.html.Loading()),format.raw/*134.26*/("""
  """),format.raw/*135.3*/("""</body>

  """),_display_(/*137.4*/views/*137.9*/.html.iot.tags.Main_js()),format.raw/*137.33*/("""

  """),format.raw/*139.3*/("""<script>
    var iconEdit = """"),_display_(/*140.22*/routes/*140.28*/.Assets.versioned("images/icon/edit.png")),format.raw/*140.69*/("""";
    var iconDelete = """"),_display_(/*141.24*/routes/*141.30*/.Assets.versioned("images/icon/delete.png")),format.raw/*141.73*/("""";

          var projectId = '"""),_display_(/*143.29*/projectId),format.raw/*143.38*/("""';
          var eventId = '"""),_display_(/*144.27*/eventId),format.raw/*144.34*/("""';

          $(document).ready(function () """),format.raw/*146.41*/("""{"""),format.raw/*146.42*/("""
            """),format.raw/*147.13*/("""$("#menu-org").addClass("mm-active");

            $("#menu").metisMenu();

            $('#dateFrom').bootstrapMaterialDatePicker("""),format.raw/*151.56*/("""{"""),format.raw/*151.57*/("""
              """),format.raw/*152.15*/("""time: false,
              format: 'DD-MM-YYYY'
            """),format.raw/*154.13*/("""}"""),format.raw/*154.14*/(""");
            $('#dateTo').bootstrapMaterialDatePicker("""),format.raw/*155.54*/("""{"""),format.raw/*155.55*/("""
              """),format.raw/*156.15*/("""time: false,
              format: 'DD-MM-YYYY'
            """),format.raw/*158.13*/("""}"""),format.raw/*158.14*/(""");
          """),format.raw/*159.11*/("""}"""),format.raw/*159.12*/(""")
  </script>

  <script src=""""),_display_(/*162.17*/routes/*162.23*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.min.js")),format.raw/*162.136*/(""""></script>

  <script src=""""),_display_(/*164.17*/routes/*164.23*/.Assets.versioned("javascripts/views/attribute/event/AttributeEvent.js")),format.raw/*164.95*/(""""></script>
  <script src=""""),_display_(/*165.17*/routes/*165.23*/.Assets.versioned("javascripts/views/attribute/event/AttributeEvent_history.js")),format.raw/*165.103*/(""""></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,projectId:String,eventId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,projectId,eventId)

  def f:((User,String,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,projectId,eventId) => apply(currentUser,projectId,eventId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:42 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/attribute/event/AttributeEvent.scala.html
                  HASH: fd66aa6c12f6eecddfb5e68dfb7e8d94ea5eaad4
                  MATRIX: 671->1|694->18|1052->52|1184->3677|1201->3685|1590->4081|1605->4087|2011->104|2038->105|2206->247|2253->274|2334->328|2349->334|2406->370|2613->551|2627->556|2673->581|2708->678|2740->683|2780->696|2795->702|2865->751|2928->787|2943->793|3039->868|3120->922|3135->928|3272->1043|3376->1119|3405->1120|3448->1135|3538->1197|3567->1198|3608->1211|3650->1225|3679->1226|3722->1241|3816->1307|3845->1308|3877->1313|3954->1364|3968->1369|4032->1412|4065->1419|4079->1424|4134->1458|4167->1464|4468->1738|4519->1768|4548->1769|4641->1835|4692->1865|4721->1866|4814->1932|4854->1952|4899->1977|4927->1985|4961->1998|5000->2009|5571->2553|5624->2585|6110->3044|6158->3071|6791->4059|6841->4463|6891->4484|7197->4762|7228->4770|7629->5143|7657->5149|7949->5412|7987->5427|8273->5686|8288->5691|8356->5737|8389->5743|8404->5748|8473->5795|8506->5801|8521->5806|8589->5852|8623->5859|8638->5864|8675->5879|8706->5882|8745->5894|8759->5899|8805->5923|8837->5927|8895->5957|8911->5963|8974->6004|9028->6030|9044->6036|9109->6079|9169->6111|9200->6120|9257->6149|9286->6156|9359->6200|9389->6201|9431->6214|9591->6345|9621->6346|9665->6361|9754->6421|9784->6422|9869->6478|9899->6479|9943->6494|10032->6554|10062->6555|10104->6568|10134->6569|10193->6600|10209->6606|10345->6719|10402->6748|10418->6754|10512->6826|10568->6854|10584->6860|10687->6940
                  LINES: 24->1|25->2|30->3|34->85|34->85|42->94|42->94|51->3|52->4|57->9|57->9|58->10|58->10|58->10|63->15|63->15|63->15|66->18|67->19|67->19|67->19|67->19|68->20|68->20|68->20|69->21|69->21|69->21|72->24|72->24|73->25|75->27|75->27|76->28|76->28|76->28|77->29|79->31|79->31|80->32|84->36|84->36|84->36|86->38|86->38|86->38|88->40|93->45|93->45|93->45|94->46|94->46|94->46|95->47|95->47|95->47|95->47|95->47|96->48|107->59|107->59|116->68|116->68|133->93|134->102|135->103|138->106|138->106|144->112|144->112|148->116|148->116|162->130|162->130|162->130|163->131|163->131|163->131|164->132|164->132|164->132|166->134|166->134|166->134|167->135|169->137|169->137|169->137|171->139|172->140|172->140|172->140|173->141|173->141|173->141|175->143|175->143|176->144|176->144|178->146|178->146|179->147|183->151|183->151|184->152|186->154|186->154|187->155|187->155|188->156|190->158|190->158|191->159|191->159|194->162|194->162|194->162|196->164|196->164|196->164|197->165|197->165|197->165
                  -- GENERATED --
              */
          