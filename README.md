# SatisfactionSurvey

开发环境：SpringMVC+Spring+Hibernate+Mysql+Jquery+Ajax

* * *

### 系统介绍

- 此项目分为前台和后台管理。使用springmvc作为web层框架。
  
- 整个项目分为3层架构： web层、业务层、dao层。上层对下层的调用使用的是接口，从而实现了层与层之间的完全解耦功能
- 使用Page对象封装了一个分页页面上的所有数据。dao层加两个方法：获取总行数，获取分页数据。
- 为了解决中文乱码问题，创建一个CharacterEncodingFilter，所有表单的提交方式都是post。
