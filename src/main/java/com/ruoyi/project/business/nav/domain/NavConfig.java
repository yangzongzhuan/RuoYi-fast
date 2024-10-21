package com.ruoyi.project.business.nav.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 导航配置对象 business_nav_config
 * 
 * @author ruoyi
 * @date 2024-10-26
 */
public class NavConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 导航名称 */
    @Excel(name = "导航名称")
    private String navName;

    /** 导航图标 */
    @Excel(name = "导航图标")
    private String navIcon;

    /** 导航地址 */
    @Excel(name = "导航地址")
    private String navUrl;

    /** 导航排序 */
    @Excel(name = "导航排序")
    private String sort;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setNavName(String navName) 
    {
        this.navName = navName;
    }

    public String getNavName() 
    {
        return navName;
    }

    public void setNavIcon(String navIcon) 
    {
        this.navIcon = navIcon;
    }

    public String getNavIcon() 
    {
        return navIcon;
    }

    public void setSort(String sort) 
    {
        this.sort = sort;
    }

    public String getSort() 
    {
        return sort;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    public String getNavUrl() {
        return navUrl;
    }

    public void setNavUrl(String navUrl) {
        this.navUrl = navUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("navName", getNavName())
            .append("navIcon", getNavIcon())
            .append("sort", getSort())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
