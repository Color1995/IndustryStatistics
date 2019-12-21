package cn.com.trueway.sys.service;

import java.util.Map;

public interface IMenuService {

    /**
     * 部门信息和用户信息在登录时
     * 已存储在session中。
     * @param userId
     * @param orgId
     * @return
     */
    public Map<String, Object> getMenusById(String userId, String orgId);


}
