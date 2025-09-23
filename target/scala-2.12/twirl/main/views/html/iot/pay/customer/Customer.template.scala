
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

object Customer extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(currentUser:User, projectId:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.38*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*9.13*/Messages("Customer")),format.raw/*9.33*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.versioned("images/logo.jpg")),format.raw/*10.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*15.6*/views/*15.11*/.html.iot.tags.Main_css()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*17.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("stylesheets/views/pay/customer.css")),format.raw/*18.79*/("""" rel="stylesheet" />

  </head>
  <body class="bg-theme">
    """),_display_(/*22.6*/views/*22.11*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*22.54*/("""

    """),_display_(/*24.6*/views/*24.11*/.html.iot.tags.Header(currentUser)),format.raw/*24.45*/("""

    """),format.raw/*26.5*/("""<div class="">
      <div class="toolbar" style="float: right; transition: 0.4s;position: fixed;bottom: 10px;right: 20px;z-index: 99;">
        <button class="btn btn-light px-5 radius-30" onclick="changePackDataModal()" id="buttonChangePackData" style="display: none">
          <i class="bx bx-history" aria-hidden="true"></i> """),_display_(/*29.61*/Messages("packdata.change")),format.raw/*29.88*/("""
        """),format.raw/*30.9*/("""</button>
      </div>
    </div>

    <div class="page-wrapper">
      <div class="page-content">

        <div class="row">
          <div class="col-md-4">
            <div class="card">

              <div class="panel" style="">
                <div class="panel-heading" >
                  <h4 class="panel-title">
                    <div class="row" style="padding: 10px;">
                      <div class="col-md-12">
                        <div class="input-group">
                          <select id="chooseOrg" class="form-select" style="border: 1px solid #aaa;" onchange="getListUserOrg()">
                            <option value="" selected disabled>"""),_display_(/*48.65*/Messages("packdata.chooseOrg")),format.raw/*48.95*/("""</option>
                          </select>
                        </div>

                        <div class="input-group" style="margin-top: 10px;">
                          <div class="inner-addon left-addon" style="width: 100%;">
                            <input id="searchCustomer" class="form-control inputSearch" type="text" placeholder="" maxlength="30">
                            <i class="glyphicon bx bx-search" onclick="focusSearchTree()"></i>
                          </div>
                        </div>
                      </div>
                    </div>
                  </h4>
                </div>


                <div class="panel-body" style="padding: 2px 2px 2px 2px; overflow-y: auto;  color: #ffffff; height: 77vh;" >
                  <div style="width: 100%; overflow: auto; height: 100%; padding: 10px;" id="listUserOfOrg">

                  </div>
                </div>

              </div>
            </div>
          </div>

          <div class="col-md-8">
            <div class="row">
              <div class="col-md-6">
                <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
                  <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; font-weight: normal;">
                    """),_display_(/*79.22*/Messages("Thông tin người dùng")),format.raw/*79.54*/("""
                    """),format.raw/*80.21*/("""<i class="bx bx-edit" data-bs-toggle="modal" data-bs-target="#editCustomerModal" style="right: 10px; position: absolute; font-size: 24px; cursor: pointer;"></i>
                  </span>
                </div>
                <div class="card mb-3" style="height: 75%; border: 1px solid #858687;">
                  <div class="card-body">
                    <p class="card-text" id="idUserCurrent">Mã ID:  </p>
                    <p class="card-text" id="nameUserCurrent">Tên: </p>
                    <p class="card-text" id="phoneUserCurrent">Số điện thoại: </p>
                    <p class="card-text" id="addressUserCurrent">Địa chỉ: </p>
                  </div>
                </div>
              </div>

              <div class="col-md-6">
                <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
                  <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; font-weight: normal;">
                    """),_display_(/*96.22*/Messages("Thông tin nhà cung cấp")),format.raw/*96.56*/("""
                  """),format.raw/*97.19*/("""<i class="bx bx-edit" data-bs-toggle="modal" data-bs-target="#editCompanyModal" style="right: 10px; position: absolute; font-size: 24px; cursor: pointer;"></i>
                  </span>
                </div>
                <div class="card mb-3" style="height: 75%; border: 1px solid #858687;">
                  <div class="card-body">
                    <p class="card-text" id="nameVendor">Tên công ty: </p>
                    <p class="card-text" id="faxVendor">Mã số thuế: </p>
                    <p class="card-text" id="addressVendor">Địa chỉ: </p>
                  </div>
                </div>
              </div>

              <div class="col-md-12 mt-4">
                <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
                  <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; font-weight: normal;">"""),_display_(/*111.162*/Messages("Thông tin gói cước")),format.raw/*111.192*/("""</span>
                </div>
                <div class="card mb-3" style="height: 75%; border: 1px solid #858687;">
                  <div class="card-body">
                    <div class="row">
                      <div class="col-md-6">
                        <div class="row mb-1">
                          <h4 class="col-sm-12 col-form-label" id="idPackDataUser">"""),_display_(/*118.85*/Messages("ID Gói cước: ")),format.raw/*118.110*/("""</h4>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="row mb-1">
                          <h4 class="col-sm-12 col-form-label" id="idSubsUser">"""),_display_(/*123.81*/Messages("ID Đăng ký: ")),format.raw/*123.105*/("""</h4>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="row mb-1">
                          <h4 class="col-sm-12 col-form-label" id="namePackDataUser">"""),_display_(/*128.87*/Messages("packdata.name")),format.raw/*128.112*/("""</h4>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="row mb-1">
                          <h4 class="col-sm-12 col-form-label" id="typePackDataUser">"""),_display_(/*133.87*/Messages("Loại gói")),format.raw/*133.107*/("""</h4>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="row mb-1">
                          <h4 class="col-sm-12 col-form-label" id="statusPackDataUser">"""),_display_(/*138.89*/Messages("Trạng thái")),format.raw/*138.111*/("""</h4>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="row mb-1">
                          <h4 class="col-sm-12 col-form-label" id="contentPackDataUser">"""),_display_(/*143.90*/Messages("Mô tả")),format.raw/*143.107*/("""</h4>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="row mb-1">
                          <h4 class="col-sm-12 col-form-label" id="datePackDataUser">"""),_display_(/*148.87*/Messages("Ngày tạo")),format.raw/*148.107*/("""</h4>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <div class="col-md-12 mt-4">
                <div class="card" style="height: 36px; opacity: 0.85;border-radius: 4px; width: 100%">
                  <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; font-weight: normal;">"""),_display_(/*158.162*/Messages("Cước tạm tính")),format.raw/*158.187*/("""</span>
                </div>
                <div class="card-group shadow" style="border: 1px solid #858687;">
                  <div class="card border-end shadow-none">
                    <div class="card-body">
                      <h5 class="card-title align-items-center">"""),_display_(/*163.66*/Messages("Số bản tin đã dùng")),format.raw/*163.96*/("""</h5>
                    </div>
                    <div class="card-footer">
                      <h4 class="card-title" style="text-align: center" id="totalMessageUse">0</h4>
                    </div>
                  </div>
                  <div class="card border-end shadow-none">
                    <div class="card-body">
                      <h5 class="card-title align-items-center">"""),_display_(/*171.66*/Messages("Số kết nối đã dùng")),format.raw/*171.96*/("""</h5>
                    </div>
                    <div class="card-footer">
                      <h4 class="card-title" style="text-align: center" id="totalConnectUse">0</h4>
                    </div>
                  </div>
                  <div class="card shadow-none">
                    <div class="card-body">
                      <h5 class="card-title align-items-center">"""),_display_(/*179.66*/Messages("Số lượng đã đăng kí")),format.raw/*179.97*/("""</h5>
                    </div>
                    <div class="card-footer">
                      <h4 class="card-title" style="text-align: center" id="totalRegisterUse">0</h4>
                    </div>
                  </div>
                  <div class="card shadow-none">
                    <div class="card-body">
                      <h5 class="card-title align-items-center">"""),_display_(/*187.66*/Messages("Chi phí hiện tại")),format.raw/*187.94*/("""</h5>
                    </div>
                    <div class="card-footer">
                      <h4 class="card-title" style="text-align: center" id="totalFeeUse">0</h4>
                    </div>
                  </div>
                </div>
              </div>

            </div>
          </div>

        </div>
      </div>
    </div>

    """),_display_(/*203.6*/views/*203.11*/.html.iot.pay.customer.Customer_changePackdata()),format.raw/*203.59*/("""
    """),_display_(/*204.6*/views/*204.11*/.html.iot.pay.customer.Customer_edit()),format.raw/*204.49*/("""
    """),_display_(/*205.6*/views/*205.11*/.html.iot.pay.customer.Customer_editCompany()),format.raw/*205.56*/("""
    """),_display_(/*206.6*/views/*206.11*/.html.iot.pay.customer.Customer_cancelPackdata()),format.raw/*206.59*/("""

    """),_display_(/*208.6*/views/*208.11*/.html.Loading()),format.raw/*208.26*/("""
  """),format.raw/*209.3*/("""</body>

  """),_display_(/*211.4*/views/*211.9*/.html.iot.tags.Main_js()),format.raw/*211.33*/("""

  """),format.raw/*213.3*/("""<script>
    var projectId = '"""),_display_(/*214.23*/projectId),format.raw/*214.32*/("""';
    var iconEdit = """"),_display_(/*215.22*/routes/*215.28*/.Assets.versioned("images/icon/edit.png")),format.raw/*215.69*/("""";
    var iconDelete = """"),_display_(/*216.24*/routes/*216.30*/.Assets.versioned("images/icon/delete.png")),format.raw/*216.73*/("""";
    var iconList = """"),_display_(/*217.22*/routes/*217.28*/.Assets.versioned("images/icon/copy.png")),format.raw/*217.69*/("""";

          $(document).ready(function () """),format.raw/*219.41*/("""{"""),format.raw/*219.42*/("""
            """),format.raw/*220.13*/("""$("#menu-customer").addClass("mm-active");

            $("#menu").metisMenu();
            for (var e = window.location, o = $(".metismenu li a").filter(function() """),format.raw/*223.86*/("""{"""),format.raw/*223.87*/("""
              """),format.raw/*224.15*/("""return this.href == e
            """),format.raw/*225.13*/("""}"""),format.raw/*225.14*/(""").addClass("").parent().addClass("mm-active"); o.is("li");) o = o.parent("").addClass("mm-show").parent("").addClass("mm-active");
          """),format.raw/*226.11*/("""}"""),format.raw/*226.12*/(""")

          function focusSearchTree() """),format.raw/*228.38*/("""{"""),format.raw/*228.39*/("""
            """),format.raw/*229.13*/("""$("#search-selectOrg").focus();
          """),format.raw/*230.11*/("""}"""),format.raw/*230.12*/("""
  """),format.raw/*231.3*/("""</script>
  <script src=""""),_display_(/*232.17*/routes/*232.23*/.Assets.versioned("javascripts/views/pay/customer/customer.js")),format.raw/*232.86*/(""""></script>
  <script src=""""),_display_(/*233.17*/routes/*233.23*/.Assets.versioned("javascripts/views/pay/customer/customer_change.js")),format.raw/*233.93*/(""""></script>
  <script src=""""),_display_(/*234.17*/routes/*234.23*/.Assets.versioned("javascripts/views/pay/customer/customer_editCompany.js")),format.raw/*234.98*/(""""></script>
  <script src=""""),_display_(/*235.17*/routes/*235.23*/.Assets.versioned("javascripts/views/pay/customer/customer_cancel.js")),format.raw/*235.93*/(""""></script>

</html>
"""))
      }
    }
  }

  def render(currentUser:User,projectId:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,projectId)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,projectId) => apply(currentUser,projectId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:45 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/pay/customer/Customer.scala.html
                  HASH: 6f447f535721656ca15f2232379af40298798586
                  MATRIX: 668->1|691->18|1036->52|1167->88|1194->89|1362->231|1402->251|1483->305|1498->311|1555->347|1762->528|1776->533|1822->558|1855->564|1895->577|1910->583|1985->637|2051->676|2066->682|2142->737|2232->801|2246->806|2310->849|2343->856|2357->861|2412->895|2445->901|2802->1231|2850->1258|2886->1267|3586->1940|3637->1970|5024->3330|5077->3362|5126->3383|6192->4422|6247->4456|6294->4475|7261->5413|7314->5443|7717->5818|7765->5843|8031->6081|8078->6105|8350->6349|8398->6374|8670->6618|8713->6638|8987->6884|9032->6906|9307->7153|9347->7170|9619->7414|9662->7434|10161->7904|10209->7929|10520->8212|10572->8242|11000->8642|11052->8672|11469->9061|11522->9092|11940->9482|11990->9510|12371->9864|12386->9869|12456->9917|12489->9923|12504->9928|12564->9966|12597->9972|12612->9977|12679->10022|12712->10028|12727->10033|12797->10081|12831->10088|12846->10093|12883->10108|12914->10111|12953->10123|12967->10128|13013->10152|13045->10156|13104->10187|13135->10196|13187->10220|13203->10226|13266->10267|13320->10293|13336->10299|13401->10342|13453->10366|13469->10372|13532->10413|13605->10457|13635->10458|13677->10471|13871->10636|13901->10637|13945->10652|14008->10686|14038->10687|14208->10828|14238->10829|14307->10869|14337->10870|14379->10883|14450->10925|14480->10926|14511->10929|14565->10955|14581->10961|14666->11024|14722->11052|14738->11058|14830->11128|14886->11156|14902->11162|14999->11237|15055->11265|15071->11271|15163->11341
                  LINES: 24->1|25->2|30->3|35->3|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|49->17|50->18|50->18|50->18|54->22|54->22|54->22|56->24|56->24|56->24|58->26|61->29|61->29|62->30|80->48|80->48|111->79|111->79|112->80|128->96|128->96|129->97|143->111|143->111|150->118|150->118|155->123|155->123|160->128|160->128|165->133|165->133|170->138|170->138|175->143|175->143|180->148|180->148|190->158|190->158|195->163|195->163|203->171|203->171|211->179|211->179|219->187|219->187|235->203|235->203|235->203|236->204|236->204|236->204|237->205|237->205|237->205|238->206|238->206|238->206|240->208|240->208|240->208|241->209|243->211|243->211|243->211|245->213|246->214|246->214|247->215|247->215|247->215|248->216|248->216|248->216|249->217|249->217|249->217|251->219|251->219|252->220|255->223|255->223|256->224|257->225|257->225|258->226|258->226|260->228|260->228|261->229|262->230|262->230|263->231|264->232|264->232|264->232|265->233|265->233|265->233|266->234|266->234|266->234|267->235|267->235|267->235
                  -- GENERATED --
              */
          