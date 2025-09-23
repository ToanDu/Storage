/**
 * Created by vtk-anhlt166 on 12/17/21.
 */
var countPlanLevelEdit;
function changeEstimateEdit() {
    resetMoneyBuyPlanEdit();

    var estimateEdit = $("#estimateEdit").val();
    if(estimateEdit == "fix" || estimateEdit == "unit"){
        document.getElementById("tabPlanLevelEdit").style.display = "none";
    } else {
        document.getElementById("tabPlanLevelEdit").style.display = "block";
        $("#namePlanLevelEdit").html("Phương pháp định giá: "+ $("#estimateEdit option:selected").text());
        countPlanLevelEdit = 0;
        if(estimateEdit == "mass"){//khoi luong
            var planLv =
                '<div class="row planLevelItemClassEdit" id="planLevelItemEdit' + countPlanLevelEdit + '">'+
                '<div class="col-md-3">'+
                '<div class="row mb-4">'+
                '<label class="col-sm-6 col-form-label" style="text-align: right;">'+Messages("Từ 1 đến")+'</label>'+
                '<div class="col-sm-6">'+
                '<input id="levelPlanEdit' + countPlanLevelEdit + '" type="number" class="form-control level_plan_edit" placeholder="'+Messages("Không giới hạn")+'" autocomplete="off" required>'+
                '</div>'+
                '</div>'+
                '</div>'+
                '<div class="col-md-5">'+
                '<div class="row mb-4">'+
                '<label class="col-sm-5 col-form-label" style="text-align: right;">'+Messages("Đơn giá")+'</label>'+
                '<div class="col-sm-7">'+
                '<input id="pricePlanEdit' + countPlanLevelEdit + '" type="number" class="form-control price_plan_edit" autocomplete="off" value="0" required>'+
                '</div>'+
                '</div>'+
                '</div>'+
                '<div class="col-md-3">'+
                '<div class="row mb-4">'+
                '<label class="col-sm-5 col-form-label" style="text-align: right;">'+Messages("Miễn phí")+'</label>'+
                '<div class="col-sm-7">'+
                '<input id="freePlanEdit' + countPlanLevelEdit + '" type="number" class="form-control free_plan_edit" autocomplete="off" value="0" required>'+
                '</div>'+
                '</div>'+
                '</div>'+
                '</div>';
            $("#planLevelEdit").html(planLv);

            document.getElementById("tabMoneyBuyPlanEdit").style.display = "block";
        } else if (estimateEdit == "step") {//Bậc thang
            var planLv =
                '<div class="row planLevelItemClassEdit" id="planLevelItemEdit' + countPlanLevelEdit + '">' +
                '<div class="col-md-3">' +
                '<div class="row mb-4">' +
                '<label class="col-sm-6 col-form-label" style="text-align: right;">' + Messages("Tối đa") + '</label>' +
                '<div class="col-sm-6">' +
                '<input id="levelPlanEdit' + countPlanLevelEdit + '" type="number" class="form-control level_plan_edit" placeholder="'+Messages("Không giới hạn")+'" autocomplete="off" required>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '<div class="col-md-5">' +
                '<div class="row mb-4">' +
                '<label class="col-sm-5 col-form-label" style="text-align: right;">' + Messages("Số tiền") + '</label>' +
                '<div class="col-sm-7">' +
                '<input id="pricePlanEdit' + countPlanLevelEdit + '" type="number" class="form-control price_plan_edit" autocomplete="off" value="0" required>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</div>';
            $("#planLevelEdit").html(planLv);

            document.getElementById("tabMoneyBuyPlanEdit").style.display = "none";
        } else {
            var planLv =
                '<div class="row planLevelItemClassEdit" id="planLevelItemEdit' + countPlanLevelEdit + '">'+
                '<div class="col-md-3">'+
                '<div class="row mb-4">'+
                '<label class="col-sm-6 col-form-label" style="text-align: right;">'+Messages("Từ 1 đến")+'</label>'+
                '<div class="col-sm-6">'+
                '<input id="levelPlanEdit' + countPlanLevelEdit + '" type="number" class="form-control level_plan_edit" placeholder="'+Messages("Không giới hạn")+'" autocomplete="off" required>'+
                '</div>'+
                '</div>'+
                '</div>'+
                '<div class="col-md-5">'+
                '<div class="row mb-4">'+
                '<label class="col-sm-5 col-form-label" style="text-align: right;">'+Messages("Đơn giá")+'</label>'+
                '<div class="col-sm-7">'+
                '<input id="pricePlanEdit' + countPlanLevelEdit + '" type="number" class="form-control price_plan_edit" autocomplete="off" value="0" required>'+
                '</div>'+
                '</div>'+
                '</div>'+
                '</div>';
            $("#planLevelEdit").html(planLv);

            document.getElementById("tabMoneyBuyPlanAdd").style.display = "block";
        }

        countPlanLevelEdit++;
    }

    if (estimateEdit == "mass" || estimateEdit == "accumulated" || estimateEdit == "step") {
        document.getElementById("divPriceEdit").style.display = "none";
        document.getElementById("divNumberFreeEdit").style.display = "none";
    } else if (estimateEdit == "fix") {
        document.getElementById("divPriceEdit").style.display = "block";
        document.getElementById("divNumberFreeEdit").style.display = "none";
    } else {
        document.getElementById("divPriceEdit").style.display = "block";
        document.getElementById("divNumberFreeEdit").style.display = "block";
    }
}

