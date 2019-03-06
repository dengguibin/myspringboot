springboot+thymeleaf实现thymeleaf的简单效果

home页面里面有thymeleaf常用的语法

    1.超链接
    2.th:text="'用户名：' +${user.name}
    3.th:switch case
    4.th:each
    5.th:text=" ${#dates.format(new java.util.Date().getTime(), 'yyyy-MM-dd hh:mm:ss')