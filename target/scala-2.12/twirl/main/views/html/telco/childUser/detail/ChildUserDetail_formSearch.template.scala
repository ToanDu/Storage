
package views.html.telco.childUser.detail

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
/*1.2*/import vn.m2m.common.models.User

object ChildUserDetail_formSearch extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User, email:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.34*/("""
"""),format.raw/*3.1*/("""<div class="card">
  <div class="card-body">
    <span class="text-search">"""),_display_(/*5.32*/Messages("TK doanh nghiệp cấp 2: ")),_display_(/*5.68*/email),format.raw/*5.73*/("""</span>
    <input id="gpkd" type="text" class="form-control" readonly hidden>

    <div class="row mt-3">
      <div class="col-md-6 m-t-3">
        <div class="row m-b-4">
          <div class="col-sm-1"></div>
          <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*12.67*/Messages("Số thuê bao")),format.raw/*12.90*/("""</label>
          <div class="col-sm-8">
            <input id="isdn" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="250" oninput="validateNumberInput(this)">
          </div>
        </div>
      </div>
      <div class="col-md-6 m-t-3">
        <div class="row m-b-4">
          <div class="col-sm-1"></div>
          <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*21.67*/Messages("GPKD")),format.raw/*21.83*/("""</label>
          <div class="col-sm-8">
            <input id="idNo" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="250">
          </div>
        </div>
      </div>
    </div>
    <div class="d-flex flex-column align-items-center text-center">
      <div class="">
        <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;" data-bs-toggle="modal" data-bs-target="#importSubsModal">"""),_display_(/*30.161*/Messages("Import")),format.raw/*30.179*/("""</button>
        """),format.raw/*31.166*/("""
        """),format.raw/*32.9*/("""<button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="resetFormSearch()">"""),_display_(/*32.132*/Messages("Reset")),format.raw/*32.149*/("""</button>
        <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF;" onclick="onlickButtonSearch()">"""),_display_(/*33.135*/Messages("Tra cứu")),format.raw/*33.154*/("""</button>
      </div>
    </div>
  </div>
</div>
<script>
        function validateNumberInput(inputElement) """),format.raw/*39.52*/("""{"""),format.raw/*39.53*/("""
          """),format.raw/*40.11*/("""var inputValue = inputElement.value;

          var numericValue = inputValue.replace(/[^0-9]/g, '');

          if (inputValue !== numericValue) """),format.raw/*44.44*/("""{"""),format.raw/*44.45*/("""
            """),format.raw/*45.13*/("""inputElement.value = numericValue;
          """),format.raw/*46.11*/("""}"""),format.raw/*46.12*/("""
        """),format.raw/*47.9*/("""}"""),format.raw/*47.10*/("""
"""),format.raw/*48.1*/("""</script>"""))
      }
    }
  }

  def render(currentUser:User,email:String): play.twirl.api.HtmlFormat.Appendable = apply(currentUser,email)

  def f:((User,String) => play.twirl.api.HtmlFormat.Appendable) = (currentUser,email) => apply(currentUser,email)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:52 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/childUser/detail/ChildUserDetail_formSearch.scala.html
                  HASH: cdc7cfe51b68627d9ce01fe9e63318b440a8b6e8
                  MATRIX: 674->1|1037->35|1164->67|1191->68|1293->144|1348->180|1373->185|1679->464|1723->487|2163->900|2200->916|2693->1381|2733->1399|2780->1574|2816->1583|2967->1706|3006->1723|3178->1867|3219->1886|3357->1996|3386->1997|3425->2008|3599->2154|3628->2155|3669->2168|3742->2213|3771->2214|3807->2223|3836->2224|3864->2225
                  LINES: 24->1|29->2|34->2|35->3|37->5|37->5|37->5|44->12|44->12|53->21|53->21|62->30|62->30|63->31|64->32|64->32|64->32|65->33|65->33|71->39|71->39|72->40|76->44|76->44|77->45|78->46|78->46|79->47|79->47|80->48
                  -- GENERATED --
              */
          