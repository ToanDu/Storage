
package views.html.telco.account

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

object Account_delEnterprise extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="delEnterpriseModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block; ">
        <h5 class="modal-title" id="myModalLabel">"""),_display_(/*5.52*/Messages("account.confirmDeleteEnterprise")),format.raw/*5.95*/("""</h5>
      </div>
      <div class="modal-body">
        <div class="row">
          <input type="text" class="form-control" id="idEnterpriseDel" readonly hidden>
          <input type="number" class="form-control" id="sttEnterpriseDel" readonly hidden>

          <div class="col-12 mt-3">
            <label class="form-label">"""),_display_(/*13.40*/Messages("account.enterprise")),format.raw/*13.70*/("""</label>
            <input type="text" class="form-control" id="nameEnterpriseDel" readonly>
          </div>
          <div class="col-12 mt-3">
            <label class="form-label">"""),_display_(/*17.40*/Messages("account.businessLicenseNumber")),format.raw/*17.81*/("""</label>
            <input type="text" class="form-control" id="gpkdEnterpriseDel" readonly>
          </div>

        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" onclick="processRemoveInfoEnterprise()">"""),_display_(/*24.95*/Messages("common.confirm")),format.raw/*24.121*/("""</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*25.82*/Messages("common.close")),format.raw/*25.106*/("""</button>
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
                  DATE: Mon Sep 22 16:32:50 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/account/Account_delEnterprise.scala.html
                  HASH: 3a6db6956eec75c57f4fed7d91f693a88f355dcf
                  MATRIX: 1060->0|1433->347|1496->390|1854->721|1905->751|2118->937|2180->978|2474->1245|2522->1271|2640->1362|2686->1386
                  LINES: 33->1|37->5|37->5|45->13|45->13|49->17|49->17|56->24|56->24|57->25|57->25
                  -- GENERATED --
              */
          