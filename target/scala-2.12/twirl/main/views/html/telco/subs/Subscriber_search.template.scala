
package views.html.telco.subs

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

object Subscriber_search extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div id="searchModal" class="modal fixed-left fade" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-dialog-aside" role="document">
    <div class="modal-content bg-gradient-burning">
      <div class="modal-header">
  <h5 class="modal-title text-white" id="exampleModalLabel">"""),_display_(/*5.62*/Messages("subscriber.modal.advanced.title")),format.raw/*5.105*/("""</h5>
      </div>
      <div class="modal-body">
  <p class="mb-0 text-white mt-3">"""),_display_(/*8.36*/Messages("subscriber.modal.advanced.phoneNumber")),format.raw/*8.85*/("""</p>
        <input type="text" class="form-control" id="">

  <p class="mb-0 text-white mt-3">"""),_display_(/*11.36*/Messages("subscriber.modal.advanced.serial")),format.raw/*11.80*/("""</p>
        <input type="text" class="form-control" id="">

  <p class="mb-0 text-white mt-3">"""),_display_(/*14.36*/Messages("subscriber.modal.advanced.activationDate")),format.raw/*14.88*/("""</p>
        <input type="text" class="form-control" id="">

  <p class="mb-0 text-white mt-3">"""),_display_(/*17.36*/Messages("subscriber.modal.advanced.activityStatus")),format.raw/*17.88*/("""</p>
        <select class="form-select" id="">
          <option selected="" >"""),_display_(/*19.33*/Messages("subscriber.modal.advanced.all")),format.raw/*19.74*/("""</option>
          <option value="" >"""),_display_(/*20.30*/Messages("subscriber.modal.advanced.active")),format.raw/*20.74*/("""</option>
          <option value="" >"""),_display_(/*21.30*/Messages("subscriber.modal.advanced.block1")),format.raw/*21.74*/("""</option>
          <option value="" >"""),_display_(/*22.30*/Messages("subscriber.modal.advanced.block2")),format.raw/*22.74*/("""</option>
          <option value="" >"""),_display_(/*23.30*/Messages("subscriber.modal.advanced.debt")),format.raw/*23.72*/("""</option>
        </select>

      </div>
      <div class="modal-footer">
        <button type="button" onclick="" class="btn btn-light" data-bs-dismiss="modal">"""),_display_(/*28.89*/Messages("btnCancle")),format.raw/*28.110*/("""</button>
        <button type="button" onclick="" class="btn btn-light">"""),_display_(/*29.65*/Messages("btnComfirm")),format.raw/*29.87*/("""</button>
      </div>
    </div>
  </div> <!-- modal-bialog .// -->
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
                  DATE: Mon Sep 22 16:32:55 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/subs/Subscriber_search.scala.html
                  HASH: b63141ff6c61a804aa0d0cf8634dc9d1261d4313
                  MATRIX: 1053->0|1370->291|1434->334|1545->419|1614->468|1737->564|1802->608|1925->704|1998->756|2121->852|2194->904|2301->984|2363->1025|2429->1064|2494->1108|2560->1147|2625->1191|2691->1230|2756->1274|2822->1313|2885->1355|3075->1518|3118->1539|3219->1613|3262->1635
                  LINES: 33->1|37->5|37->5|40->8|40->8|43->11|43->11|46->14|46->14|49->17|49->17|51->19|51->19|52->20|52->20|53->21|53->21|54->22|54->22|55->23|55->23|60->28|60->28|61->29|61->29
                  -- GENERATED --
              */
          