## crud
springboot+mybatis+druid数据源+thymeleaf+mysql

从前端到后端单表增删改查

pagehelper分页查询

配置mybatis的sql打印日志

mybatis包别名

java驼峰命名与数据库下划线分隔符号冲突解决

## mybatis-generator
1.springboot+mybatis+druid数据源实现没有前端页面，只提供api接口的单表增删改查

2.pagehelper物理分页查询

3.解决数据库下划线命名和java驼峰命名冲突:map-underscore-to-camel-case: true

4.使用mybatis-generator自动生成单表的model，mapper，以及mapper.xml，但是selectAllUser的需要自己写

## mybatis-multitable
springboot+mybatis+MySQL+druid数据源

为多表的增删改查提供了各种api,返回json数据格式

    适用：普通get和post请求，restfull风格的crud,前端数据可以传输urlencoded类型，也可以传输json数据
在resultmap中定义了查询语句

mybatis包别名

java驼峰命名与数据库下划线分隔符号冲突解决

## springboot-thymeleaf
springboot+thymeleaf实现thymeleaf的简单效果

home页面里面有thymeleaf常用的语法

    1.超链接
    2.th:text="'用户名：' +${user.name}
    3.th:switch case
    4.th:each
    5.th:text=" ${#dates.format(new java.util.Date().getTime(), 'yyyy-MM-dd hh:mm:ss')
    
##crud-memory
项目没有使用MySQL数据库

springboot+thymeleaf实现单个实体的增删改查

*使用copyconwriteArraylist替代arraylist解决了并发修改异常

## security-login-db
springboot+springsecurity+mybatis+MySQL+thymeleaf实现简单的登录与退出

访问资源的权限与角色对应，例如：role_user角色的用户只能访问/user/**的资源

## springbootRedis
1.springboot单元测试

2.Redis设置键的expireTime

3.ValueOperations对字符串类型

4.HashOperations对hash类型

5.ListOperations对List类型

6.SetOperations对Set类型

7.ZSetOperations对Zset类型

## AOP-learn
切面=（增强+切点）

使用AspectJ实现AOP

前置增强，后置增强，环绕增强

切面：增强+切点，获得连接点信息

切点深入：请看MyAspect