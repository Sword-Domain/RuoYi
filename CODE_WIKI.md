# RuoYi 项目 Code Wiki

## 1. 项目概述

### 1.1 基本信息

| 属性 | 值 |
|------|-----|
| 项目名称 | RuoYi（若依） |
| 版本 | v4.8.3 |
| 框架类型 | Java 轻量级快速开发框架 |
| 基础框架 | Spring Boot 4.0.3 |
| JDK 版本 | JDK 17+ |
| 构建工具 | Maven |
| 数据库 | MySQL |
| 作者 | ruoyi |

### 1.2 项目简介

RuoYi 是一套基于 Spring Boot 开发的企业级后台管理系统。它提供了一套完整的快速开发平台，可用于网站管理后台、网站会员中心、CMS、CRM、OA 等应用场景。系统采用传统的单体架构设计（非前后端分离），前端使用 Thymeleaf 模板引擎结合 Bootstrap UI 框架，后端采用 Spring Boot + MyBatis + Shiro 的技术组合。

### 1.3 内置功能

1. **用户管理** - 系统用户配置与权限分配
2. **部门管理** - 组织机构配置，树形结构展现，支持数据权限
3. **岗位管理** - 系统用户职务配置
4. **菜单管理** - 系统菜单、操作权限、按钮权限标识配置
5. **角色管理** - 角色菜单权限分配、数据范围权限划分
6. **字典管理** - 系统固定数据维护
7. **参数管理** - 系统动态常用参数配置
8. **通知公告** - 系统公告信息发布维护
9. **操作日志** - 系统正常操作日志与异常信息日志记录
10. **登录日志** - 系统登录日志记录（含登录异常）
11. **在线用户** - 活跃用户状态监控
12. **定时任务** - 在线任务调度（含执行结果日志）
13. **代码生成** - 前后端代码自动生成（Java、HTML、XML、SQL）
14. **系统接口** - 自动生成 API 接口文档
15. **服务监控** - CPU、内存、磁盘、堆栈等信息监控
16. **缓存监控** - 缓存查询、删除、清空操作
17. **在线构建器** - 拖动表单元素生成 HTML 代码
18. **连接池监控** - 数据库连接池状态监控与 SQL 分析

---

## 2. 技术栈

### 2.1 后端核心技术

| 技术 | 版本 | 用途 |
|------|------|------|
| Spring Boot | 4.0.3 | 核心应用框架 |
| Shiro | 2.1.0 | 安全认证与权限控制 |
| MyBatis | 4.0.1 (starter) | 数据持久层框架 |
| Druid | 1.2.28 | 数据库连接池 |
| PageHelper | 2.1.1 | 分页插件 |
| Thymeleaf | (内置) | 服务端模板引擎 |
| EhCache | (Shiro集成) | 缓存框架 |
| SpringDoc | 3.0.2 | API 文档生成 |
| FastJSON | 1.2.83 | JSON 序列化 |
| Apache POI | 4.1.2 | Excel 导入导出 |
| Velocity | 2.3 | 代码生成模板引擎 |
| Oshi | 6.10.0 | 系统信息获取 |
| Kaptcha | 2.3.3 | 验证码生成 |
| YAUAA | 8.1.0 | 客户端浏览器/OS解析 |

### 2.2 前端技术

| 技术 | 用途 |
|------|------|
| Bootstrap | CSS 框架 |
| jQuery | JavaScript 库 |
| Thymeleaf | 服务端渲染模板 |
| Bootstrap Table | 表格组件 |
| ECharts | 图表库 |
| Layer | 弹层组件 |
| Summernote | 富文本编辑器 |
| ZTree | 树形组件 |
| Hplus (H+) | 后台主题 UI 框架 |
| Font Awesome | 图标库 |

---

## 3. 项目架构

### 3.1 整体架构图

```
┌─────────────────────────────────────────────────────────────────┐
│                        ruoyi-admin (Web 层)                      │
│  ┌─────────────┐  ┌──────────────┐  ┌──────────────────────────┐ │
│  │ Controllers │  │ Static Files │  │ Thymeleaf Templates      │ │
│  │ (控制器层)    │  │ (静态资源)    │  │ (页面模板)                │ │
│  └──────┬──────┘  └──────────────┘  └──────────────────────────┘ │
│         │                                                         │
└─────────┼─────────────────────────────────────────────────────────┘
          │
┌─────────┼─────────────────────────────────────────────────────────┐
│         │                                                         │
│  ruoyi-framework (框架层)                                         │
│  ┌──────────────┐  ┌─────────────┐  ┌─────────────────────────┐  │
│  │ Shiro Config │  │  AOP Aspects │  │ MyBatis/Druid Config   │  │
│  │ (安全配置)     │  │ (切面处理)    │  │ (数据源配置)             │  │
│  └──────┬───────┘  └──────┬──────┘  └───────────┬─────────────┘  │
│         │                 │                      │                 │
└─────────┼─────────────────┼──────────────────────┼─────────────────┘
          │                 │                      │
┌─────────┼─────────────────┼──────────────────────┼─────────────────┐
│         │                 │                      │                 │
│  ruoyi-system (业务模块)   │                      │                 │
│  ┌──────────────┐  ┌──────┴──────┐  ┌───────────┴─────────────┐   │
│  │ Services     │  │  Mappers    │  │  Domains (Entities)      │   │
│  │ (业务逻辑)    │  │ (数据访问)   │  │  (领域实体)              │   │
│  └──────────────┘  └─────────────┘  └─────────────────────────┘   │
│                                                                     │
│  ruoyi-quartz (定时任务模块)                                        │
│  ┌──────────────┐  ┌─────────────┐  ┌─────────────────────────┐   │
│  │ Job Services │  │ Job Tasks   │  │  Quartz Config           │   │
│  └──────────────┘  └─────────────┘  └─────────────────────────┘   │
│                                                                     │
│  ruoyi-generator (代码生成模块)                                     │
│  ┌──────────────┐  ┌─────────────┐  ┌─────────────────────────┐   │
│  │ Gen Services │  │ Gen Domain  │  │  Velocity Templates      │   │
│  └──────────────┘  └─────────────┘  └─────────────────────────┘   │
│                                                                     │
└─────────────────────────────┬───────────────────────────────────────┘
                              │
┌─────────────────────────────┼───────────────────────────────────────┐
│                             │                                       │
│  ruoyi-common (通用工具层)                                           │
│  ┌──────────┐  ┌───────────┐  ┌──────────┐  ┌────────────────────┐  │
│  │ Utils    │  │ Constants │  │  Domain  │  │ Annotations        │  │
│  │ (工具类)  │  │ (常量)     │  │ (基础实体) │  │ (自定义注解)        │  │
│  └──────────┘  └───────────┘  └──────────┘  └────────────────────┘  │
│  ┌──────────┐  ┌───────────┐  ┌──────────┐  ┌────────────────────┐  │
│  │ Enums    │  │ Exceptions│  │  Config  │  │ Xss/Security       │  │
│  │ (枚举)    │  │ (异常体系)  │  │ (配置)    │  │ (安全过滤)           │  │
│  └──────────┘  └───────────┘  └──────────┘  └────────────────────┘  │
│                                                                     │
└─────────────────────────────┬───────────────────────────────────────┘
                              │
┌─────────────────────────────┼───────────────────────────────────────┐
│                       MySQL Database                                │
└─────────────────────────────────────────────────────────────────────┘
```

### 3.2 架构模式

项目采用经典的分层架构：

