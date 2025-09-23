/**
 * Created by vtk-anhlt166 on 3/1/22.
 */
var countPlanLevel=0;
function changeEstimateAdd() {
    resetMoneyBuyPlan();

    var estimateAdd = $("#estimateAdd").val();
    if (estimateAdd == "fix" || estimateAdd == "unit") {
        document.getElementById("tabPlanLevel").style.display = "none";
    } else {
        document.getElementById("tabPlanLevel").style.display = "block";
        $("#namePlanLevelAdd").html("Phương pháp định giá: " + $("#estimateAdd option:selected").text());
        countPlanLevel = 0;
        if (estimateAdd == "mass") {//khoi luong
            var planLv =
                '<div class="row planLevelItemClass" id="planLevelItemAdd' + countPlanLevel + '">' +
                '<div class="col-md-3">' +
                '<div class="row mb-4">' +
                '<label class="col-sm-6 col-form-label" style="text-align: right;">' + Messages("Từ 1 đến") + '</label>' +
                '<div class="col-sm-6">' +
                '<input id="levelPlanAdd' + countPlanLevel + '" type="number" class="form-control level_plan_add" placeholder="'+Messages("Không giới hạn")+'" autocomplete="off" required>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '<div class="col-md-5">' +
                '<div class="row mb-4">' +
                '<label class="col-sm-5 col-form-label" style="text-align: right;">' + Messages("Đơn giá") + '</label>' +
                '<div class="col-sm-7">' +
                '<input id="pricePlanAdd' + countPlanLevel + '" type="number" class="form-control price_plan_add" autocomplete="off" value="0" required>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '<div class="col-md-3">' +
                '<div class="row mb-4">' +
                '<label class="col-sm-6 col-form-label" style="text-align: right;">' + Messages("Miễn phí") + '</label>' +
                '<div class="col-sm-6">' +
                '<input id="freePlanAdd' + countPlanLevel + '" type="number" class="form-control free_plan_add" autocomplete="off" value="0" required>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</div>';
            $("#planLevelAdd").html(planLv);

            document.getElementById("tabMoneyBuyPlanAdd").style.display = "block";
        } else if (estimateAdd == "step") {//Bậc thang
            var planLv =
                '<div class="row planLevelItemClass" id="planLevelItemAdd' + countPlanLevel + '">' +
                '<div class="col-md-3">' +
                '<div class="row mb-4">' +
                '<label class="col-sm-6 col-form-label" style="text-align: right;">' + Messages("Tối đa") + '</label>' +
                '<div class="col-sm-6">' +
                '<input id="levelPlanAdd' + countPlanLevel + '" type="number" class="form-control level_plan_add" placeholder="'+Messages("Không giới hạn")+'" autocomplete="off" required>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '<div class="col-md-5">' +
                '<div class="row mb-4">' +
                '<label class="col-sm-5 col-form-label" style="text-align: right;">' + Messages("Số tiền") + '</label>' +
                '<div class="col-sm-7">' +
                '<input id="pricePlanAdd' + countPlanLevel + '" type="number" class="form-control price_plan_add" autocomplete="off" value="0" required>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</div>';
            $("#planLevelAdd").html(planLv);

            document.getElementById("tabMoneyBuyPlanAdd").style.display = "none";
        } else {
            var planLv =
                '<div class="row planLevelItemClass" id="planLevelItemAdd' + countPlanLevel + '">' +
                '<div class="col-md-3">' +
                '<div class="row mb-4">' +
                '<label class="col-sm-6 col-form-label" style="text-align: right;">' + Messages("Từ 1 đến") + '</label>' +
                '<div class="col-sm-6">' +
                '<input id="levelPlanAdd' + countPlanLevel + '" type="number" class="form-control level_plan_add" placeholder="'+Messages("Không giới hạn")+'" autocomplete="off" required>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '<div class="col-md-5">' +
                '<div class="row mb-4">' +
                '<label class="col-sm-5 col-form-label" style="text-align: right;">' + Messages("Đơn giá") + '</label>' +
                '<div class="col-sm-7">' +
                '<input id="pricePlanAdd' + countPlanLevel + '" type="number" class="form-control price_plan_add" autocomplete="off" value="0" required>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</div>';
            $("#planLevelAdd").html(planLv);

            document.getElementById("tabMoneyBuyPlanAdd").style.display = "block";
        }
    }

    if (estimateAdd == "mass" || estimateAdd == "accumulated" || estimateAdd == "step") {
        document.getElementById("divPriceAdd").style.display = "none";
        document.getElementById("divNumberFreeAdd").style.display = "none";
    } else if (estimateAdd == "fix") {
        document.getElementById("divPriceAdd").style.display = "block";
        document.getElementById("divNumberFreeAdd").style.display = "none";
    } else {
        document.getElementById("divPriceAdd").style.display = "block";
        document.getElementById("divNumberFreeAdd").style.display = "block";
    }
}

