
package views.html.iot.overview

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

object Overview_customerPay extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="col-md-12 mt-3">
  <div class="row mb-4">
    <div class="col-sm-9">
      <div class="breadcrumb-title pe-3 breadcrumbTitle" >"""),_display_(/*4.60*/Messages("overview.infoPay")),format.raw/*4.88*/("""</div>
    </div>
    <div class="col-sm-3">
      <div class="inner-addon left-addon">
        <input id="searchBilling" class="form-control inputSearch" type="text" placeholder="" maxlength="50">
        <i class="glyphicon bx bx-search"></i>
      </div>
    </div>
  </div>
</div>
<div class="row">
  <div class="col-md-3">
    <div class="card w-100">
      <div class="row g-0">
        <div class="card-header" style="background-color: #aaa;">
          <div class="">
            <p class="card-text align-items-center text-white" style="text-transform: uppercase;">Số thiết bị kết nối</p>
          </div>
        </div>
      </div>
      <div class="row g-0">
        <div class="col-md-12">
          <div class="card-body">
            <p class="card-text align-items-center" style="font-size: 32px; font-weight: bold;">0</p>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="col-md-3">
    <div class="card w-100">
      <div class="row g-0">
        <div class="card-header" style="background-color: #aaa;">
          <div class="">
            <p class="card-text align-items-center text-white" style="text-transform: uppercase;">Số lượt gọi API</p>
          </div>
        </div>
      </div>
      <div class="row g-0">
        <div class="col-md-12">
          <div class="card-body">
            <p class="card-text align-items-center" style="font-size: 32px; font-weight: bold;">0</p>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="col-md-3">
    <div class="card w-100">
      <div class="row g-0">
        <div class="card-header" style="background-color: #aaa;">
          <div class="">
            <p class="card-text align-items-center text-white" style="text-transform: uppercase;">Số bản tin đã sử dụng </p>
          </div>
        </div>
      </div>
      <div class="row g-0">
        <div class="col-md-12">
          <div class="card-body">
            <p class="card-text align-items-center" style="font-size: 32px; font-weight: bold;">0</p>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="col-md-3">
    <div class="card w-100">
      <div class="row g-0">
        <div class="card-header" style="background-color: #aaa;">
          <div class="">
            <p class="card-text align-items-center text-white" style="text-transform: uppercase;">Nợ cước tạm tính </p>
          </div>
        </div>
      </div>
      <div class="row g-0">
        <div class="col-md-12">
          <div class="card-body">
            <p class="card-text align-items-center" style="font-size: 32px; font-weight: bold;">0</p>
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
                  DATE: Mon Sep 22 16:32:45 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/overview/Overview_customerPay.scala.html
                  HASH: baabd1b17468c5f371b15b3ecf816a4c6806db61
                  MATRIX: 1058->0|1224->140|1272->168
                  LINES: 33->1|36->4|36->4
                  -- GENERATED --
              */
          