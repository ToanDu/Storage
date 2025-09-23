
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

object LandingPage_Sanpham extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="section features-1" id="divSanpham">
    <div class="container">
        <div class="col-md-12 mx-auto text-center">
            <p class="value">"""),_display_(/*4.31*/Messages("landingPageTelco.sanpham.iotProducts")),format.raw/*4.79*/("""</p>
            <h3 class="display-3 title-section-1">"""),_display_(/*5.52*/Messages("landingPageTelco.sanpham.diverseProducts")),format.raw/*5.104*/("""</h3>
        </div>
        <div class="wp-slider">
            <div class="owl-carousel mt-4">
                <div class="item" data-bs-interval="5000">
                    <div class="col-md-3">
                        <div class="card card-blue text-center card1-listProject">
                            <div class="alignItemCenter mt-3">
                                <img src=""""),_display_(/*13.44*/routes/*13.50*/.Assets.versioned("images/landingPageTelco/Pict_6.jpg")),format.raw/*13.105*/("""" width="" class="img-sp">
                            </div>
                            <div class="text mt-3">
                                <h4 class="sp-title-2">"""),_display_(/*16.57*/Messages("landingPageTelco.sanpham.smartTracking")),format.raw/*16.107*/("""</h4>
                                <p class="mt-3">"""),_display_(/*17.50*/Messages("landingPageTelco.sanpham.vTag")),format.raw/*17.91*/("""</p>
                                <div class="">
                                    <a href="https://viettel.vn/vtag" rel="nofollow" target="_blank"  class="btn btn-danger-2" style="color: #EA0033;top: 2rem;">"""),_display_(/*19.163*/Messages("landingPageTelco.sanpham.viewDetails")),format.raw/*19.211*/("""</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item" data-bs-interval="5000">
                    <div class="col-md-3" >
                        <div class="card card-blue text-center card1-listProject">
                            <div class="alignItemCenter mt-3">
                                <img src=""""),_display_(/*29.44*/routes/*29.50*/.Assets.versioned("images/landingPageTelco/Pict_9.jpg")),format.raw/*29.105*/("""" width="" class="img-sp">
                            </div>
                            <div class="text mt-3">
                                <h4 class="sp-title-2">"""),_display_(/*32.57*/Messages("landingPageTelco.sanpham.smartWatch")),format.raw/*32.104*/("""</h4>
                                <p class="mt-3">"""),_display_(/*33.50*/Messages("landingPageTelco.sanpham.myKid")),format.raw/*33.92*/("""</p>
                                <div class="">
                                    <a class="btn btn-danger-2" style="margin-top: 2rem;" href="https://mykid.viettel.vn/" rel="nofollow" target="_blank" style="color: #EA0033;">"""),_display_(/*35.180*/Messages("landingPageTelco.sanpham.viewDetails")),format.raw/*35.228*/("""</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item" data-bs-interval="5000">
                    <div class="col-md-3">
                        <div class="card card-blue text-center card1-listProject">
                            <div class="alignItemCenter mt-3">
                                <img src=""""),_display_(/*45.44*/routes/*45.50*/.Assets.versioned("images/landingPageTelco/Pict_8.jpg")),format.raw/*45.105*/("""" width="" class="img-sp">
                            </div>
                            <div class="text mt-3">
                                <h4 class="sp-title-2">"""),_display_(/*48.57*/Messages("landingPageTelco.sanpham.smartCar")),format.raw/*48.102*/("""</h4>
                                <p class="mt-3">"""),_display_(/*49.50*/Messages("landingPageTelco.sanpham.vcar")),format.raw/*49.91*/("""</p>
                                <div class="">
                                    <a class="btn btn-danger-2" href="https://viettel.vn/vcar" rel="nofollow" target="_blank" style="color: #EA0033;top: 2rem;">"""),_display_(/*51.162*/Messages("landingPageTelco.sanpham.viewDetails")),format.raw/*51.210*/("""</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item" data-bs-interval="5000">
                    <div class="col-md-3" >
                        <div class="card card-blue text-center card1-listProject">
                            <div class="alignItemCenter mt-3">
                                <img src=""""),_display_(/*61.44*/routes/*61.50*/.Assets.versioned("images/landingPageTelco/Pict_7.jpg")),format.raw/*61.105*/("""" width="" class="img-sp">
                            </div>

                            <div class="text mt-3">
                                <h4 class="sp-title-2">"""),_display_(/*65.57*/Messages("landingPageTelco.sanpham.assetManagement")),format.raw/*65.109*/("""</h4>
                                <p class="mt-3">"""),_display_(/*66.50*/Messages("landingPageTelco.sanpham.smartMotor")),format.raw/*66.97*/("""</p>
                                <div class="">
                                    <a href="https://smartmotor.vn/" rel="nofollow" target="_blank" class="btn btn-danger-2"  style="color: #EA0033;top: 2rem;">"""),_display_(/*68.162*/Messages("landingPageTelco.sanpham.viewDetails")),format.raw/*68.210*/("""</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item" data-bs-interval="5000" >
                    <div class="col-md-3" >
                        <div class="card card-blue text-center card1-listProject">
                            <div class="alignItemCenter mt-3">
                                <img src=""""),_display_(/*78.44*/routes/*78.50*/.Assets.versioned("images/landingPageTelco/Pict_7.jpg")),format.raw/*78.105*/("""" width="" class="img-sp">
                            </div>

                            <div class="text mt-3">
                                <h4 class="sp-title-2">"""),_display_(/*82.57*/Messages("landingPageTelco.sanpham.assetManagement")),format.raw/*82.109*/("""</h4>
                                <p class="mt-3">"""),_display_(/*83.50*/Messages("landingPageTelco.sanpham.vTrackingCar")),format.raw/*83.99*/("""</p>
                                <div class="">
                                    <a href="https://vtracking.viettel.vn/" rel="nofollow" target="_blank" class="btn btn-danger-2"  style="color: #EA0033;top: 38px;">"""),_display_(/*85.169*/Messages("landingPageTelco.sanpham.viewDetails")),format.raw/*85.217*/("""</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item" data-bs-interval="5000">
                    <div class="col-md-3" >
                        <div class="card card-blue text-center card1-listProject">
                            <div class="alignItemCenter mt-3">
                                <img src=""""),_display_(/*95.44*/routes/*95.50*/.Assets.versioned("images/landingPageTelco/Pict_13.jpg")),format.raw/*95.106*/("""" width="" class="img-sp">
                            </div>
                            <div class="text mt-3">
                                <h4 class="sp-title-2">"""),_display_(/*98.57*/Messages("landingPageTelco.sanpham.personalHealth")),format.raw/*98.108*/("""</h4>
                                <p class="mt-3">"""),_display_(/*99.50*/Messages("landingPageTelco.sanpham.vHealth")),format.raw/*99.94*/("""</p>
                            </div>
                            <div class="">
                                <a class="btn btn-danger-2"  style="color: #EA0033; height: 42px; top: 40px;font-weight: 700;font-size: 15px;">"""),_display_(/*102.145*/Messages("landingPageTelco.sanpham.inDevelopment")),format.raw/*102.195*/("""</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item" data-bs-interval="5000">
                    <div class="col-md-3" >
                        <div class="card card-blue text-center card1-listProject">
                            <div class="alignItemCenter mt-3">
                                <img src=""""),_display_(/*111.44*/routes/*111.50*/.Assets.versioned("images/landingPageTelco/Pict_15.jpg")),format.raw/*111.106*/("""" width="" class="img-sp">
                            </div>
                            <div class="text mt-3">
                                <h4 class="sp-title-2">"""),_display_(/*114.57*/Messages("landingPageTelco.sanpham.smartOffice")),format.raw/*114.105*/("""</h4>
                                <p class="mt-3">"""),_display_(/*115.50*/Messages("landingPageTelco.sanpham.cameraAl")),format.raw/*115.95*/("""</p>
                            </div>
                            <div class="">
                                <a class="btn btn-danger-2"  style="color: #EA0033; height: 42px; top: 40px; font-weight: 700;font-size: 15px;">"""),_display_(/*118.146*/Messages("landingPageTelco.sanpham.inDevelopment")),format.raw/*118.196*/("""</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item" data-bs-interval="5000">
                    <div class="col-md-3" >
                        <div class="card card-blue text-center card1-listProject">
                            <div class="alignItemCenter mt-3">
                                <img src=""""),_display_(/*127.44*/routes/*127.50*/.Assets.versioned("images/landingPageTelco/Pict_11.jpg")),format.raw/*127.106*/("""" width="" class="img-sp">
                            </div>
                            <div class="text mt-3">
                                <h4 class="sp-title-2">"""),_display_(/*130.57*/Messages("landingPageTelco.sanpham.smartApartment")),format.raw/*130.108*/("""</h4>
                                <p class="mt-3">"""),_display_(/*131.50*/Messages("landingPageTelco.sanpham.homeCamera")),format.raw/*131.97*/("""</p>
                            </div>
                            <div class="">
                                <a class="btn btn-danger-2"  style="color: #EA0033; height: 42px; top: 40px; font-weight: 700;font-size: 15px;">"""),_display_(/*134.146*/Messages("landingPageTelco.sanpham.inDevelopment")),format.raw/*134.196*/("""</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 18:18:26 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/landingPageTelco/LandingPage_Sanpham.scala.html
                  HASH: d5f548c6d9c4e43da99e1fef804f9bc9288f8c3f
                  MATRIX: 1061->0|1246->159|1314->207|1396->263|1469->315|1884->703|1899->709|1976->764|2173->934|2245->984|2327->1039|2389->1080|2631->1294|2701->1342|3180->1794|3195->1800|3272->1855|3469->2025|3538->2072|3620->2127|3683->2169|3942->2400|4012->2448|4490->2899|4505->2905|4582->2960|4779->3130|4846->3175|4928->3230|4990->3271|5231->3484|5301->3532|5780->3984|5795->3990|5872->4045|6070->4216|6144->4268|6226->4323|6294->4370|6535->4583|6605->4631|7085->5084|7100->5090|7177->5145|7375->5316|7449->5368|7531->5423|7601->5472|7849->5692|7919->5740|8398->6192|8413->6198|8491->6254|8688->6424|8761->6475|8843->6530|8908->6574|9164->6801|9237->6851|9678->7264|9694->7270|9773->7326|9971->7496|10042->7544|10125->7599|10192->7644|10449->7872|10522->7922|10963->8335|10979->8341|11058->8397|11256->8567|11330->8618|11413->8673|11482->8720|11739->8948|11812->8998
                  LINES: 33->1|36->4|36->4|37->5|37->5|45->13|45->13|45->13|48->16|48->16|49->17|49->17|51->19|51->19|61->29|61->29|61->29|64->32|64->32|65->33|65->33|67->35|67->35|77->45|77->45|77->45|80->48|80->48|81->49|81->49|83->51|83->51|93->61|93->61|93->61|97->65|97->65|98->66|98->66|100->68|100->68|110->78|110->78|110->78|114->82|114->82|115->83|115->83|117->85|117->85|127->95|127->95|127->95|130->98|130->98|131->99|131->99|134->102|134->102|143->111|143->111|143->111|146->114|146->114|147->115|147->115|150->118|150->118|159->127|159->127|159->127|162->130|162->130|163->131|163->131|166->134|166->134
                  -- GENERATED --
              */
          