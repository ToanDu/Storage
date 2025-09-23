
package views.html.iot.dashboard

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

object Dashboard_body extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="page-wrapper">
    <div class="page-content">

        <div class="card radius-10 ">
            <div class="row row-cols-1 row-cols-md-2 row-cols-xl-4 row-group g-0">
                <div class="col">
                    <div class="card bg-transparent shadow-none mb-0">
                        <div class="card-body text-center">
                            <p class="mb-1 text-dark">"""),_display_(/*9.56*/Messages("dashboard.totalUser")),format.raw/*9.87*/("""</p>
                            <h3 class="mb-3 text-dark" id="totalUserHeader">0</h3>
                            <p class="font-13 text-light-2"><span class="text-info"><i class="lni lni-arrow-up"></i>2.1% vs last 7 days</span></p>
                            <div id="chart1"></div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card bg-transparent shadow-none mb-0">
                        <div class="card-body text-center">
                            <p class="mb-1 text-dark">"""),_display_(/*19.56*/Messages("dashboard.totalDevice")),format.raw/*19.89*/("""</p>
                            <h3 class="mb-3 text-dark" id="totalDeviceHeader">0</h3>
                            <p class="font-13 text-light-2"><span class="text-info"><i class="lni lni-arrow-up"></i> 4.2% last 7 days</span></p>
                            <div id="chart2"></div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card bg-transparent shadow-none mb-0">
                        <div class="card-body text-center">
                            <p class="mb-1 text-dark">"""),_display_(/*29.56*/Messages("dashboard.totalMessage")),format.raw/*29.90*/("""</p>
                            <h3 class="mb-3 text-dark" id="totalMessageHeader">0</h3>
                            <p class="font-13 text-light-2"><span class="text-danger"><i class="lni lni-arrow-down"></i> 3.6% vs last day</span></p>
                            <div id="chart3"></div>
                        </div>
                    </div>
                </div>
                <div class="col col-md-12">
                    <div class="card bg-transparent shadow-none mb-0">
                        <div class="card-body text-center">
                            <p class="mb-1 text-dark">"""),_display_(/*39.56*/Messages("dashboard.lastDateTracking")),format.raw/*39.94*/("""</p>
                            <h3 class="mb-3 text-dark" id="lastDateTracking">00:04:60</h3>
                            <p class="font-13 text-light-2"><span class="text-danger"><i class="lni lni-arrow-down"></i> 5.2%  vs last 7 days</span></p>
                            <div id="chart5"></div>
                        </div>
                    </div>
                </div>
            </div><!--end row-->
        </div>

        <div class="row">
            <div class="col-12 col-xl-4 d-flex">
                <div class="card radius-10 w-100 ">
                    <div class="card-body">
                        <div class="d-flex align-items-center">
                            <div>
                                <h6 class="mb-0 text-dark">"""),_display_(/*55.61*/Messages("dashboard.map")),format.raw/*55.86*/("""</h6>
                            </div>
                            <div class="font-22 ms-auto text-dark"><i class="bx bx-dots-horizontal-rounded"></i>
                            </div>
                        </div>

                        <div class="">
                            <div id="paper-middle">
                                <div id="map-canvas"></div>
                            </div>
                        </div>
                    </div>
                    """),format.raw/*67.120*/("""
                        """),format.raw/*68.46*/("""
                            """),format.raw/*69.50*/("""
                                """),format.raw/*70.64*/("""
                                """),format.raw/*71.185*/("""
                            """),format.raw/*72.39*/("""
                        """),format.raw/*73.35*/("""
                    """),format.raw/*74.31*/("""
                """),format.raw/*75.17*/("""</div>
            </div>

            <div class="col-12 col-xl-4 d-flex">
                <div class="card radius-10 w-100 ">
                    <div class="card-body">
                        <div class="d-flex align-items-center">
                            <div>
                                <h5 class="mb-0 text-dark">"""),_display_(/*83.61*/Messages("manage.deviceIot.list")),format.raw/*83.94*/("""</h5>
                            </div>
                            <div class="font-22 ms-auto text-dark"><i class='bx bx-dots-horizontal-rounded'></i>
                            </div>
                        </div>
                    </div>
                    <div class="customers-list p-3 mb-3" id="deviceListTable">
                    </div>
                    """),format.raw/*91.120*/("""
                        """),format.raw/*92.46*/("""
                            """),format.raw/*93.50*/("""
                                """),format.raw/*94.81*/("""
                                """),format.raw/*95.150*/("""
                            """),format.raw/*96.39*/("""
                        """),format.raw/*97.35*/("""
                    """),format.raw/*98.31*/("""
                """),format.raw/*99.17*/("""</div>
            </div>

            <div class="col-12 col-xl-4 d-flex">
                <div class="card radius-10 w-100 ">
                    <div class="card-body">
                        <div class="d-flex align-items-center">
                            <div>
                                <h5 class="mb-0 text-dark">"""),_display_(/*107.61*/Messages("dashboard.chart")),format.raw/*107.88*/("""</h5>
                            </div>
                            <div class="font-22 ms-auto text-dark"><i class='bx bx-dots-horizontal-rounded'></i>
                            </div>
                        </div>
                    </div>
                    <div class="customers-list p-3 mb-3" id="hightChartBattery">
                    </div>
                    """),format.raw/*115.120*/("""
                        """),format.raw/*116.46*/("""
                            """),format.raw/*117.50*/("""
                                """),format.raw/*118.81*/("""
                                """),format.raw/*119.150*/("""
                            """),format.raw/*120.39*/("""
                        """),format.raw/*121.35*/("""
                    """),format.raw/*122.31*/("""
                """),format.raw/*123.17*/("""</div>
            </div>
        </div><!--End Row-->




    </div>
</div>
    <!--end page wrapper -->
    <!--start overlay-->
<div class="overlay toggle-icon"></div>
    <!--end overlay-->
    <!--Start Back To Top Button--> <a href="javaScript:;" class="back-to-top"><i class='bx bxs-up-arrow-alt'></i></a>
    <!--End Back To Top Button-->
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
                  DATE: Mon Sep 22 16:32:43 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/iot/dashboard/Dashboard_body.scala.html
                  HASH: ca9a6b3c01049550c5924ef315b1151fb9622ad3
                  MATRIX: 1053->0|1479->400|1530->431|2145->1019|2199->1052|2814->1640|2869->1674|3499->2277|3558->2315|4345->3075|4391->3100|4905->3684|4958->3730|5015->3780|5076->3844|5138->4029|5195->4068|5248->4103|5297->4134|5342->4151|5699->4481|5753->4514|6155->4986|6208->5032|6265->5082|6326->5163|6388->5313|6445->5352|6498->5387|6547->5418|6592->5435|6950->5765|6999->5792|7404->6266|7458->6312|7516->6362|7578->6443|7641->6593|7699->6632|7753->6667|7803->6698|7849->6715
                  LINES: 33->1|41->9|41->9|51->19|51->19|61->29|61->29|71->39|71->39|87->55|87->55|99->67|100->68|101->69|102->70|103->71|104->72|105->73|106->74|107->75|115->83|115->83|123->91|124->92|125->93|126->94|127->95|128->96|129->97|130->98|131->99|139->107|139->107|147->115|148->116|149->117|150->118|151->119|152->120|153->121|154->122|155->123
                  -- GENERATED --
              */
          