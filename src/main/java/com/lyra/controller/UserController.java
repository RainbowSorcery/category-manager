package com.lyra.controller;


import com.lyra.common.Result;
import com.lyra.common.utils.RedisOperator;
import com.lyra.entity.User;
import com.lyra.entity.vo.LoginVo;
import com.lyra.service.IUserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lyra
 * @since 2021-11-16
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    @Autowired
    private RedisOperator redisOperator;



    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginVo) {
        User user = userService.findUserNameByUser(loginVo.getUsername());

        if (user == null) {
            return new Result<Object>(5000, false, "登录失败.");
        }


        if (BCrypt.checkpw(loginVo.getPassword(), user.getPassword())) {
            String token = UUID.randomUUID().toString();
            redisOperator.set(USER_TOKEN + ":" + user.getId(), token);
            return new Result(20000, true, "登录成功", token);
        }

        return new Result<Object>(5000, false, "登录失败.");

    }

    @GetMapping("/info")
    public Result userInfo() {
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("token", UUID.randomUUID().toString());
        tokenMap.put("roles", "admin");
        tokenMap.put("introduction", "My name is lyra heartstrings.");
        tokenMap.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        tokenMap.put("name", "Lyra Heartstrings.");

        return new Result(20000, true, "获取用户详情成功.", tokenMap);
    }

    @PostMapping("/logout")
    public Result logout(HttpServletResponse response) {
        this.deleteCookie(response, "Admin-Token");
        return new Result(20000, true, "退出成功.");
    }

    private void setCookie(HttpServletResponse response,
                           String name,
                           String value,
                           int maxAge) {
            Cookie cookie = new Cookie(name, value);
            cookie.setPath("/");
            cookie.setMaxAge(maxAge);
            response.addCookie(cookie);
    }

    private void deleteCookie(HttpServletResponse response,
                           String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