```
┌─────────────────────────────────────────────────────────────────┐
│  表现层 (Presentation Layer)                                    │
│  ├── Controllers (ruoyi-admin)                                  │
│  ├── Thymeleaf Views (模板页面)                                  │
│  └── Static Resources (JS/CSS/图片)                             │
├─────────────────────────────────────────────────────────────────┤
│  业务层 (Business Layer)                                        │
│  ├── Services (业务逻辑)                                        │
│  ├── AOP Aspects (切面: 日志/数据权限/数据源)                     │
│  └── Shiro Filters (安全过滤链)                                 │
├─────────────────────────────────────────────────────────────────┤
│  持久层 (Persistence Layer)                                     │
│  ├── MyBatis Mappers (Mapper 接口)                              │
│  ├── Mapper XML (SQL 映射文件)                                  │
│  └── Domain Entities (实体类)                                   │
├─────────────────────────────────────────────────────────────────┤
│  通用层 (Common Layer)                                          │
│  ├── Utils (工具类)                                             │
│  ├── Constants (常量定义)                                       │
│  ├── Enums (枚举类型)                                           │
│  ├── Exceptions (异常类)                                        │
│  └── Annotations (自定义注解)                                   │
└─────────────────────────────────────────────────────────────────┘
```

### 3.3 模块依赖关系

```
                    ruoyi-admin (启动模块)
                   /      |       |      \
                  /       |       |       \
    ruoyi-framework  ruoyi-system  ruoyi-quartz  ruoyi-generator
          |              |           |              |
          └──────────────┴───────────┴──────────────┘
                             |
                        ruoyi-common (基础依赖)
```

**依赖说明：**

- **ruoyi-common**：最底层模块，不依赖其他任何模块，提供所有公共基础能力
- **ruoyi-framework**：依赖 ruoyi-common，提供框架配置（Shiro、MyBatis、AOP切面等）
- **ruoyi-system**：依赖 ruoyi-common，提供系统核心业务逻辑（用户、角色、权限等）
- **ruoyi-quartz**：依赖 ruoyi-common，提供定时任务功能
- **ruoyi-generator**：依赖 ruoyi-common，提供代码生成功能
- **ruoyi-admin**：聚合所有模块，是应用的入口模块

---

## 4. 模块详解

### 4.1 ruoyi-admin（主模块/入口模块）

**职责**：作为应用的启动模块，包含控制器、静态资源、模板页面和启动配置。

**目录结构**：

```
ruoyi-admin/
├── src/main/java/com/ruoyi/
│   ├── RuoYiApplication.java                    # Spring Boot 启动类
│   ├── RuoYiServletInitializer.java             # 传统部署入口
│   └── web/
│       ├── controller/
│       │   ├── common/                          # 通用控制器
│       │   │   └── CommonController.java        # 文件上传/下载等通用操作
│       │   ├── monitor/                         # 系统监控控制器
│       │   │   ├── CacheController.java         # 缓存监控
│       │   │   ├── DruidController.java         # 连接池监控
│       │   │   ├── ServerController.java        # 服务器信息监控
│       │   │   ├── SysLogininforController.java # 登录日志
│       │   │   ├── SysOperlogController.java    # 操作日志
│       │   │   └── SysUserOnlineController.java # 在线用户
│       │   ├── system/                          # 系统管理控制器
│       │   │   ├── SysCaptchaController.java    # 验证码
│       │   │   ├── SysConfigController.java     # 参数配置
│       │   │   ├── SysDeptController.java       # 部门管理
│       │   │   ├── SysDictDataController.java   # 字典数据
│       │   │   ├── SysDictTypeController.java   # 字典类型
│       │   │   ├── SysIndexController.java      # 首页
│       │   │   ├── SysLoginController.java      # 登录
│       │   │   ├── SysMenuController.java       # 菜单管理
│       │   │   ├── SysNoticeController.java     # 通知公告
│       │   │   ├── SysPostController.java       # 岗位管理
│       │   │   ├── SysProfileController.java    # 个人中心
│       │   │   ├── SysRegisterController.java   # 注册
│       │   │   ├── SysRoleController.java       # 角色管理
│       │   │   └── SysUserController.java       # 用户管理
│       │   └── tool/                            # 工具控制器
│       │       ├── BuildController.java         # 在线构建器
│       │       ├── SwaggerController.java       # 接口文档
│       │       └── TestController.java          # 测试控制器
│       └── core/config/
│           └── SwaggerConfig.java               # Swagger/OpenAPI 配置
└── src/main/resources/
    ├── application.yml                          # 主配置文件
    ├── application-druid.yml                    # Druid 数据源配置
    ├── logback.xml                              # 日志配置
    ├── banner.txt                               # 启动 Banner
    ├── mybatis/mybatis-config.xml               # MyBatis 全局配置
    ├── ehcache/ehcache-shiro.xml                # Shiro 缓存配置
    ├── static/                                  # 静态资源
    │   ├── ajax/libs/                           # 第三方 JS 库
    │   ├── css/                                 # 样式文件
    │   ├── js/                                  # JavaScript 文件
    │   ├── ruoyi/                               # 若依自定义 JS
    │   └── img/                                 # 图片资源
    └── templates/                               # Thymeleaf 模板
        ├── demo/                                # 示例页面
        ├── error/                               # 错误页面
        ├── monitor/                             # 监控页面
        ├── system/                              # 系统管理页面
        ├── tool/                                # 工具页面
        └── index.html, login.html, etc.         # 主页面
```

**关键类说明**：

| 类名 | 路径 | 说明 |
|------|------|------|
| `RuoYiApplication` | `com.ruoyi` | Spring Boot 启动入口，使用 `@SpringBootApplication` 注解，排除默认的 `DataSourceAutoConfiguration` 以使用自定义 Druid 数据源 |
| `RuoYiServletInitializer` | `com.ruoyi` | 继承 `SpringBootServletInitializer`，支持传统 WAR 部署 |
| `SwaggerConfig` | `com.ruoyi.web.core.config` | 配置 SpringDoc OpenAPI 接口文档，支持 API Key 认证 |

**核心 Controller 说明**：

| 控制器 | 路径前缀 | 功能描述 |
|--------|----------|----------|
| `SysLoginController` | `/` | 登录处理、验证码生成 |
| `SysUserController` | `/system/user` | 用户 CRUD、导入导出、密码重置 |
| `SysRoleController` | `/system/role` | 角色 CRUD、权限分配、数据权限 |
| `SysMenuController` | `/system/menu` | 菜单树形管理 |
| `SysDeptController` | `/system/dept` | 部门树形管理 |
| `SysDictDataController` | `/system/dict/data` | 字典数据管理 |
| `SysDictTypeController` | `/system/dict/type` | 字典类型管理 |
| `SysConfigController` | `/system/config` | 系统参数配置 |
| `SysNoticeController` | `/system/notice` | 通知公告管理 |
| `SysPostController` | `/system/post` | 岗位管理 |
| `SysProfileController` | `/system/user/profile` | 个人信息、密码修改、头像上传 |
| `CacheController` | `/monitor/cache` | 缓存查看与操作 |
| `ServerController` | `/monitor/server` | 服务器运行状态监控 |
| `DruidController` | `/druid` | Druid 连接池监控页面 |

### 4.2 ruoyi-common（通用工具模块）

**职责**：提供公共基础能力，包括工具类、常量定义、基础实体类、自定义注解、异常体系、枚举类型、XSS 防护等。

**目录结构**：