function appendPlanLevelAdd() {
    resetMoneyBuyPlan();

    var plan = document.getElementsByClassName("planLevelItemClass");
    var levelPlanLast = 0;
    for(var i=0; i<plan.length; i++){
        var id = plan[i].id;
        console.log(id);
        var stt = id.replace("planLevelItemAdd","");
        levelPlanLast = $("#levelPlanAdd"+stt).val();
        if(levelPlanLast == ""){
            showNotification('danger', Messages("Bạn chưa điền định giá trên"));
            return;
        }
    }
    var textLevelPlan = Messages("Từ ") + (parseInt(levelPlanLast)+1) + Messages(" đến");
    console.log(textLevelPlan);

    countPlanLevel++;
    var estimateAdd = $("#estimateAdd").val();
    if(estimateAdd == "mass"){//khoi luong
        var planLv =
            '<div class="row planLevelItemClass" id="planLevelItemAdd'+countPlanLevel+'">'+
            '<div class="col-md-3">'+
            '<div class="row mb-4">'+
            '<label class="col-sm-6 col-form-label" style="text-align: right;">'+'<span id="toNumberPlanAdd'+countPlanLevel+'">'+textLevelPlan+'</span>'+'</label>'+
            '<div class="col-sm-6">'+
            '<input id="levelPlanAdd'+countPlanLevel+'" type="number" class="form-control level_plan_add" placeholder="'+Messages("Không giới hạn")+'" autocomplete="off" required>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class="col-md-5">'+
            '<div class="row mb-4">'+
            '<label class="col-sm-5 col-form-label" style="text-align: right;">'+Messages("Đơn giá")+'</label>'+
            '<div class="col-sm-7">'+
            '<input id="pricePlanAdd'+countPlanLevel+'" type="number" class="form-control price_plan_add" value="0" autocomplete="off" required>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class="col-md-3">'+
            '<div class="row mb-4">'+
            '<label class="col-sm-6 col-form-label" style="text-align: right;">'+Messages("Miễn phí")+'</label>'+
            '<div class="col-sm-6">'+
            '<input id="freePlanAdd'+countPlanLevel+'" type="number" class="form-control free_plan_add" value="0" autocomplete="off" required>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class="col-md-1">'+
            '<div class="row mb-4">'+
            '<i class="bx bx-trash icon-remove-cond" style="font-size: 24px; cursor: pointer" onclick="removePlanLevelAdd('+countPlanLevel+')"></i>'+
            '</div>'+
            '</div>'+
            '</div>';
        $("#planLevelAdd").append(planLv);
    } else if(estimateAdd == "accumulated") {
        var planLv =
            '<div class="row planLevelItemClass" id="planLevelItemAdd'+countPlanLevel+'">'+
            '<div class="col-md-3">'+
            '<div class="row mb-4">'+
            '<label class="col-sm-6 col-form-label" style="text-align: right;">'+'<span id="toNumberPlanAdd'+countPlanLevel+'">'+textLevelPlan+'</span>'+'</label>'+
            '<div class="col-sm-6">'+
            '<input id="levelPlanAdd'+countPlanLevel+'" type="number" class="form-control level_plan_add" placeholder="'+Messages("Không giới hạn")+'" autocomplete="off" required>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class="col-md-5">'+
            '<div class="row mb-4">'+
            '<label class="col-sm-5 col-form-label" style="text-align: right;">'+Messages("Đơn giá")+'</label>'+
            '<div class="col-sm-7">'+
            '<input id="pricePlanAdd'+countPlanLevel+'" type="number" class="form-control price_plan_add" value="0" autocomplete="off" required>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class="col-md-1">'+
            '<div class="row mb-4">'+
            '<i class="bx bx-trash icon-remove-cond" style="font-size: 24px; cursor: pointer" onclick="removePlanLevelAdd('+countPlanLevel+')"></i>'+
            '</div>'+
            '</div>'+
            '</div>';
        $("#planLevelAdd").append(planLv);
    } else if(estimateAdd == "step") {
        var planLv =
            '<div class="row planLevelItemClass" id="planLevelItemAdd'+countPlanLevel+'">'+
            '<div class="col-md-3">'+
            '<div class="row mb-4">'+
            '<label class="col-sm-6 col-form-label" style="text-align: right;">'+Messages("Tối đa ")+'</label>'+
            '<div class="col-sm-6">'+
            '<input id="levelPlanAdd'+countPlanLevel+'" type="number" class="form-control level_plan_add" placeholder="'+Messages("Không giới hạn")+'" autocomplete="off" required>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class="col-md-5">'+
            '<div class="row mb-4">'+
            '<label class="col-sm-5 col-form-label" style="text-align: right;">'+Messages("Số tiền")+'</label>'+
            '<div class="col-sm-7">'+
            '<input id="pricePlanAdd'+countPlanLevel+'" type="number" class="form-control price_plan_add" value="0" autocomplete="off" required>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class="col-md-1">'+
            '<div class="row mb-4">'+
            '<i class="bx bx-trash icon-remove-cond" style="font-size: 24px; cursor: pointer" onclick="removePlanLevelAdd('+countPlanLevel+')"></i>'+
            '</div>'+
            '</div>'+
            '</div>';
        $("#planLevelAdd").append(planLv);
    }
}

