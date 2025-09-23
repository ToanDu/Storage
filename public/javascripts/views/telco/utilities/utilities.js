/**
 * Created by vtk-anhlt166 on 1/4/23.
 */
$(document).ready(function () {
    getListPackMiAddOn();

    setTimeout(function () {
        getListHistoryRechargeByAction();
    },2000);
});