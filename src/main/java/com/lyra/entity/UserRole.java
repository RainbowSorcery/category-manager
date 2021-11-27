package com.lyra.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lyra
 * @since 2021-11-16
 */
@TableName("user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer roleId;

    private Integer userId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
            "roleId=" + roleId +
            ", userId=" + userId +
        "}";
    }
}
