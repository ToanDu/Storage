
package views.html.group

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
/*3.2*/import vn.m2m.models.Group
/*4.2*/import vn.m2m.utils.UserHelper

object GroupManageList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[User,List[Group],Group,List[Group],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(currentUser:User, listGroupJson: List[Group], currentGroup: Group, listOtherGroups:List[Group]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.98*/("""
"""),format.raw/*6.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*11.13*/Messages("Manage Groups")),format.raw/*11.38*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*12.46*/routes/*12.52*/.Assets.versioned("images/iot.png")),format.raw/*12.87*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <link href=""""),_display_(/*18.18*/routes/*18.24*/.Assets.versioned("stylesheets/views/group/style.min.css")),format.raw/*18.82*/("""" rel="stylesheet" />
    <link rel="stylesheet" href=""""),_display_(/*19.35*/routes/*19.41*/.Assets.versioned("assets/js/wizard/css/jquery.steps.css")),format.raw/*19.99*/("""">
    <link type="text/css" rel="stylesheet" href=""""),_display_(/*20.51*/routes/*20.57*/.Assets.versioned("assets/js/wizard/jquery.stepy.css")),format.raw/*20.111*/("""" />
    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("assets/js/tabs/acc-wizard.min.css")),format.raw/*21.78*/("""" rel="stylesheet">

    <style type="text/css">
      .modal-dialog-aside """),format.raw/*24.27*/("""{"""),format.raw/*24.28*/("""
        """),format.raw/*25.9*/("""position: fixed;
        right: 0;
        top: 0;
        bottom: 0;
      """),format.raw/*29.7*/("""}"""),format.raw/*29.8*/("""
            """),format.raw/*30.13*/(""".modal .modal-dialog-aside"""),format.raw/*30.39*/("""{"""),format.raw/*30.40*/("""
              """),format.raw/*31.15*/("""width: 350px;
              max-width:80%; height: 100%; margin:0;
              transform: translate(0); transition: transform .2s;
            """),format.raw/*34.13*/("""}"""),format.raw/*34.14*/("""
            """),format.raw/*35.13*/(""".modal .modal-dialog-aside .modal-content"""),format.raw/*35.54*/("""{"""),format.raw/*35.55*/("""  """),format.raw/*35.57*/("""height: inherit; border:0; border-radius: 0;"""),format.raw/*35.101*/("""}"""),format.raw/*35.102*/("""
            """),format.raw/*36.13*/(""".modal .modal-dialog-aside .modal-content .modal-body"""),format.raw/*36.66*/("""{"""),format.raw/*36.67*/(""" """),format.raw/*36.68*/("""overflow-y: auto """),format.raw/*36.85*/("""}"""),format.raw/*36.86*/("""
            """),format.raw/*37.13*/("""/*.modal.fixed-left .modal-dialog-aside"""),format.raw/*37.52*/("""{"""),format.raw/*37.53*/(""" """),format.raw/*37.54*/("""margin-left:auto;  transform: translateX(100%); """),format.raw/*37.102*/("""}"""),format.raw/*37.103*/("""*/
            .modal.fixed-right .modal-dialog-aside"""),format.raw/*38.51*/("""{"""),format.raw/*38.52*/(""" """),format.raw/*38.53*/("""margin-right:auto; transform: translateX(-100%); """),format.raw/*38.102*/("""}"""),format.raw/*38.103*/("""
            """),format.raw/*39.13*/(""".modal.show .modal-dialog-aside"""),format.raw/*39.44*/("""{"""),format.raw/*39.45*/(""" """),format.raw/*39.46*/("""transform: translateX(0);  """),format.raw/*39.73*/("""}"""),format.raw/*39.74*/("""
    """),format.raw/*40.5*/("""</style>

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

        """),_display_(/*66.10*/views/*66.15*/.html.dashboard.Navbar(currentUser)),format.raw/*66.50*/("""
      """),format.raw/*67.7*/("""</div>
    </nav>

    """),_display_(/*70.6*/views/*70.11*/.html.dashboard.SideMenu(currentUser)),format.raw/*70.48*/("""

      """),format.raw/*72.7*/("""<!--  PAPER WRAP -->
    <div class="wrap-fluid">
      <div class="container-fluid paper-wrap bevel tlbr">
          <!-- CONTENT -->
        """),_display_(/*76.10*/views/*76.15*/.html.dashboard.Title(currentUser, Messages("Manage Groups"))),format.raw/*76.76*/("""

          """),format.raw/*78.11*/("""<!--  DEVICE MANAGER -->
        <div class="content-wrap">
          <div class="row">
            <div class="col-sm-12">

              <div class="col-md-3" >
                <div class="panel" style="height: 40em; background-color: white">
                  <div class="panel-heading" >
                    <h4 class="panel-title">
                      <div class="row" style="padding: 10px">
                        <div class="col-md-10" >
                          <input id="search-input" class="search-input" style="border-radius: 20px; width: 100%" placeholder=" ...Search Group">
                        </div>
                        <div class="col-md-2">
                          <a href="javascript:void(0)" style="display: inline; width: 50px; color: #0b75c9" data-toggle='modal' data-target='#addGroupRootModal'>
                            <i style="float: right; font-size: 20px;" class="fa fa-plus-square" aria-hidden="true"></i>
                          </a>
                        </div>
                      </div>
                    </h4>
                  </div>
                  <div class="panel-body" style="padding: 2px 2px 2px 2px; overflow-y: auto; max-height: 700px" >
                    <div style="background-color: white; width: 100%; height: 43em; overflow: auto">
                      <div id="jstree" style="background-color: white;">
                        """),format.raw/*102.54*/("""
                      """),format.raw/*103.23*/("""</div>
                    </div>
                  </div>
                </div>
              </div>

              <div class="col-md-9" style="background-color: white;">
                <div class="nest" id="tabClose">
                  """),format.raw/*111.46*/("""
                    """),format.raw/*112.29*/("""
                      """),format.raw/*113.36*/("""
                    """),format.raw/*114.50*/("""
                      """),format.raw/*115.65*/("""
                        """),format.raw/*116.65*/("""
                      """),format.raw/*117.31*/("""
                    """),format.raw/*118.31*/("""

                  """),format.raw/*120.29*/("""

                  """),format.raw/*122.19*/("""<div class="body-nest" id="tab">

                    <div id="wizard-tab">
                      <h2>"""),_display_(/*125.28*/Messages("iot.manage.groupAis.UpdateGroupInfo")),format.raw/*125.75*/("""</h2>
                      <section>"""),_display_(/*126.33*/views/*126.38*/.html.group.GroupList_tab_updateGroup()),format.raw/*126.77*/("""</section>

                      <h2>"""),_display_(/*128.28*/Messages("iot.manage.groupAis.addGroupChild")),format.raw/*128.73*/("""</h2>
                      <section>"""),_display_(/*129.33*/views/*129.38*/.html.group.GroupList_tab_insertGroup()),format.raw/*129.77*/("""</section>

                      <h2>"""),_display_(/*131.28*/Messages("iot.manage.groupAis.AddRemoveUser")),format.raw/*131.73*/("""</h2>
                      <section>"""),_display_(/*132.33*/views/*132.38*/.html.group.GroupList_tab_AddDelUser()),format.raw/*132.76*/("""</section>

                      <h2 id="h2TabDevice">"""),_display_(/*134.45*/Messages("iot.manage.groupAis.AddRemoveDevice")),format.raw/*134.92*/("""</h2>
                      <section id="sectionTabDevice">"""),_display_(/*135.55*/views/*135.60*/.html.group.GroupList_tab_AddMoveDevice()),format.raw/*135.101*/("""</section>
                    </div>

                  </div>
                </div>
              </div>

            </div>
          </div>
        </div>
          <!--  / DEVICE MANAGER -->

        <div class="content-wrap">
          <div class="row">

          </div>
            <!-- /END OF CONTENT -->

          """),_display_(/*153.12*/views/*153.17*/.html.dashboard.Footer()),format.raw/*153.41*/("""

        """),format.raw/*155.9*/("""</div>
      </div>
    </div>
      <!--  END OF PAPER WRAP -->


    """),_display_(/*161.6*/views/*161.11*/.html.dashboard.RightSlide()),format.raw/*161.39*/("""


    """),format.raw/*164.5*/("""<script src=""""),_display_(/*164.19*/routes/*164.25*/.Assets.versioned("javascripts/js/plugins/bootstrap-selectpicker.js")),format.raw/*164.94*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*165.19*/routes/*165.25*/.Assets.versioned("javascripts/views/group/jstree.js")),format.raw/*165.79*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*166.19*/routes/*166.25*/.Assets.versioned("javascripts/views/group/TreeGroup.js")),format.raw/*166.82*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*167.19*/routes/*167.25*/.Assets.versioned("javascripts/views/group/UserGroup.js")),format.raw/*167.82*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*168.19*/routes/*168.25*/.Assets.versioned("javascripts/views/group/DeviceGroup.js")),format.raw/*168.84*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*169.19*/routes/*169.25*/.Assets.versioned("javascripts/views/group/TreeGroup_move.js")),format.raw/*169.87*/("""" type="text/javascript"></script>

    <script>
            $(function ($) """),format.raw/*172.28*/("""{"""),format.raw/*172.29*/("""
              """),format.raw/*173.15*/("""// 6 create an instance when the DOM is ready
              $('#jstree').jstree("""),format.raw/*174.35*/("""{"""),format.raw/*174.36*/("""
                """),format.raw/*175.17*/("""core: """),format.raw/*175.23*/("""{"""),format.raw/*175.24*/("""
                  """),format.raw/*176.19*/("""data: [
                    """),_display_(/*177.22*/for((group: Group) <- listGroupJson) yield /*177.58*/{_display_(Seq[Any](format.raw/*177.59*/("""
                    """),format.raw/*178.21*/("""{"""),format.raw/*178.22*/("""
                      """),format.raw/*179.23*/(""""id": '"""),_display_(/*179.31*/group/*179.36*/.getId()),format.raw/*179.44*/("""',
                      """),format.raw/*180.58*/("""
                      """),format.raw/*181.23*/(""""text": '"""),_display_(/*181.33*/group/*181.38*/.getName),format.raw/*181.46*/("""'
                    """),format.raw/*182.21*/("""}"""),format.raw/*182.22*/(""",
                    """)))}),format.raw/*183.22*/("""
                  """),format.raw/*184.19*/("""],
                  check_callback: true  // don't forget to set this param to true
                """),format.raw/*186.17*/("""}"""),format.raw/*186.18*/(""",
                "plugins": ["search", "sort"],
                "search": """),format.raw/*188.27*/("""{"""),format.raw/*188.28*/("""
                  """),format.raw/*189.19*/(""""case_sensitive": false,
                  "show_only_matches": true
                """),format.raw/*191.17*/("""}"""),format.raw/*191.18*/(""",
                "sort" : function(a, b) """),format.raw/*192.41*/("""{"""),format.raw/*192.42*/("""
                  """),format.raw/*193.19*/("""//What is the function of sorting
                  a1 = this.get_node(a);
                  b1 = this.get_node(b);
                  if (a1.icon == b1.icon)"""),format.raw/*196.42*/("""{"""),format.raw/*196.43*/("""
                    """),format.raw/*197.21*/("""return (a1.text > b1.text) ? 1 : -1;
                  """),format.raw/*198.19*/("""}"""),format.raw/*198.20*/(""" """),format.raw/*198.21*/("""else """),format.raw/*198.26*/("""{"""),format.raw/*198.27*/("""
                    """),format.raw/*199.21*/("""return (a1.icon > b1.icon) ? 1 : -1;
                  """),format.raw/*200.19*/("""}"""),format.raw/*200.20*/("""
                """),format.raw/*201.17*/("""}"""),format.raw/*201.18*/("""
              """),format.raw/*202.15*/("""}"""),format.raw/*202.16*/(""");
              $('#jstree').jstree();
              // 7 bind to events triggered on the tree
              $('#jstree').on("changed.jstree", function (e, data) """),format.raw/*205.68*/("""{"""),format.raw/*205.69*/("""
                """),format.raw/*206.17*/("""selectGroup(data.selected);
              """),format.raw/*207.15*/("""}"""),format.raw/*207.16*/(""");
              // 8 interact with the tree - either way is OK
              $('button').on('click', function () """),format.raw/*209.51*/("""{"""),format.raw/*209.52*/("""
                """),format.raw/*210.17*/("""$('#jstree').jstree(true).select_node('child_node_1');
                $('#jstree').jstree('select_node', 'child_node_1');
                $.jstree.reference('#jstree').select_node('child_node_1');
              """),format.raw/*213.15*/("""}"""),format.raw/*213.16*/(""");

              $('#jstree').on('loaded.jstree', function() """),format.raw/*215.59*/("""{"""),format.raw/*215.60*/("""
                """),format.raw/*216.17*/("""//open tat ca cac node
                $('#jstree').jstree('open_all');
                //select node default
                """),_display_(/*219.18*/if(listGroupJson!=null && listGroupJson.size()>0)/*219.67*/{_display_(Seq[Any](format.raw/*219.68*/("""
                """),format.raw/*220.17*/("""//select node default
                """),_display_(/*221.18*/if(currentGroup!=null && currentGroup.getId()!=null)/*221.70*/{_display_(Seq[Any](format.raw/*221.71*/("""
                """),format.raw/*222.17*/("""$('#jstree').jstree('select_node', '"""),_display_(/*222.54*/currentGroup/*222.66*/.getId()),format.raw/*222.74*/("""');
                """)))}/*223.18*/else/*223.22*/{_display_(Seq[Any](format.raw/*223.23*/("""
                """),format.raw/*224.17*/("""$('#jstree').jstree('select_node', '"""),_display_(/*224.54*/listGroupJson/*224.67*/.get(0).getId()),format.raw/*224.82*/("""');
                """)))}),format.raw/*225.18*/("""
                """)))}),format.raw/*226.18*/("""
              """),format.raw/*227.15*/("""}"""),format.raw/*227.16*/(""");
              $(".search-input").keyup(function () """),format.raw/*228.52*/("""{"""),format.raw/*228.53*/("""
                """),format.raw/*229.17*/("""var searchString = $(this).val();
                $('#jstree').jstree('search', searchString);
              """),format.raw/*231.15*/("""}"""),format.raw/*231.16*/(""");
            """),format.raw/*232.13*/("""}"""),format.raw/*232.14*/(""");
    </script>

    <script type="text/javascript" src=""""),_display_(/*235.42*/routes/*235.48*/.Assets.versioned("assets/js/wizard/lib/jquery.cookie-1.3.1.js")),format.raw/*235.112*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*236.42*/routes/*236.48*/.Assets.versioned("assets/js/wizard/build/jquery.steps.js")),format.raw/*236.107*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*237.42*/routes/*237.48*/.Assets.versioned("assets/js/wizard/jquery.stepy.js")),format.raw/*237.101*/(""""></script>
    <script>
            $("#wizard-tab").steps("""),format.raw/*239.36*/("""{"""),format.raw/*239.37*/("""
              """),format.raw/*240.15*/("""headerTag: "h2",
              bodyTag: "section",
              transitionEffect: "none",
              enableFinishButton: false,
              enablePagination: false,
              enableAllSteps: true,
              titleTemplate: "#title#",
              cssClass: "tabcontrol"
            """),format.raw/*248.13*/("""}"""),format.raw/*248.14*/(""");
    </script>

  </body>
</html>
"""))
      }
    }
  }

  def render(currentUser:User,listGroupJson:List[Group],currentGroup:Group,listOtherGroups:List[Group]): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,listGroupJson,currentGroup,listOtherGroups)

  def f:((User,List[Group],Group,List[Group]) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,listGroupJson,currentGroup,listOtherGroups) => apply(currentUser,listGroupJson,currentGroup,listOtherGroups)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:42 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupManageList.scala.html
                  HASH: 3fb8fc12535f9e78ef5f378414bee29508dd56aa
                  MATRIX: 657->1|680->18|720->52|754->80|1127->112|1318->208|1345->209|1514->351|1560->376|1641->430|1656->436|1712->471|1933->665|1948->671|2027->729|2110->785|2125->791|2204->849|2284->902|2299->908|2375->962|2424->984|2439->990|2514->1044|2617->1119|2646->1120|2682->1129|2785->1205|2813->1206|2854->1219|2908->1245|2937->1246|2980->1261|3153->1406|3182->1407|3223->1420|3292->1461|3321->1462|3351->1464|3424->1508|3454->1509|3495->1522|3576->1575|3605->1576|3634->1577|3679->1594|3708->1595|3749->1608|3816->1647|3845->1648|3874->1649|3951->1697|3981->1698|4062->1751|4091->1752|4120->1753|4198->1802|4228->1803|4269->1816|4328->1847|4357->1848|4386->1849|4441->1876|4470->1877|4502->1882|5307->2660|5321->2665|5377->2700|5411->2707|5461->2731|5475->2736|5533->2773|5568->2781|5739->2925|5753->2930|5835->2991|5875->3003|7311->4439|7363->4462|7633->4730|7683->4759|7735->4795|7785->4845|7837->4910|7891->4975|7943->5006|7993->5037|8042->5067|8091->5087|8222->5190|8291->5237|8357->5275|8372->5280|8433->5319|8500->5358|8567->5403|8633->5441|8648->5446|8709->5485|8776->5524|8843->5569|8909->5607|8924->5612|8984->5650|9068->5706|9137->5753|9225->5813|9240->5818|9304->5859|9660->6187|9675->6192|9721->6216|9759->6226|9858->6298|9873->6303|9923->6331|9958->6338|10000->6352|10016->6358|10107->6427|10188->6480|10204->6486|10280->6540|10361->6593|10377->6599|10456->6656|10537->6709|10553->6715|10632->6772|10713->6825|10729->6831|10810->6890|10891->6943|10907->6949|10991->7011|11096->7087|11126->7088|11170->7103|11279->7183|11309->7184|11355->7201|11390->7207|11420->7208|11468->7227|11525->7256|11578->7292|11618->7293|11668->7314|11698->7315|11750->7338|11786->7346|11801->7351|11831->7359|11885->7419|11937->7442|11975->7452|11990->7457|12020->7465|12071->7487|12101->7488|12156->7511|12204->7530|12334->7631|12364->7632|12468->7707|12498->7708|12546->7727|12660->7812|12690->7813|12761->7855|12791->7856|12839->7875|13025->8032|13055->8033|13105->8054|13189->8109|13219->8110|13249->8111|13283->8116|13313->8117|13363->8138|13447->8193|13477->8194|13523->8211|13553->8212|13597->8227|13627->8228|13819->8391|13849->8392|13895->8409|13966->8451|13996->8452|14139->8566|14169->8567|14215->8584|14456->8796|14486->8797|14577->8859|14607->8860|14653->8877|14808->9004|14867->9053|14907->9054|14953->9071|15020->9110|15082->9162|15122->9163|15168->9180|15233->9217|15255->9229|15285->9237|15326->9258|15340->9262|15380->9263|15426->9280|15491->9317|15514->9330|15551->9345|15604->9366|15654->9384|15698->9399|15728->9400|15811->9454|15841->9455|15887->9472|16025->9581|16055->9582|16099->9597|16129->9598|16216->9657|16232->9663|16319->9727|16400->9780|16416->9786|16498->9845|16579->9898|16595->9904|16671->9957|16760->10017|16790->10018|16834->10033|17159->10329|17189->10330
                  LINES: 24->1|25->2|26->3|27->4|32->5|37->5|38->6|43->11|43->11|44->12|44->12|44->12|50->18|50->18|50->18|51->19|51->19|51->19|52->20|52->20|52->20|53->21|53->21|53->21|56->24|56->24|57->25|61->29|61->29|62->30|62->30|62->30|63->31|66->34|66->34|67->35|67->35|67->35|67->35|67->35|67->35|68->36|68->36|68->36|68->36|68->36|68->36|69->37|69->37|69->37|69->37|69->37|69->37|70->38|70->38|70->38|70->38|70->38|71->39|71->39|71->39|71->39|71->39|71->39|72->40|98->66|98->66|98->66|99->67|102->70|102->70|102->70|104->72|108->76|108->76|108->76|110->78|134->102|135->103|143->111|144->112|145->113|146->114|147->115|148->116|149->117|150->118|152->120|154->122|157->125|157->125|158->126|158->126|158->126|160->128|160->128|161->129|161->129|161->129|163->131|163->131|164->132|164->132|164->132|166->134|166->134|167->135|167->135|167->135|185->153|185->153|185->153|187->155|193->161|193->161|193->161|196->164|196->164|196->164|196->164|197->165|197->165|197->165|198->166|198->166|198->166|199->167|199->167|199->167|200->168|200->168|200->168|201->169|201->169|201->169|204->172|204->172|205->173|206->174|206->174|207->175|207->175|207->175|208->176|209->177|209->177|209->177|210->178|210->178|211->179|211->179|211->179|211->179|212->180|213->181|213->181|213->181|213->181|214->182|214->182|215->183|216->184|218->186|218->186|220->188|220->188|221->189|223->191|223->191|224->192|224->192|225->193|228->196|228->196|229->197|230->198|230->198|230->198|230->198|230->198|231->199|232->200|232->200|233->201|233->201|234->202|234->202|237->205|237->205|238->206|239->207|239->207|241->209|241->209|242->210|245->213|245->213|247->215|247->215|248->216|251->219|251->219|251->219|252->220|253->221|253->221|253->221|254->222|254->222|254->222|254->222|255->223|255->223|255->223|256->224|256->224|256->224|256->224|257->225|258->226|259->227|259->227|260->228|260->228|261->229|263->231|263->231|264->232|264->232|267->235|267->235|267->235|268->236|268->236|268->236|269->237|269->237|269->237|271->239|271->239|272->240|280->248|280->248
                  -- GENERATED --
              */
          