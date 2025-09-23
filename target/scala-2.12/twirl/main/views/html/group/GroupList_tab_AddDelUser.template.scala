
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

object GroupList_tab_AddDelUser extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="">
    <div class="card" style="height: 36px;background: #EC1B2E;opacity: 0.85;border-radius: 0px 4px 0px 0px; width: 100%">
        <span class="input-group-text" style="width: 100%; background-color:#EC1B2E; color: #FFFFFF; text-transform: uppercase; " id="totalUser">"""),_display_(/*3.147*/Messages("manage.org.user")),format.raw/*3.174*/("""</span>
    </div>
    <div id="tabUser" class="body-nest"></div>
    """),format.raw/*6.51*/("""
        """),format.raw/*7.60*/("""
            """),format.raw/*8.175*/("""
                """),format.raw/*9.107*/("""
            """),format.raw/*10.26*/("""
            """),format.raw/*11.156*/("""
                """),format.raw/*12.108*/("""
            """),format.raw/*13.26*/("""
            """),format.raw/*14.171*/("""
            """),format.raw/*15.87*/("""
            """),format.raw/*16.26*/("""
        """),format.raw/*17.19*/("""
    """),format.raw/*18.15*/("""
"""),format.raw/*19.1*/("""</div>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:42 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/group/GroupList_tab_AddDelUser.scala.html
                  HASH: fd42f751d49e1952df168cfc31ad610aedb63758
                  MATRIX: 1055->0|1365->283|1413->310|1510->426|1546->486|1587->661|1632->768|1673->794|1715->950|1761->1058|1802->1084|1844->1255|1885->1342|1926->1368|1963->1387|1996->1402|2024->1403
                  LINES: 33->1|35->3|35->3|38->6|39->7|40->8|41->9|42->10|43->11|44->12|45->13|46->14|47->15|48->16|49->17|50->18|51->19
                  -- GENERATED --
              */
          