```
ruoyi-common/src/main/java/com/ruoyi/common/
├── annotation/                                # 自定义注解
│   ├── Anonymous.java                         # 匿名访问注解
│   ├── DataScope.java                         # 数据权限注解
│   ├── DataSource.java                        # 数据源切换注解
│   ├── Excel.java                             # Excel 导出列注解
│   ├── Excels.java                            # Excel 多列注解
│   ├── Log.java                               # 操作日志注解
│   ├── RepeatSubmit.java                      # 防重复提交注解
│   └── Sensitive.java                         # 数据脱敏注解
├── config/                                    # 配置类
│   ├── datasource/
│   │   └── DynamicDataSourceContextHolder.java # 动态数据源上下文
│   ├── serializer/
│   │   └── SensitiveJsonSerializer.java        # 敏感数据序列化器
│   ├── thread/
│   │   └── ThreadPoolConfig.java               # 线程池配置
│   ├── RuoYiConfig.java                        # 若依全局配置
│   └── ServerConfig.java                       # 服务器URL配置
├── constant/                                  # 常量定义
│   ├── Constants.java                          # 通用常量
│   ├── GenConstants.java                       # 代码生成常量
│   ├── PermissionConstants.java                # 权限常量
│   ├── ScheduleConstants.java                  # 定时任务常量
│   ├── ShiroConstants.java                     # Shiro 常量
│   └── UserConstants.java                      # 用户常量
├── core/                                      # 核心领域
│   ├── context/
│   │   └── PermissionContextHolder.java        # 权限上下文持有者
│   ├── controller/
│   │   └── BaseController.java                 # 控制器基类
│   ├── domain/                                 # 基础领域类
│   │   ├── AjaxResult.java                     # 统一响应结果
│   │   ├── BaseEntity.java                     # 实体基类
│   │   ├── CxSelect.java                       # 级联选择数据
│   │   ├── R.java                              # 简化响应结果
│   │   ├── TreeEntity.java                     # 树形实体基类
│   │   └── Ztree.java                          # ZTree 节点数据
│   ├── entity/                                 # 核心实体
│   │   ├── SysDept.java                        # 部门实体
│   │   ├── SysDictData.java                    # 字典数据实体
│   │   ├── SysDictType.java                    # 字典类型实体
│   │   ├── SysMenu.java                        # 菜单实体
│   │   ├── SysRole.java                        # 角色实体
│   │   └── SysUser.java                        # 用户实体
│   ├── page/                                   # 分页
│   │   ├── PageDomain.java                     # 分页请求参数
│   │   ├── TableDataInfo.java                  # 表格分页响应
│   │   └── TableSupport.java                   # 分页支持类
│   ├── session/
│   │   └── OnlineSession.java                  # 在线会话实体
│   └── text/                                   # 文本处理
│       ├── CharsetKit.java                     # 字符集工具
│       ├── Convert.java                        # 类型转换工具
│       └── StrFormatter.java                   # 字符串格式化
├── enums/                                     # 枚举类型
│   ├── BusinessStatus.java                     # 业务操作状态
│   ├── BusinessType.java                       # 业务操作类型
│   ├── DataSourceType.java                     # 数据源类型
│   ├── DesensitizedType.java                   # 脱敏类型
│   ├── OnlineStatus.java                       # 在线状态
│   ├── OperatorType.java                       # 操作人类别
│   └── UserStatus.java                         # 用户状态
├── exception/                                 # 异常体系
│   ├── base/
│   │   └── BaseException.java                  # 基础异常
│   ├── file/
│   │   ├── FileException.java                  # 文件异常
│   │   ├── FileNameLengthLimitExceededException.java
│   │   ├── FileSizeLimitExceededException.java
│   │   ├── FileUploadException.java
│   │   └── InvalidExtensionException.java
│   ├── job/
│   │   └── TaskException.java                  # 定时任务异常
│   ├── user/                                   # 用户异常
│   │   ├── BlackListException.java             # 黑名单异常
│   │   ├── CaptchaException.java               # 验证码异常
│   │   ├── RoleBlockedException.java           # 角色锁定异常
│   │   ├── UserBlockedException.java           # 用户锁定异常
│   │   ├── UserDeleteException.java            # 用户删除异常
│   │   ├── UserException.java                  # 用户基础异常
│   │   ├── UserNotExistsException.java         # 用户不存在异常
│   │   ├── UserPasswordNotMatchException.java  # 密码不匹配异常
│   │   ├── UserPasswordRetryLimitCountException.java
│   │   └── UserPasswordRetryLimitExceedException.java
│   ├── DemoModeException.java                  # 演示模式异常
│   ├── GlobalException.java                    # 全局异常
│   ├── ServiceException.java                   # 业务服务异常
│   └── UtilException.java                      # 工具异常
├── json/                                      # JSON 处理
│   ├── JSON.java                               # JSON 工具接口
│   └── JSONObject.java                         # JSON 对象封装
├── utils/                                     # 工具类集合
│   ├── bean/
│   │   ├── BeanUtils.java                      # Bean 工具
│   │   └── BeanValidators.java                 # Bean 校验工具
│   ├── file/
│   │   ├── FileTypeUtils.java                  # 文件类型工具
│   │   ├── FileUploadUtils.java                # 文件上传工具
│   │   ├── FileUtils.java                      # 文件操作工具
│   │   ├── ImageUtils.java                     # 图片工具
│   │   └── MimeTypeUtils.java                  # MIME 类型工具
│   ├── html/
│   │   ├── EscapeUtil.java                     # HTML 转义工具
│   │   └── HTMLFilter.java                     # HTML 过滤器
│   ├── http/
│   │   ├── HttpUtils.java                      # HTTP 请求工具
│   │   └── UserAgentUtils.java                 # 用户代理解析
│   ├── poi/
│   │   ├── ExcelHandlerAdapter.java            # Excel 处理器适配器
│   │   ├── ExcelSheet.java                     # Excel Sheet 注解
│   │   └── ExcelUtil.java                      # Excel 导入导出工具
│   ├── reflect/
│   │   └── ReflectUtils.java                   # 反射工具
│   ├── security/
│   │   ├── CipherUtils.java                    # 加密工具
│   │   ├── Md5Utils.java                       # MD5 工具
│   │   └── PermissionUtils.java                # 权限工具
│   ├── spring/
│   │   └── SpringUtils.java                    # Spring 上下文工具
│   ├── sql/
│   │   └── SqlUtil.java                        # SQL 工具（防注入）
│   ├── uuid/
│   │   ├── IdUtils.java                        # ID 生成工具
│   │   ├── Seq.java                            # 序列号生成
│   │   └── UUID.java                           # UUID 工具
│   ├── AddressUtils.java                       # 地址解析工具
│   ├── Arith.java                              # 精确算术工具
│   ├── CacheUtils.java                         # 缓存工具
│   ├── CookieUtils.java                        # Cookie 工具
│   ├── DateUtils.java                          # 日期工具
│   ├── DesensitizedUtil.java                   # 数据脱敏工具
│   ├── DictUtils.java                          # 字典工具
│   ├── ExceptionUtil.java                      # 异常工具
│   ├── IpUtils.java                            # IP 工具
│   ├── LogUtils.java                           # 日志工具
│   ├── MapDataUtil.java                        # Map 数据工具
│   ├── MessageUtils.java                       # 消息工具（i18n）
│   ├── PageUtils.java                          # 分页工具
│   ├── ServletUtils.java                       # Servlet 工具
│   ├── ShiroUtils.java                         # Shiro 工具
│   ├── StringUtils.java                        # 字符串工具
│   └── Threads.java                            # 线程工具
└── xss/                                       # XSS 防护
    ├── Xss.java                                # XSS 注解
    ├── XssFilter.java                          # XSS 过滤器
    ├── XssHttpServletRequestWrapper.java       # XSS 请求包装器
    └── XssValidator.java                       # XSS 校验器
```

**关键类详细说明**：

#### `BaseController` - 控制器基类

```
路径: com.ruoyi.common.core.controller.BaseController
```

所有业务 Controller 的基类，提供以下通用方法：

| 方法 | 说明 |
|------|------|
| `startPage()` | 设置分页参数，启动 PageHelper 分页 |
| `startOrderBy()` | 设置排序参数 |
| `clearPage()` | 清理分页线程变量 |
| `getDataTable(List)` | 返回分页表格数据（`TableDataInfo`） |
| `toAjax(int/boolean)` | 根据操作结果返回成功/失败 |
| `success()/error()` | 返回成功/失败消息 |
| `getSysUser()` | 获取当前登录用户 |
| `getUserId()` | 获取当前登录用户 ID |
| `getLoginName()` | 获取当前登录用户名 |

#### `AjaxResult` - 统一响应结果

```
路径: com.ruoyi.common.core.domain.AjaxResult
```

基于 `HashMap<String, Object>` 的统一响应类：

| 字段 | 类型 | 说明 |
|------|------|------|
| `code` | int | 状态码（0=成功, 301=警告, 500=错误） |
| `msg` | String | 返回消息 |
| `data` | Object | 返回数据 |

静态工厂方法：`success()`, `success(data)`, `error()`, `error(msg)`, `warn(msg)`

