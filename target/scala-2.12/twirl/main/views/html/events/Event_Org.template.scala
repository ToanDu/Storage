
package views.html.events

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

object Event_Org extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[Organization],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(organizationList: List[Organization]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.40*/("""

"""),format.raw/*4.1*/("""<div class="modal fade" id="setEventOrg" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" id="theme16">
            <div class="modal-header">
                <h5 class="modal-title text-darker" id="exampleModalLabel"> """),_display_(/*8.78*/Messages("event.title.org.change")),format.raw/*8.112*/("""</h5>
                <hr>
            </div>
            <div class="modal-body">
                <form class="row g-3">
                    <div class="col-md-12">
                        <label class="form-label text-darker">"""),_display_(/*14.64*/Messages("event.column.title.organization")),format.raw/*14.107*/("""</label>
                        <select id="listOrg" class="form-select">
                        """),_display_(/*16.26*/for((org: Organization)<- organizationList) yield /*16.69*/ {_display_(Seq[Any](format.raw/*16.71*/("""
                            """),format.raw/*17.29*/("""<option value=""""),_display_(/*17.45*/org/*17.48*/.getId),format.raw/*17.54*/("""" id=""""),_display_(/*17.61*/org/*17.64*/.getId),format.raw/*17.70*/("""">"""),_display_(/*17.73*/org/*17.76*/.getName),format.raw/*17.84*/("""</option>
                        """)))}),format.raw/*18.26*/("""
                        """),format.raw/*19.25*/("""</select>

                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" onclick="changeEventOrganization()" data-bs-dismiss="modal">"""),_display_(/*26.124*/Messages("btnSave")),format.raw/*26.143*/("""</button>
                <button type="button" class="btn btn-danger" onclick="removeEventOrganization()" data-bs-dismiss="modal">"""),_display_(/*27.123*/Messages("btnDelete")),format.raw/*27.144*/("""</button>
                <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*28.85*/Messages("btnClose")),format.raw/*28.105*/("""</button>
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
                  DATE: Mon Sep 22 16:32:41 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/events/Event_Org.scala.html
                  HASH: e200e584078656802a6dc4f28eaf1ba7b6e3283e
                  MATRIX: 658->1|1016->40|1149->78|1177->80|1510->387|1565->421|1821->650|1886->693|2013->793|2072->836|2112->838|2169->867|2212->883|2224->886|2251->892|2285->899|2297->902|2324->908|2354->911|2366->914|2395->922|2461->957|2514->982|2786->1226|2827->1245|2987->1377|3030->1398|3151->1492|3193->1512
                  LINES: 24->1|29->2|34->2|36->4|40->8|40->8|46->14|46->14|48->16|48->16|48->16|49->17|49->17|49->17|49->17|49->17|49->17|49->17|49->17|49->17|49->17|50->18|51->19|58->26|58->26|59->27|59->27|60->28|60->28
                  -- GENERATED --
              */
          