function resetPlanLevelAdd() {
    countPlanLevel = 0;
    var estimateAdd = $("#estimateAdd").val();
    if(estimateAdd == "mass"){//khoi luong
        var planLv =
            '<div class="row">'+
            '<div class="col-md-4">'+
            '<div class="row mb-4">'+
            '<label class="col-sm-6 col-form-label" style="text-align: right;">'+Messages("Từ 1 đến")+'</label>'+
            '<div class="col-sm-6">'+
            '<input id="levelPlanAdd'+countPlanLevel+'" type="number" class="form-control level_plan_add" autocomplete="off" required>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class="col-md-5">'+
            '<div class="row mb-4">'+
            '<label class="col-sm-5 col-form-label" style="text-align: right;">'+Messages("Đơn giá")+'</label>'+
            '<div class="col-sm-7">'+
            '<input id="pricePlanAdd'+countPlanLevel+'" type="number" class="form-control price_plan_add" autocomplete="off" value="0" required>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class="col-md-3">'+
            '<div class="row mb-4">'+
            '<label class="col-sm-6 col-form-label" style="text-align: right;">'+Messages("Miễn phí")+'</label>'+
            '<div class="col-sm-6">'+
            '<input id="freePlanAdd'+countPlanLevel+'" type="number" class="form-control free_plan_add" autocomplete="off" value="0" required>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '</div>';
        $("#planLevelAdd").html(planLv);
    } else {
        var planLv =
            '<div class="row">'+
            '<div class="col-md-4">'+
            '<div class="row mb-4">'+
            '<label class="col-sm-6 col-form-label" style="text-align: right;">'+Messages("Từ 1 đến")+'</label>'+
            '<div class="col-sm-6">'+
            '<input id="levelPlanAdd'+countPlanLevel+'" type="number" class="form-control level_plan_add" autocomplete="off" required>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class="col-md-5">'+
            '<div class="row mb-4">'+
            '<label class="col-sm-5 col-form-label" style="text-align: right;">'+Messages("Đơn giá")+'</label>'+
            '<div class="col-sm-7">'+
            '<input id="pricePlanAdd'+countPlanLevel+'" type="number" class="form-control price_plan_add" autocomplete="off" value="0" required>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '</div>';
        $("#planLevelAdd").html(planLv);
    }
}

function removePlanLevelAdd(count) {
    $("#planLevelItemAdd"+count).remove();

    var estimateAdd = $("#estimateAdd").val();
    if(estimateAdd != "step") {
        var plan = document.getElementsByClassName("planLevelItemClass");
        for(var i=1; i<plan.length; i++){
            var idPrev = plan[i-1].id.replace("planLevelItemAdd","");
            console.log(idPrev);
            var levelPrev = $("#levelPlanAdd"+idPrev).val();
            console.log(levelPrev);

            var id = plan[i].id;
            console.log(id);
            var stt = id.replace("planLevelItemAdd","");
            $("#toNumberPlanAdd"+stt).html(Messages("Từ ") + (parseInt(levelPrev)+1) + Messages(" đến"));
        }
    }
}

