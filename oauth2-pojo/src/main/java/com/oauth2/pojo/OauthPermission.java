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
@Table(name = "oauth2_permission")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class OauthPermission implements Serializable {

    private static final long serialVersionUID = 42L;

    @Id
    @Column(name = "permission_id", length = 20, nullable = false, updatable = false)
    private String permissionId;

    @Column(name = "permission_name", length = 20, nullable = false)
    private String permissionName;

    public static Set<OauthPermission> build() {
        OauthPermission read = new OauthPermission("permission_r", "READ");
        OauthPermission write = new OauthPermission("permission_w", "WRITE");
        OauthPermission update = new OauthPermission("permission_u", "UPDATE");
        OauthPermission delete = new OauthPermission("permission_d", "DELETE");

        Set<OauthPermission> permissions = new HashSet<>();

        permissions.add(read);
        permissions.add(write);
        permissions.add(update);
        permissions.add(delete);

        return permissions;
    }
}
