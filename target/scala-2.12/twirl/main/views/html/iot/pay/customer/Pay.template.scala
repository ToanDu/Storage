
package views.html.iot.pay.customer

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

object Pay extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, projectId:String, userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.53*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("Pay")),format.raw/*9.28*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*17.78*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*21.6*/views/*21.11*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*21.54*/("""

    """),_display_(/*23.6*/views/*23.11*/.html.iot.tags.Header(currentUser)),format.raw/*23.45*/("""

    """),format.raw/*25.5*/("""<div class="page-wrapper">
      <div class="page-content">

        <div class="row">
          <div class="col-md-12">
            <div class="card mb-3">
              <div class="card-body">
                <h5 class="card-title">Thông tin gói cước</h5><hr>
                <p class="card-text" id="namePackUserCurrent">Tên: </p>
                """),format.raw/*34.77*/("""
                """),format.raw/*35.17*/("""<p class="card-text" id="datePackUserCurrent">Ngày áp dụng gói cước:  </p>
                <p class="card-text" id="cyclePackUserCurrent">Chu kỳ:   </p>
              </div>
            </div>

            <div class="card mb-3">
              <div class="card-body">
                <h5 class="card-title">Dữ liệu gói cước</h5><hr>
                <div class="card-group shadow">
                  <div class="card border-end shadow-none">
                    <div class="card-body">
                      <h5 class="card-title align-items-center">Số lượng kết nối (hiện tại/tối đa)</h5>
                    </div>
                    <div class="card-footer">
                      <h4 class="card-title" style="text-align: center" id="countMaxConnectUser">0</h4>
                    </div>
                  </div>
                  <div class="card border-end shadow-none">
                    <div class="card-body">
                      <h5 class="card-title align-items-center">Số lượng bản tin (hiện tại/tối đa)</h5>
                    </div>
                    <div class="card-footer">
                      <h4 class="card-title" style="text-align: center" id="countMaxMessUser">0</h4>
                    </div>
                  </div>
                  <div class="card shadow-none">
                    <div class="card-body">
                      <h5 class="card-title align-items-center">Số lượng bản tin phụ trội</h5>
                    </div>
                    <div class="card-footer">
                      <h4 class="card-title" style="text-align: center" id="countMessChargingUser">0</h4>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="card mb-3">
              <div class="card-body">
                <h5 class="card-title">Cước tạm tính</h5><hr>
                <div class="card-group shadow">
                  <div class="card border-end shadow-none">
                    <div class="card-body">
                      <h5 class="card-title align-items-center">Cước theo gói</h5>
                    </div>
                    <div class="card-footer">
                      <h4 class="card-title" style="text-align: center" id="feeWithPack">0</h4>
                    </div>
                  </div>
                  <div class="card border-end shadow-none">
                    <div class="card-body">
                      <h5 class="card-title align-items-center">Cước phụ trội</h5>
                    </div>
                    <div class="card-footer">
                      <h4 class="card-title" style="text-align: center" id="feeCharging">0</h4>
                    </div>
                  </div>
                  <div class="card shadow-none">
                    <div class="card-body">
                      <h5 class="card-title align-items-center">Tổng cước tạm tính</h5>
                    </div>
                    <div class="card-footer">
                      <h4 class="card-title" style="text-align: center" id="totalFee">0</h4>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

        </div>
      </div>
    </div>

    """),_display_(/*109.6*/views/*109.11*/.html.Loading()),format.raw/*109.26*/("""
  """),format.raw/*110.3*/("""</body>

  """),_display_(/*112.4*/views/*112.9*/.html.iot.tags.Main_js()),format.raw/*112.33*/("""

  """),format.raw/*114.3*/("""<script>
    var userid = '"""),_display_(/*115.20*/userId),format.raw/*115.26*/("""';
    var projectId = '"""),_display_(/*116.23*/projectId),format.raw/*116.32*/("""';

          $(document).ready(function () """),format.raw/*118.41*/("""{"""),format.raw/*118.42*/("""
            """),format.raw/*119.13*/("""$("#menu-pay").addClass("mm-active");

            $("#menu").metisMenu();
            for (var e = window.location, o = $(".metismenu li a").filter(function() """),format.raw/*122.86*/("""{"""),format.raw/*122.87*/("""
              """),format.raw/*123.15*/("""return this.href == e
            """),format.raw/*124.13*/("""}"""),format.raw/*124.14*/(""").addClass("").parent().addClass("mm-active"); o.is("li");) o = o.parent("").addClass("mm-show").parent("").addClass("mm-active");
          """),format.raw/*125.11*/("""}"""),format.raw/*125.12*/(""")

          function focusSearchTree() """),format.raw/*127.38*/("""{"""),format.raw/*127.39*/("""
            """),format.raw/*128.13*/("""$("#search-selectOrg").focus();
          """),format.raw/*129.11*/("""}"""),format.raw/*129.12*/("""
  """),format.raw/*130.3*/("""</script>

  <script src=""""),_display_(/*132.17*/routes/*132.23*/.Assets.versioned("javascripts/views/pay/customer/pay.js")),format.raw/*132.81*/(""""></script>

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
                  DATE: Mon Sep 22 16:32:45 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/pay/customer/Pay.scala.html
                  HASH: 92c52a82afd1dc900bdbcdb268b049ed72ede947
                  MATRIX: 668->1|691->18|1038->52|1184->103|1211->104|1379->246|1414->261|1495->315|1510->321|1567->357|1774->538|1788->543|1834->568|1867->574|1907->587|1922->593|1997->647|2087->711|2101->716|2165->759|2198->766|2212->771|2267->805|2300->811|2678->1221|2723->1238|6010->4498|6025->4503|6062->4518|6093->4521|6132->4533|6146->4538|6192->4562|6224->4566|6280->4594|6308->4600|6361->4625|6392->4634|6465->4678|6495->4679|6537->4692|6726->4852|6756->4853|6800->4868|6863->4902|6893->4903|7063->5044|7093->5045|7162->5085|7192->5086|7234->5099|7305->5141|7335->5142|7366->5145|7421->5172|7437->5178|7517->5236
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|53->21|53->21|53->21|55->23|55->23|55->23|57->25|66->34|67->35|141->109|141->109|141->109|142->110|144->112|144->112|144->112|146->114|147->115|147->115|148->116|148->116|150->118|150->118|151->119|154->122|154->122|155->123|156->124|156->124|157->125|157->125|159->127|159->127|160->128|161->129|161->129|162->130|164->132|164->132|164->132
                  -- GENERATED --
              */
          