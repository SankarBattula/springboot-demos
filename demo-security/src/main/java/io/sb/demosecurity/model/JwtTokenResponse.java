package io.sb.demosecurity.model;

public class JwtTokenResponse {
    private String accessToken;

    public JwtTokenResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
