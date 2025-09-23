
package views.html.login

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

object Footer extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<footer class="footer">
  <div class="container">
    <nav class="float-left">
      <ul>
        <li>
          <a href="#">
                                        IoT Platform Team
          </a>
        </li>
        <li>
          <a href="#">
                                        About Us
          </a>
        </li>
        <li>
          <a href="#">
                                        Blog
          </a>
        </li>
        <li>
          <a href="#">
                                        Licenses
          </a>
        </li>
      </ul>
    </nav>
    <div class="copyright float-right">
          &copy;
      <script>
                                    document.write(new Date().getFullYear())
                            </script>, made with <i class="fa fa-heart"></i> by
      <a href="" target="_blank">IoT Platform Team</a> for a better web.
    </div>
  </div>
</footer>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:48 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/login/Footer.scala.html
                  HASH: 79ece8bc1a065e6110cb3a4e3c26edb038298390
                  MATRIX: 1037->0
                  LINES: 33->1
                  -- GENERATED --
              */
          