function setEditPack(id) {
    var groupData = new FormData();
    groupData.id = id;

    // StartProcess();
    var r = jsRoutes.controllers.PayPackDataController.getInfoPackdata();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (datas) {
            console.log(datas);
            if(datas.success){
                $("#idPackDataEdit").val(datas.content.data.id);
                $("#namePackDataEdit").val(datas.content.data.name);
                $("#contentPackDataEdit").val(datas.content.data.description);
                $("#typePackDataEdit").val(datas.content.data.type).change();
                $("#statusPackDataEdit").val(datas.content.data.status).change();
                $("#paymentTypeEdit").val(datas.content.data.payment_type).change();
                $("#typePeriodEdit").val(datas.content.data.type_period).change();
                $("#periodEdit").val(datas.content.data.period);
                $("#calUnitEdit").val(datas.content.data.cal_unit).change();
                $("#fixCostEdit").val(datas.content.data.fix_cost);
                $("#chargingUnitEdit").val(datas.content.data.charging_unit).change();
                $("#estimateEdit").val(datas.content.data.estimate).change();
                $("#priceEdit").val(datas.content.data.price);
                $("#numberFreeEdit").val(datas.content.data.quantity_free);

                $("#namePlanLevelEdit").html("Phương pháp định giá: "+ $("#estimateEdit option:selected").text());
                $("#planLevelEdit").html("");
                if(datas.content.data.plan_lv != null && datas.content.data.plan_lv.length > 0){
                    document.getElementById("tabPlanLevelEdit").style.display = "block";
                    countPlanLevelEdit = datas.content.data.plan_lv.length;
                    if(datas.content.data.estimate == "accumulated"){
                        for(var i=0; i<datas.content.data.plan_lv.length; i++){
                            var iconRemove = "";
                            var textLevelEdit = Messages("Từ 1 đến ");
                            if(i > 0){
                                iconRemove = '<div class="col-md-1">'+
                                    '<div class="row mb-4">'+
                                    '<i class="bx bx-trash icon-remove-cond" style="font-size: 24px; cursor: pointer" onclick="removePlanLevelEdit('+i+')"></i>'+
                                    '</div>'+
                                    '</div>';
                                textLevelEdit = Messages("Từ ") + (parseInt(datas.content.data.plan_lv[i-1].level)+1) + Messages(" đến");
                            }

                            var planLv =
                                '<div class="row planLevelItemClassEdit" id="planLevelItemEdit'+i+'">'+
                                '<div class="col-md-3">'+
                                '<div class="row mb-4">'+
                                '<label class="col-sm-6 col-form-label" style="text-align: right;">'+'<span id="toNumberPlanEdit'+countPlanLevelEdit+'">'+textLevelEdit+'</span>'+'</label>'+
                                '<div class="col-sm-6">'+
                                '<input id="levelPlanEdit'+i+'" type="number" class="form-control level_plan_edit" value="'+datas.content.data.plan_lv[i].level+'" autocomplete="off" required>'+
                                '</div>'+
                                '</div>'+
                                '</div>'+
                                '<div class="col-md-5">'+
                                '<div class="row mb-4">'+
                                '<label class="col-sm-5 col-form-label" style="text-align: right;">'+Messages("Đơn giá")+'</label>'+
                                '<div class="col-sm-7">'+
                                '<input id="pricePlanEdit'+i+'" type="number" class="form-control price_plan_edit" value="'+datas.content.data.plan_lv[i].price+'" autocomplete="off" required>'+
                                '</div>'+
                                '</div>'+
                                '</div>'+
                                iconRemove +
                                '</div>';
                            $("#planLevelEdit").append(planLv);
                        }
                    } else if(datas.content.data.estimate == "step"){
                        for(var i=0; i<datas.content.data.plan_lv.length; i++){
                            var iconRemove = "";
                            if(i > 0){
                                iconRemove = '<div class="col-md-1">'+
                                    '<div class="row mb-4">'+
                                    '<i class="bx bx-trash icon-remove-cond" style="font-size: 24px; cursor: pointer" onclick="removePlanLevelEdit('+i+')"></i>'+
                                    '</div>'+
                                    '</div>';
                            }
                            var planLv =
                                '<div class="row planLevelItemClassEdit" id="planLevelItemEdit'+i+'">'+
                                '<div class="col-md-3">'+
                                '<div class="row mb-4">'+
                                '<label class="col-sm-6 col-form-label" style="text-align: right;">'+Messages("Tối đa ")+'</label>'+
                                '<div class="col-sm-6">'+
                                '<input id="levelPlanEdit'+i+'" type="number" class="form-control level_plan_edit" value="'+datas.content.data.plan_lv[i].level+'" autocomplete="off" required>'+
                                '</div>'+
                                '</div>'+
                                '</div>'+
                                '<div class="col-md-5">'+
                                '<div class="row mb-4">'+
                                '<label class="col-sm-5 col-form-label" style="text-align: right;">'+Messages("Số tiền")+'</label>'+
                                '<div class="col-sm-7">'+
                                '<input id="pricePlanEdit'+i+'" type="number" class="form-control price_plan_edit" value="'+datas.content.data.plan_lv[i].price+'" autocomplete="off" required>'+
                                '</div>'+
                                '</div>'+
                                '</div>'+
                                iconRemove +
                                '</div>';
                            $("#planLevelEdit").append(planLv);
                        }
                    } else {
                        for(var i=0; i<datas.content.data.plan_lv.length; i++){
                            var iconRemove = "";
                            var textLevelEdit = Messages("Từ 1 đến ");
                            if(i > 0){
                                iconRemove = '<div class="col-md-1">'+
                                    '<div class="row mb-4">'+
                                    '<i class="bx bx-trash icon-remove-cond" style="font-size: 24px; cursor: pointer" onclick="removePlanLevelEdit('+i+')"></i>'+
                                    '</div>'+
                                    '</div>';
                                textLevelEdit = Messages("Từ ") + (parseInt(datas.content.data.plan_lv[i-1].level)+1) + Messages(" đến")
                            }
                            var planLv =
                                '<div class="row planLevelItemClassEdit" id="planLevelItemEdit'+i+'">'+
                                '<div class="col-md-3">'+
                                '<div class="row mb-4">'+
                                '<label class="col-sm-6 col-form-label" style="text-align: right;">'+'<span id="toNumberPlanEdit'+countPlanLevelEdit+'">'+textLevelEdit+'</span>'+'</label>'+
                                '<div class="col-sm-6">'+
                                '<input id="levelPlanEdit'+i+'" type="number" class="form-control level_plan_edit" value="'+datas.content.data.plan_lv[i].level+'" autocomplete="off" required>'+
                                '</div>'+
                                '</div>'+
                                '</div>'+
                                '<div class="col-md-5">'+
                                '<div class="row mb-4">'+
                                '<label class="col-sm-5 col-form-label" style="text-align: right;">'+Messages("Đơn giá")+'</label>'+
                                '<div class="col-sm-7">'+
                                '<input id="pricePlanEdit'+i+'" type="number" class="form-control price_plan_edit" value="'+datas.content.data.plan_lv[i].price+'" autocomplete="off" required>'+
                                '</div>'+
                                '</div>'+
                                '</div>'+
                                '<div class="col-md-3">'+
                                '<div class="row mb-4">'+
                                '<label class="col-sm-5 col-form-label" style="text-align: right;">'+Messages("Miễn phí")+'</label>'+
                                '<div class="col-sm-7">'+
                                '<input id="freePlanEdit'+i+'" type="number" class="form-control free_plan_edit" value="'+datas.content.data.plan_lv[i].free+'" autocomplete="off" required>'+
                                '</div>'+
                                '</div>'+
                                '</div>'+
                                iconRemove +
                                '</div>';
                            $("#planLevelEdit").append(planLv);
                        }
                    }

                } else {
                    document.getElementById("tabPlanLevelEdit").style.display = "none";
                }

                $("#editPackDataModal").modal('show');
            }else {
                showNotification('danger', datas.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            // FinishProcess(); //Stop display loading...
        }
    });
}

