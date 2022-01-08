package com.xrayng.server;

import com.xrayng.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
@Api(value = "Post接口", tags = "全部Post接口")
public class MyPostMethods {
    @PostMapping("/login")
    @ApiOperation("登录接口，成功后获取Cookies")
    public String login(HttpServletResponse response, @RequestParam("userName") String userName, @RequestParam("passWord") String passWord) {
        if (userName.equals("zhangsan") && passWord.equals("123456")) {
            response.addCookie(new Cookie("Login", "True"));
            return "登录成功!";
        } else {
            return "用户名或密码错误!";
        }
    }

    @PostMapping("/getUserList")
    @ApiOperation("获取用户列表接口")
    public String getUserList(HttpServletRequest request, @RequestBody User u) {
        if (!Objects.isNull(request.getCookies())) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("Login") && cookie.getValue().equals("True")) {
                    User user = new User();
                    user.setName("Lisi");
                    user.setAge("18");
                    user.setSex("man");
                    return user.toString();
                }
            }
        }
        return "用户身份校验失败，请重新登录!";
    }
}
