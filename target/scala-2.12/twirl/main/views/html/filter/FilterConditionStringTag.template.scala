
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
/*10.2*/import org.springframework.util.StringUtils

object FilterConditionStringTag extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[User,String,String,SearchConditionForm,Int,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*11.2*/(currentUser: User,divRoot:String,conditionName:String,condition: SearchConditionForm, i: Int):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*11.96*/("""
"""),format.raw/*12.1*/("""<div id=""""),_display_(/*12.11*/divRoot),format.raw/*12.18*/("""" class="search-field">
    <div class="row">
        <label class="col-sm-2 col-form-label">"""),_display_(/*14.49*/Messages("filter."+conditionName)),format.raw/*14.82*/("""</label>
        <div class="col-sm-2 advancedSearchFrom" style="display: none">
            <select class="selectpicker conditionOptionValue" id="conditionOptionValue-"""),_display_(/*16.89*/conditionName),format.raw/*16.102*/("""" name="conditionList["""),_display_(/*16.125*/i),format.raw/*16.126*/("""].compQueryOp" data-style="btn btn-primary" >
                <option value="""),_display_(/*17.32*/SearchUtil/*17.42*/.SEARCH_EQUAL_OP_STRING),format.raw/*17.65*/(""" """),_display_(/*17.67*/if(condition.getCompQueryOp.equals(SearchUtil.SEARCH_EQUAL_OP_STRING))/*17.137*/ {_display_(Seq[Any](format.raw/*17.139*/("""selected""")))}),format.raw/*17.148*/(""" """),format.raw/*17.149*/(""">"""),_display_(/*17.151*/SearchUtil/*17.161*/.SEARCH_EQUAL_OP_STRING),format.raw/*17.184*/("""</option>
                <option value="""),_display_(/*18.32*/SearchUtil/*18.42*/.SEARCH_NOT_EQUAL_OP_STRING),format.raw/*18.69*/("""  """),_display_(/*18.72*/if(condition.getCompQueryOp.equals(SearchUtil.SEARCH_NOT_EQUAL_OP_STRING))/*18.146*/ {_display_(Seq[Any](format.raw/*18.148*/("""selected""")))}),format.raw/*18.157*/(""">"""),_display_(/*18.159*/SearchUtil/*18.169*/.SEARCH_NOT_EQUAL_OP_STRING),format.raw/*18.196*/("""</option>
            </select>
        </div>
        <div class="col-sm-6" >
            <div class="form-group">
                <input name="conditionList["""),_display_(/*23.45*/i),format.raw/*23.46*/("""].fieldName"  value=""""),_display_(/*23.68*/conditionName),format.raw/*23.81*/("""" class="form-control" style="display: none">
                <input name="conditionList["""),_display_(/*24.45*/i),format.raw/*24.46*/("""].fieldType"  value='"""),_display_(/*24.68*/SearchUtil/*24.78*/.SEARCH_STRING_TYPE),format.raw/*24.97*/("""' class="form-control"  style="display:none">
                <input name="conditionList["""),_display_(/*25.45*/i),format.raw/*25.46*/("""].fieldValue" class="conditionTextValue form-control"  placeholder="" value=""""),_display_(/*25.124*/condition/*25.133*/.getFieldValue),format.raw/*25.147*/("""">
            </div>
        </div>

    </div>
</div>
"""))
      }
    }
  }

  def render(currentUser:User,divRoot:String,conditionName:String,condition:SearchConditionForm,i:Int): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,divRoot,conditionName,condition,i)

  def f:((User,String,String,SearchConditionForm,Int) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,divRoot,conditionName,condition,i) => apply(currentUser,divRoot,conditionName,condition,i)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:41 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/filter/FilterConditionStringTag.scala.html
                  HASH: 07cf76301591c00c912cfd29920eacdd8d83c86f
                  MATRIX: 658->1|681->18|711->42|740->65|780->99|841->154|879->186|915->216|954->249|1358->294|1548->388|1576->389|1613->399|1641->406|1762->500|1816->533|2012->702|2047->715|2098->738|2121->739|2225->816|2244->826|2288->849|2317->851|2397->921|2438->923|2479->932|2509->933|2539->935|2559->945|2604->968|2672->1009|2691->1019|2739->1046|2769->1049|2853->1123|2894->1125|2935->1134|2965->1136|2985->1146|3034->1173|3221->1333|3243->1334|3292->1356|3326->1369|3443->1459|3465->1460|3514->1482|3533->1492|3573->1511|3690->1601|3712->1602|3818->1680|3837->1689|3873->1703
                  LINES: 24->1|25->2|26->3|27->4|28->5|29->6|30->7|31->8|32->10|37->11|42->11|43->12|43->12|43->12|45->14|45->14|47->16|47->16|47->16|47->16|48->17|48->17|48->17|48->17|48->17|48->17|48->17|48->17|48->17|48->17|48->17|49->18|49->18|49->18|49->18|49->18|49->18|49->18|49->18|49->18|49->18|54->23|54->23|54->23|54->23|55->24|55->24|55->24|55->24|55->24|56->25|56->25|56->25|56->25|56->25
                  -- GENERATED --
              */
          