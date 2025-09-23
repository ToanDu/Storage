
package views.html

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
/*4.2*/import vn.m2m.utils.UserHelper

object TestApi extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.20*/("""
"""),format.raw/*6.1*/("""<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>"""),_display_(/*11.17*/Messages("TEST API")),format.raw/*11.37*/("""</title>
        <link rel="icon" type="image/png" href=""""),_display_(/*12.50*/routes/*12.56*/.Assets.versioned("images/iot.png")),format.raw/*12.91*/("""">

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        """),_display_(/*17.10*/views/*17.15*/.html.iot.tags.Main_css()),format.raw/*17.40*/("""

        """),format.raw/*19.9*/("""<link href=""""),_display_(/*19.22*/routes/*19.28*/.Assets.versioned("stylesheets/views/group/style.min.css")),format.raw/*19.86*/("""" rel="stylesheet" />
        <link href=""""),_display_(/*20.22*/routes/*20.28*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*20.82*/("""" rel="stylesheet" />

    </head>
    <body class="bg-theme bg-theme1">
        """),_display_(/*24.10*/views/*24.15*/.html.iot.tags.Menu(currentUser, "")),format.raw/*24.51*/("""

        """),_display_(/*26.10*/views/*26.15*/.html.iot.tags.Header(currentUser)),format.raw/*26.49*/("""

        """),format.raw/*28.9*/("""<div class="page-wrapper">
            <div class="page-content">
                <div class="row">
                    <label>URL</label>
                    <input id="url" type="text" value="https://api.iotcloud.com.vn:4438/api/groups"><hr>
                    <label>DATA</label>
                    <input id="data" type="text" value="limit=10&offset=0"><hr>
                    <label>RESULT</label>
                    <textarea id="resultData" type="text" rows="10" cols="50"></textarea><hr>
                </div>
                <div class="card-footer ml-auto mr-auto">
                    <button onclick="sendPostFormUrlencoded()" type="button" class="btn btn-success">"""),_display_(/*39.103*/Messages("PostFormUrlencoded")),format.raw/*39.133*/("""</button>
                    <button onclick="sendPostJson()" type="button" class="btn btn-info">"""),_display_(/*40.90*/Messages("PostJson")),format.raw/*40.110*/("""</button>
                    <button onclick="sendGetByToken()" type="button" class="btn btn-danger">"""),_display_(/*41.94*/Messages("GetByToken")),format.raw/*41.116*/("""</button>
                </div>
            </div>
        </div>
            <!--  END OF PAPER WRAP -->

        """),_display_(/*47.10*/views/*47.15*/.html.iot.tags.Main_js()),format.raw/*47.39*/("""

        """),format.raw/*49.9*/("""<script src=""""),_display_(/*49.23*/routes/*49.29*/.Assets.versioned("assets/js/bootstrap.bundle.min.js")),format.raw/*49.83*/(""""></script>
            <!--plugins-->
        <script src=""""),_display_(/*51.23*/routes/*51.29*/.Assets.versioned("assets/plugins/simplebar/js/simplebar.min.js")),format.raw/*51.94*/(""""></script>
        <script src=""""),_display_(/*52.23*/routes/*52.29*/.Assets.versioned("assets/plugins/metismenu/js/metisMenu.min.js")),format.raw/*52.94*/(""""></script>
        <script src=""""),_display_(/*53.23*/routes/*53.29*/.Assets.versioned("assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js")),format.raw/*53.106*/(""""></script>

        <script src=""""),_display_(/*55.23*/routes/*55.29*/.Assets.versioned("javascripts/TestApi.js")),format.raw/*55.72*/(""""></script>

    </body>
</html>
"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:39 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/TestApi.scala.html
                  HASH: 8d936215ac0e8c32904cc33183bdb8d09bed10aa
                  MATRIX: 651->1|674->18|710->48|750->82|1085->114|1198->132|1225->133|1408->289|1449->309|1534->367|1549->373|1605->408|1825->601|1839->606|1885->631|1922->641|1962->654|1977->660|2056->718|2126->761|2141->767|2216->821|2325->903|2339->908|2396->944|2434->955|2448->960|2503->994|2540->1004|3251->1687|3303->1717|3429->1816|3471->1836|3601->1939|3645->1961|3789->2078|3803->2083|3848->2107|3885->2117|3926->2131|3941->2137|4016->2191|4104->2252|4119->2258|4205->2323|4266->2357|4281->2363|4367->2428|4428->2462|4443->2468|4542->2545|4604->2580|4619->2586|4683->2629
                  LINES: 24->1|25->2|26->3|27->4|32->5|37->5|38->6|43->11|43->11|44->12|44->12|44->12|49->17|49->17|49->17|51->19|51->19|51->19|51->19|52->20|52->20|52->20|56->24|56->24|56->24|58->26|58->26|58->26|60->28|71->39|71->39|72->40|72->40|73->41|73->41|79->47|79->47|79->47|81->49|81->49|81->49|81->49|83->51|83->51|83->51|84->52|84->52|84->52|85->53|85->53|85->53|87->55|87->55|87->55
                  -- GENERATED --
              */
          