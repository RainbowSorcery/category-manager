package com.lyra.service.impl;

import com.lyra.entity.Role;
import com.lyra.mapper.RoleMapper;
import com.lyra.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lyra
 * @since 2021-11-16
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
