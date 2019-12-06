package com.oauth2.resource.config;

import com.oauth2.resource.dao.AuthorityDao;
import com.oauth2.resource.dao.PermissionDao;
import com.oauth2.resource.dao.RoleAndPermission;
import com.oauth2.resource.dao.RoleDao;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhicheng.zhang
 * @date 2019/12/4
 * @description
 */
public class PermissionEvaluatorCus implements PermissionEvaluator {

    private final static String ROLE_PREFIX = "ROLE_";

    @Resource(name = "permissionDao", type = PermissionDao.class)
    PermissionDao permissionDao;

    @Resource(name = "roleDao", type = RoleDao.class)
    RoleDao roleDao;

    @Resource(name = "roleAndPer", type = RoleAndPermission.class)
    RoleAndPermission roleAndPermissionDao;

    @Resource(name = "authorityDao", type = AuthorityDao.class)
    AuthorityDao authorityDao;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        boolean access = false;

        Set<String> hasPermissionIds = new HashSet<>();

        Set<String> authorityIdSet = new HashSet<>();

        Set<String> s = StringUtils.commaDelimitedListToSet(permission.toString());

        s.forEach(item -> {
            hasPermissionIds.add(permissionDao.getIdByName(item));
        });

        for (GrantedAuthority authority : authentication.getAuthorities()) {
            String authorityName = authority.getAuthority();

            boolean isRole = authorityName.startsWith(ROLE_PREFIX);

            String authorityId = isRole ? roleDao.getRoleIdByName(authorityName) :
                    authorityDao.getAuthorityIdByName(authorityName);

            authorityIdSet.add(authorityId);

        }

        Set<String> requirePermissionIds = roleAndPermissionDao.getPermissionIdsByAuthIds(authorityIdSet);

        if (hasPermissionIds.containsAll(requirePermissionIds)) {
            access = true;
        }
        return access;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
