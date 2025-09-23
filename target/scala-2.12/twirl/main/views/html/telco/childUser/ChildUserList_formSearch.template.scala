
package views.html.telco.childUser

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

object ChildUserList_formSearch extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<div class="card">
  <div class="card-body">
    <span class="text-search">"""),_display_(/*5.32*/Messages("Thông tin tìm kiếm")),format.raw/*5.62*/("""</span>
    <input id="gpkd" type="text" class="form-control" readonly hidden>

    <div class="row mt-3">
      <div class="col-md-6 m-t-3">
        <div class="row m-b-4">
          <div class="col-sm-1"></div>
          <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*12.67*/Messages("Email")),format.raw/*12.84*/("""</label>
          <div class="col-sm-8">
            <input id="emailEnterpriseLv2" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="250" onkeypress="checkEnter(event)">
          </div>
        </div>
      </div>
    </div>
    <div class="d-flex flex-column align-items-center text-center">
      <div class="">
          <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;" data-bs-toggle="modal" data-bs-target="#addChildUserModal">"""),_display_(/*21.165*/Messages("Tạo mới")),format.raw/*21.184*/("""</button>
        """),format.raw/*22.166*/("""
        """),format.raw/*23.9*/("""<button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;" onclick="resetFormSearch()">"""),_display_(/*23.132*/Messages("Reset")),format.raw/*23.149*/("""</button>
        <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF;" onclick="onlickButtonSearchLv2()">"""),_display_(/*24.138*/Messages("Tra cứu")),format.raw/*24.157*/("""</button>
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
                  DATE: Mon Sep 22 16:32:52 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/childUser/ChildUserList_formSearch.scala.html
                  HASH: 832000923ea3b2a5601ca3472d09dbc02aee3379
                  MATRIX: 667->1|1021->35|1134->53|1161->54|1263->130|1313->160|1619->439|1657->456|2199->970|2240->989|2287->1164|2323->1173|2474->1296|2513->1313|2688->1460|2729->1479
                  LINES: 24->1|29->2|34->2|35->3|37->5|37->5|44->12|44->12|53->21|53->21|54->22|55->23|55->23|55->23|56->24|56->24
                  -- GENERATED --
              */
          