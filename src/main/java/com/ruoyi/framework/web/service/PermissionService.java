package com.ruoyi.framework.web.service;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * RuoYi首创 js调用 thymeleaf 实现按钮权限可见性
 * 
 * @author ruoyi
 */
@Service("permission")
public class PermissionService
{
    private static final Logger log = LoggerFactory.getLogger(PermissionService.class);

    public String hasPermi(String permission)
    {
        return isPermittedOperator(permission) ? "" : "hidden";
    }

    public String hasRole(String role)
    {
        return hasRoleOperator(role) ? "" : "hidden";
    }

    /**
     * 判断用户是否拥有某个权限
     * 
     * @param permission 权限字符串
     * @return 结果
     */
    private boolean isPermittedOperator(String permission)
    {
        return SecurityUtils.getSubject().isPermitted(permission);
    }

    /**
     * 判断用户是否拥有某个角色
     * 
     * @param role 角色字符串
     * @return 结果
     */
    private boolean hasRoleOperator(String role)
    {
        return SecurityUtils.getSubject().hasRole(role);
    }

    /**
     * 返回用户属性值
     *
     * @param property 属性名称
     * @return 用户属性值
     */
    public Object getPrincipalProperty(String property)
    {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null)
        {
            Object principal = subject.getPrincipal();
            try
            {
                BeanInfo bi = Introspector.getBeanInfo(principal.getClass());
                for (PropertyDescriptor pd : bi.getPropertyDescriptors())
                {
                    if (pd.getName().equals(property) == true)
                    {
                        return pd.getReadMethod().invoke(principal, (Object[]) null);
                    }
                }
            }
            catch (Exception e)
            {
                log.error("Error reading property [{}] from principal of type [{}]", property,
                        principal.getClass().getName());
            }
        }
        return null;
    }
}