#### `BaseEntity` - 实体基类

```
路径: com.ruoyi.common.core.domain.BaseEntity
```

所有领域实体的基类，提供公共字段：

| 字段 | 类型 | 说明 |
|------|------|------|
| `searchValue` | String | 搜索值（JSON 序列化时忽略） |
| `createBy` | String | 创建者 |
| `createTime` | Date | 创建时间 |
| `updateBy` | String | 更新者 |
| `updateTime` | Date | 更新时间 |
| `remark` | String | 备注 |
| `params` | Map | 请求参数（用于动态参数，如数据权限 SQL） |

#### `TreeEntity` - 树形实体基类

```
路径: com.ruoyi.common.core.domain.TreeEntity
```

继承 `BaseEntity`，增加树形结构字段：

| 字段 | 类型 | 说明 |
|------|------|------|
| `parentId` | Long | 父节点 ID |
| `parentName` | String | 父节点名称 |
| `ancestors` | String | 祖级列表（如 "0,100,101"） |

### 4.3 ruoyi-framework（框架模块）

**职责**：提供框架层面的配置与切面处理，包括 Shiro 安全认证、MyBatis 配置、AOP 切面、全局异常处理、自定义过滤器等。

**目录结构**：

```
ruoyi-framework/src/main/java/com/ruoyi/framework/
├── aspectj/                                   # AOP 切面
│   ├── DataScopeAspect.java                   # 数据权限切面
│   ├── DataSourceAspect.java                  # 数据源切换切面
│   ├── LogAspect.java                         # 操作日志切面
│   └── PermissionsAspect.java                 # 权限校验切面
├── config/                                    # 框架配置
│   ├── properties/
│   │   ├── DruidProperties.java               # Druid 配置属性
│   │   └── PermitAllUrlProperties.java        # 免认证 URL 配置
│   ├── ApplicationConfig.java                 # 应用配置（Bean 扫描）
│   ├── CaptchaConfig.java                     # 验证码配置
│   ├── DruidConfig.java                       # Druid 数据源配置
│   ├── FilterConfig.java                      # 过滤器配置
│   ├── I18nConfig.java                        # 国际化配置
│   ├── KaptchaTextCreator.java                # 验证码文本生成器
│   ├── MyBatisConfig.java                     # MyBatis 配置
│   ├── ResourcesConfig.java                   # 静态资源配置
│   └── ShiroConfig.java                       # Shiro 安全配置
├── datasource/                                # 数据源
│   └── DynamicDataSource.java                 # 动态数据源
├── interceptor/                               # 拦截器
│   ├── impl/
│   │   └── SameUrlDataInterceptor.java         # 相同URL数据拦截器
│   └── RepeatSubmitInterceptor.java           # 防重复提交拦截器
├── manager/                                   # 异步任务管理
│   ├── factory/
│   │   └── AsyncFactory.java                  # 异步任务工厂
│   ├── AsyncManager.java                      # 异步任务管理器
│   └── ShutdownManager.java                   # 关闭管理器
├── shiro/                                     # Shiro 安全
│   ├── realm/
│   │   └── UserRealm.java                     # 自定义 Realm
│   ├── rememberMe/
│   │   └── CustomCookieRememberMeManager.java # 记住我 Cookie 管理
│   ├── service/                               # Shiro 服务
│   │   ├── SysLoginService.java               # 登录服务
│   │   ├── SysPasswordService.java            # 密码服务
│   │   ├── SysRegisterService.java            # 注册服务
│   │   └── SysShiroService.java               # Shiro 辅助服务
│   ├── session/                               # 会话管理
│   │   ├── OnlineSessionDAO.java              # 在线会话 DAO
│   │   └── OnlineSessionFactory.java          # 在线会话工厂
│   ├── util/
│   │   └── AuthorizationUtils.java            # 授权工具
│   └── web/
│       ├── CustomShiroFilterFactoryBean.java  # 自定义 Shiro 过滤器工厂
│       └── filter/                            # Shiro 过滤器
│           ├── LogoutFilter.java              # 退出过滤器
│           ├── captcha/
│           │   └── CaptchaValidateFilter.java # 验证码校验过滤器
│           ├── csrf/
│           │   └── CsrfValidateFilter.java    # CSRF 校验过滤器
│           ├── kickout/
│           │   └── KickoutSessionFilter.java  # 踢出会话过滤器
│           └── online/
│               └── OnlineSessionFilter.java   # 在线会话过滤器
├── web/                                       # Web 层支持
│   ├── domain/
│   │   └── Server.java                        # 服务器信息
│   ├── exception/
│   │   └── GlobalExceptionHandler.java        # 全局异常处理器
│   └── service/                               # Web 服务
│       ├── CacheService.java                  # 缓存服务
│       ├── ConfigService.java                 # 参数配置服务
│       ├── DictService.java                   # 字典服务
│       └── PermissionService.java             # 权限服务
└── (shiro/web/filter/)
    └── sync/
        └── SyncOnlineSessionFilter.java       # 会话同步过滤器
    └── (web/session/)
        └── OnlineWebSessionManager.java       # 在线会话管理器
        └── SpringSessionValidationScheduler.java # 会话验证调度器
```

**关键类详细说明**：

#### `ShiroConfig` - Shiro 安全配置

```
路径: com.ruoyi.framework.config.ShiroConfig
```

核心安全配置类，负责配置 Shiro 的完整安全体系：

| 配置项 | 说明 |
|--------|------|
| `EhCacheManager` | 缓存管理器，使用 EhCache 存储权限和会话数据 |
| `UserRealm` | 自定义 Realm，处理登录认证与权限授权 |
| `OnlineSessionDAO` | 自定义 Session DAO，持久化在线会话 |
| `OnlineWebSessionManager` | 会话管理器，管理 Session 生命周期 |
| `SecurityManager` | Shiro 核心安全管理器 |
| `ShiroFilterFactoryBean` | 过滤器链配置，定义 URL 访问规则 |
| `CustomCookieRememberMeManager` | 记住我功能 Cookie 管理 |
| `KickoutSessionFilter` | 同账号多设备登录限制 |
| `ShiroDialect` | Thymeleaf + Shiro 模板集成 |

**Shiro 过滤器链**：

| 过滤器名称 | 功能 |
|-----------|------|
| `anon` | 匿名访问（无需登录） |
| `user` | 用户认证（登录或 RememberMe） |
| `logout` | 退出登录 |
| `captchaValidate` | 验证码校验 |
| `onlineSession` | 在线会话处理 |
| `syncOnlineSession` | 会话状态同步到数据库 |
| `kickout` | 踢出超限会话 |
| `csrfValidateFilter` | CSRF 校验 |

#### `UserRealm` - 自定义 Realm

```
路径: com.ruoyi.framework.shiro.realm.UserRealm
```

继承 `AuthorizingRealm`，实现认证和授权：

| 方法 | 说明 |
|------|------|
| `doGetAuthorizationInfo()` | 授权方法：获取用户角色和权限列表。管理员拥有 `*:*:*` 通配符权限 |
| `doGetAuthenticationInfo()` | 认证方法：验证用户名密码，抛出对应的 Shiro 异常 |

#### `DataScopeAspect` - 数据权限切面

```
路径: com.ruoyi.framework.aspectj.DataScopeAspect
```

通过 AOP 实现数据范围过滤：

| 数据范围 | 常量值 | 说明 |
|---------|--------|------|
| 全部数据权限 | `1` | 不添加过滤条件 |
| 自定义数据权限 | `2` | 根据 `sys_role_dept` 表过滤 |
| 本部门数据权限 | `3` | 仅当前部门数据 |
| 本部门及以下 | `4` | 当前部门及子部门数据 |
| 仅本人数据权限 | `5` | 仅当前用户创建的数据 |

配合 `@DataScope` 注解使用，自动在 SQL 中注入数据权限过滤条件。

#### `LogAspect` - 操作日志切面

```
路径: com.ruoyi.framework.aspectj.LogAspect
```

