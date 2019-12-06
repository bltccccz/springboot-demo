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
@Table(name = "oauth2_user")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OauthUser implements Serializable {
    private static final long serialVersionUID = 42L;

    @Id
    @Column(name = "user_id", length = 45, updatable = false, nullable = false)
    @GenericGenerator(name = "user_id", strategy = "uuid")
    @GeneratedValue(generator = "user_id")
    private String userId;

    @Column(name = "user_name", length = 45, updatable = false, nullable = false)
    private String username;

    @Column(name = "user_pass", length = 60, nullable = false)
    private String password;

    @Column(name = "user_authorities_id", length = 20, nullable = false)
    private String authoritiesId;

    @Column(name = "user_role_id", length = 20, nullable = false)
    private String roleId;

    @Column(name = "user_create", nullable = false, updatable = false)
    private final long createTime = System.currentTimeMillis();

    @Column(name = "user_update", nullable = false)
    private long updateTime = System.currentTimeMillis();

    public OauthUser(String username, String password, String authorities, String roles) {
        this.username = username;
        this.password = password;
        this.authoritiesId = authorities;
        this.roleId = roles;
    }

    public void passwordEncode() {
        this.password = SecretTools.encodeSecret(password);
    }

    public static Set<OauthUser> build() {
        OauthUser user = new OauthUser("root", "root", "auth_root", "role_admin");
        OauthUser user1 = new OauthUser("user", "user", "auth_user", "role_user");
        OauthUser user2 = new OauthUser("admin", "admin", "auth_root,auth_user", "role_user,role_admin");

        user.passwordEncode();
        user1.passwordEncode();
        user2.passwordEncode();

        Set<OauthUser> set = new HashSet<>();

        set.add(user);
        set.add(user1);
        set.add(user2);

        return set;
    }
}
