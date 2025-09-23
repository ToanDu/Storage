
package views.html.landingPageTelco

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
/*1.2*/import vn.m2m.common.models.User

object LandingPage_Giaiphap extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<div class="section features-1" id="divGiaiphap">
    <div class="container" style="margin-top: -7rem;">
        <div class="col-md-12 mx-auto text-center">
            <p class="value1">"""),_display_(/*6.32*/Messages("landingPageTelco.giaiphap.platformTitle")),format.raw/*6.83*/("""</p>
            <h3 class="display-3 title-section-1">"""),_display_(/*7.52*/Messages("landingPageTelco.giaiphap.valueProposition")),format.raw/*7.106*/("""</h3>
        </div>
        <div class="row mt-5">
            <div class="col-md-3" id="card1">
                <div class="card card-blue text-center card-listProject">
                    <div class="alignItemCenter mt-3" style="margin-top: 1rem !important;">
                        <img src=""""),_display_(/*13.36*/routes/*13.42*/.Assets.versioned("images/landingPageTelco/Icon_user.svg")),format.raw/*13.100*/("""" width="65px" height="65px" class="align-items-lg-center">
                    </div>
                    <div class="text mt-3">
                        <h4 class="gp-title-1">"""),_display_(/*16.49*/Messages("landingPageTelco.giaiphap.subscriberManagement")),format.raw/*16.107*/("""</h4>
                        <p class="mt-3">"""),_display_(/*17.42*/Messages("landingPageTelco.giaiphap.subscriberDescription")),format.raw/*17.101*/("""</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3" id="card2">
                <div class="card card-blue text-center card-listProject">
                    <div class="alignItemCenter mt-3"  style="margin-top: 1rem !important;">
                        <img src=""""),_display_(/*24.36*/routes/*24.42*/.Assets.versioned("images/landingPageTelco/Group.svg")),format.raw/*24.96*/("""" width="65px" height="65px" class="align-items-lg-center">
                    </div>
                    <div class="text mt-3">
                        <h4 class="gp-title-1">"""),_display_(/*27.49*/Messages("landingPageTelco.giaiphap.contractManagement")),format.raw/*27.105*/("""</h4>
                        <p class="mt-3" >"""),_display_(/*28.43*/Messages("landingPageTelco.giaiphap.contractDescription")),format.raw/*28.100*/("""</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3" id="card3">
                <div class="card card-blue text-center card-listProject">
                    <div class="alignItemCenter mt-3"  style="margin-top: 1rem !important;">
                        <img src=""""),_display_(/*35.36*/routes/*35.42*/.Assets.versioned("images/landingPageTelco/Icon_donhang.svg")),format.raw/*35.103*/("""" width="65px" height="65px" class="align-items-lg-center">
                    </div>
                    <div class="text mt-3">
                        <h4 class="gp-title-1">"""),_display_(/*38.49*/Messages("landingPageTelco.giaiphap.orderManagement")),format.raw/*38.102*/("""</h4>
                        <p class="mt-3" style="margin-left: 20px; margin-right: 18px;">"""),_display_(/*39.89*/Messages("landingPageTelco.giaiphap.orderDescription")),format.raw/*39.143*/("""</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3" id="card4">
                <div class="card card-blue text-center card-listProject">
                    <div class="alignItemCenter mt-3"  style="margin-top: 1rem !important;">
                        <img src=""""),_display_(/*46.36*/routes/*46.42*/.Assets.versioned("images/landingPageTelco/Icon_TT.svg")),format.raw/*46.98*/(""""  width="65px" height="65px" class="align-items-lg-center">
                    </div>
                    <div class="text mt-3">
                        <h4 class="gp-title-1">"""),_display_(/*49.49*/Messages("landingPageTelco.giaiphap.topupSubscriber")),format.raw/*49.102*/("""</h4>
                        <p class="mt-3">"""),_display_(/*50.42*/Messages("landingPageTelco.giaiphap.topupDescription")),format.raw/*50.96*/("""</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3" id="card5">
                <div class="card card-blue text-center card-listProject">
                    <div class="alignItemCenter mt-3"  style="margin-top: 1rem !important;">
                        <img src=""""),_display_(/*57.36*/routes/*57.42*/.Assets.versioned("images/landingPageTelco/Icon_tienich.svg")),format.raw/*57.103*/("""" width="65px" height="65px" class="align-items-lg-center">
                    </div>
                    <div class="text mt-3">
                        <h4 class="gp-title-1">"""),_display_(/*60.49*/Messages("landingPageTelco.giaiphap.blockUnblock")),format.raw/*60.99*/("""</h4>
                        <p class="mt-3">"""),_display_(/*61.42*/Messages("landingPageTelco.giaiphap.blockDescription")),format.raw/*61.96*/("""</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3" id="card6">
                <div class="card card-blue text-center card-listProject">
                    <div class="alignItemCenter mt-3"  style="margin-top: 1rem !important;">
                        <img src=""""),_display_(/*68.36*/routes/*68.42*/.Assets.versioned("images/landingPageTelco/icon_settings.svg")),format.raw/*68.104*/("""" width="65px" height="65px" class="align-items-lg-center">
                    </div>
                    <div class="text mt-3">
                        <h4 class="gp-title-1">"""),_display_(/*71.49*/Messages("landingPageTelco.giaiphap.packageRegistration")),format.raw/*71.106*/("""</h4>
                        <p class="mt-3">"""),_display_(/*72.42*/Messages("landingPageTelco.giaiphap.packageDescription")),format.raw/*72.98*/("""</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3" id="card7">
                <div class="card card-blue text-center card-listProject">
                    <div class="alignItemCenter mt-3"  style="margin-top: 1rem !important;">
                        <img src=""""),_display_(/*79.36*/routes/*79.42*/.Assets.versioned("images/landingPageTelco/world_1.jpg")),format.raw/*79.98*/("""" width="" class="align-items-lg-center">
                    </div>
                    <div class="text mt-3">
                        <h4 class="gp-title-1">"""),_display_(/*82.49*/Messages("landingPageTelco.giaiphap.subscriberConnection")),format.raw/*82.107*/("""</h4>
                        <p class="mt-3">"""),_display_(/*83.42*/Messages("landingPageTelco.giaiphap.connectionDescription")),format.raw/*83.101*/("""</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3" id="card8">
                <div class="card card-blue text-center card-listProject">
                    <div class="alignItemCenter mt-3"  style="margin-top: 1rem !important;">
                        <img src=""""),_display_(/*90.36*/routes/*90.42*/.Assets.versioned("images/landingPageTelco/Icon_hang.svg")),format.raw/*90.100*/("""" width="65px" height="65px" class="align-items-lg-center">
                    </div>
                    <div class="text mt-3">
                        <h4 class="gp-title-1">"""),_display_(/*93.49*/Messages("landingPageTelco.giaiphap.bulkOrdering")),format.raw/*93.99*/("""</h4>
                        <p class="mt-3">"""),_display_(/*94.42*/Messages("landingPageTelco.giaiphap.bulkDescription")),format.raw/*94.95*/("""</p>
                    </div>
                </div>
            </div>

        </div>
        <div class="info info-horizontal info-hover-primary" style="text-align: right; margin-right: 1rem;margin-top: 1rem;">
            <div class="description">
            """),_display_(/*102.14*/if(currentUser != null)/*102.37*/{_display_(Seq[Any](format.raw/*102.38*/("""
                """),format.raw/*103.17*/("""<a href=""""),_display_(/*103.27*/routes/*103.33*/.TelcoDashboardController.telcoDashboard(currentUser.getId)),format.raw/*103.92*/(""""  rel="nofollow" target="_blank" class="btn btn-danger-2" style="background: #EA0033;color: #FFFFFF">"""),_display_(/*103.195*/Messages("landingPageTelco.giaiphap.tryNow")),format.raw/*103.239*/("""<span style="margin-left: 4px;">&#8599;</span></a>
            """)))}/*104.15*/else/*104.20*/{_display_(Seq[Any](format.raw/*104.21*/("""
                """),format.raw/*105.17*/("""<a href=""""),_display_(/*105.27*/routes/*105.33*/.Application.login()),format.raw/*105.53*/("""" rel="nofollow" target="_blank" class="btn btn-danger-2" style="background: #EA0033;color: #FFFFFF">"""),_display_(/*105.155*/Messages("landingPageTelco.giaiphap.tryNow")),format.raw/*105.199*/("""<span style="margin-left: 4px;">&#8599;</span></a>
            """)))}),format.raw/*106.14*/("""
            """),format.raw/*107.13*/("""</div>
        </div>
    </div>
