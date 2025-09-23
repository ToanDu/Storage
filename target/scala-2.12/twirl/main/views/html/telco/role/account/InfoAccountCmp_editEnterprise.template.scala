
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

object InfoAccountCmp_editEnterprise extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<div class="modal fade" id="editEnterpriseModal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display : none ;">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header" style="background-color: red; border-radius: 16px 16px 0px 0px;">
                <span class="modal-title text-white" id="myModalLabel">"""),_display_(/*7.73*/Messages("Sửa thông tin doanh nghiệp")),format.raw/*7.111*/("""</span>
            </div>
            <div class="modal-body">
                <div class="row mt-3">
                    <div class="row">
                        <input id="idEnterpriseEdit" type="text" class="form-control input-form" readonly hidden>

                        <div class="col-md-12">
                            <div class="row mt-3">
                                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*16.89*/Messages("Tên doanh nghiệp")),format.raw/*16.117*/("""</label>
                                <div class="col-sm-8">
                                    <input id="nameEnterpriseEdit" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="100">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="row mt-3">
                                <label class="col-sm-4 col-form-label title-section-2">"""),_display_(/*24.89*/Messages("GPKD")),format.raw/*24.105*/("""</label>
                                <div class="col-sm-8">
                                    <input id="gpkdEnterpriseEdit" type="text" class="form-control input-form" placeholder="Nhập nội dung" maxlength="50">
                                </div>
                            </div>
                        </div>

                    </div>
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*36.87*/Messages("btnCancle")),format.raw/*36.108*/("""</button>
                <button type="button" class="btn btn-red" onclick="processSubmitEditEnterprise()">"""),_display_(/*37.100*/Messages("btnComfirm")),format.raw/*37.122*/("""</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/account/InfoAccountCmp_editEnterprise.scala.html
                  HASH: d403743c950849fb7fb213dbc139be64cc0f1f49
                  MATRIX: 670->1|1029->35|1142->53|1169->54|1626->485|1685->523|2155->966|2205->994|2744->1506|2782->1522|3329->2042|3372->2063|3509->2172|3553->2194
                  LINES: 24->1|29->2|34->2|35->3|39->7|39->7|48->16|48->16|56->24|56->24|68->36|68->36|69->37|69->37
                  -- GENERATED --
              */
          