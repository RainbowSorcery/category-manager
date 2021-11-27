package com.lyra.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lyra
 * @since 2021-11-16
 */
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
            "id=" + id +
            ", roleName=" + roleName +
        "}";
    }
}