</div>"""))
      }
    }
  }

  def render(currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(currentUser)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (currentUser) => apply(currentUser)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 17:07:59 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPageTelco/LandingPage_Giaiphap.scala.html
                  HASH: 6db483f7bbc51f2ee71a57d494baa9a431e4486d
                  MATRIX: 668->1|1018->35|1131->53|1158->54|1372->242|1443->293|1525->349|1600->403|1926->702|1941->708|2021->766|2227->945|2307->1003|2381->1050|2462->1109|2811->1431|2826->1437|2901->1491|3107->1670|3185->1726|3260->1774|3339->1831|3688->2153|3703->2159|3786->2220|3992->2399|4067->2452|4188->2546|4264->2600|4613->2922|4628->2928|4705->2984|4912->3164|4987->3217|5061->3264|5136->3318|5485->3640|5500->3646|5583->3707|5789->3886|5860->3936|5934->3983|6009->4037|6358->4359|6373->4365|6457->4427|6663->4606|6742->4663|6816->4710|6893->4766|7242->5088|7257->5094|7334->5150|7522->5311|7602->5369|7676->5416|7757->5475|8106->5797|8121->5803|8201->5861|8407->6040|8478->6090|8552->6137|8626->6190|8921->6457|8954->6480|8994->6481|9040->6498|9078->6508|9094->6514|9175->6573|9307->6676|9374->6720|9458->6785|9472->6790|9512->6791|9558->6808|9596->6818|9612->6824|9654->6844|9785->6946|9852->6990|9948->7054|9990->7067
                  LINES: 24->1|29->2|34->2|35->3|38->6|38->6|39->7|39->7|45->13|45->13|45->13|48->16|48->16|49->17|49->17|56->24|56->24|56->24|59->27|59->27|60->28|60->28|67->35|67->35|67->35|70->38|70->38|71->39|71->39|78->46|78->46|78->46|81->49|81->49|82->50|82->50|89->57|89->57|89->57|92->60|92->60|93->61|93->61|100->68|100->68|100->68|103->71|103->71|104->72|104->72|111->79|111->79|111->79|114->82|114->82|115->83|115->83|122->90|122->90|122->90|125->93|125->93|126->94|126->94|134->102|134->102|134->102|135->103|135->103|135->103|135->103|135->103|135->103|136->104|136->104|136->104|137->105|137->105|137->105|137->105|137->105|137->105|138->106|139->107
                  -- GENERATED --
              */
          