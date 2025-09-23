
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

object InfoAccountCmp_addEnterprise extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<div class="modal fade" id="addEnterpriseModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
        <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*7.65*/Messages("Thêm thông tin doanh nghiệp")),format.raw/*7.104*/("""</span>
      </div>
      <div class="modal-body">
        <div class="row mt-3">
          <div class="row">
            <div class="col-md-12">
              <div class="row mt-3">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*14.73*/Messages("Tên doanh nghiệp")),format.raw/*14.101*/("""</label>
                <div class="col-sm-8">
                  <input id="nameEnterpriseAdd" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="100">
                </div>
              </div>
            </div>
            <div class="col-md-12">
              <div class="row mt-3">
                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*22.73*/Messages("GPKD")),format.raw/*22.89*/("""</label>
                <div class="col-sm-8">
                  <input id="gpkdEnterpriseAdd" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="50">
                </div>
              </div>
            </div>

          </div>
        </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-cancle" onclick="clearDataAddEnterpriseByAdmin()" data-bs-dismiss="modal">"""),_display_(/*34.121*/Messages("btnCancle")),format.raw/*34.142*/("""</button>
        """),_display_(/*35.10*/if(currentUser.getCmpRole == User.CmpRole.SUPER_ADMIN.getCode())/*35.74*/{_display_(Seq[Any](format.raw/*35.75*/("""
          """),format.raw/*36.11*/("""<button type="button" class="btn btn-red" onclick="processSubmitAddEnterpriseBySAdmin()">"""),_display_(/*36.101*/Messages("btnComfirm")),format.raw/*36.123*/("""</button>
        """)))}/*37.11*/else/*37.16*/{_display_(Seq[Any](format.raw/*37.17*/("""
          """),format.raw/*38.11*/("""<button type="button" class="btn btn-red" onclick="processSubmitAddEnpByAdminOrSEnterprise()">"""),_display_(/*38.106*/Messages("btnComfirm")),format.raw/*38.128*/("""</button>
        """)))}),format.raw/*39.10*/("""
      """),format.raw/*40.7*/("""</div>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/account/InfoAccountCmp_addEnterprise.scala.html
                  HASH: a8cf07fce7d5554054a5e1a094f642f654da487c
                  MATRIX: 670->1|1028->35|1141->53|1168->54|1604->464|1664->503|1947->759|1997->787|2417->1180|2454->1196|2929->1643|2972->1664|3018->1683|3091->1747|3130->1748|3169->1759|3287->1849|3331->1871|3369->1891|3382->1896|3421->1897|3460->1908|3583->2003|3627->2025|3677->2044|3711->2051
                  LINES: 24->1|29->2|34->2|35->3|39->7|39->7|46->14|46->14|54->22|54->22|66->34|66->34|67->35|67->35|67->35|68->36|68->36|68->36|69->37|69->37|69->37|70->38|70->38|70->38|71->39|72->40
                  -- GENERATED --
              */
          