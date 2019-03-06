cd bin
./activemq start
netstat -anp|grep 61616
打开linux防火墙端口 61616,8161

web控制台：http://IP:8161/admin  admin/admin