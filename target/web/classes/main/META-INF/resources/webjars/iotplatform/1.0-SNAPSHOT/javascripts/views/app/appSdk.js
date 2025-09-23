/**
 * Created by vtk-anhlt166 on 12/7/21.
 */
function changeLinkIos() {
    console.log("changeLinkIos");
    var link = '<a href="http://203.113.138.18:4447/s/r2mdFKfdA28otJt/download" target="_blank"><i class="fa fa-download" style="padding: 0px 5px; border: 1px solid #ccc!important;"></i> '+"Tải tài liệu "+'</a><br>'+
        '<a href="http://203.113.138.18:4447/s/j8GJxdf3js55FsB/download" target="_blank"><i class="fa fa-download" style="padding: 0px 5px; border: 1px solid #ccc!important;"></i> '+"Tải SDK "+'</a><hr>';

    $("#linkDownloadSdk").html(link);

    document.getElementById("imgLogoIos").classList.add("area-ios");
    document.getElementById("imgLogoAndoird").classList.remove("area-android");
}

function changeLinkAndroid() {
    console.log("changeLinkAndroid");
    var link = '<a href="http://203.113.138.18:4447/s/pHfPrTDefaggWP6/download" target="_blank"><i class="fa fa-download" style="padding: 0px 5px; border: 1px solid #ccc!important;"></i> '+"Tải tài liệu "+'</a><br>'+
        '<a href="http://203.113.138.18:4447/s/NifY55TRk5CpFJk/download" target="_blank"><i class="fa fa-download" style="padding: 0px 5px; border: 1px solid #ccc!important;"></i> '+"Tải SDK "+'</a><hr>';

    $("#linkDownloadSdk").html(link);

    document.getElementById("imgLogoIos").classList.remove("area-ios");
    document.getElementById("imgLogoAndoird").classList.add("area-android");
}