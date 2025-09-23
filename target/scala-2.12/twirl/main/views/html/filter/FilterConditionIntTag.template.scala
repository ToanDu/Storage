
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

object FilterConditionIntTag extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[User,String,String,SearchConditionForm,SearchConditionForm,Int,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*9.2*/(currentUser: User,divRoot:String,conditionName:String,conditionStart: SearchConditionForm, conditionEnd: SearchConditionForm,i: Int):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*9.135*/("""

"""),format.raw/*11.1*/("""<div id=""""),_display_(/*11.11*/divRoot),format.raw/*11.18*/("""" class="search-field">
    <div class="row">
        <label class="col-sm-2 col-form-label">"""),_display_(/*13.49*/Messages("filter."+conditionName)),format.raw/*13.82*/("""</label>
        <div class="col-sm-2 advancedSearchFrom" style="display: none">
            <input name="conditionList["""),_display_(/*15.41*/i),format.raw/*15.42*/("""].fieldName"  value=""""),_display_(/*15.64*/conditionName),format.raw/*15.77*/("""" class="form-control"  style="display: none">
            <input name="conditionList["""),_display_(/*16.41*/i),format.raw/*16.42*/("""].fieldType"  value='"""),_display_(/*16.64*/SearchUtil/*16.74*/.SEARCH_INT_TYPE),format.raw/*16.90*/("""' class="form-control"  style="display: none">

            <select class="selectpicker conditionOptionValue" id="conditionOptionValue-"""),_display_(/*18.89*/conditionName),format.raw/*18.102*/("""" name="conditionList["""),_display_(/*18.125*/i),format.raw/*18.126*/("""].compQueryOp" data-style="btn btn-primary" >
                <option value="""),_display_(/*19.32*/SearchUtil/*19.42*/.SEARCH_EQUAL_OP_STRING),format.raw/*19.65*/(""" """),_display_(/*19.67*/if(conditionStart.getCompQueryOp.equals(SearchUtil.SEARCH_EQUAL_OP_STRING))/*19.142*/{_display_(Seq[Any](format.raw/*19.143*/("""selected""")))}),format.raw/*19.152*/(""" """),format.raw/*19.153*/(""">"""),_display_(/*19.155*/SearchUtil/*19.165*/.SEARCH_EQUAL_OP_STRING),format.raw/*19.188*/("""</option>
                <option value="""),_display_(/*20.32*/SearchUtil/*20.42*/.SEARCH_NOT_EQUAL_OP_STRING),format.raw/*20.69*/("""  """),_display_(/*20.72*/if(conditionStart.getCompQueryOp.equals(SearchUtil.SEARCH_NOT_EQUAL_OP_STRING))/*20.151*/{_display_(Seq[Any](format.raw/*20.152*/("""selected""")))}),format.raw/*20.161*/(""" """),format.raw/*20.162*/(""">"""),_display_(/*20.164*/SearchUtil/*20.174*/.SEARCH_NOT_EQUAL_OP_STRING),format.raw/*20.201*/("""</option>
                <option value="""),_display_(/*21.32*/SearchUtil/*21.42*/.SEARCH_LTE_OP_STRING),format.raw/*21.63*/("""  """),_display_(/*21.66*/if(conditionStart.getCompQueryOp.equals(SearchUtil.SEARCH_LTE_OP_STRING))/*21.139*/{_display_(Seq[Any](format.raw/*21.140*/("""selected""")))}),format.raw/*21.149*/(""" """),format.raw/*21.150*/(""">"""),_display_(/*21.152*/SearchUtil/*21.162*/.SEARCH_LTE_OP_STRING),format.raw/*21.183*/("""</option>
                <option value="""),_display_(/*22.32*/SearchUtil/*22.42*/.SEARCH_GTE_OP_STRING),format.raw/*22.63*/("""  """),_display_(/*22.66*/if(conditionStart.getCompQueryOp.equals(SearchUtil.SEARCH_GTE_OP_STRING))/*22.139*/{_display_(Seq[Any](format.raw/*22.140*/("""selected""")))}),format.raw/*22.149*/(""" """),format.raw/*22.150*/(""">"""),_display_(/*22.152*/SearchUtil/*22.162*/.SEARCH_GTE_OP_STRING),format.raw/*22.183*/("""</option>
                <option value="""),_display_(/*23.32*/SearchUtil/*23.42*/.SEARCH_BETWEEN_OP_STRING),format.raw/*23.67*/("""  """),_display_(/*23.70*/if(conditionStart.getCompQueryOp.equals(SearchUtil.SEARCH_BETWEEN_OP_STRING))/*23.147*/{_display_(Seq[Any](format.raw/*23.148*/("""selected""")))}),format.raw/*23.157*/(""" """),format.raw/*23.158*/(""">"""),_display_(/*23.160*/SearchUtil/*23.170*/.SEARCH_BETWEEN_OP_STRING),format.raw/*23.195*/("""</option>
            </select>
        </div>
        <div class="col-sm-3" >
            <div class="form-group">
                <input name="conditionList["""),_display_(/*28.45*/i),format.raw/*28.46*/("""].fieldValue" class="conditionIntValue form-control" type="number" placeholder="123..."  value=""""),_display_(/*28.143*/conditionStart/*28.157*/.getFieldValue),format.raw/*28.171*/("""">
            </div>
        </div>
        <div class="col-sm-3" id="rightBetween-"""),_display_(/*31.49*/conditionName),format.raw/*31.62*/("""" """),_display_(/*31.65*/if(!conditionStart.getCompQueryOp.equals(SearchUtil.SEARCH_BETWEEN_OP_STRING))/*31.143*/{_display_(Seq[Any](format.raw/*31.144*/("""style="display: none"""")))}),format.raw/*31.166*/(""">
            <div class="form-group">
                <input name="conditionList["""),_display_(/*33.45*/(i+1)),format.raw/*33.50*/("""].fieldName"  value=""""),_display_(/*33.72*/conditionName),format.raw/*33.85*/("""" class="form-control"  style="display: none">
                <input name="conditionList["""),_display_(/*34.45*/(i+1)),format.raw/*34.50*/("""].compQueryOp"  value="<=" class="form-control"  style="display: none">
                <input name="conditionList["""),_display_(/*35.45*/(i+1)),format.raw/*35.50*/("""].fieldType"  value="Int" class="form-control" style="display: none">
                <input name="conditionList["""),_display_(/*36.45*/(i+1)),format.raw/*36.50*/("""].fieldValue" class="conditionIntValue form-control" type="number" placeholder="123..." value=""""),_display_(/*36.146*/conditionEnd/*36.158*/.getFieldValue),format.raw/*36.172*/("""">
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/filter/FilterConditionIntTag.scala.html
                  HASH: cc22596d6c434b72ab97cb8f7ddb0365787f9231
                  MATRIX: 658->1|681->18|711->42|740->65|780->99|841->154|879->186|915->216|1322->248|1551->381|1580->383|1617->393|1645->400|1766->494|1820->527|1968->648|1990->649|2039->671|2073->684|2187->771|2209->772|2258->794|2277->804|2314->820|2477->956|2512->969|2563->992|2586->993|2690->1070|2709->1080|2753->1103|2782->1105|2867->1180|2907->1181|2948->1190|2978->1191|3008->1193|3028->1203|3073->1226|3141->1267|3160->1277|3208->1304|3238->1307|3327->1386|3367->1387|3408->1396|3438->1397|3468->1399|3488->1409|3537->1436|3605->1477|3624->1487|3666->1508|3696->1511|3779->1584|3819->1585|3860->1594|3890->1595|3920->1597|3940->1607|3983->1628|4051->1669|4070->1679|4112->1700|4142->1703|4225->1776|4265->1777|4306->1786|4336->1787|4366->1789|4386->1799|4429->1820|4497->1861|4516->1871|4562->1896|4592->1899|4679->1976|4719->1977|4760->1986|4790->1987|4820->1989|4840->1999|4887->2024|5074->2184|5096->2185|5221->2282|5245->2296|5281->2310|5393->2395|5427->2408|5457->2411|5545->2489|5585->2490|5639->2512|5749->2595|5775->2600|5824->2622|5858->2635|5976->2726|6002->2731|6145->2847|6171->2852|6312->2966|6338->2971|6462->3067|6484->3079|6520->3093
                  LINES: 24->1|25->2|26->3|27->4|28->5|29->6|30->7|31->8|36->9|41->9|43->11|43->11|43->11|45->13|45->13|47->15|47->15|47->15|47->15|48->16|48->16|48->16|48->16|48->16|50->18|50->18|50->18|50->18|51->19|51->19|51->19|51->19|51->19|51->19|51->19|51->19|51->19|51->19|51->19|52->20|52->20|52->20|52->20|52->20|52->20|52->20|52->20|52->20|52->20|52->20|53->21|53->21|53->21|53->21|53->21|53->21|53->21|53->21|53->21|53->21|53->21|54->22|54->22|54->22|54->22|54->22|54->22|54->22|54->22|54->22|54->22|54->22|55->23|55->23|55->23|55->23|55->23|55->23|55->23|55->23|55->23|55->23|55->23|60->28|60->28|60->28|60->28|60->28|63->31|63->31|63->31|63->31|63->31|63->31|65->33|65->33|65->33|65->33|66->34|66->34|67->35|67->35|68->36|68->36|68->36|68->36|68->36
                  -- GENERATED --
              */
          