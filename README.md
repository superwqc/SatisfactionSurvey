# SatisfactionSurvey  满意度调查管理

开发环境：SpringMVC+Spring+Hibernate+Mysql+Jquery+Ajax

* * *

### 功能描述
- 项目包括登录注册、问卷管理、问题维护、用户管理、数据分析、权限控制等模块。

- 系统分为前台和后台管理，后台管理系统可供管理员使用账号登录，管理员还可以给被调查对象添加问卷，并可以对此问卷进行冻结和激活处理

- 管理员可以维护问卷、问题、用户、数据分析这4个模块。

- 管理员可以为指定的问卷添加相关的问题，可以指定是否激活某一个问卷、查看报表信息：每个被调查人员的历史平均分，每个学生的历史打分情况。

- 管理员可添加普通用户，前台普通用户没有注册权限。

- 前台供有账号和密码的用户登录使用，普通用户可对激活的调查问卷进行打分，被调查对象类型用户通过账号登录，可查看自己的被打分情况，并通过图表展现。


### 技术描述
- 前台和后端使用Ajax异步交互。使用springmvc作为web层框架。
  
- 分为3层架构： web层、业务层、DAO层。上层对下层的调用使用的是接口，从而实现了层与层之间的完全解耦功能。

- 在DAO层获取到某一个实体时，会同时加载与该对象有关联关系的其他实体。

- 在为问卷添加问题时，会自动根据问卷调查的角色，筛选出只与该角色相关的问题列表。

- 添加权限验证过滤器，只有会话中有管理员的信息时，才允许访问admin文件夹下的资源。

- 使用Page对象封装了一个分页页面上的所有数据。dao层加两个方法：获取总行数，获取分页数据。以分页api是统一的: q.setFirstResult(); q.setMaxResults();  hibernate会根据以上两个api设置的参数，自动生成对应数据库的独有的分页sql语句。

- 为解决中文乱码问题，创建一个CharacterEncodingFilter，所有表单的提交方式都是post。

- 使用spring的IOC容器管理bean，@Controller @Service @Repository@component@Autowired.

- 前台使用div+css布局，并使用bootstrap进行优化。后台界面使用easyui制作，使用了ajax+json。   

- 使用easyui制作后台界面，使用了ajax+json。

- 使用spring的IOC容器管理bean，@Controller @Service @Repository@component@Autowired.

