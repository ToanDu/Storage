
package views.html.telco.apiKey

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

object ApiKey extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

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
        <title>"""),_display_(/*10.17*/Messages("Quản lý API Key")),format.raw/*10.44*/("""</title>
        <link rel="icon" type="image/png" href=""""),_display_(/*11.50*/routes/*11.56*/.Assets.versioned("images/logo.jpg")),format.raw/*11.92*/("""">

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        """),_display_(/*16.10*/views/*16.15*/.html.iot.tags.Main_css()),format.raw/*16.40*/("""

        """),format.raw/*18.9*/("""<link href=""""),_display_(/*18.22*/routes/*18.28*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*18.82*/("""" rel="stylesheet" />
        <link href=""""),_display_(/*19.22*/routes/*19.28*/.Assets.versioned("assets/plugins/input-tags/css/tagsinput.css")),format.raw/*19.92*/("""" rel="stylesheet" />
        """),format.raw/*20.100*/("""
        """),format.raw/*21.9*/("""<link href='"""),_display_(/*21.22*/routes/*21.28*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*21.77*/("""' type='text/css'>
        <link href=""""),_display_(/*22.22*/routes/*22.28*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*22.143*/("""" rel="stylesheet" >

        <link href=""""),_display_(/*24.22*/routes/*24.28*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*24.82*/("""" rel="stylesheet" />

    </head>
    <body class="bg-theme">
        """),_display_(/*28.10*/views/*28.15*/.html.telco.Menu(currentUser, "", userId)),format.raw/*28.56*/("""

        """),_display_(/*30.10*/views/*30.15*/.html.telco.Header(currentUser)),format.raw/*30.46*/("""

        """),format.raw/*32.9*/("""<div class="page-wrapper">
            <div class="page-content">

"""),format.raw/*35.82*/("""
                """),format.raw/*36.17*/("""<div class="card">
                    <div class="card-body">
                        <h6>Lưu ý rằng API Key sẽ không hiển thị toàn bộ lại sau khi tạo. Giữ bí mật API Key nhằm đảm bảo an toàn thông tin.</h6>
                    </div>

                </div>

                <div class="card">

                    <div class="table-responsive" style="border-radius: 8px;">
                        <table class="table table-striped" id="listApiKeyTable" style="width: 100%;">
                            <thead style="background-color: #FBCCD6;">
                                <tr>
                                    <th>STT</th>
                                    <th>Tên</th>
"""),format.raw/*51.57*/("""
                                    """),format.raw/*52.37*/("""<th>Key</th>
                                    <th>Thời gian tạo</th>
"""),format.raw/*54.88*/("""
"""),format.raw/*55.84*/("""
                                    """),format.raw/*56.37*/("""<th>Thời gian hết hạn</th>
                                    <th>Trạng thái</th>
                                    <th style="text-align: center;  vertical-align: middle;">Thao tác</th>
                                    <th style="display:none;">KeyHash</th>
                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                        <h5 id="notiNotData" style="text-align: center;"></h5>
                    </div>

                </div>
                <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033; width: 180px;" data-bs-toggle="modal" onclick="openCreateApiKeyModal()">Tạo mới API Key</button>
            </div>



            """),_display_(/*74.14*/views/*74.19*/.html.telco.apiKey.ApiKey_create()),format.raw/*74.53*/("""



            """),_display_(/*78.14*/views/*78.19*/.html.telco.Loading()),format.raw/*78.40*/("""

        """),format.raw/*80.9*/("""</div>
            <!--  END OF PAPER WRAP -->

        """),_display_(/*83.10*/views/*83.15*/.html.telco.mainJs()),format.raw/*83.35*/("""


        """),format.raw/*86.9*/("""<script src=""""),_display_(/*86.23*/routes/*86.29*/.Assets.versioned("javascripts/views/telco/apiKey/apiKey.js")),format.raw/*86.90*/("""" type="text/javascript"></script>
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
                  DATE: Mon Sep 22 16:32:50 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/apiKey/ApiKey.scala.html
                  HASH: 161095eaa0bf607e54849adce66d31b0caf03ab4
                  MATRIX: 664->1|700->31|740->65|1081->97|1209->130|1236->131|1419->287|1467->314|1552->372|1567->378|1624->414|1844->607|1858->612|1904->637|1941->647|1981->660|1996->666|2071->720|2141->763|2156->769|2241->833|2300->954|2336->963|2376->976|2391->982|2461->1031|2528->1071|2543->1077|2680->1192|2750->1235|2765->1241|2840->1295|2939->1367|2953->1372|3015->1413|3053->1424|3067->1429|3119->1460|3156->1470|3251->1618|3296->1635|4008->2375|4073->2412|4173->2571|4202->2655|4267->2692|5111->3509|5125->3514|5180->3548|5224->3565|5238->3570|5280->3591|5317->3601|5401->3658|5415->3663|5456->3683|5494->3694|5535->3708|5550->3714|5632->3775
                  LINES: 24->1|25->2|26->3|31->4|36->4|37->5|42->10|42->10|43->11|43->11|43->11|48->16|48->16|48->16|50->18|50->18|50->18|50->18|51->19|51->19|51->19|52->20|53->21|53->21|53->21|53->21|54->22|54->22|54->22|56->24|56->24|56->24|60->28|60->28|60->28|62->30|62->30|62->30|64->32|67->35|68->36|83->51|84->52|86->54|87->55|88->56|106->74|106->74|106->74|110->78|110->78|110->78|112->80|115->83|115->83|115->83|118->86|118->86|118->86|118->86
                  -- GENERATED --
              */
          