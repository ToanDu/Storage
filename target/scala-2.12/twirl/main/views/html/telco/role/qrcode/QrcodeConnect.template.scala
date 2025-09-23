
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

object QrcodeConnect extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(id: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.14*/("""
"""),format.raw/*2.1*/("""<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>"""),_display_(/*7.13*/Messages("Đấu nối")),format.raw/*7.32*/("""</title>
    <link rel="icon" type="image/png" href=""""),_display_(/*8.46*/routes/*8.52*/.Assets.versioned("images/logo.jpg")),format.raw/*8.88*/("""">

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <link href=""""),_display_(/*13.18*/routes/*13.24*/.Assets.versioned("assets/css/pace.min.css")),format.raw/*13.68*/("""" rel="stylesheet" />
      <!-- Bootstrap CSS -->
    <link href=""""),_display_(/*15.18*/routes/*15.24*/.Assets.versioned("assets/css/bootstrap.min.css")),format.raw/*15.73*/("""" rel="stylesheet">
    <link href=""""),_display_(/*16.18*/routes/*16.24*/.Assets.versioned("assets/css/app.css")),format.raw/*16.63*/("""" rel="stylesheet">
    <link href=""""),_display_(/*17.18*/routes/*17.24*/.Assets.versioned("assets/css/icons.css")),format.raw/*17.65*/("""" rel="stylesheet">

    <link rel="stylesheet" href=""""),_display_(/*19.35*/routes/*19.41*/.Assets.versioned("assets/plugins/notifications/css/lobibox.min.css")),format.raw/*19.110*/("""" />

    <link href=""""),_display_(/*21.18*/routes/*21.24*/.Assets.versioned("stylesheets/views/login/login.css")),format.raw/*21.78*/("""" rel="stylesheet">

    <style>
            .btn-red """),format.raw/*24.22*/("""{"""),format.raw/*24.23*/("""
              """),format.raw/*25.15*/("""background: #EA0033;
              color: #ffffff;
              border: 1px solid #EA0033;
              border-radius: 8px 8px 8px 0px;
              width: 150px;
              font-weight: 600;
            """),format.raw/*31.13*/("""}"""),format.raw/*31.14*/("""

            """),format.raw/*33.13*/(""".btn-cancle """),format.raw/*33.25*/("""{"""),format.raw/*33.26*/("""
              """),format.raw/*34.15*/("""background: #FFFFFF;
              color: #EA0033;
              border: 1px solid #EA0033;
              border-radius: 8px 8px 8px 0px;
              width: 120px;
              font-weight: 600;
            """),format.raw/*40.13*/("""}"""),format.raw/*40.14*/("""
    """),format.raw/*41.5*/("""</style>
  </head>
  <body class="bg-theme " style="background-image: url("""),_display_(/*43.57*/routes/*43.63*/.Assets.versioned("images/login/background.png")),format.raw/*43.111*/(""")">

    <div class="wrapper">
      <div class="authentication-reset-password d-flex align-items-center justify-content-center">
        <div class="row">
          <div class="col-12 col-lg-12 mx-auto">
            <div class="">

              <div class="row g-0" id="formVerifyConnectSubs" style="padding: 30px;border-radius: 32px;box-shadow: 0 0 30px 0 rgba(129, 137, 152, 0.4);background-color: #ffffff;">
                <div class="col-lg-12 border-end">
                  <div class="card-body mb-1">
                    <div class="p-6 mt-3">
                      <form class="row g-3" id="" autocomplete="off">
                        """),format.raw/*56.49*/("""
                          """),format.raw/*57.95*/("""
                        """),format.raw/*58.35*/("""
                        """),format.raw/*59.25*/("""<div class="col-12">
                          <h6 class="dangnhap" style="">"""),_display_(/*60.58*/Messages("Nhập mã xác nhận")),format.raw/*60.86*/("""</h6>
                          <input type="text" id="codeVerify" class="form-control" maxlength="50" style="border-radius: 30px;opacity: 0.5;background: #eee;margin-top: 15px;color: #333333;">
                        </div>

                        <div class="d-flex flex-column align-items-center text-center">
                          <div class="">
                            <button type="button" class="btn mt-3 btn-telco" style="background: #EA0033; color: #FFFFFF; width: 180px;border-radius: 8px 8px 8px 0px;" onclick="processVerifyCodeConnectSubs()">"""),_display_(/*66.210*/Messages("Xác nhận")),format.raw/*66.230*/("""</button>
                          </div>
                        </div>
                      </form>
                    </div>
                  </div>
                </div>
              </div>

              <div class="row g-0" id="formDetailConnectSubs" style="padding: 30px;border-radius: 32px;box-shadow: 0 0 30px 0 rgba(129, 137, 152, 0.4);background-color: #ffffff; display: none;">
                <div class="col-lg-12 border-end">
                  <div class="card-body mb-1">
                    <div class="p-6 mt-3">
                      <form class="row g-3" id="" autocomplete="off">
                        <div>
                          <i class="bx bx-arrow-back" onclick="backFormVerifyConnect()" style="cursor: pointer;"></i> """),_display_(/*81.120*/Messages("Quay lại")),format.raw/*81.140*/("""
                        """),format.raw/*82.25*/("""</div>
                        <div class="col-12">
                          <h6 class="dangnhap" style="text-align: center">"""),_display_(/*84.76*/Messages("Xác nhận đấu nối")),format.raw/*84.104*/("""</h6>
                        </div>
                        <div class="col-12" id="detailInfoConnectSubs">

                        </div>
                        <div class="d-flex flex-column align-items-center text-center">
                          <div class="">
                            <button type="button" class="btn btn-red" id="buttonPaymentConnect" onclick="paymentConnectSubs()" style="">"""),_display_(/*91.138*/Messages("Đấu nối")),format.raw/*91.157*/("""</button>
                            <button type="button" class="btn btn-red" id="buttonFinishConnect" onclick="finishQrConnect()" style="display: none;">"""),_display_(/*92.148*/Messages("Kết thúc")),format.raw/*92.168*/("""</button>
                          </div>
                        </div>
                      </form>
                    </div>
                  </div>
                </div>
              </div>

            </div>
          </div>
        </div>
      </div>
    </div>

    """),_display_(/*107.6*/views/*107.11*/.html.telco.Loading()),format.raw/*107.32*/("""

  """),format.raw/*109.3*/("""</body>

  <script type="text/javascript" src=""""),_display_(/*111.40*/routes/*111.46*/.JsController.jsMessages()),format.raw/*111.72*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*112.40*/routes/*112.46*/.JsController.javascriptRoutes),format.raw/*112.76*/(""""></script>
  <script src=""""),_display_(/*113.17*/routes/*113.23*/.Assets.versioned("javascripts/landingPage/jquery.min.js")),format.raw/*113.81*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*114.17*/routes/*114.23*/.Assets.versioned("javascripts/landingPage/bootstrap.min.js")),format.raw/*114.84*/("""" type="text/javascript"></script>
  <script type="text/javascript" src=""""),_display_(/*115.40*/routes/*115.46*/.Assets.versioned("assets/js/jquery.min.js")),format.raw/*115.90*/(""""></script>
    <!--notification js -->
  <script src=""""),_display_(/*117.17*/routes/*117.23*/.Assets.versioned("assets/plugins/notifications/js/lobibox.min.js")),format.raw/*117.90*/(""""></script>
  <script src=""""),_display_(/*118.17*/routes/*118.23*/.Assets.versioned("assets/plugins/notifications/js/notifications.min.js")),format.raw/*118.96*/(""""></script>
  <script src=""""),_display_(/*119.17*/routes/*119.23*/.Assets.versioned("assets/plugins/notifications/js/notification-custom-script.js")),format.raw/*119.105*/(""""></script>

  <script src=""""),_display_(/*121.17*/routes/*121.23*/.Assets.versioned("javascripts/ShowNotification.js")),format.raw/*121.75*/("""" type="text/javascript"></script>
  <script type="text/javascript">
    var idLink = '"""),_display_(/*123.20*/id),format.raw/*123.22*/("""';

            $(document).ready(function()"""),format.raw/*125.41*/("""{"""),format.raw/*125.42*/("""
              """),_display_(/*126.16*/if(flash.containsKey("success"))/*126.48*/ {_display_(Seq[Any](format.raw/*126.50*/("""
              """),format.raw/*127.15*/("""showNotification('success','"""),_display_(/*127.44*/flash/*127.49*/.get("success")),format.raw/*127.64*/("""');
              """)))}),format.raw/*128.16*/("""
              """),_display_(/*129.16*/if(flash.containsKey("failed"))/*129.47*/ {_display_(Seq[Any](format.raw/*129.49*/("""
              """),format.raw/*130.15*/("""showNotification('danger','"""),_display_(/*130.43*/flash/*130.48*/.get("failed")),format.raw/*130.62*/("""');
              """)))}),format.raw/*131.16*/("""
            """),format.raw/*132.13*/("""}"""),format.raw/*132.14*/(""");
    </script>
  <script src=""""),_display_(/*134.17*/routes/*134.23*/.Assets.versioned("javascripts/plugins/moment.min.js")),format.raw/*134.77*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*135.17*/routes/*135.23*/.Assets.versioned("assets/js/chosen.jquery.min.js")),format.raw/*135.74*/(""""></script>

  <script src=""""),_display_(/*137.17*/routes/*137.23*/.Assets.versioned("javascripts/views/telco/role/qrcode/QrcodeConnect.js")),format.raw/*137.96*/("""" type="text/javascript"></script>

</html>"""))
      }
    }
  }

  def render(id:String): play.twirl.api.HtmlFormat.Appendable = apply(id)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (id) => apply(id)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:54 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/telco/role/qrcode/QrcodeConnect.scala.html
                  HASH: 901cf7c9b716326d312c0bf665e34e6ae4ccbf03
                  MATRIX: 974->1|1081->13|1108->14|1286->166|1325->185|1405->239|1419->245|1475->281|1695->474|1710->480|1775->524|1870->592|1885->598|1955->647|2019->684|2034->690|2094->729|2158->766|2173->772|2235->813|2317->868|2332->874|2423->943|2473->966|2488->972|2563->1026|2645->1080|2674->1081|2717->1096|2955->1306|2984->1307|3026->1321|3066->1333|3095->1334|3138->1349|3376->1559|3405->1560|3437->1565|3539->1640|3554->1646|3624->1694|4300->2366|4355->2461|4408->2496|4461->2521|4566->2599|4615->2627|5208->3192|5250->3212|6034->3968|6076->3988|6129->4013|6283->4140|6333->4168|6768->4575|6809->4594|6994->4751|7036->4771|7345->5053|7360->5058|7403->5079|7435->5083|7511->5131|7527->5137|7575->5163|7654->5214|7670->5220|7722->5250|7778->5278|7794->5284|7874->5342|7953->5393|7969->5399|8052->5460|8154->5534|8170->5540|8236->5584|8320->5640|8336->5646|8425->5713|8481->5741|8497->5747|8592->5820|8648->5848|8664->5854|8769->5936|8826->5965|8842->5971|8916->6023|9032->6111|9056->6113|9129->6157|9159->6158|9203->6174|9245->6206|9286->6208|9330->6223|9387->6252|9402->6257|9439->6272|9490->6291|9534->6307|9575->6338|9616->6340|9660->6355|9716->6383|9731->6388|9767->6402|9818->6421|9860->6434|9890->6435|9951->6468|9967->6474|10043->6528|10122->6579|10138->6585|10211->6636|10268->6665|10284->6671|10379->6744
                  LINES: 28->1|33->1|34->2|39->7|39->7|40->8|40->8|40->8|45->13|45->13|45->13|47->15|47->15|47->15|48->16|48->16|48->16|49->17|49->17|49->17|51->19|51->19|51->19|53->21|53->21|53->21|56->24|56->24|57->25|63->31|63->31|65->33|65->33|65->33|66->34|72->40|72->40|73->41|75->43|75->43|75->43|88->56|89->57|90->58|91->59|92->60|92->60|98->66|98->66|113->81|113->81|114->82|116->84|116->84|123->91|123->91|124->92|124->92|139->107|139->107|139->107|141->109|143->111|143->111|143->111|144->112|144->112|144->112|145->113|145->113|145->113|146->114|146->114|146->114|147->115|147->115|147->115|149->117|149->117|149->117|150->118|150->118|150->118|151->119|151->119|151->119|153->121|153->121|153->121|155->123|155->123|157->125|157->125|158->126|158->126|158->126|159->127|159->127|159->127|159->127|160->128|161->129|161->129|161->129|162->130|162->130|162->130|162->130|163->131|164->132|164->132|166->134|166->134|166->134|167->135|167->135|167->135|169->137|169->137|169->137
                  -- GENERATED --
              */
          