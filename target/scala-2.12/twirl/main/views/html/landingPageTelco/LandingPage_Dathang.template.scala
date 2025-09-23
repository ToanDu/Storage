
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

object LandingPage_Dathang extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(currentUser:User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),format.raw/*3.1*/("""<div class="section features-1" id="dathang" style="background: red;background-image: url("""),_display_(/*3.92*/routes/*3.98*/.Assets.versioned("images/landingPageTelco/BG1_1.png")),format.raw/*3.152*/(""");background-repeat: no-repeat;  background-size: 100% 100%;">
    <div class="container container-2">
        <div class="card-body">
            <div class="row g-0">
                <div class="col-md-6">
                    <iframe id="myVideo1" width="100%" height="456px" style="border-radius: 8px;" src="https://www.youtube.com/embed/2pxi6bSjLIo?si=eaF3PsE4EBmjKpgq?rel=1&amp;controls=1&amp;showinfo=0&amp;start=1&autoplay=0&enablejsapi=1"
                    frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
                </div>
                <div class="col-md-6">
                    <div class="card-body">
                        <div class="description">
                            <p class="descriptionss opacity-8" style="margin-left: -8px;">"""),_display_(/*14.92*/Messages("landingPageTelco.dathang.title")),format.raw/*14.134*/("""</p>
                        </div>
                    </div>
                    <div class="description">
                        <p class="order-2">"""),_display_(/*18.45*/Messages("landingPageTelco.dathang.efficiency")),format.raw/*18.92*/("""</p>
                    </div>
                    <div class="description">
                        <p class="order-2">"""),_display_(/*21.45*/Messages("landingPageTelco.dathang.offer")),format.raw/*21.87*/("""</p>
                    </div>
                    <div class="description">
                        <p class="order-2">"""),_display_(/*24.45*/Messages("landingPageTelco.dathang.solution")),format.raw/*24.90*/("""</p>
                    </div>
                    <div class="description">
                        <p class="order-2">"""),_display_(/*27.45*/Messages("landingPageTelco.dathang.investment")),format.raw/*27.92*/("""</p>
                    </div>
                    <div class="info info-horizontal info-hover-primary">
                        <div class="description">
                            <a href="https://innoway.vn/login"  rel="nofollow" class="btn btn-danger-2" >"""),_display_(/*31.107*/Messages("landingPageTelco.dathang.tryNow")),format.raw/*31.150*/("""<span style="margin-left: 4px;">&#8599;</span></a>
                            <a href="https://innoway.gitbook.io/innoway/" target="_blank" class="btn btn-danger-2" >"""),_display_(/*32.118*/Messages("landingPageTelco.dathang.userGuide")),format.raw/*32.164*/("""<span style="margin-left: 4px;">&#8599;</span></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="section features-1" id="dathang1" style="background-repeat: no-repeat;  background-size: 100% 100%;">
    <div class="container container-2" style="">
        <div class="card-body">
            <div class="row g-0">
                <div class="col-md-6">
                    <div class="description">
                        <p class="descriptionss opacity-8" style="color: #44494D">"""),_display_(/*46.84*/Messages("landingPageTelco.dathang.m2mtitle")),format.raw/*46.129*/("""</p>
                    </div>
                    <div class="description">
                        <p class="order-2" style="color: #44494D">"""),_display_(/*49.68*/Messages("landingPageTelco.dathang.m2mdescription")),format.raw/*49.119*/("""</p>
                    </div>
                    <div class="description">
                        <p class="order-2" style="color: #44494D">"""),_display_(/*52.68*/Messages("landingPageTelco.dathang.m2mfeatures")),format.raw/*52.116*/("""</p>
                    </div>
                    <div class="row g-0">
                        <div class="col-md-6"  style="display: grid;">
                            <div class="description">
                                <img class="Vector" src=""""),_display_(/*57.59*/routes/*57.65*/.Assets.versioned("images/landingPageTelco/Vector.png")),format.raw/*57.120*/("""">
                                <p class="order-3" style="color: #44494D">"""),_display_(/*58.76*/Messages("landingPageTelco.dathang.m2msubscriber")),format.raw/*58.126*/("""</p>
                            </div>
                            <div class="description">
                                <img class="Vector" src=""""),_display_(/*61.59*/routes/*61.65*/.Assets.versioned("images/landingPageTelco/Vector.png")),format.raw/*61.120*/("""">
                                <p class="order-3" style="color: #44494D">"""),_display_(/*62.76*/Messages("landingPageTelco.dathang.m2morder")),format.raw/*62.121*/("""</p>
                            </div>
                        </div>
                        <div class="col-md-6"  style="display: grid;">
                            <div class="description">
                                <img class="Vector" src=""""),_display_(/*67.59*/routes/*67.65*/.Assets.versioned("images/landingPageTelco/Vector.png")),format.raw/*67.120*/("""">
                                <p class="order-3" style="color: #44494D">"""),_display_(/*68.76*/Messages("landingPageTelco.dathang.m2mcontract")),format.raw/*68.124*/("""</p>
                            </div>
                            <div class="description">
                                <img class="Vector" src=""""),_display_(/*71.59*/routes/*71.65*/.Assets.versioned("images/landingPageTelco/Vector.png")),format.raw/*71.120*/("""">
                                <p class="order-3" style="color: #44494D">"""),_display_(/*72.76*/Messages("landingPageTelco.dathang.m2mpayment")),format.raw/*72.123*/("""</p>
                            </div>
                        </div>
                        <div class="col-md-6"  style="display: grid;">
                            <div class="description">
                                <img class="Vector" src=""""),_display_(/*77.59*/routes/*77.65*/.Assets.versioned("images/landingPageTelco/Vector.png")),format.raw/*77.120*/("""">
                                <p class="order-3" style="color: #44494D">"""),_display_(/*78.76*/Messages("landingPageTelco.dathang.m2mlocationtracking")),format.raw/*78.132*/("""</p>
                            </div>
                        </div>
                    </div>
                    <div class="info info-horizontal info-hover-primary">
                        <div class="description">
                            """),_display_(/*84.30*/if(currentUser != null)/*84.53*/{_display_(Seq[Any](format.raw/*84.54*/("""
                                """),_display_(/*85.34*/if(currentUser.getCmpRole == User.CmpRole.ADMIN.getCode() || currentUser.getCmpRole == User.CmpRole.SUPER_ENTERPRISE.getCode()|| currentUser.getCmpRole == User.CmpRole.SUPER_ADMIN.getCode() )/*85.225*/{_display_(Seq[Any](format.raw/*85.226*/("""
                                    """),format.raw/*86.37*/("""<a  href=""""),_display_(/*86.48*/routes/*86.54*/.TelcoRoleAccountController.accountList()),format.raw/*86.95*/("""" rel = "nofollow" target="_blank" class="btn btn-danger-2" style="background: #EA0033;color: #FFFFFF">"""),_display_(/*86.199*/Messages("landingPageTelco.dathang.tryNow")),format.raw/*86.242*/("""<span style="margin-left: 4px;">&#8599;</span></a>
                                """)))}/*87.35*/else/*87.40*/{_display_(Seq[Any](format.raw/*87.41*/("""
                                    """),_display_(/*88.38*/if(currentUser.getProfileStatus || currentUser.getCmpRole== User.CmpRole.ENTERPRISE_LV2.getCode())/*88.136*/{_display_(Seq[Any](format.raw/*88.137*/("""
                                        """),format.raw/*89.41*/("""<a href=""""),_display_(/*89.51*/routes/*89.57*/.TelcoDashboardController.telcoDashboard(currentUser.getId)),format.raw/*89.116*/(""""  rel="nofollow" target="_blank" class="btn btn-danger-2" style="background: #EA0033;color: #FFFFFF">"""),_display_(/*89.219*/Messages("landingPageTelco.dathang.tryNow")),format.raw/*89.262*/("""<span style="margin-left: 4px;">&#8599;</span></a>
                                    """)))}/*90.38*/else/*90.42*/{_display_(Seq[Any](format.raw/*90.43*/("""
                                        """),format.raw/*91.41*/("""<a href=""""),_display_(/*91.51*/routes/*91.57*/.TelcoAccountController.accountInfo(currentUser.getId)),format.raw/*91.111*/(""""  rel="nofollow" target="_blank" class="btn btn-danger-2" style="background: #EA0033;color: #FFFFFF">"""),_display_(/*91.214*/Messages("landingPageTelco.dathang.tryNow")),format.raw/*91.257*/("""<span style="margin-left: 4px;">&#8599;</span></a>
                                    """)))}),format.raw/*92.38*/("""
                                """)))}),format.raw/*93.34*/("""
                            """)))}/*94.31*/else/*94.36*/{_display_(Seq[Any](format.raw/*94.37*/("""
                                """),format.raw/*95.33*/("""<a href=""""),_display_(/*95.43*/routes/*95.49*/.Application.login()),format.raw/*95.69*/("""" rel="nofollow" target="_blank" class="btn btn-danger-2" style="background: #EA0033;color: #FFFFFF">"""),_display_(/*95.171*/Messages("landingPageTelco.dathang.tryNow")),format.raw/*95.214*/("""<span style="margin-left: 4px;">&#8599;</span></a>
                            """)))}),format.raw/*96.30*/("""
"""),format.raw/*97.58*/("""
"""),format.raw/*98.280*/("""
"""),format.raw/*99.41*/("""
"""),format.raw/*100.267*/("""
"""),format.raw/*101.34*/("""


                        """),format.raw/*104.25*/("""</div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="img-center">
                        <img class="" style="z-index: 21;max-width: 500px;  position: absolute; bottom: -30px;" src=""""),_display_(/*109.119*/routes/*109.125*/.Assets.versioned("images/landingPageTelco/m2m_1.png")),format.raw/*109.179*/("""">
                        <img class="" style="position: absolute;z-index: 20;max-width: 500px;left: 150px;top:-30px;" src=""""),_display_(/*110.124*/routes/*110.130*/.Assets.versioned("images/landingPageTelco/m2m_2.png")),format.raw/*110.184*/("""">
                    </div>
                </div>
            </div>
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
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPageTelco/LandingPage_Dathang.scala.html
                  HASH: d18c903dd7a45fa4fc222828359cb44f27fdc86f
                  MATRIX: 668->1|1017->35|1130->53|1157->54|1274->145|1288->151|1363->205|2180->995|2244->1037|2424->1190|2492->1237|2641->1359|2704->1401|2853->1523|2919->1568|3068->1690|3136->1737|3426->1999|3491->2042|3687->2210|3755->2256|4363->2837|4430->2882|4602->3027|4675->3078|4847->3223|4917->3271|5201->3528|5216->3534|5293->3589|5398->3667|5470->3717|5649->3869|5664->3875|5741->3930|5846->4008|5913->4053|6194->4307|6209->4313|6286->4368|6391->4446|6461->4494|6640->4646|6655->4652|6732->4707|6837->4785|6906->4832|7187->5086|7202->5092|7279->5147|7384->5225|7462->5281|7740->5532|7772->5555|7811->5556|7872->5590|8073->5781|8113->5782|8178->5819|8216->5830|8231->5836|8293->5877|8425->5981|8490->6024|8593->6109|8606->6114|8645->6115|8710->6153|8818->6251|8858->6252|8927->6293|8964->6303|8979->6309|9060->6368|9191->6471|9256->6514|9363->6602|9376->6606|9415->6607|9484->6648|9521->6658|9536->6664|9612->6718|9743->6821|9808->6864|9927->6952|9992->6986|10041->7017|10054->7022|10093->7023|10154->7056|10191->7066|10206->7072|10247->7092|10377->7194|10442->7237|10553->7317|10582->7375|10612->7655|10641->7696|10672->7963|10702->7997|10758->8024|11046->8283|11063->8289|11140->8343|11295->8469|11312->8475|11389->8529
                  LINES: 24->1|29->2|34->2|35->3|35->3|35->3|35->3|46->14|46->14|50->18|50->18|53->21|53->21|56->24|56->24|59->27|59->27|63->31|63->31|64->32|64->32|78->46|78->46|81->49|81->49|84->52|84->52|89->57|89->57|89->57|90->58|90->58|93->61|93->61|93->61|94->62|94->62|99->67|99->67|99->67|100->68|100->68|103->71|103->71|103->71|104->72|104->72|109->77|109->77|109->77|110->78|110->78|116->84|116->84|116->84|117->85|117->85|117->85|118->86|118->86|118->86|118->86|118->86|118->86|119->87|119->87|119->87|120->88|120->88|120->88|121->89|121->89|121->89|121->89|121->89|121->89|122->90|122->90|122->90|123->91|123->91|123->91|123->91|123->91|123->91|124->92|125->93|126->94|126->94|126->94|127->95|127->95|127->95|127->95|127->95|127->95|128->96|129->97|130->98|131->99|132->100|133->101|136->104|141->109|141->109|141->109|142->110|142->110|142->110
                  -- GENERATED --
              */
          