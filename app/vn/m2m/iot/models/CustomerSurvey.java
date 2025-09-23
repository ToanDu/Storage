package vn.m2m.iot.models;

import org.springframework.data.annotation.Id;
import vn.m2m.common.HazelcastTTL;
import vn.m2m.common.ModelData;
import vn.m2m.utils.DateUtil;
import vn.m2m.utils.StringUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ModelData(collection = "CustomerSurvey", mapCacheName = "", mapCacheTTL = HazelcastTTL.TTL_1_DAY)
public class CustomerSurvey implements Serializable {
    private static final long serialVersionUID = 1L; //1L

    @Id
    private String id;
    private String username;
    private String tenKhachHang;
    private String ngLienHe;
    private String chucVu;
    private int soThueBao;
    private String phone;
    private Date logDate;

    private String nameEnterprise;
    private String typeBusiness;
    private String typeDevice;

    private boolean isSurvey;
    private int experience;
    private int easeUse;
    private String sometimeUse;
    private int manageSubs;
    private int manageContract;
    private int manageOrder;
    private int blockSub;
    private int open1Way;
    private int open2Way;
    private int rechargeMoney;
    private int miAddon;
    private String contentFeedback;
    private int payFeeConnect;
    private int payFeePackage;
    private int payFeeOpenSub;
    private int payFeeBlockSub;
    private int payFeeRecharge;
    private int payFeeMiAddon;
    private String extraFeatures;
    private String hard;
    private String contentUsePlatformOther;
    private String contentFeeOneMonth;
    private String hardMonth;
    private int realyUse;

    private String batTien;
    private String tinhNangBoSung;
    private String tietKiemChiPhi;
    private String tietKiemThoiGian;
    private String suDungThuanLoi;
    private int pointExperience;
    private String bietQuanLyHopDong;
    private String bietMuaGoiDataMi;
    private String bietNapTien;
    private String bietMoChanChieu;
    private String bietDauNoiDatHang;
    private String bietUserPhanQuyen;
    private String duyTriDoiNguPhatTrien;
    private String pointPayMoney;
    private String mongMuonBoSung;

    private String q1;
    private String q2;
    private String q3;
    private String q4;
    private String q5;
    private String q6;
    private String q7;
    private String q8;
    private String q9;
    private String q10;
    private String q11;
    private String q12;
    private String q13;
    private String q14;
    private String q15;
    private String q16;
    private String q17;
    private String q18;
    private String q19;
    private String q20;
    private String q21;

