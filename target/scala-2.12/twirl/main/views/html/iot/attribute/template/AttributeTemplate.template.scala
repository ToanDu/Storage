
package views.html.iot.attribute.template

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

object AttributeTemplate extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, projectId:String, templateId:String):play.twirl.api.HtmlFormat.Appendable = {
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
Seq[Any](format.raw/*3.57*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("Template Attribute")),format.raw/*9.43*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""


    """),format.raw/*18.5*/("""<link href='"""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*18.73*/("""' type='text/css'>
    <link href=""""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*19.99*/("""" rel="stylesheet">
    """),format.raw/*20.95*/("""
    """),format.raw/*21.5*/("""<link rel="stylesheet" href=""""),_display_(/*21.35*/routes/*21.41*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*21.156*/("""">

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
            """),_display_(/*45.14*/Messages("deviceTemplate.title")),format.raw/*45.46*/(""" """),format.raw/*45.47*/("""<i class="bx bx-caret-right" aria-hidden="true"></i>
            """),_display_(/*46.14*/Messages("btnAttr")),_display_(/*46.34*/Messages(" (Template ID: ")),_display_(/*46.62*/templateId),_display_(/*46.73*/Messages(")")),format.raw/*46.86*/("""
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
                      <button type="button" class="btn btn-secondary" onclick="searchHistoryAttributeTemplate()"><i class="bx bxs-search"></i>"""),_display_(/*115.144*/Messages("Tìm")),format.raw/*115.159*/("""</button>
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

    """),_display_(/*129.6*/views/*129.11*/.html.iot.attribute.template.AttributeTemplate_add()),format.raw/*129.63*/("""
    """),_display_(/*130.6*/views/*130.11*/.html.iot.attribute.template.AttributeTemplate_edit()),format.raw/*130.64*/("""
    """),_display_(/*131.6*/views/*131.11*/.html.iot.attribute.template.AttributeTemplate_del()),format.raw/*131.63*/("""

    """),_display_(/*133.6*/views/*133.11*/.html.Loading()),format.raw/*133.26*/("""
  """),format.raw/*134.3*/("""</body>

  """),_display_(/*136.4*/views/*136.9*/.html.iot.tags.Main_js()),format.raw/*136.33*/("""

  """),format.raw/*138.3*/("""<script>
    var iconEdit = """"),_display_(/*139.22*/routes/*139.28*/.Assets.versioned("images/icon/edit.png")),format.raw/*139.69*/("""";
    var iconDelete = """"),_display_(/*140.24*/routes/*140.30*/.Assets.versioned("images/icon/delete.png")),format.raw/*140.73*/("""";

          var projectId = '"""),_display_(/*142.29*/projectId),format.raw/*142.38*/("""';
          var templateId = '"""),_display_(/*143.30*/templateId),format.raw/*143.40*/("""';

          $(document).ready(function () """),format.raw/*145.41*/("""{"""),format.raw/*145.42*/("""
            """),format.raw/*146.13*/("""$("#menu-deviceTemplate").addClass("mm-active");

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

  <script src=""""),_display_(/*163.17*/routes/*163.23*/.Assets.versioned("javascripts/views/attribute/template/AttributeTemplate.js")),format.raw/*163.101*/(""""></script>
  <script src=""""),_display_(/*164.17*/routes/*164.23*/.Assets.versioned("javascripts/views/attribute/template/AttributeTemplate_history.js")),format.raw/*164.109*/(""""></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,projectId:String,templateId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,projectId,templateId)

  def f:((User,String,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,projectId,templateId) => apply(currentUser,projectId,templateId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:42 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/attribute/template/AttributeTemplate.scala.html
                  HASH: d4a97fca6522cc6cc3dae523d291f31ad7a92ac0
                  MATRIX: 674->1|697->18|1058->52|1193->3594|1210->3602|1599->3998|1614->4004|2020->107|2047->108|2215->250|2265->280|2346->334|2361->340|2418->376|2625->557|2639->562|2685->587|2719->594|2759->607|2774->613|2844->662|2907->698|2922->704|3018->779|3070->893|3102->898|3159->928|3174->934|3311->1049|3415->1125|3444->1126|3487->1141|3577->1203|3606->1204|3647->1217|3689->1231|3718->1232|3761->1247|3855->1313|3884->1314|3916->1319|3993->1370|4007->1375|4071->1418|4104->1425|4118->1430|4173->1464|4206->1470|4507->1744|4560->1776|4589->1777|4682->1843|4722->1863|4770->1891|4801->1902|4835->1915|4874->1926|5445->2470|5498->2502|5984->2961|6032->2988|6665->3976|6715->4380|6765->4401|7071->4679|7102->4687|7503->5060|7531->5066|7826->5332|7864->5347|8150->5606|8165->5611|8239->5663|8272->5669|8287->5674|8362->5727|8395->5733|8410->5738|8484->5790|8518->5797|8533->5802|8570->5817|8601->5820|8640->5832|8654->5837|8700->5861|8732->5865|8790->5895|8806->5901|8869->5942|8923->5968|8939->5974|9004->6017|9064->6049|9095->6058|9155->6090|9187->6100|9260->6144|9290->6145|9332->6158|9503->6300|9533->6301|9577->6316|9666->6376|9696->6377|9781->6433|9811->6434|9855->6449|9944->6509|9974->6510|10016->6523|10046->6524|10105->6555|10121->6561|10257->6674|10314->6703|10330->6709|10431->6787|10487->6815|10503->6821|10612->6907
                  LINES: 24->1|25->2|30->3|34->84|34->84|42->93|42->93|51->3|52->4|57->9|57->9|58->10|58->10|58->10|63->15|63->15|63->15|66->18|66->18|66->18|66->18|67->19|67->19|67->19|68->20|69->21|69->21|69->21|69->21|72->24|72->24|73->25|75->27|75->27|76->28|76->28|76->28|77->29|79->31|79->31|80->32|84->36|84->36|84->36|86->38|86->38|86->38|88->40|93->45|93->45|93->45|94->46|94->46|94->46|94->46|94->46|95->47|106->58|106->58|115->67|115->67|132->92|133->101|134->102|137->105|137->105|143->111|143->111|147->115|147->115|161->129|161->129|161->129|162->130|162->130|162->130|163->131|163->131|163->131|165->133|165->133|165->133|166->134|168->136|168->136|168->136|170->138|171->139|171->139|171->139|172->140|172->140|172->140|174->142|174->142|175->143|175->143|177->145|177->145|178->146|182->150|182->150|183->151|185->153|185->153|186->154|186->154|187->155|189->157|189->157|190->158|190->158|193->161|193->161|193->161|195->163|195->163|195->163|196->164|196->164|196->164
                  -- GENERATED --
              */
          