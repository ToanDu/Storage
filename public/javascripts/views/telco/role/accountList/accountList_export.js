/**
 * Created by vtk-anhlt166 on 3/6/23.
 */
const pagesize = 1000;
var tableExportAccountList;
var sttExport = 0;
var totalExport = 0;
var arrayExport = new Array;
function AccountExportObject() {
    this.stt = "";
    this.email = "";
    this.fullname = "";
    this.sdt = "";
    this.nameCompany = "";
    this.gpkd = "";
    this.role = "";
}
function exportAccountList(index) {
    if(index == 1){
        tableExportAccountList = null;
        StartProcess();
        sttExport = 0;
        totalExport = 0;

        arrayExport = [];
        var header = new AccountExportObject();
        header.stt = Messages("STT");
        header.email = Messages("Email");
        header.fullname = Messages("Họ tên");
        header.sdt = Messages("SĐT");
        header.nameCompany = Messages("Tên doanh nghiệp");
        header.gpkd = Messages("GPKD");
        header.role = Messages("Quyền TK");
        arrayExport.push(header);
    }

    var body = new FormData();
    body.email = $("#email").val().trim();
    body.cmpRole = $("#roleCmp").val();
    body.nameDN = $("#nameDN").val();
    body.gpkd = $("#gpdn").val();
    body.page = index;
    body.pageSize = pagesize;
    console.log(body);

    var r = jsRoutes.controllers.TelcoRoleAccountController.getListAccountCmp();
    $.ajax({
        type: r.type,
        data: JSON.stringify(body),
        contentType: "application/json; charset=utf-8",
        url: r.url,
        success: function(datas){
            console.log(datas);
            if(datas.content != null && datas.content.users != null && datas.content.users.length > 0){
                for (var i = 0; i < datas.content.users.length; i++){
                    var newObject = new AccountExportObject();
                    newObject.stt = sttExport + 1;
                    newObject.email = datas.content.users[i].email;
                    newObject.fullname = datas.content.users[i].name != null ? datas.content.users[i].name : "";
                    newObject.sdt = datas.content.users[i].phone;
                    newObject.nameCompany = datas.content.users[i].enterprise_name != null ? datas.content.users[i].enterprise_name : "";
                    newObject.gpkd = datas.content.users[i].enterprise_business_license != null ? datas.content.users[i].enterprise_business_license : "";
                    newObject.role = getRoleNameByCode(datas.content.users[i].cmp_role);

                    arrayExport.push(newObject);

                    sttExport++;
                }

                totalExport = datas.content.total;
            }
        },
        error: function (xhr) {
            console.log(xhr);
            showNotification('danger',Messages("connection.failed"));
        },
        complete: function (){
            if(totalExport > 0 && sttExport < totalExport){
                exportAccountList(index+1);
            } else {
                FinishProcess();

                if(sttExport == 0){
                    showNotification('danger',Messages("Không có dữ liệu"));
                    return;
                }

                alasql("SELECT * INTO XLSX('Danh_sach_tai_khoan.xlsx',{headers:false}) FROM ? ", [arrayExport]);
            }
        }
    })
}