
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

object GroupList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(currentUser:User, projectId: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.39*/("""
"""),format.raw/*6.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*11.13*/Messages("Manage Organizations")),format.raw/*11.45*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*12.46*/routes/*12.52*/.Assets.versioned("images/logo.jpg")),format.raw/*12.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    """),_display_(/*17.6*/views/*17.11*/.html.iot.tags.Main_css()),format.raw/*17.36*/("""

    """),format.raw/*19.5*/("""<link href=""""),_display_(/*19.18*/routes/*19.24*/.Assets.versioned("stylesheets/views/group/style.min.css")),format.raw/*19.82*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*20.18*/routes/*20.24*/.Assets.versioned("stylesheets/views/modal-right.css")),format.raw/*20.78*/("""" rel="stylesheet" />
    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("stylesheets/views/group/group.css")),format.raw/*21.78*/("""" rel="stylesheet" />
    <style>

    </style>
  </head>
  <body class="bg-theme">
    """),_display_(/*27.6*/views/*27.11*/.html.iot.tags.Menu(currentUser, projectId)),format.raw/*27.54*/("""

    """),_display_(/*29.6*/views/*29.11*/.html.iot.tags.Header(currentUser)),format.raw/*29.45*/("""

    """),format.raw/*31.5*/("""<div class="page-wrapper">
      <div class="page-content">

        <div class="row">
          <div class="col-md-4">
            <div class="card">

              <div class="panel" style="height: 85vh;">
                <div class="panel-heading" >
                  <h4 class="panel-title">
                    <div class="row" style="padding: 10px;">
                      <div class="col-md-6" style="border-bottom: 1px solid #ccc!important;">
                        <h6 style="padding: 12px; font-weight: normal"><img src=""""),_display_(/*43.83*/routes/*43.89*/.Assets.versioned("images/org/list.png")),format.raw/*43.129*/("""" > """),_display_(/*43.134*/Messages("manage.group.list")),format.raw/*43.163*/("""</h6>
                      </div>
                      <div class="col-md-6" style="border-bottom: 1px solid #ccc!important;">
                        <div class="input-group">
                          <span class="input-group-text" style="margin-left: -5px; cursor: pointer" onclick="showPopupAddOrg()" data-bs-toggle="modal" data-bs-target="#addGroupRootModal" title=""""),_display_(/*47.196*/Messages("iot.manage.groupAis.addGroupRoot")),format.raw/*47.240*/(""""><i class='bx bx-plus'></i></span>
                          <span class="input-group-text" onclick="focusSearchTree()"><i class='bx bx-search-alt'></i></span>
                          <input id="search-selectOrg" class="search-input form-control border-start-0" placeholder="" maxlength="30">
                        </div>
                      </div>
                    </div>
                  </h4>
                </div>


                <div class="panel-body" style="padding: 5px 2px 2px 2px; overflow-y: auto;  background-color: #EAEBEB; height: 77vh;" >
                  <div style="width: 100%; overflow: auto; height: 100%" id="tabListOrg">
                    <div id="jstree">
                      """),format.raw/*60.52*/("""
                    """),format.raw/*61.21*/("""</div>
                  </div>
                </div>

              </div>
            </div>
          </div>

          <div class="col-md-8">
            <div class="card " style="height: 85vh; overflow-x: auto">
              <div class="card-body">
                <ul class="nav nav-tabs" role="tablist">

                  <li class="nav-item" role="presentation" onclick="changeTabInfoOrg()">
                    <a class="nav-link active" data-bs-toggle="tab" href="#infoOrg" role="tab" aria-selected="false">
                      <div class="d-flex align-items-center">
                        <img src=""""),_display_(/*77.36*/routes/*77.42*/.Assets.versioned("images/org/org.png")),format.raw/*77.81*/("""">&nbsp
                        <span style="margin-left: 5px">"""),_display_(/*78.57*/Messages("manage.group.infoOrg")),format.raw/*78.89*/("""</span>
                      </div>
                    </a>
                  </li>
                  <li class="nav-item" role="presentation" onclick="changeTabGroup()">
                    <a class="nav-link" data-bs-toggle="tab" href="#addDelGroup" role="tab" aria-selected="false">
                      <div class="d-flex align-items-center">
                        <img src=""""),_display_(/*85.36*/routes/*85.42*/.Assets.versioned("images/org/group.png")),format.raw/*85.83*/("""">&nbsp
                        <span style="margin-left: 5px">"""),_display_(/*86.57*/Messages("manage.group.group")),format.raw/*86.87*/("""</span>
                      </div>
                    </a>
                  </li>
                  <li class="nav-item" role="presentation" onclick="changeTabUser()">
                    <a class="nav-link" data-bs-toggle="tab" href="#addDelUser" role="tab" aria-selected="false">
                      <div class="d-flex align-items-center">
                        <img src=""""),_display_(/*93.36*/routes/*93.42*/.Assets.versioned("images/org/user.png")),format.raw/*93.82*/("""">&nbsp
                        <span style="margin-left: 5px">"""),_display_(/*94.57*/Messages("manage.group.user")),format.raw/*94.86*/("""</span>
                      </div>
                    </a>
                  </li>
                  <li class="nav-item" role="presentation" onclick="changeTabDevice()">
                    <a class="nav-link" data-bs-toggle="tab" href="#addDelDevice" role="tab" aria-selected="true">
                      <div class="d-flex align-items-center">
                        <img src=""""),_display_(/*101.36*/routes/*101.42*/.Assets.versioned("images/org/device.png")),format.raw/*101.84*/("""">&nbsp
                        <span style="margin-left: 5px">"""),_display_(/*102.57*/Messages("manage.group.device")),format.raw/*102.88*/("""</span>
                      </div>
                    </a>
                  </li>
                  <li class="nav-item" role="presentation" onclick="changeTabEvent()">
                    <a class="nav-link" data-bs-toggle="tab" href="#addDelEvent" role="tab" aria-selected="false">
                      <div class="d-flex align-items-center">
                        <img src=""""),_display_(/*109.36*/routes/*109.42*/.Assets.versioned("images/org/event.png")),format.raw/*109.83*/("""">&nbsp
                        <span style="margin-left: 5px">"""),_display_(/*110.57*/Messages("manage.group.event")),format.raw/*110.87*/("""</span>
                      </div>
                    </a>
                  </li>
                  <li class="nav-item" role="presentation" onclick="changeTabRole()">
                    <a class="nav-link" data-bs-toggle="tab" href="#addDelRole" role="tab" aria-selected="false">
                      <div class="d-flex align-items-center">
                        <img src=""""),_display_(/*117.36*/routes/*117.42*/.Assets.versioned("images/org/role.png")),format.raw/*117.82*/("""">&nbsp
                        <span style="margin-left: 3px">"""),_display_(/*118.57*/Messages("manage.group.role")),format.raw/*118.86*/("""</span>
                      </div>
                    </a>
                  </li>

                </ul>
                <div class="tab-content py-3">
                  <div class="tab-pane fade show active" id="infoOrg" role="tabpanel">
                  """),_display_(/*126.20*/views/*126.25*/.html.group.GroupList_tab_InfoOrg()),format.raw/*126.60*/("""
                  """),format.raw/*127.19*/("""</div>
                  <div class="tab-pane fade" id="addDelGroup" role="tabpanel">
                  """),_display_(/*129.20*/views/*129.25*/.html.group.GroupList_tab_AddDelGroup()),format.raw/*129.64*/("""
                  """),format.raw/*130.19*/("""</div>
                  <div class="tab-pane fade" id="addDelUser" role="tabpanel">
                  """),_display_(/*132.20*/views/*132.25*/.html.group.GroupList_tab_AddDelUser()),format.raw/*132.63*/("""
                  """),format.raw/*133.19*/("""</div>
                  <div class="tab-pane fade" id="addDelDevice" role="tabpanel">
                  """),_display_(/*135.20*/views/*135.25*/.html.group.GroupList_tab_AddMoveDevice()),format.raw/*135.66*/("""
                  """),format.raw/*136.19*/("""</div>
                  <div class="tab-pane fade" id="addDelEvent" role="tabpanel">
                  """),_display_(/*138.20*/views/*138.25*/.html.group.GroupList_tab_AddDelEvent()),format.raw/*138.64*/("""
                  """),format.raw/*139.19*/("""</div>
                  <div class="tab-pane fade" id="addDelRole" role="tabpanel">
                  """),_display_(/*141.20*/views/*141.25*/.html.group.GroupList_tab_AddDelRole()),format.raw/*141.63*/("""
                  """),format.raw/*142.19*/("""</div>
                </div>
              </div>
            </div>
          </div>

        </div>
      </div>
    </div>

    """),_display_(/*152.6*/views/*152.11*/.html.group.GroupList_modal_org_delOrg()),format.raw/*152.51*/("""
    """),_display_(/*153.6*/views/*153.11*/.html.group.GroupList_modal_org_addOrgRoot()),format.raw/*153.55*/("""
    """),_display_(/*154.6*/views/*154.11*/.html.group.GroupList_modal_org_edit()),format.raw/*154.49*/("""
    """),_display_(/*155.6*/views/*155.11*/.html.group.GroupList_modal_org_addAttribute()),format.raw/*155.57*/("""
    """),_display_(/*156.6*/views/*156.11*/.html.group.GroupList_modal_org_delAttribute()),format.raw/*156.57*/("""
    """),_display_(/*157.6*/views/*157.11*/.html.group.GroupList_modal_org_editAttribute()),format.raw/*157.58*/("""

    """),_display_(/*159.6*/views/*159.11*/.html.group.GroupList_modal_user_addUser()),format.raw/*159.53*/("""
    """),_display_(/*160.6*/views/*160.11*/.html.group.GroupList_modal_user_delUsers()),format.raw/*160.54*/("""
    """),_display_(/*161.6*/views/*161.11*/.html.group.GroupList_modal_user_editRole()),format.raw/*161.54*/("""

    """),_display_(/*163.6*/views/*163.11*/.html.group.GroupList_modal_device_addDevice()),format.raw/*163.57*/("""
    """),_display_(/*164.6*/views/*164.11*/.html.group.GroupList_modal_device_delDevice()),format.raw/*164.57*/("""
    """),_display_(/*165.6*/views/*165.11*/.html.group.GroupList_modal_device_editDevice()),format.raw/*165.58*/("""
    """),_display_(/*166.6*/views/*166.11*/.html.group.GroupList_modal_group_select()),format.raw/*166.53*/("""

    """),_display_(/*168.6*/views/*168.11*/.html.group.GroupList_modal_group_add()),format.raw/*168.50*/("""
    """),_display_(/*169.6*/views/*169.11*/.html.group.GroupList_modal_group_editGroup()),format.raw/*169.56*/("""
    """),_display_(/*170.6*/views/*170.11*/.html.group.GroupList_modal_group_del()),format.raw/*170.50*/("""
    """),_display_(/*171.6*/views/*171.11*/.html.group.GroupList_modal_group_editRole()),format.raw/*171.55*/("""
    """),_display_(/*172.6*/views/*172.11*/.html.group.GroupList_modal_group_addUser()),format.raw/*172.54*/("""

    """),_display_(/*174.6*/views/*174.11*/.html.group.GroupList_modal_event_del()),format.raw/*174.50*/("""
    """),_display_(/*175.6*/views/*175.11*/.html.group.GroupList_modal_event_add()),format.raw/*175.50*/("""
    """),_display_(/*176.6*/views/*176.11*/.html.group.GroupList_modal_event_detail()),format.raw/*176.53*/("""

    """),_display_(/*178.6*/views/*178.11*/.html.group.GroupList_modal_role_add()),format.raw/*178.49*/("""
    """),_display_(/*179.6*/views/*179.11*/.html.group.GroupList_modal_role_del()),format.raw/*179.49*/("""

    """),_display_(/*181.6*/views/*181.11*/.html.Loading()),format.raw/*181.26*/("""
  """),format.raw/*182.3*/("""</body>

  """),_display_(/*184.4*/views/*184.9*/.html.iot.tags.Main_js()),format.raw/*184.33*/("""

  """),format.raw/*186.3*/("""<script>
    var projectId = '"""),_display_(/*187.23*/projectId),format.raw/*187.32*/("""';

          $(document).ready(function () """),format.raw/*189.41*/("""{"""),format.raw/*189.42*/("""
            """),format.raw/*190.13*/("""$("#menu-org").addClass("mm-active");

            $("#menu").metisMenu();
            for (var e = window.location, o = $(".metismenu li a").filter(function() """),format.raw/*193.86*/("""{"""),format.raw/*193.87*/("""
              """),format.raw/*194.15*/("""return this.href == e
            """),format.raw/*195.13*/("""}"""),format.raw/*195.14*/(""").addClass("").parent().addClass("mm-active"); o.is("li");) o = o.parent("").addClass("mm-show").parent("").addClass("mm-active");
          """),format.raw/*196.11*/("""}"""),format.raw/*196.12*/(""");

    var imgOrgDefault = """"),_display_(/*198.27*/routes/*198.33*/.Assets.versioned("images/org/building.png")),format.raw/*198.77*/("""";
    var iconEdit = """"),_display_(/*199.22*/routes/*199.28*/.Assets.versioned("images/icon/edit.png")),format.raw/*199.69*/("""";
    var iconDelete = """"),_display_(/*200.24*/routes/*200.30*/.Assets.versioned("images/icon/delete.png")),format.raw/*200.73*/("""";
    var iconCopy = """"),_display_(/*201.22*/routes/*201.28*/.Assets.versioned("images/icon/copy.png")),format.raw/*201.69*/("""";
    var iconGroup = """"),_display_(/*202.23*/routes/*202.29*/.Assets.versioned("images/icon/group.png")),format.raw/*202.71*/("""";
  </script>

"""),format.raw/*205.130*/("""
  """),format.raw/*206.3*/("""<script src=""""),_display_(/*206.17*/routes/*206.23*/.Assets.versioned("javascripts/views/group/jstree.js")),format.raw/*206.77*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*207.17*/routes/*207.23*/.Assets.versioned("javascripts/views/group/TreeOrg.js")),format.raw/*207.78*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*208.17*/routes/*208.23*/.Assets.versioned("javascripts/views/group/OrgInfo.js")),format.raw/*208.78*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*209.17*/routes/*209.23*/.Assets.versioned("javascripts/views/group/TreeGroup.js")),format.raw/*209.80*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*210.17*/routes/*210.23*/.Assets.versioned("javascripts/views/group/UserGroup.js")),format.raw/*210.80*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*211.17*/routes/*211.23*/.Assets.versioned("javascripts/views/group/DeviceGroup.js")),format.raw/*211.82*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*212.17*/routes/*212.23*/.Assets.versioned("javascripts/views/group/DeviceGroup_table.js")),format.raw/*212.88*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*214.17*/routes/*214.23*/.Assets.versioned("javascripts/views/group/GroupList.js")),format.raw/*214.80*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*215.17*/routes/*215.23*/.Assets.versioned("javascripts/views/group/RoleList.js")),format.raw/*215.79*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*216.17*/routes/*216.23*/.Assets.versioned("javascripts/views/group/EventList.js")),format.raw/*216.80*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*217.17*/routes/*217.23*/.Assets.versioned("javascripts/views/group/EventEdit.js")),format.raw/*217.80*/("""" type="text/javascript"></script>

  <script src=""""),_display_(/*219.17*/routes/*219.23*/.Assets.versioned("javascripts/views/group/TreeGroup_move.js")),format.raw/*219.85*/("""" type="text/javascript"></script>

  <script>
          $(document).ready(function() """),format.raw/*222.40*/("""{"""),format.raw/*222.41*/("""
            """),format.raw/*223.13*/("""getListOrganizations();
          """),format.raw/*224.11*/("""}"""),format.raw/*224.12*/(""")
  </script>
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
                  DATE: Mon Sep 22 16:32:41 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList.scala.html
                  HASH: 94e4c96f1784c210da32ff1bcc5a1a51cd64b278
                  MATRIX: 657->1|680->18|720->52|754->80|1098->112|1230->149|1257->150|1426->292|1479->324|1560->378|1575->384|1632->420|1839->601|1853->606|1899->631|1932->637|1972->650|1987->656|2066->714|2132->753|2147->759|2222->813|2288->852|2303->858|2378->912|2493->1001|2507->1006|2571->1049|2604->1056|2618->1061|2673->1095|2706->1101|3266->1634|3281->1640|3343->1680|3376->1685|3427->1714|3829->2088|3895->2132|4641->2879|4690->2900|5335->3518|5350->3524|5410->3563|5501->3627|5554->3659|5966->4044|5981->4050|6043->4091|6134->4155|6185->4185|6595->4568|6610->4574|6671->4614|6762->4678|6812->4707|7226->5093|7242->5099|7306->5141|7398->5205|7451->5236|7864->5621|7880->5627|7943->5668|8035->5732|8087->5762|8498->6145|8514->6151|8576->6191|8668->6255|8719->6284|9009->6546|9024->6551|9081->6586|9129->6605|9262->6710|9277->6715|9338->6754|9386->6773|9518->6877|9533->6882|9593->6920|9641->6939|9775->7045|9790->7050|9853->7091|9901->7110|10034->7215|10049->7220|10110->7259|10158->7278|10290->7382|10305->7387|10365->7425|10413->7444|10573->7577|10588->7582|10650->7622|10683->7628|10698->7633|10764->7677|10797->7683|10812->7688|10872->7726|10905->7732|10920->7737|10988->7783|11021->7789|11036->7794|11104->7840|11137->7846|11152->7851|11221->7898|11255->7905|11270->7910|11334->7952|11367->7958|11382->7963|11447->8006|11480->8012|11495->8017|11560->8060|11594->8067|11609->8072|11677->8118|11710->8124|11725->8129|11793->8175|11826->8181|11841->8186|11910->8233|11943->8239|11958->8244|12022->8286|12056->8293|12071->8298|12132->8337|12165->8343|12180->8348|12247->8393|12280->8399|12295->8404|12356->8443|12389->8449|12404->8454|12470->8498|12503->8504|12518->8509|12583->8552|12617->8559|12632->8564|12693->8603|12726->8609|12741->8614|12802->8653|12835->8659|12850->8664|12914->8706|12948->8713|12963->8718|13023->8756|13056->8762|13071->8767|13131->8805|13165->8812|13180->8817|13217->8832|13248->8835|13287->8847|13301->8852|13347->8876|13379->8880|13438->8911|13469->8920|13542->8964|13572->8965|13614->8978|13803->9138|13833->9139|13877->9154|13940->9188|13970->9189|14140->9330|14170->9331|14228->9361|14244->9367|14310->9411|14362->9435|14378->9441|14441->9482|14495->9508|14511->9514|14576->9557|14628->9581|14644->9587|14707->9628|14760->9653|14776->9659|14840->9701|14886->9846|14917->9849|14959->9863|14975->9869|15051->9923|15130->9974|15146->9980|15223->10035|15302->10086|15318->10092|15395->10147|15474->10198|15490->10204|15569->10261|15648->10312|15664->10318|15743->10375|15822->10426|15838->10432|15919->10491|15998->10542|16014->10548|16101->10613|16181->10665|16197->10671|16276->10728|16355->10779|16371->10785|16449->10841|16528->10892|16544->10898|16623->10955|16702->11006|16718->11012|16797->11069|16877->11121|16893->11127|16977->11189|17092->11275|17122->11276|17164->11289|17227->11323|17257->11324
                  LINES: 24->1|25->2|26->3|27->4|32->5|37->5|38->6|43->11|43->11|44->12|44->12|44->12|49->17|49->17|49->17|51->19|51->19|51->19|51->19|52->20|52->20|52->20|53->21|53->21|53->21|59->27|59->27|59->27|61->29|61->29|61->29|63->31|75->43|75->43|75->43|75->43|75->43|79->47|79->47|92->60|93->61|109->77|109->77|109->77|110->78|110->78|117->85|117->85|117->85|118->86|118->86|125->93|125->93|125->93|126->94|126->94|133->101|133->101|133->101|134->102|134->102|141->109|141->109|141->109|142->110|142->110|149->117|149->117|149->117|150->118|150->118|158->126|158->126|158->126|159->127|161->129|161->129|161->129|162->130|164->132|164->132|164->132|165->133|167->135|167->135|167->135|168->136|170->138|170->138|170->138|171->139|173->141|173->141|173->141|174->142|184->152|184->152|184->152|185->153|185->153|185->153|186->154|186->154|186->154|187->155|187->155|187->155|188->156|188->156|188->156|189->157|189->157|189->157|191->159|191->159|191->159|192->160|192->160|192->160|193->161|193->161|193->161|195->163|195->163|195->163|196->164|196->164|196->164|197->165|197->165|197->165|198->166|198->166|198->166|200->168|200->168|200->168|201->169|201->169|201->169|202->170|202->170|202->170|203->171|203->171|203->171|204->172|204->172|204->172|206->174|206->174|206->174|207->175|207->175|207->175|208->176|208->176|208->176|210->178|210->178|210->178|211->179|211->179|211->179|213->181|213->181|213->181|214->182|216->184|216->184|216->184|218->186|219->187|219->187|221->189|221->189|222->190|225->193|225->193|226->194|227->195|227->195|228->196|228->196|230->198|230->198|230->198|231->199|231->199|231->199|232->200|232->200|232->200|233->201|233->201|233->201|234->202|234->202|234->202|237->205|238->206|238->206|238->206|238->206|239->207|239->207|239->207|240->208|240->208|240->208|241->209|241->209|241->209|242->210|242->210|242->210|243->211|243->211|243->211|244->212|244->212|244->212|246->214|246->214|246->214|247->215|247->215|247->215|248->216|248->216|248->216|249->217|249->217|249->217|251->219|251->219|251->219|254->222|254->222|255->223|256->224|256->224
                  -- GENERATED --
              */
          