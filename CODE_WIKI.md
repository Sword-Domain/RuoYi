# RuoYi (若依) 管理系统 Code Wiki

## 项目概览

| 属性 | 说明 |
|------|------|
| **项目名称** | RuoYi (若依) |
| **版本** | 4.8.3 |
| **技术栈** | Spring Boot 4.x + Shiro 2.x + MyBatis + Thymeleaf |
| **JDK版本** | 17+ |
| **构建工具** | Maven |
| **数据库** | MySQL |
| **项目类型** | 轻量级Java后台管理系统快速开发框架 |

### 项目简介

RuoYi 是一套基于 Spring Boot 开发的全部开源的快速开发平台，可用于网站管理后台、CMS、CRM、OA 等 Web 应用程序。系统采用传统的 MVC 架构，前端基于 Thymeleaf 模板引擎 + jQuery/H+ UI 框架，后端基于 Spring Boot + Shiro + MyBatis 技术栈。

---

## 项目结构

```
ruoyi/
├── pom.xml                          # 父POM，统一管理依赖版本
├── ruoyi-admin/                     # Web服务入口模块
├── ruoyi-framework/                 # 框架核心模块
├── ruoyi-system/                    # 系统业务模块
├── ruoyi-common/                    # 通用工具模块
├── ruoyi-quartz/                    # 定时任务模块
├── ruoyi-generator/                 # 代码生成模块
├── bin/                             # 脚本文件
└── doc/                             # 文档目录
```

---

## 模块职责说明

### 1. ruoyi-admin（Web服务入口）

**职责**: 作为整个应用的启动入口和Web服务承载模块，打包部署的唯一模块。

**核心文件**:

