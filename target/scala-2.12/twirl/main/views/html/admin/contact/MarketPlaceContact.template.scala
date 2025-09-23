
package views.html.admin.contact

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
/*4.2*/import vn.m2m.iot.models.ProductContact
/*5.2*/import vn.m2m.common.models.forms.SearchObjectData

object MarketPlaceContact extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,SearchObjectData,List[String],play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*12.13*/Messages("Manage Product List")),format.raw/*12.44*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*13.46*/routes/*13.52*/.Assets.versioned("images/logo.jpg")),format.raw/*13.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*18.6*/views/*18.11*/.html.iot.tags.Main_css()),format.raw/*18.36*/("""
    """),format.raw/*19.5*/("""<link href='"""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*19.73*/("""' type='text/css'>
    <link href=""""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*20.99*/("""" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" >
    <link href=""""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*22.139*/("""" rel="stylesheet" >

    <style>
            .btn-flat """),format.raw/*25.23*/("""{"""),format.raw/*25.24*/("""
              """),format.raw/*26.15*/("""color: white;
            """),format.raw/*27.13*/("""}"""),format.raw/*27.14*/("""
      """),format.raw/*28.7*/(""".fw-bold """),format.raw/*28.16*/("""{"""),format.raw/*28.17*/("""
        """),format.raw/*29.9*/("""margin-bottom: 0.5rem;
      """),format.raw/*30.7*/("""}"""),format.raw/*30.8*/("""
    """),format.raw/*31.5*/("""</style>
  </head>
  <body class="bg-theme">
    """),_display_(/*34.6*/views/*34.11*/.html.admin.navbar()),format.raw/*34.31*/("""

    """),_display_(/*36.6*/views/*36.11*/.html.admin.header(currentUser)),format.raw/*36.42*/("""

    """),format.raw/*38.5*/("""<div class="page-wrapper">
      <div class="page-content">

        """),_display_(/*41.10*/views/*41.15*/.html.filter.FilterHeaderTag(currentUser,searchResultData.getSearchFilterForm,searchField,"/productContactList")),format.raw/*41.127*/("""

        """),format.raw/*43.9*/("""<div class="card" style="box-shadow: 0 0.3rem 1.8rem rgb(0 0 0 / 12%);">
          <div class="card-header card-header-primary card-header-icon">
            <div class="toolbar" style="float: right">
              <button class="btn btn-success px-5 radius-30" onclick="">
                <i class="bx bx-download" aria-hidden="true"></i> """),_display_(/*47.68*/Messages("Export")),format.raw/*47.86*/("""
              """),format.raw/*48.15*/("""</button>
            </div>
          </div>

          <div class="card-body">
            <div class="table-responsive">

              <table id="dataTables" class="table align-middle mb-0 table-responsive table-striped" style='width: 100%;'>
                <thead>
                  <th>"""),_display_(/*57.24*/Messages("STT")),format.raw/*57.39*/("""</th>
                  <th>"""),_display_(/*58.24*/Messages("filter.name")),format.raw/*58.47*/("""</th>
                  <th>"""),_display_(/*59.24*/Messages("filter.phone")),format.raw/*59.48*/("""</th>
                  <th>"""),_display_(/*60.24*/Messages("filter.email")),format.raw/*60.48*/("""</th>
                  <th>"""),_display_(/*61.24*/Messages("filter.company")),format.raw/*61.50*/("""</th>
                  <th>"""),_display_(/*62.24*/Messages("filter.content")),format.raw/*62.50*/("""</th>
                  <th>"""),_display_(/*63.24*/Messages("filter.productName")),format.raw/*63.54*/("""</th>
                  <th>"""),_display_(/*64.24*/Messages("filter.status")),format.raw/*64.49*/("""</th>
                  <th>"""),_display_(/*65.24*/Messages("filter.createDate")),format.raw/*65.53*/("""</th>
                  <th>"""),_display_(/*66.24*/Messages("filter.action")),format.raw/*66.49*/("""</th>
                </thead>
                <tbody>
                """),_display_(/*69.18*/for((contact: ProductContact, index)<- searchResultData.getObjectList.zipWithIndex) yield /*69.101*/ {_display_(Seq[Any](format.raw/*69.103*/("""
                  """),format.raw/*70.19*/("""<tr>
                    <td>"""),_display_(/*71.26*/(index+1+(searchResultData.getSearchFilterForm.getPage -1)*searchResultData.getSearchFilterForm.getPageSize)),format.raw/*71.134*/("""</td>
                    <td>"""),_display_(/*72.26*/contact/*72.33*/.getName),format.raw/*72.41*/("""</td>
                    <td>"""),_display_(/*73.26*/contact/*73.33*/.getPhone),format.raw/*73.42*/("""</td>
                    <td>"""),_display_(/*74.26*/contact/*74.33*/.getEmail),format.raw/*74.42*/("""</td>
                    <td>"""),_display_(/*75.26*/contact/*75.33*/.getCompany),format.raw/*75.44*/("""</td>
                    <td>"""),_display_(/*76.26*/contact/*76.33*/.getContent),format.raw/*76.44*/("""</td>
                    <td>"""),_display_(/*77.26*/contact/*77.33*/.getProductName),format.raw/*77.48*/("""</td>
                    """),_display_(/*78.22*/if(contact.isStatus)/*78.42*/{_display_(Seq[Any](format.raw/*78.43*/("""
                      """),format.raw/*79.23*/("""<td id="td-status-"""),_display_(/*79.42*/contact/*79.49*/.getId),format.raw/*79.55*/("""" style="color: green;">"""),_display_(/*79.80*/Messages("Đã xử lý")),format.raw/*79.100*/("""</td>
                    """)))}/*80.23*/else/*80.28*/{_display_(Seq[Any](format.raw/*80.29*/("""
                      """),format.raw/*81.23*/("""<td id="td-status-"""),_display_(/*81.42*/contact/*81.49*/.getId),format.raw/*81.55*/("""">"""),_display_(/*81.58*/Messages("Chưa xử lý")),format.raw/*81.80*/("""</td>
                    """)))}),format.raw/*82.22*/("""
                    """),format.raw/*83.21*/("""<td>"""),_display_(/*83.26*/DateUtil/*83.34*/.getDateByFormat(contact.getCreateDate, DateUtil.DATE_TIME_CONVERT)),format.raw/*83.101*/("""</td>
                    <td>
                      <button class="btn btn-success" onclick="setEditContact('"""),_display_(/*85.81*/contact/*85.88*/.getId),format.raw/*85.94*/("""', '"""),_display_(/*85.99*/contact/*85.106*/.isStatus),format.raw/*85.115*/("""')" data-bs-toggle="modal" data-bs-target="#editConfirmModal">
                        <i class="bx bx-info-circle"></i>
                      </button>
                    </td>
                  </tr>
                """)))}),format.raw/*90.18*/("""
                """),format.raw/*91.17*/("""</tbody>
              </table>

              """),_display_(/*94.16*/views/*94.21*/.html.filter.FilterFooterTag(searchResultData.getSearchFilterForm)),format.raw/*94.87*/("""

            """),format.raw/*96.13*/("""</div>
          </div>
        </div>

      </div>
    </div>

    """),_display_(/*103.6*/views/*103.11*/.html.admin.contact.MarketPlaceContact_status()),format.raw/*103.58*/("""

    """),_display_(/*105.6*/views/*105.11*/.html.Loading()),format.raw/*105.26*/("""

  """),format.raw/*107.3*/("""</body>

  """),_display_(/*109.4*/views/*109.9*/.html.admin.mainJs()),format.raw/*109.29*/("""

  """),format.raw/*111.3*/("""<script>
          $(document).ready(function () """),format.raw/*112.41*/("""{"""),format.raw/*112.42*/("""
            """),format.raw/*113.13*/("""$("#menu-manageContact").addClass("mm-active");
            $("#menu").metisMenu();

            var table = $("#dataTables").DataTable("""),format.raw/*116.52*/("""{"""),format.raw/*116.53*/("""
              """),format.raw/*117.15*/("""responsive: true,
              lengthChange: false,
              "info": false,
              bSort: false,
              "order": false,
              "paging" : false,
              searching: false
            """),format.raw/*124.13*/("""}"""),format.raw/*124.14*/(""");

            $('#dateFromcreateDate').bootstrapMaterialDatePicker("""),format.raw/*126.66*/("""{"""),format.raw/*126.67*/("""
              """),format.raw/*127.15*/("""format: 'DD/MM/YYYY HH:mm',
              time: true
            """),format.raw/*129.13*/("""}"""),format.raw/*129.14*/(""");
            $('#dateTocreateDate').bootstrapMaterialDatePicker("""),format.raw/*130.64*/("""{"""),format.raw/*130.65*/("""
              """),format.raw/*131.15*/("""format: 'DD/MM/YYYY HH:mm',
              time: true
            """),format.raw/*133.13*/("""}"""),format.raw/*133.14*/(""");
          """),format.raw/*134.11*/("""}"""),format.raw/*134.12*/(""")

  </script>

  <script src=""""),_display_(/*138.17*/routes/*138.23*/.Assets.versioned("javascripts/SearchJs.js")),format.raw/*138.67*/("""" type="text/javascript"></script>
  """),_display_(/*139.4*/views/*139.9*/.html.filter.FilterScriptTag(searchResultData.getSearchFilterForm, searchField)),format.raw/*139.88*/("""

  """),format.raw/*141.136*/("""
  """),format.raw/*142.3*/("""<script src=""""),_display_(/*142.17*/routes/*142.23*/.Assets.versioned("javascripts/views/admin/contact/Contact.js")),format.raw/*142.86*/("""" type="text/javascript"></script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/admin/contact/MarketPlaceContact.scala.html
                  HASH: 64c66f114a45366df699929e841c28f2c098b0e7
                  MATRIX: 665->1|688->18|724->48|764->82|811->123|1207->175|1383->256|1410->257|1579->399|1631->430|1712->484|1727->490|1784->526|1991->707|2005->712|2051->737|2083->742|2123->755|2138->761|2208->810|2271->846|2286->852|2382->927|2538->1056|2553->1062|2690->1177|2774->1233|2803->1234|2846->1249|2900->1275|2929->1276|2963->1283|3000->1292|3029->1293|3065->1302|3121->1331|3149->1332|3181->1337|3257->1387|3271->1392|3312->1412|3345->1419|3359->1424|3411->1455|3444->1461|3541->1531|3555->1536|3689->1648|3726->1658|4094->1999|4133->2017|4176->2032|4497->2326|4533->2341|4589->2370|4633->2393|4689->2422|4734->2446|4790->2475|4835->2499|4891->2528|4938->2554|4994->2583|5041->2609|5097->2638|5148->2668|5204->2697|5250->2722|5306->2751|5356->2780|5412->2809|5458->2834|5557->2906|5657->2989|5698->2991|5745->3010|5802->3040|5932->3148|5990->3179|6006->3186|6035->3194|6093->3225|6109->3232|6139->3241|6197->3272|6213->3279|6243->3288|6301->3319|6317->3326|6349->3337|6407->3368|6423->3375|6455->3386|6513->3417|6529->3424|6565->3439|6619->3466|6648->3486|6687->3487|6738->3510|6784->3529|6800->3536|6827->3542|6879->3567|6921->3587|6967->3615|6980->3620|7019->3621|7070->3644|7116->3663|7132->3670|7159->3676|7189->3679|7232->3701|7290->3728|7339->3749|7371->3754|7388->3762|7477->3829|7615->3940|7631->3947|7658->3953|7690->3958|7707->3965|7738->3974|7989->4194|8034->4211|8109->4259|8123->4264|8210->4330|8252->4344|8349->4414|8364->4419|8433->4466|8467->4473|8482->4478|8519->4493|8551->4497|8590->4509|8604->4514|8646->4534|8678->4538|8756->4587|8786->4588|8828->4601|8993->4737|9023->4738|9067->4753|9311->4968|9341->4969|9439->5038|9469->5039|9513->5054|9607->5119|9637->5120|9732->5186|9762->5187|9806->5202|9900->5267|9930->5268|9972->5281|10002->5282|10062->5314|10078->5320|10144->5364|10209->5402|10223->5407|10324->5486|10358->5623|10389->5626|10431->5640|10447->5646|10532->5709
                  LINES: 24->1|25->2|26->3|27->4|28->5|33->6|38->6|39->7|44->12|44->12|45->13|45->13|45->13|50->18|50->18|50->18|51->19|51->19|51->19|51->19|52->20|52->20|52->20|54->22|54->22|54->22|57->25|57->25|58->26|59->27|59->27|60->28|60->28|60->28|61->29|62->30|62->30|63->31|66->34|66->34|66->34|68->36|68->36|68->36|70->38|73->41|73->41|73->41|75->43|79->47|79->47|80->48|89->57|89->57|90->58|90->58|91->59|91->59|92->60|92->60|93->61|93->61|94->62|94->62|95->63|95->63|96->64|96->64|97->65|97->65|98->66|98->66|101->69|101->69|101->69|102->70|103->71|103->71|104->72|104->72|104->72|105->73|105->73|105->73|106->74|106->74|106->74|107->75|107->75|107->75|108->76|108->76|108->76|109->77|109->77|109->77|110->78|110->78|110->78|111->79|111->79|111->79|111->79|111->79|111->79|112->80|112->80|112->80|113->81|113->81|113->81|113->81|113->81|113->81|114->82|115->83|115->83|115->83|115->83|117->85|117->85|117->85|117->85|117->85|117->85|122->90|123->91|126->94|126->94|126->94|128->96|135->103|135->103|135->103|137->105|137->105|137->105|139->107|141->109|141->109|141->109|143->111|144->112|144->112|145->113|148->116|148->116|149->117|156->124|156->124|158->126|158->126|159->127|161->129|161->129|162->130|162->130|163->131|165->133|165->133|166->134|166->134|170->138|170->138|170->138|171->139|171->139|171->139|173->141|174->142|174->142|174->142|174->142
                  -- GENERATED --
              */
          