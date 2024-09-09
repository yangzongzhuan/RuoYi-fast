package com.ruoyi.framework.shiro.rememberMe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.framework.shiro.service.LoginService;
import com.ruoyi.project.system.role.domain.Role;
import com.ruoyi.project.system.user.domain.User;

/**
 * 自定义CookieRememberMeManager
 *
 * @author ruoyi
 */
public class CustomCookieRememberMeManager extends CookieRememberMeManager
{
    /**
     * 记住我时去掉角色的permissions权限字符串，防止http请求头过大。
     */
    @Override
    protected void rememberIdentity(Subject subject, PrincipalCollection principalCollection)
    {
        Map<Role, Set<String>> rolePermissions = new HashMap<>();
        // 清除角色的permissions权限字符串
        for (Object principal : principalCollection)
        {
            if (principal instanceof User)
            {
                List<Role> roles = ((User) principal).getRoles();
                for (Role role : roles)
                {
                    rolePermissions.put(role, role.getPermissions());
                    role.setPermissions(null);
                }
            }
        }
        byte[] bytes = convertPrincipalsToBytes(principalCollection);
        // 恢复角色的permissions权限字符串
        for (Object principal : principalCollection)
        {
            if (principal instanceof User)
            {
                List<Role> roles = ((User) principal).getRoles();
                for (Role role : roles)
                {
                    role.setPermissions(rolePermissions.get(role));
                }
            }
        }
        rememberSerializedIdentity(subject, bytes);
    }

    /**
     * 取记住我身份时恢复角色permissions权限字符串。
     */
    @Override
    public PrincipalCollection getRememberedPrincipals(SubjectContext subjectContext)
    {
        PrincipalCollection principals = super.getRememberedPrincipals(subjectContext);
        if (principals == null || principals.isEmpty())
        {
            return principals;
        }
        for (Object principal : principals)
        {
            if (principal instanceof User)
            {
                SpringUtils.getBean(LoginService.class).setRolePermission((User) principal);
            }
        }
        return principals;
    }
}
