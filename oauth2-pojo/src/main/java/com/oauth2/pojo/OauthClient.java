package com.oauth2.pojo;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhicheng.zhang
 * @date 2019-11-29
 * @description
 */
@Entity
@Table(name = "oauth2_client")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class OauthClient implements Serializable {
    private static final long serialVersionUID = 42L;

    @Id
    @Column(name = "client_id", length = 45, updatable = false, nullable = false)
    @GenericGenerator(name = "client_id", strategy = "uuid")
    @GeneratedValue(generator = "client_id")
    private String clientId;

    @Column(name = "client_secret", length = 60, nullable = false, updatable = false)
    private String clientSecret = SecretTools.secretenerate();

    @Column(name = "client_resource", length = 60, nullable = false)
    private String resourceId;

    @Column(name = "client_scope", length = 60)
    private String scope;

    @Column(name = "client_authorities", length = 60)
    private String authorities;

    @Column(name = "client_grant_type", length = 60, nullable = false, updatable = false)
    private final String grantType = "authorization_code,refresh_token,client_credentials,password";

    @Column(name = "client_access_expire", nullable = false, updatable = false)
    private final int accessExpire = 600;

    @Column(name = "client_refresh_expire", nullable = false, updatable = false)
    private final int refreshExpire = 3600 * 24 * 30;

    @Column(name = "client_create", nullable = false, updatable = false)
    private final long createTime = System.currentTimeMillis();

    @Column(name = "client_update", updatable = false)
    private long updateTime = System.currentTimeMillis();

    public OauthClient(String resourceId, String scope, String authorities) {
        this.resourceId = resourceId;
        this.scope = scope;
        this.authorities = authorities;
    }

    public void setSecretEncode() {
        this.clientSecret = SecretTools.encodeSecret(clientSecret);
    }

    public void setUpdateTime() {
        this.updateTime = System.currentTimeMillis();
    }

    public static Set<OauthClient> build() {
        OauthClient oauth_test = new OauthClient("oauth_test", "client_scope", "client_auth");
        OauthClient oauth_test1 = new OauthClient("oauth_test1", "client_scope", "client_auth");
        oauth_test.setClientSecret("root");
        oauth_test1.setClientSecret("root1");

        oauth_test.setSecretEncode();
        oauth_test1.setSecretEncode();

        Set<OauthClient> oauthClients = new HashSet<>();
        oauthClients.add(oauth_test);
        oauthClients.add(oauth_test1);

        return oauthClients;
    }
}
