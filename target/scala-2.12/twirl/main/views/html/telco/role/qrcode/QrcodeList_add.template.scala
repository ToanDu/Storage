
package views.html.telco.role.qrcode

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

object QrcodeList_add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="addQrcodeModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content" id="theme16">
      <div class="modal-header" style="text-align: center; display: block">
        <span class="modal-title" id="exampleModalLabel">"""),_display_(/*5.59*/Messages("Thông tin đấu nối - gói cước")),format.raw/*5.99*/("""</span>
        <a class="close cursor-pointer" data-bs-dismiss="modal" aria-hidden="true" style="float: right; font-size: 20px;">×</a>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-sm-1"></div>
          <div class="col-sm-10">
            <h6 class="">"""),_display_(/*12.27*/Messages("1. Thông tin đấu nối")),format.raw/*12.59*/("""</h6>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*14.54*/Messages("User đấu nối")),format.raw/*14.78*/("""</span>
              <div class="col-sm-5">
                <input type="text" class="form-control input-form" id="staffCode" maxlength="50"/>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*20.54*/Messages("Giấy phép kinh doanh")),format.raw/*20.86*/("""</span>
              <div class="col-sm-5">
                <select class="form-control select-form" id="gpkdList" onchange="getContractByIdno(this)">
                  <option value="" selected>"""),_display_(/*23.46*/Messages("--- Chọn GPKD ---")),format.raw/*23.75*/("""</option>
                </select>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*28.54*/Messages("Tải danh sách TB")),format.raw/*28.82*/("""</span>
              <div class="col-sm-5">
                <input type="file" id="filesSerials" name="files" style="background-color: #aaa; width: 100%;" hidden/>
                <input type="text" class="form-control input-form" id="nameFileImport" readonly/>
              </div>
              <label class="col-sm-3 col-form-label title-section-2" style="text-align: left; cursor: pointer; color: #EA0033;" onclick="importFileConnectSerialAdm1()">
                <i class="bx bx-upload"></i> """),_display_(/*34.47*/Messages("Import file")),format.raw/*34.70*/("""
              """),format.raw/*35.15*/("""</label>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*38.54*/Messages("Tải file mẫu")),format.raw/*38.78*/("""</span>
              <span class="col-sm-5 col-form-label">"""),_display_(/*39.54*/Messages("List_Serial_Adm1.xlsx")),format.raw/*39.87*/("""</span>
              <div class="col-sm-3 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="downloadTemplateListSerialConnect()"><i class="bx bx-download"></i> """),_display_(/*41.139*/Messages("Download")),format.raw/*41.159*/("""</a>
              </div>
            </div>
            <div class="row mb-3">
              <span class="col-sm-4 col-form-label">"""),_display_(/*45.54*/Messages("Số TB hợp lệ")),format.raw/*45.78*/("""</span>
              <span class="col-sm-5 col-form-label" id="countSerialAdm1True">"""),_display_(/*46.79*/Messages("0")),format.raw/*46.92*/("""</span>
              <div class="col-sm-3 col-form-label">
                <a style="color: #EA0033; cursor: pointer;" onclick="exportListSerialAdm1True()"><i class="bx bx-download"></i> """),_display_(/*48.130*/Messages("Download")),format.raw/*48.150*/("""</a>
              </div>
            </div>

            <h6 class="">"""),_display_(/*52.27*/Messages("2. Thông tin gói cước")),format.raw/*52.60*/("""</h6>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*54.54*/Messages("Gói cước")),format.raw/*54.74*/("""</span>
              <div class="col-sm-5">
                <select class="form-control select-form" id="packDataList" onchange="getReasonWithPackQr()">
                  <option value="" selected>"""),_display_(/*57.46*/Messages("-- Chọn gói cước --")),format.raw/*57.77*/("""</option>
                </select>
              </div>
            </div>
            <div class="row mb-1">
              <span class="col-sm-4 col-form-label">"""),_display_(/*62.54*/Messages("Lý do đấu nối")),format.raw/*62.79*/("""</span>
              <div class="col-sm-5">
                <select class="form-control select-form" id="reasonList">
                  <option value="" selected>"""),_display_(/*65.46*/Messages("--- Chọn lý do ---")),format.raw/*65.76*/("""</option>
                </select>
              </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-cancle" data-bs-dismiss="modal">"""),_display_(/*71.85*/Messages("btnClose")),format.raw/*71.105*/("""</button>
              <button type="button" class="btn btn-red" onclick="validateListSerialConnect()">"""),_display_(/*72.96*/Messages("btnPrev")),format.raw/*72.115*/("""</button>
            </div>
          </div>
          <div class="col-sm-1"></div>
        </div>
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
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/qrcode/QrcodeList_add.scala.html
                  HASH: 95fc29713219f0b8dc2f4d2919687a845cf0b98e
                  MATRIX: 1057->0|1440->357|1500->397|1832->702|1885->734|2006->828|2051->852|2350->1124|2403->1156|2627->1353|2677->1382|2868->1546|2917->1574|3443->2073|3487->2096|3530->2111|3673->2227|3718->2251|3806->2312|3860->2345|4086->2543|4128->2563|4288->2696|4333->2720|4446->2806|4480->2819|4697->3008|4739->3028|4838->3100|4892->3133|5013->3227|5054->3247|5280->3446|5332->3477|5523->3641|5569->3666|5760->3830|5811->3860|6038->4060|6080->4080|6212->4185|6253->4204
                  LINES: 33->1|37->5|37->5|44->12|44->12|46->14|46->14|52->20|52->20|55->23|55->23|60->28|60->28|66->34|66->34|67->35|70->38|70->38|71->39|71->39|73->41|73->41|77->45|77->45|78->46|78->46|80->48|80->48|84->52|84->52|86->54|86->54|89->57|89->57|94->62|94->62|97->65|97->65|103->71|103->71|104->72|104->72
                  -- GENERATED --
              */
          