function removePlanLevelEdit(count) {
    $("#planLevelItemEdit"+count).remove();
}

function appendPlanLevelEdit() {
    resetMoneyBuyPlanEdit();

    var plan = document.getElementsByClassName("planLevelItemClassEdit");
    var levelPlanLast = 0;
    console.log(plan);
    for(var i=0; i<plan.length; i++){
        var id = plan[i].id;
        console.log(id);
        var stt = id.replace("planLevelItemEdit","");
        levelPlanLast = $("#levelPlanEdit"+stt).val();
        if(levelPlanLast == ""){
            showNotification('danger', Messages("Bạn chưa điền định giá trên"));
            return;
        }
    }
    var textLevelPlan = Messages("Từ ") + (parseInt(levelPlanLast)+1) + Messages(" đến");
    console.log(textLevelPlan);

    var estimateEdit = $("#estimateEdit").val();
    if(estimateEdit == "mass"){//khoi luong
        var planLv =
            '<div class="row planLevelItemClassEdit" id="planLevelItemEdit'+countPlanLevelEdit+'">'+
            '<div class="col-md-3">'+
            '<div class="row mb-4">'+
            '<label class="col-sm-6 col-form-label" style="text-align: right;">'+'<span id="toNumberPlanEdit'+countPlanLevelEdit+'">'+textLevelPlan+'</span>'+'</label>'+
            '<div class="col-sm-6">'+
            '<input id="levelPlanEdit'+countPlanLevelEdit+'" type="number" class="form-control level_plan_edit" autocomplete="off" required>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class="col-md-5">'+
            '<div class="row mb-4">'+
            '<label class="col-sm-5 col-form-label" style="text-align: right;">'+Messages("Đơn giá")+'</label>'+
            '<div class="col-sm-7">'+
            '<input id="pricePlanEdit'+countPlanLevelEdit+'" type="number" class="form-control price_plan_edit" value="0" autocomplete="off" required>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class="col-md-3">'+
            '<div class="row mb-4">'+
            '<label class="col-sm-5 col-form-label" style="text-align: right;">'+Messages("Miễn phí")+'</label>'+
            '<div class="col-sm-7">'+
            '<input id="freePlanEdit'+countPlanLevelEdit+'" type="number" class="form-control free_plan_edit" value="0" autocomplete="off" required>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class="col-md-1">'+
            '<div class="row mb-4">'+
            '<i class="bx bx-trash icon-remove-cond" style="font-size: 24px; cursor: pointer" onclick="removePlanLevelEdit('+countPlanLevelEdit+')"></i>'+
            '</div>'+
            '</div>'+
            '</div>';
        $("#planLevelEdit").append(planLv);
    } else if(estimateEdit == "accumulated") {
        var planLv =
            '<div class="row planLevelItemClassEdit" id="planLevelItemEdit'+countPlanLevelEdit+'">'+
            '<div class="col-md-3">'+
            '<div class="row mb-4">'+
            '<label class="col-sm-6 col-form-label" style="text-align: right;">'+'<span id="toNumberPlanEdit'+countPlanLevelEdit+'">'+textLevelPlan+'</span>'+'</label>'+
            '<div class="col-sm-6">'+
            '<input id="levelPlanEdit'+countPlanLevelEdit+'" type="number" class="form-control level_plan_edit" autocomplete="off" required>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class="col-md-5">'+
            '<div class="row mb-4">'+
            '<label class="col-sm-5 col-form-label" style="text-align: right;">'+Messages("Đơn giá")+'</label>'+
            '<div class="col-sm-7">'+
            '<input id="pricePlanEdit'+countPlanLevelEdit+'" type="number" class="form-control price_plan_edit" value="0" autocomplete="off" required>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class="col-md-1">'+
            '<div class="row mb-4">'+
            '<i class="bx bx-trash icon-remove-cond" style="font-size: 24px; cursor: pointer" onclick="removePlanLevelEdit('+countPlanLevelEdit+')"></i>'+
            '</div>'+
            '</div>'+
            '</div>';
        $("#planLevelEdit").append(planLv);
    } else if(estimateEdit == "step") {
        var planLv =
            '<div class="row planLevelItemClassEdit" id="planLevelItemEdit'+countPlanLevel+'">'+
            '<div class="col-md-3">'+
            '<div class="row mb-4">'+
            '<label class="col-sm-6 col-form-label" style="text-align: right;">'+Messages("Tối đa ")+'</label>'+
            '<div class="col-sm-6">'+
            '<input id="levelPlanEdit'+countPlanLevel+'" type="number" class="form-control level_plan_edit" placeholder="'+Messages("Không giới hạn")+'" autocomplete="off" required>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class="col-md-5">'+
            '<div class="row mb-4">'+
            '<label class="col-sm-5 col-form-label" style="text-align: right;">'+Messages("Số tiền")+'</label>'+
            '<div class="col-sm-7">'+
            '<input id="pricePlanEdit'+countPlanLevel+'" type="number" class="form-control price_plan_edit" value="0" autocomplete="off" required>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class="col-md-1">'+
            '<div class="row mb-4">'+
            '<i class="bx bx-trash icon-remove-cond" style="font-size: 24px; cursor: pointer" onclick="removePlanLevelEdit('+countPlanLevel+')"></i>'+
            '</div>'+
            '</div>'+
            '</div>';
        $("#planLevelEdit").append(planLv);
    }
    countPlanLevelEdit++;
}

