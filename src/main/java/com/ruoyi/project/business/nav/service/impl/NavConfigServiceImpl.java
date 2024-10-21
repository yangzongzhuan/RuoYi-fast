package com.ruoyi.project.business.nav.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.nav.mapper.NavConfigMapper;
import com.ruoyi.project.business.nav.domain.NavConfig;
import com.ruoyi.project.business.nav.service.INavConfigService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 导航配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-26
 */
@Service
public class NavConfigServiceImpl implements INavConfigService 
{
    @Autowired
    private NavConfigMapper navConfigMapper;

    /**
     * 查询导航配置
     * 
     * @param id 导航配置主键
     * @return 导航配置
     */
    @Override
    public NavConfig selectNavConfigById(Long id)
    {
        return navConfigMapper.selectNavConfigById(id);
    }

    /**
     * 查询导航配置列表
     * 
     * @param navConfig 导航配置
     * @return 导航配置
     */
    @Override
    public List<NavConfig> selectNavConfigList(NavConfig navConfig)
    {
        return navConfigMapper.selectNavConfigList(navConfig);
    }

    /**
     * 新增导航配置
     * 
     * @param navConfig 导航配置
     * @return 结果
     */
    @Override
    public int insertNavConfig(NavConfig navConfig)
    {
        navConfig.setCreateTime(DateUtils.getNowDate());
        return navConfigMapper.insertNavConfig(navConfig);
    }

    /**
     * 修改导航配置
     * 
     * @param navConfig 导航配置
     * @return 结果
     */
    @Override
    public int updateNavConfig(NavConfig navConfig)
    {
        navConfig.setUpdateTime(DateUtils.getNowDate());
        return navConfigMapper.updateNavConfig(navConfig);
    }

    /**
     * 批量删除导航配置
     * 
     * @param ids 需要删除的导航配置主键
     * @return 结果
     */
    @Override
    public int deleteNavConfigByIds(String ids)
    {
        return navConfigMapper.deleteNavConfigByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除导航配置信息
     * 
     * @param id 导航配置主键
     * @return 结果
     */
    @Override
    public int deleteNavConfigById(Long id)
    {
        return navConfigMapper.deleteNavConfigById(id);
    }
}
