
package views.html.telco.admin

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

object ApprovedInfoCompany_search extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

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
                <input id="email" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="50">
              </div>
            </div>
          </div>
          <div class="col-md-6 m-t-3">
            <div class="row m-b-4">
              <div class="col-sm-1"></div>
              <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*22.71*/Messages("Số điện thoại")),format.raw/*22.96*/("""</label>
              <div class="col-sm-8 input-icons">
                <input id="phone" type="text" class="form-control input-form" placeholder="Nhập nội dung" onkeypress="return isNumberKey(event)" maxlength="11">
              </div>
            </div>
          </div>
          <div class="col-md-6 m-t-3">
            <div class="row m-b-4">
              <div class="col-sm-1"></div>
              <label class="col-sm-3 col-form-label title-section-2" hidden>"""),_display_(/*31.78*/Messages("Tên doanh nghiệp")),format.raw/*31.106*/("""</label>
              <div class="col-sm-8 input-icons">
                <input id="name" type="text" class="form-control input-form " placeholder="Nhập nội dung" maxlength="100" required hidden>
              </div>
            </div>
          </div>
          <div class="col-md-6 m-t-3">
            <div class="row m-b-4">
              <div class="col-sm-1"></div>
              <label class="col-sm-3 col-form-label title-section-2" hidden>"""),_display_(/*40.78*/Messages("GPKD")),format.raw/*40.94*/("""</label>
              <div class="col-sm-8 input-icons">
                <input id="businessLicense" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="50" required hidden>
              </div>
            </div>
          </div>
          <div class="col-md-6 m-t-3">
            <div class="row m-b-4">
              <div class="col-sm-1"></div>
              <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*49.71*/Messages("Quyền tài khoản")),format.raw/*49.98*/("""</label>
              <div class="col-sm-8">
                <select id="role_cmp" type="text" class="form-select">
                  <option value="" selected>"""),_display_(/*52.46*/Messages("-- Chọn --")),format.raw/*52.68*/("""</option>
                  """),_display_(/*53.20*/if(currentUser.getCmpRole == User.CmpRole.SUPER_ADMIN.getCode())/*53.84*/{_display_(Seq[Any](format.raw/*53.85*/("""
                    """),format.raw/*54.21*/("""<option value="ADMIN">"""),_display_(/*54.44*/Messages("Admin")),format.raw/*54.61*/("""</option>
                  """)))}),format.raw/*55.20*/("""
                  """),format.raw/*56.19*/("""<option value="SUPER_ENTERPRISE">"""),_display_(/*56.53*/Messages("Đại lý")),format.raw/*56.71*/("""</option>
                  <option value="ENTERPRISE">"""),_display_(/*57.47*/Messages("Doanh nghiệp")),format.raw/*57.71*/("""</option>
                  <option value="ENTERPRISE_VIEW">"""),_display_(/*58.52*/Messages("TK trải nghiệm")),format.raw/*58.78*/("""</option>
                  <option value="NONE">"""),_display_(/*59.41*/Messages("Không xác định")),format.raw/*59.67*/("""</option>
                </select>
              </div>
            </div>
          </div>
          <div class="col-md-6 m-t-3">
            <div class="row m-b-4">
              <div class="col-sm-1"></div>
              <label class="col-sm-3 col-form-label title-section-2">"""),_display_(/*67.71*/Messages("Trạng thái")),format.raw/*67.93*/("""</label>
              <div class="col-sm-8">
                <select id="status" type="text" class="form-select">
                  <option value="" selected>"""),_display_(/*70.46*/Messages("-- Chọn --")),format.raw/*70.68*/("""</option>
                  <option value="APPROVED">"""),_display_(/*71.45*/Messages("APPROVED")),format.raw/*71.65*/("""</option>
                  <option value="SUBMITTED">"""),_display_(/*72.46*/Messages("SUBMITTED")),format.raw/*72.67*/("""</option>
                  <option value="REJECTED">"""),_display_(/*73.45*/Messages("REJECTED")),format.raw/*73.65*/("""</option>
                </select>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="d-flex flex-column align-items-center text-center">
      <div class="">
        <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033; width: 180px;" onclick="resetFormSearch()">"""),_display_(/*83.146*/Messages("Reset")),format.raw/*83.163*/("""</button>
        <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF; width: 180px;" onclick="onlickButtonSearch()">"""),_display_(/*84.149*/Messages("Tra cứu")),format.raw/*84.168*/("""</button>
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
                  DATE: Mon Sep 22 16:32:50 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/admin/ApprovedInfoCompany_search.scala.html
                  HASH: b0fad0bac69556781c7df279e7b7dbb59a914b18
                  MATRIX: 663->1|1019->35|1132->53|1159->54|1277->146|1327->176|1634->456|1672->473|2124->898|2170->923|2668->1394|2718->1422|3194->1871|3231->1887|3709->2338|3757->2365|3946->2527|3989->2549|4045->2578|4118->2642|4157->2643|4206->2664|4256->2687|4294->2704|4354->2733|4401->2752|4462->2786|4501->2804|4584->2860|4629->2884|4717->2945|4764->2971|4841->3021|4888->3047|5196->3328|5239->3350|5426->3510|5469->3532|5550->3586|5591->3606|5673->3661|5715->3682|5796->3736|5837->3756|6231->4122|6270->4139|6456->4297|6497->4316
                  LINES: 24->1|29->2|34->2|35->3|37->5|37->5|45->13|45->13|54->22|54->22|63->31|63->31|72->40|72->40|81->49|81->49|84->52|84->52|85->53|85->53|85->53|86->54|86->54|86->54|87->55|88->56|88->56|88->56|89->57|89->57|90->58|90->58|91->59|91->59|99->67|99->67|102->70|102->70|103->71|103->71|104->72|104->72|105->73|105->73|115->83|115->83|116->84|116->84
                  -- GENERATED --
              */
          