/**
 * Created by vtk-anhlt166 on 6/15/22.
 */
var chooseGp = false;
function setWizard() {
    var btnStart = $('<button></button>').text('Bắt đầu').addClass('btn btn-info btn-start disabled').on('click', function () {
        console.log('Bắt đầu');
        processStartCreateTemplateProject();
    });
    var btnCancel = $('<button></button>').text('Hủy').addClass('btn btn-danger').on('click', function () {
        cancleWizard();
    });

    $('#smartwizard').smartWizard({
        selected: 0,
        theme: 'dots',
        transition: {
            animation: 'slide-horizontal', // Effect on navigation, none/fade/slide-horizontal/slide-vertical/slide-swing
        },
        toolbarSettings: {
            // toolbarPosition: 'both', // both bottom
            toolbarExtraButtons: [btnStart, btnCancel]
        }
    });

    $('#smartwizard').smartWizard("reset");

    $(".sw-btn-next").hide();
    $(".sw-btn-prev").hide();

    $('#smartwizard').smartWizard("next");
    $(".btn-start").removeClass('disabled');
}

function showPopupCreateTemplate() {
    // $(".sw-btn-next").click();
    // StartProcess();
}

function chooseTemplateProject(gp) {
    $("#nameTemplateProject").val(gp);

    if(gp == "Fleet Management"){
        var wizard =
            '<div id="smartwizard">'+
            '<ul class="nav">'+
            '<li class="nav-item"><a class="nav-link" href="#step-0"><strong>Start</strong><br>Chọn giải pháp mẫu </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-1"><strong>Step 1</strong><br>Tạo dự án </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-2"><strong>Step 2</strong><br>Tạo mẫu thiết bị và thuộc tính </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-3"><strong>Step 3</strong><br>Tạo mới thiết bị </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-4"><strong>Step 4</strong><br>Tạo Flow Engine </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-5"><strong>Step 5</strong><br>Import Flow Engine chứa DeviceID </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-6"><strong>Step 6</strong><br>Gán FlowID cho các mẫu thiết bị </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-7"><strong>Step 7</strong><br>Tạo DashBoard </a></li>'+
            '</ul>'+
            '<div class="tab-content">'+
            '<div id="step-0" class="tab-pane" role="tabpanel" aria-labelledby="step-0"></div>'+
            '<div id="step-1" class="tab-pane" role="tabpanel" aria-labelledby="step-1">' +
            '<h3>Giải pháp quản lý đội xe </h3>' +
            Messages("giúp bạn quản lý hoạt động của đội xe, dẫn đến giảm chi phí, cải thiện hiệu quả và nâng cao tính tuân thủ. Giải pháp quản lý đội xe phù hợp có thể là công cụ trong việc điều phối các hoạt động quản lý đội xe của bạn. ") +
            '</div>'+
            '<div id="step-2" class="tab-pane" role="tabpanel" aria-labelledby="step-2"></div>'+
            '<div id="step-3" class="tab-pane" role="tabpanel" aria-labelledby="step-3"></div>'+
            '<div id="step-4" class="tab-pane" role="tabpanel" aria-labelledby="step-4"></div>'+
            '<div id="step-5" class="tab-pane" role="tabpanel" aria-labelledby="step-5"></div>'+
            '<div id="step-6" class="tab-pane" role="tabpanel" aria-labelledby="step-6"></div>'+
            '<div id="step-7" class="tab-pane" role="tabpanel" aria-labelledby="step-7"></div>'+
            '</div>'+
            '</div>';
        $("#divSmartWizard").html(wizard);

        setWizard();
    } else if(gp == "Asset Management"){
        var wizard =
            '<div id="smartwizard">'+
            '<ul class="nav">'+
            '<li class="nav-item"><a class="nav-link" href="#step-0"><strong>Start</strong><br>Chọn giải pháp mẫu </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-1"><strong>Step 1</strong><br>Tạo dự án </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-2"><strong>Step 2</strong><br>Tạo mẫu thiết bị và thuộc tính </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-3"><strong>Step 3</strong><br>Tạo nhóm </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-4"><strong>Step 4</strong><br>Tạo mới thiết bị </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-5"><strong>Step 5</strong><br>Tạo Flow Engine </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-6"><strong>Step 6</strong><br>Import Flow Engine chứa DeviceID </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-7"><strong>Step 7</strong><br>Gán FlowID cho các mẫu thiết bị </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-8"><strong>Step 8</strong><br>Tạo DashBoard </a></li>'+
            '</ul>'+
            '<div class="tab-content">'+
            '<div id="step-0" class="tab-pane" role="tabpanel" aria-labelledby="step-0"></div>'+
            '<div id="step-1" class="tab-pane" role="tabpanel" aria-labelledby="step-1">' +
            '<h3>Giải pháp quản lý tài sản </h3>' +
            Messages("giúp bạn theo dõi tài sản thông qua việc sử dụng các thẻ RFID được gắn vào chúng. Các thẻ được đọc bằng máy quét cố định được gắn ở vị trí cố đinh. Mỗi khi một thẻ được đọc, nó sẽ được lưu tổng hợp thành một chuỗi và bán tổng tất cả các RFID đã quét được lên hệ thống. Bên cạnh đó, giải pháp còn cảnh báo cho bạn những RFID bị thiếu hoặc RFID lạ để giúp bạn tránh bị thiếu sót tài sản.") +
            '</div>'+
            '<div id="step-2" class="tab-pane" role="tabpanel" aria-labelledby="step-2"></div>'+
            '<div id="step-3" class="tab-pane" role="tabpanel" aria-labelledby="step-3"></div>'+
            '<div id="step-4" class="tab-pane" role="tabpanel" aria-labelledby="step-4"></div>'+
            '<div id="step-5" class="tab-pane" role="tabpanel" aria-labelledby="step-5"></div>'+
            '<div id="step-6" class="tab-pane" role="tabpanel" aria-labelledby="step-6"></div>'+
            '<div id="step-7" class="tab-pane" role="tabpanel" aria-labelledby="step-7"></div>'+
            '<div id="step-8" class="tab-pane" role="tabpanel" aria-labelledby="step-8"></div>'+
            '</div>'+
            '</div>';
        $("#divSmartWizard").html(wizard);

        setWizard();

    } else if(gp == "Smart Water Meter"){
        var wizard =
            '<div id="smartwizard">'+
            '<ul class="nav">'+
            '<li class="nav-item"><a class="nav-link" href="#step-0"><strong>Start</strong><br>Chọn giải pháp mẫu </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-1"><strong>Step 1</strong><br>Tạo dự án </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-2"><strong>Step 2</strong><br>Tạo mẫu thiết bị và thuộc tính </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-3"><strong>Step 3</strong><br>Tạo mới thiết bị </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-4"><strong>Step 4</strong><br>Tạo Flow Engine </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-5"><strong>Step 5</strong><br>Import Flow Engine chứa DeviceID </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-6"><strong>Step 6</strong><br>Gán FlowID cho các mẫu thiết bị </a></li>'+
            '<li class="nav-item"><a class="nav-link" href="#step-7"><strong>Step 7</strong><br>Tạo DashBoard </a></li>'+
            '</ul>'+
            '<div class="tab-content">'+
            '<div id="step-0" class="tab-pane" role="tabpanel" aria-labelledby="step-0"></div>'+
            '<div id="step-1" class="tab-pane" role="tabpanel" aria-labelledby="step-1">' +
            '<h3>Giải pháp đồng hồ nước thông mình </h3>' +
            Messages("giúp bạn theo dõi lưu lượng sử dụng, cảnh bảo về các vấn đề liên quan đến đường dẫn nước trong nhà bạn, dẫn đến giảm chi phí, giải thiếu các rủi ro. Giải pháp đồng hồ nước thông minh cung cấp hệ thông đo lường từ xa và tổng hợp lại số lượng đã sử dụng mà không cần đội ngũ đến kiểm tra.") +
            '</div>'+
            '<div id="step-2" class="tab-pane" role="tabpanel" aria-labelledby="step-2"></div>'+
            '<div id="step-3" class="tab-pane" role="tabpanel" aria-labelledby="step-3"></div>'+
            '<div id="step-4" class="tab-pane" role="tabpanel" aria-labelledby="step-4"></div>'+
            '<div id="step-5" class="tab-pane" role="tabpanel" aria-labelledby="step-5"></div>'+
            '<div id="step-6" class="tab-pane" role="tabpanel" aria-labelledby="step-6"></div>'+
            '<div id="step-7" class="tab-pane" role="tabpanel" aria-labelledby="step-7"></div>'+
            '</div>'+
            '</div>';
        $("#divSmartWizard").html(wizard);

        setWizard();
    }
}

function cancleWizard() {
    $("#createTemplateProjectModal").modal('hide');
}

function processStartCreateTemplateProject() {
    StartProcess();
    var gp = $("#nameTemplateProject").val();
    if(gp == "Fleet Management"){
        addProjectFleet();
    } else if(gp == "Asset Management"){
        addProjectAsset();
    } else if(gp == "Smart Water Meter"){
        addProjectSmartWater();
    }
}