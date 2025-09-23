
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

object GroupList_modal_role_add_action extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(id: String, style: String, name: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.43*/("""
"""),format.raw/*2.1*/("""<div class="card-body" id=""""),_display_(/*2.29*/id),format.raw/*2.31*/(""""  style=""""),_display_(/*2.42*/style),format.raw/*2.47*/("""">
  <ul class="nav nav-tabs" role="tablist" hidden>
    <li class="nav-item" role="presentation">
      <a class="nav-link" data-bs-toggle="tab" href=""""),_display_(/*5.55*/Messages("#")),_display_(/*5.69*/id),format.raw/*5.71*/("""" role="tab" aria-selected="false">
        <div class="d-flex align-items-center">
          <div class="tab-icon"><i class='bx bx-user-pin font-18 me-1'></i>
          </div>
          <div class="tab-title">"""),_display_(/*9.35*/name),format.raw/*9.39*/("""</div>
        </div>
      </a>
    </li>
  </ul>
  <div class="tab-content py-3">
    <div class="tab-pane fade show active" role="tabpanel">
      <div class="form-check mt-3">
        <input class="form-check-input" type="checkbox" value="read" onchange="change_action(this, '"""),_display_(/*17.102*/id),format.raw/*17.104*/("""', 'read')">
        <label class="form-check-label" for="flexCheckDefault">"""),_display_(/*18.65*/Messages("btnView")),format.raw/*18.84*/("""</label>
      </div>
      <div class="form-check mt-3">
        <input class="form-check-input" type="checkbox" value="create" onchange="change_action(this, '"""),_display_(/*21.104*/id),format.raw/*21.106*/("""', 'create')">
        <label class="form-check-label" for="flexCheckDefault">"""),_display_(/*22.65*/Messages("btnCreate")),format.raw/*22.86*/("""</label>
      </div>
      <div class="form-check mt-3">
        <input class="form-check-input" type="checkbox" value="modify" onchange="change_action(this, '"""),_display_(/*25.104*/id),format.raw/*25.106*/("""', 'modify')">
        <label class="form-check-label" for="flexCheckDefault">"""),_display_(/*26.65*/Messages("btnEdit")),format.raw/*26.84*/("""</label>
      </div>
      <div class="form-check mt-3">
        <input class="form-check-input" type="checkbox" value="delete" onchange="change_action(this, '"""),_display_(/*29.104*/id),format.raw/*29.106*/("""', 'delete')">
        <label class="form-check-label" for="flexCheckDefault">"""),_display_(/*30.65*/Messages("btnDelete")),format.raw/*30.86*/("""</label>
      </div>
    </div>
  </div>
</div>"""))
      }
    }
  }

  def render(id:String,style:String,name:String): play.twirl.api.HtmlFormat.Appendable = apply(id,style,name)

  def f:((String,String,String) => play.twirl.api.HtmlFormat.Appendable) = (id,style,name) => apply(id,style,name)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:42 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList_modal_role_add_action.scala.html
                  HASH: 4aa5fc177c628be31b7c58652971ea0da73ad8e7
                  MATRIX: 994->1|1130->42|1157->43|1211->71|1233->73|1270->84|1295->89|1474->242|1507->256|1529->258|1766->469|1790->473|2099->754|2123->756|2227->833|2267->852|2456->1013|2480->1015|2586->1094|2628->1115|2817->1276|2841->1278|2947->1357|2987->1376|3176->1537|3200->1539|3306->1618|3348->1639
                  LINES: 28->1|33->1|34->2|34->2|34->2|34->2|34->2|37->5|37->5|37->5|41->9|41->9|49->17|49->17|50->18|50->18|53->21|53->21|54->22|54->22|57->25|57->25|58->26|58->26|61->29|61->29|62->30|62->30
                  -- GENERATED --
              */
          