
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

object LandingPage_client extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="section features-1" id="client">
    <div class="container" style="">
        <div class="col-md-12">
            <h3 class="display-2 title-section-1">"""),_display_(/*4.52*/Messages("landingPageTelco.clients.title")),format.raw/*4.94*/("""</h3>
            """),format.raw/*5.118*/("""
        """),format.raw/*6.9*/("""</div>
        <div class="wp-slider">
            <div class="owl-carousel mt-6">
                <div class="item">
                    <img class="img-brand" src=""""),_display_(/*10.50*/routes/*10.56*/.Assets.versioned("images/landingPageTelco/partner_1.svg")),format.raw/*10.114*/("""" width="100%">
                </div>
                <div class="item">
                    <img class="img-brand" src=""""),_display_(/*13.50*/routes/*13.56*/.Assets.versioned("images/landingPageTelco/partner_8.svg")),format.raw/*13.114*/(""""width="100%">
                </div>
                <div class="item">
                    <img class="img-brand" src=""""),_display_(/*16.50*/routes/*16.56*/.Assets.versioned("images/landingPageTelco/partner_3.svg")),format.raw/*16.114*/("""" width="100%" >
                </div>
                <div class="item">
                    <img class="img-brand" src=""""),_display_(/*19.50*/routes/*19.56*/.Assets.versioned("images/landingPageTelco/partner_7.svg")),format.raw/*19.114*/("""" width="100%">
                </div>
                <div class="item">
                    <img class="img-brand" src=""""),_display_(/*22.50*/routes/*22.56*/.Assets.versioned("images/landingPageTelco/partner_6.svg")),format.raw/*22.114*/("""" width="100%" >
                </div>
                <div class="item">
                    <img class="img-brand" src=""""),_display_(/*25.50*/routes/*25.56*/.Assets.versioned("images/landingPageTelco/partner_9.svg")),format.raw/*25.114*/("""" width="100%" >
                </div>

                <div class="item">
                    <img class="img-brand" src=""""),_display_(/*29.50*/routes/*29.56*/.Assets.versioned("images/landingPageTelco/partner_11.svg")),format.raw/*29.115*/("""" width="100%" >
                </div>
                <div class="item">
                    <img class="img-brand" src=""""),_display_(/*32.50*/routes/*32.56*/.Assets.versioned("images/landingPageTelco/partner_12.svg")),format.raw/*32.115*/("""" width="100%" >
                </div>
                <div class="item">
                    <img class="img-brand" src=""""),_display_(/*35.50*/routes/*35.56*/.Assets.versioned("images/landingPageTelco/partner_13.svg")),format.raw/*35.115*/("""" width="100%" >
                </div>
            </div>
        </div>
        """),format.raw/*39.73*/("""
        """),format.raw/*40.57*/("""
        """),format.raw/*41.72*/("""
        """),format.raw/*42.55*/("""
        """),format.raw/*43.57*/("""
        """),format.raw/*44.151*/("""
        """),format.raw/*45.43*/("""
        """),format.raw/*46.57*/("""
        """),format.raw/*47.151*/("""
        """),format.raw/*48.43*/("""
        """),format.raw/*49.57*/("""
        """),format.raw/*50.139*/("""
        """),format.raw/*51.43*/("""
        """),format.raw/*52.57*/("""
        """),format.raw/*53.151*/("""
        """),format.raw/*54.43*/("""
        """),format.raw/*55.57*/("""
        """),format.raw/*56.151*/("""
        """),format.raw/*57.43*/("""
        """),format.raw/*58.39*/("""
        """),format.raw/*59.55*/("""
        """),format.raw/*60.57*/("""
        """),format.raw/*61.112*/("""
        """),format.raw/*62.43*/("""
        """),format.raw/*63.39*/("""
        """),format.raw/*64.35*/("""
        """),format.raw/*65.31*/("""
        """),format.raw/*66.27*/("""
        """),format.raw/*67.52*/("""
        """),format.raw/*68.43*/("""
        """),format.raw/*69.48*/("""
        """),format.raw/*70.173*/("""
        """),format.raw/*71.59*/("""
        """),format.raw/*72.181*/("""
        """),format.raw/*73.43*/("""
        """),format.raw/*74.51*/("""
        """),format.raw/*75.64*/("""
        """),format.raw/*76.105*/("""
        """),format.raw/*77.110*/("""
        """),format.raw/*78.138*/("""
        """),format.raw/*79.113*/("""
        """),format.raw/*80.47*/("""
        """),format.raw/*81.150*/("""
        """),format.raw/*82.43*/("""
        """),format.raw/*83.39*/("""
        """),format.raw/*84.35*/("""
        """),format.raw/*85.31*/("""
        """),format.raw/*86.43*/("""
        """),format.raw/*87.48*/("""
        """),format.raw/*88.173*/("""
        """),format.raw/*89.59*/("""
        """),format.raw/*90.180*/("""
        """),format.raw/*91.43*/("""
        """),format.raw/*92.51*/("""
        """),format.raw/*93.64*/("""
        """),format.raw/*94.105*/("""
        """),format.raw/*95.110*/("""
        """),format.raw/*96.138*/("""
        """),format.raw/*97.113*/("""
        """),format.raw/*98.113*/("""
        """),format.raw/*99.47*/("""
        """),format.raw/*100.167*/("""
        """),format.raw/*101.43*/("""
        """),format.raw/*102.39*/("""
        """),format.raw/*103.35*/("""
        """),format.raw/*104.31*/("""
        """),format.raw/*105.43*/("""
        """),format.raw/*106.48*/("""
        """),format.raw/*107.173*/("""
        """),format.raw/*108.59*/("""
        """),format.raw/*109.177*/("""
        """),format.raw/*110.43*/("""
        """),format.raw/*111.51*/("""
        """),format.raw/*112.64*/("""
        """),format.raw/*113.105*/("""
        """),format.raw/*114.110*/("""
        """),format.raw/*115.138*/("""
        """),format.raw/*116.113*/("""
        """),format.raw/*117.47*/("""
        """),format.raw/*118.141*/("""
        """),format.raw/*119.43*/("""
        """),format.raw/*120.39*/("""
        """),format.raw/*121.35*/("""
        """),format.raw/*122.31*/("""
        """),format.raw/*123.43*/("""
        """),format.raw/*124.48*/("""
        """),format.raw/*125.173*/("""
        """),format.raw/*126.59*/("""
        """),format.raw/*127.176*/("""
        """),format.raw/*128.43*/("""
        """),format.raw/*129.51*/("""
        """),format.raw/*130.64*/("""
        """),format.raw/*131.105*/("""
        """),format.raw/*132.110*/("""
        """),format.raw/*133.138*/("""
        """),format.raw/*134.113*/("""
        """),format.raw/*135.113*/("""
        """),format.raw/*136.47*/("""
        """),format.raw/*137.142*/("""
        """),format.raw/*138.43*/("""
        """),format.raw/*139.39*/("""
        """),format.raw/*140.35*/("""
        """),format.raw/*141.31*/("""
        """),format.raw/*142.43*/("""
        """),format.raw/*143.48*/("""
        """),format.raw/*144.173*/("""
        """),format.raw/*145.51*/("""
        """),format.raw/*146.177*/("""
        """),format.raw/*147.43*/("""
        """),format.raw/*148.51*/("""
        """),format.raw/*149.64*/("""
        """),format.raw/*150.105*/("""
        """),format.raw/*151.110*/("""
        """),format.raw/*152.138*/("""
        """),format.raw/*153.113*/("""
        """),format.raw/*154.47*/("""
        """),format.raw/*155.141*/("""
        """),format.raw/*156.43*/("""
        """),format.raw/*157.39*/("""
        """),format.raw/*158.35*/("""
        """),format.raw/*159.31*/("""
        """),format.raw/*160.43*/("""
        """),format.raw/*161.48*/("""
        """),format.raw/*162.173*/("""
        """),format.raw/*163.51*/("""
        """),format.raw/*164.176*/("""
        """),format.raw/*165.43*/("""
        """),format.raw/*166.51*/("""
        """),format.raw/*167.64*/("""
        """),format.raw/*168.105*/("""
        """),format.raw/*169.110*/("""
        """),format.raw/*170.138*/("""
        """),format.raw/*171.113*/("""
        """),format.raw/*172.113*/("""
        """),format.raw/*173.47*/("""
        """),format.raw/*174.142*/("""
        """),format.raw/*175.43*/("""
        """),format.raw/*176.39*/("""
        """),format.raw/*177.35*/("""
        """),format.raw/*178.31*/("""
        """),format.raw/*179.27*/("""
        """),format.raw/*180.83*/("""

    """),format.raw/*182.5*/("""</div>
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
                  DATE: Mon Sep 22 17:07:59 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPageTelco/LandingPage_client.scala.html
                  HASH: 6183eea4617e9bbb6030b4796daaf3d7e0d1ce90
                  MATRIX: 1060->0|1251->165|1313->207|1359->330|1394->339|1588->506|1603->512|1683->570|1833->693|1848->699|1928->757|2077->879|2092->885|2172->943|2323->1067|2338->1073|2418->1131|2568->1254|2583->1260|2663->1318|2814->1442|2829->1448|2909->1506|3061->1631|3076->1637|3157->1696|3308->1820|3323->1826|3404->1885|3555->2009|3570->2015|3651->2074|3761->2220|3798->2277|3835->2349|3872->2404|3909->2461|3947->2612|3984->2655|4021->2712|4059->2863|4096->2906|4133->2963|4171->3102|4208->3145|4245->3202|4283->3353|4320->3396|4357->3453|4395->3604|4432->3647|4469->3686|4506->3741|4543->3798|4581->3910|4618->3953|4655->3992|4692->4027|4729->4058|4766->4085|4803->4137|4840->4180|4877->4228|4915->4401|4952->4460|4990->4641|5027->4684|5064->4735|5101->4799|5139->4904|5177->5014|5215->5152|5253->5265|5290->5312|5328->5462|5365->5505|5402->5544|5439->5579|5476->5610|5513->5653|5550->5701|5588->5874|5625->5933|5663->6113|5700->6156|5737->6207|5774->6271|5812->6376|5850->6486|5888->6624|5926->6737|5964->6850|6001->6897|6040->7064|6078->7107|6116->7146|6154->7181|6192->7212|6230->7255|6268->7303|6307->7476|6345->7535|6384->7712|6422->7755|6460->7806|6498->7870|6537->7975|6576->8085|6615->8223|6654->8336|6692->8383|6731->8524|6769->8567|6807->8606|6845->8641|6883->8672|6921->8715|6959->8763|6998->8936|7036->8995|7075->9171|7113->9214|7151->9265|7189->9329|7228->9434|7267->9544|7306->9682|7345->9795|7384->9908|7422->9955|7461->10097|7499->10140|7537->10179|7575->10214|7613->10245|7651->10288|7689->10336|7728->10509|7766->10560|7805->10737|7843->10780|7881->10831|7919->10895|7958->11000|7997->11110|8036->11248|8075->11361|8113->11408|8152->11549|8190->11592|8228->11631|8266->11666|8304->11697|8342->11740|8380->11788|8419->11961|8457->12012|8496->12188|8534->12231|8572->12282|8610->12346|8649->12451|8688->12561|8727->12699|8766->12812|8805->12925|8843->12972|8882->13114|8920->13157|8958->13196|8996->13231|9034->13262|9072->13289|9110->13372|9144->13378
                  LINES: 33->1|36->4|36->4|37->5|38->6|42->10|42->10|42->10|45->13|45->13|45->13|48->16|48->16|48->16|51->19|51->19|51->19|54->22|54->22|54->22|57->25|57->25|57->25|61->29|61->29|61->29|64->32|64->32|64->32|67->35|67->35|67->35|71->39|72->40|73->41|74->42|75->43|76->44|77->45|78->46|79->47|80->48|81->49|82->50|83->51|84->52|85->53|86->54|87->55|88->56|89->57|90->58|91->59|92->60|93->61|94->62|95->63|96->64|97->65|98->66|99->67|100->68|101->69|102->70|103->71|104->72|105->73|106->74|107->75|108->76|109->77|110->78|111->79|112->80|113->81|114->82|115->83|116->84|117->85|118->86|119->87|120->88|121->89|122->90|123->91|124->92|125->93|126->94|127->95|128->96|129->97|130->98|131->99|132->100|133->101|134->102|135->103|136->104|137->105|138->106|139->107|140->108|141->109|142->110|143->111|144->112|145->113|146->114|147->115|148->116|149->117|150->118|151->119|152->120|153->121|154->122|155->123|156->124|157->125|158->126|159->127|160->128|161->129|162->130|163->131|164->132|165->133|166->134|167->135|168->136|169->137|170->138|171->139|172->140|173->141|174->142|175->143|176->144|177->145|178->146|179->147|180->148|181->149|182->150|183->151|184->152|185->153|186->154|187->155|188->156|189->157|190->158|191->159|192->160|193->161|194->162|195->163|196->164|197->165|198->166|199->167|200->168|201->169|202->170|203->171|204->172|205->173|206->174|207->175|208->176|209->177|210->178|211->179|212->180|214->182
                  -- GENERATED --
              */
          