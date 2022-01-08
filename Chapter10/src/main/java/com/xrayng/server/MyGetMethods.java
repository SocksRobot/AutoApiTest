package com.xrayng.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "Get接口", tags = "全部Get接口")
public class MyGetMethods {
    @GetMapping("/getCookies")
    @ApiOperation("获取携带Cookies的Get响应")
    public String getCookies(HttpServletResponse response) {
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "带cookies的Get请求响应结果!";
    }

    @GetMapping("/getWithCookies")
    @ApiOperation("发送携带Cookies的Get请求")
    public String getWithCookies(HttpServletRequest request) {
        if (!Objects.isNull(request.getCookies())) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("name") && cookie.getValue().equals("zhangsan")) {
                    return "Cookies验证通过，请求成功!";
                }
            }
        }
        return "请添加Cookies后再发送该Get请求!";
    }

    @GetMapping("/getWithParams")
    @ApiOperation("发送携带参数的Get请求-方式1")
    public Map<String, Integer> getWithParams(@RequestParam Integer start, @RequestParam Integer end) {
        Map<String, Integer> response = new HashMap<>();
        response.put("鞋子", 400);
        response.put("浣熊", 100);
        response.put("衬衫", 300);
        return response;
    }

    @GetMapping("/get/{start}/{end}")
    @ApiOperation("发送携带参数的Get请求-方式2")
    public Map<String, Integer> getStartEnd(@PathVariable Integer start, @PathVariable Integer end) {
        Map<String, Integer> response = new HashMap<>();
        response.put("鞋子", 400);
        response.put("浣熊", 100);
        response.put("衬衫", 300);
        return response;
    }
}
