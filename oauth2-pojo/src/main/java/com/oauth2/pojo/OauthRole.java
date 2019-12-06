package com.oauth2.pojo;

import lombok.*;
import org.springframework.util.Assert;

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
@Table(name = "oauth2_role")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class OauthRole implements Serializable {
    private static final long serialVersionUID = 42L;

    @Id
    @Column(name = "role_id", length = 20, updatable = false, nullable = false)
    private String roleId;

    @Column(name = "role_name", length = 20, nullable = false)
    private String roleName;

    public OauthRole(String roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName.startsWith("ROLE_") ? roleName : "ROLE_" + roleName;
    }

    public static Set<OauthRole> build() {
        OauthRole user = new OauthRole("role_user", "USER");
        OauthRole admin = new OauthRole("role_admin", "ADMIN");

        Set<OauthRole> roles = new HashSet<>();

        roles.add(user);
        roles.add(admin);

        return roles;
    }
}
