
package views.html.telco.location

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
/*1.2*/import vn.m2m.utils.DateUtil
/*2.2*/import vn.m2m.common.models.User
/*3.2*/import vn.m2m.utils.UserHelper

object Location extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(currentUser:User, userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.35*/("""
"""),format.raw/*5.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*10.13*/Messages("location.title")),format.raw/*10.39*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*11.46*/routes/*11.52*/.Assets.versioned("images/logo.jpg")),format.raw/*11.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*16.6*/views/*16.11*/.html.iot.tags.Main_css()),format.raw/*16.36*/("""

    """),format.raw/*18.5*/("""<link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*18.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("assets/plugins/input-tags/css/tagsinput.css")),format.raw/*19.88*/("""" rel="stylesheet" />
    <link href='"""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*20.73*/("""' type='text/css'>
    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("stylesheets/fonts/fonts.googleapis/fontsgoogleapis.css")),format.raw/*21.99*/("""" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" >
    <link href=""""),_display_(/*23.18*/routes/*23.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*23.139*/("""" rel="stylesheet" >

    <link href=""""),_display_(/*25.18*/routes/*25.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*25.78*/("""" rel="stylesheet" />

    <link href="https://files-maps.viettel.vn/sdk/vtmap-gl-js/v1.13.1/vtmap-gl.css" rel="stylesheet" />
    <link href=""""),_display_(/*28.18*/routes/*28.24*/.Assets.versioned("stylesheets/views/telco/location/Location.css")),format.raw/*28.90*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*32.6*/views/*32.11*/.html.telco.Menu(currentUser, "", userId)),format.raw/*32.52*/("""

    """),_display_(/*34.6*/views/*34.11*/.html.telco.Header(currentUser)),format.raw/*34.42*/("""

    """),format.raw/*36.5*/("""<div class="page-wrapper">
      <div class="page-content row">
          <div class="col-9" style="height: calc(100vh - 100px);">
            <div id="map-canvas"></div>

          </div>
        <div class="col-3" id="map-search">
          <div>
            <input id="isdn" type="text" class="form-control input-form" placeholder=""""),_display_(/*44.88*/Messages("location.searchPlaceholder")),format.raw/*44.126*/("""" onkeypress="return isNumberKey(event)" maxlength="10000" required>
            <div class="d-flex flex-row align-items-center justify-content-center text-center">
              <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="resetSearch()">"""),_display_(/*46.134*/Messages("location.resetButton")),format.raw/*46.166*/("""</button>
              <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF;" onclick="findByIsdn()">"""),_display_(/*47.133*/Messages("location.searchButton")),format.raw/*47.166*/("""</button>
            </div>
          </div>
          <div class="card m-t-3">
            <div class="table-responsive" style="border-radius: 8px;">
              <table class="table table-striped" id="listSubscriberIspn" style="width: 100%;">
                <thead style="background-color: #FBCCD6;">
                  <tr>
                    <th>"""),_display_(/*55.26*/Messages("location.serialNumber")),format.raw/*55.59*/("""</th>
                    <th>"""),_display_(/*56.26*/Messages("location.subscriberNumber")),format.raw/*56.63*/("""</th>
                  </tr>
                </thead>
                <tbody></tbody>
              </table>
              <h5 id="notiNotDataSubs" style="text-align: center;"></h5>
            </div>
            <div class="material-datatables row row-cols-auto g-3" style="margin-bottom: 5px; margin-bottom: 10px; display: none;" id="divPagingTableIsdnMap">
              <div>
                  <div class="dataTables_paginate paging_full_numbers m-t-3" id="pagingTableIsdnMap" style="cursor: pointer; right: 5px; position: absolute;"></div>
              </div>

              <input name="page" id="page" value="1" style="display: none">
              <input name="pageSize" id="pageSize" value="10" style="display: none">
              <input name="isResetPage" id="isResetPage" value="false" style="display: none">
            </div>
          </div>
        </div>
      </div>

      """),_display_(/*76.8*/views/*76.13*/.html.telco.location.Location_listIsdn()),format.raw/*76.53*/("""
      """),_display_(/*77.8*/views/*77.13*/.html.telco.location.Location_history_list()),format.raw/*77.57*/("""
      """),_display_(/*78.8*/views/*78.13*/.html.telco.location.Location_history_map()),format.raw/*78.56*/("""

      """),_display_(/*80.8*/views/*80.13*/.html.telco.Loading()),format.raw/*80.34*/("""

    """),format.raw/*82.5*/("""</div>
      <!--  END OF PAPER WRAP -->

    """),_display_(/*85.6*/views/*85.11*/.html.telco.mainJs()),format.raw/*85.31*/("""

    """),format.raw/*87.5*/("""<script>
            var imgDefault = '"""),_display_(/*88.32*/routes/*88.38*/.Assets.versioned("images/market/default.png")),format.raw/*88.84*/("""';
            var userId = '"""),_display_(/*89.28*/userId),format.raw/*89.34*/("""';
            const signalBg = """"),_display_(/*90.32*/routes/*90.38*/.Assets.versioned("images/telco/signal.png")),format.raw/*90.82*/("""";
            const mapIcon = """"),_display_(/*91.31*/routes/*91.37*/.Assets.versioned("images/telco/mapIcon.png")),format.raw/*91.82*/("""";
            const infoIcon = """"),_display_(/*92.32*/routes/*92.38*/.Assets.versioned("images/telco/info.png")),format.raw/*92.80*/("""";
            const iconHistory = """"),_display_(/*93.35*/routes/*93.41*/.Assets.versioned("images/telco/marker.png")),format.raw/*93.85*/("""";

            $(document).ready(function () """),format.raw/*95.43*/("""{"""),format.raw/*95.44*/("""
              """),format.raw/*96.15*/("""$("#menu-location").addClass("mm-active");
              $("#menu").metisMenu();

              $('.datetimepicker').bootstrapMaterialDatePicker("""),format.raw/*99.64*/("""{"""),format.raw/*99.65*/("""
                """),format.raw/*100.17*/("""format: 'DD/MM/YYYY',
                time: false
              """),format.raw/*102.15*/("""}"""),format.raw/*102.16*/(""");
            """),format.raw/*103.13*/("""}"""),format.raw/*103.14*/(""")

    </script>
    <script src=""""),_display_(/*106.19*/routes/*106.25*/.Assets.versioned("javascripts/exportfile/table3export.js")),format.raw/*106.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*107.19*/routes/*107.25*/.Assets.versioned("javascripts/views/telco/validateForm.js")),format.raw/*107.85*/("""" type="text/javascript"></script>

    <script src="https://files-maps.viettel.vn/sdk/vtmap-gl-js/v1.13.1/vtmap-gl.js" type="text/javascript"></script>
    <script src=""""),_display_(/*110.19*/routes/*110.25*/.Assets.versioned("javascripts/views/telco/statusSubs.js")),format.raw/*110.83*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*112.19*/routes/*112.25*/.Assets.versioned("javascripts/views/telco/location/Location_viettelmap.js")),format.raw/*112.101*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*113.19*/routes/*113.25*/.Assets.versioned("javascripts/views/telco/location/Location.js")),format.raw/*113.90*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*114.19*/routes/*114.25*/.Assets.versioned("javascripts/views/telco/location/Location_isdn.js")),format.raw/*114.95*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*115.19*/routes/*115.25*/.Assets.versioned("javascripts/views/telco/location/Location_history_table.js")),format.raw/*115.104*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*116.19*/routes/*116.25*/.Assets.versioned("javascripts/views/telco/location/Location_history_map.js")),format.raw/*116.102*/("""" type="text/javascript"></script>

  </body>
</html>
"""))
      }
    }
  }

  def render(currentUser:User,userId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,userId)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,userId) => apply(currentUser,userId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:53 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/location/Location.scala.html
                  HASH: 402f5e3202bfd795f6a3c656ecea00be74554b90
                  MATRIX: 666->1|702->31|742->65|1085->97|1213->130|1240->131|1409->273|1456->299|1537->353|1552->359|1609->395|1816->576|1830->581|1876->606|1909->612|1949->625|1964->631|2039->685|2105->724|2120->730|2205->794|2271->833|2286->839|2356->888|2419->924|2434->930|2530->1005|2686->1134|2701->1140|2838->1255|2904->1294|2919->1300|2994->1354|3165->1498|3180->1504|3267->1570|3357->1634|3371->1639|3433->1680|3466->1687|3480->1692|3532->1723|3565->1729|3928->2065|3988->2103|4314->2401|4368->2433|4538->2575|4593->2608|4974->2962|5028->2995|5086->3026|5144->3063|6065->3958|6079->3963|6140->4003|6174->4011|6188->4016|6253->4060|6287->4068|6301->4073|6365->4116|6400->4125|6414->4130|6456->4151|6489->4157|6562->4204|6576->4209|6617->4229|6650->4235|6717->4275|6732->4281|6799->4327|6856->4357|6883->4363|6944->4397|6959->4403|7024->4447|7084->4480|7099->4486|7165->4531|7226->4565|7241->4571|7304->4613|7368->4650|7383->4656|7448->4700|7522->4746|7551->4747|7594->4762|7767->4907|7796->4908|7842->4925|7935->4989|7965->4990|8009->5005|8039->5006|8102->5041|8118->5047|8199->5106|8280->5159|8296->5165|8378->5225|8577->5396|8593->5402|8673->5460|8755->5514|8771->5520|8870->5596|8951->5649|8967->5655|9054->5720|9135->5773|9151->5779|9243->5849|9324->5902|9340->5908|9442->5987|9523->6040|9539->6046|9639->6123
                  LINES: 24->1|25->2|26->3|31->4|36->4|37->5|42->10|42->10|43->11|43->11|43->11|48->16|48->16|48->16|50->18|50->18|50->18|50->18|51->19|51->19|51->19|52->20|52->20|52->20|53->21|53->21|53->21|55->23|55->23|55->23|57->25|57->25|57->25|60->28|60->28|60->28|64->32|64->32|64->32|66->34|66->34|66->34|68->36|76->44|76->44|78->46|78->46|79->47|79->47|87->55|87->55|88->56|88->56|108->76|108->76|108->76|109->77|109->77|109->77|110->78|110->78|110->78|112->80|112->80|112->80|114->82|117->85|117->85|117->85|119->87|120->88|120->88|120->88|121->89|121->89|122->90|122->90|122->90|123->91|123->91|123->91|124->92|124->92|124->92|125->93|125->93|125->93|127->95|127->95|128->96|131->99|131->99|132->100|134->102|134->102|135->103|135->103|138->106|138->106|138->106|139->107|139->107|139->107|142->110|142->110|142->110|144->112|144->112|144->112|145->113|145->113|145->113|146->114|146->114|146->114|147->115|147->115|147->115|148->116|148->116|148->116
                  -- GENERATED --
              */
          