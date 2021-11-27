package com.lyra.service;

import com.lyra.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyra.entity.vo.LoginVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lyra
 * @since 2021-11-16
 */
public interface IUserService extends IService<User> {
    public User findUserNameByUser(String username);
}
