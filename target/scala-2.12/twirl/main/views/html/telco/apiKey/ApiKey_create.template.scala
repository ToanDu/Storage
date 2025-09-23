
package views.html.telco.apiKey

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

object ApiKey_create extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="createApiKeyModal" tabindex="-1" aria-labelledby="apiKeyModal" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="apiKeyModal">Tạo mới API Key</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="mb-3">
"""),format.raw/*11.98*/("""
                        """),format.raw/*12.25*/("""<span class="col-sm-4 col-form-label">"""),_display_(/*12.64*/Messages("Tên")),format.raw/*12.79*/("""</span>
                        <input type="text" class="form-control" id="nameKey">


                    </div>
"""),format.raw/*17.43*/("""
"""),format.raw/*18.94*/("""
"""),format.raw/*19.89*/("""
"""),format.raw/*20.31*/("""
                """),format.raw/*21.17*/("""</form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn mt-3 btn-telco" style="background: #FFFFFF; color: #EA0033;" data-bs-dismiss="modal">Hủy</button>
                <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF;"  data-bs-target="#resultApiKey" data-bs-dismiss="modal" data-bs-toggle="modal" onclick="createApiKey()">Gửi</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="resultApiKey" tabindex="-1" aria-labelledby="apiKeyModal" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="apiKeyModal">Tạo mới API Key</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body custom-modal-body">
                <a>Vì lý do bảo mật, chúng tôi chỉ hiển thị API Key một lần khi tạo và</a><a style="font-weight: bold;"> không hiển thị lại.</a><a> Vui lòng lưu api key vào nơi an toàn.</a>
                <form>
                    <label for="recipient-name" class="text-recharge-2 mt-3">Mã API Key:</label>
                    <div class="mb-3 d-flex align-items-center">
                        <input type="text" class="form-control input-form" id="nameKeyView" readonly>
                        <button type="button" class="btn btn-telco" style="background: #FFFFFF; color: #EA0033; width: 50px;border-radius: 8px 8px 8px 8px;" onclick="copyFunction()" aria-label="Copy">
                            <span class="btn-label-wrap"><span class="btn-node"><svg xmlns="http://www.w3.org/2000/svg" width="18px" height="18px" fill="currentColor" viewBox="0 0 24 24"><path fill-rule="evenodd" d="M7 5a3 3 0 0 1 3-3h9a3 3 0 0 1 3 3v9a3 3 0 0 1-3 3h-2v2a3 3 0 0 1-3 3H5a3 3 0 0 1-3-3v-9a3 3 0 0 1 3-3h2V5Zm2 2h5a3 3 0 0 1 3 3v5h2a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1h-9a1 1 0 0 0-1 1v2ZM5 9a1 1 0 0 0-1 1v9a1 1 0 0 0 1 1h9a1 1 0 0 0 1-1v-9a1 1 0 0 0-1-1H5Z" clip-rule="evenodd"></path></svg></span></span>
                        </button>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF;" data-bs-dismiss="modal" onclick="getApiKey()">Xác nhận</button>
            </div>
        </div>
    </div>
</div>

<div id="confirmDeleteModal" class="modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Xác nhận xóa</h5>
            </div>
            <div class="modal-body">
                <p>API Key sẽ mất hiệu lực ngay khi bạn xóa, bạn có chắc chắn muốn xóa không?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" onclick="closeModal()">Hủy</button>
                <button type="button" class="btn btn-danger" onclick="deleteConfirmed()">Xóa</button>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/apiKey/ApiKey_create.scala.html
                  HASH: 1fa62eb549247c18020c2fae3acf7a62f4ca339c
                  MATRIX: 1051->0|1601->619|1654->644|1720->683|1756->698|1899->855|1928->949|1957->1038|1986->1069|2031->1086
                  LINES: 33->1|43->11|44->12|44->12|44->12|49->17|50->18|51->19|52->20|53->21
                  -- GENERATED --
              */
          