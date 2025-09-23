
package views.html.user

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
/*5.2*/import vn.m2m.common.models.forms.SearchObjectData

object UserManageList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[User,SearchObjectData,List[String],play.twirl.api.HtmlFormat.Appendable] {

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
    <title>"""),_display_(/*12.13*/Messages("Manage Users")),format.raw/*12.37*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*13.46*/routes/*13.52*/.Assets.versioned("images/iot.png")),format.raw/*13.87*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("assets/css/style.css")),format.raw/*18.65*/("""" rel="stylesheet"/>
    <link href=""""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("assets/css/loader-style.css")),format.raw/*19.72*/("""" rel="stylesheet"/>
    <link href=""""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("assets/css/bootstrap.min.css")),format.raw/*20.73*/("""" rel="stylesheet"/>
    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("assets/js/progress-bar/number-pb.css")),format.raw/*21.81*/("""" rel="stylesheet"/>

    <link rel="stylesheet" href=""""),_display_(/*23.35*/routes/*23.41*/.Assets.versioned("assets/js/timepicker/bootstrap-timepicker.css")),format.raw/*23.107*/("""">
    <link rel="stylesheet" href=""""),_display_(/*24.35*/routes/*24.41*/.Assets.versioned("assets/js/datepicker/datepicker.css")),format.raw/*24.97*/("""">
    <link rel="stylesheet" href=""""),_display_(/*25.35*/routes/*25.41*/.Assets.versioned("assets/js/datepicker/clockface.css")),format.raw/*25.96*/("""">

    <link rel="shortcut icon" href=""""),_display_(/*27.38*/routes/*27.44*/.Assets.versioned("assets/ico/minus.png")),format.raw/*27.85*/("""">

  </head>
  <body>
      <!-- Preloader -->
    <div id="preloader">
      <div id="status">&nbsp;</div>
    </div>

    <nav role="navigation" class="navbar navbar-static-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button data-target="#bs-example-navbar-collapse-1" data-toggle="collapse" class="navbar-toggle" type="button">
            <span class="entypo-menu"></span>
          </button>
          <button class="navbar-toggle toggle-menu-mobile toggle-left" type="button">
            <span class="entypo-list-add"></span>
          </button>

          <div id="logo-mobile" class="visible-xs">
            <h1>IoT Platform
              <span>v1.1</span>
            </h1>
          </div>
        </div>

        """),_display_(/*53.10*/views/*53.15*/.html.dashboard.Navbar(currentUser)),format.raw/*53.50*/("""
      """),format.raw/*54.7*/("""</div>
    </nav>

    """),_display_(/*57.6*/views/*57.11*/.html.dashboard.SideMenu(currentUser)),format.raw/*57.48*/("""

      """),format.raw/*59.7*/("""<!--  PAPER WRAP -->
    <div class="wrap-fluid">
      <div class="container-fluid paper-wrap bevel tlbr">
          <!-- CONTENT -->
        """),_display_(/*63.10*/views/*63.15*/.html.dashboard.Title(currentUser, Messages("Manage Users"))),format.raw/*63.75*/("""

          """),format.raw/*65.11*/("""<!--  DEVICE MANAGER -->
        <div class="content-wrap">
          <div class="row">
            <div class="col-sm-12">

              <div class="nest" id="tableStaticClose">
                <div class="title-alt">
                  <h6>Manage Users</h6>
                  <div class="titleToggle">
                    <a class="nav-toggle-alt" href="#tableStatic">
                      <span class="entypo-up-open"></span>
                    </a>
                  </div>
                </div>

                <div class="body-nest" id="tableStatic">
                  <section id="flip-scroll">

                    """),_display_(/*83.22*/views/*83.27*/.html.filter.FilterHeaderTag(currentUser, searchResultData.getSearchFilterForm,searchField,"/userList")),format.raw/*83.130*/("""

                    """),format.raw/*85.21*/("""<table class="table table-bordered table-striped cf">
                      <thead class="cf">
                        <th>"""),_display_(/*87.30*/Messages("No")),format.raw/*87.44*/("""</th>
                        <th data-field="username">"""),_display_(/*88.52*/Messages("Username")),format.raw/*88.72*/("""</th>
                        <th data-field="role">"""),_display_(/*89.48*/Messages("Role")),format.raw/*89.64*/("""</th>
                        <th data-field="createDate">"""),_display_(/*90.54*/Messages("Create Date")),format.raw/*90.77*/("""</th>
                        <th data-field="lastModified">"""),_display_(/*91.56*/Messages("Last Modified")),format.raw/*91.81*/("""</th>
                        <th>"""),_display_(/*92.30*/Messages("ACTION")),format.raw/*92.48*/("""</th>

                      </thead>
                      <tbody align="left">
                      """),_display_(/*96.24*/for((user: User, index)<- searchResultData.getObjectList.zipWithIndex) yield /*96.94*/ {_display_(Seq[Any](format.raw/*96.96*/("""
                        """),format.raw/*97.25*/("""<tr>
                          <td>"""),_display_(/*98.32*/(index+1+(searchResultData.getSearchFilterForm.getPage -1)*searchResultData.getSearchFilterForm.getPageSize)),format.raw/*98.140*/("""</td>
                          <td>"""),_display_(/*99.32*/user/*99.36*/.getUsername),format.raw/*99.48*/("""</td>
                          <td>"""),_display_(/*100.32*/User/*100.36*/.Roles.getNameByCode(user.getRole)),format.raw/*100.70*/("""</td>
                          <td>"""),_display_(/*101.32*/DateUtil/*101.40*/.getDateByFormat(user.getCreateDate, DateUtil.FORMAT_DATE_YYYY_MM_DD_HH_mm)),format.raw/*101.115*/("""</td>
                          <td>"""),_display_(/*102.32*/DateUtil/*102.40*/.getDateByFormat(user.getLastModified, DateUtil.FORMAT_DATE_YYYY_MM_DD_HH_mm)),format.raw/*102.117*/("""</td>
                          <td>
                            <a rel="tooltip" title=""""),_display_(/*104.54*/Messages("Edit")),format.raw/*104.70*/("""" class="btn btn-info btn-icon table-action edit" onclick="" data-toggle="modal" data-target="#" style="padding: 0.46875rem 1rem;">
                              <i class="fa fa-edit" title=""""),_display_(/*105.61*/Messages("Edit")),format.raw/*105.77*/(""""></i>
                            </a>
                          </td>

                        </tr>
                      """)))}),format.raw/*110.24*/("""
                      """),format.raw/*111.23*/("""</tbody>
                    </table>

                  </section>

                  """),_display_(/*116.20*/views/*116.25*/.html.filter.FilterFooterTag(searchResultData.getSearchFilterForm)),format.raw/*116.91*/("""
                """),format.raw/*117.17*/("""</div>
              </div>
            </div>

          </div>
        </div>
          <!--  / DEVICE MANAGER -->

        <div class="content-wrap">
          <div class="row">

          </div>
            <!-- /END OF CONTENT -->

          """),_display_(/*131.12*/views/*131.17*/.html.dashboard.Footer()),format.raw/*131.41*/("""

        """),format.raw/*133.9*/("""</div>
      </div>
    </div>
      <!--  END OF PAPER WRAP -->

    """),_display_(/*138.6*/views/*138.11*/.html.dashboard.RightSlide()),format.raw/*138.39*/("""



    """),format.raw/*142.5*/("""<script src=""""),_display_(/*142.19*/routes/*142.25*/.Assets.versioned("javascripts/SearchJs.js")),format.raw/*142.69*/("""" type="text/javascript"></script>
    """),_display_(/*143.6*/views/*143.11*/.html.filter.FilterScriptTag(searchResultData.getSearchFilterForm, searchField)),format.raw/*143.90*/("""
  """),format.raw/*144.3*/("""</body>
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
                  DATE: Mon Sep 22 16:32:56 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/user/UserManageList.scala.html
                  HASH: 84dc786c5d7e8261029e10fd8ac4ef1e6e41e1f2
                  MATRIX: 656->1|679->18|715->48|755->82|793->114|1185->166|1361->247|1388->248|1557->390|1602->414|1683->468|1698->474|1754->509|1974->702|1989->708|2051->749|2116->787|2131->793|2200->841|2265->879|2280->885|2350->934|2415->972|2430->978|2508->1035|2591->1091|2606->1097|2694->1163|2758->1200|2773->1206|2850->1262|2914->1299|2929->1305|3005->1360|3073->1401|3088->1407|3150->1448|3949->2220|3963->2225|4019->2260|4053->2267|4103->2291|4117->2296|4175->2333|4210->2341|4381->2485|4395->2490|4476->2550|4516->2562|5171->3190|5185->3195|5310->3298|5360->3320|5511->3444|5546->3458|5630->3515|5671->3535|5751->3588|5788->3604|5874->3663|5918->3686|6006->3747|6052->3772|6114->3807|6153->3825|6284->3929|6370->3999|6410->4001|6463->4026|6526->4062|6656->4170|6720->4207|6733->4211|6766->4223|6831->4260|6845->4264|6901->4298|6966->4335|6984->4343|7082->4418|7147->4455|7165->4463|7265->4540|7383->4630|7421->4646|7641->4838|7679->4854|7837->4980|7889->5003|8005->5091|8020->5096|8108->5162|8154->5179|8430->5427|8445->5432|8491->5456|8529->5466|8627->5537|8642->5542|8692->5570|8728->5578|8770->5592|8786->5598|8852->5642|8919->5682|8934->5687|9035->5766|9066->5769
                  LINES: 24->1|25->2|26->3|27->4|28->5|33->6|38->6|39->7|44->12|44->12|45->13|45->13|45->13|50->18|50->18|50->18|51->19|51->19|51->19|52->20|52->20|52->20|53->21|53->21|53->21|55->23|55->23|55->23|56->24|56->24|56->24|57->25|57->25|57->25|59->27|59->27|59->27|85->53|85->53|85->53|86->54|89->57|89->57|89->57|91->59|95->63|95->63|95->63|97->65|115->83|115->83|115->83|117->85|119->87|119->87|120->88|120->88|121->89|121->89|122->90|122->90|123->91|123->91|124->92|124->92|128->96|128->96|128->96|129->97|130->98|130->98|131->99|131->99|131->99|132->100|132->100|132->100|133->101|133->101|133->101|134->102|134->102|134->102|136->104|136->104|137->105|137->105|142->110|143->111|148->116|148->116|148->116|149->117|163->131|163->131|163->131|165->133|170->138|170->138|170->138|174->142|174->142|174->142|174->142|175->143|175->143|175->143|176->144
                  -- GENERATED --
              */
          