    public CustomerSurvey() {
        this.id = StringUtil.getTimeUUIDString();
        this.logDate = DateUtil.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public boolean isSurvey() {
        return isSurvey;
    }

    public void setSurvey(boolean survey) {
        isSurvey = survey;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getEaseUse() {
        return easeUse;
    }

    public void setEaseUse(int easeUse) {
        this.easeUse = easeUse;
    }

    public String getSometimeUse() {
        return sometimeUse;
    }

    public void setSometimeUse(String sometimeUse) {
        this.sometimeUse = sometimeUse;
    }

    public int getManageSubs() {
        return manageSubs;
    }

    public void setManageSubs(int manageSubs) {
        this.manageSubs = manageSubs;
    }

    public int getManageContract() {
        return manageContract;
    }

    public void setManageContract(int manageContract) {
        this.manageContract = manageContract;
    }

    public int getManageOrder() {
        return manageOrder;
    }

    public void setManageOrder(int manageOrder) {
        this.manageOrder = manageOrder;
    }

    public int getBlockSub() {
        return blockSub;
    }

    public void setBlockSub(int blockSub) {
        this.blockSub = blockSub;
    }

    public int getOpen1Way() {
        return open1Way;
    }

    public void setOpen1Way(int open1Way) {
        this.open1Way = open1Way;
    }

    public int getOpen2Way() {
        return open2Way;
    }

    public void setOpen2Way(int open2Way) {
        this.open2Way = open2Way;
    }

    public int getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(int rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    public int getMiAddon() {
        return miAddon;
    }

    public void setMiAddon(int miAddon) {
        this.miAddon = miAddon;
    }

    public String getContentFeedback() {
        return contentFeedback;
    }

    public void setContentFeedback(String contentFeedback) {
        this.contentFeedback = contentFeedback;
    }

    public int getPayFeeConnect() {
        return payFeeConnect;
    }

    public void setPayFeeConnect(int payFeeConnect) {
        this.payFeeConnect = payFeeConnect;
    }

    public int getPayFeePackage() {
        return payFeePackage;
    }

    public void setPayFeePackage(int payFeePackage) {
        this.payFeePackage = payFeePackage;
    }

    public int getPayFeeOpenSub() {
        return payFeeOpenSub;
    }

    public void setPayFeeOpenSub(int payFeeOpenSub) {
        this.payFeeOpenSub = payFeeOpenSub;
    }

    public int getPayFeeBlockSub() {
        return payFeeBlockSub;
    }

    public void setPayFeeBlockSub(int payFeeBlockSub) {
        this.payFeeBlockSub = payFeeBlockSub;
    }

    public int getPayFeeRecharge() {
        return payFeeRecharge;
    }

    public void setPayFeeRecharge(int payFeeRecharge) {
        this.payFeeRecharge = payFeeRecharge;
    }

    public int getPayFeeMiAddon() {
        return payFeeMiAddon;
    }

    public void setPayFeeMiAddon(int payFeeMiAddon) {
        this.payFeeMiAddon = payFeeMiAddon;
    }

    public String getExtraFeatures() {
        return extraFeatures;
    }

    public void setExtraFeatures(String extraFeatures) {
        this.extraFeatures = extraFeatures;
    }

    public String getHard() {
        return hard;
    }

    public void setHard(String hard) {
        this.hard = hard;
    }

    public String getContentUsePlatformOther() {
        return contentUsePlatformOther;
    }

    public void setContentUsePlatformOther(String contentUsePlatformOther) {
        this.contentUsePlatformOther = contentUsePlatformOther;
    }

    public String getContentFeeOneMonth() {
        return contentFeeOneMonth;
    }

    public void setContentFeeOneMonth(String contentFeeOneMonth) {
        this.contentFeeOneMonth = contentFeeOneMonth;
    }

    public String getNameEnterprise() {
        return nameEnterprise;
    }

    public void setNameEnterprise(String nameEnterprise) {
        this.nameEnterprise = nameEnterprise;
    }

    public String getTypeBusiness() {
        return typeBusiness;
    }

    public void setTypeBusiness(String typeBusiness) {
        this.typeBusiness = typeBusiness;
    }

    public String getTypeDevice() {
        return typeDevice;
    }

    public void setTypeDevice(String typeDevice) {
        this.typeDevice = typeDevice;
    }

    public String getHardMonth() {
        return hardMonth;
    }

    public void setHardMonth(String hardMonth) {
        this.hardMonth = hardMonth;
    }

    public int getRealyUse() {
        return realyUse;
    }

    public void setRealyUse(int realyUse) {
        this.realyUse = realyUse;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getNgLienHe() {
        return ngLienHe;
    }

    public void setNgLienHe(String ngLienHe) {
        this.ngLienHe = ngLienHe;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public int getSoThueBao() {
        return soThueBao;
    }

    public void setSoThueBao(int soThueBao) {
        this.soThueBao = soThueBao;
    }

    public String getBatTien() {
        return batTien;
    }

    public void setBatTien(String batTien) {
        this.batTien = batTien;
    }

    public String getTinhNangBoSung() {
        return tinhNangBoSung;
    }

    public void setTinhNangBoSung(String tinhNangBoSung) {
        this.tinhNangBoSung = tinhNangBoSung;
    }

    public String getTietKiemChiPhi() {
        return tietKiemChiPhi;
    }

    public void setTietKiemChiPhi(String tietKiemChiPhi) {
        this.tietKiemChiPhi = tietKiemChiPhi;
    }

    public String getTietKiemThoiGian() {
        return tietKiemThoiGian;
    }

    public void setTietKiemThoiGian(String tietKiemThoiGian) {
        this.tietKiemThoiGian = tietKiemThoiGian;
    }

    public String getSuDungThuanLoi() {
        return suDungThuanLoi;
    }

    public void setSuDungThuanLoi(String suDungThuanLoi) {
        this.suDungThuanLoi = suDungThuanLoi;
    }

    public int getPointExperience() {
        return pointExperience;
    }

    public void setPointExperience(int pointExperience) {
        this.pointExperience = pointExperience;
    }

    public String getBietQuanLyHopDong() {
        return bietQuanLyHopDong;
    }

    public void setBietQuanLyHopDong(String bietQuanLyHopDong) {
        this.bietQuanLyHopDong = bietQuanLyHopDong;
    }

    public String getBietMuaGoiDataMi() {
        return bietMuaGoiDataMi;
    }

    public void setBietMuaGoiDataMi(String bietMuaGoiDataMi) {
        this.bietMuaGoiDataMi = bietMuaGoiDataMi;
    }

    public String getBietNapTien() {
        return bietNapTien;
    }

    public void setBietNapTien(String bietNapTien) {
        this.bietNapTien = bietNapTien;
    }

    public String getBietMoChanChieu() {
        return bietMoChanChieu;
    }

    public void setBietMoChanChieu(String bietMoChanChieu) {
        this.bietMoChanChieu = bietMoChanChieu;
    }

    public String getBietDauNoiDatHang() {
        return bietDauNoiDatHang;
    }

    public void setBietDauNoiDatHang(String bietDauNoiDatHang) {
        this.bietDauNoiDatHang = bietDauNoiDatHang;
    }

    public String getBietUserPhanQuyen() {
        return bietUserPhanQuyen;
    }

    public void setBietUserPhanQuyen(String bietUserPhanQuyen) {
        this.bietUserPhanQuyen = bietUserPhanQuyen;
    }

    public String getDuyTriDoiNguPhatTrien() {
        return duyTriDoiNguPhatTrien;
    }

    public void setDuyTriDoiNguPhatTrien(String duyTriDoiNguPhatTrien) {
        this.duyTriDoiNguPhatTrien = duyTriDoiNguPhatTrien;
    }

    public String getMongMuonBoSung() {
        return mongMuonBoSung;
    }

    public void setMongMuonBoSung(String mongMuonBoSung) {
        this.mongMuonBoSung = mongMuonBoSung;
    }

    public String getPointPayMoney() {
        return pointPayMoney;
    }

    public void setPointPayMoney(String pointPayMoney) {
        this.pointPayMoney = pointPayMoney;
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

    public String getQ4() {
        return q4;
    }

    public void setQ4(String q4) {
        this.q4 = q4;
    }

    public String getQ5() {
        return q5;
    }

    public void setQ5(String q5) {
        this.q5 = q5;
    }

    public String getQ6() {
        return q6;
    }

    public void setQ6(String q6) {
        this.q6 = q6;
    }

    public String getQ7() {
        return q7;
    }

    public void setQ7(String q7) {
        this.q7 = q7;
    }

    public String getQ8() {
        return q8;
    }

    public void setQ8(String q8) {
        this.q8 = q8;
    }

    public String getQ9() {
        return q9;
    }

    public void setQ9(String q9) {
        this.q9 = q9;
    }

    public String getQ10() {
        return q10;
    }

    public void setQ10(String q10) {
        this.q10 = q10;
    }

    public String getQ11() {
        return q11;
    }

    public void setQ11(String q11) {
        this.q11 = q11;
    }

    public String getQ12() {
        return q12;
    }

    public void setQ12(String q12) {
        this.q12 = q12;
    }

    public String getQ13() {
        return q13;
    }

    public void setQ13(String q13) {
        this.q13 = q13;
    }

    public String getQ14() {
        return q14;
    }

    public void setQ14(String q14) {
        this.q14 = q14;
    }

    public String getQ15() {
        return q15;
    }

    public void setQ15(String q15) {
        this.q15 = q15;
    }

    public String getQ16() {
        return q16;
    }

    public void setQ16(String q16) {
        this.q16 = q16;
    }

    public String getQ17() {
        return q17;
    }

    public void setQ17(String q17) {
        this.q17 = q17;
    }

    public String getQ18() {
        return q18;
    }

    public void setQ18(String q18) {
        this.q18 = q18;
    }

    public String getQ19() {
        return q19;
    }

    public void setQ19(String q19) {
        this.q19 = q19;
    }

    public String getQ20() {
        return q20;
    }

    public void setQ20(String q20) {
        this.q20 = q20;
    }

    public String getQ21() {
        return q21;
    }

    public void setQ21(String q21) {
        this.q21 = q21;
    }
}
