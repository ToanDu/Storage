package models.forms;

public class UserForm extends AbstractFormModel {
    private String groupId;
    private String newGroupId;
    private String id;
    private String listUsrid;
    private String username;
    private String email;
    private String password;
    private String repeatpassword;
    private int role;
    private int roleVessel;
    private String phone;
    private String med;
    private boolean active;
    private String lastModified;
    private int vip;
    private int countMissionInDay;
    private int monneyNap;

    private String chuTaiKhoan;
    private String soTaiKhoan;
    private String tenNganHang;

    private int increaseMoney;

    public UserForm() {
    }

    public int getIncreaseMoney() {
        return increaseMoney;
    }

    public void setIncreaseMoney(int increaseMoney) {
        this.increaseMoney = increaseMoney;
    }

    public int getMonneyNap() {
        return monneyNap;
    }

    public void setMonneyNap(int monneyNap) {
        this.monneyNap = monneyNap;
    }

    public String getChuTaiKhoan() {
        return chuTaiKhoan;
    }

    public void setChuTaiKhoan(String chuTaiKhoan) {
        this.chuTaiKhoan = chuTaiKhoan;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public String getTenNganHang() {
        return tenNganHang;
    }

    public void setTenNganHang(String tenNganHang) {
        this.tenNganHang = tenNganHang;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatpassword() {
        return repeatpassword;
    }

    public void setRepeatpassword(String repeatpassword) {
        this.repeatpassword = repeatpassword;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getListUsrid() {
        return listUsrid;
    }

    public void setListUsrid(String listUsrid) {
        this.listUsrid = listUsrid;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getNewGroupId() {
        return newGroupId;
    }

    public void setNewGroupId(String newGroupId) {
        this.newGroupId = newGroupId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRoleVessel() {
        return roleVessel;
    }

    public void setRoleVessel(int roleVessel) {
        this.roleVessel = roleVessel;
    }

    public String getMed() {
        return med;
    }

    public void setMed(String med) {
        this.med = med;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    public int getCountMissionInDay() {
        return countMissionInDay;
    }

    public void setCountMissionInDay(int countMissionInDay) {
        this.countMissionInDay = countMissionInDay;
    }
}
