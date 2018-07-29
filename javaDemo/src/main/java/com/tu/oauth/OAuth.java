package com.tu.oauth;

/**
 * Created by tuyongjian on 2018/7/29.
 */
public class OAuth {

    private String acces_token;

    private String refresh_token;

    private String token_type;

    private int expires_in;

    public String getAcces_token() {
        return acces_token;
    }

    public void setAcces_token(String acces_token) {
        this.acces_token = acces_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }


    @Override
    public String toString() {
        return "OAuth{" +
                "acces_token='" + acces_token + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                ", token_type='" + token_type + '\'' +
                ", expires_in=" + expires_in +
                '}';
    }
}
