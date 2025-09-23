
package views.html.admin.manageProduct

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
/*4.2*/import vn.m2m.iot.models.Product
/*5.2*/import vn.m2m.common.models.forms.SearchObjectData

object ManageProductList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,SearchObjectData,List[String],play.twirl.api.HtmlFormat.Appendable] {

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

    """),format.raw/*20.96*/("""
    """),format.raw/*21.5*/("""<link href='"""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*21.73*/("""' type='text/css'>
    <link href=""""),_display_(/*22.18*/routes/*22.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*22.99*/("""" rel="stylesheet">
    <link href=""""),_display_(/*23.18*/routes/*23.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*23.139*/("""" rel="stylesheet" >

    <style>
            .btn-flat """),format.raw/*26.23*/("""{"""),format.raw/*26.24*/("""
              """),format.raw/*27.15*/("""color: white;
            """),format.raw/*28.13*/("""}"""),format.raw/*28.14*/("""
      """),format.raw/*29.7*/(""".fw-bold """),format.raw/*29.16*/("""{"""),format.raw/*29.17*/("""
        """),format.raw/*30.9*/("""margin-bottom: 0.5rem;
      """),format.raw/*31.7*/("""}"""),format.raw/*31.8*/("""
    """),format.raw/*32.5*/("""</style>
  </head>
  <body class="bg-theme">
    """),_display_(/*35.6*/views/*35.11*/.html.admin.navbar()),format.raw/*35.31*/("""

    """),_display_(/*37.6*/views/*37.11*/.html.admin.header(currentUser)),format.raw/*37.42*/("""

    """),format.raw/*39.5*/("""<div class="page-wrapper">
      <div class="page-content">

        """),_display_(/*42.10*/views/*42.15*/.html.filter.FilterHeaderTag(currentUser,searchResultData.getSearchFilterForm,searchField,"/manageProductList")),format.raw/*42.126*/("""

        """),format.raw/*44.9*/("""<div class="card" style="box-shadow: 0 0.3rem 1.8rem rgb(0 0 0 / 12%);">
          <div class="card-header card-header-primary card-header-icon">
            <div class="toolbar" style="float: right">
              <button class="btn btn-success px-5 radius-30" onclick="">
                <i class="bx bx-download" aria-hidden="true"></i> """),_display_(/*48.68*/Messages("Export")),format.raw/*48.86*/("""
              """),format.raw/*49.15*/("""</button>
            </div>
          </div>

          <div class="card-body">
            <div class="table-responsive">

