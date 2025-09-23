
package views.html.iot.attribute.group

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

object AttributeGroup_del extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="deleteAttributeConfirm" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="theme16">
      <div class="modal-header">
        <h4 class="modal-title text-white">"""),_display_(/*5.45*/Messages("manage.org.attr.del")),format.raw/*5.76*/("""</h4>
      </div>
      <div class="modal-body">
        <h5 class="modal-body text-darker align-items-center" id="myModalbody">"""),_display_(/*8.81*/Messages("noti.confirmDeletebody")),format.raw/*8.115*/("""</h5>
        <div class="form-group" hidden>
          <input id="attributeKeyDel" class="form-control">
          <input id="attributeTypeDel" class="form-control">
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal" onclick="delAttributeOfOrg()">"""),_display_(/*15.109*/Messages("btnDelete")),format.raw/*15.130*/("""</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">"""),_display_(/*16.82*/Messages("btnCancel")),format.raw/*16.103*/("""</button>
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
                  DATE: Mon Sep 22 16:32:42 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/attribute/group/AttributeGroup_del.scala.html
                  HASH: f17013e1570b14192051eb3c2d6d5b7ec5c19606
                  MATRIX: 1063->0|1326->237|1377->268|1533->398|1588->432|1952->768|1995->789|2113->880|2156->901
                  LINES: 33->1|37->5|37->5|40->8|40->8|47->15|47->15|48->16|48->16
                  -- GENERATED --
              */
          