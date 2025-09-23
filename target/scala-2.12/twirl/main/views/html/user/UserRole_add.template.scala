
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
/*1.2*/import vn.m2m.common.models.Role

object UserRole_add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[Role],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(roleList: List[Role]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.24*/("""
"""),format.raw/*3.1*/("""<div class="modal fade" id="addRoleForUserModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" id="theme16">
            <div class="modal-header">
                <h5 class="modal-title text-darker" id="exampleModalLabel">"""),_display_(/*7.77*/Messages("role.select")),format.raw/*7.100*/("""</h5>
                <hr>
            </div>
            <div class="modal-body">
                <form class="row g-3">
                    <div class="col-md-12">
                        <label class="form-label text-darker">"""),_display_(/*13.64*/Messages("role.title")),format.raw/*13.86*/("""</label>
                        <select id="listRoleDrd" class="form-select">
                            """),_display_(/*15.30*/for((role: Role)<- roleList) yield /*15.58*/ {_display_(Seq[Any](format.raw/*15.60*/("""
                                """),format.raw/*16.33*/("""<option value=""""),_display_(/*16.49*/role/*16.53*/.getId),format.raw/*16.59*/("""">"""),_display_(/*16.62*/role/*16.66*/.getName),format.raw/*16.74*/("""</option>
                            """)))}),format.raw/*17.30*/("""
                        """),format.raw/*18.25*/("""</select>
"""),format.raw/*19.52*/("""
"""),format.raw/*20.140*/("""
"""),format.raw/*21.44*/("""
"""),format.raw/*22.42*/("""
"""),format.raw/*23.59*/("""
"""),format.raw/*24.64*/("""
"""),format.raw/*25.97*/("""
"""),format.raw/*26.34*/("""
"""),format.raw/*27.38*/("""
"""),format.raw/*28.35*/("""
                    """),format.raw/*29.21*/("""</div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" onclick="addRoleForUser()" data-bs-dismiss="modal">"""),_display_(/*34.115*/Messages("btnSave")),format.raw/*34.134*/("""</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*35.90*/Messages("btnClose")),format.raw/*35.110*/("""</button>
            </div>
        </div>
    </div>
</div>"""))
      }
    }
  }

  def render(roleList:List[Role]): play.twirl.api.HtmlFormat.Appendable = apply(roleList)

  def f:((List[Role]) => play.twirl.api.HtmlFormat.Appendable) = (roleList) => apply(roleList)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:56 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/user/UserRole_add.scala.html
                  HASH: 6cbf4bba65f5d05f16f50bd2287eba8a88c90035
                  MATRIX: 656->1|1004->35|1121->57|1148->58|1488->372|1532->395|1788->624|1831->646|1966->754|2010->782|2050->784|2111->817|2154->833|2167->837|2194->843|2224->846|2237->850|2266->858|2336->897|2389->922|2427->983|2457->1123|2486->1167|2515->1209|2544->1268|2573->1332|2602->1429|2631->1463|2660->1501|2689->1536|2738->1557|2970->1761|3011->1780|3137->1879|3179->1899
                  LINES: 24->1|29->2|34->2|35->3|39->7|39->7|45->13|45->13|47->15|47->15|47->15|48->16|48->16|48->16|48->16|48->16|48->16|48->16|49->17|50->18|51->19|52->20|53->21|54->22|55->23|56->24|57->25|58->26|59->27|60->28|61->29|66->34|66->34|67->35|67->35
                  -- GENERATED --
              */
          