function processCreatePackdata() {
    var groupData = new FormData();
    groupData.project_id = projectId;
    groupData.name = $("#namePackDataAdd").val();
    groupData.description = $("#contentPackDataAdd").val();
    groupData.type = $("#typePackDataAdd").val();
    groupData.status = $("#statusPackDataAdd").val();
    groupData.payment_type = $("#paymentTypeAdd").val();
    groupData.type_period = $("#typePeriodAdd").val();
    groupData.cal_unit = $("#calUnitAdd").val();
    groupData.period = parseInt($("#periodAdd").val());
    groupData.fix_cost = parseInt($("#fixCostAdd").val());
    groupData.charging_unit = $("#chargingUnitAdd").val();
    groupData.estimate = $("#estimateAdd").val();
    groupData.price = parseInt($("#priceAdd").val());
    groupData.quantity_free = parseInt($("#numberFreeAdd").val());

    var estimateAdd = $("#estimateAdd").val();
    if(estimateAdd == "mass") {//khoi luong
        var itemList = [];
        var count = $('#planLevelAdd .level_plan_add').length;
        if(count > 0){
            for(var i=0; i<count; i++){
                var level_plan_add = $("#planLevelAdd").find('.level_plan_add')[i];
                var price_plan_add = $("#planLevelAdd").find('.price_plan_add')[i];
                var free_plan_add = $("#planLevelAdd").find('.free_plan_add')[i];
                var item = {
                    "level": ($(level_plan_add).val() != null && $(level_plan_add).val().length > 0) ? parseInt($(level_plan_add).val()) : null,
                    "price": ($(price_plan_add).val() != null && $(price_plan_add).val().length > 0) ? parseInt($(price_plan_add).val()) : 0,
                    "free": ($(free_plan_add).val() != null && $(free_plan_add).val().length > 0) ? parseInt($(free_plan_add).val()) : 0
                };
                itemList.push(item);
            }
        }
        groupData.plan_lv = itemList;
    } else if(estimateAdd == "accumulated" || estimateAdd == "step"){
        var itemList = [];
        var count = $('#planLevelAdd .level_plan_add').length;
        if(count > 0){
            for(var i=0; i<count; i++){
                var level_plan_add = $("#planLevelAdd").find('.level_plan_add')[i];
                var price_plan_add = $("#planLevelAdd").find('.price_plan_add')[i];
                var free_plan_add = $("#planLevelAdd").find('.free_plan_add')[i];
                var item = {
                    "level": ($(level_plan_add).val() != null && $(level_plan_add).val().length > 0) ? parseInt($(level_plan_add).val()) : null,
                    "price": ($(price_plan_add).val() != null && $(price_plan_add).val().length > 0) ? parseInt($(price_plan_add).val()) : 0
                };
                itemList.push(item);
            }
        }
        groupData.plan_lv = itemList;
    }

    console.log(groupData);

    StartProcess();
    var r = jsRoutes.controllers.PayPackDataController.addNewPackdata();
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
                getListPackdata();
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

function choosePaymentType() {
    var pay = $("#paymentTypeAdd").val();
    if(pay == "POSTPAID"){
        var option = '<option value="PERIODIC" selected>'+Messages("Định kỳ")+'</option>';
        $("#typePeriodAdd").html(option);

        document.getElementById("divCalUnitAdd").style.display = "block";
    } else {
        var option = '<option value="PERIODIC" selected>'+Messages("Định kỳ")+'</option>'+
            '<option value="ONCE">'+Messages("Một lần")+'</option>';
        $("#typePeriodAdd").html(option);
    }
}

function choosePeriodType() {
    var pe = $("#typePeriodAdd").val();
    if(pe == "ONCE") {
        document.getElementById("divCalUnitAdd").style.display = "none";
    } else {
        document.getElementById("divCalUnitAdd").style.display = "block";
    }
}

$('#numberBuyPlanAdd').on('input', function() {
    var z = parseInt($(this).val());
    console.log(z);
    if(z >= 0){
        var estimateAdd = $("#estimateAdd").val();

        if(estimateAdd == "fix"){//Cố định
            var price = parseInt($("#priceAdd").val());
            $("#moneyBuyPlanAdd").html(Messages(" thì tổng số tiền phải thanh toán là ") + price + Messages(" VND"));
        } else if(estimateAdd == "unit"){//Theo đơn vị
            var price = parseInt($("#priceAdd").val());
            var total = (z - parseInt($("#numberFreeAdd").val())) * price;
            $("#moneyBuyPlanAdd").html(Messages(" thì tổng số tiền phải thanh toán là ") + (total > 0 ? total : 0) + Messages(" VND"));
        } else if(estimateAdd == "mass"){//Khối lượng
            var plan = document.getElementsByClassName("level_plan_add");

            if(plan.length == 1){
                var price = parseInt($("#pricePlanAdd0").val());
                var total = (z - parseInt($("#freePlanAdd0").val())) * price;
                $("#moneyBuyPlanAdd").html(Messages(" thì tổng số tiền phải thanh toán là ") + (total > 0 ? total : 0) + Messages(" VND"));
            } else {
                for(var i=1; i<plan.length; i++){
                    var valuePrev = parseInt(plan[i-1].value); //10 price 2000 free 10
                    var value = plan[i].value; //vc price 2100 free 20

                    var idPrev = plan[i-1].id;
                    var id = plan[i].id;

                    var sttPrev = idPrev.replace("levelPlanAdd","");
                    var stt = id.replace("levelPlanAdd","");
                    console.log(i, " - " ,z, valuePrev);
                    console.log("value - " , value);
                    if(value.length > 0){
                        if(z > valuePrev && z <= parseInt(value)){
                            var free = parseInt($("#freePlanAdd"+stt).val());
                            var price = parseInt($("#pricePlanAdd"+stt).val());
                            console.log(free, price);
                            var total = (z - free) * price;
                            $("#moneyBuyPlanAdd").html(Messages(" thì tổng số tiền phải thanh toán là ") + (total > 0 ? total : 0) + Messages(" VND"));
                            break;
                        } else {
                            if(z <= valuePrev){
                                var free = parseInt($("#freePlanAdd"+sttPrev).val());
                                var price = parseInt($("#pricePlanAdd"+sttPrev).val());
                                console.log(free, price);
                                var total = (z - free) * price;
                                $("#moneyBuyPlanAdd").html(Messages(" thì tổng số tiền phải thanh toán là ") + (total > 0 ? total : 0) + Messages(" VND"));
                                break;
                            }
                        }
                    } else {
                        console.log(z, valuePrev);
                        if(z <= valuePrev){
                            var free = parseInt($("#freePlanAdd"+sttPrev).val());
                            var price = parseInt($("#pricePlanAdd"+sttPrev).val());
                            console.log(free, price);
                            var total = (z - free) * price;
                            $("#moneyBuyPlanAdd").html(Messages(" thì tổng số tiền phải thanh toán là ") + (total > 0 ? total : 0) + Messages(" VND"));
                        } else {
                            var free = parseInt($("#freePlanAdd"+stt).val());
                            var price = parseInt($("#pricePlanAdd"+stt).val());
                            console.log(free, price);
                            var total = (z - free) * price;
                            $("#moneyBuyPlanAdd").html(Messages(" thì tổng số tiền phải thanh toán là ") + (total > 0 ? total : 0) + Messages(" VND"));
                        }
                    }

                }
            }

        } else if(estimateAdd == "accumulated") {//Lũy kế
            var plan = document.getElementsByClassName("level_plan_add");
            var total = 0;
            for(var i=0; i<plan.length; i++){
                var value = plan[i].value;
                var id = plan[i].id;
                var stt = id.replace("levelPlanAdd","");
                console.log(value, id, stt);
                if(value == ""){
                    if(i == 0){
                        total += z * parseInt($("#pricePlanAdd"+stt).val());
                    } else {
                        var idPrev = plan[i-1].id;
                        var sttPrev = idPrev.replace("levelPlanAdd","");
                        total += (z - parseInt($("#levelPlanAdd"+sttPrev).val())) * parseInt($("#pricePlanAdd"+stt).val());
                    }
                    break;
                } else {
                    if(z > parseInt(value)){
                        if(i == 0){
                            total += parseInt($("#levelPlanAdd"+stt).val()) * parseInt($("#pricePlanAdd"+stt).val());
                        } else {
                            var idPrev = plan[i-1].id;
                            var sttPrev = idPrev.replace("levelPlanAdd","");
                            total += (parseInt($("#levelPlanAdd"+stt).val()) - parseInt($("#levelPlanAdd"+sttPrev).val())) * parseInt($("#pricePlanAdd"+stt).val());
                        }
                    } else {
                        if(i == 0){
                            total += z * parseInt($("#pricePlanAdd"+stt).val());
                        } else {
                            var idPrev = plan[i-1].id;
                            var sttPrev = idPrev.replace("levelPlanAdd","");
                            total += (z - parseInt($("#levelPlanAdd"+sttPrev).val())) * parseInt($("#pricePlanAdd"+stt).val());
                        }
                        break;
                    }
                }
                console.log(total);
            }
            $("#moneyBuyPlanAdd").html(Messages(" thì tổng số tiền phải thanh toán là ") + (total > 0 ? total : 0) + Messages(" VND"));
        }
    } else {
        showNotification('danger', Messages("Bạn phải điền số lượng mua lớn hơn 0"));
    }

});

function resetMoneyBuyPlan() {
    $('#numberBuyPlanAdd').val(0);
    $("#moneyBuyPlanAdd").html(Messages(" thì tổng số tiền phải thanh toán là 0 VND"));
}