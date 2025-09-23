package vn.m2m.iot.form;

import org.apache.commons.lang.StringUtils;
import play.data.validation.ValidationError;
import play.mvc.Http;
import vn.m2m.utils.ImageUtil;

import java.util.ArrayList;
import java.util.List;

import static play.mvc.Controller.request;

/**
 * Created by vtk-anhlt166 on 10/26/22.
 */
public class AccountTelcoForm extends AbstractFormModel {
    private String hoTen;
    private String cmnd;
    private String sdt;
    private String ngaySinh;
    private String quocTich;
    private String tinhTP;
    private String quanHuyen;
    private String phuongXa;
    private String diaBan;
    private String diaChiChiTiet;
    private String gioiTinh;
    private String emailContact;
    private String sdtContact;


    private String idDoanhNghiep;
    private String tenDoanhNghiep;
    private String maSoThue;
    private String soGpkd;
    private String ngayThanhLap;
    private String sdtDN;
    private String emailDN;
    private String tinhTpDN;
    private String quanHuyenDN;
    private String phuongXaDN;
    private String diaBanDN;
    private String diaChiChiTietDN;
    private boolean changeInfoDN;
    private String dsLinhVuc;
    private String dsDongThietBi;

    private String imgOld1;
    private String imgOld2;
    private String imgOld3;
    private String imgOld4;
    private String imgOld5;
    private String imgOld6;

    private String imageName1;
    private String imageName2;
    private String imageName3;
    private String imageName5;
    private String imageName6;
    private Http.MultipartFormData.FilePart image_1;
    private Http.MultipartFormData.FilePart image_2;
    private Http.MultipartFormData.FilePart image_3;
    private Http.MultipartFormData.FilePart image_4;
    private Http.MultipartFormData.FilePart image_5;
    private Http.MultipartFormData.FilePart image_6;

    public List<ValidationError> validate() {
        List<ValidationError> errors = new ArrayList<ValidationError>();
        Http.MultipartFormData data = request().body().asMultipartFormData();

        if (data != null){
            if(data.getFile("image_1") != null){
                if(!StringUtils.isEmpty(data.getFile("image_1").getFilename())){
                    image_1 = data.getFile("image_1");
                    String contenttype = ImageUtil.getImageType(image_1.getFilename());

                    if(!ImageUtil.checkValidImageType(contenttype)){
                        errors.add(new ValidationError("image_1", "wrong format image"));
                    }
                }
            }
            if(data.getFile("image_2") != null){
                if(!StringUtils.isEmpty(data.getFile("image_2").getFilename())){
                    image_2 = data.getFile("image_2");
                    String contenttype = ImageUtil.getImageType(image_2.getFilename());

                    if(!ImageUtil.checkValidImageType(contenttype)){
                        errors.add(new ValidationError("image_2", "wrong format image"));
                    }
                }
            }
            if(data.getFile("image_3") != null){
                if(!StringUtils.isEmpty(data.getFile("image_3").getFilename())){
                    image_3 = data.getFile("image_3");
                    String contenttype = ImageUtil.getImageType(image_3.getFilename());

                    if(!ImageUtil.checkValidImageType(contenttype)){
                        errors.add(new ValidationError("image_3", "wrong format image"));
                    }
                }
            }
            if(data.getFile("image_4") != null){
                if(!StringUtils.isEmpty(data.getFile("image_4").getFilename())){
                    image_4 = data.getFile("image_4");
                    String contenttype = ImageUtil.getImageType(image_4.getFilename());

                    if(!ImageUtil.checkValidImageType(contenttype)){
                        errors.add(new ValidationError("image_4", "wrong format image"));
                    }
                }
            }
            if(data.getFile("image_5") != null){
                if(!StringUtils.isEmpty(data.getFile("image_5").getFilename())){
                    image_5 = data.getFile("image_5");
                    String contenttype = ImageUtil.getImageType(image_5.getFilename());

                    if(!ImageUtil.checkValidImageType(contenttype)){
                        errors.add(new ValidationError("image_5", "wrong format image"));
                    }
                }
            }
            if(data.getFile("image_6") != null){
                if(!StringUtils.isEmpty(data.getFile("image_6").getFilename())){
                    image_6 = data.getFile("image_6");
                    String contenttype = ImageUtil.getImageType(image_6.getFilename());

                    if(!ImageUtil.checkValidImageType(contenttype)){
                        errors.add(new ValidationError("image_6", "wrong format image"));
                    }
                }
            }
        }

        return errors.isEmpty() ? null : errors;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmailContact() {
        return emailContact;
    }
    public String getSdtContact() {
        return sdtContact;
    }
    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public void setSdtContact(String sdtContact) {
        this.sdtContact = sdtContact;
    }
    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getTinhTP() {
        return tinhTP;
    }

    public void setTinhTP(String tinhTP) {
        this.tinhTP = tinhTP;
    }

    public String getQuanHuyen() {
        return quanHuyen;
    }

    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }

    public String getPhuongXa() {
        return phuongXa;
    }

    public void setPhuongXa(String phuongXa) {
        this.phuongXa = phuongXa;
    }

    public String getDiaBan() {
        return diaBan;
    }

    public void setDiaBan(String diaBan) {
        this.diaBan = diaBan;
    }

    public String getDiaChiChiTiet() {
        return diaChiChiTiet;
    }

