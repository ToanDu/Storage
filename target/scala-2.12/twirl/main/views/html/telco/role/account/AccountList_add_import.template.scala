
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

object AccountList_add_import extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="importAddEnterpriseModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <span class="modal-title" id="exampleModalLabel">"""),_display_(/*5.59*/Messages("Import danh sách doanh nghiệp")),format.raw/*5.100*/("""</span>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-12">
            <div class="row mb-3">
              <span class="col-sm-4 col-form-label" style="text-align: right;">"""),_display_(/*11.81*/Messages("Tải danh sách doanh nghiệp")),format.raw/*11.119*/("""</span>
              <div class="col-sm-4">
                <input class="form-control input-form" type="text" id="nameFilesAddEnterprise" readonly/>
                <input type="file" id="filesAddEnterprise" name="files" style="background-color: #aaa; width: 100%;" hidden/>
              </div>
              <label class="col-sm-4 col-form-label title-section-2" style="text-align: left; cursor: pointer; color: #EA0033;" onclick="importFileAddEnterprise()">
                <i class="bx bx-upload"></i> """),_display_(/*17.47*/Messages("Import danh sách")),format.raw/*17.75*/("""
              """),format.raw/*18.15*/("""</label>
            </div>
            <div class="row mb-3" id="tableAddEnterprise" style="padding: 15px;">
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-cancle" onclick="cancleImportAddEnterprise()">"""),_display_(/*24.99*/Messages("btnCancle")),format.raw/*24.120*/("""</button>
              <button type="button" class="btn btn-red" onclick="comfirmImportAddEnterprise()">"""),_display_(/*25.97*/Messages("btnComfirm")),format.raw/*25.119*/("""</button>
            </div>
          </div>
        </div>
      </div>

    </div>
  </div>
</div>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/account/AccountList_add_import.scala.html
                  HASH: ef88c1b1921d2a66d916b4ead7fef0aa6d915bb7
                  MATRIX: 1066->0|1459->367|1521->408|1775->635|1835->673|2371->1182|2420->1210|2463->1225|2757->1492|2800->1513|2933->1619|2977->1641
                  LINES: 33->1|37->5|37->5|43->11|43->11|49->17|49->17|50->18|56->24|56->24|57->25|57->25
                  -- GENERATED --
              */
          