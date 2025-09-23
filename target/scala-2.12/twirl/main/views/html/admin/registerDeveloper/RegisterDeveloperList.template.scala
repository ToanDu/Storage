
package views.html.admin.registerDeveloper

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
/*4.2*/import vn.m2m.iot.models.RegisterDeveloper
/*5.2*/import vn.m2m.common.models.forms.SearchObjectData

object RegisterDeveloperList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,SearchObjectData,List[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(currentUser:User, searchResultData: SearchObjectData, searchField: List[String]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*6.83*/("""
"""),format.raw/*7.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*12.13*/Messages("Register Developer List")),format.raw/*12.48*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*13.46*/routes/*13.52*/.Assets.versioned("images/logo.jpg")),format.raw/*13.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*18.6*/views/*18.11*/.html.iot.tags.Main_css()),format.raw/*18.36*/("""

  """),format.raw/*20.3*/("""</head>
  <body class="bg-theme">
    """),_display_(/*22.6*/views/*22.11*/.html.admin.navbar()),format.raw/*22.31*/("""

    """),_display_(/*24.6*/views/*24.11*/.html.admin.header(currentUser)),format.raw/*24.42*/("""

    """),format.raw/*26.5*/("""<div class="page-wrapper">
      <div class="page-content">

        """),_display_(/*29.10*/views/*29.15*/.html.filter.FilterHeaderTag(currentUser,searchResultData.getSearchFilterForm,searchField,"/registerDeveloperList")),format.raw/*29.130*/("""

        """),format.raw/*31.9*/("""<div class="card" style="box-shadow: 0 0.3rem 1.8rem rgb(0 0 0 / 12%);">
          <div class="card-header card-header-primary card-header-icon">
            <div class="toolbar" style="float: right">
              <button class="btn btn-success px-5 radius-30" onclick="exportToExcelRegister()">
                <i class="bx bx-download" aria-hidden="true"></i> """),_display_(/*35.68*/Messages("Export")),format.raw/*35.86*/("""
              """),format.raw/*36.15*/("""</button>
            </div>
          </div>

          <div class="card-body">
            <div class="table-responsive">

              <table id="dataTables" class="table align-middle mb-0 table-responsive table-striped" style='width: 100%;'>
                <thead>
                  <th>"""),_display_(/*45.24*/Messages("STT")),format.raw/*45.39*/("""</th>
                  <th>"""),_display_(/*46.24*/Messages("filter.name")),format.raw/*46.47*/("""</th>
                  <th>"""),_display_(/*47.24*/Messages("Công ty ")),format.raw/*47.44*/("""</th>
                  <th>"""),_display_(/*48.24*/Messages("Email ")),format.raw/*48.42*/("""</th>
                  <th>"""),_display_(/*49.24*/Messages("SĐT")),format.raw/*49.39*/("""</th>
                  <th>"""),_display_(/*50.24*/Messages("Vai trò ")),format.raw/*50.44*/("""</th>
                  <th>"""),_display_(/*51.24*/Messages("Lĩnh vực ")),format.raw/*51.45*/("""</th>
                  <th>"""),_display_(/*52.24*/Messages("Số thiết bị ")),format.raw/*52.48*/("""</th>
                  <th>"""),_display_(/*53.24*/Messages("Số người dùng ")),format.raw/*53.50*/("""</th>
                  <th>"""),_display_(/*54.24*/Messages("IP ")),format.raw/*54.39*/("""</th>
                  <th>"""),_display_(/*55.24*/Messages("Date ")),format.raw/*55.41*/("""</th>
                  <th>"""),_display_(/*56.24*/Messages("Action")),format.raw/*56.42*/("""</th>
                </thead>
                <tbody>
                """),_display_(/*59.18*/for((register: RegisterDeveloper, index)<- searchResultData.getObjectList.zipWithIndex) yield /*59.105*/ {_display_(Seq[Any](format.raw/*59.107*/("""
                  """),format.raw/*60.19*/("""<tr>
                    <td>"""),_display_(/*61.26*/(index+1+(searchResultData.getSearchFilterForm.getPage -1)*searchResultData.getSearchFilterForm.getPageSize)),format.raw/*61.134*/("""</td>
                    <td>"""),_display_(/*62.26*/register/*62.34*/.getName),format.raw/*62.42*/("""</td>
                    <td>"""),_display_(/*63.26*/register/*63.34*/.getNameCompany),format.raw/*63.49*/("""</td>
                    <td>"""),_display_(/*64.26*/register/*64.34*/.getEmail),format.raw/*64.43*/("""</td>
                    <td>"""),_display_(/*65.26*/register/*65.34*/.getPhone),format.raw/*65.43*/("""</td>
                    <td>"""),_display_(/*66.26*/register/*66.34*/.getRole),format.raw/*66.42*/("""</td>
                    <td>"""),_display_(/*67.26*/register/*67.34*/.getField),format.raw/*67.43*/("""</td>
                    <td>"""),_display_(/*68.26*/register/*68.34*/.getCountDevice),format.raw/*68.49*/("""</td>
                    <td>"""),_display_(/*69.26*/register/*69.34*/.getCountUser),format.raw/*69.47*/("""</td>
                    <td>"""),_display_(/*70.26*/register/*70.34*/.getIp),format.raw/*70.40*/("""</td>
                    <td>"""),_display_(/*71.26*/DateUtil/*71.34*/.getDateByFormat(register.getLogDate, DateUtil.FORMAT_DATE_YYYY_MM_DD_HH_mm)),format.raw/*71.110*/("""</td>
                    <td align='center'>
                      <button class="btn btn-light" onclick="setDelRegister('"""),_display_(/*73.79*/register/*73.87*/.getId),format.raw/*73.93*/("""')" data-bs-toggle="modal" data-bs-target="#delConfirmModal">
                        <i class="bx bx-trash"></i>
                      </button>
                    </td>
                  </tr>
                """)))}),format.raw/*78.18*/("""
                """),format.raw/*79.17*/("""</tbody>
              </table>

              """),_display_(/*82.16*/views/*82.21*/.html.filter.FilterFooterTag(searchResultData.getSearchFilterForm)),format.raw/*82.87*/("""

            """),format.raw/*84.13*/("""</div>
          </div>
        </div>

      </div>
    </div>

    """),_display_(/*91.6*/views/*91.11*/.html.admin.registerDeveloper.RegisterDeveloperList_del()),format.raw/*91.68*/("""

    """),_display_(/*93.6*/views/*93.11*/.html.Loading()),format.raw/*93.26*/("""

  """),format.raw/*95.3*/("""</body>

  """),_display_(/*97.4*/views/*97.9*/.html.admin.mainJs()),format.raw/*97.29*/("""

  """),format.raw/*99.3*/("""<script>
          $(document).ready(function () """),format.raw/*100.41*/("""{"""),format.raw/*100.42*/("""
            """),format.raw/*101.13*/("""$("#menu-registerDeveloper").addClass("mm-active");
            $("#menu").metisMenu();

            var table = $("#dataTables").DataTable("""),format.raw/*104.52*/("""{"""),format.raw/*104.53*/("""
              """),format.raw/*105.15*/("""responsive: true,
              lengthChange: false,
              "info": false,
              bSort: false,
              "order": false,
              "paging" : false,
              searching: false,
            """),format.raw/*112.13*/("""}"""),format.raw/*112.14*/(""");
          """),format.raw/*113.11*/("""}"""),format.raw/*113.12*/(""")

  </script>

  <script src=""""),_display_(/*117.17*/routes/*117.23*/.Assets.versioned("javascripts/SearchJs.js")),format.raw/*117.67*/("""" type="text/javascript"></script>
  """),_display_(/*118.4*/views/*118.9*/.html.filter.FilterScriptTag(searchResultData.getSearchFilterForm, searchField)),format.raw/*118.88*/("""

  """),format.raw/*120.3*/("""<script src=""""),_display_(/*120.17*/routes/*120.23*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*120.82*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*122.17*/routes/*122.23*/.Assets.versioned("javascripts/views/admin/registerDeveloper/registerDeveloper.js")),format.raw/*122.106*/("""" type="text/javascript"></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,searchResultData:SearchObjectData,searchField:List[String]): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,searchResultData,searchField)

  def f:((User,SearchObjectData,List[String]) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,searchResultData,searchField) => apply(currentUser,searchResultData,searchField)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:40 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/admin/registerDeveloper/RegisterDeveloperList.scala.html
                  HASH: 5e06fec62c680947764525507b8f255f58c9be80
                  MATRIX: 675->1|698->18|734->48|774->82|824->126|1223->178|1399->259|1426->260|1595->402|1651->437|1732->491|1747->497|1804->533|2011->714|2025->719|2071->744|2102->748|2167->787|2181->792|2222->812|2255->819|2269->824|2321->855|2354->861|2451->931|2465->936|2602->1051|2639->1061|3030->1425|3069->1443|3112->1458|3433->1752|3469->1767|3525->1796|3569->1819|3625->1848|3666->1868|3722->1897|3761->1915|3817->1944|3853->1959|3909->1988|3950->2008|4006->2037|4048->2058|4104->2087|4149->2111|4205->2140|4252->2166|4308->2195|4344->2210|4400->2239|4438->2256|4494->2285|4533->2303|4632->2375|4736->2462|4777->2464|4824->2483|4881->2513|5011->2621|5069->2652|5086->2660|5115->2668|5173->2699|5190->2707|5226->2722|5284->2753|5301->2761|5331->2770|5389->2801|5406->2809|5436->2818|5494->2849|5511->2857|5540->2865|5598->2896|5615->2904|5645->2913|5703->2944|5720->2952|5756->2967|5814->2998|5831->3006|5865->3019|5923->3050|5940->3058|5967->3064|6025->3095|6042->3103|6140->3179|6291->3303|6308->3311|6335->3317|6579->3530|6624->3547|6699->3595|6713->3600|6800->3666|6842->3680|6938->3750|6952->3755|7030->3812|7063->3819|7077->3824|7113->3839|7144->3843|7182->3855|7195->3860|7236->3880|7267->3884|7345->3933|7375->3934|7417->3947|7586->4087|7616->4088|7660->4103|7905->4319|7935->4320|7977->4333|8007->4334|8067->4366|8083->4372|8149->4416|8214->4454|8228->4459|8329->4538|8361->4542|8403->4556|8419->4562|8500->4621|8580->4673|8596->4679|8702->4762
                  LINES: 24->1|25->2|26->3|27->4|28->5|33->6|38->6|39->7|44->12|44->12|45->13|45->13|45->13|50->18|50->18|50->18|52->20|54->22|54->22|54->22|56->24|56->24|56->24|58->26|61->29|61->29|61->29|63->31|67->35|67->35|68->36|77->45|77->45|78->46|78->46|79->47|79->47|80->48|80->48|81->49|81->49|82->50|82->50|83->51|83->51|84->52|84->52|85->53|85->53|86->54|86->54|87->55|87->55|88->56|88->56|91->59|91->59|91->59|92->60|93->61|93->61|94->62|94->62|94->62|95->63|95->63|95->63|96->64|96->64|96->64|97->65|97->65|97->65|98->66|98->66|98->66|99->67|99->67|99->67|100->68|100->68|100->68|101->69|101->69|101->69|102->70|102->70|102->70|103->71|103->71|103->71|105->73|105->73|105->73|110->78|111->79|114->82|114->82|114->82|116->84|123->91|123->91|123->91|125->93|125->93|125->93|127->95|129->97|129->97|129->97|131->99|132->100|132->100|133->101|136->104|136->104|137->105|144->112|144->112|145->113|145->113|149->117|149->117|149->117|150->118|150->118|150->118|152->120|152->120|152->120|152->120|154->122|154->122|154->122
                  -- GENERATED --
              */
          