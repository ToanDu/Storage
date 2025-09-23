package vn.m2m.common.models.forms;

public class LoginForm {
    private String username;
    private String password;
    private String clicklogin ;
    private String passwordRepeat;
    private boolean isRegisterForm=false;

    private String loginChallenge;
    private String projectID;
    private String appKey;
    private String appSecret;

    private String recaptcharespone;

    public LoginForm(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public String getclicklogin() {
        return clicklogin;
    }

    public void setclicklogin(String clicklogin) {
        this.clicklogin = clicklogin;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public boolean isRegisterForm() {
        return isRegisterForm;
    }

    public void setIsRegisterForm(boolean isRegisterForm) {
        this.isRegisterForm = isRegisterForm;
    }

    public String getRecaptcharespone() {
        return recaptcharespone;
    }

    public void setRecaptcharespone(String recaptcharespone) {
        this.recaptcharespone = recaptcharespone;
    }

    public String getLoginChallenge() {
        return loginChallenge;
    }

    public void setLoginChallenge(String loginChallenge) {
        this.loginChallenge = loginChallenge;
    }

    public String getProjectID() { return this.projectID; }
    public void setProjectID(String projectID) { this.projectID = projectID; }

    public String getAppKey() { return this.appKey; }
    public void setAppKey(String appKey) { this.appKey = appKey; }

    public String getAppSecret() { return this.appSecret; }
    public void setAppSecret(String appSecret) { this.appSecret = appSecret; }
}
