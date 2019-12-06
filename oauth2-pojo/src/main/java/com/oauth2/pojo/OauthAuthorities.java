package com.oauth2.pojo;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhicheng.zhang
 * @date 2019-11-29
 * @description
 */
@Entity
@Table(name = "oauth2_authorities")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class OauthAuthorities implements Serializable {
    private static final long serialVersionUID = 42L;

    @Id
    @Column(name = "authority_id", length = 20, nullable = false, updatable = false)
    private String authorityId;

    @Column(name = "authority_name", length = 20, nullable = false)
    private String authorityName;

    public static Set<OauthAuthorities> build() {
        OauthAuthorities oauthAuthorities = new OauthAuthorities("auth_root", "ROOT");
        OauthAuthorities oauthAuthorities1 = new OauthAuthorities("auth_user", "NORMAL");
        Set<OauthAuthorities> authorities = new HashSet<>();
        authorities.add(oauthAuthorities);
        authorities.add(oauthAuthorities1);
        return authorities;
    }
}