通过 `@Log` 注解标记需要记录操作日志的方法，异步记录：

| 属性 | 说明 |
|------|------|
| `title` | 操作模块标题 |
| `businessType` | 业务操作类型（新增、修改、删除、查询、导入、导出等） |
| `operatorType` | 操作人类别（其他、后台用户、手机端用户） |

#### `DynamicDataSource` - 动态数据源

```
路径: com.ruoyi.framework.datasource.DynamicDataSource
```

继承 `AbstractRoutingDataSource`，通过 `DynamicDataSourceContextHolder` 实现运行时数据源切换。配合 `@DataSource` 注解使用。

#### `GlobalExceptionHandler` - 全局异常处理器

```
路径: com.ruoyi.framework.web.exception.GlobalExceptionHandler
```

使用 `@RestControllerAdvice` 统一处理异常：

| 异常类型 | 处理方式 |
|---------|---------|
| `AuthorizationException` | 权限校验失败，AJAX 返回 JSON，普通请求跳转未授权页面 |
| `HttpRequestMethodNotSupportedException` | HTTP 方法不支持 |
| `ServiceException` | 业务异常 |
| `BindException` | 参数校验异常 |
| `DemoModeException` | 演示模式限制 |
| `RuntimeException` / `Exception` | 未知异常兜底处理 |

### 4.4 ruoyi-system（系统业务模块）

**职责**：提供系统核心业务逻辑，包括用户、角色、菜单、部门、字典、岗位、通知、日志等管理功能。

**目录结构**：

```
ruoyi-system/src/main/java/com/ruoyi/system/
├── domain/                                    # 系统领域实体
│   ├── SysConfig.java                         # 系统配置
│   ├── SysLogininfor.java                     # 登录日志
│   ├── SysNotice.java                         # 通知公告
│   ├── SysNoticeRead.java                     # 公告已读记录
│   ├── SysOperLog.java                        # 操作日志
│   ├── SysPost.java                           # 岗位信息
│   ├── SysRoleDept.java                       # 角色-部门关联
│   ├── SysRoleMenu.java                       # 角色-菜单关联
│   ├── SysUserOnline.java                     # 在线用户
│   ├── SysUserPost.java                       # 用户-岗位关联
│   └── SysUserRole.java                       # 用户-角色关联
├── mapper/                                    # 数据访问层
│   ├── SysConfigMapper.java                   # 配置 Mapper
│   ├── SysDeptMapper.java                     # 部门 Mapper
│   ├── SysDictDataMapper.java                 # 字典数据 Mapper
│   ├── SysDictTypeMapper.java                 # 字典类型 Mapper
│   ├── SysLogininforMapper.java               # 登录日志 Mapper
│   ├── SysMenuMapper.java                     # 菜单 Mapper
│   ├── SysNoticeMapper.java                   # 通知 Mapper
│   ├── SysNoticeReadMapper.java               # 公告已读 Mapper
│   ├── SysOperLogMapper.java                  # 操作日志 Mapper
│   ├── SysPostMapper.java                     # 岗位 Mapper
│   ├── SysRoleDeptMapper.java                 # 角色-部门 Mapper
│   ├── SysRoleMapper.java                     # 角色 Mapper
│   ├── SysRoleMenuMapper.java                 # 角色-菜单 Mapper
│   ├── SysUserMapper.java                     # 用户 Mapper
│   ├── SysUserOnlineMapper.java               # 在线用户 Mapper
│   ├── SysUserPostMapper.java                 # 用户-岗位 Mapper
│   └── SysUserRoleMapper.java                 # 用户-角色 Mapper
└── service/                                   # 业务逻辑层
    ├── ISysConfigService.java                 # 配置服务接口
    ├── ISysDeptService.java                   # 部门服务接口
    ├── ISysDictDataService.java               # 字典数据服务接口
    ├── ISysDictTypeService.java               # 字典类型服务接口
    ├── ISysLogininforService.java             # 登录日志服务接口
    ├── ISysMenuService.java                   # 菜单服务接口
    ├── ISysNoticeReadService.java             # 公告已读服务接口
    ├── ISysNoticeService.java                 # 通知服务接口
    ├── ISysOperLogService.java                # 操作日志服务接口
    ├── ISysPostService.java                   # 岗位服务接口
    ├── ISysRoleService.java                   # 角色服务接口
    ├── ISysUserOnlineService.java             # 在线用户服务接口
    ├── ISysUserService.java                   # 用户服务接口
    └── impl/                                  # 服务实现类
        ├── SysConfigServiceImpl.java
        ├── SysDeptServiceImpl.java
        ├── SysDictDataServiceImpl.java
        ├── SysDictTypeServiceImpl.java
        ├── SysLogininforServiceImpl.java
        ├── SysMenuServiceImpl.java
        ├── SysNoticeReadServiceImpl.java
        ├── SysNoticeServiceImpl.java
        ├── SysOperLogServiceImpl.java
        ├── SysPostServiceImpl.java
        ├── SysRoleServiceImpl.java
        ├── SysUserOnlineServiceImpl.java
        └── SysUserServiceImpl.java
```

**核心实体说明**：

#### `SysUser` - 用户实体

```
路径: com.ruoyi.common.core.domain.entity.SysUser
```

| 字段 | 类型 | 说明 |
|------|------|------|
| `userId` | Long | 用户 ID |
| `deptId` | Long | 部门 ID |
| `loginName` | String | 登录账号 |
| `userName` | String | 用户昵称 |
| `userType` | String | 用户类型 |
| `email` | String | 邮箱 |
| `phonenumber` | String | 手机号 |
| `sex` | String | 性别（0男 1女 2未知） |
| `avatar` | String | 头像路径 |
| `password` | String | 密码（加密存储） |
| `salt` | String | 盐值 |
| `status` | String | 状态（0正常 1停用） |
| `delFlag` | String | 删除标志（0存在 2删除） |
| `loginIp` | String | 最后登录 IP |
| `loginDate` | Date | 最后登录时间 |
| `dept` | SysDept | 所属部门对象 |
| `roles` | List<SysRole> | 角色列表 |

#### `SysRole` - 角色实体

```
路径: com.ruoyi.common.core.domain.entity.SysRole
```

| 字段 | 类型 | 说明 |
|------|------|------|
| `roleId` | Long | 角色 ID |
| `roleName` | String | 角色名称 |
| `roleKey` | String | 角色权限字符串 |
| `roleSort` | String | 排序 |
| `dataScope` | String | 数据范围（1-5） |
| `status` | String | 状态 |
| `delFlag` | String | 删除标志 |
| `permissions` | Set<String> | 菜单权限集合 |

#### `SysMenu` - 菜单实体

```
路径: com.ruoyi.common.core.domain.entity.SysMenu
```

| 字段 | 类型 | 说明 |
|------|------|------|
| `menuId` | Long | 菜单 ID |
| `menuName` | String | 菜单名称 |
| `parentId` | Long | 父菜单 ID |
| `orderNum` | Integer | 排序 |
| `url` | String | 路由地址 |
| `perms` | String | 权限标识（如 `system:user:add`） |
| `menuType` | String | 类型（M目录 C菜单 F按钮） |
| `visible` | String | 是否可见 |
| `icon` | String | 图标 |

#### `SysDept` - 部门实体

```
路径: com.ruoyi.common.core.domain.entity.SysDept
```

| 字段 | 类型 | 说明 |
|------|------|------|
| `deptId` | Long | 部门 ID |
| `parentId` | Long | 父部门 ID |
| `ancestors` | String | 祖级列表 |
| `deptName` | String | 部门名称 |
| `orderNum` | Integer | 排序 |
| `leader` | String | 负责人 |
| `phone` | String | 联系电话 |
| `status` | String | 状态 |

### 4.5 ruoyi-quartz（定时任务模块）

**职责**：提供定时任务的在线管理和调度功能，基于 Quartz 框架实现。

**目录结构**：

