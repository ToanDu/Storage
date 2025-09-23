
package views.html.telco.subs

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

object SubscriberDetail extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, subs:String, gpkd:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.46*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/subs),format.raw/*9.17*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*17.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("assets/plugins/input-tags/css/tagsinput.css")),format.raw/*18.88*/("""" rel="stylesheet" />
    <link href='"""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("stylesheets/fonts/roboto.css")),format.raw/*19.73*/("""' type='text/css'>
    """),format.raw/*20.96*/("""
    """),format.raw/*21.5*/("""<link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("assets/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.min.css")),format.raw/*21.139*/("""" rel="stylesheet" >

    <link href=""""),_display_(/*23.18*/routes/*23.24*/.Assets.versioned("stylesheets/views/telco/telco.css")),format.raw/*23.78*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*27.6*/views/*27.11*/.html.telco.Menu(currentUser, gpkd, "")),format.raw/*27.50*/("""

    """),_display_(/*29.6*/views/*29.11*/.html.telco.Header(currentUser)),format.raw/*29.42*/("""

    """),format.raw/*31.5*/("""<div class="page-wrapper">
      <div class="page-content">
        <div class="card">
          <div class="card-body">
            <span>"""),_display_(/*35.20*/Messages("Thông tin chi tiết thuê bao")),format.raw/*35.59*/("""</span>
            <div class="row">
              <div class="col-sm-5">
                <ul class="list-group list-group-flush">
                  <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                    <h6 class="mb-0">Số thuê bao</h6>
                    <span class="">"""),_display_(/*41.37*/subs),format.raw/*41.41*/("""</span>
                  </li>
                  <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                    <h6 class="mb-0">Github</h6>
                    <span class="">codervent</span>
                  </li>

                  <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                    <h6 class="mb-0">Instagram</h6>
                    <span class="">codervent</span>
                  </li>
                  <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                    <h6 class="mb-0">Facebook</h6>
                    <span class="">codervent</span>
                  </li>
                </ul>
              </div>
              <div class="col-sm-2"></div>
              <div class="col-sm-5">
                <ul class="list-group list-group-flush">
                  <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                    <h6 class="mb-0">Số thuê bao</h6>
                    <span class="">"""),_display_(/*63.37*/subs),format.raw/*63.41*/("""</span>
                  </li>
                  <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                    <h6 class="mb-0">Github</h6>
                    <span class="">codervent</span>
                  </li>

                  <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                    <h6 class="mb-0">Instagram</h6>
                    <span class="">codervent</span>
                  </li>
                  <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                    <h6 class="mb-0">Facebook</h6>
                    <span class="">codervent</span>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>

        <div class="card">
          <div class="table-responsive" style="border-radius: 8px;">
            <table class="table" id="" style="width: 100%;">
              <thead style="background-color: #ff000054;">
                <tr>
                  <th>STT</th>
                  <th>Số TB</th>
                  <th>Mã TB</th>
                  <th>Gói cước</th>
                  <th>Mã KM</th>
                  <th>Mã HĐ</th>
                  <th>Mã KH</th>
                  <th>Serial Sim</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td class="wrap-test">David Buckley</td>
                  <td class="wrap-test">$485.20</td>
                  <td class="wrap-test">June 10, 2020</td>
                  <td class="wrap-test">David Buckley</td>
                  <td class="wrap-test">$485.20</td>
                  <td class="wrap-test">June 10, 2020</td>
                  <td class="wrap-test">David Buckley</td>
                  <td>
                    <a class="badge rounded-pill bg-success p-2 text-uppercase cursor-pointer">View</a>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>

      </div>

      """),_display_(/*121.8*/views/*121.13*/.html.Loading()),format.raw/*121.28*/("""

    """),format.raw/*123.5*/("""</div>
      <!--  END OF PAPER WRAP -->

    """),_display_(/*126.6*/views/*126.11*/.html.telco.mainJs()),format.raw/*126.31*/("""

    """),format.raw/*128.5*/("""<script>
            var imgDefault = '"""),_display_(/*129.32*/routes/*129.38*/.Assets.versioned("images/market/default.png")),format.raw/*129.84*/("""';
            $(document).ready(function () """),format.raw/*130.43*/("""{"""),format.raw/*130.44*/("""
              """),format.raw/*131.15*/("""$("#menu-subscriberManage").addClass("mm-active");
              $("#menu").metisMenu();
            """),format.raw/*133.13*/("""}"""),format.raw/*133.14*/(""")
    </script>

    """),format.raw/*136.126*/("""
  """),format.raw/*137.3*/("""</body>
</html>
"""))
      }
    }
  }

  def render(currentUser:User,subs:String,gpkd:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,subs,gpkd)

  def f:((User,String,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,subs,gpkd) => apply(currentUser,subs,gpkd)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:55 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/subs/SubscriberDetail.scala.html
                  HASH: 180dca13584f8f71f9a3b09d8e62381bfd795f42
                  MATRIX: 662->1|698->31|1058->65|1197->109|1224->110|1392->252|1416->256|1497->310|1512->316|1569->352|1776->533|1790->538|1836->563|1869->569|1909->582|1924->588|1999->642|2065->681|2080->687|2165->751|2231->790|2246->796|2316->845|2367->959|2399->964|2439->977|2454->983|2591->1098|2657->1137|2672->1143|2747->1197|2837->1261|2851->1266|2911->1305|2944->1312|2958->1317|3010->1348|3043->1354|3210->1494|3270->1533|3626->1862|3651->1866|4789->2977|4814->2981|6994->5134|7009->5139|7046->5154|7080->5160|7154->5207|7169->5212|7211->5232|7245->5238|7313->5278|7329->5284|7397->5330|7471->5375|7501->5376|7545->5391|7675->5492|7705->5493|7756->5635|7787->5638
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|51->19|51->19|52->20|53->21|53->21|53->21|53->21|55->23|55->23|55->23|59->27|59->27|59->27|61->29|61->29|61->29|63->31|67->35|67->35|73->41|73->41|95->63|95->63|153->121|153->121|153->121|155->123|158->126|158->126|158->126|160->128|161->129|161->129|161->129|162->130|162->130|163->131|165->133|165->133|168->136|169->137
                  -- GENERATED --
              */
          