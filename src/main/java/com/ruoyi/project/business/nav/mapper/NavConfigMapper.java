package com.ruoyi.project.business.nav.mapper;

import java.util.List;
import com.ruoyi.project.business.nav.domain.NavConfig;

/**
 * 导航配置Mapper接口
 * 
 * @author ruoyi
 * @date 2024-10-26
 */
public interface NavConfigMapper 
{
    /**
     * 查询导航配置
     * 
     * @param id 导航配置主键
     * @return 导航配置
     */
    public NavConfig selectNavConfigById(Long id);

    /**
     * 查询导航配置列表
     * 
     * @param navConfig 导航配置
     * @return 导航配置集合
     */
    public List<NavConfig> selectNavConfigList(NavConfig navConfig);

    /**
     * 新增导航配置
     * 
     * @param navConfig 导航配置
     * @return 结果
     */
    public int insertNavConfig(NavConfig navConfig);

    /**
     * 修改导航配置
     * 
     * @param navConfig 导航配置
     * @return 结果
     */
    public int updateNavConfig(NavConfig navConfig);

    /**
     * 删除导航配置
     * 
     * @param id 导航配置主键
     * @return 结果
     */
    public int deleteNavConfigById(Long id);

    /**
     * 批量删除导航配置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNavConfigByIds(String[] ids);
}
