-- ============================================
-- ERP系统数据库表结构
-- 版本: 1.0
-- 基于RuoYi框架扩展
-- ============================================

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- 1. 基础资料模块
-- ----------------------------

-- ----------------------------
-- 物料主数据表
-- ----------------------------
DROP TABLE IF EXISTS `erp_material`;
CREATE TABLE `erp_material` (
  `material_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '物料ID',
  `material_code` varchar(50) NOT NULL COMMENT '物料编码',
  `material_name` varchar(200) NOT NULL COMMENT '物料名称',
  `material_type` varchar(20) DEFAULT NULL COMMENT '物料类型: raw-原材料, semi-半成品, finish-成品, pack-包装物, tool-工具, waste-废料',
  `specification` varchar(500) DEFAULT NULL COMMENT '规格型号',
  `unit` varchar(20) DEFAULT NULL COMMENT '计量单位',
  `category_id` bigint(20) DEFAULT NULL COMMENT '物料分类ID',
  `purchase_price` decimal(12,2) DEFAULT NULL COMMENT '采购单价',
  `sale_price` decimal(12,2) DEFAULT NULL COMMENT '销售单价',
  `cost_price` decimal(12,2) DEFAULT NULL COMMENT '成本单价',
  `safe_stock` decimal(12,2) DEFAULT 0 COMMENT '安全库存',
  `min_stock` decimal(12,2) DEFAULT 0 COMMENT '最小库存',
  `max_stock` decimal(12,2) DEFAULT 0 COMMENT '最大库存',
  `lead_time` int(11) DEFAULT 0 COMMENT '采购提前期(天)',
  `batch_management` tinyint(1) DEFAULT 0 COMMENT '是否批次管理: 0-否, 1-是',
  `shelf_life` int(11) DEFAULT 0 COMMENT '保质期(天)',
  `weight` decimal(10,2) DEFAULT NULL COMMENT '重量',
  `volume` decimal(10,2) DEFAULT NULL COMMENT '体积',
  `status` char(1) DEFAULT '0' COMMENT '状态: 0-正常, 1-停用',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_dept` bigint(20) DEFAULT NULL COMMENT '创建部门',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志: 0-存在, 2-删除',
  PRIMARY KEY (`material_id`),
  UNIQUE KEY `uk_material_code` (`material_code`),
  KEY `idx_material_type` (`material_type`),
  KEY `idx_category_id` (`category_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='物料主数据表';

-- ----------------------------
-- 物料分类表
-- ----------------------------
DROP TABLE IF EXISTS `erp_material_category`;
CREATE TABLE `erp_material_category` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `parent_id` bigint(20) DEFAULT 0 COMMENT '父分类ID',
  `category_code` varchar(50) DEFAULT NULL COMMENT '分类编码',
  `category_name` varchar(100) NOT NULL COMMENT '分类名称',
  `order_num` int(11) DEFAULT 0 COMMENT '显示顺序',
  `status` char(1) DEFAULT '0' COMMENT '状态: 0-正常, 1-停用',
  `ancestors` varchar(500) DEFAULT '' COMMENT '祖籍列表',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`category_id`),
  KEY `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='物料分类表';

-- ----------------------------
-- 供应商表
-- ----------------------------
DROP TABLE IF EXISTS `erp_supplier`;
CREATE TABLE `erp_supplier` (
  `supplier_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '供应商ID',
  `supplier_code` varchar(50) NOT NULL COMMENT '供应商编码',
  `supplier_name` varchar(200) NOT NULL COMMENT '供应商名称',
  `supplier_type` varchar(20) DEFAULT NULL COMMENT '供应商类型',
  `contact` varchar(50) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `fax` varchar(20) DEFAULT NULL COMMENT '传真',
  `address` varchar(500) DEFAULT NULL COMMENT '地址',
  `tax_no` varchar(50) DEFAULT NULL COMMENT '税务登记号',
  `bank` varchar(100) DEFAULT NULL COMMENT '开户银行',
  `bank_account` varchar(50) DEFAULT NULL COMMENT '银行账号',
  `credit_level` varchar(20) DEFAULT NULL COMMENT '信用等级',
  `status` char(1) DEFAULT '0' COMMENT '状态: 0-正常, 1-停用',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_dept` bigint(20) DEFAULT NULL COMMENT '创建部门',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志: 0-存在, 2-删除',
  PRIMARY KEY (`supplier_id`),
  UNIQUE KEY `uk_supplier_code` (`supplier_code`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='供应商表';

-- ----------------------------
-- 客户表
-- ----------------------------
DROP TABLE IF EXISTS `erp_customer`;
CREATE TABLE `erp_customer` (
  `customer_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '客户ID',
  `customer_code` varchar(50) NOT NULL COMMENT '客户编码',
  `customer_name` varchar(200) NOT NULL COMMENT '客户名称',
  `customer_type` varchar(20) DEFAULT NULL COMMENT '客户类型: individual-个人, company-企业',
  `contact` varchar(50) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `fax` varchar(20) DEFAULT NULL COMMENT '传真',
  `address` varchar(500) DEFAULT NULL COMMENT '地址',
  `tax_no` varchar(50) DEFAULT NULL COMMENT '税务登记号',
  `bank` varchar(100) DEFAULT NULL COMMENT '开户银行',
  `bank_account` varchar(50) DEFAULT NULL COMMENT '银行账号',
  `credit_level` varchar(20) DEFAULT NULL COMMENT '信用等级',
  `credit_limit` decimal(12,2) DEFAULT 0 COMMENT '信用额度',
  `status` char(1) DEFAULT '0' COMMENT '状态: 0-正常, 1-停用',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_dept` bigint(20) DEFAULT NULL COMMENT '创建部门',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志: 0-存在, 2-删除',
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `uk_customer_code` (`customer_code`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='客户表';

-- ----------------------------
-- 仓库表
-- ----------------------------
DROP TABLE IF EXISTS `erp_warehouse`;
CREATE TABLE `erp_warehouse` (
  `warehouse_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '仓库ID',
  `warehouse_code` varchar(50) NOT NULL COMMENT '仓库编码',
  `warehouse_name` varchar(100) NOT NULL COMMENT '仓库名称',
  `warehouse_type` varchar(20) DEFAULT NULL COMMENT '仓库类型: main-主仓, sub-分仓, virtual-虚拟仓, quality-质检仓',
  `address` varchar(500) DEFAULT NULL COMMENT '仓库地址',
  `manager` varchar(50) DEFAULT NULL COMMENT '仓库管理员',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `is_default` tinyint(1) DEFAULT 0 COMMENT '是否默认: 0-否, 1-是',
  `status` char(1) DEFAULT '0' COMMENT '状态: 0-正常, 1-停用',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`warehouse_id`),
  UNIQUE KEY `uk_warehouse_code` (`warehouse_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='仓库表';

-- ----------------------------
-- 库位表
-- ----------------------------
DROP TABLE IF EXISTS `erp_storage_location`;
CREATE TABLE `erp_storage_location` (
  `location_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '库位ID',
  `warehouse_id` bigint(20) NOT NULL COMMENT '仓库ID',
  `location_code` varchar(50) NOT NULL COMMENT '库位编码',
  `location_name` varchar(100) NOT NULL COMMENT '库位名称',
  `location_type` varchar(20) DEFAULT NULL COMMENT '库位类型: rack-货架, floor-地面, temp-临时',
  `status` char(1) DEFAULT '0' COMMENT '状态: 0-正常, 1-停用',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`location_id`),
  UNIQUE KEY `uk_location_code` (`location_code`),
  KEY `idx_warehouse_id` (`warehouse_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='库位表';

-- ----------------------------
-- 计量单位表
-- ----------------------------
DROP TABLE IF EXISTS `erp_unit`;
CREATE TABLE `erp_unit` (
  `unit_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '单位ID',
  `unit_code` varchar(20) NOT NULL COMMENT '单位编码',
  `unit_name` varchar(50) NOT NULL COMMENT '单位名称',
  `unit_type` varchar(10) DEFAULT NULL COMMENT '单位类型: basic-基本单位, convert-转换单位',
  `ratio` decimal(10,4) DEFAULT 1 COMMENT '与基本单位转换比率',
  `status` char(1) DEFAULT '0' COMMENT '状态: 0-正常, 1-停用',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`unit_id`),
  UNIQUE KEY `uk_unit_code` (`unit_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='计量单位表';

-- ----------------------------
-- 2. 生产计划模块
-- ----------------------------

-- ----------------------------
-- BOM主表
-- ----------------------------
DROP TABLE IF EXISTS `erp_bom`;
CREATE TABLE `erp_bom` (
  `bom_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'BOM ID',
  `bom_code` varchar(50) NOT NULL COMMENT 'BOM编码',
  `bom_name` varchar(200) NOT NULL COMMENT 'BOM名称',
  `material_id` bigint(20) NOT NULL COMMENT '产品物料ID',
  `version` varchar(20) DEFAULT 'V1.0' COMMENT 'BOM版本',
  `status` varchar(20) DEFAULT 'draft' COMMENT '状态: draft-草稿, active-生效, archived-归档',
  `effective_date` date DEFAULT NULL COMMENT '生效日期',
  `obsolete_date` date DEFAULT NULL COMMENT '失效日期',
  `quantity` decimal(12,4) DEFAULT 1 COMMENT '基本用量',
  `loss_rate` decimal(6,4) DEFAULT 0 COMMENT '损耗率',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`bom_id`),
  UNIQUE KEY `uk_bom_material_version` (`material_id`, `version`),
  KEY `idx_material_id` (`material_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='BOM主表';

-- ----------------------------
-- BOM明细表
-- ----------------------------
DROP TABLE IF EXISTS `erp_bom_item`;
CREATE TABLE `erp_bom_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'BOM明细ID',
  `bom_id` bigint(20) NOT NULL COMMENT 'BOM ID',
  `material_id` bigint(20) NOT NULL COMMENT '物料ID',
  `parent_item_id` bigint(20) DEFAULT NULL COMMENT '父级明细ID',
  `level` int(11) DEFAULT 1 COMMENT '层级',
  `line_no` int(11) DEFAULT 1 COMMENT '行号',
  `quantity` decimal(12,4) NOT NULL COMMENT '用量',
  `loss_rate` decimal(6,4) DEFAULT 0 COMMENT '损耗率',
  `actual_quantity` decimal(12,4) DEFAULT NULL COMMENT '实际用量(含损耗)',
  `warehouse_id` bigint(20) DEFAULT NULL COMMENT '默认仓库ID',
  `station_no` varchar(50) DEFAULT NULL COMMENT '工位编号',
  `is_optional` tinyint(1) DEFAULT 0 COMMENT '是否可选: 0-必选, 1-可选',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`item_id`),
  KEY `idx_bom_id` (`bom_id`),
  KEY `idx_material_id` (`material_id`),
  KEY `idx_parent_item_id` (`parent_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='BOM明细表';

-- ----------------------------
-- BOM版本表
-- ----------------------------
DROP TABLE IF EXISTS `erp_bom_version`;
CREATE TABLE `erp_bom_version` (
  `version_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '版本ID',
  `bom_id` bigint(20) NOT NULL COMMENT 'BOM ID',
  `version` varchar(20) NOT NULL COMMENT '版本号',
  `change_desc` varchar(500) DEFAULT NULL COMMENT '变更说明',
  `is_current` tinyint(1) DEFAULT 0 COMMENT '是否当前版本: 0-否, 1-是',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`version_id`),
  KEY `idx_bom_id` (`bom_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='BOM版本表';

-- ----------------------------
-- 工作中心表
-- ----------------------------
DROP TABLE IF EXISTS `erp_work_center`;
CREATE TABLE `erp_work_center` (
  `center_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '工作中心ID',
  `center_code` varchar(50) NOT NULL COMMENT '工作中心编码',
  `center_name` varchar(100) NOT NULL COMMENT '工作中心名称',
  `center_type` varchar(20) DEFAULT NULL COMMENT '类型: produce-生产, quality-质检, store-仓库',
  `department_id` bigint(20) DEFAULT NULL COMMENT '所属部门ID',
  `capacity_type` varchar(20) DEFAULT 'hours' COMMENT '产能类型: hours-工时, pieces-件数',
  `capacity_per_day` decimal(10,2) DEFAULT 8 COMMENT '日产能',
  `status` char(1) DEFAULT '0' COMMENT '状态: 0-正常, 1-停用',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`center_id`),
  UNIQUE KEY `uk_center_code` (`center_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='工作中心表';

-- ----------------------------
-- 工序定义表
-- ----------------------------
DROP TABLE IF EXISTS `erp_process`;
CREATE TABLE `erp_process` (
  `process_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '工序ID',
  `process_code` varchar(50) NOT NULL COMMENT '工序编码',
  `process_name` varchar(100) NOT NULL COMMENT '工序名称',
  `process_type` varchar(20) DEFAULT NULL COMMENT '工序类型',
  `work_center_id` bigint(20) DEFAULT NULL COMMENT '默认工作中心ID',
  `work_time` decimal(8,2) DEFAULT 0 COMMENT '标准工时(小时)',
  `work_time_unit` varchar(10) DEFAULT 'hours' COMMENT '工时单位: hours-小时, minutes-分钟',
  `setup_time` decimal(8,2) DEFAULT 0 COMMENT '准备时间(分钟)',
  `wait_time` decimal(8,2) DEFAULT 0 COMMENT '等待时间(分钟)',
  `transfer_time` decimal(8,2) DEFAULT 0 COMMENT '移送时间(分钟)',
  `is_qc_required` tinyint(1) DEFAULT 0 COMMENT '是否需要质检: 0-否, 1-是',
  `qc_rate` decimal(5,2) DEFAULT 100 COMMENT '合格率标准',
  `status` char(1) DEFAULT '0' COMMENT '状态: 0-正常, 1-停用',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`process_id`),
  UNIQUE KEY `uk_process_code` (`process_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='工序定义表';

-- ----------------------------
-- 工艺路线主表
-- ----------------------------
DROP TABLE IF EXISTS `erp_routing`;
CREATE TABLE `erp_routing` (
  `routing_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '工艺路线ID',
  `routing_code` varchar(50) NOT NULL COMMENT '工艺路线编码',
  `routing_name` varchar(200) NOT NULL COMMENT '工艺路线名称',
  `material_id` bigint(20) DEFAULT NULL COMMENT '适用物料ID',
  `material_category_id` bigint(20) DEFAULT NULL COMMENT '适用物料分类ID',
  `version` varchar(20) DEFAULT 'V1.0' COMMENT '版本',
  `status` varchar(20) DEFAULT 'draft' COMMENT '状态: draft-草稿, active-生效',
  `effective_date` date DEFAULT NULL COMMENT '生效日期',
  `is_default` tinyint(1) DEFAULT 0 COMMENT '是否默认: 0-否, 1-是',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`routing_id`),
  UNIQUE KEY `uk_routing_code` (`routing_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='工艺路线主表';

-- ----------------------------
-- 工艺路线工序明细表
-- ----------------------------
DROP TABLE IF EXISTS `erp_routing_item`;
CREATE TABLE `erp_routing_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '明细ID',
  `routing_id` bigint(20) NOT NULL COMMENT '工艺路线ID',
  `process_id` bigint(20) NOT NULL COMMENT '工序ID',
  `line_no` int(11) NOT NULL COMMENT '工序序号',
  `work_center_id` bigint(20) DEFAULT NULL COMMENT '工作中心ID',
  `work_time` decimal(8,2) DEFAULT NULL COMMENT '工时(小时)',
  `queue_time` decimal(8,2) DEFAULT 0 COMMENT '排队时间(分钟)',
  `transfer_time` decimal(8,2) DEFAULT 0 COMMENT '移送时间(分钟)',
  `is_prepare` tinyint(1) DEFAULT 0 COMMENT '是否准备工序',
  `is_key` tinyint(1) DEFAULT 0 COMMENT '是否关键工序',
  `is_qc_required` tinyint(1) DEFAULT 0 COMMENT '是否需要质检',
  `next_process_id` bigint(20) DEFAULT NULL COMMENT '下一工序ID',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`item_id`),
  KEY `idx_routing_id` (`routing_id`),
  KEY `idx_process_id` (`process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='工艺路线工序明细表';

-- ----------------------------
-- 主生产计划(MPS)表
-- ----------------------------
DROP TABLE IF EXISTS `erp_mps`;
CREATE TABLE `erp_mps` (
  `mps_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'MPS ID',
  `mps_code` varchar(50) NOT NULL COMMENT 'MPS编码',
  `plan_year` int(11) NOT NULL COMMENT '计划年份',
  `plan_month` int(11) NOT NULL COMMENT '计划月份',
  `plan_type` varchar(20) DEFAULT 'mps' COMMENT '计划类型: mps-主生产计划, forecast-预测计划',
  `status` varchar(20) DEFAULT 'draft' COMMENT '状态: draft-草稿, released-已下达, closed-已关闭',
  `total_quantity` decimal(12,2) DEFAULT 0 COMMENT '总数量',
  `closed_by` varchar(64) DEFAULT NULL COMMENT '关闭人',
  `closed_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`mps_id`),
  UNIQUE KEY `uk_mps_code` (`mps_code`),
  KEY `idx_plan_date` (`plan_year`, `plan_month`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='主生产计划(MPS)表';

-- ----------------------------
-- MPS明细表
-- ----------------------------
DROP TABLE IF EXISTS `erp_mps_item`;
CREATE TABLE `erp_mps_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '明细ID',
  `mps_id` bigint(20) NOT NULL COMMENT 'MPS ID',
  `material_id` bigint(20) NOT NULL COMMENT '物料ID',
  `warehouse_id` bigint(20) DEFAULT NULL COMMENT '仓库ID',
  `plan_quantity` decimal(12,4) NOT NULL COMMENT '计划数量',
  `finished_quantity` decimal(12,4) DEFAULT 0 COMMENT '已完成数量',
  `in_production_quantity` decimal(12,4) DEFAULT 0 COMMENT '在产数量',
  `delivery_date` date DEFAULT NULL COMMENT '预计交货日期',
  `priority` int(11) DEFAULT 1 COMMENT '优先级',
  `status` varchar(20) DEFAULT 'pending' COMMENT '状态: pending-待生产, released-已下达, completed-已完成',
  `source_type` varchar(20) DEFAULT NULL COMMENT '来源类型: order-销售订单, forecast-预测, manual-手动',
  `source_code` varchar(50) DEFAULT NULL COMMENT '来源单据号',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`item_id`),
  KEY `idx_mps_id` (`mps_id`),
  KEY `idx_material_id` (`material_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='MPS明细表';

-- ----------------------------
-- MRP运算记录表
-- ----------------------------
DROP TABLE IF EXISTS `erp_mrp`;
CREATE TABLE `erp_mrp` (
  `mrp_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'MRP ID',
  `mrp_code` varchar(50) NOT NULL COMMENT 'MRP编码',
  `plan_date` date NOT NULL COMMENT '计划日期',
  `status` varchar(20) DEFAULT 'calculated' COMMENT '状态: calculated-已运算, released-已下达, closed-已关闭',
  `total_purchase_qty` decimal(12,2) DEFAULT 0 COMMENT '采购建议总量',
  `total_production_qty` decimal(12,2) DEFAULT 0 COMMENT '生产建议总量',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`mrp_id`),
  UNIQUE KEY `uk_mrp_code` (`mrp_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='MRP运算记录表';

-- ----------------------------
-- MRP明细/需求表
-- ----------------------------
DROP TABLE IF EXISTS `erp_mrp_item`;
CREATE TABLE `erp_mrp_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '明细ID',
  `mrp_id` bigint(20) NOT NULL COMMENT 'MRP ID',
  `material_id` bigint(20) NOT NULL COMMENT '物料ID',
  `warehouse_id` bigint(20) DEFAULT NULL COMMENT '仓库ID',
  `gross_requirement` decimal(12,4) NOT NULL COMMENT '毛需求',
  `scheduled_receipt` decimal(12,4) DEFAULT 0 COMMENT '计划收货(在途)',
  `onhand_quantity` decimal(12,4) DEFAULT 0 COMMENT '现有量',
  `allocated_quantity` decimal(12,4) DEFAULT 0 COMMENT '已分配量',
  `net_requirement` decimal(12,4) DEFAULT 0 COMMENT '净需求',
  `safety_stock` decimal(12,4) DEFAULT 0 COMMENT '安全库存',
  `replenishment_qty` decimal(12,4) DEFAULT 0 COMMENT '补货数量',
  `available_quantity` decimal(12,4) DEFAULT 0 COMMENT '可供分配量',
  `requirement_date` date DEFAULT NULL COMMENT '需求日期',
  `supply_type` varchar(20) DEFAULT NULL COMMENT '供应类型: purchase-采购, production-生产, onhand-库存',
  `source_id` bigint(20) DEFAULT NULL COMMENT '来源ID(MPS/MPS_ITEM等)',
  `is_firmed` tinyint(1) DEFAULT 0 COMMENT '是否确认: 0-未确认, 1-已确认',
  `status` varchar(20) DEFAULT 'pending' COMMENT '状态: pending-待处理, released-已转单, closed-已关闭',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`item_id`),
  KEY `idx_mrp_id` (`mrp_id`),
  KEY `idx_material_id` (`material_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='MRP明细表';

-- ----------------------------
-- MRP建议表(采购/生产建议)
-- ----------------------------
DROP TABLE IF EXISTS `erp_mrp_suggestion`;
CREATE TABLE `erp_mrp_suggestion` (
  `suggestion_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '建议ID',
  `mrp_id` bigint(20) NOT NULL COMMENT 'MRP ID',
  `mrp_item_id` bigint(20) DEFAULT NULL COMMENT 'MRP明细ID',
  `suggestion_type` varchar(20) NOT NULL COMMENT '建议类型: purchase-采购建议, production-生产建议',
  `material_id` bigint(20) NOT NULL COMMENT '物料ID',
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '建议供应商ID(采购时)',
  `warehouse_id` bigint(20) DEFAULT NULL COMMENT '仓库ID',
  `quantity` decimal(12,4) NOT NULL COMMENT '建议数量',
  `required_date` date NOT NULL COMMENT '需求日期',
  `due_date` date NOT NULL COMMENT '建议完成日期',
  `supply_source` varchar(50) DEFAULT NULL COMMENT '供应来源',
  `is_firmed` tinyint(1) DEFAULT 0 COMMENT '是否确认',
  `is_generated` tinyint(1) DEFAULT 0 COMMENT '是否已生成订单: 0-未生成, 1-已生成',
  `generated_order_type` varchar(20) DEFAULT NULL COMMENT '生成订单类型',
  `generated_order_id` bigint(20) DEFAULT NULL COMMENT '生成订单ID',
  `status` varchar(20) DEFAULT 'pending' COMMENT '状态: pending-待确认, released-已转单, closed-已关闭',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`suggestion_id`),
  KEY `idx_mrp_id` (`mrp_id`),
  KEY `idx_material_id` (`material_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='MRP建议表';

-- ----------------------------
-- 生产订单主表
-- ----------------------------
DROP TABLE IF EXISTS `erp_production_order`;
CREATE TABLE `erp_production_order` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '生产订单ID',
  `order_no` varchar(50) NOT NULL COMMENT '生产订单号',
  `source_type` varchar(20) DEFAULT NULL COMMENT '来源类型: mps-MPS, manual-手动',
  `source_id` bigint(20) DEFAULT NULL COMMENT '来源ID',
  `source_no` varchar(50) DEFAULT NULL COMMENT '来源单据号',
  `material_id` bigint(20) NOT NULL COMMENT '产品物料ID',
  `material_name` varchar(200) DEFAULT NULL COMMENT '产品名称(冗余)',
  `specification` varchar(200) DEFAULT NULL COMMENT '规格(冗余)',
  `unit` varchar(20) DEFAULT NULL COMMENT '单位(冗余)',
  `warehouse_id` bigint(20) DEFAULT NULL COMMENT '入库仓库ID',
  `routing_id` bigint(20) DEFAULT NULL COMMENT '工艺路线ID',
  `bom_id` bigint(20) DEFAULT NULL COMMENT 'BOM ID',
  `order_quantity` decimal(12,4) NOT NULL COMMENT '订单数量',
  `finished_quantity` decimal(12,4) DEFAULT 0 COMMENT '已完成数量',
  `scrapped_quantity` decimal(12,4) DEFAULT 0 COMMENT '报废数量',
  `plan_start_date` date DEFAULT NULL COMMENT '计划开始日期',
  `plan_finish_date` date DEFAULT NULL COMMENT '计划完成日期',
  `actual_start_date` date DEFAULT NULL COMMENT '实际开始日期',
  `actual_finish_date` date DEFAULT NULL COMMENT '实际完成日期',
  `priority` int(11) DEFAULT 1 COMMENT '优先级',
  `status` varchar(20) DEFAULT 'draft' COMMENT '状态: draft-草稿, released-已下达, in_production-生产中, completed-已完成, closed-已关闭, cancelled-已取消',
  `bom_version` varchar(20) DEFAULT NULL COMMENT 'BOM版本(订单冻结)',
  `routing_version` varchar(20) DEFAULT NULL COMMENT '工艺版本(订单冻结)',
  `work_order_count` int(11) DEFAULT 0 COMMENT '工序单数量',
  `completed_work_order_count` int(11) DEFAULT 0 COMMENT '已完成工序单数量',
  `closed_by` varchar(64) DEFAULT NULL COMMENT '关闭人',
  `closed_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_reason` varchar(500) DEFAULT NULL COMMENT '关闭原因',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `uk_order_no` (`order_no`),
  KEY `idx_material_id` (`material_id`),
  KEY `idx_status` (`status`),
  KEY `idx_plan_date` (`plan_start_date`, `plan_finish_date`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='生产订单主表';

-- ----------------------------
-- 生产订单明细表
-- ----------------------------
DROP TABLE IF EXISTS `erp_production_order_item`;
CREATE TABLE `erp_production_order_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '明细ID',
  `order_id` bigint(20) NOT NULL COMMENT '生产订单ID',
  `material_id` bigint(20) NOT NULL COMMENT '物料ID',
  `material_name` varchar(200) DEFAULT NULL COMMENT '物料名称(冗余)',
  `warehouse_id` bigint(20) DEFAULT NULL COMMENT '仓库ID',
  `bom_quantity` decimal(12,4) NOT NULL COMMENT 'BOM用量',
  `order_quantity` decimal(12,4) NOT NULL COMMENT '订单用量(包含损耗)',
  `issued_quantity` decimal(12,4) DEFAULT 0 COMMENT '已发料数量',
  `returned_quantity` decimal(12,4) DEFAULT 0 COMMENT '已退料数量',
  `used_quantity` decimal(12,4) DEFAULT 0 COMMENT '已用量(实际)',
  `status` varchar(20) DEFAULT 'pending' COMMENT '状态: pending-待发料, issued-已发料, completed-已用料',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`item_id`),
  KEY `idx_order_id` (`order_id`),
  KEY `idx_material_id` (`material_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='生产订单物料明细表';

-- ----------------------------
-- 工序任务单/派工单表
-- ----------------------------
DROP TABLE IF EXISTS `erp_work_order`;
CREATE TABLE `erp_work_order` (
  `work_order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '工序任务单ID',
  `work_order_no` varchar(50) NOT NULL COMMENT '工序任务单号',
  `production_order_id` bigint(20) NOT NULL COMMENT '生产订单ID',
  `production_order_no` varchar(50) DEFAULT NULL COMMENT '生产订单号(冗余)',
  `process_id` bigint(20) NOT NULL COMMENT '工序ID',
  `process_name` varchar(100) DEFAULT NULL COMMENT '工序名称(冗余)',
  `line_no` int(11) DEFAULT NULL COMMENT '工序序号',
  `work_center_id` bigint(20) DEFAULT NULL COMMENT '工作中心ID',
  `material_id` bigint(20) DEFAULT NULL COMMENT '产品物料ID',
  `quantity` decimal(12,4) NOT NULL COMMENT '数量',
  `finished_quantity` decimal(12,4) DEFAULT 0 COMMENT '已完成数量',
  `scrapped_quantity` decimal(12,4) DEFAULT 0 COMMENT '报废数量',
  `work_start_date` date DEFAULT NULL COMMENT '计划开始日期',
  `work_finish_date` date DEFAULT NULL COMMENT '计划完成日期',
  `actual_start_time` datetime DEFAULT NULL COMMENT '实际开始时间',
  `actual_finish_time` datetime DEFAULT NULL COMMENT '实际完成时间',
  `work_hours` decimal(8,2) DEFAULT 0 COMMENT '实际工时',
  `status` varchar(20) DEFAULT 'pending' COMMENT '状态: pending-待开工, started-已开工, completed-已完成, cancelled-已取消',
  `is_qc_passed` tinyint(1) DEFAULT NULL COMMENT '质检是否通过: 0-否, 1-是, null-未质检',
  `previous_work_order_id` bigint(20) DEFAULT NULL COMMENT '上一工序任务单ID',
  `next_work_order_id` bigint(20) DEFAULT NULL COMMENT '下一工序任务单ID',
  `qc_order_id` bigint(20) DEFAULT NULL COMMENT '关联质检单ID',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`work_order_id`),
  UNIQUE KEY `uk_work_order_no` (`work_order_no`),
  KEY `idx_production_order_id` (`production_order_id`),
  KEY `idx_process_id` (`process_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='工序任务单表';

-- ----------------------------
-- 报工记录表
-- ----------------------------
DROP TABLE IF EXISTS `erp_work_report`;
CREATE TABLE `erp_work_report` (
  `report_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '报工ID',
  `report_no` varchar(50) NOT NULL COMMENT '报工单号',
  `work_order_id` bigint(20) NOT NULL COMMENT '工序任务单ID',
  `work_order_no` varchar(50) DEFAULT NULL COMMENT '工序任务单号(冗余)',
  `production_order_id` bigint(20) DEFAULT NULL COMMENT '生产订单ID',
  `production_order_no` varchar(50) DEFAULT NULL COMMENT '生产订单号(冗余)',
  `process_id` bigint(20) DEFAULT NULL COMMENT '工序ID',
  `work_center_id` bigint(20) DEFAULT NULL COMMENT '工作中心ID',
  `reporter_id` bigint(20) DEFAULT NULL COMMENT '报工人ID',
  `reporter_name` varchar(50) DEFAULT NULL COMMENT '报工人姓名',
  `report_type` varchar(20) DEFAULT 'finish' COMMENT '报工类型: finish-报完工, partial-报半成品, scrap-报废',
  `quantity` decimal(12,4) NOT NULL COMMENT '数量',
  `qualified_quantity` decimal(12,4) DEFAULT 0 COMMENT '合格数量',
  `scrapped_quantity` decimal(12,4) DEFAULT 0 COMMENT '报废数量',
  `work_hours` decimal(8,2) DEFAULT 0 COMMENT '工时',
  `report_time` datetime NOT NULL COMMENT '报工时间',
  `qc_status` varchar(20) DEFAULT NULL COMMENT '质检状态: pending-待质检, pass-合格, fail-不合格',
  `qc_order_id` bigint(20) DEFAULT NULL COMMENT '关联质检单ID',
  `status` varchar(20) DEFAULT 'submitted' COMMENT '状态: submitted-已提交, confirmed-已确认',
  `confirmed_by` varchar(64) DEFAULT NULL COMMENT '确认人',
  `confirmed_time` datetime DEFAULT NULL COMMENT '确认时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`report_id`),
  UNIQUE KEY `uk_report_no` (`report_no`),
  KEY `idx_work_order_id` (`work_order_id`),
  KEY `idx_report_time` (`report_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='报工记录表';

-- ----------------------------
-- 生产订单状态日志表
-- ----------------------------
DROP TABLE IF EXISTS `erp_production_order_log`;
CREATE TABLE `erp_production_order_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `order_id` bigint(20) NOT NULL COMMENT '生产订单ID',
  `order_no` varchar(50) DEFAULT NULL COMMENT '生产订单号(冗余)',
  `operation_type` varchar(50) NOT NULL COMMENT '操作类型',
  `from_status` varchar(20) DEFAULT NULL COMMENT '原状态',
  `to_status` varchar(20) NOT NULL COMMENT '新状态',
  `operator_id` bigint(20) DEFAULT NULL COMMENT '操作人ID',
  `operator_name` varchar(50) DEFAULT NULL COMMENT '操作人姓名',
  `operation_time` datetime DEFAULT NULL COMMENT '操作时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='生产订单状态日志表';

-- ----------------------------
-- 3. 采购管理模块
-- ----------------------------

-- ----------------------------
-- 采购申请单表
-- ----------------------------
DROP TABLE IF EXISTS `erp_purchase_request`;
CREATE TABLE `erp_purchase_request` (
  `request_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '申请ID',
  `request_no` varchar(50) NOT NULL COMMENT '申请单号',
  `request_type` varchar(20) DEFAULT 'normal' COMMENT '申请类型: normal-普通申请, emergency-紧急申请, mrp-MRP建议',
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '供应商ID',
  `supplier_name` varchar(200) DEFAULT NULL COMMENT '供应商名称(冗余)',
  `warehouse_id` bigint(20) DEFAULT NULL COMMENT '入库仓库ID',
  `apply_user_id` bigint(20) DEFAULT NULL COMMENT '申请人ID',
  `apply_user_name` varchar(50) DEFAULT NULL COMMENT '申请人姓名',
  `department_id` bigint(20) DEFAULT NULL COMMENT '申请部门ID',
  `total_amount` decimal(12,2) DEFAULT 0 COMMENT '总金额',
  `request_date` date DEFAULT NULL COMMENT '申请日期',
  `required_date` date DEFAULT NULL COMMENT '要求到货日期',
  `status` varchar(20) DEFAULT 'draft' COMMENT '状态: draft-草稿, submitted-已提交, approved-已审批, rejected-已驳回, closed-已关闭',
  `approved_by` varchar(64) DEFAULT NULL COMMENT '审批人',
  `approved_time` datetime DEFAULT NULL COMMENT '审批时间',
  `approval_comment` varchar(500) DEFAULT NULL COMMENT '审批意见',
  `source_type` varchar(20) DEFAULT NULL COMMENT '来源类型: mrp-MRP建议, manual-手动',
  `source_id` bigint(20) DEFAULT NULL COMMENT '来源ID',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`request_id`),
  UNIQUE KEY `uk_request_no` (`request_no`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='采购申请单表';

-- ----------------------------
-- 采购申请明细表
-- ----------------------------
DROP TABLE IF EXISTS `erp_purchase_request_item`;
CREATE TABLE `erp_purchase_request_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '明细ID',
  `request_id` bigint(20) NOT NULL COMMENT '申请ID',
  `material_id` bigint(20) NOT NULL COMMENT '物料ID',
  `material_code` varchar(50) DEFAULT NULL COMMENT '物料编码(冗余)',
  `material_name` varchar(200) DEFAULT NULL COMMENT '物料名称(冗余)',
  `specification` varchar(200) DEFAULT NULL COMMENT '规格(冗余)',
  `unit` varchar(20) DEFAULT NULL COMMENT '单位(冗余)',
  `request_quantity` decimal(12,4) NOT NULL COMMENT '申请数量',
  `approved_quantity` decimal(12,4) DEFAULT NULL COMMENT '审批数量',
  `unit_price` decimal(12,2) DEFAULT NULL COMMENT '单价',
  `amount` decimal(12,2) DEFAULT NULL COMMENT '金额',
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '供应商ID',
  `required_date` date DEFAULT NULL COMMENT '要求到货日期',
  `received_quantity` decimal(12,4) DEFAULT 0 COMMENT '已收货数量',
  `status` varchar(20) DEFAULT 'pending' COMMENT '状态: pending-待审批, approved-已审批, partially-部分到货, completed-已完成',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`item_id`),
  KEY `idx_request_id` (`request_id`),
  KEY `idx_material_id` (`material_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='采购申请明细表';

-- ----------------------------
-- 采购订单表
-- ----------------------------
DROP TABLE IF EXISTS `erp_purchase_order`;
CREATE TABLE `erp_purchase_order` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `order_no` varchar(50) NOT NULL COMMENT '订单号',
  `order_type` varchar(20) DEFAULT 'normal' COMMENT '订单类型: normal-普通订单, contract-合同订单',
  `supplier_id` bigint(20) NOT NULL COMMENT '供应商ID',
  `supplier_name` varchar(200) DEFAULT NULL COMMENT '供应商名称(冗余)',
  `supplier_code` varchar(50) DEFAULT NULL COMMENT '供应商编码(冗余)',
  `contact` varchar(50) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `delivery_address` varchar(500) DEFAULT NULL COMMENT '交货地址',
  `warehouse_id` bigint(20) DEFAULT NULL COMMENT '入库仓库ID',
  `buyer_id` bigint(20) DEFAULT NULL COMMENT '采购员ID',
  `buyer_name` varchar(50) DEFAULT NULL COMMENT '采购员姓名',
  `total_amount` decimal(12,2) DEFAULT 0 COMMENT '总金额',
  `discount_rate` decimal(6,4) DEFAULT 0 COMMENT '折扣率',
  `discount_amount` decimal(12,2) DEFAULT 0 COMMENT '折扣金额',
  `net_amount` decimal(12,2) DEFAULT 0 COMMENT '净额',
  `tax_rate` decimal(6,4) DEFAULT 0 COMMENT '税率',
  `tax_amount` decimal(12,2) DEFAULT 0 COMMENT '税额',
  `order_date` date DEFAULT NULL COMMENT '订单日期',
  `expected_date` date DEFAULT NULL COMMENT '期望到货日期',
  `received_amount` decimal(12,2) DEFAULT 0 COMMENT '已到货金额',
  `invoiced_amount` decimal(12,2) DEFAULT 0 COMMENT '已发票金额',
  `paid_amount` decimal(12,2) DEFAULT 0 COMMENT '已付款金额',
  `status` varchar(20) DEFAULT 'draft' COMMENT '状态: draft-草稿, approved-已审批, released-已下达, partially-部分到货, received-全部到货, closed-已关闭, cancelled-已取消',
  `approved_by` varchar(64) DEFAULT NULL COMMENT '审批人',
  `approved_time` datetime DEFAULT NULL COMMENT '审批时间',
  `signed_by` varchar(64) DEFAULT NULL COMMENT '签收人',
  `signed_time` datetime DEFAULT NULL COMMENT '签收时间',
  `source_type` varchar(20) DEFAULT NULL COMMENT '来源: request-采购申请, mrp-MRP建议, manual-手动',
  `source_id` bigint(20) DEFAULT NULL COMMENT '来源ID',
  `source_no` varchar(50) DEFAULT NULL COMMENT '来源单号',
  `contract_no` varchar(50) DEFAULT NULL COMMENT '合同编号',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志',
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `uk_order_no` (`order_no`),
  KEY `idx_supplier_id` (`supplier_id`),
  KEY `idx_status` (`status`),
  KEY `idx_order_date` (`order_date`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='采购订单表';

-- ----------------------------
-- 采购订单明细表
-- ----------------------------
DROP TABLE IF EXISTS `erp_purchase_order_item`;
CREATE TABLE `erp_purchase_order_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '明细ID',
  `order_id` bigint(20) NOT NULL COMMENT '订单ID',
  `material_id` bigint(20) NOT NULL COMMENT '物料ID',
  `material_code` varchar(50) DEFAULT NULL COMMENT '物料编码(冗余)',
  `material_name` varchar(200) DEFAULT NULL COMMENT '物料名称(冗余)',
  `specification` varchar(200) DEFAULT NULL COMMENT '规格(冗余)',
  `unit` varchar(20) DEFAULT NULL COMMENT '单位(冗余)',
  `warehouse_id` bigint(20) DEFAULT NULL COMMENT '入库仓库ID',
  `quantity` decimal(12,4) NOT NULL COMMENT '订购数量',
  `unit_price` decimal(12,2) NOT NULL COMMENT '含税单价',
  `tax_rate` decimal(6,4) DEFAULT 0 COMMENT '税率',
  `tax_amount` decimal(12,2) DEFAULT 0 COMMENT '税额',
  `amount` decimal(12,2) DEFAULT 0 COMMENT '金额(含税)',
  `net_amount` decimal(12,2) DEFAULT 0 COMMENT '净额(不含税)',
  `received_quantity` decimal(12,4) DEFAULT 0 COMMENT '已到货数量',
  `accepted_quantity` decimal(12,4) DEFAULT 0 COMMENT '已验收数量',
  `rejected_quantity` decimal(12,4) DEFAULT 0 COMMENT '已拒收数量',
  `invoiced_quantity` decimal(12,4) DEFAULT 0 COMMENT '已开票数量',
  `paid_amount` decimal(12,2) DEFAULT 0 COMMENT '已付款金额',
  `delivery_date` date DEFAULT NULL COMMENT '交货日期',
  `received_date` date DEFAULT NULL COMMENT '实际到货日期',
  `line_no` int(11) DEFAULT 1 COMMENT '行号',
  `source_type` varchar(20) DEFAULT NULL COMMENT '来源类型',
  `source_id` bigint(20) DEFAULT NULL COMMENT '来源ID(采购申请明细/MRP建议等)',
  `source_line_id` bigint(20) DEFAULT NULL COMMENT '来源明细ID',
  `status` varchar(20) DEFAULT 'pending' COMMENT '状态: pending-待发货, partially-部分到货, received-全部到货, closed-已关闭',
  `is_gifted` tinyint(1) DEFAULT 0 COMMENT '是否赠品: 0-否, 1-是',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`item_id`),
  KEY `idx_order_id` (`order_id`),
  KEY `idx_material_id` (`material_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='采购订单明细表';

-- ----------------------------
-- 采购入库单表
-- ----------------------------
DROP TABLE IF EXISTS `erp_purchase_inbound`;
CREATE TABLE `erp_purchase_inbound` (
  `inbound_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '入库ID',
  `inbound_no` varchar(50) NOT NULL COMMENT '入库单号',
  `purchase_order_id` bigint(20) DEFAULT NULL COMMENT '采购订单ID',
  `purchase_order_no` varchar(50) DEFAULT NULL COMMENT '采购订单号(冗余)',
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '供应商ID',
  `supplier_name` varchar(200) DEFAULT NULL COMMENT '供应商名称(冗余)',
  `warehouse_id` bigint(20) NOT NULL COMMENT '入库仓库ID',
  `inbound_type` varchar(20) DEFAULT 'normal' COMMENT '入库类型: normal-普通入库, return-退货入库',
  `inbound_date` date NOT NULL COMMENT '入库日期',
  `inbound_user_id` bigint(20) DEFAULT NULL COMMENT '入库人ID',
  `inbound_user_name` varchar(50) DEFAULT NULL COMMENT '入库人姓名',
  `qc_status` varchar(20) DEFAULT 'pending' COMMENT '质检状态: pending-待质检, pass-合格, fail-不合格',
  `total_amount` decimal(12,2) DEFAULT 0 COMMENT '总金额',
  `total_quantity` decimal(12,4) DEFAULT 0 COMMENT '总数量',
  `accepted_quantity` decimal(12,4) DEFAULT 0 COMMENT '合格数量',
  `rejected_quantity` decimal(12,4) DEFAULT 0 COMMENT '不合格数量',
  `status` varchar(20) DEFAULT 'draft' COMMENT '状态: draft-草稿, submitted-已提交, completed-已完成, cancelled-已取消',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`inbound_id`),
  UNIQUE KEY `uk_inbound_no` (`inbound_no`),
  KEY `idx_purchase_order_id` (`purchase_order_id`),
  KEY `idx_inbound_date` (`inbound_date`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='采购入库单表';

-- ----------------------------
-- 采购入库明细表
-- ----------------------------
DROP TABLE IF EXISTS `erp_purchase_inbound_item`;
CREATE TABLE `erp_purchase_inbound_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '明细ID',
  `inbound_id` bigint(20) NOT NULL COMMENT '入库ID',
  `purchase_order_item_id` bigint(20) DEFAULT NULL COMMENT '采购订单明细ID',
  `material_id` bigint(20) NOT NULL COMMENT '物料ID',
  `material_code` varchar(50) DEFAULT NULL COMMENT '物料编码(冗余)',
  `material_name` varchar(200) DEFAULT NULL COMMENT '物料名称(冗余)',
  `specification` varchar(200) DEFAULT NULL COMMENT '规格(冗余)',
  `unit` varchar(20) DEFAULT NULL COMMENT '单位(冗余)',
  `warehouse_id` bigint(20) DEFAULT NULL COMMENT '入库仓库ID',
  `location_id` bigint(20) DEFAULT NULL COMMENT '库位ID',
  `batch_no` varchar(50) DEFAULT NULL COMMENT '批次号',
  `inbound_quantity` decimal(12,4) NOT NULL COMMENT '入库数量',
  `qualified_quantity` decimal(12,4) DEFAULT 0 COMMENT '合格数量',
  `rejected_quantity` decimal(12,4) DEFAULT 0 COMMENT '不合格数量',
  `rejected_reason` varchar(200) DEFAULT NULL COMMENT '不合格原因',
  `unit_cost` decimal(12,4) DEFAULT 0 COMMENT '单位成本',
  `amount` decimal(12,2) DEFAULT 0 COMMENT '金额',
  `mfg_date` date DEFAULT NULL COMMENT '生产日期',
  `exp_date` date DEFAULT NULL COMMENT '有效期至',
  `qc_order_id` bigint(20) DEFAULT NULL COMMENT '质检单ID',
  `qc_status` varchar(20) DEFAULT 'pending' COMMENT '质检状态',
  `line_no` int(11) DEFAULT 1 COMMENT '行号',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`item_id`),
  KEY `idx_inbound_id` (`inbound_id`),
  KEY `idx_material_id` (`material_id`),
  KEY `idx_batch_no` (`batch_no`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='采购入库明细表';

-- ----------------------------
-- 4. 销售管理模块
-- ----------------------------

-- ----------------------------
-- 销售订单表
-- ----------------------------
DROP TABLE IF EXISTS `erp_sales_order`;
CREATE TABLE `erp_sales_order` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `order_no` varchar(50) NOT NULL COMMENT '订单号',
  `order_type` varchar(20) DEFAULT 'normal' COMMENT '订单类型: normal-普通订单, contract-合同订单',
  `customer_id` bigint(20) NOT NULL COMMENT '客户ID',
  `customer_name` varchar(200) DEFAULT NULL COMMENT '客户名称(冗余)',
  `customer_code` varchar(50) DEFAULT NULL COMMENT '客户编码(冗余)',
  `contact` varchar(50) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `delivery_address` varchar(500) DEFAULT NULL COMMENT '交货地址',
  `warehouse_id` bigint(20) DEFAULT NULL COMMENT '发货仓库ID',
  `salesman_id` bigint(20) DEFAULT NULL COMMENT '业务员ID',
  `salesman_name` varchar(50) DEFAULT NULL COMMENT '业务员姓名',
  `total_amount` decimal(12,2) DEFAULT 0 COMMENT '总金额',
  `discount_rate` decimal(6,4) DEFAULT 0 COMMENT '折扣率',
  `discount_amount` decimal(12,2) DEFAULT 0 COMMENT '折扣金额',
  `net_amount` decimal(12,2) DEFAULT 0 COMMENT '净额',
  `tax_rate` decimal(6,4) DEFAULT 0 COMMENT '税率',
  `tax_amount` decimal(12,2) DEFAULT 0 COMMENT '税额',
  `order_date` date DEFAULT NULL COMMENT '订单日期',
  `delivery_date` date DEFAULT NULL COMMENT '要求交货日期',
  `shipped_amount` decimal(12,2) DEFAULT 0 COMMENT '已发货金额',
  `invoiced_amount` decimal(12,2) DEFAULT 0 COMMENT '已发票金额',
  `received_amount` decimal(12,2) DEFAULT 0 COMMENT '已收款金额',
  `status` varchar(20) DEFAULT 'draft' COMMENT '状态: draft-草稿, approved-已审批, released-已确认, partially-部分发货, shipped-已发货, received-已完成, closed-已关闭, cancelled-已取消',
  `approved_by` varchar(64) DEFAULT NULL COMMENT '审批人',
  `approved_time` datetime DEFAULT NULL COMMENT '审批时间',
  `source_type` varchar(20) DEFAULT NULL COMMENT '来源: manual-手动, online-线上',
  `contract_no` varchar(50) DEFAULT NULL COMMENT '合同编号',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志',
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `uk_order_no` (`order_no`),
  KEY `idx_customer_id` (`customer_id`),
  KEY `idx_status` (`status`),
  KEY `idx_order_date` (`order_date`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='销售订单表';

-- ----------------------------
-- 销售订单明细表
-- ----------------------------
DROP TABLE IF EXISTS `erp_sales_order_item`;
CREATE TABLE `erp_sales_order_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '明细ID',
  `order_id` bigint(20) NOT NULL COMMENT '订单ID',
  `material_id` bigint(20) NOT NULL COMMENT '物料ID',
  `material_code` varchar(50) DEFAULT NULL COMMENT '物料编码(冗余)',
  `material_name` varchar(200) DEFAULT NULL COMMENT '物料名称(冗余)',
  `specification` varchar(200) DEFAULT NULL COMMENT '规格(冗余)',
  `unit` varchar(20) DEFAULT NULL COMMENT '单位(冗余)',
  `warehouse_id` bigint(20) DEFAULT NULL COMMENT '发货仓库ID',
  `quantity` decimal(12,4) NOT NULL COMMENT '订购数量',
  `unit_price` decimal(12,2) NOT NULL COMMENT '含税单价',
  `tax_rate` decimal(6,4) DEFAULT 0 COMMENT '税率',
  `tax_amount` decimal(12,2) DEFAULT 0 COMMENT '税额',
  `amount` decimal(12,2) DEFAULT 0 COMMENT '金额(含税)',
  `net_amount` decimal(12,2) DEFAULT 0 COMMENT '净额(不含税)',
  `delivered_quantity` decimal(12,4) DEFAULT 0 COMMENT '已发货数量',
  `invoiced_quantity` decimal(12,4) DEFAULT 0 COMMENT '已开票数量',
  `returned_quantity` decimal(12,4) DEFAULT 0 COMMENT '已退货数量',
  `received_amount` decimal(12,2) DEFAULT 0 COMMENT '已收款金额',
  `delivery_date` date DEFAULT NULL COMMENT '交货日期',
  `line_no` int(11) DEFAULT 1 COMMENT '行号',
  `status` varchar(20) DEFAULT 'pending' COMMENT '状态: pending-待发货, partially-部分发货, delivered-已发货, completed-已完成',
  `is_gifted` tinyint(1) DEFAULT 0 COMMENT '是否赠品: 0-否, 1-是',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`item_id`),
  KEY `idx_order_id` (`order_id`),
  KEY `idx_material_id` (`material_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='销售订单明细表';

-- ----------------------------
-- 销售出库单表
-- ----------------------------
DROP TABLE IF EXISTS `erp_sales_outbound`;
CREATE TABLE `erp_sales_outbound` (
  `outbound_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '出库ID',
  `outbound_no` varchar(50) NOT NULL COMMENT '出库单号',
  `sales_order_id` bigint(20) DEFAULT NULL COMMENT '销售订单ID',
  `sales_order_no` varchar(50) DEFAULT NULL COMMENT '销售订单号(冗余)',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户ID',
  `customer_name` varchar(200) DEFAULT NULL COMMENT '客户名称(冗余)',
  `warehouse_id` bigint(20) NOT NULL COMMENT '出库仓库ID',
  `outbound_type` varchar(20) DEFAULT 'normal' COMMENT '出库类型: normal-正常出库, return-退货出库',
  `outbound_date` date NOT NULL COMMENT '出库日期',
  `outbound_user_id` bigint(20) DEFAULT NULL COMMENT '出库人ID',
  `outbound_user_name` varchar(50) DEFAULT NULL COMMENT '出库人姓名',
  `total_amount` decimal(12,2) DEFAULT 0 COMMENT '总金额',
  `total_quantity` decimal(12,4) DEFAULT 0 COMMENT '总数量',
  `status` varchar(20) DEFAULT 'draft' COMMENT '状态: draft-草稿, submitted-已提交, completed-已完成, cancelled-已取消',
  `delivery_no` varchar(50) DEFAULT NULL COMMENT '发货单号',
  `express_company` varchar(100) DEFAULT NULL COMMENT '快递公司',
  `express_no` varchar(50) DEFAULT NULL COMMENT '快递单号',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`outbound_id`),
  UNIQUE KEY `uk_outbound_no` (`outbound_no`),
  KEY `idx_sales_order_id` (`sales_order_id`),
  KEY `idx_outbound_date` (`outbound_date`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='销售出库单表';

-- ----------------------------
-- 销售出库明细表
-- ----------------------------
DROP TABLE IF EXISTS `erp_sales_outbound_item`;
CREATE TABLE `erp_sales_outbound_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '明细ID',
  `outbound_id` bigint(20) NOT NULL COMMENT '出库ID',
  `sales_order_item_id` bigint(20) DEFAULT NULL COMMENT '销售订单明细ID',
  `material_id` bigint(20) NOT NULL COMMENT '物料ID',
  `material_code` varchar(50) DEFAULT NULL COMMENT '物料编码(冗余)',
  `material_name` varchar(200) DEFAULT NULL COMMENT '物料名称(冗余)',
  `specification` varchar(200) DEFAULT NULL COMMENT '规格(冗余)',
  `unit` varchar(20) DEFAULT NULL COMMENT '单位(冗余)',
  `warehouse_id` bigint(20) DEFAULT NULL COMMENT '仓库ID',
  `location_id` bigint(20) DEFAULT NULL COMMENT '库位ID',
  `batch_no` varchar(50) DEFAULT NULL COMMENT '批次号',
  `outbound_quantity` decimal(12,4) NOT NULL COMMENT '出库数量',
  `unit_price` decimal(12,2) DEFAULT 0 COMMENT '单价',
  `amount` decimal(12,2) DEFAULT 0 COMMENT '金额',
  `line_no` int(11) DEFAULT 1 COMMENT '行号',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`item_id`),
  KEY `idx_outbound_id` (`outbound_id`),
  KEY `idx_material_id` (`material_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='销售出库明细表';

-- ----------------------------
-- 5. 库存管理模块
-- ----------------------------

-- ----------------------------
-- 库存台账表
-- ----------------------------
DROP TABLE IF EXISTS `erp_inventory`;
CREATE TABLE `erp_inventory` (
  `inventory_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '库存ID',
  `material_id` bigint(20) NOT NULL COMMENT '物料ID',
  `warehouse_id` bigint(20) NOT NULL COMMENT '仓库ID',
  `location_id` bigint(20) DEFAULT NULL COMMENT '库位ID',
  `batch_no` varchar(50) DEFAULT NULL COMMENT '批次号',
  `quantity` decimal(12,4) NOT NULL DEFAULT 0 COMMENT '库存数量',
  `available_quantity` decimal(12,4) NOT NULL DEFAULT 0 COMMENT '可用数量',
  `allocated_quantity` decimal(12,4) DEFAULT 0 COMMENT '已分配数量',
  `frozen_quantity` decimal(12,4) DEFAULT 0 COMMENT '冻结数量',
  `unit_cost` decimal(12,4) DEFAULT 0 COMMENT '单位成本',
  `total_amount` decimal(12,2) DEFAULT 0 COMMENT '库存金额',
  `mfg_date` date DEFAULT NULL COMMENT '生产日期',
  `exp_date` date DEFAULT NULL COMMENT '有效期至',
  `last_in_date` date DEFAULT NULL COMMENT '最后入库日期',
  `last_out_date` date DEFAULT NULL COMMENT '最后出库日期',
  `status` char(1) DEFAULT '0' COMMENT '状态: 0-正常, 1-冻结',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`inventory_id`),
  UNIQUE KEY `uk_material_warehouse_location_batch` (`material_id`, `warehouse_id`, `location_id`, `batch_no`),
  KEY `idx_material_id` (`material_id`),
  KEY `idx_warehouse_id` (`warehouse_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='库存台账表';

-- ----------------------------
-- 库存异动记录表(流水账)
-- ----------------------------
DROP TABLE IF EXISTS `erp_inventory_trans`;
CREATE TABLE `erp_inventory_trans` (
  `trans_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '异动ID',
  `trans_no` varchar(50) NOT NULL COMMENT '异动单号',
  `trans_type` varchar(50) NOT NULL COMMENT '异动类型: purchase_in-采购入库, sale_out-销售出库, prod_in-生产入库, prod_out-领料出库, transfer_in-调拨入库, transfer_out-调拨出库, check_in-盘点入库, check_out-盘点出库, adjust_in-调整入库, adjust_out-调整出库',
  `source_type` varchar(50) DEFAULT NULL COMMENT '来源单据类型',
  `source_id` bigint(20) DEFAULT NULL COMMENT '来源单据ID',
  `source_no` varchar(50) DEFAULT NULL COMMENT '来源单据号',
  `material_id` bigint(20) NOT NULL COMMENT '物料ID',
  `material_name` varchar(200) DEFAULT NULL COMMENT '物料名称(冗余)',
  `warehouse_id` bigint(20) NOT NULL COMMENT '仓库ID',
  `location_id` bigint(20) DEFAULT NULL COMMENT '库位ID',
  `batch_no` varchar(50) DEFAULT NULL COMMENT '批次号',
  `in_quantity` decimal(12,4) DEFAULT 0 COMMENT '入库数量',
  `out_quantity` decimal(12,4) DEFAULT 0 COMMENT '出库数量',
  `before_quantity` decimal(12,4) DEFAULT 0 COMMENT '异动前数量',
  `after_quantity` decimal(12,4) DEFAULT 0 COMMENT '异动后数量',
  `unit_cost` decimal(12,4) DEFAULT 0 COMMENT '单位成本',
  `amount` decimal(12,2) DEFAULT 0 COMMENT '金额',
  `trans_date` date NOT NULL COMMENT '异动日期',
  `trans_time` datetime NOT NULL COMMENT '异动时间',
  `operator_id` bigint(20) DEFAULT NULL COMMENT '操作人ID',
  `operator_name` varchar(50) DEFAULT NULL COMMENT '操作人姓名',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`trans_id`),
  KEY `idx_material_id` (`material_id`),
  KEY `idx_warehouse_id` (`warehouse_id`),
  KEY `idx_trans_date` (`trans_date`),
  KEY `idx_source` (`source_type`, `source_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='库存异动记录表';

-- ----------------------------
-- 库存调拨单表
-- ----------------------------
DROP TABLE IF EXISTS `erp_stock_transfer`;
CREATE TABLE `erp_stock_transfer` (
  `transfer_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '调拨ID',
  `transfer_no` varchar(50) NOT NULL COMMENT '调拨单号',
  `from_warehouse_id` bigint(20) NOT NULL COMMENT '调出仓库ID',
  `to_warehouse_id` bigint(20) NOT NULL COMMENT '调入仓库ID',
  `transfer_date` date NOT NULL COMMENT '调拨日期',
  `transfer_type` varchar(20) DEFAULT 'normal' COMMENT '调拨类型: normal-正常调拨, repair-维修调拨',
  `applicant_id` bigint(20) DEFAULT NULL COMMENT '申请人ID',
  `applicant_name` varchar(50) DEFAULT NULL COMMENT '申请人姓名',
  `handler_id` bigint(20) DEFAULT NULL COMMENT '经办人ID',
  `handler_name` varchar(50) DEFAULT NULL COMMENT '经办人姓名',
  `status` varchar(20) DEFAULT 'draft' COMMENT '状态: draft-草稿, approved-已审批, out_completed-出库完成, completed-已完成, cancelled-已取消',
  `out_time` datetime DEFAULT NULL COMMENT '出库时间',
  `in_time` datetime DEFAULT NULL COMMENT '入库时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`transfer_id`),
  UNIQUE KEY `uk_transfer_no` (`transfer_no`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='库存调拨单表';

-- ----------------------------
-- 库存调拨明细表
-- ----------------------------
DROP TABLE IF EXISTS `erp_stock_transfer_item`;
CREATE TABLE `erp_stock_transfer_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '明细ID',
  `transfer_id` bigint(20) NOT NULL COMMENT '调拨ID',
  `material_id` bigint(20) NOT NULL COMMENT '物料ID',
  `material_name` varchar(200) DEFAULT NULL COMMENT '物料名称(冗余)',
  `from_location_id` bigint(20) DEFAULT NULL COMMENT '调出库位ID',
  `to_location_id` bigint(20) DEFAULT NULL COMMENT '调入库位ID',
  `batch_no` varchar(50) DEFAULT NULL COMMENT '批次号',
  `transfer_quantity` decimal(12,4) NOT NULL COMMENT '调拨数量',
  `out_quantity` decimal(12,4) DEFAULT 0 COMMENT '已出库数量',
  `in_quantity` decimal(12,4) DEFAULT 0 COMMENT '已入库数量',
  `unit_cost` decimal(12,4) DEFAULT 0 COMMENT '单位成本',
  `amount` decimal(12,2) DEFAULT 0 COMMENT '金额',
  `line_no` int(11) DEFAULT 1 COMMENT '行号',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`item_id`),
  KEY `idx_transfer_id` (`transfer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='库存调拨明细表';

-- ----------------------------
-- 库存盘点单表
-- ----------------------------
DROP TABLE IF EXISTS `erp_stock_check`;
CREATE TABLE `erp_stock_check` (
  `check_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '盘点ID',
  `check_no` varchar(50) NOT NULL COMMENT '盘点单号',
  `warehouse_id` bigint(20) NOT NULL COMMENT '仓库ID',
  `check_type` varchar(20) DEFAULT 'full' COMMENT '盘点类型: full-全盘, partial-抽盘',
  `check_date` date NOT NULL COMMENT '盘点日期',
  `checker_id` bigint(20) DEFAULT NULL COMMENT '盘点人ID',
  `checker_name` varchar(50) DEFAULT NULL COMMENT '盘点人姓名',
  `total_amount` decimal(12,2) DEFAULT 0 COMMENT '差异总金额',
  `status` varchar(20) DEFAULT 'draft' COMMENT '状态: draft-草稿, checking-盘点中, submitted-已提交, approved-已审批, completed-已完成',
  `approved_by` varchar(64) DEFAULT NULL COMMENT '审批人',
  `approved_time` datetime DEFAULT NULL COMMENT '审批时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`check_id`),
  UNIQUE KEY `uk_check_no` (`check_no`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='库存盘点单表';

-- ----------------------------
-- 库存盘点明细表
-- ----------------------------
DROP TABLE IF EXISTS `erp_stock_check_item`;
CREATE TABLE `erp_stock_check_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '明细ID',
  `check_id` bigint(20) NOT NULL COMMENT '盘点ID',
  `material_id` bigint(20) NOT NULL COMMENT '物料ID',
  `material_name` varchar(200) DEFAULT NULL COMMENT '物料名称(冗余)',
  `location_id` bigint(20) DEFAULT NULL COMMENT '库位ID',
  `batch_no` varchar(50) DEFAULT NULL COMMENT '批次号',
  `book_quantity` decimal(12,4) DEFAULT 0 COMMENT '账面数量',
  `check_quantity` decimal(12,4) DEFAULT 0 COMMENT '盘点数量',
  `diff_quantity` decimal(12,4) DEFAULT 0 COMMENT '差异数量',
  `unit_cost` decimal(12,4) DEFAULT 0 COMMENT '单位成本',
  `diff_amount` decimal(12,2) DEFAULT 0 COMMENT '差异金额',
  `diff_reason` varchar(200) DEFAULT NULL COMMENT '差异原因',
  `dispose_type` varchar(20) DEFAULT NULL COMMENT '处理方式: adjust-调整, loss-报损, overflow-报溢',
  `dispose_status` varchar(20) DEFAULT 'pending' COMMENT '处理状态: pending-待处理, disposed-已处理',
  `line_no` int(11) DEFAULT 1 COMMENT '行号',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`item_id`),
  KEY `idx_check_id` (`check_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='库存盘点明细表';

-- ----------------------------
-- 6. 财务管理模块
-- ----------------------------

-- ----------------------------
-- 收款单表
-- ----------------------------
DROP TABLE IF EXISTS `erp_receipt`;
CREATE TABLE `erp_receipt` (
  `receipt_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '收款ID',
  `receipt_no` varchar(50) NOT NULL COMMENT '收款单号',
  `receipt_type` varchar(20) DEFAULT 'normal' COMMENT '收款类型: normal-正常收款, advance-预收款, other-其他',
  `customer_id` bigint(20) NOT NULL COMMENT '客户ID',
  `customer_name` varchar(200) DEFAULT NULL COMMENT '客户名称(冗余)',
  `sales_order_id` bigint(20) DEFAULT NULL COMMENT '销售订单ID',
  `sales_order_no` varchar(50) DEFAULT NULL COMMENT '销售订单号(冗余)',
  `receipt_date` date NOT NULL COMMENT '收款日期',
  `bank_account_id` bigint(20) DEFAULT NULL COMMENT '收款银行账户ID',
  `bank_account` varchar(50) DEFAULT NULL COMMENT '收款银行账户',
  `total_amount` decimal(12,2) NOT NULL COMMENT '收款金额',
  `advance_amount` decimal(12,2) DEFAULT 0 COMMENT '冲预收款金额',
  `writeoff_amount` decimal(12,2) DEFAULT 0 COMMENT '核销应收金额',
  `handler_id` bigint(20) DEFAULT NULL COMMENT '经办人ID',
  `handler_name` varchar(50) DEFAULT NULL COMMENT '经办人姓名',
  `status` varchar(20) DEFAULT 'draft' COMMENT '状态: draft-草稿, confirmed-已确认, cancelled-已取消',
  `confirmed_by` varchar(64) DEFAULT NULL COMMENT '确认人',
  `confirmed_time` datetime DEFAULT NULL COMMENT '确认时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`receipt_id`),
  UNIQUE KEY `uk_receipt_no` (`receipt_no`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='收款单表';

-- ----------------------------
-- 付款单表
-- ----------------------------
DROP TABLE IF EXISTS `erp_payment`;
CREATE TABLE `erp_payment` (
  `payment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '付款ID',
  `payment_no` varchar(50) NOT NULL COMMENT '付款单号',
  `payment_type` varchar(20) DEFAULT 'normal' COMMENT '付款类型: normal-正常付款, advance-预付款, other-其他',
  `supplier_id` bigint(20) NOT NULL COMMENT '供应商ID',
  `supplier_name` varchar(200) DEFAULT NULL COMMENT '供应商名称(冗余)',
  `purchase_order_id` bigint(20) DEFAULT NULL COMMENT '采购订单ID',
  `purchase_order_no` varchar(50) DEFAULT NULL COMMENT '采购订单号(冗余)',
  `payment_date` date NOT NULL COMMENT '付款日期',
  `bank_account_id` bigint(20) DEFAULT NULL COMMENT '付款银行账户ID',
  `bank_account` varchar(50) DEFAULT NULL COMMENT '付款银行账户',
  `total_amount` decimal(12,2) NOT NULL COMMENT '付款金额',
  `advance_amount` decimal(12,2) DEFAULT 0 COMMENT '冲预付款金额',
  `writeoff_amount` decimal(12,2) DEFAULT 0 COMMENT '核销应付金额',
  `handler_id` bigint(20) DEFAULT NULL COMMENT '经办人ID',
  `handler_name` varchar(50) DEFAULT NULL COMMENT '经办人姓名',
  `status` varchar(20) DEFAULT 'draft' COMMENT '状态: draft-草稿, confirmed-已确认, cancelled-已取消',
  `confirmed_by` varchar(64) DEFAULT NULL COMMENT '确认人',
  `confirmed_time` datetime DEFAULT NULL COMMENT '确认时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`payment_id`),
  UNIQUE KEY `uk_payment_no` (`payment_no`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='付款单表';

-- ----------------------------
-- 应收款表
-- ----------------------------
DROP TABLE IF EXISTS `erp_receivable`;
CREATE TABLE `erp_receivable` (
  `receivable_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '应收款ID',
  `receivable_no` varchar(50) NOT NULL COMMENT '应收单号',
  `customer_id` bigint(20) NOT NULL COMMENT '客户ID',
  `customer_name` varchar(200) DEFAULT NULL COMMENT '客户名称(冗余)',
  `sales_order_id` bigint(20) DEFAULT NULL COMMENT '销售订单ID',
  `sales_order_no` varchar(50) DEFAULT NULL COMMENT '销售订单号',
  `source_type` varchar(50) NOT NULL COMMENT '来源类型: sales_order-销售订单, other-其他',
  `source_id` bigint(20) DEFAULT NULL COMMENT '来源ID',
  `source_no` varchar(50) DEFAULT NULL COMMENT '来源单号',
  `invoice_no` varchar(50) DEFAULT NULL COMMENT '发票号',
  `receivable_date` date NOT NULL COMMENT '应收日期',
  `due_date` date DEFAULT NULL COMMENT '到期日期',
  `total_amount` decimal(12,2) NOT NULL COMMENT '应收金额',
  `paid_amount` decimal(12,2) DEFAULT 0 COMMENT '已收金额',
  `writeoff_amount` decimal(12,2) DEFAULT 0 COMMENT '核销金额',
  `balance_amount` decimal(12,2) DEFAULT 0 COMMENT '应收余额',
  `overdue_days` int(11) DEFAULT 0 COMMENT '逾期天数',
  `status` varchar(20) DEFAULT 'pending' COMMENT '状态: pending-待收款, partially-部分收款, received-已收款, cancelled-已取消',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`receivable_id`),
  UNIQUE KEY `uk_receivable_no` (`receivable_no`),
  KEY `idx_customer_id` (`customer_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='应收款表';

-- ----------------------------
-- 应付款表
-- ----------------------------
DROP TABLE IF EXISTS `erp_payable`;
CREATE TABLE `erp_payable` (
  `payable_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '应付款ID',
  `payable_no` varchar(50) NOT NULL COMMENT '应付单号',
  `supplier_id` bigint(20) NOT NULL COMMENT '供应商ID',
  `supplier_name` varchar(200) DEFAULT NULL COMMENT '供应商名称(冗余)',
  `purchase_order_id` bigint(20) DEFAULT NULL COMMENT '采购订单ID',
  `purchase_order_no` varchar(50) DEFAULT NULL COMMENT '采购订单号',
  `source_type` varchar(50) NOT NULL COMMENT '来源类型: purchase_order-采购订单, other-其他',
  `source_id` bigint(20) DEFAULT NULL COMMENT '来源ID',
  `source_no` varchar(50) DEFAULT NULL COMMENT '来源单号',
  `invoice_no` varchar(50) DEFAULT NULL COMMENT '发票号',
  `payable_date` date NOT NULL COMMENT '应付日期',
  `due_date` date DEFAULT NULL COMMENT '到期日期',
  `total_amount` decimal(12,2) NOT NULL COMMENT '应付金额',
  `paid_amount` decimal(12,2) DEFAULT 0 COMMENT '已付金额',
  `writeoff_amount` decimal(12,2) DEFAULT 0 COMMENT '核销金额',
  `balance_amount` decimal(12,2) DEFAULT 0 COMMENT '应付余额',
  `overdue_days` int(11) DEFAULT 0 COMMENT '逾期天数',
  `status` varchar(20) DEFAULT 'pending' COMMENT '状态: pending-待付款, partially-部分付款, paid-已付款, cancelled-已取消',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`payable_id`),
  UNIQUE KEY `uk_payable_no` (`payable_no`),
  KEY `idx_supplier_id` (`supplier_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='应付款表';

-- ----------------------------
-- 凭证主表
-- ----------------------------
DROP TABLE IF EXISTS `erp_voucher`;
CREATE TABLE `erp_voucher` (
  `voucher_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '凭证ID',
  `voucher_no` varchar(50) NOT NULL COMMENT '凭证号',
  `voucher_date` date NOT NULL COMMENT '凭证日期',
  `period` varchar(7) NOT NULL COMMENT '会计期间: YYYY-MM',
  `voucher_type` varchar(20) DEFAULT 'general' COMMENT '凭证类型: general-记账凭证, receipt-收款凭证, payment-付款凭证, transfer-转账凭证',
  `attachment_count` int(11) DEFAULT 0 COMMENT '附件数',
  `total_debit` decimal(12,2) DEFAULT 0 COMMENT '借方合计',
  `total_credit` decimal(12,2) DEFAULT 0 COMMENT '贷方合计',
  `source_type` varchar(50) DEFAULT NULL COMMENT '来源类型',
  `source_id` bigint(20) DEFAULT NULL COMMENT '来源ID',
  `source_no` varchar(50) DEFAULT NULL COMMENT '来源单号',
  `poster_id` bigint(20) DEFAULT NULL COMMENT '制单人ID',
  `poster_name` varchar(50) DEFAULT NULL COMMENT '制单人姓名',
  `poster_time` datetime DEFAULT NULL COMMENT '制单时间',
  `checker_id` bigint(20) DEFAULT NULL COMMENT '审核人ID',
  `checker_name` varchar(50) DEFAULT NULL COMMENT '审核人姓名',
  `checker_time` datetime DEFAULT NULL COMMENT '审核时间',
  `poster_status` varchar(20) DEFAULT 'draft' COMMENT '状态: draft-待记账, posted-已记账, reversed-已冲销',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`voucher_id`),
  UNIQUE KEY `uk_voucher_no` (`voucher_no`),
  KEY `idx_voucher_date` (`voucher_date`),
  KEY `idx_period` (`period`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='凭证主表';

-- ----------------------------
-- 凭证明细表
-- ----------------------------
DROP TABLE IF EXISTS `erp_voucher_item`;
CREATE TABLE `erp_voucher_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '明细ID',
  `voucher_id` bigint(20) NOT NULL COMMENT '凭证ID',
  `account_code` varchar(50) NOT NULL COMMENT '科目编码',
  `account_name` varchar(100) NOT NULL COMMENT '科目名称',
  `account_id` bigint(20) DEFAULT NULL COMMENT '科目ID',
  `direction` varchar(10) NOT NULL COMMENT '方向: debit-借, credit-贷',
  `amount` decimal(12,2) NOT NULL COMMENT '金额',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户ID(辅助核算)',
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '供应商ID(辅助核算)',
  `department_id` bigint(20) DEFAULT NULL COMMENT '部门ID(辅助核算)',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目ID(辅助核算)',
  `summary` varchar(200) DEFAULT NULL COMMENT '摘要',
  `line_no` int(11) DEFAULT 1 COMMENT '行号',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`item_id`),
  KEY `idx_voucher_id` (`voucher_id`),
  KEY `idx_account_code` (`account_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='凭证明细表';

-- ----------------------------
-- 发票主表
-- ----------------------------
DROP TABLE IF EXISTS `erp_invoice`;
CREATE TABLE `erp_invoice` (
  `invoice_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '发票ID',
  `invoice_no` varchar(50) NOT NULL COMMENT '发票号',
  `invoice_type` varchar(20) NOT NULL COMMENT '发票类型: sale-销售发票, purchase-采购发票',
  `invoice_kind` varchar(20) DEFAULT 'vat_special' COMMENT '发票种类: vat_special-增值税专用发票, vat_normal-增值税普通发票, receipt-收据',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户ID(销售)/供应商ID(采购)',
  `party_name` varchar(200) DEFAULT NULL COMMENT '对方单位名称',
  `tax_no` varchar(50) DEFAULT NULL COMMENT '税号',
  `bank` varchar(100) DEFAULT NULL COMMENT '开户银行',
  `bank_account` varchar(50) DEFAULT NULL COMMENT '银行账号',
  `address` varchar(500) DEFAULT NULL COMMENT '地址电话',
  `invoice_date` date NOT NULL COMMENT '开票日期',
  `billing_period` varchar(7) DEFAULT NULL COMMENT ' billing_period',
  `total_amount` decimal(12,2) NOT NULL COMMENT '价税合计',
  `net_amount` decimal(12,2) DEFAULT 0 COMMENT '金额(不含税)',
  `tax_amount` decimal(12,2) DEFAULT 0 COMMENT '税额',
  `tax_rate` decimal(6,4) DEFAULT 0 COMMENT '税率',
  `source_type` varchar(50) DEFAULT NULL COMMENT '来源单据类型',
  `source_id` bigint(20) DEFAULT NULL COMMENT '来源单据ID',
  `source_no` varchar(50) DEFAULT NULL COMMENT '来源单据号',
  `writeoff_status` varchar(20) DEFAULT 'pending' COMMENT '核销状态: pending-待核销, partially-部分核销, writeoff-已核销',
  `writeoff_amount` decimal(12,2) DEFAULT 0 COMMENT '已核销金额',
  `status` varchar(20) DEFAULT 'draft' COMMENT '状态: draft-草稿, approved-已审核, cancelled-已作废',
  `drawer` varchar(50) DEFAULT NULL COMMENT '开票人',
  `reviewer` varchar(50) DEFAULT NULL COMMENT '复核人',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`invoice_id`),
  UNIQUE KEY `uk_invoice_no` (`invoice_no`),
  KEY `idx_customer_id` (`customer_id`),
  KEY `idx_invoice_date` (`invoice_date`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='发票主表';

-- ----------------------------
-- 发票明细表
-- ----------------------------
DROP TABLE IF EXISTS `erp_invoice_item`;
CREATE TABLE `erp_invoice_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '明细ID',
  `invoice_id` bigint(20) NOT NULL COMMENT '发票ID',
  `material_id` bigint(20) DEFAULT NULL COMMENT '物料ID',
  `material_name` varchar(200) DEFAULT NULL COMMENT '物料名称',
  `specification` varchar(200) DEFAULT NULL COMMENT '规格型号',
  `unit` varchar(20) DEFAULT NULL COMMENT '单位',
  `quantity` decimal(12,4) DEFAULT 0 COMMENT '数量',
  `unit_price` decimal(12,4) DEFAULT 0 COMMENT '单价',
  `net_amount` decimal(12,2) DEFAULT 0 COMMENT '金额(不含税)',
  `tax_rate` decimal(6,4) DEFAULT 0 COMMENT '税率',
  `tax_amount` decimal(12,2) DEFAULT 0 COMMENT '税额',
  `amount` decimal(12,2) DEFAULT 0 COMMENT '价税合计',
  `source_type` varchar(50) DEFAULT NULL COMMENT '来源类型',
  `source_id` bigint(20) DEFAULT NULL COMMENT '来源ID',
  `source_line_id` bigint(20) DEFAULT NULL COMMENT '来源明细ID',
  `line_no` int(11) DEFAULT 1 COMMENT '行号',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`item_id`),
  KEY `idx_invoice_id` (`invoice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='发票明细表';

SET FOREIGN_KEY_CHECKS = 1;
