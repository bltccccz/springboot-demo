package com.oauth2.pojo;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhicheng.zhang
 * @date 2019/12/4
 * @description
 */
@Entity
@Table(name = "oauth2_role_permission")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class OauthRoleAndPermission implements Serializable {
    private static final long serialVersionUID = 42L;

    @Id
    @Column(name = "id", length = 45, nullable = false, updatable = false)
    @GenericGenerator(name = "id", strategy = "uuid")
    @GeneratedValue(generator = "id")
    public String id;

    @NonNull
    @Column(name = "permission_id", length = 20, nullable = false, updatable = false)
    public String permissionId;

    @NonNull
    @Column(name = "role_id", length = 80, updatable = false, nullable = false)
    public String roleId;

    public static Set<OauthRoleAndPermission> build() {
        OauthRoleAndPermission oauthRoleAndPermission = new OauthRoleAndPermission("permission_r", "auth_user");
        OauthRoleAndPermission oauthRoleAndPermission1 = new OauthRoleAndPermission("permission_r", "auth_root");
        OauthRoleAndPermission oauthRoleAndPermission2 = new OauthRoleAndPermission("permission_r", "user_role");
        OauthRoleAndPermission oauthRoleAndPermission3 = new OauthRoleAndPermission("permission_r", "user_admin");

        OauthRoleAndPermission oauthRoleAndPermission4 = new OauthRoleAndPermission("permission_w", "user_admin");
        OauthRoleAndPermission oauthRoleAndPermission5 = new OauthRoleAndPermission("permission_w", "oauth_root");

        OauthRoleAndPermission oauthRoleAndPermission6 = new OauthRoleAndPermission("permission_u", "user_admin");
        OauthRoleAndPermission oauthRoleAndPermission7 = new OauthRoleAndPermission("permission_u", "oauth_root");

        OauthRoleAndPermission oauthRoleAndPermission8 = new OauthRoleAndPermission("permission_d", "user_admin");
        OauthRoleAndPermission oauthRoleAndPermission9 = new OauthRoleAndPermission("permission_d", "oauth_root");

        Set<OauthRoleAndPermission> set = new HashSet<>();

        set.add(oauthRoleAndPermission);
        set.add(oauthRoleAndPermission1);
        set.add(oauthRoleAndPermission2);
        set.add(oauthRoleAndPermission3);
        set.add(oauthRoleAndPermission4);
        set.add(oauthRoleAndPermission5);
        set.add(oauthRoleAndPermission6);
        set.add(oauthRoleAndPermission7);
        set.add(oauthRoleAndPermission8);
        set.add(oauthRoleAndPermission9);

        return set;
    }
}
