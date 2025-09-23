
package views.html.iot.attribute.user

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

object AttributeUser extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, projectId:String, userId:String):play.twirl.api.HtmlFormat.Appendable = {
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
Seq[Any](format.raw/*3.53*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("User Attribute")),format.raw/*9.39*/("""</title>
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
            """),_display_(/*46.14*/Messages("manage.group.group")),format.raw/*46.44*/(""" """),format.raw/*46.45*/("""<i class="bx bx-caret-right" aria-hidden="true"></i>
            """),_display_(/*47.14*/Messages("btnAttr")),_display_(/*47.34*/Messages(" (User ID: ")),_display_(/*47.58*/userId),_display_(/*47.65*/Messages(")")),format.raw/*47.78*/("""
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
                      <button type="button" class="btn btn-secondary" onclick="searchHistoryAttributeUser()"><i class="bx bxs-search"></i>"""),_display_(/*116.140*/Messages("Tìm")),format.raw/*116.155*/("""</button>
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

    """),_display_(/*130.6*/views/*130.11*/.html.iot.attribute.user.AttributeUser_add()),format.raw/*130.55*/("""
    """),_display_(/*131.6*/views/*131.11*/.html.iot.attribute.user.AttributeUser_edit()),format.raw/*131.56*/("""
    """),_display_(/*132.6*/views/*132.11*/.html.iot.attribute.user.AttributeUser_del()),format.raw/*132.55*/("""

    """),_display_(/*134.6*/views/*134.11*/.html.Loading()),format.raw/*134.26*/("""
  """),format.raw/*135.3*/("""</body>

  """),_display_(/*137.4*/views/*137.9*/.html.iot.tags.Main_js()),format.raw/*137.33*/("""

  """),format.raw/*139.3*/("""<script>
    var iconEdit = """"),_display_(/*140.22*/routes/*140.28*/.Assets.versioned("images/icon/edit.png")),format.raw/*140.69*/("""";
    var iconDelete = """"),_display_(/*141.24*/routes/*141.30*/.Assets.versioned("images/icon/delete.png")),format.raw/*141.73*/("""";

          var projectId = '"""),_display_(/*143.29*/projectId),format.raw/*143.38*/("""';
          var userid = '"""),_display_(/*144.26*/userId),format.raw/*144.32*/("""';

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

  <script src=""""),_display_(/*164.17*/routes/*164.23*/.Assets.versioned("javascripts/views/attribute/user/AttributeUser.js")),format.raw/*164.93*/(""""></script>
  <script src=""""),_display_(/*165.17*/routes/*165.23*/.Assets.versioned("javascripts/views/attribute/user/AttributeUser_history.js")),format.raw/*165.101*/(""""></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,projectId:String,userId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,projectId,userId)

  def f:((User,String,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,projectId,userId) => apply(currentUser,projectId,userId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:43 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/attribute/user/AttributeUser.scala.html
                  HASH: 0c22aa368d5d53b1dae20f2eabaaf9518fbd6c2e
                  MATRIX: 670->1|693->18|1050->52|1181->3673|1198->3681|1587->4077|1602->4083|2008->103|2035->104|2203->246|2249->272|2330->326|2345->332|2402->368|2609->549|2623->554|2669->579|2704->676|2736->681|2776->694|2791->700|2861->749|2924->785|2939->791|3035->866|3116->920|3131->926|3268->1041|3372->1117|3401->1118|3444->1133|3534->1195|3563->1196|3604->1209|3646->1223|3675->1224|3718->1239|3812->1305|3841->1306|3873->1311|3950->1362|3964->1367|4028->1410|4061->1417|4075->1422|4130->1456|4163->1462|4464->1736|4515->1766|4544->1767|4637->1833|4688->1863|4717->1864|4810->1930|4850->1950|4894->1974|4921->1981|4955->1994|4994->2005|5565->2549|5618->2581|6104->3040|6152->3067|6785->4055|6835->4459|6885->4480|7191->4758|7222->4766|7623->5139|7651->5145|7942->5407|7980->5422|8266->5681|8281->5686|8347->5730|8380->5736|8395->5741|8462->5786|8495->5792|8510->5797|8576->5841|8610->5848|8625->5853|8662->5868|8693->5871|8732->5883|8746->5888|8792->5912|8824->5916|8882->5946|8898->5952|8961->5993|9015->6019|9031->6025|9096->6068|9156->6100|9187->6109|9243->6137|9271->6143|9344->6187|9374->6188|9416->6201|9576->6332|9606->6333|9650->6348|9739->6408|9769->6409|9854->6465|9884->6466|9928->6481|10017->6541|10047->6542|10089->6555|10119->6556|10178->6587|10194->6593|10330->6706|10387->6735|10403->6741|10495->6811|10551->6839|10567->6845|10668->6923
                  LINES: 24->1|25->2|30->3|34->85|34->85|42->94|42->94|51->3|52->4|57->9|57->9|58->10|58->10|58->10|63->15|63->15|63->15|66->18|67->19|67->19|67->19|67->19|68->20|68->20|68->20|69->21|69->21|69->21|72->24|72->24|73->25|75->27|75->27|76->28|76->28|76->28|77->29|79->31|79->31|80->32|84->36|84->36|84->36|86->38|86->38|86->38|88->40|93->45|93->45|93->45|94->46|94->46|94->46|95->47|95->47|95->47|95->47|95->47|96->48|107->59|107->59|116->68|116->68|133->93|134->102|135->103|138->106|138->106|144->112|144->112|148->116|148->116|162->130|162->130|162->130|163->131|163->131|163->131|164->132|164->132|164->132|166->134|166->134|166->134|167->135|169->137|169->137|169->137|171->139|172->140|172->140|172->140|173->141|173->141|173->141|175->143|175->143|176->144|176->144|178->146|178->146|179->147|183->151|183->151|184->152|186->154|186->154|187->155|187->155|188->156|190->158|190->158|191->159|191->159|194->162|194->162|194->162|196->164|196->164|196->164|197->165|197->165|197->165
                  -- GENERATED --
              */
          