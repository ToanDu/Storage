
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

object FilterConditionBooleanTag extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[User,String,String,SearchConditionForm,Int,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*10.2*/(currentUser: User,divRoot:String,conditionName:String,condition: SearchConditionForm, i: Int):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*10.96*/("""
"""),format.raw/*11.1*/("""<div id=""""),_display_(/*11.11*/divRoot),format.raw/*11.18*/("""" class="search-field">
    <div class="row">
        <label class="col-sm-2 col-form-label">"""),_display_(/*13.49*/Messages("filter."+conditionName)),format.raw/*13.82*/("""</label>

        <div class="col-sm-6" >
            <div class="form-group">
                <input name="conditionList["""),_display_(/*17.45*/i),format.raw/*17.46*/("""].fieldName"  value=""""),_display_(/*17.68*/conditionName),format.raw/*17.81*/("""" class="form-control"  style="display: none">
                <input name="conditionList["""),_display_(/*18.45*/i),format.raw/*18.46*/("""].fieldType"  value="""),_display_(/*18.67*/SearchUtil/*18.77*/.SEARCH_BOOLEAN_TYPE),format.raw/*18.97*/(""" """),format.raw/*18.98*/("""class="form-control"  style="display:none">
                <input name="conditionList["""),_display_(/*19.45*/i),format.raw/*19.46*/("""].compQueryOp"  value="=" class="form-control"  style="display:none">
                <select class="selectpicker conditionBooleanValue" name="conditionList["""),_display_(/*20.89*/i),format.raw/*20.90*/("""].fieldValue" data-style="btn btn-primary" >
                    <option value="""),_display_(/*21.36*/SearchUtil/*21.46*/.SEARCH_BOOLEAN_TRUE_VALUE_STRING),format.raw/*21.79*/(""" """),_display_(/*21.81*/if(condition.getFieldValue.equals(SearchUtil.SEARCH_BOOLEAN_TRUE_VALUE_STRING) )/*21.161*/{_display_(Seq[Any](format.raw/*21.162*/("""selected""")))}),format.raw/*21.171*/(""" """),format.raw/*21.172*/(""">"""),_display_(/*21.174*/SearchUtil/*21.184*/.SEARCH_BOOLEAN_TRUE_VALUE_STRING),format.raw/*21.217*/("""</option>
                    <option value="""),_display_(/*22.36*/SearchUtil/*22.46*/.SEARCH_BOOLEAN_FALSE_VALUE_STRING),format.raw/*22.80*/("""  """),_display_(/*22.83*/if(condition.getFieldValue.equals(SearchUtil.SEARCH_BOOLEAN_FALSE_VALUE_STRING) || condition.getFieldValue == null)/*22.198*/{_display_(Seq[Any](format.raw/*22.199*/("""selected""")))}),format.raw/*22.208*/(""">"""),_display_(/*22.210*/SearchUtil/*22.220*/.SEARCH_BOOLEAN_FALSE_VALUE_STRING),format.raw/*22.254*/("""</option>
                    <option value="""),_display_(/*23.36*/SearchUtil/*23.46*/.SEARCH_ANY_OP_STRING),format.raw/*23.67*/("""  """),_display_(/*23.70*/if(condition.getFieldValue.equals(SearchUtil.SEARCH_ANY_OP_STRING) || condition.getFieldValue == null)/*23.172*/{_display_(Seq[Any](format.raw/*23.173*/("""selected""")))}),format.raw/*23.182*/(""">"""),_display_(/*23.184*/Messages("filter.any")),format.raw/*23.206*/("""</option>
                </select>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/filter/FilterConditionBooleanTag.scala.html
                  HASH: 479425aef9c20cab647ac5e05bdead5b2f56ae46
                  MATRIX: 658->1|681->18|711->42|740->65|780->99|841->154|879->186|915->216|1307->249|1497->343|1525->344|1562->354|1590->361|1711->455|1765->488|1915->611|1937->612|1986->634|2020->647|2138->738|2160->739|2208->760|2227->770|2268->790|2297->791|2412->879|2434->880|2619->1038|2641->1039|2748->1119|2767->1129|2821->1162|2850->1164|2940->1244|2980->1245|3021->1254|3051->1255|3081->1257|3101->1267|3156->1300|3228->1345|3247->1355|3302->1389|3332->1392|3457->1507|3497->1508|3538->1517|3568->1519|3588->1529|3644->1563|3716->1608|3735->1618|3777->1639|3807->1642|3919->1744|3959->1745|4000->1754|4030->1756|4074->1778
                  LINES: 24->1|25->2|26->3|27->4|28->5|29->6|30->7|31->8|36->10|41->10|42->11|42->11|42->11|44->13|44->13|48->17|48->17|48->17|48->17|49->18|49->18|49->18|49->18|49->18|49->18|50->19|50->19|51->20|51->20|52->21|52->21|52->21|52->21|52->21|52->21|52->21|52->21|52->21|52->21|52->21|53->22|53->22|53->22|53->22|53->22|53->22|53->22|53->22|53->22|53->22|54->23|54->23|54->23|54->23|54->23|54->23|54->23|54->23|54->23
                  -- GENERATED --
              */
          