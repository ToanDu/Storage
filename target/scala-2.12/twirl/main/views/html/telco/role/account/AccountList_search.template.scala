
package views.html.telco.role.account

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

object AccountList_search extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<div class="card" id="formSearch">
  <div class="card-body">
    <span class="text-search">"""),_display_(/*5.32*/Messages("Thông tin tìm kiếm")),format.raw/*5.62*/("""</span>

    <div class="row mt-3">
      <div class="col-md-12">
        <div class="row">
          <div class="col-md-6 m-t-3">
            <div class="row m-b-4">
              <div class="col-sm-1"></div>
              <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*13.71*/Messages("Email")),format.raw/*13.88*/("""</label>
              <div class="col-sm-8 input-icons">
                <input id="email" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="50" required>
              </div>
            </div>
          </div>
          <div class="col-md-6 m-t-3">
            <div class="row m-b-4">
              <div class="col-sm-1"></div>
              <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*22.71*/Messages("Quyền tài khoản")),format.raw/*22.98*/("""</label>
              <div class="col-sm-8">
                <select id="roleCmp" type="text" class="form-select">
                  <option value="" selected>"""),_display_(/*25.46*/Messages("-- Chọn --")),format.raw/*25.68*/("""</option>
"""),format.raw/*26.84*/("""
                  """),_display_(/*27.20*/if(currentUser.getCmpRole == User.CmpRole.SUPER_ADMIN.getCode())/*27.84*/{_display_(Seq[Any](format.raw/*27.85*/("""
                    """),format.raw/*28.21*/("""<option value="ADMIN">"""),_display_(/*28.44*/Messages("Admin")),format.raw/*28.61*/("""</option>
                  """)))}),format.raw/*29.20*/("""
                  """),_display_(/*30.20*/if(currentUser.getCmpRole == User.CmpRole.SUPER_ADMIN.getCode() || currentUser.getCmpRole == User.CmpRole.ADMIN.getCode())/*30.142*/{_display_(Seq[Any](format.raw/*30.143*/("""
                    """),format.raw/*31.21*/("""<option value="SUPER_ENTERPRISE">"""),_display_(/*31.55*/Messages("Đại lý")),format.raw/*31.73*/("""</option>
                  """)))}),format.raw/*32.20*/("""
                  """),format.raw/*33.19*/("""<option value="ENTERPRISE">"""),_display_(/*33.47*/Messages("Doanh nghiệp")),format.raw/*33.71*/("""</option>
                  <option value="ENTERPRISE_LV2">"""),_display_(/*34.51*/Messages("Doanh nghiệp cấp 2")),format.raw/*34.81*/("""</option>
                  <option value="ENTERPRISE_VIEW">"""),_display_(/*35.52*/Messages("TK trải nghiệm")),format.raw/*35.78*/("""</option>
                </select>
              </div>
            </div>
          </div>
          """),format.raw/*40.43*/("""
            """),format.raw/*41.40*/("""
              """),format.raw/*42.47*/("""
              """),format.raw/*43.111*/("""
              """),format.raw/*44.53*/("""
                """),format.raw/*45.136*/("""
              """),format.raw/*46.25*/("""
            """),format.raw/*47.23*/("""
          """),format.raw/*48.21*/("""
          """),format.raw/*49.43*/("""
            """),format.raw/*50.40*/("""
              """),format.raw/*51.47*/("""
              """),format.raw/*52.99*/("""
              """),format.raw/*53.53*/("""
                """),format.raw/*54.134*/("""
              """),format.raw/*55.25*/("""
            """),format.raw/*56.23*/("""
          """),format.raw/*57.21*/("""
        """),format.raw/*58.9*/("""</div>
      </div>
    </div>
    <div class="d-flex flex-column align-items-center text-center">
      <div class="">
        """),_display_(/*63.10*/if(currentUser.getCmpRole == User.CmpRole.SUPER_ADMIN.getCode() || currentUser.getCmpRole == User.CmpRole.ADMIN.getCode())/*63.132*/{_display_(Seq[Any](format.raw/*63.133*/("""
          """),format.raw/*64.11*/("""<button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033; width: 180px;" onclick="addAccount()" data-bs-toggle="modal" data-bs-target="#addAccountModal">"""),_display_(/*64.200*/Messages("Thêm tài khoản")),format.raw/*64.226*/("""</button>
        """)))}),format.raw/*65.10*/("""
        """),format.raw/*66.9*/("""<button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033; width: 180px;" onclick="exportAccountList(1)">"""),_display_(/*66.149*/Messages("Export")),format.raw/*66.167*/("""</button>
        <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF; width: 180px;" onclick="onlickButtonSearch()">"""),_display_(/*67.149*/Messages("Tra cứu")),format.raw/*67.168*/("""</button>
      </div>
    </div>
  </div>
</div>"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/account/AccountList_search.scala.html
                  HASH: 173aed1a4433364893cdce0836cf7207cbbf12b5
                  MATRIX: 670->1|1018->35|1131->53|1158->54|1276->146|1326->176|1633->456|1671->473|2132->907|2180->934|2368->1095|2411->1117|2449->1210|2496->1230|2569->1294|2608->1295|2657->1316|2707->1339|2745->1356|2805->1385|2852->1405|2984->1527|3024->1528|3073->1549|3134->1583|3173->1601|3233->1630|3280->1649|3335->1677|3380->1701|3467->1761|3518->1791|3606->1852|3653->1878|3784->2013|3825->2053|3868->2100|3912->2211|3955->2264|4001->2400|4044->2425|4085->2448|4124->2469|4163->2512|4204->2552|4247->2599|4290->2698|4333->2751|4379->2885|4422->2910|4463->2933|4502->2954|4538->2963|4694->3092|4826->3214|4866->3215|4905->3226|5122->3415|5170->3441|5220->3460|5256->3469|5424->3609|5464->3627|5650->3785|5691->3804
                  LINES: 24->1|29->2|34->2|35->3|37->5|37->5|45->13|45->13|54->22|54->22|57->25|57->25|58->26|59->27|59->27|59->27|60->28|60->28|60->28|61->29|62->30|62->30|62->30|63->31|63->31|63->31|64->32|65->33|65->33|65->33|66->34|66->34|67->35|67->35|72->40|73->41|74->42|75->43|76->44|77->45|78->46|79->47|80->48|81->49|82->50|83->51|84->52|85->53|86->54|87->55|88->56|89->57|90->58|95->63|95->63|95->63|96->64|96->64|96->64|97->65|98->66|98->66|98->66|99->67|99->67
                  -- GENERATED --
              */
          