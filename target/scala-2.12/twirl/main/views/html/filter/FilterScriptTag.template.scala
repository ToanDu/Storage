
package views.html.filter

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
/*1.2*/import vn.m2m.common.models.forms.SearchFilterForm
/*2.2*/import vn.m2m.utils.SearchUtil

object FilterScriptTag extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[SearchFilterForm,List[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(searchFilterForm:SearchFilterForm, searchFieldArray: List[String] ):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.70*/("""


"""),format.raw/*6.1*/("""<script>

    $(function () """),format.raw/*8.19*/("""{"""),format.raw/*8.20*/("""
        """),format.raw/*9.9*/("""$(document).on('keyup keydown keypress', function (event) """),format.raw/*9.67*/("""{"""),format.raw/*9.68*/("""
            """),format.raw/*10.13*/("""if (event.keyCode == 116) """),format.raw/*10.39*/("""{"""),format.raw/*10.40*/("""
                """),format.raw/*11.17*/("""console.log("Enter F5 pressed");
//                window.location.reload(true);

            """),format.raw/*14.13*/("""}"""),format.raw/*14.14*/("""
            """),format.raw/*15.13*/("""else """),format.raw/*15.18*/("""{"""),format.raw/*15.19*/("""
"""),format.raw/*16.1*/("""//                alert("Not Enter key pressed");
            """),format.raw/*17.13*/("""}"""),format.raw/*17.14*/("""

        """),format.raw/*19.9*/("""}"""),format.raw/*19.10*/(""");
    """),format.raw/*20.5*/("""}"""),format.raw/*20.6*/(""");

    $('#filter-add-selectpicker').on('changed.bs.select', function (e, clickedIndex, isSelected, previousValue) """),format.raw/*22.113*/("""{"""),format.raw/*22.114*/("""
        """),format.raw/*23.9*/("""console.log("filter-add-selectpicker: "+array_list[clickedIndex]);
        if (clickedIndex < array_list.length)"""),format.raw/*24.46*/("""{"""),format.raw/*24.47*/("""
            """),format.raw/*25.13*/("""ChangeFilterValue(array_list[clickedIndex])
        """),format.raw/*26.9*/("""}"""),format.raw/*26.10*/("""else if (clickedIndex == array_list.length)"""),format.raw/*26.53*/("""{"""),format.raw/*26.54*/("""
            """),format.raw/*27.13*/("""onAdvancedSearch(isSelected)
        """),format.raw/*28.9*/("""}"""),format.raw/*28.10*/("""

    """),format.raw/*30.5*/("""}"""),format.raw/*30.6*/(""");

    $('.conditionOptionValue').on('changed.bs.select', function (e, clickedIndex, isSelected, previousValue) """),format.raw/*32.110*/("""{"""),format.raw/*32.111*/("""
        """),format.raw/*33.9*/("""if( e.target.id) """),format.raw/*33.26*/("""{"""),format.raw/*33.27*/("""
            """),format.raw/*34.13*/("""// console.log("conditionOptionValue: "+e.target.id+" - "+clickedIndex);
            // console.log("conditionOptionValue: "+$('.conditionOptionValue').selectpicker('val'));
            var targetIdArr = e.target.id.split("-");
            if ($('.conditionOptionValue').selectpicker('val') == """"),_display_(/*37.69*/SearchUtil/*37.79*/.SEARCH_BETWEEN_OP_STRING),format.raw/*37.104*/("""")"""),format.raw/*37.106*/("""{"""),format.raw/*37.107*/("""
                """),format.raw/*38.17*/("""showBetween("rightBetween-"+targetIdArr[targetIdArr.length-1],true)
            """),format.raw/*39.13*/("""}"""),format.raw/*39.14*/("""else"""),format.raw/*39.18*/("""{"""),format.raw/*39.19*/("""
                """),format.raw/*40.17*/("""showBetween("rightBetween-"+targetIdArr[targetIdArr.length-1],false)
            """),format.raw/*41.13*/("""}"""),format.raw/*41.14*/("""
        """),format.raw/*42.9*/("""}"""),format.raw/*42.10*/("""
    """),format.raw/*43.5*/("""}"""),format.raw/*43.6*/(""");



//    $('.datetimepicker').datetimepicker("""),format.raw/*47.43*/("""{"""),format.raw/*47.44*/("""
"""),format.raw/*48.1*/("""//        format:"DD/MM/YYYY HH:mm",
//        sideBySide:true,
//        icons: """),format.raw/*50.18*/("""{"""),format.raw/*50.19*/("""
"""),format.raw/*51.1*/("""//            time: "fa fa-clock-o",
//            date: "fa fa-calendar",
//            up: "fa fa-chevron-up",
//            down: "fa fa-chevron-down",
//            previous: 'fa fa-chevron-left',
//            next: 'fa fa-chevron-right',
//            today: 'fa fa-screenshot',
//            clear: 'fa fa-trash',
//            close: 'fa fa-remove',
//        """),format.raw/*60.11*/("""}"""),format.raw/*60.12*/(""",
//    """),format.raw/*61.7*/("""}"""),format.raw/*61.8*/(""");

    //Init value
    var array_list=[];
    """),_display_(/*65.6*/for((item, index) <- searchFieldArray.zipWithIndex) yield /*65.57*/ {_display_(Seq[Any](format.raw/*65.59*/("""
        """),_display_(/*66.10*/if(index % 2 == 1)/*66.28*/ {_display_(Seq[Any](format.raw/*66.30*/("""
            """),format.raw/*67.13*/("""array_list.push('"""),_display_(/*67.31*/item),format.raw/*67.35*/("""');
        """)))}),format.raw/*68.10*/("""
    """)))}),format.raw/*69.6*/("""

    """),_display_(/*71.6*/for((item, index) <- searchFieldArray.zipWithIndex) yield /*71.57*/ {_display_(Seq[Any](format.raw/*71.59*/("""
        """),_display_(/*72.10*/if(item.equals("Date"))/*72.33*/ {_display_(Seq[Any](format.raw/*72.35*/("""
            """),format.raw/*73.13*/("""$('#dateFrom'+'"""),_display_(/*73.29*/searchFieldArray(index+1)),format.raw/*73.54*/("""').on("dp.change", function(e) """),format.raw/*73.85*/("""{"""),format.raw/*73.86*/("""
                """),format.raw/*74.17*/("""$(  '#dateTo'+'"""),_display_(/*74.33*/searchFieldArray(index+1)),format.raw/*74.58*/("""'  ).data("DateTimePicker").date(e.date);
                $(  '#dateTo'+'"""),_display_(/*75.33*/searchFieldArray(index+1)),format.raw/*75.58*/("""' ).data("DateTimePicker").minDate(e.date);
            """),format.raw/*76.13*/("""}"""),format.raw/*76.14*/(""");
        """)))}),format.raw/*77.10*/("""
    """)))}),format.raw/*78.6*/("""

    """),format.raw/*80.5*/("""$().ready(function()"""),format.raw/*80.25*/("""{"""),format.raw/*80.26*/("""
        """),format.raw/*81.9*/("""//init value for search;
        """),_display_(/*82.10*/if(searchFilterForm.getFilter != null)/*82.48*/ {_display_(Seq[Any](format.raw/*82.50*/("""
            """),_display_(/*83.14*/for(filter <- searchFilterForm.getFilter) yield /*83.55*/ {_display_(Seq[Any](format.raw/*83.57*/("""
                """),format.raw/*84.17*/("""current_array_list.push('"""),_display_(/*84.43*/filter),format.raw/*84.49*/("""');
            """)))}),format.raw/*85.14*/("""
        """)))}),format.raw/*86.10*/("""
        """),_display_(/*87.10*/if(searchFilterForm.isResetCondition)/*87.47*/ {_display_(Seq[Any](format.raw/*87.49*/("""
            """),format.raw/*88.13*/("""current_array_list=[];
            for(i=0; i<array_list.length ; i++)"""),format.raw/*89.48*/("""{"""),format.raw/*89.49*/("""
                """),format.raw/*90.17*/("""current_array_list.push(array_list[i]);
            """),format.raw/*91.13*/("""}"""),format.raw/*91.14*/("""
            """),format.raw/*92.13*/("""$('body').resetValue();
        """)))}),format.raw/*93.10*/("""
        """),format.raw/*94.9*/("""InitValue();
//        $('.DateOption').change(); //Trigger change
    """),format.raw/*96.5*/("""}"""),format.raw/*96.6*/(""");

    function ApplyFilter(page, pageSize, isResetPage) """),format.raw/*98.55*/("""{"""),format.raw/*98.56*/("""
        """),format.raw/*99.9*/("""console.log("page: "+page);
        console.log("pageSize: "+pageSize);
        console.log("isResetPage: "+isResetPage);

        $('[name=page]').val(page);
        $('[name=pageSize]').val(pageSize );
        $('[name=isResetPage]').val(isResetPage );
        //$('[name=filter]').val(current_array_list );
        $('#ChooseFilter').val(current_array_list );
        console.log("ChooseFilter: "+$('#ChooseFilter').val());

        $('#search-filter-form').submit();
    """),format.raw/*111.5*/("""}"""),format.raw/*111.6*/("""
    """),format.raw/*112.5*/("""var applyButton = document.getElementById('ApplyFilter');

    function showAdminFilter()"""),format.raw/*114.31*/("""{"""),format.raw/*114.32*/("""
        """),format.raw/*115.9*/("""$("#search-filter-body").show();
        $("#advanced-search-filterToolbar").show();
        $("#aShowAdminFilter").attr("onclick","hideAdminFilter()");
        $("#aShowAdminFilter2").attr("onclick","hideAdminFilter()");
        $("#aShowAdminFilter2").text(Messages("Admin.collapse"));
    """),format.raw/*120.5*/("""}"""),format.raw/*120.6*/("""
    """),format.raw/*121.5*/("""function hideAdminFilter()"""),format.raw/*121.31*/("""{"""),format.raw/*121.32*/("""
        """),format.raw/*122.9*/("""$("#search-filter-body").hide();
        $("#advanced-search-filterToolbar").hide();
        $("#aShowAdminFilter").attr("onclick","showAdminFilter()");
        $("#aShowAdminFilter2").attr("onclick","showAdminFilter()");
        $("#aShowAdminFilter2").text(Messages("Admin.expande"));
    """),format.raw/*127.5*/("""}"""),format.raw/*127.6*/("""

    """),format.raw/*129.5*/("""//    $(document).keypress(function(event) """),format.raw/*129.48*/("""{"""),format.raw/*129.49*/("""
    """),format.raw/*130.5*/("""//        if (event.keyCode == 13) """),format.raw/*130.40*/("""{"""),format.raw/*130.41*/("""
    """),format.raw/*131.5*/("""//            event.preventDefault();
    //            applyButton.click();
    //        """),format.raw/*133.15*/("""}"""),format.raw/*133.16*/("""
    """),format.raw/*134.5*/("""//    """),format.raw/*134.11*/("""}"""),format.raw/*134.12*/(""");


</script>
"""))
      }
    }
  }

  def render(searchFilterForm:SearchFilterForm,searchFieldArray:List[String]): play.twirl.api.HtmlFormat.Appendable = apply(searchFilterForm,searchFieldArray)

  def f:((SearchFilterForm,List[String]) => play.twirl.api.HtmlFormat.Appendable) = (searchFilterForm,searchFieldArray) => apply(searchFilterForm,searchFieldArray)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 16:32:41 ICT 2025
                  SOURCE: D:/VHT_Projects/cmp-fe-dev-dev_multiLang/app/views/filter/FilterScriptTag.scala.html
                  HASH: ac493905cc0c93809eaf7dd8002ea3df1387070b
                  MATRIX: 658->1|716->53|1084->85|1247->153|1276->156|1331->184|1359->185|1394->194|1479->252|1507->253|1548->266|1602->292|1631->293|1676->310|1798->404|1827->405|1868->418|1901->423|1930->424|1958->425|2048->487|2077->488|2114->498|2143->499|2177->506|2205->507|2350->623|2380->624|2416->633|2556->745|2585->746|2626->759|2705->811|2734->812|2805->855|2834->856|2875->869|2939->906|2968->907|3001->913|3029->914|3171->1027|3201->1028|3237->1037|3282->1054|3311->1055|3352->1068|3675->1364|3694->1374|3741->1399|3772->1401|3802->1402|3847->1419|3955->1499|3984->1500|4016->1504|4045->1505|4090->1522|4199->1603|4228->1604|4264->1613|4293->1614|4325->1619|4353->1620|4429->1668|4458->1669|4486->1670|4595->1751|4624->1752|4652->1753|5048->2121|5077->2122|5112->2130|5140->2131|5215->2180|5282->2231|5322->2233|5359->2243|5386->2261|5426->2263|5467->2276|5512->2294|5537->2298|5581->2311|5617->2317|5650->2324|5717->2375|5757->2377|5794->2387|5826->2410|5866->2412|5907->2425|5950->2441|5996->2466|6055->2497|6084->2498|6129->2515|6172->2531|6218->2556|6319->2630|6365->2655|6449->2711|6478->2712|6521->2724|6557->2730|6590->2736|6638->2756|6667->2757|6703->2766|6764->2800|6811->2838|6851->2840|6892->2854|6949->2895|6989->2897|7034->2914|7087->2940|7114->2946|7162->2963|7203->2973|7240->2983|7286->3020|7326->3022|7367->3035|7465->3105|7494->3106|7539->3123|7619->3175|7648->3176|7689->3189|7753->3222|7789->3231|7887->3302|7915->3303|8001->3361|8030->3362|8066->3371|8569->3846|8598->3847|8631->3852|8749->3941|8779->3942|8816->3951|9136->4243|9165->4244|9198->4249|9253->4275|9283->4276|9320->4285|9639->4576|9668->4577|9702->4583|9774->4626|9804->4627|9837->4632|9901->4667|9931->4668|9964->4673|10084->4764|10114->4765|10147->4770|10182->4776|10212->4777
                  LINES: 24->1|25->2|30->3|35->3|38->6|40->8|40->8|41->9|41->9|41->9|42->10|42->10|42->10|43->11|46->14|46->14|47->15|47->15|47->15|48->16|49->17|49->17|51->19|51->19|52->20|52->20|54->22|54->22|55->23|56->24|56->24|57->25|58->26|58->26|58->26|58->26|59->27|60->28|60->28|62->30|62->30|64->32|64->32|65->33|65->33|65->33|66->34|69->37|69->37|69->37|69->37|69->37|70->38|71->39|71->39|71->39|71->39|72->40|73->41|73->41|74->42|74->42|75->43|75->43|79->47|79->47|80->48|82->50|82->50|83->51|92->60|92->60|93->61|93->61|97->65|97->65|97->65|98->66|98->66|98->66|99->67|99->67|99->67|100->68|101->69|103->71|103->71|103->71|104->72|104->72|104->72|105->73|105->73|105->73|105->73|105->73|106->74|106->74|106->74|107->75|107->75|108->76|108->76|109->77|110->78|112->80|112->80|112->80|113->81|114->82|114->82|114->82|115->83|115->83|115->83|116->84|116->84|116->84|117->85|118->86|119->87|119->87|119->87|120->88|121->89|121->89|122->90|123->91|123->91|124->92|125->93|126->94|128->96|128->96|130->98|130->98|131->99|143->111|143->111|144->112|146->114|146->114|147->115|152->120|152->120|153->121|153->121|153->121|154->122|159->127|159->127|161->129|161->129|161->129|162->130|162->130|162->130|163->131|165->133|165->133|166->134|166->134|166->134
                  -- GENERATED --
              */
          