```
ruoyi-quartz/src/main/java/com/ruoyi/quartz/
├── config/
│   └── ScheduleConfig.java                    # Quartz 配置
├── controller/
│   ├── SysJobController.java                  # 定时任务管理控制器
│   └── SysJobLogController.java               # 任务日志控制器
├── domain/
│   ├── SysJob.java                            # 定时任务实体
│   └── SysJobLog.java                         # 任务执行日志实体
├── mapper/
│   ├── SysJobMapper.java                      # 任务 Mapper
│   └── SysJobLogMapper.java                   # 任务日志 Mapper
├── service/
│   ├── ISysJobService.java                    # 任务服务接口
│   ├── ISysJobLogService.java                 # 任务日志服务接口
│   └── impl/
│       ├── SysJobServiceImpl.java
│       └── SysJobLogServiceImpl.java
├── task/
│   └── RyTask.java                            # 示例任务（无参/有参方法）
└── util/
    ├── AbstractQuartzJob.java                 # Quartz 任务基类
    ├── CronUtils.java                         # Cron 表达式工具
    ├── JobInvokeUtil.java                     # 任务调用工具
    ├── QuartzDisallowConcurrentExecution.java # 禁止并发执行
    ├── QuartzJobExecution.java                # 允许并发执行
    └── ScheduleUtils.java                     # 调度工具类
```

**核心类说明**：

| 类名 | 说明 |
|------|------|
| `SysJob` | 定时任务实体，包含任务名称、方法名、参数、Cron 表达式、执行策略等 |
| `AbstractQuartzJob` | 任务执行基类，实现 `org.quartz.Job` 接口，统一处理任务执行、异常记录和日志 |
| `QuartzDisallowConcurrentExecution` | `@DisallowConcurrentExecution` 标记，禁止同一任务并发执行 |
| `QuartzJobExecution` | 允许同一任务并发执行 |
| `ScheduleUtils` | 任务调度工具，提供创建、更新、暂停、恢复、删除任务的方法 |

### 4.6 ruoyi-generator（代码生成模块）

**职责**：根据数据库表结构自动生成前后端代码，支持 CRUD 操作。

**目录结构**：

```
ruoyi-generator/src/main/java/com/ruoyi/generator/
├── config/
│   └── GenConfig.java                         # 代码生成配置
├── controller/
│   └── GenController.java                     # 代码生成控制器
├── domain/
│   ├── GenTable.java                          # 代码生成业务表
│   └── GenTableColumn.java                    # 代码生成业务表字段
├── mapper/
│   ├── GenTableMapper.java                    # 业务表 Mapper
│   └── GenTableColumnMapper.java              # 字段 Mapper
├── service/
│   ├── IGenTableService.java                  # 业务表服务接口
│   ├── IGenTableColumnService.java            # 字段服务接口
│   └── impl/
│       ├── GenTableServiceImpl.java
│       └── GenTableColumnServiceImpl.java
├── util/
│   ├── GenUtils.java                          # 代码生成工具
│   ├── VelocityInitializer.java               # Velocity 初始化
│   └── VelocityUtils.java                     # Velocity 模板工具
└── resources/
    ├── mapper/generator/                      # MyBatis 映射文件
    ├── templates/tool/gen/                    # 代码生成页面模板
    ├── vm/                                    # Velocity 代码模板
    │   ├── html/                              # 前端页面模板
    │   │   ├── add.html.vm                    # 新增页面
    │   │   ├── edit.html.vm                   # 编辑页面
    │   │   ├── list.html.vm                   # 列表页面
    │   │   ├── list-tree.html.vm              # 树列表页面
    │   │   ├── tree.html.vm                   # 树组件页面
    │   │   └── view.html.vm                   # 详情页面
    │   ├── java/                              # 后端代码模板
    │   │   ├── controller.java.vm             # Controller 模板
    │   │   ├── domain.java.vm                 # Entity 模板
    │   │   ├── mapper.java.vm                 # Mapper 模板
    │   │   ├── service.java.vm                # Service 接口模板
    │   │   ├── serviceImpl.java.vm            # Service 实现模板
    │   │   └── sub-domain.java.vm             # 子实体模板
    │   └── sql/
    │       └── sql.vm                         # SQL 脚本模板
    └── generator.yml                          # 代码生成默认配置
```

**生成代码类型**：
- Java：Controller、Service、ServiceImpl、Mapper、Domain（实体类）
- HTML：增删改查页面、树形页面、详情页面
- XML：MyBatis Mapper 映射文件
- SQL：建表 SQL 脚本

---

## 5. 关键类与函数详解

### 5.1 认证与授权流程

```
用户登录请求
    │
    ▼
SysLoginController.login()
    │
    ▼
Shiro Subject.login(UsernamePasswordToken)
    │
    ▼
UserRealm.doGetAuthenticationInfo()
    │
    ├── SysLoginService.login(username, password)
    │       ├── 验证码校验（如果开启）
    │       ├── 查询用户信息
    │       ├── 密码校验（MD5 + Salt）
    │       ├── 账号状态检查
    │       └── 密码错误计数（超过 maxRetryCount 锁定10分钟）
    │
    ▼
AuthenticationInfo 返回
    │
    ▼
登录成功 → 创建 Session → 记录在线用户 → 记录登录日志
```

```
用户访问受保护资源
    │
    ▼
ShiroFilter 拦截
    │
    ▼
UserRealm.doGetAuthorizationInfo()
    │
    ├── 获取当前用户
    ├── 判断是否为管理员 → 授予 *:*:* 通配符权限
    ├── 查询用户角色列表
    └── 查询用户权限列表
    │
    ▼
权限校验（@RequiresPermissions / @RequiresRoles）
    │
    ├── 通过 → 执行业务方法
    └── 不通过 → AuthorizationException → GlobalExceptionHandler
```

### 5.2 权限注解体系

| 注解 | 包路径 | 说明 | 使用示例 |
|------|--------|------|---------|
| `@RequiresPermissions` | `org.apache.shiro.authz.annotation` | 权限校验 | `@RequiresPermissions("system:user:add")` |
| `@RequiresRoles` | `org.apache.shiro.authz.annotation` | 角色校验 | `@RequiresRoles("admin")` |
| `@DataScope` | `com.ruoyi.common.annotation` | 数据权限过滤 | `@DataScope(deptAlias = "d", userAlias = "u")` |
| `@DataSource` | `com.ruoyi.common.annotation` | 数据源切换 | `@DataSource(DataSourceType.SLAVE)` |
| `@Log` | `com.ruoyi.common.annotation` | 操作日志记录 | `@Log(title = "用户管理", businessType = BusinessType.INSERT)` |
| `@RepeatSubmit` | `com.ruoyi.common.annotation` | 防重复提交 | `@RepeatSubmit(interval = 5000)` |
| `@Anonymous` | `com.ruoyi.common.annotation` | 匿名访问（跳过认证） | `@Anonymous` |
| `@Excel` | `com.ruoyi.common.annotation` | Excel 列定义 | `@Excel(name = "用户名称")` |

### 5.3 自定义注解详解

#### `@DataScope` - 数据权限注解

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataScope {
    String deptAlias() default "";      // 部门表别名
    String userAlias() default "";      // 用户表别名
    String permission() default "";     // 权限字符
    String deptField() default "dept_id";  // 部门字段名
    String userField() default "user_id";  // 用户字段名
}
```

#### `@Log` - 操作日志注解

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String title() default "";                          // 操作模块
    BusinessType businessType() default BusinessType.OTHER;  // 操作类型
    OperatorType operatorType() default OperatorType.MANAGE; // 操作人类别
    boolean isSaveRequestData() default true;           // 是否保存请求参数
    boolean isSaveResponseData() default true;          // 是否保存响应结果
}
```

