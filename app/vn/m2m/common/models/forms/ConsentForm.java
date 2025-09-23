package vn.m2m.common.models.forms;

import java.lang.reflect.Array;

public class ConsentForm {
    private String consentChallenge;
    private String[] grantScope;

    public ConsentForm(){

    }

    public String getConsentChallenge() {
        return consentChallenge;
    }

    public void setConsentChallenge(String consentChallenge) {
        this.consentChallenge = consentChallenge;
    }

    public String[] getGrantScope() {
        return grantScope;
    }

    public void setGrantScope(String[] grantScope) {
        this.grantScope = grantScope;
    }
}
