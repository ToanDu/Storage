
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

object FilterConditionDoubleTag extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[User,String,String,SearchConditionForm,SearchConditionForm,Int,play.twirl.api.HtmlFormat.Appendable] {

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
            <input name="conditionList["""),_display_(/*16.41*/i),format.raw/*16.42*/("""].fieldType"  value='"""),_display_(/*16.64*/SearchUtil/*16.74*/.SEARCH_DOUBLE_TYPE),format.raw/*16.93*/("""' class="form-control"  style="display: none">

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
                <input name="conditionList["""),_display_(/*28.45*/i),format.raw/*28.46*/("""].fieldValue" class="conditionDoubleValue form-control"  placeholder="123..."  value=""""),_display_(/*28.133*/conditionStart/*28.147*/.getFieldValue),format.raw/*28.161*/("""">
            </div>
        </div>
        <div class="col-sm-3" id="rightBetween-"""),_display_(/*31.49*/conditionName),format.raw/*31.62*/("""" """),_display_(/*31.65*/if(!conditionStart.getCompQueryOp.equals(SearchUtil.SEARCH_BETWEEN_OP_STRING))/*31.143*/{_display_(Seq[Any](format.raw/*31.144*/("""style="display: none"""")))}),format.raw/*31.166*/(""">
            <div class="form-group">
                <input name="conditionList["""),_display_(/*33.45*/(i+1)),format.raw/*33.50*/("""].fieldName"  value=""""),_display_(/*33.72*/conditionName),format.raw/*33.85*/("""" class="form-control"  style="display: none">
                <input name="conditionList["""),_display_(/*34.45*/(i+1)),format.raw/*34.50*/("""].compQueryOp"  value="""),_display_(/*34.73*/SearchUtil/*34.83*/.SEARCH_LTE_OP_STRING),format.raw/*34.104*/(""" """),format.raw/*34.105*/("""class="form-control"  style="display: none">
                <input name="conditionList["""),_display_(/*35.45*/(i+1)),format.raw/*35.50*/("""].fieldType"  value="""),_display_(/*35.71*/SearchUtil/*35.81*/.SEARCH_DOUBLE_TYPE),format.raw/*35.100*/(""" """),format.raw/*35.101*/("""class="form-control" style="display: none">
                <input name="conditionList["""),_display_(/*36.45*/(i+1)),format.raw/*36.50*/("""].fieldValue" class="conditionDoubleValue form-control"  placeholder="123..." value=""""),_display_(/*36.136*/conditionEnd/*36.148*/.getFieldValue),format.raw/*36.162*/("""">
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/filter/FilterConditionDoubleTag.scala.html
                  HASH: c83ee23106233be82fb9f9a49aab141da08cfa4b
                  MATRIX: 658->1|681->18|711->42|740->65|780->99|841->154|879->186|915->216|1325->248|1554->381|1583->383|1620->393|1648->400|1769->494|1823->527|1971->648|1993->649|2042->671|2076->684|2190->771|2212->772|2261->794|2280->804|2320->823|2483->959|2518->972|2569->995|2592->996|2696->1073|2715->1083|2759->1106|2788->1108|2873->1183|2913->1184|2954->1193|2984->1194|3014->1196|3034->1206|3079->1229|3147->1270|3166->1280|3214->1307|3244->1310|3333->1389|3373->1390|3414->1399|3444->1400|3474->1402|3494->1412|3543->1439|3611->1480|3630->1490|3672->1511|3702->1514|3785->1587|3825->1588|3866->1597|3896->1598|3926->1600|3946->1610|3989->1631|4057->1672|4076->1682|4118->1703|4148->1706|4231->1779|4271->1780|4312->1789|4342->1790|4372->1792|4392->1802|4435->1823|4503->1864|4522->1874|4568->1899|4598->1902|4685->1979|4725->1980|4766->1989|4796->1990|4826->1992|4846->2002|4893->2027|5080->2187|5102->2188|5217->2275|5241->2289|5277->2303|5389->2388|5423->2401|5453->2404|5541->2482|5581->2483|5635->2505|5745->2588|5771->2593|5820->2615|5854->2628|5972->2719|5998->2724|6048->2747|6067->2757|6110->2778|6140->2779|6256->2868|6282->2873|6330->2894|6349->2904|6390->2923|6420->2924|6535->3012|6561->3017|6675->3103|6697->3115|6733->3129
                  LINES: 24->1|25->2|26->3|27->4|28->5|29->6|30->7|31->8|36->9|41->9|43->11|43->11|43->11|45->13|45->13|47->15|47->15|47->15|47->15|48->16|48->16|48->16|48->16|48->16|50->18|50->18|50->18|50->18|51->19|51->19|51->19|51->19|51->19|51->19|51->19|51->19|51->19|51->19|51->19|52->20|52->20|52->20|52->20|52->20|52->20|52->20|52->20|52->20|52->20|52->20|53->21|53->21|53->21|53->21|53->21|53->21|53->21|53->21|53->21|53->21|53->21|54->22|54->22|54->22|54->22|54->22|54->22|54->22|54->22|54->22|54->22|54->22|55->23|55->23|55->23|55->23|55->23|55->23|55->23|55->23|55->23|55->23|55->23|60->28|60->28|60->28|60->28|60->28|63->31|63->31|63->31|63->31|63->31|63->31|65->33|65->33|65->33|65->33|66->34|66->34|66->34|66->34|66->34|66->34|67->35|67->35|67->35|67->35|67->35|67->35|68->36|68->36|68->36|68->36|68->36
                  -- GENERATED --
              */
          