    public void setDiaChiChiTiet(String diaChiChiTiet) {
        this.diaChiChiTiet = diaChiChiTiet;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getIdDoanhNghiep() {
        return idDoanhNghiep;
    }

    public void setIdDoanhNghiep(String idDoanhNghiep) {
        this.idDoanhNghiep = idDoanhNghiep;
    }

    public String getTenDoanhNghiep() {
        return tenDoanhNghiep;
    }

    public void setTenDoanhNghiep(String tenDoanhNghiep) {
        this.tenDoanhNghiep = tenDoanhNghiep;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public String getSoGpkd() {
        return soGpkd;
    }

    public void setSoGpkd(String soGpkd) {
        this.soGpkd = soGpkd;
    }

    public String getNgayThanhLap() {
        return ngayThanhLap;
    }

    public void setNgayThanhLap(String ngayThanhLap) {
        this.ngayThanhLap = ngayThanhLap;
    }

    public String getSdtDN() {
        return sdtDN;
    }

    public void setSdtDN(String sdtDN) {
        this.sdtDN = sdtDN;
    }

    public String getEmailDN() {
        return emailDN;
    }

    public void setEmailDN(String emailDN) {
        this.emailDN = emailDN;
    }

    public String getTinhTpDN() {
        return tinhTpDN;
    }

    public void setTinhTpDN(String tinhTpDN) {
        this.tinhTpDN = tinhTpDN;
    }

    public String getQuanHuyenDN() {
        return quanHuyenDN;
    }

    public void setQuanHuyenDN(String quanHuyenDN) {
        this.quanHuyenDN = quanHuyenDN;
    }

    public String getPhuongXaDN() {
        return phuongXaDN;
    }

    public void setPhuongXaDN(String phuongXaDN) {
        this.phuongXaDN = phuongXaDN;
    }

    public String getDiaBanDN() {
        return diaBanDN;
    }

    public void setDiaBanDN(String diaBanDN) {
        this.diaBanDN = diaBanDN;
    }

    public String getDiaChiChiTietDN() {
        return diaChiChiTietDN;
    }

    public void setDiaChiChiTietDN(String diaChiChiTietDN) {
        this.diaChiChiTietDN = diaChiChiTietDN;
    }

    public String getImgOld1() {
        return imgOld1;
    }

    public void setImgOld1(String imgOld1) {
        this.imgOld1 = imgOld1;
    }

    public String getImgOld2() {
        return imgOld2;
    }

    public void setImgOld2(String imgOld2) {
        this.imgOld2 = imgOld2;
    }

    public String getImgOld3() {
        return imgOld3;
    }

    public void setImgOld3(String imgOld3) {
        this.imgOld3 = imgOld3;
    }

    public String getImgOld4() {
        return imgOld4;
    }

    public void setImgOld4(String imgOld4) {
        this.imgOld4 = imgOld4;
    }

    public String getImgOld5() {
        return imgOld5;
    }

    public void setImgOld5(String imgOld5) {
        this.imgOld5 = imgOld5;
    }

    public Http.MultipartFormData.FilePart getImage_1() {
        return image_1;
    }

    public void setImage_1(Http.MultipartFormData.FilePart image_1) {
        this.image_1 = image_1;
    }

    public Http.MultipartFormData.FilePart getImage_2() {
        return image_2;
    }

    public void setImage_2(Http.MultipartFormData.FilePart image_2) {
        this.image_2 = image_2;
    }

    public Http.MultipartFormData.FilePart getImage_3() {
        return image_3;
    }

    public void setImage_3(Http.MultipartFormData.FilePart image_3) {
        this.image_3 = image_3;
    }

    public Http.MultipartFormData.FilePart getImage_4() {
        return image_4;
    }

    public void setImage_4(Http.MultipartFormData.FilePart image_4) {
        this.image_4 = image_4;
    }

    public Http.MultipartFormData.FilePart getImage_5() {
        return image_5;
    }

    public void setImage_5(Http.MultipartFormData.FilePart image_5) {
        this.image_5 = image_5;
    }

    public String getImgOld6() {
        return imgOld6;
    }

    public String getImageName1() {
        return imageName1;
    }

    public void setImageName1(String imageName1) {
        this.imageName1 = imageName1;
    }

    public String getImageName2() {
        return imageName2;
    }

    public void setImageName2(String imageName2) {
        this.imageName2 = imageName2;
    }

    public String getImageName3() {
        return imageName3;
    }

    public void setImageName3(String imageName3) {
        this.imageName3 = imageName3;
    }

    public String getImageName5() {
        return imageName5;
    }

    public void setImageName5(String imageName5) {
        this.imageName5 = imageName5;
    }

    public String getImageName6() {
        return imageName6;
    }

    public void setImageName6(String imageName6) {
        this.imageName6 = imageName6;
    }

    public void setImgOld6(String imgOld6) {
        this.imgOld6 = imgOld6;
    }

    public Http.MultipartFormData.FilePart getImage_6() {
        return image_6;
    }

    public void setImage_6(Http.MultipartFormData.FilePart image_6) {
        this.image_6 = image_6;
    }

    public boolean isChangeInfoDN() {
        return changeInfoDN;
    }

    public void setChangeInfoDN(boolean changeInfoDN) {
        this.changeInfoDN = changeInfoDN;
    }

    public String getDsLinhVuc() {
        return dsLinhVuc;
    }

    public void setDsLinhVuc(String dsLinhVuc) {
        this.dsLinhVuc = dsLinhVuc;
    }

    public String getDsDongThietBi() {
        return dsDongThietBi;
    }

    public void setDsDongThietBi(String dsDongThietBi) {
        this.dsDongThietBi = dsDongThietBi;
    }
}
