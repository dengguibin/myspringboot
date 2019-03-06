package com.lshjy.aoplearn.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
// @ApiIgnore
//@Api(tags = { "myproject" }, description = "我的工程接口详情")
public class MyProjectc {
//    @ApiOperation(value = "展示你所输入的内容", notes = "根据客户端输入的内容返回同样的内容", response = String.class)
//    @ApiImplicitParams({ @ApiImplicitParam(name = "param", value = "输入要返回的内容", required = false, dataType = "String", paramType = "query") })
    @RequestMapping(value = "/showWhatYouSay", method = RequestMethod.GET)
    public String showWhatYouSay(String param, HttpServletRequest request) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("result", param);
//      throw new NullPointerException();
        return "eeeeeeeee";
    }
}
