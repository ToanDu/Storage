
package views.html.amarket.product

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

object ProductList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, userId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.35*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("Manage Product")),format.raw/*9.39*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/market/product/Product.css")),format.raw/*17.89*/("""" rel="stylesheet"/>

  </head>
  <body class="bg-theme">
    """),_display_(/*21.6*/views/*21.11*/.html.amarket.navbar(currentUser)),format.raw/*21.44*/("""

    """),_display_(/*23.6*/views/*23.11*/.html.amarket.header(currentUser)),format.raw/*23.44*/("""

    """),format.raw/*25.5*/("""<div class="page-wrapper">
      <div class="page-content">

        <div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-body">
                <div class="row align-items-center">
                  <div class="col-lg-2 col-xl-2">
                    <a class="btn btn-danger mb-3 mb-lg-0" data-bs-toggle="modal" data-bs-target="#addProductModal">
                      <i class='bx bxs-plus-square'></i> """),_display_(/*35.59*/Messages("New Product")),format.raw/*35.82*/("""
                    """),format.raw/*36.21*/("""</a>
                  </div>
                  <div class="col-lg-10 col-xl-10">
                    <form class="float-lg-end">
                      <div class="row row-cols-lg-auto g-2">
                        <div class="col-12">
                          <div class="position-relative">
                            <input type="text" class="form-control ps-5" id="searchProduct" placeholder="Tìm kiếm tên sản phẩm...">
                            <span class="position-absolute top-50 product-show translate-middle-y"><i class="bx bx-search"></i></span>
                          </div>
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="row row-cols-1 row-cols-sm-2 row-cols-lg-3 row-cols-xl-4 row-cols-xl-5 product-grid" id="girdProductList">

        </div>

        """),_display_(/*60.10*/views/*60.15*/.html.amarket.product.ProductList_add()),format.raw/*60.54*/("""
        """),_display_(/*61.10*/views/*61.15*/.html.amarket.product.ProductList_del()),format.raw/*61.54*/("""
        """),_display_(/*62.10*/views/*62.15*/.html.amarket.product.ProductList_edit()),format.raw/*62.55*/("""

      """),format.raw/*64.7*/("""</div>
    </div>
      <!--  END OF PAPER WRAP -->
    """),_display_(/*67.6*/views/*67.11*/.html.Loading()),format.raw/*67.26*/("""

  """),format.raw/*69.3*/("""</body>

  """),_display_(/*71.4*/views/*71.9*/.html.admin.mainJs()),format.raw/*71.29*/("""

  """),format.raw/*73.3*/("""<script>
          var userId = '"""),_display_(/*74.26*/userId),format.raw/*74.32*/("""';
          var imgDefault = '"""),_display_(/*75.30*/routes/*75.36*/.Assets.versioned("images/market/default.png")),format.raw/*75.82*/("""';
          $(document).ready(function () """),format.raw/*76.41*/("""{"""),format.raw/*76.42*/("""
            """),format.raw/*77.13*/("""$("#menu-product").addClass("mm-active");
            $("#menu").metisMenu();
          """),format.raw/*79.11*/("""}"""),format.raw/*79.12*/(""");
  </script>

  <script src=""""),_display_(/*82.17*/routes/*82.23*/.Assets.versioned("javascripts/views/amarket/product/ProductList.js")),format.raw/*82.92*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*83.17*/routes/*83.23*/.Assets.versioned("javascripts/views/amarket/product/ProductList_add.js")),format.raw/*83.96*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*84.17*/routes/*84.23*/.Assets.versioned("javascripts/views/amarket/product/ProductList_edit.js")),format.raw/*84.97*/("""" type="text/javascript"></script>

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
                  DATE: Mon Sep 22 16:32:41 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/amarket/product/ProductList.scala.html
                  HASH: 314ad2d4fe43d997d02f71fa68baabd17f6a6796
                  MATRIX: 667->1|690->18|1038->52|1166->85|1193->86|1361->228|1407->254|1488->308|1503->314|1560->350|1767->531|1781->536|1827->561|1860->567|1900->580|1915->586|2001->651|2090->714|2104->719|2158->752|2191->759|2205->764|2259->797|2292->803|2784->1268|2828->1291|2877->1312|3860->2268|3874->2273|3934->2312|3971->2322|3985->2327|4045->2366|4082->2376|4096->2381|4157->2421|4192->2429|4275->2486|4289->2491|4325->2506|4356->2510|4394->2522|4407->2527|4448->2547|4479->2551|4540->2585|4567->2591|4626->2623|4641->2629|4708->2675|4779->2718|4808->2719|4849->2732|4965->2820|4994->2821|5053->2853|5068->2859|5158->2928|5236->2979|5251->2985|5345->3058|5423->3109|5438->3115|5533->3189
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|53->21|53->21|53->21|55->23|55->23|55->23|57->25|67->35|67->35|68->36|92->60|92->60|92->60|93->61|93->61|93->61|94->62|94->62|94->62|96->64|99->67|99->67|99->67|101->69|103->71|103->71|103->71|105->73|106->74|106->74|107->75|107->75|107->75|108->76|108->76|109->77|111->79|111->79|114->82|114->82|114->82|115->83|115->83|115->83|116->84|116->84|116->84
                  -- GENERATED --
              */
          