
package views.html.filter

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
/*1.2*/import vn.m2m.common.models.forms.SearchFilterForm

object FilterFooterTag extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[SearchFilterForm,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(searchFilterForm:SearchFilterForm ):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.38*/("""

"""),format.raw/*4.1*/("""<div class="material-datatables">
    <div class="dataTables_paginate paging_full_numbers">
        <div class="col-md-6 pull-left pagination-detail">
            """),format.raw/*7.54*/("""
            """),format.raw/*8.48*/("""
            """),format.raw/*9.48*/("""
                """),format.raw/*10.107*/("""
                    """),format.raw/*11.84*/("""
                    """),format.raw/*12.52*/("""
                """),format.raw/*13.30*/("""
                """),format.raw/*14.59*/("""
                    """),format.raw/*15.84*/("""
                    """),format.raw/*16.84*/("""
                    """),format.raw/*17.84*/("""
                    """),format.raw/*18.86*/("""
                    """),format.raw/*19.86*/("""
                """),format.raw/*20.26*/("""
            """),format.raw/*21.24*/("""

            """),format.raw/*23.108*/("""
        """),format.raw/*24.9*/("""</div>
        <ul class="pagination" style="float: right!important; margin: 0px 0;">
            """),_display_(/*26.14*/if(searchFilterForm.getPage >1)/*26.45*/{_display_(Seq[Any](format.raw/*26.46*/("""
                """),format.raw/*27.17*/("""<li class="paginate_button page-item "><a class="page-link" onclick="ApplyFilter(1,"""),_display_(/*27.101*/searchFilterForm/*27.117*/.getPageSize),format.raw/*27.129*/(""",false)"><<</a></li>
                <li class="paginate_button page-item "><a class="page-link" onclick="ApplyFilter("""),_display_(/*28.99*/(searchFilterForm.getPage-1)),format.raw/*28.127*/(""","""),_display_(/*28.129*/searchFilterForm/*28.145*/.getPageSize),format.raw/*28.157*/(""",false)"><</a></li>
            """)))}),format.raw/*29.14*/("""

            """),_display_(/*31.14*/for(item<-(1 to 2).reverse) yield /*31.41*/{_display_(Seq[Any](format.raw/*31.42*/("""
                """),_display_(/*32.18*/if( (searchFilterForm.getPage - item) >0)/*32.59*/{_display_(Seq[Any](format.raw/*32.60*/("""
                    """),format.raw/*33.21*/("""<li class="paginate_button page-item "><a class="page-link" onclick="ApplyFilter("""),_display_(/*33.103*/(searchFilterForm.getPage-item)),format.raw/*33.134*/(""","""),_display_(/*33.136*/searchFilterForm/*33.152*/.getPageSize),format.raw/*33.164*/(""",false)">"""),_display_(/*33.174*/(searchFilterForm.getPage-item)),format.raw/*33.205*/("""</a></li>
                """)))}),format.raw/*34.18*/("""
            """)))}),format.raw/*35.14*/("""

            """),format.raw/*37.13*/("""<li class="paginate_button page-item active"><a class="page-link" onclick="ApplyFilter("""),_display_(/*37.101*/searchFilterForm/*37.117*/.getPage),format.raw/*37.125*/(""","""),_display_(/*37.127*/searchFilterForm/*37.143*/.getPageSize),format.raw/*37.155*/(""",false)">"""),_display_(/*37.165*/(searchFilterForm.getPage)),format.raw/*37.191*/("""</a></li>

            """),_display_(/*39.14*/for(item<-1 to 2) yield /*39.31*/{_display_(Seq[Any](format.raw/*39.32*/("""
                """),_display_(/*40.18*/if((searchFilterForm.getPage + item) <= searchFilterForm.getTotalPage)/*40.88*/ {_display_(Seq[Any](format.raw/*40.90*/("""
                    """),format.raw/*41.21*/("""<li class="paginate_button page-item "><a class="page-link" onclick="ApplyFilter("""),_display_(/*41.103*/(searchFilterForm.getPage + item)),format.raw/*41.136*/(""","""),_display_(/*41.138*/searchFilterForm/*41.154*/.getPageSize),format.raw/*41.166*/(""",false)">"""),_display_(/*41.176*/(searchFilterForm.getPage + item)),format.raw/*41.209*/("""</a></li>
                """)))}),format.raw/*42.18*/("""
            """)))}),format.raw/*43.14*/("""
            """),_display_(/*44.14*/if(searchFilterForm.getPage < searchFilterForm.getTotalPage)/*44.74*/ {_display_(Seq[Any](format.raw/*44.76*/("""
                """),format.raw/*45.17*/("""<li class="paginate_button page-item "><a class="page-link" onclick="ApplyFilter("""),_display_(/*45.99*/(searchFilterForm.getPage + 1)),format.raw/*45.129*/(""", """),_display_(/*45.132*/searchFilterForm/*45.148*/.getPageSize),format.raw/*45.160*/(""",false)">></a></li>
                <li class="paginate_button page-item "><a class="page-link" onclick="ApplyFilter( """),_display_(/*46.100*/(searchFilterForm.getTotalPage)),format.raw/*46.131*/(""","""),_display_(/*46.133*/searchFilterForm/*46.149*/.getPageSize),format.raw/*46.161*/(""",false)">>></a></li>
            """)))}),format.raw/*47.14*/("""
        """),format.raw/*48.9*/("""</ul>
    </div>
</div>



"""))
      }
    }
  }

  def render(searchFilterForm:SearchFilterForm): play.twirl.api.HtmlFormat.Appendable = apply(searchFilterForm)

  def f:((SearchFilterForm) => play.twirl.api.HtmlFormat.Appendable) = (searchFilterForm) => apply(searchFilterForm)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:41 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/filter/FilterFooterTag.scala.html
                  HASH: 4c82684405e9502023473d71264b1c1ada58d692
                  MATRIX: 658->1|1033->53|1164->89|1192->91|1382->295|1422->343|1462->391|1508->498|1557->582|1606->634|1651->664|1696->723|1745->807|1794->891|1843->975|1892->1061|1941->1147|1986->1173|2027->1197|2070->1306|2106->1315|2232->1414|2272->1445|2311->1446|2356->1463|2468->1547|2494->1563|2528->1575|2674->1694|2724->1722|2754->1724|2780->1740|2814->1752|2878->1785|2920->1800|2963->1827|3002->1828|3047->1846|3097->1887|3136->1888|3185->1909|3295->1991|3348->2022|3378->2024|3404->2040|3438->2052|3476->2062|3529->2093|3587->2120|3632->2134|3674->2148|3790->2236|3816->2252|3846->2260|3876->2262|3902->2278|3936->2290|3974->2300|4022->2326|4073->2350|4106->2367|4145->2368|4190->2386|4269->2456|4309->2458|4358->2479|4468->2561|4523->2594|4553->2596|4579->2612|4613->2624|4651->2634|4706->2667|4764->2694|4809->2708|4850->2722|4919->2782|4959->2784|5004->2801|5113->2883|5165->2913|5196->2916|5222->2932|5256->2944|5403->3063|5456->3094|5486->3096|5512->3112|5546->3124|5611->3158|5647->3167
                  LINES: 24->1|29->2|34->2|36->4|39->7|40->8|41->9|42->10|43->11|44->12|45->13|46->14|47->15|48->16|49->17|50->18|51->19|52->20|53->21|55->23|56->24|58->26|58->26|58->26|59->27|59->27|59->27|59->27|60->28|60->28|60->28|60->28|60->28|61->29|63->31|63->31|63->31|64->32|64->32|64->32|65->33|65->33|65->33|65->33|65->33|65->33|65->33|65->33|66->34|67->35|69->37|69->37|69->37|69->37|69->37|69->37|69->37|69->37|69->37|71->39|71->39|71->39|72->40|72->40|72->40|73->41|73->41|73->41|73->41|73->41|73->41|73->41|73->41|74->42|75->43|76->44|76->44|76->44|77->45|77->45|77->45|77->45|77->45|77->45|78->46|78->46|78->46|78->46|78->46|79->47|80->48
                  -- GENERATED --
              */
          