
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
/*1.2*/import helper._
/*2.2*/import vn.m2m.common.models.User
/*3.2*/import vn.m2m.common.models.forms.SearchFilterForm
/*4.2*/import vn.m2m.utils.SearchUtil

object FilterHeaderTag extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[User,SearchFilterForm,List[String],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(currentUser:User,searchFilterForm:SearchFilterForm , searchFieldArray: List[String], actionForm:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*7.2*/import java.math.BigInteger; var iterator = 0;


Seq[Any](format.raw/*6.106*/("""
"""),format.raw/*8.1*/("""<div class="advanced-search" id="advanced-search-bar">
    <div class="card">
        <div class="card-header card-header-rose card-header-icon" style="background-color: #10375C;">
            <div class="row">
                <div class="col-md-6">
                    <h4 class="card-title">
                        <a style="color: white" id="aShowAdminFilter" href="javascript:void(0)" """),_display_(/*14.98*/if(!searchFieldArray.isEmpty)/*14.127*/{_display_(Seq[Any](format.raw/*14.128*/("""onclick="showAdminFilter()"""")))}),format.raw/*14.156*/(""">"""),_display_(/*14.158*/Messages("Admin.Filters",searchFilterForm.getTotalResult)),format.raw/*14.215*/("""</a>
                        <a style="color: white" id="aShowAdminFilter2" href="javascript:void(0)" """),_display_(/*15.99*/if(!searchFieldArray.isEmpty)/*15.128*/{_display_(Seq[Any](format.raw/*15.129*/("""onclick="showAdminFilter()"""")))}),format.raw/*15.157*/(""">"""),_display_(/*15.159*/Messages("Admin.expande")),format.raw/*15.184*/("""</a>
                    </h4>
                </div>
                <div class="col-md-6">
                    <div class="toolbar" id="advanced-search-filterToolbar" style="float: right;display: none">
                            <!--        Here you can write extra buttons/actions for the toolbar              -->
                        <a id="ApplyFilter" class="btn btn-rose text-white" onclick="ApplyFilter("""),_display_(/*21.99*/searchFilterForm/*21.115*/.getPage),format.raw/*21.123*/(""","""),_display_(/*21.125*/searchFilterForm/*21.141*/.getPageSize),format.raw/*21.153*/(""",true)">
                            <i class="fa fa-filter"></i> """),_display_(/*22.59*/Messages("Admin.Filters.apply")),format.raw/*22.90*/("""
                        """),format.raw/*23.25*/("""</a>
                    </div>
                </div>
            </div>



        </div>

        <div class="card-body">
            <div id="search-filter-body" style="display: none">
                <form action="""),_display_(/*34.31*/actionForm),format.raw/*34.41*/("""  """),format.raw/*34.43*/("""method="POST" id="search-filter-form"  class="form-horizontal">
                    """),format.raw/*35.39*/("""
                    """),format.raw/*36.21*/("""<div class="col-md-12 search-field-header">
                        <input name="page"  value=""""),_display_(/*37.53*/searchFilterForm/*37.69*/.getPage),format.raw/*37.77*/(""""  style="display: none">
                        <input name="pageSize"  value=""""),_display_(/*38.57*/searchFilterForm/*38.73*/.getPageSize),format.raw/*38.85*/(""""   style="display: none">
                        <input name="isResetPage"  value=""""),_display_(/*39.60*/searchFilterForm/*39.76*/.isResetPage),format.raw/*39.88*/(""""   style="display: none">
                        <input name="sortFieldName"  value=""""),_display_(/*40.62*/searchFilterForm/*40.78*/.getSortFieldName),format.raw/*40.95*/(""""   style="display: none">
                        <input name="isDesc"  value=""""),_display_(/*41.55*/searchFilterForm/*41.71*/.isDesc),format.raw/*41.78*/(""""   style="display: none">
                        <div class="col-md-0" >
                            <div style="display: none">
                                <select id="ChooseFilter" name="filter[]"  multiple data-title="Choose Filters" class="selectpicker" data-style="btn-info btn-fill btn-block" data-menu-style="dropdown-blue">
                                """),_display_(/*45.34*/for((item, index) <- searchFieldArray.zipWithIndex) yield /*45.85*/ {_display_(Seq[Any](format.raw/*45.87*/("""
                                    """),_display_(/*46.38*/if(index % 2 == 1)/*46.56*/ {_display_(Seq[Any](format.raw/*46.58*/("""
                                        """),format.raw/*47.41*/("""<option value=""""),_display_(/*47.57*/item),format.raw/*47.61*/("""">"""),_display_(/*47.64*/item),format.raw/*47.68*/("""</option>
                                    """)))}),format.raw/*48.38*/("""
                                """)))}),format.raw/*49.34*/("""
                                """),format.raw/*50.33*/("""</select>
                            </div>
                        </div>


                    </div>

                    """),_display_(/*57.22*/if(searchFilterForm.getConditionList.size() <2)/*57.69*/{_display_(Seq[Any](format.raw/*57.70*/("""
                        """),_display_(/*58.26*/for((item, index) <- searchFieldArray.zipWithIndex) yield /*58.77*/ {_display_(Seq[Any](format.raw/*58.79*/("""
                            """),_display_(/*59.30*/if(index % 2 == 0)/*59.48*/ {_display_(Seq[Any](format.raw/*59.50*/("""
                                """),_display_(/*60.34*/if(searchFieldArray(index).equals(SearchUtil.SEARCH_STRING_TYPE))/*60.99*/{_display_(Seq[Any](format.raw/*60.100*/("""
                                    """),_display_(/*61.38*/views/*61.43*/.html.filter.FilterConditionStringTag(currentUser,searchFieldArray(index+1), searchFieldArray(index+1), searchFilterForm.getConditionList.get(0), iterator)),format.raw/*61.198*/("""
                                    """),_display_(/*62.38*/{iterator+=1}),format.raw/*62.51*/("""
                                """)))}),format.raw/*63.34*/("""
                                """),_display_(/*64.34*/if(searchFieldArray(index).equals(SearchUtil.SEARCH_BOOLEAN_TYPE))/*64.100*/{_display_(Seq[Any](format.raw/*64.101*/("""
                                    """),_display_(/*65.38*/views/*65.43*/.html.filter.FilterConditionBooleanTag(currentUser,searchFieldArray(index+1), searchFieldArray(index+1), searchFilterForm.getConditionList.get(0), iterator)),format.raw/*65.199*/("""
                                    """),_display_(/*66.38*/{iterator+=1}),format.raw/*66.51*/("""
                                """)))}),format.raw/*67.34*/("""
                                """),_display_(/*68.34*/if(searchFieldArray(index).equals(SearchUtil.SEARCH_DATE_TYPE))/*68.97*/{_display_(Seq[Any](format.raw/*68.98*/("""
                                    """),_display_(/*69.38*/views/*69.43*/.html.filter.FilterConditionDatetimeTag(currentUser,searchFieldArray(index+1),searchFieldArray(index+1), searchFilterForm.getConditionList.get(0), searchFilterForm.getConditionList.get(0), iterator)),format.raw/*69.241*/("""
                                    """),_display_(/*70.38*/{iterator+=2}),format.raw/*70.51*/("""
                                """)))}),format.raw/*71.34*/("""
                                """),_display_(/*72.34*/if(searchFieldArray(index).equals(SearchUtil.SEARCH_INT_TYPE))/*72.96*/{_display_(Seq[Any](format.raw/*72.97*/("""
                                    """),_display_(/*73.38*/views/*73.43*/.html.filter.FilterConditionIntTag(currentUser,searchFieldArray(index+1),searchFieldArray(index+1), searchFilterForm.getConditionList.get(0), searchFilterForm.getConditionList.get(0), iterator)),format.raw/*73.236*/("""
                                    """),_display_(/*74.38*/{iterator+=2}),format.raw/*74.51*/("""
                                """)))}),format.raw/*75.34*/("""
                                """),_display_(/*76.34*/if(searchFieldArray(index).equals(SearchUtil.SEARCH_DOUBLE_TYPE))/*76.99*/{_display_(Seq[Any](format.raw/*76.100*/("""
                                    """),_display_(/*77.38*/views/*77.43*/.html.filter.FilterConditionDoubleTag(currentUser,searchFieldArray(index+1),searchFieldArray(index+1), searchFilterForm.getConditionList.get(0), searchFilterForm.getConditionList.get(0), iterator)),format.raw/*77.239*/("""
                                    """),_display_(/*78.38*/{iterator+=2}),format.raw/*78.51*/("""
                                """)))}),format.raw/*79.34*/("""
                            """)))}),format.raw/*80.30*/("""
                        """)))}),format.raw/*81.26*/("""
                    """)))}/*82.22*/else/*82.27*/{_display_(Seq[Any](format.raw/*82.28*/("""
                        """),_display_(/*83.26*/for((item, index) <- searchFieldArray.zipWithIndex) yield /*83.77*/ {_display_(Seq[Any](format.raw/*83.79*/("""
                            """),_display_(/*84.30*/if(index % 2 == 0)/*84.48*/ {_display_(Seq[Any](format.raw/*84.50*/("""
                                """),_display_(/*85.34*/if(searchFieldArray(index).equals(SearchUtil.SEARCH_STRING_TYPE))/*85.99*/{_display_(Seq[Any](format.raw/*85.100*/("""
                                    """),_display_(/*86.38*/views/*86.43*/.html.filter.FilterConditionStringTag(currentUser,searchFieldArray(index+1), searchFieldArray(index+1), searchFilterForm.getConditionList.get(iterator), iterator)),format.raw/*86.205*/("""
                                    """),_display_(/*87.38*/{iterator+=1}),format.raw/*87.51*/("""
                                """)))}),format.raw/*88.34*/("""
                                """),_display_(/*89.34*/if(searchFieldArray(index).equals(SearchUtil.SEARCH_BOOLEAN_TYPE))/*89.100*/{_display_(Seq[Any](format.raw/*89.101*/("""
                                    """),_display_(/*90.38*/views/*90.43*/.html.filter.FilterConditionBooleanTag(currentUser,searchFieldArray(index+1), searchFieldArray(index+1), searchFilterForm.getConditionList.get(iterator), iterator)),format.raw/*90.206*/("""
                                    """),_display_(/*91.38*/{iterator+=1}),format.raw/*91.51*/("""
                                """)))}),format.raw/*92.34*/("""
                                """),_display_(/*93.34*/if(searchFieldArray(index).equals(SearchUtil.SEARCH_DATE_TYPE))/*93.97*/{_display_(Seq[Any](format.raw/*93.98*/("""
                                    """),_display_(/*94.38*/views/*94.43*/.html.filter.FilterConditionDatetimeTag(currentUser,searchFieldArray(index+1),searchFieldArray(index+1), searchFilterForm.getConditionList.get(iterator), searchFilterForm.getConditionList.get(iterator+1), iterator)),format.raw/*94.257*/("""
                                    """),_display_(/*95.38*/{iterator+=2}),format.raw/*95.51*/("""
                                """)))}),format.raw/*96.34*/("""
                                """),_display_(/*97.34*/if(searchFieldArray(index).equals(SearchUtil.SEARCH_INT_TYPE))/*97.96*/{_display_(Seq[Any](format.raw/*97.97*/("""
                                    """),_display_(/*98.38*/views/*98.43*/.html.filter.FilterConditionIntTag(currentUser,searchFieldArray(index+1),searchFieldArray(index+1), searchFilterForm.getConditionList.get(iterator), searchFilterForm.getConditionList.get(iterator+1), iterator)),format.raw/*98.252*/("""
                                    """),_display_(/*99.38*/{iterator+=2}),format.raw/*99.51*/("""
                                """)))}),format.raw/*100.34*/("""
                                """),_display_(/*101.34*/if(searchFieldArray(index).equals(SearchUtil.SEARCH_DOUBLE_TYPE))/*101.99*/{_display_(Seq[Any](format.raw/*101.100*/("""
                                    """),_display_(/*102.38*/views/*102.43*/.html.filter.FilterConditionDoubleTag(currentUser,searchFieldArray(index+1),searchFieldArray(index+1), searchFilterForm.getConditionList.get(iterator), searchFilterForm.getConditionList.get(iterator+1), iterator)),format.raw/*102.255*/("""
                                    """),_display_(/*103.38*/{iterator+=2}),format.raw/*103.51*/("""
                                """)))}),format.raw/*104.34*/("""
                            """)))}),format.raw/*105.30*/("""
                        """)))}),format.raw/*106.26*/("""
                    """)))}),format.raw/*107.22*/("""
                    """),format.raw/*108.21*/("""<div class="search-field col-md-12" >
                        <div class="col-md-2 col-md-offset-9" >

                        </div>
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>
<div style="clear:both;"></div>



"""))
      }
    }
  }

  def render(currentUser:User,searchFilterForm:SearchFilterForm,searchFieldArray:List[String],actionForm:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,searchFilterForm,searchFieldArray,actionForm)

  def f:((User,SearchFilterForm,List[String],String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,searchFilterForm,searchFieldArray,actionForm) => apply(currentUser,searchFilterForm,searchFieldArray,actionForm)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:41 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/filter/FilterHeaderTag.scala.html
                  HASH: 5ff88a9ae5ea11c55d0c4ddf8923e9ba169da488
                  MATRIX: 658->1|681->18|721->52|779->104|1159->137|1336->243|1413->241|1440->290|1858->681|1897->710|1937->711|1997->739|2027->741|2106->798|2236->901|2275->930|2315->931|2375->959|2405->961|2452->986|2896->1403|2922->1419|2952->1427|2982->1429|3008->1445|3042->1457|3136->1524|3188->1555|3241->1580|3487->1799|3518->1809|3548->1811|3660->1913|3709->1934|3832->2030|3857->2046|3886->2054|3995->2136|4020->2152|4053->2164|4166->2250|4191->2266|4224->2278|4339->2366|4364->2382|4402->2399|4510->2480|4535->2496|4563->2503|4961->2874|5028->2925|5068->2927|5133->2965|5160->2983|5200->2985|5269->3026|5312->3042|5337->3046|5367->3049|5392->3053|5470->3100|5535->3134|5596->3167|5750->3294|5806->3341|5845->3342|5898->3368|5965->3419|6005->3421|6062->3451|6089->3469|6129->3471|6190->3505|6264->3570|6304->3571|6369->3609|6383->3614|6560->3769|6625->3807|6659->3820|6724->3854|6785->3888|6861->3954|6901->3955|6966->3993|6980->3998|7158->4154|7223->4192|7257->4205|7322->4239|7383->4273|7455->4336|7494->4337|7559->4375|7573->4380|7793->4578|7858->4616|7892->4629|7957->4663|8018->4697|8089->4759|8128->4760|8193->4798|8207->4803|8422->4996|8487->5034|8521->5047|8586->5081|8647->5115|8721->5180|8761->5181|8826->5219|8840->5224|9058->5420|9123->5458|9157->5471|9222->5505|9283->5535|9340->5561|9381->5583|9394->5588|9433->5589|9486->5615|9553->5666|9593->5668|9650->5698|9677->5716|9717->5718|9778->5752|9852->5817|9892->5818|9957->5856|9971->5861|10155->6023|10220->6061|10254->6074|10319->6108|10380->6142|10456->6208|10496->6209|10561->6247|10575->6252|10760->6415|10825->6453|10859->6466|10924->6500|10985->6534|11057->6597|11096->6598|11161->6636|11175->6641|11411->6855|11476->6893|11510->6906|11575->6940|11636->6974|11707->7036|11746->7037|11811->7075|11825->7080|12056->7289|12121->7327|12155->7340|12221->7374|12283->7408|12358->7473|12399->7474|12465->7512|12480->7517|12715->7729|12781->7767|12816->7780|12882->7814|12944->7844|13002->7870|13056->7892|13106->7913
                  LINES: 24->1|25->2|26->3|27->4|32->6|35->7|38->6|39->8|45->14|45->14|45->14|45->14|45->14|45->14|46->15|46->15|46->15|46->15|46->15|46->15|52->21|52->21|52->21|52->21|52->21|52->21|53->22|53->22|54->23|65->34|65->34|65->34|66->35|67->36|68->37|68->37|68->37|69->38|69->38|69->38|70->39|70->39|70->39|71->40|71->40|71->40|72->41|72->41|72->41|76->45|76->45|76->45|77->46|77->46|77->46|78->47|78->47|78->47|78->47|78->47|79->48|80->49|81->50|88->57|88->57|88->57|89->58|89->58|89->58|90->59|90->59|90->59|91->60|91->60|91->60|92->61|92->61|92->61|93->62|93->62|94->63|95->64|95->64|95->64|96->65|96->65|96->65|97->66|97->66|98->67|99->68|99->68|99->68|100->69|100->69|100->69|101->70|101->70|102->71|103->72|103->72|103->72|104->73|104->73|104->73|105->74|105->74|106->75|107->76|107->76|107->76|108->77|108->77|108->77|109->78|109->78|110->79|111->80|112->81|113->82|113->82|113->82|114->83|114->83|114->83|115->84|115->84|115->84|116->85|116->85|116->85|117->86|117->86|117->86|118->87|118->87|119->88|120->89|120->89|120->89|121->90|121->90|121->90|122->91|122->91|123->92|124->93|124->93|124->93|125->94|125->94|125->94|126->95|126->95|127->96|128->97|128->97|128->97|129->98|129->98|129->98|130->99|130->99|131->100|132->101|132->101|132->101|133->102|133->102|133->102|134->103|134->103|135->104|136->105|137->106|138->107|139->108
                  -- GENERATED --
              */
          