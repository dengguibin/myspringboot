0.centos安装Redis

    cd /src
    启动服务./redis-server &
    启动客户端./redis-cli
    
    查看所有的配置信息config get *
    
    防火墙开启Redis默认端口
    firewall-cmd --permanent --zone=public --add-port=6379/tcp
    firewall-cmd --list-ports
    firewall-cmd --reload

1.springboot单元测试redisTempalte

2.Redis设置键的expireTime

3.ValueOperations对字符串类型操作

4.HashOperations对hash类型操作

5.ListOperations对List类型操作

6.SetOperations对Set类型操作

7.ZSetOperations对Zset类型操作

8.Redis是单线程的，线程安全

## 思考：
IO的多路复用