| 文件 | 说明 |
|------|------|
| [RuoYiApplication.java](file:///workspace/ruoyi-admin/src/main/java/com/ruoyi/RuoYiApplication.java) | Spring Boot 启动类，程序入口 |
| [RuoYiServletInitializer.java](file:///workspace/ruoyi-admin/src/main/java/com/ruoyi/RuoYiServletInitializer.java) | 支持外部 Tomcat 部署的初始化器 |
| [application.yml](file:///workspace/ruoyi-admin/src/main/resources/application.yml) | 主配置文件，包含服务端口、Shiro、MyBatis、分页等配置 |
| [application-druid.yml](file:///workspace/ruoyi-admin/src/main/resources/application-druid.yml) | 数据源配置，支持主从分离 |
| [logback.xml](file:///workspace/ruoyi-admin/src/main/resources/logback.xml) | 日志配置文件 |

**Controller 层**:

| Controller | 路径 | 职责 |
|------------|------|------|
| [SysLoginController](file:///workspace/ruoyi-admin/src/main/java/com/ruoyi/web/controller/system/SysLoginController.java) | `/login` | 登录认证 |
| [SysUserController](file:///workspace/ruoyi-admin/src/main/java/com/ruoyi/web/controller/system/SysUserController.java) | `/system/user` | 用户管理 |
| [SysRoleController](file:///workspace/ruoyi-admin/src/main/java/com/ruoyi/web/controller/system/SysRoleController.java) | `/system/role` | 角色管理 |
| [SysMenuController](file:///workspace/ruoyi-admin/src/main/java/com/ruoyi/web/controller/system/SysMenuController.java) | `/system/menu` | 菜单管理 |
| [SysDeptController](file:///workspace/ruoyi-admin/src/main/java/com/ruoyi/web/controller/system/SysDeptController.java) | `/system/dept` | 部门管理 |
| [SysPostController](file:///workspace/ruoyi-admin/src/main/java/com/ruoyi/web/controller/system/SysPostController.java) | `/system/post` | 岗位管理 |
| [SysDictTypeController](file:///workspace/ruoyi-admin/src/main/java/com/ruoyi/web/controller/system/SysDictTypeController.java) | `/system/dict/type` | 字典类型管理 |
| [SysDictDataController](file:///workspace/ruoyi-admin/src/main/java/com/ruoyi/web/controller/system/SysDictDataController.java) | `/system/dict/data` | 字典数据管理 |
| [SysConfigController](file:///workspace/ruoyi-admin/src/main/java/com/ruoyi/web/controller/system/SysConfigController.java) | `/system/config` | 参数配置管理 |
| [SysNoticeController](file:///workspace/ruoyi-admin/src/main/java/com/ruoyi/web/controller/system/SysNoticeController.java) | `/system/notice` | 通知公告管理 |
| [SysProfileController](file:///workspace/ruoyi-admin/src/main/java/com/ruoyi/web/controller/system/SysProfileController.java) | `/system/user/profile` | 用户个人信息管理 |
| [SysRegisterController](file:///workspace/ruoyi-admin/src/main/java/com/ruoyi/web/controller/system/SysRegisterController.java) | `/register` | 用户注册 |
| [CacheController](file:///workspace/ruoyi-admin/src/main/java/com/ruoyi/web/controller/monitor/CacheController.java) | `/monitor/cache` | 缓存监控 |
| [ServerController](file:///workspace/ruoyi-admin/src/main/java/com/ruoyi/web/controller/monitor/ServerController.java) | `/monitor/server` | 服务器监控 |
| [SysLogininforController](file:///workspace/ruoyi-admin/src/main/java/com/ruoyi/web/controller/monitor/SysLogininforController.java) | `/monitor/logininfor` | 登录日志管理 |
| [SysOperlogController](file:///workspace/ruoyi-admin/src/main/java/com/ruoyi/web/controller/monitor/SysOperlogController.java) | `/monitor/operlog` | 操作日志管理 |
| [SysUserOnlineController](file:///workspace/ruoyi-admin/src/main/java/com/ruoyi/web/controller/monitor/SysUserOnlineController.java) | `/monitor/online` | 在线用户管理 |
| [DruidController](file:///workspace/ruoyi-admin/src/main/java/com/ruoyi/web/controller/monitor/DruidController.java) | `/druid` | 数据库连接池监控 |
| [CommonController](file:///workspace/ruoyi-admin/src/main/java/com/ruoyi/web/controller/common/CommonController.java) | `/common` | 通用请求处理（文件上传下载等） |

**静态资源与模板**:
- `static/` - 前端静态资源（CSS、JS、图片、第三方库如 jQuery/Bootstrap/ECharts/Layer 等）
- `templates/` - Thymeleaf 页面模板（系统页面、Demo 示例等）
- `ruoyi/` - 若依自定义前端组件（[ry-ui.js](file:///workspace/ruoyi-admin/src/main/resources/static/ruoyi/js/ry-ui.js)、[common.js](file:///workspace/ruoyi-admin/src/main/resources/static/ruoyi/js/common.js)）

---

### 2. ruoyi-framework（框架核心模块）

**职责**: 提供框架级基础设施，包括安全认证、数据源管理、AOP 切面、异常处理、拦截器等核心能力。

#### 2.1 配置类 (config)

| 类 | 说明 |
|----|------|
| [ShiroConfig](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/config/ShiroConfig.java) | Shiro 权限框架完整配置（Realm、Session、过滤器链、RememberMe 等） |
| [MyBatisConfig](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/config/MyBatisConfig.java) | MyBatis 配置，包含分页插件、SQL 日志等 |
| [DruidConfig](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/config/DruidConfig.java) | Druid 数据源配置，支持主从动态切换 |
| [CaptchaConfig](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/config/CaptchaConfig.java) | 验证码配置（Kaptcha） |
| [FilterConfig](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/config/FilterConfig.java) | 过滤器配置 |
| [ResourcesConfig](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/config/ResourcesConfig.java) | 静态资源映射配置 |
| [I18nConfig](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/config/I18nConfig.java) | 国际化配置 |
| [ApplicationConfig](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/config/ApplicationConfig.java) | 应用基础配置 |

#### 2.2 AOP 切面 (aspectj)

| 切面类 | 说明 |
|--------|------|
| [DataScopeAspect](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/aspectj/DataScopeAspect.java) | 数据权限过滤切面，根据角色数据权限范围（全部/自定义/本部门/本部门及以下/仅本人）动态拼接 SQL WHERE 条件 |
| [DataSourceAspect](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/aspectj/DataSourceAspect.java) | 多数据源切换切面，通过 `@DataSource` 注解实现主从库切换 |
| [LogAspect](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/aspectj/LogAspect.java) | 操作日志记录切面，拦截 `@Log` 注解方法，异步记录操作日志到数据库 |
| [PermissionsAspect](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/aspectj/PermissionsAspect.java) | 权限校验切面，处理 `@HasPermissions` 注解 |

#### 2.3 Shiro 安全模块 (shiro)

| 类 | 说明 |
|----|------|
| [UserRealm](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/shiro/realm/UserRealm.java) | 自定义 Shiro Realm，处理登录认证和权限授权 |
| [OnlineSessionDAO](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/shiro/session/OnlineSessionDAO.java) | 在线用户 Session DAO，持久化 Session 到数据库 |
| [OnlineSessionFactory](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/shiro/session/OnlineSessionFactory.java) | 在线用户 Session 工厂 |
| [CustomCookieRememberMeManager](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/shiro/rememberMe/CustomCookieRememberMeManager.java) | 自定义 RememberMe Cookie 管理器 |
| [SysLoginService](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/shiro/service/SysLoginService.java) | 登录业务逻辑处理 |
| [SysPasswordService](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/shiro/service/SysPasswordService.java) | 密码服务（加密、重试次数限制等） |
| [SysRegisterService](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/shiro/service/SysRegisterService.java) | 用户注册服务 |
| [SysShiroService](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/shiro/service/SysShiroService.java) | Shiro 相关的系统服务 |

#### 2.4 数据源 (datasource)

| 类 | 说明 |
|----|------|
| [DynamicDataSource](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/datasource/DynamicDataSource.java) | 动态数据源，继承 `AbstractRoutingDataSource`，实现主从读写分离 |

#### 2.5 拦截器 (interceptor)

| 类 | 说明 |
|----|------|
| [RepeatSubmitInterceptor](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/interceptor/RepeatSubmitInterceptor.java) | 防重复提交拦截器 |
| [SameUrlDataInterceptor](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/interceptor/impl/SameUrlDataInterceptor.java) | 相同 URL 数据拦截实现 |

#### 2.6 异步管理 (manager)

| 类 | 说明 |
|----|------|
| [AsyncManager](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/manager/AsyncManager.java) | 异步任务管理器，使用线程池执行异步操作 |
| [AsyncFactory](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/manager/factory/AsyncFactory.java) | 异步任务工厂，创建操作日志记录等异步任务 |
| [ShutdownManager](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/manager/ShutdownManager.java) | 应用关闭管理器，优雅关闭线程池 |

#### 2.7 Web 异常处理

| 类 | 说明 |
|----|------|
| [GlobalExceptionHandler](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/web/exception/GlobalExceptionHandler.java) | 全局异常处理器，统一处理各类异常并返回友好的错误页面或 JSON |

#### 2.8 Web 服务 (web/service)

| 类 | 说明 |
|----|------|
| [PermissionService](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/web/service/PermissionService.java) | 权限判断服务，供模板和代码使用 |
| [CacheService](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/web/service/CacheService.java) | 缓存操作服务 |
| [DictService](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/web/service/DictService.java) | 字典数据查询服务 |
| [ConfigService](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/web/service/ConfigService.java) | 系统参数配置服务 |

---

### 3. ruoyi-system（系统业务模块）

**职责**: 实现系统核心业务功能，包括用户、角色、部门、菜单、字典、日志等的 Service 层和 Mapper 层。

#### 3.1 实体类 (domain)

| 实体类 | 说明 |
|--------|------|
| [SysConfig](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/domain/SysConfig.java) | 系统参数配置 |
| [SysLogininfor](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/domain/SysLogininfor.java) | 登录日志信息 |
| [SysOperLog](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/domain/SysOperLog.java) | 操作日志记录 |
| [SysNotice](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/domain/SysNotice.java) | 通知公告 |
| [SysNoticeRead](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/domain/SysNoticeRead.java) | 通知公告阅读记录 |
| [SysPost](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/domain/SysPost.java) | 岗位信息 |
| [SysRoleDept](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/domain/SysRoleDept.java) | 角色与部门关联 |
| [SysRoleMenu](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/domain/SysRoleMenu.java) | 角色与菜单关联 |
| [SysUserOnline](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/domain/SysUserOnline.java) | 在线用户信息 |
| [SysUserPost](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/domain/SysUserPost.java) | 用户与岗位关联 |
| [SysUserRole](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/domain/SysUserRole.java) | 用户与角色关联 |

> 注: `SysUser`、`SysRole`、`SysDept`、`SysMenu`、`SysDictType`、`SysDictData` 等核心实体定义在 `ruoyi-common` 模块的 `entity` 包中。

#### 3.2 Mapper 层

| Mapper | 说明 |
|--------|------|
| [SysUserMapper](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/mapper/SysUserMapper.java) | 用户表数据访问 |
| [SysRoleMapper](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/mapper/SysRoleMapper.java) | 角色表数据访问 |
| [SysMenuMapper](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/mapper/SysMenuMapper.java) | 菜单表数据访问 |
| [SysDeptMapper](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/mapper/SysDeptMapper.java) | 部门表数据访问 |
| [SysDictTypeMapper](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/mapper/SysDictTypeMapper.java) | 字典类型表数据访问 |
| [SysDictDataMapper](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/mapper/SysDictDataMapper.java) | 字典数据表数据访问 |
| [SysConfigMapper](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/mapper/SysConfigMapper.java) | 参数配置表数据访问 |
| [SysNoticeMapper](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/mapper/SysNoticeMapper.java) | 通知公告表数据访问 |
| [SysPostMapper](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/mapper/SysPostMapper.java) | 岗位表数据访问 |
| [SysLogininforMapper](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/mapper/SysLogininforMapper.java) | 登录日志表数据访问 |
| [SysOperLogMapper](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/mapper/SysOperLogMapper.java) | 操作日志表数据访问 |
| [SysUserOnlineMapper](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/mapper/SysUserOnlineMapper.java) | 在线用户表数据访问 |

#### 3.3 Service 层

| Service | 说明 |
|---------|------|
| [ISysUserService](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/ISysUserService.java) / [Impl](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/impl/SysUserServiceImpl.java) | 用户业务逻辑 |
| [ISysRoleService](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/ISysRoleService.java) / [Impl](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/impl/SysRoleServiceImpl.java) | 角色业务逻辑 |
| [ISysMenuService](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/ISysMenuService.java) / [Impl](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/impl/SysMenuServiceImpl.java) | 菜单业务逻辑 |
| [ISysDeptService](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/ISysDeptService.java) / [Impl](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/impl/SysDeptServiceImpl.java) | 部门业务逻辑 |
| [ISysDictTypeService](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/ISysDictTypeService.java) / [Impl](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/impl/SysDictTypeServiceImpl.java) | 字典类型业务逻辑 |
| [ISysDictDataService](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/ISysDictDataService.java) / [Impl](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/impl/SysDictDataServiceImpl.java) | 字典数据业务逻辑 |
| [ISysConfigService](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/ISysConfigService.java) / [Impl](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/impl/SysConfigServiceImpl.java) | 参数配置业务逻辑 |
| [ISysNoticeService](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/ISysNoticeService.java) / [Impl](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/impl/SysNoticeServiceImpl.java) | 通知公告业务逻辑 |
| [ISysPostService](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/ISysPostService.java) / [Impl](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/impl/SysPostServiceImpl.java) | 岗位业务逻辑 |
| [ISysLogininforService](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/ISysLogininforService.java) / [Impl](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/impl/SysLogininforServiceImpl.java) | 登录日志业务逻辑 |
| [ISysOperLogService](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/ISysOperLogService.java) / [Impl](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/impl/SysOperLogServiceImpl.java) | 操作日志业务逻辑 |
| [ISysUserOnlineService](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/ISysUserOnlineService.java) / [Impl](file:///workspace/ruoyi-system/src/main/java/com/ruoyi/system/service/impl/SysUserOnlineServiceImpl.java) | 在线用户业务逻辑 |

---

### 4. ruoyi-common（通用工具模块）

**职责**: 提供项目通用的工具类、基础领域类、常量、枚举、注解、异常类等基础设施，被所有模块依赖。

#### 4.1 注解 (annotation)

| 注解 | 说明 |
|------|------|
| `@Log` | 操作日志注解，标记需要记录操作日志的方法 |
| `@DataScope` | 数据权限注解，指定数据过滤的部门/用户别名 |
| `@DataSource` | 数据源切换注解，指定使用主库或从库 |
| `@Excel` / `@Excels` | Excel 导入/导出注解 |
| `@RepeatSubmit` | 防重复提交注解 |
| `@Sensitive` | 数据脱敏注解 |
| `@Anonymous` | 匿名访问注解 |

#### 4.2 常量定义 (constant)

| 常量类 | 说明 |
|--------|------|
| [Constants](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/constant/Constants.java) | 系统通用常量（权限标识、数据权限范围等） |
| [UserConstants](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/constant/UserConstants.java) | 用户相关常量（状态值、默认密码等） |
| [PermissionConstants](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/constant/PermissionConstants.java) | 权限常量 |
| [ScheduleConstants](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/constant/ScheduleConstants.java) | 定时任务常量 |
| [ShiroConstants](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/constant/ShiroConstants.java) | Shiro 相关常量 |
| [GenConstants](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/constant/GenConstants.java) | 代码生成常量 |

#### 4.3 核心领域类 (core/domain)

| 类 | 说明 |
|----|------|
| [BaseEntity](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/core/domain/BaseEntity.java) | 实体基类，包含 createBy、createTime、updateBy、updateTime、remark 等公共字段 |
| [AjaxResult](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/core/domain/AjaxResult.java) | 操作消息响应类 |
| [R](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/core/domain/R.java) | 响应结果类 |
| [TreeEntity](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/core/domain/TreeEntity.java) | 树形实体基类 |
| [Ztree](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/core/domain/Ztree.java) | ZTree 树结构实体 |
| [TableDataInfo](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/core/page/TableDataInfo.java) | 表格分页数据对象 |
| [PageDomain](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/core/page/PageDomain.java) | 分页数据 |
| [TableSupport](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/core/page/TableSupport.java) | 表格数据处理 |

#### 4.4 核心实体 (core/domain/entity)

| 实体 | 说明 |
|------|------|
| [SysUser](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/core/domain/entity/SysUser.java) | 用户实体，包含 userId、loginName、password、dept、roles 等 |
| [SysRole](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/core/domain/entity/SysRole.java) | 角色实体 |
| [SysDept](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/core/domain/entity/SysDept.java) | 部门实体（树形结构） |
| [SysMenu](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/core/domain/entity/SysMenu.java) | 菜单/权限实体（树形结构） |
| [SysDictType](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/core/domain/entity/SysDictType.java) | 字典类型实体 |
| [SysDictData](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/core/domain/entity/SysDictData.java) | 字典数据实体 |

#### 4.5 控制器基类 (core/controller)

| 类 | 说明 |
|----|------|
| [BaseController](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/core/controller/BaseController.java) | 所有 Controller 的基类，提供分页、响应封装、用户信息获取等通用方法 |

#### 4.6 枚举 (enums)

| 枚举 | 说明 |
|------|------|
| [BusinessType](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/enums/BusinessType.java) | 业务操作类型（增删改查导入导出等） |
| [BusinessStatus](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/enums/BusinessStatus.java) | 操作状态（成功/失败） |
| [DataSourceType](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/enums/DataSourceType.java) | 数据源类型（MASTER/SLAVE） |
| [OnlineStatus](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/enums/OnlineStatus.java) | 用户在线状态 |
| [OperatorType](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/enums/OperatorType.java) | 操作人类别 |
| [UserStatus](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/enums/UserStatus.java) | 用户状态 |
| [DesensitizedType](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/enums/DesensitizedType.java) | 脱敏类型 |

#### 4.7 异常类 (exception)

| 异常类 | 说明 |
|--------|------|
| [GlobalException](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/exception/GlobalException.java) | 全局异常 |
| [ServiceException](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/exception/ServiceException.java) | 业务异常 |
| [BaseException](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/exception/base/BaseException.java) | 基础异常 |
| `UserNotExistsException` | 用户不存在异常 |
| `UserPasswordNotMatchException` | 密码不匹配异常 |
| `UserPasswordRetryLimitExceedException` | 密码重试次数超限异常 |
| `UserBlockedException` | 用户被锁定异常 |
| `RoleBlockedException` | 角色被锁定异常 |
| `CaptchaException` | 验证码异常 |
| `BlackListException` | 黑名单异常 |
| `FileUploadException` | 文件上传异常 |
| [DemoModeException](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/exception/DemoModeException.java) | 演示模式异常 |

#### 4.8 工具类 (utils)

| 工具类 | 说明 |
|--------|------|
| [StringUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/StringUtils.java) | 字符串处理工具 |
| [DateUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/DateUtils.java) | 日期处理工具 |
| [ServletUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/ServletUtils.java) | Servlet 工具（获取请求参数、响应等） |
| [ShiroUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/ShiroUtils.java) | Shiro 工具（获取当前用户、IP 等） |
| [IpUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/IpUtils.java) | IP 工具 |
| [Md5Utils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/security/Md5Utils.java) | MD5 加密工具 |
| [CipherUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/security/CipherUtils.java) | 加密工具（AES 密钥生成等） |
| [PermissionUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/security/PermissionUtils.java) | 权限工具 |
| [FileUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/file/FileUtils.java) | 文件工具 |
| [FileUploadUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/file/FileUploadUtils.java) | 文件上传工具 |
| [ImageUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/file/ImageUtils.java) | 图片处理工具 |
| [ExcelUtil](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/poi/ExcelUtil.java) | Excel 导入导出工具 |
| [HttpUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/http/HttpUtils.java) | HTTP 请求工具 |
| [SpringUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/spring/SpringUtils.java) | Spring 上下文工具 |
| [BeanUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/bean/BeanUtils.java) | Bean 工具 |
| [UUID](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/uuid/UUID.java) | UUID 生成工具 |
| [IdUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/uuid/IdUtils.java) | ID 生成工具 |
| [Arith](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/Arith.java) | 精确浮点运算工具 |
| [CacheUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/CacheUtils.java) | 缓存工具 |
| [CookieUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/CookieUtils.java) | Cookie 工具 |
| [DictUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/DictUtils.java) | 字典工具 |
| [MessageUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/MessageUtils.java) | 国际化消息工具 |
| [PageUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/PageUtils.java) | 分页工具 |
| [AddressUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/AddressUtils.java) | 地址查询工具 |
| [LogUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/LogUtils.java) | 日志工具 |
| [MapDataUtil](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/MapDataUtil.java) | Map 数据工具 |
| [ExceptionUtil](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/ExceptionUtil.java) | 异常工具 |
| [Threads](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/Threads.java) | 线程工具 |
| [SqlUtil](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/sql/SqlUtil.java) | SQL 防注入工具 |
| [Convert](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/core/text/Convert.java) | 类型转换器 |
| [StrFormatter](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/core/text/StrFormatter.java) | 字符串格式化器 |
| [EscapeUtil](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/html/EscapeUtil.java) | HTML 转义工具 |
| [HTMLFilter](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/html/HTMLFilter.java) | HTML 过滤器（防 XSS） |
| [DesensitizedUtil](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/DesensitizedUtil.java) | 数据脱敏工具 |
| [ReflectUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/reflect/ReflectUtils.java) | 反射工具 |
| [BeanValidators](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/bean/BeanValidators.java) | Bean 验证工具 |
| [UserAgentUtils](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/utils/http/UserAgentUtils.java) | User-Agent 解析工具 |

#### 4.9 XSS 防护 (xss)

| 类 | 说明 |
|----|------|
| [XssFilter](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/xss/XssFilter.java) | XSS 过滤过滤器 |
| [XssHttpServletRequestWrapper](file:///workspace/ruoyi-common/src/main/java/com/ruoyi/common/xss/XssHttpServletRequestWrapper.java) | XSS 请求包装器 |
| `@Xss` | XSS 验证注解 |

---

### 5. ruoyi-quartz（定时任务模块）

**职责**: 基于 Quartz 实现的定时任务调度管理，支持在线 CRUD 操作任务。

#### 5.1 控制器

| Controller | 说明 |
|------------|------|
| [SysJobController](file:///workspace/ruoyi-quartz/src/main/java/com/ruoyi/quartz/controller/SysJobController.java) | 定时任务管理（增删改查、执行一次等） |
| [SysJobLogController](file:///workspace/ruoyi-quartz/src/main/java/com/ruoyi/quartz/controller/SysJobLogController.java) | 定时任务日志管理 |

#### 5.2 领域类

| 类 | 说明 |
|----|------|
| [SysJob](file:///workspace/ruoyi-quartz/src/main/java/com/ruoyi/quartz/domain/SysJob.java) | 定时任务实体 |
| [SysJobLog](file:///workspace/ruoyi-quartz/src/main/java/com/ruoyi/quartz/domain/SysJobLog.java) | 定时任务执行日志实体 |

#### 5.3 任务执行

| 类 | 说明 |
|----|------|
| [AbstractQuartzJob](file:///workspace/ruoyi-quartz/src/main/java/com/ruoyi/quartz/util/AbstractQuartzJob.java) | Quartz 任务抽象基类，处理执行前后逻辑和异常 |
| [QuartzJobExecution](file:///workspace/ruoyi-quartz/src/main/java/com/ruoyi/quartz/util/QuartzJobExecution.java) | 支持并发执行的 Quartz 任务 |
| [QuartzDisallowConcurrentExecution](file:///workspace/ruoyi-quartz/src/main/java/com/ruoyi/quartz/util/QuartzDisallowConcurrentExecution.java) | 禁止并发执行的 Quartz 任务（使用 @DisallowConcurrentExecution） |
| [RyTask](file:///workspace/ruoyi-quartz/src/main/java/com/ruoyi/quartz/task/RyTask.java) | 示例定时任务 |
| [ScheduleUtils](file:///workspace/ruoyi-quartz/src/main/java/com/ruoyi/quartz/util/ScheduleUtils.java) | 调度工具类，创建/更新/删除定时任务 |
| [CronUtils](file:///workspace/ruoyi-quartz/src/main/java/com/ruoyi/quartz/util/CronUtils.java) | Cron 表达式验证工具 |
| [JobInvokeUtil](file:///workspace/ruoyi-quartz/src/main/java/com/ruoyi/quartz/util/JobInvokeUtil.java) | 任务执行工具，通过反射调用目标方法 |

#### 5.4 配置

| 类 | 说明 |
|----|------|
| [ScheduleConfig](file:///workspace/ruoyi-quartz/src/main/java/com/ruoyi/quartz/config/ScheduleConfig.java) | Quartz 调度器配置 |

---

### 6. ruoyi-generator（代码生成模块）

**职责**: 基于数据库表结构，自动生成前后端 CRUD 代码（Controller、Service、Mapper、Domain、HTML 页面、SQL 脚本）。

#### 6.1 控制器

| Controller | 说明 |
|------------|------|
| [GenController](file:///workspace/ruoyi-generator/src/main/java/com/ruoyi/generator/controller/GenController.java) | 代码生成操作（导入表、编辑、预览、生成、下载等） |

#### 6.2 领域类

| 类 | 说明 |
|----|------|
| [GenTable](file:///workspace/ruoyi-generator/src/main/java/com/ruoyi/generator/domain/GenTable.java) | 代码生成业务表实体 |
| [GenTableColumn](file:///workspace/ruoyi-generator/src/main/java/com/ruoyi/generator/domain/GenTableColumn.java) | 代码生成业务表字段实体 |

#### 6.3 Service 层

| Service | 说明 |
|---------|------|
| [IGenTableService](file:///workspace/ruoyi-generator/src/main/java/com/ruoyi/generator/service/IGenTableService.java) / [Impl](file:///workspace/ruoyi-generator/src/main/java/com/ruoyi/generator/service/impl/GenTableServiceImpl.java) | 代码生成表业务逻辑 |
| [IGenTableColumnService](file:///workspace/ruoyi-generator/src/main/java/com/ruoyi/generator/service/IGenTableColumnService.java) / [Impl](file:///workspace/ruoyi-generator/src/main/java/com/ruoyi/generator/service/impl/GenTableColumnServiceImpl.java) | 代码生成表字段业务逻辑 |

#### 6.4 工具类

| 类 | 说明 |
|----|------|
| [GenUtils](file:///workspace/ruoyi-generator/src/main/java/com/ruoyi/generator/util/GenUtils.java) | 代码生成工具，初始化表/字段默认属性 |
| [VelocityUtils](file:///workspace/ruoyi-generator/src/main/java/com/ruoyi/generator/util/VelocityUtils.java) | Velocity 模板工具，准备模板渲染数据 |
| [VelocityInitializer](file:///workspace/ruoyi-generator/src/main/java/com/ruoyi/generator/util/VelocityInitializer.java) | Velocity 引擎初始化配置 |

#### 6.5 模板文件

| 模板类型 | 路径 |
|----------|------|
| Controller 模板 | [vm/java/controller.java.vm](file:///workspace/ruoyi-generator/src/main/resources/vm/java/controller.java.vm) |
| Domain 实体模板 | [vm/java/domain.java.vm](file:///workspace/ruoyi-generator/src/main/resources/vm/java/domain.java.vm) |
| Mapper 接口模板 | [vm/java/mapper.java.vm](file:///workspace/ruoyi-generator/src/main/resources/vm/java/mapper.java.vm) |
| Service 接口模板 | [vm/java/service.java.vm](file:///workspace/ruoyi-generator/src/main/resources/vm/java/service.java.vm) |
| ServiceImpl 模板 | [vm/java/serviceImpl.java.vm](file:///workspace/ruoyi-generator/src/main/resources/vm/java/serviceImpl.java.vm) |
| 列表页面模板 | [vm/html/list.html.vm](file:///workspace/ruoyi-generator/src/main/resources/vm/html/list.html.vm) |
| 新增页面模板 | [vm/html/add.html.vm](file:///workspace/ruoyi-generator/src/main/resources/vm/html/add.html.vm) |
| 编辑页面模板 | [vm/html/edit.html.vm](file:///workspace/ruoyi-generator/src/main/resources/vm/html/edit.html.vm) |
| 树表列表模板 | [vm/html/list-tree.html.vm](file:///workspace/ruoyi-generator/src/main/resources/vm/html/list-tree.html.vm) |
| SQL 脚本模板 | [vm/sql/sql.vm](file:///workspace/ruoyi-generator/src/main/resources/vm/sql/sql.vm) |

---

## 核心架构设计

### 整体架构图

```
┌─────────────────────────────────────────────────────────┐
│                     ruoyi-admin                          │
│  ┌─────────────┐  ┌─────────────┐  ┌─────────────────┐  │
│  │ Controller  │  │   静态资源   │  │  Thymeleaf模板   │  │
│  └──────┬──────┘  └─────────────┘  └────────┬────────┘  │
│         │                                    │           │
│         └────────────┬───────────────────────┘           │
│                      │                                   │
└──────────────────────┼───────────────────────────────────┘
                       │
┌──────────────────────┼───────────────────────────────────┐
│                 ruoyi-framework                          │
│  ┌──────────┐  ┌──────────┐  ┌──────────┐  ┌──────────┐ │
│  │ShiroConfig│  │AOP切面  │  │ 数据源   │  │ 异常处理  │ │
│  └──────────┘  └──────────┘  └──────────┘  └──────────┘ │
│  ┌──────────┐  ┌──────────┐  ┌──────────┐  ┌──────────┐ │
│  │ UserRealm │  │ Session  │  │ 拦截器   │  │ 异步管理  │ │
│  └──────────┘  └──────────┘  └──────────┘  └──────────┘ │
└──────────────────────┬───────────────────────────────────┘
                       │
        ┌──────────────┼──────────────┐
        │              │              │
┌───────▼───────┐┌─────▼──────┐┌─────▼─────────────┐
│ ruoyi-system  ││ruoyi-quartz││ruoyi-generator    │
│  系统业务模块  ││ 定时任务    ││ 代码生成模块       │
│  User/Role/   ││ Job调度    ││ 模板引擎Velocity   │
│  Menu/Dept... ││ 任务日志    ││ CRUD代码生成       │
└───────┬───────┘└─────┬──────┘└─────┬─────────────┘
        │              │              │
        └──────────────┼──────────────┘
                       │
┌──────────────────────┼───────────────────────────────────┐
│                  ruoyi-common                             │
│  ┌──────────┐  ┌──────────┐  ┌──────────┐  ┌──────────┐ │
│  │ 工具类    │  │ 实体基类  │  │ 常量枚举  │  │ 异常体系  │ │
│  └──────────┘  └──────────┘  └──────────┘  └──────────┘ │
│  ┌──────────┐  ┌──────────┐  ┌──────────┐  ┌──────────┐ │
│  │ 自定义注解│  │ XSS过滤  │  │ Excel工具 │  │ 分页组件  │ │
│  └──────────┘  └──────────┘  └──────────┘  └──────────┘ │
└──────────────────────┬───────────────────────────────────┘
                       │
┌──────────────────────▼───────────────────────────────────┐
│                    MySQL 数据库                           │
└──────────────────────────────────────────────────────────┘
```

### 模块依赖关系

```
ruoyi-admin
    ├── ruoyi-framework
    │       ├── ruoyi-system
    │       │       └── ruoyi-common
    │       └── ruoyi-common
    ├── ruoyi-quartz
    │       └── ruoyi-common
    └── ruoyi-generator
            └── ruoyi-common
```

### 认证与授权流程

```
用户请求
   │
   ▼
┌──────────────────────────────────────────────┐
│            Shiro Filter Chain                │
│  静态资源 → anon (匿名访问)                    │
│  /login   → anon,captchaValidate             │
│  /logout  → logout                           │
│  /**      → user,kickout,onlineSession,      │
│             syncOnlineSession,csrfValidate    │
└──────────────────┬───────────────────────────┘
                   │
          ┌────────▼────────┐
          │  CaptchaFilter  │ 验证码校验
          └────────┬────────┘
                   │
          ┌────────▼────────┐
          │  UserRealm      │
          │  Authentication │ 身份认证
          │  Authorization  │ 权限授权
          └────────┬────────┘
                   │
          ┌────────▼────────┐
          │  DataScopeAspect│ 数据权限过滤
          └────────┬────────┘
                   │
          ┌────────▼────────┐
          │  LogAspect      │ 操作日志记录
          └────────┬────────┘
                   │
          ┌────────▼────────┐
          │  Controller     │ 业务处理
          └─────────────────┘
```

### 数据权限模型

系统通过 `@DataScope` 注解 + [DataScopeAspect](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/aspectj/DataScopeAspect.java) 实现灵活的数据权限控制，支持五种数据范围：

| 数据范围 | 常量 | 说明 |
|----------|------|------|
| 全部数据权限 | `DATA_SCOPE_ALL` | 不添加任何过滤条件 |
| 自定义数据权限 | `DATA_SCOPE_CUSTOM` | 根据角色关联的部门进行过滤 |
| 本部门数据权限 | `DATA_SCOPE_DEPT` | 仅本部门数据 |
| 本部门及以下数据权限 | `DATA_SCOPE_DEPT_AND_CHILD` | 本部门及子部门数据 |
| 仅本人数据权限 | `DATA_SCOPE_SELF` | 仅本人创建的数据 |

### 多数据源切换

通过 `@DataSource` 注解 + [DataSourceAspect](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/aspectj/DataSourceAspect.java) + [DynamicDataSource](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/datasource/DynamicDataSource.java) 实现主从读写分离：

```java
// 使用主库（默认）
// 使用从库
@DataSource(DataSourceType.SLAVE)
public List<SysUser> selectUserList(SysUser user) { ... }
```

---

## 技术栈详情

### 后端技术

| 技术 | 版本 | 用途 |
|------|------|------|
| Spring Boot | 4.0.3 | 核心框架 |
| Shiro | 2.1.0 | 安全认证与授权框架 |
| MyBatis + mybatis-spring-boot | 4.0.1 | ORM 框架 |
| PageHelper | 2.1.1 | 分页插件 |
| Druid | 1.2.28 | 数据库连接池（支持监控） |
| Thymeleaf | (Spring Boot 管理) | 服务端模板引擎 |
| Quartz | (Spring Boot 管理) | 定时任务调度 |
| Velocity | 2.3 | 代码生成模板引擎 |
| EhCache | (Shiro 管理) | 缓存框架 |
| Kaptcha | 2.3.3 | 验证码生成 |
| Apache POI | 4.1.2 | Excel 处理 |
| FastJSON | 1.2.83 | JSON 序列化 |
| SpringDoc | 3.0.2 | API 文档生成（Swagger） |
| Oshi | 6.10.0 | 系统信息获取 |
| Yauaa | 8.1.0 | User-Agent 解析 |
| MySQL Connector | (Spring Boot 管理) | MySQL 驱动 |

### 前端技术

| 技术 | 用途 |
|------|------|
| H+ (Hplus) UI | 后台主题框架 |
| jQuery | JavaScript 库 |
| Bootstrap | CSS 框架 |
| Layer | 弹出层组件 |
| Bootstrap Table | 数据表格组件 |
| ECharts | 数据可视化图表 |
| ZTree | 树形组件 |
| Select2 | 增强下拉框 |
| Summernote | 富文本编辑器 |
| jQuery Validate | 表单验证 |
| Cropper | 图片裁剪 |

---

## 内置功能清单

| 序号 | 功能模块 | 说明 |
|------|----------|------|
| 1 | 用户管理 | 系统用户的增删改查、密码重置、状态控制、角色分配 |
| 2 | 部门管理 | 组织架构管理，树形展示，支持数据权限 |
| 3 | 岗位管理 | 用户职务配置 |
| 4 | 菜单管理 | 系统菜单/按钮配置，权限标识管理 |
| 5 | 角色管理 | 角色创建、菜单权限分配、数据权限范围设置 |
| 6 | 字典管理 | 系统固定数据字典维护（类型+数据） |
| 7 | 参数管理 | 系统动态参数配置 |
| 8 | 通知公告 | 系统公告发布、阅读状态追踪 |
| 9 | 操作日志 | 正常操作和异常操作记录，支持详情查看 |
| 10 | 登录日志 | 登录成功/失败记录，含登录异常信息 |
| 11 | 在线用户 | 当前活跃用户监控，支持强制下线 |
| 12 | 定时任务 | 在线管理定时任务，含执行日志 |
| 13 | 代码生成 | 根据数据库表生成前后端 CRUD 代码 |
| 14 | 系统接口 | SpringDoc 自动生成的 API 文档 |
| 15 | 服务监控 | CPU、内存、磁盘、JVM 等系统信息 |
| 16 | 缓存监控 | EhCache 缓存查看与操作 |
| 17 | 在线构建器 | 在线表单拖拽构建 HTML |
| 18 | 连接池监控 | Druid 数据库连接池监控与 SQL 分析 |

---

## 数据库设计

### 核心表结构

| 表名 | 说明 |
|------|------|
| sys_user | 用户表 |
| sys_role | 角色表 |
| sys_menu | 菜单权限表 |
| sys_dept | 部门表 |
| sys_post | 岗位表 |
| sys_dict_type | 字典类型表 |
| sys_dict_data | 字典数据表 |
| sys_config | 参数配置表 |
| sys_notice | 通知公告表 |
| sys_notice_read | 公告阅读记录表 |
| sys_user_role | 用户角色关联表 |
| sys_role_menu | 角色菜单关联表 |
| sys_role_dept | 角色部门关联表 |
| sys_user_post | 用户岗位关联表 |
| sys_oper_log | 操作日志表 |
| sys_logininfor | 登录日志表 |
| sys_user_online | 在线用户表 |
| sys_job | 定时任务表 |
| sys_job_log | 定时任务日志表 |
| gen_table | 代码生成业务表 |
| gen_table_column | 代码生成业务字段表 |

---

## 项目运行方式

### 环境要求

| 环境 | 版本要求 |
|------|----------|
| JDK | 17+ |
| Maven | 3.6+ |
| MySQL | 5.7+ / 8.0+ |

### 启动步骤

**1. 创建数据库并导入 SQL**

```bash
# 创建数据库
mysql -u root -p
CREATE DATABASE ry DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

# 导入初始化SQL（SQL文件通常在项目的 sql 目录下或文档中提供）
use ry;
source /path/to/ruoyi.sql;
```

**2. 修改数据库配置**

编辑 [application-druid.yml](file:///workspace/ruoyi-admin/src/main/resources/application-druid.yml)：

```yaml
spring:
    datasource:
        druid:
            master:
                url: jdbc:mysql://localhost:3306/ry?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
                username: root        # 修改为你的数据库用户名
                password: password    # 修改为你的数据库密码
```

**3. 编译构建**

```bash
cd /workspace
mvn clean package -DskipTests
```

**4. 启动应用**

方式一 - Maven 启动：
```bash
mvn spring-boot:run -pl ruoyi-admin
```

方式二 - 直接运行 JAR：
```bash
java -jar ruoyi-admin/target/ruoyi-admin.jar
```

方式三 - 使用项目提供的脚本：
```bash
# Windows
bin/run.bat

# 清理
bin/clean.bat

# 打包
bin/package.bat
```

**5. 访问系统**

- 默认端口: `80`（可在 [application.yml](file:///workspace/ruoyi-admin/src/main/resources/application.yml) 中修改）
- 访问地址: `http://localhost`
- 默认管理员账号: `admin` / `admin123`

### Druid 数据库监控

- 访问地址: `http://localhost/druid`
- 用户名: `ruoyi`
- 密码: `123456`

（用户名密码可在 [application-druid.yml](file:///workspace/ruoyi-admin/src/main/resources/application-druid.yml) 中配置）

### Swagger API 文档

- 访问地址: `http://localhost/swagger-ui.html`

---

## 关键设计模式与特性

### 1. 异步任务管理

[AsyncManager](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/manager/AsyncManager.java) 使用单例模式 + 线程池实现异步任务执行，主要用于异步记录操作日志，避免阻塞主业务流程。

### 2. AOP 切面编程

系统大量使用 AOP 实现横切关注点：
- 操作日志记录（`@Log`）
- 数据权限过滤（`@DataScope`）
- 数据源切换（`@DataSource`）
- 权限校验（`@HasPermissions`）

### 3. 模板方法模式

Quartz 定时任务使用 [AbstractQuartzJob](file:///workspace/ruoyi-quartz/src/main/java/com/ruoyi/quartz/util/AbstractQuartzJob.java) 定义模板方法，子类实现具体执行逻辑。

### 4. 策略模式

数据权限过滤根据不同的角色数据范围策略，动态生成不同的 SQL 条件。

### 5. 工厂模式

[AsyncFactory](file:///workspace/ruoyi-framework/src/main/java/com/ruoyi/framework/manager/factory/AsyncFactory.java) 负责创建各种异步任务。

---

## 配置说明

### 主要配置项

| 配置项 | 默认值 | 说明 |
|--------|--------|------|
| `ruoyi.version` | 4.8.3 | 系统版本 |
| `ruoyi.demoEnabled` | true | 是否开启演示模式 |
| `ruoyi.profile` | D:/ruoyi/uploadPath | 文件上传路径 |
| `server.port` | 80 | 服务端口 |
| `user.password.maxRetryCount` | 5 | 密码错误锁定阈值 |
| `shiro.session.expireTime` | 30 | Session 超时时间（分钟） |
| `shiro.user.captchaEnabled` | true | 是否启用验证码 |
| `shiro.user.captchaType` | math | 验证码类型（math=数学计算，char=字符） |
| `shiro.rememberMe.enabled` | true | 是否启用记住我 |
| `xss.enabled` | true | 是否启用 XSS 防护 |
| `csrf.enabled` | false | 是否启用 CSRF 防护 |

---

## 扩展开发指南

### 添加新业务模块

1. 在项目中创建新模块目录（如 `ruoyi-business/`）
2. 创建 `pom.xml`，继承父 POM
3. 在父 POM 的 `<modules>` 中添加新模块
4. 在 `ruoyi-admin/pom.xml` 中添加依赖

### 开发新业务功能的典型流程

1. 创建数据库表
2. 在代码生成模块中导入表
3. 编辑生成配置（包名、模块名、字段类型映射等）
4. 生成代码并下载
5. 将生成的代码复制到对应模块目录
6. 在菜单管理中添加菜单权限
7. 分配角色权限

### 自定义注解使用

```java
// 记录操作日志
@Log(title = "用户管理", businessType = BusinessType.INSERT)
@PostMapping("/add")
public AjaxResult add(@Validated SysUser user) { ... }

// 切换数据源
@DataSource(DataSourceType.SLAVE)
public List<SysUser> selectList(SysUser user) { ... }

// 数据权限过滤
@DataScope(deptAlias = "d", userAlias = "u")
public List<SysUser> selectUserList(SysUser user) { ... }

// 防止重复提交
@RepeatSubmit(interval = 3000)
@PostMapping("/submit")
public AjaxResult submit() { ... }
```
