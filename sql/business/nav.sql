
CREATE TABLE `business_nav_config` (
                                       `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
                                       `nav_name` varchar(30) COLLATE utf8mb4_general_ci NOT NULL COMMENT '导航名称',
                                       `nav_icon` varchar(30) COLLATE utf8mb4_general_ci NOT NULL COMMENT '导航图标',
                                       `nav_url` varchar(30) COLLATE utf8mb4_general_ci NOT NULL COMMENT '导航地址',
                                       `sort` char(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '导航排序',
                                       `status` char(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '状态（0正常 1停用）',
                                       `del_flag` char(1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                                       `create_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
                                       `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                       `update_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
                                       `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                       `remark` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='导航配置表';



-- 菜单 SQL
INSERT INTO `semanteme-admin`.`sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2000, '业务管理', 0, 4, '#', 'menuItem', 'M', '0', '1', NULL, 'fa fa-cog', 'admin', '2024-10-26 15:32:19', '', NULL, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('导航配置', '2000', '1', '/business/nav', 'C', '0', 'system:config:view', '#', 'admin', sysdate(), '', null, '导航配置菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('导航配置查询', @parentId, '1',  '#',  'F', '0', 'system:config:list',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('导航配置新增', @parentId, '2',  '#',  'F', '0', 'system:config:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('导航配置修改', @parentId, '3',  '#',  'F', '0', 'system:config:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('导航配置删除', @parentId, '4',  '#',  'F', '0', 'system:config:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('导航配置导出', @parentId, '5',  '#',  'F', '0', 'system:config:export',       '#', 'admin', sysdate(), '', null, '');