
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
/*2.2*/import play.mvc.Http._
/*3.2*/import play.data.Form
/*4.2*/import vn.m2m.common.models.User
/*5.2*/import vn.m2m.common.models.forms.SearchConditionForm
/*6.2*/import vn.m2m.utils.StaticData
/*7.2*/import vn.m2m.utils.DateUtil
/*8.2*/import vn.m2m.utils.SearchUtil

object FilterConditionDatetimeTag extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[User,String,String,SearchConditionForm,SearchConditionForm,Int,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*9.2*/(currentUser: User,divRoot:String,conditionName:String,conditionStart: SearchConditionForm, conditionEnd: SearchConditionForm,i: Int):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*9.135*/("""

"""),format.raw/*11.1*/("""<div id=""""),_display_(/*11.11*/divRoot),format.raw/*11.18*/("""" class="search-field">

    <div class="row">

        <label class="col-sm-2 col-form-label">"""),_display_(/*15.49*/Messages("filter."+conditionName)),format.raw/*15.82*/("""</label>

        <div class="col-sm-2" style="display: none" >
            <input name="conditionList["""),_display_(/*18.41*/i),format.raw/*18.42*/("""].fieldName"  value=""""),_display_(/*18.64*/conditionName),format.raw/*18.77*/("""" class="form-control"  style="display: none">
            <input name="conditionList["""),_display_(/*19.41*/i),format.raw/*19.42*/("""].fieldType"  value="""),_display_(/*19.63*/SearchUtil/*19.73*/.SEARCH_DATE_TYPE),format.raw/*19.90*/(""" """),format.raw/*19.91*/("""class="form-control"  style="display: none">
            <select name="conditionList["""),_display_(/*20.42*/i),format.raw/*20.43*/("""].compQueryOp"   class="DateOption selectpicker conditionDateOptionValue" data-style="form-control" data-menu-style="">
                <option value="""),_display_(/*21.32*/SearchUtil/*21.42*/.SEARCH_EQUAL_OP_STRING),format.raw/*21.65*/(""" """),_display_(/*21.67*/if(conditionStart.getCompQueryOp.equals(SearchUtil.SEARCH_EQUAL_OP_STRING))/*21.142*/{_display_(Seq[Any](format.raw/*21.143*/("""selected""")))}),format.raw/*21.152*/(""" """),format.raw/*21.153*/(""">"""),_display_(/*21.155*/SearchUtil/*21.165*/.SEARCH_EQUAL_OP_STRING),format.raw/*21.188*/("""</option>
                <option value="""),_display_(/*22.32*/SearchUtil/*22.42*/.SEARCH_NOT_EQUAL_OP_STRING),format.raw/*22.69*/("""  """),_display_(/*22.72*/if(conditionStart.getCompQueryOp.equals(SearchUtil.SEARCH_NOT_EQUAL_OP_STRING))/*22.151*/{_display_(Seq[Any](format.raw/*22.152*/("""selected""")))}),format.raw/*22.161*/(""" """),format.raw/*22.162*/(""">"""),_display_(/*22.164*/SearchUtil/*22.174*/.SEARCH_NOT_EQUAL_OP_STRING),format.raw/*22.201*/("""</option>
                <option value="""),_display_(/*23.32*/SearchUtil/*23.42*/.SEARCH_LTE_OP_STRING),format.raw/*23.63*/("""  """),_display_(/*23.66*/if(conditionStart.getCompQueryOp.equals(SearchUtil.SEARCH_LTE_OP_STRING))/*23.139*/{_display_(Seq[Any](format.raw/*23.140*/("""selected""")))}),format.raw/*23.149*/(""" """),format.raw/*23.150*/(""">"""),_display_(/*23.152*/SearchUtil/*23.162*/.SEARCH_LTE_OP_STRING),format.raw/*23.183*/("""</option>
                <option value="""),_display_(/*24.32*/SearchUtil/*24.42*/.SEARCH_GTE_OP_STRING),format.raw/*24.63*/("""  """),_display_(/*24.66*/if(conditionStart.getCompQueryOp.equals(SearchUtil.SEARCH_GTE_OP_STRING))/*24.139*/{_display_(Seq[Any](format.raw/*24.140*/("""selected""")))}),format.raw/*24.149*/(""" """),format.raw/*24.150*/(""">"""),_display_(/*24.152*/SearchUtil/*24.162*/.SEARCH_GTE_OP_STRING),format.raw/*24.183*/("""</option>
                <option value="""),_display_(/*25.32*/SearchUtil/*25.42*/.SEARCH_BETWEEN_OP_STRING),format.raw/*25.67*/("""  """),_display_(/*25.70*/if(conditionStart.getCompQueryOp.equals(SearchUtil.SEARCH_BETWEEN_OP_STRING))/*25.147*/{_display_(Seq[Any](format.raw/*25.148*/("""selected""")))}),format.raw/*25.157*/(""" """),format.raw/*25.158*/(""">"""),_display_(/*25.160*/SearchUtil/*25.170*/.SEARCH_BETWEEN_OP_STRING),format.raw/*25.195*/("""</option>
            </select>
        </div>

        <div class="col-sm-3" >
            <div class="form-group">
                <input id="dateFrom"""),_display_(/*31.37*/conditionName),format.raw/*31.50*/("""" name="conditionList["""),_display_(/*31.73*/i),format.raw/*31.74*/("""].fieldValue" class="form-control datetimepicker" type="text" autocomplete="off" """),_display_(/*31.156*/if(conditionStart.getFieldValue !=null &&conditionStart.getFieldValue.length >0)/*31.236*/{_display_(Seq[Any](format.raw/*31.237*/("""value='"""),_display_(/*31.245*/conditionStart/*31.259*/.getFieldValue),format.raw/*31.273*/("""'""")))}/*31.275*/else/*31.279*/{_display_(Seq[Any](format.raw/*31.280*/(""" """),format.raw/*31.281*/("""value=''""")))}),format.raw/*31.290*/("""/>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="form-group">
                <input name="conditionList["""),_display_(/*36.45*/(i+1)),format.raw/*36.50*/("""].fieldName"  value=""""),_display_(/*36.72*/conditionName),format.raw/*36.85*/("""" class="form-control"  style="display: none">
                <input name="conditionList["""),_display_(/*37.45*/(i+1)),format.raw/*37.50*/("""].compQueryOp"  value="""),_display_(/*37.73*/SearchUtil/*37.83*/.SEARCH_LTE_OP_STRING),format.raw/*37.104*/(""" """),format.raw/*37.105*/("""class="form-control"  style="display: none">
                <input name="conditionList["""),_display_(/*38.45*/(i+1)),format.raw/*38.50*/("""].fieldType"  value="""),_display_(/*38.71*/SearchUtil/*38.81*/.SEARCH_DATE_TYPE),format.raw/*38.98*/(""" """),format.raw/*38.99*/("""class="form-control"  style="display: none">
                <input id="dateTo"""),_display_(/*39.35*/conditionName),format.raw/*39.48*/("""" name="conditionList["""),_display_(/*39.71*/(i+1)),format.raw/*39.76*/("""].fieldValue" class="form-control datetimepicker" type="text" autocomplete="off" """),_display_(/*39.158*/if(conditionEnd.getFieldValue !=null&&conditionEnd.getFieldValue.length >0)/*39.233*/{_display_(Seq[Any](format.raw/*39.234*/("""value='"""),_display_(/*39.242*/conditionEnd/*39.254*/.getFieldValue),format.raw/*39.268*/("""'""")))}/*39.270*/else/*39.274*/{_display_(Seq[Any](format.raw/*39.275*/(""" """),format.raw/*39.276*/("""value=''""")))}),format.raw/*39.285*/("""/>
            </div>
        </div>

    </div>
</div>"""))
      }
    }
  }

  def render(currentUser:User,divRoot:String,conditionName:String,conditionStart:SearchConditionForm,conditionEnd:SearchConditionForm,i:Int): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,divRoot,conditionName,conditionStart,conditionEnd,i)

  def f:((User,String,String,SearchConditionForm,SearchConditionForm,Int) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,divRoot,conditionName,conditionStart,conditionEnd,i) => apply(currentUser,divRoot,conditionName,conditionStart,conditionEnd,i)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:41 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/filter/FilterConditionDatetimeTag.scala.html
                  HASH: 8a6dbfd20607b7eafb5fafe1e956f50d40a51bb9
                  MATRIX: 658->1|681->18|711->42|740->65|780->99|841->154|879->186|915->216|1327->248|1556->381|1585->383|1622->393|1650->400|1773->496|1827->529|1958->633|1980->634|2029->656|2063->669|2177->756|2199->757|2247->778|2266->788|2304->805|2333->806|2446->892|2468->893|2646->1044|2665->1054|2709->1077|2738->1079|2823->1154|2863->1155|2904->1164|2934->1165|2964->1167|2984->1177|3029->1200|3097->1241|3116->1251|3164->1278|3194->1281|3283->1360|3323->1361|3364->1370|3394->1371|3424->1373|3444->1383|3493->1410|3561->1451|3580->1461|3622->1482|3652->1485|3735->1558|3775->1559|3816->1568|3846->1569|3876->1571|3896->1581|3939->1602|4007->1643|4026->1653|4068->1674|4098->1677|4181->1750|4221->1751|4262->1760|4292->1761|4322->1763|4342->1773|4385->1794|4453->1835|4472->1845|4518->1870|4548->1873|4635->1950|4675->1951|4716->1960|4746->1961|4776->1963|4796->1973|4843->1998|5023->2151|5057->2164|5107->2187|5129->2188|5239->2270|5329->2350|5369->2351|5405->2359|5429->2373|5465->2387|5487->2389|5501->2393|5541->2394|5571->2395|5612->2404|5788->2553|5814->2558|5863->2580|5897->2593|6015->2684|6041->2689|6091->2712|6110->2722|6153->2743|6183->2744|6299->2833|6325->2838|6373->2859|6392->2869|6430->2886|6459->2887|6565->2966|6599->2979|6649->3002|6675->3007|6785->3089|6870->3164|6910->3165|6946->3173|6968->3185|7004->3199|7026->3201|7040->3205|7080->3206|7110->3207|7151->3216
                  LINES: 24->1|25->2|26->3|27->4|28->5|29->6|30->7|31->8|36->9|41->9|43->11|43->11|43->11|47->15|47->15|50->18|50->18|50->18|50->18|51->19|51->19|51->19|51->19|51->19|51->19|52->20|52->20|53->21|53->21|53->21|53->21|53->21|53->21|53->21|53->21|53->21|53->21|53->21|54->22|54->22|54->22|54->22|54->22|54->22|54->22|54->22|54->22|54->22|54->22|55->23|55->23|55->23|55->23|55->23|55->23|55->23|55->23|55->23|55->23|55->23|56->24|56->24|56->24|56->24|56->24|56->24|56->24|56->24|56->24|56->24|56->24|57->25|57->25|57->25|57->25|57->25|57->25|57->25|57->25|57->25|57->25|57->25|63->31|63->31|63->31|63->31|63->31|63->31|63->31|63->31|63->31|63->31|63->31|63->31|63->31|63->31|63->31|68->36|68->36|68->36|68->36|69->37|69->37|69->37|69->37|69->37|69->37|70->38|70->38|70->38|70->38|70->38|70->38|71->39|71->39|71->39|71->39|71->39|71->39|71->39|71->39|71->39|71->39|71->39|71->39|71->39|71->39|71->39
                  -- GENERATED --
              */
          