#### `@DataSource` - 数据源切换注解

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    DataSourceType value() default DataSourceType.MASTER;  // 数据源类型
}
```

### 5.4 工具类精选

| 工具类 | 核心方法 | 说明 |
|--------|---------|------|
| `ShiroUtils` | `getSysUser()`, `setSysUser()` | 获取/设置当前登录用户到 Shiro Session |
| `SecurityUtils` | `getSubject()`, `isAuthenticated()` | Shiro 安全工具 |
| `StringUtils` | `isNotEmpty()`, `isNull()`, `format()` | 字符串操作工具 |
| `DateUtils` | `parseDate()`, `getTime()`, `getNowDate()` | 日期处理工具 |
| `ServletUtils` | `getRequest()`, `getResponse()`, `isAjaxRequest()` | Servlet 相关工具 |
| `SpringUtils` | `getBean()` | 获取 Spring 容器中的 Bean |
| `ExcelUtil` | `exportExcel()`, `importExcel()` | Excel 导入导出 |
| `FileUploadUtils` | `upload()` | 文件上传处理 |
| `Md5Utils` | `hash()` | MD5 加密 |
| `PageUtils` | `startPage()`, `clearPage()` | 分页工具（封装 PageHelper） |
| `SqlUtil` | `escapeOrderBySql()` | SQL 防注入处理 |
| `Arith` | `add()`, `sub()`, `mul()`, `div()` | 精确浮点运算 |

---

## 6. 数据库设计

### 6.1 核心数据表

系统使用 MySQL 数据库，核心表如下：

| 表名 | 说明 | 主要字段 |
|------|------|---------|
| `sys_user` | 用户表 | user_id, dept_id, login_name, user_name, password, salt, status |
| `sys_role` | 角色表 | role_id, role_name, role_key, data_scope, status |
| `sys_menu` | 菜单权限表 | menu_id, menu_name, parent_id, url, perms, menu_type |
| `sys_dept` | 部门表 | dept_id, parent_id, ancestors, dept_name, order_num |
| `sys_post` | 岗位表 | post_id, post_code, post_name, post_sort |
| `sys_dict_type` | 字典类型表 | dict_id, dict_name, dict_type, status |
| `sys_dict_data` | 字典数据表 | dict_code, dict_sort, dict_label, dict_value, dict_type |
| `sys_config` | 参数配置表 | config_id, config_name, config_key, config_value |
| `sys_notice` | 通知公告表 | notice_id, notice_title, notice_content, notice_type |
| `sys_oper_log` | 操作日志表 | oper_id, title, business_type, method, oper_name, oper_url |
| `sys_logininfor` | 登录日志表 | info_id, login_name, ipaddr, login_location, status, msg |
| `sys_user_role` | 用户-角色关联表 | user_id, role_id |
| `sys_role_menu` | 角色-菜单关联表 | role_id, menu_id |
| `sys_role_dept` | 角色-部门关联表 | role_id, dept_id |
| `sys_user_post` | 用户-岗位关联表 | user_id, post_id |
| `sys_job` | 定时任务表 | job_id, job_name, job_group, invoke_target, cron_expression |
| `sys_job_log` | 任务日志表 | job_log_id, job_name, job_group, invoke_target, job_message |
| `gen_table` | 代码生成业务表 | table_id, table_name, class_name, tpl_category |
| `gen_table_column` | 代码生成字段表 | column_id, table_id, column_name, java_type, java_field |

### 6.2 表关系图（简版）

```
sys_user ──┬── sys_user_role ──┬── sys_role ──┬── sys_role_menu ──┬── sys_menu
           │                   │              │
           │                   │              └── sys_role_dept ──┬── sys_dept
           │                   │
           ├── sys_user_post ──┤── sys_post
           │
           └── (dept_id) ──────┘

sys_dept ──┐
           └── (parent_id) 自关联树形结构

sys_menu ──┐
           └── (parent_id) 自关联树形结构
```

---

## 7. 依赖关系图

### 7.1 Maven 依赖关系

```
ruoyi (parent pom.xml)
│
├── ruoyi-common          (无内部依赖)
│
├── ruoyi-system          → ruoyi-common
│
├── ruoyi-framework       → ruoyi-common
│                         → ruoyi-system (间接)
│
├── ruoyi-quartz          → ruoyi-common
│                         → ruoyi-framework (间接)
│
├── ruoyi-generator       → ruoyi-common
│                         → ruoyi-framework (间接)
│
└── ruoyi-admin           → ruoyi-framework
                          → ruoyi-system
                          → ruoyi-quartz
                          → ruoyi-generator
                          → ruoyi-common
```

### 7.2 核心外部依赖

| 依赖 | 用途 | 使用模块 |
|------|------|---------|
| Spring Boot 4.0.3 | 核心框架 | 全部 |
| Apache Shiro 2.1.0 | 安全认证 | ruoyi-framework, ruoyi-admin |
| MyBatis 4.0.1 | 持久层 | 全部 |
| Druid 1.2.28 | 连接池 | ruoyi-framework |
| PageHelper 2.1.1 | 分页 | ruoyi-common |
| SpringDoc 3.0.2 | API 文档 | ruoyi-admin |
| Apache POI 4.1.2 | Excel | ruoyi-common |
| Velocity 2.3 | 代码生成模板 | ruoyi-generator |
| Quartz (通过Spring Boot) | 定时任务 | ruoyi-quartz |
| EhCache (通过Shiro) | 缓存 | ruoyi-framework |
| FastJSON 1.2.83 | JSON 处理 | ruoyi-common, ruoyi-generator |

---

## 8. 配置说明

### 8.1 主要配置文件

| 文件 | 路径 | 说明 |
|------|------|------|
| `pom.xml` | 项目根目录 | Maven 父 POM，管理所有模块和依赖版本 |
| `application.yml` | ruoyi-admin | 主配置文件（端口、上传、Shiro、MyBatis、分页等） |
| `application-druid.yml` | ruoyi-admin | Druid 数据源配置（数据库连接信息） |
| `mybatis-config.xml` | ruoyi-admin | MyBatis 全局配置（驼峰命名、日志等） |
| `ehcache-shiro.xml` | ruoyi-admin | EhCache 缓存配置 |
| `logback.xml` | ruoyi-admin | 日志配置（控制台+文件输出） |
| `generator.yml` | ruoyi-generator | 代码生成默认配置（作者、包名等） |

### 8.2 application.yml 核心配置

| 配置项 | 默认值 | 说明 |
|--------|--------|------|
| `server.port` | 80 | HTTP 服务端口 |
| `ruoyi.version` | 4.8.3 | 系统版本 |
| `ruoyi.demoEnabled` | true | 是否开启演示模式 |
| `ruoyi.profile` | D:/ruoyi/uploadPath | 文件上传路径 |
| `mybatis.typeAliasesPackage` | com.ruoyi.**.domain | 实体类扫描包 |
| `mybatis.mapperLocations` | classpath*:mapper/**/*Mapper.xml | Mapper XML 扫描路径 |
| `pagehelper.helperDialect` | mysql | 分页数据库方言 |
| `shiro.user.loginUrl` | /login | 登录页面 URL |
| `shiro.session.expireTime` | 30 | Session 超时时间（分钟） |
| `shiro.user.captchaEnabled` | true | 是否开启验证码 |
| `shiro.rememberMe.enabled` | true | 是否开启记住我 |
| `xss.enabled` | true | 是否开启 XSS 过滤 |

### 8.3 Shiro Cookie 配置

| 配置项 | 默认值 | 说明 |
|--------|--------|------|
| `shiro.cookie.path` | / | Cookie 有效路径 |
| `shiro.cookie.httpOnly` | true | 仅 HTTP 访问（防止 XSS） |
| `shiro.cookie.maxAge` | 30 | Cookie 过期时间（天） |
| `shiro.session.maxSession` | -1 | 同账号最大会话数（-1 不限制） |
| `shiro.session.kickoutAfter` | false | 踢出策略（false=踢出前者） |

---

## 9. 项目运行方式

### 9.1 环境要求

| 环境 | 版本要求 |
|------|---------|
| JDK | 17 或更高版本 |
| Maven | 3.6+ |
| MySQL | 5.7+ / 8.0+ |
| Node.js (可选) | 16+（如果需要前端构建） |

### 9.2 数据库初始化

1. 创建 MySQL 数据库（如 `ry`）
2. 执行项目提供的 SQL 初始化脚本（`sql/ry_*.sql`）
3. SQL 脚本包含：
   - 表结构创建（DDL）
   - 初始数据插入（用户、角色、菜单、字典等）
   - 默认管理员账号：`admin`，密码：`admin123`

### 9.3 修改数据库配置

编辑 `ruoyi-admin/src/main/resources/application-druid.yml`，修改数据库连接信息：

```yaml
spring:
  datasource:
    druid:
      master:
        url: jdbc:mysql://localhost:3306/数据库名?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
        username: 用户名
        password: 密码