              <table id="dataTables" class="table align-middle mb-0 table-responsive table-striped" style='width: 100%;'>
                <thead>
                  <th>"""),_display_(/*58.24*/Messages("STT")),format.raw/*58.39*/("""</th>
                  <th>"""),_display_(/*59.24*/Messages("filter.code")),format.raw/*59.47*/("""</th>
                  <th>"""),_display_(/*60.24*/Messages("filter.name")),format.raw/*60.47*/("""</th>
                  <th>"""),_display_(/*61.24*/Messages("filter.username")),format.raw/*61.51*/("""</th>
                  <th>"""),_display_(/*62.24*/Messages("filter.groupName")),format.raw/*62.52*/("""</th>
                  <th>"""),_display_(/*63.24*/Messages("filter.statusApprove")),format.raw/*63.56*/("""</th>
                  <th>"""),_display_(/*64.24*/Messages("filter.createDate")),format.raw/*64.53*/("""</th>
                  <th>"""),_display_(/*65.24*/Messages("filter.action")),format.raw/*65.49*/("""</th>
                </thead>
                <tbody>
                """),_display_(/*68.18*/for((product: Product, index)<- searchResultData.getObjectList.zipWithIndex) yield /*68.94*/ {_display_(Seq[Any](format.raw/*68.96*/("""
                  """),format.raw/*69.19*/("""<tr>
                    <td>"""),_display_(/*70.26*/(index+1+(searchResultData.getSearchFilterForm.getPage -1)*searchResultData.getSearchFilterForm.getPageSize)),format.raw/*70.134*/("""</td>
                    <td>"""),_display_(/*71.26*/product/*71.33*/.getCode),format.raw/*71.41*/("""</td>
                    <td>"""),_display_(/*72.26*/product/*72.33*/.getName),format.raw/*72.41*/("""</td>
                    <td>"""),_display_(/*73.26*/product/*73.33*/.getUserName),format.raw/*73.45*/("""</td>
                    <td>"""),_display_(/*74.26*/product/*74.33*/.getGroupName),format.raw/*74.46*/("""</td>
                    """),_display_(/*75.22*/if(product.getStatusApprove == 1)/*75.55*/{_display_(Seq[Any](format.raw/*75.56*/("""
                      """),format.raw/*76.23*/("""<td style="color: green">"""),_display_(/*76.49*/Messages("Đã duyệt")),format.raw/*76.69*/("""</td>
                    """)))}/*77.23*/else if(product.getStatusApprove == 2)/*77.61*/{_display_(Seq[Any](format.raw/*77.62*/("""
                      """),format.raw/*78.23*/("""<td style="color: red">"""),_display_(/*78.47*/Messages("Từ chối")),format.raw/*78.66*/("""</td>
                    """)))}/*79.23*/else if(product.getStatusApprove == 3)/*79.61*/{_display_(Seq[Any](format.raw/*79.62*/("""
                      """),format.raw/*80.23*/("""<td style="color: #ffc107">"""),_display_(/*80.51*/Messages("Chờ duyệt")),format.raw/*80.72*/("""</td>
                    """)))}/*81.23*/else/*81.28*/{_display_(Seq[Any](format.raw/*81.29*/("""
                      """),format.raw/*82.23*/("""<td>"""),_display_(/*82.28*/Messages("Mới khởi tạo")),format.raw/*82.52*/("""</td>
                    """)))}),format.raw/*83.22*/("""
                    """),format.raw/*84.21*/("""<td>"""),_display_(/*84.26*/DateUtil/*84.34*/.getDateByFormat(product.getCreateDate, DateUtil.DATE_TIME_CONVERT)),format.raw/*84.101*/("""</td>
                    <td>
                      <button class="btn btn-info" onclick="showDetailProduct('"""),_display_(/*86.81*/product/*86.88*/.getId),format.raw/*86.94*/("""')" data-bs-toggle="modal" data-bs-target="#detailConfirmModal">
                        <i class="bx bx-info-circle"></i>
                      </button>
                    </td>
                  </tr>
                """)))}),format.raw/*91.18*/("""
                """),format.raw/*92.17*/("""</tbody>
              </table>

              """),_display_(/*95.16*/views/*95.21*/.html.filter.FilterFooterTag(searchResultData.getSearchFilterForm)),format.raw/*95.87*/("""

            """),format.raw/*97.13*/("""</div>
          </div>
        </div>

      </div>
    </div>

    """),_display_(/*104.6*/views/*104.11*/.html.admin.manageProduct.ManageProductList_detail()),format.raw/*104.63*/("""

    """),_display_(/*106.6*/views/*106.11*/.html.Loading()),format.raw/*106.26*/("""

  """),format.raw/*108.3*/("""</body>

  """),_display_(/*110.4*/views/*110.9*/.html.admin.mainJs()),format.raw/*110.29*/("""

  """),format.raw/*112.3*/("""<script>
          $(document).ready(function () """),format.raw/*113.41*/("""{"""),format.raw/*113.42*/("""
            """),format.raw/*114.13*/("""$("#menu-manageProduct").addClass("mm-active");
            $("#menu").metisMenu();

            var table = $("#dataTables").DataTable("""),format.raw/*117.52*/("""{"""),format.raw/*117.53*/("""
              """),format.raw/*118.15*/("""responsive: true,
              lengthChange: false,
              "info": false,
              bSort: false,
              "order": false,
              "paging" : false,
              searching: false
            """),format.raw/*125.13*/("""}"""),format.raw/*125.14*/(""");

            $('#dateFromcreateDate').bootstrapMaterialDatePicker("""),format.raw/*127.66*/("""{"""),format.raw/*127.67*/("""
              """),format.raw/*128.15*/("""format: 'DD/MM/YYYY HH:mm',
              time: true
            """),format.raw/*130.13*/("""}"""),format.raw/*130.14*/(""");
            $('#dateTocreateDate').bootstrapMaterialDatePicker("""),format.raw/*131.64*/("""{"""),format.raw/*131.65*/("""
              """),format.raw/*132.15*/("""format: 'DD/MM/YYYY HH:mm',
              time: true
            """),format.raw/*134.13*/("""}"""),format.raw/*134.14*/(""");
          """),format.raw/*135.11*/("""}"""),format.raw/*135.12*/(""")

  </script>

  <script src=""""),_display_(/*139.17*/routes/*139.23*/.Assets.versioned("javascripts/SearchJs.js")),format.raw/*139.67*/("""" type="text/javascript"></script>
  """),_display_(/*140.4*/views/*140.9*/.html.filter.FilterScriptTag(searchResultData.getSearchFilterForm, searchField)),format.raw/*140.88*/("""

  """),format.raw/*142.3*/("""<script src=""""),_display_(/*142.17*/routes/*142.23*/.Assets.versioned("javascripts/views/admin/manageProduct/ManageProduct.js")),format.raw/*142.98*/("""" type="text/javascript"></script>

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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/admin/manageProduct/ManageProductList.scala.html
                  HASH: 8e262a49e286f2cda318990a1806a1b6204a178a
                  MATRIX: 671->1|694->18|730->48|770->82|810->116|1205->168|1381->249|1408->250|1577->392|1629->423|1710->477|1725->483|1782->519|1989->700|2003->705|2049->730|2083->827|2115->832|2155->845|2170->851|2240->900|2303->936|2318->942|2414->1017|2478->1054|2493->1060|2630->1175|2714->1231|2743->1232|2786->1247|2840->1273|2869->1274|2903->1281|2940->1290|2969->1291|3005->1300|3061->1329|3089->1330|3121->1335|3197->1385|3211->1390|3252->1410|3285->1417|3299->1422|3351->1453|3384->1459|3481->1529|3495->1534|3628->1645|3665->1655|4033->1996|4072->2014|4115->2029|4436->2323|4472->2338|4528->2367|4572->2390|4628->2419|4672->2442|4728->2471|4776->2498|4832->2527|4881->2555|4937->2584|4990->2616|5046->2645|5096->2674|5152->2703|5198->2728|5297->2800|5389->2876|5429->2878|5476->2897|5533->2927|5663->3035|5721->3066|5737->3073|5766->3081|5824->3112|5840->3119|5869->3127|5927->3158|5943->3165|5976->3177|6034->3208|6050->3215|6084->3228|6138->3255|6180->3288|6219->3289|6270->3312|6323->3338|6364->3358|6410->3386|6457->3424|6496->3425|6547->3448|6598->3472|6638->3491|6684->3519|6731->3557|6770->3558|6821->3581|6876->3609|6918->3630|6964->3658|6977->3663|7016->3664|7067->3687|7099->3692|7144->3716|7202->3743|7251->3764|7283->3769|7300->3777|7389->3844|7527->3955|7543->3962|7570->3968|7823->4190|7868->4207|7943->4255|7957->4260|8044->4326|8086->4340|8183->4410|8198->4415|8272->4467|8306->4474|8321->4479|8358->4494|8390->4498|8429->4510|8443->4515|8485->4535|8517->4539|8595->4588|8625->4589|8667->4602|8832->4738|8862->4739|8906->4754|9150->4969|9180->4970|9278->5039|9308->5040|9352->5055|9446->5120|9476->5121|9571->5187|9601->5188|9645->5203|9739->5268|9769->5269|9811->5282|9841->5283|9901->5315|9917->5321|9983->5365|10048->5403|10062->5408|10163->5487|10195->5491|10237->5505|10253->5511|10350->5586
                  LINES: 24->1|25->2|26->3|27->4|28->5|33->6|38->6|39->7|44->12|44->12|45->13|45->13|45->13|50->18|50->18|50->18|52->20|53->21|53->21|53->21|53->21|54->22|54->22|54->22|55->23|55->23|55->23|58->26|58->26|59->27|60->28|60->28|61->29|61->29|61->29|62->30|63->31|63->31|64->32|67->35|67->35|67->35|69->37|69->37|69->37|71->39|74->42|74->42|74->42|76->44|80->48|80->48|81->49|90->58|90->58|91->59|91->59|92->60|92->60|93->61|93->61|94->62|94->62|95->63|95->63|96->64|96->64|97->65|97->65|100->68|100->68|100->68|101->69|102->70|102->70|103->71|103->71|103->71|104->72|104->72|104->72|105->73|105->73|105->73|106->74|106->74|106->74|107->75|107->75|107->75|108->76|108->76|108->76|109->77|109->77|109->77|110->78|110->78|110->78|111->79|111->79|111->79|112->80|112->80|112->80|113->81|113->81|113->81|114->82|114->82|114->82|115->83|116->84|116->84|116->84|116->84|118->86|118->86|118->86|123->91|124->92|127->95|127->95|127->95|129->97|136->104|136->104|136->104|138->106|138->106|138->106|140->108|142->110|142->110|142->110|144->112|145->113|145->113|146->114|149->117|149->117|150->118|157->125|157->125|159->127|159->127|160->128|162->130|162->130|163->131|163->131|164->132|166->134|166->134|167->135|167->135|171->139|171->139|171->139|172->140|172->140|172->140|174->142|174->142|174->142|174->142
                  -- GENERATED --
              */
          