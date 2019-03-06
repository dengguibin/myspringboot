技术：springboot+mybatis+druid数据源+thymeleaf+mysql

从前端到后端单表增删改查

pagehelper分页查询

配置mybatis的sql打印日志

mybatis包别名

java驼峰命名与数据库下划线分隔符号冲突解决

## 事务遐想

A线程开启事务》休眠10秒》执行查询方法user（1）

B线程同时开启事务》直接修改user(1)

结果:A查到的值是B修改之后的

A线程开启事务→休眠10秒》执行修改方法user（1，xxx）→再查询user（1）

B线程同时开启事务→直接修改user(1,yyy)→再查询user（1）

结果：B查到的是yyy,A查到的是xxx,可见事务并不保证select与update并发操作的安全，隔离级别：读已提交

思考：

    两个应用程序操作同一个数据库，一个应用程序操作两个数据库
