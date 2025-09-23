
package views.html.telco.blockUtilities

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

object Utilities_miAddOn_register_comfirm extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="comfirmRegisterMiAddonModal" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h6 class="modal-title">"""),_display_(/*5.34*/Messages("Đăng ký gói MI, Add-on")),format.raw/*5.68*/("""</h6>
      </div>
      <div class="modal-body text-darker">
        <h6 id="textComfirmRegisterMiAddon">"""),_display_(/*8.46*/Messages("Bạn có chắc chắn muốn thực hiện đăng kí gói MI, Add-on?")),format.raw/*8.113*/("""</h6>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-red" data-bs-dismiss="modal" onclick="processRegisterMiAddon(0)">"""),_display_(/*11.112*/Messages("btnComfirm")),format.raw/*11.134*/("""</button>
        <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*12.79*/Messages("btnCancel")),format.raw/*12.100*/("""</button>
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
                  DATE: Mon Sep 22 16:32:51 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/blockUtilities/Utilities_miAddOn_register_comfirm.scala.html
                  HASH: 69493b2d83d8b2b45eadb7195abdbba3fcbb0b21
                  MATRIX: 1080->0|1337->231|1391->265|1524->372|1612->439|1803->602|1847->624|1962->712|2005->733
                  LINES: 33->1|37->5|37->5|40->8|40->8|43->11|43->11|44->12|44->12
                  -- GENERATED --
              */
          