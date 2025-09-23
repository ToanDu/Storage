
package views.html.admin.registerDeveloper

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

object RegisterDeveloperList_del extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<form action=""""),_display_(/*1.16*/routes/*1.22*/.AdminRegisterDeveloperController.deleteRegisterDeveloper()),format.raw/*1.81*/("""" method="POST">
  <div class="modal fade" id="delConfirmModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content" id="theme16">
        <div class="modal-header">
          <h4 class="modal-title text-white">"""),_display_(/*6.47*/Messages("Xóa đăng kí")),format.raw/*6.70*/("""</h4>
        </div>
        <div class="modal-body">
          <h5 class="modal-body text-darker align-items-center" id="myModalbody">"""),_display_(/*9.83*/Messages("noti.confirmDeletebody")),format.raw/*9.117*/("""</h5>
          <div class="form-group" hidden>
            <input id="idDelete" name="id" class="form-control" readonly>
          </div>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger" >"""),_display_(/*15.58*/Messages("btnDelete")),format.raw/*15.79*/("""</button>
          <button type="button" class="btn btn-dark" data-bs-dismiss="modal">"""),_display_(/*16.79*/Messages("btnCancel")),format.raw/*16.100*/("""</button>
        </div>
      </div>
    </div>
  </div>
</form>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:40 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/admin/registerDeveloper/RegisterDeveloperList_del.scala.html
                  HASH: 3fb7bf8cafa523ec0ed3e3b6c683815f15ad7749
                  MATRIX: 1074->0|1115->15|1129->21|1208->80|1491->337|1534->360|1696->496|1751->530|2024->776|2066->797|2181->885|2224->906
                  LINES: 33->1|33->1|33->1|33->1|38->6|38->6|41->9|41->9|47->15|47->15|48->16|48->16
                  -- GENERATED --
              */
          