
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
/*1.2*/import vn.m2m.iot.models.Organization

object UserOrg_update extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[Organization],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(organizationList: List[Organization]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.40*/("""

"""),format.raw/*4.1*/("""<div class="modal fade" id="setUserOrg" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" id="theme16">
            <div class="modal-header">
                <h5 class="modal-title text-darker" id="exampleModalLabel">
                    """),_display_(/*9.22*/Messages("event.title.org.change")),format.raw/*9.56*/("""
                """),format.raw/*10.17*/("""</h5>
                <hr>
            </div>
            <div class="modal-body">
                <form class="row g-3">
                    <div class="col-md-12">
                        <label class="form-label text-darker">"""),_display_(/*16.64*/Messages("event.column.title.organization")),format.raw/*16.107*/("""</label>
                        <select id="listOrgUser" class="form-select">
                        """),_display_(/*18.26*/for((org: Organization)<- organizationList) yield /*18.69*/ {_display_(Seq[Any](format.raw/*18.71*/("""
                            """),format.raw/*19.29*/("""<option value=""""),_display_(/*19.45*/org/*19.48*/.getId),format.raw/*19.54*/("""">"""),_display_(/*19.57*/org/*19.60*/.getName),format.raw/*19.68*/("""</option>
                        """)))}),format.raw/*20.26*/("""
                        """),format.raw/*21.25*/("""</select>

                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" onclick="changeUserOrganization()" data-bs-dismiss="modal">"""),_display_(/*28.123*/Messages("btnSave")),format.raw/*28.142*/("""</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*29.90*/Messages("btnClose")),format.raw/*29.110*/("""</button>
            </div>
        </div>
    </div>
</div>"""))
      }
    }
  }

  def render(organizationList:List[Organization]): play.twirl.api.HtmlFormat.Appendable = apply(organizationList)

  def f:((List[Organization]) => play.twirl.api.HtmlFormat.Appendable) = (organizationList) => apply(organizationList)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:56 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/user/UserOrg_update.scala.html
                  HASH: 6f53da11985c560c9f0fe32945dbfaca913a441b
                  MATRIX: 656->1|1019->40|1152->78|1180->80|1532->406|1586->440|1631->457|1887->686|1952->729|2083->833|2142->876|2182->878|2239->907|2282->923|2294->926|2321->932|2351->935|2363->938|2392->946|2458->981|2511->1006|2782->1249|2823->1268|2949->1367|2991->1387
                  LINES: 24->1|29->2|34->2|36->4|41->9|41->9|42->10|48->16|48->16|50->18|50->18|50->18|51->19|51->19|51->19|51->19|51->19|51->19|51->19|52->20|53->21|60->28|60->28|61->29|61->29
                  -- GENERATED --
              */
          