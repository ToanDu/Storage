
package views.html.oauth

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
/*1.2*/import com.google.common.base.Strings

object Consent extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Map[String, String],List[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(map: Map[String, String])(requestedScopes: List[String]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.59*/("""

"""),format.raw/*4.1*/("""<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>"""),_display_(/*9.17*/Messages("Login")),format.raw/*9.34*/("""</title>
        <link rel="icon" type="image/png" href=""""),_display_(/*10.50*/routes/*10.56*/.Assets.versioned("images/logo.jpg")),format.raw/*10.92*/("""">

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        <link href=""""),_display_(/*15.22*/routes/*15.28*/.Assets.versioned("assets/css/pace.min.css")),format.raw/*15.72*/("""" rel="stylesheet" />
            <!-- Bootstrap CSS -->
        <link href=""""),_display_(/*17.22*/routes/*17.28*/.Assets.versioned("assets/css/bootstrap.min.css")),format.raw/*17.77*/("""" rel="stylesheet">
        <link href=""""),_display_(/*18.22*/routes/*18.28*/.Assets.versioned("assets/css/app.css")),format.raw/*18.67*/("""" rel="stylesheet">
        <link href=""""),_display_(/*19.22*/routes/*19.28*/.Assets.versioned("assets/css/icons.css")),format.raw/*19.69*/("""" rel="stylesheet">

        <link rel="stylesheet" href=""""),_display_(/*21.39*/routes/*21.45*/.Assets.versioned("assets/plugins/notifications/css/lobibox.min.css")),format.raw/*21.114*/("""" />

        <link href=""""),_display_(/*23.22*/routes/*23.28*/.Assets.versioned("stylesheets/views/login/login.css")),format.raw/*23.82*/("""" rel="stylesheet">
    </head>
    <body class="bg-theme " style="background-image: url("""),_display_(/*25.59*/routes/*25.65*/.Assets.versioned("images/login/background.png")),format.raw/*25.113*/(""")">

        <div class="wrapper">
            <div class="authentication-reset-password d-flex align-items-center justify-content-center">
                <div class="row">
                    <div class="col-12 col-lg-8 mx-auto">
                        <div class="">
                            <div class="row g-0" style="padding: 30px;border-radius: 32px;box-shadow: 0 0 30px 0 rgba(129, 137, 152, 0.4);background-color: #ffffff;">
                                <div class="col-lg-7">
                                    <div class="text-center">
                                        <a href=""""),_display_(/*35.51*/routes/*35.57*/.LandingPageController.home()),format.raw/*35.86*/("""">
                                            <img src=""""),_display_(/*36.56*/routes/*36.62*/.Assets.versioned("images/login/logo.svg")),format.raw/*36.104*/("""" height="80%" alt="" />
                                        </a>
                                    </div>

                                    <img src=""""),_display_(/*40.48*/routes/*40.54*/.Assets.versioned("images/login/frame.png")),format.raw/*40.97*/("""" class="card-img login-img h-80 mt-5" alt="...">
                                </div>

                                <div class="col-lg-5 border-end">
                                    <div class="card-body">
                                        <div class="p-6 mt-3">
                                            """),_display_(/*46.46*/if(Strings.isNullOrEmpty(map.get("consentChallenge")))/*46.100*/{_display_(Seq[Any](format.raw/*46.101*/("""
                                                """),format.raw/*47.49*/("""<div class="row g-3">
                                                    <div class="col-12">
                                                        <div class="d-grid text-center">
                                                            <p>
                                                                """),_display_(/*51.66*/map/*51.69*/.get("errorTitle")),format.raw/*51.87*/(""":
                                                                <a style="color:#ec1b2e">"""),_display_(/*52.91*/map/*52.94*/.get("errorContent")),format.raw/*52.114*/("""</a>
                                                            </p>
                                                        </div>
                                                    </div>
                                                </div>
                                            """)))}/*57.47*/else/*57.52*/{_display_(Seq[Any](format.raw/*57.53*/("""
                                                """),format.raw/*58.49*/("""<form class="row g-3" action=""""),_display_(/*58.80*/routes/*58.86*/.OAuthController.postConsent()),format.raw/*58.116*/("""" id="form-login" method="post" autocomplete="off">
                                                    <div class="col-12">
                                                        <h4 class="consent">"""),_display_(/*60.78*/map/*60.81*/.get("consentMessage")),format.raw/*60.103*/("""</h4>
                                                    </div>

                                                    """),_display_(/*63.54*/for(scope <- requestedScopes) yield /*63.83*/{_display_(Seq[Any](format.raw/*63.84*/("""
                                                        """),format.raw/*64.57*/("""<div class="col-12 form-check">
                                                            <input onclick="return false;" type="checkbox" id="input"""),_display_(/*65.118*/scope),format.raw/*65.123*/("""" name="grantScope[]" value=""""),_display_(/*65.153*/scope),format.raw/*65.158*/("""" class="form-check-input" checked>
                                                            <label for="input"""),_display_(/*66.79*/scope),format.raw/*66.84*/("""" class="form-label">"""),_display_(/*66.106*/scope),format.raw/*66.111*/("""</label>
                                                        </div>
                                                        <hr>
                                                    """)))}),format.raw/*69.54*/("""
                                                    """),format.raw/*70.53*/("""<input type="hidden" name="consentChallenge" value=""""),_display_(/*70.106*/map/*70.109*/.get("consentChallenge")),format.raw/*70.133*/("""">
                                                    <div class="col-12">
                                                        <div class="d-grid">
                                                            <button type="submit" id="loginButton" class="btn btn-danger">"""),_display_(/*73.124*/Messages("btnComfirm")),format.raw/*73.146*/("""</button>
                                                        </div>
                                                    </div>
                                                </form>
                                            """)))}),format.raw/*77.46*/("""

                                        """),format.raw/*79.41*/("""</div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>

    <script type="text/javascript" src=""""),_display_(/*92.42*/routes/*92.48*/.JsController.jsMessages()),format.raw/*92.74*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*93.42*/routes/*93.48*/.JsController.javascriptRoutes),format.raw/*93.78*/(""""></script>
    <script src=""""),_display_(/*94.19*/routes/*94.25*/.Assets.versioned("javascripts/js/core/jquery.min.js")),format.raw/*94.79*/("""" type="text/javascript"></script>

    <script type="text/javascript" src=""""),_display_(/*96.42*/routes/*96.48*/.Assets.versioned("assets/js/jquery.min.js")),format.raw/*96.92*/(""""></script>
        <!--notification js -->
    <script src=""""),_display_(/*98.19*/routes/*98.25*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*98.92*/(""""></script>
    <script src=""""),_display_(/*99.19*/routes/*99.25*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*99.98*/(""""></script>
    <script src=""""),_display_(/*100.19*/routes/*100.25*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*100.107*/(""""></script>

    <script src=""""),_display_(/*102.19*/routes/*102.25*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*102.77*/("""" type="text/javascript"></script>

    <script>
            $("body").on("submit", "form", function() """),format.raw/*105.55*/("""{"""),format.raw/*105.56*/("""
                """),format.raw/*106.17*/("""$(this).submit(function() """),format.raw/*106.43*/("""{"""),format.raw/*106.44*/("""
                    """),format.raw/*107.21*/("""return false;
                """),format.raw/*108.17*/("""}"""),format.raw/*108.18*/(""");
                return true;
            """),format.raw/*110.13*/("""}"""),format.raw/*110.14*/(""");
    </script>
</html>"""))
      }
    }
  }

  def render(map:Map[String, String],requestedScopes:List[String]): play.twirl.api.HtmlFormat.Appendable = apply(map)(requestedScopes)

  def f:((Map[String, String]) => (List[String]) => play.twirl.api.HtmlFormat.Appendable) = (map) => (requestedScopes) => apply(map)(requestedScopes)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:48 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/oauth/Consent.scala.html
                  HASH: 559d41b39530ab4d4420b52233e2a9eded128b69
                  MATRIX: 657->1|1027->40|1179->97|1207->99|1399->265|1436->282|1521->340|1536->346|1593->382|1825->587|1840->593|1905->637|2010->715|2025->721|2095->770|2163->811|2178->817|2238->856|2306->897|2321->903|2383->944|2469->1003|2484->1009|2575->1078|2629->1105|2644->1111|2719->1165|2836->1255|2851->1261|2921->1309|3553->1914|3568->1920|3618->1949|3703->2007|3718->2013|3782->2055|3970->2216|3985->2222|4049->2265|4400->2589|4464->2643|4504->2644|4581->2693|4921->3006|4933->3009|4972->3027|5091->3119|5103->3122|5145->3142|5456->3435|5469->3440|5508->3441|5585->3490|5643->3521|5658->3527|5710->3557|5939->3759|5951->3762|5995->3784|6141->3903|6186->3932|6225->3933|6310->3990|6487->4139|6514->4144|6572->4174|6599->4179|6740->4293|6766->4298|6816->4320|6843->4325|7060->4511|7141->4564|7222->4617|7235->4620|7281->4644|7585->4920|7629->4942|7893->5175|7963->5217|8285->5512|8300->5518|8347->5544|8427->5597|8442->5603|8493->5633|8550->5663|8565->5669|8640->5723|8744->5800|8759->5806|8824->5850|8913->5912|8928->5918|9016->5985|9073->6015|9088->6021|9182->6094|9240->6124|9256->6130|9361->6212|9420->6243|9436->6249|9510->6301|9642->6404|9672->6405|9718->6422|9773->6448|9803->6449|9853->6470|9912->6500|9942->6501|10015->6545|10045->6546
                  LINES: 24->1|29->2|34->2|36->4|41->9|41->9|42->10|42->10|42->10|47->15|47->15|47->15|49->17|49->17|49->17|50->18|50->18|50->18|51->19|51->19|51->19|53->21|53->21|53->21|55->23|55->23|55->23|57->25|57->25|57->25|67->35|67->35|67->35|68->36|68->36|68->36|72->40|72->40|72->40|78->46|78->46|78->46|79->47|83->51|83->51|83->51|84->52|84->52|84->52|89->57|89->57|89->57|90->58|90->58|90->58|90->58|92->60|92->60|92->60|95->63|95->63|95->63|96->64|97->65|97->65|97->65|97->65|98->66|98->66|98->66|98->66|101->69|102->70|102->70|102->70|102->70|105->73|105->73|109->77|111->79|124->92|124->92|124->92|125->93|125->93|125->93|126->94|126->94|126->94|128->96|128->96|128->96|130->98|130->98|130->98|131->99|131->99|131->99|132->100|132->100|132->100|134->102|134->102|134->102|137->105|137->105|138->106|138->106|138->106|139->107|140->108|140->108|142->110|142->110
                  -- GENERATED --
              */
          