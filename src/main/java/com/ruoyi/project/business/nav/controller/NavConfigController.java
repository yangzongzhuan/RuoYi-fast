package com.ruoyi.project.business.nav.controller;

import java.util.List;

import com.ruoyi.framework.aspectj.lang.annotation.Anonymous;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.business.nav.domain.NavConfig;
import com.ruoyi.project.business.nav.service.INavConfigService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 导航配置Controller
 * 
 * @author ruoyi
 * @date 2024-10-26
 */
@Api("导航主页管理1")
@ApiOperation("导航主页管理2")
@Controller
@RequestMapping("/business/nav")
public class NavConfigController extends BaseController
{
    private String prefix = "business/nav";

    @Autowired
    private INavConfigService navConfigService;

    @RequiresPermissions("system:config:view")
    @GetMapping()
    public String config()
    {
        return prefix + "/config";
    }

    /**
     * 查询导航配置列表
     */
    @ApiOperation("查询导航配置列表")
    @Anonymous
    @RequestMapping("/list")
    @ResponseBody
    public TableDataInfo list(NavConfig navConfig)
    {
        startPage();
        List<NavConfig> list = navConfigService.selectNavConfigList(navConfig);
        return getDataTable(list);
    }

    /**
     * 导出导航配置列表
     */
    @RequiresPermissions("system:config:export")
    @Log(title = "导航配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NavConfig navConfig)
    {
        List<NavConfig> list = navConfigService.selectNavConfigList(navConfig);
        ExcelUtil<NavConfig> util = new ExcelUtil<NavConfig>(NavConfig.class);
        return util.exportExcel(list, "导航配置数据");
    }

    /**
     * 新增导航配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存导航配置
     */
    @RequiresPermissions("system:config:add")
    @Log(title = "导航配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NavConfig navConfig)
    {
        return toAjax(navConfigService.insertNavConfig(navConfig));
    }

    /**
     * 修改导航配置
     */
    @RequiresPermissions("system:config:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        NavConfig navConfig = navConfigService.selectNavConfigById(id);
        mmap.put("navConfig", navConfig);
        return prefix + "/edit";
    }

    /**
     * 修改保存导航配置
     */
    @RequiresPermissions("system:config:edit")
    @Log(title = "导航配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NavConfig navConfig)
    {
        return toAjax(navConfigService.updateNavConfig(navConfig));
    }

    /**
     * 删除导航配置
     */
    @RequiresPermissions("system:config:remove")
    @Log(title = "导航配置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(navConfigService.deleteNavConfigByIds(ids));
    }
}
