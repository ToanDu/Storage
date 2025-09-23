/**
 * Created by vtk-anhlt166 on 7/27/22.
 */
$(document).ready(function () {
    const native_wizard = new window.Zangdar('#wizard-native', {
            onStepChange: () => {
            onStepChange(native_wizard, 'steps-native')
    },
    onSubmit(e) {
        e.preventDefault()
        console.log(e.target.elements)
        return false
    }
    })

    onStepChange(native_wizard, 'steps-native');
});

function onStepChange(wizard, selector) {
    const steps = wizard.getBreadcrumb();
    buildStepsBreadcrumb(wizard, selector, steps)
}

function buildStepsBreadcrumb (wizard, element, steps) {
    const $steps = document.getElementById(element)
    $steps.innerHTML = ''
    for (let label in steps) {
        if (steps.hasOwnProperty(label)) {
            const $li = document.createElement('li')
            const $a = document.createElement('a')
            $li.classList.add('step-item')
            if (steps[label].active) {
                $li.classList.add('active')
            }
            $a.setAttribute('href', '#')
            $a.classList.add('tooltip')
            $a.dataset.tooltip = label
            $a.innerText = label
            $a.addEventListener('click', e => {
                e.preventDefault()
            wizard.revealStep(label)
        })
            $li.appendChild($a)
            $steps.appendChild($li)
        }
    }
}

//register developer
function registerDeveloper() {
    var dataForm = new FormData;
    dataForm.name = $("#nameRegister").val();
    dataForm.nameCompany = $("#nameCompanyRegister").val();
    dataForm.email = $("#emailRegister").val();
    dataForm.phone = $("#phoneRegister").val();
    dataForm.field = $("#fieldRegister").val();
    dataForm.role = $("#roleRegister").val();
    dataForm.countDevice = $("#countDeviceRegister").val();
    dataForm.countUser = $("#countUserRegister").val();
    if(dataForm.name.length <= 0 || dataForm.nameCompany.length <= 0 || dataForm.email.length <= 0 || dataForm.phone.length <= 0 ||
        dataForm.field.length <= 0 || dataForm.role.length <= 0 || dataForm.countDevice.length <= 0 || dataForm.countUser.length <= 0){
        showNotification('danger', Messages("Bạn vui lòng điền đầy đủ thông tin"));
        return;
    }
    console.log(dataForm);

    StartProcess();
    var r = jsRoutes.controllers.LandingPageController.submitRegisterDeveloper();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(dataForm),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.success){
                // showNotification('success',data.resultString);
                $("#buttonFinishRegister").click();
                setTimeout(function () {
                    window.location.href = jsRoutes.controllers.LandingPageController.home().url;
                },2000);
            }else{
                showNotification('danger',data.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
            $("#registerDeveloperModal").modal('hide');
        }
    });
}