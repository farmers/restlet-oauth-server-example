package org.restlet.example.ext.oauth.server.external;

import com.google.gson.annotations.SerializedName;

/**
 * Stores the token response as a POJO.
 * 
 * @author Bret K. Ikehara
 */
public class TokenModel {

  @SerializedName("expires_in")
  private long expires;

  @SerializedName("token_type")
  private String tokenType;

  @SerializedName("refresh_token")
  private String refreshToken;

  @SerializedName("access_token")
  private String accessToken;

  /**
   * Gets this expires value.
   * 
   * @return long
   */
  public long getExpires() {
    return expires;
  }

  /**
   * Sets this expires value.
   * 
   * @param expires long
   */
  public void setExpires(long expires) {
    this.expires = expires;
  }

  /**
   * Gets this token type.
   * 
   * @return {@link String}
   */
  public String getTokenType() {
    return tokenType;
  }

  /**
   * Sets this token type.
   * 
   * @param tokenType {@link String}
   */
  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }

  /**
   * Gets this refresh token.
   * 
   * @return {@link String}
   */
  public String getRefreshToken() {
    return refreshToken;
  }

  /**
   * Sets this refresh token. 
   * 
   * @param refreshToken {@link String}
   */
  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  /**
   * Gets this access token.
   * 
   * @return {@link String}
   */
  public String getAccessToken() {
    return accessToken;
  }

  /**
   * Sets this access token.
   * 
   * @param accessToken {@link String}
   */
  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }
}