function processEditPackdata() {
    var groupData = new FormData();
    groupData.id = $("#idPackDataEdit").val();
    groupData.project_id = projectId;
    groupData.name = $("#namePackDataEdit").val();
    groupData.description = $("#contentPackDataEdit").val();
    groupData.type = $("#typePackDataEdit").val();
    groupData.status = $("#statusPackDataEdit").val();
    groupData.payment_type = $("#paymentTypeEdit").val();
    groupData.type_period = $("#typePeriodEdit").val();
    groupData.cal_unit = $("#calUnitEdit").val();
    groupData.period = parseInt($("#periodEdit").val());
    groupData.fix_cost = parseInt($("#fixCostEdit").val());
    groupData.charging_unit = $("#chargingUnitEdit").val();
    groupData.estimate = $("#estimateEdit").val();
    groupData.price = parseInt($("#priceEdit").val());
    groupData.quantity_free = parseInt($("#numberFreeEdit").val());

    var estimateEdit = $("#estimateEdit").val();
    if(estimateEdit == "mass") {//khoi luong
        var itemList = [];
        var count = $('#planLevelEdit .level_plan_edit').length;
        if(count > 0){
            for(var i=0; i<count; i++){
                var level_plan_edit = $("#planLevelEdit").find('.level_plan_edit')[i];
                var price_plan_edit = $("#planLevelEdit").find('.price_plan_edit')[i];
                var free_plan_edit = $("#planLevelEdit").find('.free_plan_edit')[i];
                var item = {
                    "level": ($(level_plan_edit).val() != null && $(level_plan_edit).val().length > 0) ? parseInt($(level_plan_edit).val()) : null,
                    "price": ($(price_plan_edit).val() != null && $(price_plan_edit).val().length > 0) ? parseInt($(price_plan_edit).val()) : 0,
                    "free": ($(free_plan_edit).val() != null && $(free_plan_edit).val().length > 0) ? parseInt($(free_plan_edit).val()) : 0
                };
                itemList.push(item);
            }
        }
        groupData.plan_lv = itemList;
    } else if(estimateEdit == "accumulated" || estimateEdit == "step"){
        var itemList = [];
        var count = $('#planLevelEdit .level_plan_edit').length;
        if(count > 0){
            for(var i=0; i<count; i++){
                var level_plan_edit = $("#planLevelEdit").find('.level_plan_edit')[i];
                var price_plan_edit = $("#planLevelEdit").find('.price_plan_edit')[i];
                var item = {
                    "level": ($(level_plan_edit).val() != null && $(level_plan_edit).val().length > 0) ? parseInt($(level_plan_edit).val()) : null,
                    "price": ($(price_plan_edit).val() != null && $(price_plan_edit).val().length > 0) ? parseInt($(price_plan_edit).val()) : 0
                };
                itemList.push(item);
            }
        }
        groupData.plan_lv = itemList;
    }

    console.log(groupData);

    StartProcess();
    var r = jsRoutes.controllers.PayPackDataController.editPackdata();
    $.ajax({
        type: r.type,
        dataType: 'json',
        data: JSON.stringify(groupData),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function (data) {
            console.log(data);
            if(data.success){
                showNotification('success', data.resultString);

                choosePackdata(groupData.id);
            }else {
                showNotification('danger', data.errorString);
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (jqXHR, textStatus) {
            FinishProcess(); //Stop display loading...
        }
    });
}

function choosePaymentTypeEdit() {
    var pay = $("#paymentTypeEdit").val();
    if(pay == "POSTPAID"){
        var option = '<option value="PERIODIC" selected>'+Messages("Định kỳ")+'</option>';
        $("#typePeriodEdit").html(option);

        document.getElementById("divCalUnitEdit").style.display = "block";
    } else {
        var option = '<option value="PERIODIC" selected>'+Messages("Định kỳ")+'</option>'+
            '<option value="ONCE">'+Messages("Một lần")+'</option>';
        $("#typePeriodEdit").html(option);
    }
}

function choosePeriodTypeEdit() {
    var pe = $("#typePeriodEdit").val();
    if(pe == "ONCE") {
        document.getElementById("divCalUnitEdit").style.display = "none";
    } else {
        document.getElementById("divCalUnitEdit").style.display = "block";
    }
}

$('#numberBuyPlanEdit').on('input', function() {
    var z = parseInt($(this).val());
    console.log(z);
    if(z >= 0){
        var estimateEdit = $("#estimateEdit").val();

        if(estimateEdit == "fix"){//Cố định
            var price = parseInt($("#priceEdit").val());
            $("#moneyBuyPlanEdit").html(Messages(" thì tổng số tiền phải thanh toán là ") + price + Messages(" VND"));
        } else if(estimateEdit == "unit"){//Theo đơn vị
            var price = parseInt($("#priceEdit").val());
            var total = (z - parseInt($("#numberFreeEdit").val())) * price;
            $("#moneyBuyPlanEdit").html(Messages(" thì tổng số tiền phải thanh toán là ") + (total > 0 ? total : 0) + Messages(" VND"));
        } else if(estimateEdit == "mass"){//Khối lượng
            var plan = document.getElementsByClassName("level_plan_edit");

            if(plan.length == 1){
                var price = parseInt($("#pricePlanEdit0").val());
                var total = (z - parseInt($("#freePlanEdit0").val())) * price;
                $("#moneyBuyPlanEdit").html(Messages(" thì tổng số tiền phải thanh toán là ") + (total > 0 ? total : 0) + Messages(" VND"));
            } else {
                for(var i=1; i<plan.length; i++){
                    var valuePrev = parseInt(plan[i-1].value); //10 price 2000 free 10
                    var value = plan[i].value; //vc price 2100 free 20

                    var idPrev = plan[i-1].id;
                    var id = plan[i].id;

                    var sttPrev = idPrev.replace("levelPlanEdit","");
                    var stt = id.replace("levelPlanEdit","");
                    console.log(i, " - " ,z, valuePrev);
                    console.log("value - " , value);
                    if(value.length > 0){
                        if(z > valuePrev && z <= parseInt(value)){
                            var free = parseInt($("#freePlanEdit"+stt).val());
                            var price = parseInt($("#pricePlanEdit"+stt).val());
                            console.log(free, price);
                            var total = (z - free) * price;
                            $("#moneyBuyPlanEdit").html(Messages(" thì tổng số tiền phải thanh toán là ") + (total > 0 ? total : 0) + Messages(" VND"));
                            break;
                        } else {
                            if(z <= valuePrev){
                                var free = parseInt($("#freePlanEdit"+sttPrev).val());
                                var price = parseInt($("#pricePlanEdit"+sttPrev).val());
                                console.log(free, price);
                                var total = (z - free) * price;
                                $("#moneyBuyPlanEdit").html(Messages(" thì tổng số tiền phải thanh toán là ") + (total > 0 ? total : 0) + Messages(" VND"));
                                break;
                            }
                        }
                    } else {
                        console.log(z, valuePrev);
                        if(z <= valuePrev){
                            var free = parseInt($("#freePlanEdit"+sttPrev).val());
                            var price = parseInt($("#pricePlanEdit"+sttPrev).val());
                            console.log(free, price);
                            var total = (z - free) * price;
                            $("#moneyBuyPlanEdit").html(Messages(" thì tổng số tiền phải thanh toán là ") + (total > 0 ? total : 0) + Messages(" VND"));
                        } else {
                            var free = parseInt($("#freePlanEdit"+stt).val());
                            var price = parseInt($("#pricePlanEdit"+stt).val());
                            console.log(free, price);
                            var total = (z - free) * price;
                            $("#moneyBuyPlanEdit").html(Messages(" thì tổng số tiền phải thanh toán là ") + (total > 0 ? total : 0) + Messages(" VND"));
                        }
                    }

                }
            }

        } else if(estimateEdit == "accumulated") {//Lũy kế
            var plan = document.getElementsByClassName("level_plan_edit");
            var total = 0;
            for(var i=0; i<plan.length; i++){
                var value = plan[i].value;
                var id = plan[i].id;
                var stt = id.replace("levelPlanEdit","");
                console.log(value, id, stt);
                if(value == ""){
                    if(i == 0){
                        total += z * parseInt($("#pricePlanEdit"+stt).val());
                    } else {
                        var idPrev = plan[i-1].id;
                        var sttPrev = idPrev.replace("levelPlanEdit","");
                        total += (z - parseInt($("#levelPlanEdit"+sttPrev).val())) * parseInt($("#pricePlanEdit"+stt).val());
                    }
                    break;
                } else {
                    if(z > parseInt(value)){
                        if(i == 0){
                            total += parseInt($("#levelPlanEdit"+stt).val()) * parseInt($("#pricePlanEdit"+stt).val());
                        } else {
                            var idPrev = plan[i-1].id;
                            var sttPrev = idPrev.replace("levelPlanEdit","");
                            total += (parseInt($("#levelPlanEdit"+stt).val()) - parseInt($("#levelPlanEdit"+sttPrev).val())) * parseInt($("#pricePlanEdit"+stt).val());
                        }
                    } else {
                        if(i == 0){
                            total += z * parseInt($("#pricePlanEdit"+stt).val());
                        } else {
                            var idPrev = plan[i-1].id;
                            var sttPrev = idPrev.replace("levelPlanEdit","");
                            total += (z - parseInt($("#levelPlanEdit"+sttPrev).val())) * parseInt($("#pricePlanEdit"+stt).val());
                        }
                        break;
                    }
                }
                console.log(total);
            }
            $("#moneyBuyPlanEdit").html(Messages(" thì tổng số tiền phải thanh toán là ") + (total > 0 ? total : 0) + Messages(" VND"));
        }
    } else {
        showNotification('danger', Messages("Bạn phải điền số lượng mua lớn hơn 0"));
    }

});

function resetMoneyBuyPlanEdit() {
    $('#numberBuyPlanEdit').val(0);
    $("#moneyBuyPlanEdit").html(Messages(" thì tổng số tiền phải thanh toán là 0 VND"));
}