```

### 9.4 启动项目

#### 方式一：IDE 启动

1. 使用 IDE（IntelliJ IDEA / Eclipse）导入 Maven 项目
2. 等待 Maven 依赖下载完成
3. 找到 `RuoYiApplication.java`（位于 `ruoyi-admin` 模块）
4. 右键 → Run As → Java Application

#### 方式二：Maven 命令启动

```bash
# 在项目根目录执行
mvn clean package

# 进入 ruoyi-admin/target 目录
cd ruoyi-admin/target

# 运行 JAR
java -jar ruoyi-admin.jar
```

#### 方式三：使用提供的启动脚本

```bash
# Windows
bin/run.bat

# Linux/Mac
./ry.sh
```

### 9.5 启动后访问

| 地址 | 说明 |
|------|------|
| `http://localhost:80` | 系统首页（需登录） |
| `http://localhost:80/login` | 登录页面 |
| `http://localhost:80/druid` | Druid 监控面板 |
| `http://localhost:80/swagger-ui.html` | API 接口文档 |
| `http://localhost:80/v3/api-docs` | OpenAPI JSON 文档 |

### 9.6 打包部署

```bash
# 完整构建
mvn clean package -DskipTests

# 生成的 JAR 包位于
ruoyi-admin/target/ruoyi-admin.jar
```

传统 WAR 部署（部署到外部 Tomcat）：
1. 修改 `ruoyi-admin/pom.xml` 的 `packaging` 为 `war`
2. `mvn clean package`
3. 将生成的 WAR 包部署到 Tomcat 的 `webapps` 目录

---

## 10. 架构设计亮点

### 10.1 数据权限控制

系统通过 `@DataScope` 注解 + AOP 切面实现灵活的数据范围权限控制：

```
角色配置数据范围 → 用户绑定角色 → 访问数据时自动注入 SQL 过滤条件
```

支持 5 种数据范围：全部数据、自定义部门、本部门、本部门及以下、仅本人数据。

### 10.2 动态数据源

通过 `@DataSource` 注解 + `DynamicDataSource` 实现运行时数据源切换，支持主从数据库分离：

```java
@DataSource(DataSourceType.SLAVE)
public List<SysUser> selectUserList(SysUser user) {
    // 该方法将使用从库执行查询
}
```

### 10.3 异步日志记录

操作日志通过 `AsyncManager` 异步写入数据库，不阻塞主业务流程：

```
用户操作 → LogAspect 拦截 → 封装日志对象 → AsyncManager.me().execute() → 异步线程写入DB
```

### 10.4 防重复提交

通过 `@RepeatSubmit` 注解 + 缓存机制（Session/URL 签名）防止表单重复提交。

### 10.5 安全机制

| 机制 | 实现方式 |
|------|---------|
| 认证 | Shiro UsernamePasswordToken + UserRealm |
| 授权 | Shiro @RequiresPermissions / @RequiresRoles |
| 数据权限 | @DataScope 注解 + AOP |
| XSS 防护 | XssFilter + XssHttpServletRequestWrapper |
| CSRF 防护 | CsrfValidateFilter + 自定义 Token |
| 密码安全 | MD5 + Salt 加密 |
| 验证码 | Kaptcha 数学计算/字符验证 |
| 会话管理 | 自定义 OnlineSession + 超时踢出 |
| SQL 注入防护 | SqlUtil.escapeOrderBySql() |

---

## 11. 核心数据流

### 11.1 用户登录流程

```
1. 前端 → POST /login (loginName, password, validateCode)
2. SysLoginController.login()
3. Shiro Subject.login(token)
4. UserRealm.doGetAuthenticationInfo()
5. SysLoginService.login()
   ├── 验证码校验
   ├── 查询用户 (SysUserMapper.selectUserByLoginName)
   ├── 密码校验 (SysPasswordService.validate)
   ├── 检查账号/角色状态
   ├── 密码错误计数 (Redis/EhCache)
   └── 更新最后登录信息
6. 认证成功 → Subject.getSession().setAttribute(用户信息)
7. 记录登录日志
8. 返回主页
```

### 11.2 数据查询流程（含分页和数据权限）

```
1. Controller.getDataTable()
   └── startPage() (设置分页参数)
2. Service.selectXxxList(query)
3. DataScopeAspect.doBefore() (AOP 拦截)
   └── 注入 dataScope SQL 到 query.params
4. Mapper.selectXxxList(query)
   └── MyBatis 执行 SQL (含数据权限过滤 + 分页)
5. 返回结果
6. Controller.getDataTable()
   └── 封装 TableDataInfo (total, rows)
```

### 11.3 代码生成流程

```
1. 选择数据库表 → 导入到 gen_table
2. 编辑表配置（生成信息、字段信息）
3. 点击生成代码
4. GenController.download()
5. GenTableServiceImpl.generatorCode()
   ├── 读取 Velocity 模板
   ├── 填充模板数据（表信息、字段信息）
   ├── 渲染生成代码（Controller/Service/Mapper/HTML/XML/SQL）
   └── 打包为 ZIP 下载
```

---

## 12. 关键设计模式

| 模式 | 应用场景 |
|------|---------|
| 模板方法模式 | `AbstractQuartzJob` 定义任务执行模板 |
| 工厂模式 | `AsyncFactory` 创建异步任务，`SessionFactory` 创建会话 |
| 策略模式 | `QuartzDisallowConcurrentExecution` / `QuartzJobExecution` 并发策略 |
| 责任链模式 | Shiro Filter Chain 过滤器链 |
| 代理模式 | AOP 切面（日志、数据权限、数据源） |
| 上下文模式 | `DynamicDataSourceContextHolder` 管理数据源上下文 |
| 单例模式 | `AsyncManager` 异步管理器 |

---

## 13. 常见问题

### 13.1 项目启动失败

| 问题 | 解决方式 |
|------|---------|
| 端口占用 | 修改 `application.yml` 中的 `server.port` |
| 数据库连接失败 | 检查 `application-druid.yml` 中的数据库配置 |
| MyBatis 扫描失败 | 检查 `mybatis.typeAliasesPackage` 包路径 |
| Shiro 配置问题 | 检查 `ehcache-shiro.xml` 是否存在 |

### 13.2 登录失败

| 问题 | 解决方式 |
|------|---------|
| 验证码错误 | 检查 Kaptcha 配置或关闭验证码 |
| 用户不存在 | 确认数据库已执行初始化 SQL |
| 密码错误 | 默认密码为 `admin123` |
| 账号被锁定 | 密码错误次数超限，等待10分钟或手动解锁 |

### 13.3 代码生成不生效

| 问题 | 解决方式 |
|------|---------|
| 表未导入 | 先在代码生成页面导入数据库表 |
| 权限不足 | 确认当前用户有 `tool:gen:*` 权限 |
| 模板路径错误 | 检查 `vm/` 目录下模板文件是否存在 |

---

## 14. 相关资源

| 资源 | 地址 |
|------|------|
| 官方文档 | http://doc.ruoyi.vip |
| 演示地址 | http://ruoyi.vip |
| Gitee 仓库 | https://gitee.com/y_project/RuoYi |
| Spring Boot 3.x 分支 | https://gitee.com/y_project/RuoYi/tree/springboot3 |
| Spring Boot 2.x 分支 | https://gitee.com/y_project/RuoYi/tree/springboot2 |
| RuoYi-Vue (前后端分离) | https://gitee.com/y_project/RuoYi-Vue |
| RuoYi-Cloud (微服务) | https://gitee.com/y_project/RuoYi-Cloud |
